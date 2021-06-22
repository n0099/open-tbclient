package d.a.k0.h;

import android.content.Context;
import android.text.TextUtils;
import d.a.k0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44246f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44247g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44248h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f44249i;

        public a(int i2, int i3, String str, Context context) {
            this.f44246f = i2;
            this.f44247g = i3;
            this.f44248h = str;
            this.f44249i = context;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44246f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f44247g);
                jSONObject.put("3", this.f44248h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.a.k0.h.b.c(this.f44249i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44250f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44251g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44252h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44253i;
        public final /* synthetic */ String j;

        public b(int i2, Context context, int i3, int i4, String str) {
            this.f44250f = i2;
            this.f44251g = context;
            this.f44252h = i3;
            this.f44253i = i4;
            this.j = str;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44250f);
                jSONObject.put("3", System.currentTimeMillis());
                int Z = d.a.k0.b.a.h(this.f44251g).Z();
                if (Z != -1) {
                    jSONObject.put("4", Z);
                }
                jSONObject.put("5", d.a.k0.b.a.h(this.f44251g).a0());
                jSONObject.put("7", this.f44252h);
                if (this.f44253i != -1) {
                    jSONObject.put("8", this.f44253i);
                }
                jSONObject.put("9", this.j);
                jSONObject.put("10", 1);
                jSONObject.put("11", i.q);
                jSONObject.put("12", "1");
                new d.a.k0.f.d(this.f44251g, null).h(jSONObject);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44254f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44255g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44256h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44257i;
        public final /* synthetic */ String j;

        public c(int i2, Context context, int i3, int i4, String str) {
            this.f44254f = i2;
            this.f44255g = context;
            this.f44256h = i3;
            this.f44257i = i4;
            this.j = str;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44254f);
                jSONObject.put("3", System.currentTimeMillis());
                int d0 = d.a.k0.b.a.h(this.f44255g).d0();
                if (d0 != -1) {
                    jSONObject.put("4", d0);
                }
                jSONObject.put("5", d.a.k0.b.a.h(this.f44255g).e0());
                jSONObject.put("7", this.f44256h);
                if (this.f44257i != -1) {
                    jSONObject.put("8", this.f44257i);
                }
                jSONObject.put("9", this.j);
                jSONObject.put("10", 1);
                jSONObject.put("11", i.r);
                jSONObject.put("12", "1");
                jSONArray.put(jSONObject);
                d.a.k0.h.b.c(this.f44255g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.k0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0615d extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44258f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44259g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44260h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44261i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0615d(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f44258f = i2;
            this.f44259g = i3;
            this.f44260h = str;
            this.f44261i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f44261i);
                jSONObject.put("2", this.f44258f);
                if (this.f44259g != -1) {
                    jSONObject.put("3", this.f44259g);
                }
                if (!TextUtils.isEmpty(this.f44260h)) {
                    jSONObject.put("4", this.f44260h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.q);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.a.k0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44262f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44263g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44264h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44265i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f44262f = i2;
            this.f44263g = i3;
            this.f44264h = str;
            this.f44265i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f44265i);
                jSONObject.put("2", this.f44262f);
                if (this.f44263g != -1) {
                    jSONObject.put("3", this.f44263g);
                }
                if (!TextUtils.isEmpty(this.f44264h)) {
                    jSONObject.put("4", this.f44264h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.r);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.a.k0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.k0.k.e.c().b(new C0615d(i4, i5, str, i2, i3, context));
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        d.a.k0.k.e.c().b(new c(i2, context, i4, i3, str));
    }

    public static void c(Context context, int i2, int i3, String str) {
        d.a.k0.k.e.c().b(new a(i2, i3, str, context));
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.k0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        d.a.k0.k.e.c().b(new b(i2, context, i4, i3, str));
    }
}
