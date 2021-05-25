package d.r.b.a.a.f.f;

import java.util.Random;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f67747b;

    /* renamed from: a  reason: collision with root package name */
    public Random f67748a = new Random();

    /* renamed from: d.r.b.a.a.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1901a {

        /* renamed from: a  reason: collision with root package name */
        public static Float f67749a = Float.valueOf(1.0f);

        /* renamed from: b  reason: collision with root package name */
        public static String f67750b = "";
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static String f67751a = "revenuepay";

        /* renamed from: b  reason: collision with root package name */
        public static int f67752b = 50319;

        /* renamed from: c  reason: collision with root package name */
        public static int f67753c = 50321;
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static String p = "";
        public static int q = 0;
        public static String r = "";
        public static String s = "";
        public static String t = "";

        /* renamed from: a  reason: collision with root package name */
        public String f67754a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f67755b = "0";

        /* renamed from: c  reason: collision with root package name */
        public String f67756c = "";

        /* renamed from: d  reason: collision with root package name */
        public long f67757d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f67758e = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f67759f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f67760g = "0";

        /* renamed from: h  reason: collision with root package name */
        public String f67761h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f67762i = "";
        public String j = "0";
        public String k = "";
        public String l = "";
        public String m = "";
        public String n = "";
        public String o = "";
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f67747b == null) {
                f67747b = new a();
            }
            aVar = f67747b;
        }
        return aVar;
    }

    public String b(String str, c cVar) {
        return C1901a.f67750b + "/" + str;
    }

    public String c(String str, c cVar) {
        return C1901a.f67750b + "/" + str;
    }

    public boolean d() {
        if (C1901a.f67749a.floatValue() <= 0.0f) {
            return false;
        }
        if (C1901a.f67749a.floatValue() >= 1.0f) {
            return true;
        }
        int floatValue = (int) (C1901a.f67749a.floatValue() * 100.0f);
        int nextInt = this.f67748a.nextInt(100);
        return nextInt >= 0 && nextInt < floatValue;
    }
}
