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
    private ImageView nKA;
    private ImageButton nKB;
    public String nKC;
    private RecommendView nKD;
    private TextView nKG;
    private RelativeLayout nKH;
    private TextView nKI;
    private TextView nKJ;
    private boolean nKK;
    private RelativeLayout nKL;
    private View nKM;
    private FrescoThumbnailView nKN;
    private AnimationSet nKO;
    private ImageView nKP;
    private TextView nKQ;
    private RelativeLayout nKR;
    private PastedEditText nKS;
    private TextView nKT;
    private LinearLayout nKU;
    private TextView nKV;
    private TextView nKW;
    private TextView nKX;
    private TextView nKY;
    private TextView nKZ;
    private int[] nKr;
    private Fragment[] nKs;
    private ImageView nKw;
    private MarqueeTextView nKx;
    private MarqueeTextView nKy;
    private ImageView nKz;
    private com.kascend.chushou.player.b.a nLA;
    private Runnable nLE;
    private View nLG;
    private LivePKBarUserValue nLH;
    private String nLI;
    private TextView nLJ;
    private ImageView nLK;
    private EditText nLL;
    private View nLM;
    private View nLN;
    private View nLO;
    private String nLS;
    private TextView nLa;
    private TextView nLb;
    private ImageView nLc;
    private TextView nLd;
    private KPSwitchPanelLinearLayout nLg;
    private ImageView nLh;
    private c nLi;
    private d.a nLj;
    private FrescoThumbnailView nLk;
    private PagerSlidingTabStrip nLl;
    private KasViewPager nLm;
    private LinearLayout nLn;
    private f nLp;
    private ViewMicPerson nLq;
    public ArrayList<RoomTab> nLs;
    private PopH5Menu nLu;
    private InteractionView nLv;
    private int nLw;
    private PopupWindow nLx;
    private TextView nLy;
    private GiftAnimationLayout nLz;
    private long nKl = 0;
    private com.kascend.chushou.view.user.a nKt = null;
    private com.kascend.chushou.player.ui.a nKu = null;
    private int bB = -1;
    private int bC = 0;
    private View nKv = null;
    private View nKE = null;
    private ImageButton nKF = null;
    private int nLe = 1;
    private boolean nLf = false;
    private boolean cp = false;
    private boolean nLo = false;
    private boolean cx = false;
    private boolean nLr = false;
    private boolean nLt = false;
    private boolean cC = true;
    private int nLB = 0;
    private int nLC = 0;
    private int nLD = -1;
    private final Rect nLF = new Rect();
    private boolean nLP = false;
    private C0888a nLQ = null;
    private boolean nLR = false;
    private boolean nLT = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nKC = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nQo = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.nQo;
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
        this.nLt = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.nRj != null) {
            this.nRj.b();
        }
        if (this.nQD != null && (this.nQD instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQD).yu(true);
            ((VideoPlayer) this.nQD).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nLt = true;
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
        this.nLe = 1;
        this.nLf = false;
        U();
        if (this.nQE != null) {
            this.nQE.cl(null);
            this.nQE = null;
        }
        if (this.nKD != null) {
            eaj().removeAllViews();
            this.nKD = null;
        }
        this.c = null;
        this.nJZ = null;
        tv.chushou.zues.a.a.cm(this);
        this.nLl = null;
        this.nLm = null;
        this.nKu = null;
        this.nKt = null;
        if (this.nKs != null) {
            for (int i = 0; i < this.nKs.length; i++) {
                this.nKs[i] = null;
            }
        }
        this.nKs = null;
        if (this.nKS != null) {
            this.nKS.addTextChangedListener(null);
            this.nKS.setOnTouchListener(null);
            this.nKS.setOnEditorActionListener(null);
            this.nKS = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nQD, this.nLi);
        if (this.nQD != null && (this.nQD instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQD).dYQ();
        }
        this.nLj = null;
        this.nLi = null;
        if (this.nLq != null) {
            this.nLq.b();
            this.nLq = null;
        }
        if (this.nLx != null) {
            this.nLx.dismiss();
        }
        if (this.nLA != null) {
            this.nLA.a();
            this.nLA = null;
            this.nLz = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.nLH = (LivePKBarUserValue) this.nQo.findViewById(a.f.live_pk_bar_user);
        this.nQw = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nLP) {
            this.nLP = true;
            if (this.nLN == null) {
                this.nLN = this.nQo.findViewById(a.f.vs_async_view);
                this.nLN = ((ViewStub) this.nLN).inflate();
            }
            if (this.nLO == null) {
                this.nLO = this.nQo.findViewById(a.f.vs_async_notification_view);
                this.nLO = ((ViewStub) this.nLO).inflate();
            }
            this.nKk = (VoiceInteractionView) this.nQo.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.nQo);
            dMM();
            ((VideoPlayer) this.nQD).q();
            this.nKf = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.nLk = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.nLl = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.nLm = (KasViewPager) view.findViewById(a.f.vp_main);
        dZx();
        aI();
        dZB();
        if (this.nQC != null) {
            I();
            a(this.nQC.nJL, this.nQC.nJO);
        }
        this.bb = 0;
        this.nRo = 0L;
        this.nRk = (RoundProgressBar) this.nQo.findViewById(a.f.roundProgressBar);
        this.nRl = (TextView) this.nQo.findViewById(a.f.tv_paonum);
        this.nRm = (FrescoThumbnailView) this.nQo.findViewById(a.f.iv_paoicon);
        this.nRt = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.nLo = false;
                if (a.this.bB == 2) {
                    a.this.aD(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.nLw, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.nLo = true;
                if (a.this.bB == 2) {
                    a.this.aD(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.nRj != null) {
                    a.this.nRj.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gW(a.this.nQD).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nQD)) - a.this.nRj.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nQD, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nQD, 54.0f) * 2);
                    if (statusBarHeight < a.this.nLw) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.nRn = (PaoGuideView) this.nQo.findViewById(a.f.rlPaoGuideView);
        this.nLq = (ViewMicPerson) this.nQo.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.nMV = ((VideoPlayer) this.nQD).dYJ();
        this.nQC = ((VideoPlayer) this.nQD).dYM();
        e(this.nQo);
        this.nLB = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
        this.nLC = tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        if (com.kascend.chushou.b.dYs().d == 0 && this.nLC > 0) {
            View findViewById = this.nQo.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nLC);
        }
        dZG();
        dZE();
        if (!this.cC) {
            Q();
        }
        dZC();
        a();
        if (this.c == null) {
            this.nJZ = new d.a();
            this.c = new GestureDetector(this.nQD, this.nJZ);
        }
        this.nKb = ((VideoPlayer) this.nQD).dYN();
        this.nKb.a(this);
        if (this.nLA != null) {
            this.nLA.a();
            this.nLA = null;
        }
        this.nLz = (GiftAnimationLayout) this.nQo.findViewById(a.f.ll_gift_animation);
        this.nLz.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.nQC != null) {
            this.nLA = new com.kascend.chushou.player.b.a(this.nQD.getApplicationContext(), this.nLz);
            this.nLA.a(this.nQC);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.nQo.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nQx = (PlayerErrorView) this.nQo.findViewById(a.f.view_net_error_msg);
        this.nQx.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        dZJ();
        if (this.nQC.dZm() != null) {
            a(this.nQC.dZm());
        }
        FullRoomInfo dZl = this.nQC.dZl();
        if (dZl != null) {
            dZN();
            if (i()) {
                this.ak = false;
                yy(true);
                this.nQE.Ow(8);
            }
            this.nKG.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dZl.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.nQp != null) {
            this.nQp.setVisibility(0);
        }
        this.nKv.setVisibility(0);
        this.ak = false;
        yy(true);
        this.nQE.Ow(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nQD).n();
        if (this.nQC != null && !h.isEmpty(this.nQC.w)) {
            b(this.nQC.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dYX;
        dZx();
        k();
        FullRoomInfo dZl = this.nQC.dZl();
        if (dZl != null) {
            if (dZl.mRoominfo != null) {
                this.nKG.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dZl.mRoominfo.mOnlineCount)));
                this.nLI = dZl.mRoominfo.mRoomID;
            }
            dZN();
            if (!h.isEmpty(dZl.mRoomToastList)) {
                Iterator<RoomToast> it = dZl.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dYA().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.nQC != null && this.nQC.l()) {
                d(true);
            }
            if (this.nQD != null && (this.nQD instanceof VideoPlayer) && (dYX = ((VideoPlayer) this.nQD).dYX()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dYX.nMW, dYX.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.nLn);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dZx() {
        boolean z = true;
        if (this.nQC == null || this.nQC.dZl() == null || this.nQC.dZl().mRoominfo == null || h.isEmpty(this.nQC.dZl().mRoomTabs)) {
            this.nLr = false;
            this.nKs = new Fragment[2];
            this.nKr = new int[2];
            this.nKr[0] = 2;
            this.nKr[1] = 1;
            return;
        }
        this.nLr = true;
        this.nLs = new ArrayList<>();
        Iterator<RoomTab> it = this.nQC.dZl().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.nLs.add(next);
            }
        }
        if (this.nLs.size() >= 2 && this.nKr != null && this.nKr.length >= 2 && this.nLs.get(0).type == this.nKr[0] && this.nLs.get(1).type == this.nKr[1]) {
            z = false;
        }
        this.nKs = new Fragment[this.nLs.size()];
        this.nKr = new int[this.nLs.size()];
        for (int i = 0; i < this.nLs.size(); i++) {
            this.nKr[i] = this.nLs.get(i).type;
        }
        if (z) {
            this.nLQ = new C0888a(getChildFragmentManager());
            this.nLm.setAdapter(this.nLQ);
        }
    }

    private void aI() {
        this.nKR = (RelativeLayout) this.nQo.findViewById(a.f.rl_edit_bar);
        this.nKN = (FrescoThumbnailView) this.nQo.findViewById(a.f.btn_hotword);
        this.nKN.Ck(a.e.ic_hotwords_black_n);
        this.nKN.setOnClickListener(this);
        this.nKP = (ImageView) this.nQo.findViewById(a.f.iv_task_badge);
        this.nKO = (AnimationSet) AnimationUtils.loadAnimation(this.nQD, a.C0882a.anim_hotword);
        this.nKO.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dYA().c) {
                    a.this.nKN.clearAnimation();
                    a.this.nKN.startAnimation(a.this.nKO);
                }
            }
        });
        if (com.kascend.chushou.d.h.dYA().c) {
            this.nKN.startAnimation(this.nKO);
            this.nKP.setVisibility(0);
        }
        this.nKQ = (TextView) this.nQo.findViewById(a.f.tv_bottom_input);
        this.nKQ.setOnClickListener(this);
        this.nRE = (FrescoThumbnailView) this.nQo.findViewById(a.f.ll_btn_set);
        this.nRE.setOnClickListener(this);
        this.nLn = (LinearLayout) this.nQo.findViewById(a.f.ll_bottom_all_button);
        this.nKL = (RelativeLayout) this.nQo.findViewById(a.f.rl_bottom_input);
        this.nKM = this.nQo.findViewById(a.f.ll_bottom_input);
        this.nKL.setVisibility(8);
        this.nKS = (PastedEditText) this.nQo.findViewById(a.f.et_bottom_input);
        this.nKS.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nKT.setEnabled(editable.length() > 0);
            }
        });
        this.nKS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nKT);
                    return true;
                }
                return true;
            }
        });
        this.nKS.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.nKS);
                }
                return false;
            }
        });
        this.nLh = (ImageView) this.nQo.findViewById(a.f.iv_btn_emoji);
        this.nLh.setVisibility(8);
        this.nKT = (TextView) this.nQo.findViewById(a.f.tv_btn_send);
        this.nKT.setOnClickListener(this);
        this.nLg = (KPSwitchPanelLinearLayout) this.nQo.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dYs().d == 0) {
            this.nLg.setUseStatusBar(true);
        }
        this.nKU = (LinearLayout) this.nQo.findViewById(a.f.head_trumpet);
        this.nKU.setVisibility(8);
        this.nKU.setOnClickListener(this);
        this.nKV = (TextView) this.nQo.findViewById(a.f.tv_primary_name);
        this.nKW = (TextView) this.nQo.findViewById(a.f.tv_primary_desc);
        this.nKZ = (TextView) this.nQo.findViewById(a.f.tv_cut_count);
        this.nKZ.setOnClickListener(this);
        this.nLb = (TextView) this.nQo.findViewById(a.f.tv_head_count);
        this.nLb.setText(this.nLe + "");
        this.nLa = (TextView) this.nQo.findViewById(a.f.tv_plus_count);
        this.nLa.setOnClickListener(this);
        this.nKY = (TextView) this.nQo.findViewById(a.f.tv_buy_count_coin);
        this.nKX = (TextView) this.nQo.findViewById(a.f.tv_buy_head);
        this.nKX.setOnClickListener(this);
        this.nLc = (ImageView) this.nQo.findViewById(a.f.iv_trumpet_select);
        this.nLc.setOnClickListener(this);
        this.nLd = (TextView) this.nQo.findViewById(a.f.tv_trumpet_have_count);
        this.nLf = false;
        this.nLc.setBackgroundResource(a.e.ic_trumpet_n);
        this.nLd.setVisibility(8);
        dZz();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nLg, this.nLh, this.nKS, new a.InterfaceC1018a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1018a
            public void yv(boolean z) {
                if (a.this.nLh != null) {
                    if (!z) {
                        a.this.nLh.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dYs().d == 0) {
                        a.this.nLg.setDirectVisibility(0);
                    }
                    a.this.nLh.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nLj = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void yw(boolean z) {
                if (a.this.nLT) {
                    a.this.nLT = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.nLh.setImageResource(a.e.cs_emoji_normal);
                    a.this.dZy();
                    return;
                }
                if (a.this.nLM != null && a.this.nLM.getVisibility() == 0) {
                    a.this.nLM.setVisibility(8);
                }
                if (a.this.nLo) {
                    a.this.nRj.setVisibility(0);
                }
                if (a.this.nQD != null && (a.this.nQD instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nQD).yu(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.nLi = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nLg, this.nLj, ((VideoPlayer) this.nQD).dYR());
        ((VideoPlayer) this.nQD).h(((VideoPlayer) this.nQD).dYR());
        this.nLM = this.nQo.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nLJ = (TextView) this.nQo.findViewById(a.f.btn_room_search);
        this.nLK = (ImageView) this.nQo.findViewById(a.f.iv_room_emoji_delete);
        this.nLL = (EditText) this.nQo.findViewById(a.f.et_room_emoji_search);
        this.nLL.setImeOptions(3);
        this.nLL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.nLJ);
                    return true;
                }
                return false;
            }
        });
        this.nLL.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nLJ.setEnabled(editable.length() > 0);
                a.this.nLK.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.nRj.setEmojiSearchText(editable.toString());
            }
        });
        this.nLJ.setOnClickListener(this);
        this.nLK.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aB(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dM(this.nLL);
            this.nLM.setVisibility(0);
            this.nLL.requestFocus();
        } else {
            this.nLM.setVisibility(8);
        }
        if (z2) {
            this.nLL.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZy() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gW(this.nQD).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD)) - tv.chushou.zues.widget.kpswitch.b.d.hi(this.nQD)) - tv.chushou.zues.utils.a.dip2px(this.nQD, 14.0f)) - this.nQD.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nQD, 54.0f) * 2);
        if (statusBarHeight < this.nLw) {
            b(statusBarHeight, 10);
        }
    }

    private void dZz() {
    }

    private void aL() {
        this.nQE = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aC(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.nQo.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nQD.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nQE.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nQE.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nQE.B(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nQE);
                            break;
                        case 12:
                            a.this.b(a.this.nQE);
                            break;
                        case 17:
                            a.this.eal();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.nQB.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dZA() {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nLs)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nLs.size()) {
                    if (!h.isEmpty(this.nLs.get(i2).notifyIcon)) {
                        this.nLl.bK(i2, this.nLs.get(i2).notifyIcon);
                        this.nLl.OV(i2);
                    } else if (this.nLs.get(i2).notify == 1) {
                        this.nLl.OU(i2);
                        this.nLl.OT(i2);
                    } else {
                        this.nLl.OT(i2);
                        this.nLl.OV(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nLs)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.nLs.size()) {
                    if (this.nLs.get(i4).type == i) {
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
    public String Nd(int i) {
        if (this.nQC == null || this.nQC.dZl() == null || this.nQC.dZl().mRoominfo == null || h.isEmpty(this.nLs)) {
            if (i == 1) {
                return this.nQD.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nQD.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.nLs.size()) {
            return this.nLs.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nLs) && i < this.nLs.size()) {
            this.nLs.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nLs) && i < this.nLs.size()) {
            this.nLs.get(i).notifyIcon = str;
        }
    }

    private void dZB() {
        if (this.nLm != null && this.nLl != null && this.nKr != null) {
            this.nKu = null;
            if (this.nKs != null) {
                for (int i = 0; i < this.nKs.length; i++) {
                    this.nKs[i] = null;
                }
            }
            if (this.nLQ == null) {
                this.nLQ = new C0888a(getChildFragmentManager());
                this.nLm.setAdapter(this.nLQ);
            } else {
                this.nLQ.notifyDataSetChanged();
            }
            this.nLm.setOffscreenPageLimit(this.nKr.length);
            this.nLl.c(this.nLm);
            this.nLl.setOnPageChangeListener(this);
            this.nLl.notifyDataSetChanged();
            this.nLl.setVisibility(0);
            this.nLm.setVisibility(0);
            if (!this.nLr) {
                this.bB = 2;
                this.nLm.setCurrentItem(c(2, 0));
                this.nKL.setVisibility(0);
            } else {
                if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                    if (!h.isEmpty(this.nQC.dZl().mRoominfo.mGameName)) {
                        this.nKy.setText(this.nQC.dZl().mRoominfo.mGameName);
                    } else {
                        this.nKy.setText(this.nQD.getString(a.i.no_online_game_name));
                    }
                    this.nKx.setText(this.nQC.dZl().mRoominfo.mName);
                } else {
                    this.nKy.setText(this.nQD.getString(a.i.no_online_game_name));
                }
                dZA();
                if (i()) {
                    dZK();
                    if (this.nLm != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.nLm.setCurrentItem(c);
                        this.nLl.setSelectItem(c);
                    }
                } else if (this.nLm != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.nLm.setCurrentItem(c2);
                    this.nLl.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dZC() {
        this.nQp = new SurfaceView(this.nQD);
        SurfaceView surfaceView = (SurfaceView) this.nQp;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        eaj().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dZD() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nQD).s();
        dMR();
        dZH();
        dZw();
        eaj().setBackgroundResource(a.e.room_not_online);
        if (this.nKD == null) {
            this.nKD = new RecommendView(this.nQD);
            eaj().addView(this.nKD);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nQD);
            this.nKD.setLayoutParams(layoutParams);
        }
        if (this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nQC.dZl().mRoominfo.mRoomID)) {
            this.nKD.a(this.nQC.dZl().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.nQD != null && a.this.eaj() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nQD);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.npI);
                        if (a.this.eaj().getChildCount() >= 2) {
                            a.this.eaj().addView(frescoThumbnailView, 0);
                        }
                        a.this.eaj().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.emi(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.nQp != null) {
            this.nQp.setVisibility(8);
        }
        if (this.nRr != null) {
            this.nRr.elE();
            this.nRr.setVisibility(8);
        }
        l(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.nRj != null) {
            this.nRj.e();
        }
        yy(false);
        a(false, false);
        if (this.nKb != null) {
            this.nKb.d();
        }
    }

    private void dZE() {
        int i = 0;
        this.nKv = this.nQo.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dYs().d == 0 && this.nLB > 0) {
            View findViewById = this.nQo.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.nLB;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nKw = (ImageView) this.nKv.findViewById(a.f.back_icon);
        this.nKw.setOnClickListener(this);
        this.nKx = (MarqueeTextView) this.nKv.findViewById(a.f.tv_title);
        this.nKy = (MarqueeTextView) this.nKv.findViewById(a.f.tv_Type);
        this.nKA = (ImageView) this.nQo.findViewById(a.f.btn_setting);
        this.nKE = this.nQo.findViewById(a.f.bottomview);
        if (this.nQu == null) {
            this.nQu = (ImageButton) this.nKE.findViewById(a.f.btn_barrage);
            this.nQu.setOnClickListener(this);
            if (this.nQC != null) {
                if (com.kascend.chushou.d.h.dYA().n()) {
                    this.nQu.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nQu.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.nQv = (ImageButton) this.nKE.findViewById(a.f.btn_audio);
        this.nQv.setOnClickListener(this);
        if (this.nQC != null && this.nQC.d) {
            this.nQv.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.nQv.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.nQC != null && this.nQC.f != null) {
            while (true) {
                if (i >= this.nQC.f.size()) {
                    break;
                } else if (!"2".equals(this.nQC.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nKF = (ImageButton) this.nKE.findViewById(a.f.playbutton);
        this.nKF.setOnTouchListener(this);
        this.nKB = (ImageButton) this.nKE.findViewById(a.f.btn_refresh);
        this.nKB.setOnClickListener(this);
        this.nKG = (TextView) this.nKE.findViewById(a.f.tv_online_count);
        if (this.nQt == null) {
            this.nQt = (ImageButton) this.nKE.findViewById(a.f.btn_screenChange);
            this.nQt.setOnClickListener(this);
        }
        if (this.nKz == null) {
            this.nKz = (ImageView) this.nKv.findViewById(a.f.report_icon);
            this.nKz.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dC(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nKu != null) {
                        this.nKu.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                        this.nQC.dZl().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nQC.dZl().mMicStatus.onMic) {
                            dZM();
                        }
                        if (this.nQC.dZl().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.nQC.dZl().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.nQC.dZl().mRoominfo.mCreatorUID);
                            }
                        } else if (this.nQC.dZl().mMicStatus.onMic) {
                            this.nQC.dZl().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nQC.dZl().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.nQC.dZl().mFanItems, str);
                            }
                            this.nLR = z2;
                            if (this.nQC.dZl().mMicStatus != null && !h.isEmpty(this.nQC.dZl().mMicStatus.micRoomId) && !this.nQC.dZl().mMicStatus.micRoomId.equals("0")) {
                                this.nLS = this.nQC.dZl().mMicStatus.micRoomId;
                            }
                            if (this.nKu != null) {
                                this.nKu.a(this.nQC.dZl().mMicStatus, this.nQC.dZl().mFanItems, str, z2);
                            }
                            if (this.nLq != null && this.nLq.getVisibility() == 0) {
                                this.nLq.a(this.nQC.dZl().mFanItems, this.nQC.dZl().mMicStatus, str, z2, this.nQC.dZl().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nKu != null) {
                                this.nKu.e();
                            }
                            if (this.nLq != null && this.nLq.isShown()) {
                                this.nLq.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nKu != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nKu.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nKu.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.nLD != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.nLD = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nKf != null && this.nKf.nMW != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nKf.nMW.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nKf.nMW.mInPKMode = true;
                                    this.nKf.nMW.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nKf.nMW.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nKf.nMW.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nKf.nMW.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nKf.nMW.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nKf.nMW.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nKf.nMW.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nKf.nMW.mMode = pkNotifyInfo.mMode;
                                    this.nKf.nMW.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dZT() != null) {
                                        dZT().g(true, this.nKf.nMW.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dYA().a) {
                                        if (!com.kascend.chushou.b.dYs().e) {
                                            com.kascend.chushou.b.dYs().e = true;
                                            g.H(this.nQD, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dYA().a(this.nQD, false);
                                        dZL();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.nLH != null) {
                                        this.nLH.setVisibility(0);
                                    }
                                    this.nKf.nMW.mAction = 7;
                                    this.nKf.nMW.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nKf.nMW.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nKf.nMW.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nKf.nMW.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nKf.nMW.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nKf.nMW.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dZS();
                                    if (dZT() != null) {
                                        dZT().g(false, 0L);
                                        dZT().b(this.nKf.nMW, true);
                                        dZT().a(this.nKf.nMW.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Va(this.nLI);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.nKf.nMW.mInPKMode = false;
                                    this.nKf.nMW.mAction = 2;
                                    dZS();
                                    if (dZT() != null) {
                                        dZT().c();
                                    }
                                    if (com.kascend.chushou.d.h.dYA().a) {
                                        if (!com.kascend.chushou.b.dYs().e) {
                                            com.kascend.chushou.b.dYs().e = true;
                                            g.H(this.nQD, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dYA().a(this.nQD, false);
                                        dZL();
                                    }
                                    this.nKf.b = null;
                                    this.nKf.nMW = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Va(this.nLI);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nKf.nMW.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nKf.nMW.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.nKf.nMW.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nQC.dZl().mRoominfo.mRoomID) && this.nQC.dZl().mRoominfo.mRoomID.equals(this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dZT() != null) {
                                        dZT().a(this.nKf.nMW, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nKf.nMW.copyUpdate(pkNotifyInfo);
                                    if (dZT() != null) {
                                        dZT().a(this.nKf.nMW);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nKf.nMW.copyStop(pkNotifyInfo);
                                        if (dZT() != null) {
                                            dZT().B(this.nKf.nMW.mMaxFreeDuration, this.nKf.nMW.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nKf.nMW.copyResult(pkNotifyInfo);
                                    if (!this.nLt && dZT() != null) {
                                        int i5 = 1;
                                        if (this.nKf.nMW.destinyInfo != null && this.nKf.nMW.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dZT().a(h.parseInt(this.nKf.nMW.mResult), h.parseLong(this.nKf.nMW.mvpUid), this.nKf.nMW.mvpAvatar, this.nKf.nMW.mvpNickname, this.nKf.nMW.mMaxFreeDuration, this.nKf.nMW.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nKu != null) {
                if (LoginManager.Instance().islogined() && this.nQC != null && this.nQC.l()) {
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
                if (this.nQC == null || this.nQC.dZl() == null || this.nQC.dZl().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.nQC.dZl().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dYA().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dYA().b().equals(next2.mUserID)) {
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
                this.nKu.a(arrayList, true, false);
                this.nKu.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nKr != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nKr.length) {
                    break;
                }
                if (this.nKr[i2] == 99 && this.nKs != null && this.nKs[i2] != null && (this.nKs[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nKs[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.nLs.size() && this.nLl != null) {
                if (i == 0) {
                    this.nLl.setTagText(i2, new StringBuilder(this.nLs.get(i2).name).toString());
                    return;
                } else {
                    this.nLl.setTagText(i2, this.nLs.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.nQu != null) {
            if (z) {
                this.nQu.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nQu.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dZF() {
        if (this.nQo == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nQo.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
        this.ar = Math.min(gW.x, gW.y);
        this.aq = (this.ar * this.nQD.getResources().getInteger(a.g.h_thumb_height_def)) / this.nQD.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = eaj().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nQw.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nLw = this.aq + this.nQD.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nQD, 54.0f);
        b(this.nLw, 10);
        if (this.nQp != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.nQp).setLayoutParams(layoutParams3);
        }
    }

    private void dZG() {
        Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
        this.ar = Math.min(gW.x, gW.y);
        this.aq = (this.ar * this.nQD.getResources().getInteger(a.g.h_thumb_height_def)) / this.nQD.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = eaj().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nQw.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nLw = this.aq + this.nQD.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nQD, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.nLw, 10);
        k();
        if (!h.isEmpty(this.nKC)) {
            File af = tv.chushou.zues.widget.fresco.a.af(Uri.parse(this.nKC));
            if (af != null && af.exists()) {
                this.nQw.setImageURI(Uri.fromFile(af));
                this.nQw.setVisibility(0);
                return;
            }
            this.nQw.setVisibility(8);
            return;
        }
        this.nQw.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aC(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nKz != null) {
            this.nKz.setVisibility(z ? 0 : 4);
        }
        if (this.nKA != null) {
            this.nKA.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aC(boolean z, boolean z2) {
        return l(z, z2, this.f);
    }

    public boolean l(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.nQE != null) {
            this.nQE.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nQD).f(true);
            if (!z3) {
                if (this.nKE.getVisibility() != 0 && z2) {
                    this.nKE.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.nQv.setVisibility(0);
                } else {
                    this.nQv.setVisibility(8);
                }
                this.nKE.setVisibility(0);
            }
            PlayUrl dZm = this.nQC.dZm();
            if (dZm != null && "2".equals(dZm.mType)) {
                if (this.nQt != null) {
                    this.nQt.setVisibility(8);
                }
            } else if (this.nQt != null) {
                this.nQt.setVisibility(0);
            }
            if (this.nKv.getVisibility() != 0 && z2) {
                this.nKv.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_top_anim));
            }
            t(!z3);
            this.nKv.setVisibility(0);
            w(true);
            if (this.nQE != null) {
                this.nQE.B(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nQD).f(false);
            if (this.nQW != null) {
                this.nQW.dismiss();
            }
            if (this.nQX != null) {
                this.nQX.dismiss();
            }
            if (this.nKE.getVisibility() != 8 && z2) {
                this.nKE.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_bottom_anim));
            }
            this.nKE.setVisibility(8);
            if (this.nKv.getVisibility() != 8 && z2) {
                this.nKv.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_top_anim));
            }
            this.nKv.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dMR() {
        if (this.nRn == null || !this.nRn.isShown()) {
            return false;
        }
        this.nRn.d();
        return true;
    }

    public boolean dZH() {
        if (this.nLq == null || !this.nLq.isShown()) {
            return false;
        }
        this.nLq.a();
        return true;
    }

    public boolean dZw() {
        if (this.nLu == null || !this.nLu.b()) {
            return false;
        }
        this.nLu.a();
        return true;
    }

    public boolean dZI() {
        if (this.nLo && this.nRj != null) {
            if (this.nRj != null) {
                this.nRj.e();
            }
            if (this.nLL != null) {
                this.nLL.setText("");
            }
            if (this.bB == 2) {
                aD(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nQo != null) {
            if (this.nLu == null) {
                this.nLu = (PopH5Menu) ((ViewStub) this.nQo.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.nLu.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.nLu.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.nKv.getHeight() + this.nKv.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nQD, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                g.c(this.nQD, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.nQC.a(false);
                a(false, false);
                ((VideoPlayer) this.nQD).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.nQD, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.nKf == null || this.nKf.nMW == null || !this.nKf.nMW.mInPKMode) {
                ((VideoPlayer) this.nQD).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nLf) {
                f(this.nKS.getText().toString());
            } else {
                a(this.nKS.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dYA().c) {
                com.kascend.chushou.d.h.dYA().b(false);
                this.nKO.cancel();
                this.nKO.reset();
                this.nKN.clearAnimation();
                this.nKP.setVisibility(8);
            }
            n(view, 0, this.nQo.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nQD, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.nQo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.nQC.d) {
                dMF();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nQD, null) && this.nQC != null && this.nQC.nJN != null) {
                if (this.nLf) {
                    dZW();
                    return;
                }
                if (this.nQC != null && this.nQC.nJN != null && this.nQC.nJN.count > 0) {
                    this.nKU.setVisibility(8);
                } else {
                    this.nKU.setVisibility(0);
                }
                this.nLf = true;
                this.nLc.setBackgroundResource(a.e.ic_trumpet_p);
                this.nLd.setVisibility(0);
                this.nLd.setSelected(true);
                this.nLd.setTextColor(Color.parseColor("#ff5959"));
                if (this.nKS != null) {
                    this.nKS.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nLe <= 9) {
                this.nLe++;
                this.nLb.setText(this.nLe + "");
            }
            dZU();
        } else if (id == a.f.tv_cut_count) {
            if (this.nLe > 1) {
                this.nLe--;
                this.nLb.setText(this.nLe + "");
            }
            dZU();
        } else if (id == a.f.tv_buy_head) {
            dZV();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.nLL.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.nLL.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dN(this.nLL);
                this.nRj.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nKS != null && this.nKL != null && this.nKR != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.nKS);
                this.nKL.setVisibility(8);
                if (this.bB == 2) {
                    this.nKR.setVisibility(0);
                }
            }
        } else if (this.nKL != null && this.nKR != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
            if (this.bB == 2) {
                this.nKL.setVisibility(0);
            }
            this.nKR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dYA().c(roomToast.mToastContent);
            if (this.nLx == null) {
                aS();
            }
            if (this.nLy != null) {
                this.nLy.setText(roomToast.mToastContent);
            }
            if (!this.nLx.isShowing()) {
                if (this.nLn != null) {
                    this.nLx.showAtLocation(this.nLn, 85, 0, this.nQo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
                    RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.nLx != null) {
                                a.this.nLx.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nLx.dismiss();
        }
    }

    private void aS() {
        if (this.nLx == null) {
            View inflate = LayoutInflater.from(this.nQD).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nLy = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nLx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 160.0f), -2);
            this.nLx.setFocusable(false);
            this.nLx.setOutsideTouchable(false);
            this.nLx.setAnimationStyle(a.j.gift_toast_style);
            this.nLx.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.nRe != null && this.nRe.isShowing()) {
            this.nRe.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
        if (this.nRB == null) {
            eam();
        }
        if (!this.nRB.isShowing()) {
            this.nRB.showAtLocation(view, 83, i, i2);
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nQC.dZl().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nRB.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.nRE != null) {
            if (h.isEmpty(this.nRF)) {
                if (((VideoPlayer) this.nQD).q) {
                    this.nRE.bX(this.nQC != null ? this.nQC.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.nRE.bX(this.nQC != null ? this.nQC.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nQD).q && this.nRF.size() == 2 && this.nRF.contains("4") && this.nRF.contains("2")) {
                this.nRE.bX(this.nQC != null ? this.nQC.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.nRF.size() > 1 || !((VideoPlayer) this.nQD).q) {
                this.nRE.bX(this.nQC != null ? this.nQC.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.nRF.get(0))) {
                this.nRE.bX(this.nQC != null ? this.nQC.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.nRF.get(0))) {
                this.nRE.bX(this.nQC != null ? this.nQC.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.nRF.get(0))) {
                this.nRE.bX(this.nQC != null ? this.nQC.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
        if (this.nRe == null) {
            al();
            this.nRe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.nRe.isShowing() && this.bB == 2) {
            this.nRe.showAtLocation(view, 83, i, this.nQD.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nQC.dZl().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nRe.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nQw != null) {
            this.nQw.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                g.c(this.nQD, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nMV.getPlayState() == 4) {
                        e(true);
                        if (this.nQC.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.nQC.a(false);
                        ((VideoPlayer) this.nQD).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nMV.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nMV.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                g.c(this.nQD, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.nQC.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nQD).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                    this.ai = false;
                    yy(true);
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
        if (this.nRr != null) {
            if (z) {
                this.nRr.setVisibility(0);
            }
            this.nRr.elE();
            if (!z) {
                this.nRr.setVisibility(8);
            }
        }
        g.c(this.nQD, this.nQD.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nKF != null) {
                this.nKF.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nQx != null) {
                this.nQx.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nKF != null) {
            this.nKF.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nQx != null) {
                    this.nQx.setVisibility(8);
                }
            }
        }
    }

    private void dZJ() {
        this.e = false;
        l(true, false, true);
    }

    private void dZK() {
        this.e = false;
        l(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.nKr[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dZA();
            a(this.nQC != null ? this.nQC.nJO.get("1") : null);
            if (i2 == 2) {
                k();
                aD(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.nQD, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aD(false, i3);
            v(false);
            b(false);
            if (this.nRe != null && this.nRe.isShowing()) {
                this.nRe.dismiss();
            }
            if (i2 == 99) {
                if (this.nKs != null && this.nKs[i] != null && (this.nKs[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nKs[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nQD, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nQD, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nQD, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nQD, "房间信息页_num", null, new Object[0]);
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
    protected void dZL() {
        ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nQE != null) {
            if (this.nKR != null && this.nKR.getVisibility() == 0) {
                u(false);
            }
            if (this.nQx != null && this.nQx.getVisibility() == 0) {
                this.f = true;
            }
            aC(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nKu != null) {
            this.nKu.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nKu != null) {
            this.nKu.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nKu != null) {
            this.nKu.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nKu != null) {
            this.nKu.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nLn != null) {
            int size = iconConfig.configs.size();
            this.nLn.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nQD).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.nLn, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bX(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bX(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.bX(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.bX(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.bX(str, a.e.ic_default_video_bottom);
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
                    public void dC(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.nLn.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.nQC != null ? this.nQC.nJO : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nKu != null) {
            this.nKu.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nLk != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nLk.Ck(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nLk.bX(str, a.c.kas_white);
                if (this.nLl != null) {
                    this.nLl.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nLk.Ck(a.c.kas_white);
                if (this.nLl != null) {
                    this.nLl.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.nLl != null) {
                    this.nLl.setTextColor(a);
                    this.nLl.setTabTextSelectColor(a2);
                    this.nLl.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nKN != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nKN.Ck(a.e.ic_hotwords_black_n);
            } else {
                this.nKN.bX(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nKM != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.eaz().a(str, this.nKM, a.e.player_skin_input);
            } else {
                this.nKM.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nKQ != null) {
                this.nKQ.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nKu != null) {
            this.nKu.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQD instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dYS = ((VideoPlayer) this.nQD).dYS();
            if (this.nRv == null) {
                this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRv.setVisibility(0);
            this.nRv.a(2, dYS);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nKu != null) {
            this.nKu.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nKu != null) {
            this.nKu.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nKu != null) {
            this.nKu.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nKu != null) {
            this.nKu.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nKu != null && this.nQC != null) {
            this.nKu.b(this.nQC.nJM);
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
    public class C0888a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0888a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.nKr.length) {
                return null;
            }
            switch (a.this.nKr[i]) {
                case 1:
                    if (a.this.nKt == null) {
                        a.this.nKt = com.kascend.chushou.view.user.a.a(2, null, a.this.nQC.a, false, a.this.nQC.h, false);
                    }
                    a.this.nKs[i] = a.this.nKt;
                    return a.this.nKt;
                case 2:
                    if (a.this.nKu == null) {
                        a aVar = a.this;
                        if (a.this.nKf != null && a.this.nKf.nMW != null) {
                            z = a.this.nKf.nMW.mInPKMode;
                        }
                        aVar.nKu = com.kascend.chushou.player.ui.a.yz(z);
                    }
                    a.this.nKs[i] = a.this.nKu;
                    return a.this.nKu;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.nQC != null && a.this.nQC.dZl() != null && !h.isEmpty(a.this.nLs)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.nLs.get(i).url);
                        h5Options.a = a.this.nLs.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nKs[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Nd(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.nKr.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int oz(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Ne(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String Nf(int i) {
            return a.this.Nd(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Ng(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Nh(int i) {
            int dimensionPixelSize = a.this.nQD.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Gc(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.OF(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nKl <= IMConnection.RETRY_DELAY_TIMES) {
            g.OF(a.i.str_too_fast);
            return false;
        } else {
            dZO();
            if (!com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a(((VideoPlayer) this.nQD).dYM().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nKl = System.currentTimeMillis();
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                a(this.nQC.dZl().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nQC.h);
            }
            g(this.b);
            if (!z && this.nKS != null) {
                this.nKS.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dZO();
            if (com.kascend.chushou.d.e.c(this.nQD, null) && LoginManager.Instance().getUserInfo() != null && this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                a(this.nQC.dZl().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nKS != null) {
                this.nKS.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nKu != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nQC.dZl().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nQC.dZl().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nQD).nIc;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.WU(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.nKu.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nKu.a(arrayList, true, true);
        }
    }

    private void dZM() {
        if (this.nKu != null) {
            this.nKu.e();
        }
        if (this.nLq != null && this.nLq.isShown()) {
            this.nLq.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.nQD instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.nQC != null) {
            this.nQC.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dZM();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.nQD != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.nQD).t)) {
                this.cx = true;
                if (this.nQC != null) {
                    this.nQC.f = null;
                    if (this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                        this.nQC.dZl().mRoominfo.mGameId = null;
                    }
                }
                dZD();
                return;
            }
            this.cx = true;
            if (this.nQD != null) {
                ((VideoPlayer) this.nQD).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nKD != null) {
            this.nKD.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nKD != null) {
            this.nKD.setVisibility(8);
        }
        super.i(z);
    }

    private void dZN() {
        dZB();
        if (i()) {
            aY();
            ap();
            return;
        }
        dZD();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        eaj().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.nQp != null) {
            this.nQp.setVisibility(0);
        }
        if (this.nRr != null) {
            this.nRr.setVisibility(0);
        }
        if (this.nKb != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.nKb.d();
        }
        if (this.nKL != null) {
            this.nKL.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nKA.setVisibility(0);
            this.nKA.setOnClickListener(this);
        } else {
            this.nKA.setVisibility(8);
        }
        this.nKF.setVisibility(0);
        this.nKB.setVisibility(0);
        this.nQu.setVisibility(0);
        if (this.p) {
            this.nQv.setVisibility(0);
        } else {
            this.nQv.setVisibility(8);
        }
        aX();
        aD(true, i());
        this.e = false;
        l(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nRv != null && this.nRv.a(i, keyEvent)) {
                return true;
            }
            if (this.nLu != null && this.nLu.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.nLv != null && this.nLv.onKeyDown(i, keyEvent)) || dZP()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nLM != null && this.nLM.getVisibility() == 0 && a(motionEvent, this.nLM)) {
                this.nLM.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dN(this.nLL);
                return true;
            } else if (this.nLo && this.nLM != null && this.nLM.getVisibility() == 8 && f(this.nRj.b, motionEvent)) {
                dZI();
                return true;
            } else if (this.nLu != null && this.nLu.b() && f(this.nLu, motionEvent)) {
                this.nLu.a();
                return true;
            } else if (this.nLv != null && this.nLv.b() && f(this.nLv, motionEvent)) {
                this.nLv.a();
                return true;
            } else if (a(motionEvent, this.nKR)) {
                return dZO();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dZO() {
        boolean z;
        b(this.nLw, 10);
        boolean z2 = false;
        if (this.nLg != null && this.nLg.getVisibility() == 0) {
            this.nLg.setVisibility(8);
            this.nLh.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
            this.nLh.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nKR == null || this.nKR.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nLf) {
                dZW();
            }
            this.nKR.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nKL != null && a.this.bB == 2) {
                        a.this.nKL.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dZP() {
        if (dZO()) {
            return true;
        }
        if (this.nRe == null || !this.nRe.isShowing()) {
            return dZI() || dZH() || dMR();
        }
        this.nRe.dismiss();
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
        this.nKL.setVisibility(8);
        this.nKR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(boolean z, boolean z2) {
        if (this.nKL != null) {
            if (z) {
                if (this.nKL.getVisibility() != 0) {
                    this.nKL.setVisibility(0);
                    this.nKL.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_bottom_anim));
                }
            } else if (this.nKL.getVisibility() != 4) {
                this.nKL.setVisibility(4);
                this.nKL.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nKD != null) {
            this.nKD.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dZQ() {
        return this.nLA;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.nQC != null) {
                        this.nQC.f = null;
                        this.nQC.dZl().mRoominfo.mGameId = null;
                    }
                    dZD();
                    return;
                }
                g.OF(a.i.str_getvideosource_failed);
            }
            yy(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.nQC != null && this.nQC.dZm() != null) {
            a(this.nQC.dZm());
        }
        this.p = false;
        if (this.nQC == null || this.nQC.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nQC.f.size()) {
                if (!"2".equals(this.nQC.f.get(i2).mType)) {
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
        if (this.nKu != null) {
            this.nKu.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nKG != null && this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                this.nKG.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.nQC.dZl().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.nLt && (c = c(1, -1)) >= 0 && c < this.nLs.size() && this.nLm != null) {
            this.nLm.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nLt) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nQD, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dYT = ((VideoPlayer) this.nQD).dYT();
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(2, dYT);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dYU = ((VideoPlayer) this.nQD).dYU();
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(2, dYU);
            } else if (bVar.a == 9) {
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nLg != null) {
            this.nLg.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nLt) {
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
        if (!aa() && this.nQC != null) {
            String str = this.nQC.a;
            RoomInfo dZn = this.nQC.dZn();
            if (dZn != null && mVar.a(dZn.mCreatorUID, str)) {
                dZn.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nKS != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nKS);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
            if (this.nLp == null) {
                this.nLp = new f(getActivity());
            }
            this.nLp.a(this.nQC.dZl().mRoominfo);
            if (!this.nLp.isShowing()) {
                this.nLp.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nKu != null) {
            this.nKu.d();
        }
    }

    private void e(View view) {
        this.nKH = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nKI = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nKI.setText(new tv.chushou.zues.widget.a.c().L(this.nQD, a.e.videoplayer_4g_video).append("  ").append(this.nQD.getString(a.i.videoplayer_4g_video)));
        this.nKJ = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nKJ.setText(new tv.chushou.zues.widget.a.c().L(this.nQD, a.e.videoplayer_4g_audio).append("  ").append(this.nQD.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nKH.setVisibility(8);
                    ((VideoPlayer) a.this.nQD).c(a.this.nKK);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nKH.setVisibility(8);
                    ((VideoPlayer) a.this.nQD).d(a.this.nKK);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dYs().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nKI.setOnClickListener(onClickListener);
        this.nKJ.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nQC != null && !h.isEmpty(this.nQC.f)) {
            f(this.nQC.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nKK = z;
            this.p = false;
            if (this.nQC != null && this.nQC.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nQC.f.size()) {
                        break;
                    } else if (!"2".equals(this.nQC.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nKH != null) {
                this.nKH.setVisibility(0);
                this.nKI.setVisibility(0);
                this.nKJ.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nKH != null) {
            this.nKH.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nLE == null) {
                this.nLE = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.nQE != null) {
                    this.nQE.e(this.nLE, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nLE != null && this.nQE != null) {
            this.nQE.L(this.nLE);
            this.nLE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nKu != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nQD, "显示双击666_num", null, new Object[0]);
            if (this.nQC != null) {
                this.nQC.b(false);
            }
            d(false);
            this.nKu.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.nQo != null) {
            if (this.nLv == null) {
                this.nLv = (InteractionView) ((ViewStub) this.nQo.findViewById(a.f.view_interaction)).inflate();
                this.nLv.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.nLv.a();
                    }
                });
            }
            if (this.nLv != null) {
                this.nLv.b(configDetail);
                this.nLv.c();
                this.nLv.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.emq()) {
                g.H(this.nQD, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nQD, null) && (this.nQD instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQC != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQD, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQC != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQD, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nQD, configDetail.mUrl, this.nQD.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nQD, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    dZR();
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

    private void dZR() {
        if (this.nLo) {
            dZI();
            return;
        }
        if (this.nQD.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击送礼_num", "竖屏", new Object[0]);
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQC.dZl().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nQD != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nKf == null) {
                this.nKf = new com.kascend.chushou.player.e.a();
            }
            this.nKf.b = str;
            this.nKf.nMW.copy(pkNotifyInfo);
            if (this.nKf.nMW.mAction == 6) {
                this.nKf.nMW.mInPKMode = true;
                this.u = this.nKf.nMW.mPkId;
            } else if (this.nKf.nMW.mAction == 7 || (this.nKf.nMW.mMode == 1 && this.nKf.nMW.mAction == 5)) {
                this.nKf.nMW.mInPKMode = true;
                this.u = this.nKf.nMW.mPkId;
                if (dZT() != null) {
                    if (2 == this.bB && this.nLH != null) {
                        this.nLH.setVisibility(0);
                    }
                    dZT().b(this.nKf.nMW, false);
                    dZT().a(this.nKf.nMW.mMode, "1");
                    if (this.nKf.nMW.mAction == 5 && this.nKf.nMW.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nKf.nMW.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nKf.nMW.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nKf.nMW.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nKf.nMW.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nKf.nMW.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dZT().a(this.nKf.nMW);
                        if (this.nKf.nMW.destinyInfo == null || this.nKf.nMW.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dZT().a(parseInt, this.nKf.nMW.mPkUpdateInfo.remainDuration, j, this.nKf.nMW.mMode, i);
                    }
                    if (!h.isEmpty(this.nKf.nMW.mPkUpdateInfo.specialMomentList) && dZT() != null) {
                        dZT().a(this.nKf.nMW, true);
                    }
                }
                dZS();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Va(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.nKf.nMW.mInPKMode = false;
                dZS();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Va(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dZS() {
        if (this.nKf != null && this.nKf.nMW != null) {
            if (this.nKf.nMW.mInPKMode) {
                this.y.setText(this.nKf.nMW.mPkUserNickname);
                this.nKh.setVisibility(0);
                if (this.nQt != null) {
                    this.nQt.setEnabled(false);
                }
                if (this.nQv != null) {
                    this.nQv.setEnabled(false);
                    return;
                }
                return;
            }
            this.nKh.setVisibility(8);
            if (this.nQt != null) {
                this.nQt.setEnabled(true);
            }
            if (this.nQv != null) {
                this.nQv.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dZT() {
        if (this.nQD == null || this.nQo == null || this.nLH == null) {
            return null;
        }
        if (this.nKg == null) {
            if (this.nLG == null) {
                this.nLG = ((ViewStub) this.nQo.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.nKg = new com.kascend.chushou.player.e.b();
            this.nKg.a(this.nLH, this.nLG, (View) null, this.nQD, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cvE()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.nQC != null) {
                        append.append(a.this.nQC.dZn().mRoomID);
                    }
                    if (a.this.nKf != null && a.this.nKf.nMW != null) {
                        append.append("&mode=").append(a.this.nKf.nMW.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nQD, append.toString());
                }
            });
        }
        return this.nKg;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nLd != null && this.nQC != null && this.nQC.nJN != null) {
            this.nLd.setText(tv.chushou.zues.utils.b.OE(this.nQC.nJN.count));
            this.nLd.setVisibility(0);
            if (this.nQC.nJN.count < 1) {
                dZW();
            }
            if (this.nKV != null) {
                this.nKV.setText(this.nQC.nJN.primaryName);
            }
            if (this.nKW != null) {
                this.nKW.setText(this.nQC.nJN.desc);
            }
            dZU();
        }
    }

    public void dZU() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nLe * h.parseLong(this.nQC.nJN.point)));
        if (this.nKY != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nQD.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.L(this.nQD, a.e.icon_coin_new);
            cVar.append(this.nQD.getString(a.i.str_buy_count_coin2));
            this.nKY.setText(cVar);
        }
    }

    private void dZV() {
        if (com.kascend.chushou.d.e.c(this.nQD, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nLe);
        }
    }

    private void v(boolean z) {
        if (this.nQo != null && this.nLH != null) {
            if (z) {
                if (this.nKf != null && this.nKf.nMW != null && this.nKf.nMW.mInPKMode) {
                    this.nLH.setVisibility(0);
                    return;
                }
                return;
            }
            this.nLH.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nQo != null && this.nKk != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nKk.setVisibility(0);
                    return;
                }
                return;
            }
            this.nKk.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.nKf != null && this.nKf.nMW != null && this.nKf.nMW.mInPKMode && this.nKh != null) {
                this.nKh.setVisibility(0);
            }
        } else if (this.nKh != null) {
            this.nKh.setVisibility(8);
        }
    }

    private void dZW() {
        this.nLf = false;
        this.nLc.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nQC != null && this.nQC.nJN != null) {
            if (this.nQC.nJN.count < 1) {
                this.nLd.setVisibility(8);
            } else {
                this.nLd.setVisibility(0);
                this.nLd.setSelected(false);
                this.nLd.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nKU.setVisibility(8);
        if (this.nKS != null) {
            this.nKS.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dZR();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nKQ != null) {
            this.nKQ.performClick();
        }
    }

    public boolean dZX() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.nLT = true;
        if (this.nQo != null && com.kascend.chushou.b.dYs().d == 0) {
            this.nLC = tv.chushou.zues.utils.systemBar.b.ha(getActivity());
            if (!z) {
                View findViewById = this.nQo.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.nLC = tv.chushou.zues.utils.systemBar.b.ha(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.nLC);
            View findViewById2 = this.nQo.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.nLC);
            findViewById2.requestLayout();
        }
    }
}
