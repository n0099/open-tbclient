package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes11.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode qcO;
    private ByteBuffer qcP = org.java_websocket.e.b.eFf();
    private boolean qcN = true;
    private boolean qcQ = false;
    private boolean qcR = false;
    private boolean qcS = false;
    private boolean qcT = false;

    public abstract void eEU() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.qcO = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEX() {
        return this.qcR;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEY() {
        return this.qcS;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eEZ() {
        return this.qcT;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean amr() {
        return this.qcN;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode eFa() {
        return this.qcO;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer eEW() {
        return this.qcP;
    }

    public String toString() {
        return "Framedata{ optcode:" + eFa() + ", fin:" + amr() + ", rsv1:" + eEX() + ", rsv2:" + eEY() + ", rsv3:" + eEZ() + ", payloadlength:[pos:" + this.qcP.position() + ", len:" + this.qcP.remaining() + "], payload:" + (this.qcP.remaining() > 1000 ? "(too big to display)" : new String(this.qcP.array())) + '}';
    }

    public void B(ByteBuffer byteBuffer) {
        this.qcP = byteBuffer;
    }

    public void eB(boolean z) {
        this.qcN = z;
    }

    public void Bj(boolean z) {
        this.qcR = z;
    }

    public void Bk(boolean z) {
        this.qcS = z;
    }

    public void Bl(boolean z) {
        this.qcT = z;
    }

    public void Bm(boolean z) {
        this.qcQ = z;
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
        if (this.qcN == fVar.qcN && this.qcQ == fVar.qcQ && this.qcR == fVar.qcR && this.qcS == fVar.qcS && this.qcT == fVar.qcT && this.qcO == fVar.qcO) {
            if (this.qcP != null) {
                z = this.qcP.equals(fVar.qcP);
            } else if (fVar.qcP != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.qcS ? 1 : 0) + (((this.qcR ? 1 : 0) + (((this.qcQ ? 1 : 0) + (((this.qcP != null ? this.qcP.hashCode() : 0) + ((((this.qcN ? 1 : 0) * 31) + this.qcO.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.qcT ? 1 : 0);
    }
}
