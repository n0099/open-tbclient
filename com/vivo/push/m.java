package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4453a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.f4453a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f4453a != null && this.f4453a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f4453a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.delTagsSuccess(hashSet);
        }
    }
}
