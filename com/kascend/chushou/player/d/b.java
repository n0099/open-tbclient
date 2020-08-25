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
import com.baidu.android.imsdk.internal.IMConnection;
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
/* loaded from: classes6.dex */
public class b extends d implements View.OnClickListener, View.OnTouchListener {
    public int bu;
    private long cu;
    private TextView nKL;
    private boolean nKN;
    private LinearLayout nLP;
    private FrameLayout nLT;
    private FrescoThumbnailView nLU;
    private ImageView nLX;
    private ImageView nLZ;
    RelativeLayout nMd;
    private ImageView nMe;
    private ImageView nMg;
    private f nMh;
    private com.kascend.chushou.player.ui.giftpopup.a nMj;
    private PopH5Menu nMl;
    private com.kascend.chushou.player.b.a nMm;
    private GiftAnimationLayout nMn;
    private ImageView nMo;
    private FoodView nMp;
    private RelativeLayout nMq;
    private TextView nMr;
    private VerticalSeekBarVolumn nMx;
    private Rect nLG = null;
    private Rect nLH = null;
    private float nLI = 0.0f;
    private Window nLJ = null;
    private WindowManager.LayoutParams nLK = null;
    private boolean bB = false;
    private View nLL = null;
    private View nKd = null;
    private View nLM = null;
    private View nLN = null;
    private View nLO = null;
    private ImageView nKi = null;
    private ImageView nLQ = null;
    private ImageButton nLR = null;
    private FrescoThumbnailView nLS = null;
    private LinearLayout nLV = null;
    private EditText nLW = null;
    private View nLY = null;
    private boolean nMa = false;
    private int nMb = 0;
    private int bV = 0;
    private long nMc = 0;
    private ProgressDialog nMf = null;
    private boolean nMi = true;
    private int nMk = -1;
    private boolean nMs = false;
    private TextView nMt = null;
    private TextView nMu = null;
    private int nMv = 0;
    private boolean nMw = false;
    private boolean nMy = false;
    private final Rect nMz = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.nQs = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.nJL = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nPW = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.nQl != null && !((Activity) this.nQl).isFinishing()) {
            dZP();
        }
        return this.nPW;
    }

    public void dZl() {
        aF(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nQl, "能量_num", "横屏", new Object[0]);
    }

    public boolean dZy() {
        if (this.nQV == null || !this.nQV.isShown()) {
            return false;
        }
        this.nQV.d();
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
        if (z3 || this.nPW.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.nQs)) {
            z = h.dYr().e;
        } else {
            z = h.dYr().b;
        }
        r(z);
        if (this.nQR != null) {
            this.nQR.b();
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
        if (this.nMj != null) {
            this.nMj.b();
            this.nMj = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cm(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            dZr();
            y();
            if (this.nJL != null) {
                this.nJL.onConfigurationChanged(configuration);
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
        if (this.nMl != null && this.nMk != i3) {
            this.nMl.a();
            this.nMl = null;
        }
        if (this.nMl == null) {
            this.nMl = (PopH5Menu) ((ViewStub) this.nPW.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point gW = tv.chushou.zues.utils.a.gW(getActivity());
            if (this.ap == 0) {
                int i4 = gW.y;
                i = gW.y;
                i2 = i4;
            } else {
                int i5 = gW.x;
                int i6 = gW.y - ((gW.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nMl.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.nMl.setLayoutParams(layoutParams);
            this.nMk = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.nMl.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!aa()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.nQl instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dYK = ((VideoPlayer) this.nQl).dYK();
                    if (this.nRd == null) {
                        this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nRd.setVisibility(0);
                    this.nRd.a(i, dYK);
                }
            } else if (bVar.a == 3) {
                if (this.nQl instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dYL = ((VideoPlayer) this.nQl).dYL();
                    if (this.nRd == null) {
                        this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nRd.setVisibility(0);
                    this.nRd.a(i, dYL);
                }
            } else if (bVar.a == 9) {
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dZe;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.nQk != null && mVar.b.equals(this.nQk.a) && (dZe = this.nQk.dZe()) != null) {
            dZe.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dZP() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.nQs)) {
            this.nQs = "1";
        }
        this.nMb = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
        this.bV = tv.chushou.zues.utils.systemBar.b.hb(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nMD = ((VideoPlayer) this.nQl).dYA();
        this.nQk = ((VideoPlayer) this.nQl).dYD();
        c(this.nPW);
        if (this.nQs.equals("1")) {
            this.nJJ = ((VideoPlayer) this.nQl).dYE();
            this.nJJ.a(this);
            if (this.nMm != null) {
                this.nMm.a();
                this.nMm = null;
                this.nMn = null;
            }
            this.nMn = (GiftAnimationLayout) this.nPW.findViewById(a.f.ll_gift_animation);
            this.nMn.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.nQk != null) {
                this.nMm = new com.kascend.chushou.player.b.a(this.nQl.getApplicationContext(), this.nMn);
                this.nMm.a(this.nQk);
            }
            this.B = (TextView) this.nPW.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.nQs.equals("3")) {
        }
        dZt();
        if (this.nJJ != null) {
            this.nJJ.d();
        }
        dZL();
        this.nLX = (ImageView) this.nPW.findViewById(a.f.btn_lockscreen);
        this.nLX.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.nPW.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nQf = (PlayerErrorView) this.nPW.findViewById(a.f.view_net_error_msg);
        this.nQf.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        dMD();
        this.nQV = (PaoGuideView) this.nPW.findViewById(a.f.rlPaoGuideView);
        this.nMo = (ImageView) this.nPW.findViewById(a.f.iv_send_danmu);
        this.nLO = this.nPW.findViewById(a.f.rt_layout);
        this.nLS = (FrescoThumbnailView) this.nLO.findViewById(a.f.btn_gift);
        this.nLT = (FrameLayout) this.nLO.findViewById(a.f.flfl_bottom_gift);
        this.nLU = (FrescoThumbnailView) this.nLO.findViewById(a.f.btn_recharge);
        this.nLU.setOnClickListener(this);
        a(this.nQk == null ? null : this.nQk.nJt);
        this.nRb = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.nQm != null) {
                    b.this.nQm.removeMessages(1);
                    b.this.nQm.B(1, 5000L);
                }
                b.this.nLX.setVisibility(0);
                b.this.nLO.setVisibility(0);
                b.this.nKd.setVisibility(0);
                b.this.nLL.setVisibility(0);
                if (b.this.nMj != null) {
                    b.this.nMj.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nQl, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.nLX.setVisibility(8);
                b.this.nLO.setVisibility(8);
                if (b.this.nMj != null) {
                    b.this.nMj.a(false);
                }
                b.this.nKd.setVisibility(8);
                b.this.nLL.setVisibility(8);
                if (b.this.nQm != null) {
                    b.this.nQm.removeMessages(1);
                }
                if (b.this.nQR != null) {
                    b.this.nQR.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nQl, 14.0f) + b.this.nQR.getMeasuredHeight(), 12);
                }
            }
        };
        this.nLV = (LinearLayout) this.nPW.findViewById(a.f.rl_seekbar);
        this.nMd = (RelativeLayout) this.nPW.findViewById(a.f.rl_paoicon);
        this.nMd.setOnClickListener(this);
        this.nQS = (RoundProgressBar) this.nPW.findViewById(a.f.roundProgressBar);
        this.nQU = (FrescoThumbnailView) this.nPW.findViewById(a.f.iv_paoicon);
        this.nQT = (TextView) this.nPW.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.nQW = 0L;
        com.kascend.chushou.player.ui.a.a dYN = ((VideoPlayer) this.nQl).dYN();
        a(dYN.eah());
        BangInfo eai = dYN.eai();
        if (eai != null) {
            a(eai, dYN.d());
        }
        if (this.nQs.equals("3")) {
            this.nLV.setVisibility(0);
            this.nLT.setVisibility(8);
            this.nMo.setVisibility(0);
            this.nMo.setOnClickListener(this);
        } else {
            this.nMo.setVisibility(8);
            this.nLV.setVisibility(8);
            this.nLT.setVisibility(0);
            this.nLS.setOnClickListener(this);
        }
        dZp();
        if (tv.chushou.zues.utils.systemBar.b.hc(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nLO.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.nLO.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nKd.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nKd.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nLN.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.nLN.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nLL.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.nLL.setLayoutParams(layoutParams4);
        }
        dZR();
        aG();
        dZr();
        this.h = (TextView) this.nPW.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nPW.findViewById(a.f.time_seekbar_relative);
        if (!this.nQs.equals("3")) {
            if (this.nQk.dZc() != null) {
                this.nMg.setVisibility(0);
            } else {
                this.nMg.setVisibility(8);
            }
        }
        dZQ();
        n();
        k(100);
        this.nMp = (FoodView) this.nPW.findViewById(a.f.kav_room_ad);
        this.nQm = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aF(false, true);
                            break;
                        case 2:
                            b.this.nQm.removeMessages(2);
                            if (b.this.nLX != null) {
                                b.this.nLX.setVisibility(8);
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
                            TextView textView = (TextView) b.this.nPW.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nQl.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nQm.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nQm.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nQm.B(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aE(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nQl).q) {
                                b.this.a(b.this.nQm);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nQl).q) {
                                b.this.b(b.this.nQm);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nQl).g = true;
                            b.this.nMD.seekTo((int) b.this.nga);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.nQk.d()) {
                                b.this.nMD.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nMD.getPlayState() == 4) {
                                int currentPos = b.this.nMD.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nQm != null) {
                                    b.this.nQm.B(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.eac();
                            break;
                        case 18:
                            b.this.aq();
                            break;
                        case 19:
                            b.this.nQj.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.nQk != null) {
            a(this.nQk.dZd());
        }
        if (this.nMD != null && (this.nMD.getPlayState() == 3 || this.nMD.getPlayState() == 4)) {
            yv(false);
            if (this.nQk.d()) {
                this.ak = false;
                yw(true);
                if (this.nMD.getDuration() > 60000) {
                    if (this.nMD.getDuration() < 300000) {
                        this.nQq = 60000;
                    } else {
                        this.nQq = Math.min(this.nMD.getDuration(), 300000);
                    }
                } else {
                    this.nQq = this.nMD.getDuration();
                }
            }
            this.e = false;
            aF(true, false);
            this.nQm.Ow(8);
            if (h() && this.nMD.getPlayState() == 4 && this.nQm != null) {
                this.nQm.removeMessages(15);
                this.nQm.Ow(15);
            }
        } else {
            yv(true);
            if (this.e) {
                aF(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dYq = g.dYq();
            int i = dYq.length == 2 ? dYq[1] : 0;
            if (i > 0) {
                View findViewById = this.nPW.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.nPW.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nQl, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nQl, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nQl != null && (this.nQl instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQl).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.nLU.Ck(a.e.ic_recharge_old);
            this.nLS.Ck(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.nMs && !this.k) {
            try {
                if (this.nMD != null) {
                    i = this.nMD.getCurrentPos();
                    i2 = this.nMD.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nJK.setProgress(i / (i2 / 1000));
                    this.nMt.setText(tv.chushou.zues.utils.b.o(this.nMD.getDuration(), false));
                    this.nMu.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dZQ() {
        this.nJK = (ProgressBar) this.nPW.findViewById(a.f.progressBarl);
        if (this.nJK != null) {
            if (this.nJK instanceof SeekBar) {
                ((SeekBar) this.nJK).setOnSeekBarChangeListener(new C0889b());
            }
            this.nJK.setMax(1000);
        }
        this.nMt = (TextView) this.nPW.findViewById(a.f.tv_time_duration);
        this.nMu = (TextView) this.nPW.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.nPW.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nPW.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dYN;
        BangInfo eai;
        if (config != null) {
            this.nQY = config;
            if (!config.display) {
                this.nMd.setVisibility(8);
            } else if ((this.nQl instanceof VideoPlayer) && (eai = (dYN = ((VideoPlayer) this.nQl).dYN()).eai()) != null) {
                a(eai, dYN.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.nQY == null || this.nQY.display) && this.nMd != null) {
            this.nMd.setVisibility(0);
            this.nQT.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nQl instanceof VideoPlayer) {
            if ((this.nQY == null || this.nQY.display) && this.nMd != null) {
                if (j > 0) {
                    this.nMd.setVisibility(0);
                    boolean z = this.nQX;
                    this.nQX = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nQl.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.nQT.setText(cVar);
                    return;
                }
                this.nQX = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0889b implements SeekBar.OnSeekBarChangeListener {
        C0889b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.nPX != null) {
                if (b.this.nMv != i || b.this.nMw != z) {
                    b.this.nMv = i;
                    b.this.nMw = z;
                    if (z) {
                        if (b.this.nMs) {
                            b.this.nga = (b.this.nMD.getDuration() / 1000) * i;
                        }
                        b.this.nMu.setText(tv.chushou.zues.utils.b.o((int) b.this.nga, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.nga, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.nga) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.nMs = true;
            b.this.m = b.this.nMD.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nQm != null) {
                if (b.this.nMs) {
                    b.this.nMs = false;
                }
                b.this.nQm.removeMessages(14);
                b.this.nQm.Ow(14);
            }
        }
    }

    private void k(int i) {
        this.nJK.setSecondaryProgress((i * 1000) / 100);
    }

    private void dZL() {
        this.nMx = (VerticalSeekBarVolumn) this.nPW.findViewById(a.f.volumn_seekbar);
        this.nMx.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nQn.getStreamVolume(3);
        this.nMx.setProgress(Ni(streamVolume));
        x(Ni(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.nPW.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.nJH = new d.a();
            this.c = new GestureDetector(this.nQl, this.nJH);
        }
    }

    private void dZR() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.nLJ == null) {
                this.nLJ = ((Activity) this.nQl).getWindow();
            }
            this.nLK = this.nLJ.getAttributes();
            this.nLI = ((VideoPlayer) this.nQl).k / 255.0f;
            ((VerticalSeekBarVolumn) this.nPW.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.nLI));
        }
    }

    private void aG() {
        this.nPW.findViewById(a.f.btn_send).setOnClickListener(this);
        this.nPW.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nQl.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.nPW.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.nLW == null) {
            this.nLW = (EditText) this.nPW.findViewById(a.f.et_input);
            this.nLW.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.nPW.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZo() {
        if (this.nMh != null) {
            this.nMh.dismiss();
            this.nMh = null;
        }
        if (this.nQl != null) {
            ((VideoPlayer) this.nQl).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nKd = this.nPW.findViewById(a.f.topview);
        this.nLP = (LinearLayout) this.nPW.findViewById(a.f.topRight);
        this.nLM = this.nKd.findViewById(a.f.rl_download);
        this.nLN = this.nPW.findViewById(a.f.topKeyboardView);
        this.nPW.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nKd.getVisibility() == 0;
        if (this.nMb > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nKd.getLayoutParams();
            layoutParams.topMargin = this.nMb;
            this.nKd.setLayoutParams(layoutParams);
        }
        this.nPW.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.nPW.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                str = this.nQk.dZc().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.nPW.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.nMe = (ImageView) this.nPW.findViewById(a.f.subscribe_icon);
        this.nMe.setOnClickListener(this);
        this.nMg = (ImageView) this.nPW.findViewById(a.f.report_icon);
        this.nMg.setOnClickListener(this);
        q();
    }

    private void dZp() {
        boolean z;
        this.nLL = this.nPW.findViewById(a.f.bottomview);
        this.nLR = (ImageButton) this.nLL.findViewById(a.f.playbutton);
        this.nLR.setOnTouchListener(this);
        this.nQc = (ImageButton) this.nPW.findViewById(a.f.btn_barrage);
        this.nQd = (ImageButton) this.nPW.findViewById(a.f.btn_audio);
        this.nLZ = (ImageView) this.nPW.findViewById(a.f.iv_danmu);
        if (!this.nQs.equals("3")) {
            this.nLL.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.nLL.findViewById(a.f.btn_refresh).setVisibility(0);
            this.nQc.setVisibility(0);
            this.nLZ.setVisibility(8);
            if (this.nQk != null && this.nQk.f != null) {
                for (int i = 0; i < this.nQk.f.size(); i++) {
                    if ("2".equals(this.nQk.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.nQd.setVisibility(0);
            } else {
                this.nQd.setVisibility(8);
            }
            this.nLL.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.nQc.setOnClickListener(this);
            if (h.dYr().e) {
                this.nQc.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nQc.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.nQk.d) {
                this.nQd.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.nQd.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.nQd.setOnClickListener(this);
            this.nKi = (ImageView) this.nLL.findViewById(a.f.btn_hotword);
            this.nLQ = (ImageView) this.nPW.findViewById(a.f.iv_task_badge);
            this.nKi.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nQl, a.C0882a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dYr().c) {
                        b.this.nKi.clearAnimation();
                        b.this.nKi.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nKi.clearAnimation();
            if (h.dYr().c) {
                this.nKi.startAnimation(animationSet);
                this.nLQ.setVisibility(0);
            }
        } else {
            this.nLL.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.nLL.findViewById(a.f.btn_refresh).setVisibility(8);
            this.nQc.setVisibility(8);
            this.nQd.setVisibility(8);
            this.nLZ.setVisibility(0);
            this.nLZ.setOnClickListener(this);
            if (h.dYr().b) {
                this.nLZ.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nLZ.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.nLL.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nQl != null) {
            ((VideoPlayer) this.nQl).e(true);
        }
        if (this.nQm != null) {
            this.nQm.cl(null);
            this.nQm = null;
        }
        this.c = null;
        this.nJH = null;
        this.nLX = null;
        if (this.nLW != null) {
            this.nLW.addTextChangedListener(null);
            this.nLW.setOnEditorActionListener(null);
            this.nLW = null;
        }
        this.nKd = null;
        this.nQc = null;
        this.nQd = null;
        this.nLL = null;
        this.nLO = null;
        if (this.nMm != null) {
            this.nMm.a();
            this.nMm = null;
            this.nMn = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dZH() {
        return this.nMm;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.nPW == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.nRd == null || !this.nRd.a(i, keyEvent)) {
                    if ((this.nMl == null || !this.nMl.onKeyDown(i, keyEvent)) && !dZy() && !dZn()) {
                        if (this.nLN != null && this.nLN.getVisibility() == 0) {
                            aE(false, true);
                            return true;
                        } else if (this.nLY != null && this.nLY.isShown()) {
                            aB();
                            return true;
                        } else if (this.nMa && this.nQm != null) {
                            if (this.nLX != null) {
                                this.nLX.setVisibility(0);
                            }
                            this.nQm.removeMessages(2);
                            this.nQm.B(2, IMConnection.RETRY_DELAY_TIMES);
                            return true;
                        } else {
                            dZo();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.nPW.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.nPW.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nQm != null) {
                    this.nQm.removeMessages(3);
                    this.nQm.B(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dZS() {
        if (this.nMa) {
            this.nLX.setVisibility(0);
            this.nQm.removeMessages(2);
            this.nQm.B(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.nMa;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.nMa) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.nLX.setVisibility(0);
            this.nQm.removeMessages(2);
            this.nQm.B(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.c(this.nQl, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.az(getActivity()) && tv.chushou.zues.utils.systemBar.b.aA(getActivity())) {
                    o(view, tv.chushou.zues.utils.systemBar.b.hb(getActivity()), 0);
                    return;
                } else {
                    o(view, 0, 0);
                    return;
                }
            }
            o(view, 0, this.nKd.getHeight() + this.nKd.getTop());
        } else if (id == a.f.btn_send) {
            if (this.nQs.equals("3")) {
                String trim = this.nLW.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.H(this.nQl, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.nLW.setText((CharSequence) null);
                aE(false, true);
            } else if (a(this.nLW.getText().toString(), false)) {
                aE(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.hb(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.nQl, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dZo();
            com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dZZ() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.nQR == null;
                b(false, false);
                if (z && this.bV > 0 && this.nQR != null && tv.chushou.zues.utils.systemBar.b.az(getActivity()) && tv.chushou.zues.utils.systemBar.b.aA(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nQR.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.nQR.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.nQR == null;
                if (this.nQl.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.nQR != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nQR.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.nQR.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQk.dZc().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aE(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aF(false, false);
            this.nQm.B(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dYr().c) {
                h.dYr().b(false);
                this.nKi.clearAnimation();
                this.nLQ.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.nLL.findViewById(a.f.ll_keyboard).getLeft(), this.nLL.getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
            } else {
                m(view, this.nLL.findViewById(a.f.ll_keyboard).getLeft(), this.nLL.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                tv.chushou.zues.utils.g.c(this.nQl, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.nQl, dZZ(), false);
        } else if (id == a.f.btn_screenChange) {
            dZo();
        } else if (id == a.f.rl_paoicon) {
            dZl();
        } else if (id == a.f.subscribe_icon) {
            dZu();
        } else if (id == a.f.report_icon) {
            if (this.nQs.equals("3")) {
                dZx();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dZv();
            }
        } else if (id == a.f.btn_audio && !this.nQk.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.OF(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nMc <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.OF(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dYr().e) {
                s(true);
                ve();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
            if (com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a(((VideoPlayer) this.nQl).dYD().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.nMc = System.currentTimeMillis();
                a(this.nQk.dZc().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nQk.h);
                if (!z) {
                    this.nLW.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.nQs.equals("3")) {
            if (this.nQc != null) {
                if (z) {
                    this.nQc.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nQc.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.nLZ != null) {
            if (z) {
                this.nLZ.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nLZ.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dZw() {
        if (this.nPW == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nPW.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.nQZ != null) {
            this.nQZ.setVisibility(z ? 0 : 8);
            if (!z) {
                this.nQZ.elv();
            }
        }
        tv.chushou.zues.utils.g.y(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.nQk.d()) {
            if (this.nMa) {
                this.nLX.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nQl, this.nQl.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.nLX.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nQl, this.nQl.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.nMa = !this.nMa;
            if (this.nLW != null) {
                this.nLW.setEnabled(this.nMa ? false : true);
            }
        }
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dM(this.nLW);
            this.nLW.setText("");
            this.nLO.setVisibility(8);
            this.nLX.setVisibility(8);
            this.nKd.setVisibility(8);
            this.nLL.setVisibility(8);
            this.nLN.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
        if (this.nLN.getVisibility() != 8 && z2) {
            this.nLN.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_top_anim));
        }
        this.nLO.setVisibility(8);
        this.nLX.setVisibility(8);
        this.nKd.setVisibility(8);
        this.nLL.setVisibility(8);
        this.nLN.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aF(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.nLP != null) {
            this.nLP.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aF(boolean z, boolean z2) {
        return l(z, z2, false);
    }

    public boolean l(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.nMj != null) {
                this.nMj.a(this.e);
            }
            return this.e;
        }
        if (this.nQm != null) {
            this.nQm.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nQl).e(true);
            if (!z3) {
                if (this.nLL.getVisibility() != 0 && z2) {
                    this.nLL.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_bottom_anim));
                }
                this.nLL.setVisibility(0);
                this.nLO.setVisibility(0);
                this.nLX.setVisibility(0);
                this.nLM.setVisibility(o() ? 0 : 8);
            }
            if (this.nKd.getVisibility() != 0 && z2) {
                this.nKd.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_top_anim));
            }
            u(!z3);
            this.nKd.setVisibility(0);
            if (this.nQm != null) {
                this.nQm.B(1, 5000L);
            }
            y(false);
            if (this.nMj != null) {
                this.nMj.a(true);
            }
        } else {
            ((VideoPlayer) this.nQl).e(false);
            if (this.nQE != null) {
                this.nQE.dismiss();
            }
            if (this.nQF != null) {
                this.nQF.dismiss();
            }
            if (this.nQM != null) {
                this.nQM.dismiss();
            }
            if (this.nLL != null) {
                if (this.nLL.getVisibility() != 8 && z2) {
                    this.nLL.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_bottom_anim));
                }
                this.nLL.setVisibility(8);
            }
            if (this.nLO != null) {
                this.nLO.setVisibility(8);
                if (this.nKd.getVisibility() != 8 && z2) {
                    this.nKd.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_top_anim));
                }
                this.nKd.setVisibility(8);
                this.nLX.setVisibility(8);
                y(true);
                a(false);
                if (this.nMj != null) {
                    this.nMj.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dZr() {
        Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
        if (this.ap == 1) {
            this.ar = Math.min(gW.x, gW.y);
            this.aq = Math.max(gW.x, gW.y);
        } else {
            this.ar = Math.max(gW.x, gW.y);
            this.aq = Math.min(gW.x, gW.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.nLG == null) {
            this.nLG = new Rect(0, 0, i / 5, i2);
        } else {
            this.nLG.set(0, 0, i / 5, i2);
        }
        if (this.nLH == null) {
            this.nLH = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.nLH.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.nLG == null) {
            return false;
        }
        return this.nLG.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.nPW.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nPW.findViewById(a.f.brightness_view);
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

    private boolean an(MotionEvent motionEvent) {
        if (this.nLH == null) {
            return false;
        }
        return this.nLH.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.nPW.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nPW.findViewById(a.f.volumn_view);
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
                if (this.nMa) {
                    this.nLX.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.nMa) {
                    this.nQm.removeMessages(2);
                    this.nQm.B(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.nQm != null) {
                    this.nQm.B(3, 1000L);
                    this.nQm.B(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.nMa) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fX(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.nQn.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Ni(int i) {
        int streamMaxVolume = (i * 10) / this.nQn.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.nPW.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.nPW.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!aa() && parserRet != null) {
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
                                    if (this.nQl != null && (this.nQl instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nQl).a(1, null, this.H, false, false, true);
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
    /* loaded from: classes6.dex */
    public class c implements VerticalSeekBarVolumn.a {
        private c() {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar, int i, boolean z) {
            b.this.nQn.setStreamVolume(3, b.this.fX(i), 0);
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
    /* loaded from: classes6.dex */
    public class a implements VerticalSeekBarVolumn.a {
        private a() {
        }

        @Override // com.kascend.chushou.widget.VerticalSeekBarVolumn.a
        public void a(SeekBar seekBar, int i, boolean z) {
            b.this.nLI = i / 10.0f;
            ((VideoPlayer) b.this.nQl).l = b.this.nLI;
            ((VideoPlayer) b.this.nQl).k = b.this.nLI * 255.0f;
            b.this.nLK.screenBrightness = b.this.nLI;
            b.this.nLJ.setAttributes(b.this.nLK);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.nPW.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (an(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.nPW.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.nQq > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.nJK.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.nPW.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.nPW.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nMD.getCurrentPos();
                            int duration = this.nMD.getDuration();
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
                                this.nJK.setProgress(i3 / (duration / 1000));
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
        if (!this.bB) {
            if (this.nLN.getVisibility() == 8 && (this.nLY == null || !this.nLY.isShown())) {
                boolean z = this.nQf != null && this.nQf.getVisibility() == 0;
                if (this.e) {
                    aF(false, true);
                } else {
                    l(true, true, z);
                }
                aVar.d = 0;
            } else {
                aE(false, true);
                aB();
            }
        }
        return false;
    }

    public boolean dZn() {
        if (this.bB) {
            if (this.nQR != null) {
                this.nQR.e();
            }
            y(false);
            if (this.nLL != null) {
                this.nLL.setVisibility(0);
            }
            if (this.nKd != null) {
                this.nKd.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.nQl instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.nQk != null) {
            this.nQk.f = null;
            if (this.nQk.dZc() != null) {
                this.nQk.dZc().mRoominfo.mGameId = null;
            }
        }
        if (this.nQs.equals("3")) {
            if (this.nMD != null) {
                this.nMD.seekTo(0L);
                e(true);
            }
            dZo();
            return;
        }
        dZo();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.nMa) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                tv.chushou.zues.utils.g.c(this.nQl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nMD.getPlayState() == 4) {
                        dZs();
                        e(true);
                    } else {
                        if (this.nMp != null) {
                            this.nMp.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.nQk.a(false);
                            ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                        } else if (!this.nQs.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                        } else if (this.nMD.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nMD.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nMD.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            yw(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nMD.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nMD.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                tv.chushou.zues.utils.g.c(this.nQl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.nQk.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                } else if (!this.nQs.equals("3")) {
                    ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                    this.ai = false;
                    yw(true);
                    a(false, !this.ak);
                } else if (this.nMD.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                    this.ai = false;
                    yw(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void dZs() {
        String str = null;
        if (!this.nQs.equals("3")) {
            if (this.nQk != null && this.nQk.dZe() != null) {
                str = this.nQk.dZe().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dYk().nHc != null && com.kascend.chushou.a.a.dYk().nHc.contains(str) && this.nQk != null && !this.nMy) {
            this.nMy = true;
            com.kascend.chushou.a.a.dYk().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.nMy = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.nMp != null) {
            this.nMp.a(listItem, this.ap == 1, a.C0882a.zues_sweetalert_modal_in, a.C0882a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.nMy = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nLR != null) {
                this.nLR.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nQf != null) {
                this.nQf.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nLR != null) {
            this.nLR.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nQf != null) {
                    this.nQf.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dZt() {
        this.nPX = new SurfaceView(this.nQl);
        SurfaceView surfaceView = (SurfaceView) this.nPX;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.nPW).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void dZC() {
        if (this.nQZ != null) {
            this.nQZ.elv();
            this.nQZ.setVisibility(8);
            this.nQZ.unInit();
            ((RelativeLayout) this.nPW).removeView(this.nQZ);
            this.nQZ = null;
        }
        if (this.nPX != null) {
            this.nPX.setVisibility(8);
            ((RelativeLayout) this.nPW).removeView(this.nPX);
            this.nPX = null;
        }
        dZt();
        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.nQm != null) {
            y(true);
            this.nQm.removeMessages(1);
            this.nLL.setVisibility(0);
            this.nLO.setVisibility(8);
            this.nKd.setVisibility(8);
            this.nLX.setVisibility(8);
        }
        if (this.nQM == null) {
            al();
            this.nQM.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nKi.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.nQM.isShowing()) {
            this.nQM.showAtLocation(view, 83, i, i2);
            this.nKi.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nQk.dZc().mRoominfo.mRoomID);
            return;
        }
        this.nQM.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nMl != null && this.nMl.b()) {
                this.nMl.getGlobalVisibleRect(this.nMz);
                if (!this.nMz.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.nMl.a();
                    return true;
                }
            }
            if (this.bB && f(this.nQR.b, motionEvent)) {
                dZn();
                return true;
            }
            if (!dZS()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.nMp != null && this.nMp.isShown()) {
                    this.nMp.a();
                    if (this.nMD.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.nQk.a(false);
                            ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                        } else if (!this.nQs.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                        } else if (this.nMD.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nQl).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nMD.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nMD.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            yw(true);
                        }
                    }
                    return true;
                }
                this.cu = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void aB() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
        if (this.nLY != null) {
            if (this.nLY.isShown()) {
                this.nLY.startAnimation(AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_top_anim));
            }
            this.nLY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nQl).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nQl).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.nQd != null) {
                this.nQd.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hc(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nLO.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.nLO.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nKd.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nKd.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nLN.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.nLN.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nLL.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.nLL.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
            this.nMe.setVisibility(0);
            if (this.nQk.dZc().mRoominfo.mIsSubscribed) {
                this.nMe.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.nMe.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.nMe.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dZu() {
        RoomInfo roomInfo;
        if (this.nQk != null && this.nQk.dZc() != null && (roomInfo = this.nQk.dZc().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nQl, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.emM();
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
        if (this.nQk != null && this.nQk.dZc() != null && (roomInfo = this.nQk.dZc().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.aa()) {
                        b.this.t(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.aa()) {
                        b.this.t(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.H(b.this.nQl, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.H(b.this.nQl, a.i.subscribe_success);
                            }
                            if (b.this.nQk != null && b.this.nQk.dZc() != null && (roomInfo2 = b.this.nQk.dZc().mRoominfo) != null) {
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
                    if (!b.this.aa()) {
                        b.this.t(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.nQl, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nQl, str2);
                    }
                }
            };
            if (this.nQk != null && this.nQk.h != null) {
                try {
                    str = new JSONObject(this.nQk.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dYm().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dYm().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.nMf == null) {
                this.nMf = new ProgressDialog(this.nQl);
                this.nMf.setProgressStyle(0);
                this.nMf.requestWindowFeature(1);
                this.nMf.setMessage(this.nQl.getText(a.i.update_userinfo_ing));
                this.nMf.setCancelable(true);
            }
            if (!this.nMf.isShowing()) {
                this.nMf.show();
            }
        } else if (this.nMf != null && this.nMf.isShowing()) {
            this.nMf.dismiss();
        }
    }

    private void dZv() {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
            if (this.nMh == null) {
                this.nMh = new f(getActivity());
            }
            this.nMh.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.nMh = null;
                }
            });
            RoomInfo roomInfo = this.nQk.dZc().mRoominfo;
            this.nMh.a();
            this.nMh.a(roomInfo);
            if (!this.nMh.isShowing()) {
                this.nMh.show();
            }
        }
    }

    private void dZx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.nMx != null && this.nQn != null && this.nQl != null && (this.nQl instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.nMx;
            VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
            verticalSeekBarVolumn.setProgressOnly(Ni(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.nJL != null) {
            this.nJL.emo();
        }
        if (this.nPW != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.nMj == null) {
                this.nMj = new com.kascend.chushou.player.ui.giftpopup.a(this.nPW, i);
            } else if (this.nMj.a() != i) {
                this.nMj.b();
                this.nMj = null;
                this.nMj = new com.kascend.chushou.player.ui.giftpopup.a(this.nPW, i);
            }
            List<ListItem> j = this.nQk != null ? this.nQk.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
            if (videoPlayer != null) {
                this.nMj.a(j, videoPlayer.dYJ(), videoPlayer.dYK(), videoPlayer.dYL(), videoPlayer.dYM());
                this.nMj.a(this.e);
                if (this.nQk != null && this.nQk.nJr != null) {
                    this.nMj.a(this.nQk.nJr, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.nQk != null) {
                                b.this.nQk.nJr = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.nMj != null && this.nQk != null) {
                    this.nMj.b(this.nQk.nJu);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nMj != null && this.nQl != null) {
            this.nMj.a(((VideoPlayer) this.nQl).dYJ());
            this.nMj.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQl instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dYJ = ((VideoPlayer) this.nQl).dYJ();
            if (this.nRd == null) {
                this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRd.setVisibility(0);
            this.nRd.a(i, dYJ);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.nMj != null) {
            this.nMj.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.nLU != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.nLU.setVisibility(0);
                    this.nLU.bX(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.nLU.setVisibility(8);
                }
            }
            if (this.nLS != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.nLT.setVisibility(0);
                    this.nLS.bX(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.nLT.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nMj != null) {
            this.nMj.a(((VideoPlayer) this.nQl).dYK());
            this.nMj.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nMj != null) {
            this.nMj.a(((VideoPlayer) this.nQl).dYK());
            this.nMj.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nMj != null) {
            this.nMj.a(((VideoPlayer) this.nQl).dYL());
            this.nMj.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nMj != null) {
            this.nMj.a(((VideoPlayer) this.nQl).dYM());
            this.nMj.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        yv(false);
        super.F();
    }

    private void c(View view) {
        this.nMq = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nKL = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nKL.setText(new tv.chushou.zues.widget.a.c().L(this.nQl, a.e.videoplayer_4g_video).append("  ").append(this.nQl.getString(a.i.videoplayer_4g_video)));
        this.nMr = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nMr.setText(new tv.chushou.zues.widget.a.c().L(this.nQl, a.e.videoplayer_4g_audio).append("  ").append(this.nQl.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dZo();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nQl, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.nMq.setVisibility(8);
                    ((VideoPlayer) b.this.nQl).c(b.this.nKN);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.nMq.setVisibility(8);
                    ((VideoPlayer) b.this.nQl).d(b.this.nKN);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
        findViewById.setLayoutParams(layoutParams);
        this.nKL.setOnClickListener(onClickListener);
        this.nMr.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nQk != null && !tv.chushou.zues.utils.h.isEmpty(this.nQk.f)) {
            f(this.nQk.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nKN = z;
            this.p = false;
            if (this.nQk != null && this.nQk.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nQk.f.size()) {
                        break;
                    } else if (!"2".equals(this.nQk.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nMq != null) {
                this.nMq.setVisibility(0);
                this.nKL.setVisibility(0);
                this.nMr.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nMq != null) {
            this.nMq.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nMj != null && this.nQk != null) {
            this.nMj.b(this.nQk.nJu);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.nPW != null && (findViewById = this.nPW.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nLS != null) {
            this.nLS.performClick();
        }
    }
}
