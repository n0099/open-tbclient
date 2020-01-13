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
import android.widget.Toast;
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
/* loaded from: classes4.dex */
public class b extends d implements View.OnClickListener, View.OnTouchListener {
    private TextView mRF;
    private boolean mRH;
    private LinearLayout mSO;
    private FrameLayout mST;
    private FrescoThumbnailView mSU;
    private ImageView mSX;
    private ImageView mSZ;
    private VerticalSeekBarVolumn mTC;
    private long mTE;
    public int mTd;
    RelativeLayout mTe;
    private ImageView mTf;
    private ImageView mTh;
    private f mTi;
    private com.kascend.chushou.player.ui.giftpopup.a mTl;
    private PopH5Menu mTn;
    private com.kascend.chushou.player.b.a mTp;
    private GiftAnimationLayout mTq;
    private ImageView mTr;
    private FoodView mTs;
    private RelativeLayout mTt;
    private TextView mTu;
    private Rect mSE = null;
    private Rect mSF = null;
    private float mSG = 0.0f;
    private Window mSH = null;
    private WindowManager.LayoutParams mSI = null;
    private boolean mSJ = false;
    private View mSK = null;
    private View mQX = null;
    private View mSL = null;
    private View mSM = null;
    private View mSN = null;
    private ImageView mRd = null;
    private ImageView mSQ = null;
    private ImageButton mSR = null;
    private FrescoThumbnailView mSS = null;
    private LinearLayout mSV = null;
    private EditText mSW = null;
    private View mSY = null;
    private boolean mTa = false;
    private int bU = 0;
    private int mTb = 0;
    private long mTc = 0;
    private ProgressDialog mTg = null;
    private boolean mTk = true;
    private int mTm = -1;
    private boolean mTv = false;
    private TextView mTw = null;
    private TextView mTz = null;
    private int mTA = 0;
    private boolean mTB = false;
    private boolean mTD = false;
    private final Rect mTF = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTd = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mQH = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXg = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mTd;
        if (this.mXw != null && !((Activity) this.mXw).isFinishing()) {
            dCo();
        }
        return this.mXg;
    }

    public void dBC() {
        av(false, false);
        super.p(true);
        com.kascend.chushou.toolkit.a.c.a(this.mXw, "能量_num", "横屏", new Object[0]);
    }

    public boolean dBQ() {
        if (this.mYf == null || !this.mYf.isShown()) {
            return false;
        }
        this.mYf.d();
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
        if (z3 || this.mXg.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dAK().e;
        } else {
            z = h.dAK().b;
        }
        q(z);
        if (this.mYb != null) {
            this.mYb.b();
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
        if (this.mTl != null) {
            this.mTl.b();
            this.mTl = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cq(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            dBJ();
            y();
            if (this.mQH != null) {
                this.mQH.onConfigurationChanged(configuration);
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
        if (this.mTn != null && this.mTm != i3) {
            this.mTn.a();
            this.mTn = null;
        }
        if (this.mTn == null) {
            this.mTn = (PopH5Menu) ((ViewStub) this.mXg.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point he = tv.chushou.zues.utils.a.he(getActivity());
            if (this.ap == 0) {
                int i4 = he.y;
                i = he.y;
                i2 = i4;
            } else {
                int i5 = he.x;
                int i6 = he.y - ((he.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTn.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mTn.setLayoutParams(layoutParams);
            this.mTm = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mTn.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dCE()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mXw instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dBb = ((VideoPlayer) this.mXw).dBb();
                    if (this.mYm == null) {
                        this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYm.setVisibility(0);
                    this.mYm.a(i, dBb);
                }
            } else if (bVar.a == 3) {
                if (this.mXw instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dBc = ((VideoPlayer) this.mXw).dBc();
                    if (this.mYm == null) {
                        this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYm.setVisibility(0);
                    this.mYm.a(i, dBc);
                }
            } else if (bVar.a == 9) {
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dBw;
        if (!dCE() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mXv != null && mVar.b.equals(this.mXv.a) && (dBw = this.mXv.dBw()) != null) {
            dBw.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dCo() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.bU = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw);
        this.mTb = tv.chushou.zues.utils.systemBar.b.hj(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.mTb);
        this.mTJ = ((VideoPlayer) this.mXw).dAS();
        this.mXv = ((VideoPlayer) this.mXw).dAV();
        c(this.mXg);
        if (this.aw.equals("1")) {
            this.mQF = ((VideoPlayer) this.mXw).dAW();
            this.mQF.a(this);
            if (this.mTp != null) {
                this.mTp.a();
                this.mTp = null;
                this.mTq = null;
            }
            this.mTq = (GiftAnimationLayout) this.mXg.findViewById(a.f.ll_gift_animation);
            this.mTq.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mXv != null) {
                this.mTp = new com.kascend.chushou.player.b.a(this.mXw.getApplicationContext(), this.mTq);
                this.mTp.a(this.mXv);
            }
            this.B = (TextView) this.mXg.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dBL();
        if (this.mQF != null) {
            this.mQF.d();
        }
        dCk();
        this.mSX = (ImageView) this.mXg.findViewById(a.f.btn_lockscreen);
        this.mSX.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mXg.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mXq = (PlayerErrorView) this.mXg.findViewById(a.f.view_net_error_msg);
        this.mXq.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dBF();
        cWu();
        this.mYf = (PaoGuideView) this.mXg.findViewById(a.f.rlPaoGuideView);
        this.mTr = (ImageView) this.mXg.findViewById(a.f.iv_send_danmu);
        this.mSN = this.mXg.findViewById(a.f.rt_layout);
        this.mSS = (FrescoThumbnailView) this.mSN.findViewById(a.f.btn_gift);
        this.mST = (FrameLayout) this.mSN.findViewById(a.f.flfl_bottom_gift);
        this.mSU = (FrescoThumbnailView) this.mSN.findViewById(a.f.btn_recharge);
        this.mSU.setOnClickListener(this);
        a(this.mXv == null ? null : this.mXv.mQp);
        this.mYl = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mSJ = false;
                b.this.wh(false);
                if (b.this.mXx != null) {
                    b.this.mXx.removeMessages(1);
                    b.this.mXx.L(1, 5000L);
                }
                b.this.mSX.setVisibility(0);
                b.this.mSN.setVisibility(0);
                b.this.mQX.setVisibility(0);
                b.this.mSK.setVisibility(0);
                if (b.this.mTl != null) {
                    b.this.mTl.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mXw, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mSJ = true;
                b.this.wh(true);
                b.this.mSX.setVisibility(8);
                b.this.mSN.setVisibility(8);
                if (b.this.mTl != null) {
                    b.this.mTl.a(false);
                }
                b.this.mQX.setVisibility(8);
                b.this.mSK.setVisibility(8);
                if (b.this.mXx != null) {
                    b.this.mXx.removeMessages(1);
                }
                if (b.this.mYb != null) {
                    b.this.mYb.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mXw, 14.0f) + b.this.mYb.getMeasuredHeight(), 12);
                }
            }
        };
        this.mSV = (LinearLayout) this.mXg.findViewById(a.f.rl_seekbar);
        this.mTe = (RelativeLayout) this.mXg.findViewById(a.f.rl_paoicon);
        this.mTe.setOnClickListener(this);
        this.mYc = (RoundProgressBar) this.mXg.findViewById(a.f.roundProgressBar);
        this.mYe = (FrescoThumbnailView) this.mXg.findViewById(a.f.iv_paoicon);
        this.mYd = (TextView) this.mXg.findViewById(a.f.tv_paonum);
        this.aNY = 0;
        this.mYg = 0L;
        com.kascend.chushou.player.ui.a.a dBe = ((VideoPlayer) this.mXw).dBe();
        a(dBe.dCL());
        BangInfo dCM = dBe.dCM();
        if (dCM != null) {
            a(dCM, dBe.d());
        }
        if (this.aw.equals("3")) {
            this.mSV.setVisibility(0);
            this.mST.setVisibility(8);
            this.mTr.setVisibility(0);
            this.mTr.setOnClickListener(this);
        } else {
            this.mTr.setVisibility(8);
            this.mSV.setVisibility(8);
            this.mST.setVisibility(0);
            this.mSS.setOnClickListener(this);
        }
        dBG();
        if (tv.chushou.zues.utils.systemBar.b.hk(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSN.getLayoutParams();
            layoutParams.rightMargin += this.mTb;
            this.mSN.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mQX.getLayoutParams();
            layoutParams2.rightMargin += this.mTb;
            this.mQX.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mSM.getLayoutParams();
            layoutParams3.rightMargin += this.mTb;
            this.mSM.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mSK.getLayoutParams();
            layoutParams4.rightMargin += this.mTb;
            this.mSK.setLayoutParams(layoutParams4);
        }
        dCq();
        dBD();
        dBJ();
        this.h = (TextView) this.mXg.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXg.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mXv.dBu() != null) {
                this.mTh.setVisibility(0);
            } else {
                this.mTh.setVisibility(8);
            }
        }
        dCp();
        n();
        MG(100);
        this.mTs = (FoodView) this.mXg.findViewById(a.f.kav_room_ad);
        this.mXx = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.av(false, true);
                            break;
                        case 2:
                            b.this.mXx.removeMessages(2);
                            if (b.this.mSX != null) {
                                b.this.mSX.setVisibility(8);
                                break;
                            }
                            break;
                        case 3:
                            b.this.u(true);
                            break;
                        case 4:
                            b.this.v(true);
                            break;
                        case 5:
                            TextView textView = (TextView) b.this.mXg.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mXw.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mXx.L(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mXx.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mXx.L(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.au(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mXw).q) {
                                b.this.a(b.this.mXx);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mXw).q) {
                                b.this.b(b.this.mXx);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mXw).g = true;
                            b.this.mTJ.seekTo((int) b.this.kVr);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mXv.d()) {
                                b.this.mTJ.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mTJ.getPlayState() == 4) {
                                int currentPos = b.this.mTJ.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mXx != null) {
                                    b.this.mXx.L(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dCH();
                            break;
                        case 18:
                            b.this.cWt();
                            break;
                        case 19:
                            b.this.mXu.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mXv != null) {
            a(this.mXv.dBv());
        }
        if (this.mTJ != null && (this.mTJ.getPlayState() == 3 || this.mTJ.getPlayState() == 4)) {
            wj(false);
            if (this.mXv.d()) {
                this.ak = false;
                wk(true);
                if (this.mTJ.getDuration() > 60000) {
                    if (this.mTJ.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mTJ.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mTJ.getDuration();
                }
            }
            this.e = false;
            av(true, false);
            this.mXx.Oc(8);
            if (h() && this.mTJ.getPlayState() == 4 && this.mXx != null) {
                this.mXx.removeMessages(15);
                this.mXx.Oc(15);
            }
        } else {
            wj(true);
            if (this.e) {
                av(false, false);
            } else {
                wh(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dAJ = g.dAJ();
            int i = dAJ.length == 2 ? dAJ[1] : 0;
            if (i > 0) {
                View findViewById = this.mXg.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mXg.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mXw, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        dCG();
        MN(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mXw, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mXw != null && (this.mXw instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXw).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mSU.xi(a.e.ic_recharge_old);
            this.mSS.xi(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mTv && !this.k) {
            try {
                if (this.mTJ != null) {
                    i = this.mTJ.getCurrentPos();
                    i2 = this.mTJ.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mQG.setProgress(i / (i2 / 1000));
                    this.mTw.setText(tv.chushou.zues.utils.b.q(this.mTJ.getDuration(), false));
                    this.mTz.setText(tv.chushou.zues.utils.b.q(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dCp() {
        this.mQG = (ProgressBar) this.mXg.findViewById(a.f.progressBarl);
        if (this.mQG != null) {
            if (this.mQG instanceof SeekBar) {
                ((SeekBar) this.mQG).setOnSeekBarChangeListener(new C0689b());
            }
            this.mQG.setMax(1000);
        }
        this.mTw = (TextView) this.mXg.findViewById(a.f.tv_time_duration);
        this.mTz = (TextView) this.mXg.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mXg.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXg.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dBe;
        BangInfo dCM;
        if (config != null) {
            this.mYi = config;
            if (!config.display) {
                this.mTe.setVisibility(8);
            } else if ((this.mXw instanceof VideoPlayer) && (dCM = (dBe = ((VideoPlayer) this.mXw).dBe()).dCM()) != null) {
                a(dCM, dBe.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mYi == null || this.mYi.display) && this.mTe != null) {
            this.mTe.setVisibility(0);
            this.mYd.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mXw instanceof VideoPlayer) {
            if ((this.mYi == null || this.mYi.display) && this.mTe != null) {
                if (j > 0) {
                    this.mTe.setVisibility(0);
                    boolean z = this.mYh;
                    this.mYh = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mXw.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mYd.setText(cVar);
                    return;
                }
                this.mYh = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0689b implements SeekBar.OnSeekBarChangeListener {
        C0689b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.mTA != i || b.this.mTB != z) {
                    b.this.mTA = i;
                    b.this.mTB = z;
                    if (z) {
                        if (b.this.mTv) {
                            b.this.kVr = (b.this.mTJ.getDuration() / 1000) * i;
                        }
                        b.this.mTz.setText(tv.chushou.zues.utils.b.q((int) b.this.kVr, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.q((int) b.this.kVr, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.q(((int) b.this.kVr) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mTv = true;
            b.this.m = b.this.mTJ.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mXx != null) {
                if (b.this.mTv) {
                    b.this.mTv = false;
                }
                b.this.mXx.removeMessages(14);
                b.this.mXx.Oc(14);
            }
        }
    }

    private void MG(int i) {
        this.mQG.setSecondaryProgress((i * 1000) / 100);
    }

    private void dCk() {
        this.mTC = (VerticalSeekBarVolumn) this.mXg.findViewById(a.f.volumn_seekbar);
        this.mTC.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mXy.getStreamVolume(3);
        this.mTC.setProgress(MM(streamVolume));
        wg(MM(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mXg.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mQD = new d.a();
            this.c = new GestureDetector(this.mXw, this.mQD);
        }
    }

    private void dCq() {
        if (this.mSH == null) {
            this.mSH = ((Activity) this.mXw).getWindow();
        }
        this.mSI = this.mSH.getAttributes();
        this.mSG = ((VideoPlayer) this.mXw).k / 255.0f;
        ((VerticalSeekBarVolumn) this.mXg.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mSG));
    }

    private void dBD() {
        this.mXg.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mXg.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mXw.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mXg.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mSW == null) {
            this.mSW = (EditText) this.mXg.findViewById(a.f.et_input);
            this.mSW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mXg.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBE() {
        if (this.mTi != null) {
            this.mTi.dismiss();
            this.mTi = null;
        }
        if (this.mXw != null) {
            ((VideoPlayer) this.mXw).a(1, null, this.H, false);
        }
    }

    private void dBF() {
        this.mQX = this.mXg.findViewById(a.f.topview);
        this.mSO = (LinearLayout) this.mXg.findViewById(a.f.topRight);
        this.mSL = this.mQX.findViewById(a.f.rl_download);
        this.mSM = this.mXg.findViewById(a.f.topKeyboardView);
        this.mXg.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mQX.getVisibility() == 0;
        if (this.bU > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mQX.getLayoutParams();
            layoutParams.topMargin = this.bU;
            this.mQX.setLayoutParams(layoutParams);
        }
        this.mXg.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mXg.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                str = this.mXv.dBu().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mXg.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mTf = (ImageView) this.mXg.findViewById(a.f.subscribe_icon);
        this.mTf.setOnClickListener(this);
        this.mTh = (ImageView) this.mXg.findViewById(a.f.report_icon);
        this.mTh.setOnClickListener(this);
        q();
    }

    private void dBG() {
        boolean z;
        this.mSK = this.mXg.findViewById(a.f.bottomview);
        this.mSR = (ImageButton) this.mSK.findViewById(a.f.playbutton);
        this.mSR.setOnTouchListener(this);
        this.mXn = (ImageButton) this.mXg.findViewById(a.f.btn_barrage);
        this.mXo = (ImageButton) this.mXg.findViewById(a.f.btn_audio);
        this.mSZ = (ImageView) this.mXg.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mSK.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mSK.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mXn.setVisibility(0);
            this.mSZ.setVisibility(8);
            if (this.mXv != null && this.mXv.f != null) {
                for (int i = 0; i < this.mXv.f.size(); i++) {
                    if ("2".equals(this.mXv.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mXo.setVisibility(0);
            } else {
                this.mXo.setVisibility(8);
            }
            this.mSK.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mXn.setOnClickListener(this);
            if (h.dAK().e) {
                this.mXn.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXn.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mXv.d) {
                this.mXo.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mXo.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mXo.setOnClickListener(this);
            this.mRd = (ImageView) this.mSK.findViewById(a.f.btn_hotword);
            this.mSQ = (ImageView) this.mXg.findViewById(a.f.iv_task_badge);
            this.mRd.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mXw, a.C0682a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dAK().c) {
                        b.this.mRd.clearAnimation();
                        b.this.mRd.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRd.clearAnimation();
            if (h.dAK().c) {
                this.mRd.startAnimation(animationSet);
                this.mSQ.setVisibility(0);
            }
        } else {
            this.mSK.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mSK.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mXn.setVisibility(8);
            this.mXo.setVisibility(8);
            this.mSZ.setVisibility(0);
            this.mSZ.setOnClickListener(this);
            if (h.dAK().b) {
                this.mSZ.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mSZ.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mSK.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mXw != null) {
            ((VideoPlayer) this.mXw).d(true);
        }
        if (this.mXx != null) {
            this.mXx.cp(null);
            this.mXx = null;
        }
        this.c = null;
        this.mQD = null;
        this.mSX = null;
        if (this.mSW != null) {
            this.mSW.addTextChangedListener(null);
            this.mSW.setOnEditorActionListener(null);
            this.mSW = null;
        }
        this.mQX = null;
        this.mXn = null;
        this.mXo = null;
        this.mSK = null;
        this.mSN = null;
        if (this.mTp != null) {
            this.mTp.a();
            this.mTp = null;
            this.mTq = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dCe() {
        return this.mTp;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mXg == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mYm == null || !this.mYm.a(i, keyEvent)) {
                    if ((this.mTn == null || !this.mTn.onKeyDown(i, keyEvent)) && !dBQ() && !dBR()) {
                        if (this.mSM != null && this.mSM.getVisibility() == 0) {
                            au(false, true);
                            return true;
                        } else if (this.mSY != null && this.mSY.isShown()) {
                            dCs();
                            return true;
                        } else if (this.mTa && this.mXx != null) {
                            if (this.mSX != null) {
                                this.mSX.setVisibility(0);
                            }
                            this.mXx.removeMessages(2);
                            this.mXx.L(2, 3000L);
                            return true;
                        } else {
                            dBE();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                u(false);
                int progress = ((VerticalSeekBarVolumn) this.mXg.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mXg.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mXx != null) {
                    this.mXx.removeMessages(3);
                    this.mXx.L(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dCr() {
        if (this.mTa) {
            this.mSX.setVisibility(0);
            this.mXx.removeMessages(2);
            this.mXx.L(2, 3000L);
        }
        return this.mTa;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.mTa) {
            if (view.getId() == a.f.btn_lockscreen) {
                dBI();
                return;
            }
            this.mSX.setVisibility(0);
            this.mXx.removeMessages(2);
            this.mXx.L(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mXw, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aC(getActivity()) && tv.chushou.zues.utils.systemBar.b.aD(getActivity())) {
                    l(view, tv.chushou.zues.utils.systemBar.b.hj(getActivity()), 0);
                    return;
                } else {
                    l(view, 0, 0);
                    return;
                }
            }
            l(view, 0, this.mQX.getHeight() + this.mQX.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mSW.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.M(this.mXw, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mSW.setText((CharSequence) null);
                au(false, true);
            } else if (a(this.mSW.getText().toString(), false)) {
                au(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dBI();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                m(view, tv.chushou.zues.utils.systemBar.b.hj(getActivity()), 0);
            } else {
                m(view, 0, tv.chushou.zues.utils.a.dip2px(this.mXw, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            m(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dBE();
            com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = nL() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mYb == null;
                b(false, false);
                if (z && this.mTb > 0 && this.mYb != null && tv.chushou.zues.utils.systemBar.b.aC(getActivity()) && tv.chushou.zues.utils.systemBar.b.aD(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYb.getLayoutParams();
                    layoutParams.rightMargin += this.mTb;
                    this.mYb.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mYb == null;
                if (this.mXw.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.mTb > 0 && this.mYb != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mYb.getLayoutParams();
                    layoutParams2.bottomMargin += this.mTb;
                    this.mYb.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXv.dBu().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            au(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            av(false, false);
            this.mXx.L(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dAK().c) {
                h.dAK().b(false);
                this.mRd.clearAnimation();
                this.mSQ.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                j(view, this.mSK.findViewById(a.f.ll_keyboard).getLeft(), this.mSK.getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
            } else {
                j(view, this.mSK.findViewById(a.f.ll_keyboard).getLeft(), this.mSK.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                tv.chushou.zues.utils.g.c(this.mXw, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.e(this.mXw, nL(), false);
        } else if (id == a.f.btn_screenChange) {
            dBE();
        } else if (id == a.f.rl_paoicon) {
            dBC();
        } else if (id == a.f.subscribe_icon) {
            dBM();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dBP();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dBN();
            }
        } else if (id == a.f.btn_audio && !this.mXv.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            Toast.makeText(this.mXw, a.i.str_same_content, 0).show();
            return false;
        } else if (System.currentTimeMillis() - this.mTc <= 3000) {
            Toast.makeText(this.mXw, a.i.str_too_fast, 0).show();
            return false;
        } else {
            if (!h.dAK().e) {
                r(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
            if (com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a(((VideoPlayer) this.mXw).dAV().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mTc = System.currentTimeMillis();
                a(this.mXv.dBu().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mXv.h);
                if (!z) {
                    this.mSW.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void q(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mXn != null) {
                if (z) {
                    this.mXn.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXn.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mSZ != null) {
            if (z) {
                this.mSZ.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mSZ.setImageResource(a.e.btn_barrage_close_n);
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

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mYj != null) {
            this.mYj.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mYj.dOn();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dBI() {
        if (this.mXv.d()) {
            if (this.mTa) {
                this.mSX.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mXw, this.mXw.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mSX.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mXw, this.mXw.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.mTa = !this.mTa;
            if (this.mSW != null) {
                this.mSW.setEnabled(this.mTa ? false : true);
            }
        }
    }

    public void au(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mSW);
            this.mSW.setText("");
            this.mSN.setVisibility(8);
            this.mSX.setVisibility(8);
            this.mQX.setVisibility(8);
            this.mSK.setVisibility(8);
            this.mSM.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
        if (this.mSM.getVisibility() != 8 && z2) {
            this.mSM.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_top_anim));
        }
        this.mSN.setVisibility(8);
        this.mSX.setVisibility(8);
        this.mQX.setVisibility(8);
        this.mSK.setVisibility(8);
        this.mSM.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        av(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mSO != null) {
            this.mSO.setVisibility(z ? 0 : 4);
        }
    }

    public boolean av(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dCE()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mTl != null) {
                this.mTl.a(this.e);
            }
            return this.e;
        }
        if (this.mXx != null) {
            this.mXx.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mXw).d(true);
            if (!z3) {
                if (this.mSK.getVisibility() != 0 && z2) {
                    this.mSK.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_bottom_anim));
                }
                this.mSK.setVisibility(0);
                this.mSN.setVisibility(0);
                this.mSX.setVisibility(0);
                this.mSL.setVisibility(o() ? 0 : 8);
            }
            if (this.mQX.getVisibility() != 0 && z2) {
                this.mQX.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_top_anim));
            }
            t(!z3);
            this.mQX.setVisibility(0);
            if (this.mXx != null) {
                this.mXx.L(1, 5000L);
            }
            wh(false);
            if (this.mTl != null) {
                this.mTl.a(true);
            }
        } else {
            ((VideoPlayer) this.mXw).d(false);
            if (this.mXN != null) {
                this.mXN.dismiss();
            }
            if (this.mXO != null) {
                this.mXO.dismiss();
            }
            if (this.mXV != null) {
                this.mXV.dismiss();
            }
            if (this.mSK != null) {
                if (this.mSK.getVisibility() != 8 && z2) {
                    this.mSK.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_bottom_anim));
                }
                this.mSK.setVisibility(8);
            }
            if (this.mSN != null) {
                this.mSN.setVisibility(8);
                if (this.mQX.getVisibility() != 8 && z2) {
                    this.mQX.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_top_anim));
                }
                this.mQX.setVisibility(8);
                this.mSX.setVisibility(8);
                wh(true);
                a(false);
                if (this.mTl != null) {
                    this.mTl.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dBJ() {
        Point he = tv.chushou.zues.utils.a.he(this.mXw);
        if (this.ap == 1) {
            this.ar = Math.min(he.x, he.y);
            this.mXA = Math.max(he.x, he.y);
        } else {
            this.ar = Math.max(he.x, he.y);
            this.mXA = Math.min(he.x, he.y);
        }
        int i = this.ar;
        int i2 = this.mXA;
        if (this.mSE == null) {
            this.mSE = new Rect(0, 0, i / 5, i2);
        } else {
            this.mSE.set(0, 0, i / 5, i2);
        }
        if (this.mSF == null) {
            this.mSF = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mSF.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mSE == null) {
            return false;
        }
        return this.mSE.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        View findViewById = this.mXg.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXg.findViewById(a.f.brightness_view);
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
        if (this.mSF == null) {
            return false;
        }
        return this.mSF.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mXg.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXg.findViewById(a.f.volumn_view);
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
                if (this.mTa) {
                    this.mSX.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.mTa) {
                    this.mXx.removeMessages(2);
                    this.mXx.L(2, 3000L);
                    return true;
                } else if (this.mXx != null) {
                    this.mXx.L(3, 1000L);
                    this.mXx.L(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.mTa) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ML(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.mXy.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mXw;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int MM(int i) {
        int streamMaxVolume = (i * 10) / this.mXy.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(boolean z) {
        if (z) {
            this.mXg.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mXg.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dCE() && parserRet != null) {
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
                                    if (this.mXw != null && (this.mXw instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mXw).a(1, null, this.H, false, false, true);
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
    /* loaded from: classes4.dex */
    public class c implements VerticalSeekBarVolumn.a {
        private c() {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar, int i, boolean z) {
            b.this.mXy.setStreamVolume(3, b.this.ML(i), 0);
            b.this.wg(i <= 0);
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar) {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void b(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements VerticalSeekBarVolumn.a {
        private a() {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar, int i, boolean z) {
            b.this.mSG = i / 10.0f;
            ((VideoPlayer) b.this.mXw).l = b.this.mSG;
            ((VideoPlayer) b.this.mXw).k = b.this.mSG * 255.0f;
            b.this.mSI.screenBrightness = b.this.mSG;
            b.this.mSH.setAttributes(b.this.mSI);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mXA && motionEvent2.getRawY() <= this.mXA) {
            int rawY = (int) (motionEvent.getRawY() - motionEvent2.getRawY());
            int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
            if (aVar.d == 0) {
                int abs = Math.abs(rawY);
                aVar.getClass();
                if (abs > 5 && Math.abs(rawX) < Math.abs(rawY)) {
                    if (c(motionEvent)) {
                        u(false);
                        aVar.getClass();
                        aVar.d = 1;
                        aVar.e = ((VerticalSeekBarVolumn) this.mXg.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        v(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mXg.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mQG.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mXg.findViewById(a.f.volumn_seekbar);
                    u(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mXg.findViewById(a.f.brightness_seekbar);
                        v(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mTJ.getCurrentPos();
                            int duration = this.mTJ.getDuration();
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
                            this.h.setText(tv.chushou.zues.utils.b.q(i3, false));
                            this.i.setText(tv.chushou.zues.utils.b.q(this.j, true));
                            if (duration > 1000) {
                                this.mQG.setProgress(i3 / (duration / 1000));
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
        if (!this.mSJ) {
            if (this.mSM.getVisibility() == 8 && (this.mSY == null || !this.mSY.isShown())) {
                boolean z = this.mXq != null && this.mXq.getVisibility() == 0;
                if (this.e) {
                    av(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                au(false, true);
                dCs();
            }
        }
        return false;
    }

    public boolean dBR() {
        if (this.mSJ) {
            if (this.mYb != null) {
                this.mYb.e();
            }
            wh(false);
            if (this.mSK != null) {
                this.mSK.setVisibility(0);
            }
            if (this.mQX != null) {
                this.mQX.setVisibility(0);
            }
            return true;
        }
        return false;
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
        this.H = true;
        if (this.mXv != null) {
            this.mXv.f = null;
            if (this.mXv.dBu() != null) {
                this.mXv.dBu().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mTJ != null) {
                this.mTJ.seekTo(0L);
                e(true);
            }
            dBE();
            return;
        }
        dBE();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mTa) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                tv.chushou.zues.utils.g.c(this.mXw, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mTJ.getPlayState() == 4) {
                        dBK();
                        e(true);
                    } else {
                        if (this.mTs != null) {
                            this.mTs.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mXv.a(false);
                            ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                        } else if (this.mTJ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mTJ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mTJ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wk(true);
                            break;
                        }
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
                tv.chushou.zues.utils.g.c(this.mXw, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mXv.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                    this.ai = false;
                    wk(true);
                    a(false, !this.ak);
                } else if (this.mTJ.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                    this.ai = false;
                    wk(true);
                    a(false, !this.ak);
                } else {
                    m(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void dBK() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.mXv != null && this.mXv.dBw() != null) {
                str = this.mXv.dBw().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dAE().z != null && com.kascend.chushou.a.a.dAE().z.contains(str) && this.mXv != null && !this.mTD) {
            this.mTD = true;
            com.kascend.chushou.a.a.dAE().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mTD = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mTs != null) {
            this.mTs.a(listItem, this.ap == 1, a.C0682a.zues_sweetalert_modal_in, a.C0682a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mTD = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mSR != null) {
                this.mSR.setImageResource(a.e.btn_pause_selector);
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
        if (this.mSR != null) {
            this.mSR.setImageResource(a.e.btn_play_selector);
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

    @SuppressLint({"NewApi"})
    private void dBL() {
        this.N = new SurfaceView(this.mXw);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mXg).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mYj != null) {
            this.mYj.dOn();
            this.mYj.setVisibility(8);
            this.mYj.unInit();
            ((RelativeLayout) this.mXg).removeView(this.mYj);
            this.mYj = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mXg).removeView(this.N);
            this.N = null;
        }
        dBL();
        ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
    }

    private void j(View view, int i, int i2) {
        if (this.mXx != null) {
            wh(true);
            this.mXx.removeMessages(1);
            this.mSK.setVisibility(0);
            this.mSN.setVisibility(8);
            this.mQX.setVisibility(8);
            this.mSX.setVisibility(8);
        }
        if (this.mXV == null) {
            al();
            this.mXV.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mRd.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mXV.isShowing()) {
            this.mXV.showAtLocation(view, 83, i, i2);
            this.mRd.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mXv.dBu().mRoominfo.mRoomID);
            return;
        }
        this.mXV.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mTn != null && this.mTn.b()) {
                this.mTn.getGlobalVisibleRect(this.mTF);
                if (!this.mTF.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mTn.a();
                    return true;
                }
            }
            if (this.mSJ && g(this.mYb.b, motionEvent)) {
                dBR();
                return true;
            }
            if (!dCr()) {
                if (System.currentTimeMillis() - this.mTE < 300 && this.mTs != null && this.mTs.isShown()) {
                    this.mTs.a();
                    if (this.mTJ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mXv.a(false);
                            ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                        } else if (this.mTJ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mXw).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mTJ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mTJ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wk(true);
                        }
                    }
                    return true;
                }
                this.mTE = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dCs() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
        if (this.mSY != null) {
            if (this.mSY.isShown()) {
                this.mSY.startAnimation(AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_top_anim));
            }
            this.mSY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mXw).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mXw).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mXo != null) {
                this.mXo.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hk(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSN.getLayoutParams();
                layoutParams.rightMargin -= this.mTb;
                this.mSN.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mQX.getLayoutParams();
                layoutParams2.rightMargin -= this.mTb;
                this.mQX.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mSM.getLayoutParams();
                layoutParams3.rightMargin -= this.mTb;
                this.mSM.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mSK.getLayoutParams();
                layoutParams4.rightMargin -= this.mTb;
                layoutParams4.bottomMargin += this.mTb;
                this.mSK.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
            this.mTf.setVisibility(0);
            if (this.mXv.dBu().mRoominfo.mIsSubscribed) {
                this.mTf.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mTf.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mTf.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dBM() {
        RoomInfo roomInfo;
        if (this.mXv != null && this.mXv.dBu() != null && (roomInfo = this.mXv.dBu().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mXw, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dPD();
                        b.this.wi(true);
                    }
                });
            } else {
                wi(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wi(final boolean z) {
        RoomInfo roomInfo;
        String str;
        if (this.mXv != null && this.mXv.dBu() != null && (roomInfo = this.mXv.dBu().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dCE()) {
                        b.this.s(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dCE()) {
                        b.this.s(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.M(b.this.mXw, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.M(b.this.mXw, a.i.subscribe_success);
                            }
                            if (b.this.mXv != null && b.this.mXv.dBu() != null && (roomInfo2 = b.this.mXv.dBu().mRoominfo) != null) {
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
                    if (!b.this.dCE()) {
                        b.this.s(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mXw, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mXw, str2);
                    }
                }
            };
            if (this.mXv != null && this.mXv.h != null) {
                try {
                    str = new JSONObject(this.mXv.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dAG().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dAG().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                }
            }
            str = null;
            String a22 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
            if (!z) {
            }
        }
    }

    public void s(boolean z) {
        if (z) {
            if (this.mTg == null) {
                this.mTg = new ProgressDialog(this.mXw);
                this.mTg.setProgressStyle(0);
                this.mTg.requestWindowFeature(1);
                this.mTg.setMessage(this.mXw.getText(a.i.update_userinfo_ing));
                this.mTg.setCancelable(true);
            }
            if (!this.mTg.isShowing()) {
                this.mTg.show();
            }
        } else if (this.mTg != null && this.mTg.isShowing()) {
            this.mTg.dismiss();
        }
    }

    private void dBN() {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
            if (this.mTi == null) {
                this.mTi = new f(getActivity());
            }
            this.mTi.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mTi = null;
                }
            });
            RoomInfo roomInfo = this.mXv.dBu().mRoominfo;
            this.mTi.a();
            this.mTi.a(roomInfo);
            if (!this.mTi.isShowing()) {
                this.mTi.show();
            }
        }
    }

    private void dBP() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mTC != null && this.mXy != null && this.mXw != null && (this.mXw instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mTC;
            VideoPlayer videoPlayer = (VideoPlayer) this.mXw;
            verticalSeekBarVolumn.setProgressOnly(MM(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mQH != null) {
            this.mQH.dPf();
        }
        if (this.mXg != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mTl == null) {
                this.mTl = new com.kascend.chushou.player.ui.giftpopup.a(this.mXg, i);
            } else if (this.mTl.a() != i) {
                this.mTl.b();
                this.mTl = null;
                this.mTl = new com.kascend.chushou.player.ui.giftpopup.a(this.mXg, i);
            }
            List<ListItem> j = this.mXv != null ? this.mXv.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mXw;
            if (videoPlayer != null) {
                this.mTl.a(j, videoPlayer.dBa(), videoPlayer.dBb(), videoPlayer.dBc(), videoPlayer.dBd());
                this.mTl.a(this.e);
                if (this.mXv != null && this.mXv.mQo != null) {
                    this.mTl.a(this.mXv.mQo, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mXv != null) {
                                b.this.mXv.mQo = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mTl != null && this.mXv != null) {
                    this.mTl.b(this.mXv.mQq);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mTl != null && this.mXw != null) {
            this.mTl.a(((VideoPlayer) this.mXw).dBa());
            this.mTl.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mXw instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dBa = ((VideoPlayer) this.mXw).dBa();
            if (this.mYm == null) {
                this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYm.setVisibility(0);
            this.mYm.a(i, dBa);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mTl != null) {
            this.mTl.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mSU != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mSU.setVisibility(0);
                    this.mSU.bV(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mSU.setVisibility(8);
                }
            }
            if (this.mSS != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mST.setVisibility(0);
                    this.mSS.bV(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mST.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mTl != null) {
            this.mTl.a(((VideoPlayer) this.mXw).dBb());
            this.mTl.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mTl != null) {
            this.mTl.a(((VideoPlayer) this.mXw).dBb());
            this.mTl.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mTl != null) {
            this.mTl.a(((VideoPlayer) this.mXw).dBc());
            this.mTl.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mTl != null) {
            this.mTl.a(((VideoPlayer) this.mXw).dBd());
            this.mTl.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wj(false);
        super.F();
    }

    private void c(View view) {
        this.mTt = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mRF = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mRF.setText(new tv.chushou.zues.widget.a.c().O(this.mXw, a.e.videoplayer_4g_video).append("  ").append(this.mXw.getString(a.i.videoplayer_4g_video)));
        this.mTu = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mTu.setText(new tv.chushou.zues.widget.a.c().O(this.mXw, a.e.videoplayer_4g_audio).append("  ").append(this.mXw.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dBE();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mXw, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mTt.setVisibility(8);
                    ((VideoPlayer) b.this.mXw).b(b.this.mRH);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mTt.setVisibility(8);
                    ((VideoPlayer) b.this.mXw).c(b.this.mRH);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw);
        findViewById.setLayoutParams(layoutParams);
        this.mRF.setOnClickListener(onClickListener);
        this.mTu.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mXv != null && !tv.chushou.zues.utils.h.isEmpty(this.mXv.f)) {
            f(this.mXv.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mRH = z;
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
            if (this.mTt != null) {
                this.mTt.setVisibility(0);
                this.mRF.setVisibility(0);
                this.mTu.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mTt != null) {
            this.mTt.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mTl != null && this.mXv != null) {
            this.mTl.b(this.mXv.mQq);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mXg != null && (findViewById = this.mXg.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mSS != null) {
            this.mSS.performClick();
        }
    }
}
