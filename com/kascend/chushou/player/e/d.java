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
    private FrescoThumbnailView nnb;
    private c.a nnc;
    private c nna = null;
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
        this.nnb = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nnb.getLayoutParams();
        int aw = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (aw > 0) {
            layoutParams.topMargin -= aw;
            layoutParams.bottomMargin = 0;
        }
        this.nnb.setLayoutParams(layoutParams);
        this.nnb.setVisibility(0);
        this.nnb.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.nnb != null && !h.isEmpty(str)) {
            this.nnb.i(str, 0, 0, 0);
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
        this.nnb.setVisibility(8);
        this.d.setVisibility(0);
        this.nna = c.b(this.a, this.h, this.b);
        this.nna.a(this.nnc);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.nna);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.nnc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nna != null) {
            this.nna.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nna != null) {
            this.nna.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nna != null) {
            this.nna.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nna != null) {
            this.nna.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nna != null) {
            this.nna.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nna != null) {
            this.nna.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.nna != null) {
            this.nna.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nna != null) {
            this.nna.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nna != null) {
            this.nna.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nna != null) {
            this.nna.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nna != null) {
            this.nna.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nna != null) {
            return this.nna.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nna != null) {
            this.nna.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nna != null) {
            this.nna.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nna != null) {
            this.nna.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nna != null) {
            this.nna.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nna != null) {
            this.nna.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nna != null) {
            this.nna.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nna != null) {
            this.nna.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nna != null) {
            return this.nna.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.nna != null) {
            return this.nna.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nna != null) {
            this.nna.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nna != null) {
            this.nna.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nna != null) {
            this.nna.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nna != null) {
            this.nna.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nna != null) {
            this.nna.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nna != null) {
            this.nna.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nna != null) {
            this.nna.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nna != null) {
            this.nna.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nna != null) {
            this.nna.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nna != null) {
            this.nna.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nna != null) {
            this.nna.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nna != null) {
            this.nna.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nna != null) {
            this.nna.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nna != null) {
            this.nna.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nna != null) {
            this.nna.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nna != null) {
            this.nna.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nna != null) {
            this.nna.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nna != null) {
            this.nna.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nna != null) {
            this.nna.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(long j) {
        if (this.nna != null) {
            this.nna.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0827a
    public void c(int i) {
        if (this.nna != null) {
            this.nna.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nna != null) {
            this.nna.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void a(int i) {
        if (this.nna != null) {
            this.nna.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void D() {
        if (this.nna != null) {
            this.nna.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nna != null) {
            this.nna.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nna != null) {
            this.nna.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nna != null) {
            this.nna.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nna != null) {
            this.nna.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(IconConfig.Config config) {
        if (this.nna != null) {
            this.nna.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(BangInfo bangInfo, String str) {
        if (this.nna != null) {
            this.nna.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nna != null) {
            this.nna.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nna != null) {
            this.nna.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nna != null) {
            this.nna.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nna != null) {
            this.nna.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nna != null) {
            this.nna.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nna != null) {
            this.nna.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nna != null) {
            this.nna.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nna != null) {
            this.nna.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nna != null) {
            this.nna.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nna != null) {
            this.nna.P();
        }
    }
}
