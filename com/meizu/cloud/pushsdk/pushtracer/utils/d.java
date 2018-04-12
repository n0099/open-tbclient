package com.meizu.cloud.pushsdk.pushtracer.utils;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static final String a = d.class.getSimpleName();

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
            } catch (JSONException e) {
                b.a(a, "Could not put key '%s' and value '%s' into new JSONObject: %s", str, a2, e);
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private static Object a(Object obj) {
        if (Build.VERSION.SDK_INT < 19) {
            if (obj == null) {
                return JSONObject.NULL;
            }
            if (!(obj instanceof JSONObject) && !(obj instanceof JSONArray)) {
                if (obj instanceof Collection) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object obj2 : (Collection) obj) {
                        jSONArray.put(a(obj2));
                    }
                    return jSONArray;
                } else if (obj.getClass().isArray()) {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        jSONArray2.put(a(Array.get(obj, i)));
                    }
                    return jSONArray2;
                } else if (obj instanceof Map) {
                    return a((Map) obj);
                } else {
                    if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                        if (obj.getClass().getPackage().getName().startsWith("java.")) {
                            return obj.toString();
                        }
                        return null;
                    }
                    return obj;
                }
            }
            return obj;
        }
        return obj;
    }

    public static long a(String str) {
        long j = 0;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                j++;
            } else if (charAt <= 2047) {
                j += 2;
            } else if (charAt >= 55296 && charAt <= 57343) {
                j += 4;
                i++;
            } else if (charAt < 65535) {
                j += 3;
            } else {
                j += 4;
            }
            i++;
        }
        return j;
    }

    public static String a() {
        return Long.toString(System.currentTimeMillis());
    }

    public static boolean a(Context context) {
        b.c(a, "Checking tracker internet connectivity.", new Object[0]);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            b.b(a, "Tracker connection online: %s", Boolean.valueOf(z));
            return z;
        } catch (SecurityException e) {
            b.a(a, "Security exception checking connection: %s", e.toString());
            return true;
        }
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public static Location c(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(1);
        criteria.setAccuracy(2);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider != null) {
            try {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                b.b(a, "Location found: %s", lastKnownLocation);
                return lastKnownLocation;
            } catch (SecurityException e) {
                b.a(a, "Failed to retrieve location: %s", e.toString());
                return null;
            }
        }
        b.a(a, "Location Manager provider is null.", new Object[0]);
        return null;
    }

    public static boolean a(long j, long j2, long j3) {
        return j > j2 - j3;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }
}
