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
    private TextView mKA;
    private RelativeLayout mKB;
    private TextView mKC;
    private TextView mKD;
    private boolean mKE;
    private RelativeLayout mKF;
    private View mKG;
    private FrescoThumbnailView mKH;
    private AnimationSet mKI;
    private ImageView mKJ;
    private TextView mKK;
    private RelativeLayout mKL;
    private PastedEditText mKM;
    private TextView mKN;
    private LinearLayout mKO;
    private TextView mKP;
    private TextView mKQ;
    private TextView mKR;
    private TextView mKS;
    private TextView mKT;
    private TextView mKU;
    private TextView mKV;
    private ImageView mKW;
    private TextView mKX;
    private int[] mKl;
    private Fragment[] mKm;
    private ImageView mKq;
    private MarqueeTextView mKr;
    private MarqueeTextView mKs;
    private ImageView mKt;
    private ImageView mKu;
    private ImageButton mKv;
    public String mKw;
    private RecommendView mKx;
    private LivePKBarUserValue mLA;
    private String mLB;
    private TextView mLC;
    private ImageView mLD;
    private EditText mLE;
    private View mLF;
    private View mLG;
    private View mLH;
    private String mLK;
    private KPSwitchPanelLinearLayout mLa;
    private ImageView mLb;
    private c mLd;
    private d.a mLe;
    private FrescoThumbnailView mLf;
    private PagerSlidingTabStrip mLg;
    private KasViewPager mLh;
    private LinearLayout mLi;
    private f mLk;
    private ViewMicPerson mLl;
    public ArrayList<RoomTab> mLn;
    private PopH5Menu mLp;
    private InteractionView mLq;
    private PopupWindow mLr;
    private TextView mLs;
    private GiftAnimationLayout mLt;
    private com.kascend.chushou.player.b.a mLu;
    private Runnable mLx;
    private View mLz;
    private long mKf = 0;
    private com.kascend.chushou.view.user.a mKn = null;
    private com.kascend.chushou.player.ui.a mKo = null;
    private int bB = -1;
    private int bC = 0;
    private View mKp = null;
    private View mKy = null;
    private ImageButton mKz = null;
    private int mKY = 1;
    private boolean mKZ = false;
    private boolean mLc = false;
    private boolean cw = false;
    private boolean mLj = false;
    private boolean mLm = false;
    private boolean cB = false;
    private boolean mLo = true;
    private int cK = 0;
    private int mLv = 0;
    private int mLw = -1;
    private final Rect mLy = new Rect();
    private boolean mLI = false;
    private C0800a mLJ = null;
    private boolean da = false;
    private boolean mLL = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mKw = getArguments().getString("mCover");
        this.mLo = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mQi = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mQi;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dFE()) {
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
        if (this.mRd != null) {
            this.mRd.b();
        }
        if (this.mQy != null && (this.mQy instanceof VideoPlayer)) {
            ((VideoPlayer) this.mQy).wy(true);
            ((VideoPlayer) this.mQy).z();
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
        this.mKY = 1;
        this.mKZ = false;
        U();
        if (this.mQz != null) {
            this.mQz.cg(null);
            this.mQz = null;
        }
        if (this.mKx != null) {
            dFF().removeAllViews();
            this.mKx = null;
        }
        this.c = null;
        this.mJT = null;
        tv.chushou.zues.a.a.ch(this);
        this.mLg = null;
        this.mLh = null;
        this.mKo = null;
        this.mKn = null;
        if (this.mKm != null) {
            for (int i = 0; i < this.mKm.length; i++) {
                this.mKm[i] = null;
            }
        }
        this.mKm = null;
        if (this.mKM != null) {
            this.mKM.addTextChangedListener(null);
            this.mKM.setOnTouchListener(null);
            this.mKM.setOnEditorActionListener(null);
            this.mKM = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mQy, this.mLd);
        if (this.mQy != null && (this.mQy instanceof VideoPlayer)) {
            ((VideoPlayer) this.mQy).dEp();
        }
        this.mLe = null;
        this.mLd = null;
        if (this.mLl != null) {
            this.mLl.b();
            this.mLl = null;
        }
        if (this.mLr != null) {
            this.mLr.dismiss();
        }
        if (this.mLu != null) {
            this.mLu.a();
            this.mLu = null;
            this.mLt = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mLA = (LivePKBarUserValue) this.mQi.findViewById(a.f.live_pk_bar_user);
        this.mQr = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mLI) {
            this.mLI = true;
            if (this.mLG == null) {
                this.mLG = this.mQi.findViewById(a.f.vs_async_view);
                this.mLG = ((ViewStub) this.mLG).inflate();
            }
            if (this.mLH == null) {
                this.mLH = this.mQi.findViewById(a.f.vs_async_notification_view);
                this.mLH = ((ViewStub) this.mLH).inflate();
            }
            this.mKe = (VoiceInteractionView) this.mQi.findViewById(a.f.voiceInteractiveView);
            t();
            ds(this.mQi);
            dsG();
            ((VideoPlayer) this.mQy).q();
            this.mJZ = new com.kascend.chushou.player.e.a();
        }
    }

    private void ds(View view) {
        this.mLf = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mLg = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mLh = (KasViewPager) view.findViewById(a.f.vp_main);
        aH();
        dEX();
        aN();
        if (this.mQx != null) {
            I();
            a(this.mQx.mJF, this.mQx.mJI);
        }
        this.bb = 0;
        this.mRi = 0L;
        this.mRe = (RoundProgressBar) this.mQi.findViewById(a.f.roundProgressBar);
        this.mRf = (TextView) this.mQi.findViewById(a.f.tv_paonum);
        this.mRg = (FrescoThumbnailView) this.mQi.findViewById(a.f.iv_paoicon);
        this.mRn = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
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
                if (a.this.mRd != null) {
                    a.this.mRd.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gv(a.this.mQy).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mQy)) - a.this.mRd.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mQy, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mQy, 54.0f) * 2);
                    if (statusBarHeight < a.this.cF) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mRh = (PaoGuideView) this.mQi.findViewById(a.f.rlPaoGuideView);
        this.mLl = (ViewMicPerson) this.mQi.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.mMN = ((VideoPlayer) this.mQy).dEi();
        this.mQx = ((VideoPlayer) this.mQy).dEl();
        dt(this.mQi);
        this.cK = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
        this.mLv = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (com.kascend.chushou.b.dDS().d == 0 && this.mLv > 0) {
            View findViewById = this.mQi.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mLv);
        }
        dFd();
        dFb();
        if (!this.mLo) {
            Q();
        }
        aO();
        a();
        if (this.c == null) {
            this.mJT = new d.a();
            this.c = new GestureDetector(this.mQy, this.mJT);
        }
        this.mJV = ((VideoPlayer) this.mQy).dEm();
        this.mJV.a(this);
        if (this.mLu != null) {
            this.mLu.a();
            this.mLu = null;
        }
        this.mLt = (GiftAnimationLayout) this.mQi.findViewById(a.f.ll_gift_animation);
        this.mLt.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mQx != null) {
            this.mLu = new com.kascend.chushou.player.b.a(this.mQy.getApplicationContext(), this.mLt);
            this.mLu.a(this.mQx);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mQi.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mQs = (PlayerErrorView) this.mQi.findViewById(a.f.view_net_error_msg);
        this.mQs.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dFa();
        dFg();
        if (this.mQx.dEM() != null) {
            a(this.mQx.dEM());
        }
        FullRoomInfo dEL = this.mQx.dEL();
        if (dEL != null) {
            dFj();
            if (i()) {
                this.ak = false;
                wC(true);
                this.mQz.Kq(8);
            }
            this.mKA.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dEL.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mKp.setVisibility(0);
        this.ak = false;
        wC(true);
        this.mQz.Kq(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mQy).n();
        if (this.mQx != null && !h.isEmpty(this.mQx.w)) {
            b(this.mQx.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dEw;
        aH();
        k();
        FullRoomInfo dEL = this.mQx.dEL();
        if (dEL != null) {
            if (dEL.mRoominfo != null) {
                this.mKA.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dEL.mRoominfo.mOnlineCount)));
                this.mLB = dEL.mRoominfo.mRoomID;
            }
            dFj();
            if (!h.isEmpty(dEL.mRoomToastList)) {
                Iterator<RoomToast> it = dEL.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dDZ().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mQx != null && this.mQx.l()) {
                d(true);
            }
            if (this.mQy != null && (this.mQy instanceof VideoPlayer) && (dEw = ((VideoPlayer) this.mQy).dEw()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dEw.mMO, dEw.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mLi);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void aH() {
        boolean z = true;
        if (this.mQx == null || this.mQx.dEL() == null || this.mQx.dEL().mRoominfo == null || h.isEmpty(this.mQx.dEL().mRoomTabs)) {
            this.mLm = false;
            this.mKm = new Fragment[2];
            this.mKl = new int[2];
            this.mKl[0] = 2;
            this.mKl[1] = 1;
            return;
        }
        this.mLm = true;
        this.mLn = new ArrayList<>();
        Iterator<RoomTab> it = this.mQx.dEL().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mLn.add(next);
            }
        }
        if (this.mLn.size() >= 2 && this.mKl != null && this.mKl.length >= 2 && this.mLn.get(0).type == this.mKl[0] && this.mLn.get(1).type == this.mKl[1]) {
            z = false;
        }
        this.mKm = new Fragment[this.mLn.size()];
        this.mKl = new int[this.mLn.size()];
        for (int i = 0; i < this.mLn.size(); i++) {
            this.mKl[i] = this.mLn.get(i).type;
        }
        if (z) {
            this.mLJ = new C0800a(getChildFragmentManager());
            this.mLh.setAdapter(this.mLJ);
        }
    }

    private void dEX() {
        this.mKL = (RelativeLayout) this.mQi.findViewById(a.f.rl_edit_bar);
        this.mKH = (FrescoThumbnailView) this.mQi.findViewById(a.f.btn_hotword);
        this.mKH.yE(a.e.ic_hotwords_black_n);
        this.mKH.setOnClickListener(this);
        this.mKJ = (ImageView) this.mQi.findViewById(a.f.iv_task_badge);
        this.mKI = (AnimationSet) AnimationUtils.loadAnimation(this.mQy, a.C0794a.anim_hotword);
        this.mKI.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dDZ().c) {
                    a.this.mKH.clearAnimation();
                    a.this.mKH.startAnimation(a.this.mKI);
                }
            }
        });
        if (com.kascend.chushou.d.h.dDZ().c) {
            this.mKH.startAnimation(this.mKI);
            this.mKJ.setVisibility(0);
        }
        this.mKK = (TextView) this.mQi.findViewById(a.f.tv_bottom_input);
        this.mKK.setOnClickListener(this);
        this.mRy = (FrescoThumbnailView) this.mQi.findViewById(a.f.ll_btn_set);
        this.mRy.setOnClickListener(this);
        this.mLi = (LinearLayout) this.mQi.findViewById(a.f.ll_bottom_all_button);
        this.mKF = (RelativeLayout) this.mQi.findViewById(a.f.rl_bottom_input);
        this.mKG = this.mQi.findViewById(a.f.ll_bottom_input);
        this.mKF.setVisibility(8);
        this.mKM = (PastedEditText) this.mQi.findViewById(a.f.et_bottom_input);
        this.mKM.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mKN.setEnabled(editable.length() > 0);
            }
        });
        this.mKM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mKN);
                    return true;
                }
                return true;
            }
        });
        this.mKM.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.m(a.this.mKM);
                }
                return false;
            }
        });
        this.mLb = (ImageView) this.mQi.findViewById(a.f.iv_btn_emoji);
        this.mLb.setVisibility(8);
        this.mKN = (TextView) this.mQi.findViewById(a.f.tv_btn_send);
        this.mKN.setOnClickListener(this);
        this.mLa = (KPSwitchPanelLinearLayout) this.mQi.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dDS().d == 0) {
            this.mLa.setUseStatusBar(true);
        }
        this.mKO = (LinearLayout) this.mQi.findViewById(a.f.head_trumpet);
        this.mKO.setVisibility(8);
        this.mKO.setOnClickListener(this);
        this.mKP = (TextView) this.mQi.findViewById(a.f.tv_primary_name);
        this.mKQ = (TextView) this.mQi.findViewById(a.f.tv_primary_desc);
        this.mKT = (TextView) this.mQi.findViewById(a.f.tv_cut_count);
        this.mKT.setOnClickListener(this);
        this.mKV = (TextView) this.mQi.findViewById(a.f.tv_head_count);
        this.mKV.setText(this.mKY + "");
        this.mKU = (TextView) this.mQi.findViewById(a.f.tv_plus_count);
        this.mKU.setOnClickListener(this);
        this.mKS = (TextView) this.mQi.findViewById(a.f.tv_buy_count_coin);
        this.mKR = (TextView) this.mQi.findViewById(a.f.tv_buy_head);
        this.mKR.setOnClickListener(this);
        this.mKW = (ImageView) this.mQi.findViewById(a.f.iv_trumpet_select);
        this.mKW.setOnClickListener(this);
        this.mKX = (TextView) this.mQi.findViewById(a.f.tv_trumpet_have_count);
        this.mKZ = false;
        this.mKW.setBackgroundResource(a.e.ic_trumpet_n);
        this.mKX.setVisibility(8);
        dEZ();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mLa, this.mLb, this.mKM, new a.InterfaceC0924a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0924a
            public void wz(boolean z) {
                if (a.this.mLb != null) {
                    if (!z) {
                        a.this.mLb.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dDS().d == 0) {
                        a.this.mLa.setDirectVisibility(0);
                    }
                    a.this.mLb.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mLe = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wA(boolean z) {
                if (a.this.mLL) {
                    a.this.mLL = false;
                    return;
                }
                a.this.mLc = z;
                if (z) {
                    a.this.mLb.setImageResource(a.e.cs_emoji_normal);
                    a.this.dEY();
                    return;
                }
                if (a.this.mLF != null && a.this.mLF.getVisibility() == 0) {
                    a.this.mLF.setVisibility(8);
                }
                if (a.this.cw) {
                    a.this.mRd.setVisibility(0);
                }
                if (a.this.mQy != null && (a.this.mQy instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mQy).wy(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mLd = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mLa, this.mLe, ((VideoPlayer) this.mQy).dEq());
        ((VideoPlayer) this.mQy).h(((VideoPlayer) this.mQy).dEq());
        this.mLF = this.mQi.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mLC = (TextView) this.mQi.findViewById(a.f.btn_room_search);
        this.mLD = (ImageView) this.mQi.findViewById(a.f.iv_room_emoji_delete);
        this.mLE = (EditText) this.mQi.findViewById(a.f.et_room_emoji_search);
        this.mLE.setImeOptions(3);
        this.mLE.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mLC);
                    return true;
                }
                return false;
            }
        });
        this.mLE.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mLC.setEnabled(editable.length() > 0);
                a.this.mLD.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mRd.setEmojiSearchText(editable.toString());
            }
        });
        this.mLC.setOnClickListener(this);
        this.mLD.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dD(this.mLE);
            this.mLF.setVisibility(0);
            this.mLE.requestFocus();
        } else {
            this.mLF.setVisibility(8);
        }
        if (z2) {
            this.mLE.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEY() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gv(this.mQy).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy)) - tv.chushou.zues.widget.kpswitch.b.d.gI(this.mQy)) - tv.chushou.zues.utils.a.dip2px(this.mQy, 14.0f)) - this.mQy.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mQy, 54.0f) * 2);
        if (statusBarHeight < this.cF) {
            b(statusBarHeight, 10);
        }
    }

    private void dEZ() {
    }

    private void dFa() {
        this.mQz = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.au(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mQi.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mQy.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mQz.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mQz.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mQz.A(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mQz);
                            break;
                        case 12:
                            a.this.b(a.this.mQz);
                            break;
                        case 17:
                            a.this.dFG();
                            break;
                        case 18:
                            a.this.dsF();
                            break;
                        case 19:
                            a.this.mQw.setVisibility(8);
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
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mLn)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mLn.size()) {
                    if (!h.isEmpty(this.mLn.get(i2).notifyIcon)) {
                        this.mLg.bF(i2, this.mLn.get(i2).notifyIcon);
                        this.mLg.KQ(i2);
                    } else if (this.mLn.get(i2).notify == 1) {
                        this.mLg.KP(i2);
                        this.mLg.KO(i2);
                    } else {
                        this.mLg.KO(i2);
                        this.mLg.KQ(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mLn)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mLn.size()) {
                    if (this.mLn.get(i4).type == i) {
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
    public String IV(int i) {
        if (this.mQx == null || this.mQx.dEL() == null || this.mQx.dEL().mRoominfo == null || h.isEmpty(this.mLn)) {
            if (i == 1) {
                return this.mQy.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mQy.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mLn.size()) {
            return this.mLn.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mLn) && i < this.mLn.size()) {
            this.mLn.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mLn) && i < this.mLn.size()) {
            this.mLn.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.mLh != null && this.mLg != null && this.mKl != null) {
            this.mKo = null;
            if (this.mKm != null) {
                for (int i = 0; i < this.mKm.length; i++) {
                    this.mKm[i] = null;
                }
            }
            if (this.mLJ == null) {
                this.mLJ = new C0800a(getChildFragmentManager());
                this.mLh.setAdapter(this.mLJ);
            } else {
                this.mLJ.notifyDataSetChanged();
            }
            this.mLh.setOffscreenPageLimit(this.mKl.length);
            this.mLg.c(this.mLh);
            this.mLg.setOnPageChangeListener(this);
            this.mLg.notifyDataSetChanged();
            this.mLg.setVisibility(0);
            this.mLh.setVisibility(0);
            if (!this.mLm) {
                this.bB = 2;
                this.mLh.setCurrentItem(c(2, 0));
                this.mKF.setVisibility(0);
            } else {
                if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                    if (!h.isEmpty(this.mQx.dEL().mRoominfo.mGameName)) {
                        this.mKs.setText(this.mQx.dEL().mRoominfo.mGameName);
                    } else {
                        this.mKs.setText(this.mQy.getString(a.i.no_online_game_name));
                    }
                    this.mKr.setText(this.mQx.dEL().mRoominfo.mName);
                } else {
                    this.mKs.setText(this.mQy.getString(a.i.no_online_game_name));
                }
                aM();
                if (i()) {
                    dFh();
                    if (this.mLh != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.mLh.setCurrentItem(c);
                        this.mLg.setSelectItem(c);
                    }
                } else if (this.mLh != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.mLh.setCurrentItem(c2);
                    this.mLg.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mQy);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dFF().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void aP() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mQy).s();
        dsM();
        dFe();
        dEW();
        dFF().setBackgroundResource(a.e.room_not_online);
        if (this.mKx == null) {
            this.mKx = new RecommendView(this.mQy);
            dFF().addView(this.mKx);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mQy);
            this.mKx.setLayoutParams(layoutParams);
        }
        if (this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mQx.dEL().mRoominfo.mRoomID)) {
            this.mKx.a(this.mQx.dEL().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dFE() && a.this.mQy != null && a.this.dFF() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mQy);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.mqe);
                        if (a.this.dFF().getChildCount() >= 2) {
                            a.this.dFF().addView(frescoThumbnailView, 0);
                        }
                        a.this.dFF().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dRB(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mRl != null) {
            this.mRl.dQW();
            this.mRl.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mRd != null) {
            this.mRd.e();
        }
        wC(false);
        a(false, false);
        if (this.mJV != null) {
            this.mJV.d();
        }
    }

    private void dFb() {
        int i = 0;
        this.mKp = this.mQi.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dDS().d == 0 && this.cK > 0) {
            View findViewById = this.mQi.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.cK;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mKq = (ImageView) this.mKp.findViewById(a.f.back_icon);
        this.mKq.setOnClickListener(this);
        this.mKr = (MarqueeTextView) this.mKp.findViewById(a.f.tv_title);
        this.mKs = (MarqueeTextView) this.mKp.findViewById(a.f.tv_Type);
        this.mKu = (ImageView) this.mQi.findViewById(a.f.btn_setting);
        this.mKy = this.mQi.findViewById(a.f.bottomview);
        if (this.mQp == null) {
            this.mQp = (ImageButton) this.mKy.findViewById(a.f.btn_barrage);
            this.mQp.setOnClickListener(this);
            if (this.mQx != null) {
                if (com.kascend.chushou.d.h.dDZ().n()) {
                    this.mQp.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mQp.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mQq = (ImageButton) this.mKy.findViewById(a.f.btn_audio);
        this.mQq.setOnClickListener(this);
        if (this.mQx != null && this.mQx.d) {
            this.mQq.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mQq.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mQx != null && this.mQx.f != null) {
            while (true) {
                if (i >= this.mQx.f.size()) {
                    break;
                } else if (!"2".equals(this.mQx.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mKz = (ImageButton) this.mKy.findViewById(a.f.playbutton);
        this.mKz.setOnTouchListener(this);
        this.mKv = (ImageButton) this.mKy.findViewById(a.f.btn_refresh);
        this.mKv.setOnClickListener(this);
        this.mKA = (TextView) this.mKy.findViewById(a.f.tv_online_count);
        if (this.mQo == null) {
            this.mQo = (ImageButton) this.mKy.findViewById(a.f.btn_screenChange);
            this.mQo.setOnClickListener(this);
        }
        if (this.mKt == null) {
            this.mKt = (ImageView) this.mKp.findViewById(a.f.report_icon);
            this.mKt.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
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
        if (!dFE() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mKo != null) {
                        this.mKo.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                        this.mQx.dEL().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mQx.dEL().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.mQx.dEL().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mQx.dEL().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.mQx.dEL().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mQx.dEL().mMicStatus.onMic) {
                            this.mQx.dEL().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mQx.dEL().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.mQx.dEL().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mQx.dEL().mMicStatus != null && !h.isEmpty(this.mQx.dEL().mMicStatus.micRoomId) && !this.mQx.dEL().mMicStatus.micRoomId.equals("0")) {
                                this.mLK = this.mQx.dEL().mMicStatus.micRoomId;
                            }
                            if (this.mKo != null) {
                                this.mKo.a(this.mQx.dEL().mMicStatus, this.mQx.dEL().mFanItems, str, z2);
                            }
                            if (this.mLl != null && this.mLl.getVisibility() == 0) {
                                this.mLl.a(this.mQx.dEL().mFanItems, this.mQx.dEL().mMicStatus, str, z2, this.mQx.dEL().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mKo != null) {
                                this.mKo.e();
                            }
                            if (this.mLl != null && this.mLl.isShown()) {
                                this.mLl.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mKo != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mKo.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mKo.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mLw != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mLw = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mJZ != null && this.mJZ.mMO != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mJZ.mMO.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mJZ.mMO.mInPKMode = true;
                                    this.mJZ.mMO.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mJZ.mMO.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mJZ.mMO.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mJZ.mMO.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mJZ.mMO.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mJZ.mMO.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mJZ.mMO.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mJZ.mMO.mMode = pkNotifyInfo.mMode;
                                    this.mJZ.mMO.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dFn() != null) {
                                        dFn().g(true, this.mJZ.mMO.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dDZ().a) {
                                        if (!com.kascend.chushou.b.dDS().e) {
                                            com.kascend.chushou.b.dDS().e = true;
                                            g.F(this.mQy, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dDZ().a(this.mQy, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.mLA != null) {
                                        this.mLA.setVisibility(0);
                                    }
                                    this.mJZ.mMO.mAction = 7;
                                    this.mJZ.mMO.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mJZ.mMO.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mJZ.mMO.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mJZ.mMO.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mJZ.mMO.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mJZ.mMO.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dFn() != null) {
                                        dFn().g(false, 0L);
                                        dFn().b(this.mJZ.mMO, true);
                                        dFn().a(this.mJZ.mMO.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Qx(this.mLB);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mJZ.mMO.mInPKMode = false;
                                    this.mJZ.mMO.mAction = 2;
                                    bd();
                                    if (dFn() != null) {
                                        dFn().c();
                                    }
                                    if (com.kascend.chushou.d.h.dDZ().a) {
                                        if (!com.kascend.chushou.b.dDS().e) {
                                            com.kascend.chushou.b.dDS().e = true;
                                            g.F(this.mQy, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dDZ().a(this.mQy, false);
                                        ak();
                                    }
                                    this.mJZ.b = null;
                                    this.mJZ.mMO = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Qx(this.mLB);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mJZ.mMO.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mJZ.mMO.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mQx.dEL().mRoominfo.mRoomID) && this.mQx.dEL().mRoominfo.mRoomID.equals(this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dFn() != null) {
                                        dFn().a(this.mJZ.mMO, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mJZ.mMO.copyUpdate(pkNotifyInfo);
                                    if (dFn() != null) {
                                        dFn().a(this.mJZ.mMO);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mJZ.mMO.copyStop(pkNotifyInfo);
                                        if (dFn() != null) {
                                            dFn().A(this.mJZ.mMO.mMaxFreeDuration, this.mJZ.mMO.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mJZ.mMO.copyResult(pkNotifyInfo);
                                    if (!this.cB && dFn() != null) {
                                        int i5 = 1;
                                        if (this.mJZ.mMO.destinyInfo != null && this.mJZ.mMO.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dFn().a(h.parseInt(this.mJZ.mMO.mResult), h.parseLong(this.mJZ.mMO.mvpUid), this.mJZ.mMO.mvpAvatar, this.mJZ.mMO.mvpNickname, this.mJZ.mMO.mMaxFreeDuration, this.mJZ.mMO.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mKo != null) {
                if (LoginManager.Instance().islogined() && this.mQx != null && this.mQx.l()) {
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
                if (this.mQx == null || this.mQx.dEL() == null || this.mQx.dEL().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mQx.dEL().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dDZ().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dDZ().b().equals(next2.mUserID)) {
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
                this.mKo.a(arrayList, true, false);
                this.mKo.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mKl != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mKl.length) {
                    break;
                }
                if (this.mKl[i2] == 99 && this.mKm != null && this.mKm[i2] != null && (this.mKm[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mKm[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mLn.size() && this.mLg != null) {
                if (i == 0) {
                    this.mLg.setTagText(i2, new StringBuilder(this.mLn.get(i2).name).toString());
                    return;
                } else {
                    this.mLg.setTagText(i2, this.mLn.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mQp != null) {
            if (z) {
                this.mQp.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mQp.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dFc() {
        if (this.mQi == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mQi.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
        this.ar = Math.min(gv.x, gv.y);
        this.aq = (this.ar * this.mQy.getResources().getInteger(a.g.h_thumb_height_def)) / this.mQy.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dFF().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mQr.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.cF = this.aq + this.mQy.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mQy, 54.0f);
        b(this.cF, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dFd() {
        Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
        this.ar = Math.min(gv.x, gv.y);
        this.aq = (this.ar * this.mQy.getResources().getInteger(a.g.h_thumb_height_def)) / this.mQy.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dFF().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mQr.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.cF = this.aq + this.mQy.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mQy, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.cF, 10);
        k();
        if (!h.isEmpty(this.mKw)) {
            File af = tv.chushou.zues.widget.fresco.a.af(Uri.parse(this.mKw));
            if (af != null && af.exists()) {
                this.mQr.setImageURI(Uri.fromFile(af));
                this.mQr.setVisibility(0);
                return;
            }
            this.mQr.setVisibility(8);
            return;
        }
        this.mQr.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mKt != null) {
            this.mKt.setVisibility(z ? 0 : 4);
        }
        if (this.mKu != null) {
            this.mKu.setVisibility(z ? 0 : 4);
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
        if (this.mQz != null) {
            this.mQz.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mQy).f(true);
            if (!z3) {
                if (this.mKy.getVisibility() != 0 && z2) {
                    this.mKy.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mQq.setVisibility(0);
                } else {
                    this.mQq.setVisibility(8);
                }
                this.mKy.setVisibility(0);
            }
            PlayUrl dEM = this.mQx.dEM();
            if (dEM != null && "2".equals(dEM.mType)) {
                if (this.mQo != null) {
                    this.mQo.setVisibility(8);
                }
            } else if (this.mQo != null) {
                this.mQo.setVisibility(0);
            }
            if (this.mKp.getVisibility() != 0 && z2) {
                this.mKp.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_top_anim));
            }
            t(!z3);
            this.mKp.setVisibility(0);
            w(true);
            if (this.mQz != null) {
                this.mQz.A(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mQy).f(false);
            if (this.mQP != null) {
                this.mQP.dismiss();
            }
            if (this.mQQ != null) {
                this.mQQ.dismiss();
            }
            if (this.mKy.getVisibility() != 8 && z2) {
                this.mKy.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_bottom_anim));
            }
            this.mKy.setVisibility(8);
            if (this.mKp.getVisibility() != 8 && z2) {
                this.mKp.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_top_anim));
            }
            this.mKp.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dsM() {
        if (this.mRh == null || !this.mRh.isShown()) {
            return false;
        }
        this.mRh.d();
        return true;
    }

    public boolean dFe() {
        if (this.mLl == null || !this.mLl.isShown()) {
            return false;
        }
        this.mLl.a();
        return true;
    }

    public boolean dEW() {
        if (this.mLp == null || !this.mLp.b()) {
            return false;
        }
        this.mLp.a();
        return true;
    }

    public boolean dFf() {
        if (this.cw && this.mRd != null) {
            if (this.mRd != null) {
                this.mRd.e();
            }
            if (this.mLE != null) {
                this.mLE.setText("");
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
        if (listItem != null && this.mQi != null) {
            if (this.mLp == null) {
                this.mLp = (PopH5Menu) ((ViewStub) this.mQi.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mLp.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mLp.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.mKp.getHeight() + this.mKp.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mQy, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                g.c(this.mQy, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mQx.a(false);
                a(false, false);
                ((VideoPlayer) this.mQy).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.mQy, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mJZ == null || this.mJZ.mMO == null || !this.mJZ.mMO.mInPKMode) {
                ((VideoPlayer) this.mQy).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mKZ) {
                f(this.mKM.getText().toString());
            } else {
                a(this.mKM.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dDZ().c) {
                com.kascend.chushou.d.h.dDZ().b(false);
                this.mKI.cancel();
                this.mKI.reset();
                this.mKH.clearAnimation();
                this.mKJ.setVisibility(8);
            }
            n(view, 0, this.mQi.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mQy, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.mQi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mQx.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mQy, null) && this.mQx != null && this.mQx.mJH != null) {
                if (this.mKZ) {
                    bg();
                    return;
                }
                if (this.mQx != null && this.mQx.mJH != null && this.mQx.mJH.count > 0) {
                    this.mKO.setVisibility(8);
                } else {
                    this.mKO.setVisibility(0);
                }
                this.mKZ = true;
                this.mKW.setBackgroundResource(a.e.ic_trumpet_p);
                this.mKX.setVisibility(0);
                this.mKX.setSelected(true);
                this.mKX.setTextColor(Color.parseColor("#ff5959"));
                if (this.mKM != null) {
                    this.mKM.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mKY <= 9) {
                this.mKY++;
                this.mKV.setText(this.mKY + "");
            }
            dFo();
        } else if (id == a.f.tv_cut_count) {
            if (this.mKY > 1) {
                this.mKY--;
                this.mKV.setText(this.mKY + "");
            }
            dFo();
        } else if (id == a.f.tv_buy_head) {
            bf();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mLE.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mLE.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.mLE);
                this.mRd.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mKM != null && this.mKF != null && this.mKL != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mKM);
                this.mKF.setVisibility(8);
                if (this.bB == 2) {
                    this.mKL.setVisibility(0);
                }
            }
        } else if (this.mKF != null && this.mKL != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
            if (this.bB == 2) {
                this.mKF.setVisibility(0);
            }
            this.mKL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dDZ().c(roomToast.mToastContent);
            if (this.mLr == null) {
                aS();
            }
            if (this.mLs != null) {
                this.mLs.setText(roomToast.mToastContent);
            }
            if (!this.mLr.isShowing()) {
                if (this.mLi != null) {
                    this.mLr.showAtLocation(this.mLi, 85, 0, this.mQi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mLr != null) {
                                a.this.mLr.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mLr.dismiss();
        }
    }

    private void aS() {
        if (this.mLr == null) {
            View inflate = LayoutInflater.from(this.mQy).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mLs = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mLr = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 160.0f), -2);
            this.mLr.setFocusable(false);
            this.mLr.setOutsideTouchable(false);
            this.mLr.setAnimationStyle(a.j.gift_toast_style);
            this.mLr.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.mQX != null && this.mQX.isShowing()) {
            this.mQX.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
        if (this.mRv == null) {
            dFH();
        }
        if (!this.mRv.isShowing()) {
            this.mRv.showAtLocation(view, 83, i, i2);
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mQx.dEL().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mRv.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.mRy != null) {
            if (h.isEmpty(this.mRz)) {
                if (((VideoPlayer) this.mQy).q) {
                    this.mRy.bV(this.mQx != null ? this.mQx.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mRy.bV(this.mQx != null ? this.mQx.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mQy).q && this.mRz.size() == 2 && this.mRz.contains("4") && this.mRz.contains("2")) {
                this.mRy.bV(this.mQx != null ? this.mQx.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mRz.size() > 1 || !((VideoPlayer) this.mQy).q) {
                this.mRy.bV(this.mQx != null ? this.mQx.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mRz.get(0))) {
                this.mRy.bV(this.mQx != null ? this.mQx.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mRz.get(0))) {
                this.mRy.bV(this.mQx != null ? this.mQx.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mRz.get(0))) {
                this.mRy.bV(this.mQx != null ? this.mQx.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
        if (this.mQX == null) {
            al();
            this.mQX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mQX.isShowing() && this.bB == 2) {
            this.mQX.showAtLocation(view, 83, i, this.mQy.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mQx.dEL().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mQX.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mQr != null) {
            this.mQr.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                g.c(this.mQy, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mMN.getPlayState() == 4) {
                        e(true);
                        if (this.mQx.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mQx.a(false);
                        ((VideoPlayer) this.mQy).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mMN.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mMN.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                g.c(this.mQy, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mQx.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mQy).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                    this.ai = false;
                    wC(true);
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
        if (this.mRl != null) {
            if (z) {
                this.mRl.setVisibility(0);
            }
            this.mRl.dQW();
            if (!z) {
                this.mRl.setVisibility(8);
            }
        }
        g.c(this.mQy, this.mQy.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mKz != null) {
                this.mKz.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mQs != null) {
                this.mQs.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mKz != null) {
            this.mKz.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mQs != null) {
                    this.mQs.setVisibility(8);
                }
            }
        }
    }

    private void dFg() {
        this.e = false;
        k(true, false, true);
    }

    private void dFh() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mKl[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            aM();
            a(this.mQx != null ? this.mQx.mJI.get("1") : null);
            if (i2 == 2) {
                k();
                av(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.mQy, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            av(false, i3);
            v(false);
            b(false);
            if (this.mQX != null && this.mQX.isShowing()) {
                this.mQX.dismiss();
            }
            if (i2 == 99) {
                if (this.mKm != null && this.mKm[i] != null && (this.mKm[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mKm[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mQy, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mQy, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mQy, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mQy, "房间信息页_num", null, new Object[0]);
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
        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mQz != null) {
            if (this.mKL != null && this.mKL.getVisibility() == 0) {
                u(false);
            }
            if (this.mQs != null && this.mQs.getVisibility() == 0) {
                this.f = true;
            }
            au(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mKo != null) {
            this.mKo.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mKo != null) {
            this.mKo.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mKo != null) {
            this.mKo.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mKo != null) {
            this.mKo.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mLi != null) {
            int size = iconConfig.configs.size();
            this.mLi.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mQy).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mLi, false);
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
                this.mLi.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mQx != null ? this.mQx.mJI : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mKo != null) {
            this.mKo.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mLf != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mLf.yE(a.c.kas_white);
            } else if (this.bB == 2) {
                this.mLf.bV(str, a.c.kas_white);
                if (this.mLg != null) {
                    this.mLg.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mLf.yE(a.c.kas_white);
                if (this.mLg != null) {
                    this.mLg.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mLg != null) {
                    this.mLg.setTextColor(a);
                    this.mLg.setTabTextSelectColor(a2);
                    this.mLg.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mKH != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mKH.yE(a.e.ic_hotwords_black_n);
            } else {
                this.mKH.bV(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mKG != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dFU().a(str, this.mKG, a.e.player_skin_input);
            } else {
                this.mKG.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mKK != null) {
                this.mKK.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void a(int i) {
        if (this.mKo != null) {
            this.mKo.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void D() {
        if (this.mQy instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dEr = ((VideoPlayer) this.mQy).dEr();
            if (this.mRp == null) {
                this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mRp.setVisibility(0);
            this.mRp.a(2, dEr);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mKo != null) {
            this.mKo.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mKo != null) {
            this.mKo.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(long j) {
        if (this.mKo != null) {
            this.mKo.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0807a
    public void c(int i) {
        if (this.mKo != null) {
            this.mKo.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mKo != null && this.mQx != null) {
            this.mKo.b(this.mQx.mJG);
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
    public class C0800a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0800a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mKl.length) {
                return null;
            }
            switch (a.this.mKl[i]) {
                case 1:
                    if (a.this.mKn == null) {
                        a.this.mKn = com.kascend.chushou.view.user.a.a(2, null, a.this.mQx.a, false, a.this.mQx.h, false);
                    }
                    a.this.mKm[i] = a.this.mKn;
                    return a.this.mKn;
                case 2:
                    if (a.this.mKo == null) {
                        a aVar = a.this;
                        if (a.this.mJZ != null && a.this.mJZ.mMO != null) {
                            z = a.this.mJZ.mMO.mInPKMode;
                        }
                        aVar.mKo = com.kascend.chushou.player.ui.a.wD(z);
                    }
                    a.this.mKm[i] = a.this.mKo;
                    return a.this.mKo;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mQx != null && a.this.mQx.dEL() != null && !h.isEmpty(a.this.mLn)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mLn.get(i).url);
                        h5Options.a = a.this.mLn.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mKm[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.IV(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.mKl.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int lI(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int IW(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String IX(int i) {
            return a.this.IV(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int IY(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b IZ(int i) {
            int dimensionPixelSize = a.this.mQy.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Ch(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.Kz(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mKf <= 3000) {
            g.Kz(a.i.str_too_fast);
            return false;
        } else {
            dFk();
            if (!com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a(((VideoPlayer) this.mQy).dEl().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mKf = System.currentTimeMillis();
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                a(this.mQx.dEL().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mQx.h);
            }
            g(this.b);
            if (!z && this.mKM != null) {
                this.mKM.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dFk();
            if (com.kascend.chushou.d.e.c(this.mQy, null) && LoginManager.Instance().getUserInfo() != null && this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                a(this.mQx.dEL().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mKM != null) {
                this.mKM.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mKo != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mQx.dEL().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mQx.dEL().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mQy).mHU;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Sr(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mKo.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mKo.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.mKo != null) {
            this.mKo.e();
        }
        if (this.mLl != null && this.mLl.isShown()) {
            this.mLl.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dFi() {
        super.dFi();
        if (this.mQy instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mQx != null) {
            this.mQx.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mLj);
        if (this.mQy != null) {
            if (this.mLj || "10004".equals(((VideoPlayer) this.mQy).t)) {
                this.mLj = true;
                if (this.mQx != null) {
                    this.mQx.f = null;
                    if (this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                        this.mQx.dEL().mRoominfo.mGameId = null;
                    }
                }
                aP();
                return;
            }
            this.mLj = true;
            if (this.mQy != null) {
                ((VideoPlayer) this.mQy).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mLj = false;
        if (this.mKx != null) {
            this.mKx.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mLj = false;
        if (this.mKx != null) {
            this.mKx.setVisibility(8);
        }
        super.i(z);
    }

    private void dFj() {
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
        dFF().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mRl != null) {
            this.mRl.setVisibility(0);
        }
        if (this.mJV != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mJV.d();
        }
        if (this.mKF != null) {
            this.mKF.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mKu.setVisibility(0);
            this.mKu.setOnClickListener(this);
        } else {
            this.mKu.setVisibility(8);
        }
        this.mKz.setVisibility(0);
        this.mKv.setVisibility(0);
        this.mQp.setVisibility(0);
        if (this.p) {
            this.mQq.setVisibility(0);
        } else {
            this.mQq.setVisibility(8);
        }
        aX();
        av(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mRp != null && this.mRp.a(i, keyEvent)) {
                return true;
            }
            if (this.mLp != null && this.mLp.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mLq != null && this.mLq.onKeyDown(i, keyEvent)) || aD()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mLF != null && this.mLF.getVisibility() == 0 && b(motionEvent, this.mLF)) {
                this.mLF.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.mLE);
                return true;
            } else if (this.cw && this.mLF != null && this.mLF.getVisibility() == 8 && f(this.mRd.b, motionEvent)) {
                dFf();
                return true;
            } else if (this.mLp != null && this.mLp.b() && f(this.mLp, motionEvent)) {
                this.mLp.a();
                return true;
            } else if (this.mLq != null && this.mLq.b() && f(this.mLq, motionEvent)) {
                this.mLq.a();
                return true;
            } else if (b(motionEvent, this.mKL)) {
                return dFk();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dFk() {
        boolean z;
        b(this.cF, 10);
        boolean z2 = false;
        if (this.mLa != null && this.mLa.getVisibility() == 0) {
            this.mLa.setVisibility(8);
            this.mLb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mLc) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
            this.mLb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mKL == null || this.mKL.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mKZ) {
                bg();
            }
            this.mKL.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mKF != null && a.this.bB == 2) {
                        a.this.mKF.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean aD() {
        if (dFk()) {
            return true;
        }
        if (this.mQX == null || !this.mQX.isShowing()) {
            return dFf() || dFe() || dsM();
        }
        this.mQX.dismiss();
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
        this.mKF.setVisibility(8);
        this.mKL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(boolean z, boolean z2) {
        if (this.mKF != null) {
            if (z) {
                if (this.mKF.getVisibility() != 0) {
                    this.mKF.setVisibility(0);
                    this.mKF.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_bottom_anim));
                }
            } else if (this.mKF.getVisibility() != 4) {
                this.mKF.setVisibility(4);
                this.mKF.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mKx != null) {
            this.mKx.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dFl() {
        return this.mLu;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dFE()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mQx != null) {
                        this.mQx.f = null;
                        this.mQx.dEL().mRoominfo.mGameId = null;
                    }
                    aP();
                    return;
                }
                g.Kz(a.i.str_getvideosource_failed);
            }
            wC(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mQx != null && this.mQx.dEM() != null) {
            a(this.mQx.dEM());
        }
        this.p = false;
        if (this.mQx == null || this.mQx.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mQx.f.size()) {
                if (!"2".equals(this.mQx.f.get(i2).mType)) {
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
        if (this.mKo != null) {
            this.mKo.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dFE()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mKA != null && this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                this.mKA.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mQx.dEL().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dFE() && !this.cB && (c = c(1, -1)) >= 0 && c < this.mLn.size() && this.mLh != null) {
            this.mLh.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dFE() && !this.cB) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mQy, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dEs = ((VideoPlayer) this.mQy).dEs();
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(2, dEs);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dEt = ((VideoPlayer) this.mQy).dEt();
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(2, dEt);
            } else if (bVar.a == 9) {
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mLa != null) {
            this.mLa.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dFE() && !this.cB) {
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
        if (!dFE() && this.mQx != null) {
            String str = this.mQx.a;
            RoomInfo dEO = this.mQx.dEO();
            if (dEO != null && mVar.a(dEO.mCreatorUID, str)) {
                dEO.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dFE()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mKM != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mKM);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nm() {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
            if (this.mLk == null) {
                this.mLk = new f(getActivity());
            }
            this.mLk.a(this.mQx.dEL().mRoominfo);
            if (!this.mLk.isShowing()) {
                this.mLk.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mKo != null) {
            this.mKo.d();
        }
    }

    private void dt(View view) {
        this.mKB = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mKC = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mKC.setText(new tv.chushou.zues.widget.a.c().J(this.mQy, a.e.videoplayer_4g_video).append("  ").append(this.mQy.getString(a.i.videoplayer_4g_video)));
        this.mKD = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mKD.setText(new tv.chushou.zues.widget.a.c().J(this.mQy, a.e.videoplayer_4g_audio).append("  ").append(this.mQy.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mKB.setVisibility(8);
                    ((VideoPlayer) a.this.mQy).c(a.this.mKE);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mKB.setVisibility(8);
                    ((VideoPlayer) a.this.mQy).d(a.this.mKE);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dDS().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mKC.setOnClickListener(onClickListener);
        this.mKD.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mQx != null && !h.isEmpty(this.mQx.f)) {
            f(this.mQx.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mKE = z;
            this.p = false;
            if (this.mQx != null && this.mQx.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mQx.f.size()) {
                        break;
                    } else if (!"2".equals(this.mQx.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mKB != null) {
                this.mKB.setVisibility(0);
                this.mKC.setVisibility(0);
                this.mKD.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mKB != null) {
            this.mKB.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mLx == null) {
                this.mLx = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dFE()) {
                            a.this.dFm();
                        }
                    }
                };
                if (this.mQz != null) {
                    this.mQz.e(this.mLx, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mLx != null && this.mQz != null) {
            this.mQz.P(this.mLx);
            this.mLx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFm() {
        if (LoginManager.Instance().islogined() && this.mKo != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mQy, "显示双击666_num", null, new Object[0]);
            if (this.mQx != null) {
                this.mQx.b(false);
            }
            d(false);
            this.mKo.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mQi != null) {
            if (this.mLq == null) {
                this.mLq = (InteractionView) ((ViewStub) this.mQi.findViewById(a.f.view_interaction)).inflate();
                this.mLq.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mLq.a();
                    }
                });
            }
            if (this.mLq != null) {
                this.mLq.b(configDetail);
                this.mLq.c();
                this.mLq.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dRJ()) {
                g.F(this.mQy, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mQy, null) && (this.mQy instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mQx != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mQy, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mQx != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mQy, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mQy, configDetail.mUrl, this.mQy.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mQy, null)) {
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
            dFf();
            return;
        }
        if (this.mQy.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mQx.dEL().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mQy != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mJZ == null) {
                this.mJZ = new com.kascend.chushou.player.e.a();
            }
            this.mJZ.b = str;
            this.mJZ.mMO.copy(pkNotifyInfo);
            if (this.mJZ.mMO.mAction == 6) {
                this.mJZ.mMO.mInPKMode = true;
                this.u = this.mJZ.mMO.mPkId;
            } else if (this.mJZ.mMO.mAction == 7 || (this.mJZ.mMO.mMode == 1 && this.mJZ.mMO.mAction == 5)) {
                this.mJZ.mMO.mInPKMode = true;
                this.u = this.mJZ.mMO.mPkId;
                if (dFn() != null) {
                    if (2 == this.bB && this.mLA != null) {
                        this.mLA.setVisibility(0);
                    }
                    dFn().b(this.mJZ.mMO, false);
                    dFn().a(this.mJZ.mMO.mMode, "1");
                    if (this.mJZ.mMO.mAction == 5 && this.mJZ.mMO.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mJZ.mMO.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mJZ.mMO.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mJZ.mMO.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dFn().a(this.mJZ.mMO);
                        if (this.mJZ.mMO.destinyInfo == null || this.mJZ.mMO.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dFn().a(parseInt, this.mJZ.mMO.mPkUpdateInfo.remainDuration, j, this.mJZ.mMO.mMode, i);
                    }
                    if (!h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.specialMomentList) && dFn() != null) {
                        dFn().a(this.mJZ.mMO, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Qx(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mJZ.mMO.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Qx(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.mJZ != null && this.mJZ.mMO != null) {
            if (this.mJZ.mMO.mInPKMode) {
                this.y.setText(this.mJZ.mMO.mPkUserNickname);
                this.mKb.setVisibility(0);
                if (this.mQo != null) {
                    this.mQo.setEnabled(false);
                }
                if (this.mQq != null) {
                    this.mQq.setEnabled(false);
                    return;
                }
                return;
            }
            this.mKb.setVisibility(8);
            if (this.mQo != null) {
                this.mQo.setEnabled(true);
            }
            if (this.mQq != null) {
                this.mQq.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dFn() {
        if (this.mQy == null || this.mQi == null || this.mLA == null) {
            return null;
        }
        if (this.mKa == null) {
            if (this.mLz == null) {
                this.mLz = ((ViewStub) this.mQi.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mKa = new com.kascend.chushou.player.e.b();
            this.mKa.a(this.mLA, this.mLz, (View) null, this.mQy, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dRp()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mQx != null) {
                        append.append(a.this.mQx.dEO().mRoomID);
                    }
                    if (a.this.mJZ != null && a.this.mJZ.mMO != null) {
                        append.append("&mode=").append(a.this.mJZ.mMO.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mQy, append.toString());
                }
            });
        }
        return this.mKa;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mKX != null && this.mQx != null && this.mQx.mJH != null) {
            this.mKX.setText(tv.chushou.zues.utils.b.Ky(this.mQx.mJH.count));
            this.mKX.setVisibility(0);
            if (this.mQx.mJH.count < 1) {
                bg();
            }
            if (this.mKP != null) {
                this.mKP.setText(this.mQx.mJH.primaryName);
            }
            if (this.mKQ != null) {
                this.mKQ.setText(this.mQx.mJH.desc);
            }
            dFo();
        }
    }

    public void dFo() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mKY * h.parseLong(this.mQx.mJH.point)));
        if (this.mKS != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mQy.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mQy, a.e.icon_coin_new);
            cVar.append(this.mQy.getString(a.i.str_buy_count_coin2));
            this.mKS.setText(cVar);
        }
    }

    private void bf() {
        if (com.kascend.chushou.d.e.c(this.mQy, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mKY);
        }
    }

    private void v(boolean z) {
        if (this.mQi != null && this.mLA != null) {
            if (z) {
                if (this.mJZ != null && this.mJZ.mMO != null && this.mJZ.mMO.mInPKMode) {
                    this.mLA.setVisibility(0);
                    return;
                }
                return;
            }
            this.mLA.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mQi != null && this.mKe != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.mKe.setVisibility(0);
                    return;
                }
                return;
            }
            this.mKe.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.mJZ != null && this.mJZ.mMO != null && this.mJZ.mMO.mInPKMode && this.mKb != null) {
                this.mKb.setVisibility(0);
            }
        } else if (this.mKb != null) {
            this.mKb.setVisibility(8);
        }
    }

    private void bg() {
        this.mKZ = false;
        this.mKW.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mQx != null && this.mQx.mJH != null) {
            if (this.mQx.mJH.count < 1) {
                this.mKX.setVisibility(8);
            } else {
                this.mKX.setVisibility(0);
                this.mKX.setSelected(false);
                this.mKX.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mKO.setVisibility(8);
        if (this.mKM != null) {
            this.mKM.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mKK != null) {
            this.mKK.performClick();
        }
    }

    public boolean dFp() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.mLL = true;
        if (this.mQi != null && com.kascend.chushou.b.dDS().d == 0) {
            this.mLv = tv.chushou.zues.utils.systemBar.b.gA(getActivity());
            if (!z) {
                View findViewById = this.mQi.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.mLv = tv.chushou.zues.utils.systemBar.b.gA(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.mLv);
            View findViewById2 = this.mQi.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.mLv);
            findViewById2.requestLayout();
        }
    }
}
