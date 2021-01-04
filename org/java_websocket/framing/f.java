package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qpX;
    private ByteBuffer qpY = org.java_websocket.e.b.eNo();
    private boolean qpW = true;
    private boolean qpZ = false;
    private boolean qqa = false;
    private boolean qqb = false;
    private boolean qqc = false;

    public abstract void eNd() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qpX = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eNg() {
        return this.qqa;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eNh() {
        return this.qqb;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eNi() {
        return this.qqc;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean aqe() {
        return this.qpW;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eNj() {
        return this.qpX;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eNf() {
        return this.qpY;
    }

    public String toString() {
        return "Framedata{ optcode:" + eNj() + ", fin:" + aqe() + ", rsv1:" + eNg() + ", rsv2:" + eNh() + ", rsv3:" + eNi() + ", payloadlength:[pos:" + this.qpY.position() + ", len:" + this.qpY.remaining() + "], payload:" + (this.qpY.remaining() > 1000 ? "(too big to display)" : new String(this.qpY.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qpY = byteBuffer;
    }

    public void fc(boolean z) {
        this.qpW = z;
    }

    public void CJ(boolean z) {
        this.qqa = z;
    }

    public void CK(boolean z) {
        this.qqb = z;
    }

    public void CL(boolean z) {
        this.qqc = z;
    }

    public void CM(boolean z) {
        this.qpZ = z;
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
        if (this.qpW == fVar.qpW && this.qpZ == fVar.qpZ && this.qqa == fVar.qqa && this.qqb == fVar.qqb && this.qqc == fVar.qqc && this.qpX == fVar.qpX) {
            if (this.qpY != null) {
                z = this.qpY.equals(fVar.qpY);
            } else if (fVar.qpY != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qqb ? 1 : 0) + (((this.qqa ? 1 : 0) + (((this.qpZ ? 1 : 0) + (((this.qpY != null ? this.qpY.hashCode() : 0) + ((((this.qpW ? 1 : 0) * 31) + this.qpX.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qqc ? 1 : 0);
    }
}
