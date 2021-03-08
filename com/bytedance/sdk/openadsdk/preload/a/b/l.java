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
        boolean z = true;
        try {
            aVar.f();
            z = false;
            return n.X.b(aVar);
        } catch (com.bytedance.sdk.openadsdk.preload.a.d.d e) {
            throw new t(e);
        } catch (EOFException e2) {
            if (z) {
                return com.bytedance.sdk.openadsdk.preload.a.n.f5034a;
            }
            throw new t(e2);
        } catch (IOException e3) {
            throw new com.bytedance.sdk.openadsdk.preload.a.m(e3);
        } catch (NumberFormatException e4) {
            throw new t(e4);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.a.l lVar, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws IOException {
        n.X.a(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes6.dex */
    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f5016a;
        private final C1043a b = new C1043a();

        a(Appendable appendable) {
            this.f5016a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.f5017a = cArr;
            this.f5016a.append(this.b, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f5016a.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C1043a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f5017a;

            C1043a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f5017a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f5017a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f5017a, i, i2 - i);
            }
        }
    }
}
