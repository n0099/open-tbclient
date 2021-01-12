package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13653a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13654b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13654b = localAliasTagsManager;
        this.f13653a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f13653a != null && this.f13653a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f13653a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.f13654b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.delTagsSuccess(hashSet);
        }
    }
}
