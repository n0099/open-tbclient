package d.b.i0.r2.a0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.h0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f59747f;

    /* renamed from: a  reason: collision with root package name */
    public String f59748a;

    /* renamed from: b  reason: collision with root package name */
    public String f59749b;

    /* renamed from: c  reason: collision with root package name */
    public long f59750c;

    /* renamed from: d  reason: collision with root package name */
    public String f59751d;

    /* renamed from: e  reason: collision with root package name */
    public String f59752e = b.i().o("asp_shown_info", "");

    public static a e() {
        if (f59747f == null) {
            synchronized (d.b.i0.c3.m0.b.class) {
                if (f59747f == null) {
                    f59747f = new a();
                }
            }
        }
        return f59747f;
    }

    public AppPosInfo a() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        builder.latitude = this.f59749b;
        builder.longitude = this.f59748a;
        builder.addr_timestamp = Long.valueOf(this.f59750c);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.f59752e;
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
                jSONObject.put("mercator_lat", c2.mercator_lat);
                jSONObject.put("mercator_lon", c2.mercator_lon);
                jSONObject.put("mercator_city", c2.mercator_city);
                jSONObject.put("mercator_radius", c2.mercator_radius);
                jSONObject.put("mercator_time", c2.mercator_time);
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    public AppPosInfo c() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        String str = this.f59749b;
        builder.latitude = str;
        builder.longitude = this.f59748a;
        if (k.isEmpty(str) || k.isEmpty(this.f59748a)) {
            String o = b.i().o("key_last_receive_location_latitude_and_longitude", "");
            if (!k.isEmpty(o)) {
                String[] split = o.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.f59750c);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.f59752e;
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
        if (TextUtils.isEmpty(this.f59751d)) {
            f();
        }
        return this.f59751d;
    }

    public void f() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f59751d = connectionInfo.getBSSID();
                } else {
                    this.f59751d = "";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        b.i().w("asp_shown_info", this.f59752e);
    }

    public void h(String str) {
        this.f59752e = str;
    }

    public void i(String str) {
        this.f59749b = str;
    }

    public void j(String str) {
        this.f59748a = str;
    }

    public void k(long j) {
        this.f59750c = j;
    }
}
