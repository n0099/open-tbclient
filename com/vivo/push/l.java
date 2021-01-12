package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13651a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13652b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13652b = localAliasTagsManager;
        this.f13651a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        if (this.f13651a != null && this.f13651a.size() > 0) {
            iSubscribeAppAliasManager = this.f13652b.mSubscribeAppAliasManager;
            iSubscribeAppAliasManager.delAliasSuccess((String) this.f13651a.get(0));
        }
    }
}
