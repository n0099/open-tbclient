package com.kascend.chushou.player.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tbadk.TbConfig;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.b.a.a.p;
import com.kascend.chushou.bean.KaraokeBean;
import com.kascend.chushou.bean.UserCard;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ColorPrivileges;
import com.kascend.chushou.constants.ConfigDetail;
import com.kascend.chushou.constants.CycleLiveRoomInfo;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.GiftInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicMemberInfo;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.OnlineVip;
import com.kascend.chushou.constants.OnlineVipItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.PrivilegeInfo;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.RoomToast;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.constants.UrlDetails;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.a.f;
import com.kascend.chushou.player.d;
import com.kascend.chushou.player.e.b;
import com.kascend.chushou.player.ui.InteractNotifier;
import com.kascend.chushou.player.ui.InteractionView;
import com.kascend.chushou.player.ui.PaoPaoView;
import com.kascend.chushou.player.ui.PlayShowMicPerson;
import com.kascend.chushou.player.ui.PlayerErrorView;
import com.kascend.chushou.player.ui.button.EmbeddedButtonLayout;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.player.ui.h5.H5Container;
import com.kascend.chushou.player.ui.h5.redpacket.RedpacketNotifier;
import com.kascend.chushou.player.ui.miniview.PlayShowMicStatusView;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.view.h5.H5Options;
import com.kascend.chushou.widget.GiftAnimationLayout;
import com.kascend.chushou.widget.OnlineToggleButton;
import com.kascend.chushou.widget.VideoShowVoteView;
import com.kascend.chushou.widget.VoiceInteractionView;
import com.kascend.chushou.widget.guide.PaoGuideView;
import com.kascend.chushou.widget.menu.KasBaseMenuView;
import com.kascend.chushou.widget.menu.PlayShowH5View;
import com.kascend.chushou.widget.showplayer.PlayShowRecommendView;
import com.tencent.connect.common.Constants;
import io.reactivex.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.common.player.SurfaceRenderView;
import tv.chushou.widget.ToggleButton;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.adapterview.recyclerview.a.a;
import tv.chushou.zues.widget.edittext.PastedEditText;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
import tv.chushou.zues.widget.kpswitch.b.a;
import tv.chushou.zues.widget.kpswitch.b.d;
import tv.chushou.zues.widget.kpswitch.widget.KPSwitchPanelLinearLayout;
import tv.chushou.zues.widget.sweetalert.b;
/* loaded from: classes6.dex */
public class c extends com.kascend.chushou.player.d implements View.OnClickListener {
    private int bP;
    private int dB;
    private TextView nUB;
    private TextView nUE;
    private ImageView nUK;
    private TextView nUT;
    private View nUq;
    public String nUx;
    private TextView nVE;
    private View nVH;
    private KPSwitchPanelLinearLayout nVb;
    private ImageView nVc;
    private tv.chushou.zues.widget.kpswitch.b.c nVd;
    private d.a nVe;
    private TextView nVt;
    private TextView nWE;
    private RelativeLayout nXA;
    private AnimationSet nXB;
    private ImageView nXC;
    private ImageView nXD;
    private RelativeLayout nXE;
    private PastedEditText nXF;
    private ToggleButton nXG;
    private RelativeLayout nXH;
    private PaoPaoView nXI;
    private FrescoThumbnailView nXJ;
    private LinearLayout nXK;
    private ImageView nXL;
    private InteractionView nXM;
    private LinearLayout nXN;
    private FrescoThumbnailView nXO;
    private FrameLayout nXP;
    private RedpacketNotifier nXQ;
    private InteractNotifier nXR;
    private EmbeddedButtonLayout nXS;
    private GiftAnimationLayout nXT;
    private com.kascend.chushou.player.b.a nXU;
    private f nXV;
    private PlayShowH5View nXW;
    private LinearLayout nXX;
    private TextView nXY;
    private TextView nXZ;
    private int nXd;
    private View nXe;
    private View nXf;
    private com.kascend.chushou.view.user.b nXg;
    private View nXh;
    private FrameLayout nXi;
    private LinearLayout nXj;
    private RelativeLayout nXk;
    private FrescoThumbnailView nXl;
    private TextView nXm;
    private TextView nXn;
    private TextView nXo;
    private FrescoThumbnailView nXp;
    private TextView nXq;
    private TextView nXr;
    private TextView nXs;
    private TextView nXt;
    private LinearLayout nXu;
    private PlayShowMicStatusView nXv;
    private RecyclerView nXw;
    private ImageView nXx;
    private PlayShowRecommendView nXy;
    private View nXz;
    private View nYA;
    private View nYB;
    private Animator nYC;
    private View nYD;
    private View nYE;
    private Animator nYF;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nYI;
    private PlayShowMicPerson nYL;
    private FoodView nYP;
    public ListItem nYQ;
    private FoodView nYR;
    private com.kascend.chushou.player.ui.miniview.a nYS;
    private int nYT;
    private int nYU;
    private Point nYV;
    private FrescoThumbnailView nYY;
    private FrescoThumbnailView nYZ;
    private TextView nYa;
    private TextView nYb;
    private TextView nYc;
    private TextView nYd;
    private ImageView nYe;
    private TextView nYf;
    private PopupWindow nYk;
    private View nYm;
    private RecyclerView nYo;
    private RoomInfo nYp;
    private RecyclerView.LayoutManager nYr;
    private ArrayList<ChatInfo> nYs;
    private ArrayList<ChatInfo> nYt;
    private ArrayList<ChatInfo> nYu;
    private ArrayList<ChatInfo> nYv;
    private Button nYz;
    private FrescoThumbnailView nZA;
    private TextView nZB;
    private TextView nZC;
    private ImageView nZD;
    private RelativeLayout nZE;
    private TextView nZG;
    private float nZH;
    private float nZI;
    private a nZJ;
    private ValueAnimator nZb;
    private LinearLayout nZc;
    private long nZd;
    private VideoShowVoteView nZe;
    private Runnable nZf;
    private FrescoThumbnailView nZh;
    private ImageView nZi;
    private RelativeLayout nZj;
    private TextView nZk;
    private ImageView nZl;
    private EditText nZm;
    private View nZn;
    private RelativeLayout nZo;
    private RelativeLayout nZp;
    private FrescoThumbnailView nZq;
    private TextView nZr;
    private TextView nZs;
    private ImageView nZt;
    private RelativeLayout nZu;
    private LinearLayout nZv;
    private TextView nZw;
    private TextView nZx;
    private RelativeLayout nZy;
    private RelativeLayout nZz;
    private boolean cp = false;
    private int nYg = 1;
    private boolean nYh = false;
    private int nYi = 0;
    private int nYj = 0;
    private int nYl = -1;
    private boolean nYn = false;
    private FullRoomInfo nYq = null;
    private com.kascend.chushou.player.adapter.a nYw = null;
    private ArrayList<String> nYx = null;
    private boolean nYy = true;
    private boolean nYG = true;
    private boolean nYH = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean nYJ = false;
    private boolean nYK = false;
    private long nYM = 0;
    private int nYN = 1;
    private boolean nYO = false;
    private int nYW = -1;
    private int nYX = -1;
    private boolean nZa = false;
    private int nZg = -1;
    private io.reactivex.disposables.b nZF = null;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(boolean z);
    }

    public static c b(String str, boolean z, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("cover", str);
        bundle.putBoolean("initViewAsync", z);
        bundle.putString("liveType", str2);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nUx = getArguments().getString("cover");
        this.nYG = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.oaj = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.oaj;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            edx();
            this.nWQ = ((VideoPlayer) this.oay).ecH();
            this.oax = ((VideoPlayer) this.oay).ecK();
            d(view);
            edH();
            if (this.oay instanceof VideoPlayer) {
                ((VideoPlayer) this.oay).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nYH = false;
        if (this.obd != null) {
            this.obd.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nYH = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nYC != null) {
            this.nYC.removeAllListeners();
            this.nYC.cancel();
            this.nYC = null;
        }
        if (this.nYF != null) {
            this.nYF.removeAllListeners();
            this.nYF.cancel();
            this.nYF = null;
        }
        if (this.nXR != null) {
            this.nXR.c();
        }
        super.onDestroyView();
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        d();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.d
    public void d() {
        if (this.nZF != null) {
            this.nZF.dispose();
            this.nZF = null;
        }
        this.nYg = 1;
        this.nYh = false;
        if (this.oaz != null) {
            this.oaz.cl(null);
        }
        if (this.nYk != null) {
            this.nYk.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.oay, this.nVd);
        if (this.oay != null && (this.oay instanceof VideoPlayer)) {
            ((VideoPlayer) this.oay).ecO();
        }
        this.nVe = null;
        this.nVd = null;
        aI();
        if (this.nXU != null) {
            this.nXU.a();
        }
        if (this.nXI != null) {
            this.nXI.b();
            this.nXI.c();
            this.nXI = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.cm(this);
        if (this.nYu != null) {
            this.nYu.clear();
        }
        if (this.nYs != null) {
            this.nYs.clear();
        }
        if (this.nYv != null) {
            this.nYv.clear();
        }
        if (this.nYt != null) {
            this.nYt.clear();
        }
        if (this.nYx != null) {
            this.nYx.clear();
        }
        if (this.nYw != null) {
            this.nYw.a(0);
            this.nYw.a();
        }
    }

    private void d(View view) {
        this.nXe = view.findViewById(a.f.fl_root);
        this.nYV = tv.chushou.zues.utils.a.hd(this.oay);
        this.nYi = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.oay);
        this.nYj = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        this.nYU = 86;
        this.oax = ((VideoPlayer) this.oay).ecK();
        if (this.oax != null) {
            this.nYp = this.oax.edl();
            this.nYq = this.oax.edj();
        }
        this.nYs = new ArrayList<>();
        this.nYu = new ArrayList<>();
        this.nYt = new ArrayList<>();
        this.nXi = (FrameLayout) this.oaj.findViewById(a.f.fl_effect);
        b();
        this.oas = (PlayerErrorView) this.oaj.findViewById(a.f.view_net_error_msg);
        this.oas.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.nXH = (RelativeLayout) this.oaj.findViewById(a.f.rl_audio_ani);
        this.nXI = (PaoPaoView) this.oaj.findViewById(a.f.audio_ani);
        this.nXJ = (FrescoThumbnailView) this.oaj.findViewById(a.f.audio_ani_avatar);
        this.nXK = (LinearLayout) this.oaj.findViewById(a.f.ll_audio);
        this.nWE = (TextView) this.oaj.findViewById(a.f.tv_open_video);
        this.nXL = (ImageView) this.oaj.findViewById(a.f.iv_audio_ani);
        this.nYZ = (FrescoThumbnailView) this.oaj.findViewById(a.f.live_cover);
        if (!this.nZa || this.nWQ == null || this.nWQ.getPlayState() != 4) {
            this.nYZ.setVisibility(0);
            this.nYZ.setBlur(true);
            this.nYZ.i(this.nUx, 0, 0, 0);
        }
        this.nWE.setOnClickListener(this);
        this.nUb = new b();
        this.nUb.a(view, null, this.oay, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cyX()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.oax != null) {
                    append.append(c.this.oax.edl().mRoomID);
                }
                if (c.this.nUa != null && c.this.nUa.nWR != null) {
                    append.append("&mode=").append(c.this.nUa.nWR.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.oay, append.toString());
            }
        });
        this.nUf = (VoiceInteractionView) this.oaj.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.oax != null) {
            this.nYp = this.oax.edl();
            this.nYq = this.oax.edj();
        }
        aL();
        edw();
        edC();
        this.nZc = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nYP = (FoodView) view.findViewById(a.f.rav_ad);
        this.nZh = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nZi = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nZh.setOnClickListener(this);
        this.nZi.setOnClickListener(this);
        this.nZj = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nYY = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nYY.setOnClickListener(this);
        this.nXR = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.nXQ = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nYz = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nYz.setOnClickListener(this);
        this.nYo = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nYo.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nYo.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nYV.x, this.nYV.y) * 0.83d);
        this.nYo.setLayoutParams(layoutParams);
        this.nYr = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.oay);
        this.nYo.setLayoutManager(this.nYr);
        this.nYo.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nYo.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nYo.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.edP();
                } else if (i == 1) {
                    c.this.nYy = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nYw = new com.kascend.chushou.player.adapter.a(this.oay, this.nYs);
        if (this.nYp != null) {
            this.nYw.a(this.nYp);
        }
        if (com.kascend.chushou.b.ecq().c != null) {
            this.nYw.a(com.kascend.chushou.b.ecq().c);
        }
        this.nYo.setAdapter(this.nYw);
        this.nYw.a(this.nYs.size());
        this.nYw.notifyDataSetChanged();
        if (this.oax != null && (c = this.oax.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.nXU != null) {
            this.nXU.a();
            this.nXU = null;
        }
        this.nXT = (GiftAnimationLayout) this.oaj.findViewById(a.f.ll_gift_animation);
        this.nXT.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.nXd = ((int) (tv.chushou.zues.utils.a.hc(this.oay).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.oay, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nXT.getLayoutParams();
        layoutParams2.bottomMargin = this.nXd;
        this.nXT.setLayoutParams(layoutParams2);
        if (this.oax != null) {
            this.nXU = new com.kascend.chushou.player.b.a(this.oay.getApplicationContext(), this.nXT);
            this.nXU.a(this.oax);
            a(this.oax.nTG, this.oax.nTJ);
        }
        this.oaj.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.nXS = (EmbeddedButtonLayout) this.oaj.findViewById(a.f.embedded_button_layout);
        this.nXS.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nZe = (VideoShowVoteView) this.oaj.findViewById(a.f.view_video_show_vote);
        this.nZe.setOnClickListener(this);
        this.nZe.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.oax != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.oay;
            this.nXS.a(videoPlayer.ecU().eeo());
            this.nXS.b(this.oax.i());
            this.nXQ.a(videoPlayer.ecQ(), false);
            this.nXR.a(videoPlayer.ecR(), videoPlayer.ecS(), videoPlayer.ecT());
            this.nUa = new com.kascend.chushou.player.e.a();
        }
        this.obo = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nYJ = false;
                c.this.b(c.this.nXd, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nYJ = true;
                if (c.this.obd != null) {
                    c.this.obd.measure(0, 0);
                    int measuredHeight = c.this.obd.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.oay, 14.0f);
                    if (measuredHeight > c.this.nXd) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.obh = (PaoGuideView) this.oaj.findViewById(a.f.rlPaoGuideView);
        this.nYL = (PlayShowMicPerson) this.oaj.findViewById(a.f.rl_mic_person_view);
        this.nXW = (PlayShowH5View) this.oaj.findViewById(a.f.rl_playshowh5);
        this.nYR = (FoodView) this.oaj.findViewById(a.f.bottom_ad);
        if (this.oax != null) {
            H();
            if (this.oax.nTz != null && !h.isEmpty(this.oax.nTz.mUrl)) {
                b(this.oax.nTz);
            }
        }
        this.nYA = this.oaj.findViewById(a.f.view_reminder_subscribe);
        this.nYB = this.nYA.findViewById(a.f.spash_subscribe);
        ((TextView) this.nYA.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().N(this.oay, a.e.videoplayer_reminder_subscribe).append(" ").append(this.oay.getString(a.i.videoplayer_reminder_subscribe)));
        this.nYA.setOnClickListener(this);
        this.nYD = this.oaj.findViewById(a.f.view_reminder_danmaku);
        this.nYE = this.nYD.findViewById(a.f.spash_danmaku);
        ((TextView) this.nYD.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().N(this.oay, a.e.videoplayer_reminder_danmaku).append(" ").append(this.oay.getString(a.i.videoplayer_reminder_danmaku)));
        this.nYD.setOnClickListener(this);
    }

    private void edw() {
        this.nZo = (RelativeLayout) this.oaj.findViewById(a.f.rl_cyclelive);
        this.nZp = (RelativeLayout) this.oaj.findViewById(a.f.rlrl_cyclelive);
        this.nZq = (FrescoThumbnailView) this.oaj.findViewById(a.f.iv_liveicon);
        this.nZr = (TextView) this.oaj.findViewById(a.f.tv_livename);
        this.nZs = (TextView) this.oaj.findViewById(a.f.tv_livedesc);
        this.nZt = (ImageView) this.oaj.findViewById(a.f.iv_cyclelive_name_menu);
        this.nZu = (RelativeLayout) this.oaj.findViewById(a.f.rl_normal);
        this.nZv = (LinearLayout) this.oaj.findViewById(a.f.ll_cyclelive_nickname);
        this.nZw = (TextView) this.oaj.findViewById(a.f.tv_cyclelive_nickname);
        this.nZx = (TextView) this.oaj.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nZy = (RelativeLayout) this.oaj.findViewById(a.f.rl_clear_cyclelive);
        this.nZz = (RelativeLayout) this.oaj.findViewById(a.f.rlrl_clear_cyclelive);
        this.nZA = (FrescoThumbnailView) this.oaj.findViewById(a.f.iv_clear_liveicon);
        this.nZB = (TextView) this.oaj.findViewById(a.f.tv_clear_livename);
        this.nZC = (TextView) this.oaj.findViewById(a.f.tv_clear_livedesc);
        this.nZD = (ImageView) this.oaj.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nZE = (RelativeLayout) this.oaj.findViewById(a.f.rl_clear_normal);
        this.nZD.setOnClickListener(this);
        this.nZt.setOnClickListener(this);
        this.nZx.setOnClickListener(this);
        this.nZw.setOnClickListener(this);
        this.nZq.setOnClickListener(this);
        this.nZA.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.oax.nTx != null && this.nYR != null) {
            this.nYR.a(true, this.oax.a == null ? "" : this.oax.a);
            this.nYR.a(this.oax.nTx, a.C0879a.slide_in_bottom_danmu_anim, a.C0879a.slide_out_bottom_danmu_anim, true);
        }
        if (this.oax != null && this.oax.nTE != null && this.nXS != null) {
            this.nYP.a(this.oax.nTE, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.oax != null) {
                        c.this.oax.nTE = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a edO() {
        return this.nXU;
    }

    private void edx() {
        this.oaz = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.oaj != null && (textView = (TextView) c.this.oaj.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.oay.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.oaz.C(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.oaz);
                        break;
                    case 12:
                        c.this.b(c.this.oaz);
                        break;
                    case 17:
                        c.this.eej();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.oaw.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nYn) {
            this.nYn = true;
            if (this.nYm == null) {
                this.nYm = this.oaj.findViewById(a.f.vs_async_show_content);
                this.nYm = ((ViewStub) this.nYm).inflate();
            }
            this.nUq = this.oaj.findViewById(a.f.ui_content);
            if (this.nVH == null) {
                this.nVH = this.oaj.findViewById(a.f.vs_async_notification_view);
                this.nVH = ((ViewStub) this.nVH).inflate();
            }
            c(this.oaj);
            k();
            dQK();
            if (this.c == null) {
                this.nTU = new d.a();
                this.c = new GestureDetector(this.oay, this.nTU);
            }
            ((VideoPlayer) this.oay).q();
        }
    }

    private void aL() {
        this.nXj = (LinearLayout) this.oaj.findViewById(a.f.ll_anchor);
        this.nXk = (RelativeLayout) this.oaj.findViewById(a.f.ll_clear_anchor);
        this.nXj.setVisibility(4);
        this.nXk.setVisibility(4);
        this.nXl = (FrescoThumbnailView) this.oaj.findViewById(a.f.iv_clear_avatar);
        this.nXm = (TextView) this.oaj.findViewById(a.f.tv_clear_nickname);
        this.nXn = (TextView) this.oaj.findViewById(a.f.tv_clear_online_count);
        this.nXo = (TextView) this.oaj.findViewById(a.f.tv_clear_btn_subscribe);
        this.nXo.setOnClickListener(this);
        this.nXp = (FrescoThumbnailView) this.oaj.findViewById(a.f.iv_avatar);
        this.nXq = (TextView) this.oaj.findViewById(a.f.tv_nickname_test);
        this.nXr = (TextView) this.oaj.findViewById(a.f.tv_online_count);
        this.nUB = (TextView) this.oaj.findViewById(a.f.tv_btn_subscribe);
        this.nUB.setOnClickListener(this);
        this.nXs = (TextView) this.oaj.findViewById(a.f.tv_loyal_counts);
        this.nUE = (TextView) this.oaj.findViewById(a.f.tv_btn_contribution);
        this.nXt = (TextView) this.oaj.findViewById(a.f.tv_btn_contribution_forpk);
        this.nUE.setVisibility(4);
        this.nXt.setVisibility(8);
        this.nXu = (LinearLayout) this.oaj.findViewById(a.f.ll_mic);
        this.nXv = (PlayShowMicStatusView) this.oaj.findViewById(a.f.show_mic_status);
        this.nXw = (RecyclerView) this.oaj.findViewById(a.f.rv_loyal);
        this.nXx = (ImageView) this.oaj.findViewById(a.f.iv_clear_close);
        this.nUK = (ImageView) this.oaj.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.nXw.setLayoutManager(linearLayoutManager);
        this.nYI = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void D(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.oay, (JSONObject) null, c.this.oax.edl().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1011a view$OnLongClickListenerC1011a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC1011a.rn(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC1011a.rn(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1011a.rn(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.eqg(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.oay, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.oay, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.oay, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.oay, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.oay, a.c.color_979797), dip2px);
                        imageView.setVisibility(8);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score_normal);
                        textView.setTextColor(Color.parseColor("#979797"));
                    }
                    if (TextUtils.isEmpty(onlineVipItem.mScore)) {
                        textView.setVisibility(8);
                    } else if (onlineVipItem.mScore.equals("0")) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(tv.chushou.zues.utils.b.bV(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.nXw.setAdapter(this.nYI);
        this.nXu.setOnClickListener(this);
        this.nXl.setOnClickListener(this);
        this.nXx.setOnClickListener(this);
        this.nXp.setOnClickListener(this);
        this.nXl.setOnClickListener(this);
        this.nUK.setOnClickListener(this);
        this.nXs.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dL(View view) {
                String str = tv.chushou.common.a.cyX() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.oax != null) {
                    str = str + c.this.oax.edl().mRoomID;
                }
                c.this.f(c.this.oay.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nUE.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dL(View view) {
                String str = tv.chushou.common.a.cyX() + "m/room-billboard/";
                if (c.this.oax != null) {
                    str = str + c.this.oax.edl().mRoomID;
                }
                c.this.f(c.this.oay.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.nXt.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dL(View view) {
                String str = tv.chushou.common.a.cyX() + "m/room-billboard/";
                if (c.this.oax != null) {
                    str = str + c.this.oax.edl().mRoomID;
                }
                c.this.f(c.this.oay.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nYq == null || this.nYq.cycleLiveRoomInfo == null || h.isEmpty(this.nYq.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nUd = this.nYq.cycleLiveRoomInfo;
        }
        if (z2 && this.nUd != null) {
            this.nZo.setVisibility(0);
            this.nZy.setVisibility(0);
            this.nZu.setVisibility(8);
            this.nZE.setVisibility(8);
            this.nZv.setVisibility(0);
            this.nZA.h(this.nUd.eventIcon, com.kascend.chushou.view.a.a(this.nYp.mCreatorGender), b.a.small, b.a.small);
            this.nZq.h(this.nUd.eventIcon, com.kascend.chushou.view.a.a(this.nYp.mCreatorGender), b.a.small, b.a.small);
            this.nZB.setText(this.nUd.eventName);
            this.nZC.setText(this.nUd.eventDesc);
            this.nZr.setText(this.nUd.eventName);
            this.nZs.setText(this.nUd.eventDesc);
            this.nZw.setText(this.nUd.nickname);
            edz();
            if (z) {
                c(this.nUd.remainTime);
                return;
            }
            return;
        }
        this.nZo.setVisibility(8);
        this.nZy.setVisibility(8);
        this.nZu.setVisibility(0);
        this.nZE.setVisibility(0);
        this.nZv.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nZF != null) {
            this.nZF.dispose();
            this.nZF = null;
        }
        this.nZF = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.ejb()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Long l) throws Exception {
            }
        }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.e.c.45
            /* JADX DEBUG: Method merged with bridge method */
            @Override // io.reactivex.c.g
            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
            }
        }, new io.reactivex.c.a() { // from class: com.kascend.chushou.player.e.c.56
            @Override // io.reactivex.c.a
            public void run() throws Exception {
                if (c.this.oay != null && (c.this.oay instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.oay).u();
                }
            }
        });
    }

    private void edy() {
        if (this.nYp != null && this.nYn) {
            this.nXj.setVisibility(0);
            this.nXk.setVisibility(0);
            this.nUE.setVisibility(0);
            this.nXl.h(this.nYp.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nYp.mCreatorGender), b.a.small, b.a.small);
            this.nXm.setText(this.nYp.mCreatorNickname);
            this.nXp.h(this.nYp.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nYp.mCreatorGender), b.a.small, b.a.small);
            this.nXq.setText(this.nYp.mCreatorNickname);
            eea();
            edA();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void eea() {
        if (this.nYp != null) {
            this.nXn.setText(tv.chushou.zues.utils.b.formatNumber(this.nYp.mOnlineCount));
            this.nXr.setText(tv.chushou.zues.utils.b.formatNumber(this.nYp.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edz() {
        if (this.nUd != null) {
            if (this.nUd.isSubscribe) {
                this.nZx.setText(a.i.like_already);
                this.nZx.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nZx.setText(getString(a.i.like));
            this.nZx.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edA() {
        if (this.nYp != null) {
            if (this.nYp.mIsSubscribed) {
                this.nXo.setText(getString(a.i.like_already));
                this.nXo.setBackgroundResource(a.e.bg_show_subcribe);
                this.nUB.setText(getString(a.i.like_already));
                this.nUB.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nXo.setText(getString(a.i.like));
            this.nXo.setBackgroundResource(a.e.bg_show_subcribe);
            this.nUB.setText(getString(a.i.like));
            this.nUB.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void edB() {
        if (this.nYI != null) {
            this.nYI.notifyDataSetChanged();
        }
    }

    private void edC() {
        this.nXz = this.oaj.findViewById(a.f.tv_interact);
        this.nXz.setOnClickListener(this);
        this.nXE = (RelativeLayout) this.oaj.findViewById(a.f.rl_edit_bar);
        this.nXC = (ImageView) this.oaj.findViewById(a.f.btn_hotword);
        this.nXC.setOnClickListener(this);
        this.nXD = (ImageView) this.oaj.findViewById(a.f.iv_task_badge);
        this.nXB = (AnimationSet) AnimationUtils.loadAnimation(this.oay, a.C0879a.anim_hotword);
        this.nXB.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.ecy().c) {
                    c.this.nXC.clearAnimation();
                    c.this.nXC.startAnimation(c.this.nXB);
                }
            }
        });
        if (com.kascend.chushou.d.h.ecy().c) {
            this.nXC.startAnimation(this.nXB);
            this.nXD.setVisibility(0);
        }
        this.nZG = (TextView) this.oaj.findViewById(a.f.tv_bottom_input);
        this.nZG.setOnClickListener(this);
        this.obz = (FrescoThumbnailView) this.oaj.findViewById(a.f.ll_btn_set);
        this.obz.setOnClickListener(this);
        this.obz.CL(a.e.ic_room_set_btn_white);
        this.nXN = (LinearLayout) this.oaj.findViewById(a.f.ll_bottom_all_button);
        this.nXO = (FrescoThumbnailView) this.oaj.findViewById(a.f.fl_clear_bottom_gift);
        this.nXO.setAnim(true);
        this.nXO.setOnClickListener(this);
        this.nXO.CL(a.e.ic_show_gift_n);
        this.nXP = (FrameLayout) this.oaj.findViewById(a.f.flfl_clear_bottom_gift);
        this.nXP.setVisibility(8);
        this.nXA = (RelativeLayout) this.oaj.findViewById(a.f.rl_bottom_input);
        this.nXA.setVisibility(0);
        this.nXF = (PastedEditText) this.oaj.findViewById(a.f.et_bottom_input);
        this.nXF.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nUT.setEnabled(editable.length() > 0);
            }
        });
        this.nXF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nUT);
                    return true;
                }
                return true;
            }
        });
        this.nXF.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.nXF);
                }
                return false;
            }
        });
        this.nVc = (ImageView) this.oaj.findViewById(a.f.iv_btn_emoji);
        this.nVc.setVisibility(8);
        this.nUT = (TextView) this.oaj.findViewById(a.f.tv_btn_send);
        this.nUT.setOnClickListener(this);
        this.nXX = (LinearLayout) this.oaj.findViewById(a.f.head_trumpet);
        this.nXX.setVisibility(8);
        this.nXX.setOnClickListener(this);
        this.nXY = (TextView) this.oaj.findViewById(a.f.tv_primary_name);
        this.nXZ = (TextView) this.oaj.findViewById(a.f.tv_primary_desc);
        this.nYb = (TextView) this.oaj.findViewById(a.f.tv_cut_count);
        this.nYb.setOnClickListener(this);
        this.nYd = (TextView) this.oaj.findViewById(a.f.tv_head_count);
        this.nYd.setText(this.nYg + "");
        this.nYc = (TextView) this.oaj.findViewById(a.f.tv_plus_count);
        this.nYc.setOnClickListener(this);
        this.nVt = (TextView) this.oaj.findViewById(a.f.tv_buy_count_coin);
        this.nYa = (TextView) this.oaj.findViewById(a.f.tv_buy_head);
        this.nYa.setOnClickListener(this);
        this.nYe = (ImageView) this.oaj.findViewById(a.f.iv_trumpet_select);
        this.nYe.setOnClickListener(this);
        this.nYf = (TextView) this.oaj.findViewById(a.f.tv_trumpet_have_count);
        this.nYh = false;
        this.nYe.setBackgroundResource(a.e.ic_trumpet_n);
        this.nYf.setVisibility(8);
        this.nVb = (KPSwitchPanelLinearLayout) this.oaj.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nVb, this.nVc, this.nXF, new a.InterfaceC1015a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1015a
            public void yE(boolean z) {
                if (c.this.nVc != null) {
                    if (z) {
                        c.this.nVb.setDirectVisibility(0);
                        c.this.nVc.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nVc.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nVe = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void jm(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.nVc.setImageResource(a.e.cs_emoji_normal);
                    c.this.edE();
                    if (c.this.nZn != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nZn.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ed(c.this.oay);
                        c.this.nZn.setLayoutParams(layoutParams);
                    }
                    if (c.this.nXE != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.nXE.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ed(c.this.oay);
                        c.this.nXE.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nZn != null && c.this.nZn.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nZn.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nZn.setLayoutParams(layoutParams3);
                    c.this.nZn.setVisibility(8);
                }
                if (c.this.nYJ) {
                    c.this.obd.setVisibility(0);
                }
                if (c.this.oay != null && (c.this.oay instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.oay).yD(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.nXE != null && c.this.nVb.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.nXE.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.nXE.setLayoutParams(layoutParams4);
                }
            }
        };
        this.nVd = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nVb, this.nVe, ((VideoPlayer) this.oay).ecP());
        ((VideoPlayer) this.oay).h(((VideoPlayer) this.oay).ecP());
        this.nZn = this.oaj.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nZk = (TextView) this.oaj.findViewById(a.f.btn_room_search);
        this.nZl = (ImageView) this.oaj.findViewById(a.f.iv_room_emoji_delete);
        this.nZm = (EditText) this.oaj.findViewById(a.f.et_room_emoji_search);
        this.nZm.setImeOptions(3);
        this.nZm.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nZk);
                    return true;
                }
                return false;
            }
        });
        this.nZm.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nZk.setEnabled(editable.length() > 0);
                c.this.nZl.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.obd.setEmojiSearchText(editable.toString());
            }
        });
        this.nZk.setOnClickListener(this);
        this.nZl.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aD(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bu(this.nZm);
            this.nZn.setVisibility(0);
            this.nZm.requestFocus();
        } else {
            this.nZn.setVisibility(8);
        }
        if (z2) {
            this.nZm.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edE() {
        int ed = tv.chushou.zues.widget.kpswitch.b.d.ed(this.oay) + tv.chushou.zues.utils.a.dip2px(this.oay, 14.0f);
        if (ed > this.nXd) {
            b(ed, 12);
        }
    }

    private void aS() {
    }

    private void edH() {
        if (this.nYj > 0) {
            View findViewById = this.oaj.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nYj);
        }
        if (this.nYi > 0) {
            View findViewById2 = this.oaj.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nYi, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nYG) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.nTW = ((VideoPlayer) this.oay).ecL();
        this.nTW.a(this);
        if (this.oax.edj() != null) {
            s();
        } else if (this.oak != null) {
            this.oak.setVisibility(0);
        }
        if (this.nTW != null) {
            this.nTW.d();
        }
    }

    private void edI() {
        if ((this.nUa == null || this.nUa.nWR == null || !this.nUa.nWR.mInPKMode) ? false : true) {
            if (this.nXe != null) {
                this.nXe.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nUc.getLayoutParams();
            layoutParams.leftMargin = (this.nYV.x / 2) + tv.chushou.zues.utils.a.dip2px(this.oay, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.nUc.setLayoutParams(layoutParams);
            this.y.setText(this.nUa.nWR.mPkUserNickname);
            this.nUc.setVisibility(0);
            this.nXu.setVisibility(8);
            return;
        }
        if (this.nXe != null) {
            this.nXe.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.nUc.setVisibility(8);
    }

    private void edK() {
        boolean z = false;
        if (this.nUa != null && this.nUa.nWR != null && this.nUa.nWR.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nZg > 0 && this.nYo != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nYo.getLayoutParams();
                if (layoutParams.height != this.nZg) {
                    layoutParams.height = this.nZg;
                    this.nYo.setLayoutParams(layoutParams);
                }
            }
            this.nXd = ((int) (tv.chushou.zues.utils.a.hc(this.oay).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.oay, 84.0f);
            b(this.nXd, 12);
        } else {
            if (this.nYo != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nYo.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.oay, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.oay, 250.0f);
                    this.nYo.setLayoutParams(layoutParams2);
                }
            }
            this.nXd = ((int) (tv.chushou.zues.utils.a.hc(this.oay).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.oay, 84.0f);
            b(this.nXd, 12);
        }
        if (this.nUb != null) {
            this.nUb.a(this.nZg + tv.chushou.zues.utils.a.dip2px(this.oay, 52.0f), this.aq);
        }
        if (this.nUf != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nUf.getLayoutParams();
            layoutParams3.bottomMargin = this.nZg + tv.chushou.zues.utils.a.dip2px(this.oay, 52.0f);
            this.nUf.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aX();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        aX();
    }

    private void edL() {
        edK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) eeh().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oak.getLayoutParams();
        this.nYV = tv.chushou.zues.utils.a.hd(this.oay);
        this.nYU = 86;
        this.dB = (Math.max(this.nYV.x, this.nYV.y) - tv.chushou.zues.utils.a.dip2px(this.oay, (this.nYU + 52) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)) - this.nYi;
        this.nYT = Math.max(this.nYV.x, this.nYV.y) - ((tv.chushou.zues.utils.a.dip2px(this.oay, this.nYU) + this.nYi) * 2);
        if (this.nYW <= 0 || this.nYX <= 0) {
            this.nYW = Math.min(this.nYV.x, this.nYV.y);
            this.nYX = Math.max(this.nYV.x, this.nYV.y);
        }
        this.ar = Math.min(this.nYV.x, this.nYV.y);
        this.aq = (this.ar * this.nYX) / this.nYW;
        boolean z = false;
        if (this.nUa == null || this.nUa.nWR == null) {
            i = 1;
        } else {
            i = this.nUa.nWR.mMode;
            if (this.nUa.nWR.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.nYU = 42;
            if (i == 2) {
                if (this.nYX < this.nYW) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nYW * layoutParams.height) / this.nYX;
                    layoutParams2.height = layoutParams.height;
                    this.aq = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.oay, this.nYU) + this.nYi;
            layoutParams.gravity = 48;
            this.nZg = ((this.nYV.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.oay, (this.nYU + 52) + 64) + this.nYi)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
            aG();
        } else if (this.E) {
            this.nYU = 42;
            if (this.nYX < this.nYW) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nYW * layoutParams.height) / this.nYX;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.oay, this.nYU) + this.nYi;
            layoutParams.gravity = 48;
            this.nZg = ((this.nYV.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.oay, (this.nYU + 52) + 98) + this.nYi)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
            edL();
        } else {
            this.nZg = -1;
            this.nYU = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.oay, this.nYU) + this.nYi;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.nYT) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.oay, this.nYU) + this.nYi;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nYV.x, this.nYV.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nYW) / this.nYX >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nYW) / this.nYX;
                    } else if ((this.ar * this.nYX) / this.nYW >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nYX) / this.nYW;
                    } else {
                        i2 = this.ar;
                        i3 = this.aq;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.aq) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.nYX) / this.nYW > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nYW) / this.nYX;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nYX) / this.nYW;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nYX) / this.nYW;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nYW) / this.nYX;
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(10);
                    }
                    layoutParams2.addRule(13);
                }
                layoutParams2.width = i2;
                layoutParams2.height = i3;
            }
        }
        if (this.oax != null && this.oax.d) {
            layoutParams.width = Math.min(this.nYV.x, this.nYV.y);
            layoutParams.height = Math.max(this.nYV.x, this.nYV.y);
        }
        eeh().setLayoutParams(layoutParams);
        this.oak.setLayoutParams(layoutParams2);
        this.oak.requestLayout();
    }

    private void aY() {
        this.oak = new SurfaceRenderView(this.oay);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.oak;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        eeh().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nYO) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return bh();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return bg();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nZJ != null) {
            this.nZJ.a();
        }
        if (this.oax != null && !h.isEmpty(this.oax.w)) {
            b(this.oax.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nWQ != null) {
            int width = this.nWQ.getWidth();
            int height = this.nWQ.getHeight();
            if (this.nYW != width || this.nYX != height || this.nYW <= 0 || this.nYX <= 0) {
                this.nYW = width;
                this.nYX = height;
                if (this.oak != null) {
                    this.oak.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.aX();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ab() {
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.iv_close || id == a.f.iv_clear_close) {
            g();
        } else if (id == a.f.tv_bottom_input) {
            u(true);
        } else if (id == a.f.fl_clear_bottom_gift) {
            if (this.nYJ) {
                edN();
            } else {
                if (this.oay.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.oay, "点击送礼_num", "竖屏", new Object[0]);
                if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.oax.edj().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nYh) {
                f(this.nXF.getText().toString());
            } else {
                a(this.nXF.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.ecy().c) {
                com.kascend.chushou.d.h.ecy().b(false);
                this.nXB.cancel();
                this.nXB.reset();
                this.nXC.clearAnimation();
                this.nXD.setVisibility(8);
            }
            n(view, 0, this.oaj.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.oay, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.oaj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.oax.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.oax.d) {
                dQD();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nYo != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nYp != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nYN = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.oay, (JSONObject) null, this.oax.edl().mRoomID, this.oax.edl().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        } else if (id == a.f.ftv_pack) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(8, null));
        } else if (id == a.f.view_reminder_subscribe) {
            a(false);
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            hashMap2.put("_fromPos", "73");
            b(hashMap2);
        } else if (id == a.f.view_reminder_danmaku) {
            y(false);
            a(this.oay.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.oay, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nYQ != null) {
                    com.kascend.chushou.d.e.a(this.oay, this.nYQ, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nZj != null) {
                    this.nZj.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.oay, null) && this.oax != null && this.oax.nTI != null) {
                    if (this.nYh) {
                        bo();
                    } else {
                        if (this.oax != null && this.oax.nTI != null && this.oax.nTI.count > 0) {
                            this.nXX.setVisibility(8);
                        } else {
                            this.nXX.setVisibility(0);
                        }
                        this.nYh = true;
                        this.nYe.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nYf.setVisibility(0);
                        this.nYf.setSelected(true);
                        this.nYf.setTextColor(Color.parseColor("#ff5959"));
                        if (this.nXF != null) {
                            this.nXF.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nYg <= 9) {
                    this.nYg++;
                    this.nYd.setText(this.nYg + "");
                }
                edv();
            } else if (id == a.f.tv_cut_count) {
                if (this.nYg > 1) {
                    this.nYg--;
                    this.nYd.setText(this.nYg + "");
                }
                edv();
            } else if (id == a.f.tv_buy_head) {
                eef();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nZm.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nZm.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nZn.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dV(this.nZm);
                    this.obd.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nUd != null && !h.isEmpty(this.nUd.eventUrl)) {
                    f("", this.nUd.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nUd != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nUd != null) {
                    com.kascend.chushou.d.a.a(this.oay, (JSONObject) null, this.nUd.roomId, this.nUd.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.oax.a(false);
                    ((VideoPlayer) this.oay).l();
                } else {
                    ((VideoPlayer) this.oay).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.nXW != null) {
            int i = (tv.chushou.zues.utils.a.hc(this.oay).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nXW.getLayoutParams();
            layoutParams.topMargin = i;
            this.nXW.setLayoutParams(layoutParams);
            this.nXW.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.nXW.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Pk(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nYM <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.Pk(a.i.str_too_fast);
            return false;
        } else {
            dQP();
            if (!com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a(((VideoPlayer) this.oay).ecK().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nYM = System.currentTimeMillis();
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                a(this.oax.edj().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.oax.h);
            }
            g(this.b);
            if (!z && this.nXF != null) {
                this.nXF.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dQP();
            if (com.kascend.chushou.d.e.c(this.oay, null) && LoginManager.Instance().getUserInfo() != null && this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                a(this.oax.edj().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nXF != null) {
                this.nXF.setText((CharSequence) null);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void c(String str) {
        super.c(str);
        g(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(String str) {
        String str2;
        if (!h.isEmpty(str)) {
            ArrayList<ChatInfo> arrayList = new ArrayList<>();
            ChatInfo chatInfo = new ChatInfo();
            MyUserInfo userInfo = LoginManager.Instance().getUserInfo();
            chatInfo.mContent = str;
            chatInfo.mGender = userInfo.mGender;
            chatInfo.mHeadIcon = userInfo.mHeadiconUrl;
            chatInfo.mUserNickname = userInfo.mNickname;
            chatInfo.mType = "1";
            chatInfo.mUserID = String.valueOf(userInfo.mUserID);
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.oax.edj().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.oax.edj().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.oay).nRX;
            if (privilegeInfo != null) {
                chatInfo.mPrivilegeInfo = privilegeInfo;
                chatInfo.mNicknameRichText = privilegeInfo.mRichNickname;
                if (!h.isEmpty(chatInfo.mNicknameRichText)) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<RichText> it = chatInfo.mNicknameRichText.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().mContent);
                    }
                    String sb2 = sb.toString();
                    if (!h.isEmpty(sb2)) {
                        chatInfo.mUserNickname = sb2;
                        str2 = sb2;
                        if (privilegeInfo != null) {
                            ColorPrivileges colorPrivileges = privilegeInfo.mColorPrivileges;
                            if (colorPrivileges != null && !h.isEmpty(colorPrivileges.mColors)) {
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                            }
                            chatInfo.mCoolNickname = privilegeInfo.mCoolNickname;
                            if (chatInfo.mCoolNickname != null) {
                                chatInfo.mCoolNickname.mNickName = str2;
                                for (int i = 0; i < chatInfo.mCoolNickname.mNicknameRichText.size(); i++) {
                                    chatInfo.mCoolNickname.mNicknameRichText.get(i).mContent = str2;
                                }
                            }
                            chatInfo.mCoolContent = privilegeInfo.mCoolContent;
                            if (chatInfo.mCoolContent != null) {
                                chatInfo.mCoolContent.mContent = str;
                                if (chatInfo.mCoolContent.mContentRichText.size() == 1) {
                                    for (int i2 = 0; i2 < chatInfo.mCoolContent.mContentRichText.size(); i2++) {
                                        chatInfo.mCoolContent.mContentRichText.get(i2).mContent = str;
                                    }
                                }
                            }
                            chatInfo.mCoolMessage = privilegeInfo.mCoolMessage;
                            if (chatInfo.mCoolMessage != null) {
                                if (chatInfo.mCoolMessage.mContentRichText.size() == 1) {
                                    for (int i3 = 0; i3 < chatInfo.mCoolMessage.mContentRichText.size(); i3++) {
                                        chatInfo.mCoolMessage.mContentRichText.get(i3).mContent = str;
                                    }
                                }
                                for (int i4 = 0; i4 < chatInfo.mCoolMessage.mNicknameRichText.size(); i4++) {
                                    chatInfo.mCoolMessage.mNicknameRichText.get(i4).mContent = str2;
                                }
                            }
                        }
                        arrayList.add(chatInfo);
                        a(arrayList, true, true);
                    }
                }
            }
            str2 = str3;
            if (privilegeInfo != null) {
            }
            arrayList.add(chatInfo);
            a(arrayList, true, true);
        }
    }

    private void m(View view, int i, int i2) {
        if (this.oaY != null && this.oaY.isShowing()) {
            this.oaY.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
        if (this.obw == null) {
            i(3);
        }
        this.obw.getContentView().setBackgroundResource(0);
        this.obw.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.obw.isShowing()) {
            this.obw.showAtLocation(view, 83, i, i2);
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.oax.edj().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.obw.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.obA)) {
            if (((VideoPlayer) this.oay).q) {
                this.obz.CL(a.e.ic_room_set_btn_white);
            } else {
                this.obz.CL(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.oay).q && this.obA.size() == 2 && this.obA.contains("4") && this.obA.contains("2")) {
            this.obz.CL(a.e.ic_room_set_btn_system_white);
        } else if (this.obA.size() > 1 || !((VideoPlayer) this.oay).q) {
            this.obz.CL(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.obA.get(0))) {
            this.obz.CL(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.obA.get(0))) {
            this.obz.CL(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.obA.get(0))) {
            this.obz.CL(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
        if (this.oaY == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.oaY.getContentView().setBackgroundResource(0);
            this.oaY.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.oaY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nXC.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.oaY.isShowing()) {
            this.oaY.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.oay, 16.0f) + i2);
            this.nXC.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.oax.edj().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.oaY.dismiss();
    }

    private void e(View view) {
        if (this.oaS == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.ecy().q()) {
            this.nXG.eqe();
        } else {
            this.nXG.eqf();
        }
        int height = this.oaj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (view != null) {
            this.oaS.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.oaS == null) {
            View inflate = LayoutInflater.from(this.oay).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.nXG = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.ecy().q()) {
                this.nXG.eqe();
            } else {
                this.nXG.eqf();
            }
            this.nXG.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.ecy().g(z);
                }
            });
            this.oaM = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.oaN = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.oaM.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.oaM.setVisibility(0);
            } else {
                this.oaM.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.ecy().a) {
                this.oaN.b();
            } else {
                this.oaN.c();
            }
            if (this.oax != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.oax.f;
                if (arrayList != null && arrayList.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        final PlayUrl playUrl = arrayList.get(i2);
                        if (playUrl != null) {
                            int i3 = a.h.definition_item_show;
                            if ("2".equals(playUrl.mType)) {
                                if (this.nUa == null || !this.nUa.nWR.mInPKMode || h.isEmpty(this.nUa.b) || this.nYp == null || !this.nUa.b.equals(this.nYp.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.oay).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl edk = this.oax.edk();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.oay).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.oay, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.oay, 5.0f);
                                            }
                                            int identifier = this.oay.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.oay.getPackageName());
                                            if (identifier > 0) {
                                                radioButton.setId(identifier);
                                                radioButton.setLayoutParams(layoutParams);
                                                radioButton.setTag(playUrl);
                                                radioButton.setText(urlDetails.mDefinitionName);
                                                radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.e.c.13
                                                    @Override // android.view.View.OnClickListener
                                                    public void onClick(View view) {
                                                        c.this.a(view, linearLayout, playUrl.mName, urlDetails);
                                                    }
                                                });
                                                radioGroup.addView(radioButton);
                                                if (edk != null && edk.mSelectedUrl.equals(urlDetails.mUrl)) {
                                                    radioGroup.check(radioButton.getId());
                                                }
                                            }
                                        }
                                        i4 = i5 + 1;
                                    }
                                    linearLayout.addView(inflate2);
                                    if (i2 == arrayList.size() - 1) {
                                        inflate2.findViewById(a.f.diliver).setVisibility(8);
                                    } else {
                                        inflate2.findViewById(a.f.diliver).setVisibility(0);
                                    }
                                }
                            } else {
                                if (this.oay.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.oay).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl edk2 = this.oax.edk();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.oay).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.oay, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.oay, 5.0f);
                                        }
                                        int identifier2 = this.oay.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.oay.getPackageName());
                                        if (identifier2 > 0) {
                                            radioButton2.setId(identifier2);
                                            radioButton2.setLayoutParams(layoutParams2);
                                            radioButton2.setTag(playUrl);
                                            radioButton2.setText(urlDetails2.mDefinitionName);
                                            radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.e.c.14
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view) {
                                                    c.this.a(view, linearLayout, playUrl.mName, urlDetails2);
                                                }
                                            });
                                            radioGroup2.addView(radioButton2);
                                            if (edk2 != null && edk2.mSelectedUrl.equals(urlDetails2.mUrl)) {
                                                radioGroup2.check(radioButton2.getId());
                                            }
                                        }
                                    }
                                    i6 = i7 + 1;
                                }
                                linearLayout.addView(inflate3);
                                if (i2 == arrayList.size() - 1) {
                                    inflate3.findViewById(a.f.diliver).setVisibility(8);
                                } else {
                                    inflate3.findViewById(a.f.diliver).setVisibility(0);
                                }
                            }
                        }
                        i = i2 + 1;
                    }
                }
            }
            inflate.findViewById(a.f.rl_report).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.e.c.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.kascend.chushou.d.e.c(c.this.getActivity(), null)) {
                        c.this.bb();
                        c.this.oaS.dismiss();
                    }
                }
            });
            this.oaS = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 150.0f), -2);
            this.oaS.setFocusable(true);
            this.oaS.setOutsideTouchable(true);
            this.oaS.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.oaS.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.oaS = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
            if (this.nXV == null) {
                this.nXV = new f(getActivity());
            }
            this.nXV.a(this.oax.edj().mRoominfo, this.ax);
            if (!this.nXV.isShowing()) {
                this.nXV.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nYO) {
            return false;
        }
        if (this.nYN == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nZH = motionEvent.getX();
                    this.nZI = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nZH;
                    if (Math.abs(f) > Math.abs(y - this.nZI) && Math.abs(f) > q && f > 0.0f) {
                        eec();
                        return true;
                    }
                    this.nZH = 0.0f;
                    this.nZI = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nZn != null && this.nZn.getVisibility() == 0 && a(motionEvent, this.nZn)) {
                this.nZn.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dV(this.nZm);
                return true;
            } else if (this.nYJ && this.nZn != null && this.nZn.getVisibility() == 8 && f(this.obd.b, motionEvent)) {
                edN();
                return true;
            } else if (this.nXW != null && this.nXW.b() && f(this.nXW, motionEvent)) {
                this.nXW.a();
                return true;
            } else if (this.nXM != null && this.nXM.b() && f(this.nXM, motionEvent)) {
                this.nXM.a();
                return true;
            } else if (a(motionEvent, this.nXE)) {
                return dQP();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean a(MotionEvent motionEvent, View view) {
        if (view != null) {
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            return motionEvent.getY() <= ((float) iArr[1]);
        }
        return true;
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.obq != null && this.obq.a(i, keyEvent)) {
                return true;
            }
            if ((this.nXW != null && this.nXW.onKeyDown(i, keyEvent)) || edF()) {
                return true;
            }
            if (this.nYN == 3) {
                this.nYN = 1;
                eec();
                return true;
            } else if (this.nXM != null && this.nXM.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nXF != null && this.nXA != null && this.nXE != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bu(this.nXF);
                this.nXA.setVisibility(8);
                this.nXE.setVisibility(0);
            }
        } else if (this.nXA != null && this.nXE != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
            this.nXA.setVisibility(0);
            this.nXE.setVisibility(8);
        }
    }

    public boolean dQP() {
        boolean z;
        b(this.nXd, 12);
        boolean z2 = false;
        if (this.nVb != null && this.nVb.getVisibility() == 0) {
            this.nVb.setVisibility(8);
            this.nVc.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.oay);
            this.nVc.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nXE == null || this.nXE.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nYh) {
                bo();
            }
            this.nXE.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.nXA != null) {
                    c.this.nXA.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean edF() {
        if (dQP()) {
            return true;
        }
        if (this.oaY != null && this.oaY.isShowing()) {
            this.oaY.dismiss();
            return true;
        } else if (this.obw != null && this.obw.isShowing()) {
            this.obw.dismiss();
            return true;
        } else if (this.oaS == null || !this.oaS.isShowing()) {
            return edN() || edG() || edM() || edu();
        } else {
            this.oaS.dismiss();
            return true;
        }
    }

    public boolean edu() {
        if (this.obh == null || !this.obh.isShown()) {
            return false;
        }
        this.obh.d();
        return true;
    }

    public boolean edG() {
        if (this.nYL == null || !this.nYL.isShown()) {
            return false;
        }
        this.nYL.a();
        return true;
    }

    public boolean edM() {
        if (this.nXW == null || !this.nXW.b()) {
            return false;
        }
        this.nXW.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.oay != null && !((Activity) this.oay).isFinishing() && pVar != null) {
            this.nYx = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nYp != null && mVar.a(this.nYp.mCreatorUID, null)) {
            this.nYp.mIsSubscribed = mVar.c;
            edA();
        }
    }

    public boolean edN() {
        if (!this.nYJ || this.obd == null) {
            return false;
        }
        if (this.obd != null) {
            this.obd.e();
        }
        if (this.nZm != null) {
            this.nZm.setText("");
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:266:0x0666  */
    @Override // com.kascend.chushou.widget.a.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ParserRet parserRet) {
        ArrayList<ChatInfo> arrayList;
        boolean z;
        String str;
        String str2;
        boolean z2;
        boolean z3;
        if (!aa() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nYS != null) {
                        this.nYS.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                        this.oax.edj().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.oax.edj().mMicStatus.onMic) {
                            if (this.nXu != null) {
                                this.nXu.setVisibility(8);
                            }
                            if (this.nYL != null && this.nYL.isShown()) {
                                this.nYL.a();
                            }
                            if (this.E) {
                                this.E = false;
                                u();
                                b(false);
                                if (getActivity() instanceof VideoPlayer) {
                                    ((VideoPlayer) getActivity()).b(true);
                                }
                            }
                        }
                        if (this.oax.edj().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nYp != null && !h.isEmpty(this.nYp.mCreatorUID)) {
                                g(arrayList2, this.nYp.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.oax.edj().mMicStatus.onMic) {
                            if (this.oax.edj().mMicStatus != null && !h.isEmpty(this.oax.edj().mMicStatus.micRoomId) && !this.oax.edj().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.oax.edj().mMicStatus.micRoomId;
                            }
                            this.oax.edj().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.oax.edj().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.oax.edj().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.oax.edj().mMicStatus, str3, z4);
                            if (this.nYL != null && this.nYL.getVisibility() == 0) {
                                this.nYL.a(this.oax.edj().mFanItems, this.oax.edj().mMicStatus, str3, z4, this.oax.edj().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nXu != null) {
                                this.nXu.setVisibility(8);
                            }
                            if (this.nYL != null && this.nYL.isShown()) {
                                this.nYL.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nYl != onlineVip.mCount || (this.nXs != null && this.nXs.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nYl = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        edS();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.bv.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.bv.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.bv.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.nZd <= 5000) {
                                z2 = false;
                            } else {
                                this.nZd = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.bv.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.bv.addAll(onlineVip.mOnlineVipItems);
                            }
                            edB();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nZe != null) {
                    if (this.nYp == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nYp.mCreatorAvatar;
                        str2 = this.nYp.mCreatorGender;
                    }
                    this.nZe.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nUa != null && this.nUa.nWR != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nUa.nWR.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.nTW != null) {
                                        this.nTW.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nUa.nWR.mInPKMode = true;
                                    this.nUa.nWR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nUa.nWR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nUa.nWR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nUa.nWR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nUa.nWR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nUa.nWR.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nUa.nWR.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nUa.nWR.mMode = pkNotifyInfo.mMode;
                                    this.nUa.nWR.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.nUb != null) {
                                        this.nUb.h(true, this.nUa.nWR.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.ecy().a) {
                                        if (!com.kascend.chushou.b.ecq().e) {
                                            com.kascend.chushou.b.ecq().e = true;
                                            tv.chushou.zues.utils.g.K(this.oay, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.ecy().a(this.oay, false);
                                        edJ();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.nUa.nWR.mAction = 7;
                                    this.nUa.nWR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nUa.nWR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nUa.nWR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nUa.nWR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nUa.nWR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nUa.nWR.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.nUa.nWR.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.nUb != null) {
                                        this.nUb.h(false, 0L);
                                        this.nUb.b(this.nUa.nWR, true);
                                        this.nUb.a(this.nZg + tv.chushou.zues.utils.a.dip2px(this.oay, 52.0f), this.aq);
                                        this.nUb.a(this.nUa.nWR.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.nTW != null) {
                                        this.nTW.a(false);
                                    }
                                    this.nUa.nWR.mInPKMode = false;
                                    this.nUa.nWR.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.nUb != null) {
                                        this.nUb.c();
                                    }
                                    this.nUa.b = null;
                                    this.nUa.nWR = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nUa.nWR.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nUa.nWR.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.nUa.nWR.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nYp != null && !h.isEmpty(this.nYp.mRoomID) && this.nYp.mRoomID.equals(this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.nUa.nWR.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.nUb != null) {
                                        this.nUb.a(this.nUa.nWR, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nUa.nWR.copyUpdate(pkNotifyInfo);
                                    if (this.nUb != null) {
                                        this.nUb.a(this.nUa.nWR);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nUa.nWR.copyStop(pkNotifyInfo);
                                        if (this.nUb != null) {
                                            this.nUb.E(this.nUa.nWR.mMaxFreeDuration, this.nUa.nWR.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nUa.nWR.copyResult(pkNotifyInfo);
                                    if (!this.nYH && this.nUb != null) {
                                        int i7 = 1;
                                        if (this.nUa.nWR.destinyInfo != null && this.nUa.nWR.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.nUb.a(h.parseInt(this.nUa.nWR.mResult), h.parseLong(this.nUa.nWR.mvpUid), this.nUa.nWR.mvpAvatar, this.nUa.nWR.mvpNickname, this.nUa.nWR.mMaxFreeDuration, this.nUa.nWR.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nUd != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nUd.uid = cycleLiveRoomInfo.uid;
                        this.nUd.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nUd.roomId = cycleLiveRoomInfo.roomId;
                        this.nUd.avatar = cycleLiveRoomInfo.avatar;
                        this.nUd.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.oay != null && (this.oay instanceof VideoPlayer)) {
                            ((VideoPlayer) this.oay).d();
                        }
                    } else {
                        ((VideoPlayer) this.oay).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.oax != null && this.oax.l()) {
                    Iterator<ChatInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ChatInfo next = it.next();
                        if ("1".equals(next.mType) || "3".equals(next.mType)) {
                            z = false;
                            break;
                        }
                        while (it.hasNext()) {
                        }
                    }
                    z = true;
                    d(z);
                }
                Iterator<ChatInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ChatInfo next2 = it2.next();
                    if (next2 == null) {
                        it2.remove();
                    } else {
                        if (!h.isEmpty(com.kascend.chushou.d.h.ecy().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.ecy().b().equals(next2.mUserID)) {
                            it2.remove();
                        }
                        if ("3".equals(next2.mType)) {
                            GiftInfo giftInfo = next2.mGift;
                            if (next2.giftType != 2 && giftInfo != null && giftInfo.id != -1 && giftInfo.point < 20000) {
                                it2.remove();
                            }
                        }
                    }
                }
                a(arrayList, true, false);
            }
        }
    }

    public void edS() {
        if (this.nXs != null) {
            if (this.nUa == null || this.nUa.nWR == null || !this.nUa.nWR.mInPKMode) {
                if (this.bP > 0) {
                    this.nXs.setVisibility(0);
                    this.nXs.setText(String.format(this.oay.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.nXw.setVisibility(0);
                    return;
                }
                this.nXs.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.nXu.setVisibility(0);
            if (this.nXv != null) {
                this.nXv.a(str, z, micStatus, this.oax.edj().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.nXu.setVisibility(8);
    }

    private boolean h(ArrayList<FanItem> arrayList, String str) {
        if (h.isEmpty(arrayList) || h.isEmpty(str)) {
            return false;
        }
        Iterator<FanItem> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().mUserId)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edP() {
        int childCount = this.nYr.getChildCount();
        int itemCount = this.nYr.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nYr);
        if (f + childCount >= itemCount) {
            this.nYy = true;
            if (this.nYz != null) {
                this.nYz.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void edY() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nYs.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nYs.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nYs == null) {
            this.nYs = new ArrayList<>();
        }
        while (2 < this.nYs.size()) {
            this.nYs.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nYu);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nYs.addAll(a2);
        int size = this.nYs.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nYs.size(); i++) {
                this.nYs.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nYv == null) {
            this.nYv = new ArrayList<>();
        }
        this.nYv.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nYx != null && this.nYx.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nYx.contains("2"))) {
                        this.nYv.add(next);
                    } else if (!this.nYx.contains(next.mType)) {
                        this.nYv.add(next);
                    }
                }
                return this.nYv;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nYs == null) {
                    this.nYs = new ArrayList<>(arrayList);
                    edY();
                    w(z2);
                    return;
                }
                if (this.nYu == null) {
                    this.nYu = new ArrayList<>();
                }
                this.nYu.addAll(arrayList);
                int size = this.nYu.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.nYu.size(); i++) {
                        this.nYu.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nYs.size();
                if (a2 != null) {
                    this.nYs.addAll(a2);
                }
                int size3 = this.nYs.size();
                if (!this.nYy && this.nYz != null) {
                    this.nYz.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nYs.size(); i3++) {
                        this.nYs.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nYs == null) {
                this.nYs = new ArrayList<>(arrayList);
                edY();
            } else {
                if (this.nYu == null) {
                    this.nYu = new ArrayList<>();
                }
                this.nYu.clear();
                this.nYu.addAll(arrayList);
                this.nYs.clear();
                edY();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nYs.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nYw != null) {
                this.nYw.a(this.nYs.size());
                if (i == 1) {
                    this.nYw.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nYw.notifyItemRangeRemoved(i2, i3);
                    this.nYw.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nYw.notifyDataSetChanged();
                }
            }
            if (z || this.nYy) {
                this.nYy = true;
                if (this.nYz != null) {
                    this.nYz.setVisibility(8);
                }
                if (z) {
                    this.nYo.scrollToPosition(this.nYs.size() - 1);
                } else {
                    this.nYo.smoothScrollToPosition(this.nYs.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nYw != null) {
                this.nYw.a(this.nYs.size());
                this.nYw.notifyDataSetChanged();
            }
            if (z || this.nYy) {
                this.nYy = true;
                if (this.nYz != null) {
                    this.nYz.setVisibility(8);
                }
                if (z) {
                    this.nYo.scrollToPosition(this.nYs.size() - 1);
                } else {
                    this.nYo.smoothScrollToPosition(this.nYs.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a ecV;
        RoomToast roomToast;
        this.p = false;
        if (this.oax != null && this.oax.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.oax.f.size()) {
                    break;
                } else if (!"2".equals(this.oax.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            eeb();
            return;
        }
        if (this.nUq != null) {
            this.nUq.setVisibility(0);
        }
        if (this.nXi != null) {
            this.nXi.setVisibility(0);
        }
        if (this.oax != null) {
            this.nYp = this.oax.edl();
            this.nYq = this.oax.edj();
            if (com.kascend.chushou.b.ecq().c != null && this.nYw != null) {
                this.nYw.a(com.kascend.chushou.b.ecq().c);
                this.nYw.notifyDataSetChanged();
            }
            FullRoomInfo edj = this.oax.edj();
            if (edj != null) {
                if (!h.isEmpty(edj.mRoomToastList)) {
                    Iterator<RoomToast> it = edj.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.ecy().j())) {
                    a(roomToast);
                }
            }
            if (this.nYp != null) {
                bk();
            }
            if (this.nYp != null && !this.nYp.mIsSubscribed) {
                RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nYp == null || !c.this.nYp.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.oax != null && this.oax.l()) {
                d(true);
            }
        }
        if (this.nYp != null && this.nYw != null) {
            if (this.nYs != null) {
                this.nYs.clear();
            } else {
                this.nYs = new ArrayList<>();
            }
            this.nYw.a(this.nYp);
            edY();
            this.nYw.a(this.nYs.size());
            this.nYw.notifyDataSetChanged();
        }
        edy();
        N();
        if (this.oay != null && (this.oay instanceof VideoPlayer) && (ecV = ((VideoPlayer) this.oay).ecV()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(ecV.nWR, ecV.b);
        }
        this.nXJ.h(this.nYp.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nYp.mCreatorGender), 0, 0);
        if (this.oak != null) {
            this.oak.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.nXN);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void edQ() {
        if (this.nYk == null) {
            View inflate = LayoutInflater.from(this.oay).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nVE = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nYk = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.oay, 160.0f), -2);
            this.nYk.setFocusable(false);
            this.nYk.setOutsideTouchable(false);
            this.nYk.setAnimationStyle(a.j.gift_toast_style);
            this.nYk.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.ecy().c(roomToast.mToastContent);
            if (this.nYk == null) {
                edQ();
            }
            if (this.nVE != null) {
                this.nVE.setText(roomToast.mToastContent);
            }
            if (!this.nYk.isShowing()) {
                if (this.nXN != null) {
                    this.nYk.showAtLocation(this.nXN, 85, 0, this.oaj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
                    RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nYk != null) {
                                c.this.nYk.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nYk.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nYZ != null) {
            this.nYZ.setVisibility(z ? 0 : 8);
        }
        this.nZa = true;
        if (this.oay instanceof VideoPlayer) {
            ((VideoPlayer) this.oay).p();
        }
    }

    private void eeb() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.oay).s();
        edu();
        edG();
        if (this.nXy == null) {
            this.nXy = (PlayShowRecommendView) ((ViewStub) this.oaj.findViewById(a.f.view_recommend)).inflate();
        }
        this.nXy.setVisibility(0);
        if (this.oax.edj() != null && this.oax.edj().mRoominfo != null && !h.isEmpty(this.oax.edj().mRoominfo.mRoomID)) {
            edT();
        }
        if (this.oak != null) {
            this.oak.setVisibility(8);
        }
        if (this.obd != null) {
            this.obd.e();
        }
        if (this.nUq != null) {
            this.nUq.setVisibility(4);
        }
        if (this.nXi != null) {
            this.nXi.setVisibility(8);
        }
        if (this.obm != null) {
            this.obm.epC();
            this.obm.setVisibility(8);
        }
        yG(false);
        a(false, false);
        if (this.nTW != null) {
            this.nTW.a();
        }
    }

    private void edT() {
        if (this.nXy != null && this.nXy.getVisibility() == 0) {
            this.nXy.a(this.oax.edj().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
                @Override // com.kascend.chushou.widget.showplayer.PlayShowRecommendView.a
                public void a(View view) {
                    if (view.getId() == a.f.iv_close) {
                        c.this.g();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void ac() {
        super.ac();
        if (this.oay instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.oay;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.nXW != null && this.nXW.b()) {
            this.nXW.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nYK);
        if (this.oay != null) {
            if (this.nYK || "10004".equals(((VideoPlayer) this.oay).t)) {
                this.nYK = true;
                if (this.oax != null) {
                    this.oax.f = null;
                    if (this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                        this.oax.edj().mRoominfo.mGameId = null;
                    }
                }
                eeb();
                return;
            }
            this.nYK = true;
            if (this.oay != null) {
                ((VideoPlayer) this.oay).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nYK = false;
        if (this.nUq != null) {
            this.nUq.setVisibility(0);
        }
        if (this.nXi != null) {
            this.nXi.setVisibility(0);
        }
        if (this.nXy != null) {
            this.nXy.setVisibility(8);
        }
        if (this.oas != null) {
            this.oas.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nYK = false;
        if (this.nUq != null) {
            this.nUq.setVisibility(0);
        }
        if (this.nXi != null) {
            this.nXi.setVisibility(0);
        }
        if (this.nXy != null) {
            this.nXy.setVisibility(8);
        }
        if (this.oas != null) {
            this.oas.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nXy != null) {
            this.nXy.setVisibility(8);
        }
        if (this.oak != null) {
            this.oak.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.oax != null) {
                        this.oax.f = null;
                        this.oax.edj().mRoominfo.mGameId = null;
                    }
                    eeb();
                    return;
                }
                tv.chushou.zues.utils.g.Pk(a.i.str_getvideosource_failed);
            }
            yG(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.oax != null && this.oax.edk() != null) {
            a(this.oax.edk());
        }
        this.p = false;
        if (this.oax == null || this.oax.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.oax.f.size()) {
                if (!"2".equals(this.oax.f.get(i2).mType)) {
                    i = i2 + 1;
                } else {
                    this.p = true;
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public GiftAnimationLayout edD() {
        if (this.oaj == null) {
            return null;
        }
        return (GiftAnimationLayout) this.oaj.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nXN != null) {
            int size = iconConfig.configs.size();
            this.nXN.removeAllViews();
            if (this.nXP != null) {
                this.nXP.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.oay).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.nXN, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bX(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.bX(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bX(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.nXP.setVisibility(0);
                            this.nXO.bX(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.bX(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.bX(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.bX(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void dL(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.nXN.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void D() {
        if (this.oay instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a ecQ = ((VideoPlayer) this.oay).ecQ();
            if (this.obq == null) {
                this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.obq.setVisibility(0);
            this.obq.a(2, ecQ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nXR != null && this.oay != null) {
            this.nXR.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nXR != null && this.oay != null) {
            this.nXR.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(long j) {
        if (this.nXR != null) {
            this.nXR.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0892a
    public void c(int i) {
        if (this.nXR != null) {
            this.nXR.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void a(int i) {
        if (this.nXQ != null) {
            if (this.oay != null) {
                this.nXQ.a(((VideoPlayer) this.oay).ecQ(), false);
            }
            this.nXQ.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.oaj != null) {
            Point hc = tv.chushou.zues.utils.a.hc(this.oay);
            int i = hc.x > hc.y ? 1 : 2;
            if (this.obq == null) {
                this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.obq.setPlayerViewHelper(this.oax);
            this.obq.setVisibility(0);
            this.obq.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nXS != null) {
            this.nXS.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nXS != null) {
            this.nXS.a(bangInfo, str);
        }
        if (this.nUE != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nUE.setText(this.oay.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nUE.setText(this.oay.getString(a.i.str_contribute_tittle));
            } else {
                this.nUE.setText(Html.fromHtml(this.oay.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.nXt != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nXt.setText(this.oay.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nXt.setText(this.oay.getString(a.i.str_contribute_tittle));
            } else {
                this.nXt.setText(Html.fromHtml(this.oay.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nXS != null) {
            this.nXS.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.oax != null && !h.isEmpty(this.oax.nTH)) {
            this.nYQ = this.oax.nTH.get(0);
            if (this.nZh != null) {
                this.nZh.setVisibility(0);
                this.nZh.a(this.nYQ.mCover, 0, 0, 0, 1);
                if (this.nZi != null) {
                    if (this.nYQ.mShowClose) {
                        this.nZi.setVisibility(0);
                    } else {
                        this.nZi.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nXS != null) {
            this.nXS.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.oaj != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nVb != null) {
            this.nVb.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nYH) {
            if (iVar.a == 52) {
                if (this.nYw != null) {
                    this.nYw.a(com.kascend.chushou.b.ecq().c);
                    this.nYw.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nYH && (iVar.b instanceof ListItem)) {
                    ListItem listItem = (ListItem) iVar.b;
                    if (!h.isEmpty(listItem.mUrl)) {
                        b(listItem);
                    }
                }
            } else if (iVar.a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.nXF != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.nXF);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nYH) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.oay, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b ecR = ((VideoPlayer) this.oay).ecR();
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(2, ecR);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a ecS = ((VideoPlayer) this.oay).ecS();
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(2, ecS);
            } else if (bVar.a == 8) {
                if (this.nYS != null && this.nYS.getVisibility() != 0) {
                    this.nYS.a(a.C0879a.slide_in_bottom_danmu_anim, a.C0879a.slide_out_bottom_danmu_anim, this.nYp == null ? "" : this.nYp.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.obq == null) {
                    this.obq = (H5Container) ((ViewStub) this.oaj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.obq.setVisibility(0);
                this.obq.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.oax != null && !h.isEmpty(this.oax.a) && this.oax.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nYS != null && this.nYS.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.oay, 80.0f);
                }
                if (this.nYR != null && this.nYR.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nYR.getHeight());
                }
                this.nZc.setTranslationY(-r0);
                return;
            }
            if (this.nZb != null) {
                this.nZb.cancel();
                this.nZb = null;
            }
            int translationY = (int) this.nZc.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.oay, 80.0f) : 0;
                    if (this.nYR != null && this.nYR.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nYR.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nYR.getHeight() : 0;
                    if (this.nYS != null && this.nYS.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.oay, 80.0f));
                    }
                }
                int i = -r0;
                if (translationY != i) {
                    c(translationY, i);
                }
            }
        }
    }

    private void c(int i, int i2) {
        this.nZb = ValueAnimator.ofInt(i, i2);
        this.nZb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.nXS != null) {
                    c.this.nZc.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nZb.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nZb = null;
            }
        });
        this.nZb.setInterpolator(new LinearInterpolator());
        this.nZb.setDuration(800L);
        this.nZb.start();
    }

    private boolean bg() {
        if (this.nYN == 1) {
            this.nYN = 2;
            x(true);
            return true;
        } else if (this.nYN == 3) {
            eec();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.nYN == 1) {
            return bi();
        }
        if (this.nYN == 2) {
            this.nYN = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nYO || this.oax == null || this.oax.edl() == null) {
            return false;
        }
        if (this.nZJ != null) {
            this.nZJ.a(true);
        }
        this.nYN = 3;
        this.nYO = true;
        bk();
        this.nXf.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nYO = false;
                c.this.nXh.setVisibility(8);
            }
        });
        this.nXh.startAnimation(loadAnimation);
        this.nXf.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eec() {
        if (!this.nYO) {
            if (this.nZJ != null) {
                this.nZJ.a(false);
            }
            this.nYN = 1;
            this.nYO = true;
            bk();
            this.nXh.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nYO = false;
                    c.this.nXf.setVisibility(8);
                }
            });
            this.nXh.startAnimation(loadAnimation);
            this.nXf.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.oaj != null) {
            if (this.nXf == null) {
                this.nXf = this.oaj.findViewById(a.f.user_space_container);
            }
            if (this.nXh == null) {
                this.nXh = this.oaj.findViewById(a.f.video_container);
            }
            if (this.nXg == null) {
                this.nXg = com.kascend.chushou.view.user.b.c(null, this.oax.a, false, this.oax.h);
                this.nXg.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.eec();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.eec();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.nXg).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.nXi != null) {
            this.nXi.setVisibility(z ? 8 : 0);
        }
        if (this.nYm != null) {
            this.nYO = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nYm.setVisibility(8);
                        c.this.nYO = false;
                    }
                });
            } else {
                this.nYO = true;
                loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nYm.setVisibility(0);
                        c.this.nYO = false;
                    }
                });
            }
            this.nYm.startAnimation(loadAnimation);
        }
        edF();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.nXz.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.nXH != null) {
                this.nXH.setVisibility(0);
            }
            if (this.nXI != null) {
                this.nXI.a();
                return;
            }
            return;
        }
        if (this.nXK != null) {
            this.nXK.setVisibility(0);
        }
        if (this.nXL != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.nXL.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.nXK != null) {
            this.nXK.setVisibility(8);
        }
        if (this.nXL != null) {
            this.nXL.clearAnimation();
        }
        if (this.nXH != null) {
            this.nXH.setVisibility(8);
        }
        if (this.nXI != null) {
            this.nXI.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nYm != null && this.oaj != null) {
            if (this.nYS == null) {
                this.nYS = new com.kascend.chushou.player.ui.miniview.a(this.oay, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nYS != null && c.this.oaj != null && c.this.nYS.a()) {
                            ((ViewGroup) c.this.oaj).removeView(c.this.nYS);
                            c.this.nYS = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nYS.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.oay, 52.0f);
                this.nYS.setLayoutParams(layoutParams);
                ((ViewGroup) this.nYm).addView(this.nYS, ((ViewGroup) this.nYm).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nYS.setVisibility(8);
                } else {
                    this.nYS.a(a.C0879a.slide_in_bottom_danmu_anim, a.C0879a.slide_out_bottom_danmu_anim, this.oax.a == null ? "" : this.oax.a);
                }
            } else if (!this.nYS.isShown()) {
                this.nYS.a(a.C0879a.slide_in_bottom_danmu_anim, a.C0879a.slide_out_bottom_danmu_anim, this.oax.a == null ? "" : this.oax.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nYY != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nYY.setVisibility(0);
                this.nYY.setAnim(true);
                this.nYY.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.oYr, b.C1014b.oYt, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nYA != null && this.nYA.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eed();
                    }
                });
                this.nYA.setVisibility(0);
                this.nYA.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nYA != null && this.nYA.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nYC != null) {
                        c.this.nYC.removeAllListeners();
                        c.this.nYC.cancel();
                        c.this.nYC = null;
                    }
                    if (c.this.nYA != null) {
                        c.this.nYA.setVisibility(8);
                    }
                }
            });
            this.nYA.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nZf == null) {
                this.nZf = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.oay, "显示双击666_num", null, new Object[0]);
                            if (c.this.oax != null) {
                                c.this.oax.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.oaz != null) {
                    this.oaz.e(this.nZf, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nZf != null) {
            this.oaz.L(this.nZf);
            this.nZf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nYD != null && this.nYD.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.oay, a.C0879a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eee();
                    }
                });
                this.nYD.setVisibility(0);
                this.nYD.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.oai, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nYD != null && this.nYD.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.oay, a.C0879a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nYF != null) {
                        c.this.nYF.removeAllListeners();
                        c.this.nYF.cancel();
                        c.this.nYF = null;
                    }
                    if (c.this.nYD != null) {
                        c.this.nYD.setVisibility(8);
                    }
                }
            });
            this.nYD.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator eed() {
        if (this.nYA == null || this.nYB == null) {
            return null;
        }
        if (this.nYC != null) {
            this.nYC.removeAllListeners();
            this.nYC.cancel();
            this.nYC = null;
        }
        this.nYB.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nYB, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nYB, 0.0f);
        int measuredWidth = (this.nYA.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.oay, 13.0f) * 2)) - this.nYB.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nYB, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nYB, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nYB, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nYC != null) {
                    c.this.nYC.removeAllListeners();
                    c.this.nYC.cancel();
                    c.this.nYC = null;
                }
                RxExecutor.postDelayed(c.this.oai, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eed();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nYC = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator eee() {
        if (this.nYD == null || this.nYE == null) {
            return null;
        }
        if (this.nYF != null) {
            this.nYF.removeAllListeners();
            this.nYF.cancel();
            this.nYF = null;
        }
        this.nYE.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nYE, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nYE, 0.0f);
        int measuredWidth = (this.nYD.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.oay, 13.0f) * 2)) - this.nYE.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nYE, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nYE, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nYE, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nYF != null) {
                    c.this.nYF.removeAllListeners();
                    c.this.nYF.cancel();
                    c.this.nYF = null;
                }
                RxExecutor.postDelayed(c.this.oai, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eee();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nYF = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nZJ = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nUd != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nUd.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet ep = com.kascend.chushou.c.a.ep(jSONObject);
                        if (ep.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Pk(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Pk(a.i.subscribe_success);
                            }
                            if (c.this.nUd != null) {
                                c.this.nUd.isSubscribe = !z;
                                c.this.edz();
                                return;
                            }
                            return;
                        }
                        a(ep.mRc, ep.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.w(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.ect().a(bVar, (String) null, this.nUd.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nUd.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.ect().b(bVar, (String) null, c.this.nUd.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.oax != null && this.nYp != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.oax.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.oax.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nYp.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet ep = com.kascend.chushou.c.a.ep(jSONObject);
                        if (ep.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Pk(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Pk(a.i.subscribe_success);
                            }
                            c.this.nYp.mIsSubscribed = !z;
                            c.this.edA();
                            return;
                        }
                        a(ep.mRc, ep.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.w(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.ect().a(bVar, (String) null, this.nYp.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nYp.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.ect().b(bVar, (String) null, c.this.nYp.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.f
    public void Y() {
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void F() {
        super.F();
        if (this.nWQ != null) {
            int width = this.nWQ.getWidth();
            int height = this.nWQ.getHeight();
            if (this.nYW != width || this.nYX != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void edJ() {
        ((VideoPlayer) this.oay).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.oaj != null) {
            if (this.nXM == null) {
                this.nXM = (InteractionView) ((ViewStub) this.oaj.findViewById(a.f.view_interaction)).inflate();
                this.nXM.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.nXM.a();
                    }
                });
            }
            if (this.nXM != null) {
                this.nXM.b(configDetail);
                this.nXM.c();
                this.nXM.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eqo()) {
                tv.chushou.zues.utils.g.K(this.oay, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.oay, null) && (this.oay instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.oax != null) {
                com.kascend.chushou.toolkit.a.c.a(this.oay, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.oay, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.oax != null) {
                com.kascend.chushou.toolkit.a.c.a(this.oay, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.oay, configDetail.mUrl, this.oay.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.oay, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nYJ) {
                        edN();
                        return;
                    }
                    if (this.oay.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.oay, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.oax != null && this.oax.edj() != null && this.oax.edj().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.oax.edj().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.nXN);
                    return;
                } else {
                    return;
                }
            }
            b(com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "34"));
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.oay != null && !this.v && !h.isEmpty(str) && this.nYp != null && str.equals(this.nYp.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nUa == null) {
                this.nUa = new com.kascend.chushou.player.e.a();
            }
            this.nUa.b = str;
            this.nUa.nWR.copy(pkNotifyInfo);
            if (this.nUa.nWR.mAction == 6) {
                if (this.nTW != null) {
                    this.nTW.a(true);
                }
                this.nUa.nWR.mInPKMode = true;
                this.u = this.nUa.nWR.mPkId;
            } else if (this.nUa.nWR.mAction == 7 || (this.nUa.nWR.mMode == 1 && this.nUa.nWR.mAction == 5)) {
                if (this.nTW != null) {
                    this.nTW.a(true);
                }
                this.nUa.nWR.mInPKMode = true;
                if (this.nYU != 42) {
                    this.nZg = ((this.nYV.y - ((this.nYV.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.oay, 158.0f) + this.nYi)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
                    aX();
                }
                this.u = this.nUa.nWR.mPkId;
                if (this.nUb != null) {
                    this.nUb.b(this.nUa.nWR, false);
                    this.nUb.a(this.nUa.nWR.mMode, (String) null);
                    if (this.nUa.nWR.mAction == 5 && this.nUa.nWR.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nUa.nWR.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nUa.nWR.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nUa.nWR.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nUa.nWR.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nUa.nWR.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.nUb.a(this.nUa.nWR);
                        this.nUb.a(parseInt, this.nUa.nWR.mPkUpdateInfo.remainDuration, j, this.nUa.nWR.mMode, (this.nUa.nWR.destinyInfo == null || this.nUa.nWR.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.nUa.nWR.mPkUpdateInfo != null && !h.isEmpty(this.nUa.nWR.mPkUpdateInfo.specialMomentList) && this.nUb != null) {
                    this.nUb.a(this.nUa.nWR, true);
                }
                if (this.nUa.nWR.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.nUa.nWR.mInPKMode = false;
                if (this.nUa.nWR.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        edK();
        edI();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nYf != null && this.oax != null && this.oax.nTI != null) {
            this.nYf.setText(tv.chushou.zues.utils.b.Pj(this.oax.nTI.count));
            this.nYf.setVisibility(0);
            if (this.oax.nTI.count < 1) {
                bo();
            }
            if (this.nXY != null) {
                this.nXY.setText(this.oax.nTI.primaryName);
            }
            if (this.nXZ != null) {
                this.nXZ.setText(this.oax.nTI.desc);
            }
            edv();
        }
    }

    public void edv() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nYg * h.parseLong(this.oax.nTI.point)));
        if (this.nVt != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.oay.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.N(this.oay, a.e.icon_coin_new);
            cVar.append(this.oay.getString(a.i.str_buy_count_coin2));
            this.nVt.setText(cVar);
        }
    }

    private void eef() {
        if (com.kascend.chushou.d.e.c(this.oay, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nYg);
        }
    }

    private void bo() {
        this.nYh = false;
        this.nYe.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.oax != null && this.oax.nTI != null) {
            if (this.oax.nTI.count < 1) {
                this.nYf.setVisibility(8);
            } else {
                this.nYf.setVisibility(0);
                this.nYf.setSelected(false);
                this.nYf.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nXX.setVisibility(8);
        if (this.nXF != null) {
            this.nXF.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nUf != null) {
            if (z) {
                this.nUf.setVisibility(0);
            } else {
                this.nUf.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nZG != null) {
            this.nZG.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nXO != null) {
            this.nXO.performClick();
        }
    }
}
