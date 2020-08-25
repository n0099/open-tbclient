package com.xiaomi.push;

import com.baidu.android.common.logging.Log;
import com.xiaomi.push.je;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class jo extends je {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = Log.FILE_LIMETE;
    private static int f = 104857600;

    /* loaded from: classes7.dex */
    public static class a extends je.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.je.a, com.xiaomi.push.jk
        public ji a(js jsVar) {
            jo joVar = new jo(jsVar, this.f778a, this.b);
            if (this.a != 0) {
                joVar.b(this.a);
            }
            return joVar;
        }
    }

    public jo(js jsVar, boolean z, boolean z2) {
        super(jsVar, z, z2);
    }

    @Override // com.xiaomi.push.je, com.xiaomi.push.ji
    public jg a() {
        byte a2 = a();
        int a3 = a();
        if (a3 > c) {
            throw new jj(3, "Thrift list size " + a3 + " out of range!");
        }
        return new jg(a2, a3);
    }

    @Override // com.xiaomi.push.je, com.xiaomi.push.ji
    public jh a() {
        byte a2 = a();
        byte a3 = a();
        int a4 = a();
        if (a4 > b) {
            throw new jj(3, "Thrift map size " + a4 + " out of range!");
        }
        return new jh(a2, a3, a4);
    }

    @Override // com.xiaomi.push.je, com.xiaomi.push.ji
    public jm a() {
        byte a2 = a();
        int a3 = a();
        if (a3 > d) {
            throw new jj(3, "Thrift set size " + a3 + " out of range!");
        }
        return new jm(a2, a3);
    }

    @Override // com.xiaomi.push.je, com.xiaomi.push.ji
    public String a() {
        int a2 = a();
        if (a2 > e) {
            throw new jj(3, "Thrift string size " + a2 + " out of range!");
        }
        if (this.a.b() >= a2) {
            try {
                String str = new String(this.a.m496a(), this.a.a(), a2, "UTF-8");
                this.a.a(a2);
                return str;
            } catch (UnsupportedEncodingException e2) {
                throw new jc("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(a2);
    }

    @Override // com.xiaomi.push.je, com.xiaomi.push.ji
    public ByteBuffer a() {
        int a2 = a();
        if (a2 > f) {
            throw new jj(3, "Thrift binary size " + a2 + " out of range!");
        }
        c(a2);
        if (this.a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(this.a.m496a(), this.a.a(), a2);
            this.a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        this.a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }
}
