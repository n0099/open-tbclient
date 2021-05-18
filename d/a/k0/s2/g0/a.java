package d.a.k0.s2.g0;

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
import d.a.j0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f61014f;

    /* renamed from: a  reason: collision with root package name */
    public String f61015a;

    /* renamed from: b  reason: collision with root package name */
    public String f61016b;

    /* renamed from: c  reason: collision with root package name */
    public long f61017c;

    /* renamed from: d  reason: collision with root package name */
    public String f61018d;

    /* renamed from: e  reason: collision with root package name */
    public String f61019e = b.j().p("asp_shown_info", "");

    public static a e() {
        if (f61014f == null) {
            synchronized (d.a.k0.d3.m0.b.class) {
                if (f61014f == null) {
                    f61014f = new a();
                }
            }
        }
        return f61014f;
    }

    public AppPosInfo a() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        builder.latitude = this.f61016b;
        builder.longitude = this.f61015a;
        builder.addr_timestamp = Long.valueOf(this.f61017c);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.f61019e;
        MercatorModel.MercatorData e2 = MercatorModel.d().e();
        if (e2 != null) {
            builder.mercator_lat = e2.t();
            builder.mercator_lon = e2.u();
            builder.mercator_city = Integer.valueOf(e2.s());
            builder.mercator_radius = e2.v();
            builder.mercator_time = Long.valueOf(e2.w());
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
        String str = this.f61016b;
        builder.latitude = str;
        builder.longitude = this.f61015a;
        if (k.isEmpty(str) || k.isEmpty(this.f61015a)) {
            String p = b.j().p("key_last_receive_location_latitude_and_longitude", "");
            if (!k.isEmpty(p)) {
                String[] split = p.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.f61017c);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.f61019e;
        MercatorModel.MercatorData e2 = MercatorModel.d().e();
        if (e2 != null) {
            builder.mercator_lat = e2.t();
            builder.mercator_lon = e2.u();
            builder.mercator_city = Integer.valueOf(e2.s());
            builder.mercator_radius = e2.v();
            builder.mercator_time = Long.valueOf(e2.w());
        }
        return builder.build(false);
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f61018d)) {
            f();
        }
        return this.f61018d;
    }

    public void f() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f61018d = connectionInfo.getBSSID();
                } else {
                    this.f61018d = "";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        b.j().x("asp_shown_info", this.f61019e);
    }

    public void h(String str) {
        this.f61019e = str;
    }

    public void i(String str) {
        this.f61016b = str;
    }

    public void j(String str) {
        this.f61015a = str;
    }

    public void k(long j) {
        this.f61017c = j;
    }
}
