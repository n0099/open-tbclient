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
    private TextView ple;
    private boolean plg;
    private f pmA;
    private com.kascend.chushou.player.ui.giftpopup.a pmC;
    private PopH5Menu pmE;
    private com.kascend.chushou.player.b.a pmF;
    private GiftAnimationLayout pmG;
    private ImageView pmH;
    private FoodView pmI;
    private RelativeLayout pmJ;
    private TextView pmK;
    private VerticalSeekBarVolumn pmQ;
    private LinearLayout pmi;
    private FrameLayout pmm;
    private FrescoThumbnailView pmn;
    private ImageView pmq;
    private ImageView pms;
    RelativeLayout pmw;
    private ImageView pmx;
    private ImageView pmz;
    private Rect plZ = null;
    private Rect pma = null;
    private float pmb = 0.0f;
    private Window pmc = null;
    private WindowManager.LayoutParams pmd = null;
    private boolean bB = false;
    private View pme = null;
    private View pkw = null;
    private View pmf = null;
    private View pmg = null;
    private View pmh = null;
    private ImageView pkB = null;
    private ImageView pmj = null;
    private ImageButton pmk = null;
    private FrescoThumbnailView pml = null;
    private LinearLayout pmo = null;
    private EditText pmp = null;
    private View pmr = null;
    private boolean pmt = false;
    private int pmu = 0;
    private int bV = 0;
    private long pmv = 0;
    private ProgressDialog pmy = null;
    private boolean pmB = true;
    private int pmD = -1;
    private boolean pmL = false;
    private TextView pmM = null;
    private TextView pmN = null;
    private int pmO = 0;
    private boolean pmP = false;
    private boolean pmR = false;
    private final Rect pmS = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.pqO = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.pkd = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.pqt = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.pqI != null && !((Activity) this.pqI).isFinishing()) {
            evw();
        }
        return this.pqt;
    }

    public void euS() {
        aM(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.pqI, "能量_num", "横屏", new Object[0]);
    }

    public boolean evf() {
        if (this.prr == null || !this.prr.isShown()) {
            return false;
        }
        this.prr.d();
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
        if (z3 || this.pqt.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.pqO)) {
            z = h.etY().e;
        } else {
            z = h.etY().b;
        }
        r(z);
        if (this.prn != null) {
            this.prn.b();
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
        if (this.pmC != null) {
            this.pmC.b();
            this.pmC = null;
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
            euY();
            y();
            if (this.pkd != null) {
                this.pkd.onConfigurationChanged(configuration);
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
        if (this.pmE != null && this.pmD != i3) {
            this.pmE.a();
            this.pmE = null;
        }
        if (this.pmE == null) {
            this.pmE = (PopH5Menu) ((ViewStub) this.pqt.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pmE.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.pmE.setLayoutParams(layoutParams);
            this.pmD = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.f4233a = listItem.mUrl;
        h5Options.h = -1;
        this.pmE.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.pqI instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b eur = ((VideoPlayer) this.pqI).eur();
                    if (this.prz == null) {
                        this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.prz.setVisibility(0);
                    this.prz.a(i, eur);
                }
            } else if (bVar.f4152a == 3) {
                if (this.pqI instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a eus = ((VideoPlayer) this.pqI).eus();
                    if (this.prz == null) {
                        this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.prz.setVisibility(0);
                    this.prz.a(i, eus);
                }
            } else if (bVar.f4152a == 9) {
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo euL;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.pqH != null && mVar.b.equals(this.pqH.f4119a) && (euL = this.pqH.euL()) != null) {
            euL.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void evw() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.pqO)) {
            this.pqO = "1";
        }
        this.pmu = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
        this.bV = tv.chushou.zues.utils.systemBar.b.hI(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.pmW = ((VideoPlayer) this.pqI).euh();
        this.pqH = ((VideoPlayer) this.pqI).euk();
        c(this.pqt);
        if (this.pqO.equals("1")) {
            this.pkb = ((VideoPlayer) this.pqI).eul();
            this.pkb.a(this);
            if (this.pmF != null) {
                this.pmF.a();
                this.pmF = null;
                this.pmG = null;
            }
            this.pmG = (GiftAnimationLayout) this.pqt.findViewById(a.f.ll_gift_animation);
            this.pmG.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.pqH != null) {
                this.pmF = new com.kascend.chushou.player.b.a(this.pqI.getApplicationContext(), this.pmG);
                this.pmF.a(this.pqH);
            }
            this.B = (TextView) this.pqt.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.pqO.equals("3")) {
        }
        eva();
        if (this.pkb != null) {
            this.pkb.d();
        }
        evs();
        this.pmq = (ImageView) this.pqt.findViewById(a.f.btn_lockscreen);
        this.pmq.setOnClickListener(this);
        if (this.f4123a == null) {
            this.f4123a = (ImageButton) this.pqt.findViewById(a.f.resumebutton);
            this.f4123a.setOnTouchListener(this);
        }
        this.pqC = (PlayerErrorView) this.pqt.findViewById(a.f.view_net_error_msg);
        this.pqC.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        edV();
        this.prr = (PaoGuideView) this.pqt.findViewById(a.f.rlPaoGuideView);
        this.pmH = (ImageView) this.pqt.findViewById(a.f.iv_send_danmu);
        this.pmh = this.pqt.findViewById(a.f.rt_layout);
        this.pml = (FrescoThumbnailView) this.pmh.findViewById(a.f.btn_gift);
        this.pmm = (FrameLayout) this.pmh.findViewById(a.f.flfl_bottom_gift);
        this.pmn = (FrescoThumbnailView) this.pmh.findViewById(a.f.btn_recharge);
        this.pmn.setOnClickListener(this);
        a(this.pqH == null ? null : this.pqH.pjL);
        this.prx = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.bB = false;
                b.this.y(false);
                if (b.this.pqJ != null) {
                    b.this.pqJ.removeMessages(1);
                    b.this.pqJ.D(1, 5000L);
                }
                b.this.pmq.setVisibility(0);
                b.this.pmh.setVisibility(0);
                b.this.pkw.setVisibility(0);
                b.this.pme.setVisibility(0);
                if (b.this.pmC != null) {
                    b.this.pmC.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.pqI, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.bB = true;
                b.this.y(true);
                b.this.pmq.setVisibility(8);
                b.this.pmh.setVisibility(8);
                if (b.this.pmC != null) {
                    b.this.pmC.a(false);
                }
                b.this.pkw.setVisibility(8);
                b.this.pme.setVisibility(8);
                if (b.this.pqJ != null) {
                    b.this.pqJ.removeMessages(1);
                }
                if (b.this.prn != null) {
                    b.this.prn.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.pqI, 14.0f) + b.this.prn.getMeasuredHeight(), 12);
                }
            }
        };
        this.pmo = (LinearLayout) this.pqt.findViewById(a.f.rl_seekbar);
        this.pmw = (RelativeLayout) this.pqt.findViewById(a.f.rl_paoicon);
        this.pmw.setOnClickListener(this);
        this.pro = (RoundProgressBar) this.pqt.findViewById(a.f.roundProgressBar);
        this.prq = (FrescoThumbnailView) this.pqt.findViewById(a.f.iv_paoicon);
        this.prp = (TextView) this.pqt.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.prs = 0L;
        com.kascend.chushou.player.ui.a.a euu = ((VideoPlayer) this.pqI).euu();
        a(euu.evO());
        BangInfo evP = euu.evP();
        if (evP != null) {
            a(evP, euu.d());
        }
        if (this.pqO.equals("3")) {
            this.pmo.setVisibility(0);
            this.pmm.setVisibility(8);
            this.pmH.setVisibility(0);
            this.pmH.setOnClickListener(this);
        } else {
            this.pmH.setVisibility(8);
            this.pmo.setVisibility(8);
            this.pmm.setVisibility(0);
            this.pml.setOnClickListener(this);
        }
        euW();
        if (tv.chushou.zues.utils.systemBar.b.hJ(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pmh.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.pmh.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pkw.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.pkw.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pmg.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.pmg.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.pme.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.pme.setLayoutParams(layoutParams4);
        }
        evy();
        aG();
        euY();
        this.h = (TextView) this.pqt.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.pqt.findViewById(a.f.time_seekbar_relative);
        if (!this.pqO.equals("3")) {
            if (this.pqH.euJ() != null) {
                this.pmz.setVisibility(0);
            } else {
                this.pmz.setVisibility(8);
            }
        }
        evx();
        n();
        k(100);
        this.pmI = (FoodView) this.pqt.findViewById(a.f.kav_room_ad);
        this.pqJ = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.aM(false, true);
                            break;
                        case 2:
                            b.this.pqJ.removeMessages(2);
                            if (b.this.pmq != null) {
                                b.this.pmq.setVisibility(8);
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
                            TextView textView = (TextView) b.this.pqt.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.pqI.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.pqJ.D(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.pqJ.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.pqJ.D(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aL(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.pqI).q) {
                                b.this.a(b.this.pqJ);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.pqI).q) {
                                b.this.b(b.this.pqJ);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.pqI).g = true;
                            b.this.pmW.seekTo((int) b.this.orw);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.pqH.d()) {
                                b.this.pmW.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.pmW.getPlayState() == 4) {
                                int currentPos = b.this.pmW.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.pqJ != null) {
                                    b.this.pqJ.D(15, i3);
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
                            b.this.pqG.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.pqH != null) {
            a(this.pqH.euK());
        }
        if (this.pmW != null && (this.pmW.getPlayState() == 3 || this.pmW.getPlayState() == 4)) {
            AF(false);
            if (this.pqH.d()) {
                this.ak = false;
                AG(true);
                if (this.pmW.getDuration() > 60000) {
                    if (this.pmW.getDuration() < 300000) {
                        this.pqM = 60000;
                    } else {
                        this.pqM = Math.min(this.pmW.getDuration(), 300000);
                    }
                } else {
                    this.pqM = this.pmW.getDuration();
                }
            }
            this.e = false;
            aM(true, false);
            this.pqJ.RT(8);
            if (h() && this.pmW.getPlayState() == 4 && this.pqJ != null) {
                this.pqJ.removeMessages(15);
                this.pqJ.RT(15);
            }
        } else {
            AF(true);
            if (this.e) {
                aM(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] etX = g.etX();
            int i = etX.length == 2 ? etX[1] : 0;
            if (i > 0) {
                View findViewById = this.pqt.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.pqt.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.pqI, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.pqI, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.pqI != null && (this.pqI instanceof VideoPlayer)) {
            ((VideoPlayer) this.pqI).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.pmn.DX(a.e.ic_recharge_old);
            this.pml.DX(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.pmL && !this.k) {
            try {
                if (this.pmW != null) {
                    i = this.pmW.getCurrentPos();
                    i2 = this.pmW.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.pkc.setProgress(i / (i2 / 1000));
                    this.pmM.setText(tv.chushou.zues.utils.b.v(this.pmW.getDuration(), false));
                    this.pmN.setText(tv.chushou.zues.utils.b.v(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void evx() {
        this.pkc = (ProgressBar) this.pqt.findViewById(a.f.progressBarl);
        if (this.pkc != null) {
            if (this.pkc instanceof SeekBar) {
                ((SeekBar) this.pkc).setOnSeekBarChangeListener(new C0995b());
            }
            this.pkc.setMax(1000);
        }
        this.pmM = (TextView) this.pqt.findViewById(a.f.tv_time_duration);
        this.pmN = (TextView) this.pqt.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.pqt.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.pqt.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a euu;
        BangInfo evP;
        if (config != null) {
            this.pru = config;
            if (!config.display) {
                this.pmw.setVisibility(8);
            } else if ((this.pqI instanceof VideoPlayer) && (evP = (euu = ((VideoPlayer) this.pqI).euu()).evP()) != null) {
                a(evP, euu.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.pru == null || this.pru.display) && this.pmw != null) {
            this.pmw.setVisibility(0);
            this.prp.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pqI instanceof VideoPlayer) {
            if ((this.pru == null || this.pru.display) && this.pmw != null) {
                if (j > 0) {
                    this.pmw.setVisibility(0);
                    boolean z = this.prt;
                    this.prt = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.pqI.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.prp.setText(cVar);
                    return;
                }
                this.prt = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0995b implements SeekBar.OnSeekBarChangeListener {
        C0995b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.pqu != null) {
                if (b.this.pmO != i || b.this.pmP != z) {
                    b.this.pmO = i;
                    b.this.pmP = z;
                    if (z) {
                        if (b.this.pmL) {
                            b.this.orw = (b.this.pmW.getDuration() / 1000) * i;
                        }
                        b.this.pmN.setText(tv.chushou.zues.utils.b.v((int) b.this.orw, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.v((int) b.this.orw, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.v(((int) b.this.orw) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.pmL = true;
            b.this.m = b.this.pmW.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.pqJ != null) {
                if (b.this.pmL) {
                    b.this.pmL = false;
                }
                b.this.pqJ.removeMessages(14);
                b.this.pqJ.RT(14);
            }
        }
    }

    private void k(int i) {
        this.pkc.setSecondaryProgress((i * 1000) / 100);
    }

    private void evs() {
        this.pmQ = (VerticalSeekBarVolumn) this.pqt.findViewById(a.f.volumn_seekbar);
        this.pmQ.setOnSeekBarChangeListener(new c());
        int streamVolume = this.pqK.getStreamVolume(3);
        this.pmQ.setProgress(QF(streamVolume));
        x(QF(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.pqt.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.pjZ = new d.a();
            this.c = new GestureDetector(this.pqI, this.pjZ);
        }
    }

    private void evy() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.pmc == null) {
                this.pmc = ((Activity) this.pqI).getWindow();
            }
            this.pmd = this.pmc.getAttributes();
            this.pmb = ((VideoPlayer) this.pqI).k / 255.0f;
            ((VerticalSeekBarVolumn) this.pqt.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.pmb));
        }
    }

    private void aG() {
        this.pqt.findViewById(a.f.btn_send).setOnClickListener(this);
        this.pqt.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.pqI.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.pqt.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.pmp == null) {
            this.pmp = (EditText) this.pqt.findViewById(a.f.et_input);
            this.pmp.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.pqt.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euV() {
        if (this.pmA != null) {
            this.pmA.dismiss();
            this.pmA = null;
        }
        if (this.pqI != null) {
            ((VideoPlayer) this.pqI).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.pkw = this.pqt.findViewById(a.f.topview);
        this.pmi = (LinearLayout) this.pqt.findViewById(a.f.topRight);
        this.pmf = this.pkw.findViewById(a.f.rl_download);
        this.pmg = this.pqt.findViewById(a.f.topKeyboardView);
        this.pqt.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.pkw.getVisibility() == 0;
        if (this.pmu > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pkw.getLayoutParams();
            layoutParams.topMargin = this.pmu;
            this.pkw.setLayoutParams(layoutParams);
        }
        this.pqt.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.pqt.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                str = this.pqH.euJ().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.pqt.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.pmx = (ImageView) this.pqt.findViewById(a.f.subscribe_icon);
        this.pmx.setOnClickListener(this);
        this.pmz = (ImageView) this.pqt.findViewById(a.f.report_icon);
        this.pmz.setOnClickListener(this);
        q();
    }

    private void euW() {
        boolean z;
        this.pme = this.pqt.findViewById(a.f.bottomview);
        this.pmk = (ImageButton) this.pme.findViewById(a.f.playbutton);
        this.pmk.setOnTouchListener(this);
        this.pqz = (ImageButton) this.pqt.findViewById(a.f.btn_barrage);
        this.pqA = (ImageButton) this.pqt.findViewById(a.f.btn_audio);
        this.pms = (ImageView) this.pqt.findViewById(a.f.iv_danmu);
        if (!this.pqO.equals("3")) {
            this.pme.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.pme.findViewById(a.f.btn_refresh).setVisibility(0);
            this.pqz.setVisibility(0);
            this.pms.setVisibility(8);
            if (this.pqH != null && this.pqH.f != null) {
                for (int i = 0; i < this.pqH.f.size(); i++) {
                    if ("2".equals(this.pqH.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.pqA.setVisibility(0);
            } else {
                this.pqA.setVisibility(8);
            }
            this.pme.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.pqz.setOnClickListener(this);
            if (h.etY().e) {
                this.pqz.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pqz.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.pqH.d) {
                this.pqA.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.pqA.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.pqA.setOnClickListener(this);
            this.pkB = (ImageView) this.pme.findViewById(a.f.btn_hotword);
            this.pmj = (ImageView) this.pqt.findViewById(a.f.iv_task_badge);
            this.pkB.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.pqI, a.C0988a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.etY().c) {
                        b.this.pkB.clearAnimation();
                        b.this.pkB.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.pkB.clearAnimation();
            if (h.etY().c) {
                this.pkB.startAnimation(animationSet);
                this.pmj.setVisibility(0);
            }
        } else {
            this.pme.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.pme.findViewById(a.f.btn_refresh).setVisibility(8);
            this.pqz.setVisibility(8);
            this.pqA.setVisibility(8);
            this.pms.setVisibility(0);
            this.pms.setOnClickListener(this);
            if (h.etY().b) {
                this.pms.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pms.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.pme.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.pqI != null) {
            ((VideoPlayer) this.pqI).e(true);
        }
        if (this.pqJ != null) {
            this.pqJ.cs(null);
            this.pqJ = null;
        }
        this.c = null;
        this.pjZ = null;
        this.pmq = null;
        if (this.pmp != null) {
            this.pmp.addTextChangedListener(null);
            this.pmp.setOnEditorActionListener(null);
            this.pmp = null;
        }
        this.pkw = null;
        this.pqz = null;
        this.pqA = null;
        this.pme = null;
        this.pmh = null;
        if (this.pmF != null) {
            this.pmF.a();
            this.pmF = null;
            this.pmG = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a evo() {
        return this.pmF;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.pqt == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.prz == null || !this.prz.a(i, keyEvent)) {
                    if ((this.pmE == null || !this.pmE.onKeyDown(i, keyEvent)) && !evf() && !euU()) {
                        if (this.pmg != null && this.pmg.getVisibility() == 0) {
                            aL(false, true);
                            return true;
                        } else if (this.pmr != null && this.pmr.isShown()) {
                            aB();
                            return true;
                        } else if (this.pmt && this.pqJ != null) {
                            if (this.pmq != null) {
                                this.pmq.setVisibility(0);
                            }
                            this.pqJ.removeMessages(2);
                            this.pqJ.D(2, IMConnection.RETRY_DELAY_TIMES);
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
                int progress = ((VerticalSeekBarVolumn) this.pqt.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.pqt.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.pqJ != null) {
                    this.pqJ.removeMessages(3);
                    this.pqJ.D(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean evz() {
        if (this.pmt) {
            this.pmq.setVisibility(0);
            this.pqJ.removeMessages(2);
            this.pqJ.D(2, IMConnection.RETRY_DELAY_TIMES);
        }
        return this.pmt;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.pmt) {
            if (view.getId() == a.f.btn_lockscreen) {
                aL();
                return;
            }
            this.pmq.setVisibility(0);
            this.pqJ.removeMessages(2);
            this.pqJ.D(2, IMConnection.RETRY_DELAY_TIMES);
            tv.chushou.zues.utils.g.d(this.pqI, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aJ(getActivity()) && tv.chushou.zues.utils.systemBar.b.aK(getActivity())) {
                    o(view, tv.chushou.zues.utils.systemBar.b.hI(getActivity()), 0);
                    return;
                } else {
                    o(view, 0, 0);
                    return;
                }
            }
            o(view, 0, this.pkw.getHeight() + this.pkw.getTop());
        } else if (id == a.f.btn_send) {
            if (this.pqO.equals("3")) {
                String trim = this.pmp.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.O(this.pqI, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.pmp.setText((CharSequence) null);
                aL(false, true);
            } else if (a(this.pmp.getText().toString(), false)) {
                aL(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            aL();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                p(view, tv.chushou.zues.utils.systemBar.b.hI(getActivity()), 0);
            } else {
                p(view, 0, tv.chushou.zues.utils.a.dip2px(this.pqI, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            p(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            euV();
            com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = evG() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.prn == null;
                b(false, false);
                if (z && this.bV > 0 && this.prn != null && tv.chushou.zues.utils.systemBar.b.aJ(getActivity()) && tv.chushou.zues.utils.systemBar.b.aK(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.prn.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.prn.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.prn == null;
                if (this.pqI.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.prn != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.prn.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.prn.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.pqH.euJ().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aL(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            aM(false, false);
            this.pqJ.D(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.etY().c) {
                h.etY().b(false);
                this.pkB.clearAnimation();
                this.pmj.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                m(view, this.pme.findViewById(a.f.ll_keyboard).getLeft(), this.pme.getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
            } else {
                m(view, this.pme.findViewById(a.f.ll_keyboard).getLeft(), this.pme.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                tv.chushou.zues.utils.g.d(this.pqI, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.pqI, evG(), false);
        } else if (id == a.f.btn_screenChange) {
            euV();
        } else if (id == a.f.rl_paoicon) {
            euS();
        } else if (id == a.f.subscribe_icon) {
            evb();
        } else if (id == a.f.report_icon) {
            if (this.pqO.equals("3")) {
                eve();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                evc();
            }
        } else if (id == a.f.btn_audio && !this.pqH.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Sc(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.pmv <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.Sc(a.i.str_too_fast);
            return false;
        } else {
            if (!h.etY().e) {
                s(true);
                vB();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
            if (com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a(((VideoPlayer) this.pqI).euk().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.pmv = System.currentTimeMillis();
                a(this.pqH.euJ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.pqH.h);
                if (!z) {
                    this.pmp.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.pqO.equals("3")) {
            if (this.pqz != null) {
                if (z) {
                    this.pqz.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.pqz.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.pms != null) {
            if (z) {
                this.pms.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.pms.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout evd() {
        if (this.pqt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.pqt.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.prv != null) {
            this.prv.setVisibility(z ? 0 : 8);
            if (!z) {
                this.prv.eHa();
            }
        }
        tv.chushou.zues.utils.g.A(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void aL() {
        if (this.pqH.d()) {
            if (this.pmt) {
                this.pmq.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.d(this.pqI, this.pqI.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.pmq.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.d(this.pqI, this.pqI.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.pmt = !this.pmt;
            if (this.pmp != null) {
                this.pmp.setEnabled(this.pmt ? false : true);
            }
        }
    }

    public void aL(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bD(this.pmp);
            this.pmp.setText("");
            this.pmh.setVisibility(8);
            this.pmq.setVisibility(8);
            this.pkw.setVisibility(8);
            this.pme.setVisibility(8);
            this.pmg.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
        if (this.pmg.getVisibility() != 8 && z2) {
            this.pmg.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_top_anim));
        }
        this.pmh.setVisibility(8);
        this.pmq.setVisibility(8);
        this.pkw.setVisibility(8);
        this.pme.setVisibility(8);
        this.pmg.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        aM(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.pmi != null) {
            this.pmi.setVisibility(z ? 0 : 4);
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
            if (this.pmC != null) {
                this.pmC.a(this.e);
            }
            return this.e;
        }
        if (this.pqJ != null) {
            this.pqJ.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.pqI).e(true);
            if (!z3) {
                if (this.pme.getVisibility() != 0 && z2) {
                    this.pme.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_bottom_anim));
                }
                this.pme.setVisibility(0);
                this.pmh.setVisibility(0);
                this.pmq.setVisibility(0);
                this.pmf.setVisibility(o() ? 0 : 8);
            }
            if (this.pkw.getVisibility() != 0 && z2) {
                this.pkw.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_top_anim));
            }
            u(!z3);
            this.pkw.setVisibility(0);
            if (this.pqJ != null) {
                this.pqJ.D(1, 5000L);
            }
            y(false);
            if (this.pmC != null) {
                this.pmC.a(true);
            }
        } else {
            ((VideoPlayer) this.pqI).e(false);
            if (this.pra != null) {
                this.pra.dismiss();
            }
            if (this.prb != null) {
                this.prb.dismiss();
            }
            if (this.pri != null) {
                this.pri.dismiss();
            }
            if (this.pme != null) {
                if (this.pme.getVisibility() != 8 && z2) {
                    this.pme.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_bottom_anim));
                }
                this.pme.setVisibility(8);
            }
            if (this.pmh != null) {
                this.pmh.setVisibility(8);
                if (this.pkw.getVisibility() != 8 && z2) {
                    this.pkw.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_top_anim));
                }
                this.pkw.setVisibility(8);
                this.pmq.setVisibility(8);
                y(true);
                a(false);
                if (this.pmC != null) {
                    this.pmC.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void euY() {
        Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
        if (this.ap == 1) {
            this.ar = Math.min(hD.x, hD.y);
            this.aq = Math.max(hD.x, hD.y);
        } else {
            this.ar = Math.max(hD.x, hD.y);
            this.aq = Math.min(hD.x, hD.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.plZ == null) {
            this.plZ = new Rect(0, 0, i / 5, i2);
        } else {
            this.plZ.set(0, 0, i / 5, i2);
        }
        if (this.pma == null) {
            this.pma = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.pma.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.plZ == null) {
            return false;
        }
        return this.plZ.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.pqt.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.pqt.findViewById(a.f.brightness_view);
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
        if (this.pma == null) {
            return false;
        }
        return this.pma.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.pqt.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.pqt.findViewById(a.f.volumn_view);
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
                if (this.pmt) {
                    this.pmq.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.pmt) {
                    this.pqJ.removeMessages(2);
                    this.pqJ.D(2, IMConnection.RETRY_DELAY_TIMES);
                    return true;
                } else if (this.pqJ != null) {
                    this.pqJ.D(3, 1000L);
                    this.pqJ.D(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.pmt) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gV(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.pqK.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int QF(int i) {
        int streamMaxVolume = (i * 10) / this.pqK.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.pqt.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.pqt.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.pqI != null && (this.pqI instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.pqI).a(1, null, this.H, false, false, true);
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
            b.this.pqK.setStreamVolume(3, b.this.gV(i), 0);
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
            b.this.pmb = i / 10.0f;
            ((VideoPlayer) b.this.pqI).l = b.this.pmb;
            ((VideoPlayer) b.this.pqI).k = b.this.pmb * 255.0f;
            b.this.pmd.screenBrightness = b.this.pmb;
            b.this.pmc.setAttributes(b.this.pmd);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.pqt.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (aq(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.pqt.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.pqM > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.pkc.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.pqt.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.pqt.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.pmW.getCurrentPos();
                            int duration = this.pmW.getDuration();
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
                                this.pkc.setProgress(i3 / (duration / 1000));
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
            if (this.pmg.getVisibility() == 8 && (this.pmr == null || !this.pmr.isShown())) {
                boolean z = this.pqC != null && this.pqC.getVisibility() == 0;
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

    public boolean euU() {
        if (this.bB) {
            if (this.prn != null) {
                this.prn.e();
            }
            y(false);
            if (this.pme != null) {
                this.pme.setVisibility(0);
            }
            if (this.pkw != null) {
                this.pkw.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.pqI instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.pqH != null) {
            this.pqH.f = null;
            if (this.pqH.euJ() != null) {
                this.pqH.euJ().mRoominfo.mGameId = null;
            }
        }
        if (this.pqO.equals("3")) {
            if (this.pmW != null) {
                this.pmW.seekTo(0L);
                e(true);
            }
            euV();
            return;
        }
        euV();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.pmt) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                tv.chushou.zues.utils.g.d(this.pqI, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.pmW.getPlayState() == 4) {
                        euZ();
                        e(true);
                    } else {
                        if (this.pmI != null) {
                            this.pmI.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.pqH.a(false);
                            ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                        } else if (!this.pqO.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                        } else if (this.pmW.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.pmW.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.pmW.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            AG(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.pmW.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.pmW.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                tv.chushou.zues.utils.g.d(this.pqI, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.pqH.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                } else if (!this.pqO.equals("3")) {
                    ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                    this.ai = false;
                    AG(true);
                    a(false, !this.ak);
                } else if (this.pmW.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                    this.ai = false;
                    AG(true);
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
        if (!this.pqO.equals("3")) {
            if (this.pqH != null && this.pqH.euL() != null) {
                str = this.pqH.euL().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.etR().z != null && com.kascend.chushou.a.a.etR().z.contains(str) && this.pqH != null && !this.pmR) {
            this.pmR = true;
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
                        b.this.pmR = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.pmI != null) {
            this.pmI.a(listItem, this.ap == 1, a.C0988a.zues_sweetalert_modal_in, a.C0988a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.pmR = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.pmk != null) {
                this.pmk.setImageResource(a.e.btn_pause_selector);
            }
            if (this.f4123a != null) {
                this.f4123a.setVisibility(8);
            }
            if (this.pqC != null) {
                this.pqC.setVisibility(8);
                return;
            }
            return;
        }
        if (this.pmk != null) {
            this.pmk.setImageResource(a.e.btn_play_selector);
        }
        if (this.f4123a != null) {
            if (z2 != (this.f4123a.getVisibility() == 0)) {
                if (z2) {
                    this.f4123a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.f4123a.setVisibility(0);
                    return;
                }
                this.f4123a.setVisibility(8);
                if (this.pqC != null) {
                    this.pqC.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void eva() {
        this.pqu = new SurfaceView(this.pqI);
        SurfaceView surfaceView = (SurfaceView) this.pqu;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.pqt).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void evj() {
        if (this.prv != null) {
            this.prv.eHa();
            this.prv.setVisibility(8);
            this.prv.unInit();
            ((RelativeLayout) this.pqt).removeView(this.prv);
            this.prv = null;
        }
        if (this.pqu != null) {
            this.pqu.setVisibility(8);
            ((RelativeLayout) this.pqt).removeView(this.pqu);
            this.pqu = null;
        }
        eva();
        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
    }

    private void m(View view, int i, int i2) {
        if (this.pqJ != null) {
            y(true);
            this.pqJ.removeMessages(1);
            this.pme.setVisibility(0);
            this.pmh.setVisibility(8);
            this.pkw.setVisibility(8);
            this.pmq.setVisibility(8);
        }
        if (this.pri == null) {
            al();
            this.pri.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.pkB.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.pri.isShowing()) {
            this.pri.showAtLocation(view, 83, i, i2);
            this.pkB.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.pqH.euJ().mRoominfo.mRoomID);
            return;
        }
        this.pri.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.pmE != null && this.pmE.b()) {
                this.pmE.getGlobalVisibleRect(this.pmS);
                if (!this.pmS.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.pmE.a();
                    return true;
                }
            }
            if (this.bB && f(this.prn.b, motionEvent)) {
                euU();
                return true;
            }
            if (!evz()) {
                if (System.currentTimeMillis() - this.cu < 300 && this.pmI != null && this.pmI.isShown()) {
                    this.pmI.a();
                    if (this.pmW.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.pqH.a(false);
                            ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                        } else if (!this.pqO.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                        } else if (this.pmW.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.pqI).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.pmW.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.pmW.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            AG(true);
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
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
        if (this.pmr != null) {
            if (this.pmr.isShown()) {
                this.pmr.startAnimation(AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_top_anim));
            }
            this.pmr.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.pqI).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.pqI).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.pqA != null) {
                this.pqA.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hJ(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pmh.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.pmh.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pkw.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.pkw.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pmg.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.pmg.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.pme.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.pme.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
            this.pmx.setVisibility(0);
            if (this.pqH.euJ().mRoominfo.mIsSubscribed) {
                this.pmx.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.pmx.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.pmx.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void evb() {
        RoomInfo roomInfo;
        if (this.pqH != null && this.pqH.euJ() != null && (roomInfo = this.pqH.euJ().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.pqI, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.eIp();
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
        if (this.pqH != null && this.pqH.euJ() != null && (roomInfo = this.pqH.euJ().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.O(b.this.pqI, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.O(b.this.pqI, a.i.subscribe_success);
                            }
                            if (b.this.pqH != null && b.this.pqH.euJ() != null && (roomInfo2 = b.this.pqH.euJ().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.pqI, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.d(b.this.pqI, str2);
                    }
                }
            };
            if (this.pqH != null && this.pqH.h != null) {
                try {
                    str = new JSONObject(this.pqH.h).optString("_sc");
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
            if (this.pmy == null) {
                this.pmy = new ProgressDialog(this.pqI);
                this.pmy.setProgressStyle(0);
                this.pmy.requestWindowFeature(1);
                this.pmy.setMessage(this.pqI.getText(a.i.update_userinfo_ing));
                this.pmy.setCancelable(true);
            }
            if (!this.pmy.isShowing()) {
                this.pmy.show();
            }
        } else if (this.pmy != null && this.pmy.isShowing()) {
            this.pmy.dismiss();
        }
    }

    private void evc() {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
            if (this.pmA == null) {
                this.pmA = new f(getActivity());
            }
            this.pmA.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.pmA = null;
                }
            });
            RoomInfo roomInfo = this.pqH.euJ().mRoominfo;
            this.pmA.a();
            this.pmA.a(roomInfo);
            if (!this.pmA.isShowing()) {
                this.pmA.show();
            }
        }
    }

    private void eve() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.pmQ != null && this.pqK != null && this.pqI != null && (this.pqI instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.pmQ;
            VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
            verticalSeekBarVolumn.setProgressOnly(QF(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.pkd != null) {
            this.pkd.eHT();
        }
        if (this.pqt != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.pmC == null) {
                this.pmC = new com.kascend.chushou.player.ui.giftpopup.a(this.pqt, i);
            } else if (this.pmC.a() != i) {
                this.pmC.b();
                this.pmC = null;
                this.pmC = new com.kascend.chushou.player.ui.giftpopup.a(this.pqt, i);
            }
            List<ListItem> j = this.pqH != null ? this.pqH.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
            if (videoPlayer != null) {
                this.pmC.a(j, videoPlayer.euq(), videoPlayer.eur(), videoPlayer.eus(), videoPlayer.eut());
                this.pmC.a(this.e);
                if (this.pqH != null && this.pqH.pjJ != null) {
                    this.pmC.a(this.pqH.pjJ, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.pqH != null) {
                                b.this.pqH.pjJ = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.pmC != null && this.pqH != null) {
                    this.pmC.b(this.pqH.pjM);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void a(int i) {
        if (this.pmC != null && this.pqI != null) {
            this.pmC.a(((VideoPlayer) this.pqI).euq());
            this.pmC.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void D() {
        if (this.pqI instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a euq = ((VideoPlayer) this.pqI).euq();
            if (this.prz == null) {
                this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.prz.setVisibility(0);
            this.prz.a(i, euq);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.pmC != null) {
            this.pmC.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.pmn != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.pmn.setVisibility(0);
                    this.pmn.ce(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.pmn.setVisibility(8);
                }
            }
            if (this.pml != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.pmm.setVisibility(0);
                    this.pml.ce(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.pmm.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pmC != null) {
            this.pmC.a(((VideoPlayer) this.pqI).eur());
            this.pmC.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pmC != null) {
            this.pmC.a(((VideoPlayer) this.pqI).eur());
            this.pmC.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(long j) {
        if (this.pmC != null) {
            this.pmC.a(((VideoPlayer) this.pqI).eus());
            this.pmC.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1001a
    public void c(int i) {
        if (this.pmC != null) {
            this.pmC.a(((VideoPlayer) this.pqI).eut());
            this.pmC.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        AF(false);
        super.F();
    }

    private void c(View view) {
        this.pmJ = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.ple = (TextView) view.findViewById(a.f.tv_4g_video);
        this.ple.setText(new tv.chushou.zues.widget.a.c().R(this.pqI, a.e.videoplayer_4g_video).append("  ").append(this.pqI.getString(a.i.videoplayer_4g_video)));
        this.pmK = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.pmK.setText(new tv.chushou.zues.widget.a.c().R(this.pqI, a.e.videoplayer_4g_audio).append("  ").append(this.pqI.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.euV();
                    com.kascend.chushou.toolkit.a.c.a(b.this.pqI, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.pmJ.setVisibility(8);
                    ((VideoPlayer) b.this.pqI).c(b.this.plg);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.pmJ.setVisibility(8);
                    ((VideoPlayer) b.this.pqI).d(b.this.plg);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
        findViewById.setLayoutParams(layoutParams);
        this.ple.setOnClickListener(onClickListener);
        this.pmK.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.pqH != null && !tv.chushou.zues.utils.h.isEmpty(this.pqH.f)) {
            g(this.pqH.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void g(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.plg = z;
            this.p = false;
            if (this.pqH != null && this.pqH.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.pqH.f.size()) {
                        break;
                    } else if (!"2".equals(this.pqH.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.pmJ != null) {
                this.pmJ.setVisibility(0);
                this.ple.setVisibility(0);
                this.pmK.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.pmJ != null) {
            this.pmJ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pmC != null && this.pqH != null) {
            this.pmC.b(this.pqH.pjM);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.pqt != null && (findViewById = this.pqt.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pml != null) {
            this.pml.performClick();
        }
    }
}
