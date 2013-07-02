package com.mofamulu.tieba.sign;

import android.util.Log;
import com.baidu.browser.explorer.BdWebErrorView;
/* loaded from: classes.dex */
public class ab extends Thread {
    protected Object[] b;
    private String c;
    private boolean a = true;
    private volatile int d = 0;
    private boolean e = false;
    private int f = BdWebErrorView.ERROR_CODE_500;

    public ab(String str, int i) {
        setDaemon(true);
        this.c = str;
        this.b = new Object[i];
        setName("demon-" + str);
    }

    public void c() {
        this.a = false;
        try {
            notify();
        } catch (Exception e) {
        }
    }

    protected boolean a() {
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        while (this.a) {
            this.e = false;
            try {
                z = !a();
            } catch (Throwable th) {
                Log.e("tbhp", "error occured whiling processing the queue of thread: " + this.c, th);
                z = true;
            }
            if (z) {
                try {
                    synchronized (this) {
                        this.e = true;
                        wait(b());
                    }
                } catch (Throwable th2) {
                }
            }
        }
    }

    protected int b() {
        return this.f;
    }
}
