package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;
/* loaded from: classes15.dex */
public class as {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f12564a = new Random(System.currentTimeMillis());

    /* renamed from: b  reason: collision with root package name */
    private static volatile Boolean f12565b = null;

    public static void a() {
        f12565b = null;
    }

    public static boolean a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        if (i < i2) {
            String b2 = o.b();
            if (TextUtils.isEmpty(b2) || (b2.hashCode() & Integer.MAX_VALUE) % i2 > i) {
                return false;
            }
        }
        return true;
    }

    public static boolean b() {
        SM sm = GDTADManager.getInstance().getSM();
        if (sm != null) {
            return a(sm.getInteger("qimeiSamplingRate", 0), 10000);
        }
        return false;
    }

    public static boolean b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        return i >= i2 || f12564a.nextInt(i2) < i;
    }

    public static boolean c() {
        if (f12565b != null) {
            return f12565b.booleanValue();
        }
        SM sm = GDTADManager.getInstance().getSM();
        if (sm != null) {
            f12565b = Boolean.valueOf(b(sm.getInteger("collectAntiSpamInfo", 0), 10000));
            return f12565b.booleanValue();
        }
        return false;
    }

    public static boolean d() {
        SM sm = GDTADManager.getInstance().getSM();
        if (sm != null) {
            return b(sm.getInteger("securityVulnerabilityReport", 10), 10000);
        }
        return false;
    }
}
