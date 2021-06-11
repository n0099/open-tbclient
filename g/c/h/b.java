package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public class b extends d {

    /* renamed from: h  reason: collision with root package name */
    public int f71633h;

    /* renamed from: i  reason: collision with root package name */
    public String f71634i;

    public b() {
        super(Framedata.Opcode.CLOSING);
        r("");
        q(1000);
    }

    @Override // g.c.h.f, org.java_websocket.framing.Framedata
    public ByteBuffer a() {
        if (this.f71633h == 1005) {
            return g.c.k.b.a();
        }
        return super.a();
    }

    @Override // g.c.h.d, g.c.h.f
    public void h() throws InvalidDataException {
        super.h();
        if (this.f71633h == 1007 && this.f71634i == null) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
        if (this.f71633h == 1005 && this.f71634i.length() > 0) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        int i2 = this.f71633h;
        if (i2 > 1015 && i2 < 3000) {
            throw new InvalidDataException(1002, "Trying to send an illegal close code!");
        }
        int i3 = this.f71633h;
        if (i3 == 1006 || i3 == 1015 || i3 == 1005 || i3 > 4999 || i3 < 1000 || i3 == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f71633h);
        }
    }

    @Override // g.c.h.f
    public void j(ByteBuffer byteBuffer) {
        this.f71633h = 1005;
        this.f71634i = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.f71633h = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.f71633h = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(byteBuffer.getShort());
                allocate.position(0);
                this.f71633h = allocate.getInt();
            }
            byteBuffer.reset();
            try {
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(byteBuffer.position() + 2);
                    this.f71634i = g.c.k.c.e(byteBuffer);
                    byteBuffer.position(position);
                } catch (IllegalArgumentException unused) {
                    throw new InvalidDataException(1007);
                }
            } catch (InvalidDataException unused2) {
                this.f71633h = 1007;
                this.f71634i = null;
            }
        }
    }

    public int o() {
        return this.f71633h;
    }

    public String p() {
        return this.f71634i;
    }

    public void q(int i2) {
        this.f71633h = i2;
        if (i2 == 1015) {
            this.f71633h = 1005;
            this.f71634i = "";
        }
        s();
    }

    public void r(String str) {
        if (str == null) {
            str = "";
        }
        this.f71634i = str;
        s();
    }

    public final void s() {
        byte[] f2 = g.c.k.c.f(this.f71634i);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.f71633h);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(f2.length + 2);
        allocate2.put(allocate);
        allocate2.put(f2);
        allocate2.rewind();
        super.j(allocate2);
    }

    @Override // g.c.h.f
    public String toString() {
        return super.toString() + "code: " + this.f71633h;
    }
}
