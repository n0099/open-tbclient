package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4673a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.f4673a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f4673a != null && this.f4673a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f4673a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.setTagsSuccess(hashSet);
        }
    }
}
