package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nii;
    private ByteBuffer nij = org.java_websocket.e.b.dHg();
    private boolean nih = true;
    private boolean nik = false;
    private boolean nil = false;
    private boolean nim = false;
    private boolean nin = false;

    public abstract void dGV() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nii = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dGY() {
        return this.nil;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dGZ() {
        return this.nim;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dHa() {
        return this.nin;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Ue() {
        return this.nih;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dHb() {
        return this.nii;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dGX() {
        return this.nij;
    }

    public String toString() {
        return "Framedata{ optcode:" + dHb() + ", fin:" + Ue() + ", rsv1:" + dGY() + ", rsv2:" + dGZ() + ", rsv3:" + dHa() + ", payloadlength:[pos:" + this.nij.position() + ", len:" + this.nij.remaining() + "], payload:" + (this.nij.remaining() > 1000 ? "(too big to display)" : new String(this.nij.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nij = byteBuffer;
    }

    public void dg(boolean z) {
        this.nih = z;
    }

    public void wH(boolean z) {
        this.nil = z;
    }

    public void wI(boolean z) {
        this.nim = z;
    }

    public void wJ(boolean z) {
        this.nin = z;
    }

    public void wK(boolean z) {
        this.nik = z;
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
        if (this.nih == fVar.nih && this.nik == fVar.nik && this.nil == fVar.nil && this.nim == fVar.nim && this.nin == fVar.nin && this.nii == fVar.nii) {
            if (this.nij != null) {
                z = this.nij.equals(fVar.nij);
            } else if (fVar.nij != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nim ? 1 : 0) + (((this.nil ? 1 : 0) + (((this.nik ? 1 : 0) + (((this.nij != null ? this.nij.hashCode() : 0) + ((((this.nih ? 1 : 0) * 31) + this.nii.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nin ? 1 : 0);
    }
}
