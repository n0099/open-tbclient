package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;
/* loaded from: classes6.dex */
public class aa implements v {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Handler> f36852a = new SparseArray<>();

    private void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.v
    public void a() {
        for (int i = 0; i < this.f36852a.size(); i++) {
            a(this.f36852a.get(this.f36852a.keyAt(i)));
        }
    }

    @Override // com.kwai.filedownloader.v
    public void a(List<Integer> list) {
        for (Integer num : list) {
            b(this.f36852a.get(num.intValue()));
        }
    }

    @Override // com.kwai.filedownloader.v
    public boolean a(int i) {
        return this.f36852a.get(i) != null;
    }

    @Override // com.kwai.filedownloader.v
    public int b() {
        return this.f36852a.size();
    }
}
