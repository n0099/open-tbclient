package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;
/* loaded from: classes6.dex */
public class aa implements v {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Handler> f37237a = new SparseArray<>();

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.v
    public void a() {
        for (int i = 0; i < this.f37237a.size(); i++) {
            a(this.f37237a.get(this.f37237a.keyAt(i)));
        }
    }

    @Override // com.kwai.filedownloader.v
    public void a(List<Integer> list) {
        for (Integer num : list) {
            b(this.f37237a.get(num.intValue()));
        }
    }

    @Override // com.kwai.filedownloader.v
    public boolean a(int i) {
        return this.f37237a.get(i) != null;
    }

    @Override // com.kwai.filedownloader.v
    public int b() {
        return this.f37237a.size();
    }
}
