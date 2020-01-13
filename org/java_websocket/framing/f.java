package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nLF;
    private ByteBuffer nLG = org.java_websocket.e.b.dMs();
    private boolean nLE = true;
    private boolean nLH = false;
    private boolean nLI = false;
    private boolean nLJ = false;
    private boolean nLK = false;

    public abstract void dMh() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nLF = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dMk() {
        return this.nLI;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dMl() {
        return this.nLJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dMm() {
        return this.nLK;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean JY() {
        return this.nLE;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dMn() {
        return this.nLF;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dMj() {
        return this.nLG;
    }

    public String toString() {
        return "Framedata{ optcode:" + dMn() + ", fin:" + JY() + ", rsv1:" + dMk() + ", rsv2:" + dMl() + ", rsv3:" + dMm() + ", payloadlength:[pos:" + this.nLG.position() + ", len:" + this.nLG.remaining() + "], payload:" + (this.nLG.remaining() > 1000 ? "(too big to display)" : new String(this.nLG.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nLG = byteBuffer;
    }

    public void cc(boolean z) {
        this.nLE = z;
    }

    public void wR(boolean z) {
        this.nLI = z;
    }

    public void wS(boolean z) {
        this.nLJ = z;
    }

    public void wT(boolean z) {
        this.nLK = z;
    }

    public void wU(boolean z) {
        this.nLH = z;
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
        if (this.nLE == fVar.nLE && this.nLH == fVar.nLH && this.nLI == fVar.nLI && this.nLJ == fVar.nLJ && this.nLK == fVar.nLK && this.nLF == fVar.nLF) {
            if (this.nLG != null) {
                z = this.nLG.equals(fVar.nLG);
            } else if (fVar.nLG != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nLJ ? 1 : 0) + (((this.nLI ? 1 : 0) + (((this.nLH ? 1 : 0) + (((this.nLG != null ? this.nLG.hashCode() : 0) + ((((this.nLE ? 1 : 0) * 31) + this.nLF.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nLK ? 1 : 0);
    }
}
