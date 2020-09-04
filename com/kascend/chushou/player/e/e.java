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
    private VideoVerticalViewPager nQb;
    private d nQc;
    private d nQd;
    private d nQe;
    private d nQf;
    private Context nQg;
    private ListItem nQi;
    private ListItem nQj;
    private boolean q;
    private boolean u;
    private String v;
    private boolean o = false;
    private int p = -1;
    protected com.kascend.chushou.player.b nQh = null;
    public List<ListItem> b = new ArrayList();
    private boolean r = false;
    c.a nQk = new c.a() { // from class: com.kascend.chushou.player.e.e.2
        @Override // com.kascend.chushou.player.e.c.a
        public void a(boolean z) {
            if (e.this.r && e.this.nQb != null) {
                e.this.nQb.setNoFocus(!z);
            }
        }

        @Override // com.kascend.chushou.player.e.c.a
        public void a() {
            e.this.u = true;
            if (e.this.r && e.this.nQb != null) {
                e.this.nQb.setNoFocus(true);
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
        this.nQg = getActivity();
        this.c = getArguments().getString("cover");
        this.q = getArguments().getBoolean("initViewAsync");
        this.d = getArguments().getString("liveType");
        this.v = getArguments().getString("roomId");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f = layoutInflater.inflate(a.h.videoplayer_root_view_faceshow, viewGroup, false);
        this.nQb = (VideoVerticalViewPager) this.f.findViewById(a.f.viewpager);
        this.nQb.setOverScrollMode(2);
        return this.f;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        a();
    }

    private void a() {
        String str;
        String str2;
        this.nQh = ((VideoPlayer) this.nQg).dYM();
        b();
        if (this.nQi != null) {
            str = !h.isEmpty(this.nQi.mOriginalCover) ? this.nQi.mOriginalCover : this.nQi.mCover;
        } else {
            str = "";
        }
        this.nQc = d.c(str, true, this.d);
        this.nQd = d.c(this.c, this.q, this.d);
        if (this.nQj != null) {
            str2 = !h.isEmpty(this.nQj.mOriginalCover) ? this.nQj.mOriginalCover : this.nQj.mCover;
        } else {
            str2 = "";
        }
        this.nQe = d.c(str2, true, this.d);
        this.m = new ArrayList();
        this.m.add(this.nQc);
        this.m.add(this.nQd);
        this.m.add(this.nQe);
        this.nQb.setAdapter(new a(getChildFragmentManager()));
        this.nQb.setCurrentItem(1, false);
        this.p = 1;
        this.nQf = this.m.get(1);
        if (this.nQf != null) {
            this.nQf.a();
            this.nQf.a(this.nQk);
        }
        this.nQb.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.player.e.e.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                if (e.this.p != i && e.this.r) {
                    if (e.this.nQf != null) {
                        e.this.nQf.b();
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
                            if (e.this.nQg != null && e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                                if (e.this.nQh != null) {
                                    try {
                                        jSONObject = new JSONObject(e.this.nQh.h);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jSONObject2 = jSONObject != null ? new JSONObject() : jSONObject;
                                    jSONObject2.put("tag_from_view", "1");
                                    if (jSONObject2.has("_thumb")) {
                                        jSONObject2.remove("_thumb");
                                    }
                                    aVar = !(e.this.nQg instanceof VideoPlayer) ? ((VideoPlayer) e.this.nQg).nIx : null;
                                    if (aVar != null && aVar.nQM != null) {
                                        aVar.nQM.time = System.currentTimeMillis() - aVar.b;
                                        aVar.nQM.roomId = e.this.v;
                                        aVar.a();
                                        aVar.nQM.reset();
                                        aVar.b = System.currentTimeMillis();
                                    }
                                    if (i <= e.this.p) {
                                        com.kascend.chushou.d.e.a(e.this.nQg, e.this.nQj, jSONObject2);
                                        if (aVar != null && aVar.nQM != null) {
                                            aVar.nQM.roomId = e.this.nQj.mRoomId;
                                            aVar.nQM.enterType = 2;
                                        }
                                    } else {
                                        com.kascend.chushou.d.e.a(e.this.nQg, e.this.nQi, jSONObject2);
                                        if (aVar != null && aVar.nQM != null) {
                                            aVar.nQM.roomId = e.this.nQi.mRoomId;
                                            aVar.nQM.enterType = 3;
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
                                if (!(e.this.nQg instanceof VideoPlayer)) {
                                }
                                if (aVar != null) {
                                    aVar.nQM.time = System.currentTimeMillis() - aVar.b;
                                    aVar.nQM.roomId = e.this.v;
                                    aVar.a();
                                    aVar.nQM.reset();
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
        ((VideoPlayer) this.nQg).n();
    }

    private void b() {
        if (this.nQh != null && !h.isEmpty(this.nQh.t)) {
            this.b.clear();
            if (this.nQh != null && !h.isEmpty(this.nQh.t)) {
                this.b.addAll(this.nQh.t);
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
                    if (this.u && this.nQb != null) {
                        this.nQb.setNoFocus(true);
                    }
                    if (i - 1 < 0) {
                        this.nQi = this.b.get(size - 1);
                    } else {
                        this.nQi = this.b.get(i - 1);
                    }
                    a(this.nQi.mRoomId, this.nQi.mLiveType);
                    if (this.nQc != null) {
                        if (!h.isEmpty(this.nQi.mOriginalCover)) {
                            this.nQc.a(this.nQi.mOriginalCover);
                        } else {
                            this.nQc.a(this.nQi.mCover);
                        }
                    }
                    if (i + 1 >= size) {
                        this.nQj = this.b.get(0);
                    } else {
                        this.nQj = this.b.get(i + 1);
                    }
                    a(this.nQj.mRoomId, this.nQj.mLiveType);
                    if (this.nQe != null) {
                        if (!h.isEmpty(this.nQj.mOriginalCover)) {
                            this.nQe.a(this.nQj.mOriginalCover);
                        } else {
                            this.nQe.a(this.nQj.mCover);
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
        j.dYG().a(str, a(str2));
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
        if (this.nQf != null) {
            this.nQf.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.nQf != null) {
            this.nQf.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.nQf != null) {
            this.nQf.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.nQf != null) {
            this.nQf.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nQf != null) {
            this.nQf.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.nQf != null) {
            this.nQf.e(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.nQf != null) {
            this.nQf.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nQf != null) {
            this.nQf.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.nQf != null) {
            this.nQf.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.nQf != null) {
            this.nQf.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.nQf != null) {
            return this.nQf.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.nQf != null) {
            this.nQf.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.nQf != null) {
            this.nQf.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.nQf != null) {
            this.nQf.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.nQf != null) {
            this.nQf.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.nQf != null) {
            this.nQf.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.nQf != null) {
            this.nQf.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.nQf != null) {
            this.nQf.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nQf != null) {
            return this.nQf.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
            return true;
        } else if (this.nQf != null) {
            return this.nQf.a(i, keyEvent);
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
        if (this.nQf != null) {
            this.nQf.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.nQf != null) {
            this.nQf.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.nQf != null) {
            this.nQf.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.nQf != null) {
            this.nQf.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.nQf != null) {
            this.nQf.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.nQf != null) {
            this.nQf.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.nQf != null) {
            this.nQf.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.nQf != null) {
            this.nQf.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.nQf != null) {
            this.nQf.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.nQf != null) {
            this.nQf.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.nQf != null) {
            this.nQf.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.nQf != null) {
            this.nQf.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.nQf != null) {
            this.nQf.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.nQf != null) {
            this.nQf.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.nQf != null) {
            this.nQf.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.nQf != null) {
            this.nQf.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nQf != null) {
            this.nQf.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nQf != null) {
            this.nQf.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nQf != null) {
            this.nQf.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nQf != null) {
            this.nQf.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nQf != null) {
            this.nQf.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nQf != null) {
            this.nQf.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nQf != null) {
            this.nQf.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQf != null) {
            this.nQf.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nQf != null) {
            this.nQf.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nQf != null) {
            this.nQf.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.nQf != null) {
            this.nQf.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.nQf != null) {
            this.nQf.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        if (this.nQf != null) {
            this.nQf.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        if (this.nQf != null) {
            this.nQf.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nQf != null) {
            this.nQf.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.nQf != null) {
            this.nQf.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.nQf != null) {
            this.nQf.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nQf != null) {
            this.nQf.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.nQf != null) {
            this.nQf.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.nQf != null) {
            this.nQf.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.nQf != null) {
            this.nQf.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.nQf != null) {
            this.nQf.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j(boolean z) {
        if (this.nQb != null) {
            this.nQb.setNoFocus(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nQf != null) {
            this.nQf.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nQf != null) {
            this.nQf.P();
        }
    }
}
