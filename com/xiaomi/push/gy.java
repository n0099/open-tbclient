package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class gy extends al.b {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gx.f415a;
        synchronized (obj) {
            list = gx.f417a;
            arrayList = new ArrayList(list);
            list2 = gx.f417a;
            list2.clear();
        }
        gx.b(this.a, arrayList);
    }
}
