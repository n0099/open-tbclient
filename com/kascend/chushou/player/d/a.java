package com.kascend.chushou.player.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.swan.games.utils.so.SoUtils;
import com.facebook.drawee.drawable.p;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.b.a.a.q;
import com.kascend.chushou.bean.UserCard;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ColorPrivileges;
import com.kascend.chushou.constants.ConfigDetail;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.GiftInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicMemberInfo;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.OnlineVip;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.PrivilegeInfo;
import com.kascend.chushou.constants.RoomChatBackground;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.RoomTab;
import com.kascend.chushou.constants.RoomToast;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.a.f;
import com.kascend.chushou.player.d;
import com.kascend.chushou.player.e.b;
import com.kascend.chushou.player.ui.InteractionView;
import com.kascend.chushou.player.ui.PlayerErrorView;
import com.kascend.chushou.player.ui.ViewMicPerson;
import com.kascend.chushou.player.ui.h5.H5Container;
import com.kascend.chushou.player.ui.pk.LivePKBarUserValue;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.widget.GiftAnimationLayout;
import com.kascend.chushou.widget.RecommendView;
import com.kascend.chushou.widget.RoundProgressBar;
import com.kascend.chushou.widget.VoiceInteractionView;
import com.kascend.chushou.widget.guide.PaoGuideView;
import com.kascend.chushou.widget.menu.KasBaseMenuView;
import com.kascend.chushou.widget.menu.PopH5Menu;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.edittext.PastedEditText;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.kpswitch.b.a;
import tv.chushou.zues.widget.kpswitch.b.c;
import tv.chushou.zues.widget.kpswitch.b.d;
import tv.chushou.zues.widget.kpswitch.widget.KPSwitchPanelLinearLayout;
import tv.chushou.zues.widget.psts.PagerSlidingTabStrip;
import tv.chushou.zues.widget.textview.MarqueeTextView;
import tv.chushou.zues.widget.viewpager.KasViewPager;
/* loaded from: classes6.dex */
public class a extends d implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnTouchListener {
    private int[] plV;
    private Fragment[] plW;
    private TextView pmA;
    private TextView pmB;
    private TextView pmC;
    private TextView pmD;
    private TextView pmE;
    private TextView pmF;
    private ImageView pmG;
    private TextView pmH;
    private KPSwitchPanelLinearLayout pmK;
    private ImageView pmL;
    private c pmM;
    private d.a pmN;
    private FrescoThumbnailView pmO;
    private PagerSlidingTabStrip pmP;
    private KasViewPager pmQ;
    private LinearLayout pmR;
    private f pmT;
    private ViewMicPerson pmU;
    public ArrayList<RoomTab> pmW;
    private PopH5Menu pmY;
    private InteractionView pmZ;
    private ImageView pma;
    private MarqueeTextView pmb;
    private MarqueeTextView pmc;
    private ImageView pmd;
    private ImageView pme;
    private ImageButton pmf;
    public String pmg;
    private RecommendView pmh;
    private TextView pmk;
    private RelativeLayout pml;
    private TextView pmm;
    private TextView pmn;
    private boolean pmo;
    private RelativeLayout pmp;
    private View pmq;
    private FrescoThumbnailView pmr;
    private AnimationSet pms;
    private ImageView pmt;
    private TextView pmu;
    private RelativeLayout pmv;
    private PastedEditText pmw;
    private TextView pmx;
    private LinearLayout pmy;
    private TextView pmz;
    private int pna;
    private PopupWindow pnb;
    private TextView pnc;
    private GiftAnimationLayout pnd;
    private com.kascend.chushou.player.b.a pne;
    private Runnable pni;
    private View pnk;
    private LivePKBarUserValue pnl;
    private String pnm;
    private TextView pnn;
    private ImageView pno;
    private EditText pnp;
    private View pnq;
    private View pnr;
    private View pns;
    private String pnw;
    private long plP = 0;
    private com.kascend.chushou.view.user.a plX = null;
    private com.kascend.chushou.player.ui.a plY = null;
    private int bB = -1;
    private int bC = 0;
    private View plZ = null;
    private View pmi = null;
    private ImageButton pmj = null;
    private int pmI = 1;
    private boolean pmJ = false;
    private boolean cp = false;
    private boolean pmS = false;
    private boolean cx = false;
    private boolean pmV = false;
    private boolean pmX = false;
    private boolean cC = true;
    private int pnf = 0;
    private int png = 0;
    private int pnh = -1;
    private final Rect pnj = new Rect();
    private boolean pnt = false;
    private C0997a pnu = null;
    private boolean pnv = false;
    private boolean pnx = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pmg = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.prW = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.prW;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            c(view);
            aG();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.pmX = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.psQ != null) {
            this.psQ.b();
        }
        if (this.psl != null && (this.psl instanceof VideoPlayer)) {
            ((VideoPlayer) this.psl).AK(true);
            ((VideoPlayer) this.psl).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.pmX = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d();
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerEmbeddedScreenFragment", "release <----------");
        this.pmI = 1;
        this.pmJ = false;
        U();
        if (this.psm != null) {
            this.psm.ct(null);
            this.psm = null;
        }
        if (this.pmh != null) {
            evH().removeAllViews();
            this.pmh = null;
        }
        this.c = null;
        this.plD = null;
        tv.chushou.zues.a.a.cu(this);
        this.pmP = null;
        this.pmQ = null;
        this.plY = null;
        this.plX = null;
        if (this.plW != null) {
            for (int i = 0; i < this.plW.length; i++) {
                this.plW[i] = null;
            }
        }
        this.plW = null;
        if (this.pmw != null) {
            this.pmw.addTextChangedListener(null);
            this.pmw.setOnTouchListener(null);
            this.pmw.setOnEditorActionListener(null);
            this.pmw = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.psl, this.pmM);
        if (this.psl != null && (this.psl instanceof VideoPlayer)) {
            ((VideoPlayer) this.psl).euo();
        }
        this.pmN = null;
        this.pmM = null;
        if (this.pmU != null) {
            this.pmU.b();
            this.pmU = null;
        }
        if (this.pnb != null) {
            this.pnb.dismiss();
        }
        if (this.pne != null) {
            this.pne.a();
            this.pne = null;
            this.pnd = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.pnl = (LivePKBarUserValue) this.prW.findViewById(a.f.live_pk_bar_user);
        this.pse = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.pnt) {
            this.pnt = true;
            if (this.pnr == null) {
                this.pnr = this.prW.findViewById(a.f.vs_async_view);
                this.pnr = ((ViewStub) this.pnr).inflate();
            }
            if (this.pns == null) {
                this.pns = this.prW.findViewById(a.f.vs_async_notification_view);
                this.pns = ((ViewStub) this.pns).inflate();
            }
            this.plO = (VoiceInteractionView) this.prW.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.prW);
            edU();
            ((VideoPlayer) this.psl).q();
            this.plJ = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.pmO = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.pmP = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.pmQ = (KasViewPager) view.findViewById(a.f.vp_main);
        euV();
        aI();
        euZ();
        if (this.psk != null) {
            I();
            a(this.psk.plp, this.psk.pls);
        }
        this.bb = 0;
        this.psV = 0L;
        this.psR = (RoundProgressBar) this.prW.findViewById(a.f.roundProgressBar);
        this.psS = (TextView) this.prW.findViewById(a.f.tv_paonum);
        this.psT = (FrescoThumbnailView) this.prW.findViewById(a.f.iv_paoicon);
        this.pta = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.pmS = false;
                if (a.this.bB == 2) {
                    a.this.aI(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.pna, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.pmS = true;
                if (a.this.bB == 2) {
                    a.this.aI(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.psQ != null) {
                    a.this.psQ.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hB(a.this.psl).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.psl)) - a.this.psQ.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.psl, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.psl, 54.0f) * 2);
                    if (statusBarHeight < a.this.pna) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.psU = (PaoGuideView) this.prW.findViewById(a.f.rlPaoGuideView);
        this.pmU = (ViewMicPerson) this.prW.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.poC = ((VideoPlayer) this.psl).euh();
        this.psk = ((VideoPlayer) this.psl).euk();
        e(this.prW);
        this.pnf = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
        this.png = tv.chushou.zues.utils.systemBar.b.aH(getActivity());
        if (com.kascend.chushou.b.etQ().d == 0 && this.png > 0) {
            View findViewById = this.prW.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.png);
        }
        eve();
        evc();
        if (!this.cC) {
            Q();
        }
        eva();
        a();
        if (this.c == null) {
            this.plD = new d.a();
            this.c = new GestureDetector(this.psl, this.plD);
        }
        this.plF = ((VideoPlayer) this.psl).eul();
        this.plF.a(this);
        if (this.pne != null) {
            this.pne.a();
            this.pne = null;
        }
        this.pnd = (GiftAnimationLayout) this.prW.findViewById(a.f.ll_gift_animation);
        this.pnd.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.psk != null) {
            this.pne = new com.kascend.chushou.player.b.a(this.psl.getApplicationContext(), this.pnd);
            this.pne.a(this.psk);
        }
        if (this.f4123a == null) {
            this.f4123a = (ImageButton) this.prW.findViewById(a.f.resumebutton);
            this.f4123a.setOnTouchListener(this);
        }
        this.psf = (PlayerErrorView) this.prW.findViewById(a.f.view_net_error_msg);
        this.psf.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        evh();
        if (this.psk.euK() != null) {
            a(this.psk.euK());
        }
        FullRoomInfo euJ = this.psk.euJ();
        if (euJ != null) {
            evl();
            if (i()) {
                this.ak = false;
                AN(true);
                this.psm.Sv(8);
            }
            this.pmk.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(euJ.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.prX != null) {
            this.prX.setVisibility(0);
        }
        this.plZ.setVisibility(0);
        this.ak = false;
        AN(true);
        this.psm.Sv(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.psl).n();
        if (this.psk != null && !h.isEmpty(this.psk.w)) {
            b(this.psk.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a euv;
        euV();
        k();
        FullRoomInfo euJ = this.psk.euJ();
        if (euJ != null) {
            if (euJ.mRoominfo != null) {
                this.pmk.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(euJ.mRoominfo.mOnlineCount)));
                this.pnm = euJ.mRoominfo.mRoomID;
            }
            evl();
            if (!h.isEmpty(euJ.mRoomToastList)) {
                Iterator<RoomToast> it = euJ.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.etY().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.psk != null && this.psk.l()) {
                d(true);
            }
            if (this.psl != null && (this.psl instanceof VideoPlayer) && (euv = ((VideoPlayer) this.psl).euv()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(euv.poD, euv.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.pmR);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void euV() {
        boolean z = true;
        if (this.psk == null || this.psk.euJ() == null || this.psk.euJ().mRoominfo == null || h.isEmpty(this.psk.euJ().mRoomTabs)) {
            this.pmV = false;
            this.plW = new Fragment[2];
            this.plV = new int[2];
            this.plV[0] = 2;
            this.plV[1] = 1;
            return;
        }
        this.pmV = true;
        this.pmW = new ArrayList<>();
        Iterator<RoomTab> it = this.psk.euJ().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.pmW.add(next);
            }
        }
        if (this.pmW.size() >= 2 && this.plV != null && this.plV.length >= 2 && this.pmW.get(0).type == this.plV[0] && this.pmW.get(1).type == this.plV[1]) {
            z = false;
        }
        this.plW = new Fragment[this.pmW.size()];
        this.plV = new int[this.pmW.size()];
        for (int i = 0; i < this.pmW.size(); i++) {
            this.plV[i] = this.pmW.get(i).type;
        }
        if (z) {
            this.pnu = new C0997a(getChildFragmentManager());
            this.pmQ.setAdapter(this.pnu);
        }
    }

    private void aI() {
        this.pmv = (RelativeLayout) this.prW.findViewById(a.f.rl_edit_bar);
        this.pmr = (FrescoThumbnailView) this.prW.findViewById(a.f.btn_hotword);
        this.pmr.Ev(a.e.ic_hotwords_black_n);
        this.pmr.setOnClickListener(this);
        this.pmt = (ImageView) this.prW.findViewById(a.f.iv_task_badge);
        this.pms = (AnimationSet) AnimationUtils.loadAnimation(this.psl, a.C0991a.anim_hotword);
        this.pms.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.etY().c) {
                    a.this.pmr.clearAnimation();
                    a.this.pmr.startAnimation(a.this.pms);
                }
            }
        });
        if (com.kascend.chushou.d.h.etY().c) {
            this.pmr.startAnimation(this.pms);
            this.pmt.setVisibility(0);
        }
        this.pmu = (TextView) this.prW.findViewById(a.f.tv_bottom_input);
        this.pmu.setOnClickListener(this);
        this.ptl = (FrescoThumbnailView) this.prW.findViewById(a.f.ll_btn_set);
        this.ptl.setOnClickListener(this);
        this.pmR = (LinearLayout) this.prW.findViewById(a.f.ll_bottom_all_button);
        this.pmp = (RelativeLayout) this.prW.findViewById(a.f.rl_bottom_input);
        this.pmq = this.prW.findViewById(a.f.ll_bottom_input);
        this.pmp.setVisibility(8);
        this.pmw = (PastedEditText) this.prW.findViewById(a.f.et_bottom_input);
        this.pmw.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.pmx.setEnabled(editable.length() > 0);
            }
        });
        this.pmw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.pmx);
                    return true;
                }
                return true;
            }
        });
        this.pmw.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.pmw);
                }
                return false;
            }
        });
        this.pmL = (ImageView) this.prW.findViewById(a.f.iv_btn_emoji);
        this.pmL.setVisibility(8);
        this.pmx = (TextView) this.prW.findViewById(a.f.tv_btn_send);
        this.pmx.setOnClickListener(this);
        this.pmK = (KPSwitchPanelLinearLayout) this.prW.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.etQ().d == 0) {
            this.pmK.setUseStatusBar(true);
        }
        this.pmy = (LinearLayout) this.prW.findViewById(a.f.head_trumpet);
        this.pmy.setVisibility(8);
        this.pmy.setOnClickListener(this);
        this.pmz = (TextView) this.prW.findViewById(a.f.tv_primary_name);
        this.pmA = (TextView) this.prW.findViewById(a.f.tv_primary_desc);
        this.pmD = (TextView) this.prW.findViewById(a.f.tv_cut_count);
        this.pmD.setOnClickListener(this);
        this.pmF = (TextView) this.prW.findViewById(a.f.tv_head_count);
        this.pmF.setText(this.pmI + "");
        this.pmE = (TextView) this.prW.findViewById(a.f.tv_plus_count);
        this.pmE.setOnClickListener(this);
        this.pmC = (TextView) this.prW.findViewById(a.f.tv_buy_count_coin);
        this.pmB = (TextView) this.prW.findViewById(a.f.tv_buy_head);
        this.pmB.setOnClickListener(this);
        this.pmG = (ImageView) this.prW.findViewById(a.f.iv_trumpet_select);
        this.pmG.setOnClickListener(this);
        this.pmH = (TextView) this.prW.findViewById(a.f.tv_trumpet_have_count);
        this.pmJ = false;
        this.pmG.setBackgroundResource(a.e.ic_trumpet_n);
        this.pmH.setVisibility(8);
        euX();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.pmK, this.pmL, this.pmw, new a.InterfaceC1128a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1128a
            public void AL(boolean z) {
                if (a.this.pmL != null) {
                    if (!z) {
                        a.this.pmL.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.etQ().d == 0) {
                        a.this.pmK.setDirectVisibility(0);
                    }
                    a.this.pmL.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.pmN = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void kh(boolean z) {
                if (a.this.pnx) {
                    a.this.pnx = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.pmL.setImageResource(a.e.cs_emoji_normal);
                    a.this.euW();
                    return;
                }
                if (a.this.pnq != null && a.this.pnq.getVisibility() == 0) {
                    a.this.pnq.setVisibility(8);
                }
                if (a.this.pmS) {
                    a.this.psQ.setVisibility(0);
                }
                if (a.this.psl != null && (a.this.psl instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.psl).AK(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.pmM = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.pmK, this.pmN, ((VideoPlayer) this.psl).eup());
        ((VideoPlayer) this.psl).h(((VideoPlayer) this.psl).eup());
        this.pnq = this.prW.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.pnn = (TextView) this.prW.findViewById(a.f.btn_room_search);
        this.pno = (ImageView) this.prW.findViewById(a.f.iv_room_emoji_delete);
        this.pnp = (EditText) this.prW.findViewById(a.f.et_room_emoji_search);
        this.pnp.setImeOptions(3);
        this.pnp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.pnn);
                    return true;
                }
                return false;
            }
        });
        this.pnp.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.pnn.setEnabled(editable.length() > 0);
                a.this.pno.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.psQ.setEmojiSearchText(editable.toString());
            }
        });
        this.pnn.setOnClickListener(this);
        this.pno.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aG(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bG(this.pnp);
            this.pnq.setVisibility(0);
            this.pnp.requestFocus();
        } else {
            this.pnq.setVisibility(8);
        }
        if (z2) {
            this.pnp.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euW() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hB(this.psl).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl)) - tv.chushou.zues.widget.kpswitch.b.d.ek(this.psl)) - tv.chushou.zues.utils.a.dip2px(this.psl, 14.0f)) - this.psl.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.psl, 54.0f) * 2);
        if (statusBarHeight < this.pna) {
            b(statusBarHeight, 10);
        }
    }

    private void euX() {
    }

    private void aL() {
        this.psm = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aH(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.prW.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.psl.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.psm.D(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.psm.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.psm.D(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.psm);
                            break;
                        case 12:
                            a.this.b(a.this.psm);
                            break;
                        case 17:
                            a.this.evJ();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.psj.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void euY() {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.pmW)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.pmW.size()) {
                    if (!h.isEmpty(this.pmW.get(i2).notifyIcon)) {
                        this.pmP.cc(i2, this.pmW.get(i2).notifyIcon);
                        this.pmP.SP(i2);
                    } else if (this.pmW.get(i2).notify == 1) {
                        this.pmP.SO(i2);
                        this.pmP.SN(i2);
                    } else {
                        this.pmP.SN(i2);
                        this.pmP.SP(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.pmW)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.pmW.size()) {
                    if (this.pmW.get(i4).type == i) {
                        return i4;
                    }
                    i3 = i4 + 1;
                } else {
                    return i2;
                }
            }
        } else {
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Rd(int i) {
        if (this.psk == null || this.psk.euJ() == null || this.psk.euJ().mRoominfo == null || h.isEmpty(this.pmW)) {
            if (i == 1) {
                return this.psl.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.psl.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.pmW.size()) {
            return this.pmW.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.pmW) && i < this.pmW.size()) {
            this.pmW.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.pmW) && i < this.pmW.size()) {
            this.pmW.get(i).notifyIcon = str;
        }
    }

    private void euZ() {
        if (this.pmQ != null && this.pmP != null && this.plV != null) {
            this.plY = null;
            if (this.plW != null) {
                for (int i = 0; i < this.plW.length; i++) {
                    this.plW[i] = null;
                }
            }
            if (this.pnu == null) {
                this.pnu = new C0997a(getChildFragmentManager());
                this.pmQ.setAdapter(this.pnu);
            } else {
                this.pnu.notifyDataSetChanged();
            }
            this.pmQ.setOffscreenPageLimit(this.plV.length);
            this.pmP.c(this.pmQ);
            this.pmP.setOnPageChangeListener(this);
            this.pmP.notifyDataSetChanged();
            this.pmP.setVisibility(0);
            this.pmQ.setVisibility(0);
            if (!this.pmV) {
                this.bB = 2;
                this.pmQ.setCurrentItem(c(2, 0));
                this.pmp.setVisibility(0);
            } else {
                if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                    if (!h.isEmpty(this.psk.euJ().mRoominfo.mGameName)) {
                        this.pmc.setText(this.psk.euJ().mRoominfo.mGameName);
                    } else {
                        this.pmc.setText(this.psl.getString(a.i.no_online_game_name));
                    }
                    this.pmb.setText(this.psk.euJ().mRoominfo.mName);
                } else {
                    this.pmc.setText(this.psl.getString(a.i.no_online_game_name));
                }
                euY();
                if (i()) {
                    evi();
                    if (this.pmQ != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.pmQ.setCurrentItem(c);
                        this.pmP.setSelectItem(c);
                    }
                } else if (this.pmQ != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.pmQ.setCurrentItem(c2);
                    this.pmP.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void eva() {
        this.prX = new SurfaceView(this.psl);
        SurfaceView surfaceView = (SurfaceView) this.prX;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        evH().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void evb() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.psl).s();
        edZ();
        evf();
        euU();
        evH().setBackgroundResource(a.e.room_not_online);
        if (this.pmh == null) {
            this.pmh = new RecommendView(this.psl);
            evH().addView(this.pmh);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.psl);
            this.pmh.setLayoutParams(layoutParams);
        }
        if (this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.psk.euJ().mRoominfo.mRoomID)) {
            this.pmh.a(this.psk.euJ().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.psl != null && a.this.evH() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.psl);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.oRo);
                        if (a.this.evH().getChildCount() >= 2) {
                            a.this.evH().addView(frescoThumbnailView, 0);
                        }
                        a.this.evH().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.eHF(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.prX != null) {
            this.prX.setVisibility(8);
        }
        if (this.psY != null) {
            this.psY.eHb();
            this.psY.setVisibility(8);
        }
        m(false, false, true);
        if (this.f4123a != null) {
            this.f4123a.setVisibility(8);
        }
        if (this.psQ != null) {
            this.psQ.e();
        }
        AN(false);
        a(false, false);
        if (this.plF != null) {
            this.plF.d();
        }
    }

    private void evc() {
        int i = 0;
        this.plZ = this.prW.findViewById(a.f.topview);
        if (com.kascend.chushou.b.etQ().d == 0 && this.pnf > 0) {
            View findViewById = this.prW.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.pnf;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.pma = (ImageView) this.plZ.findViewById(a.f.back_icon);
        this.pma.setOnClickListener(this);
        this.pmb = (MarqueeTextView) this.plZ.findViewById(a.f.tv_title);
        this.pmc = (MarqueeTextView) this.plZ.findViewById(a.f.tv_Type);
        this.pme = (ImageView) this.prW.findViewById(a.f.btn_setting);
        this.pmi = this.prW.findViewById(a.f.bottomview);
        if (this.psc == null) {
            this.psc = (ImageButton) this.pmi.findViewById(a.f.btn_barrage);
            this.psc.setOnClickListener(this);
            if (this.psk != null) {
                if (com.kascend.chushou.d.h.etY().n()) {
                    this.psc.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.psc.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.psd = (ImageButton) this.pmi.findViewById(a.f.btn_audio);
        this.psd.setOnClickListener(this);
        if (this.psk != null && this.psk.d) {
            this.psd.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.psd.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.psk != null && this.psk.f != null) {
            while (true) {
                if (i >= this.psk.f.size()) {
                    break;
                } else if (!"2".equals(this.psk.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.pmj = (ImageButton) this.pmi.findViewById(a.f.playbutton);
        this.pmj.setOnTouchListener(this);
        this.pmf = (ImageButton) this.pmi.findViewById(a.f.btn_refresh);
        this.pmf.setOnClickListener(this);
        this.pmk = (TextView) this.pmi.findViewById(a.f.tv_online_count);
        if (this.psb == null) {
            this.psb = (ImageButton) this.pmi.findViewById(a.f.btn_screenChange);
            this.psb.setOnClickListener(this);
        }
        if (this.pmd == null) {
            this.pmd = (ImageView) this.plZ.findViewById(a.f.report_icon);
            this.pmd.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void em(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.ba();
                    }
                }
            });
        }
    }

    private boolean h(ArrayList<FanItem> arrayList, String str) {
        if (h.isEmpty(arrayList) || h.isEmpty(str)) {
            return false;
        }
        Iterator<FanItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().mUserId)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x05c7  */
    @Override // com.kascend.chushou.widget.a.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ParserRet parserRet) {
        ArrayList<ChatInfo> arrayList;
        long j;
        GiftInfo giftInfo;
        boolean z;
        if (!aa() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.plY != null) {
                        this.plY.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                        this.psk.euJ().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.psk.euJ().mMicStatus.onMic) {
                            evk();
                        }
                        if (this.psk.euJ().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.psk.euJ().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.psk.euJ().mRoominfo.mCreatorUID);
                            }
                        } else if (this.psk.euJ().mMicStatus.onMic) {
                            this.psk.euJ().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.psk.euJ().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.psk.euJ().mFanItems, str);
                            }
                            this.pnv = z2;
                            if (this.psk.euJ().mMicStatus != null && !h.isEmpty(this.psk.euJ().mMicStatus.micRoomId) && !this.psk.euJ().mMicStatus.micRoomId.equals("0")) {
                                this.pnw = this.psk.euJ().mMicStatus.micRoomId;
                            }
                            if (this.plY != null) {
                                this.plY.a(this.psk.euJ().mMicStatus, this.psk.euJ().mFanItems, str, z2);
                            }
                            if (this.pmU != null && this.pmU.getVisibility() == 0) {
                                this.pmU.a(this.psk.euJ().mFanItems, this.psk.euJ().mMicStatus, str, z2, this.psk.euJ().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.plY != null) {
                                this.plY.e();
                            }
                            if (this.pmU != null && this.pmU.isShown()) {
                                this.pmU.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.plY != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.plY.a(roomChatBackground.mChatBackground);
                        } else {
                            this.plY.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.pnh != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.pnh = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.plJ != null && this.plJ.poD != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.plJ.poD.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.plJ.poD.mInPKMode = true;
                                    this.plJ.poD.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.plJ.poD.mPkUid = pkNotifyInfo.mPkUid;
                                    this.plJ.poD.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.plJ.poD.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.plJ.poD.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.plJ.poD.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.plJ.poD.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.plJ.poD.mMode = pkNotifyInfo.mMode;
                                    this.plJ.poD.liveStyle = pkNotifyInfo.liveStyle;
                                    if (evr() != null) {
                                        evr().k(true, this.plJ.poD.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.etY().f4087a) {
                                        if (!com.kascend.chushou.b.etQ().e) {
                                            com.kascend.chushou.b.etQ().e = true;
                                            g.O(this.psl, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.etY().a(this.psl, false);
                                        evj();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.pnl != null) {
                                        this.pnl.setVisibility(0);
                                    }
                                    this.plJ.poD.mAction = 7;
                                    this.plJ.poD.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.plJ.poD.mPkUid = pkNotifyInfo.mPkUid;
                                    this.plJ.poD.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.plJ.poD.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.plJ.poD.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.plJ.poD.destinyInfo = pkNotifyInfo.destinyInfo;
                                    evq();
                                    if (evr() != null) {
                                        evr().k(false, 0L);
                                        evr().b(this.plJ.poD, true);
                                        evr().a(this.plJ.poD.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Ys(this.pnm);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.plJ.poD.mInPKMode = false;
                                    this.plJ.poD.mAction = 2;
                                    evq();
                                    if (evr() != null) {
                                        evr().c();
                                    }
                                    if (com.kascend.chushou.d.h.etY().f4087a) {
                                        if (!com.kascend.chushou.b.etQ().e) {
                                            com.kascend.chushou.b.etQ().e = true;
                                            g.O(this.psl, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.etY().a(this.psl, false);
                                        evj();
                                    }
                                    this.plJ.b = null;
                                    this.plJ.poD = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Ys(this.pnm);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.plJ.poD.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.plJ.poD.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.plJ.poD.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.psk.euJ().mRoominfo.mRoomID) && this.psk.euJ().mRoominfo.mRoomID.equals(this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (evr() != null) {
                                        evr().a(this.plJ.poD, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.plJ.poD.copyUpdate(pkNotifyInfo);
                                    if (evr() != null) {
                                        evr().a(this.plJ.poD);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.plJ.poD.copyStop(pkNotifyInfo);
                                        if (evr() != null) {
                                            evr().M(this.plJ.poD.mMaxFreeDuration, this.plJ.poD.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.plJ.poD.copyResult(pkNotifyInfo);
                                    if (!this.pmX && evr() != null) {
                                        int i5 = 1;
                                        if (this.plJ.poD.destinyInfo != null && this.plJ.poD.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        evr().a(h.parseInt(this.plJ.poD.mResult), h.parseLong(this.plJ.poD.mvpUid), this.plJ.poD.mvpAvatar, this.plJ.poD.mvpNickname, this.plJ.poD.mMaxFreeDuration, this.plJ.poD.mMode, i5);
                                    }
                                }
                            }
                            i = i2 + 1;
                        }
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0 && this.plY != null) {
                if (LoginManager.Instance().islogined() && this.psk != null && this.psk.l()) {
                    Iterator<ChatInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ChatInfo next = it.next();
                        if ("1".equals(next.mType) || "3".equals(next.mType)) {
                            z = false;
                            break;
                        }
                        while (it.hasNext()) {
                        }
                    }
                    z = true;
                    d(z);
                }
                if (this.psk == null || this.psk.euJ() == null || this.psk.euJ().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.psk.euJ().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.etY().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.etY().b().equals(next2.mUserID)) {
                            it2.remove();
                        }
                        if (j > 0 && "3".equals(next2.mType) && !next2.isBatchGift && (giftInfo = next2.mGift) != null && giftInfo.id != -1 && giftInfo.point < 20000 && next2.mUserComboCount > 1 && next2.mUserComboCount % j != 0) {
                            it2.remove();
                        }
                        if ("2".equals(next2.mType) && !h.isEmpty(next2.mDisplayPosition) && !next2.mDisplayPosition.contains("2")) {
                            it2.remove();
                        }
                        if (next2.isShare()) {
                            arrayList3.add(next2);
                            it2.remove();
                        }
                    }
                }
                this.plY.a(arrayList, true, false);
                this.plY.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.plV != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.plV.length) {
                    break;
                }
                if (this.plV[i2] == 99 && this.plW != null && this.plW[i2] != null && (this.plW[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.plW[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.pmW.size() && this.pmP != null) {
                if (i == 0) {
                    this.pmP.setTagText(i2, new StringBuilder(this.pmW.get(i2).name).toString());
                    return;
                } else {
                    this.pmP.setTagText(i2, this.pmW.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
                    return;
                }
            }
            return;
        }
        i2 = -1;
        if (i2 < 0) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (this.psc != null) {
            if (z) {
                this.psc.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.psc.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout evd() {
        if (this.prW == null) {
            return null;
        }
        return (GiftAnimationLayout) this.prW.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hB = tv.chushou.zues.utils.a.hB(this.psl);
        this.ar = Math.min(hB.x, hB.y);
        this.aq = (this.ar * this.psl.getResources().getInteger(a.g.h_thumb_height_def)) / this.psl.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = evH().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.pse.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.pna = this.aq + this.psl.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.psl, 54.0f);
        b(this.pna, 10);
        if (this.prX != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.prX).setLayoutParams(layoutParams3);
        }
    }

    private void eve() {
        Point hB = tv.chushou.zues.utils.a.hB(this.psl);
        this.ar = Math.min(hB.x, hB.y);
        this.aq = (this.ar * this.psl.getResources().getInteger(a.g.h_thumb_height_def)) / this.psl.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = evH().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.pse.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.pna = this.aq + this.psl.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.psl, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.pna, 10);
        k();
        if (!h.isEmpty(this.pmg)) {
            File ai = tv.chushou.zues.widget.fresco.a.ai(Uri.parse(this.pmg));
            if (ai != null && ai.exists()) {
                this.pse.setImageURI(Uri.fromFile(ai));
                this.pse.setVisibility(0);
                return;
            }
            this.pse.setVisibility(8);
            return;
        }
        this.pse.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aH(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.pmd != null) {
            this.pmd.setVisibility(z ? 0 : 4);
        }
        if (this.pme != null) {
            this.pme.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aH(boolean z, boolean z2) {
        return m(z, z2, this.f);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.psm != null) {
            this.psm.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.psl).f(true);
            if (!z3) {
                if (this.pmi.getVisibility() != 0 && z2) {
                    this.pmi.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.psd.setVisibility(0);
                } else {
                    this.psd.setVisibility(8);
                }
                this.pmi.setVisibility(0);
            }
            PlayUrl euK = this.psk.euK();
            if (euK != null && "2".equals(euK.mType)) {
                if (this.psb != null) {
                    this.psb.setVisibility(8);
                }
            } else if (this.psb != null) {
                this.psb.setVisibility(0);
            }
            if (this.plZ.getVisibility() != 0 && z2) {
                this.plZ.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_top_anim));
            }
            t(!z3);
            this.plZ.setVisibility(0);
            w(true);
            if (this.psm != null) {
                this.psm.D(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.psl).f(false);
            if (this.psD != null) {
                this.psD.dismiss();
            }
            if (this.psE != null) {
                this.psE.dismiss();
            }
            if (this.pmi.getVisibility() != 8 && z2) {
                this.pmi.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_bottom_anim));
            }
            this.pmi.setVisibility(8);
            if (this.plZ.getVisibility() != 8 && z2) {
                this.plZ.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_top_anim));
            }
            this.plZ.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean edZ() {
        if (this.psU == null || !this.psU.isShown()) {
            return false;
        }
        this.psU.d();
        return true;
    }

    public boolean evf() {
        if (this.pmU == null || !this.pmU.isShown()) {
            return false;
        }
        this.pmU.a();
        return true;
    }

    public boolean euU() {
        if (this.pmY == null || !this.pmY.b()) {
            return false;
        }
        this.pmY.a();
        return true;
    }

    public boolean evg() {
        if (this.pmS && this.psQ != null) {
            if (this.psQ != null) {
                this.psQ.e();
            }
            if (this.pnp != null) {
                this.pnp.setText("");
            }
            if (this.bB == 2) {
                aI(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.prW != null) {
            if (this.pmY == null) {
                this.pmY = (PopH5Menu) ((ViewStub) this.prW.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.pmY.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
                    @Override // com.kascend.chushou.widget.menu.a
                    public void a() {
                        a.this.l();
                    }

                    @Override // com.kascend.chushou.widget.menu.a
                    public void b() {
                        a.this.k();
                    }
                });
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.f4233a = listItem.mUrl;
            h5Options.h = -1;
            this.pmY.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            p(view, 0, this.plZ.getHeight() + this.plZ.getTop());
        } else if (id == a.f.btn_barrage) {
            q(view, 0, -tv.chushou.zues.utils.a.dip2px(this.psl, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                g.d(this.psl, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.psk.a(false);
                a(false, false);
                ((VideoPlayer) this.psl).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.psl).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.psl, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.plJ == null || this.plJ.poD == null || !this.plJ.poD.mInPKMode) {
                ((VideoPlayer) this.psl).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.psl, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.pmJ) {
                f(this.pmw.getText().toString());
            } else {
                a(this.pmw.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.etY().c) {
                com.kascend.chushou.d.h.etY().b(false);
                this.pms.cancel();
                this.pms.reset();
                this.pmr.clearAnimation();
                this.pmt.setVisibility(8);
            }
            o(view, 0, this.prW.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.psl, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            n(view, x, this.prW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.psk.d) {
                edN();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.psl, null) && this.psk != null && this.psk.plr != null) {
                if (this.pmJ) {
                    evu();
                    return;
                }
                if (this.psk != null && this.psk.plr != null && this.psk.plr.count > 0) {
                    this.pmy.setVisibility(8);
                } else {
                    this.pmy.setVisibility(0);
                }
                this.pmJ = true;
                this.pmG.setBackgroundResource(a.e.ic_trumpet_p);
                this.pmH.setVisibility(0);
                this.pmH.setSelected(true);
                this.pmH.setTextColor(Color.parseColor("#ff5959"));
                if (this.pmw != null) {
                    this.pmw.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.pmI <= 9) {
                this.pmI++;
                this.pmF.setText(this.pmI + "");
            }
            evs();
        } else if (id == a.f.tv_cut_count) {
            if (this.pmI > 1) {
                this.pmI--;
                this.pmF.setText(this.pmI + "");
            }
            evs();
        } else if (id == a.f.tv_buy_head) {
            evt();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.pnp.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.pnp.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.ew(this.pnp);
                this.psQ.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.pmw != null && this.pmp != null && this.pmv != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bG(this.pmw);
                this.pmp.setVisibility(8);
                if (this.bB == 2) {
                    this.pmv.setVisibility(0);
                }
            }
        } else if (this.pmp != null && this.pmv != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
            if (this.bB == 2) {
                this.pmp.setVisibility(0);
            }
            this.pmv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.etY().c(roomToast.mToastContent);
            if (this.pnb == null) {
                aS();
            }
            if (this.pnc != null) {
                this.pnc.setText(roomToast.mToastContent);
            }
            if (!this.pnb.isShowing()) {
                if (this.pmR != null) {
                    this.pnb.showAtLocation(this.pmR, 85, 0, this.prW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
                    RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.pnb != null) {
                                a.this.pnb.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.pnb.dismiss();
        }
    }

    private void aS() {
        if (this.pnb == null) {
            View inflate = LayoutInflater.from(this.psl).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.pnc = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.pnb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 160.0f), -2);
            this.pnb.setFocusable(false);
            this.pnb.setOutsideTouchable(false);
            this.pnb.setAnimationStyle(a.j.gift_toast_style);
            this.pnb.update();
        }
    }

    private void n(View view, int i, int i2) {
        if (this.psL != null && this.psL.isShowing()) {
            this.psL.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
        if (this.pti == null) {
            evK();
        }
        if (!this.pti.isShowing()) {
            this.pti.showAtLocation(view, 83, i, i2);
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.psk.euJ().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.pti.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.ptl != null) {
            if (h.isEmpty(this.ptm)) {
                if (((VideoPlayer) this.psl).q) {
                    this.ptl.cd(this.psk != null ? this.psk.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.ptl.cd(this.psk != null ? this.psk.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.psl).q && this.ptm.size() == 2 && this.ptm.contains("4") && this.ptm.contains("2")) {
                this.ptl.cd(this.psk != null ? this.psk.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.ptm.size() > 1 || !((VideoPlayer) this.psl).q) {
                this.ptl.cd(this.psk != null ? this.psk.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.ptm.get(0))) {
                this.ptl.cd(this.psk != null ? this.psk.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.ptm.get(0))) {
                this.ptl.cd(this.psk != null ? this.psk.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.ptm.get(0))) {
                this.ptl.cd(this.psk != null ? this.psk.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void o(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
        if (this.psL == null) {
            al();
            this.psL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.psL.isShowing() && this.bB == 2) {
            this.psL.showAtLocation(view, 83, i, this.psl.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.psk.euJ().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.psL.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.pse != null) {
            this.pse.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                g.d(this.psl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.poC.getPlayState() == 4) {
                        e(true);
                        if (this.psk.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.psk.a(false);
                        ((VideoPlayer) this.psl).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.poC.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.poC.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                g.d(this.psl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.psk.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.psl).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                    this.ai = false;
                    AN(true);
                    a(false, !this.ak);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.psY != null) {
            if (z) {
                this.psY.setVisibility(0);
            }
            this.psY.eHb();
            if (!z) {
                this.psY.setVisibility(8);
            }
        }
        g.d(this.psl, this.psl.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.pmj != null) {
                this.pmj.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4123a != null) {
                this.f4123a.setVisibility(8);
            }
            if (this.psf != null) {
                this.psf.setVisibility(8);
                return;
            }
            return;
        }
        if (this.pmj != null) {
            this.pmj.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4123a != null) {
            if (z2 != (this.f4123a.getVisibility() == 0)) {
                if (z2) {
                    this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4123a.setVisibility(0);
                    return;
                }
                this.f4123a.setVisibility(8);
                if (this.psf != null) {
                    this.psf.setVisibility(8);
                }
            }
        }
    }

    private void evh() {
        this.e = false;
        m(true, false, true);
    }

    private void evi() {
        this.e = false;
        m(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.plV[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            euY();
            a(this.psk != null ? this.psk.pls.get("1") : null);
            if (i2 == 2) {
                k();
                aI(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.psl, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aI(false, i3);
            v(false);
            b(false);
            if (this.psL != null && this.psL.isShowing()) {
                this.psL.dismiss();
            }
            if (i2 == 99) {
                if (this.plW != null && this.plW[i] != null && (this.plW[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.plW[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.psl, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.psl, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.psl, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.psl, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.bC = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.bB == 2) {
            super.k();
        } else {
            super.l();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.kascend.chushou.player.g
    protected void evj() {
        ((VideoPlayer) this.psl).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.psm != null) {
            if (this.pmv != null && this.pmv.getVisibility() == 0) {
                u(false);
            }
            if (this.psf != null && this.psf.getVisibility() == 0) {
                this.f = true;
            }
            aH(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.plY != null) {
            this.plY.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.plY != null) {
            this.plY.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.plY != null) {
            this.plY.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.plY != null) {
            this.plY.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.pmR != null) {
            int size = iconConfig.configs.size();
            this.pmR.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.psl).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.pmR, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.cd(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.cd(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.cd(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.cd(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.cd(str, a.e.ic_default_video_bottom);
                }
                TextView textView = (TextView) inflate.findViewById(a.f.tv_bottom);
                String str2 = skinRes != null ? skinRes.text : "";
                if (h.isEmpty(str2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(str2);
                    textView.setTextColor(com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black));
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.3
                    @Override // tv.chushou.zues.a
                    public void em(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.pmR.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.psk != null ? this.psk.pls : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.plY != null) {
            this.plY.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pmO != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.pmO.Ev(a.c.kas_white);
            } else if (this.bB == 2) {
                this.pmO.cd(str, a.c.kas_white);
                if (this.pmP != null) {
                    this.pmP.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.pmO.Ev(a.c.kas_white);
                if (this.pmP != null) {
                    this.pmP.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a2 = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a3 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.pmP != null) {
                    this.pmP.setTextColor(a2);
                    this.pmP.setTabTextSelectColor(a3);
                    this.pmP.setIndicatorColor(a3);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pmr != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.pmr.Ev(a.e.ic_hotwords_black_n);
            } else {
                this.pmr.cd(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pmq != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.evX().a(str, this.pmq, a.e.player_skin_input);
            } else {
                this.pmq.setBackgroundResource(a.e.player_skin_input);
            }
            int a2 = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.pmu != null) {
                this.pmu.setTextColor(a2);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void a(int i) {
        if (this.plY != null) {
            this.plY.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void D() {
        if (this.psl instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a euq = ((VideoPlayer) this.psl).euq();
            if (this.ptc == null) {
                this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.ptc.setVisibility(0);
            this.ptc.a(2, euq);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.plY != null) {
            this.plY.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.plY != null) {
            this.plY.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(long j) {
        if (this.plY != null) {
            this.plY.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1004a
    public void c(int i) {
        if (this.plY != null) {
            this.plY.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.plY != null && this.psk != null) {
            this.plY.b(this.psk.plq);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void c(String str) {
        super.c(str);
        g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0997a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0997a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.plV.length) {
                return null;
            }
            switch (a.this.plV[i]) {
                case 1:
                    if (a.this.plX == null) {
                        a.this.plX = com.kascend.chushou.view.user.a.a(2, null, a.this.psk.f4119a, false, a.this.psk.h, false);
                    }
                    a.this.plW[i] = a.this.plX;
                    return a.this.plX;
                case 2:
                    if (a.this.plY == null) {
                        a aVar = a.this;
                        if (a.this.plJ != null && a.this.plJ.poD != null) {
                            z = a.this.plJ.poD.mInPKMode;
                        }
                        aVar.plY = com.kascend.chushou.player.ui.a.AO(z);
                    }
                    a.this.plW[i] = a.this.plY;
                    return a.this.plY;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.psk != null && a.this.psk.euJ() != null && !h.isEmpty(a.this.pmW)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.pmW.get(i).url);
                        h5Options.f4233a = a.this.pmW.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a2 = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.plW[i] = a2;
                    return a2;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Rd(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.plV.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int qd(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Re(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String Rf(int i) {
            return a.this.Rd(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Rg(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Rh(int i) {
            int dimensionPixelSize = a.this.psl.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void In(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.SE(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.plP <= IMConnection.RETRY_DELAY_TIMES) {
            g.SE(a.i.str_too_fast);
            return false;
        } else {
            evm();
            if (!com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a(((VideoPlayer) this.psl).euk().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.plP = System.currentTimeMillis();
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                a(this.psk.euJ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.psk.h);
            }
            g(this.b);
            if (!z && this.pmw != null) {
                this.pmw.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            evm();
            if (com.kascend.chushou.d.e.c(this.psl, null) && LoginManager.Instance().getUserInfo() != null && this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                a(this.psk.euJ().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.pmw != null) {
                this.pmw.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.plY != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.psk.euJ().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.psk.euJ().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.psl).pjF;
            if (privilegeInfo != null) {
                chatInfo.mPrivilegeInfo = privilegeInfo;
                chatInfo.mNicknameRichText = privilegeInfo.mRichNickname;
                if (!h.isEmpty(chatInfo.mNicknameRichText)) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<RichText> it = chatInfo.mNicknameRichText.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().mContent);
                    }
                    String sb2 = sb.toString();
                    if (!h.isEmpty(sb2)) {
                        chatInfo.mUserNickname = sb2;
                        str2 = sb2;
                        if (privilegeInfo != null) {
                            ColorPrivileges colorPrivileges = privilegeInfo.mColorPrivileges;
                            if (colorPrivileges != null && !h.isEmpty(colorPrivileges.mColors)) {
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.aal(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                            }
                            chatInfo.mCoolNickname = privilegeInfo.mCoolNickname;
                            if (chatInfo.mCoolNickname != null) {
                                chatInfo.mCoolNickname.mNickName = str2;
                                for (int i = 0; i < chatInfo.mCoolNickname.mNicknameRichText.size(); i++) {
                                    chatInfo.mCoolNickname.mNicknameRichText.get(i).mContent = str2;
                                }
                            }
                            chatInfo.mCoolContent = privilegeInfo.mCoolContent;
                            if (chatInfo.mCoolContent != null) {
                                chatInfo.mCoolContent.mContent = str;
                                if (chatInfo.mCoolContent.mContentRichText.size() == 1) {
                                    for (int i2 = 0; i2 < chatInfo.mCoolContent.mContentRichText.size(); i2++) {
                                        chatInfo.mCoolContent.mContentRichText.get(i2).mContent = str;
                                    }
                                }
                            }
                            chatInfo.mCoolMessage = privilegeInfo.mCoolMessage;
                            if (chatInfo.mCoolMessage != null) {
                                if (chatInfo.mCoolMessage.mContentRichText.size() == 1) {
                                    for (int i3 = 0; i3 < chatInfo.mCoolMessage.mContentRichText.size(); i3++) {
                                        chatInfo.mCoolMessage.mContentRichText.get(i3).mContent = str;
                                    }
                                }
                                for (int i4 = 0; i4 < chatInfo.mCoolMessage.mNicknameRichText.size(); i4++) {
                                    chatInfo.mCoolMessage.mNicknameRichText.get(i4).mContent = str2;
                                }
                            }
                        }
                        arrayList.add(chatInfo);
                        this.plY.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.plY.a(arrayList, true, true);
        }
    }

    private void evk() {
        if (this.plY != null) {
            this.plY.e();
        }
        if (this.pmU != null && this.pmU.isShown()) {
            this.pmU.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.psl instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.psl;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.psk != null) {
            this.psk.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        evk();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.psl != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.psl).t)) {
                this.cx = true;
                if (this.psk != null) {
                    this.psk.f = null;
                    if (this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                        this.psk.euJ().mRoominfo.mGameId = null;
                    }
                }
                evb();
                return;
            }
            this.cx = true;
            if (this.psl != null) {
                ((VideoPlayer) this.psl).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.pmh != null) {
            this.pmh.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.pmh != null) {
            this.pmh.setVisibility(8);
        }
        super.i(z);
    }

    private void evl() {
        euZ();
        if (i()) {
            aY();
            ap();
            return;
        }
        evb();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        evH().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.prX != null) {
            this.prX.setVisibility(0);
        }
        if (this.psY != null) {
            this.psY.setVisibility(0);
        }
        if (this.plF != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.plF.d();
        }
        if (this.pmp != null) {
            this.pmp.setVisibility(0);
        }
        if (com.kascend.chushou.c.f4079a) {
            this.pme.setVisibility(0);
            this.pme.setOnClickListener(this);
        } else {
            this.pme.setVisibility(8);
        }
        this.pmj.setVisibility(0);
        this.pmf.setVisibility(0);
        this.psc.setVisibility(0);
        if (this.p) {
            this.psd.setVisibility(0);
        } else {
            this.psd.setVisibility(8);
        }
        aX();
        aI(true, i());
        this.e = false;
        m(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ptc != null && this.ptc.a(i, keyEvent)) {
                return true;
            }
            if (this.pmY != null && this.pmY.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.pmZ != null && this.pmZ.onKeyDown(i, keyEvent)) || evn()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.pnq != null && this.pnq.getVisibility() == 0 && a(motionEvent, this.pnq)) {
                this.pnq.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.ew(this.pnp);
                return true;
            } else if (this.pmS && this.pnq != null && this.pnq.getVisibility() == 8 && f(this.psQ.b, motionEvent)) {
                evg();
                return true;
            } else if (this.pmY != null && this.pmY.b() && f(this.pmY, motionEvent)) {
                this.pmY.a();
                return true;
            } else if (this.pmZ != null && this.pmZ.b() && f(this.pmZ, motionEvent)) {
                this.pmZ.a();
                return true;
            } else if (a(motionEvent, this.pmv)) {
                return evm();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean evm() {
        boolean z;
        b(this.pna, 10);
        boolean z2 = false;
        if (this.pmK != null && this.pmK.getVisibility() == 0) {
            this.pmK.setVisibility(8);
            this.pmL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
            this.pmL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.pmv == null || this.pmv.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.pmJ) {
                evu();
            }
            this.pmv.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.pmp != null && a.this.bB == 2) {
                        a.this.pmp.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean evn() {
        if (evm()) {
            return true;
        }
        if (this.psL == null || !this.psL.isShowing()) {
            return evg() || evf() || edZ();
        }
        this.psL.dismiss();
        return true;
    }

    public boolean a(MotionEvent motionEvent, View view) {
        if (view != null) {
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            return motionEvent.getY() <= ((float) iArr[1]);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ() {
        this.pmp.setVisibility(8);
        this.pmv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(boolean z, boolean z2) {
        if (this.pmp != null) {
            if (z) {
                if (this.pmp.getVisibility() != 0) {
                    this.pmp.setVisibility(0);
                    this.pmp.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_bottom_anim));
                }
            } else if (this.pmp.getVisibility() != 4) {
                this.pmp.setVisibility(4);
                this.pmp.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.pmh != null) {
            this.pmh.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a evo() {
        return this.pne;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.psk != null) {
                        this.psk.f = null;
                        this.psk.euJ().mRoominfo.mGameId = null;
                    }
                    evb();
                    return;
                }
                g.SE(a.i.str_getvideosource_failed);
            }
            AN(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.psk != null && this.psk.euK() != null) {
            a(this.psk.euK());
        }
        this.p = false;
        if (this.psk == null || this.psk.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.psk.f.size()) {
                if (!"2".equals(this.psk.f.get(i2).mType)) {
                    i = i2 + 1;
                } else {
                    this.p = true;
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (this.plY != null) {
            this.plY.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.pmk != null && this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                this.pmk.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.psk.euJ().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.pmX && (c = c(1, -1)) >= 0 && c < this.pmW.size() && this.pmQ != null) {
            this.pmQ.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.pmX) {
            if (bVar.f4152a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.psl, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                com.kascend.chushou.player.ui.h5.b.b eur = ((VideoPlayer) this.psl).eur();
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(2, eur);
            } else if (bVar.f4152a == 3) {
                com.kascend.chushou.player.ui.h5.d.a eus = ((VideoPlayer) this.psl).eus();
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(2, eus);
            } else if (bVar.f4152a == 9) {
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.pmK != null) {
            this.pmK.setPanelEnabled(gVar.f4071a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.pmX) {
            if (iVar.f4073a == 53) {
                if (iVar.b instanceof String) {
                    a((String) iVar.b, true);
                }
            } else if (iVar.f4073a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (!aa() && this.psk != null) {
            String str = this.psk.f4119a;
            RoomInfo euL = this.psk.euL();
            if (euL != null && mVar.a(euL.mCreatorUID, str)) {
                euL.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.pmw != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.pmw);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
            if (this.pmT == null) {
                this.pmT = new f(getActivity());
            }
            this.pmT.a(this.psk.euJ().mRoominfo);
            if (!this.pmT.isShowing()) {
                this.pmT.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.plY != null) {
            this.plY.d();
        }
    }

    private void e(View view) {
        this.pml = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.pmm = (TextView) view.findViewById(a.f.tv_4g_video);
        this.pmm.setText(new tv.chushou.zues.widget.a.c().R(this.psl, a.e.videoplayer_4g_video).append("  ").append(this.psl.getString(a.i.videoplayer_4g_video)));
        this.pmn = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.pmn.setText(new tv.chushou.zues.widget.a.c().R(this.psl, a.e.videoplayer_4g_audio).append("  ").append(this.psl.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.pml.setVisibility(8);
                    ((VideoPlayer) a.this.psl).c(a.this.pmo);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.pml.setVisibility(8);
                    ((VideoPlayer) a.this.psl).d(a.this.pmo);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.etQ().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.pmm.setOnClickListener(onClickListener);
        this.pmn.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.psk != null && !h.isEmpty(this.psk.f)) {
            g(this.psk.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.pmo = z;
            this.p = false;
            if (this.psk != null && this.psk.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.psk.f.size()) {
                        break;
                    } else if (!"2".equals(this.psk.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.pml != null) {
                this.pml.setVisibility(0);
                this.pmm.setVisibility(0);
                this.pmn.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.pml != null) {
            this.pml.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.pni == null) {
                this.pni = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.psm != null) {
                    this.psm.f(this.pni, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.pni != null && this.psm != null) {
            this.psm.N(this.pni);
            this.pni = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.plY != null) {
            com.kascend.chushou.toolkit.a.c.a(this.psl, "显示双击666_num", null, new Object[0]);
            if (this.psk != null) {
                this.psk.b(false);
            }
            d(false);
            this.plY.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.prW != null) {
            if (this.pmZ == null) {
                this.pmZ = (InteractionView) ((ViewStub) this.prW.findViewById(a.f.view_interaction)).inflate();
                this.pmZ.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.pmZ.a();
                    }
                });
            }
            if (this.pmZ != null) {
                this.pmZ.b(configDetail);
                this.pmZ.c();
                this.pmZ.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eHN()) {
                g.O(this.psl, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.psl, null) && (this.psl instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.psk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.psl, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.psk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.psl, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.psl, configDetail.mUrl, this.psl.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.psl, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    evp();
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else {
                    return;
                }
            }
            b(com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "34"));
        }
    }

    private void evp() {
        if (this.pmS) {
            evg();
            return;
        }
        if (this.psl.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.psl, "点击送礼_num", "竖屏", new Object[0]);
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.psk.euJ().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.psl != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.plJ == null) {
                this.plJ = new com.kascend.chushou.player.e.a();
            }
            this.plJ.b = str;
            this.plJ.poD.copy(pkNotifyInfo);
            if (this.plJ.poD.mAction == 6) {
                this.plJ.poD.mInPKMode = true;
                this.u = this.plJ.poD.mPkId;
            } else if (this.plJ.poD.mAction == 7 || (this.plJ.poD.mMode == 1 && this.plJ.poD.mAction == 5)) {
                this.plJ.poD.mInPKMode = true;
                this.u = this.plJ.poD.mPkId;
                if (evr() != null) {
                    if (2 == this.bB && this.pnl != null) {
                        this.pnl.setVisibility(0);
                    }
                    evr().b(this.plJ.poD, false);
                    evr().a(this.plJ.poD.mMode, "1");
                    if (this.plJ.poD.mAction == 5 && this.plJ.poD.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.plJ.poD.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.plJ.poD.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.plJ.poD.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.plJ.poD.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.plJ.poD.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        evr().a(this.plJ.poD);
                        if (this.plJ.poD.destinyInfo == null || this.plJ.poD.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        evr().a(parseInt, this.plJ.poD.mPkUpdateInfo.remainDuration, j, this.plJ.poD.mMode, i);
                    }
                    if (!h.isEmpty(this.plJ.poD.mPkUpdateInfo.specialMomentList) && evr() != null) {
                        evr().a(this.plJ.poD, true);
                    }
                }
                evq();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Ys(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.plJ.poD.mInPKMode = false;
                evq();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Ys(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void evq() {
        if (this.plJ != null && this.plJ.poD != null) {
            if (this.plJ.poD.mInPKMode) {
                this.y.setText(this.plJ.poD.mPkUserNickname);
                this.plL.setVisibility(0);
                if (this.psb != null) {
                    this.psb.setEnabled(false);
                }
                if (this.psd != null) {
                    this.psd.setEnabled(false);
                    return;
                }
                return;
            }
            this.plL.setVisibility(8);
            if (this.psb != null) {
                this.psb.setEnabled(true);
            }
            if (this.psd != null) {
                this.psd.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b evr() {
        if (this.psl == null || this.prW == null || this.pnl == null) {
            return null;
        }
        if (this.plK == null) {
            if (this.pnk == null) {
                this.pnk = ((ViewStub) this.prW.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.plK = new com.kascend.chushou.player.e.b();
            this.plK.a(this.pnl, this.pnk, (View) null, this.psl, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cHI()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.psk != null) {
                        append.append(a.this.psk.euL().mRoomID);
                    }
                    if (a.this.plJ != null && a.this.plJ.poD != null) {
                        append.append("&mode=").append(a.this.plJ.poD.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.psl, append.toString());
                }
            });
        }
        return this.plK;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.pmH != null && this.psk != null && this.psk.plr != null) {
            this.pmH.setText(tv.chushou.zues.utils.b.SD(this.psk.plr.count));
            this.pmH.setVisibility(0);
            if (this.psk.plr.count < 1) {
                evu();
            }
            if (this.pmz != null) {
                this.pmz.setText(this.psk.plr.primaryName);
            }
            if (this.pmA != null) {
                this.pmA.setText(this.psk.plr.desc);
            }
            evs();
        }
    }

    public void evs() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.pmI * h.parseLong(this.psk.plr.point)));
        if (this.pmC != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.psl.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.R(this.psl, a.e.icon_coin_new);
            cVar.append(this.psl.getString(a.i.str_buy_count_coin2));
            this.pmC.setText(cVar);
        }
    }

    private void evt() {
        if (com.kascend.chushou.d.e.c(this.psl, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.pmI);
        }
    }

    private void v(boolean z) {
        if (this.prW != null && this.pnl != null) {
            if (z) {
                if (this.plJ != null && this.plJ.poD != null && this.plJ.poD.mInPKMode) {
                    this.pnl.setVisibility(0);
                    return;
                }
                return;
            }
            this.pnl.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.prW != null && this.plO != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.plO.setVisibility(0);
                    return;
                }
                return;
            }
            this.plO.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.plJ != null && this.plJ.poD != null && this.plJ.poD.mInPKMode && this.plL != null) {
                this.plL.setVisibility(0);
            }
        } else if (this.plL != null) {
            this.plL.setVisibility(8);
        }
    }

    private void evu() {
        this.pmJ = false;
        this.pmG.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.psk != null && this.psk.plr != null) {
            if (this.psk.plr.count < 1) {
                this.pmH.setVisibility(8);
            } else {
                this.pmH.setVisibility(0);
                this.pmH.setSelected(false);
                this.pmH.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.pmy.setVisibility(8);
        if (this.pmw != null) {
            this.pmw.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        evp();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pmu != null) {
            this.pmu.performClick();
        }
    }

    public boolean evv() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.pnx = true;
        if (this.prW != null && com.kascend.chushou.b.etQ().d == 0) {
            this.png = tv.chushou.zues.utils.systemBar.b.hF(getActivity());
            if (!z) {
                View findViewById = this.prW.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.png = tv.chushou.zues.utils.systemBar.b.hF(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.png);
            View findViewById2 = this.prW.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.png);
            findViewById2.requestLayout();
        }
    }
}
