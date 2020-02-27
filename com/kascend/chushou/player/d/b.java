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
    private TextView mSo;
    private boolean mSr;
    private LinearLayout mTB;
    private FrameLayout mTF;
    private FrescoThumbnailView mTG;
    private ImageView mTJ;
    private ImageView mTL;
    public int mTP;
    RelativeLayout mTQ;
    private ImageView mTR;
    private ImageView mTT;
    private f mTU;
    private com.kascend.chushou.player.ui.giftpopup.a mTW;
    private PopH5Menu mTY;
    private com.kascend.chushou.player.b.a mTZ;
    private GiftAnimationLayout mUa;
    private ImageView mUb;
    private FoodView mUc;
    private RelativeLayout mUd;
    private TextView mUe;
    private VerticalSeekBarVolumn mUl;
    private long mUn;
    private Rect mTp = null;
    private Rect mTq = null;
    private float mTr = 0.0f;
    private Window mTs = null;
    private WindowManager.LayoutParams mTt = null;
    private boolean mTu = false;
    private View mTv = null;
    private View mRG = null;
    private View mTw = null;
    private View mTz = null;
    private View mTA = null;
    private ImageView mRL = null;
    private ImageView mTC = null;
    private ImageButton mTD = null;
    private FrescoThumbnailView mTE = null;
    private LinearLayout mTH = null;
    private EditText mTI = null;
    private View mTK = null;
    private boolean mTM = false;
    private int bU = 0;
    private int mTN = 0;
    private long mTO = 0;
    private ProgressDialog mTS = null;
    private boolean mTV = true;
    private int mTX = -1;
    private boolean mUf = false;
    private TextView mUg = null;
    private TextView mUh = null;
    private int mUi = 0;
    private boolean mUj = false;
    private boolean mUm = false;
    private final Rect mUo = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTP = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mRq = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXO = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mTP;
        if (this.mYe != null && !((Activity) this.mYe).isFinishing()) {
            dDw();
        }
        return this.mXO;
    }

    public void dCK() {
        ax(false, false);
        super.p(true);
        com.kascend.chushou.toolkit.a.c.a(this.mYe, "能量_num", "横屏", new Object[0]);
    }

    public boolean dCY() {
        if (this.mYN == null || !this.mYN.isShown()) {
            return false;
        }
        this.mYN.d();
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
        if (z3 || this.mXO.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dBS().e;
        } else {
            z = h.dBS().b;
        }
        q(z);
        if (this.mYJ != null) {
            this.mYJ.b();
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
        if (this.mTW != null) {
            this.mTW.b();
            this.mTW = null;
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tv.chushou.zues.a.a.cr(this);
        d();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1 || configuration.orientation == 0 || configuration.orientation == 6) {
            dCR();
            y();
            if (this.mRq != null) {
                this.mRq.onConfigurationChanged(configuration);
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
        if (this.mTY != null && this.mTX != i3) {
            this.mTY.a();
            this.mTY = null;
        }
        if (this.mTY == null) {
            this.mTY = (PopH5Menu) ((ViewStub) this.mXO.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
            Point hd = tv.chushou.zues.utils.a.hd(getActivity());
            if (this.ap == 0) {
                int i4 = hd.y;
                i = hd.y;
                i2 = i4;
            } else {
                int i5 = hd.x;
                int i6 = hd.y - ((hd.x * 9) / 16);
                i = i5;
                i2 = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTY.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mTY.setLayoutParams(layoutParams);
            this.mTX = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mTY.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dDM()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mYe instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dCj = ((VideoPlayer) this.mYe).dCj();
                    if (this.mYU == null) {
                        this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYU.setVisibility(0);
                    this.mYU.a(i, dCj);
                }
            } else if (bVar.a == 3) {
                if (this.mYe instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dCk = ((VideoPlayer) this.mYe).dCk();
                    if (this.mYU == null) {
                        this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYU.setVisibility(0);
                    this.mYU.a(i, dCk);
                }
            } else if (bVar.a == 9) {
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dCE;
        if (!dDM() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mYd != null && mVar.b.equals(this.mYd.a) && (dCE = this.mYd.dCE()) != null) {
            dCE.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dDw() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.bU = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
        this.mTN = tv.chushou.zues.utils.systemBar.b.hi(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.mTN);
        this.mUs = ((VideoPlayer) this.mYe).dCa();
        this.mYd = ((VideoPlayer) this.mYe).dCd();
        c(this.mXO);
        if (this.aw.equals("1")) {
            this.mRo = ((VideoPlayer) this.mYe).dCe();
            this.mRo.a(this);
            if (this.mTZ != null) {
                this.mTZ.a();
                this.mTZ = null;
                this.mUa = null;
            }
            this.mUa = (GiftAnimationLayout) this.mXO.findViewById(a.f.ll_gift_animation);
            this.mUa.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mYd != null) {
                this.mTZ = new com.kascend.chushou.player.b.a(this.mYe.getApplicationContext(), this.mUa);
                this.mTZ.a(this.mYd);
            }
            this.B = (TextView) this.mXO.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dCT();
        if (this.mRo != null) {
            this.mRo.d();
        }
        dDs();
        this.mTJ = (ImageView) this.mXO.findViewById(a.f.btn_lockscreen);
        this.mTJ.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mXO.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mXY = (PlayerErrorView) this.mXO.findViewById(a.f.view_net_error_msg);
        this.mXY.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dCN();
        cXK();
        this.mYN = (PaoGuideView) this.mXO.findViewById(a.f.rlPaoGuideView);
        this.mUb = (ImageView) this.mXO.findViewById(a.f.iv_send_danmu);
        this.mTA = this.mXO.findViewById(a.f.rt_layout);
        this.mTE = (FrescoThumbnailView) this.mTA.findViewById(a.f.btn_gift);
        this.mTF = (FrameLayout) this.mTA.findViewById(a.f.flfl_bottom_gift);
        this.mTG = (FrescoThumbnailView) this.mTA.findViewById(a.f.btn_recharge);
        this.mTG.setOnClickListener(this);
        a(this.mYd == null ? null : this.mYd.mQX);
        this.mYT = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mTu = false;
                b.this.wl(false);
                if (b.this.mYf != null) {
                    b.this.mYf.removeMessages(1);
                    b.this.mYf.K(1, 5000L);
                }
                b.this.mTJ.setVisibility(0);
                b.this.mTA.setVisibility(0);
                b.this.mRG.setVisibility(0);
                b.this.mTv.setVisibility(0);
                if (b.this.mTW != null) {
                    b.this.mTW.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mYe, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mTu = true;
                b.this.wl(true);
                b.this.mTJ.setVisibility(8);
                b.this.mTA.setVisibility(8);
                if (b.this.mTW != null) {
                    b.this.mTW.a(false);
                }
                b.this.mRG.setVisibility(8);
                b.this.mTv.setVisibility(8);
                if (b.this.mYf != null) {
                    b.this.mYf.removeMessages(1);
                }
                if (b.this.mYJ != null) {
                    b.this.mYJ.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mYe, 14.0f) + b.this.mYJ.getMeasuredHeight(), 12);
                }
            }
        };
        this.mTH = (LinearLayout) this.mXO.findViewById(a.f.rl_seekbar);
        this.mTQ = (RelativeLayout) this.mXO.findViewById(a.f.rl_paoicon);
        this.mTQ.setOnClickListener(this);
        this.mYK = (RoundProgressBar) this.mXO.findViewById(a.f.roundProgressBar);
        this.mYM = (FrescoThumbnailView) this.mXO.findViewById(a.f.iv_paoicon);
        this.mYL = (TextView) this.mXO.findViewById(a.f.tv_paonum);
        this.aSx = 0;
        this.mYO = 0L;
        com.kascend.chushou.player.ui.a.a dCm = ((VideoPlayer) this.mYe).dCm();
        a(dCm.dDT());
        BangInfo dDU = dCm.dDU();
        if (dDU != null) {
            a(dDU, dCm.d());
        }
        if (this.aw.equals("3")) {
            this.mTH.setVisibility(0);
            this.mTF.setVisibility(8);
            this.mUb.setVisibility(0);
            this.mUb.setOnClickListener(this);
        } else {
            this.mUb.setVisibility(8);
            this.mTH.setVisibility(8);
            this.mTF.setVisibility(0);
            this.mTE.setOnClickListener(this);
        }
        dCO();
        if (tv.chushou.zues.utils.systemBar.b.hj(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTA.getLayoutParams();
            layoutParams.rightMargin += this.mTN;
            this.mTA.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRG.getLayoutParams();
            layoutParams2.rightMargin += this.mTN;
            this.mRG.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTz.getLayoutParams();
            layoutParams3.rightMargin += this.mTN;
            this.mTz.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTv.getLayoutParams();
            layoutParams4.rightMargin += this.mTN;
            this.mTv.setLayoutParams(layoutParams4);
        }
        dDy();
        dCL();
        dCR();
        this.h = (TextView) this.mXO.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXO.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mYd.dCC() != null) {
                this.mTT.setVisibility(0);
            } else {
                this.mTT.setVisibility(8);
            }
        }
        dDx();
        n();
        k(100);
        this.mUc = (FoodView) this.mXO.findViewById(a.f.kav_room_ad);
        this.mYf = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ax(false, true);
                            break;
                        case 2:
                            b.this.mYf.removeMessages(2);
                            if (b.this.mTJ != null) {
                                b.this.mTJ.setVisibility(8);
                                break;
                            }
                            break;
                        case 3:
                            b.this.u(true);
                            break;
                        case 4:
                            b.this.v(true);
                            break;
                        case 5:
                            TextView textView = (TextView) b.this.mXO.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mYe.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mYf.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mYf.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mYf.K(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aw(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mYe).q) {
                                b.this.a(b.this.mYf);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mYe).q) {
                                b.this.b(b.this.mYf);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mYe).g = true;
                            b.this.mUs.seekTo((int) b.this.kWc);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mYd.d()) {
                                b.this.mUs.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mUs.getPlayState() == 4) {
                                int currentPos = b.this.mUs.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mYf != null) {
                                    b.this.mYf.K(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dDP();
                            break;
                        case 18:
                            b.this.cXJ();
                            break;
                        case 19:
                            b.this.mYc.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mYd != null) {
            a(this.mYd.dCD());
        }
        if (this.mUs != null && (this.mUs.getPlayState() == 3 || this.mUs.getPlayState() == 4)) {
            wn(false);
            if (this.mYd.d()) {
                this.ak = false;
                wo(true);
                if (this.mUs.getDuration() > 60000) {
                    if (this.mUs.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mUs.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mUs.getDuration();
                }
            }
            this.e = false;
            ax(true, false);
            this.mYf.Of(8);
            if (h() && this.mUs.getPlayState() == 4 && this.mYf != null) {
                this.mYf.removeMessages(15);
                this.mYf.Of(15);
            }
        } else {
            wn(true);
            if (this.e) {
                ax(false, false);
            } else {
                wl(true);
            }
        }
        if (g.a() && g.c()) {
            int[] dBR = g.dBR();
            int i = dBR.length == 2 ? dBR[1] : 0;
            if (i > 0) {
                View findViewById = this.mXO.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mXO.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mYe, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        dDO();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mYe, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mYe != null && (this.mYe instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYe).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mTG.xo(a.e.ic_recharge_old);
            this.mTE.xo(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mUf && !this.k) {
            try {
                if (this.mUs != null) {
                    i = this.mUs.getCurrentPos();
                    i2 = this.mUs.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mRp.setProgress(i / (i2 / 1000));
                    this.mUg.setText(tv.chushou.zues.utils.b.s(this.mUs.getDuration(), false));
                    this.mUh.setText(tv.chushou.zues.utils.b.s(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dDx() {
        this.mRp = (ProgressBar) this.mXO.findViewById(a.f.progressBarl);
        if (this.mRp != null) {
            if (this.mRp instanceof SeekBar) {
                ((SeekBar) this.mRp).setOnSeekBarChangeListener(new C0697b());
            }
            this.mRp.setMax(1000);
        }
        this.mUg = (TextView) this.mXO.findViewById(a.f.tv_time_duration);
        this.mUh = (TextView) this.mXO.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mXO.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXO.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dCm;
        BangInfo dDU;
        if (config != null) {
            this.mYQ = config;
            if (!config.display) {
                this.mTQ.setVisibility(8);
            } else if ((this.mYe instanceof VideoPlayer) && (dDU = (dCm = ((VideoPlayer) this.mYe).dCm()).dDU()) != null) {
                a(dDU, dCm.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mYQ == null || this.mYQ.display) && this.mTQ != null) {
            this.mTQ.setVisibility(0);
            this.mYL.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mYe instanceof VideoPlayer) {
            if ((this.mYQ == null || this.mYQ.display) && this.mTQ != null) {
                if (j > 0) {
                    this.mTQ.setVisibility(0);
                    boolean z = this.mYP;
                    this.mYP = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mYe.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mYL.setText(cVar);
                    return;
                }
                this.mYP = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0697b implements SeekBar.OnSeekBarChangeListener {
        C0697b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.mUi != i || b.this.mUj != z) {
                    b.this.mUi = i;
                    b.this.mUj = z;
                    if (z) {
                        if (b.this.mUf) {
                            b.this.kWc = (b.this.mUs.getDuration() / 1000) * i;
                        }
                        b.this.mUh.setText(tv.chushou.zues.utils.b.s((int) b.this.kWc, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.s((int) b.this.kWc, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.s(((int) b.this.kWc) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mUf = true;
            b.this.m = b.this.mUs.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mYf != null) {
                if (b.this.mUf) {
                    b.this.mUf = false;
                }
                b.this.mYf.removeMessages(14);
                b.this.mYf.Of(14);
            }
        }
    }

    private void k(int i) {
        this.mRp.setSecondaryProgress((i * 1000) / 100);
    }

    private void dDs() {
        this.mUl = (VerticalSeekBarVolumn) this.mXO.findViewById(a.f.volumn_seekbar);
        this.mUl.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mYg.getStreamVolume(3);
        this.mUl.setProgress(MQ(streamVolume));
        wk(MQ(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mXO.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mRm = new d.a();
            this.c = new GestureDetector(this.mYe, this.mRm);
        }
    }

    private void dDy() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mTs == null) {
                this.mTs = ((Activity) this.mYe).getWindow();
            }
            this.mTt = this.mTs.getAttributes();
            this.mTr = ((VideoPlayer) this.mYe).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mXO.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mTr));
        }
    }

    private void dCL() {
        this.mXO.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mXO.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mYe.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mXO.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mTI == null) {
            this.mTI = (EditText) this.mXO.findViewById(a.f.et_input);
            this.mTI.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mXO.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCM() {
        if (this.mTU != null) {
            this.mTU.dismiss();
            this.mTU = null;
        }
        if (this.mYe != null) {
            ((VideoPlayer) this.mYe).a(1, null, this.H, false);
        }
    }

    private void dCN() {
        this.mRG = this.mXO.findViewById(a.f.topview);
        this.mTB = (LinearLayout) this.mXO.findViewById(a.f.topRight);
        this.mTw = this.mRG.findViewById(a.f.rl_download);
        this.mTz = this.mXO.findViewById(a.f.topKeyboardView);
        this.mXO.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mRG.getVisibility() == 0;
        if (this.bU > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRG.getLayoutParams();
            layoutParams.topMargin = this.bU;
            this.mRG.setLayoutParams(layoutParams);
        }
        this.mXO.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mXO.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                str = this.mYd.dCC().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mXO.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mTR = (ImageView) this.mXO.findViewById(a.f.subscribe_icon);
        this.mTR.setOnClickListener(this);
        this.mTT = (ImageView) this.mXO.findViewById(a.f.report_icon);
        this.mTT.setOnClickListener(this);
        q();
    }

    private void dCO() {
        boolean z;
        this.mTv = this.mXO.findViewById(a.f.bottomview);
        this.mTD = (ImageButton) this.mTv.findViewById(a.f.playbutton);
        this.mTD.setOnTouchListener(this);
        this.mXV = (ImageButton) this.mXO.findViewById(a.f.btn_barrage);
        this.mXW = (ImageButton) this.mXO.findViewById(a.f.btn_audio);
        this.mTL = (ImageView) this.mXO.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mTv.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mTv.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mXV.setVisibility(0);
            this.mTL.setVisibility(8);
            if (this.mYd != null && this.mYd.f != null) {
                for (int i = 0; i < this.mYd.f.size(); i++) {
                    if ("2".equals(this.mYd.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mXW.setVisibility(0);
            } else {
                this.mXW.setVisibility(8);
            }
            this.mTv.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mXV.setOnClickListener(this);
            if (h.dBS().e) {
                this.mXV.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXV.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mYd.d) {
                this.mXW.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mXW.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mXW.setOnClickListener(this);
            this.mRL = (ImageView) this.mTv.findViewById(a.f.btn_hotword);
            this.mTC = (ImageView) this.mXO.findViewById(a.f.iv_task_badge);
            this.mRL.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mYe, a.C0690a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dBS().c) {
                        b.this.mRL.clearAnimation();
                        b.this.mRL.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRL.clearAnimation();
            if (h.dBS().c) {
                this.mRL.startAnimation(animationSet);
                this.mTC.setVisibility(0);
            }
        } else {
            this.mTv.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mTv.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mXV.setVisibility(8);
            this.mXW.setVisibility(8);
            this.mTL.setVisibility(0);
            this.mTL.setOnClickListener(this);
            if (h.dBS().b) {
                this.mTL.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTL.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mTv.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mYe != null) {
            ((VideoPlayer) this.mYe).d(true);
        }
        if (this.mYf != null) {
            this.mYf.cq(null);
            this.mYf = null;
        }
        this.c = null;
        this.mRm = null;
        this.mTJ = null;
        if (this.mTI != null) {
            this.mTI.addTextChangedListener(null);
            this.mTI.setOnEditorActionListener(null);
            this.mTI = null;
        }
        this.mRG = null;
        this.mXV = null;
        this.mXW = null;
        this.mTv = null;
        this.mTA = null;
        if (this.mTZ != null) {
            this.mTZ.a();
            this.mTZ = null;
            this.mUa = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDm() {
        return this.mTZ;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mXO == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mYU == null || !this.mYU.a(i, keyEvent)) {
                    if ((this.mTY == null || !this.mTY.onKeyDown(i, keyEvent)) && !dCY() && !dCZ()) {
                        if (this.mTz != null && this.mTz.getVisibility() == 0) {
                            aw(false, true);
                            return true;
                        } else if (this.mTK != null && this.mTK.isShown()) {
                            dDA();
                            return true;
                        } else if (this.mTM && this.mYf != null) {
                            if (this.mTJ != null) {
                                this.mTJ.setVisibility(0);
                            }
                            this.mYf.removeMessages(2);
                            this.mYf.K(2, 3000L);
                            return true;
                        } else {
                            dCM();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                u(false);
                int progress = ((VerticalSeekBarVolumn) this.mXO.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mXO.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mYf != null) {
                    this.mYf.removeMessages(3);
                    this.mYf.K(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dDz() {
        if (this.mTM) {
            this.mTJ.setVisibility(0);
            this.mYf.removeMessages(2);
            this.mYf.K(2, 3000L);
        }
        return this.mTM;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.mTM) {
            if (view.getId() == a.f.btn_lockscreen) {
                dCQ();
                return;
            }
            this.mTJ.setVisibility(0);
            this.mYf.removeMessages(2);
            this.mYf.K(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mYe, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aD(getActivity()) && tv.chushou.zues.utils.systemBar.b.aE(getActivity())) {
                    l(view, tv.chushou.zues.utils.systemBar.b.hi(getActivity()), 0);
                    return;
                } else {
                    l(view, 0, 0);
                    return;
                }
            }
            l(view, 0, this.mRG.getHeight() + this.mRG.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mTI.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.M(this.mYe, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mTI.setText((CharSequence) null);
                aw(false, true);
            } else if (a(this.mTI.getText().toString(), false)) {
                aw(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dCQ();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                m(view, tv.chushou.zues.utils.systemBar.b.hi(getActivity()), 0);
            } else {
                m(view, 0, tv.chushou.zues.utils.a.dip2px(this.mYe, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            m(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dCM();
            com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = ou() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mYJ == null;
                b(false, false);
                if (z && this.mTN > 0 && this.mYJ != null && tv.chushou.zues.utils.systemBar.b.aD(getActivity()) && tv.chushou.zues.utils.systemBar.b.aE(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYJ.getLayoutParams();
                    layoutParams.rightMargin += this.mTN;
                    this.mYJ.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mYJ == null;
                if (this.mYe.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.mTN > 0 && this.mYJ != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mYJ.getLayoutParams();
                    layoutParams2.bottomMargin += this.mTN;
                    this.mYJ.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYd.dCC().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aw(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ax(false, false);
            this.mYf.K(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dBS().c) {
                h.dBS().b(false);
                this.mRL.clearAnimation();
                this.mTC.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                j(view, this.mTv.findViewById(a.f.ll_keyboard).getLeft(), this.mTv.getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
            } else {
                j(view, this.mTv.findViewById(a.f.ll_keyboard).getLeft(), this.mTv.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                tv.chushou.zues.utils.g.c(this.mYe, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.e(this.mYe, ou(), false);
        } else if (id == a.f.btn_screenChange) {
            dCM();
        } else if (id == a.f.rl_paoicon) {
            dCK();
        } else if (id == a.f.subscribe_icon) {
            dCU();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dCX();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dCV();
            }
        } else if (id == a.f.btn_audio && !this.mYd.d) {
            aj();
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            return false;
        }
        if (!tv.chushou.zues.utils.h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Om(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mTO <= 3000) {
            tv.chushou.zues.utils.g.Om(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dBS().e) {
                r(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
            if (com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYe).dCd().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mTO = System.currentTimeMillis();
                a(this.mYd.dCC().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYd.h);
                if (!z) {
                    this.mTI.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void q(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mXV != null) {
                if (z) {
                    this.mXV.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXV.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mTL != null) {
            if (z) {
                this.mTL.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTL.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dCW() {
        if (this.mXO == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXO.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mYR != null) {
            this.mYR.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mYR.dPC();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dCQ() {
        if (this.mYd.d()) {
            if (this.mTM) {
                this.mTJ.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mYe, this.mYe.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mTJ.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mYe, this.mYe.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.mTM = !this.mTM;
            if (this.mTI != null) {
                this.mTI.setEnabled(this.mTM ? false : true);
            }
        }
    }

    public void aw(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mTI);
            this.mTI.setText("");
            this.mTA.setVisibility(8);
            this.mTJ.setVisibility(8);
            this.mRG.setVisibility(8);
            this.mTv.setVisibility(8);
            this.mTz.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
        if (this.mTz.getVisibility() != 8 && z2) {
            this.mTz.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_top_anim));
        }
        this.mTA.setVisibility(8);
        this.mTJ.setVisibility(8);
        this.mRG.setVisibility(8);
        this.mTv.setVisibility(8);
        this.mTz.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ax(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mTB != null) {
            this.mTB.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ax(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dDM()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mTW != null) {
                this.mTW.a(this.e);
            }
            return this.e;
        }
        if (this.mYf != null) {
            this.mYf.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mYe).d(true);
            if (!z3) {
                if (this.mTv.getVisibility() != 0 && z2) {
                    this.mTv.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_bottom_anim));
                }
                this.mTv.setVisibility(0);
                this.mTA.setVisibility(0);
                this.mTJ.setVisibility(0);
                this.mTw.setVisibility(o() ? 0 : 8);
            }
            if (this.mRG.getVisibility() != 0 && z2) {
                this.mRG.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_top_anim));
            }
            t(!z3);
            this.mRG.setVisibility(0);
            if (this.mYf != null) {
                this.mYf.K(1, 5000L);
            }
            wl(false);
            if (this.mTW != null) {
                this.mTW.a(true);
            }
        } else {
            ((VideoPlayer) this.mYe).d(false);
            if (this.mYv != null) {
                this.mYv.dismiss();
            }
            if (this.mYw != null) {
                this.mYw.dismiss();
            }
            if (this.mYD != null) {
                this.mYD.dismiss();
            }
            if (this.mTv != null) {
                if (this.mTv.getVisibility() != 8 && z2) {
                    this.mTv.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_bottom_anim));
                }
                this.mTv.setVisibility(8);
            }
            if (this.mTA != null) {
                this.mTA.setVisibility(8);
                if (this.mRG.getVisibility() != 8 && z2) {
                    this.mRG.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_top_anim));
                }
                this.mRG.setVisibility(8);
                this.mTJ.setVisibility(8);
                wl(true);
                a(false);
                if (this.mTW != null) {
                    this.mTW.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dCR() {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
        if (this.ap == 1) {
            this.ar = Math.min(hd.x, hd.y);
            this.mYi = Math.max(hd.x, hd.y);
        } else {
            this.ar = Math.max(hd.x, hd.y);
            this.mYi = Math.min(hd.x, hd.y);
        }
        int i = this.ar;
        int i2 = this.mYi;
        if (this.mTp == null) {
            this.mTp = new Rect(0, 0, i / 5, i2);
        } else {
            this.mTp.set(0, 0, i / 5, i2);
        }
        if (this.mTq == null) {
            this.mTq = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mTq.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mTp == null) {
            return false;
        }
        return this.mTp.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        View findViewById = this.mXO.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXO.findViewById(a.f.brightness_view);
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
        if (this.mTq == null) {
            return false;
        }
        return this.mTq.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mXO.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXO.findViewById(a.f.volumn_view);
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
                if (this.mTM) {
                    this.mTJ.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.mTM) {
                    this.mYf.removeMessages(2);
                    this.mYf.K(2, 3000L);
                    return true;
                } else if (this.mYf != null) {
                    this.mYf.K(3, 1000L);
                    this.mYf.K(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.mTM) {
                    return true;
                }
                break;
        }
        return super.a(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MP(int i) {
        if (i <= 0) {
            i = 0;
        } else if (i >= 10) {
            i = 10;
        }
        int streamMaxVolume = (this.mYg.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int MQ(int i) {
        int streamMaxVolume = (i * 10) / this.mYg.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wk(boolean z) {
        if (z) {
            this.mXO.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mXO.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dDM() && parserRet != null) {
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
                                    if (this.mYe != null && (this.mYe instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mYe).a(1, null, this.H, false, false, true);
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
            b.this.mYg.setStreamVolume(3, b.this.MP(i), 0);
            b.this.wk(i <= 0);
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
            b.this.mTr = i / 10.0f;
            ((VideoPlayer) b.this.mYe).l = b.this.mTr;
            ((VideoPlayer) b.this.mYe).k = b.this.mTr * 255.0f;
            b.this.mTt.screenBrightness = b.this.mTr;
            b.this.mTs.setAttributes(b.this.mTt);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mYi && motionEvent2.getRawY() <= this.mYi) {
            int rawY = (int) (motionEvent.getRawY() - motionEvent2.getRawY());
            int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
            if (aVar.d == 0) {
                int abs = Math.abs(rawY);
                aVar.getClass();
                if (abs > 5 && Math.abs(rawX) < Math.abs(rawY)) {
                    if (c(motionEvent)) {
                        u(false);
                        aVar.getClass();
                        aVar.d = 1;
                        aVar.e = ((VerticalSeekBarVolumn) this.mXO.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        v(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mXO.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mRp.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mXO.findViewById(a.f.volumn_seekbar);
                    u(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mXO.findViewById(a.f.brightness_seekbar);
                        v(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mUs.getCurrentPos();
                            int duration = this.mUs.getDuration();
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
                            this.h.setText(tv.chushou.zues.utils.b.s(i3, false));
                            this.i.setText(tv.chushou.zues.utils.b.s(this.j, true));
                            if (duration > 1000) {
                                this.mRp.setProgress(i3 / (duration / 1000));
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
        if (!this.mTu) {
            if (this.mTz.getVisibility() == 8 && (this.mTK == null || !this.mTK.isShown())) {
                boolean z = this.mXY != null && this.mXY.getVisibility() == 0;
                if (this.e) {
                    ax(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                aw(false, true);
                dDA();
            }
        }
        return false;
    }

    public boolean dCZ() {
        if (this.mTu) {
            if (this.mYJ != null) {
                this.mYJ.e();
            }
            wl(false);
            if (this.mTv != null) {
                this.mTv.setVisibility(0);
            }
            if (this.mRG != null) {
                this.mRG.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ox() {
        super.ox();
        if (this.mYe instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mYd != null) {
            this.mYd.f = null;
            if (this.mYd.dCC() != null) {
                this.mYd.dCC().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mUs != null) {
                this.mUs.seekTo(0L);
                e(true);
            }
            dCM();
            return;
        }
        dCM();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mTM) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                tv.chushou.zues.utils.g.c(this.mYe, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mUs.getPlayState() == 4) {
                        dCS();
                        e(true);
                    } else {
                        if (this.mUc != null) {
                            this.mUc.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mYd.a(false);
                            ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                        } else if (this.mUs.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mUs.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mUs.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wo(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.mUs.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mUs.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                tv.chushou.zues.utils.g.c(this.mYe, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mYd.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                    this.ai = false;
                    wo(true);
                    a(false, !this.ak);
                } else if (this.mUs.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                    this.ai = false;
                    wo(true);
                    a(false, !this.ak);
                } else {
                    m(true);
                }
            } else if (motionEvent.getAction() == 0) {
            }
        }
        return motionEvent.getAction() == 0;
    }

    private void dCS() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.mYd != null && this.mYd.dCE() != null) {
                str = this.mYd.dCE().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dBM().z != null && com.kascend.chushou.a.a.dBM().z.contains(str) && this.mYd != null && !this.mUm) {
            this.mUm = true;
            com.kascend.chushou.a.a.dBM().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mUm = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mUc != null) {
            this.mUc.a(listItem, this.ap == 1, a.C0690a.zues_sweetalert_modal_in, a.C0690a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mUm = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mTD != null) {
                this.mTD.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mXY != null) {
                this.mXY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mTD != null) {
            this.mTD.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mXY != null) {
                    this.mXY.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dCT() {
        this.N = new SurfaceView(this.mYe);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mXO).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mYR != null) {
            this.mYR.dPC();
            this.mYR.setVisibility(8);
            this.mYR.unInit();
            ((RelativeLayout) this.mXO).removeView(this.mYR);
            this.mYR = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mXO).removeView(this.N);
            this.N = null;
        }
        dCT();
        ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
    }

    private void j(View view, int i, int i2) {
        if (this.mYf != null) {
            wl(true);
            this.mYf.removeMessages(1);
            this.mTv.setVisibility(0);
            this.mTA.setVisibility(8);
            this.mRG.setVisibility(8);
            this.mTJ.setVisibility(8);
        }
        if (this.mYD == null) {
            al();
            this.mYD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mRL.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mYD.isShowing()) {
            this.mYD.showAtLocation(view, 83, i, i2);
            this.mRL.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYd.dCC().mRoominfo.mRoomID);
            return;
        }
        this.mYD.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mTY != null && this.mTY.b()) {
                this.mTY.getGlobalVisibleRect(this.mUo);
                if (!this.mUo.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mTY.a();
                    return true;
                }
            }
            if (this.mTu && g(this.mYJ.b, motionEvent)) {
                dCZ();
                return true;
            }
            if (!dDz()) {
                if (System.currentTimeMillis() - this.mUn < 300 && this.mUc != null && this.mUc.isShown()) {
                    this.mUc.a();
                    if (this.mUs.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mYd.a(false);
                            ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                        } else if (this.mUs.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mYe).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mUs.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mUs.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wo(true);
                        }
                    }
                    return true;
                }
                this.mUn = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dDA() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
        if (this.mTK != null) {
            if (this.mTK.isShown()) {
                this.mTK.startAnimation(AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_top_anim));
            }
            this.mTK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mYe).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mYe).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mXW != null) {
                this.mXW.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hj(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTA.getLayoutParams();
                layoutParams.rightMargin -= this.mTN;
                this.mTA.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRG.getLayoutParams();
                layoutParams2.rightMargin -= this.mTN;
                this.mRG.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTz.getLayoutParams();
                layoutParams3.rightMargin -= this.mTN;
                this.mTz.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTv.getLayoutParams();
                layoutParams4.rightMargin -= this.mTN;
                layoutParams4.bottomMargin += this.mTN;
                this.mTv.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
            this.mTR.setVisibility(0);
            if (this.mYd.dCC().mRoominfo.mIsSubscribed) {
                this.mTR.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mTR.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mTR.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dCU() {
        RoomInfo roomInfo;
        if (this.mYd != null && this.mYd.dCC() != null && (roomInfo = this.mYd.dCC().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mYe, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dQS();
                        b.this.wm(true);
                    }
                });
            } else {
                wm(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void wm(final boolean z) {
        RoomInfo roomInfo;
        String str;
        if (this.mYd != null && this.mYd.dCC() != null && (roomInfo = this.mYd.dCC().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dDM()) {
                        b.this.s(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dDM()) {
                        b.this.s(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.M(b.this.mYe, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.M(b.this.mYe, a.i.subscribe_success);
                            }
                            if (b.this.mYd != null && b.this.mYd.dCC() != null && (roomInfo2 = b.this.mYd.dCC().mRoominfo) != null) {
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
                    if (!b.this.dDM()) {
                        b.this.s(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mYe, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mYe, str2);
                    }
                }
            };
            if (this.mYd != null && this.mYd.h != null) {
                try {
                    str = new JSONObject(this.mYd.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dBO().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dBO().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                }
            }
            str = null;
            String a22 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
            if (!z) {
            }
        }
    }

    public void s(boolean z) {
        if (z) {
            if (this.mTS == null) {
                this.mTS = new ProgressDialog(this.mYe);
                this.mTS.setProgressStyle(0);
                this.mTS.requestWindowFeature(1);
                this.mTS.setMessage(this.mYe.getText(a.i.update_userinfo_ing));
                this.mTS.setCancelable(true);
            }
            if (!this.mTS.isShowing()) {
                this.mTS.show();
            }
        } else if (this.mTS != null && this.mTS.isShowing()) {
            this.mTS.dismiss();
        }
    }

    private void dCV() {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
            if (this.mTU == null) {
                this.mTU = new f(getActivity());
            }
            this.mTU.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mTU = null;
                }
            });
            RoomInfo roomInfo = this.mYd.dCC().mRoominfo;
            this.mTU.a();
            this.mTU.a(roomInfo);
            if (!this.mTU.isShowing()) {
                this.mTU.show();
            }
        }
    }

    private void dCX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mUl != null && this.mYg != null && this.mYe != null && (this.mYe instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mUl;
            VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
            verticalSeekBarVolumn.setProgressOnly(MQ(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mRq != null) {
            this.mRq.dQu();
        }
        if (this.mXO != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mTW == null) {
                this.mTW = new com.kascend.chushou.player.ui.giftpopup.a(this.mXO, i);
            } else if (this.mTW.a() != i) {
                this.mTW.b();
                this.mTW = null;
                this.mTW = new com.kascend.chushou.player.ui.giftpopup.a(this.mXO, i);
            }
            List<ListItem> j = this.mYd != null ? this.mYd.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
            if (videoPlayer != null) {
                this.mTW.a(j, videoPlayer.dCi(), videoPlayer.dCj(), videoPlayer.dCk(), videoPlayer.dCl());
                this.mTW.a(this.e);
                if (this.mYd != null && this.mYd.mQW != null) {
                    this.mTW.a(this.mYd.mQW, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mYd != null) {
                                b.this.mYd.mQW = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mTW != null && this.mYd != null) {
                    this.mTW.b(this.mYd.mQY);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mTW != null && this.mYe != null) {
            this.mTW.a(((VideoPlayer) this.mYe).dCi());
            this.mTW.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYe instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dCi = ((VideoPlayer) this.mYe).dCi();
            if (this.mYU == null) {
                this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYU.setVisibility(0);
            this.mYU.a(i, dCi);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mTW != null) {
            this.mTW.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mTG != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mTG.setVisibility(0);
                    this.mTG.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mTG.setVisibility(8);
                }
            }
            if (this.mTE != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mTF.setVisibility(0);
                    this.mTE.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mTF.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mTW != null) {
            this.mTW.a(((VideoPlayer) this.mYe).dCj());
            this.mTW.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mTW != null) {
            this.mTW.a(((VideoPlayer) this.mYe).dCj());
            this.mTW.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mTW != null) {
            this.mTW.a(((VideoPlayer) this.mYe).dCk());
            this.mTW.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mTW != null) {
            this.mTW.a(((VideoPlayer) this.mYe).dCl());
            this.mTW.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wn(false);
        super.F();
    }

    private void c(View view) {
        this.mUd = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mSo = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mSo.setText(new tv.chushou.zues.widget.a.c().O(this.mYe, a.e.videoplayer_4g_video).append("  ").append(this.mYe.getString(a.i.videoplayer_4g_video)));
        this.mUe = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mUe.setText(new tv.chushou.zues.widget.a.c().O(this.mYe, a.e.videoplayer_4g_audio).append("  ").append(this.mYe.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dCM();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mYe, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mUd.setVisibility(8);
                    ((VideoPlayer) b.this.mYe).b(b.this.mSr);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mUd.setVisibility(8);
                    ((VideoPlayer) b.this.mYe).c(b.this.mSr);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
        findViewById.setLayoutParams(layoutParams);
        this.mSo.setOnClickListener(onClickListener);
        this.mUe.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mYd != null && !tv.chushou.zues.utils.h.isEmpty(this.mYd.f)) {
            f(this.mYd.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mSr = z;
            this.p = false;
            if (this.mYd != null && this.mYd.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mYd.f.size()) {
                        break;
                    } else if (!"2".equals(this.mYd.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mUd != null) {
                this.mUd.setVisibility(0);
                this.mSo.setVisibility(0);
                this.mUe.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mUd != null) {
            this.mUd.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mTW != null && this.mYd != null) {
            this.mTW.b(this.mYd.mQY);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mXO != null && (findViewById = this.mXO.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mTE != null) {
            this.mTE.performClick();
        }
    }
}
