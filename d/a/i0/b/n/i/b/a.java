package d.a.i0.b.n.i.b;

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
import d.a.i0.a.a2.e;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46245a;

    /* renamed from: b  reason: collision with root package name */
    public C0949a f46246b;

    /* renamed from: c  reason: collision with root package name */
    public c f46247c;

    /* renamed from: d  reason: collision with root package name */
    public b f46248d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f46249e;

    /* renamed from: d.a.i0.b.n.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0949a {

        /* renamed from: a  reason: collision with root package name */
        public String f46250a;

        /* renamed from: b  reason: collision with root package name */
        public String f46251b;

        /* renamed from: c  reason: collision with root package name */
        public int f46252c;

        /* renamed from: d  reason: collision with root package name */
        public int f46253d;

        /* renamed from: e  reason: collision with root package name */
        public String f46254e;

        /* renamed from: f  reason: collision with root package name */
        public String f46255f;

        /* renamed from: g  reason: collision with root package name */
        public int f46256g;

        /* renamed from: h  reason: collision with root package name */
        public int f46257h;

        /* renamed from: i  reason: collision with root package name */
        public String f46258i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f46259a;

        /* renamed from: b  reason: collision with root package name */
        public int f46260b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f46261a;

        /* renamed from: b  reason: collision with root package name */
        public double f46262b;

        /* renamed from: c  reason: collision with root package name */
        public double f46263c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0949a c0949a = new C0949a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f46245a = TextUtils.isEmpty(V) ? "" : V;
        this.f46246b = c0949a;
        this.f46247c = cVar;
        this.f46248d = bVar;
        this.f46249e = jSONObject;
        String r = q0.r();
        c0949a.f46250a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0949a.f46251b = "0".equals(a2) ? "" : a2;
        c0949a.f46252c = 2;
        c0949a.f46253d = d.a.i0.b.n.i.c.a.e(context) ? 3 : 2;
        String i2 = d.a.i0.a.d0.c.i();
        c0949a.f46254e = "NUL".equals(i2) ? "" : i2;
        String g2 = d.a.i0.a.d0.c.g();
        c0949a.f46255f = "NUL".equals(g2) ? "" : g2;
        c0949a.f46256g = n0.n(context);
        c0949a.f46257h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0949a.f46258i = str;
        bVar.f46259a = d.a.i0.b.n.i.c.a.c();
        bVar.f46260b = d.a.i0.b.n.i.c.a.d(context);
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
            jSONObject.put(Constants.APP_ID, this.f46245a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f46246b.f46250a);
            jSONObject2.put("androidid", this.f46246b.f46251b);
            jSONObject2.put(SearchJsBridge.COOKIE_OS_TYPE, this.f46246b.f46252c);
            jSONObject2.put("device_type", this.f46246b.f46253d);
            jSONObject2.put("device_vendor", this.f46246b.f46254e);
            jSONObject2.put("device_model", this.f46246b.f46255f);
            jSONObject2.put("screen_height", this.f46246b.f46256g);
            jSONObject2.put("screen_width", this.f46246b.f46257h);
            jSONObject2.put(IAdRequestParam.MAC, this.f46246b.f46258i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f46247c.f46261a);
            jSONObject3.put("latitude", this.f46247c.f46262b);
            jSONObject3.put("longitude", this.f46247c.f46263c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f46248d.f46259a);
            jSONObject4.put("operator", this.f46248d.f46260b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f46249e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
