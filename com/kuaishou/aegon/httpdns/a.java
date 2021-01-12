package com.kuaishou.aegon.httpdns;

import java.util.List;
/* loaded from: classes4.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final List f8112a;

    private a(List list) {
        this.f8112a = list;
    }

    public static Runnable gR(List list) {
        return new a(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeIncreasePriority((String[]) this.f8112a.toArray(new String[0]));
    }
}
