package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39752a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39753b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f39753b = localAliasTagsManager;
        this.f39752a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f39753b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f39752a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f39752a);
        }
    }
}
