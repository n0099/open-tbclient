package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public interface b {
    boolean Sh(String str);

    boolean Si(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    String dMg();

    String dMh();

    b dMi();

    void e(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
