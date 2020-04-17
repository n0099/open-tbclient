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
    private FrescoThumbnailView mvU;
    private c.a mvV;
    private c mvT = null;
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
        this.mvU = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mvU.getLayoutParams();
        int ax = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (ax > 0) {
            layoutParams.topMargin -= ax;
            layoutParams.bottomMargin = 0;
        }
        this.mvU.setLayoutParams(layoutParams);
        this.mvU.setVisibility(0);
        this.mvU.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mvU != null && !h.isEmpty(str)) {
            this.mvU.i(str, 0, 0, 0);
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
        this.mvU.setVisibility(8);
        this.d.setVisibility(0);
        this.mvT = c.b(this.a, this.h, this.b);
        this.mvT.a(this.mvV);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mvT);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mvV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mvT != null) {
            this.mvT.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mvT != null) {
            this.mvT.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mvT != null) {
            this.mvT.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mvT != null) {
            this.mvT.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mvT != null) {
            this.mvT.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mvT != null) {
            this.mvT.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mvT != null) {
            this.mvT.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mvT != null) {
            this.mvT.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mvT != null) {
            this.mvT.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mvT != null) {
            this.mvT.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mvT != null) {
            this.mvT.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mvT != null) {
            return this.mvT.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mvT != null) {
            this.mvT.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mvT != null) {
            this.mvT.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mvT != null) {
            this.mvT.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mvT != null) {
            this.mvT.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mvT != null) {
            this.mvT.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mvT != null) {
            this.mvT.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mvT != null) {
            this.mvT.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mvT != null) {
            return this.mvT.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mvT != null) {
            return this.mvT.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mvT != null) {
            this.mvT.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mvT != null) {
            this.mvT.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mvT != null) {
            this.mvT.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mvT != null) {
            this.mvT.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mvT != null) {
            this.mvT.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mvT != null) {
            this.mvT.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mvT != null) {
            this.mvT.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mvT != null) {
            this.mvT.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mvT != null) {
            this.mvT.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mvT != null) {
            this.mvT.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mvT != null) {
            this.mvT.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mvT != null) {
            this.mvT.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mvT != null) {
            this.mvT.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mvT != null) {
            this.mvT.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mvT != null) {
            this.mvT.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mvT != null) {
            this.mvT.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mvT != null) {
            this.mvT.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mvT != null) {
            this.mvT.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mvT != null) {
            this.mvT.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(long j) {
        if (this.mvT != null) {
            this.mvT.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0728a
    public void c(int i) {
        if (this.mvT != null) {
            this.mvT.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mvT != null) {
            this.mvT.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void a(int i) {
        if (this.mvT != null) {
            this.mvT.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void D() {
        if (this.mvT != null) {
            this.mvT.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mvT != null) {
            this.mvT.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mvT != null) {
            this.mvT.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mvT != null) {
            this.mvT.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mvT != null) {
            this.mvT.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(IconConfig.Config config) {
        if (this.mvT != null) {
            this.mvT.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        if (this.mvT != null) {
            this.mvT.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mvT != null) {
            this.mvT.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mvT != null) {
            this.mvT.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mvT != null) {
            this.mvT.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mvT != null) {
            this.mvT.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mvT != null) {
            this.mvT.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mvT != null) {
            this.mvT.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mvT != null) {
            this.mvT.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mvT != null) {
            this.mvT.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mvT != null) {
            this.mvT.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mvT != null) {
            this.mvT.P();
        }
    }
}
