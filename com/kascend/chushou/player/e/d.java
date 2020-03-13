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
    private FrescoThumbnailView mXM;
    private c.a mXN;
    private c mXL = null;
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
        this.mXM = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXM.getLayoutParams();
        int aE = tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        if (aE > 0) {
            layoutParams.topMargin -= aE;
            layoutParams.bottomMargin = 0;
        }
        this.mXM.setLayoutParams(layoutParams);
        this.mXM.setVisibility(0);
        this.mXM.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mXM != null && !h.isEmpty(str)) {
            this.mXM.i(str, 0, 0, 0);
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
        this.mXM.setVisibility(8);
        this.d.setVisibility(0);
        this.mXL = c.b(this.a, this.h, this.b);
        this.mXL.a(this.mXN);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mXL);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mXN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mXL != null) {
            this.mXL.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mXL != null) {
            this.mXL.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mXL != null) {
            this.mXL.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mXL != null) {
            this.mXL.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mXL != null) {
            this.mXL.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mXL != null) {
            this.mXL.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mXL != null) {
            this.mXL.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mXL != null) {
            this.mXL.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mXL != null) {
            this.mXL.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mXL != null) {
            this.mXL.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mXL != null) {
            this.mXL.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mXL != null) {
            return this.mXL.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mXL != null) {
            this.mXL.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mXL != null) {
            this.mXL.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mXL != null) {
            this.mXL.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mXL != null) {
            this.mXL.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mXL != null) {
            this.mXL.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mXL != null) {
            this.mXL.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mXL != null) {
            this.mXL.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mXL != null) {
            return this.mXL.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mXL != null) {
            return this.mXL.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mXL != null) {
            this.mXL.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mXL != null) {
            this.mXL.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mXL != null) {
            this.mXL.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mXL != null) {
            this.mXL.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mXL != null) {
            this.mXL.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mXL != null) {
            this.mXL.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mXL != null) {
            this.mXL.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mXL != null) {
            this.mXL.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mXL != null) {
            this.mXL.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mXL != null) {
            this.mXL.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mXL != null) {
            this.mXL.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mXL != null) {
            this.mXL.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mXL != null) {
            this.mXL.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mXL != null) {
            this.mXL.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mXL != null) {
            this.mXL.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mXL != null) {
            this.mXL.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mXL != null) {
            this.mXL.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mXL != null) {
            this.mXL.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mXL != null) {
            this.mXL.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mXL != null) {
            this.mXL.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mXL != null) {
            this.mXL.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mXL != null) {
            this.mXL.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mXL != null) {
            this.mXL.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mXL != null) {
            this.mXL.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mXL != null) {
            this.mXL.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mXL != null) {
            this.mXL.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mXL != null) {
            this.mXL.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mXL != null) {
            this.mXL.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        if (this.mXL != null) {
            this.mXL.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        if (this.mXL != null) {
            this.mXL.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mXL != null) {
            this.mXL.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mXL != null) {
            this.mXL.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mXL != null) {
            this.mXL.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mXL != null) {
            this.mXL.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mXL != null) {
            this.mXL.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mXL != null) {
            this.mXL.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mXL != null) {
            this.mXL.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mXL != null) {
            this.mXL.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mXL != null) {
            this.mXL.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mXL != null) {
            this.mXL.P();
        }
    }
}
