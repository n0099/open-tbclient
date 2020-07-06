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
    private ImageView nhC;
    private MarqueeTextView nhD;
    private MarqueeTextView nhE;
    private ImageView nhF;
    private ImageView nhG;
    private ImageButton nhH;
    public String nhI;
    private RecommendView nhJ;
    private TextView nhM;
    private RelativeLayout nhN;
    private TextView nhO;
    private TextView nhP;
    private boolean nhQ;
    private RelativeLayout nhR;
    private View nhS;
    private FrescoThumbnailView nhT;
    private AnimationSet nhU;
    private ImageView nhV;
    private TextView nhW;
    private RelativeLayout nhX;
    private PastedEditText nhY;
    private TextView nhZ;
    private int[] nhx;
    private Fragment[] nhy;
    public ArrayList<RoomTab> niA;
    private PopH5Menu niD;
    private InteractionView niE;
    private int niF;
    private PopupWindow niG;
    private TextView niH;
    private GiftAnimationLayout niI;
    private com.kascend.chushou.player.b.a niJ;
    private Runnable niN;
    private View niP;
    private LivePKBarUserValue niQ;
    private String niR;
    private TextView niS;
    private ImageView niT;
    private EditText niU;
    private View niV;
    private View niW;
    private View niX;
    private LinearLayout nia;
    private TextView nib;
    private TextView nic;
    private TextView nie;
    private TextView nif;
    private TextView nig;
    private TextView nih;
    private TextView nii;
    private ImageView nij;
    private TextView nik;
    private KPSwitchPanelLinearLayout nin;
    private ImageView nio;
    private c niq;
    private d.a nir;
    private FrescoThumbnailView nis;
    private PagerSlidingTabStrip nit;
    private KasViewPager niu;
    private LinearLayout niv;
    private f nix;
    private ViewMicPerson niy;
    private String nja;
    private long nhr = 0;
    private com.kascend.chushou.view.user.a nhz = null;
    private com.kascend.chushou.player.ui.a nhA = null;
    private int bB = -1;
    private int bC = 0;
    private View nhB = null;
    private View nhK = null;
    private ImageButton nhL = null;
    private int nil = 1;
    private boolean nim = false;
    private boolean nip = false;
    private boolean niw = false;
    private boolean cx = false;
    private boolean niz = false;
    private boolean niB = false;
    private boolean niC = true;
    private int niK = 0;
    private int niL = 0;
    private int niM = -1;
    private final Rect niO = new Rect();
    private boolean niY = false;
    private C0821a niZ = null;
    private boolean da = false;
    private boolean njb = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhI = getArguments().getString("mCover");
        this.niC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nnt = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.nnt;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            c(view);
            dJS();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.niB = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.non != null) {
            this.non.b();
        }
        if (this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnJ).wW(true);
            ((VideoPlayer) this.nnJ).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.niB = true;
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
        this.nil = 1;
        this.nim = false;
        U();
        if (this.nnK != null) {
            this.nnK.ch(null);
            this.nnK = null;
        }
        if (this.nhJ != null) {
            dKE().removeAllViews();
            this.nhJ = null;
        }
        this.c = null;
        this.nhf = null;
        tv.chushou.zues.a.a.ci(this);
        this.nit = null;
        this.niu = null;
        this.nhA = null;
        this.nhz = null;
        if (this.nhy != null) {
            for (int i = 0; i < this.nhy.length; i++) {
                this.nhy[i] = null;
            }
        }
        this.nhy = null;
        if (this.nhY != null) {
            this.nhY.addTextChangedListener(null);
            this.nhY.setOnTouchListener(null);
            this.nhY.setOnEditorActionListener(null);
            this.nhY = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nnJ, this.niq);
        if (this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnJ).dJj();
        }
        this.nir = null;
        this.niq = null;
        if (this.niy != null) {
            this.niy.b();
            this.niy = null;
        }
        if (this.niG != null) {
            this.niG.dismiss();
        }
        if (this.niJ != null) {
            this.niJ.a();
            this.niJ = null;
            this.niI = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.niQ = (LivePKBarUserValue) this.nnt.findViewById(a.f.live_pk_bar_user);
        this.nnC = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.niY) {
            this.niY = true;
            if (this.niW == null) {
                this.niW = this.nnt.findViewById(a.f.vs_async_view);
                this.niW = ((ViewStub) this.niW).inflate();
            }
            if (this.niX == null) {
                this.niX = this.nnt.findViewById(a.f.vs_async_notification_view);
                this.niX = ((ViewStub) this.niX).inflate();
            }
            this.nhq = (VoiceInteractionView) this.nnt.findViewById(a.f.voiceInteractiveView);
            t();
            dt(this.nnt);
            ar();
            ((VideoPlayer) this.nnJ).q();
            this.nhl = new com.kascend.chushou.player.e.a();
        }
    }

    private void dt(View view) {
        this.nis = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.nit = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.niu = (KasViewPager) view.findViewById(a.f.vp_main);
        dJT();
        aI();
        aN();
        if (this.nnI != null) {
            I();
            a(this.nnI.ngR, this.nnI.ngU);
        }
        this.bb = 0;
        this.nos = 0L;
        this.noo = (RoundProgressBar) this.nnt.findViewById(a.f.roundProgressBar);
        this.nop = (TextView) this.nnt.findViewById(a.f.tv_paonum);
        this.noq = (FrescoThumbnailView) this.nnt.findViewById(a.f.iv_paoicon);
        this.noz = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.niw = false;
                if (a.this.bB == 2) {
                    a.this.aw(true, a.this.i());
                } else {
                    a.this.dKm();
                }
                a.this.b(a.this.niF, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.niw = true;
                if (a.this.bB == 2) {
                    a.this.aw(false, a.this.i());
                } else {
                    a.this.dKm();
                }
                if (a.this.non != null) {
                    a.this.non.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gw(a.this.nnJ).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.nnJ)) - a.this.non.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.nnJ, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.nnJ, 54.0f) * 2);
                    if (statusBarHeight < a.this.niF) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.nor = (PaoGuideView) this.nnt.findViewById(a.f.rlPaoGuideView);
        this.niy = (ViewMicPerson) this.nnt.findViewById(a.f.rl_mic_person_view);
    }

    private void dJS() {
        this.nke = ((VideoPlayer) this.nnJ).dJc();
        this.nnI = ((VideoPlayer) this.nnJ).dJf();
        du(this.nnt);
        this.niK = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
        this.niL = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (com.kascend.chushou.b.dIM().d == 0 && this.niL > 0) {
            View findViewById = this.nnt.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.niL);
        }
        dKb();
        dJZ();
        if (!this.niC) {
            Q();
        }
        dJX();
        a();
        if (this.c == null) {
            this.nhf = new d.a();
            this.c = new GestureDetector(this.nnJ, this.nhf);
        }
        this.nhh = ((VideoPlayer) this.nnJ).dJg();
        this.nhh.a(this);
        if (this.niJ != null) {
            this.niJ.a();
            this.niJ = null;
        }
        this.niI = (GiftAnimationLayout) this.nnt.findViewById(a.f.ll_gift_animation);
        this.niI.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.nnI != null) {
            this.niJ = new com.kascend.chushou.player.b.a(this.nnJ.getApplicationContext(), this.niI);
            this.niJ.a(this.nnI);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.nnt.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nnD = (PlayerErrorView) this.nnt.findViewById(a.f.view_net_error_msg);
        this.nnD.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dJV();
        dKf();
        if (this.nnI.dJG() != null) {
            a(this.nnI.dJG());
        }
        FullRoomInfo dJF = this.nnI.dJF();
        if (dJF != null) {
            dKh();
            if (i()) {
                this.ak = false;
                m(true);
                this.nnK.Lz(8);
            }
            this.nhM.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dJF.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.nhB.setVisibility(0);
        this.ak = false;
        m(true);
        this.nnK.Lz(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.nnJ).n();
        if (this.nnI != null && !h.isEmpty(this.nnI.w)) {
            b(this.nnI.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dJq;
        dJT();
        k();
        FullRoomInfo dJF = this.nnI.dJF();
        if (dJF != null) {
            if (dJF.mRoominfo != null) {
                this.nhM.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dJF.mRoominfo.mOnlineCount)));
                this.niR = dJF.mRoominfo.mRoomID;
            }
            dKh();
            if (!h.isEmpty(dJF.mRoomToastList)) {
                Iterator<RoomToast> it = dJF.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dIT().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.nnI != null && this.nnI.l()) {
                d(true);
            }
            if (this.nnJ != null && (this.nnJ instanceof VideoPlayer) && (dJq = ((VideoPlayer) this.nnJ).dJq()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dJq.nkf, dJq.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.niv);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dJT() {
        boolean z = true;
        if (this.nnI == null || this.nnI.dJF() == null || this.nnI.dJF().mRoominfo == null || h.isEmpty(this.nnI.dJF().mRoomTabs)) {
            this.niz = false;
            this.nhy = new Fragment[2];
            this.nhx = new int[2];
            this.nhx[0] = 2;
            this.nhx[1] = 1;
            return;
        }
        this.niz = true;
        this.niA = new ArrayList<>();
        Iterator<RoomTab> it = this.nnI.dJF().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.niA.add(next);
            }
        }
        if (this.niA.size() >= 2 && this.nhx != null && this.nhx.length >= 2 && this.niA.get(0).type == this.nhx[0] && this.niA.get(1).type == this.nhx[1]) {
            z = false;
        }
        this.nhy = new Fragment[this.niA.size()];
        this.nhx = new int[this.niA.size()];
        for (int i = 0; i < this.niA.size(); i++) {
            this.nhx[i] = this.niA.get(i).type;
        }
        if (z) {
            this.niZ = new C0821a(getChildFragmentManager());
            this.niu.setAdapter(this.niZ);
        }
    }

    private void aI() {
        this.nhX = (RelativeLayout) this.nnt.findViewById(a.f.rl_edit_bar);
        this.nhT = (FrescoThumbnailView) this.nnt.findViewById(a.f.btn_hotword);
        this.nhT.zs(a.e.ic_hotwords_black_n);
        this.nhT.setOnClickListener(this);
        this.nhV = (ImageView) this.nnt.findViewById(a.f.iv_task_badge);
        this.nhU = (AnimationSet) AnimationUtils.loadAnimation(this.nnJ, a.C0815a.anim_hotword);
        this.nhU.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dIT().c) {
                    a.this.nhT.clearAnimation();
                    a.this.nhT.startAnimation(a.this.nhU);
                }
            }
        });
        if (com.kascend.chushou.d.h.dIT().c) {
            this.nhT.startAnimation(this.nhU);
            this.nhV.setVisibility(0);
        }
        this.nhW = (TextView) this.nnt.findViewById(a.f.tv_bottom_input);
        this.nhW.setOnClickListener(this);
        this.noJ = (FrescoThumbnailView) this.nnt.findViewById(a.f.ll_btn_set);
        this.noJ.setOnClickListener(this);
        this.niv = (LinearLayout) this.nnt.findViewById(a.f.ll_bottom_all_button);
        this.nhR = (RelativeLayout) this.nnt.findViewById(a.f.rl_bottom_input);
        this.nhS = this.nnt.findViewById(a.f.ll_bottom_input);
        this.nhR.setVisibility(8);
        this.nhY = (PastedEditText) this.nnt.findViewById(a.f.et_bottom_input);
        this.nhY.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.nhZ.setEnabled(editable.length() > 0);
            }
        });
        this.nhY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.nhZ);
                    return true;
                }
                return true;
            }
        });
        this.nhY.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.nhY);
                }
                return false;
            }
        });
        this.nio = (ImageView) this.nnt.findViewById(a.f.iv_btn_emoji);
        this.nio.setVisibility(8);
        this.nhZ = (TextView) this.nnt.findViewById(a.f.tv_btn_send);
        this.nhZ.setOnClickListener(this);
        this.nin = (KPSwitchPanelLinearLayout) this.nnt.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dIM().d == 0) {
            this.nin.setUseStatusBar(true);
        }
        this.nia = (LinearLayout) this.nnt.findViewById(a.f.head_trumpet);
        this.nia.setVisibility(8);
        this.nia.setOnClickListener(this);
        this.nib = (TextView) this.nnt.findViewById(a.f.tv_primary_name);
        this.nic = (TextView) this.nnt.findViewById(a.f.tv_primary_desc);
        this.nig = (TextView) this.nnt.findViewById(a.f.tv_cut_count);
        this.nig.setOnClickListener(this);
        this.nii = (TextView) this.nnt.findViewById(a.f.tv_head_count);
        this.nii.setText(this.nil + "");
        this.nih = (TextView) this.nnt.findViewById(a.f.tv_plus_count);
        this.nih.setOnClickListener(this);
        this.nif = (TextView) this.nnt.findViewById(a.f.tv_buy_count_coin);
        this.nie = (TextView) this.nnt.findViewById(a.f.tv_buy_head);
        this.nie.setOnClickListener(this);
        this.nij = (ImageView) this.nnt.findViewById(a.f.iv_trumpet_select);
        this.nij.setOnClickListener(this);
        this.nik = (TextView) this.nnt.findViewById(a.f.tv_trumpet_have_count);
        this.nim = false;
        this.nij.setBackgroundResource(a.e.ic_trumpet_n);
        this.nik.setVisibility(8);
        aK();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nin, this.nio, this.nhY, new a.InterfaceC0945a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0945a
            public void wX(boolean z) {
                if (a.this.nio != null) {
                    if (!z) {
                        a.this.nio.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dIM().d == 0) {
                        a.this.nin.setDirectVisibility(0);
                    }
                    a.this.nio.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.nir = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wY(boolean z) {
                if (a.this.njb) {
                    a.this.njb = false;
                    return;
                }
                a.this.nip = z;
                if (z) {
                    a.this.nio.setImageResource(a.e.cs_emoji_normal);
                    a.this.dJU();
                    return;
                }
                if (a.this.niV != null && a.this.niV.getVisibility() == 0) {
                    a.this.niV.setVisibility(8);
                }
                if (a.this.niw) {
                    a.this.non.setVisibility(0);
                }
                if (a.this.nnJ != null && (a.this.nnJ instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.nnJ).wW(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.niq = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nin, this.nir, ((VideoPlayer) this.nnJ).dJk());
        ((VideoPlayer) this.nnJ).h(((VideoPlayer) this.nnJ).dJk());
        this.niV = this.nnt.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.niS = (TextView) this.nnt.findViewById(a.f.btn_room_search);
        this.niT = (ImageView) this.nnt.findViewById(a.f.iv_room_emoji_delete);
        this.niU = (EditText) this.nnt.findViewById(a.f.et_room_emoji_search);
        this.niU.setImeOptions(3);
        this.niU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.niS);
                    return true;
                }
                return false;
            }
        });
        this.niU.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.niS.setEnabled(editable.length() > 0);
                a.this.niT.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.non.setEmojiSearchText(editable.toString());
            }
        });
        this.niS.setOnClickListener(this);
        this.niT.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void au(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dE(this.niU);
            this.niV.setVisibility(0);
            this.niU.requestFocus();
        } else {
            this.niV.setVisibility(8);
        }
        if (z2) {
            this.niU.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJU() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gw(this.nnJ).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ)) - tv.chushou.zues.widget.kpswitch.b.d.gJ(this.nnJ)) - tv.chushou.zues.utils.a.dip2px(this.nnJ, 14.0f)) - this.nnJ.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.nnJ, 54.0f) * 2);
        if (statusBarHeight < this.niF) {
            b(statusBarHeight, 10);
        }
    }

    private void aK() {
    }

    private void dJV() {
        this.nnK = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.av(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.nnt.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.nnJ.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.nnK.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.nnK.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.nnK.B(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.nnK);
                            break;
                        case 12:
                            a.this.b(a.this.nnK);
                            break;
                        case 17:
                            a.this.as();
                            break;
                        case 18:
                            a.this.dxC();
                            break;
                        case 19:
                            a.this.nnH.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dJW() {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.niA)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.niA.size()) {
                    if (!h.isEmpty(this.niA.get(i2).notifyIcon)) {
                        this.nit.bM(i2, this.niA.get(i2).notifyIcon);
                        this.nit.LY(i2);
                    } else if (this.niA.get(i2).notify == 1) {
                        this.nit.LX(i2);
                        this.nit.LW(i2);
                    } else {
                        this.nit.LW(i2);
                        this.nit.LY(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.niA)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.niA.size()) {
                    if (this.niA.get(i4).type == i) {
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
        if (this.nnI == null || this.nnI.dJF() == null || this.nnI.dJF().mRoominfo == null || h.isEmpty(this.niA)) {
            if (i == 1) {
                return this.nnJ.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.nnJ.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.niA.size()) {
            return this.niA.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.niA) && i < this.niA.size()) {
            this.niA.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.niA) && i < this.niA.size()) {
            this.niA.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.niu != null && this.nit != null && this.nhx != null) {
            this.nhA = null;
            if (this.nhy != null) {
                for (int i = 0; i < this.nhy.length; i++) {
                    this.nhy[i] = null;
                }
            }
            if (this.niZ == null) {
                this.niZ = new C0821a(getChildFragmentManager());
                this.niu.setAdapter(this.niZ);
            } else {
                this.niZ.notifyDataSetChanged();
            }
            this.niu.setOffscreenPageLimit(this.nhx.length);
            this.nit.c(this.niu);
            this.nit.setOnPageChangeListener(this);
            this.nit.notifyDataSetChanged();
            this.nit.setVisibility(0);
            this.niu.setVisibility(0);
            if (!this.niz) {
                this.bB = 2;
                this.niu.setCurrentItem(c(2, 0));
                this.nhR.setVisibility(0);
            } else {
                if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                    if (!h.isEmpty(this.nnI.dJF().mRoominfo.mGameName)) {
                        this.nhE.setText(this.nnI.dJF().mRoominfo.mGameName);
                    } else {
                        this.nhE.setText(this.nnJ.getString(a.i.no_online_game_name));
                    }
                    this.nhD.setText(this.nnI.dJF().mRoominfo.mName);
                } else {
                    this.nhE.setText(this.nnJ.getString(a.i.no_online_game_name));
                }
                dJW();
                if (i()) {
                    aU();
                    if (this.niu != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.niu.setCurrentItem(c);
                        this.nit.setSelectItem(c);
                    }
                } else if (this.niu != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.niu.setCurrentItem(c2);
                    this.nit.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dJX() {
        this.N = new SurfaceView(this.nnJ);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dKE().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dJY() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nnJ).s();
        dxH();
        az();
        dJR();
        dKE().setBackgroundResource(a.e.room_not_online);
        if (this.nhJ == null) {
            this.nhJ = new RecommendView(this.nnJ);
            dKE().addView(this.nhJ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.nnJ);
            this.nhJ.setLayoutParams(layoutParams);
        }
        if (this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.nnI.dJF().mRoominfo.mRoomID)) {
            this.nhJ.a(this.nnI.dJF().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.nnJ != null && a.this.dKE() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.nnJ);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.mNp);
                        if (a.this.dKE().getChildCount() >= 2) {
                            a.this.dKE().addView(frescoThumbnailView, 0);
                        }
                        a.this.dKE().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dWz(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nox != null) {
            this.nox.dVU();
            this.nox.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.non != null) {
            this.non.e();
        }
        m(false);
        a(false, false);
        if (this.nhh != null) {
            this.nhh.d();
        }
    }

    private void dJZ() {
        int i = 0;
        this.nhB = this.nnt.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dIM().d == 0 && this.niK > 0) {
            View findViewById = this.nnt.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.niK;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.nhC = (ImageView) this.nhB.findViewById(a.f.back_icon);
        this.nhC.setOnClickListener(this);
        this.nhD = (MarqueeTextView) this.nhB.findViewById(a.f.tv_title);
        this.nhE = (MarqueeTextView) this.nhB.findViewById(a.f.tv_Type);
        this.nhG = (ImageView) this.nnt.findViewById(a.f.btn_setting);
        this.nhK = this.nnt.findViewById(a.f.bottomview);
        if (this.nnA == null) {
            this.nnA = (ImageButton) this.nhK.findViewById(a.f.btn_barrage);
            this.nnA.setOnClickListener(this);
            if (this.nnI != null) {
                if (com.kascend.chushou.d.h.dIT().n()) {
                    this.nnA.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nnA.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.nnB = (ImageButton) this.nhK.findViewById(a.f.btn_audio);
        this.nnB.setOnClickListener(this);
        if (this.nnI != null && this.nnI.d) {
            this.nnB.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.nnB.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.nnI != null && this.nnI.f != null) {
            while (true) {
                if (i >= this.nnI.f.size()) {
                    break;
                } else if (!"2".equals(this.nnI.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.nhL = (ImageButton) this.nhK.findViewById(a.f.playbutton);
        this.nhL.setOnTouchListener(this);
        this.nhH = (ImageButton) this.nhK.findViewById(a.f.btn_refresh);
        this.nhH.setOnClickListener(this);
        this.nhM = (TextView) this.nhK.findViewById(a.f.tv_online_count);
        if (this.nnz == null) {
            this.nnz = (ImageButton) this.nhK.findViewById(a.f.btn_screenChange);
            this.nnz.setOnClickListener(this);
        }
        if (this.nhF == null) {
            this.nhF = (ImageView) this.nhB.findViewById(a.f.report_icon);
            this.nhF.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nhA != null) {
                        this.nhA.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                        this.nnI.dJF().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nnI.dJF().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.nnI.dJF().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.nnI.dJF().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.nnI.dJF().mRoominfo.mCreatorUID);
                            }
                        } else if (this.nnI.dJF().mMicStatus.onMic) {
                            this.nnI.dJF().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nnI.dJF().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.nnI.dJF().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.nnI.dJF().mMicStatus != null && !h.isEmpty(this.nnI.dJF().mMicStatus.micRoomId) && !this.nnI.dJF().mMicStatus.micRoomId.equals("0")) {
                                this.nja = this.nnI.dJF().mMicStatus.micRoomId;
                            }
                            if (this.nhA != null) {
                                this.nhA.a(this.nnI.dJF().mMicStatus, this.nnI.dJF().mFanItems, str, z2);
                            }
                            if (this.niy != null && this.niy.getVisibility() == 0) {
                                this.niy.a(this.nnI.dJF().mFanItems, this.nnI.dJF().mMicStatus, str, z2, this.nnI.dJF().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nhA != null) {
                                this.nhA.e();
                            }
                            if (this.niy != null && this.niy.isShown()) {
                                this.niy.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.nhA != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.nhA.a(roomChatBackground.mChatBackground);
                        } else {
                            this.nhA.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.niM != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.niM = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nhl != null && this.nhl.nkf != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nhl.nkf.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nhl.nkf.mInPKMode = true;
                                    this.nhl.nkf.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhl.nkf.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhl.nkf.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhl.nkf.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhl.nkf.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhl.nkf.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nhl.nkf.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nhl.nkf.mMode = pkNotifyInfo.mMode;
                                    this.nhl.nkf.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dKo() != null) {
                                        dKo().g(true, this.nhl.nkf.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dIT().a) {
                                        if (!com.kascend.chushou.b.dIM().e) {
                                            com.kascend.chushou.b.dIM().e = true;
                                            g.F(this.nnJ, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dIT().a(this.nnJ, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.niQ != null) {
                                        this.niQ.setVisibility(0);
                                    }
                                    this.nhl.nkf.mAction = 7;
                                    this.nhl.nkf.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhl.nkf.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhl.nkf.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhl.nkf.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhl.nkf.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhl.nkf.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dKo() != null) {
                                        dKo().g(false, 0L);
                                        dKo().b(this.nhl.nkf, true);
                                        dKo().a(this.nhl.nkf.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Rl(this.niR);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.nhl.nkf.mInPKMode = false;
                                    this.nhl.nkf.mAction = 2;
                                    bd();
                                    if (dKo() != null) {
                                        dKo().c();
                                    }
                                    if (com.kascend.chushou.d.h.dIT().a) {
                                        if (!com.kascend.chushou.b.dIM().e) {
                                            com.kascend.chushou.b.dIM().e = true;
                                            g.F(this.nnJ, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dIT().a(this.nnJ, false);
                                        ak();
                                    }
                                    this.nhl.b = null;
                                    this.nhl.nkf = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Rl(this.niR);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nhl.nkf.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nhl.nkf.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.nhl.nkf.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.nnI.dJF().mRoominfo.mRoomID) && this.nnI.dJF().mRoominfo.mRoomID.equals(this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dKo() != null) {
                                        dKo().a(this.nhl.nkf, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nhl.nkf.copyUpdate(pkNotifyInfo);
                                    if (dKo() != null) {
                                        dKo().a(this.nhl.nkf);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nhl.nkf.copyStop(pkNotifyInfo);
                                        if (dKo() != null) {
                                            dKo().A(this.nhl.nkf.mMaxFreeDuration, this.nhl.nkf.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nhl.nkf.copyResult(pkNotifyInfo);
                                    if (!this.niB && dKo() != null) {
                                        int i5 = 1;
                                        if (this.nhl.nkf.destinyInfo != null && this.nhl.nkf.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dKo().a(h.parseInt(this.nhl.nkf.mResult), h.parseLong(this.nhl.nkf.mvpUid), this.nhl.nkf.mvpAvatar, this.nhl.nkf.mvpNickname, this.nhl.nkf.mMaxFreeDuration, this.nhl.nkf.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.nhA != null) {
                if (LoginManager.Instance().islogined() && this.nnI != null && this.nnI.l()) {
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
                if (this.nnI == null || this.nnI.dJF() == null || this.nnI.dJF().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.nnI.dJF().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dIT().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dIT().b().equals(next2.mUserID)) {
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
                this.nhA.a(arrayList, true, false);
                this.nhA.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.nhx != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.nhx.length) {
                    break;
                }
                if (this.nhx[i2] == 99 && this.nhy != null && this.nhy[i2] != null && (this.nhy[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.nhy[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.niA.size() && this.nit != null) {
                if (i == 0) {
                    this.nit.setTagText(i2, new StringBuilder(this.niA.get(i2).name).toString());
                    return;
                } else {
                    this.nit.setTagText(i2, this.niA.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.nnA != null) {
            if (z) {
                this.nnA.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nnA.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dKa() {
        if (this.nnt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nnt.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
        this.ar = Math.min(gw.x, gw.y);
        this.aq = (this.ar * this.nnJ.getResources().getInteger(a.g.h_thumb_height_def)) / this.nnJ.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dKE().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nnC.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.niF = this.aq + this.nnJ.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nnJ, 54.0f);
        b(this.niF, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dKb() {
        Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
        this.ar = Math.min(gw.x, gw.y);
        this.aq = (this.ar * this.nnJ.getResources().getInteger(a.g.h_thumb_height_def)) / this.nnJ.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dKE().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.nnC.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.niF = this.aq + this.nnJ.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.nnJ, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.niF, 10);
        k();
        if (!h.isEmpty(this.nhI)) {
            File ag = tv.chushou.zues.widget.fresco.a.ag(Uri.parse(this.nhI));
            if (ag != null && ag.exists()) {
                this.nnC.setImageURI(Uri.fromFile(ag));
                this.nnC.setVisibility(0);
                return;
            }
            this.nnC.setVisibility(8);
            return;
        }
        this.nnC.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        av(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.nhF != null) {
            this.nhF.setVisibility(z ? 0 : 4);
        }
        if (this.nhG != null) {
            this.nhG.setVisibility(z ? 0 : 4);
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
        if (this.nnK != null) {
            this.nnK.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nnJ).f(true);
            if (!z3) {
                if (this.nhK.getVisibility() != 0 && z2) {
                    this.nhK.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.nnB.setVisibility(0);
                } else {
                    this.nnB.setVisibility(8);
                }
                this.nhK.setVisibility(0);
            }
            PlayUrl dJG = this.nnI.dJG();
            if (dJG != null && "2".equals(dJG.mType)) {
                if (this.nnz != null) {
                    this.nnz.setVisibility(8);
                }
            } else if (this.nnz != null) {
                this.nnz.setVisibility(0);
            }
            if (this.nhB.getVisibility() != 0 && z2) {
                this.nhB.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_top_anim));
            }
            t(!z3);
            this.nhB.setVisibility(0);
            w(true);
            if (this.nnK != null) {
                this.nnK.B(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.nnJ).f(false);
            if (this.noa != null) {
                this.noa.dismiss();
            }
            if (this.nob != null) {
                this.nob.dismiss();
            }
            if (this.nhK.getVisibility() != 8 && z2) {
                this.nhK.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_bottom_anim));
            }
            this.nhK.setVisibility(8);
            if (this.nhB.getVisibility() != 8 && z2) {
                this.nhB.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_top_anim));
            }
            this.nhB.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dxH() {
        if (this.nor == null || !this.nor.isShown()) {
            return false;
        }
        this.nor.d();
        return true;
    }

    public boolean az() {
        if (this.niy == null || !this.niy.isShown()) {
            return false;
        }
        this.niy.a();
        return true;
    }

    public boolean dJR() {
        if (this.niD == null || !this.niD.b()) {
            return false;
        }
        this.niD.a();
        return true;
    }

    public boolean dKc() {
        if (this.niw && this.non != null) {
            if (this.non != null) {
                this.non.e();
            }
            if (this.niU != null) {
                this.niU.setText("");
            }
            if (this.bB == 2) {
                aw(true, i());
                return true;
            }
            dKm();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nnt != null) {
            if (this.niD == null) {
                this.niD = (PopH5Menu) ((ViewStub) this.nnt.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.niD.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.niD.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            n(view, 0, this.nhB.getHeight() + this.nhB.getTop());
        } else if (id == a.f.btn_barrage) {
            o(view, 0, -tv.chushou.zues.utils.a.dip2px(this.nnJ, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                g.c(this.nnJ, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.nnI.a(false);
                a(false, false);
                ((VideoPlayer) this.nnJ).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.nnJ, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.nhl == null || this.nhl.nkf == null || !this.nhl.nkf.mInPKMode) {
                ((VideoPlayer) this.nnJ).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nim) {
                f(this.nhY.getText().toString());
            } else {
                a(this.nhY.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dIT().c) {
                com.kascend.chushou.d.h.dIT().b(false);
                this.nhU.cancel();
                this.nhU.reset();
                this.nhT.clearAnimation();
                this.nhV.setVisibility(8);
            }
            m(view, 0, this.nnt.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nnJ, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            l(view, x, this.nnt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.nnI.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.nnJ, null) && this.nnI != null && this.nnI.ngT != null) {
                if (this.nim) {
                    bg();
                    return;
                }
                if (this.nnI != null && this.nnI.ngT != null && this.nnI.ngT.count > 0) {
                    this.nia.setVisibility(8);
                } else {
                    this.nia.setVisibility(0);
                }
                this.nim = true;
                this.nij.setBackgroundResource(a.e.ic_trumpet_p);
                this.nik.setVisibility(0);
                this.nik.setSelected(true);
                this.nik.setTextColor(Color.parseColor("#ff5959"));
                if (this.nhY != null) {
                    this.nhY.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.nil <= 9) {
                this.nil++;
                this.nii.setText(this.nil + "");
            }
            dKp();
        } else if (id == a.f.tv_cut_count) {
            if (this.nil > 1) {
                this.nil--;
                this.nii.setText(this.nil + "");
            }
            dKp();
        } else if (id == a.f.tv_buy_head) {
            dKq();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.niU.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.niU.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dF(this.niU);
                this.non.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nhY != null && this.nhR != null && this.nhX != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.nhY);
                this.nhR.setVisibility(8);
                if (this.bB == 2) {
                    this.nhX.setVisibility(0);
                }
            }
        } else if (this.nhR != null && this.nhX != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
            if (this.bB == 2) {
                this.nhR.setVisibility(0);
            }
            this.nhX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dIT().c(roomToast.mToastContent);
            if (this.niG == null) {
                dKd();
            }
            if (this.niH != null) {
                this.niH.setText(roomToast.mToastContent);
            }
            if (!this.niG.isShowing()) {
                if (this.niv != null) {
                    this.niG.showAtLocation(this.niv, 85, 0, this.nnt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.niG != null) {
                                a.this.niG.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.niG.dismiss();
        }
    }

    private void dKd() {
        if (this.niG == null) {
            View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.niH = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.niG = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 160.0f), -2);
            this.niG.setFocusable(false);
            this.niG.setOutsideTouchable(false);
            this.niG.setAnimationStyle(a.j.gift_toast_style);
            this.niG.update();
        }
    }

    private void l(View view, int i, int i2) {
        if (this.noi != null && this.noi.isShowing()) {
            this.noi.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
        if (this.noG == null) {
            dKF();
        }
        if (!this.noG.isShowing()) {
            this.noG.showAtLocation(view, 83, i, i2);
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nnI.dJF().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.noG.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dKe() {
        if (this.noJ != null) {
            if (h.isEmpty(this.noK)) {
                if (((VideoPlayer) this.nnJ).q) {
                    this.noJ.bU(this.nnI != null ? this.nnI.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.noJ.bU(this.nnI != null ? this.nnI.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.nnJ).q && this.noK.size() == 2 && this.noK.contains("4") && this.noK.contains("2")) {
                this.noJ.bU(this.nnI != null ? this.nnI.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.noK.size() > 1 || !((VideoPlayer) this.nnJ).q) {
                this.noJ.bU(this.nnI != null ? this.nnI.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.noK.get(0))) {
                this.noJ.bU(this.nnI != null ? this.nnI.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.noK.get(0))) {
                this.noJ.bU(this.nnI != null ? this.nnI.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.noK.get(0))) {
                this.noJ.bU(this.nnI != null ? this.nnI.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void m(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
        if (this.noi == null) {
            al();
            this.noi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.noi.isShowing() && this.bB == 2) {
            this.noi.showAtLocation(view, 83, i, this.nnJ.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nnI.dJF().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.noi.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nnC != null) {
            this.nnC.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                g.c(this.nnJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nke.getPlayState() == 4) {
                        e(true);
                        if (this.nnI.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.nnI.a(false);
                        ((VideoPlayer) this.nnJ).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.nke.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nke.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                g.c(this.nnJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.nnI.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nnJ).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
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
        if (this.nox != null) {
            if (z) {
                this.nox.setVisibility(0);
            }
            this.nox.dVU();
            if (!z) {
                this.nox.setVisibility(8);
            }
        }
        g.c(this.nnJ, this.nnJ.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nhL != null) {
                this.nhL.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nnD != null) {
                this.nnD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nhL != null) {
            this.nhL.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nnD != null) {
                    this.nnD.setVisibility(8);
                }
            }
        }
    }

    private void dKf() {
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
        int i2 = this.nhx[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dJW();
            a(this.nnI != null ? this.nnI.ngU.get("1") : null);
            if (i2 == 2) {
                k();
                aw(true, i3);
                v(true);
                b(true);
                dKi();
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aw(false, i3);
            v(false);
            b(false);
            if (this.noi != null && this.noi.isShowing()) {
                this.noi.dismiss();
            }
            if (i2 == 99) {
                if (this.nhy != null && this.nhy[i] != null && (this.nhy[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.nhy[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, "房间信息页_num", null, new Object[0]);
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
        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.nnK != null) {
            if (this.nhX != null && this.nhX.getVisibility() == 0) {
                u(false);
            }
            if (this.nnD != null && this.nnD.getVisibility() == 0) {
                this.f = true;
            }
            av(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nhA != null) {
            this.nhA.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nhA != null) {
            this.nhA.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.nhA != null) {
            this.nhA.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nhA != null) {
            this.nhA.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.niv != null) {
            int size = iconConfig.configs.size();
            this.niv.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.niv, false);
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
                this.niv.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.nnI != null ? this.nnI.ngU : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.nhA != null) {
            this.nhA.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dKe();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nis != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.nis.zs(a.c.kas_white);
            } else if (this.bB == 2) {
                this.nis.bU(str, a.c.kas_white);
                if (this.nit != null) {
                    this.nit.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.nis.zs(a.c.kas_white);
                if (this.nit != null) {
                    this.nit.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.nit != null) {
                    this.nit.setTextColor(a);
                    this.nit.setTabTextSelectColor(a2);
                    this.nit.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nhT != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.nhT.zs(a.e.ic_hotwords_black_n);
            } else {
                this.nhT.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.nhS != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dKS().a(str, this.nhS, a.e.player_skin_input);
            } else {
                this.nhS.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.nhW != null) {
                this.nhW.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void a(int i) {
        if (this.nhA != null) {
            this.nhA.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void D() {
        if (this.nnJ instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dJl = ((VideoPlayer) this.nnJ).dJl();
            if (this.noA == null) {
                this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.noA.setVisibility(0);
            this.noA.a(2, dJl);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nhA != null) {
            this.nhA.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nhA != null) {
            this.nhA.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(long j) {
        if (this.nhA != null) {
            this.nhA.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0828a
    public void c(int i) {
        if (this.nhA != null) {
            this.nhA.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nhA != null && this.nnI != null) {
            this.nhA.b(this.nnI.ngS);
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
    public class C0821a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0821a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.nhx.length) {
                return null;
            }
            switch (a.this.nhx[i]) {
                case 1:
                    if (a.this.nhz == null) {
                        a.this.nhz = com.kascend.chushou.view.user.a.a(2, null, a.this.nnI.a, false, a.this.nnI.h, false);
                    }
                    a.this.nhy[i] = a.this.nhz;
                    return a.this.nhz;
                case 2:
                    if (a.this.nhA == null) {
                        a aVar = a.this;
                        if (a.this.nhl != null && a.this.nhl.nkf != null) {
                            z = a.this.nhl.nkf.mInPKMode;
                        }
                        aVar.nhA = com.kascend.chushou.player.ui.a.xa(z);
                    }
                    a.this.nhy[i] = a.this.nhA;
                    return a.this.nhA;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.nnI != null && a.this.nnI.dJF() != null && !h.isEmpty(a.this.niA)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.niA.get(i).url);
                        h5Options.a = a.this.niA.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.nhy[i] = a;
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
            return a.this.nhx.length;
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
            int dimensionPixelSize = a.this.nnJ.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
        } else if (System.currentTimeMillis() - this.nhr <= 3000) {
            g.LI(a.i.str_too_fast);
            return false;
        } else {
            dKk();
            if (!com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a(((VideoPlayer) this.nnJ).dJf().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nhr = System.currentTimeMillis();
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                a(this.nnI.dJF().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nnI.h);
            }
            g(this.b);
            if (!z && this.nhY != null) {
                this.nhY.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dKk();
            if (com.kascend.chushou.d.e.c(this.nnJ, null) && LoginManager.Instance().getUserInfo() != null && this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                a(this.nnI.dJF().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nhY != null) {
                this.nhY.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.nhA != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.nnI.dJF().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nnI.dJF().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nnJ).nfj;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Tf(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.nhA.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.nhA.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.nhA != null) {
            this.nhA.e();
        }
        if (this.niy != null && this.niy.isShown()) {
            this.niy.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dKg() {
        super.dKg();
        if (this.nnJ instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.nnI != null) {
            this.nnI.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.nnJ != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.nnJ).t)) {
                this.cx = true;
                if (this.nnI != null) {
                    this.nnI.f = null;
                    if (this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                        this.nnI.dJF().mRoominfo.mGameId = null;
                    }
                }
                dJY();
                return;
            }
            this.cx = true;
            if (this.nnJ != null) {
                ((VideoPlayer) this.nnJ).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.nhJ != null) {
            this.nhJ.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.nhJ != null) {
            this.nhJ.setVisibility(8);
        }
        super.i(z);
    }

    private void dKh() {
        aN();
        if (i()) {
            dKj();
            ap();
            return;
        }
        dJY();
    }

    private void dKi() {
    }

    private void dKj() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dKE().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.nox != null) {
            this.nox.setVisibility(0);
        }
        if (this.nhh != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.nhh.d();
        }
        if (this.nhR != null) {
            this.nhR.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.nhG.setVisibility(0);
            this.nhG.setOnClickListener(this);
        } else {
            this.nhG.setVisibility(8);
        }
        this.nhL.setVisibility(0);
        this.nhH.setVisibility(0);
        this.nnA.setVisibility(0);
        if (this.p) {
            this.nnB.setVisibility(0);
        } else {
            this.nnB.setVisibility(8);
        }
        dKi();
        aw(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.noA != null && this.noA.a(i, keyEvent)) {
                return true;
            }
            if (this.niD != null && this.niD.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.niE != null && this.niE.onKeyDown(i, keyEvent)) || dKl()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.niV != null && this.niV.getVisibility() == 0 && b(motionEvent, this.niV)) {
                this.niV.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dF(this.niU);
                return true;
            } else if (this.niw && this.niV != null && this.niV.getVisibility() == 8 && f(this.non.b, motionEvent)) {
                dKc();
                return true;
            } else if (this.niD != null && this.niD.b() && f(this.niD, motionEvent)) {
                this.niD.a();
                return true;
            } else if (this.niE != null && this.niE.b() && f(this.niE, motionEvent)) {
                this.niE.a();
                return true;
            } else if (b(motionEvent, this.nhX)) {
                return dKk();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dKk() {
        boolean z;
        b(this.niF, 10);
        boolean z2 = false;
        if (this.nin != null && this.nin.getVisibility() == 0) {
            this.nin.setVisibility(8);
            this.nio.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nip) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
            this.nio.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nhX == null || this.nhX.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nim) {
                bg();
            }
            this.nhX.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nhR != null && a.this.bB == 2) {
                        a.this.nhR.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dKl() {
        if (dKk()) {
            return true;
        }
        if (this.noi == null || !this.noi.isShowing()) {
            return dKc() || az() || dxH();
        }
        this.noi.dismiss();
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
    public void dKm() {
        this.nhR.setVisibility(8);
        this.nhX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(boolean z, boolean z2) {
        if (this.nhR != null) {
            if (z) {
                if (this.nhR.getVisibility() != 0) {
                    this.nhR.setVisibility(0);
                    this.nhR.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_bottom_anim));
                }
            } else if (this.nhR.getVisibility() != 4) {
                this.nhR.setVisibility(4);
                this.nhR.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nhJ != null) {
            this.nhJ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dKn() {
        return this.niJ;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.nnI != null) {
                        this.nnI.f = null;
                        this.nnI.dJF().mRoominfo.mGameId = null;
                    }
                    dJY();
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
        if (this.nnI != null && this.nnI.dJG() != null) {
            a(this.nnI.dJG());
        }
        this.p = false;
        if (this.nnI == null || this.nnI.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nnI.f.size()) {
                if (!"2".equals(this.nnI.f.get(i2).mType)) {
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
        if (this.nhA != null) {
            this.nhA.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.nhM != null && this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                this.nhM.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.nnI.dJF().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.niB && (c = c(1, -1)) >= 0 && c < this.niA.size() && this.niu != null) {
            this.niu.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.niB) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dJm = ((VideoPlayer) this.nnJ).dJm();
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(2, dJm);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dJn = ((VideoPlayer) this.nnJ).dJn();
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(2, dJn);
            } else if (bVar.a == 9) {
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nin != null) {
            this.nin.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.niB) {
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
        if (!aa() && this.nnI != null) {
            String str = this.nnI.a;
            RoomInfo dJI = this.nnI.dJI();
            if (dJI != null && mVar.a(dJI.mCreatorUID, str)) {
                dJI.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.nhY != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.nhY);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
            if (this.nix == null) {
                this.nix = new f(getActivity());
            }
            this.nix.a(this.nnI.dJF().mRoominfo);
            if (!this.nix.isShowing()) {
                this.nix.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nhA != null) {
            this.nhA.d();
        }
    }

    private void du(View view) {
        this.nhN = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nhO = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nhO.setText(new tv.chushou.zues.widget.a.c().J(this.nnJ, a.e.videoplayer_4g_video).append("  ").append(this.nnJ.getString(a.i.videoplayer_4g_video)));
        this.nhP = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nhP.setText(new tv.chushou.zues.widget.a.c().J(this.nnJ, a.e.videoplayer_4g_audio).append("  ").append(this.nnJ.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.nhN.setVisibility(8);
                    ((VideoPlayer) a.this.nnJ).c(a.this.nhQ);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.nhN.setVisibility(8);
                    ((VideoPlayer) a.this.nnJ).d(a.this.nhQ);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dIM().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.nhO.setOnClickListener(onClickListener);
        this.nhP.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nnI != null && !h.isEmpty(this.nnI.f)) {
            f(this.nnI.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nhQ = z;
            this.p = false;
            if (this.nnI != null && this.nnI.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nnI.f.size()) {
                        break;
                    } else if (!"2".equals(this.nnI.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nhN != null) {
                this.nhN.setVisibility(0);
                this.nhO.setVisibility(0);
                this.nhP.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nhN != null) {
            this.nhN.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.niN == null) {
                this.niN = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.nnK != null) {
                    this.nnK.e(this.niN, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.niN != null && this.nnK != null) {
            this.nnK.P(this.niN);
            this.niN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.nhA != null) {
            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "显示双击666_num", null, new Object[0]);
            if (this.nnI != null) {
                this.nnI.b(false);
            }
            d(false);
            this.nhA.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.nnt != null) {
            if (this.niE == null) {
                this.niE = (InteractionView) ((ViewStub) this.nnt.findViewById(a.f.view_interaction)).inflate();
                this.niE.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.niE.a();
                    }
                });
            }
            if (this.niE != null) {
                this.niE.b(configDetail);
                this.niE.c();
                this.niE.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dWH()) {
                g.F(this.nnJ, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nnJ, null) && (this.nnJ instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nnJ, configDetail.mUrl, this.nnJ.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nnJ, null)) {
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
        if (this.niw) {
            dKc();
            return;
        }
        if (this.nnJ.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击送礼_num", "竖屏", new Object[0]);
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnI.dJF().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.nnJ != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nhl == null) {
                this.nhl = new com.kascend.chushou.player.e.a();
            }
            this.nhl.b = str;
            this.nhl.nkf.copy(pkNotifyInfo);
            if (this.nhl.nkf.mAction == 6) {
                this.nhl.nkf.mInPKMode = true;
                this.u = this.nhl.nkf.mPkId;
            } else if (this.nhl.nkf.mAction == 7 || (this.nhl.nkf.mMode == 1 && this.nhl.nkf.mAction == 5)) {
                this.nhl.nkf.mInPKMode = true;
                this.u = this.nhl.nkf.mPkId;
                if (dKo() != null) {
                    if (2 == this.bB && this.niQ != null) {
                        this.niQ.setVisibility(0);
                    }
                    dKo().b(this.nhl.nkf, false);
                    dKo().a(this.nhl.nkf.mMode, "1");
                    if (this.nhl.nkf.mAction == 5 && this.nhl.nkf.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nhl.nkf.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nhl.nkf.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nhl.nkf.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nhl.nkf.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nhl.nkf.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dKo().a(this.nhl.nkf);
                        if (this.nhl.nkf.destinyInfo == null || this.nhl.nkf.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dKo().a(parseInt, this.nhl.nkf.mPkUpdateInfo.remainDuration, j, this.nhl.nkf.mMode, i);
                    }
                    if (!h.isEmpty(this.nhl.nkf.mPkUpdateInfo.specialMomentList) && dKo() != null) {
                        dKo().a(this.nhl.nkf, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Rl(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.nhl.nkf.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Rl(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.nhl != null && this.nhl.nkf != null) {
            if (this.nhl.nkf.mInPKMode) {
                this.y.setText(this.nhl.nkf.mPkUserNickname);
                this.nhn.setVisibility(0);
                if (this.nnz != null) {
                    this.nnz.setEnabled(false);
                }
                if (this.nnB != null) {
                    this.nnB.setEnabled(false);
                    return;
                }
                return;
            }
            this.nhn.setVisibility(8);
            if (this.nnz != null) {
                this.nnz.setEnabled(true);
            }
            if (this.nnB != null) {
                this.nnB.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dKo() {
        if (this.nnJ == null || this.nnt == null || this.niQ == null) {
            return null;
        }
        if (this.nhm == null) {
            if (this.niP == null) {
                this.niP = ((ViewStub) this.nnt.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.nhm = new com.kascend.chushou.player.e.b();
            this.nhm.a(this.niQ, this.niP, (View) null, this.nnJ, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dWn()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.nnI != null) {
                        append.append(a.this.nnI.dJI().mRoomID);
                    }
                    if (a.this.nhl != null && a.this.nhl.nkf != null) {
                        append.append("&mode=").append(a.this.nhl.nkf.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.nnJ, append.toString());
                }
            });
        }
        return this.nhm;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nik != null && this.nnI != null && this.nnI.ngT != null) {
            this.nik.setText(tv.chushou.zues.utils.b.LH(this.nnI.ngT.count));
            this.nik.setVisibility(0);
            if (this.nnI.ngT.count < 1) {
                bg();
            }
            if (this.nib != null) {
                this.nib.setText(this.nnI.ngT.primaryName);
            }
            if (this.nic != null) {
                this.nic.setText(this.nnI.ngT.desc);
            }
            dKp();
        }
    }

    public void dKp() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nil * h.parseLong(this.nnI.ngT.point)));
        if (this.nif != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nnJ.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nnJ, a.e.icon_coin_new);
            cVar.append(this.nnJ.getString(a.i.str_buy_count_coin2));
            this.nif.setText(cVar);
        }
    }

    private void dKq() {
        if (com.kascend.chushou.d.e.c(this.nnJ, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nil);
        }
    }

    private void v(boolean z) {
        if (this.nnt != null && this.niQ != null) {
            if (z) {
                if (this.nhl != null && this.nhl.nkf != null && this.nhl.nkf.mInPKMode) {
                    this.niQ.setVisibility(0);
                    return;
                }
                return;
            }
            this.niQ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nnt != null && this.nhq != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.nhq.setVisibility(0);
                    return;
                }
                return;
            }
            this.nhq.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.nhl != null && this.nhl.nkf != null && this.nhl.nkf.mInPKMode && this.nhn != null) {
                this.nhn.setVisibility(0);
            }
        } else if (this.nhn != null) {
            this.nhn.setVisibility(8);
        }
    }

    private void bg() {
        this.nim = false;
        this.nij.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nnI != null && this.nnI.ngT != null) {
            if (this.nnI.ngT.count < 1) {
                this.nik.setVisibility(8);
            } else {
                this.nik.setVisibility(0);
                this.nik.setSelected(false);
                this.nik.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nia.setVisibility(8);
        if (this.nhY != null) {
            this.nhY.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nhW != null) {
            this.nhW.performClick();
        }
    }

    public boolean dKr() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.njb = true;
        if (this.nnt != null && com.kascend.chushou.b.dIM().d == 0) {
            this.niL = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
            if (!z) {
                View findViewById = this.nnt.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.niL = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.niL);
            View findViewById2 = this.nnt.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.niL);
            findViewById2.requestLayout();
        }
    }
}
