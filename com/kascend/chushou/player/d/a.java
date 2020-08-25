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
    private int[] nJZ;
    private PastedEditText nKA;
    private TextView nKB;
    private LinearLayout nKC;
    private TextView nKD;
    private TextView nKE;
    private TextView nKF;
    private TextView nKG;
    private TextView nKH;
    private TextView nKI;
    private TextView nKJ;
    private ImageView nKK;
    private TextView nKL;
    private KPSwitchPanelLinearLayout nKO;
    private ImageView nKP;
    private c nKQ;
    private d.a nKR;
    private FrescoThumbnailView nKS;
    private PagerSlidingTabStrip nKT;
    private KasViewPager nKU;
    private LinearLayout nKV;
    private f nKX;
    private ViewMicPerson nKY;
    private Fragment[] nKa;
    private ImageView nKe;
    private MarqueeTextView nKf;
    private MarqueeTextView nKg;
    private ImageView nKh;
    private ImageView nKi;
    private ImageButton nKj;
    public String nKk;
    private RecommendView nKl;
    private TextView nKo;
    private RelativeLayout nKp;
    private TextView nKq;
    private TextView nKr;
    private boolean nKs;
    private RelativeLayout nKt;
    private View nKu;
    private FrescoThumbnailView nKv;
    private AnimationSet nKw;
    private ImageView nKx;
    private TextView nKy;
    private RelativeLayout nKz;
    private String nLA;
    public ArrayList<RoomTab> nLa;
    private PopH5Menu nLc;
    private InteractionView nLd;
    private int nLe;
    private PopupWindow nLf;
    private TextView nLg;
    private GiftAnimationLayout nLh;
    private com.kascend.chushou.player.b.a nLi;
    private Runnable nLm;
    private View nLo;
    private LivePKBarUserValue nLp;
    private String nLq;
    private TextView nLr;
    private ImageView nLs;
    private EditText nLt;
    private View nLu;
    private View nLv;
    private View nLw;
    private long nJT = 0;
    private com.kascend.chushou.view.user.a nKb = null;
    private com.kascend.chushou.player.ui.a nKc = null;
    private int bB = -1;
    private int bC = 0;
    private View nKd = null;
    private View nKm = null;
    private ImageButton nKn = null;
    private int nKM = 1;
    private boolean nKN = false;
    private boolean cp = false;
    private boolean nKW = false;
    private boolean cx = false;
    private boolean nKZ = false;
    private boolean nLb = false;
    private boolean cC = true;
    private int nLj = 0;
    private int nLk = 0;
    private int nLl = -1;
    private final Rect nLn = new Rect();
    private boolean nLx = false;
    private C0888a nLy = null;
    private boolean nLz = false;
    private boolean nLB = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nKk = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nPW = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.nPW;
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
        this.nLb = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.nQR != null) {
            this.nQR.b();
        }
        if (this.nQl != null && (this.nQl instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQl).ys(true);
            ((VideoPlayer) this.nQl).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nLb = true;
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
        this.nKM = 1;
        this.nKN = false;
        U();
        if (this.nQm != null) {
            this.nQm.cl(null);
            this.nQm = null;
        }
        if (this.nKl != null) {
            eaa().removeAllViews();
            this.nKl = null;
        }
        this.c = null;
        this.nJH = null;
        tv.chushou.zues.a.a.cm(this);
        this.nKT = null;
        this.nKU = null;
        this.nKc = null;
        this.nKb = null;
        if (this.nKa != null) {
            for (int i = 0; i < this.nKa.length; i++) {
                this.nKa[i] = null;
            }
        }
        this.nKa = null;
        if (this.nKA != null) {
            this.nKA.addTextChangedListener(null);
            this.nKA.setOnTouchListener(null);
            this.nKA.setOnEditorActionListener(null);
            this.nKA = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nQl, this.nKQ);
        if (this.nQl != null && (this.nQl instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQl).dYH();
        }
        this.nKR = null;
        this.nKQ = null;
        if (this.nKY != null) {
            this.nKY.b();
            this.nKY = null;
        }
        if (this.nLf != null) {
            this.nLf.dismiss();
        }
        if (this.nLi != null) {
            this.nLi.a();
            this.nLi = null;
            this.nLh = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.nLp = (LivePKBarUserValue) this.nPW.findViewById(a.f.live_pk_bar_user);
        this.nQe = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nLx) {
            this.nLx = true;
            if (this.nLv == null) {
                this.nLv = this.nPW.findViewById(a.f.vs_async_view);
                this.nLv = ((ViewStub) this.nLv).inflate();
            }
            if (this.nLw == null) {
                this.nLw = this.nPW.findViewById(a.f.vs_async_notification_view);
                this.nLw = ((ViewStub) this.nLw).inflate();
            }
            this.nJS = (VoiceInteractionView) this.nPW.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.nPW);
            dMD();
            ((VideoPlayer) this.nQl).q();
            this.nJN = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.nKS = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.nKT = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.nKU = (KasViewPager) view.findViewById(a.f.vp_main);
        dZo();
        aI();
        dZs();
        if (this.nQk != null) {
            I();
            a(this.nQk.nJt, this.nQk.nJw);
        }
        this.bb = 0;
        this.nQW = 0L;
        this.nQS = (RoundProgressBar) this.nPW.findViewById(a.f.roundProgressBar);
        this.nQT = (TextView) this.nPW.findViewById(a.f.tv_paonum);
        this.nQU = (FrescoThumbnailView) this.nPW.findViewById(a.f.iv_paoicon);
        this.nRb = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.nKW = false;
                if (a.this.bB == 2) {
                    a.this.aD(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.nLe, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.nKW = true;
                if (a.this.bB == 2) {
                    a.this.aD(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.nQR != null) {
                    a.this.nQR.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gW(a.this.nQl).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nQl)) - a.this.nQR.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nQl, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nQl, 54.0f) * 2);
                    if (statusBarHeight < a.this.nLe) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.nQV = (PaoGuideView) this.nPW.findViewById(a.f.rlPaoGuideView);
        this.nKY = (ViewMicPerson) this.nPW.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.nMD = ((VideoPlayer) this.nQl).dYA();
        this.nQk = ((VideoPlayer) this.nQl).dYD();
        e(this.nPW);
        this.nLj = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
        this.nLk = tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        if (com.kascend.chushou.b.dYj().d == 0 && this.nLk > 0) {
            View findViewById = this.nPW.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nLk);
        }
        dZx();
        dZv();
        if (!this.cC) {
            Q();
        }
        dZt();
        a();
        if (this.c == null) {
            this.nJH = new d.a();
            this.c = new GestureDetector(this.nQl, this.nJH);
        }
        this.nJJ = ((VideoPlayer) this.nQl).dYE();
        this.nJJ.a(this);
        if (this.nLi != null) {
            this.nLi.a();
            this.nLi = null;
        }
        this.nLh = (GiftAnimationLayout) this.nPW.findViewById(a.f.ll_gift_animation);
        this.nLh.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.nQk != null) {
            this.nLi = new com.kascend.chushou.player.b.a(this.nQl.getApplicationContext(), this.nLh);
            this.nLi.a(this.nQk);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.nPW.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nQf = (PlayerErrorView) this.nPW.findViewById(a.f.view_net_error_msg);
        this.nQf.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        dZA();
        if (this.nQk.dZd() != null) {
            a(this.nQk.dZd());
        }
        FullRoomInfo dZc = this.nQk.dZc();
        if (dZc != null) {
            dZE();
            if (i()) {
                this.ak = false;
                yw(true);
                this.nQm.Ow(8);
            }
            this.nKo.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dZc.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.nPX != null) {
            this.nPX.setVisibility(0);
        }
        this.nKd.setVisibility(0);
        this.ak = false;
        yw(true);
        this.nQm.Ow(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nQl).n();
        if (this.nQk != null && !h.isEmpty(this.nQk.w)) {
            b(this.nQk.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dYO;
        dZo();
        k();
        FullRoomInfo dZc = this.nQk.dZc();
        if (dZc != null) {
            if (dZc.mRoominfo != null) {
                this.nKo.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dZc.mRoominfo.mOnlineCount)));
                this.nLq = dZc.mRoominfo.mRoomID;
            }
            dZE();
            if (!h.isEmpty(dZc.mRoomToastList)) {
                Iterator<RoomToast> it = dZc.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dYr().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.nQk != null && this.nQk.l()) {
                d(true);
            }
            if (this.nQl != null && (this.nQl instanceof VideoPlayer) && (dYO = ((VideoPlayer) this.nQl).dYO()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dYO.nME, dYO.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.nKV);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dZo() {
        boolean z = true;
        if (this.nQk == null || this.nQk.dZc() == null || this.nQk.dZc().mRoominfo == null || h.isEmpty(this.nQk.dZc().mRoomTabs)) {
            this.nKZ = false;
            this.nKa = new Fragment[2];
            this.nJZ = new int[2];
            this.nJZ[0] = 2;
            this.nJZ[1] = 1;
            return;
        }
        this.nKZ = true;
        this.nLa = new ArrayList<>();
        Iterator<RoomTab> it = this.nQk.dZc().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.nLa.add(next);
            }
        }
        if (this.nLa.size() >= 2 && this.nJZ != null && this.nJZ.length >= 2 && this.nLa.get(0).type == this.nJZ[0] && this.nLa.get(1).type == this.nJZ[1]) {
            z = false;
        }
        this.nKa = new Fragment[this.nLa.size()];
        this.nJZ = new int[this.nLa.size()];
        for (int i = 0; i < this.nLa.size(); i++) {
            this.nJZ[i] = this.nLa.get(i).type;
        }
        if (z) {
            this.nLy = new C0888a(getChildFragmentManager());
            this.nKU.setAdapter(this.nLy);
        }
    }

    private void aI() {
        this.nKz = (RelativeLayout) this.nPW.findViewById(a.f.rl_edit_bar);
        this.nKv = (FrescoThumbnailView) this.nPW.findViewById(a.f.btn_hotword);
        this.nKv.Ck(a.e.ic_hotwords_black_n);
        this.nKv.setOnClickListener(this);
        this.nKx = (ImageView) this.nPW.findViewById(a.f.iv_task_badge);
        this.nKw = (AnimationSet) AnimationUtils.loadAnimation(this.nQl, a.C0882a.anim_hotword);
        this.nKw.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dYr().c) {
                    a.this.nKv.clearAnimation();
                    a.this.nKv.startAnimation(a.this.nKw);
                }
            }
        });
        if (com.kascend.chushou.d.h.dYr().c) {
            this.nKv.startAnimation(this.nKw);
            this.nKx.setVisibility(0);
        }
        this.nKy = (TextView) this.nPW.findViewById(a.f.tv_bottom_input);
        this.nKy.setOnClickListener(this);
        this.nRm = (FrescoThumbnailView) this.nPW.findViewById(a.f.ll_btn_set);
        this.nRm.setOnClickListener(this);
        this.nKV = (LinearLayout) this.nPW.findViewById(a.f.ll_bottom_all_button);
        this.nKt = (RelativeLayout) this.nPW.findViewById(a.f.rl_bottom_input);
        this.nKu = this.nPW.findViewById(a.f.ll_bottom_input);
        this.nKt.setVisibility(8);
        this.nKA = (PastedEditText) this.nPW.findViewById(a.f.et_bottom_input);
        this.nKA.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nKB.setEnabled(editable.length() > 0);
            }
        });
        this.nKA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nKB);
                    return true;
                }
                return true;
            }
        });
        this.nKA.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.nKA);
                }
                return false;
            }
        });
        this.nKP = (ImageView) this.nPW.findViewById(a.f.iv_btn_emoji);
        this.nKP.setVisibility(8);
        this.nKB = (TextView) this.nPW.findViewById(a.f.tv_btn_send);
        this.nKB.setOnClickListener(this);
        this.nKO = (KPSwitchPanelLinearLayout) this.nPW.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dYj().d == 0) {
            this.nKO.setUseStatusBar(true);
        }
        this.nKC = (LinearLayout) this.nPW.findViewById(a.f.head_trumpet);
        this.nKC.setVisibility(8);
        this.nKC.setOnClickListener(this);
        this.nKD = (TextView) this.nPW.findViewById(a.f.tv_primary_name);
        this.nKE = (TextView) this.nPW.findViewById(a.f.tv_primary_desc);
        this.nKH = (TextView) this.nPW.findViewById(a.f.tv_cut_count);
        this.nKH.setOnClickListener(this);
        this.nKJ = (TextView) this.nPW.findViewById(a.f.tv_head_count);
        this.nKJ.setText(this.nKM + "");
        this.nKI = (TextView) this.nPW.findViewById(a.f.tv_plus_count);
        this.nKI.setOnClickListener(this);
        this.nKG = (TextView) this.nPW.findViewById(a.f.tv_buy_count_coin);
        this.nKF = (TextView) this.nPW.findViewById(a.f.tv_buy_head);
        this.nKF.setOnClickListener(this);
        this.nKK = (ImageView) this.nPW.findViewById(a.f.iv_trumpet_select);
        this.nKK.setOnClickListener(this);
        this.nKL = (TextView) this.nPW.findViewById(a.f.tv_trumpet_have_count);
        this.nKN = false;
        this.nKK.setBackgroundResource(a.e.ic_trumpet_n);
        this.nKL.setVisibility(8);
        dZq();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nKO, this.nKP, this.nKA, new a.InterfaceC1018a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1018a
            public void yt(boolean z) {
                if (a.this.nKP != null) {
                    if (!z) {
                        a.this.nKP.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dYj().d == 0) {
                        a.this.nKO.setDirectVisibility(0);
                    }
                    a.this.nKP.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nKR = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void yu(boolean z) {
                if (a.this.nLB) {
                    a.this.nLB = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.nKP.setImageResource(a.e.cs_emoji_normal);
                    a.this.dZp();
                    return;
                }
                if (a.this.nLu != null && a.this.nLu.getVisibility() == 0) {
                    a.this.nLu.setVisibility(8);
                }
                if (a.this.nKW) {
                    a.this.nQR.setVisibility(0);
                }
                if (a.this.nQl != null && (a.this.nQl instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nQl).ys(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.nKQ = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nKO, this.nKR, ((VideoPlayer) this.nQl).dYI());
        ((VideoPlayer) this.nQl).h(((VideoPlayer) this.nQl).dYI());
        this.nLu = this.nPW.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nLr = (TextView) this.nPW.findViewById(a.f.btn_room_search);
        this.nLs = (ImageView) this.nPW.findViewById(a.f.iv_room_emoji_delete);
        this.nLt = (EditText) this.nPW.findViewById(a.f.et_room_emoji_search);
        this.nLt.setImeOptions(3);
        this.nLt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.nLr);
                    return true;
                }
                return false;
            }
        });
        this.nLt.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nLr.setEnabled(editable.length() > 0);
                a.this.nLs.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.nQR.setEmojiSearchText(editable.toString());
            }
        });
        this.nLr.setOnClickListener(this);
        this.nLs.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aB(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dM(this.nLt);
            this.nLu.setVisibility(0);
            this.nLt.requestFocus();
        } else {
            this.nLu.setVisibility(8);
        }
        if (z2) {
            this.nLt.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZp() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gW(this.nQl).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl)) - tv.chushou.zues.widget.kpswitch.b.d.hi(this.nQl)) - tv.chushou.zues.utils.a.dip2px(this.nQl, 14.0f)) - this.nQl.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nQl, 54.0f) * 2);
        if (statusBarHeight < this.nLe) {
            b(statusBarHeight, 10);
        }
    }

    private void dZq() {
    }

    private void aL() {
        this.nQm = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aC(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.nPW.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nQl.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nQm.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nQm.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nQm.B(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nQm);
                            break;
                        case 12:
                            a.this.b(a.this.nQm);
                            break;
                        case 17:
                            a.this.eac();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.nQj.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dZr() {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nLa)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nLa.size()) {
                    if (!h.isEmpty(this.nLa.get(i2).notifyIcon)) {
                        this.nKT.bL(i2, this.nLa.get(i2).notifyIcon);
                        this.nKT.OV(i2);
                    } else if (this.nLa.get(i2).notify == 1) {
                        this.nKT.OU(i2);
                        this.nKT.OT(i2);
                    } else {
                        this.nKT.OT(i2);
                        this.nKT.OV(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nLa)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.nLa.size()) {
                    if (this.nLa.get(i4).type == i) {
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
        if (this.nQk == null || this.nQk.dZc() == null || this.nQk.dZc().mRoominfo == null || h.isEmpty(this.nLa)) {
            if (i == 1) {
                return this.nQl.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nQl.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.nLa.size()) {
            return this.nLa.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nLa) && i < this.nLa.size()) {
            this.nLa.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nLa) && i < this.nLa.size()) {
            this.nLa.get(i).notifyIcon = str;
        }
    }

    private void dZs() {
        if (this.nKU != null && this.nKT != null && this.nJZ != null) {
            this.nKc = null;
            if (this.nKa != null) {
                for (int i = 0; i < this.nKa.length; i++) {
                    this.nKa[i] = null;
                }
            }
            if (this.nLy == null) {
                this.nLy = new C0888a(getChildFragmentManager());
                this.nKU.setAdapter(this.nLy);
            } else {
                this.nLy.notifyDataSetChanged();
            }
            this.nKU.setOffscreenPageLimit(this.nJZ.length);
            this.nKT.c(this.nKU);
            this.nKT.setOnPageChangeListener(this);
            this.nKT.notifyDataSetChanged();
            this.nKT.setVisibility(0);
            this.nKU.setVisibility(0);
            if (!this.nKZ) {
                this.bB = 2;
                this.nKU.setCurrentItem(c(2, 0));
                this.nKt.setVisibility(0);
            } else {
                if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                    if (!h.isEmpty(this.nQk.dZc().mRoominfo.mGameName)) {
                        this.nKg.setText(this.nQk.dZc().mRoominfo.mGameName);
                    } else {
                        this.nKg.setText(this.nQl.getString(a.i.no_online_game_name));
                    }
                    this.nKf.setText(this.nQk.dZc().mRoominfo.mName);
                } else {
                    this.nKg.setText(this.nQl.getString(a.i.no_online_game_name));
                }
                dZr();
                if (i()) {
                    dZB();
                    if (this.nKU != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.nKU.setCurrentItem(c);
                        this.nKT.setSelectItem(c);
                    }
                } else if (this.nKU != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.nKU.setCurrentItem(c2);
                    this.nKT.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dZt() {
        this.nPX = new SurfaceView(this.nQl);
        SurfaceView surfaceView = (SurfaceView) this.nPX;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        eaa().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dZu() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nQl).s();
        dMI();
        dZy();
        dZn();
        eaa().setBackgroundResource(a.e.room_not_online);
        if (this.nKl == null) {
            this.nKl = new RecommendView(this.nQl);
            eaa().addView(this.nKl);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nQl);
            this.nKl.setLayoutParams(layoutParams);
        }
        if (this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nQk.dZc().mRoominfo.mRoomID)) {
            this.nKl.a(this.nQk.dZc().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.nQl != null && a.this.eaa() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nQl);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.npq);
                        if (a.this.eaa().getChildCount() >= 2) {
                            a.this.eaa().addView(frescoThumbnailView, 0);
                        }
                        a.this.eaa().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.elZ(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.nPX != null) {
            this.nPX.setVisibility(8);
        }
        if (this.nQZ != null) {
            this.nQZ.elv();
            this.nQZ.setVisibility(8);
        }
        l(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.nQR != null) {
            this.nQR.e();
        }
        yw(false);
        a(false, false);
        if (this.nJJ != null) {
            this.nJJ.d();
        }
    }

    private void dZv() {
        int i = 0;
        this.nKd = this.nPW.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dYj().d == 0 && this.nLj > 0) {
            View findViewById = this.nPW.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.nLj;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nKe = (ImageView) this.nKd.findViewById(a.f.back_icon);
        this.nKe.setOnClickListener(this);
        this.nKf = (MarqueeTextView) this.nKd.findViewById(a.f.tv_title);
        this.nKg = (MarqueeTextView) this.nKd.findViewById(a.f.tv_Type);
        this.nKi = (ImageView) this.nPW.findViewById(a.f.btn_setting);
        this.nKm = this.nPW.findViewById(a.f.bottomview);
        if (this.nQc == null) {
            this.nQc = (ImageButton) this.nKm.findViewById(a.f.btn_barrage);
            this.nQc.setOnClickListener(this);
            if (this.nQk != null) {
                if (com.kascend.chushou.d.h.dYr().n()) {
                    this.nQc.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nQc.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.nQd = (ImageButton) this.nKm.findViewById(a.f.btn_audio);
        this.nQd.setOnClickListener(this);
        if (this.nQk != null && this.nQk.d) {
            this.nQd.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.nQd.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.nQk != null && this.nQk.f != null) {
            while (true) {
                if (i >= this.nQk.f.size()) {
                    break;
                } else if (!"2".equals(this.nQk.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nKn = (ImageButton) this.nKm.findViewById(a.f.playbutton);
        this.nKn.setOnTouchListener(this);
        this.nKj = (ImageButton) this.nKm.findViewById(a.f.btn_refresh);
        this.nKj.setOnClickListener(this);
        this.nKo = (TextView) this.nKm.findViewById(a.f.tv_online_count);
        if (this.nQb == null) {
            this.nQb = (ImageButton) this.nKm.findViewById(a.f.btn_screenChange);
            this.nQb.setOnClickListener(this);
        }
        if (this.nKh == null) {
            this.nKh = (ImageView) this.nKd.findViewById(a.f.report_icon);
            this.nKh.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nKc != null) {
                        this.nKc.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                        this.nQk.dZc().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nQk.dZc().mMicStatus.onMic) {
                            dZD();
                        }
                        if (this.nQk.dZc().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.nQk.dZc().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.nQk.dZc().mRoominfo.mCreatorUID);
                            }
                        } else if (this.nQk.dZc().mMicStatus.onMic) {
                            this.nQk.dZc().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nQk.dZc().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.nQk.dZc().mFanItems, str);
                            }
                            this.nLz = z2;
                            if (this.nQk.dZc().mMicStatus != null && !h.isEmpty(this.nQk.dZc().mMicStatus.micRoomId) && !this.nQk.dZc().mMicStatus.micRoomId.equals("0")) {
                                this.nLA = this.nQk.dZc().mMicStatus.micRoomId;
                            }
                            if (this.nKc != null) {
                                this.nKc.a(this.nQk.dZc().mMicStatus, this.nQk.dZc().mFanItems, str, z2);
                            }
                            if (this.nKY != null && this.nKY.getVisibility() == 0) {
                                this.nKY.a(this.nQk.dZc().mFanItems, this.nQk.dZc().mMicStatus, str, z2, this.nQk.dZc().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nKc != null) {
                                this.nKc.e();
                            }
                            if (this.nKY != null && this.nKY.isShown()) {
                                this.nKY.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nKc != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nKc.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nKc.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.nLl != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.nLl = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nJN != null && this.nJN.nME != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nJN.nME.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nJN.nME.mInPKMode = true;
                                    this.nJN.nME.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nJN.nME.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nJN.nME.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nJN.nME.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nJN.nME.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nJN.nME.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nJN.nME.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nJN.nME.mMode = pkNotifyInfo.mMode;
                                    this.nJN.nME.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dZK() != null) {
                                        dZK().g(true, this.nJN.nME.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dYr().a) {
                                        if (!com.kascend.chushou.b.dYj().e) {
                                            com.kascend.chushou.b.dYj().e = true;
                                            g.H(this.nQl, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dYr().a(this.nQl, false);
                                        dZC();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.nLp != null) {
                                        this.nLp.setVisibility(0);
                                    }
                                    this.nJN.nME.mAction = 7;
                                    this.nJN.nME.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nJN.nME.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nJN.nME.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nJN.nME.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nJN.nME.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nJN.nME.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dZJ();
                                    if (dZK() != null) {
                                        dZK().g(false, 0L);
                                        dZK().b(this.nJN.nME, true);
                                        dZK().a(this.nJN.nME.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Va(this.nLq);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.nJN.nME.mInPKMode = false;
                                    this.nJN.nME.mAction = 2;
                                    dZJ();
                                    if (dZK() != null) {
                                        dZK().c();
                                    }
                                    if (com.kascend.chushou.d.h.dYr().a) {
                                        if (!com.kascend.chushou.b.dYj().e) {
                                            com.kascend.chushou.b.dYj().e = true;
                                            g.H(this.nQl, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dYr().a(this.nQl, false);
                                        dZC();
                                    }
                                    this.nJN.b = null;
                                    this.nJN.nME = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Va(this.nLq);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nJN.nME.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nJN.nME.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.nJN.nME.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nQk.dZc().mRoominfo.mRoomID) && this.nQk.dZc().mRoominfo.mRoomID.equals(this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dZK() != null) {
                                        dZK().a(this.nJN.nME, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nJN.nME.copyUpdate(pkNotifyInfo);
                                    if (dZK() != null) {
                                        dZK().a(this.nJN.nME);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nJN.nME.copyStop(pkNotifyInfo);
                                        if (dZK() != null) {
                                            dZK().B(this.nJN.nME.mMaxFreeDuration, this.nJN.nME.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nJN.nME.copyResult(pkNotifyInfo);
                                    if (!this.nLb && dZK() != null) {
                                        int i5 = 1;
                                        if (this.nJN.nME.destinyInfo != null && this.nJN.nME.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dZK().a(h.parseInt(this.nJN.nME.mResult), h.parseLong(this.nJN.nME.mvpUid), this.nJN.nME.mvpAvatar, this.nJN.nME.mvpNickname, this.nJN.nME.mMaxFreeDuration, this.nJN.nME.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nKc != null) {
                if (LoginManager.Instance().islogined() && this.nQk != null && this.nQk.l()) {
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
                if (this.nQk == null || this.nQk.dZc() == null || this.nQk.dZc().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.nQk.dZc().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dYr().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dYr().b().equals(next2.mUserID)) {
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
                this.nKc.a(arrayList, true, false);
                this.nKc.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nJZ != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nJZ.length) {
                    break;
                }
                if (this.nJZ[i2] == 99 && this.nKa != null && this.nKa[i2] != null && (this.nKa[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nKa[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.nLa.size() && this.nKT != null) {
                if (i == 0) {
                    this.nKT.setTagText(i2, new StringBuilder(this.nLa.get(i2).name).toString());
                    return;
                } else {
                    this.nKT.setTagText(i2, this.nLa.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.nQc != null) {
            if (z) {
                this.nQc.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nQc.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dZw() {
        if (this.nPW == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nPW.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
        this.ar = Math.min(gW.x, gW.y);
        this.aq = (this.ar * this.nQl.getResources().getInteger(a.g.h_thumb_height_def)) / this.nQl.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = eaa().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nQe.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nLe = this.aq + this.nQl.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nQl, 54.0f);
        b(this.nLe, 10);
        if (this.nPX != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.nPX).setLayoutParams(layoutParams3);
        }
    }

    private void dZx() {
        Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
        this.ar = Math.min(gW.x, gW.y);
        this.aq = (this.ar * this.nQl.getResources().getInteger(a.g.h_thumb_height_def)) / this.nQl.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = eaa().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nQe.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nLe = this.aq + this.nQl.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nQl, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.nLe, 10);
        k();
        if (!h.isEmpty(this.nKk)) {
            File af = tv.chushou.zues.widget.fresco.a.af(Uri.parse(this.nKk));
            if (af != null && af.exists()) {
                this.nQe.setImageURI(Uri.fromFile(af));
                this.nQe.setVisibility(0);
                return;
            }
            this.nQe.setVisibility(8);
            return;
        }
        this.nQe.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aC(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nKh != null) {
            this.nKh.setVisibility(z ? 0 : 4);
        }
        if (this.nKi != null) {
            this.nKi.setVisibility(z ? 0 : 4);
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
        if (this.nQm != null) {
            this.nQm.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nQl).f(true);
            if (!z3) {
                if (this.nKm.getVisibility() != 0 && z2) {
                    this.nKm.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.nQd.setVisibility(0);
                } else {
                    this.nQd.setVisibility(8);
                }
                this.nKm.setVisibility(0);
            }
            PlayUrl dZd = this.nQk.dZd();
            if (dZd != null && "2".equals(dZd.mType)) {
                if (this.nQb != null) {
                    this.nQb.setVisibility(8);
                }
            } else if (this.nQb != null) {
                this.nQb.setVisibility(0);
            }
            if (this.nKd.getVisibility() != 0 && z2) {
                this.nKd.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_top_anim));
            }
            t(!z3);
            this.nKd.setVisibility(0);
            w(true);
            if (this.nQm != null) {
                this.nQm.B(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nQl).f(false);
            if (this.nQE != null) {
                this.nQE.dismiss();
            }
            if (this.nQF != null) {
                this.nQF.dismiss();
            }
            if (this.nKm.getVisibility() != 8 && z2) {
                this.nKm.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_bottom_anim));
            }
            this.nKm.setVisibility(8);
            if (this.nKd.getVisibility() != 8 && z2) {
                this.nKd.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_top_anim));
            }
            this.nKd.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dMI() {
        if (this.nQV == null || !this.nQV.isShown()) {
            return false;
        }
        this.nQV.d();
        return true;
    }

    public boolean dZy() {
        if (this.nKY == null || !this.nKY.isShown()) {
            return false;
        }
        this.nKY.a();
        return true;
    }

    public boolean dZn() {
        if (this.nLc == null || !this.nLc.b()) {
            return false;
        }
        this.nLc.a();
        return true;
    }

    public boolean dZz() {
        if (this.nKW && this.nQR != null) {
            if (this.nQR != null) {
                this.nQR.e();
            }
            if (this.nLt != null) {
                this.nLt.setText("");
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
        if (listItem != null && this.nPW != null) {
            if (this.nLc == null) {
                this.nLc = (PopH5Menu) ((ViewStub) this.nPW.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.nLc.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.nLc.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.nKd.getHeight() + this.nKd.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nQl, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                g.c(this.nQl, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.nQk.a(false);
                a(false, false);
                ((VideoPlayer) this.nQl).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.nQl, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.nJN == null || this.nJN.nME == null || !this.nJN.nME.mInPKMode) {
                ((VideoPlayer) this.nQl).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nKN) {
                f(this.nKA.getText().toString());
            } else {
                a(this.nKA.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dYr().c) {
                com.kascend.chushou.d.h.dYr().b(false);
                this.nKw.cancel();
                this.nKw.reset();
                this.nKv.clearAnimation();
                this.nKx.setVisibility(8);
            }
            n(view, 0, this.nPW.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nQl, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.nPW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.nQk.d) {
                dMw();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nQl, null) && this.nQk != null && this.nQk.nJv != null) {
                if (this.nKN) {
                    dZN();
                    return;
                }
                if (this.nQk != null && this.nQk.nJv != null && this.nQk.nJv.count > 0) {
                    this.nKC.setVisibility(8);
                } else {
                    this.nKC.setVisibility(0);
                }
                this.nKN = true;
                this.nKK.setBackgroundResource(a.e.ic_trumpet_p);
                this.nKL.setVisibility(0);
                this.nKL.setSelected(true);
                this.nKL.setTextColor(Color.parseColor("#ff5959"));
                if (this.nKA != null) {
                    this.nKA.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nKM <= 9) {
                this.nKM++;
                this.nKJ.setText(this.nKM + "");
            }
            dZL();
        } else if (id == a.f.tv_cut_count) {
            if (this.nKM > 1) {
                this.nKM--;
                this.nKJ.setText(this.nKM + "");
            }
            dZL();
        } else if (id == a.f.tv_buy_head) {
            dZM();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.nLt.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.nLt.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dN(this.nLt);
                this.nQR.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nKA != null && this.nKt != null && this.nKz != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.nKA);
                this.nKt.setVisibility(8);
                if (this.bB == 2) {
                    this.nKz.setVisibility(0);
                }
            }
        } else if (this.nKt != null && this.nKz != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
            if (this.bB == 2) {
                this.nKt.setVisibility(0);
            }
            this.nKz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dYr().c(roomToast.mToastContent);
            if (this.nLf == null) {
                aS();
            }
            if (this.nLg != null) {
                this.nLg.setText(roomToast.mToastContent);
            }
            if (!this.nLf.isShowing()) {
                if (this.nKV != null) {
                    this.nLf.showAtLocation(this.nKV, 85, 0, this.nPW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
                    RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.nLf != null) {
                                a.this.nLf.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nLf.dismiss();
        }
    }

    private void aS() {
        if (this.nLf == null) {
            View inflate = LayoutInflater.from(this.nQl).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nLg = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nLf = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 160.0f), -2);
            this.nLf.setFocusable(false);
            this.nLf.setOutsideTouchable(false);
            this.nLf.setAnimationStyle(a.j.gift_toast_style);
            this.nLf.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.nQM != null && this.nQM.isShowing()) {
            this.nQM.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
        if (this.nRj == null) {
            ead();
        }
        if (!this.nRj.isShowing()) {
            this.nRj.showAtLocation(view, 83, i, i2);
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nQk.dZc().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nRj.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.nRm != null) {
            if (h.isEmpty(this.nRn)) {
                if (((VideoPlayer) this.nQl).q) {
                    this.nRm.bX(this.nQk != null ? this.nQk.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.nRm.bX(this.nQk != null ? this.nQk.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nQl).q && this.nRn.size() == 2 && this.nRn.contains("4") && this.nRn.contains("2")) {
                this.nRm.bX(this.nQk != null ? this.nQk.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.nRn.size() > 1 || !((VideoPlayer) this.nQl).q) {
                this.nRm.bX(this.nQk != null ? this.nQk.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.nRn.get(0))) {
                this.nRm.bX(this.nQk != null ? this.nQk.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.nRn.get(0))) {
                this.nRm.bX(this.nQk != null ? this.nQk.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.nRn.get(0))) {
                this.nRm.bX(this.nQk != null ? this.nQk.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
        if (this.nQM == null) {
            al();
            this.nQM.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.nQM.isShowing() && this.bB == 2) {
            this.nQM.showAtLocation(view, 83, i, this.nQl.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nQk.dZc().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nQM.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nQe != null) {
            this.nQe.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                g.c(this.nQl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nMD.getPlayState() == 4) {
                        e(true);
                        if (this.nQk.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.nQk.a(false);
                        ((VideoPlayer) this.nQl).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nMD.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nMD.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                g.c(this.nQl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.nQk.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nQl).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                    this.ai = false;
                    yw(true);
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
        if (this.nQZ != null) {
            if (z) {
                this.nQZ.setVisibility(0);
            }
            this.nQZ.elv();
            if (!z) {
                this.nQZ.setVisibility(8);
            }
        }
        g.c(this.nQl, this.nQl.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nKn != null) {
                this.nKn.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nQf != null) {
                this.nQf.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nKn != null) {
            this.nKn.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nQf != null) {
                    this.nQf.setVisibility(8);
                }
            }
        }
    }

    private void dZA() {
        this.e = false;
        l(true, false, true);
    }

    private void dZB() {
        this.e = false;
        l(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.nJZ[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dZr();
            a(this.nQk != null ? this.nQk.nJw.get("1") : null);
            if (i2 == 2) {
                k();
                aD(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.nQl, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aD(false, i3);
            v(false);
            b(false);
            if (this.nQM != null && this.nQM.isShowing()) {
                this.nQM.dismiss();
            }
            if (i2 == 99) {
                if (this.nKa != null && this.nKa[i] != null && (this.nKa[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nKa[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nQl, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nQl, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nQl, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nQl, "房间信息页_num", null, new Object[0]);
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
    protected void dZC() {
        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nQm != null) {
            if (this.nKz != null && this.nKz.getVisibility() == 0) {
                u(false);
            }
            if (this.nQf != null && this.nQf.getVisibility() == 0) {
                this.f = true;
            }
            aC(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nKc != null) {
            this.nKc.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nKc != null) {
            this.nKc.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nKc != null) {
            this.nKc.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nKc != null) {
            this.nKc.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nKV != null) {
            int size = iconConfig.configs.size();
            this.nKV.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nQl).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.nKV, false);
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
                this.nKV.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.nQk != null ? this.nQk.nJw : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nKc != null) {
            this.nKc.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nKS != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nKS.Ck(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nKS.bX(str, a.c.kas_white);
                if (this.nKT != null) {
                    this.nKT.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nKS.Ck(a.c.kas_white);
                if (this.nKT != null) {
                    this.nKT.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.nKT != null) {
                    this.nKT.setTextColor(a);
                    this.nKT.setTabTextSelectColor(a2);
                    this.nKT.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nKv != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nKv.Ck(a.e.ic_hotwords_black_n);
            } else {
                this.nKv.bX(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nKu != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.eaq().a(str, this.nKu, a.e.player_skin_input);
            } else {
                this.nKu.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nKy != null) {
                this.nKy.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nKc != null) {
            this.nKc.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQl instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dYJ = ((VideoPlayer) this.nQl).dYJ();
            if (this.nRd == null) {
                this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRd.setVisibility(0);
            this.nRd.a(2, dYJ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nKc != null) {
            this.nKc.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nKc != null) {
            this.nKc.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nKc != null) {
            this.nKc.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nKc != null) {
            this.nKc.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nKc != null && this.nQk != null) {
            this.nKc.b(this.nQk.nJu);
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
            if (i < 0 || i >= a.this.nJZ.length) {
                return null;
            }
            switch (a.this.nJZ[i]) {
                case 1:
                    if (a.this.nKb == null) {
                        a.this.nKb = com.kascend.chushou.view.user.a.a(2, null, a.this.nQk.a, false, a.this.nQk.h, false);
                    }
                    a.this.nKa[i] = a.this.nKb;
                    return a.this.nKb;
                case 2:
                    if (a.this.nKc == null) {
                        a aVar = a.this;
                        if (a.this.nJN != null && a.this.nJN.nME != null) {
                            z = a.this.nJN.nME.mInPKMode;
                        }
                        aVar.nKc = com.kascend.chushou.player.ui.a.yx(z);
                    }
                    a.this.nKa[i] = a.this.nKc;
                    return a.this.nKc;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.nQk != null && a.this.nQk.dZc() != null && !h.isEmpty(a.this.nLa)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.nLa.get(i).url);
                        h5Options.a = a.this.nLa.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nKa[i] = a;
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
            return a.this.nJZ.length;
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
            int dimensionPixelSize = a.this.nQl.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
        } else if (System.currentTimeMillis() - this.nJT <= IMConnection.RETRY_DELAY_TIMES) {
            g.OF(a.i.str_too_fast);
            return false;
        } else {
            dZF();
            if (!com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a(((VideoPlayer) this.nQl).dYD().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nJT = System.currentTimeMillis();
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                a(this.nQk.dZc().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nQk.h);
            }
            g(this.b);
            if (!z && this.nKA != null) {
                this.nKA.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dZF();
            if (com.kascend.chushou.d.e.c(this.nQl, null) && LoginManager.Instance().getUserInfo() != null && this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                a(this.nQk.dZc().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nKA != null) {
                this.nKA.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nKc != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nQk.dZc().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nQk.dZc().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nQl).nHK;
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
                        this.nKc.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nKc.a(arrayList, true, true);
        }
    }

    private void dZD() {
        if (this.nKc != null) {
            this.nKc.e();
        }
        if (this.nKY != null && this.nKY.isShown()) {
            this.nKY.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.nQl instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.nQk != null) {
            this.nQk.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dZD();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.nQl != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.nQl).t)) {
                this.cx = true;
                if (this.nQk != null) {
                    this.nQk.f = null;
                    if (this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                        this.nQk.dZc().mRoominfo.mGameId = null;
                    }
                }
                dZu();
                return;
            }
            this.cx = true;
            if (this.nQl != null) {
                ((VideoPlayer) this.nQl).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nKl != null) {
            this.nKl.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nKl != null) {
            this.nKl.setVisibility(8);
        }
        super.i(z);
    }

    private void dZE() {
        dZs();
        if (i()) {
            aY();
            ap();
            return;
        }
        dZu();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        eaa().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.nPX != null) {
            this.nPX.setVisibility(0);
        }
        if (this.nQZ != null) {
            this.nQZ.setVisibility(0);
        }
        if (this.nJJ != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.nJJ.d();
        }
        if (this.nKt != null) {
            this.nKt.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nKi.setVisibility(0);
            this.nKi.setOnClickListener(this);
        } else {
            this.nKi.setVisibility(8);
        }
        this.nKn.setVisibility(0);
        this.nKj.setVisibility(0);
        this.nQc.setVisibility(0);
        if (this.p) {
            this.nQd.setVisibility(0);
        } else {
            this.nQd.setVisibility(8);
        }
        aX();
        aD(true, i());
        this.e = false;
        l(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nRd != null && this.nRd.a(i, keyEvent)) {
                return true;
            }
            if (this.nLc != null && this.nLc.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.nLd != null && this.nLd.onKeyDown(i, keyEvent)) || dZG()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nLu != null && this.nLu.getVisibility() == 0 && a(motionEvent, this.nLu)) {
                this.nLu.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dN(this.nLt);
                return true;
            } else if (this.nKW && this.nLu != null && this.nLu.getVisibility() == 8 && f(this.nQR.b, motionEvent)) {
                dZz();
                return true;
            } else if (this.nLc != null && this.nLc.b() && f(this.nLc, motionEvent)) {
                this.nLc.a();
                return true;
            } else if (this.nLd != null && this.nLd.b() && f(this.nLd, motionEvent)) {
                this.nLd.a();
                return true;
            } else if (a(motionEvent, this.nKz)) {
                return dZF();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dZF() {
        boolean z;
        b(this.nLe, 10);
        boolean z2 = false;
        if (this.nKO != null && this.nKO.getVisibility() == 0) {
            this.nKO.setVisibility(8);
            this.nKP.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
            this.nKP.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nKz == null || this.nKz.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nKN) {
                dZN();
            }
            this.nKz.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nKt != null && a.this.bB == 2) {
                        a.this.nKt.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dZG() {
        if (dZF()) {
            return true;
        }
        if (this.nQM == null || !this.nQM.isShowing()) {
            return dZz() || dZy() || dMI();
        }
        this.nQM.dismiss();
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
        this.nKt.setVisibility(8);
        this.nKz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(boolean z, boolean z2) {
        if (this.nKt != null) {
            if (z) {
                if (this.nKt.getVisibility() != 0) {
                    this.nKt.setVisibility(0);
                    this.nKt.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_bottom_anim));
                }
            } else if (this.nKt.getVisibility() != 4) {
                this.nKt.setVisibility(4);
                this.nKt.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nKl != null) {
            this.nKl.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dZH() {
        return this.nLi;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.nQk != null) {
                        this.nQk.f = null;
                        this.nQk.dZc().mRoominfo.mGameId = null;
                    }
                    dZu();
                    return;
                }
                g.OF(a.i.str_getvideosource_failed);
            }
            yw(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.nQk != null && this.nQk.dZd() != null) {
            a(this.nQk.dZd());
        }
        this.p = false;
        if (this.nQk == null || this.nQk.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nQk.f.size()) {
                if (!"2".equals(this.nQk.f.get(i2).mType)) {
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
        if (this.nKc != null) {
            this.nKc.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nKo != null && this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                this.nKo.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.nQk.dZc().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.nLb && (c = c(1, -1)) >= 0 && c < this.nLa.size() && this.nKU != null) {
            this.nKU.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nLb) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nQl, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dYK = ((VideoPlayer) this.nQl).dYK();
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(2, dYK);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dYL = ((VideoPlayer) this.nQl).dYL();
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(2, dYL);
            } else if (bVar.a == 9) {
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nKO != null) {
            this.nKO.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nLb) {
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
        if (!aa() && this.nQk != null) {
            String str = this.nQk.a;
            RoomInfo dZe = this.nQk.dZe();
            if (dZe != null && mVar.a(dZe.mCreatorUID, str)) {
                dZe.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nKA != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nKA);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
            if (this.nKX == null) {
                this.nKX = new f(getActivity());
            }
            this.nKX.a(this.nQk.dZc().mRoominfo);
            if (!this.nKX.isShowing()) {
                this.nKX.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nKc != null) {
            this.nKc.d();
        }
    }

    private void e(View view) {
        this.nKp = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nKq = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nKq.setText(new tv.chushou.zues.widget.a.c().L(this.nQl, a.e.videoplayer_4g_video).append("  ").append(this.nQl.getString(a.i.videoplayer_4g_video)));
        this.nKr = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nKr.setText(new tv.chushou.zues.widget.a.c().L(this.nQl, a.e.videoplayer_4g_audio).append("  ").append(this.nQl.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nKp.setVisibility(8);
                    ((VideoPlayer) a.this.nQl).c(a.this.nKs);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nKp.setVisibility(8);
                    ((VideoPlayer) a.this.nQl).d(a.this.nKs);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dYj().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nKq.setOnClickListener(onClickListener);
        this.nKr.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nQk != null && !h.isEmpty(this.nQk.f)) {
            f(this.nQk.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nKs = z;
            this.p = false;
            if (this.nQk != null && this.nQk.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nQk.f.size()) {
                        break;
                    } else if (!"2".equals(this.nQk.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nKp != null) {
                this.nKp.setVisibility(0);
                this.nKq.setVisibility(0);
                this.nKr.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nKp != null) {
            this.nKp.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nLm == null) {
                this.nLm = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.nQm != null) {
                    this.nQm.e(this.nLm, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nLm != null && this.nQm != null) {
            this.nQm.L(this.nLm);
            this.nLm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nKc != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nQl, "显示双击666_num", null, new Object[0]);
            if (this.nQk != null) {
                this.nQk.b(false);
            }
            d(false);
            this.nKc.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.nPW != null) {
            if (this.nLd == null) {
                this.nLd = (InteractionView) ((ViewStub) this.nPW.findViewById(a.f.view_interaction)).inflate();
                this.nLd.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.nLd.a();
                    }
                });
            }
            if (this.nLd != null) {
                this.nLd.b(configDetail);
                this.nLd.c();
                this.nLd.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.emh()) {
                g.H(this.nQl, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nQl, null) && (this.nQl instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQl, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQl, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nQl, configDetail.mUrl, this.nQl.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nQl, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    dZI();
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

    private void dZI() {
        if (this.nKW) {
            dZz();
            return;
        }
        if (this.nQl.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击送礼_num", "竖屏", new Object[0]);
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQk.dZc().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nQl != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nJN == null) {
                this.nJN = new com.kascend.chushou.player.e.a();
            }
            this.nJN.b = str;
            this.nJN.nME.copy(pkNotifyInfo);
            if (this.nJN.nME.mAction == 6) {
                this.nJN.nME.mInPKMode = true;
                this.u = this.nJN.nME.mPkId;
            } else if (this.nJN.nME.mAction == 7 || (this.nJN.nME.mMode == 1 && this.nJN.nME.mAction == 5)) {
                this.nJN.nME.mInPKMode = true;
                this.u = this.nJN.nME.mPkId;
                if (dZK() != null) {
                    if (2 == this.bB && this.nLp != null) {
                        this.nLp.setVisibility(0);
                    }
                    dZK().b(this.nJN.nME, false);
                    dZK().a(this.nJN.nME.mMode, "1");
                    if (this.nJN.nME.mAction == 5 && this.nJN.nME.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nJN.nME.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nJN.nME.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nJN.nME.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nJN.nME.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nJN.nME.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dZK().a(this.nJN.nME);
                        if (this.nJN.nME.destinyInfo == null || this.nJN.nME.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dZK().a(parseInt, this.nJN.nME.mPkUpdateInfo.remainDuration, j, this.nJN.nME.mMode, i);
                    }
                    if (!h.isEmpty(this.nJN.nME.mPkUpdateInfo.specialMomentList) && dZK() != null) {
                        dZK().a(this.nJN.nME, true);
                    }
                }
                dZJ();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Va(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.nJN.nME.mInPKMode = false;
                dZJ();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Va(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dZJ() {
        if (this.nJN != null && this.nJN.nME != null) {
            if (this.nJN.nME.mInPKMode) {
                this.y.setText(this.nJN.nME.mPkUserNickname);
                this.nJP.setVisibility(0);
                if (this.nQb != null) {
                    this.nQb.setEnabled(false);
                }
                if (this.nQd != null) {
                    this.nQd.setEnabled(false);
                    return;
                }
                return;
            }
            this.nJP.setVisibility(8);
            if (this.nQb != null) {
                this.nQb.setEnabled(true);
            }
            if (this.nQd != null) {
                this.nQd.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dZK() {
        if (this.nQl == null || this.nPW == null || this.nLp == null) {
            return null;
        }
        if (this.nJO == null) {
            if (this.nLo == null) {
                this.nLo = ((ViewStub) this.nPW.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.nJO = new com.kascend.chushou.player.e.b();
            this.nJO.a(this.nLp, this.nLo, (View) null, this.nQl, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cvD()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.nQk != null) {
                        append.append(a.this.nQk.dZe().mRoomID);
                    }
                    if (a.this.nJN != null && a.this.nJN.nME != null) {
                        append.append("&mode=").append(a.this.nJN.nME.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nQl, append.toString());
                }
            });
        }
        return this.nJO;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nKL != null && this.nQk != null && this.nQk.nJv != null) {
            this.nKL.setText(tv.chushou.zues.utils.b.OE(this.nQk.nJv.count));
            this.nKL.setVisibility(0);
            if (this.nQk.nJv.count < 1) {
                dZN();
            }
            if (this.nKD != null) {
                this.nKD.setText(this.nQk.nJv.primaryName);
            }
            if (this.nKE != null) {
                this.nKE.setText(this.nQk.nJv.desc);
            }
            dZL();
        }
    }

    public void dZL() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nKM * h.parseLong(this.nQk.nJv.point)));
        if (this.nKG != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nQl.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.L(this.nQl, a.e.icon_coin_new);
            cVar.append(this.nQl.getString(a.i.str_buy_count_coin2));
            this.nKG.setText(cVar);
        }
    }

    private void dZM() {
        if (com.kascend.chushou.d.e.c(this.nQl, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nKM);
        }
    }

    private void v(boolean z) {
        if (this.nPW != null && this.nLp != null) {
            if (z) {
                if (this.nJN != null && this.nJN.nME != null && this.nJN.nME.mInPKMode) {
                    this.nLp.setVisibility(0);
                    return;
                }
                return;
            }
            this.nLp.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nPW != null && this.nJS != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nJS.setVisibility(0);
                    return;
                }
                return;
            }
            this.nJS.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.nJN != null && this.nJN.nME != null && this.nJN.nME.mInPKMode && this.nJP != null) {
                this.nJP.setVisibility(0);
            }
        } else if (this.nJP != null) {
            this.nJP.setVisibility(8);
        }
    }

    private void dZN() {
        this.nKN = false;
        this.nKK.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nQk != null && this.nQk.nJv != null) {
            if (this.nQk.nJv.count < 1) {
                this.nKL.setVisibility(8);
            } else {
                this.nKL.setVisibility(0);
                this.nKL.setSelected(false);
                this.nKL.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nKC.setVisibility(8);
        if (this.nKA != null) {
            this.nKA.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dZI();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nKy != null) {
            this.nKy.performClick();
        }
    }

    public boolean dZO() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.nLB = true;
        if (this.nPW != null && com.kascend.chushou.b.dYj().d == 0) {
            this.nLk = tv.chushou.zues.utils.systemBar.b.ha(getActivity());
            if (!z) {
                View findViewById = this.nPW.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.nLk = tv.chushou.zues.utils.systemBar.b.ha(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.nLk);
            View findViewById2 = this.nPW.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.nLk);
            findViewById2.requestLayout();
        }
    }
}
