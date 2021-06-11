package d.a.n0.t2.g0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.m0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f64808f;

    /* renamed from: a  reason: collision with root package name */
    public String f64809a;

    /* renamed from: b  reason: collision with root package name */
    public String f64810b;

    /* renamed from: c  reason: collision with root package name */
    public long f64811c;

    /* renamed from: d  reason: collision with root package name */
    public String f64812d;

    /* renamed from: e  reason: collision with root package name */
    public String f64813e = b.j().p("asp_shown_info", "");

    public static a e() {
        if (f64808f == null) {
            synchronized (d.a.n0.e3.m0.b.class) {
                if (f64808f == null) {
                    f64808f = new a();
                }
            }
        }
        return f64808f;
    }

    public AppPosInfo a() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        builder.latitude = this.f64810b;
        builder.longitude = this.f64809a;
        builder.addr_timestamp = Long.valueOf(this.f64811c);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.f64813e;
        MercatorModel.MercatorData e2 = MercatorModel.d().e();
        if (e2 != null) {
            builder.mercator_lat = e2.x();
            builder.mercator_lon = e2.y();
            builder.mercator_city = Integer.valueOf(e2.w());
            builder.mercator_radius = e2.z();
            builder.mercator_time = Long.valueOf(e2.A());
        }
        return builder.build(false);
    }

    public String b() {
        AppPosInfo c2 = c();
        JSONObject jSONObject = new JSONObject();
        if (c2 != null) {
            try {
                jSONObject.put("ap_mac", c2.ap_mac);
                jSONObject.put("ap_connected", c2.ap_connected);
                jSONObject.put("latitude", c2.latitude);
                jSONObject.put("longitude", c2.longitude);
                jSONObject.put("addr_timestamp", c2.addr_timestamp);
                jSONObject.put("coordinate_type", c2.coordinate_type);
                jSONObject.put("asp_shown_info", c2.asp_shown_info);
                jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LAT, c2.mercator_lat);
                jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LON, c2.mercator_lon);
                jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_CITY, c2.mercator_city);
                jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_RADIUS, c2.mercator_radius);
                jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_TIME, c2.mercator_time);
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    public AppPosInfo c() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        String str = this.f64810b;
        builder.latitude = str;
        builder.longitude = this.f64809a;
        if (k.isEmpty(str) || k.isEmpty(this.f64809a)) {
            String p = b.j().p("key_last_receive_location_latitude_and_longitude", "");
            if (!k.isEmpty(p)) {
                String[] split = p.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.f64811c);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.f64813e;
        MercatorModel.MercatorData e2 = MercatorModel.d().e();
        if (e2 != null) {
            builder.mercator_lat = e2.x();
            builder.mercator_lon = e2.y();
            builder.mercator_city = Integer.valueOf(e2.w());
            builder.mercator_radius = e2.z();
            builder.mercator_time = Long.valueOf(e2.A());
        }
        return builder.build(false);
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f64812d)) {
            f();
        }
        return this.f64812d;
    }

    public void f() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f64812d = connectionInfo.getBSSID();
                } else {
                    this.f64812d = "";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        b.j().x("asp_shown_info", this.f64813e);
    }

    public void h(String str) {
        this.f64813e = str;
    }

    public void i(String str) {
        this.f64810b = str;
    }

    public void j(String str) {
        this.f64809a = str;
    }

    public void k(long j) {
        this.f64811c = j;
    }
}
