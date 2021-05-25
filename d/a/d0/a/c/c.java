package d.a.d0.a.c;

import java.util.Calendar;
/* loaded from: classes2.dex */
public class c {
    public static boolean a(Long l, Long l2) {
        if (l == null || l2 == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2.longValue());
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }
}
