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

    /* renamed from: a  reason: collision with root package name */
    public String f4135a;
    public String b;
    private View c;
    private boolean h;
    private FrameLayout pqc;
    private FrescoThumbnailView pqe;
    private c.a pqf;
    private c pqd = null;
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
        this.f4135a = getArguments().getString("cover");
        this.h = getArguments().getBoolean("initViewAsync");
        this.b = getArguments().getString("liveType");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.c = layoutInflater.inflate(a.h.videoplayer_root_view_show_parent, viewGroup, false);
        this.pqc = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.pqe = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pqe.getLayoutParams();
        int aI = tv.chushou.zues.utils.systemBar.b.aI(getActivity());
        if (aI > 0) {
            layoutParams.topMargin -= aI;
            layoutParams.bottomMargin = 0;
        }
        this.pqe.setLayoutParams(layoutParams);
        this.pqe.setVisibility(0);
        this.pqe.setBlur(true);
        a(this.f4135a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.pqe != null && !h.isEmpty(str)) {
            this.pqe.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.pqc != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.pqe.setVisibility(8);
        this.pqc.setVisibility(0);
        this.pqd = c.b(this.f4135a, this.h, this.b);
        this.pqd.a(this.pqf);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.pqd);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.pqf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.pqd != null) {
            this.pqd.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.pqd != null) {
            this.pqd.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.pqd != null) {
            this.pqd.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.pqd != null) {
            this.pqd.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.pqd != null) {
            this.pqd.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.pqd != null) {
            this.pqd.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.pqd != null) {
            this.pqd.abs();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.pqd != null) {
            this.pqd.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.pqd != null) {
            this.pqd.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.pqd != null) {
            this.pqd.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.pqd != null) {
            this.pqd.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.pqd != null) {
            return this.pqd.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.pqd != null) {
            this.pqd.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.pqd != null) {
            this.pqd.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.pqd != null) {
            this.pqd.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.pqd != null) {
            this.pqd.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.pqd != null) {
            this.pqd.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.pqd != null) {
            this.pqd.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.pqd != null) {
            this.pqd.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.pqd != null) {
            return this.pqd.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.pqd != null) {
            return this.pqd.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.pqd != null) {
            this.pqd.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.pqd != null) {
            this.pqd.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.pqd != null) {
            this.pqd.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.pqd != null) {
            this.pqd.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.pqd != null) {
            this.pqd.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.pqd != null) {
            this.pqd.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.pqd != null) {
            this.pqd.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.pqd != null) {
            this.pqd.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.pqd != null) {
            this.pqd.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.pqd != null) {
            this.pqd.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.pqd != null) {
            this.pqd.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.pqd != null) {
            this.pqd.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.pqd != null) {
            this.pqd.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.pqd != null) {
            this.pqd.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.pqd != null) {
            this.pqd.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.pqd != null) {
            this.pqd.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pqd != null) {
            this.pqd.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pqd != null) {
            this.pqd.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pqd != null) {
            this.pqd.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(long j) {
        if (this.pqd != null) {
            this.pqd.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1001a
    public void c(int i) {
        if (this.pqd != null) {
            this.pqd.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pqd != null) {
            this.pqd.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void a(int i) {
        if (this.pqd != null) {
            this.pqd.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void D() {
        if (this.pqd != null) {
            this.pqd.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.pqd != null) {
            this.pqd.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.pqd != null) {
            this.pqd.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.pqd != null) {
            this.pqd.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pqd != null) {
            this.pqd.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(IconConfig.Config config) {
        if (this.pqd != null) {
            this.pqd.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(BangInfo bangInfo, String str) {
        if (this.pqd != null) {
            this.pqd.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pqd != null) {
            this.pqd.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.pqd != null) {
            this.pqd.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.pqd != null) {
            this.pqd.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pqd != null) {
            this.pqd.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.pqd != null) {
            this.pqd.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.pqd != null) {
            this.pqd.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.pqd != null) {
            this.pqd.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.pqd != null) {
            this.pqd.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pqd != null) {
            this.pqd.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pqd != null) {
            this.pqd.P();
        }
    }
}
