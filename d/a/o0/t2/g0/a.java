package d.a.o0.t2.g0;

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
import d.a.n0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f64933f;

    /* renamed from: a  reason: collision with root package name */
    public String f64934a;

    /* renamed from: b  reason: collision with root package name */
    public String f64935b;

    /* renamed from: c  reason: collision with root package name */
    public long f64936c;

    /* renamed from: d  reason: collision with root package name */
    public String f64937d;

    /* renamed from: e  reason: collision with root package name */
    public String f64938e = b.j().p("asp_shown_info", "");

    public static a e() {
        if (f64933f == null) {
            synchronized (d.a.o0.e3.m0.b.class) {
                if (f64933f == null) {
                    f64933f = new a();
                }
            }
        }
        return f64933f;
    }

    public AppPosInfo a() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        builder.latitude = this.f64935b;
        builder.longitude = this.f64934a;
        builder.addr_timestamp = Long.valueOf(this.f64936c);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.f64938e;
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
        String str = this.f64935b;
        builder.latitude = str;
        builder.longitude = this.f64934a;
        if (k.isEmpty(str) || k.isEmpty(this.f64934a)) {
            String p = b.j().p("key_last_receive_location_latitude_and_longitude", "");
            if (!k.isEmpty(p)) {
                String[] split = p.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.f64936c);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.f64938e;
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
        if (TextUtils.isEmpty(this.f64937d)) {
            f();
        }
        return this.f64937d;
    }

    public void f() {
        if (TbadkCoreApplication.getInst().isAllActivityBackground()) {
            return;
        }
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f64937d = connectionInfo.getBSSID();
                } else {
                    this.f64937d = "";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        b.j().x("asp_shown_info", this.f64938e);
    }

    public void h(String str) {
        this.f64938e = str;
    }

    public void i(String str) {
        this.f64935b = str;
    }

    public void j(String str) {
        this.f64934a = str;
    }

    public void k(long j) {
        this.f64936c = j;
    }
}
