package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public interface b {
    boolean acA(String str);

    boolean acB(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    String eMm();

    String eMn();

    b eMo();

    void reset();

    String toString();
}
