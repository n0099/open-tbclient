package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13639a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13640b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13640b = localAliasTagsManager;
        this.f13639a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f13639a != null && this.f13639a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f13639a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.f13640b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.setTagsSuccess(hashSet);
        }
    }
}
