package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f40423a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40424b;

    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f40424b = localAliasTagsManager;
        this.f40423a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        List list = this.f40423a;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f40423a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f40424b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.delTagsSuccess(hashSet);
    }
}
