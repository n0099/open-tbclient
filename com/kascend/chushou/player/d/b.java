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
    private TextView mra;
    private boolean mrc;
    private PopH5Menu msB;
    private com.kascend.chushou.player.b.a msC;
    private GiftAnimationLayout msD;
    private ImageView msE;
    private FoodView msF;
    private RelativeLayout msG;
    private TextView msH;
    private VerticalSeekBarVolumn msN;
    private long msP;
    private LinearLayout msd;
    private FrameLayout msi;
    private FrescoThumbnailView msj;
    private ImageView msm;
    private ImageView mso;
    public int mss;
    RelativeLayout mst;
    private ImageView msu;
    private ImageView msw;
    private f msx;
    private com.kascend.chushou.player.ui.giftpopup.a msz;
    private Rect mrT = null;
    private Rect mrU = null;
    private float mrV = 0.0f;
    private Window mrW = null;
    private WindowManager.LayoutParams mrX = null;
    private boolean mrY = false;
    private View mrZ = null;
    private View mqs = null;
    private View msa = null;
    private View msb = null;
    private View msc = null;
    private ImageView mqx = null;
    private ImageView mse = null;
    private ImageButton msf = null;
    private FrescoThumbnailView msh = null;
    private LinearLayout msk = null;
    private EditText msl = null;
    private View msn = null;
    private boolean bT = false;
    private int msp = 0;
    private int msq = 0;
    private long msr = 0;
    private ProgressDialog msv = null;
    private boolean msy = true;
    private int msA = -1;
    private boolean msI = false;
    private TextView msJ = null;
    private TextView msK = null;
    private int msL = 0;
    private boolean msM = false;
    private boolean msO = false;
    private final Rect msQ = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mss = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mqb = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mwo = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mss;
        if (this.mwE != null && !((Activity) this.mwE).isFinishing()) {
            dxY();
        }
        return this.mwo;
    }

    public void dxC() {
        au(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.mwE, "能量_num", "横屏", new Object[0]);
    }

    public boolean dxK() {
        if (this.mxo == null || !this.mxo.isShown()) {
            return false;
        }
        this.mxo.d();
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
        if (z3 || this.mwo.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dwH().e;
        } else {
            z = h.dwH().b;
        }
        r(z);
        if (this.mxk != null) {
            this.mxk.b();
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
        if (this.msz != null) {
            this.msz.b();
            this.msz = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cb(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            aM();
            y();
            if (this.mqb != null) {
                this.mqb.onConfigurationChanged(configuration);
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
        if (this.msB != null && this.msA != i3) {
            this.msB.a();
            this.msB = null;
        }
        if (this.msB == null) {
            this.msB = (PopH5Menu) ((ViewStub) this.mwo.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point fU = tv.chushou.zues.utils.a.fU(getActivity());
            if (this.ap == 0) {
                int i4 = fU.y;
                i = fU.y;
                i2 = i4;
            } else {
                int i5 = fU.x;
                int i6 = fU.y - ((fU.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.msB.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.msB.setLayoutParams(layoutParams);
            this.msA = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.msB.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dym()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mwE instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dwZ = ((VideoPlayer) this.mwE).dwZ();
                    if (this.mxv == null) {
                        this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mxv.setVisibility(0);
                    this.mxv.a(i, dwZ);
                }
            } else if (bVar.a == 3) {
                if (this.mwE instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dxa = ((VideoPlayer) this.mwE).dxa();
                    if (this.mxv == null) {
                        this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mxv.setVisibility(0);
                    this.mxv.a(i, dxa);
                }
            } else if (bVar.a == 9) {
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dxv;
        if (!dym() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mwD != null && mVar.b.equals(this.mwD.a) && (dxv = this.mwD.dxv()) != null) {
            dxv.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dxY() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.msp = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
        this.msq = tv.chushou.zues.utils.systemBar.b.fZ(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.msq);
        this.msU = ((VideoPlayer) this.mwE).dwP();
        this.mwD = ((VideoPlayer) this.mwE).dwS();
        c(this.mwo);
        if (this.aw.equals("1")) {
            this.mpZ = ((VideoPlayer) this.mwE).dwT();
            this.mpZ.a(this);
            if (this.msC != null) {
                this.msC.a();
                this.msC = null;
                this.msD = null;
            }
            this.msD = (GiftAnimationLayout) this.mwo.findViewById(a.f.ll_gift_animation);
            this.msD.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mwD != null) {
                this.msC = new com.kascend.chushou.player.b.a(this.mwE.getApplicationContext(), this.msD);
                this.msC.a(this.mwD);
            }
            this.B = (TextView) this.mwo.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        aO();
        if (this.mpZ != null) {
            this.mpZ.d();
        }
        dxW();
        this.msm = (ImageView) this.mwo.findViewById(a.f.btn_lockscreen);
        this.msm.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mwo.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mwy = (PlayerErrorView) this.mwo.findViewById(a.f.view_net_error_msg);
        this.mwy.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dxD();
        dlq();
        this.mxo = (PaoGuideView) this.mwo.findViewById(a.f.rlPaoGuideView);
        this.msE = (ImageView) this.mwo.findViewById(a.f.iv_send_danmu);
        this.msc = this.mwo.findViewById(a.f.rt_layout);
        this.msh = (FrescoThumbnailView) this.msc.findViewById(a.f.btn_gift);
        this.msi = (FrameLayout) this.msc.findViewById(a.f.flfl_bottom_gift);
        this.msj = (FrescoThumbnailView) this.msc.findViewById(a.f.btn_recharge);
        this.msj.setOnClickListener(this);
        a(this.mwD == null ? null : this.mwD.mpI);
        this.mxu = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mrY = false;
                b.this.y(false);
                if (b.this.mwF != null) {
                    b.this.mwF.removeMessages(1);
                    b.this.mwF.A(1, 5000L);
                }
                b.this.msm.setVisibility(0);
                b.this.msc.setVisibility(0);
                b.this.mqs.setVisibility(0);
                b.this.mrZ.setVisibility(0);
                if (b.this.msz != null) {
                    b.this.msz.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mwE, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mrY = true;
                b.this.y(true);
                b.this.msm.setVisibility(8);
                b.this.msc.setVisibility(8);
                if (b.this.msz != null) {
                    b.this.msz.a(false);
                }
                b.this.mqs.setVisibility(8);
                b.this.mrZ.setVisibility(8);
                if (b.this.mwF != null) {
                    b.this.mwF.removeMessages(1);
                }
                if (b.this.mxk != null) {
                    b.this.mxk.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mwE, 14.0f) + b.this.mxk.getMeasuredHeight(), 12);
                }
            }
        };
        this.msk = (LinearLayout) this.mwo.findViewById(a.f.rl_seekbar);
        this.mst = (RelativeLayout) this.mwo.findViewById(a.f.rl_paoicon);
        this.mst.setOnClickListener(this);
        this.mxl = (RoundProgressBar) this.mwo.findViewById(a.f.roundProgressBar);
        this.mxn = (FrescoThumbnailView) this.mwo.findViewById(a.f.iv_paoicon);
        this.mxm = (TextView) this.mwo.findViewById(a.f.tv_paonum);
        this.boT = 0;
        this.mxp = 0L;
        com.kascend.chushou.player.ui.a.a dxc = ((VideoPlayer) this.mwE).dxc();
        a(dxc.dys());
        BangInfo dyt = dxc.dyt();
        if (dyt != null) {
            a(dyt, dxc.d());
        }
        if (this.aw.equals("3")) {
            this.msk.setVisibility(0);
            this.msi.setVisibility(8);
            this.msE.setVisibility(0);
            this.msE.setOnClickListener(this);
        } else {
            this.msE.setVisibility(8);
            this.msk.setVisibility(8);
            this.msi.setVisibility(0);
            this.msh.setOnClickListener(this);
        }
        dxE();
        if (tv.chushou.zues.utils.systemBar.b.ga(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.msc.getLayoutParams();
            layoutParams.rightMargin += this.msq;
            this.msc.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mqs.getLayoutParams();
            layoutParams2.rightMargin += this.msq;
            this.mqs.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.msb.getLayoutParams();
            layoutParams3.rightMargin += this.msq;
            this.msb.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mrZ.getLayoutParams();
            layoutParams4.rightMargin += this.msq;
            this.mrZ.setLayoutParams(layoutParams4);
        }
        dya();
        aG();
        aM();
        this.h = (TextView) this.mwo.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mwo.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mwD.dxs() != null) {
                this.msw.setVisibility(0);
            } else {
                this.msw.setVisibility(8);
            }
        }
        dxZ();
        n();
        k(100);
        this.msF = (FoodView) this.mwo.findViewById(a.f.kav_room_ad);
        this.mwF = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.au(false, true);
                            break;
                        case 2:
                            b.this.mwF.removeMessages(2);
                            if (b.this.msm != null) {
                                b.this.msm.setVisibility(8);
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
                            TextView textView = (TextView) b.this.mwo.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mwE.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mwF.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mwF.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mwF.A(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.at(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mwE).q) {
                                b.this.a(b.this.mwF);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mwE).q) {
                                b.this.b(b.this.mwF);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mwE).g = true;
                            b.this.msU.seekTo((int) b.this.lOB);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mwD.d()) {
                                b.this.msU.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.msU.getPlayState() == 4) {
                                int currentPos = b.this.msU.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mwF != null) {
                                    b.this.mwF.A(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dyo();
                            break;
                        case 18:
                            b.this.dlp();
                            break;
                        case 19:
                            b.this.mwC.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mwD != null) {
            a(this.mwD.dxt());
        }
        if (this.msU != null && (this.msU.getPlayState() == 3 || this.msU.getPlayState() == 4)) {
            wd(false);
            if (this.mwD.d()) {
                this.ak = false;
                we(true);
                if (this.msU.getDuration() > 60000) {
                    if (this.msU.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.msU.getDuration(), 300000);
                    }
                } else {
                    this.at = this.msU.getDuration();
                }
            }
            this.e = false;
            au(true, false);
            this.mwF.JF(8);
            if (h() && this.msU.getPlayState() == 4 && this.mwF != null) {
                this.mwF.removeMessages(15);
                this.mwF.JF(15);
            }
        } else {
            wd(true);
            if (this.e) {
                au(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dwG = g.dwG();
            int i = dwG.length == 2 ? dwG[1] : 0;
            if (i > 0) {
                View findViewById = this.mwo.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mwo.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mwE, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mwE, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mwE != null && (this.mwE instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwE).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.msj.xW(a.e.ic_recharge_old);
            this.msh.xW(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.msI && !this.k) {
            try {
                if (this.msU != null) {
                    i = this.msU.getCurrentPos();
                    i2 = this.msU.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mqa.setProgress(i / (i2 / 1000));
                    this.msJ.setText(tv.chushou.zues.utils.b.n(this.msU.getDuration(), false));
                    this.msK.setText(tv.chushou.zues.utils.b.n(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dxZ() {
        this.mqa = (ProgressBar) this.mwo.findViewById(a.f.progressBarl);
        if (this.mqa != null) {
            if (this.mqa instanceof SeekBar) {
                ((SeekBar) this.mqa).setOnSeekBarChangeListener(new C0743b());
            }
            this.mqa.setMax(1000);
        }
        this.msJ = (TextView) this.mwo.findViewById(a.f.tv_time_duration);
        this.msK = (TextView) this.mwo.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mwo.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mwo.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dxc;
        BangInfo dyt;
        if (config != null) {
            this.mxr = config;
            if (!config.display) {
                this.mst.setVisibility(8);
            } else if ((this.mwE instanceof VideoPlayer) && (dyt = (dxc = ((VideoPlayer) this.mwE).dxc()).dyt()) != null) {
                a(dyt, dxc.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mxr == null || this.mxr.display) && this.mst != null) {
            this.mst.setVisibility(0);
            this.mxm.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mwE instanceof VideoPlayer) {
            if ((this.mxr == null || this.mxr.display) && this.mst != null) {
                if (j > 0) {
                    this.mst.setVisibility(0);
                    boolean z = this.mxq;
                    this.mxq = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mwE.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mxm.setText(cVar);
                    return;
                }
                this.mxq = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0743b implements SeekBar.OnSeekBarChangeListener {
        C0743b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.msL != i || b.this.msM != z) {
                    b.this.msL = i;
                    b.this.msM = z;
                    if (z) {
                        if (b.this.msI) {
                            b.this.lOB = (b.this.msU.getDuration() / 1000) * i;
                        }
                        b.this.msK.setText(tv.chushou.zues.utils.b.n((int) b.this.lOB, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.n((int) b.this.lOB, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.n(((int) b.this.lOB) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.msI = true;
            b.this.m = b.this.msU.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mwF != null) {
                if (b.this.msI) {
                    b.this.msI = false;
                }
                b.this.mwF.removeMessages(14);
                b.this.mwF.JF(14);
            }
        }
    }

    private void k(int i) {
        this.mqa.setSecondaryProgress((i * 1000) / 100);
    }

    private void dxW() {
        this.msN = (VerticalSeekBarVolumn) this.mwo.findViewById(a.f.volumn_seekbar);
        this.msN.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mwG.getStreamVolume(3);
        this.msN.setProgress(Iq(streamVolume));
        x(Iq(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mwo.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mpX = new d.a();
            this.c = new GestureDetector(this.mwE, this.mpX);
        }
    }

    private void dya() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mrW == null) {
                this.mrW = ((Activity) this.mwE).getWindow();
            }
            this.mrX = this.mrW.getAttributes();
            this.mrV = ((VideoPlayer) this.mwE).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mwo.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mrV));
        }
    }

    private void aG() {
        this.mwo.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mwo.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mwE.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mwo.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.msl == null) {
            this.msl = (EditText) this.mwo.findViewById(a.f.et_input);
            this.msl.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mwo.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        if (this.msx != null) {
            this.msx.dismiss();
            this.msx = null;
        }
        if (this.mwE != null) {
            ((VideoPlayer) this.mwE).a(1, null, this.H, false);
        }
    }

    private void dxD() {
        this.mqs = this.mwo.findViewById(a.f.topview);
        this.msd = (LinearLayout) this.mwo.findViewById(a.f.topRight);
        this.msa = this.mqs.findViewById(a.f.rl_download);
        this.msb = this.mwo.findViewById(a.f.topKeyboardView);
        this.mwo.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mqs.getVisibility() == 0;
        if (this.msp > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mqs.getLayoutParams();
            layoutParams.topMargin = this.msp;
            this.mqs.setLayoutParams(layoutParams);
        }
        this.mwo.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mwo.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                str = this.mwD.dxs().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mwo.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.msu = (ImageView) this.mwo.findViewById(a.f.subscribe_icon);
        this.msu.setOnClickListener(this);
        this.msw = (ImageView) this.mwo.findViewById(a.f.report_icon);
        this.msw.setOnClickListener(this);
        q();
    }

    private void dxE() {
        boolean z;
        this.mrZ = this.mwo.findViewById(a.f.bottomview);
        this.msf = (ImageButton) this.mrZ.findViewById(a.f.playbutton);
        this.msf.setOnTouchListener(this);
        this.mwv = (ImageButton) this.mwo.findViewById(a.f.btn_barrage);
        this.mww = (ImageButton) this.mwo.findViewById(a.f.btn_audio);
        this.mso = (ImageView) this.mwo.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mrZ.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mrZ.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mwv.setVisibility(0);
            this.mso.setVisibility(8);
            if (this.mwD != null && this.mwD.f != null) {
                for (int i = 0; i < this.mwD.f.size(); i++) {
                    if ("2".equals(this.mwD.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mww.setVisibility(0);
            } else {
                this.mww.setVisibility(8);
            }
            this.mrZ.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mwv.setOnClickListener(this);
            if (h.dwH().e) {
                this.mwv.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mwv.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mwD.d) {
                this.mww.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mww.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mww.setOnClickListener(this);
            this.mqx = (ImageView) this.mrZ.findViewById(a.f.btn_hotword);
            this.mse = (ImageView) this.mwo.findViewById(a.f.iv_task_badge);
            this.mqx.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mwE, a.C0736a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dwH().c) {
                        b.this.mqx.clearAnimation();
                        b.this.mqx.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mqx.clearAnimation();
            if (h.dwH().c) {
                this.mqx.startAnimation(animationSet);
                this.mse.setVisibility(0);
            }
        } else {
            this.mrZ.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mrZ.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mwv.setVisibility(8);
            this.mww.setVisibility(8);
            this.mso.setVisibility(0);
            this.mso.setOnClickListener(this);
            if (h.dwH().b) {
                this.mso.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mso.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mrZ.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mwE != null) {
            ((VideoPlayer) this.mwE).e(true);
        }
        if (this.mwF != null) {
            this.mwF.ca(null);
            this.mwF = null;
        }
        this.c = null;
        this.mpX = null;
        this.msm = null;
        if (this.msl != null) {
            this.msl.addTextChangedListener(null);
            this.msl.setOnEditorActionListener(null);
            this.msl = null;
        }
        this.mqs = null;
        this.mwv = null;
        this.mww = null;
        this.mrZ = null;
        this.msc = null;
        if (this.msC != null) {
            this.msC.a();
            this.msC = null;
            this.msD = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dxS() {
        return this.msC;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mwo == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mxv == null || !this.mxv.a(i, keyEvent)) {
                    if ((this.msB == null || !this.msB.onKeyDown(i, keyEvent)) && !dxK() && !dxL()) {
                        if (this.msb != null && this.msb.getVisibility() == 0) {
                            at(false, true);
                            return true;
                        } else if (this.msn != null && this.msn.isShown()) {
                            dyc();
                            return true;
                        } else if (this.bT && this.mwF != null) {
                            if (this.msm != null) {
                                this.msm.setVisibility(0);
                            }
                            this.mwF.removeMessages(2);
                            this.mwF.A(2, 3000L);
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
                int progress = ((VerticalSeekBarVolumn) this.mwo.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mwo.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mwF != null) {
                    this.mwF.removeMessages(3);
                    this.mwF.A(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dyb() {
        if (this.bT) {
            this.msm.setVisibility(0);
            this.mwF.removeMessages(2);
            this.mwF.A(2, 3000L);
        }
        return this.bT;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.bT) {
            if (view.getId() == a.f.btn_lockscreen) {
                dxG();
                return;
            }
            this.msm.setVisibility(0);
            this.mwF.removeMessages(2);
            this.mwF.A(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mwE, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    m(view, tv.chushou.zues.utils.systemBar.b.fZ(getActivity()), 0);
                    return;
                } else {
                    m(view, 0, 0);
                    return;
                }
            }
            m(view, 0, this.mqs.getHeight() + this.mqs.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.msl.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.mwE, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.msl.setText((CharSequence) null);
                at(false, true);
            } else if (a(this.msl.getText().toString(), false)) {
                at(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dxG();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                n(view, tv.chushou.zues.utils.systemBar.b.fZ(getActivity()), 0);
            } else {
                n(view, 0, tv.chushou.zues.utils.a.dip2px(this.mwE, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            n(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            aH();
            com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dyl() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mxk == null;
                b(false, false);
                if (z && this.msq > 0 && this.mxk != null && tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mxk.getLayoutParams();
                    layoutParams.rightMargin += this.msq;
                    this.mxk.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mxk == null;
                if (this.mwE.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.msq > 0 && this.mxk != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mxk.getLayoutParams();
                    layoutParams2.bottomMargin += this.msq;
                    this.mxk.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwD.dxs().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            at(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            au(false, false);
            this.mwF.A(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dwH().c) {
                h.dwH().b(false);
                this.mqx.clearAnimation();
                this.mse.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                k(view, this.mrZ.findViewById(a.f.ll_keyboard).getLeft(), this.mrZ.getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
            } else {
                k(view, this.mrZ.findViewById(a.f.ll_keyboard).getLeft(), this.mrZ.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                tv.chushou.zues.utils.g.c(this.mwE, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.mwE, dyl(), false);
        } else if (id == a.f.btn_screenChange) {
            aH();
        } else if (id == a.f.rl_paoicon) {
            dxC();
        } else if (id == a.f.subscribe_icon) {
            aP();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dxJ();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dxH();
            }
        } else if (id == a.f.btn_audio && !this.mwD.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.JO(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.msr <= 3000) {
            tv.chushou.zues.utils.g.JO(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dwH().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
            if (com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a(((VideoPlayer) this.mwE).dwS().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.msr = System.currentTimeMillis();
                a(this.mwD.dxs().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mwD.h);
                if (!z) {
                    this.msl.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mwv != null) {
                if (z) {
                    this.mwv.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mwv.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mso != null) {
            if (z) {
                this.mso.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mso.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dxI() {
        if (this.mwo == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mwo.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.mxs != null) {
            this.mxs.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mxs.dJb();
            }
        }
        tv.chushou.zues.utils.g.t(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dxG() {
        if (this.mwD.d()) {
            if (this.bT) {
                this.msm.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mwE, this.mwE.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.msm.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mwE, this.mwE.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.bT = !this.bT;
            if (this.msl != null) {
                this.msl.setEnabled(this.bT ? false : true);
            }
        }
    }

    public void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dC(this.msl);
            this.msl.setText("");
            this.msc.setVisibility(8);
            this.msm.setVisibility(8);
            this.mqs.setVisibility(8);
            this.mrZ.setVisibility(8);
            this.msb.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
        if (this.msb.getVisibility() != 8 && z2) {
            this.msb.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_top_anim));
        }
        this.msc.setVisibility(8);
        this.msm.setVisibility(8);
        this.mqs.setVisibility(8);
        this.mrZ.setVisibility(8);
        this.msb.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.msd != null) {
            this.msd.setVisibility(z ? 0 : 4);
        }
    }

    public boolean au(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dym()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.msz != null) {
                this.msz.a(this.e);
            }
            return this.e;
        }
        if (this.mwF != null) {
            this.mwF.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mwE).e(true);
            if (!z3) {
                if (this.mrZ.getVisibility() != 0 && z2) {
                    this.mrZ.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_bottom_anim));
                }
                this.mrZ.setVisibility(0);
                this.msc.setVisibility(0);
                this.msm.setVisibility(0);
                this.msa.setVisibility(o() ? 0 : 8);
            }
            if (this.mqs.getVisibility() != 0 && z2) {
                this.mqs.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_top_anim));
            }
            u(!z3);
            this.mqs.setVisibility(0);
            if (this.mwF != null) {
                this.mwF.A(1, 5000L);
            }
            y(false);
            if (this.msz != null) {
                this.msz.a(true);
            }
        } else {
            ((VideoPlayer) this.mwE).e(false);
            if (this.mwW != null) {
                this.mwW.dismiss();
            }
            if (this.mwX != null) {
                this.mwX.dismiss();
            }
            if (this.mxe != null) {
                this.mxe.dismiss();
            }
            if (this.mrZ != null) {
                if (this.mrZ.getVisibility() != 8 && z2) {
                    this.mrZ.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_bottom_anim));
                }
                this.mrZ.setVisibility(8);
            }
            if (this.msc != null) {
                this.msc.setVisibility(8);
                if (this.mqs.getVisibility() != 8 && z2) {
                    this.mqs.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_top_anim));
                }
                this.mqs.setVisibility(8);
                this.msm.setVisibility(8);
                y(true);
                a(false);
                if (this.msz != null) {
                    this.msz.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void aM() {
        Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
        if (this.ap == 1) {
            this.ar = Math.min(fU.x, fU.y);
            this.mwI = Math.max(fU.x, fU.y);
        } else {
            this.ar = Math.max(fU.x, fU.y);
            this.mwI = Math.min(fU.x, fU.y);
        }
        int i = this.ar;
        int i2 = this.mwI;
        if (this.mrT == null) {
            this.mrT = new Rect(0, 0, i / 5, i2);
        } else {
            this.mrT.set(0, 0, i / 5, i2);
        }
        if (this.mrU == null) {
            this.mrU = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mrU.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mrT == null) {
            return false;
        }
        return this.mrT.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mwo.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mwo.findViewById(a.f.brightness_view);
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
        if (this.mrU == null) {
            return false;
        }
        return this.mrU.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.mwo.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mwo.findViewById(a.f.volumn_view);
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
                    this.msm.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.bT) {
                    this.mwF.removeMessages(2);
                    this.mwF.A(2, 3000L);
                    return true;
                } else if (this.mwF != null) {
                    this.mwF.A(3, 1000L);
                    this.mwF.A(4, 1000L);
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
    public int Ip(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.mwG.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Iq(int i) {
        int streamMaxVolume = (i * 10) / this.mwG.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.mwo.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mwo.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dym() && parserRet != null) {
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
                                    if (this.mwE != null && (this.mwE instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mwE).a(1, null, this.H, false, false, true);
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
            b.this.mwG.setStreamVolume(3, b.this.Ip(i), 0);
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
            b.this.mrV = i / 10.0f;
            ((VideoPlayer) b.this.mwE).l = b.this.mrV;
            ((VideoPlayer) b.this.mwE).k = b.this.mrV * 255.0f;
            b.this.mrX.screenBrightness = b.this.mrV;
            b.this.mrW.setAttributes(b.this.mrX);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mwI && motionEvent2.getRawY() <= this.mwI) {
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mwo.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mwo.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mqa.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mwo.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mwo.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.msU.getCurrentPos();
                            int duration = this.msU.getDuration();
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
                            this.h.setText(tv.chushou.zues.utils.b.n(i3, false));
                            this.i.setText(tv.chushou.zues.utils.b.n(this.j, true));
                            if (duration > 1000) {
                                this.mqa.setProgress(i3 / (duration / 1000));
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
        if (!this.mrY) {
            if (this.msb.getVisibility() == 8 && (this.msn == null || !this.msn.isShown())) {
                boolean z = this.mwy != null && this.mwy.getVisibility() == 0;
                if (this.e) {
                    au(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                at(false, true);
                dyc();
            }
        }
        return false;
    }

    public boolean dxL() {
        if (this.mrY) {
            if (this.mxk != null) {
                this.mxk.e();
            }
            y(false);
            if (this.mrZ != null) {
                this.mrZ.setVisibility(0);
            }
            if (this.mqs != null) {
                this.mqs.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dxP() {
        super.dxP();
        if (this.mwE instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mwD != null) {
            this.mwD.f = null;
            if (this.mwD.dxs() != null) {
                this.mwD.dxs().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.msU != null) {
                this.msU.seekTo(0L);
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
            if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                tv.chushou.zues.utils.g.c(this.mwE, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.msU.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.msF != null) {
                            this.msF.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mwD.a(false);
                            ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                        } else if (this.msU.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.msU.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.msU.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            we(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.msU.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.msU.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dwA().a && !com.kascend.chushou.b.dwA().b) {
                tv.chushou.zues.utils.g.c(this.mwE, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mwD.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                    this.ai = false;
                    we(true);
                    a(false, !this.ak);
                } else if (this.msU.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                    this.ai = false;
                    we(true);
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
            if (this.mwD != null && this.mwD.dxv() != null) {
                str = this.mwD.dxv().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dwB().mnn != null && com.kascend.chushou.a.a.dwB().mnn.contains(str) && this.mwD != null && !this.msO) {
            this.msO = true;
            com.kascend.chushou.a.a.dwB().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.msO = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.msF != null) {
            this.msF.a(listItem, this.ap == 1, a.C0736a.zues_sweetalert_modal_in, a.C0736a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.msO = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.msf != null) {
                this.msf.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mwy != null) {
                this.mwy.setVisibility(8);
                return;
            }
            return;
        }
        if (this.msf != null) {
            this.msf.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mwy != null) {
                    this.mwy.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mwE);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mwo).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mxs != null) {
            this.mxs.dJb();
            this.mxs.setVisibility(8);
            this.mxs.unInit();
            ((RelativeLayout) this.mwo).removeView(this.mxs);
            this.mxs = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mwo).removeView(this.N);
            this.N = null;
        }
        aO();
        ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
    }

    private void k(View view, int i, int i2) {
        if (this.mwF != null) {
            y(true);
            this.mwF.removeMessages(1);
            this.mrZ.setVisibility(0);
            this.msc.setVisibility(8);
            this.mqs.setVisibility(8);
            this.msm.setVisibility(8);
        }
        if (this.mxe == null) {
            al();
            this.mxe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mqx.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mxe.isShowing()) {
            this.mxe.showAtLocation(view, 83, i, i2);
            this.mqx.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mwD.dxs().mRoominfo.mRoomID);
            return;
        }
        this.mxe.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.msB != null && this.msB.b()) {
                this.msB.getGlobalVisibleRect(this.msQ);
                if (!this.msQ.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.msB.a();
                    return true;
                }
            }
            if (this.mrY && g(this.mxk.b, motionEvent)) {
                dxL();
                return true;
            }
            if (!dyb()) {
                if (System.currentTimeMillis() - this.msP < 300 && this.msF != null && this.msF.isShown()) {
                    this.msF.a();
                    if (this.msU.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mwD.a(false);
                            ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                        } else if (this.msU.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mwE).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.msU.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.msU.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            we(true);
                        }
                    }
                    return true;
                }
                this.msP = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dyc() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
        if (this.msn != null) {
            if (this.msn.isShown()) {
                this.msn.startAnimation(AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_top_anim));
            }
            this.msn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mwE).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mwE).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mww != null) {
                this.mww.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.ga(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.msc.getLayoutParams();
                layoutParams.rightMargin -= this.msq;
                this.msc.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mqs.getLayoutParams();
                layoutParams2.rightMargin -= this.msq;
                this.mqs.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.msb.getLayoutParams();
                layoutParams3.rightMargin -= this.msq;
                this.msb.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mrZ.getLayoutParams();
                layoutParams4.rightMargin -= this.msq;
                layoutParams4.bottomMargin += this.msq;
                this.mrZ.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
            this.msu.setVisibility(0);
            if (this.mwD.dxs().mRoominfo.mIsSubscribed) {
                this.msu.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.msu.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.msu.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void aP() {
        RoomInfo roomInfo;
        if (this.mwD != null && this.mwD.dxs() != null && (roomInfo = this.mwD.dxs().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mwE, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dKt();
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
        if (this.mwD != null && this.mwD.dxs() != null && (roomInfo = this.mwD.dxs().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dym()) {
                        b.this.t(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dym()) {
                        b.this.t(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.F(b.this.mwE, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.mwE, a.i.subscribe_success);
                            }
                            if (b.this.mwD != null && b.this.mwD.dxs() != null && (roomInfo2 = b.this.mwD.dxs().mRoominfo) != null) {
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
                    if (!b.this.dym()) {
                        b.this.t(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mwE, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mwE, str2);
                    }
                }
            };
            if (this.mwD != null && this.mwD.h != null) {
                try {
                    str = new JSONObject(this.mwD.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dwD().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dwD().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.msv == null) {
                this.msv = new ProgressDialog(this.mwE);
                this.msv.setProgressStyle(0);
                this.msv.requestWindowFeature(1);
                this.msv.setMessage(this.mwE.getText(a.i.update_userinfo_ing));
                this.msv.setCancelable(true);
            }
            if (!this.msv.isShowing()) {
                this.msv.show();
            }
        } else if (this.msv != null && this.msv.isShowing()) {
            this.msv.dismiss();
        }
    }

    private void dxH() {
        if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
            if (this.msx == null) {
                this.msx = new f(getActivity());
            }
            this.msx.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.msx = null;
                }
            });
            RoomInfo roomInfo = this.mwD.dxs().mRoominfo;
            this.msx.a();
            this.msx.a(roomInfo);
            if (!this.msx.isShowing()) {
                this.msx.show();
            }
        }
    }

    private void dxJ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.msN != null && this.mwG != null && this.mwE != null && (this.mwE instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.msN;
            VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
            verticalSeekBarVolumn.setProgressOnly(Iq(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mqb != null) {
            this.mqb.dJV();
        }
        if (this.mwo != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.msz == null) {
                this.msz = new com.kascend.chushou.player.ui.giftpopup.a(this.mwo, i);
            } else if (this.msz.a() != i) {
                this.msz.b();
                this.msz = null;
                this.msz = new com.kascend.chushou.player.ui.giftpopup.a(this.mwo, i);
            }
            List<ListItem> j = this.mwD != null ? this.mwD.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
            if (videoPlayer != null) {
                this.msz.a(j, videoPlayer.dwY(), videoPlayer.dwZ(), videoPlayer.dxa(), videoPlayer.dxb());
                this.msz.a(this.e);
                if (this.mwD != null && this.mwD.mpH != null) {
                    this.msz.a(this.mwD.mpH, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mwD != null) {
                                b.this.mwD.mpH = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.msz != null && this.mwD != null) {
                    this.msz.b(this.mwD.mpJ);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void a(int i) {
        if (this.msz != null && this.mwE != null) {
            this.msz.a(((VideoPlayer) this.mwE).dwY());
            this.msz.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void D() {
        if (this.mwE instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dwY = ((VideoPlayer) this.mwE).dwY();
            if (this.mxv == null) {
                this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxv.setVisibility(0);
            this.mxv.a(i, dwY);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.msz != null) {
            this.msz.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.msj != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.msj.setVisibility(0);
                    this.msj.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.msj.setVisibility(8);
                }
            }
            if (this.msh != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.msi.setVisibility(0);
                    this.msh.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.msi.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.msz != null) {
            this.msz.a(((VideoPlayer) this.mwE).dwZ());
            this.msz.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.msz != null) {
            this.msz.a(((VideoPlayer) this.mwE).dwZ());
            this.msz.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(long j) {
        if (this.msz != null) {
            this.msz.a(((VideoPlayer) this.mwE).dxa());
            this.msz.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0749a
    public void c(int i) {
        if (this.msz != null) {
            this.msz.a(((VideoPlayer) this.mwE).dxb());
            this.msz.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wd(false);
        super.F();
    }

    private void c(View view) {
        this.msG = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mra = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mra.setText(new tv.chushou.zues.widget.a.c().J(this.mwE, a.e.videoplayer_4g_video).append("  ").append(this.mwE.getString(a.i.videoplayer_4g_video)));
        this.msH = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.msH.setText(new tv.chushou.zues.widget.a.c().J(this.mwE, a.e.videoplayer_4g_audio).append("  ").append(this.mwE.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.aH();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mwE, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.msG.setVisibility(8);
                    ((VideoPlayer) b.this.mwE).c(b.this.mrc);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.msG.setVisibility(8);
                    ((VideoPlayer) b.this.mwE).d(b.this.mrc);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
        findViewById.setLayoutParams(layoutParams);
        this.mra.setOnClickListener(onClickListener);
        this.msH.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mwD != null && !tv.chushou.zues.utils.h.isEmpty(this.mwD.f)) {
            f(this.mwD.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mrc = z;
            this.p = false;
            if (this.mwD != null && this.mwD.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mwD.f.size()) {
                        break;
                    } else if (!"2".equals(this.mwD.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.msG != null) {
                this.msG.setVisibility(0);
                this.mra.setVisibility(0);
                this.msH.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.msG != null) {
            this.msG.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.msz != null && this.mwD != null) {
            this.msz.b(this.mwD.mpJ);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mwo != null && (findViewById = this.mwo.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.msh != null) {
            this.msh.performClick();
        }
    }
}
