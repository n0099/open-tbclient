package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode iEF;
    private ByteBuffer iEG = org.java_websocket.e.b.cei();
    private boolean iEE = true;
    private boolean iEH = false;
    private boolean iEI = false;
    private boolean iEJ = false;
    private boolean iEK = false;

    public abstract void cdW() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.iEF = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cea() {
        return this.iEI;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ceb() {
        return this.iEJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cec() {
        return this.iEK;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cdZ() {
        return this.iEE;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode ced() {
        return this.iEF;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cdY() {
        return this.iEG;
    }

    public String toString() {
        return "Framedata{ optcode:" + ced() + ", fin:" + cdZ() + ", rsv1:" + cea() + ", rsv2:" + ceb() + ", rsv3:" + cec() + ", payloadlength:[pos:" + this.iEG.position() + ", len:" + this.iEG.remaining() + "], payload:" + (this.iEG.remaining() > 1000 ? "(too big to display)" : new String(this.iEG.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.iEG = byteBuffer;
    }

    public void pm(boolean z) {
        this.iEE = z;
    }

    public void pn(boolean z) {
        this.iEI = z;
    }

    public void po(boolean z) {
        this.iEJ = z;
    }

    public void pp(boolean z) {
        this.iEK = z;
    }

    public void pq(boolean z) {
        this.iEH = z;
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
        if (this.iEE == fVar.iEE && this.iEH == fVar.iEH && this.iEI == fVar.iEI && this.iEJ == fVar.iEJ && this.iEK == fVar.iEK && this.iEF == fVar.iEF) {
            if (this.iEG != null) {
                z = this.iEG.equals(fVar.iEG);
            } else if (fVar.iEG != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iEJ ? 1 : 0) + (((this.iEI ? 1 : 0) + (((this.iEH ? 1 : 0) + (((this.iEG != null ? this.iEG.hashCode() : 0) + ((((this.iEE ? 1 : 0) * 31) + this.iEF.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.iEK ? 1 : 0);
    }
}
