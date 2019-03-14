package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    boolean Gf(String str);

    boolean Gg(String str);

    void c(Framedata framedata) throws InvalidDataException;

    String cDl();

    String cDm();

    b cDn();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
