package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nLK;
    private ByteBuffer nLL = org.java_websocket.e.b.dMu();
    private boolean nLJ = true;
    private boolean nLM = false;
    private boolean nLN = false;
    private boolean nLO = false;
    private boolean nLP = false;

    public abstract void dMj() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nLK = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dMm() {
        return this.nLN;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dMn() {
        return this.nLO;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dMo() {
        return this.nLP;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean JY() {
        return this.nLJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dMp() {
        return this.nLK;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dMl() {
        return this.nLL;
    }

    public String toString() {
        return "Framedata{ optcode:" + dMp() + ", fin:" + JY() + ", rsv1:" + dMm() + ", rsv2:" + dMn() + ", rsv3:" + dMo() + ", payloadlength:[pos:" + this.nLL.position() + ", len:" + this.nLL.remaining() + "], payload:" + (this.nLL.remaining() > 1000 ? "(too big to display)" : new String(this.nLL.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nLL = byteBuffer;
    }

    public void cc(boolean z) {
        this.nLJ = z;
    }

    public void wR(boolean z) {
        this.nLN = z;
    }

    public void wS(boolean z) {
        this.nLO = z;
    }

    public void wT(boolean z) {
        this.nLP = z;
    }

    public void wU(boolean z) {
        this.nLM = z;
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
        if (this.nLJ == fVar.nLJ && this.nLM == fVar.nLM && this.nLN == fVar.nLN && this.nLO == fVar.nLO && this.nLP == fVar.nLP && this.nLK == fVar.nLK) {
            if (this.nLL != null) {
                z = this.nLL.equals(fVar.nLL);
            } else if (fVar.nLL != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nLO ? 1 : 0) + (((this.nLN ? 1 : 0) + (((this.nLM ? 1 : 0) + (((this.nLL != null ? this.nLL.hashCode() : 0) + ((((this.nLJ ? 1 : 0) * 31) + this.nLK.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nLP ? 1 : 0);
    }
}
