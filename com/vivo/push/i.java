package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f40415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40416b;

    public i(LocalAliasTagsManager localAliasTagsManager, ArrayList arrayList) {
        this.f40416b = localAliasTagsManager;
        this.f40415a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        HashSet hashSet = new HashSet();
        Iterator it = this.f40415a.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        iSubscribeAppTagManager = this.f40416b.mSubscribeAppTagManager;
        if (iSubscribeAppTagManager.delTags(hashSet)) {
            p.a().b(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f40415a);
        }
    }
}
