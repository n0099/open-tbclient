package org.java_websocket.framing;

import android.support.v4.view.PointerIconCompat;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes2.dex */
public class i extends e {
    public i() {
        super(Framedata.Opcode.TEXT);
    }

    @Override // org.java_websocket.framing.e, org.java_websocket.framing.f
    public void cDl() throws InvalidDataException {
        super.cDl();
        if (!org.java_websocket.e.c.v(cDn())) {
            throw new InvalidDataException((int) PointerIconCompat.TYPE_CROSSHAIR, "Received text is no valid utf8 string!");
        }
    }
}
