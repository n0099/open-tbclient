package com.kascend.chushou.player.ui.h5.redpacket;

import android.content.Context;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.player.ui.h5.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class a {
    private final List<e> a = new ArrayList();
    private io.reactivex.disposables.a c = new io.reactivex.disposables.a();
    private InterfaceC0707a neI;

    /* renamed from: com.kascend.chushou.player.ui.h5.redpacket.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0707a {
        void D();

        void a(int i);
    }

    public a(Context context) {
        try {
            this.neI = (InterfaceC0707a) context;
        } catch (Exception e) {
            this.neI = null;
        }
    }

    public List<e> a() {
        return this.a;
    }

    public void a(List<e> list) {
        for (e eVar : list) {
            if (eVar != null && !a(eVar)) {
                this.a.add(0, eVar);
            }
        }
        e();
    }

    public void a(String str) {
        if (!h.isEmpty(str)) {
            for (e eVar : this.a) {
                if (str.equals(eVar.a())) {
                    eVar.Na(2);
                    return;
                }
            }
        }
    }

    public void b() {
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next == null || next.c() == 2) {
                it.remove();
            }
        }
        if (this.neI != null) {
            this.neI.a(this.a.size());
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.dispose();
            this.c = null;
        }
        this.c = new io.reactivex.disposables.a();
        this.a.clear();
        e();
    }

    public void d() {
        if (this.c != null) {
            this.c.dispose();
            this.c = null;
        }
        this.a.clear();
    }

    public void e() {
        RxExecutor.post(this.c, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.redpacket.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.neI != null) {
                    a.this.neI.a(a.this.a.size());
                }
            }
        });
        if (com.kascend.chushou.d.h.dCs().q() && this.a.size() > 0 && this.neI != null) {
            this.neI.D();
        }
    }

    public H5Positon MZ(int i) {
        if (this.a.size() == 0) {
            return null;
        }
        e eVar = this.a.get(0);
        if (i == 2) {
            return eVar.dED();
        }
        if (i == 1) {
            return eVar.dEC();
        }
        return null;
    }

    public String f() {
        return this.a.size() > 0 ? this.a.get(0).d() : "";
    }

    private boolean a(e eVar) {
        for (e eVar2 : this.a) {
            String a = eVar.a();
            if (!h.isEmpty(a) && a.equals(eVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
