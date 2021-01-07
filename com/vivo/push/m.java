package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13953a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13954b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13954b = localAliasTagsManager;
        this.f13953a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f13953a != null && this.f13953a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f13953a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.f13954b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.delTagsSuccess(hashSet);
        }
    }
}
