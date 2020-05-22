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
    private FrescoThumbnailView mPT;
    private c.a mPU;
    private c mPS = null;
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
        this.mPT = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPT.getLayoutParams();
        int aw = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (aw > 0) {
            layoutParams.topMargin -= aw;
            layoutParams.bottomMargin = 0;
        }
        this.mPT.setLayoutParams(layoutParams);
        this.mPT.setVisibility(0);
        this.mPT.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mPT != null && !h.isEmpty(str)) {
            this.mPT.i(str, 0, 0, 0);
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
        this.mPT.setVisibility(8);
        this.d.setVisibility(0);
        this.mPS = c.b(this.a, this.h, this.b);
        this.mPS.a(this.mPU);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mPS);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mPU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mPS != null) {
            this.mPS.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mPS != null) {
            this.mPS.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mPS != null) {
            this.mPS.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mPS != null) {
            this.mPS.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mPS != null) {
            this.mPS.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mPS != null) {
            this.mPS.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mPS != null) {
            this.mPS.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mPS != null) {
            this.mPS.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mPS != null) {
            this.mPS.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mPS != null) {
            this.mPS.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mPS != null) {
            this.mPS.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mPS != null) {
            return this.mPS.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mPS != null) {
            this.mPS.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mPS != null) {
            this.mPS.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mPS != null) {
            this.mPS.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mPS != null) {
            this.mPS.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mPS != null) {
            this.mPS.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mPS != null) {
            this.mPS.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mPS != null) {
            this.mPS.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mPS != null) {
            return this.mPS.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mPS != null) {
            return this.mPS.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mPS != null) {
            this.mPS.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mPS != null) {
            this.mPS.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mPS != null) {
            this.mPS.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mPS != null) {
            this.mPS.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mPS != null) {
            this.mPS.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mPS != null) {
            this.mPS.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mPS != null) {
            this.mPS.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mPS != null) {
            this.mPS.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mPS != null) {
            this.mPS.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mPS != null) {
            this.mPS.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mPS != null) {
            this.mPS.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mPS != null) {
            this.mPS.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mPS != null) {
            this.mPS.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mPS != null) {
            this.mPS.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mPS != null) {
            this.mPS.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mPS != null) {
            this.mPS.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mPS != null) {
            this.mPS.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mPS != null) {
            this.mPS.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mPS != null) {
            this.mPS.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(long j) {
        if (this.mPS != null) {
            this.mPS.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0807a
    public void c(int i) {
        if (this.mPS != null) {
            this.mPS.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mPS != null) {
            this.mPS.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void a(int i) {
        if (this.mPS != null) {
            this.mPS.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void D() {
        if (this.mPS != null) {
            this.mPS.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mPS != null) {
            this.mPS.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mPS != null) {
            this.mPS.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mPS != null) {
            this.mPS.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mPS != null) {
            this.mPS.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(IconConfig.Config config) {
        if (this.mPS != null) {
            this.mPS.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(BangInfo bangInfo, String str) {
        if (this.mPS != null) {
            this.mPS.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mPS != null) {
            this.mPS.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mPS != null) {
            this.mPS.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mPS != null) {
            this.mPS.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mPS != null) {
            this.mPS.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mPS != null) {
            this.mPS.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mPS != null) {
            this.mPS.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mPS != null) {
            this.mPS.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mPS != null) {
            this.mPS.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mPS != null) {
            this.mPS.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mPS != null) {
            this.mPS.P();
        }
    }
}
