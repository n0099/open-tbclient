package d.a.j0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import d.a.j0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40428g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40429h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f40430i;

        public a(int i2, int i3, int i4, Context context) {
            this.f40427f = i2;
            this.f40428g = i3;
            this.f40429h = i4;
            this.f40430i = context;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40427f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f40428g);
                jSONObject.put("3", this.f40429h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(this.f40430i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40431f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40432g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40433h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40434i;
        public final /* synthetic */ String j;

        public b(int i2, Context context, int i3, int i4, String str) {
            this.f40431f = i2;
            this.f40432g = context;
            this.f40433h = i3;
            this.f40434i = i4;
            this.j = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40431f);
                jSONObject.put("3", System.currentTimeMillis());
                int X = d.a.j0.b.a.g(this.f40432g).X();
                if (X != -1) {
                    jSONObject.put("4", X);
                }
                jSONObject.put("5", d.a.j0.b.a.g(this.f40432g).Y());
                jSONObject.put("7", this.f40433h);
                if (this.f40434i != -1) {
                    jSONObject.put("8", this.f40434i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.q);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                new d.a.j0.f.d(this.f40432g, null).g(jSONObject);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40436g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40437h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40438i;
        public final /* synthetic */ String j;

        public c(int i2, Context context, int i3, int i4, String str) {
            this.f40435f = i2;
            this.f40436g = context;
            this.f40437h = i3;
            this.f40438i = i4;
            this.j = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40435f);
                jSONObject.put("3", System.currentTimeMillis());
                int b0 = d.a.j0.b.a.g(this.f40436g).b0();
                if (b0 != -1) {
                    jSONObject.put("4", b0);
                }
                jSONObject.put("5", d.a.j0.b.a.g(this.f40436g).c0());
                jSONObject.put("7", this.f40437h);
                if (this.f40438i != -1) {
                    jSONObject.put("8", this.f40438i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.r);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                jSONArray.put(jSONObject);
                d.a.j0.h.b.c(this.f40436g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.j0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0554d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40440g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40441h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40442i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0554d(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f40439f = i2;
            this.f40440g = i3;
            this.f40441h = str;
            this.f40442i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f40442i);
                jSONObject.put("2", this.f40439f);
                if (this.f40440g != -1) {
                    jSONObject.put("3", this.f40440g);
                }
                if (!TextUtils.isEmpty(this.f40441h)) {
                    jSONObject.put("4", this.f40441h);
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
        public final /* synthetic */ int f40443f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40444g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40445h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40446i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f40443f = i2;
            this.f40444g = i3;
            this.f40445h = str;
            this.f40446i = i4;
            this.j = i5;
            this.k = context;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f40446i);
                jSONObject.put("2", this.f40443f);
                if (this.f40444g != -1) {
                    jSONObject.put("3", this.f40444g);
                }
                if (!TextUtils.isEmpty(this.f40445h)) {
                    jSONObject.put("4", this.f40445h);
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

    public static void a(Context context, int i2, int i3, int i4) {
        d.a.j0.k.e.c().b(new a(i2, i3, i4, context));
    }

    public static void b(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.j0.k.e.c().b(new C0554d(i4, i5, str, i2, i3, context));
    }

    public static void c(Context context, int i2, int i3, int i4, String str) {
        d.a.j0.k.e.c().b(new c(i2, context, i4, i3, str));
    }

    public static void d(Context context, int i2, int i3, int i4, int i5, String str) {
        d.a.j0.k.e.c().b(new e(i4, i5, str, i2, i3, context));
    }

    public static void e(Context context, int i2, int i3, int i4, String str) {
        d.a.j0.k.e.c().b(new b(i2, context, i4, i3, str));
    }
}
