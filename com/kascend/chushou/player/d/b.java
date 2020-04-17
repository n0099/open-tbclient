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
    private TextView mqV;
    private boolean mqX;
    private LinearLayout mrY;
    private FoodView msA;
    private RelativeLayout msB;
    private TextView msC;
    private VerticalSeekBarVolumn msI;
    private long msK;
    private FrameLayout msc;
    private FrescoThumbnailView msd;
    private ImageView msh;
    private ImageView msj;
    public int msn;
    RelativeLayout mso;
    private ImageView msp;
    private ImageView msr;
    private f mss;
    private com.kascend.chushou.player.ui.giftpopup.a msu;
    private PopH5Menu msw;
    private com.kascend.chushou.player.b.a msx;
    private GiftAnimationLayout msy;
    private ImageView msz;
    private Rect mrO = null;
    private Rect mrP = null;
    private float mrQ = 0.0f;
    private Window mrR = null;
    private WindowManager.LayoutParams mrS = null;
    private boolean mrT = false;
    private View mrU = null;
    private View mqn = null;
    private View mrV = null;
    private View mrW = null;
    private View mrX = null;
    private ImageView mqs = null;
    private ImageView mrZ = null;
    private ImageButton msa = null;
    private FrescoThumbnailView msb = null;
    private LinearLayout mse = null;
    private EditText msf = null;
    private View msi = null;
    private boolean bT = false;
    private int msk = 0;
    private int msl = 0;
    private long msm = 0;
    private ProgressDialog msq = null;
    private boolean mst = true;
    private int msv = -1;
    private boolean msD = false;
    private TextView msE = null;
    private TextView msF = null;
    private int msG = 0;
    private boolean msH = false;
    private boolean msJ = false;
    private final Rect msL = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.msn = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mpW = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mwj = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.msn;
        if (this.mwz != null && !((Activity) this.mwz).isFinishing()) {
            dyc();
        }
        return this.mwj;
    }

    public void dxG() {
        au(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.mwz, "能量_num", "横屏", new Object[0]);
    }

    public boolean dxO() {
        if (this.mxj == null || !this.mxj.isShown()) {
            return false;
        }
        this.mxj.d();
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
        if (z3 || this.mwj.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dwK().e;
        } else {
            z = h.dwK().b;
        }
        r(z);
        if (this.mxf != null) {
            this.mxf.b();
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
        if (this.msu != null) {
            this.msu.b();
            this.msu = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.ca(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            aM();
            y();
            if (this.mpW != null) {
                this.mpW.onConfigurationChanged(configuration);
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
        if (this.msw != null && this.msv != i3) {
            this.msw.a();
            this.msw = null;
        }
        if (this.msw == null) {
            this.msw = (PopH5Menu) ((ViewStub) this.mwj.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point gh = tv.chushou.zues.utils.a.gh(getActivity());
            if (this.ap == 0) {
                int i4 = gh.y;
                i = gh.y;
                i2 = i4;
            } else {
                int i5 = gh.x;
                int i6 = gh.y - ((gh.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.msw.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.msw.setLayoutParams(layoutParams);
            this.msv = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.msw.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dyq()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mwz instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dxc = ((VideoPlayer) this.mwz).dxc();
                    if (this.mxq == null) {
                        this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mxq.setVisibility(0);
                    this.mxq.a(i, dxc);
                }
            } else if (bVar.a == 3) {
                if (this.mwz instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dxd = ((VideoPlayer) this.mwz).dxd();
                    if (this.mxq == null) {
                        this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mxq.setVisibility(0);
                    this.mxq.a(i, dxd);
                }
            } else if (bVar.a == 9) {
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dxz;
        if (!dyq() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mwy != null && mVar.b.equals(this.mwy.a) && (dxz = this.mwy.dxz()) != null) {
            dxz.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dyc() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.msk = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
        this.msl = tv.chushou.zues.utils.systemBar.b.gm(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.msl);
        this.msP = ((VideoPlayer) this.mwz).dwS();
        this.mwy = ((VideoPlayer) this.mwz).dwV();
        c(this.mwj);
        if (this.aw.equals("1")) {
            this.mpU = ((VideoPlayer) this.mwz).dwW();
            this.mpU.a(this);
            if (this.msx != null) {
                this.msx.a();
                this.msx = null;
                this.msy = null;
            }
            this.msy = (GiftAnimationLayout) this.mwj.findViewById(a.f.ll_gift_animation);
            this.msy.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mwy != null) {
                this.msx = new com.kascend.chushou.player.b.a(this.mwz.getApplicationContext(), this.msy);
                this.msx.a(this.mwy);
            }
            this.B = (TextView) this.mwj.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        aO();
        if (this.mpU != null) {
            this.mpU.d();
        }
        dya();
        this.msh = (ImageView) this.mwj.findViewById(a.f.btn_lockscreen);
        this.msh.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mwj.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mwt = (PlayerErrorView) this.mwj.findViewById(a.f.view_net_error_msg);
        this.mwt.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dxH();
        dlt();
        this.mxj = (PaoGuideView) this.mwj.findViewById(a.f.rlPaoGuideView);
        this.msz = (ImageView) this.mwj.findViewById(a.f.iv_send_danmu);
        this.mrX = this.mwj.findViewById(a.f.rt_layout);
        this.msb = (FrescoThumbnailView) this.mrX.findViewById(a.f.btn_gift);
        this.msc = (FrameLayout) this.mrX.findViewById(a.f.flfl_bottom_gift);
        this.msd = (FrescoThumbnailView) this.mrX.findViewById(a.f.btn_recharge);
        this.msd.setOnClickListener(this);
        a(this.mwy == null ? null : this.mwy.mpD);
        this.mxp = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mrT = false;
                b.this.y(false);
                if (b.this.mwA != null) {
                    b.this.mwA.removeMessages(1);
                    b.this.mwA.A(1, 5000L);
                }
                b.this.msh.setVisibility(0);
                b.this.mrX.setVisibility(0);
                b.this.mqn.setVisibility(0);
                b.this.mrU.setVisibility(0);
                if (b.this.msu != null) {
                    b.this.msu.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mwz, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mrT = true;
                b.this.y(true);
                b.this.msh.setVisibility(8);
                b.this.mrX.setVisibility(8);
                if (b.this.msu != null) {
                    b.this.msu.a(false);
                }
                b.this.mqn.setVisibility(8);
                b.this.mrU.setVisibility(8);
                if (b.this.mwA != null) {
                    b.this.mwA.removeMessages(1);
                }
                if (b.this.mxf != null) {
                    b.this.mxf.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mwz, 14.0f) + b.this.mxf.getMeasuredHeight(), 12);
                }
            }
        };
        this.mse = (LinearLayout) this.mwj.findViewById(a.f.rl_seekbar);
        this.mso = (RelativeLayout) this.mwj.findViewById(a.f.rl_paoicon);
        this.mso.setOnClickListener(this);
        this.mxg = (RoundProgressBar) this.mwj.findViewById(a.f.roundProgressBar);
        this.mxi = (FrescoThumbnailView) this.mwj.findViewById(a.f.iv_paoicon);
        this.mxh = (TextView) this.mwj.findViewById(a.f.tv_paonum);
        this.boO = 0;
        this.mxk = 0L;
        com.kascend.chushou.player.ui.a.a dxf = ((VideoPlayer) this.mwz).dxf();
        a(dxf.dyw());
        BangInfo dyx = dxf.dyx();
        if (dyx != null) {
            a(dyx, dxf.d());
        }
        if (this.aw.equals("3")) {
            this.mse.setVisibility(0);
            this.msc.setVisibility(8);
            this.msz.setVisibility(0);
            this.msz.setOnClickListener(this);
        } else {
            this.msz.setVisibility(8);
            this.mse.setVisibility(8);
            this.msc.setVisibility(0);
            this.msb.setOnClickListener(this);
        }
        dxI();
        if (tv.chushou.zues.utils.systemBar.b.gn(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mrX.getLayoutParams();
            layoutParams.rightMargin += this.msl;
            this.mrX.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mqn.getLayoutParams();
            layoutParams2.rightMargin += this.msl;
            this.mqn.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mrW.getLayoutParams();
            layoutParams3.rightMargin += this.msl;
            this.mrW.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mrU.getLayoutParams();
            layoutParams4.rightMargin += this.msl;
            this.mrU.setLayoutParams(layoutParams4);
        }
        dye();
        aG();
        aM();
        this.h = (TextView) this.mwj.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mwj.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mwy.dxv() != null) {
                this.msr.setVisibility(0);
            } else {
                this.msr.setVisibility(8);
            }
        }
        dyd();
        n();
        k(100);
        this.msA = (FoodView) this.mwj.findViewById(a.f.kav_room_ad);
        this.mwA = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.au(false, true);
                            break;
                        case 2:
                            b.this.mwA.removeMessages(2);
                            if (b.this.msh != null) {
                                b.this.msh.setVisibility(8);
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
                            TextView textView = (TextView) b.this.mwj.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mwz.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mwA.A(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mwA.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mwA.A(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.at(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mwz).q) {
                                b.this.a(b.this.mwA);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mwz).q) {
                                b.this.b(b.this.mwA);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mwz).g = true;
                            b.this.msP.seekTo((int) b.this.lOx);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mwy.d()) {
                                b.this.msP.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.msP.getPlayState() == 4) {
                                int currentPos = b.this.msP.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mwA != null) {
                                    b.this.mwA.A(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dys();
                            break;
                        case 18:
                            b.this.dls();
                            break;
                        case 19:
                            b.this.mwx.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mwy != null) {
            a(this.mwy.dxw());
        }
        if (this.msP != null && (this.msP.getPlayState() == 3 || this.msP.getPlayState() == 4)) {
            wd(false);
            if (this.mwy.d()) {
                this.ak = false;
                we(true);
                if (this.msP.getDuration() > 60000) {
                    if (this.msP.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.msP.getDuration(), 300000);
                    }
                } else {
                    this.at = this.msP.getDuration();
                }
            }
            this.e = false;
            au(true, false);
            this.mwA.JF(8);
            if (h() && this.msP.getPlayState() == 4 && this.mwA != null) {
                this.mwA.removeMessages(15);
                this.mwA.JF(15);
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
            int[] dwJ = g.dwJ();
            int i = dwJ.length == 2 ? dwJ[1] : 0;
            if (i > 0) {
                View findViewById = this.mwj.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mwj.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mwz, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mwz, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mwz != null && (this.mwz instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwz).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.msd.xW(a.e.ic_recharge_old);
            this.msb.xW(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.msD && !this.k) {
            try {
                if (this.msP != null) {
                    i = this.msP.getCurrentPos();
                    i2 = this.msP.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mpV.setProgress(i / (i2 / 1000));
                    this.msE.setText(tv.chushou.zues.utils.b.n(this.msP.getDuration(), false));
                    this.msF.setText(tv.chushou.zues.utils.b.n(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dyd() {
        this.mpV = (ProgressBar) this.mwj.findViewById(a.f.progressBarl);
        if (this.mpV != null) {
            if (this.mpV instanceof SeekBar) {
                ((SeekBar) this.mpV).setOnSeekBarChangeListener(new C0722b());
            }
            this.mpV.setMax(1000);
        }
        this.msE = (TextView) this.mwj.findViewById(a.f.tv_time_duration);
        this.msF = (TextView) this.mwj.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mwj.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mwj.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dxf;
        BangInfo dyx;
        if (config != null) {
            this.mxm = config;
            if (!config.display) {
                this.mso.setVisibility(8);
            } else if ((this.mwz instanceof VideoPlayer) && (dyx = (dxf = ((VideoPlayer) this.mwz).dxf()).dyx()) != null) {
                a(dyx, dxf.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mxm == null || this.mxm.display) && this.mso != null) {
            this.mso.setVisibility(0);
            this.mxh.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mwz instanceof VideoPlayer) {
            if ((this.mxm == null || this.mxm.display) && this.mso != null) {
                if (j > 0) {
                    this.mso.setVisibility(0);
                    boolean z = this.mxl;
                    this.mxl = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mwz.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mxh.setText(cVar);
                    return;
                }
                this.mxl = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0722b implements SeekBar.OnSeekBarChangeListener {
        C0722b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.msG != i || b.this.msH != z) {
                    b.this.msG = i;
                    b.this.msH = z;
                    if (z) {
                        if (b.this.msD) {
                            b.this.lOx = (b.this.msP.getDuration() / 1000) * i;
                        }
                        b.this.msF.setText(tv.chushou.zues.utils.b.n((int) b.this.lOx, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.n((int) b.this.lOx, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.n(((int) b.this.lOx) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.msD = true;
            b.this.m = b.this.msP.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mwA != null) {
                if (b.this.msD) {
                    b.this.msD = false;
                }
                b.this.mwA.removeMessages(14);
                b.this.mwA.JF(14);
            }
        }
    }

    private void k(int i) {
        this.mpV.setSecondaryProgress((i * 1000) / 100);
    }

    private void dya() {
        this.msI = (VerticalSeekBarVolumn) this.mwj.findViewById(a.f.volumn_seekbar);
        this.msI.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mwB.getStreamVolume(3);
        this.msI.setProgress(Iq(streamVolume));
        x(Iq(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mwj.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mpS = new d.a();
            this.c = new GestureDetector(this.mwz, this.mpS);
        }
    }

    private void dye() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mrR == null) {
                this.mrR = ((Activity) this.mwz).getWindow();
            }
            this.mrS = this.mrR.getAttributes();
            this.mrQ = ((VideoPlayer) this.mwz).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mwj.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mrQ));
        }
    }

    private void aG() {
        this.mwj.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mwj.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mwz.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mwj.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.msf == null) {
            this.msf = (EditText) this.mwj.findViewById(a.f.et_input);
            this.msf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mwj.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH() {
        if (this.mss != null) {
            this.mss.dismiss();
            this.mss = null;
        }
        if (this.mwz != null) {
            ((VideoPlayer) this.mwz).a(1, null, this.H, false);
        }
    }

    private void dxH() {
        this.mqn = this.mwj.findViewById(a.f.topview);
        this.mrY = (LinearLayout) this.mwj.findViewById(a.f.topRight);
        this.mrV = this.mqn.findViewById(a.f.rl_download);
        this.mrW = this.mwj.findViewById(a.f.topKeyboardView);
        this.mwj.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mqn.getVisibility() == 0;
        if (this.msk > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mqn.getLayoutParams();
            layoutParams.topMargin = this.msk;
            this.mqn.setLayoutParams(layoutParams);
        }
        this.mwj.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mwj.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                str = this.mwy.dxv().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mwj.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.msp = (ImageView) this.mwj.findViewById(a.f.subscribe_icon);
        this.msp.setOnClickListener(this);
        this.msr = (ImageView) this.mwj.findViewById(a.f.report_icon);
        this.msr.setOnClickListener(this);
        q();
    }

    private void dxI() {
        boolean z;
        this.mrU = this.mwj.findViewById(a.f.bottomview);
        this.msa = (ImageButton) this.mrU.findViewById(a.f.playbutton);
        this.msa.setOnTouchListener(this);
        this.mwq = (ImageButton) this.mwj.findViewById(a.f.btn_barrage);
        this.mwr = (ImageButton) this.mwj.findViewById(a.f.btn_audio);
        this.msj = (ImageView) this.mwj.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mrU.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mrU.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mwq.setVisibility(0);
            this.msj.setVisibility(8);
            if (this.mwy != null && this.mwy.f != null) {
                for (int i = 0; i < this.mwy.f.size(); i++) {
                    if ("2".equals(this.mwy.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mwr.setVisibility(0);
            } else {
                this.mwr.setVisibility(8);
            }
            this.mrU.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mwq.setOnClickListener(this);
            if (h.dwK().e) {
                this.mwq.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mwq.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mwy.d) {
                this.mwr.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mwr.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mwr.setOnClickListener(this);
            this.mqs = (ImageView) this.mrU.findViewById(a.f.btn_hotword);
            this.mrZ = (ImageView) this.mwj.findViewById(a.f.iv_task_badge);
            this.mqs.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mwz, a.C0715a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dwK().c) {
                        b.this.mqs.clearAnimation();
                        b.this.mqs.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mqs.clearAnimation();
            if (h.dwK().c) {
                this.mqs.startAnimation(animationSet);
                this.mrZ.setVisibility(0);
            }
        } else {
            this.mrU.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mrU.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mwq.setVisibility(8);
            this.mwr.setVisibility(8);
            this.msj.setVisibility(0);
            this.msj.setOnClickListener(this);
            if (h.dwK().b) {
                this.msj.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.msj.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mrU.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mwz != null) {
            ((VideoPlayer) this.mwz).e(true);
        }
        if (this.mwA != null) {
            this.mwA.bZ(null);
            this.mwA = null;
        }
        this.c = null;
        this.mpS = null;
        this.msh = null;
        if (this.msf != null) {
            this.msf.addTextChangedListener(null);
            this.msf.setOnEditorActionListener(null);
            this.msf = null;
        }
        this.mqn = null;
        this.mwq = null;
        this.mwr = null;
        this.mrU = null;
        this.mrX = null;
        if (this.msx != null) {
            this.msx.a();
            this.msx = null;
            this.msy = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dxW() {
        return this.msx;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mwj == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mxq == null || !this.mxq.a(i, keyEvent)) {
                    if ((this.msw == null || !this.msw.onKeyDown(i, keyEvent)) && !dxO() && !dxP()) {
                        if (this.mrW != null && this.mrW.getVisibility() == 0) {
                            at(false, true);
                            return true;
                        } else if (this.msi != null && this.msi.isShown()) {
                            dyg();
                            return true;
                        } else if (this.bT && this.mwA != null) {
                            if (this.msh != null) {
                                this.msh.setVisibility(0);
                            }
                            this.mwA.removeMessages(2);
                            this.mwA.A(2, 3000L);
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
                int progress = ((VerticalSeekBarVolumn) this.mwj.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mwj.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mwA != null) {
                    this.mwA.removeMessages(3);
                    this.mwA.A(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dyf() {
        if (this.bT) {
            this.msh.setVisibility(0);
            this.mwA.removeMessages(2);
            this.mwA.A(2, 3000L);
        }
        return this.bT;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.bT) {
            if (view.getId() == a.f.btn_lockscreen) {
                dxK();
                return;
            }
            this.msh.setVisibility(0);
            this.mwA.removeMessages(2);
            this.mwA.A(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mwz, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    m(view, tv.chushou.zues.utils.systemBar.b.gm(getActivity()), 0);
                    return;
                } else {
                    m(view, 0, 0);
                    return;
                }
            }
            m(view, 0, this.mqn.getHeight() + this.mqn.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.msf.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.mwz, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.msf.setText((CharSequence) null);
                at(false, true);
            } else if (a(this.msf.getText().toString(), false)) {
                at(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dxK();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                n(view, tv.chushou.zues.utils.systemBar.b.gm(getActivity()), 0);
            } else {
                n(view, 0, tv.chushou.zues.utils.a.dip2px(this.mwz, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            n(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            aH();
            com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dyp() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mxf == null;
                b(false, false);
                if (z && this.msl > 0 && this.mxf != null && tv.chushou.zues.utils.systemBar.b.ay(getActivity()) && tv.chushou.zues.utils.systemBar.b.az(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mxf.getLayoutParams();
                    layoutParams.rightMargin += this.msl;
                    this.mxf.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mxf == null;
                if (this.mwz.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.msl > 0 && this.mxf != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mxf.getLayoutParams();
                    layoutParams2.bottomMargin += this.msl;
                    this.mxf.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwy.dxv().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            at(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            au(false, false);
            this.mwA.A(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dwK().c) {
                h.dwK().b(false);
                this.mqs.clearAnimation();
                this.mrZ.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                k(view, this.mrU.findViewById(a.f.ll_keyboard).getLeft(), this.mrU.getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
            } else {
                k(view, this.mrU.findViewById(a.f.ll_keyboard).getLeft(), this.mrU.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                tv.chushou.zues.utils.g.c(this.mwz, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.mwz, dyp(), false);
        } else if (id == a.f.btn_screenChange) {
            aH();
        } else if (id == a.f.rl_paoicon) {
            dxG();
        } else if (id == a.f.subscribe_icon) {
            aP();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dxN();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dxL();
            }
        } else if (id == a.f.btn_audio && !this.mwy.d) {
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
        } else if (System.currentTimeMillis() - this.msm <= 3000) {
            tv.chushou.zues.utils.g.JO(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dwK().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
            if (com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a(((VideoPlayer) this.mwz).dwV().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.msm = System.currentTimeMillis();
                a(this.mwy.dxv().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mwy.h);
                if (!z) {
                    this.msf.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mwq != null) {
                if (z) {
                    this.mwq.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mwq.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.msj != null) {
            if (z) {
                this.msj.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.msj.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dxM() {
        if (this.mwj == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mwj.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.mxn != null) {
            this.mxn.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mxn.dJf();
            }
        }
        tv.chushou.zues.utils.g.t(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dxK() {
        if (this.mwy.d()) {
            if (this.bT) {
                this.msh.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mwz, this.mwz.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.msh.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mwz, this.mwz.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.bT = !this.bT;
            if (this.msf != null) {
                this.msf.setEnabled(this.bT ? false : true);
            }
        }
    }

    public void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dC(this.msf);
            this.msf.setText("");
            this.mrX.setVisibility(8);
            this.msh.setVisibility(8);
            this.mqn.setVisibility(8);
            this.mrU.setVisibility(8);
            this.mrW.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
        if (this.mrW.getVisibility() != 8 && z2) {
            this.mrW.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_top_anim));
        }
        this.mrX.setVisibility(8);
        this.msh.setVisibility(8);
        this.mqn.setVisibility(8);
        this.mrU.setVisibility(8);
        this.mrW.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        au(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.mrY != null) {
            this.mrY.setVisibility(z ? 0 : 4);
        }
    }

    public boolean au(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dyq()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.msu != null) {
                this.msu.a(this.e);
            }
            return this.e;
        }
        if (this.mwA != null) {
            this.mwA.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mwz).e(true);
            if (!z3) {
                if (this.mrU.getVisibility() != 0 && z2) {
                    this.mrU.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_bottom_anim));
                }
                this.mrU.setVisibility(0);
                this.mrX.setVisibility(0);
                this.msh.setVisibility(0);
                this.mrV.setVisibility(o() ? 0 : 8);
            }
            if (this.mqn.getVisibility() != 0 && z2) {
                this.mqn.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_top_anim));
            }
            u(!z3);
            this.mqn.setVisibility(0);
            if (this.mwA != null) {
                this.mwA.A(1, 5000L);
            }
            y(false);
            if (this.msu != null) {
                this.msu.a(true);
            }
        } else {
            ((VideoPlayer) this.mwz).e(false);
            if (this.mwR != null) {
                this.mwR.dismiss();
            }
            if (this.mwS != null) {
                this.mwS.dismiss();
            }
            if (this.mwZ != null) {
                this.mwZ.dismiss();
            }
            if (this.mrU != null) {
                if (this.mrU.getVisibility() != 8 && z2) {
                    this.mrU.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_bottom_anim));
                }
                this.mrU.setVisibility(8);
            }
            if (this.mrX != null) {
                this.mrX.setVisibility(8);
                if (this.mqn.getVisibility() != 8 && z2) {
                    this.mqn.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_top_anim));
                }
                this.mqn.setVisibility(8);
                this.msh.setVisibility(8);
                y(true);
                a(false);
                if (this.msu != null) {
                    this.msu.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void aM() {
        Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
        if (this.ap == 1) {
            this.ar = Math.min(gh.x, gh.y);
            this.mwD = Math.max(gh.x, gh.y);
        } else {
            this.ar = Math.max(gh.x, gh.y);
            this.mwD = Math.min(gh.x, gh.y);
        }
        int i = this.ar;
        int i2 = this.mwD;
        if (this.mrO == null) {
            this.mrO = new Rect(0, 0, i / 5, i2);
        } else {
            this.mrO.set(0, 0, i / 5, i2);
        }
        if (this.mrP == null) {
            this.mrP = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mrP.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mrO == null) {
            return false;
        }
        return this.mrO.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mwj.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mwj.findViewById(a.f.brightness_view);
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
        if (this.mrP == null) {
            return false;
        }
        return this.mrP.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.mwj.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mwj.findViewById(a.f.volumn_view);
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
                    this.msh.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.bT) {
                    this.mwA.removeMessages(2);
                    this.mwA.A(2, 3000L);
                    return true;
                } else if (this.mwA != null) {
                    this.mwA.A(3, 1000L);
                    this.mwA.A(4, 1000L);
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
        int streamMaxVolume = (this.mwB.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Iq(int i) {
        int streamMaxVolume = (i * 10) / this.mwB.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.mwj.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mwj.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dyq() && parserRet != null) {
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
                                    if (this.mwz != null && (this.mwz instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mwz).a(1, null, this.H, false, false, true);
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
            b.this.mwB.setStreamVolume(3, b.this.Ip(i), 0);
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
            b.this.mrQ = i / 10.0f;
            ((VideoPlayer) b.this.mwz).l = b.this.mrQ;
            ((VideoPlayer) b.this.mwz).k = b.this.mrQ * 255.0f;
            b.this.mrS.screenBrightness = b.this.mrQ;
            b.this.mrR.setAttributes(b.this.mrS);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mwD && motionEvent2.getRawY() <= this.mwD) {
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mwj.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mwj.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mpV.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mwj.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mwj.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.msP.getCurrentPos();
                            int duration = this.msP.getDuration();
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
                                this.mpV.setProgress(i3 / (duration / 1000));
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
        if (!this.mrT) {
            if (this.mrW.getVisibility() == 8 && (this.msi == null || !this.msi.isShown())) {
                boolean z = this.mwt != null && this.mwt.getVisibility() == 0;
                if (this.e) {
                    au(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                at(false, true);
                dyg();
            }
        }
        return false;
    }

    public boolean dxP() {
        if (this.mrT) {
            if (this.mxf != null) {
                this.mxf.e();
            }
            y(false);
            if (this.mrU != null) {
                this.mrU.setVisibility(0);
            }
            if (this.mqn != null) {
                this.mqn.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dxT() {
        super.dxT();
        if (this.mwz instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mwy != null) {
            this.mwy.f = null;
            if (this.mwy.dxv() != null) {
                this.mwy.dxv().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.msP != null) {
                this.msP.seekTo(0L);
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
            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                tv.chushou.zues.utils.g.c(this.mwz, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.msP.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.msA != null) {
                            this.msA.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mwy.a(false);
                            ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                        } else if (this.msP.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.msP.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.msP.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            we(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.msP.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.msP.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                tv.chushou.zues.utils.g.c(this.mwz, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mwy.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                    this.ai = false;
                    we(true);
                    a(false, !this.ak);
                } else if (this.msP.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
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
            if (this.mwy != null && this.mwy.dxz() != null) {
                str = this.mwy.dxz().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dwE().z != null && com.kascend.chushou.a.a.dwE().z.contains(str) && this.mwy != null && !this.msJ) {
            this.msJ = true;
            com.kascend.chushou.a.a.dwE().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.msJ = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.msA != null) {
            this.msA.a(listItem, this.ap == 1, a.C0715a.zues_sweetalert_modal_in, a.C0715a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.msJ = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.msa != null) {
                this.msa.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mwt != null) {
                this.mwt.setVisibility(8);
                return;
            }
            return;
        }
        if (this.msa != null) {
            this.msa.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mwt != null) {
                    this.mwt.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void aO() {
        this.N = new SurfaceView(this.mwz);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mwj).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mxn != null) {
            this.mxn.dJf();
            this.mxn.setVisibility(8);
            this.mxn.unInit();
            ((RelativeLayout) this.mwj).removeView(this.mxn);
            this.mxn = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mwj).removeView(this.N);
            this.N = null;
        }
        aO();
        ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
    }

    private void k(View view, int i, int i2) {
        if (this.mwA != null) {
            y(true);
            this.mwA.removeMessages(1);
            this.mrU.setVisibility(0);
            this.mrX.setVisibility(8);
            this.mqn.setVisibility(8);
            this.msh.setVisibility(8);
        }
        if (this.mwZ == null) {
            al();
            this.mwZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mqs.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mwZ.isShowing()) {
            this.mwZ.showAtLocation(view, 83, i, i2);
            this.mqs.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mwy.dxv().mRoominfo.mRoomID);
            return;
        }
        this.mwZ.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.msw != null && this.msw.b()) {
                this.msw.getGlobalVisibleRect(this.msL);
                if (!this.msL.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.msw.a();
                    return true;
                }
            }
            if (this.mrT && g(this.mxf.b, motionEvent)) {
                dxP();
                return true;
            }
            if (!dyf()) {
                if (System.currentTimeMillis() - this.msK < 300 && this.msA != null && this.msA.isShown()) {
                    this.msA.a();
                    if (this.msP.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mwy.a(false);
                            ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                        } else if (this.msP.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mwz).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.msP.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.msP.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            we(true);
                        }
                    }
                    return true;
                }
                this.msK = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dyg() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
        if (this.msi != null) {
            if (this.msi.isShown()) {
                this.msi.startAnimation(AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_top_anim));
            }
            this.msi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mwz).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mwz).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mwr != null) {
                this.mwr.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gn(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mrX.getLayoutParams();
                layoutParams.rightMargin -= this.msl;
                this.mrX.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mqn.getLayoutParams();
                layoutParams2.rightMargin -= this.msl;
                this.mqn.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mrW.getLayoutParams();
                layoutParams3.rightMargin -= this.msl;
                this.mrW.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mrU.getLayoutParams();
                layoutParams4.rightMargin -= this.msl;
                layoutParams4.bottomMargin += this.msl;
                this.mrU.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
            this.msp.setVisibility(0);
            if (this.mwy.dxv().mRoominfo.mIsSubscribed) {
                this.msp.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.msp.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.msp.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void aP() {
        RoomInfo roomInfo;
        if (this.mwy != null && this.mwy.dxv() != null && (roomInfo = this.mwy.dxv().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mwz, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dKx();
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
        if (this.mwy != null && this.mwy.dxv() != null && (roomInfo = this.mwy.dxv().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dyq()) {
                        b.this.t(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dyq()) {
                        b.this.t(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.F(b.this.mwz, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.mwz, a.i.subscribe_success);
                            }
                            if (b.this.mwy != null && b.this.mwy.dxv() != null && (roomInfo2 = b.this.mwy.dxv().mRoominfo) != null) {
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
                    if (!b.this.dyq()) {
                        b.this.t(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mwz, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mwz, str2);
                    }
                }
            };
            if (this.mwy != null && this.mwy.h != null) {
                try {
                    str = new JSONObject(this.mwy.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dwG().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dwG().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.msq == null) {
                this.msq = new ProgressDialog(this.mwz);
                this.msq.setProgressStyle(0);
                this.msq.requestWindowFeature(1);
                this.msq.setMessage(this.mwz.getText(a.i.update_userinfo_ing));
                this.msq.setCancelable(true);
            }
            if (!this.msq.isShowing()) {
                this.msq.show();
            }
        } else if (this.msq != null && this.msq.isShowing()) {
            this.msq.dismiss();
        }
    }

    private void dxL() {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
            if (this.mss == null) {
                this.mss = new f(getActivity());
            }
            this.mss.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mss = null;
                }
            });
            RoomInfo roomInfo = this.mwy.dxv().mRoominfo;
            this.mss.a();
            this.mss.a(roomInfo);
            if (!this.mss.isShowing()) {
                this.mss.show();
            }
        }
    }

    private void dxN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.msI != null && this.mwB != null && this.mwz != null && (this.mwz instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.msI;
            VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
            verticalSeekBarVolumn.setProgressOnly(Iq(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mpW != null) {
            this.mpW.dJZ();
        }
        if (this.mwj != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.msu == null) {
                this.msu = new com.kascend.chushou.player.ui.giftpopup.a(this.mwj, i);
            } else if (this.msu.a() != i) {
                this.msu.b();
                this.msu = null;
                this.msu = new com.kascend.chushou.player.ui.giftpopup.a(this.mwj, i);
            }
            List<ListItem> dxy = this.mwy != null ? this.mwy.dxy() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
            if (videoPlayer != null) {
                this.msu.a(dxy, videoPlayer.dxb(), videoPlayer.dxc(), videoPlayer.dxd(), videoPlayer.dxe());
                this.msu.a(this.e);
                if (this.mwy != null && this.mwy.mpC != null) {
                    this.msu.a(this.mwy.mpC, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mwy != null) {
                                b.this.mwy.mpC = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.msu != null && this.mwy != null) {
                    this.msu.b(this.mwy.mpE);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void a(int i) {
        if (this.msu != null && this.mwz != null) {
            this.msu.a(((VideoPlayer) this.mwz).dxb());
            this.msu.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void D() {
        if (this.mwz instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dxb = ((VideoPlayer) this.mwz).dxb();
            if (this.mxq == null) {
                this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxq.setVisibility(0);
            this.mxq.a(i, dxb);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.msu != null) {
            this.msu.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.msd != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.msd.setVisibility(0);
                    this.msd.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.msd.setVisibility(8);
                }
            }
            if (this.msb != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.msc.setVisibility(0);
                    this.msb.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.msc.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.msu != null) {
            this.msu.a(((VideoPlayer) this.mwz).dxc());
            this.msu.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.msu != null) {
            this.msu.a(((VideoPlayer) this.mwz).dxc());
            this.msu.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(long j) {
        if (this.msu != null) {
            this.msu.a(((VideoPlayer) this.mwz).dxd());
            this.msu.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0728a
    public void c(int i) {
        if (this.msu != null) {
            this.msu.a(((VideoPlayer) this.mwz).dxe());
            this.msu.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wd(false);
        super.F();
    }

    private void c(View view) {
        this.msB = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mqV = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mqV.setText(new tv.chushou.zues.widget.a.c().J(this.mwz, a.e.videoplayer_4g_video).append("  ").append(this.mwz.getString(a.i.videoplayer_4g_video)));
        this.msC = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.msC.setText(new tv.chushou.zues.widget.a.c().J(this.mwz, a.e.videoplayer_4g_audio).append("  ").append(this.mwz.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.aH();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mwz, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.msB.setVisibility(8);
                    ((VideoPlayer) b.this.mwz).c(b.this.mqX);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.msB.setVisibility(8);
                    ((VideoPlayer) b.this.mwz).d(b.this.mqX);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
        findViewById.setLayoutParams(layoutParams);
        this.mqV.setOnClickListener(onClickListener);
        this.msC.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mwy != null && !tv.chushou.zues.utils.h.isEmpty(this.mwy.f)) {
            f(this.mwy.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mqX = z;
            this.p = false;
            if (this.mwy != null && this.mwy.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mwy.f.size()) {
                        break;
                    } else if (!"2".equals(this.mwy.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.msB != null) {
                this.msB.setVisibility(0);
                this.mqV.setVisibility(0);
                this.msC.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.msB != null) {
            this.msB.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.msu != null && this.mwy != null) {
            this.msu.b(this.mwy.mpE);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mwj != null && (findViewById = this.mwj.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.msb != null) {
            this.msb.performClick();
        }
    }
}
