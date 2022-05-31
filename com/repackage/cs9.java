package com.repackage;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public interface cs9 {
    cs9 a();

    boolean b(String str);

    void c(Framedata framedata);

    String d();

    boolean e(String str);

    void f(Framedata framedata) throws InvalidDataException;

    String g();

    void h(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
