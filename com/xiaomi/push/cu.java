package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class cu extends co {

    /* renamed from: a  reason: collision with root package name */
    public co f37415a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cs f205a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ co f37416b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(cs csVar, String str, co coVar) {
        super(str);
        this.f205a = csVar;
        this.f37416b = coVar;
        co coVar2 = this.f37416b;
        this.f37415a = coVar2;
        ((co) this).f191b = ((co) this).f191b;
        if (coVar2 != null) {
            this.f37404f = coVar2.f37404f;
        }
    }

    @Override // com.xiaomi.push.co
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f37415a != null) {
            arrayList.addAll(this.f37415a.a(true));
        }
        synchronized (cs.f37411b) {
            co coVar = cs.f37411b.get(((co) this).f191b);
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
        if (this.f37415a != null) {
            this.f37415a.a(str, cnVar);
        }
    }

    @Override // com.xiaomi.push.co
    public boolean b() {
        return false;
    }
}
