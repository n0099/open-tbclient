package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13936a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13937b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f13937b = localAliasTagsManager;
        this.f13936a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f13937b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.setAlias(this.f13936a)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f13936a);
        }
    }
}
