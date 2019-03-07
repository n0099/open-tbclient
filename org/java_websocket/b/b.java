package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    boolean Ge(String str);

    boolean Gf(String str);

    void c(Framedata framedata) throws InvalidDataException;

    String cCY();

    String cCZ();

    b cDa();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
