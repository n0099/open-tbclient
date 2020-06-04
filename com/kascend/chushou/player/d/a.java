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
/* loaded from: classes5.dex */
public class a extends d implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnTouchListener {
    private int cF;
    private ImageView mLA;
    private MarqueeTextView mLB;
    private MarqueeTextView mLC;
    private ImageView mLD;
    private ImageView mLE;
    private ImageButton mLF;
    public String mLG;
    private RecommendView mLH;
    private TextView mLK;
    private RelativeLayout mLL;
    private TextView mLM;
    private TextView mLN;
    private boolean mLO;
    private RelativeLayout mLP;
    private View mLQ;
    private FrescoThumbnailView mLR;
    private AnimationSet mLS;
    private ImageView mLT;
    private TextView mLU;
    private RelativeLayout mLV;
    private PastedEditText mLW;
    private TextView mLX;
    private LinearLayout mLY;
    private TextView mLZ;
    private int[] mLv;
    private Fragment[] mLw;
    private InteractionView mMA;
    private PopupWindow mMB;
    private TextView mMC;
    private GiftAnimationLayout mMD;
    private com.kascend.chushou.player.b.a mME;
    private Runnable mMH;
    private View mMJ;
    private LivePKBarUserValue mMK;
    private String mML;
    private TextView mMM;
    private ImageView mMN;
    private EditText mMO;
    private View mMP;
    private View mMQ;
    private View mMR;
    private String mMU;
    private TextView mMa;
    private TextView mMb;
    private TextView mMc;
    private TextView mMd;
    private TextView mMe;
    private TextView mMf;
    private ImageView mMg;
    private TextView mMh;
    private KPSwitchPanelLinearLayout mMk;
    private ImageView mMl;
    private c mMn;
    private d.a mMo;
    private FrescoThumbnailView mMp;
    private PagerSlidingTabStrip mMq;
    private KasViewPager mMr;
    private LinearLayout mMs;
    private f mMu;
    private ViewMicPerson mMv;
    public ArrayList<RoomTab> mMx;
    private PopH5Menu mMz;
    private long mLp = 0;
    private com.kascend.chushou.view.user.a mLx = null;
    private com.kascend.chushou.player.ui.a mLy = null;
    private int bB = -1;
    private int bC = 0;
    private View mLz = null;
    private View mLI = null;
    private ImageButton mLJ = null;
    private int mMi = 1;
    private boolean mMj = false;
    private boolean mMm = false;
    private boolean cw = false;
    private boolean mMt = false;
    private boolean mMw = false;
    private boolean cB = false;
    private boolean mMy = true;
    private int cK = 0;
    private int mMF = 0;
    private int mMG = -1;
    private final Rect mMI = new Rect();
    private boolean mMS = false;
    private C0801a mMT = null;
    private boolean da = false;
    private boolean mMV = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLG = getArguments().getString("mCover");
        this.mMy = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRt = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mRt;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dFS()) {
            c(view);
            aG();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.cB = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mSn != null) {
            this.mSn.b();
        }
        if (this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.mRJ).wA(true);
            ((VideoPlayer) this.mRJ).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cB = true;
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
        this.mMi = 1;
        this.mMj = false;
        U();
        if (this.mRK != null) {
            this.mRK.cg(null);
            this.mRK = null;
        }
        if (this.mLH != null) {
            dFT().removeAllViews();
            this.mLH = null;
        }
        this.c = null;
        this.mLd = null;
        tv.chushou.zues.a.a.ch(this);
        this.mMq = null;
        this.mMr = null;
        this.mLy = null;
        this.mLx = null;
        if (this.mLw != null) {
            for (int i = 0; i < this.mLw.length; i++) {
                this.mLw[i] = null;
            }
        }
        this.mLw = null;
        if (this.mLW != null) {
            this.mLW.addTextChangedListener(null);
            this.mLW.setOnTouchListener(null);
            this.mLW.setOnEditorActionListener(null);
            this.mLW = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mRJ, this.mMn);
        if (this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.mRJ).dED();
        }
        this.mMo = null;
        this.mMn = null;
        if (this.mMv != null) {
            this.mMv.b();
            this.mMv = null;
        }
        if (this.mMB != null) {
            this.mMB.dismiss();
        }
        if (this.mME != null) {
            this.mME.a();
            this.mME = null;
            this.mMD = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mMK = (LivePKBarUserValue) this.mRt.findViewById(a.f.live_pk_bar_user);
        this.mRC = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mMS) {
            this.mMS = true;
            if (this.mMQ == null) {
                this.mMQ = this.mRt.findViewById(a.f.vs_async_view);
                this.mMQ = ((ViewStub) this.mMQ).inflate();
            }
            if (this.mMR == null) {
                this.mMR = this.mRt.findViewById(a.f.vs_async_notification_view);
                this.mMR = ((ViewStub) this.mMR).inflate();
            }
            this.mLo = (VoiceInteractionView) this.mRt.findViewById(a.f.voiceInteractiveView);
            t();
            ds(this.mRt);
            dsU();
            ((VideoPlayer) this.mRJ).q();
            this.mLj = new com.kascend.chushou.player.e.a();
        }
    }

    private void ds(View view) {
        this.mMp = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mMq = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mMr = (KasViewPager) view.findViewById(a.f.vp_main);
        aH();
        dFl();
        aN();
        if (this.mRI != null) {
            I();
            a(this.mRI.mKP, this.mRI.mKS);
        }
        this.bb = 0;
        this.mSt = 0L;
        this.mSo = (RoundProgressBar) this.mRt.findViewById(a.f.roundProgressBar);
        this.mSq = (TextView) this.mRt.findViewById(a.f.tv_paonum);
        this.mSr = (FrescoThumbnailView) this.mRt.findViewById(a.f.iv_paoicon);
        this.mSy = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.cw = false;
                if (a.this.bB == 2) {
                    a.this.av(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.cF, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.cw = true;
                if (a.this.bB == 2) {
                    a.this.av(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.mSn != null) {
                    a.this.mSn.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gv(a.this.mRJ).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mRJ)) - a.this.mSn.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mRJ, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mRJ, 54.0f) * 2);
                    if (statusBarHeight < a.this.cF) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mSs = (PaoGuideView) this.mRt.findViewById(a.f.rlPaoGuideView);
        this.mMv = (ViewMicPerson) this.mRt.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.mNX = ((VideoPlayer) this.mRJ).dEw();
        this.mRI = ((VideoPlayer) this.mRJ).dEz();
        dt(this.mRt);
        this.cK = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
        this.mMF = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (com.kascend.chushou.b.dEg().d == 0 && this.mMF > 0) {
            View findViewById = this.mRt.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mMF);
        }
        dFr();
        dFp();
        if (!this.mMy) {
            Q();
        }
        aO();
        a();
        if (this.c == null) {
            this.mLd = new d.a();
            this.c = new GestureDetector(this.mRJ, this.mLd);
        }
        this.mLf = ((VideoPlayer) this.mRJ).dEA();
        this.mLf.a(this);
        if (this.mME != null) {
            this.mME.a();
            this.mME = null;
        }
        this.mMD = (GiftAnimationLayout) this.mRt.findViewById(a.f.ll_gift_animation);
        this.mMD.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mRI != null) {
            this.mME = new com.kascend.chushou.player.b.a(this.mRJ.getApplicationContext(), this.mMD);
            this.mME.a(this.mRI);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mRt.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mRD = (PlayerErrorView) this.mRt.findViewById(a.f.view_net_error_msg);
        this.mRD.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dFo();
        dFu();
        if (this.mRI.dFa() != null) {
            a(this.mRI.dFa());
        }
        FullRoomInfo dEZ = this.mRI.dEZ();
        if (dEZ != null) {
            dFx();
            if (i()) {
                this.ak = false;
                wE(true);
                this.mRK.Ks(8);
            }
            this.mLK.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dEZ.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mLz.setVisibility(0);
        this.ak = false;
        wE(true);
        this.mRK.Ks(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mRJ).n();
        if (this.mRI != null && !h.isEmpty(this.mRI.w)) {
            b(this.mRI.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dEK;
        aH();
        k();
        FullRoomInfo dEZ = this.mRI.dEZ();
        if (dEZ != null) {
            if (dEZ.mRoominfo != null) {
                this.mLK.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dEZ.mRoominfo.mOnlineCount)));
                this.mML = dEZ.mRoominfo.mRoomID;
            }
            dFx();
            if (!h.isEmpty(dEZ.mRoomToastList)) {
                Iterator<RoomToast> it = dEZ.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dEn().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mRI != null && this.mRI.l()) {
                d(true);
            }
            if (this.mRJ != null && (this.mRJ instanceof VideoPlayer) && (dEK = ((VideoPlayer) this.mRJ).dEK()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dEK.mNY, dEK.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mMs);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void aH() {
        boolean z = true;
        if (this.mRI == null || this.mRI.dEZ() == null || this.mRI.dEZ().mRoominfo == null || h.isEmpty(this.mRI.dEZ().mRoomTabs)) {
            this.mMw = false;
            this.mLw = new Fragment[2];
            this.mLv = new int[2];
            this.mLv[0] = 2;
            this.mLv[1] = 1;
            return;
        }
        this.mMw = true;
        this.mMx = new ArrayList<>();
        Iterator<RoomTab> it = this.mRI.dEZ().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mMx.add(next);
            }
        }
        if (this.mMx.size() >= 2 && this.mLv != null && this.mLv.length >= 2 && this.mMx.get(0).type == this.mLv[0] && this.mMx.get(1).type == this.mLv[1]) {
            z = false;
        }
        this.mLw = new Fragment[this.mMx.size()];
        this.mLv = new int[this.mMx.size()];
        for (int i = 0; i < this.mMx.size(); i++) {
            this.mLv[i] = this.mMx.get(i).type;
        }
        if (z) {
            this.mMT = new C0801a(getChildFragmentManager());
            this.mMr.setAdapter(this.mMT);
        }
    }

    private void dFl() {
        this.mLV = (RelativeLayout) this.mRt.findViewById(a.f.rl_edit_bar);
        this.mLR = (FrescoThumbnailView) this.mRt.findViewById(a.f.btn_hotword);
        this.mLR.yG(a.e.ic_hotwords_black_n);
        this.mLR.setOnClickListener(this);
        this.mLT = (ImageView) this.mRt.findViewById(a.f.iv_task_badge);
        this.mLS = (AnimationSet) AnimationUtils.loadAnimation(this.mRJ, a.C0795a.anim_hotword);
        this.mLS.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dEn().c) {
                    a.this.mLR.clearAnimation();
                    a.this.mLR.startAnimation(a.this.mLS);
                }
            }
        });
        if (com.kascend.chushou.d.h.dEn().c) {
            this.mLR.startAnimation(this.mLS);
            this.mLT.setVisibility(0);
        }
        this.mLU = (TextView) this.mRt.findViewById(a.f.tv_bottom_input);
        this.mLU.setOnClickListener(this);
        this.mSK = (FrescoThumbnailView) this.mRt.findViewById(a.f.ll_btn_set);
        this.mSK.setOnClickListener(this);
        this.mMs = (LinearLayout) this.mRt.findViewById(a.f.ll_bottom_all_button);
        this.mLP = (RelativeLayout) this.mRt.findViewById(a.f.rl_bottom_input);
        this.mLQ = this.mRt.findViewById(a.f.ll_bottom_input);
        this.mLP.setVisibility(8);
        this.mLW = (PastedEditText) this.mRt.findViewById(a.f.et_bottom_input);
        this.mLW.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mLX.setEnabled(editable.length() > 0);
            }
        });
        this.mLW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mLX);
                    return true;
                }
                return true;
            }
        });
        this.mLW.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.mLW);
                }
                return false;
            }
        });
        this.mMl = (ImageView) this.mRt.findViewById(a.f.iv_btn_emoji);
        this.mMl.setVisibility(8);
        this.mLX = (TextView) this.mRt.findViewById(a.f.tv_btn_send);
        this.mLX.setOnClickListener(this);
        this.mMk = (KPSwitchPanelLinearLayout) this.mRt.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dEg().d == 0) {
            this.mMk.setUseStatusBar(true);
        }
        this.mLY = (LinearLayout) this.mRt.findViewById(a.f.head_trumpet);
        this.mLY.setVisibility(8);
        this.mLY.setOnClickListener(this);
        this.mLZ = (TextView) this.mRt.findViewById(a.f.tv_primary_name);
        this.mMa = (TextView) this.mRt.findViewById(a.f.tv_primary_desc);
        this.mMd = (TextView) this.mRt.findViewById(a.f.tv_cut_count);
        this.mMd.setOnClickListener(this);
        this.mMf = (TextView) this.mRt.findViewById(a.f.tv_head_count);
        this.mMf.setText(this.mMi + "");
        this.mMe = (TextView) this.mRt.findViewById(a.f.tv_plus_count);
        this.mMe.setOnClickListener(this);
        this.mMc = (TextView) this.mRt.findViewById(a.f.tv_buy_count_coin);
        this.mMb = (TextView) this.mRt.findViewById(a.f.tv_buy_head);
        this.mMb.setOnClickListener(this);
        this.mMg = (ImageView) this.mRt.findViewById(a.f.iv_trumpet_select);
        this.mMg.setOnClickListener(this);
        this.mMh = (TextView) this.mRt.findViewById(a.f.tv_trumpet_have_count);
        this.mMj = false;
        this.mMg.setBackgroundResource(a.e.ic_trumpet_n);
        this.mMh.setVisibility(8);
        dFn();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mMk, this.mMl, this.mLW, new a.InterfaceC0925a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0925a
            public void wB(boolean z) {
                if (a.this.mMl != null) {
                    if (!z) {
                        a.this.mMl.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dEg().d == 0) {
                        a.this.mMk.setDirectVisibility(0);
                    }
                    a.this.mMl.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mMo = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wC(boolean z) {
                if (a.this.mMV) {
                    a.this.mMV = false;
                    return;
                }
                a.this.mMm = z;
                if (z) {
                    a.this.mMl.setImageResource(a.e.cs_emoji_normal);
                    a.this.dFm();
                    return;
                }
                if (a.this.mMP != null && a.this.mMP.getVisibility() == 0) {
                    a.this.mMP.setVisibility(8);
                }
                if (a.this.cw) {
                    a.this.mSn.setVisibility(0);
                }
                if (a.this.mRJ != null && (a.this.mRJ instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mRJ).wA(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mMn = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mMk, this.mMo, ((VideoPlayer) this.mRJ).dEE());
        ((VideoPlayer) this.mRJ).h(((VideoPlayer) this.mRJ).dEE());
        this.mMP = this.mRt.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mMM = (TextView) this.mRt.findViewById(a.f.btn_room_search);
        this.mMN = (ImageView) this.mRt.findViewById(a.f.iv_room_emoji_delete);
        this.mMO = (EditText) this.mRt.findViewById(a.f.et_room_emoji_search);
        this.mMO.setImeOptions(3);
        this.mMO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mMM);
                    return true;
                }
                return false;
            }
        });
        this.mMO.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mMM.setEnabled(editable.length() > 0);
                a.this.mMN.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mSn.setEmojiSearchText(editable.toString());
            }
        });
        this.mMM.setOnClickListener(this);
        this.mMN.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dD(this.mMO);
            this.mMP.setVisibility(0);
            this.mMO.requestFocus();
        } else {
            this.mMP.setVisibility(8);
        }
        if (z2) {
            this.mMO.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFm() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gv(this.mRJ).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ)) - tv.chushou.zues.widget.kpswitch.b.d.gI(this.mRJ)) - tv.chushou.zues.utils.a.dip2px(this.mRJ, 14.0f)) - this.mRJ.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mRJ, 54.0f) * 2);
        if (statusBarHeight < this.cF) {
            b(statusBarHeight, 10);
        }
    }

    private void dFn() {
    }

    private void dFo() {
        this.mRK = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.au(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mRt.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mRJ.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mRK.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mRK.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mRK.A(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mRK);
                            break;
                        case 12:
                            a.this.b(a.this.mRK);
                            break;
                        case 17:
                            a.this.dFU();
                            break;
                        case 18:
                            a.this.dsT();
                            break;
                        case 19:
                            a.this.mRH.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void aM() {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mMx)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mMx.size()) {
                    if (!h.isEmpty(this.mMx.get(i2).notifyIcon)) {
                        this.mMq.bF(i2, this.mMx.get(i2).notifyIcon);
                        this.mMq.KS(i2);
                    } else if (this.mMx.get(i2).notify == 1) {
                        this.mMq.KR(i2);
                        this.mMq.KQ(i2);
                    } else {
                        this.mMq.KQ(i2);
                        this.mMq.KS(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mMx)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mMx.size()) {
                    if (this.mMx.get(i4).type == i) {
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
    public String IX(int i) {
        if (this.mRI == null || this.mRI.dEZ() == null || this.mRI.dEZ().mRoominfo == null || h.isEmpty(this.mMx)) {
            if (i == 1) {
                return this.mRJ.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mRJ.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mMx.size()) {
            return this.mMx.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mMx) && i < this.mMx.size()) {
            this.mMx.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mMx) && i < this.mMx.size()) {
            this.mMx.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.mMr != null && this.mMq != null && this.mLv != null) {
            this.mLy = null;
            if (this.mLw != null) {
                for (int i = 0; i < this.mLw.length; i++) {
                    this.mLw[i] = null;
                }
            }
            if (this.mMT == null) {
                this.mMT = new C0801a(getChildFragmentManager());
                this.mMr.setAdapter(this.mMT);
            } else {
                this.mMT.notifyDataSetChanged();
            }
            this.mMr.setOffscreenPageLimit(this.mLv.length);
            this.mMq.c(this.mMr);
            this.mMq.setOnPageChangeListener(this);
            this.mMq.notifyDataSetChanged();
            this.mMq.setVisibility(0);
            this.mMr.setVisibility(0);
            if (!this.mMw) {
                this.bB = 2;
                this.mMr.setCurrentItem(c(2, 0));
                this.mLP.setVisibility(0);
            } else {
                if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                    if (!h.isEmpty(this.mRI.dEZ().mRoominfo.mGameName)) {
                        this.mLC.setText(this.mRI.dEZ().mRoominfo.mGameName);
                    } else {
                        this.mLC.setText(this.mRJ.getString(a.i.no_online_game_name));
                    }
                    this.mLB.setText(this.mRI.dEZ().mRoominfo.mName);
                } else {
                    this.mLC.setText(this.mRJ.getString(a.i.no_online_game_name));
                }
                aM();
                if (i()) {
                    dFv();
                    if (this.mMr != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.mMr.setCurrentItem(c);
                        this.mMq.setSelectItem(c);
                    }
                } else if (this.mMr != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.mMr.setCurrentItem(c2);
                    this.mMq.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mRJ);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dFT().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void aP() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mRJ).s();
        dta();
        dFs();
        dFk();
        dFT().setBackgroundResource(a.e.room_not_online);
        if (this.mLH == null) {
            this.mLH = new RecommendView(this.mRJ);
            dFT().addView(this.mLH);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mRJ);
            this.mLH.setLayoutParams(layoutParams);
        }
        if (this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mRI.dEZ().mRoominfo.mRoomID)) {
            this.mLH.a(this.mRI.dEZ().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dFS() && a.this.mRJ != null && a.this.dFT() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mRJ);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.mro);
                        if (a.this.dFT().getChildCount() >= 2) {
                            a.this.dFT().addView(frescoThumbnailView, 0);
                        }
                        a.this.dFT().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dRP(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mSw != null) {
            this.mSw.dRk();
            this.mSw.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mSn != null) {
            this.mSn.e();
        }
        wE(false);
        a(false, false);
        if (this.mLf != null) {
            this.mLf.d();
        }
    }

    private void dFp() {
        int i = 0;
        this.mLz = this.mRt.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dEg().d == 0 && this.cK > 0) {
            View findViewById = this.mRt.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.cK;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mLA = (ImageView) this.mLz.findViewById(a.f.back_icon);
        this.mLA.setOnClickListener(this);
        this.mLB = (MarqueeTextView) this.mLz.findViewById(a.f.tv_title);
        this.mLC = (MarqueeTextView) this.mLz.findViewById(a.f.tv_Type);
        this.mLE = (ImageView) this.mRt.findViewById(a.f.btn_setting);
        this.mLI = this.mRt.findViewById(a.f.bottomview);
        if (this.mRA == null) {
            this.mRA = (ImageButton) this.mLI.findViewById(a.f.btn_barrage);
            this.mRA.setOnClickListener(this);
            if (this.mRI != null) {
                if (com.kascend.chushou.d.h.dEn().n()) {
                    this.mRA.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mRA.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mRB = (ImageButton) this.mLI.findViewById(a.f.btn_audio);
        this.mRB.setOnClickListener(this);
        if (this.mRI != null && this.mRI.d) {
            this.mRB.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mRB.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mRI != null && this.mRI.f != null) {
            while (true) {
                if (i >= this.mRI.f.size()) {
                    break;
                } else if (!"2".equals(this.mRI.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mLJ = (ImageButton) this.mLI.findViewById(a.f.playbutton);
        this.mLJ.setOnTouchListener(this);
        this.mLF = (ImageButton) this.mLI.findViewById(a.f.btn_refresh);
        this.mLF.setOnClickListener(this);
        this.mLK = (TextView) this.mLI.findViewById(a.f.tv_online_count);
        if (this.mRz == null) {
            this.mRz = (ImageButton) this.mLI.findViewById(a.f.btn_screenChange);
            this.mRz.setOnClickListener(this);
        }
        if (this.mLD == null) {
            this.mLD = (ImageView) this.mLz.findViewById(a.f.report_icon);
            this.mLD.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.Nm();
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
        if (!dFS() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mLy != null) {
                        this.mLy.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                        this.mRI.dEZ().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mRI.dEZ().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.mRI.dEZ().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mRI.dEZ().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.mRI.dEZ().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mRI.dEZ().mMicStatus.onMic) {
                            this.mRI.dEZ().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mRI.dEZ().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.mRI.dEZ().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mRI.dEZ().mMicStatus != null && !h.isEmpty(this.mRI.dEZ().mMicStatus.micRoomId) && !this.mRI.dEZ().mMicStatus.micRoomId.equals("0")) {
                                this.mMU = this.mRI.dEZ().mMicStatus.micRoomId;
                            }
                            if (this.mLy != null) {
                                this.mLy.a(this.mRI.dEZ().mMicStatus, this.mRI.dEZ().mFanItems, str, z2);
                            }
                            if (this.mMv != null && this.mMv.getVisibility() == 0) {
                                this.mMv.a(this.mRI.dEZ().mFanItems, this.mRI.dEZ().mMicStatus, str, z2, this.mRI.dEZ().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mLy != null) {
                                this.mLy.e();
                            }
                            if (this.mMv != null && this.mMv.isShown()) {
                                this.mMv.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mLy != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mLy.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mLy.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mMG != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mMG = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mLj != null && this.mLj.mNY != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mLj.mNY.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mLj.mNY.mInPKMode = true;
                                    this.mLj.mNY.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mLj.mNY.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mLj.mNY.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mLj.mNY.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mLj.mNY.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mLj.mNY.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mLj.mNY.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mLj.mNY.mMode = pkNotifyInfo.mMode;
                                    this.mLj.mNY.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dFB() != null) {
                                        dFB().g(true, this.mLj.mNY.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dEn().a) {
                                        if (!com.kascend.chushou.b.dEg().e) {
                                            com.kascend.chushou.b.dEg().e = true;
                                            g.F(this.mRJ, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dEn().a(this.mRJ, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.mMK != null) {
                                        this.mMK.setVisibility(0);
                                    }
                                    this.mLj.mNY.mAction = 7;
                                    this.mLj.mNY.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mLj.mNY.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mLj.mNY.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mLj.mNY.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mLj.mNY.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mLj.mNY.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dFB() != null) {
                                        dFB().g(false, 0L);
                                        dFB().b(this.mLj.mNY, true);
                                        dFB().a(this.mLj.mNY.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Qy(this.mML);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mLj.mNY.mInPKMode = false;
                                    this.mLj.mNY.mAction = 2;
                                    bd();
                                    if (dFB() != null) {
                                        dFB().c();
                                    }
                                    if (com.kascend.chushou.d.h.dEn().a) {
                                        if (!com.kascend.chushou.b.dEg().e) {
                                            com.kascend.chushou.b.dEg().e = true;
                                            g.F(this.mRJ, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dEn().a(this.mRJ, false);
                                        ak();
                                    }
                                    this.mLj.b = null;
                                    this.mLj.mNY = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Qy(this.mML);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mLj.mNY.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mLj.mNY.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mLj.mNY.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mRI.dEZ().mRoominfo.mRoomID) && this.mRI.dEZ().mRoominfo.mRoomID.equals(this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dFB() != null) {
                                        dFB().a(this.mLj.mNY, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mLj.mNY.copyUpdate(pkNotifyInfo);
                                    if (dFB() != null) {
                                        dFB().a(this.mLj.mNY);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mLj.mNY.copyStop(pkNotifyInfo);
                                        if (dFB() != null) {
                                            dFB().A(this.mLj.mNY.mMaxFreeDuration, this.mLj.mNY.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mLj.mNY.copyResult(pkNotifyInfo);
                                    if (!this.cB && dFB() != null) {
                                        int i5 = 1;
                                        if (this.mLj.mNY.destinyInfo != null && this.mLj.mNY.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dFB().a(h.parseInt(this.mLj.mNY.mResult), h.parseLong(this.mLj.mNY.mvpUid), this.mLj.mNY.mvpAvatar, this.mLj.mNY.mvpNickname, this.mLj.mNY.mMaxFreeDuration, this.mLj.mNY.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mLy != null) {
                if (LoginManager.Instance().islogined() && this.mRI != null && this.mRI.l()) {
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
                if (this.mRI == null || this.mRI.dEZ() == null || this.mRI.dEZ().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mRI.dEZ().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dEn().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dEn().b().equals(next2.mUserID)) {
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
                this.mLy.a(arrayList, true, false);
                this.mLy.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mLv != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mLv.length) {
                    break;
                }
                if (this.mLv[i2] == 99 && this.mLw != null && this.mLw[i2] != null && (this.mLw[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mLw[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mMx.size() && this.mMq != null) {
                if (i == 0) {
                    this.mMq.setTagText(i2, new StringBuilder(this.mMx.get(i2).name).toString());
                    return;
                } else {
                    this.mMq.setTagText(i2, this.mMx.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mRA != null) {
            if (z) {
                this.mRA.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mRA.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dFq() {
        if (this.mRt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mRt.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
        this.ar = Math.min(gv.x, gv.y);
        this.aq = (this.ar * this.mRJ.getResources().getInteger(a.g.h_thumb_height_def)) / this.mRJ.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dFT().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mRC.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.cF = this.aq + this.mRJ.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mRJ, 54.0f);
        b(this.cF, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dFr() {
        Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
        this.ar = Math.min(gv.x, gv.y);
        this.aq = (this.ar * this.mRJ.getResources().getInteger(a.g.h_thumb_height_def)) / this.mRJ.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dFT().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mRC.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.cF = this.aq + this.mRJ.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mRJ, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.cF, 10);
        k();
        if (!h.isEmpty(this.mLG)) {
            File af = tv.chushou.zues.widget.fresco.a.af(Uri.parse(this.mLG));
            if (af != null && af.exists()) {
                this.mRC.setImageURI(Uri.fromFile(af));
                this.mRC.setVisibility(0);
                return;
            }
            this.mRC.setVisibility(8);
            return;
        }
        this.mRC.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mLD != null) {
            this.mLD.setVisibility(z ? 0 : 4);
        }
        if (this.mLE != null) {
            this.mLE.setVisibility(z ? 0 : 4);
        }
    }

    public boolean au(boolean z, boolean z2) {
        return k(z, z2, this.f);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.mRK != null) {
            this.mRK.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mRJ).f(true);
            if (!z3) {
                if (this.mLI.getVisibility() != 0 && z2) {
                    this.mLI.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mRB.setVisibility(0);
                } else {
                    this.mRB.setVisibility(8);
                }
                this.mLI.setVisibility(0);
            }
            PlayUrl dFa = this.mRI.dFa();
            if (dFa != null && "2".equals(dFa.mType)) {
                if (this.mRz != null) {
                    this.mRz.setVisibility(8);
                }
            } else if (this.mRz != null) {
                this.mRz.setVisibility(0);
            }
            if (this.mLz.getVisibility() != 0 && z2) {
                this.mLz.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_top_anim));
            }
            t(!z3);
            this.mLz.setVisibility(0);
            w(true);
            if (this.mRK != null) {
                this.mRK.A(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mRJ).f(false);
            if (this.mSa != null) {
                this.mSa.dismiss();
            }
            if (this.mSb != null) {
                this.mSb.dismiss();
            }
            if (this.mLI.getVisibility() != 8 && z2) {
                this.mLI.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_bottom_anim));
            }
            this.mLI.setVisibility(8);
            if (this.mLz.getVisibility() != 8 && z2) {
                this.mLz.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_top_anim));
            }
            this.mLz.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dta() {
        if (this.mSs == null || !this.mSs.isShown()) {
            return false;
        }
        this.mSs.d();
        return true;
    }

    public boolean dFs() {
        if (this.mMv == null || !this.mMv.isShown()) {
            return false;
        }
        this.mMv.a();
        return true;
    }

    public boolean dFk() {
        if (this.mMz == null || !this.mMz.b()) {
            return false;
        }
        this.mMz.a();
        return true;
    }

    public boolean dFt() {
        if (this.cw && this.mSn != null) {
            if (this.mSn != null) {
                this.mSn.e();
            }
            if (this.mMO != null) {
                this.mMO.setText("");
            }
            if (this.bB == 2) {
                av(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mRt != null) {
            if (this.mMz == null) {
                this.mMz = (PopH5Menu) ((ViewStub) this.mRt.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mMz.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mMz.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.mLz.getHeight() + this.mLz.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mRJ, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                g.c(this.mRJ, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mRI.a(false);
                a(false, false);
                ((VideoPlayer) this.mRJ).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.mRJ, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mLj == null || this.mLj.mNY == null || !this.mLj.mNY.mInPKMode) {
                ((VideoPlayer) this.mRJ).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mMj) {
                f(this.mLW.getText().toString());
            } else {
                a(this.mLW.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dEn().c) {
                com.kascend.chushou.d.h.dEn().b(false);
                this.mLS.cancel();
                this.mLS.reset();
                this.mLR.clearAnimation();
                this.mLT.setVisibility(8);
            }
            n(view, 0, this.mRt.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mRJ, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.mRt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mRI.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mRJ, null) && this.mRI != null && this.mRI.mKR != null) {
                if (this.mMj) {
                    bg();
                    return;
                }
                if (this.mRI != null && this.mRI.mKR != null && this.mRI.mKR.count > 0) {
                    this.mLY.setVisibility(8);
                } else {
                    this.mLY.setVisibility(0);
                }
                this.mMj = true;
                this.mMg.setBackgroundResource(a.e.ic_trumpet_p);
                this.mMh.setVisibility(0);
                this.mMh.setSelected(true);
                this.mMh.setTextColor(Color.parseColor("#ff5959"));
                if (this.mLW != null) {
                    this.mLW.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mMi <= 9) {
                this.mMi++;
                this.mMf.setText(this.mMi + "");
            }
            dFC();
        } else if (id == a.f.tv_cut_count) {
            if (this.mMi > 1) {
                this.mMi--;
                this.mMf.setText(this.mMi + "");
            }
            dFC();
        } else if (id == a.f.tv_buy_head) {
            bf();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mMO.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mMO.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.mMO);
                this.mSn.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mLW != null && this.mLP != null && this.mLV != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mLW);
                this.mLP.setVisibility(8);
                if (this.bB == 2) {
                    this.mLV.setVisibility(0);
                }
            }
        } else if (this.mLP != null && this.mLV != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
            if (this.bB == 2) {
                this.mLP.setVisibility(0);
            }
            this.mLV.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dEn().c(roomToast.mToastContent);
            if (this.mMB == null) {
                aS();
            }
            if (this.mMC != null) {
                this.mMC.setText(roomToast.mToastContent);
            }
            if (!this.mMB.isShowing()) {
                if (this.mMs != null) {
                    this.mMB.showAtLocation(this.mMs, 85, 0, this.mRt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mMB != null) {
                                a.this.mMB.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mMB.dismiss();
        }
    }

    private void aS() {
        if (this.mMB == null) {
            View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mMC = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mMB = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 160.0f), -2);
            this.mMB.setFocusable(false);
            this.mMB.setOutsideTouchable(false);
            this.mMB.setAnimationStyle(a.j.gift_toast_style);
            this.mMB.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.mSi != null && this.mSi.isShowing()) {
            this.mSi.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
        if (this.mSH == null) {
            dFV();
        }
        if (!this.mSH.isShowing()) {
            this.mSH.showAtLocation(view, 83, i, i2);
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mSH.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.mSK != null) {
            if (h.isEmpty(this.mSL)) {
                if (((VideoPlayer) this.mRJ).q) {
                    this.mSK.bV(this.mRI != null ? this.mRI.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mSK.bV(this.mRI != null ? this.mRI.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mRJ).q && this.mSL.size() == 2 && this.mSL.contains("4") && this.mSL.contains("2")) {
                this.mSK.bV(this.mRI != null ? this.mRI.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mSL.size() > 1 || !((VideoPlayer) this.mRJ).q) {
                this.mSK.bV(this.mRI != null ? this.mRI.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mSL.get(0))) {
                this.mSK.bV(this.mRI != null ? this.mRI.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mSL.get(0))) {
                this.mSK.bV(this.mRI != null ? this.mRI.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mSL.get(0))) {
                this.mSK.bV(this.mRI != null ? this.mRI.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
        if (this.mSi == null) {
            al();
            this.mSi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mSi.isShowing() && this.bB == 2) {
            this.mSi.showAtLocation(view, 83, i, this.mRJ.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mSi.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mRC != null) {
            this.mRC.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                g.c(this.mRJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mNX.getPlayState() == 4) {
                        e(true);
                        if (this.mRI.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mRI.a(false);
                        ((VideoPlayer) this.mRJ).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mNX.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mNX.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                g.c(this.mRJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mRI.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mRJ).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                    this.ai = false;
                    wE(true);
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
        if (this.mSw != null) {
            if (z) {
                this.mSw.setVisibility(0);
            }
            this.mSw.dRk();
            if (!z) {
                this.mSw.setVisibility(8);
            }
        }
        g.c(this.mRJ, this.mRJ.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mLJ != null) {
                this.mLJ.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mRD != null) {
                this.mRD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mLJ != null) {
            this.mLJ.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mRD != null) {
                    this.mRD.setVisibility(8);
                }
            }
        }
    }

    private void dFu() {
        this.e = false;
        k(true, false, true);
    }

    private void dFv() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mLv[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            aM();
            a(this.mRI != null ? this.mRI.mKS.get("1") : null);
            if (i2 == 2) {
                k();
                av(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            av(false, i3);
            v(false);
            b(false);
            if (this.mSi != null && this.mSi.isShowing()) {
                this.mSi.dismiss();
            }
            if (i2 == 99) {
                if (this.mLw != null && this.mLw[i] != null && (this.mLw[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mLw[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, "房间信息页_num", null, new Object[0]);
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
    protected void ak() {
        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mRK != null) {
            if (this.mLV != null && this.mLV.getVisibility() == 0) {
                u(false);
            }
            if (this.mRD != null && this.mRD.getVisibility() == 0) {
                this.f = true;
            }
            au(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mLy != null) {
            this.mLy.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mLy != null) {
            this.mLy.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mLy != null) {
            this.mLy.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mLy != null) {
            this.mLy.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mMs != null) {
            int size = iconConfig.configs.size();
            this.mMs.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mMs, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bV(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bV(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.bV(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.bV(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.bV(str, a.e.ic_default_video_bottom);
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
                    public void dr(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.mMs.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mRI != null ? this.mRI.mKS : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mLy != null) {
            this.mLy.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mMp != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mMp.yG(a.c.kas_white);
            } else if (this.bB == 2) {
                this.mMp.bV(str, a.c.kas_white);
                if (this.mMq != null) {
                    this.mMq.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mMp.yG(a.c.kas_white);
                if (this.mMq != null) {
                    this.mMq.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mMq != null) {
                    this.mMq.setTextColor(a);
                    this.mMq.setTabTextSelectColor(a2);
                    this.mMq.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mLR != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mLR.yG(a.e.ic_hotwords_black_n);
            } else {
                this.mLR.bV(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mLQ != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dGi().a(str, this.mLQ, a.e.player_skin_input);
            } else {
                this.mLQ.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mLU != null) {
                this.mLU.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void a(int i) {
        if (this.mLy != null) {
            this.mLy.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void D() {
        if (this.mRJ instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dEF = ((VideoPlayer) this.mRJ).dEF();
            if (this.mSA == null) {
                this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mSA.setVisibility(0);
            this.mSA.a(2, dEF);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mLy != null) {
            this.mLy.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mLy != null) {
            this.mLy.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(long j) {
        if (this.mLy != null) {
            this.mLy.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0808a
    public void c(int i) {
        if (this.mLy != null) {
            this.mLy.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mLy != null && this.mRI != null) {
            this.mLy.b(this.mRI.mKQ);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void c(String str) {
        super.c(str);
        g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0801a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0801a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mLv.length) {
                return null;
            }
            switch (a.this.mLv[i]) {
                case 1:
                    if (a.this.mLx == null) {
                        a.this.mLx = com.kascend.chushou.view.user.a.a(2, null, a.this.mRI.a, false, a.this.mRI.h, false);
                    }
                    a.this.mLw[i] = a.this.mLx;
                    return a.this.mLx;
                case 2:
                    if (a.this.mLy == null) {
                        a aVar = a.this;
                        if (a.this.mLj != null && a.this.mLj.mNY != null) {
                            z = a.this.mLj.mNY.mInPKMode;
                        }
                        aVar.mLy = com.kascend.chushou.player.ui.a.wF(z);
                    }
                    a.this.mLw[i] = a.this.mLy;
                    return a.this.mLy;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mRI != null && a.this.mRI.dEZ() != null && !h.isEmpty(a.this.mMx)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mMx.get(i).url);
                        h5Options.a = a.this.mMx.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mLw[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.IX(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.mLv.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int lK(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int IY(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String IZ(int i) {
            return a.this.IX(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Ja(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Jb(int i) {
            int dimensionPixelSize = a.this.mRJ.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Cj(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.KB(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mLp <= 3000) {
            g.KB(a.i.str_too_fast);
            return false;
        } else {
            dFy();
            if (!com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a(((VideoPlayer) this.mRJ).dEz().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mLp = System.currentTimeMillis();
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                a(this.mRI.dEZ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mRI.h);
            }
            g(this.b);
            if (!z && this.mLW != null) {
                this.mLW.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dFy();
            if (com.kascend.chushou.d.e.c(this.mRJ, null) && LoginManager.Instance().getUserInfo() != null && this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                a(this.mRI.dEZ().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mLW != null) {
                this.mLW.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mLy != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mRI.dEZ().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mRI.dEZ().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mRJ).mJi;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Ss(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mLy.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mLy.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.mLy != null) {
            this.mLy.e();
        }
        if (this.mMv != null && this.mMv.isShown()) {
            this.mMv.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dFw() {
        super.dFw();
        if (this.mRJ instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mRI != null) {
            this.mRI.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mMt);
        if (this.mRJ != null) {
            if (this.mMt || "10004".equals(((VideoPlayer) this.mRJ).t)) {
                this.mMt = true;
                if (this.mRI != null) {
                    this.mRI.f = null;
                    if (this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                        this.mRI.dEZ().mRoominfo.mGameId = null;
                    }
                }
                aP();
                return;
            }
            this.mMt = true;
            if (this.mRJ != null) {
                ((VideoPlayer) this.mRJ).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mMt = false;
        if (this.mLH != null) {
            this.mLH.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mMt = false;
        if (this.mLH != null) {
            this.mLH.setVisibility(8);
        }
        super.i(z);
    }

    private void dFx() {
        aN();
        if (i()) {
            aY();
            ap();
            return;
        }
        aP();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dFT().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mSw != null) {
            this.mSw.setVisibility(0);
        }
        if (this.mLf != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mLf.d();
        }
        if (this.mLP != null) {
            this.mLP.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mLE.setVisibility(0);
            this.mLE.setOnClickListener(this);
        } else {
            this.mLE.setVisibility(8);
        }
        this.mLJ.setVisibility(0);
        this.mLF.setVisibility(0);
        this.mRA.setVisibility(0);
        if (this.p) {
            this.mRB.setVisibility(0);
        } else {
            this.mRB.setVisibility(8);
        }
        aX();
        av(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mSA != null && this.mSA.a(i, keyEvent)) {
                return true;
            }
            if (this.mMz != null && this.mMz.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mMA != null && this.mMA.onKeyDown(i, keyEvent)) || aD()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mMP != null && this.mMP.getVisibility() == 0 && b(motionEvent, this.mMP)) {
                this.mMP.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.mMO);
                return true;
            } else if (this.cw && this.mMP != null && this.mMP.getVisibility() == 8 && f(this.mSn.b, motionEvent)) {
                dFt();
                return true;
            } else if (this.mMz != null && this.mMz.b() && f(this.mMz, motionEvent)) {
                this.mMz.a();
                return true;
            } else if (this.mMA != null && this.mMA.b() && f(this.mMA, motionEvent)) {
                this.mMA.a();
                return true;
            } else if (b(motionEvent, this.mLV)) {
                return dFy();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dFy() {
        boolean z;
        b(this.cF, 10);
        boolean z2 = false;
        if (this.mMk != null && this.mMk.getVisibility() == 0) {
            this.mMk.setVisibility(8);
            this.mMl.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mMm) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
            this.mMl.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mLV == null || this.mLV.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mMj) {
                bg();
            }
            this.mLV.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mLP != null && a.this.bB == 2) {
                        a.this.mLP.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean aD() {
        if (dFy()) {
            return true;
        }
        if (this.mSi == null || !this.mSi.isShowing()) {
            return dFt() || dFs() || dta();
        }
        this.mSi.dismiss();
        return true;
    }

    public boolean b(MotionEvent motionEvent, View view) {
        if (view != null) {
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            return motionEvent.getY() <= ((float) iArr[1]);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ() {
        this.mLP.setVisibility(8);
        this.mLV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z, boolean z2) {
        if (this.mLP != null) {
            if (z) {
                if (this.mLP.getVisibility() != 0) {
                    this.mLP.setVisibility(0);
                    this.mLP.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_bottom_anim));
                }
            } else if (this.mLP.getVisibility() != 4) {
                this.mLP.setVisibility(4);
                this.mLP.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mLH != null) {
            this.mLH.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dFz() {
        return this.mME;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dFS()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mRI != null) {
                        this.mRI.f = null;
                        this.mRI.dEZ().mRoominfo.mGameId = null;
                    }
                    aP();
                    return;
                }
                g.KB(a.i.str_getvideosource_failed);
            }
            wE(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mRI != null && this.mRI.dFa() != null) {
            a(this.mRI.dFa());
        }
        this.p = false;
        if (this.mRI == null || this.mRI.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mRI.f.size()) {
                if (!"2".equals(this.mRI.f.get(i2).mType)) {
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
        if (this.mLy != null) {
            this.mLy.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dFS()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mLK != null && this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                this.mLK.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mRI.dEZ().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dFS() && !this.cB && (c = c(1, -1)) >= 0 && c < this.mMx.size() && this.mMr != null) {
            this.mMr.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dFS() && !this.cB) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dEG = ((VideoPlayer) this.mRJ).dEG();
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(2, dEG);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dEH = ((VideoPlayer) this.mRJ).dEH();
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(2, dEH);
            } else if (bVar.a == 9) {
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mMk != null) {
            this.mMk.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dFS() && !this.cB) {
            if (iVar.a == 53) {
                if (iVar.b instanceof String) {
                    a((String) iVar.b, true);
                }
            } else if (iVar.a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (!dFS() && this.mRI != null) {
            String str = this.mRI.a;
            RoomInfo dFc = this.mRI.dFc();
            if (dFc != null && mVar.a(dFc.mCreatorUID, str)) {
                dFc.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dFS()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mLW != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mLW);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nm() {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
            if (this.mMu == null) {
                this.mMu = new f(getActivity());
            }
            this.mMu.a(this.mRI.dEZ().mRoominfo);
            if (!this.mMu.isShowing()) {
                this.mMu.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mLy != null) {
            this.mLy.d();
        }
    }

    private void dt(View view) {
        this.mLL = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mLM = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mLM.setText(new tv.chushou.zues.widget.a.c().J(this.mRJ, a.e.videoplayer_4g_video).append("  ").append(this.mRJ.getString(a.i.videoplayer_4g_video)));
        this.mLN = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mLN.setText(new tv.chushou.zues.widget.a.c().J(this.mRJ, a.e.videoplayer_4g_audio).append("  ").append(this.mRJ.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mLL.setVisibility(8);
                    ((VideoPlayer) a.this.mRJ).c(a.this.mLO);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mLL.setVisibility(8);
                    ((VideoPlayer) a.this.mRJ).d(a.this.mLO);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dEg().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mLM.setOnClickListener(onClickListener);
        this.mLN.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mRI != null && !h.isEmpty(this.mRI.f)) {
            f(this.mRI.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mLO = z;
            this.p = false;
            if (this.mRI != null && this.mRI.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mRI.f.size()) {
                        break;
                    } else if (!"2".equals(this.mRI.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mLL != null) {
                this.mLL.setVisibility(0);
                this.mLM.setVisibility(0);
                this.mLN.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mLL != null) {
            this.mLL.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mMH == null) {
                this.mMH = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dFS()) {
                            a.this.dFA();
                        }
                    }
                };
                if (this.mRK != null) {
                    this.mRK.e(this.mMH, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mMH != null && this.mRK != null) {
            this.mRK.P(this.mMH);
            this.mMH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFA() {
        if (LoginManager.Instance().islogined() && this.mLy != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "显示双击666_num", null, new Object[0]);
            if (this.mRI != null) {
                this.mRI.b(false);
            }
            d(false);
            this.mLy.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mRt != null) {
            if (this.mMA == null) {
                this.mMA = (InteractionView) ((ViewStub) this.mRt.findViewById(a.f.view_interaction)).inflate();
                this.mMA.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mMA.a();
                    }
                });
            }
            if (this.mMA != null) {
                this.mMA.b(configDetail);
                this.mMA.c();
                this.mMA.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dRX()) {
                g.F(this.mRJ, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mRJ, null) && (this.mRJ instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mRI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mRI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mRJ, configDetail.mUrl, this.mRJ.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mRJ, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    bc();
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

    private void bc() {
        if (this.cw) {
            dFt();
            return;
        }
        if (this.mRJ.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mRJ != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mLj == null) {
                this.mLj = new com.kascend.chushou.player.e.a();
            }
            this.mLj.b = str;
            this.mLj.mNY.copy(pkNotifyInfo);
            if (this.mLj.mNY.mAction == 6) {
                this.mLj.mNY.mInPKMode = true;
                this.u = this.mLj.mNY.mPkId;
            } else if (this.mLj.mNY.mAction == 7 || (this.mLj.mNY.mMode == 1 && this.mLj.mNY.mAction == 5)) {
                this.mLj.mNY.mInPKMode = true;
                this.u = this.mLj.mNY.mPkId;
                if (dFB() != null) {
                    if (2 == this.bB && this.mMK != null) {
                        this.mMK.setVisibility(0);
                    }
                    dFB().b(this.mLj.mNY, false);
                    dFB().a(this.mLj.mNY.mMode, "1");
                    if (this.mLj.mNY.mAction == 5 && this.mLj.mNY.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mLj.mNY.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mLj.mNY.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mLj.mNY.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mLj.mNY.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mLj.mNY.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dFB().a(this.mLj.mNY);
                        if (this.mLj.mNY.destinyInfo == null || this.mLj.mNY.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dFB().a(parseInt, this.mLj.mNY.mPkUpdateInfo.remainDuration, j, this.mLj.mNY.mMode, i);
                    }
                    if (!h.isEmpty(this.mLj.mNY.mPkUpdateInfo.specialMomentList) && dFB() != null) {
                        dFB().a(this.mLj.mNY, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Qy(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mLj.mNY.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Qy(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.mLj != null && this.mLj.mNY != null) {
            if (this.mLj.mNY.mInPKMode) {
                this.y.setText(this.mLj.mNY.mPkUserNickname);
                this.mLl.setVisibility(0);
                if (this.mRz != null) {
                    this.mRz.setEnabled(false);
                }
                if (this.mRB != null) {
                    this.mRB.setEnabled(false);
                    return;
                }
                return;
            }
            this.mLl.setVisibility(8);
            if (this.mRz != null) {
                this.mRz.setEnabled(true);
            }
            if (this.mRB != null) {
                this.mRB.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dFB() {
        if (this.mRJ == null || this.mRt == null || this.mMK == null) {
            return null;
        }
        if (this.mLk == null) {
            if (this.mMJ == null) {
                this.mMJ = ((ViewStub) this.mRt.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mLk = new com.kascend.chushou.player.e.b();
            this.mLk.a(this.mMK, this.mMJ, (View) null, this.mRJ, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dRD()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mRI != null) {
                        append.append(a.this.mRI.dFc().mRoomID);
                    }
                    if (a.this.mLj != null && a.this.mLj.mNY != null) {
                        append.append("&mode=").append(a.this.mLj.mNY.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mRJ, append.toString());
                }
            });
        }
        return this.mLk;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mMh != null && this.mRI != null && this.mRI.mKR != null) {
            this.mMh.setText(tv.chushou.zues.utils.b.KA(this.mRI.mKR.count));
            this.mMh.setVisibility(0);
            if (this.mRI.mKR.count < 1) {
                bg();
            }
            if (this.mLZ != null) {
                this.mLZ.setText(this.mRI.mKR.primaryName);
            }
            if (this.mMa != null) {
                this.mMa.setText(this.mRI.mKR.desc);
            }
            dFC();
        }
    }

    public void dFC() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mMi * h.parseLong(this.mRI.mKR.point)));
        if (this.mMc != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mRJ.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mRJ, a.e.icon_coin_new);
            cVar.append(this.mRJ.getString(a.i.str_buy_count_coin2));
            this.mMc.setText(cVar);
        }
    }

    private void bf() {
        if (com.kascend.chushou.d.e.c(this.mRJ, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mMi);
        }
    }

    private void v(boolean z) {
        if (this.mRt != null && this.mMK != null) {
            if (z) {
                if (this.mLj != null && this.mLj.mNY != null && this.mLj.mNY.mInPKMode) {
                    this.mMK.setVisibility(0);
                    return;
                }
                return;
            }
            this.mMK.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mRt != null && this.mLo != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.mLo.setVisibility(0);
                    return;
                }
                return;
            }
            this.mLo.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.mLj != null && this.mLj.mNY != null && this.mLj.mNY.mInPKMode && this.mLl != null) {
                this.mLl.setVisibility(0);
            }
        } else if (this.mLl != null) {
            this.mLl.setVisibility(8);
        }
    }

    private void bg() {
        this.mMj = false;
        this.mMg.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mRI != null && this.mRI.mKR != null) {
            if (this.mRI.mKR.count < 1) {
                this.mMh.setVisibility(8);
            } else {
                this.mMh.setVisibility(0);
                this.mMh.setSelected(false);
                this.mMh.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mLY.setVisibility(8);
        if (this.mLW != null) {
            this.mLW.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mLU != null) {
            this.mLU.performClick();
        }
    }

    public boolean dFD() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.mMV = true;
        if (this.mRt != null && com.kascend.chushou.b.dEg().d == 0) {
            this.mMF = tv.chushou.zues.utils.systemBar.b.gA(getActivity());
            if (!z) {
                View findViewById = this.mRt.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.mMF = tv.chushou.zues.utils.systemBar.b.gA(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.mMF);
            View findViewById2 = this.mRt.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.mMF);
            findViewById2.requestLayout();
        }
    }
}
