package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class f extends com.bytedance.sdk.openadsdk.preload.a.d.c {

    /* renamed from: a  reason: collision with root package name */
    public static final Writer f29692a = new Writer() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.f.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final q f29693b = new q("closed");

    /* renamed from: c  reason: collision with root package name */
    public final List<com.bytedance.sdk.openadsdk.preload.a.l> f29694c;

    /* renamed from: d  reason: collision with root package name */
    public String f29695d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.a.l f29696e;

    public f() {
        super(f29692a);
        this.f29694c = new ArrayList();
        this.f29696e = com.bytedance.sdk.openadsdk.preload.a.n.f29917a;
    }

    private com.bytedance.sdk.openadsdk.preload.a.l j() {
        List<com.bytedance.sdk.openadsdk.preload.a.l> list = this.f29694c;
        return list.get(list.size() - 1);
    }

    public com.bytedance.sdk.openadsdk.preload.a.l a() {
        if (this.f29694c.isEmpty()) {
            return this.f29696e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f29694c);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c b() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.i iVar = new com.bytedance.sdk.openadsdk.preload.a.i();
        a(iVar);
        this.f29694c.add(iVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c c() throws IOException {
        if (!this.f29694c.isEmpty() && this.f29695d == null) {
            if (j() instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                List<com.bytedance.sdk.openadsdk.preload.a.l> list = this.f29694c;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f29694c.isEmpty()) {
            this.f29694c.add(f29693b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c d() throws IOException {
        o oVar = new o();
        a(oVar);
        this.f29694c.add(oVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c e() throws IOException {
        if (!this.f29694c.isEmpty() && this.f29695d == null) {
            if (j() instanceof o) {
                List<com.bytedance.sdk.openadsdk.preload.a.l> list = this.f29694c;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c f() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.n.f29917a);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Flushable
    public void flush() throws IOException {
    }

    private void a(com.bytedance.sdk.openadsdk.preload.a.l lVar) {
        if (this.f29695d != null) {
            if (!lVar.j() || i()) {
                ((o) j()).a(this.f29695d, lVar);
            }
            this.f29695d = null;
        } else if (this.f29694c.isEmpty()) {
            this.f29696e = lVar;
        } else {
            com.bytedance.sdk.openadsdk.preload.a.l j = j();
            if (j instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                ((com.bytedance.sdk.openadsdk.preload.a.i) j).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        a(new q(str));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(String str) throws IOException {
        if (str != null) {
            if (!this.f29694c.isEmpty() && this.f29695d == null) {
                if (j() instanceof o) {
                    this.f29695d = str;
                    return this;
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(boolean z) throws IOException {
        a(new q(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        a(new q(bool));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(long j) throws IOException {
        a(new q(Long.valueOf(j)));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new q(number));
        return this;
    }
}
