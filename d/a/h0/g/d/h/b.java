package d.a.h0.g.d.h;

import d.a.h0.g.d.g.e;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class b {
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static e a(byte[] bArr) {
        e eVar = null;
        if (bArr == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b2 = wrap.get();
        byte b3 = wrap.get();
        if (b2 == -27 && b3 == -89) {
            eVar = new e();
            wrap.get();
            wrap.get();
            eVar.p(wrap.get());
            eVar.n(wrap.get());
            int i2 = wrap.getShort();
            eVar.o(i2);
            int i3 = wrap.getInt();
            eVar.j(i3);
            byte[] bArr2 = new byte[i2];
            wrap.get(bArr2, 0, i2);
            eVar.m(bArr2);
            if (i3 > 0) {
                byte[] bArr3 = new byte[i3];
                wrap.get(bArr3, 0, i3);
                eVar.i(bArr3);
            }
        }
        return eVar;
    }

    public static byte[] b(e eVar) {
        if (eVar == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(eVar.g() + 12 + eVar.b());
        allocate.put((byte) -27);
        allocate.put((byte) -89);
        if (eVar.d() != null && eVar.d().length == 2) {
            allocate.put(eVar.d()[0]);
            allocate.put(eVar.d()[1]);
            allocate.put(eVar.h());
            allocate.put(eVar.f());
            if (eVar.e() != null && eVar.e().length != 0) {
                int length = eVar.e().length;
                allocate.put((byte) ((length >> 8) & 255));
                allocate.put((byte) (length & 255));
                if (eVar.a() != null && eVar.a().length != 0) {
                    allocate.putInt(eVar.a().length);
                } else {
                    allocate.putInt(0);
                }
                if (eVar.e() != null) {
                    allocate.put(eVar.e());
                }
                if (eVar.a() != null) {
                    allocate.put(eVar.a());
                }
                return allocate.array();
            }
        }
        return null;
    }
}
