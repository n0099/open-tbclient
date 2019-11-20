package org.java_websocket.framing;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public class i extends e {
    public i() {
        super(Framedata.Opcode.TEXT);
    }

    @Override // org.java_websocket.framing.e, org.java_websocket.framing.f
    public void cNK() throws InvalidDataException {
        super.cNK();
        if (!org.java_websocket.e.c.s(cNM())) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
    }
}
