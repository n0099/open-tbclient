package org.java_websocket.b;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes11.dex */
public interface b {
    boolean Zx(String str);

    boolean Zy(String str);

    void c(Framedata framedata) throws InvalidDataException;

    void d(Framedata framedata);

    void e(Framedata framedata) throws InvalidDataException;

    String eBc();

    String eBd();

    b eBe();

    void reset();

    String toString();
}
