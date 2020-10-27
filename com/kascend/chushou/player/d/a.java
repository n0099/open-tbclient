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
    private int[] paV;
    private Fragment[] paW;
    private TextView pbA;
    private TextView pbB;
    private TextView pbC;
    private TextView pbD;
    private TextView pbE;
    private TextView pbF;
    private ImageView pbG;
    private TextView pbH;
    private KPSwitchPanelLinearLayout pbK;
    private ImageView pbL;
    private c pbM;
    private d.a pbN;
    private FrescoThumbnailView pbO;
    private PagerSlidingTabStrip pbP;
    private KasViewPager pbQ;
    private LinearLayout pbR;
    private f pbT;
    private ViewMicPerson pbU;
    public ArrayList<RoomTab> pbW;
    private PopH5Menu pbY;
    private InteractionView pbZ;
    private ImageView pba;
    private MarqueeTextView pbb;
    private MarqueeTextView pbc;
    private ImageView pbd;
    private ImageView pbe;
    private ImageButton pbf;
    public String pbg;
    private RecommendView pbh;
    private TextView pbk;
    private RelativeLayout pbl;
    private TextView pbm;
    private TextView pbn;
    private boolean pbo;
    private RelativeLayout pbp;
    private View pbq;
    private FrescoThumbnailView pbr;
    private AnimationSet pbs;
    private ImageView pbt;
    private TextView pbu;
    private RelativeLayout pbv;
    private PastedEditText pbw;
    private TextView pbx;
    private LinearLayout pby;
    private TextView pbz;
    private int pca;
    private PopupWindow pcb;
    private TextView pcc;
    private GiftAnimationLayout pcd;
    private com.kascend.chushou.player.b.a pce;
    private Runnable pci;
    private View pck;
    private LivePKBarUserValue pcl;
    private String pcm;
    private TextView pcn;
    private ImageView pco;
    private EditText pcp;
    private View pcq;
    private View pcr;
    private View pcs;
    private String pcw;
    private long paP = 0;
    private com.kascend.chushou.view.user.a paX = null;
    private com.kascend.chushou.player.ui.a paY = null;
    private int bB = -1;
    private int bC = 0;
    private View paZ = null;
    private View pbi = null;
    private ImageButton pbj = null;
    private int pbI = 1;
    private boolean pbJ = false;
    private boolean cp = false;
    private boolean pbS = false;
    private boolean cx = false;
    private boolean pbV = false;
    private boolean pbX = false;
    private boolean cC = true;
    private int pcf = 0;
    private int pcg = 0;
    private int pch = -1;
    private final Rect pcj = new Rect();
    private boolean pct = false;
    private C0975a pcu = null;
    private boolean pcv = false;
    private boolean pcx = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pbg = getArguments().getString("mCover");
        this.cC = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.pgS = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.pgS;
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
        this.pbX = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.phM != null) {
            this.phM.b();
        }
        if (this.phh != null && (this.phh instanceof VideoPlayer)) {
            ((VideoPlayer) this.phh).As(true);
            ((VideoPlayer) this.phh).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.pbX = true;
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
        this.pbI = 1;
        this.pbJ = false;
        U();
        if (this.phi != null) {
            this.phi.cs(null);
            this.phi = null;
        }
        if (this.pbh != null) {
            erS().removeAllViews();
            this.pbh = null;
        }
        this.c = null;
        this.paD = null;
        tv.chushou.zues.a.a.ct(this);
        this.pbP = null;
        this.pbQ = null;
        this.paY = null;
        this.paX = null;
        if (this.paW != null) {
            for (int i = 0; i < this.paW.length; i++) {
                this.paW[i] = null;
            }
        }
        this.paW = null;
        if (this.pbw != null) {
            this.pbw.addTextChangedListener(null);
            this.pbw.setOnTouchListener(null);
            this.pbw.setOnEditorActionListener(null);
            this.pbw = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.phh, this.pbM);
        if (this.phh != null && (this.phh instanceof VideoPlayer)) {
            ((VideoPlayer) this.phh).eqz();
        }
        this.pbN = null;
        this.pbM = null;
        if (this.pbU != null) {
            this.pbU.b();
            this.pbU = null;
        }
        if (this.pcb != null) {
            this.pcb.dismiss();
        }
        if (this.pce != null) {
            this.pce.a();
            this.pce = null;
            this.pcd = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.pcl = (LivePKBarUserValue) this.pgS.findViewById(a.f.live_pk_bar_user);
        this.pha = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.pct) {
            this.pct = true;
            if (this.pcr == null) {
                this.pcr = this.pgS.findViewById(a.f.vs_async_view);
                this.pcr = ((ViewStub) this.pcr).inflate();
            }
            if (this.pcs == null) {
                this.pcs = this.pgS.findViewById(a.f.vs_async_notification_view);
                this.pcs = ((ViewStub) this.pcs).inflate();
            }
            this.paO = (VoiceInteractionView) this.pgS.findViewById(a.f.voiceInteractiveView);
            t();
            d(this.pgS);
            ean();
            ((VideoPlayer) this.phh).q();
            this.paJ = new com.kascend.chushou.player.e.a();
        }
    }

    private void d(View view) {
        this.pbO = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.pbP = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.pbQ = (KasViewPager) view.findViewById(a.f.vp_main);
        erg();
        aI();
        erk();
        if (this.phg != null) {
            I();
            a(this.phg.pao, this.phg.par);
        }
        this.bb = 0;
        this.phR = 0L;
        this.phN = (RoundProgressBar) this.pgS.findViewById(a.f.roundProgressBar);
        this.phO = (TextView) this.pgS.findViewById(a.f.tv_paonum);
        this.phP = (FrescoThumbnailView) this.pgS.findViewById(a.f.iv_paoicon);
        this.phW = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.pbS = false;
                if (a.this.bB == 2) {
                    a.this.aK(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.pca, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.pbS = true;
                if (a.this.bB == 2) {
                    a.this.aK(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.phM != null) {
                    a.this.phM.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.hD(a.this.phh).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.phh)) - a.this.phM.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.phh, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.phh, 54.0f) * 2);
                    if (statusBarHeight < a.this.pca) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.phQ = (PaoGuideView) this.pgS.findViewById(a.f.rlPaoGuideView);
        this.pbU = (ViewMicPerson) this.pgS.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.pdz = ((VideoPlayer) this.phh).eqs();
        this.phg = ((VideoPlayer) this.phh).eqv();
        e(this.pgS);
        this.pcf = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
        this.pcg = tv.chushou.zues.utils.systemBar.b.aG(getActivity());
        if (com.kascend.chushou.b.eqb().d == 0 && this.pcg > 0) {
            View findViewById = this.pgS.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.pcg);
        }
        erp();
        ern();
        if (!this.cC) {
            Q();
        }
        erl();
        a();
        if (this.c == null) {
            this.paD = new d.a();
            this.c = new GestureDetector(this.phh, this.paD);
        }
        this.paF = ((VideoPlayer) this.phh).eqw();
        this.paF.a(this);
        if (this.pce != null) {
            this.pce.a();
            this.pce = null;
        }
        this.pcd = (GiftAnimationLayout) this.pgS.findViewById(a.f.ll_gift_animation);
        this.pcd.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.phg != null) {
            this.pce = new com.kascend.chushou.player.b.a(this.phh.getApplicationContext(), this.pcd);
            this.pce.a(this.phg);
        }
        if (this.f4121a == null) {
            this.f4121a = (ImageButton) this.pgS.findViewById(a.f.resumebutton);
            this.f4121a.setOnTouchListener(this);
        }
        this.phb = (PlayerErrorView) this.pgS.findViewById(a.f.view_net_error_msg);
        this.phb.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aL();
        ers();
        if (this.phg.eqV() != null) {
            a(this.phg.eqV());
        }
        FullRoomInfo eqU = this.phg.eqU();
        if (eqU != null) {
            erw();
            if (i()) {
                this.ak = false;
                Av(true);
                this.phi.Ry(8);
            }
            this.pbk.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(eqU.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.pgT != null) {
            this.pgT.setVisibility(0);
        }
        this.paZ.setVisibility(0);
        this.ak = false;
        Av(true);
        this.phi.Ry(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.phh).n();
        if (this.phg != null && !h.isEmpty(this.phg.w)) {
            b(this.phg.w);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a eqG;
        erg();
        k();
        FullRoomInfo eqU = this.phg.eqU();
        if (eqU != null) {
            if (eqU.mRoominfo != null) {
                this.pbk.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(eqU.mRoominfo.mOnlineCount)));
                this.pcm = eqU.mRoominfo.mRoomID;
            }
            erw();
            if (!h.isEmpty(eqU.mRoomToastList)) {
                Iterator<RoomToast> it = eqU.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.eqj().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.phg != null && this.phg.l()) {
                d(true);
            }
            if (this.phh != null && (this.phh instanceof VideoPlayer) && (eqG = ((VideoPlayer) this.phh).eqG()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(eqG.pdA, eqG.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.pbR);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void erg() {
        boolean z = true;
        if (this.phg == null || this.phg.eqU() == null || this.phg.eqU().mRoominfo == null || h.isEmpty(this.phg.eqU().mRoomTabs)) {
            this.pbV = false;
            this.paW = new Fragment[2];
            this.paV = new int[2];
            this.paV[0] = 2;
            this.paV[1] = 1;
            return;
        }
        this.pbV = true;
        this.pbW = new ArrayList<>();
        Iterator<RoomTab> it = this.phg.eqU().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.pbW.add(next);
            }
        }
        if (this.pbW.size() >= 2 && this.paV != null && this.paV.length >= 2 && this.pbW.get(0).type == this.paV[0] && this.pbW.get(1).type == this.paV[1]) {
            z = false;
        }
        this.paW = new Fragment[this.pbW.size()];
        this.paV = new int[this.pbW.size()];
        for (int i = 0; i < this.pbW.size(); i++) {
            this.paV[i] = this.pbW.get(i).type;
        }
        if (z) {
            this.pcu = new C0975a(getChildFragmentManager());
            this.pbQ.setAdapter(this.pcu);
        }
    }

    private void aI() {
        this.pbv = (RelativeLayout) this.pgS.findViewById(a.f.rl_edit_bar);
        this.pbr = (FrescoThumbnailView) this.pgS.findViewById(a.f.btn_hotword);
        this.pbr.DK(a.e.ic_hotwords_black_n);
        this.pbr.setOnClickListener(this);
        this.pbt = (ImageView) this.pgS.findViewById(a.f.iv_task_badge);
        this.pbs = (AnimationSet) AnimationUtils.loadAnimation(this.phh, a.C0969a.anim_hotword);
        this.pbs.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.eqj().c) {
                    a.this.pbr.clearAnimation();
                    a.this.pbr.startAnimation(a.this.pbs);
                }
            }
        });
        if (com.kascend.chushou.d.h.eqj().c) {
            this.pbr.startAnimation(this.pbs);
            this.pbt.setVisibility(0);
        }
        this.pbu = (TextView) this.pgS.findViewById(a.f.tv_bottom_input);
        this.pbu.setOnClickListener(this);
        this.pij = (FrescoThumbnailView) this.pgS.findViewById(a.f.ll_btn_set);
        this.pij.setOnClickListener(this);
        this.pbR = (LinearLayout) this.pgS.findViewById(a.f.ll_bottom_all_button);
        this.pbp = (RelativeLayout) this.pgS.findViewById(a.f.rl_bottom_input);
        this.pbq = this.pgS.findViewById(a.f.ll_bottom_input);
        this.pbp.setVisibility(8);
        this.pbw = (PastedEditText) this.pgS.findViewById(a.f.et_bottom_input);
        this.pbw.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.pbx.setEnabled(editable.length() > 0);
            }
        });
        this.pbw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.pbx);
                    return true;
                }
                return true;
            }
        });
        this.pbw.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.pbw);
                }
                return false;
            }
        });
        this.pbL = (ImageView) this.pgS.findViewById(a.f.iv_btn_emoji);
        this.pbL.setVisibility(8);
        this.pbx = (TextView) this.pgS.findViewById(a.f.tv_btn_send);
        this.pbx.setOnClickListener(this);
        this.pbK = (KPSwitchPanelLinearLayout) this.pgS.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.eqb().d == 0) {
            this.pbK.setUseStatusBar(true);
        }
        this.pby = (LinearLayout) this.pgS.findViewById(a.f.head_trumpet);
        this.pby.setVisibility(8);
        this.pby.setOnClickListener(this);
        this.pbz = (TextView) this.pgS.findViewById(a.f.tv_primary_name);
        this.pbA = (TextView) this.pgS.findViewById(a.f.tv_primary_desc);
        this.pbD = (TextView) this.pgS.findViewById(a.f.tv_cut_count);
        this.pbD.setOnClickListener(this);
        this.pbF = (TextView) this.pgS.findViewById(a.f.tv_head_count);
        this.pbF.setText(this.pbI + "");
        this.pbE = (TextView) this.pgS.findViewById(a.f.tv_plus_count);
        this.pbE.setOnClickListener(this);
        this.pbC = (TextView) this.pgS.findViewById(a.f.tv_buy_count_coin);
        this.pbB = (TextView) this.pgS.findViewById(a.f.tv_buy_head);
        this.pbB.setOnClickListener(this);
        this.pbG = (ImageView) this.pgS.findViewById(a.f.iv_trumpet_select);
        this.pbG.setOnClickListener(this);
        this.pbH = (TextView) this.pgS.findViewById(a.f.tv_trumpet_have_count);
        this.pbJ = false;
        this.pbG.setBackgroundResource(a.e.ic_trumpet_n);
        this.pbH.setVisibility(8);
        eri();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.pbK, this.pbL, this.pbw, new a.InterfaceC1105a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1105a
            public void At(boolean z) {
                if (a.this.pbL != null) {
                    if (!z) {
                        a.this.pbL.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.eqb().d == 0) {
                        a.this.pbK.setDirectVisibility(0);
                    }
                    a.this.pbL.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.pbN = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void jX(boolean z) {
                if (a.this.pcx) {
                    a.this.pcx = false;
                    return;
                }
                a.this.cp = z;
                if (z) {
                    a.this.pbL.setImageResource(a.e.cs_emoji_normal);
                    a.this.erh();
                    return;
                }
                if (a.this.pcq != null && a.this.pcq.getVisibility() == 0) {
                    a.this.pcq.setVisibility(8);
                }
                if (a.this.pbS) {
                    a.this.phM.setVisibility(0);
                }
                if (a.this.phh != null && (a.this.phh instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.phh).As(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.pbM = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.pbK, this.pbN, ((VideoPlayer) this.phh).eqA());
        ((VideoPlayer) this.phh).h(((VideoPlayer) this.phh).eqA());
        this.pcq = this.pgS.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.pcn = (TextView) this.pgS.findViewById(a.f.btn_room_search);
        this.pco = (ImageView) this.pgS.findViewById(a.f.iv_room_emoji_delete);
        this.pcp = (EditText) this.pgS.findViewById(a.f.et_room_emoji_search);
        this.pcp.setImeOptions(3);
        this.pcp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.pcn);
                    return true;
                }
                return false;
            }
        });
        this.pcp.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.pcn.setEnabled(editable.length() > 0);
                a.this.pco.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.phM.setEmojiSearchText(editable.toString());
            }
        });
        this.pcn.setOnClickListener(this);
        this.pco.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aI(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bz(this.pcp);
            this.pcq.setVisibility(0);
            this.pcp.requestFocus();
        } else {
            this.pcq.setVisibility(8);
        }
        if (z2) {
            this.pcp.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erh() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.hD(this.phh).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh)) - tv.chushou.zues.widget.kpswitch.b.d.ek(this.phh)) - tv.chushou.zues.utils.a.dip2px(this.phh, 14.0f)) - this.phh.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.phh, 54.0f) * 2);
        if (statusBarHeight < this.pca) {
            b(statusBarHeight, 10);
        }
    }

    private void eri() {
    }

    private void aL() {
        this.phi = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.aJ(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.pgS.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.phh.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.phi.E(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.phi.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.phi.E(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.phi);
                            break;
                        case 12:
                            a.this.b(a.this.phi);
                            break;
                        case 17:
                            a.this.erU();
                            break;
                        case 18:
                            a.this.aq();
                            break;
                        case 19:
                            a.this.phf.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void erj() {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.pbW)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.pbW.size()) {
                    if (!h.isEmpty(this.pbW.get(i2).notifyIcon)) {
                        this.pbP.bZ(i2, this.pbW.get(i2).notifyIcon);
                        this.pbP.RT(i2);
                    } else if (this.pbW.get(i2).notify == 1) {
                        this.pbP.RS(i2);
                        this.pbP.RR(i2);
                    } else {
                        this.pbP.RR(i2);
                        this.pbP.RT(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.pbW)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.pbW.size()) {
                    if (this.pbW.get(i4).type == i) {
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
    public String Qf(int i) {
        if (this.phg == null || this.phg.eqU() == null || this.phg.eqU().mRoominfo == null || h.isEmpty(this.pbW)) {
            if (i == 1) {
                return this.phh.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.phh.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.pbW.size()) {
            return this.pbW.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.pbW) && i < this.pbW.size()) {
            this.pbW.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.pbW) && i < this.pbW.size()) {
            this.pbW.get(i).notifyIcon = str;
        }
    }

    private void erk() {
        if (this.pbQ != null && this.pbP != null && this.paV != null) {
            this.paY = null;
            if (this.paW != null) {
                for (int i = 0; i < this.paW.length; i++) {
                    this.paW[i] = null;
                }
            }
            if (this.pcu == null) {
                this.pcu = new C0975a(getChildFragmentManager());
                this.pbQ.setAdapter(this.pcu);
            } else {
                this.pcu.notifyDataSetChanged();
            }
            this.pbQ.setOffscreenPageLimit(this.paV.length);
            this.pbP.c(this.pbQ);
            this.pbP.setOnPageChangeListener(this);
            this.pbP.notifyDataSetChanged();
            this.pbP.setVisibility(0);
            this.pbQ.setVisibility(0);
            if (!this.pbV) {
                this.bB = 2;
                this.pbQ.setCurrentItem(c(2, 0));
                this.pbp.setVisibility(0);
            } else {
                if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                    if (!h.isEmpty(this.phg.eqU().mRoominfo.mGameName)) {
                        this.pbc.setText(this.phg.eqU().mRoominfo.mGameName);
                    } else {
                        this.pbc.setText(this.phh.getString(a.i.no_online_game_name));
                    }
                    this.pbb.setText(this.phg.eqU().mRoominfo.mName);
                } else {
                    this.pbc.setText(this.phh.getString(a.i.no_online_game_name));
                }
                erj();
                if (i()) {
                    ert();
                    if (this.pbQ != null) {
                        this.bB = 2;
                        int c = c(2, 0);
                        this.pbQ.setCurrentItem(c);
                        this.pbP.setSelectItem(c);
                    }
                } else if (this.pbQ != null) {
                    this.bB = 1;
                    int c2 = c(1, 1);
                    this.pbQ.setCurrentItem(c2);
                    this.pbP.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void erl() {
        this.pgT = new SurfaceView(this.phh);
        SurfaceView surfaceView = (SurfaceView) this.pgT;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.aq);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        erS().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void erm() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.phh).s();
        eas();
        erq();
        erf();
        erS().setBackgroundResource(a.e.room_not_online);
        if (this.pbh == null) {
            this.pbh = new RecommendView(this.phh);
            erS().addView(this.pbh);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.phh);
            this.pbh.setLayoutParams(layoutParams);
        }
        if (this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.phg.eqU().mRoominfo.mRoomID)) {
            this.pbh.a(this.phg.eqU().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.aa() && a.this.phh != null && a.this.erS() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.phh);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.oGs);
                        if (a.this.erS().getChildCount() >= 2) {
                            a.this.erS().addView(frescoThumbnailView, 0);
                        }
                        a.this.erS().setBackgroundResource(0);
                        frescoThumbnailView.j(str, tv.chushou.widget.a.c.eDP(), a.this.ar, a.this.aq);
                    }
                }
            });
        }
        if (this.pgT != null) {
            this.pgT.setVisibility(8);
        }
        if (this.phU != null) {
            this.phU.eDl();
            this.phU.setVisibility(8);
        }
        m(false, false, true);
        if (this.f4121a != null) {
            this.f4121a.setVisibility(8);
        }
        if (this.phM != null) {
            this.phM.e();
        }
        Av(false);
        a(false, false);
        if (this.paF != null) {
            this.paF.d();
        }
    }

    private void ern() {
        int i = 0;
        this.paZ = this.pgS.findViewById(a.f.topview);
        if (com.kascend.chushou.b.eqb().d == 0 && this.pcf > 0) {
            View findViewById = this.pgS.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.pcf;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.pba = (ImageView) this.paZ.findViewById(a.f.back_icon);
        this.pba.setOnClickListener(this);
        this.pbb = (MarqueeTextView) this.paZ.findViewById(a.f.tv_title);
        this.pbc = (MarqueeTextView) this.paZ.findViewById(a.f.tv_Type);
        this.pbe = (ImageView) this.pgS.findViewById(a.f.btn_setting);
        this.pbi = this.pgS.findViewById(a.f.bottomview);
        if (this.pgY == null) {
            this.pgY = (ImageButton) this.pbi.findViewById(a.f.btn_barrage);
            this.pgY.setOnClickListener(this);
            if (this.phg != null) {
                if (com.kascend.chushou.d.h.eqj().n()) {
                    this.pgY.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.pgY.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.pgZ = (ImageButton) this.pbi.findViewById(a.f.btn_audio);
        this.pgZ.setOnClickListener(this);
        if (this.phg != null && this.phg.d) {
            this.pgZ.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.pgZ.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.phg != null && this.phg.f != null) {
            while (true) {
                if (i >= this.phg.f.size()) {
                    break;
                } else if (!"2".equals(this.phg.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.pbj = (ImageButton) this.pbi.findViewById(a.f.playbutton);
        this.pbj.setOnTouchListener(this);
        this.pbf = (ImageButton) this.pbi.findViewById(a.f.btn_refresh);
        this.pbf.setOnClickListener(this);
        this.pbk = (TextView) this.pbi.findViewById(a.f.tv_online_count);
        if (this.pgX == null) {
            this.pgX = (ImageButton) this.pbi.findViewById(a.f.btn_screenChange);
            this.pgX.setOnClickListener(this);
        }
        if (this.pbd == null) {
            this.pbd = (ImageView) this.paZ.findViewById(a.f.report_icon);
            this.pbd.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dX(View view) {
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.paY != null) {
                        this.paY.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                        this.phg.eqU().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.phg.eqU().mMicStatus.onMic) {
                            erv();
                        }
                        if (this.phg.eqU().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.phg.eqU().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.phg.eqU().mRoominfo.mCreatorUID);
                            }
                        } else if (this.phg.eqU().mMicStatus.onMic) {
                            this.phg.eqU().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.phg.eqU().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.phg.eqU().mFanItems, str);
                            }
                            this.pcv = z2;
                            if (this.phg.eqU().mMicStatus != null && !h.isEmpty(this.phg.eqU().mMicStatus.micRoomId) && !this.phg.eqU().mMicStatus.micRoomId.equals("0")) {
                                this.pcw = this.phg.eqU().mMicStatus.micRoomId;
                            }
                            if (this.paY != null) {
                                this.paY.a(this.phg.eqU().mMicStatus, this.phg.eqU().mFanItems, str, z2);
                            }
                            if (this.pbU != null && this.pbU.getVisibility() == 0) {
                                this.pbU.a(this.phg.eqU().mFanItems, this.phg.eqU().mMicStatus, str, z2, this.phg.eqU().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.paY != null) {
                                this.paY.e();
                            }
                            if (this.pbU != null && this.pbU.isShown()) {
                                this.pbU.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.paY != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.paY.a(roomChatBackground.mChatBackground);
                        } else {
                            this.paY.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.pch != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.pch = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.paJ != null && this.paJ.pdA != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.paJ.pdA.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.paJ.pdA.mInPKMode = true;
                                    this.paJ.pdA.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.paJ.pdA.mPkUid = pkNotifyInfo.mPkUid;
                                    this.paJ.pdA.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.paJ.pdA.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.paJ.pdA.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.paJ.pdA.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.paJ.pdA.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.paJ.pdA.mMode = pkNotifyInfo.mMode;
                                    this.paJ.pdA.liveStyle = pkNotifyInfo.liveStyle;
                                    if (erC() != null) {
                                        erC().k(true, this.paJ.pdA.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.eqj().f4085a) {
                                        if (!com.kascend.chushou.b.eqb().e) {
                                            com.kascend.chushou.b.eqb().e = true;
                                            g.N(this.phh, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.eqj().a(this.phh, false);
                                        eru();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.bB && this.pcl != null) {
                                        this.pcl.setVisibility(0);
                                    }
                                    this.paJ.pdA.mAction = 7;
                                    this.paJ.pdA.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.paJ.pdA.mPkUid = pkNotifyInfo.mPkUid;
                                    this.paJ.pdA.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.paJ.pdA.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.paJ.pdA.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.paJ.pdA.destinyInfo = pkNotifyInfo.destinyInfo;
                                    erB();
                                    if (erC() != null) {
                                        erC().k(false, 0L);
                                        erC().b(this.paJ.pdA, true);
                                        erC().a(this.paJ.pdA.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.Yd(this.pcm);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.paJ.pdA.mInPKMode = false;
                                    this.paJ.pdA.mAction = 2;
                                    erB();
                                    if (erC() != null) {
                                        erC().c();
                                    }
                                    if (com.kascend.chushou.d.h.eqj().f4085a) {
                                        if (!com.kascend.chushou.b.eqb().e) {
                                            com.kascend.chushou.b.eqb().e = true;
                                            g.N(this.phh, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.eqj().a(this.phh, false);
                                        eru();
                                    }
                                    this.paJ.b = null;
                                    this.paJ.pdA = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.Yd(this.pcm);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.paJ.pdA.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.paJ.pdA.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.paJ.pdA.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.phg.eqU().mRoominfo.mRoomID) && this.phg.eqU().mRoominfo.mRoomID.equals(this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (erC() != null) {
                                        erC().a(this.paJ.pdA, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.paJ.pdA.copyUpdate(pkNotifyInfo);
                                    if (erC() != null) {
                                        erC().a(this.paJ.pdA);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.paJ.pdA.copyStop(pkNotifyInfo);
                                        if (erC() != null) {
                                            erC().J(this.paJ.pdA.mMaxFreeDuration, this.paJ.pdA.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.paJ.pdA.copyResult(pkNotifyInfo);
                                    if (!this.pbX && erC() != null) {
                                        int i5 = 1;
                                        if (this.paJ.pdA.destinyInfo != null && this.paJ.pdA.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        erC().a(h.parseInt(this.paJ.pdA.mResult), h.parseLong(this.paJ.pdA.mvpUid), this.paJ.pdA.mvpAvatar, this.paJ.pdA.mvpNickname, this.paJ.pdA.mMaxFreeDuration, this.paJ.pdA.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.paY != null) {
                if (LoginManager.Instance().islogined() && this.phg != null && this.phg.l()) {
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
                if (this.phg == null || this.phg.eqU() == null || this.phg.eqU().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.phg.eqU().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.eqj().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.eqj().b().equals(next2.mUserID)) {
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
                this.paY.a(arrayList, true, false);
                this.paY.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.paV != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.paV.length) {
                    break;
                }
                if (this.paV[i2] == 99 && this.paW != null && this.paW[i2] != null && (this.paW[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.paW[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.pbW.size() && this.pbP != null) {
                if (i == 0) {
                    this.pbP.setTagText(i2, new StringBuilder(this.pbW.get(i2).name).toString());
                    return;
                } else {
                    this.pbP.setTagText(i2, this.pbW.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.pgY != null) {
            if (z) {
                this.pgY.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pgY.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout ero() {
        if (this.pgS == null) {
            return null;
        }
        return (GiftAnimationLayout) this.pgS.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point hD = tv.chushou.zues.utils.a.hD(this.phh);
        this.ar = Math.min(hD.x, hD.y);
        this.aq = (this.ar * this.phh.getResources().getInteger(a.g.h_thumb_height_def)) / this.phh.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = erS().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.pha.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.pca = this.aq + this.phh.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.phh, 54.0f);
        b(this.pca, 10);
        if (this.pgT != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.aq);
            layoutParams3.addRule(13);
            ((SurfaceView) this.pgT).setLayoutParams(layoutParams3);
        }
    }

    private void erp() {
        Point hD = tv.chushou.zues.utils.a.hD(this.phh);
        this.ar = Math.min(hD.x, hD.y);
        this.aq = (this.ar * this.phh.getResources().getInteger(a.g.h_thumb_height_def)) / this.phh.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = erS().getLayoutParams();
        layoutParams.height = this.aq;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.pha.getLayoutParams();
        layoutParams2.height = this.aq;
        layoutParams2.width = this.ar;
        this.pca = this.aq + this.phh.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.phh, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.pca, 10);
        k();
        if (!h.isEmpty(this.pbg)) {
            File ah = tv.chushou.zues.widget.fresco.a.ah(Uri.parse(this.pbg));
            if (ah != null && ah.exists()) {
                this.pha.setImageURI(Uri.fromFile(ah));
                this.pha.setVisibility(0);
                return;
            }
            this.pha.setVisibility(8);
            return;
        }
        this.pha.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aJ(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.pbd != null) {
            this.pbd.setVisibility(z ? 0 : 4);
        }
        if (this.pbe != null) {
            this.pbe.setVisibility(z ? 0 : 4);
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
        if (this.phi != null) {
            this.phi.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.phh).f(true);
            if (!z3) {
                if (this.pbi.getVisibility() != 0 && z2) {
                    this.pbi.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.pgZ.setVisibility(0);
                } else {
                    this.pgZ.setVisibility(8);
                }
                this.pbi.setVisibility(0);
            }
            PlayUrl eqV = this.phg.eqV();
            if (eqV != null && "2".equals(eqV.mType)) {
                if (this.pgX != null) {
                    this.pgX.setVisibility(8);
                }
            } else if (this.pgX != null) {
                this.pgX.setVisibility(0);
            }
            if (this.paZ.getVisibility() != 0 && z2) {
                this.paZ.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_top_anim));
            }
            t(!z3);
            this.paZ.setVisibility(0);
            w(true);
            if (this.phi != null) {
                this.phi.E(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.phh).f(false);
            if (this.phz != null) {
                this.phz.dismiss();
            }
            if (this.phA != null) {
                this.phA.dismiss();
            }
            if (this.pbi.getVisibility() != 8 && z2) {
                this.pbi.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_bottom_anim));
            }
            this.pbi.setVisibility(8);
            if (this.paZ.getVisibility() != 8 && z2) {
                this.paZ.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_top_anim));
            }
            this.paZ.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean eas() {
        if (this.phQ == null || !this.phQ.isShown()) {
            return false;
        }
        this.phQ.d();
        return true;
    }

    public boolean erq() {
        if (this.pbU == null || !this.pbU.isShown()) {
            return false;
        }
        this.pbU.a();
        return true;
    }

    public boolean erf() {
        if (this.pbY == null || !this.pbY.b()) {
            return false;
        }
        this.pbY.a();
        return true;
    }

    public boolean err() {
        if (this.pbS && this.phM != null) {
            if (this.phM != null) {
                this.phM.e();
            }
            if (this.pcp != null) {
                this.pcp.setText("");
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
        if (listItem != null && this.pgS != null) {
            if (this.pbY == null) {
                this.pbY = (PopH5Menu) ((ViewStub) this.pgS.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.pbY.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.f4231a = listItem.mUrl;
            h5Options.h = -1;
            this.pbY.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            o(view, 0, this.paZ.getHeight() + this.paZ.getTop());
        } else if (id == a.f.btn_barrage) {
            p(view, 0, -tv.chushou.zues.utils.a.dip2px(this.phh, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                g.d(this.phh, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.phg.a(false);
                a(false, false);
                ((VideoPlayer) this.phh).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.phh, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.paJ == null || this.paJ.pdA == null || !this.paJ.pdA.mInPKMode) {
                ((VideoPlayer) this.phh).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.phh, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.pbJ) {
                f(this.pbw.getText().toString());
            } else {
                a(this.pbw.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.eqj().c) {
                com.kascend.chushou.d.h.eqj().b(false);
                this.pbs.cancel();
                this.pbs.reset();
                this.pbr.clearAnimation();
                this.pbt.setVisibility(8);
            }
            n(view, 0, this.pgS.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.phh, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            m(view, x, this.pgS.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.phg.d) {
                eag();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.phh, null) && this.phg != null && this.phg.paq != null) {
                if (this.pbJ) {
                    erF();
                    return;
                }
                if (this.phg != null && this.phg.paq != null && this.phg.paq.count > 0) {
                    this.pby.setVisibility(8);
                } else {
                    this.pby.setVisibility(0);
                }
                this.pbJ = true;
                this.pbG.setBackgroundResource(a.e.ic_trumpet_p);
                this.pbH.setVisibility(0);
                this.pbH.setSelected(true);
                this.pbH.setTextColor(Color.parseColor("#ff5959"));
                if (this.pbw != null) {
                    this.pbw.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.pbI <= 9) {
                this.pbI++;
                this.pbF.setText(this.pbI + "");
            }
            erD();
        } else if (id == a.f.tv_cut_count) {
            if (this.pbI > 1) {
                this.pbI--;
                this.pbF.setText(this.pbI + "");
            }
            erD();
        } else if (id == a.f.tv_buy_head) {
            erE();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.pcp.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.pcp.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.eh(this.pcp);
                this.phM.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.pbw != null && this.pbp != null && this.pbv != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bz(this.pbw);
                this.pbp.setVisibility(8);
                if (this.bB == 2) {
                    this.pbv.setVisibility(0);
                }
            }
        } else if (this.pbp != null && this.pbv != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
            if (this.bB == 2) {
                this.pbp.setVisibility(0);
            }
            this.pbv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.eqj().c(roomToast.mToastContent);
            if (this.pcb == null) {
                aS();
            }
            if (this.pcc != null) {
                this.pcc.setText(roomToast.mToastContent);
            }
            if (!this.pcb.isShowing()) {
                if (this.pbR != null) {
                    this.pcb.showAtLocation(this.pbR, 85, 0, this.pgS.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
                    RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.pcb != null) {
                                a.this.pcb.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.pcb.dismiss();
        }
    }

    private void aS() {
        if (this.pcb == null) {
            View inflate = LayoutInflater.from(this.phh).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.pcc = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.pcb = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 160.0f), -2);
            this.pcb.setFocusable(false);
            this.pcb.setOutsideTouchable(false);
            this.pcb.setAnimationStyle(a.j.gift_toast_style);
            this.pcb.update();
        }
    }

    private void m(View view, int i, int i2) {
        if (this.phH != null && this.phH.isShowing()) {
            this.phH.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
        if (this.pig == null) {
            erV();
        }
        if (!this.pig.isShowing()) {
            this.pig.showAtLocation(view, 83, i, i2);
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.phg.eqU().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.pig.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.pij != null) {
            if (h.isEmpty(this.pik)) {
                if (((VideoPlayer) this.phh).q) {
                    this.pij.cc(this.phg != null ? this.phg.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.pij.cc(this.phg != null ? this.phg.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.phh).q && this.pik.size() == 2 && this.pik.contains("4") && this.pik.contains("2")) {
                this.pij.cc(this.phg != null ? this.phg.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.pik.size() > 1 || !((VideoPlayer) this.phh).q) {
                this.pij.cc(this.phg != null ? this.phg.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.pik.get(0))) {
                this.pij.cc(this.phg != null ? this.phg.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.pik.get(0))) {
                this.pij.cc(this.phg != null ? this.phg.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.pik.get(0))) {
                this.pij.cc(this.phg != null ? this.phg.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
        if (this.phH == null) {
            al();
            this.phH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.phH.isShowing() && this.bB == 2) {
            this.phH.showAtLocation(view, 83, i, this.phh.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.phg.eqU().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.phH.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.pha != null) {
            this.pha.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                g.d(this.phh, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.pdz.getPlayState() == 4) {
                        e(true);
                        if (this.phg.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.phg.a(false);
                        ((VideoPlayer) this.phh).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.pdz.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.pdz.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                g.d(this.phh, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.f4121a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.phg.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.phh).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                    this.ai = false;
                    Av(true);
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
        if (this.phU != null) {
            if (z) {
                this.phU.setVisibility(0);
            }
            this.phU.eDl();
            if (!z) {
                this.phU.setVisibility(8);
            }
        }
        g.d(this.phh, this.phh.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.pbj != null) {
                this.pbj.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4121a != null) {
                this.f4121a.setVisibility(8);
            }
            if (this.phb != null) {
                this.phb.setVisibility(8);
                return;
            }
            return;
        }
        if (this.pbj != null) {
            this.pbj.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4121a != null) {
            if (z2 != (this.f4121a.getVisibility() == 0)) {
                if (z2) {
                    this.f4121a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4121a.setVisibility(0);
                    return;
                }
                this.f4121a.setVisibility(8);
                if (this.phb != null) {
                    this.phb.setVisibility(8);
                }
            }
        }
    }

    private void ers() {
        this.e = false;
        m(true, false, true);
    }

    private void ert() {
        this.e = false;
        m(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.paV[i];
        if (this.bB != i2 || this.bC != i) {
            this.bC = i;
            this.bB = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            erj();
            a(this.phg != null ? this.phg.par.get("1") : null);
            if (i2 == 2) {
                k();
                aK(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.phh, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            aK(false, i3);
            v(false);
            b(false);
            if (this.phH != null && this.phH.isShowing()) {
                this.phH.dismiss();
            }
            if (i2 == 99) {
                if (this.paW != null && this.paW[i] != null && (this.paW[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.paW[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.phh, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.phh, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.phh, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.phh, "房间信息页_num", null, new Object[0]);
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
    protected void eru() {
        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.phi != null) {
            if (this.pbv != null && this.pbv.getVisibility() == 0) {
                u(false);
            }
            if (this.phb != null && this.phb.getVisibility() == 0) {
                this.f = true;
            }
            aJ(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.paY != null) {
            this.paY.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.paY != null) {
            this.paY.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.paY != null) {
            this.paY.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.paY != null) {
            this.paY.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.pbR != null) {
            int size = iconConfig.configs.size();
            this.pbR.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.phh).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.pbR, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.cc(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.cc(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                        frescoThumbnailView.cc(str, a.e.ic_gift_btn_n);
                    } else {
                        frescoThumbnailView.cc(str, a.e.ic_default_video_bottom);
                    }
                } else {
                    frescoThumbnailView.cc(str, a.e.ic_default_video_bottom);
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
                    public void dX(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.pbR.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.phg != null ? this.phg.par : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.paY != null) {
            this.paY.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pbO != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.pbO.DK(a.c.kas_white);
            } else if (this.bB == 2) {
                this.pbO.cc(str, a.c.kas_white);
                if (this.pbP != null) {
                    this.pbP.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.pbO.DK(a.c.kas_white);
                if (this.pbP != null) {
                    this.pbP.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a2 = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a3 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.pbP != null) {
                    this.pbP.setTextColor(a2);
                    this.pbP.setTabTextSelectColor(a3);
                    this.pbP.setIndicatorColor(a3);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pbr != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.pbr.DK(a.e.ic_hotwords_black_n);
            } else {
                this.pbr.cc(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.pbq != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.esi().a(str, this.pbq, a.e.player_skin_input);
            } else {
                this.pbq.setBackgroundResource(a.e.player_skin_input);
            }
            int a2 = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.pbu != null) {
                this.pbu.setTextColor(a2);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void a(int i) {
        if (this.paY != null) {
            this.paY.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void D() {
        if (this.phh instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a eqB = ((VideoPlayer) this.phh).eqB();
            if (this.phY == null) {
                this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.phY.setVisibility(0);
            this.phY.a(2, eqB);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.paY != null) {
            this.paY.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.paY != null) {
            this.paY.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(long j) {
        if (this.paY != null) {
            this.paY.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0982a
    public void c(int i) {
        if (this.paY != null) {
            this.paY.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.paY != null && this.phg != null) {
            this.paY.b(this.phg.pap);
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
    public class C0975a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0975a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.paV.length) {
                return null;
            }
            switch (a.this.paV[i]) {
                case 1:
                    if (a.this.paX == null) {
                        a.this.paX = com.kascend.chushou.view.user.a.a(2, null, a.this.phg.f4117a, false, a.this.phg.h, false);
                    }
                    a.this.paW[i] = a.this.paX;
                    return a.this.paX;
                case 2:
                    if (a.this.paY == null) {
                        a aVar = a.this;
                        if (a.this.paJ != null && a.this.paJ.pdA != null) {
                            z = a.this.paJ.pdA.mInPKMode;
                        }
                        aVar.paY = com.kascend.chushou.player.ui.a.Aw(z);
                    }
                    a.this.paW[i] = a.this.paY;
                    return a.this.paY;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.phg != null && a.this.phg.eqU() != null && !h.isEmpty(a.this.pbW)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.pbW.get(i).url);
                        h5Options.f4231a = a.this.pbW.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a2 = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.paW[i] = a2;
                    return a2;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Qf(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.paV.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int pv(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Qg(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String Qh(int i) {
            return a.this.Qf(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Qi(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Qj(int i) {
            int dimensionPixelSize = a.this.phh.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void HC(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.RH(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.paP <= IMConnection.RETRY_DELAY_TIMES) {
            g.RH(a.i.str_too_fast);
            return false;
        } else {
            erx();
            if (!com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a(((VideoPlayer) this.phh).eqv().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.paP = System.currentTimeMillis();
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                a(this.phg.eqU().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.phg.h);
            }
            g(this.b);
            if (!z && this.pbw != null) {
                this.pbw.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            erx();
            if (com.kascend.chushou.d.e.c(this.phh, null) && LoginManager.Instance().getUserInfo() != null && this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                a(this.phg.eqU().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.pbw != null) {
                this.pbw.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.paY != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.phg.eqU().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.phg.eqU().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.phh).oYE;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.ZW(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.paY.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.paY.a(arrayList, true, true);
        }
    }

    private void erv() {
        if (this.paY != null) {
            this.paY.e();
        }
        if (this.pbU != null && this.pbU.isShown()) {
            this.pbU.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.phh instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.phh;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.phg != null) {
            this.phg.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        erv();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.cx);
        if (this.phh != null) {
            if (this.cx || "10004".equals(((VideoPlayer) this.phh).t)) {
                this.cx = true;
                if (this.phg != null) {
                    this.phg.f = null;
                    if (this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                        this.phg.eqU().mRoominfo.mGameId = null;
                    }
                }
                erm();
                return;
            }
            this.cx = true;
            if (this.phh != null) {
                ((VideoPlayer) this.phh).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.cx = false;
        if (this.pbh != null) {
            this.pbh.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.cx = false;
        if (this.pbh != null) {
            this.pbh.setVisibility(8);
        }
        super.i(z);
    }

    private void erw() {
        erk();
        if (i()) {
            aY();
            ap();
            return;
        }
        erm();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        erS().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.pgT != null) {
            this.pgT.setVisibility(0);
        }
        if (this.phU != null) {
            this.phU.setVisibility(0);
        }
        if (this.paF != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.paF.d();
        }
        if (this.pbp != null) {
            this.pbp.setVisibility(0);
        }
        if (com.kascend.chushou.c.f4077a) {
            this.pbe.setVisibility(0);
            this.pbe.setOnClickListener(this);
        } else {
            this.pbe.setVisibility(8);
        }
        this.pbj.setVisibility(0);
        this.pbf.setVisibility(0);
        this.pgY.setVisibility(0);
        if (this.p) {
            this.pgZ.setVisibility(0);
        } else {
            this.pgZ.setVisibility(8);
        }
        aX();
        aK(true, i());
        this.e = false;
        m(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.phY != null && this.phY.a(i, keyEvent)) {
                return true;
            }
            if (this.pbY != null && this.pbY.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.pbZ != null && this.pbZ.onKeyDown(i, keyEvent)) || ery()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.pcq != null && this.pcq.getVisibility() == 0 && a(motionEvent, this.pcq)) {
                this.pcq.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.eh(this.pcp);
                return true;
            } else if (this.pbS && this.pcq != null && this.pcq.getVisibility() == 8 && f(this.phM.b, motionEvent)) {
                err();
                return true;
            } else if (this.pbY != null && this.pbY.b() && f(this.pbY, motionEvent)) {
                this.pbY.a();
                return true;
            } else if (this.pbZ != null && this.pbZ.b() && f(this.pbZ, motionEvent)) {
                this.pbZ.a();
                return true;
            } else if (a(motionEvent, this.pbv)) {
                return erx();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean erx() {
        boolean z;
        b(this.pca, 10);
        boolean z2 = false;
        if (this.pbK != null && this.pbK.getVisibility() == 0) {
            this.pbK.setVisibility(8);
            this.pbL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
            this.pbL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.pbv == null || this.pbv.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.pbJ) {
                erF();
            }
            this.pbv.setVisibility(8);
            z = true;
        }
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.pbp != null && a.this.bB == 2) {
                        a.this.pbp.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean ery() {
        if (erx()) {
            return true;
        }
        if (this.phH == null || !this.phH.isShowing()) {
            return err() || erq() || eas();
        }
        this.phH.dismiss();
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
        this.pbp.setVisibility(8);
        this.pbv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(boolean z, boolean z2) {
        if (this.pbp != null) {
            if (z) {
                if (this.pbp.getVisibility() != 0) {
                    this.pbp.setVisibility(0);
                    this.pbp.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_bottom_anim));
                }
            } else if (this.pbp.getVisibility() != 4) {
                this.pbp.setVisibility(4);
                this.pbp.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.pbh != null) {
            this.pbh.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a erz() {
        return this.pce;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.phg != null) {
                        this.phg.f = null;
                        this.phg.eqU().mRoominfo.mGameId = null;
                    }
                    erm();
                    return;
                }
                g.RH(a.i.str_getvideosource_failed);
            }
            Av(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.phg != null && this.phg.eqV() != null) {
            a(this.phg.eqV());
        }
        this.p = false;
        if (this.phg == null || this.phg.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.phg.f.size()) {
                if (!"2".equals(this.phg.f.get(i2).mType)) {
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
        if (this.paY != null) {
            this.paY.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!aa()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.pbk != null && this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                this.pbk.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.phg.eqU().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!aa() && !this.pbX && (c = c(1, -1)) >= 0 && c < this.pbW.size() && this.pbQ != null) {
            this.pbQ.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.pbX) {
            if (bVar.f4150a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.phh, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4150a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4150a == 6) {
                D();
            } else if (bVar.f4150a == 4) {
                com.kascend.chushou.player.ui.h5.b.b eqC = ((VideoPlayer) this.phh).eqC();
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(2, eqC);
            } else if (bVar.f4150a == 3) {
                com.kascend.chushou.player.ui.h5.d.a eqD = ((VideoPlayer) this.phh).eqD();
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(2, eqD);
            } else if (bVar.f4150a == 9) {
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.pbK != null) {
            this.pbK.setPanelEnabled(gVar.f4069a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.pbX) {
            if (iVar.f4071a == 53) {
                if (iVar.b instanceof String) {
                    a((String) iVar.b, true);
                }
            } else if (iVar.f4071a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (!aa() && this.phg != null) {
            String str = this.phg.f4117a;
            RoomInfo eqW = this.phg.eqW();
            if (eqW != null && mVar.a(eqW.mCreatorUID, str)) {
                eqW.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.bB == 2) {
            RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.aa()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.pbw != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.pbw);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
            if (this.pbT == null) {
                this.pbT = new f(getActivity());
            }
            this.pbT.a(this.phg.eqU().mRoominfo);
            if (!this.pbT.isShowing()) {
                this.pbT.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.paY != null) {
            this.paY.d();
        }
    }

    private void e(View view) {
        this.pbl = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.pbm = (TextView) view.findViewById(a.f.tv_4g_video);
        this.pbm.setText(new tv.chushou.zues.widget.a.c().Q(this.phh, a.e.videoplayer_4g_video).append("  ").append(this.phh.getString(a.i.videoplayer_4g_video)));
        this.pbn = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.pbn.setText(new tv.chushou.zues.widget.a.c().Q(this.phh, a.e.videoplayer_4g_audio).append("  ").append(this.phh.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.pbl.setVisibility(8);
                    ((VideoPlayer) a.this.phh).c(a.this.pbo);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.pbl.setVisibility(8);
                    ((VideoPlayer) a.this.phh).d(a.this.pbo);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.eqb().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.pbm.setOnClickListener(onClickListener);
        this.pbn.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.phg != null && !h.isEmpty(this.phg.f)) {
            g(this.phg.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.pbo = z;
            this.p = false;
            if (this.phg != null && this.phg.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.phg.f.size()) {
                        break;
                    } else if (!"2".equals(this.phg.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.pbl != null) {
                this.pbl.setVisibility(0);
                this.pbm.setVisibility(0);
                this.pbn.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.pbl != null) {
            this.pbl.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.pci == null) {
                this.pci = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aa()) {
                            a.this.bb();
                        }
                    }
                };
                if (this.phi != null) {
                    this.phi.f(this.pci, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.pci != null && this.phi != null) {
            this.phi.N(this.pci);
            this.pci = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (LoginManager.Instance().islogined() && this.paY != null) {
            com.kascend.chushou.toolkit.a.c.a(this.phh, "显示双击666_num", null, new Object[0]);
            if (this.phg != null) {
                this.phg.b(false);
            }
            d(false);
            this.paY.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.pgS != null) {
            if (this.pbZ == null) {
                this.pbZ = (InteractionView) ((ViewStub) this.pgS.findViewById(a.f.view_interaction)).inflate();
                this.pbZ.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.pbZ.a();
                    }
                });
            }
            if (this.pbZ != null) {
                this.pbZ.b(configDetail);
                this.pbZ.c();
                this.pbZ.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eDX()) {
                g.N(this.phh, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.phh, null) && (this.phh instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.phg != null) {
                com.kascend.chushou.toolkit.a.c.a(this.phh, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.phg != null) {
                com.kascend.chushou.toolkit.a.c.a(this.phh, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.phh, configDetail.mUrl, this.phh.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.phh, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    erA();
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

    private void erA() {
        if (this.pbS) {
            err();
            return;
        }
        if (this.phh.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.phh, "点击送礼_num", "竖屏", new Object[0]);
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.phg.eqU().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.phh != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.paJ == null) {
                this.paJ = new com.kascend.chushou.player.e.a();
            }
            this.paJ.b = str;
            this.paJ.pdA.copy(pkNotifyInfo);
            if (this.paJ.pdA.mAction == 6) {
                this.paJ.pdA.mInPKMode = true;
                this.u = this.paJ.pdA.mPkId;
            } else if (this.paJ.pdA.mAction == 7 || (this.paJ.pdA.mMode == 1 && this.paJ.pdA.mAction == 5)) {
                this.paJ.pdA.mInPKMode = true;
                this.u = this.paJ.pdA.mPkId;
                if (erC() != null) {
                    if (2 == this.bB && this.pcl != null) {
                        this.pcl.setVisibility(0);
                    }
                    erC().b(this.paJ.pdA, false);
                    erC().a(this.paJ.pdA.mMode, "1");
                    if (this.paJ.pdA.mAction == 5 && this.paJ.pdA.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.paJ.pdA.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.paJ.pdA.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.paJ.pdA.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.paJ.pdA.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.paJ.pdA.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        erC().a(this.paJ.pdA);
                        if (this.paJ.pdA.destinyInfo == null || this.paJ.pdA.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        erC().a(parseInt, this.paJ.pdA.mPkUpdateInfo.remainDuration, j, this.paJ.pdA.mMode, i);
                    }
                    if (!h.isEmpty(this.paJ.pdA.mPkUpdateInfo.specialMomentList) && erC() != null) {
                        erC().a(this.paJ.pdA, true);
                    }
                }
                erB();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.Yd(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.paJ.pdA.mInPKMode = false;
                erB();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.Yd(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void erB() {
        if (this.paJ != null && this.paJ.pdA != null) {
            if (this.paJ.pdA.mInPKMode) {
                this.y.setText(this.paJ.pdA.mPkUserNickname);
                this.paL.setVisibility(0);
                if (this.pgX != null) {
                    this.pgX.setEnabled(false);
                }
                if (this.pgZ != null) {
                    this.pgZ.setEnabled(false);
                    return;
                }
                return;
            }
            this.paL.setVisibility(8);
            if (this.pgX != null) {
                this.pgX.setEnabled(true);
            }
            if (this.pgZ != null) {
                this.pgZ.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b erC() {
        if (this.phh == null || this.pgS == null || this.pcl == null) {
            return null;
        }
        if (this.paK == null) {
            if (this.pck == null) {
                this.pck = ((ViewStub) this.pgS.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.paK = new com.kascend.chushou.player.e.b();
            this.paK.a(this.pcl, this.pck, (View) null, this.phh, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.cFC()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.phg != null) {
                        append.append(a.this.phg.eqW().mRoomID);
                    }
                    if (a.this.paJ != null && a.this.paJ.pdA != null) {
                        append.append("&mode=").append(a.this.paJ.pdA.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.phh, append.toString());
                }
            });
        }
        return this.paK;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.pbH != null && this.phg != null && this.phg.paq != null) {
            this.pbH.setText(tv.chushou.zues.utils.b.RG(this.phg.paq.count));
            this.pbH.setVisibility(0);
            if (this.phg.paq.count < 1) {
                erF();
            }
            if (this.pbz != null) {
                this.pbz.setText(this.phg.paq.primaryName);
            }
            if (this.pbA != null) {
                this.pbA.setText(this.phg.paq.desc);
            }
            erD();
        }
    }

    public void erD() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.pbI * h.parseLong(this.phg.paq.point)));
        if (this.pbC != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.phh.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.Q(this.phh, a.e.icon_coin_new);
            cVar.append(this.phh.getString(a.i.str_buy_count_coin2));
            this.pbC.setText(cVar);
        }
    }

    private void erE() {
        if (com.kascend.chushou.d.e.c(this.phh, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.pbI);
        }
    }

    private void v(boolean z) {
        if (this.pgS != null && this.pcl != null) {
            if (z) {
                if (this.paJ != null && this.paJ.pdA != null && this.paJ.pdA.mInPKMode) {
                    this.pcl.setVisibility(0);
                    return;
                }
                return;
            }
            this.pcl.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.pgS != null && this.paO != null) {
            if (z) {
                if (this.E && 2 == this.bB) {
                    this.paO.setVisibility(0);
                    return;
                }
                return;
            }
            this.paO.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.paJ != null && this.paJ.pdA != null && this.paJ.pdA.mInPKMode && this.paL != null) {
                this.paL.setVisibility(0);
            }
        } else if (this.paL != null) {
            this.paL.setVisibility(8);
        }
    }

    private void erF() {
        this.pbJ = false;
        this.pbG.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.phg != null && this.phg.paq != null) {
            if (this.phg.paq.count < 1) {
                this.pbH.setVisibility(8);
            } else {
                this.pbH.setVisibility(0);
                this.pbH.setSelected(false);
                this.pbH.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.pby.setVisibility(8);
        if (this.pbw != null) {
            this.pbw.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        erA();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pbu != null) {
            this.pbu.performClick();
        }
    }

    public boolean erG() {
        return this.bB == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.pcx = true;
        if (this.pgS != null && com.kascend.chushou.b.eqb().d == 0) {
            this.pcg = tv.chushou.zues.utils.systemBar.b.hH(getActivity());
            if (!z) {
                View findViewById = this.pgS.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.pcg = tv.chushou.zues.utils.systemBar.b.hH(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.pcg);
            View findViewById2 = this.pgS.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.pcg);
            findViewById2.requestLayout();
        }
    }
}
