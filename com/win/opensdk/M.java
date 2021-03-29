package com.win.opensdk;

import android.widget.Toast;
/* loaded from: classes7.dex */
public class M implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N f39722a;

    public M(N n) {
        this.f39722a = n;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f39722a.f39725b.getApplicationContext(), R.string.win_toast_network_error2, 0).show();
    }
}
