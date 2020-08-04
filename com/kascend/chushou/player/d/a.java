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
    private RelativeLayout nqB;
    private TextView nqC;
    private TextView nqD;
    private boolean nqE;
    private RelativeLayout nqF;
    private View nqG;
    private FrescoThumbnailView nqH;
    private AnimationSet nqI;
    private ImageView nqJ;
    private TextView nqK;
    private RelativeLayout nqL;
    private PastedEditText nqM;
    private TextView nqN;
    private LinearLayout nqO;
    private TextView nqP;
    private TextView nqQ;
    private TextView nqR;
    private TextView nqS;
    private TextView nqT;
    private TextView nqU;
    private TextView nqV;
    private ImageView nqW;
    private TextView nqX;
    private int[] nql;
    private Fragment[] nqm;
    private ImageView nqq;
    private MarqueeTextView nqr;
    private MarqueeTextView nqs;
    private ImageView nqt;
    private ImageView nqu;
    private ImageButton nqv;
    public String nqw;
    private RecommendView nqx;
    private Runnable nrA;
    private View nrC;
    private LivePKBarUserValue nrD;
    private String nrE;
    private TextView nrF;
    private ImageView nrG;
    private EditText nrH;
    private View nrI;
    private View nrJ;
    private View nrK;
    private String nrN;
    private KPSwitchPanelLinearLayout nra;
    private ImageView nrb;
    private c nrd;
    private d.a nre;
    private FrescoThumbnailView nrf;
    private PagerSlidingTabStrip nrg;
    private KasViewPager nrh;
    private LinearLayout nri;
    private f nrk;
    private ViewMicPerson nrl;
    public ArrayList<RoomTab> nrn;
    private PopH5Menu nrq;
    private InteractionView nrr;
    private int nrs;
    private PopupWindow nrt;
    private TextView nru;
    private GiftAnimationLayout nrv;
    private com.kascend.chushou.player.b.a nrw;
    private long nqf = 0;
    private com.kascend.chushou.view.user.a nqn = null;
    private com.kascend.chushou.player.ui.a nqo = null;
    private int bB = -1;
    private int bC = 0;
    private View nqp = null;
    private View nqy = null;
    private ImageButton nqz = null;
    private int nqY = 1;
    private boolean nqZ = false;
    private boolean nrc = false;
    private boolean nrj = false;
    private boolean cx = false;
    private boolean nrm = false;
    private boolean nro = false;
    private boolean nrp = true;
    private int nrx = 0;
    private int nry = 0;
    private int nrz = -1;
    private final Rect nrB = new Rect();
    private boolean nrL = false;
    private C0830a nrM = null;
    private boolean da = false;
    private boolean nrO = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqw = getArguments().getString("mCover");
        this.nrp = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nwi = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.nwi;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            c(view);
            dNo();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.nro = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.nxb != null) {
            this.nxb.b();
        }
        if (this.nwx != null && (this.nwx instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwx).xB(true);
            ((VideoPlayer) this.nwx).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nro = true;
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
        this.nqY = 1;
        this.nqZ = false;
        U();
        if (this.nwy != null) {
            this.nwy.ch(null);
            this.nwy = null;
        }
        if (this.nqx != null) {
            dOa().removeAllViews();
            this.nqx = null;
        }
        this.c = null;
        this.npT = null;
        tv.chushou.zues.a.a.ci(this);
        this.nrg = null;
        this.nrh = null;
        this.nqo = null;
        this.nqn = null;
        if (this.nqm != null) {
            for (int i = 0; i < this.nqm.length; i++) {
                this.nqm[i] = null;
            }
        }
        this.nqm = null;
        if (this.nqM != null) {
            this.nqM.addTextChangedListener(null);
            this.nqM.setOnTouchListener(null);
            this.nqM.setOnEditorActionListener(null);
            this.nqM = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nwx, this.nrd);
        if (this.nwx != null && (this.nwx instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwx).dMF();
        }
        this.nre = null;
        this.nrd = null;
        if (this.nrl != null) {
            this.nrl.b();
            this.nrl = null;
        }
        if (this.nrt != null) {
            this.nrt.dismiss();
        }
        if (this.nrw != null) {
            this.nrw.a();
            this.nrw = null;
            this.nrv = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.nrD = (LivePKBarUserValue) this.nwi.findViewById(a.f.live_pk_bar_user);
        this.nwq = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nrL) {
            this.nrL = true;
            if (this.nrJ == null) {
                this.nrJ = this.nwi.findViewById(a.f.vs_async_view);
                this.nrJ = ((ViewStub) this.nrJ).inflate();
            }
            if (this.nrK == null) {
                this.nrK = this.nwi.findViewById(a.f.vs_async_notification_view);
                this.nrK = ((ViewStub) this.nrK).inflate();
            }
            this.nqe = (VoiceInteractionView) this.nwi.findViewById(a.f.voiceInteractiveView);
            t();
            dz(this.nwi);
            ar();
            ((VideoPlayer) this.nwx).q();
            this.npZ = new com.kascend.chushou.player.e.a();
        }
    }

    private void dz(View view) {
        this.nrf = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.nrg = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.nrh = (KasViewPager) view.findViewById(a.f.vp_main);
        dNp();
        aI();
        aN();
        if (this.nww != null) {
            I();
            a(this.nww.npF, this.nww.npI);
        }
        this.bb = 0;
        this.nxg = 0L;
        this.nxc = (RoundProgressBar) this.nwi.findViewById(a.f.roundProgressBar);
        this.nxd = (TextView) this.nwi.findViewById(a.f.tv_paonum);
        this.nxe = (FrescoThumbnailView) this.nwi.findViewById(a.f.iv_paoicon);
        this.nxl = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.nrj = false;
                if (a.this.bB == 2) {
                    a.this.ax(true, a.this.i());
                } else {
                    a.this.dNI();
                }
                a.this.b(a.this.nrs, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.nrj = true;
                if (a.this.bB == 2) {
                    a.this.ax(false, a.this.i());
                } else {
                    a.this.dNI();
                }
                if (a.this.nxb != null) {
                    a.this.nxb.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gE(a.this.nwx).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nwx)) - a.this.nxb.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nwx, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nwx, 54.0f) * 2);
                    if (statusBarHeight < a.this.nrs) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.nxf = (PaoGuideView) this.nwi.findViewById(a.f.rlPaoGuideView);
        this.nrl = (ViewMicPerson) this.nwi.findViewById(a.f.rl_mic_person_view);
    }

    private void dNo() {
        this.nsS = ((VideoPlayer) this.nwx).dMy();
        this.nww = ((VideoPlayer) this.nwx).dMB();
        dA(this.nwi);
        this.nrx = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
        this.nry = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (com.kascend.chushou.b.dMi().d == 0 && this.nry > 0) {
            View findViewById = this.nwi.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nry);
        }
        dNx();
        dNv();
        if (!this.nrp) {
            Q();
        }
        dNt();
        a();
        if (this.c == null) {
            this.npT = new d.a();
            this.c = new GestureDetector(this.nwx, this.npT);
        }
        this.npV = ((VideoPlayer) this.nwx).dMC();
        this.npV.a(this);
        if (this.nrw != null) {
            this.nrw.a();
            this.nrw = null;
        }
        this.nrv = (GiftAnimationLayout) this.nwi.findViewById(a.f.ll_gift_animation);
        this.nrv.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.nww != null) {
            this.nrw = new com.kascend.chushou.player.b.a(this.nwx.getApplicationContext(), this.nrv);
            this.nrw.a(this.nww);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.nwi.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nwr = (PlayerErrorView) this.nwi.findViewById(a.f.view_net_error_msg);
        this.nwr.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dNr();
        dNB();
        if (this.nww.dNc() != null) {
            a(this.nww.dNc());
        }
        FullRoomInfo dNb = this.nww.dNb();
        if (dNb != null) {
            dND();
            if (i()) {
                this.ak = false;
                m(true);
                this.nwy.LT(8);
            }
            this.nqA.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dNb.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.nqp.setVisibility(0);
        this.ak = false;
        m(true);
        this.nwy.LT(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nwx).n();
        if (this.nww != null && !h.isEmpty(this.nww.w)) {
            b(this.nww.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dMM;
        dNp();
        k();
        FullRoomInfo dNb = this.nww.dNb();
        if (dNb != null) {
            if (dNb.mRoominfo != null) {
                this.nqA.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dNb.mRoominfo.mOnlineCount)));
                this.nrE = dNb.mRoominfo.mRoomID;
            }
            dND();
            if (!h.isEmpty(dNb.mRoomToastList)) {
                Iterator<RoomToast> it = dNb.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dMp().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.nww != null && this.nww.l()) {
                d(true);
            }
            if (this.nwx != null && (this.nwx instanceof VideoPlayer) && (dMM = ((VideoPlayer) this.nwx).dMM()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dMM.nsT, dMM.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.nri);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dNp() {
        boolean z = true;
        if (this.nww == null || this.nww.dNb() == null || this.nww.dNb().mRoominfo == null || h.isEmpty(this.nww.dNb().mRoomTabs)) {
            this.nrm = false;
            this.nqm = new Fragment[2];
            this.nql = new int[2];
            this.nql[0] = 2;
            this.nql[1] = 1;
            return;
        }
        this.nrm = true;
        this.nrn = new ArrayList<>();
        Iterator<RoomTab> it = this.nww.dNb().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.nrn.add(next);
            }
        }
        if (this.nrn.size() >= 2 && this.nql != null && this.nql.length >= 2 && this.nrn.get(0).type == this.nql[0] && this.nrn.get(1).type == this.nql[1]) {
            z = false;
        }
        this.nqm = new Fragment[this.nrn.size()];
        this.nql = new int[this.nrn.size()];
        for (int i = 0; i < this.nrn.size(); i++) {
            this.nql[i] = this.nrn.get(i).type;
        }
        if (z) {
            this.nrM = new C0830a(getChildFragmentManager());
            this.nrh.setAdapter(this.nrM);
        }
    }

    private void aI() {
        this.nqL = (RelativeLayout) this.nwi.findViewById(a.f.rl_edit_bar);
        this.nqH = (FrescoThumbnailView) this.nwi.findViewById(a.f.btn_hotword);
        this.nqH.zR(a.e.ic_hotwords_black_n);
        this.nqH.setOnClickListener(this);
        this.nqJ = (ImageView) this.nwi.findViewById(a.f.iv_task_badge);
        this.nqI = (AnimationSet) AnimationUtils.loadAnimation(this.nwx, a.C0824a.anim_hotword);
        this.nqI.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dMp().c) {
                    a.this.nqH.clearAnimation();
                    a.this.nqH.startAnimation(a.this.nqI);
                }
            }
        });
        if (com.kascend.chushou.d.h.dMp().c) {
            this.nqH.startAnimation(this.nqI);
            this.nqJ.setVisibility(0);
        }
        this.nqK = (TextView) this.nwi.findViewById(a.f.tv_bottom_input);
        this.nqK.setOnClickListener(this);
        this.nxv = (FrescoThumbnailView) this.nwi.findViewById(a.f.ll_btn_set);
        this.nxv.setOnClickListener(this);
        this.nri = (LinearLayout) this.nwi.findViewById(a.f.ll_bottom_all_button);
        this.nqF = (RelativeLayout) this.nwi.findViewById(a.f.rl_bottom_input);
        this.nqG = this.nwi.findViewById(a.f.ll_bottom_input);
        this.nqF.setVisibility(8);
        this.nqM = (PastedEditText) this.nwi.findViewById(a.f.et_bottom_input);
        this.nqM.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nqN.setEnabled(editable.length() > 0);
            }
        });
        this.nqM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nqN);
                    return true;
                }
                return true;
            }
        });
        this.nqM.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.nqM);
                }
                return false;
            }
        });
        this.nrb = (ImageView) this.nwi.findViewById(a.f.iv_btn_emoji);
        this.nrb.setVisibility(8);
        this.nqN = (TextView) this.nwi.findViewById(a.f.tv_btn_send);
        this.nqN.setOnClickListener(this);
        this.nra = (KPSwitchPanelLinearLayout) this.nwi.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dMi().d == 0) {
            this.nra.setUseStatusBar(true);
        }
        this.nqO = (LinearLayout) this.nwi.findViewById(a.f.head_trumpet);
        this.nqO.setVisibility(8);
        this.nqO.setOnClickListener(this);
        this.nqP = (TextView) this.nwi.findViewById(a.f.tv_primary_name);
        this.nqQ = (TextView) this.nwi.findViewById(a.f.tv_primary_desc);
        this.nqT = (TextView) this.nwi.findViewById(a.f.tv_cut_count);
        this.nqT.setOnClickListener(this);
        this.nqV = (TextView) this.nwi.findViewById(a.f.tv_head_count);
        this.nqV.setText(this.nqY + "");
        this.nqU = (TextView) this.nwi.findViewById(a.f.tv_plus_count);
        this.nqU.setOnClickListener(this);
        this.nqS = (TextView) this.nwi.findViewById(a.f.tv_buy_count_coin);
        this.nqR = (TextView) this.nwi.findViewById(a.f.tv_buy_head);
        this.nqR.setOnClickListener(this);
        this.nqW = (ImageView) this.nwi.findViewById(a.f.iv_trumpet_select);
        this.nqW.setOnClickListener(this);
        this.nqX = (TextView) this.nwi.findViewById(a.f.tv_trumpet_have_count);
        this.nqZ = false;
        this.nqW.setBackgroundResource(a.e.ic_trumpet_n);
        this.nqX.setVisibility(8);
        aK();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nra, this.nrb, this.nqM, new a.InterfaceC0960a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0960a
            public void xC(boolean z) {
                if (a.this.nrb != null) {
                    if (!z) {
                        a.this.nrb.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dMi().d == 0) {
                        a.this.nra.setDirectVisibility(0);
                    }
                    a.this.nrb.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nre = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void xD(boolean z) {
                if (a.this.nrO) {
                    a.this.nrO = false;
                    return;
                }
                a.this.nrc = z;
                if (z) {
                    a.this.nrb.setImageResource(a.e.cs_emoji_normal);
                    a.this.dNq();
                    return;
                }
                if (a.this.nrI != null && a.this.nrI.getVisibility() == 0) {
                    a.this.nrI.setVisibility(8);
                }
                if (a.this.nrj) {
                    a.this.nxb.setVisibility(0);
                }
                if (a.this.nwx != null && (a.this.nwx instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nwx).xB(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.nrd = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nra, this.nre, ((VideoPlayer) this.nwx).dMG());
        ((VideoPlayer) this.nwx).h(((VideoPlayer) this.nwx).dMG());
        this.nrI = this.nwi.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nrF = (TextView) this.nwi.findViewById(a.f.btn_room_search);
        this.nrG = (ImageView) this.nwi.findViewById(a.f.iv_room_emoji_delete);
        this.nrH = (EditText) this.nwi.findViewById(a.f.et_room_emoji_search);
        this.nrH.setImeOptions(3);
        this.nrH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.nrF);
                    return true;
                }
                return false;
            }
        });
        this.nrH.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nrF.setEnabled(editable.length() > 0);
                a.this.nrG.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.nxb.setEmojiSearchText(editable.toString());
            }
        });
        this.nrF.setOnClickListener(this);
        this.nrG.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void av(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dK(this.nrH);
            this.nrI.setVisibility(0);
            this.nrH.requestFocus();
        } else {
            this.nrI.setVisibility(8);
        }
        if (z2) {
            this.nrH.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNq() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gE(this.nwx).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx)) - tv.chushou.zues.widget.kpswitch.b.d.gQ(this.nwx)) - tv.chushou.zues.utils.a.dip2px(this.nwx, 14.0f)) - this.nwx.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nwx, 54.0f) * 2);
        if (statusBarHeight < this.nrs) {
            b(statusBarHeight, 10);
        }
    }

    private void aK() {
    }

    private void dNr() {
        this.nwy = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aw(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.nwi.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nwx.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nwy.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nwy.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nwy.B(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nwy);
                            break;
                        case 12:
                            a.this.b(a.this.nwy);
                            break;
                        case 17:
                            a.this.as();
                            break;
                        case 18:
                            a.this.dAP();
                            break;
                        case 19:
                            a.this.nwv.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dNs() {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nrn)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nrn.size()) {
                    if (!h.isEmpty(this.nrn.get(i2).notifyIcon)) {
                        this.nrg.bN(i2, this.nrn.get(i2).notifyIcon);
                        this.nrg.Ms(i2);
                    } else if (this.nrn.get(i2).notify == 1) {
                        this.nrg.Mr(i2);
                        this.nrg.Mq(i2);
                    } else {
                        this.nrg.Mq(i2);
                        this.nrg.Ms(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nrn)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.nrn.size()) {
                    if (this.nrn.get(i4).type == i) {
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
        if (this.nww == null || this.nww.dNb() == null || this.nww.dNb().mRoominfo == null || h.isEmpty(this.nrn)) {
            if (i == 1) {
                return this.nwx.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nwx.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.nrn.size()) {
            return this.nrn.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nrn) && i < this.nrn.size()) {
            this.nrn.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nrn) && i < this.nrn.size()) {
            this.nrn.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.nrh != null && this.nrg != null && this.nql != null) {
            this.nqo = null;
            if (this.nqm != null) {
                for (int i = 0; i < this.nqm.length; i++) {
                    this.nqm[i] = null;
                }
            }
            if (this.nrM == null) {
                this.nrM = new C0830a(getChildFragmentManager());
                this.nrh.setAdapter(this.nrM);
            } else {
                this.nrM.notifyDataSetChanged();
            }
            this.nrh.setOffscreenPageLimit(this.nql.length);
            this.nrg.c(this.nrh);
            this.nrg.setOnPageChangeListener(this);
            this.nrg.notifyDataSetChanged();
            this.nrg.setVisibility(0);
            this.nrh.setVisibility(0);
            if (!this.nrm) {
                this.bB = 2;
                this.nrh.setCurrentItem(c(2, 0));
                this.nqF.setVisibility(0);
            } else {
                if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                    if (!h.isEmpty(this.nww.dNb().mRoominfo.mGameName)) {
                        this.nqs.setText(this.nww.dNb().mRoominfo.mGameName);
                    } else {
                        this.nqs.setText(this.nwx.getString(a.i.no_online_game_name));
                    }
                    this.nqr.setText(this.nww.dNb().mRoominfo.mName);
                } else {
                    this.nqs.setText(this.nwx.getString(a.i.no_online_game_name));
                }
                dNs();
                if (i()) {
                    aU();
                    if (this.nrh != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.nrh.setCurrentItem(c);
                        this.nrg.setSelectItem(c);
                    }
                } else if (this.nrh != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.nrh.setCurrentItem(c2);
                    this.nrg.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dNt() {
        this.N = new SurfaceView(this.nwx);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dOa().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dNu() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nwx).s();
        dAU();
        az();
        dNn();
        dOa().setBackgroundResource(a.e.room_not_online);
        if (this.nqx == null) {
            this.nqx = new RecommendView(this.nwx);
            dOa().addView(this.nqx);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nwx);
            this.nqx.setLayoutParams(layoutParams);
        }
        if (this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nww.dNb().mRoominfo.mRoomID)) {
            this.nqx.a(this.nww.dNb().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.nwx != null && a.this.dOa() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nwx);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.mVA);
                        if (a.this.dOa().getChildCount() >= 2) {
                            a.this.dOa().addView(frescoThumbnailView, 0);
                        }
                        a.this.dOa().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dZW(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nxj != null) {
            this.nxj.dZr();
            this.nxj.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.nxb != null) {
            this.nxb.e();
        }
        m(false);
        a(false, false);
        if (this.npV != null) {
            this.npV.d();
        }
    }

    private void dNv() {
        int i = 0;
        this.nqp = this.nwi.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dMi().d == 0 && this.nrx > 0) {
            View findViewById = this.nwi.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.nrx;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nqq = (ImageView) this.nqp.findViewById(a.f.back_icon);
        this.nqq.setOnClickListener(this);
        this.nqr = (MarqueeTextView) this.nqp.findViewById(a.f.tv_title);
        this.nqs = (MarqueeTextView) this.nqp.findViewById(a.f.tv_Type);
        this.nqu = (ImageView) this.nwi.findViewById(a.f.btn_setting);
        this.nqy = this.nwi.findViewById(a.f.bottomview);
        if (this.nwo == null) {
            this.nwo = (ImageButton) this.nqy.findViewById(a.f.btn_barrage);
            this.nwo.setOnClickListener(this);
            if (this.nww != null) {
                if (com.kascend.chushou.d.h.dMp().n()) {
                    this.nwo.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nwo.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.nwp = (ImageButton) this.nqy.findViewById(a.f.btn_audio);
        this.nwp.setOnClickListener(this);
        if (this.nww != null && this.nww.d) {
            this.nwp.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.nwp.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.nww != null && this.nww.f != null) {
            while (true) {
                if (i >= this.nww.f.size()) {
                    break;
                } else if (!"2".equals(this.nww.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nqz = (ImageButton) this.nqy.findViewById(a.f.playbutton);
        this.nqz.setOnTouchListener(this);
        this.nqv = (ImageButton) this.nqy.findViewById(a.f.btn_refresh);
        this.nqv.setOnClickListener(this);
        this.nqA = (TextView) this.nqy.findViewById(a.f.tv_online_count);
        if (this.nwn == null) {
            this.nwn = (ImageButton) this.nqy.findViewById(a.f.btn_screenChange);
            this.nwn.setOnClickListener(this);
        }
        if (this.nqt == null) {
            this.nqt = (ImageView) this.nqp.findViewById(a.f.report_icon);
            this.nqt.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nqo != null) {
                        this.nqo.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                        this.nww.dNb().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nww.dNb().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.nww.dNb().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.nww.dNb().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.nww.dNb().mRoominfo.mCreatorUID);
                            }
                        } else if (this.nww.dNb().mMicStatus.onMic) {
                            this.nww.dNb().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nww.dNb().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.nww.dNb().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.nww.dNb().mMicStatus != null && !h.isEmpty(this.nww.dNb().mMicStatus.micRoomId) && !this.nww.dNb().mMicStatus.micRoomId.equals("0")) {
                                this.nrN = this.nww.dNb().mMicStatus.micRoomId;
                            }
                            if (this.nqo != null) {
                                this.nqo.a(this.nww.dNb().mMicStatus, this.nww.dNb().mFanItems, str, z2);
                            }
                            if (this.nrl != null && this.nrl.getVisibility() == 0) {
                                this.nrl.a(this.nww.dNb().mFanItems, this.nww.dNb().mMicStatus, str, z2, this.nww.dNb().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nqo != null) {
                                this.nqo.e();
                            }
                            if (this.nrl != null && this.nrl.isShown()) {
                                this.nrl.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nqo != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nqo.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nqo.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.nrz != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.nrz = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.npZ != null && this.npZ.nsT != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.npZ.nsT.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.npZ.nsT.mInPKMode = true;
                                    this.npZ.nsT.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npZ.nsT.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npZ.nsT.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npZ.nsT.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npZ.nsT.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npZ.nsT.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.npZ.nsT.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.npZ.nsT.mMode = pkNotifyInfo.mMode;
                                    this.npZ.nsT.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dNK() != null) {
                                        dNK().g(true, this.npZ.nsT.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dMp().a) {
                                        if (!com.kascend.chushou.b.dMi().e) {
                                            com.kascend.chushou.b.dMi().e = true;
                                            g.F(this.nwx, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dMp().a(this.nwx, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.nrD != null) {
                                        this.nrD.setVisibility(0);
                                    }
                                    this.npZ.nsT.mAction = 7;
                                    this.npZ.nsT.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npZ.nsT.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npZ.nsT.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npZ.nsT.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npZ.nsT.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npZ.nsT.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dNK() != null) {
                                        dNK().g(false, 0L);
                                        dNK().b(this.npZ.nsT, true);
                                        dNK().a(this.npZ.nsT.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.RW(this.nrE);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.npZ.nsT.mInPKMode = false;
                                    this.npZ.nsT.mAction = 2;
                                    bd();
                                    if (dNK() != null) {
                                        dNK().c();
                                    }
                                    if (com.kascend.chushou.d.h.dMp().a) {
                                        if (!com.kascend.chushou.b.dMi().e) {
                                            com.kascend.chushou.b.dMi().e = true;
                                            g.F(this.nwx, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dMp().a(this.nwx, false);
                                        ak();
                                    }
                                    this.npZ.b = null;
                                    this.npZ.nsT = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.RW(this.nrE);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.npZ.nsT.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.npZ.nsT.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.npZ.nsT.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nww.dNb().mRoominfo.mRoomID) && this.nww.dNb().mRoominfo.mRoomID.equals(this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dNK() != null) {
                                        dNK().a(this.npZ.nsT, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.npZ.nsT.copyUpdate(pkNotifyInfo);
                                    if (dNK() != null) {
                                        dNK().a(this.npZ.nsT);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.npZ.nsT.copyStop(pkNotifyInfo);
                                        if (dNK() != null) {
                                            dNK().B(this.npZ.nsT.mMaxFreeDuration, this.npZ.nsT.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.npZ.nsT.copyResult(pkNotifyInfo);
                                    if (!this.nro && dNK() != null) {
                                        int i5 = 1;
                                        if (this.npZ.nsT.destinyInfo != null && this.npZ.nsT.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dNK().a(h.parseInt(this.npZ.nsT.mResult), h.parseLong(this.npZ.nsT.mvpUid), this.npZ.nsT.mvpAvatar, this.npZ.nsT.mvpNickname, this.npZ.nsT.mMaxFreeDuration, this.npZ.nsT.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nqo != null) {
                if (LoginManager.Instance().islogined() && this.nww != null && this.nww.l()) {
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
                if (this.nww == null || this.nww.dNb() == null || this.nww.dNb().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.nww.dNb().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dMp().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dMp().b().equals(next2.mUserID)) {
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
                this.nqo.a(arrayList, true, false);
                this.nqo.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nql != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nql.length) {
                    break;
                }
                if (this.nql[i2] == 99 && this.nqm != null && this.nqm[i2] != null && (this.nqm[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nqm[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.nrn.size() && this.nrg != null) {
                if (i == 0) {
                    this.nrg.setTagText(i2, new StringBuilder(this.nrn.get(i2).name).toString());
                    return;
                } else {
                    this.nrg.setTagText(i2, this.nrn.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.nwo != null) {
            if (z) {
                this.nwo.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nwo.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dNw() {
        if (this.nwi == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nwi.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
        this.ar = Math.min(gE.x, gE.y);
        this.aq = (this.ar * this.nwx.getResources().getInteger(a.g.h_thumb_height_def)) / this.nwx.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dOa().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nwq.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nrs = this.aq + this.nwx.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nwx, 54.0f);
        b(this.nrs, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dNx() {
        Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
        this.ar = Math.min(gE.x, gE.y);
        this.aq = (this.ar * this.nwx.getResources().getInteger(a.g.h_thumb_height_def)) / this.nwx.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dOa().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nwq.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nrs = this.aq + this.nwx.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nwx, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.nrs, 10);
        k();
        if (!h.isEmpty(this.nqw)) {
            File af = tv.chushou.zues.widget.fresco.a.af(Uri.parse(this.nqw));
            if (af != null && af.exists()) {
                this.nwq.setImageURI(Uri.fromFile(af));
                this.nwq.setVisibility(0);
                return;
            }
            this.nwq.setVisibility(8);
            return;
        }
        this.nwq.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aw(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nqt != null) {
            this.nqt.setVisibility(z ? 0 : 4);
        }
        if (this.nqu != null) {
            this.nqu.setVisibility(z ? 0 : 4);
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
        if (this.nwy != null) {
            this.nwy.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nwx).f(true);
            if (!z3) {
                if (this.nqy.getVisibility() != 0 && z2) {
                    this.nqy.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.nwp.setVisibility(0);
                } else {
                    this.nwp.setVisibility(8);
                }
                this.nqy.setVisibility(0);
            }
            PlayUrl dNc = this.nww.dNc();
            if (dNc != null && "2".equals(dNc.mType)) {
                if (this.nwn != null) {
                    this.nwn.setVisibility(8);
                }
            } else if (this.nwn != null) {
                this.nwn.setVisibility(0);
            }
            if (this.nqp.getVisibility() != 0 && z2) {
                this.nqp.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_top_anim));
            }
            t(!z3);
            this.nqp.setVisibility(0);
            w(true);
            if (this.nwy != null) {
                this.nwy.B(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nwx).f(false);
            if (this.nwO != null) {
                this.nwO.dismiss();
            }
            if (this.nwP != null) {
                this.nwP.dismiss();
            }
            if (this.nqy.getVisibility() != 8 && z2) {
                this.nqy.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_bottom_anim));
            }
            this.nqy.setVisibility(8);
            if (this.nqp.getVisibility() != 8 && z2) {
                this.nqp.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_top_anim));
            }
            this.nqp.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dAU() {
        if (this.nxf == null || !this.nxf.isShown()) {
            return false;
        }
        this.nxf.d();
        return true;
    }

    public boolean az() {
        if (this.nrl == null || !this.nrl.isShown()) {
            return false;
        }
        this.nrl.a();
        return true;
    }

    public boolean dNn() {
        if (this.nrq == null || !this.nrq.b()) {
            return false;
        }
        this.nrq.a();
        return true;
    }

    public boolean dNy() {
        if (this.nrj && this.nxb != null) {
            if (this.nxb != null) {
                this.nxb.e();
            }
            if (this.nrH != null) {
                this.nrH.setText("");
            }
            if (this.bB == 2) {
                ax(true, i());
                return true;
            }
            dNI();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nwi != null) {
            if (this.nrq == null) {
                this.nrq = (PopH5Menu) ((ViewStub) this.nwi.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.nrq.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.nrq.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            p(view, 0, this.nqp.getHeight() + this.nqp.getTop());
        } else if (id == a.f.btn_barrage) {
            q(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nwx, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                g.c(this.nwx, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.nww.a(false);
                a(false, false);
                ((VideoPlayer) this.nwx).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.nwx, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.npZ == null || this.npZ.nsT == null || !this.npZ.nsT.mInPKMode) {
                ((VideoPlayer) this.nwx).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nqZ) {
                f(this.nqM.getText().toString());
            } else {
                a(this.nqM.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dMp().c) {
                com.kascend.chushou.d.h.dMp().b(false);
                this.nqI.cancel();
                this.nqI.reset();
                this.nqH.clearAnimation();
                this.nqJ.setVisibility(8);
            }
            o(view, 0, this.nwi.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nwx, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            n(view, x, this.nwi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.nww.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nwx, null) && this.nww != null && this.nww.npH != null) {
                if (this.nqZ) {
                    bg();
                    return;
                }
                if (this.nww != null && this.nww.npH != null && this.nww.npH.count > 0) {
                    this.nqO.setVisibility(8);
                } else {
                    this.nqO.setVisibility(0);
                }
                this.nqZ = true;
                this.nqW.setBackgroundResource(a.e.ic_trumpet_p);
                this.nqX.setVisibility(0);
                this.nqX.setSelected(true);
                this.nqX.setTextColor(Color.parseColor("#ff5959"));
                if (this.nqM != null) {
                    this.nqM.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nqY <= 9) {
                this.nqY++;
                this.nqV.setText(this.nqY + "");
            }
            dNL();
        } else if (id == a.f.tv_cut_count) {
            if (this.nqY > 1) {
                this.nqY--;
                this.nqV.setText(this.nqY + "");
            }
            dNL();
        } else if (id == a.f.tv_buy_head) {
            dNM();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.nrH.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.nrH.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.nrH);
                this.nxb.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nqM != null && this.nqF != null && this.nqL != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.nqM);
                this.nqF.setVisibility(8);
                if (this.bB == 2) {
                    this.nqL.setVisibility(0);
                }
            }
        } else if (this.nqF != null && this.nqL != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
            if (this.bB == 2) {
                this.nqF.setVisibility(0);
            }
            this.nqL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dMp().c(roomToast.mToastContent);
            if (this.nrt == null) {
                dNz();
            }
            if (this.nru != null) {
                this.nru.setText(roomToast.mToastContent);
            }
            if (!this.nrt.isShowing()) {
                if (this.nri != null) {
                    this.nrt.showAtLocation(this.nri, 85, 0, this.nwi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.nrt != null) {
                                a.this.nrt.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nrt.dismiss();
        }
    }

    private void dNz() {
        if (this.nrt == null) {
            View inflate = LayoutInflater.from(this.nwx).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nru = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nrt = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 160.0f), -2);
            this.nrt.setFocusable(false);
            this.nrt.setOutsideTouchable(false);
            this.nrt.setAnimationStyle(a.j.gift_toast_style);
            this.nrt.update();
        }
    }

    private void n(View view, int i, int i2) {
        if (this.nwW != null && this.nwW.isShowing()) {
            this.nwW.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
        if (this.nxs == null) {
            dOb();
        }
        if (!this.nxs.isShowing()) {
            this.nxs.showAtLocation(view, 83, i, i2);
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nww.dNb().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nxs.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dNA() {
        if (this.nxv != null) {
            if (h.isEmpty(this.nxw)) {
                if (((VideoPlayer) this.nwx).q) {
                    this.nxv.bS(this.nww != null ? this.nww.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.nxv.bS(this.nww != null ? this.nww.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nwx).q && this.nxw.size() == 2 && this.nxw.contains("4") && this.nxw.contains("2")) {
                this.nxv.bS(this.nww != null ? this.nww.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.nxw.size() > 1 || !((VideoPlayer) this.nwx).q) {
                this.nxv.bS(this.nww != null ? this.nww.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.nxw.get(0))) {
                this.nxv.bS(this.nww != null ? this.nww.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.nxw.get(0))) {
                this.nxv.bS(this.nww != null ? this.nww.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.nxw.get(0))) {
                this.nxv.bS(this.nww != null ? this.nww.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void o(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
        if (this.nwW == null) {
            al();
            this.nwW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.nwW.isShowing() && this.bB == 2) {
            this.nwW.showAtLocation(view, 83, i, this.nwx.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nww.dNb().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nwW.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nwq != null) {
            this.nwq.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                g.c(this.nwx, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nsS.getPlayState() == 4) {
                        e(true);
                        if (this.nww.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.nww.a(false);
                        ((VideoPlayer) this.nwx).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nsS.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nsS.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                g.c(this.nwx, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.nww.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nwx).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
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
        if (this.nxj != null) {
            if (z) {
                this.nxj.setVisibility(0);
            }
            this.nxj.dZr();
            if (!z) {
                this.nxj.setVisibility(8);
            }
        }
        g.c(this.nwx, this.nwx.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nqz != null) {
                this.nqz.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nwr != null) {
                this.nwr.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nqz != null) {
            this.nqz.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nwr != null) {
                    this.nwr.setVisibility(8);
                }
            }
        }
    }

    private void dNB() {
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
        int i2 = this.nql[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dNs();
            a(this.nww != null ? this.nww.npI.get("1") : null);
            if (i2 == 2) {
                k();
                ax(true, i3);
                v(true);
                b(true);
                dNE();
                com.kascend.chushou.toolkit.a.c.a(this.nwx, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            ax(false, i3);
            v(false);
            b(false);
            if (this.nwW != null && this.nwW.isShowing()) {
                this.nwW.dismiss();
            }
            if (i2 == 99) {
                if (this.nqm != null && this.nqm[i] != null && (this.nqm[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nqm[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nwx, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nwx, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nwx, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nwx, "房间信息页_num", null, new Object[0]);
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
        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nwy != null) {
            if (this.nqL != null && this.nqL.getVisibility() == 0) {
                u(false);
            }
            if (this.nwr != null && this.nwr.getVisibility() == 0) {
                this.f = true;
            }
            aw(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nqo != null) {
            this.nqo.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nqo != null) {
            this.nqo.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nqo != null) {
            this.nqo.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nqo != null) {
            this.nqo.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nri != null) {
            int size = iconConfig.configs.size();
            this.nri.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nwx).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.nri, false);
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
                this.nri.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.nww != null ? this.nww.npI : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nqo != null) {
            this.nqo.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dNA();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nrf != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nrf.zR(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nrf.bS(str, a.c.kas_white);
                if (this.nrg != null) {
                    this.nrg.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nrf.zR(a.c.kas_white);
                if (this.nrg != null) {
                    this.nrg.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.nrg != null) {
                    this.nrg.setTextColor(a);
                    this.nrg.setTabTextSelectColor(a2);
                    this.nrg.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nqH != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nqH.zR(a.e.ic_hotwords_black_n);
            } else {
                this.nqH.bS(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nqG != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dOo().a(str, this.nqG, a.e.player_skin_input);
            } else {
                this.nqG.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nqK != null) {
                this.nqK.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nqo != null) {
            this.nqo.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nwx instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dMH = ((VideoPlayer) this.nwx).dMH();
            if (this.nxm == null) {
                this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxm.setVisibility(0);
            this.nxm.a(2, dMH);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nqo != null) {
            this.nqo.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nqo != null) {
            this.nqo.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.nqo != null) {
            this.nqo.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.nqo != null) {
            this.nqo.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nqo != null && this.nww != null) {
            this.nqo.b(this.nww.npG);
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
            if (i < 0 || i >= a.this.nql.length) {
                return null;
            }
            switch (a.this.nql[i]) {
                case 1:
                    if (a.this.nqn == null) {
                        a.this.nqn = com.kascend.chushou.view.user.a.a(2, null, a.this.nww.a, false, a.this.nww.h, false);
                    }
                    a.this.nqm[i] = a.this.nqn;
                    return a.this.nqn;
                case 2:
                    if (a.this.nqo == null) {
                        a aVar = a.this;
                        if (a.this.npZ != null && a.this.npZ.nsT != null) {
                            z = a.this.npZ.nsT.mInPKMode;
                        }
                        aVar.nqo = com.kascend.chushou.player.ui.a.xF(z);
                    }
                    a.this.nqm[i] = a.this.nqo;
                    return a.this.nqo;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.nww != null && a.this.nww.dNb() != null && !h.isEmpty(a.this.nrn)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.nrn.get(i).url);
                        h5Options.a = a.this.nrn.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nqm[i] = a;
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
            return a.this.nql.length;
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
            int dimensionPixelSize = a.this.nwx.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
        } else if (System.currentTimeMillis() - this.nqf <= 3000) {
            g.Mc(a.i.str_too_fast);
            return false;
        } else {
            dNG();
            if (!com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a(((VideoPlayer) this.nwx).dMB().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nqf = System.currentTimeMillis();
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                a(this.nww.dNb().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nww.h);
            }
            g(this.b);
            if (!z && this.nqM != null) {
                this.nqM.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dNG();
            if (com.kascend.chushou.d.e.c(this.nwx, null) && LoginManager.Instance().getUserInfo() != null && this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                a(this.nww.dNb().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nqM != null) {
                this.nqM.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nqo != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nww.dNb().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nww.dNb().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nwx).nnU;
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
                        this.nqo.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nqo.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.nqo != null) {
            this.nqo.e();
        }
        if (this.nrl != null && this.nrl.isShown()) {
            this.nrl.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dNC() {
        super.dNC();
        if (this.nwx instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.nww != null) {
            this.nww.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.nwx != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.nwx).t)) {
                this.cx = true;
                if (this.nww != null) {
                    this.nww.f = null;
                    if (this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                        this.nww.dNb().mRoominfo.mGameId = null;
                    }
                }
                dNu();
                return;
            }
            this.cx = true;
            if (this.nwx != null) {
                ((VideoPlayer) this.nwx).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nqx != null) {
            this.nqx.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nqx != null) {
            this.nqx.setVisibility(8);
        }
        super.i(z);
    }

    private void dND() {
        aN();
        if (i()) {
            dNF();
            ap();
            return;
        }
        dNu();
    }

    private void dNE() {
    }

    private void dNF() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dOa().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.nxj != null) {
            this.nxj.setVisibility(0);
        }
        if (this.npV != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.npV.d();
        }
        if (this.nqF != null) {
            this.nqF.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nqu.setVisibility(0);
            this.nqu.setOnClickListener(this);
        } else {
            this.nqu.setVisibility(8);
        }
        this.nqz.setVisibility(0);
        this.nqv.setVisibility(0);
        this.nwo.setVisibility(0);
        if (this.p) {
            this.nwp.setVisibility(0);
        } else {
            this.nwp.setVisibility(8);
        }
        dNE();
        ax(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nxm != null && this.nxm.a(i, keyEvent)) {
                return true;
            }
            if (this.nrq != null && this.nrq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.nrr != null && this.nrr.onKeyDown(i, keyEvent)) || dNH()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nrI != null && this.nrI.getVisibility() == 0 && b(motionEvent, this.nrI)) {
                this.nrI.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.nrH);
                return true;
            } else if (this.nrj && this.nrI != null && this.nrI.getVisibility() == 8 && f(this.nxb.b, motionEvent)) {
                dNy();
                return true;
            } else if (this.nrq != null && this.nrq.b() && f(this.nrq, motionEvent)) {
                this.nrq.a();
                return true;
            } else if (this.nrr != null && this.nrr.b() && f(this.nrr, motionEvent)) {
                this.nrr.a();
                return true;
            } else if (b(motionEvent, this.nqL)) {
                return dNG();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dNG() {
        boolean z;
        b(this.nrs, 10);
        boolean z2 = false;
        if (this.nra != null && this.nra.getVisibility() == 0) {
            this.nra.setVisibility(8);
            this.nrb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nrc) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
            this.nrb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nqL == null || this.nqL.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nqZ) {
                bg();
            }
            this.nqL.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nqF != null && a.this.bB == 2) {
                        a.this.nqF.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dNH() {
        if (dNG()) {
            return true;
        }
        if (this.nwW == null || !this.nwW.isShowing()) {
            return dNy() || az() || dAU();
        }
        this.nwW.dismiss();
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
    public void dNI() {
        this.nqF.setVisibility(8);
        this.nqL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(boolean z, boolean z2) {
        if (this.nqF != null) {
            if (z) {
                if (this.nqF.getVisibility() != 0) {
                    this.nqF.setVisibility(0);
                    this.nqF.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_bottom_anim));
                }
            } else if (this.nqF.getVisibility() != 4) {
                this.nqF.setVisibility(4);
                this.nqF.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nqx != null) {
            this.nqx.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dNJ() {
        return this.nrw;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.nww != null) {
                        this.nww.f = null;
                        this.nww.dNb().mRoominfo.mGameId = null;
                    }
                    dNu();
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
        if (this.nww != null && this.nww.dNc() != null) {
            a(this.nww.dNc());
        }
        this.p = false;
        if (this.nww == null || this.nww.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nww.f.size()) {
                if (!"2".equals(this.nww.f.get(i2).mType)) {
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
        if (this.nqo != null) {
            this.nqo.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nqA != null && this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                this.nqA.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.nww.dNb().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.nro && (c = c(1, -1)) >= 0 && c < this.nrn.size() && this.nrh != null) {
            this.nrh.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nro) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nwx, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dMI = ((VideoPlayer) this.nwx).dMI();
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(2, dMI);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dMJ = ((VideoPlayer) this.nwx).dMJ();
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(2, dMJ);
            } else if (bVar.a == 9) {
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nra != null) {
            this.nra.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nro) {
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
        if (!aa() && this.nww != null) {
            String str = this.nww.a;
            RoomInfo dNe = this.nww.dNe();
            if (dNe != null && mVar.a(dNe.mCreatorUID, str)) {
                dNe.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nqM != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nqM);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
            if (this.nrk == null) {
                this.nrk = new f(getActivity());
            }
            this.nrk.a(this.nww.dNb().mRoominfo);
            if (!this.nrk.isShowing()) {
                this.nrk.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nqo != null) {
            this.nqo.d();
        }
    }

    private void dA(View view) {
        this.nqB = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nqC = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nqC.setText(new tv.chushou.zues.widget.a.c().J(this.nwx, a.e.videoplayer_4g_video).append("  ").append(this.nwx.getString(a.i.videoplayer_4g_video)));
        this.nqD = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nqD.setText(new tv.chushou.zues.widget.a.c().J(this.nwx, a.e.videoplayer_4g_audio).append("  ").append(this.nwx.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nqB.setVisibility(8);
                    ((VideoPlayer) a.this.nwx).c(a.this.nqE);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nqB.setVisibility(8);
                    ((VideoPlayer) a.this.nwx).d(a.this.nqE);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dMi().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nqC.setOnClickListener(onClickListener);
        this.nqD.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nww != null && !h.isEmpty(this.nww.f)) {
            f(this.nww.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nqE = z;
            this.p = false;
            if (this.nww != null && this.nww.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nww.f.size()) {
                        break;
                    } else if (!"2".equals(this.nww.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nqB != null) {
                this.nqB.setVisibility(0);
                this.nqC.setVisibility(0);
                this.nqD.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nqB != null) {
            this.nqB.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nrA == null) {
                this.nrA = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.nwy != null) {
                    this.nwy.e(this.nrA, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nrA != null && this.nwy != null) {
            this.nwy.O(this.nrA);
            this.nrA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nqo != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nwx, "显示双击666_num", null, new Object[0]);
            if (this.nww != null) {
                this.nww.b(false);
            }
            d(false);
            this.nqo.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.nwi != null) {
            if (this.nrr == null) {
                this.nrr = (InteractionView) ((ViewStub) this.nwi.findViewById(a.f.view_interaction)).inflate();
                this.nrr.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.nrr.a();
                    }
                });
            }
            if (this.nrr != null) {
                this.nrr.b(configDetail);
                this.nrr.c();
                this.nrr.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eae()) {
                g.F(this.nwx, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nwx, null) && (this.nwx instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nww != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwx, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nww != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwx, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nwx, configDetail.mUrl, this.nwx.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nwx, null)) {
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
        if (this.nrj) {
            dNy();
            return;
        }
        if (this.nwx.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击送礼_num", "竖屏", new Object[0]);
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nww.dNb().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nwx != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.npZ == null) {
                this.npZ = new com.kascend.chushou.player.e.a();
            }
            this.npZ.b = str;
            this.npZ.nsT.copy(pkNotifyInfo);
            if (this.npZ.nsT.mAction == 6) {
                this.npZ.nsT.mInPKMode = true;
                this.u = this.npZ.nsT.mPkId;
            } else if (this.npZ.nsT.mAction == 7 || (this.npZ.nsT.mMode == 1 && this.npZ.nsT.mAction == 5)) {
                this.npZ.nsT.mInPKMode = true;
                this.u = this.npZ.nsT.mPkId;
                if (dNK() != null) {
                    if (2 == this.bB && this.nrD != null) {
                        this.nrD.setVisibility(0);
                    }
                    dNK().b(this.npZ.nsT, false);
                    dNK().a(this.npZ.nsT.mMode, "1");
                    if (this.npZ.nsT.mAction == 5 && this.npZ.nsT.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.npZ.nsT.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.npZ.nsT.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.npZ.nsT.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.npZ.nsT.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.npZ.nsT.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dNK().a(this.npZ.nsT);
                        if (this.npZ.nsT.destinyInfo == null || this.npZ.nsT.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dNK().a(parseInt, this.npZ.nsT.mPkUpdateInfo.remainDuration, j, this.npZ.nsT.mMode, i);
                    }
                    if (!h.isEmpty(this.npZ.nsT.mPkUpdateInfo.specialMomentList) && dNK() != null) {
                        dNK().a(this.npZ.nsT, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.RW(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.npZ.nsT.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.RW(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.npZ != null && this.npZ.nsT != null) {
            if (this.npZ.nsT.mInPKMode) {
                this.y.setText(this.npZ.nsT.mPkUserNickname);
                this.nqb.setVisibility(0);
                if (this.nwn != null) {
                    this.nwn.setEnabled(false);
                }
                if (this.nwp != null) {
                    this.nwp.setEnabled(false);
                    return;
                }
                return;
            }
            this.nqb.setVisibility(8);
            if (this.nwn != null) {
                this.nwn.setEnabled(true);
            }
            if (this.nwp != null) {
                this.nwp.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dNK() {
        if (this.nwx == null || this.nwi == null || this.nrD == null) {
            return null;
        }
        if (this.nqa == null) {
            if (this.nrC == null) {
                this.nrC = ((ViewStub) this.nwi.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.nqa = new com.kascend.chushou.player.e.b();
            this.nqa.a(this.nrD, this.nrC, (View) null, this.nwx, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dZK()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.nww != null) {
                        append.append(a.this.nww.dNe().mRoomID);
                    }
                    if (a.this.npZ != null && a.this.npZ.nsT != null) {
                        append.append("&mode=").append(a.this.npZ.nsT.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nwx, append.toString());
                }
            });
        }
        return this.nqa;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nqX != null && this.nww != null && this.nww.npH != null) {
            this.nqX.setText(tv.chushou.zues.utils.b.Mb(this.nww.npH.count));
            this.nqX.setVisibility(0);
            if (this.nww.npH.count < 1) {
                bg();
            }
            if (this.nqP != null) {
                this.nqP.setText(this.nww.npH.primaryName);
            }
            if (this.nqQ != null) {
                this.nqQ.setText(this.nww.npH.desc);
            }
            dNL();
        }
    }

    public void dNL() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nqY * h.parseLong(this.nww.npH.point)));
        if (this.nqS != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nwx.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nwx, a.e.icon_coin_new);
            cVar.append(this.nwx.getString(a.i.str_buy_count_coin2));
            this.nqS.setText(cVar);
        }
    }

    private void dNM() {
        if (com.kascend.chushou.d.e.c(this.nwx, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nqY);
        }
    }

    private void v(boolean z) {
        if (this.nwi != null && this.nrD != null) {
            if (z) {
                if (this.npZ != null && this.npZ.nsT != null && this.npZ.nsT.mInPKMode) {
                    this.nrD.setVisibility(0);
                    return;
                }
                return;
            }
            this.nrD.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nwi != null && this.nqe != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nqe.setVisibility(0);
                    return;
                }
                return;
            }
            this.nqe.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.npZ != null && this.npZ.nsT != null && this.npZ.nsT.mInPKMode && this.nqb != null) {
                this.nqb.setVisibility(0);
            }
        } else if (this.nqb != null) {
            this.nqb.setVisibility(8);
        }
    }

    private void bg() {
        this.nqZ = false;
        this.nqW.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nww != null && this.nww.npH != null) {
            if (this.nww.npH.count < 1) {
                this.nqX.setVisibility(8);
            } else {
                this.nqX.setVisibility(0);
                this.nqX.setSelected(false);
                this.nqX.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nqO.setVisibility(8);
        if (this.nqM != null) {
            this.nqM.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nqK != null) {
            this.nqK.performClick();
        }
    }

    public boolean dNN() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.nrO = true;
        if (this.nwi != null && com.kascend.chushou.b.dMi().d == 0) {
            this.nry = tv.chushou.zues.utils.systemBar.b.gI(getActivity());
            if (!z) {
                View findViewById = this.nwi.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.nry = tv.chushou.zues.utils.systemBar.b.gI(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.nry);
            View findViewById2 = this.nwi.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.nry);
            findViewById2.requestLayout();
        }
    }
}
