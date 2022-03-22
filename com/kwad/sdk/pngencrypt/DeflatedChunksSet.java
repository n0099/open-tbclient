package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes7.dex */
public class DeflatedChunksSet {
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public State f40597b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f40598c;

    /* renamed from: f  reason: collision with root package name */
    public final String f40601f;

    /* renamed from: g  reason: collision with root package name */
    public int f40602g;

    /* renamed from: h  reason: collision with root package name */
    public int f40603h;
    public int i;
    public Inflater j;
    public final boolean k;
    public d l;
    public long m = 0;
    public long n = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f40599d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f40600e = -1;

    /* loaded from: classes7.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public boolean isClosed() {
            return this == CLOSED;
        }

        public boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        this.f40597b = State.WAITING_FOR_INPUT;
        this.f40601f = str;
        this.f40598c = z;
        this.f40603h = i;
        boolean z2 = true;
        if (i < 1 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.j = inflater;
            z2 = false;
        } else {
            this.j = new Inflater();
        }
        this.k = z2;
        this.a = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.i = -1;
        this.f40597b = State.WAITING_FOR_INPUT;
        try {
            a(i);
        } catch (RuntimeException e2) {
            f();
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: RuntimeException -> 0x0087, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0087, blocks: (B:2:0x0000, B:4:0x0006, B:5:0x0010, B:8:0x001a, B:10:0x001e, B:13:0x002b, B:15:0x0031, B:17:0x0039, B:21:0x0055, B:20:0x004a, B:22:0x0060, B:24:0x0066, B:32:0x007b, B:34:0x0081, B:25:0x0069, B:27:0x0071, B:28:0x0074, B:31:0x0079, B:12:0x0025), top: B:41:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i() {
        State state;
        int i;
        try {
            if (this.f40597b == State.ROW_READY) {
                com.kwad.sdk.core.d.a.a(new PngjException("invalid state"));
            }
            if (this.f40597b.isDone()) {
                return false;
            }
            if (this.a == null || this.a.length < this.f40603h) {
                this.a = new byte[this.f40603h];
            }
            if (this.f40602g < this.f40603h && !this.j.finished()) {
                try {
                    i = this.j.inflate(this.a, this.f40602g, this.f40603h - this.f40602g);
                } catch (DataFormatException e2) {
                    com.kwad.sdk.core.d.a.a(new PngjException("error decompressing zlib stream ", e2));
                    i = 0;
                }
                this.f40602g += i;
                this.n += i;
            }
            if (this.f40602g != this.f40603h) {
                if (!this.j.finished()) {
                    state = State.WAITING_FOR_INPUT;
                } else if (this.f40602g <= 0) {
                    state = State.DONE;
                }
                this.f40597b = state;
                if (state != State.ROW_READY) {
                    a();
                    return true;
                }
                return false;
            }
            state = State.ROW_READY;
            this.f40597b = state;
            if (state != State.ROW_READY) {
            }
        } catch (RuntimeException e3) {
            f();
            throw e3;
        }
    }

    public void a() {
    }

    public void a(int i) {
        this.f40602g = 0;
        this.i++;
        if (i < 1 || this.j.finished()) {
            this.f40603h = 0;
            g();
            return;
        }
        this.f40597b = State.WAITING_FOR_INPUT;
        this.f40603h = i;
        if (this.f40598c) {
            return;
        }
        i();
    }

    public void a(d dVar) {
        if (!this.f40601f.equals(dVar.a().f40642c)) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk inside IdatSet, id:" + dVar.a().f40642c + ", expected:" + this.f40601f));
        }
        this.l = dVar;
        int i = this.f40599d + 1;
        this.f40599d = i;
        int i2 = this.f40600e;
        if (i2 >= 0) {
            dVar.a(i + i2);
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        this.m += i2;
        if (i2 < 1 || this.f40597b.isDone()) {
            return;
        }
        if (this.f40597b == State.ROW_READY) {
            com.kwad.sdk.core.d.a.a(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.j.needsDictionary() || !this.j.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.j.setInput(bArr, i, i2);
        if (!this.f40598c) {
            i();
            return;
        }
        while (i()) {
            a(b());
            if (d()) {
                c();
            }
        }
    }

    public boolean a(String str) {
        if (this.f40597b.isClosed()) {
            return false;
        }
        if (str.equals(this.f40601f) || b(str)) {
            return true;
        }
        if (this.f40597b.isDone()) {
            if (!this.f40597b.isClosed()) {
                f();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.f40601f + " set is not done");
    }

    public int b() {
        throw new PngjException("not implemented");
    }

    public boolean b(String str) {
        return false;
    }

    public void c() {
    }

    public boolean d() {
        return this.f40597b.isDone();
    }

    public boolean e() {
        return this.f40597b.isClosed();
    }

    public void f() {
        try {
            if (!this.f40597b.isClosed()) {
                this.f40597b = State.CLOSED;
            }
            if (!this.k || this.j == null) {
                return;
            }
            this.j.end();
            this.j = null;
        } catch (Exception unused) {
        }
    }

    public void g() {
        if (d()) {
            return;
        }
        this.f40597b = State.DONE;
    }

    public int h() {
        return this.i;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.l.a().f40642c + " state=" + this.f40597b + " rows=" + this.i + " bytes=" + this.m + "/" + this.n).toString();
    }
}
