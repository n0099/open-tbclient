package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f36702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f36703b;

    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f36703b = localAliasTagsManager;
        this.f36702a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f36703b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f36702a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f36702a);
        }
    }
}
