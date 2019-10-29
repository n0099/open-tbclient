package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public interface b {
    boolean Hg(String str);

    boolean Hh(String str);

    void c(Framedata framedata) throws InvalidDataException;

    String cNJ();

    String cNK();

    b cNL();

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
