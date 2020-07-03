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
    private MarqueeTextView nhA;
    private MarqueeTextView nhB;
    private ImageView nhC;
    private ImageView nhD;
    private ImageButton nhE;
    public String nhF;
    private RecommendView nhG;
    private TextView nhJ;
    private RelativeLayout nhK;
    private TextView nhL;
    private TextView nhM;
    private boolean nhN;
    private RelativeLayout nhO;
    private View nhP;
    private FrescoThumbnailView nhQ;
    private AnimationSet nhR;
    private ImageView nhS;
    private TextView nhT;
    private RelativeLayout nhU;
    private PastedEditText nhV;
    private TextView nhW;
    private LinearLayout nhX;
    private TextView nhY;
    private TextView nhZ;
    private int[] nhu;
    private Fragment[] nhv;
    private ImageView nhz;
    private PopH5Menu niA;
    private InteractionView niB;
    private int niC;
    private PopupWindow niD;
    private TextView niE;
    private GiftAnimationLayout niF;
    private com.kascend.chushou.player.b.a niG;
    private Runnable niK;
    private View niM;
    private LivePKBarUserValue niN;
    private String niO;
    private TextView niP;
    private ImageView niQ;
    private EditText niR;
    private View niS;
    private View niT;
    private View niU;
    private String niX;
    private TextView nia;
    private TextView nib;
    private TextView nic;
    private TextView nie;
    private TextView nif;
    private ImageView nig;
    private TextView nih;
    private KPSwitchPanelLinearLayout nik;
    private ImageView nil;
    private c nin;
    private d.a nio;
    private FrescoThumbnailView nip;
    private PagerSlidingTabStrip niq;
    private KasViewPager nir;
    private LinearLayout nis;
    private f niu;
    private ViewMicPerson niv;
    public ArrayList<RoomTab> nix;
    private long nho = 0;
    private com.kascend.chushou.view.user.a nhw = null;
    private com.kascend.chushou.player.ui.a nhx = null;
    private int bB = -1;
    private int bC = 0;
    private View nhy = null;
    private View nhH = null;
    private ImageButton nhI = null;
    private int nii = 1;
    private boolean nij = false;
    private boolean nim = false;
    private boolean nit = false;
    private boolean cx = false;
    private boolean niw = false;
    private boolean niy = false;
    private boolean niz = true;
    private int niH = 0;
    private int niI = 0;
    private int niJ = -1;
    private final Rect niL = new Rect();
    private boolean niV = false;
    private C0820a niW = null;
    private boolean da = false;
    private boolean niY = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhF = getArguments().getString("mCover");
        this.niz = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nnq = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.nnq;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            c(view);
            dJO();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.niy = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.nok != null) {
            this.nok.b();
        }
        if (this.nnG != null && (this.nnG instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnG).wW(true);
            ((VideoPlayer) this.nnG).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.niy = true;
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
        this.nii = 1;
        this.nij = false;
        U();
        if (this.nnH != null) {
            this.nnH.ch(null);
            this.nnH = null;
        }
        if (this.nhG != null) {
            dKA().removeAllViews();
            this.nhG = null;
        }
        this.c = null;
        this.nhc = null;
        tv.chushou.zues.a.a.ci(this);
        this.niq = null;
        this.nir = null;
        this.nhx = null;
        this.nhw = null;
        if (this.nhv != null) {
            for (int i = 0; i < this.nhv.length; i++) {
                this.nhv[i] = null;
            }
        }
        this.nhv = null;
        if (this.nhV != null) {
            this.nhV.addTextChangedListener(null);
            this.nhV.setOnTouchListener(null);
            this.nhV.setOnEditorActionListener(null);
            this.nhV = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nnG, this.nin);
        if (this.nnG != null && (this.nnG instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnG).dJf();
        }
        this.nio = null;
        this.nin = null;
        if (this.niv != null) {
            this.niv.b();
            this.niv = null;
        }
        if (this.niD != null) {
            this.niD.dismiss();
        }
        if (this.niG != null) {
            this.niG.a();
            this.niG = null;
            this.niF = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.niN = (LivePKBarUserValue) this.nnq.findViewById(a.f.live_pk_bar_user);
        this.nnz = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.niV) {
            this.niV = true;
            if (this.niT == null) {
                this.niT = this.nnq.findViewById(a.f.vs_async_view);
                this.niT = ((ViewStub) this.niT).inflate();
            }
            if (this.niU == null) {
                this.niU = this.nnq.findViewById(a.f.vs_async_notification_view);
                this.niU = ((ViewStub) this.niU).inflate();
            }
            this.nhn = (VoiceInteractionView) this.nnq.findViewById(a.f.voiceInteractiveView);
            t();
            dt(this.nnq);
            ar();
            ((VideoPlayer) this.nnG).q();
            this.nhi = new com.kascend.chushou.player.e.a();
        }
    }

    private void dt(View view) {
        this.nip = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.niq = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.nir = (KasViewPager) view.findViewById(a.f.vp_main);
        dJP();
        aI();
        aN();
        if (this.nnF != null) {
            I();
            a(this.nnF.ngO, this.nnF.ngR);
        }
        this.bb = 0;
        this.nop = 0L;
        this.nol = (RoundProgressBar) this.nnq.findViewById(a.f.roundProgressBar);
        this.nom = (TextView) this.nnq.findViewById(a.f.tv_paonum);
        this.non = (FrescoThumbnailView) this.nnq.findViewById(a.f.iv_paoicon);
        this.nov = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.nit = false;
                if (a.this.bB == 2) {
                    a.this.aw(true, a.this.i());
                } else {
                    a.this.dKi();
                }
                a.this.b(a.this.niC, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.nit = true;
                if (a.this.bB == 2) {
                    a.this.aw(false, a.this.i());
                } else {
                    a.this.dKi();
                }
                if (a.this.nok != null) {
                    a.this.nok.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gw(a.this.nnG).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nnG)) - a.this.nok.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nnG, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nnG, 54.0f) * 2);
                    if (statusBarHeight < a.this.niC) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.noo = (PaoGuideView) this.nnq.findViewById(a.f.rlPaoGuideView);
        this.niv = (ViewMicPerson) this.nnq.findViewById(a.f.rl_mic_person_view);
    }

    private void dJO() {
        this.nkb = ((VideoPlayer) this.nnG).dIY();
        this.nnF = ((VideoPlayer) this.nnG).dJb();
        du(this.nnq);
        this.niH = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
        this.niI = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (com.kascend.chushou.b.dII().d == 0 && this.niI > 0) {
            View findViewById = this.nnq.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.niI);
        }
        dJX();
        dJV();
        if (!this.niz) {
            Q();
        }
        dJT();
        a();
        if (this.c == null) {
            this.nhc = new d.a();
            this.c = new GestureDetector(this.nnG, this.nhc);
        }
        this.nhe = ((VideoPlayer) this.nnG).dJc();
        this.nhe.a(this);
        if (this.niG != null) {
            this.niG.a();
            this.niG = null;
        }
        this.niF = (GiftAnimationLayout) this.nnq.findViewById(a.f.ll_gift_animation);
        this.niF.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.nnF != null) {
            this.niG = new com.kascend.chushou.player.b.a(this.nnG.getApplicationContext(), this.niF);
            this.niG.a(this.nnF);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.nnq.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nnA = (PlayerErrorView) this.nnq.findViewById(a.f.view_net_error_msg);
        this.nnA.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dJR();
        dKb();
        if (this.nnF.dJC() != null) {
            a(this.nnF.dJC());
        }
        FullRoomInfo dJB = this.nnF.dJB();
        if (dJB != null) {
            dKd();
            if (i()) {
                this.ak = false;
                m(true);
                this.nnH.Lz(8);
            }
            this.nhJ.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dJB.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.nhy.setVisibility(0);
        this.ak = false;
        m(true);
        this.nnH.Lz(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nnG).n();
        if (this.nnF != null && !h.isEmpty(this.nnF.w)) {
            b(this.nnF.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dJm;
        dJP();
        k();
        FullRoomInfo dJB = this.nnF.dJB();
        if (dJB != null) {
            if (dJB.mRoominfo != null) {
                this.nhJ.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dJB.mRoominfo.mOnlineCount)));
                this.niO = dJB.mRoominfo.mRoomID;
            }
            dKd();
            if (!h.isEmpty(dJB.mRoomToastList)) {
                Iterator<RoomToast> it = dJB.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dIP().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.nnF != null && this.nnF.l()) {
                d(true);
            }
            if (this.nnG != null && (this.nnG instanceof VideoPlayer) && (dJm = ((VideoPlayer) this.nnG).dJm()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dJm.nkc, dJm.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.nis);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dJP() {
        boolean z = true;
        if (this.nnF == null || this.nnF.dJB() == null || this.nnF.dJB().mRoominfo == null || h.isEmpty(this.nnF.dJB().mRoomTabs)) {
            this.niw = false;
            this.nhv = new Fragment[2];
            this.nhu = new int[2];
            this.nhu[0] = 2;
            this.nhu[1] = 1;
            return;
        }
        this.niw = true;
        this.nix = new ArrayList<>();
        Iterator<RoomTab> it = this.nnF.dJB().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.nix.add(next);
            }
        }
        if (this.nix.size() >= 2 && this.nhu != null && this.nhu.length >= 2 && this.nix.get(0).type == this.nhu[0] && this.nix.get(1).type == this.nhu[1]) {
            z = false;
        }
        this.nhv = new Fragment[this.nix.size()];
        this.nhu = new int[this.nix.size()];
        for (int i = 0; i < this.nix.size(); i++) {
            this.nhu[i] = this.nix.get(i).type;
        }
        if (z) {
            this.niW = new C0820a(getChildFragmentManager());
            this.nir.setAdapter(this.niW);
        }
    }

    private void aI() {
        this.nhU = (RelativeLayout) this.nnq.findViewById(a.f.rl_edit_bar);
        this.nhQ = (FrescoThumbnailView) this.nnq.findViewById(a.f.btn_hotword);
        this.nhQ.zs(a.e.ic_hotwords_black_n);
        this.nhQ.setOnClickListener(this);
        this.nhS = (ImageView) this.nnq.findViewById(a.f.iv_task_badge);
        this.nhR = (AnimationSet) AnimationUtils.loadAnimation(this.nnG, a.C0814a.anim_hotword);
        this.nhR.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dIP().c) {
                    a.this.nhQ.clearAnimation();
                    a.this.nhQ.startAnimation(a.this.nhR);
                }
            }
        });
        if (com.kascend.chushou.d.h.dIP().c) {
            this.nhQ.startAnimation(this.nhR);
            this.nhS.setVisibility(0);
        }
        this.nhT = (TextView) this.nnq.findViewById(a.f.tv_bottom_input);
        this.nhT.setOnClickListener(this);
        this.noG = (FrescoThumbnailView) this.nnq.findViewById(a.f.ll_btn_set);
        this.noG.setOnClickListener(this);
        this.nis = (LinearLayout) this.nnq.findViewById(a.f.ll_bottom_all_button);
        this.nhO = (RelativeLayout) this.nnq.findViewById(a.f.rl_bottom_input);
        this.nhP = this.nnq.findViewById(a.f.ll_bottom_input);
        this.nhO.setVisibility(8);
        this.nhV = (PastedEditText) this.nnq.findViewById(a.f.et_bottom_input);
        this.nhV.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nhW.setEnabled(editable.length() > 0);
            }
        });
        this.nhV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nhW);
                    return true;
                }
                return true;
            }
        });
        this.nhV.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.nhV);
                }
                return false;
            }
        });
        this.nil = (ImageView) this.nnq.findViewById(a.f.iv_btn_emoji);
        this.nil.setVisibility(8);
        this.nhW = (TextView) this.nnq.findViewById(a.f.tv_btn_send);
        this.nhW.setOnClickListener(this);
        this.nik = (KPSwitchPanelLinearLayout) this.nnq.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dII().d == 0) {
            this.nik.setUseStatusBar(true);
        }
        this.nhX = (LinearLayout) this.nnq.findViewById(a.f.head_trumpet);
        this.nhX.setVisibility(8);
        this.nhX.setOnClickListener(this);
        this.nhY = (TextView) this.nnq.findViewById(a.f.tv_primary_name);
        this.nhZ = (TextView) this.nnq.findViewById(a.f.tv_primary_desc);
        this.nic = (TextView) this.nnq.findViewById(a.f.tv_cut_count);
        this.nic.setOnClickListener(this);
        this.nif = (TextView) this.nnq.findViewById(a.f.tv_head_count);
        this.nif.setText(this.nii + "");
        this.nie = (TextView) this.nnq.findViewById(a.f.tv_plus_count);
        this.nie.setOnClickListener(this);
        this.nib = (TextView) this.nnq.findViewById(a.f.tv_buy_count_coin);
        this.nia = (TextView) this.nnq.findViewById(a.f.tv_buy_head);
        this.nia.setOnClickListener(this);
        this.nig = (ImageView) this.nnq.findViewById(a.f.iv_trumpet_select);
        this.nig.setOnClickListener(this);
        this.nih = (TextView) this.nnq.findViewById(a.f.tv_trumpet_have_count);
        this.nij = false;
        this.nig.setBackgroundResource(a.e.ic_trumpet_n);
        this.nih.setVisibility(8);
        aK();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nik, this.nil, this.nhV, new a.InterfaceC0944a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0944a
            public void wX(boolean z) {
                if (a.this.nil != null) {
                    if (!z) {
                        a.this.nil.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dII().d == 0) {
                        a.this.nik.setDirectVisibility(0);
                    }
                    a.this.nil.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nio = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wY(boolean z) {
                if (a.this.niY) {
                    a.this.niY = false;
                    return;
                }
                a.this.nim = z;
                if (z) {
                    a.this.nil.setImageResource(a.e.cs_emoji_normal);
                    a.this.dJQ();
                    return;
                }
                if (a.this.niS != null && a.this.niS.getVisibility() == 0) {
                    a.this.niS.setVisibility(8);
                }
                if (a.this.nit) {
                    a.this.nok.setVisibility(0);
                }
                if (a.this.nnG != null && (a.this.nnG instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nnG).wW(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.nin = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nik, this.nio, ((VideoPlayer) this.nnG).dJg());
        ((VideoPlayer) this.nnG).h(((VideoPlayer) this.nnG).dJg());
        this.niS = this.nnq.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.niP = (TextView) this.nnq.findViewById(a.f.btn_room_search);
        this.niQ = (ImageView) this.nnq.findViewById(a.f.iv_room_emoji_delete);
        this.niR = (EditText) this.nnq.findViewById(a.f.et_room_emoji_search);
        this.niR.setImeOptions(3);
        this.niR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.niP);
                    return true;
                }
                return false;
            }
        });
        this.niR.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.niP.setEnabled(editable.length() > 0);
                a.this.niQ.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.nok.setEmojiSearchText(editable.toString());
            }
        });
        this.niP.setOnClickListener(this);
        this.niQ.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void au(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dE(this.niR);
            this.niS.setVisibility(0);
            this.niR.requestFocus();
        } else {
            this.niS.setVisibility(8);
        }
        if (z2) {
            this.niR.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJQ() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gw(this.nnG).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG)) - tv.chushou.zues.widget.kpswitch.b.d.gJ(this.nnG)) - tv.chushou.zues.utils.a.dip2px(this.nnG, 14.0f)) - this.nnG.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nnG, 54.0f) * 2);
        if (statusBarHeight < this.niC) {
            b(statusBarHeight, 10);
        }
    }

    private void aK() {
    }

    private void dJR() {
        this.nnH = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.av(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.nnq.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nnG.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nnH.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nnH.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nnH.B(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nnH);
                            break;
                        case 12:
                            a.this.b(a.this.nnH);
                            break;
                        case 17:
                            a.this.as();
                            break;
                        case 18:
                            a.this.dxy();
                            break;
                        case 19:
                            a.this.nnE.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dJS() {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nix)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nix.size()) {
                    if (!h.isEmpty(this.nix.get(i2).notifyIcon)) {
                        this.niq.bM(i2, this.nix.get(i2).notifyIcon);
                        this.niq.LY(i2);
                    } else if (this.nix.get(i2).notify == 1) {
                        this.niq.LX(i2);
                        this.niq.LW(i2);
                    } else {
                        this.niq.LW(i2);
                        this.niq.LY(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nix)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.nix.size()) {
                    if (this.nix.get(i4).type == i) {
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
    public String Ke(int i) {
        if (this.nnF == null || this.nnF.dJB() == null || this.nnF.dJB().mRoominfo == null || h.isEmpty(this.nix)) {
            if (i == 1) {
                return this.nnG.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nnG.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.nix.size()) {
            return this.nix.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nix) && i < this.nix.size()) {
            this.nix.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nix) && i < this.nix.size()) {
            this.nix.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.nir != null && this.niq != null && this.nhu != null) {
            this.nhx = null;
            if (this.nhv != null) {
                for (int i = 0; i < this.nhv.length; i++) {
                    this.nhv[i] = null;
                }
            }
            if (this.niW == null) {
                this.niW = new C0820a(getChildFragmentManager());
                this.nir.setAdapter(this.niW);
            } else {
                this.niW.notifyDataSetChanged();
            }
            this.nir.setOffscreenPageLimit(this.nhu.length);
            this.niq.c(this.nir);
            this.niq.setOnPageChangeListener(this);
            this.niq.notifyDataSetChanged();
            this.niq.setVisibility(0);
            this.nir.setVisibility(0);
            if (!this.niw) {
                this.bB = 2;
                this.nir.setCurrentItem(c(2, 0));
                this.nhO.setVisibility(0);
            } else {
                if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                    if (!h.isEmpty(this.nnF.dJB().mRoominfo.mGameName)) {
                        this.nhB.setText(this.nnF.dJB().mRoominfo.mGameName);
                    } else {
                        this.nhB.setText(this.nnG.getString(a.i.no_online_game_name));
                    }
                    this.nhA.setText(this.nnF.dJB().mRoominfo.mName);
                } else {
                    this.nhB.setText(this.nnG.getString(a.i.no_online_game_name));
                }
                dJS();
                if (i()) {
                    aU();
                    if (this.nir != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.nir.setCurrentItem(c);
                        this.niq.setSelectItem(c);
                    }
                } else if (this.nir != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.nir.setCurrentItem(c2);
                    this.niq.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dJT() {
        this.N = new SurfaceView(this.nnG);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dKA().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dJU() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nnG).s();
        dxD();
        az();
        dJN();
        dKA().setBackgroundResource(a.e.room_not_online);
        if (this.nhG == null) {
            this.nhG = new RecommendView(this.nnG);
            dKA().addView(this.nhG);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nnG);
            this.nhG.setLayoutParams(layoutParams);
        }
        if (this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nnF.dJB().mRoominfo.mRoomID)) {
            this.nhG.a(this.nnF.dJB().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.nnG != null && a.this.dKA() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nnG);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.mNm);
                        if (a.this.dKA().getChildCount() >= 2) {
                            a.this.dKA().addView(frescoThumbnailView, 0);
                        }
                        a.this.dKA().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dWv(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nos != null) {
            this.nos.dVQ();
            this.nos.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.nok != null) {
            this.nok.e();
        }
        m(false);
        a(false, false);
        if (this.nhe != null) {
            this.nhe.d();
        }
    }

    private void dJV() {
        int i = 0;
        this.nhy = this.nnq.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dII().d == 0 && this.niH > 0) {
            View findViewById = this.nnq.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.niH;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nhz = (ImageView) this.nhy.findViewById(a.f.back_icon);
        this.nhz.setOnClickListener(this);
        this.nhA = (MarqueeTextView) this.nhy.findViewById(a.f.tv_title);
        this.nhB = (MarqueeTextView) this.nhy.findViewById(a.f.tv_Type);
        this.nhD = (ImageView) this.nnq.findViewById(a.f.btn_setting);
        this.nhH = this.nnq.findViewById(a.f.bottomview);
        if (this.nnx == null) {
            this.nnx = (ImageButton) this.nhH.findViewById(a.f.btn_barrage);
            this.nnx.setOnClickListener(this);
            if (this.nnF != null) {
                if (com.kascend.chushou.d.h.dIP().n()) {
                    this.nnx.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nnx.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.nny = (ImageButton) this.nhH.findViewById(a.f.btn_audio);
        this.nny.setOnClickListener(this);
        if (this.nnF != null && this.nnF.d) {
            this.nny.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.nny.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.nnF != null && this.nnF.f != null) {
            while (true) {
                if (i >= this.nnF.f.size()) {
                    break;
                } else if (!"2".equals(this.nnF.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nhI = (ImageButton) this.nhH.findViewById(a.f.playbutton);
        this.nhI.setOnTouchListener(this);
        this.nhE = (ImageButton) this.nhH.findViewById(a.f.btn_refresh);
        this.nhE.setOnClickListener(this);
        this.nhJ = (TextView) this.nhH.findViewById(a.f.tv_online_count);
        if (this.nnw == null) {
            this.nnw = (ImageButton) this.nhH.findViewById(a.f.btn_screenChange);
            this.nnw.setOnClickListener(this);
        }
        if (this.nhC == null) {
            this.nhC = (ImageView) this.nhy.findViewById(a.f.report_icon);
            this.nhC.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void ds(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nhx != null) {
                        this.nhx.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                        this.nnF.dJB().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nnF.dJB().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.nnF.dJB().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.nnF.dJB().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.nnF.dJB().mRoominfo.mCreatorUID);
                            }
                        } else if (this.nnF.dJB().mMicStatus.onMic) {
                            this.nnF.dJB().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nnF.dJB().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.nnF.dJB().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.nnF.dJB().mMicStatus != null && !h.isEmpty(this.nnF.dJB().mMicStatus.micRoomId) && !this.nnF.dJB().mMicStatus.micRoomId.equals("0")) {
                                this.niX = this.nnF.dJB().mMicStatus.micRoomId;
                            }
                            if (this.nhx != null) {
                                this.nhx.a(this.nnF.dJB().mMicStatus, this.nnF.dJB().mFanItems, str, z2);
                            }
                            if (this.niv != null && this.niv.getVisibility() == 0) {
                                this.niv.a(this.nnF.dJB().mFanItems, this.nnF.dJB().mMicStatus, str, z2, this.nnF.dJB().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nhx != null) {
                                this.nhx.e();
                            }
                            if (this.niv != null && this.niv.isShown()) {
                                this.niv.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nhx != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nhx.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nhx.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.niJ != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.niJ = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nhi != null && this.nhi.nkc != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nhi.nkc.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nhi.nkc.mInPKMode = true;
                                    this.nhi.nkc.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhi.nkc.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhi.nkc.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhi.nkc.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhi.nkc.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhi.nkc.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nhi.nkc.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nhi.nkc.mMode = pkNotifyInfo.mMode;
                                    this.nhi.nkc.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dKk() != null) {
                                        dKk().g(true, this.nhi.nkc.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dIP().a) {
                                        if (!com.kascend.chushou.b.dII().e) {
                                            com.kascend.chushou.b.dII().e = true;
                                            g.F(this.nnG, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dIP().a(this.nnG, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.niN != null) {
                                        this.niN.setVisibility(0);
                                    }
                                    this.nhi.nkc.mAction = 7;
                                    this.nhi.nkc.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhi.nkc.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhi.nkc.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhi.nkc.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhi.nkc.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhi.nkc.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dKk() != null) {
                                        dKk().g(false, 0L);
                                        dKk().b(this.nhi.nkc, true);
                                        dKk().a(this.nhi.nkc.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Rk(this.niO);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.nhi.nkc.mInPKMode = false;
                                    this.nhi.nkc.mAction = 2;
                                    bd();
                                    if (dKk() != null) {
                                        dKk().c();
                                    }
                                    if (com.kascend.chushou.d.h.dIP().a) {
                                        if (!com.kascend.chushou.b.dII().e) {
                                            com.kascend.chushou.b.dII().e = true;
                                            g.F(this.nnG, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dIP().a(this.nnG, false);
                                        ak();
                                    }
                                    this.nhi.b = null;
                                    this.nhi.nkc = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Rk(this.niO);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nhi.nkc.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nhi.nkc.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.nhi.nkc.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nnF.dJB().mRoominfo.mRoomID) && this.nnF.dJB().mRoominfo.mRoomID.equals(this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dKk() != null) {
                                        dKk().a(this.nhi.nkc, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nhi.nkc.copyUpdate(pkNotifyInfo);
                                    if (dKk() != null) {
                                        dKk().a(this.nhi.nkc);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nhi.nkc.copyStop(pkNotifyInfo);
                                        if (dKk() != null) {
                                            dKk().A(this.nhi.nkc.mMaxFreeDuration, this.nhi.nkc.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nhi.nkc.copyResult(pkNotifyInfo);
                                    if (!this.niy && dKk() != null) {
                                        int i5 = 1;
                                        if (this.nhi.nkc.destinyInfo != null && this.nhi.nkc.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dKk().a(h.parseInt(this.nhi.nkc.mResult), h.parseLong(this.nhi.nkc.mvpUid), this.nhi.nkc.mvpAvatar, this.nhi.nkc.mvpNickname, this.nhi.nkc.mMaxFreeDuration, this.nhi.nkc.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nhx != null) {
                if (LoginManager.Instance().islogined() && this.nnF != null && this.nnF.l()) {
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
                if (this.nnF == null || this.nnF.dJB() == null || this.nnF.dJB().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.nnF.dJB().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dIP().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dIP().b().equals(next2.mUserID)) {
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
                this.nhx.a(arrayList, true, false);
                this.nhx.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nhu != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nhu.length) {
                    break;
                }
                if (this.nhu[i2] == 99 && this.nhv != null && this.nhv[i2] != null && (this.nhv[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nhv[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.nix.size() && this.niq != null) {
                if (i == 0) {
                    this.niq.setTagText(i2, new StringBuilder(this.nix.get(i2).name).toString());
                    return;
                } else {
                    this.niq.setTagText(i2, this.nix.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.nnx != null) {
            if (z) {
                this.nnx.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nnx.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dJW() {
        if (this.nnq == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nnq.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
        this.ar = Math.min(gw.x, gw.y);
        this.aq = (this.ar * this.nnG.getResources().getInteger(a.g.h_thumb_height_def)) / this.nnG.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dKA().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nnz.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.niC = this.aq + this.nnG.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nnG, 54.0f);
        b(this.niC, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dJX() {
        Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
        this.ar = Math.min(gw.x, gw.y);
        this.aq = (this.ar * this.nnG.getResources().getInteger(a.g.h_thumb_height_def)) / this.nnG.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dKA().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nnz.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.niC = this.aq + this.nnG.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nnG, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.niC, 10);
        k();
        if (!h.isEmpty(this.nhF)) {
            File ag = tv.chushou.zues.widget.fresco.a.ag(Uri.parse(this.nhF));
            if (ag != null && ag.exists()) {
                this.nnz.setImageURI(Uri.fromFile(ag));
                this.nnz.setVisibility(0);
                return;
            }
            this.nnz.setVisibility(8);
            return;
        }
        this.nnz.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        av(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nhC != null) {
            this.nhC.setVisibility(z ? 0 : 4);
        }
        if (this.nhD != null) {
            this.nhD.setVisibility(z ? 0 : 4);
        }
    }

    public boolean av(boolean z, boolean z2) {
        return k(z, z2, this.f);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.nnH != null) {
            this.nnH.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nnG).f(true);
            if (!z3) {
                if (this.nhH.getVisibility() != 0 && z2) {
                    this.nhH.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.nny.setVisibility(0);
                } else {
                    this.nny.setVisibility(8);
                }
                this.nhH.setVisibility(0);
            }
            PlayUrl dJC = this.nnF.dJC();
            if (dJC != null && "2".equals(dJC.mType)) {
                if (this.nnw != null) {
                    this.nnw.setVisibility(8);
                }
            } else if (this.nnw != null) {
                this.nnw.setVisibility(0);
            }
            if (this.nhy.getVisibility() != 0 && z2) {
                this.nhy.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_top_anim));
            }
            t(!z3);
            this.nhy.setVisibility(0);
            w(true);
            if (this.nnH != null) {
                this.nnH.B(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nnG).f(false);
            if (this.nnX != null) {
                this.nnX.dismiss();
            }
            if (this.nnY != null) {
                this.nnY.dismiss();
            }
            if (this.nhH.getVisibility() != 8 && z2) {
                this.nhH.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_bottom_anim));
            }
            this.nhH.setVisibility(8);
            if (this.nhy.getVisibility() != 8 && z2) {
                this.nhy.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_top_anim));
            }
            this.nhy.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dxD() {
        if (this.noo == null || !this.noo.isShown()) {
            return false;
        }
        this.noo.d();
        return true;
    }

    public boolean az() {
        if (this.niv == null || !this.niv.isShown()) {
            return false;
        }
        this.niv.a();
        return true;
    }

    public boolean dJN() {
        if (this.niA == null || !this.niA.b()) {
            return false;
        }
        this.niA.a();
        return true;
    }

    public boolean dJY() {
        if (this.nit && this.nok != null) {
            if (this.nok != null) {
                this.nok.e();
            }
            if (this.niR != null) {
                this.niR.setText("");
            }
            if (this.bB == 2) {
                aw(true, i());
                return true;
            }
            dKi();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nnq != null) {
            if (this.niA == null) {
                this.niA = (PopH5Menu) ((ViewStub) this.nnq.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.niA.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.niA.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            n(view, 0, this.nhy.getHeight() + this.nhy.getTop());
        } else if (id == a.f.btn_barrage) {
            o(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nnG, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                g.c(this.nnG, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.nnF.a(false);
                a(false, false);
                ((VideoPlayer) this.nnG).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.nnG, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.nhi == null || this.nhi.nkc == null || !this.nhi.nkc.mInPKMode) {
                ((VideoPlayer) this.nnG).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nij) {
                f(this.nhV.getText().toString());
            } else {
                a(this.nhV.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dIP().c) {
                com.kascend.chushou.d.h.dIP().b(false);
                this.nhR.cancel();
                this.nhR.reset();
                this.nhQ.clearAnimation();
                this.nhS.setVisibility(8);
            }
            m(view, 0, this.nnq.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nnG, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            l(view, x, this.nnq.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.nnF.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nnG, null) && this.nnF != null && this.nnF.ngQ != null) {
                if (this.nij) {
                    bg();
                    return;
                }
                if (this.nnF != null && this.nnF.ngQ != null && this.nnF.ngQ.count > 0) {
                    this.nhX.setVisibility(8);
                } else {
                    this.nhX.setVisibility(0);
                }
                this.nij = true;
                this.nig.setBackgroundResource(a.e.ic_trumpet_p);
                this.nih.setVisibility(0);
                this.nih.setSelected(true);
                this.nih.setTextColor(Color.parseColor("#ff5959"));
                if (this.nhV != null) {
                    this.nhV.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nii <= 9) {
                this.nii++;
                this.nif.setText(this.nii + "");
            }
            dKl();
        } else if (id == a.f.tv_cut_count) {
            if (this.nii > 1) {
                this.nii--;
                this.nif.setText(this.nii + "");
            }
            dKl();
        } else if (id == a.f.tv_buy_head) {
            dKm();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.niR.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.niR.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dF(this.niR);
                this.nok.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nhV != null && this.nhO != null && this.nhU != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.nhV);
                this.nhO.setVisibility(8);
                if (this.bB == 2) {
                    this.nhU.setVisibility(0);
                }
            }
        } else if (this.nhO != null && this.nhU != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
            if (this.bB == 2) {
                this.nhO.setVisibility(0);
            }
            this.nhU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dIP().c(roomToast.mToastContent);
            if (this.niD == null) {
                dJZ();
            }
            if (this.niE != null) {
                this.niE.setText(roomToast.mToastContent);
            }
            if (!this.niD.isShowing()) {
                if (this.nis != null) {
                    this.niD.showAtLocation(this.nis, 85, 0, this.nnq.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.niD != null) {
                                a.this.niD.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.niD.dismiss();
        }
    }

    private void dJZ() {
        if (this.niD == null) {
            View inflate = LayoutInflater.from(this.nnG).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.niE = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.niD = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 160.0f), -2);
            this.niD.setFocusable(false);
            this.niD.setOutsideTouchable(false);
            this.niD.setAnimationStyle(a.j.gift_toast_style);
            this.niD.update();
        }
    }

    private void l(View view, int i, int i2) {
        if (this.nof != null && this.nof.isShowing()) {
            this.nof.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
        if (this.noD == null) {
            dKB();
        }
        if (!this.noD.isShowing()) {
            this.noD.showAtLocation(view, 83, i, i2);
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nnF.dJB().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.noD.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dKa() {
        if (this.noG != null) {
            if (h.isEmpty(this.noH)) {
                if (((VideoPlayer) this.nnG).q) {
                    this.noG.bU(this.nnF != null ? this.nnF.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.noG.bU(this.nnF != null ? this.nnF.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nnG).q && this.noH.size() == 2 && this.noH.contains("4") && this.noH.contains("2")) {
                this.noG.bU(this.nnF != null ? this.nnF.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.noH.size() > 1 || !((VideoPlayer) this.nnG).q) {
                this.noG.bU(this.nnF != null ? this.nnF.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.noH.get(0))) {
                this.noG.bU(this.nnF != null ? this.nnF.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.noH.get(0))) {
                this.noG.bU(this.nnF != null ? this.nnF.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.noH.get(0))) {
                this.noG.bU(this.nnF != null ? this.nnF.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void m(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
        if (this.nof == null) {
            al();
            this.nof.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.nof.isShowing() && this.bB == 2) {
            this.nof.showAtLocation(view, 83, i, this.nnG.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nnF.dJB().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nof.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nnz != null) {
            this.nnz.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                g.c(this.nnG, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nkb.getPlayState() == 4) {
                        e(true);
                        if (this.nnF.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.nnF.a(false);
                        ((VideoPlayer) this.nnG).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nkb.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nkb.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                g.c(this.nnG, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.nnF.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nnG).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
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
        if (this.nos != null) {
            if (z) {
                this.nos.setVisibility(0);
            }
            this.nos.dVQ();
            if (!z) {
                this.nos.setVisibility(8);
            }
        }
        g.c(this.nnG, this.nnG.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nhI != null) {
                this.nhI.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nnA != null) {
                this.nnA.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nhI != null) {
            this.nhI.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nnA != null) {
                    this.nnA.setVisibility(8);
                }
            }
        }
    }

    private void dKb() {
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
        int i2 = this.nhu[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dJS();
            a(this.nnF != null ? this.nnF.ngR.get("1") : null);
            if (i2 == 2) {
                k();
                aw(true, i3);
                v(true);
                b(true);
                dKe();
                com.kascend.chushou.toolkit.a.c.a(this.nnG, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aw(false, i3);
            v(false);
            b(false);
            if (this.nof != null && this.nof.isShowing()) {
                this.nof.dismiss();
            }
            if (i2 == 99) {
                if (this.nhv != null && this.nhv[i] != null && (this.nhv[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nhv[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nnG, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nnG, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nnG, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nnG, "房间信息页_num", null, new Object[0]);
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
        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nnH != null) {
            if (this.nhU != null && this.nhU.getVisibility() == 0) {
                u(false);
            }
            if (this.nnA != null && this.nnA.getVisibility() == 0) {
                this.f = true;
            }
            av(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nhx != null) {
            this.nhx.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nhx != null) {
            this.nhx.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nhx != null) {
            this.nhx.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nhx != null) {
            this.nhx.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nis != null) {
            int size = iconConfig.configs.size();
            this.nis.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nnG).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.nis, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bU(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bU(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
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
                    public void ds(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.nis.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.nnF != null ? this.nnF.ngR : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nhx != null) {
            this.nhx.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dKa();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nip != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nip.zs(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nip.bU(str, a.c.kas_white);
                if (this.niq != null) {
                    this.niq.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nip.zs(a.c.kas_white);
                if (this.niq != null) {
                    this.niq.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.niq != null) {
                    this.niq.setTextColor(a);
                    this.niq.setTabTextSelectColor(a2);
                    this.niq.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nhQ != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nhQ.zs(a.e.ic_hotwords_black_n);
            } else {
                this.nhQ.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nhP != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dKO().a(str, this.nhP, a.e.player_skin_input);
            } else {
                this.nhP.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nhT != null) {
                this.nhT.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void a(int i) {
        if (this.nhx != null) {
            this.nhx.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void D() {
        if (this.nnG instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dJh = ((VideoPlayer) this.nnG).dJh();
            if (this.nox == null) {
                this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nox.setVisibility(0);
            this.nox.a(2, dJh);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nhx != null) {
            this.nhx.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nhx != null) {
            this.nhx.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(long j) {
        if (this.nhx != null) {
            this.nhx.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0827a
    public void c(int i) {
        if (this.nhx != null) {
            this.nhx.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nhx != null && this.nnF != null) {
            this.nhx.b(this.nnF.ngP);
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
    public class C0820a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0820a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.nhu.length) {
                return null;
            }
            switch (a.this.nhu[i]) {
                case 1:
                    if (a.this.nhw == null) {
                        a.this.nhw = com.kascend.chushou.view.user.a.a(2, null, a.this.nnF.a, false, a.this.nnF.h, false);
                    }
                    a.this.nhv[i] = a.this.nhw;
                    return a.this.nhw;
                case 2:
                    if (a.this.nhx == null) {
                        a aVar = a.this;
                        if (a.this.nhi != null && a.this.nhi.nkc != null) {
                            z = a.this.nhi.nkc.mInPKMode;
                        }
                        aVar.nhx = com.kascend.chushou.player.ui.a.xa(z);
                    }
                    a.this.nhv[i] = a.this.nhx;
                    return a.this.nhx;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.nnF != null && a.this.nnF.dJB() != null && !h.isEmpty(a.this.nix)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.nix.get(i).url);
                        h5Options.a = a.this.nix.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nhv[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Ke(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.nhu.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int mb(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Kf(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String Kg(int i) {
            return a.this.Ke(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Kh(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Ki(int i) {
            int dimensionPixelSize = a.this.nnG.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Dl(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.LI(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nho <= 3000) {
            g.LI(a.i.str_too_fast);
            return false;
        } else {
            dKg();
            if (!com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a(((VideoPlayer) this.nnG).dJb().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nho = System.currentTimeMillis();
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                a(this.nnF.dJB().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nnF.h);
            }
            g(this.b);
            if (!z && this.nhV != null) {
                this.nhV.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dKg();
            if (com.kascend.chushou.d.e.c(this.nnG, null) && LoginManager.Instance().getUserInfo() != null && this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                a(this.nnF.dJB().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nhV != null) {
                this.nhV.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nhx != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nnF.dJB().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nnF.dJB().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nnG).nfg;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Te(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.nhx.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nhx.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.nhx != null) {
            this.nhx.e();
        }
        if (this.niv != null && this.niv.isShown()) {
            this.niv.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dKc() {
        super.dKc();
        if (this.nnG instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.nnF != null) {
            this.nnF.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.nnG != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.nnG).t)) {
                this.cx = true;
                if (this.nnF != null) {
                    this.nnF.f = null;
                    if (this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                        this.nnF.dJB().mRoominfo.mGameId = null;
                    }
                }
                dJU();
                return;
            }
            this.cx = true;
            if (this.nnG != null) {
                ((VideoPlayer) this.nnG).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nhG != null) {
            this.nhG.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nhG != null) {
            this.nhG.setVisibility(8);
        }
        super.i(z);
    }

    private void dKd() {
        aN();
        if (i()) {
            dKf();
            ap();
            return;
        }
        dJU();
    }

    private void dKe() {
    }

    private void dKf() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dKA().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.nos != null) {
            this.nos.setVisibility(0);
        }
        if (this.nhe != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.nhe.d();
        }
        if (this.nhO != null) {
            this.nhO.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nhD.setVisibility(0);
            this.nhD.setOnClickListener(this);
        } else {
            this.nhD.setVisibility(8);
        }
        this.nhI.setVisibility(0);
        this.nhE.setVisibility(0);
        this.nnx.setVisibility(0);
        if (this.p) {
            this.nny.setVisibility(0);
        } else {
            this.nny.setVisibility(8);
        }
        dKe();
        aw(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nox != null && this.nox.a(i, keyEvent)) {
                return true;
            }
            if (this.niA != null && this.niA.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.niB != null && this.niB.onKeyDown(i, keyEvent)) || dKh()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.niS != null && this.niS.getVisibility() == 0 && b(motionEvent, this.niS)) {
                this.niS.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dF(this.niR);
                return true;
            } else if (this.nit && this.niS != null && this.niS.getVisibility() == 8 && f(this.nok.b, motionEvent)) {
                dJY();
                return true;
            } else if (this.niA != null && this.niA.b() && f(this.niA, motionEvent)) {
                this.niA.a();
                return true;
            } else if (this.niB != null && this.niB.b() && f(this.niB, motionEvent)) {
                this.niB.a();
                return true;
            } else if (b(motionEvent, this.nhU)) {
                return dKg();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dKg() {
        boolean z;
        b(this.niC, 10);
        boolean z2 = false;
        if (this.nik != null && this.nik.getVisibility() == 0) {
            this.nik.setVisibility(8);
            this.nil.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nim) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
            this.nil.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nhU == null || this.nhU.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nij) {
                bg();
            }
            this.nhU.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nhO != null && a.this.bB == 2) {
                        a.this.nhO.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dKh() {
        if (dKg()) {
            return true;
        }
        if (this.nof == null || !this.nof.isShowing()) {
            return dJY() || az() || dxD();
        }
        this.nof.dismiss();
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
    public void dKi() {
        this.nhO.setVisibility(8);
        this.nhU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z, boolean z2) {
        if (this.nhO != null) {
            if (z) {
                if (this.nhO.getVisibility() != 0) {
                    this.nhO.setVisibility(0);
                    this.nhO.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_bottom_anim));
                }
            } else if (this.nhO.getVisibility() != 4) {
                this.nhO.setVisibility(4);
                this.nhO.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nhG != null) {
            this.nhG.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dKj() {
        return this.niG;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.nnF != null) {
                        this.nnF.f = null;
                        this.nnF.dJB().mRoominfo.mGameId = null;
                    }
                    dJU();
                    return;
                }
                g.LI(a.i.str_getvideosource_failed);
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
        if (this.nnF != null && this.nnF.dJC() != null) {
            a(this.nnF.dJC());
        }
        this.p = false;
        if (this.nnF == null || this.nnF.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nnF.f.size()) {
                if (!"2".equals(this.nnF.f.get(i2).mType)) {
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
        if (this.nhx != null) {
            this.nhx.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nhJ != null && this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                this.nhJ.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.nnF.dJB().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.niy && (c = c(1, -1)) >= 0 && c < this.nix.size() && this.nir != null) {
            this.nir.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.niy) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nnG, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dJi = ((VideoPlayer) this.nnG).dJi();
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(2, dJi);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dJj = ((VideoPlayer) this.nnG).dJj();
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(2, dJj);
            } else if (bVar.a == 9) {
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nik != null) {
            this.nik.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.niy) {
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
        if (!aa() && this.nnF != null) {
            String str = this.nnF.a;
            RoomInfo dJE = this.nnF.dJE();
            if (dJE != null && mVar.a(dJE.mCreatorUID, str)) {
                dJE.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nhV != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nhV);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
            if (this.niu == null) {
                this.niu = new f(getActivity());
            }
            this.niu.a(this.nnF.dJB().mRoominfo);
            if (!this.niu.isShowing()) {
                this.niu.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nhx != null) {
            this.nhx.d();
        }
    }

    private void du(View view) {
        this.nhK = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nhL = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nhL.setText(new tv.chushou.zues.widget.a.c().J(this.nnG, a.e.videoplayer_4g_video).append("  ").append(this.nnG.getString(a.i.videoplayer_4g_video)));
        this.nhM = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nhM.setText(new tv.chushou.zues.widget.a.c().J(this.nnG, a.e.videoplayer_4g_audio).append("  ").append(this.nnG.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nhK.setVisibility(8);
                    ((VideoPlayer) a.this.nnG).c(a.this.nhN);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nhK.setVisibility(8);
                    ((VideoPlayer) a.this.nnG).d(a.this.nhN);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dII().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nhL.setOnClickListener(onClickListener);
        this.nhM.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nnF != null && !h.isEmpty(this.nnF.f)) {
            f(this.nnF.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nhN = z;
            this.p = false;
            if (this.nnF != null && this.nnF.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nnF.f.size()) {
                        break;
                    } else if (!"2".equals(this.nnF.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nhK != null) {
                this.nhK.setVisibility(0);
                this.nhL.setVisibility(0);
                this.nhM.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nhK != null) {
            this.nhK.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.niK == null) {
                this.niK = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.nnH != null) {
                    this.nnH.e(this.niK, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.niK != null && this.nnH != null) {
            this.nnH.P(this.niK);
            this.niK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nhx != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nnG, "显示双击666_num", null, new Object[0]);
            if (this.nnF != null) {
                this.nnF.b(false);
            }
            d(false);
            this.nhx.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.nnq != null) {
            if (this.niB == null) {
                this.niB = (InteractionView) ((ViewStub) this.nnq.findViewById(a.f.view_interaction)).inflate();
                this.niB.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.niB.a();
                    }
                });
            }
            if (this.niB != null) {
                this.niB.b(configDetail);
                this.niB.c();
                this.niB.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dWD()) {
                g.F(this.nnG, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nnG, null) && (this.nnG instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnF != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnG, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnF != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnG, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nnG, configDetail.mUrl, this.nnG.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nnG, null)) {
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
        if (this.nit) {
            dJY();
            return;
        }
        if (this.nnG.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击送礼_num", "竖屏", new Object[0]);
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnF.dJB().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nnG != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nhi == null) {
                this.nhi = new com.kascend.chushou.player.e.a();
            }
            this.nhi.b = str;
            this.nhi.nkc.copy(pkNotifyInfo);
            if (this.nhi.nkc.mAction == 6) {
                this.nhi.nkc.mInPKMode = true;
                this.u = this.nhi.nkc.mPkId;
            } else if (this.nhi.nkc.mAction == 7 || (this.nhi.nkc.mMode == 1 && this.nhi.nkc.mAction == 5)) {
                this.nhi.nkc.mInPKMode = true;
                this.u = this.nhi.nkc.mPkId;
                if (dKk() != null) {
                    if (2 == this.bB && this.niN != null) {
                        this.niN.setVisibility(0);
                    }
                    dKk().b(this.nhi.nkc, false);
                    dKk().a(this.nhi.nkc.mMode, "1");
                    if (this.nhi.nkc.mAction == 5 && this.nhi.nkc.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nhi.nkc.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nhi.nkc.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nhi.nkc.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nhi.nkc.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nhi.nkc.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dKk().a(this.nhi.nkc);
                        if (this.nhi.nkc.destinyInfo == null || this.nhi.nkc.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dKk().a(parseInt, this.nhi.nkc.mPkUpdateInfo.remainDuration, j, this.nhi.nkc.mMode, i);
                    }
                    if (!h.isEmpty(this.nhi.nkc.mPkUpdateInfo.specialMomentList) && dKk() != null) {
                        dKk().a(this.nhi.nkc, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Rk(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.nhi.nkc.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Rk(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.nhi != null && this.nhi.nkc != null) {
            if (this.nhi.nkc.mInPKMode) {
                this.y.setText(this.nhi.nkc.mPkUserNickname);
                this.nhk.setVisibility(0);
                if (this.nnw != null) {
                    this.nnw.setEnabled(false);
                }
                if (this.nny != null) {
                    this.nny.setEnabled(false);
                    return;
                }
                return;
            }
            this.nhk.setVisibility(8);
            if (this.nnw != null) {
                this.nnw.setEnabled(true);
            }
            if (this.nny != null) {
                this.nny.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dKk() {
        if (this.nnG == null || this.nnq == null || this.niN == null) {
            return null;
        }
        if (this.nhj == null) {
            if (this.niM == null) {
                this.niM = ((ViewStub) this.nnq.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.nhj = new com.kascend.chushou.player.e.b();
            this.nhj.a(this.niN, this.niM, (View) null, this.nnG, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dWj()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.nnF != null) {
                        append.append(a.this.nnF.dJE().mRoomID);
                    }
                    if (a.this.nhi != null && a.this.nhi.nkc != null) {
                        append.append("&mode=").append(a.this.nhi.nkc.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nnG, append.toString());
                }
            });
        }
        return this.nhj;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nih != null && this.nnF != null && this.nnF.ngQ != null) {
            this.nih.setText(tv.chushou.zues.utils.b.LH(this.nnF.ngQ.count));
            this.nih.setVisibility(0);
            if (this.nnF.ngQ.count < 1) {
                bg();
            }
            if (this.nhY != null) {
                this.nhY.setText(this.nnF.ngQ.primaryName);
            }
            if (this.nhZ != null) {
                this.nhZ.setText(this.nnF.ngQ.desc);
            }
            dKl();
        }
    }

    public void dKl() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nii * h.parseLong(this.nnF.ngQ.point)));
        if (this.nib != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nnG.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nnG, a.e.icon_coin_new);
            cVar.append(this.nnG.getString(a.i.str_buy_count_coin2));
            this.nib.setText(cVar);
        }
    }

    private void dKm() {
        if (com.kascend.chushou.d.e.c(this.nnG, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nii);
        }
    }

    private void v(boolean z) {
        if (this.nnq != null && this.niN != null) {
            if (z) {
                if (this.nhi != null && this.nhi.nkc != null && this.nhi.nkc.mInPKMode) {
                    this.niN.setVisibility(0);
                    return;
                }
                return;
            }
            this.niN.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nnq != null && this.nhn != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nhn.setVisibility(0);
                    return;
                }
                return;
            }
            this.nhn.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.nhi != null && this.nhi.nkc != null && this.nhi.nkc.mInPKMode && this.nhk != null) {
                this.nhk.setVisibility(0);
            }
        } else if (this.nhk != null) {
            this.nhk.setVisibility(8);
        }
    }

    private void bg() {
        this.nij = false;
        this.nig.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nnF != null && this.nnF.ngQ != null) {
            if (this.nnF.ngQ.count < 1) {
                this.nih.setVisibility(8);
            } else {
                this.nih.setVisibility(0);
                this.nih.setSelected(false);
                this.nih.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nhX.setVisibility(8);
        if (this.nhV != null) {
            this.nhV.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nhT != null) {
            this.nhT.performClick();
        }
    }

    public boolean dKn() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.niY = true;
        if (this.nnq != null && com.kascend.chushou.b.dII().d == 0) {
            this.niI = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
            if (!z) {
                View findViewById = this.nnq.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.niI = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.niI);
            View findViewById2 = this.nnq.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.niI);
            findViewById2.requestLayout();
        }
    }
}
