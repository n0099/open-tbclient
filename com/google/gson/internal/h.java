package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes17.dex */
public final class h {
    public static JsonElement parse(com.google.gson.stream.a aVar) throws JsonParseException {
        boolean z = true;
        try {
            aVar.eph();
            z = false;
            return TypeAdapters.oWg.read(aVar);
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (EOFException e2) {
            if (z) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static void a(JsonElement jsonElement, com.google.gson.stream.b bVar) throws IOException {
        TypeAdapters.oWg.write(bVar, jsonElement);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes17.dex */
    private static final class a extends Writer {
        private final Appendable oUq;
        private final C0965a oUr = new C0965a();

        a(Appendable appendable) {
            this.oUq = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.oUr.chars = cArr;
            this.oUq.append(this.oUr, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.oUq.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: com.google.gson.internal.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        static class C0965a implements CharSequence {
            char[] chars;

            C0965a() {
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
