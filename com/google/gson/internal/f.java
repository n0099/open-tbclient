package com.google.gson.internal;

import com.google.gson.h;
import com.google.gson.internal.a.m;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public final class f {
    public static void b(h hVar, com.google.gson.stream.a aVar) throws IOException {
        m.krf.a(aVar, hVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes2.dex */
    private static final class a extends Writer {
        private final Appendable kpt;
        private final C0569a kpu = new C0569a();

        a(Appendable appendable) {
            this.kpt = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.kpu.chars = cArr;
            this.kpt.append(this.kpu, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.kpt.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: com.google.gson.internal.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0569a implements CharSequence {
            char[] chars;

            C0569a() {
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
