package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
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
        eEV();
    }

    public void setReason(String str) {
        if (str == null) {
            str = "";
        }
        this.reason = str;
        eEV();
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
    public void eEU() throws InvalidDataException {
        super.eEU();
        if (this.code == 1007 && this.reason == null) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
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
    public void B(ByteBuffer byteBuffer) {
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
                    this.reason = org.java_websocket.e.c.C(byteBuffer);
                    byteBuffer.position(position);
                } catch (IllegalArgumentException e) {
                    throw new InvalidDataException(1007);
                }
            } catch (InvalidDataException e2) {
                this.code = 1007;
                this.reason = null;
            }
        }
    }

    private void eEV() {
        byte[] aaG = org.java_websocket.e.c.aaG(this.reason);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.code);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(aaG.length + 2);
        allocate2.put(allocate);
        allocate2.put(aaG);
        allocate2.rewind();
        super.B(allocate2);
    }

    @Override // org.java_websocket.framing.f, org.java_websocket.framing.Framedata
    public ByteBuffer eEW() {
        return this.code == 1005 ? org.java_websocket.e.b.eFf() : super.eEW();
    }
}
