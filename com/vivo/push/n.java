package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes7.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f40433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40434b;

    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f40434b = localAliasTagsManager;
        this.f40433a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f40433a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f40434b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.setAliasSuccess((String) this.f40433a.get(0));
    }
}
