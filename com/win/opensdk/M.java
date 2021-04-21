package com.win.opensdk;

import android.widget.Toast;
/* loaded from: classes7.dex */
public class M implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ N f40106a;

    public M(N n) {
        this.f40106a = n;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f40106a.f40109b.getApplicationContext(), R.string.win_toast_network_error2, 0).show();
    }
}
