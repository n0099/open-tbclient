package d.b.h0.a.i2;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Integer> f45418a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f45419b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<Integer> f45420c = new HashSet();

    static {
        f45418a.add(2);
        f45418a.add(3);
        f45418a.add(4);
        f45418a.add(5);
        f45418a.add(6);
        f45419b.add(7);
        f45419b.add(1);
        f45420c.addAll(f45418a);
        f45420c.addAll(f45419b);
    }

    public static Date a() {
        return new Date();
    }

    public static String b(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static Date c(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static Date d(String str, String[] strArr) {
        Date date = null;
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                try {
                    date = new SimpleDateFormat(str2).parse(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (date != null) {
                    break;
                }
            }
        }
        return date;
    }

    public static String e(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static String f(long j, String str) {
        try {
            return new SimpleDateFormat((str == null || str.isEmpty()) ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss").format(new Date(j));
        } catch (NumberFormatException e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
                return "";
            }
            return "";
        }
    }
}
