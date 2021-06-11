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
    public String f50095a;

    /* renamed from: b  reason: collision with root package name */
    public C1016a f50096b;

    /* renamed from: c  reason: collision with root package name */
    public c f50097c;

    /* renamed from: d  reason: collision with root package name */
    public b f50098d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f50099e;

    /* renamed from: d.a.l0.b.n.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1016a {

        /* renamed from: a  reason: collision with root package name */
        public String f50100a;

        /* renamed from: b  reason: collision with root package name */
        public String f50101b;

        /* renamed from: c  reason: collision with root package name */
        public int f50102c;

        /* renamed from: d  reason: collision with root package name */
        public int f50103d;

        /* renamed from: e  reason: collision with root package name */
        public String f50104e;

        /* renamed from: f  reason: collision with root package name */
        public String f50105f;

        /* renamed from: g  reason: collision with root package name */
        public int f50106g;

        /* renamed from: h  reason: collision with root package name */
        public int f50107h;

        /* renamed from: i  reason: collision with root package name */
        public String f50108i;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f50109a;

        /* renamed from: b  reason: collision with root package name */
        public int f50110b;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f50111a;

        /* renamed from: b  reason: collision with root package name */
        public double f50112b;

        /* renamed from: c  reason: collision with root package name */
        public double f50113c;
    }

    public a(@NonNull Context context, @NonNull JSONObject jSONObject) {
        C1016a c1016a = new C1016a();
        c cVar = new c();
        b bVar = new b();
        String V = e.V();
        String str = "";
        this.f50095a = TextUtils.isEmpty(V) ? "" : V;
        this.f50096b = c1016a;
        this.f50097c = cVar;
        this.f50098d = bVar;
        this.f50099e = jSONObject;
        String r = q0.r();
        c1016a.f50100a = "0".equals(r) ? "" : r;
        String a2 = a();
        c1016a.f50101b = "0".equals(a2) ? "" : a2;
        c1016a.f50102c = 2;
        c1016a.f50103d = d.a.l0.b.n.i.c.a.e(context) ? 3 : 2;
        String i2 = d.a.l0.a.d0.c.i();
        c1016a.f50104e = "NUL".equals(i2) ? "" : i2;
        String g2 = d.a.l0.a.d0.c.g();
        c1016a.f50105f = "NUL".equals(g2) ? "" : g2;
        c1016a.f50106g = n0.n(context);
        c1016a.f50107h = n0.o(context);
        String b2 = b();
        if (!TextUtils.isEmpty(b2) && !Config.DEF_MAC_ID.equals(b2)) {
            str = b2;
        }
        c1016a.f50108i = str;
        bVar.f50109a = d.a.l0.b.n.i.c.a.c();
        bVar.f50110b = d.a.l0.b.n.i.c.a.d(context);
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
            jSONObject.put(Constants.APP_ID, this.f50095a);
            jSONObject2.put(DeviceUtils.KEY_OLD_NAME_STRING, this.f50096b.f50100a);
            jSONObject2.put("androidid", this.f50096b.f50101b);
            jSONObject2.put(SearchJsBridge.COOKIE_OS_TYPE, this.f50096b.f50102c);
            jSONObject2.put("device_type", this.f50096b.f50103d);
            jSONObject2.put("device_vendor", this.f50096b.f50104e);
            jSONObject2.put("device_model", this.f50096b.f50105f);
            jSONObject2.put("screen_height", this.f50096b.f50106g);
            jSONObject2.put("screen_width", this.f50096b.f50107h);
            jSONObject2.put("mac", this.f50096b.f50108i);
            jSONObject.put("device", jSONObject2);
            jSONObject3.put("coord_type", this.f50097c.f50111a);
            jSONObject3.put("latitude", this.f50097c.f50112b);
            jSONObject3.put("longitude", this.f50097c.f50113c);
            jSONObject.put(TableDefine.DB_TABLE_USERINFO, jSONObject3);
            jSONObject4.put("network", this.f50098d.f50109a);
            jSONObject4.put("operator", this.f50098d.f50110b);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.f50099e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String d() {
        return c().toString();
    }
}
