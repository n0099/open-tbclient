package com.ss.android.socialbase.downloader.d;

import java.util.List;
/* loaded from: classes4.dex */
public abstract class u implements aj {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13119a = false;

    @Override // com.ss.android.socialbase.downloader.d.aj
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f13119a = true;
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.aj
    public boolean a() {
        return this.f13119a;
    }
}
