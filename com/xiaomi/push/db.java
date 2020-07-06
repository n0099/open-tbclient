package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class db extends cv {
    cv a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cz f204a;
    final /* synthetic */ cv b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(cz czVar, String str, cv cvVar) {
        super(str);
        this.f204a = czVar;
        this.b = cvVar;
        this.a = this.b;
        this.f190b = this.f190b;
        if (this.b != null) {
            this.f = this.b.f;
        }
    }

    @Override // com.xiaomi.push.cv
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.a != null) {
            arrayList.addAll(this.a.a(true));
        }
        synchronized (cz.b) {
            cv cvVar = cz.b.get(this.f190b);
            if (cvVar != null) {
                Iterator<String> it = cvVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f190b);
                arrayList.add(this.f190b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cv
    public synchronized void a(String str, cu cuVar) {
        if (this.a != null) {
            this.a.a(str, cuVar);
        }
    }

    @Override // com.xiaomi.push.cv
    public boolean b() {
        return false;
    }
}
