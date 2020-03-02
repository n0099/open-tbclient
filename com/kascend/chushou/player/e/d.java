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
    private FrescoThumbnailView mXB;
    private c.a mXC;
    private c mXA = null;
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
        this.mXB = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXB.getLayoutParams();
        int aC = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (aC > 0) {
            layoutParams.topMargin -= aC;
            layoutParams.bottomMargin = 0;
        }
        this.mXB.setLayoutParams(layoutParams);
        this.mXB.setVisibility(0);
        this.mXB.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mXB != null && !h.isEmpty(str)) {
            this.mXB.i(str, 0, 0, 0);
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
        this.mXB.setVisibility(8);
        this.d.setVisibility(0);
        this.mXA = c.b(this.a, this.h, this.b);
        this.mXA.a(this.mXC);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mXA);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mXC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mXA != null) {
            this.mXA.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mXA != null) {
            this.mXA.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mXA != null) {
            this.mXA.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mXA != null) {
            this.mXA.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mXA != null) {
            this.mXA.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mXA != null) {
            this.mXA.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mXA != null) {
            this.mXA.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mXA != null) {
            this.mXA.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mXA != null) {
            this.mXA.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mXA != null) {
            this.mXA.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mXA != null) {
            this.mXA.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mXA != null) {
            return this.mXA.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mXA != null) {
            this.mXA.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mXA != null) {
            this.mXA.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mXA != null) {
            this.mXA.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mXA != null) {
            this.mXA.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mXA != null) {
            this.mXA.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mXA != null) {
            this.mXA.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mXA != null) {
            this.mXA.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mXA != null) {
            return this.mXA.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mXA != null) {
            return this.mXA.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mXA != null) {
            this.mXA.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mXA != null) {
            this.mXA.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mXA != null) {
            this.mXA.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mXA != null) {
            this.mXA.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mXA != null) {
            this.mXA.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mXA != null) {
            this.mXA.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mXA != null) {
            this.mXA.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mXA != null) {
            this.mXA.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mXA != null) {
            this.mXA.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mXA != null) {
            this.mXA.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mXA != null) {
            this.mXA.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mXA != null) {
            this.mXA.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mXA != null) {
            this.mXA.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mXA != null) {
            this.mXA.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mXA != null) {
            this.mXA.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mXA != null) {
            this.mXA.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mXA != null) {
            this.mXA.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mXA != null) {
            this.mXA.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mXA != null) {
            this.mXA.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mXA != null) {
            this.mXA.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mXA != null) {
            this.mXA.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mXA != null) {
            this.mXA.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mXA != null) {
            this.mXA.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mXA != null) {
            this.mXA.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mXA != null) {
            this.mXA.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mXA != null) {
            this.mXA.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mXA != null) {
            this.mXA.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mXA != null) {
            this.mXA.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        if (this.mXA != null) {
            this.mXA.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        if (this.mXA != null) {
            this.mXA.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mXA != null) {
            this.mXA.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mXA != null) {
            this.mXA.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mXA != null) {
            this.mXA.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mXA != null) {
            this.mXA.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mXA != null) {
            this.mXA.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mXA != null) {
            this.mXA.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mXA != null) {
            this.mXA.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mXA != null) {
            this.mXA.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mXA != null) {
            this.mXA.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mXA != null) {
            this.mXA.P();
        }
    }
}
