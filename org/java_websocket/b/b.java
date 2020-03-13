package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public interface b {
    boolean St(String str);

    boolean Su(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dNw();

    String dNx();

    b dNy();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
