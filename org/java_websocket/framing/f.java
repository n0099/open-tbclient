package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode kuU;
    private ByteBuffer kuV = org.java_websocket.e.b.cPf();
    private boolean kuT = true;
    private boolean kuW = false;
    private boolean kuX = false;
    private boolean kuY = false;
    private boolean kuZ = false;

    public abstract void cOT() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.kuU = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOX() {
        return this.kuX;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOY() {
        return this.kuY;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOZ() {
        return this.kuZ;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cOW() {
        return this.kuT;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cPa() {
        return this.kuU;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer cOV() {
        return this.kuV;
    }

    public String toString() {
        return "Framedata{ optcode:" + cPa() + ", fin:" + cOW() + ", rsv1:" + cOX() + ", rsv2:" + cOY() + ", rsv3:" + cOZ() + ", payloadlength:[pos:" + this.kuV.position() + ", len:" + this.kuV.remaining() + "], payload:" + (this.kuV.remaining() > 1000 ? "(too big to display)" : new String(this.kuV.array())) + '}';
    }

    public void q(ByteBuffer byteBuffer) {
        this.kuV = byteBuffer;
    }

    public void sT(boolean z) {
        this.kuT = z;
    }

    public void sU(boolean z) {
        this.kuX = z;
    }

    public void sV(boolean z) {
        this.kuY = z;
    }

    public void sW(boolean z) {
        this.kuZ = z;
    }

    public void sX(boolean z) {
        this.kuW = z;
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
        if (this.kuT == fVar.kuT && this.kuW == fVar.kuW && this.kuX == fVar.kuX && this.kuY == fVar.kuY && this.kuZ == fVar.kuZ && this.kuU == fVar.kuU) {
            if (this.kuV != null) {
                z = this.kuV.equals(fVar.kuV);
            } else if (fVar.kuV != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.kuY ? 1 : 0) + (((this.kuX ? 1 : 0) + (((this.kuW ? 1 : 0) + (((this.kuV != null ? this.kuV.hashCode() : 0) + ((((this.kuT ? 1 : 0) * 31) + this.kuU.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.kuZ ? 1 : 0);
    }
}
