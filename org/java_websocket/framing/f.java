package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode iru;
    private ByteBuffer irv = org.java_websocket.e.b.cbh();
    private boolean irt = true;
    private boolean irw = false;
    private boolean irx = false;
    private boolean iry = false;
    private boolean irz = false;

    public abstract void caV() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.iru = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean caZ() {
        return this.irx;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cba() {
        return this.iry;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cbb() {
        return this.irz;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean caY() {
        return this.irt;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cbc() {
        return this.iru;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer caX() {
        return this.irv;
    }

    public String toString() {
        return "Framedata{ optcode:" + cbc() + ", fin:" + caY() + ", rsv1:" + caZ() + ", rsv2:" + cba() + ", rsv3:" + cbb() + ", payloadlength:[pos:" + this.irv.position() + ", len:" + this.irv.remaining() + "], payload:" + (this.irv.remaining() > 1000 ? "(too big to display)" : new String(this.irv.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.irv = byteBuffer;
    }

    public void oT(boolean z) {
        this.irt = z;
    }

    public void oU(boolean z) {
        this.irx = z;
    }

    public void oV(boolean z) {
        this.iry = z;
    }

    public void oW(boolean z) {
        this.irz = z;
    }

    public void oX(boolean z) {
        this.irw = z;
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
        if (this.irt == fVar.irt && this.irw == fVar.irw && this.irx == fVar.irx && this.iry == fVar.iry && this.irz == fVar.irz && this.iru == fVar.iru) {
            if (this.irv != null) {
                z = this.irv.equals(fVar.irv);
            } else if (fVar.irv != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.iry ? 1 : 0) + (((this.irx ? 1 : 0) + (((this.irw ? 1 : 0) + (((this.irv != null ? this.irv.hashCode() : 0) + ((((this.irt ? 1 : 0) * 31) + this.iru.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.irz ? 1 : 0);
    }
}
