package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class gy extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4937a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(Context context) {
        this.f4937a = context;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gx.f408a;
        synchronized (obj) {
            list = gx.f410a;
            arrayList = new ArrayList(list);
            list2 = gx.f410a;
            list2.clear();
        }
        gx.b(this.f4937a, arrayList);
    }
}
