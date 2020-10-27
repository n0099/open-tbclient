package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4681a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.f4681a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f4681a != null && this.f4681a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f4681a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.delTagsSuccess(hashSet);
        }
    }
}
