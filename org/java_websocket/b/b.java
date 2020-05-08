package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public interface b {
    boolean PL(String str);

    boolean PM(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dGS();

    String dGT();

    b dGU();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
