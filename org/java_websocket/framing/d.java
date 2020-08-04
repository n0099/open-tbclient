package org.java_websocket.framing;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes9.dex */
public abstract class d extends f {
    public d(Framedata.Opcode opcode) {
        super(opcode);
    }

    @Override // org.java_websocket.framing.f
    public void dXl() throws InvalidDataException {
        if (!Yw()) {
            throw new InvalidFrameException("Control frame cant have fin==false set");
        }
        if (dXo()) {
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        }
        if (dXp()) {
            throw new InvalidFrameException("Control frame cant have rsv2==true set");
        }
        if (dXq()) {
            throw new InvalidFrameException("Control frame cant have rsv3==true set");
        }
    }
}
