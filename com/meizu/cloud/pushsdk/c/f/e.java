package com.meizu.cloud.pushsdk.c.f;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static final String a = "e";

    public static long a(String str) {
        long j2;
        long j3 = 0;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt <= 127) {
                j2 = 1;
            } else if (charAt <= 2047) {
                j2 = 2;
            } else {
                if (charAt >= 55296 && charAt <= 57343) {
                    j3 += 4;
                    i2++;
                } else if (charAt < 65535) {
                    j2 = 3;
                } else {
                    j3 += 4;
                }
                i2++;
            }
            j3 += j2;
            i2++;
        }
        return j3;
    }

    public static Object a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            return obj;
        }
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (Collection) obj) {
                jSONArray.put(a(obj2));
            }
            return jSONArray;
        } else if (obj.getClass().isArray()) {
            JSONArray jSONArray2 = new JSONArray();
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                jSONArray2.put(a(Array.get(obj, i2)));
            }
            return jSONArray2;
        } else if (obj instanceof Map) {
            return a((Map) obj);
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
                return obj;
            }
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
    }

    public static String a() {
        return Long.toString(System.currentTimeMillis());
    }

    public static JSONObject a(Map map) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new JSONObject(map);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object a2 = a(entry.getValue());
            try {
                jSONObject.put(str, a2);
            } catch (JSONException e2) {
                c.a(a, "Could not put key '%s' and value '%s' into new JSONObject: %s", str, a2, e2);
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static boolean a(long j2, long j3, long j4) {
        return j2 > j3 - j4;
    }

    public static boolean a(Context context) {
        try {
            c.c(a, "Checking tracker internet connectivity.", new Object[0]);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            c.b(a, "Tracker connection online: %s", Boolean.valueOf(z));
            return z;
        } catch (Exception e2) {
            c.a(a, "Security exception checking connection: %s", e2.toString());
            return true;
        }
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return null;
        } catch (Exception e2) {
            c.a(a, "getCarrier: %s", e2.toString());
            return null;
        }
    }

    public static Location c(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                c.a(a, "Location Manager is null.", new Object[0]);
                return null;
            }
            Criteria criteria = new Criteria();
            criteria.setPowerRequirement(1);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null) {
                c.a(a, "Location Manager provider is null.", new Object[0]);
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
            c.b(a, "Location found: %s", lastKnownLocation);
            return lastKnownLocation;
        } catch (Exception e2) {
            c.a(a, "Failed to retrieve location: %s", e2.toString());
            return null;
        }
    }
}
