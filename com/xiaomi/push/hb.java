package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.am;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class hb extends am.b {
    public final /* synthetic */ Context a;

    public hb(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.am.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = ha.f458a;
        synchronized (obj) {
            list = ha.f460a;
            arrayList = new ArrayList(list);
            list2 = ha.f460a;
            list2.clear();
        }
        ha.b(this.a, arrayList);
    }
}
