package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.live.tbadk.log.LogConfig;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class f extends com.bytedance.sdk.openadsdk.preload.a.d.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Writer f4960a = new Writer() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.f.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final q b = new q(LogConfig.TYPE_CLOSED);
    private final List<com.bytedance.sdk.openadsdk.preload.a.l> c;
    private String d;
    private com.bytedance.sdk.openadsdk.preload.a.l e;

    public f() {
        super(f4960a);
        this.c = new ArrayList();
        this.e = com.bytedance.sdk.openadsdk.preload.a.n.f5034a;
    }

    public com.bytedance.sdk.openadsdk.preload.a.l a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    private com.bytedance.sdk.openadsdk.preload.a.l j() {
        return this.c.get(this.c.size() - 1);
    }

    private void a(com.bytedance.sdk.openadsdk.preload.a.l lVar) {
        if (this.d != null) {
            if (!lVar.j() || i()) {
                ((o) j()).a(this.d, lVar);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = lVar;
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
    public com.bytedance.sdk.openadsdk.preload.a.d.c b() throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.i iVar = new com.bytedance.sdk.openadsdk.preload.a.i();
        a(iVar);
        this.c.add(iVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c d() throws IOException {
        o oVar = new o();
        a(oVar);
        this.c.add(oVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof o) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof o) {
            this.d = str;
            return this;
        }
        throw new IllegalStateException();
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
    public com.bytedance.sdk.openadsdk.preload.a.d.c f() throws IOException {
        a(com.bytedance.sdk.openadsdk.preload.a.n.f5034a);
        return this;
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

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }
}
