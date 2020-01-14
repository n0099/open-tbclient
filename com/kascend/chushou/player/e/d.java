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
/* loaded from: classes4.dex */
public class d extends com.kascend.chushou.player.e {
    public String a;
    public String b;
    private View c;
    private FrameLayout d;
    private boolean h;
    private FrescoThumbnailView mWW;
    private c.a mWX;
    private c mWV = null;
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
        this.mWW = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWW.getLayoutParams();
        int aB = tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        if (aB > 0) {
            layoutParams.topMargin -= aB;
            layoutParams.bottomMargin = 0;
        }
        this.mWW.setLayoutParams(layoutParams);
        this.mWW.setVisibility(0);
        this.mWW.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mWW != null && !h.isEmpty(str)) {
            this.mWW.i(str, 0, 0, 0);
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
        this.mWW.setVisibility(8);
        this.d.setVisibility(0);
        this.mWV = c.b(this.a, this.h, this.b);
        this.mWV.a(this.mWX);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mWV);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mWX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mWV != null) {
            this.mWV.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mWV != null) {
            this.mWV.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mWV != null) {
            this.mWV.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mWV != null) {
            this.mWV.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mWV != null) {
            this.mWV.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mWV != null) {
            this.mWV.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mWV != null) {
            this.mWV.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mWV != null) {
            this.mWV.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mWV != null) {
            this.mWV.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mWV != null) {
            this.mWV.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mWV != null) {
            this.mWV.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mWV != null) {
            return this.mWV.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mWV != null) {
            this.mWV.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mWV != null) {
            this.mWV.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mWV != null) {
            this.mWV.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mWV != null) {
            this.mWV.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mWV != null) {
            this.mWV.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mWV != null) {
            this.mWV.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mWV != null) {
            this.mWV.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mWV != null) {
            return this.mWV.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mWV != null) {
            return this.mWV.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mWV != null) {
            this.mWV.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mWV != null) {
            this.mWV.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mWV != null) {
            this.mWV.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mWV != null) {
            this.mWV.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mWV != null) {
            this.mWV.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mWV != null) {
            this.mWV.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mWV != null) {
            this.mWV.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mWV != null) {
            this.mWV.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mWV != null) {
            this.mWV.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mWV != null) {
            this.mWV.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mWV != null) {
            this.mWV.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mWV != null) {
            this.mWV.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mWV != null) {
            this.mWV.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mWV != null) {
            this.mWV.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mWV != null) {
            this.mWV.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mWV != null) {
            this.mWV.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mWV != null) {
            this.mWV.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mWV != null) {
            this.mWV.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWV != null) {
            this.mWV.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mWV != null) {
            this.mWV.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mWV != null) {
            this.mWV.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWV != null) {
            this.mWV.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mWV != null) {
            this.mWV.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mWV != null) {
            this.mWV.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mWV != null) {
            this.mWV.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mWV != null) {
            this.mWV.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mWV != null) {
            this.mWV.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWV != null) {
            this.mWV.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        if (this.mWV != null) {
            this.mWV.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        if (this.mWV != null) {
            this.mWV.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mWV != null) {
            this.mWV.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mWV != null) {
            this.mWV.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mWV != null) {
            this.mWV.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mWV != null) {
            this.mWV.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mWV != null) {
            this.mWV.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mWV != null) {
            this.mWV.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mWV != null) {
            this.mWV.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mWV != null) {
            this.mWV.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mWV != null) {
            this.mWV.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mWV != null) {
            this.mWV.P();
        }
    }
}
