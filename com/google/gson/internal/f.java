package com.google.gson.internal;

import com.google.gson.h;
import com.google.gson.internal.a.k;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public final class f {
    public static void b(h hVar, com.google.gson.stream.a aVar) throws IOException {
        k.hOY.a(aVar, hVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes2.dex */
    private static final class a extends Writer {
        private final Appendable hNy;
        private final C0267a hNz;

        private a(Appendable appendable) {
            this.hNz = new C0267a();
            this.hNy = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.hNz.chars = cArr;
            this.hNy.append(this.hNz, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.hNy.append((char) i);
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
            char[] chars;

            C0267a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.chars[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.chars, i, i2 - i);
            }
        }
    }
}
