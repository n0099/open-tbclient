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
    private TextView mRK;
    private boolean mRM;
    private LinearLayout mSU;
    private FrameLayout mSY;
    private FrescoThumbnailView mSZ;
    private RelativeLayout mTA;
    private TextView mTB;
    private VerticalSeekBarVolumn mTH;
    private long mTJ;
    private ImageView mTc;
    private ImageView mTe;
    public int mTi;
    RelativeLayout mTk;
    private ImageView mTl;
    private ImageView mTn;
    private f mTp;
    private com.kascend.chushou.player.ui.giftpopup.a mTr;
    private PopH5Menu mTt;
    private com.kascend.chushou.player.b.a mTu;
    private GiftAnimationLayout mTv;
    private ImageView mTw;
    private FoodView mTz;
    private Rect mSJ = null;
    private Rect mSK = null;
    private float mSL = 0.0f;
    private Window mSM = null;
    private WindowManager.LayoutParams mSN = null;
    private boolean mSO = false;
    private View mSQ = null;
    private View mRd = null;
    private View mSR = null;
    private View mSS = null;
    private View mST = null;
    private ImageView mRi = null;
    private ImageView mSV = null;
    private ImageButton mSW = null;
    private FrescoThumbnailView mSX = null;
    private LinearLayout mTa = null;
    private EditText mTb = null;
    private View mTd = null;
    private boolean mTf = false;
    private int bU = 0;
    private int mTg = 0;
    private long mTh = 0;
    private ProgressDialog mTm = null;
    private boolean mTq = true;
    private int mTs = -1;
    private boolean mTC = false;
    private TextView mTD = null;
    private TextView mTE = null;
    private int mTF = 0;
    private boolean mTG = false;
    private boolean mTI = false;
    private final Rect mTK = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTi = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mQM = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXl = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mTi;
        if (this.mXB != null && !((Activity) this.mXB).isFinishing()) {
            dCq();
        }
        return this.mXl;
    }

    public void dBE() {
        av(false, false);
        super.p(true);
        com.kascend.chushou.toolkit.a.c.a(this.mXB, "能量_num", "横屏", new Object[0]);
    }

    public boolean dBS() {
        if (this.mYk == null || !this.mYk.isShown()) {
            return false;
        }
        this.mYk.d();
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
        if (z3 || this.mXl.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dAM().e;
        } else {
            z = h.dAM().b;
        }
        q(z);
        if (this.mYg != null) {
            this.mYg.b();
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
        if (this.mTr != null) {
            this.mTr.b();
            this.mTr = null;
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
            dBL();
            y();
            if (this.mQM != null) {
                this.mQM.onConfigurationChanged(configuration);
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
        if (this.mTt != null && this.mTs != i3) {
            this.mTt.a();
            this.mTt = null;
        }
        if (this.mTt == null) {
            this.mTt = (PopH5Menu) ((ViewStub) this.mXl.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mTt.setLayoutParams(layoutParams);
            this.mTs = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mTt.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dCG()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mXB instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dBd = ((VideoPlayer) this.mXB).dBd();
                    if (this.mYr == null) {
                        this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYr.setVisibility(0);
                    this.mYr.a(i, dBd);
                }
            } else if (bVar.a == 3) {
                if (this.mXB instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dBe = ((VideoPlayer) this.mXB).dBe();
                    if (this.mYr == null) {
                        this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYr.setVisibility(0);
                    this.mYr.a(i, dBe);
                }
            } else if (bVar.a == 9) {
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dBy;
        if (!dCG() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mXA != null && mVar.b.equals(this.mXA.a) && (dBy = this.mXA.dBy()) != null) {
            dBy.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dCq() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.bU = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB);
        this.mTg = tv.chushou.zues.utils.systemBar.b.hj(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.mTg);
        this.mTO = ((VideoPlayer) this.mXB).dAU();
        this.mXA = ((VideoPlayer) this.mXB).dAX();
        c(this.mXl);
        if (this.aw.equals("1")) {
            this.mQK = ((VideoPlayer) this.mXB).dAY();
            this.mQK.a(this);
            if (this.mTu != null) {
                this.mTu.a();
                this.mTu = null;
                this.mTv = null;
            }
            this.mTv = (GiftAnimationLayout) this.mXl.findViewById(a.f.ll_gift_animation);
            this.mTv.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mXA != null) {
                this.mTu = new com.kascend.chushou.player.b.a(this.mXB.getApplicationContext(), this.mTv);
                this.mTu.a(this.mXA);
            }
            this.B = (TextView) this.mXl.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dBN();
        if (this.mQK != null) {
            this.mQK.d();
        }
        dCm();
        this.mTc = (ImageView) this.mXl.findViewById(a.f.btn_lockscreen);
        this.mTc.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mXl.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mXv = (PlayerErrorView) this.mXl.findViewById(a.f.view_net_error_msg);
        this.mXv.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dBH();
        cWw();
        this.mYk = (PaoGuideView) this.mXl.findViewById(a.f.rlPaoGuideView);
        this.mTw = (ImageView) this.mXl.findViewById(a.f.iv_send_danmu);
        this.mST = this.mXl.findViewById(a.f.rt_layout);
        this.mSX = (FrescoThumbnailView) this.mST.findViewById(a.f.btn_gift);
        this.mSY = (FrameLayout) this.mST.findViewById(a.f.flfl_bottom_gift);
        this.mSZ = (FrescoThumbnailView) this.mST.findViewById(a.f.btn_recharge);
        this.mSZ.setOnClickListener(this);
        a(this.mXA == null ? null : this.mXA.mQu);
        this.mYq = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mSO = false;
                b.this.wh(false);
                if (b.this.mXC != null) {
                    b.this.mXC.removeMessages(1);
                    b.this.mXC.L(1, 5000L);
                }
                b.this.mTc.setVisibility(0);
                b.this.mST.setVisibility(0);
                b.this.mRd.setVisibility(0);
                b.this.mSQ.setVisibility(0);
                if (b.this.mTr != null) {
                    b.this.mTr.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mXB, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mSO = true;
                b.this.wh(true);
                b.this.mTc.setVisibility(8);
                b.this.mST.setVisibility(8);
                if (b.this.mTr != null) {
                    b.this.mTr.a(false);
                }
                b.this.mRd.setVisibility(8);
                b.this.mSQ.setVisibility(8);
                if (b.this.mXC != null) {
                    b.this.mXC.removeMessages(1);
                }
                if (b.this.mYg != null) {
                    b.this.mYg.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mXB, 14.0f) + b.this.mYg.getMeasuredHeight(), 12);
                }
            }
        };
        this.mTa = (LinearLayout) this.mXl.findViewById(a.f.rl_seekbar);
        this.mTk = (RelativeLayout) this.mXl.findViewById(a.f.rl_paoicon);
        this.mTk.setOnClickListener(this);
        this.mYh = (RoundProgressBar) this.mXl.findViewById(a.f.roundProgressBar);
        this.mYj = (FrescoThumbnailView) this.mXl.findViewById(a.f.iv_paoicon);
        this.mYi = (TextView) this.mXl.findViewById(a.f.tv_paonum);
        this.aNY = 0;
        this.mYl = 0L;
        com.kascend.chushou.player.ui.a.a dBg = ((VideoPlayer) this.mXB).dBg();
        a(dBg.dCN());
        BangInfo dCO = dBg.dCO();
        if (dCO != null) {
            a(dCO, dBg.d());
        }
        if (this.aw.equals("3")) {
            this.mTa.setVisibility(0);
            this.mSY.setVisibility(8);
            this.mTw.setVisibility(0);
            this.mTw.setOnClickListener(this);
        } else {
            this.mTw.setVisibility(8);
            this.mTa.setVisibility(8);
            this.mSY.setVisibility(0);
            this.mSX.setOnClickListener(this);
        }
        dBI();
        if (tv.chushou.zues.utils.systemBar.b.hk(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mST.getLayoutParams();
            layoutParams.rightMargin += this.mTg;
            this.mST.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRd.getLayoutParams();
            layoutParams2.rightMargin += this.mTg;
            this.mRd.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mSS.getLayoutParams();
            layoutParams3.rightMargin += this.mTg;
            this.mSS.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mSQ.getLayoutParams();
            layoutParams4.rightMargin += this.mTg;
            this.mSQ.setLayoutParams(layoutParams4);
        }
        dCs();
        dBF();
        dBL();
        this.h = (TextView) this.mXl.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXl.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mXA.dBw() != null) {
                this.mTn.setVisibility(0);
            } else {
                this.mTn.setVisibility(8);
            }
        }
        dCr();
        n();
        MG(100);
        this.mTz = (FoodView) this.mXl.findViewById(a.f.kav_room_ad);
        this.mXC = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.av(false, true);
                            break;
                        case 2:
                            b.this.mXC.removeMessages(2);
                            if (b.this.mTc != null) {
                                b.this.mTc.setVisibility(8);
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
                            TextView textView = (TextView) b.this.mXl.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mXB.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mXC.L(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mXC.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mXC.L(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.au(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mXB).q) {
                                b.this.a(b.this.mXC);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mXB).q) {
                                b.this.b(b.this.mXC);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mXB).g = true;
                            b.this.mTO.seekTo((int) b.this.kVw);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mXA.d()) {
                                b.this.mTO.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mTO.getPlayState() == 4) {
                                int currentPos = b.this.mTO.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mXC != null) {
                                    b.this.mXC.L(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dCJ();
                            break;
                        case 18:
                            b.this.cWv();
                            break;
                        case 19:
                            b.this.mXz.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mXA != null) {
            a(this.mXA.dBx());
        }
        if (this.mTO != null && (this.mTO.getPlayState() == 3 || this.mTO.getPlayState() == 4)) {
            wj(false);
            if (this.mXA.d()) {
                this.ak = false;
                wk(true);
                if (this.mTO.getDuration() > 60000) {
                    if (this.mTO.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mTO.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mTO.getDuration();
                }
            }
            this.e = false;
            av(true, false);
            this.mXC.Oc(8);
            if (h() && this.mTO.getPlayState() == 4 && this.mXC != null) {
                this.mXC.removeMessages(15);
                this.mXC.Oc(15);
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
            int[] dAL = g.dAL();
            int i = dAL.length == 2 ? dAL[1] : 0;
            if (i > 0) {
                View findViewById = this.mXl.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mXl.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mXB, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        dCI();
        MN(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mXB, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mXB != null && (this.mXB instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXB).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mSZ.xi(a.e.ic_recharge_old);
            this.mSX.xi(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mTC && !this.k) {
            try {
                if (this.mTO != null) {
                    i = this.mTO.getCurrentPos();
                    i2 = this.mTO.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mQL.setProgress(i / (i2 / 1000));
                    this.mTD.setText(tv.chushou.zues.utils.b.q(this.mTO.getDuration(), false));
                    this.mTE.setText(tv.chushou.zues.utils.b.q(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dCr() {
        this.mQL = (ProgressBar) this.mXl.findViewById(a.f.progressBarl);
        if (this.mQL != null) {
            if (this.mQL instanceof SeekBar) {
                ((SeekBar) this.mQL).setOnSeekBarChangeListener(new C0689b());
            }
            this.mQL.setMax(1000);
        }
        this.mTD = (TextView) this.mXl.findViewById(a.f.tv_time_duration);
        this.mTE = (TextView) this.mXl.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mXl.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXl.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dBg;
        BangInfo dCO;
        if (config != null) {
            this.mYn = config;
            if (!config.display) {
                this.mTk.setVisibility(8);
            } else if ((this.mXB instanceof VideoPlayer) && (dCO = (dBg = ((VideoPlayer) this.mXB).dBg()).dCO()) != null) {
                a(dCO, dBg.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mYn == null || this.mYn.display) && this.mTk != null) {
            this.mTk.setVisibility(0);
            this.mYi.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mXB instanceof VideoPlayer) {
            if ((this.mYn == null || this.mYn.display) && this.mTk != null) {
                if (j > 0) {
                    this.mTk.setVisibility(0);
                    boolean z = this.mYm;
                    this.mYm = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mXB.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mYi.setText(cVar);
                    return;
                }
                this.mYm = false;
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
                if (b.this.mTF != i || b.this.mTG != z) {
                    b.this.mTF = i;
                    b.this.mTG = z;
                    if (z) {
                        if (b.this.mTC) {
                            b.this.kVw = (b.this.mTO.getDuration() / 1000) * i;
                        }
                        b.this.mTE.setText(tv.chushou.zues.utils.b.q((int) b.this.kVw, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.q((int) b.this.kVw, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.q(((int) b.this.kVw) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mTC = true;
            b.this.m = b.this.mTO.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mXC != null) {
                if (b.this.mTC) {
                    b.this.mTC = false;
                }
                b.this.mXC.removeMessages(14);
                b.this.mXC.Oc(14);
            }
        }
    }

    private void MG(int i) {
        this.mQL.setSecondaryProgress((i * 1000) / 100);
    }

    private void dCm() {
        this.mTH = (VerticalSeekBarVolumn) this.mXl.findViewById(a.f.volumn_seekbar);
        this.mTH.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mXD.getStreamVolume(3);
        this.mTH.setProgress(MM(streamVolume));
        wg(MM(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mXl.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mQI = new d.a();
            this.c = new GestureDetector(this.mXB, this.mQI);
        }
    }

    private void dCs() {
        if (this.mSM == null) {
            this.mSM = ((Activity) this.mXB).getWindow();
        }
        this.mSN = this.mSM.getAttributes();
        this.mSL = ((VideoPlayer) this.mXB).k / 255.0f;
        ((VerticalSeekBarVolumn) this.mXl.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mSL));
    }

    private void dBF() {
        this.mXl.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mXl.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mXB.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mXl.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mTb == null) {
            this.mTb = (EditText) this.mXl.findViewById(a.f.et_input);
            this.mTb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mXl.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBG() {
        if (this.mTp != null) {
            this.mTp.dismiss();
            this.mTp = null;
        }
        if (this.mXB != null) {
            ((VideoPlayer) this.mXB).a(1, null, this.H, false);
        }
    }

    private void dBH() {
        this.mRd = this.mXl.findViewById(a.f.topview);
        this.mSU = (LinearLayout) this.mXl.findViewById(a.f.topRight);
        this.mSR = this.mRd.findViewById(a.f.rl_download);
        this.mSS = this.mXl.findViewById(a.f.topKeyboardView);
        this.mXl.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mRd.getVisibility() == 0;
        if (this.bU > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRd.getLayoutParams();
            layoutParams.topMargin = this.bU;
            this.mRd.setLayoutParams(layoutParams);
        }
        this.mXl.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mXl.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                str = this.mXA.dBw().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mXl.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mTl = (ImageView) this.mXl.findViewById(a.f.subscribe_icon);
        this.mTl.setOnClickListener(this);
        this.mTn = (ImageView) this.mXl.findViewById(a.f.report_icon);
        this.mTn.setOnClickListener(this);
        q();
    }

    private void dBI() {
        boolean z;
        this.mSQ = this.mXl.findViewById(a.f.bottomview);
        this.mSW = (ImageButton) this.mSQ.findViewById(a.f.playbutton);
        this.mSW.setOnTouchListener(this);
        this.mXs = (ImageButton) this.mXl.findViewById(a.f.btn_barrage);
        this.mXt = (ImageButton) this.mXl.findViewById(a.f.btn_audio);
        this.mTe = (ImageView) this.mXl.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mSQ.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mSQ.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mXs.setVisibility(0);
            this.mTe.setVisibility(8);
            if (this.mXA != null && this.mXA.f != null) {
                for (int i = 0; i < this.mXA.f.size(); i++) {
                    if ("2".equals(this.mXA.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mXt.setVisibility(0);
            } else {
                this.mXt.setVisibility(8);
            }
            this.mSQ.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mXs.setOnClickListener(this);
            if (h.dAM().e) {
                this.mXs.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXs.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mXA.d) {
                this.mXt.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mXt.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mXt.setOnClickListener(this);
            this.mRi = (ImageView) this.mSQ.findViewById(a.f.btn_hotword);
            this.mSV = (ImageView) this.mXl.findViewById(a.f.iv_task_badge);
            this.mRi.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mXB, a.C0682a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dAM().c) {
                        b.this.mRi.clearAnimation();
                        b.this.mRi.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRi.clearAnimation();
            if (h.dAM().c) {
                this.mRi.startAnimation(animationSet);
                this.mSV.setVisibility(0);
            }
        } else {
            this.mSQ.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mSQ.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mXs.setVisibility(8);
            this.mXt.setVisibility(8);
            this.mTe.setVisibility(0);
            this.mTe.setOnClickListener(this);
            if (h.dAM().b) {
                this.mTe.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTe.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mSQ.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mXB != null) {
            ((VideoPlayer) this.mXB).d(true);
        }
        if (this.mXC != null) {
            this.mXC.cp(null);
            this.mXC = null;
        }
        this.c = null;
        this.mQI = null;
        this.mTc = null;
        if (this.mTb != null) {
            this.mTb.addTextChangedListener(null);
            this.mTb.setOnEditorActionListener(null);
            this.mTb = null;
        }
        this.mRd = null;
        this.mXs = null;
        this.mXt = null;
        this.mSQ = null;
        this.mST = null;
        if (this.mTu != null) {
            this.mTu.a();
            this.mTu = null;
            this.mTv = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dCg() {
        return this.mTu;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mXl == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mYr == null || !this.mYr.a(i, keyEvent)) {
                    if ((this.mTt == null || !this.mTt.onKeyDown(i, keyEvent)) && !dBS() && !dBT()) {
                        if (this.mSS != null && this.mSS.getVisibility() == 0) {
                            au(false, true);
                            return true;
                        } else if (this.mTd != null && this.mTd.isShown()) {
                            dCu();
                            return true;
                        } else if (this.mTf && this.mXC != null) {
                            if (this.mTc != null) {
                                this.mTc.setVisibility(0);
                            }
                            this.mXC.removeMessages(2);
                            this.mXC.L(2, 3000L);
                            return true;
                        } else {
                            dBG();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                u(false);
                int progress = ((VerticalSeekBarVolumn) this.mXl.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mXl.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mXC != null) {
                    this.mXC.removeMessages(3);
                    this.mXC.L(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dCt() {
        if (this.mTf) {
            this.mTc.setVisibility(0);
            this.mXC.removeMessages(2);
            this.mXC.L(2, 3000L);
        }
        return this.mTf;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.mTf) {
            if (view.getId() == a.f.btn_lockscreen) {
                dBK();
                return;
            }
            this.mTc.setVisibility(0);
            this.mXC.removeMessages(2);
            this.mXC.L(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mXB, getString(a.i.STR_VP_SCREEN_LOCK));
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
            l(view, 0, this.mRd.getHeight() + this.mRd.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mTb.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.M(this.mXB, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mTb.setText((CharSequence) null);
                au(false, true);
            } else if (a(this.mTb.getText().toString(), false)) {
                au(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dBK();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                m(view, tv.chushou.zues.utils.systemBar.b.hj(getActivity()), 0);
            } else {
                m(view, 0, tv.chushou.zues.utils.a.dip2px(this.mXB, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            m(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dBG();
            com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = nL() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mYg == null;
                b(false, false);
                if (z && this.mTg > 0 && this.mYg != null && tv.chushou.zues.utils.systemBar.b.aC(getActivity()) && tv.chushou.zues.utils.systemBar.b.aD(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYg.getLayoutParams();
                    layoutParams.rightMargin += this.mTg;
                    this.mYg.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mYg == null;
                if (this.mXB.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.mTg > 0 && this.mYg != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mYg.getLayoutParams();
                    layoutParams2.bottomMargin += this.mTg;
                    this.mYg.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXA.dBw().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            au(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            av(false, false);
            this.mXC.L(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dAM().c) {
                h.dAM().b(false);
                this.mRi.clearAnimation();
                this.mSV.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                j(view, this.mSQ.findViewById(a.f.ll_keyboard).getLeft(), this.mSQ.getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
            } else {
                j(view, this.mSQ.findViewById(a.f.ll_keyboard).getLeft(), this.mSQ.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                tv.chushou.zues.utils.g.c(this.mXB, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.e(this.mXB, nL(), false);
        } else if (id == a.f.btn_screenChange) {
            dBG();
        } else if (id == a.f.rl_paoicon) {
            dBE();
        } else if (id == a.f.subscribe_icon) {
            dBO();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dBR();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dBP();
            }
        } else if (id == a.f.btn_audio && !this.mXA.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            Toast.makeText(this.mXB, a.i.str_same_content, 0).show();
            return false;
        } else if (System.currentTimeMillis() - this.mTh <= 3000) {
            Toast.makeText(this.mXB, a.i.str_too_fast, 0).show();
            return false;
        } else {
            if (!h.dAM().e) {
                r(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
            if (com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a(((VideoPlayer) this.mXB).dAX().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mTh = System.currentTimeMillis();
                a(this.mXA.dBw().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mXA.h);
                if (!z) {
                    this.mTb.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void q(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mXs != null) {
                if (z) {
                    this.mXs.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXs.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mTe != null) {
            if (z) {
                this.mTe.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTe.setImageResource(a.e.btn_barrage_close_n);
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

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mYo != null) {
            this.mYo.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mYo.dOp();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dBK() {
        if (this.mXA.d()) {
            if (this.mTf) {
                this.mTc.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mXB, this.mXB.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mTc.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mXB, this.mXB.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.mTf = !this.mTf;
            if (this.mTb != null) {
                this.mTb.setEnabled(this.mTf ? false : true);
            }
        }
    }

    public void au(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mTb);
            this.mTb.setText("");
            this.mST.setVisibility(8);
            this.mTc.setVisibility(8);
            this.mRd.setVisibility(8);
            this.mSQ.setVisibility(8);
            this.mSS.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
        if (this.mSS.getVisibility() != 8 && z2) {
            this.mSS.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_top_anim));
        }
        this.mST.setVisibility(8);
        this.mTc.setVisibility(8);
        this.mRd.setVisibility(8);
        this.mSQ.setVisibility(8);
        this.mSS.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        av(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mSU != null) {
            this.mSU.setVisibility(z ? 0 : 4);
        }
    }

    public boolean av(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dCG()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mTr != null) {
                this.mTr.a(this.e);
            }
            return this.e;
        }
        if (this.mXC != null) {
            this.mXC.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mXB).d(true);
            if (!z3) {
                if (this.mSQ.getVisibility() != 0 && z2) {
                    this.mSQ.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_bottom_anim));
                }
                this.mSQ.setVisibility(0);
                this.mST.setVisibility(0);
                this.mTc.setVisibility(0);
                this.mSR.setVisibility(o() ? 0 : 8);
            }
            if (this.mRd.getVisibility() != 0 && z2) {
                this.mRd.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_top_anim));
            }
            t(!z3);
            this.mRd.setVisibility(0);
            if (this.mXC != null) {
                this.mXC.L(1, 5000L);
            }
            wh(false);
            if (this.mTr != null) {
                this.mTr.a(true);
            }
        } else {
            ((VideoPlayer) this.mXB).d(false);
            if (this.mXS != null) {
                this.mXS.dismiss();
            }
            if (this.mXT != null) {
                this.mXT.dismiss();
            }
            if (this.mYa != null) {
                this.mYa.dismiss();
            }
            if (this.mSQ != null) {
                if (this.mSQ.getVisibility() != 8 && z2) {
                    this.mSQ.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_bottom_anim));
                }
                this.mSQ.setVisibility(8);
            }
            if (this.mST != null) {
                this.mST.setVisibility(8);
                if (this.mRd.getVisibility() != 8 && z2) {
                    this.mRd.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_top_anim));
                }
                this.mRd.setVisibility(8);
                this.mTc.setVisibility(8);
                wh(true);
                a(false);
                if (this.mTr != null) {
                    this.mTr.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dBL() {
        Point he = tv.chushou.zues.utils.a.he(this.mXB);
        if (this.ap == 1) {
            this.ar = Math.min(he.x, he.y);
            this.mXF = Math.max(he.x, he.y);
        } else {
            this.ar = Math.max(he.x, he.y);
            this.mXF = Math.min(he.x, he.y);
        }
        int i = this.ar;
        int i2 = this.mXF;
        if (this.mSJ == null) {
            this.mSJ = new Rect(0, 0, i / 5, i2);
        } else {
            this.mSJ.set(0, 0, i / 5, i2);
        }
        if (this.mSK == null) {
            this.mSK = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mSK.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mSJ == null) {
            return false;
        }
        return this.mSJ.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        View findViewById = this.mXl.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXl.findViewById(a.f.brightness_view);
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
        if (this.mSK == null) {
            return false;
        }
        return this.mSK.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mXl.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXl.findViewById(a.f.volumn_view);
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
                if (this.mTf) {
                    this.mTc.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.mTf) {
                    this.mXC.removeMessages(2);
                    this.mXC.L(2, 3000L);
                    return true;
                } else if (this.mXC != null) {
                    this.mXC.L(3, 1000L);
                    this.mXC.L(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.mTf) {
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
        int streamMaxVolume = (this.mXD.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int MM(int i) {
        int streamMaxVolume = (i * 10) / this.mXD.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(boolean z) {
        if (z) {
            this.mXl.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mXl.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dCG() && parserRet != null) {
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
                                    if (this.mXB != null && (this.mXB instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mXB).a(1, null, this.H, false, false, true);
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
            b.this.mXD.setStreamVolume(3, b.this.ML(i), 0);
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
            b.this.mSL = i / 10.0f;
            ((VideoPlayer) b.this.mXB).l = b.this.mSL;
            ((VideoPlayer) b.this.mXB).k = b.this.mSL * 255.0f;
            b.this.mSN.screenBrightness = b.this.mSL;
            b.this.mSM.setAttributes(b.this.mSN);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mXF && motionEvent2.getRawY() <= this.mXF) {
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mXl.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        v(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mXl.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mQL.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mXl.findViewById(a.f.volumn_seekbar);
                    u(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mXl.findViewById(a.f.brightness_seekbar);
                        v(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mTO.getCurrentPos();
                            int duration = this.mTO.getDuration();
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
                                this.mQL.setProgress(i3 / (duration / 1000));
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
        if (!this.mSO) {
            if (this.mSS.getVisibility() == 8 && (this.mTd == null || !this.mTd.isShown())) {
                boolean z = this.mXv != null && this.mXv.getVisibility() == 0;
                if (this.e) {
                    av(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                au(false, true);
                dCu();
            }
        }
        return false;
    }

    public boolean dBT() {
        if (this.mSO) {
            if (this.mYg != null) {
                this.mYg.e();
            }
            wh(false);
            if (this.mSQ != null) {
                this.mSQ.setVisibility(0);
            }
            if (this.mRd != null) {
                this.mRd.setVisibility(0);
            }
            return true;
        }
        return false;
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
        this.H = true;
        if (this.mXA != null) {
            this.mXA.f = null;
            if (this.mXA.dBw() != null) {
                this.mXA.dBw().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mTO != null) {
                this.mTO.seekTo(0L);
                e(true);
            }
            dBG();
            return;
        }
        dBG();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mTf) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                tv.chushou.zues.utils.g.c(this.mXB, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mTO.getPlayState() == 4) {
                        dBM();
                        e(true);
                    } else {
                        if (this.mTz != null) {
                            this.mTz.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mXA.a(false);
                            ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
                        } else if (this.mTO.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mTO.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mTO.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wk(true);
                            break;
                        }
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
                tv.chushou.zues.utils.g.c(this.mXB, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mXA.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
                    this.ai = false;
                    wk(true);
                    a(false, !this.ak);
                } else if (this.mTO.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
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

    private void dBM() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.mXA != null && this.mXA.dBy() != null) {
                str = this.mXA.dBy().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dAG().z != null && com.kascend.chushou.a.a.dAG().z.contains(str) && this.mXA != null && !this.mTI) {
            this.mTI = true;
            com.kascend.chushou.a.a.dAG().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mTI = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mTz != null) {
            this.mTz.a(listItem, this.ap == 1, a.C0682a.zues_sweetalert_modal_in, a.C0682a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mTI = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mSW != null) {
                this.mSW.setImageResource(a.e.btn_pause_selector);
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
        if (this.mSW != null) {
            this.mSW.setImageResource(a.e.btn_play_selector);
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

    @SuppressLint({"NewApi"})
    private void dBN() {
        this.N = new SurfaceView(this.mXB);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mXl).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mYo != null) {
            this.mYo.dOp();
            this.mYo.setVisibility(8);
            this.mYo.unInit();
            ((RelativeLayout) this.mXl).removeView(this.mYo);
            this.mYo = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mXl).removeView(this.N);
            this.N = null;
        }
        dBN();
        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
    }

    private void j(View view, int i, int i2) {
        if (this.mXC != null) {
            wh(true);
            this.mXC.removeMessages(1);
            this.mSQ.setVisibility(0);
            this.mST.setVisibility(8);
            this.mRd.setVisibility(8);
            this.mTc.setVisibility(8);
        }
        if (this.mYa == null) {
            al();
            this.mYa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mRi.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mYa.isShowing()) {
            this.mYa.showAtLocation(view, 83, i, i2);
            this.mRi.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mXA.dBw().mRoominfo.mRoomID);
            return;
        }
        this.mYa.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mTt != null && this.mTt.b()) {
                this.mTt.getGlobalVisibleRect(this.mTK);
                if (!this.mTK.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mTt.a();
                    return true;
                }
            }
            if (this.mSO && g(this.mYg.b, motionEvent)) {
                dBT();
                return true;
            }
            if (!dCt()) {
                if (System.currentTimeMillis() - this.mTJ < 300 && this.mTz != null && this.mTz.isShown()) {
                    this.mTz.a();
                    if (this.mTO.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mXA.a(false);
                            ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
                        } else if (this.mTO.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mXB).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mTO.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mTO.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wk(true);
                        }
                    }
                    return true;
                }
                this.mTJ = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dCu() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
        if (this.mTd != null) {
            if (this.mTd.isShown()) {
                this.mTd.startAnimation(AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_top_anim));
            }
            this.mTd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mXB).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mXB).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mXt != null) {
                this.mXt.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hk(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mST.getLayoutParams();
                layoutParams.rightMargin -= this.mTg;
                this.mST.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRd.getLayoutParams();
                layoutParams2.rightMargin -= this.mTg;
                this.mRd.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mSS.getLayoutParams();
                layoutParams3.rightMargin -= this.mTg;
                this.mSS.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mSQ.getLayoutParams();
                layoutParams4.rightMargin -= this.mTg;
                layoutParams4.bottomMargin += this.mTg;
                this.mSQ.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
            this.mTl.setVisibility(0);
            if (this.mXA.dBw().mRoominfo.mIsSubscribed) {
                this.mTl.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mTl.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mTl.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dBO() {
        RoomInfo roomInfo;
        if (this.mXA != null && this.mXA.dBw() != null && (roomInfo = this.mXA.dBw().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mXB, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dPF();
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
        if (this.mXA != null && this.mXA.dBw() != null && (roomInfo = this.mXA.dBw().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dCG()) {
                        b.this.s(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dCG()) {
                        b.this.s(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.M(b.this.mXB, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.M(b.this.mXB, a.i.subscribe_success);
                            }
                            if (b.this.mXA != null && b.this.mXA.dBw() != null && (roomInfo2 = b.this.mXA.dBw().mRoominfo) != null) {
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
                    if (!b.this.dCG()) {
                        b.this.s(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mXB, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mXB, str2);
                    }
                }
            };
            if (this.mXA != null && this.mXA.h != null) {
                try {
                    str = new JSONObject(this.mXA.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dAI().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dAI().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.mTm == null) {
                this.mTm = new ProgressDialog(this.mXB);
                this.mTm.setProgressStyle(0);
                this.mTm.requestWindowFeature(1);
                this.mTm.setMessage(this.mXB.getText(a.i.update_userinfo_ing));
                this.mTm.setCancelable(true);
            }
            if (!this.mTm.isShowing()) {
                this.mTm.show();
            }
        } else if (this.mTm != null && this.mTm.isShowing()) {
            this.mTm.dismiss();
        }
    }

    private void dBP() {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
            if (this.mTp == null) {
                this.mTp = new f(getActivity());
            }
            this.mTp.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mTp = null;
                }
            });
            RoomInfo roomInfo = this.mXA.dBw().mRoominfo;
            this.mTp.a();
            this.mTp.a(roomInfo);
            if (!this.mTp.isShowing()) {
                this.mTp.show();
            }
        }
    }

    private void dBR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mTH != null && this.mXD != null && this.mXB != null && (this.mXB instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mTH;
            VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
            verticalSeekBarVolumn.setProgressOnly(MM(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mQM != null) {
            this.mQM.dPh();
        }
        if (this.mXl != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mTr == null) {
                this.mTr = new com.kascend.chushou.player.ui.giftpopup.a(this.mXl, i);
            } else if (this.mTr.a() != i) {
                this.mTr.b();
                this.mTr = null;
                this.mTr = new com.kascend.chushou.player.ui.giftpopup.a(this.mXl, i);
            }
            List<ListItem> j = this.mXA != null ? this.mXA.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
            if (videoPlayer != null) {
                this.mTr.a(j, videoPlayer.dBc(), videoPlayer.dBd(), videoPlayer.dBe(), videoPlayer.dBf());
                this.mTr.a(this.e);
                if (this.mXA != null && this.mXA.mQt != null) {
                    this.mTr.a(this.mXA.mQt, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mXA != null) {
                                b.this.mXA.mQt = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mTr != null && this.mXA != null) {
                    this.mTr.b(this.mXA.mQv);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mTr != null && this.mXB != null) {
            this.mTr.a(((VideoPlayer) this.mXB).dBc());
            this.mTr.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mXB instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dBc = ((VideoPlayer) this.mXB).dBc();
            if (this.mYr == null) {
                this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYr.setVisibility(0);
            this.mYr.a(i, dBc);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mTr != null) {
            this.mTr.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mSZ != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mSZ.setVisibility(0);
                    this.mSZ.bV(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mSZ.setVisibility(8);
                }
            }
            if (this.mSX != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mSY.setVisibility(0);
                    this.mSX.bV(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mSY.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mTr != null) {
            this.mTr.a(((VideoPlayer) this.mXB).dBd());
            this.mTr.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mTr != null) {
            this.mTr.a(((VideoPlayer) this.mXB).dBd());
            this.mTr.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mTr != null) {
            this.mTr.a(((VideoPlayer) this.mXB).dBe());
            this.mTr.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mTr != null) {
            this.mTr.a(((VideoPlayer) this.mXB).dBf());
            this.mTr.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wj(false);
        super.F();
    }

    private void c(View view) {
        this.mTA = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mRK = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mRK.setText(new tv.chushou.zues.widget.a.c().O(this.mXB, a.e.videoplayer_4g_video).append("  ").append(this.mXB.getString(a.i.videoplayer_4g_video)));
        this.mTB = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mTB.setText(new tv.chushou.zues.widget.a.c().O(this.mXB, a.e.videoplayer_4g_audio).append("  ").append(this.mXB.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dBG();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mXB, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mTA.setVisibility(8);
                    ((VideoPlayer) b.this.mXB).b(b.this.mRM);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mTA.setVisibility(8);
                    ((VideoPlayer) b.this.mXB).c(b.this.mRM);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB);
        findViewById.setLayoutParams(layoutParams);
        this.mRK.setOnClickListener(onClickListener);
        this.mTB.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mXA != null && !tv.chushou.zues.utils.h.isEmpty(this.mXA.f)) {
            f(this.mXA.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mRM = z;
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
            if (this.mTA != null) {
                this.mTA.setVisibility(0);
                this.mRK.setVisibility(0);
                this.mTB.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mTA != null) {
            this.mTA.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mTr != null && this.mXA != null) {
            this.mTr.b(this.mXA.mQv);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mXl != null && (findViewById = this.mXl.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mSX != null) {
            this.mSX.performClick();
        }
    }
}
