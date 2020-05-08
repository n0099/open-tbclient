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
/* loaded from: classes5.dex */
public class c extends com.kascend.chushou.player.d implements View.OnClickListener {
    private TextView mqD;
    private TextView mqG;
    private ImageView mqM;
    private TextView mqV;
    private View mqs;
    public String mqz;
    private TextView mrF;
    private View mrI;
    private KPSwitchPanelLinearLayout mrd;
    private ImageView mre;
    private tv.chushou.zues.widget.kpswitch.b.c mrg;
    private d.a mrh;
    private TextView mrv;
    private TextView msH;
    private PlayShowMicStatusView mtA;
    private RecyclerView mtB;
    private ImageView mtC;
    private PlayShowRecommendView mtD;
    private View mtE;
    private RelativeLayout mtF;
    private AnimationSet mtG;
    private ImageView mtH;
    private ImageView mtI;
    private RelativeLayout mtJ;
    private PastedEditText mtK;
    private ToggleButton mtL;
    private RelativeLayout mtM;
    private PaoPaoView mtN;
    private FrescoThumbnailView mtO;
    private LinearLayout mtP;
    private ImageView mtQ;
    private InteractionView mtR;
    private LinearLayout mtS;
    private FrescoThumbnailView mtT;
    private FrameLayout mtU;
    private RedpacketNotifier mtV;
    private InteractNotifier mtW;
    private EmbeddedButtonLayout mtX;
    private GiftAnimationLayout mtY;
    private com.kascend.chushou.player.b.a mtZ;
    private int mth;
    private View mti;
    private View mtj;
    private com.kascend.chushou.view.user.b mtk;
    private View mtl;
    private FrameLayout mtm;
    private LinearLayout mtn;
    private RelativeLayout mto;
    private FrescoThumbnailView mtp;
    private TextView mtq;
    private TextView mtr;
    private TextView mts;
    private FrescoThumbnailView mtt;
    private TextView mtu;
    private TextView mtv;
    private TextView mtw;
    private int mtx;
    private TextView mty;
    private LinearLayout mtz;
    private ArrayList<ChatInfo> muA;
    private Button muE;
    private View muF;
    private View muG;
    private Animator muH;
    private View muI;
    private View muJ;
    private Animator muK;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> muN;
    private PlayShowMicPerson muR;
    private FoodView muU;
    public ListItem muV;
    private FoodView muW;
    private com.kascend.chushou.player.ui.miniview.a muX;
    private int muY;
    private int muZ;
    private f mua;
    private PlayShowH5View mub;
    private LinearLayout muc;
    private TextView mud;
    private TextView mue;
    private TextView muf;
    private TextView mug;
    private TextView muh;
    private TextView mui;
    private ImageView muj;
    private TextView muk;
    private PopupWindow mup;
    private View mur;
    private RecyclerView mut;
    private RoomInfo muu;
    private RecyclerView.LayoutManager muw;
    private ArrayList<ChatInfo> mux;
    private ArrayList<ChatInfo> muy;
    private ArrayList<ChatInfo> muz;
    private RelativeLayout mvA;
    private LinearLayout mvB;
    private TextView mvC;
    private TextView mvD;
    private RelativeLayout mvE;
    private RelativeLayout mvF;
    private FrescoThumbnailView mvG;
    private TextView mvH;
    private TextView mvI;
    private ImageView mvJ;
    private RelativeLayout mvK;
    private TextView mvM;
    private float mvN;
    private float mvO;
    private a mvP;
    private int mva;
    private Point mvb;
    private FrescoThumbnailView mve;
    private FrescoThumbnailView mvf;
    private ValueAnimator mvh;
    private LinearLayout mvi;
    private long mvj;
    private VideoShowVoteView mvk;
    private Runnable mvl;
    private FrescoThumbnailView mvn;
    private ImageView mvo;
    private RelativeLayout mvp;
    private TextView mvq;
    private ImageView mvr;
    private EditText mvs;
    private View mvt;
    private RelativeLayout mvu;
    private RelativeLayout mvv;
    private FrescoThumbnailView mvw;
    private TextView mvx;
    private TextView mvy;
    private ImageView mvz;
    private boolean mrf = false;
    private int mul = 1;
    private boolean mum = false;
    private int mun = 0;
    private int muo = 0;
    private int muq = -1;
    private boolean mus = false;
    private FullRoomInfo muv = null;
    private com.kascend.chushou.player.adapter.a muB = null;
    private ArrayList<String> muC = null;
    private boolean muD = true;
    private boolean muL = true;
    private boolean muM = false;
    public final List<OnlineVipItem> muO = new ArrayList();
    private boolean muP = false;
    private boolean muQ = false;
    private long muS = 0;
    private int muT = 1;
    private boolean dx = false;
    private int mvc = -1;
    private int mvd = -1;
    private boolean mvg = false;
    private int mvm = -1;
    private io.reactivex.disposables.b mvL = null;

