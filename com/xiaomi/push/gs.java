package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class gs extends al.b {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gs(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gr.f423a;
        synchronized (obj) {
            list = gr.f425a;
            arrayList = new ArrayList(list);
            list2 = gr.f425a;
            list2.clear();
        }
        gr.b(this.a, arrayList);
    }
}
