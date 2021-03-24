package d.b.f0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import d.b.f0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42980g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42981h;
        public final /* synthetic */ Context i;

        public a(int i, int i2, int i3, Context context) {
            this.f42979f = i;
            this.f42980g = i2;
            this.f42981h = i3;
            this.i = context;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f42979f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f42980g);
                jSONObject.put("3", this.f42981h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.b.f0.h.b.c(this.i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42982f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f42983g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42984h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;

        public b(int i, Context context, int i2, int i3, String str) {
            this.f42982f = i;
            this.f42983g = context;
            this.f42984h = i2;
            this.i = i3;
            this.j = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f42982f);
                jSONObject.put("3", System.currentTimeMillis());
                int X = d.b.f0.b.a.g(this.f42983g).X();
                if (X != -1) {
                    jSONObject.put("4", X);
                }
                jSONObject.put("5", d.b.f0.b.a.g(this.f42983g).Y());
                jSONObject.put("7", this.f42984h);
                if (this.i != -1) {
                    jSONObject.put("8", this.i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.q);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                new d.b.f0.f.d(this.f42983g, null).g(jSONObject);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42985f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f42986g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42987h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;

        public c(int i, Context context, int i2, int i3, String str) {
            this.f42985f = i;
            this.f42986g = context;
            this.f42987h = i2;
            this.i = i3;
            this.j = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f42985f);
                jSONObject.put("3", System.currentTimeMillis());
                int b0 = d.b.f0.b.a.g(this.f42986g).b0();
                if (b0 != -1) {
                    jSONObject.put("4", b0);
                }
                jSONObject.put("5", d.b.f0.b.a.g(this.f42986g).c0());
                jSONObject.put("7", this.f42987h);
                if (this.i != -1) {
                    jSONObject.put("8", this.i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.r);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                jSONArray.put(jSONObject);
                d.b.f0.h.b.c(this.f42986g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.b.f0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0583d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42989g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42990h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0583d(int i, int i2, String str, int i3, int i4, Context context) {
            this.f42988f = i;
            this.f42989g = i2;
            this.f42990h = str;
            this.i = i3;
            this.j = i4;
            this.k = context;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.i);
                jSONObject.put("2", this.f42988f);
                if (this.f42989g != -1) {
                    jSONObject.put("3", this.f42989g);
                }
                if (!TextUtils.isEmpty(this.f42990h)) {
                    jSONObject.put("4", this.f42990h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.q);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.b.f0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42993h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i, int i2, String str, int i3, int i4, Context context) {
            this.f42991f = i;
            this.f42992g = i2;
            this.f42993h = str;
            this.i = i3;
            this.j = i4;
            this.k = context;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.i);
                jSONObject.put("2", this.f42991f);
                if (this.f42992g != -1) {
                    jSONObject.put("3", this.f42992g);
                }
                if (!TextUtils.isEmpty(this.f42993h)) {
                    jSONObject.put("4", this.f42993h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.r);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.b.f0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    public static void a(Context context, int i, int i2, int i3) {
        d.b.f0.k.e.c().b(new a(i, i2, i3, context));
    }

    public static void b(Context context, int i, int i2, int i3, int i4, String str) {
        d.b.f0.k.e.c().b(new C0583d(i3, i4, str, i, i2, context));
    }

    public static void c(Context context, int i, int i2, int i3, String str) {
        d.b.f0.k.e.c().b(new c(i, context, i3, i2, str));
    }

    public static void d(Context context, int i, int i2, int i3, int i4, String str) {
        d.b.f0.k.e.c().b(new e(i3, i4, str, i, i2, context));
    }

    public static void e(Context context, int i, int i2, int i3, String str) {
        d.b.f0.k.e.c().b(new b(i, context, i3, i2, str));
    }
}
