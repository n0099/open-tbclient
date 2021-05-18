package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f36695a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f36696b;

    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f36696b = localAliasTagsManager;
        this.f36695a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f36696b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f36695a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f36695a);
        }
    }
}
