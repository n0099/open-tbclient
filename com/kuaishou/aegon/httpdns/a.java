package com.kuaishou.aegon.httpdns;

import java.util.List;
/* loaded from: classes3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final List f5411a;

    private a(List list) {
        this.f5411a = list;
    }

    public static Runnable gP(List list) {
        return new a(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeIncreasePriority((String[]) this.f5411a.toArray(new String[0]));
    }
}
