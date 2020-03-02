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
    private TextView mSr;
    private boolean mSt;
    private LinearLayout mTD;
    private FrameLayout mTH;
    private FrescoThumbnailView mTI;
    private ImageView mTL;
    private ImageView mTN;
    public int mTR;
    RelativeLayout mTS;
    private ImageView mTT;
    private ImageView mTV;
    private f mTW;
    private com.kascend.chushou.player.ui.giftpopup.a mTY;
    private PopH5Menu mUa;
    private com.kascend.chushou.player.b.a mUb;
    private GiftAnimationLayout mUc;
    private ImageView mUd;
    private FoodView mUe;
    private RelativeLayout mUf;
    private TextView mUg;
    private VerticalSeekBarVolumn mUn;
    private long mUp;
    private Rect mTr = null;
    private Rect mTs = null;
    private float mTt = 0.0f;
    private Window mTu = null;
    private WindowManager.LayoutParams mTv = null;
    private boolean mTw = false;
    private View mTz = null;
    private View mRI = null;
    private View mTA = null;
    private View mTB = null;
    private View mTC = null;
    private ImageView mRN = null;
    private ImageView mTE = null;
    private ImageButton mTF = null;
    private FrescoThumbnailView mTG = null;
    private LinearLayout mTJ = null;
    private EditText mTK = null;
    private View mTM = null;
    private boolean mTO = false;
    private int bU = 0;
    private int mTP = 0;
    private long mTQ = 0;
    private ProgressDialog mTU = null;
    private boolean mTX = true;
    private int mTZ = -1;
    private boolean mUh = false;
    private TextView mUi = null;
    private TextView mUj = null;
    private int mUl = 0;
    private boolean mUm = false;
    private boolean mUo = false;
    private final Rect mUq = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTR = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mRs = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mXQ = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mTR;
        if (this.mYg != null && !((Activity) this.mYg).isFinishing()) {
            dDy();
        }
        return this.mXQ;
    }

    public void dCM() {
        ax(false, false);
        super.p(true);
        com.kascend.chushou.toolkit.a.c.a(this.mYg, "能量_num", "横屏", new Object[0]);
    }

    public boolean dDa() {
        if (this.mYP == null || !this.mYP.isShown()) {
            return false;
        }
        this.mYP.d();
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
        if (z3 || this.mXQ.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dBU().e;
        } else {
            z = h.dBU().b;
        }
        q(z);
        if (this.mYL != null) {
            this.mYL.b();
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
        if (this.mTY != null) {
            this.mTY.b();
            this.mTY = null;
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
            dCT();
            y();
            if (this.mRs != null) {
                this.mRs.onConfigurationChanged(configuration);
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
        if (this.mUa != null && this.mTZ != i3) {
            this.mUa.a();
            this.mUa = null;
        }
        if (this.mUa == null) {
            this.mUa = (PopH5Menu) ((ViewStub) this.mXQ.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUa.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mUa.setLayoutParams(layoutParams);
            this.mTZ = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mUa.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dDO()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mYg instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dCl = ((VideoPlayer) this.mYg).dCl();
                    if (this.mYW == null) {
                        this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYW.setVisibility(0);
                    this.mYW.a(i, dCl);
                }
            } else if (bVar.a == 3) {
                if (this.mYg instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dCm = ((VideoPlayer) this.mYg).dCm();
                    if (this.mYW == null) {
                        this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mYW.setVisibility(0);
                    this.mYW.a(i, dCm);
                }
            } else if (bVar.a == 9) {
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dCG;
        if (!dDO() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mYf != null && mVar.b.equals(this.mYf.a) && (dCG = this.mYf.dCG()) != null) {
            dCG.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dDy() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.bU = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
        this.mTP = tv.chushou.zues.utils.systemBar.b.hi(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.mTP);
        this.mUu = ((VideoPlayer) this.mYg).dCc();
        this.mYf = ((VideoPlayer) this.mYg).dCf();
        c(this.mXQ);
        if (this.aw.equals("1")) {
            this.mRq = ((VideoPlayer) this.mYg).dCg();
            this.mRq.a(this);
            if (this.mUb != null) {
                this.mUb.a();
                this.mUb = null;
                this.mUc = null;
            }
            this.mUc = (GiftAnimationLayout) this.mXQ.findViewById(a.f.ll_gift_animation);
            this.mUc.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mYf != null) {
                this.mUb = new com.kascend.chushou.player.b.a(this.mYg.getApplicationContext(), this.mUc);
                this.mUb.a(this.mYf);
            }
            this.B = (TextView) this.mXQ.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dCV();
        if (this.mRq != null) {
            this.mRq.d();
        }
        dDu();
        this.mTL = (ImageView) this.mXQ.findViewById(a.f.btn_lockscreen);
        this.mTL.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mXQ.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mYa = (PlayerErrorView) this.mXQ.findViewById(a.f.view_net_error_msg);
        this.mYa.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dCP();
        cXM();
        this.mYP = (PaoGuideView) this.mXQ.findViewById(a.f.rlPaoGuideView);
        this.mUd = (ImageView) this.mXQ.findViewById(a.f.iv_send_danmu);
        this.mTC = this.mXQ.findViewById(a.f.rt_layout);
        this.mTG = (FrescoThumbnailView) this.mTC.findViewById(a.f.btn_gift);
        this.mTH = (FrameLayout) this.mTC.findViewById(a.f.flfl_bottom_gift);
        this.mTI = (FrescoThumbnailView) this.mTC.findViewById(a.f.btn_recharge);
        this.mTI.setOnClickListener(this);
        a(this.mYf == null ? null : this.mYf.mQZ);
        this.mYV = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mTw = false;
                b.this.wl(false);
                if (b.this.mYh != null) {
                    b.this.mYh.removeMessages(1);
                    b.this.mYh.K(1, 5000L);
                }
                b.this.mTL.setVisibility(0);
                b.this.mTC.setVisibility(0);
                b.this.mRI.setVisibility(0);
                b.this.mTz.setVisibility(0);
                if (b.this.mTY != null) {
                    b.this.mTY.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mYg, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mTw = true;
                b.this.wl(true);
                b.this.mTL.setVisibility(8);
                b.this.mTC.setVisibility(8);
                if (b.this.mTY != null) {
                    b.this.mTY.a(false);
                }
                b.this.mRI.setVisibility(8);
                b.this.mTz.setVisibility(8);
                if (b.this.mYh != null) {
                    b.this.mYh.removeMessages(1);
                }
                if (b.this.mYL != null) {
                    b.this.mYL.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mYg, 14.0f) + b.this.mYL.getMeasuredHeight(), 12);
                }
            }
        };
        this.mTJ = (LinearLayout) this.mXQ.findViewById(a.f.rl_seekbar);
        this.mTS = (RelativeLayout) this.mXQ.findViewById(a.f.rl_paoicon);
        this.mTS.setOnClickListener(this);
        this.mYM = (RoundProgressBar) this.mXQ.findViewById(a.f.roundProgressBar);
        this.mYO = (FrescoThumbnailView) this.mXQ.findViewById(a.f.iv_paoicon);
        this.mYN = (TextView) this.mXQ.findViewById(a.f.tv_paonum);
        this.aSy = 0;
        this.mYQ = 0L;
        com.kascend.chushou.player.ui.a.a dCo = ((VideoPlayer) this.mYg).dCo();
        a(dCo.dDV());
        BangInfo dDW = dCo.dDW();
        if (dDW != null) {
            a(dDW, dCo.d());
        }
        if (this.aw.equals("3")) {
            this.mTJ.setVisibility(0);
            this.mTH.setVisibility(8);
            this.mUd.setVisibility(0);
            this.mUd.setOnClickListener(this);
        } else {
            this.mUd.setVisibility(8);
            this.mTJ.setVisibility(8);
            this.mTH.setVisibility(0);
            this.mTG.setOnClickListener(this);
        }
        dCQ();
        if (tv.chushou.zues.utils.systemBar.b.hj(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTC.getLayoutParams();
            layoutParams.rightMargin += this.mTP;
            this.mTC.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRI.getLayoutParams();
            layoutParams2.rightMargin += this.mTP;
            this.mRI.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTB.getLayoutParams();
            layoutParams3.rightMargin += this.mTP;
            this.mTB.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTz.getLayoutParams();
            layoutParams4.rightMargin += this.mTP;
            this.mTz.setLayoutParams(layoutParams4);
        }
        dDA();
        dCN();
        dCT();
        this.h = (TextView) this.mXQ.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXQ.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mYf.dCE() != null) {
                this.mTV.setVisibility(0);
            } else {
                this.mTV.setVisibility(8);
            }
        }
        dDz();
        n();
        k(100);
        this.mUe = (FoodView) this.mXQ.findViewById(a.f.kav_room_ad);
        this.mYh = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ax(false, true);
                            break;
                        case 2:
                            b.this.mYh.removeMessages(2);
                            if (b.this.mTL != null) {
                                b.this.mTL.setVisibility(8);
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
                            TextView textView = (TextView) b.this.mXQ.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mYg.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mYh.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mYh.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mYh.K(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aw(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mYg).q) {
                                b.this.a(b.this.mYh);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mYg).q) {
                                b.this.b(b.this.mYh);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mYg).g = true;
                            b.this.mUu.seekTo((int) b.this.kWe);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mYf.d()) {
                                b.this.mUu.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mUu.getPlayState() == 4) {
                                int currentPos = b.this.mUu.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mYh != null) {
                                    b.this.mYh.K(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dDR();
                            break;
                        case 18:
                            b.this.cXL();
                            break;
                        case 19:
                            b.this.mYe.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mYf != null) {
            a(this.mYf.dCF());
        }
        if (this.mUu != null && (this.mUu.getPlayState() == 3 || this.mUu.getPlayState() == 4)) {
            wn(false);
            if (this.mYf.d()) {
                this.ak = false;
                wo(true);
                if (this.mUu.getDuration() > 60000) {
                    if (this.mUu.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mUu.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mUu.getDuration();
                }
            }
            this.e = false;
            ax(true, false);
            this.mYh.Of(8);
            if (h() && this.mUu.getPlayState() == 4 && this.mYh != null) {
                this.mYh.removeMessages(15);
                this.mYh.Of(15);
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
            int[] dBT = g.dBT();
            int i = dBT.length == 2 ? dBT[1] : 0;
            if (i > 0) {
                View findViewById = this.mXQ.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mXQ.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mYg, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        dDQ();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mYg, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mYg != null && (this.mYg instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYg).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mTI.xo(a.e.ic_recharge_old);
            this.mTG.xo(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mUh && !this.k) {
            try {
                if (this.mUu != null) {
                    i = this.mUu.getCurrentPos();
                    i2 = this.mUu.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mRr.setProgress(i / (i2 / 1000));
                    this.mUi.setText(tv.chushou.zues.utils.b.s(this.mUu.getDuration(), false));
                    this.mUj.setText(tv.chushou.zues.utils.b.s(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dDz() {
        this.mRr = (ProgressBar) this.mXQ.findViewById(a.f.progressBarl);
        if (this.mRr != null) {
            if (this.mRr instanceof SeekBar) {
                ((SeekBar) this.mRr).setOnSeekBarChangeListener(new C0697b());
            }
            this.mRr.setMax(1000);
        }
        this.mUi = (TextView) this.mXQ.findViewById(a.f.tv_time_duration);
        this.mUj = (TextView) this.mXQ.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mXQ.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mXQ.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dCo;
        BangInfo dDW;
        if (config != null) {
            this.mYS = config;
            if (!config.display) {
                this.mTS.setVisibility(8);
            } else if ((this.mYg instanceof VideoPlayer) && (dDW = (dCo = ((VideoPlayer) this.mYg).dCo()).dDW()) != null) {
                a(dDW, dCo.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mYS == null || this.mYS.display) && this.mTS != null) {
            this.mTS.setVisibility(0);
            this.mYN.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mYg instanceof VideoPlayer) {
            if ((this.mYS == null || this.mYS.display) && this.mTS != null) {
                if (j > 0) {
                    this.mTS.setVisibility(0);
                    boolean z = this.mYR;
                    this.mYR = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mYg.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mYN.setText(cVar);
                    return;
                }
                this.mYR = false;
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
                if (b.this.mUl != i || b.this.mUm != z) {
                    b.this.mUl = i;
                    b.this.mUm = z;
                    if (z) {
                        if (b.this.mUh) {
                            b.this.kWe = (b.this.mUu.getDuration() / 1000) * i;
                        }
                        b.this.mUj.setText(tv.chushou.zues.utils.b.s((int) b.this.kWe, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.s((int) b.this.kWe, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.s(((int) b.this.kWe) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mUh = true;
            b.this.m = b.this.mUu.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mYh != null) {
                if (b.this.mUh) {
                    b.this.mUh = false;
                }
                b.this.mYh.removeMessages(14);
                b.this.mYh.Of(14);
            }
        }
    }

    private void k(int i) {
        this.mRr.setSecondaryProgress((i * 1000) / 100);
    }

    private void dDu() {
        this.mUn = (VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.volumn_seekbar);
        this.mUn.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mYi.getStreamVolume(3);
        this.mUn.setProgress(MQ(streamVolume));
        wk(MQ(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mRo = new d.a();
            this.c = new GestureDetector(this.mYg, this.mRo);
        }
    }

    private void dDA() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mTu == null) {
                this.mTu = ((Activity) this.mYg).getWindow();
            }
            this.mTv = this.mTu.getAttributes();
            this.mTt = ((VideoPlayer) this.mYg).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mTt));
        }
    }

    private void dCN() {
        this.mXQ.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mXQ.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mYg.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mXQ.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mTK == null) {
            this.mTK = (EditText) this.mXQ.findViewById(a.f.et_input);
            this.mTK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mXQ.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCO() {
        if (this.mTW != null) {
            this.mTW.dismiss();
            this.mTW = null;
        }
        if (this.mYg != null) {
            ((VideoPlayer) this.mYg).a(1, null, this.H, false);
        }
    }

    private void dCP() {
        this.mRI = this.mXQ.findViewById(a.f.topview);
        this.mTD = (LinearLayout) this.mXQ.findViewById(a.f.topRight);
        this.mTA = this.mRI.findViewById(a.f.rl_download);
        this.mTB = this.mXQ.findViewById(a.f.topKeyboardView);
        this.mXQ.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mRI.getVisibility() == 0;
        if (this.bU > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRI.getLayoutParams();
            layoutParams.topMargin = this.bU;
            this.mRI.setLayoutParams(layoutParams);
        }
        this.mXQ.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mXQ.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                str = this.mYf.dCE().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mXQ.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mTT = (ImageView) this.mXQ.findViewById(a.f.subscribe_icon);
        this.mTT.setOnClickListener(this);
        this.mTV = (ImageView) this.mXQ.findViewById(a.f.report_icon);
        this.mTV.setOnClickListener(this);
        q();
    }

    private void dCQ() {
        boolean z;
        this.mTz = this.mXQ.findViewById(a.f.bottomview);
        this.mTF = (ImageButton) this.mTz.findViewById(a.f.playbutton);
        this.mTF.setOnTouchListener(this);
        this.mXX = (ImageButton) this.mXQ.findViewById(a.f.btn_barrage);
        this.mXY = (ImageButton) this.mXQ.findViewById(a.f.btn_audio);
        this.mTN = (ImageView) this.mXQ.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mTz.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mTz.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mXX.setVisibility(0);
            this.mTN.setVisibility(8);
            if (this.mYf != null && this.mYf.f != null) {
                for (int i = 0; i < this.mYf.f.size(); i++) {
                    if ("2".equals(this.mYf.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mXY.setVisibility(0);
            } else {
                this.mXY.setVisibility(8);
            }
            this.mTz.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mXX.setOnClickListener(this);
            if (h.dBU().e) {
                this.mXX.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mXX.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mYf.d) {
                this.mXY.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mXY.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mXY.setOnClickListener(this);
            this.mRN = (ImageView) this.mTz.findViewById(a.f.btn_hotword);
            this.mTE = (ImageView) this.mXQ.findViewById(a.f.iv_task_badge);
            this.mRN.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mYg, a.C0690a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dBU().c) {
                        b.this.mRN.clearAnimation();
                        b.this.mRN.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRN.clearAnimation();
            if (h.dBU().c) {
                this.mRN.startAnimation(animationSet);
                this.mTE.setVisibility(0);
            }
        } else {
            this.mTz.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mTz.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mXX.setVisibility(8);
            this.mXY.setVisibility(8);
            this.mTN.setVisibility(0);
            this.mTN.setOnClickListener(this);
            if (h.dBU().b) {
                this.mTN.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTN.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mTz.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mYg != null) {
            ((VideoPlayer) this.mYg).d(true);
        }
        if (this.mYh != null) {
            this.mYh.cq(null);
            this.mYh = null;
        }
        this.c = null;
        this.mRo = null;
        this.mTL = null;
        if (this.mTK != null) {
            this.mTK.addTextChangedListener(null);
            this.mTK.setOnEditorActionListener(null);
            this.mTK = null;
        }
        this.mRI = null;
        this.mXX = null;
        this.mXY = null;
        this.mTz = null;
        this.mTC = null;
        if (this.mUb != null) {
            this.mUb.a();
            this.mUb = null;
            this.mUc = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDo() {
        return this.mUb;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mXQ == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mYW == null || !this.mYW.a(i, keyEvent)) {
                    if ((this.mUa == null || !this.mUa.onKeyDown(i, keyEvent)) && !dDa() && !dDb()) {
                        if (this.mTB != null && this.mTB.getVisibility() == 0) {
                            aw(false, true);
                            return true;
                        } else if (this.mTM != null && this.mTM.isShown()) {
                            dDC();
                            return true;
                        } else if (this.mTO && this.mYh != null) {
                            if (this.mTL != null) {
                                this.mTL.setVisibility(0);
                            }
                            this.mYh.removeMessages(2);
                            this.mYh.K(2, 3000L);
                            return true;
                        } else {
                            dCO();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                u(false);
                int progress = ((VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mYh != null) {
                    this.mYh.removeMessages(3);
                    this.mYh.K(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dDB() {
        if (this.mTO) {
            this.mTL.setVisibility(0);
            this.mYh.removeMessages(2);
            this.mYh.K(2, 3000L);
        }
        return this.mTO;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.mTO) {
            if (view.getId() == a.f.btn_lockscreen) {
                dCS();
                return;
            }
            this.mTL.setVisibility(0);
            this.mYh.removeMessages(2);
            this.mYh.K(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mYg, getString(a.i.STR_VP_SCREEN_LOCK));
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
            l(view, 0, this.mRI.getHeight() + this.mRI.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mTK.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.M(this.mYg, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mTK.setText((CharSequence) null);
                aw(false, true);
            } else if (a(this.mTK.getText().toString(), false)) {
                aw(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dCS();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                m(view, tv.chushou.zues.utils.systemBar.b.hi(getActivity()), 0);
            } else {
                m(view, 0, tv.chushou.zues.utils.a.dip2px(this.mYg, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            m(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dCO();
            com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = ou() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mYL == null;
                b(false, false);
                if (z && this.mTP > 0 && this.mYL != null && tv.chushou.zues.utils.systemBar.b.aD(getActivity()) && tv.chushou.zues.utils.systemBar.b.aE(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYL.getLayoutParams();
                    layoutParams.rightMargin += this.mTP;
                    this.mYL.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mYL == null;
                if (this.mYg.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.mTP > 0 && this.mYL != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mYL.getLayoutParams();
                    layoutParams2.bottomMargin += this.mTP;
                    this.mYL.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYf.dCE().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aw(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ax(false, false);
            this.mYh.K(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dBU().c) {
                h.dBU().b(false);
                this.mRN.clearAnimation();
                this.mTE.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                j(view, this.mTz.findViewById(a.f.ll_keyboard).getLeft(), this.mTz.getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
            } else {
                j(view, this.mTz.findViewById(a.f.ll_keyboard).getLeft(), this.mTz.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                tv.chushou.zues.utils.g.c(this.mYg, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.e(this.mYg, ou(), false);
        } else if (id == a.f.btn_screenChange) {
            dCO();
        } else if (id == a.f.rl_paoicon) {
            dCM();
        } else if (id == a.f.subscribe_icon) {
            dCW();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dCZ();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dCX();
            }
        } else if (id == a.f.btn_audio && !this.mYf.d) {
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
        } else if (System.currentTimeMillis() - this.mTQ <= 3000) {
            tv.chushou.zues.utils.g.Om(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dBU().e) {
                r(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
            if (com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYg).dCf().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mTQ = System.currentTimeMillis();
                a(this.mYf.dCE().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYf.h);
                if (!z) {
                    this.mTK.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void q(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mXX != null) {
                if (z) {
                    this.mXX.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mXX.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mTN != null) {
            if (z) {
                this.mTN.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTN.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dCY() {
        if (this.mXQ == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXQ.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mYT != null) {
            this.mYT.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mYT.dPE();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dCS() {
        if (this.mYf.d()) {
            if (this.mTO) {
                this.mTL.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mYg, this.mYg.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mTL.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mYg, this.mYg.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.mTO = !this.mTO;
            if (this.mTK != null) {
                this.mTK.setEnabled(this.mTO ? false : true);
            }
        }
    }

    public void aw(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mTK);
            this.mTK.setText("");
            this.mTC.setVisibility(8);
            this.mTL.setVisibility(8);
            this.mRI.setVisibility(8);
            this.mTz.setVisibility(8);
            this.mTB.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
        if (this.mTB.getVisibility() != 8 && z2) {
            this.mTB.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_top_anim));
        }
        this.mTC.setVisibility(8);
        this.mTL.setVisibility(8);
        this.mRI.setVisibility(8);
        this.mTz.setVisibility(8);
        this.mTB.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ax(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mTD != null) {
            this.mTD.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ax(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dDO()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mTY != null) {
                this.mTY.a(this.e);
            }
            return this.e;
        }
        if (this.mYh != null) {
            this.mYh.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mYg).d(true);
            if (!z3) {
                if (this.mTz.getVisibility() != 0 && z2) {
                    this.mTz.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_bottom_anim));
                }
                this.mTz.setVisibility(0);
                this.mTC.setVisibility(0);
                this.mTL.setVisibility(0);
                this.mTA.setVisibility(o() ? 0 : 8);
            }
            if (this.mRI.getVisibility() != 0 && z2) {
                this.mRI.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_top_anim));
            }
            t(!z3);
            this.mRI.setVisibility(0);
            if (this.mYh != null) {
                this.mYh.K(1, 5000L);
            }
            wl(false);
            if (this.mTY != null) {
                this.mTY.a(true);
            }
        } else {
            ((VideoPlayer) this.mYg).d(false);
            if (this.mYx != null) {
                this.mYx.dismiss();
            }
            if (this.mYy != null) {
                this.mYy.dismiss();
            }
            if (this.mYF != null) {
                this.mYF.dismiss();
            }
            if (this.mTz != null) {
                if (this.mTz.getVisibility() != 8 && z2) {
                    this.mTz.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_bottom_anim));
                }
                this.mTz.setVisibility(8);
            }
            if (this.mTC != null) {
                this.mTC.setVisibility(8);
                if (this.mRI.getVisibility() != 8 && z2) {
                    this.mRI.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_top_anim));
                }
                this.mRI.setVisibility(8);
                this.mTL.setVisibility(8);
                wl(true);
                a(false);
                if (this.mTY != null) {
                    this.mTY.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dCT() {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
        if (this.ap == 1) {
            this.ar = Math.min(hd.x, hd.y);
            this.mYk = Math.max(hd.x, hd.y);
        } else {
            this.ar = Math.max(hd.x, hd.y);
            this.mYk = Math.min(hd.x, hd.y);
        }
        int i = this.ar;
        int i2 = this.mYk;
        if (this.mTr == null) {
            this.mTr = new Rect(0, 0, i / 5, i2);
        } else {
            this.mTr.set(0, 0, i / 5, i2);
        }
        if (this.mTs == null) {
            this.mTs = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mTs.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mTr == null) {
            return false;
        }
        return this.mTr.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        View findViewById = this.mXQ.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXQ.findViewById(a.f.brightness_view);
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
        if (this.mTs == null) {
            return false;
        }
        return this.mTs.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mXQ.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mXQ.findViewById(a.f.volumn_view);
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
                if (this.mTO) {
                    this.mTL.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.mTO) {
                    this.mYh.removeMessages(2);
                    this.mYh.K(2, 3000L);
                    return true;
                } else if (this.mYh != null) {
                    this.mYh.K(3, 1000L);
                    this.mYh.K(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.mTO) {
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
        int streamMaxVolume = (this.mYi.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int MQ(int i) {
        int streamMaxVolume = (i * 10) / this.mYi.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wk(boolean z) {
        if (z) {
            this.mXQ.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mXQ.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dDO() && parserRet != null) {
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
                                    if (this.mYg != null && (this.mYg instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mYg).a(1, null, this.H, false, false, true);
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
            b.this.mYi.setStreamVolume(3, b.this.MP(i), 0);
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
            b.this.mTt = i / 10.0f;
            ((VideoPlayer) b.this.mYg).l = b.this.mTt;
            ((VideoPlayer) b.this.mYg).k = b.this.mTt * 255.0f;
            b.this.mTv.screenBrightness = b.this.mTt;
            b.this.mTu.setAttributes(b.this.mTv);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mYk && motionEvent2.getRawY() <= this.mYk) {
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        v(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mRr.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.volumn_seekbar);
                    u(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mXQ.findViewById(a.f.brightness_seekbar);
                        v(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mUu.getCurrentPos();
                            int duration = this.mUu.getDuration();
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
                                this.mRr.setProgress(i3 / (duration / 1000));
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
        if (!this.mTw) {
            if (this.mTB.getVisibility() == 8 && (this.mTM == null || !this.mTM.isShown())) {
                boolean z = this.mYa != null && this.mYa.getVisibility() == 0;
                if (this.e) {
                    ax(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                aw(false, true);
                dDC();
            }
        }
        return false;
    }

    public boolean dDb() {
        if (this.mTw) {
            if (this.mYL != null) {
                this.mYL.e();
            }
            wl(false);
            if (this.mTz != null) {
                this.mTz.setVisibility(0);
            }
            if (this.mRI != null) {
                this.mRI.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ox() {
        super.ox();
        if (this.mYg instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mYf != null) {
            this.mYf.f = null;
            if (this.mYf.dCE() != null) {
                this.mYf.dCE().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mUu != null) {
                this.mUu.seekTo(0L);
                e(true);
            }
            dCO();
            return;
        }
        dCO();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mTO) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                tv.chushou.zues.utils.g.c(this.mYg, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mUu.getPlayState() == 4) {
                        dCU();
                        e(true);
                    } else {
                        if (this.mUe != null) {
                            this.mUe.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mYf.a(false);
                            ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                        } else if (this.mUu.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mUu.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mUu.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wo(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.mUu.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mUu.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                tv.chushou.zues.utils.g.c(this.mYg, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mYf.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                    this.ai = false;
                    wo(true);
                    a(false, !this.ak);
                } else if (this.mUu.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
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

    private void dCU() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.mYf != null && this.mYf.dCG() != null) {
                str = this.mYf.dCG().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dBO().z != null && com.kascend.chushou.a.a.dBO().z.contains(str) && this.mYf != null && !this.mUo) {
            this.mUo = true;
            com.kascend.chushou.a.a.dBO().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mUo = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mUe != null) {
            this.mUe.a(listItem, this.ap == 1, a.C0690a.zues_sweetalert_modal_in, a.C0690a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mUo = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mTF != null) {
                this.mTF.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mYa != null) {
                this.mYa.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mTF != null) {
            this.mTF.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mYa != null) {
                    this.mYa.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dCV() {
        this.N = new SurfaceView(this.mYg);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mXQ).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mYT != null) {
            this.mYT.dPE();
            this.mYT.setVisibility(8);
            this.mYT.unInit();
            ((RelativeLayout) this.mXQ).removeView(this.mYT);
            this.mYT = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mXQ).removeView(this.N);
            this.N = null;
        }
        dCV();
        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
    }

    private void j(View view, int i, int i2) {
        if (this.mYh != null) {
            wl(true);
            this.mYh.removeMessages(1);
            this.mTz.setVisibility(0);
            this.mTC.setVisibility(8);
            this.mRI.setVisibility(8);
            this.mTL.setVisibility(8);
        }
        if (this.mYF == null) {
            al();
            this.mYF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mRN.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mYF.isShowing()) {
            this.mYF.showAtLocation(view, 83, i, i2);
            this.mRN.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYf.dCE().mRoominfo.mRoomID);
            return;
        }
        this.mYF.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mUa != null && this.mUa.b()) {
                this.mUa.getGlobalVisibleRect(this.mUq);
                if (!this.mUq.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mUa.a();
                    return true;
                }
            }
            if (this.mTw && g(this.mYL.b, motionEvent)) {
                dDb();
                return true;
            }
            if (!dDB()) {
                if (System.currentTimeMillis() - this.mUp < 300 && this.mUe != null && this.mUe.isShown()) {
                    this.mUe.a();
                    if (this.mUu.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mYf.a(false);
                            ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                        } else if (this.mUu.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mYg).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mUu.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mUu.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wo(true);
                        }
                    }
                    return true;
                }
                this.mUp = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dDC() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
        if (this.mTM != null) {
            if (this.mTM.isShown()) {
                this.mTM.startAnimation(AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_top_anim));
            }
            this.mTM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mYg).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mYg).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mXY != null) {
                this.mXY.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hj(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTC.getLayoutParams();
                layoutParams.rightMargin -= this.mTP;
                this.mTC.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRI.getLayoutParams();
                layoutParams2.rightMargin -= this.mTP;
                this.mRI.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTB.getLayoutParams();
                layoutParams3.rightMargin -= this.mTP;
                this.mTB.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTz.getLayoutParams();
                layoutParams4.rightMargin -= this.mTP;
                layoutParams4.bottomMargin += this.mTP;
                this.mTz.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
            this.mTT.setVisibility(0);
            if (this.mYf.dCE().mRoominfo.mIsSubscribed) {
                this.mTT.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mTT.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mTT.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dCW() {
        RoomInfo roomInfo;
        if (this.mYf != null && this.mYf.dCE() != null && (roomInfo = this.mYf.dCE().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mYg, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dQU();
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
        if (this.mYf != null && this.mYf.dCE() != null && (roomInfo = this.mYf.dCE().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dDO()) {
                        b.this.s(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dDO()) {
                        b.this.s(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.M(b.this.mYg, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.M(b.this.mYg, a.i.subscribe_success);
                            }
                            if (b.this.mYf != null && b.this.mYf.dCE() != null && (roomInfo2 = b.this.mYf.dCE().mRoominfo) != null) {
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
                    if (!b.this.dDO()) {
                        b.this.s(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mYg, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mYg, str2);
                    }
                }
            };
            if (this.mYf != null && this.mYf.h != null) {
                try {
                    str = new JSONObject(this.mYf.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dBQ().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dBQ().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.mTU == null) {
                this.mTU = new ProgressDialog(this.mYg);
                this.mTU.setProgressStyle(0);
                this.mTU.requestWindowFeature(1);
                this.mTU.setMessage(this.mYg.getText(a.i.update_userinfo_ing));
                this.mTU.setCancelable(true);
            }
            if (!this.mTU.isShowing()) {
                this.mTU.show();
            }
        } else if (this.mTU != null && this.mTU.isShowing()) {
            this.mTU.dismiss();
        }
    }

    private void dCX() {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
            if (this.mTW == null) {
                this.mTW = new f(getActivity());
            }
            this.mTW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mTW = null;
                }
            });
            RoomInfo roomInfo = this.mYf.dCE().mRoominfo;
            this.mTW.a();
            this.mTW.a(roomInfo);
            if (!this.mTW.isShowing()) {
                this.mTW.show();
            }
        }
    }

    private void dCZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mUn != null && this.mYi != null && this.mYg != null && (this.mYg instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mUn;
            VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
            verticalSeekBarVolumn.setProgressOnly(MQ(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mRs != null) {
            this.mRs.dQw();
        }
        if (this.mXQ != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mTY == null) {
                this.mTY = new com.kascend.chushou.player.ui.giftpopup.a(this.mXQ, i);
            } else if (this.mTY.a() != i) {
                this.mTY.b();
                this.mTY = null;
                this.mTY = new com.kascend.chushou.player.ui.giftpopup.a(this.mXQ, i);
            }
            List<ListItem> j = this.mYf != null ? this.mYf.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
            if (videoPlayer != null) {
                this.mTY.a(j, videoPlayer.dCk(), videoPlayer.dCl(), videoPlayer.dCm(), videoPlayer.dCn());
                this.mTY.a(this.e);
                if (this.mYf != null && this.mYf.mQY != null) {
                    this.mTY.a(this.mYf.mQY, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mYf != null) {
                                b.this.mYf.mQY = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mTY != null && this.mYf != null) {
                    this.mTY.b(this.mYf.mRa);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mTY != null && this.mYg != null) {
            this.mTY.a(((VideoPlayer) this.mYg).dCk());
            this.mTY.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYg instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dCk = ((VideoPlayer) this.mYg).dCk();
            if (this.mYW == null) {
                this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYW.setVisibility(0);
            this.mYW.a(i, dCk);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mTY != null) {
            this.mTY.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mTI != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mTI.setVisibility(0);
                    this.mTI.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mTI.setVisibility(8);
                }
            }
            if (this.mTG != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mTH.setVisibility(0);
                    this.mTG.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mTH.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mTY != null) {
            this.mTY.a(((VideoPlayer) this.mYg).dCl());
            this.mTY.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mTY != null) {
            this.mTY.a(((VideoPlayer) this.mYg).dCl());
            this.mTY.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mTY != null) {
            this.mTY.a(((VideoPlayer) this.mYg).dCm());
            this.mTY.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mTY != null) {
            this.mTY.a(((VideoPlayer) this.mYg).dCn());
            this.mTY.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wn(false);
        super.F();
    }

    private void c(View view) {
        this.mUf = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mSr = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mSr.setText(new tv.chushou.zues.widget.a.c().O(this.mYg, a.e.videoplayer_4g_video).append("  ").append(this.mYg.getString(a.i.videoplayer_4g_video)));
        this.mUg = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mUg.setText(new tv.chushou.zues.widget.a.c().O(this.mYg, a.e.videoplayer_4g_audio).append("  ").append(this.mYg.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dCO();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mYg, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mUf.setVisibility(8);
                    ((VideoPlayer) b.this.mYg).b(b.this.mSt);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mUf.setVisibility(8);
                    ((VideoPlayer) b.this.mYg).c(b.this.mSt);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
        findViewById.setLayoutParams(layoutParams);
        this.mSr.setOnClickListener(onClickListener);
        this.mUg.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mYf != null && !tv.chushou.zues.utils.h.isEmpty(this.mYf.f)) {
            f(this.mYf.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mSt = z;
            this.p = false;
            if (this.mYf != null && this.mYf.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mYf.f.size()) {
                        break;
                    } else if (!"2".equals(this.mYf.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mUf != null) {
                this.mUf.setVisibility(0);
                this.mSr.setVisibility(0);
                this.mUg.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mUf != null) {
            this.mUf.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mTY != null && this.mYf != null) {
            this.mTY.b(this.mYf.mRa);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mXQ != null && (findViewById = this.mXQ.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mTG != null) {
            this.mTG.performClick();
        }
    }
}
