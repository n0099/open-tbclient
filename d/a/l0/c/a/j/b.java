package d.a.l0.c.a.j;

import d.a.l0.c.a.i.e;
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
            eVar.r(wrap.get());
            eVar.p(wrap.get());
            int i2 = wrap.getShort();
            eVar.q(i2);
            int i3 = wrap.getInt();
            eVar.k(i3);
            eVar.l(wrap.getLong());
            byte[] bArr2 = new byte[i2];
            wrap.get(bArr2, 0, i2);
            eVar.o(bArr2);
            if (i3 > 0) {
                byte[] bArr3 = new byte[i3];
                wrap.get(bArr3, 0, i3);
                eVar.j(bArr3);
            }
        }
        return eVar;
    }

    public static byte[] b(e eVar) {
        if (eVar == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(eVar.h() + 20 + eVar.b());
        allocate.put((byte) -27);
        allocate.put((byte) -89);
        if (eVar.e() != null && eVar.e().length == 2) {
            allocate.put(eVar.e()[0]);
            allocate.put(eVar.e()[1]);
            allocate.put(eVar.i());
            allocate.put(eVar.g());
            if (eVar.f() != null && eVar.f().length != 0) {
                int length = eVar.f().length;
                allocate.put((byte) ((length >> 8) & 255));
                allocate.put((byte) (length & 255));
                if (eVar.a() != null && eVar.a().length != 0) {
                    allocate.putInt(eVar.a().length);
                } else {
                    allocate.putInt(0);
                }
                allocate.putLong(eVar.c());
                if (eVar.f() != null) {
                    allocate.put(eVar.f());
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
