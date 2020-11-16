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
    private TextView pmH;
    private boolean pmJ;
    private LinearLayout pnL;
    private FrameLayout pnP;
    private FrescoThumbnailView pnQ;
    private ImageView pnT;
    private ImageView pnV;
    RelativeLayout pnZ;
    private ImageView poa;
    private ImageView poc;
    private f pod;
    private com.kascend.chushou.player.ui.giftpopup.a pof;
    private PopH5Menu poh;
    private com.kascend.chushou.player.b.a poj;
    private GiftAnimationLayout pok;
    private ImageView pol;
    private FoodView pom;
    private RelativeLayout pon;
    private TextView poo;
    private VerticalSeekBarVolumn pow;
    private Rect pnC = null;
    private Rect pnD = null;
    private float pnE = 0.0f;
    private Window pnF = null;
    private WindowManager.LayoutParams pnG = null;
    private boolean bB = false;
    private View pnH = null;
    private View plZ = null;
    private View pnI = null;
    private View pnJ = null;
    private View pnK = null;
    private ImageView pme = null;
    private ImageView pnM = null;
    private ImageButton pnN = null;
    private FrescoThumbnailView pnO = null;
    private LinearLayout pnR = null;
    private EditText pnS = null;
    private View pnU = null;
    private boolean pnW = false;
    private int pnX = 0;
    private int bV = 0;
    private long pnY = 0;
    private ProgressDialog pob = null;
    private boolean poe = true;
    private int pog = -1;
    private boolean poq = false;
    private TextView por = null;
    private TextView pot = null;
    private int pou = 0;
    private boolean pov = false;
    private boolean pox = false;
    private final Rect poy = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.psr = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.plH = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.prW = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.psl != null && !((Activity) this.psl).isFinishing()) {
            evw();
        }
        return this.prW;
    }

    public void euS() {
        aK(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.psl, "能量_num", "横屏", new Object[0]);
    }

    public boolean evf() {
        if (this.psU == null || !this.psU.isShown()) {
            return false;
        }
        this.psU.d();
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
        if (z3 || this.prW.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.psr)) {
            z = h.etY().e;
        } else {
            z = h.etY().b;
        }
        r(z);
        if (this.psQ != null) {
            this.psQ.b();
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
        if (this.pof != null) {
            this.pof.b();
            this.pof = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cu(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            euY();
            y();
            if (this.plH != null) {
                this.plH.onConfigurationChanged(configuration);
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
        if (this.poh != null && this.pog != i3) {
            this.poh.a();
            this.poh = null;
        }
        if (this.poh == null) {
            this.poh = (PopH5Menu) ((ViewStub) this.prW.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point hB = tv.chushou.zues.utils.a.hB(getActivity());
            if (this.ap == 0) {
                int i4 = hB.y;
                i = hB.y;
                i2 = i4;
            } else {
                int i5 = hB.x;
                int i6 = hB.y - ((hB.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.poh.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.poh.setLayoutParams(layoutParams);
            this.pog = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.f4233a = listItem.mUrl;
        h5Options.h = -1;
        this.poh.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!aa()) {
            if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                if (this.psl instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b eur = ((VideoPlayer) this.psl).eur();
                    if (this.ptc == null) {
                        this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.ptc.setVisibility(0);
                    this.ptc.a(i, eur);
                }
            } else if (bVar.f4152a == 3) {
                if (this.psl instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a eus = ((VideoPlayer) this.psl).eus();
                    if (this.ptc == null) {
                        this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.ptc.setVisibility(0);
                    this.ptc.a(i, eus);
                }
            } else if (bVar.f4152a == 9) {
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo euL;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.psk != null && mVar.b.equals(this.psk.f4119a) && (euL = this.psk.euL()) != null) {
            euL.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void evw() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.psr)) {
            this.psr = "1";
        }
        this.pnX = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
        this.bV = tv.chushou.zues.utils.systemBar.b.hG(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.poC = ((VideoPlayer) this.psl).euh();
        this.psk = ((VideoPlayer) this.psl).euk();
        c(this.prW);
        if (this.psr.equals("1")) {
            this.plF = ((VideoPlayer) this.psl).eul();
            this.plF.a(this);
            if (this.poj != null) {
                this.poj.a();
                this.poj = null;
                this.pok = null;
            }
            this.pok = (GiftAnimationLayout) this.prW.findViewById(a.f.ll_gift_animation);
            this.pok.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.psk != null) {
                this.poj = new com.kascend.chushou.player.b.a(this.psl.getApplicationContext(), this.pok);
                this.poj.a(this.psk);
            }
            this.B = (TextView) this.prW.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.psr.equals("3")) {
        }
        eva();
        if (this.plF != null) {
            this.plF.d();
        }
        evs();
        this.pnT = (ImageView) this.prW.findViewById(a.f.btn_lockscreen);
        this.pnT.setOnClickListener(this);
        if (this.f4123a == null) {
            this.f4123a = (ImageButton) this.prW.findViewById(a.f.resumebutton);
            this.f4123a.setOnTouchListener(this);
        }
        this.psf = (PlayerErrorView) this.prW.findViewById(a.f.view_net_error_msg);
        this.psf.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        edU();
        this.psU = (PaoGuideView) this.prW.findViewById(a.f.rlPaoGuideView);
        this.pol = (ImageView) this.prW.findViewById(a.f.iv_send_danmu);
        this.pnK = this.prW.findViewById(a.f.rt_layout);
        this.pnO = (FrescoThumbnailView) this.pnK.findViewById(a.f.btn_gift);
        this.pnP = (FrameLayout) this.pnK.findViewById(a.f.flfl_bottom_gift);
        this.pnQ = (FrescoThumbnailView) this.pnK.findViewById(a.f.btn_recharge);
        this.pnQ.setOnClickListener(this);
        a(this.psk == null ? null : this.psk.plp);
        this.pta = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.psm != null) {
                    b.this.psm.removeMessages(1);
                    b.this.psm.D(1, 5000L);
                }
                b.this.pnT.setVisibility(0);
                b.this.pnK.setVisibility(0);
                b.this.plZ.setVisibility(0);
                b.this.pnH.setVisibility(0);
                if (b.this.pof != null) {
                    b.this.pof.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.psl, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.pnT.setVisibility(8);
                b.this.pnK.setVisibility(8);
                if (b.this.pof != null) {
                    b.this.pof.a(false);
                }
                b.this.plZ.setVisibility(8);
                b.this.pnH.setVisibility(8);
                if (b.this.psm != null) {
                    b.this.psm.removeMessages(1);
                }
                if (b.this.psQ != null) {
                    b.this.psQ.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.psl, 14.0f) + b.this.psQ.getMeasuredHeight(), 12);
                }
            }
        };
        this.pnR = (LinearLayout) this.prW.findViewById(a.f.rl_seekbar);
        this.pnZ = (RelativeLayout) this.prW.findViewById(a.f.rl_paoicon);
        this.pnZ.setOnClickListener(this);
        this.psR = (RoundProgressBar) this.prW.findViewById(a.f.roundProgressBar);
        this.psT = (FrescoThumbnailView) this.prW.findViewById(a.f.iv_paoicon);
        this.psS = (TextView) this.prW.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.psV = 0L;
        com.kascend.chushou.player.ui.a.a euu = ((VideoPlayer) this.psl).euu();
        a(euu.evO());
        BangInfo evP = euu.evP();
        if (evP != null) {
            a(evP, euu.d());
        }
        if (this.psr.equals("3")) {
            this.pnR.setVisibility(0);
            this.pnP.setVisibility(8);
            this.pol.setVisibility(0);
            this.pol.setOnClickListener(this);
        } else {
            this.pol.setVisibility(8);
            this.pnR.setVisibility(8);
            this.pnP.setVisibility(0);
            this.pnO.setOnClickListener(this);
        }
        euW();
        if (tv.chushou.zues.utils.systemBar.b.hH(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pnK.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.pnK.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.plZ.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.plZ.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pnJ.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.pnJ.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.pnH.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.pnH.setLayoutParams(layoutParams4);
        }
        evy();
        aG();
        euY();
        this.h = (TextView) this.prW.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.prW.findViewById(a.f.time_seekbar_relative);
        if (!this.psr.equals("3")) {
            if (this.psk.euJ() != null) {
                this.poc.setVisibility(0);
            } else {
                this.poc.setVisibility(8);
            }
        }
        evx();
        n();
        k(100);
        this.pom = (FoodView) this.prW.findViewById(a.f.kav_room_ad);
        this.psm = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aK(false, true);
                            break;
                        case 2:
                            b.this.psm.removeMessages(2);
                            if (b.this.pnT != null) {
                                b.this.pnT.setVisibility(8);
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
                            TextView textView = (TextView) b.this.prW.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.psl.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.psm.D(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.psm.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.psm.D(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aJ(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.psl).q) {
                                b.this.a(b.this.psm);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.psl).q) {
                                b.this.b(b.this.psm);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.psl).g = true;
                            b.this.poC.seekTo((int) b.this.osZ);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.psk.d()) {
                                b.this.poC.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.poC.getPlayState() == 4) {
                                int currentPos = b.this.poC.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.psm != null) {
                                    b.this.psm.D(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.evJ();
                            break;
                        case 18:
                            b.this.aq();
                            break;
                        case 19:
                            b.this.psj.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.psk != null) {
            a(this.psk.euK());
        }
        if (this.poC != null && (this.poC.getPlayState() == 3 || this.poC.getPlayState() == 4)) {
            AM(false);
            if (this.psk.d()) {
                this.ak = false;
                AN(true);
                if (this.poC.getDuration() > 60000) {
                    if (this.poC.getDuration() < 300000) {
                        this.psp = 60000;
                    } else {
                        this.psp = Math.min(this.poC.getDuration(), 300000);
                    }
                } else {
                    this.psp = this.poC.getDuration();
                }
            }
            this.e = false;
            aK(true, false);
            this.psm.Sv(8);
            if (h() && this.poC.getPlayState() == 4 && this.psm != null) {
                this.psm.removeMessages(15);
                this.psm.Sv(15);
            }
        } else {
            AM(true);
            if (this.e) {
                aK(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] etX = g.etX();
            int i = etX.length == 2 ? etX[1] : 0;
            if (i > 0) {
                View findViewById = this.prW.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.psl, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.prW.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.psl, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.psl, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.psl != null && (this.psl instanceof VideoPlayer)) {
            ((VideoPlayer) this.psl).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.pnQ.Ev(a.e.ic_recharge_old);
            this.pnO.Ev(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.poq && !this.k) {
            try {
                if (this.poC != null) {
                    i = this.poC.getCurrentPos();
                    i2 = this.poC.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.plG.setProgress(i / (i2 / 1000));
                    this.por.setText(tv.chushou.zues.utils.b.v(this.poC.getDuration(), false));
                    this.pot.setText(tv.chushou.zues.utils.b.v(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void evx() {
        this.plG = (ProgressBar) this.prW.findViewById(a.f.progressBarl);
        if (this.plG != null) {
            if (this.plG instanceof SeekBar) {
                ((SeekBar) this.plG).setOnSeekBarChangeListener(new C0998b());
            }
            this.plG.setMax(1000);
        }
        this.por = (TextView) this.prW.findViewById(a.f.tv_time_duration);
        this.pot = (TextView) this.prW.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.prW.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.prW.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a euu;
        BangInfo evP;
        if (config != null) {
            this.psX = config;
            if (!config.display) {
                this.pnZ.setVisibility(8);
            } else if ((this.psl instanceof VideoPlayer) && (evP = (euu = ((VideoPlayer) this.psl).euu()).evP()) != null) {
                a(evP, euu.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.psX == null || this.psX.display) && this.pnZ != null) {
            this.pnZ.setVisibility(0);
            this.psS.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.psl instanceof VideoPlayer) {
            if ((this.psX == null || this.psX.display) && this.pnZ != null) {
                if (j > 0) {
                    this.pnZ.setVisibility(0);
                    boolean z = this.psW;
                    this.psW = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.psl.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.psS.setText(cVar);
                    return;
                }
                this.psW = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0998b implements SeekBar.OnSeekBarChangeListener {
        C0998b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.prX != null) {
                if (b.this.pou != i || b.this.pov != z) {
                    b.this.pou = i;
                    b.this.pov = z;
                    if (z) {
                        if (b.this.poq) {
                            b.this.osZ = (b.this.poC.getDuration() / 1000) * i;
                        }
                        b.this.pot.setText(tv.chushou.zues.utils.b.v((int) b.this.osZ, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.v((int) b.this.osZ, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.v(((int) b.this.osZ) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.poq = true;
            b.this.m = b.this.poC.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.psm != null) {
                if (b.this.poq) {
                    b.this.poq = false;
                }
                b.this.psm.removeMessages(14);
                b.this.psm.Sv(14);
            }
        }
    }

    private void k(int i) {
        this.plG.setSecondaryProgress((i * 1000) / 100);
    }

    private void evs() {
        this.pow = (VerticalSeekBarVolumn) this.prW.findViewById(a.f.volumn_seekbar);
        this.pow.setOnSeekBarChangeListener(new c());
        int streamVolume = this.psn.getStreamVolume(3);
        this.pow.setProgress(Ri(streamVolume));
        x(Ri(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.prW.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.plD = new d.a();
            this.c = new GestureDetector(this.psl, this.plD);
        }
    }

    private void evy() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.pnF == null) {
                this.pnF = ((Activity) this.psl).getWindow();
            }
            this.pnG = this.pnF.getAttributes();
            this.pnE = ((VideoPlayer) this.psl).k / 255.0f;
            ((VerticalSeekBarVolumn) this.prW.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.pnE));
        }
    }

    private void aG() {
        this.prW.findViewById(a.f.btn_send).setOnClickListener(this);
        this.prW.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.psl.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.prW.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.pnS == null) {
            this.pnS = (EditText) this.prW.findViewById(a.f.et_input);
            this.pnS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.prW.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euV() {
        if (this.pod != null) {
            this.pod.dismiss();
            this.pod = null;
        }
        if (this.psl != null) {
            ((VideoPlayer) this.psl).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.plZ = this.prW.findViewById(a.f.topview);
        this.pnL = (LinearLayout) this.prW.findViewById(a.f.topRight);
        this.pnI = this.plZ.findViewById(a.f.rl_download);
        this.pnJ = this.prW.findViewById(a.f.topKeyboardView);
        this.prW.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.plZ.getVisibility() == 0;
        if (this.pnX > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.plZ.getLayoutParams();
            layoutParams.topMargin = this.pnX;
            this.plZ.setLayoutParams(layoutParams);
        }
        this.prW.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.prW.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                str = this.psk.euJ().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.prW.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.poa = (ImageView) this.prW.findViewById(a.f.subscribe_icon);
        this.poa.setOnClickListener(this);
        this.poc = (ImageView) this.prW.findViewById(a.f.report_icon);
        this.poc.setOnClickListener(this);
        q();
    }

    private void euW() {
        boolean z;
        this.pnH = this.prW.findViewById(a.f.bottomview);
        this.pnN = (ImageButton) this.pnH.findViewById(a.f.playbutton);
        this.pnN.setOnTouchListener(this);
        this.psc = (ImageButton) this.prW.findViewById(a.f.btn_barrage);
        this.psd = (ImageButton) this.prW.findViewById(a.f.btn_audio);
        this.pnV = (ImageView) this.prW.findViewById(a.f.iv_danmu);
        if (!this.psr.equals("3")) {
            this.pnH.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.pnH.findViewById(a.f.btn_refresh).setVisibility(0);
            this.psc.setVisibility(0);
            this.pnV.setVisibility(8);
            if (this.psk != null && this.psk.f != null) {
                for (int i = 0; i < this.psk.f.size(); i++) {
                    if ("2".equals(this.psk.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.psd.setVisibility(0);
            } else {
                this.psd.setVisibility(8);
            }
            this.pnH.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.psc.setOnClickListener(this);
            if (h.etY().e) {
                this.psc.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.psc.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.psk.d) {
                this.psd.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.psd.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.psd.setOnClickListener(this);
            this.pme = (ImageView) this.pnH.findViewById(a.f.btn_hotword);
            this.pnM = (ImageView) this.prW.findViewById(a.f.iv_task_badge);
            this.pme.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.psl, a.C0991a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.etY().c) {
                        b.this.pme.clearAnimation();
                        b.this.pme.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.pme.clearAnimation();
            if (h.etY().c) {
                this.pme.startAnimation(animationSet);
                this.pnM.setVisibility(0);
            }
        } else {
            this.pnH.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.pnH.findViewById(a.f.btn_refresh).setVisibility(8);
            this.psc.setVisibility(8);
            this.psd.setVisibility(8);
            this.pnV.setVisibility(0);
            this.pnV.setOnClickListener(this);
            if (h.etY().b) {
                this.pnV.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pnV.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.pnH.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.psl != null) {
            ((VideoPlayer) this.psl).e(true);
        }
        if (this.psm != null) {
            this.psm.ct(null);
            this.psm = null;
        }
        this.c = null;
        this.plD = null;
        this.pnT = null;
        if (this.pnS != null) {
            this.pnS.addTextChangedListener(null);
            this.pnS.setOnEditorActionListener(null);
            this.pnS = null;
        }
        this.plZ = null;
        this.psc = null;
        this.psd = null;
        this.pnH = null;
        this.pnK = null;
        if (this.poj != null) {
            this.poj.a();
            this.poj = null;
            this.pok = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a evo() {
        return this.poj;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.prW == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.ptc == null || !this.ptc.a(i, keyEvent)) {
                    if ((this.poh == null || !this.poh.onKeyDown(i, keyEvent)) && !evf() && !euU()) {
                        if (this.pnJ != null && this.pnJ.getVisibility() == 0) {
                            aJ(false, true);
                            return true;
                        } else if (this.pnU != null && this.pnU.isShown()) {
                            aB();
                            return true;
                        } else if (this.pnW && this.psm != null) {
                            if (this.pnT != null) {
                                this.pnT.setVisibility(0);
                            }
                            this.psm.removeMessages(2);
                            this.psm.D(2, IMConnection.RETRY_DELAY_TIMES);
                            return true;
                        } else {
                            euV();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.prW.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.prW.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.psm != null) {
                    this.psm.removeMessages(3);
                    this.psm.D(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean evz() {
        if (this.pnW) {
            this.pnT.setVisibility(0);
            this.psm.removeMessages(2);
            this.psm.D(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.pnW;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.pnW) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.pnT.setVisibility(0);
            this.psm.removeMessages(2);
            this.psm.D(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.d(this.psl, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aI(getActivity()) && tv.chushou.zues.utils.systemBar.b.aJ(getActivity())) {
                    p(view, tv.chushou.zues.utils.systemBar.b.hG(getActivity()), 0);
                    return;
                } else {
                    p(view, 0, 0);
                    return;
                }
            }
            p(view, 0, this.plZ.getHeight() + this.plZ.getTop());
        } else if (id == a.f.btn_send) {
            if (this.psr.equals("3")) {
                String trim = this.pnS.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.O(this.psl, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.pnS.setText((CharSequence) null);
                aJ(false, true);
            } else if (a(this.pnS.getText().toString(), false)) {
                aJ(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                q(view, tv.chushou.zues.utils.systemBar.b.hG(getActivity()), 0);
            } else {
                q(view, 0, tv.chushou.zues.utils.a.dip2px(this.psl, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            q(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            euV();
            com.kascend.chushou.toolkit.a.c.a(this.psl, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = evG() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.psQ == null;
                b(false, false);
                if (z && this.bV > 0 && this.psQ != null && tv.chushou.zues.utils.systemBar.b.aI(getActivity()) && tv.chushou.zues.utils.systemBar.b.aJ(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.psQ.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.psQ.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.psQ == null;
                if (this.psl.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.psQ != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.psQ.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.psQ.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.psl, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.psk.euJ().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aJ(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aK(false, false);
            this.psm.D(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.etY().c) {
                h.etY().b(false);
                this.pme.clearAnimation();
                this.pnM.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                n(view, this.pnH.findViewById(a.f.ll_keyboard).getLeft(), this.pnH.getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
            } else {
                n(view, this.pnH.findViewById(a.f.ll_keyboard).getLeft(), this.pnH.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                tv.chushou.zues.utils.g.d(this.psl, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.psl).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.psl, evG(), false);
        } else if (id == a.f.btn_screenChange) {
            euV();
        } else if (id == a.f.rl_paoicon) {
            euS();
        } else if (id == a.f.subscribe_icon) {
            evb();
        } else if (id == a.f.report_icon) {
            if (this.psr.equals("3")) {
                eve();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                evc();
            }
        } else if (id == a.f.btn_audio && !this.psk.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.SE(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.pnY <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.SE(a.i.str_too_fast);
            return false;
        } else {
            if (!h.etY().e) {
                s(true);
                vA();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
            if (com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a(((VideoPlayer) this.psl).euk().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.pnY = System.currentTimeMillis();
                a(this.psk.euJ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.psk.h);
                if (!z) {
                    this.pnS.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.psr.equals("3")) {
            if (this.psc != null) {
                if (z) {
                    this.psc.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.psc.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.pnV != null) {
            if (z) {
                this.pnV.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pnV.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout evd() {
        if (this.prW == null) {
            return null;
        }
        return (GiftAnimationLayout) this.prW.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.psY != null) {
            this.psY.setVisibility(z ? 0 : 8);
            if (!z) {
                this.psY.eHb();
            }
        }
        tv.chushou.zues.utils.g.B(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.psk.d()) {
            if (this.pnW) {
                this.pnT.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.d(this.psl, this.psl.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.pnT.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.d(this.psl, this.psl.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.pnW = !this.pnW;
            if (this.pnS != null) {
                this.pnS.setEnabled(this.pnW ? false : true);
            }
        }
    }

    public void aJ(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bG(this.pnS);
            this.pnS.setText("");
            this.pnK.setVisibility(8);
            this.pnT.setVisibility(8);
            this.plZ.setVisibility(8);
            this.pnH.setVisibility(8);
            this.pnJ.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
        if (this.pnJ.getVisibility() != 8 && z2) {
            this.pnJ.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_top_anim));
        }
        this.pnK.setVisibility(8);
        this.pnT.setVisibility(8);
        this.plZ.setVisibility(8);
        this.pnH.setVisibility(8);
        this.pnJ.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aK(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.pnL != null) {
            this.pnL.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aK(boolean z, boolean z2) {
        return m(z, z2, false);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.pof != null) {
                this.pof.a(this.e);
            }
            return this.e;
        }
        if (this.psm != null) {
            this.psm.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.psl).e(true);
            if (!z3) {
                if (this.pnH.getVisibility() != 0 && z2) {
                    this.pnH.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_bottom_anim));
                }
                this.pnH.setVisibility(0);
                this.pnK.setVisibility(0);
                this.pnT.setVisibility(0);
                this.pnI.setVisibility(o() ? 0 : 8);
            }
            if (this.plZ.getVisibility() != 0 && z2) {
                this.plZ.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_top_anim));
            }
            u(!z3);
            this.plZ.setVisibility(0);
            if (this.psm != null) {
                this.psm.D(1, 5000L);
            }
            y(false);
            if (this.pof != null) {
                this.pof.a(true);
            }
        } else {
            ((VideoPlayer) this.psl).e(false);
            if (this.psD != null) {
                this.psD.dismiss();
            }
            if (this.psE != null) {
                this.psE.dismiss();
            }
            if (this.psL != null) {
                this.psL.dismiss();
            }
            if (this.pnH != null) {
                if (this.pnH.getVisibility() != 8 && z2) {
                    this.pnH.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_bottom_anim));
                }
                this.pnH.setVisibility(8);
            }
            if (this.pnK != null) {
                this.pnK.setVisibility(8);
                if (this.plZ.getVisibility() != 8 && z2) {
                    this.plZ.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_top_anim));
                }
                this.plZ.setVisibility(8);
                this.pnT.setVisibility(8);
                y(true);
                a(false);
                if (this.pof != null) {
                    this.pof.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void euY() {
        Point hB = tv.chushou.zues.utils.a.hB(this.psl);
        if (this.ap == 1) {
            this.ar = Math.min(hB.x, hB.y);
            this.aq = Math.max(hB.x, hB.y);
        } else {
            this.ar = Math.max(hB.x, hB.y);
            this.aq = Math.min(hB.x, hB.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.pnC == null) {
            this.pnC = new Rect(0, 0, i / 5, i2);
        } else {
            this.pnC.set(0, 0, i / 5, i2);
        }
        if (this.pnD == null) {
            this.pnD = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.pnD.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.pnC == null) {
            return false;
        }
        return this.pnC.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.prW.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.prW.findViewById(a.f.brightness_view);
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

    private boolean aq(MotionEvent motionEvent) {
        if (this.pnD == null) {
            return false;
        }
        return this.pnD.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.prW.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.prW.findViewById(a.f.volumn_view);
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
                if (this.pnW) {
                    this.pnT.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.pnW) {
                    this.psm.removeMessages(2);
                    this.psm.D(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.psm != null) {
                    this.psm.D(3, 1000L);
                    this.psm.D(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.pnW) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gR(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.psn.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.psl;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Ri(int i) {
        int streamMaxVolume = (i * 10) / this.psn.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.prW.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.prW.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.psl != null && (this.psl instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.psl).a(1, null, this.H, false, false, true);
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
            b.this.psn.setStreamVolume(3, b.this.gR(i), 0);
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
            b.this.pnE = i / 10.0f;
            ((VideoPlayer) b.this.psl).l = b.this.pnE;
            ((VideoPlayer) b.this.psl).k = b.this.pnE * 255.0f;
            b.this.pnG.screenBrightness = b.this.pnE;
            b.this.pnF.setAttributes(b.this.pnG);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.prW.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (aq(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.prW.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.psp > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.plG.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.prW.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.prW.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.poC.getCurrentPos();
                            int duration = this.poC.getDuration();
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
                            this.h.setText(tv.chushou.zues.utils.b.v(i3, false));
                            this.i.setText(tv.chushou.zues.utils.b.v(this.j, true));
                            if (duration > 1000) {
                                this.plG.setProgress(i3 / (duration / 1000));
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
            if (this.pnJ.getVisibility() == 8 && (this.pnU == null || !this.pnU.isShown())) {
                boolean z = this.psf != null && this.psf.getVisibility() == 0;
                if (this.e) {
                    aK(false, true);
                } else {
                    m(true, true, z);
                }
                aVar.d = 0;
            } else {
                aJ(false, true);
                aB();
            }
        }
        return false;
    }

    public boolean euU() {
        if (this.bB) {
            if (this.psQ != null) {
                this.psQ.e();
            }
            y(false);
            if (this.pnH != null) {
                this.pnH.setVisibility(0);
            }
            if (this.plZ != null) {
                this.plZ.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.psl instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.psl;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.psk != null) {
            this.psk.f = null;
            if (this.psk.euJ() != null) {
                this.psk.euJ().mRoominfo.mGameId = null;
            }
        }
        if (this.psr.equals("3")) {
            if (this.poC != null) {
                this.poC.seekTo(0L);
                e(true);
            }
            euV();
            return;
        }
        euV();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.pnW) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                tv.chushou.zues.utils.g.d(this.psl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.poC.getPlayState() == 4) {
                        euZ();
                        e(true);
                    } else {
                        if (this.pom != null) {
                            this.pom.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.psk.a(false);
                            ((VideoPlayer) this.psl).a(true, (Uri) null, false);
                        } else if (!this.psr.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                        } else if (this.poC.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.poC.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.poC.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            AN(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.poC.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.poC.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                tv.chushou.zues.utils.g.d(this.psl, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.psk.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.psl).a(true, (Uri) null, false);
                } else if (!this.psr.equals("3")) {
                    ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                    this.ai = false;
                    AN(true);
                    a(false, !this.ak);
                } else if (this.poC.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                    this.ai = false;
                    AN(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void euZ() {
        String str = null;
        if (!this.psr.equals("3")) {
            if (this.psk != null && this.psk.euL() != null) {
                str = this.psk.euL().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.etR().z != null && com.kascend.chushou.a.a.etR().z.contains(str) && this.psk != null && !this.pox) {
            this.pox = true;
            com.kascend.chushou.a.a.etR().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.pox = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.pom != null) {
            this.pom.a(listItem, this.ap == 1, a.C0991a.zues_sweetalert_modal_in, a.C0991a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.pox = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.pnN != null) {
                this.pnN.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4123a != null) {
                this.f4123a.setVisibility(8);
            }
            if (this.psf != null) {
                this.psf.setVisibility(8);
                return;
            }
            return;
        }
        if (this.pnN != null) {
            this.pnN.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4123a != null) {
            if (z2 != (this.f4123a.getVisibility() == 0)) {
                if (z2) {
                    this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4123a.setVisibility(0);
                    return;
                }
                this.f4123a.setVisibility(8);
                if (this.psf != null) {
                    this.psf.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void eva() {
        this.prX = new SurfaceView(this.psl);
        SurfaceView surfaceView = (SurfaceView) this.prX;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.prW).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void evj() {
        if (this.psY != null) {
            this.psY.eHb();
            this.psY.setVisibility(8);
            this.psY.unInit();
            ((RelativeLayout) this.prW).removeView(this.psY);
            this.psY = null;
        }
        if (this.prX != null) {
            this.prX.setVisibility(8);
            ((RelativeLayout) this.prW).removeView(this.prX);
            this.prX = null;
        }
        eva();
        ((VideoPlayer) this.psl).a(true, (Uri) null, false);
    }

    private void n(View view, int i, int i2) {
        if (this.psm != null) {
            y(true);
            this.psm.removeMessages(1);
            this.pnH.setVisibility(0);
            this.pnK.setVisibility(8);
            this.plZ.setVisibility(8);
            this.pnT.setVisibility(8);
        }
        if (this.psL == null) {
            al();
            this.psL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.pme.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.psL.isShowing()) {
            this.psL.showAtLocation(view, 83, i, i2);
            this.pme.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.psk.euJ().mRoominfo.mRoomID);
            return;
        }
        this.psL.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.poh != null && this.poh.b()) {
                this.poh.getGlobalVisibleRect(this.poy);
                if (!this.poy.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.poh.a();
                    return true;
                }
            }
            if (this.bB && f(this.psQ.b, motionEvent)) {
                euU();
                return true;
            }
            if (!evz()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.pom != null && this.pom.isShown()) {
                    this.pom.a();
                    if (this.poC.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.psk.a(false);
                            ((VideoPlayer) this.psl).a(true, (Uri) null, false);
                        } else if (!this.psr.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                        } else if (this.poC.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.psl).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.poC.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.poC.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            AN(true);
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
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
        if (this.pnU != null) {
            if (this.pnU.isShown()) {
                this.pnU.startAnimation(AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_top_anim));
            }
            this.pnU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.psl).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.psl).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.psd != null) {
                this.psd.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hH(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pnK.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.pnK.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.plZ.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.plZ.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pnJ.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.pnJ.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.pnH.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.pnH.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
            this.poa.setVisibility(0);
            if (this.psk.euJ().mRoominfo.mIsSubscribed) {
                this.poa.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.poa.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.poa.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void evb() {
        RoomInfo roomInfo;
        if (this.psk != null && this.psk.euJ() != null && (roomInfo = this.psk.euJ().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.psl, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.eIq();
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
        if (this.psk != null && this.psk.euJ() != null && (roomInfo = this.psk.euJ().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.O(b.this.psl, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.O(b.this.psl, a.i.subscribe_success);
                            }
                            if (b.this.psk != null && b.this.psk.euJ() != null && (roomInfo2 = b.this.psk.euJ().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.psl, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.d(b.this.psl, str2);
                    }
                }
            };
            if (this.psk != null && this.psk.h != null) {
                try {
                    str = new JSONObject(this.psk.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.etT().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.etT().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.pob == null) {
                this.pob = new ProgressDialog(this.psl);
                this.pob.setProgressStyle(0);
                this.pob.requestWindowFeature(1);
                this.pob.setMessage(this.psl.getText(a.i.update_userinfo_ing));
                this.pob.setCancelable(true);
            }
            if (!this.pob.isShowing()) {
                this.pob.show();
            }
        } else if (this.pob != null && this.pob.isShowing()) {
            this.pob.dismiss();
        }
    }

    private void evc() {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
            if (this.pod == null) {
                this.pod = new f(getActivity());
            }
            this.pod.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.pod = null;
                }
            });
            RoomInfo roomInfo = this.psk.euJ().mRoominfo;
            this.pod.a();
            this.pod.a(roomInfo);
            if (!this.pod.isShowing()) {
                this.pod.show();
            }
        }
    }

    private void eve() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.pow != null && this.psn != null && this.psl != null && (this.psl instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.pow;
            VideoPlayer videoPlayer = (VideoPlayer) this.psl;
            verticalSeekBarVolumn.setProgressOnly(Ri(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.plH != null) {
            this.plH.eHU();
        }
        if (this.prW != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.pof == null) {
                this.pof = new com.kascend.chushou.player.ui.giftpopup.a(this.prW, i);
            } else if (this.pof.a() != i) {
                this.pof.b();
                this.pof = null;
                this.pof = new com.kascend.chushou.player.ui.giftpopup.a(this.prW, i);
            }
            List<ListItem> j = this.psk != null ? this.psk.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.psl;
            if (videoPlayer != null) {
                this.pof.a(j, videoPlayer.euq(), videoPlayer.eur(), videoPlayer.eus(), videoPlayer.eut());
                this.pof.a(this.e);
                if (this.psk != null && this.psk.pln != null) {
                    this.pof.a(this.psk.pln, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.psk != null) {
                                b.this.psk.pln = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.pof != null && this.psk != null) {
                    this.pof.b(this.psk.plq);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void a(int i) {
        if (this.pof != null && this.psl != null) {
            this.pof.a(((VideoPlayer) this.psl).euq());
            this.pof.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void D() {
        if (this.psl instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a euq = ((VideoPlayer) this.psl).euq();
            if (this.ptc == null) {
                this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.ptc.setVisibility(0);
            this.ptc.a(i, euq);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.pof != null) {
            this.pof.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.pnQ != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.pnQ.setVisibility(0);
                    this.pnQ.cd(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.pnQ.setVisibility(8);
                }
            }
            if (this.pnO != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.pnP.setVisibility(0);
                    this.pnO.cd(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.pnP.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pof != null) {
            this.pof.a(((VideoPlayer) this.psl).eur());
            this.pof.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pof != null) {
            this.pof.a(((VideoPlayer) this.psl).eur());
            this.pof.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(long j) {
        if (this.pof != null) {
            this.pof.a(((VideoPlayer) this.psl).eus());
            this.pof.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1004a
    public void c(int i) {
        if (this.pof != null) {
            this.pof.a(((VideoPlayer) this.psl).eut());
            this.pof.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        AM(false);
        super.F();
    }

    private void c(View view) {
        this.pon = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.pmH = (TextView) view.findViewById(a.f.tv_4g_video);
        this.pmH.setText(new tv.chushou.zues.widget.a.c().R(this.psl, a.e.videoplayer_4g_video).append("  ").append(this.psl.getString(a.i.videoplayer_4g_video)));
        this.poo = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.poo.setText(new tv.chushou.zues.widget.a.c().R(this.psl, a.e.videoplayer_4g_audio).append("  ").append(this.psl.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.euV();
                    com.kascend.chushou.toolkit.a.c.a(b.this.psl, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.pon.setVisibility(8);
                    ((VideoPlayer) b.this.psl).c(b.this.pmJ);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.pon.setVisibility(8);
                    ((VideoPlayer) b.this.psl).d(b.this.pmJ);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
        findViewById.setLayoutParams(layoutParams);
        this.pmH.setOnClickListener(onClickListener);
        this.poo.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.psk != null && !tv.chushou.zues.utils.h.isEmpty(this.psk.f)) {
            g(this.psk.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.pmJ = z;
            this.p = false;
            if (this.psk != null && this.psk.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.psk.f.size()) {
                        break;
                    } else if (!"2".equals(this.psk.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.pon != null) {
                this.pon.setVisibility(0);
                this.pmH.setVisibility(0);
                this.poo.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.pon != null) {
            this.pon.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pof != null && this.psk != null) {
            this.pof.b(this.psk.plq);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.prW != null && (findViewById = this.prW.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pnO != null) {
            this.pnO.performClick();
        }
    }
}
