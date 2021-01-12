package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes4.dex */
public interface b {
    boolean abm(String str);

    boolean abn(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    String eJO();

    String eJP();

    b eJQ();

    void reset();

    String toString();
}
