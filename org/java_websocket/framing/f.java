package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class f implements Framedata {
    private Framedata.Opcode nif;
    private ByteBuffer nig = org.java_websocket.e.b.dHk();
    private boolean nie = true;
    private boolean nih = false;
    private boolean nii = false;
    private boolean nij = false;
    private boolean nik = false;

    public abstract void dGZ() throws InvalidDataException;

    public f(Framedata.Opcode opcode) {
        this.nif = opcode;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dHc() {
        return this.nii;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dHd() {
        return this.nij;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean dHe() {
        return this.nik;
    }

    @Override // org.java_websocket.framing.Framedata
    public boolean Uf() {
        return this.nie;
    }

    @Override // org.java_websocket.framing.Framedata
    public Framedata.Opcode dHf() {
        return this.nif;
    }

    @Override // org.java_websocket.framing.Framedata
    public ByteBuffer dHb() {
        return this.nig;
    }

    public String toString() {
        return "Framedata{ optcode:" + dHf() + ", fin:" + Uf() + ", rsv1:" + dHc() + ", rsv2:" + dHd() + ", rsv3:" + dHe() + ", payloadlength:[pos:" + this.nig.position() + ", len:" + this.nig.remaining() + "], payload:" + (this.nig.remaining() > 1000 ? "(too big to display)" : new String(this.nig.array())) + '}';
    }

    public void u(ByteBuffer byteBuffer) {
        this.nig = byteBuffer;
    }

    public void dg(boolean z) {
        this.nie = z;
    }

    public void wH(boolean z) {
        this.nii = z;
    }

    public void wI(boolean z) {
        this.nij = z;
    }

    public void wJ(boolean z) {
        this.nik = z;
    }

    public void wK(boolean z) {
        this.nih = z;
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
        if (this.nie == fVar.nie && this.nih == fVar.nih && this.nii == fVar.nii && this.nij == fVar.nij && this.nik == fVar.nik && this.nif == fVar.nif) {
            if (this.nig != null) {
                z = this.nig.equals(fVar.nig);
            } else if (fVar.nig != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return (((this.nij ? 1 : 0) + (((this.nii ? 1 : 0) + (((this.nih ? 1 : 0) + (((this.nig != null ? this.nig.hashCode() : 0) + ((((this.nie ? 1 : 0) * 31) + this.nif.hashCode()) * 31)) * 31)) * 31)) * 31)) * 31) + (this.nik ? 1 : 0);
    }
}
