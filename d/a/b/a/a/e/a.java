package d.a.b.a.a.e;

import java.util.Calendar;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    public static long a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                if (str.length() == 6) {
                    if (str == null || str.length() == 0 || str.length() != 6) {
                        throw new IllegalArgumentException("fluteDateString should not be null or empty ");
                    }
                    if (Pattern.compile("[0-9]*").matcher(str).matches()) {
                        String str2 = "202" + str.substring(0, 1);
                        String substring = str.substring(1, 4);
                        String substring2 = str.substring(4, 6);
                        Calendar calendar = Calendar.getInstance();
                        calendar.clear();
                        calendar.set(1, Integer.valueOf(str2).intValue());
                        calendar.set(6, Integer.valueOf(substring).intValue());
                        calendar.set(11, Integer.valueOf(substring2).intValue());
                        return calendar.getTimeInMillis();
                    }
                    throw new IllegalArgumentException("fluteDateString should be all number");
                }
                throw new IllegalArgumentException("fluteDateString length should be 6 ");
            }
            throw new IllegalArgumentException("fluteDateString should not be empty ");
        }
        throw new IllegalArgumentException("fluteDateString should not be null ");
    }

    public static String b(long j) {
        String valueOf = String.valueOf(j);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 6 - valueOf.length(); i2++) {
            stringBuffer.append(0);
        }
        stringBuffer.append(valueOf);
        return stringBuffer.toString();
    }
}
