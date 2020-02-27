package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.a != null && this.a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.setTagsSuccess(hashSet);
        }
    }
}
