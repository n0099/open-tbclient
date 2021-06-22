package d.a.m0.a.v2;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Integer> f49201a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f49202b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<Integer> f49203c = new HashSet();

    static {
        f49201a.add(2);
        f49201a.add(3);
        f49201a.add(4);
        f49201a.add(5);
        f49201a.add(6);
        f49202b.add(7);
        f49202b.add(1);
        f49203c.addAll(f49201a);
        f49203c.addAll(f49202b);
    }

    public static Date a() {
        return new Date();
    }

    public static String b(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str, Locale.getDefault()).format(date);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
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
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
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
                    date = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
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
            return new SimpleDateFormat(str, Locale.getDefault()).format(date);
        } catch (Exception unused) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static boolean f(Long l, Long l2) {
        return l.longValue() / 86400000 == l2.longValue() / 86400000;
    }

    public static String g(long j, String str) {
        try {
            return new SimpleDateFormat((str == null || str.isEmpty()) ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (NumberFormatException e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
                return "";
            }
            return "";
        }
    }
}
