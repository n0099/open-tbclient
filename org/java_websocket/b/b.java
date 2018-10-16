package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    void c(Framedata framedata) throws InvalidDataException;

    String caS();

    String caT();

    b caU();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();

    boolean za(String str);

    boolean zb(String str);
}
