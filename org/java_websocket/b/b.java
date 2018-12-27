package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    void c(Framedata framedata) throws InvalidDataException;

    String cdl();

    String cdm();

    b cdn();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();

    boolean zL(String str);

    boolean zM(String str);
}
