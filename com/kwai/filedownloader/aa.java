package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;
/* loaded from: classes7.dex */
public class aa implements v {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Handler> f37611a = new SparseArray<>();

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.v
    public void a() {
        for (int i2 = 0; i2 < this.f37611a.size(); i2++) {
            a(this.f37611a.get(this.f37611a.keyAt(i2)));
        }
    }

    @Override // com.kwai.filedownloader.v
    public void a(List<Integer> list) {
        for (Integer num : list) {
            b(this.f37611a.get(num.intValue()));
        }
    }

    @Override // com.kwai.filedownloader.v
    public boolean a(int i2) {
        return this.f37611a.get(i2) != null;
    }

    @Override // com.kwai.filedownloader.v
    public int b() {
        return this.f37611a.size();
    }
}
