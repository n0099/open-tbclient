package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f40408a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40409b;

    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f40409b = localAliasTagsManager;
        this.f40408a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        List list = this.f40408a;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f40408a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f40409b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.setTagsSuccess(hashSet);
    }
}
