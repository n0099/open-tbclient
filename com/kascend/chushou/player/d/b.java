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
    private TextView mKX;
    private boolean mKZ;
    private TextView mMA;
    private VerticalSeekBarVolumn mMG;
    private long mMI;
    private LinearLayout mMa;
    private FrameLayout mMe;
    private FrescoThumbnailView mMf;
    private ImageView mMi;
    private ImageView mMk;
    RelativeLayout mMn;
    private ImageView mMo;
    private ImageView mMq;
    private f mMr;
    private com.kascend.chushou.player.ui.giftpopup.a mMs;
    private PopH5Menu mMu;
    private com.kascend.chushou.player.b.a mMv;
    private GiftAnimationLayout mMw;
    private ImageView mMx;
    private FoodView mMy;
    private RelativeLayout mMz;
    private Rect mLQ = null;
    private Rect mLR = null;
    private float mLS = 0.0f;
    private Window mLT = null;
    private WindowManager.LayoutParams mLU = null;
    private boolean mLV = false;
    private View mLW = null;
    private View mKp = null;
    private View mLX = null;
    private View mLY = null;
    private View mLZ = null;
    private ImageView mKu = null;
    private ImageView mMb = null;
    private ImageButton mMc = null;
    private FrescoThumbnailView mMd = null;
    private LinearLayout mMg = null;
    private EditText mMh = null;
    private View mMj = null;
    private boolean bT = false;
    private int mMl = 0;
    private int bV = 0;
    private long mMm = 0;
    private ProgressDialog mMp = null;
    private boolean bws = true;
    private int mMt = -1;
    private boolean mMB = false;
    private TextView mMC = null;
    private TextView mMD = null;
    private int mME = 0;
    private boolean mMF = false;
    private boolean mMH = false;
    private final Rect mMJ = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mJX = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mQi = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.mQy != null && !((Activity) this.mQy).isFinishing()) {
            dFq();
        }
        return this.mQi;
    }

    public void dEV() {
        ax(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.mQy, "能量_num", "横屏", new Object[0]);
    }

    public boolean dFe() {
        if (this.mRh == null || !this.mRh.isShown()) {
            return false;
        }
        this.mRh.d();
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
        if (z3 || this.mQi.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dDZ().e;
        } else {
            z = h.dDZ().b;
        }
        r(z);
        if (this.mRd != null) {
            this.mRd.b();
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
        if (this.mMs != null) {
            this.mMs.b();
            this.mMs = null;
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
            if (this.mJX != null) {
                this.mJX.onConfigurationChanged(configuration);
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
        if (this.mMu != null && this.mMt != i3) {
            this.mMu.a();
            this.mMu = null;
        }
        if (this.mMu == null) {
            this.mMu = (PopH5Menu) ((ViewStub) this.mQi.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mMu.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mMu.setLayoutParams(layoutParams);
            this.mMt = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mMu.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dFE()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mQy instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dEs = ((VideoPlayer) this.mQy).dEs();
                    if (this.mRp == null) {
                        this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mRp.setVisibility(0);
                    this.mRp.a(i, dEs);
                }
            } else if (bVar.a == 3) {
                if (this.mQy instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dEt = ((VideoPlayer) this.mQy).dEt();
                    if (this.mRp == null) {
                        this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mRp.setVisibility(0);
                    this.mRp.a(i, dEt);
                }
            } else if (bVar.a == 9) {
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dEO;
        if (!dFE() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mQx != null && mVar.b.equals(this.mQx.a) && (dEO = this.mQx.dEO()) != null) {
            dEO.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dFq() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.mMl = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
        this.bV = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.mMN = ((VideoPlayer) this.mQy).dEi();
        this.mQx = ((VideoPlayer) this.mQy).dEl();
        c(this.mQi);
        if (this.aw.equals("1")) {
            this.mJV = ((VideoPlayer) this.mQy).dEm();
            this.mJV.a(this);
            if (this.mMv != null) {
                this.mMv.a();
                this.mMv = null;
                this.mMw = null;
            }
            this.mMw = (GiftAnimationLayout) this.mQi.findViewById(a.f.ll_gift_animation);
            this.mMw.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mQx != null) {
                this.mMv = new com.kascend.chushou.player.b.a(this.mQy.getApplicationContext(), this.mMw);
                this.mMv.a(this.mQx);
            }
            this.B = (TextView) this.mQi.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        aO();
        if (this.mJV != null) {
            this.mJV.d();
        }
        dFo();
        this.mMi = (ImageView) this.mQi.findViewById(a.f.btn_lockscreen);
        this.mMi.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mQi.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mQs = (PlayerErrorView) this.mQi.findViewById(a.f.view_net_error_msg);
        this.mQs.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dEX();
        dsG();
        this.mRh = (PaoGuideView) this.mQi.findViewById(a.f.rlPaoGuideView);
        this.mMx = (ImageView) this.mQi.findViewById(a.f.iv_send_danmu);
        this.mLZ = this.mQi.findViewById(a.f.rt_layout);
        this.mMd = (FrescoThumbnailView) this.mLZ.findViewById(a.f.btn_gift);
        this.mMe = (FrameLayout) this.mLZ.findViewById(a.f.flfl_bottom_gift);
        this.mMf = (FrescoThumbnailView) this.mLZ.findViewById(a.f.btn_recharge);
        this.mMf.setOnClickListener(this);
        a(this.mQx == null ? null : this.mQx.mJF);
        this.mRn = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mLV = false;
                b.this.y(false);
                if (b.this.mQz != null) {
                    b.this.mQz.removeMessages(1);
                    b.this.mQz.A(1, 5000L);
                }
                b.this.mMi.setVisibility(0);
                b.this.mLZ.setVisibility(0);
                b.this.mKp.setVisibility(0);
                b.this.mLW.setVisibility(0);
                if (b.this.mMs != null) {
                    b.this.mMs.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mQy, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mLV = true;
                b.this.y(true);
                b.this.mMi.setVisibility(8);
                b.this.mLZ.setVisibility(8);
                if (b.this.mMs != null) {
                    b.this.mMs.a(false);
                }
                b.this.mKp.setVisibility(8);
                b.this.mLW.setVisibility(8);
                if (b.this.mQz != null) {
                    b.this.mQz.removeMessages(1);
                }
                if (b.this.mRd != null) {
                    b.this.mRd.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mQy, 14.0f) + b.this.mRd.getMeasuredHeight(), 12);
                }
            }
        };
        this.mMg = (LinearLayout) this.mQi.findViewById(a.f.rl_seekbar);
        this.mMn = (RelativeLayout) this.mQi.findViewById(a.f.rl_paoicon);
        this.mMn.setOnClickListener(this);
        this.mRe = (RoundProgressBar) this.mQi.findViewById(a.f.roundProgressBar);
        this.mRg = (FrescoThumbnailView) this.mQi.findViewById(a.f.iv_paoicon);
        this.mRf = (TextView) this.mQi.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.mRi = 0L;
        com.kascend.chushou.player.ui.a.a dEv = ((VideoPlayer) this.mQy).dEv();
        a(dEv.dFL());
        BangInfo dFM = dEv.dFM();
        if (dFM != null) {
            a(dFM, dEv.d());
        }
        if (this.aw.equals("3")) {
            this.mMg.setVisibility(0);
            this.mMe.setVisibility(8);
            this.mMx.setVisibility(0);
            this.mMx.setOnClickListener(this);
        } else {
            this.mMx.setVisibility(8);
            this.mMg.setVisibility(8);
            this.mMe.setVisibility(0);
            this.mMd.setOnClickListener(this);
        }
        dEY();
        if (tv.chushou.zues.utils.systemBar.b.gC(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLZ.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.mLZ.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mKp.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.mKp.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLY.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.mLY.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mLW.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.mLW.setLayoutParams(layoutParams4);
        }
        dFs();
        aG();
        aM();
        this.h = (TextView) this.mQi.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mQi.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mQx.dEL() != null) {
                this.mMq.setVisibility(0);
            } else {
                this.mMq.setVisibility(8);
            }
        }
        dFr();
        n();
        k(100);
        this.mMy = (FoodView) this.mQi.findViewById(a.f.kav_room_ad);
        this.mQz = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ax(false, true);
                            break;
                        case 2:
                            b.this.mQz.removeMessages(2);
                            if (b.this.mMi != null) {
                                b.this.mMi.setVisibility(8);
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
                            TextView textView = (TextView) b.this.mQi.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mQy.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mQz.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mQz.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mQz.A(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aw(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mQy).q) {
                                b.this.a(b.this.mQz);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mQy).q) {
                                b.this.b(b.this.mQz);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mQy).g = true;
                            b.this.mMN.seekTo((int) b.this.mhQ);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mQx.d()) {
                                b.this.mMN.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mMN.getPlayState() == 4) {
                                int currentPos = b.this.mMN.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mQz != null) {
                                    b.this.mQz.A(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dFG();
                            break;
                        case 18:
                            b.this.dsF();
                            break;
                        case 19:
                            b.this.mQw.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mQx != null) {
            a(this.mQx.dEM());
        }
        if (this.mMN != null && (this.mMN.getPlayState() == 3 || this.mMN.getPlayState() == 4)) {
            wB(false);
            if (this.mQx.d()) {
                this.ak = false;
                wC(true);
                if (this.mMN.getDuration() > 60000) {
                    if (this.mMN.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mMN.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mMN.getDuration();
                }
            }
            this.e = false;
            ax(true, false);
            this.mQz.Kq(8);
            if (h() && this.mMN.getPlayState() == 4 && this.mQz != null) {
                this.mQz.removeMessages(15);
                this.mQz.Kq(15);
            }
        } else {
            wB(true);
            if (this.e) {
                ax(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dDY = g.dDY();
            int i = dDY.length == 2 ? dDY[1] : 0;
            if (i > 0) {
                View findViewById = this.mQi.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mQi.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mQy, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mQy, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mQy != null && (this.mQy instanceof VideoPlayer)) {
            ((VideoPlayer) this.mQy).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mMf.yE(a.e.ic_recharge_old);
            this.mMd.yE(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mMB && !this.k) {
            try {
                if (this.mMN != null) {
                    i = this.mMN.getCurrentPos();
                    i2 = this.mMN.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mJW.setProgress(i / (i2 / 1000));
                    this.mMC.setText(tv.chushou.zues.utils.b.o(this.mMN.getDuration(), false));
                    this.mMD.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dFr() {
        this.mJW = (ProgressBar) this.mQi.findViewById(a.f.progressBarl);
        if (this.mJW != null) {
            if (this.mJW instanceof SeekBar) {
                ((SeekBar) this.mJW).setOnSeekBarChangeListener(new C0801b());
            }
            this.mJW.setMax(1000);
        }
        this.mMC = (TextView) this.mQi.findViewById(a.f.tv_time_duration);
        this.mMD = (TextView) this.mQi.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mQi.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mQi.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dEv;
        BangInfo dFM;
        if (config != null) {
            this.mRk = config;
            if (!config.display) {
                this.mMn.setVisibility(8);
            } else if ((this.mQy instanceof VideoPlayer) && (dFM = (dEv = ((VideoPlayer) this.mQy).dEv()).dFM()) != null) {
                a(dFM, dEv.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mRk == null || this.mRk.display) && this.mMn != null) {
            this.mMn.setVisibility(0);
            this.mRf.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mQy instanceof VideoPlayer) {
            if ((this.mRk == null || this.mRk.display) && this.mMn != null) {
                if (j > 0) {
                    this.mMn.setVisibility(0);
                    boolean z = this.mRj;
                    this.mRj = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mQy.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mRf.setText(cVar);
                    return;
                }
                this.mRj = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0801b implements SeekBar.OnSeekBarChangeListener {
        C0801b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.mME != i || b.this.mMF != z) {
                    b.this.mME = i;
                    b.this.mMF = z;
                    if (z) {
                        if (b.this.mMB) {
                            b.this.mhQ = (b.this.mMN.getDuration() / 1000) * i;
                        }
                        b.this.mMD.setText(tv.chushou.zues.utils.b.o((int) b.this.mhQ, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.mhQ, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.mhQ) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mMB = true;
            b.this.m = b.this.mMN.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mQz != null) {
                if (b.this.mMB) {
                    b.this.mMB = false;
                }
                b.this.mQz.removeMessages(14);
                b.this.mQz.Kq(14);
            }
        }
    }

    private void k(int i) {
        this.mJW.setSecondaryProgress((i * 1000) / 100);
    }

    private void dFo() {
        this.mMG = (VerticalSeekBarVolumn) this.mQi.findViewById(a.f.volumn_seekbar);
        this.mMG.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mQA.getStreamVolume(3);
        this.mMG.setProgress(Jb(streamVolume));
        x(Jb(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mQi.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mJT = new d.a();
            this.c = new GestureDetector(this.mQy, this.mJT);
        }
    }

    private void dFs() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mLT == null) {
                this.mLT = ((Activity) this.mQy).getWindow();
            }
            this.mLU = this.mLT.getAttributes();
            this.mLS = ((VideoPlayer) this.mQy).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mQi.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mLS));
        }
    }

    private void aG() {
        this.mQi.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mQi.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mQy.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mQi.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mMh == null) {
            this.mMh = (EditText) this.mQi.findViewById(a.f.et_input);
            this.mMh.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mQi.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        if (this.mMr != null) {
            this.mMr.dismiss();
            this.mMr = null;
        }
        if (this.mQy != null) {
            ((VideoPlayer) this.mQy).a(1, null, this.H, false);
        }
    }

    private void dEX() {
        this.mKp = this.mQi.findViewById(a.f.topview);
        this.mMa = (LinearLayout) this.mQi.findViewById(a.f.topRight);
        this.mLX = this.mKp.findViewById(a.f.rl_download);
        this.mLY = this.mQi.findViewById(a.f.topKeyboardView);
        this.mQi.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mKp.getVisibility() == 0;
        if (this.mMl > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mKp.getLayoutParams();
            layoutParams.topMargin = this.mMl;
            this.mKp.setLayoutParams(layoutParams);
        }
        this.mQi.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mQi.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                str = this.mQx.dEL().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mQi.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mMo = (ImageView) this.mQi.findViewById(a.f.subscribe_icon);
        this.mMo.setOnClickListener(this);
        this.mMq = (ImageView) this.mQi.findViewById(a.f.report_icon);
        this.mMq.setOnClickListener(this);
        q();
    }

    private void dEY() {
        boolean z;
        this.mLW = this.mQi.findViewById(a.f.bottomview);
        this.mMc = (ImageButton) this.mLW.findViewById(a.f.playbutton);
        this.mMc.setOnTouchListener(this);
        this.mQp = (ImageButton) this.mQi.findViewById(a.f.btn_barrage);
        this.mQq = (ImageButton) this.mQi.findViewById(a.f.btn_audio);
        this.mMk = (ImageView) this.mQi.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mLW.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mLW.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mQp.setVisibility(0);
            this.mMk.setVisibility(8);
            if (this.mQx != null && this.mQx.f != null) {
                for (int i = 0; i < this.mQx.f.size(); i++) {
                    if ("2".equals(this.mQx.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mQq.setVisibility(0);
            } else {
                this.mQq.setVisibility(8);
            }
            this.mLW.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mQp.setOnClickListener(this);
            if (h.dDZ().e) {
                this.mQp.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mQp.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mQx.d) {
                this.mQq.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mQq.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mQq.setOnClickListener(this);
            this.mKu = (ImageView) this.mLW.findViewById(a.f.btn_hotword);
            this.mMb = (ImageView) this.mQi.findViewById(a.f.iv_task_badge);
            this.mKu.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mQy, a.C0794a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dDZ().c) {
                        b.this.mKu.clearAnimation();
                        b.this.mKu.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mKu.clearAnimation();
            if (h.dDZ().c) {
                this.mKu.startAnimation(animationSet);
                this.mMb.setVisibility(0);
            }
        } else {
            this.mLW.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mLW.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mQp.setVisibility(8);
            this.mQq.setVisibility(8);
            this.mMk.setVisibility(0);
            this.mMk.setOnClickListener(this);
            if (h.dDZ().b) {
                this.mMk.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mMk.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mLW.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mQy != null) {
            ((VideoPlayer) this.mQy).e(true);
        }
        if (this.mQz != null) {
            this.mQz.cg(null);
            this.mQz = null;
        }
        this.c = null;
        this.mJT = null;
        this.mMi = null;
        if (this.mMh != null) {
            this.mMh.addTextChangedListener(null);
            this.mMh.setOnEditorActionListener(null);
            this.mMh = null;
        }
        this.mKp = null;
        this.mQp = null;
        this.mQq = null;
        this.mLW = null;
        this.mLZ = null;
        if (this.mMv != null) {
            this.mMv.a();
            this.mMv = null;
            this.mMw = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dFl() {
        return this.mMv;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mQi == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mRp == null || !this.mRp.a(i, keyEvent)) {
                    if ((this.mMu == null || !this.mMu.onKeyDown(i, keyEvent)) && !dFe() && !dEW()) {
                        if (this.mLY != null && this.mLY.getVisibility() == 0) {
                            aw(false, true);
                            return true;
                        } else if (this.mMj != null && this.mMj.isShown()) {
                            dFu();
                            return true;
                        } else if (this.bT && this.mQz != null) {
                            if (this.mMi != null) {
                                this.mMi.setVisibility(0);
                            }
                            this.mQz.removeMessages(2);
                            this.mQz.A(2, 3000L);
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
                int progress = ((VerticalSeekBarVolumn) this.mQi.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mQi.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mQz != null) {
                    this.mQz.removeMessages(3);
                    this.mQz.A(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dFt() {
        if (this.bT) {
            this.mMi.setVisibility(0);
            this.mQz.removeMessages(2);
            this.mQz.A(2, 3000L);
        }
        return this.bT;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.bT) {
            if (view.getId() == a.f.btn_lockscreen) {
                dFa();
                return;
            }
            this.mMi.setVisibility(0);
            this.mQz.removeMessages(2);
            this.mQz.A(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mQy, getString(a.i.STR_VP_SCREEN_LOCK));
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
            o(view, 0, this.mKp.getHeight() + this.mKp.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mMh.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.mQy, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mMh.setText((CharSequence) null);
                aw(false, true);
            } else if (a(this.mMh.getText().toString(), false)) {
                aw(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dFa();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.gB(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.mQy, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            aH();
            com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dFD() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mRd == null;
                b(false, false);
                if (z && this.bV > 0 && this.mRd != null && tv.chushou.zues.utils.systemBar.b.ax(getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRd.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.mRd.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mRd == null;
                if (this.mQy.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.mRd != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRd.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.mRd.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mQx.dEL().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aw(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ax(false, false);
            this.mQz.A(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dDZ().c) {
                h.dDZ().b(false);
                this.mKu.clearAnimation();
                this.mMb.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.mLW.findViewById(a.f.ll_keyboard).getLeft(), this.mLW.getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
            } else {
                m(view, this.mLW.findViewById(a.f.ll_keyboard).getLeft(), this.mLW.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                tv.chushou.zues.utils.g.c(this.mQy, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.mQy, dFD(), false);
        } else if (id == a.f.btn_screenChange) {
            aH();
        } else if (id == a.f.rl_paoicon) {
            dEV();
        } else if (id == a.f.subscribe_icon) {
            aP();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dFd();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dFb();
            }
        } else if (id == a.f.btn_audio && !this.mQx.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Kz(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mMm <= 3000) {
            tv.chushou.zues.utils.g.Kz(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dDZ().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
            if (com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a(((VideoPlayer) this.mQy).dEl().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mMm = System.currentTimeMillis();
                a(this.mQx.dEL().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mQx.h);
                if (!z) {
                    this.mMh.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mQp != null) {
                if (z) {
                    this.mQp.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mQp.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mMk != null) {
            if (z) {
                this.mMk.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mMk.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dFc() {
        if (this.mQi == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mQi.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.mRl != null) {
            this.mRl.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mRl.dQW();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dFa() {
        if (this.mQx.d()) {
            if (this.bT) {
                this.mMi.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mQy, this.mQy.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mMi.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mQy, this.mQy.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.bT = !this.bT;
            if (this.mMh != null) {
                this.mMh.setEnabled(this.bT ? false : true);
            }
        }
    }

    public void aw(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dD(this.mMh);
            this.mMh.setText("");
            this.mLZ.setVisibility(8);
            this.mMi.setVisibility(8);
            this.mKp.setVisibility(8);
            this.mLW.setVisibility(8);
            this.mLY.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
        if (this.mLY.getVisibility() != 8 && z2) {
            this.mLY.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_top_anim));
        }
        this.mLZ.setVisibility(8);
        this.mMi.setVisibility(8);
        this.mKp.setVisibility(8);
        this.mLW.setVisibility(8);
        this.mLY.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ax(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.mMa != null) {
            this.mMa.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ax(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dFE()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mMs != null) {
                this.mMs.a(this.e);
            }
            return this.e;
        }
        if (this.mQz != null) {
            this.mQz.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mQy).e(true);
            if (!z3) {
                if (this.mLW.getVisibility() != 0 && z2) {
                    this.mLW.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_bottom_anim));
                }
                this.mLW.setVisibility(0);
                this.mLZ.setVisibility(0);
                this.mMi.setVisibility(0);
                this.mLX.setVisibility(o() ? 0 : 8);
            }
            if (this.mKp.getVisibility() != 0 && z2) {
                this.mKp.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_top_anim));
            }
            u(!z3);
            this.mKp.setVisibility(0);
            if (this.mQz != null) {
                this.mQz.A(1, 5000L);
            }
            y(false);
            if (this.mMs != null) {
                this.mMs.a(true);
            }
        } else {
            ((VideoPlayer) this.mQy).e(false);
            if (this.mQP != null) {
                this.mQP.dismiss();
            }
            if (this.mQQ != null) {
                this.mQQ.dismiss();
            }
            if (this.mQX != null) {
                this.mQX.dismiss();
            }
            if (this.mLW != null) {
                if (this.mLW.getVisibility() != 8 && z2) {
                    this.mLW.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_bottom_anim));
                }
                this.mLW.setVisibility(8);
            }
            if (this.mLZ != null) {
                this.mLZ.setVisibility(8);
                if (this.mKp.getVisibility() != 8 && z2) {
                    this.mKp.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_top_anim));
                }
                this.mKp.setVisibility(8);
                this.mMi.setVisibility(8);
                y(true);
                a(false);
                if (this.mMs != null) {
                    this.mMs.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void aM() {
        Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
        if (this.ap == 1) {
            this.ar = Math.min(gv.x, gv.y);
            this.aq = Math.max(gv.x, gv.y);
        } else {
            this.ar = Math.max(gv.x, gv.y);
            this.aq = Math.min(gv.x, gv.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.mLQ == null) {
            this.mLQ = new Rect(0, 0, i / 5, i2);
        } else {
            this.mLQ.set(0, 0, i / 5, i2);
        }
        if (this.mLR == null) {
            this.mLR = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mLR.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mLQ == null) {
            return false;
        }
        return this.mLQ.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mQi.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mQi.findViewById(a.f.brightness_view);
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
        if (this.mLR == null) {
            return false;
        }
        return this.mLR.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.mQi.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mQi.findViewById(a.f.volumn_view);
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
                    this.mMi.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.bT) {
                    this.mQz.removeMessages(2);
                    this.mQz.A(2, 3000L);
                    return true;
                } else if (this.mQz != null) {
                    this.mQz.A(3, 1000L);
                    this.mQz.A(4, 1000L);
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
    public int Ja(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.mQA.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Jb(int i) {
        int streamMaxVolume = (i * 10) / this.mQA.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.mQi.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mQi.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dFE() && parserRet != null) {
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
                                    if (this.mQy != null && (this.mQy instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mQy).a(1, null, this.H, false, false, true);
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
            b.this.mQA.setStreamVolume(3, b.this.Ja(i), 0);
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
            b.this.mLS = i / 10.0f;
            ((VideoPlayer) b.this.mQy).l = b.this.mLS;
            ((VideoPlayer) b.this.mQy).k = b.this.mLS * 255.0f;
            b.this.mLU.screenBrightness = b.this.mLS;
            b.this.mLT.setAttributes(b.this.mLU);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mQi.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mQi.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mJW.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mQi.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mQi.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mMN.getCurrentPos();
                            int duration = this.mMN.getDuration();
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
                                this.mJW.setProgress(i3 / (duration / 1000));
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
        if (!this.mLV) {
            if (this.mLY.getVisibility() == 8 && (this.mMj == null || !this.mMj.isShown())) {
                boolean z = this.mQs != null && this.mQs.getVisibility() == 0;
                if (this.e) {
                    ax(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                aw(false, true);
                dFu();
            }
        }
        return false;
    }

    public boolean dEW() {
        if (this.mLV) {
            if (this.mRd != null) {
                this.mRd.e();
            }
            y(false);
            if (this.mLW != null) {
                this.mLW.setVisibility(0);
            }
            if (this.mKp != null) {
                this.mKp.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dFi() {
        super.dFi();
        if (this.mQy instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mQx != null) {
            this.mQx.f = null;
            if (this.mQx.dEL() != null) {
                this.mQx.dEL().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mMN != null) {
                this.mMN.seekTo(0L);
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
            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                tv.chushou.zues.utils.g.c(this.mQy, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mMN.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.mMy != null) {
                            this.mMy.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mQx.a(false);
                            ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                        } else if (this.mMN.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.mMN.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mMN.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wC(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.mMN.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mMN.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                tv.chushou.zues.utils.g.c(this.mQy, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mQx.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                    this.ai = false;
                    wC(true);
                    a(false, !this.ak);
                } else if (this.mMN.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                    this.ai = false;
                    wC(true);
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
            if (this.mQx != null && this.mQx.dEO() != null) {
                str = this.mQx.dEO().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dDT().mHk != null && com.kascend.chushou.a.a.dDT().mHk.contains(str) && this.mQx != null && !this.mMH) {
            this.mMH = true;
            com.kascend.chushou.a.a.dDT().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mMH = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mMy != null) {
            this.mMy.a(listItem, this.ap == 1, a.C0794a.zues_sweetalert_modal_in, a.C0794a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mMH = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mMc != null) {
                this.mMc.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mQs != null) {
                this.mQs.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mMc != null) {
            this.mMc.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mQs != null) {
                    this.mQs.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mQy);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mQi).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mRl != null) {
            this.mRl.dQW();
            this.mRl.setVisibility(8);
            this.mRl.unInit();
            ((RelativeLayout) this.mQi).removeView(this.mRl);
            this.mRl = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mQi).removeView(this.N);
            this.N = null;
        }
        aO();
        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.mQz != null) {
            y(true);
            this.mQz.removeMessages(1);
            this.mLW.setVisibility(0);
            this.mLZ.setVisibility(8);
            this.mKp.setVisibility(8);
            this.mMi.setVisibility(8);
        }
        if (this.mQX == null) {
            al();
            this.mQX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mKu.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mQX.isShowing()) {
            this.mQX.showAtLocation(view, 83, i, i2);
            this.mKu.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mQx.dEL().mRoominfo.mRoomID);
            return;
        }
        this.mQX.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mMu != null && this.mMu.b()) {
                this.mMu.getGlobalVisibleRect(this.mMJ);
                if (!this.mMJ.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mMu.a();
                    return true;
                }
            }
            if (this.mLV && f(this.mRd.b, motionEvent)) {
                dEW();
                return true;
            }
            if (!dFt()) {
                if (System.currentTimeMillis() - this.mMI < 300 && this.mMy != null && this.mMy.isShown()) {
                    this.mMy.a();
                    if (this.mMN.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mQx.a(false);
                            ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                        } else if (this.mMN.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mQy).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.mMN.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mMN.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wC(true);
                        }
                    }
                    return true;
                }
                this.mMI = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dFu() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
        if (this.mMj != null) {
            if (this.mMj.isShown()) {
                this.mMj.startAnimation(AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_top_anim));
            }
            this.mMj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mQy).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mQy).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mQq != null) {
                this.mQq.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gC(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLZ.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.mLZ.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mKp.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.mKp.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLY.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.mLY.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mLW.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.mLW.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
            this.mMo.setVisibility(0);
            if (this.mQx.dEL().mRoominfo.mIsSubscribed) {
                this.mMo.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mMo.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mMo.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void aP() {
        RoomInfo roomInfo;
        if (this.mQx != null && this.mQx.dEL() != null && (roomInfo = this.mQx.dEL().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mQy, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dSo();
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
        if (this.mQx != null && this.mQx.dEL() != null && (roomInfo = this.mQx.dEL().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dFE()) {
                        b.this.t(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dFE()) {
                        b.this.t(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.F(b.this.mQy, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.mQy, a.i.subscribe_success);
                            }
                            if (b.this.mQx != null && b.this.mQx.dEL() != null && (roomInfo2 = b.this.mQx.dEL().mRoominfo) != null) {
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
                    if (!b.this.dFE()) {
                        b.this.t(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mQy, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mQy, str2);
                    }
                }
            };
            if (this.mQx != null && this.mQx.h != null) {
                try {
                    str = new JSONObject(this.mQx.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dDV().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dDV().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.mMp == null) {
                this.mMp = new ProgressDialog(this.mQy);
                this.mMp.setProgressStyle(0);
                this.mMp.requestWindowFeature(1);
                this.mMp.setMessage(this.mQy.getText(a.i.update_userinfo_ing));
                this.mMp.setCancelable(true);
            }
            if (!this.mMp.isShowing()) {
                this.mMp.show();
            }
        } else if (this.mMp != null && this.mMp.isShowing()) {
            this.mMp.dismiss();
        }
    }

    private void dFb() {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
            if (this.mMr == null) {
                this.mMr = new f(getActivity());
            }
            this.mMr.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mMr = null;
                }
            });
            RoomInfo roomInfo = this.mQx.dEL().mRoominfo;
            this.mMr.a();
            this.mMr.a(roomInfo);
            if (!this.mMr.isShowing()) {
                this.mMr.show();
            }
        }
    }

    private void dFd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mMG != null && this.mQA != null && this.mQy != null && (this.mQy instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mMG;
            VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
            verticalSeekBarVolumn.setProgressOnly(Jb(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mJX != null) {
            this.mJX.dRQ();
        }
        if (this.mQi != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mMs == null) {
                this.mMs = new com.kascend.chushou.player.ui.giftpopup.a(this.mQi, i);
            } else if (this.mMs.a() != i) {
                this.mMs.b();
                this.mMs = null;
                this.mMs = new com.kascend.chushou.player.ui.giftpopup.a(this.mQi, i);
            }
            List<ListItem> j = this.mQx != null ? this.mQx.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
            if (videoPlayer != null) {
                this.mMs.a(j, videoPlayer.dEr(), videoPlayer.dEs(), videoPlayer.dEt(), videoPlayer.dEu());
                this.mMs.a(this.e);
                if (this.mQx != null && this.mQx.mJE != null) {
                    this.mMs.a(this.mQx.mJE, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mQx != null) {
                                b.this.mQx.mJE = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mMs != null && this.mQx != null) {
                    this.mMs.b(this.mQx.mJG);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void a(int i) {
        if (this.mMs != null && this.mQy != null) {
            this.mMs.a(((VideoPlayer) this.mQy).dEr());
            this.mMs.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void D() {
        if (this.mQy instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dEr = ((VideoPlayer) this.mQy).dEr();
            if (this.mRp == null) {
                this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mRp.setVisibility(0);
            this.mRp.a(i, dEr);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mMs != null) {
            this.mMs.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mMf != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mMf.setVisibility(0);
                    this.mMf.bV(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mMf.setVisibility(8);
                }
            }
            if (this.mMd != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mMe.setVisibility(0);
                    this.mMd.bV(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mMe.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mMs != null) {
            this.mMs.a(((VideoPlayer) this.mQy).dEs());
            this.mMs.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mMs != null) {
            this.mMs.a(((VideoPlayer) this.mQy).dEs());
            this.mMs.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(long j) {
        if (this.mMs != null) {
            this.mMs.a(((VideoPlayer) this.mQy).dEt());
            this.mMs.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0807a
    public void c(int i) {
        if (this.mMs != null) {
            this.mMs.a(((VideoPlayer) this.mQy).dEu());
            this.mMs.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wB(false);
        super.F();
    }

    private void c(View view) {
        this.mMz = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mKX = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mKX.setText(new tv.chushou.zues.widget.a.c().J(this.mQy, a.e.videoplayer_4g_video).append("  ").append(this.mQy.getString(a.i.videoplayer_4g_video)));
        this.mMA = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mMA.setText(new tv.chushou.zues.widget.a.c().J(this.mQy, a.e.videoplayer_4g_audio).append("  ").append(this.mQy.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.aH();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mQy, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mMz.setVisibility(8);
                    ((VideoPlayer) b.this.mQy).c(b.this.mKZ);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mMz.setVisibility(8);
                    ((VideoPlayer) b.this.mQy).d(b.this.mKZ);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
        findViewById.setLayoutParams(layoutParams);
        this.mKX.setOnClickListener(onClickListener);
        this.mMA.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mQx != null && !tv.chushou.zues.utils.h.isEmpty(this.mQx.f)) {
            f(this.mQx.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mKZ = z;
            this.p = false;
            if (this.mQx != null && this.mQx.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mQx.f.size()) {
                        break;
                    } else if (!"2".equals(this.mQx.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mMz != null) {
                this.mMz.setVisibility(0);
                this.mKX.setVisibility(0);
                this.mMA.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mMz != null) {
            this.mMz.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mMs != null && this.mQx != null) {
            this.mMs.b(this.mQx.mJG);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mQi != null && (findViewById = this.mQi.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mMd != null) {
            this.mMd.performClick();
        }
    }
}
