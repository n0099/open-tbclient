package com.kuaishou.aegon.httpdns;

import java.util.List;
/* loaded from: classes5.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final List f8411a;

    private a(List list) {
        this.f8411a = list;
    }

    public static Runnable gQ(List list) {
        return new a(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeIncreasePriority((String[]) this.f8411a.toArray(new String[0]));
    }
}
