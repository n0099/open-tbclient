package d.a.h0.a.i2;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Integer> f42736a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f42737b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static final Set<Integer> f42738c = new HashSet();

    static {
        f42736a.add(2);
        f42736a.add(3);
        f42736a.add(4);
        f42736a.add(5);
        f42736a.add(6);
        f42737b.add(7);
        f42737b.add(1);
        f42738c.addAll(f42736a);
        f42738c.addAll(f42737b);
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
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
                return "";
            }
            return "";
        }
    }
}
