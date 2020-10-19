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
    private FrameLayout opl;
    private FrescoThumbnailView opn;
    private c.a opo;
    private c opm = null;
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
        this.opl = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.opn = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.opn.getLayoutParams();
        int aD = tv.chushou.zues.utils.systemBar.b.aD(getActivity());
        if (aD > 0) {
            layoutParams.topMargin -= aD;
            layoutParams.bottomMargin = 0;
        }
        this.opn.setLayoutParams(layoutParams);
        this.opn.setVisibility(0);
        this.opn.setBlur(true);
        a(this.f4135a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.opn != null && !h.isEmpty(str)) {
            this.opn.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.opl != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.opn.setVisibility(8);
        this.opl.setVisibility(0);
        this.opm = c.b(this.f4135a, this.h, this.b);
        this.opm.a(this.opo);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.opm);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.opo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.opm != null) {
            this.opm.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.opm != null) {
            this.opm.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.opm != null) {
            this.opm.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.opm != null) {
            this.opm.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.opm != null) {
            this.opm.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.opm != null) {
            this.opm.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.opm != null) {
            this.opm.WZ();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.opm != null) {
            this.opm.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.opm != null) {
            this.opm.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.opm != null) {
            this.opm.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.opm != null) {
            this.opm.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.opm != null) {
            return this.opm.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.opm != null) {
            this.opm.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.opm != null) {
            this.opm.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.opm != null) {
            this.opm.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.opm != null) {
            this.opm.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.opm != null) {
            this.opm.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.opm != null) {
            this.opm.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.opm != null) {
            this.opm.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.opm != null) {
            return this.opm.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.opm != null) {
            return this.opm.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.opm != null) {
            this.opm.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.opm != null) {
            this.opm.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.opm != null) {
            this.opm.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.opm != null) {
            this.opm.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.opm != null) {
            this.opm.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.opm != null) {
            this.opm.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.opm != null) {
            this.opm.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.opm != null) {
            this.opm.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.opm != null) {
            this.opm.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.opm != null) {
            this.opm.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.opm != null) {
            this.opm.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.opm != null) {
            this.opm.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.opm != null) {
            this.opm.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.opm != null) {
            this.opm.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.opm != null) {
            this.opm.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.opm != null) {
            this.opm.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.opm != null) {
            this.opm.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.opm != null) {
            this.opm.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.opm != null) {
            this.opm.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(long j) {
        if (this.opm != null) {
            this.opm.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0910a
    public void c(int i) {
        if (this.opm != null) {
            this.opm.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.opm != null) {
            this.opm.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void a(int i) {
        if (this.opm != null) {
            this.opm.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void D() {
        if (this.opm != null) {
            this.opm.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.opm != null) {
            this.opm.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.opm != null) {
            this.opm.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.opm != null) {
            this.opm.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.opm != null) {
            this.opm.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(IconConfig.Config config) {
        if (this.opm != null) {
            this.opm.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(BangInfo bangInfo, String str) {
        if (this.opm != null) {
            this.opm.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.opm != null) {
            this.opm.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.opm != null) {
            this.opm.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.opm != null) {
            this.opm.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.opm != null) {
            this.opm.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.opm != null) {
            this.opm.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.opm != null) {
            this.opm.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.opm != null) {
            this.opm.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.opm != null) {
            this.opm.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.opm != null) {
            this.opm.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.opm != null) {
            this.opm.P();
        }
    }
}
