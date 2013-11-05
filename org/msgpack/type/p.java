package org.msgpack.type;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
class p extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f2918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str) {
        this.f2918a = str;
    }

    @Override // org.msgpack.type.RawValue
    public byte[] b() {
        try {
            return this.f2918a.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new MessageTypeException(e);
        }
    }

    @Override // org.msgpack.type.RawValue
    public String c() {
        return this.f2918a;
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.a(this.f2918a);
    }

    @Override // org.msgpack.type.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.isRawValue()) {
                if (rVar.getClass() == p.class) {
                    return this.f2918a.equals(((p) rVar).f2918a);
                }
                return Arrays.equals(b(), rVar.asRawValue().b());
            }
            return false;
        }
        return false;
    }
}
