package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes7.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f36639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f36640b;

    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f36640b = localAliasTagsManager;
        this.f36639a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f36639a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f36640b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.delAliasSuccess((String) this.f36639a.get(0));
    }
}
