package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public interface b {
    boolean SF(String str);

    boolean SG(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dTL();

    String dTM();

    b dTN();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
