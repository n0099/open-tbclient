package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.HashSet;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f13938a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LocalAliasTagsManager f13939b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LocalAliasTagsManager localAliasTagsManager, List list) {
        this.f13939b = localAliasTagsManager;
        this.f13938a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        if (this.f13938a != null && this.f13938a.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : this.f13938a) {
                hashSet.add(str);
            }
            iSubscribeAppTagManager = this.f13939b.mSubscribeAppTagManager;
            iSubscribeAppTagManager.setTagsSuccess(hashSet);
        }
    }
}
