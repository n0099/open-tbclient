package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode ncG;
    private ByteBuffer ncH = org.java_websocket.e.b.dFR();
    private boolean ncF = true;
    private boolean ncI = false;
    private boolean ncJ = false;
    private boolean ncK = false;
    private boolean ncL = false;

    public abstract void dFG() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.ncG = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dFJ() {
        return this.ncJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dFK() {
        return this.ncK;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dFL() {
        return this.ncL;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean JC() {
        return this.ncF;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dFM() {
        return this.ncG;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dFI() {
        return this.ncH;
    }

    public String toString() {
        return "Framedata{ optcode:" + dFM() + ", fin:" + JC() + ", rsv1:" + dFJ() + ", rsv2:" + dFK() + ", rsv3:" + dFL() + ", payloadlength:[pos:" + this.ncH.position() + ", len:" + this.ncH.remaining() + "], payload:" + (this.ncH.remaining() > 1000 ? "(too big to display)" : new String(this.ncH.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.ncH = byteBuffer;
    }

    public void bX(boolean z) {
        this.ncF = z;
    }

    public void wf(boolean z) {
        this.ncJ = z;
    }

    public void wg(boolean z) {
        this.ncK = z;
    }

    public void wh(boolean z) {
        this.ncL = z;
    }

    public void wi(boolean z) {
        this.ncI = z;
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
        if (this.ncF == fVar.ncF && this.ncI == fVar.ncI && this.ncJ == fVar.ncJ && this.ncK == fVar.ncK && this.ncL == fVar.ncL && this.ncG == fVar.ncG) {
            if (this.ncH != null) {
                z = this.ncH.equals(fVar.ncH);
            } else if (fVar.ncH != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.ncK ? 1 : 0) + (((this.ncJ ? 1 : 0) + (((this.ncI ? 1 : 0) + (((this.ncH != null ? this.ncH.hashCode() : 0) + ((((this.ncF ? 1 : 0) * 31) + this.ncG.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.ncL ? 1 : 0);
    }
}
