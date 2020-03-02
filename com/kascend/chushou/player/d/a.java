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
    private boolean bR;
    private int[] mRD;
    private Fragment[] mRE;
    private ImageView mRJ;
    private MarqueeTextView mRK;
    private MarqueeTextView mRL;
    private ImageView mRM;
    private ImageView mRN;
    private ImageButton mRO;
    public String mRP;
    private RecommendView mRQ;
    private TextView mRT;
    private RelativeLayout mRU;
    private TextView mRV;
    private TextView mRW;
    private RelativeLayout mRX;
    private View mRY;
    private FrescoThumbnailView mRZ;
    private PagerSlidingTabStrip mSA;
    private KasViewPager mSB;
    private LinearLayout mSD;
    private f mSG;
    private ViewMicPerson mSH;
    public ArrayList<RoomTab> mSJ;
    private PopH5Menu mSM;
    private InteractionView mSN;
    private int mSO;
    private PopupWindow mSQ;
    private TextView mSR;
    private GiftAnimationLayout mSS;
    private com.kascend.chushou.player.b.a mST;
    private Runnable mSX;
    private View mSZ;
    private AnimationSet mSa;
    private ImageView mSb;
    private TextView mSc;
    private RelativeLayout mSd;
    private PastedEditText mSe;
    private TextView mSf;
    private LinearLayout mSg;
    private TextView mSh;
    private TextView mSi;
    private TextView mSj;
    private TextView mSl;
    private TextView mSm;
    private TextView mSn;
    private TextView mSo;
    private ImageView mSq;
    private TextView mSr;
    private KPSwitchPanelLinearLayout mSu;
    private ImageView mSv;
    private c mSx;
    private d.a mSy;
    private FrescoThumbnailView mSz;
    private LivePKBarUserValue mTa;
    private String mTb;
    private TextView mTc;
    private ImageView mTd;
    private EditText mTe;
    private View mTf;
    private View mTg;
    private View mTh;
    private String mTl;
    private long mRC = 0;
    private com.kascend.chushou.view.user.a mRF = null;
    private com.kascend.chushou.player.ui.a mRG = null;
    private int mRH = -1;
    private int Sw = 0;
    private View mRI = null;
    private View mRR = null;
    private ImageButton mRS = null;
    private int mSs = 1;
    private boolean mSt = false;
    private boolean mSw = false;
    private boolean mSE = false;
    private boolean mSF = false;
    private boolean mSI = false;
    private boolean mSK = false;
    private boolean mSL = true;
    private int mSU = 0;
    private int mSV = 0;
    private int mSW = -1;
    private final Rect mSY = new Rect();
    private boolean mTi = false;
    private C0696a mTk = null;
    private boolean da = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRP = getArguments().getString("mCover");
        this.mSL = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXQ = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mXQ;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dDO()) {
            c(view);
            dCN();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.mSK = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mYL != null) {
            this.mYL.b();
        }
        if (this.mYg != null && (this.mYg instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYg).wh(true);
            ((VideoPlayer) this.mYg).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSK = true;
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
        this.mSs = 1;
        this.mSt = false;
        U();
        if (this.mYh != null) {
            this.mYh.cq(null);
            this.mYh = null;
        }
        if (this.mRQ != null) {
            dDP().removeAllViews();
            this.mRQ = null;
        }
        this.c = null;
        this.mRo = null;
        tv.chushou.zues.a.a.cr(this);
        this.mSA = null;
        this.mSB = null;
        this.mRG = null;
        this.mRF = null;
        if (this.mRE != null) {
            for (int i = 0; i < this.mRE.length; i++) {
                this.mRE[i] = null;
            }
        }
        this.mRE = null;
        if (this.mSe != null) {
            this.mSe.addTextChangedListener(null);
            this.mSe.setOnTouchListener(null);
            this.mSe.setOnEditorActionListener(null);
            this.mSe = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mYg, this.mSx);
        if (this.mYg != null && (this.mYg instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYg).dCi();
        }
        this.mSy = null;
        this.mSx = null;
        if (this.mSH != null) {
            this.mSH.b();
            this.mSH = null;
        }
        if (this.mSQ != null) {
            this.mSQ.dismiss();
        }
        if (this.mST != null) {
            this.mST.a();
            this.mST = null;
            this.mSS = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mTa = (LivePKBarUserValue) this.mXQ.findViewById(a.f.live_pk_bar_user);
        this.mXZ = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mTi) {
            this.mTi = true;
            if (this.mTg == null) {
                this.mTg = this.mXQ.findViewById(a.f.vs_async_view);
                this.mTg = ((ViewStub) this.mTg).inflate();
            }
            if (this.mTh == null) {
                this.mTh = this.mXQ.findViewById(a.f.vs_async_notification_view);
                this.mTh = ((ViewStub) this.mTh).inflate();
            }
            this.mRy = (VoiceInteractionView) this.mXQ.findViewById(a.f.voiceInteractiveView);
            t();
            dA(this.mXQ);
            cXM();
            ((VideoPlayer) this.mYg).q();
            this.mRt = new com.kascend.chushou.player.e.a();
        }
    }

    private void dA(View view) {
        this.mSz = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mSA = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mSB = (KasViewPager) view.findViewById(a.f.vp_main);
        dCO();
        dCP();
        dCU();
        if (this.mYf != null) {
            I();
            a(this.mYf.mQZ, this.mYf.mRe);
        }
        this.aSy = 0;
        this.mYQ = 0L;
        this.mYM = (RoundProgressBar) this.mXQ.findViewById(a.f.roundProgressBar);
        this.mYN = (TextView) this.mXQ.findViewById(a.f.tv_paonum);
        this.mYO = (FrescoThumbnailView) this.mXQ.findViewById(a.f.iv_paoicon);
        this.mYV = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.mSE = false;
                if (a.this.mRH == 2) {
                    a.this.av(true, a.this.i());
                } else {
                    a.this.dDn();
                }
                a.this.b(a.this.mSO, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.mSE = true;
                if (a.this.mRH == 2) {
                    a.this.av(false, a.this.i());
                } else {
                    a.this.dDn();
                }
                if (a.this.mYL != null) {
                    a.this.mYL.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hd(a.this.mYg).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mYg)) - a.this.mYL.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mYg, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mYg, 54.0f) * 2);
                    if (statusBarHeight < a.this.mSO) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mYP = (PaoGuideView) this.mXQ.findViewById(a.f.rlPaoGuideView);
        this.mSH = (ViewMicPerson) this.mXQ.findViewById(a.f.rl_mic_person_view);
    }

    private void dCN() {
        this.mUu = ((VideoPlayer) this.mYg).dCc();
        this.mYf = ((VideoPlayer) this.mYg).dCf();
        dB(this.mXQ);
        this.mSU = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
        this.mSV = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (com.kascend.chushou.b.dBN().d == 0 && this.mSV > 0) {
            View findViewById = this.mXQ.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mSV);
        }
        dCZ();
        dCX();
        if (!this.mSL) {
            Q();
        }
        dCV();
        a();
        if (this.c == null) {
            this.mRo = new d.a();
            this.c = new GestureDetector(this.mYg, this.mRo);
        }
        this.mRq = ((VideoPlayer) this.mYg).dCg();
        this.mRq.a(this);
        if (this.mST != null) {
            this.mST.a();
            this.mST = null;
        }
        this.mSS = (GiftAnimationLayout) this.mXQ.findViewById(a.f.ll_gift_animation);
        this.mSS.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mYf != null) {
            this.mST = new com.kascend.chushou.player.b.a(this.mYg.getApplicationContext(), this.mSS);
            this.mST.a(this.mYf);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mXQ.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mYa = (PlayerErrorView) this.mXQ.findViewById(a.f.view_net_error_msg);
        this.mYa.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dCS();
        dDf();
        if (this.mYf.dCF() != null) {
            a(this.mYf.dCF());
        }
        FullRoomInfo dCE = this.mYf.dCE();
        if (dCE != null) {
            dDi();
            if (i()) {
                this.ak = false;
                wo(true);
                this.mYh.Of(8);
            }
            this.mRT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dCE.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mRI.setVisibility(0);
        this.ak = false;
        wo(true);
        this.mYh.Of(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mYg).n();
        if (this.mYf != null && !h.isEmpty(this.mYf.mRb)) {
            b(this.mYf.mRb);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dCp;
        dCO();
        k();
        FullRoomInfo dCE = this.mYf.dCE();
        if (dCE != null) {
            if (dCE.mRoominfo != null) {
                this.mRT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dCE.mRoominfo.mOnlineCount)));
                this.mTb = dCE.mRoominfo.mRoomID;
            }
            dDi();
            if (!h.isEmpty(dCE.mRoomToastList)) {
                Iterator<RoomToast> it = dCE.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dBU().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mYf != null && this.mYf.l()) {
                d(true);
            }
            if (this.mYg != null && (this.mYg instanceof VideoPlayer) && (dCp = ((VideoPlayer) this.mYg).dCp()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dCp.mUv, dCp.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mSD);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dCO() {
        boolean z = true;
        if (this.mYf == null || this.mYf.dCE() == null || this.mYf.dCE().mRoominfo == null || h.isEmpty(this.mYf.dCE().mRoomTabs)) {
            this.mSI = false;
            this.mRE = new Fragment[2];
            this.mRD = new int[2];
            this.mRD[0] = 2;
            this.mRD[1] = 1;
            return;
        }
        this.mSI = true;
        this.mSJ = new ArrayList<>();
        Iterator<RoomTab> it = this.mYf.dCE().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mSJ.add(next);
            }
        }
        if (this.mSJ.size() >= 2 && this.mRD != null && this.mRD.length >= 2 && this.mSJ.get(0).type == this.mRD[0] && this.mSJ.get(1).type == this.mRD[1]) {
            z = false;
        }
        this.mRE = new Fragment[this.mSJ.size()];
        this.mRD = new int[this.mSJ.size()];
        for (int i = 0; i < this.mSJ.size(); i++) {
            this.mRD[i] = this.mSJ.get(i).type;
        }
        if (z) {
            this.mTk = new C0696a(getChildFragmentManager());
            this.mSB.setAdapter(this.mTk);
        }
    }

    private void dCP() {
        this.mSd = (RelativeLayout) this.mXQ.findViewById(a.f.rl_edit_bar);
        this.mRZ = (FrescoThumbnailView) this.mXQ.findViewById(a.f.btn_hotword);
        this.mRZ.xo(a.e.ic_hotwords_black_n);
        this.mRZ.setOnClickListener(this);
        this.mSb = (ImageView) this.mXQ.findViewById(a.f.iv_task_badge);
        this.mSa = (AnimationSet) AnimationUtils.loadAnimation(this.mYg, a.C0690a.anim_hotword);
        this.mSa.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dBU().c) {
                    a.this.mRZ.clearAnimation();
                    a.this.mRZ.startAnimation(a.this.mSa);
                }
            }
        });
        if (com.kascend.chushou.d.h.dBU().c) {
            this.mRZ.startAnimation(this.mSa);
            this.mSb.setVisibility(0);
        }
        this.mSc = (TextView) this.mXQ.findViewById(a.f.tv_bottom_input);
        this.mSc.setOnClickListener(this);
        this.mZf = (FrescoThumbnailView) this.mXQ.findViewById(a.f.ll_btn_set);
        this.mZf.setOnClickListener(this);
        this.mSD = (LinearLayout) this.mXQ.findViewById(a.f.ll_bottom_all_button);
        this.mRX = (RelativeLayout) this.mXQ.findViewById(a.f.rl_bottom_input);
        this.mRY = this.mXQ.findViewById(a.f.ll_bottom_input);
        this.mRX.setVisibility(8);
        this.mSe = (PastedEditText) this.mXQ.findViewById(a.f.et_bottom_input);
        this.mSe.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mSf.setEnabled(editable.length() > 0);
            }
        });
        this.mSe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mSf);
                    return true;
                }
                return true;
            }
        });
        this.mSe.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.mSe);
                }
                return false;
            }
        });
        this.mSv = (ImageView) this.mXQ.findViewById(a.f.iv_btn_emoji);
        this.mSv.setVisibility(8);
        this.mSf = (TextView) this.mXQ.findViewById(a.f.tv_btn_send);
        this.mSf.setOnClickListener(this);
        this.mSu = (KPSwitchPanelLinearLayout) this.mXQ.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dBN().d == 0) {
            this.mSu.setUseStatusBar(true);
        }
        this.mSg = (LinearLayout) this.mXQ.findViewById(a.f.head_trumpet);
        this.mSg.setVisibility(8);
        this.mSg.setOnClickListener(this);
        this.mSh = (TextView) this.mXQ.findViewById(a.f.tv_primary_name);
        this.mSi = (TextView) this.mXQ.findViewById(a.f.tv_primary_desc);
        this.mSm = (TextView) this.mXQ.findViewById(a.f.tv_cut_count);
        this.mSm.setOnClickListener(this);
        this.mSo = (TextView) this.mXQ.findViewById(a.f.tv_head_count);
        this.mSo.setText(this.mSs + "");
        this.mSn = (TextView) this.mXQ.findViewById(a.f.tv_plus_count);
        this.mSn.setOnClickListener(this);
        this.mSl = (TextView) this.mXQ.findViewById(a.f.tv_buy_count_coin);
        this.mSj = (TextView) this.mXQ.findViewById(a.f.tv_buy_head);
        this.mSj.setOnClickListener(this);
        this.mSq = (ImageView) this.mXQ.findViewById(a.f.iv_trumpet_select);
        this.mSq.setOnClickListener(this);
        this.mSr = (TextView) this.mXQ.findViewById(a.f.tv_trumpet_have_count);
        this.mSt = false;
        this.mSq.setBackgroundResource(a.e.ic_trumpet_n);
        this.mSr.setVisibility(8);
        dCR();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mSu, this.mSv, this.mSe, new a.InterfaceC0817a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0817a
            public void wi(boolean z) {
                if (a.this.mSv != null) {
                    if (!z) {
                        a.this.mSv.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dBN().d == 0) {
                        a.this.mSu.setDirectVisibility(0);
                    }
                    a.this.mSv.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mSy = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wj(boolean z) {
                a.this.mSw = z;
                if (z) {
                    a.this.mSv.setImageResource(a.e.cs_emoji_normal);
                    a.this.dCQ();
                    return;
                }
                if (a.this.mTf != null && a.this.mTf.getVisibility() == 0) {
                    a.this.mTf.setVisibility(8);
                }
                if (a.this.mSE) {
                    a.this.mYL.setVisibility(0);
                }
                if (a.this.mYg != null && (a.this.mYg instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mYg).wh(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mSx = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mSu, this.mSy, ((VideoPlayer) this.mYg).dCj());
        ((VideoPlayer) this.mYg).g(((VideoPlayer) this.mYg).dCj());
        this.mTf = this.mXQ.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mTc = (TextView) this.mXQ.findViewById(a.f.btn_room_search);
        this.mTd = (ImageView) this.mXQ.findViewById(a.f.iv_room_emoji_delete);
        this.mTe = (EditText) this.mXQ.findViewById(a.f.et_room_emoji_search);
        this.mTe.setImeOptions(3);
        this.mTe.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mTc);
                    return true;
                }
                return false;
            }
        });
        this.mTe.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mTc.setEnabled(editable.length() > 0);
                a.this.mTd.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mYL.setEmojiSearchText(editable.toString());
            }
        });
        this.mTc.setOnClickListener(this);
        this.mTd.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mTe);
            this.mTf.setVisibility(0);
            this.mTe.requestFocus();
        } else {
            this.mTf.setVisibility(8);
        }
        if (z2) {
            this.mTe.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCQ() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hd(this.mYg).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg)) - tv.chushou.zues.widget.kpswitch.b.d.ho(this.mYg)) - tv.chushou.zues.utils.a.dip2px(this.mYg, 14.0f)) - this.mYg.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mYg, 54.0f) * 2);
        if (statusBarHeight < this.mSO) {
            b(statusBarHeight, 10);
        }
    }

    private void dCR() {
    }

    private void dCS() {
        this.mYh = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.au(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mXQ.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mYg.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mYh.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mYh.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mYh.K(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mYh);
                            break;
                        case 12:
                            a.this.b(a.this.mYh);
                            break;
                        case 17:
                            a.this.dDR();
                            break;
                        case 18:
                            a.this.cXL();
                            break;
                        case 19:
                            a.this.mYe.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dCT() {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mSJ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSJ.size()) {
                    if (!h.isEmpty(this.mSJ.get(i2).notifyIcon)) {
                        this.mSA.bl(i2, this.mSJ.get(i2).notifyIcon);
                        this.mSA.OC(i2);
                    } else if (this.mSJ.get(i2).notify == 1) {
                        this.mSA.OB(i2);
                        this.mSA.OA(i2);
                    } else {
                        this.mSA.OA(i2);
                        this.mSA.OC(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mSJ)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mSJ.size()) {
                    if (this.mSJ.get(i4).type == i) {
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
    public String MK(int i) {
        if (this.mYf == null || this.mYf.dCE() == null || this.mYf.dCE().mRoominfo == null || h.isEmpty(this.mSJ)) {
            if (i == 1) {
                return this.mYg.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mYg.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mSJ.size()) {
            return this.mSJ.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mSJ) && i < this.mSJ.size()) {
            this.mSJ.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mSJ) && i < this.mSJ.size()) {
            this.mSJ.get(i).notifyIcon = str;
        }
    }

    private void dCU() {
        if (this.mSB != null && this.mSA != null && this.mRD != null) {
            this.mRG = null;
            if (this.mRE != null) {
                for (int i = 0; i < this.mRE.length; i++) {
                    this.mRE[i] = null;
                }
            }
            if (this.mTk == null) {
                this.mTk = new C0696a(getChildFragmentManager());
                this.mSB.setAdapter(this.mTk);
            } else {
                this.mTk.notifyDataSetChanged();
            }
            this.mSB.setOffscreenPageLimit(this.mRD.length);
            this.mSA.c(this.mSB);
            this.mSA.setOnPageChangeListener(this);
            this.mSA.notifyDataSetChanged();
            this.mSA.setVisibility(0);
            this.mSB.setVisibility(0);
            if (!this.mSI) {
                this.mRH = 2;
                this.mSB.setCurrentItem(c(2, 0));
                this.mRX.setVisibility(0);
            } else {
                if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                    if (!h.isEmpty(this.mYf.dCE().mRoominfo.mGameName)) {
                        this.mRL.setText(this.mYf.dCE().mRoominfo.mGameName);
                    } else {
                        this.mRL.setText(this.mYg.getString(a.i.no_online_game_name));
                    }
                    this.mRK.setText(this.mYf.dCE().mRoominfo.mName);
                } else {
                    this.mRL.setText(this.mYg.getString(a.i.no_online_game_name));
                }
                dCT();
                if (i()) {
                    dDg();
                    if (this.mSB != null) {
                        this.mRH = 2;
                        int c = c(2, 0);
                        this.mSB.setCurrentItem(c);
                        this.mSA.setSelectItem(c);
                    }
                } else if (this.mSB != null) {
                    this.mRH = 1;
                    int c2 = c(1, 1);
                    this.mSB.setCurrentItem(c2);
                    this.mSA.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dCV() {
        this.N = new SurfaceView(this.mYg);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mYk);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dDP().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dCW() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mYg).s();
        cXS();
        dDa();
        dDb();
        dDP().setBackgroundResource(a.e.room_not_online);
        if (this.mRQ == null) {
            this.mRQ = new RecommendView(this.mYg);
            dDP().addView(this.mRQ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mYg);
            this.mRQ.setLayoutParams(layoutParams);
        }
        if (this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mYf.dCE().mRoominfo.mRoomID)) {
            this.mRQ.a(this.mYf.dCE().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dDO() && a.this.mYg != null && a.this.dDP() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mYg);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lMT);
                        if (a.this.dDP().getChildCount() >= 2) {
                            a.this.dDP().addView(frescoThumbnailView, 0);
                        }
                        a.this.dDP().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dQk(), a.this.ar, a.this.mYk);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYT != null) {
            this.mYT.dPE();
            this.mYT.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mYL != null) {
            this.mYL.e();
        }
        wo(false);
        a(false, false);
        if (this.mRq != null) {
            this.mRq.d();
        }
    }

    private void dCX() {
        int i = 0;
        this.mRI = this.mXQ.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dBN().d == 0 && this.mSU > 0) {
            View findViewById = this.mXQ.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.mSU;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mRJ = (ImageView) this.mRI.findViewById(a.f.back_icon);
        this.mRJ.setOnClickListener(this);
        this.mRK = (MarqueeTextView) this.mRI.findViewById(a.f.tv_title);
        this.mRL = (MarqueeTextView) this.mRI.findViewById(a.f.tv_Type);
        this.mRN = (ImageView) this.mXQ.findViewById(a.f.btn_setting);
        this.mRR = this.mXQ.findViewById(a.f.bottomview);
        if (this.mXX == null) {
            this.mXX = (ImageButton) this.mRR.findViewById(a.f.btn_barrage);
            this.mXX.setOnClickListener(this);
            if (this.mYf != null) {
                if (com.kascend.chushou.d.h.dBU().n()) {
                    this.mXX.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXX.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mXY = (ImageButton) this.mRR.findViewById(a.f.btn_audio);
        this.mXY.setOnClickListener(this);
        if (this.mYf != null && this.mYf.d) {
            this.mXY.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mXY.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mYf != null && this.mYf.f != null) {
            while (true) {
                if (i >= this.mYf.f.size()) {
                    break;
                } else if (!"2".equals(this.mYf.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mRS = (ImageButton) this.mRR.findViewById(a.f.playbutton);
        this.mRS.setOnTouchListener(this);
        this.mRO = (ImageButton) this.mRR.findViewById(a.f.btn_refresh);
        this.mRO.setOnClickListener(this);
        this.mRT = (TextView) this.mRR.findViewById(a.f.tv_online_count);
        if (this.mXW == null) {
            this.mXW = (ImageButton) this.mRR.findViewById(a.f.btn_screenChange);
            this.mXW.setOnClickListener(this);
        }
        if (this.mRM == null) {
            this.mRM = (ImageView) this.mRI.findViewById(a.f.report_icon);
            this.mRM.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dDp();
                    }
                }
            });
        }
    }

    private boolean j(ArrayList<FanItem> arrayList, String str) {
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
        if (!dDO() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mRG != null) {
                        this.mRG.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                        this.mYf.dCE().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mYf.dCE().mMicStatus.onMic) {
                            dDh();
                        }
                        if (this.mYf.dCE().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mYf.dCE().mRoominfo.mCreatorUID)) {
                                i(arrayList2, this.mYf.dCE().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mYf.dCE().mMicStatus.onMic) {
                            this.mYf.dCE().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mYf.dCE().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = j(this.mYf.dCE().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mYf.dCE().mMicStatus != null && !h.isEmpty(this.mYf.dCE().mMicStatus.micRoomId) && !this.mYf.dCE().mMicStatus.micRoomId.equals("0")) {
                                this.mTl = this.mYf.dCE().mMicStatus.micRoomId;
                            }
                            if (this.mRG != null) {
                                this.mRG.a(this.mYf.dCE().mMicStatus, this.mYf.dCE().mFanItems, str, z2);
                            }
                            if (this.mSH != null && this.mSH.getVisibility() == 0) {
                                this.mSH.a(this.mYf.dCE().mFanItems, this.mYf.dCE().mMicStatus, str, z2, this.mYf.dCE().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mRG != null) {
                                this.mRG.e();
                            }
                            if (this.mSH != null && this.mSH.isShown()) {
                                this.mSH.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mRG != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mRG.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mRG.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mSW != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mSW = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mRt != null && this.mRt.mUv != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mRt.mUv.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mRt.mUv.mInPKMode = true;
                                    this.mRt.mUv.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRt.mUv.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRt.mUv.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRt.mUv.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRt.mUv.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRt.mUv.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mRt.mUv.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mRt.mUv.mMode = pkNotifyInfo.mMode;
                                    this.mRt.mUv.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dDt() != null) {
                                        dDt().g(true, this.mRt.mUv.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dBU().a) {
                                        if (!com.kascend.chushou.b.dBN().e) {
                                            com.kascend.chushou.b.dBN().e = true;
                                            g.M(this.mYg, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBU().a(this.mYg, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.mRH && this.mTa != null) {
                                        this.mTa.setVisibility(0);
                                    }
                                    this.mRt.mUv.mAction = 7;
                                    this.mRt.mUv.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRt.mUv.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRt.mUv.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRt.mUv.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRt.mUv.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRt.mUv.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dDs();
                                    if (dDt() != null) {
                                        dDt().g(false, 0L);
                                        dDt().b(this.mRt.mUv, true);
                                        dDt().a(this.mRt.mUv.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.QV(this.mTb);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mRt.mUv.mInPKMode = false;
                                    this.mRt.mUv.mAction = 2;
                                    dDs();
                                    if (dDt() != null) {
                                        dDt().c();
                                    }
                                    if (com.kascend.chushou.d.h.dBU().a) {
                                        if (!com.kascend.chushou.b.dBN().e) {
                                            com.kascend.chushou.b.dBN().e = true;
                                            g.M(this.mYg, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBU().a(this.mYg, false);
                                        ak();
                                    }
                                    this.mRt.b = null;
                                    this.mRt.mUv = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.QV(this.mTb);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mRt.mUv.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mRt.mUv.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mRt.mUv.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mYf.dCE().mRoominfo.mRoomID) && this.mYf.dCE().mRoominfo.mRoomID.equals(this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dDt() != null) {
                                        dDt().a(this.mRt.mUv, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mRt.mUv.copyUpdate(pkNotifyInfo);
                                    if (dDt() != null) {
                                        dDt().a(this.mRt.mUv);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mRt.mUv.copyStop(pkNotifyInfo);
                                        if (dDt() != null) {
                                            dDt().w(this.mRt.mUv.mMaxFreeDuration, this.mRt.mUv.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mRt.mUv.copyResult(pkNotifyInfo);
                                    if (!this.mSK && dDt() != null) {
                                        int i5 = 1;
                                        if (this.mRt.mUv.destinyInfo != null && this.mRt.mUv.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dDt().a(h.parseInt(this.mRt.mUv.mResult), h.parseLong(this.mRt.mUv.mvpUid), this.mRt.mUv.mvpAvatar, this.mRt.mUv.mvpNickname, this.mRt.mUv.mMaxFreeDuration, this.mRt.mUv.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mRG != null) {
                if (LoginManager.Instance().islogined() && this.mYf != null && this.mYf.l()) {
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
                if (this.mYf == null || this.mYf.dCE() == null || this.mYf.dCE().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mYf.dCE().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dBU().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dBU().b().equals(next2.mUserID)) {
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
                this.mRG.a(arrayList, true, false);
                this.mRG.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mRD != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mRD.length) {
                    break;
                }
                if (this.mRD[i2] == 99 && this.mRE != null && this.mRE[i2] != null && (this.mRE[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mRE[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mSJ.size() && this.mSA != null) {
                if (i == 0) {
                    this.mSA.setTagText(i2, new StringBuilder(this.mSJ.get(i2).name).toString());
                    return;
                } else {
                    this.mSA.setTagText(i2, this.mSJ.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
    protected void q(boolean z) {
        if (this.mXX != null) {
            if (z) {
                this.mXX.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXX.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dCY() {
        if (this.mXQ == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXQ.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
        this.ar = Math.min(hd.x, hd.y);
        this.mYk = (this.ar * this.mYg.getResources().getInteger(a.g.h_thumb_height_def)) / this.mYg.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dDP().getLayoutParams();
        layoutParams.height = this.mYk;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXZ.getLayoutParams();
        layoutParams2.height = this.mYk;
        layoutParams2.width = this.ar;
        this.mSO = this.mYk + this.mYg.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mYg, 54.0f);
        b(this.mSO, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mYk);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dCZ() {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
        this.ar = Math.min(hd.x, hd.y);
        this.mYk = (this.ar * this.mYg.getResources().getInteger(a.g.h_thumb_height_def)) / this.mYg.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dDP().getLayoutParams();
        layoutParams.height = this.mYk;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXZ.getLayoutParams();
        layoutParams2.height = this.mYk;
        layoutParams2.width = this.ar;
        this.mSO = this.mYk + this.mYg.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mYg, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.mSO, 10);
        k();
        if (!h.isEmpty(this.mRP)) {
            File ad = tv.chushou.zues.widget.fresco.a.ad(Uri.parse(this.mRP));
            if (ad != null && ad.exists()) {
                this.mXZ.setImageURI(Uri.fromFile(ad));
                this.mXZ.setVisibility(0);
                return;
            }
            this.mXZ.setVisibility(8);
            return;
        }
        this.mXZ.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void s(boolean z) {
        if (this.mRM != null) {
            this.mRM.setVisibility(z ? 0 : 4);
        }
        if (this.mRN != null) {
            this.mRN.setVisibility(z ? 0 : 4);
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
        if (this.mYh != null) {
            this.mYh.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mYg).e(true);
            if (!z3) {
                if (this.mRR.getVisibility() != 0 && z2) {
                    this.mRR.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mXY.setVisibility(0);
                } else {
                    this.mXY.setVisibility(8);
                }
                this.mRR.setVisibility(0);
            }
            PlayUrl dCF = this.mYf.dCF();
            if (dCF != null && "2".equals(dCF.mType)) {
                if (this.mXW != null) {
                    this.mXW.setVisibility(8);
                }
            } else if (this.mXW != null) {
                this.mXW.setVisibility(0);
            }
            if (this.mRI.getVisibility() != 0 && z2) {
                this.mRI.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_top_anim));
            }
            s(!z3);
            this.mRI.setVisibility(0);
            v(true);
            if (this.mYh != null) {
                this.mYh.K(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mYg).e(false);
            if (this.mYx != null) {
                this.mYx.dismiss();
            }
            if (this.mYy != null) {
                this.mYy.dismiss();
            }
            if (this.mRR.getVisibility() != 8 && z2) {
                this.mRR.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_bottom_anim));
            }
            this.mRR.setVisibility(8);
            if (this.mRI.getVisibility() != 8 && z2) {
                this.mRI.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_top_anim));
            }
            this.mRI.setVisibility(8);
            v(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean cXS() {
        if (this.mYP == null || !this.mYP.isShown()) {
            return false;
        }
        this.mYP.d();
        return true;
    }

    public boolean dDa() {
        if (this.mSH == null || !this.mSH.isShown()) {
            return false;
        }
        this.mSH.a();
        return true;
    }

    public boolean dDb() {
        if (this.mSM == null || !this.mSM.b()) {
            return false;
        }
        this.mSM.a();
        return true;
    }

    public boolean dDc() {
        if (this.mSE && this.mYL != null) {
            if (this.mYL != null) {
                this.mYL.e();
            }
            if (this.mTe != null) {
                this.mTe.setText("");
            }
            if (this.mRH == 2) {
                av(true, i());
                return true;
            }
            dDn();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXQ != null) {
            if (this.mSM == null) {
                this.mSM = (PopH5Menu) ((ViewStub) this.mXQ.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mSM.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mSM.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            l(view, 0, this.mRI.getHeight() + this.mRI.getTop());
        } else if (id == a.f.btn_barrage) {
            m(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mYg, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                g.c(this.mYg, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mYf.a(false);
                a(false, false);
                ((VideoPlayer) this.mYg).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.e(this.mYg, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mRt == null || this.mRt.mUv == null || !this.mRt.mUv.mInPKMode) {
                ((VideoPlayer) this.mYg).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mSt) {
                f(this.mSe.getText().toString());
            } else {
                a(this.mSe.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dBU().c) {
                com.kascend.chushou.d.h.dBU().b(false);
                this.mSa.cancel();
                this.mSa.reset();
                this.mRZ.clearAnimation();
                this.mSb.setVisibility(8);
            }
            k(view, 0, this.mXQ.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.t(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mYg, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            j(view, x, this.mXQ.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mYf.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mYg, null) && this.mYf != null && this.mYf.mRd != null) {
                if (this.mSt) {
                    dDw();
                    return;
                }
                if (this.mYf != null && this.mYf.mRd != null && this.mYf.mRd.count > 0) {
                    this.mSg.setVisibility(8);
                } else {
                    this.mSg.setVisibility(0);
                }
                this.mSt = true;
                this.mSq.setBackgroundResource(a.e.ic_trumpet_p);
                this.mSr.setVisibility(0);
                this.mSr.setSelected(true);
                this.mSr.setTextColor(Color.parseColor("#ff5959"));
                if (this.mSe != null) {
                    this.mSe.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mSs <= 9) {
                this.mSs++;
                this.mSo.setText(this.mSs + "");
            }
            dDu();
        } else if (id == a.f.tv_cut_count) {
            if (this.mSs > 1) {
                this.mSs--;
                this.mSo.setText(this.mSs + "");
            }
            dDu();
        } else if (id == a.f.tv_buy_head) {
            dDv();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mTe.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mTe.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mTe);
                this.mYL.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mSe != null && this.mRX != null && this.mSd != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mSe);
                this.mRX.setVisibility(8);
                if (this.mRH == 2) {
                    this.mSd.setVisibility(0);
                }
            }
        } else if (this.mRX != null && this.mSd != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
            if (this.mRH == 2) {
                this.mRX.setVisibility(0);
            }
            this.mSd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dBU().c(roomToast.mToastContent);
            if (this.mSQ == null) {
                dDd();
            }
            if (this.mSR != null) {
                this.mSR.setText(roomToast.mToastContent);
            }
            if (!this.mSQ.isShowing()) {
                if (this.mSD != null) {
                    this.mSQ.showAtLocation(this.mSD, 85, 0, this.mXQ.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
                    RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mSQ != null) {
                                a.this.mSQ.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mSQ.dismiss();
        }
    }

    private void dDd() {
        if (this.mSQ == null) {
            View inflate = LayoutInflater.from(this.mYg).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mSR = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mSQ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 160.0f), -2);
            this.mSQ.setFocusable(false);
            this.mSQ.setOutsideTouchable(false);
            this.mSQ.setAnimationStyle(a.j.gift_toast_style);
            this.mSQ.update();
        }
    }

    private void j(View view, int i, int i2) {
        if (this.mYF != null && this.mYF.isShowing()) {
            this.mYF.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
        if (this.mZc == null) {
            dDS();
        }
        if (!this.mZc.isShowing()) {
            this.mZc.showAtLocation(view, 83, i, i2);
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mYf.dCE().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mZc.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDe() {
        if (this.mZf != null) {
            if (h.isEmpty(this.mZg)) {
                if (((VideoPlayer) this.mYg).q) {
                    this.mZf.bU(this.mYf != null ? this.mYf.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mZf.bU(this.mYf != null ? this.mYf.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mYg).q && this.mZg.size() == 2 && this.mZg.contains("4") && this.mZg.contains("2")) {
                this.mZf.bU(this.mYf != null ? this.mYf.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mZg.size() > 1 || !((VideoPlayer) this.mYg).q) {
                this.mZf.bU(this.mYf != null ? this.mYf.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mZg.get(0))) {
                this.mZf.bU(this.mYf != null ? this.mYf.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mZg.get(0))) {
                this.mZf.bU(this.mYf != null ? this.mYf.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mZg.get(0))) {
                this.mZf.bU(this.mYf != null ? this.mYf.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
        if (this.mYF == null) {
            al();
            this.mYF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mYF.isShowing() && this.mRH == 2) {
            this.mYF.showAtLocation(view, 83, i, this.mYg.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYf.dCE().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYF.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mXZ != null) {
            this.mXZ.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                g.c(this.mYg, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mUu.getPlayState() == 4) {
                        e(true);
                        if (this.mYf.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mYf.a(false);
                        ((VideoPlayer) this.mYg).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mUu.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mUu.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                g.c(this.mYg, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mYf.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mYg).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                    this.ai = false;
                    wo(true);
                    a(false, !this.ak);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mYT != null) {
            if (z) {
                this.mYT.setVisibility(0);
            }
            this.mYT.dPE();
            if (!z) {
                this.mYT.setVisibility(8);
            }
        }
        g.c(this.mYg, this.mYg.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mRS != null) {
                this.mRS.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mYa != null) {
                this.mYa.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mRS != null) {
            this.mRS.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mYa != null) {
                    this.mYa.setVisibility(8);
                }
            }
        }
    }

    private void dDf() {
        this.e = false;
        k(true, false, true);
    }

    private void dDg() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mRD[i];
        if (this.mRH != i2 || this.Sw != i) {
            this.Sw = i;
            this.mRH = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dCT();
            a(this.mYf != null ? this.mYf.mRe.get("1") : null);
            if (i2 == 2) {
                k();
                av(true, i3);
                u(true);
                b(true);
                dDj();
                com.kascend.chushou.toolkit.a.c.a(this.mYg, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            av(false, i3);
            u(false);
            b(false);
            if (this.mYF != null && this.mYF.isShowing()) {
                this.mYF.dismiss();
            }
            if (i2 == 99) {
                if (this.mRE != null && this.mRE[i] != null && (this.mRE[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mRE[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mYg, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mYg, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mYg, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mYg, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.Sw = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.mRH == 2) {
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
        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mYh != null) {
            if (this.mSd != null && this.mSd.getVisibility() == 0) {
                t(false);
            }
            if (this.mYa != null && this.mYa.getVisibility() == 0) {
                this.f = true;
            }
            au(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mRG != null) {
            this.mRG.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mRG != null) {
            this.mRG.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mRG != null) {
            this.mRG.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mRG != null) {
            this.mRG.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mSD != null) {
            int size = iconConfig.configs.size();
            this.mSD.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mYg).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mSD, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bU(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bU(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals("gift")) {
                        frescoThumbnailView.bU(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.bU(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.bU(str, a.e.ic_default_video_bottom);
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
                    public void dz(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.mSD.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mYf != null ? this.mYf.mRe : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mRG != null) {
            this.mRG.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dDe();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mSz != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mSz.xo(a.c.kas_white);
            } else if (this.mRH == 2) {
                this.mSz.bU(str, a.c.kas_white);
                if (this.mSA != null) {
                    this.mSA.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mSz.xo(a.c.kas_white);
                if (this.mSA != null) {
                    this.mSA.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mSA != null) {
                    this.mSA.setTextColor(a);
                    this.mSA.setTabTextSelectColor(a2);
                    this.mSA.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRZ != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mRZ.xo(a.e.ic_hotwords_black_n);
            } else {
                this.mRZ.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRY != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dEe().a(str, this.mRY, a.e.player_skin_input);
            } else {
                this.mRY.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mSc != null) {
                this.mSc.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mRG != null) {
            this.mRG.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYg instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCk = ((VideoPlayer) this.mYg).dCk();
            if (this.mYW == null) {
                this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYW.setVisibility(0);
            this.mYW.a(2, dCk);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mRG != null) {
            this.mRG.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mRG != null) {
            this.mRG.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mRG != null) {
            this.mRG.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mRG != null) {
            this.mRG.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mRG != null && this.mYf != null) {
            this.mRG.b(this.mYf.mRa);
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
    public class C0696a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0696a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mRD.length) {
                return null;
            }
            switch (a.this.mRD[i]) {
                case 1:
                    if (a.this.mRF == null) {
                        a.this.mRF = com.kascend.chushou.view.user.a.a(2, null, a.this.mYf.a, false, a.this.mYf.h, false);
                    }
                    a.this.mRE[i] = a.this.mRF;
                    return a.this.mRF;
                case 2:
                    if (a.this.mRG == null) {
                        a aVar = a.this;
                        if (a.this.mRt != null && a.this.mRt.mUv != null) {
                            z = a.this.mRt.mUv.mInPKMode;
                        }
                        aVar.mRG = com.kascend.chushou.player.ui.a.wp(z);
                    }
                    a.this.mRE[i] = a.this.mRG;
                    return a.this.mRG;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mYf != null && a.this.mYf.dCE() != null && !h.isEmpty(a.this.mSJ)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mSJ.get(i).url);
                        h5Options.a = a.this.mSJ.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mRE[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.MK(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.mRD.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int kW(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int ML(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String MM(int i) {
            return a.this.MK(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int MN(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b MO(int i) {
            int dimensionPixelSize = a.this.mYg.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void AP(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.Om(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mRC <= 3000) {
            g.Om(a.i.str_too_fast);
            return false;
        } else {
            dDl();
            if (!com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYg).dCf().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mRC = System.currentTimeMillis();
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                a(this.mYf.dCE().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYf.h);
            }
            g(this.b);
            if (!z && this.mSe != null) {
                this.mSe.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dDl();
            if (com.kascend.chushou.d.e.c(this.mYg, null) && LoginManager.Instance().getUserInfo() != null && this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                a(this.mYf.dCE().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mSe != null) {
                this.mSe.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mRG != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mYf.dCE().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mYf.dCE().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mYg).mPp;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.SS(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mRG.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mRG.a(arrayList, true, true);
        }
    }

    private void dDh() {
        if (this.mRG != null) {
            this.mRG.e();
        }
        if (this.mSH != null && this.mSH.isShown()) {
            this.mSH.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ox() {
        super.ox();
        if (this.mYg instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mYf != null) {
            this.mYf.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dDh();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mSF);
        if (this.mYg != null) {
            if (this.mSF || "10004".equals(((VideoPlayer) this.mYg).t)) {
                this.mSF = true;
                if (this.mYf != null) {
                    this.mYf.f = null;
                    if (this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                        this.mYf.dCE().mRoominfo.mGameId = null;
                    }
                }
                dCW();
                return;
            }
            this.mSF = true;
            if (this.mYg != null) {
                ((VideoPlayer) this.mYg).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mSF = false;
        if (this.mRQ != null) {
            this.mRQ.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mSF = false;
        if (this.mRQ != null) {
            this.mRQ.setVisibility(8);
        }
        super.i(z);
    }

    private void dDi() {
        dCU();
        if (i()) {
            dDk();
            dDQ();
            return;
        }
        dCW();
    }

    private void dDj() {
    }

    private void dDk() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dDP().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mYT != null) {
            this.mYT.setVisibility(0);
        }
        if (this.mRq != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mRq.d();
        }
        if (this.mRX != null) {
            this.mRX.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mRN.setVisibility(0);
            this.mRN.setOnClickListener(this);
        } else {
            this.mRN.setVisibility(8);
        }
        this.mRS.setVisibility(0);
        this.mRO.setVisibility(0);
        this.mXX.setVisibility(0);
        if (this.p) {
            this.mXY.setVisibility(0);
        } else {
            this.mXY.setVisibility(8);
        }
        dDj();
        av(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mYW != null && this.mYW.a(i, keyEvent)) {
                return true;
            }
            if (this.mSM != null && this.mSM.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mSN != null && this.mSN.onKeyDown(i, keyEvent)) || dDm()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mTf != null && this.mTf.getVisibility() == 0 && b(motionEvent, this.mTf)) {
                this.mTf.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mTe);
                return true;
            } else if (this.mSE && this.mTf != null && this.mTf.getVisibility() == 8 && g(this.mYL.b, motionEvent)) {
                dDc();
                return true;
            } else if (this.mSM != null && this.mSM.b() && g(this.mSM, motionEvent)) {
                this.mSM.a();
                return true;
            } else if (this.mSN != null && this.mSN.b() && g(this.mSN, motionEvent)) {
                this.mSN.a();
                return true;
            } else if (b(motionEvent, this.mSd)) {
                return dDl();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dDl() {
        boolean z;
        b(this.mSO, 10);
        boolean z2 = false;
        if (this.mSu != null && this.mSu.getVisibility() == 0) {
            this.mSu.setVisibility(8);
            this.mSv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSw) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
            this.mSv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSd == null || this.mSd.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mSt) {
                dDw();
            }
            this.mSd.setVisibility(8);
            z = true;
        }
        if (this.mRH == 2) {
            RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mRX != null && a.this.mRH == 2) {
                        a.this.mRX.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dDm() {
        if (dDl()) {
            return true;
        }
        if (this.mYF == null || !this.mYF.isShowing()) {
            return dDc() || dDa() || cXS();
        }
        this.mYF.dismiss();
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
    public void dDn() {
        this.mRX.setVisibility(8);
        this.mSd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z, boolean z2) {
        if (this.mRX != null) {
            if (z) {
                if (this.mRX.getVisibility() != 0) {
                    this.mRX.setVisibility(0);
                    this.mRX.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_bottom_anim));
                }
            } else if (this.mRX.getVisibility() != 4) {
                this.mRX.setVisibility(4);
                this.mRX.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mRQ != null) {
            this.mRQ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDo() {
        return this.mST;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dDO()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mYf != null) {
                        this.mYf.f = null;
                        this.mYf.dCE().mRoominfo.mGameId = null;
                    }
                    dCW();
                    return;
                }
                g.Om(a.i.str_getvideosource_failed);
            }
            wo(false);
            n(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mYf != null && this.mYf.dCF() != null) {
            a(this.mYf.dCF());
        }
        this.p = false;
        if (this.mYf == null || this.mYf.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mYf.f.size()) {
                if (!"2".equals(this.mYf.f.get(i2).mType)) {
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
        if (this.mRG != null) {
            this.mRG.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dDO()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mRT != null && this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                this.mRT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mYf.dCE().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dDO() && !this.mSK && (c = c(1, -1)) >= 0 && c < this.mSJ.size() && this.mSB != null) {
            this.mSB.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dDO() && !this.mSK) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mYg, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCl = ((VideoPlayer) this.mYg).dCl();
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(2, dCl);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCm = ((VideoPlayer) this.mYg).dCm();
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(2, dCm);
            } else if (bVar.a == 9) {
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mSu != null) {
            this.mSu.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dDO() && !this.mSK) {
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
        if (!dDO() && this.mYf != null) {
            String str = this.mYf.a;
            RoomInfo dCG = this.mYf.dCG();
            if (dCG != null && mVar.a(dCG.mCreatorUID, str)) {
                dCG.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.mRH == 2) {
            RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dDO()) {
                        a.this.t(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mSe != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mSe);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDp() {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
            if (this.mSG == null) {
                this.mSG = new f(getActivity());
            }
            this.mSG.a(this.mYf.dCE().mRoominfo);
            if (!this.mSG.isShowing()) {
                this.mSG.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mRG != null) {
            this.mRG.d();
        }
    }

    private void dB(View view) {
        this.mRU = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mRV = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mRV.setText(new tv.chushou.zues.widget.a.c().O(this.mYg, a.e.videoplayer_4g_video).append("  ").append(this.mYg.getString(a.i.videoplayer_4g_video)));
        this.mRW = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mRW.setText(new tv.chushou.zues.widget.a.c().O(this.mYg, a.e.videoplayer_4g_audio).append("  ").append(this.mYg.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mRU.setVisibility(8);
                    ((VideoPlayer) a.this.mYg).b(a.this.bR);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mRU.setVisibility(8);
                    ((VideoPlayer) a.this.mYg).c(a.this.bR);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dBN().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mRV.setOnClickListener(onClickListener);
        this.mRW.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mYf != null && !h.isEmpty(this.mYf.f)) {
            f(this.mYf.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.bR = z;
            this.p = false;
            if (this.mYf != null && this.mYf.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mYf.f.size()) {
                        break;
                    } else if (!"2".equals(this.mYf.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mRU != null) {
                this.mRU.setVisibility(0);
                this.mRV.setVisibility(0);
                this.mRW.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mRU != null) {
            this.mRU.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mSX == null) {
                this.mSX = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dDO()) {
                            a.this.dDq();
                        }
                    }
                };
                if (this.mYh != null) {
                    this.mYh.d(this.mSX, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mSX != null && this.mYh != null) {
            this.mYh.removeCallbacks(this.mSX);
            this.mSX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDq() {
        if (LoginManager.Instance().islogined() && this.mRG != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mYg, "显示双击666_num", null, new Object[0]);
            if (this.mYf != null) {
                this.mYf.b(false);
            }
            d(false);
            this.mRG.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXQ != null) {
            if (this.mSN == null) {
                this.mSN = (InteractionView) ((ViewStub) this.mXQ.findViewById(a.f.view_interaction)).inflate();
                this.mSN.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mSN.a();
                    }
                });
            }
            if (this.mSN != null) {
                this.mSN.b(configDetail);
                this.mSN.c();
                this.mSN.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQp()) {
                g.M(this.mYg, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mYg, null) && (this.mYg instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYf != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYg, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYf != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYg, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mYg, configDetail.mUrl, this.mYg.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mYg, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    dDr();
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

    private void dDr() {
        if (this.mSE) {
            dDc();
            return;
        }
        if (this.mYg.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYf.dCE().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mYg != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mRt == null) {
                this.mRt = new com.kascend.chushou.player.e.a();
            }
            this.mRt.b = str;
            this.mRt.mUv.copy(pkNotifyInfo);
            if (this.mRt.mUv.mAction == 6) {
                this.mRt.mUv.mInPKMode = true;
                this.u = this.mRt.mUv.mPkId;
            } else if (this.mRt.mUv.mAction == 7 || (this.mRt.mUv.mMode == 1 && this.mRt.mUv.mAction == 5)) {
                this.mRt.mUv.mInPKMode = true;
                this.u = this.mRt.mUv.mPkId;
                if (dDt() != null) {
                    if (2 == this.mRH && this.mTa != null) {
                        this.mTa.setVisibility(0);
                    }
                    dDt().b(this.mRt.mUv, false);
                    dDt().a(this.mRt.mUv.mMode, "1");
                    if (this.mRt.mUv.mAction == 5 && this.mRt.mUv.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mRt.mUv.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mRt.mUv.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mRt.mUv.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mRt.mUv.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mRt.mUv.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dDt().a(this.mRt.mUv);
                        if (this.mRt.mUv.destinyInfo == null || this.mRt.mUv.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dDt().a(parseInt, this.mRt.mUv.mPkUpdateInfo.remainDuration, j, this.mRt.mUv.mMode, i);
                    }
                    if (!h.isEmpty(this.mRt.mUv.mPkUpdateInfo.specialMomentList) && dDt() != null) {
                        dDt().a(this.mRt.mUv, true);
                    }
                }
                dDs();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.QV(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mRt.mUv.mInPKMode = false;
                dDs();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.QV(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dDs() {
        if (this.mRt != null && this.mRt.mUv != null) {
            if (this.mRt.mUv.mInPKMode) {
                this.y.setText(this.mRt.mUv.mPkUserNickname);
                this.mRv.setVisibility(0);
                if (this.mXW != null) {
                    this.mXW.setEnabled(false);
                }
                if (this.mXY != null) {
                    this.mXY.setEnabled(false);
                    return;
                }
                return;
            }
            this.mRv.setVisibility(8);
            if (this.mXW != null) {
                this.mXW.setEnabled(true);
            }
            if (this.mXY != null) {
                this.mXY.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dDt() {
        if (this.mYg == null || this.mXQ == null || this.mTa == null) {
            return null;
        }
        if (this.mRu == null) {
            if (this.mSZ == null) {
                this.mSZ = ((ViewStub) this.mXQ.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mRu = new com.kascend.chushou.player.e.b();
            this.mRu.a(this.mTa, this.mSZ, (View) null, this.mYg, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dPY()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mYf != null) {
                        append.append(a.this.mYf.dCG().mRoomID);
                    }
                    if (a.this.mRt != null && a.this.mRt.mUv != null) {
                        append.append("&mode=").append(a.this.mRt.mUv.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mYg, append.toString());
                }
            });
        }
        return this.mRu;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mSr != null && this.mYf != null && this.mYf.mRd != null) {
            this.mSr.setText(tv.chushou.zues.utils.b.Ol(this.mYf.mRd.count));
            this.mSr.setVisibility(0);
            if (this.mYf.mRd.count < 1) {
                dDw();
            }
            if (this.mSh != null) {
                this.mSh.setText(this.mYf.mRd.primaryName);
            }
            if (this.mSi != null) {
                this.mSi.setText(this.mYf.mRd.desc);
            }
            dDu();
        }
    }

    public void dDu() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mSs * h.parseLong(this.mYf.mRd.point)));
        if (this.mSl != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mYg.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mYg, a.e.icon_coin_new);
            cVar.append(this.mYg.getString(a.i.str_buy_count_coin2));
            this.mSl.setText(cVar);
        }
    }

    private void dDv() {
        if (com.kascend.chushou.d.e.c(this.mYg, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mSs);
        }
    }

    private void u(boolean z) {
        if (this.mXQ != null && this.mTa != null) {
            if (z) {
                if (this.mRt != null && this.mRt.mUv != null && this.mRt.mUv.mInPKMode) {
                    this.mTa.setVisibility(0);
                    return;
                }
                return;
            }
            this.mTa.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mXQ != null && this.mRy != null) {
            if (z) {
                if (this.E && 2 == this.mRH) {
                    this.mRy.setVisibility(0);
                    return;
                }
                return;
            }
            this.mRy.setVisibility(8);
        }
    }

    private void v(boolean z) {
        if (z) {
            if (this.mRt != null && this.mRt.mUv != null && this.mRt.mUv.mInPKMode && this.mRv != null) {
                this.mRv.setVisibility(0);
            }
        } else if (this.mRv != null) {
            this.mRv.setVisibility(8);
        }
    }

    private void dDw() {
        this.mSt = false;
        this.mSq.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mYf != null && this.mYf.mRd != null) {
            if (this.mYf.mRd.count < 1) {
                this.mSr.setVisibility(8);
            } else {
                this.mSr.setVisibility(0);
                this.mSr.setSelected(false);
                this.mSr.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mSg.setVisibility(8);
        if (this.mSe != null) {
            this.mSe.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dDr();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mSc != null) {
            this.mSc.performClick();
        }
    }

    public boolean dDx() {
        return this.mRH == 2;
    }
}
