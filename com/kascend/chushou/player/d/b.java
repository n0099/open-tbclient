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
    private TextView nik;
    private boolean nim;
    private ImageView njA;
    RelativeLayout njE;
    private ImageView njF;
    private ImageView njH;
    private f njI;
    private com.kascend.chushou.player.ui.giftpopup.a njJ;
    private PopH5Menu njL;
    private com.kascend.chushou.player.b.a njM;
    private GiftAnimationLayout njN;
    private ImageView njO;
    private FoodView njP;
    private RelativeLayout njQ;
    private TextView njR;
    private VerticalSeekBarVolumn njX;
    private long njZ;
    private LinearLayout njq;
    private FrameLayout nju;
    private FrescoThumbnailView njv;
    private ImageView njy;
    private Rect njg = null;
    private Rect njh = null;
    private float nji = 0.0f;
    private Window njj = null;
    private WindowManager.LayoutParams njk = null;
    private boolean njl = false;
    private View njm = null;
    private View nhB = null;
    private View njn = null;
    private View njo = null;
    private View njp = null;
    private ImageView nhG = null;
    private ImageView njr = null;
    private ImageButton njs = null;
    private FrescoThumbnailView njt = null;
    private LinearLayout njw = null;
    private EditText njx = null;
    private View njz = null;
    private boolean njB = false;
    private int njC = 0;
    private int bV = 0;
    private long njD = 0;
    private ProgressDialog njG = null;
    private boolean bBj = true;
    private int njK = -1;
    private boolean njS = false;
    private TextView njT = null;
    private TextView njU = null;
    private int njV = 0;
    private boolean njW = false;
    private boolean njY = false;
    private final Rect nka = new Rect();

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bu = getArguments().getInt("mExtraOrientation");
        this.aw = getArguments().getString("mViewType");
        if (Build.VERSION.SDK_INT >= 19) {
            this.nhj = new tv.chushou.zues.utils.systemBar.a(getActivity());
        }
        tv.chushou.zues.a.a.register(this);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.nnt = layoutInflater.inflate(a.h.videoplayer_root_view_l, viewGroup, false);
        this.ap = this.bu;
        if (this.nnJ != null && !((Activity) this.nnJ).isFinishing()) {
            aC();
        }
        return this.nnt;
    }

    public void dJP() {
        ay(false, false);
        super.q(true);
        com.kascend.chushou.toolkit.a.c.a(this.nnJ, "能量_num", "横屏", new Object[0]);
    }

    public boolean az() {
        if (this.nor == null || !this.nor.isShown()) {
            return false;
        }
        this.nor.d();
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
        if (z3 || this.nnt.findViewById(a.f.loadingview).getVisibility() == 0) {
            z2 = false;
        }
        a(z3, z2);
        if ("1".equals(this.aw)) {
            z = h.dIT().e;
        } else {
            z = h.dIT().b;
        }
        r(z);
        if (this.non != null) {
            this.non.b();
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
        if (this.njJ != null) {
            this.njJ.b();
            this.njJ = null;
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
            dJW();
            y();
            if (this.nhj != null) {
                this.nhj.onConfigurationChanged(configuration);
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
        if (this.njL != null && this.njK != i3) {
            this.njL.a();
            this.njL = null;
        }
        if (this.njL == null) {
            this.njL = (PopH5Menu) ((ViewStub) this.nnt.findViewById(this.ap == 0 ? a.f.viewstub_activity_h5_landscape : a.f.viewstub_activity_h5_portrait)).inflate();
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
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njL.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.njL.setLayoutParams(layoutParams);
            this.njK = this.ap;
        }
        if (this.ap == 0) {
            loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_right_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_right_anim);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_bottom_anim);
            loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_bottom_anim);
        }
        H5Options h5Options = new H5Options();
        h5Options.b = true;
        h5Options.d = true;
        h5Options.e = true;
        h5Options.a = listItem.mUrl;
        h5Options.h = -1;
        this.njL.a(getChildFragmentManager(), h5Options, loadAnimation, loadAnimation2);
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
                if (this.nnJ instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.b.b dJm = ((VideoPlayer) this.nnJ).dJm();
                    if (this.noA == null) {
                        this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.noA.setVisibility(0);
                    this.noA.a(i, dJm);
                }
            } else if (bVar.a == 3) {
                if (this.nnJ instanceof VideoPlayer) {
                    if (this.ap == 6 || this.ap == 1) {
                        i = 2;
                    }
                    com.kascend.chushou.player.ui.h5.d.a dJn = ((VideoPlayer) this.nnJ).dJn();
                    if (this.noA == null) {
                        this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                    }
                    this.noA.setVisibility(0);
                    this.noA.a(i, dJn);
                }
            } else if (bVar.a == 9) {
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(1, bVar.b);
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        RoomInfo dJI;
        if (!aa() && !tv.chushou.zues.utils.h.isEmpty(mVar.b) && this.nnI != null && mVar.b.equals(this.nnI.a) && (dJI = this.nnI.dJI()) != null) {
            dJI.mIsSubscribed = mVar.c;
            q();
        }
    }

    private void aC() {
        b();
        if (tv.chushou.zues.utils.h.isEmpty(this.aw)) {
            this.aw = "1";
        }
        this.njC = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
        this.bV = tv.chushou.zues.utils.systemBar.b.gC(getActivity());
        e.d("VideoPlayerFullScreenFragment", "navbarheight=" + this.bV);
        this.nke = ((VideoPlayer) this.nnJ).dJc();
        this.nnI = ((VideoPlayer) this.nnJ).dJf();
        c(this.nnt);
        if (this.aw.equals("1")) {
            this.nhh = ((VideoPlayer) this.nnJ).dJg();
            this.nhh.a(this);
            if (this.njM != null) {
                this.njM.a();
                this.njM = null;
                this.njN = null;
            }
            this.njN = (GiftAnimationLayout) this.nnt.findViewById(a.f.ll_gift_animation);
            this.njN.setLayoutDefaultBg(a.e.bg_gift_animation_h);
            if (this.nnI != null) {
                this.njM = new com.kascend.chushou.player.b.a(this.nnJ.getApplicationContext(), this.njN);
                this.njM.a(this.nnI);
            }
            this.B = (TextView) this.nnt.findViewById(a.f.iv_cyclelive_countdown);
        } else if (this.aw.equals("3")) {
        }
        dJX();
        if (this.nhh != null) {
            this.nhh.d();
        }
        dKp();
        this.njy = (ImageView) this.nnt.findViewById(a.f.btn_lockscreen);
        this.njy.setOnClickListener(this);
        if (this.a == null) {
            this.a = (ImageButton) this.nnt.findViewById(a.f.resumebutton);
            this.a.setOnTouchListener(this);
        }
        this.nnD = (PlayerErrorView) this.nnt.findViewById(a.f.view_net_error_msg);
        this.nnD.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        aI();
        ar();
        this.nor = (PaoGuideView) this.nnt.findViewById(a.f.rlPaoGuideView);
        this.njO = (ImageView) this.nnt.findViewById(a.f.iv_send_danmu);
        this.njp = this.nnt.findViewById(a.f.rt_layout);
        this.njt = (FrescoThumbnailView) this.njp.findViewById(a.f.btn_gift);
        this.nju = (FrameLayout) this.njp.findViewById(a.f.flfl_bottom_gift);
        this.njv = (FrescoThumbnailView) this.njp.findViewById(a.f.btn_recharge);
        this.njv.setOnClickListener(this);
        a(this.nnI == null ? null : this.nnI.ngR);
        this.noz = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.d.b.1
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                b.this.njl = false;
                b.this.y(false);
                if (b.this.nnK != null) {
                    b.this.nnK.removeMessages(1);
                    b.this.nnK.B(1, 5000L);
                }
                b.this.njy.setVisibility(0);
                b.this.njp.setVisibility(0);
                b.this.nhB.setVisibility(0);
                b.this.njm.setVisibility(0);
                if (b.this.njJ != null) {
                    b.this.njJ.a(true);
                }
                b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nnJ, 58.0f), 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                b.this.njl = true;
                b.this.y(true);
                b.this.njy.setVisibility(8);
                b.this.njp.setVisibility(8);
                if (b.this.njJ != null) {
                    b.this.njJ.a(false);
                }
                b.this.nhB.setVisibility(8);
                b.this.njm.setVisibility(8);
                if (b.this.nnK != null) {
                    b.this.nnK.removeMessages(1);
                }
                if (b.this.non != null) {
                    b.this.non.measure(0, 0);
                    b.this.b(tv.chushou.zues.utils.a.dip2px(b.this.nnJ, 14.0f) + b.this.non.getMeasuredHeight(), 12);
                }
            }
        };
        this.njw = (LinearLayout) this.nnt.findViewById(a.f.rl_seekbar);
        this.njE = (RelativeLayout) this.nnt.findViewById(a.f.rl_paoicon);
        this.njE.setOnClickListener(this);
        this.noo = (RoundProgressBar) this.nnt.findViewById(a.f.roundProgressBar);
        this.noq = (FrescoThumbnailView) this.nnt.findViewById(a.f.iv_paoicon);
        this.nop = (TextView) this.nnt.findViewById(a.f.tv_paonum);
        this.bb = 0;
        this.nos = 0L;
        com.kascend.chushou.player.ui.a.a dJp = ((VideoPlayer) this.nnJ).dJp();
        a(dJp.dKJ());
        BangInfo dKK = dJp.dKK();
        if (dKK != null) {
            a(dKK, dJp.d());
        }
        if (this.aw.equals("3")) {
            this.njw.setVisibility(0);
            this.nju.setVisibility(8);
            this.njO.setVisibility(0);
            this.njO.setOnClickListener(this);
        } else {
            this.njO.setVisibility(8);
            this.njw.setVisibility(8);
            this.nju.setVisibility(0);
            this.njt.setOnClickListener(this);
        }
        dJU();
        if (tv.chushou.zues.utils.systemBar.b.gD(getActivity())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njp.getLayoutParams();
            layoutParams.rightMargin += this.bV;
            this.njp.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nhB.getLayoutParams();
            layoutParams2.rightMargin += this.bV;
            this.nhB.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.njo.getLayoutParams();
            layoutParams3.rightMargin += this.bV;
            this.njo.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.njm.getLayoutParams();
            layoutParams4.rightMargin += this.bV;
            this.njm.setLayoutParams(layoutParams4);
        }
        dKs();
        dJS();
        dJW();
        this.h = (TextView) this.nnt.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nnt.findViewById(a.f.time_seekbar_relative);
        if (!this.aw.equals("3")) {
            if (this.nnI.dJF() != null) {
                this.njH.setVisibility(0);
            } else {
                this.njH.setVisibility(8);
            }
        }
        aD();
        n();
        k(100);
        this.njP = (FoodView) this.nnt.findViewById(a.f.kav_room_ad);
        this.nnK = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.d.b.8
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    switch (message.what) {
                        case 1:
                            b.this.ay(false, true);
                            break;
                        case 2:
                            b.this.nnK.removeMessages(2);
                            if (b.this.njy != null) {
                                b.this.njy.setVisibility(8);
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
                            TextView textView = (TextView) b.this.nnt.findViewById(a.f.LoadingPercent);
                            if (textView != null && textView.getVisibility() == 0) {
                                int i = b.this.ao;
                                if (i < 0) {
                                    i = 0;
                                }
                                if (i >= 100) {
                                    i = 99;
                                }
                                textView.setText(b.this.nnJ.getString(a.i.str_buffer_percent) + ":" + i + "%");
                                b.this.nnK.B(5, 200L);
                                break;
                            }
                            break;
                        case 8:
                            b.this.nnK.removeMessages(8);
                            if (!b.this.aj) {
                                b.this.nnK.B(8, 100L);
                                break;
                            } else {
                                b.this.y();
                                break;
                            }
                        case 9:
                            b.this.ax(true, false);
                            break;
                        case 11:
                            if (((VideoPlayer) b.this.nnJ).q) {
                                b.this.a(b.this.nnK);
                                break;
                            }
                            break;
                        case 12:
                            if (((VideoPlayer) b.this.nnJ).q) {
                                b.this.b(b.this.nnK);
                                break;
                            }
                            break;
                        case 14:
                            ((VideoPlayer) b.this.nnJ).g = true;
                            b.this.nke.seekTo((int) b.this.mEY);
                            if (b.this.i != null && b.this.h != null) {
                                b.this.h.setVisibility(8);
                                b.this.i.setVisibility(8);
                            }
                            b.this.ai = false;
                            if (!b.this.ai && b.this.nnI.d()) {
                                b.this.nke.play();
                                break;
                            }
                            break;
                        case 15:
                            if (b.this.nke.getPlayState() == 4) {
                                int currentPos = b.this.nke.getCurrentPos();
                                if (b.this.n != currentPos) {
                                    b.this.n();
                                    b.this.n = currentPos;
                                }
                                int i2 = 1000 - (currentPos % 1000);
                                int i3 = i2 >= 500 ? i2 : 500;
                                if (b.this.nnK != null) {
                                    b.this.nnK.B(15, i3);
                                    break;
                                }
                            }
                            break;
                        case 17:
                            b.this.as();
                            break;
                        case 18:
                            b.this.dxC();
                            break;
                        case 19:
                            b.this.nnH.setVisibility(8);
                            break;
                    }
                } catch (Exception e) {
                }
                return false;
            }
        });
        if (this.nnI != null) {
            a(this.nnI.dJG());
        }
        if (this.nke != null && (this.nke.getPlayState() == 3 || this.nke.getPlayState() == 4)) {
            wZ(false);
            if (this.nnI.d()) {
                this.ak = false;
                m(true);
                if (this.nke.getDuration() > 60000) {
                    if (this.nke.getDuration() < 300000) {
                        this.at = 60000;
                    } else {
                        this.at = Math.min(this.nke.getDuration(), 300000);
                    }
                } else {
                    this.at = this.nke.getDuration();
                }
            }
            this.e = false;
            ay(true, false);
            this.nnK.Lz(8);
            if (h() && this.nke.getPlayState() == 4 && this.nnK != null) {
                this.nnK.removeMessages(15);
                this.nnK.Lz(15);
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
            int[] dIS = g.dIS();
            int i = dIS.length == 2 ? dIS[1] : 0;
            if (i > 0) {
                View findViewById = this.nnt.findViewById(a.f.viewstub_gift_popup_landscape);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams5.leftMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, 16.0f) + i;
                findViewById.setLayoutParams(layoutParams5);
                View findViewById2 = this.nnt.findViewById(a.f.ll_lockscreen);
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                layoutParams6.leftMargin = i + tv.chushou.zues.utils.a.dip2px(this.nnJ, 10.0f);
                findViewById2.setLayoutParams(layoutParams6);
            }
        }
        ap();
        j(a.e.bg_gift_animation_h);
        b(tv.chushou.zues.utils.a.dip2px(this.nnJ, 58.0f), 12);
        k();
        a();
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnJ).n();
        }
    }

    private void a(IconConfig iconConfig) {
        if (iconConfig == null) {
            this.njv.zs(a.e.ic_recharge_old);
            this.njt.zs(a.e.ic_gift_btn_n);
            return;
        }
        a(iconConfig, (Map<String, SkinConfig.SkinRes>) null);
    }

    @Override // com.kascend.chushou.player.d
    protected void n() {
        int i;
        int i2 = 0;
        if (!this.njS && !this.k) {
            try {
                if (this.nke != null) {
                    i = this.nke.getCurrentPos();
                    i2 = this.nke.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nhi.setProgress(i / (i2 / 1000));
                    this.njT.setText(tv.chushou.zues.utils.b.o(this.nke.getDuration(), false));
                    this.njU.setText(tv.chushou.zues.utils.b.o(i, false));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @SuppressLint({"WrongViewCast"})
    private void aD() {
        this.nhi = (ProgressBar) this.nnt.findViewById(a.f.progressBarl);
        if (this.nhi != null) {
            if (this.nhi instanceof SeekBar) {
                ((SeekBar) this.nhi).setOnSeekBarChangeListener(new C0822b());
            }
            this.nhi.setMax(1000);
        }
        this.njT = (TextView) this.nnt.findViewById(a.f.tv_time_duration);
        this.njU = (TextView) this.nnt.findViewById(a.f.tv_time_pos);
        this.h = (TextView) this.nnt.findViewById(a.f.time_seekbar);
        this.i = (TextView) this.nnt.findViewById(a.f.time_seekbar_relative);
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(IconConfig.Config config) {
        com.kascend.chushou.player.ui.a.a dJp;
        BangInfo dKK;
        if (config != null) {
            this.nov = config;
            if (!config.display) {
                this.njE.setVisibility(8);
            } else if ((this.nnJ instanceof VideoPlayer) && (dKK = (dJp = ((VideoPlayer) this.nnJ).dJp()).dKK()) != null) {
                a(dKK, dJp.d());
            }
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if ((this.nov == null || this.nov.display) && this.njE != null) {
            this.njE.setVisibility(0);
            this.nop.setVisibility(0);
            b(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nnJ instanceof VideoPlayer) {
            if ((this.nov == null || this.nov.display) && this.njE != null) {
                if (j > 0) {
                    this.njE.setVisibility(0);
                    boolean z = this.nou;
                    this.nou = true;
                    if (!z) {
                        b(bangInfo, str);
                    }
                    tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                    cVar.append(this.nnJ.getString(a.i.auto_bang_count_down, Long.valueOf(j)));
                    this.nop.setText(cVar);
                    return;
                }
                this.nou = false;
                a(bangInfo, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kascend.chushou.player.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0822b implements SeekBar.OnSeekBarChangeListener {
        C0822b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (b.this.N != null) {
                if (b.this.njV != i || b.this.njW != z) {
                    b.this.njV = i;
                    b.this.njW = z;
                    if (z) {
                        if (b.this.njS) {
                            b.this.mEY = (b.this.nke.getDuration() / 1000) * i;
                        }
                        b.this.njU.setText(tv.chushou.zues.utils.b.o((int) b.this.mEY, false));
                        b.this.h.setText(tv.chushou.zues.utils.b.o((int) b.this.mEY, false));
                        b.this.i.setText(tv.chushou.zues.utils.b.o(((int) b.this.mEY) - b.this.m, true));
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            b.this.njS = true;
            b.this.m = b.this.nke.getCurrentPos();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (b.this.nnK != null) {
                if (b.this.njS) {
                    b.this.njS = false;
                }
                b.this.nnK.removeMessages(14);
                b.this.nnK.Lz(14);
            }
        }
    }

    private void k(int i) {
        this.nhi.setSecondaryProgress((i * 1000) / 100);
    }

    private void dKp() {
        this.njX = (VerticalSeekBarVolumn) this.nnt.findViewById(a.f.volumn_seekbar);
        this.njX.setOnSeekBarChangeListener(new c());
        int streamVolume = this.nnL.getStreamVolume(3);
        this.njX.setProgress(Kk(streamVolume));
        x(Kk(streamVolume) <= 0);
        ((VerticalSeekBarVolumn) this.nnt.findViewById(a.f.brightness_seekbar)).setOnSeekBarChangeListener(new a());
        if (this.c == null) {
            this.nhf = new d.a();
            this.c = new GestureDetector(this.nnJ, this.nhf);
        }
    }

    private void dKs() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.njj == null) {
                this.njj = ((Activity) this.nnJ).getWindow();
            }
            this.njk = this.njj.getAttributes();
            this.nji = ((VideoPlayer) this.nnJ).k / 255.0f;
            ((VerticalSeekBarVolumn) this.nnt.findViewById(a.f.brightness_seekbar)).setProgress((int) (10.0f * this.nji));
        }
    }

    private void dJS() {
        this.nnt.findViewById(a.f.btn_send).setOnClickListener(this);
        this.nnt.findViewById(a.f.et_input_open).setOnClickListener(this);
        if (this.nnJ.getResources().getDisplayMetrics().density < 2.0f) {
            ((TextView) this.nnt.findViewById(a.f.et_input_open)).setHint(a.i.str_danmu_hint2);
        }
        if (this.njx == null) {
            this.njx = (EditText) this.nnt.findViewById(a.f.et_input);
            this.njx.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.d.b.9
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (4 == i) {
                        b.this.onClick(b.this.nnt.findViewById(a.f.btn_send));
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJT() {
        if (this.njI != null) {
            this.njI.dismiss();
            this.njI = null;
        }
        if (this.nnJ != null) {
            ((VideoPlayer) this.nnJ).b(1, null, this.H, false);
        }
    }

    private void aI() {
        this.nhB = this.nnt.findViewById(a.f.topview);
        this.njq = (LinearLayout) this.nnt.findViewById(a.f.topRight);
        this.njn = this.nhB.findViewById(a.f.rl_download);
        this.njo = this.nnt.findViewById(a.f.topKeyboardView);
        this.nnt.findViewById(a.f.ib_close_keyboard).setOnClickListener(this);
        this.e = this.nhB.getVisibility() == 0;
        if (this.njC > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nhB.getLayoutParams();
            layoutParams.topMargin = this.njC;
            this.nhB.setLayoutParams(layoutParams);
        }
        this.nnt.findViewById(a.f.iv_back_landscape).setOnClickListener(this);
        MarqueeTextView marqueeTextView = (MarqueeTextView) this.nnt.findViewById(a.f.tv_title);
        if (marqueeTextView != null) {
            String str = "";
            if (!h() && this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                str = this.nnI.dJF().mRoominfo.mName;
            }
            marqueeTextView.setText(str);
        }
        ImageView imageView = (ImageView) this.nnt.findViewById(a.f.btn_setting);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        this.njF = (ImageView) this.nnt.findViewById(a.f.subscribe_icon);
        this.njF.setOnClickListener(this);
        this.njH = (ImageView) this.nnt.findViewById(a.f.report_icon);
        this.njH.setOnClickListener(this);
        q();
    }

    private void dJU() {
        boolean z;
        this.njm = this.nnt.findViewById(a.f.bottomview);
        this.njs = (ImageButton) this.njm.findViewById(a.f.playbutton);
        this.njs.setOnTouchListener(this);
        this.nnA = (ImageButton) this.nnt.findViewById(a.f.btn_barrage);
        this.nnB = (ImageButton) this.nnt.findViewById(a.f.btn_audio);
        this.njA = (ImageView) this.nnt.findViewById(a.f.iv_danmu);
        if (!this.aw.equals("3")) {
            this.njm.findViewById(a.f.ll_keyboard).setVisibility(0);
            this.njm.findViewById(a.f.btn_refresh).setVisibility(0);
            this.nnA.setVisibility(0);
            this.njA.setVisibility(8);
            if (this.nnI != null && this.nnI.f != null) {
                for (int i = 0; i < this.nnI.f.size(); i++) {
                    if ("2".equals(this.nnI.f.get(i).mType)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.nnB.setVisibility(0);
            } else {
                this.nnB.setVisibility(8);
            }
            this.njm.findViewById(a.f.btn_refresh).setOnClickListener(this);
            this.nnA.setOnClickListener(this);
            if (h.dIT().e) {
                this.nnA.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.nnA.setImageResource(a.e.btn_barrage_close_n);
            }
            if (this.nnI.d) {
                this.nnB.setImageResource(a.e.ic_btn_room_video_n);
            } else {
                this.nnB.setImageResource(a.e.ic_btn_room_audio_n);
            }
            this.nnB.setOnClickListener(this);
            this.nhG = (ImageView) this.njm.findViewById(a.f.btn_hotword);
            this.njr = (ImageView) this.nnt.findViewById(a.f.iv_task_badge);
            this.nhG.setOnClickListener(this);
            final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this.nnJ, a.C0815a.anim_hotword);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.d.b.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (h.dIT().c) {
                        b.this.nhG.clearAnimation();
                        b.this.nhG.startAnimation(animationSet);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.nhG.clearAnimation();
            if (h.dIT().c) {
                this.nhG.startAnimation(animationSet);
                this.njr.setVisibility(0);
            }
        } else {
            this.njm.findViewById(a.f.ll_keyboard).setVisibility(8);
            this.njm.findViewById(a.f.btn_refresh).setVisibility(8);
            this.nnA.setVisibility(8);
            this.nnB.setVisibility(8);
            this.njA.setVisibility(0);
            this.njA.setOnClickListener(this);
            if (h.dIT().b) {
                this.njA.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.njA.setImageResource(a.e.btn_barrage_close_n);
            }
        }
        this.njm.findViewById(a.f.btn_screenChange).setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.d
    protected void d() {
        e.e("VideoPlayerFullScreenFragment", "release <----------");
        if (this.nnJ != null) {
            ((VideoPlayer) this.nnJ).e(true);
        }
        if (this.nnK != null) {
            this.nnK.ch(null);
            this.nnK = null;
        }
        this.c = null;
        this.nhf = null;
        this.njy = null;
        if (this.njx != null) {
            this.njx.addTextChangedListener(null);
            this.njx.setOnEditorActionListener(null);
            this.njx = null;
        }
        this.nhB = null;
        this.nnA = null;
        this.nnB = null;
        this.njm = null;
        this.njp = null;
        if (this.njM != null) {
            this.njM.a();
            this.njM = null;
            this.njN = null;
        }
        super.d();
        e.e("VideoPlayerFullScreenFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dKn() {
        return this.njM;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        int i2;
        if (this.nnt == null) {
            return false;
        }
        switch (i) {
            case 4:
                if (this.noA == null || !this.noA.a(i, keyEvent)) {
                    if ((this.njL == null || !this.njL.onKeyDown(i, keyEvent)) && !az() && !dJR()) {
                        if (this.njo != null && this.njo.getVisibility() == 0) {
                            ax(false, true);
                            return true;
                        } else if (this.njz != null && this.njz.isShown()) {
                            dKu();
                            return true;
                        } else if (this.njB && this.nnK != null) {
                            if (this.njy != null) {
                                this.njy.setVisibility(0);
                            }
                            this.nnK.removeMessages(2);
                            this.nnK.B(2, 3000L);
                            return true;
                        } else {
                            dJT();
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            case 24:
            case 25:
                v(false);
                int progress = ((VerticalSeekBarVolumn) this.nnt.findViewById(a.f.volumn_seekbar)).getProgress();
                if (i == 25) {
                    i2 = progress - 1;
                } else {
                    i2 = progress + 1;
                }
                if (i2 <= 0) {
                    i2 = 0;
                }
                ((VerticalSeekBarVolumn) this.nnt.findViewById(a.f.volumn_seekbar)).setProgress(i2 <= 10 ? i2 : 10);
                if (this.nnK != null) {
                    this.nnK.removeMessages(3);
                    this.nnK.B(3, 2000L);
                }
                return true;
            default:
                return super.a(i, keyEvent);
        }
    }

    private boolean dKt() {
        if (this.njB) {
            this.njy.setVisibility(0);
            this.nnK.removeMessages(2);
            this.nnK.B(2, 3000L);
        }
        return this.njB;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.njB) {
            if (view.getId() == a.f.btn_lockscreen) {
                dJV();
                return;
            }
            this.njy.setVisibility(0);
            this.nnK.removeMessages(2);
            this.nnK.B(2, 3000L);
            tv.chushou.zues.utils.g.c(this.nnJ, getString(a.i.STR_VP_SCREEN_LOCK));
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
            n(view, 0, this.nhB.getHeight() + this.nhB.getTop());
        } else if (id == a.f.btn_send) {
            if (this.aw.equals("3")) {
                String trim = this.njx.getText().toString().trim();
                if (tv.chushou.zues.utils.h.isEmpty(trim)) {
                    tv.chushou.zues.utils.g.F(this.nnJ, a.i.content_no_null);
                    return;
                }
                a(trim);
                this.njx.setText((CharSequence) null);
                ax(false, true);
            } else if (a(this.njx.getText().toString(), false)) {
                ax(false, true);
            }
        } else if (id == a.f.btn_lockscreen) {
            dJV();
        } else if (id == a.f.btn_barrage) {
            if (getResources().getConfiguration().orientation == 2) {
                o(view, tv.chushou.zues.utils.systemBar.b.gC(getActivity()), 0);
            } else {
                o(view, 0, tv.chushou.zues.utils.a.dip2px(this.nnJ, 48.0f));
            }
        } else if (id == a.f.iv_danmu) {
            o(view, 0, 0);
        } else if (id == a.f.iv_back_landscape) {
            dJT();
            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击转屏_num", "横屏到竖屏", new Object[0]);
        } else if (id == a.f.btn_recharge) {
            Object[] objArr = new Object[4];
            objArr[0] = "_fromView";
            objArr[1] = dKD() ? Constants.VIA_ACT_TYPE_NINETEEN : Constants.VIA_REPORT_TYPE_START_WAP;
            objArr[2] = "_fromPos";
            objArr[3] = "34";
            b(com.kascend.chushou.d.e.a(objArr));
        } else if (id == a.f.btn_gift) {
            if (this.ap == 0) {
                boolean z = this.non == null;
                b(false, false);
                if (z && this.bV > 0 && this.non != null && tv.chushou.zues.utils.systemBar.b.ax(getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(getActivity())) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.non.getLayoutParams();
                    layoutParams.rightMargin += this.bV;
                    this.non.setLayoutParams(layoutParams);
                }
            } else {
                boolean z2 = this.non == null;
                if (this.nnJ.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                if (z2 && this.bV > 0 && this.non != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.non.getLayoutParams();
                    layoutParams2.bottomMargin += this.bV;
                    this.non.setLayoutParams(layoutParams2);
                }
            }
            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击送礼_num", "横屏", new Object[0]);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnI.dJF().mRoominfo.mRoomID);
        } else if (id == a.f.ib_close_keyboard) {
            ax(false, true);
        } else if (id == a.f.iv_send_danmu || id == a.f.et_input_open) {
            ay(false, false);
            this.nnK.B(9, 200L);
        } else if (id == a.f.btn_hotword) {
            if (h.dIT().c) {
                h.dIT().b(false);
                this.nhG.clearAnimation();
                this.njr.setVisibility(8);
            }
            int i2 = getResources().getConfiguration().orientation;
            getResources().getConfiguration();
            if (i2 == 1) {
                l(view, this.njm.findViewById(a.f.ll_keyboard).getLeft(), this.njm.getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
            } else {
                l(view, this.njm.findViewById(a.f.ll_keyboard).getLeft(), this.njm.getHeight());
            }
        } else if (id == a.f.tv_error_refresh_again || id == a.f.btn_refresh) {
            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                tv.chushou.zues.utils.g.c(this.nnJ, getString(a.i.netWorkError));
                return;
            }
            this.ai = false;
            ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
            com.kascend.chushou.toolkit.a.c.d(this.nnJ, dKD(), false);
        } else if (id == a.f.btn_screenChange) {
            dJT();
        } else if (id == a.f.rl_paoicon) {
            dJP();
        } else if (id == a.f.subscribe_icon) {
            dJY();
        } else if (id == a.f.report_icon) {
            if (this.aw.equals("3")) {
                dKb();
            } else if (com.kascend.chushou.d.e.c(getActivity(), null)) {
                dJZ();
            }
        } else if (id == a.f.btn_audio && !this.nnI.d) {
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
        } else if (System.currentTimeMillis() - this.njD <= 3000) {
            tv.chushou.zues.utils.g.LI(a.i.str_too_fast);
            return false;
        } else {
            if (!h.dIT().e) {
                s(true);
                af();
            }
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
            if (com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a(((VideoPlayer) this.nnJ).dJf().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9"))) {
                this.b = str.trim();
                this.b = com.kascend.chushou.d.e.b(this.b);
                this.njD = System.currentTimeMillis();
                a(this.nnI.dJF().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nnI.h);
                if (!z) {
                    this.njx.setText((CharSequence) null);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void r(boolean z) {
        if (!this.aw.equals("3")) {
            if (this.nnA != null) {
                if (z) {
                    this.nnA.setImageResource(a.e.btn_barrage_open_n);
                } else {
                    this.nnA.setImageResource(a.e.btn_barrage_close_n);
                }
            }
        } else if (this.njA != null) {
            if (z) {
                this.njA.setImageResource(a.e.btn_barrage_open_n);
            } else {
                this.njA.setImageResource(a.e.btn_barrage_close_n);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout dKa() {
        if (this.nnt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nnt.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.g
    protected void s(boolean z) {
        r(z);
        if (this.nox != null) {
            this.nox.setVisibility(z ? 0 : 8);
            if (!z) {
                this.nox.dVU();
            }
        }
        tv.chushou.zues.utils.g.y(tv.chushou.widget.a.c.getString(z ? a.i.STR_VP_BARRAGE_OPEN : a.i.STR_VP_BARRAGE_CLOSE));
    }

    private void dJV() {
        if (this.nnI.d()) {
            if (this.njB) {
                this.njy.setBackgroundResource(a.e.btn_unlockscreen_n);
                tv.chushou.zues.utils.g.c(this.nnJ, this.nnJ.getString(a.i.STR_VP_SCREEN_UNLOCK));
            } else {
                this.njy.setBackgroundResource(a.e.btn_lockscreen_n);
                tv.chushou.zues.utils.g.c(this.nnJ, this.nnJ.getString(a.i.STR_VP_SCREEN_LOCK));
            }
            this.njB = !this.njB;
            if (this.njx != null) {
                this.njx.setEnabled(this.njB ? false : true);
            }
        }
    }

    public void ax(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dE(this.njx);
            this.njx.setText("");
            this.njp.setVisibility(8);
            this.njy.setVisibility(8);
            this.nhB.setVisibility(8);
            this.njm.setVisibility(8);
            this.njo.setVisibility(0);
            return;
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
        if (this.njo.getVisibility() != 8 && z2) {
            this.njo.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_top_anim));
        }
        this.njp.setVisibility(8);
        this.njy.setVisibility(8);
        this.nhB.setVisibility(8);
        this.njm.setVisibility(8);
        this.njo.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.g
    public void c(String str, String str2) {
        ay(false, false);
        super.c(str, str2);
    }

    private void u(boolean z) {
        if (this.njq != null) {
            this.njq.setVisibility(z ? 0 : 4);
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
            if (this.njJ != null) {
                this.njJ.a(this.e);
            }
            return this.e;
        }
        if (this.nnK != null) {
            this.nnK.removeMessages(1);
        }
        if (z) {
            ((VideoPlayer) this.nnJ).e(true);
            if (!z3) {
                if (this.njm.getVisibility() != 0 && z2) {
                    this.njm.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_bottom_anim));
                }
                this.njm.setVisibility(0);
                this.njp.setVisibility(0);
                this.njy.setVisibility(0);
                this.njn.setVisibility(o() ? 0 : 8);
            }
            if (this.nhB.getVisibility() != 0 && z2) {
                this.nhB.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_top_anim));
            }
            u(!z3);
            this.nhB.setVisibility(0);
            if (this.nnK != null) {
                this.nnK.B(1, 5000L);
            }
            y(false);
            if (this.njJ != null) {
                this.njJ.a(true);
            }
        } else {
            ((VideoPlayer) this.nnJ).e(false);
            if (this.noa != null) {
                this.noa.dismiss();
            }
            if (this.nob != null) {
                this.nob.dismiss();
            }
            if (this.noi != null) {
                this.noi.dismiss();
            }
            if (this.njm != null) {
                if (this.njm.getVisibility() != 8 && z2) {
                    this.njm.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_bottom_anim));
                }
                this.njm.setVisibility(8);
            }
            if (this.njp != null) {
                this.njp.setVisibility(8);
                if (this.nhB.getVisibility() != 8 && z2) {
                    this.nhB.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_top_anim));
                }
                this.nhB.setVisibility(8);
                this.njy.setVisibility(8);
                y(true);
                a(false);
                if (this.njJ != null) {
                    this.njJ.a(false);
                }
            } else {
                return z;
            }
        }
        this.e = z;
        return this.e;
    }

    private void dJW() {
        Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
        if (this.ap == 1) {
            this.ar = Math.min(gw.x, gw.y);
            this.aq = Math.max(gw.x, gw.y);
        } else {
            this.ar = Math.max(gw.x, gw.y);
            this.aq = Math.min(gw.x, gw.y);
        }
        int i = this.ar;
        int i2 = this.aq;
        if (this.njg == null) {
            this.njg = new Rect(0, 0, i / 5, i2);
        } else {
            this.njg.set(0, 0, i / 5, i2);
        }
        if (this.njh == null) {
            this.njh = new Rect((i * 4) / 5, 0, i, i2);
        } else {
            this.njh.set((i * 4) / 5, 0, i, i2);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.njg == null) {
            return false;
        }
        return this.njg.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z) {
        View findViewById = this.nnt.findViewById(a.f.volumn_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nnt.findViewById(a.f.brightness_view);
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
        if (this.njh == null) {
            return false;
        }
        return this.njh.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        View findViewById = this.nnt.findViewById(a.f.brightness_view);
        if (findViewById != null) {
            if (!z) {
                if (!findViewById.isShown()) {
                    findViewById.setVisibility(0);
                    View findViewById2 = this.nnt.findViewById(a.f.volumn_view);
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
                if (this.njB) {
                    this.njy.setVisibility(0);
                    return true;
                }
                break;
            case 1:
                if (this.njB) {
                    this.nnK.removeMessages(2);
                    this.nnK.B(2, 3000L);
                    return true;
                } else if (this.nnK != null) {
                    this.nnK.B(3, 1000L);
                    this.nnK.B(4, 1000L);
                    break;
                }
                break;
            case 2:
                if (this.njB) {
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
        int streamMaxVolume = (this.nnL.getStreamMaxVolume(3) * i) / 10;
        VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
        VideoPlayer.n = streamMaxVolume;
        return streamMaxVolume;
    }

    private int Kk(int i) {
        int streamMaxVolume = (i * 10) / this.nnL.getStreamMaxVolume(3);
        e.d("VideoPlayerFullScreenFragment", "index:" + i + " progress" + streamMaxVolume);
        return streamMaxVolume;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (z) {
            this.nnt.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.mute);
        } else {
            this.nnt.findViewById(a.f.flag_volumn).setBackgroundResource(a.e.volumn);
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
                                    if (this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
                                        ((VideoPlayer) this.nnJ).a(1, null, this.H, false, false, true);
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
            b.this.nnL.setStreamVolume(3, b.this.Kj(i), 0);
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
            b.this.nji = i / 10.0f;
            ((VideoPlayer) b.this.nnJ).l = b.this.nji;
            ((VideoPlayer) b.this.nnJ).k = b.this.nji * 255.0f;
            b.this.njk.screenBrightness = b.this.nji;
            b.this.njj.setAttributes(b.this.njk);
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
                        aVar.e = ((VerticalSeekBarVolumn) this.nnt.findViewById(a.f.volumn_seekbar)).getProgress();
                    } else if (d(motionEvent)) {
                        w(false);
                        aVar.getClass();
                        aVar.d = 2;
                        aVar.e = ((VerticalSeekBarVolumn) this.nnt.findViewById(a.f.brightness_seekbar)).getProgress();
                    }
                }
                if (aVar.d == 0 && this.at > 0 && Math.abs(rawY) < Math.abs(rawX)) {
                    int abs2 = Math.abs(rawX);
                    aVar.getClass();
                    if (abs2 > 5) {
                        this.k = true;
                        aVar.d = 3;
                        aVar.e = this.nhi.getProgress();
                    }
                }
            } else {
                int i = aVar.d;
                aVar.getClass();
                if (i == 1) {
                    VerticalSeekBarVolumn verticalSeekBarVolumn = (VerticalSeekBarVolumn) this.nnt.findViewById(a.f.volumn_seekbar);
                    v(false);
                    int height = verticalSeekBarVolumn.getHeight();
                    if (height > 0) {
                        verticalSeekBarVolumn.setProgress(((rawY * 10) / height) + aVar.e);
                    }
                } else {
                    int i2 = aVar.d;
                    aVar.getClass();
                    if (i2 == 2) {
                        VerticalSeekBarVolumn verticalSeekBarVolumn2 = (VerticalSeekBarVolumn) this.nnt.findViewById(a.f.brightness_seekbar);
                        w(false);
                        int height2 = verticalSeekBarVolumn2.getHeight();
                        if (height2 > 0) {
                            verticalSeekBarVolumn2.setProgress(((rawY * 10) / height2) + aVar.e);
                        }
                    } else if (aVar.d == 3) {
                        this.j = d(rawX);
                        if (this.j != 0) {
                            int currentPos = this.nke.getCurrentPos();
                            int duration = this.nke.getDuration();
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
                                this.nhi.setProgress(i3 / (duration / 1000));
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
        if (!this.njl) {
            if (this.njo.getVisibility() == 8 && (this.njz == null || !this.njz.isShown())) {
                boolean z = this.nnD != null && this.nnD.getVisibility() == 0;
                if (this.e) {
                    ay(false, true);
                } else {
                    k(true, true, z);
                }
                aVar.d = 0;
            } else {
                ax(false, true);
                dKu();
            }
        }
        return false;
    }

    public boolean dJR() {
        if (this.njl) {
            if (this.non != null) {
                this.non.e();
            }
            y(false);
            if (this.njm != null) {
                this.njm.setVisibility(0);
            }
            if (this.nhB != null) {
                this.nhB.setVisibility(0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void dKg() {
        super.dKg();
        if (this.nnJ instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        this.H = true;
        if (this.nnI != null) {
            this.nnI.f = null;
            if (this.nnI.dJF() != null) {
                this.nnI.dJF().mRoominfo.mGameId = null;
            }
        }
        if (this.aw.equals("3")) {
            if (this.nke != null) {
                this.nke.seekTo(0L);
                e(true);
            }
            dJT();
            return;
        }
        dJT();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.njB) {
            return true;
        }
        if (view.getId() == a.f.playbutton) {
            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                tv.chushou.zues.utils.g.c(this.nnJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.nke.getPlayState() == 4) {
                        aN();
                        e(true);
                    } else {
                        if (this.njP != null) {
                            this.njP.a();
                        }
                        if (this.al) {
                            this.al = false;
                            this.nnI.a(false);
                            ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
                        } else if (this.nke.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nke.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            break;
                        } else if (this.nke.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.nke.getPlayState() == 4) {
                        a(true, false);
                        break;
                    } else if (this.nke.getPlayState() == 6) {
                        a(false, false);
                        break;
                    } else {
                        a(false, !this.ak);
                        break;
                    }
            }
        } else if (view.getId() == a.f.resumebutton) {
            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                tv.chushou.zues.utils.g.c(this.nnJ, getString(a.i.netWorkError));
                return motionEvent.getAction() == 0;
            } else if (motionEvent.getAction() == 1) {
                if (this.al) {
                    this.al = false;
                    this.nnI.a(false);
                    a(false, !this.ak);
                    ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                } else if (!this.aw.equals("3")) {
                    ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
                    this.ai = false;
                    m(true);
                    a(false, !this.ak);
                } else if (this.nke.getPlayState() == 6) {
                    e.e("VideoPlayerFullScreenFragment", "replay this video...");
                    ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
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
            if (this.nnI != null && this.nnI.dJI() != null) {
                str = this.nnI.dJI().mRoomID;
            }
            f(com.kascend.chushou.a.a.d, str);
        }
    }

    private void f(final String str, String str2) {
        if (com.kascend.chushou.a.a.dIN().neA != null && com.kascend.chushou.a.a.dIN().neA.contains(str) && this.nnI != null && !this.njY) {
            this.njY = true;
            com.kascend.chushou.a.a.dIN().a(str, str2, new a.c() { // from class: com.kascend.chushou.player.d.b.11
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
                        b.this.njY = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        if (listItem != null && this.njP != null) {
            this.njP.a(listItem, this.ap == 1, a.C0815a.zues_sweetalert_modal_in, a.C0815a.zues_sweetalert_modal_out, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.12
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    b.this.njY = false;
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void a(boolean z, boolean z2) {
        if (z) {
            if (this.njs != null) {
                this.njs.setImageResource(a.e.btn_pause_selector);
            }
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            if (this.nnD != null) {
                this.nnD.setVisibility(8);
                return;
            }
            return;
        }
        if (this.njs != null) {
            this.njs.setImageResource(a.e.btn_play_selector);
        }
        if (this.a != null) {
            if (z2 != (this.a.getVisibility() == 0)) {
                if (z2) {
                    this.a.setBackgroundResource(a.e.ic_dynamics_video_play);
                    this.a.setVisibility(0);
                    return;
                }
                this.a.setVisibility(8);
                if (this.nnD != null) {
                    this.nnD.setVisibility(8);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void dJX() {
        this.N = new SurfaceView(this.nnJ);
        SurfaceView surfaceView = (SurfaceView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        surfaceView.setLayoutParams(layoutParams);
        ((RelativeLayout) this.nnt).addView(surfaceView, 0);
        surfaceView.getHolder().addCallback(this);
        Y();
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        if (this.nox != null) {
            this.nox.dVU();
            this.nox.setVisibility(8);
            this.nox.unInit();
            ((RelativeLayout) this.nnt).removeView(this.nox);
            this.nox = null;
        }
        if (this.N != null) {
            this.N.setVisibility(8);
            ((RelativeLayout) this.nnt).removeView(this.N);
            this.N = null;
        }
        dJX();
        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
    }

    private void l(View view, int i, int i2) {
        if (this.nnK != null) {
            y(true);
            this.nnK.removeMessages(1);
            this.njm.setVisibility(0);
            this.njp.setVisibility(8);
            this.nhB.setVisibility(8);
            this.njy.setVisibility(8);
        }
        if (this.noi == null) {
            al();
            this.noi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    b.this.nhG.setImageResource(a.e.ic_hotwords);
                }
            });
        }
        if (!this.noi.isShowing()) {
            this.noi.showAtLocation(view, 83, i, i2);
            this.nhG.setImageResource(a.e.ic_hotwords_p);
            com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nnI.dJF().mRoominfo.mRoomID);
            return;
        }
        this.noi.dismiss();
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.njL != null && this.njL.b()) {
                this.njL.getGlobalVisibleRect(this.nka);
                if (!this.nka.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.njL.a();
                    return true;
                }
            }
            if (this.njl && f(this.non.b, motionEvent)) {
                dJR();
                return true;
            }
            if (!dKt()) {
                if (System.currentTimeMillis() - this.njZ < 300 && this.njP != null && this.njP.isShown()) {
                    this.njP.a();
                    if (this.nke.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                            this.nnI.a(false);
                            ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                        } else if (!this.aw.equals("3")) {
                            this.ai = false;
                            ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
                        } else if (this.nke.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            ((VideoPlayer) this.nnJ).a(false, (Uri) null, false);
                        } else {
                            n(true);
                        }
                    }
                    if (this.nke.getPlayState() != 4) {
                        if (this.al) {
                            this.al = false;
                        } else if (this.nke.getPlayState() == 6) {
                            e.e("VideoPlayerFullScreenFragment", "replay this video...");
                            m(true);
                        }
                    }
                    return true;
                }
                this.njZ = System.currentTimeMillis();
            }
            return false;
        }
        return false;
    }

    public void dKu() {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
        if (this.njz != null) {
            if (this.njz.isShown()) {
                this.njz.startAnimation(AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_top_anim));
            }
            this.njz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        WindowManager.LayoutParams attributes = ((VideoPlayer) this.nnJ).getWindow().getAttributes();
        if (z) {
            attributes.flags |= 1024;
        } else {
            attributes.flags &= -1025;
        }
        ((VideoPlayer) this.nnJ).getWindow().setAttributes(attributes);
        if (z) {
            a(false, 0);
        } else {
            a(true, a.c.player_bg_color);
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void h(int i) {
        if (i == 1) {
            if (this.nnB != null) {
                this.nnB.setVisibility(8);
            }
            if (tv.chushou.zues.utils.systemBar.b.gD(getActivity())) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.njp.getLayoutParams();
                layoutParams.rightMargin -= this.bV;
                this.njp.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nhB.getLayoutParams();
                layoutParams2.rightMargin -= this.bV;
                this.nhB.setLayoutParams(layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.njo.getLayoutParams();
                layoutParams3.rightMargin -= this.bV;
                this.njo.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.njm.getLayoutParams();
                layoutParams4.rightMargin -= this.bV;
                layoutParams4.bottomMargin += this.bV;
                this.njm.setLayoutParams(layoutParams4);
            }
        }
    }

    @Override // com.kascend.chushou.player.d
    public void q() {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
            this.njF.setVisibility(0);
            if (this.nnI.dJF().mRoominfo.mIsSubscribed) {
                this.njF.setImageResource(a.e.myroom_subscribed);
                return;
            } else {
                this.njF.setImageResource(a.e.btn_player_subscribe_n);
                return;
            }
        }
        this.njF.setVisibility(8);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    private void dJY() {
        RoomInfo roomInfo;
        if (this.nnI != null && this.nnI.dJF() != null && (roomInfo = this.nnI.dJF().mRoominfo) != null) {
            if (roomInfo.mIsSubscribed) {
                com.kascend.chushou.d.e.a(this.nnJ, roomInfo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.d.b.3
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar) {
                        bVar.dXm();
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
        if (this.nnI != null && this.nnI.dJF() != null && (roomInfo = this.nnI.dJF().mRoominfo) != null) {
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
                                tv.chushou.zues.utils.g.F(b.this.nnJ, a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.F(b.this.nnJ, a.i.subscribe_success);
                            }
                            if (b.this.nnI != null && b.this.nnI.dJF() != null && (roomInfo2 = b.this.nnI.dJF().mRoominfo) != null) {
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
                            com.kascend.chushou.d.e.b(b.this.nnJ, (String) null);
                            return;
                        }
                        if (tv.chushou.zues.utils.h.isEmpty(str2)) {
                            str2 = b.this.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.c(b.this.nnJ, str2);
                    }
                }
            };
            if (this.nnI != null && this.nnI.h != null) {
                try {
                    str = new JSONObject(this.nnI.h).optString("_sc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String a2 = com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "30", "_sc", str);
                if (!z) {
                    com.kascend.chushou.c.c.dIP().b(bVar, (String) null, roomInfo.mCreatorUID, a2);
                    return;
                } else {
                    com.kascend.chushou.c.c.dIP().a(bVar, (String) null, roomInfo.mCreatorUID, a2);
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
            if (this.njG == null) {
                this.njG = new ProgressDialog(this.nnJ);
                this.njG.setProgressStyle(0);
                this.njG.requestWindowFeature(1);
                this.njG.setMessage(this.nnJ.getText(a.i.update_userinfo_ing));
                this.njG.setCancelable(true);
            }
            if (!this.njG.isShowing()) {
                this.njG.show();
            }
        } else if (this.njG != null && this.njG.isShowing()) {
            this.njG.dismiss();
        }
    }

    private void dJZ() {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
            if (this.njI == null) {
                this.njI = new f(getActivity());
            }
            this.njI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kascend.chushou.player.d.b.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    b.this.njI = null;
                }
            });
            RoomInfo roomInfo = this.nnI.dJF().mRoominfo;
            this.njI.a();
            this.njI.a(roomInfo);
            if (!this.njI.isShowing()) {
                this.njI.show();
            }
        }
    }

    private void dKb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
        if (this.njX != null && this.nnL != null && this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
            VerticalSeekBarVolumn verticalSeekBarVolumn = this.njX;
            VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
            verticalSeekBarVolumn.setProgressOnly(Kk(VideoPlayer.n));
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        super.y();
        if (this.nhj != null) {
            this.nhj.dWO();
        }
        if (this.nnt != null) {
            int i = this.ap == 0 ? 1 : 2;
            if (this.njJ == null) {
                this.njJ = new com.kascend.chushou.player.ui.giftpopup.a(this.nnt, i);
            } else if (this.njJ.a() != i) {
                this.njJ.b();
                this.njJ = null;
                this.njJ = new com.kascend.chushou.player.ui.giftpopup.a(this.nnt, i);
            }
            List<ListItem> j = this.nnI != null ? this.nnI.j() : null;
            VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
            if (videoPlayer != null) {
                this.njJ.a(j, videoPlayer.dJl(), videoPlayer.dJm(), videoPlayer.dJn(), videoPlayer.dJo());
                this.njJ.a(this.e);
                if (this.nnI != null && this.nnI.ngQ != null) {
                    this.njJ.a(this.nnI.ngQ, new FoodView.a() { // from class: com.kascend.chushou.player.d.b.6
                        @Override // com.kascend.chushou.player.ui.food.FoodView.a
                        public boolean a() {
                            if (b.this.nnI != null) {
                                b.this.nnI.ngQ = null;
                                return true;
                            }
                            return true;
                        }
                    });
                }
                if (this.njJ != null && this.nnI != null) {
                    this.njJ.b(this.nnI.ngS);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void a(int i) {
        if (this.njJ != null && this.nnJ != null) {
            this.njJ.a(((VideoPlayer) this.nnJ).dJl());
            this.njJ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void D() {
        if (this.nnJ instanceof VideoPlayer) {
            int i = (this.ap == 6 || this.ap == 1) ? 2 : 1;
            com.kascend.chushou.player.ui.h5.redpacket.a dJl = ((VideoPlayer) this.nnJ).dJl();
            if (this.noA == null) {
                this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.noA.setVisibility(0);
            this.noA.a(i, dJl);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        super.a(list);
        if (this.njJ != null) {
            this.njJ.a(list);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null) {
            if (this.njv != null && iconConfig.payConfig != null) {
                if (iconConfig.payConfig.display) {
                    this.njv.setVisibility(0);
                    this.njv.bU(iconConfig.payConfig.icon, a.e.ic_recharge_old);
                } else {
                    this.njv.setVisibility(8);
                }
            }
            if (this.njt != null && iconConfig.giftConfig != null) {
                if (iconConfig.giftConfig.display) {
                    this.nju.setVisibility(0);
                    this.njt.bU(iconConfig.giftConfig.icon, a.e.ic_gift_btn_n);
                    return;
                }
                this.nju.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.njJ != null) {
            this.njJ.a(((VideoPlayer) this.nnJ).dJm());
            this.njJ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.njJ != null) {
            this.njJ.a(((VideoPlayer) this.nnJ).dJm());
            this.njJ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(long j) {
        if (this.njJ != null) {
            this.njJ.a(((VideoPlayer) this.nnJ).dJn());
            this.njJ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0828a
    public void c(int i) {
        if (this.njJ != null) {
            this.njJ.a(((VideoPlayer) this.nnJ).dJo());
            this.njJ.c();
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        wZ(false);
        super.F();
    }

    private void c(View view) {
        this.njQ = (RelativeLayout) view.findViewById(a.f.rl_4g_warning);
        this.nik = (TextView) view.findViewById(a.f.tv_4g_video);
        this.nik.setText(new tv.chushou.zues.widget.a.c().J(this.nnJ, a.e.videoplayer_4g_video).append("  ").append(this.nnJ.getString(a.i.videoplayer_4g_video)));
        this.njR = (TextView) view.findViewById(a.f.tv_4g_audio);
        this.njR.setText(new tv.chushou.zues.widget.a.c().J(this.nnJ, a.e.videoplayer_4g_audio).append("  ").append(this.nnJ.getString(a.i.videoplayer_4g_audio)));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kascend.chushou.player.d.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int id = view2.getId();
                if (id == a.f.iv_4g_back) {
                    b.this.dJT();
                    com.kascend.chushou.toolkit.a.c.a(b.this.nnJ, "点击转屏_num", "横屏到竖屏", new Object[0]);
                } else if (id == a.f.tv_4g_video) {
                    b.this.njQ.setVisibility(8);
                    ((VideoPlayer) b.this.nnJ).c(b.this.nim);
                } else if (id == a.f.tv_4g_audio) {
                    b.this.njQ.setVisibility(8);
                    ((VideoPlayer) b.this.nnJ).d(b.this.nim);
                } else {
                    if (id == a.f.tv_union_proxy) {
                    }
                }
            }
        };
        View findViewById = view.findViewById(a.f.iv_4g_back);
        findViewById.setOnClickListener(onClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
        findViewById.setLayoutParams(layoutParams);
        this.nik.setOnClickListener(onClickListener);
        this.njR.setOnClickListener(onClickListener);
        View findViewById2 = view.findViewById(a.f.tv_union_proxy);
        findViewById2.setOnClickListener(onClickListener);
        findViewById2.setVisibility(8);
        if (this.nnI != null && !tv.chushou.zues.utils.h.isEmpty(this.nnI.f)) {
            f(this.nnI.f, false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f(ArrayList<PlayUrl> arrayList, boolean z) {
        if (com.kascend.chushou.d.e.b() && com.kascend.chushou.d.e.c() == -1) {
            this.nim = z;
            this.p = false;
            if (this.nnI != null && this.nnI.f != null) {
                int i = 0;
                while (true) {
                    if (i >= this.nnI.f.size()) {
                        break;
                    } else if (!"2".equals(this.nnI.f.get(i).mType)) {
                        i++;
                    } else {
                        this.p = true;
                        break;
                    }
                }
            }
            if (this.njQ != null) {
                this.njQ.setVisibility(0);
                this.nik.setVisibility(0);
                this.njR.setVisibility(this.p ? 0 : 8);
                return;
            }
            return;
        }
        v();
    }

    @Override // com.kascend.chushou.player.e
    public void v() {
        if (this.njQ != null) {
            this.njQ.setVisibility(8);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.njJ != null && this.nnI != null) {
            this.njJ.b(this.nnI.ngS);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        View findViewById;
        if (this.nnt != null && (findViewById = this.nnt.findViewById(a.f.et_input_open)) != null) {
            findViewById.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.njt != null) {
            this.njt.performClick();
        }
    }
}
