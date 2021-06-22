package com.vivo.push;

import com.vivo.push.cache.ISubscribeAppTagManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f40410a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LocalAliasTagsManager f40411b;

    public f(LocalAliasTagsManager localAliasTagsManager, ArrayList arrayList) {
        this.f40411b = localAliasTagsManager;
        this.f40410a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISubscribeAppTagManager iSubscribeAppTagManager;
        HashSet hashSet = new HashSet();
        Iterator it = this.f40410a.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        iSubscribeAppTagManager = this.f40411b.mSubscribeAppTagManager;
        if (iSubscribeAppTagManager.setTags(hashSet)) {
            p.a().a(LocalAliasTagsManager.DEFAULT_LOCAL_REQUEST_ID, this.f40410a);
        }
    }
}
