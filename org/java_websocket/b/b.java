package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    boolean Ab(String str);

    boolean Ac(String str);

    void c(Framedata framedata) throws InvalidDataException;

    String cdT();

    String cdU();

    b cdV();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
