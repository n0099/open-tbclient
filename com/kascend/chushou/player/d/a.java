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
    private ImageView pkA;
    private ImageView pkB;
    private ImageButton pkC;
    public String pkD;
    private RecommendView pkE;
    private TextView pkH;
    private RelativeLayout pkI;
    private TextView pkJ;
    private TextView pkK;
    private boolean pkL;
    private RelativeLayout pkM;
    private View pkN;
    private FrescoThumbnailView pkO;
    private AnimationSet pkP;
    private ImageView pkQ;
    private TextView pkR;
    private RelativeLayout pkS;
    private PastedEditText pkT;
    private TextView pkU;
    private LinearLayout pkV;
    private TextView pkW;
    private TextView pkX;
    private TextView pkY;
    private TextView pkZ;
    private int[] pks;
    private Fragment[] pkt;
    private ImageView pkx;
    private MarqueeTextView pky;
    private MarqueeTextView pkz;
    private GiftAnimationLayout plA;
    private com.kascend.chushou.player.b.a plB;
    private Runnable plF;
    private View plH;
    private LivePKBarUserValue plI;
    private String plJ;
    private TextView plK;
    private ImageView plL;
    private EditText plM;
    private View plN;
    private View plO;
    private View plP;
    private String plT;
    private TextView pla;
    private TextView plb;
    private TextView plc;
    private ImageView pld;
    private TextView ple;
    private KPSwitchPanelLinearLayout plh;
    private ImageView pli;
    private c plj;
    private d.a plk;
    private FrescoThumbnailView pll;
    private PagerSlidingTabStrip plm;
    private KasViewPager pln;
    private LinearLayout plo;
    private f plq;
    private ViewMicPerson plr;
    public ArrayList<RoomTab> plt;
    private PopH5Menu plv;
    private InteractionView plw;
    private int plx;
    private PopupWindow ply;
    private TextView plz;
    private long pkm = 0;
    private com.kascend.chushou.view.user.a pku = null;
    private com.kascend.chushou.player.ui.a pkv = null;
    private int bB = -1;
    private int bC = 0;
    private View pkw = null;
    private View pkF = null;
    private ImageButton pkG = null;
    private int plf = 1;
    private boolean plg = false;
    private boolean cp = false;
    private boolean plp = false;
    private boolean cx = false;
    private boolean pls = false;
    private boolean plu = false;
    private boolean cC = true;
    private int plC = 0;
    private int plD = 0;
    private int plE = -1;
    private final Rect plG = new Rect();
    private boolean plQ = false;
    private C0994a plR = null;
    private boolean plS = false;
    private boolean plU = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pkD = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.pqt = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.pqt;
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
        this.plu = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.prn != null) {
            this.prn.b();
        }
        if (this.pqI != null && (this.pqI instanceof VideoPlayer)) {
            ((VideoPlayer) this.pqI).AD(true);
            ((VideoPlayer) this.pqI).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.plu = true;
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
        this.plf = 1;
        this.plg = false;
        U();
        if (this.pqJ != null) {
            this.pqJ.cs(null);
            this.pqJ = null;
        }
        if (this.pkE != null) {
            evH().removeAllViews();
            this.pkE = null;
        }
        this.c = null;
        this.pjZ = null;
        tv.chushou.zues.a.a.ct(this);
        this.plm = null;
        this.pln = null;
        this.pkv = null;
        this.pku = null;
        if (this.pkt != null) {
            for (int i = 0; i < this.pkt.length; i++) {
                this.pkt[i] = null;
            }
        }
        this.pkt = null;
        if (this.pkT != null) {
            this.pkT.addTextChangedListener(null);
            this.pkT.setOnTouchListener(null);
            this.pkT.setOnEditorActionListener(null);
            this.pkT = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.pqI, this.plj);
        if (this.pqI != null && (this.pqI instanceof VideoPlayer)) {
            ((VideoPlayer) this.pqI).euo();
        }
        this.plk = null;
        this.plj = null;
        if (this.plr != null) {
            this.plr.b();
            this.plr = null;
        }
        if (this.ply != null) {
            this.ply.dismiss();
        }
        if (this.plB != null) {
            this.plB.a();
            this.plB = null;
            this.plA = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.plI = (LivePKBarUserValue) this.pqt.findViewById(a.f.live_pk_bar_user);
        this.pqB = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.plQ) {
            this.plQ = true;
            if (this.plO == null) {
                this.plO = this.pqt.findViewById(a.f.vs_async_view);
                this.plO = ((ViewStub) this.plO).inflate();
            }
            if (this.plP == null) {
                this.plP = this.pqt.findViewById(a.f.vs_async_notification_view);
                this.plP = ((ViewStub) this.plP).inflate();
            }
            this.pkl = (VoiceInteractionView) this.pqt.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.pqt);
            edV();
            ((VideoPlayer) this.pqI).q();
            this.pkf = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.pll = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.plm = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.pln = (KasViewPager) view.findViewById(a.f.vp_main);
        euV();
        aI();
        euZ();
        if (this.pqH != null) {
            I();
            a(this.pqH.pjL, this.pqH.pjO);
        }
        this.bb = 0;
        this.prs = 0L;
        this.pro = (RoundProgressBar) this.pqt.findViewById(a.f.roundProgressBar);
        this.prp = (TextView) this.pqt.findViewById(a.f.tv_paonum);
        this.prq = (FrescoThumbnailView) this.pqt.findViewById(a.f.iv_paoicon);
        this.prx = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.plp = false;
                if (a.this.bB == 2) {
                    a.this.aK(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.plx, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.plp = true;
                if (a.this.bB == 2) {
                    a.this.aK(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.prn != null) {
                    a.this.prn.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hD(a.this.pqI).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.pqI)) - a.this.prn.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.pqI, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.pqI, 54.0f) * 2);
                    if (statusBarHeight < a.this.plx) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.prr = (PaoGuideView) this.pqt.findViewById(a.f.rlPaoGuideView);
        this.plr = (ViewMicPerson) this.pqt.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.pmW = ((VideoPlayer) this.pqI).euh();
        this.pqH = ((VideoPlayer) this.pqI).euk();
        e(this.pqt);
        this.plC = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
        this.plD = tv.chushou.zues.utils.systemBar.b.aI(getActivity());
        if (com.kascend.chushou.b.etQ().d == 0 && this.plD > 0) {
            View findViewById = this.pqt.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.plD);
        }
        eve();
        evc();
        if (!this.cC) {
            Q();
        }
        eva();
        a();
        if (this.c == null) {
            this.pjZ = new d.a();
            this.c = new GestureDetector(this.pqI, this.pjZ);
        }
        this.pkb = ((VideoPlayer) this.pqI).eul();
        this.pkb.a(this);
        if (this.plB != null) {
            this.plB.a();
            this.plB = null;
        }
        this.plA = (GiftAnimationLayout) this.pqt.findViewById(a.f.ll_gift_animation);
        this.plA.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.pqH != null) {
            this.plB = new com.kascend.chushou.player.b.a(this.pqI.getApplicationContext(), this.plA);
            this.plB.a(this.pqH);
        }
        if (this.f4123a == null) {
            this.f4123a = (ImageButton) this.pqt.findViewById(a.f.resumebutton);
            this.f4123a.setOnTouchListener(this);
        }
        this.pqC = (PlayerErrorView) this.pqt.findViewById(a.f.view_net_error_msg);
        this.pqC.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        evh();
        if (this.pqH.euK() != null) {
            a(this.pqH.euK());
        }
        FullRoomInfo euJ = this.pqH.euJ();
        if (euJ != null) {
            evl();
            if (i()) {
                this.ak = false;
                AG(true);
                this.pqJ.RT(8);
            }
            this.pkH.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(euJ.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.pqu != null) {
            this.pqu.setVisibility(0);
        }
        this.pkw.setVisibility(0);
        this.ak = false;
        AG(true);
        this.pqJ.RT(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.pqI).n();
        if (this.pqH != null && !h.isEmpty(this.pqH.w)) {
            b(this.pqH.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a euv;
        euV();
        k();
        FullRoomInfo euJ = this.pqH.euJ();
        if (euJ != null) {
            if (euJ.mRoominfo != null) {
                this.pkH.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(euJ.mRoominfo.mOnlineCount)));
                this.plJ = euJ.mRoominfo.mRoomID;
            }
            evl();
            if (!h.isEmpty(euJ.mRoomToastList)) {
                Iterator<RoomToast> it = euJ.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.etY().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.pqH != null && this.pqH.l()) {
                d(true);
            }
            if (this.pqI != null && (this.pqI instanceof VideoPlayer) && (euv = ((VideoPlayer) this.pqI).euv()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(euv.pmX, euv.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.plo);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void euV() {
        boolean z = true;
        if (this.pqH == null || this.pqH.euJ() == null || this.pqH.euJ().mRoominfo == null || h.isEmpty(this.pqH.euJ().mRoomTabs)) {
            this.pls = false;
            this.pkt = new Fragment[2];
            this.pks = new int[2];
            this.pks[0] = 2;
            this.pks[1] = 1;
            return;
        }
        this.pls = true;
        this.plt = new ArrayList<>();
        Iterator<RoomTab> it = this.pqH.euJ().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.plt.add(next);
            }
        }
        if (this.plt.size() >= 2 && this.pks != null && this.pks.length >= 2 && this.plt.get(0).type == this.pks[0] && this.plt.get(1).type == this.pks[1]) {
            z = false;
        }
        this.pkt = new Fragment[this.plt.size()];
        this.pks = new int[this.plt.size()];
        for (int i = 0; i < this.plt.size(); i++) {
            this.pks[i] = this.plt.get(i).type;
        }
        if (z) {
            this.plR = new C0994a(getChildFragmentManager());
            this.pln.setAdapter(this.plR);
        }
    }

    private void aI() {
        this.pkS = (RelativeLayout) this.pqt.findViewById(a.f.rl_edit_bar);
        this.pkO = (FrescoThumbnailView) this.pqt.findViewById(a.f.btn_hotword);
        this.pkO.DX(a.e.ic_hotwords_black_n);
        this.pkO.setOnClickListener(this);
        this.pkQ = (ImageView) this.pqt.findViewById(a.f.iv_task_badge);
        this.pkP = (AnimationSet) AnimationUtils.loadAnimation(this.pqI, a.C0988a.anim_hotword);
        this.pkP.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.etY().c) {
                    a.this.pkO.clearAnimation();
                    a.this.pkO.startAnimation(a.this.pkP);
                }
            }
        });
        if (com.kascend.chushou.d.h.etY().c) {
            this.pkO.startAnimation(this.pkP);
            this.pkQ.setVisibility(0);
        }
        this.pkR = (TextView) this.pqt.findViewById(a.f.tv_bottom_input);
        this.pkR.setOnClickListener(this);
        this.prI = (FrescoThumbnailView) this.pqt.findViewById(a.f.ll_btn_set);
        this.prI.setOnClickListener(this);
        this.plo = (LinearLayout) this.pqt.findViewById(a.f.ll_bottom_all_button);
        this.pkM = (RelativeLayout) this.pqt.findViewById(a.f.rl_bottom_input);
        this.pkN = this.pqt.findViewById(a.f.ll_bottom_input);
        this.pkM.setVisibility(8);
        this.pkT = (PastedEditText) this.pqt.findViewById(a.f.et_bottom_input);
        this.pkT.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.pkU.setEnabled(editable.length() > 0);
            }
        });
        this.pkT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.pkU);
                    return true;
                }
                return true;
            }
        });
        this.pkT.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.pkT);
                }
                return false;
            }
        });
        this.pli = (ImageView) this.pqt.findViewById(a.f.iv_btn_emoji);
        this.pli.setVisibility(8);
        this.pkU = (TextView) this.pqt.findViewById(a.f.tv_btn_send);
        this.pkU.setOnClickListener(this);
        this.plh = (KPSwitchPanelLinearLayout) this.pqt.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.etQ().d == 0) {
            this.plh.setUseStatusBar(true);
        }
        this.pkV = (LinearLayout) this.pqt.findViewById(a.f.head_trumpet);
        this.pkV.setVisibility(8);
        this.pkV.setOnClickListener(this);
        this.pkW = (TextView) this.pqt.findViewById(a.f.tv_primary_name);
        this.pkX = (TextView) this.pqt.findViewById(a.f.tv_primary_desc);
        this.pla = (TextView) this.pqt.findViewById(a.f.tv_cut_count);
        this.pla.setOnClickListener(this);
        this.plc = (TextView) this.pqt.findViewById(a.f.tv_head_count);
        this.plc.setText(this.plf + "");
        this.plb = (TextView) this.pqt.findViewById(a.f.tv_plus_count);
        this.plb.setOnClickListener(this);
        this.pkZ = (TextView) this.pqt.findViewById(a.f.tv_buy_count_coin);
        this.pkY = (TextView) this.pqt.findViewById(a.f.tv_buy_head);
        this.pkY.setOnClickListener(this);
        this.pld = (ImageView) this.pqt.findViewById(a.f.iv_trumpet_select);
        this.pld.setOnClickListener(this);
        this.ple = (TextView) this.pqt.findViewById(a.f.tv_trumpet_have_count);
        this.plg = false;
        this.pld.setBackgroundResource(a.e.ic_trumpet_n);
        this.ple.setVisibility(8);
        euX();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.plh, this.pli, this.pkT, new a.InterfaceC1125a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1125a
            public void AE(boolean z) {
                if (a.this.pli != null) {
                    if (!z) {
                        a.this.pli.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.etQ().d == 0) {
                        a.this.plh.setDirectVisibility(0);
                    }
                    a.this.pli.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.plk = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void kg(boolean z) {
                if (a.this.plU) {
                    a.this.plU = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.pli.setImageResource(a.e.cs_emoji_normal);
                    a.this.euW();
                    return;
                }
                if (a.this.plN != null && a.this.plN.getVisibility() == 0) {
                    a.this.plN.setVisibility(8);
                }
                if (a.this.plp) {
                    a.this.prn.setVisibility(0);
                }
                if (a.this.pqI != null && (a.this.pqI instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.pqI).AD(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.plj = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.plh, this.plk, ((VideoPlayer) this.pqI).eup());
        ((VideoPlayer) this.pqI).h(((VideoPlayer) this.pqI).eup());
        this.plN = this.pqt.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.plK = (TextView) this.pqt.findViewById(a.f.btn_room_search);
        this.plL = (ImageView) this.pqt.findViewById(a.f.iv_room_emoji_delete);
        this.plM = (EditText) this.pqt.findViewById(a.f.et_room_emoji_search);
        this.plM.setImeOptions(3);
        this.plM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.plK);
                    return true;
                }
                return false;
            }
        });
        this.plM.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.plK.setEnabled(editable.length() > 0);
                a.this.plL.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.prn.setEmojiSearchText(editable.toString());
            }
        });
        this.plK.setOnClickListener(this);
        this.plL.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aI(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bD(this.plM);
            this.plN.setVisibility(0);
            this.plM.requestFocus();
        } else {
            this.plN.setVisibility(8);
        }
        if (z2) {
            this.plM.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euW() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hD(this.pqI).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI)) - tv.chushou.zues.widget.kpswitch.b.d.ek(this.pqI)) - tv.chushou.zues.utils.a.dip2px(this.pqI, 14.0f)) - this.pqI.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.pqI, 54.0f) * 2);
        if (statusBarHeight < this.plx) {
            b(statusBarHeight, 10);
        }
    }

    private void euX() {
    }

    private void aL() {
        this.pqJ = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aJ(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.pqt.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.pqI.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.pqJ.D(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.pqJ.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.pqJ.D(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.pqJ);
                            break;
                        case 12:
                            a.this.b(a.this.pqJ);
                            break;
                        case 17:
                            a.this.evJ();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.pqG.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void euY() {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.plt)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.plt.size()) {
                    if (!h.isEmpty(this.plt.get(i2).notifyIcon)) {
                        this.plm.ce(i2, this.plt.get(i2).notifyIcon);
                        this.plm.Sn(i2);
                    } else if (this.plt.get(i2).notify == 1) {
                        this.plm.Sm(i2);
                        this.plm.Sl(i2);
                    } else {
                        this.plm.Sl(i2);
                        this.plm.Sn(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.plt)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.plt.size()) {
                    if (this.plt.get(i4).type == i) {
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
    public String QA(int i) {
        if (this.pqH == null || this.pqH.euJ() == null || this.pqH.euJ().mRoominfo == null || h.isEmpty(this.plt)) {
            if (i == 1) {
                return this.pqI.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.pqI.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.plt.size()) {
            return this.plt.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.plt) && i < this.plt.size()) {
            this.plt.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.plt) && i < this.plt.size()) {
            this.plt.get(i).notifyIcon = str;
        }
    }

    private void euZ() {
        if (this.pln != null && this.plm != null && this.pks != null) {
            this.pkv = null;
            if (this.pkt != null) {
                for (int i = 0; i < this.pkt.length; i++) {
                    this.pkt[i] = null;
                }
            }
            if (this.plR == null) {
                this.plR = new C0994a(getChildFragmentManager());
                this.pln.setAdapter(this.plR);
            } else {
                this.plR.notifyDataSetChanged();
            }
            this.pln.setOffscreenPageLimit(this.pks.length);
            this.plm.c(this.pln);
            this.plm.setOnPageChangeListener(this);
            this.plm.notifyDataSetChanged();
            this.plm.setVisibility(0);
            this.pln.setVisibility(0);
            if (!this.pls) {
                this.bB = 2;
                this.pln.setCurrentItem(c(2, 0));
                this.pkM.setVisibility(0);
            } else {
                if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                    if (!h.isEmpty(this.pqH.euJ().mRoominfo.mGameName)) {
                        this.pkz.setText(this.pqH.euJ().mRoominfo.mGameName);
                    } else {
                        this.pkz.setText(this.pqI.getString(a.i.no_online_game_name));
                    }
                    this.pky.setText(this.pqH.euJ().mRoominfo.mName);
                } else {
                    this.pkz.setText(this.pqI.getString(a.i.no_online_game_name));
                }
                euY();
                if (i()) {
                    evi();
                    if (this.pln != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.pln.setCurrentItem(c);
                        this.plm.setSelectItem(c);
                    }
                } else if (this.pln != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.pln.setCurrentItem(c2);
                    this.plm.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void eva() {
        this.pqu = new SurfaceView(this.pqI);
        SurfaceView surfaceView = (SurfaceView) this.pqu;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        evH().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void evb() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.pqI).s();
        eea();
        evf();
        euU();
        evH().setBackgroundResource(a.e.room_not_online);
        if (this.pkE == null) {
            this.pkE = new RecommendView(this.pqI);
            evH().addView(this.pkE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.pqI);
            this.pkE.setLayoutParams(layoutParams);
        }
        if (this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.pqH.euJ().mRoominfo.mRoomID)) {
            this.pkE.a(this.pqH.euJ().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.pqI != null && a.this.evH() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.pqI);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.oPL);
                        if (a.this.evH().getChildCount() >= 2) {
                            a.this.evH().addView(frescoThumbnailView, 0);
                        }
                        a.this.evH().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.eHE(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.pqu != null) {
            this.pqu.setVisibility(8);
        }
        if (this.prv != null) {
            this.prv.eHa();
            this.prv.setVisibility(8);
        }
        m(false, false, true);
        if (this.f4123a != null) {
            this.f4123a.setVisibility(8);
        }
        if (this.prn != null) {
            this.prn.e();
        }
        AG(false);
        a(false, false);
        if (this.pkb != null) {
            this.pkb.d();
        }
    }

    private void evc() {
        int i = 0;
        this.pkw = this.pqt.findViewById(a.f.topview);
        if (com.kascend.chushou.b.etQ().d == 0 && this.plC > 0) {
            View findViewById = this.pqt.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.plC;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.pkx = (ImageView) this.pkw.findViewById(a.f.back_icon);
        this.pkx.setOnClickListener(this);
        this.pky = (MarqueeTextView) this.pkw.findViewById(a.f.tv_title);
        this.pkz = (MarqueeTextView) this.pkw.findViewById(a.f.tv_Type);
        this.pkB = (ImageView) this.pqt.findViewById(a.f.btn_setting);
        this.pkF = this.pqt.findViewById(a.f.bottomview);
        if (this.pqz == null) {
            this.pqz = (ImageButton) this.pkF.findViewById(a.f.btn_barrage);
            this.pqz.setOnClickListener(this);
            if (this.pqH != null) {
                if (com.kascend.chushou.d.h.etY().n()) {
                    this.pqz.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.pqz.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.pqA = (ImageButton) this.pkF.findViewById(a.f.btn_audio);
        this.pqA.setOnClickListener(this);
        if (this.pqH != null && this.pqH.d) {
            this.pqA.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.pqA.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.pqH != null && this.pqH.f != null) {
            while (true) {
                if (i >= this.pqH.f.size()) {
                    break;
                } else if (!"2".equals(this.pqH.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.pkG = (ImageButton) this.pkF.findViewById(a.f.playbutton);
        this.pkG.setOnTouchListener(this);
        this.pkC = (ImageButton) this.pkF.findViewById(a.f.btn_refresh);
        this.pkC.setOnClickListener(this);
        this.pkH = (TextView) this.pkF.findViewById(a.f.tv_online_count);
        if (this.pqy == null) {
            this.pqy = (ImageButton) this.pkF.findViewById(a.f.btn_screenChange);
            this.pqy.setOnClickListener(this);
        }
        if (this.pkA == null) {
            this.pkA = (ImageView) this.pkw.findViewById(a.f.report_icon);
            this.pkA.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void ef(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.pkv != null) {
                        this.pkv.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                        this.pqH.euJ().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.pqH.euJ().mMicStatus.onMic) {
                            evk();
                        }
                        if (this.pqH.euJ().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.pqH.euJ().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.pqH.euJ().mRoominfo.mCreatorUID);
                            }
                        } else if (this.pqH.euJ().mMicStatus.onMic) {
                            this.pqH.euJ().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.pqH.euJ().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.pqH.euJ().mFanItems, str);
                            }
                            this.plS = z2;
                            if (this.pqH.euJ().mMicStatus != null && !h.isEmpty(this.pqH.euJ().mMicStatus.micRoomId) && !this.pqH.euJ().mMicStatus.micRoomId.equals("0")) {
                                this.plT = this.pqH.euJ().mMicStatus.micRoomId;
                            }
                            if (this.pkv != null) {
                                this.pkv.a(this.pqH.euJ().mMicStatus, this.pqH.euJ().mFanItems, str, z2);
                            }
                            if (this.plr != null && this.plr.getVisibility() == 0) {
                                this.plr.a(this.pqH.euJ().mFanItems, this.pqH.euJ().mMicStatus, str, z2, this.pqH.euJ().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.pkv != null) {
                                this.pkv.e();
                            }
                            if (this.plr != null && this.plr.isShown()) {
                                this.plr.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.pkv != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.pkv.a(roomChatBackground.mChatBackground);
                        } else {
                            this.pkv.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.plE != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.plE = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.pkf != null && this.pkf.pmX != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.pkf.pmX.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.pkf.pmX.mInPKMode = true;
                                    this.pkf.pmX.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.pkf.pmX.mPkUid = pkNotifyInfo.mPkUid;
                                    this.pkf.pmX.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.pkf.pmX.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.pkf.pmX.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.pkf.pmX.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.pkf.pmX.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.pkf.pmX.mMode = pkNotifyInfo.mMode;
                                    this.pkf.pmX.liveStyle = pkNotifyInfo.liveStyle;
                                    if (evr() != null) {
                                        evr().k(true, this.pkf.pmX.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.etY().f4087a) {
                                        if (!com.kascend.chushou.b.etQ().e) {
                                            com.kascend.chushou.b.etQ().e = true;
                                            g.O(this.pqI, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.etY().a(this.pqI, false);
                                        evj();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.plI != null) {
                                        this.plI.setVisibility(0);
                                    }
                                    this.pkf.pmX.mAction = 7;
                                    this.pkf.pmX.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.pkf.pmX.mPkUid = pkNotifyInfo.mPkUid;
                                    this.pkf.pmX.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.pkf.pmX.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.pkf.pmX.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.pkf.pmX.destinyInfo = pkNotifyInfo.destinyInfo;
                                    evq();
                                    if (evr() != null) {
                                        evr().k(false, 0L);
                                        evr().b(this.pkf.pmX, true);
                                        evr().a(this.pkf.pmX.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.YH(this.plJ);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.pkf.pmX.mInPKMode = false;
                                    this.pkf.pmX.mAction = 2;
                                    evq();
                                    if (evr() != null) {
                                        evr().c();
                                    }
                                    if (com.kascend.chushou.d.h.etY().f4087a) {
                                        if (!com.kascend.chushou.b.etQ().e) {
                                            com.kascend.chushou.b.etQ().e = true;
                                            g.O(this.pqI, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.etY().a(this.pqI, false);
                                        evj();
                                    }
                                    this.pkf.b = null;
                                    this.pkf.pmX = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.YH(this.plJ);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.pkf.pmX.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.pkf.pmX.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.pkf.pmX.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.pqH.euJ().mRoominfo.mRoomID) && this.pqH.euJ().mRoominfo.mRoomID.equals(this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (evr() != null) {
                                        evr().a(this.pkf.pmX, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.pkf.pmX.copyUpdate(pkNotifyInfo);
                                    if (evr() != null) {
                                        evr().a(this.pkf.pmX);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.pkf.pmX.copyStop(pkNotifyInfo);
                                        if (evr() != null) {
                                            evr().M(this.pkf.pmX.mMaxFreeDuration, this.pkf.pmX.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.pkf.pmX.copyResult(pkNotifyInfo);
                                    if (!this.plu && evr() != null) {
                                        int i5 = 1;
                                        if (this.pkf.pmX.destinyInfo != null && this.pkf.pmX.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        evr().a(h.parseInt(this.pkf.pmX.mResult), h.parseLong(this.pkf.pmX.mvpUid), this.pkf.pmX.mvpAvatar, this.pkf.pmX.mvpNickname, this.pkf.pmX.mMaxFreeDuration, this.pkf.pmX.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.pkv != null) {
                if (LoginManager.Instance().islogined() && this.pqH != null && this.pqH.l()) {
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
                if (this.pqH == null || this.pqH.euJ() == null || this.pqH.euJ().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.pqH.euJ().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.etY().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.etY().b().equals(next2.mUserID)) {
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
                this.pkv.a(arrayList, true, false);
                this.pkv.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.pks != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.pks.length) {
                    break;
                }
                if (this.pks[i2] == 99 && this.pkt != null && this.pkt[i2] != null && (this.pkt[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.pkt[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.plt.size() && this.plm != null) {
                if (i == 0) {
                    this.plm.setTagText(i2, new StringBuilder(this.plt.get(i2).name).toString());
                    return;
                } else {
                    this.plm.setTagText(i2, this.plt.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.pqz != null) {
            if (z) {
                this.pqz.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pqz.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout evd() {
        if (this.pqt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.pqt.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
        this.ar = Math.min(hD.x, hD.y);
        this.aq = (this.ar * this.pqI.getResources().getInteger(a.g.h_thumb_height_def)) / this.pqI.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = evH().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.pqB.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.plx = this.aq + this.pqI.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.pqI, 54.0f);
        b(this.plx, 10);
        if (this.pqu != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.pqu).setLayoutParams(layoutParams3);
        }
    }

    private void eve() {
        Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
        this.ar = Math.min(hD.x, hD.y);
        this.aq = (this.ar * this.pqI.getResources().getInteger(a.g.h_thumb_height_def)) / this.pqI.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = evH().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.pqB.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.plx = this.aq + this.pqI.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.pqI, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.plx, 10);
        k();
        if (!h.isEmpty(this.pkD)) {
            File ah = tv.chushou.zues.widget.fresco.a.ah(Uri.parse(this.pkD));
            if (ah != null && ah.exists()) {
                this.pqB.setImageURI(Uri.fromFile(ah));
                this.pqB.setVisibility(0);
                return;
            }
            this.pqB.setVisibility(8);
            return;
        }
        this.pqB.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aJ(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.pkA != null) {
            this.pkA.setVisibility(z ? 0 : 4);
        }
        if (this.pkB != null) {
            this.pkB.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aJ(boolean z, boolean z2) {
        return m(z, z2, this.f);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.pqJ != null) {
            this.pqJ.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.pqI).f(true);
            if (!z3) {
                if (this.pkF.getVisibility() != 0 && z2) {
                    this.pkF.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.pqA.setVisibility(0);
                } else {
                    this.pqA.setVisibility(8);
                }
                this.pkF.setVisibility(0);
            }
            PlayUrl euK = this.pqH.euK();
            if (euK != null && "2".equals(euK.mType)) {
                if (this.pqy != null) {
                    this.pqy.setVisibility(8);
                }
            } else if (this.pqy != null) {
                this.pqy.setVisibility(0);
            }
            if (this.pkw.getVisibility() != 0 && z2) {
                this.pkw.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_top_anim));
            }
            t(!z3);
            this.pkw.setVisibility(0);
            w(true);
            if (this.pqJ != null) {
                this.pqJ.D(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.pqI).f(false);
            if (this.pra != null) {
                this.pra.dismiss();
            }
            if (this.prb != null) {
                this.prb.dismiss();
            }
            if (this.pkF.getVisibility() != 8 && z2) {
                this.pkF.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_bottom_anim));
            }
            this.pkF.setVisibility(8);
            if (this.pkw.getVisibility() != 8 && z2) {
                this.pkw.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_top_anim));
            }
            this.pkw.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean eea() {
        if (this.prr == null || !this.prr.isShown()) {
            return false;
        }
        this.prr.d();
        return true;
    }

    public boolean evf() {
        if (this.plr == null || !this.plr.isShown()) {
            return false;
        }
        this.plr.a();
        return true;
    }

    public boolean euU() {
        if (this.plv == null || !this.plv.b()) {
            return false;
        }
        this.plv.a();
        return true;
    }

    public boolean evg() {
        if (this.plp && this.prn != null) {
            if (this.prn != null) {
                this.prn.e();
            }
            if (this.plM != null) {
                this.plM.setText("");
            }
            if (this.bB == 2) {
                aK(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.pqt != null) {
            if (this.plv == null) {
                this.plv = (PopH5Menu) ((ViewStub) this.pqt.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.plv.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.f4233a = listItem.mUrl;
            h5Options.h = -1;
            this.plv.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.pkw.getHeight() + this.pkw.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.pqI, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                g.d(this.pqI, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.pqH.a(false);
                a(false, false);
                ((VideoPlayer) this.pqI).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.pqI, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.pkf == null || this.pkf.pmX == null || !this.pkf.pmX.mInPKMode) {
                ((VideoPlayer) this.pqI).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.plg) {
                f(this.pkT.getText().toString());
            } else {
                a(this.pkT.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.etY().c) {
                com.kascend.chushou.d.h.etY().b(false);
                this.pkP.cancel();
                this.pkP.reset();
                this.pkO.clearAnimation();
                this.pkQ.setVisibility(8);
            }
            n(view, 0, this.pqt.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.pqI, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.pqt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.pqH.d) {
                edO();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.pqI, null) && this.pqH != null && this.pqH.pjN != null) {
                if (this.plg) {
                    evu();
                    return;
                }
                if (this.pqH != null && this.pqH.pjN != null && this.pqH.pjN.count > 0) {
                    this.pkV.setVisibility(8);
                } else {
                    this.pkV.setVisibility(0);
                }
                this.plg = true;
                this.pld.setBackgroundResource(a.e.ic_trumpet_p);
                this.ple.setVisibility(0);
                this.ple.setSelected(true);
                this.ple.setTextColor(Color.parseColor("#ff5959"));
                if (this.pkT != null) {
                    this.pkT.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.plf <= 9) {
                this.plf++;
                this.plc.setText(this.plf + "");
            }
            evs();
        } else if (id == a.f.tv_cut_count) {
            if (this.plf > 1) {
                this.plf--;
                this.plc.setText(this.plf + "");
            }
            evs();
        } else if (id == a.f.tv_buy_head) {
            evt();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.plM.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.plM.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.ep(this.plM);
                this.prn.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.pkT != null && this.pkM != null && this.pkS != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bD(this.pkT);
                this.pkM.setVisibility(8);
                if (this.bB == 2) {
                    this.pkS.setVisibility(0);
                }
            }
        } else if (this.pkM != null && this.pkS != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
            if (this.bB == 2) {
                this.pkM.setVisibility(0);
            }
            this.pkS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.etY().c(roomToast.mToastContent);
            if (this.ply == null) {
                aS();
            }
            if (this.plz != null) {
                this.plz.setText(roomToast.mToastContent);
            }
            if (!this.ply.isShowing()) {
                if (this.plo != null) {
                    this.ply.showAtLocation(this.plo, 85, 0, this.pqt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
                    RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.ply != null) {
                                a.this.ply.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.ply.dismiss();
        }
    }

    private void aS() {
        if (this.ply == null) {
            View inflate = LayoutInflater.from(this.pqI).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.plz = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.ply = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 160.0f), -2);
            this.ply.setFocusable(false);
            this.ply.setOutsideTouchable(false);
            this.ply.setAnimationStyle(a.j.gift_toast_style);
            this.ply.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.pri != null && this.pri.isShowing()) {
            this.pri.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
        if (this.prF == null) {
            evK();
        }
        if (!this.prF.isShowing()) {
            this.prF.showAtLocation(view, 83, i, i2);
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.pqH.euJ().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.prF.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.prI != null) {
            if (h.isEmpty(this.prJ)) {
                if (((VideoPlayer) this.pqI).q) {
                    this.prI.ce(this.pqH != null ? this.pqH.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.prI.ce(this.pqH != null ? this.pqH.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.pqI).q && this.prJ.size() == 2 && this.prJ.contains("4") && this.prJ.contains("2")) {
                this.prI.ce(this.pqH != null ? this.pqH.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.prJ.size() > 1 || !((VideoPlayer) this.pqI).q) {
                this.prI.ce(this.pqH != null ? this.pqH.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.prJ.get(0))) {
                this.prI.ce(this.pqH != null ? this.pqH.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.prJ.get(0))) {
                this.prI.ce(this.pqH != null ? this.pqH.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.prJ.get(0))) {
                this.prI.ce(this.pqH != null ? this.pqH.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
        if (this.pri == null) {
            al();
            this.pri.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.pri.isShowing() && this.bB == 2) {
            this.pri.showAtLocation(view, 83, i, this.pqI.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.pqH.euJ().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.pri.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.pqB != null) {
            this.pqB.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                g.d(this.pqI, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.pmW.getPlayState() == 4) {
                        e(true);
                        if (this.pqH.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.pqH.a(false);
                        ((VideoPlayer) this.pqI).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.pmW.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.pmW.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                g.d(this.pqI, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.pqH.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.pqI).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                    this.ai = false;
                    AG(true);
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
        if (this.prv != null) {
            if (z) {
                this.prv.setVisibility(0);
            }
            this.prv.eHa();
            if (!z) {
                this.prv.setVisibility(8);
            }
        }
        g.d(this.pqI, this.pqI.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.pkG != null) {
                this.pkG.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4123a != null) {
                this.f4123a.setVisibility(8);
            }
            if (this.pqC != null) {
                this.pqC.setVisibility(8);
                return;
            }
            return;
        }
        if (this.pkG != null) {
            this.pkG.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4123a != null) {
            if (z2 != (this.f4123a.getVisibility() == 0)) {
                if (z2) {
                    this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4123a.setVisibility(0);
                    return;
                }
                this.f4123a.setVisibility(8);
                if (this.pqC != null) {
                    this.pqC.setVisibility(8);
                }
            }
        }
    }

    private void evh() {
        this.e = false;
        m(true, false, true);
    }

    private void evi() {
        this.e = false;
        m(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.pks[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            euY();
            a(this.pqH != null ? this.pqH.pjO.get("1") : null);
            if (i2 == 2) {
                k();
                aK(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.pqI, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aK(false, i3);
            v(false);
            b(false);
            if (this.pri != null && this.pri.isShowing()) {
                this.pri.dismiss();
            }
            if (i2 == 99) {
                if (this.pkt != null && this.pkt[i] != null && (this.pkt[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.pkt[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.pqI, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.pqI, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.pqI, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.pqI, "房间信息页_num", null, new Object[0]);
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
    protected void evj() {
        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.pqJ != null) {
            if (this.pkS != null && this.pkS.getVisibility() == 0) {
                u(false);
            }
            if (this.pqC != null && this.pqC.getVisibility() == 0) {
                this.f = true;
            }
            aJ(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.pkv != null) {
            this.pkv.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.pkv != null) {
            this.pkv.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.pkv != null) {
            this.pkv.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.pkv != null) {
            this.pkv.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.plo != null) {
            int size = iconConfig.configs.size();
            this.plo.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.pqI).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.plo, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.ce(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.ce(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.ce(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.ce(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.ce(str, a.e.ic_default_video_bottom);
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
                    public void ef(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.plo.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.pqH != null ? this.pqH.pjO : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.pkv != null) {
            this.pkv.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pll != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.pll.DX(a.c.kas_white);
            } else if (this.bB == 2) {
                this.pll.ce(str, a.c.kas_white);
                if (this.plm != null) {
                    this.plm.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.pll.DX(a.c.kas_white);
                if (this.plm != null) {
                    this.plm.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a2 = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a3 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.plm != null) {
                    this.plm.setTextColor(a2);
                    this.plm.setTabTextSelectColor(a3);
                    this.plm.setIndicatorColor(a3);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pkO != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.pkO.DX(a.e.ic_hotwords_black_n);
            } else {
                this.pkO.ce(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pkN != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.evX().a(str, this.pkN, a.e.player_skin_input);
            } else {
                this.pkN.setBackgroundResource(a.e.player_skin_input);
            }
            int a2 = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.pkR != null) {
                this.pkR.setTextColor(a2);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void a(int i) {
        if (this.pkv != null) {
            this.pkv.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void D() {
        if (this.pqI instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a euq = ((VideoPlayer) this.pqI).euq();
            if (this.prz == null) {
                this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.prz.setVisibility(0);
            this.prz.a(2, euq);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pkv != null) {
            this.pkv.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pkv != null) {
            this.pkv.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(long j) {
        if (this.pkv != null) {
            this.pkv.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1001a
    public void c(int i) {
        if (this.pkv != null) {
            this.pkv.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pkv != null && this.pqH != null) {
            this.pkv.b(this.pqH.pjM);
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
    public class C0994a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0994a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.pks.length) {
                return null;
            }
            switch (a.this.pks[i]) {
                case 1:
                    if (a.this.pku == null) {
                        a.this.pku = com.kascend.chushou.view.user.a.a(2, null, a.this.pqH.f4119a, false, a.this.pqH.h, false);
                    }
                    a.this.pkt[i] = a.this.pku;
                    return a.this.pku;
                case 2:
                    if (a.this.pkv == null) {
                        a aVar = a.this;
                        if (a.this.pkf != null && a.this.pkf.pmX != null) {
                            z = a.this.pkf.pmX.mInPKMode;
                        }
                        aVar.pkv = com.kascend.chushou.player.ui.a.AH(z);
                    }
                    a.this.pkt[i] = a.this.pkv;
                    return a.this.pkv;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.pqH != null && a.this.pqH.euJ() != null && !h.isEmpty(a.this.plt)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.plt.get(i).url);
                        h5Options.f4233a = a.this.plt.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a2 = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.pkt[i] = a2;
                    return a2;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.QA(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.pks.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int pF(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int QB(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String QC(int i) {
            return a.this.QA(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int QD(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b QE(int i) {
            int dimensionPixelSize = a.this.pqI.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void HP(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.Sc(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.pkm <= IMConnection.RETRY_DELAY_TIMES) {
            g.Sc(a.i.str_too_fast);
            return false;
        } else {
            evm();
            if (!com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a(((VideoPlayer) this.pqI).euk().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.pkm = System.currentTimeMillis();
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                a(this.pqH.euJ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.pqH.h);
            }
            g(this.b);
            if (!z && this.pkT != null) {
                this.pkT.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            evm();
            if (com.kascend.chushou.d.e.c(this.pqI, null) && LoginManager.Instance().getUserInfo() != null && this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                a(this.pqH.euJ().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.pkT != null) {
                this.pkT.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.pkv != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.pqH.euJ().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.pqH.euJ().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.pqI).phZ;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.aaA(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.pkv.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.pkv.a(arrayList, true, true);
        }
    }

    private void evk() {
        if (this.pkv != null) {
            this.pkv.e();
        }
        if (this.plr != null && this.plr.isShown()) {
            this.plr.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.pqI instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.pqH != null) {
            this.pqH.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        evk();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.pqI != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.pqI).t)) {
                this.cx = true;
                if (this.pqH != null) {
                    this.pqH.f = null;
                    if (this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                        this.pqH.euJ().mRoominfo.mGameId = null;
                    }
                }
                evb();
                return;
            }
            this.cx = true;
            if (this.pqI != null) {
                ((VideoPlayer) this.pqI).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.pkE != null) {
            this.pkE.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.pkE != null) {
            this.pkE.setVisibility(8);
        }
        super.i(z);
    }

    private void evl() {
        euZ();
        if (i()) {
            aY();
            ap();
            return;
        }
        evb();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        evH().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.pqu != null) {
            this.pqu.setVisibility(0);
        }
        if (this.prv != null) {
            this.prv.setVisibility(0);
        }
        if (this.pkb != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.pkb.d();
        }
        if (this.pkM != null) {
            this.pkM.setVisibility(0);
        }
        if (com.kascend.chushou.c.f4079a) {
            this.pkB.setVisibility(0);
            this.pkB.setOnClickListener(this);
        } else {
            this.pkB.setVisibility(8);
        }
        this.pkG.setVisibility(0);
        this.pkC.setVisibility(0);
        this.pqz.setVisibility(0);
        if (this.p) {
            this.pqA.setVisibility(0);
        } else {
            this.pqA.setVisibility(8);
        }
        aX();
        aK(true, i());
        this.e = false;
        m(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.prz != null && this.prz.a(i, keyEvent)) {
                return true;
            }
            if (this.plv != null && this.plv.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.plw != null && this.plw.onKeyDown(i, keyEvent)) || evn()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.plN != null && this.plN.getVisibility() == 0 && a(motionEvent, this.plN)) {
                this.plN.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.ep(this.plM);
                return true;
            } else if (this.plp && this.plN != null && this.plN.getVisibility() == 8 && f(this.prn.b, motionEvent)) {
                evg();
                return true;
            } else if (this.plv != null && this.plv.b() && f(this.plv, motionEvent)) {
                this.plv.a();
                return true;
            } else if (this.plw != null && this.plw.b() && f(this.plw, motionEvent)) {
                this.plw.a();
                return true;
            } else if (a(motionEvent, this.pkS)) {
                return evm();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean evm() {
        boolean z;
        b(this.plx, 10);
        boolean z2 = false;
        if (this.plh != null && this.plh.getVisibility() == 0) {
            this.plh.setVisibility(8);
            this.pli.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
            this.pli.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.pkS == null || this.pkS.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.plg) {
                evu();
            }
            this.pkS.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.pkM != null && a.this.bB == 2) {
                        a.this.pkM.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean evn() {
        if (evm()) {
            return true;
        }
        if (this.pri == null || !this.pri.isShowing()) {
            return evg() || evf() || eea();
        }
        this.pri.dismiss();
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
        this.pkM.setVisibility(8);
        this.pkS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(boolean z, boolean z2) {
        if (this.pkM != null) {
            if (z) {
                if (this.pkM.getVisibility() != 0) {
                    this.pkM.setVisibility(0);
                    this.pkM.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_bottom_anim));
                }
            } else if (this.pkM.getVisibility() != 4) {
                this.pkM.setVisibility(4);
                this.pkM.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.pkE != null) {
            this.pkE.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a evo() {
        return this.plB;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.pqH != null) {
                        this.pqH.f = null;
                        this.pqH.euJ().mRoominfo.mGameId = null;
                    }
                    evb();
                    return;
                }
                g.Sc(a.i.str_getvideosource_failed);
            }
            AG(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.pqH != null && this.pqH.euK() != null) {
            a(this.pqH.euK());
        }
        this.p = false;
        if (this.pqH == null || this.pqH.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.pqH.f.size()) {
                if (!"2".equals(this.pqH.f.get(i2).mType)) {
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
        if (this.pkv != null) {
            this.pkv.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.pkH != null && this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                this.pkH.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.pqH.euJ().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.plu && (c = c(1, -1)) >= 0 && c < this.plt.size() && this.pln != null) {
            this.pln.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.plu) {
            if (bVar.f4152a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.pqI, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                com.kascend.chushou.player.ui.h5.b.b eur = ((VideoPlayer) this.pqI).eur();
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(2, eur);
            } else if (bVar.f4152a == 3) {
                com.kascend.chushou.player.ui.h5.d.a eus = ((VideoPlayer) this.pqI).eus();
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(2, eus);
            } else if (bVar.f4152a == 9) {
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.plh != null) {
            this.plh.setPanelEnabled(gVar.f4071a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.plu) {
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
        if (!aa() && this.pqH != null) {
            String str = this.pqH.f4119a;
            RoomInfo euL = this.pqH.euL();
            if (euL != null && mVar.a(euL.mCreatorUID, str)) {
                euL.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.pkT != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.pkT);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
            if (this.plq == null) {
                this.plq = new f(getActivity());
            }
            this.plq.a(this.pqH.euJ().mRoominfo);
            if (!this.plq.isShowing()) {
                this.plq.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.pkv != null) {
            this.pkv.d();
        }
    }

    private void e(View view) {
        this.pkI = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.pkJ = (TextView) view.findViewById(a.f.tv_4g_video);
        this.pkJ.setText(new tv.chushou.zues.widget.a.c().R(this.pqI, a.e.videoplayer_4g_video).append("  ").append(this.pqI.getString(a.i.videoplayer_4g_video)));
        this.pkK = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.pkK.setText(new tv.chushou.zues.widget.a.c().R(this.pqI, a.e.videoplayer_4g_audio).append("  ").append(this.pqI.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.pkI.setVisibility(8);
                    ((VideoPlayer) a.this.pqI).c(a.this.pkL);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.pkI.setVisibility(8);
                    ((VideoPlayer) a.this.pqI).d(a.this.pkL);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.etQ().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.pkJ.setOnClickListener(onClickListener);
        this.pkK.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.pqH != null && !h.isEmpty(this.pqH.f)) {
            g(this.pqH.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.pkL = z;
            this.p = false;
            if (this.pqH != null && this.pqH.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.pqH.f.size()) {
                        break;
                    } else if (!"2".equals(this.pqH.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.pkI != null) {
                this.pkI.setVisibility(0);
                this.pkJ.setVisibility(0);
                this.pkK.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.pkI != null) {
            this.pkI.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.plF == null) {
                this.plF = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.pqJ != null) {
                    this.pqJ.f(this.plF, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.plF != null && this.pqJ != null) {
            this.pqJ.N(this.plF);
            this.plF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.pkv != null) {
            com.kascend.chushou.toolkit.a.c.a(this.pqI, "显示双击666_num", null, new Object[0]);
            if (this.pqH != null) {
                this.pqH.b(false);
            }
            d(false);
            this.pkv.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.pqt != null) {
            if (this.plw == null) {
                this.plw = (InteractionView) ((ViewStub) this.pqt.findViewById(a.f.view_interaction)).inflate();
                this.plw.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.plw.a();
                    }
                });
            }
            if (this.plw != null) {
                this.plw.b(configDetail);
                this.plw.c();
                this.plw.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eHM()) {
                g.O(this.pqI, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.pqI, null) && (this.pqI instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.pqH != null) {
                com.kascend.chushou.toolkit.a.c.a(this.pqI, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.pqH != null) {
                com.kascend.chushou.toolkit.a.c.a(this.pqI, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.pqI, configDetail.mUrl, this.pqI.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.pqI, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    evp();
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

    private void evp() {
        if (this.plp) {
            evg();
            return;
        }
        if (this.pqI.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击送礼_num", "竖屏", new Object[0]);
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.pqH.euJ().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.pqI != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.pkf == null) {
                this.pkf = new com.kascend.chushou.player.e.a();
            }
            this.pkf.b = str;
            this.pkf.pmX.copy(pkNotifyInfo);
            if (this.pkf.pmX.mAction == 6) {
                this.pkf.pmX.mInPKMode = true;
                this.u = this.pkf.pmX.mPkId;
            } else if (this.pkf.pmX.mAction == 7 || (this.pkf.pmX.mMode == 1 && this.pkf.pmX.mAction == 5)) {
                this.pkf.pmX.mInPKMode = true;
                this.u = this.pkf.pmX.mPkId;
                if (evr() != null) {
                    if (2 == this.bB && this.plI != null) {
                        this.plI.setVisibility(0);
                    }
                    evr().b(this.pkf.pmX, false);
                    evr().a(this.pkf.pmX.mMode, "1");
                    if (this.pkf.pmX.mAction == 5 && this.pkf.pmX.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.pkf.pmX.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.pkf.pmX.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.pkf.pmX.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.pkf.pmX.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.pkf.pmX.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        evr().a(this.pkf.pmX);
                        if (this.pkf.pmX.destinyInfo == null || this.pkf.pmX.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        evr().a(parseInt, this.pkf.pmX.mPkUpdateInfo.remainDuration, j, this.pkf.pmX.mMode, i);
                    }
                    if (!h.isEmpty(this.pkf.pmX.mPkUpdateInfo.specialMomentList) && evr() != null) {
                        evr().a(this.pkf.pmX, true);
                    }
                }
                evq();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.YH(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.pkf.pmX.mInPKMode = false;
                evq();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.YH(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void evq() {
        if (this.pkf != null && this.pkf.pmX != null) {
            if (this.pkf.pmX.mInPKMode) {
                this.y.setText(this.pkf.pmX.mPkUserNickname);
                this.pki.setVisibility(0);
                if (this.pqy != null) {
                    this.pqy.setEnabled(false);
                }
                if (this.pqA != null) {
                    this.pqA.setEnabled(false);
                    return;
                }
                return;
            }
            this.pki.setVisibility(8);
            if (this.pqy != null) {
                this.pqy.setEnabled(true);
            }
            if (this.pqA != null) {
                this.pqA.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b evr() {
        if (this.pqI == null || this.pqt == null || this.plI == null) {
            return null;
        }
        if (this.pkh == null) {
            if (this.plH == null) {
                this.plH = ((ViewStub) this.pqt.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.pkh = new com.kascend.chushou.player.e.b();
            this.pkh.a(this.plI, this.plH, (View) null, this.pqI, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cId()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.pqH != null) {
                        append.append(a.this.pqH.euL().mRoomID);
                    }
                    if (a.this.pkf != null && a.this.pkf.pmX != null) {
                        append.append("&mode=").append(a.this.pkf.pmX.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.pqI, append.toString());
                }
            });
        }
        return this.pkh;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.ple != null && this.pqH != null && this.pqH.pjN != null) {
            this.ple.setText(tv.chushou.zues.utils.b.Sb(this.pqH.pjN.count));
            this.ple.setVisibility(0);
            if (this.pqH.pjN.count < 1) {
                evu();
            }
            if (this.pkW != null) {
                this.pkW.setText(this.pqH.pjN.primaryName);
            }
            if (this.pkX != null) {
                this.pkX.setText(this.pqH.pjN.desc);
            }
            evs();
        }
    }

    public void evs() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.plf * h.parseLong(this.pqH.pjN.point)));
        if (this.pkZ != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.pqI.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.R(this.pqI, a.e.icon_coin_new);
            cVar.append(this.pqI.getString(a.i.str_buy_count_coin2));
            this.pkZ.setText(cVar);
        }
    }

    private void evt() {
        if (com.kascend.chushou.d.e.c(this.pqI, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.plf);
        }
    }

    private void v(boolean z) {
        if (this.pqt != null && this.plI != null) {
            if (z) {
                if (this.pkf != null && this.pkf.pmX != null && this.pkf.pmX.mInPKMode) {
                    this.plI.setVisibility(0);
                    return;
                }
                return;
            }
            this.plI.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.pqt != null && this.pkl != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.pkl.setVisibility(0);
                    return;
                }
                return;
            }
            this.pkl.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.pkf != null && this.pkf.pmX != null && this.pkf.pmX.mInPKMode && this.pki != null) {
                this.pki.setVisibility(0);
            }
        } else if (this.pki != null) {
            this.pki.setVisibility(8);
        }
    }

    private void evu() {
        this.plg = false;
        this.pld.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.pqH != null && this.pqH.pjN != null) {
            if (this.pqH.pjN.count < 1) {
                this.ple.setVisibility(8);
            } else {
                this.ple.setVisibility(0);
                this.ple.setSelected(false);
                this.ple.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.pkV.setVisibility(8);
        if (this.pkT != null) {
            this.pkT.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        evp();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pkR != null) {
            this.pkR.performClick();
        }
    }

    public boolean evv() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.plU = true;
        if (this.pqt != null && com.kascend.chushou.b.etQ().d == 0) {
            this.plD = tv.chushou.zues.utils.systemBar.b.hH(getActivity());
            if (!z) {
                View findViewById = this.pqt.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.plD = tv.chushou.zues.utils.systemBar.b.hH(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.plD);
            View findViewById2 = this.pqt.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.plD);
            findViewById2.requestLayout();
        }
    }
}
