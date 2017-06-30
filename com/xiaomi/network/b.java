package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b extends Fallback {
    Fallback i;
    final /* synthetic */ Fallback j;
    final /* synthetic */ HostManager k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(HostManager hostManager, String str, Fallback fallback) {
        super(str);
        this.k = hostManager;
        this.j = fallback;
        this.i = this.j;
        this.b = this.b;
        if (this.j != null) {
            this.f = this.j.f;
        }
    }

    @Override // com.xiaomi.network.Fallback
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.i != null) {
            arrayList.addAll(this.i.a(true));
        }
        synchronized (HostManager.mReservedHosts) {
            ArrayList<String> arrayList2 = HostManager.mReservedHosts.get(this.b);
            if (arrayList2 != null) {
                ArrayList<String> a = this.i != null ? this.i.a(false) : arrayList;
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (a.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.b);
                arrayList.add(this.b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.network.Fallback
    public synchronized void a(String str, AccessHistory accessHistory) {
        if (this.i != null) {
            this.i.a(str, accessHistory);
        }
    }

    @Override // com.xiaomi.network.Fallback
    public boolean b() {
        return false;
    }
}
