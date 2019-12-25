package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public interface b {
    boolean Rm(String str);

    boolean Rn(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dFD();

    String dFE();

    b dFF();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
