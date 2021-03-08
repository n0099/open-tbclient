package com.win.opensdk;

import android.widget.Toast;
import com.win.opensdk.bd;
/* loaded from: classes14.dex */
public class al implements Runnable {
    public final /* synthetic */ ao qkM;

    public al(ao aoVar) {
        this.qkM = aoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.qkM.qkN.getApplicationContext(), bd.e.win_toast_network_error2, 0).show();
    }
}
