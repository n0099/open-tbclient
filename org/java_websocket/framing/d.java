package org.java_websocket.framing;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public abstract class d extends f {
    public d(Framedata.Opcode opcode) {
        super(opcode);
    }

    @Override // org.java_websocket.framing.f
    public void dMh() throws InvalidDataException {
        if (!JY()) {
            throw new InvalidFrameException("Control frame cant have fin==false set");
        }
        if (dMk()) {
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        }
        if (dMl()) {
            throw new InvalidFrameException("Control frame cant have rsv2==true set");
        }
        if (dMm()) {
            throw new InvalidFrameException("Control frame cant have rsv3==true set");
        }
    }
}
