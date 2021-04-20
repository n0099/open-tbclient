package d.b.f0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import d.b.f0.e.i;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43372f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43373g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43374h;
        public final /* synthetic */ Context i;

        public a(int i, int i2, int i3, Context context) {
            this.f43372f = i;
            this.f43373g = i2;
            this.f43374h = i3;
            this.i = context;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43372f);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f43373g);
                jSONObject.put("3", this.f43374h);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                d.b.f0.h.b.c(this.i).f(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43375f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43376g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43377h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;

        public b(int i, Context context, int i2, int i3, String str) {
            this.f43375f = i;
            this.f43376g = context;
            this.f43377h = i2;
            this.i = i3;
            this.j = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43375f);
                jSONObject.put("3", System.currentTimeMillis());
                int X = d.b.f0.b.a.g(this.f43376g).X();
                if (X != -1) {
                    jSONObject.put("4", X);
                }
                jSONObject.put("5", d.b.f0.b.a.g(this.f43376g).Y());
                jSONObject.put("7", this.f43377h);
                if (this.i != -1) {
                    jSONObject.put("8", this.i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.q);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                new d.b.f0.f.d(this.f43376g, null).g(jSONObject);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43378f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43379g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43380h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;

        public c(int i, Context context, int i2, int i3, String str) {
            this.f43378f = i;
            this.f43379g = context;
            this.f43380h = i2;
            this.i = i3;
            this.j = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43378f);
                jSONObject.put("3", System.currentTimeMillis());
                int b0 = d.b.f0.b.a.g(this.f43379g).b0();
                if (b0 != -1) {
                    jSONObject.put("4", b0);
                }
                jSONObject.put("5", d.b.f0.b.a.g(this.f43379g).c0());
                jSONObject.put("7", this.f43380h);
                if (this.i != -1) {
                    jSONObject.put("8", this.i);
                }
                jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, this.j);
                jSONObject.put("10", 1);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, i.r);
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "1");
                jSONArray.put(jSONObject);
                d.b.f0.h.b.c(this.f43379g).f(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.b.f0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0596d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43381f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43382g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43383h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public C0596d(int i, int i2, String str, int i3, int i4, Context context) {
            this.f43381f = i;
            this.f43382g = i2;
            this.f43383h = str;
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
                jSONObject.put("2", this.f43381f);
                if (this.f43382g != -1) {
                    jSONObject.put("3", this.f43382g);
                }
                if (!TextUtils.isEmpty(this.f43383h)) {
                    jSONObject.put("4", this.f43383h);
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

    /* loaded from: classes2.dex */
    public static class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43385g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43386h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ Context k;

        public e(int i, int i2, String str, int i3, int i4, Context context) {
            this.f43384f = i;
            this.f43385g = i2;
            this.f43386h = str;
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
                jSONObject.put("2", this.f43384f);
                if (this.f43385g != -1) {
                    jSONObject.put("3", this.f43385g);
                }
                if (!TextUtils.isEmpty(this.f43386h)) {
                    jSONObject.put("4", this.f43386h);
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
        d.b.f0.k.e.c().b(new C0596d(i3, i4, str, i, i2, context));
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
