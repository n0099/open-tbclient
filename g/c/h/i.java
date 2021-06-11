package g.c.h;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes8.dex */
public class i extends e {
    public i() {
        super(Framedata.Opcode.TEXT);
    }

    @Override // g.c.h.e, g.c.h.f
    public void h() throws InvalidDataException {
        super.h();
        if (!g.c.k.c.b(a())) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
    }
}
