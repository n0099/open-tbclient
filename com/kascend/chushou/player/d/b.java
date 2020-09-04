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
    private TextView nLd;
    private boolean nLf;
    private com.kascend.chushou.player.ui.giftpopup.a nMB;
    private PopH5Menu nMD;
    private com.kascend.chushou.player.b.a nME;
    private GiftAnimationLayout nMF;
    private ImageView nMG;
    private FoodView nMH;
    private RelativeLayout nMI;
    private TextView nMJ;
    private VerticalSeekBarVolumn nMP;
    private LinearLayout nMh;
    private FrameLayout nMl;
    private FrescoThumbnailView nMm;
    private ImageView nMp;
    private ImageView nMr;
    RelativeLayout nMv;
    private ImageView nMw;
    private ImageView nMy;
    private f nMz;
    private Rect nLY = null;
    private Rect nLZ = null;
    private float nMa = 0.0f;
    private Window nMb = null;
    private WindowManager.LayoutParams nMc = null;
    private boolean bB = false;
    private View nMd = null;
    private View nKv = null;
    private View nMe = null;
    private View nMf = null;
    private View nMg = null;
    private ImageView nKA = null;
    private ImageView nMi = null;
    private ImageButton nMj = null;
    private FrescoThumbnailView nMk = null;
    private LinearLayout nMn = null;
    private EditText nMo = null;
    private View nMq = null;
    private boolean nMs = false;
    private int nMt = 0;
    private int bV = 0;
    private long nMu = 0;
    private ProgressDialog nMx = null;
    private boolean nMA = true;
    private int nMC = -1;
    private boolean nMK = false;
    private TextView nML = null;
    private TextView nMM = null;
    private int nMN = 0;
    private boolean nMO = false;
    private boolean nMQ = false;
    private final Rect nMR = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.nQK = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.nKd = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nQo = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.nQD != null && !((Activity) this.nQD).isFinishing()) {
            dZY();
        }
        return this.nQo;
    }

    public void dZu() {
        aF(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nQD, "能量_num", "横屏", new Object[0]);
    }

    public boolean dZH() {
        if (this.nRn == null || !this.nRn.isShown()) {
            return false;
        }
        this.nRn.d();
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
        if (z3 || this.nQo.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.nQK)) {
            z = h.dYA().e;
        } else {
            z = h.dYA().b;
        }
        r(z);
        if (this.nRj != null) {
            this.nRj.b();
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
        if (this.nMB != null) {
            this.nMB.b();
            this.nMB = null;
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
            dZA();
            y();
            if (this.nKd != null) {
                this.nKd.onConfigurationChanged(configuration);
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
        if (this.nMD != null && this.nMC != i3) {
            this.nMD.a();
            this.nMD = null;
        }
        if (this.nMD == null) {
            this.nMD = (PopH5Menu) ((ViewStub) this.nQo.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nMD.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.nMD.setLayoutParams(layoutParams);
            this.nMC = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.nMD.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.nQD instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dYT = ((VideoPlayer) this.nQD).dYT();
                    if (this.nRv == null) {
                        this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nRv.setVisibility(0);
                    this.nRv.a(i, dYT);
                }
            } else if (bVar.a == 3) {
                if (this.nQD instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dYU = ((VideoPlayer) this.nQD).dYU();
                    if (this.nRv == null) {
                        this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nRv.setVisibility(0);
                    this.nRv.a(i, dYU);
                }
            } else if (bVar.a == 9) {
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dZn;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.nQC != null && mVar.b.equals(this.nQC.a) && (dZn = this.nQC.dZn()) != null) {
            dZn.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dZY() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.nQK)) {
            this.nQK = "1";
        }
        this.nMt = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
        this.bV = tv.chushou.zues.utils.systemBar.b.hb(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nMV = ((VideoPlayer) this.nQD).dYJ();
        this.nQC = ((VideoPlayer) this.nQD).dYM();
        c(this.nQo);
        if (this.nQK.equals("1")) {
            this.nKb = ((VideoPlayer) this.nQD).dYN();
            this.nKb.a(this);
            if (this.nME != null) {
                this.nME.a();
                this.nME = null;
                this.nMF = null;
            }
            this.nMF = (GiftAnimationLayout) this.nQo.findViewById(a.f.ll_gift_animation);
            this.nMF.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.nQC != null) {
                this.nME = new com.kascend.chushou.player.b.a(this.nQD.getApplicationContext(), this.nMF);
                this.nME.a(this.nQC);
            }
            this.B = (TextView) this.nQo.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.nQK.equals("3")) {
        }
        dZC();
        if (this.nKb != null) {
            this.nKb.d();
        }
        dZU();
        this.nMp = (ImageView) this.nQo.findViewById(a.f.btn_lockscreen);
        this.nMp.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.nQo.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nQx = (PlayerErrorView) this.nQo.findViewById(a.f.view_net_error_msg);
        this.nQx.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        dMM();
        this.nRn = (PaoGuideView) this.nQo.findViewById(a.f.rlPaoGuideView);
        this.nMG = (ImageView) this.nQo.findViewById(a.f.iv_send_danmu);
        this.nMg = this.nQo.findViewById(a.f.rt_layout);
        this.nMk = (FrescoThumbnailView) this.nMg.findViewById(a.f.btn_gift);
        this.nMl = (FrameLayout) this.nMg.findViewById(a.f.flfl_bottom_gift);
        this.nMm = (FrescoThumbnailView) this.nMg.findViewById(a.f.btn_recharge);
        this.nMm.setOnClickListener(this);
        a(this.nQC == null ? null : this.nQC.nJL);
        this.nRt = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.nQE != null) {
                    b.this.nQE.removeMessages(1);
                    b.this.nQE.B(1, 5000L);
                }
                b.this.nMp.setVisibility(0);
                b.this.nMg.setVisibility(0);
                b.this.nKv.setVisibility(0);
                b.this.nMd.setVisibility(0);
                if (b.this.nMB != null) {
                    b.this.nMB.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nQD, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.nMp.setVisibility(8);
                b.this.nMg.setVisibility(8);
                if (b.this.nMB != null) {
                    b.this.nMB.a(false);
                }
                b.this.nKv.setVisibility(8);
                b.this.nMd.setVisibility(8);
                if (b.this.nQE != null) {
                    b.this.nQE.removeMessages(1);
                }
                if (b.this.nRj != null) {
                    b.this.nRj.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nQD, 14.0f) + b.this.nRj.getMeasuredHeight(), 12);
                }
            }
        };
        this.nMn = (LinearLayout) this.nQo.findViewById(a.f.rl_seekbar);
        this.nMv = (RelativeLayout) this.nQo.findViewById(a.f.rl_paoicon);
        this.nMv.setOnClickListener(this);
        this.nRk = (RoundProgressBar) this.nQo.findViewById(a.f.roundProgressBar);
        this.nRm = (FrescoThumbnailView) this.nQo.findViewById(a.f.iv_paoicon);
        this.nRl = (TextView) this.nQo.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.nRo = 0L;
        com.kascend.chushou.player.ui.a.a dYW = ((VideoPlayer) this.nQD).dYW();
        a(dYW.eaq());
        BangInfo ear = dYW.ear();
        if (ear != null) {
            a(ear, dYW.d());
        }
        if (this.nQK.equals("3")) {
            this.nMn.setVisibility(0);
            this.nMl.setVisibility(8);
            this.nMG.setVisibility(0);
            this.nMG.setOnClickListener(this);
        } else {
            this.nMG.setVisibility(8);
            this.nMn.setVisibility(8);
            this.nMl.setVisibility(0);
            this.nMk.setOnClickListener(this);
        }
        dZy();
        if (tv.chushou.zues.utils.systemBar.b.hc(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nMg.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.nMg.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nKv.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nKv.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nMf.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.nMf.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nMd.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.nMd.setLayoutParams(layoutParams4);
        }
        eaa();
        aG();
        dZA();
        this.h = (TextView) this.nQo.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nQo.findViewById(a.f.time_seekbar_relative);
        if (!this.nQK.equals("3")) {
            if (this.nQC.dZl() != null) {
                this.nMy.setVisibility(0);
            } else {
                this.nMy.setVisibility(8);
            }
        }
        dZZ();
        n();
        k(100);
        this.nMH = (FoodView) this.nQo.findViewById(a.f.kav_room_ad);
        this.nQE = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aF(false, true);
                            break;
                        case 2:
                            b.this.nQE.removeMessages(2);
                            if (b.this.nMp != null) {
                                b.this.nMp.setVisibility(8);
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
                            TextView textView = (TextView) b.this.nQo.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nQD.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nQE.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nQE.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nQE.B(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aE(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nQD).q) {
                                b.this.a(b.this.nQE);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nQD).q) {
                                b.this.b(b.this.nQE);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nQD).g = true;
                            b.this.nMV.seekTo((int) b.this.ngs);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.nQC.d()) {
                                b.this.nMV.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nMV.getPlayState() == 4) {
                                int currentPos = b.this.nMV.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nQE != null) {
                                    b.this.nQE.B(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.eal();
                            break;
                        case 18:
                            b.this.aq();
                            break;
                        case 19:
                            b.this.nQB.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.nQC != null) {
            a(this.nQC.dZm());
        }
        if (this.nMV != null && (this.nMV.getPlayState() == 3 || this.nMV.getPlayState() == 4)) {
            yx(false);
            if (this.nQC.d()) {
                this.ak = false;
                yy(true);
                if (this.nMV.getDuration() > 60000) {
                    if (this.nMV.getDuration() < 300000) {
                        this.nQI = 60000;
                    } else {
                        this.nQI = Math.min(this.nMV.getDuration(), 300000);
                    }
                } else {
                    this.nQI = this.nMV.getDuration();
                }
            }
            this.e = false;
            aF(true, false);
            this.nQE.Ow(8);
            if (h() && this.nMV.getPlayState() == 4 && this.nQE != null) {
                this.nQE.removeMessages(15);
                this.nQE.Ow(15);
            }
        } else {
            yx(true);
            if (this.e) {
                aF(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dYz = g.dYz();
            int i = dYz.length == 2 ? dYz[1] : 0;
            if (i > 0) {
                View findViewById = this.nQo.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.nQo.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nQD, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nQD, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nQD != null && (this.nQD instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQD).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.nMm.Ck(a.e.ic_recharge_old);
            this.nMk.Ck(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.nMK && !this.k) {
            try {
                if (this.nMV != null) {
                    i = this.nMV.getCurrentPos();
                    i2 = this.nMV.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nKc.setProgress(i / (i2 / 1000));
                    this.nML.setText(tv.chushou.zues.utils.b.o(this.nMV.getDuration(), false));
                    this.nMM.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dZZ() {
        this.nKc = (ProgressBar) this.nQo.findViewById(a.f.progressBarl);
        if (this.nKc != null) {
            if (this.nKc instanceof SeekBar) {
                ((SeekBar) this.nKc).setOnSeekBarChangeListener(new C0889b());
            }
            this.nKc.setMax(1000);
        }
        this.nML = (TextView) this.nQo.findViewById(a.f.tv_time_duration);
        this.nMM = (TextView) this.nQo.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.nQo.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nQo.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dYW;
        BangInfo ear;
        if (config != null) {
            this.nRq = config;
            if (!config.display) {
                this.nMv.setVisibility(8);
            } else if ((this.nQD instanceof VideoPlayer) && (ear = (dYW = ((VideoPlayer) this.nQD).dYW()).ear()) != null) {
                a(ear, dYW.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.nRq == null || this.nRq.display) && this.nMv != null) {
            this.nMv.setVisibility(0);
            this.nRl.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nQD instanceof VideoPlayer) {
            if ((this.nRq == null || this.nRq.display) && this.nMv != null) {
                if (j > 0) {
                    this.nMv.setVisibility(0);
                    boolean z = this.nRp;
                    this.nRp = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nQD.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.nRl.setText(cVar);
                    return;
                }
                this.nRp = false;
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
            if (b.this.nQp != null) {
                if (b.this.nMN != i || b.this.nMO != z) {
                    b.this.nMN = i;
                    b.this.nMO = z;
                    if (z) {
                        if (b.this.nMK) {
                            b.this.ngs = (b.this.nMV.getDuration() / 1000) * i;
                        }
                        b.this.nMM.setText(tv.chushou.zues.utils.b.o((int) b.this.ngs, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.ngs, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.ngs) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.nMK = true;
            b.this.m = b.this.nMV.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nQE != null) {
                if (b.this.nMK) {
                    b.this.nMK = false;
                }
                b.this.nQE.removeMessages(14);
                b.this.nQE.Ow(14);
            }
        }
    }

    private void k(int i) {
        this.nKc.setSecondaryProgress((i * 1000) / 100);
    }

    private void dZU() {
        this.nMP = (VerticalSeekBarVolumn) this.nQo.findViewById(a.f.volumn_seekbar);
        this.nMP.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nQF.getStreamVolume(3);
        this.nMP.setProgress(Ni(streamVolume));
        x(Ni(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.nQo.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.nJZ = new d.a();
            this.c = new GestureDetector(this.nQD, this.nJZ);
        }
    }

    private void eaa() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.nMb == null) {
                this.nMb = ((Activity) this.nQD).getWindow();
            }
            this.nMc = this.nMb.getAttributes();
            this.nMa = ((VideoPlayer) this.nQD).k / 255.0f;
            ((VerticalSeekBarVolumn) this.nQo.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.nMa));
        }
    }

    private void aG() {
        this.nQo.findViewById(a.f.btn_send).setOnClickListener(this);
        this.nQo.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nQD.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.nQo.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.nMo == null) {
            this.nMo = (EditText) this.nQo.findViewById(a.f.et_input);
            this.nMo.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.nQo.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZx() {
        if (this.nMz != null) {
            this.nMz.dismiss();
            this.nMz = null;
        }
        if (this.nQD != null) {
            ((VideoPlayer) this.nQD).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nKv = this.nQo.findViewById(a.f.topview);
        this.nMh = (LinearLayout) this.nQo.findViewById(a.f.topRight);
        this.nMe = this.nKv.findViewById(a.f.rl_download);
        this.nMf = this.nQo.findViewById(a.f.topKeyboardView);
        this.nQo.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nKv.getVisibility() == 0;
        if (this.nMt > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nKv.getLayoutParams();
            layoutParams.topMargin = this.nMt;
            this.nKv.setLayoutParams(layoutParams);
        }
        this.nQo.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.nQo.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                str = this.nQC.dZl().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.nQo.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.nMw = (ImageView) this.nQo.findViewById(a.f.subscribe_icon);
        this.nMw.setOnClickListener(this);
        this.nMy = (ImageView) this.nQo.findViewById(a.f.report_icon);
        this.nMy.setOnClickListener(this);
        q();
    }

    private void dZy() {
        boolean z;
        this.nMd = this.nQo.findViewById(a.f.bottomview);
        this.nMj = (ImageButton) this.nMd.findViewById(a.f.playbutton);
        this.nMj.setOnTouchListener(this);
        this.nQu = (ImageButton) this.nQo.findViewById(a.f.btn_barrage);
        this.nQv = (ImageButton) this.nQo.findViewById(a.f.btn_audio);
        this.nMr = (ImageView) this.nQo.findViewById(a.f.iv_danmu);
        if (!this.nQK.equals("3")) {
            this.nMd.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.nMd.findViewById(a.f.btn_refresh).setVisibility(0);
            this.nQu.setVisibility(0);
            this.nMr.setVisibility(8);
            if (this.nQC != null && this.nQC.f != null) {
                for (int i = 0; i < this.nQC.f.size(); i++) {
                    if ("2".equals(this.nQC.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.nQv.setVisibility(0);
            } else {
                this.nQv.setVisibility(8);
            }
            this.nMd.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.nQu.setOnClickListener(this);
            if (h.dYA().e) {
                this.nQu.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nQu.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.nQC.d) {
                this.nQv.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.nQv.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.nQv.setOnClickListener(this);
            this.nKA = (ImageView) this.nMd.findViewById(a.f.btn_hotword);
            this.nMi = (ImageView) this.nQo.findViewById(a.f.iv_task_badge);
            this.nKA.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nQD, a.C0882a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dYA().c) {
                        b.this.nKA.clearAnimation();
                        b.this.nKA.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nKA.clearAnimation();
            if (h.dYA().c) {
                this.nKA.startAnimation(animationSet);
                this.nMi.setVisibility(0);
            }
        } else {
            this.nMd.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.nMd.findViewById(a.f.btn_refresh).setVisibility(8);
            this.nQu.setVisibility(8);
            this.nQv.setVisibility(8);
            this.nMr.setVisibility(0);
            this.nMr.setOnClickListener(this);
            if (h.dYA().b) {
                this.nMr.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nMr.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.nMd.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nQD != null) {
            ((VideoPlayer) this.nQD).e(true);
        }
        if (this.nQE != null) {
            this.nQE.cl(null);
            this.nQE = null;
        }
        this.c = null;
        this.nJZ = null;
        this.nMp = null;
        if (this.nMo != null) {
            this.nMo.addTextChangedListener(null);
            this.nMo.setOnEditorActionListener(null);
            this.nMo = null;
        }
        this.nKv = null;
        this.nQu = null;
        this.nQv = null;
        this.nMd = null;
        this.nMg = null;
        if (this.nME != null) {
            this.nME.a();
            this.nME = null;
            this.nMF = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dZQ() {
        return this.nME;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.nQo == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.nRv == null || !this.nRv.a(i, keyEvent)) {
                    if ((this.nMD == null || !this.nMD.onKeyDown(i, keyEvent)) && !dZH() && !dZw()) {
                        if (this.nMf != null && this.nMf.getVisibility() == 0) {
                            aE(false, true);
                            return true;
                        } else if (this.nMq != null && this.nMq.isShown()) {
                            aB();
                            return true;
                        } else if (this.nMs && this.nQE != null) {
                            if (this.nMp != null) {
                                this.nMp.setVisibility(0);
                            }
                            this.nQE.removeMessages(2);
                            this.nQE.B(2, IMConnection.RETRY_DELAY_TIMES);
                            return true;
                        } else {
                            dZx();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.nQo.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.nQo.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nQE != null) {
                    this.nQE.removeMessages(3);
                    this.nQE.B(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean eab() {
        if (this.nMs) {
            this.nMp.setVisibility(0);
            this.nQE.removeMessages(2);
            this.nQE.B(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.nMs;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.nMs) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.nMp.setVisibility(0);
            this.nQE.removeMessages(2);
            this.nQE.B(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.c(this.nQD, getString(a.i.STR_VP_SCREEN_LOCK));
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
            o(view, 0, this.nKv.getHeight() + this.nKv.getTop());
        } else if (id == a.f.btn_send) {
            if (this.nQK.equals("3")) {
                String trim = this.nMo.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.H(this.nQD, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.nMo.setText((CharSequence) null);
                aE(false, true);
            } else if (a(this.nMo.getText().toString(), false)) {
                aE(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.hb(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.nQD, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dZx();
            com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = eai() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.nRj == null;
                b(false, false);
                if (z && this.bV > 0 && this.nRj != null && tv.chushou.zues.utils.systemBar.b.az(getActivity()) && tv.chushou.zues.utils.systemBar.b.aA(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nRj.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.nRj.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.nRj == null;
                if (this.nQD.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.nRj != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nRj.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.nRj.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQC.dZl().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aE(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aF(false, false);
            this.nQE.B(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dYA().c) {
                h.dYA().b(false);
                this.nKA.clearAnimation();
                this.nMi.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.nMd.findViewById(a.f.ll_keyboard).getLeft(), this.nMd.getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
            } else {
                m(view, this.nMd.findViewById(a.f.ll_keyboard).getLeft(), this.nMd.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                tv.chushou.zues.utils.g.c(this.nQD, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.nQD, eai(), false);
        } else if (id == a.f.btn_screenChange) {
            dZx();
        } else if (id == a.f.rl_paoicon) {
            dZu();
        } else if (id == a.f.subscribe_icon) {
            dZD();
        } else if (id == a.f.report_icon) {
            if (this.nQK.equals("3")) {
                dZG();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dZE();
            }
        } else if (id == a.f.btn_audio && !this.nQC.d) {
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
        } else if (System.currentTimeMillis() - this.nMu <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.OF(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dYA().e) {
                s(true);
                ve();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
            if (com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a(((VideoPlayer) this.nQD).dYM().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.nMu = System.currentTimeMillis();
                a(this.nQC.dZl().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nQC.h);
                if (!z) {
                    this.nMo.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.nQK.equals("3")) {
            if (this.nQu != null) {
                if (z) {
                    this.nQu.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nQu.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.nMr != null) {
            if (z) {
                this.nMr.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nMr.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dZF() {
        if (this.nQo == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nQo.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.nRr != null) {
            this.nRr.setVisibility(z ? 0 : 8);
            if (!z) {
                this.nRr.elE();
            }
        }
        tv.chushou.zues.utils.g.y(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.nQC.d()) {
            if (this.nMs) {
                this.nMp.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nQD, this.nQD.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.nMp.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nQD, this.nQD.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.nMs = !this.nMs;
            if (this.nMo != null) {
                this.nMo.setEnabled(this.nMs ? false : true);
            }
        }
    }

    public void aE(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dM(this.nMo);
            this.nMo.setText("");
            this.nMg.setVisibility(8);
            this.nMp.setVisibility(8);
            this.nKv.setVisibility(8);
            this.nMd.setVisibility(8);
            this.nMf.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
        if (this.nMf.getVisibility() != 8 && z2) {
            this.nMf.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_top_anim));
        }
        this.nMg.setVisibility(8);
        this.nMp.setVisibility(8);
        this.nKv.setVisibility(8);
        this.nMd.setVisibility(8);
        this.nMf.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aF(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.nMh != null) {
            this.nMh.setVisibility(z ? 0 : 4);
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
            if (this.nMB != null) {
                this.nMB.a(this.e);
            }
            return this.e;
        }
        if (this.nQE != null) {
            this.nQE.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nQD).e(true);
            if (!z3) {
                if (this.nMd.getVisibility() != 0 && z2) {
                    this.nMd.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_bottom_anim));
                }
                this.nMd.setVisibility(0);
                this.nMg.setVisibility(0);
                this.nMp.setVisibility(0);
                this.nMe.setVisibility(o() ? 0 : 8);
            }
            if (this.nKv.getVisibility() != 0 && z2) {
                this.nKv.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_top_anim));
            }
            u(!z3);
            this.nKv.setVisibility(0);
            if (this.nQE != null) {
                this.nQE.B(1, 5000L);
            }
            y(false);
            if (this.nMB != null) {
                this.nMB.a(true);
            }
        } else {
            ((VideoPlayer) this.nQD).e(false);
            if (this.nQW != null) {
                this.nQW.dismiss();
            }
            if (this.nQX != null) {
                this.nQX.dismiss();
            }
            if (this.nRe != null) {
                this.nRe.dismiss();
            }
            if (this.nMd != null) {
                if (this.nMd.getVisibility() != 8 && z2) {
                    this.nMd.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_bottom_anim));
                }
                this.nMd.setVisibility(8);
            }
            if (this.nMg != null) {
                this.nMg.setVisibility(8);
                if (this.nKv.getVisibility() != 8 && z2) {
                    this.nKv.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_top_anim));
                }
                this.nKv.setVisibility(8);
                this.nMp.setVisibility(8);
                y(true);
                a(false);
                if (this.nMB != null) {
                    this.nMB.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dZA() {
        Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
        if (this.ap == 1) {
            this.ar = Math.min(gW.x, gW.y);
            this.aq = Math.max(gW.x, gW.y);
        } else {
            this.ar = Math.max(gW.x, gW.y);
            this.aq = Math.min(gW.x, gW.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.nLY == null) {
            this.nLY = new Rect(0, 0, i / 5, i2);
        } else {
            this.nLY.set(0, 0, i / 5, i2);
        }
        if (this.nLZ == null) {
            this.nLZ = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.nLZ.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.nLY == null) {
            return false;
        }
        return this.nLY.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.nQo.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nQo.findViewById(a.f.brightness_view);
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
        if (this.nLZ == null) {
            return false;
        }
        return this.nLZ.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.nQo.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nQo.findViewById(a.f.volumn_view);
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
                if (this.nMs) {
                    this.nMp.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.nMs) {
                    this.nQE.removeMessages(2);
                    this.nQE.B(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.nQE != null) {
                    this.nQE.B(3, 1000L);
                    this.nQE.B(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.nMs) {
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
        int streamMaxVolume = (this.nQF.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Ni(int i) {
        int streamMaxVolume = (i * 10) / this.nQF.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.nQo.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.nQo.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.nQD != null && (this.nQD instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nQD).a(1, null, this.H, false, false, true);
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
            b.this.nQF.setStreamVolume(3, b.this.fX(i), 0);
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
            b.this.nMa = i / 10.0f;
            ((VideoPlayer) b.this.nQD).l = b.this.nMa;
            ((VideoPlayer) b.this.nQD).k = b.this.nMa * 255.0f;
            b.this.nMc.screenBrightness = b.this.nMa;
            b.this.nMb.setAttributes(b.this.nMc);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.nQo.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (an(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.nQo.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.nQI > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.nKc.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.nQo.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.nQo.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nMV.getCurrentPos();
                            int duration = this.nMV.getDuration();
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
                                this.nKc.setProgress(i3 / (duration / 1000));
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
            if (this.nMf.getVisibility() == 8 && (this.nMq == null || !this.nMq.isShown())) {
                boolean z = this.nQx != null && this.nQx.getVisibility() == 0;
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

    public boolean dZw() {
        if (this.bB) {
            if (this.nRj != null) {
                this.nRj.e();
            }
            y(false);
            if (this.nMd != null) {
                this.nMd.setVisibility(0);
            }
            if (this.nKv != null) {
                this.nKv.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.nQD instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.nQC != null) {
            this.nQC.f = null;
            if (this.nQC.dZl() != null) {
                this.nQC.dZl().mRoominfo.mGameId = null;
            }
        }
        if (this.nQK.equals("3")) {
            if (this.nMV != null) {
                this.nMV.seekTo(0L);
                e(true);
            }
            dZx();
            return;
        }
        dZx();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.nMs) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                tv.chushou.zues.utils.g.c(this.nQD, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nMV.getPlayState() == 4) {
                        dZB();
                        e(true);
                    } else {
                        if (this.nMH != null) {
                            this.nMH.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.nQC.a(false);
                            ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
                        } else if (!this.nQK.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                        } else if (this.nMV.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nMV.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nMV.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            yy(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nMV.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nMV.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                tv.chushou.zues.utils.g.c(this.nQD, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.nQC.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
                } else if (!this.nQK.equals("3")) {
                    ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                    this.ai = false;
                    yy(true);
                    a(false, !this.ak);
                } else if (this.nMV.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                    this.ai = false;
                    yy(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void dZB() {
        String str = null;
        if (!this.nQK.equals("3")) {
            if (this.nQC != null && this.nQC.dZn() != null) {
                str = this.nQC.dZn().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dYt().nHu != null && com.kascend.chushou.a.a.dYt().nHu.contains(str) && this.nQC != null && !this.nMQ) {
            this.nMQ = true;
            com.kascend.chushou.a.a.dYt().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.nMQ = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.nMH != null) {
            this.nMH.a(listItem, this.ap == 1, a.C0882a.zues_sweetalert_modal_in, a.C0882a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.nMQ = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nMj != null) {
                this.nMj.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nQx != null) {
                this.nQx.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nMj != null) {
            this.nMj.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nQx != null) {
                    this.nQx.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dZC() {
        this.nQp = new SurfaceView(this.nQD);
        SurfaceView surfaceView = (SurfaceView) this.nQp;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.nQo).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void dZL() {
        if (this.nRr != null) {
            this.nRr.elE();
            this.nRr.setVisibility(8);
            this.nRr.unInit();
            ((RelativeLayout) this.nQo).removeView(this.nRr);
            this.nRr = null;
        }
        if (this.nQp != null) {
            this.nQp.setVisibility(8);
            ((RelativeLayout) this.nQo).removeView(this.nQp);
            this.nQp = null;
        }
        dZC();
        ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.nQE != null) {
            y(true);
            this.nQE.removeMessages(1);
            this.nMd.setVisibility(0);
            this.nMg.setVisibility(8);
            this.nKv.setVisibility(8);
            this.nMp.setVisibility(8);
        }
        if (this.nRe == null) {
            al();
            this.nRe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nKA.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.nRe.isShowing()) {
            this.nRe.showAtLocation(view, 83, i, i2);
            this.nKA.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nQC.dZl().mRoominfo.mRoomID);
            return;
        }
        this.nRe.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nMD != null && this.nMD.b()) {
                this.nMD.getGlobalVisibleRect(this.nMR);
                if (!this.nMR.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.nMD.a();
                    return true;
                }
            }
            if (this.bB && f(this.nRj.b, motionEvent)) {
                dZw();
                return true;
            }
            if (!eab()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.nMH != null && this.nMH.isShown()) {
                    this.nMH.a();
                    if (this.nMV.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.nQC.a(false);
                            ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
                        } else if (!this.nQK.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                        } else if (this.nMV.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nQD).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nMV.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nMV.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            yy(true);
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
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
        if (this.nMq != null) {
            if (this.nMq.isShown()) {
                this.nMq.startAnimation(AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_top_anim));
            }
            this.nMq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nQD).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nQD).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.nQv != null) {
                this.nQv.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hc(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nMg.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.nMg.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nKv.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nKv.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nMf.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.nMf.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nMd.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.nMd.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
            this.nMw.setVisibility(0);
            if (this.nQC.dZl().mRoominfo.mIsSubscribed) {
                this.nMw.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.nMw.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.nMw.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dZD() {
        RoomInfo roomInfo;
        if (this.nQC != null && this.nQC.dZl() != null && (roomInfo = this.nQC.dZl().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nQD, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.emV();
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
        if (this.nQC != null && this.nQC.dZl() != null && (roomInfo = this.nQC.dZl().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.H(b.this.nQD, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.H(b.this.nQD, a.i.subscribe_success);
                            }
                            if (b.this.nQC != null && b.this.nQC.dZl() != null && (roomInfo2 = b.this.nQC.dZl().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.nQD, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nQD, str2);
                    }
                }
            };
            if (this.nQC != null && this.nQC.h != null) {
                try {
                    str = new JSONObject(this.nQC.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dYv().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dYv().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.nMx == null) {
                this.nMx = new ProgressDialog(this.nQD);
                this.nMx.setProgressStyle(0);
                this.nMx.requestWindowFeature(1);
                this.nMx.setMessage(this.nQD.getText(a.i.update_userinfo_ing));
                this.nMx.setCancelable(true);
            }
            if (!this.nMx.isShowing()) {
                this.nMx.show();
            }
        } else if (this.nMx != null && this.nMx.isShowing()) {
            this.nMx.dismiss();
        }
    }

    private void dZE() {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
            if (this.nMz == null) {
                this.nMz = new f(getActivity());
            }
            this.nMz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.nMz = null;
                }
            });
            RoomInfo roomInfo = this.nQC.dZl().mRoominfo;
            this.nMz.a();
            this.nMz.a(roomInfo);
            if (!this.nMz.isShowing()) {
                this.nMz.show();
            }
        }
    }

    private void dZG() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.nMP != null && this.nQF != null && this.nQD != null && (this.nQD instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.nMP;
            VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
            verticalSeekBarVolumn.setProgressOnly(Ni(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.nKd != null) {
            this.nKd.emx();
        }
        if (this.nQo != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.nMB == null) {
                this.nMB = new com.kascend.chushou.player.ui.giftpopup.a(this.nQo, i);
            } else if (this.nMB.a() != i) {
                this.nMB.b();
                this.nMB = null;
                this.nMB = new com.kascend.chushou.player.ui.giftpopup.a(this.nQo, i);
            }
            List<ListItem> j = this.nQC != null ? this.nQC.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
            if (videoPlayer != null) {
                this.nMB.a(j, videoPlayer.dYS(), videoPlayer.dYT(), videoPlayer.dYU(), videoPlayer.dYV());
                this.nMB.a(this.e);
                if (this.nQC != null && this.nQC.nJJ != null) {
                    this.nMB.a(this.nQC.nJJ, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.nQC != null) {
                                b.this.nQC.nJJ = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.nMB != null && this.nQC != null) {
                    this.nMB.b(this.nQC.nJM);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nMB != null && this.nQD != null) {
            this.nMB.a(((VideoPlayer) this.nQD).dYS());
            this.nMB.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQD instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dYS = ((VideoPlayer) this.nQD).dYS();
            if (this.nRv == null) {
                this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRv.setVisibility(0);
            this.nRv.a(i, dYS);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.nMB != null) {
            this.nMB.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.nMm != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.nMm.setVisibility(0);
                    this.nMm.bX(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.nMm.setVisibility(8);
                }
            }
            if (this.nMk != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.nMl.setVisibility(0);
                    this.nMk.bX(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.nMl.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nMB != null) {
            this.nMB.a(((VideoPlayer) this.nQD).dYT());
            this.nMB.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nMB != null) {
            this.nMB.a(((VideoPlayer) this.nQD).dYT());
            this.nMB.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nMB != null) {
            this.nMB.a(((VideoPlayer) this.nQD).dYU());
            this.nMB.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nMB != null) {
            this.nMB.a(((VideoPlayer) this.nQD).dYV());
            this.nMB.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        yx(false);
        super.F();
    }

    private void c(View view) {
        this.nMI = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nLd = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nLd.setText(new tv.chushou.zues.widget.a.c().L(this.nQD, a.e.videoplayer_4g_video).append("  ").append(this.nQD.getString(a.i.videoplayer_4g_video)));
        this.nMJ = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nMJ.setText(new tv.chushou.zues.widget.a.c().L(this.nQD, a.e.videoplayer_4g_audio).append("  ").append(this.nQD.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dZx();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nQD, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.nMI.setVisibility(8);
                    ((VideoPlayer) b.this.nQD).c(b.this.nLf);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.nMI.setVisibility(8);
                    ((VideoPlayer) b.this.nQD).d(b.this.nLf);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
        findViewById.setLayoutParams(layoutParams);
        this.nLd.setOnClickListener(onClickListener);
        this.nMJ.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nQC != null && !tv.chushou.zues.utils.h.isEmpty(this.nQC.f)) {
            f(this.nQC.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nLf = z;
            this.p = false;
            if (this.nQC != null && this.nQC.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nQC.f.size()) {
                        break;
                    } else if (!"2".equals(this.nQC.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nMI != null) {
                this.nMI.setVisibility(0);
                this.nLd.setVisibility(0);
                this.nMJ.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nMI != null) {
            this.nMI.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nMB != null && this.nQC != null) {
            this.nMB.b(this.nQC.nJM);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.nQo != null && (findViewById = this.nQo.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nMk != null) {
            this.nMk.performClick();
        }
    }
}
