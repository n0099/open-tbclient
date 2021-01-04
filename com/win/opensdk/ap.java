package com.win.opensdk;

import android.util.Base64;
/* loaded from: classes4.dex */
public final class ap {
    public static String java = "Y2wyaQ==";

    /* renamed from: case  reason: not valid java name */
    public static String f24case = "YjJsbw==";

    /* renamed from: a  reason: collision with root package name */
    public static String f14024a = "aTFob21lOGw=";

    public static String java() {
        byte[] decode = Base64.decode(java, 2);
        StringBuilder sb = new StringBuilder();
        for (byte b2 : decode) {
            sb.append((char) b2);
        }
        return sb.toString();
    }

    public static String eJS() {
        byte[] decode = Base64.decode(f24case, 0);
        StringBuilder sb = new StringBuilder();
        for (byte b2 : decode) {
            sb.append((char) b2);
        }
        return sb.toString();
    }

    public static String a() {
        byte[] decode = Base64.decode(f14024a, 0);
        StringBuilder sb = new StringBuilder();
        for (byte b2 : decode) {
            sb.append((char) b2);
        }
        return sb.toString();
    }
}
