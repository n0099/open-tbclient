package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class cu extends co {

    /* renamed from: a  reason: collision with root package name */
    public co f40629a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cs f205a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ co f40630b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(cs csVar, String str, co coVar) {
        super(str);
        this.f205a = csVar;
        this.f40630b = coVar;
        co coVar2 = this.f40630b;
        this.f40629a = coVar2;
        ((co) this).f191b = ((co) this).f191b;
        if (coVar2 != null) {
            this.f40619f = coVar2.f40619f;
        }
    }

    @Override // com.xiaomi.push.co
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f40629a != null) {
            arrayList.addAll(this.f40629a.a(true));
        }
        synchronized (cs.f40625b) {
            co coVar = cs.f40625b.get(((co) this).f191b);
            if (coVar != null) {
                Iterator<String> it = coVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(((co) this).f191b);
                arrayList.add(((co) this).f191b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.co
    public synchronized void a(String str, cn cnVar) {
        if (this.f40629a != null) {
            this.f40629a.a(str, cnVar);
        }
    }

    @Override // com.xiaomi.push.co
    public boolean b() {
        return false;
    }
}
