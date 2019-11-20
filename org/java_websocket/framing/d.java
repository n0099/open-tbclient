package org.java_websocket.framing;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public abstract class d extends f {
    public d(Framedata.Opcode opcode) {
        super(opcode);
    }

    @Override // org.java_websocket.framing.f
    public void cNK() throws InvalidDataException {
        if (!cNN()) {
            throw new InvalidFrameException("Control frame cant have fin==false set");
        }
        if (cNO()) {
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        }
        if (cNP()) {
            throw new InvalidFrameException("Control frame cant have rsv2==true set");
        }
        if (cNQ()) {
            throw new InvalidFrameException("Control frame cant have rsv3==true set");
        }
    }
}
