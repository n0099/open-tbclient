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
    private FrameLayout nPX;
    private FrescoThumbnailView nPZ;
    private c.a nQa;
    private c nPY = null;
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
        this.nPX = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.nPZ = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nPZ.getLayoutParams();
        int ay = tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        if (ay > 0) {
            layoutParams.topMargin -= ay;
            layoutParams.bottomMargin = 0;
        }
        this.nPZ.setLayoutParams(layoutParams);
        this.nPZ.setVisibility(0);
        this.nPZ.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.nPZ != null && !h.isEmpty(str)) {
            this.nPZ.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.nPX != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.nPZ.setVisibility(8);
        this.nPX.setVisibility(0);
        this.nPY = c.b(this.a, this.h, this.b);
        this.nPY.a(this.nQa);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.nPY);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.nQa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nPY != null) {
            this.nPY.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nPY != null) {
            this.nPY.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nPY != null) {
            this.nPY.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nPY != null) {
            this.nPY.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nPY != null) {
            this.nPY.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nPY != null) {
            this.nPY.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.nPY != null) {
            this.nPY.Ut();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nPY != null) {
            this.nPY.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nPY != null) {
            this.nPY.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nPY != null) {
            this.nPY.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nPY != null) {
            this.nPY.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nPY != null) {
            return this.nPY.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nPY != null) {
            this.nPY.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nPY != null) {
            this.nPY.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nPY != null) {
            this.nPY.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nPY != null) {
            this.nPY.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nPY != null) {
            this.nPY.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nPY != null) {
            this.nPY.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nPY != null) {
            this.nPY.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nPY != null) {
            return this.nPY.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.nPY != null) {
            return this.nPY.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nPY != null) {
            this.nPY.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nPY != null) {
            this.nPY.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nPY != null) {
            this.nPY.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nPY != null) {
            this.nPY.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nPY != null) {
            this.nPY.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nPY != null) {
            this.nPY.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nPY != null) {
            this.nPY.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nPY != null) {
            this.nPY.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nPY != null) {
            this.nPY.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nPY != null) {
            this.nPY.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nPY != null) {
            this.nPY.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nPY != null) {
            this.nPY.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nPY != null) {
            this.nPY.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nPY != null) {
            this.nPY.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nPY != null) {
            this.nPY.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nPY != null) {
            this.nPY.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nPY != null) {
            this.nPY.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nPY != null) {
            this.nPY.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPY != null) {
            this.nPY.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nPY != null) {
            this.nPY.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nPY != null) {
            this.nPY.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPY != null) {
            this.nPY.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nPY != null) {
            this.nPY.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nPY != null) {
            this.nPY.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nPY != null) {
            this.nPY.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nPY != null) {
            this.nPY.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nPY != null) {
            this.nPY.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPY != null) {
            this.nPY.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        if (this.nPY != null) {
            this.nPY.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        if (this.nPY != null) {
            this.nPY.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nPY != null) {
            this.nPY.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nPY != null) {
            this.nPY.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nPY != null) {
            this.nPY.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nPY != null) {
            this.nPY.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nPY != null) {
            this.nPY.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nPY != null) {
            this.nPY.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nPY != null) {
            this.nPY.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nPY != null) {
            this.nPY.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nPY != null) {
            this.nPY.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nPY != null) {
            this.nPY.P();
        }
    }
}
