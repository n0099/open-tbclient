package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f39754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39755b;

    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f39755b = localAliasTagsManager;
        this.f39754a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        List list = this.f39754a;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f39754a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f39755b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.setTagsSuccess(hashSet);
    }
}
