package org.java_websocket.framing;

import android.support.v4.view.PointerIconCompat;
import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public class b extends d {
    private int code;
    private String reason;

    public b() {
        super(Framedata.Opcode.CLOSING);
        setReason("");
        setCode(1000);
    }

    public void setCode(int i) {
        this.code = i;
        if (i == 1015) {
            this.code = 1005;
            this.reason = "";
        }
        cKM();
    }

    public void setReason(String str) {
        if (str == null) {
            str = "";
        }
        this.reason = str;
        cKM();
    }

    public int getCloseCode() {
        return this.code;
    }

    public String getMessage() {
        return this.reason;
    }

    @Override // org.java_websocket.framing.f
    public String toString() {
        return super.toString() + "code: " + this.code;
    }

    @Override // org.java_websocket.framing.d, org.java_websocket.framing.f
    public void cKL() throws InvalidDataException {
        super.cKL();
        if (this.code == 1007 && this.reason == null) {
            throw new InvalidDataException((int) PointerIconCompat.TYPE_CROSSHAIR, "Received text is no valid utf8 string!");
        }
        if (this.code == 1005 && this.reason.length() > 0) {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
        if (this.code > 1015 && this.code < 3000) {
            throw new InvalidDataException(1002, "Trying to send an illegal close code!");
        }
        if (this.code == 1006 || this.code == 1015 || this.code == 1005 || this.code > 4999 || this.code < 1000 || this.code == 1004) {
            throw new InvalidFrameException("closecode must not be sent over the wire: " + this.code);
        }
    }

    @Override // org.java_websocket.framing.f
    public void q(ByteBuffer byteBuffer) {
        this.code = 1005;
        this.reason = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.code = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.code = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(byteBuffer.getShort());
                allocate.position(0);
                this.code = allocate.getInt();
            }
            byteBuffer.reset();
            try {
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(byteBuffer.position() + 2);
                    this.reason = org.java_websocket.e.c.r(byteBuffer);
                    byteBuffer.position(position);
                } catch (IllegalArgumentException e) {
                    throw new InvalidDataException(PointerIconCompat.TYPE_CROSSHAIR);
                }
            } catch (InvalidDataException e2) {
                this.code = PointerIconCompat.TYPE_CROSSHAIR;
                this.reason = null;
            }
        }
    }

    private void cKM() {
        byte[] Ht = org.java_websocket.e.c.Ht(this.reason);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.code);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(Ht.length + 2);
        allocate2.put(allocate);
        allocate2.put(Ht);
        allocate2.rewind();
        super.q(allocate2);
    }

    @Override // org.java_websocket.framing.f, org.java_websocket.framing.Framedata
    public ByteBuffer cKN() {
        return this.code == 1005 ? org.java_websocket.e.b.cKX() : super.cKN();
    }
}
