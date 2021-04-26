package d.r.b.a.a.f.e;

import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.Marshallable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public abstract class g extends Marshallable {
    @Override // d.r.b.a.a.f.e.f
    public byte[] c() {
        ByteBuffer allocate = ByteBuffer.allocate(k());
        this.f67017a = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        b(this.f67017a);
        l();
        return this.f67017a.array();
    }

    public abstract int k();

    public abstract void l();
}
