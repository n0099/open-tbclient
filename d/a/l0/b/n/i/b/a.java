package d.a.l0.b.n.i.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.xiaomi.mipush.sdk.Constants;
import d.a.l0.a.a2.e;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46421a;

    /* renamed from: b  reason: collision with root package name */
    public C0960a f46422b;

    /* renamed from: c  reason: collision with root package name */
    public c f46423c;

    /* renamed from: d  reason: collision with root package name */
    public b f46424d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f46425e;

    /* renamed from: d.a.l0.b.n.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0960a {

        /* renamed from: a  reason: collision with root package name */
        public String f46426a;

        /* renamed from: b  reason: collision with root package name */
        public String f46427b;

        /* renamed from: c  reason: collision with root package name */
        public int f46428c;

        /* renamed from: d  reason: collision with root package name */
        public int f46429d;

        /* renamed from: e  reason: collision with root package name */
        public String f46430e;

        /* renamed from: f  reason: collision with root package name */
        public String f46431f;

        /* renamed from: g  reason: collision with root package name */
        public int f46432g;

        /* renamed from: h  reason: collision with root package name */
        public int f46433h;

        /* renamed from: i  reason: collision with root package name */
        public String f46434i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f46435a;

        /* renamed from: b  reason: collision with root package name */
        public int f46436b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f46437a;

        /* renamed from: b  reason: collision with root package name */
        public double f46438b;

        /* renamed from: c  reason: collision with root package name */
        public double f46439c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0960a c0960a = new C0960a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f46421a = TextUtils.isEmpty(V) ? "" : V;
        this.f46422b = c0960a;
        this.f46423c = cVar;
        this.f46424d = bVar;
        this.f46425e = jSONObject;
        String r = q0.r();
        c0960a.f46426a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0960a.f46427b = "0".equals(a2) ? "" : a2;
        c0960a.f46428c = 2;
        c0960a.f46429d = d.a.l0.b.n.i.c.a.e(context) ? 3 : 2;
        String i2 = d.a.l0.a.d0.c.i();
        c0960a.f46430e = "NUL".equals(i2) ? "" : i2;
        String g2 = d.a.l0.a.d0.c.g();
        c0960a.f46431f = "NUL".equals(g2) ? "" : g2;
        c0960a.f46432g = n0.n(context);
        c0960a.f46433h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0960a.f46434i = str;
        bVar.f46435a = d.a.l0.b.n.i.c.a.c();
        bVar.f46436b = d.a.l0.b.n.i.c.a.d(context);
    }

    public String a() {
        String string = Settings.Secure.getString(AppRuntime.getAppContext().getContentResolver(), IAdRequestParam.ANDROID_ID);
        return TextUtils.isEmpty(string) ? "0" : string;
    }

    public String b() {
        String str;
        try {
            str = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @NonNull
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Constants.APP_ID, this.f46421a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f46422b.f46426a);
            jSONObject2.put("androidid", this.f46422b.f46427b);
            jSONObject2.put(SearchJsBridge.COOKIE_OS_TYPE, this.f46422b.f46428c);
            jSONObject2.put("device_type", this.f46422b.f46429d);
            jSONObject2.put("device_vendor", this.f46422b.f46430e);
            jSONObject2.put("device_model", this.f46422b.f46431f);
            jSONObject2.put("screen_height", this.f46422b.f46432g);
            jSONObject2.put("screen_width", this.f46422b.f46433h);
            jSONObject2.put(IAdRequestParam.MAC, this.f46422b.f46434i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f46423c.f46437a);
            jSONObject3.put("latitude", this.f46423c.f46438b);
            jSONObject3.put("longitude", this.f46423c.f46439c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f46424d.f46435a);
            jSONObject4.put("operator", this.f46424d.f46436b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f46425e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
