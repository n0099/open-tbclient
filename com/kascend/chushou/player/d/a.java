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
    private int[] mRB;
    private Fragment[] mRC;
    private ImageView mRH;
    private MarqueeTextView mRI;
    private MarqueeTextView mRJ;
    private ImageView mRK;
    private ImageView mRL;
    private ImageButton mRM;
    public String mRN;
    private RecommendView mRO;
    private TextView mRR;
    private RelativeLayout mRS;
    private TextView mRT;
    private TextView mRU;
    private RelativeLayout mRV;
    private View mRW;
    private FrescoThumbnailView mRX;
    private AnimationSet mRY;
    private ImageView mRZ;
    private LinearLayout mSA;
    private f mSE;
    private ViewMicPerson mSF;
    public ArrayList<RoomTab> mSH;
    private PopH5Menu mSK;
    private InteractionView mSL;
    private int mSM;
    private PopupWindow mSN;
    private TextView mSO;
    private GiftAnimationLayout mSQ;
    private com.kascend.chushou.player.b.a mSR;
    private Runnable mSV;
    private View mSX;
    private LivePKBarUserValue mSY;
    private String mSZ;
    private TextView mSa;
    private RelativeLayout mSb;
    private PastedEditText mSc;
    private TextView mSd;
    private LinearLayout mSe;
    private TextView mSf;
    private TextView mSg;
    private TextView mSh;
    private TextView mSi;
    private TextView mSj;
    private TextView mSl;
    private TextView mSm;
    private ImageView mSn;
    private TextView mSo;
    private KPSwitchPanelLinearLayout mSs;
    private ImageView mSt;
    private c mSv;
    private d.a mSw;
    private FrescoThumbnailView mSx;
    private PagerSlidingTabStrip mSy;
    private KasViewPager mSz;
    private TextView mTa;
    private ImageView mTb;
    private EditText mTc;
    private View mTd;
    private View mTe;
    private View mTf;
    private String mTi;
    private long mRA = 0;
    private com.kascend.chushou.view.user.a mRD = null;
    private com.kascend.chushou.player.ui.a mRE = null;
    private int mRF = -1;
    private int Sw = 0;
    private View mRG = null;
    private View mRP = null;
    private ImageButton mRQ = null;
    private int mSq = 1;
    private boolean mSr = false;
    private boolean mSu = false;
    private boolean mSB = false;
    private boolean mSD = false;
    private boolean mSG = false;
    private boolean mSI = false;
    private boolean mSJ = true;
    private int mSS = 0;
    private int mST = 0;
    private int mSU = -1;
    private final Rect mSW = new Rect();
    private boolean mTg = false;
    private C0696a mTh = null;
    private boolean da = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRN = getArguments().getString("mCover");
        this.mSJ = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXO = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mXO;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dDM()) {
            c(view);
            dCL();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.mSI = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mYJ != null) {
            this.mYJ.b();
        }
        if (this.mYe != null && (this.mYe instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYe).wh(true);
            ((VideoPlayer) this.mYe).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSI = true;
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
        this.mSq = 1;
        this.mSr = false;
        U();
        if (this.mYf != null) {
            this.mYf.cq(null);
            this.mYf = null;
        }
        if (this.mRO != null) {
            dDN().removeAllViews();
            this.mRO = null;
        }
        this.c = null;
        this.mRm = null;
        tv.chushou.zues.a.a.cr(this);
        this.mSy = null;
        this.mSz = null;
        this.mRE = null;
        this.mRD = null;
        if (this.mRC != null) {
            for (int i = 0; i < this.mRC.length; i++) {
                this.mRC[i] = null;
            }
        }
        this.mRC = null;
        if (this.mSc != null) {
            this.mSc.addTextChangedListener(null);
            this.mSc.setOnTouchListener(null);
            this.mSc.setOnEditorActionListener(null);
            this.mSc = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mYe, this.mSv);
        if (this.mYe != null && (this.mYe instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYe).dCg();
        }
        this.mSw = null;
        this.mSv = null;
        if (this.mSF != null) {
            this.mSF.b();
            this.mSF = null;
        }
        if (this.mSN != null) {
            this.mSN.dismiss();
        }
        if (this.mSR != null) {
            this.mSR.a();
            this.mSR = null;
            this.mSQ = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mSY = (LivePKBarUserValue) this.mXO.findViewById(a.f.live_pk_bar_user);
        this.mXX = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mTg) {
            this.mTg = true;
            if (this.mTe == null) {
                this.mTe = this.mXO.findViewById(a.f.vs_async_view);
                this.mTe = ((ViewStub) this.mTe).inflate();
            }
            if (this.mTf == null) {
                this.mTf = this.mXO.findViewById(a.f.vs_async_notification_view);
                this.mTf = ((ViewStub) this.mTf).inflate();
            }
            this.mRw = (VoiceInteractionView) this.mXO.findViewById(a.f.voiceInteractiveView);
            t();
            dA(this.mXO);
            cXK();
            ((VideoPlayer) this.mYe).q();
            this.mRr = new com.kascend.chushou.player.e.a();
        }
    }

    private void dA(View view) {
        this.mSx = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mSy = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mSz = (KasViewPager) view.findViewById(a.f.vp_main);
        dCM();
        dCN();
        dCS();
        if (this.mYd != null) {
            I();
            a(this.mYd.mQX, this.mYd.mRb);
        }
        this.aSx = 0;
        this.mYO = 0L;
        this.mYK = (RoundProgressBar) this.mXO.findViewById(a.f.roundProgressBar);
        this.mYL = (TextView) this.mXO.findViewById(a.f.tv_paonum);
        this.mYM = (FrescoThumbnailView) this.mXO.findViewById(a.f.iv_paoicon);
        this.mYT = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.mSB = false;
                if (a.this.mRF == 2) {
                    a.this.av(true, a.this.i());
                } else {
                    a.this.dDl();
                }
                a.this.b(a.this.mSM, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.mSB = true;
                if (a.this.mRF == 2) {
                    a.this.av(false, a.this.i());
                } else {
                    a.this.dDl();
                }
                if (a.this.mYJ != null) {
                    a.this.mYJ.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hd(a.this.mYe).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mYe)) - a.this.mYJ.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mYe, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mYe, 54.0f) * 2);
                    if (statusBarHeight < a.this.mSM) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mYN = (PaoGuideView) this.mXO.findViewById(a.f.rlPaoGuideView);
        this.mSF = (ViewMicPerson) this.mXO.findViewById(a.f.rl_mic_person_view);
    }

    private void dCL() {
        this.mUs = ((VideoPlayer) this.mYe).dCa();
        this.mYd = ((VideoPlayer) this.mYe).dCd();
        dB(this.mXO);
        this.mSS = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
        this.mST = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (com.kascend.chushou.b.dBL().d == 0 && this.mST > 0) {
            View findViewById = this.mXO.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mST);
        }
        dCX();
        dCV();
        if (!this.mSJ) {
            Q();
        }
        dCT();
        a();
        if (this.c == null) {
            this.mRm = new d.a();
            this.c = new GestureDetector(this.mYe, this.mRm);
        }
        this.mRo = ((VideoPlayer) this.mYe).dCe();
        this.mRo.a(this);
        if (this.mSR != null) {
            this.mSR.a();
            this.mSR = null;
        }
        this.mSQ = (GiftAnimationLayout) this.mXO.findViewById(a.f.ll_gift_animation);
        this.mSQ.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mYd != null) {
            this.mSR = new com.kascend.chushou.player.b.a(this.mYe.getApplicationContext(), this.mSQ);
            this.mSR.a(this.mYd);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mXO.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mXY = (PlayerErrorView) this.mXO.findViewById(a.f.view_net_error_msg);
        this.mXY.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dCQ();
        dDd();
        if (this.mYd.dCD() != null) {
            a(this.mYd.dCD());
        }
        FullRoomInfo dCC = this.mYd.dCC();
        if (dCC != null) {
            dDg();
            if (i()) {
                this.ak = false;
                wo(true);
                this.mYf.Of(8);
            }
            this.mRR.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dCC.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mRG.setVisibility(0);
        this.ak = false;
        wo(true);
        this.mYf.Of(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mYe).n();
        if (this.mYd != null && !h.isEmpty(this.mYd.mQZ)) {
            b(this.mYd.mQZ);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dCn;
        dCM();
        k();
        FullRoomInfo dCC = this.mYd.dCC();
        if (dCC != null) {
            if (dCC.mRoominfo != null) {
                this.mRR.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dCC.mRoominfo.mOnlineCount)));
                this.mSZ = dCC.mRoominfo.mRoomID;
            }
            dDg();
            if (!h.isEmpty(dCC.mRoomToastList)) {
                Iterator<RoomToast> it = dCC.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dBS().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mYd != null && this.mYd.l()) {
                d(true);
            }
            if (this.mYe != null && (this.mYe instanceof VideoPlayer) && (dCn = ((VideoPlayer) this.mYe).dCn()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dCn.mUt, dCn.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mSA);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dCM() {
        boolean z = true;
        if (this.mYd == null || this.mYd.dCC() == null || this.mYd.dCC().mRoominfo == null || h.isEmpty(this.mYd.dCC().mRoomTabs)) {
            this.mSG = false;
            this.mRC = new Fragment[2];
            this.mRB = new int[2];
            this.mRB[0] = 2;
            this.mRB[1] = 1;
            return;
        }
        this.mSG = true;
        this.mSH = new ArrayList<>();
        Iterator<RoomTab> it = this.mYd.dCC().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mSH.add(next);
            }
        }
        if (this.mSH.size() >= 2 && this.mRB != null && this.mRB.length >= 2 && this.mSH.get(0).type == this.mRB[0] && this.mSH.get(1).type == this.mRB[1]) {
            z = false;
        }
        this.mRC = new Fragment[this.mSH.size()];
        this.mRB = new int[this.mSH.size()];
        for (int i = 0; i < this.mSH.size(); i++) {
            this.mRB[i] = this.mSH.get(i).type;
        }
        if (z) {
            this.mTh = new C0696a(getChildFragmentManager());
            this.mSz.setAdapter(this.mTh);
        }
    }

    private void dCN() {
        this.mSb = (RelativeLayout) this.mXO.findViewById(a.f.rl_edit_bar);
        this.mRX = (FrescoThumbnailView) this.mXO.findViewById(a.f.btn_hotword);
        this.mRX.xo(a.e.ic_hotwords_black_n);
        this.mRX.setOnClickListener(this);
        this.mRZ = (ImageView) this.mXO.findViewById(a.f.iv_task_badge);
        this.mRY = (AnimationSet) AnimationUtils.loadAnimation(this.mYe, a.C0690a.anim_hotword);
        this.mRY.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dBS().c) {
                    a.this.mRX.clearAnimation();
                    a.this.mRX.startAnimation(a.this.mRY);
                }
            }
        });
        if (com.kascend.chushou.d.h.dBS().c) {
            this.mRX.startAnimation(this.mRY);
            this.mRZ.setVisibility(0);
        }
        this.mSa = (TextView) this.mXO.findViewById(a.f.tv_bottom_input);
        this.mSa.setOnClickListener(this);
        this.mZd = (FrescoThumbnailView) this.mXO.findViewById(a.f.ll_btn_set);
        this.mZd.setOnClickListener(this);
        this.mSA = (LinearLayout) this.mXO.findViewById(a.f.ll_bottom_all_button);
        this.mRV = (RelativeLayout) this.mXO.findViewById(a.f.rl_bottom_input);
        this.mRW = this.mXO.findViewById(a.f.ll_bottom_input);
        this.mRV.setVisibility(8);
        this.mSc = (PastedEditText) this.mXO.findViewById(a.f.et_bottom_input);
        this.mSc.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mSd.setEnabled(editable.length() > 0);
            }
        });
        this.mSc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mSd);
                    return true;
                }
                return true;
            }
        });
        this.mSc.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.mSc);
                }
                return false;
            }
        });
        this.mSt = (ImageView) this.mXO.findViewById(a.f.iv_btn_emoji);
        this.mSt.setVisibility(8);
        this.mSd = (TextView) this.mXO.findViewById(a.f.tv_btn_send);
        this.mSd.setOnClickListener(this);
        this.mSs = (KPSwitchPanelLinearLayout) this.mXO.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dBL().d == 0) {
            this.mSs.setUseStatusBar(true);
        }
        this.mSe = (LinearLayout) this.mXO.findViewById(a.f.head_trumpet);
        this.mSe.setVisibility(8);
        this.mSe.setOnClickListener(this);
        this.mSf = (TextView) this.mXO.findViewById(a.f.tv_primary_name);
        this.mSg = (TextView) this.mXO.findViewById(a.f.tv_primary_desc);
        this.mSj = (TextView) this.mXO.findViewById(a.f.tv_cut_count);
        this.mSj.setOnClickListener(this);
        this.mSm = (TextView) this.mXO.findViewById(a.f.tv_head_count);
        this.mSm.setText(this.mSq + "");
        this.mSl = (TextView) this.mXO.findViewById(a.f.tv_plus_count);
        this.mSl.setOnClickListener(this);
        this.mSi = (TextView) this.mXO.findViewById(a.f.tv_buy_count_coin);
        this.mSh = (TextView) this.mXO.findViewById(a.f.tv_buy_head);
        this.mSh.setOnClickListener(this);
        this.mSn = (ImageView) this.mXO.findViewById(a.f.iv_trumpet_select);
        this.mSn.setOnClickListener(this);
        this.mSo = (TextView) this.mXO.findViewById(a.f.tv_trumpet_have_count);
        this.mSr = false;
        this.mSn.setBackgroundResource(a.e.ic_trumpet_n);
        this.mSo.setVisibility(8);
        dCP();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mSs, this.mSt, this.mSc, new a.InterfaceC0817a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0817a
            public void wi(boolean z) {
                if (a.this.mSt != null) {
                    if (!z) {
                        a.this.mSt.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dBL().d == 0) {
                        a.this.mSs.setDirectVisibility(0);
                    }
                    a.this.mSt.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mSw = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wj(boolean z) {
                a.this.mSu = z;
                if (z) {
                    a.this.mSt.setImageResource(a.e.cs_emoji_normal);
                    a.this.dCO();
                    return;
                }
                if (a.this.mTd != null && a.this.mTd.getVisibility() == 0) {
                    a.this.mTd.setVisibility(8);
                }
                if (a.this.mSB) {
                    a.this.mYJ.setVisibility(0);
                }
                if (a.this.mYe != null && (a.this.mYe instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mYe).wh(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mSv = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mSs, this.mSw, ((VideoPlayer) this.mYe).dCh());
        ((VideoPlayer) this.mYe).g(((VideoPlayer) this.mYe).dCh());
        this.mTd = this.mXO.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mTa = (TextView) this.mXO.findViewById(a.f.btn_room_search);
        this.mTb = (ImageView) this.mXO.findViewById(a.f.iv_room_emoji_delete);
        this.mTc = (EditText) this.mXO.findViewById(a.f.et_room_emoji_search);
        this.mTc.setImeOptions(3);
        this.mTc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mTa);
                    return true;
                }
                return false;
            }
        });
        this.mTc.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mTa.setEnabled(editable.length() > 0);
                a.this.mTb.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mYJ.setEmojiSearchText(editable.toString());
            }
        });
        this.mTa.setOnClickListener(this);
        this.mTb.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mTc);
            this.mTd.setVisibility(0);
            this.mTc.requestFocus();
        } else {
            this.mTd.setVisibility(8);
        }
        if (z2) {
            this.mTc.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCO() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hd(this.mYe).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe)) - tv.chushou.zues.widget.kpswitch.b.d.ho(this.mYe)) - tv.chushou.zues.utils.a.dip2px(this.mYe, 14.0f)) - this.mYe.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mYe, 54.0f) * 2);
        if (statusBarHeight < this.mSM) {
            b(statusBarHeight, 10);
        }
    }

    private void dCP() {
    }

    private void dCQ() {
        this.mYf = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.au(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mXO.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mYe.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mYf.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mYf.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mYf.K(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mYf);
                            break;
                        case 12:
                            a.this.b(a.this.mYf);
                            break;
                        case 17:
                            a.this.dDP();
                            break;
                        case 18:
                            a.this.cXJ();
                            break;
                        case 19:
                            a.this.mYc.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dCR() {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mSH)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSH.size()) {
                    if (!h.isEmpty(this.mSH.get(i2).notifyIcon)) {
                        this.mSy.bl(i2, this.mSH.get(i2).notifyIcon);
                        this.mSy.OC(i2);
                    } else if (this.mSH.get(i2).notify == 1) {
                        this.mSy.OB(i2);
                        this.mSy.OA(i2);
                    } else {
                        this.mSy.OA(i2);
                        this.mSy.OC(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mSH)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mSH.size()) {
                    if (this.mSH.get(i4).type == i) {
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
        if (this.mYd == null || this.mYd.dCC() == null || this.mYd.dCC().mRoominfo == null || h.isEmpty(this.mSH)) {
            if (i == 1) {
                return this.mYe.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mYe.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mSH.size()) {
            return this.mSH.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mSH) && i < this.mSH.size()) {
            this.mSH.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mSH) && i < this.mSH.size()) {
            this.mSH.get(i).notifyIcon = str;
        }
    }

    private void dCS() {
        if (this.mSz != null && this.mSy != null && this.mRB != null) {
            this.mRE = null;
            if (this.mRC != null) {
                for (int i = 0; i < this.mRC.length; i++) {
                    this.mRC[i] = null;
                }
            }
            if (this.mTh == null) {
                this.mTh = new C0696a(getChildFragmentManager());
                this.mSz.setAdapter(this.mTh);
            } else {
                this.mTh.notifyDataSetChanged();
            }
            this.mSz.setOffscreenPageLimit(this.mRB.length);
            this.mSy.c(this.mSz);
            this.mSy.setOnPageChangeListener(this);
            this.mSy.notifyDataSetChanged();
            this.mSy.setVisibility(0);
            this.mSz.setVisibility(0);
            if (!this.mSG) {
                this.mRF = 2;
                this.mSz.setCurrentItem(c(2, 0));
                this.mRV.setVisibility(0);
            } else {
                if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                    if (!h.isEmpty(this.mYd.dCC().mRoominfo.mGameName)) {
                        this.mRJ.setText(this.mYd.dCC().mRoominfo.mGameName);
                    } else {
                        this.mRJ.setText(this.mYe.getString(a.i.no_online_game_name));
                    }
                    this.mRI.setText(this.mYd.dCC().mRoominfo.mName);
                } else {
                    this.mRJ.setText(this.mYe.getString(a.i.no_online_game_name));
                }
                dCR();
                if (i()) {
                    dDe();
                    if (this.mSz != null) {
                        this.mRF = 2;
                        int c = c(2, 0);
                        this.mSz.setCurrentItem(c);
                        this.mSy.setSelectItem(c);
                    }
                } else if (this.mSz != null) {
                    this.mRF = 1;
                    int c2 = c(1, 1);
                    this.mSz.setCurrentItem(c2);
                    this.mSy.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dCT() {
        this.N = new SurfaceView(this.mYe);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mYi);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dDN().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dCU() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mYe).s();
        cXQ();
        dCY();
        dCZ();
        dDN().setBackgroundResource(a.e.room_not_online);
        if (this.mRO == null) {
            this.mRO = new RecommendView(this.mYe);
            dDN().addView(this.mRO);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mYe);
            this.mRO.setLayoutParams(layoutParams);
        }
        if (this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mYd.dCC().mRoominfo.mRoomID)) {
            this.mRO.a(this.mYd.dCC().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dDM() && a.this.mYe != null && a.this.dDN() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mYe);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lMR);
                        if (a.this.dDN().getChildCount() >= 2) {
                            a.this.dDN().addView(frescoThumbnailView, 0);
                        }
                        a.this.dDN().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dQi(), a.this.ar, a.this.mYi);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYR != null) {
            this.mYR.dPC();
            this.mYR.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mYJ != null) {
            this.mYJ.e();
        }
        wo(false);
        a(false, false);
        if (this.mRo != null) {
            this.mRo.d();
        }
    }

    private void dCV() {
        int i = 0;
        this.mRG = this.mXO.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dBL().d == 0 && this.mSS > 0) {
            View findViewById = this.mXO.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.mSS;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mRH = (ImageView) this.mRG.findViewById(a.f.back_icon);
        this.mRH.setOnClickListener(this);
        this.mRI = (MarqueeTextView) this.mRG.findViewById(a.f.tv_title);
        this.mRJ = (MarqueeTextView) this.mRG.findViewById(a.f.tv_Type);
        this.mRL = (ImageView) this.mXO.findViewById(a.f.btn_setting);
        this.mRP = this.mXO.findViewById(a.f.bottomview);
        if (this.mXV == null) {
            this.mXV = (ImageButton) this.mRP.findViewById(a.f.btn_barrage);
            this.mXV.setOnClickListener(this);
            if (this.mYd != null) {
                if (com.kascend.chushou.d.h.dBS().n()) {
                    this.mXV.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXV.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mXW = (ImageButton) this.mRP.findViewById(a.f.btn_audio);
        this.mXW.setOnClickListener(this);
        if (this.mYd != null && this.mYd.d) {
            this.mXW.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mXW.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mYd != null && this.mYd.f != null) {
            while (true) {
                if (i >= this.mYd.f.size()) {
                    break;
                } else if (!"2".equals(this.mYd.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mRQ = (ImageButton) this.mRP.findViewById(a.f.playbutton);
        this.mRQ.setOnTouchListener(this);
        this.mRM = (ImageButton) this.mRP.findViewById(a.f.btn_refresh);
        this.mRM.setOnClickListener(this);
        this.mRR = (TextView) this.mRP.findViewById(a.f.tv_online_count);
        if (this.mXU == null) {
            this.mXU = (ImageButton) this.mRP.findViewById(a.f.btn_screenChange);
            this.mXU.setOnClickListener(this);
        }
        if (this.mRK == null) {
            this.mRK = (ImageView) this.mRG.findViewById(a.f.report_icon);
            this.mRK.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dDn();
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
        if (!dDM() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mRE != null) {
                        this.mRE.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                        this.mYd.dCC().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mYd.dCC().mMicStatus.onMic) {
                            dDf();
                        }
                        if (this.mYd.dCC().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mYd.dCC().mRoominfo.mCreatorUID)) {
                                i(arrayList2, this.mYd.dCC().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mYd.dCC().mMicStatus.onMic) {
                            this.mYd.dCC().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mYd.dCC().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = j(this.mYd.dCC().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mYd.dCC().mMicStatus != null && !h.isEmpty(this.mYd.dCC().mMicStatus.micRoomId) && !this.mYd.dCC().mMicStatus.micRoomId.equals("0")) {
                                this.mTi = this.mYd.dCC().mMicStatus.micRoomId;
                            }
                            if (this.mRE != null) {
                                this.mRE.a(this.mYd.dCC().mMicStatus, this.mYd.dCC().mFanItems, str, z2);
                            }
                            if (this.mSF != null && this.mSF.getVisibility() == 0) {
                                this.mSF.a(this.mYd.dCC().mFanItems, this.mYd.dCC().mMicStatus, str, z2, this.mYd.dCC().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mRE != null) {
                                this.mRE.e();
                            }
                            if (this.mSF != null && this.mSF.isShown()) {
                                this.mSF.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mRE != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mRE.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mRE.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mSU != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mSU = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mRr != null && this.mRr.mUt != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mRr.mUt.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mRr.mUt.mInPKMode = true;
                                    this.mRr.mUt.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRr.mUt.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRr.mUt.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRr.mUt.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRr.mUt.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRr.mUt.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mRr.mUt.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mRr.mUt.mMode = pkNotifyInfo.mMode;
                                    this.mRr.mUt.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dDr() != null) {
                                        dDr().g(true, this.mRr.mUt.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dBS().a) {
                                        if (!com.kascend.chushou.b.dBL().e) {
                                            com.kascend.chushou.b.dBL().e = true;
                                            g.M(this.mYe, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBS().a(this.mYe, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.mRF && this.mSY != null) {
                                        this.mSY.setVisibility(0);
                                    }
                                    this.mRr.mUt.mAction = 7;
                                    this.mRr.mUt.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRr.mUt.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRr.mUt.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRr.mUt.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRr.mUt.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRr.mUt.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dDq();
                                    if (dDr() != null) {
                                        dDr().g(false, 0L);
                                        dDr().b(this.mRr.mUt, true);
                                        dDr().a(this.mRr.mUt.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.QV(this.mSZ);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mRr.mUt.mInPKMode = false;
                                    this.mRr.mUt.mAction = 2;
                                    dDq();
                                    if (dDr() != null) {
                                        dDr().c();
                                    }
                                    if (com.kascend.chushou.d.h.dBS().a) {
                                        if (!com.kascend.chushou.b.dBL().e) {
                                            com.kascend.chushou.b.dBL().e = true;
                                            g.M(this.mYe, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBS().a(this.mYe, false);
                                        ak();
                                    }
                                    this.mRr.b = null;
                                    this.mRr.mUt = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.QV(this.mSZ);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mRr.mUt.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mRr.mUt.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mRr.mUt.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mYd.dCC().mRoominfo.mRoomID) && this.mYd.dCC().mRoominfo.mRoomID.equals(this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dDr() != null) {
                                        dDr().a(this.mRr.mUt, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mRr.mUt.copyUpdate(pkNotifyInfo);
                                    if (dDr() != null) {
                                        dDr().a(this.mRr.mUt);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mRr.mUt.copyStop(pkNotifyInfo);
                                        if (dDr() != null) {
                                            dDr().w(this.mRr.mUt.mMaxFreeDuration, this.mRr.mUt.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mRr.mUt.copyResult(pkNotifyInfo);
                                    if (!this.mSI && dDr() != null) {
                                        int i5 = 1;
                                        if (this.mRr.mUt.destinyInfo != null && this.mRr.mUt.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dDr().a(h.parseInt(this.mRr.mUt.mResult), h.parseLong(this.mRr.mUt.mvpUid), this.mRr.mUt.mvpAvatar, this.mRr.mUt.mvpNickname, this.mRr.mUt.mMaxFreeDuration, this.mRr.mUt.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mRE != null) {
                if (LoginManager.Instance().islogined() && this.mYd != null && this.mYd.l()) {
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
                if (this.mYd == null || this.mYd.dCC() == null || this.mYd.dCC().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mYd.dCC().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dBS().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dBS().b().equals(next2.mUserID)) {
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
                this.mRE.a(arrayList, true, false);
                this.mRE.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mRB != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mRB.length) {
                    break;
                }
                if (this.mRB[i2] == 99 && this.mRC != null && this.mRC[i2] != null && (this.mRC[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mRC[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mSH.size() && this.mSy != null) {
                if (i == 0) {
                    this.mSy.setTagText(i2, new StringBuilder(this.mSH.get(i2).name).toString());
                    return;
                } else {
                    this.mSy.setTagText(i2, this.mSH.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mXV != null) {
            if (z) {
                this.mXV.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXV.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dCW() {
        if (this.mXO == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXO.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
        this.ar = Math.min(hd.x, hd.y);
        this.mYi = (this.ar * this.mYe.getResources().getInteger(a.g.h_thumb_height_def)) / this.mYe.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dDN().getLayoutParams();
        layoutParams.height = this.mYi;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXX.getLayoutParams();
        layoutParams2.height = this.mYi;
        layoutParams2.width = this.ar;
        this.mSM = this.mYi + this.mYe.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mYe, 54.0f);
        b(this.mSM, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mYi);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dCX() {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
        this.ar = Math.min(hd.x, hd.y);
        this.mYi = (this.ar * this.mYe.getResources().getInteger(a.g.h_thumb_height_def)) / this.mYe.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dDN().getLayoutParams();
        layoutParams.height = this.mYi;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXX.getLayoutParams();
        layoutParams2.height = this.mYi;
        layoutParams2.width = this.ar;
        this.mSM = this.mYi + this.mYe.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mYe, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.mSM, 10);
        k();
        if (!h.isEmpty(this.mRN)) {
            File ad = tv.chushou.zues.widget.fresco.a.ad(Uri.parse(this.mRN));
            if (ad != null && ad.exists()) {
                this.mXX.setImageURI(Uri.fromFile(ad));
                this.mXX.setVisibility(0);
                return;
            }
            this.mXX.setVisibility(8);
            return;
        }
        this.mXX.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void s(boolean z) {
        if (this.mRK != null) {
            this.mRK.setVisibility(z ? 0 : 4);
        }
        if (this.mRL != null) {
            this.mRL.setVisibility(z ? 0 : 4);
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
        if (this.mYf != null) {
            this.mYf.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mYe).e(true);
            if (!z3) {
                if (this.mRP.getVisibility() != 0 && z2) {
                    this.mRP.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mXW.setVisibility(0);
                } else {
                    this.mXW.setVisibility(8);
                }
                this.mRP.setVisibility(0);
            }
            PlayUrl dCD = this.mYd.dCD();
            if (dCD != null && "2".equals(dCD.mType)) {
                if (this.mXU != null) {
                    this.mXU.setVisibility(8);
                }
            } else if (this.mXU != null) {
                this.mXU.setVisibility(0);
            }
            if (this.mRG.getVisibility() != 0 && z2) {
                this.mRG.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_top_anim));
            }
            s(!z3);
            this.mRG.setVisibility(0);
            v(true);
            if (this.mYf != null) {
                this.mYf.K(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mYe).e(false);
            if (this.mYv != null) {
                this.mYv.dismiss();
            }
            if (this.mYw != null) {
                this.mYw.dismiss();
            }
            if (this.mRP.getVisibility() != 8 && z2) {
                this.mRP.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_bottom_anim));
            }
            this.mRP.setVisibility(8);
            if (this.mRG.getVisibility() != 8 && z2) {
                this.mRG.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_top_anim));
            }
            this.mRG.setVisibility(8);
            v(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean cXQ() {
        if (this.mYN == null || !this.mYN.isShown()) {
            return false;
        }
        this.mYN.d();
        return true;
    }

    public boolean dCY() {
        if (this.mSF == null || !this.mSF.isShown()) {
            return false;
        }
        this.mSF.a();
        return true;
    }

    public boolean dCZ() {
        if (this.mSK == null || !this.mSK.b()) {
            return false;
        }
        this.mSK.a();
        return true;
    }

    public boolean dDa() {
        if (this.mSB && this.mYJ != null) {
            if (this.mYJ != null) {
                this.mYJ.e();
            }
            if (this.mTc != null) {
                this.mTc.setText("");
            }
            if (this.mRF == 2) {
                av(true, i());
                return true;
            }
            dDl();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXO != null) {
            if (this.mSK == null) {
                this.mSK = (PopH5Menu) ((ViewStub) this.mXO.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mSK.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mSK.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            l(view, 0, this.mRG.getHeight() + this.mRG.getTop());
        } else if (id == a.f.btn_barrage) {
            m(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mYe, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                g.c(this.mYe, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mYd.a(false);
                a(false, false);
                ((VideoPlayer) this.mYe).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.e(this.mYe, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mRr == null || this.mRr.mUt == null || !this.mRr.mUt.mInPKMode) {
                ((VideoPlayer) this.mYe).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mSr) {
                f(this.mSc.getText().toString());
            } else {
                a(this.mSc.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dBS().c) {
                com.kascend.chushou.d.h.dBS().b(false);
                this.mRY.cancel();
                this.mRY.reset();
                this.mRX.clearAnimation();
                this.mRZ.setVisibility(8);
            }
            k(view, 0, this.mXO.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.t(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mYe, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            j(view, x, this.mXO.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mYd.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mYe, null) && this.mYd != null && this.mYd.mRa != null) {
                if (this.mSr) {
                    dDu();
                    return;
                }
                if (this.mYd != null && this.mYd.mRa != null && this.mYd.mRa.count > 0) {
                    this.mSe.setVisibility(8);
                } else {
                    this.mSe.setVisibility(0);
                }
                this.mSr = true;
                this.mSn.setBackgroundResource(a.e.ic_trumpet_p);
                this.mSo.setVisibility(0);
                this.mSo.setSelected(true);
                this.mSo.setTextColor(Color.parseColor("#ff5959"));
                if (this.mSc != null) {
                    this.mSc.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mSq <= 9) {
                this.mSq++;
                this.mSm.setText(this.mSq + "");
            }
            dDs();
        } else if (id == a.f.tv_cut_count) {
            if (this.mSq > 1) {
                this.mSq--;
                this.mSm.setText(this.mSq + "");
            }
            dDs();
        } else if (id == a.f.tv_buy_head) {
            dDt();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mTc.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mTc.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mTc);
                this.mYJ.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mSc != null && this.mRV != null && this.mSb != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mSc);
                this.mRV.setVisibility(8);
                if (this.mRF == 2) {
                    this.mSb.setVisibility(0);
                }
            }
        } else if (this.mRV != null && this.mSb != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
            if (this.mRF == 2) {
                this.mRV.setVisibility(0);
            }
            this.mSb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dBS().c(roomToast.mToastContent);
            if (this.mSN == null) {
                dDb();
            }
            if (this.mSO != null) {
                this.mSO.setText(roomToast.mToastContent);
            }
            if (!this.mSN.isShowing()) {
                if (this.mSA != null) {
                    this.mSN.showAtLocation(this.mSA, 85, 0, this.mXO.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
                    RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mSN != null) {
                                a.this.mSN.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mSN.dismiss();
        }
    }

    private void dDb() {
        if (this.mSN == null) {
            View inflate = LayoutInflater.from(this.mYe).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mSO = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mSN = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 160.0f), -2);
            this.mSN.setFocusable(false);
            this.mSN.setOutsideTouchable(false);
            this.mSN.setAnimationStyle(a.j.gift_toast_style);
            this.mSN.update();
        }
    }

    private void j(View view, int i, int i2) {
        if (this.mYD != null && this.mYD.isShowing()) {
            this.mYD.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
        if (this.mZa == null) {
            dDQ();
        }
        if (!this.mZa.isShowing()) {
            this.mZa.showAtLocation(view, 83, i, i2);
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mYd.dCC().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mZa.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDc() {
        if (this.mZd != null) {
            if (h.isEmpty(this.mZe)) {
                if (((VideoPlayer) this.mYe).q) {
                    this.mZd.bU(this.mYd != null ? this.mYd.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mZd.bU(this.mYd != null ? this.mYd.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mYe).q && this.mZe.size() == 2 && this.mZe.contains("4") && this.mZe.contains("2")) {
                this.mZd.bU(this.mYd != null ? this.mYd.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mZe.size() > 1 || !((VideoPlayer) this.mYe).q) {
                this.mZd.bU(this.mYd != null ? this.mYd.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mZe.get(0))) {
                this.mZd.bU(this.mYd != null ? this.mYd.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mZe.get(0))) {
                this.mZd.bU(this.mYd != null ? this.mYd.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mZe.get(0))) {
                this.mZd.bU(this.mYd != null ? this.mYd.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
        if (this.mYD == null) {
            al();
            this.mYD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mYD.isShowing() && this.mRF == 2) {
            this.mYD.showAtLocation(view, 83, i, this.mYe.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYd.dCC().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYD.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mXX != null) {
            this.mXX.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                g.c(this.mYe, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mUs.getPlayState() == 4) {
                        e(true);
                        if (this.mYd.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mYd.a(false);
                        ((VideoPlayer) this.mYe).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mUs.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mUs.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                g.c(this.mYe, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mYd.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mYe).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
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
        if (this.mYR != null) {
            if (z) {
                this.mYR.setVisibility(0);
            }
            this.mYR.dPC();
            if (!z) {
                this.mYR.setVisibility(8);
            }
        }
        g.c(this.mYe, this.mYe.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mRQ != null) {
                this.mRQ.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mXY != null) {
                this.mXY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mRQ != null) {
            this.mRQ.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mXY != null) {
                    this.mXY.setVisibility(8);
                }
            }
        }
    }

    private void dDd() {
        this.e = false;
        k(true, false, true);
    }

    private void dDe() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mRB[i];
        if (this.mRF != i2 || this.Sw != i) {
            this.Sw = i;
            this.mRF = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dCR();
            a(this.mYd != null ? this.mYd.mRb.get("1") : null);
            if (i2 == 2) {
                k();
                av(true, i3);
                u(true);
                b(true);
                dDh();
                com.kascend.chushou.toolkit.a.c.a(this.mYe, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            av(false, i3);
            u(false);
            b(false);
            if (this.mYD != null && this.mYD.isShowing()) {
                this.mYD.dismiss();
            }
            if (i2 == 99) {
                if (this.mRC != null && this.mRC[i] != null && (this.mRC[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mRC[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mYe, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mYe, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mYe, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mYe, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.Sw = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.mRF == 2) {
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
        ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mYf != null) {
            if (this.mSb != null && this.mSb.getVisibility() == 0) {
                t(false);
            }
            if (this.mXY != null && this.mXY.getVisibility() == 0) {
                this.f = true;
            }
            au(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mRE != null) {
            this.mRE.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mRE != null) {
            this.mRE.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mRE != null) {
            this.mRE.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mRE != null) {
            this.mRE.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mSA != null) {
            int size = iconConfig.configs.size();
            this.mSA.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mYe).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mSA, false);
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
                this.mSA.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mYd != null ? this.mYd.mRb : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mRE != null) {
            this.mRE.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dDc();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mSx != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mSx.xo(a.c.kas_white);
            } else if (this.mRF == 2) {
                this.mSx.bU(str, a.c.kas_white);
                if (this.mSy != null) {
                    this.mSy.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mSx.xo(a.c.kas_white);
                if (this.mSy != null) {
                    this.mSy.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mSy != null) {
                    this.mSy.setTextColor(a);
                    this.mSy.setTabTextSelectColor(a2);
                    this.mSy.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRX != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mRX.xo(a.e.ic_hotwords_black_n);
            } else {
                this.mRX.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRW != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dEc().a(str, this.mRW, a.e.player_skin_input);
            } else {
                this.mRW.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mSa != null) {
                this.mSa.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mRE != null) {
            this.mRE.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYe instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCi = ((VideoPlayer) this.mYe).dCi();
            if (this.mYU == null) {
                this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYU.setVisibility(0);
            this.mYU.a(2, dCi);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mRE != null) {
            this.mRE.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mRE != null) {
            this.mRE.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mRE != null) {
            this.mRE.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mRE != null) {
            this.mRE.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mRE != null && this.mYd != null) {
            this.mRE.b(this.mYd.mQY);
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
            if (i < 0 || i >= a.this.mRB.length) {
                return null;
            }
            switch (a.this.mRB[i]) {
                case 1:
                    if (a.this.mRD == null) {
                        a.this.mRD = com.kascend.chushou.view.user.a.a(2, null, a.this.mYd.a, false, a.this.mYd.h, false);
                    }
                    a.this.mRC[i] = a.this.mRD;
                    return a.this.mRD;
                case 2:
                    if (a.this.mRE == null) {
                        a aVar = a.this;
                        if (a.this.mRr != null && a.this.mRr.mUt != null) {
                            z = a.this.mRr.mUt.mInPKMode;
                        }
                        aVar.mRE = com.kascend.chushou.player.ui.a.wp(z);
                    }
                    a.this.mRC[i] = a.this.mRE;
                    return a.this.mRE;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mYd != null && a.this.mYd.dCC() != null && !h.isEmpty(a.this.mSH)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mSH.get(i).url);
                        h5Options.a = a.this.mSH.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mRC[i] = a;
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
            return a.this.mRB.length;
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
            int dimensionPixelSize = a.this.mYe.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
        } else if (System.currentTimeMillis() - this.mRA <= 3000) {
            g.Om(a.i.str_too_fast);
            return false;
        } else {
            dDj();
            if (!com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYe).dCd().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mRA = System.currentTimeMillis();
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                a(this.mYd.dCC().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYd.h);
            }
            g(this.b);
            if (!z && this.mSc != null) {
                this.mSc.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dDj();
            if (com.kascend.chushou.d.e.c(this.mYe, null) && LoginManager.Instance().getUserInfo() != null && this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                a(this.mYd.dCC().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mSc != null) {
                this.mSc.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mRE != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mYd.dCC().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mYd.dCC().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mYe).mPl;
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
                        this.mRE.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mRE.a(arrayList, true, true);
        }
    }

    private void dDf() {
        if (this.mRE != null) {
            this.mRE.e();
        }
        if (this.mSF != null && this.mSF.isShown()) {
            this.mSF.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ox() {
        super.ox();
        if (this.mYe instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mYd != null) {
            this.mYd.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dDf();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mSD);
        if (this.mYe != null) {
            if (this.mSD || "10004".equals(((VideoPlayer) this.mYe).t)) {
                this.mSD = true;
                if (this.mYd != null) {
                    this.mYd.f = null;
                    if (this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                        this.mYd.dCC().mRoominfo.mGameId = null;
                    }
                }
                dCU();
                return;
            }
            this.mSD = true;
            if (this.mYe != null) {
                ((VideoPlayer) this.mYe).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mSD = false;
        if (this.mRO != null) {
            this.mRO.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mSD = false;
        if (this.mRO != null) {
            this.mRO.setVisibility(8);
        }
        super.i(z);
    }

    private void dDg() {
        dCS();
        if (i()) {
            dDi();
            dDO();
            return;
        }
        dCU();
    }

    private void dDh() {
    }

    private void dDi() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dDN().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mYR != null) {
            this.mYR.setVisibility(0);
        }
        if (this.mRo != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mRo.d();
        }
        if (this.mRV != null) {
            this.mRV.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mRL.setVisibility(0);
            this.mRL.setOnClickListener(this);
        } else {
            this.mRL.setVisibility(8);
        }
        this.mRQ.setVisibility(0);
        this.mRM.setVisibility(0);
        this.mXV.setVisibility(0);
        if (this.p) {
            this.mXW.setVisibility(0);
        } else {
            this.mXW.setVisibility(8);
        }
        dDh();
        av(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mYU != null && this.mYU.a(i, keyEvent)) {
                return true;
            }
            if (this.mSK != null && this.mSK.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mSL != null && this.mSL.onKeyDown(i, keyEvent)) || dDk()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mTd != null && this.mTd.getVisibility() == 0 && b(motionEvent, this.mTd)) {
                this.mTd.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mTc);
                return true;
            } else if (this.mSB && this.mTd != null && this.mTd.getVisibility() == 8 && g(this.mYJ.b, motionEvent)) {
                dDa();
                return true;
            } else if (this.mSK != null && this.mSK.b() && g(this.mSK, motionEvent)) {
                this.mSK.a();
                return true;
            } else if (this.mSL != null && this.mSL.b() && g(this.mSL, motionEvent)) {
                this.mSL.a();
                return true;
            } else if (b(motionEvent, this.mSb)) {
                return dDj();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dDj() {
        boolean z;
        b(this.mSM, 10);
        boolean z2 = false;
        if (this.mSs != null && this.mSs.getVisibility() == 0) {
            this.mSs.setVisibility(8);
            this.mSt.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSu) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
            this.mSt.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSb == null || this.mSb.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mSr) {
                dDu();
            }
            this.mSb.setVisibility(8);
            z = true;
        }
        if (this.mRF == 2) {
            RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mRV != null && a.this.mRF == 2) {
                        a.this.mRV.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dDk() {
        if (dDj()) {
            return true;
        }
        if (this.mYD == null || !this.mYD.isShowing()) {
            return dDa() || dCY() || cXQ();
        }
        this.mYD.dismiss();
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
    public void dDl() {
        this.mRV.setVisibility(8);
        this.mSb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z, boolean z2) {
        if (this.mRV != null) {
            if (z) {
                if (this.mRV.getVisibility() != 0) {
                    this.mRV.setVisibility(0);
                    this.mRV.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_bottom_anim));
                }
            } else if (this.mRV.getVisibility() != 4) {
                this.mRV.setVisibility(4);
                this.mRV.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mRO != null) {
            this.mRO.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDm() {
        return this.mSR;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dDM()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mYd != null) {
                        this.mYd.f = null;
                        this.mYd.dCC().mRoominfo.mGameId = null;
                    }
                    dCU();
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
        if (this.mYd != null && this.mYd.dCD() != null) {
            a(this.mYd.dCD());
        }
        this.p = false;
        if (this.mYd == null || this.mYd.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mYd.f.size()) {
                if (!"2".equals(this.mYd.f.get(i2).mType)) {
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
        if (this.mRE != null) {
            this.mRE.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dDM()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mRR != null && this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                this.mRR.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mYd.dCC().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dDM() && !this.mSI && (c = c(1, -1)) >= 0 && c < this.mSH.size() && this.mSz != null) {
            this.mSz.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dDM() && !this.mSI) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mYe, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCj = ((VideoPlayer) this.mYe).dCj();
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(2, dCj);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCk = ((VideoPlayer) this.mYe).dCk();
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(2, dCk);
            } else if (bVar.a == 9) {
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mSs != null) {
            this.mSs.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dDM() && !this.mSI) {
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
        if (!dDM() && this.mYd != null) {
            String str = this.mYd.a;
            RoomInfo dCE = this.mYd.dCE();
            if (dCE != null && mVar.a(dCE.mCreatorUID, str)) {
                dCE.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.mRF == 2) {
            RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dDM()) {
                        a.this.t(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mSc != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mSc);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDn() {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
            if (this.mSE == null) {
                this.mSE = new f(getActivity());
            }
            this.mSE.a(this.mYd.dCC().mRoominfo);
            if (!this.mSE.isShowing()) {
                this.mSE.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mRE != null) {
            this.mRE.d();
        }
    }

    private void dB(View view) {
        this.mRS = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mRT = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mRT.setText(new tv.chushou.zues.widget.a.c().O(this.mYe, a.e.videoplayer_4g_video).append("  ").append(this.mYe.getString(a.i.videoplayer_4g_video)));
        this.mRU = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mRU.setText(new tv.chushou.zues.widget.a.c().O(this.mYe, a.e.videoplayer_4g_audio).append("  ").append(this.mYe.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mRS.setVisibility(8);
                    ((VideoPlayer) a.this.mYe).b(a.this.bR);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mRS.setVisibility(8);
                    ((VideoPlayer) a.this.mYe).c(a.this.bR);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dBL().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mRT.setOnClickListener(onClickListener);
        this.mRU.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mYd != null && !h.isEmpty(this.mYd.f)) {
            f(this.mYd.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.bR = z;
            this.p = false;
            if (this.mYd != null && this.mYd.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mYd.f.size()) {
                        break;
                    } else if (!"2".equals(this.mYd.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mRS != null) {
                this.mRS.setVisibility(0);
                this.mRT.setVisibility(0);
                this.mRU.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mRS != null) {
            this.mRS.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mSV == null) {
                this.mSV = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dDM()) {
                            a.this.dDo();
                        }
                    }
                };
                if (this.mYf != null) {
                    this.mYf.d(this.mSV, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mSV != null && this.mYf != null) {
            this.mYf.removeCallbacks(this.mSV);
            this.mSV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDo() {
        if (LoginManager.Instance().islogined() && this.mRE != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mYe, "显示双击666_num", null, new Object[0]);
            if (this.mYd != null) {
                this.mYd.b(false);
            }
            d(false);
            this.mRE.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXO != null) {
            if (this.mSL == null) {
                this.mSL = (InteractionView) ((ViewStub) this.mXO.findViewById(a.f.view_interaction)).inflate();
                this.mSL.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mSL.a();
                    }
                });
            }
            if (this.mSL != null) {
                this.mSL.b(configDetail);
                this.mSL.c();
                this.mSL.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQn()) {
                g.M(this.mYe, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mYe, null) && (this.mYe instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYd != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYe, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYd != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYe, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mYe, configDetail.mUrl, this.mYe.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mYe, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    dDp();
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

    private void dDp() {
        if (this.mSB) {
            dDa();
            return;
        }
        if (this.mYe.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYd.dCC().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mYe != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mRr == null) {
                this.mRr = new com.kascend.chushou.player.e.a();
            }
            this.mRr.b = str;
            this.mRr.mUt.copy(pkNotifyInfo);
            if (this.mRr.mUt.mAction == 6) {
                this.mRr.mUt.mInPKMode = true;
                this.u = this.mRr.mUt.mPkId;
            } else if (this.mRr.mUt.mAction == 7 || (this.mRr.mUt.mMode == 1 && this.mRr.mUt.mAction == 5)) {
                this.mRr.mUt.mInPKMode = true;
                this.u = this.mRr.mUt.mPkId;
                if (dDr() != null) {
                    if (2 == this.mRF && this.mSY != null) {
                        this.mSY.setVisibility(0);
                    }
                    dDr().b(this.mRr.mUt, false);
                    dDr().a(this.mRr.mUt.mMode, "1");
                    if (this.mRr.mUt.mAction == 5 && this.mRr.mUt.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mRr.mUt.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mRr.mUt.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mRr.mUt.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mRr.mUt.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mRr.mUt.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dDr().a(this.mRr.mUt);
                        if (this.mRr.mUt.destinyInfo == null || this.mRr.mUt.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dDr().a(parseInt, this.mRr.mUt.mPkUpdateInfo.remainDuration, j, this.mRr.mUt.mMode, i);
                    }
                    if (!h.isEmpty(this.mRr.mUt.mPkUpdateInfo.specialMomentList) && dDr() != null) {
                        dDr().a(this.mRr.mUt, true);
                    }
                }
                dDq();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.QV(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mRr.mUt.mInPKMode = false;
                dDq();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.QV(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dDq() {
        if (this.mRr != null && this.mRr.mUt != null) {
            if (this.mRr.mUt.mInPKMode) {
                this.y.setText(this.mRr.mUt.mPkUserNickname);
                this.mRt.setVisibility(0);
                if (this.mXU != null) {
                    this.mXU.setEnabled(false);
                }
                if (this.mXW != null) {
                    this.mXW.setEnabled(false);
                    return;
                }
                return;
            }
            this.mRt.setVisibility(8);
            if (this.mXU != null) {
                this.mXU.setEnabled(true);
            }
            if (this.mXW != null) {
                this.mXW.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dDr() {
        if (this.mYe == null || this.mXO == null || this.mSY == null) {
            return null;
        }
        if (this.mRs == null) {
            if (this.mSX == null) {
                this.mSX = ((ViewStub) this.mXO.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mRs = new com.kascend.chushou.player.e.b();
            this.mRs.a(this.mSY, this.mSX, (View) null, this.mYe, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dPW()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mYd != null) {
                        append.append(a.this.mYd.dCE().mRoomID);
                    }
                    if (a.this.mRr != null && a.this.mRr.mUt != null) {
                        append.append("&mode=").append(a.this.mRr.mUt.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mYe, append.toString());
                }
            });
        }
        return this.mRs;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mSo != null && this.mYd != null && this.mYd.mRa != null) {
            this.mSo.setText(tv.chushou.zues.utils.b.Ol(this.mYd.mRa.count));
            this.mSo.setVisibility(0);
            if (this.mYd.mRa.count < 1) {
                dDu();
            }
            if (this.mSf != null) {
                this.mSf.setText(this.mYd.mRa.primaryName);
            }
            if (this.mSg != null) {
                this.mSg.setText(this.mYd.mRa.desc);
            }
            dDs();
        }
    }

    public void dDs() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mSq * h.parseLong(this.mYd.mRa.point)));
        if (this.mSi != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mYe.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mYe, a.e.icon_coin_new);
            cVar.append(this.mYe.getString(a.i.str_buy_count_coin2));
            this.mSi.setText(cVar);
        }
    }

    private void dDt() {
        if (com.kascend.chushou.d.e.c(this.mYe, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mSq);
        }
    }

    private void u(boolean z) {
        if (this.mXO != null && this.mSY != null) {
            if (z) {
                if (this.mRr != null && this.mRr.mUt != null && this.mRr.mUt.mInPKMode) {
                    this.mSY.setVisibility(0);
                    return;
                }
                return;
            }
            this.mSY.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mXO != null && this.mRw != null) {
            if (z) {
                if (this.E && 2 == this.mRF) {
                    this.mRw.setVisibility(0);
                    return;
                }
                return;
            }
            this.mRw.setVisibility(8);
        }
    }

    private void v(boolean z) {
        if (z) {
            if (this.mRr != null && this.mRr.mUt != null && this.mRr.mUt.mInPKMode && this.mRt != null) {
                this.mRt.setVisibility(0);
            }
        } else if (this.mRt != null) {
            this.mRt.setVisibility(8);
        }
    }

    private void dDu() {
        this.mSr = false;
        this.mSn.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mYd != null && this.mYd.mRa != null) {
            if (this.mYd.mRa.count < 1) {
                this.mSo.setVisibility(8);
            } else {
                this.mSo.setVisibility(0);
                this.mSo.setSelected(false);
                this.mSo.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mSe.setVisibility(8);
        if (this.mSc != null) {
            this.mSc.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dDp();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mSa != null) {
            this.mSa.performClick();
        }
    }

    public boolean dDv() {
        return this.mRF == 2;
    }
}
