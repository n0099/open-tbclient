package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes17.dex */
public interface b {
    boolean WW(String str);

    boolean WX(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    String ens();

    String ent();

    b enu();

    void reset();

    String toString();
}
