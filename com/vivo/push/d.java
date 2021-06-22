package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40406a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40407b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f40407b = localAliasTagsManager;
        this.f40406a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f40407b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f40406a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f40406a);
        }
    }
}
