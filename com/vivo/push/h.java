package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13644a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13645b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LocalAliasTagsManager localAliasTagsManager, String str) {
        this.f13645b = localAliasTagsManager;
        this.f13644a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        iSubscribeAppAliasManager = this.f13645b.mSubscribeAppAliasManager;
        if (iSubscribeAppAliasManager.delAlias(this.f13644a)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f13644a);
        }
    }
}
