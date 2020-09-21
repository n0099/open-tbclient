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
    private TextView nUB;
    private RelativeLayout nUC;
    private TextView nUD;
    private TextView nUE;
    private boolean nUF;
    private RelativeLayout nUG;
    private View nUH;
    private FrescoThumbnailView nUI;
    private AnimationSet nUJ;
    private ImageView nUK;
    private TextView nUL;
    private RelativeLayout nUM;
    private PastedEditText nUN;
    private TextView nUO;
    private LinearLayout nUP;
    private TextView nUQ;
    private TextView nUR;
    private TextView nUS;
    private TextView nUT;
    private TextView nUU;
    private TextView nUV;
    private TextView nUW;
    private ImageView nUX;
    private TextView nUY;
    private int[] nUm;
    private Fragment[] nUn;
    private ImageView nUr;
    private MarqueeTextView nUs;
    private MarqueeTextView nUt;
    private ImageView nUu;
    private ImageView nUv;
    private ImageButton nUw;
    public String nUx;
    private RecommendView nUy;
    private View nVB;
    private LivePKBarUserValue nVC;
    private String nVD;
    private TextView nVE;
    private ImageView nVF;
    private EditText nVG;
    private View nVH;
    private View nVI;
    private View nVJ;
    private String nVN;
    private KPSwitchPanelLinearLayout nVb;
    private ImageView nVc;
    private c nVd;
    private d.a nVe;
    private FrescoThumbnailView nVf;
    private PagerSlidingTabStrip nVg;
    private KasViewPager nVh;
    private LinearLayout nVi;
    private f nVk;
    private ViewMicPerson nVl;
    public ArrayList<RoomTab> nVn;
    private PopH5Menu nVp;
    private InteractionView nVq;
    private int nVr;
    private PopupWindow nVs;
    private TextView nVt;
    private GiftAnimationLayout nVu;
    private com.kascend.chushou.player.b.a nVv;
    private Runnable nVz;
    private long nUg = 0;
    private com.kascend.chushou.view.user.a nUo = null;
    private com.kascend.chushou.player.ui.a nUp = null;
    private int bB = -1;
    private int bC = 0;
    private View nUq = null;
    private View nUz = null;
    private ImageButton nUA = null;
    private int nUZ = 1;
    private boolean nVa = false;
    private boolean cp = false;
    private boolean nVj = false;
    private boolean cx = false;
    private boolean nVm = false;
    private boolean nVo = false;
    private boolean cC = true;
    private int nVw = 0;
    private int nVx = 0;
    private int nVy = -1;
    private final Rect nVA = new Rect();
    private boolean nVK = false;
    private C0885a nVL = null;
    private boolean nVM = false;
    private boolean nVO = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nUx = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.oaj = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.oaj;
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
        this.nVo = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.obd != null) {
            this.obd.b();
        }
        if (this.oay != null && (this.oay instanceof VideoPlayer)) {
            ((VideoPlayer) this.oay).yD(true);
            ((VideoPlayer) this.oay).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nVo = true;
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
        this.nUZ = 1;
        this.nVa = false;
        U();
        if (this.oaz != null) {
            this.oaz.cl(null);
            this.oaz = null;
        }
        if (this.nUy != null) {
            eeh().removeAllViews();
            this.nUy = null;
        }
        this.c = null;
        this.nTU = null;
        tv.chushou.zues.a.a.cm(this);
        this.nVg = null;
        this.nVh = null;
        this.nUp = null;
        this.nUo = null;
        if (this.nUn != null) {
            for (int i = 0; i < this.nUn.length; i++) {
                this.nUn[i] = null;
            }
        }
        this.nUn = null;
        if (this.nUN != null) {
            this.nUN.addTextChangedListener(null);
            this.nUN.setOnTouchListener(null);
            this.nUN.setOnEditorActionListener(null);
            this.nUN = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.oay, this.nVd);
        if (this.oay != null && (this.oay instanceof VideoPlayer)) {
            ((VideoPlayer) this.oay).ecO();
        }
        this.nVe = null;
        this.nVd = null;
        if (this.nVl != null) {
            this.nVl.b();
            this.nVl = null;
        }
        if (this.nVs != null) {
            this.nVs.dismiss();
        }
        if (this.nVv != null) {
            this.nVv.a();
            this.nVv = null;
            this.nVu = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.nVC = (LivePKBarUserValue) this.oaj.findViewById(a.f.live_pk_bar_user);
        this.oar = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nVK) {
            this.nVK = true;
            if (this.nVI == null) {
                this.nVI = this.oaj.findViewById(a.f.vs_async_view);
                this.nVI = ((ViewStub) this.nVI).inflate();
            }
            if (this.nVJ == null) {
                this.nVJ = this.oaj.findViewById(a.f.vs_async_notification_view);
                this.nVJ = ((ViewStub) this.nVJ).inflate();
            }
            this.nUf = (VoiceInteractionView) this.oaj.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.oaj);
            dQK();
            ((VideoPlayer) this.oay).q();
            this.nUa = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.nVf = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.nVg = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.nVh = (KasViewPager) view.findViewById(a.f.vp_main);
        edv();
        aI();
        edz();
        if (this.oax != null) {
            I();
            a(this.oax.nTG, this.oax.nTJ);
        }
        this.bb = 0;
        this.obi = 0L;
        this.obe = (RoundProgressBar) this.oaj.findViewById(a.f.roundProgressBar);
        this.obf = (TextView) this.oaj.findViewById(a.f.tv_paonum);
        this.obg = (FrescoThumbnailView) this.oaj.findViewById(a.f.iv_paoicon);
        this.obo = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.nVj = false;
                if (a.this.bB == 2) {
                    a.this.aF(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.nVr, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.nVj = true;
                if (a.this.bB == 2) {
                    a.this.aF(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.obd != null) {
                    a.this.obd.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hc(a.this.oay).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.oay)) - a.this.obd.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.oay, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.oay, 54.0f) * 2);
                    if (statusBarHeight < a.this.nVr) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.obh = (PaoGuideView) this.oaj.findViewById(a.f.rlPaoGuideView);
        this.nVl = (ViewMicPerson) this.oaj.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.nWQ = ((VideoPlayer) this.oay).ecH();
        this.oax = ((VideoPlayer) this.oay).ecK();
        e(this.oaj);
        this.nVw = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
        this.nVx = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (com.kascend.chushou.b.ecq().d == 0 && this.nVx > 0) {
            View findViewById = this.oaj.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nVx);
        }
        edE();
        edC();
        if (!this.cC) {
            Q();
        }
        edA();
        a();
        if (this.c == null) {
            this.nTU = new d.a();
            this.c = new GestureDetector(this.oay, this.nTU);
        }
        this.nTW = ((VideoPlayer) this.oay).ecL();
        this.nTW.a(this);
        if (this.nVv != null) {
            this.nVv.a();
            this.nVv = null;
        }
        this.nVu = (GiftAnimationLayout) this.oaj.findViewById(a.f.ll_gift_animation);
        this.nVu.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.oax != null) {
            this.nVv = new com.kascend.chushou.player.b.a(this.oay.getApplicationContext(), this.nVu);
            this.nVv.a(this.oax);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.oaj.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.oas = (PlayerErrorView) this.oaj.findViewById(a.f.view_net_error_msg);
        this.oas.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        edH();
        if (this.oax.edk() != null) {
            a(this.oax.edk());
        }
        FullRoomInfo edj = this.oax.edj();
        if (edj != null) {
            edL();
            if (i()) {
                this.ak = false;
                yG(true);
                this.oaz.Pb(8);
            }
            this.nUB.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(edj.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.oak != null) {
            this.oak.setVisibility(0);
        }
        this.nUq.setVisibility(0);
        this.ak = false;
        yG(true);
        this.oaz.Pb(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.oay).n();
        if (this.oax != null && !h.isEmpty(this.oax.w)) {
            b(this.oax.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a ecV;
        edv();
        k();
        FullRoomInfo edj = this.oax.edj();
        if (edj != null) {
            if (edj.mRoominfo != null) {
                this.nUB.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(edj.mRoominfo.mOnlineCount)));
                this.nVD = edj.mRoominfo.mRoomID;
            }
            edL();
            if (!h.isEmpty(edj.mRoomToastList)) {
                Iterator<RoomToast> it = edj.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.ecy().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.oax != null && this.oax.l()) {
                d(true);
            }
            if (this.oay != null && (this.oay instanceof VideoPlayer) && (ecV = ((VideoPlayer) this.oay).ecV()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(ecV.nWR, ecV.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.nVi);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void edv() {
        boolean z = true;
        if (this.oax == null || this.oax.edj() == null || this.oax.edj().mRoominfo == null || h.isEmpty(this.oax.edj().mRoomTabs)) {
            this.nVm = false;
            this.nUn = new Fragment[2];
            this.nUm = new int[2];
            this.nUm[0] = 2;
            this.nUm[1] = 1;
            return;
        }
        this.nVm = true;
        this.nVn = new ArrayList<>();
        Iterator<RoomTab> it = this.oax.edj().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.nVn.add(next);
            }
        }
        if (this.nVn.size() >= 2 && this.nUm != null && this.nUm.length >= 2 && this.nVn.get(0).type == this.nUm[0] && this.nVn.get(1).type == this.nUm[1]) {
            z = false;
        }
        this.nUn = new Fragment[this.nVn.size()];
        this.nUm = new int[this.nVn.size()];
        for (int i = 0; i < this.nVn.size(); i++) {
            this.nUm[i] = this.nVn.get(i).type;
        }
        if (z) {
            this.nVL = new C0885a(getChildFragmentManager());
            this.nVh.setAdapter(this.nVL);
        }
    }

    private void aI() {
        this.nUM = (RelativeLayout) this.oaj.findViewById(a.f.rl_edit_bar);
        this.nUI = (FrescoThumbnailView) this.oaj.findViewById(a.f.btn_hotword);
        this.nUI.CL(a.e.ic_hotwords_black_n);
        this.nUI.setOnClickListener(this);
        this.nUK = (ImageView) this.oaj.findViewById(a.f.iv_task_badge);
        this.nUJ = (AnimationSet) AnimationUtils.loadAnimation(this.oay, a.C0879a.anim_hotword);
        this.nUJ.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.ecy().c) {
                    a.this.nUI.clearAnimation();
                    a.this.nUI.startAnimation(a.this.nUJ);
                }
            }
        });
        if (com.kascend.chushou.d.h.ecy().c) {
            this.nUI.startAnimation(this.nUJ);
            this.nUK.setVisibility(0);
        }
        this.nUL = (TextView) this.oaj.findViewById(a.f.tv_bottom_input);
        this.nUL.setOnClickListener(this);
        this.obz = (FrescoThumbnailView) this.oaj.findViewById(a.f.ll_btn_set);
        this.obz.setOnClickListener(this);
        this.nVi = (LinearLayout) this.oaj.findViewById(a.f.ll_bottom_all_button);
        this.nUG = (RelativeLayout) this.oaj.findViewById(a.f.rl_bottom_input);
        this.nUH = this.oaj.findViewById(a.f.ll_bottom_input);
        this.nUG.setVisibility(8);
        this.nUN = (PastedEditText) this.oaj.findViewById(a.f.et_bottom_input);
        this.nUN.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nUO.setEnabled(editable.length() > 0);
            }
        });
        this.nUN.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nUO);
                    return true;
                }
                return true;
            }
        });
        this.nUN.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.nUN);
                }
                return false;
            }
        });
        this.nVc = (ImageView) this.oaj.findViewById(a.f.iv_btn_emoji);
        this.nVc.setVisibility(8);
        this.nUO = (TextView) this.oaj.findViewById(a.f.tv_btn_send);
        this.nUO.setOnClickListener(this);
        this.nVb = (KPSwitchPanelLinearLayout) this.oaj.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.ecq().d == 0) {
            this.nVb.setUseStatusBar(true);
        }
        this.nUP = (LinearLayout) this.oaj.findViewById(a.f.head_trumpet);
        this.nUP.setVisibility(8);
        this.nUP.setOnClickListener(this);
        this.nUQ = (TextView) this.oaj.findViewById(a.f.tv_primary_name);
        this.nUR = (TextView) this.oaj.findViewById(a.f.tv_primary_desc);
        this.nUU = (TextView) this.oaj.findViewById(a.f.tv_cut_count);
        this.nUU.setOnClickListener(this);
        this.nUW = (TextView) this.oaj.findViewById(a.f.tv_head_count);
        this.nUW.setText(this.nUZ + "");
        this.nUV = (TextView) this.oaj.findViewById(a.f.tv_plus_count);
        this.nUV.setOnClickListener(this);
        this.nUT = (TextView) this.oaj.findViewById(a.f.tv_buy_count_coin);
        this.nUS = (TextView) this.oaj.findViewById(a.f.tv_buy_head);
        this.nUS.setOnClickListener(this);
        this.nUX = (ImageView) this.oaj.findViewById(a.f.iv_trumpet_select);
        this.nUX.setOnClickListener(this);
        this.nUY = (TextView) this.oaj.findViewById(a.f.tv_trumpet_have_count);
        this.nVa = false;
        this.nUX.setBackgroundResource(a.e.ic_trumpet_n);
        this.nUY.setVisibility(8);
        edx();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nVb, this.nVc, this.nUN, new a.InterfaceC1015a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1015a
            public void yE(boolean z) {
                if (a.this.nVc != null) {
                    if (!z) {
                        a.this.nVc.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.ecq().d == 0) {
                        a.this.nVb.setDirectVisibility(0);
                    }
                    a.this.nVc.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nVe = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void jm(boolean z) {
                if (a.this.nVO) {
                    a.this.nVO = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.nVc.setImageResource(a.e.cs_emoji_normal);
                    a.this.edw();
                    return;
                }
                if (a.this.nVH != null && a.this.nVH.getVisibility() == 0) {
                    a.this.nVH.setVisibility(8);
                }
                if (a.this.nVj) {
                    a.this.obd.setVisibility(0);
                }
                if (a.this.oay != null && (a.this.oay instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.oay).yD(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.nVd = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nVb, this.nVe, ((VideoPlayer) this.oay).ecP());
        ((VideoPlayer) this.oay).h(((VideoPlayer) this.oay).ecP());
        this.nVH = this.oaj.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nVE = (TextView) this.oaj.findViewById(a.f.btn_room_search);
        this.nVF = (ImageView) this.oaj.findViewById(a.f.iv_room_emoji_delete);
        this.nVG = (EditText) this.oaj.findViewById(a.f.et_room_emoji_search);
        this.nVG.setImeOptions(3);
        this.nVG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.nVE);
                    return true;
                }
                return false;
            }
        });
        this.nVG.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nVE.setEnabled(editable.length() > 0);
                a.this.nVF.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.obd.setEmojiSearchText(editable.toString());
            }
        });
        this.nVE.setOnClickListener(this);
        this.nVF.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aD(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bu(this.nVG);
            this.nVH.setVisibility(0);
            this.nVG.requestFocus();
        } else {
            this.nVH.setVisibility(8);
        }
        if (z2) {
            this.nVG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edw() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hc(this.oay).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay)) - tv.chushou.zues.widget.kpswitch.b.d.ed(this.oay)) - tv.chushou.zues.utils.a.dip2px(this.oay, 14.0f)) - this.oay.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.oay, 54.0f) * 2);
        if (statusBarHeight < this.nVr) {
            b(statusBarHeight, 10);
        }
    }

    private void edx() {
    }

    private void aL() {
        this.oaz = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aE(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.oaj.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.oay.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.oaz.C(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.oaz.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.oaz.C(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.oaz);
                            break;
                        case 12:
                            a.this.b(a.this.oaz);
                            break;
                        case 17:
                            a.this.eej();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.oaw.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void edy() {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.nVn)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nVn.size()) {
                    if (!h.isEmpty(this.nVn.get(i2).notifyIcon)) {
                        this.nVg.bO(i2, this.nVn.get(i2).notifyIcon);
                        this.nVg.Pw(i2);
                    } else if (this.nVn.get(i2).notify == 1) {
                        this.nVg.Pv(i2);
                        this.nVg.Pu(i2);
                    } else {
                        this.nVg.Pu(i2);
                        this.nVg.Pw(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.nVn)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.nVn.size()) {
                    if (this.nVn.get(i4).type == i) {
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
    public String NI(int i) {
        if (this.oax == null || this.oax.edj() == null || this.oax.edj().mRoominfo == null || h.isEmpty(this.nVn)) {
            if (i == 1) {
                return this.oay.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.oay.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.nVn.size()) {
            return this.nVn.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.nVn) && i < this.nVn.size()) {
            this.nVn.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.nVn) && i < this.nVn.size()) {
            this.nVn.get(i).notifyIcon = str;
        }
    }

    private void edz() {
        if (this.nVh != null && this.nVg != null && this.nUm != null) {
            this.nUp = null;
            if (this.nUn != null) {
                for (int i = 0; i < this.nUn.length; i++) {
                    this.nUn[i] = null;
                }
            }
            if (this.nVL == null) {
                this.nVL = new C0885a(getChildFragmentManager());
                this.nVh.setAdapter(this.nVL);
            } else {
                this.nVL.notifyDataSetChanged();
            }
            this.nVh.setOffscreenPageLimit(this.nUm.length);
            this.nVg.c(this.nVh);
            this.nVg.setOnPageChangeListener(this);
            this.nVg.notifyDataSetChanged();
            this.nVg.setVisibility(0);
            this.nVh.setVisibility(0);
            if (!this.nVm) {
                this.bB = 2;
                this.nVh.setCurrentItem(c(2, 0));
                this.nUG.setVisibility(0);
            } else {
                if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                    if (!h.isEmpty(this.oax.edj().mRoominfo.mGameName)) {
                        this.nUt.setText(this.oax.edj().mRoominfo.mGameName);
                    } else {
                        this.nUt.setText(this.oay.getString(a.i.no_online_game_name));
                    }
                    this.nUs.setText(this.oax.edj().mRoominfo.mName);
                } else {
                    this.nUt.setText(this.oay.getString(a.i.no_online_game_name));
                }
                edy();
                if (i()) {
                    edI();
                    if (this.nVh != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.nVh.setCurrentItem(c);
                        this.nVg.setSelectItem(c);
                    }
                } else if (this.nVh != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.nVh.setCurrentItem(c2);
                    this.nVg.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void edA() {
        this.oak = new SurfaceView(this.oay);
        SurfaceView surfaceView = (SurfaceView) this.oak;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        eeh().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void edB() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.oay).s();
        dQP();
        edF();
        edu();
        eeh().setBackgroundResource(a.e.room_not_online);
        if (this.nUy == null) {
            this.nUy = new RecommendView(this.oay);
            eeh().addView(this.nUy);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.oay);
            this.nUy.setLayoutParams(layoutParams);
        }
        if (this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.oax.edj().mRoominfo.mRoomID)) {
            this.nUy.a(this.oax.edj().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.oay != null && a.this.eeh() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.oay);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.nzG);
                        if (a.this.eeh().getChildCount() >= 2) {
                            a.this.eeh().addView(frescoThumbnailView, 0);
                        }
                        a.this.eeh().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.eqg(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.oak != null) {
            this.oak.setVisibility(8);
        }
        if (this.obm != null) {
            this.obm.epC();
            this.obm.setVisibility(8);
        }
        m(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.obd != null) {
            this.obd.e();
        }
        yG(false);
        a(false, false);
        if (this.nTW != null) {
            this.nTW.d();
        }
    }

    private void edC() {
        int i = 0;
        this.nUq = this.oaj.findViewById(a.f.topview);
        if (com.kascend.chushou.b.ecq().d == 0 && this.nVw > 0) {
            View findViewById = this.oaj.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.nVw;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nUr = (ImageView) this.nUq.findViewById(a.f.back_icon);
        this.nUr.setOnClickListener(this);
        this.nUs = (MarqueeTextView) this.nUq.findViewById(a.f.tv_title);
        this.nUt = (MarqueeTextView) this.nUq.findViewById(a.f.tv_Type);
        this.nUv = (ImageView) this.oaj.findViewById(a.f.btn_setting);
        this.nUz = this.oaj.findViewById(a.f.bottomview);
        if (this.oap == null) {
            this.oap = (ImageButton) this.nUz.findViewById(a.f.btn_barrage);
            this.oap.setOnClickListener(this);
            if (this.oax != null) {
                if (com.kascend.chushou.d.h.ecy().n()) {
                    this.oap.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.oap.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.oaq = (ImageButton) this.nUz.findViewById(a.f.btn_audio);
        this.oaq.setOnClickListener(this);
        if (this.oax != null && this.oax.d) {
            this.oaq.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.oaq.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.oax != null && this.oax.f != null) {
            while (true) {
                if (i >= this.oax.f.size()) {
                    break;
                } else if (!"2".equals(this.oax.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nUA = (ImageButton) this.nUz.findViewById(a.f.playbutton);
        this.nUA.setOnTouchListener(this);
        this.nUw = (ImageButton) this.nUz.findViewById(a.f.btn_refresh);
        this.nUw.setOnClickListener(this);
        this.nUB = (TextView) this.nUz.findViewById(a.f.tv_online_count);
        if (this.oao == null) {
            this.oao = (ImageButton) this.nUz.findViewById(a.f.btn_screenChange);
            this.oao.setOnClickListener(this);
        }
        if (this.nUu == null) {
            this.nUu = (ImageView) this.nUq.findViewById(a.f.report_icon);
            this.nUu.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dL(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nUp != null) {
                        this.nUp.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                        this.oax.edj().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.oax.edj().mMicStatus.onMic) {
                            edK();
                        }
                        if (this.oax.edj().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.oax.edj().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.oax.edj().mRoominfo.mCreatorUID);
                            }
                        } else if (this.oax.edj().mMicStatus.onMic) {
                            this.oax.edj().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.oax.edj().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.oax.edj().mFanItems, str);
                            }
                            this.nVM = z2;
                            if (this.oax.edj().mMicStatus != null && !h.isEmpty(this.oax.edj().mMicStatus.micRoomId) && !this.oax.edj().mMicStatus.micRoomId.equals("0")) {
                                this.nVN = this.oax.edj().mMicStatus.micRoomId;
                            }
                            if (this.nUp != null) {
                                this.nUp.a(this.oax.edj().mMicStatus, this.oax.edj().mFanItems, str, z2);
                            }
                            if (this.nVl != null && this.nVl.getVisibility() == 0) {
                                this.nVl.a(this.oax.edj().mFanItems, this.oax.edj().mMicStatus, str, z2, this.oax.edj().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nUp != null) {
                                this.nUp.e();
                            }
                            if (this.nVl != null && this.nVl.isShown()) {
                                this.nVl.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nUp != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nUp.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nUp.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.nVy != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.nVy = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nUa != null && this.nUa.nWR != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nUa.nWR.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nUa.nWR.mInPKMode = true;
                                    this.nUa.nWR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nUa.nWR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nUa.nWR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nUa.nWR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nUa.nWR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nUa.nWR.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nUa.nWR.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nUa.nWR.mMode = pkNotifyInfo.mMode;
                                    this.nUa.nWR.liveStyle = pkNotifyInfo.liveStyle;
                                    if (edR() != null) {
                                        edR().h(true, this.nUa.nWR.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.ecy().a) {
                                        if (!com.kascend.chushou.b.ecq().e) {
                                            com.kascend.chushou.b.ecq().e = true;
                                            g.K(this.oay, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.ecy().a(this.oay, false);
                                        edJ();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.nVC != null) {
                                        this.nVC.setVisibility(0);
                                    }
                                    this.nUa.nWR.mAction = 7;
                                    this.nUa.nWR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nUa.nWR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nUa.nWR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nUa.nWR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nUa.nWR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nUa.nWR.destinyInfo = pkNotifyInfo.destinyInfo;
                                    edQ();
                                    if (edR() != null) {
                                        edR().h(false, 0L);
                                        edR().b(this.nUa.nWR, true);
                                        edR().a(this.nUa.nWR.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.VC(this.nVD);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.nUa.nWR.mInPKMode = false;
                                    this.nUa.nWR.mAction = 2;
                                    edQ();
                                    if (edR() != null) {
                                        edR().c();
                                    }
                                    if (com.kascend.chushou.d.h.ecy().a) {
                                        if (!com.kascend.chushou.b.ecq().e) {
                                            com.kascend.chushou.b.ecq().e = true;
                                            g.K(this.oay, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.ecy().a(this.oay, false);
                                        edJ();
                                    }
                                    this.nUa.b = null;
                                    this.nUa.nWR = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.VC(this.nVD);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nUa.nWR.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nUa.nWR.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.nUa.nWR.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.oax.edj().mRoominfo.mRoomID) && this.oax.edj().mRoominfo.mRoomID.equals(this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (edR() != null) {
                                        edR().a(this.nUa.nWR, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nUa.nWR.copyUpdate(pkNotifyInfo);
                                    if (edR() != null) {
                                        edR().a(this.nUa.nWR);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nUa.nWR.copyStop(pkNotifyInfo);
                                        if (edR() != null) {
                                            edR().E(this.nUa.nWR.mMaxFreeDuration, this.nUa.nWR.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nUa.nWR.copyResult(pkNotifyInfo);
                                    if (!this.nVo && edR() != null) {
                                        int i5 = 1;
                                        if (this.nUa.nWR.destinyInfo != null && this.nUa.nWR.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        edR().a(h.parseInt(this.nUa.nWR.mResult), h.parseLong(this.nUa.nWR.mvpUid), this.nUa.nWR.mvpAvatar, this.nUa.nWR.mvpNickname, this.nUa.nWR.mMaxFreeDuration, this.nUa.nWR.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nUp != null) {
                if (LoginManager.Instance().islogined() && this.oax != null && this.oax.l()) {
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
                if (this.oax == null || this.oax.edj() == null || this.oax.edj().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.oax.edj().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.ecy().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.ecy().b().equals(next2.mUserID)) {
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
                this.nUp.a(arrayList, true, false);
                this.nUp.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nUm != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nUm.length) {
                    break;
                }
                if (this.nUm[i2] == 99 && this.nUn != null && this.nUn[i2] != null && (this.nUn[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nUn[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.nVn.size() && this.nVg != null) {
                if (i == 0) {
                    this.nVg.setTagText(i2, new StringBuilder(this.nVn.get(i2).name).toString());
                    return;
                } else {
                    this.nVg.setTagText(i2, this.nVn.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.oap != null) {
            if (z) {
                this.oap.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.oap.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout edD() {
        if (this.oaj == null) {
            return null;
        }
        return (GiftAnimationLayout) this.oaj.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hc = tv.chushou.zues.utils.a.hc(this.oay);
        this.ar = Math.min(hc.x, hc.y);
        this.aq = (this.ar * this.oay.getResources().getInteger(a.g.h_thumb_height_def)) / this.oay.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = eeh().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.oar.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nVr = this.aq + this.oay.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.oay, 54.0f);
        b(this.nVr, 10);
        if (this.oak != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.oak).setLayoutParams(layoutParams3);
        }
    }

    private void edE() {
        Point hc = tv.chushou.zues.utils.a.hc(this.oay);
        this.ar = Math.min(hc.x, hc.y);
        this.aq = (this.ar * this.oay.getResources().getInteger(a.g.h_thumb_height_def)) / this.oay.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = eeh().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.oar.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.nVr = this.aq + this.oay.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.oay, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.nVr, 10);
        k();
        if (!h.isEmpty(this.nUx)) {
            File ah = tv.chushou.zues.widget.fresco.a.ah(Uri.parse(this.nUx));
            if (ah != null && ah.exists()) {
                this.oar.setImageURI(Uri.fromFile(ah));
                this.oar.setVisibility(0);
                return;
            }
            this.oar.setVisibility(8);
            return;
        }
        this.oar.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aE(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nUu != null) {
            this.nUu.setVisibility(z ? 0 : 4);
        }
        if (this.nUv != null) {
            this.nUv.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aE(boolean z, boolean z2) {
        return m(z, z2, this.f);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.oaz != null) {
            this.oaz.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.oay).f(true);
            if (!z3) {
                if (this.nUz.getVisibility() != 0 && z2) {
                    this.nUz.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.oaq.setVisibility(0);
                } else {
                    this.oaq.setVisibility(8);
                }
                this.nUz.setVisibility(0);
            }
            PlayUrl edk = this.oax.edk();
            if (edk != null && "2".equals(edk.mType)) {
                if (this.oao != null) {
                    this.oao.setVisibility(8);
                }
            } else if (this.oao != null) {
                this.oao.setVisibility(0);
            }
            if (this.nUq.getVisibility() != 0 && z2) {
                this.nUq.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_top_anim));
            }
            t(!z3);
            this.nUq.setVisibility(0);
            w(true);
            if (this.oaz != null) {
                this.oaz.C(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.oay).f(false);
            if (this.oaQ != null) {
                this.oaQ.dismiss();
            }
            if (this.oaR != null) {
                this.oaR.dismiss();
            }
            if (this.nUz.getVisibility() != 8 && z2) {
                this.nUz.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_bottom_anim));
            }
            this.nUz.setVisibility(8);
            if (this.nUq.getVisibility() != 8 && z2) {
                this.nUq.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_top_anim));
            }
            this.nUq.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dQP() {
        if (this.obh == null || !this.obh.isShown()) {
            return false;
        }
        this.obh.d();
        return true;
    }

    public boolean edF() {
        if (this.nVl == null || !this.nVl.isShown()) {
            return false;
        }
        this.nVl.a();
        return true;
    }

    public boolean edu() {
        if (this.nVp == null || !this.nVp.b()) {
            return false;
        }
        this.nVp.a();
        return true;
    }

    public boolean edG() {
        if (this.nVj && this.obd != null) {
            if (this.obd != null) {
                this.obd.e();
            }
            if (this.nVG != null) {
                this.nVG.setText("");
            }
            if (this.bB == 2) {
                aF(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.oaj != null) {
            if (this.nVp == null) {
                this.nVp = (PopH5Menu) ((ViewStub) this.oaj.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.nVp.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.nVp.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.nUq.getHeight() + this.nUq.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.oay, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                g.c(this.oay, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.oax.a(false);
                a(false, false);
                ((VideoPlayer) this.oay).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.oay).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.oay, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.nUa == null || this.nUa.nWR == null || !this.nUa.nWR.mInPKMode) {
                ((VideoPlayer) this.oay).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.oay, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nVa) {
                f(this.nUN.getText().toString());
            } else {
                a(this.nUN.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.ecy().c) {
                com.kascend.chushou.d.h.ecy().b(false);
                this.nUJ.cancel();
                this.nUJ.reset();
                this.nUI.clearAnimation();
                this.nUK.setVisibility(8);
            }
            n(view, 0, this.oaj.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.oay, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.oaj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.oax.d) {
                dQD();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.oay, null) && this.oax != null && this.oax.nTI != null) {
                if (this.nVa) {
                    edU();
                    return;
                }
                if (this.oax != null && this.oax.nTI != null && this.oax.nTI.count > 0) {
                    this.nUP.setVisibility(8);
                } else {
                    this.nUP.setVisibility(0);
                }
                this.nVa = true;
                this.nUX.setBackgroundResource(a.e.ic_trumpet_p);
                this.nUY.setVisibility(0);
                this.nUY.setSelected(true);
                this.nUY.setTextColor(Color.parseColor("#ff5959"));
                if (this.nUN != null) {
                    this.nUN.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nUZ <= 9) {
                this.nUZ++;
                this.nUW.setText(this.nUZ + "");
            }
            edS();
        } else if (id == a.f.tv_cut_count) {
            if (this.nUZ > 1) {
                this.nUZ--;
                this.nUW.setText(this.nUZ + "");
            }
            edS();
        } else if (id == a.f.tv_buy_head) {
            edT();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.nVG.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.nVG.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dV(this.nVG);
                this.obd.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nUN != null && this.nUG != null && this.nUM != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bu(this.nUN);
                this.nUG.setVisibility(8);
                if (this.bB == 2) {
                    this.nUM.setVisibility(0);
                }
            }
        } else if (this.nUG != null && this.nUM != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
            if (this.bB == 2) {
                this.nUG.setVisibility(0);
            }
            this.nUM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.ecy().c(roomToast.mToastContent);
            if (this.nVs == null) {
                aS();
            }
            if (this.nVt != null) {
                this.nVt.setText(roomToast.mToastContent);
            }
            if (!this.nVs.isShowing()) {
                if (this.nVi != null) {
                    this.nVs.showAtLocation(this.nVi, 85, 0, this.oaj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
                    RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.nVs != null) {
                                a.this.nVs.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nVs.dismiss();
        }
    }

    private void aS() {
        if (this.nVs == null) {
            View inflate = LayoutInflater.from(this.oay).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nVt = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nVs = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 160.0f), -2);
            this.nVs.setFocusable(false);
            this.nVs.setOutsideTouchable(false);
            this.nVs.setAnimationStyle(a.j.gift_toast_style);
            this.nVs.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.oaY != null && this.oaY.isShowing()) {
            this.oaY.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
        if (this.obw == null) {
            eek();
        }
        if (!this.obw.isShowing()) {
            this.obw.showAtLocation(view, 83, i, i2);
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.oax.edj().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.obw.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.obz != null) {
            if (h.isEmpty(this.obA)) {
                if (((VideoPlayer) this.oay).q) {
                    this.obz.bX(this.oax != null ? this.oax.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.obz.bX(this.oax != null ? this.oax.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.oay).q && this.obA.size() == 2 && this.obA.contains("4") && this.obA.contains("2")) {
                this.obz.bX(this.oax != null ? this.oax.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.obA.size() > 1 || !((VideoPlayer) this.oay).q) {
                this.obz.bX(this.oax != null ? this.oax.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.obA.get(0))) {
                this.obz.bX(this.oax != null ? this.oax.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.obA.get(0))) {
                this.obz.bX(this.oax != null ? this.oax.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.obA.get(0))) {
                this.obz.bX(this.oax != null ? this.oax.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
        if (this.oaY == null) {
            al();
            this.oaY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.oaY.isShowing() && this.bB == 2) {
            this.oaY.showAtLocation(view, 83, i, this.oay.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.oax.edj().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.oaY.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.oar != null) {
            this.oar.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                g.c(this.oay, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nWQ.getPlayState() == 4) {
                        e(true);
                        if (this.oax.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.oax.a(false);
                        ((VideoPlayer) this.oay).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nWQ.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nWQ.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                g.c(this.oay, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.oax.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.oay).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                    this.ai = false;
                    yG(true);
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
        if (this.obm != null) {
            if (z) {
                this.obm.setVisibility(0);
            }
            this.obm.epC();
            if (!z) {
                this.obm.setVisibility(8);
            }
        }
        g.c(this.oay, this.oay.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nUA != null) {
                this.nUA.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.oas != null) {
                this.oas.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nUA != null) {
            this.nUA.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.oas != null) {
                    this.oas.setVisibility(8);
                }
            }
        }
    }

    private void edH() {
        this.e = false;
        m(true, false, true);
    }

    private void edI() {
        this.e = false;
        m(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.nUm[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            edy();
            a(this.oax != null ? this.oax.nTJ.get("1") : null);
            if (i2 == 2) {
                k();
                aF(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.oay, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aF(false, i3);
            v(false);
            b(false);
            if (this.oaY != null && this.oaY.isShowing()) {
                this.oaY.dismiss();
            }
            if (i2 == 99) {
                if (this.nUn != null && this.nUn[i] != null && (this.nUn[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nUn[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.oay, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.oay, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.oay, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.oay, "房间信息页_num", null, new Object[0]);
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
    protected void edJ() {
        ((VideoPlayer) this.oay).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.oaz != null) {
            if (this.nUM != null && this.nUM.getVisibility() == 0) {
                u(false);
            }
            if (this.oas != null && this.oas.getVisibility() == 0) {
                this.f = true;
            }
            aE(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nUp != null) {
            this.nUp.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nUp != null) {
            this.nUp.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nUp != null) {
            this.nUp.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nUp != null) {
            this.nUp.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nVi != null) {
            int size = iconConfig.configs.size();
            this.nVi.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.oay).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.nVi, false);
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
                    public void dL(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.nVi.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.oax != null ? this.oax.nTJ : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nUp != null) {
            this.nUp.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nVf != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nVf.CL(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nVf.bX(str, a.c.kas_white);
                if (this.nVg != null) {
                    this.nVg.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nVf.CL(a.c.kas_white);
                if (this.nVg != null) {
                    this.nVg.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.nVg != null) {
                    this.nVg.setTextColor(a);
                    this.nVg.setTabTextSelectColor(a2);
                    this.nVg.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nUI != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nUI.CL(a.e.ic_hotwords_black_n);
            } else {
                this.nUI.bX(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nUH != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.eex().a(str, this.nUH, a.e.player_skin_input);
            } else {
                this.nUH.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nUL != null) {
                this.nUL.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void a(int i) {
        if (this.nUp != null) {
            this.nUp.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void D() {
        if (this.oay instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a ecQ = ((VideoPlayer) this.oay).ecQ();
            if (this.obq == null) {
                this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.obq.setVisibility(0);
            this.obq.a(2, ecQ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nUp != null) {
            this.nUp.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nUp != null) {
            this.nUp.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(long j) {
        if (this.nUp != null) {
            this.nUp.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0892a
    public void c(int i) {
        if (this.nUp != null) {
            this.nUp.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nUp != null && this.oax != null) {
            this.nUp.b(this.oax.nTH);
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
    public class C0885a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0885a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.nUm.length) {
                return null;
            }
            switch (a.this.nUm[i]) {
                case 1:
                    if (a.this.nUo == null) {
                        a.this.nUo = com.kascend.chushou.view.user.a.a(2, null, a.this.oax.a, false, a.this.oax.h, false);
                    }
                    a.this.nUn[i] = a.this.nUo;
                    return a.this.nUo;
                case 2:
                    if (a.this.nUp == null) {
                        a aVar = a.this;
                        if (a.this.nUa != null && a.this.nUa.nWR != null) {
                            z = a.this.nUa.nWR.mInPKMode;
                        }
                        aVar.nUp = com.kascend.chushou.player.ui.a.yH(z);
                    }
                    a.this.nUn[i] = a.this.nUp;
                    return a.this.nUp;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.oax != null && a.this.oax.edj() != null && !h.isEmpty(a.this.nVn)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.nVn.get(i).url);
                        h5Options.a = a.this.nVn.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nUn[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.NI(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.nUm.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int oL(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int NJ(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String NK(int i) {
            return a.this.NI(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int NL(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b NM(int i) {
            int dimensionPixelSize = a.this.oay.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void GD(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.Pk(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nUg <= IMConnection.RETRY_DELAY_TIMES) {
            g.Pk(a.i.str_too_fast);
            return false;
        } else {
            edM();
            if (!com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a(((VideoPlayer) this.oay).ecK().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nUg = System.currentTimeMillis();
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                a(this.oax.edj().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.oax.h);
            }
            g(this.b);
            if (!z && this.nUN != null) {
                this.nUN.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            edM();
            if (com.kascend.chushou.d.e.c(this.oay, null) && LoginManager.Instance().getUserInfo() != null && this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                a(this.oax.edj().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nUN != null) {
                this.nUN.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nUp != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.oax.edj().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.oax.edj().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.oay).nRX;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.nUp.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nUp.a(arrayList, true, true);
        }
    }

    private void edK() {
        if (this.nUp != null) {
            this.nUp.e();
        }
        if (this.nVl != null && this.nVl.isShown()) {
            this.nVl.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.oay instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.oay;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.oax != null) {
            this.oax.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        edK();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.oay != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.oay).t)) {
                this.cx = true;
                if (this.oax != null) {
                    this.oax.f = null;
                    if (this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                        this.oax.edj().mRoominfo.mGameId = null;
                    }
                }
                edB();
                return;
            }
            this.cx = true;
            if (this.oay != null) {
                ((VideoPlayer) this.oay).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nUy != null) {
            this.nUy.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nUy != null) {
            this.nUy.setVisibility(8);
        }
        super.i(z);
    }

    private void edL() {
        edz();
        if (i()) {
            aY();
            ap();
            return;
        }
        edB();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        eeh().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.oak != null) {
            this.oak.setVisibility(0);
        }
        if (this.obm != null) {
            this.obm.setVisibility(0);
        }
        if (this.nTW != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.nTW.d();
        }
        if (this.nUG != null) {
            this.nUG.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nUv.setVisibility(0);
            this.nUv.setOnClickListener(this);
        } else {
            this.nUv.setVisibility(8);
        }
        this.nUA.setVisibility(0);
        this.nUw.setVisibility(0);
        this.oap.setVisibility(0);
        if (this.p) {
            this.oaq.setVisibility(0);
        } else {
            this.oaq.setVisibility(8);
        }
        aX();
        aF(true, i());
        this.e = false;
        m(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.obq != null && this.obq.a(i, keyEvent)) {
                return true;
            }
            if (this.nVp != null && this.nVp.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.nVq != null && this.nVq.onKeyDown(i, keyEvent)) || edN()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nVH != null && this.nVH.getVisibility() == 0 && a(motionEvent, this.nVH)) {
                this.nVH.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dV(this.nVG);
                return true;
            } else if (this.nVj && this.nVH != null && this.nVH.getVisibility() == 8 && f(this.obd.b, motionEvent)) {
                edG();
                return true;
            } else if (this.nVp != null && this.nVp.b() && f(this.nVp, motionEvent)) {
                this.nVp.a();
                return true;
            } else if (this.nVq != null && this.nVq.b() && f(this.nVq, motionEvent)) {
                this.nVq.a();
                return true;
            } else if (a(motionEvent, this.nUM)) {
                return edM();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean edM() {
        boolean z;
        b(this.nVr, 10);
        boolean z2 = false;
        if (this.nVb != null && this.nVb.getVisibility() == 0) {
            this.nVb.setVisibility(8);
            this.nVc.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
            this.nVc.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nUM == null || this.nUM.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nVa) {
                edU();
            }
            this.nUM.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nUG != null && a.this.bB == 2) {
                        a.this.nUG.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean edN() {
        if (edM()) {
            return true;
        }
        if (this.oaY == null || !this.oaY.isShowing()) {
            return edG() || edF() || dQP();
        }
        this.oaY.dismiss();
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
        this.nUG.setVisibility(8);
        this.nUM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(boolean z, boolean z2) {
        if (this.nUG != null) {
            if (z) {
                if (this.nUG.getVisibility() != 0) {
                    this.nUG.setVisibility(0);
                    this.nUG.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_bottom_anim));
                }
            } else if (this.nUG.getVisibility() != 4) {
                this.nUG.setVisibility(4);
                this.nUG.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nUy != null) {
            this.nUy.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a edO() {
        return this.nVv;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.oax != null) {
                        this.oax.f = null;
                        this.oax.edj().mRoominfo.mGameId = null;
                    }
                    edB();
                    return;
                }
                g.Pk(a.i.str_getvideosource_failed);
            }
            yG(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.oax != null && this.oax.edk() != null) {
            a(this.oax.edk());
        }
        this.p = false;
        if (this.oax == null || this.oax.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.oax.f.size()) {
                if (!"2".equals(this.oax.f.get(i2).mType)) {
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
        if (this.nUp != null) {
            this.nUp.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nUB != null && this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                this.nUB.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.oax.edj().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.nVo && (c = c(1, -1)) >= 0 && c < this.nVn.size() && this.nVh != null) {
            this.nVh.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nVo) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.oay, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b ecR = ((VideoPlayer) this.oay).ecR();
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(2, ecR);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a ecS = ((VideoPlayer) this.oay).ecS();
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(2, ecS);
            } else if (bVar.a == 9) {
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nVb != null) {
            this.nVb.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nVo) {
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
        if (!aa() && this.oax != null) {
            String str = this.oax.a;
            RoomInfo edl = this.oax.edl();
            if (edl != null && mVar.a(edl.mCreatorUID, str)) {
                edl.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nUN != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nUN);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
            if (this.nVk == null) {
                this.nVk = new f(getActivity());
            }
            this.nVk.a(this.oax.edj().mRoominfo);
            if (!this.nVk.isShowing()) {
                this.nVk.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nUp != null) {
            this.nUp.d();
        }
    }

    private void e(View view) {
        this.nUC = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nUD = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nUD.setText(new tv.chushou.zues.widget.a.c().N(this.oay, a.e.videoplayer_4g_video).append("  ").append(this.oay.getString(a.i.videoplayer_4g_video)));
        this.nUE = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nUE.setText(new tv.chushou.zues.widget.a.c().N(this.oay, a.e.videoplayer_4g_audio).append("  ").append(this.oay.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nUC.setVisibility(8);
                    ((VideoPlayer) a.this.oay).c(a.this.nUF);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nUC.setVisibility(8);
                    ((VideoPlayer) a.this.oay).d(a.this.nUF);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.ecq().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nUD.setOnClickListener(onClickListener);
        this.nUE.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.oax != null && !h.isEmpty(this.oax.f)) {
            g(this.oax.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nUF = z;
            this.p = false;
            if (this.oax != null && this.oax.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.oax.f.size()) {
                        break;
                    } else if (!"2".equals(this.oax.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nUC != null) {
                this.nUC.setVisibility(0);
                this.nUD.setVisibility(0);
                this.nUE.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nUC != null) {
            this.nUC.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nVz == null) {
                this.nVz = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.oaz != null) {
                    this.oaz.e(this.nVz, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nVz != null && this.oaz != null) {
            this.oaz.L(this.nVz);
            this.nVz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nUp != null) {
            com.kascend.chushou.toolkit.a.c.a(this.oay, "显示双击666_num", null, new Object[0]);
            if (this.oax != null) {
                this.oax.b(false);
            }
            d(false);
            this.nUp.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.oaj != null) {
            if (this.nVq == null) {
                this.nVq = (InteractionView) ((ViewStub) this.oaj.findViewById(a.f.view_interaction)).inflate();
                this.nVq.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.nVq.a();
                    }
                });
            }
            if (this.nVq != null) {
                this.nVq.b(configDetail);
                this.nVq.c();
                this.nVq.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eqo()) {
                g.K(this.oay, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.oay, null) && (this.oay instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.oax != null) {
                com.kascend.chushou.toolkit.a.c.a(this.oay, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.oax != null) {
                com.kascend.chushou.toolkit.a.c.a(this.oay, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.oay, configDetail.mUrl, this.oay.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.oay, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    edP();
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

    private void edP() {
        if (this.nVj) {
            edG();
            return;
        }
        if (this.oay.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.oay, "点击送礼_num", "竖屏", new Object[0]);
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.oax.edj().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.oay != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nUa == null) {
                this.nUa = new com.kascend.chushou.player.e.a();
            }
            this.nUa.b = str;
            this.nUa.nWR.copy(pkNotifyInfo);
            if (this.nUa.nWR.mAction == 6) {
                this.nUa.nWR.mInPKMode = true;
                this.u = this.nUa.nWR.mPkId;
            } else if (this.nUa.nWR.mAction == 7 || (this.nUa.nWR.mMode == 1 && this.nUa.nWR.mAction == 5)) {
                this.nUa.nWR.mInPKMode = true;
                this.u = this.nUa.nWR.mPkId;
                if (edR() != null) {
                    if (2 == this.bB && this.nVC != null) {
                        this.nVC.setVisibility(0);
                    }
                    edR().b(this.nUa.nWR, false);
                    edR().a(this.nUa.nWR.mMode, "1");
                    if (this.nUa.nWR.mAction == 5 && this.nUa.nWR.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nUa.nWR.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nUa.nWR.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nUa.nWR.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nUa.nWR.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nUa.nWR.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        edR().a(this.nUa.nWR);
                        if (this.nUa.nWR.destinyInfo == null || this.nUa.nWR.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        edR().a(parseInt, this.nUa.nWR.mPkUpdateInfo.remainDuration, j, this.nUa.nWR.mMode, i);
                    }
                    if (!h.isEmpty(this.nUa.nWR.mPkUpdateInfo.specialMomentList) && edR() != null) {
                        edR().a(this.nUa.nWR, true);
                    }
                }
                edQ();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.VC(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.nUa.nWR.mInPKMode = false;
                edQ();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.VC(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void edQ() {
        if (this.nUa != null && this.nUa.nWR != null) {
            if (this.nUa.nWR.mInPKMode) {
                this.y.setText(this.nUa.nWR.mPkUserNickname);
                this.nUc.setVisibility(0);
                if (this.oao != null) {
                    this.oao.setEnabled(false);
                }
                if (this.oaq != null) {
                    this.oaq.setEnabled(false);
                    return;
                }
                return;
            }
            this.nUc.setVisibility(8);
            if (this.oao != null) {
                this.oao.setEnabled(true);
            }
            if (this.oaq != null) {
                this.oaq.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b edR() {
        if (this.oay == null || this.oaj == null || this.nVC == null) {
            return null;
        }
        if (this.nUb == null) {
            if (this.nVB == null) {
                this.nVB = ((ViewStub) this.oaj.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.nUb = new com.kascend.chushou.player.e.b();
            this.nUb.a(this.nVC, this.nVB, (View) null, this.oay, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cyX()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.oax != null) {
                        append.append(a.this.oax.edl().mRoomID);
                    }
                    if (a.this.nUa != null && a.this.nUa.nWR != null) {
                        append.append("&mode=").append(a.this.nUa.nWR.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.oay, append.toString());
                }
            });
        }
        return this.nUb;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nUY != null && this.oax != null && this.oax.nTI != null) {
            this.nUY.setText(tv.chushou.zues.utils.b.Pj(this.oax.nTI.count));
            this.nUY.setVisibility(0);
            if (this.oax.nTI.count < 1) {
                edU();
            }
            if (this.nUQ != null) {
                this.nUQ.setText(this.oax.nTI.primaryName);
            }
            if (this.nUR != null) {
                this.nUR.setText(this.oax.nTI.desc);
            }
            edS();
        }
    }

    public void edS() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nUZ * h.parseLong(this.oax.nTI.point)));
        if (this.nUT != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.oay.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.N(this.oay, a.e.icon_coin_new);
            cVar.append(this.oay.getString(a.i.str_buy_count_coin2));
            this.nUT.setText(cVar);
        }
    }

    private void edT() {
        if (com.kascend.chushou.d.e.c(this.oay, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nUZ);
        }
    }

    private void v(boolean z) {
        if (this.oaj != null && this.nVC != null) {
            if (z) {
                if (this.nUa != null && this.nUa.nWR != null && this.nUa.nWR.mInPKMode) {
                    this.nVC.setVisibility(0);
                    return;
                }
                return;
            }
            this.nVC.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.oaj != null && this.nUf != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nUf.setVisibility(0);
                    return;
                }
                return;
            }
            this.nUf.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.nUa != null && this.nUa.nWR != null && this.nUa.nWR.mInPKMode && this.nUc != null) {
                this.nUc.setVisibility(0);
            }
        } else if (this.nUc != null) {
            this.nUc.setVisibility(8);
        }
    }

    private void edU() {
        this.nVa = false;
        this.nUX.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.oax != null && this.oax.nTI != null) {
            if (this.oax.nTI.count < 1) {
                this.nUY.setVisibility(8);
            } else {
                this.nUY.setVisibility(0);
                this.nUY.setSelected(false);
                this.nUY.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nUP.setVisibility(8);
        if (this.nUN != null) {
            this.nUN.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        edP();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nUL != null) {
            this.nUL.performClick();
        }
    }

    public boolean edV() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.nVO = true;
        if (this.oaj != null && com.kascend.chushou.b.ecq().d == 0) {
            this.nVx = tv.chushou.zues.utils.systemBar.b.hg(getActivity());
            if (!z) {
                View findViewById = this.oaj.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.nVx = tv.chushou.zues.utils.systemBar.b.hg(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.nVx);
            View findViewById2 = this.oaj.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.nVx);
            findViewById2.requestLayout();
        }
    }
}
