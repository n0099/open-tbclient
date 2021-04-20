package d.b.i0.s2.d0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.h0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f61648f;

    /* renamed from: a  reason: collision with root package name */
    public String f61649a;

    /* renamed from: b  reason: collision with root package name */
    public String f61650b;

    /* renamed from: c  reason: collision with root package name */
    public long f61651c;

    /* renamed from: d  reason: collision with root package name */
    public String f61652d;

    /* renamed from: e  reason: collision with root package name */
    public String f61653e = b.j().p("asp_shown_info", "");

    public static a e() {
        if (f61648f == null) {
            synchronized (d.b.i0.d3.m0.b.class) {
                if (f61648f == null) {
                    f61648f = new a();
                }
            }
        }
        return f61648f;
    }

    public AppPosInfo a() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = d();
        builder.ap_connected = Boolean.valueOf(j.H());
        builder.latitude = this.f61650b;
        builder.longitude = this.f61649a;
        builder.addr_timestamp = Long.valueOf(this.f61651c);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.f61653e;
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
        String str = this.f61650b;
        builder.latitude = str;
        builder.longitude = this.f61649a;
        if (k.isEmpty(str) || k.isEmpty(this.f61649a)) {
            String p = b.j().p("key_last_receive_location_latitude_and_longitude", "");
            if (!k.isEmpty(p)) {
                String[] split = p.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.f61651c);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.f61653e;
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
        if (TextUtils.isEmpty(this.f61652d)) {
            f();
        }
        return this.f61652d;
    }

    public void f() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f61652d = connectionInfo.getBSSID();
                } else {
                    this.f61652d = "";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        b.j().x("asp_shown_info", this.f61653e);
    }

    public void h(String str) {
        this.f61653e = str;
    }

    public void i(String str) {
        this.f61650b = str;
    }

    public void j(String str) {
        this.f61649a = str;
    }

    public void k(long j) {
        this.f61651c = j;
    }
}
