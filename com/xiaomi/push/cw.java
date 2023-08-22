package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class cw extends cq {
    public cq a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cu f201a;
    public final /* synthetic */ cq b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw(cu cuVar, String str, cq cqVar) {
        super(str);
        this.f201a = cuVar;
        this.b = cqVar;
        cq cqVar2 = this.b;
        this.a = cqVar2;
        ((cq) this).f187b = ((cq) this).f187b;
        if (cqVar2 != null) {
            this.f = cqVar2.f;
        }
    }

    @Override // com.xiaomi.push.cq
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.a != null) {
            arrayList.addAll(this.a.a(true));
        }
        synchronized (cu.b) {
            cq cqVar = cu.b.get(((cq) this).f187b);
            if (cqVar != null) {
                Iterator<String> it = cqVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(((cq) this).f187b);
                arrayList.add(((cq) this).f187b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cq
    public synchronized void a(String str, cp cpVar) {
        if (this.a != null) {
            this.a.a(str, cpVar);
        }
    }

    @Override // com.xiaomi.push.cq
    public boolean b() {
        return false;
    }
}
