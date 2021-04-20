package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.f;
/* loaded from: classes6.dex */
public class UTDevice {
    public static String a(Context context) {
        a b2 = b.b(context);
        return (b2 == null || f.isEmpty(b2.getUtdid())) ? "ffffffffffffffffffffffff" : b2.getUtdid();
    }

    public static String b(Context context) {
        String d2 = c.a(context).d();
        return (d2 == null || f.isEmpty(d2)) ? "ffffffffffffffffffffffff" : d2;
    }

    @Deprecated
    public static String getUtdid(Context context) {
        return a(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return b(context);
    }
}
