package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes6.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f37465a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f37466b;

    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f37466b = localAliasTagsManager;
        this.f37465a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f37465a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f37466b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.delAliasSuccess((String) this.f37465a.get(0));
    }
}
