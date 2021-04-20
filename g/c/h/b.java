package g.c.h;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public class b extends d {

    /* renamed from: h  reason: collision with root package name */
    public int f68640h;
    public String i;

    public b() {
        super(Framedata.Opcode.CLOSING);
        r("");
        q(1000);
    }

    @Override // g.c.h.f, org.java_websocket.framing.Framedata
    public ByteBuffer f() {
        if (this.f68640h == 1005) {
            return g.c.k.b.a();
        }
        return super.f();
    }

    @Override // g.c.h.d, g.c.h.f
    public void h() throws InvalidDataException {
        super.h();
        if (this.f68640h == 1007 && this.i == null) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
        if (this.f68640h == 1005 && this.i.length() > 0) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        int i = this.f68640h;
        if (i > 1015 && i < 3000) {
            throw new InvalidDataException(1002, "Trying to send an illegal close code!");
        }
        int i2 = this.f68640h;
        if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.f68640h);
        }
    }

    @Override // g.c.h.f
    public void j(ByteBuffer byteBuffer) {
        this.f68640h = 1005;
        this.i = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.f68640h = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.f68640h = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(byteBuffer.getShort());
                allocate.position(0);
                this.f68640h = allocate.getInt();
            }
            byteBuffer.reset();
            try {
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(byteBuffer.position() + 2);
                    this.i = g.c.k.c.e(byteBuffer);
                    byteBuffer.position(position);
                } catch (IllegalArgumentException unused) {
                    throw new InvalidDataException(1007);
                }
            } catch (InvalidDataException unused2) {
                this.f68640h = 1007;
                this.i = null;
            }
        }
    }

    public int o() {
        return this.f68640h;
    }

    public String p() {
        return this.i;
    }

    public void q(int i) {
        this.f68640h = i;
        if (i == 1015) {
            this.f68640h = 1005;
            this.i = "";
        }
        s();
    }

    public void r(String str) {
        if (str == null) {
            str = "";
        }
        this.i = str;
        s();
    }

    public final void s() {
        byte[] f2 = g.c.k.c.f(this.i);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.f68640h);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(f2.length + 2);
        allocate2.put(allocate);
        allocate2.put(f2);
        allocate2.rewind();
        super.j(allocate2);
    }

    @Override // g.c.h.f
    public String toString() {
        return super.toString() + "code: " + this.f68640h;
    }
}
