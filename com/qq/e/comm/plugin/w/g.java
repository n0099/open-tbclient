package com.qq.e.comm.plugin.w;

import android.os.SystemClock;
import android.util.Pair;
import com.baidu.fsg.base.statistics.j;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.util.GDTLogger;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile long f12683a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f12684b = null;
    private static volatile boolean c = false;
    private static Object d = new Object();

    /* renamed from: com.qq.e.comm.plugin.w.g$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a(true);
            synchronized (g.b()) {
                if (g.c()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("pv", GDTADManager.getInstance().getPM().getPluginVersion());
                        jSONObject.put("im", o.b());
                        jSONObject.put("ai", o.e());
                        jSONObject.put("bt", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                        Locale locale = Locale.getDefault();
                        jSONObject.put("cc", locale.getCountry());
                        jSONObject.put("lg", locale.getLanguage());
                        jSONObject.put("tz", TimeZone.getDefault().getDisplayName(false, 0));
                        jSONObject.put("ir", o.f() ? 1 : 0);
                        Pair<Integer, Integer> a2 = o.a();
                        if (((Integer) a2.first).intValue() > ((Integer) a2.second).intValue()) {
                            jSONObject.put("sw", a2.second);
                            jSONObject.put(IXAdRequestInfo.SCREEN_HEIGHT, a2.first);
                        } else {
                            jSONObject.put("sw", a2.first);
                            jSONObject.put(IXAdRequestInfo.SCREEN_HEIGHT, a2.second);
                        }
                        jSONObject.put("cv", o.g());
                        jSONObject.put("rs", o.h());
                        jSONObject.put("is", o.i());
                        jSONObject.put(j.c, g.d());
                        jSONObject.put("al", g.e());
                        h.a(1009, jSONObject);
                        g.f();
                    } catch (JSONException e) {
                        GDTLogger.w("report qimei args failed.", e);
                    }
                }
            }
            g.a(false);
        }
    }

    private static long a(String str) {
        return gdtadv.getJresult(88, 1, str);
    }

    public static void a() {
        gdtadv.getVresult(89, 1, new Object[0]);
    }

    static /* synthetic */ boolean a(boolean z) {
        return gdtadv.getZresult(90, 1, Boolean.valueOf(z));
    }

    static /* synthetic */ Object b() {
        return gdtadv.getobjresult(91, 1, new Object[0]);
    }

    static /* synthetic */ boolean c() {
        return gdtadv.getZresult(92, 1, new Object[0]);
    }

    static /* synthetic */ String d() {
        return (String) gdtadv.getobjresult(93, 1, new Object[0]);
    }

    static /* synthetic */ JSONObject e() {
        return (JSONObject) gdtadv.getobjresult(94, 1, new Object[0]);
    }

    static /* synthetic */ void f() {
        gdtadv.getVresult(95, 1, new Object[0]);
    }

    private static boolean g() {
        return gdtadv.getZresult(96, 1, new Object[0]);
    }

    private static JSONObject h() {
        return (JSONObject) gdtadv.getobjresult(97, 1, new Object[0]);
    }

    private static void i() {
        gdtadv.getVresult(98, 1, new Object[0]);
    }
}
