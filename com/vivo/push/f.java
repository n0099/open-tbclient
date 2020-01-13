package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class f implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocalAliasTagsManager localAliasTagsManager, ArrayList arrayList) {
        this.b = localAliasTagsManager;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        HashSet hashSet = new HashSet();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        iSubscribeAppTagManager = this.b.mSubscribeAppTagManager;
        if (iSubscribeAppTagManager.setTags(hashSet)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.a);
        }
    }
}
