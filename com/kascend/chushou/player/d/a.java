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
    private RecommendView mqA;
    private TextView mqD;
    private RelativeLayout mqE;
    private TextView mqF;
    private TextView mqG;
    private boolean mqH;
    private RelativeLayout mqI;
    private View mqJ;
    private FrescoThumbnailView mqK;
    private AnimationSet mqL;
    private ImageView mqM;
    private TextView mqN;
    private RelativeLayout mqO;
    private PastedEditText mqP;
    private TextView mqQ;
    private LinearLayout mqR;
    private TextView mqS;
    private TextView mqT;
    private TextView mqU;
    private TextView mqV;
    private TextView mqW;
    private TextView mqX;
    private TextView mqY;
    private ImageView mqZ;
    private int[] mqn;
    private Fragment[] mqo;
    private ImageView mqt;
    private MarqueeTextView mqu;
    private MarqueeTextView mqv;
    private ImageView mqw;
    private ImageView mqx;
    private ImageButton mqy;
    public String mqz;
    private Runnable mrA;
    private View mrC;
    private LivePKBarUserValue mrD;
    private String mrE;
    private TextView mrF;
    private ImageView mrG;
    private EditText mrH;
    private View mrI;
    private View mrJ;
    private View mrK;
    private String mrN;
    private TextView mra;
    private KPSwitchPanelLinearLayout mrd;
    private ImageView mre;
    private c mrg;
    private d.a mrh;
    private FrescoThumbnailView mri;
    private PagerSlidingTabStrip mrj;
    private KasViewPager mrk;
    private LinearLayout mrl;
    private f mrn;
    private ViewMicPerson mro;
    public ArrayList<RoomTab> mrq;
    private PopH5Menu mrs;
    private InteractionView mrt;
    private PopupWindow mru;
    private TextView mrv;
    private GiftAnimationLayout mrw;
    private com.kascend.chushou.player.b.a mrx;
    private long mqm = 0;
    private com.kascend.chushou.view.user.a mqp = null;
    private com.kascend.chushou.player.ui.a mqq = null;
    private int akQ = -1;
    private int mqr = 0;
    private View mqs = null;
    private View mqB = null;
    private ImageButton mqC = null;
    private int mrb = 1;
    private boolean mrc = false;
    private boolean mrf = false;
    private boolean cw = false;
    private boolean mrm = false;
    private boolean mrp = false;
    private boolean cB = false;
    private boolean mrr = true;
    private int cK = 0;
    private int mry = 0;
    private int mrz = -1;
    private final Rect mrB = new Rect();
    private boolean mrL = false;
    private C0742a mrM = null;
    private boolean da = false;
    private boolean mrO = false;

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mqz = getArguments().getString("mCover");
        this.mrr = getArguments().getBoolean("mInitViewAsync", false);
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mwo = layoutInflater.inflate(a.h.videoplayer_root_view_p, viewGroup, false);
        return this.mwo;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dyn()) {
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
        if (this.mxk != null) {
            this.mxk.b();
        }
        if (this.mwE != null && (this.mwE instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwE).wa(true);
            ((VideoPlayer) this.mwE).z();
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
        this.mrb = 1;
        this.mrc = false;
        U();
        if (this.mwF != null) {
            this.mwF.ca(null);
            this.mwF = null;
        }
        if (this.mqA != null) {
            dyo().removeAllViews();
            this.mqA = null;
        }
        this.c = null;
        this.mpX = null;
        tv.chushou.zues.a.a.cb(this);
        this.mrj = null;
        this.mrk = null;
        this.mqq = null;
        this.mqp = null;
        if (this.mqo != null) {
            for (int i = 0; i < this.mqo.length; i++) {
                this.mqo[i] = null;
            }
        }
        this.mqo = null;
        if (this.mqP != null) {
            this.mqP.addTextChangedListener(null);
            this.mqP.setOnTouchListener(null);
            this.mqP.setOnEditorActionListener(null);
            this.mqP = null;
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mwE, this.mrg);
        if (this.mwE != null && (this.mwE instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwE).dwX();
        }
        this.mrh = null;
        this.mrg = null;
        if (this.mro != null) {
            this.mro.b();
            this.mro = null;
        }
        if (this.mru != null) {
            this.mru.dismiss();
        }
        if (this.mrx != null) {
            this.mrx.a();
            this.mrx = null;
            this.mrw = null;
        }
        super.d();
        e.e("VideoPlayerEmbeddedScreenFragment", "release ---------->");
    }

    private void c(View view) {
        a(view);
        b();
        c();
        this.mrD = (LivePKBarUserValue) this.mwo.findViewById(a.f.live_pk_bar_user);
        this.mwx = (ImageView) view.findViewById(a.f.htvVideoPreview);
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mrL) {
            this.mrL = true;
            if (this.mrJ == null) {
                this.mrJ = this.mwo.findViewById(a.f.vs_async_view);
                this.mrJ = ((ViewStub) this.mrJ).inflate();
            }
            if (this.mrK == null) {
                this.mrK = this.mwo.findViewById(a.f.vs_async_notification_view);
                this.mrK = ((ViewStub) this.mrK).inflate();
            }
            this.mqi = (VoiceInteractionView) this.mwo.findViewById(a.f.voiceInteractiveView);
            t();
            dr(this.mwo);
            dlr();
            ((VideoPlayer) this.mwE).q();
            this.mqd = new com.kascend.chushou.player.e.a();
        }
    }

    private void dr(View view) {
        this.mri = (FrescoThumbnailView) view.findViewById(a.f.iv_tabs_bg);
        this.mrj = (PagerSlidingTabStrip) view.findViewById(a.f.tabs);
        this.mrk = (KasViewPager) view.findViewById(a.f.vp_main);
        aH();
        dxE();
        aN();
        if (this.mwD != null) {
            I();
            a(this.mwD.mpI, this.mwD.mpM);
        }
        this.boT = 0;
        this.mxp = 0L;
        this.mxl = (RoundProgressBar) this.mwo.findViewById(a.f.roundProgressBar);
        this.mxm = (TextView) this.mwo.findViewById(a.f.tv_paonum);
        this.mxn = (FrescoThumbnailView) this.mwo.findViewById(a.f.iv_paoicon);
        this.mxu = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.a.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                a.this.cw = false;
                if (a.this.akQ == 2) {
                    a.this.as(true, a.this.i());
                } else {
                    a.this.aZ();
                }
                a.this.b(a.this.cF, 10);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                a.this.cw = true;
                if (a.this.akQ == 2) {
                    a.this.as(false, a.this.i());
                } else {
                    a.this.aZ();
                }
                if (a.this.mxk != null) {
                    a.this.mxk.measure(0, 0);
                    int statusBarHeight = (((tv.chushou.zues.utils.a.fU(a.this.mwE).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(a.this.mwE)) - a.this.mxk.getMeasuredHeight()) - tv.chushou.zues.utils.a.dip2px(a.this.mwE, 14.0f)) - (tv.chushou.zues.utils.a.dip2px(a.this.mwE, 54.0f) * 2);
                    if (statusBarHeight < a.this.cF) {
                        a.this.b(statusBarHeight, 10);
                    }
                }
            }
        };
        this.mxo = (PaoGuideView) this.mwo.findViewById(a.f.rlPaoGuideView);
        this.mro = (ViewMicPerson) this.mwo.findViewById(a.f.rl_mic_person_view);
    }

    private void aG() {
        this.msU = ((VideoPlayer) this.mwE).dwQ();
        this.mwD = ((VideoPlayer) this.mwE).dwT();
        ds(this.mwo);
        this.cK = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
        this.mry = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (com.kascend.chushou.b.dwB().d == 0 && this.mry > 0) {
            View findViewById = this.mwo.findViewById(a.f.videoplayer_content);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mry);
        }
        dxK();
        dxI();
        if (!this.mrr) {
            Q();
        }
        aO();
        a();
        if (this.c == null) {
            this.mpX = new d.a();
            this.c = new GestureDetector(this.mwE, this.mpX);
        }
        this.mpZ = ((VideoPlayer) this.mwE).dwU();
        this.mpZ.a(this);
        if (this.mrx != null) {
            this.mrx.a();
            this.mrx = null;
        }
        this.mrw = (GiftAnimationLayout) this.mwo.findViewById(a.f.ll_gift_animation);
        this.mrw.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        if (this.mwD != null) {
            this.mrx = new com.kascend.chushou.player.b.a(this.mwE.getApplicationContext(), this.mrw);
            this.mrx.a(this.mwD);
        }
        if (this.a == null) {
            this.a = (ImageButton) this.mwo.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mwy = (PlayerErrorView) this.mwo.findViewById(a.f.view_net_error_msg);
        this.mwy.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dxH();
        dxO();
        if (this.mwD.dxu() != null) {
            a(this.mwD.dxu());
        }
        FullRoomInfo dxt = this.mwD.dxt();
        if (dxt != null) {
            dxR();
            if (i()) {
                this.ak = false;
                we(true);
                this.mwF.JF(8);
            }
            this.mqD.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dxt.mRoominfo.mOnlineCount)));
            return;
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        this.mqs.setVisibility(0);
        this.ak = false;
        we(true);
        this.mwF.JF(8);
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        ((VideoPlayer) this.mwE).n();
        if (this.mwD != null && !h.isEmpty(this.mwD.mpK)) {
            b(this.mwD.mpK);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        RoomToast roomToast;
        com.kascend.chushou.player.e.a dxe;
        aH();
        k();
        FullRoomInfo dxt = this.mwD.dxt();
        if (dxt != null) {
            if (dxt.mRoominfo != null) {
                this.mqD.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(dxt.mRoominfo.mOnlineCount)));
                this.mrE = dxt.mRoominfo.mRoomID;
            }
            dxR();
            if (!h.isEmpty(dxt.mRoomToastList)) {
                Iterator<RoomToast> it = dxt.mRoomToastList.iterator();
                while (it.hasNext()) {
                    roomToast = it.next();
                    if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                        break;
                    }
                }
            }
            roomToast = null;
            if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dwI().j())) {
                a(roomToast);
            }
            if (LoginManager.Instance().islogined() && this.mwD != null && this.mwD.l()) {
                d(true);
            }
            if (this.mwE != null && (this.mwE instanceof VideoPlayer) && (dxe = ((VideoPlayer) this.mwE).dxe()) != null) {
                e.d("guohe", "VideoPlayerEmbeddedScreenFragment.initFragmentAfterApi(): aaa");
                a(dxe.msV, dxe.b);
            }
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.11
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(a.this.mrl);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void aH() {
        boolean z = true;
        if (this.mwD == null || this.mwD.dxt() == null || this.mwD.dxt().mRoominfo == null || h.isEmpty(this.mwD.dxt().mRoomTabs)) {
            this.mrp = false;
            this.mqo = new Fragment[2];
            this.mqn = new int[2];
            this.mqn[0] = 2;
            this.mqn[1] = 1;
            return;
        }
        this.mrp = true;
        this.mrq = new ArrayList<>();
        Iterator<RoomTab> it = this.mwD.dxt().mRoomTabs.iterator();
        while (it.hasNext()) {
            RoomTab next = it.next();
            if (next.type == 2 || next.type == 1 || next.type == 99) {
                this.mrq.add(next);
            }
        }
        if (this.mrq.size() >= 2 && this.mqn != null && this.mqn.length >= 2 && this.mrq.get(0).type == this.mqn[0] && this.mrq.get(1).type == this.mqn[1]) {
            z = false;
        }
        this.mqo = new Fragment[this.mrq.size()];
        this.mqn = new int[this.mrq.size()];
        for (int i = 0; i < this.mrq.size(); i++) {
            this.mqn[i] = this.mrq.get(i).type;
        }
        if (z) {
            this.mrM = new C0742a(getChildFragmentManager());
            this.mrk.setAdapter(this.mrM);
        }
    }

    private void dxE() {
        this.mqO = (RelativeLayout) this.mwo.findViewById(a.f.rl_edit_bar);
        this.mqK = (FrescoThumbnailView) this.mwo.findViewById(a.f.btn_hotword);
        this.mqK.xW(a.e.ic_hotwords_black_n);
        this.mqK.setOnClickListener(this);
        this.mqM = (ImageView) this.mwo.findViewById(a.f.iv_task_badge);
        this.mqL = (AnimationSet) AnimationUtils.loadAnimation(this.mwE, a.C0736a.anim_hotword);
        this.mqL.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.d.a.13
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dwI().c) {
                    a.this.mqK.clearAnimation();
                    a.this.mqK.startAnimation(a.this.mqL);
                }
            }
        });
        if (com.kascend.chushou.d.h.dwI().c) {
            this.mqK.startAnimation(this.mqL);
            this.mqM.setVisibility(0);
        }
        this.mqN = (TextView) this.mwo.findViewById(a.f.tv_bottom_input);
        this.mqN.setOnClickListener(this);
        this.mxE = (FrescoThumbnailView) this.mwo.findViewById(a.f.ll_btn_set);
        this.mxE.setOnClickListener(this);
        this.mrl = (LinearLayout) this.mwo.findViewById(a.f.ll_bottom_all_button);
        this.mqI = (RelativeLayout) this.mwo.findViewById(a.f.rl_bottom_input);
        this.mqJ = this.mwo.findViewById(a.f.ll_bottom_input);
        this.mqI.setVisibility(8);
        this.mqP = (PastedEditText) this.mwo.findViewById(a.f.et_bottom_input);
        this.mqP.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.14
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mqQ.setEnabled(editable.length() > 0);
            }
        });
        this.mqP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    a.this.onClick(a.this.mqQ);
                    return true;
                }
                return true;
            }
        });
        this.mqP.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.d.a.16
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return a.this.m(a.this.mqP);
                }
                return false;
            }
        });
        this.mre = (ImageView) this.mwo.findViewById(a.f.iv_btn_emoji);
        this.mre.setVisibility(8);
        this.mqQ = (TextView) this.mwo.findViewById(a.f.tv_btn_send);
        this.mqQ.setOnClickListener(this);
        this.mrd = (KPSwitchPanelLinearLayout) this.mwo.findViewById(a.f.chat_extended_container);
        if (com.kascend.chushou.b.dwB().d == 0) {
            this.mrd.setUseStatusBar(true);
        }
        this.mqR = (LinearLayout) this.mwo.findViewById(a.f.head_trumpet);
        this.mqR.setVisibility(8);
        this.mqR.setOnClickListener(this);
        this.mqS = (TextView) this.mwo.findViewById(a.f.tv_primary_name);
        this.mqT = (TextView) this.mwo.findViewById(a.f.tv_primary_desc);
        this.mqW = (TextView) this.mwo.findViewById(a.f.tv_cut_count);
        this.mqW.setOnClickListener(this);
        this.mqY = (TextView) this.mwo.findViewById(a.f.tv_head_count);
        this.mqY.setText(this.mrb + "");
        this.mqX = (TextView) this.mwo.findViewById(a.f.tv_plus_count);
        this.mqX.setOnClickListener(this);
        this.mqV = (TextView) this.mwo.findViewById(a.f.tv_buy_count_coin);
        this.mqU = (TextView) this.mwo.findViewById(a.f.tv_buy_head);
        this.mqU.setOnClickListener(this);
        this.mqZ = (ImageView) this.mwo.findViewById(a.f.iv_trumpet_select);
        this.mqZ.setOnClickListener(this);
        this.mra = (TextView) this.mwo.findViewById(a.f.tv_trumpet_have_count);
        this.mrc = false;
        this.mqZ.setBackgroundResource(a.e.ic_trumpet_n);
        this.mra.setVisibility(8);
        dxG();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mrd, this.mre, this.mqP, new a.InterfaceC0862a() { // from class: com.kascend.chushou.player.d.a.17
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0862a
            public void wb(boolean z) {
                if (a.this.mre != null) {
                    if (!z) {
                        a.this.mre.setImageResource(a.e.cs_emoji_normal);
                        return;
                    }
                    if (com.kascend.chushou.b.dwB().d == 0) {
                        a.this.mrd.setDirectVisibility(0);
                    }
                    a.this.mre.setImageResource(a.e.cs_keyboard_normal);
                }
            }
        });
        this.mrh = new d.a() { // from class: com.kascend.chushou.player.d.a.18
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wc(boolean z) {
                if (a.this.mrO) {
                    a.this.mrO = false;
                    return;
                }
                a.this.mrf = z;
                if (z) {
                    a.this.mre.setImageResource(a.e.cs_emoji_normal);
                    a.this.dxF();
                    return;
                }
                if (a.this.mrI != null && a.this.mrI.getVisibility() == 0) {
                    a.this.mrI.setVisibility(8);
                }
                if (a.this.cw) {
                    a.this.mxk.setVisibility(0);
                }
                if (a.this.mwE != null && (a.this.mwE instanceof VideoPlayer)) {
                    ((VideoPlayer) a.this.mwE).wa(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
            }
        };
        this.mrg = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mrd, this.mrh, ((VideoPlayer) this.mwE).dwY());
        ((VideoPlayer) this.mwE).h(((VideoPlayer) this.mwE).dwY());
        this.mrI = this.mwo.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mrF = (TextView) this.mwo.findViewById(a.f.btn_room_search);
        this.mrG = (ImageView) this.mwo.findViewById(a.f.iv_room_emoji_delete);
        this.mrH = (EditText) this.mwo.findViewById(a.f.et_room_emoji_search);
        this.mrH.setImeOptions(3);
        this.mrH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.a.12
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    a.this.onClick(a.this.mrF);
                    return true;
                }
                return false;
            }
        });
        this.mrH.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.d.a.19
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                a.this.mrF.setEnabled(editable.length() > 0);
                a.this.mrG.setVisibility(editable.length() <= 0 ? 8 : 0);
                a.this.mxk.setEmojiSearchText(editable.toString());
            }
        });
        this.mrF.setOnClickListener(this);
        this.mrG.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aq(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dC(this.mrH);
            this.mrI.setVisibility(0);
            this.mrH.requestFocus();
        } else {
            this.mrI.setVisibility(8);
        }
        if (z2) {
            this.mrH.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxF() {
        int statusBarHeight = ((((tv.chushou.zues.utils.a.fU(this.mwE).y - tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE)) - tv.chushou.zues.widget.kpswitch.b.d.gh(this.mwE)) - tv.chushou.zues.utils.a.dip2px(this.mwE, 14.0f)) - this.mwE.getResources().getDimensionPixelSize(a.d.rl_bottom_input_height)) - (tv.chushou.zues.utils.a.dip2px(this.mwE, 54.0f) * 2);
        if (statusBarHeight < this.cF) {
            b(statusBarHeight, 10);
        }
    }

    private void dxG() {
    }

    private void dxH() {
        this.mwF = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.a.20
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            a.this.ar(false, true);
                            break;
                        case 5:
                            TextView textView = (TextView) a.this.mwo.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = a.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(a.this.mwE.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                a.this.mwF.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            a.this.mwF.removeMessages(8);
                            if (!a.this.aj) {
                                a.this.mwF.A(8, 100L);
                                break;
                            } else {
                                a.this.y();
                                break;
                            }
                        case 11:
                            a.this.a(a.this.mwF);
                            break;
                        case 12:
                            a.this.b(a.this.mwF);
                            break;
                        case 17:
                            a.this.dyp();
                            break;
                        case 18:
                            a.this.dlq();
                            break;
                        case 19:
                            a.this.mwC.setVisibility(8);
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
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mrq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mrq.size()) {
                    if (!h.isEmpty(this.mrq.get(i2).notifyIcon)) {
                        this.mrj.bA(i2, this.mrq.get(i2).notifyIcon);
                        this.mrj.Kf(i2);
                    } else if (this.mrq.get(i2).notify == 1) {
                        this.mrj.Ke(i2);
                        this.mrj.Kd(i2);
                    } else {
                        this.mrj.Kd(i2);
                        this.mrj.Kf(i2);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i, int i2) {
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mrq)) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.mrq.size()) {
                    if (this.mrq.get(i4).type == i) {
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
        if (this.mwD == null || this.mwD.dxt() == null || this.mwD.dxt().mRoominfo == null || h.isEmpty(this.mrq)) {
            if (i == 1) {
                return this.mwE.getString(a.i.str_roominfo_title);
            }
            if (i == 0) {
                return this.mwE.getString(a.i.str_banrrageinfo_title);
            }
        } else if (i >= 0 && i < this.mrq.size()) {
            return this.mrq.get(i).name;
        }
        return null;
    }

    private void d(int i, int i2) {
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mrq) && i < this.mrq.size()) {
            this.mrq.get(i).notify = i2;
        }
    }

    private void a(int i, String str) {
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mrq) && i < this.mrq.size()) {
            this.mrq.get(i).notifyIcon = str;
        }
    }

    private void aN() {
        if (this.mrk != null && this.mrj != null && this.mqn != null) {
            this.mqq = null;
            if (this.mqo != null) {
                for (int i = 0; i < this.mqo.length; i++) {
                    this.mqo[i] = null;
                }
            }
            if (this.mrM == null) {
                this.mrM = new C0742a(getChildFragmentManager());
                this.mrk.setAdapter(this.mrM);
            } else {
                this.mrM.notifyDataSetChanged();
            }
            this.mrk.setOffscreenPageLimit(this.mqn.length);
            this.mrj.c(this.mrk);
            this.mrj.setOnPageChangeListener(this);
            this.mrj.notifyDataSetChanged();
            this.mrj.setVisibility(0);
            this.mrk.setVisibility(0);
            if (!this.mrp) {
                this.akQ = 2;
                this.mrk.setCurrentItem(c(2, 0));
                this.mqI.setVisibility(0);
            } else {
                if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                    if (!h.isEmpty(this.mwD.dxt().mRoominfo.mGameName)) {
                        this.mqv.setText(this.mwD.dxt().mRoominfo.mGameName);
                    } else {
                        this.mqv.setText(this.mwE.getString(a.i.no_online_game_name));
                    }
                    this.mqu.setText(this.mwD.dxt().mRoominfo.mName);
                } else {
                    this.mqv.setText(this.mwE.getString(a.i.no_online_game_name));
                }
                aM();
                if (i()) {
                    dxP();
                    if (this.mrk != null) {
                        this.akQ = 2;
                        int c = c(2, 0);
                        this.mrk.setCurrentItem(c);
                        this.mrj.setSelectItem(c);
                    }
                } else if (this.mrk != null) {
                    this.akQ = 1;
                    int c2 = c(1, 1);
                    this.mrk.setCurrentItem(c2);
                    this.mrj.setSelectItem(c2);
                }
            }
            k();
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mwE);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ar, this.mwI);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        dyo().addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e() {
        super.e();
    }

    private void aP() {
        e.e("VideoPlayerEmbeddedScreenFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mwE).s();
        dlx();
        dxL();
        dxM();
        dyo().setBackgroundResource(a.e.room_not_online);
        if (this.mqA == null) {
            this.mqA = new RecommendView(this.mwE);
            dyo().addView(this.mqA);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = (int) tv.chushou.zues.utils.a.a(1, 30.0f, this.mwE);
            this.mqA.setLayoutParams(layoutParams);
        }
        if (this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mwD.dxt().mRoominfo.mRoomID)) {
            this.mqA.a(this.mwD.dxt().mRoominfo.mRoomID, new RecommendView.a() { // from class: com.kascend.chushou.player.d.a.21
                @Override // com.kascend.chushou.widget.RecommendView.a
                public void a(String str) {
                    if (!a.this.dyn() && a.this.mwE != null && a.this.dyo() != null) {
                        FrescoThumbnailView frescoThumbnailView = new FrescoThumbnailView(a.this.mwE);
                        frescoThumbnailView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        frescoThumbnailView.getHierarchy().b(p.b.lWk);
                        if (a.this.dyo().getChildCount() >= 2) {
                            a.this.dyo().addView(frescoThumbnailView, 0);
                        }
                        a.this.dyo().setBackgroundResource(0);
                        frescoThumbnailView.i(str, tv.chushou.widget.a.c.dJH(), a.this.ar, a.this.mwI);
                    }
                }
            });
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mxs != null) {
            this.mxs.dJc();
            this.mxs.setVisibility(8);
        }
        k(false, false, true);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.mxk != null) {
            this.mxk.e();
        }
        we(false);
        a(false, false);
        if (this.mpZ != null) {
            this.mpZ.d();
        }
    }

    private void dxI() {
        int i = 0;
        this.mqs = this.mwo.findViewById(a.f.topview);
        if (com.kascend.chushou.b.dwB().d == 0 && this.cK > 0) {
            View findViewById = this.mwo.findViewById(a.f.status_bar_view);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = this.cK;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        }
        this.mqt = (ImageView) this.mqs.findViewById(a.f.back_icon);
        this.mqt.setOnClickListener(this);
        this.mqu = (MarqueeTextView) this.mqs.findViewById(a.f.tv_title);
        this.mqv = (MarqueeTextView) this.mqs.findViewById(a.f.tv_Type);
        this.mqx = (ImageView) this.mwo.findViewById(a.f.btn_setting);
        this.mqB = this.mwo.findViewById(a.f.bottomview);
        if (this.mwv == null) {
            this.mwv = (ImageButton) this.mqB.findViewById(a.f.btn_barrage);
            this.mwv.setOnClickListener(this);
            if (this.mwD != null) {
                if (com.kascend.chushou.d.h.dwI().n()) {
                    this.mwv.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mwv.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        }
        this.mww = (ImageButton) this.mqB.findViewById(a.f.btn_audio);
        this.mww.setOnClickListener(this);
        if (this.mwD != null && this.mwD.d) {
            this.mww.setImageResource(a.e.ic_btn_room_video_n);
        } else {
            this.mww.setImageResource(a.e.ic_btn_room_audio_n);
        }
        this.p = false;
        if (this.mwD != null && this.mwD.f != null) {
            while (true) {
                if (i >= this.mwD.f.size()) {
                    break;
                } else if (!"2".equals(this.mwD.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        this.mqC = (ImageButton) this.mqB.findViewById(a.f.playbutton);
        this.mqC.setOnTouchListener(this);
        this.mqy = (ImageButton) this.mqB.findViewById(a.f.btn_refresh);
        this.mqy.setOnClickListener(this);
        this.mqD = (TextView) this.mqB.findViewById(a.f.tv_online_count);
        if (this.mwu == null) {
            this.mwu = (ImageButton) this.mqB.findViewById(a.f.btn_screenChange);
            this.mwu.setOnClickListener(this);
        }
        if (this.mqw == null) {
            this.mqw = (ImageView) this.mqs.findViewById(a.f.report_icon);
            this.mqw.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.d.a.22
                @Override // tv.chushou.zues.a
                public void dq(View view) {
                    if (com.kascend.chushou.d.e.c(a.this.getActivity(), null)) {
                        a.this.dxU();
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
        if (!dyn() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mqq != null) {
                        this.mqq.b(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                        this.mwD.dxt().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mwD.dxt().mMicStatus.onMic) {
                            aV();
                        }
                        if (this.mwD.dxt().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (!h.isEmpty(this.mwD.dxt().mRoominfo.mCreatorUID)) {
                                g(arrayList2, this.mwD.dxt().mRoominfo.mCreatorUID);
                            }
                        } else if (this.mwD.dxt().mMicStatus.onMic) {
                            this.mwD.dxt().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mwD.dxt().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str = null;
                            boolean z2 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z2 = h(this.mwD.dxt().mFanItems, str);
                            }
                            this.da = z2;
                            if (this.mwD.dxt().mMicStatus != null && !h.isEmpty(this.mwD.dxt().mMicStatus.micRoomId) && !this.mwD.dxt().mMicStatus.micRoomId.equals("0")) {
                                this.mrN = this.mwD.dxt().mMicStatus.micRoomId;
                            }
                            if (this.mqq != null) {
                                this.mqq.a(this.mwD.dxt().mMicStatus, this.mwD.dxt().mFanItems, str, z2);
                            }
                            if (this.mro != null && this.mro.getVisibility() == 0) {
                                this.mro.a(this.mwD.dxt().mFanItems, this.mwD.dxt().mMicStatus, str, z2, this.mwD.dxt().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mqq != null) {
                                this.mqq.e();
                            }
                            if (this.mro != null && this.mro.isShown()) {
                                this.mro.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(9) != null && (sparseArray.get(9) instanceof RoomChatBackground)) {
                    RoomChatBackground roomChatBackground = (RoomChatBackground) sparseArray.get(9);
                    if (this.mqq != null && roomChatBackground.mCoverChatBackground) {
                        if (!h.isEmpty(roomChatBackground.mChatBackground)) {
                            this.mqq.a(roomChatBackground.mChatBackground);
                        } else {
                            this.mqq.a();
                        }
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if (this.mrz != onlineVip.mCount && onlineVip.mCount >= 0) {
                        this.mrz = onlineVip.mCount;
                        k(onlineVip.mCount);
                    }
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mqd != null && this.mqd.msV != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i2);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mqd.msV.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mqd.msV.mInPKMode = true;
                                    this.mqd.msV.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mqd.msV.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mqd.msV.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mqd.msV.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mqd.msV.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mqd.msV.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mqd.msV.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mqd.msV.mMode = pkNotifyInfo.mMode;
                                    this.mqd.msV.liveStyle = pkNotifyInfo.liveStyle;
                                    if (dxW() != null) {
                                        dxW().g(true, this.mqd.msV.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dwI().a) {
                                        if (!com.kascend.chushou.b.dwB().e) {
                                            com.kascend.chushou.b.dwB().e = true;
                                            g.F(this.mwE, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dwI().a(this.mwE, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    if (2 == this.akQ && this.mrD != null) {
                                        this.mrD.setVisibility(0);
                                    }
                                    this.mqd.msV.mAction = 7;
                                    this.mqd.msV.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mqd.msV.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mqd.msV.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mqd.msV.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mqd.msV.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mqd.msV.destinyInfo = pkNotifyInfo.destinyInfo;
                                    bd();
                                    if (dxW() != null) {
                                        dxW().g(false, 0L);
                                        dxW().b(this.mqd.msV, true);
                                        dxW().a(this.mqd.msV.mMode, "1");
                                    }
                                    com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                                    aVar.OJ(this.mrE);
                                    tv.chushou.zues.a.a.post(aVar);
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    this.mqd.msV.mInPKMode = false;
                                    this.mqd.msV.mAction = 2;
                                    bd();
                                    if (dxW() != null) {
                                        dxW().c();
                                    }
                                    if (com.kascend.chushou.d.h.dwI().a) {
                                        if (!com.kascend.chushou.b.dwB().e) {
                                            com.kascend.chushou.b.dwB().e = true;
                                            g.F(this.mwE, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dwI().a(this.mwE, false);
                                        ak();
                                    }
                                    this.mqd.b = null;
                                    this.mqd.msV = new PkNotifyInfo();
                                    this.u = null;
                                    com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                                    aVar2.OJ(this.mrE);
                                    tv.chushou.zues.a.a.post(aVar2);
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mqd.msV.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mqd.msV.mPkUpdateInfo.specialMomentList)) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= this.mqd.msV.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i4).type == 1) {
                                                if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mwD.dxt().mRoominfo.mRoomID) && this.mwD.dxt().mRoominfo.mRoomID.equals(this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i4).roomId)) {
                                                    this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = true;
                                                } else {
                                                    this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i4).mineFirstblood = false;
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    if (dxW() != null) {
                                        dxW().a(this.mqd.msV, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mqd.msV.copyUpdate(pkNotifyInfo);
                                    if (dxW() != null) {
                                        dxW().a(this.mqd.msV);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mqd.msV.copyStop(pkNotifyInfo);
                                        if (dxW() != null) {
                                            dxW().A(this.mqd.msV.mMaxFreeDuration, this.mqd.msV.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mqd.msV.copyResult(pkNotifyInfo);
                                    if (!this.cB && dxW() != null) {
                                        int i5 = 1;
                                        if (this.mqd.msV.destinyInfo != null && this.mqd.msV.destinyInfo.destinyId != 0) {
                                            i5 = 2;
                                        }
                                        dxW().a(h.parseInt(this.mqd.msV.mResult), h.parseLong(this.mqd.msV.mvpUid), this.mqd.msV.mvpAvatar, this.mqd.msV.mvpNickname, this.mqd.msV.mMaxFreeDuration, this.mqd.msV.mMode, i5);
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
            if (arrayList != null && arrayList.size() != 0 && this.mqq != null) {
                if (LoginManager.Instance().islogined() && this.mwD != null && this.mwD.l()) {
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
                if (this.mwD == null || this.mwD.dxt() == null || this.mwD.dxt().mGiftComboConfig == null) {
                    j = 0;
                } else {
                    j = this.mwD.dxt().mGiftComboConfig.displayBaseCombo;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.dwI().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dwI().b().equals(next2.mUserID)) {
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
                this.mqq.a(arrayList, true, false);
                this.mqq.c(arrayList3);
            }
        }
    }

    public void k(int i) {
        int i2;
        if (this.mqn != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= this.mqn.length) {
                    break;
                }
                if (this.mqn[i2] == 99 && this.mqo != null && this.mqo[i2] != null && (this.mqo[i2] instanceof com.kascend.chushou.view.h5.a)) {
                    String str = ((com.kascend.chushou.view.h5.a) this.mqo[i2]).c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        break;
                    }
                }
                i3 = i2 + 1;
            }
            if (i2 < 0 && i2 < this.mrq.size() && this.mrj != null) {
                if (i == 0) {
                    this.mrj.setTagText(i2, new StringBuilder(this.mrq.get(i2).name).toString());
                    return;
                } else {
                    this.mrj.setTagText(i2, this.mrq.get(i2).name + "(" + tv.chushou.zues.utils.b.formatNumber(String.valueOf(i)) + ")");
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
        if (this.mwv != null) {
            if (z) {
                this.mwv.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mwv.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dxJ() {
        if (this.mwo == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mwo.findViewById(a.f.ll_gift_animation);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
        this.ar = Math.min(fU.x, fU.y);
        this.mwI = (this.ar * this.mwE.getResources().getInteger(a.g.h_thumb_height_def)) / this.mwE.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dyo().getLayoutParams();
        layoutParams.height = this.mwI;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mwx.getLayoutParams();
        layoutParams2.height = this.mwI;
        layoutParams2.width = this.ar;
        this.cF = this.mwI + this.mwE.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mwE, 54.0f);
        b(this.cF, 10);
        if (this.N != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.ar, this.mwI);
            layoutParams3.addRule(13);
            ((SurfaceView) this.N).setLayoutParams(layoutParams3);
        }
    }

    private void dxK() {
        Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
        this.ar = Math.min(fU.x, fU.y);
        this.mwI = (this.ar * this.mwE.getResources().getInteger(a.g.h_thumb_height_def)) / this.mwE.getResources().getInteger(a.g.h_thumb_width_def);
        ViewGroup.LayoutParams layoutParams = dyo().getLayoutParams();
        layoutParams.height = this.mwI;
        layoutParams.width = this.ar;
        ViewGroup.LayoutParams layoutParams2 = this.mwx.getLayoutParams();
        layoutParams2.height = this.mwI;
        layoutParams2.width = this.ar;
        this.cF = this.mwI + this.mwE.getResources().getDimensionPixelOffset(a.d.videoplayer_tab_height) + tv.chushou.zues.utils.a.dip2px(this.mwE, 54.0f);
        j(a.e.bg_gift_animation_v);
        b(this.cF, 10);
        k();
        if (!h.isEmpty(this.mqz)) {
            File ad = tv.chushou.zues.widget.fresco.a.ad(Uri.parse(this.mqz));
            if (ad != null && ad.exists()) {
                this.mwx.setImageURI(Uri.fromFile(ad));
                this.mwx.setVisibility(0);
                return;
            }
            this.mwx.setVisibility(8);
            return;
        }
        this.mwx.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ar(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mqw != null) {
            this.mqw.setVisibility(z ? 0 : 4);
        }
        if (this.mqx != null) {
            this.mqx.setVisibility(z ? 0 : 4);
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
        if (this.mwF != null) {
            this.mwF.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mwE).f(true);
            if (!z3) {
                if (this.mqB.getVisibility() != 0 && z2) {
                    this.mqB.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_bottom_anim));
                }
                if (this.p) {
                    this.mww.setVisibility(0);
                } else {
                    this.mww.setVisibility(8);
                }
                this.mqB.setVisibility(0);
            }
            PlayUrl dxu = this.mwD.dxu();
            if (dxu != null && "2".equals(dxu.mType)) {
                if (this.mwu != null) {
                    this.mwu.setVisibility(8);
                }
            } else if (this.mwu != null) {
                this.mwu.setVisibility(0);
            }
            if (this.mqs.getVisibility() != 0 && z2) {
                this.mqs.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_top_anim));
            }
            t(!z3);
            this.mqs.setVisibility(0);
            w(true);
            if (this.mwF != null) {
                this.mwF.A(1, 5000L);
            }
        } else {
            ((VideoPlayer) this.mwE).f(false);
            if (this.mwW != null) {
                this.mwW.dismiss();
            }
            if (this.mwX != null) {
                this.mwX.dismiss();
            }
            if (this.mqB.getVisibility() != 8 && z2) {
                this.mqB.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_bottom_anim));
            }
            this.mqB.setVisibility(8);
            if (this.mqs.getVisibility() != 8 && z2) {
                this.mqs.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_top_anim));
            }
            this.mqs.setVisibility(8);
            w(false);
        }
        this.e = z;
        return this.e;
    }

    public boolean dlx() {
        if (this.mxo == null || !this.mxo.isShown()) {
            return false;
        }
        this.mxo.d();
        return true;
    }

    public boolean dxL() {
        if (this.mro == null || !this.mro.isShown()) {
            return false;
        }
        this.mro.a();
        return true;
    }

    public boolean dxM() {
        if (this.mrs == null || !this.mrs.b()) {
            return false;
        }
        this.mrs.a();
        return true;
    }

    public boolean dxN() {
        if (this.cw && this.mxk != null) {
            if (this.mxk != null) {
                this.mxk.e();
            }
            if (this.mrH != null) {
                this.mrH.setText("");
            }
            if (this.akQ == 2) {
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
        if (listItem != null && this.mwo != null) {
            if (this.mrs == null) {
                this.mrs = (PopH5Menu) ((ViewStub) this.mwo.findViewById(a.f.viewstub_activity_h5)).inflate();
                this.mrs.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.d.a.23
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.b = true;
            h5Options.d = true;
            h5Options.e = true;
            h5Options.a = listItem.mUrl;
            h5Options.h = -1;
            this.mrs.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.btn_setting) {
            m(view, 0, this.mqs.getHeight() + this.mqs.getTop());
        } else if (id == a.f.btn_barrage) {
            n(view, 0, -tv.chushou.zues.utils.a.dip2px(this.mwE, 148.0f));
        } else if (id == a.f.back_icon) {
            g();
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dwB().a && !com.kascend.chushou.b.dwB().b) {
                g.c(this.mwE, getString(a.i.netWorkError));
            } else if (this.al) {
                this.al = false;
                this.mwD.a(false);
                a(false, false);
                ((VideoPlayer) this.mwE).l();
            } else {
                this.ai = false;
                ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
                com.kascend.chushou.toolkit.a.c.d(this.mwE, false, true);
            }
        } else if (id == a.f.btn_screenChange) {
            if (this.mqd == null || this.mqd.msV == null || !this.mqd.msV.mInPKMode) {
                ((VideoPlayer) this.mwE).a(0, (String) null);
                com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击转屏_num", "竖屏到横屏", new Object[0]);
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mrc) {
                f(this.mqP.getText().toString());
            } else {
                a(this.mqP.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dwI().c) {
                com.kascend.chushou.d.h.dwI().b(false);
                this.mqL.cancel();
                this.mqL.reset();
                this.mqK.clearAnimation();
                this.mqM.setVisibility(8);
            }
            l(view, 0, this.mwo.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_bottom_input) {
            RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.24
                @Override // java.lang.Runnable
                public void run() {
                    a.this.u(true);
                }
            });
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mwE, 165.0f) / 2);
            if (x < 0) {
                x = 0;
            }
            k(view, x, this.mwo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.btn_audio) {
            if (this.mwD.d) {
                ai();
            } else {
                aj();
            }
        } else if (id == a.f.iv_trumpet_select) {
            if (com.kascend.chushou.d.e.c(this.mwE, null) && this.mwD != null && this.mwD.mpL != null) {
                if (this.mrc) {
                    bg();
                    return;
                }
                if (this.mwD != null && this.mwD.mpL != null && this.mwD.mpL.count > 0) {
                    this.mqR.setVisibility(8);
                } else {
                    this.mqR.setVisibility(0);
                }
                this.mrc = true;
                this.mqZ.setBackgroundResource(a.e.ic_trumpet_p);
                this.mra.setVisibility(0);
                this.mra.setSelected(true);
                this.mra.setTextColor(Color.parseColor("#ff5959"));
                if (this.mqP != null) {
                    this.mqP.setHint(a.i.str_danmu_trumpet_hint);
                }
            }
        } else if (id == a.f.tv_plus_count) {
            if (this.mrb <= 9) {
                this.mrb++;
                this.mqY.setText(this.mrb + "");
            }
            dxX();
        } else if (id == a.f.tv_cut_count) {
            if (this.mrb > 1) {
                this.mrb--;
                this.mqY.setText(this.mrb + "");
            }
            dxX();
        } else if (id == a.f.tv_buy_head) {
            bf();
        } else if (id == a.f.iv_room_emoji_delete) {
            this.mrH.setText("");
        } else if (id == a.f.btn_room_search) {
            String obj = this.mrH.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mrH);
                this.mxk.a(obj);
            }
        } else {
            e.i("VideoPlayerEmbeddedScreenFragment", "onClicked");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mqP != null && this.mqI != null && this.mqO != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dC(this.mqP);
                this.mqI.setVisibility(8);
                if (this.akQ == 2) {
                    this.mqO.setVisibility(0);
                }
            }
        } else if (this.mqI != null && this.mqO != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
            if (this.akQ == 2) {
                this.mqI.setVisibility(0);
            }
            this.mqO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dwI().c(roomToast.mToastContent);
            if (this.mru == null) {
                aS();
            }
            if (this.mrv != null) {
                this.mrv.setText(roomToast.mToastContent);
            }
            if (!this.mru.isShowing()) {
                if (this.mrl != null) {
                    this.mru.showAtLocation(this.mrl, 85, 0, this.mwo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.25
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.mru != null) {
                                a.this.mru.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mru.dismiss();
        }
    }

    private void aS() {
        if (this.mru == null) {
            View inflate = LayoutInflater.from(this.mwE).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mrv = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mru = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 160.0f), -2);
            this.mru.setFocusable(false);
            this.mru.setOutsideTouchable(false);
            this.mru.setAnimationStyle(a.j.gift_toast_style);
            this.mru.update();
        }
    }

    private void k(View view, int i, int i2) {
        if (this.mxe != null && this.mxe.isShowing()) {
            this.mxe.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
        if (this.mxB == null) {
            dyq();
        }
        if (!this.mxB.isShowing()) {
            this.mxB.showAtLocation(view, 83, i, i2);
            if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mwD.dxt().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mxB.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (this.mxE != null) {
            if (h.isEmpty(this.mxF)) {
                if (((VideoPlayer) this.mwE).q) {
                    this.mxE.bU(this.mwD != null ? this.mwD.b("5") : "", a.e.ic_room_set_btn);
                } else {
                    this.mxE.bU(this.mwD != null ? this.mwD.b("10") : "", a.e.ic_room_set_btn_effect);
                }
            } else if (((VideoPlayer) this.mwE).q && this.mxF.size() == 2 && this.mxF.contains("4") && this.mxF.contains("2")) {
                this.mxE.bU(this.mwD != null ? this.mwD.b("7") : "", a.e.ic_room_set_btn_system);
            } else if (this.mxF.size() > 1 || !((VideoPlayer) this.mwE).q) {
                this.mxE.bU(this.mwD != null ? this.mwD.b("6") : "", a.e.ic_room_set_btn_more);
            } else if ("1".equals(this.mxF.get(0))) {
                this.mxE.bU(this.mwD != null ? this.mwD.b("8") : "", a.e.ic_room_set_btn_chat);
            } else if ("3".equals(this.mxF.get(0))) {
                this.mxE.bU(this.mwD != null ? this.mwD.b("9") : "", a.e.ic_room_set_btn_gift);
            } else if ("4".equals(this.mxF.get(0))) {
                this.mxE.bU(this.mwD != null ? this.mwD.b("7") : "", a.e.ic_room_set_btn_system);
            }
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
        if (this.mxe == null) {
            al();
            this.mxe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.a.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    a.this.ao();
                }
            });
        }
        if (!this.mxe.isShowing() && this.akQ == 2) {
            this.mxe.showAtLocation(view, 83, i, this.mwE.getResources().getDimensionPixelSize(a.d.margin_8) + i2);
            if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mwD.dxt().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mxe.dismiss();
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mwx != null) {
            this.mwx.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dwB().a && !com.kascend.chushou.b.dwB().b) {
                g.c(this.mwE, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.msU.getPlayState() == 4) {
                        e(true);
                        if (this.mwD.d) {
                            V();
                            break;
                        }
                    } else if (this.al) {
                        this.al = false;
                        this.mwD.a(false);
                        ((VideoPlayer) this.mwE).l();
                        break;
                    } else {
                        e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                        this.ai = false;
                        ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                        break;
                    }
                    break;
                case 1:
                    if (this.msU.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.msU.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dwB().a && !com.kascend.chushou.b.dwB().b) {
                g.c(this.mwE, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                if (this.al) {
                    this.al = false;
                    this.mwD.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mwE).l();
                } else {
                    e.e("VideoPlayerEmbeddedScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
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
        if (this.mxs != null) {
            if (z) {
                this.mxs.setVisibility(0);
            }
            this.mxs.dJc();
            if (!z) {
                this.mxs.setVisibility(8);
            }
        }
        g.c(this.mwE, this.mwE.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mqC != null) {
                this.mqC.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mwy != null) {
                this.mwy.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mqC != null) {
            this.mqC.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mwy != null) {
                    this.mwy.setVisibility(8);
                }
            }
        }
    }

    private void dxO() {
        this.e = false;
        k(true, false, true);
    }

    private void dxP() {
        this.e = false;
        k(true, false, false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = this.mqn[i];
        if (this.akQ != i2 || this.mqr != i) {
            this.mqr = i;
            this.akQ = i2;
            boolean i3 = i();
            d(i, 0);
            a(i, "");
            aM();
            a(this.mwD != null ? this.mwD.mpM.get("1") : null);
            if (i2 == 2) {
                k();
                as(true, i3);
                v(true);
                b(true);
                aX();
                com.kascend.chushou.toolkit.a.c.a(this.mwE, "互动页_num", null, new Object[0]);
                return;
            }
            l();
            as(false, i3);
            v(false);
            b(false);
            if (this.mxe != null && this.mxe.isShowing()) {
                this.mxe.dismiss();
            }
            if (i2 == 99) {
                if (this.mqo != null && this.mqo[i] != null && (this.mqo[i] instanceof com.kascend.chushou.view.h5.a)) {
                    com.kascend.chushou.view.h5.a aVar = (com.kascend.chushou.view.h5.a) this.mqo[i];
                    String str = aVar.c;
                    if (!h.isEmpty(str) && str.contains("bigfans")) {
                        aVar.c();
                    } else {
                        aVar.b();
                    }
                    if (!h.isEmpty(str)) {
                        if (str.contains("m/room-billboard")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mwE, "贡献榜_num", null, new Object[0]);
                            return;
                        } else if (str.contains("bigfans")) {
                            com.kascend.chushou.toolkit.a.c.a(this.mwE, "贵宾_num", null, new Object[0]);
                            return;
                        } else {
                            com.kascend.chushou.toolkit.a.c.a(this.mwE, "房间H5页_num", null, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                return;
            } else if (i2 == 1) {
                com.kascend.chushou.toolkit.a.c.a(this.mwE, "房间信息页_num", null, new Object[0]);
                return;
            } else {
                return;
            }
        }
        this.mqr = i;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void k() {
        if (this.akQ == 2) {
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
        ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (this.mwF != null) {
            if (this.mqO != null && this.mqO.getVisibility() == 0) {
                u(false);
            }
            if (this.mwy != null && this.mwy.getVisibility() == 0) {
                this.f = true;
            }
            ar(!this.e, true);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mqq != null) {
            this.mqq.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mqq != null) {
            this.mqq.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(long j, BangInfo bangInfo, String str) {
        super.a(j, bangInfo, str);
        if (this.mqq != null) {
            this.mqq.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mqq != null) {
            this.mqq.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mrl != null) {
            int size = iconConfig.configs.size();
            this.mrl.removeAllViews();
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                SkinConfig.SkinRes skinRes = map != null ? map.get(configDetail.position) : null;
                String str = skinRes != null ? skinRes.image : "";
                View inflate = LayoutInflater.from(this.mwE).inflate(a.h.item_videoplayer_embedded_bottom, (ViewGroup) this.mrl, false);
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
                this.mrl.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void I() {
        Map<String, SkinConfig.SkinRes> map = this.mwD != null ? this.mwD.mpM : null;
        a(map != null ? map.get("1") : null);
        SkinConfig.SkinRes skinRes = map != null ? map.get("2") : null;
        if (this.mqq != null) {
            this.mqq.a(skinRes != null ? skinRes.image : "");
        }
        b(map != null ? map.get("3") : null);
        c(map != null ? map.get("4") : null);
        au();
    }

    private void a(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mri != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (h.isEmpty(str)) {
                this.mri.xW(a.c.kas_white);
            } else if (this.akQ == 2) {
                this.mri.bU(str, a.c.kas_white);
                if (this.mrj != null) {
                    this.mrj.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.transparent));
                }
            } else {
                this.mri.xW(a.c.kas_white);
                if (this.mrj != null) {
                    this.mrj.setUnderlineColor(tv.chushou.widget.a.c.getColor(a.c.c_page_diliver_color_new));
                }
            }
            String str2 = skinRes != null ? skinRes.color : "";
            String str3 = skinRes != null ? skinRes.selectedColor : "";
            if (!h.isEmpty(str2) && !h.isEmpty(str3)) {
                int a = com.kascend.chushou.d.f.a(str2, a.c.second_black);
                int a2 = com.kascend.chushou.d.f.a(str3, a.c.kas_red_n);
                if (this.mrj != null) {
                    this.mrj.setTextColor(a);
                    this.mrj.setTabTextSelectColor(a2);
                    this.mrj.setIndicatorColor(a2);
                }
            }
        }
    }

    private void b(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mqK != null) {
            if (h.isEmpty(skinRes != null ? skinRes.image : "")) {
                this.mqK.xW(a.e.ic_hotwords_black_n);
            } else {
                this.mqK.bU(skinRes != null ? skinRes.image : null, a.e.ic_hotwords_n);
            }
        }
    }

    private void c(@Nullable SkinConfig.SkinRes skinRes) {
        if (this.mqJ != null) {
            String str = skinRes != null ? skinRes.image : null;
            if (str != null) {
                com.kascend.chushou.toolkit.b.a.dyC().a(str, this.mqJ, a.e.player_skin_input);
            } else {
                this.mqJ.setBackgroundResource(a.e.player_skin_input);
            }
            int a = com.kascend.chushou.d.f.a(skinRes != null ? skinRes.color : "", a.c.second_black);
            if (this.mqN != null) {
                this.mqN.setTextColor(a);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void a(int i) {
        if (this.mqq != null) {
            this.mqq.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void D() {
        if (this.mwE instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dwZ = ((VideoPlayer) this.mwE).dwZ();
            if (this.mxv == null) {
                this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxv.setVisibility(0);
            this.mxv.a(2, dwZ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mqq != null) {
            this.mqq.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mqq != null) {
            this.mqq.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(long j) {
        if (this.mqq != null) {
            this.mqq.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0749a
    public void c(int i) {
        if (this.mqq != null) {
            this.mqq.c();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mqq != null && this.mwD != null) {
            this.mqq.b(this.mwD.mpJ);
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
    public class C0742a extends FragmentStatePagerAdapter implements PagerSlidingTabStrip.b, PagerSlidingTabStrip.h {
        C0742a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            boolean z = false;
            if (i < 0 || i >= a.this.mqn.length) {
                return null;
            }
            switch (a.this.mqn[i]) {
                case 1:
                    if (a.this.mqp == null) {
                        a.this.mqp = com.kascend.chushou.view.user.a.a(2, null, a.this.mwD.a, false, a.this.mwD.h, false);
                    }
                    a.this.mqo[i] = a.this.mqp;
                    return a.this.mqp;
                case 2:
                    if (a.this.mqq == null) {
                        a aVar = a.this;
                        if (a.this.mqd != null && a.this.mqd.msV != null) {
                            z = a.this.mqd.msV.mInPKMode;
                        }
                        aVar.mqq = com.kascend.chushou.player.ui.a.wf(z);
                    }
                    a.this.mqo[i] = a.this.mqq;
                    return a.this.mqq;
                case 99:
                    H5Options h5Options = new H5Options();
                    h5Options.d = false;
                    h5Options.c = true;
                    if (a.this.mwD != null && a.this.mwD.dxt() != null && !h.isEmpty(a.this.mrq)) {
                        e.d("VideoPlayerEmbeddedScreenFragment", "MainPageAdapter.getItem: mRoomTabs.get(position).url = " + a.this.mrq.get(i).url);
                        h5Options.a = a.this.mrq.get(i).url;
                    }
                    com.kascend.chushou.view.h5.a a = com.kascend.chushou.view.h5.a.a(h5Options);
                    a.this.mqo[i] = a;
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
            return a.this.mqn.length;
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
            int dimensionPixelSize = a.this.mwE.getResources().getDimensionPixelSize(a.d.psts_dot_m_right);
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
        } else if (System.currentTimeMillis() - this.mqm <= 3000) {
            g.JO(a.i.str_too_fast);
            return false;
        } else {
            dxS();
            if (!com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a(((VideoPlayer) this.mwE).dwT().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mqm = System.currentTimeMillis();
            if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                a(this.mwD.dxt().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mwD.h);
            }
            g(this.b);
            if (!z && this.mqP != null) {
                this.mqP.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dxS();
            if (com.kascend.chushou.d.e.c(this.mwE, null) && LoginManager.Instance().getUserInfo() != null && this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                a(this.mwD.dxt().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mqP != null) {
                this.mqP.setText((CharSequence) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (this.mqq != null && !h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null && !h.isEmpty(this.mwD.dxt().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mwD.dxt().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mwE).mnY;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Ql(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
                        this.mqq.a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            this.mqq.a(arrayList, true, true);
        }
    }

    private void aV() {
        if (this.mqq != null) {
            this.mqq.e();
        }
        if (this.mro != null && this.mro.isShown()) {
            this.mro.a();
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dxQ() {
        super.dxQ();
        if (this.mwE instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
        if (this.mwD != null) {
            this.mwD.d = false;
            U();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        aV();
        e.e("VideoPlayerEmbeddedScreenFragment", "receive onCompletePlayback mRetryInComplete =" + this.mrm);
        if (this.mwE != null) {
            if (this.mrm || "10004".equals(((VideoPlayer) this.mwE).t)) {
                this.mrm = true;
                if (this.mwD != null) {
                    this.mwD.f = null;
                    if (this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                        this.mwD.dxt().mRoominfo.mGameId = null;
                    }
                }
                aP();
                return;
            }
            this.mrm = true;
            if (this.mwE != null) {
                ((VideoPlayer) this.mwE).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mrm = false;
        if (this.mqA != null) {
            this.mqA.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mrm = false;
        if (this.mqA != null) {
            this.mqA.setVisibility(8);
        }
        super.i(z);
    }

    private void dxR() {
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
        dyo().setBackgroundColor(getResources().getColor(a.c.black));
        if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mxs != null) {
            this.mxs.setVisibility(0);
        }
        if (this.mpZ != null) {
            e.i("VideoPlayerEmbeddedScreenFragment", "start danmu");
            this.mpZ.d();
        }
        if (this.mqI != null) {
            this.mqI.setVisibility(0);
        }
        if (com.kascend.chushou.c.a) {
            this.mqx.setVisibility(0);
            this.mqx.setOnClickListener(this);
        } else {
            this.mqx.setVisibility(8);
        }
        this.mqC.setVisibility(0);
        this.mqy.setVisibility(0);
        this.mwv.setVisibility(0);
        if (this.p) {
            this.mww.setVisibility(0);
        } else {
            this.mww.setVisibility(8);
        }
        aX();
        as(true, i());
        this.e = false;
        k(true, false, false);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mxv != null && this.mxv.a(i, keyEvent)) {
                return true;
            }
            if (this.mrs != null && this.mrs.onKeyDown(i, keyEvent)) {
                return true;
            }
            if ((this.mrt != null && this.mrt.onKeyDown(i, keyEvent)) || aD()) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mrI != null && this.mrI.getVisibility() == 0 && b(motionEvent, this.mrI)) {
                this.mrI.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mrH);
                return true;
            } else if (this.cw && this.mrI != null && this.mrI.getVisibility() == 8 && g(this.mxk.b, motionEvent)) {
                dxN();
                return true;
            } else if (this.mrs != null && this.mrs.b() && g(this.mrs, motionEvent)) {
                this.mrs.a();
                return true;
            } else if (this.mrt != null && this.mrt.b() && g(this.mrt, motionEvent)) {
                this.mrt.a();
                return true;
            } else if (b(motionEvent, this.mqO)) {
                return dxS();
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dxS() {
        boolean z;
        b(this.cF, 10);
        boolean z2 = false;
        if (this.mrd != null && this.mrd.getVisibility() == 0) {
            this.mrd.setVisibility(8);
            this.mre.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mrf) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
            this.mre.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mqO == null || this.mqO.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mrc) {
                bg();
            }
            this.mqO.setVisibility(8);
            z = true;
        }
        if (this.akQ == 2) {
            RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mqI != null && a.this.akQ == 2) {
                        a.this.mqI.setVisibility(0);
                    }
                }
            });
        }
        return z;
    }

    public boolean aD() {
        if (dxS()) {
            return true;
        }
        if (this.mxe == null || !this.mxe.isShowing()) {
            return dxN() || dxL() || dlx();
        }
        this.mxe.dismiss();
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
        this.mqI.setVisibility(8);
        this.mqO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(boolean z, boolean z2) {
        if (this.mqI != null) {
            if (z) {
                if (this.mqI.getVisibility() != 0) {
                    this.mqI.setVisibility(0);
                    this.mqI.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_bottom_anim));
                }
            } else if (this.mqI.getVisibility() != 4) {
                this.mqI.setVisibility(4);
                this.mqI.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_bottom_anim));
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mqA != null) {
            this.mqA.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dxT() {
        return this.mrx;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dyn()) {
            e.e("VideoPlayerEmbeddedScreenFragment", "onGetPlayUrlFail rc=" + i);
            if (i()) {
                if (i == 404) {
                    if (this.mwD != null) {
                        this.mwD.f = null;
                        this.mwD.dxt().mRoominfo.mGameId = null;
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
        if (this.mwD != null && this.mwD.dxu() != null) {
            a(this.mwD.dxu());
        }
        this.p = false;
        if (this.mwD == null || this.mwD.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mwD.f.size()) {
                if (!"2".equals(this.mwD.f.get(i2).mType)) {
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
        if (this.mqq != null) {
            this.mqq.c(z);
        }
    }

    @Subscribe
    public void onUpdateRoomInfoEvent(q qVar) {
        if (!dyn()) {
            e.i("VideoPlayerEmbeddedScreenFragment", "onUpdateRoomInfoEvent()");
            if (this.mqD != null && this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
                this.mqD.setText(getResources().getString(a.i.str_video_online_count, tv.chushou.zues.utils.b.formatNumber(this.mwD.dxt().mRoominfo.mOnlineCount)));
            }
        }
    }

    @Subscribe
    public void onSubcribeAlertClick(com.kascend.chushou.b.a.a.b bVar) {
        int c;
        if (!dyn() && !this.cB && (c = c(1, -1)) >= 0 && c < this.mrq.size() && this.mrk != null) {
            this.mrk.setCurrentItem(c);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dyn() && !this.cB) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mwE, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dxa = ((VideoPlayer) this.mwE).dxa();
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(2, dxa);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dxb = ((VideoPlayer) this.mwE).dxb();
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(2, dxb);
            } else if (bVar.a == 9) {
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mrd != null) {
            this.mrd.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dyn() && !this.cB) {
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
        if (!dyn() && this.mwD != null) {
            String str = this.mwD.a;
            RoomInfo dxw = this.mwD.dxw();
            if (dxw != null && mVar.a(dxw.mCreatorUID, str)) {
                dxw.mIsSubscribed = mVar.c;
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        if (this.akQ == 2) {
            RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.d.a.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.dyn()) {
                        a.this.u(true);
                        if (!h.isEmpty(userCardInfo.getNickname()) && a.this.mqP != null) {
                            a.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), a.this.mqP);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxU() {
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
            if (this.mrn == null) {
                this.mrn = new f(getActivity());
            }
            this.mrn.a(this.mwD.dxt().mRoominfo);
            if (!this.mrn.isShowing()) {
                this.mrn.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mqq != null) {
            this.mqq.d();
        }
    }

    private void ds(View view) {
        this.mqE = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mqF = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mqF.setText(new tv.chushou.zues.widget.a.c().J(this.mwE, a.e.videoplayer_4g_video).append("  ").append(this.mwE.getString(a.i.videoplayer_4g_video)));
        this.mqG = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mqG.setText(new tv.chushou.zues.widget.a.c().J(this.mwE, a.e.videoplayer_4g_audio).append("  ").append(this.mwE.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    a.this.g();
                } else if (id == a.f.tv_4g_video) {
                    a.this.mqE.setVisibility(8);
                    ((VideoPlayer) a.this.mwE).c(a.this.mqH);
                } else if (id == a.f.tv_4g_audio) {
                    a.this.mqE.setVisibility(8);
                    ((VideoPlayer) a.this.mwE).d(a.this.mqH);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        int statusBarHeight = com.kascend.chushou.b.dwB().d == 1 ? 0 : tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        this.mqF.setOnClickListener(onClickListener);
        this.mqG.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mwD != null && !h.isEmpty(this.mwD.f)) {
            f(this.mwD.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mqH = z;
            this.p = false;
            if (this.mwD != null && this.mwD.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mwD.f.size()) {
                        break;
                    } else if (!"2".equals(this.mwD.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mqE != null) {
                this.mqE.setVisibility(0);
                this.mqF.setVisibility(0);
                this.mqG.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mqE != null) {
            this.mqE.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mrA == null) {
                this.mrA = new Runnable() { // from class: com.kascend.chushou.player.d.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.dyn()) {
                            a.this.dxV();
                        }
                    }
                };
                if (this.mwF != null) {
                    this.mwF.e(this.mrA, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mrA != null && this.mwF != null) {
            this.mwF.N(this.mrA);
            this.mrA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxV() {
        if (LoginManager.Instance().islogined() && this.mqq != null) {
            com.kascend.chushou.toolkit.a.c.a(this.mwE, "显示双击666_num", null, new Object[0]);
            if (this.mwD != null) {
                this.mwD.b(false);
            }
            d(false);
            this.mqq.b(true);
        }
    }

    private void a(ConfigDetail configDetail) {
        if (this.mwo != null) {
            if (this.mrt == null) {
                this.mrt = (InteractionView) ((ViewStub) this.mwo.findViewById(a.f.view_interaction)).inflate();
                this.mrt.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.d.a.9
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        a.this.b(configDetail2);
                        a.this.mrt.a();
                    }
                });
            }
            if (this.mrt != null) {
                this.mrt.b(configDetail);
                this.mrt.c();
                this.mrt.a(false);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dJP()) {
                g.F(this.mwE, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mwE, null) && (this.mwE instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwD != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwE, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwD != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwE, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mwE, configDetail.mUrl, this.mwE.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mwE, null)) {
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
            dxN();
            return;
        }
        if (this.mwE.getResources().getDisplayMetrics().density < 2.0f) {
            b(true, false);
        } else {
            b(true, true);
        }
        com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击送礼_num", "竖屏", new Object[0]);
        if (this.mwD != null && this.mwD.dxt() != null && this.mwD.dxt().mRoominfo != null) {
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwD.dxt().mRoominfo.mRoomID);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        int i = 2;
        if (this.mwE != null && !this.v && !h.isEmpty(str) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mqd == null) {
                this.mqd = new com.kascend.chushou.player.e.a();
            }
            this.mqd.b = str;
            this.mqd.msV.copy(pkNotifyInfo);
            if (this.mqd.msV.mAction == 6) {
                this.mqd.msV.mInPKMode = true;
                this.u = this.mqd.msV.mPkId;
            } else if (this.mqd.msV.mAction == 7 || (this.mqd.msV.mMode == 1 && this.mqd.msV.mAction == 5)) {
                this.mqd.msV.mInPKMode = true;
                this.u = this.mqd.msV.mPkId;
                if (dxW() != null) {
                    if (2 == this.akQ && this.mrD != null) {
                        this.mrD.setVisibility(0);
                    }
                    dxW().b(this.mqd.msV, false);
                    dxW().a(this.mqd.msV.mMode, "1");
                    if (this.mqd.msV.mAction == 5 && this.mqd.msV.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mqd.msV.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mqd.msV.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mqd.msV.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mqd.msV.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mqd.msV.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        dxW().a(this.mqd.msV);
                        if (this.mqd.msV.destinyInfo == null || this.mqd.msV.destinyInfo.destinyId == 0) {
                            i = 1;
                        }
                        dxW().a(parseInt, this.mqd.msV.mPkUpdateInfo.remainDuration, j, this.mqd.msV.mMode, i);
                    }
                    if (!h.isEmpty(this.mqd.msV.mPkUpdateInfo.specialMomentList) && dxW() != null) {
                        dxW().a(this.mqd.msV, true);
                    }
                }
                bd();
                com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, 0);
                aVar.OJ(str);
                tv.chushou.zues.a.a.post(aVar);
            } else {
                this.mqd.msV.mInPKMode = false;
                bd();
                com.kascend.chushou.player.ui.button.a aVar2 = new com.kascend.chushou.player.ui.button.a(5, 8);
                aVar2.OJ(str);
                tv.chushou.zues.a.a.post(aVar2);
            }
        }
    }

    private void bd() {
        if (this.mqd != null && this.mqd.msV != null) {
            if (this.mqd.msV.mInPKMode) {
                this.y.setText(this.mqd.msV.mPkUserNickname);
                this.mqf.setVisibility(0);
                if (this.mwu != null) {
                    this.mwu.setEnabled(false);
                }
                if (this.mww != null) {
                    this.mww.setEnabled(false);
                    return;
                }
                return;
            }
            this.mqf.setVisibility(8);
            if (this.mwu != null) {
                this.mwu.setEnabled(true);
            }
            if (this.mww != null) {
                this.mww.setEnabled(true);
            }
        }
    }

    private com.kascend.chushou.player.e.b dxW() {
        if (this.mwE == null || this.mwo == null || this.mrD == null) {
            return null;
        }
        if (this.mqe == null) {
            if (this.mrC == null) {
                this.mrC = ((ViewStub) this.mwo.findViewById(a.f.vs_pk_container)).inflate();
            }
            this.mqe = new com.kascend.chushou.player.e.b();
            this.mqe.a(this.mrD, this.mrC, (View) null, this.mwE, new b.a() { // from class: com.kascend.chushou.player.d.a.10
                @Override // com.kascend.chushou.player.e.b.a
                public void a(int i) {
                    StringBuilder append = new StringBuilder(tv.chushou.common.a.dJv()).append("/m/pk-live/assist-billboard.htm?roomId=");
                    if (a.this.mwD != null) {
                        append.append(a.this.mwD.dxw().mRoomID);
                    }
                    if (a.this.mqd != null && a.this.mqd.msV != null) {
                        append.append("&mode=").append(a.this.mqd.msV.mMode);
                    }
                    append.append("&type=").append(i);
                    com.kascend.chushou.d.e.a(a.this.mwE, append.toString());
                }
            });
        }
        return this.mqe;
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mra != null && this.mwD != null && this.mwD.mpL != null) {
            this.mra.setText(tv.chushou.zues.utils.b.JN(this.mwD.mpL.count));
            this.mra.setVisibility(0);
            if (this.mwD.mpL.count < 1) {
                bg();
            }
            if (this.mqS != null) {
                this.mqS.setText(this.mwD.mpL.primaryName);
            }
            if (this.mqT != null) {
                this.mqT.setText(this.mwD.mpL.desc);
            }
            dxX();
        }
    }

    public void dxX() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mrb * h.parseLong(this.mwD.mpL.point)));
        if (this.mqV != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mwE.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mwE, a.e.icon_coin_new);
            cVar.append(this.mwE.getString(a.i.str_buy_count_coin2));
            this.mqV.setText(cVar);
        }
    }

    private void bf() {
        if (com.kascend.chushou.d.e.c(this.mwE, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mrb);
        }
    }

    private void v(boolean z) {
        if (this.mwo != null && this.mrD != null) {
            if (z) {
                if (this.mqd != null && this.mqd.msV != null && this.mqd.msV.mInPKMode) {
                    this.mrD.setVisibility(0);
                    return;
                }
                return;
            }
            this.mrD.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mwo != null && this.mqi != null) {
            if (z) {
                if (this.E && 2 == this.akQ) {
                    this.mqi.setVisibility(0);
                    return;
                }
                return;
            }
            this.mqi.setVisibility(8);
        }
    }

    private void w(boolean z) {
        if (z) {
            if (this.mqd != null && this.mqd.msV != null && this.mqd.msV.mInPKMode && this.mqf != null) {
                this.mqf.setVisibility(0);
            }
        } else if (this.mqf != null) {
            this.mqf.setVisibility(8);
        }
    }

    private void bg() {
        this.mrc = false;
        this.mqZ.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mwD != null && this.mwD.mpL != null) {
            if (this.mwD.mpL.count < 1) {
                this.mra.setVisibility(8);
            } else {
                this.mra.setVisibility(0);
                this.mra.setSelected(false);
                this.mra.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mqR.setVisibility(8);
        if (this.mqP != null) {
            this.mqP.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        bc();
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mqN != null) {
            this.mqN.performClick();
        }
    }

    public boolean dxY() {
        return this.akQ == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.e
    public void k(boolean z) {
        this.mrO = true;
        if (this.mwo != null && com.kascend.chushou.b.dwB().d == 0) {
            this.mry = tv.chushou.zues.utils.systemBar.b.fY(getActivity());
            if (!z) {
                View findViewById = this.mwo.findViewById(a.f.videoplayer_content);
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
                findViewById.requestLayout();
                return;
            }
            this.mry = tv.chushou.zues.utils.systemBar.b.fY(getActivity());
            e.d("guohe", "VideoPlayerEmbeddedScreenFragment.dealNavigationBarChange(): mNaviBarHeight = " + this.mry);
            View findViewById2 = this.mwo.findViewById(a.f.videoplayer_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop(), findViewById2.getPaddingRight(), this.mry);
            findViewById2.requestLayout();
        }
    }
}
