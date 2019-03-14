package org.apache.thrift.protocol;

import com.baidu.android.common.logging.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.http.protocol.HTTP;
import org.apache.thrift.protocol.a;
/* loaded from: classes3.dex */
public class k extends org.apache.thrift.protocol.a {
    private static int f = 10000;
    private static int g = 10000;
    private static int h = 10000;
    private static int i = Log.FILE_LIMETE;
    private static int j = 104857600;

    /* loaded from: classes3.dex */
    public static class a extends a.C0473a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // org.apache.thrift.protocol.a.C0473a, org.apache.thrift.protocol.g
        public e a(org.apache.thrift.transport.d dVar) {
            k kVar = new k(dVar, this.a, this.b);
            if (this.c != 0) {
                kVar.c(this.c);
            }
            return kVar;
        }
    }

    public k(org.apache.thrift.transport.d dVar, boolean z, boolean z2) {
        super(dVar, z, z2);
    }

    @Override // org.apache.thrift.protocol.a, org.apache.thrift.protocol.e
    public d k() {
        byte r = r();
        byte r2 = r();
        int t = t();
        if (t > f) {
            throw new f(3, "Thrift map size " + t + " out of range!");
        }
        return new d(r, r2, t);
    }

    @Override // org.apache.thrift.protocol.a, org.apache.thrift.protocol.e
    public c m() {
        byte r = r();
        int t = t();
        if (t > g) {
            throw new f(3, "Thrift list size " + t + " out of range!");
        }
        return new c(r, t);
    }

    @Override // org.apache.thrift.protocol.a, org.apache.thrift.protocol.e
    public i o() {
        byte r = r();
        int t = t();
        if (t > h) {
            throw new f(3, "Thrift set size " + t + " out of range!");
        }
        return new i(r, t);
    }

    @Override // org.apache.thrift.protocol.a, org.apache.thrift.protocol.e
    public String w() {
        int t = t();
        if (t > i) {
            throw new f(3, "Thrift string size " + t + " out of range!");
        }
        if (this.e.c() >= t) {
            try {
                String str = new String(this.e.a(), this.e.b(), t, HTTP.UTF_8);
                this.e.a(t);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new org.apache.thrift.f("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(t);
    }

    @Override // org.apache.thrift.protocol.a, org.apache.thrift.protocol.e
    public ByteBuffer x() {
        int t = t();
        if (t > j) {
            throw new f(3, "Thrift binary size " + t + " out of range!");
        }
        d(t);
        if (this.e.c() >= t) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.a(), this.e.b(), t);
            this.e.a(t);
            return wrap;
        }
        byte[] bArr = new byte[t];
        this.e.d(bArr, 0, t);
        return ByteBuffer.wrap(bArr);
    }
}
