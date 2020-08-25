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
    private FrameLayout nPF;
    private FrescoThumbnailView nPH;
    private c.a nPI;
    private c nPG = null;
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
        this.nPF = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.nPH = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nPH.getLayoutParams();
        int ay = tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        if (ay > 0) {
            layoutParams.topMargin -= ay;
            layoutParams.bottomMargin = 0;
        }
        this.nPH.setLayoutParams(layoutParams);
        this.nPH.setVisibility(0);
        this.nPH.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.nPH != null && !h.isEmpty(str)) {
            this.nPH.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.nPF != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.nPH.setVisibility(8);
        this.nPF.setVisibility(0);
        this.nPG = c.b(this.a, this.h, this.b);
        this.nPG.a(this.nPI);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.nPG);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.nPI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nPG != null) {
            this.nPG.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nPG != null) {
            this.nPG.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nPG != null) {
            this.nPG.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nPG != null) {
            this.nPG.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nPG != null) {
            this.nPG.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nPG != null) {
            this.nPG.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.nPG != null) {
            this.nPG.Ut();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nPG != null) {
            this.nPG.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nPG != null) {
            this.nPG.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nPG != null) {
            this.nPG.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nPG != null) {
            this.nPG.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nPG != null) {
            return this.nPG.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nPG != null) {
            this.nPG.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nPG != null) {
            this.nPG.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nPG != null) {
            this.nPG.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nPG != null) {
            this.nPG.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nPG != null) {
            this.nPG.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nPG != null) {
            this.nPG.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nPG != null) {
            this.nPG.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nPG != null) {
            return this.nPG.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.nPG != null) {
            return this.nPG.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nPG != null) {
            this.nPG.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nPG != null) {
            this.nPG.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nPG != null) {
            this.nPG.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nPG != null) {
            this.nPG.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nPG != null) {
            this.nPG.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nPG != null) {
            this.nPG.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nPG != null) {
            this.nPG.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nPG != null) {
            this.nPG.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nPG != null) {
            this.nPG.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nPG != null) {
            this.nPG.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nPG != null) {
            this.nPG.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nPG != null) {
            this.nPG.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nPG != null) {
            this.nPG.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nPG != null) {
            this.nPG.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nPG != null) {
            this.nPG.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nPG != null) {
            this.nPG.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nPG != null) {
            this.nPG.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nPG != null) {
            this.nPG.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPG != null) {
            this.nPG.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nPG != null) {
            this.nPG.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nPG != null) {
            this.nPG.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPG != null) {
            this.nPG.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nPG != null) {
            this.nPG.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nPG != null) {
            this.nPG.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nPG != null) {
            this.nPG.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nPG != null) {
            this.nPG.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nPG != null) {
            this.nPG.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPG != null) {
            this.nPG.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        if (this.nPG != null) {
            this.nPG.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        if (this.nPG != null) {
            this.nPG.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nPG != null) {
            this.nPG.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nPG != null) {
            this.nPG.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nPG != null) {
            this.nPG.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nPG != null) {
            this.nPG.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nPG != null) {
            this.nPG.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nPG != null) {
            this.nPG.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nPG != null) {
            this.nPG.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nPG != null) {
            this.nPG.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nPG != null) {
            this.nPG.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nPG != null) {
            this.nPG.P();
        }
    }
}
