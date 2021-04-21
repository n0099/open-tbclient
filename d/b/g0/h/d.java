package d.b.g0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import d.b.g0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43669f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43670g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43671h;
        public final /* synthetic */ Context i;

        public a(int i, int i2, int i3, Context context) {
            this.f43669f = i;
            this.f43670g = i2;
            this.f43671h = i3;
            this.i = context;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43669f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f43670g);
                jSONObject.put("3", this.f43671h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.b.g0.h.b.c(this.i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43672f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43673g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43674h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;

        public b(int i, Context context, int i2, int i3, String str) {
            this.f43672f = i;
            this.f43673g = context;
            this.f43674h = i2;
            this.i = i3;
            this.j = str;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43672f);
                jSONObject.put("3", System.currentTimeMillis());
                int X = d.b.g0.b.a.g(this.f43673g).X();
                if (X != -1) {
                    jSONObject.put("4", X);
                }
                jSONObject.put("5", d.b.g0.b.a.g(this.f43673g).Y());
                jSONObject.put("7", this.f43674h);
                if (this.i != -1) {
                    jSONObject.put("8", this.i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.q);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                new d.b.g0.f.d(this.f43673g, null).g(jSONObject);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43675f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43676g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43677h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;

        public c(int i, Context context, int i2, int i3, String str) {
            this.f43675f = i;
            this.f43676g = context;
            this.f43677h = i2;
            this.i = i3;
            this.j = str;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43675f);
                jSONObject.put("3", System.currentTimeMillis());
                int b0 = d.b.g0.b.a.g(this.f43676g).b0();
                if (b0 != -1) {
                    jSONObject.put("4", b0);
                }
                jSONObject.put("5", d.b.g0.b.a.g(this.f43676g).c0());
                jSONObject.put("7", this.f43677h);
                if (this.i != -1) {
                    jSONObject.put("8", this.i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.r);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                jSONArray.put(jSONObject);
                d.b.g0.h.b.c(this.f43676g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.b.g0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0615d extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43678f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43679g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43680h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0615d(int i, int i2, String str, int i3, int i4, Context context) {
            this.f43678f = i;
            this.f43679g = i2;
            this.f43680h = str;
            this.i = i3;
            this.j = i4;
            this.k = context;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.i);
                jSONObject.put("2", this.f43678f);
                if (this.f43679g != -1) {
                    jSONObject.put("3", this.f43679g);
                }
                if (!TextUtils.isEmpty(this.f43680h)) {
                    jSONObject.put("4", this.f43680h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.q);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.b.g0.h.b.c(this.k).f(jSONArray.toString(), "1077105", 2);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43681f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43682g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43683h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i, int i2, String str, int i3, int i4, Context context) {
            this.f43681f = i;
            this.f43682g = i2;
            this.f43683h = str;
            this.i = i3;
            this.j = i4;
            this.k = context;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.i);
                jSONObject.put("2", this.f43681f);
                if (this.f43682g != -1) {
                    jSONObject.put("3", this.f43682g);
                }
                if (!TextUtils.isEmpty(this.f43683h)) {
                    jSONObject.put("4", this.f43683h);
                }
                jSONObject.put("5", 1);
                jSONObject.put("6", i.r);
                jSONObject.put("7", this.j);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                d.b.g0.h.b.c(this.k).f(jSONArray.toString(), "1077123", 2);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    public static void a(Context context, int i, int i2, int i3) {
        d.b.g0.k.e.c().b(new a(i, i2, i3, context));
    }

    public static void b(Context context, int i, int i2, int i3, int i4, String str) {
        d.b.g0.k.e.c().b(new C0615d(i3, i4, str, i, i2, context));
    }

    public static void c(Context context, int i, int i2, int i3, String str) {
        d.b.g0.k.e.c().b(new c(i, context, i3, i2, str));
    }

    public static void d(Context context, int i, int i2, int i3, int i4, String str) {
        d.b.g0.k.e.c().b(new e(i3, i4, str, i, i2, context));
    }

    public static void e(Context context, int i, int i2, int i3, String str) {
        d.b.g0.k.e.c().b(new b(i, context, i3, i2, str));
    }
}
