package com.bytedance.sdk.openadsdk.preload.a.b;

import com.bytedance.sdk.openadsdk.preload.a.b.a.n;
import com.bytedance.sdk.openadsdk.preload.a.p;
import com.bytedance.sdk.openadsdk.preload.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes6.dex */
public final class l {
    public static com.bytedance.sdk.openadsdk.preload.a.l a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws p {
        boolean z;
        try {
            try {
                aVar.f();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return n.X.b(aVar);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return com.bytedance.sdk.openadsdk.preload.a.n.f30137a;
                }
                throw new t(e);
            }
        } catch (com.bytedance.sdk.openadsdk.preload.a.d.d e4) {
            throw new t(e4);
        } catch (IOException e5) {
            throw new com.bytedance.sdk.openadsdk.preload.a.m(e5);
        } catch (NumberFormatException e6) {
            throw new t(e6);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        public final Appendable f30072a;

        /* renamed from: b  reason: collision with root package name */
        public final C0332a f30073b = new C0332a();

        /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0332a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            public char[] f30074a;

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f30074a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f30074a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f30074a, i, i2 - i);
            }
        }

        public a(Appendable appendable) {
            this.f30072a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            C0332a c0332a = this.f30073b;
            c0332a.f30074a = cArr;
            this.f30072a.append(c0332a, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f30072a.append((char) i);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.a.l lVar, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws IOException {
        n.X.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
