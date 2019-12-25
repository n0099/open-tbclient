package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class cw extends cq {
    cq a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cu f217a;
    final /* synthetic */ cq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw(cu cuVar, String str, cq cqVar) {
        super(str);
        this.f217a = cuVar;
        this.b = cqVar;
        this.a = this.b;
        this.f203b = this.f203b;
        if (this.b != null) {
            this.f = this.b.f;
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
            cq cqVar = cu.b.get(this.f203b);
            if (cqVar != null) {
                Iterator<String> it = cqVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f203b);
                arrayList.add(this.f203b);
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
