package com.kwai.player;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public class KwaiCheckEnableHardwareDecoder {
    private static boolean mEnable;
    private static final HardwareDecoderProduct[] mProductArray = {new HardwareDecoderProduct("HUAWEI", "ALP-AL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "ALP-TL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "ALP-L09", "kirin970"), new HardwareDecoderProduct("HUAWEI", "ALP-L29", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-AL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "STF-AL10", "hi3660"), new HardwareDecoderProduct("HUAWEI", "STF-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "STF-TL10", "hi3660"), new HardwareDecoderProduct("HUAWEI", "BLA-AL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-TL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-L09", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-L29", "kirin970"), new HardwareDecoderProduct("HUAWEI", "LON-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "DUK-AL20", "hi3660"), new HardwareDecoderProduct("HUAWEI", "DUK-AL30", "hi3660"), new HardwareDecoderProduct("HUAWEI", "DUK-TL30", "hi3660"), new HardwareDecoderProduct("HUAWEI", "BAC-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BAC-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PIC-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PIC-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "FRD-AL00", "hi3650"), new HardwareDecoderProduct("HUAWEI", "FRD-AL10", "hi3650"), new HardwareDecoderProduct("HUAWEI", "FRD-DL00", "hi3650"), new HardwareDecoderProduct("HUAWEI", "NEM-AL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-UL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-TL00H", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-UL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-TL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL20", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL30", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL40", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PRA-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PRA-AL00X", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PRA-TL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "WAS-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "WAS-TL10", "hi6250")};
    private static String mProduct = getProp("ro.product.manufacturer");
    private static String mPlatform = getProp("ro.board.platform");
    private static String mModel = getProp("ro.product.model");

    /* loaded from: classes5.dex */
    private static class HardwareDecoderProduct {
        public String model;
        public String platform;
        public String product;

        public HardwareDecoderProduct(String str, String str2, String str3) {
            this.product = str;
            this.platform = str3;
            this.model = str2;
        }
    }

    static {
        mEnable = false;
        for (int i = 0; i < mProductArray.length; i++) {
            if (TextUtils.equals(mProduct, mProductArray[i].product) && TextUtils.equals(mPlatform, mProductArray[i].platform) && TextUtils.equals(mModel, mProductArray[i].model)) {
                mEnable = true;
            }
        }
    }

    public static boolean canEnableHardwareDecoder() {
        return mEnable;
    }

    private static String getProp(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
