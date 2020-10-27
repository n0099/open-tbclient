package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class db extends cv {

    /* renamed from: a  reason: collision with root package name */
    cv f4848a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cz f196a;
    final /* synthetic */ cv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(cz czVar, String str, cv cvVar) {
        super(str);
        this.f196a = czVar;
        this.b = cvVar;
        this.f4848a = this.b;
        this.f182b = this.f182b;
        if (this.b != null) {
            this.f = this.b.f;
        }
    }

    @Override // com.xiaomi.push.cv
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f4848a != null) {
            arrayList.addAll(this.f4848a.a(true));
        }
        synchronized (cz.b) {
            cv cvVar = cz.b.get(this.f182b);
            if (cvVar != null) {
                Iterator<String> it = cvVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f182b);
                arrayList.add(this.f182b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cv
    public synchronized void a(String str, cu cuVar) {
        if (this.f4848a != null) {
            this.f4848a.a(str, cuVar);
        }
    }

    @Override // com.xiaomi.push.cv
    public boolean b() {
        return false;
    }
}
