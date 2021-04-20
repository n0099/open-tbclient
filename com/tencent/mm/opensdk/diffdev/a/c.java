package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ b f39435g;

    public c(b bVar) {
        this.f39435g = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f39435g.f39434f.f39431c;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onQrcodeScanned();
        }
    }
}
