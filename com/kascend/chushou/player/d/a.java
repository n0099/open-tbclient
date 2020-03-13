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
    private int[] mRO;
    private Fragment[] mRP;
    private ImageView mRU;
    private MarqueeTextView mRV;
    private MarqueeTextView mRW;
    private ImageView mRX;
    private ImageView mRY;
    private ImageButton mRZ;
    private TextView mSA;
    private ImageView mSB;
    private TextView mSD;
    private KPSwitchPanelLinearLayout mSG;
    private ImageView mSH;
    private c mSJ;
    private d.a mSK;
    private FrescoThumbnailView mSL;
    private PagerSlidingTabStrip mSM;
    private KasViewPager mSN;
    private LinearLayout mSO;
    private f mSS;
    private ViewMicPerson mST;
    public ArrayList<RoomTab> mSV;
    private PopH5Menu mSY;
    private InteractionView mSZ;
    public String mSa;
    private RecommendView mSb;
    private TextView mSe;
    private RelativeLayout mSf;
    private TextView mSg;
    private TextView mSh;
    private RelativeLayout mSi;
    private View mSj;
    private FrescoThumbnailView mSl;
    private AnimationSet mSm;
    private ImageView mSn;
    private TextView mSo;
    private RelativeLayout mSq;
    private PastedEditText mSr;
    private TextView mSs;
    private LinearLayout mSt;
    private TextView mSu;
    private TextView mSv;
    private TextView mSw;
    private TextView mSx;
    private TextView mSy;
    private TextView mSz;
    private int mTa;
    private PopupWindow mTb;
    private TextView mTc;
    private GiftAnimationLayout mTd;
    private com.kascend.chushou.player.b.a mTe;
    private Runnable mTi;
    private View mTl;
    private LivePKBarUserValue mTm;
    private String mTn;
    private TextView mTp;
    private ImageView mTq;
    private EditText mTr;
    private View mTs;
    private View mTt;
    private View mTu;
    private String mTz;
    private long mRN = 0;
    private com.kascend.chushou.view.user.a mRQ = null;
    private com.kascend.chushou.player.ui.a mRR = null;
    private int mRS = -1;
    private int Sw = 0;
    private View mRT = null;
    private View mSc = null;
    private ImageButton mSd = null;
    private int mSE = 1;
    private boolean mSF = false;
    private boolean mSI = false;
    private boolean mSQ = false;
    private boolean mSR = false;
    private boolean mSU = false;
    private boolean mSW = false;
    private boolean mSX = true;
    private int mTf = 0;
    private int mTg = 0;
    private int mTh = -1;
    private final Rect mTk = new Rect();
    private boolean mTv = false;
    private C0696a mTw = null;
    private boolean da = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSa = getArguments().getString("mCover");
        this.mSX = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mYb = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mYb;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dDP()) {
            c(view);
            dCO();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.mSW = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mYW != null) {
            this.mYW.b();
        }
        if (this.mYr != null && (this.mYr instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYr).wh(true);
            ((VideoPlayer) this.mYr).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSW = true;
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
        this.mSE = 1;
        this.mSF = false;
        U();
        if (this.mYs != null) {
            this.mYs.cq(null);
            this.mYs = null;
        }
        if (this.mSb != null) {
            dDQ().removeAllViews();
            this.mSb = null;
        }
        this.c = null;
        this.mRz = null;
        tv.chushou.zues.a.a.cr(this);
        this.mSM = null;
        this.mSN = null;
        this.mRR = null;
        this.mRQ = null;
        if (this.mRP != null) {
            for (int i = 0; i < this.mRP.length; i++) {
                this.mRP[i] = null;
            }
        }
        this.mRP = null;
        if (this.mSr != null) {
            this.mSr.addTextChangedListener(null);
            this.mSr.setOnTouchListener(null);
            this.mSr.setOnEditorActionListener(null);
            this.mSr = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mYr, this.mSJ);
        if (this.mYr != null && (this.mYr instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYr).dCj();
        }
        this.mSK = null;
        this.mSJ = null;
        if (this.mST != null) {
            this.mST.b();
            this.mST = null;
        }
        if (this.mTb != null) {
            this.mTb.dismiss();
        }
        if (this.mTe != null) {
            this.mTe.a();
            this.mTe = null;
            this.mTd = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mTm = (LivePKBarUserValue) this.mYb.findViewById(a.f.live_pk_bar_user);
        this.mYk = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mTv) {
            this.mTv = true;
            if (this.mTt == null) {
                this.mTt = this.mYb.findViewById(a.f.vs_async_view);
                this.mTt = ((ViewStub) this.mTt).inflate();
            }
            if (this.mTu == null) {
                this.mTu = this.mYb.findViewById(a.f.vs_async_notification_view);
                this.mTu = ((ViewStub) this.mTu).inflate();
            }
            this.mRJ = (VoiceInteractionView) this.mYb.findViewById(a.f.voiceInteractiveView);
            t();
            dA(this.mYb);
            cXN();
            ((VideoPlayer) this.mYr).q();
            this.mRE = new com.kascend.chushou.player.e.a();
        }
    }

    private void dA(View view) {
        this.mSL = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mSM = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mSN = (KasViewPager) view.findViewById(a.f.vp_main);
        dCP();
        dCQ();
        dCV();
        if (this.mYq != null) {
            I();
            a(this.mYq.mRl, this.mYq.mRp);
        }
        this.aSz = 0;
        this.mZb = 0L;
        this.mYX = (RoundProgressBar) this.mYb.findViewById(a.f.roundProgressBar);
        this.mYY = (TextView) this.mYb.findViewById(a.f.tv_paonum);
        this.mYZ = (FrescoThumbnailView) this.mYb.findViewById(a.f.iv_paoicon);
        this.mZg = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.mSQ = false;
                if (a.this.mRS == 2) {
                    a.this.av(true, a.this.i());
                } else {
                    a.this.dDo();
                }
                a.this.b(a.this.mTa, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.mSQ = true;
                if (a.this.mRS == 2) {
                    a.this.av(false, a.this.i());
                } else {
                    a.this.dDo();
                }
                if (a.this.mYW != null) {
                    a.this.mYW.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hd(a.this.mYr).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mYr)) - a.this.mYW.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mYr, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mYr, 54.0f) * 2);
                    if (statusBarHeight < a.this.mTa) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mZa = (PaoGuideView) this.mYb.findViewById(a.f.rlPaoGuideView);
        this.mST = (ViewMicPerson) this.mYb.findViewById(a.f.rl_mic_person_view);
    }

    private void dCO() {
        this.mUF = ((VideoPlayer) this.mYr).dCd();
        this.mYq = ((VideoPlayer) this.mYr).dCg();
        dB(this.mYb);
        this.mTf = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
        this.mTg = tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        if (com.kascend.chushou.b.dBO().d == 0 && this.mTg > 0) {
            View findViewById = this.mYb.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mTg);
        }
        dDa();
        dCY();
        if (!this.mSX) {
            Q();
        }
        dCW();
        a();
        if (this.c == null) {
            this.mRz = new d.a();
            this.c = new GestureDetector(this.mYr, this.mRz);
        }
        this.mRB = ((VideoPlayer) this.mYr).dCh();
        this.mRB.a(this);
        if (this.mTe != null) {
            this.mTe.a();
            this.mTe = null;
        }
        this.mTd = (GiftAnimationLayout) this.mYb.findViewById(a.f.ll_gift_animation);
        this.mTd.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mYq != null) {
            this.mTe = new com.kascend.chushou.player.b.a(this.mYr.getApplicationContext(), this.mTd);
            this.mTe.a(this.mYq);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mYb.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mYl = (PlayerErrorView) this.mYb.findViewById(a.f.view_net_error_msg);
        this.mYl.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dCT();
        dDg();
        if (this.mYq.dCG() != null) {
            a(this.mYq.dCG());
        }
        FullRoomInfo dCF = this.mYq.dCF();
        if (dCF != null) {
            dDj();
            if (i()) {
                this.ak = false;
                wo(true);
                this.mYs.Of(8);
            }
            this.mSe.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dCF.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mRT.setVisibility(0);
        this.ak = false;
        wo(true);
        this.mYs.Of(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mYr).n();
        if (this.mYq != null && !h.isEmpty(this.mYq.mRn)) {
            b(this.mYq.mRn);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dCq;
        dCP();
        k();
        FullRoomInfo dCF = this.mYq.dCF();
        if (dCF != null) {
            if (dCF.mRoominfo != null) {
                this.mSe.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dCF.mRoominfo.mOnlineCount)));
                this.mTn = dCF.mRoominfo.mRoomID;
            }
            dDj();
            if (!h.isEmpty(dCF.mRoomToastList)) {
                Iterator<RoomToast> it = dCF.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dBV().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mYq != null && this.mYq.l()) {
                d(true);
            }
            if (this.mYr != null && (this.mYr instanceof VideoPlayer) && (dCq = ((VideoPlayer) this.mYr).dCq()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dCq.mUG, dCq.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mSO);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dCP() {
        boolean z = true;
        if (this.mYq == null || this.mYq.dCF() == null || this.mYq.dCF().mRoominfo == null || h.isEmpty(this.mYq.dCF().mRoomTabs)) {
            this.mSU = false;
            this.mRP = new Fragment[2];
            this.mRO = new int[2];
            this.mRO[0] = 2;
            this.mRO[1] = 1;
            return;
        }
        this.mSU = true;
        this.mSV = new ArrayList<>();
        Iterator<RoomTab> it = this.mYq.dCF().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mSV.add(next);
            }
        }
        if (this.mSV.size() >= 2 && this.mRO != null && this.mRO.length >= 2 && this.mSV.get(0).type == this.mRO[0] && this.mSV.get(1).type == this.mRO[1]) {
            z = false;
        }
        this.mRP = new Fragment[this.mSV.size()];
        this.mRO = new int[this.mSV.size()];
        for (int i = 0; i < this.mSV.size(); i++) {
            this.mRO[i] = this.mSV.get(i).type;
        }
        if (z) {
            this.mTw = new C0696a(getChildFragmentManager());
            this.mSN.setAdapter(this.mTw);
        }
    }

    private void dCQ() {
        this.mSq = (RelativeLayout) this.mYb.findViewById(a.f.rl_edit_bar);
        this.mSl = (FrescoThumbnailView) this.mYb.findViewById(a.f.btn_hotword);
        this.mSl.xo(a.e.ic_hotwords_black_n);
        this.mSl.setOnClickListener(this);
        this.mSn = (ImageView) this.mYb.findViewById(a.f.iv_task_badge);
        this.mSm = (AnimationSet) AnimationUtils.loadAnimation(this.mYr, a.C0690a.anim_hotword);
        this.mSm.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dBV().c) {
                    a.this.mSl.clearAnimation();
                    a.this.mSl.startAnimation(a.this.mSm);
                }
            }
        });
        if (com.kascend.chushou.d.h.dBV().c) {
            this.mSl.startAnimation(this.mSm);
            this.mSn.setVisibility(0);
        }
        this.mSo = (TextView) this.mYb.findViewById(a.f.tv_bottom_input);
        this.mSo.setOnClickListener(this);
        this.mZq = (FrescoThumbnailView) this.mYb.findViewById(a.f.ll_btn_set);
        this.mZq.setOnClickListener(this);
        this.mSO = (LinearLayout) this.mYb.findViewById(a.f.ll_bottom_all_button);
        this.mSi = (RelativeLayout) this.mYb.findViewById(a.f.rl_bottom_input);
        this.mSj = this.mYb.findViewById(a.f.ll_bottom_input);
        this.mSi.setVisibility(8);
        this.mSr = (PastedEditText) this.mYb.findViewById(a.f.et_bottom_input);
        this.mSr.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mSs.setEnabled(editable.length() > 0);
            }
        });
        this.mSr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mSs);
                    return true;
                }
                return true;
            }
        });
        this.mSr.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.mSr);
                }
                return false;
            }
        });
        this.mSH = (ImageView) this.mYb.findViewById(a.f.iv_btn_emoji);
        this.mSH.setVisibility(8);
        this.mSs = (TextView) this.mYb.findViewById(a.f.tv_btn_send);
        this.mSs.setOnClickListener(this);
        this.mSG = (KPSwitchPanelLinearLayout) this.mYb.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dBO().d == 0) {
            this.mSG.setUseStatusBar(true);
        }
        this.mSt = (LinearLayout) this.mYb.findViewById(a.f.head_trumpet);
        this.mSt.setVisibility(8);
        this.mSt.setOnClickListener(this);
        this.mSu = (TextView) this.mYb.findViewById(a.f.tv_primary_name);
        this.mSv = (TextView) this.mYb.findViewById(a.f.tv_primary_desc);
        this.mSy = (TextView) this.mYb.findViewById(a.f.tv_cut_count);
        this.mSy.setOnClickListener(this);
        this.mSA = (TextView) this.mYb.findViewById(a.f.tv_head_count);
        this.mSA.setText(this.mSE + "");
        this.mSz = (TextView) this.mYb.findViewById(a.f.tv_plus_count);
        this.mSz.setOnClickListener(this);
        this.mSx = (TextView) this.mYb.findViewById(a.f.tv_buy_count_coin);
        this.mSw = (TextView) this.mYb.findViewById(a.f.tv_buy_head);
        this.mSw.setOnClickListener(this);
        this.mSB = (ImageView) this.mYb.findViewById(a.f.iv_trumpet_select);
        this.mSB.setOnClickListener(this);
        this.mSD = (TextView) this.mYb.findViewById(a.f.tv_trumpet_have_count);
        this.mSF = false;
        this.mSB.setBackgroundResource(a.e.ic_trumpet_n);
        this.mSD.setVisibility(8);
        dCS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mSG, this.mSH, this.mSr, new a.InterfaceC0817a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0817a
            public void wi(boolean z) {
                if (a.this.mSH != null) {
                    if (!z) {
                        a.this.mSH.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dBO().d == 0) {
                        a.this.mSG.setDirectVisibility(0);
                    }
                    a.this.mSH.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mSK = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wj(boolean z) {
                a.this.mSI = z;
                if (z) {
                    a.this.mSH.setImageResource(a.e.cs_emoji_normal);
                    a.this.dCR();
                    return;
                }
                if (a.this.mTs != null && a.this.mTs.getVisibility() == 0) {
                    a.this.mTs.setVisibility(8);
                }
                if (a.this.mSQ) {
                    a.this.mYW.setVisibility(0);
                }
                if (a.this.mYr != null && (a.this.mYr instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mYr).wh(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mSJ = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mSG, this.mSK, ((VideoPlayer) this.mYr).dCk());
        ((VideoPlayer) this.mYr).g(((VideoPlayer) this.mYr).dCk());
        this.mTs = this.mYb.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mTp = (TextView) this.mYb.findViewById(a.f.btn_room_search);
        this.mTq = (ImageView) this.mYb.findViewById(a.f.iv_room_emoji_delete);
        this.mTr = (EditText) this.mYb.findViewById(a.f.et_room_emoji_search);
        this.mTr.setImeOptions(3);
        this.mTr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mTp);
                    return true;
                }
                return false;
            }
        });
        this.mTr.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mTp.setEnabled(editable.length() > 0);
                a.this.mTq.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mYW.setEmojiSearchText(editable.toString());
            }
        });
        this.mTp.setOnClickListener(this);
        this.mTq.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mTr);
            this.mTs.setVisibility(0);
            this.mTr.requestFocus();
        } else {
            this.mTs.setVisibility(8);
        }
        if (z2) {
            this.mTr.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCR() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hd(this.mYr).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr)) - tv.chushou.zues.widget.kpswitch.b.d.ho(this.mYr)) - tv.chushou.zues.utils.a.dip2px(this.mYr, 14.0f)) - this.mYr.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mYr, 54.0f) * 2);
        if (statusBarHeight < this.mTa) {
            b(statusBarHeight, 10);
        }
    }

    private void dCS() {
    }

    private void dCT() {
        this.mYs = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.au(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mYb.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mYr.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mYs.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mYs.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mYs.K(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mYs);
                            break;
                        case 12:
                            a.this.b(a.this.mYs);
                            break;
                        case 17:
                            a.this.dDS();
                            break;
                        case 18:
                            a.this.cXM();
                            break;
                        case 19:
                            a.this.mYp.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dCU() {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mSV)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSV.size()) {
                    if (!h.isEmpty(this.mSV.get(i2).notifyIcon)) {
                        this.mSM.bl(i2, this.mSV.get(i2).notifyIcon);
                        this.mSM.OC(i2);
                    } else if (this.mSV.get(i2).notify == 1) {
                        this.mSM.OB(i2);
                        this.mSM.OA(i2);
                    } else {
                        this.mSM.OA(i2);
                        this.mSM.OC(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mSV)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mSV.size()) {
                    if (this.mSV.get(i4).type == i) {
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
        if (this.mYq == null || this.mYq.dCF() == null || this.mYq.dCF().mRoominfo == null || h.isEmpty(this.mSV)) {
            if (i == 1) {
                return this.mYr.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mYr.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mSV.size()) {
            return this.mSV.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mSV) && i < this.mSV.size()) {
            this.mSV.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mSV) && i < this.mSV.size()) {
            this.mSV.get(i).notifyIcon = str;
        }
    }

    private void dCV() {
        if (this.mSN != null && this.mSM != null && this.mRO != null) {
            this.mRR = null;
            if (this.mRP != null) {
                for (int i = 0; i < this.mRP.length; i++) {
                    this.mRP[i] = null;
                }
            }
            if (this.mTw == null) {
                this.mTw = new C0696a(getChildFragmentManager());
                this.mSN.setAdapter(this.mTw);
            } else {
                this.mTw.notifyDataSetChanged();
            }
            this.mSN.setOffscreenPageLimit(this.mRO.length);
            this.mSM.c(this.mSN);
            this.mSM.setOnPageChangeListener(this);
            this.mSM.notifyDataSetChanged();
            this.mSM.setVisibility(0);
            this.mSN.setVisibility(0);
            if (!this.mSU) {
                this.mRS = 2;
                this.mSN.setCurrentItem(c(2, 0));
                this.mSi.setVisibility(0);
            } else {
                if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                    if (!h.isEmpty(this.mYq.dCF().mRoominfo.mGameName)) {
                        this.mRW.setText(this.mYq.dCF().mRoominfo.mGameName);
                    } else {
                        this.mRW.setText(this.mYr.getString(a.i.no_online_game_name));
                    }
                    this.mRV.setText(this.mYq.dCF().mRoominfo.mName);
                } else {
                    this.mRW.setText(this.mYr.getString(a.i.no_online_game_name));
                }
                dCU();
                if (i()) {
                    dDh();
                    if (this.mSN != null) {
                        this.mRS = 2;
                        int c = c(2, 0);
                        this.mSN.setCurrentItem(c);
                        this.mSM.setSelectItem(c);
                    }
                } else if (this.mSN != null) {
                    this.mRS = 1;
                    int c2 = c(1, 1);
                    this.mSN.setCurrentItem(c2);
                    this.mSM.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dCW() {
        this.N = new SurfaceView(this.mYr);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mYv);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dDQ().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dCX() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mYr).s();
        cXT();
        dDb();
        dDc();
        dDQ().setBackgroundResource(a.e.room_not_online);
        if (this.mSb == null) {
            this.mSb = new RecommendView(this.mYr);
            dDQ().addView(this.mSb);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mYr);
            this.mSb.setLayoutParams(layoutParams);
        }
        if (this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mYq.dCF().mRoominfo.mRoomID)) {
            this.mSb.a(this.mYq.dCF().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dDP() && a.this.mYr != null && a.this.dDQ() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mYr);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lNe);
                        if (a.this.dDQ().getChildCount() >= 2) {
                            a.this.dDQ().addView(frescoThumbnailView, 0);
                        }
                        a.this.dDQ().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dQl(), a.this.ar, a.this.mYv);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mZe != null) {
            this.mZe.dPF();
            this.mZe.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mYW != null) {
            this.mYW.e();
        }
        wo(false);
        a(false, false);
        if (this.mRB != null) {
            this.mRB.d();
        }
    }

    private void dCY() {
        int i = 0;
        this.mRT = this.mYb.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dBO().d == 0 && this.mTf > 0) {
            View findViewById = this.mYb.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.mTf;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mRU = (ImageView) this.mRT.findViewById(a.f.back_icon);
        this.mRU.setOnClickListener(this);
        this.mRV = (MarqueeTextView) this.mRT.findViewById(a.f.tv_title);
        this.mRW = (MarqueeTextView) this.mRT.findViewById(a.f.tv_Type);
        this.mRY = (ImageView) this.mYb.findViewById(a.f.btn_setting);
        this.mSc = this.mYb.findViewById(a.f.bottomview);
        if (this.mYi == null) {
            this.mYi = (ImageButton) this.mSc.findViewById(a.f.btn_barrage);
            this.mYi.setOnClickListener(this);
            if (this.mYq != null) {
                if (com.kascend.chushou.d.h.dBV().n()) {
                    this.mYi.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mYi.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mYj = (ImageButton) this.mSc.findViewById(a.f.btn_audio);
        this.mYj.setOnClickListener(this);
        if (this.mYq != null && this.mYq.d) {
            this.mYj.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mYj.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mYq != null && this.mYq.f != null) {
            while (true) {
                if (i >= this.mYq.f.size()) {
                    break;
                } else if (!"2".equals(this.mYq.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mSd = (ImageButton) this.mSc.findViewById(a.f.playbutton);
        this.mSd.setOnTouchListener(this);
        this.mRZ = (ImageButton) this.mSc.findViewById(a.f.btn_refresh);
        this.mRZ.setOnClickListener(this);
        this.mSe = (TextView) this.mSc.findViewById(a.f.tv_online_count);
        if (this.mYh == null) {
            this.mYh = (ImageButton) this.mSc.findViewById(a.f.btn_screenChange);
            this.mYh.setOnClickListener(this);
        }
        if (this.mRX == null) {
            this.mRX = (ImageView) this.mRT.findViewById(a.f.report_icon);
            this.mRX.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dDq();
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
        if (!dDP() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mRR != null) {
                        this.mRR.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                        this.mYq.dCF().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mYq.dCF().mMicStatus.onMic) {
                            dDi();
                        }
                        if (this.mYq.dCF().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mYq.dCF().mRoominfo.mCreatorUID)) {
                                i(arrayList2, this.mYq.dCF().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mYq.dCF().mMicStatus.onMic) {
                            this.mYq.dCF().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mYq.dCF().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = j(this.mYq.dCF().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mYq.dCF().mMicStatus != null && !h.isEmpty(this.mYq.dCF().mMicStatus.micRoomId) && !this.mYq.dCF().mMicStatus.micRoomId.equals("0")) {
                                this.mTz = this.mYq.dCF().mMicStatus.micRoomId;
                            }
                            if (this.mRR != null) {
                                this.mRR.a(this.mYq.dCF().mMicStatus, this.mYq.dCF().mFanItems, str, z2);
                            }
                            if (this.mST != null && this.mST.getVisibility() == 0) {
                                this.mST.a(this.mYq.dCF().mFanItems, this.mYq.dCF().mMicStatus, str, z2, this.mYq.dCF().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mRR != null) {
                                this.mRR.e();
                            }
                            if (this.mST != null && this.mST.isShown()) {
                                this.mST.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mRR != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mRR.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mRR.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mTh != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mTh = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mRE != null && this.mRE.mUG != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mRE.mUG.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mRE.mUG.mInPKMode = true;
                                    this.mRE.mUG.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRE.mUG.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRE.mUG.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRE.mUG.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRE.mUG.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRE.mUG.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mRE.mUG.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mRE.mUG.mMode = pkNotifyInfo.mMode;
                                    this.mRE.mUG.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dDu() != null) {
                                        dDu().g(true, this.mRE.mUG.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dBV().a) {
                                        if (!com.kascend.chushou.b.dBO().e) {
                                            com.kascend.chushou.b.dBO().e = true;
                                            g.M(this.mYr, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBV().a(this.mYr, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.mRS && this.mTm != null) {
                                        this.mTm.setVisibility(0);
                                    }
                                    this.mRE.mUG.mAction = 7;
                                    this.mRE.mUG.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRE.mUG.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRE.mUG.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRE.mUG.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRE.mUG.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRE.mUG.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dDt();
                                    if (dDu() != null) {
                                        dDu().g(false, 0L);
                                        dDu().b(this.mRE.mUG, true);
                                        dDu().a(this.mRE.mUG.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.QW(this.mTn);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mRE.mUG.mInPKMode = false;
                                    this.mRE.mUG.mAction = 2;
                                    dDt();
                                    if (dDu() != null) {
                                        dDu().c();
                                    }
                                    if (com.kascend.chushou.d.h.dBV().a) {
                                        if (!com.kascend.chushou.b.dBO().e) {
                                            com.kascend.chushou.b.dBO().e = true;
                                            g.M(this.mYr, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBV().a(this.mYr, false);
                                        ak();
                                    }
                                    this.mRE.b = null;
                                    this.mRE.mUG = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.QW(this.mTn);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mRE.mUG.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mRE.mUG.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mRE.mUG.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mYq.dCF().mRoominfo.mRoomID) && this.mYq.dCF().mRoominfo.mRoomID.equals(this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dDu() != null) {
                                        dDu().a(this.mRE.mUG, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mRE.mUG.copyUpdate(pkNotifyInfo);
                                    if (dDu() != null) {
                                        dDu().a(this.mRE.mUG);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mRE.mUG.copyStop(pkNotifyInfo);
                                        if (dDu() != null) {
                                            dDu().w(this.mRE.mUG.mMaxFreeDuration, this.mRE.mUG.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mRE.mUG.copyResult(pkNotifyInfo);
                                    if (!this.mSW && dDu() != null) {
                                        int i5 = 1;
                                        if (this.mRE.mUG.destinyInfo != null && this.mRE.mUG.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dDu().a(h.parseInt(this.mRE.mUG.mResult), h.parseLong(this.mRE.mUG.mvpUid), this.mRE.mUG.mvpAvatar, this.mRE.mUG.mvpNickname, this.mRE.mUG.mMaxFreeDuration, this.mRE.mUG.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mRR != null) {
                if (LoginManager.Instance().islogined() && this.mYq != null && this.mYq.l()) {
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
                if (this.mYq == null || this.mYq.dCF() == null || this.mYq.dCF().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mYq.dCF().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dBV().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dBV().b().equals(next2.mUserID)) {
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
                this.mRR.a(arrayList, true, false);
                this.mRR.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mRO != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mRO.length) {
                    break;
                }
                if (this.mRO[i2] == 99 && this.mRP != null && this.mRP[i2] != null && (this.mRP[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mRP[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mSV.size() && this.mSM != null) {
                if (i == 0) {
                    this.mSM.setTagText(i2, new StringBuilder(this.mSV.get(i2).name).toString());
                    return;
                } else {
                    this.mSM.setTagText(i2, this.mSV.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mYi != null) {
            if (z) {
                this.mYi.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mYi.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dCZ() {
        if (this.mYb == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mYb.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
        this.ar = Math.min(hd.x, hd.y);
        this.mYv = (this.ar * this.mYr.getResources().getInteger(a.g.h_thumb_height_def)) / this.mYr.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dDQ().getLayoutParams();
        layoutParams.height = this.mYv;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mYk.getLayoutParams();
        layoutParams2.height = this.mYv;
        layoutParams2.width = this.ar;
        this.mTa = this.mYv + this.mYr.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mYr, 54.0f);
        b(this.mTa, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mYv);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dDa() {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
        this.ar = Math.min(hd.x, hd.y);
        this.mYv = (this.ar * this.mYr.getResources().getInteger(a.g.h_thumb_height_def)) / this.mYr.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dDQ().getLayoutParams();
        layoutParams.height = this.mYv;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mYk.getLayoutParams();
        layoutParams2.height = this.mYv;
        layoutParams2.width = this.ar;
        this.mTa = this.mYv + this.mYr.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mYr, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.mTa, 10);
        k();
        if (!h.isEmpty(this.mSa)) {
            File ad = tv.chushou.zues.widget.fresco.a.ad(Uri.parse(this.mSa));
            if (ad != null && ad.exists()) {
                this.mYk.setImageURI(Uri.fromFile(ad));
                this.mYk.setVisibility(0);
                return;
            }
            this.mYk.setVisibility(8);
            return;
        }
        this.mYk.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void s(boolean z) {
        if (this.mRX != null) {
            this.mRX.setVisibility(z ? 0 : 4);
        }
        if (this.mRY != null) {
            this.mRY.setVisibility(z ? 0 : 4);
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
        if (this.mYs != null) {
            this.mYs.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mYr).e(true);
            if (!z3) {
                if (this.mSc.getVisibility() != 0 && z2) {
                    this.mSc.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mYj.setVisibility(0);
                } else {
                    this.mYj.setVisibility(8);
                }
                this.mSc.setVisibility(0);
            }
            PlayUrl dCG = this.mYq.dCG();
            if (dCG != null && "2".equals(dCG.mType)) {
                if (this.mYh != null) {
                    this.mYh.setVisibility(8);
                }
            } else if (this.mYh != null) {
                this.mYh.setVisibility(0);
            }
            if (this.mRT.getVisibility() != 0 && z2) {
                this.mRT.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_top_anim));
            }
            s(!z3);
            this.mRT.setVisibility(0);
            v(true);
            if (this.mYs != null) {
                this.mYs.K(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mYr).e(false);
            if (this.mYI != null) {
                this.mYI.dismiss();
            }
            if (this.mYJ != null) {
                this.mYJ.dismiss();
            }
            if (this.mSc.getVisibility() != 8 && z2) {
                this.mSc.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_bottom_anim));
            }
            this.mSc.setVisibility(8);
            if (this.mRT.getVisibility() != 8 && z2) {
                this.mRT.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_top_anim));
            }
            this.mRT.setVisibility(8);
            v(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean cXT() {
        if (this.mZa == null || !this.mZa.isShown()) {
            return false;
        }
        this.mZa.d();
        return true;
    }

    public boolean dDb() {
        if (this.mST == null || !this.mST.isShown()) {
            return false;
        }
        this.mST.a();
        return true;
    }

    public boolean dDc() {
        if (this.mSY == null || !this.mSY.b()) {
            return false;
        }
        this.mSY.a();
        return true;
    }

    public boolean dDd() {
        if (this.mSQ && this.mYW != null) {
            if (this.mYW != null) {
                this.mYW.e();
            }
            if (this.mTr != null) {
                this.mTr.setText("");
            }
            if (this.mRS == 2) {
                av(true, i());
                return true;
            }
            dDo();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mYb != null) {
            if (this.mSY == null) {
                this.mSY = (PopH5Menu) ((ViewStub) this.mYb.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mSY.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mSY.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            m(view, 0, this.mRT.getHeight() + this.mRT.getTop());
        } else if (id == a.f.btn_barrage) {
            n(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mYr, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                g.c(this.mYr, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mYq.a(false);
                a(false, false);
                ((VideoPlayer) this.mYr).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.e(this.mYr, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mRE == null || this.mRE.mUG == null || !this.mRE.mUG.mInPKMode) {
                ((VideoPlayer) this.mYr).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mSF) {
                f(this.mSr.getText().toString());
            } else {
                a(this.mSr.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dBV().c) {
                com.kascend.chushou.d.h.dBV().b(false);
                this.mSm.cancel();
                this.mSm.reset();
                this.mSl.clearAnimation();
                this.mSn.setVisibility(8);
            }
            l(view, 0, this.mYb.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.t(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mYr, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            k(view, x, this.mYb.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mYq.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mYr, null) && this.mYq != null && this.mYq.mRo != null) {
                if (this.mSF) {
                    dDx();
                    return;
                }
                if (this.mYq != null && this.mYq.mRo != null && this.mYq.mRo.count > 0) {
                    this.mSt.setVisibility(8);
                } else {
                    this.mSt.setVisibility(0);
                }
                this.mSF = true;
                this.mSB.setBackgroundResource(a.e.ic_trumpet_p);
                this.mSD.setVisibility(0);
                this.mSD.setSelected(true);
                this.mSD.setTextColor(Color.parseColor("#ff5959"));
                if (this.mSr != null) {
                    this.mSr.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mSE <= 9) {
                this.mSE++;
                this.mSA.setText(this.mSE + "");
            }
            dDv();
        } else if (id == a.f.tv_cut_count) {
            if (this.mSE > 1) {
                this.mSE--;
                this.mSA.setText(this.mSE + "");
            }
            dDv();
        } else if (id == a.f.tv_buy_head) {
            dDw();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mTr.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mTr.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mTr);
                this.mYW.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mSr != null && this.mSi != null && this.mSq != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mSr);
                this.mSi.setVisibility(8);
                if (this.mRS == 2) {
                    this.mSq.setVisibility(0);
                }
            }
        } else if (this.mSi != null && this.mSq != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
            if (this.mRS == 2) {
                this.mSi.setVisibility(0);
            }
            this.mSq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dBV().c(roomToast.mToastContent);
            if (this.mTb == null) {
                dDe();
            }
            if (this.mTc != null) {
                this.mTc.setText(roomToast.mToastContent);
            }
            if (!this.mTb.isShowing()) {
                if (this.mSO != null) {
                    this.mTb.showAtLocation(this.mSO, 85, 0, this.mYb.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
                    RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mTb != null) {
                                a.this.mTb.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mTb.dismiss();
        }
    }

    private void dDe() {
        if (this.mTb == null) {
            View inflate = LayoutInflater.from(this.mYr).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mTc = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mTb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 160.0f), -2);
            this.mTb.setFocusable(false);
            this.mTb.setOutsideTouchable(false);
            this.mTb.setAnimationStyle(a.j.gift_toast_style);
            this.mTb.update();
        }
    }

    private void k(View view, int i, int i2) {
        if (this.mYQ != null && this.mYQ.isShowing()) {
            this.mYQ.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
        if (this.mZn == null) {
            dDT();
        }
        if (!this.mZn.isShowing()) {
            this.mZn.showAtLocation(view, 83, i, i2);
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mYq.dCF().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mZn.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDf() {
        if (this.mZq != null) {
            if (h.isEmpty(this.mZr)) {
                if (((VideoPlayer) this.mYr).q) {
                    this.mZq.bU(this.mYq != null ? this.mYq.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mZq.bU(this.mYq != null ? this.mYq.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mYr).q && this.mZr.size() == 2 && this.mZr.contains("4") && this.mZr.contains("2")) {
                this.mZq.bU(this.mYq != null ? this.mYq.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mZr.size() > 1 || !((VideoPlayer) this.mYr).q) {
                this.mZq.bU(this.mYq != null ? this.mYq.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mZr.get(0))) {
                this.mZq.bU(this.mYq != null ? this.mYq.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mZr.get(0))) {
                this.mZq.bU(this.mYq != null ? this.mYq.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mZr.get(0))) {
                this.mZq.bU(this.mYq != null ? this.mYq.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
        if (this.mYQ == null) {
            al();
            this.mYQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mYQ.isShowing() && this.mRS == 2) {
            this.mYQ.showAtLocation(view, 83, i, this.mYr.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYq.dCF().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYQ.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mYk != null) {
            this.mYk.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                g.c(this.mYr, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mUF.getPlayState() == 4) {
                        e(true);
                        if (this.mYq.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mYq.a(false);
                        ((VideoPlayer) this.mYr).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mUF.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mUF.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                g.c(this.mYr, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mYq.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mYr).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
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
        if (this.mZe != null) {
            if (z) {
                this.mZe.setVisibility(0);
            }
            this.mZe.dPF();
            if (!z) {
                this.mZe.setVisibility(8);
            }
        }
        g.c(this.mYr, this.mYr.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mSd != null) {
                this.mSd.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mYl != null) {
                this.mYl.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mSd != null) {
            this.mSd.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mYl != null) {
                    this.mYl.setVisibility(8);
                }
            }
        }
    }

    private void dDg() {
        this.e = false;
        k(true, false, true);
    }

    private void dDh() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mRO[i];
        if (this.mRS != i2 || this.Sw != i) {
            this.Sw = i;
            this.mRS = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dCU();
            a(this.mYq != null ? this.mYq.mRp.get("1") : null);
            if (i2 == 2) {
                k();
                av(true, i3);
                u(true);
                b(true);
                dDk();
                com.kascend.chushou.toolkit.a.c.a(this.mYr, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            av(false, i3);
            u(false);
            b(false);
            if (this.mYQ != null && this.mYQ.isShowing()) {
                this.mYQ.dismiss();
            }
            if (i2 == 99) {
                if (this.mRP != null && this.mRP[i] != null && (this.mRP[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mRP[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mYr, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mYr, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mYr, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mYr, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.Sw = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.mRS == 2) {
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
        ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mYs != null) {
            if (this.mSq != null && this.mSq.getVisibility() == 0) {
                t(false);
            }
            if (this.mYl != null && this.mYl.getVisibility() == 0) {
                this.f = true;
            }
            au(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mRR != null) {
            this.mRR.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mRR != null) {
            this.mRR.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mRR != null) {
            this.mRR.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mRR != null) {
            this.mRR.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mSO != null) {
            int size = iconConfig.configs.size();
            this.mSO.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mYr).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mSO, false);
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
                this.mSO.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mYq != null ? this.mYq.mRp : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mRR != null) {
            this.mRR.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dDf();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mSL != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mSL.xo(a.c.kas_white);
            } else if (this.mRS == 2) {
                this.mSL.bU(str, a.c.kas_white);
                if (this.mSM != null) {
                    this.mSM.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mSL.xo(a.c.kas_white);
                if (this.mSM != null) {
                    this.mSM.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mSM != null) {
                    this.mSM.setTextColor(a);
                    this.mSM.setTabTextSelectColor(a2);
                    this.mSM.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mSl != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mSl.xo(a.e.ic_hotwords_black_n);
            } else {
                this.mSl.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mSj != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dEf().a(str, this.mSj, a.e.player_skin_input);
            } else {
                this.mSj.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mSo != null) {
                this.mSo.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mRR != null) {
            this.mRR.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYr instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCl = ((VideoPlayer) this.mYr).dCl();
            if (this.mZh == null) {
                this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mZh.setVisibility(0);
            this.mZh.a(2, dCl);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mRR != null) {
            this.mRR.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mRR != null) {
            this.mRR.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mRR != null) {
            this.mRR.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mRR != null) {
            this.mRR.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mRR != null && this.mYq != null) {
            this.mRR.b(this.mYq.mRm);
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
            if (i < 0 || i >= a.this.mRO.length) {
                return null;
            }
            switch (a.this.mRO[i]) {
                case 1:
                    if (a.this.mRQ == null) {
                        a.this.mRQ = com.kascend.chushou.view.user.a.a(2, null, a.this.mYq.a, false, a.this.mYq.h, false);
                    }
                    a.this.mRP[i] = a.this.mRQ;
                    return a.this.mRQ;
                case 2:
                    if (a.this.mRR == null) {
                        a aVar = a.this;
                        if (a.this.mRE != null && a.this.mRE.mUG != null) {
                            z = a.this.mRE.mUG.mInPKMode;
                        }
                        aVar.mRR = com.kascend.chushou.player.ui.a.wp(z);
                    }
                    a.this.mRP[i] = a.this.mRR;
                    return a.this.mRR;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mYq != null && a.this.mYq.dCF() != null && !h.isEmpty(a.this.mSV)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mSV.get(i).url);
                        h5Options.a = a.this.mSV.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mRP[i] = a;
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
            return a.this.mRO.length;
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
            int dimensionPixelSize = a.this.mYr.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
        } else if (System.currentTimeMillis() - this.mRN <= 3000) {
            g.Om(a.i.str_too_fast);
            return false;
        } else {
            dDm();
            if (!com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYr).dCg().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mRN = System.currentTimeMillis();
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                a(this.mYq.dCF().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYq.h);
            }
            g(this.b);
            if (!z && this.mSr != null) {
                this.mSr.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dDm();
            if (com.kascend.chushou.d.e.c(this.mYr, null) && LoginManager.Instance().getUserInfo() != null && this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                a(this.mYq.dCF().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mSr != null) {
                this.mSr.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mRR != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mYq.dCF().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mYq.dCF().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mYr).mPA;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.ST(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mRR.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mRR.a(arrayList, true, true);
        }
    }

    private void dDi() {
        if (this.mRR != null) {
            this.mRR.e();
        }
        if (this.mST != null && this.mST.isShown()) {
            this.mST.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ox() {
        super.ox();
        if (this.mYr instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mYq != null) {
            this.mYq.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dDi();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mSR);
        if (this.mYr != null) {
            if (this.mSR || "10004".equals(((VideoPlayer) this.mYr).t)) {
                this.mSR = true;
                if (this.mYq != null) {
                    this.mYq.f = null;
                    if (this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                        this.mYq.dCF().mRoominfo.mGameId = null;
                    }
                }
                dCX();
                return;
            }
            this.mSR = true;
            if (this.mYr != null) {
                ((VideoPlayer) this.mYr).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mSR = false;
        if (this.mSb != null) {
            this.mSb.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mSR = false;
        if (this.mSb != null) {
            this.mSb.setVisibility(8);
        }
        super.i(z);
    }

    private void dDj() {
        dCV();
        if (i()) {
            dDl();
            dDR();
            return;
        }
        dCX();
    }

    private void dDk() {
    }

    private void dDl() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dDQ().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mZe != null) {
            this.mZe.setVisibility(0);
        }
        if (this.mRB != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mRB.d();
        }
        if (this.mSi != null) {
            this.mSi.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mRY.setVisibility(0);
            this.mRY.setOnClickListener(this);
        } else {
            this.mRY.setVisibility(8);
        }
        this.mSd.setVisibility(0);
        this.mRZ.setVisibility(0);
        this.mYi.setVisibility(0);
        if (this.p) {
            this.mYj.setVisibility(0);
        } else {
            this.mYj.setVisibility(8);
        }
        dDk();
        av(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mZh != null && this.mZh.a(i, keyEvent)) {
                return true;
            }
            if (this.mSY != null && this.mSY.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mSZ != null && this.mSZ.onKeyDown(i, keyEvent)) || dDn()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mTs != null && this.mTs.getVisibility() == 0 && b(motionEvent, this.mTs)) {
                this.mTs.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mTr);
                return true;
            } else if (this.mSQ && this.mTs != null && this.mTs.getVisibility() == 8 && g(this.mYW.b, motionEvent)) {
                dDd();
                return true;
            } else if (this.mSY != null && this.mSY.b() && g(this.mSY, motionEvent)) {
                this.mSY.a();
                return true;
            } else if (this.mSZ != null && this.mSZ.b() && g(this.mSZ, motionEvent)) {
                this.mSZ.a();
                return true;
            } else if (b(motionEvent, this.mSq)) {
                return dDm();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dDm() {
        boolean z;
        b(this.mTa, 10);
        boolean z2 = false;
        if (this.mSG != null && this.mSG.getVisibility() == 0) {
            this.mSG.setVisibility(8);
            this.mSH.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSI) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
            this.mSH.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSq == null || this.mSq.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mSF) {
                dDx();
            }
            this.mSq.setVisibility(8);
            z = true;
        }
        if (this.mRS == 2) {
            RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mSi != null && a.this.mRS == 2) {
                        a.this.mSi.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dDn() {
        if (dDm()) {
            return true;
        }
        if (this.mYQ == null || !this.mYQ.isShowing()) {
            return dDd() || dDb() || cXT();
        }
        this.mYQ.dismiss();
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
    public void dDo() {
        this.mSi.setVisibility(8);
        this.mSq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z, boolean z2) {
        if (this.mSi != null) {
            if (z) {
                if (this.mSi.getVisibility() != 0) {
                    this.mSi.setVisibility(0);
                    this.mSi.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_bottom_anim));
                }
            } else if (this.mSi.getVisibility() != 4) {
                this.mSi.setVisibility(4);
                this.mSi.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mSb != null) {
            this.mSb.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDp() {
        return this.mTe;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dDP()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mYq != null) {
                        this.mYq.f = null;
                        this.mYq.dCF().mRoominfo.mGameId = null;
                    }
                    dCX();
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
        if (this.mYq != null && this.mYq.dCG() != null) {
            a(this.mYq.dCG());
        }
        this.p = false;
        if (this.mYq == null || this.mYq.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mYq.f.size()) {
                if (!"2".equals(this.mYq.f.get(i2).mType)) {
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
        if (this.mRR != null) {
            this.mRR.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dDP()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mSe != null && this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                this.mSe.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mYq.dCF().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dDP() && !this.mSW && (c = c(1, -1)) >= 0 && c < this.mSV.size() && this.mSN != null) {
            this.mSN.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dDP() && !this.mSW) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mYr, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCm = ((VideoPlayer) this.mYr).dCm();
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(2, dCm);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCn = ((VideoPlayer) this.mYr).dCn();
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(2, dCn);
            } else if (bVar.a == 9) {
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mSG != null) {
            this.mSG.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dDP() && !this.mSW) {
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
        if (!dDP() && this.mYq != null) {
            String str = this.mYq.a;
            RoomInfo dCH = this.mYq.dCH();
            if (dCH != null && mVar.a(dCH.mCreatorUID, str)) {
                dCH.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.mRS == 2) {
            RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dDP()) {
                        a.this.t(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mSr != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mSr);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDq() {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
            if (this.mSS == null) {
                this.mSS = new f(getActivity());
            }
            this.mSS.a(this.mYq.dCF().mRoominfo);
            if (!this.mSS.isShowing()) {
                this.mSS.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mRR != null) {
            this.mRR.d();
        }
    }

    private void dB(View view) {
        this.mSf = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mSg = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mSg.setText(new tv.chushou.zues.widget.a.c().O(this.mYr, a.e.videoplayer_4g_video).append("  ").append(this.mYr.getString(a.i.videoplayer_4g_video)));
        this.mSh = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mSh.setText(new tv.chushou.zues.widget.a.c().O(this.mYr, a.e.videoplayer_4g_audio).append("  ").append(this.mYr.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mSf.setVisibility(8);
                    ((VideoPlayer) a.this.mYr).b(a.this.bR);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mSf.setVisibility(8);
                    ((VideoPlayer) a.this.mYr).c(a.this.bR);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dBO().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mSg.setOnClickListener(onClickListener);
        this.mSh.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mYq != null && !h.isEmpty(this.mYq.f)) {
            f(this.mYq.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.bR = z;
            this.p = false;
            if (this.mYq != null && this.mYq.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mYq.f.size()) {
                        break;
                    } else if (!"2".equals(this.mYq.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mSf != null) {
                this.mSf.setVisibility(0);
                this.mSg.setVisibility(0);
                this.mSh.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mSf != null) {
            this.mSf.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mTi == null) {
                this.mTi = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dDP()) {
                            a.this.dDr();
                        }
                    }
                };
                if (this.mYs != null) {
                    this.mYs.d(this.mTi, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mTi != null && this.mYs != null) {
            this.mYs.removeCallbacks(this.mTi);
            this.mTi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDr() {
        if (LoginManager.Instance().islogined() && this.mRR != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mYr, "显示双击666_num", null, new Object[0]);
            if (this.mYq != null) {
                this.mYq.b(false);
            }
            d(false);
            this.mRR.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mYb != null) {
            if (this.mSZ == null) {
                this.mSZ = (InteractionView) ((ViewStub) this.mYb.findViewById(a.f.view_interaction)).inflate();
                this.mSZ.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mSZ.a();
                    }
                });
            }
            if (this.mSZ != null) {
                this.mSZ.b(configDetail);
                this.mSZ.c();
                this.mSZ.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQq()) {
                g.M(this.mYr, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mYr, null) && (this.mYr instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYq != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYr, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYq != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYr, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mYr, configDetail.mUrl, this.mYr.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mYr, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    dDs();
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

    private void dDs() {
        if (this.mSQ) {
            dDd();
            return;
        }
        if (this.mYr.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYq.dCF().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mYr != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mRE == null) {
                this.mRE = new com.kascend.chushou.player.e.a();
            }
            this.mRE.b = str;
            this.mRE.mUG.copy(pkNotifyInfo);
            if (this.mRE.mUG.mAction == 6) {
                this.mRE.mUG.mInPKMode = true;
                this.u = this.mRE.mUG.mPkId;
            } else if (this.mRE.mUG.mAction == 7 || (this.mRE.mUG.mMode == 1 && this.mRE.mUG.mAction == 5)) {
                this.mRE.mUG.mInPKMode = true;
                this.u = this.mRE.mUG.mPkId;
                if (dDu() != null) {
                    if (2 == this.mRS && this.mTm != null) {
                        this.mTm.setVisibility(0);
                    }
                    dDu().b(this.mRE.mUG, false);
                    dDu().a(this.mRE.mUG.mMode, "1");
                    if (this.mRE.mUG.mAction == 5 && this.mRE.mUG.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mRE.mUG.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mRE.mUG.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mRE.mUG.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mRE.mUG.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mRE.mUG.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dDu().a(this.mRE.mUG);
                        if (this.mRE.mUG.destinyInfo == null || this.mRE.mUG.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dDu().a(parseInt, this.mRE.mUG.mPkUpdateInfo.remainDuration, j, this.mRE.mUG.mMode, i);
                    }
                    if (!h.isEmpty(this.mRE.mUG.mPkUpdateInfo.specialMomentList) && dDu() != null) {
                        dDu().a(this.mRE.mUG, true);
                    }
                }
                dDt();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.QW(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mRE.mUG.mInPKMode = false;
                dDt();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.QW(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dDt() {
        if (this.mRE != null && this.mRE.mUG != null) {
            if (this.mRE.mUG.mInPKMode) {
                this.y.setText(this.mRE.mUG.mPkUserNickname);
                this.mRG.setVisibility(0);
                if (this.mYh != null) {
                    this.mYh.setEnabled(false);
                }
                if (this.mYj != null) {
                    this.mYj.setEnabled(false);
                    return;
                }
                return;
            }
            this.mRG.setVisibility(8);
            if (this.mYh != null) {
                this.mYh.setEnabled(true);
            }
            if (this.mYj != null) {
                this.mYj.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dDu() {
        if (this.mYr == null || this.mYb == null || this.mTm == null) {
            return null;
        }
        if (this.mRF == null) {
            if (this.mTl == null) {
                this.mTl = ((ViewStub) this.mYb.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mRF = new com.kascend.chushou.player.e.b();
            this.mRF.a(this.mTm, this.mTl, (View) null, this.mYr, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dPZ()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mYq != null) {
                        append.append(a.this.mYq.dCH().mRoomID);
                    }
                    if (a.this.mRE != null && a.this.mRE.mUG != null) {
                        append.append("&mode=").append(a.this.mRE.mUG.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mYr, append.toString());
                }
            });
        }
        return this.mRF;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mSD != null && this.mYq != null && this.mYq.mRo != null) {
            this.mSD.setText(tv.chushou.zues.utils.b.Ol(this.mYq.mRo.count));
            this.mSD.setVisibility(0);
            if (this.mYq.mRo.count < 1) {
                dDx();
            }
            if (this.mSu != null) {
                this.mSu.setText(this.mYq.mRo.primaryName);
            }
            if (this.mSv != null) {
                this.mSv.setText(this.mYq.mRo.desc);
            }
            dDv();
        }
    }

    public void dDv() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mSE * h.parseLong(this.mYq.mRo.point)));
        if (this.mSx != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mYr.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mYr, a.e.icon_coin_new);
            cVar.append(this.mYr.getString(a.i.str_buy_count_coin2));
            this.mSx.setText(cVar);
        }
    }

    private void dDw() {
        if (com.kascend.chushou.d.e.c(this.mYr, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mSE);
        }
    }

    private void u(boolean z) {
        if (this.mYb != null && this.mTm != null) {
            if (z) {
                if (this.mRE != null && this.mRE.mUG != null && this.mRE.mUG.mInPKMode) {
                    this.mTm.setVisibility(0);
                    return;
                }
                return;
            }
            this.mTm.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mYb != null && this.mRJ != null) {
            if (z) {
                if (this.E && 2 == this.mRS) {
                    this.mRJ.setVisibility(0);
                    return;
                }
                return;
            }
            this.mRJ.setVisibility(8);
        }
    }

    private void v(boolean z) {
        if (z) {
            if (this.mRE != null && this.mRE.mUG != null && this.mRE.mUG.mInPKMode && this.mRG != null) {
                this.mRG.setVisibility(0);
            }
        } else if (this.mRG != null) {
            this.mRG.setVisibility(8);
        }
    }

    private void dDx() {
        this.mSF = false;
        this.mSB.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mYq != null && this.mYq.mRo != null) {
            if (this.mYq.mRo.count < 1) {
                this.mSD.setVisibility(8);
            } else {
                this.mSD.setVisibility(0);
                this.mSD.setSelected(false);
                this.mSD.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mSt.setVisibility(8);
        if (this.mSr != null) {
            this.mSr.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dDs();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mSo != null) {
            this.mSo.performClick();
        }
    }

    public boolean dDy() {
        return this.mRS == 2;
    }
}
