package d.g.c.b;

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
/* loaded from: classes6.dex */
public final class h {
    public static JsonElement a(d.g.c.d.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.M();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return TypeAdapters.X.read(aVar);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return JsonNull.INSTANCE;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    public static void b(JsonElement jsonElement, d.g.c.d.b bVar) throws IOException {
        TypeAdapters.X.write(bVar, jsonElement);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* loaded from: classes6.dex */
    public static final class a extends Writer {

        /* renamed from: e  reason: collision with root package name */
        public final Appendable f66104e;

        /* renamed from: f  reason: collision with root package name */
        public final C1809a f66105f = new C1809a();

        /* renamed from: d.g.c.b.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C1809a implements CharSequence {

            /* renamed from: e  reason: collision with root package name */
            public char[] f66106e;

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f66106e[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f66106e.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f66106e, i, i2 - i);
            }
        }

        public a(Appendable appendable) {
            this.f66104e = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            C1809a c1809a = this.f66105f;
            c1809a.f66106e = cArr;
            this.f66104e.append(c1809a, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f66104e.append((char) i);
        }
    }
}
