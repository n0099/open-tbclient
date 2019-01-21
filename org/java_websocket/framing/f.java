package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode iEG;
    private ByteBuffer iEH = org.java_websocket.e.b.cei();
    private boolean iEF = true;
    private boolean iEI = false;
    private boolean iEJ = false;
    private boolean iEK = false;
    private boolean iEL = false;

    public abstract void cdW() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.iEG = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cea() {
        return this.iEJ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean ceb() {
        return this.iEK;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cec() {
        return this.iEL;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cdZ() {
        return this.iEF;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode ced() {
        return this.iEG;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cdY() {
        return this.iEH;
    }

    public String toString() {
        return "Framedata{ optcode:" + ced() + ", fin:" + cdZ() + ", rsv1:" + cea() + ", rsv2:" + ceb() + ", rsv3:" + cec() + ", payloadlength:[pos:" + this.iEH.position() + ", len:" + this.iEH.remaining() + "], payload:" + (this.iEH.remaining() > 1000 ? "(too big to display)" : new String(this.iEH.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.iEH = byteBuffer;
    }

    public void pm(boolean z) {
        this.iEF = z;
    }

    public void pn(boolean z) {
        this.iEJ = z;
    }

    public void po(boolean z) {
        this.iEK = z;
    }

    public void pp(boolean z) {
        this.iEL = z;
    }

    public void pq(boolean z) {
        this.iEI = z;
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
        if (this.iEF == fVar.iEF && this.iEI == fVar.iEI && this.iEJ == fVar.iEJ && this.iEK == fVar.iEK && this.iEL == fVar.iEL && this.iEG == fVar.iEG) {
            if (this.iEH != null) {
                z = this.iEH.equals(fVar.iEH);
            } else if (fVar.iEH != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iEK ? 1 : 0) + (((this.iEJ ? 1 : 0) + (((this.iEI ? 1 : 0) + (((this.iEH != null ? this.iEH.hashCode() : 0) + ((((this.iEF ? 1 : 0) * 31) + this.iEG.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.iEL ? 1 : 0);
    }
}
