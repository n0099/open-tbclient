package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes6.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f37477a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f37478b;

    public n(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f37478b = localAliasTagsManager;
        this.f37477a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f37477a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f37478b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.setAliasSuccess((String) this.f37477a.get(0));
    }
}
