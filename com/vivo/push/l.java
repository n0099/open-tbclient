package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppAliasManager;
import java.util.List;
/* loaded from: classes7.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f39767a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f39768b;

    public l(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f39768b = localAliasTagsManager;
        this.f39767a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppAliasManager iSubscribeAppAliasManager;
        List list = this.f39767a;
        if (list == null || list.size() <= 0) {
            return;
        }
        iSubscribeAppAliasManager = this.f39768b.mSubscribeAppAliasManager;
        iSubscribeAppAliasManager.delAliasSuccess((String) this.f39767a.get(0));
    }
}
