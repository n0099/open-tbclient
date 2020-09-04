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
    public String nKC;
    private TextView nKG;
    private TextView nKJ;
    private ImageView nKP;
    private TextView nKY;
    private View nKv;
    private TextView nLJ;
    private View nLM;
    private KPSwitchPanelLinearLayout nLg;
    private ImageView nLh;
    private tv.chushou.zues.widget.kpswitch.b.c nLi;
    private d.a nLj;
    private TextView nLy;
    private TextView nMJ;
    private PlayShowMicStatusView nNA;
    private RecyclerView nNB;
    private ImageView nNC;
    private PlayShowRecommendView nND;
    private View nNE;
    private RelativeLayout nNF;
    private AnimationSet nNG;
    private ImageView nNH;
    private ImageView nNI;
    private RelativeLayout nNJ;
    private PastedEditText nNK;
    private ToggleButton nNL;
    private RelativeLayout nNM;
    private PaoPaoView nNN;
    private FrescoThumbnailView nNO;
    private LinearLayout nNP;
    private ImageView nNQ;
    private InteractionView nNR;
    private LinearLayout nNS;
    private FrescoThumbnailView nNT;
    private FrameLayout nNU;
    private RedpacketNotifier nNV;
    private InteractNotifier nNW;
    private EmbeddedButtonLayout nNX;
    private GiftAnimationLayout nNY;
    private com.kascend.chushou.player.b.a nNZ;
    private int nNi;
    private View nNj;
    private View nNk;
    private com.kascend.chushou.view.user.b nNl;
    private View nNm;
    private FrameLayout nNn;
    private LinearLayout nNo;
    private RelativeLayout nNp;
    private FrescoThumbnailView nNq;
    private TextView nNr;
    private TextView nNs;
    private TextView nNt;
    private FrescoThumbnailView nNu;
    private TextView nNv;
    private TextView nNw;
    private TextView nNx;
    private TextView nNy;
    private LinearLayout nNz;
    private ArrayList<ChatInfo> nOA;
    private Button nOE;
    private View nOF;
    private View nOG;
    private Animator nOH;
    private View nOI;
    private View nOJ;
    private Animator nOK;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nON;
    private PlayShowMicPerson nOQ;
    private FoodView nOU;
    public ListItem nOV;
    private FoodView nOW;
    private com.kascend.chushou.player.ui.miniview.a nOX;
    private int nOY;
    private int nOZ;
    private f nOa;
    private PlayShowH5View nOb;
    private LinearLayout nOc;
    private TextView nOd;
    private TextView nOe;
    private TextView nOf;
    private TextView nOg;
    private TextView nOh;
    private TextView nOi;
    private ImageView nOj;
    private TextView nOk;
    private PopupWindow nOp;
    private View nOr;
    private RecyclerView nOt;
    private RoomInfo nOu;
    private RecyclerView.LayoutManager nOw;
    private ArrayList<ChatInfo> nOx;
    private ArrayList<ChatInfo> nOy;
    private ArrayList<ChatInfo> nOz;
    private LinearLayout nPA;
    private TextView nPB;
    private TextView nPC;
    private RelativeLayout nPD;
    private RelativeLayout nPE;
    private FrescoThumbnailView nPF;
    private TextView nPG;
    private TextView nPH;
    private ImageView nPI;
    private RelativeLayout nPJ;
    private TextView nPL;
    private float nPM;
    private float nPN;
    private a nPO;
    private Point nPa;
    private FrescoThumbnailView nPd;
    private FrescoThumbnailView nPe;
    private ValueAnimator nPg;
    private LinearLayout nPh;
    private long nPi;
    private VideoShowVoteView nPj;
    private Runnable nPk;
    private FrescoThumbnailView nPm;
    private ImageView nPn;
    private RelativeLayout nPo;
    private TextView nPp;
    private ImageView nPq;
    private EditText nPr;
    private View nPs;
    private RelativeLayout nPt;
    private RelativeLayout nPu;
    private FrescoThumbnailView nPv;
    private TextView nPw;
    private TextView nPx;
    private ImageView nPy;
    private RelativeLayout nPz;
    private boolean cp = false;
    private int nOl = 1;
    private boolean nOm = false;
    private int nOn = 0;
    private int nOo = 0;
    private int nOq = -1;
    private boolean nOs = false;
    private FullRoomInfo nOv = null;
    private com.kascend.chushou.player.adapter.a nOB = null;
    private ArrayList<String> nOC = null;
    private boolean nOD = true;
    private boolean nOL = true;
    private boolean nOM = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean nOO = false;
    private boolean nOP = false;
    private long nOR = 0;
    private int nOS = 1;
    private boolean nOT = false;
    private int nPb = -1;
    private int nPc = -1;
    private boolean nPf = false;
    private int nPl = -1;
    private io.reactivex.disposables.b nPK = null;

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
        this.nKC = getArguments().getString("cover");
        this.nOL = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.nQo = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.nQo;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            dZz();
            this.nMV = ((VideoPlayer) this.nQD).dYJ();
            this.nQC = ((VideoPlayer) this.nQD).dYM();
            d(view);
            dZJ();
            if (this.nQD instanceof VideoPlayer) {
                ((VideoPlayer) this.nQD).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nOM = false;
        if (this.nRj != null) {
            this.nRj.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nOM = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nOH != null) {
            this.nOH.removeAllListeners();
            this.nOH.cancel();
            this.nOH = null;
        }
        if (this.nOK != null) {
            this.nOK.removeAllListeners();
            this.nOK.cancel();
            this.nOK = null;
        }
        if (this.nNW != null) {
            this.nNW.c();
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
        if (this.nPK != null) {
            this.nPK.dispose();
            this.nPK = null;
        }
        this.nOl = 1;
        this.nOm = false;
        if (this.nQE != null) {
            this.nQE.cl(null);
        }
        if (this.nOp != null) {
            this.nOp.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nQD, this.nLi);
        if (this.nQD != null && (this.nQD instanceof VideoPlayer)) {
            ((VideoPlayer) this.nQD).dYQ();
        }
        this.nLj = null;
        this.nLi = null;
        aI();
        if (this.nNZ != null) {
            this.nNZ.a();
        }
        if (this.nNN != null) {
            this.nNN.b();
            this.nNN.c();
            this.nNN = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.cm(this);
        if (this.nOz != null) {
            this.nOz.clear();
        }
        if (this.nOx != null) {
            this.nOx.clear();
        }
        if (this.nOA != null) {
            this.nOA.clear();
        }
        if (this.nOy != null) {
            this.nOy.clear();
        }
        if (this.nOC != null) {
            this.nOC.clear();
        }
        if (this.nOB != null) {
            this.nOB.a(0);
            this.nOB.a();
        }
    }

    private void d(View view) {
        this.nNj = view.findViewById(a.f.fl_root);
        this.nPa = tv.chushou.zues.utils.a.gX(this.nQD);
        this.nOn = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nQD);
        this.nOo = tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        this.nOZ = 86;
        this.nQC = ((VideoPlayer) this.nQD).dYM();
        if (this.nQC != null) {
            this.nOu = this.nQC.dZn();
            this.nOv = this.nQC.dZl();
        }
        this.nOx = new ArrayList<>();
        this.nOz = new ArrayList<>();
        this.nOy = new ArrayList<>();
        this.nNn = (FrameLayout) this.nQo.findViewById(a.f.fl_effect);
        b();
        this.nQx = (PlayerErrorView) this.nQo.findViewById(a.f.view_net_error_msg);
        this.nQx.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.nNM = (RelativeLayout) this.nQo.findViewById(a.f.rl_audio_ani);
        this.nNN = (PaoPaoView) this.nQo.findViewById(a.f.audio_ani);
        this.nNO = (FrescoThumbnailView) this.nQo.findViewById(a.f.audio_ani_avatar);
        this.nNP = (LinearLayout) this.nQo.findViewById(a.f.ll_audio);
        this.nMJ = (TextView) this.nQo.findViewById(a.f.tv_open_video);
        this.nNQ = (ImageView) this.nQo.findViewById(a.f.iv_audio_ani);
        this.nPe = (FrescoThumbnailView) this.nQo.findViewById(a.f.live_cover);
        if (!this.nPf || this.nMV == null || this.nMV.getPlayState() != 4) {
            this.nPe.setVisibility(0);
            this.nPe.setBlur(true);
            this.nPe.i(this.nKC, 0, 0, 0);
        }
        this.nMJ.setOnClickListener(this);
        this.nKg = new b();
        this.nKg.a(view, null, this.nQD, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cvE()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.nQC != null) {
                    append.append(c.this.nQC.dZn().mRoomID);
                }
                if (c.this.nKf != null && c.this.nKf.nMW != null) {
                    append.append("&mode=").append(c.this.nKf.nMW.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nQD, append.toString());
            }
        });
        this.nKk = (VoiceInteractionView) this.nQo.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.nQC != null) {
            this.nOu = this.nQC.dZn();
            this.nOv = this.nQC.dZl();
        }
        aL();
        dZy();
        dZE();
        this.nPh = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nOU = (FoodView) view.findViewById(a.f.rav_ad);
        this.nPm = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nPn = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nPm.setOnClickListener(this);
        this.nPn.setOnClickListener(this);
        this.nPo = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nPd = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nPd.setOnClickListener(this);
        this.nNW = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.nNV = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nOE = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nOE.setOnClickListener(this);
        this.nOt = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nOt.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOt.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nPa.x, this.nPa.y) * 0.83d);
        this.nOt.setLayoutParams(layoutParams);
        this.nOw = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nQD);
        this.nOt.setLayoutManager(this.nOw);
        this.nOt.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nOt.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nOt.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dZR();
                } else if (i == 1) {
                    c.this.nOD = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nOB = new com.kascend.chushou.player.adapter.a(this.nQD, this.nOx);
        if (this.nOu != null) {
            this.nOB.a(this.nOu);
        }
        if (com.kascend.chushou.b.dYs().c != null) {
            this.nOB.a(com.kascend.chushou.b.dYs().c);
        }
        this.nOt.setAdapter(this.nOB);
        this.nOB.a(this.nOx.size());
        this.nOB.notifyDataSetChanged();
        if (this.nQC != null && (c = this.nQC.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.nNZ != null) {
            this.nNZ.a();
            this.nNZ = null;
        }
        this.nNY = (GiftAnimationLayout) this.nQo.findViewById(a.f.ll_gift_animation);
        this.nNY.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.nNi = ((int) (tv.chushou.zues.utils.a.gW(this.nQD).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nQD, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nNY.getLayoutParams();
        layoutParams2.bottomMargin = this.nNi;
        this.nNY.setLayoutParams(layoutParams2);
        if (this.nQC != null) {
            this.nNZ = new com.kascend.chushou.player.b.a(this.nQD.getApplicationContext(), this.nNY);
            this.nNZ.a(this.nQC);
            a(this.nQC.nJL, this.nQC.nJO);
        }
        this.nQo.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.nNX = (EmbeddedButtonLayout) this.nQo.findViewById(a.f.embedded_button_layout);
        this.nNX.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nPj = (VideoShowVoteView) this.nQo.findViewById(a.f.view_video_show_vote);
        this.nPj.setOnClickListener(this);
        this.nPj.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.nQC != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
            this.nNX.a(videoPlayer.dYW().eaq());
            this.nNX.b(this.nQC.i());
            this.nNV.a(videoPlayer.dYS(), false);
            this.nNW.a(videoPlayer.dYT(), videoPlayer.dYU(), videoPlayer.dYV());
            this.nKf = new com.kascend.chushou.player.e.a();
        }
        this.nRt = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nOO = false;
                c.this.b(c.this.nNi, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nOO = true;
                if (c.this.nRj != null) {
                    c.this.nRj.measure(0, 0);
                    int measuredHeight = c.this.nRj.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nQD, 14.0f);
                    if (measuredHeight > c.this.nNi) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.nRn = (PaoGuideView) this.nQo.findViewById(a.f.rlPaoGuideView);
        this.nOQ = (PlayShowMicPerson) this.nQo.findViewById(a.f.rl_mic_person_view);
        this.nOb = (PlayShowH5View) this.nQo.findViewById(a.f.rl_playshowh5);
        this.nOW = (FoodView) this.nQo.findViewById(a.f.bottom_ad);
        if (this.nQC != null) {
            H();
            if (this.nQC.nJE != null && !h.isEmpty(this.nQC.nJE.mUrl)) {
                b(this.nQC.nJE);
            }
        }
        this.nOF = this.nQo.findViewById(a.f.view_reminder_subscribe);
        this.nOG = this.nOF.findViewById(a.f.spash_subscribe);
        ((TextView) this.nOF.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().L(this.nQD, a.e.videoplayer_reminder_subscribe).append(" ").append(this.nQD.getString(a.i.videoplayer_reminder_subscribe)));
        this.nOF.setOnClickListener(this);
        this.nOI = this.nQo.findViewById(a.f.view_reminder_danmaku);
        this.nOJ = this.nOI.findViewById(a.f.spash_danmaku);
        ((TextView) this.nOI.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().L(this.nQD, a.e.videoplayer_reminder_danmaku).append(" ").append(this.nQD.getString(a.i.videoplayer_reminder_danmaku)));
        this.nOI.setOnClickListener(this);
    }

    private void dZy() {
        this.nPt = (RelativeLayout) this.nQo.findViewById(a.f.rl_cyclelive);
        this.nPu = (RelativeLayout) this.nQo.findViewById(a.f.rlrl_cyclelive);
        this.nPv = (FrescoThumbnailView) this.nQo.findViewById(a.f.iv_liveicon);
        this.nPw = (TextView) this.nQo.findViewById(a.f.tv_livename);
        this.nPx = (TextView) this.nQo.findViewById(a.f.tv_livedesc);
        this.nPy = (ImageView) this.nQo.findViewById(a.f.iv_cyclelive_name_menu);
        this.nPz = (RelativeLayout) this.nQo.findViewById(a.f.rl_normal);
        this.nPA = (LinearLayout) this.nQo.findViewById(a.f.ll_cyclelive_nickname);
        this.nPB = (TextView) this.nQo.findViewById(a.f.tv_cyclelive_nickname);
        this.nPC = (TextView) this.nQo.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nPD = (RelativeLayout) this.nQo.findViewById(a.f.rl_clear_cyclelive);
        this.nPE = (RelativeLayout) this.nQo.findViewById(a.f.rlrl_clear_cyclelive);
        this.nPF = (FrescoThumbnailView) this.nQo.findViewById(a.f.iv_clear_liveicon);
        this.nPG = (TextView) this.nQo.findViewById(a.f.tv_clear_livename);
        this.nPH = (TextView) this.nQo.findViewById(a.f.tv_clear_livedesc);
        this.nPI = (ImageView) this.nQo.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nPJ = (RelativeLayout) this.nQo.findViewById(a.f.rl_clear_normal);
        this.nPI.setOnClickListener(this);
        this.nPy.setOnClickListener(this);
        this.nPC.setOnClickListener(this);
        this.nPB.setOnClickListener(this);
        this.nPv.setOnClickListener(this);
        this.nPF.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nQC.nJC != null && this.nOW != null) {
            this.nOW.a(true, this.nQC.a == null ? "" : this.nQC.a);
            this.nOW.a(this.nQC.nJC, a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nQC != null && this.nQC.nJJ != null && this.nNX != null) {
            this.nOU.a(this.nQC.nJJ, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.nQC != null) {
                        c.this.nQC.nJJ = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dZQ() {
        return this.nNZ;
    }

    private void dZz() {
        this.nQE = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.nQo != null && (textView = (TextView) c.this.nQo.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nQD.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nQE.B(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nQE);
                        break;
                    case 12:
                        c.this.b(c.this.nQE);
                        break;
                    case 17:
                        c.this.eal();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.nQB.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nOs) {
            this.nOs = true;
            if (this.nOr == null) {
                this.nOr = this.nQo.findViewById(a.f.vs_async_show_content);
                this.nOr = ((ViewStub) this.nOr).inflate();
            }
            this.nKv = this.nQo.findViewById(a.f.ui_content);
            if (this.nLM == null) {
                this.nLM = this.nQo.findViewById(a.f.vs_async_notification_view);
                this.nLM = ((ViewStub) this.nLM).inflate();
            }
            c(this.nQo);
            k();
            dMM();
            if (this.c == null) {
                this.nJZ = new d.a();
                this.c = new GestureDetector(this.nQD, this.nJZ);
            }
            ((VideoPlayer) this.nQD).q();
        }
    }

    private void aL() {
        this.nNo = (LinearLayout) this.nQo.findViewById(a.f.ll_anchor);
        this.nNp = (RelativeLayout) this.nQo.findViewById(a.f.ll_clear_anchor);
        this.nNo.setVisibility(4);
        this.nNp.setVisibility(4);
        this.nNq = (FrescoThumbnailView) this.nQo.findViewById(a.f.iv_clear_avatar);
        this.nNr = (TextView) this.nQo.findViewById(a.f.tv_clear_nickname);
        this.nNs = (TextView) this.nQo.findViewById(a.f.tv_clear_online_count);
        this.nNt = (TextView) this.nQo.findViewById(a.f.tv_clear_btn_subscribe);
        this.nNt.setOnClickListener(this);
        this.nNu = (FrescoThumbnailView) this.nQo.findViewById(a.f.iv_avatar);
        this.nNv = (TextView) this.nQo.findViewById(a.f.tv_nickname_test);
        this.nNw = (TextView) this.nQo.findViewById(a.f.tv_online_count);
        this.nKG = (TextView) this.nQo.findViewById(a.f.tv_btn_subscribe);
        this.nKG.setOnClickListener(this);
        this.nNx = (TextView) this.nQo.findViewById(a.f.tv_loyal_counts);
        this.nKJ = (TextView) this.nQo.findViewById(a.f.tv_btn_contribution);
        this.nNy = (TextView) this.nQo.findViewById(a.f.tv_btn_contribution_forpk);
        this.nKJ.setVisibility(4);
        this.nNy.setVisibility(8);
        this.nNz = (LinearLayout) this.nQo.findViewById(a.f.ll_mic);
        this.nNA = (PlayShowMicStatusView) this.nQo.findViewById(a.f.show_mic_status);
        this.nNB = (RecyclerView) this.nQo.findViewById(a.f.rv_loyal);
        this.nNC = (ImageView) this.nQo.findViewById(a.f.iv_clear_close);
        this.nKP = (ImageView) this.nQo.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.nNB.setLayoutManager(linearLayoutManager);
        this.nON = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void C(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nQD, (JSONObject) null, c.this.nQC.dZn().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.emi(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nQD, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQD, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQD, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQD, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nQD, a.c.color_979797), dip2px);
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
        this.nNB.setAdapter(this.nON);
        this.nNz.setOnClickListener(this);
        this.nNq.setOnClickListener(this);
        this.nNC.setOnClickListener(this);
        this.nNu.setOnClickListener(this);
        this.nNq.setOnClickListener(this);
        this.nKP.setOnClickListener(this);
        this.nNx.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dC(View view) {
                String str = tv.chushou.common.a.cvE() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.nQC != null) {
                    str = str + c.this.nQC.dZn().mRoomID;
                }
                c.this.f(c.this.nQD.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nKJ.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dC(View view) {
                String str = tv.chushou.common.a.cvE() + "m/room-billboard/";
                if (c.this.nQC != null) {
                    str = str + c.this.nQC.dZn().mRoomID;
                }
                c.this.f(c.this.nQD.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.nNy.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dC(View view) {
                String str = tv.chushou.common.a.cvE() + "m/room-billboard/";
                if (c.this.nQC != null) {
                    str = str + c.this.nQC.dZn().mRoomID;
                }
                c.this.f(c.this.nQD.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nOv == null || this.nOv.cycleLiveRoomInfo == null || h.isEmpty(this.nOv.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nKi = this.nOv.cycleLiveRoomInfo;
        }
        if (z2 && this.nKi != null) {
            this.nPt.setVisibility(0);
            this.nPD.setVisibility(0);
            this.nPz.setVisibility(8);
            this.nPJ.setVisibility(8);
            this.nPA.setVisibility(0);
            this.nPF.h(this.nKi.eventIcon, com.kascend.chushou.view.a.a(this.nOu.mCreatorGender), b.a.small, b.a.small);
            this.nPv.h(this.nKi.eventIcon, com.kascend.chushou.view.a.a(this.nOu.mCreatorGender), b.a.small, b.a.small);
            this.nPG.setText(this.nKi.eventName);
            this.nPH.setText(this.nKi.eventDesc);
            this.nPw.setText(this.nKi.eventName);
            this.nPx.setText(this.nKi.eventDesc);
            this.nPB.setText(this.nKi.nickname);
            dZB();
            if (z) {
                c(this.nKi.remainTime);
                return;
            }
            return;
        }
        this.nPt.setVisibility(8);
        this.nPD.setVisibility(8);
        this.nPz.setVisibility(0);
        this.nPJ.setVisibility(0);
        this.nPA.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nPK != null) {
            this.nPK.dispose();
            this.nPK = null;
        }
        this.nPK = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.efe()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nQD != null && (c.this.nQD instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nQD).u();
                }
            }
        });
    }

    private void dZA() {
        if (this.nOu != null && this.nOs) {
            this.nNo.setVisibility(0);
            this.nNp.setVisibility(0);
            this.nKJ.setVisibility(0);
            this.nNq.h(this.nOu.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nOu.mCreatorGender), b.a.small, b.a.small);
            this.nNr.setText(this.nOu.mCreatorNickname);
            this.nNu.h(this.nOu.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nOu.mCreatorGender), b.a.small, b.a.small);
            this.nNv.setText(this.nOu.mCreatorNickname);
            eac();
            dZC();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void eac() {
        if (this.nOu != null) {
            this.nNs.setText(tv.chushou.zues.utils.b.formatNumber(this.nOu.mOnlineCount));
            this.nNw.setText(tv.chushou.zues.utils.b.formatNumber(this.nOu.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZB() {
        if (this.nKi != null) {
            if (this.nKi.isSubscribe) {
                this.nPC.setText(a.i.like_already);
                this.nPC.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nPC.setText(getString(a.i.like));
            this.nPC.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZC() {
        if (this.nOu != null) {
            if (this.nOu.mIsSubscribed) {
                this.nNt.setText(getString(a.i.like_already));
                this.nNt.setBackgroundResource(a.e.bg_show_subcribe);
                this.nKG.setText(getString(a.i.like_already));
                this.nKG.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nNt.setText(getString(a.i.like));
            this.nNt.setBackgroundResource(a.e.bg_show_subcribe);
            this.nKG.setText(getString(a.i.like));
            this.nKG.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dZD() {
        if (this.nON != null) {
            this.nON.notifyDataSetChanged();
        }
    }

    private void dZE() {
        this.nNE = this.nQo.findViewById(a.f.tv_interact);
        this.nNE.setOnClickListener(this);
        this.nNJ = (RelativeLayout) this.nQo.findViewById(a.f.rl_edit_bar);
        this.nNH = (ImageView) this.nQo.findViewById(a.f.btn_hotword);
        this.nNH.setOnClickListener(this);
        this.nNI = (ImageView) this.nQo.findViewById(a.f.iv_task_badge);
        this.nNG = (AnimationSet) AnimationUtils.loadAnimation(this.nQD, a.C0882a.anim_hotword);
        this.nNG.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dYA().c) {
                    c.this.nNH.clearAnimation();
                    c.this.nNH.startAnimation(c.this.nNG);
                }
            }
        });
        if (com.kascend.chushou.d.h.dYA().c) {
            this.nNH.startAnimation(this.nNG);
            this.nNI.setVisibility(0);
        }
        this.nPL = (TextView) this.nQo.findViewById(a.f.tv_bottom_input);
        this.nPL.setOnClickListener(this);
        this.nRE = (FrescoThumbnailView) this.nQo.findViewById(a.f.ll_btn_set);
        this.nRE.setOnClickListener(this);
        this.nRE.Ck(a.e.ic_room_set_btn_white);
        this.nNS = (LinearLayout) this.nQo.findViewById(a.f.ll_bottom_all_button);
        this.nNT = (FrescoThumbnailView) this.nQo.findViewById(a.f.fl_clear_bottom_gift);
        this.nNT.setAnim(true);
        this.nNT.setOnClickListener(this);
        this.nNT.Ck(a.e.ic_show_gift_n);
        this.nNU = (FrameLayout) this.nQo.findViewById(a.f.flfl_clear_bottom_gift);
        this.nNU.setVisibility(8);
        this.nNF = (RelativeLayout) this.nQo.findViewById(a.f.rl_bottom_input);
        this.nNF.setVisibility(0);
        this.nNK = (PastedEditText) this.nQo.findViewById(a.f.et_bottom_input);
        this.nNK.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nKY.setEnabled(editable.length() > 0);
            }
        });
        this.nNK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nKY);
                    return true;
                }
                return true;
            }
        });
        this.nNK.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.nNK);
                }
                return false;
            }
        });
        this.nLh = (ImageView) this.nQo.findViewById(a.f.iv_btn_emoji);
        this.nLh.setVisibility(8);
        this.nKY = (TextView) this.nQo.findViewById(a.f.tv_btn_send);
        this.nKY.setOnClickListener(this);
        this.nOc = (LinearLayout) this.nQo.findViewById(a.f.head_trumpet);
        this.nOc.setVisibility(8);
        this.nOc.setOnClickListener(this);
        this.nOd = (TextView) this.nQo.findViewById(a.f.tv_primary_name);
        this.nOe = (TextView) this.nQo.findViewById(a.f.tv_primary_desc);
        this.nOg = (TextView) this.nQo.findViewById(a.f.tv_cut_count);
        this.nOg.setOnClickListener(this);
        this.nOi = (TextView) this.nQo.findViewById(a.f.tv_head_count);
        this.nOi.setText(this.nOl + "");
        this.nOh = (TextView) this.nQo.findViewById(a.f.tv_plus_count);
        this.nOh.setOnClickListener(this);
        this.nLy = (TextView) this.nQo.findViewById(a.f.tv_buy_count_coin);
        this.nOf = (TextView) this.nQo.findViewById(a.f.tv_buy_head);
        this.nOf.setOnClickListener(this);
        this.nOj = (ImageView) this.nQo.findViewById(a.f.iv_trumpet_select);
        this.nOj.setOnClickListener(this);
        this.nOk = (TextView) this.nQo.findViewById(a.f.tv_trumpet_have_count);
        this.nOm = false;
        this.nOj.setBackgroundResource(a.e.ic_trumpet_n);
        this.nOk.setVisibility(8);
        this.nLg = (KPSwitchPanelLinearLayout) this.nQo.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nLg, this.nLh, this.nNK, new a.InterfaceC1018a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1018a
            public void yv(boolean z) {
                if (c.this.nLh != null) {
                    if (z) {
                        c.this.nLg.setDirectVisibility(0);
                        c.this.nLh.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nLh.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nLj = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void yw(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.nLh.setImageResource(a.e.cs_emoji_normal);
                    c.this.dZG();
                    if (c.this.nPs != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nPs.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hi(c.this.nQD);
                        c.this.nPs.setLayoutParams(layoutParams);
                    }
                    if (c.this.nNJ != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.nNJ.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hi(c.this.nQD);
                        c.this.nNJ.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nPs != null && c.this.nPs.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nPs.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nPs.setLayoutParams(layoutParams3);
                    c.this.nPs.setVisibility(8);
                }
                if (c.this.nOO) {
                    c.this.nRj.setVisibility(0);
                }
                if (c.this.nQD != null && (c.this.nQD instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nQD).yu(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.nNJ != null && c.this.nLg.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.nNJ.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.nNJ.setLayoutParams(layoutParams4);
                }
            }
        };
        this.nLi = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nLg, this.nLj, ((VideoPlayer) this.nQD).dYR());
        ((VideoPlayer) this.nQD).h(((VideoPlayer) this.nQD).dYR());
        this.nPs = this.nQo.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nPp = (TextView) this.nQo.findViewById(a.f.btn_room_search);
        this.nPq = (ImageView) this.nQo.findViewById(a.f.iv_room_emoji_delete);
        this.nPr = (EditText) this.nQo.findViewById(a.f.et_room_emoji_search);
        this.nPr.setImeOptions(3);
        this.nPr.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nPp);
                    return true;
                }
                return false;
            }
        });
        this.nPr.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nPp.setEnabled(editable.length() > 0);
                c.this.nPq.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.nRj.setEmojiSearchText(editable.toString());
            }
        });
        this.nPp.setOnClickListener(this);
        this.nPq.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aB(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dM(this.nPr);
            this.nPs.setVisibility(0);
            this.nPr.requestFocus();
        } else {
            this.nPs.setVisibility(8);
        }
        if (z2) {
            this.nPr.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZG() {
        int hi = tv.chushou.zues.widget.kpswitch.b.d.hi(this.nQD) + tv.chushou.zues.utils.a.dip2px(this.nQD, 14.0f);
        if (hi > this.nNi) {
            b(hi, 12);
        }
    }

    private void aS() {
    }

    private void dZJ() {
        if (this.nOo > 0) {
            View findViewById = this.nQo.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.nOo);
        }
        if (this.nOn > 0) {
            View findViewById2 = this.nQo.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nOn, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nOL) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.nKb = ((VideoPlayer) this.nQD).dYN();
        this.nKb.a(this);
        if (this.nQC.dZl() != null) {
            s();
        } else if (this.nQp != null) {
            this.nQp.setVisibility(0);
        }
        if (this.nKb != null) {
            this.nKb.d();
        }
    }

    private void dZK() {
        if ((this.nKf == null || this.nKf.nMW == null || !this.nKf.nMW.mInPKMode) ? false : true) {
            if (this.nNj != null) {
                this.nNj.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nKh.getLayoutParams();
            layoutParams.leftMargin = (this.nPa.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nQD, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.nKh.setLayoutParams(layoutParams);
            this.y.setText(this.nKf.nMW.mPkUserNickname);
            this.nKh.setVisibility(0);
            this.nNz.setVisibility(8);
            return;
        }
        if (this.nNj != null) {
            this.nNj.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.nKh.setVisibility(8);
    }

    private void dZM() {
        boolean z = false;
        if (this.nKf != null && this.nKf.nMW != null && this.nKf.nMW.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nPl > 0 && this.nOt != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOt.getLayoutParams();
                if (layoutParams.height != this.nPl) {
                    layoutParams.height = this.nPl;
                    this.nOt.setLayoutParams(layoutParams);
                }
            }
            this.nNi = ((int) (tv.chushou.zues.utils.a.gW(this.nQD).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nQD, 84.0f);
            b(this.nNi, 12);
        } else {
            if (this.nOt != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nOt.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nQD, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nQD, 250.0f);
                    this.nOt.setLayoutParams(layoutParams2);
                }
            }
            this.nNi = ((int) (tv.chushou.zues.utils.a.gW(this.nQD).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nQD, 84.0f);
            b(this.nNi, 12);
        }
        if (this.nKg != null) {
            this.nKg.a(this.nPl + tv.chushou.zues.utils.a.dip2px(this.nQD, 52.0f), this.aq);
        }
        if (this.nKk != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nKk.getLayoutParams();
            layoutParams3.bottomMargin = this.nPl + tv.chushou.zues.utils.a.dip2px(this.nQD, 52.0f);
            this.nKk.setLayoutParams(layoutParams3);
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

    private void dZN() {
        dZM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) eaj().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nQp.getLayoutParams();
        this.nPa = tv.chushou.zues.utils.a.gX(this.nQD);
        this.nOZ = 86;
        this.dB = (Math.max(this.nPa.x, this.nPa.y) - tv.chushou.zues.utils.a.dip2px(this.nQD, (this.nOZ + 52) + 250)) - this.nOn;
        this.nOY = Math.max(this.nPa.x, this.nPa.y) - ((tv.chushou.zues.utils.a.dip2px(this.nQD, this.nOZ) + this.nOn) * 2);
        if (this.nPb <= 0 || this.nPc <= 0) {
            this.nPb = Math.min(this.nPa.x, this.nPa.y);
            this.nPc = Math.max(this.nPa.x, this.nPa.y);
        }
        this.ar = Math.min(this.nPa.x, this.nPa.y);
        this.aq = (this.ar * this.nPc) / this.nPb;
        boolean z = false;
        if (this.nKf == null || this.nKf.nMW == null) {
            i = 1;
        } else {
            i = this.nKf.nMW.mMode;
            if (this.nKf.nMW.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.nOZ = 42;
            if (i == 2) {
                if (this.nPc < this.nPb) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nPb * layoutParams.height) / this.nPc;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, this.nOZ) + this.nOn;
            layoutParams.gravity = 48;
            this.nPl = ((this.nPa.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nQD, (this.nOZ + 52) + 64) + this.nOn)) - tv.chushou.zues.utils.systemBar.b.ay(getActivity());
            aG();
        } else if (this.E) {
            this.nOZ = 42;
            if (this.nPc < this.nPb) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nPb * layoutParams.height) / this.nPc;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, this.nOZ) + this.nOn;
            layoutParams.gravity = 48;
            this.nPl = ((this.nPa.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nQD, (this.nOZ + 52) + 98) + this.nOn)) - tv.chushou.zues.utils.systemBar.b.ay(getActivity());
            dZN();
        } else {
            this.nPl = -1;
            this.nOZ = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, this.nOZ) + this.nOn;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.nOY) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, this.nOZ) + this.nOn;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nPa.x, this.nPa.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nPb) / this.nPc >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nPb) / this.nPc;
                    } else if ((this.ar * this.nPc) / this.nPb >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nPc) / this.nPb;
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
                    if ((this.ar * this.nPc) / this.nPb > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nPb) / this.nPc;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nPc) / this.nPb;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nPc) / this.nPb;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nPb) / this.nPc;
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
        if (this.nQC != null && this.nQC.d) {
            layoutParams.width = Math.min(this.nPa.x, this.nPa.y);
            layoutParams.height = Math.max(this.nPa.x, this.nPa.y);
        }
        eaj().setLayoutParams(layoutParams);
        this.nQp.setLayoutParams(layoutParams2);
        this.nQp.requestLayout();
    }

    private void aY() {
        this.nQp = new SurfaceRenderView(this.nQD);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.nQp;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        eaj().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nOT) {
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
        if (this.nPO != null) {
            this.nPO.a();
        }
        if (this.nQC != null && !h.isEmpty(this.nQC.w)) {
            b(this.nQC.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nMV != null) {
            int width = this.nMV.getWidth();
            int height = this.nMV.getHeight();
            if (this.nPb != width || this.nPc != height || this.nPb <= 0 || this.nPc <= 0) {
                this.nPb = width;
                this.nPc = height;
                if (this.nQp != null) {
                    this.nQp.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.nOO) {
                dZP();
            } else {
                if (this.nQD.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击送礼_num", "竖屏", new Object[0]);
                if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQC.dZl().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.nOm) {
                f(this.nNK.getText().toString());
            } else {
                a(this.nNK.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dYA().c) {
                com.kascend.chushou.d.h.dYA().b(false);
                this.nNG.cancel();
                this.nNG.reset();
                this.nNH.clearAnimation();
                this.nNI.setVisibility(8);
            }
            n(view, 0, this.nQo.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nQD, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.nQo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.nQC.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.nQC.d) {
                dMF();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nOt != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nOu != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nOS = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nQD, (JSONObject) null, this.nQC.dZn().mRoomID, this.nQC.dZn().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.nQD.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nQD, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nOV != null) {
                    com.kascend.chushou.d.e.a(this.nQD, this.nOV, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nPo != null) {
                    this.nPo.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nQD, null) && this.nQC != null && this.nQC.nJN != null) {
                    if (this.nOm) {
                        bo();
                    } else {
                        if (this.nQC != null && this.nQC.nJN != null && this.nQC.nJN.count > 0) {
                            this.nOc.setVisibility(8);
                        } else {
                            this.nOc.setVisibility(0);
                        }
                        this.nOm = true;
                        this.nOj.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nOk.setVisibility(0);
                        this.nOk.setSelected(true);
                        this.nOk.setTextColor(Color.parseColor("#ff5959"));
                        if (this.nNK != null) {
                            this.nNK.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nOl <= 9) {
                    this.nOl++;
                    this.nOi.setText(this.nOl + "");
                }
                dZx();
            } else if (id == a.f.tv_cut_count) {
                if (this.nOl > 1) {
                    this.nOl--;
                    this.nOi.setText(this.nOl + "");
                }
                dZx();
            } else if (id == a.f.tv_buy_head) {
                eah();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nPr.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nPr.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nPs.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dN(this.nPr);
                    this.nRj.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nKi != null && !h.isEmpty(this.nKi.eventUrl)) {
                    f("", this.nKi.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nKi != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nKi != null) {
                    com.kascend.chushou.d.a.a(this.nQD, (JSONObject) null, this.nKi.roomId, this.nKi.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.nQC.a(false);
                    ((VideoPlayer) this.nQD).l();
                } else {
                    ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
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
        if (this.nOb != null) {
            int i = (tv.chushou.zues.utils.a.gW(this.nQD).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOb.getLayoutParams();
            layoutParams.topMargin = i;
            this.nOb.setLayoutParams(layoutParams);
            this.nOb.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.nOb.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
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
        } else if (System.currentTimeMillis() - this.nOR <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.OF(a.i.str_too_fast);
            return false;
        } else {
            dMR();
            if (!com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a(((VideoPlayer) this.nQD).dYM().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nOR = System.currentTimeMillis();
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                a(this.nQC.dZl().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nQC.h);
            }
            g(this.b);
            if (!z && this.nNK != null) {
                this.nNK.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dMR();
            if (com.kascend.chushou.d.e.c(this.nQD, null) && LoginManager.Instance().getUserInfo() != null && this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                a(this.nQC.dZl().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nNK != null) {
                this.nNK.setText((CharSequence) null);
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
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nQC.dZl().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nQC.dZl().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nQD).nIc;
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
        if (this.nRe != null && this.nRe.isShowing()) {
            this.nRe.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
        if (this.nRB == null) {
            i(3);
        }
        this.nRB.getContentView().setBackgroundResource(0);
        this.nRB.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.nRB.isShowing()) {
            this.nRB.showAtLocation(view, 83, i, i2);
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nQC.dZl().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nRB.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.nRF)) {
            if (((VideoPlayer) this.nQD).q) {
                this.nRE.Ck(a.e.ic_room_set_btn_white);
            } else {
                this.nRE.Ck(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nQD).q && this.nRF.size() == 2 && this.nRF.contains("4") && this.nRF.contains("2")) {
            this.nRE.Ck(a.e.ic_room_set_btn_system_white);
        } else if (this.nRF.size() > 1 || !((VideoPlayer) this.nQD).q) {
            this.nRE.Ck(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.nRF.get(0))) {
            this.nRE.Ck(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.nRF.get(0))) {
            this.nRE.Ck(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.nRF.get(0))) {
            this.nRE.Ck(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
        if (this.nRe == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.nRe.getContentView().setBackgroundResource(0);
            this.nRe.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nRe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nNH.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.nRe.isShowing()) {
            this.nRe.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nQD, 16.0f) + i2);
            this.nNH.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nQC.dZl().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nRe.dismiss();
    }

    private void e(View view) {
        if (this.nQY == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.dYA().q()) {
            this.nNL.emg();
        } else {
            this.nNL.emh();
        }
        int height = this.nQo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity());
        if (view != null) {
            this.nQY.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.nQY == null) {
            View inflate = LayoutInflater.from(this.nQD).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.nNL = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dYA().q()) {
                this.nNL.emg();
            } else {
                this.nNL.emh();
            }
            this.nNL.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dYA().g(z);
                }
            });
            this.nQS = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nQT = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nQS.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nQS.setVisibility(0);
            } else {
                this.nQS.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dYA().a) {
                this.nQT.b();
            } else {
                this.nQT.c();
            }
            if (this.nQC != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.nQC.f;
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
                                if (this.nKf == null || !this.nKf.nMW.mInPKMode || h.isEmpty(this.nKf.b) || this.nOu == null || !this.nKf.b.equals(this.nOu.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nQD).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dZm = this.nQC.dZm();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nQD).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQD, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, 5.0f);
                                            }
                                            int identifier = this.nQD.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nQD.getPackageName());
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
                                                if (dZm != null && dZm.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nQD.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nQD).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dZm2 = this.nQC.dZm();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nQD).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nQD, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, 5.0f);
                                        }
                                        int identifier2 = this.nQD.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nQD.getPackageName());
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
                                            if (dZm2 != null && dZm2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.nQY.dismiss();
                    }
                }
            });
            this.nQY = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 150.0f), -2);
            this.nQY.setFocusable(true);
            this.nQY.setOutsideTouchable(true);
            this.nQY.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nQY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nQY = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
            if (this.nOa == null) {
                this.nOa = new f(getActivity());
            }
            this.nOa.a(this.nQC.dZl().mRoominfo, this.ax);
            if (!this.nOa.isShowing()) {
                this.nOa.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nOT) {
            return false;
        }
        if (this.nOS == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nPM = motionEvent.getX();
                    this.nPN = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nPM;
                    if (Math.abs(f) > Math.abs(y - this.nPN) && Math.abs(f) > q && f > 0.0f) {
                        eae();
                        return true;
                    }
                    this.nPM = 0.0f;
                    this.nPN = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nPs != null && this.nPs.getVisibility() == 0 && a(motionEvent, this.nPs)) {
                this.nPs.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dN(this.nPr);
                return true;
            } else if (this.nOO && this.nPs != null && this.nPs.getVisibility() == 8 && f(this.nRj.b, motionEvent)) {
                dZP();
                return true;
            } else if (this.nOb != null && this.nOb.b() && f(this.nOb, motionEvent)) {
                this.nOb.a();
                return true;
            } else if (this.nNR != null && this.nNR.b() && f(this.nNR, motionEvent)) {
                this.nNR.a();
                return true;
            } else if (a(motionEvent, this.nNJ)) {
                return dMR();
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
            if (this.nRv != null && this.nRv.a(i, keyEvent)) {
                return true;
            }
            if ((this.nOb != null && this.nOb.onKeyDown(i, keyEvent)) || dZH()) {
                return true;
            }
            if (this.nOS == 3) {
                this.nOS = 1;
                eae();
                return true;
            } else if (this.nNR != null && this.nNR.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nNK != null && this.nNF != null && this.nNJ != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.nNK);
                this.nNF.setVisibility(8);
                this.nNJ.setVisibility(0);
            }
        } else if (this.nNF != null && this.nNJ != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
            this.nNF.setVisibility(0);
            this.nNJ.setVisibility(8);
        }
    }

    public boolean dMR() {
        boolean z;
        b(this.nNi, 12);
        boolean z2 = false;
        if (this.nLg != null && this.nLg.getVisibility() == 0) {
            this.nLg.setVisibility(8);
            this.nLh.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nQD);
            this.nLh.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nNJ == null || this.nNJ.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.nOm) {
                bo();
            }
            this.nNJ.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.nNF != null) {
                    c.this.nNF.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dZH() {
        if (dMR()) {
            return true;
        }
        if (this.nRe != null && this.nRe.isShowing()) {
            this.nRe.dismiss();
            return true;
        } else if (this.nRB != null && this.nRB.isShowing()) {
            this.nRB.dismiss();
            return true;
        } else if (this.nQY == null || !this.nQY.isShowing()) {
            return dZP() || dZI() || dZO() || dZw();
        } else {
            this.nQY.dismiss();
            return true;
        }
    }

    public boolean dZw() {
        if (this.nRn == null || !this.nRn.isShown()) {
            return false;
        }
        this.nRn.d();
        return true;
    }

    public boolean dZI() {
        if (this.nOQ == null || !this.nOQ.isShown()) {
            return false;
        }
        this.nOQ.a();
        return true;
    }

    public boolean dZO() {
        if (this.nOb == null || !this.nOb.b()) {
            return false;
        }
        this.nOb.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nQD != null && !((Activity) this.nQD).isFinishing() && pVar != null) {
            this.nOC = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nOu != null && mVar.a(this.nOu.mCreatorUID, null)) {
            this.nOu.mIsSubscribed = mVar.c;
            dZC();
        }
    }

    public boolean dZP() {
        if (!this.nOO || this.nRj == null) {
            return false;
        }
        if (this.nRj != null) {
            this.nRj.e();
        }
        if (this.nPr != null) {
            this.nPr.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nOX != null) {
                        this.nOX.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                        this.nQC.dZl().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nQC.dZl().mMicStatus.onMic) {
                            if (this.nNz != null) {
                                this.nNz.setVisibility(8);
                            }
                            if (this.nOQ != null && this.nOQ.isShown()) {
                                this.nOQ.a();
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
                        if (this.nQC.dZl().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nOu != null && !h.isEmpty(this.nOu.mCreatorUID)) {
                                g(arrayList2, this.nOu.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.nQC.dZl().mMicStatus.onMic) {
                            if (this.nQC.dZl().mMicStatus != null && !h.isEmpty(this.nQC.dZl().mMicStatus.micRoomId) && !this.nQC.dZl().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.nQC.dZl().mMicStatus.micRoomId;
                            }
                            this.nQC.dZl().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nQC.dZl().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.nQC.dZl().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.nQC.dZl().mMicStatus, str3, z4);
                            if (this.nOQ != null && this.nOQ.getVisibility() == 0) {
                                this.nOQ.a(this.nQC.dZl().mFanItems, this.nQC.dZl().mMicStatus, str3, z4, this.nQC.dZl().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nNz != null) {
                                this.nNz.setVisibility(8);
                            }
                            if (this.nOQ != null && this.nOQ.isShown()) {
                                this.nOQ.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nOq != onlineVip.mCount || (this.nNx != null && this.nNx.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nOq = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dZU();
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
                            if (!z3 || System.currentTimeMillis() - this.nPi <= 5000) {
                                z2 = false;
                            } else {
                                this.nPi = System.currentTimeMillis();
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
                            dZD();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nPj != null) {
                    if (this.nOu == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nOu.mCreatorAvatar;
                        str2 = this.nOu.mCreatorGender;
                    }
                    this.nPj.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nKf != null && this.nKf.nMW != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nKf.nMW.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.nKb != null) {
                                        this.nKb.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nKf.nMW.mInPKMode = true;
                                    this.nKf.nMW.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nKf.nMW.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nKf.nMW.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nKf.nMW.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nKf.nMW.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nKf.nMW.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nKf.nMW.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nKf.nMW.mMode = pkNotifyInfo.mMode;
                                    this.nKf.nMW.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.nKg != null) {
                                        this.nKg.g(true, this.nKf.nMW.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dYA().a) {
                                        if (!com.kascend.chushou.b.dYs().e) {
                                            com.kascend.chushou.b.dYs().e = true;
                                            tv.chushou.zues.utils.g.H(this.nQD, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dYA().a(this.nQD, false);
                                        dZL();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.nKf.nMW.mAction = 7;
                                    this.nKf.nMW.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nKf.nMW.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nKf.nMW.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nKf.nMW.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nKf.nMW.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nKf.nMW.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.nKf.nMW.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.nKg != null) {
                                        this.nKg.g(false, 0L);
                                        this.nKg.b(this.nKf.nMW, true);
                                        this.nKg.a(this.nPl + tv.chushou.zues.utils.a.dip2px(this.nQD, 52.0f), this.aq);
                                        this.nKg.a(this.nKf.nMW.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.nKb != null) {
                                        this.nKb.a(false);
                                    }
                                    this.nKf.nMW.mInPKMode = false;
                                    this.nKf.nMW.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.nKg != null) {
                                        this.nKg.c();
                                    }
                                    this.nKf.b = null;
                                    this.nKf.nMW = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nKf.nMW.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nKf.nMW.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.nKf.nMW.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nOu != null && !h.isEmpty(this.nOu.mRoomID) && this.nOu.mRoomID.equals(this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.nKf.nMW.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.nKg != null) {
                                        this.nKg.a(this.nKf.nMW, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nKf.nMW.copyUpdate(pkNotifyInfo);
                                    if (this.nKg != null) {
                                        this.nKg.a(this.nKf.nMW);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nKf.nMW.copyStop(pkNotifyInfo);
                                        if (this.nKg != null) {
                                            this.nKg.B(this.nKf.nMW.mMaxFreeDuration, this.nKf.nMW.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nKf.nMW.copyResult(pkNotifyInfo);
                                    if (!this.nOM && this.nKg != null) {
                                        int i7 = 1;
                                        if (this.nKf.nMW.destinyInfo != null && this.nKf.nMW.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.nKg.a(h.parseInt(this.nKf.nMW.mResult), h.parseLong(this.nKf.nMW.mvpUid), this.nKf.nMW.mvpAvatar, this.nKf.nMW.mvpNickname, this.nKf.nMW.mMaxFreeDuration, this.nKf.nMW.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nKi != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nKi.uid = cycleLiveRoomInfo.uid;
                        this.nKi.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nKi.roomId = cycleLiveRoomInfo.roomId;
                        this.nKi.avatar = cycleLiveRoomInfo.avatar;
                        this.nKi.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nQD != null && (this.nQD instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nQD).d();
                        }
                    } else {
                        ((VideoPlayer) this.nQD).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.nQC != null && this.nQC.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dYA().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dYA().b().equals(next2.mUserID)) {
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

    public void dZU() {
        if (this.nNx != null) {
            if (this.nKf == null || this.nKf.nMW == null || !this.nKf.nMW.mInPKMode) {
                if (this.bP > 0) {
                    this.nNx.setVisibility(0);
                    this.nNx.setText(String.format(this.nQD.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.nNB.setVisibility(0);
                    return;
                }
                this.nNx.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.nNz.setVisibility(0);
            if (this.nNA != null) {
                this.nNA.a(str, z, micStatus, this.nQC.dZl().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.nNz.setVisibility(8);
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
    public void dZR() {
        int childCount = this.nOw.getChildCount();
        int itemCount = this.nOw.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nOw);
        if (f + childCount >= itemCount) {
            this.nOD = true;
            if (this.nOE != null) {
                this.nOE.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void eaa() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nOx.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nOx.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nOx == null) {
            this.nOx = new ArrayList<>();
        }
        while (2 < this.nOx.size()) {
            this.nOx.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nOz);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nOx.addAll(a2);
        int size = this.nOx.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nOx.size(); i++) {
                this.nOx.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nOA == null) {
            this.nOA = new ArrayList<>();
        }
        this.nOA.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nOC != null && this.nOC.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nOC.contains("2"))) {
                        this.nOA.add(next);
                    } else if (!this.nOC.contains(next.mType)) {
                        this.nOA.add(next);
                    }
                }
                return this.nOA;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nOx == null) {
                    this.nOx = new ArrayList<>(arrayList);
                    eaa();
                    w(z2);
                    return;
                }
                if (this.nOz == null) {
                    this.nOz = new ArrayList<>();
                }
                this.nOz.addAll(arrayList);
                int size = this.nOz.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.nOz.size(); i++) {
                        this.nOz.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nOx.size();
                if (a2 != null) {
                    this.nOx.addAll(a2);
                }
                int size3 = this.nOx.size();
                if (!this.nOD && this.nOE != null) {
                    this.nOE.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nOx.size(); i3++) {
                        this.nOx.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nOx == null) {
                this.nOx = new ArrayList<>(arrayList);
                eaa();
            } else {
                if (this.nOz == null) {
                    this.nOz = new ArrayList<>();
                }
                this.nOz.clear();
                this.nOz.addAll(arrayList);
                this.nOx.clear();
                eaa();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nOx.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nOB != null) {
                this.nOB.a(this.nOx.size());
                if (i == 1) {
                    this.nOB.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nOB.notifyItemRangeRemoved(i2, i3);
                    this.nOB.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nOB.notifyDataSetChanged();
                }
            }
            if (z || this.nOD) {
                this.nOD = true;
                if (this.nOE != null) {
                    this.nOE.setVisibility(8);
                }
                if (z) {
                    this.nOt.scrollToPosition(this.nOx.size() - 1);
                } else {
                    this.nOt.smoothScrollToPosition(this.nOx.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nOB != null) {
                this.nOB.a(this.nOx.size());
                this.nOB.notifyDataSetChanged();
            }
            if (z || this.nOD) {
                this.nOD = true;
                if (this.nOE != null) {
                    this.nOE.setVisibility(8);
                }
                if (z) {
                    this.nOt.scrollToPosition(this.nOx.size() - 1);
                } else {
                    this.nOt.smoothScrollToPosition(this.nOx.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dYX;
        RoomToast roomToast;
        this.p = false;
        if (this.nQC != null && this.nQC.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.nQC.f.size()) {
                    break;
                } else if (!"2".equals(this.nQC.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            ead();
            return;
        }
        if (this.nKv != null) {
            this.nKv.setVisibility(0);
        }
        if (this.nNn != null) {
            this.nNn.setVisibility(0);
        }
        if (this.nQC != null) {
            this.nOu = this.nQC.dZn();
            this.nOv = this.nQC.dZl();
            if (com.kascend.chushou.b.dYs().c != null && this.nOB != null) {
                this.nOB.a(com.kascend.chushou.b.dYs().c);
                this.nOB.notifyDataSetChanged();
            }
            FullRoomInfo dZl = this.nQC.dZl();
            if (dZl != null) {
                if (!h.isEmpty(dZl.mRoomToastList)) {
                    Iterator<RoomToast> it = dZl.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dYA().j())) {
                    a(roomToast);
                }
            }
            if (this.nOu != null) {
                bk();
            }
            if (this.nOu != null && !this.nOu.mIsSubscribed) {
                RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nOu == null || !c.this.nOu.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.nQC != null && this.nQC.l()) {
                d(true);
            }
        }
        if (this.nOu != null && this.nOB != null) {
            if (this.nOx != null) {
                this.nOx.clear();
            } else {
                this.nOx = new ArrayList<>();
            }
            this.nOB.a(this.nOu);
            eaa();
            this.nOB.a(this.nOx.size());
            this.nOB.notifyDataSetChanged();
        }
        dZA();
        N();
        if (this.nQD != null && (this.nQD instanceof VideoPlayer) && (dYX = ((VideoPlayer) this.nQD).dYX()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dYX.nMW, dYX.b);
        }
        this.nNO.h(this.nOu.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nOu.mCreatorGender), 0, 0);
        if (this.nQp != null) {
            this.nQp.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.nNS);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dZS() {
        if (this.nOp == null) {
            View inflate = LayoutInflater.from(this.nQD).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nLJ = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nOp = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nQD, 160.0f), -2);
            this.nOp.setFocusable(false);
            this.nOp.setOutsideTouchable(false);
            this.nOp.setAnimationStyle(a.j.gift_toast_style);
            this.nOp.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dYA().c(roomToast.mToastContent);
            if (this.nOp == null) {
                dZS();
            }
            if (this.nLJ != null) {
                this.nLJ.setText(roomToast.mToastContent);
            }
            if (!this.nOp.isShowing()) {
                if (this.nNS != null) {
                    this.nOp.showAtLocation(this.nNS, 85, 0, this.nQo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ay(getActivity()));
                    RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nOp != null) {
                                c.this.nOp.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nOp.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nPe != null) {
            this.nPe.setVisibility(z ? 0 : 8);
        }
        this.nPf = true;
        if (this.nQD instanceof VideoPlayer) {
            ((VideoPlayer) this.nQD).p();
        }
    }

    private void ead() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nQD).s();
        dZw();
        dZI();
        if (this.nND == null) {
            this.nND = (PlayShowRecommendView) ((ViewStub) this.nQo.findViewById(a.f.view_recommend)).inflate();
        }
        this.nND.setVisibility(0);
        if (this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null && !h.isEmpty(this.nQC.dZl().mRoominfo.mRoomID)) {
            dZV();
        }
        if (this.nQp != null) {
            this.nQp.setVisibility(8);
        }
        if (this.nRj != null) {
            this.nRj.e();
        }
        if (this.nKv != null) {
            this.nKv.setVisibility(4);
        }
        if (this.nNn != null) {
            this.nNn.setVisibility(8);
        }
        if (this.nRr != null) {
            this.nRr.elE();
            this.nRr.setVisibility(8);
        }
        yy(false);
        a(false, false);
        if (this.nKb != null) {
            this.nKb.a();
        }
    }

    private void dZV() {
        if (this.nND != null && this.nND.getVisibility() == 0) {
            this.nND.a(this.nQC.dZl().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.nQD instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nQD;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.nOb != null && this.nOb.b()) {
            this.nOb.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nOP);
        if (this.nQD != null) {
            if (this.nOP || "10004".equals(((VideoPlayer) this.nQD).t)) {
                this.nOP = true;
                if (this.nQC != null) {
                    this.nQC.f = null;
                    if (this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                        this.nQC.dZl().mRoominfo.mGameId = null;
                    }
                }
                ead();
                return;
            }
            this.nOP = true;
            if (this.nQD != null) {
                ((VideoPlayer) this.nQD).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nOP = false;
        if (this.nKv != null) {
            this.nKv.setVisibility(0);
        }
        if (this.nNn != null) {
            this.nNn.setVisibility(0);
        }
        if (this.nND != null) {
            this.nND.setVisibility(8);
        }
        if (this.nQx != null) {
            this.nQx.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nOP = false;
        if (this.nKv != null) {
            this.nKv.setVisibility(0);
        }
        if (this.nNn != null) {
            this.nNn.setVisibility(0);
        }
        if (this.nND != null) {
            this.nND.setVisibility(8);
        }
        if (this.nQx != null) {
            this.nQx.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nND != null) {
            this.nND.setVisibility(8);
        }
        if (this.nQp != null) {
            this.nQp.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.nQC != null) {
                        this.nQC.f = null;
                        this.nQC.dZl().mRoominfo.mGameId = null;
                    }
                    ead();
                    return;
                }
                tv.chushou.zues.utils.g.OF(a.i.str_getvideosource_failed);
            }
            yy(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.nQC != null && this.nQC.dZm() != null) {
            a(this.nQC.dZm());
        }
        this.p = false;
        if (this.nQC == null || this.nQC.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nQC.f.size()) {
                if (!"2".equals(this.nQC.f.get(i2).mType)) {
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
    public GiftAnimationLayout dZF() {
        if (this.nQo == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nQo.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nNS != null) {
            int size = iconConfig.configs.size();
            this.nNS.removeAllViews();
            if (this.nNU != null) {
                this.nNU.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nQD).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.nNS, false);
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
                            this.nNU.setVisibility(0);
                            this.nNT.bX(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.nNS.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (this.nQD instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dYS = ((VideoPlayer) this.nQD).dYS();
            if (this.nRv == null) {
                this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRv.setVisibility(0);
            this.nRv.a(2, dYS);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nNW != null && this.nQD != null) {
            this.nNW.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nNW != null && this.nQD != null) {
            this.nNW.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (this.nNW != null) {
            this.nNW.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (this.nNW != null) {
            this.nNW.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nNV != null) {
            if (this.nQD != null) {
                this.nNV.a(((VideoPlayer) this.nQD).dYS(), false);
            }
            this.nNV.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nQo != null) {
            Point gW = tv.chushou.zues.utils.a.gW(this.nQD);
            int i = gW.x > gW.y ? 1 : 2;
            if (this.nRv == null) {
                this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nRv.setPlayerViewHelper(this.nQC);
            this.nRv.setVisibility(0);
            this.nRv.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nNX != null) {
            this.nNX.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nNX != null) {
            this.nNX.a(bangInfo, str);
        }
        if (this.nKJ != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nKJ.setText(this.nQD.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nKJ.setText(this.nQD.getString(a.i.str_contribute_tittle));
            } else {
                this.nKJ.setText(Html.fromHtml(this.nQD.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.nNy != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nNy.setText(this.nQD.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nNy.setText(this.nQD.getString(a.i.str_contribute_tittle));
            } else {
                this.nNy.setText(Html.fromHtml(this.nQD.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nNX != null) {
            this.nNX.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nQC != null && !h.isEmpty(this.nQC.nJM)) {
            this.nOV = this.nQC.nJM.get(0);
            if (this.nPm != null) {
                this.nPm.setVisibility(0);
                this.nPm.a(this.nOV.mCover, 0, 0, 0, 1);
                if (this.nPn != null) {
                    if (this.nOV.mShowClose) {
                        this.nPn.setVisibility(0);
                    } else {
                        this.nPn.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nNX != null) {
            this.nNX.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nQo != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nLg != null) {
            this.nLg.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nOM) {
            if (iVar.a == 52) {
                if (this.nOB != null) {
                    this.nOB.a(com.kascend.chushou.b.dYs().c);
                    this.nOB.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nOM && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.nNK != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.nNK);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nOM) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nQD, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dYT = ((VideoPlayer) this.nQD).dYT();
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(2, dYT);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dYU = ((VideoPlayer) this.nQD).dYU();
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(2, dYU);
            } else if (bVar.a == 8) {
                if (this.nOX != null && this.nOX.getVisibility() != 0) {
                    this.nOX.a(a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, this.nOu == null ? "" : this.nOu.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.nRv == null) {
                    this.nRv = (H5Container) ((ViewStub) this.nQo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nRv.setVisibility(0);
                this.nRv.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.nQC != null && !h.isEmpty(this.nQC.a) && this.nQC.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nOX != null && this.nOX.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nQD, 80.0f);
                }
                if (this.nOW != null && this.nOW.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nOW.getHeight());
                }
                this.nPh.setTranslationY(-r0);
                return;
            }
            if (this.nPg != null) {
                this.nPg.cancel();
                this.nPg = null;
            }
            int translationY = (int) this.nPh.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nQD, 80.0f) : 0;
                    if (this.nOW != null && this.nOW.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nOW.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nOW.getHeight() : 0;
                    if (this.nOX != null && this.nOX.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nQD, 80.0f));
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
        this.nPg = ValueAnimator.ofInt(i, i2);
        this.nPg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.nNX != null) {
                    c.this.nPh.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nPg.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nPg = null;
            }
        });
        this.nPg.setInterpolator(new LinearInterpolator());
        this.nPg.setDuration(800L);
        this.nPg.start();
    }

    private boolean bg() {
        if (this.nOS == 1) {
            this.nOS = 2;
            x(true);
            return true;
        } else if (this.nOS == 3) {
            eae();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.nOS == 1) {
            return bi();
        }
        if (this.nOS == 2) {
            this.nOS = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nOT || this.nQC == null || this.nQC.dZn() == null) {
            return false;
        }
        if (this.nPO != null) {
            this.nPO.a(true);
        }
        this.nOS = 3;
        this.nOT = true;
        bk();
        this.nNk.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nOT = false;
                c.this.nNm.setVisibility(8);
            }
        });
        this.nNm.startAnimation(loadAnimation);
        this.nNk.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eae() {
        if (!this.nOT) {
            if (this.nPO != null) {
                this.nPO.a(false);
            }
            this.nOS = 1;
            this.nOT = true;
            bk();
            this.nNm.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nOT = false;
                    c.this.nNk.setVisibility(8);
                }
            });
            this.nNm.startAnimation(loadAnimation);
            this.nNk.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.nQo != null) {
            if (this.nNk == null) {
                this.nNk = this.nQo.findViewById(a.f.user_space_container);
            }
            if (this.nNm == null) {
                this.nNm = this.nQo.findViewById(a.f.video_container);
            }
            if (this.nNl == null) {
                this.nNl = com.kascend.chushou.view.user.b.c(null, this.nQC.a, false, this.nQC.h);
                this.nNl.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.eae();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.eae();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.nNl).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.nNn != null) {
            this.nNn.setVisibility(z ? 8 : 0);
        }
        if (this.nOr != null) {
            this.nOT = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nOr.setVisibility(8);
                        c.this.nOT = false;
                    }
                });
            } else {
                this.nOT = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nOr.setVisibility(0);
                        c.this.nOT = false;
                    }
                });
            }
            this.nOr.startAnimation(loadAnimation);
        }
        dZH();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.nNE.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.nNM != null) {
                this.nNM.setVisibility(0);
            }
            if (this.nNN != null) {
                this.nNN.a();
                return;
            }
            return;
        }
        if (this.nNP != null) {
            this.nNP.setVisibility(0);
        }
        if (this.nNQ != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.nNQ.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.nNP != null) {
            this.nNP.setVisibility(8);
        }
        if (this.nNQ != null) {
            this.nNQ.clearAnimation();
        }
        if (this.nNM != null) {
            this.nNM.setVisibility(8);
        }
        if (this.nNN != null) {
            this.nNN.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nOr != null && this.nQo != null) {
            if (this.nOX == null) {
                this.nOX = new com.kascend.chushou.player.ui.miniview.a(this.nQD, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nOX != null && c.this.nQo != null && c.this.nOX.a()) {
                            ((ViewGroup) c.this.nQo).removeView(c.this.nOX);
                            c.this.nOX = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nOX.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nQD, 52.0f);
                this.nOX.setLayoutParams(layoutParams);
                ((ViewGroup) this.nOr).addView(this.nOX, ((ViewGroup) this.nOr).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nOX.setVisibility(8);
                } else {
                    this.nOX.a(a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, this.nQC.a == null ? "" : this.nQC.a);
                }
            } else if (!this.nOX.isShown()) {
                this.nOX.a(a.C0882a.slide_in_bottom_danmu_anim, a.C0882a.slide_out_bottom_danmu_anim, this.nQC.a == null ? "" : this.nQC.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nPd != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nPd.setVisibility(0);
                this.nPd.setAnim(true);
                this.nPd.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.oOP, b.C1017b.oOR, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nOF != null && this.nOF.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eaf();
                    }
                });
                this.nOF.setVisibility(0);
                this.nOF.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nOF != null && this.nOF.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nOH != null) {
                        c.this.nOH.removeAllListeners();
                        c.this.nOH.cancel();
                        c.this.nOH = null;
                    }
                    if (c.this.nOF != null) {
                        c.this.nOF.setVisibility(8);
                    }
                }
            });
            this.nOF.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nPk == null) {
                this.nPk = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nQD, "显示双击666_num", null, new Object[0]);
                            if (c.this.nQC != null) {
                                c.this.nQC.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.nQE != null) {
                    this.nQE.e(this.nPk, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nPk != null) {
            this.nQE.L(this.nPk);
            this.nPk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nOI != null && this.nOI.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nQD, a.C0882a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.eag();
                    }
                });
                this.nOI.setVisibility(0);
                this.nOI.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nQn, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nOI != null && this.nOI.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nQD, a.C0882a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nOK != null) {
                        c.this.nOK.removeAllListeners();
                        c.this.nOK.cancel();
                        c.this.nOK = null;
                    }
                    if (c.this.nOI != null) {
                        c.this.nOI.setVisibility(8);
                    }
                }
            });
            this.nOI.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator eaf() {
        if (this.nOF == null || this.nOG == null) {
            return null;
        }
        if (this.nOH != null) {
            this.nOH.removeAllListeners();
            this.nOH.cancel();
            this.nOH = null;
        }
        this.nOG.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nOG, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nOG, 0.0f);
        int measuredWidth = (this.nOF.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nQD, 13.0f) * 2)) - this.nOG.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nOG, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nOG, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nOG, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nOH != null) {
                    c.this.nOH.removeAllListeners();
                    c.this.nOH.cancel();
                    c.this.nOH = null;
                }
                RxExecutor.postDelayed(c.this.nQn, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eaf();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nOH = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator eag() {
        if (this.nOI == null || this.nOJ == null) {
            return null;
        }
        if (this.nOK != null) {
            this.nOK.removeAllListeners();
            this.nOK.cancel();
            this.nOK = null;
        }
        this.nOJ.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nOJ, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nOJ, 0.0f);
        int measuredWidth = (this.nOI.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nQD, 13.0f) * 2)) - this.nOJ.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nOJ, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nOJ, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nOJ, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nOK != null) {
                    c.this.nOK.removeAllListeners();
                    c.this.nOK.cancel();
                    c.this.nOK = null;
                }
                RxExecutor.postDelayed(c.this.nQn, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.eag();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nOK = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nPO = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nKi != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nKi.isSubscribe;
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
                            if (c.this.nKi != null) {
                                c.this.nKi.isSubscribe = !z;
                                c.this.dZB();
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
                com.kascend.chushou.c.c.dYv().a(bVar, (String) null, this.nKi.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nKi.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dYv().b(bVar, (String) null, c.this.nKi.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.nQC != null && this.nOu != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.nQC.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nQC.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nOu.mIsSubscribed;
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
                            c.this.nOu.mIsSubscribed = !z;
                            c.this.dZC();
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
                com.kascend.chushou.c.c.dYv().a(bVar, (String) null, this.nOu.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nOu.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dYv().b(bVar, (String) null, c.this.nOu.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.nMV != null) {
            int width = this.nMV.getWidth();
            int height = this.nMV.getHeight();
            if (this.nPb != width || this.nPc != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void dZL() {
        ((VideoPlayer) this.nQD).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.nQo != null) {
            if (this.nNR == null) {
                this.nNR = (InteractionView) ((ViewStub) this.nQo.findViewById(a.f.view_interaction)).inflate();
                this.nNR.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.nNR.a();
                    }
                });
            }
            if (this.nNR != null) {
                this.nNR.b(configDetail);
                this.nNR.c();
                this.nNR.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.emq()) {
                tv.chushou.zues.utils.g.H(this.nQD, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nQD, null) && (this.nQD instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQC != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQD, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nQD, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nQC != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nQD, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nQD, configDetail.mUrl, this.nQD.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nQD, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nOO) {
                        dZP();
                        return;
                    }
                    if (this.nQD.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nQD, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.nQC != null && this.nQC.dZl() != null && this.nQC.dZl().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.nQC.dZl().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.nNS);
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
        if (this.nQD != null && !this.v && !h.isEmpty(str) && this.nOu != null && str.equals(this.nOu.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nKf == null) {
                this.nKf = new com.kascend.chushou.player.e.a();
            }
            this.nKf.b = str;
            this.nKf.nMW.copy(pkNotifyInfo);
            if (this.nKf.nMW.mAction == 6) {
                if (this.nKb != null) {
                    this.nKb.a(true);
                }
                this.nKf.nMW.mInPKMode = true;
                this.u = this.nKf.nMW.mPkId;
            } else if (this.nKf.nMW.mAction == 7 || (this.nKf.nMW.mMode == 1 && this.nKf.nMW.mAction == 5)) {
                if (this.nKb != null) {
                    this.nKb.a(true);
                }
                this.nKf.nMW.mInPKMode = true;
                if (this.nOZ != 42) {
                    this.nPl = ((this.nPa.y - ((this.nPa.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nQD, 158.0f) + this.nOn)) - tv.chushou.zues.utils.systemBar.b.ay(getActivity());
                    aX();
                }
                this.u = this.nKf.nMW.mPkId;
                if (this.nKg != null) {
                    this.nKg.b(this.nKf.nMW, false);
                    this.nKg.a(this.nKf.nMW.mMode, (String) null);
                    if (this.nKf.nMW.mAction == 5 && this.nKf.nMW.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nKf.nMW.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nKf.nMW.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nKf.nMW.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nKf.nMW.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nKf.nMW.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.nKg.a(this.nKf.nMW);
                        this.nKg.a(parseInt, this.nKf.nMW.mPkUpdateInfo.remainDuration, j, this.nKf.nMW.mMode, (this.nKf.nMW.destinyInfo == null || this.nKf.nMW.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.nKf.nMW.mPkUpdateInfo != null && !h.isEmpty(this.nKf.nMW.mPkUpdateInfo.specialMomentList) && this.nKg != null) {
                    this.nKg.a(this.nKf.nMW, true);
                }
                if (this.nKf.nMW.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.nKf.nMW.mInPKMode = false;
                if (this.nKf.nMW.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        dZM();
        dZK();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nOk != null && this.nQC != null && this.nQC.nJN != null) {
            this.nOk.setText(tv.chushou.zues.utils.b.OE(this.nQC.nJN.count));
            this.nOk.setVisibility(0);
            if (this.nQC.nJN.count < 1) {
                bo();
            }
            if (this.nOd != null) {
                this.nOd.setText(this.nQC.nJN.primaryName);
            }
            if (this.nOe != null) {
                this.nOe.setText(this.nQC.nJN.desc);
            }
            dZx();
        }
    }

    public void dZx() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nOl * h.parseLong(this.nQC.nJN.point)));
        if (this.nLy != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nQD.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.L(this.nQD, a.e.icon_coin_new);
            cVar.append(this.nQD.getString(a.i.str_buy_count_coin2));
            this.nLy.setText(cVar);
        }
    }

    private void eah() {
        if (com.kascend.chushou.d.e.c(this.nQD, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nOl);
        }
    }

    private void bo() {
        this.nOm = false;
        this.nOj.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nQC != null && this.nQC.nJN != null) {
            if (this.nQC.nJN.count < 1) {
                this.nOk.setVisibility(8);
            } else {
                this.nOk.setVisibility(0);
                this.nOk.setSelected(false);
                this.nOk.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nOc.setVisibility(8);
        if (this.nNK != null) {
            this.nNK.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nKk != null) {
            if (z) {
                this.nKk.setVisibility(0);
            } else {
                this.nKk.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nPL != null) {
            this.nPL.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nNT != null) {
            this.nNT.performClick();
        }
    }
}
