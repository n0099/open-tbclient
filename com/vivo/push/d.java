package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39847a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39848b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f39848b = localAliasTagsManager;
        this.f39847a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f39848b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f39847a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f39847a);
        }
    }
}
