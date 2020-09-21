package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes17.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode oML;
    private ByteBuffer oMM = org.java_websocket.e.b.enG();
    private boolean oMK = true;
    private boolean oMN = false;
    private boolean oMO = false;
    private boolean oMP = false;
    private boolean oMQ = false;

    public abstract void env() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.oML = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean eny() {
        return this.oMO;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean enz() {
        return this.oMP;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean enA() {
        return this.oMQ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean afm() {
        return this.oMK;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode enB() {
        return this.oML;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer enx() {
        return this.oMM;
    }

    public String toString() {
        return "Framedata{ optcode:" + enB() + ", fin:" + afm() + ", rsv1:" + eny() + ", rsv2:" + enz() + ", rsv3:" + enA() + ", payloadlength:[pos:" + this.oMM.position() + ", len:" + this.oMM.remaining() + "], payload:" + (this.oMM.remaining() > 1000 ? "(too big to display)" : new String(this.oMM.array())) + '}';
    }

    public void A(ByteBuffer byteBuffer) {
        this.oMM = byteBuffer;
    }

    public void dJ(boolean z) {
        this.oMK = z;
    }

    public void zj(boolean z) {
        this.oMO = z;
    }

    public void zk(boolean z) {
        this.oMP = z;
    }

    public void zl(boolean z) {
        this.oMQ = z;
    }

    public void zm(boolean z) {
        this.oMN = z;
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
        if (this.oMK == fVar.oMK && this.oMN == fVar.oMN && this.oMO == fVar.oMO && this.oMP == fVar.oMP && this.oMQ == fVar.oMQ && this.oML == fVar.oML) {
            if (this.oMM != null) {
                z = this.oMM.equals(fVar.oMM);
            } else if (fVar.oMM != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.oMP ? 1 : 0) + (((this.oMO ? 1 : 0) + (((this.oMN ? 1 : 0) + (((this.oMM != null ? this.oMM.hashCode() : 0) + ((((this.oMK ? 1 : 0) * 31) + this.oML.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.oMQ ? 1 : 0);
    }
}
