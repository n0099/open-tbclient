package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f4676a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocalAliasTagsManager localAliasTagsManager, ArrayList arrayList) {
        this.b = localAliasTagsManager;
        this.f4676a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        HashSet hashSet = new HashSet();
        Iterator it = this.f4676a.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        iSubscribeAppTagManager = this.b.mSubscribeAppTagManager;
        if (iSubscribeAppTagManager.setTags(hashSet)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f4676a);
        }
    }
}
