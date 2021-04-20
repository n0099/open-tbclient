package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f39769a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39770b;

    public m(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f39770b = localAliasTagsManager;
        this.f39769a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        List list = this.f39769a;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.f39769a) {
            hashSet.add(str);
        }
        iSubscribeAppTagManager = this.f39770b.mSubscribeAppTagManager;
        iSubscribeAppTagManager.delTagsSuccess(hashSet);
    }
}
