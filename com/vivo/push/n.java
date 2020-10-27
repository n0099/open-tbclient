package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f4684a;
    final /* synthetic */ LocalAliasTagsManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.b = localAliasTagsManager;
        this.f4684a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f4684a != null && this.f4684a.size() > 0) {
            iSubscribeAppAliasManager = this.b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.setAliasSuccess((String) this.f4684a.get(0));
        }
    }
}
