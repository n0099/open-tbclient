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
    private int cF;
    private TextView mqA;
    private TextView mqB;
    private boolean mqC;
    private RelativeLayout mqD;
    private View mqE;
    private FrescoThumbnailView mqF;
    private AnimationSet mqG;
    private ImageView mqH;
    private TextView mqI;
    private RelativeLayout mqJ;
    private PastedEditText mqK;
    private TextView mqL;
    private LinearLayout mqM;
    private TextView mqN;
    private TextView mqO;
    private TextView mqP;
    private TextView mqQ;
    private TextView mqR;
    private TextView mqS;
    private TextView mqT;
    private ImageView mqU;
    private TextView mqV;
    private KPSwitchPanelLinearLayout mqY;
    private ImageView mqZ;
    private int[] mqi;
    private Fragment[] mqj;
    private ImageView mqo;
    private MarqueeTextView mqp;
    private MarqueeTextView mqq;
    private ImageView mqr;
    private ImageView mqs;
    private ImageButton mqt;
    public String mqu;
    private RecommendView mqv;
    private TextView mqy;
    private RelativeLayout mqz;
    private TextView mrA;
    private ImageView mrB;
    private EditText mrC;
    private View mrD;
    private View mrE;
    private View mrF;
    private String mrI;
    private c mrb;
    private d.a mrc;
    private FrescoThumbnailView mrd;
    private PagerSlidingTabStrip mre;
    private KasViewPager mrf;
    private LinearLayout mrg;
    private f mri;
    private ViewMicPerson mrj;
    public ArrayList<RoomTab> mrl;
    private PopH5Menu mrn;
    private InteractionView mro;
    private PopupWindow mrp;
    private TextView mrq;
    private GiftAnimationLayout mrr;
    private com.kascend.chushou.player.b.a mrs;
    private Runnable mrv;
    private View mrx;
    private LivePKBarUserValue mry;
    private String mrz;
    private long mqh = 0;
    private com.kascend.chushou.view.user.a mqk = null;
    private com.kascend.chushou.player.ui.a mql = null;
    private int akK = -1;
    private int mqm = 0;
    private View mqn = null;
    private View mqw = null;
    private ImageButton mqx = null;
    private int mqW = 1;
    private boolean mqX = false;
    private boolean mra = false;
    private boolean cw = false;
    private boolean mrh = false;
    private boolean mrk = false;
    private boolean cB = false;
    private boolean mrm = true;
    private int cK = 0;
    private int mrt = 0;
    private int mru = -1;
    private final Rect mrw = new Rect();
    private boolean mrG = false;
    private C0721a mrH = null;
    private boolean da = false;
    private boolean mrJ = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mqu = getArguments().getString("mCover");
        this.mrm = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mwj = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mwj;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dyq()) {
            c(view);
            aG();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        e.i("VideoPlayerEmbeddedScreenFragment", "video player embed onResume");
        this.cB = false;
        boolean z = (this.ai || this.H || this.al) ? false : true;
        a(z, z ? false : true);
        if (this.mxf != null) {
            this.mxf.b();
        }
        if (this.mwz != null && (this.mwz instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwz).wa(true);
            ((VideoPlayer) this.mwz).z();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cB = true;
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
        this.mqW = 1;
        this.mqX = false;
        U();
        if (this.mwA != null) {
            this.mwA.bZ(null);
            this.mwA = null;
        }
        if (this.mqv != null) {
            dyr().removeAllViews();
            this.mqv = null;
        }
        this.c = null;
        this.mpS = null;
        tv.chushou.zues.a.a.ca(this);
        this.mre = null;
        this.mrf = null;
        this.mql = null;
        this.mqk = null;
        if (this.mqj != null) {
            for (int i = 0; i < this.mqj.length; i++) {
                this.mqj[i] = null;
            }
        }
        this.mqj = null;
        if (this.mqK != null) {
            this.mqK.addTextChangedListener(null);
            this.mqK.setOnTouchListener(null);
            this.mqK.setOnEditorActionListener(null);
            this.mqK = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mwz, this.mrb);
        if (this.mwz != null && (this.mwz instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwz).dwZ();
        }
        this.mrc = null;
        this.mrb = null;
        if (this.mrj != null) {
            this.mrj.b();
            this.mrj = null;
        }
        if (this.mrp != null) {
            this.mrp.dismiss();
        }
        if (this.mrs != null) {
            this.mrs.a();
            this.mrs = null;
            this.mrr = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mry = (LivePKBarUserValue) this.mwj.findViewById(a.f.live_pk_bar_user);
        this.mws = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mrG) {
            this.mrG = true;
            if (this.mrE == null) {
                this.mrE = this.mwj.findViewById(a.f.vs_async_view);
                this.mrE = ((ViewStub) this.mrE).inflate();
            }
            if (this.mrF == null) {
                this.mrF = this.mwj.findViewById(a.f.vs_async_notification_view);
                this.mrF = ((ViewStub) this.mrF).inflate();
            }
            this.mqd = (VoiceInteractionView) this.mwj.findViewById(a.f.voiceInteractiveView);
            t();
            dr(this.mwj);
            dlt();
            ((VideoPlayer) this.mwz).q();
            this.mpY = new com.kascend.chushou.player.e.a();
        }
    }

    private void dr(View view) {
        this.mrd = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mre = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mrf = (KasViewPager) view.findViewById(a.f.vp_main);
        aH();
        dxH();
        aN();
        if (this.mwy != null) {
            I();
            a(this.mwy.mpD, this.mwy.mpH);
        }
        this.boO = 0;
        this.mxk = 0L;
        this.mxg = (RoundProgressBar) this.mwj.findViewById(a.f.roundProgressBar);
        this.mxh = (TextView) this.mwj.findViewById(a.f.tv_paonum);
        this.mxi = (FrescoThumbnailView) this.mwj.findViewById(a.f.iv_paoicon);
        this.mxp = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.cw = false;
                if (a.this.akK == 2) {
                    a.this.as(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.cF, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.cw = true;
                if (a.this.akK == 2) {
                    a.this.as(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.mxf != null) {
                    a.this.mxf.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.gh(a.this.mwz).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mwz)) - a.this.mxf.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mwz, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mwz, 54.0f) * 2);
                    if (statusBarHeight < a.this.cF) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mxj = (PaoGuideView) this.mwj.findViewById(a.f.rlPaoGuideView);
        this.mrj = (ViewMicPerson) this.mwj.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.msP = ((VideoPlayer) this.mwz).dwS();
        this.mwy = ((VideoPlayer) this.mwz).dwV();
        ds(this.mwj);
        this.cK = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
        this.mrt = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (com.kascend.chushou.b.dwD().d == 0 && this.mrt > 0) {
            View findViewById = this.mwj.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mrt);
        }
        dxN();
        dxL();
        if (!this.mrm) {
            Q();
        }
        aO();
        a();
        if (this.c == null) {
            this.mpS = new d.a();
            this.c = new GestureDetector(this.mwz, this.mpS);
        }
        this.mpU = ((VideoPlayer) this.mwz).dwW();
        this.mpU.a(this);
        if (this.mrs != null) {
            this.mrs.a();
            this.mrs = null;
        }
        this.mrr = (GiftAnimationLayout) this.mwj.findViewById(a.f.ll_gift_animation);
        this.mrr.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mwy != null) {
            this.mrs = new com.kascend.chushou.player.b.a(this.mwz.getApplicationContext(), this.mrr);
            this.mrs.a(this.mwy);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mwj.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mwt = (PlayerErrorView) this.mwj.findViewById(a.f.view_net_error_msg);
        this.mwt.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dxK();
        dxR();
        if (this.mwy.dxw() != null) {
            a(this.mwy.dxw());
        }
        FullRoomInfo dxv = this.mwy.dxv();
        if (dxv != null) {
            dxU();
            if (i()) {
                this.ak = false;
                we(true);
                this.mwA.JF(8);
            }
            this.mqy.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dxv.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mqn.setVisibility(0);
        this.ak = false;
        we(true);
        this.mwA.JF(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mwz).n();
        if (this.mwy != null && !h.isEmpty(this.mwy.mpF)) {
            b(this.mwy.mpF);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dxg;
        aH();
        k();
        FullRoomInfo dxv = this.mwy.dxv();
        if (dxv != null) {
            if (dxv.mRoominfo != null) {
                this.mqy.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dxv.mRoominfo.mOnlineCount)));
                this.mrz = dxv.mRoominfo.mRoomID;
            }
            dxU();
            if (!h.isEmpty(dxv.mRoomToastList)) {
                Iterator<RoomToast> it = dxv.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dwK().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mwy != null && this.mwy.l()) {
                d(true);
            }
            if (this.mwz != null && (this.mwz instanceof VideoPlayer) && (dxg = ((VideoPlayer) this.mwz).dxg()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dxg.msQ, dxg.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mrg);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void aH() {
        boolean z = true;
        if (this.mwy == null || this.mwy.dxv() == null || this.mwy.dxv().mRoominfo == null || h.isEmpty(this.mwy.dxv().mRoomTabs)) {
            this.mrk = false;
            this.mqj = new Fragment[2];
            this.mqi = new int[2];
            this.mqi[0] = 2;
            this.mqi[1] = 1;
            return;
        }
        this.mrk = true;
        this.mrl = new ArrayList<>();
        Iterator<RoomTab> it = this.mwy.dxv().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mrl.add(next);
            }
        }
        if (this.mrl.size() >= 2 && this.mqi != null && this.mqi.length >= 2 && this.mrl.get(0).type == this.mqi[0] && this.mrl.get(1).type == this.mqi[1]) {
            z = false;
        }
        this.mqj = new Fragment[this.mrl.size()];
        this.mqi = new int[this.mrl.size()];
        for (int i = 0; i < this.mrl.size(); i++) {
            this.mqi[i] = this.mrl.get(i).type;
        }
        if (z) {
            this.mrH = new C0721a(getChildFragmentManager());
            this.mrf.setAdapter(this.mrH);
        }
    }

    private void dxH() {
        this.mqJ = (RelativeLayout) this.mwj.findViewById(a.f.rl_edit_bar);
        this.mqF = (FrescoThumbnailView) this.mwj.findViewById(a.f.btn_hotword);
        this.mqF.xW(a.e.ic_hotwords_black_n);
        this.mqF.setOnClickListener(this);
        this.mqH = (ImageView) this.mwj.findViewById(a.f.iv_task_badge);
        this.mqG = (AnimationSet) AnimationUtils.loadAnimation(this.mwz, a.C0715a.anim_hotword);
        this.mqG.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dwK().c) {
                    a.this.mqF.clearAnimation();
                    a.this.mqF.startAnimation(a.this.mqG);
                }
            }
        });
        if (com.kascend.chushou.d.h.dwK().c) {
            this.mqF.startAnimation(this.mqG);
            this.mqH.setVisibility(0);
        }
        this.mqI = (TextView) this.mwj.findViewById(a.f.tv_bottom_input);
        this.mqI.setOnClickListener(this);
        this.mxz = (FrescoThumbnailView) this.mwj.findViewById(a.f.ll_btn_set);
        this.mxz.setOnClickListener(this);
        this.mrg = (LinearLayout) this.mwj.findViewById(a.f.ll_bottom_all_button);
        this.mqD = (RelativeLayout) this.mwj.findViewById(a.f.rl_bottom_input);
        this.mqE = this.mwj.findViewById(a.f.ll_bottom_input);
        this.mqD.setVisibility(8);
        this.mqK = (PastedEditText) this.mwj.findViewById(a.f.et_bottom_input);
        this.mqK.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mqL.setEnabled(editable.length() > 0);
            }
        });
        this.mqK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mqL);
                    return true;
                }
                return true;
            }
        });
        this.mqK.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.m(a.this.mqK);
                }
                return false;
            }
        });
        this.mqZ = (ImageView) this.mwj.findViewById(a.f.iv_btn_emoji);
        this.mqZ.setVisibility(8);
        this.mqL = (TextView) this.mwj.findViewById(a.f.tv_btn_send);
        this.mqL.setOnClickListener(this);
        this.mqY = (KPSwitchPanelLinearLayout) this.mwj.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dwD().d == 0) {
            this.mqY.setUseStatusBar(true);
        }
        this.mqM = (LinearLayout) this.mwj.findViewById(a.f.head_trumpet);
        this.mqM.setVisibility(8);
        this.mqM.setOnClickListener(this);
        this.mqN = (TextView) this.mwj.findViewById(a.f.tv_primary_name);
        this.mqO = (TextView) this.mwj.findViewById(a.f.tv_primary_desc);
        this.mqR = (TextView) this.mwj.findViewById(a.f.tv_cut_count);
        this.mqR.setOnClickListener(this);
        this.mqT = (TextView) this.mwj.findViewById(a.f.tv_head_count);
        this.mqT.setText(this.mqW + "");
        this.mqS = (TextView) this.mwj.findViewById(a.f.tv_plus_count);
        this.mqS.setOnClickListener(this);
        this.mqQ = (TextView) this.mwj.findViewById(a.f.tv_buy_count_coin);
        this.mqP = (TextView) this.mwj.findViewById(a.f.tv_buy_head);
        this.mqP.setOnClickListener(this);
        this.mqU = (ImageView) this.mwj.findViewById(a.f.iv_trumpet_select);
        this.mqU.setOnClickListener(this);
        this.mqV = (TextView) this.mwj.findViewById(a.f.tv_trumpet_have_count);
        this.mqX = false;
        this.mqU.setBackgroundResource(a.e.ic_trumpet_n);
        this.mqV.setVisibility(8);
        dxJ();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mqY, this.mqZ, this.mqK, new a.InterfaceC0841a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0841a
            public void wb(boolean z) {
                if (a.this.mqZ != null) {
                    if (!z) {
                        a.this.mqZ.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dwD().d == 0) {
                        a.this.mqY.setDirectVisibility(0);
                    }
                    a.this.mqZ.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mrc = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wc(boolean z) {
                if (a.this.mrJ) {
                    a.this.mrJ = false;
                    return;
                }
                a.this.mra = z;
                if (z) {
                    a.this.mqZ.setImageResource(a.e.cs_emoji_normal);
                    a.this.dxI();
                    return;
                }
                if (a.this.mrD != null && a.this.mrD.getVisibility() == 0) {
                    a.this.mrD.setVisibility(8);
                }
                if (a.this.cw) {
                    a.this.mxf.setVisibility(0);
                }
                if (a.this.mwz != null && (a.this.mwz instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mwz).wa(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mrb = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mqY, this.mrc, ((VideoPlayer) this.mwz).dxa());
        ((VideoPlayer) this.mwz).h(((VideoPlayer) this.mwz).dxa());
        this.mrD = this.mwj.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mrA = (TextView) this.mwj.findViewById(a.f.btn_room_search);
        this.mrB = (ImageView) this.mwj.findViewById(a.f.iv_room_emoji_delete);
        this.mrC = (EditText) this.mwj.findViewById(a.f.et_room_emoji_search);
        this.mrC.setImeOptions(3);
        this.mrC.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mrA);
                    return true;
                }
                return false;
            }
        });
        this.mrC.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mrA.setEnabled(editable.length() > 0);
                a.this.mrB.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mxf.setEmojiSearchText(editable.toString());
            }
        });
        this.mrA.setOnClickListener(this);
        this.mrB.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aq(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dC(this.mrC);
            this.mrD.setVisibility(0);
            this.mrC.requestFocus();
        } else {
            this.mrD.setVisibility(8);
        }
        if (z2) {
            this.mrC.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxI() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.gh(this.mwz).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz)) - tv.chushou.zues.widget.kpswitch.b.d.gt(this.mwz)) - tv.chushou.zues.utils.a.dip2px(this.mwz, 14.0f)) - this.mwz.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mwz, 54.0f) * 2);
        if (statusBarHeight < this.cF) {
            b(statusBarHeight, 10);
        }
    }

    private void dxJ() {
    }

    private void dxK() {
        this.mwA = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.ar(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mwj.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mwz.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mwA.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mwA.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mwA.A(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mwA);
                            break;
                        case 12:
                            a.this.b(a.this.mwA);
                            break;
                        case 17:
                            a.this.dys();
                            break;
                        case 18:
                            a.this.dls();
                            break;
                        case 19:
                            a.this.mwx.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                    e.e("VideoPlayerEmbeddedScreenFragment", "handlemessage error e=" + e.toString() + " msg=" + message.toString());
                }
                return false;
            }
        });
    }

    private void aM() {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mrl)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mrl.size()) {
                    if (!h.isEmpty(this.mrl.get(i2).notifyIcon)) {
                        this.mre.bA(i2, this.mrl.get(i2).notifyIcon);
                        this.mre.Kf(i2);
                    } else if (this.mrl.get(i2).notify == 1) {
                        this.mre.Ke(i2);
                        this.mre.Kd(i2);
                    } else {
                        this.mre.Kd(i2);
                        this.mre.Kf(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mrl)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mrl.size()) {
                    if (this.mrl.get(i4).type == i) {
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
    public String Ik(int i) {
        if (this.mwy == null || this.mwy.dxv() == null || this.mwy.dxv().mRoominfo == null || h.isEmpty(this.mrl)) {
            if (i == 1) {
                return this.mwz.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mwz.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mrl.size()) {
            return this.mrl.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mrl) && i < this.mrl.size()) {
            this.mrl.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mrl) && i < this.mrl.size()) {
            this.mrl.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.mrf != null && this.mre != null && this.mqi != null) {
            this.mql = null;
            if (this.mqj != null) {
                for (int i = 0; i < this.mqj.length; i++) {
                    this.mqj[i] = null;
                }
            }
            if (this.mrH == null) {
                this.mrH = new C0721a(getChildFragmentManager());
                this.mrf.setAdapter(this.mrH);
            } else {
                this.mrH.notifyDataSetChanged();
            }
            this.mrf.setOffscreenPageLimit(this.mqi.length);
            this.mre.c(this.mrf);
            this.mre.setOnPageChangeListener(this);
            this.mre.notifyDataSetChanged();
            this.mre.setVisibility(0);
            this.mrf.setVisibility(0);
            if (!this.mrk) {
                this.akK = 2;
                this.mrf.setCurrentItem(c(2, 0));
                this.mqD.setVisibility(0);
            } else {
                if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                    if (!h.isEmpty(this.mwy.dxv().mRoominfo.mGameName)) {
                        this.mqq.setText(this.mwy.dxv().mRoominfo.mGameName);
                    } else {
                        this.mqq.setText(this.mwz.getString(a.i.no_online_game_name));
                    }
                    this.mqp.setText(this.mwy.dxv().mRoominfo.mName);
                } else {
                    this.mqq.setText(this.mwz.getString(a.i.no_online_game_name));
                }
                aM();
                if (i()) {
                    dxS();
                    if (this.mrf != null) {
                        this.akK = 2;
                        int c = c(2, 0);
                        this.mrf.setCurrentItem(c);
                        this.mre.setSelectItem(c);
                    }
                } else if (this.mrf != null) {
                    this.akK = 1;
                    int c2 = c(1, 1);
                    this.mrf.setCurrentItem(c2);
                    this.mre.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mwz);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mwD);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dyr().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void aP() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mwz).s();
        dlz();
        dxO();
        dxP();
        dyr().setBackgroundResource(a.e.room_not_online);
        if (this.mqv == null) {
            this.mqv = new RecommendView(this.mwz);
            dyr().addView(this.mqv);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mwz);
            this.mqv.setLayoutParams(layoutParams);
        }
        if (this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mwy.dxv().mRoominfo.mRoomID)) {
            this.mqv.a(this.mwy.dxv().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dyq() && a.this.mwz != null && a.this.dyr() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mwz);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lWg);
                        if (a.this.dyr().getChildCount() >= 2) {
                            a.this.dyr().addView(frescoThumbnailView, 0);
                        }
                        a.this.dyr().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dJK(), a.this.ar, a.this.mwD);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mxn != null) {
            this.mxn.dJf();
            this.mxn.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mxf != null) {
            this.mxf.e();
        }
        we(false);
        a(false, false);
        if (this.mpU != null) {
            this.mpU.d();
        }
    }

    private void dxL() {
        int i = 0;
        this.mqn = this.mwj.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dwD().d == 0 && this.cK > 0) {
            View findViewById = this.mwj.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.cK;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mqo = (ImageView) this.mqn.findViewById(a.f.back_icon);
        this.mqo.setOnClickListener(this);
        this.mqp = (MarqueeTextView) this.mqn.findViewById(a.f.tv_title);
        this.mqq = (MarqueeTextView) this.mqn.findViewById(a.f.tv_Type);
        this.mqs = (ImageView) this.mwj.findViewById(a.f.btn_setting);
        this.mqw = this.mwj.findViewById(a.f.bottomview);
        if (this.mwq == null) {
            this.mwq = (ImageButton) this.mqw.findViewById(a.f.btn_barrage);
            this.mwq.setOnClickListener(this);
            if (this.mwy != null) {
                if (com.kascend.chushou.d.h.dwK().n()) {
                    this.mwq.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mwq.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mwr = (ImageButton) this.mqw.findViewById(a.f.btn_audio);
        this.mwr.setOnClickListener(this);
        if (this.mwy != null && this.mwy.d) {
            this.mwr.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mwr.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mwy != null && this.mwy.f != null) {
            while (true) {
                if (i >= this.mwy.f.size()) {
                    break;
                } else if (!"2".equals(this.mwy.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mqx = (ImageButton) this.mqw.findViewById(a.f.playbutton);
        this.mqx.setOnTouchListener(this);
        this.mqt = (ImageButton) this.mqw.findViewById(a.f.btn_refresh);
        this.mqt.setOnClickListener(this);
        this.mqy = (TextView) this.mqw.findViewById(a.f.tv_online_count);
        if (this.mwp == null) {
            this.mwp = (ImageButton) this.mqw.findViewById(a.f.btn_screenChange);
            this.mwp.setOnClickListener(this);
        }
        if (this.mqr == null) {
            this.mqr = (ImageView) this.mqn.findViewById(a.f.report_icon);
            this.mqr.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dq(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dxX();
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
        if (!dyq() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mql != null) {
                        this.mql.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                        this.mwy.dxv().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mwy.dxv().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.mwy.dxv().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mwy.dxv().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.mwy.dxv().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mwy.dxv().mMicStatus.onMic) {
                            this.mwy.dxv().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mwy.dxv().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.mwy.dxv().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mwy.dxv().mMicStatus != null && !h.isEmpty(this.mwy.dxv().mMicStatus.micRoomId) && !this.mwy.dxv().mMicStatus.micRoomId.equals("0")) {
                                this.mrI = this.mwy.dxv().mMicStatus.micRoomId;
                            }
                            if (this.mql != null) {
                                this.mql.a(this.mwy.dxv().mMicStatus, this.mwy.dxv().mFanItems, str, z2);
                            }
                            if (this.mrj != null && this.mrj.getVisibility() == 0) {
                                this.mrj.a(this.mwy.dxv().mFanItems, this.mwy.dxv().mMicStatus, str, z2, this.mwy.dxv().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mql != null) {
                                this.mql.e();
                            }
                            if (this.mrj != null && this.mrj.isShown()) {
                                this.mrj.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mql != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mql.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mql.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mru != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mru = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mpY != null && this.mpY.msQ != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mpY.msQ.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mpY.msQ.mInPKMode = true;
                                    this.mpY.msQ.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mpY.msQ.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mpY.msQ.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mpY.msQ.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mpY.msQ.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mpY.msQ.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mpY.msQ.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mpY.msQ.mMode = pkNotifyInfo.mMode;
                                    this.mpY.msQ.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dxZ() != null) {
                                        dxZ().g(true, this.mpY.msQ.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dwK().a) {
                                        if (!com.kascend.chushou.b.dwD().e) {
                                            com.kascend.chushou.b.dwD().e = true;
                                            g.F(this.mwz, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dwK().a(this.mwz, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.akK && this.mry != null) {
                                        this.mry.setVisibility(0);
                                    }
                                    this.mpY.msQ.mAction = 7;
                                    this.mpY.msQ.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mpY.msQ.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mpY.msQ.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mpY.msQ.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mpY.msQ.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mpY.msQ.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dxZ() != null) {
                                        dxZ().g(false, 0L);
                                        dxZ().b(this.mpY.msQ, true);
                                        dxZ().a(this.mpY.msQ.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.OG(this.mrz);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mpY.msQ.mInPKMode = false;
                                    this.mpY.msQ.mAction = 2;
                                    bd();
                                    if (dxZ() != null) {
                                        dxZ().c();
                                    }
                                    if (com.kascend.chushou.d.h.dwK().a) {
                                        if (!com.kascend.chushou.b.dwD().e) {
                                            com.kascend.chushou.b.dwD().e = true;
                                            g.F(this.mwz, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dwK().a(this.mwz, false);
                                        ak();
                                    }
                                    this.mpY.b = null;
                                    this.mpY.msQ = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.OG(this.mrz);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mpY.msQ.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mpY.msQ.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mpY.msQ.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mwy.dxv().mRoominfo.mRoomID) && this.mwy.dxv().mRoominfo.mRoomID.equals(this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dxZ() != null) {
                                        dxZ().a(this.mpY.msQ, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mpY.msQ.copyUpdate(pkNotifyInfo);
                                    if (dxZ() != null) {
                                        dxZ().a(this.mpY.msQ);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mpY.msQ.copyStop(pkNotifyInfo);
                                        if (dxZ() != null) {
                                            dxZ().A(this.mpY.msQ.mMaxFreeDuration, this.mpY.msQ.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mpY.msQ.copyResult(pkNotifyInfo);
                                    if (!this.cB && dxZ() != null) {
                                        int i5 = 1;
                                        if (this.mpY.msQ.destinyInfo != null && this.mpY.msQ.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dxZ().a(h.parseInt(this.mpY.msQ.mResult), h.parseLong(this.mpY.msQ.mvpUid), this.mpY.msQ.mvpAvatar, this.mpY.msQ.mvpNickname, this.mpY.msQ.mMaxFreeDuration, this.mpY.msQ.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mql != null) {
                if (LoginManager.Instance().islogined() && this.mwy != null && this.mwy.l()) {
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
                if (this.mwy == null || this.mwy.dxv() == null || this.mwy.dxv().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mwy.dxv().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dwK().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dwK().b().equals(next2.mUserID)) {
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
                this.mql.a(arrayList, true, false);
                this.mql.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mqi != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mqi.length) {
                    break;
                }
                if (this.mqi[i2] == 99 && this.mqj != null && this.mqj[i2] != null && (this.mqj[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mqj[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mrl.size() && this.mre != null) {
                if (i == 0) {
                    this.mre.setTagText(i2, new StringBuilder(this.mrl.get(i2).name).toString());
                    return;
                } else {
                    this.mre.setTagText(i2, this.mrl.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mwq != null) {
            if (z) {
                this.mwq.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mwq.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dxM() {
        if (this.mwj == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mwj.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
        this.ar = Math.min(gh.x, gh.y);
        this.mwD = (this.ar * this.mwz.getResources().getInteger(a.g.h_thumb_height_def)) / this.mwz.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dyr().getLayoutParams();
        layoutParams.height = this.mwD;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mws.getLayoutParams();
        layoutParams2.height = this.mwD;
        layoutParams2.width = this.ar;
        this.cF = this.mwD + this.mwz.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mwz, 54.0f);
        b(this.cF, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mwD);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dxN() {
        Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
        this.ar = Math.min(gh.x, gh.y);
        this.mwD = (this.ar * this.mwz.getResources().getInteger(a.g.h_thumb_height_def)) / this.mwz.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dyr().getLayoutParams();
        layoutParams.height = this.mwD;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mws.getLayoutParams();
        layoutParams2.height = this.mwD;
        layoutParams2.width = this.ar;
        this.cF = this.mwD + this.mwz.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mwz, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.cF, 10);
        k();
        if (!h.isEmpty(this.mqu)) {
            File ad = tv.chushou.zues.widget.fresco.a.ad(Uri.parse(this.mqu));
            if (ad != null && ad.exists()) {
                this.mws.setImageURI(Uri.fromFile(ad));
                this.mws.setVisibility(0);
                return;
            }
            this.mws.setVisibility(8);
            return;
        }
        this.mws.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ar(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mqr != null) {
            this.mqr.setVisibility(z ? 0 : 4);
        }
        if (this.mqs != null) {
            this.mqs.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ar(boolean z, boolean z2) {
        return k(z, z2, this.f);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        e.d("VideoPlayerEmbeddedScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e + ", onlyBackBtn = " + z3);
        this.f = z3;
        if (this.e == z) {
            return this.e;
        }
        if (this.mwA != null) {
            this.mwA.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mwz).f(true);
            if (!z3) {
                if (this.mqw.getVisibility() != 0 && z2) {
                    this.mqw.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mwr.setVisibility(0);
                } else {
                    this.mwr.setVisibility(8);
                }
                this.mqw.setVisibility(0);
            }
            PlayUrl dxw = this.mwy.dxw();
            if (dxw != null && "2".equals(dxw.mType)) {
                if (this.mwp != null) {
                    this.mwp.setVisibility(8);
                }
            } else if (this.mwp != null) {
                this.mwp.setVisibility(0);
            }
            if (this.mqn.getVisibility() != 0 && z2) {
                this.mqn.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_top_anim));
            }
            t(!z3);
            this.mqn.setVisibility(0);
            w(true);
            if (this.mwA != null) {
                this.mwA.A(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mwz).f(false);
            if (this.mwR != null) {
                this.mwR.dismiss();
            }
            if (this.mwS != null) {
                this.mwS.dismiss();
            }
            if (this.mqw.getVisibility() != 8 && z2) {
                this.mqw.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_bottom_anim));
            }
            this.mqw.setVisibility(8);
            if (this.mqn.getVisibility() != 8 && z2) {
                this.mqn.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_top_anim));
            }
            this.mqn.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dlz() {
        if (this.mxj == null || !this.mxj.isShown()) {
            return false;
        }
        this.mxj.d();
        return true;
    }

    public boolean dxO() {
        if (this.mrj == null || !this.mrj.isShown()) {
            return false;
        }
        this.mrj.a();
        return true;
    }

    public boolean dxP() {
        if (this.mrn == null || !this.mrn.b()) {
            return false;
        }
        this.mrn.a();
        return true;
    }

    public boolean dxQ() {
        if (this.cw && this.mxf != null) {
            if (this.mxf != null) {
                this.mxf.e();
            }
            if (this.mrC != null) {
                this.mrC.setText("");
            }
            if (this.akK == 2) {
                as(true, i());
                return true;
            }
            aZ();
            return true;
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mwj != null) {
            if (this.mrn == null) {
                this.mrn = (PopH5Menu) ((ViewStub) this.mwj.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mrn.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mrn.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            m(view, 0, this.mqn.getHeight() + this.mqn.getTop());
        } else if (id == a.f.btn_barrage) {
            n(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mwz, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                g.c(this.mwz, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mwy.a(false);
                a(false, false);
                ((VideoPlayer) this.mwz).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.mwz, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mpY == null || this.mpY.msQ == null || !this.mpY.msQ.mInPKMode) {
                ((VideoPlayer) this.mwz).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mqX) {
                f(this.mqK.getText().toString());
            } else {
                a(this.mqK.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dwK().c) {
                com.kascend.chushou.d.h.dwK().b(false);
                this.mqG.cancel();
                this.mqG.reset();
                this.mqF.clearAnimation();
                this.mqH.setVisibility(8);
            }
            l(view, 0, this.mwj.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mwz, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            k(view, x, this.mwj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mwy.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mwz, null) && this.mwy != null && this.mwy.mpG != null) {
                if (this.mqX) {
                    bg();
                    return;
                }
                if (this.mwy != null && this.mwy.mpG != null && this.mwy.mpG.count > 0) {
                    this.mqM.setVisibility(8);
                } else {
                    this.mqM.setVisibility(0);
                }
                this.mqX = true;
                this.mqU.setBackgroundResource(a.e.ic_trumpet_p);
                this.mqV.setVisibility(0);
                this.mqV.setSelected(true);
                this.mqV.setTextColor(Color.parseColor("#ff5959"));
                if (this.mqK != null) {
                    this.mqK.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mqW <= 9) {
                this.mqW++;
                this.mqT.setText(this.mqW + "");
            }
            dya();
        } else if (id == a.f.tv_cut_count) {
            if (this.mqW > 1) {
                this.mqW--;
                this.mqT.setText(this.mqW + "");
            }
            dya();
        } else if (id == a.f.tv_buy_head) {
            bf();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mrC.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mrC.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mrC);
                this.mxf.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mqK != null && this.mqD != null && this.mqJ != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dC(this.mqK);
                this.mqD.setVisibility(8);
                if (this.akK == 2) {
                    this.mqJ.setVisibility(0);
                }
            }
        } else if (this.mqD != null && this.mqJ != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
            if (this.akK == 2) {
                this.mqD.setVisibility(0);
            }
            this.mqJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dwK().c(roomToast.mToastContent);
            if (this.mrp == null) {
                aS();
            }
            if (this.mrq != null) {
                this.mrq.setText(roomToast.mToastContent);
            }
            if (!this.mrp.isShowing()) {
                if (this.mrg != null) {
                    this.mrp.showAtLocation(this.mrg, 85, 0, this.mwj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mrp != null) {
                                a.this.mrp.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mrp.dismiss();
        }
    }

    private void aS() {
        if (this.mrp == null) {
            View inflate = LayoutInflater.from(this.mwz).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mrq = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mrp = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 160.0f), -2);
            this.mrp.setFocusable(false);
            this.mrp.setOutsideTouchable(false);
            this.mrp.setAnimationStyle(a.j.gift_toast_style);
            this.mrp.update();
        }
    }

    private void k(View view, int i, int i2) {
        if (this.mwZ != null && this.mwZ.isShowing()) {
            this.mwZ.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
        if (this.mxw == null) {
            dyt();
        }
        if (!this.mxw.isShowing()) {
            this.mxw.showAtLocation(view, 83, i, i2);
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mwy.dxv().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mxw.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.mxz != null) {
            if (h.isEmpty(this.mxA)) {
                if (((VideoPlayer) this.mwz).q) {
                    this.mxz.bU(this.mwy != null ? this.mwy.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mxz.bU(this.mwy != null ? this.mwy.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mwz).q && this.mxA.size() == 2 && this.mxA.contains("4") && this.mxA.contains("2")) {
                this.mxz.bU(this.mwy != null ? this.mwy.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mxA.size() > 1 || !((VideoPlayer) this.mwz).q) {
                this.mxz.bU(this.mwy != null ? this.mwy.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mxA.get(0))) {
                this.mxz.bU(this.mwy != null ? this.mwy.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mxA.get(0))) {
                this.mxz.bU(this.mwy != null ? this.mwy.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mxA.get(0))) {
                this.mxz.bU(this.mwy != null ? this.mwy.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
        if (this.mwZ == null) {
            al();
            this.mwZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mwZ.isShowing() && this.akK == 2) {
            this.mwZ.showAtLocation(view, 83, i, this.mwz.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mwy.dxv().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mwZ.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mws != null) {
            this.mws.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                g.c(this.mwz, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.msP.getPlayState() == 4) {
                        e(true);
                        if (this.mwy.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mwy.a(false);
                        ((VideoPlayer) this.mwz).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.msP.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.msP.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                g.c(this.mwz, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mwy.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mwz).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                    this.ai = false;
                    we(true);
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
        if (this.mxn != null) {
            if (z) {
                this.mxn.setVisibility(0);
            }
            this.mxn.dJf();
            if (!z) {
                this.mxn.setVisibility(8);
            }
        }
        g.c(this.mwz, this.mwz.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mqx != null) {
                this.mqx.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mwt != null) {
                this.mwt.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mqx != null) {
            this.mqx.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mwt != null) {
                    this.mwt.setVisibility(8);
                }
            }
        }
    }

    private void dxR() {
        this.e = false;
        k(true, false, true);
    }

    private void dxS() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mqi[i];
        if (this.akK != i2 || this.mqm != i) {
            this.mqm = i;
            this.akK = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            aM();
            a(this.mwy != null ? this.mwy.mpH.get("1") : null);
            if (i2 == 2) {
                k();
                as(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.mwz, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            as(false, i3);
            v(false);
            b(false);
            if (this.mwZ != null && this.mwZ.isShowing()) {
                this.mwZ.dismiss();
            }
            if (i2 == 99) {
                if (this.mqj != null && this.mqj[i] != null && (this.mqj[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mqj[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mwz, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mwz, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mwz, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mwz, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.mqm = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.akK == 2) {
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
        ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mwA != null) {
            if (this.mqJ != null && this.mqJ.getVisibility() == 0) {
                u(false);
            }
            if (this.mwt != null && this.mwt.getVisibility() == 0) {
                this.f = true;
            }
            ar(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mql != null) {
            this.mql.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mql != null) {
            this.mql.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mql != null) {
            this.mql.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mql != null) {
            this.mql.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mrg != null) {
            int size = iconConfig.configs.size();
            this.mrg.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mwz).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mrg, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bU(str, a.e.icon_interact);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bU(str, a.e.ic_recharge_n);
                    } else if (configDetail.mTargetKey.equals("gift")) {
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
                    public void dq(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            a.this.b(configDetail2);
                        }
                    }
                });
                this.mrg.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mwy != null ? this.mwy.mpH : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mql != null) {
            this.mql.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mrd != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mrd.xW(a.c.kas_white);
            } else if (this.akK == 2) {
                this.mrd.bU(str, a.c.kas_white);
                if (this.mre != null) {
                    this.mre.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mrd.xW(a.c.kas_white);
                if (this.mre != null) {
                    this.mre.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mre != null) {
                    this.mre.setTextColor(a);
                    this.mre.setTabTextSelectColor(a2);
                    this.mre.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mqF != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mqF.xW(a.e.ic_hotwords_black_n);
            } else {
                this.mqF.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mqE != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dyF().a(str, this.mqE, a.e.player_skin_input);
            } else {
                this.mqE.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mqI != null) {
                this.mqI.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void a(int i) {
        if (this.mql != null) {
            this.mql.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void D() {
        if (this.mwz instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dxb = ((VideoPlayer) this.mwz).dxb();
            if (this.mxq == null) {
                this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxq.setVisibility(0);
            this.mxq.a(2, dxb);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mql != null) {
            this.mql.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mql != null) {
            this.mql.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(long j) {
        if (this.mql != null) {
            this.mql.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0728a
    public void c(int i) {
        if (this.mql != null) {
            this.mql.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mql != null && this.mwy != null) {
            this.mql.b(this.mwy.mpE);
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
    public class C0721a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0721a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mqi.length) {
                return null;
            }
            switch (a.this.mqi[i]) {
                case 1:
                    if (a.this.mqk == null) {
                        a.this.mqk = com.kascend.chushou.view.user.a.a(2, null, a.this.mwy.a, false, a.this.mwy.h, false);
                    }
                    a.this.mqj[i] = a.this.mqk;
                    return a.this.mqk;
                case 2:
                    if (a.this.mql == null) {
                        a aVar = a.this;
                        if (a.this.mpY != null && a.this.mpY.msQ != null) {
                            z = a.this.mpY.msQ.mInPKMode;
                        }
                        aVar.mql = com.kascend.chushou.player.ui.a.wf(z);
                    }
                    a.this.mqj[i] = a.this.mql;
                    return a.this.mql;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mwy != null && a.this.mwy.dxv() != null && !h.isEmpty(a.this.mrl)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mrl.get(i).url);
                        h5Options.a = a.this.mrl.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mqj[i] = a;
                    return a;
                default:
                    return null;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return a.this.Ik(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return a.this.mqi.length;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int lg(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int Il(int i) {
            return 0;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public String Im(int i) {
            return a.this.Ik(i);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public int In(int i) {
            return 1;
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.b
        public tv.chushou.zues.widget.psts.b Io(int i) {
            int dimensionPixelSize = a.this.mwz.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
            return new tv.chushou.zues.widget.psts.b((int) (0.5d * dimensionPixelSize), dimensionPixelSize, 0, 0);
        }

        @Override // tv.chushou.zues.widget.psts.PagerSlidingTabStrip.h
        public void Bx(int i) {
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            g.JO(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mqh <= 3000) {
            g.JO(a.i.str_too_fast);
            return false;
        } else {
            dxV();
            if (!com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a(((VideoPlayer) this.mwz).dwV().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mqh = System.currentTimeMillis();
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                a(this.mwy.dxv().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mwy.h);
            }
            g(this.b);
            if (!z && this.mqK != null) {
                this.mqK.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dxV();
            if (com.kascend.chushou.d.e.c(this.mwz, null) && LoginManager.Instance().getUserInfo() != null && this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                a(this.mwy.dxv().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mqK != null) {
                this.mqK.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mql != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mwy.dxv().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mwy.dxv().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mwz).mnT;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Qi(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mql.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mql.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.mql != null) {
            this.mql.e();
        }
        if (this.mrj != null && this.mrj.isShown()) {
            this.mrj.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dxT() {
        super.dxT();
        if (this.mwz instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mwy != null) {
            this.mwy.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mrh);
        if (this.mwz != null) {
            if (this.mrh || "10004".equals(((VideoPlayer) this.mwz).t)) {
                this.mrh = true;
                if (this.mwy != null) {
                    this.mwy.f = null;
                    if (this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                        this.mwy.dxv().mRoominfo.mGameId = null;
                    }
                }
                aP();
                return;
            }
            this.mrh = true;
            if (this.mwz != null) {
                ((VideoPlayer) this.mwz).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mrh = false;
        if (this.mqv != null) {
            this.mqv.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mrh = false;
        if (this.mqv != null) {
            this.mqv.setVisibility(8);
        }
        super.i(z);
    }

    private void dxU() {
        aN();
        if (i()) {
            aY();
            ap();
            return;
        }
        aP();
    }

    private void aX() {
    }

    private void aY() {
        e.i("VideoPlayerEmbeddedScreenFragment", "on Complete");
        dyr().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mxn != null) {
            this.mxn.setVisibility(0);
        }
        if (this.mpU != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mpU.d();
        }
        if (this.mqD != null) {
            this.mqD.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mqs.setVisibility(0);
            this.mqs.setOnClickListener(this);
        } else {
            this.mqs.setVisibility(8);
        }
        this.mqx.setVisibility(0);
        this.mqt.setVisibility(0);
        this.mwq.setVisibility(0);
        if (this.p) {
            this.mwr.setVisibility(0);
        } else {
            this.mwr.setVisibility(8);
        }
        aX();
        as(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mxq != null && this.mxq.a(i, keyEvent)) {
                return true;
            }
            if (this.mrn != null && this.mrn.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mro != null && this.mro.onKeyDown(i, keyEvent)) || aD()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mrD != null && this.mrD.getVisibility() == 0 && b(motionEvent, this.mrD)) {
                this.mrD.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mrC);
                return true;
            } else if (this.cw && this.mrD != null && this.mrD.getVisibility() == 8 && g(this.mxf.b, motionEvent)) {
                dxQ();
                return true;
            } else if (this.mrn != null && this.mrn.b() && g(this.mrn, motionEvent)) {
                this.mrn.a();
                return true;
            } else if (this.mro != null && this.mro.b() && g(this.mro, motionEvent)) {
                this.mro.a();
                return true;
            } else if (b(motionEvent, this.mqJ)) {
                return dxV();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dxV() {
        boolean z;
        b(this.cF, 10);
        boolean z2 = false;
        if (this.mqY != null && this.mqY.getVisibility() == 0) {
            this.mqY.setVisibility(8);
            this.mqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mra) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
            this.mqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mqJ == null || this.mqJ.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mqX) {
                bg();
            }
            this.mqJ.setVisibility(8);
            z = true;
        }
        if (this.akK == 2) {
            RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mqD != null && a.this.akK == 2) {
                        a.this.mqD.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean aD() {
        if (dxV()) {
            return true;
        }
        if (this.mwZ == null || !this.mwZ.isShowing()) {
            return dxQ() || dxO() || dlz();
        }
        this.mwZ.dismiss();
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
    public void aZ() {
        this.mqD.setVisibility(8);
        this.mqJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(boolean z, boolean z2) {
        if (this.mqD != null) {
            if (z) {
                if (this.mqD.getVisibility() != 0) {
                    this.mqD.setVisibility(0);
                    this.mqD.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_bottom_anim));
                }
            } else if (this.mqD.getVisibility() != 4) {
                this.mqD.setVisibility(4);
                this.mqD.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mqv != null) {
            this.mqv.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dxW() {
        return this.mrs;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dyq()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mwy != null) {
                        this.mwy.f = null;
                        this.mwy.dxv().mRoominfo.mGameId = null;
                    }
                    aP();
                    return;
                }
                g.JO(a.i.str_getvideosource_failed);
            }
            we(false);
            o(false);
            a(false, i != 404);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mwy != null && this.mwy.dxw() != null) {
            a(this.mwy.dxw());
        }
        this.p = false;
        if (this.mwy == null || this.mwy.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mwy.f.size()) {
                if (!"2".equals(this.mwy.f.get(i2).mType)) {
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
        if (this.mql != null) {
            this.mql.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dyq()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mqy != null && this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                this.mqy.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mwy.dxv().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dyq() && !this.cB && (c = c(1, -1)) >= 0 && c < this.mrl.size() && this.mrf != null) {
            this.mrf.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dyq() && !this.cB) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mwz, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dxc = ((VideoPlayer) this.mwz).dxc();
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(2, dxc);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dxd = ((VideoPlayer) this.mwz).dxd();
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(2, dxd);
            } else if (bVar.a == 9) {
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mqY != null) {
            this.mqY.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dyq() && !this.cB) {
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
        if (!dyq() && this.mwy != null) {
            String str = this.mwy.a;
            RoomInfo dxz = this.mwy.dxz();
            if (dxz != null && mVar.a(dxz.mCreatorUID, str)) {
                dxz.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.akK == 2) {
            RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dyq()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mqK != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mqK);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxX() {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
            if (this.mri == null) {
                this.mri = new f(getActivity());
            }
            this.mri.a(this.mwy.dxv().mRoominfo);
            if (!this.mri.isShowing()) {
                this.mri.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mql != null) {
            this.mql.d();
        }
    }

    private void ds(View view) {
        this.mqz = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mqA = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mqA.setText(new tv.chushou.zues.widget.a.c().J(this.mwz, a.e.videoplayer_4g_video).append("  ").append(this.mwz.getString(a.i.videoplayer_4g_video)));
        this.mqB = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mqB.setText(new tv.chushou.zues.widget.a.c().J(this.mwz, a.e.videoplayer_4g_audio).append("  ").append(this.mwz.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mqz.setVisibility(8);
                    ((VideoPlayer) a.this.mwz).c(a.this.mqC);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mqz.setVisibility(8);
                    ((VideoPlayer) a.this.mwz).d(a.this.mqC);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dwD().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mqA.setOnClickListener(onClickListener);
        this.mqB.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mwy != null && !h.isEmpty(this.mwy.f)) {
            f(this.mwy.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mqC = z;
            this.p = false;
            if (this.mwy != null && this.mwy.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mwy.f.size()) {
                        break;
                    } else if (!"2".equals(this.mwy.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mqz != null) {
                this.mqz.setVisibility(0);
                this.mqA.setVisibility(0);
                this.mqB.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mqz != null) {
            this.mqz.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mrv == null) {
                this.mrv = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dyq()) {
                            a.this.dxY();
                        }
                    }
                };
                if (this.mwA != null) {
                    this.mwA.e(this.mrv, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mrv != null && this.mwA != null) {
            this.mwA.N(this.mrv);
            this.mrv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxY() {
        if (LoginManager.Instance().islogined() && this.mql != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mwz, "显示双击666_num", null, new Object[0]);
            if (this.mwy != null) {
                this.mwy.b(false);
            }
            d(false);
            this.mql.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mwj != null) {
            if (this.mro == null) {
                this.mro = (InteractionView) ((ViewStub) this.mwj.findViewById(a.f.view_interaction)).inflate();
                this.mro.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mro.a();
                    }
                });
            }
            if (this.mro != null) {
                this.mro.b(configDetail);
                this.mro.c();
                this.mro.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dJS()) {
                g.F(this.mwz, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mwz, null) && (this.mwz instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwy != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwz, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwy != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwz, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mwz, configDetail.mUrl, this.mwz.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mwz, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
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
        if (this.cw) {
            dxQ();
            return;
        }
        if (this.mwz.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwy.dxv().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mwz != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mpY == null) {
                this.mpY = new com.kascend.chushou.player.e.a();
            }
            this.mpY.b = str;
            this.mpY.msQ.copy(pkNotifyInfo);
            if (this.mpY.msQ.mAction == 6) {
                this.mpY.msQ.mInPKMode = true;
                this.u = this.mpY.msQ.mPkId;
            } else if (this.mpY.msQ.mAction == 7 || (this.mpY.msQ.mMode == 1 && this.mpY.msQ.mAction == 5)) {
                this.mpY.msQ.mInPKMode = true;
                this.u = this.mpY.msQ.mPkId;
                if (dxZ() != null) {
                    if (2 == this.akK && this.mry != null) {
                        this.mry.setVisibility(0);
                    }
                    dxZ().b(this.mpY.msQ, false);
                    dxZ().a(this.mpY.msQ.mMode, "1");
                    if (this.mpY.msQ.mAction == 5 && this.mpY.msQ.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mpY.msQ.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mpY.msQ.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mpY.msQ.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mpY.msQ.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mpY.msQ.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dxZ().a(this.mpY.msQ);
                        if (this.mpY.msQ.destinyInfo == null || this.mpY.msQ.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dxZ().a(parseInt, this.mpY.msQ.mPkUpdateInfo.remainDuration, j, this.mpY.msQ.mMode, i);
                    }
                    if (!h.isEmpty(this.mpY.msQ.mPkUpdateInfo.specialMomentList) && dxZ() != null) {
                        dxZ().a(this.mpY.msQ, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.OG(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mpY.msQ.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.OG(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.mpY != null && this.mpY.msQ != null) {
            if (this.mpY.msQ.mInPKMode) {
                this.y.setText(this.mpY.msQ.mPkUserNickname);
                this.mqa.setVisibility(0);
                if (this.mwp != null) {
                    this.mwp.setEnabled(false);
                }
                if (this.mwr != null) {
                    this.mwr.setEnabled(false);
                    return;
                }
                return;
            }
            this.mqa.setVisibility(8);
            if (this.mwp != null) {
                this.mwp.setEnabled(true);
            }
            if (this.mwr != null) {
                this.mwr.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dxZ() {
        if (this.mwz == null || this.mwj == null || this.mry == null) {
            return null;
        }
        if (this.mpZ == null) {
            if (this.mrx == null) {
                this.mrx = ((ViewStub) this.mwj.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mpZ = new com.kascend.chushou.player.e.b();
            this.mpZ.a(this.mry, this.mrx, (View) null, this.mwz, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dJy()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mwy != null) {
                        append.append(a.this.mwy.dxz().mRoomID);
                    }
                    if (a.this.mpY != null && a.this.mpY.msQ != null) {
                        append.append("&mode=").append(a.this.mpY.msQ.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mwz, append.toString());
                }
            });
        }
        return this.mpZ;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mqV != null && this.mwy != null && this.mwy.mpG != null) {
            this.mqV.setText(tv.chushou.zues.utils.b.JN(this.mwy.mpG.count));
            this.mqV.setVisibility(0);
            if (this.mwy.mpG.count < 1) {
                bg();
            }
            if (this.mqN != null) {
                this.mqN.setText(this.mwy.mpG.primaryName);
            }
            if (this.mqO != null) {
                this.mqO.setText(this.mwy.mpG.desc);
            }
            dya();
        }
    }

    public void dya() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mqW * h.parseLong(this.mwy.mpG.point)));
        if (this.mqQ != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mwz.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mwz, a.e.icon_coin_new);
            cVar.append(this.mwz.getString(a.i.str_buy_count_coin2));
            this.mqQ.setText(cVar);
        }
    }

    private void bf() {
        if (com.kascend.chushou.d.e.c(this.mwz, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mqW);
        }
    }

    private void v(boolean z) {
        if (this.mwj != null && this.mry != null) {
            if (z) {
                if (this.mpY != null && this.mpY.msQ != null && this.mpY.msQ.mInPKMode) {
                    this.mry.setVisibility(0);
                    return;
                }
                return;
            }
            this.mry.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mwj != null && this.mqd != null) {
            if (z) {
                if (this.E && 2 == this.akK) {
                    this.mqd.setVisibility(0);
                    return;
                }
                return;
            }
            this.mqd.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.mpY != null && this.mpY.msQ != null && this.mpY.msQ.mInPKMode && this.mqa != null) {
                this.mqa.setVisibility(0);
            }
        } else if (this.mqa != null) {
            this.mqa.setVisibility(8);
        }
    }

    private void bg() {
        this.mqX = false;
        this.mqU.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mwy != null && this.mwy.mpG != null) {
            if (this.mwy.mpG.count < 1) {
                this.mqV.setVisibility(8);
            } else {
                this.mqV.setVisibility(0);
                this.mqV.setSelected(false);
                this.mqV.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mqM.setVisibility(8);
        if (this.mqK != null) {
            this.mqK.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mqI != null) {
            this.mqI.performClick();
        }
    }

    public boolean dyb() {
        return this.akK == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.mrJ = true;
        if (this.mwj != null && com.kascend.chushou.b.dwD().d == 0) {
            this.mrt = tv.chushou.zues.utils.systemBar.b.gl(getActivity());
            if (!z) {
                View findViewById = this.mwj.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.mrt = tv.chushou.zues.utils.systemBar.b.gl(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.mrt);
            View findViewById2 = this.mwj.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.mrt);
            findViewById2.requestLayout();
        }
    }
}
