package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import d.r.b.a.a.f.e.f;
import java.io.UnsupportedEncodingException;
/* loaded from: classes7.dex */
public class Marshallable extends f {

    /* loaded from: classes7.dex */
    public enum ELenType {
        E_INT16,
        E_INT32,
        E_INT64,
        E_NONE
    }

    public final int f() throws Exception {
        a(4);
        return this.f67746a.getInt();
    }

    public final String g() throws Exception {
        int remaining = this.f67746a.remaining();
        byte[] bArr = new byte[remaining];
        a(remaining);
        this.f67746a.get(bArr);
        return new String(bArr, "UTF-8");
    }

    public final String h() throws Exception {
        a(4);
        int f2 = f();
        a(f2);
        byte[] bArr = new byte[f2];
        this.f67746a.get(bArr);
        return new String(bArr, "UTF-8");
    }

    public final void i(int i2) {
        this.f67746a.putInt(i2);
    }

    public final void j(String str) {
        byte[] bArr;
        if (str != null) {
            try {
                bArr = str.getBytes("utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                bArr = new byte[0];
            }
            i(bArr.length);
            this.f67746a.put(bArr);
        }
    }
}
