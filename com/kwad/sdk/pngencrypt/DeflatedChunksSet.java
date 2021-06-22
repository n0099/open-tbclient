package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes7.dex */
public class DeflatedChunksSet {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f36896a;

    /* renamed from: b  reason: collision with root package name */
    public State f36897b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36898c;

    /* renamed from: f  reason: collision with root package name */
    public final String f36901f;

    /* renamed from: g  reason: collision with root package name */
    public int f36902g;

    /* renamed from: h  reason: collision with root package name */
    public int f36903h;

    /* renamed from: i  reason: collision with root package name */
    public int f36904i;
    public Inflater j;
    public final boolean k;
    public d l;
    public long m = 0;
    public long n = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f36899d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f36900e = -1;

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

    public DeflatedChunksSet(String str, boolean z, int i2, int i3, Inflater inflater, byte[] bArr) {
        this.f36897b = State.WAITING_FOR_INPUT;
        this.f36901f = str;
        this.f36898c = z;
        this.f36903h = i2;
        boolean z2 = true;
        if (i2 < 1 || i3 < i2) {
            throw new PngjException("bad inital row len " + i2);
        }
        if (inflater != null) {
            this.j = inflater;
            z2 = false;
        } else {
            this.j = new Inflater();
        }
        this.k = z2;
        this.f36896a = (bArr == null || bArr.length < i2) ? new byte[i3] : bArr;
        this.f36904i = -1;
        this.f36897b = State.WAITING_FOR_INPUT;
        try {
            a(i2);
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
        int i2;
        try {
            if (this.f36897b == State.ROW_READY) {
                com.kwad.sdk.core.d.a.a(new PngjException("invalid state"));
            }
            if (this.f36897b.isDone()) {
                return false;
            }
            if (this.f36896a == null || this.f36896a.length < this.f36903h) {
                this.f36896a = new byte[this.f36903h];
            }
            if (this.f36902g < this.f36903h && !this.j.finished()) {
                try {
                    i2 = this.j.inflate(this.f36896a, this.f36902g, this.f36903h - this.f36902g);
                } catch (DataFormatException e2) {
                    com.kwad.sdk.core.d.a.a(new PngjException("error decompressing zlib stream ", e2));
                    i2 = 0;
                }
                this.f36902g += i2;
                this.n += i2;
            }
            if (this.f36902g != this.f36903h) {
                if (!this.j.finished()) {
                    state = State.WAITING_FOR_INPUT;
                } else if (this.f36902g <= 0) {
                    state = State.DONE;
                }
                this.f36897b = state;
                if (state != State.ROW_READY) {
                    a();
                    return true;
                }
                return false;
            }
            state = State.ROW_READY;
            this.f36897b = state;
            if (state != State.ROW_READY) {
            }
        } catch (RuntimeException e3) {
            f();
            throw e3;
        }
    }

    public void a() {
    }

    public void a(int i2) {
        this.f36902g = 0;
        this.f36904i++;
        if (i2 < 1 || this.j.finished()) {
            this.f36903h = 0;
            g();
            return;
        }
        this.f36897b = State.WAITING_FOR_INPUT;
        this.f36903h = i2;
        if (this.f36898c) {
            return;
        }
        i();
    }

    public void a(d dVar) {
        if (!this.f36901f.equals(dVar.a().f36956c)) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk inside IdatSet, id:" + dVar.a().f36956c + ", expected:" + this.f36901f));
        }
        this.l = dVar;
        int i2 = this.f36899d + 1;
        this.f36899d = i2;
        int i3 = this.f36900e;
        if (i3 >= 0) {
            dVar.a(i2 + i3);
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.m += i3;
        if (i3 < 1 || this.f36897b.isDone()) {
            return;
        }
        if (this.f36897b == State.ROW_READY) {
            com.kwad.sdk.core.d.a.a(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.j.needsDictionary() || !this.j.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.j.setInput(bArr, i2, i3);
        if (!this.f36898c) {
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
        if (this.f36897b.isClosed()) {
            return false;
        }
        if (str.equals(this.f36901f) || b(str)) {
            return true;
        }
        if (this.f36897b.isDone()) {
            if (!this.f36897b.isClosed()) {
                f();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.f36901f + " set is not done");
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
        return this.f36897b.isDone();
    }

    public boolean e() {
        return this.f36897b.isClosed();
    }

    public void f() {
        try {
            if (!this.f36897b.isClosed()) {
                this.f36897b = State.CLOSED;
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
        this.f36897b = State.DONE;
    }

    public int h() {
        return this.f36904i;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.l.a().f36956c + " state=" + this.f36897b + " rows=" + this.f36904i + " bytes=" + this.m + "/" + this.n).toString();
    }
}
