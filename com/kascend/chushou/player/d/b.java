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
    private TextView mSD;
    private boolean mSF;
    private LinearLayout mTO;
    private FrameLayout mTS;
    private FrescoThumbnailView mTT;
    private ImageView mTW;
    private ImageView mTY;
    private long mUA;
    public int mUc;
    RelativeLayout mUd;
    private ImageView mUe;
    private ImageView mUg;
    private f mUh;
    private com.kascend.chushou.player.ui.giftpopup.a mUj;
    private PopH5Menu mUm;
    private com.kascend.chushou.player.b.a mUn;
    private GiftAnimationLayout mUo;
    private ImageView mUp;
    private FoodView mUq;
    private RelativeLayout mUr;
    private TextView mUs;
    private VerticalSeekBarVolumn mUy;
    private Rect mTE = null;
    private Rect mTF = null;
    private float mTG = 0.0f;
    private Window mTH = null;
    private WindowManager.LayoutParams mTI = null;
    private boolean mTJ = false;
    private View mTK = null;
    private View mRT = null;
    private View mTL = null;
    private View mTM = null;
    private View mTN = null;
    private ImageView mRY = null;
    private ImageView mTP = null;
    private ImageButton mTQ = null;
    private FrescoThumbnailView mTR = null;
    private LinearLayout mTU = null;
    private EditText mTV = null;
    private View mTX = null;
    private boolean mTZ = false;
    private int bU = 0;
    private int mUa = 0;
    private long mUb = 0;
    private ProgressDialog mUf = null;
    private boolean mUi = true;
    private int mUl = -1;
    private boolean mUt = false;
    private TextView mUu = null;
    private TextView mUv = null;
    private int mUw = 0;
    private boolean mUx = false;
    private boolean mUz = false;
    private final Rect mUB = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUc = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mRD = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mYb = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.mUc;
        if (this.mYr != null && !((Activity) this.mYr).isFinishing()) {
            dDz();
        }
        return this.mYb;
    }

    public void dCN() {
        ax(false, false);
        super.p(true);
        com.kascend.chushou.toolkit.a.c.a(this.mYr, "能量_num", "横屏", new Object[0]);
    }

    public boolean dDb() {
        if (this.mZa == null || !this.mZa.isShown()) {
            return false;
        }
        this.mZa.d();
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
        if (z3 || this.mYb.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dBV().e;
        } else {
            z = h.dBV().b;
        }
        q(z);
        if (this.mYW != null) {
            this.mYW.b();
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
        if (this.mUj != null) {
            this.mUj.b();
            this.mUj = null;
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
            dCU();
            y();
            if (this.mRD != null) {
                this.mRD.onConfigurationChanged(configuration);
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
        if (this.mUm != null && this.mUl != i3) {
            this.mUm.a();
            this.mUm = null;
        }
        if (this.mUm == null) {
            this.mUm = (PopH5Menu) ((ViewStub) this.mYb.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUm.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mUm.setLayoutParams(layoutParams);
            this.mUl = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.mUm.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        int i = 1;
        if (!dDP()) {
            if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                if (this.mYr instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dCm = ((VideoPlayer) this.mYr).dCm();
                    if (this.mZh == null) {
                        this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mZh.setVisibility(0);
                    this.mZh.a(i, dCm);
                }
            } else if (bVar.a == 3) {
                if (this.mYr instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dCn = ((VideoPlayer) this.mYr).dCn();
                    if (this.mZh == null) {
                        this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.mZh.setVisibility(0);
                    this.mZh.a(i, dCn);
                }
            } else if (bVar.a == 9) {
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dCH;
        if (!dDP() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.mYq != null && mVar.b.equals(this.mYq.a) && (dCH = this.mYq.dCH()) != null) {
            dCH.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void dDz() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.bU = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
        this.mUa = tv.chushou.zues.utils.systemBar.b.hi(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.mUa);
        this.mUF = ((VideoPlayer) this.mYr).dCd();
        this.mYq = ((VideoPlayer) this.mYr).dCg();
        c(this.mYb);
        if (this.aw.equals("1")) {
            this.mRB = ((VideoPlayer) this.mYr).dCh();
            this.mRB.a(this);
            if (this.mUn != null) {
                this.mUn.a();
                this.mUn = null;
                this.mUo = null;
            }
            this.mUo = (GiftAnimationLayout) this.mYb.findViewById(a.f.ll_gift_animation);
            this.mUo.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.mYq != null) {
                this.mUn = new com.kascend.chushou.player.b.a(this.mYr.getApplicationContext(), this.mUo);
                this.mUn.a(this.mYq);
            }
            this.B = (TextView) this.mYb.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dCW();
        if (this.mRB != null) {
            this.mRB.d();
        }
        dDv();
        this.mTW = (ImageView) this.mYb.findViewById(a.f.btn_lockscreen);
        this.mTW.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.mYb.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.mYl = (PlayerErrorView) this.mYb.findViewById(a.f.view_net_error_msg);
        this.mYl.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        dCQ();
        cXN();
        this.mZa = (PaoGuideView) this.mYb.findViewById(a.f.rlPaoGuideView);
        this.mUp = (ImageView) this.mYb.findViewById(a.f.iv_send_danmu);
        this.mTN = this.mYb.findViewById(a.f.rt_layout);
        this.mTR = (FrescoThumbnailView) this.mTN.findViewById(a.f.btn_gift);
        this.mTS = (FrameLayout) this.mTN.findViewById(a.f.flfl_bottom_gift);
        this.mTT = (FrescoThumbnailView) this.mTN.findViewById(a.f.btn_recharge);
        this.mTT.setOnClickListener(this);
        a(this.mYq == null ? null : this.mYq.mRl);
        this.mZg = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.mTJ = false;
                b.this.wl(false);
                if (b.this.mYs != null) {
                    b.this.mYs.removeMessages(1);
                    b.this.mYs.K(1, 5000L);
                }
                b.this.mTW.setVisibility(0);
                b.this.mTN.setVisibility(0);
                b.this.mRT.setVisibility(0);
                b.this.mTK.setVisibility(0);
                if (b.this.mUj != null) {
                    b.this.mUj.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mYr, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.mTJ = true;
                b.this.wl(true);
                b.this.mTW.setVisibility(8);
                b.this.mTN.setVisibility(8);
                if (b.this.mUj != null) {
                    b.this.mUj.a(false);
                }
                b.this.mRT.setVisibility(8);
                b.this.mTK.setVisibility(8);
                if (b.this.mYs != null) {
                    b.this.mYs.removeMessages(1);
                }
                if (b.this.mYW != null) {
                    b.this.mYW.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.mYr, 14.0f) + b.this.mYW.getMeasuredHeight(), 12);
                }
            }
        };
        this.mTU = (LinearLayout) this.mYb.findViewById(a.f.rl_seekbar);
        this.mUd = (RelativeLayout) this.mYb.findViewById(a.f.rl_paoicon);
        this.mUd.setOnClickListener(this);
        this.mYX = (RoundProgressBar) this.mYb.findViewById(a.f.roundProgressBar);
        this.mYZ = (FrescoThumbnailView) this.mYb.findViewById(a.f.iv_paoicon);
        this.mYY = (TextView) this.mYb.findViewById(a.f.tv_paonum);
        this.aSz = 0;
        this.mZb = 0L;
        com.kascend.chushou.player.ui.a.a dCp = ((VideoPlayer) this.mYr).dCp();
        a(dCp.dDW());
        BangInfo dDX = dCp.dDX();
        if (dDX != null) {
            a(dDX, dCp.d());
        }
        if (this.aw.equals("3")) {
            this.mTU.setVisibility(0);
            this.mTS.setVisibility(8);
            this.mUp.setVisibility(0);
            this.mUp.setOnClickListener(this);
        } else {
            this.mUp.setVisibility(8);
            this.mTU.setVisibility(8);
            this.mTS.setVisibility(0);
            this.mTR.setOnClickListener(this);
        }
        dCR();
        if (tv.chushou.zues.utils.systemBar.b.hj(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTN.getLayoutParams();
            layoutParams.rightMargin += this.mUa;
            this.mTN.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRT.getLayoutParams();
            layoutParams2.rightMargin += this.mUa;
            this.mRT.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTM.getLayoutParams();
            layoutParams3.rightMargin += this.mUa;
            this.mTM.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTK.getLayoutParams();
            layoutParams4.rightMargin += this.mUa;
            this.mTK.setLayoutParams(layoutParams4);
        }
        dDB();
        dCO();
        dCU();
        this.h = (TextView) this.mYb.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mYb.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.mYq.dCF() != null) {
                this.mUg.setVisibility(0);
            } else {
                this.mUg.setVisibility(8);
            }
        }
        dDA();
        n();
        k(100);
        this.mUq = (FoodView) this.mYb.findViewById(a.f.kav_room_ad);
        this.mYs = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ax(false, true);
                            break;
                        case 2:
                            b.this.mYs.removeMessages(2);
                            if (b.this.mTW != null) {
                                b.this.mTW.setVisibility(8);
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
                            TextView textView = (TextView) b.this.mYb.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.mYr.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.mYs.K(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.mYs.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.mYs.K(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.aw(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.mYr).q) {
                                b.this.a(b.this.mYs);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.mYr).q) {
                                b.this.b(b.this.mYs);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.mYr).g = true;
                            b.this.mUF.seekTo((int) b.this.kWq);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.mYq.d()) {
                                b.this.mUF.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.mUF.getPlayState() == 4) {
                                int currentPos = b.this.mUF.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.mYs != null) {
                                    b.this.mYs.K(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.dDS();
                            break;
                        case 18:
                            b.this.cXM();
                            break;
                        case 19:
                            b.this.mYp.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.mYq != null) {
            a(this.mYq.dCG());
        }
        if (this.mUF != null && (this.mUF.getPlayState() == 3 || this.mUF.getPlayState() == 4)) {
            wn(false);
            if (this.mYq.d()) {
                this.ak = false;
                wo(true);
                if (this.mUF.getDuration() > 60000) {
                    if (this.mUF.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.mUF.getDuration(), 300000);
                    }
                } else {
                    this.at = this.mUF.getDuration();
                }
            }
            this.e = false;
            ax(true, false);
            this.mYs.Of(8);
            if (h() && this.mUF.getPlayState() == 4 && this.mYs != null) {
                this.mYs.removeMessages(15);
                this.mYs.Of(15);
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
            int[] dBU = g.dBU();
            int i = dBU.length == 2 ? dBU[1] : 0;
            if (i > 0) {
                View findViewById = this.mYb.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.mYb.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.mYr, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        dDR();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.mYr, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mYr != null && (this.mYr instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYr).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.mTT.xo(a.e.ic_recharge_old);
            this.mTR.xo(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.mUt && !this.k) {
            try {
                if (this.mUF != null) {
                    i = this.mUF.getCurrentPos();
                    i2 = this.mUF.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mRC.setProgress(i / (i2 / 1000));
                    this.mUu.setText(tv.chushou.zues.utils.b.s(this.mUF.getDuration(), false));
                    this.mUv.setText(tv.chushou.zues.utils.b.s(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void dDA() {
        this.mRC = (ProgressBar) this.mYb.findViewById(a.f.progressBarl);
        if (this.mRC != null) {
            if (this.mRC instanceof SeekBar) {
                ((SeekBar) this.mRC).setOnSeekBarChangeListener(new C0697b());
            }
            this.mRC.setMax(1000);
        }
        this.mUu = (TextView) this.mYb.findViewById(a.f.tv_time_duration);
        this.mUv = (TextView) this.mYb.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.mYb.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.mYb.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dCp;
        BangInfo dDX;
        if (config != null) {
            this.mZd = config;
            if (!config.display) {
                this.mUd.setVisibility(8);
            } else if ((this.mYr instanceof VideoPlayer) && (dDX = (dCp = ((VideoPlayer) this.mYr).dCp()).dDX()) != null) {
                a(dDX, dCp.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.mZd == null || this.mZd.display) && this.mUd != null) {
            this.mUd.setVisibility(0);
            this.mYY.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mYr instanceof VideoPlayer) {
            if ((this.mZd == null || this.mZd.display) && this.mUd != null) {
                if (j > 0) {
                    this.mUd.setVisibility(0);
                    boolean z = this.mZc;
                    this.mZc = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.mYr.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.mYY.setText(cVar);
                    return;
                }
                this.mZc = false;
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
                if (b.this.mUw != i || b.this.mUx != z) {
                    b.this.mUw = i;
                    b.this.mUx = z;
                    if (z) {
                        if (b.this.mUt) {
                            b.this.kWq = (b.this.mUF.getDuration() / 1000) * i;
                        }
                        b.this.mUv.setText(tv.chushou.zues.utils.b.s((int) b.this.kWq, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.s((int) b.this.kWq, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.s(((int) b.this.kWq) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.mUt = true;
            b.this.m = b.this.mUF.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.mYs != null) {
                if (b.this.mUt) {
                    b.this.mUt = false;
                }
                b.this.mYs.removeMessages(14);
                b.this.mYs.Of(14);
            }
        }
    }

    private void k(int i) {
        this.mRC.setSecondaryProgress((i * 1000) / 100);
    }

    private void dDv() {
        this.mUy = (VerticalSeekBarVolumn) this.mYb.findViewById(a.f.volumn_seekbar);
        this.mUy.setOnSeekBarChangeListener(new c());
        int streamVolume = this.mYt.getStreamVolume(3);
        this.mUy.setProgress(MQ(streamVolume));
        wk(MQ(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.mYb.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.mRz = new d.a();
            this.c = new GestureDetector(this.mYr, this.mRz);
        }
    }

    private void dDB() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mTH == null) {
                this.mTH = ((Activity) this.mYr).getWindow();
            }
            this.mTI = this.mTH.getAttributes();
            this.mTG = ((VideoPlayer) this.mYr).k / 255.0f;
            ((VerticalSeekBarVolumn) this.mYb.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.mTG));
        }
    }

    private void dCO() {
        this.mYb.findViewById(a.f.btn_send).setOnClickListener(this);
        this.mYb.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.mYr.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.mYb.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.mTV == null) {
            this.mTV = (EditText) this.mYb.findViewById(a.f.et_input);
            this.mTV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.mYb.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCP() {
        if (this.mUh != null) {
            this.mUh.dismiss();
            this.mUh = null;
        }
        if (this.mYr != null) {
            ((VideoPlayer) this.mYr).a(1, null, this.H, false);
        }
    }

    private void dCQ() {
        this.mRT = this.mYb.findViewById(a.f.topview);
        this.mTO = (LinearLayout) this.mYb.findViewById(a.f.topRight);
        this.mTL = this.mRT.findViewById(a.f.rl_download);
        this.mTM = this.mYb.findViewById(a.f.topKeyboardView);
        this.mYb.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.mRT.getVisibility() == 0;
        if (this.bU > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRT.getLayoutParams();
            layoutParams.topMargin = this.bU;
            this.mRT.setLayoutParams(layoutParams);
        }
        this.mYb.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.mYb.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                str = this.mYq.dCF().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.mYb.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.mUe = (ImageView) this.mYb.findViewById(a.f.subscribe_icon);
        this.mUe.setOnClickListener(this);
        this.mUg = (ImageView) this.mYb.findViewById(a.f.report_icon);
        this.mUg.setOnClickListener(this);
        q();
    }

    private void dCR() {
        boolean z;
        this.mTK = this.mYb.findViewById(a.f.bottomview);
        this.mTQ = (ImageButton) this.mTK.findViewById(a.f.playbutton);
        this.mTQ.setOnTouchListener(this);
        this.mYi = (ImageButton) this.mYb.findViewById(a.f.btn_barrage);
        this.mYj = (ImageButton) this.mYb.findViewById(a.f.btn_audio);
        this.mTY = (ImageView) this.mYb.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.mTK.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.mTK.findViewById(a.f.btn_refresh).setVisibility(0);
            this.mYi.setVisibility(0);
            this.mTY.setVisibility(8);
            if (this.mYq != null && this.mYq.f != null) {
                for (int i = 0; i < this.mYq.f.size(); i++) {
                    if ("2".equals(this.mYq.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.mYj.setVisibility(0);
            } else {
                this.mYj.setVisibility(8);
            }
            this.mTK.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.mYi.setOnClickListener(this);
            if (h.dBV().e) {
                this.mYi.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mYi.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.mYq.d) {
                this.mYj.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.mYj.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.mYj.setOnClickListener(this);
            this.mRY = (ImageView) this.mTK.findViewById(a.f.btn_hotword);
            this.mTP = (ImageView) this.mYb.findViewById(a.f.iv_task_badge);
            this.mRY.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.mYr, a.C0690a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dBV().c) {
                        b.this.mRY.clearAnimation();
                        b.this.mRY.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRY.clearAnimation();
            if (h.dBV().c) {
                this.mRY.startAnimation(animationSet);
                this.mTP.setVisibility(0);
            }
        } else {
            this.mTK.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.mTK.findViewById(a.f.btn_refresh).setVisibility(8);
            this.mYi.setVisibility(8);
            this.mYj.setVisibility(8);
            this.mTY.setVisibility(0);
            this.mTY.setOnClickListener(this);
            if (h.dBV().b) {
                this.mTY.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTY.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.mTK.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.mYr != null) {
            ((VideoPlayer) this.mYr).d(true);
        }
        if (this.mYs != null) {
            this.mYs.cq(null);
            this.mYs = null;
        }
        this.c = null;
        this.mRz = null;
        this.mTW = null;
        if (this.mTV != null) {
            this.mTV.addTextChangedListener(null);
            this.mTV.setOnEditorActionListener(null);
            this.mTV = null;
        }
        this.mRT = null;
        this.mYi = null;
        this.mYj = null;
        this.mTK = null;
        this.mTN = null;
        if (this.mUn != null) {
            this.mUn.a();
            this.mUn = null;
            this.mUo = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDp() {
        return this.mUn;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.mYb == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.mZh == null || !this.mZh.a(i, keyEvent)) {
                    if ((this.mUm == null || !this.mUm.onKeyDown(i, keyEvent)) && !dDb() && !dDc()) {
                        if (this.mTM != null && this.mTM.getVisibility() == 0) {
                            aw(false, true);
                            return true;
                        } else if (this.mTX != null && this.mTX.isShown()) {
                            dDD();
                            return true;
                        } else if (this.mTZ && this.mYs != null) {
                            if (this.mTW != null) {
                                this.mTW.setVisibility(0);
                            }
                            this.mYs.removeMessages(2);
                            this.mYs.K(2, 3000L);
                            return true;
                        } else {
                            dCP();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                u(false);
                int progress = ((VerticalSeekBarVolumn) this.mYb.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.mYb.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.mYs != null) {
                    this.mYs.removeMessages(3);
                    this.mYs.K(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dDC() {
        if (this.mTZ) {
            this.mTW.setVisibility(0);
            this.mYs.removeMessages(2);
            this.mYs.K(2, 3000L);
        }
        return this.mTZ;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.mTZ) {
            if (view.getId() == a.f.btn_lockscreen) {
                dCT();
                return;
            }
            this.mTW.setVisibility(0);
            this.mYs.removeMessages(2);
            this.mYs.K(2, 3000L);
            tv.chushou.zues.utils.g.c(this.mYr, getString(a.i.STR_VP_SCREEN_LOCK));
            return;
        }
        int id = view.getId();
        if (id == a.f.btn_setting) {
            int i = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i == 2) {
                if (tv.chushou.zues.utils.systemBar.b.aF(getActivity()) && tv.chushou.zues.utils.systemBar.b.aG(getActivity())) {
                    m(view, tv.chushou.zues.utils.systemBar.b.hi(getActivity()), 0);
                    return;
                } else {
                    m(view, 0, 0);
                    return;
                }
            }
            m(view, 0, this.mRT.getHeight() + this.mRT.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.mTV.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.M(this.mYr, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.mTV.setText((CharSequence) null);
                aw(false, true);
            } else if (a(this.mTV.getText().toString(), false)) {
                aw(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dCT();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                n(view, tv.chushou.zues.utils.systemBar.b.hi(getActivity()), 0);
            } else {
                n(view, 0, tv.chushou.zues.utils.a.dip2px(this.mYr, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            n(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dCP();
            com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = ou() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.mYW == null;
                b(false, false);
                if (z && this.mUa > 0 && this.mYW != null && tv.chushou.zues.utils.systemBar.b.aF(getActivity()) && tv.chushou.zues.utils.systemBar.b.aG(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYW.getLayoutParams();
                    layoutParams.rightMargin += this.mUa;
                    this.mYW.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.mYW == null;
                if (this.mYr.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.mUa > 0 && this.mYW != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mYW.getLayoutParams();
                    layoutParams2.bottomMargin += this.mUa;
                    this.mYW.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYq.dCF().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            aw(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ax(false, false);
            this.mYs.K(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dBV().c) {
                h.dBV().b(false);
                this.mRY.clearAnimation();
                this.mTP.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                k(view, this.mTK.findViewById(a.f.ll_keyboard).getLeft(), this.mTK.getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
            } else {
                k(view, this.mTK.findViewById(a.f.ll_keyboard).getLeft(), this.mTK.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                tv.chushou.zues.utils.g.c(this.mYr, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.e(this.mYr, ou(), false);
        } else if (id == a.f.btn_screenChange) {
            dCP();
        } else if (id == a.f.rl_paoicon) {
            dCN();
        } else if (id == a.f.subscribe_icon) {
            dCX();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dDa();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dCY();
            }
        } else if (id == a.f.btn_audio && !this.mYq.d) {
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
        } else if (System.currentTimeMillis() - this.mUb <= 3000) {
            tv.chushou.zues.utils.g.Om(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dBV().e) {
                r(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
            if (com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYr).dCg().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.mUb = System.currentTimeMillis();
                a(this.mYq.dCF().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYq.h);
                if (!z) {
                    this.mTV.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void q(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.mYi != null) {
                if (z) {
                    this.mYi.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.mYi.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.mTY != null) {
            if (z) {
                this.mTY.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.mTY.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dCZ() {
        if (this.mYb == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mYb.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        q(z);
        if (this.mZe != null) {
            this.mZe.setVisibility(z ? 0 : 8);
            if (!z) {
                this.mZe.dPF();
            }
        }
        tv.chushou.zues.utils.g.u(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dCT() {
        if (this.mYq.d()) {
            if (this.mTZ) {
                this.mTW.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.mYr, this.mYr.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.mTW.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.mYr, this.mYr.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.mTZ = !this.mTZ;
            if (this.mTV != null) {
                this.mTV.setEnabled(this.mTZ ? false : true);
            }
        }
    }

    public void aw(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mTV);
            this.mTV.setText("");
            this.mTN.setVisibility(8);
            this.mTW.setVisibility(8);
            this.mRT.setVisibility(8);
            this.mTK.setVisibility(8);
            this.mTM.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
        if (this.mTM.getVisibility() != 8 && z2) {
            this.mTM.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_top_anim));
        }
        this.mTN.setVisibility(8);
        this.mTW.setVisibility(8);
        this.mRT.setVisibility(8);
        this.mTK.setVisibility(8);
        this.mTM.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ax(false, false);
        super.c(str, str2);
    }

    private void t(boolean z) {
        if (this.mTO != null) {
            this.mTO.setVisibility(z ? 0 : 4);
        }
    }

    public boolean ax(boolean z, boolean z2) {
        return k(z, z2, false);
    }

    public boolean k(boolean z, boolean z2, boolean z3) {
        if (dDP()) {
            return this.e;
        }
        e.d("VideoPlayerFullScreenFragment", "controlBarVisible:" + z + " misCtrlBarShowing = " + this.e);
        if (this.e == z) {
            if (this.mUj != null) {
                this.mUj.a(this.e);
            }
            return this.e;
        }
        if (this.mYs != null) {
            this.mYs.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.mYr).d(true);
            if (!z3) {
                if (this.mTK.getVisibility() != 0 && z2) {
                    this.mTK.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_bottom_anim));
                }
                this.mTK.setVisibility(0);
                this.mTN.setVisibility(0);
                this.mTW.setVisibility(0);
                this.mTL.setVisibility(o() ? 0 : 8);
            }
            if (this.mRT.getVisibility() != 0 && z2) {
                this.mRT.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_top_anim));
            }
            t(!z3);
            this.mRT.setVisibility(0);
            if (this.mYs != null) {
                this.mYs.K(1, 5000L);
            }
            wl(false);
            if (this.mUj != null) {
                this.mUj.a(true);
            }
        } else {
            ((VideoPlayer) this.mYr).d(false);
            if (this.mYI != null) {
                this.mYI.dismiss();
            }
            if (this.mYJ != null) {
                this.mYJ.dismiss();
            }
            if (this.mYQ != null) {
                this.mYQ.dismiss();
            }
            if (this.mTK != null) {
                if (this.mTK.getVisibility() != 8 && z2) {
                    this.mTK.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_bottom_anim));
                }
                this.mTK.setVisibility(8);
            }
            if (this.mTN != null) {
                this.mTN.setVisibility(8);
                if (this.mRT.getVisibility() != 8 && z2) {
                    this.mRT.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_top_anim));
                }
                this.mRT.setVisibility(8);
                this.mTW.setVisibility(8);
                wl(true);
                a(false);
                if (this.mUj != null) {
                    this.mUj.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dCU() {
        Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
        if (this.ap == 1) {
            this.ar = Math.min(hd.x, hd.y);
            this.mYv = Math.max(hd.x, hd.y);
        } else {
            this.ar = Math.max(hd.x, hd.y);
            this.mYv = Math.min(hd.x, hd.y);
        }
        int i = this.ar;
        int i2 = this.mYv;
        if (this.mTE == null) {
            this.mTE = new Rect(0, 0, i / 5, i2);
        } else {
            this.mTE.set(0, 0, i / 5, i2);
        }
        if (this.mTF == null) {
            this.mTF = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.mTF.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.mTE == null) {
            return false;
        }
        return this.mTE.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        View findViewById = this.mYb.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mYb.findViewById(a.f.brightness_view);
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
        if (this.mTF == null) {
            return false;
        }
        return this.mTF.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.mYb.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.mYb.findViewById(a.f.volumn_view);
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
                if (this.mTZ) {
                    this.mTW.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.mTZ) {
                    this.mYs.removeMessages(2);
                    this.mYs.K(2, 3000L);
                    return true;
                } else if (this.mYs != null) {
                    this.mYs.K(3, 1000L);
                    this.mYs.K(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.mTZ) {
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
        int streamMaxVolume = (this.mYt.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int MQ(int i) {
        int streamMaxVolume = (i * 10) / this.mYt.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wk(boolean z) {
        if (z) {
            this.mYb.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.mYb.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
        }
    }

    @Override // com.kascend.chushou.widget.a.b.a
    public void b(ParserRet parserRet) {
        if (!dDP() && parserRet != null) {
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
                                    if (this.mYr != null && (this.mYr instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.mYr).a(1, null, this.H, false, false, true);
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
            b.this.mYt.setStreamVolume(3, b.this.MP(i), 0);
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
            b.this.mTG = i / 10.0f;
            ((VideoPlayer) b.this.mYr).l = b.this.mTG;
            ((VideoPlayer) b.this.mYr).k = b.this.mTG * 255.0f;
            b.this.mTI.screenBrightness = b.this.mTG;
            b.this.mTH.setAttributes(b.this.mTI);
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
        if (motionEvent != null && motionEvent2 != null && motionEvent.getRawY() <= this.mYv && motionEvent2.getRawY() <= this.mYv) {
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
                        aVar.e = ((VerticalSeekBarVolumn) this.mYb.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        v(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.mYb.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.mRC.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.mYb.findViewById(a.f.volumn_seekbar);
                    u(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.mYb.findViewById(a.f.brightness_seekbar);
                        v(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.mUF.getCurrentPos();
                            int duration = this.mUF.getDuration();
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
                                this.mRC.setProgress(i3 / (duration / 1000));
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
        if (!this.mTJ) {
            if (this.mTM.getVisibility() == 8 && (this.mTX == null || !this.mTX.isShown())) {
                boolean z = this.mYl != null && this.mYl.getVisibility() == 0;
                if (this.e) {
                    ax(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                aw(false, true);
                dDD();
            }
        }
        return false;
    }

    public boolean dDc() {
        if (this.mTJ) {
            if (this.mYW != null) {
                this.mYW.e();
            }
            wl(false);
            if (this.mTK != null) {
                this.mTK.setVisibility(0);
            }
            if (this.mRT != null) {
                this.mRT.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ox() {
        super.ox();
        if (this.mYr instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.mYq != null) {
            this.mYq.f = null;
            if (this.mYq.dCF() != null) {
                this.mYq.dCF().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.mUF != null) {
                this.mUF.seekTo(0L);
                e(true);
            }
            dCP();
            return;
        }
        dCP();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mTZ) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                tv.chushou.zues.utils.g.c(this.mYr, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.mUF.getPlayState() == 4) {
                        dCV();
                        e(true);
                    } else {
                        if (this.mUq != null) {
                            this.mUq.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.mYq.a(false);
                            ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
                        } else if (this.mUF.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mUF.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.mUF.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wo(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.mUF.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.mUF.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                tv.chushou.zues.utils.g.c(this.mYr, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.mYq.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
                    this.ai = false;
                    wo(true);
                    a(false, !this.ak);
                } else if (this.mUF.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
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

    private void dCV() {
        String str = null;
        if (!this.aw.equals("3")) {
            if (this.mYq != null && this.mYq.dCH() != null) {
                str = this.mYq.dCH().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dBP().z != null && com.kascend.chushou.a.a.dBP().z.contains(str) && this.mYq != null && !this.mUz) {
            this.mUz = true;
            com.kascend.chushou.a.a.dBP().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.mUz = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.mUq != null) {
            this.mUq.a(listItem, this.ap == 1, a.C0690a.zues_sweetalert_modal_in, a.C0690a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.mUz = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.mTQ != null) {
                this.mTQ.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.mYl != null) {
                this.mYl.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mTQ != null) {
            this.mTQ.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.mYl != null) {
                    this.mYl.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dCW() {
        this.N = new SurfaceView(this.mYr);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.mYb).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.mZe != null) {
            this.mZe.dPF();
            this.mZe.setVisibility(8);
            this.mZe.unInit();
            ((RelativeLayout) this.mYb).removeView(this.mZe);
            this.mZe = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.mYb).removeView(this.N);
            this.N = null;
        }
        dCW();
        ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
    }

    private void k(View view, int i, int i2) {
        if (this.mYs != null) {
            wl(true);
            this.mYs.removeMessages(1);
            this.mTK.setVisibility(0);
            this.mTN.setVisibility(8);
            this.mRT.setVisibility(8);
            this.mTW.setVisibility(8);
        }
        if (this.mYQ == null) {
            al();
            this.mYQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.mRY.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.mYQ.isShowing()) {
            this.mYQ.showAtLocation(view, 83, i, i2);
            this.mRY.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYq.dCF().mRoominfo.mRoomID);
            return;
        }
        this.mYQ.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mUm != null && this.mUm.b()) {
                this.mUm.getGlobalVisibleRect(this.mUB);
                if (!this.mUB.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.mUm.a();
                    return true;
                }
            }
            if (this.mTJ && g(this.mYW.b, motionEvent)) {
                dDc();
                return true;
            }
            if (!dDC()) {
                if (System.currentTimeMillis() - this.mUA < 300 && this.mUq != null && this.mUq.isShown()) {
                    this.mUq.a();
                    if (this.mUF.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.mYq.a(false);
                            ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
                        } else if (this.mUF.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.mYr).a(false, (Uri) null, false);
                        } else {
                            m(true);
                        }
                    }
                    if (this.mUF.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.mUF.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            wo(true);
                        }
                    }
                    return true;
                }
                this.mUA = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dDD() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
        if (this.mTX != null) {
            if (this.mTX.isShown()) {
                this.mTX.startAnimation(AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_top_anim));
            }
            this.mTX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.mYr).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.mYr).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.mYj != null) {
                this.mYj.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.hj(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTN.getLayoutParams();
                layoutParams.rightMargin -= this.mUa;
                this.mTN.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRT.getLayoutParams();
                layoutParams2.rightMargin -= this.mUa;
                this.mRT.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTM.getLayoutParams();
                layoutParams3.rightMargin -= this.mUa;
                this.mTM.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mTK.getLayoutParams();
                layoutParams4.rightMargin -= this.mUa;
                layoutParams4.bottomMargin += this.mUa;
                this.mTK.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
            this.mUe.setVisibility(0);
            if (this.mYq.dCF().mRoominfo.mIsSubscribed) {
                this.mUe.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.mUe.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.mUe.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dCX() {
        RoomInfo roomInfo;
        if (this.mYq != null && this.mYq.dCF() != null && (roomInfo = this.mYq.dCF().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.mYr, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dQV();
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
        if (this.mYq != null && this.mYq.dCF() != null && (roomInfo = this.mYq.dCF().mRoominfo) != null) {
            com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.b.4
                @Override // com.kascend.chushou.c.b
                public void a() {
                    if (!b.this.dDP()) {
                        b.this.s(true);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    RoomInfo roomInfo2;
                    if (!b.this.dDP()) {
                        b.this.s(false);
                        if (jSONObject == null) {
                            a(-1, (String) null);
                            return;
                        }
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message", "");
                        if (optInt == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.M(b.this.mYr, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.M(b.this.mYr, a.i.subscribe_success);
                            }
                            if (b.this.mYq != null && b.this.mYq.dCF() != null && (roomInfo2 = b.this.mYq.dCF().mRoominfo) != null) {
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
                    if (!b.this.dDP()) {
                        b.this.s(false);
                        if (i == 401) {
                            com.kascend.chushou.d.e.b(b.this.mYr, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.mYr, str2);
                    }
                }
            };
            if (this.mYq != null && this.mYq.h != null) {
                try {
                    str = new JSONObject(this.mYq.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dBR().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dBR().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.mUf == null) {
                this.mUf = new ProgressDialog(this.mYr);
                this.mUf.setProgressStyle(0);
                this.mUf.requestWindowFeature(1);
                this.mUf.setMessage(this.mYr.getText(a.i.update_userinfo_ing));
                this.mUf.setCancelable(true);
            }
            if (!this.mUf.isShowing()) {
                this.mUf.show();
            }
        } else if (this.mUf != null && this.mUf.isShowing()) {
            this.mUf.dismiss();
        }
    }

    private void dCY() {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
            if (this.mUh == null) {
                this.mUh = new f(getActivity());
            }
            this.mUh.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.mUh = null;
                }
            });
            RoomInfo roomInfo = this.mYq.dCF().mRoominfo;
            this.mUh.a();
            this.mUh.a(roomInfo);
            if (!this.mUh.isShowing()) {
                this.mUh.show();
            }
        }
    }

    private void dDa() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.mUy != null && this.mYt != null && this.mYr != null && (this.mYr instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.mUy;
            VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
            verticalSeekBarVolumn.setProgressOnly(MQ(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.mRD != null) {
            this.mRD.dQx();
        }
        if (this.mYb != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.mUj == null) {
                this.mUj = new com.kascend.chushou.player.ui.giftpopup.a(this.mYb, i);
            } else if (this.mUj.a() != i) {
                this.mUj.b();
                this.mUj = null;
                this.mUj = new com.kascend.chushou.player.ui.giftpopup.a(this.mYb, i);
            }
            List<ListItem> j = this.mYq != null ? this.mYq.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
            if (videoPlayer != null) {
                this.mUj.a(j, videoPlayer.dCl(), videoPlayer.dCm(), videoPlayer.dCn(), videoPlayer.dCo());
                this.mUj.a(this.e);
                if (this.mYq != null && this.mYq.mRk != null) {
                    this.mUj.a(this.mYq.mRk, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.mYq != null) {
                                b.this.mYq.mRk = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.mUj != null && this.mYq != null) {
                    this.mUj.b(this.mYq.mRm);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mUj != null && this.mYr != null) {
            this.mUj.a(((VideoPlayer) this.mYr).dCl());
            this.mUj.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYr instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dCl = ((VideoPlayer) this.mYr).dCl();
            if (this.mZh == null) {
                this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mZh.setVisibility(0);
            this.mZh.a(i, dCl);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.mUj != null) {
            this.mUj.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.mTT != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.mTT.setVisibility(0);
                    this.mTT.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.mTT.setVisibility(8);
                }
            }
            if (this.mTR != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.mTS.setVisibility(0);
                    this.mTR.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.mTS.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mUj != null) {
            this.mUj.a(((VideoPlayer) this.mYr).dCm());
            this.mUj.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mUj != null) {
            this.mUj.a(((VideoPlayer) this.mYr).dCm());
            this.mUj.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mUj != null) {
            this.mUj.a(((VideoPlayer) this.mYr).dCn());
            this.mUj.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mUj != null) {
            this.mUj.a(((VideoPlayer) this.mYr).dCo());
            this.mUj.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wn(false);
        super.F();
    }

    private void c(View view) {
        this.mUr = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.mSD = (TextView) view.findViewById(a.f.tv_4g_video);
        this.mSD.setText(new tv.chushou.zues.widget.a.c().O(this.mYr, a.e.videoplayer_4g_video).append("  ").append(this.mYr.getString(a.i.videoplayer_4g_video)));
        this.mUs = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.mUs.setText(new tv.chushou.zues.widget.a.c().O(this.mYr, a.e.videoplayer_4g_audio).append("  ").append(this.mYr.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dCP();
                    com.kascend.chushou.toolkit.a.c.a(b.this.mYr, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.mUr.setVisibility(8);
                    ((VideoPlayer) b.this.mYr).b(b.this.mSF);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.mUr.setVisibility(8);
                    ((VideoPlayer) b.this.mYr).c(b.this.mSF);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
        findViewById.setLayoutParams(layoutParams);
        this.mSD.setOnClickListener(onClickListener);
        this.mUs.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.mYq != null && !tv.chushou.zues.utils.h.isEmpty(this.mYq.f)) {
            f(this.mYq.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.mSF = z;
            this.p = false;
            if (this.mYq != null && this.mYq.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mYq.f.size()) {
                        break;
                    } else if (!"2".equals(this.mYq.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.mUr != null) {
                this.mUr.setVisibility(0);
                this.mSD.setVisibility(0);
                this.mUs.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.mUr != null) {
            this.mUr.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mUj != null && this.mYq != null) {
            this.mUj.b(this.mYq.mRm);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.mYb != null && (findViewById = this.mYb.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mTR != null) {
            this.mTR.performClick();
        }
    }
}
