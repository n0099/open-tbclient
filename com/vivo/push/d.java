package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f36624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f36625b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f36625b = localAliasTagsManager;
        this.f36624a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f36625b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f36624a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f36624a);
        }
    }
}
