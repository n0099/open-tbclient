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
        public final /* synthetic */ int f40166f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40167g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40168h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f40169i;

        public a(int i2, int i3, int i4, Context context) {
            this.f40166f = i2;
            this.f40167g = i3;
            this.f40168h = i4;
            this.f40169i = context;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40166f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f40167g);
                jSONObject.put("3", this.f40168h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.a.g0.h.b.c(this.f40169i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40170f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40171g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40172h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40173i;
        public final /* synthetic */ String j;

        public b(int i2, Context context, int i3, int i4, String str) {
            this.f40170f = i2;
            this.f40171g = context;
            this.f40172h = i3;
            this.f40173i = i4;
            this.j = str;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40170f);
                jSONObject.put("3", System.currentTimeMillis());
                int X = d.a.g0.b.a.g(this.f40171g).X();
                if (X != -1) {
                    jSONObject.put("4", X);
                }
                jSONObject.put("5", d.a.g0.b.a.g(this.f40171g).Y());
                jSONObject.put("7", this.f40172h);
                if (this.f40173i != -1) {
                    jSONObject.put("8", this.f40173i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.q);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                new d.a.g0.f.d(this.f40171g, null).g(jSONObject);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40175g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40176h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40177i;
        public final /* synthetic */ String j;

        public c(int i2, Context context, int i3, int i4, String str) {
            this.f40174f = i2;
            this.f40175g = context;
            this.f40176h = i3;
            this.f40177i = i4;
            this.j = str;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40174f);
                jSONObject.put("3", System.currentTimeMillis());
                int b0 = d.a.g0.b.a.g(this.f40175g).b0();
                if (b0 != -1) {
                    jSONObject.put("4", b0);
                }
                jSONObject.put("5", d.a.g0.b.a.g(this.f40175g).c0());
                jSONObject.put("7", this.f40176h);
                if (this.f40177i != -1) {
                    jSONObject.put("8", this.f40177i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.r);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                jSONArray.put(jSONObject);
                d.a.g0.h.b.c(this.f40175g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.g0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0541d extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40178f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40179g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40180h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40181i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0541d(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f40178f = i2;
            this.f40179g = i3;
            this.f40180h = str;
            this.f40181i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f40181i);
                jSONObject.put("2", this.f40178f);
                if (this.f40179g != -1) {
                    jSONObject.put("3", this.f40179g);
                }
                if (!TextUtils.isEmpty(this.f40180h)) {
                    jSONObject.put("4", this.f40180h);
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
        public final /* synthetic */ int f40182f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40183g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40184h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40185i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f40182f = i2;
            this.f40183g = i3;
            this.f40184h = str;
            this.f40185i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f40185i);
                jSONObject.put("2", this.f40182f);
                if (this.f40183g != -1) {
                    jSONObject.put("3", this.f40183g);
                }
                if (!TextUtils.isEmpty(this.f40184h)) {
                    jSONObject.put("4", this.f40184h);
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
        d.a.g0.k.e.c().b(new C0541d(i4, i5, str, i2, i3, context));
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
