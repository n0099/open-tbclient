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
    private TextView pbH;
    private boolean pbJ;
    private LinearLayout pcL;
    private FrameLayout pcP;
    private FrescoThumbnailView pcQ;
    private ImageView pcT;
    private ImageView pcV;
    RelativeLayout pcZ;
    private ImageView pda;
    private ImageView pdc;
    private f pdd;
    private com.kascend.chushou.player.ui.giftpopup.a pdf;
    private PopH5Menu pdh;
    private com.kascend.chushou.player.b.a pdi;
    private GiftAnimationLayout pdj;
    private ImageView pdk;
    private FoodView pdl;
    private RelativeLayout pdm;
    private TextView pdn;
    private VerticalSeekBarVolumn pdt;
    private Rect pcC = null;
    private Rect pcD = null;
    private float pcE = 0.0f;
    private Window pcF = null;
    private WindowManager.LayoutParams pcG = null;
    private boolean bB = false;
    private View pcH = null;
    private View paZ = null;
    private View pcI = null;
    private View pcJ = null;
    private View pcK = null;
    private ImageView pbe = null;
    private ImageView pcM = null;
    private ImageButton pcN = null;
    private FrescoThumbnailView pcO = null;
    private LinearLayout pcR = null;
    private EditText pcS = null;
    private View pcU = null;
    private boolean pcW = false;
    private int pcX = 0;
    private int bV = 0;
    private long pcY = 0;
    private ProgressDialog pdb = null;
    private boolean pde = true;
    private int pdg = -1;
    private boolean pdo = false;
    private TextView pdp = null;
    private TextView pdq = null;
    private int pdr = 0;
    private boolean pds = false;
    private boolean pdu = false;
    private final Rect pdv = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.phn = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.paH = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.pgS = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.phh != null && !((Activity) this.phh).isFinishing()) {
            erH();
        }
        return this.pgS;
    }

    public void erd() {
        aM(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.phh, "能量_num", "横屏", new Object[0]);
    }

    public boolean erq() {
        if (this.phQ == null || !this.phQ.isShown()) {
            return false;
        }
        this.phQ.d();
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
        if (z3 || this.pgS.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.phn)) {
            z = h.eqj().e;
        } else {
            z = h.eqj().b;
        }
        r(z);
        if (this.phM != null) {
            this.phM.b();
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
        if (this.pdf != null) {
            this.pdf.b();
            this.pdf = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.ct(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            erj();
            y();
            if (this.paH != null) {
                this.paH.onConfigurationChanged(configuration);
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
        if (this.pdh != null && this.pdg != i3) {
            this.pdh.a();
            this.pdh = null;
        }
        if (this.pdh == null) {
            this.pdh = (PopH5Menu) ((ViewStub) this.pgS.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point hD = tv.chushou.zues.utils.a.hD(getActivity());
            if (this.ap == 0) {
                int i4 = hD.y;
                i = hD.y;
                i2 = i4;
            } else {
                int i5 = hD.x;
                int i6 = hD.y - ((hD.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pdh.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.pdh.setLayoutParams(layoutParams);
            this.pdg = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.f4231a = listItem.mUrl;
        h5Options.h = -1;
        this.pdh.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!aa()) {
            if (bVar.f4150a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4150a == 6) {
                D();
            } else if (bVar.f4150a == 4) {
                if (this.phh instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b eqC = ((VideoPlayer) this.phh).eqC();
                    if (this.phY == null) {
                        this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.phY.setVisibility(0);
                    this.phY.a(i, eqC);
                }
            } else if (bVar.f4150a == 3) {
                if (this.phh instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a eqD = ((VideoPlayer) this.phh).eqD();
                    if (this.phY == null) {
                        this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.phY.setVisibility(0);
                    this.phY.a(i, eqD);
                }
            } else if (bVar.f4150a == 9) {
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo eqW;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.phg != null && mVar.b.equals(this.phg.f4117a) && (eqW = this.phg.eqW()) != null) {
            eqW.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void erH() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.phn)) {
            this.phn = "1";
        }
        this.pcX = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
        this.bV = tv.chushou.zues.utils.systemBar.b.hI(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.pdz = ((VideoPlayer) this.phh).eqs();
        this.phg = ((VideoPlayer) this.phh).eqv();
        c(this.pgS);
        if (this.phn.equals("1")) {
            this.paF = ((VideoPlayer) this.phh).eqw();
            this.paF.a(this);
            if (this.pdi != null) {
                this.pdi.a();
                this.pdi = null;
                this.pdj = null;
            }
            this.pdj = (GiftAnimationLayout) this.pgS.findViewById(a.f.ll_gift_animation);
            this.pdj.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.phg != null) {
                this.pdi = new com.kascend.chushou.player.b.a(this.phh.getApplicationContext(), this.pdj);
                this.pdi.a(this.phg);
            }
            this.B = (TextView) this.pgS.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.phn.equals("3")) {
        }
        erl();
        if (this.paF != null) {
            this.paF.d();
        }
        erD();
        this.pcT = (ImageView) this.pgS.findViewById(a.f.btn_lockscreen);
        this.pcT.setOnClickListener(this);
        if (this.f4121a == null) {
            this.f4121a = (ImageButton) this.pgS.findViewById(a.f.resumebutton);
            this.f4121a.setOnTouchListener(this);
        }
        this.phb = (PlayerErrorView) this.pgS.findViewById(a.f.view_net_error_msg);
        this.phb.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        ean();
        this.phQ = (PaoGuideView) this.pgS.findViewById(a.f.rlPaoGuideView);
        this.pdk = (ImageView) this.pgS.findViewById(a.f.iv_send_danmu);
        this.pcK = this.pgS.findViewById(a.f.rt_layout);
        this.pcO = (FrescoThumbnailView) this.pcK.findViewById(a.f.btn_gift);
        this.pcP = (FrameLayout) this.pcK.findViewById(a.f.flfl_bottom_gift);
        this.pcQ = (FrescoThumbnailView) this.pcK.findViewById(a.f.btn_recharge);
        this.pcQ.setOnClickListener(this);
        a(this.phg == null ? null : this.phg.pao);
        this.phW = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.phi != null) {
                    b.this.phi.removeMessages(1);
                    b.this.phi.E(1, 5000L);
                }
                b.this.pcT.setVisibility(0);
                b.this.pcK.setVisibility(0);
                b.this.paZ.setVisibility(0);
                b.this.pcH.setVisibility(0);
                if (b.this.pdf != null) {
                    b.this.pdf.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.phh, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.pcT.setVisibility(8);
                b.this.pcK.setVisibility(8);
                if (b.this.pdf != null) {
                    b.this.pdf.a(false);
                }
                b.this.paZ.setVisibility(8);
                b.this.pcH.setVisibility(8);
                if (b.this.phi != null) {
                    b.this.phi.removeMessages(1);
                }
                if (b.this.phM != null) {
                    b.this.phM.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.phh, 14.0f) + b.this.phM.getMeasuredHeight(), 12);
                }
            }
        };
        this.pcR = (LinearLayout) this.pgS.findViewById(a.f.rl_seekbar);
        this.pcZ = (RelativeLayout) this.pgS.findViewById(a.f.rl_paoicon);
        this.pcZ.setOnClickListener(this);
        this.phN = (RoundProgressBar) this.pgS.findViewById(a.f.roundProgressBar);
        this.phP = (FrescoThumbnailView) this.pgS.findViewById(a.f.iv_paoicon);
        this.phO = (TextView) this.pgS.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.phR = 0L;
        com.kascend.chushou.player.ui.a.a eqF = ((VideoPlayer) this.phh).eqF();
        a(eqF.erZ());
        BangInfo esa = eqF.esa();
        if (esa != null) {
            a(esa, eqF.d());
        }
        if (this.phn.equals("3")) {
            this.pcR.setVisibility(0);
            this.pcP.setVisibility(8);
            this.pdk.setVisibility(0);
            this.pdk.setOnClickListener(this);
        } else {
            this.pdk.setVisibility(8);
            this.pcR.setVisibility(8);
            this.pcP.setVisibility(0);
            this.pcO.setOnClickListener(this);
        }
        erh();
        if (tv.chushou.zues.utils.systemBar.b.hJ(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pcK.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.pcK.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.paZ.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.paZ.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pcJ.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.pcJ.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.pcH.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.pcH.setLayoutParams(layoutParams4);
        }
        erJ();
        aG();
        erj();
        this.h = (TextView) this.pgS.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.pgS.findViewById(a.f.time_seekbar_relative);
        if (!this.phn.equals("3")) {
            if (this.phg.eqU() != null) {
                this.pdc.setVisibility(0);
            } else {
                this.pdc.setVisibility(8);
            }
        }
        erI();
        n();
        k(100);
        this.pdl = (FoodView) this.pgS.findViewById(a.f.kav_room_ad);
        this.phi = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aM(false, true);
                            break;
                        case 2:
                            b.this.phi.removeMessages(2);
                            if (b.this.pcT != null) {
                                b.this.pcT.setVisibility(8);
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
                            TextView textView = (TextView) b.this.pgS.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.phh.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.phi.E(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.phi.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.phi.E(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aL(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.phh).q) {
                                b.this.a(b.this.phi);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.phh).q) {
                                b.this.b(b.this.phi);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.phh).g = true;
                            b.this.pdz.seekTo((int) b.this.oiq);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.phg.d()) {
                                b.this.pdz.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.pdz.getPlayState() == 4) {
                                int currentPos = b.this.pdz.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.phi != null) {
                                    b.this.phi.E(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.erU();
                            break;
                        case 18:
                            b.this.aq();
                            break;
                        case 19:
                            b.this.phf.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.phg != null) {
            a(this.phg.eqV());
        }
        if (this.pdz != null && (this.pdz.getPlayState() == 3 || this.pdz.getPlayState() == 4)) {
            Au(false);
            if (this.phg.d()) {
                this.ak = false;
                Av(true);
                if (this.pdz.getDuration() > 60000) {
                    if (this.pdz.getDuration() < 300000) {
                        this.phl = 60000;
                    } else {
                        this.phl = Math.min(this.pdz.getDuration(), 300000);
                    }
                } else {
                    this.phl = this.pdz.getDuration();
                }
            }
            this.e = false;
            aM(true, false);
            this.phi.Ry(8);
            if (h() && this.pdz.getPlayState() == 4 && this.phi != null) {
                this.phi.removeMessages(15);
                this.phi.Ry(15);
            }
        } else {
            Au(true);
            if (this.e) {
                aM(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] eqi = g.eqi();
            int i = eqi.length == 2 ? eqi[1] : 0;
            if (i > 0) {
                View findViewById = this.pgS.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.phh, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.pgS.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.phh, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.phh, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.phh != null && (this.phh instanceof VideoPlayer)) {
            ((VideoPlayer) this.phh).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.pcQ.DK(a.e.ic_recharge_old);
            this.pcO.DK(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.pdo && !this.k) {
            try {
                if (this.pdz != null) {
                    i = this.pdz.getCurrentPos();
                    i2 = this.pdz.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.paG.setProgress(i / (i2 / 1000));
                    this.pdp.setText(tv.chushou.zues.utils.b.v(this.pdz.getDuration(), false));
                    this.pdq.setText(tv.chushou.zues.utils.b.v(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void erI() {
        this.paG = (ProgressBar) this.pgS.findViewById(a.f.progressBarl);
        if (this.paG != null) {
            if (this.paG instanceof SeekBar) {
                ((SeekBar) this.paG).setOnSeekBarChangeListener(new C0976b());
            }
            this.paG.setMax(1000);
        }
        this.pdp = (TextView) this.pgS.findViewById(a.f.tv_time_duration);
        this.pdq = (TextView) this.pgS.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.pgS.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.pgS.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a eqF;
        BangInfo esa;
        if (config != null) {
            this.phT = config;
            if (!config.display) {
                this.pcZ.setVisibility(8);
            } else if ((this.phh instanceof VideoPlayer) && (esa = (eqF = ((VideoPlayer) this.phh).eqF()).esa()) != null) {
                a(esa, eqF.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.phT == null || this.phT.display) && this.pcZ != null) {
            this.pcZ.setVisibility(0);
            this.phO.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.phh instanceof VideoPlayer) {
            if ((this.phT == null || this.phT.display) && this.pcZ != null) {
                if (j > 0) {
                    this.pcZ.setVisibility(0);
                    boolean z = this.phS;
                    this.phS = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.phh.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.phO.setText(cVar);
                    return;
                }
                this.phS = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0976b implements SeekBar.OnSeekBarChangeListener {
        C0976b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.pgT != null) {
                if (b.this.pdr != i || b.this.pds != z) {
                    b.this.pdr = i;
                    b.this.pds = z;
                    if (z) {
                        if (b.this.pdo) {
                            b.this.oiq = (b.this.pdz.getDuration() / 1000) * i;
                        }
                        b.this.pdq.setText(tv.chushou.zues.utils.b.v((int) b.this.oiq, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.v((int) b.this.oiq, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.v(((int) b.this.oiq) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.pdo = true;
            b.this.m = b.this.pdz.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.phi != null) {
                if (b.this.pdo) {
                    b.this.pdo = false;
                }
                b.this.phi.removeMessages(14);
                b.this.phi.Ry(14);
            }
        }
    }

    private void k(int i) {
        this.paG.setSecondaryProgress((i * 1000) / 100);
    }

    private void erD() {
        this.pdt = (VerticalSeekBarVolumn) this.pgS.findViewById(a.f.volumn_seekbar);
        this.pdt.setOnSeekBarChangeListener(new c());
        int streamVolume = this.phj.getStreamVolume(3);
        this.pdt.setProgress(Qk(streamVolume));
        x(Qk(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.pgS.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.paD = new d.a();
            this.c = new GestureDetector(this.phh, this.paD);
        }
    }

    private void erJ() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.pcF == null) {
                this.pcF = ((Activity) this.phh).getWindow();
            }
            this.pcG = this.pcF.getAttributes();
            this.pcE = ((VideoPlayer) this.phh).k / 255.0f;
            ((VerticalSeekBarVolumn) this.pgS.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.pcE));
        }
    }

    private void aG() {
        this.pgS.findViewById(a.f.btn_send).setOnClickListener(this);
        this.pgS.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.phh.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.pgS.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.pcS == null) {
            this.pcS = (EditText) this.pgS.findViewById(a.f.et_input);
            this.pcS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.pgS.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erg() {
        if (this.pdd != null) {
            this.pdd.dismiss();
            this.pdd = null;
        }
        if (this.phh != null) {
            ((VideoPlayer) this.phh).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.paZ = this.pgS.findViewById(a.f.topview);
        this.pcL = (LinearLayout) this.pgS.findViewById(a.f.topRight);
        this.pcI = this.paZ.findViewById(a.f.rl_download);
        this.pcJ = this.pgS.findViewById(a.f.topKeyboardView);
        this.pgS.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.paZ.getVisibility() == 0;
        if (this.pcX > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.paZ.getLayoutParams();
            layoutParams.topMargin = this.pcX;
            this.paZ.setLayoutParams(layoutParams);
        }
        this.pgS.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.pgS.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                str = this.phg.eqU().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.pgS.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.pda = (ImageView) this.pgS.findViewById(a.f.subscribe_icon);
        this.pda.setOnClickListener(this);
        this.pdc = (ImageView) this.pgS.findViewById(a.f.report_icon);
        this.pdc.setOnClickListener(this);
        q();
    }

    private void erh() {
        boolean z;
        this.pcH = this.pgS.findViewById(a.f.bottomview);
        this.pcN = (ImageButton) this.pcH.findViewById(a.f.playbutton);
        this.pcN.setOnTouchListener(this);
        this.pgY = (ImageButton) this.pgS.findViewById(a.f.btn_barrage);
        this.pgZ = (ImageButton) this.pgS.findViewById(a.f.btn_audio);
        this.pcV = (ImageView) this.pgS.findViewById(a.f.iv_danmu);
        if (!this.phn.equals("3")) {
            this.pcH.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.pcH.findViewById(a.f.btn_refresh).setVisibility(0);
            this.pgY.setVisibility(0);
            this.pcV.setVisibility(8);
            if (this.phg != null && this.phg.f != null) {
                for (int i = 0; i < this.phg.f.size(); i++) {
                    if ("2".equals(this.phg.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.pgZ.setVisibility(0);
            } else {
                this.pgZ.setVisibility(8);
            }
            this.pcH.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.pgY.setOnClickListener(this);
            if (h.eqj().e) {
                this.pgY.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pgY.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.phg.d) {
                this.pgZ.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.pgZ.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.pgZ.setOnClickListener(this);
            this.pbe = (ImageView) this.pcH.findViewById(a.f.btn_hotword);
            this.pcM = (ImageView) this.pgS.findViewById(a.f.iv_task_badge);
            this.pbe.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.phh, a.C0969a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.eqj().c) {
                        b.this.pbe.clearAnimation();
                        b.this.pbe.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.pbe.clearAnimation();
            if (h.eqj().c) {
                this.pbe.startAnimation(animationSet);
                this.pcM.setVisibility(0);
            }
        } else {
            this.pcH.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.pcH.findViewById(a.f.btn_refresh).setVisibility(8);
            this.pgY.setVisibility(8);
            this.pgZ.setVisibility(8);
            this.pcV.setVisibility(0);
            this.pcV.setOnClickListener(this);
            if (h.eqj().b) {
                this.pcV.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pcV.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.pcH.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.phh != null) {
            ((VideoPlayer) this.phh).e(true);
        }
        if (this.phi != null) {
            this.phi.cs(null);
            this.phi = null;
        }
        this.c = null;
        this.paD = null;
        this.pcT = null;
        if (this.pcS != null) {
            this.pcS.addTextChangedListener(null);
            this.pcS.setOnEditorActionListener(null);
            this.pcS = null;
        }
        this.paZ = null;
        this.pgY = null;
        this.pgZ = null;
        this.pcH = null;
        this.pcK = null;
        if (this.pdi != null) {
            this.pdi.a();
            this.pdi = null;
            this.pdj = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a erz() {
        return this.pdi;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.pgS == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.phY == null || !this.phY.a(i, keyEvent)) {
                    if ((this.pdh == null || !this.pdh.onKeyDown(i, keyEvent)) && !erq() && !erf()) {
                        if (this.pcJ != null && this.pcJ.getVisibility() == 0) {
                            aL(false, true);
                            return true;
                        } else if (this.pcU != null && this.pcU.isShown()) {
                            aB();
                            return true;
                        } else if (this.pcW && this.phi != null) {
                            if (this.pcT != null) {
                                this.pcT.setVisibility(0);
                            }
                            this.phi.removeMessages(2);
                            this.phi.E(2, IMConnection.RETRY_DELAY_TIMES);
                            return true;
                        } else {
                            erg();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.pgS.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.pgS.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.phi != null) {
                    this.phi.removeMessages(3);
                    this.phi.E(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean erK() {
        if (this.pcW) {
            this.pcT.setVisibility(0);
            this.phi.removeMessages(2);
            this.phi.E(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.pcW;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.pcW) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.pcT.setVisibility(0);
            this.phi.removeMessages(2);
            this.phi.E(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.d(this.phh, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aH(getActivity()) && tv.chushou.zues.utils.systemBar.b.aI(getActivity())) {
                    o(view, tv.chushou.zues.utils.systemBar.b.hI(getActivity()), 0);
                    return;
                } else {
                    o(view, 0, 0);
                    return;
                }
            }
            o(view, 0, this.paZ.getHeight() + this.paZ.getTop());
        } else if (id == a.f.btn_send) {
            if (this.phn.equals("3")) {
                String trim = this.pcS.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.N(this.phh, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.pcS.setText((CharSequence) null);
                aL(false, true);
            } else if (a(this.pcS.getText().toString(), false)) {
                aL(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.hI(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.phh, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            erg();
            com.kascend.chushou.toolkit.a.c.a(this.phh, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = erR() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.phM == null;
                b(false, false);
                if (z && this.bV > 0 && this.phM != null && tv.chushou.zues.utils.systemBar.b.aH(getActivity()) && tv.chushou.zues.utils.systemBar.b.aI(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.phM.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.phM.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.phM == null;
                if (this.phh.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.phM != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.phM.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.phM.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.phh, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.phg.eqU().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aL(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aM(false, false);
            this.phi.E(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.eqj().c) {
                h.eqj().b(false);
                this.pbe.clearAnimation();
                this.pcM.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.pcH.findViewById(a.f.ll_keyboard).getLeft(), this.pcH.getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
            } else {
                m(view, this.pcH.findViewById(a.f.ll_keyboard).getLeft(), this.pcH.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                tv.chushou.zues.utils.g.d(this.phh, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.phh).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.phh, erR(), false);
        } else if (id == a.f.btn_screenChange) {
            erg();
        } else if (id == a.f.rl_paoicon) {
            erd();
        } else if (id == a.f.subscribe_icon) {
            erm();
        } else if (id == a.f.report_icon) {
            if (this.phn.equals("3")) {
                erp();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                ern();
            }
        } else if (id == a.f.btn_audio && !this.phg.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.RH(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.pcY <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.RH(a.i.str_too_fast);
            return false;
        } else {
            if (!h.eqj().e) {
                s(true);
                vB();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
            if (com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a(((VideoPlayer) this.phh).eqv().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.pcY = System.currentTimeMillis();
                a(this.phg.eqU().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.phg.h);
                if (!z) {
                    this.pcS.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.phn.equals("3")) {
            if (this.pgY != null) {
                if (z) {
                    this.pgY.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.pgY.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.pcV != null) {
            if (z) {
                this.pcV.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pcV.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout ero() {
        if (this.pgS == null) {
            return null;
        }
        return (GiftAnimationLayout) this.pgS.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.phU != null) {
            this.phU.setVisibility(z ? 0 : 8);
            if (!z) {
                this.phU.eDl();
            }
        }
        tv.chushou.zues.utils.g.A(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.phg.d()) {
            if (this.pcW) {
                this.pcT.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.d(this.phh, this.phh.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.pcT.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.d(this.phh, this.phh.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.pcW = !this.pcW;
            if (this.pcS != null) {
                this.pcS.setEnabled(this.pcW ? false : true);
            }
        }
    }

    public void aL(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bz(this.pcS);
            this.pcS.setText("");
            this.pcK.setVisibility(8);
            this.pcT.setVisibility(8);
            this.paZ.setVisibility(8);
            this.pcH.setVisibility(8);
            this.pcJ.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
        if (this.pcJ.getVisibility() != 8 && z2) {
            this.pcJ.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_top_anim));
        }
        this.pcK.setVisibility(8);
        this.pcT.setVisibility(8);
        this.paZ.setVisibility(8);
        this.pcH.setVisibility(8);
        this.pcJ.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aM(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.pcL != null) {
            this.pcL.setVisibility(z ? 0 : 4);
        }
    }

    public boolean aM(boolean z, boolean z2) {
        return m(z, z2, false);
    }

    public boolean m(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.pdf != null) {
                this.pdf.a(this.e);
            }
            return this.e;
        }
        if (this.phi != null) {
            this.phi.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.phh).e(true);
            if (!z3) {
                if (this.pcH.getVisibility() != 0 && z2) {
                    this.pcH.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_bottom_anim));
                }
                this.pcH.setVisibility(0);
                this.pcK.setVisibility(0);
                this.pcT.setVisibility(0);
                this.pcI.setVisibility(o() ? 0 : 8);
            }
            if (this.paZ.getVisibility() != 0 && z2) {
                this.paZ.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_top_anim));
            }
            u(!z3);
            this.paZ.setVisibility(0);
            if (this.phi != null) {
                this.phi.E(1, 5000L);
            }
            y(false);
            if (this.pdf != null) {
                this.pdf.a(true);
            }
        } else {
            ((VideoPlayer) this.phh).e(false);
            if (this.phz != null) {
                this.phz.dismiss();
            }
            if (this.phA != null) {
                this.phA.dismiss();
            }
            if (this.phH != null) {
                this.phH.dismiss();
            }
            if (this.pcH != null) {
                if (this.pcH.getVisibility() != 8 && z2) {
                    this.pcH.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_bottom_anim));
                }
                this.pcH.setVisibility(8);
            }
            if (this.pcK != null) {
                this.pcK.setVisibility(8);
                if (this.paZ.getVisibility() != 8 && z2) {
                    this.paZ.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_top_anim));
                }
                this.paZ.setVisibility(8);
                this.pcT.setVisibility(8);
                y(true);
                a(false);
                if (this.pdf != null) {
                    this.pdf.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void erj() {
        Point hD = tv.chushou.zues.utils.a.hD(this.phh);
        if (this.ap == 1) {
            this.ar = Math.min(hD.x, hD.y);
            this.aq = Math.max(hD.x, hD.y);
        } else {
            this.ar = Math.max(hD.x, hD.y);
            this.aq = Math.min(hD.x, hD.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.pcC == null) {
            this.pcC = new Rect(0, 0, i / 5, i2);
        } else {
            this.pcC.set(0, 0, i / 5, i2);
        }
        if (this.pcD == null) {
            this.pcD = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.pcD.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.pcC == null) {
            return false;
        }
        return this.pcC.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.pgS.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.pgS.findViewById(a.f.brightness_view);
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

    private boolean ap(MotionEvent motionEvent) {
        if (this.pcD == null) {
            return false;
        }
        return this.pcD.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.pgS.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.pgS.findViewById(a.f.volumn_view);
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
                if (this.pcW) {
                    this.pcT.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.pcW) {
                    this.phi.removeMessages(2);
                    this.phi.E(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.phi != null) {
                    this.phi.E(3, 1000L);
                    this.phi.E(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.pcW) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gL(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.phj.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.phh;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Qk(int i) {
        int streamMaxVolume = (i * 10) / this.phj.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.pgS.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.pgS.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.phh != null && (this.phh instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.phh).a(1, null, this.H, false, false, true);
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
            b.this.phj.setStreamVolume(3, b.this.gL(i), 0);
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
            b.this.pcE = i / 10.0f;
            ((VideoPlayer) b.this.phh).l = b.this.pcE;
            ((VideoPlayer) b.this.phh).k = b.this.pcE * 255.0f;
            b.this.pcG.screenBrightness = b.this.pcE;
            b.this.pcF.setAttributes(b.this.pcG);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.pgS.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (ap(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.pgS.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.phl > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.paG.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.pgS.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.pgS.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.pdz.getCurrentPos();
                            int duration = this.pdz.getDuration();
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
                                this.paG.setProgress(i3 / (duration / 1000));
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
            if (this.pcJ.getVisibility() == 8 && (this.pcU == null || !this.pcU.isShown())) {
                boolean z = this.phb != null && this.phb.getVisibility() == 0;
                if (this.e) {
                    aM(false, true);
                } else {
                    m(true, true, z);
                }
                aVar.d = 0;
            } else {
                aL(false, true);
                aB();
            }
        }
        return false;
    }

    public boolean erf() {
        if (this.bB) {
            if (this.phM != null) {
                this.phM.e();
            }
            y(false);
            if (this.pcH != null) {
                this.pcH.setVisibility(0);
            }
            if (this.paZ != null) {
                this.paZ.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.phh instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.phh;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.phg != null) {
            this.phg.f = null;
            if (this.phg.eqU() != null) {
                this.phg.eqU().mRoominfo.mGameId = null;
            }
        }
        if (this.phn.equals("3")) {
            if (this.pdz != null) {
                this.pdz.seekTo(0L);
                e(true);
            }
            erg();
            return;
        }
        erg();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.pcW) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                tv.chushou.zues.utils.g.d(this.phh, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.pdz.getPlayState() == 4) {
                        erk();
                        e(true);
                    } else {
                        if (this.pdl != null) {
                            this.pdl.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.phg.a(false);
                            ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                        } else if (!this.phn.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                        } else if (this.pdz.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.pdz.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.pdz.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            Av(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.pdz.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.pdz.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                tv.chushou.zues.utils.g.d(this.phh, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.phg.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                } else if (!this.phn.equals("3")) {
                    ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                    this.ai = false;
                    Av(true);
                    a(false, !this.ak);
                } else if (this.pdz.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                    this.ai = false;
                    Av(true);
                    a(false, !this.ak);
                } else {
                    n(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void erk() {
        String str = null;
        if (!this.phn.equals("3")) {
            if (this.phg != null && this.phg.eqW() != null) {
                str = this.phg.eqW().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.eqc().z != null && com.kascend.chushou.a.a.eqc().z.contains(str) && this.phg != null && !this.pdu) {
            this.pdu = true;
            com.kascend.chushou.a.a.eqc().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.pdu = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.pdl != null) {
            this.pdl.a(listItem, this.ap == 1, a.C0969a.zues_sweetalert_modal_in, a.C0969a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.pdu = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.pcN != null) {
                this.pcN.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4121a != null) {
                this.f4121a.setVisibility(8);
            }
            if (this.phb != null) {
                this.phb.setVisibility(8);
                return;
            }
            return;
        }
        if (this.pcN != null) {
            this.pcN.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4121a != null) {
            if (z2 != (this.f4121a.getVisibility() == 0)) {
                if (z2) {
                    this.f4121a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4121a.setVisibility(0);
                    return;
                }
                this.f4121a.setVisibility(8);
                if (this.phb != null) {
                    this.phb.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void erl() {
        this.pgT = new SurfaceView(this.phh);
        SurfaceView surfaceView = (SurfaceView) this.pgT;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.pgS).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void eru() {
        if (this.phU != null) {
            this.phU.eDl();
            this.phU.setVisibility(8);
            this.phU.unInit();
            ((RelativeLayout) this.pgS).removeView(this.phU);
            this.phU = null;
        }
        if (this.pgT != null) {
            this.pgT.setVisibility(8);
            ((RelativeLayout) this.pgS).removeView(this.pgT);
            this.pgT = null;
        }
        erl();
        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.phi != null) {
            y(true);
            this.phi.removeMessages(1);
            this.pcH.setVisibility(0);
            this.pcK.setVisibility(8);
            this.paZ.setVisibility(8);
            this.pcT.setVisibility(8);
        }
        if (this.phH == null) {
            al();
            this.phH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.pbe.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.phH.isShowing()) {
            this.phH.showAtLocation(view, 83, i, i2);
            this.pbe.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.phg.eqU().mRoominfo.mRoomID);
            return;
        }
        this.phH.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.pdh != null && this.pdh.b()) {
                this.pdh.getGlobalVisibleRect(this.pdv);
                if (!this.pdv.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.pdh.a();
                    return true;
                }
            }
            if (this.bB && f(this.phM.b, motionEvent)) {
                erf();
                return true;
            }
            if (!erK()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.pdl != null && this.pdl.isShown()) {
                    this.pdl.a();
                    if (this.pdz.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.phg.a(false);
                            ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                        } else if (!this.phn.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                        } else if (this.pdz.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.phh).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.pdz.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.pdz.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            Av(true);
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
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
        if (this.pcU != null) {
            if (this.pcU.isShown()) {
                this.pcU.startAnimation(AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_top_anim));
            }
            this.pcU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.phh).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.phh).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.pgZ != null) {
                this.pgZ.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hJ(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pcK.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.pcK.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.paZ.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.paZ.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pcJ.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.pcJ.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.pcH.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.pcH.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
            this.pda.setVisibility(0);
            if (this.phg.eqU().mRoominfo.mIsSubscribed) {
                this.pda.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.pda.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.pda.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void erm() {
        RoomInfo roomInfo;
        if (this.phg != null && this.phg.eqU() != null && (roomInfo = this.phg.eqU().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.phh, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.eEA();
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
        if (this.phg != null && this.phg.eqU() != null && (roomInfo = this.phg.eqU().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.N(b.this.phh, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.N(b.this.phh, a.i.subscribe_success);
                            }
                            if (b.this.phg != null && b.this.phg.eqU() != null && (roomInfo2 = b.this.phg.eqU().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.phh, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.d(b.this.phh, str2);
                    }
                }
            };
            if (this.phg != null && this.phg.h != null) {
                try {
                    str = new JSONObject(this.phg.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.eqe().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.eqe().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.pdb == null) {
                this.pdb = new ProgressDialog(this.phh);
                this.pdb.setProgressStyle(0);
                this.pdb.requestWindowFeature(1);
                this.pdb.setMessage(this.phh.getText(a.i.update_userinfo_ing));
                this.pdb.setCancelable(true);
            }
            if (!this.pdb.isShowing()) {
                this.pdb.show();
            }
        } else if (this.pdb != null && this.pdb.isShowing()) {
            this.pdb.dismiss();
        }
    }

    private void ern() {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
            if (this.pdd == null) {
                this.pdd = new f(getActivity());
            }
            this.pdd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.pdd = null;
                }
            });
            RoomInfo roomInfo = this.phg.eqU().mRoominfo;
            this.pdd.a();
            this.pdd.a(roomInfo);
            if (!this.pdd.isShowing()) {
                this.pdd.show();
            }
        }
    }

    private void erp() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.pdt != null && this.phj != null && this.phh != null && (this.phh instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.pdt;
            VideoPlayer videoPlayer = (VideoPlayer) this.phh;
            verticalSeekBarVolumn.setProgressOnly(Qk(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.paH != null) {
            this.paH.eEe();
        }
        if (this.pgS != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.pdf == null) {
                this.pdf = new com.kascend.chushou.player.ui.giftpopup.a(this.pgS, i);
            } else if (this.pdf.a() != i) {
                this.pdf.b();
                this.pdf = null;
                this.pdf = new com.kascend.chushou.player.ui.giftpopup.a(this.pgS, i);
            }
            List<ListItem> j = this.phg != null ? this.phg.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.phh;
            if (videoPlayer != null) {
                this.pdf.a(j, videoPlayer.eqB(), videoPlayer.eqC(), videoPlayer.eqD(), videoPlayer.eqE());
                this.pdf.a(this.e);
                if (this.phg != null && this.phg.pam != null) {
                    this.pdf.a(this.phg.pam, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.phg != null) {
                                b.this.phg.pam = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.pdf != null && this.phg != null) {
                    this.pdf.b(this.phg.pap);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void a(int i) {
        if (this.pdf != null && this.phh != null) {
            this.pdf.a(((VideoPlayer) this.phh).eqB());
            this.pdf.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void D() {
        if (this.phh instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a eqB = ((VideoPlayer) this.phh).eqB();
            if (this.phY == null) {
                this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.phY.setVisibility(0);
            this.phY.a(i, eqB);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.pdf != null) {
            this.pdf.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.pcQ != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.pcQ.setVisibility(0);
                    this.pcQ.cc(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.pcQ.setVisibility(8);
                }
            }
            if (this.pcO != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.pcP.setVisibility(0);
                    this.pcO.cc(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.pcP.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pdf != null) {
            this.pdf.a(((VideoPlayer) this.phh).eqC());
            this.pdf.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pdf != null) {
            this.pdf.a(((VideoPlayer) this.phh).eqC());
            this.pdf.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(long j) {
        if (this.pdf != null) {
            this.pdf.a(((VideoPlayer) this.phh).eqD());
            this.pdf.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0982a
    public void c(int i) {
        if (this.pdf != null) {
            this.pdf.a(((VideoPlayer) this.phh).eqE());
            this.pdf.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        Au(false);
        super.F();
    }

    private void c(View view) {
        this.pdm = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.pbH = (TextView) view.findViewById(a.f.tv_4g_video);
        this.pbH.setText(new tv.chushou.zues.widget.a.c().Q(this.phh, a.e.videoplayer_4g_video).append("  ").append(this.phh.getString(a.i.videoplayer_4g_video)));
        this.pdn = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.pdn.setText(new tv.chushou.zues.widget.a.c().Q(this.phh, a.e.videoplayer_4g_audio).append("  ").append(this.phh.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.erg();
                    com.kascend.chushou.toolkit.a.c.a(b.this.phh, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.pdm.setVisibility(8);
                    ((VideoPlayer) b.this.phh).c(b.this.pbJ);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.pdm.setVisibility(8);
                    ((VideoPlayer) b.this.phh).d(b.this.pbJ);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
        findViewById.setLayoutParams(layoutParams);
        this.pbH.setOnClickListener(onClickListener);
        this.pdn.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.phg != null && !tv.chushou.zues.utils.h.isEmpty(this.phg.f)) {
            g(this.phg.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.pbJ = z;
            this.p = false;
            if (this.phg != null && this.phg.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.phg.f.size()) {
                        break;
                    } else if (!"2".equals(this.phg.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.pdm != null) {
                this.pdm.setVisibility(0);
                this.pbH.setVisibility(0);
                this.pdn.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.pdm != null) {
            this.pdm.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pdf != null && this.phg != null) {
            this.pdf.b(this.phg.pap);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.pgS != null && (findViewById = this.pgS.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pcO != null) {
            this.pcO.performClick();
        }
    }
}
