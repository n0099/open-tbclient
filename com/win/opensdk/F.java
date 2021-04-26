package com.win.opensdk;

import android.widget.Toast;
/* loaded from: classes6.dex */
public class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ G f37645a;

    public F(G g2) {
        this.f37645a = g2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f37645a.f37649b.getApplicationContext(), R.string.win_toast_network_error2, 0).show();
    }
}
