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
    private FrameLayout d;
    private boolean h;
    private FrescoThumbnailView nvT;
    private c.a nvU;
    private c nvS = null;
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
        this.nvT = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nvT.getLayoutParams();
        int ax = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (ax > 0) {
            layoutParams.topMargin -= ax;
            layoutParams.bottomMargin = 0;
        }
        this.nvT.setLayoutParams(layoutParams);
        this.nvT.setVisibility(0);
        this.nvT.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.nvT != null && !h.isEmpty(str)) {
            this.nvT.i(str, 0, 0, 0);
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
        this.nvT.setVisibility(8);
        this.d.setVisibility(0);
        this.nvS = c.b(this.a, this.h, this.b);
        this.nvS.a(this.nvU);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.nvS);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.nvU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nvS != null) {
            this.nvS.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nvS != null) {
            this.nvS.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nvS != null) {
            this.nvS.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nvS != null) {
            this.nvS.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nvS != null) {
            this.nvS.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nvS != null) {
            this.nvS.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.nvS != null) {
            this.nvS.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nvS != null) {
            this.nvS.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nvS != null) {
            this.nvS.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nvS != null) {
            this.nvS.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nvS != null) {
            this.nvS.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nvS != null) {
            return this.nvS.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nvS != null) {
            this.nvS.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nvS != null) {
            this.nvS.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nvS != null) {
            this.nvS.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nvS != null) {
            this.nvS.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nvS != null) {
            this.nvS.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nvS != null) {
            this.nvS.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nvS != null) {
            this.nvS.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nvS != null) {
            return this.nvS.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.nvS != null) {
            return this.nvS.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nvS != null) {
            this.nvS.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nvS != null) {
            this.nvS.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nvS != null) {
            this.nvS.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nvS != null) {
            this.nvS.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nvS != null) {
            this.nvS.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nvS != null) {
            this.nvS.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nvS != null) {
            this.nvS.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nvS != null) {
            this.nvS.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nvS != null) {
            this.nvS.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nvS != null) {
            this.nvS.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nvS != null) {
            this.nvS.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nvS != null) {
            this.nvS.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nvS != null) {
            this.nvS.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nvS != null) {
            this.nvS.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nvS != null) {
            this.nvS.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nvS != null) {
            this.nvS.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nvS != null) {
            this.nvS.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nvS != null) {
            this.nvS.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nvS != null) {
            this.nvS.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.nvS != null) {
            this.nvS.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.nvS != null) {
            this.nvS.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nvS != null) {
            this.nvS.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nvS != null) {
            this.nvS.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nvS != null) {
            this.nvS.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nvS != null) {
            this.nvS.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nvS != null) {
            this.nvS.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nvS != null) {
            this.nvS.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nvS != null) {
            this.nvS.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        if (this.nvS != null) {
            this.nvS.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        if (this.nvS != null) {
            this.nvS.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nvS != null) {
            this.nvS.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nvS != null) {
            this.nvS.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nvS != null) {
            this.nvS.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nvS != null) {
            this.nvS.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nvS != null) {
            this.nvS.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nvS != null) {
            this.nvS.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nvS != null) {
            this.nvS.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nvS != null) {
            this.nvS.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nvS != null) {
            this.nvS.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nvS != null) {
            this.nvS.P();
        }
    }
}
