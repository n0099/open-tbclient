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
    private TextView nqX;
    private boolean nqZ;
    private com.kascend.chushou.player.b.a nsA;
    private GiftAnimationLayout nsB;
    private ImageView nsC;
    private FoodView nsD;
    private RelativeLayout nsE;
    private TextView nsF;
    private VerticalSeekBarVolumn nsL;
    private long nsN;
    private LinearLayout nsd;
    private FrameLayout nsh;
    private FrescoThumbnailView nsi;
    private ImageView nsl;
    private ImageView nsn;
    RelativeLayout nsr;
    private ImageView nss;
    private ImageView nsu;
    private f nsv;
    private com.kascend.chushou.player.ui.giftpopup.a nsx;
    private PopH5Menu nsz;
    private Rect nrT = null;
    private Rect nrU = null;
    private float nrV = 0.0f;
    private Window nrW = null;
    private WindowManager.LayoutParams nrX = null;
    private boolean nrY = false;
    private View nrZ = null;
    private View nqp = null;
    private View nsa = null;
    private View nsb = null;
    private View nsc = null;
    private ImageView nqu = null;
    private ImageView nse = null;
    private ImageButton nsf = null;
    private FrescoThumbnailView nsg = null;
    private LinearLayout nsj = null;
    private EditText nsk = null;
    private View nsm = null;
    private boolean nso = false;
    private int nsp = 0;
    private int bV = 0;
    private long nsq = 0;
    private ProgressDialog nst = null;
    private boolean nsw = true;
    private int nsy = -1;
    private boolean nsG = false;
    private TextView nsH = null;
    private TextView nsI = null;
    private int nsJ = 0;
    private boolean nsK = false;
    private boolean nsM = false;
    private final Rect nsO = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.npX = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nwi = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.nwx != null && !((Activity) this.nwx).isFinishing()) {
            aC();
        }
        return this.nwi;
    }

    public void dNl() {
        az(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nwx, "能量_num", "横屏", new Object[0]);
    }

    public boolean az() {
        if (this.nxf == null || !this.nxf.isShown()) {
            return false;
        }
        this.nxf.d();
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
        if (z3 || this.nwi.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dMp().e;
        } else {
            z = h.dMp().b;
        }
        r(z);
        if (this.nxb != null) {
            this.nxb.b();
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
        if (this.nsx != null) {
            this.nsx.b();
            this.nsx = null;
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
            dNs();
            y();
            if (this.npX != null) {
                this.npX.onConfigurationChanged(configuration);
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
        if (this.nsz != null && this.nsy != i3) {
            this.nsz.a();
            this.nsz = null;
        }
        if (this.nsz == null) {
            this.nsz = (PopH5Menu) ((ViewStub) this.nwi.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsz.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.nsz.setLayoutParams(layoutParams);
            this.nsy = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.nsz.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.nwx instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dMI = ((VideoPlayer) this.nwx).dMI();
                    if (this.nxm == null) {
                        this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nxm.setVisibility(0);
                    this.nxm.a(i, dMI);
                }
            } else if (bVar.a == 3) {
                if (this.nwx instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dMJ = ((VideoPlayer) this.nwx).dMJ();
                    if (this.nxm == null) {
                        this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nxm.setVisibility(0);
                    this.nxm.a(i, dMJ);
                }
            } else if (bVar.a == 9) {
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dNe;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.nww != null && mVar.b.equals(this.nww.a) && (dNe = this.nww.dNe()) != null) {
            dNe.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void aC() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.nsp = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
        this.bV = tv.chushou.zues.utils.systemBar.b.gJ(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nsS = ((VideoPlayer) this.nwx).dMy();
        this.nww = ((VideoPlayer) this.nwx).dMB();
        c(this.nwi);
        if (this.aw.equals("1")) {
            this.npV = ((VideoPlayer) this.nwx).dMC();
            this.npV.a(this);
            if (this.nsA != null) {
                this.nsA.a();
                this.nsA = null;
                this.nsB = null;
            }
            this.nsB = (GiftAnimationLayout) this.nwi.findViewById(a.f.ll_gift_animation);
            this.nsB.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.nww != null) {
                this.nsA = new com.kascend.chushou.player.b.a(this.nwx.getApplicationContext(), this.nsB);
                this.nsA.a(this.nww);
            }
            this.B = (TextView) this.nwi.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dNt();
        if (this.npV != null) {
            this.npV.d();
        }
        dNL();
        this.nsl = (ImageView) this.nwi.findViewById(a.f.btn_lockscreen);
        this.nsl.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.nwi.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nwr = (PlayerErrorView) this.nwi.findViewById(a.f.view_net_error_msg);
        this.nwr.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        ar();
        this.nxf = (PaoGuideView) this.nwi.findViewById(a.f.rlPaoGuideView);
        this.nsC = (ImageView) this.nwi.findViewById(a.f.iv_send_danmu);
        this.nsc = this.nwi.findViewById(a.f.rt_layout);
        this.nsg = (FrescoThumbnailView) this.nsc.findViewById(a.f.btn_gift);
        this.nsh = (FrameLayout) this.nsc.findViewById(a.f.flfl_bottom_gift);
        this.nsi = (FrescoThumbnailView) this.nsc.findViewById(a.f.btn_recharge);
        this.nsi.setOnClickListener(this);
        a(this.nww == null ? null : this.nww.npF);
        this.nxl = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.nrY = false;
                b.this.y(false);
                if (b.this.nwy != null) {
                    b.this.nwy.removeMessages(1);
                    b.this.nwy.B(1, 5000L);
                }
                b.this.nsl.setVisibility(0);
                b.this.nsc.setVisibility(0);
                b.this.nqp.setVisibility(0);
                b.this.nrZ.setVisibility(0);
                if (b.this.nsx != null) {
                    b.this.nsx.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nwx, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.nrY = true;
                b.this.y(true);
                b.this.nsl.setVisibility(8);
                b.this.nsc.setVisibility(8);
                if (b.this.nsx != null) {
                    b.this.nsx.a(false);
                }
                b.this.nqp.setVisibility(8);
                b.this.nrZ.setVisibility(8);
                if (b.this.nwy != null) {
                    b.this.nwy.removeMessages(1);
                }
                if (b.this.nxb != null) {
                    b.this.nxb.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nwx, 14.0f) + b.this.nxb.getMeasuredHeight(), 12);
                }
            }
        };
        this.nsj = (LinearLayout) this.nwi.findViewById(a.f.rl_seekbar);
        this.nsr = (RelativeLayout) this.nwi.findViewById(a.f.rl_paoicon);
        this.nsr.setOnClickListener(this);
        this.nxc = (RoundProgressBar) this.nwi.findViewById(a.f.roundProgressBar);
        this.nxe = (FrescoThumbnailView) this.nwi.findViewById(a.f.iv_paoicon);
        this.nxd = (TextView) this.nwi.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.nxg = 0L;
        com.kascend.chushou.player.ui.a.a dML = ((VideoPlayer) this.nwx).dML();
        a(dML.dOf());
        BangInfo dOg = dML.dOg();
        if (dOg != null) {
            a(dOg, dML.d());
        }
        if (this.aw.equals("3")) {
            this.nsj.setVisibility(0);
            this.nsh.setVisibility(8);
            this.nsC.setVisibility(0);
            this.nsC.setOnClickListener(this);
        } else {
            this.nsC.setVisibility(8);
            this.nsj.setVisibility(8);
            this.nsh.setVisibility(0);
            this.nsg.setOnClickListener(this);
        }
        dNq();
        if (tv.chushou.zues.utils.systemBar.b.gK(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsc.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.nsc.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nqp.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nqp.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nsb.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.nsb.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nrZ.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.nrZ.setLayoutParams(layoutParams4);
        }
        dNO();
        dNo();
        dNs();
        this.h = (TextView) this.nwi.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nwi.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.nww.dNb() != null) {
                this.nsu.setVisibility(0);
            } else {
                this.nsu.setVisibility(8);
            }
        }
        aD();
        n();
        k(100);
        this.nsD = (FoodView) this.nwi.findViewById(a.f.kav_room_ad);
        this.nwy = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.az(false, true);
                            break;
                        case 2:
                            b.this.nwy.removeMessages(2);
                            if (b.this.nsl != null) {
                                b.this.nsl.setVisibility(8);
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
                            TextView textView = (TextView) b.this.nwi.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nwx.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nwy.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nwy.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nwy.B(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.ay(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nwx).q) {
                                b.this.a(b.this.nwy);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nwx).q) {
                                b.this.b(b.this.nwy);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nwx).g = true;
                            b.this.nsS.seekTo((int) b.this.mNe);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.nww.d()) {
                                b.this.nsS.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nsS.getPlayState() == 4) {
                                int currentPos = b.this.nsS.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nwy != null) {
                                    b.this.nwy.B(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.as();
                            break;
                        case 18:
                            b.this.dAP();
                            break;
                        case 19:
                            b.this.nwv.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.nww != null) {
            a(this.nww.dNc());
        }
        if (this.nsS != null && (this.nsS.getPlayState() == 3 || this.nsS.getPlayState() == 4)) {
            xE(false);
            if (this.nww.d()) {
                this.ak = false;
                m(true);
                if (this.nsS.getDuration() > 60000) {
                    if (this.nsS.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.nsS.getDuration(), 300000);
                    }
                } else {
                    this.at = this.nsS.getDuration();
                }
            }
            this.e = false;
            az(true, false);
            this.nwy.LT(8);
            if (h() && this.nsS.getPlayState() == 4 && this.nwy != null) {
                this.nwy.removeMessages(15);
                this.nwy.LT(15);
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
            int[] dMo = g.dMo();
            int i = dMo.length == 2 ? dMo[1] : 0;
            if (i > 0) {
                View findViewById = this.nwi.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.nwi.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nwx, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nwx, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nwx != null && (this.nwx instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwx).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.nsi.zR(a.e.ic_recharge_old);
            this.nsg.zR(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.nsG && !this.k) {
            try {
                if (this.nsS != null) {
                    i = this.nsS.getCurrentPos();
                    i2 = this.nsS.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.npW.setProgress(i / (i2 / 1000));
                    this.nsH.setText(tv.chushou.zues.utils.b.o(this.nsS.getDuration(), false));
                    this.nsI.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void aD() {
        this.npW = (ProgressBar) this.nwi.findViewById(a.f.progressBarl);
        if (this.npW != null) {
            if (this.npW instanceof SeekBar) {
                ((SeekBar) this.npW).setOnSeekBarChangeListener(new C0831b());
            }
            this.npW.setMax(1000);
        }
        this.nsH = (TextView) this.nwi.findViewById(a.f.tv_time_duration);
        this.nsI = (TextView) this.nwi.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.nwi.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nwi.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dML;
        BangInfo dOg;
        if (config != null) {
            this.nxi = config;
            if (!config.display) {
                this.nsr.setVisibility(8);
            } else if ((this.nwx instanceof VideoPlayer) && (dOg = (dML = ((VideoPlayer) this.nwx).dML()).dOg()) != null) {
                a(dOg, dML.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.nxi == null || this.nxi.display) && this.nsr != null) {
            this.nsr.setVisibility(0);
            this.nxd.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nwx instanceof VideoPlayer) {
            if ((this.nxi == null || this.nxi.display) && this.nsr != null) {
                if (j > 0) {
                    this.nsr.setVisibility(0);
                    boolean z = this.nxh;
                    this.nxh = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nwx.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.nxd.setText(cVar);
                    return;
                }
                this.nxh = false;
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
                if (b.this.nsJ != i || b.this.nsK != z) {
                    b.this.nsJ = i;
                    b.this.nsK = z;
                    if (z) {
                        if (b.this.nsG) {
                            b.this.mNe = (b.this.nsS.getDuration() / 1000) * i;
                        }
                        b.this.nsI.setText(tv.chushou.zues.utils.b.o((int) b.this.mNe, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.mNe, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.mNe) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.nsG = true;
            b.this.m = b.this.nsS.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nwy != null) {
                if (b.this.nsG) {
                    b.this.nsG = false;
                }
                b.this.nwy.removeMessages(14);
                b.this.nwy.LT(14);
            }
        }
    }

    private void k(int i) {
        this.npW.setSecondaryProgress((i * 1000) / 100);
    }

    private void dNL() {
        this.nsL = (VerticalSeekBarVolumn) this.nwi.findViewById(a.f.volumn_seekbar);
        this.nsL.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nwz.getStreamVolume(3);
        this.nsL.setProgress(KE(streamVolume));
        x(KE(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.nwi.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.npT = new d.a();
            this.c = new GestureDetector(this.nwx, this.npT);
        }
    }

    private void dNO() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.nrW == null) {
                this.nrW = ((Activity) this.nwx).getWindow();
            }
            this.nrX = this.nrW.getAttributes();
            this.nrV = ((VideoPlayer) this.nwx).k / 255.0f;
            ((VerticalSeekBarVolumn) this.nwi.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.nrV));
        }
    }

    private void dNo() {
        this.nwi.findViewById(a.f.btn_send).setOnClickListener(this);
        this.nwi.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nwx.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.nwi.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.nsk == null) {
            this.nsk = (EditText) this.nwi.findViewById(a.f.et_input);
            this.nsk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.nwi.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNp() {
        if (this.nsv != null) {
            this.nsv.dismiss();
            this.nsv = null;
        }
        if (this.nwx != null) {
            ((VideoPlayer) this.nwx).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nqp = this.nwi.findViewById(a.f.topview);
        this.nsd = (LinearLayout) this.nwi.findViewById(a.f.topRight);
        this.nsa = this.nqp.findViewById(a.f.rl_download);
        this.nsb = this.nwi.findViewById(a.f.topKeyboardView);
        this.nwi.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nqp.getVisibility() == 0;
        if (this.nsp > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nqp.getLayoutParams();
            layoutParams.topMargin = this.nsp;
            this.nqp.setLayoutParams(layoutParams);
        }
        this.nwi.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.nwi.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                str = this.nww.dNb().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.nwi.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.nss = (ImageView) this.nwi.findViewById(a.f.subscribe_icon);
        this.nss.setOnClickListener(this);
        this.nsu = (ImageView) this.nwi.findViewById(a.f.report_icon);
        this.nsu.setOnClickListener(this);
        q();
    }

    private void dNq() {
        boolean z;
        this.nrZ = this.nwi.findViewById(a.f.bottomview);
        this.nsf = (ImageButton) this.nrZ.findViewById(a.f.playbutton);
        this.nsf.setOnTouchListener(this);
        this.nwo = (ImageButton) this.nwi.findViewById(a.f.btn_barrage);
        this.nwp = (ImageButton) this.nwi.findViewById(a.f.btn_audio);
        this.nsn = (ImageView) this.nwi.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.nrZ.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.nrZ.findViewById(a.f.btn_refresh).setVisibility(0);
            this.nwo.setVisibility(0);
            this.nsn.setVisibility(8);
            if (this.nww != null && this.nww.f != null) {
                for (int i = 0; i < this.nww.f.size(); i++) {
                    if ("2".equals(this.nww.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.nwp.setVisibility(0);
            } else {
                this.nwp.setVisibility(8);
            }
            this.nrZ.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.nwo.setOnClickListener(this);
            if (h.dMp().e) {
                this.nwo.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nwo.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.nww.d) {
                this.nwp.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.nwp.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.nwp.setOnClickListener(this);
            this.nqu = (ImageView) this.nrZ.findViewById(a.f.btn_hotword);
            this.nse = (ImageView) this.nwi.findViewById(a.f.iv_task_badge);
            this.nqu.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nwx, a.C0824a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dMp().c) {
                        b.this.nqu.clearAnimation();
                        b.this.nqu.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nqu.clearAnimation();
            if (h.dMp().c) {
                this.nqu.startAnimation(animationSet);
                this.nse.setVisibility(0);
            }
        } else {
            this.nrZ.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.nrZ.findViewById(a.f.btn_refresh).setVisibility(8);
            this.nwo.setVisibility(8);
            this.nwp.setVisibility(8);
            this.nsn.setVisibility(0);
            this.nsn.setOnClickListener(this);
            if (h.dMp().b) {
                this.nsn.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nsn.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.nrZ.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nwx != null) {
            ((VideoPlayer) this.nwx).e(true);
        }
        if (this.nwy != null) {
            this.nwy.ch(null);
            this.nwy = null;
        }
        this.c = null;
        this.npT = null;
        this.nsl = null;
        if (this.nsk != null) {
            this.nsk.addTextChangedListener(null);
            this.nsk.setOnEditorActionListener(null);
            this.nsk = null;
        }
        this.nqp = null;
        this.nwo = null;
        this.nwp = null;
        this.nrZ = null;
        this.nsc = null;
        if (this.nsA != null) {
            this.nsA.a();
            this.nsA = null;
            this.nsB = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dNJ() {
        return this.nsA;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.nwi == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.nxm == null || !this.nxm.a(i, keyEvent)) {
                    if ((this.nsz == null || !this.nsz.onKeyDown(i, keyEvent)) && !az() && !dNn()) {
                        if (this.nsb != null && this.nsb.getVisibility() == 0) {
                            ay(false, true);
                            return true;
                        } else if (this.nsm != null && this.nsm.isShown()) {
                            dNQ();
                            return true;
                        } else if (this.nso && this.nwy != null) {
                            if (this.nsl != null) {
                                this.nsl.setVisibility(0);
                            }
                            this.nwy.removeMessages(2);
                            this.nwy.B(2, 3000L);
                            return true;
                        } else {
                            dNp();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.nwi.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.nwi.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nwy != null) {
                    this.nwy.removeMessages(3);
                    this.nwy.B(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dNP() {
        if (this.nso) {
            this.nsl.setVisibility(0);
            this.nwy.removeMessages(2);
            this.nwy.B(2, 3000L);
        }
        return this.nso;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.nso) {
            if (view.getId() == a.f.btn_lockscreen) {
                dNr();
                return;
            }
            this.nsl.setVisibility(0);
            this.nwy.removeMessages(2);
            this.nwy.B(2, 3000L);
            tv.chushou.zues.utils.g.c(this.nwx, getString(a.i.STR_VP_SCREEN_LOCK));
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
            p(view, 0, this.nqp.getHeight() + this.nqp.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.nsk.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.nwx, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.nsk.setText((CharSequence) null);
                ay(false, true);
            } else if (a(this.nsk.getText().toString(), false)) {
                ay(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dNr();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                q(view, tv.chushou.zues.utils.systemBar.b.gJ(getActivity()), 0);
            } else {
                q(view, 0, tv.chushou.zues.utils.a.dip2px(this.nwx, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            q(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dNp();
            com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dNZ() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.nxb == null;
                b(false, false);
                if (z && this.bV > 0 && this.nxb != null && tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nxb.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.nxb.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.nxb == null;
                if (this.nwx.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.nxb != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nxb.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.nxb.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nww.dNb().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            ay(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            az(false, false);
            this.nwy.B(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dMp().c) {
                h.dMp().b(false);
                this.nqu.clearAnimation();
                this.nse.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                n(view, this.nrZ.findViewById(a.f.ll_keyboard).getLeft(), this.nrZ.getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
            } else {
                n(view, this.nrZ.findViewById(a.f.ll_keyboard).getLeft(), this.nrZ.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                tv.chushou.zues.utils.g.c(this.nwx, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.nwx, dNZ(), false);
        } else if (id == a.f.btn_screenChange) {
            dNp();
        } else if (id == a.f.rl_paoicon) {
            dNl();
        } else if (id == a.f.subscribe_icon) {
            dNu();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dNx();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dNv();
            }
        } else if (id == a.f.btn_audio && !this.nww.d) {
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
        } else if (System.currentTimeMillis() - this.nsq <= 3000) {
            tv.chushou.zues.utils.g.Mc(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dMp().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
            if (com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a(((VideoPlayer) this.nwx).dMB().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.nsq = System.currentTimeMillis();
                a(this.nww.dNb().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nww.h);
                if (!z) {
                    this.nsk.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.nwo != null) {
                if (z) {
                    this.nwo.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nwo.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.nsn != null) {
            if (z) {
                this.nsn.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nsn.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dNw() {
        if (this.nwi == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nwi.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.nxj != null) {
            this.nxj.setVisibility(z ? 0 : 8);
            if (!z) {
                this.nxj.dZr();
            }
        }
        tv.chushou.zues.utils.g.y(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dNr() {
        if (this.nww.d()) {
            if (this.nso) {
                this.nsl.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nwx, this.nwx.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.nsl.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nwx, this.nwx.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.nso = !this.nso;
            if (this.nsk != null) {
                this.nsk.setEnabled(this.nso ? false : true);
            }
        }
    }

    public void ay(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dK(this.nsk);
            this.nsk.setText("");
            this.nsc.setVisibility(8);
            this.nsl.setVisibility(8);
            this.nqp.setVisibility(8);
            this.nrZ.setVisibility(8);
            this.nsb.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
        if (this.nsb.getVisibility() != 8 && z2) {
            this.nsb.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_top_anim));
        }
        this.nsc.setVisibility(8);
        this.nsl.setVisibility(8);
        this.nqp.setVisibility(8);
        this.nrZ.setVisibility(8);
        this.nsb.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        az(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.nsd != null) {
            this.nsd.setVisibility(z ? 0 : 4);
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
            if (this.nsx != null) {
                this.nsx.a(this.e);
            }
            return this.e;
        }
        if (this.nwy != null) {
            this.nwy.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nwx).e(true);
            if (!z3) {
                if (this.nrZ.getVisibility() != 0 && z2) {
                    this.nrZ.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_bottom_anim));
                }
                this.nrZ.setVisibility(0);
                this.nsc.setVisibility(0);
                this.nsl.setVisibility(0);
                this.nsa.setVisibility(o() ? 0 : 8);
            }
            if (this.nqp.getVisibility() != 0 && z2) {
                this.nqp.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_top_anim));
            }
            u(!z3);
            this.nqp.setVisibility(0);
            if (this.nwy != null) {
                this.nwy.B(1, 5000L);
            }
            y(false);
            if (this.nsx != null) {
                this.nsx.a(true);
            }
        } else {
            ((VideoPlayer) this.nwx).e(false);
            if (this.nwO != null) {
                this.nwO.dismiss();
            }
            if (this.nwP != null) {
                this.nwP.dismiss();
            }
            if (this.nwW != null) {
                this.nwW.dismiss();
            }
            if (this.nrZ != null) {
                if (this.nrZ.getVisibility() != 8 && z2) {
                    this.nrZ.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_bottom_anim));
                }
                this.nrZ.setVisibility(8);
            }
            if (this.nsc != null) {
                this.nsc.setVisibility(8);
                if (this.nqp.getVisibility() != 8 && z2) {
                    this.nqp.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_top_anim));
                }
                this.nqp.setVisibility(8);
                this.nsl.setVisibility(8);
                y(true);
                a(false);
                if (this.nsx != null) {
                    this.nsx.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dNs() {
        Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
        if (this.ap == 1) {
            this.ar = Math.min(gE.x, gE.y);
            this.aq = Math.max(gE.x, gE.y);
        } else {
            this.ar = Math.max(gE.x, gE.y);
            this.aq = Math.min(gE.x, gE.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.nrT == null) {
            this.nrT = new Rect(0, 0, i / 5, i2);
        } else {
            this.nrT.set(0, 0, i / 5, i2);
        }
        if (this.nrU == null) {
            this.nrU = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.nrU.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.nrT == null) {
            return false;
        }
        return this.nrT.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.nwi.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nwi.findViewById(a.f.brightness_view);
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
        if (this.nrU == null) {
            return false;
        }
        return this.nrU.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.nwi.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nwi.findViewById(a.f.volumn_view);
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
                if (this.nso) {
                    this.nsl.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.nso) {
                    this.nwy.removeMessages(2);
                    this.nwy.B(2, 3000L);
                    return true;
                } else if (this.nwy != null) {
                    this.nwy.B(3, 1000L);
                    this.nwy.B(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.nso) {
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
        int streamMaxVolume = (this.nwz.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int KE(int i) {
        int streamMaxVolume = (i * 10) / this.nwz.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.nwi.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.nwi.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.nwx != null && (this.nwx instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nwx).a(1, null, this.H, false, false, true);
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
            b.this.nwz.setStreamVolume(3, b.this.eb(i), 0);
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
            b.this.nrV = i / 10.0f;
            ((VideoPlayer) b.this.nwx).l = b.this.nrV;
            ((VideoPlayer) b.this.nwx).k = b.this.nrV * 255.0f;
            b.this.nrX.screenBrightness = b.this.nrV;
            b.this.nrW.setAttributes(b.this.nrX);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.nwi.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.nwi.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.npW.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.nwi.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.nwi.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nsS.getCurrentPos();
                            int duration = this.nsS.getDuration();
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
                                this.npW.setProgress(i3 / (duration / 1000));
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
        if (!this.nrY) {
            if (this.nsb.getVisibility() == 8 && (this.nsm == null || !this.nsm.isShown())) {
                boolean z = this.nwr != null && this.nwr.getVisibility() == 0;
                if (this.e) {
                    az(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                ay(false, true);
                dNQ();
            }
        }
        return false;
    }

    public boolean dNn() {
        if (this.nrY) {
            if (this.nxb != null) {
                this.nxb.e();
            }
            y(false);
            if (this.nrZ != null) {
                this.nrZ.setVisibility(0);
            }
            if (this.nqp != null) {
                this.nqp.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dNC() {
        super.dNC();
        if (this.nwx instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.nww != null) {
            this.nww.f = null;
            if (this.nww.dNb() != null) {
                this.nww.dNb().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.nsS != null) {
                this.nsS.seekTo(0L);
                e(true);
            }
            dNp();
            return;
        }
        dNp();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.nso) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                tv.chushou.zues.utils.g.c(this.nwx, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nsS.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.nsD != null) {
                            this.nsD.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.nww.a(false);
                            ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
                        } else if (this.nsS.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nsS.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nsS.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nsS.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nsS.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                tv.chushou.zues.utils.g.c(this.nwx, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.nww.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
                    this.ai = false;
                    m(true);
                    a(false, !this.ak);
                } else if (this.nsS.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
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
            if (this.nww != null && this.nww.dNe() != null) {
                str = this.nww.dNe().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dMj().nnl != null && com.kascend.chushou.a.a.dMj().nnl.contains(str) && this.nww != null && !this.nsM) {
            this.nsM = true;
            com.kascend.chushou.a.a.dMj().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.nsM = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.nsD != null) {
            this.nsD.a(listItem, this.ap == 1, a.C0824a.zues_sweetalert_modal_in, a.C0824a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.nsM = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.nsf != null) {
                this.nsf.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nwr != null) {
                this.nwr.setVisibility(8);
                return;
            }
            return;
        }
        if (this.nsf != null) {
            this.nsf.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nwr != null) {
                    this.nwr.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dNt() {
        this.N = new SurfaceView(this.nwx);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.nwi).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.nxj != null) {
            this.nxj.dZr();
            this.nxj.setVisibility(8);
            this.nxj.unInit();
            ((RelativeLayout) this.nwi).removeView(this.nxj);
            this.nxj = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.nwi).removeView(this.N);
            this.N = null;
        }
        dNt();
        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
    }

    private void n(View view, int i, int i2) {
        if (this.nwy != null) {
            y(true);
            this.nwy.removeMessages(1);
            this.nrZ.setVisibility(0);
            this.nsc.setVisibility(8);
            this.nqp.setVisibility(8);
            this.nsl.setVisibility(8);
        }
        if (this.nwW == null) {
            al();
            this.nwW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nqu.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.nwW.isShowing()) {
            this.nwW.showAtLocation(view, 83, i, i2);
            this.nqu.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nww.dNb().mRoominfo.mRoomID);
            return;
        }
        this.nwW.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.nsz != null && this.nsz.b()) {
                this.nsz.getGlobalVisibleRect(this.nsO);
                if (!this.nsO.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.nsz.a();
                    return true;
                }
            }
            if (this.nrY && f(this.nxb.b, motionEvent)) {
                dNn();
                return true;
            }
            if (!dNP()) {
                if (System.currentTimeMillis() - this.nsN < 300 && this.nsD != null && this.nsD.isShown()) {
                    this.nsD.a();
                    if (this.nsS.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.nww.a(false);
                            ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
                        } else if (this.nsS.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nwx).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nsS.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nsS.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                        }
                    }
                    return true;
                }
                this.nsN = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dNQ() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
        if (this.nsm != null) {
            if (this.nsm.isShown()) {
                this.nsm.startAnimation(AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_top_anim));
            }
            this.nsm.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nwx).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nwx).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.nwp != null) {
                this.nwp.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gK(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsc.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.nsc.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nqp.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nqp.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nsb.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.nsb.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.nrZ.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.nrZ.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
            this.nss.setVisibility(0);
            if (this.nww.dNb().mRoominfo.mIsSubscribed) {
                this.nss.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.nss.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.nss.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dNu() {
        RoomInfo roomInfo;
        if (this.nww != null && this.nww.dNb() != null && (roomInfo = this.nww.dNb().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nwx, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.eaJ();
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
        if (this.nww != null && this.nww.dNb() != null && (roomInfo = this.nww.dNb().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.F(b.this.nwx, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.nwx, a.i.subscribe_success);
                            }
                            if (b.this.nww != null && b.this.nww.dNb() != null && (roomInfo2 = b.this.nww.dNb().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.nwx, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nwx, str2);
                    }
                }
            };
            if (this.nww != null && this.nww.h != null) {
                try {
                    str = new JSONObject(this.nww.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dMl().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dMl().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.nst == null) {
                this.nst = new ProgressDialog(this.nwx);
                this.nst.setProgressStyle(0);
                this.nst.requestWindowFeature(1);
                this.nst.setMessage(this.nwx.getText(a.i.update_userinfo_ing));
                this.nst.setCancelable(true);
            }
            if (!this.nst.isShowing()) {
                this.nst.show();
            }
        } else if (this.nst != null && this.nst.isShowing()) {
            this.nst.dismiss();
        }
    }

    private void dNv() {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
            if (this.nsv == null) {
                this.nsv = new f(getActivity());
            }
            this.nsv.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.nsv = null;
                }
            });
            RoomInfo roomInfo = this.nww.dNb().mRoominfo;
            this.nsv.a();
            this.nsv.a(roomInfo);
            if (!this.nsv.isShowing()) {
                this.nsv.show();
            }
        }
    }

    private void dNx() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.nsL != null && this.nwz != null && this.nwx != null && (this.nwx instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.nsL;
            VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
            verticalSeekBarVolumn.setProgressOnly(KE(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.npX != null) {
            this.npX.eal();
        }
        if (this.nwi != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.nsx == null) {
                this.nsx = new com.kascend.chushou.player.ui.giftpopup.a(this.nwi, i);
            } else if (this.nsx.a() != i) {
                this.nsx.b();
                this.nsx = null;
                this.nsx = new com.kascend.chushou.player.ui.giftpopup.a(this.nwi, i);
            }
            List<ListItem> j = this.nww != null ? this.nww.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
            if (videoPlayer != null) {
                this.nsx.a(j, videoPlayer.dMH(), videoPlayer.dMI(), videoPlayer.dMJ(), videoPlayer.dMK());
                this.nsx.a(this.e);
                if (this.nww != null && this.nww.npE != null) {
                    this.nsx.a(this.nww.npE, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.nww != null) {
                                b.this.nww.npE = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.nsx != null && this.nww != null) {
                    this.nsx.b(this.nww.npG);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nsx != null && this.nwx != null) {
            this.nsx.a(((VideoPlayer) this.nwx).dMH());
            this.nsx.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nwx instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dMH = ((VideoPlayer) this.nwx).dMH();
            if (this.nxm == null) {
                this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxm.setVisibility(0);
            this.nxm.a(i, dMH);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.nsx != null) {
            this.nsx.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.nsi != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.nsi.setVisibility(0);
                    this.nsi.bS(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.nsi.setVisibility(8);
                }
            }
            if (this.nsg != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.nsh.setVisibility(0);
                    this.nsg.bS(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.nsh.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nsx != null) {
            this.nsx.a(((VideoPlayer) this.nwx).dMI());
            this.nsx.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nsx != null) {
            this.nsx.a(((VideoPlayer) this.nwx).dMI());
            this.nsx.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.nsx != null) {
            this.nsx.a(((VideoPlayer) this.nwx).dMJ());
            this.nsx.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.nsx != null) {
            this.nsx.a(((VideoPlayer) this.nwx).dMK());
            this.nsx.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        xE(false);
        super.F();
    }

    private void c(View view) {
        this.nsE = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nqX = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nqX.setText(new tv.chushou.zues.widget.a.c().J(this.nwx, a.e.videoplayer_4g_video).append("  ").append(this.nwx.getString(a.i.videoplayer_4g_video)));
        this.nsF = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.nsF.setText(new tv.chushou.zues.widget.a.c().J(this.nwx, a.e.videoplayer_4g_audio).append("  ").append(this.nwx.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dNp();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nwx, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.nsE.setVisibility(8);
                    ((VideoPlayer) b.this.nwx).c(b.this.nqZ);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.nsE.setVisibility(8);
                    ((VideoPlayer) b.this.nwx).d(b.this.nqZ);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
        findViewById.setLayoutParams(layoutParams);
        this.nqX.setOnClickListener(onClickListener);
        this.nsF.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nww != null && !tv.chushou.zues.utils.h.isEmpty(this.nww.f)) {
            f(this.nww.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nqZ = z;
            this.p = false;
            if (this.nww != null && this.nww.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nww.f.size()) {
                        break;
                    } else if (!"2".equals(this.nww.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.nsE != null) {
                this.nsE.setVisibility(0);
                this.nqX.setVisibility(0);
                this.nsF.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.nsE != null) {
            this.nsE.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nsx != null && this.nww != null) {
            this.nsx.b(this.nww.npG);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.nwi != null && (findViewById = this.nwi.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nsg != null) {
            this.nsg.performClick();
        }
    }
}
