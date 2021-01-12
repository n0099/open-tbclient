package com.qq.e.comm.plugin.w;

import com.qq.e.comm.plugin.ad.m;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12685a = "http://sdk.e.qq.com";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12686b = "http://sdk.e.qq.com/getad";
    public static final String c = "http://sdk.e.qq.com/disp";
    public static final String d = "http://sdk.e.qq.com/click";
    public static final String e = "http://sdk.e.qq.com/msg";
    private static final String f = "imei";
    private static final String g = "index";
    private static final String h = "secLevel";
    private static final String i = "gdtType";
    private static final String j = "trace";
    private static final String k = "dev";
    private static Random l = new Random();

    public static JSONObject a(m mVar) throws JSONException {
        return (JSONObject) gdtadv.getobjresult(63, 1, mVar);
    }

    private static JSONObject a(String str, String str2, Map<String, Object> map) throws JSONException {
        return (JSONObject) gdtadv.getobjresult(64, 1, str, str2, map);
    }

    private static JSONObject a(String str, String str2, Map<String, Object> map, com.qq.e.comm.plugin.ad.f fVar, JSONObject jSONObject) throws JSONException {
        return (JSONObject) gdtadv.getobjresult(65, 1, str, str2, map, fVar, jSONObject);
    }

    public static void a(int i2, JSONObject jSONObject) {
        gdtadv.getVresult(66, 1, Integer.valueOf(i2), jSONObject);
    }

    public static void a(int i2, JSONObject jSONObject, m mVar, String str) {
        gdtadv.getVresult(67, 1, Integer.valueOf(i2), jSONObject, mVar, str);
    }

    public static void a(String str, String str2, m mVar, Map<String, Object> map, com.qq.e.comm.plugin.t.b bVar) {
        gdtadv.getVresult(68, 1, str, str2, mVar, map, bVar);
    }

    public static void a(String str, String str2, JSONObject jSONObject, m mVar, com.qq.e.comm.plugin.ad.f fVar, Map<String, Object> map, com.qq.e.comm.plugin.t.b bVar) {
        gdtadv.getVresult(69, 1, str, str2, jSONObject, mVar, fVar, map, bVar);
    }

    public static void a(List<String> list, String str, m mVar, Map<String, Object> map, com.qq.e.comm.plugin.t.b bVar) {
        gdtadv.getVresult(70, 1, list, str, mVar, map, bVar);
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        gdtadv.getVresult(71, 1, jSONObject);
    }

    public static void a(StackTraceElement[] stackTraceElementArr, int i2, int i3, int i4) {
        gdtadv.getVresult(72, 1, stackTraceElementArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private static boolean a(int i2, int i3) {
        return gdtadv.getZresult(73, 1, Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