    /* loaded from: classes5.dex */
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
        this.mqz = getArguments().getString("cover");
        this.muL = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mwo = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mwo;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dym()) {
            dxF();
            this.msU = ((VideoPlayer) this.mwE).dwP();
            this.mwD = ((VideoPlayer) this.mwE).dwS();
            dr(view);
            dxN();
            if (this.mwE instanceof VideoPlayer) {
                ((VideoPlayer) this.mwE).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.muM = false;
        if (this.mxk != null) {
            this.mxk.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.muM = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.muH != null) {
            this.muH.removeAllListeners();
            this.muH.cancel();
            this.muH = null;
        }
        if (this.muK != null) {
            this.muK.removeAllListeners();
            this.muK.cancel();
            this.muK = null;
        }
        if (this.mtW != null) {
            this.mtW.c();
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
        if (this.mvL != null) {
            this.mvL.dispose();
            this.mvL = null;
        }
        this.mul = 1;
        this.mum = false;
        if (this.mwF != null) {
            this.mwF.ca(null);
        }
        if (this.mup != null) {
            this.mup.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mwE, this.mrg);
        if (this.mwE != null && (this.mwE instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwE).dwW();
        }
        this.mrh = null;
        this.mrg = null;
        dxD();
        if (this.mtZ != null) {
            this.mtZ.a();
        }
        if (this.mtN != null) {
            this.mtN.b();
            this.mtN.c();
            this.mtN = null;
        }
        super.d();
    }

    private void dxD() {
        tv.chushou.zues.a.a.cb(this);
        if (this.muz != null) {
            this.muz.clear();
        }
        if (this.mux != null) {
            this.mux.clear();
        }
        if (this.muA != null) {
            this.muA.clear();
        }
        if (this.muy != null) {
            this.muy.clear();
        }
        if (this.muC != null) {
            this.muC.clear();
        }
        if (this.muB != null) {
            this.muB.a(0);
            this.muB.a();
        }
    }

    private void dr(View view) {
        this.mti = view.findViewById(a.f.fl_root);
        this.mvb = tv.chushou.zues.utils.a.fV(this.mwE);
        this.mun = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwE);
        this.muo = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        this.mva = 86;
        this.mwD = ((VideoPlayer) this.mwE).dwS();
        if (this.mwD != null) {
            this.muu = this.mwD.dxv();
            this.muv = this.mwD.dxs();
        }
        this.mux = new ArrayList<>();
        this.muz = new ArrayList<>();
        this.muy = new ArrayList<>();
        this.mtm = (FrameLayout) this.mwo.findViewById(a.f.fl_effect);
        b();
        this.mwy = (PlayerErrorView) this.mwo.findViewById(a.f.view_net_error_msg);
        this.mwy.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mtM = (RelativeLayout) this.mwo.findViewById(a.f.rl_audio_ani);
        this.mtN = (PaoPaoView) this.mwo.findViewById(a.f.audio_ani);
        this.mtO = (FrescoThumbnailView) this.mwo.findViewById(a.f.audio_ani_avatar);
        this.mtP = (LinearLayout) this.mwo.findViewById(a.f.ll_audio);
        this.msH = (TextView) this.mwo.findViewById(a.f.tv_open_video);
        this.mtQ = (ImageView) this.mwo.findViewById(a.f.iv_audio_ani);
        this.mvf = (FrescoThumbnailView) this.mwo.findViewById(a.f.live_cover);
        if (!this.mvg || this.msU == null || this.msU.getPlayState() != 4) {
            this.mvf.setVisibility(0);
            this.mvf.setBlur(true);
            this.mvf.i(this.mqz, 0, 0, 0);
        }
        this.msH.setOnClickListener(this);
        this.mqe = new b();
        this.mqe.a(view, null, this.mwE, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dJu()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mwD != null) {
                    append.append(c.this.mwD.dxv().mRoomID);
                }
                if (c.this.mqd != null && c.this.mqd.msV != null) {
                    append.append("&mode=").append(c.this.mqd.msV.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mwE, append.toString());
            }
        });
        this.mqi = (VoiceInteractionView) this.mwo.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mwD != null) {
            this.muu = this.mwD.dxv();
            this.muv = this.mwD.dxs();
        }
        dxG();
        dxE();
        dxH();
        this.mvi = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.muU = (FoodView) view.findViewById(a.f.rav_ad);
        this.mvn = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mvo = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mvn.setOnClickListener(this);
        this.mvo.setOnClickListener(this);
        this.mvp = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mve = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mve.setOnClickListener(this);
        this.mtW = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mtV = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.muE = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.muE.setOnClickListener(this);
        this.mut = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mut.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mut.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mvb.x, this.mvb.y) * 0.83d);
        this.mut.setLayoutParams(layoutParams);
        this.muw = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mwE);
        this.mut.setLayoutManager(this.muw);
        this.mut.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mut.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mut.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.muD = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.muB = new com.kascend.chushou.player.adapter.a(this.mwE, this.mux);
        if (this.muu != null) {
            this.muB.a(this.muu);
        }
        if (com.kascend.chushou.b.dwA().c != null) {
            this.muB.a(com.kascend.chushou.b.dwA().c);
        }
        this.mut.setAdapter(this.muB);
        this.muB.a(this.mux.size());
        this.muB.notifyDataSetChanged();
        if (this.mwD != null && (c = this.mwD.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mtZ != null) {
            this.mtZ.a();
            this.mtZ = null;
        }
        this.mtY = (GiftAnimationLayout) this.mwo.findViewById(a.f.ll_gift_animation);
        this.mtY.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mth = ((int) (tv.chushou.zues.utils.a.fU(this.mwE).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mwE, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mtY.getLayoutParams();
        layoutParams2.bottomMargin = this.mth;
        this.mtY.setLayoutParams(layoutParams2);
        if (this.mwD != null) {
            this.mtZ = new com.kascend.chushou.player.b.a(this.mwE.getApplicationContext(), this.mtY);
            this.mtZ.a(this.mwD);
            a(this.mwD.mpI, this.mwD.mpM);
        }
        this.mwo.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mtX = (EmbeddedButtonLayout) this.mwo.findViewById(a.f.embedded_button_layout);
        this.mtX.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mvk = (VideoShowVoteView) this.mwo.findViewById(a.f.view_video_show_vote);
        this.mvk.setOnClickListener(this);
        this.mvk.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.mwD != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
            this.mtX.a(videoPlayer.dxc().dys());
            this.mtX.b(this.mwD.dxu());
            this.mtV.a(videoPlayer.dwY(), false);
            this.mtW.a(videoPlayer.dwZ(), videoPlayer.dxa(), videoPlayer.dxb());
            this.mqd = new com.kascend.chushou.player.e.a();
        }
        this.mxu = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.muP = false;
                c.this.b(c.this.mth, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.muP = true;
                if (c.this.mxk != null) {
                    c.this.mxk.measure(0, 0);
                    int measuredHeight = c.this.mxk.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mwE, 14.0f);
                    if (measuredHeight > c.this.mth) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mxo = (PaoGuideView) this.mwo.findViewById(a.f.rlPaoGuideView);
        this.muR = (PlayShowMicPerson) this.mwo.findViewById(a.f.rl_mic_person_view);
        this.mub = (PlayShowH5View) this.mwo.findViewById(a.f.rl_playshowh5);
        this.muW = (FoodView) this.mwo.findViewById(a.f.bottom_ad);
        if (this.mwD != null) {
            H();
            if (this.mwD.mpC != null && !h.isEmpty(this.mwD.mpC.mUrl)) {
                b(this.mwD.mpC);
            }
        }
        this.muF = this.mwo.findViewById(a.f.view_reminder_subscribe);
        this.muG = this.muF.findViewById(a.f.spash_subscribe);
        ((TextView) this.muF.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.mwE, a.e.videoplayer_reminder_subscribe).append(" ").append(this.mwE.getString(a.i.videoplayer_reminder_subscribe)));
        this.muF.setOnClickListener(this);
        this.muI = this.mwo.findViewById(a.f.view_reminder_danmaku);
        this.muJ = this.muI.findViewById(a.f.spash_danmaku);
        ((TextView) this.muI.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.mwE, a.e.videoplayer_reminder_danmaku).append(" ").append(this.mwE.getString(a.i.videoplayer_reminder_danmaku)));
        this.muI.setOnClickListener(this);
    }

    private void dxE() {
        this.mvu = (RelativeLayout) this.mwo.findViewById(a.f.rl_cyclelive);
        this.mvv = (RelativeLayout) this.mwo.findViewById(a.f.rlrl_cyclelive);
        this.mvw = (FrescoThumbnailView) this.mwo.findViewById(a.f.iv_liveicon);
        this.mvx = (TextView) this.mwo.findViewById(a.f.tv_livename);
        this.mvy = (TextView) this.mwo.findViewById(a.f.tv_livedesc);
        this.mvz = (ImageView) this.mwo.findViewById(a.f.iv_cyclelive_name_menu);
        this.mvA = (RelativeLayout) this.mwo.findViewById(a.f.rl_normal);
        this.mvB = (LinearLayout) this.mwo.findViewById(a.f.ll_cyclelive_nickname);
        this.mvC = (TextView) this.mwo.findViewById(a.f.tv_cyclelive_nickname);
        this.mvD = (TextView) this.mwo.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mvE = (RelativeLayout) this.mwo.findViewById(a.f.rl_clear_cyclelive);
        this.mvF = (RelativeLayout) this.mwo.findViewById(a.f.rlrl_clear_cyclelive);
        this.mvG = (FrescoThumbnailView) this.mwo.findViewById(a.f.iv_clear_liveicon);
        this.mvH = (TextView) this.mwo.findViewById(a.f.tv_clear_livename);
        this.mvI = (TextView) this.mwo.findViewById(a.f.tv_clear_livedesc);
        this.mvJ = (ImageView) this.mwo.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mvK = (RelativeLayout) this.mwo.findViewById(a.f.rl_clear_normal);
        this.mvJ.setOnClickListener(this);
        this.mvz.setOnClickListener(this);
        this.mvD.setOnClickListener(this);
        this.mvC.setOnClickListener(this);
        this.mvw.setOnClickListener(this);
        this.mvG.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mwD.mpA != null && this.muW != null) {
            this.muW.a(true, this.mwD.a == null ? "" : this.mwD.a);
            this.muW.a(this.mwD.mpA, a.C0736a.slide_in_bottom_danmu_anim, a.C0736a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mwD != null && this.mwD.mpH != null && this.mtX != null) {
            this.muU.a(this.mwD.mpH, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mwD != null) {
                        c.this.mwD.mpH = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dxS() {
        return this.mtZ;
    }

    private void dxF() {
        this.mwF = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mwo != null && (textView = (TextView) c.this.mwo.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mwE.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mwF.A(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mwF);
                        break;
                    case 12:
                        c.this.b(c.this.mwF);
                        break;
                    case 17:
                        c.this.dyo();
                        break;
                    case 18:
                        c.this.dlp();
                        break;
                    case 19:
                        c.this.mwC.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mus) {
            this.mus = true;
            if (this.mur == null) {
                this.mur = this.mwo.findViewById(a.f.vs_async_show_content);
                this.mur = ((ViewStub) this.mur).inflate();
            }
            this.mqs = this.mwo.findViewById(a.f.ui_content);
            if (this.mrI == null) {
                this.mrI = this.mwo.findViewById(a.f.vs_async_notification_view);
                this.mrI = ((ViewStub) this.mrI).inflate();
            }
            c(this.mwo);
            k();
            dlq();
            if (this.c == null) {
                this.mpX = new d.a();
                this.c = new GestureDetector(this.mwE, this.mpX);
            }
            ((VideoPlayer) this.mwE).q();
        }
    }

    private void dxG() {
        this.mtn = (LinearLayout) this.mwo.findViewById(a.f.ll_anchor);
        this.mto = (RelativeLayout) this.mwo.findViewById(a.f.ll_clear_anchor);
        this.mtn.setVisibility(4);
        this.mto.setVisibility(4);
        this.mtp = (FrescoThumbnailView) this.mwo.findViewById(a.f.iv_clear_avatar);
        this.mtq = (TextView) this.mwo.findViewById(a.f.tv_clear_nickname);
        this.mtr = (TextView) this.mwo.findViewById(a.f.tv_clear_online_count);
        this.mts = (TextView) this.mwo.findViewById(a.f.tv_clear_btn_subscribe);
        this.mts.setOnClickListener(this);
        this.mtt = (FrescoThumbnailView) this.mwo.findViewById(a.f.iv_avatar);
        this.mtu = (TextView) this.mwo.findViewById(a.f.tv_nickname_test);
        this.mtv = (TextView) this.mwo.findViewById(a.f.tv_online_count);
        this.mqD = (TextView) this.mwo.findViewById(a.f.tv_btn_subscribe);
        this.mqD.setOnClickListener(this);
        this.mtw = (TextView) this.mwo.findViewById(a.f.tv_loyal_counts);
        this.mqG = (TextView) this.mwo.findViewById(a.f.tv_btn_contribution);
        this.mty = (TextView) this.mwo.findViewById(a.f.tv_btn_contribution_forpk);
        this.mqG.setVisibility(4);
        this.mty.setVisibility(8);
        this.mtz = (LinearLayout) this.mwo.findViewById(a.f.ll_mic);
        this.mtA = (PlayShowMicStatusView) this.mwo.findViewById(a.f.show_mic_status);
        this.mtB = (RecyclerView) this.mwo.findViewById(a.f.rv_loyal);
        this.mtC = (ImageView) this.mwo.findViewById(a.f.iv_clear_close);
        this.mqM = (ImageView) this.mwo.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mtB.setLayoutManager(linearLayoutManager);
        this.muN = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.muO, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.muO.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mwE, (JSONObject) null, c.this.mwD.dxv().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0858a view$OnLongClickListenerC0858a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0858a view$OnLongClickListenerC0858a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0858a.JQ(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0858a.JQ(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0858a.JQ(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dJG(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mwE, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwE, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwE, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwE, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwE, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.bS(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.mtB.setAdapter(this.muN);
        this.mtz.setOnClickListener(this);
        this.mtp.setOnClickListener(this);
        this.mtC.setOnClickListener(this);
        this.mtt.setOnClickListener(this);
        this.mtp.setOnClickListener(this);
        this.mqM.setOnClickListener(this);
        this.mtw.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dq(View view) {
                String str = tv.chushou.common.a.dJu() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mwD != null) {
                    str = str + c.this.mwD.dxv().mRoomID;
                }
                c.this.f(c.this.mwE.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mqG.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dq(View view) {
                String str = tv.chushou.common.a.dJu() + "m/room-billboard/";
                if (c.this.mwD != null) {
                    str = str + c.this.mwD.dxv().mRoomID;
                }
                c.this.f(c.this.mwE.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mty.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dq(View view) {
                String str = tv.chushou.common.a.dJu() + "m/room-billboard/";
                if (c.this.mwD != null) {
                    str = str + c.this.mwD.dxv().mRoomID;
                }
                c.this.f(c.this.mwE.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.muv == null || this.muv.cycleLiveRoomInfo == null || h.isEmpty(this.muv.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mqg = this.muv.cycleLiveRoomInfo;
        }
        if (z2 && this.mqg != null) {
            this.mvu.setVisibility(0);
            this.mvE.setVisibility(0);
            this.mvA.setVisibility(8);
            this.mvK.setVisibility(8);
            this.mvB.setVisibility(0);
            this.mvG.h(this.mqg.eventIcon, com.kascend.chushou.view.a.a(this.muu.mCreatorGender), b.a.small, b.a.small);
            this.mvw.h(this.mqg.eventIcon, com.kascend.chushou.view.a.a(this.muu.mCreatorGender), b.a.small, b.a.small);
            this.mvH.setText(this.mqg.eventName);
            this.mvI.setText(this.mqg.eventDesc);
            this.mvx.setText(this.mqg.eventName);
            this.mvy.setText(this.mqg.eventDesc);
            this.mvC.setText(this.mqg.nickname);
            aN();
            if (z) {
                c(this.mqg.remainTime);
                return;
            }
            return;
        }
        this.mvu.setVisibility(8);
        this.mvE.setVisibility(8);
        this.mvA.setVisibility(0);
        this.mvK.setVisibility(0);
        this.mvB.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mvL != null) {
            this.mvL.dispose();
            this.mvL = null;
        }
        this.mvL = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dCD()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mwE != null && (c.this.mwE instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mwE).u();
                }
            }
        });
    }

    private void aM() {
        if (this.muu != null && this.mus) {
            this.mtn.setVisibility(0);
            this.mto.setVisibility(0);
            this.mqG.setVisibility(0);
            this.mtp.h(this.muu.mCreatorAvatar, com.kascend.chushou.view.a.a(this.muu.mCreatorGender), b.a.small, b.a.small);
            this.mtq.setText(this.muu.mCreatorNickname);
            this.mtt.h(this.muu.mCreatorAvatar, com.kascend.chushou.view.a.a(this.muu.mCreatorGender), b.a.small, b.a.small);
            this.mtu.setText(this.muu.mCreatorNickname);
            dyd();
            aO();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dyd() {
        if (this.muu != null) {
            this.mtr.setText(tv.chushou.zues.utils.b.formatNumber(this.muu.mOnlineCount));
            this.mtv.setText(tv.chushou.zues.utils.b.formatNumber(this.muu.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.mqg != null) {
            if (this.mqg.isSubscribe) {
                this.mvD.setText(a.i.like_already);
                this.mvD.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mvD.setText(getString(a.i.like));
            this.mvD.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        if (this.muu != null) {
            if (this.muu.mIsSubscribed) {
                this.mts.setText(getString(a.i.like_already));
                this.mts.setBackgroundResource(a.e.bg_show_subcribe);
                this.mqD.setText(getString(a.i.like_already));
                this.mqD.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mts.setText(getString(a.i.like));
            this.mts.setBackgroundResource(a.e.bg_show_subcribe);
            this.mqD.setText(getString(a.i.like));
            this.mqD.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void aP() {
        if (this.muN != null) {
            this.muN.notifyDataSetChanged();
        }
    }

    private void dxH() {
        this.mtE = this.mwo.findViewById(a.f.tv_interact);
        this.mtE.setOnClickListener(this);
        this.mtJ = (RelativeLayout) this.mwo.findViewById(a.f.rl_edit_bar);
        this.mtH = (ImageView) this.mwo.findViewById(a.f.btn_hotword);
        this.mtH.setOnClickListener(this);
        this.mtI = (ImageView) this.mwo.findViewById(a.f.iv_task_badge);
        this.mtG = (AnimationSet) AnimationUtils.loadAnimation(this.mwE, a.C0736a.anim_hotword);
        this.mtG.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dwH().c) {
                    c.this.mtH.clearAnimation();
                    c.this.mtH.startAnimation(c.this.mtG);
                }
            }
        });
        if (com.kascend.chushou.d.h.dwH().c) {
            this.mtH.startAnimation(this.mtG);
            this.mtI.setVisibility(0);
        }
        this.mvM = (TextView) this.mwo.findViewById(a.f.tv_bottom_input);
        this.mvM.setOnClickListener(this);
        this.mxE = (FrescoThumbnailView) this.mwo.findViewById(a.f.ll_btn_set);
        this.mxE.setOnClickListener(this);
        this.mxE.xW(a.e.ic_room_set_btn_white);
        this.mtS = (LinearLayout) this.mwo.findViewById(a.f.ll_bottom_all_button);
        this.mtT = (FrescoThumbnailView) this.mwo.findViewById(a.f.fl_clear_bottom_gift);
        this.mtT.setAnim(true);
        this.mtT.setOnClickListener(this);
        this.mtT.xW(a.e.ic_show_gift_n);
        this.mtU = (FrameLayout) this.mwo.findViewById(a.f.flfl_clear_bottom_gift);
        this.mtU.setVisibility(8);
        this.mtF = (RelativeLayout) this.mwo.findViewById(a.f.rl_bottom_input);
        this.mtF.setVisibility(0);
        this.mtK = (PastedEditText) this.mwo.findViewById(a.f.et_bottom_input);
        this.mtK.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mqV.setEnabled(editable.length() > 0);
            }
        });
        this.mtK.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mqV);
                    return true;
                }
                return true;
            }
        });
        this.mtK.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.m(c.this.mtK);
                }
                return false;
            }
        });
        this.mre = (ImageView) this.mwo.findViewById(a.f.iv_btn_emoji);
        this.mre.setVisibility(8);
        this.mqV = (TextView) this.mwo.findViewById(a.f.tv_btn_send);
        this.mqV.setOnClickListener(this);
        this.muc = (LinearLayout) this.mwo.findViewById(a.f.head_trumpet);
        this.muc.setVisibility(8);
        this.muc.setOnClickListener(this);
        this.mud = (TextView) this.mwo.findViewById(a.f.tv_primary_name);
        this.mue = (TextView) this.mwo.findViewById(a.f.tv_primary_desc);
        this.mug = (TextView) this.mwo.findViewById(a.f.tv_cut_count);
        this.mug.setOnClickListener(this);
        this.mui = (TextView) this.mwo.findViewById(a.f.tv_head_count);
        this.mui.setText(this.mul + "");
        this.muh = (TextView) this.mwo.findViewById(a.f.tv_plus_count);
        this.muh.setOnClickListener(this);
        this.mrv = (TextView) this.mwo.findViewById(a.f.tv_buy_count_coin);
        this.muf = (TextView) this.mwo.findViewById(a.f.tv_buy_head);
        this.muf.setOnClickListener(this);
        this.muj = (ImageView) this.mwo.findViewById(a.f.iv_trumpet_select);
        this.muj.setOnClickListener(this);
        this.muk = (TextView) this.mwo.findViewById(a.f.tv_trumpet_have_count);
        this.mum = false;
        this.muj.setBackgroundResource(a.e.ic_trumpet_n);
        this.muk.setVisibility(8);
        this.mrd = (KPSwitchPanelLinearLayout) this.mwo.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mrd, this.mre, this.mtK, new a.InterfaceC0862a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0862a
            public void wb(boolean z) {
                if (c.this.mre != null) {
                    if (z) {
                        c.this.mrd.setDirectVisibility(0);
                        c.this.mre.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mre.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mrh = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wc(boolean z) {
                c.this.mrf = z;
                if (z) {
                    c.this.mre.setImageResource(a.e.cs_emoji_normal);
                    c.this.dxJ();
                    if (c.this.mvt != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mvt.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gh(c.this.mwE);
                        c.this.mvt.setLayoutParams(layoutParams);
                    }
                    if (c.this.mtJ != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mtJ.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gh(c.this.mwE);
                        c.this.mtJ.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mvt != null && c.this.mvt.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mvt.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mvt.setLayoutParams(layoutParams3);
                    c.this.mvt.setVisibility(8);
                }
                if (c.this.muP) {
                    c.this.mxk.setVisibility(0);
                }
                if (c.this.mwE != null && (c.this.mwE instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mwE).wa(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mtJ != null && c.this.mrd.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mtJ.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mtJ.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mrg = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mrd, this.mrh, ((VideoPlayer) this.mwE).dwX());
        ((VideoPlayer) this.mwE).h(((VideoPlayer) this.mwE).dwX());
        this.mvt = this.mwo.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mvq = (TextView) this.mwo.findViewById(a.f.btn_room_search);
        this.mvr = (ImageView) this.mwo.findViewById(a.f.iv_room_emoji_delete);
        this.mvs = (EditText) this.mwo.findViewById(a.f.et_room_emoji_search);
        this.mvs.setImeOptions(3);
        this.mvs.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mvq);
                    return true;
                }
                return false;
            }
        });
        this.mvs.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mvq.setEnabled(editable.length() > 0);
                c.this.mvr.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mxk.setEmojiSearchText(editable.toString());
            }
        });
        this.mvq.setOnClickListener(this);
        this.mvr.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aq(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dC(this.mvs);
            this.mvt.setVisibility(0);
            this.mvs.requestFocus();
        } else {
            this.mvt.setVisibility(8);
        }
        if (z2) {
            this.mvs.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxJ() {
        int gh = tv.chushou.zues.widget.kpswitch.b.d.gh(this.mwE) + tv.chushou.zues.utils.a.dip2px(this.mwE, 14.0f);
        if (gh > this.mth) {
            b(gh, 12);
        }
    }

    private void aS() {
    }

    private void dxN() {
        if (this.muo > 0) {
            View findViewById = this.mwo.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.muo);
        }
        if (this.mun > 0) {
            View findViewById2 = this.mwo.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mun, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.muL) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.mpZ = ((VideoPlayer) this.mwE).dwT();
        this.mpZ.a(this);
        if (this.mwD.dxs() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mpZ != null) {
            this.mpZ.d();
        }
    }

    private void dxO() {
        if ((this.mqd == null || this.mqd.msV == null || !this.mqd.msV.mInPKMode) ? false : true) {
            if (this.mti != null) {
                this.mti.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mqf.getLayoutParams();
            layoutParams.leftMargin = (this.mvb.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mwE, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mqf.setLayoutParams(layoutParams);
            this.y.setText(this.mqd.msV.mPkUserNickname);
            this.mqf.setVisibility(0);
            this.mtz.setVisibility(8);
            return;
        }
        if (this.mti != null) {
            this.mti.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mqf.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.mqd != null && this.mqd.msV != null && this.mqd.msV.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mvm > 0 && this.mut != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mut.getLayoutParams();
                if (layoutParams.height != this.mvm) {
                    layoutParams.height = this.mvm;
                    this.mut.setLayoutParams(layoutParams);
                }
            }
            this.mth = ((int) (tv.chushou.zues.utils.a.fU(this.mwE).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mwE, 84.0f);
            b(this.mth, 12);
        } else {
            if (this.mut != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mut.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mwE, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mwE, 250.0f);
                    this.mut.setLayoutParams(layoutParams2);
                }
            }
            this.mth = ((int) (tv.chushou.zues.utils.a.fU(this.mwE).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mwE, 84.0f);
            b(this.mth, 12);
        }
        if (this.mqe != null) {
            this.mqe.a(this.mvm + tv.chushou.zues.utils.a.dip2px(this.mwE, 52.0f), this.mwI);
        }
        if (this.mqi != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mqi.getLayoutParams();
            layoutParams3.bottomMargin = this.mvm + tv.chushou.zues.utils.a.dip2px(this.mwE, 52.0f);
            this.mqi.setLayoutParams(layoutParams3);
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

    private void dxQ() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dyn().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mvb = tv.chushou.zues.utils.a.fV(this.mwE);
        this.mva = 86;
        this.muY = (Math.max(this.mvb.x, this.mvb.y) - tv.chushou.zues.utils.a.dip2px(this.mwE, (this.mva + 52) + 250)) - this.mun;
        this.muZ = Math.max(this.mvb.x, this.mvb.y) - ((tv.chushou.zues.utils.a.dip2px(this.mwE, this.mva) + this.mun) * 2);
        if (this.mvc <= 0 || this.mvd <= 0) {
            this.mvc = Math.min(this.mvb.x, this.mvb.y);
            this.mvd = Math.max(this.mvb.x, this.mvb.y);
        }
        this.ar = Math.min(this.mvb.x, this.mvb.y);
        this.mwI = (this.ar * this.mvd) / this.mvc;
        boolean z = false;
        if (this.mqd == null || this.mqd.msV == null) {
            i = 1;
        } else {
            i = this.mqd.msV.mMode;
            if (this.mqd.msV.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mva = 42;
            if (i == 2) {
                if (this.mvd < this.mvc) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mwI;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mwI;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mvc * layoutParams.height) / this.mvd;
                    layoutParams2.height = layoutParams.height;
                    this.mwI = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mwI;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwI;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, this.mva) + this.mun;
            layoutParams.gravity = 48;
            this.mvm = ((this.mvb.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mwE, (this.mva + 52) + 64) + this.mun)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            aG();
        } else if (this.E) {
            this.mva = 42;
            if (this.mvd < this.mvc) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mwI;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwI;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mvc * layoutParams.height) / this.mvd;
                layoutParams2.height = layoutParams.height;
                this.mwI = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, this.mva) + this.mun;
            layoutParams.gravity = 48;
            this.mvm = ((this.mvb.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mwE, (this.mva + 52) + 98) + this.mun)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            dxQ();
        } else {
            this.mvm = -1;
            this.mva = 86;
            if (this.mwI <= this.muY) {
                layoutParams.width = this.ar;
                layoutParams.height = this.muY;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, this.mva) + this.mun;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwI;
            } else if (this.mwI < this.muZ) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mwI;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, this.mva) + this.mun;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwI;
            } else {
                this.mwI = Math.max(this.mvb.x, this.mvb.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mwI;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mwI * this.mvc) / this.mvd >= this.ar) {
                        i3 = this.mwI;
                        i2 = (this.mwI * this.mvc) / this.mvd;
                    } else if ((this.ar * this.mvd) / this.mvc >= this.mwI) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mvd) / this.mvc;
                    } else {
                        i2 = this.ar;
                        i3 = this.mwI;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mwI) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mvd) / this.mvc > this.mwI) {
                        i3 = this.mwI;
                        i2 = (this.mwI * this.mvc) / this.mvd;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mvd) / this.mvc;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mvd) / this.mvc;
                        if (i3 > this.mwI) {
                            i3 = this.mwI;
                            i2 = (this.mwI * this.mvc) / this.mvd;
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
        if (this.mwD != null && this.mwD.d) {
            layoutParams.width = Math.min(this.mvb.x, this.mvb.y);
            layoutParams.height = Math.max(this.mvb.x, this.mvb.y);
        }
        dyn().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void aY() {
        this.N = new SurfaceRenderView(this.mwE);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dyn().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.dx) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dyg();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dyf();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mvP != null) {
            this.mvP.a();
        }
        if (this.mwD != null && !h.isEmpty(this.mwD.mpK)) {
            b(this.mwD.mpK);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.msU != null) {
            int width = this.msU.getWidth();
            int height = this.msU.getHeight();
            if (this.mvc != width || this.mvd != height || this.mvc <= 0 || this.mvd <= 0) {
                this.mvc = width;
                this.mvd = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.muP) {
                aD();
            } else {
                if (this.mwE.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwD.dxs().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mum) {
                f(this.mtK.getText().toString());
            } else {
                a(this.mtK.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dwH().c) {
                com.kascend.chushou.d.h.dwH().b(false);
                this.mtG.cancel();
                this.mtG.reset();
                this.mtH.clearAnimation();
                this.mtI.setVisibility(8);
            }
            l(view, 0, this.mwo.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mwE, 165.0f) / 2);
            k(view, x >= 0 ? x : 0, this.mwo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mwD.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mwD.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mut != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.muu != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.muT = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mwE, (JSONObject) null, this.mwD.dxv().mRoomID, this.mwD.dxv().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mwE.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mwE, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.muV != null) {
                    com.kascend.chushou.d.e.a(this.mwE, this.muV, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mvp != null) {
                    this.mvp.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mwE, null) && this.mwD != null && this.mwD.mpL != null) {
                    if (this.mum) {
                        bo();
                    } else {
                        if (this.mwD != null && this.mwD.mpL != null && this.mwD.mpL.count > 0) {
                            this.muc.setVisibility(8);
                        } else {
                            this.muc.setVisibility(0);
                        }
                        this.mum = true;
                        this.muj.setBackgroundResource(a.e.ic_trumpet_p);
                        this.muk.setVisibility(0);
                        this.muk.setSelected(true);
                        this.muk.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mtK != null) {
                            this.mtK.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mul <= 9) {
                    this.mul++;
                    this.mui.setText(this.mul + "");
                }
                aH();
            } else if (id == a.f.tv_cut_count) {
                if (this.mul > 1) {
                    this.mul--;
                    this.mui.setText(this.mul + "");
                }
                aH();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mvs.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mvs.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mvt.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dD(this.mvs);
                    this.mxk.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mqg != null && !h.isEmpty(this.mqg.eventUrl)) {
                    f("", this.mqg.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mqg != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mqg != null) {
                    com.kascend.chushou.d.a.a(this.mwE, (JSONObject) null, this.mqg.roomId, this.mqg.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mwD.a(false);
                    ((VideoPlayer) this.mwE).l();
                } else {
                    ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
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
        if (this.mub != null) {
            int i = (tv.chushou.zues.utils.a.fU(this.mwE).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mub.getLayoutParams();
            layoutParams.topMargin = i;
            this.mub.setLayoutParams(layoutParams);
            this.mub.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mub.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.JO(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.muS <= 3000) {
            tv.chushou.zues.utils.g.JO(a.i.str_too_fast);
            return false;
        } else {
            dlw();
            if (!com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a(((VideoPlayer) this.mwE).dwS().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.muS = System.currentTimeMillis();
            if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                a(this.mwD.dxs().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mwD.h);
            }
            g(this.b);
            if (!z && this.mtK != null) {
                this.mtK.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dlw();
            if (com.kascend.chushou.d.e.c(this.mwE, null) && LoginManager.Instance().getUserInfo() != null && this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                a(this.mwD.dxs().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mtK != null) {
                this.mtK.setText((CharSequence) null);
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
            if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null && !h.isEmpty(this.mwD.dxs().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mwD.dxs().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mwE).mnY;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Ql(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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

    private void k(View view, int i, int i2) {
        if (this.mxe != null && this.mxe.isShowing()) {
            this.mxe.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
        if (this.mxB == null) {
            i(3);
        }
        this.mxB.getContentView().setBackgroundResource(0);
        this.mxB.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mxB.isShowing()) {
            this.mxB.showAtLocation(view, 83, i, i2);
            if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mwD.dxs().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mxB.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.mxF)) {
            if (((VideoPlayer) this.mwE).q) {
                this.mxE.xW(a.e.ic_room_set_btn_white);
            } else {
                this.mxE.xW(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mwE).q && this.mxF.size() == 2 && this.mxF.contains("4") && this.mxF.contains("2")) {
            this.mxE.xW(a.e.ic_room_set_btn_system_white);
        } else if (this.mxF.size() > 1 || !((VideoPlayer) this.mwE).q) {
            this.mxE.xW(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mxF.get(0))) {
            this.mxE.xW(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mxF.get(0))) {
            this.mxE.xW(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mxF.get(0))) {
            this.mxE.xW(a.e.ic_room_set_btn_system_white);
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
        if (this.mxe == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mxe.getContentView().setBackgroundResource(0);
            this.mxe.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mxe.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mtH.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mxe.isShowing()) {
            this.mxe.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mwE, 16.0f) + i2);
            this.mtH.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mwD.dxs().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mxe.dismiss();
    }

    private void ds(View view) {
        if (this.mwY == null) {
            dxT();
        }
        if (com.kascend.chushou.d.h.dwH().q()) {
            this.mtL.dJE();
        } else {
            this.mtL.dJF();
        }
        int height = this.mwo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (view != null) {
            this.mwY.showAtLocation(view, 85, 0, height);
        }
    }

    private void dxT() {
        if (this.mwY == null) {
            View inflate = LayoutInflater.from(this.mwE).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mtL = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dwH().q()) {
                this.mtL.dJE();
            } else {
                this.mtL.dJF();
            }
            this.mtL.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dwH().g(z);
                }
            });
            this.mwS = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mwT = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mwS.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mwS.setVisibility(0);
            } else {
                this.mwS.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dwH().a) {
                this.mwT.b();
            } else {
                this.mwT.c();
            }
            if (this.mwD != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mwD.f;
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
                                if (this.mqd == null || !this.mqd.msV.mInPKMode || h.isEmpty(this.mqd.b) || this.muu == null || !this.mqd.b.equals(this.muu.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mwE).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dxt = this.mwD.dxt();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mwE).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwE, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, 5.0f);
                                            }
                                            int identifier = this.mwE.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mwE.getPackageName());
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
                                                if (dxt != null && dxt.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mwE.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mwE).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dxt2 = this.mwD.dxt();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mwE).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwE, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, 5.0f);
                                        }
                                        int identifier2 = this.mwE.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mwE.getPackageName());
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
                                            if (dxt2 != null && dxt2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dxU();
                        c.this.mwY.dismiss();
                    }
                }
            });
            this.mwY = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 150.0f), -2);
            this.mwY.setFocusable(true);
            this.mwY.setOutsideTouchable(true);
            this.mwY.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mwY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mwY = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxU() {
        if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
            if (this.mua == null) {
                this.mua = new f(getActivity());
            }
            this.mua.a(this.mwD.dxs().mRoominfo, this.ax);
            if (!this.mua.isShowing()) {
                this.mua.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.dx) {
            return false;
        }
        if (this.muT == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mvN = motionEvent.getX();
                    this.mvO = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mvN;
                    if (Math.abs(f) > Math.abs(y - this.mvO) && Math.abs(f) > q && f > 0.0f) {
                        dyi();
                        return true;
                    }
                    this.mvN = 0.0f;
                    this.mvO = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mvt != null && this.mvt.getVisibility() == 0 && b(motionEvent, this.mvt)) {
                this.mvt.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mvs);
                return true;
            } else if (this.muP && this.mvt != null && this.mvt.getVisibility() == 8 && g(this.mxk.b, motionEvent)) {
                aD();
                return true;
            } else if (this.mub != null && this.mub.b() && g(this.mub, motionEvent)) {
                this.mub.a();
                return true;
            } else if (this.mtR != null && this.mtR.b() && g(this.mtR, motionEvent)) {
                this.mtR.a();
                return true;
            } else if (b(motionEvent, this.mtJ)) {
                return dlw();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean b(MotionEvent motionEvent, View view) {
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
            if (this.mxv != null && this.mxv.a(i, keyEvent)) {
                return true;
            }
            if ((this.mub != null && this.mub.onKeyDown(i, keyEvent)) || dxK()) {
                return true;
            }
            if (this.muT == 3) {
                this.muT = 1;
                dyi();
                return true;
            } else if (this.mtR != null && this.mtR.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mtK != null && this.mtF != null && this.mtJ != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dC(this.mtK);
                this.mtF.setVisibility(8);
                this.mtJ.setVisibility(0);
            }
        } else if (this.mtF != null && this.mtJ != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
            this.mtF.setVisibility(0);
            this.mtJ.setVisibility(8);
        }
    }

    public boolean dlw() {
        boolean z;
        b(this.mth, 12);
        boolean z2 = false;
        if (this.mrd != null && this.mrd.getVisibility() == 0) {
            this.mrd.setVisibility(8);
            this.mre.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mrf) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwE);
            this.mre.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mtJ == null || this.mtJ.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mum) {
                bo();
            }
            this.mtJ.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mtF != null) {
                    c.this.mtF.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dxK() {
        if (dlw()) {
            return true;
        }
        if (this.mxe != null && this.mxe.isShowing()) {
            this.mxe.dismiss();
            return true;
        } else if (this.mxB != null && this.mxB.isShowing()) {
            this.mxB.dismiss();
            return true;
        } else if (this.mwY == null || !this.mwY.isShowing()) {
            return aD() || dxM() || dxR() || dxL();
        } else {
            this.mwY.dismiss();
            return true;
        }
    }

    public boolean dxL() {
        if (this.mxo == null || !this.mxo.isShown()) {
            return false;
        }
        this.mxo.d();
        return true;
    }

    public boolean dxM() {
        if (this.muR == null || !this.muR.isShown()) {
            return false;
        }
        this.muR.a();
        return true;
    }

    public boolean dxR() {
        if (this.mub == null || !this.mub.b()) {
            return false;
        }
        this.mub.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mwE != null && !((Activity) this.mwE).isFinishing() && pVar != null) {
            this.muC = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dym() && this.muu != null && mVar.a(this.muu.mCreatorUID, null)) {
            this.muu.mIsSubscribed = mVar.c;
            aO();
        }
    }

    public boolean aD() {
        if (!this.muP || this.mxk == null) {
            return false;
        }
        if (this.mxk != null) {
            this.mxk.e();
        }
        if (this.mvs != null) {
            this.mvs.setText("");
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
        if (!dym() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.muX != null) {
                        this.muX.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                        this.mwD.dxs().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mwD.dxs().mMicStatus.onMic) {
                            if (this.mtz != null) {
                                this.mtz.setVisibility(8);
                            }
                            if (this.muR != null && this.muR.isShown()) {
                                this.muR.a();
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
                        if (this.mwD.dxs().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.muu != null && !h.isEmpty(this.muu.mCreatorUID)) {
                                g(arrayList2, this.muu.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.mwD.dxs().mMicStatus.onMic) {
                            if (this.mwD.dxs().mMicStatus != null && !h.isEmpty(this.mwD.dxs().mMicStatus.micRoomId) && !this.mwD.dxs().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mwD.dxs().mMicStatus.micRoomId;
                            }
                            this.mwD.dxs().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mwD.dxs().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.mwD.dxs().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mwD.dxs().mMicStatus, str3, z4);
                            if (this.muR != null && this.muR.getVisibility() == 0) {
                                this.muR.a(this.mwD.dxs().mFanItems, this.mwD.dxs().mMicStatus, str3, z4, this.mwD.dxs().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mtz != null) {
                                this.mtz.setVisibility(8);
                            }
                            if (this.muR != null && this.muR.isShown()) {
                                this.muR.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.muq != onlineVip.mCount || (this.mtw != null && this.mtw.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.muq = onlineVip.mCount;
                        this.mtx = onlineVip.mCount;
                        dxW();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.muO.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.muO.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.muO.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mvj <= 5000) {
                                z2 = false;
                            } else {
                                this.mvj = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.muO.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.muO.addAll(onlineVip.mOnlineVipItems);
                            }
                            aP();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mvk != null) {
                    if (this.muu == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.muu.mCreatorAvatar;
                        str2 = this.muu.mCreatorGender;
                    }
                    this.mvk.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mqd != null && this.mqd.msV != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mqd.msV.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mpZ != null) {
                                        this.mpZ.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mqd.msV.mInPKMode = true;
                                    this.mqd.msV.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mqd.msV.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mqd.msV.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mqd.msV.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mqd.msV.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mqd.msV.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mqd.msV.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mqd.msV.mMode = pkNotifyInfo.mMode;
                                    this.mqd.msV.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mqe != null) {
                                        this.mqe.g(true, this.mqd.msV.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dwH().a) {
                                        if (!com.kascend.chushou.b.dwA().e) {
                                            com.kascend.chushou.b.dwA().e = true;
                                            tv.chushou.zues.utils.g.F(this.mwE, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dwH().a(this.mwE, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mqd.msV.mAction = 7;
                                    this.mqd.msV.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mqd.msV.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mqd.msV.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mqd.msV.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mqd.msV.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mqd.msV.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mqd.msV.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.mqe != null) {
                                        this.mqe.g(false, 0L);
                                        this.mqe.b(this.mqd.msV, true);
                                        this.mqe.a(this.mvm + tv.chushou.zues.utils.a.dip2px(this.mwE, 52.0f), this.mwI);
                                        this.mqe.a(this.mqd.msV.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mpZ != null) {
                                        this.mpZ.a(false);
                                    }
                                    this.mqd.msV.mInPKMode = false;
                                    this.mqd.msV.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.mqe != null) {
                                        this.mqe.c();
                                    }
                                    this.mqd.b = null;
                                    this.mqd.msV = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mqd.msV.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mqd.msV.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mqd.msV.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.muu != null && !h.isEmpty(this.muu.mRoomID) && this.muu.mRoomID.equals(this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mqd.msV.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mqe != null) {
                                        this.mqe.a(this.mqd.msV, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mqd.msV.copyUpdate(pkNotifyInfo);
                                    if (this.mqe != null) {
                                        this.mqe.a(this.mqd.msV);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mqd.msV.copyStop(pkNotifyInfo);
                                        if (this.mqe != null) {
                                            this.mqe.A(this.mqd.msV.mMaxFreeDuration, this.mqd.msV.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mqd.msV.copyResult(pkNotifyInfo);
                                    if (!this.muM && this.mqe != null) {
                                        int i7 = 1;
                                        if (this.mqd.msV.destinyInfo != null && this.mqd.msV.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mqe.a(h.parseInt(this.mqd.msV.mResult), h.parseLong(this.mqd.msV.mvpUid), this.mqd.msV.mvpAvatar, this.mqd.msV.mvpNickname, this.mqd.msV.mMaxFreeDuration, this.mqd.msV.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mqg != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mqg.uid = cycleLiveRoomInfo.uid;
                        this.mqg.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mqg.roomId = cycleLiveRoomInfo.roomId;
                        this.mqg.avatar = cycleLiveRoomInfo.avatar;
                        this.mqg.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.mwE != null && (this.mwE instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mwE).d();
                        }
                    } else {
                        ((VideoPlayer) this.mwE).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mwD != null && this.mwD.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dwH().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dwH().b().equals(next2.mUserID)) {
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

    public void dxW() {
        if (this.mtw != null) {
            if (this.mqd == null || this.mqd.msV == null || !this.mqd.msV.mInPKMode) {
                if (this.mtx > 0) {
                    this.mtw.setVisibility(0);
                    this.mtw.setText(String.format(this.mwE.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mtx))));
                    this.mtB.setVisibility(0);
                    return;
                }
                this.mtw.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mtz.setVisibility(0);
            if (this.mtA != null) {
                this.mtA.a(str, z, micStatus, this.mwD.dxs().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mtz.setVisibility(8);
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
    public void bc() {
        int childCount = this.muw.getChildCount();
        int itemCount = this.muw.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.muw);
        if (f + childCount >= itemCount) {
            this.muD = true;
            if (this.muE != null) {
                this.muE.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dya() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mux.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mux.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.mux == null) {
            this.mux = new ArrayList<>();
        }
        while (2 < this.mux.size()) {
            this.mux.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.muz);
        if (a2 == null) {
            w(false);
            return;
        }
        this.mux.addAll(a2);
        int size = this.mux.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mux.size(); i++) {
                this.mux.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.muA == null) {
            this.muA = new ArrayList<>();
        }
        this.muA.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.muC != null && this.muC.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.muC.contains("2"))) {
                        this.muA.add(next);
                    } else if (!this.muC.contains(next.mType)) {
                        this.muA.add(next);
                    }
                }
                return this.muA;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mux == null) {
                    this.mux = new ArrayList<>(arrayList);
                    dya();
                    w(z2);
                    return;
                }
                if (this.muz == null) {
                    this.muz = new ArrayList<>();
                }
                this.muz.addAll(arrayList);
                int size = this.muz.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.muz.size(); i++) {
                        this.muz.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mux.size();
                if (a2 != null) {
                    this.mux.addAll(a2);
                }
                int size3 = this.mux.size();
                if (!this.muD && this.muE != null) {
                    this.muE.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mux.size(); i3++) {
                        this.mux.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mux == null) {
                this.mux = new ArrayList<>(arrayList);
                dya();
            } else {
                if (this.muz == null) {
                    this.muz = new ArrayList<>();
                }
                this.muz.clear();
                this.muz.addAll(arrayList);
                this.mux.clear();
                dya();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mux.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.muB != null) {
                this.muB.a(this.mux.size());
                if (i == 1) {
                    this.muB.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.muB.notifyItemRangeRemoved(i2, i3);
                    this.muB.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.muB.notifyDataSetChanged();
                }
            }
            if (z || this.muD) {
                this.muD = true;
                if (this.muE != null) {
                    this.muE.setVisibility(8);
                }
                if (z) {
                    this.mut.scrollToPosition(this.mux.size() - 1);
                } else {
                    this.mut.smoothScrollToPosition(this.mux.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.muB != null) {
                this.muB.a(this.mux.size());
                this.muB.notifyDataSetChanged();
            }
            if (z || this.muD) {
                this.muD = true;
                if (this.muE != null) {
                    this.muE.setVisibility(8);
                }
                if (z) {
                    this.mut.scrollToPosition(this.mux.size() - 1);
                } else {
                    this.mut.smoothScrollToPosition(this.mux.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dxd;
        RoomToast roomToast;
        this.p = false;
        if (this.mwD != null && this.mwD.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mwD.f.size()) {
                    break;
                } else if (!"2".equals(this.mwD.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dye();
            return;
        }
        if (this.mqs != null) {
            this.mqs.setVisibility(0);
        }
        if (this.mtm != null) {
            this.mtm.setVisibility(0);
        }
        if (this.mwD != null) {
            this.muu = this.mwD.dxv();
            this.muv = this.mwD.dxs();
            if (com.kascend.chushou.b.dwA().c != null && this.muB != null) {
                this.muB.a(com.kascend.chushou.b.dwA().c);
                this.muB.notifyDataSetChanged();
            }
            FullRoomInfo dxs = this.mwD.dxs();
            if (dxs != null) {
                if (!h.isEmpty(dxs.mRoomToastList)) {
                    Iterator<RoomToast> it = dxs.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dwH().j())) {
                    a(roomToast);
                }
            }
            if (this.muu != null) {
                bk();
            }
            if (this.muu != null && !this.muu.mIsSubscribed) {
                RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.muu == null || !c.this.muu.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mwD != null && this.mwD.l()) {
                d(true);
            }
        }
        if (this.muu != null && this.muB != null) {
            if (this.mux != null) {
                this.mux.clear();
            } else {
                this.mux = new ArrayList<>();
            }
            this.muB.a(this.muu);
            dya();
            this.muB.a(this.mux.size());
            this.muB.notifyDataSetChanged();
        }
        aM();
        N();
        if (this.mwE != null && (this.mwE instanceof VideoPlayer) && (dxd = ((VideoPlayer) this.mwE).dxd()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dxd.msV, dxd.b);
        }
        this.mtO.h(this.muu.mCreatorAvatar, com.kascend.chushou.view.a.a(this.muu.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mtS);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.mup == null) {
            View inflate = LayoutInflater.from(this.mwE).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mrF = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mup = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwE, 160.0f), -2);
            this.mup.setFocusable(false);
            this.mup.setOutsideTouchable(false);
            this.mup.setAnimationStyle(a.j.gift_toast_style);
            this.mup.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dwH().c(roomToast.mToastContent);
            if (this.mup == null) {
                bd();
            }
            if (this.mrF != null) {
                this.mrF.setText(roomToast.mToastContent);
            }
            if (!this.mup.isShowing()) {
                if (this.mtS != null) {
                    this.mup.showAtLocation(this.mtS, 85, 0, this.mwo.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mup != null) {
                                c.this.mup.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mup.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mvf != null) {
            this.mvf.setVisibility(z ? 0 : 8);
        }
        this.mvg = true;
        if (this.mwE instanceof VideoPlayer) {
            ((VideoPlayer) this.mwE).p();
        }
    }

    private void dye() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mwE).s();
        dxL();
        dxM();
        if (this.mtD == null) {
            this.mtD = (PlayShowRecommendView) ((ViewStub) this.mwo.findViewById(a.f.view_recommend)).inflate();
        }
        this.mtD.setVisibility(0);
        if (this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null && !h.isEmpty(this.mwD.dxs().mRoominfo.mRoomID)) {
            bf();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mxk != null) {
            this.mxk.e();
        }
        if (this.mqs != null) {
            this.mqs.setVisibility(4);
        }
        if (this.mtm != null) {
            this.mtm.setVisibility(8);
        }
        if (this.mxs != null) {
            this.mxs.dJb();
            this.mxs.setVisibility(8);
        }
        we(false);
        a(false, false);
        if (this.mpZ != null) {
            this.mpZ.a();
        }
    }

    private void bf() {
        if (this.mtD != null && this.mtD.getVisibility() == 0) {
            this.mtD.a(this.mwD.dxs().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dxP() {
        super.dxP();
        if (this.mwE instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwE;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mub != null && this.mub.b()) {
            this.mub.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.muQ);
        if (this.mwE != null) {
            if (this.muQ || "10004".equals(((VideoPlayer) this.mwE).t)) {
                this.muQ = true;
                if (this.mwD != null) {
                    this.mwD.f = null;
                    if (this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                        this.mwD.dxs().mRoominfo.mGameId = null;
                    }
                }
                dye();
                return;
            }
            this.muQ = true;
            if (this.mwE != null) {
                ((VideoPlayer) this.mwE).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.muQ = false;
        if (this.mqs != null) {
            this.mqs.setVisibility(0);
        }
        if (this.mtm != null) {
            this.mtm.setVisibility(0);
        }
        if (this.mtD != null) {
            this.mtD.setVisibility(8);
        }
        if (this.mwy != null) {
            this.mwy.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.muQ = false;
        if (this.mqs != null) {
            this.mqs.setVisibility(0);
        }
        if (this.mtm != null) {
            this.mtm.setVisibility(0);
        }
        if (this.mtD != null) {
            this.mtD.setVisibility(8);
        }
        if (this.mwy != null) {
            this.mwy.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mtD != null) {
            this.mtD.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dym()) {
            if (i()) {
                if (i == 404) {
                    if (this.mwD != null) {
                        this.mwD.f = null;
                        this.mwD.dxs().mRoominfo.mGameId = null;
                    }
                    dye();
                    return;
                }
                tv.chushou.zues.utils.g.JO(a.i.str_getvideosource_failed);
            }
            we(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mwD != null && this.mwD.dxt() != null) {
            a(this.mwD.dxt());
        }
        this.p = false;
        if (this.mwD == null || this.mwD.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mwD.f.size()) {
                if (!"2".equals(this.mwD.f.get(i2).mType)) {
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
    public GiftAnimationLayout dxI() {
        if (this.mwo == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mwo.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mtS != null) {
            int size = iconConfig.configs.size();
            this.mtS.removeAllViews();
            if (this.mtU != null) {
                this.mtU.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mwE).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mtS, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bU(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.bU(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bU(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals("gift")) {
                            this.mtU.setVisibility(0);
                            this.mtT.bU(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.bU(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.bU(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.bU(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void dq(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.mtS.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void D() {
        if (this.mwE instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dwY = ((VideoPlayer) this.mwE).dwY();
            if (this.mxv == null) {
                this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxv.setVisibility(0);
            this.mxv.a(2, dwY);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mtW != null && this.mwE != null) {
            this.mtW.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mtW != null && this.mwE != null) {
            this.mtW.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(long j) {
        if (this.mtW != null) {
            this.mtW.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0749a
    public void c(int i) {
        if (this.mtW != null) {
            this.mtW.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void a(int i) {
        if (this.mtV != null) {
            if (this.mwE != null) {
                this.mtV.a(((VideoPlayer) this.mwE).dwY(), false);
            }
            this.mtV.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mwo != null) {
            Point fU = tv.chushou.zues.utils.a.fU(this.mwE);
            int i = fU.x > fU.y ? 1 : 2;
            if (this.mxv == null) {
                this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxv.setPlayerViewHelper(this.mwD);
            this.mxv.setVisibility(0);
            this.mxv.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mtX != null) {
            this.mtX.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mtX != null) {
            this.mtX.a(bangInfo, str);
        }
        if (this.mqG != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mqG.setText(this.mwE.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mqG.setText(this.mwE.getString(a.i.str_contribute_tittle));
            } else {
                this.mqG.setText(Html.fromHtml(this.mwE.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mty != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mty.setText(this.mwE.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mty.setText(this.mwE.getString(a.i.str_contribute_tittle));
            } else {
                this.mty.setText(Html.fromHtml(this.mwE.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mtX != null) {
            this.mtX.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mwD != null && !h.isEmpty(this.mwD.mpJ)) {
            this.muV = this.mwD.mpJ.get(0);
            if (this.mvn != null) {
                this.mvn.setVisibility(0);
                this.mvn.a(this.muV.mCover, 0, 0, 0, 1);
                if (this.mvo != null) {
                    if (this.muV.mShowClose) {
                        this.mvo.setVisibility(0);
                    } else {
                        this.mvo.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mtX != null) {
            this.mtX.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mwo != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mrd != null) {
            this.mrd.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dym() && !this.muM) {
            if (iVar.a == 52) {
                if (this.muB != null) {
                    this.muB.a(com.kascend.chushou.b.dwA().c);
                    this.muB.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.muM && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dym()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mtK != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mtK);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dym() && !this.muM) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mwE, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dwZ = ((VideoPlayer) this.mwE).dwZ();
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(2, dwZ);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dxa = ((VideoPlayer) this.mwE).dxa();
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(2, dxa);
            } else if (bVar.a == 8) {
                if (this.muX != null && this.muX.getVisibility() != 0) {
                    this.muX.a(a.C0736a.slide_in_bottom_danmu_anim, a.C0736a.slide_out_bottom_danmu_anim, this.muu == null ? "" : this.muu.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mxv == null) {
                    this.mxv = (H5Container) ((ViewStub) this.mwo.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxv.setVisibility(0);
                this.mxv.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dym() && this.mwD != null && !h.isEmpty(this.mwD.a) && this.mwD.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.muX != null && this.muX.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mwE, 80.0f);
                }
                if (this.muW != null && this.muW.getVisibility() == 0) {
                    r0 = Math.max(r0, this.muW.getHeight());
                }
                this.mvi.setTranslationY(-r0);
                return;
            }
            if (this.mvh != null) {
                this.mvh.cancel();
                this.mvh = null;
            }
            int translationY = (int) this.mvi.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mwE, 80.0f) : 0;
                    if (this.muW != null && this.muW.getVisibility() == 0) {
                        r0 = Math.max(r0, this.muW.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.muW.getHeight() : 0;
                    if (this.muX != null && this.muX.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mwE, 80.0f));
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
        this.mvh = ValueAnimator.ofInt(i, i2);
        this.mvh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dym() && c.this.mtX != null) {
                    c.this.mvi.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mvh.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mvh = null;
            }
        });
        this.mvh.setInterpolator(new LinearInterpolator());
        this.mvh.setDuration(800L);
        this.mvh.start();
    }

    private boolean dyf() {
        if (this.muT == 1) {
            this.muT = 2;
            x(true);
            return true;
        } else if (this.muT == 3) {
            dyi();
            return true;
        } else {
            return false;
        }
    }

    private boolean dyg() {
        if (this.muT == 1) {
            return dyh();
        }
        if (this.muT == 2) {
            this.muT = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean dyh() {
        if (this.dx || this.mwD == null || this.mwD.dxv() == null) {
            return false;
        }
        if (this.mvP != null) {
            this.mvP.a(true);
        }
        this.muT = 3;
        this.dx = true;
        bk();
        this.mtj.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.dx = false;
                c.this.mtl.setVisibility(8);
            }
        });
        this.mtl.startAnimation(loadAnimation);
        this.mtj.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyi() {
        if (!this.dx) {
            if (this.mvP != null) {
                this.mvP.a(false);
            }
            this.muT = 1;
            this.dx = true;
            bk();
            this.mtl.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.dx = false;
                    c.this.mtj.setVisibility(8);
                }
            });
            this.mtl.startAnimation(loadAnimation);
            this.mtj.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.mwo != null) {
            if (this.mtj == null) {
                this.mtj = this.mwo.findViewById(a.f.user_space_container);
            }
            if (this.mtl == null) {
                this.mtl = this.mwo.findViewById(a.f.video_container);
            }
            if (this.mtk == null) {
                this.mtk = com.kascend.chushou.view.user.b.b(null, this.mwD.a, false, this.mwD.h);
                this.mtk.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dyi();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dyi();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mtk).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.mtm != null) {
            this.mtm.setVisibility(z ? 8 : 0);
        }
        if (this.mur != null) {
            this.dx = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mur.setVisibility(8);
                        c.this.dx = false;
                    }
                });
            } else {
                this.dx = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mur.setVisibility(0);
                        c.this.dx = false;
                    }
                });
            }
            this.mur.startAnimation(loadAnimation);
        }
        dxK();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mtE.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mtM != null) {
                this.mtM.setVisibility(0);
            }
            if (this.mtN != null) {
                this.mtN.a();
                return;
            }
            return;
        }
        if (this.mtP != null) {
            this.mtP.setVisibility(0);
        }
        if (this.mtQ != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mtQ.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mtP != null) {
            this.mtP.setVisibility(8);
        }
        if (this.mtQ != null) {
            this.mtQ.clearAnimation();
        }
        if (this.mtM != null) {
            this.mtM.setVisibility(8);
        }
        if (this.mtN != null) {
            this.mtN.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mur != null && this.mwo != null) {
            if (this.muX == null) {
                this.muX = new com.kascend.chushou.player.ui.miniview.a(this.mwE, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.muX != null && c.this.mwo != null && c.this.muX.a()) {
                            ((ViewGroup) c.this.mwo).removeView(c.this.muX);
                            c.this.muX = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.muX.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mwE, 52.0f);
                this.muX.setLayoutParams(layoutParams);
                ((ViewGroup) this.mur).addView(this.muX, ((ViewGroup) this.mur).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.muX.setVisibility(8);
                } else {
                    this.muX.a(a.C0736a.slide_in_bottom_danmu_anim, a.C0736a.slide_out_bottom_danmu_anim, this.mwD.a == null ? "" : this.mwD.a);
                }
            } else if (!this.muX.isShown()) {
                this.muX.a(a.C0736a.slide_in_bottom_danmu_anim, a.C0736a.slide_out_bottom_danmu_anim, this.mwD.a == null ? "" : this.mwD.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mve != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mve.setVisibility(0);
                this.mve.setAnim(true);
                this.mve.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nua, b.C0861b.nuc, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.muF != null && this.muF.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dyj();
                    }
                });
                this.muF.setVisibility(0);
                this.muF.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.muF != null && this.muF.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.muH != null) {
                        c.this.muH.removeAllListeners();
                        c.this.muH.cancel();
                        c.this.muH = null;
                    }
                    if (c.this.muF != null) {
                        c.this.muF.setVisibility(8);
                    }
                }
            });
            this.muF.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mvl == null) {
                this.mvl = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dym()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mwE, "显示双击666_num", null, new Object[0]);
                            if (c.this.mwD != null) {
                                c.this.mwD.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.mwF != null) {
                    this.mwF.e(this.mvl, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mvl != null) {
            this.mwF.N(this.mvl);
            this.mvl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.muI != null && this.muI.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mwE, a.C0736a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dyk();
                    }
                });
                this.muI.setVisibility(0);
                this.muI.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mwn, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.muI != null && this.muI.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwE, a.C0736a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.muK != null) {
                        c.this.muK.removeAllListeners();
                        c.this.muK.cancel();
                        c.this.muK = null;
                    }
                    if (c.this.muI != null) {
                        c.this.muI.setVisibility(8);
                    }
                }
            });
            this.muI.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dyj() {
        if (this.muF == null || this.muG == null) {
            return null;
        }
        if (this.muH != null) {
            this.muH.removeAllListeners();
            this.muH.cancel();
            this.muH = null;
        }
        this.muG.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.muG, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.muG, 0.0f);
        int measuredWidth = (this.muF.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mwE, 13.0f) * 2)) - this.muG.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.muG, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.muG, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.muG, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.muH != null) {
                    c.this.muH.removeAllListeners();
                    c.this.muH.cancel();
                    c.this.muH = null;
                }
                RxExecutor.postDelayed(c.this.mwn, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dyj();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.muH = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dyk() {
        if (this.muI == null || this.muJ == null) {
            return null;
        }
        if (this.muK != null) {
            this.muK.removeAllListeners();
            this.muK.cancel();
            this.muK = null;
        }
        this.muJ.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.muJ, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.muJ, 0.0f);
        int measuredWidth = (this.muI.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mwE, 13.0f) * 2)) - this.muJ.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.muJ, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.muJ, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.muJ, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.muK != null) {
                    c.this.muK.removeAllListeners();
                    c.this.muK.cancel();
                    c.this.muK = null;
                }
                RxExecutor.postDelayed(c.this.mwn, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dyk();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.muK = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mvP = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mqg != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mqg.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dym()) {
                        ParserRet dy = com.kascend.chushou.c.a.dy(jSONObject);
                        if (dy.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.JO(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.JO(a.i.subscribe_success);
                            }
                            if (c.this.mqg != null) {
                                c.this.mqg.isSubscribe = !z;
                                c.this.aN();
                                return;
                            }
                            return;
                        }
                        a(dy.mRc, dy.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dym()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.t(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dwD().a(bVar, (String) null, this.mqg.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mqg.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dwD().b(bVar, (String) null, c.this.mqg.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mwD != null && this.muu != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mwD.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mwD.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.muu.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dym()) {
                        ParserRet dy = com.kascend.chushou.c.a.dy(jSONObject);
                        if (dy.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.JO(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.JO(a.i.subscribe_success);
                            }
                            c.this.muu.mIsSubscribed = !z;
                            c.this.aO();
                            return;
                        }
                        a(dy.mRc, dy.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dym()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.t(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dwD().a(bVar, (String) null, this.muu.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.muu.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dwD().b(bVar, (String) null, c.this.muu.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.msU != null) {
            int width = this.msU.getWidth();
            int height = this.msU.getHeight();
            if (this.mvc != width || this.mvd != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mwE).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mwo != null) {
            if (this.mtR == null) {
                this.mtR = (InteractionView) ((ViewStub) this.mwo.findViewById(a.f.view_interaction)).inflate();
                this.mtR.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mtR.a();
                    }
                });
            }
            if (this.mtR != null) {
                this.mtR.b(configDetail);
                this.mtR.c();
                this.mtR.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dJO()) {
                tv.chushou.zues.utils.g.F(this.mwE, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mwE, null) && (this.mwE instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwD != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwE, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mwE, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwD != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwE, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mwE, configDetail.mUrl, this.mwE.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mwE, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    if (this.muP) {
                        aD();
                        return;
                    }
                    if (this.mwE.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mwE, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mwD != null && this.mwD.dxs() != null && this.mwD.dxs().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwD.dxs().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    ds(this.mtS);
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
        if (this.mwE != null && !this.v && !h.isEmpty(str) && this.muu != null && str.equals(this.muu.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mqd == null) {
                this.mqd = new com.kascend.chushou.player.e.a();
            }
            this.mqd.b = str;
            this.mqd.msV.copy(pkNotifyInfo);
            if (this.mqd.msV.mAction == 6) {
                if (this.mpZ != null) {
                    this.mpZ.a(true);
                }
                this.mqd.msV.mInPKMode = true;
                this.u = this.mqd.msV.mPkId;
            } else if (this.mqd.msV.mAction == 7 || (this.mqd.msV.mMode == 1 && this.mqd.msV.mAction == 5)) {
                if (this.mpZ != null) {
                    this.mpZ.a(true);
                }
                this.mqd.msV.mInPKMode = true;
                if (this.mva != 42) {
                    this.mvm = ((this.mvb.y - ((this.mvb.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mwE, 158.0f) + this.mun)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
                    aX();
                }
                this.u = this.mqd.msV.mPkId;
                if (this.mqe != null) {
                    this.mqe.b(this.mqd.msV, false);
                    this.mqe.a(this.mqd.msV.mMode, (String) null);
                    if (this.mqd.msV.mAction == 5 && this.mqd.msV.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mqd.msV.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mqd.msV.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mqd.msV.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mqd.msV.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mqd.msV.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mqe.a(this.mqd.msV);
                        this.mqe.a(parseInt, this.mqd.msV.mPkUpdateInfo.remainDuration, j, this.mqd.msV.mMode, (this.mqd.msV.destinyInfo == null || this.mqd.msV.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mqd.msV.mPkUpdateInfo != null && !h.isEmpty(this.mqd.msV.mPkUpdateInfo.specialMomentList) && this.mqe != null) {
                    this.mqe.a(this.mqd.msV, true);
                }
                if (this.mqd.msV.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.mqd.msV.mInPKMode = false;
                if (this.mqd.msV.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        aV();
        dxO();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.muk != null && this.mwD != null && this.mwD.mpL != null) {
            this.muk.setText(tv.chushou.zues.utils.b.JN(this.mwD.mpL.count));
            this.muk.setVisibility(0);
            if (this.mwD.mpL.count < 1) {
                bo();
            }
            if (this.mud != null) {
                this.mud.setText(this.mwD.mpL.primaryName);
            }
            if (this.mue != null) {
                this.mue.setText(this.mwD.mpL.desc);
            }
            aH();
        }
    }

    public void aH() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mul * h.parseLong(this.mwD.mpL.point)));
        if (this.mrv != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mwE.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mwE, a.e.icon_coin_new);
            cVar.append(this.mwE.getString(a.i.str_buy_count_coin2));
            this.mrv.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.mwE, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mul);
        }
    }

    private void bo() {
        this.mum = false;
        this.muj.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mwD != null && this.mwD.mpL != null) {
            if (this.mwD.mpL.count < 1) {
                this.muk.setVisibility(8);
            } else {
                this.muk.setVisibility(0);
                this.muk.setSelected(false);
                this.muk.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.muc.setVisibility(8);
        if (this.mtK != null) {
            this.mtK.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mqi != null) {
            if (z) {
                this.mqi.setVisibility(0);
            } else {
                this.mqi.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mvM != null) {
            this.mvM.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mtT != null) {
            this.mtT.performClick();
        }
    }
}
