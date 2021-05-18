package com.win.opensdk;

import android.widget.Toast;
/* loaded from: classes7.dex */
public class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ G f36890a;

    public F(G g2) {
        this.f36890a = g2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f36890a.f36894b.getApplicationContext(), R.string.win_toast_network_error2, 0).show();
    }
}
