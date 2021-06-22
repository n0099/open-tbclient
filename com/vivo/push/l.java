package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes7.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f40421a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40422b;

    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f40422b = localAliasTagsManager;
        this.f40421a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f40421a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f40422b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.delAliasSuccess((String) this.f40421a.get(0));
    }
}
