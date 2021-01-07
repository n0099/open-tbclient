package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class gy extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(Context context) {
        this.f14373a = context;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gx.f490a;
        synchronized (obj) {
            list = gx.f492a;
            arrayList = new ArrayList(list);
            list2 = gx.f492a;
            list2.clear();
        }
        gx.b(this.f14373a, arrayList);
    }
}
