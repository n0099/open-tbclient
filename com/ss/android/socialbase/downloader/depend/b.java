package com.ss.android.socialbase.downloader.depend;

import java.util.List;
/* loaded from: classes8.dex */
public abstract class b implements v {
    public boolean a = false;

    @Override // com.ss.android.socialbase.downloader.depend.v
    public boolean a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.depend.v
    public void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.a = true;
        }
    }
}
