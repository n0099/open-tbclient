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
    private int[] ojE;
    private Fragment[] ojF;
    private ImageView ojJ;
    private MarqueeTextView ojK;
    private MarqueeTextView ojL;
    private ImageView ojM;
    private ImageView ojN;
    private ImageButton ojO;
    public String ojP;
    private RecommendView ojQ;
    private TextView ojT;
    private RelativeLayout ojU;
    private TextView ojV;
    private TextView ojW;
    private boolean ojX;
    private RelativeLayout ojY;
    private View ojZ;
    private LinearLayout okA;
    private f okC;
    private ViewMicPerson okD;
    public ArrayList<RoomTab> okF;
    private PopH5Menu okH;
    private InteractionView okI;
    private int okJ;
    private PopupWindow okK;
    private TextView okL;
    private GiftAnimationLayout okM;
    private com.kascend.chushou.player.b.a okN;
    private Runnable okR;
    private View okT;
    private LivePKBarUserValue okU;
    private String okV;
    private TextView okW;
    private ImageView okX;
    private EditText okY;
    private View okZ;
    private FrescoThumbnailView oka;
    private AnimationSet okb;
    private ImageView okc;
    private TextView okd;
    private RelativeLayout oke;
    private PastedEditText okf;
    private TextView okg;
    private LinearLayout okh;
    private TextView oki;
    private TextView okj;
    private TextView okk;
    private TextView okl;
    private TextView okm;
    private TextView okn;
    private TextView oko;
    private ImageView okp;
    private TextView okq;
    private KPSwitchPanelLinearLayout okt;
    private ImageView oku;
    private c okv;
    private d.a okw;
    private FrescoThumbnailView okx;
    private PagerSlidingTabStrip oky;
    private KasViewPager okz;
    private View ola;
    private View olb;
    private String olf;
    private long ojy = 0;
    private com.kascend.chushou.view.user.a ojG = null;
    private com.kascend.chushou.player.ui.a ojH = null;
    private int bB = -1;
    private int bC = 0;
    private View ojI = null;
    private View ojR = null;
    private ImageButton ojS = null;
    private int okr = 1;
    private boolean oks = false;
    private boolean cp = false;
    private boolean okB = false;
    private boolean cx = false;
    private boolean okE = false;
    private boolean okG = false;
    private boolean cC = true;
    private int okO = 0;
    private int okP = 0;
    private int okQ = -1;
    private final Rect okS = new Rect();
    private boolean olc = false;
    private C0903a old = null;
    private boolean ole = false;
    private boolean olg = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ojP = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.opD = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.opD;
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
        this.okG = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.oqx != null) {
            this.oqx.b();
        }
        if (this.opS != null && (this.opS instanceof VideoPlayer)) {
            ((VideoPlayer) this.opS).zk(true);
            ((VideoPlayer) this.opS).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.okG = true;
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
        this.okr = 1;
        this.oks = false;
        U();
        if (this.opT != null) {
            this.opT.co(null);
            this.opT = null;
        }
        if (this.ojQ != null) {
            ehS().removeAllViews();
            this.ojQ = null;
        }
        this.c = null;
        this.ojm = null;
        tv.chushou.zues.a.a.cp(this);
        this.oky = null;
        this.okz = null;
        this.ojH = null;
        this.ojG = null;
        if (this.ojF != null) {
            for (int i = 0; i < this.ojF.length; i++) {
                this.ojF[i] = null;
            }
        }
        this.ojF = null;
        if (this.okf != null) {
            this.okf.addTextChangedListener(null);
            this.okf.setOnTouchListener(null);
            this.okf.setOnEditorActionListener(null);
            this.okf = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.opS, this.okv);
        if (this.opS != null && (this.opS instanceof VideoPlayer)) {
            ((VideoPlayer) this.opS).egz();
        }
        this.okw = null;
        this.okv = null;
        if (this.okD != null) {
            this.okD.b();
            this.okD = null;
        }
        if (this.okK != null) {
            this.okK.dismiss();
        }
        if (this.okN != null) {
            this.okN.a();
            this.okN = null;
            this.okM = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.okU = (LivePKBarUserValue) this.opD.findViewById(a.f.live_pk_bar_user);
        this.opL = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.olc) {
            this.olc = true;
            if (this.ola == null) {
                this.ola = this.opD.findViewById(a.f.vs_async_view);
                this.ola = ((ViewStub) this.ola).inflate();
            }
            if (this.olb == null) {
                this.olb = this.opD.findViewById(a.f.vs_async_notification_view);
                this.olb = ((ViewStub) this.olb).inflate();
            }
            this.ojx = (VoiceInteractionView) this.opD.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.opD);
            dUv();
            ((VideoPlayer) this.opS).q();
            this.ojs = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.okx = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.oky = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.okz = (KasViewPager) view.findViewById(a.f.vp_main);
        ehg();
        aI();
        ehk();
        if (this.opR != null) {
            I();
            a(this.opR.oiY, this.opR.ojb);
        }
        this.bb = 0;
        this.oqC = 0L;
        this.oqy = (RoundProgressBar) this.opD.findViewById(a.f.roundProgressBar);
        this.oqz = (TextView) this.opD.findViewById(a.f.tv_paonum);
        this.oqA = (FrescoThumbnailView) this.opD.findViewById(a.f.iv_paoicon);
        this.oqH = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.okB = false;
                if (a.this.bB == 2) {
                    a.this.aE(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.okJ, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.okB = true;
                if (a.this.bB == 2) {
                    a.this.aE(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.oqx != null) {
                    a.this.oqx.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hj(a.this.opS).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.opS)) - a.this.oqx.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.opS, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.opS, 54.0f) * 2);
                    if (statusBarHeight < a.this.okJ) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.oqB = (PaoGuideView) this.opD.findViewById(a.f.rlPaoGuideView);
        this.okD = (ViewMicPerson) this.opD.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.omi = ((VideoPlayer) this.opS).egs();
        this.opR = ((VideoPlayer) this.opS).egv();
        e(this.opD);
        this.okO = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
        this.okP = tv.chushou.zues.utils.systemBar.b.aD(getActivity());
        if (com.kascend.chushou.b.egb().d == 0 && this.okP > 0) {
            View findViewById = this.opD.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.okP);
        }
        ehp();
        ehn();
        if (!this.cC) {
            Q();
        }
        ehl();
        a();
        if (this.c == null) {
            this.ojm = new d.a();
            this.c = new GestureDetector(this.opS, this.ojm);
        }
        this.ojo = ((VideoPlayer) this.opS).egw();
        this.ojo.a(this);
        if (this.okN != null) {
            this.okN.a();
            this.okN = null;
        }
        this.okM = (GiftAnimationLayout) this.opD.findViewById(a.f.ll_gift_animation);
        this.okM.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.opR != null) {
            this.okN = new com.kascend.chushou.player.b.a(this.opS.getApplicationContext(), this.okM);
            this.okN.a(this.opR);
        }
        if (this.f4123a == null) {
            this.f4123a = (ImageButton) this.opD.findViewById(a.f.resumebutton);
            this.f4123a.setOnTouchListener(this);
        }
        this.opM = (PlayerErrorView) this.opD.findViewById(a.f.view_net_error_msg);
        this.opM.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        ehs();
        if (this.opR.egV() != null) {
            a(this.opR.egV());
        }
        FullRoomInfo egU = this.opR.egU();
        if (egU != null) {
            ehw();
            if (i()) {
                this.ak = false;
                zn(true);
                this.opT.PH(8);
            }
            this.ojT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(egU.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.opE != null) {
            this.opE.setVisibility(0);
        }
        this.ojI.setVisibility(0);
        this.ak = false;
        zn(true);
        this.opT.PH(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.opS).n();
        if (this.opR != null && !h.isEmpty(this.opR.w)) {
            b(this.opR.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a egG;
        ehg();
        k();
        FullRoomInfo egU = this.opR.egU();
        if (egU != null) {
            if (egU.mRoominfo != null) {
                this.ojT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(egU.mRoominfo.mOnlineCount)));
                this.okV = egU.mRoominfo.mRoomID;
            }
            ehw();
            if (!h.isEmpty(egU.mRoomToastList)) {
                Iterator<RoomToast> it = egU.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.egj().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.opR != null && this.opR.l()) {
                d(true);
            }
            if (this.opS != null && (this.opS instanceof VideoPlayer) && (egG = ((VideoPlayer) this.opS).egG()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(egG.omj, egG.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.okA);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void ehg() {
        boolean z = true;
        if (this.opR == null || this.opR.egU() == null || this.opR.egU().mRoominfo == null || h.isEmpty(this.opR.egU().mRoomTabs)) {
            this.okE = false;
            this.ojF = new Fragment[2];
            this.ojE = new int[2];
            this.ojE[0] = 2;
            this.ojE[1] = 1;
            return;
        }
        this.okE = true;
        this.okF = new ArrayList<>();
        Iterator<RoomTab> it = this.opR.egU().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.okF.add(next);
            }
        }
        if (this.okF.size() >= 2 && this.ojE != null && this.ojE.length >= 2 && this.okF.get(0).type == this.ojE[0] && this.okF.get(1).type == this.ojE[1]) {
            z = false;
        }
        this.ojF = new Fragment[this.okF.size()];
        this.ojE = new int[this.okF.size()];
        for (int i = 0; i < this.okF.size(); i++) {
            this.ojE[i] = this.okF.get(i).type;
        }
        if (z) {
            this.old = new C0903a(getChildFragmentManager());
            this.okz.setAdapter(this.old);
        }
    }

    private void aI() {
        this.oke = (RelativeLayout) this.opD.findViewById(a.f.rl_edit_bar);
        this.oka = (FrescoThumbnailView) this.opD.findViewById(a.f.btn_hotword);
        this.oka.Dr(a.e.ic_hotwords_black_n);
        this.oka.setOnClickListener(this);
        this.okc = (ImageView) this.opD.findViewById(a.f.iv_task_badge);
        this.okb = (AnimationSet) AnimationUtils.loadAnimation(this.opS, a.C0897a.anim_hotword);
        this.okb.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.egj().c) {
                    a.this.oka.clearAnimation();
                    a.this.oka.startAnimation(a.this.okb);
                }
            }
        });
        if (com.kascend.chushou.d.h.egj().c) {
            this.oka.startAnimation(this.okb);
            this.okc.setVisibility(0);
        }
        this.okd = (TextView) this.opD.findViewById(a.f.tv_bottom_input);
        this.okd.setOnClickListener(this);
        this.oqS = (FrescoThumbnailView) this.opD.findViewById(a.f.ll_btn_set);
        this.oqS.setOnClickListener(this);
        this.okA = (LinearLayout) this.opD.findViewById(a.f.ll_bottom_all_button);
        this.ojY = (RelativeLayout) this.opD.findViewById(a.f.rl_bottom_input);
        this.ojZ = this.opD.findViewById(a.f.ll_bottom_input);
        this.ojY.setVisibility(8);
        this.okf = (PastedEditText) this.opD.findViewById(a.f.et_bottom_input);
        this.okf.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.okg.setEnabled(editable.length() > 0);
            }
        });
        this.okf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.okg);
                    return true;
                }
                return true;
            }
        });
        this.okf.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.n(a.this.okf);
                }
                return false;
            }
        });
        this.oku = (ImageView) this.opD.findViewById(a.f.iv_btn_emoji);
        this.oku.setVisibility(8);
        this.okg = (TextView) this.opD.findViewById(a.f.tv_btn_send);
        this.okg.setOnClickListener(this);
        this.okt = (KPSwitchPanelLinearLayout) this.opD.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.egb().d == 0) {
            this.okt.setUseStatusBar(true);
        }
        this.okh = (LinearLayout) this.opD.findViewById(a.f.head_trumpet);
        this.okh.setVisibility(8);
        this.okh.setOnClickListener(this);
        this.oki = (TextView) this.opD.findViewById(a.f.tv_primary_name);
        this.okj = (TextView) this.opD.findViewById(a.f.tv_primary_desc);
        this.okm = (TextView) this.opD.findViewById(a.f.tv_cut_count);
        this.okm.setOnClickListener(this);
        this.oko = (TextView) this.opD.findViewById(a.f.tv_head_count);
        this.oko.setText(this.okr + "");
        this.okn = (TextView) this.opD.findViewById(a.f.tv_plus_count);
        this.okn.setOnClickListener(this);
        this.okl = (TextView) this.opD.findViewById(a.f.tv_buy_count_coin);
        this.okk = (TextView) this.opD.findViewById(a.f.tv_buy_head);
        this.okk.setOnClickListener(this);
        this.okp = (ImageView) this.opD.findViewById(a.f.iv_trumpet_select);
        this.okp.setOnClickListener(this);
        this.okq = (TextView) this.opD.findViewById(a.f.tv_trumpet_have_count);
        this.oks = false;
        this.okp.setBackgroundResource(a.e.ic_trumpet_n);
        this.okq.setVisibility(8);
        ehi();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.okt, this.oku, this.okf, new a.InterfaceC1033a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1033a
            public void zl(boolean z) {
                if (a.this.oku != null) {
                    if (!z) {
                        a.this.oku.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.egb().d == 0) {
                        a.this.okt.setDirectVisibility(0);
                    }
                    a.this.oku.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.okw = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void jK(boolean z) {
                if (a.this.olg) {
                    a.this.olg = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.oku.setImageResource(a.e.cs_emoji_normal);
                    a.this.ehh();
                    return;
                }
                if (a.this.okZ != null && a.this.okZ.getVisibility() == 0) {
                    a.this.okZ.setVisibility(8);
                }
                if (a.this.okB) {
                    a.this.oqx.setVisibility(0);
                }
                if (a.this.opS != null && (a.this.opS instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.opS).zk(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.okv = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.okt, this.okw, ((VideoPlayer) this.opS).egA());
        ((VideoPlayer) this.opS).h(((VideoPlayer) this.opS).egA());
        this.okZ = this.opD.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.okW = (TextView) this.opD.findViewById(a.f.btn_room_search);
        this.okX = (ImageView) this.opD.findViewById(a.f.iv_room_emoji_delete);
        this.okY = (EditText) this.opD.findViewById(a.f.et_room_emoji_search);
        this.okY.setImeOptions(3);
        this.okY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.okW);
                    return true;
                }
                return false;
            }
        });
        this.okY.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.okW.setEnabled(editable.length() > 0);
                a.this.okX.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.oqx.setEmojiSearchText(editable.toString());
            }
        });
        this.okW.setOnClickListener(this);
        this.okX.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aC(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.by(this.okY);
            this.okZ.setVisibility(0);
            this.okY.requestFocus();
        } else {
            this.okZ.setVisibility(8);
        }
        if (z2) {
            this.okY.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehh() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hj(this.opS).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS)) - tv.chushou.zues.widget.kpswitch.b.d.ek(this.opS)) - tv.chushou.zues.utils.a.dip2px(this.opS, 14.0f)) - this.opS.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.opS, 54.0f) * 2);
        if (statusBarHeight < this.okJ) {
            b(statusBarHeight, 10);
        }
    }

    private void ehi() {
    }

    private void aL() {
        this.opT = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aD(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.opD.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.opS.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.opT.D(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.opT.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.opT.D(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.opT);
                            break;
                        case 12:
                            a.this.b(a.this.opT);
                            break;
                        case 17:
                            a.this.ehU();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.opQ.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void ehj() {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.okF)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.okF.size()) {
                    if (!h.isEmpty(this.okF.get(i2).notifyIcon)) {
                        this.oky.bY(i2, this.okF.get(i2).notifyIcon);
                        this.oky.Qc(i2);
                    } else if (this.okF.get(i2).notify == 1) {
                        this.oky.Qb(i2);
                        this.oky.Qa(i2);
                    } else {
                        this.oky.Qa(i2);
                        this.oky.Qc(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.okF)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.okF.size()) {
                    if (this.okF.get(i4).type == i) {
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
    public String Oo(int i) {
        if (this.opR == null || this.opR.egU() == null || this.opR.egU().mRoominfo == null || h.isEmpty(this.okF)) {
            if (i == 1) {
                return this.opS.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.opS.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.okF.size()) {
            return this.okF.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.okF) && i < this.okF.size()) {
            this.okF.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.okF) && i < this.okF.size()) {
            this.okF.get(i).notifyIcon = str;
        }
    }

    private void ehk() {
        if (this.okz != null && this.oky != null && this.ojE != null) {
            this.ojH = null;
            if (this.ojF != null) {
                for (int i = 0; i < this.ojF.length; i++) {
                    this.ojF[i] = null;
                }
            }
            if (this.old == null) {
                this.old = new C0903a(getChildFragmentManager());
                this.okz.setAdapter(this.old);
            } else {
                this.old.notifyDataSetChanged();
            }
            this.okz.setOffscreenPageLimit(this.ojE.length);
            this.oky.c(this.okz);
            this.oky.setOnPageChangeListener(this);
            this.oky.notifyDataSetChanged();
            this.oky.setVisibility(0);
            this.okz.setVisibility(0);
            if (!this.okE) {
                this.bB = 2;
                this.okz.setCurrentItem(c(2, 0));
                this.ojY.setVisibility(0);
            } else {
                if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                    if (!h.isEmpty(this.opR.egU().mRoominfo.mGameName)) {
                        this.ojL.setText(this.opR.egU().mRoominfo.mGameName);
                    } else {
                        this.ojL.setText(this.opS.getString(a.i.no_online_game_name));
                    }
                    this.ojK.setText(this.opR.egU().mRoominfo.mName);
                } else {
                    this.ojL.setText(this.opS.getString(a.i.no_online_game_name));
                }
                ehj();
                if (i()) {
                    eht();
                    if (this.okz != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.okz.setCurrentItem(c);
                        this.oky.setSelectItem(c);
                    }
                } else if (this.okz != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.okz.setCurrentItem(c2);
                    this.oky.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void ehl() {
        this.opE = new SurfaceView(this.opS);
        SurfaceView surfaceView = (SurfaceView) this.opE;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ehS().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void ehm() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.opS).s();
        dUA();
        ehq();
        ehf();
        ehS().setBackgroundResource(a.e.room_not_online);
        if (this.ojQ == null) {
            this.ojQ = new RecommendView(this.opS);
            ehS().addView(this.ojQ);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.opS);
            this.ojQ.setLayoutParams(layoutParams);
        }
        if (this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.opR.egU().mRoominfo.mRoomID)) {
            this.ojQ.a(this.opR.egU().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.opS != null && a.this.ehS() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.opS);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.nOZ);
                        if (a.this.ehS().getChildCount() >= 2) {
                            a.this.ehS().addView(frescoThumbnailView, 0);
                        }
                        a.this.ehS().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.etR(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.opE != null) {
            this.opE.setVisibility(8);
        }
        if (this.oqF != null) {
            this.oqF.etn();
            this.oqF.setVisibility(8);
        }
        m(false, false, true);
        if (this.f4123a != null) {
            this.f4123a.setVisibility(8);
        }
        if (this.oqx != null) {
            this.oqx.e();
        }
        zn(false);
        a(false, false);
        if (this.ojo != null) {
            this.ojo.d();
        }
    }

    private void ehn() {
        int i = 0;
        this.ojI = this.opD.findViewById(a.f.topview);
        if (com.kascend.chushou.b.egb().d == 0 && this.okO > 0) {
            View findViewById = this.opD.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.okO;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.ojJ = (ImageView) this.ojI.findViewById(a.f.back_icon);
        this.ojJ.setOnClickListener(this);
        this.ojK = (MarqueeTextView) this.ojI.findViewById(a.f.tv_title);
        this.ojL = (MarqueeTextView) this.ojI.findViewById(a.f.tv_Type);
        this.ojN = (ImageView) this.opD.findViewById(a.f.btn_setting);
        this.ojR = this.opD.findViewById(a.f.bottomview);
        if (this.opJ == null) {
            this.opJ = (ImageButton) this.ojR.findViewById(a.f.btn_barrage);
            this.opJ.setOnClickListener(this);
            if (this.opR != null) {
                if (com.kascend.chushou.d.h.egj().n()) {
                    this.opJ.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.opJ.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.opK = (ImageButton) this.ojR.findViewById(a.f.btn_audio);
        this.opK.setOnClickListener(this);
        if (this.opR != null && this.opR.d) {
            this.opK.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.opK.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.opR != null && this.opR.f != null) {
            while (true) {
                if (i >= this.opR.f.size()) {
                    break;
                } else if (!"2".equals(this.opR.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.ojS = (ImageButton) this.ojR.findViewById(a.f.playbutton);
        this.ojS.setOnTouchListener(this);
        this.ojO = (ImageButton) this.ojR.findViewById(a.f.btn_refresh);
        this.ojO.setOnClickListener(this);
        this.ojT = (TextView) this.ojR.findViewById(a.f.tv_online_count);
        if (this.opI == null) {
            this.opI = (ImageButton) this.ojR.findViewById(a.f.btn_screenChange);
            this.opI.setOnClickListener(this);
        }
        if (this.ojM == null) {
            this.ojM = (ImageView) this.ojI.findViewById(a.f.report_icon);
            this.ojM.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dP(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.ojH != null) {
                        this.ojH.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                        this.opR.egU().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.opR.egU().mMicStatus.onMic) {
                            ehv();
                        }
                        if (this.opR.egU().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.opR.egU().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.opR.egU().mRoominfo.mCreatorUID);
                            }
                        } else if (this.opR.egU().mMicStatus.onMic) {
                            this.opR.egU().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.opR.egU().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.opR.egU().mFanItems, str);
                            }
                            this.ole = z2;
                            if (this.opR.egU().mMicStatus != null && !h.isEmpty(this.opR.egU().mMicStatus.micRoomId) && !this.opR.egU().mMicStatus.micRoomId.equals("0")) {
                                this.olf = this.opR.egU().mMicStatus.micRoomId;
                            }
                            if (this.ojH != null) {
                                this.ojH.a(this.opR.egU().mMicStatus, this.opR.egU().mFanItems, str, z2);
                            }
                            if (this.okD != null && this.okD.getVisibility() == 0) {
                                this.okD.a(this.opR.egU().mFanItems, this.opR.egU().mMicStatus, str, z2, this.opR.egU().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.ojH != null) {
                                this.ojH.e();
                            }
                            if (this.okD != null && this.okD.isShown()) {
                                this.okD.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.ojH != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.ojH.a(roomChatBackground.mChatBackground);
                        } else {
                            this.ojH.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.okQ != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.okQ = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.ojs != null && this.ojs.omj != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.ojs.omj.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.ojs.omj.mInPKMode = true;
                                    this.ojs.omj.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.ojs.omj.mPkUid = pkNotifyInfo.mPkUid;
                                    this.ojs.omj.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.ojs.omj.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.ojs.omj.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.ojs.omj.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.ojs.omj.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.ojs.omj.mMode = pkNotifyInfo.mMode;
                                    this.ojs.omj.liveStyle = pkNotifyInfo.liveStyle;
                                    if (ehC() != null) {
                                        ehC().j(true, this.ojs.omj.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.egj().f4087a) {
                                        if (!com.kascend.chushou.b.egb().e) {
                                            com.kascend.chushou.b.egb().e = true;
                                            g.K(this.opS, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.egj().a(this.opS, false);
                                        ehu();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.okU != null) {
                                        this.okU.setVisibility(0);
                                    }
                                    this.ojs.omj.mAction = 7;
                                    this.ojs.omj.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.ojs.omj.mPkUid = pkNotifyInfo.mPkUid;
                                    this.ojs.omj.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.ojs.omj.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.ojs.omj.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.ojs.omj.destinyInfo = pkNotifyInfo.destinyInfo;
                                    ehB();
                                    if (ehC() != null) {
                                        ehC().j(false, 0L);
                                        ehC().b(this.ojs.omj, true);
                                        ehC().a(this.ojs.omj.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Wq(this.okV);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.ojs.omj.mInPKMode = false;
                                    this.ojs.omj.mAction = 2;
                                    ehB();
                                    if (ehC() != null) {
                                        ehC().c();
                                    }
                                    if (com.kascend.chushou.d.h.egj().f4087a) {
                                        if (!com.kascend.chushou.b.egb().e) {
                                            com.kascend.chushou.b.egb().e = true;
                                            g.K(this.opS, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.egj().a(this.opS, false);
                                        ehu();
                                    }
                                    this.ojs.b = null;
                                    this.ojs.omj = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Wq(this.okV);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.ojs.omj.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.ojs.omj.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.ojs.omj.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.opR.egU().mRoominfo.mRoomID) && this.opR.egU().mRoominfo.mRoomID.equals(this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (ehC() != null) {
                                        ehC().a(this.ojs.omj, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.ojs.omj.copyUpdate(pkNotifyInfo);
                                    if (ehC() != null) {
                                        ehC().a(this.ojs.omj);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.ojs.omj.copyStop(pkNotifyInfo);
                                        if (ehC() != null) {
                                            ehC().I(this.ojs.omj.mMaxFreeDuration, this.ojs.omj.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.ojs.omj.copyResult(pkNotifyInfo);
                                    if (!this.okG && ehC() != null) {
                                        int i5 = 1;
                                        if (this.ojs.omj.destinyInfo != null && this.ojs.omj.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        ehC().a(h.parseInt(this.ojs.omj.mResult), h.parseLong(this.ojs.omj.mvpUid), this.ojs.omj.mvpAvatar, this.ojs.omj.mvpNickname, this.ojs.omj.mMaxFreeDuration, this.ojs.omj.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.ojH != null) {
                if (LoginManager.Instance().islogined() && this.opR != null && this.opR.l()) {
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
                if (this.opR == null || this.opR.egU() == null || this.opR.egU().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.opR.egU().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.egj().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.egj().b().equals(next2.mUserID)) {
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
                this.ojH.a(arrayList, true, false);
                this.ojH.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.ojE != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.ojE.length) {
                    break;
                }
                if (this.ojE[i2] == 99 && this.ojF != null && this.ojF[i2] != null && (this.ojF[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.ojF[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.okF.size() && this.oky != null) {
                if (i == 0) {
                    this.oky.setTagText(i2, new StringBuilder(this.okF.get(i2).name).toString());
                    return;
                } else {
                    this.oky.setTagText(i2, this.okF.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.opJ != null) {
            if (z) {
                this.opJ.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.opJ.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout eho() {
        if (this.opD == null) {
            return null;
        }
        return (GiftAnimationLayout) this.opD.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hj = tv.chushou.zues.utils.a.hj(this.opS);
        this.ar = Math.min(hj.x, hj.y);
        this.aq = (this.ar * this.opS.getResources().getInteger(a.g.h_thumb_height_def)) / this.opS.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = ehS().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.opL.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.okJ = this.aq + this.opS.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.opS, 54.0f);
        b(this.okJ, 10);
        if (this.opE != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.opE).setLayoutParams(layoutParams3);
        }
    }

    private void ehp() {
        Point hj = tv.chushou.zues.utils.a.hj(this.opS);
        this.ar = Math.min(hj.x, hj.y);
        this.aq = (this.ar * this.opS.getResources().getInteger(a.g.h_thumb_height_def)) / this.opS.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = ehS().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.opL.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.okJ = this.aq + this.opS.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.opS, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.okJ, 10);
        k();
        if (!h.isEmpty(this.ojP)) {
            File ah = tv.chushou.zues.widget.fresco.a.ah(Uri.parse(this.ojP));
            if (ah != null && ah.exists()) {
                this.opL.setImageURI(Uri.fromFile(ah));
                this.opL.setVisibility(0);
                return;
            }
            this.opL.setVisibility(8);
            return;
        }
        this.opL.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aD(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.ojM != null) {
            this.ojM.setVisibility(z ? 0 : 4);
        }
        if (this.ojN != null) {
            this.ojN.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aD(boolean z, boolean z2) {
        return m(z, z2, this.f);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.opT != null) {
            this.opT.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.opS).f(true);
            if (!z3) {
                if (this.ojR.getVisibility() != 0 && z2) {
                    this.ojR.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.opK.setVisibility(0);
                } else {
                    this.opK.setVisibility(8);
                }
                this.ojR.setVisibility(0);
            }
            PlayUrl egV = this.opR.egV();
            if (egV != null && "2".equals(egV.mType)) {
                if (this.opI != null) {
                    this.opI.setVisibility(8);
                }
            } else if (this.opI != null) {
                this.opI.setVisibility(0);
            }
            if (this.ojI.getVisibility() != 0 && z2) {
                this.ojI.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_top_anim));
            }
            t(!z3);
            this.ojI.setVisibility(0);
            w(true);
            if (this.opT != null) {
                this.opT.D(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.opS).f(false);
            if (this.oqk != null) {
                this.oqk.dismiss();
            }
            if (this.oql != null) {
                this.oql.dismiss();
            }
            if (this.ojR.getVisibility() != 8 && z2) {
                this.ojR.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_bottom_anim));
            }
            this.ojR.setVisibility(8);
            if (this.ojI.getVisibility() != 8 && z2) {
                this.ojI.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_top_anim));
            }
            this.ojI.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dUA() {
        if (this.oqB == null || !this.oqB.isShown()) {
            return false;
        }
        this.oqB.d();
        return true;
    }

    public boolean ehq() {
        if (this.okD == null || !this.okD.isShown()) {
            return false;
        }
        this.okD.a();
        return true;
    }

    public boolean ehf() {
        if (this.okH == null || !this.okH.b()) {
            return false;
        }
        this.okH.a();
        return true;
    }

    public boolean ehr() {
        if (this.okB && this.oqx != null) {
            if (this.oqx != null) {
                this.oqx.e();
            }
            if (this.okY != null) {
                this.okY.setText("");
            }
            if (this.bB == 2) {
                aE(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.opD != null) {
            if (this.okH == null) {
                this.okH = (PopH5Menu) ((ViewStub) this.opD.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.okH.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.f4233a = listItem.mUrl;
            h5Options.h = -1;
            this.okH.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.ojI.getHeight() + this.ojI.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.opS, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                g.c(this.opS, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.opR.a(false);
                a(false, false);
                ((VideoPlayer) this.opS).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.opS).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.opS, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.ojs == null || this.ojs.omj == null || !this.ojs.omj.mInPKMode) {
                ((VideoPlayer) this.opS).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.opS, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.oks) {
                f(this.okf.getText().toString());
            } else {
                a(this.okf.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.egj().c) {
                com.kascend.chushou.d.h.egj().b(false);
                this.okb.cancel();
                this.okb.reset();
                this.oka.clearAnimation();
                this.okc.setVisibility(8);
            }
            n(view, 0, this.opD.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.opS, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.opD.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.opR.d) {
                dUo();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.opS, null) && this.opR != null && this.opR.oja != null) {
                if (this.oks) {
                    ehF();
                    return;
                }
                if (this.opR != null && this.opR.oja != null && this.opR.oja.count > 0) {
                    this.okh.setVisibility(8);
                } else {
                    this.okh.setVisibility(0);
                }
                this.oks = true;
                this.okp.setBackgroundResource(a.e.ic_trumpet_p);
                this.okq.setVisibility(0);
                this.okq.setSelected(true);
                this.okq.setTextColor(Color.parseColor("#ff5959"));
                if (this.okf != null) {
                    this.okf.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.okr <= 9) {
                this.okr++;
                this.oko.setText(this.okr + "");
            }
            ehD();
        } else if (id == a.f.tv_cut_count) {
            if (this.okr > 1) {
                this.okr--;
                this.oko.setText(this.okr + "");
            }
            ehD();
        } else if (id == a.f.tv_buy_head) {
            ehE();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.okY.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.okY.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dZ(this.okY);
                this.oqx.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.okf != null && this.ojY != null && this.oke != null) {
                tv.chushou.zues.widget.kpswitch.b.d.by(this.okf);
                this.ojY.setVisibility(8);
                if (this.bB == 2) {
                    this.oke.setVisibility(0);
                }
            }
        } else if (this.ojY != null && this.oke != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
            if (this.bB == 2) {
                this.ojY.setVisibility(0);
            }
            this.oke.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.egj().c(roomToast.mToastContent);
            if (this.okK == null) {
                aS();
            }
            if (this.okL != null) {
                this.okL.setText(roomToast.mToastContent);
            }
            if (!this.okK.isShowing()) {
                if (this.okA != null) {
                    this.okK.showAtLocation(this.okA, 85, 0, this.opD.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
                    RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.okK != null) {
                                a.this.okK.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.okK.dismiss();
        }
    }

    private void aS() {
        if (this.okK == null) {
            View inflate = LayoutInflater.from(this.opS).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.okL = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.okK = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 160.0f), -2);
            this.okK.setFocusable(false);
            this.okK.setOutsideTouchable(false);
            this.okK.setAnimationStyle(a.j.gift_toast_style);
            this.okK.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.oqs != null && this.oqs.isShowing()) {
            this.oqs.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
        if (this.oqP == null) {
            ehV();
        }
        if (!this.oqP.isShowing()) {
            this.oqP.showAtLocation(view, 83, i, i2);
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.opR.egU().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.oqP.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.oqS != null) {
            if (h.isEmpty(this.oqT)) {
                if (((VideoPlayer) this.opS).q) {
                    this.oqS.bY(this.opR != null ? this.opR.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.oqS.bY(this.opR != null ? this.opR.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.opS).q && this.oqT.size() == 2 && this.oqT.contains("4") && this.oqT.contains("2")) {
                this.oqS.bY(this.opR != null ? this.opR.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.oqT.size() > 1 || !((VideoPlayer) this.opS).q) {
                this.oqS.bY(this.opR != null ? this.opR.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.oqT.get(0))) {
                this.oqS.bY(this.opR != null ? this.opR.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.oqT.get(0))) {
                this.oqS.bY(this.opR != null ? this.opR.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.oqT.get(0))) {
                this.oqS.bY(this.opR != null ? this.opR.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
        if (this.oqs == null) {
            al();
            this.oqs.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.oqs.isShowing() && this.bB == 2) {
            this.oqs.showAtLocation(view, 83, i, this.opS.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.opR.egU().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.oqs.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.opL != null) {
            this.opL.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                g.c(this.opS, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.omi.getPlayState() == 4) {
                        e(true);
                        if (this.opR.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.opR.a(false);
                        ((VideoPlayer) this.opS).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.omi.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.omi.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                g.c(this.opS, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.opR.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.opS).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                    this.ai = false;
                    zn(true);
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
        if (this.oqF != null) {
            if (z) {
                this.oqF.setVisibility(0);
            }
            this.oqF.etn();
            if (!z) {
                this.oqF.setVisibility(8);
            }
        }
        g.c(this.opS, this.opS.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.ojS != null) {
                this.ojS.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4123a != null) {
                this.f4123a.setVisibility(8);
            }
            if (this.opM != null) {
                this.opM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ojS != null) {
            this.ojS.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4123a != null) {
            if (z2 != (this.f4123a.getVisibility() == 0)) {
                if (z2) {
                    this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4123a.setVisibility(0);
                    return;
                }
                this.f4123a.setVisibility(8);
                if (this.opM != null) {
                    this.opM.setVisibility(8);
                }
            }
        }
    }

    private void ehs() {
        this.e = false;
        m(true, false, true);
    }

    private void eht() {
        this.e = false;
        m(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.ojE[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            ehj();
            a(this.opR != null ? this.opR.ojb.get("1") : null);
            if (i2 == 2) {
                k();
                aE(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.opS, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aE(false, i3);
            v(false);
            b(false);
            if (this.oqs != null && this.oqs.isShowing()) {
                this.oqs.dismiss();
            }
            if (i2 == 99) {
                if (this.ojF != null && this.ojF[i] != null && (this.ojF[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.ojF[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.opS, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.opS, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.opS, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.opS, "房间信息页_num", null, new Object[0]);
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
    protected void ehu() {
        ((VideoPlayer) this.opS).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.opT != null) {
            if (this.oke != null && this.oke.getVisibility() == 0) {
                u(false);
            }
            if (this.opM != null && this.opM.getVisibility() == 0) {
                this.f = true;
            }
            aD(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.ojH != null) {
            this.ojH.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.ojH != null) {
            this.ojH.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.ojH != null) {
            this.ojH.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.ojH != null) {
            this.ojH.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.okA != null) {
            int size = iconConfig.configs.size();
            this.okA.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.opS).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.okA, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bY(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bY(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.bY(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.bY(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.bY(str, a.e.ic_default_video_bottom);
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
                    public void dP(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.okA.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.opR != null ? this.opR.ojb : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.ojH != null) {
            this.ojH.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.okx != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.okx.Dr(a.c.kas_white);
            } else if (this.bB == 2) {
                this.okx.bY(str, a.c.kas_white);
                if (this.oky != null) {
                    this.oky.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.okx.Dr(a.c.kas_white);
                if (this.oky != null) {
                    this.oky.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a2 = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a3 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.oky != null) {
                    this.oky.setTextColor(a2);
                    this.oky.setTabTextSelectColor(a3);
                    this.oky.setIndicatorColor(a3);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.oka != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.oka.Dr(a.e.ic_hotwords_black_n);
            } else {
                this.oka.bY(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.ojZ != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.eii().a(str, this.ojZ, a.e.player_skin_input);
            } else {
                this.ojZ.setBackgroundResource(a.e.player_skin_input);
            }
            int a2 = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.okd != null) {
                this.okd.setTextColor(a2);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void a(int i) {
        if (this.ojH != null) {
            this.ojH.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void D() {
        if (this.opS instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a egB = ((VideoPlayer) this.opS).egB();
            if (this.oqJ == null) {
                this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.oqJ.setVisibility(0);
            this.oqJ.a(2, egB);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.ojH != null) {
            this.ojH.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.ojH != null) {
            this.ojH.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(long j) {
        if (this.ojH != null) {
            this.ojH.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0910a
    public void c(int i) {
        if (this.ojH != null) {
            this.ojH.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.ojH != null && this.opR != null) {
            this.ojH.b(this.opR.oiZ);
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
    public class C0903a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0903a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.ojE.length) {
                return null;
            }
            switch (a.this.ojE[i]) {
                case 1:
                    if (a.this.ojG == null) {
                        a.this.ojG = com.kascend.chushou.view.user.a.a(2, null, a.this.opR.f4119a, false, a.this.opR.h, false);
                    }
                    a.this.ojF[i] = a.this.ojG;
                    return a.this.ojG;
                case 2:
                    if (a.this.ojH == null) {
                        a aVar = a.this;
                        if (a.this.ojs != null && a.this.ojs.omj != null) {
                            z = a.this.ojs.omj.mInPKMode;
                        }
                        aVar.ojH = com.kascend.chushou.player.ui.a.zo(z);
                    }
                    a.this.ojF[i] = a.this.ojH;
                    return a.this.ojH;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.opR != null && a.this.opR.egU() != null && !h.isEmpty(a.this.okF)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.okF.get(i).url);
                        h5Options.f4233a = a.this.okF.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a2 = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.ojF[i] = a2;
                    return a2;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Oo(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.ojE.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int pj(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Op(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String Oq(int i) {
            return a.this.Oo(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Or(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Os(int i) {
            int dimensionPixelSize = a.this.opS.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Hj(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.PQ(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.ojy <= IMConnection.RETRY_DELAY_TIMES) {
            g.PQ(a.i.str_too_fast);
            return false;
        } else {
            ehx();
            if (!com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a(((VideoPlayer) this.opS).egv().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.ojy = System.currentTimeMillis();
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                a(this.opR.egU().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.opR.h);
            }
            g(this.b);
            if (!z && this.okf != null) {
                this.okf.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            ehx();
            if (com.kascend.chushou.d.e.c(this.opS, null) && LoginManager.Instance().getUserInfo() != null && this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                a(this.opR.egU().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.okf != null) {
                this.okf.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.ojH != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.opR.egU().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.opR.egU().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.opS).ohp;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Yj(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.ojH.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.ojH.a(arrayList, true, true);
        }
    }

    private void ehv() {
        if (this.ojH != null) {
            this.ojH.e();
        }
        if (this.okD != null && this.okD.isShown()) {
            this.okD.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.opS instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.opS;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.opR != null) {
            this.opR.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        ehv();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.opS != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.opS).t)) {
                this.cx = true;
                if (this.opR != null) {
                    this.opR.f = null;
                    if (this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                        this.opR.egU().mRoominfo.mGameId = null;
                    }
                }
                ehm();
                return;
            }
            this.cx = true;
            if (this.opS != null) {
                ((VideoPlayer) this.opS).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.ojQ != null) {
            this.ojQ.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.ojQ != null) {
            this.ojQ.setVisibility(8);
        }
        super.i(z);
    }

    private void ehw() {
        ehk();
        if (i()) {
            aY();
            ap();
            return;
        }
        ehm();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        ehS().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.opE != null) {
            this.opE.setVisibility(0);
        }
        if (this.oqF != null) {
            this.oqF.setVisibility(0);
        }
        if (this.ojo != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.ojo.d();
        }
        if (this.ojY != null) {
            this.ojY.setVisibility(0);
        }
        if (com.kascend.chushou.c.f4079a) {
            this.ojN.setVisibility(0);
            this.ojN.setOnClickListener(this);
        } else {
            this.ojN.setVisibility(8);
        }
        this.ojS.setVisibility(0);
        this.ojO.setVisibility(0);
        this.opJ.setVisibility(0);
        if (this.p) {
            this.opK.setVisibility(0);
        } else {
            this.opK.setVisibility(8);
        }
        aX();
        aE(true, i());
        this.e = false;
        m(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.oqJ != null && this.oqJ.a(i, keyEvent)) {
                return true;
            }
            if (this.okH != null && this.okH.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.okI != null && this.okI.onKeyDown(i, keyEvent)) || ehy()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.okZ != null && this.okZ.getVisibility() == 0 && a(motionEvent, this.okZ)) {
                this.okZ.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dZ(this.okY);
                return true;
            } else if (this.okB && this.okZ != null && this.okZ.getVisibility() == 8 && f(this.oqx.b, motionEvent)) {
                ehr();
                return true;
            } else if (this.okH != null && this.okH.b() && f(this.okH, motionEvent)) {
                this.okH.a();
                return true;
            } else if (this.okI != null && this.okI.b() && f(this.okI, motionEvent)) {
                this.okI.a();
                return true;
            } else if (a(motionEvent, this.oke)) {
                return ehx();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean ehx() {
        boolean z;
        b(this.okJ, 10);
        boolean z2 = false;
        if (this.okt != null && this.okt.getVisibility() == 0) {
            this.okt.setVisibility(8);
            this.oku.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
            this.oku.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.oke == null || this.oke.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.oks) {
                ehF();
            }
            this.oke.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ojY != null && a.this.bB == 2) {
                        a.this.ojY.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean ehy() {
        if (ehx()) {
            return true;
        }
        if (this.oqs == null || !this.oqs.isShowing()) {
            return ehr() || ehq() || dUA();
        }
        this.oqs.dismiss();
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
        this.ojY.setVisibility(8);
        this.oke.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(boolean z, boolean z2) {
        if (this.ojY != null) {
            if (z) {
                if (this.ojY.getVisibility() != 0) {
                    this.ojY.setVisibility(0);
                    this.ojY.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_bottom_anim));
                }
            } else if (this.ojY.getVisibility() != 4) {
                this.ojY.setVisibility(4);
                this.ojY.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.ojQ != null) {
            this.ojQ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a ehz() {
        return this.okN;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.opR != null) {
                        this.opR.f = null;
                        this.opR.egU().mRoominfo.mGameId = null;
                    }
                    ehm();
                    return;
                }
                g.PQ(a.i.str_getvideosource_failed);
            }
            zn(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.opR != null && this.opR.egV() != null) {
            a(this.opR.egV());
        }
        this.p = false;
        if (this.opR == null || this.opR.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.opR.f.size()) {
                if (!"2".equals(this.opR.f.get(i2).mType)) {
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
        if (this.ojH != null) {
            this.ojH.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.ojT != null && this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                this.ojT.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.opR.egU().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.okG && (c = c(1, -1)) >= 0 && c < this.okF.size() && this.okz != null) {
            this.okz.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.okG) {
            if (bVar.f4152a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.opS, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                com.kascend.chushou.player.ui.h5.b.b egC = ((VideoPlayer) this.opS).egC();
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(2, egC);
            } else if (bVar.f4152a == 3) {
                com.kascend.chushou.player.ui.h5.d.a egD = ((VideoPlayer) this.opS).egD();
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(2, egD);
            } else if (bVar.f4152a == 9) {
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.okt != null) {
            this.okt.setPanelEnabled(gVar.f4071a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.okG) {
            if (iVar.f4073a == 53) {
                if (iVar.b instanceof String) {
                    a((String) iVar.b, true);
                }
            } else if (iVar.f4073a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (!aa() && this.opR != null) {
            String str = this.opR.f4119a;
            RoomInfo egW = this.opR.egW();
            if (egW != null && mVar.a(egW.mCreatorUID, str)) {
                egW.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.okf != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.okf);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
            if (this.okC == null) {
                this.okC = new f(getActivity());
            }
            this.okC.a(this.opR.egU().mRoominfo);
            if (!this.okC.isShowing()) {
                this.okC.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.ojH != null) {
            this.ojH.d();
        }
    }

    private void e(View view) {
        this.ojU = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.ojV = (TextView) view.findViewById(a.f.tv_4g_video);
        this.ojV.setText(new tv.chushou.zues.widget.a.c().N(this.opS, a.e.videoplayer_4g_video).append("  ").append(this.opS.getString(a.i.videoplayer_4g_video)));
        this.ojW = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.ojW.setText(new tv.chushou.zues.widget.a.c().N(this.opS, a.e.videoplayer_4g_audio).append("  ").append(this.opS.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.ojU.setVisibility(8);
                    ((VideoPlayer) a.this.opS).c(a.this.ojX);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.ojU.setVisibility(8);
                    ((VideoPlayer) a.this.opS).d(a.this.ojX);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.egb().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.ojV.setOnClickListener(onClickListener);
        this.ojW.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.opR != null && !h.isEmpty(this.opR.f)) {
            g(this.opR.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.ojX = z;
            this.p = false;
            if (this.opR != null && this.opR.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.opR.f.size()) {
                        break;
                    } else if (!"2".equals(this.opR.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.ojU != null) {
                this.ojU.setVisibility(0);
                this.ojV.setVisibility(0);
                this.ojW.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.ojU != null) {
            this.ojU.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.okR == null) {
                this.okR = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.opT != null) {
                    this.opT.e(this.okR, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.okR != null && this.opT != null) {
            this.opT.L(this.okR);
            this.okR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.ojH != null) {
            com.kascend.chushou.toolkit.a.c.a(this.opS, "显示双击666_num", null, new Object[0]);
            if (this.opR != null) {
                this.opR.b(false);
            }
            d(false);
            this.ojH.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.opD != null) {
            if (this.okI == null) {
                this.okI = (InteractionView) ((ViewStub) this.opD.findViewById(a.f.view_interaction)).inflate();
                this.okI.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.okI.a();
                    }
                });
            }
            if (this.okI != null) {
                this.okI.b(configDetail);
                this.okI.c();
                this.okI.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.etZ()) {
                g.K(this.opS, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.opS, null) && (this.opS instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.opR != null) {
                com.kascend.chushou.toolkit.a.c.a(this.opS, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.opR != null) {
                com.kascend.chushou.toolkit.a.c.a(this.opS, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.opS, configDetail.mUrl, this.opS.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.opS, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    ehA();
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

    private void ehA() {
        if (this.okB) {
            ehr();
            return;
        }
        if (this.opS.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.opS, "点击送礼_num", "竖屏", new Object[0]);
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.opR.egU().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.opS != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.ojs == null) {
                this.ojs = new com.kascend.chushou.player.e.a();
            }
            this.ojs.b = str;
            this.ojs.omj.copy(pkNotifyInfo);
            if (this.ojs.omj.mAction == 6) {
                this.ojs.omj.mInPKMode = true;
                this.u = this.ojs.omj.mPkId;
            } else if (this.ojs.omj.mAction == 7 || (this.ojs.omj.mMode == 1 && this.ojs.omj.mAction == 5)) {
                this.ojs.omj.mInPKMode = true;
                this.u = this.ojs.omj.mPkId;
                if (ehC() != null) {
                    if (2 == this.bB && this.okU != null) {
                        this.okU.setVisibility(0);
                    }
                    ehC().b(this.ojs.omj, false);
                    ehC().a(this.ojs.omj.mMode, "1");
                    if (this.ojs.omj.mAction == 5 && this.ojs.omj.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.ojs.omj.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.ojs.omj.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.ojs.omj.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.ojs.omj.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.ojs.omj.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        ehC().a(this.ojs.omj);
                        if (this.ojs.omj.destinyInfo == null || this.ojs.omj.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        ehC().a(parseInt, this.ojs.omj.mPkUpdateInfo.remainDuration, j, this.ojs.omj.mMode, i);
                    }
                    if (!h.isEmpty(this.ojs.omj.mPkUpdateInfo.specialMomentList) && ehC() != null) {
                        ehC().a(this.ojs.omj, true);
                    }
                }
                ehB();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Wq(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.ojs.omj.mInPKMode = false;
                ehB();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Wq(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void ehB() {
        if (this.ojs != null && this.ojs.omj != null) {
            if (this.ojs.omj.mInPKMode) {
                this.y.setText(this.ojs.omj.mPkUserNickname);
                this.oju.setVisibility(0);
                if (this.opI != null) {
                    this.opI.setEnabled(false);
                }
                if (this.opK != null) {
                    this.opK.setEnabled(false);
                    return;
                }
                return;
            }
            this.oju.setVisibility(8);
            if (this.opI != null) {
                this.opI.setEnabled(true);
            }
            if (this.opK != null) {
                this.opK.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b ehC() {
        if (this.opS == null || this.opD == null || this.okU == null) {
            return null;
        }
        if (this.ojt == null) {
            if (this.okT == null) {
                this.okT = ((ViewStub) this.opD.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.ojt = new com.kascend.chushou.player.e.b();
            this.ojt.a(this.okU, this.okT, (View) null, this.opS, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cCv()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.opR != null) {
                        append.append(a.this.opR.egW().mRoomID);
                    }
                    if (a.this.ojs != null && a.this.ojs.omj != null) {
                        append.append("&mode=").append(a.this.ojs.omj.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.opS, append.toString());
                }
            });
        }
        return this.ojt;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.okq != null && this.opR != null && this.opR.oja != null) {
            this.okq.setText(tv.chushou.zues.utils.b.PP(this.opR.oja.count));
            this.okq.setVisibility(0);
            if (this.opR.oja.count < 1) {
                ehF();
            }
            if (this.oki != null) {
                this.oki.setText(this.opR.oja.primaryName);
            }
            if (this.okj != null) {
                this.okj.setText(this.opR.oja.desc);
            }
            ehD();
        }
    }

    public void ehD() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.okr * h.parseLong(this.opR.oja.point)));
        if (this.okl != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.opS.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.N(this.opS, a.e.icon_coin_new);
            cVar.append(this.opS.getString(a.i.str_buy_count_coin2));
            this.okl.setText(cVar);
        }
    }

    private void ehE() {
        if (com.kascend.chushou.d.e.c(this.opS, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.okr);
        }
    }

    private void v(boolean z) {
        if (this.opD != null && this.okU != null) {
            if (z) {
                if (this.ojs != null && this.ojs.omj != null && this.ojs.omj.mInPKMode) {
                    this.okU.setVisibility(0);
                    return;
                }
                return;
            }
            this.okU.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.opD != null && this.ojx != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.ojx.setVisibility(0);
                    return;
                }
                return;
            }
            this.ojx.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.ojs != null && this.ojs.omj != null && this.ojs.omj.mInPKMode && this.oju != null) {
                this.oju.setVisibility(0);
            }
        } else if (this.oju != null) {
            this.oju.setVisibility(8);
        }
    }

    private void ehF() {
        this.oks = false;
        this.okp.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.opR != null && this.opR.oja != null) {
            if (this.opR.oja.count < 1) {
                this.okq.setVisibility(8);
            } else {
                this.okq.setVisibility(0);
                this.okq.setSelected(false);
                this.okq.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.okh.setVisibility(8);
        if (this.okf != null) {
            this.okf.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        ehA();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.okd != null) {
            this.okd.performClick();
        }
    }

    public boolean ehG() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.olg = true;
        if (this.opD != null && com.kascend.chushou.b.egb().d == 0) {
            this.okP = tv.chushou.zues.utils.systemBar.b.hn(getActivity());
            if (!z) {
                View findViewById = this.opD.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.okP = tv.chushou.zues.utils.systemBar.b.hn(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.okP);
            View findViewById2 = this.opD.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.okP);
            findViewById2.requestLayout();
        }
    }
}
