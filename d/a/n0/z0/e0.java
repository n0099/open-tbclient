package d.a.n0.z0;

import android.net.Uri;
import com.baidu.tbadk.core.util.TimeHelper;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f54803a = Pattern.compile("http[s]?://tieba\\.baidu\\.com/f(.*)&jump_tieba_native=1(.*)");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f54804b = Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1");

    public static boolean a() {
        if (d.a.n0.b.d.H()) {
            Date date = new Date(d.a.n0.r.d0.b.j().l("show_login_dialog_strategy_key", 0L));
            long currentTimeMillis = System.currentTimeMillis();
            Date date2 = new Date(currentTimeMillis);
            d.a.n0.r.d0.b.j().w("show_login_dialog_strategy_key", currentTimeMillis);
            return !TimeHelper.isSameDay(date, date2);
        }
        return false;
    }

    public static boolean b(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return false;
        }
        return f54803a.matcher(str.toLowerCase()).find();
    }

    public static boolean c(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return false;
        }
        return f54804b.matcher(str.toLowerCase()).find();
    }

    public static boolean d(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return false;
        }
        return "person".equalsIgnoreCase(Uri.parse(str).getAuthority());
    }

    public static boolean e(String str) {
        return b(str) || c(str) || d(str);
    }
}
