package com.xiaomi.smack.util;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.h;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h extends h.b {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = g.c;
        synchronized (obj) {
            list = g.d;
            arrayList = new ArrayList(list);
            list2 = g.d;
            list2.clear();
        }
        g.b(this.a, arrayList);
    }
}
