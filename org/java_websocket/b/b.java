package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public interface b {
    boolean aaA(String str);

    boolean aaz(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    String eES();

    String eET();

    b eEU();

    void reset();

    String toString();
}
