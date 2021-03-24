package com.ta.utdid2.device;

import com.ta.utdid2.a.a.f;
/* loaded from: classes7.dex */
public class e {
    public String d(String str) {
        return com.ta.utdid2.a.a.a.b(str);
    }

    public String e(String str) {
        String b2 = com.ta.utdid2.a.a.a.b(str);
        if (!f.isEmpty(b2)) {
            try {
                return new String(com.ta.utdid2.a.a.b.decode(b2, 0));
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
