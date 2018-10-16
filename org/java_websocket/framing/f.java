package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode irt;
    private ByteBuffer iru = org.java_websocket.e.b.cbh();
    private boolean irs = true;
    private boolean irv = false;
    private boolean irw = false;
    private boolean irx = false;
    private boolean iry = false;

    public abstract void caV() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.irt = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean caZ() {
        return this.irw;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cba() {
        return this.irx;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean cbb() {
        return this.iry;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean caY() {
        return this.irs;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode cbc() {
        return this.irt;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer caX() {
        return this.iru;
    }

    public String toString() {
        return "Framedata{ optcode:" + cbc() + ", fin:" + caY() + ", rsv1:" + caZ() + ", rsv2:" + cba() + ", rsv3:" + cbb() + ", payloadlength:[pos:" + this.iru.position() + ", len:" + this.iru.remaining() + "], payload:" + (this.iru.remaining() > 1000 ? "(too big to display)" : new String(this.iru.array())) + '}';
    }

    public void t(ByteBuffer byteBuffer) {
        this.iru = byteBuffer;
    }

    public void oT(boolean z) {
        this.irs = z;
    }

    public void oU(boolean z) {
        this.irw = z;
    }

    public void oV(boolean z) {
        this.irx = z;
    }

    public void oW(boolean z) {
        this.iry = z;
    }

    public void oX(boolean z) {
        this.irv = z;
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
        if (this.irs == fVar.irs && this.irv == fVar.irv && this.irw == fVar.irw && this.irx == fVar.irx && this.iry == fVar.iry && this.irt == fVar.irt) {
            if (this.iru != null) {
                z = this.iru.equals(fVar.iru);
            } else if (fVar.iru != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.irx ? 1 : 0) + (((this.irw ? 1 : 0) + (((this.irv ? 1 : 0) + (((this.iru != null ? this.iru.hashCode() : 0) + ((((this.irs ? 1 : 0) * 31) + this.irt.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.iry ? 1 : 0);
    }
}
