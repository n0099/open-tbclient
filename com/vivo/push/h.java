package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f36631a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f36632b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f36632b = localAliasTagsManager;
        this.f36631a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f36632b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f36631a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f36631a);
        }
    }
}
