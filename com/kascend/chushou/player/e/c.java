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
    private TextView nKG;
    private KPSwitchPanelLinearLayout nKO;
    private ImageView nKP;
    private tv.chushou.zues.widget.kpswitch.b.c nKQ;
    private d.a nKR;
    private View nKd;
    public String nKk;
    private TextView nKo;
    private TextView nKr;
    private ImageView nKx;
    private TextView nLg;
    private TextView nLr;
    private View nLu;
    private int nMQ;
    private View nMR;
    private View nMS;
    private com.kascend.chushou.view.user.b nMT;
    private View nMU;
    private FrameLayout nMV;
    private LinearLayout nMW;
    private RelativeLayout nMX;
    private FrescoThumbnailView nMY;
    private TextView nMZ;
    private TextView nMr;
    private LinearLayout nNA;
    private FrescoThumbnailView nNB;
    private FrameLayout nNC;
    private RedpacketNotifier nND;
    private InteractNotifier nNE;
    private EmbeddedButtonLayout nNF;
    private GiftAnimationLayout nNG;
    private com.kascend.chushou.player.b.a nNH;
    private f nNI;
    private PlayShowH5View nNJ;
    private LinearLayout nNK;
    private TextView nNL;
    private TextView nNM;
    private TextView nNN;
    private TextView nNO;
    private TextView nNP;
    private TextView nNQ;
    private ImageView nNR;
    private TextView nNS;
    private PopupWindow nNX;
    private View nNZ;
    private TextView nNa;
    private TextView nNb;
    private FrescoThumbnailView nNc;
    private TextView nNd;
    private TextView nNe;
    private TextView nNf;
    private TextView nNg;
    private LinearLayout nNh;
    private PlayShowMicStatusView nNi;
    private RecyclerView nNj;
    private ImageView nNk;
    private PlayShowRecommendView nNl;
    private View nNm;
    private RelativeLayout nNn;
    private AnimationSet nNo;
    private ImageView nNp;
    private ImageView nNq;
    private RelativeLayout nNr;
    private PastedEditText nNs;
    private ToggleButton nNt;
    private RelativeLayout nNu;
    private PaoPaoView nNv;
    private FrescoThumbnailView nNw;
    private LinearLayout nNx;
    private ImageView nNy;
    private InteractionView nNz;
    private FoodView nOC;
    public ListItem nOD;
    private FoodView nOE;
    private com.kascend.chushou.player.ui.miniview.a nOF;
    private int nOG;
    private int nOH;
    private Point nOI;
    private FrescoThumbnailView nOL;
    private FrescoThumbnailView nOM;
    private ValueAnimator nOO;
    private LinearLayout nOP;
    private long nOQ;
    private VideoShowVoteView nOR;
    private Runnable nOS;
    private FrescoThumbnailView nOU;
    private ImageView nOV;
    private RelativeLayout nOW;
    private TextView nOX;
    private ImageView nOY;
    private EditText nOZ;
    private RecyclerView nOb;
    private RoomInfo nOc;
    private RecyclerView.LayoutManager nOe;
    private ArrayList<ChatInfo> nOf;
    private ArrayList<ChatInfo> nOg;
    private ArrayList<ChatInfo> nOh;
    private ArrayList<ChatInfo> nOi;
    private Button nOm;
    private View nOn;
    private View nOo;
    private Animator nOp;
    private View nOq;
    private View nOr;
    private Animator nOs;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nOv;
    private PlayShowMicPerson nOy;
    private View nPa;
    private RelativeLayout nPb;
    private RelativeLayout nPc;
    private FrescoThumbnailView nPd;
    private TextView nPe;
    private TextView nPf;
    private ImageView nPg;
    private RelativeLayout nPh;
    private LinearLayout nPi;
    private TextView nPj;
    private TextView nPk;
    private RelativeLayout nPl;
    private RelativeLayout nPm;
    private FrescoThumbnailView nPn;
    private TextView nPo;
    private TextView nPp;
    private ImageView nPq;
    private RelativeLayout nPr;
    private TextView nPt;
    private float nPu;
    private float nPv;
    private a nPw;
    private boolean cp = false;
    private int nNT = 1;
    private boolean nNU = false;
    private int nNV = 0;
    private int nNW = 0;
    private int nNY = -1;
    private boolean nOa = false;
    private FullRoomInfo nOd = null;
    private com.kascend.chushou.player.adapter.a nOj = null;
    private ArrayList<String> nOk = null;
    private boolean nOl = true;
    private boolean nOt = true;
    private boolean nOu = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean nOw = false;
    private boolean nOx = false;
    private long nOz = 0;
    private int nOA = 1;
    private boolean nOB = false;
    private int nOJ = -1;
    private int nOK = -1;
    private boolean nON = false;
    private int nOT = -1;
    private io.reactivex.disposables.b nPs = null;

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
        this.nKk = getArguments().getString("cover");
        this.nOt = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.nPW = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.nPW;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            dZq();
            this.nMD = ((VideoPlayer) this.nQl).dYA();
            this.nQk = ((VideoPlayer) this.nQl).dYD();
            d(view);
            dZA();
            if (this.nQl instanceof VideoPlayer) {
                ((VideoPlayer) this.nQl).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nOu = false;
        if (this.nQR != null) {
            this.nQR.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nOu = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nOp != null) {
            this.nOp.removeAllListeners();
            this.nOp.cancel();
            this.nOp = null;
        }
        if (this.nOs != null) {
            this.nOs.removeAllListeners();
            this.nOs.cancel();
            this.nOs = null;
        }
        if (this.nNE != null) {
            this.nNE.c();
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
        if (this.nPs != null) {
            this.nPs.dispose();
            this.nPs = null;
        }
        this.nNT = 1;
        this.nNU = false;
        if (this.nQm != null) {
            this.nQm.cl(null);
        }
        if (this.nNX != null) {
            this.nNX.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nQl, this.nKQ);
        if (this.nQl != null && (this.nQl instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQl).dYH();
        }
        this.nKR = null;
        this.nKQ = null;
        aI();
        if (this.nNH != null) {
            this.nNH.a();
        }
        if (this.nNv != null) {
            this.nNv.b();
            this.nNv.c();
            this.nNv = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.cm(this);
        if (this.nOh != null) {
            this.nOh.clear();
        }
        if (this.nOf != null) {
            this.nOf.clear();
        }
        if (this.nOi != null) {
            this.nOi.clear();
        }
        if (this.nOg != null) {
            this.nOg.clear();
        }
        if (this.nOk != null) {
            this.nOk.clear();
        }
        if (this.nOj != null) {
            this.nOj.a(0);
            this.nOj.a();
        }
    }

    private void d(View view) {
        this.nMR = view.findViewById(a.f.fl_root);
        this.nOI = tv.chushou.zues.utils.a.gX(this.nQl);
        this.nNV = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQl);
        this.nNW = tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        this.nOH = 86;
        this.nQk = ((VideoPlayer) this.nQl).dYD();
        if (this.nQk != null) {
            this.nOc = this.nQk.dZe();
            this.nOd = this.nQk.dZc();
        }
        this.nOf = new ArrayList<>();
        this.nOh = new ArrayList<>();
        this.nOg = new ArrayList<>();
        this.nMV = (FrameLayout) this.nPW.findViewById(a.f.fl_effect);
        b();
        this.nQf = (PlayerErrorView) this.nPW.findViewById(a.f.view_net_error_msg);
        this.nQf.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.nNu = (RelativeLayout) this.nPW.findViewById(a.f.rl_audio_ani);
        this.nNv = (PaoPaoView) this.nPW.findViewById(a.f.audio_ani);
        this.nNw = (FrescoThumbnailView) this.nPW.findViewById(a.f.audio_ani_avatar);
        this.nNx = (LinearLayout) this.nPW.findViewById(a.f.ll_audio);
        this.nMr = (TextView) this.nPW.findViewById(a.f.tv_open_video);
        this.nNy = (ImageView) this.nPW.findViewById(a.f.iv_audio_ani);
        this.nOM = (FrescoThumbnailView) this.nPW.findViewById(a.f.live_cover);
        if (!this.nON || this.nMD == null || this.nMD.getPlayState() != 4) {
            this.nOM.setVisibility(0);
            this.nOM.setBlur(true);
            this.nOM.i(this.nKk, 0, 0, 0);
        }
        this.nMr.setOnClickListener(this);
        this.nJO = new b();
        this.nJO.a(view, null, this.nQl, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cvD()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.nQk != null) {
                    append.append(c.this.nQk.dZe().mRoomID);
                }
                if (c.this.nJN != null && c.this.nJN.nME != null) {
                    append.append("&mode=").append(c.this.nJN.nME.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nQl, append.toString());
            }
        });
        this.nJS = (VoiceInteractionView) this.nPW.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.nQk != null) {
            this.nOc = this.nQk.dZe();
            this.nOd = this.nQk.dZc();
        }
        aL();
        dZp();
        dZv();
        this.nOP = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nOC = (FoodView) view.findViewById(a.f.rav_ad);
        this.nOU = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nOV = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nOU.setOnClickListener(this);
        this.nOV.setOnClickListener(this);
        this.nOW = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nOL = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nOL.setOnClickListener(this);
        this.nNE = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.nND = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nOm = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nOm.setOnClickListener(this);
        this.nOb = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nOb.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOb.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nOI.x, this.nOI.y) * 0.83d);
        this.nOb.setLayoutParams(layoutParams);
        this.nOe = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nQl);
        this.nOb.setLayoutManager(this.nOe);
        this.nOb.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nOb.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nOb.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dZI();
                } else if (i == 1) {
                    c.this.nOl = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nOj = new com.kascend.chushou.player.adapter.a(this.nQl, this.nOf);
        if (this.nOc != null) {
            this.nOj.a(this.nOc);
        }
        if (com.kascend.chushou.b.dYj().c != null) {
            this.nOj.a(com.kascend.chushou.b.dYj().c);
        }
        this.nOb.setAdapter(this.nOj);
        this.nOj.a(this.nOf.size());
        this.nOj.notifyDataSetChanged();
        if (this.nQk != null && (c = this.nQk.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.nNH != null) {
            this.nNH.a();
            this.nNH = null;
        }
        this.nNG = (GiftAnimationLayout) this.nPW.findViewById(a.f.ll_gift_animation);
        this.nNG.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.nMQ = ((int) (tv.chushou.zues.utils.a.gW(this.nQl).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nQl, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nNG.getLayoutParams();
        layoutParams2.bottomMargin = this.nMQ;
        this.nNG.setLayoutParams(layoutParams2);
        if (this.nQk != null) {
            this.nNH = new com.kascend.chushou.player.b.a(this.nQl.getApplicationContext(), this.nNG);
            this.nNH.a(this.nQk);
            a(this.nQk.nJt, this.nQk.nJw);
        }
        this.nPW.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.nNF = (EmbeddedButtonLayout) this.nPW.findViewById(a.f.embedded_button_layout);
        this.nNF.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nOR = (VideoShowVoteView) this.nPW.findViewById(a.f.view_video_show_vote);
        this.nOR.setOnClickListener(this);
        this.nOR.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.nQk != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
            this.nNF.a(videoPlayer.dYN().eah());
            this.nNF.b(this.nQk.i());
            this.nND.a(videoPlayer.dYJ(), false);
            this.nNE.a(videoPlayer.dYK(), videoPlayer.dYL(), videoPlayer.dYM());
            this.nJN = new com.kascend.chushou.player.e.a();
        }
        this.nRb = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nOw = false;
                c.this.b(c.this.nMQ, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nOw = true;
                if (c.this.nQR != null) {
                    c.this.nQR.measure(0, 0);
                    int measuredHeight = c.this.nQR.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nQl, 14.0f);
                    if (measuredHeight > c.this.nMQ) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.nQV = (PaoGuideView) this.nPW.findViewById(a.f.rlPaoGuideView);
        this.nOy = (PlayShowMicPerson) this.nPW.findViewById(a.f.rl_mic_person_view);
        this.nNJ = (PlayShowH5View) this.nPW.findViewById(a.f.rl_playshowh5);
        this.nOE = (FoodView) this.nPW.findViewById(a.f.bottom_ad);
        if (this.nQk != null) {
            H();
            if (this.nQk.nJm != null && !h.isEmpty(this.nQk.nJm.mUrl)) {
                b(this.nQk.nJm);
            }
        }
        this.nOn = this.nPW.findViewById(a.f.view_reminder_subscribe);
        this.nOo = this.nOn.findViewById(a.f.spash_subscribe);
        ((TextView) this.nOn.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().L(this.nQl, a.e.videoplayer_reminder_subscribe).append(" ").append(this.nQl.getString(a.i.videoplayer_reminder_subscribe)));
        this.nOn.setOnClickListener(this);
        this.nOq = this.nPW.findViewById(a.f.view_reminder_danmaku);
        this.nOr = this.nOq.findViewById(a.f.spash_danmaku);
        ((TextView) this.nOq.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().L(this.nQl, a.e.videoplayer_reminder_danmaku).append(" ").append(this.nQl.getString(a.i.videoplayer_reminder_danmaku)));
        this.nOq.setOnClickListener(this);
    }

    private void dZp() {
        this.nPb = (RelativeLayout) this.nPW.findViewById(a.f.rl_cyclelive);
        this.nPc = (RelativeLayout) this.nPW.findViewById(a.f.rlrl_cyclelive);
        this.nPd = (FrescoThumbnailView) this.nPW.findViewById(a.f.iv_liveicon);
        this.nPe = (TextView) this.nPW.findViewById(a.f.tv_livename);
        this.nPf = (TextView) this.nPW.findViewById(a.f.tv_livedesc);
        this.nPg = (ImageView) this.nPW.findViewById(a.f.iv_cyclelive_name_menu);
        this.nPh = (RelativeLayout) this.nPW.findViewById(a.f.rl_normal);
        this.nPi = (LinearLayout) this.nPW.findViewById(a.f.ll_cyclelive_nickname);
        this.nPj = (TextView) this.nPW.findViewById(a.f.tv_cyclelive_nickname);
        this.nPk = (TextView) this.nPW.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nPl = (RelativeLayout) this.nPW.findViewById(a.f.rl_clear_cyclelive);
        this.nPm = (RelativeLayout) this.nPW.findViewById(a.f.rlrl_clear_cyclelive);
        this.nPn = (FrescoThumbnailView) this.nPW.findViewById(a.f.iv_clear_liveicon);
        this.nPo = (TextView) this.nPW.findViewById(a.f.tv_clear_livename);
        this.nPp = (TextView) this.nPW.findViewById(a.f.tv_clear_livedesc);
        this.nPq = (ImageView) this.nPW.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nPr = (RelativeLayout) this.nPW.findViewById(a.f.rl_clear_normal);
        this.nPq.setOnClickListener(this);
        this.nPg.setOnClickListener(this);
        this.nPk.setOnClickListener(this);
        this.nPj.setOnClickListener(this);
        this.nPd.setOnClickListener(this);
        this.nPn.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nQk.nJk != null && this.nOE != null) {
            this.nOE.a(true, this.nQk.a == null ? "" : this.nQk.a);
            this.nOE.a(this.nQk.nJk, a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nQk != null && this.nQk.nJr != null && this.nNF != null) {
            this.nOC.a(this.nQk.nJr, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.nQk != null) {
                        c.this.nQk.nJr = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dZH() {
        return this.nNH;
    }

    private void dZq() {
        this.nQm = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.nPW != null && (textView = (TextView) c.this.nPW.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nQl.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nQm.B(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nQm);
                        break;
                    case 12:
                        c.this.b(c.this.nQm);
                        break;
                    case 17:
                        c.this.eac();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.nQj.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nOa) {
            this.nOa = true;
            if (this.nNZ == null) {
                this.nNZ = this.nPW.findViewById(a.f.vs_async_show_content);
                this.nNZ = ((ViewStub) this.nNZ).inflate();
            }
            this.nKd = this.nPW.findViewById(a.f.ui_content);
            if (this.nLu == null) {
                this.nLu = this.nPW.findViewById(a.f.vs_async_notification_view);
                this.nLu = ((ViewStub) this.nLu).inflate();
            }
            c(this.nPW);
            k();
            dMD();
            if (this.c == null) {
                this.nJH = new d.a();
                this.c = new GestureDetector(this.nQl, this.nJH);
            }
            ((VideoPlayer) this.nQl).q();
        }
    }

    private void aL() {
        this.nMW = (LinearLayout) this.nPW.findViewById(a.f.ll_anchor);
        this.nMX = (RelativeLayout) this.nPW.findViewById(a.f.ll_clear_anchor);
        this.nMW.setVisibility(4);
        this.nMX.setVisibility(4);
        this.nMY = (FrescoThumbnailView) this.nPW.findViewById(a.f.iv_clear_avatar);
        this.nMZ = (TextView) this.nPW.findViewById(a.f.tv_clear_nickname);
        this.nNa = (TextView) this.nPW.findViewById(a.f.tv_clear_online_count);
        this.nNb = (TextView) this.nPW.findViewById(a.f.tv_clear_btn_subscribe);
        this.nNb.setOnClickListener(this);
        this.nNc = (FrescoThumbnailView) this.nPW.findViewById(a.f.iv_avatar);
        this.nNd = (TextView) this.nPW.findViewById(a.f.tv_nickname_test);
        this.nNe = (TextView) this.nPW.findViewById(a.f.tv_online_count);
        this.nKo = (TextView) this.nPW.findViewById(a.f.tv_btn_subscribe);
        this.nKo.setOnClickListener(this);
        this.nNf = (TextView) this.nPW.findViewById(a.f.tv_loyal_counts);
        this.nKr = (TextView) this.nPW.findViewById(a.f.tv_btn_contribution);
        this.nNg = (TextView) this.nPW.findViewById(a.f.tv_btn_contribution_forpk);
        this.nKr.setVisibility(4);
        this.nNg.setVisibility(8);
        this.nNh = (LinearLayout) this.nPW.findViewById(a.f.ll_mic);
        this.nNi = (PlayShowMicStatusView) this.nPW.findViewById(a.f.show_mic_status);
        this.nNj = (RecyclerView) this.nPW.findViewById(a.f.rv_loyal);
        this.nNk = (ImageView) this.nPW.findViewById(a.f.iv_clear_close);
        this.nKx = (ImageView) this.nPW.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.nNj.setLayoutManager(linearLayoutManager);
        this.nOv = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void C(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nQl, (JSONObject) null, c.this.nQk.dZe().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1014a view$OnLongClickListenerC1014a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1014a view$OnLongClickListenerC1014a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC1014a.qW(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC1014a.qW(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1014a.qW(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.elZ(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nQl, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQl, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQl, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQl, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQl, a.c.color_979797), dip2px);
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
        this.nNj.setAdapter(this.nOv);
        this.nNh.setOnClickListener(this);
        this.nMY.setOnClickListener(this);
        this.nNk.setOnClickListener(this);
        this.nNc.setOnClickListener(this);
        this.nMY.setOnClickListener(this);
        this.nKx.setOnClickListener(this);
        this.nNf.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dC(View view) {
                String str = tv.chushou.common.a.cvD() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.nQk != null) {
                    str = str + c.this.nQk.dZe().mRoomID;
                }
                c.this.f(c.this.nQl.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nKr.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dC(View view) {
                String str = tv.chushou.common.a.cvD() + "m/room-billboard/";
                if (c.this.nQk != null) {
                    str = str + c.this.nQk.dZe().mRoomID;
                }
                c.this.f(c.this.nQl.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.nNg.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dC(View view) {
                String str = tv.chushou.common.a.cvD() + "m/room-billboard/";
                if (c.this.nQk != null) {
                    str = str + c.this.nQk.dZe().mRoomID;
                }
                c.this.f(c.this.nQl.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nOd == null || this.nOd.cycleLiveRoomInfo == null || h.isEmpty(this.nOd.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nJQ = this.nOd.cycleLiveRoomInfo;
        }
        if (z2 && this.nJQ != null) {
            this.nPb.setVisibility(0);
            this.nPl.setVisibility(0);
            this.nPh.setVisibility(8);
            this.nPr.setVisibility(8);
            this.nPi.setVisibility(0);
            this.nPn.h(this.nJQ.eventIcon, com.kascend.chushou.view.a.a(this.nOc.mCreatorGender), b.a.small, b.a.small);
            this.nPd.h(this.nJQ.eventIcon, com.kascend.chushou.view.a.a(this.nOc.mCreatorGender), b.a.small, b.a.small);
            this.nPo.setText(this.nJQ.eventName);
            this.nPp.setText(this.nJQ.eventDesc);
            this.nPe.setText(this.nJQ.eventName);
            this.nPf.setText(this.nJQ.eventDesc);
            this.nPj.setText(this.nJQ.nickname);
            dZs();
            if (z) {
                c(this.nJQ.remainTime);
                return;
            }
            return;
        }
        this.nPb.setVisibility(8);
        this.nPl.setVisibility(8);
        this.nPh.setVisibility(0);
        this.nPr.setVisibility(0);
        this.nPi.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nPs != null) {
            this.nPs.dispose();
            this.nPs = null;
        }
        this.nPs = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.eeV()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nQl != null && (c.this.nQl instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nQl).u();
                }
            }
        });
    }

    private void dZr() {
        if (this.nOc != null && this.nOa) {
            this.nMW.setVisibility(0);
            this.nMX.setVisibility(0);
            this.nKr.setVisibility(0);
            this.nMY.h(this.nOc.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nOc.mCreatorGender), b.a.small, b.a.small);
            this.nMZ.setText(this.nOc.mCreatorNickname);
            this.nNc.h(this.nOc.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nOc.mCreatorGender), b.a.small, b.a.small);
            this.nNd.setText(this.nOc.mCreatorNickname);
            dZT();
            dZt();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dZT() {
        if (this.nOc != null) {
            this.nNa.setText(tv.chushou.zues.utils.b.formatNumber(this.nOc.mOnlineCount));
            this.nNe.setText(tv.chushou.zues.utils.b.formatNumber(this.nOc.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZs() {
        if (this.nJQ != null) {
            if (this.nJQ.isSubscribe) {
                this.nPk.setText(a.i.like_already);
                this.nPk.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nPk.setText(getString(a.i.like));
            this.nPk.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZt() {
        if (this.nOc != null) {
            if (this.nOc.mIsSubscribed) {
                this.nNb.setText(getString(a.i.like_already));
                this.nNb.setBackgroundResource(a.e.bg_show_subcribe);
                this.nKo.setText(getString(a.i.like_already));
                this.nKo.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nNb.setText(getString(a.i.like));
            this.nNb.setBackgroundResource(a.e.bg_show_subcribe);
            this.nKo.setText(getString(a.i.like));
            this.nKo.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dZu() {
        if (this.nOv != null) {
            this.nOv.notifyDataSetChanged();
        }
    }

    private void dZv() {
        this.nNm = this.nPW.findViewById(a.f.tv_interact);
        this.nNm.setOnClickListener(this);
        this.nNr = (RelativeLayout) this.nPW.findViewById(a.f.rl_edit_bar);
        this.nNp = (ImageView) this.nPW.findViewById(a.f.btn_hotword);
        this.nNp.setOnClickListener(this);
        this.nNq = (ImageView) this.nPW.findViewById(a.f.iv_task_badge);
        this.nNo = (AnimationSet) AnimationUtils.loadAnimation(this.nQl, a.C0882a.anim_hotword);
        this.nNo.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dYr().c) {
                    c.this.nNp.clearAnimation();
                    c.this.nNp.startAnimation(c.this.nNo);
                }
            }
        });
        if (com.kascend.chushou.d.h.dYr().c) {
            this.nNp.startAnimation(this.nNo);
            this.nNq.setVisibility(0);
        }
        this.nPt = (TextView) this.nPW.findViewById(a.f.tv_bottom_input);
        this.nPt.setOnClickListener(this);
        this.nRm = (FrescoThumbnailView) this.nPW.findViewById(a.f.ll_btn_set);
        this.nRm.setOnClickListener(this);
        this.nRm.Ck(a.e.ic_room_set_btn_white);
        this.nNA = (LinearLayout) this.nPW.findViewById(a.f.ll_bottom_all_button);
        this.nNB = (FrescoThumbnailView) this.nPW.findViewById(a.f.fl_clear_bottom_gift);
        this.nNB.setAnim(true);
        this.nNB.setOnClickListener(this);
        this.nNB.Ck(a.e.ic_show_gift_n);
        this.nNC = (FrameLayout) this.nPW.findViewById(a.f.flfl_clear_bottom_gift);
        this.nNC.setVisibility(8);
        this.nNn = (RelativeLayout) this.nPW.findViewById(a.f.rl_bottom_input);
        this.nNn.setVisibility(0);
        this.nNs = (PastedEditText) this.nPW.findViewById(a.f.et_bottom_input);
        this.nNs.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nKG.setEnabled(editable.length() > 0);
            }
        });
        this.nNs.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nKG);
                    return true;
                }
                return true;
            }
        });
        this.nNs.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.nNs);
                }
                return false;
            }
        });
        this.nKP = (ImageView) this.nPW.findViewById(a.f.iv_btn_emoji);
        this.nKP.setVisibility(8);
        this.nKG = (TextView) this.nPW.findViewById(a.f.tv_btn_send);
        this.nKG.setOnClickListener(this);
        this.nNK = (LinearLayout) this.nPW.findViewById(a.f.head_trumpet);
        this.nNK.setVisibility(8);
        this.nNK.setOnClickListener(this);
        this.nNL = (TextView) this.nPW.findViewById(a.f.tv_primary_name);
        this.nNM = (TextView) this.nPW.findViewById(a.f.tv_primary_desc);
        this.nNO = (TextView) this.nPW.findViewById(a.f.tv_cut_count);
        this.nNO.setOnClickListener(this);
        this.nNQ = (TextView) this.nPW.findViewById(a.f.tv_head_count);
        this.nNQ.setText(this.nNT + "");
        this.nNP = (TextView) this.nPW.findViewById(a.f.tv_plus_count);
        this.nNP.setOnClickListener(this);
        this.nLg = (TextView) this.nPW.findViewById(a.f.tv_buy_count_coin);
        this.nNN = (TextView) this.nPW.findViewById(a.f.tv_buy_head);
        this.nNN.setOnClickListener(this);
        this.nNR = (ImageView) this.nPW.findViewById(a.f.iv_trumpet_select);
        this.nNR.setOnClickListener(this);
        this.nNS = (TextView) this.nPW.findViewById(a.f.tv_trumpet_have_count);
        this.nNU = false;
        this.nNR.setBackgroundResource(a.e.ic_trumpet_n);
        this.nNS.setVisibility(8);
        this.nKO = (KPSwitchPanelLinearLayout) this.nPW.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nKO, this.nKP, this.nNs, new a.InterfaceC1018a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1018a
            public void yt(boolean z) {
                if (c.this.nKP != null) {
                    if (z) {
                        c.this.nKO.setDirectVisibility(0);
                        c.this.nKP.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nKP.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nKR = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void yu(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.nKP.setImageResource(a.e.cs_emoji_normal);
                    c.this.dZx();
                    if (c.this.nPa != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nPa.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hi(c.this.nQl);
                        c.this.nPa.setLayoutParams(layoutParams);
                    }
                    if (c.this.nNr != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.nNr.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hi(c.this.nQl);
                        c.this.nNr.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nPa != null && c.this.nPa.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nPa.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nPa.setLayoutParams(layoutParams3);
                    c.this.nPa.setVisibility(8);
                }
                if (c.this.nOw) {
                    c.this.nQR.setVisibility(0);
                }
                if (c.this.nQl != null && (c.this.nQl instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nQl).ys(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.nNr != null && c.this.nKO.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.nNr.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.nNr.setLayoutParams(layoutParams4);
                }
            }
        };
        this.nKQ = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nKO, this.nKR, ((VideoPlayer) this.nQl).dYI());
        ((VideoPlayer) this.nQl).h(((VideoPlayer) this.nQl).dYI());
        this.nPa = this.nPW.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nOX = (TextView) this.nPW.findViewById(a.f.btn_room_search);
        this.nOY = (ImageView) this.nPW.findViewById(a.f.iv_room_emoji_delete);
        this.nOZ = (EditText) this.nPW.findViewById(a.f.et_room_emoji_search);
        this.nOZ.setImeOptions(3);
        this.nOZ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nOX);
                    return true;
                }
                return false;
            }
        });
        this.nOZ.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nOX.setEnabled(editable.length() > 0);
                c.this.nOY.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.nQR.setEmojiSearchText(editable.toString());
            }
        });
        this.nOX.setOnClickListener(this);
        this.nOY.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aB(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dM(this.nOZ);
            this.nPa.setVisibility(0);
            this.nOZ.requestFocus();
        } else {
            this.nPa.setVisibility(8);
        }
        if (z2) {
            this.nOZ.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZx() {
        int hi = tv.chushou.zues.widget.kpswitch.b.d.hi(this.nQl) + tv.chushou.zues.utils.a.dip2px(this.nQl, 14.0f);
        if (hi > this.nMQ) {
            b(hi, 12);
        }
    }

    private void aS() {
    }

    private void dZA() {
        if (this.nNW > 0) {
            View findViewById = this.nPW.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nNW);
        }
        if (this.nNV > 0) {
            View findViewById2 = this.nPW.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nNV, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nOt) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.nJJ = ((VideoPlayer) this.nQl).dYE();
        this.nJJ.a(this);
        if (this.nQk.dZc() != null) {
            s();
        } else if (this.nPX != null) {
            this.nPX.setVisibility(0);
        }
        if (this.nJJ != null) {
            this.nJJ.d();
        }
    }

    private void dZB() {
        if ((this.nJN == null || this.nJN.nME == null || !this.nJN.nME.mInPKMode) ? false : true) {
            if (this.nMR != null) {
                this.nMR.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nJP.getLayoutParams();
            layoutParams.leftMargin = (this.nOI.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nQl, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.nJP.setLayoutParams(layoutParams);
            this.y.setText(this.nJN.nME.mPkUserNickname);
            this.nJP.setVisibility(0);
            this.nNh.setVisibility(8);
            return;
        }
        if (this.nMR != null) {
            this.nMR.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.nJP.setVisibility(8);
    }

    private void dZD() {
        boolean z = false;
        if (this.nJN != null && this.nJN.nME != null && this.nJN.nME.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nOT > 0 && this.nOb != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOb.getLayoutParams();
                if (layoutParams.height != this.nOT) {
                    layoutParams.height = this.nOT;
                    this.nOb.setLayoutParams(layoutParams);
                }
            }
            this.nMQ = ((int) (tv.chushou.zues.utils.a.gW(this.nQl).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nQl, 84.0f);
            b(this.nMQ, 12);
        } else {
            if (this.nOb != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nOb.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nQl, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nQl, 250.0f);
                    this.nOb.setLayoutParams(layoutParams2);
                }
            }
            this.nMQ = ((int) (tv.chushou.zues.utils.a.gW(this.nQl).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nQl, 84.0f);
            b(this.nMQ, 12);
        }
        if (this.nJO != null) {
            this.nJO.a(this.nOT + tv.chushou.zues.utils.a.dip2px(this.nQl, 52.0f), this.aq);
        }
        if (this.nJS != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nJS.getLayoutParams();
            layoutParams3.bottomMargin = this.nOT + tv.chushou.zues.utils.a.dip2px(this.nQl, 52.0f);
            this.nJS.setLayoutParams(layoutParams3);
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

    private void dZE() {
        dZD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) eaa().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nPX.getLayoutParams();
        this.nOI = tv.chushou.zues.utils.a.gX(this.nQl);
        this.nOH = 86;
        this.dB = (Math.max(this.nOI.x, this.nOI.y) - tv.chushou.zues.utils.a.dip2px(this.nQl, (this.nOH + 52) + 250)) - this.nNV;
        this.nOG = Math.max(this.nOI.x, this.nOI.y) - ((tv.chushou.zues.utils.a.dip2px(this.nQl, this.nOH) + this.nNV) * 2);
        if (this.nOJ <= 0 || this.nOK <= 0) {
            this.nOJ = Math.min(this.nOI.x, this.nOI.y);
            this.nOK = Math.max(this.nOI.x, this.nOI.y);
        }
        this.ar = Math.min(this.nOI.x, this.nOI.y);
        this.aq = (this.ar * this.nOK) / this.nOJ;
        boolean z = false;
        if (this.nJN == null || this.nJN.nME == null) {
            i = 1;
        } else {
            i = this.nJN.nME.mMode;
            if (this.nJN.nME.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.nOH = 42;
            if (i == 2) {
                if (this.nOK < this.nOJ) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nOJ * layoutParams.height) / this.nOK;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, this.nOH) + this.nNV;
            layoutParams.gravity = 48;
            this.nOT = ((this.nOI.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nQl, (this.nOH + 52) + 64) + this.nNV)) - tv.chushou.zues.utils.systemBar.b.ay(getActivity());
            aG();
        } else if (this.E) {
            this.nOH = 42;
            if (this.nOK < this.nOJ) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nOJ * layoutParams.height) / this.nOK;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, this.nOH) + this.nNV;
            layoutParams.gravity = 48;
            this.nOT = ((this.nOI.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nQl, (this.nOH + 52) + 98) + this.nNV)) - tv.chushou.zues.utils.systemBar.b.ay(getActivity());
            dZE();
        } else {
            this.nOT = -1;
            this.nOH = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, this.nOH) + this.nNV;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.nOG) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, this.nOH) + this.nNV;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nOI.x, this.nOI.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nOJ) / this.nOK >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nOJ) / this.nOK;
                    } else if ((this.ar * this.nOK) / this.nOJ >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nOK) / this.nOJ;
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
                    if ((this.ar * this.nOK) / this.nOJ > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nOJ) / this.nOK;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nOK) / this.nOJ;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nOK) / this.nOJ;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nOJ) / this.nOK;
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
        if (this.nQk != null && this.nQk.d) {
            layoutParams.width = Math.min(this.nOI.x, this.nOI.y);
            layoutParams.height = Math.max(this.nOI.x, this.nOI.y);
        }
        eaa().setLayoutParams(layoutParams);
        this.nPX.setLayoutParams(layoutParams2);
        this.nPX.requestLayout();
    }

    private void aY() {
        this.nPX = new SurfaceRenderView(this.nQl);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.nPX;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        eaa().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nOB) {
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
        if (this.nPw != null) {
            this.nPw.a();
        }
        if (this.nQk != null && !h.isEmpty(this.nQk.w)) {
            b(this.nQk.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nMD != null) {
            int width = this.nMD.getWidth();
            int height = this.nMD.getHeight();
            if (this.nOJ != width || this.nOK != height || this.nOJ <= 0 || this.nOK <= 0) {
                this.nOJ = width;
                this.nOK = height;
                if (this.nPX != null) {
                    this.nPX.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.nOw) {
                dZG();
            } else {
                if (this.nQl.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击送礼_num", "竖屏", new Object[0]);
                if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQk.dZc().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nNU) {
                f(this.nNs.getText().toString());
            } else {
                a(this.nNs.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dYr().c) {
                com.kascend.chushou.d.h.dYr().b(false);
                this.nNo.cancel();
                this.nNo.reset();
                this.nNp.clearAnimation();
                this.nNq.setVisibility(8);
            }
            n(view, 0, this.nPW.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nQl, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.nPW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.nQk.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.nQk.d) {
                dMw();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nOb != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nOc != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nOA = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nQl, (JSONObject) null, this.nQk.dZe().mRoomID, this.nQk.dZe().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.nQl.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nQl, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nOD != null) {
                    com.kascend.chushou.d.e.a(this.nQl, this.nOD, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nOW != null) {
                    this.nOW.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nQl, null) && this.nQk != null && this.nQk.nJv != null) {
                    if (this.nNU) {
                        bo();
                    } else {
                        if (this.nQk != null && this.nQk.nJv != null && this.nQk.nJv.count > 0) {
                            this.nNK.setVisibility(8);
                        } else {
                            this.nNK.setVisibility(0);
                        }
                        this.nNU = true;
                        this.nNR.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nNS.setVisibility(0);
                        this.nNS.setSelected(true);
                        this.nNS.setTextColor(Color.parseColor("#ff5959"));
                        if (this.nNs != null) {
                            this.nNs.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nNT <= 9) {
                    this.nNT++;
                    this.nNQ.setText(this.nNT + "");
                }
                dZo();
            } else if (id == a.f.tv_cut_count) {
                if (this.nNT > 1) {
                    this.nNT--;
                    this.nNQ.setText(this.nNT + "");
                }
                dZo();
            } else if (id == a.f.tv_buy_head) {
                dZY();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nOZ.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nOZ.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nPa.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dN(this.nOZ);
                    this.nQR.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nJQ != null && !h.isEmpty(this.nJQ.eventUrl)) {
                    f("", this.nJQ.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nJQ != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nJQ != null) {
                    com.kascend.chushou.d.a.a(this.nQl, (JSONObject) null, this.nJQ.roomId, this.nJQ.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.nQk.a(false);
                    ((VideoPlayer) this.nQl).l();
                } else {
                    ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
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
        if (this.nNJ != null) {
            int i = (tv.chushou.zues.utils.a.gW(this.nQl).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nNJ.getLayoutParams();
            layoutParams.topMargin = i;
            this.nNJ.setLayoutParams(layoutParams);
            this.nNJ.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.nNJ.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.OF(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nOz <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.OF(a.i.str_too_fast);
            return false;
        } else {
            dMI();
            if (!com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a(((VideoPlayer) this.nQl).dYD().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nOz = System.currentTimeMillis();
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                a(this.nQk.dZc().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nQk.h);
            }
            g(this.b);
            if (!z && this.nNs != null) {
                this.nNs.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dMI();
            if (com.kascend.chushou.d.e.c(this.nQl, null) && LoginManager.Instance().getUserInfo() != null && this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                a(this.nQk.dZc().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nNs != null) {
                this.nNs.setText((CharSequence) null);
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
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nQk.dZc().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nQk.dZc().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nQl).nHK;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.WU(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.nQM != null && this.nQM.isShowing()) {
            this.nQM.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
        if (this.nRj == null) {
            i(3);
        }
        this.nRj.getContentView().setBackgroundResource(0);
        this.nRj.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.nRj.isShowing()) {
            this.nRj.showAtLocation(view, 83, i, i2);
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nQk.dZc().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nRj.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.nRn)) {
            if (((VideoPlayer) this.nQl).q) {
                this.nRm.Ck(a.e.ic_room_set_btn_white);
            } else {
                this.nRm.Ck(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nQl).q && this.nRn.size() == 2 && this.nRn.contains("4") && this.nRn.contains("2")) {
            this.nRm.Ck(a.e.ic_room_set_btn_system_white);
        } else if (this.nRn.size() > 1 || !((VideoPlayer) this.nQl).q) {
            this.nRm.Ck(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.nRn.get(0))) {
            this.nRm.Ck(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.nRn.get(0))) {
            this.nRm.Ck(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.nRn.get(0))) {
            this.nRm.Ck(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
        if (this.nQM == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.nQM.getContentView().setBackgroundResource(0);
            this.nQM.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nQM.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nNp.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.nQM.isShowing()) {
            this.nQM.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nQl, 16.0f) + i2);
            this.nNp.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nQk.dZc().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nQM.dismiss();
    }

    private void e(View view) {
        if (this.nQG == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.dYr().q()) {
            this.nNt.elX();
        } else {
            this.nNt.elY();
        }
        int height = this.nPW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        if (view != null) {
            this.nQG.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.nQG == null) {
            View inflate = LayoutInflater.from(this.nQl).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.nNt = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dYr().q()) {
                this.nNt.elX();
            } else {
                this.nNt.elY();
            }
            this.nNt.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dYr().g(z);
                }
            });
            this.nQA = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nQB = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nQA.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nQA.setVisibility(0);
            } else {
                this.nQA.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dYr().a) {
                this.nQB.b();
            } else {
                this.nQB.c();
            }
            if (this.nQk != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.nQk.f;
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
                                if (this.nJN == null || !this.nJN.nME.mInPKMode || h.isEmpty(this.nJN.b) || this.nOc == null || !this.nJN.b.equals(this.nOc.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nQl).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dZd = this.nQk.dZd();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nQl).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQl, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, 5.0f);
                                            }
                                            int identifier = this.nQl.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nQl.getPackageName());
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
                                                if (dZd != null && dZd.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nQl.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nQl).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dZd2 = this.nQk.dZd();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nQl).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQl, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, 5.0f);
                                        }
                                        int identifier2 = this.nQl.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nQl.getPackageName());
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
                                            if (dZd2 != null && dZd2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.nQG.dismiss();
                    }
                }
            });
            this.nQG = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 150.0f), -2);
            this.nQG.setFocusable(true);
            this.nQG.setOutsideTouchable(true);
            this.nQG.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nQG.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nQG = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
            if (this.nNI == null) {
                this.nNI = new f(getActivity());
            }
            this.nNI.a(this.nQk.dZc().mRoominfo, this.ax);
            if (!this.nNI.isShowing()) {
                this.nNI.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nOB) {
            return false;
        }
        if (this.nOA == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nPu = motionEvent.getX();
                    this.nPv = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nPu;
                    if (Math.abs(f) > Math.abs(y - this.nPv) && Math.abs(f) > q && f > 0.0f) {
                        dZV();
                        return true;
                    }
                    this.nPu = 0.0f;
                    this.nPv = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nPa != null && this.nPa.getVisibility() == 0 && a(motionEvent, this.nPa)) {
                this.nPa.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dN(this.nOZ);
                return true;
            } else if (this.nOw && this.nPa != null && this.nPa.getVisibility() == 8 && f(this.nQR.b, motionEvent)) {
                dZG();
                return true;
            } else if (this.nNJ != null && this.nNJ.b() && f(this.nNJ, motionEvent)) {
                this.nNJ.a();
                return true;
            } else if (this.nNz != null && this.nNz.b() && f(this.nNz, motionEvent)) {
                this.nNz.a();
                return true;
            } else if (a(motionEvent, this.nNr)) {
                return dMI();
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
            if (this.nRd != null && this.nRd.a(i, keyEvent)) {
                return true;
            }
            if ((this.nNJ != null && this.nNJ.onKeyDown(i, keyEvent)) || dZy()) {
                return true;
            }
            if (this.nOA == 3) {
                this.nOA = 1;
                dZV();
                return true;
            } else if (this.nNz != null && this.nNz.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nNs != null && this.nNn != null && this.nNr != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.nNs);
                this.nNn.setVisibility(8);
                this.nNr.setVisibility(0);
            }
        } else if (this.nNn != null && this.nNr != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
            this.nNn.setVisibility(0);
            this.nNr.setVisibility(8);
        }
    }

    public boolean dMI() {
        boolean z;
        b(this.nMQ, 12);
        boolean z2 = false;
        if (this.nKO != null && this.nKO.getVisibility() == 0) {
            this.nKO.setVisibility(8);
            this.nKP.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQl);
            this.nKP.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nNr == null || this.nNr.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nNU) {
                bo();
            }
            this.nNr.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.nNn != null) {
                    c.this.nNn.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dZy() {
        if (dMI()) {
            return true;
        }
        if (this.nQM != null && this.nQM.isShowing()) {
            this.nQM.dismiss();
            return true;
        } else if (this.nRj != null && this.nRj.isShowing()) {
            this.nRj.dismiss();
            return true;
        } else if (this.nQG == null || !this.nQG.isShowing()) {
            return dZG() || dZz() || dZF() || dZn();
        } else {
            this.nQG.dismiss();
            return true;
        }
    }

    public boolean dZn() {
        if (this.nQV == null || !this.nQV.isShown()) {
            return false;
        }
        this.nQV.d();
        return true;
    }

    public boolean dZz() {
        if (this.nOy == null || !this.nOy.isShown()) {
            return false;
        }
        this.nOy.a();
        return true;
    }

    public boolean dZF() {
        if (this.nNJ == null || !this.nNJ.b()) {
            return false;
        }
        this.nNJ.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nQl != null && !((Activity) this.nQl).isFinishing() && pVar != null) {
            this.nOk = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nOc != null && mVar.a(this.nOc.mCreatorUID, null)) {
            this.nOc.mIsSubscribed = mVar.c;
            dZt();
        }
    }

    public boolean dZG() {
        if (!this.nOw || this.nQR == null) {
            return false;
        }
        if (this.nQR != null) {
            this.nQR.e();
        }
        if (this.nOZ != null) {
            this.nOZ.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nOF != null) {
                        this.nOF.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                        this.nQk.dZc().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nQk.dZc().mMicStatus.onMic) {
                            if (this.nNh != null) {
                                this.nNh.setVisibility(8);
                            }
                            if (this.nOy != null && this.nOy.isShown()) {
                                this.nOy.a();
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
                        if (this.nQk.dZc().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nOc != null && !h.isEmpty(this.nOc.mCreatorUID)) {
                                g(arrayList2, this.nOc.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.nQk.dZc().mMicStatus.onMic) {
                            if (this.nQk.dZc().mMicStatus != null && !h.isEmpty(this.nQk.dZc().mMicStatus.micRoomId) && !this.nQk.dZc().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.nQk.dZc().mMicStatus.micRoomId;
                            }
                            this.nQk.dZc().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nQk.dZc().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.nQk.dZc().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.nQk.dZc().mMicStatus, str3, z4);
                            if (this.nOy != null && this.nOy.getVisibility() == 0) {
                                this.nOy.a(this.nQk.dZc().mFanItems, this.nQk.dZc().mMicStatus, str3, z4, this.nQk.dZc().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nNh != null) {
                                this.nNh.setVisibility(8);
                            }
                            if (this.nOy != null && this.nOy.isShown()) {
                                this.nOy.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nNY != onlineVip.mCount || (this.nNf != null && this.nNf.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nNY = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dZL();
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
                            if (!z3 || System.currentTimeMillis() - this.nOQ <= 5000) {
                                z2 = false;
                            } else {
                                this.nOQ = System.currentTimeMillis();
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
                            dZu();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nOR != null) {
                    if (this.nOc == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nOc.mCreatorAvatar;
                        str2 = this.nOc.mCreatorGender;
                    }
                    this.nOR.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nJN != null && this.nJN.nME != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nJN.nME.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.nJJ != null) {
                                        this.nJJ.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nJN.nME.mInPKMode = true;
                                    this.nJN.nME.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nJN.nME.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nJN.nME.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nJN.nME.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nJN.nME.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nJN.nME.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nJN.nME.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nJN.nME.mMode = pkNotifyInfo.mMode;
                                    this.nJN.nME.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.nJO != null) {
                                        this.nJO.g(true, this.nJN.nME.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dYr().a) {
                                        if (!com.kascend.chushou.b.dYj().e) {
                                            com.kascend.chushou.b.dYj().e = true;
                                            tv.chushou.zues.utils.g.H(this.nQl, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dYr().a(this.nQl, false);
                                        dZC();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.nJN.nME.mAction = 7;
                                    this.nJN.nME.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nJN.nME.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nJN.nME.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nJN.nME.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nJN.nME.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nJN.nME.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.nJN.nME.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.nJO != null) {
                                        this.nJO.g(false, 0L);
                                        this.nJO.b(this.nJN.nME, true);
                                        this.nJO.a(this.nOT + tv.chushou.zues.utils.a.dip2px(this.nQl, 52.0f), this.aq);
                                        this.nJO.a(this.nJN.nME.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.nJJ != null) {
                                        this.nJJ.a(false);
                                    }
                                    this.nJN.nME.mInPKMode = false;
                                    this.nJN.nME.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.nJO != null) {
                                        this.nJO.c();
                                    }
                                    this.nJN.b = null;
                                    this.nJN.nME = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nJN.nME.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nJN.nME.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.nJN.nME.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nOc != null && !h.isEmpty(this.nOc.mRoomID) && this.nOc.mRoomID.equals(this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.nJN.nME.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.nJO != null) {
                                        this.nJO.a(this.nJN.nME, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nJN.nME.copyUpdate(pkNotifyInfo);
                                    if (this.nJO != null) {
                                        this.nJO.a(this.nJN.nME);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nJN.nME.copyStop(pkNotifyInfo);
                                        if (this.nJO != null) {
                                            this.nJO.B(this.nJN.nME.mMaxFreeDuration, this.nJN.nME.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nJN.nME.copyResult(pkNotifyInfo);
                                    if (!this.nOu && this.nJO != null) {
                                        int i7 = 1;
                                        if (this.nJN.nME.destinyInfo != null && this.nJN.nME.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.nJO.a(h.parseInt(this.nJN.nME.mResult), h.parseLong(this.nJN.nME.mvpUid), this.nJN.nME.mvpAvatar, this.nJN.nME.mvpNickname, this.nJN.nME.mMaxFreeDuration, this.nJN.nME.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nJQ != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nJQ.uid = cycleLiveRoomInfo.uid;
                        this.nJQ.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nJQ.roomId = cycleLiveRoomInfo.roomId;
                        this.nJQ.avatar = cycleLiveRoomInfo.avatar;
                        this.nJQ.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nQl != null && (this.nQl instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nQl).d();
                        }
                    } else {
                        ((VideoPlayer) this.nQl).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.nQk != null && this.nQk.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dYr().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dYr().b().equals(next2.mUserID)) {
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

    public void dZL() {
        if (this.nNf != null) {
            if (this.nJN == null || this.nJN.nME == null || !this.nJN.nME.mInPKMode) {
                if (this.bP > 0) {
                    this.nNf.setVisibility(0);
                    this.nNf.setText(String.format(this.nQl.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.nNj.setVisibility(0);
                    return;
                }
                this.nNf.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.nNh.setVisibility(0);
            if (this.nNi != null) {
                this.nNi.a(str, z, micStatus, this.nQk.dZc().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.nNh.setVisibility(8);
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
    public void dZI() {
        int childCount = this.nOe.getChildCount();
        int itemCount = this.nOe.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nOe);
        if (f + childCount >= itemCount) {
            this.nOl = true;
            if (this.nOm != null) {
                this.nOm.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dZR() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nOf.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nOf.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nOf == null) {
            this.nOf = new ArrayList<>();
        }
        while (2 < this.nOf.size()) {
            this.nOf.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nOh);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nOf.addAll(a2);
        int size = this.nOf.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nOf.size(); i++) {
                this.nOf.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nOi == null) {
            this.nOi = new ArrayList<>();
        }
        this.nOi.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nOk != null && this.nOk.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nOk.contains("2"))) {
                        this.nOi.add(next);
                    } else if (!this.nOk.contains(next.mType)) {
                        this.nOi.add(next);
                    }
                }
                return this.nOi;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nOf == null) {
                    this.nOf = new ArrayList<>(arrayList);
                    dZR();
                    w(z2);
                    return;
                }
                if (this.nOh == null) {
                    this.nOh = new ArrayList<>();
                }
                this.nOh.addAll(arrayList);
                int size = this.nOh.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.nOh.size(); i++) {
                        this.nOh.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nOf.size();
                if (a2 != null) {
                    this.nOf.addAll(a2);
                }
                int size3 = this.nOf.size();
                if (!this.nOl && this.nOm != null) {
                    this.nOm.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nOf.size(); i3++) {
                        this.nOf.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nOf == null) {
                this.nOf = new ArrayList<>(arrayList);
                dZR();
            } else {
                if (this.nOh == null) {
                    this.nOh = new ArrayList<>();
                }
                this.nOh.clear();
                this.nOh.addAll(arrayList);
                this.nOf.clear();
                dZR();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nOf.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nOj != null) {
                this.nOj.a(this.nOf.size());
                if (i == 1) {
                    this.nOj.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nOj.notifyItemRangeRemoved(i2, i3);
                    this.nOj.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nOj.notifyDataSetChanged();
                }
            }
            if (z || this.nOl) {
                this.nOl = true;
                if (this.nOm != null) {
                    this.nOm.setVisibility(8);
                }
                if (z) {
                    this.nOb.scrollToPosition(this.nOf.size() - 1);
                } else {
                    this.nOb.smoothScrollToPosition(this.nOf.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nOj != null) {
                this.nOj.a(this.nOf.size());
                this.nOj.notifyDataSetChanged();
            }
            if (z || this.nOl) {
                this.nOl = true;
                if (this.nOm != null) {
                    this.nOm.setVisibility(8);
                }
                if (z) {
                    this.nOb.scrollToPosition(this.nOf.size() - 1);
                } else {
                    this.nOb.smoothScrollToPosition(this.nOf.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dYO;
        RoomToast roomToast;
        this.p = false;
        if (this.nQk != null && this.nQk.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.nQk.f.size()) {
                    break;
                } else if (!"2".equals(this.nQk.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dZU();
            return;
        }
        if (this.nKd != null) {
            this.nKd.setVisibility(0);
        }
        if (this.nMV != null) {
            this.nMV.setVisibility(0);
        }
        if (this.nQk != null) {
            this.nOc = this.nQk.dZe();
            this.nOd = this.nQk.dZc();
            if (com.kascend.chushou.b.dYj().c != null && this.nOj != null) {
                this.nOj.a(com.kascend.chushou.b.dYj().c);
                this.nOj.notifyDataSetChanged();
            }
            FullRoomInfo dZc = this.nQk.dZc();
            if (dZc != null) {
                if (!h.isEmpty(dZc.mRoomToastList)) {
                    Iterator<RoomToast> it = dZc.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dYr().j())) {
                    a(roomToast);
                }
            }
            if (this.nOc != null) {
                bk();
            }
            if (this.nOc != null && !this.nOc.mIsSubscribed) {
                RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nOc == null || !c.this.nOc.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.nQk != null && this.nQk.l()) {
                d(true);
            }
        }
        if (this.nOc != null && this.nOj != null) {
            if (this.nOf != null) {
                this.nOf.clear();
            } else {
                this.nOf = new ArrayList<>();
            }
            this.nOj.a(this.nOc);
            dZR();
            this.nOj.a(this.nOf.size());
            this.nOj.notifyDataSetChanged();
        }
        dZr();
        N();
        if (this.nQl != null && (this.nQl instanceof VideoPlayer) && (dYO = ((VideoPlayer) this.nQl).dYO()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dYO.nME, dYO.b);
        }
        this.nNw.h(this.nOc.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nOc.mCreatorGender), 0, 0);
        if (this.nPX != null) {
            this.nPX.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.nNA);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dZJ() {
        if (this.nNX == null) {
            View inflate = LayoutInflater.from(this.nQl).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nLr = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nNX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQl, 160.0f), -2);
            this.nNX.setFocusable(false);
            this.nNX.setOutsideTouchable(false);
            this.nNX.setAnimationStyle(a.j.gift_toast_style);
            this.nNX.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dYr().c(roomToast.mToastContent);
            if (this.nNX == null) {
                dZJ();
            }
            if (this.nLr != null) {
                this.nLr.setText(roomToast.mToastContent);
            }
            if (!this.nNX.isShowing()) {
                if (this.nNA != null) {
                    this.nNX.showAtLocation(this.nNA, 85, 0, this.nPW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
                    RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nNX != null) {
                                c.this.nNX.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nNX.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nOM != null) {
            this.nOM.setVisibility(z ? 0 : 8);
        }
        this.nON = true;
        if (this.nQl instanceof VideoPlayer) {
            ((VideoPlayer) this.nQl).p();
        }
    }

    private void dZU() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nQl).s();
        dZn();
        dZz();
        if (this.nNl == null) {
            this.nNl = (PlayShowRecommendView) ((ViewStub) this.nPW.findViewById(a.f.view_recommend)).inflate();
        }
        this.nNl.setVisibility(0);
        if (this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null && !h.isEmpty(this.nQk.dZc().mRoominfo.mRoomID)) {
            dZM();
        }
        if (this.nPX != null) {
            this.nPX.setVisibility(8);
        }
        if (this.nQR != null) {
            this.nQR.e();
        }
        if (this.nKd != null) {
            this.nKd.setVisibility(4);
        }
        if (this.nMV != null) {
            this.nMV.setVisibility(8);
        }
        if (this.nQZ != null) {
            this.nQZ.elv();
            this.nQZ.setVisibility(8);
        }
        yw(false);
        a(false, false);
        if (this.nJJ != null) {
            this.nJJ.a();
        }
    }

    private void dZM() {
        if (this.nNl != null && this.nNl.getVisibility() == 0) {
            this.nNl.a(this.nQk.dZc().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.nQl instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.nNJ != null && this.nNJ.b()) {
            this.nNJ.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nOx);
        if (this.nQl != null) {
            if (this.nOx || "10004".equals(((VideoPlayer) this.nQl).t)) {
                this.nOx = true;
                if (this.nQk != null) {
                    this.nQk.f = null;
                    if (this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                        this.nQk.dZc().mRoominfo.mGameId = null;
                    }
                }
                dZU();
                return;
            }
            this.nOx = true;
            if (this.nQl != null) {
                ((VideoPlayer) this.nQl).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nOx = false;
        if (this.nKd != null) {
            this.nKd.setVisibility(0);
        }
        if (this.nMV != null) {
            this.nMV.setVisibility(0);
        }
        if (this.nNl != null) {
            this.nNl.setVisibility(8);
        }
        if (this.nQf != null) {
            this.nQf.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nOx = false;
        if (this.nKd != null) {
            this.nKd.setVisibility(0);
        }
        if (this.nMV != null) {
            this.nMV.setVisibility(0);
        }
        if (this.nNl != null) {
            this.nNl.setVisibility(8);
        }
        if (this.nQf != null) {
            this.nQf.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nNl != null) {
            this.nNl.setVisibility(8);
        }
        if (this.nPX != null) {
            this.nPX.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.nQk != null) {
                        this.nQk.f = null;
                        this.nQk.dZc().mRoominfo.mGameId = null;
                    }
                    dZU();
                    return;
                }
                tv.chushou.zues.utils.g.OF(a.i.str_getvideosource_failed);
            }
            yw(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.nQk != null && this.nQk.dZd() != null) {
            a(this.nQk.dZd());
        }
        this.p = false;
        if (this.nQk == null || this.nQk.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nQk.f.size()) {
                if (!"2".equals(this.nQk.f.get(i2).mType)) {
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
    public GiftAnimationLayout dZw() {
        if (this.nPW == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nPW.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nNA != null) {
            int size = iconConfig.configs.size();
            this.nNA.removeAllViews();
            if (this.nNC != null) {
                this.nNC.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nQl).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.nNA, false);
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
                            this.nNC.setVisibility(0);
                            this.nNB.bX(configDetail.mCover, a.e.ic_show_gift_n);
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
                    public void dC(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.nNA.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQl instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dYJ = ((VideoPlayer) this.nQl).dYJ();
            if (this.nRd == null) {
                this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRd.setVisibility(0);
            this.nRd.a(2, dYJ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nNE != null && this.nQl != null) {
            this.nNE.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nNE != null && this.nQl != null) {
            this.nNE.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nNE != null) {
            this.nNE.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nNE != null) {
            this.nNE.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nND != null) {
            if (this.nQl != null) {
                this.nND.a(((VideoPlayer) this.nQl).dYJ(), false);
            }
            this.nND.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nPW != null) {
            Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
            int i = gW.x > gW.y ? 1 : 2;
            if (this.nRd == null) {
                this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRd.setPlayerViewHelper(this.nQk);
            this.nRd.setVisibility(0);
            this.nRd.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nNF != null) {
            this.nNF.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nNF != null) {
            this.nNF.a(bangInfo, str);
        }
        if (this.nKr != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nKr.setText(this.nQl.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nKr.setText(this.nQl.getString(a.i.str_contribute_tittle));
            } else {
                this.nKr.setText(Html.fromHtml(this.nQl.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.nNg != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nNg.setText(this.nQl.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nNg.setText(this.nQl.getString(a.i.str_contribute_tittle));
            } else {
                this.nNg.setText(Html.fromHtml(this.nQl.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nNF != null) {
            this.nNF.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nQk != null && !h.isEmpty(this.nQk.nJu)) {
            this.nOD = this.nQk.nJu.get(0);
            if (this.nOU != null) {
                this.nOU.setVisibility(0);
                this.nOU.a(this.nOD.mCover, 0, 0, 0, 1);
                if (this.nOV != null) {
                    if (this.nOD.mShowClose) {
                        this.nOV.setVisibility(0);
                    } else {
                        this.nOV.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nNF != null) {
            this.nNF.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nPW != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nKO != null) {
            this.nKO.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nOu) {
            if (iVar.a == 52) {
                if (this.nOj != null) {
                    this.nOj.a(com.kascend.chushou.b.dYj().c);
                    this.nOj.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nOu && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.nNs != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.nNs);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nOu) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nQl, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dYK = ((VideoPlayer) this.nQl).dYK();
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(2, dYK);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dYL = ((VideoPlayer) this.nQl).dYL();
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(2, dYL);
            } else if (bVar.a == 8) {
                if (this.nOF != null && this.nOF.getVisibility() != 0) {
                    this.nOF.a(a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, this.nOc == null ? "" : this.nOc.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.nRd == null) {
                    this.nRd = (H5Container) ((ViewStub) this.nPW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRd.setVisibility(0);
                this.nRd.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.nQk != null && !h.isEmpty(this.nQk.a) && this.nQk.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nOF != null && this.nOF.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nQl, 80.0f);
                }
                if (this.nOE != null && this.nOE.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nOE.getHeight());
                }
                this.nOP.setTranslationY(-r0);
                return;
            }
            if (this.nOO != null) {
                this.nOO.cancel();
                this.nOO = null;
            }
            int translationY = (int) this.nOP.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nQl, 80.0f) : 0;
                    if (this.nOE != null && this.nOE.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nOE.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nOE.getHeight() : 0;
                    if (this.nOF != null && this.nOF.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nQl, 80.0f));
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
        this.nOO = ValueAnimator.ofInt(i, i2);
        this.nOO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.nNF != null) {
                    c.this.nOP.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nOO.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nOO = null;
            }
        });
        this.nOO.setInterpolator(new LinearInterpolator());
        this.nOO.setDuration(800L);
        this.nOO.start();
    }

    private boolean bg() {
        if (this.nOA == 1) {
            this.nOA = 2;
            x(true);
            return true;
        } else if (this.nOA == 3) {
            dZV();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.nOA == 1) {
            return bi();
        }
        if (this.nOA == 2) {
            this.nOA = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nOB || this.nQk == null || this.nQk.dZe() == null) {
            return false;
        }
        if (this.nPw != null) {
            this.nPw.a(true);
        }
        this.nOA = 3;
        this.nOB = true;
        bk();
        this.nMS.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nOB = false;
                c.this.nMU.setVisibility(8);
            }
        });
        this.nMU.startAnimation(loadAnimation);
        this.nMS.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZV() {
        if (!this.nOB) {
            if (this.nPw != null) {
                this.nPw.a(false);
            }
            this.nOA = 1;
            this.nOB = true;
            bk();
            this.nMU.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nOB = false;
                    c.this.nMS.setVisibility(8);
                }
            });
            this.nMU.startAnimation(loadAnimation);
            this.nMS.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.nPW != null) {
            if (this.nMS == null) {
                this.nMS = this.nPW.findViewById(a.f.user_space_container);
            }
            if (this.nMU == null) {
                this.nMU = this.nPW.findViewById(a.f.video_container);
            }
            if (this.nMT == null) {
                this.nMT = com.kascend.chushou.view.user.b.c(null, this.nQk.a, false, this.nQk.h);
                this.nMT.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dZV();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dZV();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.nMT).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.nMV != null) {
            this.nMV.setVisibility(z ? 8 : 0);
        }
        if (this.nNZ != null) {
            this.nOB = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nNZ.setVisibility(8);
                        c.this.nOB = false;
                    }
                });
            } else {
                this.nOB = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nNZ.setVisibility(0);
                        c.this.nOB = false;
                    }
                });
            }
            this.nNZ.startAnimation(loadAnimation);
        }
        dZy();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.nNm.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.nNu != null) {
                this.nNu.setVisibility(0);
            }
            if (this.nNv != null) {
                this.nNv.a();
                return;
            }
            return;
        }
        if (this.nNx != null) {
            this.nNx.setVisibility(0);
        }
        if (this.nNy != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.nNy.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.nNx != null) {
            this.nNx.setVisibility(8);
        }
        if (this.nNy != null) {
            this.nNy.clearAnimation();
        }
        if (this.nNu != null) {
            this.nNu.setVisibility(8);
        }
        if (this.nNv != null) {
            this.nNv.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nNZ != null && this.nPW != null) {
            if (this.nOF == null) {
                this.nOF = new com.kascend.chushou.player.ui.miniview.a(this.nQl, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nOF != null && c.this.nPW != null && c.this.nOF.a()) {
                            ((ViewGroup) c.this.nPW).removeView(c.this.nOF);
                            c.this.nOF = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOF.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nQl, 52.0f);
                this.nOF.setLayoutParams(layoutParams);
                ((ViewGroup) this.nNZ).addView(this.nOF, ((ViewGroup) this.nNZ).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nOF.setVisibility(8);
                } else {
                    this.nOF.a(a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, this.nQk.a == null ? "" : this.nQk.a);
                }
            } else if (!this.nOF.isShown()) {
                this.nOF.a(a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, this.nQk.a == null ? "" : this.nQk.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nOL != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nOL.setVisibility(0);
                this.nOL.setAnim(true);
                this.nOL.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.oOx, b.C1017b.oOz, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nOn != null && this.nOn.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dZW();
                    }
                });
                this.nOn.setVisibility(0);
                this.nOn.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nOn != null && this.nOn.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nOp != null) {
                        c.this.nOp.removeAllListeners();
                        c.this.nOp.cancel();
                        c.this.nOp = null;
                    }
                    if (c.this.nOn != null) {
                        c.this.nOn.setVisibility(8);
                    }
                }
            });
            this.nOn.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nOS == null) {
                this.nOS = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nQl, "显示双击666_num", null, new Object[0]);
                            if (c.this.nQk != null) {
                                c.this.nQk.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.nQm != null) {
                    this.nQm.e(this.nOS, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nOS != null) {
            this.nQm.L(this.nOS);
            this.nOS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nOq != null && this.nOq.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nQl, a.C0882a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dZX();
                    }
                });
                this.nOq.setVisibility(0);
                this.nOq.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nPV, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nOq != null && this.nOq.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQl, a.C0882a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nOs != null) {
                        c.this.nOs.removeAllListeners();
                        c.this.nOs.cancel();
                        c.this.nOs = null;
                    }
                    if (c.this.nOq != null) {
                        c.this.nOq.setVisibility(8);
                    }
                }
            });
            this.nOq.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dZW() {
        if (this.nOn == null || this.nOo == null) {
            return null;
        }
        if (this.nOp != null) {
            this.nOp.removeAllListeners();
            this.nOp.cancel();
            this.nOp = null;
        }
        this.nOo.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nOo, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nOo, 0.0f);
        int measuredWidth = (this.nOn.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nQl, 13.0f) * 2)) - this.nOo.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nOo, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nOo, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nOo, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nOp != null) {
                    c.this.nOp.removeAllListeners();
                    c.this.nOp.cancel();
                    c.this.nOp = null;
                }
                RxExecutor.postDelayed(c.this.nPV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dZW();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nOp = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dZX() {
        if (this.nOq == null || this.nOr == null) {
            return null;
        }
        if (this.nOs != null) {
            this.nOs.removeAllListeners();
            this.nOs.cancel();
            this.nOs = null;
        }
        this.nOr.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nOr, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nOr, 0.0f);
        int measuredWidth = (this.nOq.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nQl, 13.0f) * 2)) - this.nOr.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nOr, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nOr, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nOr, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nOs != null) {
                    c.this.nOs.removeAllListeners();
                    c.this.nOs.cancel();
                    c.this.nOs = null;
                }
                RxExecutor.postDelayed(c.this.nPV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dZX();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nOs = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nPw = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nJQ != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nJQ.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eh = com.kascend.chushou.c.a.eh(jSONObject);
                        if (eh.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.OF(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.OF(a.i.subscribe_success);
                            }
                            if (c.this.nJQ != null) {
                                c.this.nJQ.isSubscribe = !z;
                                c.this.dZs();
                                return;
                            }
                            return;
                        }
                        a(eh.mRc, eh.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.y(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dYm().a(bVar, (String) null, this.nJQ.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nJQ.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dYm().b(bVar, (String) null, c.this.nJQ.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.nQk != null && this.nOc != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.nQk.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nQk.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nOc.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eh = com.kascend.chushou.c.a.eh(jSONObject);
                        if (eh.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.OF(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.OF(a.i.subscribe_success);
                            }
                            c.this.nOc.mIsSubscribed = !z;
                            c.this.dZt();
                            return;
                        }
                        a(eh.mRc, eh.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.y(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dYm().a(bVar, (String) null, this.nOc.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nOc.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dYm().b(bVar, (String) null, c.this.nOc.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.nMD != null) {
            int width = this.nMD.getWidth();
            int height = this.nMD.getHeight();
            if (this.nOJ != width || this.nOK != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void dZC() {
        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.nPW != null) {
            if (this.nNz == null) {
                this.nNz = (InteractionView) ((ViewStub) this.nPW.findViewById(a.f.view_interaction)).inflate();
                this.nNz.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.nNz.a();
                    }
                });
            }
            if (this.nNz != null) {
                this.nNz.b(configDetail);
                this.nNz.c();
                this.nNz.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.emh()) {
                tv.chushou.zues.utils.g.H(this.nQl, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nQl, null) && (this.nQl instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQl, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nQl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQl, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nQl, configDetail.mUrl, this.nQl.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nQl, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nOw) {
                        dZG();
                        return;
                    }
                    if (this.nQl.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nQl, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.nQk != null && this.nQk.dZc() != null && this.nQk.dZc().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQk.dZc().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.nNA);
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
        if (this.nQl != null && !this.v && !h.isEmpty(str) && this.nOc != null && str.equals(this.nOc.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nJN == null) {
                this.nJN = new com.kascend.chushou.player.e.a();
            }
            this.nJN.b = str;
            this.nJN.nME.copy(pkNotifyInfo);
            if (this.nJN.nME.mAction == 6) {
                if (this.nJJ != null) {
                    this.nJJ.a(true);
                }
                this.nJN.nME.mInPKMode = true;
                this.u = this.nJN.nME.mPkId;
            } else if (this.nJN.nME.mAction == 7 || (this.nJN.nME.mMode == 1 && this.nJN.nME.mAction == 5)) {
                if (this.nJJ != null) {
                    this.nJJ.a(true);
                }
                this.nJN.nME.mInPKMode = true;
                if (this.nOH != 42) {
                    this.nOT = ((this.nOI.y - ((this.nOI.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nQl, 158.0f) + this.nNV)) - tv.chushou.zues.utils.systemBar.b.ay(getActivity());
                    aX();
                }
                this.u = this.nJN.nME.mPkId;
                if (this.nJO != null) {
                    this.nJO.b(this.nJN.nME, false);
                    this.nJO.a(this.nJN.nME.mMode, (String) null);
                    if (this.nJN.nME.mAction == 5 && this.nJN.nME.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nJN.nME.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nJN.nME.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nJN.nME.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nJN.nME.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nJN.nME.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.nJO.a(this.nJN.nME);
                        this.nJO.a(parseInt, this.nJN.nME.mPkUpdateInfo.remainDuration, j, this.nJN.nME.mMode, (this.nJN.nME.destinyInfo == null || this.nJN.nME.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.nJN.nME.mPkUpdateInfo != null && !h.isEmpty(this.nJN.nME.mPkUpdateInfo.specialMomentList) && this.nJO != null) {
                    this.nJO.a(this.nJN.nME, true);
                }
                if (this.nJN.nME.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.nJN.nME.mInPKMode = false;
                if (this.nJN.nME.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        dZD();
        dZB();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nNS != null && this.nQk != null && this.nQk.nJv != null) {
            this.nNS.setText(tv.chushou.zues.utils.b.OE(this.nQk.nJv.count));
            this.nNS.setVisibility(0);
            if (this.nQk.nJv.count < 1) {
                bo();
            }
            if (this.nNL != null) {
                this.nNL.setText(this.nQk.nJv.primaryName);
            }
            if (this.nNM != null) {
                this.nNM.setText(this.nQk.nJv.desc);
            }
            dZo();
        }
    }

    public void dZo() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nNT * h.parseLong(this.nQk.nJv.point)));
        if (this.nLg != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nQl.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.L(this.nQl, a.e.icon_coin_new);
            cVar.append(this.nQl.getString(a.i.str_buy_count_coin2));
            this.nLg.setText(cVar);
        }
    }

    private void dZY() {
        if (com.kascend.chushou.d.e.c(this.nQl, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nNT);
        }
    }

    private void bo() {
        this.nNU = false;
        this.nNR.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nQk != null && this.nQk.nJv != null) {
            if (this.nQk.nJv.count < 1) {
                this.nNS.setVisibility(8);
            } else {
                this.nNS.setVisibility(0);
                this.nNS.setSelected(false);
                this.nNS.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nNK.setVisibility(8);
        if (this.nNs != null) {
            this.nNs.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nJS != null) {
            if (z) {
                this.nJS.setVisibility(0);
            } else {
                this.nJS.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nPt != null) {
            this.nPt.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nNB != null) {
            this.nNB.performClick();
        }
    }
}
