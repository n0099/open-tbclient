package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public class DeflatedChunksSet {
    public byte[] a;
    public State b;
    public final boolean c;
    public final String f;
    public int g;
    public int h;
    public int i;
    public Inflater j;
    public final boolean k;
    public d l;
    public long m = 0;
    public long n = 0;
    public int d = -1;
    public int e = -1;

    /* loaded from: classes5.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        boolean z2;
        this.b = State.WAITING_FOR_INPUT;
        this.f = str;
        this.c = z;
        this.h = i;
        if (i <= 0 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.j = inflater;
            z2 = false;
        } else {
            this.j = new Inflater();
            z2 = true;
        }
        this.k = z2;
        this.a = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.i = -1;
        this.b = State.WAITING_FOR_INPUT;
        try {
            a(i);
        } catch (RuntimeException e) {
            e();
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: RuntimeException -> 0x0087, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0087, blocks: (B:2:0x0000, B:4:0x0006, B:5:0x0010, B:8:0x001a, B:10:0x001e, B:13:0x002b, B:15:0x0031, B:17:0x0039, B:21:0x0055, B:20:0x004a, B:22:0x0060, B:24:0x0066, B:32:0x007b, B:34:0x0081, B:25:0x0069, B:27:0x0071, B:28:0x0074, B:31:0x0079, B:12:0x0025), top: B:41:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean h() {
        State state;
        int i;
        try {
            if (this.b == State.ROW_READY) {
                com.kwad.sdk.core.d.b.a(new PngjException("invalid state"));
            }
            if (this.b.isDone()) {
                return false;
            }
            if (this.a == null || this.a.length < this.h) {
                this.a = new byte[this.h];
            }
            if (this.g < this.h && !this.j.finished()) {
                try {
                    i = this.j.inflate(this.a, this.g, this.h - this.g);
                } catch (DataFormatException e) {
                    com.kwad.sdk.core.d.b.a(new PngjException("error decompressing zlib stream ", e));
                    i = 0;
                }
                this.g += i;
                this.n += i;
            }
            if (this.g != this.h) {
                if (!this.j.finished()) {
                    state = State.WAITING_FOR_INPUT;
                } else if (this.g <= 0) {
                    state = State.DONE;
                }
                this.b = state;
                if (state != State.ROW_READY) {
                    a();
                    return true;
                }
                return false;
            }
            state = State.ROW_READY;
            this.b = state;
            if (state != State.ROW_READY) {
            }
        } catch (RuntimeException e2) {
            e();
            throw e2;
        }
    }

    public void a() {
    }

    public final void a(int i) {
        this.g = 0;
        this.i++;
        if (i <= 0 || this.j.finished()) {
            this.h = 0;
            f();
            return;
        }
        this.b = State.WAITING_FOR_INPUT;
        this.h = i;
        if (this.c) {
            return;
        }
        h();
    }

    public final void a(d dVar) {
        if (!this.f.equals(dVar.a().c)) {
            com.kwad.sdk.core.d.b.a(new PngjException("Bad chunk inside IdatSet, id:" + dVar.a().c + ", expected:" + this.f));
        }
        this.l = dVar;
        int i = this.d + 1;
        this.d = i;
        int i2 = this.e;
        if (i2 >= 0) {
            dVar.a(i + i2);
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        this.m += i2;
        if (i2 <= 0 || this.b.isDone()) {
            return;
        }
        if (this.b == State.ROW_READY) {
            com.kwad.sdk.core.d.b.a(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.j.needsDictionary() || !this.j.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.j.setInput(bArr, i, i2);
        if (!this.c) {
            h();
            return;
        }
        while (h()) {
            a(b());
            c();
        }
    }

    public final boolean a(String str) {
        if (this.b.isClosed()) {
            return false;
        }
        if (str.equals(this.f)) {
            return true;
        }
        if (this.b.isDone()) {
            if (!this.b.isClosed()) {
                e();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.f + " set is not done");
    }

    public int b() {
        throw new PngjException("not implemented");
    }

    public final boolean c() {
        return this.b.isDone();
    }

    public final boolean d() {
        return this.b.isClosed();
    }

    public void e() {
        try {
            if (!this.b.isClosed()) {
                this.b = State.CLOSED;
            }
            if (!this.k || this.j == null) {
                return;
            }
            this.j.end();
            this.j = null;
        } catch (Exception unused) {
        }
    }

    public final void f() {
        if (c()) {
            return;
        }
        this.b = State.DONE;
    }

    public final int g() {
        return this.i;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.l.a().c + " state=" + this.b + " rows=" + this.i + " bytes=" + this.m + "/" + this.n).toString();
    }
}
