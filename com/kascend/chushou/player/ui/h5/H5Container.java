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
    private Context f4163a;
    private String b;
    private final List<a> c;
    private c pkU;
    private b pkV;
    private com.kascend.chushou.player.ui.h5.b.a pkW;
    private com.kascend.chushou.player.ui.h5.redpacket.b pkX;
    private com.kascend.chushou.player.b pkY;
    private io.reactivex.disposables.a pkZ;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f4165a;
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
        this.f4163a = context;
        setClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.pkZ != null) {
            this.pkZ.dispose();
            this.pkZ = null;
        }
        tv.chushou.zues.a.a.ct(this);
        super.onDetachedFromWindow();
    }

    public void setPlayerViewHelper(com.kascend.chushou.player.b bVar) {
        this.pkY = bVar;
    }

    public void a(int i, com.kascend.chushou.player.ui.h5.d.a aVar) {
        if (this.pkU != null) {
            this.pkU.setVisibility(0);
            return;
        }
        H5Positon Qn = aVar.Qn(i);
        if (Qn != null) {
            this.pkU = new c(this.f4163a);
            this.pkU.setCloseH5Listener(new e() { // from class: com.kascend.chushou.player.ui.h5.H5Container.1
                @Override // com.kascend.chushou.widget.cswebview.e, com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    H5Container.this.a();
                }
            });
            com.kascend.chushou.player.ui.h5.c.c ese = aVar.ese();
            a(this.pkU, ese.l, aVar);
            this.pkU.a(i, Qn, ese);
            if (ese.d > 0) {
                if (this.pkZ == null) {
                    this.pkZ = new io.reactivex.disposables.a();
                }
                RxExecutor.postDelayed(this.pkZ, EventThread.MAIN_THREAD, ese.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.H5Container.4
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
            if (this.pkV != null) {
                this.pkV.setVisibility(0);
                return;
            }
            com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) obj;
            if (i == 1) {
                h5Positon = bVar.plJ;
            } else {
                h5Positon = bVar.plK;
            }
            if (h5Positon != null) {
                this.pkV = new b(this.f4163a);
                this.pkV.setCloseH5Listener(new e() { // from class: com.kascend.chushou.player.ui.h5.H5Container.5
                    @Override // com.kascend.chushou.widget.cswebview.e, com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj2) {
                        H5Container.this.b();
                    }
                });
                a(this.pkV, bVar.l, bVar);
                this.pkV.a(i, h5Positon, bVar);
                if (bVar.c > 0) {
                    if (this.pkZ == null) {
                        this.pkZ = new io.reactivex.disposables.a();
                    }
                    RxExecutor.postDelayed(this.pkZ, EventThread.MAIN_THREAD, bVar.c, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.H5Container.6
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
        if (this.pkU != null) {
            a(this.pkU);
            this.pkU = null;
        }
    }

    public void b() {
        if (this.pkV != null) {
            a(this.pkV);
            this.pkV = null;
        }
    }

    public void a(int i, com.kascend.chushou.player.ui.h5.b.b bVar) {
        H5Positon Qn;
        if (this.pkW != null) {
            this.pkW.a();
            f();
            return;
        }
        List<com.kascend.chushou.player.ui.h5.c.c> d = bVar.d();
        if (!h.isEmpty(d) && (Qn = bVar.Qn(i)) != null) {
            this.pkW = new com.kascend.chushou.player.ui.h5.b.a(this.f4163a);
            a(this.pkW, d.get(d.size() - 1).l, bVar);
            this.pkW.setCloseH5Listener(new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.ui.h5.H5Container.7
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    H5Container.this.c();
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            this.pkW.a(i, Qn, bVar);
        }
    }

    public void c() {
        if (this.pkW != null) {
            a(this.pkW);
            this.pkW = null;
        }
    }

    public void a(int i, com.kascend.chushou.player.ui.h5.redpacket.a aVar) {
        H5Positon Qn;
        if (this.pkX != null) {
            this.pkX.a();
            f();
            return;
        }
        List<com.kascend.chushou.player.ui.h5.c.e> a2 = aVar.a();
        if (!h.isEmpty(a2) && (Qn = aVar.Qn(i)) != null) {
            this.pkX = new com.kascend.chushou.player.ui.h5.redpacket.b(this.f4163a);
            a(this.pkX, a2.get(a2.size() - 1).l, aVar);
            this.pkX.setCloseH5Listener(new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.ui.h5.H5Container.8
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    H5Container.this.d();
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            this.pkX.a(i, Qn, aVar);
        }
    }

    public void d() {
        if (this.pkX != null) {
            a(this.pkX);
            this.pkX = null;
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
            H5Positon h5Positon = aVar.plK;
            if (i == 1) {
                h5Positon = aVar.plJ;
            }
            if (h5Positon != null) {
                CommonH5View commonH5View = new CommonH5View(this.f4163a);
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
                if (this.pkY != null) {
                    this.pkY.a(aVar);
                }
                commonH5View.a(i, h5Positon, aVar);
                if (aVar.o.contains("m/quest/pay-first.htm")) {
                    com.kascend.chushou.toolkit.a.a.a("39");
                    this.b = aVar.p;
                }
                if (aVar.c == 2) {
                    Set<String> eqm = com.kascend.chushou.d.h.eqj().eqm();
                    if (eqm == null) {
                        eqm = new HashSet<>();
                    }
                    eqm.add(aVar.b);
                    com.kascend.chushou.d.h.eqj().a(eqm);
                }
                if (a3) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f4163a, a.C0969a.flake_show);
                    commonH5View.setVisibility(0);
                    commonH5View.startAnimation(loadAnimation);
                }
                if (aVar.f4171a > 0) {
                    if (this.pkZ == null) {
                        this.pkZ = new io.reactivex.disposables.a();
                    }
                    RxExecutor.postDelayed(this.pkZ, EventThread.MAIN_THREAD, aVar.f4171a, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.h5.H5Container.10
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
                    removeView(next.f4165a);
                    if (this.pkY != null) {
                        this.pkY.a(str);
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
                    a(aVar.f4165a);
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
        if (this.f4163a != null && getVisibility() == 0) {
            new tv.chushou.zues.widget.sweetalert.b(this.f4163a, 0).a(new b.a() { // from class: com.kascend.chushou.player.ui.h5.H5Container.3
                @Override // tv.chushou.zues.widget.sweetalert.b.a
                public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                    bVar.dismiss();
                }
            }).b(new b.a() { // from class: com.kascend.chushou.player.ui.h5.H5Container.2
                @Override // tv.chushou.zues.widget.sweetalert.b.a
                public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                    bVar.dismiss();
                    com.kascend.chushou.d.h.eqj().b(str);
                    H5Container.this.a(str2);
                }
            }).aah(this.f4163a.getResources().getString(a.i.alert_dialog_cancel)).aaj(this.f4163a.getResources().getString(a.i.quit_str)).aag(this.f4163a.getResources().getString(a.i.str_dialog_tip_title)).D(this.f4163a.getResources().getString(a.i.quit_answer)).show();
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
        aVar.f4165a = view;
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
                if (aVar.f4165a == view) {
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
                    this.pkX = null;
                } else if (obj instanceof com.kascend.chushou.player.ui.h5.b.b) {
                    this.pkW = null;
                } else if (obj instanceof com.kascend.chushou.player.ui.h5.d.a) {
                    this.pkU = null;
                } else if (obj instanceof com.kascend.chushou.player.ui.h5.c.b) {
                    this.pkV = null;
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
            View view = this.c.get(size - 1).f4165a;
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
                    this.c.get(i).f4165a.setVisibility(8);
                }
            }
        }
    }
}
