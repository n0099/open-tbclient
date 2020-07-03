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
    public int bu;
    private TextView nih;
    private boolean nij;
    RelativeLayout njB;
    private ImageView njC;
    private ImageView njE;
    private f njF;
    private com.kascend.chushou.player.ui.giftpopup.a njG;
    private PopH5Menu njI;
    private com.kascend.chushou.player.b.a njJ;
    private GiftAnimationLayout njK;
    private ImageView njL;
    private FoodView njM;
    private RelativeLayout njN;
    private TextView njO;
    private VerticalSeekBarVolumn njU;
    private long njW;
    private LinearLayout njn;
    private FrameLayout njr;
    private FrescoThumbnailView njs;
    private ImageView njv;
    private ImageView njx;
    private Rect njd = null;
    private Rect nje = null;
    private float njf = 0.0f;
    private Window njg = null;
    private WindowManager.LayoutParams njh = null;
    private boolean nji = false;
    private View njj = null;
    private View nhy = null;
    private View njk = null;
    private View njl = null;
    private View njm = null;
    private ImageView nhD = null;
    private ImageView njo = null;
    private ImageButton njp = null;
    private FrescoThumbnailView njq = null;
    private LinearLayout njt = null;
    private EditText nju = null;
    private View njw = null;
    private boolean njy = false;
    private int njz = 0;
    private int bV = 0;
    private long njA = 0;
    private ProgressDialog njD = null;
    private boolean bBj = true;
    private int njH = -1;
    private boolean njP = false;
    private TextView njQ = null;
    private TextView njR = null;
    private int njS = 0;
    private boolean njT = false;
    private boolean njV = false;
    private final Rect njX = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.nhg = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nnq = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.nnG != null && !((Activity) this.nnG).isFinishing()) {
            aC();
        }
        return this.nnq;
    }

    public void dJL() {
        ay(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nnG, "能量_num", "横屏", new Object[0]);
    }

    public boolean az() {
        if (this.noo == null || !this.noo.isShown()) {
            return false;
        }
        this.noo.d();
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
        if (z3 || this.nnq.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dIP().e;
        } else {
            z = h.dIP().b;
        }
        r(z);
        if (this.nok != null) {
            this.nok.b();
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
        if (this.njG != null) {
            this.njG.b();
            this.njG = null;
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
            dJS();
            y();
            if (this.nhg != null) {
                this.nhg.onConfigurationChanged(configuration);
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
        if (this.njI != null && this.njH != i3) {
            this.njI.a();
            this.njI = null;
        }
        if (this.njI == null) {
            this.njI = (PopH5Menu) ((ViewStub) this.nnq.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point gw = tv.chushou.zues.utils.a.gw(getActivity());
            if (this.ap == 0) {
                int i4 = gw.y;
                i = gw.y;
                i2 = i4;
            } else {
                int i5 = gw.x;
                int i6 = gw.y - ((gw.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njI.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.njI.setLayoutParams(layoutParams);
            this.njH = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.njI.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.nnG instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dJi = ((VideoPlayer) this.nnG).dJi();
                    if (this.nox == null) {
                        this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nox.setVisibility(0);
                    this.nox.a(i, dJi);
                }
            } else if (bVar.a == 3) {
                if (this.nnG instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dJj = ((VideoPlayer) this.nnG).dJj();
                    if (this.nox == null) {
                        this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.nox.setVisibility(0);
                    this.nox.a(i, dJj);
                }
            } else if (bVar.a == 9) {
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dJE;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.nnF != null && mVar.b.equals(this.nnF.a) && (dJE = this.nnF.dJE()) != null) {
            dJE.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void aC() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.njz = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
        this.bV = tv.chushou.zues.utils.systemBar.b.gC(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nkb = ((VideoPlayer) this.nnG).dIY();
        this.nnF = ((VideoPlayer) this.nnG).dJb();
        c(this.nnq);
        if (this.aw.equals("1")) {
            this.nhe = ((VideoPlayer) this.nnG).dJc();
            this.nhe.a(this);
            if (this.njJ != null) {
                this.njJ.a();
                this.njJ = null;
                this.njK = null;
            }
            this.njK = (GiftAnimationLayout) this.nnq.findViewById(a.f.ll_gift_animation);
            this.njK.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.nnF != null) {
                this.njJ = new com.kascend.chushou.player.b.a(this.nnG.getApplicationContext(), this.njK);
                this.njJ.a(this.nnF);
            }
            this.B = (TextView) this.nnq.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dJT();
        if (this.nhe != null) {
            this.nhe.d();
        }
        dKl();
        this.njv = (ImageView) this.nnq.findViewById(a.f.btn_lockscreen);
        this.njv.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.nnq.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nnA = (PlayerErrorView) this.nnq.findViewById(a.f.view_net_error_msg);
        this.nnA.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        ar();
        this.noo = (PaoGuideView) this.nnq.findViewById(a.f.rlPaoGuideView);
        this.njL = (ImageView) this.nnq.findViewById(a.f.iv_send_danmu);
        this.njm = this.nnq.findViewById(a.f.rt_layout);
        this.njq = (FrescoThumbnailView) this.njm.findViewById(a.f.btn_gift);
        this.njr = (FrameLayout) this.njm.findViewById(a.f.flfl_bottom_gift);
        this.njs = (FrescoThumbnailView) this.njm.findViewById(a.f.btn_recharge);
        this.njs.setOnClickListener(this);
        a(this.nnF == null ? null : this.nnF.ngO);
        this.nov = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.nji = false;
                b.this.y(false);
                if (b.this.nnH != null) {
                    b.this.nnH.removeMessages(1);
                    b.this.nnH.B(1, 5000L);
                }
                b.this.njv.setVisibility(0);
                b.this.njm.setVisibility(0);
                b.this.nhy.setVisibility(0);
                b.this.njj.setVisibility(0);
                if (b.this.njG != null) {
                    b.this.njG.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nnG, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.nji = true;
                b.this.y(true);
                b.this.njv.setVisibility(8);
                b.this.njm.setVisibility(8);
                if (b.this.njG != null) {
                    b.this.njG.a(false);
                }
                b.this.nhy.setVisibility(8);
                b.this.njj.setVisibility(8);
                if (b.this.nnH != null) {
                    b.this.nnH.removeMessages(1);
                }
                if (b.this.nok != null) {
                    b.this.nok.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nnG, 14.0f) + b.this.nok.getMeasuredHeight(), 12);
                }
            }
        };
        this.njt = (LinearLayout) this.nnq.findViewById(a.f.rl_seekbar);
        this.njB = (RelativeLayout) this.nnq.findViewById(a.f.rl_paoicon);
        this.njB.setOnClickListener(this);
        this.nol = (RoundProgressBar) this.nnq.findViewById(a.f.roundProgressBar);
        this.non = (FrescoThumbnailView) this.nnq.findViewById(a.f.iv_paoicon);
        this.nom = (TextView) this.nnq.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.nop = 0L;
        com.kascend.chushou.player.ui.a.a dJl = ((VideoPlayer) this.nnG).dJl();
        a(dJl.dKF());
        BangInfo dKG = dJl.dKG();
        if (dKG != null) {
            a(dKG, dJl.d());
        }
        if (this.aw.equals("3")) {
            this.njt.setVisibility(0);
            this.njr.setVisibility(8);
            this.njL.setVisibility(0);
            this.njL.setOnClickListener(this);
        } else {
            this.njL.setVisibility(8);
            this.njt.setVisibility(8);
            this.njr.setVisibility(0);
            this.njq.setOnClickListener(this);
        }
        dJQ();
        if (tv.chushou.zues.utils.systemBar.b.gD(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njm.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.njm.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nhy.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nhy.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.njl.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.njl.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.njj.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.njj.setLayoutParams(layoutParams4);
        }
        dKo();
        dJO();
        dJS();
        this.h = (TextView) this.nnq.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nnq.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.nnF.dJB() != null) {
                this.njE.setVisibility(0);
            } else {
                this.njE.setVisibility(8);
            }
        }
        aD();
        n();
        k(100);
        this.njM = (FoodView) this.nnq.findViewById(a.f.kav_room_ad);
        this.nnH = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ay(false, true);
                            break;
                        case 2:
                            b.this.nnH.removeMessages(2);
                            if (b.this.njv != null) {
                                b.this.njv.setVisibility(8);
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
                            TextView textView = (TextView) b.this.nnq.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nnG.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nnH.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nnH.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nnH.B(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.ax(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nnG).q) {
                                b.this.a(b.this.nnH);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nnG).q) {
                                b.this.b(b.this.nnH);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nnG).g = true;
                            b.this.nkb.seekTo((int) b.this.mEV);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.nnF.d()) {
                                b.this.nkb.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nkb.getPlayState() == 4) {
                                int currentPos = b.this.nkb.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nnH != null) {
                                    b.this.nnH.B(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.as();
                            break;
                        case 18:
                            b.this.dxy();
                            break;
                        case 19:
                            b.this.nnE.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.nnF != null) {
            a(this.nnF.dJC());
        }
        if (this.nkb != null && (this.nkb.getPlayState() == 3 || this.nkb.getPlayState() == 4)) {
            wZ(false);
            if (this.nnF.d()) {
                this.ak = false;
                m(true);
                if (this.nkb.getDuration() > 60000) {
                    if (this.nkb.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.nkb.getDuration(), 300000);
                    }
                } else {
                    this.at = this.nkb.getDuration();
                }
            }
            this.e = false;
            ay(true, false);
            this.nnH.Lz(8);
            if (h() && this.nkb.getPlayState() == 4 && this.nnH != null) {
                this.nnH.removeMessages(15);
                this.nnH.Lz(15);
            }
        } else {
            wZ(true);
            if (this.e) {
                ay(false, false);
            } else {
                y(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dIO = g.dIO();
            int i = dIO.length == 2 ? dIO[1] : 0;
            if (i > 0) {
                View findViewById = this.nnq.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.nnq.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nnG, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nnG, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nnG != null && (this.nnG instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnG).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.njs.zs(a.e.ic_recharge_old);
            this.njq.zs(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.njP && !this.k) {
            try {
                if (this.nkb != null) {
                    i = this.nkb.getCurrentPos();
                    i2 = this.nkb.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nhf.setProgress(i / (i2 / 1000));
                    this.njQ.setText(tv.chushou.zues.utils.b.o(this.nkb.getDuration(), false));
                    this.njR.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void aD() {
        this.nhf = (ProgressBar) this.nnq.findViewById(a.f.progressBarl);
        if (this.nhf != null) {
            if (this.nhf instanceof SeekBar) {
                ((SeekBar) this.nhf).setOnSeekBarChangeListener(new C0821b());
            }
            this.nhf.setMax(1000);
        }
        this.njQ = (TextView) this.nnq.findViewById(a.f.tv_time_duration);
        this.njR = (TextView) this.nnq.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.nnq.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nnq.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dJl;
        BangInfo dKG;
        if (config != null) {
            this.nor = config;
            if (!config.display) {
                this.njB.setVisibility(8);
            } else if ((this.nnG instanceof VideoPlayer) && (dKG = (dJl = ((VideoPlayer) this.nnG).dJl()).dKG()) != null) {
                a(dKG, dJl.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.nor == null || this.nor.display) && this.njB != null) {
            this.njB.setVisibility(0);
            this.nom.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nnG instanceof VideoPlayer) {
            if ((this.nor == null || this.nor.display) && this.njB != null) {
                if (j > 0) {
                    this.njB.setVisibility(0);
                    boolean z = this.noq;
                    this.noq = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nnG.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.nom.setText(cVar);
                    return;
                }
                this.noq = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0821b implements SeekBar.OnSeekBarChangeListener {
        C0821b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.njS != i || b.this.njT != z) {
                    b.this.njS = i;
                    b.this.njT = z;
                    if (z) {
                        if (b.this.njP) {
                            b.this.mEV = (b.this.nkb.getDuration() / 1000) * i;
                        }
                        b.this.njR.setText(tv.chushou.zues.utils.b.o((int) b.this.mEV, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.mEV, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.mEV) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.njP = true;
            b.this.m = b.this.nkb.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nnH != null) {
                if (b.this.njP) {
                    b.this.njP = false;
                }
                b.this.nnH.removeMessages(14);
                b.this.nnH.Lz(14);
            }
        }
    }

    private void k(int i) {
        this.nhf.setSecondaryProgress((i * 1000) / 100);
    }

    private void dKl() {
        this.njU = (VerticalSeekBarVolumn) this.nnq.findViewById(a.f.volumn_seekbar);
        this.njU.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nnI.getStreamVolume(3);
        this.njU.setProgress(Kk(streamVolume));
        x(Kk(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.nnq.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.nhc = new d.a();
            this.c = new GestureDetector(this.nnG, this.nhc);
        }
    }

    private void dKo() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.njg == null) {
                this.njg = ((Activity) this.nnG).getWindow();
            }
            this.njh = this.njg.getAttributes();
            this.njf = ((VideoPlayer) this.nnG).k / 255.0f;
            ((VerticalSeekBarVolumn) this.nnq.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.njf));
        }
    }

    private void dJO() {
        this.nnq.findViewById(a.f.btn_send).setOnClickListener(this);
        this.nnq.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nnG.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.nnq.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.nju == null) {
            this.nju = (EditText) this.nnq.findViewById(a.f.et_input);
            this.nju.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.nnq.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJP() {
        if (this.njF != null) {
            this.njF.dismiss();
            this.njF = null;
        }
        if (this.nnG != null) {
            ((VideoPlayer) this.nnG).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nhy = this.nnq.findViewById(a.f.topview);
        this.njn = (LinearLayout) this.nnq.findViewById(a.f.topRight);
        this.njk = this.nhy.findViewById(a.f.rl_download);
        this.njl = this.nnq.findViewById(a.f.topKeyboardView);
        this.nnq.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nhy.getVisibility() == 0;
        if (this.njz > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nhy.getLayoutParams();
            layoutParams.topMargin = this.njz;
            this.nhy.setLayoutParams(layoutParams);
        }
        this.nnq.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.nnq.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                str = this.nnF.dJB().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.nnq.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.njC = (ImageView) this.nnq.findViewById(a.f.subscribe_icon);
        this.njC.setOnClickListener(this);
        this.njE = (ImageView) this.nnq.findViewById(a.f.report_icon);
        this.njE.setOnClickListener(this);
        q();
    }

    private void dJQ() {
        boolean z;
        this.njj = this.nnq.findViewById(a.f.bottomview);
        this.njp = (ImageButton) this.njj.findViewById(a.f.playbutton);
        this.njp.setOnTouchListener(this);
        this.nnx = (ImageButton) this.nnq.findViewById(a.f.btn_barrage);
        this.nny = (ImageButton) this.nnq.findViewById(a.f.btn_audio);
        this.njx = (ImageView) this.nnq.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.njj.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.njj.findViewById(a.f.btn_refresh).setVisibility(0);
            this.nnx.setVisibility(0);
            this.njx.setVisibility(8);
            if (this.nnF != null && this.nnF.f != null) {
                for (int i = 0; i < this.nnF.f.size(); i++) {
                    if ("2".equals(this.nnF.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.nny.setVisibility(0);
            } else {
                this.nny.setVisibility(8);
            }
            this.njj.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.nnx.setOnClickListener(this);
            if (h.dIP().e) {
                this.nnx.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nnx.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.nnF.d) {
                this.nny.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.nny.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.nny.setOnClickListener(this);
            this.nhD = (ImageView) this.njj.findViewById(a.f.btn_hotword);
            this.njo = (ImageView) this.nnq.findViewById(a.f.iv_task_badge);
            this.nhD.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nnG, a.C0814a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dIP().c) {
                        b.this.nhD.clearAnimation();
                        b.this.nhD.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nhD.clearAnimation();
            if (h.dIP().c) {
                this.nhD.startAnimation(animationSet);
                this.njo.setVisibility(0);
            }
        } else {
            this.njj.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.njj.findViewById(a.f.btn_refresh).setVisibility(8);
            this.nnx.setVisibility(8);
            this.nny.setVisibility(8);
            this.njx.setVisibility(0);
            this.njx.setOnClickListener(this);
            if (h.dIP().b) {
                this.njx.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.njx.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.njj.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nnG != null) {
            ((VideoPlayer) this.nnG).e(true);
        }
        if (this.nnH != null) {
            this.nnH.ch(null);
            this.nnH = null;
        }
        this.c = null;
        this.nhc = null;
        this.njv = null;
        if (this.nju != null) {
            this.nju.addTextChangedListener(null);
            this.nju.setOnEditorActionListener(null);
            this.nju = null;
        }
        this.nhy = null;
        this.nnx = null;
        this.nny = null;
        this.njj = null;
        this.njm = null;
        if (this.njJ != null) {
            this.njJ.a();
            this.njJ = null;
            this.njK = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dKj() {
        return this.njJ;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.nnq == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.nox == null || !this.nox.a(i, keyEvent)) {
                    if ((this.njI == null || !this.njI.onKeyDown(i, keyEvent)) && !az() && !dJN()) {
                        if (this.njl != null && this.njl.getVisibility() == 0) {
                            ax(false, true);
                            return true;
                        } else if (this.njw != null && this.njw.isShown()) {
                            dKq();
                            return true;
                        } else if (this.njy && this.nnH != null) {
                            if (this.njv != null) {
                                this.njv.setVisibility(0);
                            }
                            this.nnH.removeMessages(2);
                            this.nnH.B(2, 3000L);
                            return true;
                        } else {
                            dJP();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.nnq.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.nnq.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nnH != null) {
                    this.nnH.removeMessages(3);
                    this.nnH.B(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dKp() {
        if (this.njy) {
            this.njv.setVisibility(0);
            this.nnH.removeMessages(2);
            this.nnH.B(2, 3000L);
        }
        return this.njy;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.njy) {
            if (view.getId() == a.f.btn_lockscreen) {
                dJR();
                return;
            }
            this.njv.setVisibility(0);
            this.nnH.removeMessages(2);
            this.nnH.B(2, 3000L);
            tv.chushou.zues.utils.g.c(this.nnG, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.ax(getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(getActivity())) {
                    n(view, tv.chushou.zues.utils.systemBar.b.gC(getActivity()), 0);
                    return;
                } else {
                    n(view, 0, 0);
                    return;
                }
            }
            n(view, 0, this.nhy.getHeight() + this.nhy.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.nju.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.nnG, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.nju.setText((CharSequence) null);
                ax(false, true);
            } else if (a(this.nju.getText().toString(), false)) {
                ax(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dJR();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                o(view, tv.chushou.zues.utils.systemBar.b.gC(getActivity()), 0);
            } else {
                o(view, 0, tv.chushou.zues.utils.a.dip2px(this.nnG, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            o(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dJP();
            com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dKz() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.nok == null;
                b(false, false);
                if (z && this.bV > 0 && this.nok != null && tv.chushou.zues.utils.systemBar.b.ax(getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nok.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.nok.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.nok == null;
                if (this.nnG.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.nok != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nok.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.nok.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnF.dJB().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            ax(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ay(false, false);
            this.nnH.B(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dIP().c) {
                h.dIP().b(false);
                this.nhD.clearAnimation();
                this.njo.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                l(view, this.njj.findViewById(a.f.ll_keyboard).getLeft(), this.njj.getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
            } else {
                l(view, this.njj.findViewById(a.f.ll_keyboard).getLeft(), this.njj.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                tv.chushou.zues.utils.g.c(this.nnG, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.nnG, dKz(), false);
        } else if (id == a.f.btn_screenChange) {
            dJP();
        } else if (id == a.f.rl_paoicon) {
            dJL();
        } else if (id == a.f.subscribe_icon) {
            dJU();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dJX();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dJV();
            }
        } else if (id == a.f.btn_audio && !this.nnF.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.LI(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.njA <= 3000) {
            tv.chushou.zues.utils.g.LI(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dIP().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
            if (com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a(((VideoPlayer) this.nnG).dJb().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.njA = System.currentTimeMillis();
                a(this.nnF.dJB().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nnF.h);
                if (!z) {
                    this.nju.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.nnx != null) {
                if (z) {
                    this.nnx.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nnx.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.njx != null) {
            if (z) {
                this.njx.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.njx.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dJW() {
        if (this.nnq == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nnq.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.nos != null) {
            this.nos.setVisibility(z ? 0 : 8);
            if (!z) {
                this.nos.dVQ();
            }
        }
        tv.chushou.zues.utils.g.y(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dJR() {
        if (this.nnF.d()) {
            if (this.njy) {
                this.njv.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nnG, this.nnG.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.njv.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nnG, this.nnG.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.njy = !this.njy;
            if (this.nju != null) {
                this.nju.setEnabled(this.njy ? false : true);
            }
        }
    }

    public void ax(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dE(this.nju);
            this.nju.setText("");
            this.njm.setVisibility(8);
            this.njv.setVisibility(8);
            this.nhy.setVisibility(8);
            this.njj.setVisibility(8);
            this.njl.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
        if (this.njl.getVisibility() != 8 && z2) {
            this.njl.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_top_anim));
        }
        this.njm.setVisibility(8);
        this.njv.setVisibility(8);
        this.nhy.setVisibility(8);
        this.njj.setVisibility(8);
        this.njl.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ay(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.njn != null) {
            this.njn.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ay(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (aa()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.njG != null) {
                this.njG.a(this.e);
            }
            return this.e;
        }
        if (this.nnH != null) {
            this.nnH.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nnG).e(true);
            if (!z3) {
                if (this.njj.getVisibility() != 0 && z2) {
                    this.njj.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_bottom_anim));
                }
                this.njj.setVisibility(0);
                this.njm.setVisibility(0);
                this.njv.setVisibility(0);
                this.njk.setVisibility(o() ? 0 : 8);
            }
            if (this.nhy.getVisibility() != 0 && z2) {
                this.nhy.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_top_anim));
            }
            u(!z3);
            this.nhy.setVisibility(0);
            if (this.nnH != null) {
                this.nnH.B(1, 5000L);
            }
            y(false);
            if (this.njG != null) {
                this.njG.a(true);
            }
        } else {
            ((VideoPlayer) this.nnG).e(false);
            if (this.nnX != null) {
                this.nnX.dismiss();
            }
            if (this.nnY != null) {
                this.nnY.dismiss();
            }
            if (this.nof != null) {
                this.nof.dismiss();
            }
            if (this.njj != null) {
                if (this.njj.getVisibility() != 8 && z2) {
                    this.njj.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_bottom_anim));
                }
                this.njj.setVisibility(8);
            }
            if (this.njm != null) {
                this.njm.setVisibility(8);
                if (this.nhy.getVisibility() != 8 && z2) {
                    this.nhy.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_top_anim));
                }
                this.nhy.setVisibility(8);
                this.njv.setVisibility(8);
                y(true);
                a(false);
                if (this.njG != null) {
                    this.njG.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dJS() {
        Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
        if (this.ap == 1) {
            this.ar = Math.min(gw.x, gw.y);
            this.aq = Math.max(gw.x, gw.y);
        } else {
            this.ar = Math.max(gw.x, gw.y);
            this.aq = Math.min(gw.x, gw.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.njd == null) {
            this.njd = new Rect(0, 0, i / 5, i2);
        } else {
            this.njd.set(0, 0, i / 5, i2);
        }
        if (this.nje == null) {
            this.nje = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.nje.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.njd == null) {
            return false;
        }
        return this.njd.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.nnq.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nnq.findViewById(a.f.brightness_view);
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
        if (this.nje == null) {
            return false;
        }
        return this.nje.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.nnq.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nnq.findViewById(a.f.volumn_view);
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
                if (this.njy) {
                    this.njv.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.njy) {
                    this.nnH.removeMessages(2);
                    this.nnH.B(2, 3000L);
                    return true;
                } else if (this.nnH != null) {
                    this.nnH.B(3, 1000L);
                    this.nnH.B(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.njy) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Kj(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.nnI.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Kk(int i) {
        int streamMaxVolume = (i * 10) / this.nnI.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.nnq.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.nnq.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.nnG != null && (this.nnG instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nnG).a(1, null, this.H, false, false, true);
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
            b.this.nnI.setStreamVolume(3, b.this.Kj(i), 0);
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
            b.this.njf = i / 10.0f;
            ((VideoPlayer) b.this.nnG).l = b.this.njf;
            ((VideoPlayer) b.this.nnG).k = b.this.njf * 255.0f;
            b.this.njh.screenBrightness = b.this.njf;
            b.this.njg.setAttributes(b.this.njh);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.nnq.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.nnq.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.nhf.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.nnq.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.nnq.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nkb.getCurrentPos();
                            int duration = this.nkb.getDuration();
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
                                this.nhf.setProgress(i3 / (duration / 1000));
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
        if (!this.nji) {
            if (this.njl.getVisibility() == 8 && (this.njw == null || !this.njw.isShown())) {
                boolean z = this.nnA != null && this.nnA.getVisibility() == 0;
                if (this.e) {
                    ay(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                ax(false, true);
                dKq();
            }
        }
        return false;
    }

    public boolean dJN() {
        if (this.nji) {
            if (this.nok != null) {
                this.nok.e();
            }
            y(false);
            if (this.njj != null) {
                this.njj.setVisibility(0);
            }
            if (this.nhy != null) {
                this.nhy.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dKc() {
        super.dKc();
        if (this.nnG instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.nnF != null) {
            this.nnF.f = null;
            if (this.nnF.dJB() != null) {
                this.nnF.dJB().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.nkb != null) {
                this.nkb.seekTo(0L);
                e(true);
            }
            dJP();
            return;
        }
        dJP();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.njy) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                tv.chushou.zues.utils.g.c(this.nnG, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nkb.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.njM != null) {
                            this.njM.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.nnF.a(false);
                            ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
                        } else if (this.nkb.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nkb.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nkb.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nkb.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nkb.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                tv.chushou.zues.utils.g.c(this.nnG, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.nnF.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
                    this.ai = false;
                    m(true);
                    a(false, !this.ak);
                } else if (this.nkb.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
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
            if (this.nnF != null && this.nnF.dJE() != null) {
                str = this.nnF.dJE().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dIJ().nex != null && com.kascend.chushou.a.a.dIJ().nex.contains(str) && this.nnF != null && !this.njV) {
            this.njV = true;
            com.kascend.chushou.a.a.dIJ().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.njV = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.njM != null) {
            this.njM.a(listItem, this.ap == 1, a.C0814a.zues_sweetalert_modal_in, a.C0814a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.njV = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.njp != null) {
                this.njp.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nnA != null) {
                this.nnA.setVisibility(8);
                return;
            }
            return;
        }
        if (this.njp != null) {
            this.njp.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nnA != null) {
                    this.nnA.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dJT() {
        this.N = new SurfaceView(this.nnG);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.nnq).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.nos != null) {
            this.nos.dVQ();
            this.nos.setVisibility(8);
            this.nos.unInit();
            ((RelativeLayout) this.nnq).removeView(this.nos);
            this.nos = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.nnq).removeView(this.N);
            this.N = null;
        }
        dJT();
        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
    }

    private void l(View view, int i, int i2) {
        if (this.nnH != null) {
            y(true);
            this.nnH.removeMessages(1);
            this.njj.setVisibility(0);
            this.njm.setVisibility(8);
            this.nhy.setVisibility(8);
            this.njv.setVisibility(8);
        }
        if (this.nof == null) {
            al();
            this.nof.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nhD.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.nof.isShowing()) {
            this.nof.showAtLocation(view, 83, i, i2);
            this.nhD.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nnF.dJB().mRoominfo.mRoomID);
            return;
        }
        this.nof.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.njI != null && this.njI.b()) {
                this.njI.getGlobalVisibleRect(this.njX);
                if (!this.njX.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.njI.a();
                    return true;
                }
            }
            if (this.nji && f(this.nok.b, motionEvent)) {
                dJN();
                return true;
            }
            if (!dKp()) {
                if (System.currentTimeMillis() - this.njW < 300 && this.njM != null && this.njM.isShown()) {
                    this.njM.a();
                    if (this.nkb.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.nnF.a(false);
                            ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
                        } else if (this.nkb.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nnG).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nkb.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nkb.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                        }
                    }
                    return true;
                }
                this.njW = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dKq() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
        if (this.njw != null) {
            if (this.njw.isShown()) {
                this.njw.startAnimation(AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_top_anim));
            }
            this.njw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nnG).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nnG).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.nny != null) {
                this.nny.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gD(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njm.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.njm.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nhy.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nhy.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.njl.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.njl.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.njj.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.njj.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
            this.njC.setVisibility(0);
            if (this.nnF.dJB().mRoominfo.mIsSubscribed) {
                this.njC.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.njC.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.njC.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dJU() {
        RoomInfo roomInfo;
        if (this.nnF != null && this.nnF.dJB() != null && (roomInfo = this.nnF.dJB().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nnG, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dXi();
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
        if (this.nnF != null && this.nnF.dJB() != null && (roomInfo = this.nnF.dJB().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.F(b.this.nnG, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.nnG, a.i.subscribe_success);
                            }
                            if (b.this.nnF != null && b.this.nnF.dJB() != null && (roomInfo2 = b.this.nnF.dJB().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.nnG, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nnG, str2);
                    }
                }
            };
            if (this.nnF != null && this.nnF.h != null) {
                try {
                    str = new JSONObject(this.nnF.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dIL().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dIL().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.njD == null) {
                this.njD = new ProgressDialog(this.nnG);
                this.njD.setProgressStyle(0);
                this.njD.requestWindowFeature(1);
                this.njD.setMessage(this.nnG.getText(a.i.update_userinfo_ing));
                this.njD.setCancelable(true);
            }
            if (!this.njD.isShowing()) {
                this.njD.show();
            }
        } else if (this.njD != null && this.njD.isShowing()) {
            this.njD.dismiss();
        }
    }

    private void dJV() {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
            if (this.njF == null) {
                this.njF = new f(getActivity());
            }
            this.njF.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.njF = null;
                }
            });
            RoomInfo roomInfo = this.nnF.dJB().mRoominfo;
            this.njF.a();
            this.njF.a(roomInfo);
            if (!this.njF.isShowing()) {
                this.njF.show();
            }
        }
    }

    private void dJX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.njU != null && this.nnI != null && this.nnG != null && (this.nnG instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.njU;
            VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
            verticalSeekBarVolumn.setProgressOnly(Kk(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.nhg != null) {
            this.nhg.dWK();
        }
        if (this.nnq != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.njG == null) {
                this.njG = new com.kascend.chushou.player.ui.giftpopup.a(this.nnq, i);
            } else if (this.njG.a() != i) {
                this.njG.b();
                this.njG = null;
                this.njG = new com.kascend.chushou.player.ui.giftpopup.a(this.nnq, i);
            }
            List<ListItem> j = this.nnF != null ? this.nnF.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
            if (videoPlayer != null) {
                this.njG.a(j, videoPlayer.dJh(), videoPlayer.dJi(), videoPlayer.dJj(), videoPlayer.dJk());
                this.njG.a(this.e);
                if (this.nnF != null && this.nnF.ngN != null) {
                    this.njG.a(this.nnF.ngN, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.nnF != null) {
                                b.this.nnF.ngN = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.njG != null && this.nnF != null) {
                    this.njG.b(this.nnF.ngP);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void a(int i) {
        if (this.njG != null && this.nnG != null) {
            this.njG.a(((VideoPlayer) this.nnG).dJh());
            this.njG.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void D() {
        if (this.nnG instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dJh = ((VideoPlayer) this.nnG).dJh();
            if (this.nox == null) {
                this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nox.setVisibility(0);
            this.nox.a(i, dJh);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.njG != null) {
            this.njG.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.njs != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.njs.setVisibility(0);
                    this.njs.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.njs.setVisibility(8);
                }
            }
            if (this.njq != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.njr.setVisibility(0);
                    this.njq.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.njr.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.njG != null) {
            this.njG.a(((VideoPlayer) this.nnG).dJi());
            this.njG.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.njG != null) {
            this.njG.a(((VideoPlayer) this.nnG).dJi());
            this.njG.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(long j) {
        if (this.njG != null) {
            this.njG.a(((VideoPlayer) this.nnG).dJj());
            this.njG.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0827a
    public void c(int i) {
        if (this.njG != null) {
            this.njG.a(((VideoPlayer) this.nnG).dJk());
            this.njG.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wZ(false);
        super.F();
    }

    private void c(View view) {
        this.njN = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nih = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nih.setText(new tv.chushou.zues.widget.a.c().J(this.nnG, a.e.videoplayer_4g_video).append("  ").append(this.nnG.getString(a.i.videoplayer_4g_video)));
        this.njO = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.njO.setText(new tv.chushou.zues.widget.a.c().J(this.nnG, a.e.videoplayer_4g_audio).append("  ").append(this.nnG.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dJP();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nnG, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.njN.setVisibility(8);
                    ((VideoPlayer) b.this.nnG).c(b.this.nij);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.njN.setVisibility(8);
                    ((VideoPlayer) b.this.nnG).d(b.this.nij);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
        findViewById.setLayoutParams(layoutParams);
        this.nih.setOnClickListener(onClickListener);
        this.njO.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nnF != null && !tv.chushou.zues.utils.h.isEmpty(this.nnF.f)) {
            f(this.nnF.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nij = z;
            this.p = false;
            if (this.nnF != null && this.nnF.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nnF.f.size()) {
                        break;
                    } else if (!"2".equals(this.nnF.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.njN != null) {
                this.njN.setVisibility(0);
                this.nih.setVisibility(0);
                this.njO.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.njN != null) {
            this.njN.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.njG != null && this.nnF != null) {
            this.njG.b(this.nnF.ngP);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.nnq != null && (findViewById = this.nnq.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.njq != null) {
            this.njq.performClick();
        }
    }
}
