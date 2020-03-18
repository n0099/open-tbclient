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
    private TextView mUr;
    private boolean mUt;
    private FrameLayout mVC;
    private FrescoThumbnailView mVD;
    private ImageView mVG;
    private ImageView mVI;
    public int mVN;
    RelativeLayout mVO;
    private ImageView mVP;
    private ImageView mVR;
    private f mVS;
    private com.kascend.chushou.player.ui.giftpopup.a mVU;
    private PopH5Menu mVW;
    private com.kascend.chushou.player.b.a mVX;
    private GiftAnimationLayout mVY;
    private ImageView mVZ;
    private LinearLayout mVy;
    private FoodView mWa;
    private RelativeLayout mWb;
    private TextView mWc;
    private VerticalSeekBarVolumn mWi;
    private long mWk;
    private Rect mVo = null;
    private Rect mVp = null;
    private float mVq = 0.0f;
    private Window mVr = null;
    private WindowManager.LayoutParams mVs = null;
    private boolean mVt = false;
    private View mVu = null;
    private View mTI = null;
    private View mVv = null;
    private View mVw = null;
    private View mVx = null;
    private ImageView mTN = null;
    private ImageView mVz = null;
    private ImageButton mVA = null;
    private FrescoThumbnailView mVB = null;
    private LinearLayout mVE = null;
    private EditText mVF = null;
    private View mVH = null;
    private boolean mVJ = false;
    private int mVK = 0;
    private int mVL = 0;
    private long mVM = 0;
    private ProgressDialog mVQ = null;
    private boolean mVT = true;
    private int mVV = -1;
    private boolean mWd = false;
    private TextView mWe = null;
    private TextView mWf = null;
    private int mWg = 0;
    private boolean mWh = false;
    private boolean mWj = false;
    private final Rect mWl = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mVN = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mTp = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mZL = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mVN;
        if (this.nab != null && !((Activity) this.nab).isFinishing()) {
            dDY();
        }
        return this.mZL;
    }

    public void dDl() {
        ax(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nab, "能量_num", "横屏", new Object[0]);
    }

    public boolean dDz() {
        if (this.naL == null || !this.naL.isShown()) {
            return false;
        }
        this.naL.d();
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
        if (z3 || this.mZL.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dCs().e;
        } else {
            z = h.dCs().b;
        }
        r(z);
        if (this.naH != null) {
            this.naH.b();
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
        if (this.mVU != null) {
            this.mVU.b();
            this.mVU = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cr(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            dDs();
            y();
            if (this.mTp != null) {
                this.mTp.onConfigurationChanged(configuration);
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
        if (this.mVW != null && this.mVV != i3) {
            this.mVW.a();
            this.mVW = null;
        }
        if (this.mVW == null) {
            this.mVW = (PopH5Menu) ((ViewStub) this.mZL.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point hc = tv.chushou.zues.utils.a.hc(getActivity());
            if (this.ap == 0) {
                int i4 = hc.y;
                i = hc.y;
                i2 = i4;
            } else {
                int i5 = hc.x;
                int i6 = hc.y - ((hc.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVW.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mVW.setLayoutParams(layoutParams);
            this.mVV = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mVW.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dEp()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.nab instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dCK = ((VideoPlayer) this.nab).dCK();
                    if (this.naS == null) {
                        this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.naS.setVisibility(0);
                    this.naS.a(i, dCK);
                }
            } else if (bVar.a == 3) {
                if (this.nab instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dCL = ((VideoPlayer) this.nab).dCL();
                    if (this.naS == null) {
                        this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.naS.setVisibility(0);
                    this.naS.a(i, dCL);
                }
            } else if (bVar.a == 9) {
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dDf;
        if (!dEp() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.naa != null && mVar.b.equals(this.naa.a) && (dDf = this.naa.dDf()) != null) {
            dDf.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dDY() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.mVK = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
        this.mVL = tv.chushou.zues.utils.systemBar.b.hh(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.mVL);
        this.mWp = ((VideoPlayer) this.nab).dCA();
        this.naa = ((VideoPlayer) this.nab).dCD();
        c(this.mZL);
        if (this.aw.equals("1")) {
            this.mTm = ((VideoPlayer) this.nab).dCE();
            this.mTm.a(this);
            if (this.mVX != null) {
                this.mVX.a();
                this.mVX = null;
                this.mVY = null;
            }
            this.mVY = (GiftAnimationLayout) this.mZL.findViewById(a.f.ll_gift_animation);
            this.mVY.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.naa != null) {
                this.mVX = new com.kascend.chushou.player.b.a(this.nab.getApplicationContext(), this.mVY);
                this.mVX.a(this.naa);
            }
            this.B = (TextView) this.mZL.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dDu();
        if (this.mTm != null) {
            this.mTm.d();
        }
        dDU();
        this.mVG = (ImageView) this.mZL.findViewById(a.f.btn_lockscreen);
        this.mVG.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mZL.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mZV = (PlayerErrorView) this.mZL.findViewById(a.f.view_net_error_msg);
        this.mZV.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dDo();
        cYk();
        this.naL = (PaoGuideView) this.mZL.findViewById(a.f.rlPaoGuideView);
        this.mVZ = (ImageView) this.mZL.findViewById(a.f.iv_send_danmu);
        this.mVx = this.mZL.findViewById(a.f.rt_layout);
        this.mVB = (FrescoThumbnailView) this.mVx.findViewById(a.f.btn_gift);
        this.mVC = (FrameLayout) this.mVx.findViewById(a.f.flfl_bottom_gift);
        this.mVD = (FrescoThumbnailView) this.mVx.findViewById(a.f.btn_recharge);
        this.mVD.setOnClickListener(this);
        a(this.naa == null ? null : this.naa.mSV);
        this.naR = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mVt = false;
                b.this.wt(false);
                if (b.this.nac != null) {
                    b.this.nac.removeMessages(1);
                    b.this.nac.K(1, 5000L);
                }
                b.this.mVG.setVisibility(0);
                b.this.mVx.setVisibility(0);
                b.this.mTI.setVisibility(0);
                b.this.mVu.setVisibility(0);
                if (b.this.mVU != null) {
                    b.this.mVU.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nab, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mVt = true;
                b.this.wt(true);
                b.this.mVG.setVisibility(8);
                b.this.mVx.setVisibility(8);
                if (b.this.mVU != null) {
                    b.this.mVU.a(false);
                }
                b.this.mTI.setVisibility(8);
                b.this.mVu.setVisibility(8);
                if (b.this.nac != null) {
                    b.this.nac.removeMessages(1);
                }
                if (b.this.naH != null) {
                    b.this.naH.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nab, 14.0f) + b.this.naH.getMeasuredHeight(), 12);
                }
            }
        };
        this.mVE = (LinearLayout) this.mZL.findViewById(a.f.rl_seekbar);
        this.mVO = (RelativeLayout) this.mZL.findViewById(a.f.rl_paoicon);
        this.mVO.setOnClickListener(this);
        this.naI = (RoundProgressBar) this.mZL.findViewById(a.f.roundProgressBar);
        this.naK = (FrescoThumbnailView) this.mZL.findViewById(a.f.iv_paoicon);
        this.naJ = (TextView) this.mZL.findViewById(a.f.tv_paonum);
        this.aSM = 0;
        this.naM = 0L;
        com.kascend.chushou.player.ui.a.a dCN = ((VideoPlayer) this.nab).dCN();
        a(dCN.dEw());
        BangInfo dEx = dCN.dEx();
        if (dEx != null) {
            a(dEx, dCN.d());
        }
        if (this.aw.equals("3")) {
            this.mVE.setVisibility(0);
            this.mVC.setVisibility(8);
            this.mVZ.setVisibility(0);
            this.mVZ.setOnClickListener(this);
        } else {
            this.mVZ.setVisibility(8);
            this.mVE.setVisibility(8);
            this.mVC.setVisibility(0);
            this.mVB.setOnClickListener(this);
        }
        dDp();
        if (tv.chushou.zues.utils.systemBar.b.hi(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVx.getLayoutParams();
            layoutParams.rightMargin += this.mVL;
            this.mVx.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTI.getLayoutParams();
            layoutParams2.rightMargin += this.mVL;
            this.mTI.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mVw.getLayoutParams();
            layoutParams3.rightMargin += this.mVL;
            this.mVw.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mVu.getLayoutParams();
            layoutParams4.rightMargin += this.mVL;
            this.mVu.setLayoutParams(layoutParams4);
        }
        dEa();
        dDm();
        dDs();
        this.h = (TextView) this.mZL.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mZL.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.naa.dDd() != null) {
                this.mVR.setVisibility(0);
            } else {
                this.mVR.setVisibility(8);
            }
        }
        dDZ();
        n();
        k(100);
        this.mWa = (FoodView) this.mZL.findViewById(a.f.kav_room_ad);
        this.nac = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ax(false, true);
                            break;
                        case 2:
                            b.this.nac.removeMessages(2);
                            if (b.this.mVG != null) {
                                b.this.mVG.setVisibility(8);
                                break;
                            }
                            break;
                        case 3:
                            b.this.v(true);
                            break;
                        case 4:
                            b.this.wp(true);
                            break;
                        case 5:
                            TextView textView = (TextView) b.this.mZL.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nab.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nac.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nac.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nac.K(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aw(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nab).q) {
                                b.this.a(b.this.nac);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nab).q) {
                                b.this.b(b.this.nac);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nab).g = true;
                            b.this.mWp.seekTo((int) b.this.kXT);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.naa.d()) {
                                b.this.mWp.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mWp.getPlayState() == 4) {
                                int currentPos = b.this.mWp.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nac != null) {
                                    b.this.nac.K(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dEs();
                            break;
                        case 18:
                            b.this.cYj();
                            break;
                        case 19:
                            b.this.mZZ.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.naa != null) {
            a(this.naa.dDe());
        }
        if (this.mWp != null && (this.mWp.getPlayState() == 3 || this.mWp.getPlayState() == 4)) {
            wv(false);
            if (this.naa.d()) {
                this.ak = false;
                ww(true);
                if (this.mWp.getDuration() > 60000) {
                    if (this.mWp.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mWp.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mWp.getDuration();
                }
            }
            this.e = false;
            ax(true, false);
            this.nac.Ol(8);
            if (h() && this.mWp.getPlayState() == 4 && this.nac != null) {
                this.nac.removeMessages(15);
                this.nac.Ol(15);
            }
        } else {
            wv(true);
            if (this.e) {
                ax(false, false);
            } else {
                wt(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dCr = g.dCr();
            int i = dCr.length == 2 ? dCr[1] : 0;
            if (i > 0) {
                View findViewById = this.mZL.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nab, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mZL.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nab, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        dEr();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nab, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nab != null && (this.nab instanceof VideoPlayer)) {
            ((VideoPlayer) this.nab).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mVD.xw(a.e.ic_recharge_old);
            this.mVB.xw(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mWd && !this.k) {
            try {
                if (this.mWp != null) {
                    i = this.mWp.getCurrentPos();
                    i2 = this.mWp.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mTn.setProgress(i / (i2 / 1000));
                    this.mWe.setText(tv.chushou.zues.utils.b.t(this.mWp.getDuration(), false));
                    this.mWf.setText(tv.chushou.zues.utils.b.t(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dDZ() {
        this.mTn = (ProgressBar) this.mZL.findViewById(a.f.progressBarl);
        if (this.mTn != null) {
            if (this.mTn instanceof SeekBar) {
                ((SeekBar) this.mTn).setOnSeekBarChangeListener(new C0698b());
            }
            this.mTn.setMax(1000);
        }
        this.mWe = (TextView) this.mZL.findViewById(a.f.tv_time_duration);
        this.mWf = (TextView) this.mZL.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mZL.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mZL.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dCN;
        BangInfo dEx;
        if (config != null) {
            this.naO = config;
            if (!config.display) {
                this.mVO.setVisibility(8);
            } else if ((this.nab instanceof VideoPlayer) && (dEx = (dCN = ((VideoPlayer) this.nab).dCN()).dEx()) != null) {
                a(dEx, dCN.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.naO == null || this.naO.display) && this.mVO != null) {
            this.mVO.setVisibility(0);
            this.naJ.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nab instanceof VideoPlayer) {
            if ((this.naO == null || this.naO.display) && this.mVO != null) {
                if (j > 0) {
                    this.mVO.setVisibility(0);
                    boolean z = this.naN;
                    this.naN = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nab.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.naJ.setText(cVar);
                    return;
                }
                this.naN = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0698b implements SeekBar.OnSeekBarChangeListener {
        C0698b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.mWg != i || b.this.mWh != z) {
                    b.this.mWg = i;
                    b.this.mWh = z;
                    if (z) {
                        if (b.this.mWd) {
                            b.this.kXT = (b.this.mWp.getDuration() / 1000) * i;
                        }
                        b.this.mWf.setText(tv.chushou.zues.utils.b.t((int) b.this.kXT, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.t((int) b.this.kXT, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.t(((int) b.this.kXT) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mWd = true;
            b.this.m = b.this.mWp.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nac != null) {
                if (b.this.mWd) {
                    b.this.mWd = false;
                }
                b.this.nac.removeMessages(14);
                b.this.nac.Ol(14);
            }
        }
    }

    private void k(int i) {
        this.mTn.setSecondaryProgress((i * 1000) / 100);
    }

    private void dDU() {
        this.mWi = (VerticalSeekBarVolumn) this.mZL.findViewById(a.f.volumn_seekbar);
        this.mWi.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nad.getStreamVolume(3);
        this.mWi.setProgress(MW(streamVolume));
        ws(MW(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mZL.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mTk = new d.a();
            this.c = new GestureDetector(this.nab, this.mTk);
        }
    }

    private void dEa() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mVr == null) {
                this.mVr = ((Activity) this.nab).getWindow();
            }
            this.mVs = this.mVr.getAttributes();
            this.mVq = ((VideoPlayer) this.nab).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mZL.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mVq));
        }
    }

    private void dDm() {
        this.mZL.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mZL.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nab.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mZL.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mVF == null) {
            this.mVF = (EditText) this.mZL.findViewById(a.f.et_input);
            this.mVF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mZL.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDn() {
        if (this.mVS != null) {
            this.mVS.dismiss();
            this.mVS = null;
        }
        if (this.nab != null) {
            ((VideoPlayer) this.nab).a(1, null, this.H, false);
        }
    }

    private void dDo() {
        this.mTI = this.mZL.findViewById(a.f.topview);
        this.mVy = (LinearLayout) this.mZL.findViewById(a.f.topRight);
        this.mVv = this.mTI.findViewById(a.f.rl_download);
        this.mVw = this.mZL.findViewById(a.f.topKeyboardView);
        this.mZL.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mTI.getVisibility() == 0;
        if (this.mVK > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTI.getLayoutParams();
            layoutParams.topMargin = this.mVK;
            this.mTI.setLayoutParams(layoutParams);
        }
        this.mZL.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mZL.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                str = this.naa.dDd().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mZL.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mVP = (ImageView) this.mZL.findViewById(a.f.subscribe_icon);
        this.mVP.setOnClickListener(this);
        this.mVR = (ImageView) this.mZL.findViewById(a.f.report_icon);
        this.mVR.setOnClickListener(this);
        q();
    }

    private void dDp() {
        boolean z;
        this.mVu = this.mZL.findViewById(a.f.bottomview);
        this.mVA = (ImageButton) this.mVu.findViewById(a.f.playbutton);
        this.mVA.setOnTouchListener(this);
        this.mZS = (ImageButton) this.mZL.findViewById(a.f.btn_barrage);
        this.mZT = (ImageButton) this.mZL.findViewById(a.f.btn_audio);
        this.mVI = (ImageView) this.mZL.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mVu.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mVu.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mZS.setVisibility(0);
            this.mVI.setVisibility(8);
            if (this.naa != null && this.naa.f != null) {
                for (int i = 0; i < this.naa.f.size(); i++) {
                    if ("2".equals(this.naa.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mZT.setVisibility(0);
            } else {
                this.mZT.setVisibility(8);
            }
            this.mVu.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mZS.setOnClickListener(this);
            if (h.dCs().e) {
                this.mZS.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mZS.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.naa.d) {
                this.mZT.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mZT.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mZT.setOnClickListener(this);
            this.mTN = (ImageView) this.mVu.findViewById(a.f.btn_hotword);
            this.mVz = (ImageView) this.mZL.findViewById(a.f.iv_task_badge);
            this.mTN.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nab, a.C0691a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dCs().c) {
                        b.this.mTN.clearAnimation();
                        b.this.mTN.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mTN.clearAnimation();
            if (h.dCs().c) {
                this.mTN.startAnimation(animationSet);
                this.mVz.setVisibility(0);
            }
        } else {
            this.mVu.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mVu.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mZS.setVisibility(8);
            this.mZT.setVisibility(8);
            this.mVI.setVisibility(0);
            this.mVI.setOnClickListener(this);
            if (h.dCs().b) {
                this.mVI.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mVI.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mVu.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nab != null) {
            ((VideoPlayer) this.nab).e(true);
        }
        if (this.nac != null) {
            this.nac.cq(null);
            this.nac = null;
        }
        this.c = null;
        this.mTk = null;
        this.mVG = null;
        if (this.mVF != null) {
            this.mVF.addTextChangedListener(null);
            this.mVF.setOnEditorActionListener(null);
            this.mVF = null;
        }
        this.mTI = null;
        this.mZS = null;
        this.mZT = null;
        this.mVu = null;
        this.mVx = null;
        if (this.mVX != null) {
            this.mVX.a();
            this.mVX = null;
            this.mVY = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDO() {
        return this.mVX;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mZL == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.naS == null || !this.naS.a(i, keyEvent)) {
                    if ((this.mVW == null || !this.mVW.onKeyDown(i, keyEvent)) && !dDz() && !dDA()) {
                        if (this.mVw != null && this.mVw.getVisibility() == 0) {
                            aw(false, true);
                            return true;
                        } else if (this.mVH != null && this.mVH.isShown()) {
                            dEc();
                            return true;
                        } else if (this.mVJ && this.nac != null) {
                            if (this.mVG != null) {
                                this.mVG.setVisibility(0);
                            }
                            this.nac.removeMessages(2);
                            this.nac.K(2, 3000L);
                            return true;
                        } else {
                            dDn();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.mZL.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mZL.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nac != null) {
                    this.nac.removeMessages(3);
                    this.nac.K(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dEb() {
        if (this.mVJ) {
            this.mVG.setVisibility(0);
            this.nac.removeMessages(2);
            this.nac.K(2, 3000L);
        }
        return this.mVJ;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.mVJ) {
            if (view.getId() == a.f.btn_lockscreen) {
                dDr();
                return;
            }
            this.mVG.setVisibility(0);
            this.nac.removeMessages(2);
            this.nac.K(2, 3000L);
            tv.chushou.zues.utils.g.c(this.nab, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aF(getActivity()) && tv.chushou.zues.utils.systemBar.b.aG(getActivity())) {
                    m(view, tv.chushou.zues.utils.systemBar.b.hh(getActivity()), 0);
                    return;
                } else {
                    m(view, 0, 0);
                    return;
                }
            }
            m(view, 0, this.mTI.getHeight() + this.mTI.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mVF.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.M(this.nab, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mVF.setText((CharSequence) null);
                aw(false, true);
            } else if (a(this.mVF.getText().toString(), false)) {
                aw(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dDr();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                n(view, tv.chushou.zues.utils.systemBar.b.hh(getActivity()), 0);
            } else {
                n(view, 0, tv.chushou.zues.utils.a.dip2px(this.nab, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            n(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dDn();
            com.kascend.chushou.toolkit.a.c.a(this.nab, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dEo() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.naH == null;
                b(false, false);
                if (z && this.mVL > 0 && this.naH != null && tv.chushou.zues.utils.systemBar.b.aF(getActivity()) && tv.chushou.zues.utils.systemBar.b.aG(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.naH.getLayoutParams();
                    layoutParams.rightMargin += this.mVL;
                    this.naH.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.naH == null;
                if (this.nab.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.mVL > 0 && this.naH != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.naH.getLayoutParams();
                    layoutParams2.bottomMargin += this.mVL;
                    this.naH.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nab, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.naa.dDd().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aw(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ax(false, false);
            this.nac.K(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dCs().c) {
                h.dCs().b(false);
                this.mTN.clearAnimation();
                this.mVz.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                k(view, this.mVu.findViewById(a.f.ll_keyboard).getLeft(), this.mVu.getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
            } else {
                k(view, this.mVu.findViewById(a.f.ll_keyboard).getLeft(), this.mVu.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                tv.chushou.zues.utils.g.c(this.nab, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nab).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.e(this.nab, dEo(), false);
        } else if (id == a.f.btn_screenChange) {
            dDn();
        } else if (id == a.f.rl_paoicon) {
            dDl();
        } else if (id == a.f.subscribe_icon) {
            dDv();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dDy();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dDw();
            }
        } else if (id == a.f.btn_audio && !this.naa.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Os(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mVM <= 3000) {
            tv.chushou.zues.utils.g.Os(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dCs().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
            if (com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a(((VideoPlayer) this.nab).dCD().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mVM = System.currentTimeMillis();
                a(this.naa.dDd().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.naa.h);
                if (!z) {
                    this.mVF.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mZS != null) {
                if (z) {
                    this.mZS.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mZS.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mVI != null) {
            if (z) {
                this.mVI.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mVI.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dDx() {
        if (this.mZL == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mZL.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.naP != null) {
            this.naP.setVisibility(z ? 0 : 8);
            if (!z) {
                this.naP.dQf();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dDr() {
        if (this.naa.d()) {
            if (this.mVJ) {
                this.mVG.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nab, this.nab.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mVG.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nab, this.nab.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.mVJ = !this.mVJ;
            if (this.mVF != null) {
                this.mVF.setEnabled(this.mVJ ? false : true);
            }
        }
    }

    public void aw(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mVF);
            this.mVF.setText("");
            this.mVx.setVisibility(8);
            this.mVG.setVisibility(8);
            this.mTI.setVisibility(8);
            this.mVu.setVisibility(8);
            this.mVw.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
        if (this.mVw.getVisibility() != 8 && z2) {
            this.mVw.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_top_anim));
        }
        this.mVx.setVisibility(8);
        this.mVG.setVisibility(8);
        this.mTI.setVisibility(8);
        this.mVu.setVisibility(8);
        this.mVw.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ax(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.mVy != null) {
            this.mVy.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ax(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dEp()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mVU != null) {
                this.mVU.a(this.e);
            }
            return this.e;
        }
        if (this.nac != null) {
            this.nac.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nab).e(true);
            if (!z3) {
                if (this.mVu.getVisibility() != 0 && z2) {
                    this.mVu.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_bottom_anim));
                }
                this.mVu.setVisibility(0);
                this.mVx.setVisibility(0);
                this.mVG.setVisibility(0);
                this.mVv.setVisibility(o() ? 0 : 8);
            }
            if (this.mTI.getVisibility() != 0 && z2) {
                this.mTI.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_top_anim));
            }
            u(!z3);
            this.mTI.setVisibility(0);
            if (this.nac != null) {
                this.nac.K(1, 5000L);
            }
            wt(false);
            if (this.mVU != null) {
                this.mVU.a(true);
            }
        } else {
            ((VideoPlayer) this.nab).e(false);
            if (this.nat != null) {
                this.nat.dismiss();
            }
            if (this.nau != null) {
                this.nau.dismiss();
            }
            if (this.naB != null) {
                this.naB.dismiss();
            }
            if (this.mVu != null) {
                if (this.mVu.getVisibility() != 8 && z2) {
                    this.mVu.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_bottom_anim));
                }
                this.mVu.setVisibility(8);
            }
            if (this.mVx != null) {
                this.mVx.setVisibility(8);
                if (this.mTI.getVisibility() != 8 && z2) {
                    this.mTI.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_top_anim));
                }
                this.mTI.setVisibility(8);
                this.mVG.setVisibility(8);
                wt(true);
                a(false);
                if (this.mVU != null) {
                    this.mVU.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dDs() {
        Point hc = tv.chushou.zues.utils.a.hc(this.nab);
        if (this.ap == 1) {
            this.ar = Math.min(hc.x, hc.y);
            this.naf = Math.max(hc.x, hc.y);
        } else {
            this.ar = Math.max(hc.x, hc.y);
            this.naf = Math.min(hc.x, hc.y);
        }
        int i = this.ar;
        int i2 = this.naf;
        if (this.mVo == null) {
            this.mVo = new Rect(0, 0, i / 5, i2);
        } else {
            this.mVo.set(0, 0, i / 5, i2);
        }
        if (this.mVp == null) {
            this.mVp = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mVp.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mVo == null) {
            return false;
        }
        return this.mVo.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mZL.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mZL.findViewById(a.f.brightness_view);
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
        if (this.mVp == null) {
            return false;
        }
        return this.mVp.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp(boolean z) {
        View findViewById = this.mZL.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mZL.findViewById(a.f.volumn_view);
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
                if (this.mVJ) {
                    this.mVG.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.mVJ) {
                    this.nac.removeMessages(2);
                    this.nac.K(2, 3000L);
                    return true;
                } else if (this.nac != null) {
                    this.nac.K(3, 1000L);
                    this.nac.K(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.mVJ) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MV(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.nad.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nab;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int MW(int i) {
        int streamMaxVolume = (i * 10) / this.nad.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws(boolean z) {
        if (z) {
            this.mZL.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mZL.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dEp() && parserRet != null) {
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
                                    if (this.nab != null && (this.nab instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nab).a(1, null, this.H, false, false, true);
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
            b.this.nad.setStreamVolume(3, b.this.MV(i), 0);
            b.this.ws(i <= 0);
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
            b.this.mVq = i / 10.0f;
            ((VideoPlayer) b.this.nab).l = b.this.mVq;
            ((VideoPlayer) b.this.nab).k = b.this.mVq * 255.0f;
            b.this.mVs.screenBrightness = b.this.mVq;
            b.this.mVr.setAttributes(b.this.mVs);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.naf && motionEvent2.getRawY() <= this.naf) {
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mZL.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        wp(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mZL.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mTn.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mZL.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mZL.findViewById(a.f.brightness_seekbar);
                        wp(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mWp.getCurrentPos();
                            int duration = this.mWp.getDuration();
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
                            this.h.setText(tv.chushou.zues.utils.b.t(i3, false));
                            this.i.setText(tv.chushou.zues.utils.b.t(this.j, true));
                            if (duration > 1000) {
                                this.mTn.setProgress(i3 / (duration / 1000));
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
        if (!this.mVt) {
            if (this.mVw.getVisibility() == 8 && (this.mVH == null || !this.mVH.isShown())) {
                boolean z = this.mZV != null && this.mZV.getVisibility() == 0;
                if (this.e) {
                    ax(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                aw(false, true);
                dEc();
            }
        }
        return false;
    }

    public boolean dDA() {
        if (this.mVt) {
            if (this.naH != null) {
                this.naH.e();
            }
            wt(false);
            if (this.mVu != null) {
                this.mVu.setVisibility(0);
            }
            if (this.mTI != null) {
                this.mTI.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dDH() {
        super.dDH();
        if (this.nab instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nab;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.naa != null) {
            this.naa.f = null;
            if (this.naa.dDd() != null) {
                this.naa.dDd().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mWp != null) {
                this.mWp.seekTo(0L);
                e(true);
            }
            dDn();
            return;
        }
        dDn();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mVJ) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                tv.chushou.zues.utils.g.c(this.nab, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mWp.getPlayState() == 4) {
                        dDt();
                        e(true);
                    } else {
                        if (this.mWa != null) {
                            this.mWa.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.naa.a(false);
                            ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                        } else if (this.mWp.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.mWp.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mWp.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ww(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.mWp.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mWp.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                tv.chushou.zues.utils.g.c(this.nab, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.naa.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                    this.ai = false;
                    ww(true);
                    a(false, !this.ak);
                } else if (this.mWp.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                    this.ai = false;
                    ww(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void dDt() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.naa != null && this.naa.dDf() != null) {
                str = this.naa.dDf().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dCm().z != null && com.kascend.chushou.a.a.dCm().z.contains(str) && this.naa != null && !this.mWj) {
            this.mWj = true;
            com.kascend.chushou.a.a.dCm().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mWj = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mWa != null) {
            this.mWa.a(listItem, this.ap == 1, a.C0691a.zues_sweetalert_modal_in, a.C0691a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mWj = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mVA != null) {
                this.mVA.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mZV != null) {
                this.mZV.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mVA != null) {
            this.mVA.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mZV != null) {
                    this.mZV.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dDu() {
        this.N = new SurfaceView(this.nab);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mZL).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.naP != null) {
            this.naP.dQf();
            this.naP.setVisibility(8);
            this.naP.unInit();
            ((RelativeLayout) this.mZL).removeView(this.naP);
            this.naP = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mZL).removeView(this.N);
            this.N = null;
        }
        dDu();
        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
    }

    private void k(View view, int i, int i2) {
        if (this.nac != null) {
            wt(true);
            this.nac.removeMessages(1);
            this.mVu.setVisibility(0);
            this.mVx.setVisibility(8);
            this.mTI.setVisibility(8);
            this.mVG.setVisibility(8);
        }
        if (this.naB == null) {
            al();
            this.naB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mTN.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.naB.isShowing()) {
            this.naB.showAtLocation(view, 83, i, i2);
            this.mTN.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.naa.dDd().mRoominfo.mRoomID);
            return;
        }
        this.naB.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mVW != null && this.mVW.b()) {
                this.mVW.getGlobalVisibleRect(this.mWl);
                if (!this.mWl.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mVW.a();
                    return true;
                }
            }
            if (this.mVt && g(this.naH.b, motionEvent)) {
                dDA();
                return true;
            }
            if (!dEb()) {
                if (System.currentTimeMillis() - this.mWk < 300 && this.mWa != null && this.mWa.isShown()) {
                    this.mWa.a();
                    if (this.mWp.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.naa.a(false);
                            ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                        } else if (this.mWp.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nab).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.mWp.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mWp.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ww(true);
                        }
                    }
                    return true;
                }
                this.mWk = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dEc() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
        if (this.mVH != null) {
            if (this.mVH.isShown()) {
                this.mVH.startAnimation(AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_top_anim));
            }
            this.mVH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wt(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nab).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nab).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mZT != null) {
                this.mZT.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hi(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVx.getLayoutParams();
                layoutParams.rightMargin -= this.mVL;
                this.mVx.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTI.getLayoutParams();
                layoutParams2.rightMargin -= this.mVL;
                this.mTI.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mVw.getLayoutParams();
                layoutParams3.rightMargin -= this.mVL;
                this.mVw.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mVu.getLayoutParams();
                layoutParams4.rightMargin -= this.mVL;
                layoutParams4.bottomMargin += this.mVL;
                this.mVu.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
            this.mVP.setVisibility(0);
            if (this.naa.dDd().mRoominfo.mIsSubscribed) {
                this.mVP.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mVP.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mVP.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dDv() {
        RoomInfo roomInfo;
        if (this.naa != null && this.naa.dDd() != null && (roomInfo = this.naa.dDd().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nab, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dRv();
                        b.this.wu(true);
                    }
                });
            } else {
                wu(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wu(final boolean z) {
        RoomInfo roomInfo;
        String str;
        if (this.naa != null && this.naa.dDd() != null && (roomInfo = this.naa.dDd().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dEp()) {
                        b.this.t(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dEp()) {
                        b.this.t(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.M(b.this.nab, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.M(b.this.nab, a.i.subscribe_success);
                            }
                            if (b.this.naa != null && b.this.naa.dDd() != null && (roomInfo2 = b.this.naa.dDd().mRoominfo) != null) {
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
                    if (!b.this.dEp()) {
                        b.this.t(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.nab, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nab, str2);
                    }
                }
            };
            if (this.naa != null && this.naa.h != null) {
                try {
                    str = new JSONObject(this.naa.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dCo().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dCo().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.mVQ == null) {
                this.mVQ = new ProgressDialog(this.nab);
                this.mVQ.setProgressStyle(0);
                this.mVQ.requestWindowFeature(1);
                this.mVQ.setMessage(this.nab.getText(a.i.update_userinfo_ing));
                this.mVQ.setCancelable(true);
            }
            if (!this.mVQ.isShowing()) {
                this.mVQ.show();
            }
        } else if (this.mVQ != null && this.mVQ.isShowing()) {
            this.mVQ.dismiss();
        }
    }

    private void dDw() {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
            if (this.mVS == null) {
                this.mVS = new f(getActivity());
            }
            this.mVS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mVS = null;
                }
            });
            RoomInfo roomInfo = this.naa.dDd().mRoominfo;
            this.mVS.a();
            this.mVS.a(roomInfo);
            if (!this.mVS.isShowing()) {
                this.mVS.show();
            }
        }
    }

    private void dDy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mWi != null && this.nad != null && this.nab != null && (this.nab instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mWi;
            VideoPlayer videoPlayer = (VideoPlayer) this.nab;
            verticalSeekBarVolumn.setProgressOnly(MW(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mTp != null) {
            this.mTp.dQX();
        }
        if (this.mZL != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mVU == null) {
                this.mVU = new com.kascend.chushou.player.ui.giftpopup.a(this.mZL, i);
            } else if (this.mVU.a() != i) {
                this.mVU.b();
                this.mVU = null;
                this.mVU = new com.kascend.chushou.player.ui.giftpopup.a(this.mZL, i);
            }
            List<ListItem> j = this.naa != null ? this.naa.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nab;
            if (videoPlayer != null) {
                this.mVU.a(j, videoPlayer.dCJ(), videoPlayer.dCK(), videoPlayer.dCL(), videoPlayer.dCM());
                this.mVU.a(this.e);
                if (this.naa != null && this.naa.mSU != null) {
                    this.mVU.a(this.naa.mSU, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.naa != null) {
                                b.this.naa.mSU = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mVU != null && this.naa != null) {
                    this.mVU.b(this.naa.mSW);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void a(int i) {
        if (this.mVU != null && this.nab != null) {
            this.mVU.a(((VideoPlayer) this.nab).dCJ());
            this.mVU.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void D() {
        if (this.nab instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dCJ = ((VideoPlayer) this.nab).dCJ();
            if (this.naS == null) {
                this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.naS.setVisibility(0);
            this.naS.a(i, dCJ);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mVU != null) {
            this.mVU.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mVD != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mVD.setVisibility(0);
                    this.mVD.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mVD.setVisibility(8);
                }
            }
            if (this.mVB != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mVC.setVisibility(0);
                    this.mVB.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mVC.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mVU != null) {
            this.mVU.a(((VideoPlayer) this.nab).dCK());
            this.mVU.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mVU != null) {
            this.mVU.a(((VideoPlayer) this.nab).dCK());
            this.mVU.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(long j) {
        if (this.mVU != null) {
            this.mVU.a(((VideoPlayer) this.nab).dCL());
            this.mVU.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0704a
    public void c(int i) {
        if (this.mVU != null) {
            this.mVU.a(((VideoPlayer) this.nab).dCM());
            this.mVU.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wv(false);
        super.F();
    }

    private void c(View view) {
        this.mWb = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mUr = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mUr.setText(new tv.chushou.zues.widget.a.c().O(this.nab, a.e.videoplayer_4g_video).append("  ").append(this.nab.getString(a.i.videoplayer_4g_video)));
        this.mWc = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mWc.setText(new tv.chushou.zues.widget.a.c().O(this.nab, a.e.videoplayer_4g_audio).append("  ").append(this.nab.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dDn();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nab, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mWb.setVisibility(8);
                    ((VideoPlayer) b.this.nab).c(b.this.mUt);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mWb.setVisibility(8);
                    ((VideoPlayer) b.this.nab).d(b.this.mUt);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
        findViewById.setLayoutParams(layoutParams);
        this.mUr.setOnClickListener(onClickListener);
        this.mWc.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.naa != null && !tv.chushou.zues.utils.h.isEmpty(this.naa.f)) {
            f(this.naa.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mUt = z;
            this.p = false;
            if (this.naa != null && this.naa.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.naa.f.size()) {
                        break;
                    } else if (!"2".equals(this.naa.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mWb != null) {
                this.mWb.setVisibility(0);
                this.mUr.setVisibility(0);
                this.mWc.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mWb != null) {
            this.mWb.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mVU != null && this.naa != null) {
            this.mVU.b(this.naa.mSW);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mZL != null && (findViewById = this.mZL.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mVB != null) {
            this.mVB.performClick();
        }
    }
}
