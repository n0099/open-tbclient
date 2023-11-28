package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;
/* loaded from: classes10.dex */
public final class ab implements w {
    public final SparseArray<Handler> aeS = new SparseArray<>();

    @Override // com.kwad.framework.filedownloader.w
    public final void uQ() {
        for (int i = 0; i < this.aeS.size(); i++) {
            a(this.aeS.get(this.aeS.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int uR() {
        return this.aeS.size();
    }

    public static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    public static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bc(int i) {
        if (this.aeS.get(i) != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void o(List<Integer> list) {
        for (Integer num : list) {
            b(this.aeS.get(num.intValue()));
        }
    }
}
