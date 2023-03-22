package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import com.baidu.searchbox.pms.db.PackageTable;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class MD5Utils {
    public static synchronized String md5(String str) {
        String str2;
        synchronized (MD5Utils.class) {
            str2 = "";
            try {
                for (byte b : MessageDigest.getInstance(PackageTable.MD5).digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
            } catch (NoSuchAlgorithmException unused) {
                if (!Env.instance().isTestEnv()) {
                    return str2;
                }
                throw new RuntimeException("没有md5这个算法！");
            }
        }
        return str2;
    }
}
