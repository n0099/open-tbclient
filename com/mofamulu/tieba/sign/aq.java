package com.mofamulu.tieba.sign;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends Thread {
    final /* synthetic */ ap a;

    public aq(ap apVar) {
        this.a = apVar;
        setDaemon(true);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.a.a != null && !this.a.a.isEmpty()) {
            try {
                for (int i = 0; i < this.a.a.size(); i++) {
                    ar arVar = (ar) this.a.a.get(i);
                    if (arVar.f()) {
                        try {
                            if (arVar.h() && i == this.a.a.size() - 1) {
                                Iterator it = this.a.f.iterator();
                                while (it.hasNext()) {
                                    ((am) it.next()).a(arVar.t());
                                }
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
                this.a.e();
                synchronized (this) {
                    try {
                        wait(1000L);
                    } catch (InterruptedException e) {
                    }
                }
            } catch (Throwable th2) {
                this.a.g = null;
                this.a.a = null;
                return;
            }
        }
        this.a.g = null;
        this.a.a = null;
    }
}
