package d.r.b.a.a.f.f;

import java.util.Random;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f67018b;

    /* renamed from: a  reason: collision with root package name */
    public Random f67019a = new Random();

    /* renamed from: d.r.b.a.a.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1833a {

        /* renamed from: a  reason: collision with root package name */
        public static Float f67020a = Float.valueOf(1.0f);

        /* renamed from: b  reason: collision with root package name */
        public static String f67021b = "";
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static String f67022a = "revenuepay";

        /* renamed from: b  reason: collision with root package name */
        public static int f67023b = 50319;

        /* renamed from: c  reason: collision with root package name */
        public static int f67024c = 50321;
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static String p = "";
        public static int q = 0;
        public static String r = "";
        public static String s = "";
        public static String t = "";

        /* renamed from: a  reason: collision with root package name */
        public String f67025a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f67026b = "0";

        /* renamed from: c  reason: collision with root package name */
        public String f67027c = "";

        /* renamed from: d  reason: collision with root package name */
        public long f67028d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f67029e = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f67030f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f67031g = "0";

        /* renamed from: h  reason: collision with root package name */
        public String f67032h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f67033i = "";
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
            if (f67018b == null) {
                f67018b = new a();
            }
            aVar = f67018b;
        }
        return aVar;
    }

    public String b(String str, c cVar) {
        return C1833a.f67021b + "/" + str;
    }

    public String c(String str, c cVar) {
        return C1833a.f67021b + "/" + str;
    }

    public boolean d() {
        if (C1833a.f67020a.floatValue() <= 0.0f) {
            return false;
        }
        if (C1833a.f67020a.floatValue() >= 1.0f) {
            return true;
        }
        int floatValue = (int) (C1833a.f67020a.floatValue() * 100.0f);
        int nextInt = this.f67019a.nextInt(100);
        return nextInt >= 0 && nextInt < floatValue;
    }
}
