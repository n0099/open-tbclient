package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class gr extends al.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40895a;

    public gr(Context context) {
        this.f40895a = context;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gq.f440a;
        synchronized (obj) {
            list = gq.f442a;
            arrayList = new ArrayList(list);
            list2 = gq.f442a;
            list2.clear();
        }
        gq.b(this.f40895a, arrayList);
    }
}
