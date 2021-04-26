package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f37452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f37453b;

    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f37453b = localAliasTagsManager;
        this.f37452a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        List list = this.f37452a;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f37452a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f37453b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.setTagsSuccess(hashSet);
    }
}
