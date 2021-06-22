package d.a.m0.b.n.i.b;

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
import d.a.m0.a.a2.e;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f50203a;

    /* renamed from: b  reason: collision with root package name */
    public C1019a f50204b;

    /* renamed from: c  reason: collision with root package name */
    public c f50205c;

    /* renamed from: d  reason: collision with root package name */
    public b f50206d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f50207e;

    /* renamed from: d.a.m0.b.n.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1019a {

        /* renamed from: a  reason: collision with root package name */
        public String f50208a;

        /* renamed from: b  reason: collision with root package name */
        public String f50209b;

        /* renamed from: c  reason: collision with root package name */
        public int f50210c;

        /* renamed from: d  reason: collision with root package name */
        public int f50211d;

        /* renamed from: e  reason: collision with root package name */
        public String f50212e;

        /* renamed from: f  reason: collision with root package name */
        public String f50213f;

        /* renamed from: g  reason: collision with root package name */
        public int f50214g;

        /* renamed from: h  reason: collision with root package name */
        public int f50215h;

        /* renamed from: i  reason: collision with root package name */
        public String f50216i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f50217a;

        /* renamed from: b  reason: collision with root package name */
        public int f50218b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f50219a;

        /* renamed from: b  reason: collision with root package name */
        public double f50220b;

        /* renamed from: c  reason: collision with root package name */
        public double f50221c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C1019a c1019a = new C1019a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f50203a = TextUtils.isEmpty(V) ? "" : V;
        this.f50204b = c1019a;
        this.f50205c = cVar;
        this.f50206d = bVar;
        this.f50207e = jSONObject;
        String r = q0.r();
        c1019a.f50208a = "0".equals(r) ? "" : r;
        String a2 = a();
        c1019a.f50209b = "0".equals(a2) ? "" : a2;
        c1019a.f50210c = 2;
        c1019a.f50211d = d.a.m0.b.n.i.c.a.e(context) ? 3 : 2;
        String i2 = d.a.m0.a.d0.c.i();
        c1019a.f50212e = "NUL".equals(i2) ? "" : i2;
        String g2 = d.a.m0.a.d0.c.g();
        c1019a.f50213f = "NUL".equals(g2) ? "" : g2;
        c1019a.f50214g = n0.n(context);
        c1019a.f50215h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c1019a.f50216i = str;
        bVar.f50217a = d.a.m0.b.n.i.c.a.c();
        bVar.f50218b = d.a.m0.b.n.i.c.a.d(context);
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
            jSONObject.put(Constants.APP_ID, this.f50203a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f50204b.f50208a);
            jSONObject2.put("androidid", this.f50204b.f50209b);
            jSONObject2.put(SearchJsBridge.COOKIE_OS_TYPE, this.f50204b.f50210c);
            jSONObject2.put("device_type", this.f50204b.f50211d);
            jSONObject2.put("device_vendor", this.f50204b.f50212e);
            jSONObject2.put("device_model", this.f50204b.f50213f);
            jSONObject2.put("screen_height", this.f50204b.f50214g);
            jSONObject2.put("screen_width", this.f50204b.f50215h);
            jSONObject2.put("mac", this.f50204b.f50216i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f50205c.f50219a);
            jSONObject3.put("latitude", this.f50205c.f50220b);
            jSONObject3.put("longitude", this.f50205c.f50221c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f50206d.f50217a);
            jSONObject4.put("operator", this.f50206d.f50218b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f50207e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
