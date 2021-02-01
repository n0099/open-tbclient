package com.kuaishou.aegon.httpdns;

import java.util.List;
/* loaded from: classes3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final List f8114a;

    private a(List list) {
        this.f8114a = list;
    }

    public static Runnable gP(List list) {
        return new a(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeIncreasePriority((String[]) this.f8114a.toArray(new String[0]));
    }
}
