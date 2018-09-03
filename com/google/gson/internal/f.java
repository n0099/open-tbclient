package com.google.gson.internal;

import com.google.gson.h;
import com.google.gson.internal.a.k;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public final class f {
    public static void b(h hVar, com.google.gson.stream.a aVar) throws IOException {
        k.hHD.a(aVar, hVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes2.dex */
    private static final class a extends Writer {
        private final Appendable hGc;
        private final C0267a hGd;

        private a(Appendable appendable) {
            this.hGd = new C0267a();
            this.hGc = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.hGd.hGe = cArr;
            this.hGc.append(this.hGd, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.hGc.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: com.google.gson.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0267a implements CharSequence {
            char[] hGe;

            C0267a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.hGe.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.hGe[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.hGe, i, i2 - i);
            }
        }
    }
}
