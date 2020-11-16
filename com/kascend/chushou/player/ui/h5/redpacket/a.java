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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f4181a = new ArrayList();
    private io.reactivex.disposables.a c = new io.reactivex.disposables.a();
    private InterfaceC1007a pwU;

    /* renamed from: com.kascend.chushou.player.ui.h5.redpacket.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1007a {
        void D();

        void a(int i);
    }

    public a(Context context) {
        try {
            this.pwU = (InterfaceC1007a) context;
        } catch (Exception e) {
            this.pwU = null;
        }
    }

    public List<e> a() {
        return this.f4181a;
    }

    public void a(List<e> list) {
        for (e eVar : list) {
            if (eVar != null && !a(eVar)) {
                this.f4181a.add(0, eVar);
            }
        }
        e();
    }

    public void a(String str) {
        if (!h.isEmpty(str)) {
            for (e eVar : this.f4181a) {
                if (str.equals(eVar.a())) {
                    eVar.Rm(2);
                    return;
                }
            }
        }
    }

    public void b() {
        Iterator<e> it = this.f4181a.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next == null || next.c() == 2) {
                it.remove();
            }
        }
        if (this.pwU != null) {
            this.pwU.a(this.f4181a.size());
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.dispose();
            this.c = null;
        }
        this.c = new io.reactivex.disposables.a();
        this.f4181a.clear();
        e();
    }

    public void d() {
        if (this.c != null) {
            this.c.dispose();
            this.c = null;
        }
        this.f4181a.clear();
    }

    public void e() {
        RxExecutor.post(this.c, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.redpacket.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.pwU != null) {
                    a.this.pwU.a(a.this.f4181a.size());
                }
            }
        });
        if (com.kascend.chushou.d.h.etY().q() && this.f4181a.size() > 0 && this.pwU != null) {
            this.pwU.D();
        }
    }

    public H5Positon Rl(int i) {
        if (this.f4181a.size() == 0) {
            return null;
        }
        e eVar = this.f4181a.get(0);
        if (i == 2) {
            return eVar.evV();
        }
        if (i == 1) {
            return eVar.evU();
        }
        return null;
    }

    public String f() {
        return this.f4181a.size() > 0 ? this.f4181a.get(0).d() : "";
    }

    private boolean a(e eVar) {
        for (e eVar2 : this.f4181a) {
            String a2 = eVar.a();
            if (!h.isEmpty(a2) && a2.equals(eVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
