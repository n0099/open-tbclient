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
    private FrescoThumbnailView mWR;
    private c.a mWS;
    private c mWQ = null;
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
        this.mWR = (FrescoThumbnailView) this.c.findViewById(a.f.view_cover);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWR.getLayoutParams();
        int aB = tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        if (aB > 0) {
            layoutParams.topMargin -= aB;
            layoutParams.bottomMargin = 0;
        }
        this.mWR.setLayoutParams(layoutParams);
        this.mWR.setVisibility(0);
        this.mWR.setBlur(true);
        a(this.a);
        if (this.g) {
            this.g = false;
            c();
        }
        return this.c;
    }

    public void a(String str) {
        if (this.mWR != null && !h.isEmpty(str)) {
            this.mWR.i(str, 0, 0, 0);
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
        this.mWR.setVisibility(8);
        this.d.setVisibility(0);
        this.mWQ = c.b(this.a, this.h, this.b);
        this.mWQ.a(this.mWS);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(a.f.game_fragment, this.mWQ);
        beginTransaction.commitAllowingStateLoss();
    }

    public void a(c.a aVar) {
        this.mWS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mWQ != null) {
            this.mWQ.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.mWQ != null) {
            this.mWQ.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.mWQ != null) {
            this.mWQ.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.mWQ != null) {
            this.mWQ.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mWQ != null) {
            this.mWQ.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.mWQ != null) {
            this.mWQ.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.mWQ != null) {
            this.mWQ.Z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.mWQ != null) {
            this.mWQ.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mWQ != null) {
            this.mWQ.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.mWQ != null) {
            this.mWQ.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.mWQ != null) {
            this.mWQ.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.mWQ != null) {
            return this.mWQ.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.mWQ != null) {
            this.mWQ.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.mWQ != null) {
            this.mWQ.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.mWQ != null) {
            this.mWQ.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.mWQ != null) {
            this.mWQ.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.mWQ != null) {
            this.mWQ.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.mWQ != null) {
            this.mWQ.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.mWQ != null) {
            this.mWQ.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mWQ != null) {
            return this.mWQ.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.mWQ != null) {
            return this.mWQ.a(i, keyEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.mWQ != null) {
            this.mWQ.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.mWQ != null) {
            this.mWQ.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.mWQ != null) {
            this.mWQ.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.mWQ != null) {
            this.mWQ.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.mWQ != null) {
            this.mWQ.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.mWQ != null) {
            this.mWQ.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.mWQ != null) {
            this.mWQ.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.mWQ != null) {
            this.mWQ.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.mWQ != null) {
            this.mWQ.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.mWQ != null) {
            this.mWQ.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.mWQ != null) {
            this.mWQ.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.mWQ != null) {
            this.mWQ.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.mWQ != null) {
            this.mWQ.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.mWQ != null) {
            this.mWQ.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.mWQ != null) {
            this.mWQ.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.mWQ != null) {
            this.mWQ.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mWQ != null) {
            this.mWQ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mWQ != null) {
            this.mWQ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWQ != null) {
            this.mWQ.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mWQ != null) {
            this.mWQ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mWQ != null) {
            this.mWQ.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWQ != null) {
            this.mWQ.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mWQ != null) {
            this.mWQ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mWQ != null) {
            this.mWQ.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mWQ != null) {
            this.mWQ.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mWQ != null) {
            this.mWQ.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.mWQ != null) {
            this.mWQ.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.mWQ != null) {
            this.mWQ.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        if (this.mWQ != null) {
            this.mWQ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        if (this.mWQ != null) {
            this.mWQ.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mWQ != null) {
            this.mWQ.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.mWQ != null) {
            this.mWQ.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.mWQ != null) {
            this.mWQ.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mWQ != null) {
            this.mWQ.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.mWQ != null) {
            this.mWQ.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mWQ != null) {
            this.mWQ.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.mWQ != null) {
            this.mWQ.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.mWQ != null) {
            this.mWQ.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mWQ != null) {
            this.mWQ.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mWQ != null) {
            this.mWQ.P();
        }
    }
}
