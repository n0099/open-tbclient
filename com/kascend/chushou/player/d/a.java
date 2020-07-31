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
/* loaded from: classes6.dex */
public class a extends d implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnTouchListener {
    private TextView nqA;
    private TextView nqB;
    private boolean nqC;
    private RelativeLayout nqD;
    private View nqE;
    private FrescoThumbnailView nqF;
    private AnimationSet nqG;
    private ImageView nqH;
    private TextView nqI;
    private RelativeLayout nqJ;
    private PastedEditText nqK;
    private TextView nqL;
    private LinearLayout nqM;
    private TextView nqN;
    private TextView nqO;
    private TextView nqP;
    private TextView nqQ;
    private TextView nqR;
    private TextView nqS;
    private TextView nqT;
    private ImageView nqU;
    private TextView nqV;
    private KPSwitchPanelLinearLayout nqY;
    private ImageView nqZ;
    private int[] nqj;
    private Fragment[] nqk;
    private ImageView nqo;
    private MarqueeTextView nqp;
    private MarqueeTextView nqq;
    private ImageView nqr;
    private ImageView nqs;
    private ImageButton nqt;
    public String nqu;
    private RecommendView nqv;
    private TextView nqy;
    private RelativeLayout nqz;
    private View nrA;
    private LivePKBarUserValue nrB;
    private String nrC;
    private TextView nrD;
    private ImageView nrE;
    private EditText nrF;
    private View nrG;
    private View nrH;
    private View nrI;
    private String nrL;
    private c nrb;
    private d.a nrc;
    private FrescoThumbnailView nrd;
    private PagerSlidingTabStrip nre;
    private KasViewPager nrf;
    private LinearLayout nrg;
    private f nri;
    private ViewMicPerson nrj;
    public ArrayList<RoomTab> nrl;
    private PopH5Menu nro;
    private InteractionView nrp;
    private int nrq;
    private PopupWindow nrr;
    private TextView nrs;
    private GiftAnimationLayout nrt;
    private com.kascend.chushou.player.b.a nru;
    private Runnable nry;
    private long nqd = 0;
    private com.kascend.chushou.view.user.a nql = null;
    private com.kascend.chushou.player.ui.a nqm = null;
    private int bB = -1;
    private int bC = 0;
    private View nqn = null;
    private View nqw = null;
    private ImageButton nqx = null;
    private int nqW = 1;
    private boolean nqX = false;
    private boolean nra = false;
    private boolean nrh = false;
    private boolean cx = false;
    private boolean nrk = false;
    private boolean nrm = false;
    private boolean nrn = true;
    private int nrv = 0;
    private int nrw = 0;
    private int nrx = -1;
    private final Rect nrz = new Rect();
    private boolean nrJ = false;
    private C0830a nrK = null;
    private boolean da = false;
    private boolean nrM = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqu = getArguments().getString("mCover");
        this.nrn = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nwg = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.nwg;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            c(view);
            dNn();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.nrm = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.nwZ != null) {
            this.nwZ.b();
        }
        if (this.nwv != null && (this.nwv instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwv).xB(true);
            ((VideoPlayer) this.nwv).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nrm = true;
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
        this.nqW = 1;
        this.nqX = false;
        U();
        if (this.nww != null) {
            this.nww.ch(null);
            this.nww = null;
        }
        if (this.nqv != null) {
            dNZ().removeAllViews();
            this.nqv = null;
        }
        this.c = null;
        this.npR = null;
        tv.chushou.zues.a.a.ci(this);
        this.nre = null;
        this.nrf = null;
        this.nqm = null;
        this.nql = null;
        if (this.nqk != null) {
            for (int i = 0; i < this.nqk.length; i++) {
                this.nqk[i] = null;
            }
        }
        this.nqk = null;
        if (this.nqK != null) {
            this.nqK.addTextChangedListener(null);
            this.nqK.setOnTouchListener(null);
            this.nqK.setOnEditorActionListener(null);
            this.nqK = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nwv, this.nrb);
        if (this.nwv != null && (this.nwv instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwv).dME();
        }
        this.nrc = null;
        this.nrb = null;
        if (this.nrj != null) {
            this.nrj.b();
            this.nrj = null;
        }
        if (this.nrr != null) {
            this.nrr.dismiss();
        }
        if (this.nru != null) {
            this.nru.a();
            this.nru = null;
            this.nrt = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.nrB = (LivePKBarUserValue) this.nwg.findViewById(a.f.live_pk_bar_user);
        this.nwo = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nrJ) {
            this.nrJ = true;
            if (this.nrH == null) {
                this.nrH = this.nwg.findViewById(a.f.vs_async_view);
                this.nrH = ((ViewStub) this.nrH).inflate();
            }
            if (this.nrI == null) {
                this.nrI = this.nwg.findViewById(a.f.vs_async_notification_view);
                this.nrI = ((ViewStub) this.nrI).inflate();
            }
            this.nqc = (VoiceInteractionView) this.nwg.findViewById(a.f.voiceInteractiveView);
            t();
            dz(this.nwg);
            ar();
            ((VideoPlayer) this.nwv).q();
            this.npX = new com.kascend.chushou.player.e.a();
        }
    }

    private void dz(View view) {
        this.nrd = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.nre = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.nrf = (KasViewPager) view.findViewById(a.f.vp_main);
        dNo();
        aI();
        aN();
        if (this.nwu != null) {
            I();
            a(this.nwu.npD, this.nwu.npG);
        }
        this.bb = 0;
        this.nxe = 0L;
        this.nxa = (RoundProgressBar) this.nwg.findViewById(a.f.roundProgressBar);
        this.nxb = (TextView) this.nwg.findViewById(a.f.tv_paonum);
        this.nxc = (FrescoThumbnailView) this.nwg.findViewById(a.f.iv_paoicon);
        this.nxj = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.nrh = false;
                if (a.this.bB == 2) {
                    a.this.ax(true, a.this.i());
                } else {
                    a.this.dNH();
                }
                a.this.b(a.this.nrq, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.nrh = true;
                if (a.this.bB == 2) {
                    a.this.ax(false, a.this.i());
                } else {
                    a.this.dNH();
                }
                if (a.this.nwZ != null) {
                    a.this.nwZ.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gE(a.this.nwv).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nwv)) - a.this.nwZ.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nwv, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nwv, 54.0f) * 2);
                    if (statusBarHeight < a.this.nrq) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.nxd = (PaoGuideView) this.nwg.findViewById(a.f.rlPaoGuideView);
        this.nrj = (ViewMicPerson) this.nwg.findViewById(a.f.rl_mic_person_view);
    }

    private void dNn() {
        this.nsQ = ((VideoPlayer) this.nwv).dMx();
        this.nwu = ((VideoPlayer) this.nwv).dMA();
        dA(this.nwg);
        this.nrv = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
        this.nrw = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (com.kascend.chushou.b.dMh().d == 0 && this.nrw > 0) {
            View findViewById = this.nwg.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nrw);
        }
        dNw();
        dNu();
        if (!this.nrn) {
            Q();
        }
        dNs();
        a();
        if (this.c == null) {
            this.npR = new d.a();
            this.c = new GestureDetector(this.nwv, this.npR);
        }
        this.npT = ((VideoPlayer) this.nwv).dMB();
        this.npT.a(this);
        if (this.nru != null) {
            this.nru.a();
            this.nru = null;
        }
        this.nrt = (GiftAnimationLayout) this.nwg.findViewById(a.f.ll_gift_animation);
        this.nrt.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.nwu != null) {
            this.nru = new com.kascend.chushou.player.b.a(this.nwv.getApplicationContext(), this.nrt);
            this.nru.a(this.nwu);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.nwg.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nwp = (PlayerErrorView) this.nwg.findViewById(a.f.view_net_error_msg);
        this.nwp.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dNq();
        dNA();
        if (this.nwu.dNb() != null) {
            a(this.nwu.dNb());
        }
        FullRoomInfo dNa = this.nwu.dNa();
        if (dNa != null) {
            dNC();
            if (i()) {
                this.ak = false;
                m(true);
                this.nww.LT(8);
            }
            this.nqy.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dNa.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.nqn.setVisibility(0);
        this.ak = false;
        m(true);
        this.nww.LT(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nwv).n();
        if (this.nwu != null && !h.isEmpty(this.nwu.w)) {
            b(this.nwu.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dML;
        dNo();
        k();
        FullRoomInfo dNa = this.nwu.dNa();
        if (dNa != null) {
            if (dNa.mRoominfo != null) {
                this.nqy.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dNa.mRoominfo.mOnlineCount)));
                this.nrC = dNa.mRoominfo.mRoomID;
            }
            dNC();
            if (!h.isEmpty(dNa.mRoomToastList)) {
                Iterator<RoomToast> it = dNa.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dMo().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.nwu != null && this.nwu.l()) {
                d(true);
            }
            if (this.nwv != null && (this.nwv instanceof VideoPlayer) && (dML = ((VideoPlayer) this.nwv).dML()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dML.nsR, dML.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.nrg);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dNo() {
        boolean z = true;
        if (this.nwu == null || this.nwu.dNa() == null || this.nwu.dNa().mRoominfo == null || h.isEmpty(this.nwu.dNa().mRoomTabs)) {
            this.nrk = false;
            this.nqk = new Fragment[2];
            this.nqj = new int[2];
            this.nqj[0] = 2;
            this.nqj[1] = 1;
            return;
        }
        this.nrk = true;
        this.nrl = new ArrayList<>();
        Iterator<RoomTab> it = this.nwu.dNa().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.nrl.add(next);
            }
        }
        if (this.nrl.size() >= 2 && this.nqj != null && this.nqj.length >= 2 && this.nrl.get(0).type == this.nqj[0] && this.nrl.get(1).type == this.nqj[1]) {
            z = false;
        }
        this.nqk = new Fragment[this.nrl.size()];
        this.nqj = new int[this.nrl.size()];
        for (int i = 0; i < this.nrl.size(); i++) {
            this.nqj[i] = this.nrl.get(i).type;
        }
        if (z) {
            this.nrK = new C0830a(getChildFragmentManager());
            this.nrf.setAdapter(this.nrK);
        }
    }

    private void aI() {
        this.nqJ = (RelativeLayout) this.nwg.findViewById(a.f.rl_edit_bar);
        this.nqF = (FrescoThumbnailView) this.nwg.findViewById(a.f.btn_hotword);
        this.nqF.zR(a.e.ic_hotwords_black_n);
        this.nqF.setOnClickListener(this);
        this.nqH = (ImageView) this.nwg.findViewById(a.f.iv_task_badge);
        this.nqG = (AnimationSet) AnimationUtils.loadAnimation(this.nwv, a.C0824a.anim_hotword);
        this.nqG.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dMo().c) {
                    a.this.nqF.clearAnimation();
                    a.this.nqF.startAnimation(a.this.nqG);
                }
            }
        });
        if (com.kascend.chushou.d.h.dMo().c) {
            this.nqF.startAnimation(this.nqG);
            this.nqH.setVisibility(0);
        }
        this.nqI = (TextView) this.nwg.findViewById(a.f.tv_bottom_input);
        this.nqI.setOnClickListener(this);
        this.nxt = (FrescoThumbnailView) this.nwg.findViewById(a.f.ll_btn_set);
        this.nxt.setOnClickListener(this);
        this.nrg = (LinearLayout) this.nwg.findViewById(a.f.ll_bottom_all_button);
        this.nqD = (RelativeLayout) this.nwg.findViewById(a.f.rl_bottom_input);
        this.nqE = this.nwg.findViewById(a.f.ll_bottom_input);
        this.nqD.setVisibility(8);
        this.nqK = (PastedEditText) this.nwg.findViewById(a.f.et_bottom_input);
        this.nqK.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nqL.setEnabled(editable.length() > 0);
            }
        });
        this.nqK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nqL);
                    return true;
                }
                return true;
            }
        });
        this.nqK.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.nqK);
                }
                return false;
            }
        });
        this.nqZ = (ImageView) this.nwg.findViewById(a.f.iv_btn_emoji);
        this.nqZ.setVisibility(8);
        this.nqL = (TextView) this.nwg.findViewById(a.f.tv_btn_send);
        this.nqL.setOnClickListener(this);
        this.nqY = (KPSwitchPanelLinearLayout) this.nwg.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dMh().d == 0) {
            this.nqY.setUseStatusBar(true);
        }
        this.nqM = (LinearLayout) this.nwg.findViewById(a.f.head_trumpet);
        this.nqM.setVisibility(8);
        this.nqM.setOnClickListener(this);
        this.nqN = (TextView) this.nwg.findViewById(a.f.tv_primary_name);
        this.nqO = (TextView) this.nwg.findViewById(a.f.tv_primary_desc);
        this.nqR = (TextView) this.nwg.findViewById(a.f.tv_cut_count);
        this.nqR.setOnClickListener(this);
        this.nqT = (TextView) this.nwg.findViewById(a.f.tv_head_count);
        this.nqT.setText(this.nqW + "");
        this.nqS = (TextView) this.nwg.findViewById(a.f.tv_plus_count);
        this.nqS.setOnClickListener(this);
        this.nqQ = (TextView) this.nwg.findViewById(a.f.tv_buy_count_coin);
        this.nqP = (TextView) this.nwg.findViewById(a.f.tv_buy_head);
        this.nqP.setOnClickListener(this);
        this.nqU = (ImageView) this.nwg.findViewById(a.f.iv_trumpet_select);
        this.nqU.setOnClickListener(this);
        this.nqV = (TextView) this.nwg.findViewById(a.f.tv_trumpet_have_count);
        this.nqX = false;
        this.nqU.setBackgroundResource(a.e.ic_trumpet_n);
        this.nqV.setVisibility(8);
        aK();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nqY, this.nqZ, this.nqK, new a.InterfaceC0960a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0960a
            public void xC(boolean z) {
                if (a.this.nqZ != null) {
                    if (!z) {
                        a.this.nqZ.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dMh().d == 0) {
                        a.this.nqY.setDirectVisibility(0);
                    }
                    a.this.nqZ.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nrc = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void xD(boolean z) {
                if (a.this.nrM) {
                    a.this.nrM = false;
                    return;
                }
                a.this.nra = z;
                if (z) {
                    a.this.nqZ.setImageResource(a.e.cs_emoji_normal);
                    a.this.dNp();
                    return;
                }
                if (a.this.nrG != null && a.this.nrG.getVisibility() == 0) {
                    a.this.nrG.setVisibility(8);
                }
                if (a.this.nrh) {
                    a.this.nwZ.setVisibility(0);
                }
                if (a.this.nwv != null && (a.this.nwv instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nwv).xB(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.nrb = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nqY, this.nrc, ((VideoPlayer) this.nwv).dMF());
        ((VideoPlayer) this.nwv).h(((VideoPlayer) this.nwv).dMF());
        this.nrG = this.nwg.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nrD = (TextView) this.nwg.findViewById(a.f.btn_room_search);
        this.nrE = (ImageView) this.nwg.findViewById(a.f.iv_room_emoji_delete);
        this.nrF = (EditText) this.nwg.findViewById(a.f.et_room_emoji_search);
        this.nrF.setImeOptions(3);
        this.nrF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.nrD);
                    return true;
                }
                return false;
            }
        });
        this.nrF.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nrD.setEnabled(editable.length() > 0);
                a.this.nrE.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.nwZ.setEmojiSearchText(editable.toString());
            }
        });
        this.nrD.setOnClickListener(this);
        this.nrE.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void av(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dK(this.nrF);
            this.nrG.setVisibility(0);
            this.nrF.requestFocus();
        } else {
            this.nrG.setVisibility(8);
        }
        if (z2) {
            this.nrF.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNp() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gE(this.nwv).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv)) - tv.chushou.zues.widget.kpswitch.b.d.gQ(this.nwv)) - tv.chushou.zues.utils.a.dip2px(this.nwv, 14.0f)) - this.nwv.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nwv, 54.0f) * 2);
        if (statusBarHeight < this.nrq) {
            b(statusBarHeight, 10);
        }
    }

    private void aK() {
    }

    private void dNq() {
        this.nww = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aw(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.nwg.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nwv.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nww.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nww.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nww.B(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nww);
                            break;
                        case 12:
                            a.this.b(a.this.nww);
                            break;
                        case 17:
                            a.this.as();
                            break;
                        case 18:
                            a.this.dAO();
                            break;
                        case 19:
                            a.this.nwt.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dNr() {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nrl)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nrl.size()) {
                    if (!h.isEmpty(this.nrl.get(i2).notifyIcon)) {
                        this.nre.bN(i2, this.nrl.get(i2).notifyIcon);
                        this.nre.Ms(i2);
                    } else if (this.nrl.get(i2).notify == 1) {
                        this.nre.Mr(i2);
                        this.nre.Mq(i2);
                    } else {
                        this.nre.Mq(i2);
                        this.nre.Ms(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nrl)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.nrl.size()) {
                    if (this.nrl.get(i4).type == i) {
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
    public String Kz(int i) {
        if (this.nwu == null || this.nwu.dNa() == null || this.nwu.dNa().mRoominfo == null || h.isEmpty(this.nrl)) {
            if (i == 1) {
                return this.nwv.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nwv.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.nrl.size()) {
            return this.nrl.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nrl) && i < this.nrl.size()) {
            this.nrl.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nrl) && i < this.nrl.size()) {
            this.nrl.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.nrf != null && this.nre != null && this.nqj != null) {
            this.nqm = null;
            if (this.nqk != null) {
                for (int i = 0; i < this.nqk.length; i++) {
                    this.nqk[i] = null;
                }
            }
            if (this.nrK == null) {
                this.nrK = new C0830a(getChildFragmentManager());
                this.nrf.setAdapter(this.nrK);
            } else {
                this.nrK.notifyDataSetChanged();
            }
            this.nrf.setOffscreenPageLimit(this.nqj.length);
            this.nre.c(this.nrf);
            this.nre.setOnPageChangeListener(this);
            this.nre.notifyDataSetChanged();
            this.nre.setVisibility(0);
            this.nrf.setVisibility(0);
            if (!this.nrk) {
                this.bB = 2;
                this.nrf.setCurrentItem(c(2, 0));
                this.nqD.setVisibility(0);
            } else {
                if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                    if (!h.isEmpty(this.nwu.dNa().mRoominfo.mGameName)) {
                        this.nqq.setText(this.nwu.dNa().mRoominfo.mGameName);
                    } else {
                        this.nqq.setText(this.nwv.getString(a.i.no_online_game_name));
                    }
                    this.nqp.setText(this.nwu.dNa().mRoominfo.mName);
                } else {
                    this.nqq.setText(this.nwv.getString(a.i.no_online_game_name));
                }
                dNr();
                if (i()) {
                    aU();
                    if (this.nrf != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.nrf.setCurrentItem(c);
                        this.nre.setSelectItem(c);
                    }
                } else if (this.nrf != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.nrf.setCurrentItem(c2);
                    this.nre.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dNs() {
        this.N = new SurfaceView(this.nwv);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dNZ().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dNt() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nwv).s();
        dAT();
        az();
        dNm();
        dNZ().setBackgroundResource(a.e.room_not_online);
        if (this.nqv == null) {
            this.nqv = new RecommendView(this.nwv);
            dNZ().addView(this.nqv);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nwv);
            this.nqv.setLayoutParams(layoutParams);
        }
        if (this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nwu.dNa().mRoominfo.mRoomID)) {
            this.nqv.a(this.nwu.dNa().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.nwv != null && a.this.dNZ() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nwv);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.mVy);
                        if (a.this.dNZ().getChildCount() >= 2) {
                            a.this.dNZ().addView(frescoThumbnailView, 0);
                        }
                        a.this.dNZ().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dZV(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nxh != null) {
            this.nxh.dZq();
            this.nxh.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.nwZ != null) {
            this.nwZ.e();
        }
        m(false);
        a(false, false);
        if (this.npT != null) {
            this.npT.d();
        }
    }

    private void dNu() {
        int i = 0;
        this.nqn = this.nwg.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dMh().d == 0 && this.nrv > 0) {
            View findViewById = this.nwg.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.nrv;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nqo = (ImageView) this.nqn.findViewById(a.f.back_icon);
        this.nqo.setOnClickListener(this);
        this.nqp = (MarqueeTextView) this.nqn.findViewById(a.f.tv_title);
        this.nqq = (MarqueeTextView) this.nqn.findViewById(a.f.tv_Type);
        this.nqs = (ImageView) this.nwg.findViewById(a.f.btn_setting);
        this.nqw = this.nwg.findViewById(a.f.bottomview);
        if (this.nwm == null) {
            this.nwm = (ImageButton) this.nqw.findViewById(a.f.btn_barrage);
            this.nwm.setOnClickListener(this);
            if (this.nwu != null) {
                if (com.kascend.chushou.d.h.dMo().n()) {
                    this.nwm.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nwm.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.nwn = (ImageButton) this.nqw.findViewById(a.f.btn_audio);
        this.nwn.setOnClickListener(this);
        if (this.nwu != null && this.nwu.d) {
            this.nwn.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.nwn.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.nwu != null && this.nwu.f != null) {
            while (true) {
                if (i >= this.nwu.f.size()) {
                    break;
                } else if (!"2".equals(this.nwu.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nqx = (ImageButton) this.nqw.findViewById(a.f.playbutton);
        this.nqx.setOnTouchListener(this);
        this.nqt = (ImageButton) this.nqw.findViewById(a.f.btn_refresh);
        this.nqt.setOnClickListener(this);
        this.nqy = (TextView) this.nqw.findViewById(a.f.tv_online_count);
        if (this.nwl == null) {
            this.nwl = (ImageButton) this.nqw.findViewById(a.f.btn_screenChange);
            this.nwl.setOnClickListener(this);
        }
        if (this.nqr == null) {
            this.nqr = (ImageView) this.nqn.findViewById(a.f.report_icon);
            this.nqr.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dy(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nqm != null) {
                        this.nqm.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                        this.nwu.dNa().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nwu.dNa().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.nwu.dNa().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.nwu.dNa().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.nwu.dNa().mRoominfo.mCreatorUID);
                            }
                        } else if (this.nwu.dNa().mMicStatus.onMic) {
                            this.nwu.dNa().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nwu.dNa().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.nwu.dNa().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.nwu.dNa().mMicStatus != null && !h.isEmpty(this.nwu.dNa().mMicStatus.micRoomId) && !this.nwu.dNa().mMicStatus.micRoomId.equals("0")) {
                                this.nrL = this.nwu.dNa().mMicStatus.micRoomId;
                            }
                            if (this.nqm != null) {
                                this.nqm.a(this.nwu.dNa().mMicStatus, this.nwu.dNa().mFanItems, str, z2);
                            }
                            if (this.nrj != null && this.nrj.getVisibility() == 0) {
                                this.nrj.a(this.nwu.dNa().mFanItems, this.nwu.dNa().mMicStatus, str, z2, this.nwu.dNa().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nqm != null) {
                                this.nqm.e();
                            }
                            if (this.nrj != null && this.nrj.isShown()) {
                                this.nrj.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nqm != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nqm.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nqm.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.nrx != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.nrx = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.npX != null && this.npX.nsR != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.npX.nsR.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.npX.nsR.mInPKMode = true;
                                    this.npX.nsR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npX.nsR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npX.nsR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npX.nsR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npX.nsR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npX.nsR.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.npX.nsR.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.npX.nsR.mMode = pkNotifyInfo.mMode;
                                    this.npX.nsR.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dNJ() != null) {
                                        dNJ().g(true, this.npX.nsR.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dMo().a) {
                                        if (!com.kascend.chushou.b.dMh().e) {
                                            com.kascend.chushou.b.dMh().e = true;
                                            g.F(this.nwv, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dMo().a(this.nwv, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.nrB != null) {
                                        this.nrB.setVisibility(0);
                                    }
                                    this.npX.nsR.mAction = 7;
                                    this.npX.nsR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npX.nsR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npX.nsR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npX.nsR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npX.nsR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npX.nsR.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dNJ() != null) {
                                        dNJ().g(false, 0L);
                                        dNJ().b(this.npX.nsR, true);
                                        dNJ().a(this.npX.nsR.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.RW(this.nrC);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.npX.nsR.mInPKMode = false;
                                    this.npX.nsR.mAction = 2;
                                    bd();
                                    if (dNJ() != null) {
                                        dNJ().c();
                                    }
                                    if (com.kascend.chushou.d.h.dMo().a) {
                                        if (!com.kascend.chushou.b.dMh().e) {
                                            com.kascend.chushou.b.dMh().e = true;
                                            g.F(this.nwv, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dMo().a(this.nwv, false);
                                        ak();
                                    }
                                    this.npX.b = null;
                                    this.npX.nsR = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.RW(this.nrC);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.npX.nsR.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.npX.nsR.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.npX.nsR.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nwu.dNa().mRoominfo.mRoomID) && this.nwu.dNa().mRoominfo.mRoomID.equals(this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dNJ() != null) {
                                        dNJ().a(this.npX.nsR, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.npX.nsR.copyUpdate(pkNotifyInfo);
                                    if (dNJ() != null) {
                                        dNJ().a(this.npX.nsR);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.npX.nsR.copyStop(pkNotifyInfo);
                                        if (dNJ() != null) {
                                            dNJ().B(this.npX.nsR.mMaxFreeDuration, this.npX.nsR.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.npX.nsR.copyResult(pkNotifyInfo);
                                    if (!this.nrm && dNJ() != null) {
                                        int i5 = 1;
                                        if (this.npX.nsR.destinyInfo != null && this.npX.nsR.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dNJ().a(h.parseInt(this.npX.nsR.mResult), h.parseLong(this.npX.nsR.mvpUid), this.npX.nsR.mvpAvatar, this.npX.nsR.mvpNickname, this.npX.nsR.mMaxFreeDuration, this.npX.nsR.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nqm != null) {
                if (LoginManager.Instance().islogined() && this.nwu != null && this.nwu.l()) {
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
                if (this.nwu == null || this.nwu.dNa() == null || this.nwu.dNa().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.nwu.dNa().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dMo().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dMo().b().equals(next2.mUserID)) {
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
                this.nqm.a(arrayList, true, false);
                this.nqm.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nqj != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nqj.length) {
                    break;
                }
                if (this.nqj[i2] == 99 && this.nqk != null && this.nqk[i2] != null && (this.nqk[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nqk[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.nrl.size() && this.nre != null) {
                if (i == 0) {
                    this.nre.setTagText(i2, new StringBuilder(this.nrl.get(i2).name).toString());
                    return;
                } else {
                    this.nre.setTagText(i2, this.nrl.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.nwm != null) {
            if (z) {
                this.nwm.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nwm.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dNv() {
        if (this.nwg == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nwg.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
        this.ar = Math.min(gE.x, gE.y);
        this.aq = (this.ar * this.nwv.getResources().getInteger(a.g.h_thumb_height_def)) / this.nwv.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dNZ().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nwo.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nrq = this.aq + this.nwv.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nwv, 54.0f);
        b(this.nrq, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dNw() {
        Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
        this.ar = Math.min(gE.x, gE.y);
        this.aq = (this.ar * this.nwv.getResources().getInteger(a.g.h_thumb_height_def)) / this.nwv.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dNZ().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nwo.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nrq = this.aq + this.nwv.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nwv, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.nrq, 10);
        k();
        if (!h.isEmpty(this.nqu)) {
            File af = tv.chushou.zues.widget.fresco.a.af(Uri.parse(this.nqu));
            if (af != null && af.exists()) {
                this.nwo.setImageURI(Uri.fromFile(af));
                this.nwo.setVisibility(0);
                return;
            }
            this.nwo.setVisibility(8);
            return;
        }
        this.nwo.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aw(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nqr != null) {
            this.nqr.setVisibility(z ? 0 : 4);
        }
        if (this.nqs != null) {
            this.nqs.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aw(boolean z, boolean z2) {
        return k(z, z2, this.f);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.nww != null) {
            this.nww.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nwv).f(true);
            if (!z3) {
                if (this.nqw.getVisibility() != 0 && z2) {
                    this.nqw.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.nwn.setVisibility(0);
                } else {
                    this.nwn.setVisibility(8);
                }
                this.nqw.setVisibility(0);
            }
            PlayUrl dNb = this.nwu.dNb();
            if (dNb != null && "2".equals(dNb.mType)) {
                if (this.nwl != null) {
                    this.nwl.setVisibility(8);
                }
            } else if (this.nwl != null) {
                this.nwl.setVisibility(0);
            }
            if (this.nqn.getVisibility() != 0 && z2) {
                this.nqn.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_top_anim));
            }
            t(!z3);
            this.nqn.setVisibility(0);
            w(true);
            if (this.nww != null) {
                this.nww.B(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nwv).f(false);
            if (this.nwM != null) {
                this.nwM.dismiss();
            }
            if (this.nwN != null) {
                this.nwN.dismiss();
            }
            if (this.nqw.getVisibility() != 8 && z2) {
                this.nqw.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_bottom_anim));
            }
            this.nqw.setVisibility(8);
            if (this.nqn.getVisibility() != 8 && z2) {
                this.nqn.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_top_anim));
            }
            this.nqn.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dAT() {
        if (this.nxd == null || !this.nxd.isShown()) {
            return false;
        }
        this.nxd.d();
        return true;
    }

    public boolean az() {
        if (this.nrj == null || !this.nrj.isShown()) {
            return false;
        }
        this.nrj.a();
        return true;
    }

    public boolean dNm() {
        if (this.nro == null || !this.nro.b()) {
            return false;
        }
        this.nro.a();
        return true;
    }

    public boolean dNx() {
        if (this.nrh && this.nwZ != null) {
            if (this.nwZ != null) {
                this.nwZ.e();
            }
            if (this.nrF != null) {
                this.nrF.setText("");
            }
            if (this.bB == 2) {
                ax(true, i());
                return true;
            }
            dNH();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nwg != null) {
            if (this.nro == null) {
                this.nro = (PopH5Menu) ((ViewStub) this.nwg.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.nro.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.nro.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            p(view, 0, this.nqn.getHeight() + this.nqn.getTop());
        } else if (id == a.f.btn_barrage) {
            q(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nwv, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                g.c(this.nwv, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.nwu.a(false);
                a(false, false);
                ((VideoPlayer) this.nwv).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.nwv, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.npX == null || this.npX.nsR == null || !this.npX.nsR.mInPKMode) {
                ((VideoPlayer) this.nwv).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nqX) {
                f(this.nqK.getText().toString());
            } else {
                a(this.nqK.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dMo().c) {
                com.kascend.chushou.d.h.dMo().b(false);
                this.nqG.cancel();
                this.nqG.reset();
                this.nqF.clearAnimation();
                this.nqH.setVisibility(8);
            }
            o(view, 0, this.nwg.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nwv, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            n(view, x, this.nwg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.nwu.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nwv, null) && this.nwu != null && this.nwu.npF != null) {
                if (this.nqX) {
                    bg();
                    return;
                }
                if (this.nwu != null && this.nwu.npF != null && this.nwu.npF.count > 0) {
                    this.nqM.setVisibility(8);
                } else {
                    this.nqM.setVisibility(0);
                }
                this.nqX = true;
                this.nqU.setBackgroundResource(a.e.ic_trumpet_p);
                this.nqV.setVisibility(0);
                this.nqV.setSelected(true);
                this.nqV.setTextColor(Color.parseColor("#ff5959"));
                if (this.nqK != null) {
                    this.nqK.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nqW <= 9) {
                this.nqW++;
                this.nqT.setText(this.nqW + "");
            }
            dNK();
        } else if (id == a.f.tv_cut_count) {
            if (this.nqW > 1) {
                this.nqW--;
                this.nqT.setText(this.nqW + "");
            }
            dNK();
        } else if (id == a.f.tv_buy_head) {
            dNL();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.nrF.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.nrF.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.nrF);
                this.nwZ.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nqK != null && this.nqD != null && this.nqJ != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.nqK);
                this.nqD.setVisibility(8);
                if (this.bB == 2) {
                    this.nqJ.setVisibility(0);
                }
            }
        } else if (this.nqD != null && this.nqJ != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
            if (this.bB == 2) {
                this.nqD.setVisibility(0);
            }
            this.nqJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dMo().c(roomToast.mToastContent);
            if (this.nrr == null) {
                dNy();
            }
            if (this.nrs != null) {
                this.nrs.setText(roomToast.mToastContent);
            }
            if (!this.nrr.isShowing()) {
                if (this.nrg != null) {
                    this.nrr.showAtLocation(this.nrg, 85, 0, this.nwg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.nrr != null) {
                                a.this.nrr.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nrr.dismiss();
        }
    }

    private void dNy() {
        if (this.nrr == null) {
            View inflate = LayoutInflater.from(this.nwv).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nrs = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nrr = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 160.0f), -2);
            this.nrr.setFocusable(false);
            this.nrr.setOutsideTouchable(false);
            this.nrr.setAnimationStyle(a.j.gift_toast_style);
            this.nrr.update();
        }
    }

    private void n(View view, int i, int i2) {
        if (this.nwU != null && this.nwU.isShowing()) {
            this.nwU.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
        if (this.nxq == null) {
            dOa();
        }
        if (!this.nxq.isShowing()) {
            this.nxq.showAtLocation(view, 83, i, i2);
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nwu.dNa().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nxq.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dNz() {
        if (this.nxt != null) {
            if (h.isEmpty(this.nxu)) {
                if (((VideoPlayer) this.nwv).q) {
                    this.nxt.bS(this.nwu != null ? this.nwu.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.nxt.bS(this.nwu != null ? this.nwu.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nwv).q && this.nxu.size() == 2 && this.nxu.contains("4") && this.nxu.contains("2")) {
                this.nxt.bS(this.nwu != null ? this.nwu.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.nxu.size() > 1 || !((VideoPlayer) this.nwv).q) {
                this.nxt.bS(this.nwu != null ? this.nwu.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.nxu.get(0))) {
                this.nxt.bS(this.nwu != null ? this.nwu.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.nxu.get(0))) {
                this.nxt.bS(this.nwu != null ? this.nwu.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.nxu.get(0))) {
                this.nxt.bS(this.nwu != null ? this.nwu.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void o(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
        if (this.nwU == null) {
            al();
            this.nwU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.nwU.isShowing() && this.bB == 2) {
            this.nwU.showAtLocation(view, 83, i, this.nwv.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nwu.dNa().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nwU.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nwo != null) {
            this.nwo.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                g.c(this.nwv, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nsQ.getPlayState() == 4) {
                        e(true);
                        if (this.nwu.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.nwu.a(false);
                        ((VideoPlayer) this.nwv).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nsQ.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nsQ.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                g.c(this.nwv, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.nwu.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nwv).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                    this.ai = false;
                    m(true);
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
        if (this.nxh != null) {
            if (z) {
                this.nxh.setVisibility(0);
            }
            this.nxh.dZq();
            if (!z) {
                this.nxh.setVisibility(8);
            }
        }
        g.c(this.nwv, this.nwv.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nqx != null) {
                this.nqx.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nwp != null) {
                this.nwp.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nqx != null) {
            this.nqx.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nwp != null) {
                    this.nwp.setVisibility(8);
                }
            }
        }
    }

    private void dNA() {
        this.e = false;
        k(true, false, true);
    }

    private void aU() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.nqj[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dNr();
            a(this.nwu != null ? this.nwu.npG.get("1") : null);
            if (i2 == 2) {
                k();
                ax(true, i3);
                v(true);
                b(true);
                dND();
                com.kascend.chushou.toolkit.a.c.a(this.nwv, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            ax(false, i3);
            v(false);
            b(false);
            if (this.nwU != null && this.nwU.isShowing()) {
                this.nwU.dismiss();
            }
            if (i2 == 99) {
                if (this.nqk != null && this.nqk[i] != null && (this.nqk[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nqk[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nwv, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nwv, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nwv, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nwv, "房间信息页_num", null, new Object[0]);
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
        ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nww != null) {
            if (this.nqJ != null && this.nqJ.getVisibility() == 0) {
                u(false);
            }
            if (this.nwp != null && this.nwp.getVisibility() == 0) {
                this.f = true;
            }
            aw(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nqm != null) {
            this.nqm.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nqm != null) {
            this.nqm.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nqm != null) {
            this.nqm.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nqm != null) {
            this.nqm.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nrg != null) {
            int size = iconConfig.configs.size();
            this.nrg.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nwv).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.nrg, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bS(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bS(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.bS(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.bS(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.bS(str, a.e.ic_default_video_bottom);
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
                    public void dy(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.nrg.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.nwu != null ? this.nwu.npG : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nqm != null) {
            this.nqm.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dNz();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nrd != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nrd.zR(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nrd.bS(str, a.c.kas_white);
                if (this.nre != null) {
                    this.nre.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nrd.zR(a.c.kas_white);
                if (this.nre != null) {
                    this.nre.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.nre != null) {
                    this.nre.setTextColor(a);
                    this.nre.setTabTextSelectColor(a2);
                    this.nre.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nqF != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nqF.zR(a.e.ic_hotwords_black_n);
            } else {
                this.nqF.bS(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nqE != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dOn().a(str, this.nqE, a.e.player_skin_input);
            } else {
                this.nqE.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nqI != null) {
                this.nqI.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nqm != null) {
            this.nqm.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nwv instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dMG = ((VideoPlayer) this.nwv).dMG();
            if (this.nxk == null) {
                this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxk.setVisibility(0);
            this.nxk.a(2, dMG);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nqm != null) {
            this.nqm.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nqm != null) {
            this.nqm.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.nqm != null) {
            this.nqm.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.nqm != null) {
            this.nqm.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nqm != null && this.nwu != null) {
            this.nqm.b(this.nwu.npE);
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
    public class C0830a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0830a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.nqj.length) {
                return null;
            }
            switch (a.this.nqj[i]) {
                case 1:
                    if (a.this.nql == null) {
                        a.this.nql = com.kascend.chushou.view.user.a.a(2, null, a.this.nwu.a, false, a.this.nwu.h, false);
                    }
                    a.this.nqk[i] = a.this.nql;
                    return a.this.nql;
                case 2:
                    if (a.this.nqm == null) {
                        a aVar = a.this;
                        if (a.this.npX != null && a.this.npX.nsR != null) {
                            z = a.this.npX.nsR.mInPKMode;
                        }
                        aVar.nqm = com.kascend.chushou.player.ui.a.xF(z);
                    }
                    a.this.nqk[i] = a.this.nqm;
                    return a.this.nqm;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.nwu != null && a.this.nwu.dNa() != null && !h.isEmpty(a.this.nrl)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.nrl.get(i).url);
                        h5Options.a = a.this.nrl.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nqk[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Kz(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.nqj.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int mu(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int KA(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String KB(int i) {
            return a.this.Kz(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int KC(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b KD(int i) {
            int dimensionPixelSize = a.this.nwv.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void DH(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.Mc(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nqd <= 3000) {
            g.Mc(a.i.str_too_fast);
            return false;
        } else {
            dNF();
            if (!com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a(((VideoPlayer) this.nwv).dMA().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nqd = System.currentTimeMillis();
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                a(this.nwu.dNa().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nwu.h);
            }
            g(this.b);
            if (!z && this.nqK != null) {
                this.nqK.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dNF();
            if (com.kascend.chushou.d.e.c(this.nwv, null) && LoginManager.Instance().getUserInfo() != null && this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                a(this.nwu.dNa().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nqK != null) {
                this.nqK.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nqm != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nwu.dNa().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nwu.dNa().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nwv).nnS;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.nqm.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nqm.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.nqm != null) {
            this.nqm.e();
        }
        if (this.nrj != null && this.nrj.isShown()) {
            this.nrj.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dNB() {
        super.dNB();
        if (this.nwv instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.nwu != null) {
            this.nwu.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.nwv != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.nwv).t)) {
                this.cx = true;
                if (this.nwu != null) {
                    this.nwu.f = null;
                    if (this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                        this.nwu.dNa().mRoominfo.mGameId = null;
                    }
                }
                dNt();
                return;
            }
            this.cx = true;
            if (this.nwv != null) {
                ((VideoPlayer) this.nwv).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nqv != null) {
            this.nqv.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nqv != null) {
            this.nqv.setVisibility(8);
        }
        super.i(z);
    }

    private void dNC() {
        aN();
        if (i()) {
            dNE();
            ap();
            return;
        }
        dNt();
    }

    private void dND() {
    }

    private void dNE() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dNZ().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.nxh != null) {
            this.nxh.setVisibility(0);
        }
        if (this.npT != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.npT.d();
        }
        if (this.nqD != null) {
            this.nqD.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nqs.setVisibility(0);
            this.nqs.setOnClickListener(this);
        } else {
            this.nqs.setVisibility(8);
        }
        this.nqx.setVisibility(0);
        this.nqt.setVisibility(0);
        this.nwm.setVisibility(0);
        if (this.p) {
            this.nwn.setVisibility(0);
        } else {
            this.nwn.setVisibility(8);
        }
        dND();
        ax(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nxk != null && this.nxk.a(i, keyEvent)) {
                return true;
            }
            if (this.nro != null && this.nro.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.nrp != null && this.nrp.onKeyDown(i, keyEvent)) || dNG()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nrG != null && this.nrG.getVisibility() == 0 && b(motionEvent, this.nrG)) {
                this.nrG.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.nrF);
                return true;
            } else if (this.nrh && this.nrG != null && this.nrG.getVisibility() == 8 && f(this.nwZ.b, motionEvent)) {
                dNx();
                return true;
            } else if (this.nro != null && this.nro.b() && f(this.nro, motionEvent)) {
                this.nro.a();
                return true;
            } else if (this.nrp != null && this.nrp.b() && f(this.nrp, motionEvent)) {
                this.nrp.a();
                return true;
            } else if (b(motionEvent, this.nqJ)) {
                return dNF();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dNF() {
        boolean z;
        b(this.nrq, 10);
        boolean z2 = false;
        if (this.nqY != null && this.nqY.getVisibility() == 0) {
            this.nqY.setVisibility(8);
            this.nqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nra) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
            this.nqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nqJ == null || this.nqJ.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nqX) {
                bg();
            }
            this.nqJ.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nqD != null && a.this.bB == 2) {
                        a.this.nqD.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dNG() {
        if (dNF()) {
            return true;
        }
        if (this.nwU == null || !this.nwU.isShowing()) {
            return dNx() || az() || dAT();
        }
        this.nwU.dismiss();
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
    public void dNH() {
        this.nqD.setVisibility(8);
        this.nqJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(boolean z, boolean z2) {
        if (this.nqD != null) {
            if (z) {
                if (this.nqD.getVisibility() != 0) {
                    this.nqD.setVisibility(0);
                    this.nqD.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_bottom_anim));
                }
            } else if (this.nqD.getVisibility() != 4) {
                this.nqD.setVisibility(4);
                this.nqD.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nqv != null) {
            this.nqv.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dNI() {
        return this.nru;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.nwu != null) {
                        this.nwu.f = null;
                        this.nwu.dNa().mRoominfo.mGameId = null;
                    }
                    dNt();
                    return;
                }
                g.Mc(a.i.str_getvideosource_failed);
            }
            m(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.nwu != null && this.nwu.dNb() != null) {
            a(this.nwu.dNb());
        }
        this.p = false;
        if (this.nwu == null || this.nwu.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nwu.f.size()) {
                if (!"2".equals(this.nwu.f.get(i2).mType)) {
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
        if (this.nqm != null) {
            this.nqm.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nqy != null && this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                this.nqy.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.nwu.dNa().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.nrm && (c = c(1, -1)) >= 0 && c < this.nrl.size() && this.nrf != null) {
            this.nrf.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nrm) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nwv, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dMH = ((VideoPlayer) this.nwv).dMH();
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(2, dMH);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dMI = ((VideoPlayer) this.nwv).dMI();
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(2, dMI);
            } else if (bVar.a == 9) {
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nqY != null) {
            this.nqY.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nrm) {
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
        if (!aa() && this.nwu != null) {
            String str = this.nwu.a;
            RoomInfo dNd = this.nwu.dNd();
            if (dNd != null && mVar.a(dNd.mCreatorUID, str)) {
                dNd.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nqK != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nqK);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
            if (this.nri == null) {
                this.nri = new f(getActivity());
            }
            this.nri.a(this.nwu.dNa().mRoominfo);
            if (!this.nri.isShowing()) {
                this.nri.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nqm != null) {
            this.nqm.d();
        }
    }

    private void dA(View view) {
        this.nqz = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nqA = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nqA.setText(new tv.chushou.zues.widget.a.c().J(this.nwv, a.e.videoplayer_4g_video).append("  ").append(this.nwv.getString(a.i.videoplayer_4g_video)));
        this.nqB = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nqB.setText(new tv.chushou.zues.widget.a.c().J(this.nwv, a.e.videoplayer_4g_audio).append("  ").append(this.nwv.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nqz.setVisibility(8);
                    ((VideoPlayer) a.this.nwv).c(a.this.nqC);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nqz.setVisibility(8);
                    ((VideoPlayer) a.this.nwv).d(a.this.nqC);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dMh().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nqA.setOnClickListener(onClickListener);
        this.nqB.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nwu != null && !h.isEmpty(this.nwu.f)) {
            f(this.nwu.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nqC = z;
            this.p = false;
            if (this.nwu != null && this.nwu.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nwu.f.size()) {
                        break;
                    } else if (!"2".equals(this.nwu.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nqz != null) {
                this.nqz.setVisibility(0);
                this.nqA.setVisibility(0);
                this.nqB.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nqz != null) {
            this.nqz.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nry == null) {
                this.nry = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.nww != null) {
                    this.nww.e(this.nry, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nry != null && this.nww != null) {
            this.nww.O(this.nry);
            this.nry = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nqm != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nwv, "显示双击666_num", null, new Object[0]);
            if (this.nwu != null) {
                this.nwu.b(false);
            }
            d(false);
            this.nqm.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.nwg != null) {
            if (this.nrp == null) {
                this.nrp = (InteractionView) ((ViewStub) this.nwg.findViewById(a.f.view_interaction)).inflate();
                this.nrp.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.nrp.a();
                    }
                });
            }
            if (this.nrp != null) {
                this.nrp.b(configDetail);
                this.nrp.c();
                this.nrp.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.ead()) {
                g.F(this.nwv, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nwv, null) && (this.nwv instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nwu != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwv, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nwu != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwv, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nwv, configDetail.mUrl, this.nwv.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nwv, null)) {
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
        if (this.nrh) {
            dNx();
            return;
        }
        if (this.nwv.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击送礼_num", "竖屏", new Object[0]);
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nwu.dNa().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nwv != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.npX == null) {
                this.npX = new com.kascend.chushou.player.e.a();
            }
            this.npX.b = str;
            this.npX.nsR.copy(pkNotifyInfo);
            if (this.npX.nsR.mAction == 6) {
                this.npX.nsR.mInPKMode = true;
                this.u = this.npX.nsR.mPkId;
            } else if (this.npX.nsR.mAction == 7 || (this.npX.nsR.mMode == 1 && this.npX.nsR.mAction == 5)) {
                this.npX.nsR.mInPKMode = true;
                this.u = this.npX.nsR.mPkId;
                if (dNJ() != null) {
                    if (2 == this.bB && this.nrB != null) {
                        this.nrB.setVisibility(0);
                    }
                    dNJ().b(this.npX.nsR, false);
                    dNJ().a(this.npX.nsR.mMode, "1");
                    if (this.npX.nsR.mAction == 5 && this.npX.nsR.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.npX.nsR.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.npX.nsR.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.npX.nsR.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.npX.nsR.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.npX.nsR.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dNJ().a(this.npX.nsR);
                        if (this.npX.nsR.destinyInfo == null || this.npX.nsR.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dNJ().a(parseInt, this.npX.nsR.mPkUpdateInfo.remainDuration, j, this.npX.nsR.mMode, i);
                    }
                    if (!h.isEmpty(this.npX.nsR.mPkUpdateInfo.specialMomentList) && dNJ() != null) {
                        dNJ().a(this.npX.nsR, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.RW(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.npX.nsR.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.RW(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.npX != null && this.npX.nsR != null) {
            if (this.npX.nsR.mInPKMode) {
                this.y.setText(this.npX.nsR.mPkUserNickname);
                this.npZ.setVisibility(0);
                if (this.nwl != null) {
                    this.nwl.setEnabled(false);
                }
                if (this.nwn != null) {
                    this.nwn.setEnabled(false);
                    return;
                }
                return;
            }
            this.npZ.setVisibility(8);
            if (this.nwl != null) {
                this.nwl.setEnabled(true);
            }
            if (this.nwn != null) {
                this.nwn.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dNJ() {
        if (this.nwv == null || this.nwg == null || this.nrB == null) {
            return null;
        }
        if (this.npY == null) {
            if (this.nrA == null) {
                this.nrA = ((ViewStub) this.nwg.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.npY = new com.kascend.chushou.player.e.b();
            this.npY.a(this.nrB, this.nrA, (View) null, this.nwv, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dZJ()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.nwu != null) {
                        append.append(a.this.nwu.dNd().mRoomID);
                    }
                    if (a.this.npX != null && a.this.npX.nsR != null) {
                        append.append("&mode=").append(a.this.npX.nsR.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nwv, append.toString());
                }
            });
        }
        return this.npY;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nqV != null && this.nwu != null && this.nwu.npF != null) {
            this.nqV.setText(tv.chushou.zues.utils.b.Mb(this.nwu.npF.count));
            this.nqV.setVisibility(0);
            if (this.nwu.npF.count < 1) {
                bg();
            }
            if (this.nqN != null) {
                this.nqN.setText(this.nwu.npF.primaryName);
            }
            if (this.nqO != null) {
                this.nqO.setText(this.nwu.npF.desc);
            }
            dNK();
        }
    }

    public void dNK() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nqW * h.parseLong(this.nwu.npF.point)));
        if (this.nqQ != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nwv.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nwv, a.e.icon_coin_new);
            cVar.append(this.nwv.getString(a.i.str_buy_count_coin2));
            this.nqQ.setText(cVar);
        }
    }

    private void dNL() {
        if (com.kascend.chushou.d.e.c(this.nwv, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nqW);
        }
    }

    private void v(boolean z) {
        if (this.nwg != null && this.nrB != null) {
            if (z) {
                if (this.npX != null && this.npX.nsR != null && this.npX.nsR.mInPKMode) {
                    this.nrB.setVisibility(0);
                    return;
                }
                return;
            }
            this.nrB.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nwg != null && this.nqc != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nqc.setVisibility(0);
                    return;
                }
                return;
            }
            this.nqc.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.npX != null && this.npX.nsR != null && this.npX.nsR.mInPKMode && this.npZ != null) {
                this.npZ.setVisibility(0);
            }
        } else if (this.npZ != null) {
            this.npZ.setVisibility(8);
        }
    }

    private void bg() {
        this.nqX = false;
        this.nqU.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nwu != null && this.nwu.npF != null) {
            if (this.nwu.npF.count < 1) {
                this.nqV.setVisibility(8);
            } else {
                this.nqV.setVisibility(0);
                this.nqV.setSelected(false);
                this.nqV.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nqM.setVisibility(8);
        if (this.nqK != null) {
            this.nqK.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nqI != null) {
            this.nqI.performClick();
        }
    }

    public boolean dNM() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.nrM = true;
        if (this.nwg != null && com.kascend.chushou.b.dMh().d == 0) {
            this.nrw = tv.chushou.zues.utils.systemBar.b.gI(getActivity());
            if (!z) {
                View findViewById = this.nwg.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.nrw = tv.chushou.zues.utils.systemBar.b.gI(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.nrw);
            View findViewById2 = this.nwg.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.nrw);
            findViewById2.requestLayout();
        }
    }
}
