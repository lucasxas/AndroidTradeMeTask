package lucasxavier.trademetask.network;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class CurrencyJsonAdapter extends TypeAdapter<BigDecimal> {

    @Override
    public void write(JsonWriter out, BigDecimal value) throws IOException {
        String format = "$%.2f";
        out.value(String.format(format, value.floatValue()));
    }

    @Override
    public BigDecimal read(JsonReader in) throws IOException {
        String nextString = in.nextString();
        String currency = nextString.substring(1).split(" ")[0];
        String regularExpression = "^[0-9,\\.]+$";
        return currency.matches(regularExpression) ? new BigDecimal(currency) : BigDecimal.ZERO;
    }
}