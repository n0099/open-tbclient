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
import android.widget.Toast;
import com.baidu.swan.games.utils.so.SoUtils;
import com.facebook.drawee.drawable.p;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
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
/* loaded from: classes4.dex */
public class a extends d implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnTouchListener {
    private boolean bR;
    private int[] mQS;
    private Fragment[] mQT;
    private ImageView mQY;
    private MarqueeTextView mQZ;
    private TextView mRA;
    private TextView mRB;
    private TextView mRC;
    private TextView mRD;
    private ImageView mRE;
    private TextView mRF;
    private KPSwitchPanelLinearLayout mRI;
    private ImageView mRJ;
    private c mRL;
    private d.a mRM;
    private FrescoThumbnailView mRN;
    private PagerSlidingTabStrip mRO;
    private KasViewPager mRP;
    private LinearLayout mRQ;
    private f mRT;
    private ViewMicPerson mRU;
    public ArrayList<RoomTab> mRW;
    private PopH5Menu mRZ;
    private MarqueeTextView mRa;
    private ImageView mRb;
    private ImageView mRd;
    private ImageButton mRe;
    public String mRf;
    private RecommendView mRg;
    private TextView mRj;
    private RelativeLayout mRk;
    private TextView mRl;
    private TextView mRm;
    private RelativeLayout mRn;
    private View mRo;
    private FrescoThumbnailView mRp;
    private AnimationSet mRq;
    private ImageView mRr;
    private TextView mRs;
    private RelativeLayout mRt;
    private PastedEditText mRu;
    private TextView mRv;
    private LinearLayout mRw;
    private TextView mRx;
    private TextView mRy;
    private TextView mRz;
    private InteractionView mSa;
    private int mSb;
    private PopupWindow mSc;
    private TextView mSd;
    private GiftAnimationLayout mSe;
    private com.kascend.chushou.player.b.a mSf;
    private Runnable mSj;
    private View mSm;
    private LivePKBarUserValue mSn;
    private String mSo;
    private TextView mSq;
    private ImageView mSr;
    private EditText mSs;
    private View mSt;
    private View mSu;
    private View mSv;
    private String mSy;
    private long mQR = 0;
    private com.kascend.chushou.view.user.a mQU = null;
    private com.kascend.chushou.player.ui.a mQV = null;
    private int mQW = -1;
    private int QR = 0;
    private View mQX = null;
    private View mRh = null;
    private ImageButton mRi = null;
    private int mRG = 1;
    private boolean mRH = false;
    private boolean mRK = false;
    private boolean mRR = false;
    private boolean mRS = false;
    private boolean mRV = false;
    private boolean mRX = false;
    private boolean mRY = true;
    private int mSg = 0;
    private int mSh = 0;
    private int mSi = -1;
    private final Rect mSl = new Rect();
    private boolean mSw = false;
    private C0688a mSx = null;
    private boolean da = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRf = getArguments().getString("mCover");
        this.mRY = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXg = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mXg;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dCE()) {
            c(view);
            dBD();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.mRX = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mYb != null) {
            this.mYb.b();
        }
        if (this.mXw != null && (this.mXw instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXw).wd(true);
            ((VideoPlayer) this.mXw).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mRX = true;
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
        this.mRG = 1;
        this.mRH = false;
        U();
        if (this.mXx != null) {
            this.mXx.cp(null);
            this.mXx = null;
        }
        if (this.mRg != null) {
            dCF().removeAllViews();
            this.mRg = null;
        }
        this.c = null;
        this.mQD = null;
        tv.chushou.zues.a.a.cq(this);
        this.mRO = null;
        this.mRP = null;
        this.mQV = null;
        this.mQU = null;
        if (this.mQT != null) {
            for (int i = 0; i < this.mQT.length; i++) {
                this.mQT[i] = null;
            }
        }
        this.mQT = null;
        if (this.mRu != null) {
            this.mRu.addTextChangedListener(null);
            this.mRu.setOnTouchListener(null);
            this.mRu.setOnEditorActionListener(null);
            this.mRu = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mXw, this.mRL);
        if (this.mXw != null && (this.mXw instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXw).dAY();
        }
        this.mRM = null;
        this.mRL = null;
        if (this.mRU != null) {
            this.mRU.b();
            this.mRU = null;
        }
        if (this.mSc != null) {
            this.mSc.dismiss();
        }
        if (this.mSf != null) {
            this.mSf.a();
            this.mSf = null;
            this.mSe = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mSn = (LivePKBarUserValue) this.mXg.findViewById(a.f.live_pk_bar_user);
        this.mXp = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mSw) {
            this.mSw = true;
            if (this.mSu == null) {
                this.mSu = this.mXg.findViewById(a.f.vs_async_view);
                this.mSu = ((ViewStub) this.mSu).inflate();
            }
            if (this.mSv == null) {
                this.mSv = this.mXg.findViewById(a.f.vs_async_notification_view);
                this.mSv = ((ViewStub) this.mSv).inflate();
            }
            this.mQN = (VoiceInteractionView) this.mXg.findViewById(a.f.voiceInteractiveView);
            t();
            dy(this.mXg);
            cWu();
            ((VideoPlayer) this.mXw).q();
            this.mQI = new com.kascend.chushou.player.e.a();
        }
    }

    private void dy(View view) {
        this.mRN = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mRO = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mRP = (KasViewPager) view.findViewById(a.f.vp_main);
        dBE();
        dBF();
        dBK();
        if (this.mXv != null) {
            I();
            a(this.mXv.mQp, this.mXv.mQt);
        }
        this.aNY = 0;
        this.mYg = 0L;
        this.mYc = (RoundProgressBar) this.mXg.findViewById(a.f.roundProgressBar);
        this.mYd = (TextView) this.mXg.findViewById(a.f.tv_paonum);
        this.mYe = (FrescoThumbnailView) this.mXg.findViewById(a.f.iv_paoicon);
        this.mYl = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.mRR = false;
                if (a.this.mQW == 2) {
                    a.this.at(true, a.this.i());
                } else {
                    a.this.dCd();
                }
                a.this.b(a.this.mSb, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.mRR = true;
                if (a.this.mQW == 2) {
                    a.this.at(false, a.this.i());
                } else {
                    a.this.dCd();
                }
                if (a.this.mYb != null) {
                    a.this.mYb.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.he(a.this.mXw).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mXw)) - a.this.mYb.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mXw, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mXw, 54.0f) * 2);
                    if (statusBarHeight < a.this.mSb) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mYf = (PaoGuideView) this.mXg.findViewById(a.f.rlPaoGuideView);
        this.mRU = (ViewMicPerson) this.mXg.findViewById(a.f.rl_mic_person_view);
    }

    private void dBD() {
        this.mTJ = ((VideoPlayer) this.mXw).dAS();
        this.mXv = ((VideoPlayer) this.mXw).dAV();
        dz(this.mXg);
        this.mSg = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw);
        this.mSh = tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        if (com.kascend.chushou.b.dAD().d == 0 && this.mSh > 0) {
            View findViewById = this.mXg.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mSh);
        }
        dBP();
        dBN();
        if (!this.mRY) {
            Q();
        }
        dBL();
        a();
        if (this.c == null) {
            this.mQD = new d.a();
            this.c = new GestureDetector(this.mXw, this.mQD);
        }
        this.mQF = ((VideoPlayer) this.mXw).dAW();
        this.mQF.a(this);
        if (this.mSf != null) {
            this.mSf.a();
            this.mSf = null;
        }
        this.mSe = (GiftAnimationLayout) this.mXg.findViewById(a.f.ll_gift_animation);
        this.mSe.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mXv != null) {
            this.mSf = new com.kascend.chushou.player.b.a(this.mXw.getApplicationContext(), this.mSe);
            this.mSf.a(this.mXv);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mXg.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mXq = (PlayerErrorView) this.mXg.findViewById(a.f.view_net_error_msg);
        this.mXq.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dBI();
        dBV();
        if (this.mXv.dBv() != null) {
            a(this.mXv.dBv());
        }
        FullRoomInfo dBu = this.mXv.dBu();
        if (dBu != null) {
            dBY();
            if (i()) {
                this.ak = false;
                wk(true);
                this.mXx.Oc(8);
            }
            this.mRj.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dBu.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mQX.setVisibility(0);
        this.ak = false;
        wk(true);
        this.mXx.Oc(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mXw).n();
        if (this.mXv != null && !h.isEmpty(this.mXv.mQr)) {
            b(this.mXv.mQr);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dBf;
        dBE();
        k();
        FullRoomInfo dBu = this.mXv.dBu();
        if (dBu != null) {
            if (dBu.mRoominfo != null) {
                this.mRj.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dBu.mRoominfo.mOnlineCount)));
                this.mSo = dBu.mRoominfo.mRoomID;
            }
            dBY();
            if (!h.isEmpty(dBu.mRoomToastList)) {
                Iterator<RoomToast> it = dBu.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dAK().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mXv != null && this.mXv.l()) {
                d(true);
            }
            if (this.mXw != null && (this.mXw instanceof VideoPlayer) && (dBf = ((VideoPlayer) this.mXw).dBf()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dBf.mTK, dBf.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mRQ);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dBE() {
        boolean z = true;
        if (this.mXv == null || this.mXv.dBu() == null || this.mXv.dBu().mRoominfo == null || h.isEmpty(this.mXv.dBu().mRoomTabs)) {
            this.mRV = false;
            this.mQT = new Fragment[2];
            this.mQS = new int[2];
            this.mQS[0] = 2;
            this.mQS[1] = 1;
            return;
        }
        this.mRV = true;
        this.mRW = new ArrayList<>();
        Iterator<RoomTab> it = this.mXv.dBu().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mRW.add(next);
            }
        }
        if (this.mRW.size() >= 2 && this.mQS != null && this.mQS.length >= 2 && this.mRW.get(0).type == this.mQS[0] && this.mRW.get(1).type == this.mQS[1]) {
            z = false;
        }
        this.mQT = new Fragment[this.mRW.size()];
        this.mQS = new int[this.mRW.size()];
        for (int i = 0; i < this.mRW.size(); i++) {
            this.mQS[i] = this.mRW.get(i).type;
        }
        if (z) {
            this.mSx = new C0688a(getChildFragmentManager());
            this.mRP.setAdapter(this.mSx);
        }
    }

    private void dBF() {
        this.mRt = (RelativeLayout) this.mXg.findViewById(a.f.rl_edit_bar);
        this.mRp = (FrescoThumbnailView) this.mXg.findViewById(a.f.btn_hotword);
        this.mRp.xi(a.e.ic_hotwords_black_n);
        this.mRp.setOnClickListener(this);
        this.mRr = (ImageView) this.mXg.findViewById(a.f.iv_task_badge);
        this.mRq = (AnimationSet) AnimationUtils.loadAnimation(this.mXw, a.C0682a.anim_hotword);
        this.mRq.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dAK().c) {
                    a.this.mRp.clearAnimation();
                    a.this.mRp.startAnimation(a.this.mRq);
                }
            }
        });
        if (com.kascend.chushou.d.h.dAK().c) {
            this.mRp.startAnimation(this.mRq);
            this.mRr.setVisibility(0);
        }
        this.mRs = (TextView) this.mXg.findViewById(a.f.tv_bottom_input);
        this.mRs.setOnClickListener(this);
        this.mYv = (FrescoThumbnailView) this.mXg.findViewById(a.f.ll_btn_set);
        this.mYv.setOnClickListener(this);
        this.mRQ = (LinearLayout) this.mXg.findViewById(a.f.ll_bottom_all_button);
        this.mRn = (RelativeLayout) this.mXg.findViewById(a.f.rl_bottom_input);
        this.mRo = this.mXg.findViewById(a.f.ll_bottom_input);
        this.mRn.setVisibility(8);
        this.mRu = (PastedEditText) this.mXg.findViewById(a.f.et_bottom_input);
        this.mRu.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mRv.setEnabled(editable.length() > 0);
            }
        });
        this.mRu.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mRv);
                    return true;
                }
                return true;
            }
        });
        this.mRu.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.mRu);
                }
                return false;
            }
        });
        this.mRJ = (ImageView) this.mXg.findViewById(a.f.iv_btn_emoji);
        this.mRJ.setVisibility(8);
        this.mRv = (TextView) this.mXg.findViewById(a.f.tv_btn_send);
        this.mRv.setOnClickListener(this);
        this.mRI = (KPSwitchPanelLinearLayout) this.mXg.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dAD().d == 0) {
            this.mRI.setUseStatusBar(true);
        }
        this.mRw = (LinearLayout) this.mXg.findViewById(a.f.head_trumpet);
        this.mRw.setVisibility(8);
        this.mRw.setOnClickListener(this);
        this.mRx = (TextView) this.mXg.findViewById(a.f.tv_primary_name);
        this.mRy = (TextView) this.mXg.findViewById(a.f.tv_primary_desc);
        this.mRB = (TextView) this.mXg.findViewById(a.f.tv_cut_count);
        this.mRB.setOnClickListener(this);
        this.mRD = (TextView) this.mXg.findViewById(a.f.tv_head_count);
        this.mRD.setText(this.mRG + "");
        this.mRC = (TextView) this.mXg.findViewById(a.f.tv_plus_count);
        this.mRC.setOnClickListener(this);
        this.mRA = (TextView) this.mXg.findViewById(a.f.tv_buy_count_coin);
        this.mRz = (TextView) this.mXg.findViewById(a.f.tv_buy_head);
        this.mRz.setOnClickListener(this);
        this.mRE = (ImageView) this.mXg.findViewById(a.f.iv_trumpet_select);
        this.mRE.setOnClickListener(this);
        this.mRF = (TextView) this.mXg.findViewById(a.f.tv_trumpet_have_count);
        this.mRH = false;
        this.mRE.setBackgroundResource(a.e.ic_trumpet_n);
        this.mRF.setVisibility(8);
        dBH();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mRI, this.mRJ, this.mRu, new a.InterfaceC0809a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0809a
            public void we(boolean z) {
                if (a.this.mRJ != null) {
                    if (!z) {
                        a.this.mRJ.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dAD().d == 0) {
                        a.this.mRI.setDirectVisibility(0);
                    }
                    a.this.mRJ.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mRM = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wf(boolean z) {
                a.this.mRK = z;
                if (z) {
                    a.this.mRJ.setImageResource(a.e.cs_emoji_normal);
                    a.this.dBG();
                    return;
                }
                if (a.this.mSt != null && a.this.mSt.getVisibility() == 0) {
                    a.this.mSt.setVisibility(8);
                }
                if (a.this.mRR) {
                    a.this.mYb.setVisibility(0);
                }
                if (a.this.mXw != null && (a.this.mXw instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mXw).wd(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mRL = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mRI, this.mRM, ((VideoPlayer) this.mXw).dAZ());
        ((VideoPlayer) this.mXw).g(((VideoPlayer) this.mXw).dAZ());
        this.mSt = this.mXg.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mSq = (TextView) this.mXg.findViewById(a.f.btn_room_search);
        this.mSr = (ImageView) this.mXg.findViewById(a.f.iv_room_emoji_delete);
        this.mSs = (EditText) this.mXg.findViewById(a.f.et_room_emoji_search);
        this.mSs.setImeOptions(3);
        this.mSs.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mSq);
                    return true;
                }
                return false;
            }
        });
        this.mSs.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mSq.setEnabled(editable.length() > 0);
                a.this.mSr.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mYb.setEmojiSearchText(editable.toString());
            }
        });
        this.mSq.setOnClickListener(this);
        this.mSr.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void ar(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mSs);
            this.mSt.setVisibility(0);
            this.mSs.requestFocus();
        } else {
            this.mSt.setVisibility(8);
        }
        if (z2) {
            this.mSs.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBG() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.he(this.mXw).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw)) - tv.chushou.zues.widget.kpswitch.b.d.hp(this.mXw)) - tv.chushou.zues.utils.a.dip2px(this.mXw, 14.0f)) - this.mXw.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mXw, 54.0f) * 2);
        if (statusBarHeight < this.mSb) {
            b(statusBarHeight, 10);
        }
    }

    private void dBH() {
    }

    private void dBI() {
        this.mXx = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.as(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mXg.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mXw.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mXx.L(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mXx.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mXx.L(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mXx);
                            break;
                        case 12:
                            a.this.b(a.this.mXx);
                            break;
                        case 17:
                            a.this.dCH();
                            break;
                        case 18:
                            a.this.cWt();
                            break;
                        case 19:
                            a.this.mXu.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dBJ() {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mRW)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mRW.size()) {
                    if (!h.isEmpty(this.mRW.get(i2).notifyIcon)) {
                        this.mRO.bm(i2, this.mRW.get(i2).notifyIcon);
                        this.mRO.Oz(i2);
                    } else if (this.mRW.get(i2).notify == 1) {
                        this.mRO.Oy(i2);
                        this.mRO.Ox(i2);
                    } else {
                        this.mRO.Ox(i2);
                        this.mRO.Oz(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mRW)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mRW.size()) {
                    if (this.mRW.get(i4).type == i) {
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
    public String MF(int i) {
        if (this.mXv == null || this.mXv.dBu() == null || this.mXv.dBu().mRoominfo == null || h.isEmpty(this.mRW)) {
            if (i == 1) {
                return this.mXw.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mXw.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mRW.size()) {
            return this.mRW.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mRW) && i < this.mRW.size()) {
            this.mRW.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mRW) && i < this.mRW.size()) {
            this.mRW.get(i).notifyIcon = str;
        }
    }

    private void dBK() {
        if (this.mRP != null && this.mRO != null && this.mQS != null) {
            this.mQV = null;
            if (this.mQT != null) {
                for (int i = 0; i < this.mQT.length; i++) {
                    this.mQT[i] = null;
                }
            }
            if (this.mSx == null) {
                this.mSx = new C0688a(getChildFragmentManager());
                this.mRP.setAdapter(this.mSx);
            } else {
                this.mSx.notifyDataSetChanged();
            }
            this.mRP.setOffscreenPageLimit(this.mQS.length);
            this.mRO.c(this.mRP);
            this.mRO.setOnPageChangeListener(this);
            this.mRO.notifyDataSetChanged();
            this.mRO.setVisibility(0);
            this.mRP.setVisibility(0);
            if (!this.mRV) {
                this.mQW = 2;
                this.mRP.setCurrentItem(c(2, 0));
                this.mRn.setVisibility(0);
            } else {
                if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                    if (!h.isEmpty(this.mXv.dBu().mRoominfo.mGameName)) {
                        this.mRa.setText(this.mXv.dBu().mRoominfo.mGameName);
                    } else {
                        this.mRa.setText(this.mXw.getString(a.i.no_online_game_name));
                    }
                    this.mQZ.setText(this.mXv.dBu().mRoominfo.mName);
                } else {
                    this.mRa.setText(this.mXw.getString(a.i.no_online_game_name));
                }
                dBJ();
                if (i()) {
                    dBW();
                    if (this.mRP != null) {
                        this.mQW = 2;
                        int c = c(2, 0);
                        this.mRP.setCurrentItem(c);
                        this.mRO.setSelectItem(c);
                    }
                } else if (this.mRP != null) {
                    this.mQW = 1;
                    int c2 = c(1, 1);
                    this.mRP.setCurrentItem(c2);
                    this.mRO.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dBL() {
        this.N = new SurfaceView(this.mXw);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mXA);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dCF().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dBM() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mXw).s();
        cWA();
        dBQ();
        dBR();
        dCF().setBackgroundResource(a.e.room_not_online);
        if (this.mRg == null) {
            this.mRg = new RecommendView(this.mXw);
            dCF().addView(this.mRg);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mXw);
            this.mRg.setLayoutParams(layoutParams);
        }
        if (this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mXv.dBu().mRoominfo.mRoomID)) {
            this.mRg.a(this.mXv.dBu().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dCE() && a.this.mXw != null && a.this.dCF() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mXw);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lMf);
                        if (a.this.dCF().getChildCount() >= 2) {
                            a.this.dCF().addView(frescoThumbnailView, 0);
                        }
                        a.this.dCF().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dOT(), a.this.ar, a.this.mXA);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYj != null) {
            this.mYj.dOn();
            this.mYj.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mYb != null) {
            this.mYb.e();
        }
        wk(false);
        a(false, false);
        if (this.mQF != null) {
            this.mQF.d();
        }
    }

    private void dBN() {
        int i = 0;
        this.mQX = this.mXg.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dAD().d == 0 && this.mSg > 0) {
            View findViewById = this.mXg.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.mSg;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mQY = (ImageView) this.mQX.findViewById(a.f.back_icon);
        this.mQY.setOnClickListener(this);
        this.mQZ = (MarqueeTextView) this.mQX.findViewById(a.f.tv_title);
        this.mRa = (MarqueeTextView) this.mQX.findViewById(a.f.tv_Type);
        this.mRd = (ImageView) this.mXg.findViewById(a.f.btn_setting);
        this.mRh = this.mXg.findViewById(a.f.bottomview);
        if (this.mXn == null) {
            this.mXn = (ImageButton) this.mRh.findViewById(a.f.btn_barrage);
            this.mXn.setOnClickListener(this);
            if (this.mXv != null) {
                if (com.kascend.chushou.d.h.dAK().n()) {
                    this.mXn.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXn.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mXo = (ImageButton) this.mRh.findViewById(a.f.btn_audio);
        this.mXo.setOnClickListener(this);
        if (this.mXv != null && this.mXv.d) {
            this.mXo.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mXo.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mXv != null && this.mXv.f != null) {
            while (true) {
                if (i >= this.mXv.f.size()) {
                    break;
                } else if (!"2".equals(this.mXv.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mRi = (ImageButton) this.mRh.findViewById(a.f.playbutton);
        this.mRi.setOnTouchListener(this);
        this.mRe = (ImageButton) this.mRh.findViewById(a.f.btn_refresh);
        this.mRe.setOnClickListener(this);
        this.mRj = (TextView) this.mRh.findViewById(a.f.tv_online_count);
        if (this.mXm == null) {
            this.mXm = (ImageButton) this.mRh.findViewById(a.f.btn_screenChange);
            this.mXm.setOnClickListener(this);
        }
        if (this.mRb == null) {
            this.mRb = (ImageView) this.mQX.findViewById(a.f.report_icon);
            this.mRb.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dx(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dCf();
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
        if (!dCE() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mQV != null) {
                        this.mQV.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                        this.mXv.dBu().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mXv.dBu().mMicStatus.onMic) {
                            dBX();
                        }
                        if (this.mXv.dBu().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mXv.dBu().mRoominfo.mCreatorUID)) {
                                i(arrayList2, this.mXv.dBu().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mXv.dBu().mMicStatus.onMic) {
                            this.mXv.dBu().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mXv.dBu().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = j(this.mXv.dBu().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mXv.dBu().mMicStatus != null && !h.isEmpty(this.mXv.dBu().mMicStatus.micRoomId) && !this.mXv.dBu().mMicStatus.micRoomId.equals("0")) {
                                this.mSy = this.mXv.dBu().mMicStatus.micRoomId;
                            }
                            if (this.mQV != null) {
                                this.mQV.a(this.mXv.dBu().mMicStatus, this.mXv.dBu().mFanItems, str, z2);
                            }
                            if (this.mRU != null && this.mRU.getVisibility() == 0) {
                                this.mRU.a(this.mXv.dBu().mFanItems, this.mXv.dBu().mMicStatus, str, z2, this.mXv.dBu().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mQV != null) {
                                this.mQV.e();
                            }
                            if (this.mRU != null && this.mRU.isShown()) {
                                this.mRU.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mQV != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mQV.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mQV.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mSi != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mSi = onlineVip.mCount;
                        MG(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mQI != null && this.mQI.mTK != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mQI.mTK.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mQI.mTK.mInPKMode = true;
                                    this.mQI.mTK.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQI.mTK.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQI.mTK.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQI.mTK.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQI.mTK.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQI.mTK.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mQI.mTK.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mQI.mTK.mMode = pkNotifyInfo.mMode;
                                    this.mQI.mTK.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dCj() != null) {
                                        dCj().g(true, this.mQI.mTK.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dAK().a) {
                                        if (!com.kascend.chushou.b.dAD().e) {
                                            com.kascend.chushou.b.dAD().e = true;
                                            g.M(this.mXw, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dAK().a(this.mXw, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.mQW && this.mSn != null) {
                                        this.mSn.setVisibility(0);
                                    }
                                    this.mQI.mTK.mAction = 7;
                                    this.mQI.mTK.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQI.mTK.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQI.mTK.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQI.mTK.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQI.mTK.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQI.mTK.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dCi();
                                    if (dCj() != null) {
                                        dCj().g(false, 0L);
                                        dCj().b(this.mQI.mTK, true);
                                        dCj().a(this.mQI.mTK.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.QI(this.mSo);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mQI.mTK.mInPKMode = false;
                                    this.mQI.mTK.mAction = 2;
                                    dCi();
                                    if (dCj() != null) {
                                        dCj().c();
                                    }
                                    if (com.kascend.chushou.d.h.dAK().a) {
                                        if (!com.kascend.chushou.b.dAD().e) {
                                            com.kascend.chushou.b.dAD().e = true;
                                            g.M(this.mXw, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dAK().a(this.mXw, false);
                                        ak();
                                    }
                                    this.mQI.b = null;
                                    this.mQI.mTK = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.QI(this.mSo);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mQI.mTK.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mQI.mTK.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mQI.mTK.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mXv.dBu().mRoominfo.mRoomID) && this.mXv.dBu().mRoominfo.mRoomID.equals(this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dCj() != null) {
                                        dCj().a(this.mQI.mTK, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mQI.mTK.copyUpdate(pkNotifyInfo);
                                    if (dCj() != null) {
                                        dCj().a(this.mQI.mTK);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mQI.mTK.copyStop(pkNotifyInfo);
                                        if (dCj() != null) {
                                            dCj().w(this.mQI.mTK.mMaxFreeDuration, this.mQI.mTK.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mQI.mTK.copyResult(pkNotifyInfo);
                                    if (!this.mRX && dCj() != null) {
                                        int i5 = 1;
                                        if (this.mQI.mTK.destinyInfo != null && this.mQI.mTK.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dCj().a(h.parseInt(this.mQI.mTK.mResult), h.parseLong(this.mQI.mTK.mvpUid), this.mQI.mTK.mvpAvatar, this.mQI.mTK.mvpNickname, this.mQI.mTK.mMaxFreeDuration, this.mQI.mTK.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mQV != null) {
                if (LoginManager.Instance().islogined() && this.mXv != null && this.mXv.l()) {
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
                if (this.mXv == null || this.mXv.dBu() == null || this.mXv.dBu().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mXv.dBu().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dAK().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dAK().b().equals(next2.mUserID)) {
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
                this.mQV.a(arrayList, true, false);
                this.mQV.c(arrayList3);
            }
        }
    }

    public void MG(int i) {
        int i2;
        if (this.mQS != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mQS.length) {
                    break;
                }
                if (this.mQS[i2] == 99 && this.mQT != null && this.mQT[i2] != null && (this.mQT[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mQT[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mRW.size() && this.mRO != null) {
                if (i == 0) {
                    this.mRO.setTagText(i2, new StringBuilder(this.mRW.get(i2).name).toString());
                    return;
                } else {
                    this.mRO.setTagText(i2, this.mRW.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
    protected void q(boolean z) {
        if (this.mXn != null) {
            if (z) {
                this.mXn.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXn.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dBO() {
        if (this.mXg == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXg.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point he = tv.chushou.zues.utils.a.he(this.mXw);
        this.ar = Math.min(he.x, he.y);
        this.mXA = (this.ar * this.mXw.getResources().getInteger(a.g.h_thumb_height_def)) / this.mXw.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dCF().getLayoutParams();
        layoutParams.height = this.mXA;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXp.getLayoutParams();
        layoutParams2.height = this.mXA;
        layoutParams2.width = this.ar;
        this.mSb = this.mXA + this.mXw.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mXw, 54.0f);
        b(this.mSb, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mXA);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dBP() {
        Point he = tv.chushou.zues.utils.a.he(this.mXw);
        this.ar = Math.min(he.x, he.y);
        this.mXA = (this.ar * this.mXw.getResources().getInteger(a.g.h_thumb_height_def)) / this.mXw.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dCF().getLayoutParams();
        layoutParams.height = this.mXA;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXp.getLayoutParams();
        layoutParams2.height = this.mXA;
        layoutParams2.width = this.ar;
        this.mSb = this.mXA + this.mXw.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mXw, 54.0f);
        MN(a.e.bg_gift_animation_v);
        b(this.mSb, 10);
        k();
        if (!h.isEmpty(this.mRf)) {
            File ac = tv.chushou.zues.widget.fresco.a.ac(Uri.parse(this.mRf));
            if (ac != null && ac.exists()) {
                this.mXp.setImageURI(Uri.fromFile(ac));
                this.mXp.setVisibility(0);
                return;
            }
            this.mXp.setVisibility(8);
            return;
        }
        this.mXp.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        as(false, false);
        super.c(str, str2);
    }

    private void s(boolean z) {
        if (this.mRb != null) {
            this.mRb.setVisibility(z ? 0 : 4);
        }
        if (this.mRd != null) {
            this.mRd.setVisibility(z ? 0 : 4);
        }
    }

    public boolean as(boolean z, boolean z2) {
        return k(z, z2, this.f);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.mXx != null) {
            this.mXx.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mXw).e(true);
            if (!z3) {
                if (this.mRh.getVisibility() != 0 && z2) {
                    this.mRh.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mXo.setVisibility(0);
                } else {
                    this.mXo.setVisibility(8);
                }
                this.mRh.setVisibility(0);
            }
            if (this.mQX.getVisibility() != 0 && z2) {
                this.mQX.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_top_anim));
            }
            s(!z3);
            this.mQX.setVisibility(0);
            v(true);
            if (this.mXx != null) {
                this.mXx.L(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mXw).e(false);
            if (this.mXN != null) {
                this.mXN.dismiss();
            }
            if (this.mXO != null) {
                this.mXO.dismiss();
            }
            if (this.mRh.getVisibility() != 8 && z2) {
                this.mRh.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_bottom_anim));
            }
            this.mRh.setVisibility(8);
            if (this.mQX.getVisibility() != 8 && z2) {
                this.mQX.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_top_anim));
            }
            this.mQX.setVisibility(8);
            v(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean cWA() {
        if (this.mYf == null || !this.mYf.isShown()) {
            return false;
        }
        this.mYf.d();
        return true;
    }

    public boolean dBQ() {
        if (this.mRU == null || !this.mRU.isShown()) {
            return false;
        }
        this.mRU.a();
        return true;
    }

    public boolean dBR() {
        if (this.mRZ == null || !this.mRZ.b()) {
            return false;
        }
        this.mRZ.a();
        return true;
    }

    public boolean dBS() {
        if (this.mRR && this.mYb != null) {
            if (this.mYb != null) {
                this.mYb.e();
            }
            if (this.mSs != null) {
                this.mSs.setText("");
            }
            if (this.mQW == 2) {
                at(true, i());
                return true;
            }
            dCd();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXg != null) {
            if (this.mRZ == null) {
                this.mRZ = (PopH5Menu) ((ViewStub) this.mXg.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mRZ.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mRZ.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            l(view, 0, this.mQX.getHeight() + this.mQX.getTop());
        } else if (id == a.f.btn_barrage) {
            m(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mXw, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                g.c(this.mXw, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mXv.a(false);
                a(false, false);
                ((VideoPlayer) this.mXw).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.e(this.mXw, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mQI == null || this.mQI.mTK == null || !this.mQI.mTK.mInPKMode) {
                ((VideoPlayer) this.mXw).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mRH) {
                f(this.mRu.getText().toString());
            } else {
                a(this.mRu.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dAK().c) {
                com.kascend.chushou.d.h.dAK().b(false);
                this.mRq.cancel();
                this.mRq.reset();
                this.mRp.clearAnimation();
                this.mRr.setVisibility(8);
            }
            k(view, 0, this.mXg.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.t(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mXw, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            j(view, x, this.mXg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mXv.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mXw, null) && this.mXv != null && this.mXv.mQs != null) {
                if (this.mRH) {
                    dCm();
                    return;
                }
                if (this.mXv != null && this.mXv.mQs != null && this.mXv.mQs.count > 0) {
                    this.mRw.setVisibility(8);
                } else {
                    this.mRw.setVisibility(0);
                }
                this.mRH = true;
                this.mRE.setBackgroundResource(a.e.ic_trumpet_p);
                this.mRF.setVisibility(0);
                this.mRF.setSelected(true);
                this.mRF.setTextColor(Color.parseColor("#ff5959"));
                if (this.mRu != null) {
                    this.mRu.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mRG <= 9) {
                this.mRG++;
                this.mRD.setText(this.mRG + "");
            }
            dCk();
        } else if (id == a.f.tv_cut_count) {
            if (this.mRG > 1) {
                this.mRG--;
                this.mRD.setText(this.mRG + "");
            }
            dCk();
        } else if (id == a.f.tv_buy_head) {
            dCl();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mSs.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mSs.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.mSs);
                this.mYb.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mRu != null && this.mRn != null && this.mRt != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mRu);
                this.mRn.setVisibility(8);
                if (this.mQW == 2) {
                    this.mRt.setVisibility(0);
                }
            }
        } else if (this.mRn != null && this.mRt != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
            if (this.mQW == 2) {
                this.mRn.setVisibility(0);
            }
            this.mRt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dAK().c(roomToast.mToastContent);
            if (this.mSc == null) {
                dBT();
            }
            if (this.mSd != null) {
                this.mSd.setText(roomToast.mToastContent);
            }
            if (!this.mSc.isShowing()) {
                if (this.mRQ != null) {
                    this.mSc.showAtLocation(this.mRQ, 85, 0, this.mXg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
                    RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mSc != null) {
                                a.this.mSc.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mSc.dismiss();
        }
    }

    private void dBT() {
        if (this.mSc == null) {
            View inflate = LayoutInflater.from(this.mXw).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mSd = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mSc = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 160.0f), -2);
            this.mSc.setFocusable(false);
            this.mSc.setOutsideTouchable(false);
            this.mSc.setAnimationStyle(a.j.gift_toast_style);
            this.mSc.update();
        }
    }

    private void j(View view, int i, int i2) {
        if (this.mXV != null && this.mXV.isShowing()) {
            this.mXV.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
        if (this.mYs == null) {
            dCI();
        }
        if (!this.mYs.isShowing()) {
            this.mYs.showAtLocation(view, 83, i, i2);
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mXv.dBu().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mYs.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dBU() {
        if (this.mYv != null) {
            if (h.isEmpty(this.mYw)) {
                if (((VideoPlayer) this.mXw).q) {
                    this.mYv.bV(this.mXv != null ? this.mXv.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mYv.bV(this.mXv != null ? this.mXv.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mXw).q && this.mYw.size() == 2 && this.mYw.contains("4") && this.mYw.contains("2")) {
                this.mYv.bV(this.mXv != null ? this.mXv.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mYw.size() > 1 || !((VideoPlayer) this.mXw).q) {
                this.mYv.bV(this.mXv != null ? this.mXv.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mYw.get(0))) {
                this.mYv.bV(this.mXv != null ? this.mXv.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mYw.get(0))) {
                this.mYv.bV(this.mXv != null ? this.mXv.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mYw.get(0))) {
                this.mYv.bV(this.mXv != null ? this.mXv.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
        if (this.mXV == null) {
            al();
            this.mXV.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mXV.isShowing() && this.mQW == 2) {
            this.mXV.showAtLocation(view, 83, i, this.mXw.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mXv.dBu().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mXV.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mXp != null) {
            this.mXp.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                g.c(this.mXw, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mTJ.getPlayState() == 4) {
                        e(true);
                        if (this.mXv.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mXv.a(false);
                        ((VideoPlayer) this.mXw).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mTJ.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mTJ.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                g.c(this.mXw, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mXv.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mXw).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                    this.ai = false;
                    wk(true);
                    a(false, !this.ak);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mYj != null) {
            if (z) {
                this.mYj.setVisibility(0);
            }
            this.mYj.dOn();
            if (!z) {
                this.mYj.setVisibility(8);
            }
        }
        g.c(this.mXw, this.mXw.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mRi != null) {
                this.mRi.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mXq != null) {
                this.mXq.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mRi != null) {
            this.mRi.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mXq != null) {
                    this.mXq.setVisibility(8);
                }
            }
        }
    }

    private void dBV() {
        this.e = false;
        k(true, false, true);
    }

    private void dBW() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mQS[i];
        if (this.mQW != i2 || this.QR != i) {
            this.QR = i;
            this.mQW = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dBJ();
            a(this.mXv != null ? this.mXv.mQt.get("1") : null);
            if (i2 == 2) {
                k();
                at(true, i3);
                u(true);
                b(true);
                dBZ();
                com.kascend.chushou.toolkit.a.c.a(this.mXw, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            at(false, i3);
            u(false);
            b(false);
            if (this.mXV != null && this.mXV.isShowing()) {
                this.mXV.dismiss();
            }
            if (i2 == 99) {
                if (this.mQT != null && this.mQT[i] != null && (this.mQT[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mQT[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mXw, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mXw, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mXw, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mXw, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.QR = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.mQW == 2) {
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
        ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mXx != null) {
            if (this.mRt != null && this.mRt.getVisibility() == 0) {
                t(false);
            }
            if (this.mXq != null && this.mXq.getVisibility() == 0) {
                this.f = true;
            }
            as(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mQV != null) {
            this.mQV.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mQV != null) {
            this.mQV.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mQV != null) {
            this.mQV.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mQV != null) {
            this.mQV.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mRQ != null) {
            int size = iconConfig.configs.size();
            this.mRQ.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mXw).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mRQ, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bV(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bV(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals("gift")) {
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
                    public void dx(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.mRQ.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mXv != null ? this.mXv.mQt : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mQV != null) {
            this.mQV.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dBU();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRN != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mRN.xi(a.c.kas_white);
            } else if (this.mQW == 2) {
                this.mRN.bV(str, a.c.kas_white);
                if (this.mRO != null) {
                    this.mRO.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mRN.xi(a.c.kas_white);
                if (this.mRO != null) {
                    this.mRO.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mRO != null) {
                    this.mRO.setTextColor(a);
                    this.mRO.setTabTextSelectColor(a2);
                    this.mRO.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRp != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mRp.xi(a.e.ic_hotwords_black_n);
            } else {
                this.mRp.bV(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRo != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dCU().a(str, this.mRo, a.e.player_skin_input);
            } else {
                this.mRo.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mRs != null) {
                this.mRs.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mQV != null) {
            this.mQV.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mXw instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dBa = ((VideoPlayer) this.mXw).dBa();
            if (this.mYm == null) {
                this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYm.setVisibility(0);
            this.mYm.a(2, dBa);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mQV != null) {
            this.mQV.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mQV != null) {
            this.mQV.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mQV != null) {
            this.mQV.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mQV != null) {
            this.mQV.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mQV != null && this.mXv != null) {
            this.mQV.b(this.mXv.mQq);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void c(String str) {
        super.c(str);
        g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0688a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0688a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mQS.length) {
                return null;
            }
            switch (a.this.mQS[i]) {
                case 1:
                    if (a.this.mQU == null) {
                        a.this.mQU = com.kascend.chushou.view.user.a.a(2, null, a.this.mXv.a, false, a.this.mXv.h, false);
                    }
                    a.this.mQT[i] = a.this.mQU;
                    return a.this.mQU;
                case 2:
                    if (a.this.mQV == null) {
                        a aVar = a.this;
                        if (a.this.mQI != null && a.this.mQI.mTK != null) {
                            z = a.this.mQI.mTK.mInPKMode;
                        }
                        aVar.mQV = com.kascend.chushou.player.ui.a.wl(z);
                    }
                    a.this.mQT[i] = a.this.mQV;
                    return a.this.mQV;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mXv != null && a.this.mXv.dBu() != null && !h.isEmpty(a.this.mRW)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mRW.get(i).url);
                        h5Options.a = a.this.mRW.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mQT[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.MF(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.mQS.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int kF(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int MH(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String MI(int i) {
            return a.this.MF(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int MJ(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b MK(int i) {
            int dimensionPixelSize = a.this.mXw.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void AG(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            Toast.makeText(this.mXw, a.i.str_same_content, 0).show();
            return false;
        } else if (System.currentTimeMillis() - this.mQR <= 3000) {
            Toast.makeText(this.mXw, a.i.str_too_fast, 0).show();
            return false;
        } else {
            dCb();
            if (!com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a(((VideoPlayer) this.mXw).dAV().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mQR = System.currentTimeMillis();
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                a(this.mXv.dBu().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mXv.h);
            }
            g(this.b);
            if (!z && this.mRu != null) {
                this.mRu.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dCb();
            if (com.kascend.chushou.d.e.c(this.mXw, null) && LoginManager.Instance().getUserInfo() != null && this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                a(this.mXv.dBu().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mRu != null) {
                this.mRu.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mQV != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mXv.dBu().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mXv.dBu().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mXw).mOE;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.SH(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mQV.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mQV.a(arrayList, true, true);
        }
    }

    private void dBX() {
        if (this.mQV != null) {
            this.mQV.e();
        }
        if (this.mRU != null && this.mRU.isShown()) {
            this.mRU.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void nO() {
        super.nO();
        if (this.mXw instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mXw;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dBX();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mRS);
        if (this.mXw != null) {
            if (this.mRS || "10004".equals(((VideoPlayer) this.mXw).t)) {
                this.mRS = true;
                if (this.mXv != null) {
                    this.mXv.f = null;
                    if (this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                        this.mXv.dBu().mRoominfo.mGameId = null;
                    }
                }
                dBM();
                return;
            }
            this.mRS = true;
            if (this.mXw != null) {
                ((VideoPlayer) this.mXw).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mRS = false;
        if (this.mRg != null) {
            this.mRg.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mRS = false;
        if (this.mRg != null) {
            this.mRg.setVisibility(8);
        }
        super.i(z);
    }

    private void dBY() {
        dBK();
        if (i()) {
            dCa();
            dCG();
            return;
        }
        dBM();
    }

    private void dBZ() {
    }

    private void dCa() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dCF().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mYj != null) {
            this.mYj.setVisibility(0);
        }
        if (this.mQF != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mQF.d();
        }
        if (this.mRn != null) {
            this.mRn.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mRd.setVisibility(0);
            this.mRd.setOnClickListener(this);
        } else {
            this.mRd.setVisibility(8);
        }
        this.mRi.setVisibility(0);
        this.mRe.setVisibility(0);
        this.mXn.setVisibility(0);
        if (this.p) {
            this.mXo.setVisibility(0);
        } else {
            this.mXo.setVisibility(8);
        }
        dBZ();
        at(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mYm != null && this.mYm.a(i, keyEvent)) {
                return true;
            }
            if (this.mRZ != null && this.mRZ.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mSa != null && this.mSa.onKeyDown(i, keyEvent)) || dCc()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mSt != null && this.mSt.getVisibility() == 0 && b(motionEvent, this.mSt)) {
                this.mSt.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.mSs);
                return true;
            } else if (this.mRR && this.mSt != null && this.mSt.getVisibility() == 8 && g(this.mYb.b, motionEvent)) {
                dBS();
                return true;
            } else if (this.mRZ != null && this.mRZ.b() && g(this.mRZ, motionEvent)) {
                this.mRZ.a();
                return true;
            } else if (this.mSa != null && this.mSa.b() && g(this.mSa, motionEvent)) {
                this.mSa.a();
                return true;
            } else if (b(motionEvent, this.mRt)) {
                return dCb();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dCb() {
        boolean z;
        b(this.mSb, 10);
        boolean z2 = false;
        if (this.mRI != null && this.mRI.getVisibility() == 0) {
            this.mRI.setVisibility(8);
            this.mRJ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mRK) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
            this.mRJ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mRt == null || this.mRt.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mRH) {
                dCm();
            }
            this.mRt.setVisibility(8);
            z = true;
        }
        if (this.mQW == 2) {
            RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mRn != null && a.this.mQW == 2) {
                        a.this.mRn.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dCc() {
        if (dCb()) {
            return true;
        }
        if (this.mXV == null || !this.mXV.isShowing()) {
            return dBS() || dBQ() || cWA();
        }
        this.mXV.dismiss();
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
    public void dCd() {
        this.mRn.setVisibility(8);
        this.mRt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(boolean z, boolean z2) {
        if (this.mRn != null) {
            if (z) {
                if (this.mRn.getVisibility() != 0) {
                    this.mRn.setVisibility(0);
                    this.mRn.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_bottom_anim));
                }
            } else if (this.mRn.getVisibility() != 4) {
                this.mRn.setVisibility(4);
                this.mRn.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mRg != null) {
            this.mRg.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dCe() {
        return this.mSf;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dCE()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mXv != null) {
                        this.mXv.f = null;
                        this.mXv.dBu().mRoominfo.mGameId = null;
                    }
                    dBM();
                    return;
                }
                Toast.makeText(this.mXw, a.i.str_getvideosource_failed, 0).show();
            }
            wk(false);
            n(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mXv != null && this.mXv.dBv() != null) {
            a(this.mXv.dBv());
        }
        this.p = false;
        if (this.mXv == null || this.mXv.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mXv.f.size()) {
                if (!"2".equals(this.mXv.f.get(i2).mType)) {
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
        if (this.mQV != null) {
            this.mQV.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dCE()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mRj != null && this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                this.mRj.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mXv.dBu().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dCE() && !this.mRX && (c = c(1, -1)) >= 0 && c < this.mRW.size() && this.mRP != null) {
            this.mRP.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dCE() && !this.mRX) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mXw, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dBb = ((VideoPlayer) this.mXw).dBb();
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(2, dBb);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dBc = ((VideoPlayer) this.mXw).dBc();
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(2, dBc);
            } else if (bVar.a == 9) {
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mRI != null) {
            this.mRI.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dCE() && !this.mRX) {
            if (iVar.a == 53) {
                if (iVar.b instanceof String) {
                    a((String) iVar.b, true);
                }
            } else if (iVar.a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.mQW == 2) {
            RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dCE()) {
                        a.this.t(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mRu != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mRu);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCf() {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
            if (this.mRT == null) {
                this.mRT = new f(getActivity());
            }
            this.mRT.a(this.mXv.dBu().mRoominfo);
            if (!this.mRT.isShowing()) {
                this.mRT.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mQV != null) {
            this.mQV.d();
        }
    }

    private void dz(View view) {
        this.mRk = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mRl = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mRl.setText(new tv.chushou.zues.widget.a.c().O(this.mXw, a.e.videoplayer_4g_video).append("  ").append(this.mXw.getString(a.i.videoplayer_4g_video)));
        this.mRm = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mRm.setText(new tv.chushou.zues.widget.a.c().O(this.mXw, a.e.videoplayer_4g_audio).append("  ").append(this.mXw.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mRk.setVisibility(8);
                    ((VideoPlayer) a.this.mXw).b(a.this.bR);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mRk.setVisibility(8);
                    ((VideoPlayer) a.this.mXw).c(a.this.bR);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dAD().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mRl.setOnClickListener(onClickListener);
        this.mRm.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mXv != null && !h.isEmpty(this.mXv.f)) {
            f(this.mXv.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.bR = z;
            this.p = false;
            if (this.mXv != null && this.mXv.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mXv.f.size()) {
                        break;
                    } else if (!"2".equals(this.mXv.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mRk != null) {
                this.mRk.setVisibility(0);
                this.mRl.setVisibility(0);
                this.mRm.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mRk != null) {
            this.mRk.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mSj == null) {
                this.mSj = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dCE()) {
                            a.this.dCg();
                        }
                    }
                };
                if (this.mXx != null) {
                    this.mXx.d(this.mSj, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mSj != null && this.mXx != null) {
            this.mXx.removeCallbacks(this.mSj);
            this.mSj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCg() {
        if (LoginManager.Instance().islogined() && this.mQV != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mXw, "显示双击666_num", null, new Object[0]);
            if (this.mXv != null) {
                this.mXv.b(false);
            }
            d(false);
            this.mQV.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXg != null) {
            if (this.mSa == null) {
                this.mSa = (InteractionView) ((ViewStub) this.mXg.findViewById(a.f.view_interaction)).inflate();
                this.mSa.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mSa.a();
                    }
                });
            }
            if (this.mSa != null) {
                this.mSa.b(configDetail);
                this.mSa.c();
                this.mSa.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dOY()) {
                g.M(this.mXw, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mXw, null) && (this.mXw instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXv != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXw, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXv != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXw, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mXw, configDetail.mUrl, this.mXw.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
            if (com.kascend.chushou.d.e.c(this.mXw, null)) {
                if (!configDetail.mTargetKey.equals("pay")) {
                    if (configDetail.mTargetKey.equals("gift")) {
                        dCh();
                        return;
                    } else if (configDetail.mTargetKey.equals("interaction")) {
                        a(configDetail);
                        return;
                    } else {
                        Toast.makeText(this.mXw, a.i.str_getnewversion, 0).show();
                        return;
                    }
                }
                b(com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "34"));
            }
        } else {
            Toast.makeText(this.mXw, a.i.str_getnewversion, 0).show();
        }
    }

    private void dCh() {
        if (this.mRR) {
            dBS();
            return;
        }
        if (this.mXw.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXv.dBu().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mXw != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mQI == null) {
                this.mQI = new com.kascend.chushou.player.e.a();
            }
            this.mQI.b = str;
            this.mQI.mTK.copy(pkNotifyInfo);
            if (this.mQI.mTK.mAction == 6) {
                this.mQI.mTK.mInPKMode = true;
                this.u = this.mQI.mTK.mPkId;
            } else if (this.mQI.mTK.mAction == 7 || (this.mQI.mTK.mMode == 1 && this.mQI.mTK.mAction == 5)) {
                this.mQI.mTK.mInPKMode = true;
                this.u = this.mQI.mTK.mPkId;
                if (dCj() != null) {
                    if (2 == this.mQW && this.mSn != null) {
                        this.mSn.setVisibility(0);
                    }
                    dCj().b(this.mQI.mTK, false);
                    dCj().a(this.mQI.mTK.mMode, "1");
                    if (this.mQI.mTK.mAction == 5 && this.mQI.mTK.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mQI.mTK.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mQI.mTK.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mQI.mTK.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mQI.mTK.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mQI.mTK.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dCj().a(this.mQI.mTK);
                        if (this.mQI.mTK.destinyInfo == null || this.mQI.mTK.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dCj().a(parseInt, this.mQI.mTK.mPkUpdateInfo.remainDuration, j, this.mQI.mTK.mMode, i);
                    }
                    if (!h.isEmpty(this.mQI.mTK.mPkUpdateInfo.specialMomentList) && dCj() != null) {
                        dCj().a(this.mQI.mTK, true);
                    }
                }
                dCi();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.QI(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mQI.mTK.mInPKMode = false;
                dCi();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.QI(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dCi() {
        if (this.mQI != null && this.mQI.mTK != null) {
            if (this.mQI.mTK.mInPKMode) {
                this.y.setText(this.mQI.mTK.mPkUserNickname);
                this.mQK.setVisibility(0);
                if (this.mXm != null) {
                    this.mXm.setEnabled(false);
                }
                if (this.mXo != null) {
                    this.mXo.setEnabled(false);
                    return;
                }
                return;
            }
            this.mQK.setVisibility(8);
            if (this.mXm != null) {
                this.mXm.setEnabled(true);
            }
            if (this.mXo != null) {
                this.mXo.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dCj() {
        if (this.mXw == null || this.mXg == null || this.mSn == null) {
            return null;
        }
        if (this.mQJ == null) {
            if (this.mSm == null) {
                this.mSm = ((ViewStub) this.mXg.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mQJ = new com.kascend.chushou.player.e.b();
            this.mQJ.a(this.mSn, this.mSm, (View) null, this.mXw, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dOH()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mXv != null) {
                        append.append(a.this.mXv.dBw().mRoomID);
                    }
                    if (a.this.mQI != null && a.this.mQI.mTK != null) {
                        append.append("&mode=").append(a.this.mQI.mTK.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mXw, append.toString());
                }
            });
        }
        return this.mQJ;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mRF != null && this.mXv != null && this.mXv.mQs != null) {
            this.mRF.setText(tv.chushou.zues.utils.b.Oi(this.mXv.mQs.count));
            this.mRF.setVisibility(0);
            if (this.mXv.mQs.count < 1) {
                dCm();
            }
            if (this.mRx != null) {
                this.mRx.setText(this.mXv.mQs.primaryName);
            }
            if (this.mRy != null) {
                this.mRy.setText(this.mXv.mQs.desc);
            }
            dCk();
        }
    }

    public void dCk() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mRG * h.parseLong(this.mXv.mQs.point)));
        if (this.mRA != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mXw.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mXw, a.e.icon_coin_new);
            cVar.append(this.mXw.getString(a.i.str_buy_count_coin2));
            this.mRA.setText(cVar);
        }
    }

    private void dCl() {
        if (com.kascend.chushou.d.e.c(this.mXw, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mRG);
        }
    }

    private void u(boolean z) {
        if (this.mXg != null && this.mSn != null) {
            if (z) {
                if (this.mQI != null && this.mQI.mTK != null && this.mQI.mTK.mInPKMode) {
                    this.mSn.setVisibility(0);
                    return;
                }
                return;
            }
            this.mSn.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mXg != null && this.mQN != null) {
            if (z) {
                if (this.E && 2 == this.mQW) {
                    this.mQN.setVisibility(0);
                    return;
                }
                return;
            }
            this.mQN.setVisibility(8);
        }
    }

    private void v(boolean z) {
        if (z) {
            if (this.mQI != null && this.mQI.mTK != null && this.mQI.mTK.mInPKMode && this.mQK != null) {
                this.mQK.setVisibility(0);
            }
        } else if (this.mQK != null) {
            this.mQK.setVisibility(8);
        }
    }

    private void dCm() {
        this.mRH = false;
        this.mRE.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mXv != null && this.mXv.mQs != null) {
            if (this.mXv.mQs.count < 1) {
                this.mRF.setVisibility(8);
            } else {
                this.mRF.setVisibility(0);
                this.mRF.setSelected(false);
                this.mRF.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mRw.setVisibility(8);
        if (this.mRu != null) {
            this.mRu.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dCh();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mRs != null) {
            this.mRs.performClick();
        }
    }

    public boolean dCn() {
        return this.mQW == 2;
    }
}
