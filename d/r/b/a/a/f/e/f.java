package d.r.b.a.a.f.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f67017a;

    public void a(int i2) throws Exception {
        ByteBuffer byteBuffer = this.f67017a;
        if (byteBuffer != null) {
            if (byteBuffer.capacity() - this.f67017a.position() < i2) {
                throw new Exception("cause stack overflow exception when unmarshall the pack");
            }
            return;
        }
        throw new Exception("call supper unmarshall before pop data");
    }

    public void b(ByteBuffer byteBuffer) {
    }

    public byte[] c() {
        if (this.f67017a == null) {
            ByteBuffer allocate = ByteBuffer.allocate(1);
            this.f67017a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        b(this.f67017a);
        return this.f67017a.array();
    }

    public void d(ByteBuffer byteBuffer) {
    }

    public void e(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f67017a = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        d(this.f67017a);
    }
}
