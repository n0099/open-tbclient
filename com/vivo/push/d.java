package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40303a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40304b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f40304b = localAliasTagsManager;
        this.f40303a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f40304b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f40303a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f40303a);
        }
    }
}
