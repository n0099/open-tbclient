package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class cu {
    public static String e = el.d + "jy/cf?";
    public static cu qlE;

    /* renamed from: a  reason: collision with root package name */
    public Context f8147a;
    public long b;
    public long c;

    public cu(Context context) {
        this.f8147a = context;
    }

    public static cu iU(Context context) {
        if (qlE == null) {
            synchronized (cu.class) {
                if (qlE == null) {
                    qlE = new cu(context);
                }
            }
        }
        return qlE;
    }

    public final String a() {
        return e;
    }

    public final void a(ep epVar) {
        JSONObject jSONObject;
        if (epVar != null && (jSONObject = epVar.c) != null && jSONObject.length() != 0) {
            try {
                JSONObject jSONObject2 = epVar.c;
                bp.c(this.f8147a, jSONObject2.optString("bt", ""));
                int optInt = jSONObject2.optInt("time", 12);
                SharedPreferences.Editor edit = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit.putInt("interval", optInt);
                edit.apply();
                int optInt2 = jSONObject2.optInt("wt", 5);
                SharedPreferences.Editor edit2 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit2.putInt("timeout_sec", optInt2);
                edit2.apply();
                JSONArray optJSONArray = jSONObject2.optJSONArray("ids");
                Context context = this.f8147a;
                String jSONArray = optJSONArray.toString();
                SharedPreferences.Editor edit3 = context.getSharedPreferences("_prefs", 0).edit();
                edit3.putString("pids", jSONArray);
                edit3.apply();
                String optString = jSONObject2.optString("psdid");
                SharedPreferences.Editor edit4 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit4.putString("psdid", optString);
                edit4.apply();
                int optInt3 = jSONObject2.optInt("psdopt");
                SharedPreferences.Editor edit5 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit5.putInt("psdopt", optInt3);
                edit5.apply();
                int optInt4 = jSONObject2.optInt("psdt");
                SharedPreferences.Editor edit6 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit6.putInt("psdt", optInt4);
                edit6.apply();
                int optInt5 = jSONObject2.optInt("psd");
                SharedPreferences.Editor edit7 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit7.putInt("psd", optInt5);
                edit7.apply();
                int optInt6 = jSONObject2.optInt("hbsw");
                SharedPreferences.Editor edit8 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit8.putInt("hbsw", optInt6);
                edit8.apply();
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("bp");
                Context context2 = this.f8147a;
                String jSONArray2 = optJSONArray2.toString();
                SharedPreferences.Editor edit9 = context2.getSharedPreferences("_prefs", 0).edit();
                edit9.putString("bp", jSONArray2);
                edit9.apply();
                int optInt7 = jSONObject2.optInt("bs", 0);
                SharedPreferences.Editor edit10 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit10.putInt("bro_high", optInt7);
                edit10.apply();
                int optInt8 = jSONObject2.optInt("pro", 4);
                SharedPreferences.Editor edit11 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit11.putInt("re_pro", optInt8);
                edit11.apply();
                int optInt9 = jSONObject2.optInt("scbsw", 0);
                SharedPreferences.Editor edit12 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit12.putInt("scb_sw", optInt9);
                edit12.apply();
                int optInt10 = jSONObject2.optInt("pclsw", 0);
                SharedPreferences.Editor edit13 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit13.putInt("pcl_sw", optInt10);
                edit13.apply();
                int optInt11 = jSONObject2.optInt("scbtsi", 300);
                SharedPreferences.Editor edit14 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit14.putInt("scb_tsi", optInt11);
                edit14.apply();
                long optInt12 = jSONObject2.optInt("bdtsi", 24);
                SharedPreferences.Editor edit15 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit15.putLong("bdtsi", optInt12);
                edit15.apply();
                long optInt13 = jSONObject2.optInt("las", 12);
                SharedPreferences.Editor edit16 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit16.putLong("las", optInt13);
                edit16.apply();
                int optInt14 = jSONObject2.optInt("jumpsw", 0);
                SharedPreferences.Editor edit17 = this.f8147a.getSharedPreferences("_prefs", 0).edit();
                edit17.putInt("jumpsw", optInt14);
                edit17.apply();
                bp.b(this.f8147a, new Date().getTime());
            } catch (Exception e2) {
                ca.iT(this.f8147a).H(101, this.c).a();
                e2.printStackTrace();
            }
        }
    }

    public final void b() {
        bp.b(this.f8147a, new Date().getTime());
    }
}
