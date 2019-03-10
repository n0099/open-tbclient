package org.apache.thrift;

import org.apache.thrift.protocol.a;
/* loaded from: classes3.dex */
public class e {
    private final org.apache.thrift.protocol.e a;
    private final org.apache.thrift.transport.c b;

    public e() {
        this(new a.C0379a());
    }

    public e(org.apache.thrift.protocol.g gVar) {
        this.b = new org.apache.thrift.transport.c();
        this.a = gVar.a(this.b);
    }

    public void a(a aVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            aVar.a(this.a);
        } finally {
            this.a.y();
        }
    }
}
