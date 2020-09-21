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
/* loaded from: classes6.dex */
public class d extends com.kascend.chushou.player.e {
    public String a;
    public String b;
    private View c;
    private boolean h;
    private FrameLayout nZS;
    private FrescoThumbnailView nZU;
    private c.a nZV;
    private c nZT = null;
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
        this.nZS = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.nZU = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nZU.getLayoutParams();
        int aC = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (aC > 0) {
            layoutParams.topMargin -= aC;
            layoutParams.bottomMargin = 0;
        }
        this.nZU.setLayoutParams(layoutParams);
        this.nZU.setVisibility(0);
        this.nZU.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.nZU != null && !h.isEmpty(str)) {
            this.nZU.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.nZS != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.nZU.setVisibility(8);
        this.nZS.setVisibility(0);
        this.nZT = c.b(this.a, this.h, this.b);
        this.nZT.a(this.nZV);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.nZT);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.nZV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nZT != null) {
            this.nZT.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nZT != null) {
            this.nZT.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nZT != null) {
            this.nZT.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nZT != null) {
            this.nZT.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nZT != null) {
            this.nZT.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nZT != null) {
            this.nZT.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.nZT != null) {
            this.nZT.Vc();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nZT != null) {
            this.nZT.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nZT != null) {
            this.nZT.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nZT != null) {
            this.nZT.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nZT != null) {
            this.nZT.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nZT != null) {
            return this.nZT.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nZT != null) {
            this.nZT.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nZT != null) {
            this.nZT.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nZT != null) {
            this.nZT.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nZT != null) {
            this.nZT.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nZT != null) {
            this.nZT.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nZT != null) {
            this.nZT.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nZT != null) {
            this.nZT.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nZT != null) {
            return this.nZT.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.nZT != null) {
            return this.nZT.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nZT != null) {
            this.nZT.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nZT != null) {
            this.nZT.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nZT != null) {
            this.nZT.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nZT != null) {
            this.nZT.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nZT != null) {
            this.nZT.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nZT != null) {
            this.nZT.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nZT != null) {
            this.nZT.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nZT != null) {
            this.nZT.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nZT != null) {
            this.nZT.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nZT != null) {
            this.nZT.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nZT != null) {
            this.nZT.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nZT != null) {
            this.nZT.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nZT != null) {
            this.nZT.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nZT != null) {
            this.nZT.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nZT != null) {
            this.nZT.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nZT != null) {
            this.nZT.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nZT != null) {
            this.nZT.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nZT != null) {
            this.nZT.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nZT != null) {
            this.nZT.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(long j) {
        if (this.nZT != null) {
            this.nZT.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0892a
    public void c(int i) {
        if (this.nZT != null) {
            this.nZT.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nZT != null) {
            this.nZT.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void a(int i) {
        if (this.nZT != null) {
            this.nZT.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void D() {
        if (this.nZT != null) {
            this.nZT.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nZT != null) {
            this.nZT.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nZT != null) {
            this.nZT.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nZT != null) {
            this.nZT.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nZT != null) {
            this.nZT.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(IconConfig.Config config) {
        if (this.nZT != null) {
            this.nZT.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(BangInfo bangInfo, String str) {
        if (this.nZT != null) {
            this.nZT.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nZT != null) {
            this.nZT.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nZT != null) {
            this.nZT.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nZT != null) {
            this.nZT.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nZT != null) {
            this.nZT.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nZT != null) {
            this.nZT.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nZT != null) {
            this.nZT.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nZT != null) {
            this.nZT.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nZT != null) {
            this.nZT.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nZT != null) {
            this.nZT.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nZT != null) {
            this.nZT.P();
        }
    }
}
