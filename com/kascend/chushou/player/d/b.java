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
/* loaded from: classes6.dex */
public class b extends d implements View.OnClickListener, View.OnTouchListener {
    public int bu;
    private TextView nqV;
    private boolean nqX;
    private ImageView nsA;
    private FoodView nsB;
    private RelativeLayout nsC;
    private TextView nsD;
    private VerticalSeekBarVolumn nsJ;
    private long nsL;
    private LinearLayout nsb;
    private FrameLayout nsf;
    private FrescoThumbnailView nsg;
    private ImageView nsj;
    private ImageView nsl;
    RelativeLayout nsp;
    private ImageView nsq;
    private ImageView nss;
    private f nst;
    private com.kascend.chushou.player.ui.giftpopup.a nsv;
    private PopH5Menu nsx;
    private com.kascend.chushou.player.b.a nsy;
    private GiftAnimationLayout nsz;
    private Rect nrR = null;
    private Rect nrS = null;
    private float nrT = 0.0f;
    private Window nrU = null;
    private WindowManager.LayoutParams nrV = null;
    private boolean nrW = false;
    private View nrX = null;
    private View nqn = null;
    private View nrY = null;
    private View nrZ = null;
    private View nsa = null;
    private ImageView nqs = null;
    private ImageView nsc = null;
    private ImageButton nsd = null;
    private FrescoThumbnailView nse = null;
    private LinearLayout nsh = null;
    private EditText nsi = null;
    private View nsk = null;
    private boolean nsm = false;
    private int nsn = 0;
    private int bV = 0;
    private long nso = 0;
    private ProgressDialog nsr = null;
    private boolean nsu = true;
    private int nsw = -1;
    private boolean nsE = false;
    private TextView nsF = null;
    private TextView nsG = null;
    private int nsH = 0;
    private boolean nsI = false;
    private boolean nsK = false;
    private final Rect nsM = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.npV = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nwg = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.nwv != null && !((Activity) this.nwv).isFinishing()) {
            aC();
        }
        return this.nwg;
    }

    public void dNk() {
        az(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nwv, "能量_num", "横屏", new Object[0]);
    }

    public boolean az() {
        if (this.nxd == null || !this.nxd.isShown()) {
            return false;
        }
        this.nxd.d();
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
        if (z3 || this.nwg.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dMo().e;
        } else {
            z = h.dMo().b;
        }
        r(z);
        if (this.nwZ != null) {
            this.nwZ.b();
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
        if (this.nsv != null) {
            this.nsv.b();
            this.nsv = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.ci(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            dNr();
            y();
            if (this.npV != null) {
                this.npV.onConfigurationChanged(configuration);
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
        if (this.nsx != null && this.nsw != i3) {
            this.nsx.a();
            this.nsx = null;
        }
        if (this.nsx == null) {
            this.nsx = (PopH5Menu) ((ViewStub) this.nwg.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point gE = tv.chushou.zues.utils.a.gE(getActivity());
            if (this.ap == 0) {
                int i4 = gE.y;
                i = gE.y;
                i2 = i4;
            } else {
                int i5 = gE.x;
                int i6 = gE.y - ((gE.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsx.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.nsx.setLayoutParams(layoutParams);
            this.nsw = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.nsx.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.nwv instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dMH = ((VideoPlayer) this.nwv).dMH();
                    if (this.nxk == null) {
                        this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nxk.setVisibility(0);
                    this.nxk.a(i, dMH);
                }
            } else if (bVar.a == 3) {
                if (this.nwv instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dMI = ((VideoPlayer) this.nwv).dMI();
                    if (this.nxk == null) {
                        this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nxk.setVisibility(0);
                    this.nxk.a(i, dMI);
                }
            } else if (bVar.a == 9) {
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dNd;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.nwu != null && mVar.b.equals(this.nwu.a) && (dNd = this.nwu.dNd()) != null) {
            dNd.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void aC() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.nsn = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
        this.bV = tv.chushou.zues.utils.systemBar.b.gJ(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nsQ = ((VideoPlayer) this.nwv).dMx();
        this.nwu = ((VideoPlayer) this.nwv).dMA();
        c(this.nwg);
        if (this.aw.equals("1")) {
            this.npT = ((VideoPlayer) this.nwv).dMB();
            this.npT.a(this);
            if (this.nsy != null) {
                this.nsy.a();
                this.nsy = null;
                this.nsz = null;
            }
            this.nsz = (GiftAnimationLayout) this.nwg.findViewById(a.f.ll_gift_animation);
            this.nsz.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.nwu != null) {
                this.nsy = new com.kascend.chushou.player.b.a(this.nwv.getApplicationContext(), this.nsz);
                this.nsy.a(this.nwu);
            }
            this.B = (TextView) this.nwg.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dNs();
        if (this.npT != null) {
            this.npT.d();
        }
        dNK();
        this.nsj = (ImageView) this.nwg.findViewById(a.f.btn_lockscreen);
        this.nsj.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.nwg.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nwp = (PlayerErrorView) this.nwg.findViewById(a.f.view_net_error_msg);
        this.nwp.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        ar();
        this.nxd = (PaoGuideView) this.nwg.findViewById(a.f.rlPaoGuideView);
        this.nsA = (ImageView) this.nwg.findViewById(a.f.iv_send_danmu);
        this.nsa = this.nwg.findViewById(a.f.rt_layout);
        this.nse = (FrescoThumbnailView) this.nsa.findViewById(a.f.btn_gift);
        this.nsf = (FrameLayout) this.nsa.findViewById(a.f.flfl_bottom_gift);
        this.nsg = (FrescoThumbnailView) this.nsa.findViewById(a.f.btn_recharge);
        this.nsg.setOnClickListener(this);
        a(this.nwu == null ? null : this.nwu.npD);
        this.nxj = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.nrW = false;
                b.this.y(false);
                if (b.this.nww != null) {
                    b.this.nww.removeMessages(1);
                    b.this.nww.B(1, 5000L);
                }
                b.this.nsj.setVisibility(0);
                b.this.nsa.setVisibility(0);
                b.this.nqn.setVisibility(0);
                b.this.nrX.setVisibility(0);
                if (b.this.nsv != null) {
                    b.this.nsv.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nwv, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.nrW = true;
                b.this.y(true);
                b.this.nsj.setVisibility(8);
                b.this.nsa.setVisibility(8);
                if (b.this.nsv != null) {
                    b.this.nsv.a(false);
                }
                b.this.nqn.setVisibility(8);
                b.this.nrX.setVisibility(8);
                if (b.this.nww != null) {
                    b.this.nww.removeMessages(1);
                }
                if (b.this.nwZ != null) {
                    b.this.nwZ.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nwv, 14.0f) + b.this.nwZ.getMeasuredHeight(), 12);
                }
            }
        };
        this.nsh = (LinearLayout) this.nwg.findViewById(a.f.rl_seekbar);
        this.nsp = (RelativeLayout) this.nwg.findViewById(a.f.rl_paoicon);
        this.nsp.setOnClickListener(this);
        this.nxa = (RoundProgressBar) this.nwg.findViewById(a.f.roundProgressBar);
        this.nxc = (FrescoThumbnailView) this.nwg.findViewById(a.f.iv_paoicon);
        this.nxb = (TextView) this.nwg.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.nxe = 0L;
        com.kascend.chushou.player.ui.a.a dMK = ((VideoPlayer) this.nwv).dMK();
        a(dMK.dOe());
        BangInfo dOf = dMK.dOf();
        if (dOf != null) {
            a(dOf, dMK.d());
        }
        if (this.aw.equals("3")) {
            this.nsh.setVisibility(0);
            this.nsf.setVisibility(8);
            this.nsA.setVisibility(0);
            this.nsA.setOnClickListener(this);
        } else {
            this.nsA.setVisibility(8);
            this.nsh.setVisibility(8);
            this.nsf.setVisibility(0);
            this.nse.setOnClickListener(this);
        }
        dNp();
        if (tv.chushou.zues.utils.systemBar.b.gK(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsa.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.nsa.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nqn.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nqn.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nrZ.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.nrZ.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nrX.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.nrX.setLayoutParams(layoutParams4);
        }
        dNN();
        dNn();
        dNr();
        this.h = (TextView) this.nwg.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nwg.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.nwu.dNa() != null) {
                this.nss.setVisibility(0);
            } else {
                this.nss.setVisibility(8);
            }
        }
        aD();
        n();
        k(100);
        this.nsB = (FoodView) this.nwg.findViewById(a.f.kav_room_ad);
        this.nww = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.az(false, true);
                            break;
                        case 2:
                            b.this.nww.removeMessages(2);
                            if (b.this.nsj != null) {
                                b.this.nsj.setVisibility(8);
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
                            TextView textView = (TextView) b.this.nwg.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nwv.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nww.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nww.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nww.B(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.ay(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nwv).q) {
                                b.this.a(b.this.nww);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nwv).q) {
                                b.this.b(b.this.nww);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nwv).g = true;
                            b.this.nsQ.seekTo((int) b.this.mNc);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.nwu.d()) {
                                b.this.nsQ.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nsQ.getPlayState() == 4) {
                                int currentPos = b.this.nsQ.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nww != null) {
                                    b.this.nww.B(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.as();
                            break;
                        case 18:
                            b.this.dAO();
                            break;
                        case 19:
                            b.this.nwt.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.nwu != null) {
            a(this.nwu.dNb());
        }
        if (this.nsQ != null && (this.nsQ.getPlayState() == 3 || this.nsQ.getPlayState() == 4)) {
            xE(false);
            if (this.nwu.d()) {
                this.ak = false;
                m(true);
                if (this.nsQ.getDuration() > 60000) {
                    if (this.nsQ.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.nsQ.getDuration(), 300000);
                    }
                } else {
                    this.at = this.nsQ.getDuration();
                }
            }
            this.e = false;
            az(true, false);
            this.nww.LT(8);
            if (h() && this.nsQ.getPlayState() == 4 && this.nww != null) {
                this.nww.removeMessages(15);
                this.nww.LT(15);
            }
        } else {
            xE(true);
            if (this.e) {
                az(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dMn = g.dMn();
            int i = dMn.length == 2 ? dMn[1] : 0;
            if (i > 0) {
                View findViewById = this.nwg.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.nwg.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nwv, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nwv, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nwv != null && (this.nwv instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwv).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.nsg.zR(a.e.ic_recharge_old);
            this.nse.zR(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.nsE && !this.k) {
            try {
                if (this.nsQ != null) {
                    i = this.nsQ.getCurrentPos();
                    i2 = this.nsQ.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.npU.setProgress(i / (i2 / 1000));
                    this.nsF.setText(tv.chushou.zues.utils.b.o(this.nsQ.getDuration(), false));
                    this.nsG.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void aD() {
        this.npU = (ProgressBar) this.nwg.findViewById(a.f.progressBarl);
        if (this.npU != null) {
            if (this.npU instanceof SeekBar) {
                ((SeekBar) this.npU).setOnSeekBarChangeListener(new C0831b());
            }
            this.npU.setMax(1000);
        }
        this.nsF = (TextView) this.nwg.findViewById(a.f.tv_time_duration);
        this.nsG = (TextView) this.nwg.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.nwg.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nwg.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dMK;
        BangInfo dOf;
        if (config != null) {
            this.nxg = config;
            if (!config.display) {
                this.nsp.setVisibility(8);
            } else if ((this.nwv instanceof VideoPlayer) && (dOf = (dMK = ((VideoPlayer) this.nwv).dMK()).dOf()) != null) {
                a(dOf, dMK.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.nxg == null || this.nxg.display) && this.nsp != null) {
            this.nsp.setVisibility(0);
            this.nxb.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nwv instanceof VideoPlayer) {
            if ((this.nxg == null || this.nxg.display) && this.nsp != null) {
                if (j > 0) {
                    this.nsp.setVisibility(0);
                    boolean z = this.nxf;
                    this.nxf = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nwv.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.nxb.setText(cVar);
                    return;
                }
                this.nxf = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0831b implements SeekBar.OnSeekBarChangeListener {
        C0831b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.nsH != i || b.this.nsI != z) {
                    b.this.nsH = i;
                    b.this.nsI = z;
                    if (z) {
                        if (b.this.nsE) {
                            b.this.mNc = (b.this.nsQ.getDuration() / 1000) * i;
                        }
                        b.this.nsG.setText(tv.chushou.zues.utils.b.o((int) b.this.mNc, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.mNc, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.mNc) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.nsE = true;
            b.this.m = b.this.nsQ.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nww != null) {
                if (b.this.nsE) {
                    b.this.nsE = false;
                }
                b.this.nww.removeMessages(14);
                b.this.nww.LT(14);
            }
        }
    }

    private void k(int i) {
        this.npU.setSecondaryProgress((i * 1000) / 100);
    }

    private void dNK() {
        this.nsJ = (VerticalSeekBarVolumn) this.nwg.findViewById(a.f.volumn_seekbar);
        this.nsJ.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nwx.getStreamVolume(3);
        this.nsJ.setProgress(KE(streamVolume));
        x(KE(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.nwg.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.npR = new d.a();
            this.c = new GestureDetector(this.nwv, this.npR);
        }
    }

    private void dNN() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.nrU == null) {
                this.nrU = ((Activity) this.nwv).getWindow();
            }
            this.nrV = this.nrU.getAttributes();
            this.nrT = ((VideoPlayer) this.nwv).k / 255.0f;
            ((VerticalSeekBarVolumn) this.nwg.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.nrT));
        }
    }

    private void dNn() {
        this.nwg.findViewById(a.f.btn_send).setOnClickListener(this);
        this.nwg.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nwv.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.nwg.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.nsi == null) {
            this.nsi = (EditText) this.nwg.findViewById(a.f.et_input);
            this.nsi.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.nwg.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNo() {
        if (this.nst != null) {
            this.nst.dismiss();
            this.nst = null;
        }
        if (this.nwv != null) {
            ((VideoPlayer) this.nwv).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nqn = this.nwg.findViewById(a.f.topview);
        this.nsb = (LinearLayout) this.nwg.findViewById(a.f.topRight);
        this.nrY = this.nqn.findViewById(a.f.rl_download);
        this.nrZ = this.nwg.findViewById(a.f.topKeyboardView);
        this.nwg.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nqn.getVisibility() == 0;
        if (this.nsn > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nqn.getLayoutParams();
            layoutParams.topMargin = this.nsn;
            this.nqn.setLayoutParams(layoutParams);
        }
        this.nwg.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.nwg.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                str = this.nwu.dNa().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.nwg.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.nsq = (ImageView) this.nwg.findViewById(a.f.subscribe_icon);
        this.nsq.setOnClickListener(this);
        this.nss = (ImageView) this.nwg.findViewById(a.f.report_icon);
        this.nss.setOnClickListener(this);
        q();
    }

    private void dNp() {
        boolean z;
        this.nrX = this.nwg.findViewById(a.f.bottomview);
        this.nsd = (ImageButton) this.nrX.findViewById(a.f.playbutton);
        this.nsd.setOnTouchListener(this);
        this.nwm = (ImageButton) this.nwg.findViewById(a.f.btn_barrage);
        this.nwn = (ImageButton) this.nwg.findViewById(a.f.btn_audio);
        this.nsl = (ImageView) this.nwg.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.nrX.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.nrX.findViewById(a.f.btn_refresh).setVisibility(0);
            this.nwm.setVisibility(0);
            this.nsl.setVisibility(8);
            if (this.nwu != null && this.nwu.f != null) {
                for (int i = 0; i < this.nwu.f.size(); i++) {
                    if ("2".equals(this.nwu.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.nwn.setVisibility(0);
            } else {
                this.nwn.setVisibility(8);
            }
            this.nrX.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.nwm.setOnClickListener(this);
            if (h.dMo().e) {
                this.nwm.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nwm.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.nwu.d) {
                this.nwn.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.nwn.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.nwn.setOnClickListener(this);
            this.nqs = (ImageView) this.nrX.findViewById(a.f.btn_hotword);
            this.nsc = (ImageView) this.nwg.findViewById(a.f.iv_task_badge);
            this.nqs.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nwv, a.C0824a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dMo().c) {
                        b.this.nqs.clearAnimation();
                        b.this.nqs.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nqs.clearAnimation();
            if (h.dMo().c) {
                this.nqs.startAnimation(animationSet);
                this.nsc.setVisibility(0);
            }
        } else {
            this.nrX.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.nrX.findViewById(a.f.btn_refresh).setVisibility(8);
            this.nwm.setVisibility(8);
            this.nwn.setVisibility(8);
            this.nsl.setVisibility(0);
            this.nsl.setOnClickListener(this);
            if (h.dMo().b) {
                this.nsl.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nsl.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.nrX.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nwv != null) {
            ((VideoPlayer) this.nwv).e(true);
        }
        if (this.nww != null) {
            this.nww.ch(null);
            this.nww = null;
        }
        this.c = null;
        this.npR = null;
        this.nsj = null;
        if (this.nsi != null) {
            this.nsi.addTextChangedListener(null);
            this.nsi.setOnEditorActionListener(null);
            this.nsi = null;
        }
        this.nqn = null;
        this.nwm = null;
        this.nwn = null;
        this.nrX = null;
        this.nsa = null;
        if (this.nsy != null) {
            this.nsy.a();
            this.nsy = null;
            this.nsz = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dNI() {
        return this.nsy;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.nwg == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.nxk == null || !this.nxk.a(i, keyEvent)) {
                    if ((this.nsx == null || !this.nsx.onKeyDown(i, keyEvent)) && !az() && !dNm()) {
                        if (this.nrZ != null && this.nrZ.getVisibility() == 0) {
                            ay(false, true);
                            return true;
                        } else if (this.nsk != null && this.nsk.isShown()) {
                            dNP();
                            return true;
                        } else if (this.nsm && this.nww != null) {
                            if (this.nsj != null) {
                                this.nsj.setVisibility(0);
                            }
                            this.nww.removeMessages(2);
                            this.nww.B(2, 3000L);
                            return true;
                        } else {
                            dNo();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.nwg.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.nwg.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nww != null) {
                    this.nww.removeMessages(3);
                    this.nww.B(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dNO() {
        if (this.nsm) {
            this.nsj.setVisibility(0);
            this.nww.removeMessages(2);
            this.nww.B(2, 3000L);
        }
        return this.nsm;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.nsm) {
            if (view.getId() == a.f.btn_lockscreen) {
                dNq();
                return;
            }
            this.nsj.setVisibility(0);
            this.nww.removeMessages(2);
            this.nww.B(2, 3000L);
            tv.chushou.zues.utils.g.c(this.nwv, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    p(view, tv.chushou.zues.utils.systemBar.b.gJ(getActivity()), 0);
                    return;
                } else {
                    p(view, 0, 0);
                    return;
                }
            }
            p(view, 0, this.nqn.getHeight() + this.nqn.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.nsi.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.nwv, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.nsi.setText((CharSequence) null);
                ay(false, true);
            } else if (a(this.nsi.getText().toString(), false)) {
                ay(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dNq();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                q(view, tv.chushou.zues.utils.systemBar.b.gJ(getActivity()), 0);
            } else {
                q(view, 0, tv.chushou.zues.utils.a.dip2px(this.nwv, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            q(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dNo();
            com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dNY() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.nwZ == null;
                b(false, false);
                if (z && this.bV > 0 && this.nwZ != null && tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nwZ.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.nwZ.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.nwZ == null;
                if (this.nwv.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.nwZ != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nwZ.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.nwZ.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nwu.dNa().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            ay(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            az(false, false);
            this.nww.B(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dMo().c) {
                h.dMo().b(false);
                this.nqs.clearAnimation();
                this.nsc.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                n(view, this.nrX.findViewById(a.f.ll_keyboard).getLeft(), this.nrX.getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
            } else {
                n(view, this.nrX.findViewById(a.f.ll_keyboard).getLeft(), this.nrX.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                tv.chushou.zues.utils.g.c(this.nwv, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.nwv, dNY(), false);
        } else if (id == a.f.btn_screenChange) {
            dNo();
        } else if (id == a.f.rl_paoicon) {
            dNk();
        } else if (id == a.f.subscribe_icon) {
            dNt();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dNw();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dNu();
            }
        } else if (id == a.f.btn_audio && !this.nwu.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Mc(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nso <= 3000) {
            tv.chushou.zues.utils.g.Mc(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dMo().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
            if (com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a(((VideoPlayer) this.nwv).dMA().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.nso = System.currentTimeMillis();
                a(this.nwu.dNa().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nwu.h);
                if (!z) {
                    this.nsi.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.nwm != null) {
                if (z) {
                    this.nwm.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nwm.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.nsl != null) {
            if (z) {
                this.nsl.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nsl.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dNv() {
        if (this.nwg == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nwg.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.nxh != null) {
            this.nxh.setVisibility(z ? 0 : 8);
            if (!z) {
                this.nxh.dZq();
            }
        }
        tv.chushou.zues.utils.g.y(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dNq() {
        if (this.nwu.d()) {
            if (this.nsm) {
                this.nsj.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nwv, this.nwv.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.nsj.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nwv, this.nwv.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.nsm = !this.nsm;
            if (this.nsi != null) {
                this.nsi.setEnabled(this.nsm ? false : true);
            }
        }
    }

    public void ay(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dK(this.nsi);
            this.nsi.setText("");
            this.nsa.setVisibility(8);
            this.nsj.setVisibility(8);
            this.nqn.setVisibility(8);
            this.nrX.setVisibility(8);
            this.nrZ.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
        if (this.nrZ.getVisibility() != 8 && z2) {
            this.nrZ.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_top_anim));
        }
        this.nsa.setVisibility(8);
        this.nsj.setVisibility(8);
        this.nqn.setVisibility(8);
        this.nrX.setVisibility(8);
        this.nrZ.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        az(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.nsb != null) {
            this.nsb.setVisibility(z ? 0 : 4);
        }
    }

    public boolean az(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.nsv != null) {
                this.nsv.a(this.e);
            }
            return this.e;
        }
        if (this.nww != null) {
            this.nww.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nwv).e(true);
            if (!z3) {
                if (this.nrX.getVisibility() != 0 && z2) {
                    this.nrX.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_bottom_anim));
                }
                this.nrX.setVisibility(0);
                this.nsa.setVisibility(0);
                this.nsj.setVisibility(0);
                this.nrY.setVisibility(o() ? 0 : 8);
            }
            if (this.nqn.getVisibility() != 0 && z2) {
                this.nqn.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_top_anim));
            }
            u(!z3);
            this.nqn.setVisibility(0);
            if (this.nww != null) {
                this.nww.B(1, 5000L);
            }
            y(false);
            if (this.nsv != null) {
                this.nsv.a(true);
            }
        } else {
            ((VideoPlayer) this.nwv).e(false);
            if (this.nwM != null) {
                this.nwM.dismiss();
            }
            if (this.nwN != null) {
                this.nwN.dismiss();
            }
            if (this.nwU != null) {
                this.nwU.dismiss();
            }
            if (this.nrX != null) {
                if (this.nrX.getVisibility() != 8 && z2) {
                    this.nrX.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_bottom_anim));
                }
                this.nrX.setVisibility(8);
            }
            if (this.nsa != null) {
                this.nsa.setVisibility(8);
                if (this.nqn.getVisibility() != 8 && z2) {
                    this.nqn.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_top_anim));
                }
                this.nqn.setVisibility(8);
                this.nsj.setVisibility(8);
                y(true);
                a(false);
                if (this.nsv != null) {
                    this.nsv.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dNr() {
        Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
        if (this.ap == 1) {
            this.ar = Math.min(gE.x, gE.y);
            this.aq = Math.max(gE.x, gE.y);
        } else {
            this.ar = Math.max(gE.x, gE.y);
            this.aq = Math.min(gE.x, gE.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.nrR == null) {
            this.nrR = new Rect(0, 0, i / 5, i2);
        } else {
            this.nrR.set(0, 0, i / 5, i2);
        }
        if (this.nrS == null) {
            this.nrS = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.nrS.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.nrR == null) {
            return false;
        }
        return this.nrR.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.nwg.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nwg.findViewById(a.f.brightness_view);
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
        if (this.nrS == null) {
            return false;
        }
        return this.nrS.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.nwg.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nwg.findViewById(a.f.volumn_view);
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
                if (this.nsm) {
                    this.nsj.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.nsm) {
                    this.nww.removeMessages(2);
                    this.nww.B(2, 3000L);
                    return true;
                } else if (this.nww != null) {
                    this.nww.B(3, 1000L);
                    this.nww.B(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.nsm) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eb(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.nwx.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int KE(int i) {
        int streamMaxVolume = (i * 10) / this.nwx.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.nwg.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.nwg.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.nwv != null && (this.nwv instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nwv).a(1, null, this.H, false, false, true);
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
            b.this.nwx.setStreamVolume(3, b.this.eb(i), 0);
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
            b.this.nrT = i / 10.0f;
            ((VideoPlayer) b.this.nwv).l = b.this.nrT;
            ((VideoPlayer) b.this.nwv).k = b.this.nrT * 255.0f;
            b.this.nrV.screenBrightness = b.this.nrT;
            b.this.nrU.setAttributes(b.this.nrV);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.nwg.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.nwg.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.npU.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.nwg.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.nwg.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nsQ.getCurrentPos();
                            int duration = this.nsQ.getDuration();
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
                                this.npU.setProgress(i3 / (duration / 1000));
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
        if (!this.nrW) {
            if (this.nrZ.getVisibility() == 8 && (this.nsk == null || !this.nsk.isShown())) {
                boolean z = this.nwp != null && this.nwp.getVisibility() == 0;
                if (this.e) {
                    az(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                ay(false, true);
                dNP();
            }
        }
        return false;
    }

    public boolean dNm() {
        if (this.nrW) {
            if (this.nwZ != null) {
                this.nwZ.e();
            }
            y(false);
            if (this.nrX != null) {
                this.nrX.setVisibility(0);
            }
            if (this.nqn != null) {
                this.nqn.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dNB() {
        super.dNB();
        if (this.nwv instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.nwu != null) {
            this.nwu.f = null;
            if (this.nwu.dNa() != null) {
                this.nwu.dNa().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.nsQ != null) {
                this.nsQ.seekTo(0L);
                e(true);
            }
            dNo();
            return;
        }
        dNo();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.nsm) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                tv.chushou.zues.utils.g.c(this.nwv, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nsQ.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.nsB != null) {
                            this.nsB.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.nwu.a(false);
                            ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                        } else if (this.nsQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nsQ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nsQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nsQ.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nsQ.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                tv.chushou.zues.utils.g.c(this.nwv, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.nwu.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                    this.ai = false;
                    m(true);
                    a(false, !this.ak);
                } else if (this.nsQ.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                    this.ai = false;
                    m(true);
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
            if (this.nwu != null && this.nwu.dNd() != null) {
                str = this.nwu.dNd().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dMi().nnj != null && com.kascend.chushou.a.a.dMi().nnj.contains(str) && this.nwu != null && !this.nsK) {
            this.nsK = true;
            com.kascend.chushou.a.a.dMi().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.nsK = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.nsB != null) {
            this.nsB.a(listItem, this.ap == 1, a.C0824a.zues_sweetalert_modal_in, a.C0824a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.nsK = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nsd != null) {
                this.nsd.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nwp != null) {
                this.nwp.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nsd != null) {
            this.nsd.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nwp != null) {
                    this.nwp.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dNs() {
        this.N = new SurfaceView(this.nwv);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.nwg).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.nxh != null) {
            this.nxh.dZq();
            this.nxh.setVisibility(8);
            this.nxh.unInit();
            ((RelativeLayout) this.nwg).removeView(this.nxh);
            this.nxh = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.nwg).removeView(this.N);
            this.N = null;
        }
        dNs();
        ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
    }

    private void n(View view, int i, int i2) {
        if (this.nww != null) {
            y(true);
            this.nww.removeMessages(1);
            this.nrX.setVisibility(0);
            this.nsa.setVisibility(8);
            this.nqn.setVisibility(8);
            this.nsj.setVisibility(8);
        }
        if (this.nwU == null) {
            al();
            this.nwU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nqs.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.nwU.isShowing()) {
            this.nwU.showAtLocation(view, 83, i, i2);
            this.nqs.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nwu.dNa().mRoominfo.mRoomID);
            return;
        }
        this.nwU.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nsx != null && this.nsx.b()) {
                this.nsx.getGlobalVisibleRect(this.nsM);
                if (!this.nsM.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.nsx.a();
                    return true;
                }
            }
            if (this.nrW && f(this.nwZ.b, motionEvent)) {
                dNm();
                return true;
            }
            if (!dNO()) {
                if (System.currentTimeMillis() - this.nsL < 300 && this.nsB != null && this.nsB.isShown()) {
                    this.nsB.a();
                    if (this.nsQ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.nwu.a(false);
                            ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                        } else if (this.nsQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nwv).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nsQ.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nsQ.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                        }
                    }
                    return true;
                }
                this.nsL = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dNP() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
        if (this.nsk != null) {
            if (this.nsk.isShown()) {
                this.nsk.startAnimation(AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_top_anim));
            }
            this.nsk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nwv).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nwv).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.nwn != null) {
                this.nwn.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gK(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsa.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.nsa.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nqn.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nqn.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nrZ.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.nrZ.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nrX.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.nrX.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
            this.nsq.setVisibility(0);
            if (this.nwu.dNa().mRoominfo.mIsSubscribed) {
                this.nsq.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.nsq.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.nsq.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dNt() {
        RoomInfo roomInfo;
        if (this.nwu != null && this.nwu.dNa() != null && (roomInfo = this.nwu.dNa().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nwv, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.eaI();
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
        if (this.nwu != null && this.nwu.dNa() != null && (roomInfo = this.nwu.dNa().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.F(b.this.nwv, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.nwv, a.i.subscribe_success);
                            }
                            if (b.this.nwu != null && b.this.nwu.dNa() != null && (roomInfo2 = b.this.nwu.dNa().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.nwv, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nwv, str2);
                    }
                }
            };
            if (this.nwu != null && this.nwu.h != null) {
                try {
                    str = new JSONObject(this.nwu.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dMk().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dMk().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.nsr == null) {
                this.nsr = new ProgressDialog(this.nwv);
                this.nsr.setProgressStyle(0);
                this.nsr.requestWindowFeature(1);
                this.nsr.setMessage(this.nwv.getText(a.i.update_userinfo_ing));
                this.nsr.setCancelable(true);
            }
            if (!this.nsr.isShowing()) {
                this.nsr.show();
            }
        } else if (this.nsr != null && this.nsr.isShowing()) {
            this.nsr.dismiss();
        }
    }

    private void dNu() {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
            if (this.nst == null) {
                this.nst = new f(getActivity());
            }
            this.nst.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.nst = null;
                }
            });
            RoomInfo roomInfo = this.nwu.dNa().mRoominfo;
            this.nst.a();
            this.nst.a(roomInfo);
            if (!this.nst.isShowing()) {
                this.nst.show();
            }
        }
    }

    private void dNw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.nsJ != null && this.nwx != null && this.nwv != null && (this.nwv instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.nsJ;
            VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
            verticalSeekBarVolumn.setProgressOnly(KE(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.npV != null) {
            this.npV.eak();
        }
        if (this.nwg != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.nsv == null) {
                this.nsv = new com.kascend.chushou.player.ui.giftpopup.a(this.nwg, i);
            } else if (this.nsv.a() != i) {
                this.nsv.b();
                this.nsv = null;
                this.nsv = new com.kascend.chushou.player.ui.giftpopup.a(this.nwg, i);
            }
            List<ListItem> j = this.nwu != null ? this.nwu.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
            if (videoPlayer != null) {
                this.nsv.a(j, videoPlayer.dMG(), videoPlayer.dMH(), videoPlayer.dMI(), videoPlayer.dMJ());
                this.nsv.a(this.e);
                if (this.nwu != null && this.nwu.npC != null) {
                    this.nsv.a(this.nwu.npC, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.nwu != null) {
                                b.this.nwu.npC = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.nsv != null && this.nwu != null) {
                    this.nsv.b(this.nwu.npE);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nsv != null && this.nwv != null) {
            this.nsv.a(((VideoPlayer) this.nwv).dMG());
            this.nsv.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nwv instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dMG = ((VideoPlayer) this.nwv).dMG();
            if (this.nxk == null) {
                this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxk.setVisibility(0);
            this.nxk.a(i, dMG);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.nsv != null) {
            this.nsv.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.nsg != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.nsg.setVisibility(0);
                    this.nsg.bS(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.nsg.setVisibility(8);
                }
            }
            if (this.nse != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.nsf.setVisibility(0);
                    this.nse.bS(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.nsf.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nsv != null) {
            this.nsv.a(((VideoPlayer) this.nwv).dMH());
            this.nsv.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nsv != null) {
            this.nsv.a(((VideoPlayer) this.nwv).dMH());
            this.nsv.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.nsv != null) {
            this.nsv.a(((VideoPlayer) this.nwv).dMI());
            this.nsv.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.nsv != null) {
            this.nsv.a(((VideoPlayer) this.nwv).dMJ());
            this.nsv.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        xE(false);
        super.F();
    }

    private void c(View view) {
        this.nsC = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nqV = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nqV.setText(new tv.chushou.zues.widget.a.c().J(this.nwv, a.e.videoplayer_4g_video).append("  ").append(this.nwv.getString(a.i.videoplayer_4g_video)));
        this.nsD = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nsD.setText(new tv.chushou.zues.widget.a.c().J(this.nwv, a.e.videoplayer_4g_audio).append("  ").append(this.nwv.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dNo();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nwv, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.nsC.setVisibility(8);
                    ((VideoPlayer) b.this.nwv).c(b.this.nqX);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.nsC.setVisibility(8);
                    ((VideoPlayer) b.this.nwv).d(b.this.nqX);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
        findViewById.setLayoutParams(layoutParams);
        this.nqV.setOnClickListener(onClickListener);
        this.nsD.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nwu != null && !tv.chushou.zues.utils.h.isEmpty(this.nwu.f)) {
            f(this.nwu.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nqX = z;
            this.p = false;
            if (this.nwu != null && this.nwu.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nwu.f.size()) {
                        break;
                    } else if (!"2".equals(this.nwu.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nsC != null) {
                this.nsC.setVisibility(0);
                this.nqV.setVisibility(0);
                this.nsD.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nsC != null) {
            this.nsC.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nsv != null && this.nwu != null) {
            this.nsv.b(this.nwu.npE);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.nwg != null && (findViewById = this.nwg.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nse != null) {
            this.nse.performClick();
        }
    }
}
