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
    private TextView nUY;
    private boolean nVa;
    private GiftAnimationLayout nWA;
    private ImageView nWB;
    private FoodView nWC;
    private RelativeLayout nWD;
    private TextView nWE;
    private VerticalSeekBarVolumn nWK;
    private LinearLayout nWc;
    private FrameLayout nWg;
    private FrescoThumbnailView nWh;
    private ImageView nWk;
    private ImageView nWm;
    RelativeLayout nWq;
    private ImageView nWr;
    private ImageView nWt;
    private f nWu;
    private com.kascend.chushou.player.ui.giftpopup.a nWw;
    private PopH5Menu nWy;
    private com.kascend.chushou.player.b.a nWz;
    private Rect nVT = null;
    private Rect nVU = null;
    private float nVV = 0.0f;
    private Window nVW = null;
    private WindowManager.LayoutParams nVX = null;
    private boolean bB = false;
    private View nVY = null;
    private View nUq = null;
    private View nVZ = null;
    private View nWa = null;
    private View nWb = null;
    private ImageView nUv = null;
    private ImageView nWd = null;
    private ImageButton nWe = null;
    private FrescoThumbnailView nWf = null;
    private LinearLayout nWi = null;
    private EditText nWj = null;
    private View nWl = null;
    private boolean nWn = false;
    private int nWo = 0;
    private int bV = 0;
    private long nWp = 0;
    private ProgressDialog nWs = null;
    private boolean nWv = true;
    private int nWx = -1;
    private boolean nWF = false;
    private TextView nWG = null;
    private TextView nWH = null;
    private int nWI = 0;
    private boolean nWJ = false;
    private boolean nWL = false;
    private final Rect nWM = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.oaE = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.nTY = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.oaj = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.oay != null && !((Activity) this.oay).isFinishing()) {
            edW();
        }
        return this.oaj;
    }

    public void eds() {
        aH(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.oay, "能量_num", "横屏", new Object[0]);
    }

    public boolean edF() {
        if (this.obh == null || !this.obh.isShown()) {
            return false;
        }
        this.obh.d();
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
        if (z3 || this.oaj.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.oaE)) {
            z = h.ecy().e;
        } else {
            z = h.ecy().b;
        }
        r(z);
        if (this.obd != null) {
            this.obd.b();
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
        if (this.nWw != null) {
            this.nWw.b();
            this.nWw = null;
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
            edy();
            y();
            if (this.nTY != null) {
                this.nTY.onConfigurationChanged(configuration);
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
        if (this.nWy != null && this.nWx != i3) {
            this.nWy.a();
            this.nWy = null;
        }
        if (this.nWy == null) {
            this.nWy = (PopH5Menu) ((ViewStub) this.oaj.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nWy.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.nWy.setLayoutParams(layoutParams);
            this.nWx = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.nWy.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.oay instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b ecR = ((VideoPlayer) this.oay).ecR();
                    if (this.obq == null) {
                        this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.obq.setVisibility(0);
                    this.obq.a(i, ecR);
                }
            } else if (bVar.a == 3) {
                if (this.oay instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a ecS = ((VideoPlayer) this.oay).ecS();
                    if (this.obq == null) {
                        this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.obq.setVisibility(0);
                    this.obq.a(i, ecS);
                }
            } else if (bVar.a == 9) {
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo edl;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.oax != null && mVar.b.equals(this.oax.a) && (edl = this.oax.edl()) != null) {
            edl.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void edW() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.oaE)) {
            this.oaE = "1";
        }
        this.nWo = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
        this.bV = tv.chushou.zues.utils.systemBar.b.hh(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nWQ = ((VideoPlayer) this.oay).ecH();
        this.oax = ((VideoPlayer) this.oay).ecK();
        c(this.oaj);
        if (this.oaE.equals("1")) {
            this.nTW = ((VideoPlayer) this.oay).ecL();
            this.nTW.a(this);
            if (this.nWz != null) {
                this.nWz.a();
                this.nWz = null;
                this.nWA = null;
            }
            this.nWA = (GiftAnimationLayout) this.oaj.findViewById(a.f.ll_gift_animation);
            this.nWA.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.oax != null) {
                this.nWz = new com.kascend.chushou.player.b.a(this.oay.getApplicationContext(), this.nWA);
                this.nWz.a(this.oax);
            }
            this.B = (TextView) this.oaj.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.oaE.equals("3")) {
        }
        edA();
        if (this.nTW != null) {
            this.nTW.d();
        }
        edS();
        this.nWk = (ImageView) this.oaj.findViewById(a.f.btn_lockscreen);
        this.nWk.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.oaj.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.oas = (PlayerErrorView) this.oaj.findViewById(a.f.view_net_error_msg);
        this.oas.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        dQK();
        this.obh = (PaoGuideView) this.oaj.findViewById(a.f.rlPaoGuideView);
        this.nWB = (ImageView) this.oaj.findViewById(a.f.iv_send_danmu);
        this.nWb = this.oaj.findViewById(a.f.rt_layout);
        this.nWf = (FrescoThumbnailView) this.nWb.findViewById(a.f.btn_gift);
        this.nWg = (FrameLayout) this.nWb.findViewById(a.f.flfl_bottom_gift);
        this.nWh = (FrescoThumbnailView) this.nWb.findViewById(a.f.btn_recharge);
        this.nWh.setOnClickListener(this);
        a(this.oax == null ? null : this.oax.nTG);
        this.obo = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.oaz != null) {
                    b.this.oaz.removeMessages(1);
                    b.this.oaz.C(1, 5000L);
                }
                b.this.nWk.setVisibility(0);
                b.this.nWb.setVisibility(0);
                b.this.nUq.setVisibility(0);
                b.this.nVY.setVisibility(0);
                if (b.this.nWw != null) {
                    b.this.nWw.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.oay, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.nWk.setVisibility(8);
                b.this.nWb.setVisibility(8);
                if (b.this.nWw != null) {
                    b.this.nWw.a(false);
                }
                b.this.nUq.setVisibility(8);
                b.this.nVY.setVisibility(8);
                if (b.this.oaz != null) {
                    b.this.oaz.removeMessages(1);
                }
                if (b.this.obd != null) {
                    b.this.obd.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.oay, 14.0f) + b.this.obd.getMeasuredHeight(), 12);
                }
            }
        };
        this.nWi = (LinearLayout) this.oaj.findViewById(a.f.rl_seekbar);
        this.nWq = (RelativeLayout) this.oaj.findViewById(a.f.rl_paoicon);
        this.nWq.setOnClickListener(this);
        this.obe = (RoundProgressBar) this.oaj.findViewById(a.f.roundProgressBar);
        this.obg = (FrescoThumbnailView) this.oaj.findViewById(a.f.iv_paoicon);
        this.obf = (TextView) this.oaj.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.obi = 0L;
        com.kascend.chushou.player.ui.a.a ecU = ((VideoPlayer) this.oay).ecU();
        a(ecU.eeo());
        BangInfo eep = ecU.eep();
        if (eep != null) {
            a(eep, ecU.d());
        }
        if (this.oaE.equals("3")) {
            this.nWi.setVisibility(0);
            this.nWg.setVisibility(8);
            this.nWB.setVisibility(0);
            this.nWB.setOnClickListener(this);
        } else {
            this.nWB.setVisibility(8);
            this.nWi.setVisibility(8);
            this.nWg.setVisibility(0);
            this.nWf.setOnClickListener(this);
        }
        edw();
        if (tv.chushou.zues.utils.systemBar.b.hi(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nWb.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.nWb.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nUq.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nUq.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nWa.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.nWa.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nVY.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.nVY.setLayoutParams(layoutParams4);
        }
        edY();
        aG();
        edy();
        this.h = (TextView) this.oaj.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.oaj.findViewById(a.f.time_seekbar_relative);
        if (!this.oaE.equals("3")) {
            if (this.oax.edj() != null) {
                this.nWt.setVisibility(0);
            } else {
                this.nWt.setVisibility(8);
            }
        }
        edX();
        n();
        k(100);
        this.nWC = (FoodView) this.oaj.findViewById(a.f.kav_room_ad);
        this.oaz = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aH(false, true);
                            break;
                        case 2:
                            b.this.oaz.removeMessages(2);
                            if (b.this.nWk != null) {
                                b.this.nWk.setVisibility(8);
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
                            TextView textView = (TextView) b.this.oaj.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.oay.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.oaz.C(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.oaz.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.oaz.C(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aG(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.oay).q) {
                                b.this.a(b.this.oaz);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.oay).q) {
                                b.this.b(b.this.oaz);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.oay).g = true;
                            b.this.nWQ.seekTo((int) b.this.nqu);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.oax.d()) {
                                b.this.nWQ.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nWQ.getPlayState() == 4) {
                                int currentPos = b.this.nWQ.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.oaz != null) {
                                    b.this.oaz.C(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.eej();
                            break;
                        case 18:
                            b.this.aq();
                            break;
                        case 19:
                            b.this.oaw.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.oax != null) {
            a(this.oax.edk());
        }
        if (this.nWQ != null && (this.nWQ.getPlayState() == 3 || this.nWQ.getPlayState() == 4)) {
            yF(false);
            if (this.oax.d()) {
                this.ak = false;
                yG(true);
                if (this.nWQ.getDuration() > 60000) {
                    if (this.nWQ.getDuration() < 300000) {
                        this.oaC = 60000;
                    } else {
                        this.oaC = Math.min(this.nWQ.getDuration(), 300000);
                    }
                } else {
                    this.oaC = this.nWQ.getDuration();
                }
            }
            this.e = false;
            aH(true, false);
            this.oaz.Pb(8);
            if (h() && this.nWQ.getPlayState() == 4 && this.oaz != null) {
                this.oaz.removeMessages(15);
                this.oaz.Pb(15);
            }
        } else {
            yF(true);
            if (this.e) {
                aH(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] ecx = g.ecx();
            int i = ecx.length == 2 ? ecx[1] : 0;
            if (i > 0) {
                View findViewById = this.oaj.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.oay, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.oaj.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.oay, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.oay, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.oay != null && (this.oay instanceof VideoPlayer)) {
            ((VideoPlayer) this.oay).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.nWh.CL(a.e.ic_recharge_old);
            this.nWf.CL(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.nWF && !this.k) {
            try {
                if (this.nWQ != null) {
                    i = this.nWQ.getCurrentPos();
                    i2 = this.nWQ.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nTX.setProgress(i / (i2 / 1000));
                    this.nWG.setText(tv.chushou.zues.utils.b.q(this.nWQ.getDuration(), false));
                    this.nWH.setText(tv.chushou.zues.utils.b.q(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void edX() {
        this.nTX = (ProgressBar) this.oaj.findViewById(a.f.progressBarl);
        if (this.nTX != null) {
            if (this.nTX instanceof SeekBar) {
                ((SeekBar) this.nTX).setOnSeekBarChangeListener(new C0886b());
            }
            this.nTX.setMax(1000);
        }
        this.nWG = (TextView) this.oaj.findViewById(a.f.tv_time_duration);
        this.nWH = (TextView) this.oaj.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.oaj.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.oaj.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a ecU;
        BangInfo eep;
        if (config != null) {
            this.obl = config;
            if (!config.display) {
                this.nWq.setVisibility(8);
            } else if ((this.oay instanceof VideoPlayer) && (eep = (ecU = ((VideoPlayer) this.oay).ecU()).eep()) != null) {
                a(eep, ecU.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.obl == null || this.obl.display) && this.nWq != null) {
            this.nWq.setVisibility(0);
            this.obf.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.oay instanceof VideoPlayer) {
            if ((this.obl == null || this.obl.display) && this.nWq != null) {
                if (j > 0) {
                    this.nWq.setVisibility(0);
                    boolean z = this.obk;
                    this.obk = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.oay.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.obf.setText(cVar);
                    return;
                }
                this.obk = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0886b implements SeekBar.OnSeekBarChangeListener {
        C0886b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.oak != null) {
                if (b.this.nWI != i || b.this.nWJ != z) {
                    b.this.nWI = i;
                    b.this.nWJ = z;
                    if (z) {
                        if (b.this.nWF) {
                            b.this.nqu = (b.this.nWQ.getDuration() / 1000) * i;
                        }
                        b.this.nWH.setText(tv.chushou.zues.utils.b.q((int) b.this.nqu, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.q((int) b.this.nqu, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.q(((int) b.this.nqu) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.nWF = true;
            b.this.m = b.this.nWQ.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.oaz != null) {
                if (b.this.nWF) {
                    b.this.nWF = false;
                }
                b.this.oaz.removeMessages(14);
                b.this.oaz.Pb(14);
            }
        }
    }

    private void k(int i) {
        this.nTX.setSecondaryProgress((i * 1000) / 100);
    }

    private void edS() {
        this.nWK = (VerticalSeekBarVolumn) this.oaj.findViewById(a.f.volumn_seekbar);
        this.nWK.setOnSeekBarChangeListener(new c());
        int streamVolume = this.oaA.getStreamVolume(3);
        this.nWK.setProgress(NN(streamVolume));
        x(NN(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.oaj.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.nTU = new d.a();
            this.c = new GestureDetector(this.oay, this.nTU);
        }
    }

    private void edY() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.nVW == null) {
                this.nVW = ((Activity) this.oay).getWindow();
            }
            this.nVX = this.nVW.getAttributes();
            this.nVV = ((VideoPlayer) this.oay).k / 255.0f;
            ((VerticalSeekBarVolumn) this.oaj.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.nVV));
        }
    }

    private void aG() {
        this.oaj.findViewById(a.f.btn_send).setOnClickListener(this);
        this.oaj.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.oay.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.oaj.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.nWj == null) {
            this.nWj = (EditText) this.oaj.findViewById(a.f.et_input);
            this.nWj.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.oaj.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edv() {
        if (this.nWu != null) {
            this.nWu.dismiss();
            this.nWu = null;
        }
        if (this.oay != null) {
            ((VideoPlayer) this.oay).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nUq = this.oaj.findViewById(a.f.topview);
        this.nWc = (LinearLayout) this.oaj.findViewById(a.f.topRight);
        this.nVZ = this.nUq.findViewById(a.f.rl_download);
        this.nWa = this.oaj.findViewById(a.f.topKeyboardView);
        this.oaj.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nUq.getVisibility() == 0;
        if (this.nWo > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nUq.getLayoutParams();
            layoutParams.topMargin = this.nWo;
            this.nUq.setLayoutParams(layoutParams);
        }
        this.oaj.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.oaj.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                str = this.oax.edj().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.oaj.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.nWr = (ImageView) this.oaj.findViewById(a.f.subscribe_icon);
        this.nWr.setOnClickListener(this);
        this.nWt = (ImageView) this.oaj.findViewById(a.f.report_icon);
        this.nWt.setOnClickListener(this);
        q();
    }

    private void edw() {
        boolean z;
        this.nVY = this.oaj.findViewById(a.f.bottomview);
        this.nWe = (ImageButton) this.nVY.findViewById(a.f.playbutton);
        this.nWe.setOnTouchListener(this);
        this.oap = (ImageButton) this.oaj.findViewById(a.f.btn_barrage);
        this.oaq = (ImageButton) this.oaj.findViewById(a.f.btn_audio);
        this.nWm = (ImageView) this.oaj.findViewById(a.f.iv_danmu);
        if (!this.oaE.equals("3")) {
            this.nVY.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.nVY.findViewById(a.f.btn_refresh).setVisibility(0);
            this.oap.setVisibility(0);
            this.nWm.setVisibility(8);
            if (this.oax != null && this.oax.f != null) {
                for (int i = 0; i < this.oax.f.size(); i++) {
                    if ("2".equals(this.oax.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.oaq.setVisibility(0);
            } else {
                this.oaq.setVisibility(8);
            }
            this.nVY.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.oap.setOnClickListener(this);
            if (h.ecy().e) {
                this.oap.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.oap.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.oax.d) {
                this.oaq.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.oaq.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.oaq.setOnClickListener(this);
            this.nUv = (ImageView) this.nVY.findViewById(a.f.btn_hotword);
            this.nWd = (ImageView) this.oaj.findViewById(a.f.iv_task_badge);
            this.nUv.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.oay, a.C0879a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.ecy().c) {
                        b.this.nUv.clearAnimation();
                        b.this.nUv.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nUv.clearAnimation();
            if (h.ecy().c) {
                this.nUv.startAnimation(animationSet);
                this.nWd.setVisibility(0);
            }
        } else {
            this.nVY.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.nVY.findViewById(a.f.btn_refresh).setVisibility(8);
            this.oap.setVisibility(8);
            this.oaq.setVisibility(8);
            this.nWm.setVisibility(0);
            this.nWm.setOnClickListener(this);
            if (h.ecy().b) {
                this.nWm.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nWm.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.nVY.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.oay != null) {
            ((VideoPlayer) this.oay).e(true);
        }
        if (this.oaz != null) {
            this.oaz.cl(null);
            this.oaz = null;
        }
        this.c = null;
        this.nTU = null;
        this.nWk = null;
        if (this.nWj != null) {
            this.nWj.addTextChangedListener(null);
            this.nWj.setOnEditorActionListener(null);
            this.nWj = null;
        }
        this.nUq = null;
        this.oap = null;
        this.oaq = null;
        this.nVY = null;
        this.nWb = null;
        if (this.nWz != null) {
            this.nWz.a();
            this.nWz = null;
            this.nWA = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a edO() {
        return this.nWz;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.oaj == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.obq == null || !this.obq.a(i, keyEvent)) {
                    if ((this.nWy == null || !this.nWy.onKeyDown(i, keyEvent)) && !edF() && !edu()) {
                        if (this.nWa != null && this.nWa.getVisibility() == 0) {
                            aG(false, true);
                            return true;
                        } else if (this.nWl != null && this.nWl.isShown()) {
                            aB();
                            return true;
                        } else if (this.nWn && this.oaz != null) {
                            if (this.nWk != null) {
                                this.nWk.setVisibility(0);
                            }
                            this.oaz.removeMessages(2);
                            this.oaz.C(2, IMConnection.RETRY_DELAY_TIMES);
                            return true;
                        } else {
                            edv();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.oaj.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.oaj.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.oaz != null) {
                    this.oaz.removeMessages(3);
                    this.oaz.C(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean edZ() {
        if (this.nWn) {
            this.nWk.setVisibility(0);
            this.oaz.removeMessages(2);
            this.oaz.C(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.nWn;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.nWn) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.nWk.setVisibility(0);
            this.oaz.removeMessages(2);
            this.oaz.C(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.c(this.oay, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aD(getActivity()) && tv.chushou.zues.utils.systemBar.b.aE(getActivity())) {
                    o(view, tv.chushou.zues.utils.systemBar.b.hh(getActivity()), 0);
                    return;
                } else {
                    o(view, 0, 0);
                    return;
                }
            }
            o(view, 0, this.nUq.getHeight() + this.nUq.getTop());
        } else if (id == a.f.btn_send) {
            if (this.oaE.equals("3")) {
                String trim = this.nWj.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.K(this.oay, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.nWj.setText((CharSequence) null);
                aG(false, true);
            } else if (a(this.nWj.getText().toString(), false)) {
                aG(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.hh(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.oay, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            edv();
            com.kascend.chushou.toolkit.a.c.a(this.oay, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = eeg() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.obd == null;
                b(false, false);
                if (z && this.bV > 0 && this.obd != null && tv.chushou.zues.utils.systemBar.b.aD(getActivity()) && tv.chushou.zues.utils.systemBar.b.aE(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.obd.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.obd.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.obd == null;
                if (this.oay.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.obd != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.obd.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.obd.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.oay, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.oax.edj().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aG(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aH(false, false);
            this.oaz.C(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.ecy().c) {
                h.ecy().b(false);
                this.nUv.clearAnimation();
                this.nWd.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.nVY.findViewById(a.f.ll_keyboard).getLeft(), this.nVY.getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
            } else {
                m(view, this.nVY.findViewById(a.f.ll_keyboard).getLeft(), this.nVY.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                tv.chushou.zues.utils.g.c(this.oay, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.oay).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.oay, eeg(), false);
        } else if (id == a.f.btn_screenChange) {
            edv();
        } else if (id == a.f.rl_paoicon) {
            eds();
        } else if (id == a.f.subscribe_icon) {
            edB();
        } else if (id == a.f.report_icon) {
            if (this.oaE.equals("3")) {
                edE();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                edC();
            }
        } else if (id == a.f.btn_audio && !this.oax.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Pk(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nWp <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.Pk(a.i.str_too_fast);
            return false;
        } else {
            if (!h.ecy().e) {
                s(true);
                vs();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
            if (com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a(((VideoPlayer) this.oay).ecK().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.nWp = System.currentTimeMillis();
                a(this.oax.edj().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.oax.h);
                if (!z) {
                    this.nWj.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.oaE.equals("3")) {
            if (this.oap != null) {
                if (z) {
                    this.oap.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.oap.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.nWm != null) {
            if (z) {
                this.nWm.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nWm.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout edD() {
        if (this.oaj == null) {
            return null;
        }
        return (GiftAnimationLayout) this.oaj.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.obm != null) {
            this.obm.setVisibility(z ? 0 : 8);
            if (!z) {
                this.obm.epC();
            }
        }
        tv.chushou.zues.utils.g.w(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.oax.d()) {
            if (this.nWn) {
                this.nWk.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.oay, this.oay.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.nWk.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.oay, this.oay.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.nWn = !this.nWn;
            if (this.nWj != null) {
                this.nWj.setEnabled(this.nWn ? false : true);
            }
        }
    }

    public void aG(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bu(this.nWj);
            this.nWj.setText("");
            this.nWb.setVisibility(8);
            this.nWk.setVisibility(8);
            this.nUq.setVisibility(8);
            this.nVY.setVisibility(8);
            this.nWa.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
        if (this.nWa.getVisibility() != 8 && z2) {
            this.nWa.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_top_anim));
        }
        this.nWb.setVisibility(8);
        this.nWk.setVisibility(8);
        this.nUq.setVisibility(8);
        this.nVY.setVisibility(8);
        this.nWa.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aH(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.nWc != null) {
            this.nWc.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aH(boolean z, boolean z2) {
        return m(z, z2, false);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.nWw != null) {
                this.nWw.a(this.e);
            }
            return this.e;
        }
        if (this.oaz != null) {
            this.oaz.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.oay).e(true);
            if (!z3) {
                if (this.nVY.getVisibility() != 0 && z2) {
                    this.nVY.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_bottom_anim));
                }
                this.nVY.setVisibility(0);
                this.nWb.setVisibility(0);
                this.nWk.setVisibility(0);
                this.nVZ.setVisibility(o() ? 0 : 8);
            }
            if (this.nUq.getVisibility() != 0 && z2) {
                this.nUq.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_top_anim));
            }
            u(!z3);
            this.nUq.setVisibility(0);
            if (this.oaz != null) {
                this.oaz.C(1, 5000L);
            }
            y(false);
            if (this.nWw != null) {
                this.nWw.a(true);
            }
        } else {
            ((VideoPlayer) this.oay).e(false);
            if (this.oaQ != null) {
                this.oaQ.dismiss();
            }
            if (this.oaR != null) {
                this.oaR.dismiss();
            }
            if (this.oaY != null) {
                this.oaY.dismiss();
            }
            if (this.nVY != null) {
                if (this.nVY.getVisibility() != 8 && z2) {
                    this.nVY.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_bottom_anim));
                }
                this.nVY.setVisibility(8);
            }
            if (this.nWb != null) {
                this.nWb.setVisibility(8);
                if (this.nUq.getVisibility() != 8 && z2) {
                    this.nUq.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_top_anim));
                }
                this.nUq.setVisibility(8);
                this.nWk.setVisibility(8);
                y(true);
                a(false);
                if (this.nWw != null) {
                    this.nWw.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void edy() {
        Point hc = tv.chushou.zues.utils.a.hc(this.oay);
        if (this.ap == 1) {
            this.ar = Math.min(hc.x, hc.y);
            this.aq = Math.max(hc.x, hc.y);
        } else {
            this.ar = Math.max(hc.x, hc.y);
            this.aq = Math.min(hc.x, hc.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.nVT == null) {
            this.nVT = new Rect(0, 0, i / 5, i2);
        } else {
            this.nVT.set(0, 0, i / 5, i2);
        }
        if (this.nVU == null) {
            this.nVU = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.nVU.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.nVT == null) {
            return false;
        }
        return this.nVT.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.oaj.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.oaj.findViewById(a.f.brightness_view);
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
        if (this.nVU == null) {
            return false;
        }
        return this.nVU.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.oaj.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.oaj.findViewById(a.f.volumn_view);
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
                if (this.nWn) {
                    this.nWk.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.nWn) {
                    this.oaz.removeMessages(2);
                    this.oaz.C(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.oaz != null) {
                    this.oaz.C(3, 1000L);
                    this.oaz.C(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.nWn) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gg(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.oaA.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.oay;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int NN(int i) {
        int streamMaxVolume = (i * 10) / this.oaA.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.oaj.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.oaj.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.oay != null && (this.oay instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.oay).a(1, null, this.H, false, false, true);
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
            b.this.oaA.setStreamVolume(3, b.this.gg(i), 0);
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
            b.this.nVV = i / 10.0f;
            ((VideoPlayer) b.this.oay).l = b.this.nVV;
            ((VideoPlayer) b.this.oay).k = b.this.nVV * 255.0f;
            b.this.nVX.screenBrightness = b.this.nVV;
            b.this.nVW.setAttributes(b.this.nVX);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.oaj.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (an(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.oaj.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.oaC > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.nTX.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.oaj.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.oaj.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nWQ.getCurrentPos();
                            int duration = this.nWQ.getDuration();
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
                                this.nTX.setProgress(i3 / (duration / 1000));
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
            if (this.nWa.getVisibility() == 8 && (this.nWl == null || !this.nWl.isShown())) {
                boolean z = this.oas != null && this.oas.getVisibility() == 0;
                if (this.e) {
                    aH(false, true);
                } else {
                    m(true, true, z);
                }
                aVar.d = 0;
            } else {
                aG(false, true);
                aB();
            }
        }
        return false;
    }

    public boolean edu() {
        if (this.bB) {
            if (this.obd != null) {
                this.obd.e();
            }
            y(false);
            if (this.nVY != null) {
                this.nVY.setVisibility(0);
            }
            if (this.nUq != null) {
                this.nUq.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.oay instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.oay;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.oax != null) {
            this.oax.f = null;
            if (this.oax.edj() != null) {
                this.oax.edj().mRoominfo.mGameId = null;
            }
        }
        if (this.oaE.equals("3")) {
            if (this.nWQ != null) {
                this.nWQ.seekTo(0L);
                e(true);
            }
            edv();
            return;
        }
        edv();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.nWn) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                tv.chushou.zues.utils.g.c(this.oay, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nWQ.getPlayState() == 4) {
                        edz();
                        e(true);
                    } else {
                        if (this.nWC != null) {
                            this.nWC.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.oax.a(false);
                            ((VideoPlayer) this.oay).a(true, (Uri) null, false);
                        } else if (!this.oaE.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                        } else if (this.nWQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nWQ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nWQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            yG(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nWQ.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nWQ.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                tv.chushou.zues.utils.g.c(this.oay, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.oax.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.oay).a(true, (Uri) null, false);
                } else if (!this.oaE.equals("3")) {
                    ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                    this.ai = false;
                    yG(true);
                    a(false, !this.ak);
                } else if (this.nWQ.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                    this.ai = false;
                    yG(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void edz() {
        String str = null;
        if (!this.oaE.equals("3")) {
            if (this.oax != null && this.oax.edl() != null) {
                str = this.oax.edl().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.ecr().z != null && com.kascend.chushou.a.a.ecr().z.contains(str) && this.oax != null && !this.nWL) {
            this.nWL = true;
            com.kascend.chushou.a.a.ecr().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.nWL = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.nWC != null) {
            this.nWC.a(listItem, this.ap == 1, a.C0879a.zues_sweetalert_modal_in, a.C0879a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.nWL = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nWe != null) {
                this.nWe.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.oas != null) {
                this.oas.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nWe != null) {
            this.nWe.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.oas != null) {
                    this.oas.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void edA() {
        this.oak = new SurfaceView(this.oay);
        SurfaceView surfaceView = (SurfaceView) this.oak;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.oaj).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void edJ() {
        if (this.obm != null) {
            this.obm.epC();
            this.obm.setVisibility(8);
            this.obm.unInit();
            ((RelativeLayout) this.oaj).removeView(this.obm);
            this.obm = null;
        }
        if (this.oak != null) {
            this.oak.setVisibility(8);
            ((RelativeLayout) this.oaj).removeView(this.oak);
            this.oak = null;
        }
        edA();
        ((VideoPlayer) this.oay).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.oaz != null) {
            y(true);
            this.oaz.removeMessages(1);
            this.nVY.setVisibility(0);
            this.nWb.setVisibility(8);
            this.nUq.setVisibility(8);
            this.nWk.setVisibility(8);
        }
        if (this.oaY == null) {
            al();
            this.oaY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nUv.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.oaY.isShowing()) {
            this.oaY.showAtLocation(view, 83, i, i2);
            this.nUv.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.oax.edj().mRoominfo.mRoomID);
            return;
        }
        this.oaY.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nWy != null && this.nWy.b()) {
                this.nWy.getGlobalVisibleRect(this.nWM);
                if (!this.nWM.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.nWy.a();
                    return true;
                }
            }
            if (this.bB && f(this.obd.b, motionEvent)) {
                edu();
                return true;
            }
            if (!edZ()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.nWC != null && this.nWC.isShown()) {
                    this.nWC.a();
                    if (this.nWQ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.oax.a(false);
                            ((VideoPlayer) this.oay).a(true, (Uri) null, false);
                        } else if (!this.oaE.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                        } else if (this.nWQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.oay).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nWQ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nWQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            yG(true);
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
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
        if (this.nWl != null) {
            if (this.nWl.isShown()) {
                this.nWl.startAnimation(AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_top_anim));
            }
            this.nWl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.oay).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.oay).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.oaq != null) {
                this.oaq.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hi(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nWb.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.nWb.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nUq.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nUq.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nWa.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.nWa.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nVY.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.nVY.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
            this.nWr.setVisibility(0);
            if (this.oax.edj().mRoominfo.mIsSubscribed) {
                this.nWr.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.nWr.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.nWr.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void edB() {
        RoomInfo roomInfo;
        if (this.oax != null && this.oax.edj() != null && (roomInfo = this.oax.edj().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.oay, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.eqR();
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
        if (this.oax != null && this.oax.edj() != null && (roomInfo = this.oax.edj().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.K(b.this.oay, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.K(b.this.oay, a.i.subscribe_success);
                            }
                            if (b.this.oax != null && b.this.oax.edj() != null && (roomInfo2 = b.this.oax.edj().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.oay, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.oay, str2);
                    }
                }
            };
            if (this.oax != null && this.oax.h != null) {
                try {
                    str = new JSONObject(this.oax.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.ect().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.ect().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.nWs == null) {
                this.nWs = new ProgressDialog(this.oay);
                this.nWs.setProgressStyle(0);
                this.nWs.requestWindowFeature(1);
                this.nWs.setMessage(this.oay.getText(a.i.update_userinfo_ing));
                this.nWs.setCancelable(true);
            }
            if (!this.nWs.isShowing()) {
                this.nWs.show();
            }
        } else if (this.nWs != null && this.nWs.isShowing()) {
            this.nWs.dismiss();
        }
    }

    private void edC() {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
            if (this.nWu == null) {
                this.nWu = new f(getActivity());
            }
            this.nWu.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.nWu = null;
                }
            });
            RoomInfo roomInfo = this.oax.edj().mRoominfo;
            this.nWu.a();
            this.nWu.a(roomInfo);
            if (!this.nWu.isShowing()) {
                this.nWu.show();
            }
        }
    }

    private void edE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.nWK != null && this.oaA != null && this.oay != null && (this.oay instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.nWK;
            VideoPlayer videoPlayer = (VideoPlayer) this.oay;
            verticalSeekBarVolumn.setProgressOnly(NN(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.nTY != null) {
            this.nTY.eqv();
        }
        if (this.oaj != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.nWw == null) {
                this.nWw = new com.kascend.chushou.player.ui.giftpopup.a(this.oaj, i);
            } else if (this.nWw.a() != i) {
                this.nWw.b();
                this.nWw = null;
                this.nWw = new com.kascend.chushou.player.ui.giftpopup.a(this.oaj, i);
            }
            List<ListItem> j = this.oax != null ? this.oax.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.oay;
            if (videoPlayer != null) {
                this.nWw.a(j, videoPlayer.ecQ(), videoPlayer.ecR(), videoPlayer.ecS(), videoPlayer.ecT());
                this.nWw.a(this.e);
                if (this.oax != null && this.oax.nTE != null) {
                    this.nWw.a(this.oax.nTE, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.oax != null) {
                                b.this.oax.nTE = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.nWw != null && this.oax != null) {
                    this.nWw.b(this.oax.nTH);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void a(int i) {
        if (this.nWw != null && this.oay != null) {
            this.nWw.a(((VideoPlayer) this.oay).ecQ());
            this.nWw.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void D() {
        if (this.oay instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a ecQ = ((VideoPlayer) this.oay).ecQ();
            if (this.obq == null) {
                this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.obq.setVisibility(0);
            this.obq.a(i, ecQ);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.nWw != null) {
            this.nWw.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.nWh != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.nWh.setVisibility(0);
                    this.nWh.bX(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.nWh.setVisibility(8);
                }
            }
            if (this.nWf != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.nWg.setVisibility(0);
                    this.nWf.bX(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.nWg.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nWw != null) {
            this.nWw.a(((VideoPlayer) this.oay).ecR());
            this.nWw.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nWw != null) {
            this.nWw.a(((VideoPlayer) this.oay).ecR());
            this.nWw.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(long j) {
        if (this.nWw != null) {
            this.nWw.a(((VideoPlayer) this.oay).ecS());
            this.nWw.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0892a
    public void c(int i) {
        if (this.nWw != null) {
            this.nWw.a(((VideoPlayer) this.oay).ecT());
            this.nWw.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        yF(false);
        super.F();
    }

    private void c(View view) {
        this.nWD = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nUY = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nUY.setText(new tv.chushou.zues.widget.a.c().N(this.oay, a.e.videoplayer_4g_video).append("  ").append(this.oay.getString(a.i.videoplayer_4g_video)));
        this.nWE = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nWE.setText(new tv.chushou.zues.widget.a.c().N(this.oay, a.e.videoplayer_4g_audio).append("  ").append(this.oay.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.edv();
                    com.kascend.chushou.toolkit.a.c.a(b.this.oay, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.nWD.setVisibility(8);
                    ((VideoPlayer) b.this.oay).c(b.this.nVa);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.nWD.setVisibility(8);
                    ((VideoPlayer) b.this.oay).d(b.this.nVa);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
        findViewById.setLayoutParams(layoutParams);
        this.nUY.setOnClickListener(onClickListener);
        this.nWE.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.oax != null && !tv.chushou.zues.utils.h.isEmpty(this.oax.f)) {
            g(this.oax.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nVa = z;
            this.p = false;
            if (this.oax != null && this.oax.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.oax.f.size()) {
                        break;
                    } else if (!"2".equals(this.oax.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nWD != null) {
                this.nWD.setVisibility(0);
                this.nUY.setVisibility(0);
                this.nWE.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nWD != null) {
            this.nWD.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nWw != null && this.oax != null) {
            this.nWw.b(this.oax.nTH);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.oaj != null && (findViewById = this.oaj.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nWf != null) {
            this.nWf.performClick();
        }
    }
}
