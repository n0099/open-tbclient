package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class db extends cv {

    /* renamed from: a  reason: collision with root package name */
    cv f14230a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cz f278a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cv f14231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(cz czVar, String str, cv cvVar) {
        super(str);
        this.f278a = czVar;
        this.f14231b = cvVar;
        this.f14230a = this.f14231b;
        this.f264b = this.f264b;
        if (this.f14231b != null) {
            this.f = this.f14231b.f;
        }
    }

    @Override // com.xiaomi.push.cv
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f14230a != null) {
            arrayList.addAll(this.f14230a.a(true));
        }
        synchronized (cz.f14228b) {
            cv cvVar = cz.f14228b.get(this.f264b);
            if (cvVar != null) {
                Iterator<String> it = cvVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f264b);
                arrayList.add(this.f264b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cv
    public synchronized void a(String str, cu cuVar) {
        if (this.f14230a != null) {
            this.f14230a.a(str, cuVar);
        }
    }

    @Override // com.xiaomi.push.cv
    public boolean b() {
        return false;
    }
}
