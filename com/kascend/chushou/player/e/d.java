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
    private FrameLayout prF;
    private FrescoThumbnailView prH;
    private c.a prI;
    private c prG = null;
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
        this.prF = (FrameLayout) this.c.findViewById(a.f.game_fragment);
        this.prH = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.prH.getLayoutParams();
        int aH = tv.chushou.zues.utils.systemBar.b.aH(getActivity());
        if (aH > 0) {
            layoutParams.topMargin -= aH;
            layoutParams.bottomMargin = 0;
        }
        this.prH.setLayoutParams(layoutParams);
        this.prH.setVisibility(0);
        this.prH.setBlur(true);
        a(this.f4135a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.prH != null && !h.isEmpty(str)) {
            this.prH.i(str, 0, 0, 0);
        }
    }

    public void a() {
        if (this.prF != null) {
            c();
        } else {
            this.g = true;
        }
    }

    private void c() {
        this.prH.setVisibility(8);
        this.prF.setVisibility(0);
        this.prG = c.b(this.f4135a, this.h, this.b);
        this.prG.a(this.prI);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.prG);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.prI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.prG != null) {
            this.prG.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.prG != null) {
            this.prG.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.prG != null) {
            this.prG.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.prG != null) {
            this.prG.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.prG != null) {
            this.prG.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.prG != null) {
            this.prG.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.prG != null) {
            this.prG.aaJ();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.prG != null) {
            this.prG.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.prG != null) {
            this.prG.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.prG != null) {
            this.prG.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.prG != null) {
            this.prG.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.prG != null) {
            return this.prG.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.prG != null) {
            this.prG.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.prG != null) {
            this.prG.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.prG != null) {
            this.prG.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.prG != null) {
            this.prG.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.prG != null) {
            this.prG.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.prG != null) {
            this.prG.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.prG != null) {
            this.prG.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.prG != null) {
            return this.prG.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.prG != null) {
            return this.prG.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.prG != null) {
            this.prG.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.prG != null) {
            this.prG.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.prG != null) {
            this.prG.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.prG != null) {
            this.prG.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.prG != null) {
            this.prG.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.prG != null) {
            this.prG.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.prG != null) {
            this.prG.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.prG != null) {
            this.prG.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.prG != null) {
            this.prG.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.prG != null) {
            this.prG.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.prG != null) {
            this.prG.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.prG != null) {
            this.prG.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.prG != null) {
            this.prG.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.prG != null) {
            this.prG.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.prG != null) {
            this.prG.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.prG != null) {
            this.prG.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.prG != null) {
            this.prG.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.prG != null) {
            this.prG.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.prG != null) {
            this.prG.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(long j) {
        if (this.prG != null) {
            this.prG.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1004a
    public void c(int i) {
        if (this.prG != null) {
            this.prG.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.prG != null) {
            this.prG.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void a(int i) {
        if (this.prG != null) {
            this.prG.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void D() {
        if (this.prG != null) {
            this.prG.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.prG != null) {
            this.prG.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.prG != null) {
            this.prG.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.prG != null) {
            this.prG.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.prG != null) {
            this.prG.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(IconConfig.Config config) {
        if (this.prG != null) {
            this.prG.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(BangInfo bangInfo, String str) {
        if (this.prG != null) {
            this.prG.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.prG != null) {
            this.prG.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.prG != null) {
            this.prG.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.prG != null) {
            this.prG.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.prG != null) {
            this.prG.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.prG != null) {
            this.prG.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.prG != null) {
            this.prG.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.prG != null) {
            this.prG.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.prG != null) {
            this.prG.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.prG != null) {
            this.prG.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.prG != null) {
            this.prG.P();
        }
    }
}
