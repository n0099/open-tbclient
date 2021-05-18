package d.r.b.a.a.f.f;

import java.util.Random;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f67704b;

    /* renamed from: a  reason: collision with root package name */
    public Random f67705a = new Random();

    /* renamed from: d.r.b.a.a.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1897a {

        /* renamed from: a  reason: collision with root package name */
        public static Float f67706a = Float.valueOf(1.0f);

        /* renamed from: b  reason: collision with root package name */
        public static String f67707b = "";
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static String f67708a = "revenuepay";

        /* renamed from: b  reason: collision with root package name */
        public static int f67709b = 50319;

        /* renamed from: c  reason: collision with root package name */
        public static int f67710c = 50321;
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static String p = "";
        public static int q = 0;
        public static String r = "";
        public static String s = "";
        public static String t = "";

        /* renamed from: a  reason: collision with root package name */
        public String f67711a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f67712b = "0";

        /* renamed from: c  reason: collision with root package name */
        public String f67713c = "";

        /* renamed from: d  reason: collision with root package name */
        public long f67714d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f67715e = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f67716f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f67717g = "0";

        /* renamed from: h  reason: collision with root package name */
        public String f67718h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f67719i = "";
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
            if (f67704b == null) {
                f67704b = new a();
            }
            aVar = f67704b;
        }
        return aVar;
    }

    public String b(String str, c cVar) {
        return C1897a.f67707b + "/" + str;
    }

    public String c(String str, c cVar) {
        return C1897a.f67707b + "/" + str;
    }

    public boolean d() {
        if (C1897a.f67706a.floatValue() <= 0.0f) {
            return false;
        }
        if (C1897a.f67706a.floatValue() >= 1.0f) {
            return true;
        }
        int floatValue = (int) (C1897a.f67706a.floatValue() * 100.0f);
        int nextInt = this.f67705a.nextInt(100);
        return nextInt >= 0 && nextInt < floatValue;
    }
}
