package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.a.f;
/* loaded from: classes11.dex */
public class SecureJsInterface extends a.b {
    public static boolean isPWDEdit = false;

    /* renamed from: a  reason: collision with root package name */
    private String f4625a;

    @Override // com.tencent.open.a.b
    public boolean customCallback() {
        return true;
    }

    public void curPosFromJS(String str) {
        f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
        }
        if (i < 0) {
            throw new RuntimeException("position is illegal.");
        }
        if (!a.c) {
        }
        if (a.b) {
            if (Boolean.valueOf(JniInterface.BackSpaceChar(a.b, i)).booleanValue()) {
                a.b = false;
                return;
            }
            return;
        }
        this.f4625a = a.f4626a;
        JniInterface.insetTextToArray(i, this.f4625a, this.f4625a.length());
        f.a("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f4625a);
    }

    public void isPasswordEdit(String str) {
        f.c("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            f.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
        }
        if (i != 0 && i != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i == 0) {
            isPWDEdit = false;
        } else if (i == 1) {
            isPWDEdit = true;
        }
    }

    public void clearAllEdit() {
        f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            f.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getMD5FromNative() {
        f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            f.a("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e) {
            f.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
