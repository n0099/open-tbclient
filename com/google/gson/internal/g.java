package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.i;
import com.google.gson.internal.a.n;
import com.google.gson.j;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes2.dex */
public final class g {
    public static i h(com.google.gson.stream.a aVar) throws JsonParseException {
        boolean z = true;
        try {
            aVar.bYB();
            z = false;
            return n.ioN.b(aVar);
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (EOFException e2) {
            if (z) {
                return j.ilR;
            }
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static void b(i iVar, com.google.gson.stream.b bVar) throws IOException {
        n.ioN.a(bVar, iVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes2.dex */
    private static final class a extends Writer {
        private final Appendable imS;
        private final C0354a imT = new C0354a();

        a(Appendable appendable) {
            this.imS = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.imT.chars = cArr;
            this.imS.append(this.imT, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.imS.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: com.google.gson.internal.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0354a implements CharSequence {
            char[] chars;

            C0354a() {
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
