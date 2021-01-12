package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13659a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13660b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13660b = localAliasTagsManager;
        this.f13659a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f13659a != null && this.f13659a.size() > 0) {
            iSubscribeAppAliasManager = this.f13660b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.setAliasSuccess((String) this.f13659a.get(0));
        }
    }
}
