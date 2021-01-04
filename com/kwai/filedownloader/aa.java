package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;
/* loaded from: classes5.dex */
class aa implements v {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Handler> f11162a = new SparseArray<>();

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.v
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f11162a.size()) {
                return;
            }
            a(this.f11162a.get(this.f11162a.keyAt(i2)));
            i = i2 + 1;
        }
    }

    @Override // com.kwai.filedownloader.v
    public void a(List<Integer> list) {
        for (Integer num : list) {
            b(this.f11162a.get(num.intValue()));
        }
    }

    @Override // com.kwai.filedownloader.v
    public boolean a(int i) {
        return this.f11162a.get(i) != null;
    }

    @Override // com.kwai.filedownloader.v
    public int b() {
        return this.f11162a.size();
    }
}
