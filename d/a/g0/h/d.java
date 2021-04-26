package d.a.g0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import d.a.g0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40922g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40923h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f40924i;

        public a(int i2, int i3, int i4, Context context) {
            this.f40921f = i2;
            this.f40922g = i3;
            this.f40923h = i4;
            this.f40924i = context;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40921f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f40922g);
                jSONObject.put("3", this.f40923h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.a.g0.h.b.c(this.f40924i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40925f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40926g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40927h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40928i;
        public final /* synthetic */ String j;

        public b(int i2, Context context, int i3, int i4, String str) {
            this.f40925f = i2;
            this.f40926g = context;
            this.f40927h = i3;
            this.f40928i = i4;
            this.j = str;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40925f);
                jSONObject.put("3", System.currentTimeMillis());
                int X = d.a.g0.b.a.g(this.f40926g).X();
                if (X != -1) {
                    jSONObject.put("4", X);
                }
                jSONObject.put("5", d.a.g0.b.a.g(this.f40926g).Y());
                jSONObject.put("7", this.f40927h);
                if (this.f40928i != -1) {
                    jSONObject.put("8", this.f40928i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.q);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                new d.a.g0.f.d(this.f40926g, null).g(jSONObject);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40929f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40930g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40931h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40932i;
        public final /* synthetic */ String j;

        public c(int i2, Context context, int i3, int i4, String str) {
            this.f40929f = i2;
            this.f40930g = context;
            this.f40931h = i3;
            this.f40932i = i4;
            this.j = str;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40929f);
                jSONObject.put("3", System.currentTimeMillis());
                int b0 = d.a.g0.b.a.g(this.f40930g).b0();
                if (b0 != -1) {
                    jSONObject.put("4", b0);
                }
                jSONObject.put("5", d.a.g0.b.a.g(this.f40930g).c0());
                jSONObject.put("7", this.f40931h);
                if (this.f40932i != -1) {
                    jSONObject.put("8", this.f40932i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.r);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                jSONArray.put(jSONObject);
                d.a.g0.h.b.c(this.f40930g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.g0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0554d extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40933f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40934g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40935h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40936i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0554d(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f40933f = i2;
            this.f40934g = i3;
            this.f40935h = str;
            this.f40936i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f40936i);
                jSONObject.put("2", this.f40933f);
                if (this.f40934g != -1) {
                    jSONObject.put("3", this.f40934g);
                }
                if (!TextUtils.isEmpty(this.f40935h)) {
                    jSONObject.put("4", this.f40935h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.q);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.a.g0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40937f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40938g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40939h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40940i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f40937f = i2;
            this.f40938g = i3;
            this.f40939h = str;
            this.f40940i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f40940i);
                jSONObject.put("2", this.f40937f);
                if (this.f40938g != -1) {
                    jSONObject.put("3", this.f40938g);
                }
                if (!TextUtils.isEmpty(this.f40939h)) {
                    jSONObject.put("4", this.f40939h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.r);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.a.g0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4) {
        d.a.g0.k.e.c().b(new a(i2, i3, i4, context));
    }

    public static void b(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.g0.k.e.c().b(new C0554d(i4, i5, str, i2, i3, context));
    }

    public static void c(Context context, int i2, int i3, int i4, String str) {
        d.a.g0.k.e.c().b(new c(i2, context, i4, i3, str));
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.g0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        d.a.g0.k.e.c().b(new b(i2, context, i4, i3, str));
    }
}
