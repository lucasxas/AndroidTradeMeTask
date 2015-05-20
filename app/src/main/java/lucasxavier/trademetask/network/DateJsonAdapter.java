package lucasxavier.trademetask.network;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateJsonAdapter extends TypeAdapter<Date> {

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        String format = "/Date(%d)/";
        out.value(String.format(format, value.getTime()));
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        String nextString = in.nextString();
        String time = nextString.substring(6, nextString.length()-2);
        return new Date(Long.parseLong(time));
    }
}