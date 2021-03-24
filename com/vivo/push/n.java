package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes7.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f39489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39490b;

    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f39490b = localAliasTagsManager;
        this.f39489a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f39489a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f39490b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.setAliasSuccess((String) this.f39489a.get(0));
    }
}
