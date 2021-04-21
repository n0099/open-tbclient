package d.b.h0.b.m.i.b;

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
import com.xiaomi.mipush.sdk.Constants;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48178a;

    /* renamed from: b  reason: collision with root package name */
    public C0949a f48179b;

    /* renamed from: c  reason: collision with root package name */
    public c f48180c;

    /* renamed from: d  reason: collision with root package name */
    public b f48181d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48182e;

    /* renamed from: d.b.h0.b.m.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0949a {

        /* renamed from: a  reason: collision with root package name */
        public String f48183a;

        /* renamed from: b  reason: collision with root package name */
        public String f48184b;

        /* renamed from: c  reason: collision with root package name */
        public int f48185c;

        /* renamed from: d  reason: collision with root package name */
        public int f48186d;

        /* renamed from: e  reason: collision with root package name */
        public String f48187e;

        /* renamed from: f  reason: collision with root package name */
        public String f48188f;

        /* renamed from: g  reason: collision with root package name */
        public int f48189g;

        /* renamed from: h  reason: collision with root package name */
        public int f48190h;
        public String i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f48191a;

        /* renamed from: b  reason: collision with root package name */
        public int f48192b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f48193a;

        /* renamed from: b  reason: collision with root package name */
        public double f48194b;

        /* renamed from: c  reason: collision with root package name */
        public double f48195c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C0949a c0949a = new C0949a();
        c cVar = new c();
        b bVar = new b();
        String T = e.T();
        String str = "";
        this.f48178a = TextUtils.isEmpty(T) ? "" : T;
        this.f48179b = c0949a;
        this.f48180c = cVar;
        this.f48181d = bVar;
        this.f48182e = jSONObject;
        String r = k0.r();
        c0949a.f48183a = "0".equals(r) ? "" : r;
        String a2 = a();
        c0949a.f48184b = "0".equals(a2) ? "" : a2;
        c0949a.f48185c = 2;
        c0949a.f48186d = d.b.h0.b.m.i.c.a.e(context) ? 3 : 2;
        String h2 = d.b.h0.a.b0.c.h();
        c0949a.f48187e = "NUL".equals(h2) ? "" : h2;
        String f2 = d.b.h0.a.b0.c.f();
        c0949a.f48188f = "NUL".equals(f2) ? "" : f2;
        c0949a.f48189g = h0.l(context);
        c0949a.f48190h = h0.m(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c0949a.i = str;
        bVar.f48191a = d.b.h0.b.m.i.c.a.c();
        bVar.f48192b = d.b.h0.b.m.i.c.a.d(context);
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
            jSONObject.put(Constants.APP_ID, this.f48178a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f48179b.f48183a);
            jSONObject2.put("androidid", this.f48179b.f48184b);
            jSONObject2.put("os_type", this.f48179b.f48185c);
            jSONObject2.put("device_type", this.f48179b.f48186d);
            jSONObject2.put("device_vendor", this.f48179b.f48187e);
            jSONObject2.put("device_model", this.f48179b.f48188f);
            jSONObject2.put("screen_height", this.f48179b.f48189g);
            jSONObject2.put("screen_width", this.f48179b.f48190h);
            jSONObject2.put(IAdRequestParam.MAC, this.f48179b.i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f48180c.f48193a);
            jSONObject3.put("latitude", this.f48180c.f48194b);
            jSONObject3.put("longitude", this.f48180c.f48195c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f48181d.f48191a);
            jSONObject4.put("operator", this.f48181d.f48192b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f48182e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
