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
    private int[] mQX;
    private Fragment[] mQY;
    private TextView mRA;
    private LinearLayout mRB;
    private TextView mRC;
    private TextView mRD;
    private TextView mRE;
    private TextView mRF;
    private TextView mRG;
    private TextView mRH;
    private TextView mRI;
    private ImageView mRJ;
    private TextView mRK;
    private KPSwitchPanelLinearLayout mRN;
    private ImageView mRO;
    private c mRQ;
    private d.a mRR;
    private FrescoThumbnailView mRS;
    private PagerSlidingTabStrip mRT;
    private KasViewPager mRU;
    private LinearLayout mRV;
    private f mRY;
    private ViewMicPerson mRZ;
    private ImageView mRe;
    private MarqueeTextView mRf;
    private MarqueeTextView mRg;
    private ImageView mRh;
    private ImageView mRi;
    private ImageButton mRj;
    public String mRk;
    private RecommendView mRl;
    private TextView mRo;
    private RelativeLayout mRp;
    private TextView mRq;
    private TextView mRr;
    private RelativeLayout mRs;
    private View mRt;
    private FrescoThumbnailView mRu;
    private AnimationSet mRv;
    private ImageView mRw;
    private TextView mRx;
    private RelativeLayout mRy;
    private PastedEditText mRz;
    private View mSA;
    private String mSE;
    public ArrayList<RoomTab> mSb;
    private PopH5Menu mSe;
    private InteractionView mSf;
    private int mSg;
    private PopupWindow mSh;
    private TextView mSi;
    private GiftAnimationLayout mSj;
    private com.kascend.chushou.player.b.a mSl;
    private Runnable mSq;
    private View mSs;
    private LivePKBarUserValue mSt;
    private String mSu;
    private TextView mSv;
    private ImageView mSw;
    private EditText mSx;
    private View mSy;
    private View mSz;
    private long mQW = 0;
    private com.kascend.chushou.view.user.a mQZ = null;
    private com.kascend.chushou.player.ui.a mRa = null;
    private int mRb = -1;
    private int QR = 0;
    private View mRd = null;
    private View mRm = null;
    private ImageButton mRn = null;
    private int mRL = 1;
    private boolean mRM = false;
    private boolean mRP = false;
    private boolean mRW = false;
    private boolean mRX = false;
    private boolean mSa = false;
    private boolean mSc = false;
    private boolean mSd = true;
    private int mSm = 0;
    private int mSn = 0;
    private int mSo = -1;
    private final Rect mSr = new Rect();
    private boolean mSB = false;
    private C0688a mSD = null;
    private boolean da = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRk = getArguments().getString("mCover");
        this.mSd = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXl = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mXl;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dCG()) {
            c(view);
            dBF();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.mSc = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mYg != null) {
            this.mYg.b();
        }
        if (this.mXB != null && (this.mXB instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXB).wd(true);
            ((VideoPlayer) this.mXB).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSc = true;
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
        this.mRL = 1;
        this.mRM = false;
        U();
        if (this.mXC != null) {
            this.mXC.cp(null);
            this.mXC = null;
        }
        if (this.mRl != null) {
            dCH().removeAllViews();
            this.mRl = null;
        }
        this.c = null;
        this.mQI = null;
        tv.chushou.zues.a.a.cq(this);
        this.mRT = null;
        this.mRU = null;
        this.mRa = null;
        this.mQZ = null;
        if (this.mQY != null) {
            for (int i = 0; i < this.mQY.length; i++) {
                this.mQY[i] = null;
            }
        }
        this.mQY = null;
        if (this.mRz != null) {
            this.mRz.addTextChangedListener(null);
            this.mRz.setOnTouchListener(null);
            this.mRz.setOnEditorActionListener(null);
            this.mRz = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mXB, this.mRQ);
        if (this.mXB != null && (this.mXB instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXB).dBa();
        }
        this.mRR = null;
        this.mRQ = null;
        if (this.mRZ != null) {
            this.mRZ.b();
            this.mRZ = null;
        }
        if (this.mSh != null) {
            this.mSh.dismiss();
        }
        if (this.mSl != null) {
            this.mSl.a();
            this.mSl = null;
            this.mSj = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mSt = (LivePKBarUserValue) this.mXl.findViewById(a.f.live_pk_bar_user);
        this.mXu = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mSB) {
            this.mSB = true;
            if (this.mSz == null) {
                this.mSz = this.mXl.findViewById(a.f.vs_async_view);
                this.mSz = ((ViewStub) this.mSz).inflate();
            }
            if (this.mSA == null) {
                this.mSA = this.mXl.findViewById(a.f.vs_async_notification_view);
                this.mSA = ((ViewStub) this.mSA).inflate();
            }
            this.mQS = (VoiceInteractionView) this.mXl.findViewById(a.f.voiceInteractiveView);
            t();
            dy(this.mXl);
            cWw();
            ((VideoPlayer) this.mXB).q();
            this.mQN = new com.kascend.chushou.player.e.a();
        }
    }

    private void dy(View view) {
        this.mRS = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mRT = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mRU = (KasViewPager) view.findViewById(a.f.vp_main);
        dBG();
        dBH();
        dBM();
        if (this.mXA != null) {
            I();
            a(this.mXA.mQu, this.mXA.mQy);
        }
        this.aNY = 0;
        this.mYl = 0L;
        this.mYh = (RoundProgressBar) this.mXl.findViewById(a.f.roundProgressBar);
        this.mYi = (TextView) this.mXl.findViewById(a.f.tv_paonum);
        this.mYj = (FrescoThumbnailView) this.mXl.findViewById(a.f.iv_paoicon);
        this.mYq = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.mRW = false;
                if (a.this.mRb == 2) {
                    a.this.at(true, a.this.i());
                } else {
                    a.this.dCf();
                }
                a.this.b(a.this.mSg, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.mRW = true;
                if (a.this.mRb == 2) {
                    a.this.at(false, a.this.i());
                } else {
                    a.this.dCf();
                }
                if (a.this.mYg != null) {
                    a.this.mYg.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.he(a.this.mXB).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mXB)) - a.this.mYg.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mXB, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mXB, 54.0f) * 2);
                    if (statusBarHeight < a.this.mSg) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mYk = (PaoGuideView) this.mXl.findViewById(a.f.rlPaoGuideView);
        this.mRZ = (ViewMicPerson) this.mXl.findViewById(a.f.rl_mic_person_view);
    }

    private void dBF() {
        this.mTO = ((VideoPlayer) this.mXB).dAU();
        this.mXA = ((VideoPlayer) this.mXB).dAX();
        dz(this.mXl);
        this.mSm = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB);
        this.mSn = tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        if (com.kascend.chushou.b.dAF().d == 0 && this.mSn > 0) {
            View findViewById = this.mXl.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mSn);
        }
        dBR();
        dBP();
        if (!this.mSd) {
            Q();
        }
        dBN();
        a();
        if (this.c == null) {
            this.mQI = new d.a();
            this.c = new GestureDetector(this.mXB, this.mQI);
        }
        this.mQK = ((VideoPlayer) this.mXB).dAY();
        this.mQK.a(this);
        if (this.mSl != null) {
            this.mSl.a();
            this.mSl = null;
        }
        this.mSj = (GiftAnimationLayout) this.mXl.findViewById(a.f.ll_gift_animation);
        this.mSj.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mXA != null) {
            this.mSl = new com.kascend.chushou.player.b.a(this.mXB.getApplicationContext(), this.mSj);
            this.mSl.a(this.mXA);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mXl.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mXv = (PlayerErrorView) this.mXl.findViewById(a.f.view_net_error_msg);
        this.mXv.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dBK();
        dBX();
        if (this.mXA.dBx() != null) {
            a(this.mXA.dBx());
        }
        FullRoomInfo dBw = this.mXA.dBw();
        if (dBw != null) {
            dCa();
            if (i()) {
                this.ak = false;
                wk(true);
                this.mXC.Oc(8);
            }
            this.mRo.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dBw.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mRd.setVisibility(0);
        this.ak = false;
        wk(true);
        this.mXC.Oc(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mXB).n();
        if (this.mXA != null && !h.isEmpty(this.mXA.mQw)) {
            b(this.mXA.mQw);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dBh;
        dBG();
        k();
        FullRoomInfo dBw = this.mXA.dBw();
        if (dBw != null) {
            if (dBw.mRoominfo != null) {
                this.mRo.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dBw.mRoominfo.mOnlineCount)));
                this.mSu = dBw.mRoominfo.mRoomID;
            }
            dCa();
            if (!h.isEmpty(dBw.mRoomToastList)) {
                Iterator<RoomToast> it = dBw.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dAM().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mXA != null && this.mXA.l()) {
                d(true);
            }
            if (this.mXB != null && (this.mXB instanceof VideoPlayer) && (dBh = ((VideoPlayer) this.mXB).dBh()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dBh.mTP, dBh.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mRV);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dBG() {
        boolean z = true;
        if (this.mXA == null || this.mXA.dBw() == null || this.mXA.dBw().mRoominfo == null || h.isEmpty(this.mXA.dBw().mRoomTabs)) {
            this.mSa = false;
            this.mQY = new Fragment[2];
            this.mQX = new int[2];
            this.mQX[0] = 2;
            this.mQX[1] = 1;
            return;
        }
        this.mSa = true;
        this.mSb = new ArrayList<>();
        Iterator<RoomTab> it = this.mXA.dBw().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mSb.add(next);
            }
        }
        if (this.mSb.size() >= 2 && this.mQX != null && this.mQX.length >= 2 && this.mSb.get(0).type == this.mQX[0] && this.mSb.get(1).type == this.mQX[1]) {
            z = false;
        }
        this.mQY = new Fragment[this.mSb.size()];
        this.mQX = new int[this.mSb.size()];
        for (int i = 0; i < this.mSb.size(); i++) {
            this.mQX[i] = this.mSb.get(i).type;
        }
        if (z) {
            this.mSD = new C0688a(getChildFragmentManager());
            this.mRU.setAdapter(this.mSD);
        }
    }

    private void dBH() {
        this.mRy = (RelativeLayout) this.mXl.findViewById(a.f.rl_edit_bar);
        this.mRu = (FrescoThumbnailView) this.mXl.findViewById(a.f.btn_hotword);
        this.mRu.xi(a.e.ic_hotwords_black_n);
        this.mRu.setOnClickListener(this);
        this.mRw = (ImageView) this.mXl.findViewById(a.f.iv_task_badge);
        this.mRv = (AnimationSet) AnimationUtils.loadAnimation(this.mXB, a.C0682a.anim_hotword);
        this.mRv.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dAM().c) {
                    a.this.mRu.clearAnimation();
                    a.this.mRu.startAnimation(a.this.mRv);
                }
            }
        });
        if (com.kascend.chushou.d.h.dAM().c) {
            this.mRu.startAnimation(this.mRv);
            this.mRw.setVisibility(0);
        }
        this.mRx = (TextView) this.mXl.findViewById(a.f.tv_bottom_input);
        this.mRx.setOnClickListener(this);
        this.mYA = (FrescoThumbnailView) this.mXl.findViewById(a.f.ll_btn_set);
        this.mYA.setOnClickListener(this);
        this.mRV = (LinearLayout) this.mXl.findViewById(a.f.ll_bottom_all_button);
        this.mRs = (RelativeLayout) this.mXl.findViewById(a.f.rl_bottom_input);
        this.mRt = this.mXl.findViewById(a.f.ll_bottom_input);
        this.mRs.setVisibility(8);
        this.mRz = (PastedEditText) this.mXl.findViewById(a.f.et_bottom_input);
        this.mRz.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mRA.setEnabled(editable.length() > 0);
            }
        });
        this.mRz.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mRA);
                    return true;
                }
                return true;
            }
        });
        this.mRz.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.o(a.this.mRz);
                }
                return false;
            }
        });
        this.mRO = (ImageView) this.mXl.findViewById(a.f.iv_btn_emoji);
        this.mRO.setVisibility(8);
        this.mRA = (TextView) this.mXl.findViewById(a.f.tv_btn_send);
        this.mRA.setOnClickListener(this);
        this.mRN = (KPSwitchPanelLinearLayout) this.mXl.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dAF().d == 0) {
            this.mRN.setUseStatusBar(true);
        }
        this.mRB = (LinearLayout) this.mXl.findViewById(a.f.head_trumpet);
        this.mRB.setVisibility(8);
        this.mRB.setOnClickListener(this);
        this.mRC = (TextView) this.mXl.findViewById(a.f.tv_primary_name);
        this.mRD = (TextView) this.mXl.findViewById(a.f.tv_primary_desc);
        this.mRG = (TextView) this.mXl.findViewById(a.f.tv_cut_count);
        this.mRG.setOnClickListener(this);
        this.mRI = (TextView) this.mXl.findViewById(a.f.tv_head_count);
        this.mRI.setText(this.mRL + "");
        this.mRH = (TextView) this.mXl.findViewById(a.f.tv_plus_count);
        this.mRH.setOnClickListener(this);
        this.mRF = (TextView) this.mXl.findViewById(a.f.tv_buy_count_coin);
        this.mRE = (TextView) this.mXl.findViewById(a.f.tv_buy_head);
        this.mRE.setOnClickListener(this);
        this.mRJ = (ImageView) this.mXl.findViewById(a.f.iv_trumpet_select);
        this.mRJ.setOnClickListener(this);
        this.mRK = (TextView) this.mXl.findViewById(a.f.tv_trumpet_have_count);
        this.mRM = false;
        this.mRJ.setBackgroundResource(a.e.ic_trumpet_n);
        this.mRK.setVisibility(8);
        dBJ();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mRN, this.mRO, this.mRz, new a.InterfaceC0809a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0809a
            public void we(boolean z) {
                if (a.this.mRO != null) {
                    if (!z) {
                        a.this.mRO.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dAF().d == 0) {
                        a.this.mRN.setDirectVisibility(0);
                    }
                    a.this.mRO.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mRR = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wf(boolean z) {
                a.this.mRP = z;
                if (z) {
                    a.this.mRO.setImageResource(a.e.cs_emoji_normal);
                    a.this.dBI();
                    return;
                }
                if (a.this.mSy != null && a.this.mSy.getVisibility() == 0) {
                    a.this.mSy.setVisibility(8);
                }
                if (a.this.mRW) {
                    a.this.mYg.setVisibility(0);
                }
                if (a.this.mXB != null && (a.this.mXB instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mXB).wd(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mRQ = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mRN, this.mRR, ((VideoPlayer) this.mXB).dBb());
        ((VideoPlayer) this.mXB).g(((VideoPlayer) this.mXB).dBb());
        this.mSy = this.mXl.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mSv = (TextView) this.mXl.findViewById(a.f.btn_room_search);
        this.mSw = (ImageView) this.mXl.findViewById(a.f.iv_room_emoji_delete);
        this.mSx = (EditText) this.mXl.findViewById(a.f.et_room_emoji_search);
        this.mSx.setImeOptions(3);
        this.mSx.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mSv);
                    return true;
                }
                return false;
            }
        });
        this.mSx.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mSv.setEnabled(editable.length() > 0);
                a.this.mSw.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mYg.setEmojiSearchText(editable.toString());
            }
        });
        this.mSv.setOnClickListener(this);
        this.mSw.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void ar(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mSx);
            this.mSy.setVisibility(0);
            this.mSx.requestFocus();
        } else {
            this.mSy.setVisibility(8);
        }
        if (z2) {
            this.mSx.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBI() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.he(this.mXB).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB)) - tv.chushou.zues.widget.kpswitch.b.d.hp(this.mXB)) - tv.chushou.zues.utils.a.dip2px(this.mXB, 14.0f)) - this.mXB.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mXB, 54.0f) * 2);
        if (statusBarHeight < this.mSg) {
            b(statusBarHeight, 10);
        }
    }

    private void dBJ() {
    }

    private void dBK() {
        this.mXC = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.as(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mXl.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mXB.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mXC.L(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mXC.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mXC.L(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mXC);
                            break;
                        case 12:
                            a.this.b(a.this.mXC);
                            break;
                        case 17:
                            a.this.dCJ();
                            break;
                        case 18:
                            a.this.cWv();
                            break;
                        case 19:
                            a.this.mXz.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void dBL() {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mSb)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mSb.size()) {
                    if (!h.isEmpty(this.mSb.get(i2).notifyIcon)) {
                        this.mRT.bm(i2, this.mSb.get(i2).notifyIcon);
                        this.mRT.Oz(i2);
                    } else if (this.mSb.get(i2).notify == 1) {
                        this.mRT.Oy(i2);
                        this.mRT.Ox(i2);
                    } else {
                        this.mRT.Ox(i2);
                        this.mRT.Oz(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mSb)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mSb.size()) {
                    if (this.mSb.get(i4).type == i) {
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
        if (this.mXA == null || this.mXA.dBw() == null || this.mXA.dBw().mRoominfo == null || h.isEmpty(this.mSb)) {
            if (i == 1) {
                return this.mXB.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mXB.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mSb.size()) {
            return this.mSb.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mSb) && i < this.mSb.size()) {
            this.mSb.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mSb) && i < this.mSb.size()) {
            this.mSb.get(i).notifyIcon = str;
        }
    }

    private void dBM() {
        if (this.mRU != null && this.mRT != null && this.mQX != null) {
            this.mRa = null;
            if (this.mQY != null) {
                for (int i = 0; i < this.mQY.length; i++) {
                    this.mQY[i] = null;
                }
            }
            if (this.mSD == null) {
                this.mSD = new C0688a(getChildFragmentManager());
                this.mRU.setAdapter(this.mSD);
            } else {
                this.mSD.notifyDataSetChanged();
            }
            this.mRU.setOffscreenPageLimit(this.mQX.length);
            this.mRT.c(this.mRU);
            this.mRT.setOnPageChangeListener(this);
            this.mRT.notifyDataSetChanged();
            this.mRT.setVisibility(0);
            this.mRU.setVisibility(0);
            if (!this.mSa) {
                this.mRb = 2;
                this.mRU.setCurrentItem(c(2, 0));
                this.mRs.setVisibility(0);
            } else {
                if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                    if (!h.isEmpty(this.mXA.dBw().mRoominfo.mGameName)) {
                        this.mRg.setText(this.mXA.dBw().mRoominfo.mGameName);
                    } else {
                        this.mRg.setText(this.mXB.getString(a.i.no_online_game_name));
                    }
                    this.mRf.setText(this.mXA.dBw().mRoominfo.mName);
                } else {
                    this.mRg.setText(this.mXB.getString(a.i.no_online_game_name));
                }
                dBL();
                if (i()) {
                    dBY();
                    if (this.mRU != null) {
                        this.mRb = 2;
                        int c = c(2, 0);
                        this.mRU.setCurrentItem(c);
                        this.mRT.setSelectItem(c);
                    }
                } else if (this.mRU != null) {
                    this.mRb = 1;
                    int c2 = c(1, 1);
                    this.mRU.setCurrentItem(c2);
                    this.mRT.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void dBN() {
        this.N = new SurfaceView(this.mXB);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mXF);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dCH().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void dBO() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mXB).s();
        cWC();
        dBS();
        dBT();
        dCH().setBackgroundResource(a.e.room_not_online);
        if (this.mRl == null) {
            this.mRl = new RecommendView(this.mXB);
            dCH().addView(this.mRl);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mXB);
            this.mRl.setLayoutParams(layoutParams);
        }
        if (this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mXA.dBw().mRoominfo.mRoomID)) {
            this.mRl.a(this.mXA.dBw().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dCG() && a.this.mXB != null && a.this.dCH() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mXB);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lMk);
                        if (a.this.dCH().getChildCount() >= 2) {
                            a.this.dCH().addView(frescoThumbnailView, 0);
                        }
                        a.this.dCH().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dOV(), a.this.ar, a.this.mXF);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYo != null) {
            this.mYo.dOp();
            this.mYo.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mYg != null) {
            this.mYg.e();
        }
        wk(false);
        a(false, false);
        if (this.mQK != null) {
            this.mQK.d();
        }
    }

    private void dBP() {
        int i = 0;
        this.mRd = this.mXl.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dAF().d == 0 && this.mSm > 0) {
            View findViewById = this.mXl.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.mSm;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mRe = (ImageView) this.mRd.findViewById(a.f.back_icon);
        this.mRe.setOnClickListener(this);
        this.mRf = (MarqueeTextView) this.mRd.findViewById(a.f.tv_title);
        this.mRg = (MarqueeTextView) this.mRd.findViewById(a.f.tv_Type);
        this.mRi = (ImageView) this.mXl.findViewById(a.f.btn_setting);
        this.mRm = this.mXl.findViewById(a.f.bottomview);
        if (this.mXs == null) {
            this.mXs = (ImageButton) this.mRm.findViewById(a.f.btn_barrage);
            this.mXs.setOnClickListener(this);
            if (this.mXA != null) {
                if (com.kascend.chushou.d.h.dAM().n()) {
                    this.mXs.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXs.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mXt = (ImageButton) this.mRm.findViewById(a.f.btn_audio);
        this.mXt.setOnClickListener(this);
        if (this.mXA != null && this.mXA.d) {
            this.mXt.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mXt.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mXA != null && this.mXA.f != null) {
            while (true) {
                if (i >= this.mXA.f.size()) {
                    break;
                } else if (!"2".equals(this.mXA.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mRn = (ImageButton) this.mRm.findViewById(a.f.playbutton);
        this.mRn.setOnTouchListener(this);
        this.mRj = (ImageButton) this.mRm.findViewById(a.f.btn_refresh);
        this.mRj.setOnClickListener(this);
        this.mRo = (TextView) this.mRm.findViewById(a.f.tv_online_count);
        if (this.mXr == null) {
            this.mXr = (ImageButton) this.mRm.findViewById(a.f.btn_screenChange);
            this.mXr.setOnClickListener(this);
        }
        if (this.mRh == null) {
            this.mRh = (ImageView) this.mRd.findViewById(a.f.report_icon);
            this.mRh.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dx(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dCh();
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
        if (!dCG() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mRa != null) {
                        this.mRa.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                        this.mXA.dBw().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mXA.dBw().mMicStatus.onMic) {
                            dBZ();
                        }
                        if (this.mXA.dBw().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mXA.dBw().mRoominfo.mCreatorUID)) {
                                i(arrayList2, this.mXA.dBw().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mXA.dBw().mMicStatus.onMic) {
                            this.mXA.dBw().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mXA.dBw().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = j(this.mXA.dBw().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mXA.dBw().mMicStatus != null && !h.isEmpty(this.mXA.dBw().mMicStatus.micRoomId) && !this.mXA.dBw().mMicStatus.micRoomId.equals("0")) {
                                this.mSE = this.mXA.dBw().mMicStatus.micRoomId;
                            }
                            if (this.mRa != null) {
                                this.mRa.a(this.mXA.dBw().mMicStatus, this.mXA.dBw().mFanItems, str, z2);
                            }
                            if (this.mRZ != null && this.mRZ.getVisibility() == 0) {
                                this.mRZ.a(this.mXA.dBw().mFanItems, this.mXA.dBw().mMicStatus, str, z2, this.mXA.dBw().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mRa != null) {
                                this.mRa.e();
                            }
                            if (this.mRZ != null && this.mRZ.isShown()) {
                                this.mRZ.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mRa != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mRa.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mRa.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mSo != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mSo = onlineVip.mCount;
                        MG(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mQN != null && this.mQN.mTP != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mQN.mTP.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mQN.mTP.mInPKMode = true;
                                    this.mQN.mTP.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQN.mTP.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQN.mTP.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQN.mTP.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQN.mTP.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQN.mTP.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mQN.mTP.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mQN.mTP.mMode = pkNotifyInfo.mMode;
                                    this.mQN.mTP.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dCl() != null) {
                                        dCl().g(true, this.mQN.mTP.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dAM().a) {
                                        if (!com.kascend.chushou.b.dAF().e) {
                                            com.kascend.chushou.b.dAF().e = true;
                                            g.M(this.mXB, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dAM().a(this.mXB, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.mRb && this.mSt != null) {
                                        this.mSt.setVisibility(0);
                                    }
                                    this.mQN.mTP.mAction = 7;
                                    this.mQN.mTP.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQN.mTP.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQN.mTP.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQN.mTP.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQN.mTP.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQN.mTP.destinyInfo = pkNotifyInfo.destinyInfo;
                                    dCk();
                                    if (dCl() != null) {
                                        dCl().g(false, 0L);
                                        dCl().b(this.mQN.mTP, true);
                                        dCl().a(this.mQN.mTP.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.QI(this.mSu);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mQN.mTP.mInPKMode = false;
                                    this.mQN.mTP.mAction = 2;
                                    dCk();
                                    if (dCl() != null) {
                                        dCl().c();
                                    }
                                    if (com.kascend.chushou.d.h.dAM().a) {
                                        if (!com.kascend.chushou.b.dAF().e) {
                                            com.kascend.chushou.b.dAF().e = true;
                                            g.M(this.mXB, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dAM().a(this.mXB, false);
                                        ak();
                                    }
                                    this.mQN.b = null;
                                    this.mQN.mTP = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.QI(this.mSu);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mQN.mTP.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mQN.mTP.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mQN.mTP.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mXA.dBw().mRoominfo.mRoomID) && this.mXA.dBw().mRoominfo.mRoomID.equals(this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dCl() != null) {
                                        dCl().a(this.mQN.mTP, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mQN.mTP.copyUpdate(pkNotifyInfo);
                                    if (dCl() != null) {
                                        dCl().a(this.mQN.mTP);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mQN.mTP.copyStop(pkNotifyInfo);
                                        if (dCl() != null) {
                                            dCl().w(this.mQN.mTP.mMaxFreeDuration, this.mQN.mTP.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mQN.mTP.copyResult(pkNotifyInfo);
                                    if (!this.mSc && dCl() != null) {
                                        int i5 = 1;
                                        if (this.mQN.mTP.destinyInfo != null && this.mQN.mTP.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dCl().a(h.parseInt(this.mQN.mTP.mResult), h.parseLong(this.mQN.mTP.mvpUid), this.mQN.mTP.mvpAvatar, this.mQN.mTP.mvpNickname, this.mQN.mTP.mMaxFreeDuration, this.mQN.mTP.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mRa != null) {
                if (LoginManager.Instance().islogined() && this.mXA != null && this.mXA.l()) {
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
                if (this.mXA == null || this.mXA.dBw() == null || this.mXA.dBw().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mXA.dBw().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dAM().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dAM().b().equals(next2.mUserID)) {
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
                this.mRa.a(arrayList, true, false);
                this.mRa.c(arrayList3);
            }
        }
    }

    public void MG(int i) {
        int i2;
        if (this.mQX != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mQX.length) {
                    break;
                }
                if (this.mQX[i2] == 99 && this.mQY != null && this.mQY[i2] != null && (this.mQY[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mQY[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mSb.size() && this.mRT != null) {
                if (i == 0) {
                    this.mRT.setTagText(i2, new StringBuilder(this.mSb.get(i2).name).toString());
                    return;
                } else {
                    this.mRT.setTagText(i2, this.mSb.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mXs != null) {
            if (z) {
                this.mXs.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXs.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dBQ() {
        if (this.mXl == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXl.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point he = tv.chushou.zues.utils.a.he(this.mXB);
        this.ar = Math.min(he.x, he.y);
        this.mXF = (this.ar * this.mXB.getResources().getInteger(a.g.h_thumb_height_def)) / this.mXB.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dCH().getLayoutParams();
        layoutParams.height = this.mXF;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXu.getLayoutParams();
        layoutParams2.height = this.mXF;
        layoutParams2.width = this.ar;
        this.mSg = this.mXF + this.mXB.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mXB, 54.0f);
        b(this.mSg, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mXF);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dBR() {
        Point he = tv.chushou.zues.utils.a.he(this.mXB);
        this.ar = Math.min(he.x, he.y);
        this.mXF = (this.ar * this.mXB.getResources().getInteger(a.g.h_thumb_height_def)) / this.mXB.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dCH().getLayoutParams();
        layoutParams.height = this.mXF;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mXu.getLayoutParams();
        layoutParams2.height = this.mXF;
        layoutParams2.width = this.ar;
        this.mSg = this.mXF + this.mXB.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mXB, 54.0f);
        MN(a.e.bg_gift_animation_v);
        b(this.mSg, 10);
        k();
        if (!h.isEmpty(this.mRk)) {
            File ac = tv.chushou.zues.widget.fresco.a.ac(Uri.parse(this.mRk));
            if (ac != null && ac.exists()) {
                this.mXu.setImageURI(Uri.fromFile(ac));
                this.mXu.setVisibility(0);
                return;
            }
            this.mXu.setVisibility(8);
            return;
        }
        this.mXu.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        as(false, false);
        super.c(str, str2);
    }

    private void s(boolean z) {
        if (this.mRh != null) {
            this.mRh.setVisibility(z ? 0 : 4);
        }
        if (this.mRi != null) {
            this.mRi.setVisibility(z ? 0 : 4);
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
        if (this.mXC != null) {
            this.mXC.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mXB).e(true);
            if (!z3) {
                if (this.mRm.getVisibility() != 0 && z2) {
                    this.mRm.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mXt.setVisibility(0);
                } else {
                    this.mXt.setVisibility(8);
                }
                this.mRm.setVisibility(0);
            }
            if (this.mRd.getVisibility() != 0 && z2) {
                this.mRd.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_top_anim));
            }
            s(!z3);
            this.mRd.setVisibility(0);
            v(true);
            if (this.mXC != null) {
                this.mXC.L(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mXB).e(false);
            if (this.mXS != null) {
                this.mXS.dismiss();
            }
            if (this.mXT != null) {
                this.mXT.dismiss();
            }
            if (this.mRm.getVisibility() != 8 && z2) {
                this.mRm.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_bottom_anim));
            }
            this.mRm.setVisibility(8);
            if (this.mRd.getVisibility() != 8 && z2) {
                this.mRd.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_top_anim));
            }
            this.mRd.setVisibility(8);
            v(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean cWC() {
        if (this.mYk == null || !this.mYk.isShown()) {
            return false;
        }
        this.mYk.d();
        return true;
    }

    public boolean dBS() {
        if (this.mRZ == null || !this.mRZ.isShown()) {
            return false;
        }
        this.mRZ.a();
        return true;
    }

    public boolean dBT() {
        if (this.mSe == null || !this.mSe.b()) {
            return false;
        }
        this.mSe.a();
        return true;
    }

    public boolean dBU() {
        if (this.mRW && this.mYg != null) {
            if (this.mYg != null) {
                this.mYg.e();
            }
            if (this.mSx != null) {
                this.mSx.setText("");
            }
            if (this.mRb == 2) {
                at(true, i());
                return true;
            }
            dCf();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXl != null) {
            if (this.mSe == null) {
                this.mSe = (PopH5Menu) ((ViewStub) this.mXl.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mSe.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mSe.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            l(view, 0, this.mRd.getHeight() + this.mRd.getTop());
        } else if (id == a.f.btn_barrage) {
            m(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mXB, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                g.c(this.mXB, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mXA.a(false);
                a(false, false);
                ((VideoPlayer) this.mXB).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.e(this.mXB, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mQN == null || this.mQN.mTP == null || !this.mQN.mTP.mInPKMode) {
                ((VideoPlayer) this.mXB).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mRM) {
                f(this.mRz.getText().toString());
            } else {
                a(this.mRz.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dAM().c) {
                com.kascend.chushou.d.h.dAM().b(false);
                this.mRv.cancel();
                this.mRv.reset();
                this.mRu.clearAnimation();
                this.mRw.setVisibility(8);
            }
            k(view, 0, this.mXl.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.t(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mXB, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            j(view, x, this.mXl.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mXA.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mXB, null) && this.mXA != null && this.mXA.mQx != null) {
                if (this.mRM) {
                    dCo();
                    return;
                }
                if (this.mXA != null && this.mXA.mQx != null && this.mXA.mQx.count > 0) {
                    this.mRB.setVisibility(8);
                } else {
                    this.mRB.setVisibility(0);
                }
                this.mRM = true;
                this.mRJ.setBackgroundResource(a.e.ic_trumpet_p);
                this.mRK.setVisibility(0);
                this.mRK.setSelected(true);
                this.mRK.setTextColor(Color.parseColor("#ff5959"));
                if (this.mRz != null) {
                    this.mRz.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mRL <= 9) {
                this.mRL++;
                this.mRI.setText(this.mRL + "");
            }
            dCm();
        } else if (id == a.f.tv_cut_count) {
            if (this.mRL > 1) {
                this.mRL--;
                this.mRI.setText(this.mRL + "");
            }
            dCm();
        } else if (id == a.f.tv_buy_head) {
            dCn();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mSx.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mSx.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.mSx);
                this.mYg.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mRz != null && this.mRs != null && this.mRy != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mRz);
                this.mRs.setVisibility(8);
                if (this.mRb == 2) {
                    this.mRy.setVisibility(0);
                }
            }
        } else if (this.mRs != null && this.mRy != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
            if (this.mRb == 2) {
                this.mRs.setVisibility(0);
            }
            this.mRy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dAM().c(roomToast.mToastContent);
            if (this.mSh == null) {
                dBV();
            }
            if (this.mSi != null) {
                this.mSi.setText(roomToast.mToastContent);
            }
            if (!this.mSh.isShowing()) {
                if (this.mRV != null) {
                    this.mSh.showAtLocation(this.mRV, 85, 0, this.mXl.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
                    RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mSh != null) {
                                a.this.mSh.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mSh.dismiss();
        }
    }

    private void dBV() {
        if (this.mSh == null) {
            View inflate = LayoutInflater.from(this.mXB).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mSi = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mSh = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 160.0f), -2);
            this.mSh.setFocusable(false);
            this.mSh.setOutsideTouchable(false);
            this.mSh.setAnimationStyle(a.j.gift_toast_style);
            this.mSh.update();
        }
    }

    private void j(View view, int i, int i2) {
        if (this.mYa != null && this.mYa.isShowing()) {
            this.mYa.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
        if (this.mYx == null) {
            dCK();
        }
        if (!this.mYx.isShowing()) {
            this.mYx.showAtLocation(view, 83, i, i2);
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mXA.dBw().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mYx.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dBW() {
        if (this.mYA != null) {
            if (h.isEmpty(this.mYB)) {
                if (((VideoPlayer) this.mXB).q) {
                    this.mYA.bV(this.mXA != null ? this.mXA.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mYA.bV(this.mXA != null ? this.mXA.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mXB).q && this.mYB.size() == 2 && this.mYB.contains("4") && this.mYB.contains("2")) {
                this.mYA.bV(this.mXA != null ? this.mXA.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mYB.size() > 1 || !((VideoPlayer) this.mXB).q) {
                this.mYA.bV(this.mXA != null ? this.mXA.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mYB.get(0))) {
                this.mYA.bV(this.mXA != null ? this.mXA.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mYB.get(0))) {
                this.mYA.bV(this.mXA != null ? this.mXA.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mYB.get(0))) {
                this.mYA.bV(this.mXA != null ? this.mXA.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
        if (this.mYa == null) {
            al();
            this.mYa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mYa.isShowing() && this.mRb == 2) {
            this.mYa.showAtLocation(view, 83, i, this.mXB.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mXA.dBw().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYa.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mXu != null) {
            this.mXu.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                g.c(this.mXB, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mTO.getPlayState() == 4) {
                        e(true);
                        if (this.mXA.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mXA.a(false);
                        ((VideoPlayer) this.mXB).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.mTO.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mTO.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                g.c(this.mXB, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mXA.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mXB).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
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
        if (this.mYo != null) {
            if (z) {
                this.mYo.setVisibility(0);
            }
            this.mYo.dOp();
            if (!z) {
                this.mYo.setVisibility(8);
            }
        }
        g.c(this.mXB, this.mXB.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mRn != null) {
                this.mRn.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mXv != null) {
                this.mXv.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mRn != null) {
            this.mRn.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mXv != null) {
                    this.mXv.setVisibility(8);
                }
            }
        }
    }

    private void dBX() {
        this.e = false;
        k(true, false, true);
    }

    private void dBY() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mQX[i];
        if (this.mRb != i2 || this.QR != i) {
            this.QR = i;
            this.mRb = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            dBL();
            a(this.mXA != null ? this.mXA.mQy.get("1") : null);
            if (i2 == 2) {
                k();
                at(true, i3);
                u(true);
                b(true);
                dCb();
                com.kascend.chushou.toolkit.a.c.a(this.mXB, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            at(false, i3);
            u(false);
            b(false);
            if (this.mYa != null && this.mYa.isShowing()) {
                this.mYa.dismiss();
            }
            if (i2 == 99) {
                if (this.mQY != null && this.mQY[i] != null && (this.mQY[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mQY[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mXB, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mXB, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mXB, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mXB, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.QR = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.mRb == 2) {
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
        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mXC != null) {
            if (this.mRy != null && this.mRy.getVisibility() == 0) {
                t(false);
            }
            if (this.mXv != null && this.mXv.getVisibility() == 0) {
                this.f = true;
            }
            as(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mRa != null) {
            this.mRa.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mRa != null) {
            this.mRa.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mRa != null) {
            this.mRa.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mRa != null) {
            this.mRa.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mRV != null) {
            int size = iconConfig.configs.size();
            this.mRV.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mXB).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mRV, false);
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
                this.mRV.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mXA != null ? this.mXA.mQy : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mRa != null) {
            this.mRa.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        dBW();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRS != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mRS.xi(a.c.kas_white);
            } else if (this.mRb == 2) {
                this.mRS.bV(str, a.c.kas_white);
                if (this.mRT != null) {
                    this.mRT.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mRS.xi(a.c.kas_white);
                if (this.mRT != null) {
                    this.mRT.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mRT != null) {
                    this.mRT.setTextColor(a);
                    this.mRT.setTabTextSelectColor(a2);
                    this.mRT.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRu != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mRu.xi(a.e.ic_hotwords_black_n);
            } else {
                this.mRu.bV(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mRt != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dCW().a(str, this.mRt, a.e.player_skin_input);
            } else {
                this.mRt.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mRx != null) {
                this.mRx.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mRa != null) {
            this.mRa.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mXB instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dBc = ((VideoPlayer) this.mXB).dBc();
            if (this.mYr == null) {
                this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYr.setVisibility(0);
            this.mYr.a(2, dBc);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mRa != null) {
            this.mRa.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mRa != null) {
            this.mRa.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mRa != null) {
            this.mRa.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mRa != null) {
            this.mRa.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mRa != null && this.mXA != null) {
            this.mRa.b(this.mXA.mQv);
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
            if (i < 0 || i >= a.this.mQX.length) {
                return null;
            }
            switch (a.this.mQX[i]) {
                case 1:
                    if (a.this.mQZ == null) {
                        a.this.mQZ = com.kascend.chushou.view.user.a.a(2, null, a.this.mXA.a, false, a.this.mXA.h, false);
                    }
                    a.this.mQY[i] = a.this.mQZ;
                    return a.this.mQZ;
                case 2:
                    if (a.this.mRa == null) {
                        a aVar = a.this;
                        if (a.this.mQN != null && a.this.mQN.mTP != null) {
                            z = a.this.mQN.mTP.mInPKMode;
                        }
                        aVar.mRa = com.kascend.chushou.player.ui.a.wl(z);
                    }
                    a.this.mQY[i] = a.this.mRa;
                    return a.this.mRa;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mXA != null && a.this.mXA.dBw() != null && !h.isEmpty(a.this.mSb)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mSb.get(i).url);
                        h5Options.a = a.this.mSb.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mQY[i] = a;
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
            return a.this.mQX.length;
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
            int dimensionPixelSize = a.this.mXB.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
            Toast.makeText(this.mXB, a.i.str_same_content, 0).show();
            return false;
        } else if (System.currentTimeMillis() - this.mQW <= 3000) {
            Toast.makeText(this.mXB, a.i.str_too_fast, 0).show();
            return false;
        } else {
            dCd();
            if (!com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a(((VideoPlayer) this.mXB).dAX().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mQW = System.currentTimeMillis();
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                a(this.mXA.dBw().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mXA.h);
            }
            g(this.b);
            if (!z && this.mRz != null) {
                this.mRz.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dCd();
            if (com.kascend.chushou.d.e.c(this.mXB, null) && LoginManager.Instance().getUserInfo() != null && this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                a(this.mXA.dBw().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mRz != null) {
                this.mRz.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mRa != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mXA.dBw().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mXA.dBw().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mXB).mOJ;
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
                        this.mRa.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mRa.a(arrayList, true, true);
        }
    }

    private void dBZ() {
        if (this.mRa != null) {
            this.mRa.e();
        }
        if (this.mRZ != null && this.mRZ.isShown()) {
            this.mRZ.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void nO() {
        super.nO();
        if (this.mXB instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        dBZ();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mRX);
        if (this.mXB != null) {
            if (this.mRX || "10004".equals(((VideoPlayer) this.mXB).t)) {
                this.mRX = true;
                if (this.mXA != null) {
                    this.mXA.f = null;
                    if (this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                        this.mXA.dBw().mRoominfo.mGameId = null;
                    }
                }
                dBO();
                return;
            }
            this.mRX = true;
            if (this.mXB != null) {
                ((VideoPlayer) this.mXB).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mRX = false;
        if (this.mRl != null) {
            this.mRl.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mRX = false;
        if (this.mRl != null) {
            this.mRl.setVisibility(8);
        }
        super.i(z);
    }

    private void dCa() {
        dBM();
        if (i()) {
            dCc();
            dCI();
            return;
        }
        dBO();
    }

    private void dCb() {
    }

    private void dCc() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dCH().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mYo != null) {
            this.mYo.setVisibility(0);
        }
        if (this.mQK != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mQK.d();
        }
        if (this.mRs != null) {
            this.mRs.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mRi.setVisibility(0);
            this.mRi.setOnClickListener(this);
        } else {
            this.mRi.setVisibility(8);
        }
        this.mRn.setVisibility(0);
        this.mRj.setVisibility(0);
        this.mXs.setVisibility(0);
        if (this.p) {
            this.mXt.setVisibility(0);
        } else {
            this.mXt.setVisibility(8);
        }
        dCb();
        at(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mYr != null && this.mYr.a(i, keyEvent)) {
                return true;
            }
            if (this.mSe != null && this.mSe.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mSf != null && this.mSf.onKeyDown(i, keyEvent)) || dCe()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mSy != null && this.mSy.getVisibility() == 0 && b(motionEvent, this.mSy)) {
                this.mSy.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.mSx);
                return true;
            } else if (this.mRW && this.mSy != null && this.mSy.getVisibility() == 8 && g(this.mYg.b, motionEvent)) {
                dBU();
                return true;
            } else if (this.mSe != null && this.mSe.b() && g(this.mSe, motionEvent)) {
                this.mSe.a();
                return true;
            } else if (this.mSf != null && this.mSf.b() && g(this.mSf, motionEvent)) {
                this.mSf.a();
                return true;
            } else if (b(motionEvent, this.mRy)) {
                return dCd();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dCd() {
        boolean z;
        b(this.mSg, 10);
        boolean z2 = false;
        if (this.mRN != null && this.mRN.getVisibility() == 0) {
            this.mRN.setVisibility(8);
            this.mRO.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mRP) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
            this.mRO.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mRy == null || this.mRy.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mRM) {
                dCo();
            }
            this.mRy.setVisibility(8);
            z = true;
        }
        if (this.mRb == 2) {
            RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mRs != null && a.this.mRb == 2) {
                        a.this.mRs.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean dCe() {
        if (dCd()) {
            return true;
        }
        if (this.mYa == null || !this.mYa.isShowing()) {
            return dBU() || dBS() || cWC();
        }
        this.mYa.dismiss();
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
    public void dCf() {
        this.mRs.setVisibility(8);
        this.mRy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(boolean z, boolean z2) {
        if (this.mRs != null) {
            if (z) {
                if (this.mRs.getVisibility() != 0) {
                    this.mRs.setVisibility(0);
                    this.mRs.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_bottom_anim));
                }
            } else if (this.mRs.getVisibility() != 4) {
                this.mRs.setVisibility(4);
                this.mRs.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mRl != null) {
            this.mRl.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dCg() {
        return this.mSl;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dCG()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mXA != null) {
                        this.mXA.f = null;
                        this.mXA.dBw().mRoominfo.mGameId = null;
                    }
                    dBO();
                    return;
                }
                Toast.makeText(this.mXB, a.i.str_getvideosource_failed, 0).show();
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
        if (this.mXA != null && this.mXA.dBx() != null) {
            a(this.mXA.dBx());
        }
        this.p = false;
        if (this.mXA == null || this.mXA.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mXA.f.size()) {
                if (!"2".equals(this.mXA.f.get(i2).mType)) {
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
        if (this.mRa != null) {
            this.mRa.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dCG()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mRo != null && this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                this.mRo.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mXA.dBw().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dCG() && !this.mSc && (c = c(1, -1)) >= 0 && c < this.mSb.size() && this.mRU != null) {
            this.mRU.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dCG() && !this.mSc) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mXB, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dBd = ((VideoPlayer) this.mXB).dBd();
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(2, dBd);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dBe = ((VideoPlayer) this.mXB).dBe();
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(2, dBe);
            } else if (bVar.a == 9) {
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mRN != null) {
            this.mRN.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dCG() && !this.mSc) {
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
        if (this.mRb == 2) {
            RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dCG()) {
                        a.this.t(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mRz != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mRz);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCh() {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
            if (this.mRY == null) {
                this.mRY = new f(getActivity());
            }
            this.mRY.a(this.mXA.dBw().mRoominfo);
            if (!this.mRY.isShowing()) {
                this.mRY.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mRa != null) {
            this.mRa.d();
        }
    }

    private void dz(View view) {
        this.mRp = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mRq = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mRq.setText(new tv.chushou.zues.widget.a.c().O(this.mXB, a.e.videoplayer_4g_video).append("  ").append(this.mXB.getString(a.i.videoplayer_4g_video)));
        this.mRr = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mRr.setText(new tv.chushou.zues.widget.a.c().O(this.mXB, a.e.videoplayer_4g_audio).append("  ").append(this.mXB.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mRp.setVisibility(8);
                    ((VideoPlayer) a.this.mXB).b(a.this.bR);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mRp.setVisibility(8);
                    ((VideoPlayer) a.this.mXB).c(a.this.bR);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dAF().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mRq.setOnClickListener(onClickListener);
        this.mRr.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mXA != null && !h.isEmpty(this.mXA.f)) {
            f(this.mXA.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.bR = z;
            this.p = false;
            if (this.mXA != null && this.mXA.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mXA.f.size()) {
                        break;
                    } else if (!"2".equals(this.mXA.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mRp != null) {
                this.mRp.setVisibility(0);
                this.mRq.setVisibility(0);
                this.mRr.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mRp != null) {
            this.mRp.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mSq == null) {
                this.mSq = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dCG()) {
                            a.this.dCi();
                        }
                    }
                };
                if (this.mXC != null) {
                    this.mXC.d(this.mSq, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mSq != null && this.mXC != null) {
            this.mXC.removeCallbacks(this.mSq);
            this.mSq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCi() {
        if (LoginManager.Instance().islogined() && this.mRa != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mXB, "显示双击666_num", null, new Object[0]);
            if (this.mXA != null) {
                this.mXA.b(false);
            }
            d(false);
            this.mRa.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXl != null) {
            if (this.mSf == null) {
                this.mSf = (InteractionView) ((ViewStub) this.mXl.findViewById(a.f.view_interaction)).inflate();
                this.mSf.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mSf.a();
                    }
                });
            }
            if (this.mSf != null) {
                this.mSf.b(configDetail);
                this.mSf.c();
                this.mSf.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dPa()) {
                g.M(this.mXB, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mXB, null) && (this.mXB instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXA != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXB, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXA != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXB, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mXB, configDetail.mUrl, this.mXB.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
            if (com.kascend.chushou.d.e.c(this.mXB, null)) {
                if (!configDetail.mTargetKey.equals("pay")) {
                    if (configDetail.mTargetKey.equals("gift")) {
                        dCj();
                        return;
                    } else if (configDetail.mTargetKey.equals("interaction")) {
                        a(configDetail);
                        return;
                    } else {
                        Toast.makeText(this.mXB, a.i.str_getnewversion, 0).show();
                        return;
                    }
                }
                b(com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "34"));
            }
        } else {
            Toast.makeText(this.mXB, a.i.str_getnewversion, 0).show();
        }
    }

    private void dCj() {
        if (this.mRW) {
            dBU();
            return;
        }
        if (this.mXB.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXA.dBw().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mXB != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mQN == null) {
                this.mQN = new com.kascend.chushou.player.e.a();
            }
            this.mQN.b = str;
            this.mQN.mTP.copy(pkNotifyInfo);
            if (this.mQN.mTP.mAction == 6) {
                this.mQN.mTP.mInPKMode = true;
                this.u = this.mQN.mTP.mPkId;
            } else if (this.mQN.mTP.mAction == 7 || (this.mQN.mTP.mMode == 1 && this.mQN.mTP.mAction == 5)) {
                this.mQN.mTP.mInPKMode = true;
                this.u = this.mQN.mTP.mPkId;
                if (dCl() != null) {
                    if (2 == this.mRb && this.mSt != null) {
                        this.mSt.setVisibility(0);
                    }
                    dCl().b(this.mQN.mTP, false);
                    dCl().a(this.mQN.mTP.mMode, "1");
                    if (this.mQN.mTP.mAction == 5 && this.mQN.mTP.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mQN.mTP.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mQN.mTP.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mQN.mTP.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mQN.mTP.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mQN.mTP.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dCl().a(this.mQN.mTP);
                        if (this.mQN.mTP.destinyInfo == null || this.mQN.mTP.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dCl().a(parseInt, this.mQN.mTP.mPkUpdateInfo.remainDuration, j, this.mQN.mTP.mMode, i);
                    }
                    if (!h.isEmpty(this.mQN.mTP.mPkUpdateInfo.specialMomentList) && dCl() != null) {
                        dCl().a(this.mQN.mTP, true);
                    }
                }
                dCk();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.QI(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mQN.mTP.mInPKMode = false;
                dCk();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.QI(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void dCk() {
        if (this.mQN != null && this.mQN.mTP != null) {
            if (this.mQN.mTP.mInPKMode) {
                this.y.setText(this.mQN.mTP.mPkUserNickname);
                this.mQP.setVisibility(0);
                if (this.mXr != null) {
                    this.mXr.setEnabled(false);
                }
                if (this.mXt != null) {
                    this.mXt.setEnabled(false);
                    return;
                }
                return;
            }
            this.mQP.setVisibility(8);
            if (this.mXr != null) {
                this.mXr.setEnabled(true);
            }
            if (this.mXt != null) {
                this.mXt.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dCl() {
        if (this.mXB == null || this.mXl == null || this.mSt == null) {
            return null;
        }
        if (this.mQO == null) {
            if (this.mSs == null) {
                this.mSs = ((ViewStub) this.mXl.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mQO = new com.kascend.chushou.player.e.b();
            this.mQO.a(this.mSt, this.mSs, (View) null, this.mXB, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dOJ()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mXA != null) {
                        append.append(a.this.mXA.dBy().mRoomID);
                    }
                    if (a.this.mQN != null && a.this.mQN.mTP != null) {
                        append.append("&mode=").append(a.this.mQN.mTP.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mXB, append.toString());
                }
            });
        }
        return this.mQO;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mRK != null && this.mXA != null && this.mXA.mQx != null) {
            this.mRK.setText(tv.chushou.zues.utils.b.Oi(this.mXA.mQx.count));
            this.mRK.setVisibility(0);
            if (this.mXA.mQx.count < 1) {
                dCo();
            }
            if (this.mRC != null) {
                this.mRC.setText(this.mXA.mQx.primaryName);
            }
            if (this.mRD != null) {
                this.mRD.setText(this.mXA.mQx.desc);
            }
            dCm();
        }
    }

    public void dCm() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mRL * h.parseLong(this.mXA.mQx.point)));
        if (this.mRF != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mXB.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mXB, a.e.icon_coin_new);
            cVar.append(this.mXB.getString(a.i.str_buy_count_coin2));
            this.mRF.setText(cVar);
        }
    }

    private void dCn() {
        if (com.kascend.chushou.d.e.c(this.mXB, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mRL);
        }
    }

    private void u(boolean z) {
        if (this.mXl != null && this.mSt != null) {
            if (z) {
                if (this.mQN != null && this.mQN.mTP != null && this.mQN.mTP.mInPKMode) {
                    this.mSt.setVisibility(0);
                    return;
                }
                return;
            }
            this.mSt.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mXl != null && this.mQS != null) {
            if (z) {
                if (this.E && 2 == this.mRb) {
                    this.mQS.setVisibility(0);
                    return;
                }
                return;
            }
            this.mQS.setVisibility(8);
        }
    }

    private void v(boolean z) {
        if (z) {
            if (this.mQN != null && this.mQN.mTP != null && this.mQN.mTP.mInPKMode && this.mQP != null) {
                this.mQP.setVisibility(0);
            }
        } else if (this.mQP != null) {
            this.mQP.setVisibility(8);
        }
    }

    private void dCo() {
        this.mRM = false;
        this.mRJ.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mXA != null && this.mXA.mQx != null) {
            if (this.mXA.mQx.count < 1) {
                this.mRK.setVisibility(8);
            } else {
                this.mRK.setVisibility(0);
                this.mRK.setSelected(false);
                this.mRK.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mRB.setVisibility(8);
        if (this.mRz != null) {
            this.mRz.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        dCj();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mRx != null) {
            this.mRx.performClick();
        }
    }

    public boolean dCp() {
        return this.mRb == 2;
    }
}
