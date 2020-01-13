package com.kascend.chushou.player.ui.h5.a;

import android.app.Activity;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.c;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0695a nbr;
    private final c nbq = new c(Looper.getMainLooper());
    private final List<com.kascend.chushou.player.ui.h5.c.b> c = new ArrayList();

    /* renamed from: com.kascend.chushou.player.ui.h5.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0695a {
        void c(int i);
    }

    public a(Activity activity) {
        try {
            this.nbr = (InterfaceC0695a) activity;
        } catch (Exception e) {
            this.nbr = null;
        }
    }

    public void a() {
        this.c.clear();
        this.nbq.cp(null);
    }

    public void b() {
        this.c.clear();
        this.nbq.cp(null);
        this.nbr = null;
    }

    public void a(List<com.kascend.chushou.player.ui.h5.c.b> list) {
        if (!h.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                com.kascend.chushou.player.ui.h5.c.b bVar = list.get(i);
                if (bVar != null && !h.isEmpty(bVar.p)) {
                    a(bVar);
                }
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                final com.kascend.chushou.player.ui.h5.c.b bVar2 = this.c.get(i2);
                if (bVar2.b > 0) {
                    this.nbq.d(new Runnable() { // from class: com.kascend.chushou.player.ui.h5.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.b(bVar2);
                        }
                    }, bVar2.b * 1000);
                }
            }
            if (this.nbr != null) {
                this.nbr.c(this.c.size());
            }
        }
    }

    private void a(com.kascend.chushou.player.ui.h5.c.b bVar) {
        if (this.c.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.c.size()) {
                    if (!this.c.get(i2).p.equals(bVar.p)) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    this.c.add(bVar);
                    return;
                }
            }
        } else {
            this.c.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.kascend.chushou.player.ui.h5.c.b bVar) {
        if (bVar != null) {
            this.c.remove(bVar);
        }
        if (this.nbr != null) {
            this.nbr.c(this.c.size());
        }
    }

    public List<com.kascend.chushou.player.ui.h5.c.b> c() {
        return this.c;
    }
}
