package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class db extends cv {

    /* renamed from: a  reason: collision with root package name */
    cv f13930a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cz f277a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cv f13931b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(cz czVar, String str, cv cvVar) {
        super(str);
        this.f277a = czVar;
        this.f13931b = cvVar;
        this.f13930a = this.f13931b;
        this.f263b = this.f263b;
        if (this.f13931b != null) {
            this.f = this.f13931b.f;
        }
    }

    @Override // com.xiaomi.push.cv
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f13930a != null) {
            arrayList.addAll(this.f13930a.a(true));
        }
        synchronized (cz.f13928b) {
            cv cvVar = cz.f13928b.get(this.f263b);
            if (cvVar != null) {
                Iterator<String> it = cvVar.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f263b);
                arrayList.add(this.f263b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cv
    public synchronized void a(String str, cu cuVar) {
        if (this.f13930a != null) {
            this.f13930a.a(str, cuVar);
        }
    }

    @Override // com.xiaomi.push.cv
    public boolean b() {
        return false;
    }
}
