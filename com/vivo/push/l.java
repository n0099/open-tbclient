package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13950a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13951b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13951b = localAliasTagsManager;
        this.f13950a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f13950a != null && this.f13950a.size() > 0) {
            iSubscribeAppAliasManager = this.f13951b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.delAliasSuccess((String) this.f13950a.get(0));
        }
    }
}
