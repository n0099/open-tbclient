package com.kascend.chushou.player.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.d.j;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.e.c;
import com.kascend.chushou.player.g;
import com.kascend.chushou.widget.VideoVerticalViewPager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class e extends com.kascend.chushou.player.e {
    public String c;
    public String d;
    private View f;
    private View h;
    private List<d> m;
    private VideoVerticalViewPager nPJ;
    private d nPK;
    private d nPL;
    private d nPM;
    private d nPN;
    private Context nPO;
    private ListItem nPQ;
    private ListItem nPR;
    private boolean q;
    private boolean u;
    private String v;
    private boolean o = false;
    private int p = -1;
    protected com.kascend.chushou.player.b nPP = null;
    public List<ListItem> b = new ArrayList();
    private boolean r = false;
    c.a nPS = new c.a() { // from class: com.kascend.chushou.player.e.e.2
        @Override // com.kascend.chushou.player.e.c.a
        public void a(boolean z) {
            if (e.this.r && e.this.nPJ != null) {
                e.this.nPJ.setNoFocus(!z);
            }
        }

        @Override // com.kascend.chushou.player.e.c.a
        public void a() {
            e.this.u = true;
            if (e.this.r && e.this.nPJ != null) {
                e.this.nPJ.setNoFocus(true);
            }
        }
    };

    public static e b(String str, boolean z, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("cover", str);
        bundle.putBoolean("initViewAsync", z);
        bundle.putString("liveType", str2);
        bundle.putString("roomId", str3);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nPO = getActivity();
        this.c = getArguments().getString("cover");
        this.q = getArguments().getBoolean("initViewAsync");
        this.d = getArguments().getString("liveType");
        this.v = getArguments().getString("roomId");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f = layoutInflater.inflate(a.h.videoplayer_root_view_faceshow, viewGroup, false);
        this.nPJ = (VideoVerticalViewPager) this.f.findViewById(a.f.viewpager);
        this.nPJ.setOverScrollMode(2);
        return this.f;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        a();
    }

    private void a() {
        String str;
        String str2;
        this.nPP = ((VideoPlayer) this.nPO).dYD();
        b();
        if (this.nPQ != null) {
            str = !h.isEmpty(this.nPQ.mOriginalCover) ? this.nPQ.mOriginalCover : this.nPQ.mCover;
        } else {
            str = "";
        }
        this.nPK = d.c(str, true, this.d);
        this.nPL = d.c(this.c, this.q, this.d);
        if (this.nPR != null) {
            str2 = !h.isEmpty(this.nPR.mOriginalCover) ? this.nPR.mOriginalCover : this.nPR.mCover;
        } else {
            str2 = "";
        }
        this.nPM = d.c(str2, true, this.d);
        this.m = new ArrayList();
        this.m.add(this.nPK);
        this.m.add(this.nPL);
        this.m.add(this.nPM);
        this.nPJ.setAdapter(new a(getChildFragmentManager()));
        this.nPJ.setCurrentItem(1, false);
        this.p = 1;
        this.nPN = this.m.get(1);
        if (this.nPN != null) {
            this.nPN.a();
            this.nPN.a(this.nPS);
        }
        this.nPJ.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.player.e.e.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                if (e.this.p != i && e.this.r) {
                    if (e.this.nPN != null) {
                        e.this.nPN.b();
                    }
                    RxExecutor.postDelayed(new io.reactivex.disposables.a(), EventThread.MAIN_THREAD, 150L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.e.1.1
                        /* JADX WARN: Can't wrap try/catch for region: R(14:7|(13:43|44|(1:11)(1:42)|12|13|(1:15)|17|(1:19)(1:39)|(1:23)|24|(2:26|(1:30))(2:34|(1:38))|31|32)|9|(0)(0)|12|13|(0)|17|(0)(0)|(2:21|23)|24|(0)(0)|31|32) */
                        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e6, code lost:
                            r0 = move-exception;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
                            r0.printStackTrace();
                         */
                        /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
                        /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: JSONException -> 0x00e6, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:14:0x0041, B:16:0x0053), top: B:44:0x0041 }] */
                        /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
                        /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
                        /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
                        /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
                        /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            JSONObject jSONObject;
                            JSONObject jSONObject2;
                            com.kascend.chushou.player.feedback.a aVar;
                            if (e.this.nPO != null && e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                                if (e.this.nPP != null) {
                                    try {
                                        jSONObject = new JSONObject(e.this.nPP.h);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jSONObject2 = jSONObject != null ? new JSONObject() : jSONObject;
                                    jSONObject2.put("tag_from_view", "1");
                                    if (jSONObject2.has("_thumb")) {
                                        jSONObject2.remove("_thumb");
                                    }
                                    aVar = !(e.this.nPO instanceof VideoPlayer) ? ((VideoPlayer) e.this.nPO).nIf : null;
                                    if (aVar != null && aVar.nQu != null) {
                                        aVar.nQu.time = System.currentTimeMillis() - aVar.b;
                                        aVar.nQu.roomId = e.this.v;
                                        aVar.a();
                                        aVar.nQu.reset();
                                        aVar.b = System.currentTimeMillis();
                                    }
                                    if (i <= e.this.p) {
                                        com.kascend.chushou.d.e.a(e.this.nPO, e.this.nPR, jSONObject2);
                                        if (aVar != null && aVar.nQu != null) {
                                            aVar.nQu.roomId = e.this.nPR.mRoomId;
                                            aVar.nQu.enterType = 2;
                                        }
                                    } else {
                                        com.kascend.chushou.d.e.a(e.this.nPO, e.this.nPQ, jSONObject2);
                                        if (aVar != null && aVar.nQu != null) {
                                            aVar.nQu.roomId = e.this.nPQ.mRoomId;
                                            aVar.nQu.enterType = 3;
                                        }
                                    }
                                    e.this.p = i;
                                }
                                jSONObject = null;
                                if (jSONObject != null) {
                                }
                                jSONObject2.put("tag_from_view", "1");
                                if (jSONObject2.has("_thumb")) {
                                }
                                if (!(e.this.nPO instanceof VideoPlayer)) {
                                }
                                if (aVar != null) {
                                    aVar.nQu.time = System.currentTimeMillis() - aVar.b;
                                    aVar.nQu.roomId = e.this.v;
                                    aVar.a();
                                    aVar.nQu.reset();
                                    aVar.b = System.currentTimeMillis();
                                }
                                if (i <= e.this.p) {
                                }
                                e.this.p = i;
                            }
                        }
                    });
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        ((VideoPlayer) this.nPO).n();
    }

    private void b() {
        if (this.nPP != null && !h.isEmpty(this.nPP.t)) {
            this.b.clear();
            if (this.nPP != null && !h.isEmpty(this.nPP.t)) {
                this.b.addAll(this.nPP.t);
            }
            if (!h.isEmpty(this.b) && !h.isEmpty(this.v)) {
                int i = 0;
                while (true) {
                    if (i >= this.b.size()) {
                        i = -1;
                        break;
                    } else if (this.v.equals(this.b.get(i).mTargetKey)) {
                        break;
                    } else {
                        i++;
                    }
                }
                int size = this.b.size();
                if (i != -1 && size >= 3) {
                    this.r = true;
                    if (this.u && this.nPJ != null) {
                        this.nPJ.setNoFocus(true);
                    }
                    if (i - 1 < 0) {
                        this.nPQ = this.b.get(size - 1);
                    } else {
                        this.nPQ = this.b.get(i - 1);
                    }
                    a(this.nPQ.mRoomId, this.nPQ.mLiveType);
                    if (this.nPK != null) {
                        if (!h.isEmpty(this.nPQ.mOriginalCover)) {
                            this.nPK.a(this.nPQ.mOriginalCover);
                        } else {
                            this.nPK.a(this.nPQ.mCover);
                        }
                    }
                    if (i + 1 >= size) {
                        this.nPR = this.b.get(0);
                    } else {
                        this.nPR = this.b.get(i + 1);
                    }
                    a(this.nPR.mRoomId, this.nPR.mLiveType);
                    if (this.nPM != null) {
                        if (!h.isEmpty(this.nPR.mOriginalCover)) {
                            this.nPM.a(this.nPR.mOriginalCover);
                        } else {
                            this.nPM.a(this.nPR.mCover);
                        }
                    }
                }
            }
        }
    }

    private String a(String str) {
        if ("4".equals(str)) {
            return TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
        }
        return "2" + Constants.ACCEPT_TIME_SEPARATOR_SP + "1" + Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    }

    private void a(String str, String str2) {
        j.dYx().a(str, a(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) e.this.m.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return e.this.m.size();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nPN != null) {
            this.nPN.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nPN != null) {
            this.nPN.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nPN != null) {
            this.nPN.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nPN != null) {
            this.nPN.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nPN != null) {
            this.nPN.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nPN != null) {
            this.nPN.e(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nPN != null) {
            this.nPN.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nPN != null) {
            this.nPN.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nPN != null) {
            this.nPN.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nPN != null) {
            this.nPN.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nPN != null) {
            return this.nPN.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nPN != null) {
            this.nPN.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nPN != null) {
            this.nPN.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nPN != null) {
            this.nPN.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nPN != null) {
            this.nPN.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nPN != null) {
            this.nPN.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nPN != null) {
            this.nPN.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nPN != null) {
            this.nPN.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nPN != null) {
            return this.nPN.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
            return true;
        } else if (this.nPN != null) {
            return this.nPN.a(i, keyEvent);
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.e
    public void w() {
        b();
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
        if (this.nPN != null) {
            this.nPN.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nPN != null) {
            this.nPN.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nPN != null) {
            this.nPN.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nPN != null) {
            this.nPN.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nPN != null) {
            this.nPN.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nPN != null) {
            this.nPN.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nPN != null) {
            this.nPN.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nPN != null) {
            this.nPN.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nPN != null) {
            this.nPN.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nPN != null) {
            this.nPN.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nPN != null) {
            this.nPN.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nPN != null) {
            this.nPN.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nPN != null) {
            this.nPN.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nPN != null) {
            this.nPN.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nPN != null) {
            this.nPN.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nPN != null) {
            this.nPN.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nPN != null) {
            this.nPN.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nPN != null) {
            this.nPN.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPN != null) {
            this.nPN.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nPN != null) {
            this.nPN.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nPN != null) {
            this.nPN.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPN != null) {
            this.nPN.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nPN != null) {
            this.nPN.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nPN != null) {
            this.nPN.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nPN != null) {
            this.nPN.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nPN != null) {
            this.nPN.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nPN != null) {
            this.nPN.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nPN != null) {
            this.nPN.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        if (this.nPN != null) {
            this.nPN.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        if (this.nPN != null) {
            this.nPN.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nPN != null) {
            this.nPN.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nPN != null) {
            this.nPN.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nPN != null) {
            this.nPN.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nPN != null) {
            this.nPN.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nPN != null) {
            this.nPN.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nPN != null) {
            this.nPN.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nPN != null) {
            this.nPN.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nPN != null) {
            this.nPN.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j(boolean z) {
        if (this.nPJ != null) {
            this.nPJ.setNoFocus(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nPN != null) {
            this.nPN.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nPN != null) {
            this.nPN.P();
        }
    }
}
