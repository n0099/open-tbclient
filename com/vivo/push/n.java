package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13661a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13662b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13662b = localAliasTagsManager;
        this.f13661a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f13661a != null && this.f13661a.size() > 0) {
            iSubscribeAppAliasManager = this.f13662b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.setAliasSuccess((String) this.f13661a.get(0));
        }
    }
}
