package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public interface b {
    boolean Tq(String str);

    boolean Tr(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dXi();

    String dXj();

    b dXk();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
