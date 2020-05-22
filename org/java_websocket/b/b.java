package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public interface b {
    boolean RR(String str);

    boolean RS(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dON();

    String dOO();

    b dOP();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
