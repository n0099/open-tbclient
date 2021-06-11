package d.a.j0.h;

import android.content.Context;
import android.text.TextUtils;
import d.a.j0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44107g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44108h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f44109i;

        public a(int i2, int i3, String str, Context context) {
            this.f44106f = i2;
            this.f44107g = i3;
            this.f44108h = str;
            this.f44109i = context;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44106f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f44107g);
                jSONObject.put("3", this.f44108h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(this.f44109i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44110f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44111g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44112h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44113i;
        public final /* synthetic */ String j;

        public b(int i2, Context context, int i3, int i4, String str) {
            this.f44110f = i2;
            this.f44111g = context;
            this.f44112h = i3;
            this.f44113i = i4;
            this.j = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44110f);
                jSONObject.put("3", System.currentTimeMillis());
                int Z = d.a.j0.b.a.h(this.f44111g).Z();
                if (Z != -1) {
                    jSONObject.put("4", Z);
                }
                jSONObject.put("5", d.a.j0.b.a.h(this.f44111g).a0());
                jSONObject.put("7", this.f44112h);
                if (this.f44113i != -1) {
                    jSONObject.put("8", this.f44113i);
                }
                jSONObject.put("9", this.j);
                jSONObject.put("10", 1);
                jSONObject.put("11", i.q);
                jSONObject.put("12", "1");
                new d.a.j0.f.d(this.f44111g, null).h(jSONObject);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44116h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44117i;
        public final /* synthetic */ String j;

        public c(int i2, Context context, int i3, int i4, String str) {
            this.f44114f = i2;
            this.f44115g = context;
            this.f44116h = i3;
            this.f44117i = i4;
            this.j = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44114f);
                jSONObject.put("3", System.currentTimeMillis());
                int d0 = d.a.j0.b.a.h(this.f44115g).d0();
                if (d0 != -1) {
                    jSONObject.put("4", d0);
                }
                jSONObject.put("5", d.a.j0.b.a.h(this.f44115g).e0());
                jSONObject.put("7", this.f44116h);
                if (this.f44117i != -1) {
                    jSONObject.put("8", this.f44117i);
                }
                jSONObject.put("9", this.j);
                jSONObject.put("10", 1);
                jSONObject.put("11", i.r);
                jSONObject.put("12", "1");
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(this.f44115g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.j0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0611d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44119g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44120h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44121i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0611d(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f44118f = i2;
            this.f44119g = i3;
            this.f44120h = str;
            this.f44121i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f44121i);
                jSONObject.put("2", this.f44118f);
                if (this.f44119g != -1) {
                    jSONObject.put("3", this.f44119g);
                }
                if (!TextUtils.isEmpty(this.f44120h)) {
                    jSONObject.put("4", this.f44120h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.q);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44122f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44123g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44124h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44125i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f44122f = i2;
            this.f44123g = i3;
            this.f44124h = str;
            this.f44125i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f44125i);
                jSONObject.put("2", this.f44122f);
                if (this.f44123g != -1) {
                    jSONObject.put("3", this.f44123g);
                }
                if (!TextUtils.isEmpty(this.f44124h)) {
                    jSONObject.put("4", this.f44124h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.r);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.j0.k.e.c().b(new C0611d(i4, i5, str, i2, i3, context));
    }

    public static void b(Context context, int i2, int i3, int i4, String str) {
        d.a.j0.k.e.c().b(new c(i2, context, i4, i3, str));
    }

    public static void c(Context context, int i2, int i3, String str) {
        d.a.j0.k.e.c().b(new a(i2, i3, str, context));
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.j0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        d.a.j0.k.e.c().b(new b(i2, context, i4, i3, str));
    }
}
