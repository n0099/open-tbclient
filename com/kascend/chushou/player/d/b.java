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
    private TextView okq;
    private boolean oks;
    private ImageView olC;
    private ImageView olE;
    RelativeLayout olI;
    private ImageView olJ;
    private ImageView olL;
    private f olM;
    private com.kascend.chushou.player.ui.giftpopup.a olO;
    private PopH5Menu olQ;
    private com.kascend.chushou.player.b.a olR;
    private GiftAnimationLayout olS;
    private ImageView olT;
    private FoodView olU;
    private RelativeLayout olV;
    private TextView olW;
    private LinearLayout olu;
    private FrameLayout oly;
    private FrescoThumbnailView olz;
    private VerticalSeekBarVolumn omc;
    private Rect oll = null;
    private Rect olm = null;
    private float oln = 0.0f;
    private Window olo = null;
    private WindowManager.LayoutParams olp = null;
    private boolean bB = false;
    private View olq = null;
    private View ojI = null;
    private View olr = null;
    private View ols = null;
    private View olt = null;
    private ImageView ojN = null;
    private ImageView olv = null;
    private ImageButton olw = null;
    private FrescoThumbnailView olx = null;
    private LinearLayout olA = null;
    private EditText olB = null;
    private View olD = null;
    private boolean olF = false;
    private int olG = 0;
    private int bV = 0;
    private long olH = 0;
    private ProgressDialog olK = null;
    private boolean olN = true;
    private int olP = -1;
    private boolean olX = false;
    private TextView olY = null;
    private TextView olZ = null;
    private int oma = 0;
    private boolean omb = false;
    private boolean omd = false;
    private final Rect ome = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.opY = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.ojq = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.opD = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.opS != null && !((Activity) this.opS).isFinishing()) {
            ehH();
        }
        return this.opD;
    }

    public void ehd() {
        aG(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.opS, "能量_num", "横屏", new Object[0]);
    }

    public boolean ehq() {
        if (this.oqB == null || !this.oqB.isShown()) {
            return false;
        }
        this.oqB.d();
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
        if (z3 || this.opD.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.opY)) {
            z = h.egj().e;
        } else {
            z = h.egj().b;
        }
        r(z);
        if (this.oqx != null) {
            this.oqx.b();
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
        if (this.olO != null) {
            this.olO.b();
            this.olO = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cp(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            ehj();
            y();
            if (this.ojq != null) {
                this.ojq.onConfigurationChanged(configuration);
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
        if (this.olQ != null && this.olP != i3) {
            this.olQ.a();
            this.olQ = null;
        }
        if (this.olQ == null) {
            this.olQ = (PopH5Menu) ((ViewStub) this.opD.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point hj = tv.chushou.zues.utils.a.hj(getActivity());
            if (this.ap == 0) {
                int i4 = hj.y;
                i = hj.y;
                i2 = i4;
            } else {
                int i5 = hj.x;
                int i6 = hj.y - ((hj.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.olQ.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.olQ.setLayoutParams(layoutParams);
            this.olP = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.f4233a = listItem.mUrl;
        h5Options.h = -1;
        this.olQ.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.opS instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b egC = ((VideoPlayer) this.opS).egC();
                    if (this.oqJ == null) {
                        this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.oqJ.setVisibility(0);
                    this.oqJ.a(i, egC);
                }
            } else if (bVar.f4152a == 3) {
                if (this.opS instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a egD = ((VideoPlayer) this.opS).egD();
                    if (this.oqJ == null) {
                        this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.oqJ.setVisibility(0);
                    this.oqJ.a(i, egD);
                }
            } else if (bVar.f4152a == 9) {
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo egW;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.opR != null && mVar.b.equals(this.opR.f4119a) && (egW = this.opR.egW()) != null) {
            egW.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void ehH() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.opY)) {
            this.opY = "1";
        }
        this.olG = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
        this.bV = tv.chushou.zues.utils.systemBar.b.ho(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.omi = ((VideoPlayer) this.opS).egs();
        this.opR = ((VideoPlayer) this.opS).egv();
        c(this.opD);
        if (this.opY.equals("1")) {
            this.ojo = ((VideoPlayer) this.opS).egw();
            this.ojo.a(this);
            if (this.olR != null) {
                this.olR.a();
                this.olR = null;
                this.olS = null;
            }
            this.olS = (GiftAnimationLayout) this.opD.findViewById(a.f.ll_gift_animation);
            this.olS.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.opR != null) {
                this.olR = new com.kascend.chushou.player.b.a(this.opS.getApplicationContext(), this.olS);
                this.olR.a(this.opR);
            }
            this.B = (TextView) this.opD.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.opY.equals("3")) {
        }
        ehl();
        if (this.ojo != null) {
            this.ojo.d();
        }
        ehD();
        this.olC = (ImageView) this.opD.findViewById(a.f.btn_lockscreen);
        this.olC.setOnClickListener(this);
        if (this.f4123a == null) {
            this.f4123a = (ImageButton) this.opD.findViewById(a.f.resumebutton);
            this.f4123a.setOnTouchListener(this);
        }
        this.opM = (PlayerErrorView) this.opD.findViewById(a.f.view_net_error_msg);
        this.opM.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        dUv();
        this.oqB = (PaoGuideView) this.opD.findViewById(a.f.rlPaoGuideView);
        this.olT = (ImageView) this.opD.findViewById(a.f.iv_send_danmu);
        this.olt = this.opD.findViewById(a.f.rt_layout);
        this.olx = (FrescoThumbnailView) this.olt.findViewById(a.f.btn_gift);
        this.oly = (FrameLayout) this.olt.findViewById(a.f.flfl_bottom_gift);
        this.olz = (FrescoThumbnailView) this.olt.findViewById(a.f.btn_recharge);
        this.olz.setOnClickListener(this);
        a(this.opR == null ? null : this.opR.oiY);
        this.oqH = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.opT != null) {
                    b.this.opT.removeMessages(1);
                    b.this.opT.D(1, 5000L);
                }
                b.this.olC.setVisibility(0);
                b.this.olt.setVisibility(0);
                b.this.ojI.setVisibility(0);
                b.this.olq.setVisibility(0);
                if (b.this.olO != null) {
                    b.this.olO.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.opS, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.olC.setVisibility(8);
                b.this.olt.setVisibility(8);
                if (b.this.olO != null) {
                    b.this.olO.a(false);
                }
                b.this.ojI.setVisibility(8);
                b.this.olq.setVisibility(8);
                if (b.this.opT != null) {
                    b.this.opT.removeMessages(1);
                }
                if (b.this.oqx != null) {
                    b.this.oqx.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.opS, 14.0f) + b.this.oqx.getMeasuredHeight(), 12);
                }
            }
        };
        this.olA = (LinearLayout) this.opD.findViewById(a.f.rl_seekbar);
        this.olI = (RelativeLayout) this.opD.findViewById(a.f.rl_paoicon);
        this.olI.setOnClickListener(this);
        this.oqy = (RoundProgressBar) this.opD.findViewById(a.f.roundProgressBar);
        this.oqA = (FrescoThumbnailView) this.opD.findViewById(a.f.iv_paoicon);
        this.oqz = (TextView) this.opD.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.oqC = 0L;
        com.kascend.chushou.player.ui.a.a egF = ((VideoPlayer) this.opS).egF();
        a(egF.ehZ());
        BangInfo eia = egF.eia();
        if (eia != null) {
            a(eia, egF.d());
        }
        if (this.opY.equals("3")) {
            this.olA.setVisibility(0);
            this.oly.setVisibility(8);
            this.olT.setVisibility(0);
            this.olT.setOnClickListener(this);
        } else {
            this.olT.setVisibility(8);
            this.olA.setVisibility(8);
            this.oly.setVisibility(0);
            this.olx.setOnClickListener(this);
        }
        ehh();
        if (tv.chushou.zues.utils.systemBar.b.hp(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.olt.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.olt.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ojI.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.ojI.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ols.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.ols.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.olq.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.olq.setLayoutParams(layoutParams4);
        }
        ehJ();
        aG();
        ehj();
        this.h = (TextView) this.opD.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.opD.findViewById(a.f.time_seekbar_relative);
        if (!this.opY.equals("3")) {
            if (this.opR.egU() != null) {
                this.olL.setVisibility(0);
            } else {
                this.olL.setVisibility(8);
            }
        }
        ehI();
        n();
        k(100);
        this.olU = (FoodView) this.opD.findViewById(a.f.kav_room_ad);
        this.opT = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aG(false, true);
                            break;
                        case 2:
                            b.this.opT.removeMessages(2);
                            if (b.this.olC != null) {
                                b.this.olC.setVisibility(8);
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
                            TextView textView = (TextView) b.this.opD.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.opS.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.opT.D(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.opT.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.opT.D(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aF(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.opS).q) {
                                b.this.a(b.this.opT);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.opS).q) {
                                b.this.b(b.this.opT);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.opS).g = true;
                            b.this.omi.seekTo((int) b.this.nFO);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.opR.d()) {
                                b.this.omi.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.omi.getPlayState() == 4) {
                                int currentPos = b.this.omi.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.opT != null) {
                                    b.this.opT.D(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.ehU();
                            break;
                        case 18:
                            b.this.aq();
                            break;
                        case 19:
                            b.this.opQ.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.opR != null) {
            a(this.opR.egV());
        }
        if (this.omi != null && (this.omi.getPlayState() == 3 || this.omi.getPlayState() == 4)) {
            zm(false);
            if (this.opR.d()) {
                this.ak = false;
                zn(true);
                if (this.omi.getDuration() > 60000) {
                    if (this.omi.getDuration() < 300000) {
                        this.opW = 60000;
                    } else {
                        this.opW = Math.min(this.omi.getDuration(), 300000);
                    }
                } else {
                    this.opW = this.omi.getDuration();
                }
            }
            this.e = false;
            aG(true, false);
            this.opT.PH(8);
            if (h() && this.omi.getPlayState() == 4 && this.opT != null) {
                this.opT.removeMessages(15);
                this.opT.PH(15);
            }
        } else {
            zm(true);
            if (this.e) {
                aG(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] egi = g.egi();
            int i = egi.length == 2 ? egi[1] : 0;
            if (i > 0) {
                View findViewById = this.opD.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.opS, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.opD.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.opS, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.opS, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.opS != null && (this.opS instanceof VideoPlayer)) {
            ((VideoPlayer) this.opS).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.olz.Dr(a.e.ic_recharge_old);
            this.olx.Dr(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.olX && !this.k) {
            try {
                if (this.omi != null) {
                    i = this.omi.getCurrentPos();
                    i2 = this.omi.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.ojp.setProgress(i / (i2 / 1000));
                    this.olY.setText(tv.chushou.zues.utils.b.q(this.omi.getDuration(), false));
                    this.olZ.setText(tv.chushou.zues.utils.b.q(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void ehI() {
        this.ojp = (ProgressBar) this.opD.findViewById(a.f.progressBarl);
        if (this.ojp != null) {
            if (this.ojp instanceof SeekBar) {
                ((SeekBar) this.ojp).setOnSeekBarChangeListener(new C0904b());
            }
            this.ojp.setMax(1000);
        }
        this.olY = (TextView) this.opD.findViewById(a.f.tv_time_duration);
        this.olZ = (TextView) this.opD.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.opD.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.opD.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a egF;
        BangInfo eia;
        if (config != null) {
            this.oqE = config;
            if (!config.display) {
                this.olI.setVisibility(8);
            } else if ((this.opS instanceof VideoPlayer) && (eia = (egF = ((VideoPlayer) this.opS).egF()).eia()) != null) {
                a(eia, egF.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.oqE == null || this.oqE.display) && this.olI != null) {
            this.olI.setVisibility(0);
            this.oqz.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.opS instanceof VideoPlayer) {
            if ((this.oqE == null || this.oqE.display) && this.olI != null) {
                if (j > 0) {
                    this.olI.setVisibility(0);
                    boolean z = this.oqD;
                    this.oqD = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.opS.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.oqz.setText(cVar);
                    return;
                }
                this.oqD = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0904b implements SeekBar.OnSeekBarChangeListener {
        C0904b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.opE != null) {
                if (b.this.oma != i || b.this.omb != z) {
                    b.this.oma = i;
                    b.this.omb = z;
                    if (z) {
                        if (b.this.olX) {
                            b.this.nFO = (b.this.omi.getDuration() / 1000) * i;
                        }
                        b.this.olZ.setText(tv.chushou.zues.utils.b.q((int) b.this.nFO, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.q((int) b.this.nFO, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.q(((int) b.this.nFO) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.olX = true;
            b.this.m = b.this.omi.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.opT != null) {
                if (b.this.olX) {
                    b.this.olX = false;
                }
                b.this.opT.removeMessages(14);
                b.this.opT.PH(14);
            }
        }
    }

    private void k(int i) {
        this.ojp.setSecondaryProgress((i * 1000) / 100);
    }

    private void ehD() {
        this.omc = (VerticalSeekBarVolumn) this.opD.findViewById(a.f.volumn_seekbar);
        this.omc.setOnSeekBarChangeListener(new c());
        int streamVolume = this.opU.getStreamVolume(3);
        this.omc.setProgress(Ot(streamVolume));
        x(Ot(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.opD.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.ojm = new d.a();
            this.c = new GestureDetector(this.opS, this.ojm);
        }
    }

    private void ehJ() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.olo == null) {
                this.olo = ((Activity) this.opS).getWindow();
            }
            this.olp = this.olo.getAttributes();
            this.oln = ((VideoPlayer) this.opS).k / 255.0f;
            ((VerticalSeekBarVolumn) this.opD.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.oln));
        }
    }

    private void aG() {
        this.opD.findViewById(a.f.btn_send).setOnClickListener(this);
        this.opD.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.opS.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.opD.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.olB == null) {
            this.olB = (EditText) this.opD.findViewById(a.f.et_input);
            this.olB.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.opD.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehg() {
        if (this.olM != null) {
            this.olM.dismiss();
            this.olM = null;
        }
        if (this.opS != null) {
            ((VideoPlayer) this.opS).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.ojI = this.opD.findViewById(a.f.topview);
        this.olu = (LinearLayout) this.opD.findViewById(a.f.topRight);
        this.olr = this.ojI.findViewById(a.f.rl_download);
        this.ols = this.opD.findViewById(a.f.topKeyboardView);
        this.opD.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.ojI.getVisibility() == 0;
        if (this.olG > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ojI.getLayoutParams();
            layoutParams.topMargin = this.olG;
            this.ojI.setLayoutParams(layoutParams);
        }
        this.opD.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.opD.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                str = this.opR.egU().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.opD.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.olJ = (ImageView) this.opD.findViewById(a.f.subscribe_icon);
        this.olJ.setOnClickListener(this);
        this.olL = (ImageView) this.opD.findViewById(a.f.report_icon);
        this.olL.setOnClickListener(this);
        q();
    }

    private void ehh() {
        boolean z;
        this.olq = this.opD.findViewById(a.f.bottomview);
        this.olw = (ImageButton) this.olq.findViewById(a.f.playbutton);
        this.olw.setOnTouchListener(this);
        this.opJ = (ImageButton) this.opD.findViewById(a.f.btn_barrage);
        this.opK = (ImageButton) this.opD.findViewById(a.f.btn_audio);
        this.olE = (ImageView) this.opD.findViewById(a.f.iv_danmu);
        if (!this.opY.equals("3")) {
            this.olq.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.olq.findViewById(a.f.btn_refresh).setVisibility(0);
            this.opJ.setVisibility(0);
            this.olE.setVisibility(8);
            if (this.opR != null && this.opR.f != null) {
                for (int i = 0; i < this.opR.f.size(); i++) {
                    if ("2".equals(this.opR.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.opK.setVisibility(0);
            } else {
                this.opK.setVisibility(8);
            }
            this.olq.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.opJ.setOnClickListener(this);
            if (h.egj().e) {
                this.opJ.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.opJ.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.opR.d) {
                this.opK.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.opK.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.opK.setOnClickListener(this);
            this.ojN = (ImageView) this.olq.findViewById(a.f.btn_hotword);
            this.olv = (ImageView) this.opD.findViewById(a.f.iv_task_badge);
            this.ojN.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.opS, a.C0897a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.egj().c) {
                        b.this.ojN.clearAnimation();
                        b.this.ojN.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.ojN.clearAnimation();
            if (h.egj().c) {
                this.ojN.startAnimation(animationSet);
                this.olv.setVisibility(0);
            }
        } else {
            this.olq.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.olq.findViewById(a.f.btn_refresh).setVisibility(8);
            this.opJ.setVisibility(8);
            this.opK.setVisibility(8);
            this.olE.setVisibility(0);
            this.olE.setOnClickListener(this);
            if (h.egj().b) {
                this.olE.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.olE.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.olq.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.opS != null) {
            ((VideoPlayer) this.opS).e(true);
        }
        if (this.opT != null) {
            this.opT.co(null);
            this.opT = null;
        }
        this.c = null;
        this.ojm = null;
        this.olC = null;
        if (this.olB != null) {
            this.olB.addTextChangedListener(null);
            this.olB.setOnEditorActionListener(null);
            this.olB = null;
        }
        this.ojI = null;
        this.opJ = null;
        this.opK = null;
        this.olq = null;
        this.olt = null;
        if (this.olR != null) {
            this.olR.a();
            this.olR = null;
            this.olS = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a ehz() {
        return this.olR;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.opD == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.oqJ == null || !this.oqJ.a(i, keyEvent)) {
                    if ((this.olQ == null || !this.olQ.onKeyDown(i, keyEvent)) && !ehq() && !ehf()) {
                        if (this.ols != null && this.ols.getVisibility() == 0) {
                            aF(false, true);
                            return true;
                        } else if (this.olD != null && this.olD.isShown()) {
                            aB();
                            return true;
                        } else if (this.olF && this.opT != null) {
                            if (this.olC != null) {
                                this.olC.setVisibility(0);
                            }
                            this.opT.removeMessages(2);
                            this.opT.D(2, IMConnection.RETRY_DELAY_TIMES);
                            return true;
                        } else {
                            ehg();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.opD.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.opD.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.opT != null) {
                    this.opT.removeMessages(3);
                    this.opT.D(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean ehK() {
        if (this.olF) {
            this.olC.setVisibility(0);
            this.opT.removeMessages(2);
            this.opT.D(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.olF;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.olF) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.olC.setVisibility(0);
            this.opT.removeMessages(2);
            this.opT.D(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.c(this.opS, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aE(getActivity()) && tv.chushou.zues.utils.systemBar.b.aF(getActivity())) {
                    o(view, tv.chushou.zues.utils.systemBar.b.ho(getActivity()), 0);
                    return;
                } else {
                    o(view, 0, 0);
                    return;
                }
            }
            o(view, 0, this.ojI.getHeight() + this.ojI.getTop());
        } else if (id == a.f.btn_send) {
            if (this.opY.equals("3")) {
                String trim = this.olB.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.K(this.opS, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.olB.setText((CharSequence) null);
                aF(false, true);
            } else if (a(this.olB.getText().toString(), false)) {
                aF(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.ho(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.opS, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            ehg();
            com.kascend.chushou.toolkit.a.c.a(this.opS, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = ehR() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.oqx == null;
                b(false, false);
                if (z && this.bV > 0 && this.oqx != null && tv.chushou.zues.utils.systemBar.b.aE(getActivity()) && tv.chushou.zues.utils.systemBar.b.aF(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oqx.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.oqx.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.oqx == null;
                if (this.opS.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.oqx != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oqx.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.oqx.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.opS, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.opR.egU().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aF(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aG(false, false);
            this.opT.D(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.egj().c) {
                h.egj().b(false);
                this.ojN.clearAnimation();
                this.olv.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.olq.findViewById(a.f.ll_keyboard).getLeft(), this.olq.getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
            } else {
                m(view, this.olq.findViewById(a.f.ll_keyboard).getLeft(), this.olq.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                tv.chushou.zues.utils.g.c(this.opS, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.opS).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.opS, ehR(), false);
        } else if (id == a.f.btn_screenChange) {
            ehg();
        } else if (id == a.f.rl_paoicon) {
            ehd();
        } else if (id == a.f.subscribe_icon) {
            ehm();
        } else if (id == a.f.report_icon) {
            if (this.opY.equals("3")) {
                ehp();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                ehn();
            }
        } else if (id == a.f.btn_audio && !this.opR.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.PQ(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.olH <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.PQ(a.i.str_too_fast);
            return false;
        } else {
            if (!h.egj().e) {
                s(true);
                vB();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
            if (com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a(((VideoPlayer) this.opS).egv().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.olH = System.currentTimeMillis();
                a(this.opR.egU().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.opR.h);
                if (!z) {
                    this.olB.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.opY.equals("3")) {
            if (this.opJ != null) {
                if (z) {
                    this.opJ.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.opJ.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.olE != null) {
            if (z) {
                this.olE.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.olE.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout eho() {
        if (this.opD == null) {
            return null;
        }
        return (GiftAnimationLayout) this.opD.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.oqF != null) {
            this.oqF.setVisibility(z ? 0 : 8);
            if (!z) {
                this.oqF.etn();
            }
        }
        tv.chushou.zues.utils.g.x(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.opR.d()) {
            if (this.olF) {
                this.olC.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.opS, this.opS.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.olC.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.opS, this.opS.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.olF = !this.olF;
            if (this.olB != null) {
                this.olB.setEnabled(this.olF ? false : true);
            }
        }
    }

    public void aF(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.by(this.olB);
            this.olB.setText("");
            this.olt.setVisibility(8);
            this.olC.setVisibility(8);
            this.ojI.setVisibility(8);
            this.olq.setVisibility(8);
            this.ols.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
        if (this.ols.getVisibility() != 8 && z2) {
            this.ols.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_top_anim));
        }
        this.olt.setVisibility(8);
        this.olC.setVisibility(8);
        this.ojI.setVisibility(8);
        this.olq.setVisibility(8);
        this.ols.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aG(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.olu != null) {
            this.olu.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aG(boolean z, boolean z2) {
        return m(z, z2, false);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.olO != null) {
                this.olO.a(this.e);
            }
            return this.e;
        }
        if (this.opT != null) {
            this.opT.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.opS).e(true);
            if (!z3) {
                if (this.olq.getVisibility() != 0 && z2) {
                    this.olq.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_bottom_anim));
                }
                this.olq.setVisibility(0);
                this.olt.setVisibility(0);
                this.olC.setVisibility(0);
                this.olr.setVisibility(o() ? 0 : 8);
            }
            if (this.ojI.getVisibility() != 0 && z2) {
                this.ojI.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_top_anim));
            }
            u(!z3);
            this.ojI.setVisibility(0);
            if (this.opT != null) {
                this.opT.D(1, 5000L);
            }
            y(false);
            if (this.olO != null) {
                this.olO.a(true);
            }
        } else {
            ((VideoPlayer) this.opS).e(false);
            if (this.oqk != null) {
                this.oqk.dismiss();
            }
            if (this.oql != null) {
                this.oql.dismiss();
            }
            if (this.oqs != null) {
                this.oqs.dismiss();
            }
            if (this.olq != null) {
                if (this.olq.getVisibility() != 8 && z2) {
                    this.olq.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_bottom_anim));
                }
                this.olq.setVisibility(8);
            }
            if (this.olt != null) {
                this.olt.setVisibility(8);
                if (this.ojI.getVisibility() != 8 && z2) {
                    this.ojI.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_top_anim));
                }
                this.ojI.setVisibility(8);
                this.olC.setVisibility(8);
                y(true);
                a(false);
                if (this.olO != null) {
                    this.olO.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void ehj() {
        Point hj = tv.chushou.zues.utils.a.hj(this.opS);
        if (this.ap == 1) {
            this.ar = Math.min(hj.x, hj.y);
            this.aq = Math.max(hj.x, hj.y);
        } else {
            this.ar = Math.max(hj.x, hj.y);
            this.aq = Math.min(hj.x, hj.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.oll == null) {
            this.oll = new Rect(0, 0, i / 5, i2);
        } else {
            this.oll.set(0, 0, i / 5, i2);
        }
        if (this.olm == null) {
            this.olm = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.olm.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.oll == null) {
            return false;
        }
        return this.oll.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.opD.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.opD.findViewById(a.f.brightness_view);
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
        if (this.olm == null) {
            return false;
        }
        return this.olm.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.opD.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.opD.findViewById(a.f.volumn_view);
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
                if (this.olF) {
                    this.olC.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.olF) {
                    this.opT.removeMessages(2);
                    this.opT.D(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.opT != null) {
                    this.opT.D(3, 1000L);
                    this.opT.D(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.olF) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gA(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.opU.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.opS;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Ot(int i) {
        int streamMaxVolume = (i * 10) / this.opU.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.opD.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.opD.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.opS != null && (this.opS instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.opS).a(1, null, this.H, false, false, true);
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
            b.this.opU.setStreamVolume(3, b.this.gA(i), 0);
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
            b.this.oln = i / 10.0f;
            ((VideoPlayer) b.this.opS).l = b.this.oln;
            ((VideoPlayer) b.this.opS).k = b.this.oln * 255.0f;
            b.this.olp.screenBrightness = b.this.oln;
            b.this.olo.setAttributes(b.this.olp);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.opD.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (an(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.opD.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.opW > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.ojp.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.opD.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.opD.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.omi.getCurrentPos();
                            int duration = this.omi.getDuration();
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
                                this.ojp.setProgress(i3 / (duration / 1000));
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
            if (this.ols.getVisibility() == 8 && (this.olD == null || !this.olD.isShown())) {
                boolean z = this.opM != null && this.opM.getVisibility() == 0;
                if (this.e) {
                    aG(false, true);
                } else {
                    m(true, true, z);
                }
                aVar.d = 0;
            } else {
                aF(false, true);
                aB();
            }
        }
        return false;
    }

    public boolean ehf() {
        if (this.bB) {
            if (this.oqx != null) {
                this.oqx.e();
            }
            y(false);
            if (this.olq != null) {
                this.olq.setVisibility(0);
            }
            if (this.ojI != null) {
                this.ojI.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.opS instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.opS;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.opR != null) {
            this.opR.f = null;
            if (this.opR.egU() != null) {
                this.opR.egU().mRoominfo.mGameId = null;
            }
        }
        if (this.opY.equals("3")) {
            if (this.omi != null) {
                this.omi.seekTo(0L);
                e(true);
            }
            ehg();
            return;
        }
        ehg();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.olF) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                tv.chushou.zues.utils.g.c(this.opS, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.omi.getPlayState() == 4) {
                        ehk();
                        e(true);
                    } else {
                        if (this.olU != null) {
                            this.olU.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.opR.a(false);
                            ((VideoPlayer) this.opS).a(true, (Uri) null, false);
                        } else if (!this.opY.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                        } else if (this.omi.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.omi.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.omi.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            zn(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.omi.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.omi.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                tv.chushou.zues.utils.g.c(this.opS, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.opR.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.opS).a(true, (Uri) null, false);
                } else if (!this.opY.equals("3")) {
                    ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                    this.ai = false;
                    zn(true);
                    a(false, !this.ak);
                } else if (this.omi.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                    this.ai = false;
                    zn(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void ehk() {
        String str = null;
        if (!this.opY.equals("3")) {
            if (this.opR != null && this.opR.egW() != null) {
                str = this.opR.egW().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.egc().z != null && com.kascend.chushou.a.a.egc().z.contains(str) && this.opR != null && !this.omd) {
            this.omd = true;
            com.kascend.chushou.a.a.egc().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.omd = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.olU != null) {
            this.olU.a(listItem, this.ap == 1, a.C0897a.zues_sweetalert_modal_in, a.C0897a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.omd = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.olw != null) {
                this.olw.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4123a != null) {
                this.f4123a.setVisibility(8);
            }
            if (this.opM != null) {
                this.opM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.olw != null) {
            this.olw.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4123a != null) {
            if (z2 != (this.f4123a.getVisibility() == 0)) {
                if (z2) {
                    this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4123a.setVisibility(0);
                    return;
                }
                this.f4123a.setVisibility(8);
                if (this.opM != null) {
                    this.opM.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void ehl() {
        this.opE = new SurfaceView(this.opS);
        SurfaceView surfaceView = (SurfaceView) this.opE;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.opD).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ehu() {
        if (this.oqF != null) {
            this.oqF.etn();
            this.oqF.setVisibility(8);
            this.oqF.unInit();
            ((RelativeLayout) this.opD).removeView(this.oqF);
            this.oqF = null;
        }
        if (this.opE != null) {
            this.opE.setVisibility(8);
            ((RelativeLayout) this.opD).removeView(this.opE);
            this.opE = null;
        }
        ehl();
        ((VideoPlayer) this.opS).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.opT != null) {
            y(true);
            this.opT.removeMessages(1);
            this.olq.setVisibility(0);
            this.olt.setVisibility(8);
            this.ojI.setVisibility(8);
            this.olC.setVisibility(8);
        }
        if (this.oqs == null) {
            al();
            this.oqs.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.ojN.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.oqs.isShowing()) {
            this.oqs.showAtLocation(view, 83, i, i2);
            this.ojN.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.opR.egU().mRoominfo.mRoomID);
            return;
        }
        this.oqs.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.olQ != null && this.olQ.b()) {
                this.olQ.getGlobalVisibleRect(this.ome);
                if (!this.ome.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.olQ.a();
                    return true;
                }
            }
            if (this.bB && f(this.oqx.b, motionEvent)) {
                ehf();
                return true;
            }
            if (!ehK()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.olU != null && this.olU.isShown()) {
                    this.olU.a();
                    if (this.omi.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.opR.a(false);
                            ((VideoPlayer) this.opS).a(true, (Uri) null, false);
                        } else if (!this.opY.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                        } else if (this.omi.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.opS).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.omi.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.omi.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            zn(true);
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
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
        if (this.olD != null) {
            if (this.olD.isShown()) {
                this.olD.startAnimation(AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_top_anim));
            }
            this.olD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.opS).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.opS).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.opK != null) {
                this.opK.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hp(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.olt.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.olt.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ojI.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.ojI.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ols.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.ols.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.olq.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.olq.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
            this.olJ.setVisibility(0);
            if (this.opR.egU().mRoominfo.mIsSubscribed) {
                this.olJ.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.olJ.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.olJ.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void ehm() {
        RoomInfo roomInfo;
        if (this.opR != null && this.opR.egU() != null && (roomInfo = this.opR.egU().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.opS, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.euC();
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
        if (this.opR != null && this.opR.egU() != null && (roomInfo = this.opR.egU().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.K(b.this.opS, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.K(b.this.opS, a.i.subscribe_success);
                            }
                            if (b.this.opR != null && b.this.opR.egU() != null && (roomInfo2 = b.this.opR.egU().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.opS, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.opS, str2);
                    }
                }
            };
            if (this.opR != null && this.opR.h != null) {
                try {
                    str = new JSONObject(this.opR.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.ege().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.ege().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.olK == null) {
                this.olK = new ProgressDialog(this.opS);
                this.olK.setProgressStyle(0);
                this.olK.requestWindowFeature(1);
                this.olK.setMessage(this.opS.getText(a.i.update_userinfo_ing));
                this.olK.setCancelable(true);
            }
            if (!this.olK.isShowing()) {
                this.olK.show();
            }
        } else if (this.olK != null && this.olK.isShowing()) {
            this.olK.dismiss();
        }
    }

    private void ehn() {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
            if (this.olM == null) {
                this.olM = new f(getActivity());
            }
            this.olM.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.olM = null;
                }
            });
            RoomInfo roomInfo = this.opR.egU().mRoominfo;
            this.olM.a();
            this.olM.a(roomInfo);
            if (!this.olM.isShowing()) {
                this.olM.show();
            }
        }
    }

    private void ehp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.omc != null && this.opU != null && this.opS != null && (this.opS instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.omc;
            VideoPlayer videoPlayer = (VideoPlayer) this.opS;
            verticalSeekBarVolumn.setProgressOnly(Ot(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.ojq != null) {
            this.ojq.eug();
        }
        if (this.opD != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.olO == null) {
                this.olO = new com.kascend.chushou.player.ui.giftpopup.a(this.opD, i);
            } else if (this.olO.a() != i) {
                this.olO.b();
                this.olO = null;
                this.olO = new com.kascend.chushou.player.ui.giftpopup.a(this.opD, i);
            }
            List<ListItem> j = this.opR != null ? this.opR.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.opS;
            if (videoPlayer != null) {
                this.olO.a(j, videoPlayer.egB(), videoPlayer.egC(), videoPlayer.egD(), videoPlayer.egE());
                this.olO.a(this.e);
                if (this.opR != null && this.opR.oiW != null) {
                    this.olO.a(this.opR.oiW, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.opR != null) {
                                b.this.opR.oiW = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.olO != null && this.opR != null) {
                    this.olO.b(this.opR.oiZ);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void a(int i) {
        if (this.olO != null && this.opS != null) {
            this.olO.a(((VideoPlayer) this.opS).egB());
            this.olO.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void D() {
        if (this.opS instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a egB = ((VideoPlayer) this.opS).egB();
            if (this.oqJ == null) {
                this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.oqJ.setVisibility(0);
            this.oqJ.a(i, egB);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.olO != null) {
            this.olO.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.olz != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.olz.setVisibility(0);
                    this.olz.bY(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.olz.setVisibility(8);
                }
            }
            if (this.olx != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.oly.setVisibility(0);
                    this.olx.bY(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.oly.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.olO != null) {
            this.olO.a(((VideoPlayer) this.opS).egC());
            this.olO.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.olO != null) {
            this.olO.a(((VideoPlayer) this.opS).egC());
            this.olO.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(long j) {
        if (this.olO != null) {
            this.olO.a(((VideoPlayer) this.opS).egD());
            this.olO.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0910a
    public void c(int i) {
        if (this.olO != null) {
            this.olO.a(((VideoPlayer) this.opS).egE());
            this.olO.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        zm(false);
        super.F();
    }

    private void c(View view) {
        this.olV = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.okq = (TextView) view.findViewById(a.f.tv_4g_video);
        this.okq.setText(new tv.chushou.zues.widget.a.c().N(this.opS, a.e.videoplayer_4g_video).append("  ").append(this.opS.getString(a.i.videoplayer_4g_video)));
        this.olW = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.olW.setText(new tv.chushou.zues.widget.a.c().N(this.opS, a.e.videoplayer_4g_audio).append("  ").append(this.opS.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.ehg();
                    com.kascend.chushou.toolkit.a.c.a(b.this.opS, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.olV.setVisibility(8);
                    ((VideoPlayer) b.this.opS).c(b.this.oks);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.olV.setVisibility(8);
                    ((VideoPlayer) b.this.opS).d(b.this.oks);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
        findViewById.setLayoutParams(layoutParams);
        this.okq.setOnClickListener(onClickListener);
        this.olW.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.opR != null && !tv.chushou.zues.utils.h.isEmpty(this.opR.f)) {
            g(this.opR.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.oks = z;
            this.p = false;
            if (this.opR != null && this.opR.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.opR.f.size()) {
                        break;
                    } else if (!"2".equals(this.opR.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.olV != null) {
                this.olV.setVisibility(0);
                this.okq.setVisibility(0);
                this.olW.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.olV != null) {
            this.olV.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.olO != null && this.opR != null) {
            this.olO.b(this.opR.oiZ);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.opD != null && (findViewById = this.opD.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.olx != null) {
            this.olx.performClick();
        }
    }
}
