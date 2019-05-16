package com.xiaomi.metoknlp.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private static c a;
    private Context b;
    private List d = new ArrayList();
    private Handler c = new d(this, com.xiaomi.metoknlp.a.a().d().getLooper());
    private BroadcastReceiver e = new e(this);

    private c(Context context) {
        this.b = context;
        this.b.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static c a() {
        return a;
    }

    public static void a(Context context) {
        if (a == null) {
            a = new c(context);
        }
    }

    public void a(a aVar) {
        synchronized (this.d) {
            this.d.add(aVar);
        }
    }
}
