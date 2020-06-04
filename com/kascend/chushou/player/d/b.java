package com.kascend.chushou.player.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kascend.chushou.a;
import com.kascend.chushou.a.a;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.d.g;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.a.f;
import com.kascend.chushou.player.d;
import com.kascend.chushou.player.ui.PlayerErrorView;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.player.ui.h5.H5Container;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.widget.GiftAnimationLayout;
import com.kascend.chushou.widget.RoundProgressBar;
import com.kascend.chushou.widget.VerticalSeekBarVolumn;
import com.kascend.chushou.widget.guide.PaoGuideView;
import com.kascend.chushou.widget.menu.KasBaseMenuView;
import com.kascend.chushou.widget.menu.PopH5Menu;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.sweetalert.b;
import tv.chushou.zues.widget.textview.MarqueeTextView;
/* loaded from: classes5.dex */
public class b extends d implements View.OnClickListener, View.OnTouchListener {
    public int bu;
    private TextView mMh;
    private boolean mMj;
    private ImageView mNA;
    private f mNB;
    private com.kascend.chushou.player.ui.giftpopup.a mNC;
    private PopH5Menu mNE;
    private com.kascend.chushou.player.b.a mNF;
    private GiftAnimationLayout mNG;
    private ImageView mNH;
    private FoodView mNI;
    private RelativeLayout mNJ;
    private TextView mNK;
    private VerticalSeekBarVolumn mNQ;
    private long mNS;
    private LinearLayout mNk;
    private FrameLayout mNo;
    private FrescoThumbnailView mNp;
    private ImageView mNs;
    private ImageView mNu;
    RelativeLayout mNx;
    private ImageView mNy;
    private Rect mNa = null;
    private Rect mNb = null;
    private float mNc = 0.0f;
    private Window mNd = null;
    private WindowManager.LayoutParams mNe = null;
    private boolean mNf = false;
    private View mNg = null;
    private View mLz = null;
    private View mNh = null;
    private View mNi = null;
    private View mNj = null;
    private ImageView mLE = null;
    private ImageView mNl = null;
    private ImageButton mNm = null;
    private FrescoThumbnailView mNn = null;
    private LinearLayout mNq = null;
    private EditText mNr = null;
    private View mNt = null;
    private boolean bT = false;
    private int mNv = 0;
    private int bV = 0;
    private long mNw = 0;
    private ProgressDialog mNz = null;
    private boolean bws = true;
    private int mND = -1;
    private boolean mNL = false;
    private TextView mNM = null;
    private TextView mNN = null;
    private int mNO = 0;
    private boolean mNP = false;
    private boolean mNR = false;
    private final Rect mNT = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLh = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRt = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.mRJ != null && !((Activity) this.mRJ).isFinishing()) {
            dFE();
        }
        return this.mRt;
    }

    public void dFj() {
        ax(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.mRJ, "能量_num", "横屏", new Object[0]);
    }

    public boolean dFs() {
        if (this.mSs == null || !this.mSs.isShown()) {
            return false;
        }
        this.mSs.d();
        return true;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        e.d("VideoPlayerFullScreenFragment", MissionEvent.MESSAGE_PAUSE);
        super.onPause();
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        boolean z;
        boolean z2 = true;
        super.onResume();
        boolean z3 = (this.ai || this.H || this.al) ? false : true;
        if (z3 || this.mRt.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dEn().e;
        } else {
            z = h.dEn().b;
        }
        r(z);
        if (this.mSn != null) {
            this.mSn.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mNC != null) {
            this.mNC.b();
            this.mNC = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.ch(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            aM();
            y();
            if (this.mLh != null) {
                this.mLh.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        Animation loadAnimation;
        Animation loadAnimation2;
        int i;
        int i2;
        int i3 = this.ap == 0 ? 0 : 6;
        if (this.mNE != null && this.mND != i3) {
            this.mNE.a();
            this.mNE = null;
        }
        if (this.mNE == null) {
            this.mNE = (PopH5Menu) ((ViewStub) this.mRt.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point gv = tv.chushou.zues.utils.a.gv(getActivity());
            if (this.ap == 0) {
                int i4 = gv.y;
                i = gv.y;
                i2 = i4;
            } else {
                int i5 = gv.x;
                int i6 = gv.y - ((gv.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNE.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mNE.setLayoutParams(layoutParams);
            this.mND = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mNE.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dFS()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mRJ instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dEG = ((VideoPlayer) this.mRJ).dEG();
                    if (this.mSA == null) {
                        this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mSA.setVisibility(0);
                    this.mSA.a(i, dEG);
                }
            } else if (bVar.a == 3) {
                if (this.mRJ instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dEH = ((VideoPlayer) this.mRJ).dEH();
                    if (this.mSA == null) {
                        this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mSA.setVisibility(0);
                    this.mSA.a(i, dEH);
                }
            } else if (bVar.a == 9) {
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dFc;
        if (!dFS() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mRI != null && mVar.b.equals(this.mRI.a) && (dFc = this.mRI.dFc()) != null) {
            dFc.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dFE() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.mNv = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
        this.bV = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.mNX = ((VideoPlayer) this.mRJ).dEw();
        this.mRI = ((VideoPlayer) this.mRJ).dEz();
        c(this.mRt);
        if (this.aw.equals("1")) {
            this.mLf = ((VideoPlayer) this.mRJ).dEA();
            this.mLf.a(this);
            if (this.mNF != null) {
                this.mNF.a();
                this.mNF = null;
                this.mNG = null;
            }
            this.mNG = (GiftAnimationLayout) this.mRt.findViewById(a.f.ll_gift_animation);
            this.mNG.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mRI != null) {
                this.mNF = new com.kascend.chushou.player.b.a(this.mRJ.getApplicationContext(), this.mNG);
                this.mNF.a(this.mRI);
            }
            this.B = (TextView) this.mRt.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        aO();
        if (this.mLf != null) {
            this.mLf.d();
        }
        dFC();
        this.mNs = (ImageView) this.mRt.findViewById(a.f.btn_lockscreen);
        this.mNs.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mRt.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mRD = (PlayerErrorView) this.mRt.findViewById(a.f.view_net_error_msg);
        this.mRD.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dFl();
        dsU();
        this.mSs = (PaoGuideView) this.mRt.findViewById(a.f.rlPaoGuideView);
        this.mNH = (ImageView) this.mRt.findViewById(a.f.iv_send_danmu);
        this.mNj = this.mRt.findViewById(a.f.rt_layout);
        this.mNn = (FrescoThumbnailView) this.mNj.findViewById(a.f.btn_gift);
        this.mNo = (FrameLayout) this.mNj.findViewById(a.f.flfl_bottom_gift);
        this.mNp = (FrescoThumbnailView) this.mNj.findViewById(a.f.btn_recharge);
        this.mNp.setOnClickListener(this);
        a(this.mRI == null ? null : this.mRI.mKP);
        this.mSy = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mNf = false;
                b.this.y(false);
                if (b.this.mRK != null) {
                    b.this.mRK.removeMessages(1);
                    b.this.mRK.A(1, 5000L);
                }
                b.this.mNs.setVisibility(0);
                b.this.mNj.setVisibility(0);
                b.this.mLz.setVisibility(0);
                b.this.mNg.setVisibility(0);
                if (b.this.mNC != null) {
                    b.this.mNC.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mRJ, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mNf = true;
                b.this.y(true);
                b.this.mNs.setVisibility(8);
                b.this.mNj.setVisibility(8);
                if (b.this.mNC != null) {
                    b.this.mNC.a(false);
                }
                b.this.mLz.setVisibility(8);
                b.this.mNg.setVisibility(8);
                if (b.this.mRK != null) {
                    b.this.mRK.removeMessages(1);
                }
                if (b.this.mSn != null) {
                    b.this.mSn.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mRJ, 14.0f) + b.this.mSn.getMeasuredHeight(), 12);
                }
            }
        };
        this.mNq = (LinearLayout) this.mRt.findViewById(a.f.rl_seekbar);
        this.mNx = (RelativeLayout) this.mRt.findViewById(a.f.rl_paoicon);
        this.mNx.setOnClickListener(this);
        this.mSo = (RoundProgressBar) this.mRt.findViewById(a.f.roundProgressBar);
        this.mSr = (FrescoThumbnailView) this.mRt.findViewById(a.f.iv_paoicon);
        this.mSq = (TextView) this.mRt.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.mSt = 0L;
        com.kascend.chushou.player.ui.a.a dEJ = ((VideoPlayer) this.mRJ).dEJ();
        a(dEJ.dFZ());
        BangInfo dGa = dEJ.dGa();
        if (dGa != null) {
            a(dGa, dEJ.d());
        }
        if (this.aw.equals("3")) {
            this.mNq.setVisibility(0);
            this.mNo.setVisibility(8);
            this.mNH.setVisibility(0);
            this.mNH.setOnClickListener(this);
        } else {
            this.mNH.setVisibility(8);
            this.mNq.setVisibility(8);
            this.mNo.setVisibility(0);
            this.mNn.setOnClickListener(this);
        }
        dFm();
        if (tv.chushou.zues.utils.systemBar.b.gC(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNj.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.mNj.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mLz.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.mLz.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mNi.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.mNi.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mNg.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.mNg.setLayoutParams(layoutParams4);
        }
        dFG();
        aG();
        aM();
        this.h = (TextView) this.mRt.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mRt.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mRI.dEZ() != null) {
                this.mNA.setVisibility(0);
            } else {
                this.mNA.setVisibility(8);
            }
        }
        dFF();
        n();
        k(100);
        this.mNI = (FoodView) this.mRt.findViewById(a.f.kav_room_ad);
        this.mRK = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ax(false, true);
                            break;
                        case 2:
                            b.this.mRK.removeMessages(2);
                            if (b.this.mNs != null) {
                                b.this.mNs.setVisibility(8);
                                break;
                            }
                            break;
                        case 3:
                            b.this.v(true);
                            break;
                        case 4:
                            b.this.w(true);
                            break;
                        case 5:
                            TextView textView = (TextView) b.this.mRt.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mRJ.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mRK.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mRK.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mRK.A(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aw(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mRJ).q) {
                                b.this.a(b.this.mRK);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mRJ).q) {
                                b.this.b(b.this.mRK);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mRJ).g = true;
                            b.this.mNX.seekTo((int) b.this.mjc);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mRI.d()) {
                                b.this.mNX.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mNX.getPlayState() == 4) {
                                int currentPos = b.this.mNX.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mRK != null) {
                                    b.this.mRK.A(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dFU();
                            break;
                        case 18:
                            b.this.dsT();
                            break;
                        case 19:
                            b.this.mRH.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mRI != null) {
            a(this.mRI.dFa());
        }
        if (this.mNX != null && (this.mNX.getPlayState() == 3 || this.mNX.getPlayState() == 4)) {
            wD(false);
            if (this.mRI.d()) {
                this.ak = false;
                wE(true);
                if (this.mNX.getDuration() > 60000) {
                    if (this.mNX.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mNX.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mNX.getDuration();
                }
            }
            this.e = false;
            ax(true, false);
            this.mRK.Ks(8);
            if (h() && this.mNX.getPlayState() == 4 && this.mRK != null) {
                this.mRK.removeMessages(15);
                this.mRK.Ks(15);
            }
        } else {
            wD(true);
            if (this.e) {
                ax(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dEm = g.dEm();
            int i = dEm.length == 2 ? dEm[1] : 0;
            if (i > 0) {
                View findViewById = this.mRt.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mRt.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mRJ, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mRJ, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.mRJ).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mNp.yG(a.e.ic_recharge_old);
            this.mNn.yG(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mNL && !this.k) {
            try {
                if (this.mNX != null) {
                    i = this.mNX.getCurrentPos();
                    i2 = this.mNX.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mLg.setProgress(i / (i2 / 1000));
                    this.mNM.setText(tv.chushou.zues.utils.b.o(this.mNX.getDuration(), false));
                    this.mNN.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dFF() {
        this.mLg = (ProgressBar) this.mRt.findViewById(a.f.progressBarl);
        if (this.mLg != null) {
            if (this.mLg instanceof SeekBar) {
                ((SeekBar) this.mLg).setOnSeekBarChangeListener(new C0802b());
            }
            this.mLg.setMax(1000);
        }
        this.mNM = (TextView) this.mRt.findViewById(a.f.tv_time_duration);
        this.mNN = (TextView) this.mRt.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mRt.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mRt.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dEJ;
        BangInfo dGa;
        if (config != null) {
            this.mSv = config;
            if (!config.display) {
                this.mNx.setVisibility(8);
            } else if ((this.mRJ instanceof VideoPlayer) && (dGa = (dEJ = ((VideoPlayer) this.mRJ).dEJ()).dGa()) != null) {
                a(dGa, dEJ.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mSv == null || this.mSv.display) && this.mNx != null) {
            this.mNx.setVisibility(0);
            this.mSq.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mRJ instanceof VideoPlayer) {
            if ((this.mSv == null || this.mSv.display) && this.mNx != null) {
                if (j > 0) {
                    this.mNx.setVisibility(0);
                    boolean z = this.mSu;
                    this.mSu = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mRJ.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mSq.setText(cVar);
                    return;
                }
                this.mSu = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0802b implements SeekBar.OnSeekBarChangeListener {
        C0802b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.mNO != i || b.this.mNP != z) {
                    b.this.mNO = i;
                    b.this.mNP = z;
                    if (z) {
                        if (b.this.mNL) {
                            b.this.mjc = (b.this.mNX.getDuration() / 1000) * i;
                        }
                        b.this.mNN.setText(tv.chushou.zues.utils.b.o((int) b.this.mjc, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.mjc, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.mjc) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mNL = true;
            b.this.m = b.this.mNX.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mRK != null) {
                if (b.this.mNL) {
                    b.this.mNL = false;
                }
                b.this.mRK.removeMessages(14);
                b.this.mRK.Ks(14);
            }
        }
    }

    private void k(int i) {
        this.mLg.setSecondaryProgress((i * 1000) / 100);
    }

    private void dFC() {
        this.mNQ = (VerticalSeekBarVolumn) this.mRt.findViewById(a.f.volumn_seekbar);
        this.mNQ.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mRL.getStreamVolume(3);
        this.mNQ.setProgress(Jd(streamVolume));
        x(Jd(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mRt.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mLd = new d.a();
            this.c = new GestureDetector(this.mRJ, this.mLd);
        }
    }

    private void dFG() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mNd == null) {
                this.mNd = ((Activity) this.mRJ).getWindow();
            }
            this.mNe = this.mNd.getAttributes();
            this.mNc = ((VideoPlayer) this.mRJ).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mRt.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mNc));
        }
    }

    private void aG() {
        this.mRt.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mRt.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mRJ.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mRt.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mNr == null) {
            this.mNr = (EditText) this.mRt.findViewById(a.f.et_input);
            this.mNr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mRt.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        if (this.mNB != null) {
            this.mNB.dismiss();
            this.mNB = null;
        }
        if (this.mRJ != null) {
            ((VideoPlayer) this.mRJ).a(1, null, this.H, false);
        }
    }

    private void dFl() {
        this.mLz = this.mRt.findViewById(a.f.topview);
        this.mNk = (LinearLayout) this.mRt.findViewById(a.f.topRight);
        this.mNh = this.mLz.findViewById(a.f.rl_download);
        this.mNi = this.mRt.findViewById(a.f.topKeyboardView);
        this.mRt.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mLz.getVisibility() == 0;
        if (this.mNv > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLz.getLayoutParams();
            layoutParams.topMargin = this.mNv;
            this.mLz.setLayoutParams(layoutParams);
        }
        this.mRt.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mRt.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                str = this.mRI.dEZ().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mRt.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mNy = (ImageView) this.mRt.findViewById(a.f.subscribe_icon);
        this.mNy.setOnClickListener(this);
        this.mNA = (ImageView) this.mRt.findViewById(a.f.report_icon);
        this.mNA.setOnClickListener(this);
        q();
    }

    private void dFm() {
        boolean z;
        this.mNg = this.mRt.findViewById(a.f.bottomview);
        this.mNm = (ImageButton) this.mNg.findViewById(a.f.playbutton);
        this.mNm.setOnTouchListener(this);
        this.mRA = (ImageButton) this.mRt.findViewById(a.f.btn_barrage);
        this.mRB = (ImageButton) this.mRt.findViewById(a.f.btn_audio);
        this.mNu = (ImageView) this.mRt.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mNg.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mNg.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mRA.setVisibility(0);
            this.mNu.setVisibility(8);
            if (this.mRI != null && this.mRI.f != null) {
                for (int i = 0; i < this.mRI.f.size(); i++) {
                    if ("2".equals(this.mRI.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mRB.setVisibility(0);
            } else {
                this.mRB.setVisibility(8);
            }
            this.mNg.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mRA.setOnClickListener(this);
            if (h.dEn().e) {
                this.mRA.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mRA.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mRI.d) {
                this.mRB.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mRB.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mRB.setOnClickListener(this);
            this.mLE = (ImageView) this.mNg.findViewById(a.f.btn_hotword);
            this.mNl = (ImageView) this.mRt.findViewById(a.f.iv_task_badge);
            this.mLE.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mRJ, a.C0795a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dEn().c) {
                        b.this.mLE.clearAnimation();
                        b.this.mLE.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mLE.clearAnimation();
            if (h.dEn().c) {
                this.mLE.startAnimation(animationSet);
                this.mNl.setVisibility(0);
            }
        } else {
            this.mNg.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mNg.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mRA.setVisibility(8);
            this.mRB.setVisibility(8);
            this.mNu.setVisibility(0);
            this.mNu.setOnClickListener(this);
            if (h.dEn().b) {
                this.mNu.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mNu.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mNg.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mRJ != null) {
            ((VideoPlayer) this.mRJ).e(true);
        }
        if (this.mRK != null) {
            this.mRK.cg(null);
            this.mRK = null;
        }
        this.c = null;
        this.mLd = null;
        this.mNs = null;
        if (this.mNr != null) {
            this.mNr.addTextChangedListener(null);
            this.mNr.setOnEditorActionListener(null);
            this.mNr = null;
        }
        this.mLz = null;
        this.mRA = null;
        this.mRB = null;
        this.mNg = null;
        this.mNj = null;
        if (this.mNF != null) {
            this.mNF.a();
            this.mNF = null;
            this.mNG = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dFz() {
        return this.mNF;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mRt == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mSA == null || !this.mSA.a(i, keyEvent)) {
                    if ((this.mNE == null || !this.mNE.onKeyDown(i, keyEvent)) && !dFs() && !dFk()) {
                        if (this.mNi != null && this.mNi.getVisibility() == 0) {
                            aw(false, true);
                            return true;
                        } else if (this.mNt != null && this.mNt.isShown()) {
                            dFI();
                            return true;
                        } else if (this.bT && this.mRK != null) {
                            if (this.mNs != null) {
                                this.mNs.setVisibility(0);
                            }
                            this.mRK.removeMessages(2);
                            this.mRK.A(2, 3000L);
                            return true;
                        } else {
                            aH();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.mRt.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mRt.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mRK != null) {
                    this.mRK.removeMessages(3);
                    this.mRK.A(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dFH() {
        if (this.bT) {
            this.mNs.setVisibility(0);
            this.mRK.removeMessages(2);
            this.mRK.A(2, 3000L);
        }
        return this.bT;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.bT) {
            if (view.getId() == a.f.btn_lockscreen) {
                dFo();
                return;
            }
            this.mNs.setVisibility(0);
            this.mRK.removeMessages(2);
            this.mRK.A(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mRJ, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.ax(getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(getActivity())) {
                    o(view, tv.chushou.zues.utils.systemBar.b.gB(getActivity()), 0);
                    return;
                } else {
                    o(view, 0, 0);
                    return;
                }
            }
            o(view, 0, this.mLz.getHeight() + this.mLz.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mNr.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.mRJ, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mNr.setText((CharSequence) null);
                aw(false, true);
            } else if (a(this.mNr.getText().toString(), false)) {
                aw(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dFo();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.gB(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.mRJ, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            aH();
            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dFR() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mSn == null;
                b(false, false);
                if (z && this.bV > 0 && this.mSn != null && tv.chushou.zues.utils.systemBar.b.ax(getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSn.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.mSn.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mSn == null;
                if (this.mRJ.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.mSn != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mSn.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.mSn.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aw(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ax(false, false);
            this.mRK.A(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dEn().c) {
                h.dEn().b(false);
                this.mLE.clearAnimation();
                this.mNl.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.mNg.findViewById(a.f.ll_keyboard).getLeft(), this.mNg.getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
            } else {
                m(view, this.mNg.findViewById(a.f.ll_keyboard).getLeft(), this.mNg.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                tv.chushou.zues.utils.g.c(this.mRJ, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.mRJ, dFR(), false);
        } else if (id == a.f.btn_screenChange) {
            aH();
        } else if (id == a.f.rl_paoicon) {
            dFj();
        } else if (id == a.f.subscribe_icon) {
            aP();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dFr();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dFp();
            }
        } else if (id == a.f.btn_audio && !this.mRI.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.KB(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mNw <= 3000) {
            tv.chushou.zues.utils.g.KB(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dEn().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
            if (com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a(((VideoPlayer) this.mRJ).dEz().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mNw = System.currentTimeMillis();
                a(this.mRI.dEZ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mRI.h);
                if (!z) {
                    this.mNr.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mRA != null) {
                if (z) {
                    this.mRA.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mRA.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mNu != null) {
            if (z) {
                this.mNu.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mNu.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dFq() {
        if (this.mRt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mRt.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.mSw != null) {
            this.mSw.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mSw.dRk();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dFo() {
        if (this.mRI.d()) {
            if (this.bT) {
                this.mNs.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mRJ, this.mRJ.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mNs.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mRJ, this.mRJ.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.bT = !this.bT;
            if (this.mNr != null) {
                this.mNr.setEnabled(this.bT ? false : true);
            }
        }
    }

    public void aw(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dD(this.mNr);
            this.mNr.setText("");
            this.mNj.setVisibility(8);
            this.mNs.setVisibility(8);
            this.mLz.setVisibility(8);
            this.mNg.setVisibility(8);
            this.mNi.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
        if (this.mNi.getVisibility() != 8 && z2) {
            this.mNi.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_top_anim));
        }
        this.mNj.setVisibility(8);
        this.mNs.setVisibility(8);
        this.mLz.setVisibility(8);
        this.mNg.setVisibility(8);
        this.mNi.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ax(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.mNk != null) {
            this.mNk.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ax(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dFS()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mNC != null) {
                this.mNC.a(this.e);
            }
            return this.e;
        }
        if (this.mRK != null) {
            this.mRK.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mRJ).e(true);
            if (!z3) {
                if (this.mNg.getVisibility() != 0 && z2) {
                    this.mNg.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_bottom_anim));
                }
                this.mNg.setVisibility(0);
                this.mNj.setVisibility(0);
                this.mNs.setVisibility(0);
                this.mNh.setVisibility(o() ? 0 : 8);
            }
            if (this.mLz.getVisibility() != 0 && z2) {
                this.mLz.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_top_anim));
            }
            u(!z3);
            this.mLz.setVisibility(0);
            if (this.mRK != null) {
                this.mRK.A(1, 5000L);
            }
            y(false);
            if (this.mNC != null) {
                this.mNC.a(true);
            }
        } else {
            ((VideoPlayer) this.mRJ).e(false);
            if (this.mSa != null) {
                this.mSa.dismiss();
            }
            if (this.mSb != null) {
                this.mSb.dismiss();
            }
            if (this.mSi != null) {
                this.mSi.dismiss();
            }
            if (this.mNg != null) {
                if (this.mNg.getVisibility() != 8 && z2) {
                    this.mNg.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_bottom_anim));
                }
                this.mNg.setVisibility(8);
            }
            if (this.mNj != null) {
                this.mNj.setVisibility(8);
                if (this.mLz.getVisibility() != 8 && z2) {
                    this.mLz.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_top_anim));
                }
                this.mLz.setVisibility(8);
                this.mNs.setVisibility(8);
                y(true);
                a(false);
                if (this.mNC != null) {
                    this.mNC.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void aM() {
        Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
        if (this.ap == 1) {
            this.ar = Math.min(gv.x, gv.y);
            this.aq = Math.max(gv.x, gv.y);
        } else {
            this.ar = Math.max(gv.x, gv.y);
            this.aq = Math.min(gv.x, gv.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.mNa == null) {
            this.mNa = new Rect(0, 0, i / 5, i2);
        } else {
            this.mNa.set(0, 0, i / 5, i2);
        }
        if (this.mNb == null) {
            this.mNb = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mNb.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mNa == null) {
            return false;
        }
        return this.mNa.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mRt.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mRt.findViewById(a.f.brightness_view);
                    if (findViewById2.getVisibility() == 0) {
                        findViewById2.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.mNb == null) {
            return false;
        }
        return this.mNb.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.mRt.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mRt.findViewById(a.f.volumn_view);
                    if (findViewById2.getVisibility() == 0) {
                        findViewById2.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.bT) {
                    this.mNs.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.bT) {
                    this.mRK.removeMessages(2);
                    this.mRK.A(2, 3000L);
                    return true;
                } else if (this.mRK != null) {
                    this.mRK.A(3, 1000L);
                    this.mRK.A(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.bT) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Jc(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.mRL.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Jd(int i) {
        int streamMaxVolume = (i * 10) / this.mRL.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.mRt.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mRt.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dFS() && parserRet != null) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List)) {
                    List list = (List) sparseArray.get(14);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        for (int i = 0; i < list.size(); i++) {
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i);
                            if (pkNotifyInfo != null) {
                                e.d("guohe", "VideoPlayerFullScreenFragment.onDanmuGetted(): action = " + pkNotifyInfo.mAction);
                                if (pkNotifyInfo.mAction == 6 || pkNotifyInfo.mAction == 7) {
                                    if (this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mRJ).a(1, null, this.H, false, false, true);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements VerticalSeekBarVolumn.a {
        private c() {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar, int i, boolean z) {
            b.this.mRL.setStreamVolume(3, b.this.Jc(i), 0);
            b.this.x(i <= 0);
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar) {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void b(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements VerticalSeekBarVolumn.a {
        private a() {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar, int i, boolean z) {
            b.this.mNc = i / 10.0f;
            ((VideoPlayer) b.this.mRJ).l = b.this.mNc;
            ((VideoPlayer) b.this.mRJ).k = b.this.mNc * 255.0f;
            b.this.mNe.screenBrightness = b.this.mNc;
            b.this.mNd.setAttributes(b.this.mNe);
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar) {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void b(SeekBar seekBar) {
        }
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.aq && motionEvent2.getRawY() <= this.aq) {
            int rawY = (int) (motionEvent.getRawY() - motionEvent2.getRawY());
            int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
            if (aVar.d == 0) {
                int abs = Math.abs(rawY);
                aVar.getClass();
                if (abs > 5 && Math.abs(rawX) < Math.abs(rawY)) {
                    if (c(motionEvent)) {
                        v(false);
                        aVar.getClass();
                        aVar.d = 1;
                        aVar.e = ((VerticalSeekBarVolumn) this.mRt.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mRt.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mLg.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mRt.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mRt.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mNX.getCurrentPos();
                            int duration = this.mNX.getDuration();
                            int i3 = this.j + currentPos;
                            if (i3 < 0) {
                                this.j = 0 - currentPos;
                                i3 = 0;
                            } else if (i3 > duration) {
                                this.j = duration - currentPos;
                                i3 = duration;
                            }
                            this.h.setVisibility(0);
                            this.i.setVisibility(0);
                            this.h.setText(tv.chushou.zues.utils.b.o(i3, false));
                            this.i.setText(tv.chushou.zues.utils.b.o(this.j, true));
                            if (duration > 1000) {
                                this.mLg.setProgress(i3 / (duration / 1000));
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(d.a aVar, MotionEvent motionEvent) {
        if (!this.mNf) {
            if (this.mNi.getVisibility() == 8 && (this.mNt == null || !this.mNt.isShown())) {
                boolean z = this.mRD != null && this.mRD.getVisibility() == 0;
                if (this.e) {
                    ax(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                aw(false, true);
                dFI();
            }
        }
        return false;
    }

    public boolean dFk() {
        if (this.mNf) {
            if (this.mSn != null) {
                this.mSn.e();
            }
            y(false);
            if (this.mNg != null) {
                this.mNg.setVisibility(0);
            }
            if (this.mLz != null) {
                this.mLz.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dFw() {
        super.dFw();
        if (this.mRJ instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mRI != null) {
            this.mRI.f = null;
            if (this.mRI.dEZ() != null) {
                this.mRI.dEZ().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mNX != null) {
                this.mNX.seekTo(0L);
                e(true);
            }
            aH();
            return;
        }
        aH();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bT) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                tv.chushou.zues.utils.g.c(this.mRJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mNX.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.mNI != null) {
                            this.mNI.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mRI.a(false);
                            ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                        } else if (this.mNX.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.mNX.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mNX.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wE(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.mNX.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mNX.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                tv.chushou.zues.utils.g.c(this.mRJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mRI.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                    this.ai = false;
                    wE(true);
                    a(false, !this.ak);
                } else if (this.mNX.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                    this.ai = false;
                    wE(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void aN() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.mRI != null && this.mRI.dFc() != null) {
                str = this.mRI.dFc().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dEh().mIx != null && com.kascend.chushou.a.a.dEh().mIx.contains(str) && this.mRI != null && !this.mNR) {
            this.mNR = true;
            com.kascend.chushou.a.a.dEh().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
                @Override // com.kascend.chushou.a.a.c
                public void a(List<ListItem> list) {
                    boolean z;
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            z = false;
                            break;
                        } else if (list.get(i).mAdExtraInfo != null && str.equals(list.get(i).mAdExtraInfo.mCode)) {
                            b.this.b(list.get(i));
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        b.this.mNR = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mNI != null) {
            this.mNI.a(listItem, this.ap == 1, a.C0795a.zues_sweetalert_modal_in, a.C0795a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mNR = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mNm != null) {
                this.mNm.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mRD != null) {
                this.mRD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNm != null) {
            this.mNm.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mRD != null) {
                    this.mRD.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mRJ);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mRt).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mSw != null) {
            this.mSw.dRk();
            this.mSw.setVisibility(8);
            this.mSw.unInit();
            ((RelativeLayout) this.mRt).removeView(this.mSw);
            this.mSw = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mRt).removeView(this.N);
            this.N = null;
        }
        aO();
        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.mRK != null) {
            y(true);
            this.mRK.removeMessages(1);
            this.mNg.setVisibility(0);
            this.mNj.setVisibility(8);
            this.mLz.setVisibility(8);
            this.mNs.setVisibility(8);
        }
        if (this.mSi == null) {
            al();
            this.mSi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mLE.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mSi.isShowing()) {
            this.mSi.showAtLocation(view, 83, i, i2);
            this.mLE.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
            return;
        }
        this.mSi.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mNE != null && this.mNE.b()) {
                this.mNE.getGlobalVisibleRect(this.mNT);
                if (!this.mNT.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mNE.a();
                    return true;
                }
            }
            if (this.mNf && f(this.mSn.b, motionEvent)) {
                dFk();
                return true;
            }
            if (!dFH()) {
                if (System.currentTimeMillis() - this.mNS < 300 && this.mNI != null && this.mNI.isShown()) {
                    this.mNI.a();
                    if (this.mNX.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mRI.a(false);
                            ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                        } else if (this.mNX.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mRJ).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.mNX.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mNX.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wE(true);
                        }
                    }
                    return true;
                }
                this.mNS = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dFI() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
        if (this.mNt != null) {
            if (this.mNt.isShown()) {
                this.mNt.startAnimation(AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_top_anim));
            }
            this.mNt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mRJ).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mRJ).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mRB != null) {
                this.mRB.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gC(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNj.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.mNj.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mLz.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.mLz.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mNi.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.mNi.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mNg.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.mNg.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
            this.mNy.setVisibility(0);
            if (this.mRI.dEZ().mRoominfo.mIsSubscribed) {
                this.mNy.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mNy.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mNy.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void aP() {
        RoomInfo roomInfo;
        if (this.mRI != null && this.mRI.dEZ() != null && (roomInfo = this.mRI.dEZ().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mRJ, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dSC();
                        b.this.z(true);
                    }
                });
            } else {
                z(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z(final boolean z) {
        RoomInfo roomInfo;
        String str;
        if (this.mRI != null && this.mRI.dEZ() != null && (roomInfo = this.mRI.dEZ().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dFS()) {
                        b.this.t(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dFS()) {
                        b.this.t(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.F(b.this.mRJ, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.mRJ, a.i.subscribe_success);
                            }
                            if (b.this.mRI != null && b.this.mRI.dEZ() != null && (roomInfo2 = b.this.mRI.dEZ().mRoominfo) != null) {
                                roomInfo2.mIsSubscribed = roomInfo2.mIsSubscribed ? false : true;
                                b.this.q();
                                return;
                            }
                            return;
                        }
                        a(optInt, optString);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!b.this.dFS()) {
                        b.this.t(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mRJ, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mRJ, str2);
                    }
                }
            };
            if (this.mRI != null && this.mRI.h != null) {
                try {
                    str = new JSONObject(this.mRI.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dEj().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dEj().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                }
            }
            str = null;
            String a22 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
            if (!z) {
            }
        }
    }

    public void t(boolean z) {
        if (z) {
            if (this.mNz == null) {
                this.mNz = new ProgressDialog(this.mRJ);
                this.mNz.setProgressStyle(0);
                this.mNz.requestWindowFeature(1);
                this.mNz.setMessage(this.mRJ.getText(a.i.update_userinfo_ing));
                this.mNz.setCancelable(true);
            }
            if (!this.mNz.isShowing()) {
                this.mNz.show();
            }
        } else if (this.mNz != null && this.mNz.isShowing()) {
            this.mNz.dismiss();
        }
    }

    private void dFp() {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
            if (this.mNB == null) {
                this.mNB = new f(getActivity());
            }
            this.mNB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mNB = null;
                }
            });
            RoomInfo roomInfo = this.mRI.dEZ().mRoominfo;
            this.mNB.a();
            this.mNB.a(roomInfo);
            if (!this.mNB.isShowing()) {
                this.mNB.show();
            }
        }
    }

    private void dFr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mNQ != null && this.mRL != null && this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mNQ;
            VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
            verticalSeekBarVolumn.setProgressOnly(Jd(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mLh != null) {
            this.mLh.dSe();
        }
        if (this.mRt != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mNC == null) {
                this.mNC = new com.kascend.chushou.player.ui.giftpopup.a(this.mRt, i);
            } else if (this.mNC.a() != i) {
                this.mNC.b();
                this.mNC = null;
                this.mNC = new com.kascend.chushou.player.ui.giftpopup.a(this.mRt, i);
            }
            List<ListItem> j = this.mRI != null ? this.mRI.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
            if (videoPlayer != null) {
                this.mNC.a(j, videoPlayer.dEF(), videoPlayer.dEG(), videoPlayer.dEH(), videoPlayer.dEI());
                this.mNC.a(this.e);
                if (this.mRI != null && this.mRI.mKO != null) {
                    this.mNC.a(this.mRI.mKO, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mRI != null) {
                                b.this.mRI.mKO = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mNC != null && this.mRI != null) {
                    this.mNC.b(this.mRI.mKQ);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void a(int i) {
        if (this.mNC != null && this.mRJ != null) {
            this.mNC.a(((VideoPlayer) this.mRJ).dEF());
            this.mNC.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void D() {
        if (this.mRJ instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dEF = ((VideoPlayer) this.mRJ).dEF();
            if (this.mSA == null) {
                this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mSA.setVisibility(0);
            this.mSA.a(i, dEF);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mNC != null) {
            this.mNC.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mNp != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mNp.setVisibility(0);
                    this.mNp.bV(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mNp.setVisibility(8);
                }
            }
            if (this.mNn != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mNo.setVisibility(0);
                    this.mNn.bV(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mNo.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mNC != null) {
            this.mNC.a(((VideoPlayer) this.mRJ).dEG());
            this.mNC.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mNC != null) {
            this.mNC.a(((VideoPlayer) this.mRJ).dEG());
            this.mNC.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(long j) {
        if (this.mNC != null) {
            this.mNC.a(((VideoPlayer) this.mRJ).dEH());
            this.mNC.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0808a
    public void c(int i) {
        if (this.mNC != null) {
            this.mNC.a(((VideoPlayer) this.mRJ).dEI());
            this.mNC.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wD(false);
        super.F();
    }

    private void c(View view) {
        this.mNJ = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mMh = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mMh.setText(new tv.chushou.zues.widget.a.c().J(this.mRJ, a.e.videoplayer_4g_video).append("  ").append(this.mRJ.getString(a.i.videoplayer_4g_video)));
        this.mNK = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mNK.setText(new tv.chushou.zues.widget.a.c().J(this.mRJ, a.e.videoplayer_4g_audio).append("  ").append(this.mRJ.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.aH();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mRJ, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mNJ.setVisibility(8);
                    ((VideoPlayer) b.this.mRJ).c(b.this.mMj);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mNJ.setVisibility(8);
                    ((VideoPlayer) b.this.mRJ).d(b.this.mMj);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
        findViewById.setLayoutParams(layoutParams);
        this.mMh.setOnClickListener(onClickListener);
        this.mNK.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mRI != null && !tv.chushou.zues.utils.h.isEmpty(this.mRI.f)) {
            f(this.mRI.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mMj = z;
            this.p = false;
            if (this.mRI != null && this.mRI.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mRI.f.size()) {
                        break;
                    } else if (!"2".equals(this.mRI.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mNJ != null) {
                this.mNJ.setVisibility(0);
                this.mMh.setVisibility(0);
                this.mNK.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mNJ != null) {
            this.mNJ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mNC != null && this.mRI != null) {
            this.mNC.b(this.mRI.mKQ);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mRt != null && (findViewById = this.mRt.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mNn != null) {
            this.mNn.performClick();
        }
    }
}
