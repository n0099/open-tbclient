package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    boolean Ir(String str);

    boolean Is(String str);

    void c(Framedata framedata) throws InvalidDataException;

    String cOQ();

    String cOR();

    b cOS();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
