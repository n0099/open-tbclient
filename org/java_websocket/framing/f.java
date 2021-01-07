package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qrF;
    private ByteBuffer qrG = org.java_websocket.e.b.eNS();
    private boolean qrE = true;
    private boolean qrH = false;
    private boolean qrI = false;
    private boolean qrJ = false;
    private boolean qrK = false;

    public abstract void eNH() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qrF = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eNK() {
        return this.qrI;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eNL() {
        return this.qrJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eNM() {
        return this.qrK;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean aqf() {
        return this.qrE;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eNN() {
        return this.qrF;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eNJ() {
        return this.qrG;
    }

    public String toString() {
        return "Framedata{ optcode:" + eNN() + ", fin:" + aqf() + ", rsv1:" + eNK() + ", rsv2:" + eNL() + ", rsv3:" + eNM() + ", payloadlength:[pos:" + this.qrG.position() + ", len:" + this.qrG.remaining() + "], payload:" + (this.qrG.remaining() > 1000 ? "(too big to display)" : new String(this.qrG.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qrG = byteBuffer;
    }

    public void fc(boolean z) {
        this.qrE = z;
    }

    public void CJ(boolean z) {
        this.qrI = z;
    }

    public void CK(boolean z) {
        this.qrJ = z;
    }

    public void CL(boolean z) {
        this.qrK = z;
    }

    public void CM(boolean z) {
        this.qrH = z;
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
        if (this.qrE == fVar.qrE && this.qrH == fVar.qrH && this.qrI == fVar.qrI && this.qrJ == fVar.qrJ && this.qrK == fVar.qrK && this.qrF == fVar.qrF) {
            if (this.qrG != null) {
                z = this.qrG.equals(fVar.qrG);
            } else if (fVar.qrG != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qrJ ? 1 : 0) + (((this.qrI ? 1 : 0) + (((this.qrH ? 1 : 0) + (((this.qrG != null ? this.qrG.hashCode() : 0) + ((((this.qrE ? 1 : 0) * 31) + this.qrF.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qrK ? 1 : 0);
    }
}
