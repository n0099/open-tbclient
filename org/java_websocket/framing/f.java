package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qxH;
    private ByteBuffer qxI = org.java_websocket.e.b.eMA();
    private boolean qxG = true;
    private boolean qxJ = false;
    private boolean qxK = false;
    private boolean qxL = false;
    private boolean qxM = false;

    public abstract void eMp() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qxH = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMs() {
        return this.qxK;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMt() {
        return this.qxL;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eMu() {
        return this.qxM;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean amI() {
        return this.qxG;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eMv() {
        return this.qxH;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eMr() {
        return this.qxI;
    }

    public String toString() {
        return "Framedata{ optcode:" + eMv() + ", fin:" + amI() + ", rsv1:" + eMs() + ", rsv2:" + eMt() + ", rsv3:" + eMu() + ", payloadlength:[pos:" + this.qxI.position() + ", len:" + this.qxI.remaining() + "], payload:" + (this.qxI.remaining() > 1000 ? "(too big to display)" : new String(this.qxI.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.qxI = byteBuffer;
    }

    public void fa(boolean z) {
        this.qxG = z;
    }

    public void CZ(boolean z) {
        this.qxK = z;
    }

    public void Da(boolean z) {
        this.qxL = z;
    }

    public void Db(boolean z) {
        this.qxM = z;
    }

    public void Dc(boolean z) {
        this.qxJ = z;
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
        if (this.qxG == fVar.qxG && this.qxJ == fVar.qxJ && this.qxK == fVar.qxK && this.qxL == fVar.qxL && this.qxM == fVar.qxM && this.qxH == fVar.qxH) {
            if (this.qxI != null) {
                z = this.qxI.equals(fVar.qxI);
            } else if (fVar.qxI != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qxL ? 1 : 0) + (((this.qxK ? 1 : 0) + (((this.qxJ ? 1 : 0) + (((this.qxI != null ? this.qxI.hashCode() : 0) + ((((this.qxG ? 1 : 0) * 31) + this.qxH.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qxM ? 1 : 0);
    }
}
