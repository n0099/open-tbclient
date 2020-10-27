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
    private VideoVerticalViewPager pgF;
    private d pgG;
    private d pgH;
    private d pgI;
    private d pgJ;
    private Context pgK;
    private ListItem pgM;
    private ListItem pgN;
    private boolean q;
    private boolean u;
    private String v;
    private boolean o = false;
    private int p = -1;
    protected com.kascend.chushou.player.b pgL = null;
    public List<ListItem> b = new ArrayList();
    private boolean r = false;
    c.a pgO = new c.a() { // from class: com.kascend.chushou.player.e.e.2
        @Override // com.kascend.chushou.player.e.c.a
        public void a(boolean z) {
            if (e.this.r && e.this.pgF != null) {
                e.this.pgF.setNoFocus(!z);
            }
        }

        @Override // com.kascend.chushou.player.e.c.a
        public void a() {
            e.this.u = true;
            if (e.this.r && e.this.pgF != null) {
                e.this.pgF.setNoFocus(true);
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
        this.pgK = getActivity();
        this.c = getArguments().getString("cover");
        this.q = getArguments().getBoolean("initViewAsync");
        this.d = getArguments().getString("liveType");
        this.v = getArguments().getString("roomId");
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f = layoutInflater.inflate(a.h.videoplayer_root_view_faceshow, viewGroup, false);
        this.pgF = (VideoVerticalViewPager) this.f.findViewById(a.f.viewpager);
        this.pgF.setOverScrollMode(2);
        return this.f;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        a();
    }

    private void a() {
        String str;
        String str2;
        this.pgL = ((VideoPlayer) this.pgK).eqv();
        b();
        if (this.pgM != null) {
            str = !h.isEmpty(this.pgM.mOriginalCover) ? this.pgM.mOriginalCover : this.pgM.mCover;
        } else {
            str = "";
        }
        this.pgG = d.c(str, true, this.d);
        this.pgH = d.c(this.c, this.q, this.d);
        if (this.pgN != null) {
            str2 = !h.isEmpty(this.pgN.mOriginalCover) ? this.pgN.mOriginalCover : this.pgN.mCover;
        } else {
            str2 = "";
        }
        this.pgI = d.c(str2, true, this.d);
        this.m = new ArrayList();
        this.m.add(this.pgG);
        this.m.add(this.pgH);
        this.m.add(this.pgI);
        this.pgF.setAdapter(new a(getChildFragmentManager()));
        this.pgF.setCurrentItem(1, false);
        this.p = 1;
        this.pgJ = this.m.get(1);
        if (this.pgJ != null) {
            this.pgJ.a();
            this.pgJ.a(this.pgO);
        }
        this.pgF.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kascend.chushou.player.e.e.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                if (e.this.p != i && e.this.r) {
                    if (e.this.pgJ != null) {
                        e.this.pgJ.b();
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
                            if (e.this.pgK != null && e.this.getActivity() != null && !e.this.getActivity().isFinishing()) {
                                if (e.this.pgL != null) {
                                    try {
                                        jSONObject = new JSONObject(e.this.pgL.h);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jSONObject2 = jSONObject != null ? new JSONObject() : jSONObject;
                                    jSONObject2.put("tag_from_view", "1");
                                    if (jSONObject2.has("_thumb")) {
                                        jSONObject2.remove("_thumb");
                                    }
                                    aVar = !(e.this.pgK instanceof VideoPlayer) ? ((VideoPlayer) e.this.pgK).oYZ : null;
                                    if (aVar != null && aVar.php != null) {
                                        aVar.php.time = System.currentTimeMillis() - aVar.b;
                                        aVar.php.roomId = e.this.v;
                                        aVar.a();
                                        aVar.php.reset();
                                        aVar.b = System.currentTimeMillis();
                                    }
                                    if (i <= e.this.p) {
                                        com.kascend.chushou.d.e.a(e.this.pgK, e.this.pgN, jSONObject2);
                                        if (aVar != null && aVar.php != null) {
                                            aVar.php.roomId = e.this.pgN.mRoomId;
                                            aVar.php.enterType = 2;
                                        }
                                    } else {
                                        com.kascend.chushou.d.e.a(e.this.pgK, e.this.pgM, jSONObject2);
                                        if (aVar != null && aVar.php != null) {
                                            aVar.php.roomId = e.this.pgM.mRoomId;
                                            aVar.php.enterType = 3;
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
                                if (!(e.this.pgK instanceof VideoPlayer)) {
                                }
                                if (aVar != null) {
                                    aVar.php.time = System.currentTimeMillis() - aVar.b;
                                    aVar.php.roomId = e.this.v;
                                    aVar.a();
                                    aVar.php.reset();
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
        ((VideoPlayer) this.pgK).n();
    }

    private void b() {
        if (this.pgL != null && !h.isEmpty(this.pgL.t)) {
            this.b.clear();
            if (this.pgL != null && !h.isEmpty(this.pgL.t)) {
                this.b.addAll(this.pgL.t);
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
                    if (this.u && this.pgF != null) {
                        this.pgF.setNoFocus(true);
                    }
                    if (i - 1 < 0) {
                        this.pgM = this.b.get(size - 1);
                    } else {
                        this.pgM = this.b.get(i - 1);
                    }
                    a(this.pgM.mRoomId, this.pgM.mLiveType);
                    if (this.pgG != null) {
                        if (!h.isEmpty(this.pgM.mOriginalCover)) {
                            this.pgG.a(this.pgM.mOriginalCover);
                        } else {
                            this.pgG.a(this.pgM.mCover);
                        }
                    }
                    if (i + 1 >= size) {
                        this.pgN = this.b.get(0);
                    } else {
                        this.pgN = this.b.get(i + 1);
                    }
                    a(this.pgN.mRoomId, this.pgN.mLiveType);
                    if (this.pgI != null) {
                        if (!h.isEmpty(this.pgN.mOriginalCover)) {
                            this.pgI.a(this.pgN.mOriginalCover);
                        } else {
                            this.pgI.a(this.pgN.mCover);
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
        j.eqp().a(str, a(str2));
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
        if (this.pgJ != null) {
            this.pgJ.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void m() {
        if (this.pgJ != null) {
            this.pgJ.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void l() {
        if (this.pgJ != null) {
            this.pgJ.l();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
        if (this.pgJ != null) {
            this.pgJ.r();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.pgJ != null) {
            this.pgJ.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void e(boolean z) {
        if (this.pgJ != null) {
            this.pgJ.e(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(boolean z) {
        if (this.pgJ != null) {
            this.pgJ.f(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.pgJ != null) {
            this.pgJ.f();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        if (this.pgJ != null) {
            this.pgJ.c(str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
        if (this.pgJ != null) {
            this.pgJ.a(nVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if (this.pgJ != null) {
            return this.pgJ.a(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.pgJ != null) {
            this.pgJ.a(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
        if (this.pgJ != null) {
            this.pgJ.e(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
        if (this.pgJ != null) {
            this.pgJ.p();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(boolean z) {
        if (this.pgJ != null) {
            this.pgJ.g(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void h(boolean z) {
        if (this.pgJ != null) {
            this.pgJ.h(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        if (this.pgJ != null) {
            this.pgJ.e();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void x() {
        if (this.pgJ != null) {
            this.pgJ.x();
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.pgJ != null) {
            return this.pgJ.b(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.setVisibility(8);
            return true;
        } else if (this.pgJ != null) {
            return this.pgJ.a(i, keyEvent);
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
        if (this.pgJ != null) {
            this.pgJ.s();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(com.kascend.chushou.player.b bVar) {
        if (this.pgJ != null) {
            this.pgJ.a(bVar);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void y() {
        if (this.pgJ != null) {
            this.pgJ.y();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(int i) {
        if (this.pgJ != null) {
            this.pgJ.g(i);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void z() {
        if (this.pgJ != null) {
            this.pgJ.z();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void A() {
        if (this.pgJ != null) {
            this.pgJ.A();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void i(boolean z) {
        if (this.pgJ != null) {
            this.pgJ.i(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void B() {
        if (this.pgJ != null) {
            this.pgJ.B();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void C() {
        if (this.pgJ != null) {
            this.pgJ.C();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, boolean z) {
        if (this.pgJ != null) {
            this.pgJ.a(i, z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void E() {
        if (this.pgJ != null) {
            this.pgJ.E();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z, boolean z2, boolean z3) {
        if (this.pgJ != null) {
            this.pgJ.a(z, z2, z3);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void G() {
        if (this.pgJ != null) {
            this.pgJ.G();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void F() {
        if (this.pgJ != null) {
            this.pgJ.F();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void H() {
        if (this.pgJ != null) {
            this.pgJ.H();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(int i, int i2, Intent intent) {
        if (this.pgJ != null) {
            this.pgJ.a(i, i2, intent);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pgJ != null) {
            this.pgJ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pgJ != null) {
            this.pgJ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pgJ != null) {
            this.pgJ.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(long j) {
        if (this.pgJ != null) {
            this.pgJ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0982a
    public void c(int i) {
        if (this.pgJ != null) {
            this.pgJ.c(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pgJ != null) {
            this.pgJ.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void a(int i) {
        if (this.pgJ != null) {
            this.pgJ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void D() {
        if (this.pgJ != null) {
            this.pgJ.D();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.pgJ != null) {
            this.pgJ.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.pgJ != null) {
            this.pgJ.a(iconConfig, map);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        if (this.pgJ != null) {
            this.pgJ.I();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (this.pgJ != null) {
            this.pgJ.c(aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(IconConfig.Config config) {
        if (this.pgJ != null) {
            this.pgJ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        if (this.pgJ != null) {
            this.pgJ.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pgJ != null) {
            this.pgJ.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        if (this.pgJ != null) {
            this.pgJ.J();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
        if (this.pgJ != null) {
            this.pgJ.K();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pgJ != null) {
            this.pgJ.L();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void b(List<g.a> list) {
        if (this.pgJ != null) {
            this.pgJ.b(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.pgJ != null) {
            this.pgJ.a(pkNotifyInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        if (this.pgJ != null) {
            this.pgJ.M();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        if (this.pgJ != null) {
            this.pgJ.N();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void j(boolean z) {
        if (this.pgF != null) {
            this.pgF.setNoFocus(z);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pgJ != null) {
            this.pgJ.O();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pgJ != null) {
            this.pgJ.P();
        }
    }
}
