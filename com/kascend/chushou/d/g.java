package com.kascend.chushou.d;

import com.baidu.android.util.devices.RomUtils;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class g {
    public static boolean a() {
        String str = tv.chushou.zues.utils.f.get("ro.product.manufacturer");
        return !tv.chushou.zues.utils.h.isEmpty(str) && str.toLowerCase().contains(RomUtils.MANUFACTURER_HUAWEI);
    }

    public static boolean b() {
        String lowerCase = tv.chushou.zues.utils.f.get("ro.product.manufacturer").toLowerCase();
        if (tv.chushou.zues.utils.h.isEmpty(lowerCase)) {
            return false;
        }
        if (lowerCase.contains(RomUtils.MANUFACTURER_HUAWEI)) {
            return c();
        }
        if (lowerCase.contains(RomUtils.MANUFACTURER_VIVO)) {
            return d();
        }
        if (lowerCase.contains(RomUtils.MANUFACTURER_OPPO)) {
            if (tv.chushou.basis.d.b.elS() != null) {
                return tv.chushou.basis.d.b.elS().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
            }
            return false;
        } else if (lowerCase.contains(RomUtils.MANUFACTURER_XIAOMI)) {
            return "1".equals(tv.chushou.zues.utils.f.get("ro.miui.notch"));
        } else {
            if (lowerCase.contains("oneplus")) {
                return tv.chushou.zues.utils.f.get("ro.product.device").toLowerCase().equals("oneplus6");
            }
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [66=4] */
    public static boolean c() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.util.HwNotchSizeUtil");
            Method method = cls.getMethod("hasNotchInScreen", new Class[0]);
            method.setAccessible(true);
            return ((Boolean) method.invoke(cls, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=4] */
    public static boolean d() {
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            Method method = cls.getMethod("isFeatureSupport", Integer.TYPE);
            method.setAccessible(true);
            return ((Boolean) method.invoke(cls, 32)).booleanValue();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [101=4] */
    public static int[] dYz() {
        int[] iArr = {0, 0};
        try {
            Class<?> cls = Class.forName("com.huawei.android.util.HwNotchSizeUtil");
            Method method = cls.getMethod("getNotchSize", new Class[0]);
            method.setAccessible(true);
            return (int[]) method.invoke(cls, new Object[0]);
        } catch (ClassNotFoundException e) {
            return iArr;
        } catch (NoSuchMethodException e2) {
            return iArr;
        } catch (Exception e3) {
            return iArr;
        } catch (Throwable th) {
            return iArr;
        }
    }
}
