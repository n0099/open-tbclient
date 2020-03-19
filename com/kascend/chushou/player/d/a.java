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
    private int[] mTD;
    private Fragment[] mTE;
    private ImageView mTJ;
    private MarqueeTextView mTK;
    private MarqueeTextView mTL;
    private ImageView mTM;
    private ImageView mTN;
    private ImageButton mTO;
    public String mTP;
    private RecommendView mTQ;
    private TextView mTT;
    private RelativeLayout mTU;
    private TextView mTV;
    private TextView mTW;
    private boolean mTX;
    private RelativeLayout mTY;
    private View mTZ;
    private PagerSlidingTabStrip mUA;
    private KasViewPager mUB;
    private LinearLayout mUC;
    private f mUF;
    private ViewMicPerson mUG;
    public ArrayList<RoomTab> mUI;
    private PopH5Menu mUL;
    private InteractionView mUM;
    private int mUN;
    private PopupWindow mUO;
    private TextView mUP;
    private GiftAnimationLayout mUQ;
    private com.kascend.chushou.player.b.a mUR;
    private Runnable mUV;
    private View mUX;
    private LivePKBarUserValue mUY;
    private String mUZ;
    private FrescoThumbnailView mUa;
    private AnimationSet mUb;
    private ImageView mUc;
    private TextView mUd;
    private RelativeLayout mUe;
    private PastedEditText mUf;
    private TextView mUg;
    private LinearLayout mUh;
    private TextView mUi;
    private TextView mUj;
    private TextView mUl;
    private TextView mUm;
    private TextView mUn;
    private TextView mUo;
    private TextView mUp;
    private ImageView mUq;
    private TextView mUr;
    private KPSwitchPanelLinearLayout mUu;
    private ImageView mUv;
    private c mUx;
    private d.a mUy;
    private FrescoThumbnailView mUz;
    private TextView mVa;
    private ImageView mVb;
    private EditText mVc;
    private View mVd;
    private View mVe;
    private View mVf;
    private String mVi;
    private long mTC = 0;
    private com.kascend.chushou.view.user.a mTF = null;
    private com.kascend.chushou.player.ui.a mTG = null;
    private int Su = -1;
    private int mTH = 0;
    private View mTI = null;
    private View mTR = null;
    private ImageButton mTS = null;
    private int mUs = 1;
    private boolean mUt = false;
    private boolean mUw = false;
    private boolean mUD = false;
    private boolean mUE = false;
    private boolean mUH = false;
    private boolean mUJ = false;
    private boolean mUK = true;
    private int mUS = 0;
    private int mUT = 0;
    private int mUU = -1;
    private final Rect mUW = new Rect();
    private boolean mVg = false;
    private C0697a mVh = null;
    private boolean da = false;
    private boolean mVj = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTP = getArguments().getString("mCover");
        this.mUK = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mZL = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mZL;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dEp()) {
            c(view);
            dDm();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.mUJ = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.naH != null) {
            this.naH.b();
        }
        if (this.nab != null && (this.nab instanceof VideoPlayer)) {
            ((VideoPlayer) this.nab).wo(true);
            ((VideoPlayer) this.nab).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mUJ = true;
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
        this.mUs = 1;
        this.mUt = false;
        U();
        if (this.nac != null) {
            this.nac.cq(null);
            this.nac = null;
        }
        if (this.mTQ != null) {
            dEq().removeAllViews();
            this.mTQ = null;
        }
        this.c = null;
        this.mTk = null;
        tv.chushou.zues.a.a.cr(this);
        this.mUA = null;
        this.mUB = null;
        this.mTG = null;
        this.mTF = null;
        if (this.mTE != null) {
            for (int i = 0; i < this.mTE.length; i++) {
                this.mTE[i] = null;
            }
        }
        this.mTE = null;
        if (this.mUf != null) {
            this.mUf.addTextChangedListener(null);
            this.mUf.setOnTouchListener(null);
            this.mUf.setOnEditorActionListener(null);
            this.mUf = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nab, this.mUx);
        if (this.nab != null && (this.nab instanceof VideoPlayer)) {
            ((VideoPlayer) this.nab).dCH();
        }
        this.mUy = null;
        this.mUx = null;
        if (this.mUG != null) {
            this.mUG.b();
            this.mUG = null;
        }
        if (this.mUO != null) {
            this.mUO.dismiss();
        }
        if (this.mUR != null) {
            this.mUR.a();
            this.mUR = null;
            this.mUQ = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mUY = (LivePKBarUserValue) this.mZL.findViewById(a.f.live_pk_bar_user);
        this.mZU = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mVg) {
            this.mVg = true;
            if (this.mVe == null) {
                this.mVe = this.mZL.findViewById(a.f.vs_async_view);
                this.mVe = ((ViewStub) this.mVe).inflate();
            }
            if (this.mVf == null) {
                this.mVf = this.mZL.findViewById(a.f.vs_async_notification_view);
                this.mVf = ((ViewStub) this.mVf).inflate();
            }
            this.mTw = (VoiceInteractionView) this.mZL.findViewById(a.f.voiceInteractiveView);
            t();
            dA(this.mZL);
            cYk();
            ((VideoPlayer) this.nab).q();
            this.mTr = new com.kascend.chushou.player.e.a();
        }
    }

    private void dA(View view) {
        this.mUz = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mUA = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mUB = (KasViewPager) view.findViewById(a.f.vp_main);
        dDn();
        dDo();
        dDt();
        if (this.naa != null) {
            I();
            a(this.naa.mSV, this.naa.mSZ);
        }
        this.aSM = 0;
        this.naM = 0L;
        this.naI = (RoundProgressBar) this.mZL.findViewById(a.f.roundProgressBar);
        this.naJ = (TextView) this.mZL.findViewById(a.f.tv_paonum);
        this.naK = (FrescoThumbnailView) this.mZL.findViewById(a.f.iv_paoicon);
        this.naR = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.mUD = false;
                if (a.this.Su == 2) {
                    a.this.av(true, a.this.i());
                } else {
                    a.this.dDN();
                }
                a.this.b(a.this.mUN, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.mUD = true;
                if (a.this.Su == 2) {
                    a.this.av(false, a.this.i());
                } else {
                    a.this.dDN();
                }
                if (a.this.naH != null) {
                    a.this.naH.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hc(a.this.nab).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nab)) - a.this.naH.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nab, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nab, 54.0f) * 2);
                    if (statusBarHeight < a.this.mUN) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.naL = (PaoGuideView) this.mZL.findViewById(a.f.rlPaoGuideView);
        this.mUG = (ViewMicPerson) this.mZL.findViewById(a.f.rl_mic_person_view);
    }

    private void dDm() {
        this.mWp = ((VideoPlayer) this.nab).dCA();
        this.naa = ((VideoPlayer) this.nab).dCD();
        dB(this.mZL);
        this.mUS = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
        this.mUT = tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        if (com.kascend.chushou.b.dCl().d == 0 && this.mUT > 0) {
            View findViewById = this.mZL.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mUT);
        }
        dDy();
        dDw();
        if (!this.mUK) {
            Q();
        }
        dDu();
        a();
        if (this.c == null) {
            this.mTk = new d.a();
            this.c = new GestureDetector(this.nab, this.mTk);
        }
        this.mTm = ((VideoPlayer) this.nab).dCE();
        this.mTm.a(this);
        if (this.mUR != null) {
            this.mUR.a();
            this.mUR = null;
        }
        this.mUQ = (GiftAnimationLayout) this.mZL.findViewById(a.f.ll_gift_animation);
        this.mUQ.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.naa != null) {
            this.mUR = new com.kascend.chushou.player.b.a(this.nab.getApplicationContext(), this.mUQ);
            this.mUR.a(this.naa);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mZL.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mZV = (PlayerErrorView) this.mZL.findViewById(a.f.view_net_error_msg);
        this.mZV.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dDr();
        dDE();
        if (this.naa.dDe() != null) {
            a(this.naa.dDe());
        }
        FullRoomInfo dDd = this.naa.dDd();
        if (dDd != null) {
            dDI();
            if (i()) {
                this.ak = false;
                ww(true);
                this.nac.Ol(8);
            }
            this.mTT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dDd.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mTI.setVisibility(0);
        this.ak = false;
        ww(true);
        this.nac.Ol(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nab).n();
        if (this.naa != null && !h.isEmpty(this.naa.mSX)) {
            b(this.naa.mSX);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dCO;
        dDn();
        k();
        FullRoomInfo dDd = this.naa.dDd();
        if (dDd != null) {
            if (dDd.mRoominfo != null) {
                this.mTT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dDd.mRoominfo.mOnlineCount)));
                this.mUZ = dDd.mRoominfo.mRoomID;
            }
            dDI();
            if (!h.isEmpty(dDd.mRoomToastList)) {
                Iterator<RoomToast> it = dDd.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dCs().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.naa != null && this.naa.l()) {
                d(true);
            }
            if (this.nab != null && (this.nab instanceof VideoPlayer) && (dCO = ((VideoPlayer) this.nab).dCO()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dCO.mWq, dCO.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mUC);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dDn() {
        boolean z = true;
        if (this.naa == null || this.naa.dDd() == null || this.naa.dDd().mRoominfo == null || h.isEmpty(this.naa.dDd().mRoomTabs)) {
            this.mUH = false;
            this.mTE = new Fragment[2];
            this.mTD = new int[2];
            this.mTD[0] = 2;
            this.mTD[1] = 1;
            return;
        }
        this.mUH = true;
        this.mUI = new ArrayList<>();
        Iterator<RoomTab> it = this.naa.dDd().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mUI.add(next);
            }
        }
        if (this.mUI.size() >= 2 && this.mTD != null && this.mTD.length >= 2 && this.mUI.get(0).type == this.mTD[0] && this.mUI.get(1).type == this.mTD[1]) {
            z = false;
        }
        this.mTE = new Fragment[this.mUI.size()];
        this.mTD = new int[this.mUI.size()];
        for (int i = 0; i < this.mUI.size(); i++) {
            this.mTD[i] = this.mUI.get(i).type;
        }
        if (z) {
            this.mVh = new C0697a(getChildFragmentManager());
            this.mUB.setAdapter(this.mVh);
        }
    }

    private void dDo() {
        this.mUe = (RelativeLayout) this.mZL.findViewById(a.f.rl_edit_bar);
        this.mUa = (FrescoThumbnailView) this.mZL.findViewById(a.f.btn_hotword);
        this.mUa.xw(a.e.ic_hotwords_black_n);
        this.mUa.setOnClickListener(this);
        this.mUc = (ImageView) this.mZL.findViewById(a.f.iv_task_badge);
        this.mUb = (AnimationSet) AnimationUtils.loadAnimation(this.nab, a.C0691a.anim_hotword);
        this.mUb.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dCs().c) {
                    a.this.mUa.clearAnimation();
                    a.this.mUa.startAnimation(a.this.mUb);
                }
            }
        });
        if (com.kascend.chushou.d.h.dCs().c) {
            this.mUa.startAnimation(this.mUb);
            this.mUc.setVisibility(0);
        }
        this.mUd = (TextView) this.mZL.findViewById(a.f.tv_bottom_input);
        this.mUd.setOnClickListener(this);
        this.nbb = (FrescoThumbnailView) this.mZL.findViewById(a.f.ll_btn_set);
        this.nbb.setOnClickListener(this);
        this.mUC = (LinearLayout) this.mZL.findViewById(a.f.ll_bottom_all_button);
        this.mTY = (RelativeLayout) this.mZL.findViewById(a.f.rl_bottom_input);
        this.mTZ = this.mZL.findViewById(a.f.ll_bottom_input);
        this.mTY.setVisibility(8);
        this.mUf = (PastedEditText) this.mZL.findViewById(a.f.et_bottom_input);
        this.mUf.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mUg.setEnabled(editable.length() > 0);
            }
        });
        this.mUf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mUg);
                    return true;
                }
                return true;
            }
        });
        this.mUf.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.mUf);
                }
                return false;
            }
        });
        this.mUv = (ImageView) this.mZL.findViewById(a.f.iv_btn_emoji);
        this.mUv.setVisibility(8);
        this.mUg = (TextView) this.mZL.findViewById(a.f.tv_btn_send);
        this.mUg.setOnClickListener(this);
        this.mUu = (KPSwitchPanelLinearLayout) this.mZL.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dCl().d == 0) {
            this.mUu.setUseStatusBar(true);
        }
        this.mUh = (LinearLayout) this.mZL.findViewById(a.f.head_trumpet);
        this.mUh.setVisibility(8);
        this.mUh.setOnClickListener(this);
        this.mUi = (TextView) this.mZL.findViewById(a.f.tv_primary_name);
        this.mUj = (TextView) this.mZL.findViewById(a.f.tv_primary_desc);
        this.mUn = (TextView) this.mZL.findViewById(a.f.tv_cut_count);
        this.mUn.setOnClickListener(this);
        this.mUp = (TextView) this.mZL.findViewById(a.f.tv_head_count);
        this.mUp.setText(this.mUs + "");
        this.mUo = (TextView) this.mZL.findViewById(a.f.tv_plus_count);
        this.mUo.setOnClickListener(this);
        this.mUm = (TextView) this.mZL.findViewById(a.f.tv_buy_count_coin);
        this.mUl = (TextView) this.mZL.findViewById(a.f.tv_buy_head);
        this.mUl.setOnClickListener(this);
        this.mUq = (ImageView) this.mZL.findViewById(a.f.iv_trumpet_select);
        this.mUq.setOnClickListener(this);
        this.mUr = (TextView) this.mZL.findViewById(a.f.tv_trumpet_have_count);
        this.mUt = false;
        this.mUq.setBackgroundResource(a.e.ic_trumpet_n);
        this.mUr.setVisibility(8);
        dDq();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mUu, this.mUv, this.mUf, new a.InterfaceC0818a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0818a
            public void wq(boolean z) {
                if (a.this.mUv != null) {
                    if (!z) {
                        a.this.mUv.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dCl().d == 0) {
                        a.this.mUu.setDirectVisibility(0);
                    }
                    a.this.mUv.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mUy = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wr(boolean z) {
                if (a.this.mVj) {
                    a.this.mVj = false;
                    return;
                }
                a.this.mUw = z;
                if (z) {
                    a.this.mUv.setImageResource(a.e.cs_emoji_normal);
                    a.this.dDp();
                    return;
                }
                if (a.this.mVd != null && a.this.mVd.getVisibility() == 0) {
                    a.this.mVd.setVisibility(8);
                }
                if (a.this.mUD) {
                    a.this.naH.setVisibility(0);
                }
                if (a.this.nab != null && (a.this.nab instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nab).wo(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mUx = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mUu, this.mUy, ((VideoPlayer) this.nab).dCI());
        ((VideoPlayer) this.nab).h(((VideoPlayer) this.nab).dCI());
        this.mVd = this.mZL.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mVa = (TextView) this.mZL.findViewById(a.f.btn_room_search);
        this.mVb = (ImageView) this.mZL.findViewById(a.f.iv_room_emoji_delete);
        this.mVc = (EditText) this.mZL.findViewById(a.f.et_room_emoji_search);
        this.mVc.setImeOptions(3);
        this.mVc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mVa);
                    return true;
                }
                return false;
            }
        });
        this.mVc.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mVa.setEnabled(editable.length() > 0);
                a.this.mVb.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.naH.setEmojiSearchText(editable.toString());
            }
        });
        this.mVa.setOnClickListener(this);
        this.mVb.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mVc);
            this.mVd.setVisibility(0);
            this.mVc.requestFocus();
        } else {
            this.mVd.setVisibility(8);
        }
        if (z2) {
            this.mVc.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDp() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hc(this.nab).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab)) - tv.chushou.zues.widget.kpswitch.b.d.hn(this.nab)) - tv.chushou.zues.utils.a.dip2px(this.nab, 14.0f)) - this.nab.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nab, 54.0f) * 2);
        if (statusBarHeight < this.mUN) {
            b(statusBarHeight, 10);
        }
    }

    private void dDq() {
    }

    private void dDr() {
        this.nac = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.au(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mZL.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nab.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nac.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nac.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nac.K(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nac);
                            break;
                        case 12:
                            a.this.b(a.this.nac);
                            break;
                        case 17:
                            a.this.dEs();
                            break;
                        case 18:
                            a.this.cYj();
                            break;
                        case 19:
                            a.this.mZZ.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dDs() {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.mUI)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mUI.size()) {
                    if (!h.isEmpty(this.mUI.get(i2).notifyIcon)) {
                        this.mUA.bl(i2, this.mUI.get(i2).notifyIcon);
                        this.mUA.OI(i2);
                    } else if (this.mUI.get(i2).notify == 1) {
                        this.mUA.OH(i2);
                        this.mUA.OG(i2);
                    } else {
                        this.mUA.OG(i2);
                        this.mUA.OI(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.mUI)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mUI.size()) {
                    if (this.mUI.get(i4).type == i) {
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
    public String MQ(int i) {
        if (this.naa == null || this.naa.dDd() == null || this.naa.dDd().mRoominfo == null || h.isEmpty(this.mUI)) {
            if (i == 1) {
                return this.nab.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nab.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mUI.size()) {
            return this.mUI.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.mUI) && i < this.mUI.size()) {
            this.mUI.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.mUI) && i < this.mUI.size()) {
            this.mUI.get(i).notifyIcon = str;
        }
    }

    private void dDt() {
        if (this.mUB != null && this.mUA != null && this.mTD != null) {
            this.mTG = null;
            if (this.mTE != null) {
                for (int i = 0; i < this.mTE.length; i++) {
                    this.mTE[i] = null;
                }
            }
            if (this.mVh == null) {
                this.mVh = new C0697a(getChildFragmentManager());
                this.mUB.setAdapter(this.mVh);
            } else {
                this.mVh.notifyDataSetChanged();
            }
            this.mUB.setOffscreenPageLimit(this.mTD.length);
            this.mUA.c(this.mUB);
            this.mUA.setOnPageChangeListener(this);
            this.mUA.notifyDataSetChanged();
            this.mUA.setVisibility(0);
            this.mUB.setVisibility(0);
            if (!this.mUH) {
                this.Su = 2;
                this.mUB.setCurrentItem(c(2, 0));
                this.mTY.setVisibility(0);
            } else {
                if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                    if (!h.isEmpty(this.naa.dDd().mRoominfo.mGameName)) {
                        this.mTL.setText(this.naa.dDd().mRoominfo.mGameName);
                    } else {
                        this.mTL.setText(this.nab.getString(a.i.no_online_game_name));
                    }
                    this.mTK.setText(this.naa.dDd().mRoominfo.mName);
                } else {
                    this.mTL.setText(this.nab.getString(a.i.no_online_game_name));
                }
                dDs();
                if (i()) {
                    dDF();
                    if (this.mUB != null) {
                        this.Su = 2;
                        int c = c(2, 0);
                        this.mUB.setCurrentItem(c);
                        this.mUA.setSelectItem(c);
                    }
                } else if (this.mUB != null) {
                    this.Su = 1;
                    int c2 = c(1, 1);
                    this.mUB.setCurrentItem(c2);
                    this.mUA.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dDu() {
        this.N = new SurfaceView(this.nab);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.naf);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dEq().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dDv() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nab).s();
        cYq();
        dDz();
        dDA();
        dEq().setBackgroundResource(a.e.room_not_online);
        if (this.mTQ == null) {
            this.mTQ = new RecommendView(this.nab);
            dEq().addView(this.mTQ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nab);
            this.mTQ.setLayoutParams(layoutParams);
        }
        if (this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.naa.dDd().mRoominfo.mRoomID)) {
            this.mTQ.a(this.naa.dDd().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dEp() && a.this.nab != null && a.this.dEq() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nab);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lOK);
                        if (a.this.dEq().getChildCount() >= 2) {
                            a.this.dEq().addView(frescoThumbnailView, 0);
                        }
                        a.this.dEq().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dQL(), a.this.ar, a.this.naf);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.naP != null) {
            this.naP.dQf();
            this.naP.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.naH != null) {
            this.naH.e();
        }
        ww(false);
        a(false, false);
        if (this.mTm != null) {
            this.mTm.d();
        }
    }

    private void dDw() {
        int i = 0;
        this.mTI = this.mZL.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dCl().d == 0 && this.mUS > 0) {
            View findViewById = this.mZL.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.mUS;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mTJ = (ImageView) this.mTI.findViewById(a.f.back_icon);
        this.mTJ.setOnClickListener(this);
        this.mTK = (MarqueeTextView) this.mTI.findViewById(a.f.tv_title);
        this.mTL = (MarqueeTextView) this.mTI.findViewById(a.f.tv_Type);
        this.mTN = (ImageView) this.mZL.findViewById(a.f.btn_setting);
        this.mTR = this.mZL.findViewById(a.f.bottomview);
        if (this.mZS == null) {
            this.mZS = (ImageButton) this.mTR.findViewById(a.f.btn_barrage);
            this.mZS.setOnClickListener(this);
            if (this.naa != null) {
                if (com.kascend.chushou.d.h.dCs().n()) {
                    this.mZS.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mZS.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mZT = (ImageButton) this.mTR.findViewById(a.f.btn_audio);
        this.mZT.setOnClickListener(this);
        if (this.naa != null && this.naa.d) {
            this.mZT.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mZT.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.naa != null && this.naa.f != null) {
            while (true) {
                if (i >= this.naa.f.size()) {
                    break;
                } else if (!"2".equals(this.naa.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mTS = (ImageButton) this.mTR.findViewById(a.f.playbutton);
        this.mTS.setOnTouchListener(this);
        this.mTO = (ImageButton) this.mTR.findViewById(a.f.btn_refresh);
        this.mTO.setOnClickListener(this);
        this.mTT = (TextView) this.mTR.findViewById(a.f.tv_online_count);
        if (this.mZR == null) {
            this.mZR = (ImageButton) this.mTR.findViewById(a.f.btn_screenChange);
            this.mZR.setOnClickListener(this);
        }
        if (this.mTM == null) {
            this.mTM = (ImageView) this.mTI.findViewById(a.f.report_icon);
            this.mTM.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dDP();
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
        if (!dEp() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mTG != null) {
                        this.mTG.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                        this.naa.dDd().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.naa.dDd().mMicStatus.onMic) {
                            dDG();
                        }
                        if (this.naa.dDd().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.naa.dDd().mRoominfo.mCreatorUID)) {
                                i(arrayList2, this.naa.dDd().mRoominfo.mCreatorUID);
                            }
                        } else if (this.naa.dDd().mMicStatus.onMic) {
                            this.naa.dDd().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.naa.dDd().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = j(this.naa.dDd().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.naa.dDd().mMicStatus != null && !h.isEmpty(this.naa.dDd().mMicStatus.micRoomId) && !this.naa.dDd().mMicStatus.micRoomId.equals("0")) {
                                this.mVi = this.naa.dDd().mMicStatus.micRoomId;
                            }
                            if (this.mTG != null) {
                                this.mTG.a(this.naa.dDd().mMicStatus, this.naa.dDd().mFanItems, str, z2);
                            }
                            if (this.mUG != null && this.mUG.getVisibility() == 0) {
                                this.mUG.a(this.naa.dDd().mFanItems, this.naa.dDd().mMicStatus, str, z2, this.naa.dDd().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mTG != null) {
                                this.mTG.e();
                            }
                            if (this.mUG != null && this.mUG.isShown()) {
                                this.mUG.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mTG != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mTG.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mTG.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mUU != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mUU = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mTr != null && this.mTr.mWq != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mTr.mWq.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mTr.mWq.mInPKMode = true;
                                    this.mTr.mWq.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mTr.mWq.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mTr.mWq.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mTr.mWq.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mTr.mWq.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mTr.mWq.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mTr.mWq.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mTr.mWq.mMode = pkNotifyInfo.mMode;
                                    this.mTr.mWq.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dDT() != null) {
                                        dDT().g(true, this.mTr.mWq.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dCs().a) {
                                        if (!com.kascend.chushou.b.dCl().e) {
                                            com.kascend.chushou.b.dCl().e = true;
                                            g.M(this.nab, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dCs().a(this.nab, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.Su && this.mUY != null) {
                                        this.mUY.setVisibility(0);
                                    }
                                    this.mTr.mWq.mAction = 7;
                                    this.mTr.mWq.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mTr.mWq.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mTr.mWq.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mTr.mWq.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mTr.mWq.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mTr.mWq.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dDS();
                                    if (dDT() != null) {
                                        dDT().g(false, 0L);
                                        dDT().b(this.mTr.mWq, true);
                                        dDT().a(this.mTr.mWq.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.QW(this.mUZ);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mTr.mWq.mInPKMode = false;
                                    this.mTr.mWq.mAction = 2;
                                    dDS();
                                    if (dDT() != null) {
                                        dDT().c();
                                    }
                                    if (com.kascend.chushou.d.h.dCs().a) {
                                        if (!com.kascend.chushou.b.dCl().e) {
                                            com.kascend.chushou.b.dCl().e = true;
                                            g.M(this.nab, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dCs().a(this.nab, false);
                                        ak();
                                    }
                                    this.mTr.b = null;
                                    this.mTr.mWq = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.QW(this.mUZ);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mTr.mWq.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mTr.mWq.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mTr.mWq.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.naa.dDd().mRoominfo.mRoomID) && this.naa.dDd().mRoominfo.mRoomID.equals(this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dDT() != null) {
                                        dDT().a(this.mTr.mWq, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mTr.mWq.copyUpdate(pkNotifyInfo);
                                    if (dDT() != null) {
                                        dDT().a(this.mTr.mWq);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mTr.mWq.copyStop(pkNotifyInfo);
                                        if (dDT() != null) {
                                            dDT().w(this.mTr.mWq.mMaxFreeDuration, this.mTr.mWq.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mTr.mWq.copyResult(pkNotifyInfo);
                                    if (!this.mUJ && dDT() != null) {
                                        int i5 = 1;
                                        if (this.mTr.mWq.destinyInfo != null && this.mTr.mWq.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dDT().a(h.parseInt(this.mTr.mWq.mResult), h.parseLong(this.mTr.mWq.mvpUid), this.mTr.mWq.mvpAvatar, this.mTr.mWq.mvpNickname, this.mTr.mWq.mMaxFreeDuration, this.mTr.mWq.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mTG != null) {
                if (LoginManager.Instance().islogined() && this.naa != null && this.naa.l()) {
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
                if (this.naa == null || this.naa.dDd() == null || this.naa.dDd().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.naa.dDd().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dCs().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dCs().b().equals(next2.mUserID)) {
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
                this.mTG.a(arrayList, true, false);
                this.mTG.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mTD != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mTD.length) {
                    break;
                }
                if (this.mTD[i2] == 99 && this.mTE != null && this.mTE[i2] != null && (this.mTE[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mTE[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mUI.size() && this.mUA != null) {
                if (i == 0) {
                    this.mUA.setTagText(i2, new StringBuilder(this.mUI.get(i2).name).toString());
                    return;
                } else {
                    this.mUA.setTagText(i2, this.mUI.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mZS != null) {
            if (z) {
                this.mZS.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mZS.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dDx() {
        if (this.mZL == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mZL.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hc = tv.chushou.zues.utils.a.hc(this.nab);
        this.ar = Math.min(hc.x, hc.y);
        this.naf = (this.ar * this.nab.getResources().getInteger(a.g.h_thumb_height_def)) / this.nab.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dEq().getLayoutParams();
        layoutParams.height = this.naf;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mZU.getLayoutParams();
        layoutParams2.height = this.naf;
        layoutParams2.width = this.ar;
        this.mUN = this.naf + this.nab.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nab, 54.0f);
        b(this.mUN, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.naf);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dDy() {
        Point hc = tv.chushou.zues.utils.a.hc(this.nab);
        this.ar = Math.min(hc.x, hc.y);
        this.naf = (this.ar * this.nab.getResources().getInteger(a.g.h_thumb_height_def)) / this.nab.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dEq().getLayoutParams();
        layoutParams.height = this.naf;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mZU.getLayoutParams();
        layoutParams2.height = this.naf;
        layoutParams2.width = this.ar;
        this.mUN = this.naf + this.nab.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nab, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.mUN, 10);
        k();
        if (!h.isEmpty(this.mTP)) {
            File ad = tv.chushou.zues.widget.fresco.a.ad(Uri.parse(this.mTP));
            if (ad != null && ad.exists()) {
                this.mZU.setImageURI(Uri.fromFile(ad));
                this.mZU.setVisibility(0);
                return;
            }
            this.mZU.setVisibility(8);
            return;
        }
        this.mZU.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mTM != null) {
            this.mTM.setVisibility(z ? 0 : 4);
        }
        if (this.mTN != null) {
            this.mTN.setVisibility(z ? 0 : 4);
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
        if (this.nac != null) {
            this.nac.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nab).f(true);
            if (!z3) {
                if (this.mTR.getVisibility() != 0 && z2) {
                    this.mTR.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mZT.setVisibility(0);
                } else {
                    this.mZT.setVisibility(8);
                }
                this.mTR.setVisibility(0);
            }
            PlayUrl dDe = this.naa.dDe();
            if (dDe != null && "2".equals(dDe.mType)) {
                if (this.mZR != null) {
                    this.mZR.setVisibility(8);
                }
            } else if (this.mZR != null) {
                this.mZR.setVisibility(0);
            }
            if (this.mTI.getVisibility() != 0 && z2) {
                this.mTI.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_top_anim));
            }
            t(!z3);
            this.mTI.setVisibility(0);
            wp(true);
            if (this.nac != null) {
                this.nac.K(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nab).f(false);
            if (this.nat != null) {
                this.nat.dismiss();
            }
            if (this.nau != null) {
                this.nau.dismiss();
            }
            if (this.mTR.getVisibility() != 8 && z2) {
                this.mTR.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_bottom_anim));
            }
            this.mTR.setVisibility(8);
            if (this.mTI.getVisibility() != 8 && z2) {
                this.mTI.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_top_anim));
            }
            this.mTI.setVisibility(8);
            wp(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean cYq() {
        if (this.naL == null || !this.naL.isShown()) {
            return false;
        }
        this.naL.d();
        return true;
    }

    public boolean dDz() {
        if (this.mUG == null || !this.mUG.isShown()) {
            return false;
        }
        this.mUG.a();
        return true;
    }

    public boolean dDA() {
        if (this.mUL == null || !this.mUL.b()) {
            return false;
        }
        this.mUL.a();
        return true;
    }

    public boolean dDB() {
        if (this.mUD && this.naH != null) {
            if (this.naH != null) {
                this.naH.e();
            }
            if (this.mVc != null) {
                this.mVc.setText("");
            }
            if (this.Su == 2) {
                av(true, i());
                return true;
            }
            dDN();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mZL != null) {
            if (this.mUL == null) {
                this.mUL = (PopH5Menu) ((ViewStub) this.mZL.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mUL.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mUL.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            m(view, 0, this.mTI.getHeight() + this.mTI.getTop());
        } else if (id == a.f.btn_barrage) {
            n(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nab, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                g.c(this.nab, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.naa.a(false);
                a(false, false);
                ((VideoPlayer) this.nab).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.e(this.nab, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mTr == null || this.mTr.mWq == null || !this.mTr.mWq.mInPKMode) {
                ((VideoPlayer) this.nab).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nab, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mUt) {
                f(this.mUf.getText().toString());
            } else {
                a(this.mUf.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dCs().c) {
                com.kascend.chushou.d.h.dCs().b(false);
                this.mUb.cancel();
                this.mUb.reset();
                this.mUa.clearAnimation();
                this.mUc.setVisibility(8);
            }
            l(view, 0, this.mZL.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nab, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            k(view, x, this.mZL.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.naa.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nab, null) && this.naa != null && this.naa.mSY != null) {
                if (this.mUt) {
                    dDW();
                    return;
                }
                if (this.naa != null && this.naa.mSY != null && this.naa.mSY.count > 0) {
                    this.mUh.setVisibility(8);
                } else {
                    this.mUh.setVisibility(0);
                }
                this.mUt = true;
                this.mUq.setBackgroundResource(a.e.ic_trumpet_p);
                this.mUr.setVisibility(0);
                this.mUr.setSelected(true);
                this.mUr.setTextColor(Color.parseColor("#ff5959"));
                if (this.mUf != null) {
                    this.mUf.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mUs <= 9) {
                this.mUs++;
                this.mUp.setText(this.mUs + "");
            }
            dDU();
        } else if (id == a.f.tv_cut_count) {
            if (this.mUs > 1) {
                this.mUs--;
                this.mUp.setText(this.mUs + "");
            }
            dDU();
        } else if (id == a.f.tv_buy_head) {
            dDV();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mVc.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mVc.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mVc);
                this.naH.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mUf != null && this.mTY != null && this.mUe != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mUf);
                this.mTY.setVisibility(8);
                if (this.Su == 2) {
                    this.mUe.setVisibility(0);
                }
            }
        } else if (this.mTY != null && this.mUe != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
            if (this.Su == 2) {
                this.mTY.setVisibility(0);
            }
            this.mUe.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dCs().c(roomToast.mToastContent);
            if (this.mUO == null) {
                dDC();
            }
            if (this.mUP != null) {
                this.mUP.setText(roomToast.mToastContent);
            }
            if (!this.mUO.isShowing()) {
                if (this.mUC != null) {
                    this.mUO.showAtLocation(this.mUC, 85, 0, this.mZL.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
                    RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mUO != null) {
                                a.this.mUO.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mUO.dismiss();
        }
    }

    private void dDC() {
        if (this.mUO == null) {
            View inflate = LayoutInflater.from(this.nab).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mUP = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mUO = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 160.0f), -2);
            this.mUO.setFocusable(false);
            this.mUO.setOutsideTouchable(false);
            this.mUO.setAnimationStyle(a.j.gift_toast_style);
            this.mUO.update();
        }
    }

    private void k(View view, int i, int i2) {
        if (this.naB != null && this.naB.isShowing()) {
            this.naB.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
        if (this.naY == null) {
            dEt();
        }
        if (!this.naY.isShowing()) {
            this.naY.showAtLocation(view, 83, i, i2);
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.naa.dDd().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.naY.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDD() {
        if (this.nbb != null) {
            if (h.isEmpty(this.nbc)) {
                if (((VideoPlayer) this.nab).q) {
                    this.nbb.bU(this.naa != null ? this.naa.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.nbb.bU(this.naa != null ? this.naa.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nab).q && this.nbc.size() == 2 && this.nbc.contains("4") && this.nbc.contains("2")) {
                this.nbb.bU(this.naa != null ? this.naa.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.nbc.size() > 1 || !((VideoPlayer) this.nab).q) {
                this.nbb.bU(this.naa != null ? this.naa.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.nbc.get(0))) {
                this.nbb.bU(this.naa != null ? this.naa.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.nbc.get(0))) {
                this.nbb.bU(this.naa != null ? this.naa.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.nbc.get(0))) {
                this.nbb.bU(this.naa != null ? this.naa.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
        if (this.naB == null) {
            al();
            this.naB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.naB.isShowing() && this.Su == 2) {
            this.naB.showAtLocation(view, 83, i, this.nab.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.naa.dDd().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.naB.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mZU != null) {
            this.mZU.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                g.c(this.nab, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mWp.getPlayState() == 4) {
                        e(true);
                        if (this.naa.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.naa.a(false);
                        ((VideoPlayer) this.nab).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mWp.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mWp.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                g.c(this.nab, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.naa.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nab).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                    this.ai = false;
                    ww(true);
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
        if (this.naP != null) {
            if (z) {
                this.naP.setVisibility(0);
            }
            this.naP.dQf();
            if (!z) {
                this.naP.setVisibility(8);
            }
        }
        g.c(this.nab, this.nab.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mTS != null) {
                this.mTS.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mZV != null) {
                this.mZV.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mTS != null) {
            this.mTS.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mZV != null) {
                    this.mZV.setVisibility(8);
                }
            }
        }
    }

    private void dDE() {
        this.e = false;
        k(true, false, true);
    }

    private void dDF() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mTD[i];
        if (this.Su != i2 || this.mTH != i) {
            this.mTH = i;
            this.Su = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dDs();
            a(this.naa != null ? this.naa.mSZ.get("1") : null);
            if (i2 == 2) {
                k();
                av(true, i3);
                v(true);
                b(true);
                dDJ();
                com.kascend.chushou.toolkit.a.c.a(this.nab, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            av(false, i3);
            v(false);
            b(false);
            if (this.naB != null && this.naB.isShowing()) {
                this.naB.dismiss();
            }
            if (i2 == 99) {
                if (this.mTE != null && this.mTE[i] != null && (this.mTE[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mTE[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nab, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nab, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nab, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nab, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.mTH = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.Su == 2) {
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
        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nac != null) {
            if (this.mUe != null && this.mUe.getVisibility() == 0) {
                u(false);
            }
            if (this.mZV != null && this.mZV.getVisibility() == 0) {
                this.f = true;
            }
            au(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mTG != null) {
            this.mTG.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mTG != null) {
            this.mTG.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mTG != null) {
            this.mTG.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mTG != null) {
            this.mTG.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mUC != null) {
            int size = iconConfig.configs.size();
            this.mUC.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nab).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mUC, false);
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
                this.mUC.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.naa != null ? this.naa.mSZ : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mTG != null) {
            this.mTG.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dDD();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mUz != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mUz.xw(a.c.kas_white);
            } else if (this.Su == 2) {
                this.mUz.bU(str, a.c.kas_white);
                if (this.mUA != null) {
                    this.mUA.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mUz.xw(a.c.kas_white);
                if (this.mUA != null) {
                    this.mUA.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mUA != null) {
                    this.mUA.setTextColor(a);
                    this.mUA.setTabTextSelectColor(a2);
                    this.mUA.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mUa != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mUa.xw(a.e.ic_hotwords_black_n);
            } else {
                this.mUa.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mTZ != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dEF().a(str, this.mTZ, a.e.player_skin_input);
            } else {
                this.mTZ.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mUd != null) {
                this.mUd.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void a(int i) {
        if (this.mTG != null) {
            this.mTG.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void D() {
        if (this.nab instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCJ = ((VideoPlayer) this.nab).dCJ();
            if (this.naS == null) {
                this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.naS.setVisibility(0);
            this.naS.a(2, dCJ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mTG != null) {
            this.mTG.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mTG != null) {
            this.mTG.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(long j) {
        if (this.mTG != null) {
            this.mTG.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0704a
    public void c(int i) {
        if (this.mTG != null) {
            this.mTG.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mTG != null && this.naa != null) {
            this.mTG.b(this.naa.mSW);
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
    public class C0697a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0697a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mTD.length) {
                return null;
            }
            switch (a.this.mTD[i]) {
                case 1:
                    if (a.this.mTF == null) {
                        a.this.mTF = com.kascend.chushou.view.user.a.a(2, null, a.this.naa.a, false, a.this.naa.h, false);
                    }
                    a.this.mTE[i] = a.this.mTF;
                    return a.this.mTF;
                case 2:
                    if (a.this.mTG == null) {
                        a aVar = a.this;
                        if (a.this.mTr != null && a.this.mTr.mWq != null) {
                            z = a.this.mTr.mWq.mInPKMode;
                        }
                        aVar.mTG = com.kascend.chushou.player.ui.a.wx(z);
                    }
                    a.this.mTE[i] = a.this.mTG;
                    return a.this.mTG;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.naa != null && a.this.naa.dDd() != null && !h.isEmpty(a.this.mUI)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mUI.get(i).url);
                        h5Options.a = a.this.mUI.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mTE[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.MQ(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.mTD.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int kW(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int MR(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String MS(int i) {
            return a.this.MQ(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int MT(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b MU(int i) {
            int dimensionPixelSize = a.this.nab.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void AX(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.Os(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mTC <= 3000) {
            g.Os(a.i.str_too_fast);
            return false;
        } else {
            dDL();
            if (!com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a(((VideoPlayer) this.nab).dCD().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mTC = System.currentTimeMillis();
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                a(this.naa.dDd().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.naa.h);
            }
            g(this.b);
            if (!z && this.mUf != null) {
                this.mUf.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dDL();
            if (com.kascend.chushou.d.e.c(this.nab, null) && LoginManager.Instance().getUserInfo() != null && this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                a(this.naa.dDd().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mUf != null) {
                this.mUf.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mTG != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.naa.dDd().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.naa.dDd().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nab).mRh;
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
                        this.mTG.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mTG.a(arrayList, true, true);
        }
    }

    private void dDG() {
        if (this.mTG != null) {
            this.mTG.e();
        }
        if (this.mUG != null && this.mUG.isShown()) {
            this.mUG.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dDH() {
        super.dDH();
        if (this.nab instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nab;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.naa != null) {
            this.naa.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dDG();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mUE);
        if (this.nab != null) {
            if (this.mUE || "10004".equals(((VideoPlayer) this.nab).t)) {
                this.mUE = true;
                if (this.naa != null) {
                    this.naa.f = null;
                    if (this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                        this.naa.dDd().mRoominfo.mGameId = null;
                    }
                }
                dDv();
                return;
            }
            this.mUE = true;
            if (this.nab != null) {
                ((VideoPlayer) this.nab).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mUE = false;
        if (this.mTQ != null) {
            this.mTQ.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mUE = false;
        if (this.mTQ != null) {
            this.mTQ.setVisibility(8);
        }
        super.i(z);
    }

    private void dDI() {
        dDt();
        if (i()) {
            dDK();
            dEr();
            return;
        }
        dDv();
    }

    private void dDJ() {
    }

    private void dDK() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dEq().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.naP != null) {
            this.naP.setVisibility(0);
        }
        if (this.mTm != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mTm.d();
        }
        if (this.mTY != null) {
            this.mTY.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mTN.setVisibility(0);
            this.mTN.setOnClickListener(this);
        } else {
            this.mTN.setVisibility(8);
        }
        this.mTS.setVisibility(0);
        this.mTO.setVisibility(0);
        this.mZS.setVisibility(0);
        if (this.p) {
            this.mZT.setVisibility(0);
        } else {
            this.mZT.setVisibility(8);
        }
        dDJ();
        av(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.naS != null && this.naS.a(i, keyEvent)) {
                return true;
            }
            if (this.mUL != null && this.mUL.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mUM != null && this.mUM.onKeyDown(i, keyEvent)) || dDM()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mVd != null && this.mVd.getVisibility() == 0 && b(motionEvent, this.mVd)) {
                this.mVd.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mVc);
                return true;
            } else if (this.mUD && this.mVd != null && this.mVd.getVisibility() == 8 && g(this.naH.b, motionEvent)) {
                dDB();
                return true;
            } else if (this.mUL != null && this.mUL.b() && g(this.mUL, motionEvent)) {
                this.mUL.a();
                return true;
            } else if (this.mUM != null && this.mUM.b() && g(this.mUM, motionEvent)) {
                this.mUM.a();
                return true;
            } else if (b(motionEvent, this.mUe)) {
                return dDL();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dDL() {
        boolean z;
        b(this.mUN, 10);
        boolean z2 = false;
        if (this.mUu != null && this.mUu.getVisibility() == 0) {
            this.mUu.setVisibility(8);
            this.mUv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mUw) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
            this.mUv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mUe == null || this.mUe.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mUt) {
                dDW();
            }
            this.mUe.setVisibility(8);
            z = true;
        }
        if (this.Su == 2) {
            RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mTY != null && a.this.Su == 2) {
                        a.this.mTY.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dDM() {
        if (dDL()) {
            return true;
        }
        if (this.naB == null || !this.naB.isShowing()) {
            return dDB() || dDz() || cYq();
        }
        this.naB.dismiss();
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
    public void dDN() {
        this.mTY.setVisibility(8);
        this.mUe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z, boolean z2) {
        if (this.mTY != null) {
            if (z) {
                if (this.mTY.getVisibility() != 0) {
                    this.mTY.setVisibility(0);
                    this.mTY.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_bottom_anim));
                }
            } else if (this.mTY.getVisibility() != 4) {
                this.mTY.setVisibility(4);
                this.mTY.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mTQ != null) {
            this.mTQ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDO() {
        return this.mUR;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dEp()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.naa != null) {
                        this.naa.f = null;
                        this.naa.dDd().mRoominfo.mGameId = null;
                    }
                    dDv();
                    return;
                }
                g.Os(a.i.str_getvideosource_failed);
            }
            ww(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.naa != null && this.naa.dDe() != null) {
            a(this.naa.dDe());
        }
        this.p = false;
        if (this.naa == null || this.naa.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.naa.f.size()) {
                if (!"2".equals(this.naa.f.get(i2).mType)) {
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
        if (this.mTG != null) {
            this.mTG.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dEp()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mTT != null && this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                this.mTT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.naa.dDd().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dEp() && !this.mUJ && (c = c(1, -1)) >= 0 && c < this.mUI.size() && this.mUB != null) {
            this.mUB.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dEp() && !this.mUJ) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nab, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCK = ((VideoPlayer) this.nab).dCK();
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(2, dCK);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCL = ((VideoPlayer) this.nab).dCL();
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(2, dCL);
            } else if (bVar.a == 9) {
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mUu != null) {
            this.mUu.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dEp() && !this.mUJ) {
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
        if (!dEp() && this.naa != null) {
            String str = this.naa.a;
            RoomInfo dDf = this.naa.dDf();
            if (dDf != null && mVar.a(dDf.mCreatorUID, str)) {
                dDf.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.Su == 2) {
            RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dEp()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mUf != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mUf);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDP() {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
            if (this.mUF == null) {
                this.mUF = new f(getActivity());
            }
            this.mUF.a(this.naa.dDd().mRoominfo);
            if (!this.mUF.isShowing()) {
                this.mUF.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mTG != null) {
            this.mTG.d();
        }
    }

    private void dB(View view) {
        this.mTU = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mTV = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mTV.setText(new tv.chushou.zues.widget.a.c().O(this.nab, a.e.videoplayer_4g_video).append("  ").append(this.nab.getString(a.i.videoplayer_4g_video)));
        this.mTW = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mTW.setText(new tv.chushou.zues.widget.a.c().O(this.nab, a.e.videoplayer_4g_audio).append("  ").append(this.nab.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mTU.setVisibility(8);
                    ((VideoPlayer) a.this.nab).c(a.this.mTX);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mTU.setVisibility(8);
                    ((VideoPlayer) a.this.nab).d(a.this.mTX);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dCl().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mTV.setOnClickListener(onClickListener);
        this.mTW.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.naa != null && !h.isEmpty(this.naa.f)) {
            f(this.naa.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mTX = z;
            this.p = false;
            if (this.naa != null && this.naa.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.naa.f.size()) {
                        break;
                    } else if (!"2".equals(this.naa.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mTU != null) {
                this.mTU.setVisibility(0);
                this.mTV.setVisibility(0);
                this.mTW.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mTU != null) {
            this.mTU.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mUV == null) {
                this.mUV = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dEp()) {
                            a.this.dDQ();
                        }
                    }
                };
                if (this.nac != null) {
                    this.nac.d(this.mUV, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mUV != null && this.nac != null) {
            this.nac.removeCallbacks(this.mUV);
            this.mUV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDQ() {
        if (LoginManager.Instance().islogined() && this.mTG != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nab, "显示双击666_num", null, new Object[0]);
            if (this.naa != null) {
                this.naa.b(false);
            }
            d(false);
            this.mTG.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mZL != null) {
            if (this.mUM == null) {
                this.mUM = (InteractionView) ((ViewStub) this.mZL.findViewById(a.f.view_interaction)).inflate();
                this.mUM.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mUM.a();
                    }
                });
            }
            if (this.mUM != null) {
                this.mUM.b(configDetail);
                this.mUM.c();
                this.mUM.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQQ()) {
                g.M(this.nab, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nab, null) && (this.nab instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.naa != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nab, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.naa != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nab, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nab, configDetail.mUrl, this.nab.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nab, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    dDR();
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

    private void dDR() {
        if (this.mUD) {
            dDB();
            return;
        }
        if (this.nab.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nab, "点击送礼_num", "竖屏", new Object[0]);
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.naa.dDd().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nab != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mTr == null) {
                this.mTr = new com.kascend.chushou.player.e.a();
            }
            this.mTr.b = str;
            this.mTr.mWq.copy(pkNotifyInfo);
            if (this.mTr.mWq.mAction == 6) {
                this.mTr.mWq.mInPKMode = true;
                this.u = this.mTr.mWq.mPkId;
            } else if (this.mTr.mWq.mAction == 7 || (this.mTr.mWq.mMode == 1 && this.mTr.mWq.mAction == 5)) {
                this.mTr.mWq.mInPKMode = true;
                this.u = this.mTr.mWq.mPkId;
                if (dDT() != null) {
                    if (2 == this.Su && this.mUY != null) {
                        this.mUY.setVisibility(0);
                    }
                    dDT().b(this.mTr.mWq, false);
                    dDT().a(this.mTr.mWq.mMode, "1");
                    if (this.mTr.mWq.mAction == 5 && this.mTr.mWq.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mTr.mWq.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mTr.mWq.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mTr.mWq.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mTr.mWq.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mTr.mWq.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dDT().a(this.mTr.mWq);
                        if (this.mTr.mWq.destinyInfo == null || this.mTr.mWq.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dDT().a(parseInt, this.mTr.mWq.mPkUpdateInfo.remainDuration, j, this.mTr.mWq.mMode, i);
                    }
                    if (!h.isEmpty(this.mTr.mWq.mPkUpdateInfo.specialMomentList) && dDT() != null) {
                        dDT().a(this.mTr.mWq, true);
                    }
                }
                dDS();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.QW(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mTr.mWq.mInPKMode = false;
                dDS();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.QW(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dDS() {
        if (this.mTr != null && this.mTr.mWq != null) {
            if (this.mTr.mWq.mInPKMode) {
                this.y.setText(this.mTr.mWq.mPkUserNickname);
                this.mTt.setVisibility(0);
                if (this.mZR != null) {
                    this.mZR.setEnabled(false);
                }
                if (this.mZT != null) {
                    this.mZT.setEnabled(false);
                    return;
                }
                return;
            }
            this.mTt.setVisibility(8);
            if (this.mZR != null) {
                this.mZR.setEnabled(true);
            }
            if (this.mZT != null) {
                this.mZT.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dDT() {
        if (this.nab == null || this.mZL == null || this.mUY == null) {
            return null;
        }
        if (this.mTs == null) {
            if (this.mUX == null) {
                this.mUX = ((ViewStub) this.mZL.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mTs = new com.kascend.chushou.player.e.b();
            this.mTs.a(this.mUY, this.mUX, (View) null, this.nab, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dQz()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.naa != null) {
                        append.append(a.this.naa.dDf().mRoomID);
                    }
                    if (a.this.mTr != null && a.this.mTr.mWq != null) {
                        append.append("&mode=").append(a.this.mTr.mWq.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nab, append.toString());
                }
            });
        }
        return this.mTs;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mUr != null && this.naa != null && this.naa.mSY != null) {
            this.mUr.setText(tv.chushou.zues.utils.b.Or(this.naa.mSY.count));
            this.mUr.setVisibility(0);
            if (this.naa.mSY.count < 1) {
                dDW();
            }
            if (this.mUi != null) {
                this.mUi.setText(this.naa.mSY.primaryName);
            }
            if (this.mUj != null) {
                this.mUj.setText(this.naa.mSY.desc);
            }
            dDU();
        }
    }

    public void dDU() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mUs * h.parseLong(this.naa.mSY.point)));
        if (this.mUm != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nab.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.nab, a.e.icon_coin_new);
            cVar.append(this.nab.getString(a.i.str_buy_count_coin2));
            this.mUm.setText(cVar);
        }
    }

    private void dDV() {
        if (com.kascend.chushou.d.e.c(this.nab, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mUs);
        }
    }

    private void v(boolean z) {
        if (this.mZL != null && this.mUY != null) {
            if (z) {
                if (this.mTr != null && this.mTr.mWq != null && this.mTr.mWq.mInPKMode) {
                    this.mUY.setVisibility(0);
                    return;
                }
                return;
            }
            this.mUY.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mZL != null && this.mTw != null) {
            if (z) {
                if (this.E && 2 == this.Su) {
                    this.mTw.setVisibility(0);
                    return;
                }
                return;
            }
            this.mTw.setVisibility(8);
        }
    }

    private void wp(boolean z) {
        if (z) {
            if (this.mTr != null && this.mTr.mWq != null && this.mTr.mWq.mInPKMode && this.mTt != null) {
                this.mTt.setVisibility(0);
            }
        } else if (this.mTt != null) {
            this.mTt.setVisibility(8);
        }
    }

    private void dDW() {
        this.mUt = false;
        this.mUq.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.naa != null && this.naa.mSY != null) {
            if (this.naa.mSY.count < 1) {
                this.mUr.setVisibility(8);
            } else {
                this.mUr.setVisibility(0);
                this.mUr.setSelected(false);
                this.mUr.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mUh.setVisibility(8);
        if (this.mUf != null) {
            this.mUf.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dDR();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mUd != null) {
            this.mUd.performClick();
        }
    }

    public boolean dDX() {
        return this.Su == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.mVj = true;
        if (this.mZL != null && com.kascend.chushou.b.dCl().d == 0) {
            this.mUT = tv.chushou.zues.utils.systemBar.b.hg(getActivity());
            if (!z) {
                View findViewById = this.mZL.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.mUT = tv.chushou.zues.utils.systemBar.b.hg(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.mUT);
            View findViewById2 = this.mZL.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.mUT);
            findViewById2.requestLayout();
        }
    }
}
