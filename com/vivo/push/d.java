package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes6.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f37451b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f37451b = localAliasTagsManager;
        this.f37450a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f37451b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f37450a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f37450a);
        }
    }
}
