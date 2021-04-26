package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;
/* loaded from: classes6.dex */
public class aa implements v {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Handler> f34952a = new SparseArray<>();

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.v
    public void a() {
        for (int i2 = 0; i2 < this.f34952a.size(); i2++) {
            a(this.f34952a.get(this.f34952a.keyAt(i2)));
        }
    }

    @Override // com.kwai.filedownloader.v
    public void a(List<Integer> list) {
        for (Integer num : list) {
            b(this.f34952a.get(num.intValue()));
        }
    }

    @Override // com.kwai.filedownloader.v
    public boolean a(int i2) {
        return this.f34952a.get(i2) != null;
    }

    @Override // com.kwai.filedownloader.v
    public int b() {
        return this.f34952a.size();
    }
}
