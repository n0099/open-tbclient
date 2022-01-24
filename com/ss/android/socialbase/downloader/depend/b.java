package com.ss.android.socialbase.downloader.depend;

import java.util.List;
/* loaded from: classes4.dex */
public abstract class b implements v {
    public boolean a = false;

    @Override // com.ss.android.socialbase.downloader.depend.v
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.a = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.v
    public boolean a() {
        return this.a;
    }
}
