package com.kascend.chushou.player.ui.h5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.tbadk.pay.PayConfig;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.widget.cswebview.e;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes6.dex */
public class H5Container extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f4165a;
    private String b;
    private final List<a> c;
    private c otC;
    private b otD;
    private com.kascend.chushou.player.ui.h5.b.a otE;
    private com.kascend.chushou.player.ui.h5.redpacket.b otF;
    private com.kascend.chushou.player.b otG;
    private io.reactivex.disposables.a otH;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f4167a;
        int b;
        Object c;

        private a() {
        }
    }

    public H5Container(@NonNull Context context) {
        super(context);
        this.c = new ArrayList();
        a(context);
    }

    public H5Container(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        a(context);
    }

    public H5Container(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList();
        a(context);
    }

    private void a(Context context) {
        this.f4165a = context;
        setClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.otH != null) {
            this.otH.dispose();
            this.otH = null;
        }
        tv.chushou.zues.a.a.cp(this);
        super.onDetachedFromWindow();
    }

    public void setPlayerViewHelper(com.kascend.chushou.player.b bVar) {
        this.otG = bVar;
    }

    public void a(int i, com.kascend.chushou.player.ui.h5.d.a aVar) {
        if (this.otC != null) {
            this.otC.setVisibility(0);
            return;
        }
        H5Positon Ow = aVar.Ow(i);
        if (Ow != null) {
            this.otC = new c(this.f4165a);
            this.otC.setCloseH5Listener(new e() { // from class: com.kascend.chushou.player.ui.h5.H5Container.1
                @Override // com.kascend.chushou.widget.cswebview.e, com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    H5Container.this.a();
                }
            });
            com.kascend.chushou.player.ui.h5.c.c eie = aVar.eie();
            a(this.otC, eie.l, aVar);
            this.otC.a(i, Ow, eie);
            if (eie.d > 0) {
                if (this.otH == null) {
                    this.otH = new io.reactivex.disposables.a();
                }
                RxExecutor.postDelayed(this.otH, EventThread.MAIN_THREAD, eie.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.H5Container.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ViewCompat.isAttachedToWindow(H5Container.this)) {
                            H5Container.this.a();
                        }
                    }
                });
            }
        }
    }

    public void a(int i, Object obj) {
        H5Positon h5Positon;
        if (obj instanceof com.kascend.chushou.player.ui.h5.c.b) {
            if (this.otD != null) {
                this.otD.setVisibility(0);
                return;
            }
            com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) obj;
            if (i == 1) {
                h5Positon = bVar.our;
            } else {
                h5Positon = bVar.ous;
            }
            if (h5Positon != null) {
                this.otD = new b(this.f4165a);
                this.otD.setCloseH5Listener(new e() { // from class: com.kascend.chushou.player.ui.h5.H5Container.5
                    @Override // com.kascend.chushou.widget.cswebview.e, com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj2) {
                        H5Container.this.b();
                    }
                });
                a(this.otD, bVar.l, bVar);
                this.otD.a(i, h5Positon, bVar);
                if (bVar.c > 0) {
                    if (this.otH == null) {
                        this.otH = new io.reactivex.disposables.a();
                    }
                    RxExecutor.postDelayed(this.otH, EventThread.MAIN_THREAD, bVar.c, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.H5Container.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ViewCompat.isAttachedToWindow(H5Container.this)) {
                                H5Container.this.b();
                            }
                        }
                    });
                }
            }
        }
    }

    public void a() {
        if (this.otC != null) {
            a(this.otC);
            this.otC = null;
        }
    }

    public void b() {
        if (this.otD != null) {
            a(this.otD);
            this.otD = null;
        }
    }

    public void a(int i, com.kascend.chushou.player.ui.h5.b.b bVar) {
        H5Positon Ow;
        if (this.otE != null) {
            this.otE.a();
            f();
            return;
        }
        List<com.kascend.chushou.player.ui.h5.c.c> d = bVar.d();
        if (!h.isEmpty(d) && (Ow = bVar.Ow(i)) != null) {
            this.otE = new com.kascend.chushou.player.ui.h5.b.a(this.f4165a);
            a(this.otE, d.get(d.size() - 1).l, bVar);
            this.otE.setCloseH5Listener(new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.ui.h5.H5Container.7
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    H5Container.this.c();
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            this.otE.a(i, Ow, bVar);
        }
    }

    public void c() {
        if (this.otE != null) {
            a(this.otE);
            this.otE = null;
        }
    }

    public void a(int i, com.kascend.chushou.player.ui.h5.redpacket.a aVar) {
        H5Positon Ow;
        if (this.otF != null) {
            this.otF.a();
            f();
            return;
        }
        List<com.kascend.chushou.player.ui.h5.c.e> a2 = aVar.a();
        if (!h.isEmpty(a2) && (Ow = aVar.Ow(i)) != null) {
            this.otF = new com.kascend.chushou.player.ui.h5.redpacket.b(this.f4165a);
            a(this.otF, a2.get(a2.size() - 1).l, aVar);
            this.otF.setCloseH5Listener(new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.ui.h5.H5Container.8
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    H5Container.this.d();
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            this.otF.a(i, Ow, aVar);
        }
    }

    public void d() {
        if (this.otF != null) {
            a(this.otF);
            this.otF = null;
        }
    }

    public void a(int i, final com.kascend.chushou.player.ui.h5.c.a aVar) {
        String str;
        if (aVar != null) {
            if (!h.isEmpty(aVar.o) && aVar.o.contains("m/quest/pay-first.htm")) {
                HashMap hashMap = new HashMap();
                hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
                hashMap.put("_fromPos", PayConfig.PAYMENT_POS_KEY_MANGA);
                String a2 = com.kascend.chushou.d.e.a(aVar.o, hashMap);
                if (!h.isEmpty(a2)) {
                    aVar.o = a2;
                }
            }
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                a aVar2 = this.c.get(i2);
                if (!(aVar2.c instanceof com.kascend.chushou.player.ui.h5.c.a)) {
                    str = null;
                } else {
                    str = ((com.kascend.chushou.player.ui.h5.c.a) aVar2.c).p;
                }
                if (!h.isEmpty(str) && str.equals(aVar.p)) {
                    return;
                }
            }
            H5Positon h5Positon = aVar.ous;
            if (i == 1) {
                h5Positon = aVar.our;
            }
            if (h5Positon != null) {
                CommonH5View commonH5View = new CommonH5View(this.f4165a);
                commonH5View.setCloseH5Listener(new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.ui.h5.H5Container.9
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        H5Container.this.a(aVar.p);
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str2) {
                    }
                });
                boolean a3 = a(commonH5View, aVar.l, aVar);
                if (this.otG != null) {
                    this.otG.a(aVar);
                }
                commonH5View.a(i, h5Positon, aVar);
                if (aVar.o.contains("m/quest/pay-first.htm")) {
                    com.kascend.chushou.toolkit.a.a.a("39");
                    this.b = aVar.p;
                }
                if (aVar.c == 2) {
                    Set<String> egm = com.kascend.chushou.d.h.egj().egm();
                    if (egm == null) {
                        egm = new HashSet<>();
                    }
                    egm.add(aVar.b);
                    com.kascend.chushou.d.h.egj().a(egm);
                }
                if (a3) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f4165a, a.C0897a.flake_show);
                    commonH5View.setVisibility(0);
                    commonH5View.startAnimation(loadAnimation);
                }
                if (aVar.f4173a > 0) {
                    if (this.otH == null) {
                        this.otH = new io.reactivex.disposables.a();
                    }
                    RxExecutor.postDelayed(this.otH, EventThread.MAIN_THREAD, aVar.f4173a, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.H5Container.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ViewCompat.isAttachedToWindow(H5Container.this)) {
                                H5Container.this.a(aVar.p);
                            }
                        }
                    });
                }
            }
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str)) {
            Iterator<a> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                String str2 = null;
                if (next.c instanceof com.kascend.chushou.player.ui.h5.c.a) {
                    str2 = ((com.kascend.chushou.player.ui.h5.c.a) next.c).p;
                }
                if (!h.isEmpty(str2) && str.equals(str2)) {
                    removeView(next.f4167a);
                    if (this.otG != null) {
                        this.otG.a(str);
                    }
                    it.remove();
                }
            }
            a(true);
            if (h.isEmpty(this.c)) {
                setVisibility(8);
            }
        }
    }

    public void e() {
        if (!h.isEmpty(this.b)) {
            a(this.b);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4 && this.c.size() > 0) {
            a aVar = this.c.get(this.c.size() - 1);
            if (aVar != null) {
                if (aVar.c instanceof com.kascend.chushou.player.ui.h5.c.a) {
                    com.kascend.chushou.player.ui.h5.c.a aVar2 = (com.kascend.chushou.player.ui.h5.c.a) aVar.c;
                    if (aVar2.j == 1 && !h.isEmpty(aVar2.b)) {
                        tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.c(com.kascend.chushou.b.a.a.c.b, aVar2.b, aVar2.p));
                    } else {
                        a(aVar2.p);
                    }
                } else {
                    a(aVar.f4167a);
                }
            }
            return true;
        }
        return false;
    }

    @Subscribe
    public void confirmCloseWebviewMessage(com.kascend.chushou.b.a.a.c cVar) {
        if (cVar.c == com.kascend.chushou.b.a.a.c.b && !h.isEmpty(cVar.d) && !h.isEmpty(cVar.e)) {
            a(cVar.d, cVar.e);
        }
    }

    private void a(final String str, final String str2) {
        if (this.f4165a != null && getVisibility() == 0) {
            new tv.chushou.zues.widget.sweetalert.b(this.f4165a, 0).a(new b.a() { // from class: com.kascend.chushou.player.ui.h5.H5Container.3
                @Override // tv.chushou.zues.widget.sweetalert.b.a
                public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                    bVar.dismiss();
                }
            }).b(new b.a() { // from class: com.kascend.chushou.player.ui.h5.H5Container.2
                @Override // tv.chushou.zues.widget.sweetalert.b.a
                public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                    bVar.dismiss();
                    com.kascend.chushou.d.h.egj().b(str);
                    H5Container.this.a(str2);
                }
            }).Yu(this.f4165a.getResources().getString(a.i.alert_dialog_cancel)).Yw(this.f4165a.getResources().getString(a.i.quit_str)).Yt(this.f4165a.getResources().getString(a.i.str_dialog_tip_title)).A(this.f4165a.getResources().getString(a.i.quit_answer)).show();
        }
    }

    private boolean a(View view, int i, Object obj) {
        int i2;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= this.c.size()) {
                i2 = -1;
                break;
            } else if (this.c.get(i3).b > i) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 == -1) {
            i2 = getChildCount();
            z = true;
        }
        addView(view, i2, new FrameLayout.LayoutParams(-1, -1));
        a aVar = new a();
        aVar.f4167a = view;
        aVar.b = i;
        aVar.c = obj;
        this.c.add(i2, aVar);
        f();
        return z;
    }

    private void a(View view) {
        a aVar;
        if (view.getParent() != null) {
            Iterator<a> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar.f4167a == view) {
                    break;
                }
            }
            if (aVar != null) {
                this.c.remove(aVar);
            }
            removeView(view);
            if (aVar != null) {
                Object obj = aVar.c;
                if (obj instanceof com.kascend.chushou.player.ui.h5.redpacket.a) {
                    ((com.kascend.chushou.player.ui.h5.redpacket.a) obj).b();
                    this.otF = null;
                } else if (obj instanceof com.kascend.chushou.player.ui.h5.b.b) {
                    this.otE = null;
                } else if (obj instanceof com.kascend.chushou.player.ui.h5.d.a) {
                    this.otC = null;
                } else if (obj instanceof com.kascend.chushou.player.ui.h5.c.b) {
                    this.otD = null;
                }
            }
            a(true);
            if (h.isEmpty(this.c)) {
                setVisibility(8);
            }
        }
    }

    private void f() {
        a(false);
    }

    private void a(boolean z) {
        int size = this.c.size();
        if (size != 0) {
            View view = this.c.get(size - 1).f4167a;
            if (view != null && view.getVisibility() == 8) {
                view.setVisibility(0);
                if (z && (view instanceof CommonH5View)) {
                    ((CommonH5View) view).b();
                }
                if (z && (view instanceof c)) {
                    ((c) view).b();
                }
            }
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    this.c.get(i).f4167a.setVisibility(8);
                }
            }
        }
    }
}
