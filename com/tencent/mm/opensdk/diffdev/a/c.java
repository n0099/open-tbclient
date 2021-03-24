package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ b f39145g;

    public c(b bVar) {
        this.f39145g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f39145g.f39144f.f39141c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onQrcodeScanned();
        }
    }
}
