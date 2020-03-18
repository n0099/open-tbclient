package com.kascend.chushou.player.e;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.player.e.c;
import com.kascend.chushou.player.g;
import java.util.List;
import java.util.Map;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class d extends com.kascend.chushou.player.e {
    public String a;
    public String b;
    private View c;
    private FrameLayout d;
    private boolean h;
    private FrescoThumbnailView mZw;
    private c.a mZx;
    private c mZv = null;
    private boolean g = false;

    public static d c(String str, boolean z, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("cover", str);
        bundle.putBoolean("initViewAsync", z);
        bundle.putString("liveType", str2);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = getArguments().getString("cover");
        this.h = getArguments().getBoolean("initViewAsync");
        this.b = getArguments().getString("liveType");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.c = layoutInflater.inflate(a.h.videoplayer_root_view_show_parent, viewGroup, false);
        this.d = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.mZw = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mZw.getLayoutParams();
        int aE = tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        if (aE > 0) {
            layoutParams.topMargin -= aE;
            layoutParams.bottomMargin = 0;
        }
        this.mZw.setLayoutParams(layoutParams);
        this.mZw.setVisibility(0);
        this.mZw.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mZw != null && !h.isEmpty(str)) {
            this.mZw.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.d != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.mZw.setVisibility(8);
        this.d.setVisibility(0);
        this.mZv = c.b(this.a, this.h, this.b);
        this.mZv.a(this.mZx);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mZv);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mZx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mZv != null) {
            this.mZv.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mZv != null) {
            this.mZv.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mZv != null) {
            this.mZv.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mZv != null) {
            this.mZv.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mZv != null) {
            this.mZv.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mZv != null) {
            this.mZv.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mZv != null) {
            this.mZv.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mZv != null) {
            this.mZv.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mZv != null) {
            this.mZv.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mZv != null) {
            this.mZv.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mZv != null) {
            this.mZv.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mZv != null) {
            return this.mZv.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mZv != null) {
            this.mZv.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mZv != null) {
            this.mZv.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mZv != null) {
            this.mZv.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mZv != null) {
            this.mZv.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mZv != null) {
            this.mZv.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mZv != null) {
            this.mZv.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mZv != null) {
            this.mZv.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mZv != null) {
            return this.mZv.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mZv != null) {
            return this.mZv.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mZv != null) {
            this.mZv.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mZv != null) {
            this.mZv.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mZv != null) {
            this.mZv.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mZv != null) {
            this.mZv.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mZv != null) {
            this.mZv.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mZv != null) {
            this.mZv.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mZv != null) {
            this.mZv.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mZv != null) {
            this.mZv.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mZv != null) {
            this.mZv.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mZv != null) {
            this.mZv.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mZv != null) {
            this.mZv.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mZv != null) {
            this.mZv.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mZv != null) {
            this.mZv.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mZv != null) {
            this.mZv.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mZv != null) {
            this.mZv.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mZv != null) {
            this.mZv.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mZv != null) {
            this.mZv.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mZv != null) {
            this.mZv.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mZv != null) {
            this.mZv.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(long j) {
        if (this.mZv != null) {
            this.mZv.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0704a
    public void c(int i) {
        if (this.mZv != null) {
            this.mZv.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mZv != null) {
            this.mZv.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void a(int i) {
        if (this.mZv != null) {
            this.mZv.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void D() {
        if (this.mZv != null) {
            this.mZv.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mZv != null) {
            this.mZv.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mZv != null) {
            this.mZv.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mZv != null) {
            this.mZv.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mZv != null) {
            this.mZv.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(IconConfig.Config config) {
        if (this.mZv != null) {
            this.mZv.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(BangInfo bangInfo, String str) {
        if (this.mZv != null) {
            this.mZv.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mZv != null) {
            this.mZv.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mZv != null) {
            this.mZv.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mZv != null) {
            this.mZv.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mZv != null) {
            this.mZv.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mZv != null) {
            this.mZv.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mZv != null) {
            this.mZv.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mZv != null) {
            this.mZv.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mZv != null) {
            this.mZv.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mZv != null) {
            this.mZv.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mZv != null) {
            this.mZv.P();
        }
    }
}
