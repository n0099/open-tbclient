package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class p {
    public static com.google.gson.r a(com.google.gson.stream.a aVar) {
        boolean z = true;
        try {
            aVar.f();
            z = false;
            return (com.google.gson.r) com.google.gson.internal.a.y.P.b(aVar);
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (EOFException e2) {
            if (z) {
                return com.google.gson.s.f1672a;
            }
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static void a(com.google.gson.r rVar, com.google.gson.stream.d dVar) {
        com.google.gson.internal.a.y.P.a(dVar, rVar);
    }
}
