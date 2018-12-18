package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    void c(Framedata framedata) throws InvalidDataException;

    String ccu();

    String ccv();

    b ccw();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();

    boolean zI(String str);

    boolean zJ(String str);
}
