package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import d.h.d.b.h;
import d.h.d.d.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    public final Object lock;
    public final a parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z = this.parser.M() != JsonToken.END_DOCUMENT;
                    } catch (IOException e2) {
                        throw new JsonIOException(e2);
                    }
                } catch (MalformedJsonException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        a aVar = new a(reader);
        this.parser = aVar;
        aVar.R(true);
        this.lock = new Object();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return h.a(this.parser);
            } catch (JsonParseException e2) {
                if (e2.getCause() instanceof EOFException) {
                    throw new NoSuchElementException();
                }
                throw e2;
            } catch (OutOfMemoryError e3) {
                throw new JsonParseException("Failed parsing JSON source to Json", e3);
            } catch (StackOverflowError e4) {
                throw new JsonParseException("Failed parsing JSON source to Json", e4);
            }
        }
        throw new NoSuchElementException();
    }
}
