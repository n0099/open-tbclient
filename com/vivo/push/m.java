package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f37467a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f37468b;

    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f37468b = localAliasTagsManager;
        this.f37467a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        List list = this.f37467a;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f37467a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f37468b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.delTagsSuccess(hashSet);
    }
}
