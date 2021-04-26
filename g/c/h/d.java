package g.c.h;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes7.dex */
public abstract class d extends f {
    public d(Framedata.Opcode opcode) {
        super(opcode);
    }

    @Override // g.c.h.f
    public void h() throws InvalidDataException {
        if (f()) {
            if (!b()) {
                if (!c()) {
                    if (e()) {
                        throw new InvalidFrameException("Control frame cant have rsv3==true set");
                    }
                    return;
                }
                throw new InvalidFrameException("Control frame cant have rsv2==true set");
            }
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        }
        throw new InvalidFrameException("Control frame cant have fin==false set");
    }
}
