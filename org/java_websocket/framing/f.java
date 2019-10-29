package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kxV;
    private ByteBuffer kxW = org.java_websocket.e.b.cNY();
    private boolean kxU = true;
    private boolean kxX = false;
    private boolean kxY = false;
    private boolean kxZ = false;
    private boolean kya = false;

    public abstract void cNM() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kxV = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNQ() {
        return this.kxY;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNR() {
        return this.kxZ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNS() {
        return this.kya;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cNP() {
        return this.kxU;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cNT() {
        return this.kxV;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cNO() {
        return this.kxW;
    }

    public String toString() {
        return "Framedata{ optcode:" + cNT() + ", fin:" + cNP() + ", rsv1:" + cNQ() + ", rsv2:" + cNR() + ", rsv3:" + cNS() + ", payloadlength:[pos:" + this.kxW.position() + ", len:" + this.kxW.remaining() + "], payload:" + (this.kxW.remaining() > 1000 ? "(too big to display)" : new String(this.kxW.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kxW = byteBuffer;
    }

    public void sB(boolean z) {
        this.kxU = z;
    }

    public void sC(boolean z) {
        this.kxY = z;
    }

    public void sD(boolean z) {
        this.kxZ = z;
    }

    public void sE(boolean z) {
        this.kya = z;
    }

    public void sF(boolean z) {
        this.kxX = z;
    }

    public static f b(Framedata.Opcode opcode) {
        if (opcode == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (opcode) {
            case PING:
                return new g();
            case PONG:
                return new h();
            case TEXT:
                return new i();
            case BINARY:
                return new a();
            case CLOSING:
                return new b();
            case CONTINUOUS:
                return new c();
            default:
                throw new IllegalArgumentException("Supplied opcode is invalid");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.kxU == fVar.kxU && this.kxX == fVar.kxX && this.kxY == fVar.kxY && this.kxZ == fVar.kxZ && this.kya == fVar.kya && this.kxV == fVar.kxV) {
            if (this.kxW != null) {
                z = this.kxW.equals(fVar.kxW);
            } else if (fVar.kxW != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kxZ ? 1 : 0) + (((this.kxY ? 1 : 0) + (((this.kxX ? 1 : 0) + (((this.kxW != null ? this.kxW.hashCode() : 0) + ((((this.kxU ? 1 : 0) * 31) + this.kxV.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kya ? 1 : 0);
    }
}
