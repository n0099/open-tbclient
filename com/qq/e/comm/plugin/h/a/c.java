package com.qq.e.comm.plugin.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends b {
    private String A;
    private JSONObject B;
    private JSONObject C;

    /* renamed from: b  reason: collision with root package name */
    private final int f12379b = 1;
    private final int c = 2;
    private final int d = 4;
    private final int e = 8;
    private final int f = 16;
    private final int g = 32;
    private final int h = 64;
    private final int i = 128;
    private final int j = 256;
    private final int k = 512;
    private final int l = 1024;
    private final int m = 2048;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private JSONArray z;

    @SuppressLint({"MissingPermission"})
    private JSONArray a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            GDTLogger.d("no read_phone_state permission");
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            GDTLogger.d("tm is null");
            return null;
        }
        this.n = telephonyManager.getDeviceId();
        if (z) {
            this.w = telephonyManager.getSubscriberId();
            if (this.w == null) {
                this.w = "";
            }
        } else {
            this.w = null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.o = telephonyManager.getDeviceId(0);
                this.p = telephonyManager.getDeviceId(1);
            } else {
                String[] a2 = a(telephonyManager, "getDeviceId");
                if (a2 != null) {
                    this.o = a2[1];
                    this.p = a2[2];
                }
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.q = telephonyManager.getImei();
                this.r = telephonyManager.getImei(0);
                this.s = telephonyManager.getImei(1);
            } else {
                String[] a3 = a(telephonyManager, "getImei");
                if (a3 != null) {
                    this.q = a3[0];
                    this.r = a3[1];
                    this.s = a3[2];
                }
            }
            if (z) {
                String[] a4 = a(telephonyManager, "getSubscriberId");
                if (a4 != null) {
                    this.x = a4[1];
                    this.y = a4[2];
                }
            } else {
                this.x = null;
                this.y = null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.t = telephonyManager.getMeid();
                this.u = telephonyManager.getMeid(0);
                this.v = telephonyManager.getMeid(1);
            }
        }
        GDTLogger.d("get ids, time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return b();
    }

    private String[] a(TelephonyManager telephonyManager, String str) {
        Class<?> cls = telephonyManager.getClass();
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            String str2 = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod(str, Integer.TYPE);
            declaredMethod2.setAccessible(true);
            return new String[]{str2, (String) declaredMethod2.invoke(telephonyManager, 0), (String) declaredMethod2.invoke(telephonyManager, 1)};
        } catch (Exception e) {
            GDTLogger.d(str + ", exception = " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private JSONArray b() {
        JSONArray jSONArray;
        JSONException jSONException;
        JSONArray jSONArray2;
        long currentTimeMillis = System.currentTimeMillis();
        String[] strArr = {this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y};
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1 << i;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            int i3 = iArr[i2];
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = (ArrayList) hashMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(str, arrayList);
                }
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (hashMap.size() > 0) {
            try {
                jSONArray2 = new JSONArray();
            } catch (JSONException e) {
                jSONArray = null;
                jSONException = e;
            }
            try {
                for (String str2 : hashMap.keySet()) {
                    JSONObject jSONObject = new JSONObject();
                    Iterator it = ((ArrayList) hashMap.get(str2)).iterator();
                    int i4 = 0;
                    while (it.hasNext()) {
                        i4 = ((Integer) it.next()).intValue() | i4;
                    }
                    jSONObject.put("id_h", Md5Util.encode(str2.toLowerCase()));
                    jSONObject.put("bitmap", i4);
                    jSONArray2.put(jSONObject);
                }
            } catch (JSONException e2) {
                jSONArray = jSONArray2;
                jSONException = e2;
                jSONException.printStackTrace();
                jSONArray2 = jSONArray;
                GDTLogger.d("assemble idInfo, time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return jSONArray2;
            }
        } else {
            jSONArray2 = null;
        }
        GDTLogger.d("assemble idInfo, time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return jSONArray2;
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.z != null && this.z.length() > 0) {
                jSONObject.put("id_info", this.z);
            }
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put("wm_h", this.A);
            }
            if (this.B != null && this.B.length() > 0) {
                jSONObject.put("uuid", this.B);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = null;
        if (jSONObject.length() > 0) {
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("attri_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject2;
    }

    private void e(Context context) {
        if (GDTADManager.getInstance().getSM().getInteger("tdson", 1) == 1) {
            boolean z = GDTADManager.getInstance().getSM().getInteger("imsion", 1) == 1;
            boolean z2 = (this.w == null && z) || !(this.w == null || z);
            if (this.z == null || z2) {
                try {
                    this.z = a(context, z);
                } catch (Throwable th) {
                    this.z = null;
                }
            }
        } else {
            this.z = null;
        }
        if (GDTADManager.getInstance().getSM().getInteger("bdon", 1) == 1) {
            try {
                this.A = f(context);
            } catch (Throwable th2) {
                this.A = null;
            }
        } else {
            this.A = null;
        }
        if (GDTADManager.getInstance().getSM().getInteger("udon", 1) != 1) {
            this.B = null;
        } else if (this.B != null) {
            ai.a("read uuid from cached:" + this.B, new Object[0]);
        } else {
            String string = GDTADManager.getInstance().getSM().getString("ud_salt");
            if (TextUtils.isEmpty(string)) {
                string = "[{\"v\":1,\"s\":\"CB6;8PHJtpsNJwTW\"}]";
            }
            ai.a("read uuid use salt:" + string, new Object[0]);
            try {
                this.B = g.a(string);
            } catch (Exception e) {
                ai.a("read uuid error", e);
            }
            ai.a("read uuid from file:" + this.B, new Object[0]);
        }
    }

    @SuppressLint({"MissingPermission"})
    private String f(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
            GDTLogger.d("no access_wifi_state permission");
            return null;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnected()) {
            GDTLogger.d("wifi not connected");
        } else {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                String bssid = wifiManager.getConnectionInfo().getBSSID();
                GDTLogger.d("bssid = " + bssid);
                if (!TextUtils.isEmpty(bssid) && !Config.DEF_MAC_ID.equals(bssid)) {
                    return Md5Util.encode(bssid.replaceAll(":", "").toUpperCase());
                }
                GDTLogger.d("bssid is empty");
            } else {
                GDTLogger.d("wm is null");
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.h.a
    public String a(Context context) {
        return b(context);
    }

    @Override // com.qq.e.comm.plugin.h.a.b, com.qq.e.comm.plugin.h.a
    public String b(Context context) {
        if (TextUtils.isEmpty(this.f12377a)) {
            this.f12377a = c(context);
        }
        return this.f12377a;
    }

    @Override // com.qq.e.comm.plugin.h.a.b
    protected String c(Context context) {
        JSONObject d = d(context);
        if (d != null) {
            return d.toString();
        }
        return null;
    }

    public JSONObject d(Context context) {
        JSONArray jSONArray = this.z;
        String str = this.A;
        JSONObject jSONObject = this.B;
        String str2 = this.w;
        e(context);
        if (this.C == null || ((!TextUtils.isEmpty(str) && !str.equals(this.A)) || ((!TextUtils.isEmpty(this.A) && !this.A.equals(str)) || ((jSONArray == null && this.z != null) || ((this.z == null && jSONArray != null) || jSONObject != this.B || !TextUtils.equals(str2, this.w)))))) {
            this.C = c();
        }
        return this.C;
    }
}
