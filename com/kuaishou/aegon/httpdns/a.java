package com.kuaishou.aegon.httpdns;

import java.util.List;
/* loaded from: classes6.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final List f31619a;

    public a(List list) {
        this.f31619a = list;
    }

    public static Runnable a(List list) {
        return new a(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeIncreasePriority((String[]) this.f31619a.toArray(new String[0]));
    }
}
