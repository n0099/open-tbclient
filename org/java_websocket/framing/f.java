package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode ktO;
    private ByteBuffer ktP = org.java_websocket.e.b.cOK();
    private boolean ktN = true;
    private boolean ktQ = false;
    private boolean ktR = false;
    private boolean ktS = false;
    private boolean ktT = false;

    public abstract void cOy() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.ktO = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOC() {
        return this.ktR;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOD() {
        return this.ktS;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOE() {
        return this.ktT;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOB() {
        return this.ktN;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cOF() {
        return this.ktO;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cOA() {
        return this.ktP;
    }

    public String toString() {
        return "Framedata{ optcode:" + cOF() + ", fin:" + cOB() + ", rsv1:" + cOC() + ", rsv2:" + cOD() + ", rsv3:" + cOE() + ", payloadlength:[pos:" + this.ktP.position() + ", len:" + this.ktP.remaining() + "], payload:" + (this.ktP.remaining() > 1000 ? "(too big to display)" : new String(this.ktP.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.ktP = byteBuffer;
    }

    public void sS(boolean z) {
        this.ktN = z;
    }

    public void sT(boolean z) {
        this.ktR = z;
    }

    public void sU(boolean z) {
        this.ktS = z;
    }

    public void sV(boolean z) {
        this.ktT = z;
    }

    public void sW(boolean z) {
        this.ktQ = z;
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
        if (this.ktN == fVar.ktN && this.ktQ == fVar.ktQ && this.ktR == fVar.ktR && this.ktS == fVar.ktS && this.ktT == fVar.ktT && this.ktO == fVar.ktO) {
            if (this.ktP != null) {
                z = this.ktP.equals(fVar.ktP);
            } else if (fVar.ktP != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.ktS ? 1 : 0) + (((this.ktR ? 1 : 0) + (((this.ktQ ? 1 : 0) + (((this.ktP != null ? this.ktP.hashCode() : 0) + ((((this.ktN ? 1 : 0) * 31) + this.ktO.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.ktT ? 1 : 0);
    }
}
