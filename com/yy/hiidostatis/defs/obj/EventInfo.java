package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.log.L;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class EventInfo extends Info<EventElementInfo> {
    public static final long serialVersionUID = -2909020670205500872L;

    public int getRealElemCount() {
        Iterator<EventElementInfo> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            EventElementInfo next = it.next();
            if (next.ctype == 1) {
                i = (int) (i + parseAsInt(next.cvalue));
            } else {
                i++;
            }
        }
        return i;
    }

    private long parseAsInt(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            L.debug(this, "Failed to parse %s as number", str);
            return 1L;
        }
    }
}
