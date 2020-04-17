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
    private TextView mqB;
    private ImageView mqH;
    private TextView mqQ;
    private KPSwitchPanelLinearLayout mqY;
    private ImageView mqZ;
    private View mqn;
    public String mqu;
    private TextView mqy;
    private TextView mrA;
    private View mrD;
    private tv.chushou.zues.widget.kpswitch.b.c mrb;
    private d.a mrc;
    private TextView mrq;
    private TextView msC;
    private RelativeLayout mtA;
    private AnimationSet mtB;
    private ImageView mtC;
    private ImageView mtD;
    private RelativeLayout mtE;
    private PastedEditText mtF;
    private ToggleButton mtG;
    private RelativeLayout mtH;
    private PaoPaoView mtI;
    private FrescoThumbnailView mtJ;
    private LinearLayout mtK;
    private ImageView mtL;
    private InteractionView mtM;
    private LinearLayout mtN;
    private FrescoThumbnailView mtO;
    private FrameLayout mtP;
    private RedpacketNotifier mtQ;
    private InteractNotifier mtR;
    private EmbeddedButtonLayout mtS;
    private GiftAnimationLayout mtT;
    private com.kascend.chushou.player.b.a mtU;
    private f mtV;
    private PlayShowH5View mtW;
    private LinearLayout mtX;
    private TextView mtY;
    private TextView mtZ;
    private int mtc;
    private View mtd;
    private View mte;
    private com.kascend.chushou.view.user.b mtf;
    private View mtg;
    private FrameLayout mth;
    private LinearLayout mti;
    private RelativeLayout mtj;
    private FrescoThumbnailView mtk;
    private TextView mtl;
    private TextView mtm;
    private TextView mtn;
    private FrescoThumbnailView mto;
    private TextView mtp;
    private TextView mtq;
    private TextView mtr;
    private int mts;
    private TextView mtt;
    private LinearLayout mtu;
    private PlayShowMicStatusView mtv;
    private RecyclerView mtw;
    private ImageView mtx;
    private PlayShowRecommendView mty;
    private View mtz;
    private View muA;
    private View muB;
    private Animator muC;
    private View muD;
    private View muE;
    private Animator muF;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> muI;
    private PlayShowMicPerson muM;
    private FoodView muP;
    public ListItem muQ;
    private FoodView muR;
    private com.kascend.chushou.player.ui.miniview.a muS;
    private int muT;
    private int muU;
    private int muV;
    private Point muW;
    private FrescoThumbnailView muZ;
    private TextView mua;
    private TextView mub;
    private TextView muc;
    private TextView mud;
    private ImageView mue;
    private TextView muf;
    private PopupWindow muk;
    private View mum;
    private RecyclerView muo;
    private RoomInfo mup;
    private RecyclerView.LayoutManager mur;
    private ArrayList<ChatInfo> mus;
    private ArrayList<ChatInfo> mut;
    private ArrayList<ChatInfo> muu;
    private ArrayList<ChatInfo> muv;
    private Button muz;
    private RelativeLayout mvA;
    private FrescoThumbnailView mvB;
    private TextView mvC;
    private TextView mvD;
    private ImageView mvE;
    private RelativeLayout mvF;
    private TextView mvH;
    private float mvI;
    private float mvJ;
    private a mvK;
    private FrescoThumbnailView mva;
    private ValueAnimator mvc;
    private LinearLayout mvd;
    private long mve;
    private VideoShowVoteView mvf;
    private Runnable mvg;
    private FrescoThumbnailView mvi;
    private ImageView mvj;
    private RelativeLayout mvk;
    private TextView mvl;
    private ImageView mvm;
    private EditText mvn;
    private View mvo;
    private RelativeLayout mvp;
    private RelativeLayout mvq;
    private FrescoThumbnailView mvr;
    private TextView mvs;
    private TextView mvt;
    private ImageView mvu;
    private RelativeLayout mvv;
    private LinearLayout mvw;
    private TextView mvx;
    private TextView mvy;
    private RelativeLayout mvz;
    private boolean mra = false;
    private int mug = 1;
    private boolean muh = false;
    private int mui = 0;
    private int muj = 0;
    private int mul = -1;
    private boolean mun = false;
    private FullRoomInfo muq = null;
    private com.kascend.chushou.player.adapter.a muw = null;
    private ArrayList<String> mux = null;
    private boolean muy = true;
    private boolean muG = true;
    private boolean muH = false;
    public final List<OnlineVipItem> muJ = new ArrayList();
    private boolean muK = false;
    private boolean muL = false;
    private long muN = 0;
    private int muO = 1;
    private boolean dx = false;
    private int muX = -1;
    private int muY = -1;
    private boolean mvb = false;
    private int mvh = -1;
    private io.reactivex.disposables.b mvG = null;

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
        this.mqu = getArguments().getString("cover");
        this.muG = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mwj = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mwj;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dyq()) {
            dxJ();
            this.msP = ((VideoPlayer) this.mwz).dwS();
            this.mwy = ((VideoPlayer) this.mwz).dwV();
            dr(view);
            dxR();
            if (this.mwz instanceof VideoPlayer) {
                ((VideoPlayer) this.mwz).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.muH = false;
        if (this.mxf != null) {
            this.mxf.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.muH = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.muC != null) {
            this.muC.removeAllListeners();
            this.muC.cancel();
            this.muC = null;
        }
        if (this.muF != null) {
            this.muF.removeAllListeners();
            this.muF.cancel();
            this.muF = null;
        }
        if (this.mtR != null) {
            this.mtR.c();
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
        if (this.mvG != null) {
            this.mvG.dispose();
            this.mvG = null;
        }
        this.mug = 1;
        this.muh = false;
        if (this.mwA != null) {
            this.mwA.bZ(null);
        }
        if (this.muk != null) {
            this.muk.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mwz, this.mrb);
        if (this.mwz != null && (this.mwz instanceof VideoPlayer)) {
            ((VideoPlayer) this.mwz).dwZ();
        }
        this.mrc = null;
        this.mrb = null;
        dxH();
        if (this.mtU != null) {
            this.mtU.a();
        }
        if (this.mtI != null) {
            this.mtI.b();
            this.mtI.c();
            this.mtI = null;
        }
        super.d();
    }

    private void dxH() {
        tv.chushou.zues.a.a.ca(this);
        if (this.muu != null) {
            this.muu.clear();
        }
        if (this.mus != null) {
            this.mus.clear();
        }
        if (this.muv != null) {
            this.muv.clear();
        }
        if (this.mut != null) {
            this.mut.clear();
        }
        if (this.mux != null) {
            this.mux.clear();
        }
        if (this.muw != null) {
            this.muw.a(0);
            this.muw.a();
        }
    }

    private void dr(View view) {
        this.mtd = view.findViewById(a.f.fl_root);
        this.muW = tv.chushou.zues.utils.a.gi(this.mwz);
        this.mui = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mwz);
        this.muj = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        this.muV = 86;
        this.mwy = ((VideoPlayer) this.mwz).dwV();
        if (this.mwy != null) {
            this.mup = this.mwy.dxz();
            this.muq = this.mwy.dxv();
        }
        this.mus = new ArrayList<>();
        this.muu = new ArrayList<>();
        this.mut = new ArrayList<>();
        this.mth = (FrameLayout) this.mwj.findViewById(a.f.fl_effect);
        b();
        this.mwt = (PlayerErrorView) this.mwj.findViewById(a.f.view_net_error_msg);
        this.mwt.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mtH = (RelativeLayout) this.mwj.findViewById(a.f.rl_audio_ani);
        this.mtI = (PaoPaoView) this.mwj.findViewById(a.f.audio_ani);
        this.mtJ = (FrescoThumbnailView) this.mwj.findViewById(a.f.audio_ani_avatar);
        this.mtK = (LinearLayout) this.mwj.findViewById(a.f.ll_audio);
        this.msC = (TextView) this.mwj.findViewById(a.f.tv_open_video);
        this.mtL = (ImageView) this.mwj.findViewById(a.f.iv_audio_ani);
        this.mva = (FrescoThumbnailView) this.mwj.findViewById(a.f.live_cover);
        if (!this.mvb || this.msP == null || this.msP.getPlayState() != 4) {
            this.mva.setVisibility(0);
            this.mva.setBlur(true);
            this.mva.i(this.mqu, 0, 0, 0);
        }
        this.msC.setOnClickListener(this);
        this.mpZ = new b();
        this.mpZ.a(view, null, this.mwz, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dJy()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mwy != null) {
                    append.append(c.this.mwy.dxz().mRoomID);
                }
                if (c.this.mpY != null && c.this.mpY.msQ != null) {
                    append.append("&mode=").append(c.this.mpY.msQ.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mwz, append.toString());
            }
        });
        this.mqd = (VoiceInteractionView) this.mwj.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mwy != null) {
            this.mup = this.mwy.dxz();
            this.muq = this.mwy.dxv();
        }
        dxK();
        dxI();
        dxL();
        this.mvd = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.muP = (FoodView) view.findViewById(a.f.rav_ad);
        this.mvi = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mvj = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mvi.setOnClickListener(this);
        this.mvj.setOnClickListener(this);
        this.mvk = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.muZ = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.muZ.setOnClickListener(this);
        this.mtR = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mtQ = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.muz = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.muz.setOnClickListener(this);
        this.muo = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.muo.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.muo.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.muW.x, this.muW.y) * 0.83d);
        this.muo.setLayoutParams(layoutParams);
        this.mur = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mwz);
        this.muo.setLayoutManager(this.mur);
        this.muo.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.muo.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.muo.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.muy = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.muw = new com.kascend.chushou.player.adapter.a(this.mwz, this.mus);
        if (this.mup != null) {
            this.muw.a(this.mup);
        }
        if (com.kascend.chushou.b.dwD().c != null) {
            this.muw.a(com.kascend.chushou.b.dwD().c);
        }
        this.muo.setAdapter(this.muw);
        this.muw.a(this.mus.size());
        this.muw.notifyDataSetChanged();
        if (this.mwy != null && (c = this.mwy.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mtU != null) {
            this.mtU.a();
            this.mtU = null;
        }
        this.mtT = (GiftAnimationLayout) this.mwj.findViewById(a.f.ll_gift_animation);
        this.mtT.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mtc = ((int) (tv.chushou.zues.utils.a.gh(this.mwz).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mwz, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mtT.getLayoutParams();
        layoutParams2.bottomMargin = this.mtc;
        this.mtT.setLayoutParams(layoutParams2);
        if (this.mwy != null) {
            this.mtU = new com.kascend.chushou.player.b.a(this.mwz.getApplicationContext(), this.mtT);
            this.mtU.a(this.mwy);
            a(this.mwy.mpD, this.mwy.mpH);
        }
        this.mwj.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mtS = (EmbeddedButtonLayout) this.mwj.findViewById(a.f.embedded_button_layout);
        this.mtS.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mvf = (VideoShowVoteView) this.mwj.findViewById(a.f.view_video_show_vote);
        this.mvf.setOnClickListener(this);
        this.mvf.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.mwy != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
            this.mtS.a(videoPlayer.dxf().dyw());
            this.mtS.b(this.mwy.dxx());
            this.mtQ.a(videoPlayer.dxb(), false);
            this.mtR.a(videoPlayer.dxc(), videoPlayer.dxd(), videoPlayer.dxe());
            this.mpY = new com.kascend.chushou.player.e.a();
        }
        this.mxp = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.muK = false;
                c.this.b(c.this.mtc, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.muK = true;
                if (c.this.mxf != null) {
                    c.this.mxf.measure(0, 0);
                    int measuredHeight = c.this.mxf.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mwz, 14.0f);
                    if (measuredHeight > c.this.mtc) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mxj = (PaoGuideView) this.mwj.findViewById(a.f.rlPaoGuideView);
        this.muM = (PlayShowMicPerson) this.mwj.findViewById(a.f.rl_mic_person_view);
        this.mtW = (PlayShowH5View) this.mwj.findViewById(a.f.rl_playshowh5);
        this.muR = (FoodView) this.mwj.findViewById(a.f.bottom_ad);
        if (this.mwy != null) {
            H();
            if (this.mwy.mpx != null && !h.isEmpty(this.mwy.mpx.mUrl)) {
                b(this.mwy.mpx);
            }
        }
        this.muA = this.mwj.findViewById(a.f.view_reminder_subscribe);
        this.muB = this.muA.findViewById(a.f.spash_subscribe);
        ((TextView) this.muA.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.mwz, a.e.videoplayer_reminder_subscribe).append(" ").append(this.mwz.getString(a.i.videoplayer_reminder_subscribe)));
        this.muA.setOnClickListener(this);
        this.muD = this.mwj.findViewById(a.f.view_reminder_danmaku);
        this.muE = this.muD.findViewById(a.f.spash_danmaku);
        ((TextView) this.muD.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.mwz, a.e.videoplayer_reminder_danmaku).append(" ").append(this.mwz.getString(a.i.videoplayer_reminder_danmaku)));
        this.muD.setOnClickListener(this);
    }

    private void dxI() {
        this.mvp = (RelativeLayout) this.mwj.findViewById(a.f.rl_cyclelive);
        this.mvq = (RelativeLayout) this.mwj.findViewById(a.f.rlrl_cyclelive);
        this.mvr = (FrescoThumbnailView) this.mwj.findViewById(a.f.iv_liveicon);
        this.mvs = (TextView) this.mwj.findViewById(a.f.tv_livename);
        this.mvt = (TextView) this.mwj.findViewById(a.f.tv_livedesc);
        this.mvu = (ImageView) this.mwj.findViewById(a.f.iv_cyclelive_name_menu);
        this.mvv = (RelativeLayout) this.mwj.findViewById(a.f.rl_normal);
        this.mvw = (LinearLayout) this.mwj.findViewById(a.f.ll_cyclelive_nickname);
        this.mvx = (TextView) this.mwj.findViewById(a.f.tv_cyclelive_nickname);
        this.mvy = (TextView) this.mwj.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mvz = (RelativeLayout) this.mwj.findViewById(a.f.rl_clear_cyclelive);
        this.mvA = (RelativeLayout) this.mwj.findViewById(a.f.rlrl_clear_cyclelive);
        this.mvB = (FrescoThumbnailView) this.mwj.findViewById(a.f.iv_clear_liveicon);
        this.mvC = (TextView) this.mwj.findViewById(a.f.tv_clear_livename);
        this.mvD = (TextView) this.mwj.findViewById(a.f.tv_clear_livedesc);
        this.mvE = (ImageView) this.mwj.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mvF = (RelativeLayout) this.mwj.findViewById(a.f.rl_clear_normal);
        this.mvE.setOnClickListener(this);
        this.mvu.setOnClickListener(this);
        this.mvy.setOnClickListener(this);
        this.mvx.setOnClickListener(this);
        this.mvr.setOnClickListener(this);
        this.mvB.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mwy.mpv != null && this.muR != null) {
            this.muR.a(true, this.mwy.a == null ? "" : this.mwy.a);
            this.muR.a(this.mwy.mpv, a.C0715a.slide_in_bottom_danmu_anim, a.C0715a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mwy != null && this.mwy.mpC != null && this.mtS != null) {
            this.muP.a(this.mwy.mpC, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mwy != null) {
                        c.this.mwy.mpC = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dxW() {
        return this.mtU;
    }

    private void dxJ() {
        this.mwA = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mwj != null && (textView = (TextView) c.this.mwj.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mwz.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mwA.A(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mwA);
                        break;
                    case 12:
                        c.this.b(c.this.mwA);
                        break;
                    case 17:
                        c.this.dys();
                        break;
                    case 18:
                        c.this.dls();
                        break;
                    case 19:
                        c.this.mwx.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mun) {
            this.mun = true;
            if (this.mum == null) {
                this.mum = this.mwj.findViewById(a.f.vs_async_show_content);
                this.mum = ((ViewStub) this.mum).inflate();
            }
            this.mqn = this.mwj.findViewById(a.f.ui_content);
            if (this.mrD == null) {
                this.mrD = this.mwj.findViewById(a.f.vs_async_notification_view);
                this.mrD = ((ViewStub) this.mrD).inflate();
            }
            c(this.mwj);
            k();
            dlt();
            if (this.c == null) {
                this.mpS = new d.a();
                this.c = new GestureDetector(this.mwz, this.mpS);
            }
            ((VideoPlayer) this.mwz).q();
        }
    }

    private void dxK() {
        this.mti = (LinearLayout) this.mwj.findViewById(a.f.ll_anchor);
        this.mtj = (RelativeLayout) this.mwj.findViewById(a.f.ll_clear_anchor);
        this.mti.setVisibility(4);
        this.mtj.setVisibility(4);
        this.mtk = (FrescoThumbnailView) this.mwj.findViewById(a.f.iv_clear_avatar);
        this.mtl = (TextView) this.mwj.findViewById(a.f.tv_clear_nickname);
        this.mtm = (TextView) this.mwj.findViewById(a.f.tv_clear_online_count);
        this.mtn = (TextView) this.mwj.findViewById(a.f.tv_clear_btn_subscribe);
        this.mtn.setOnClickListener(this);
        this.mto = (FrescoThumbnailView) this.mwj.findViewById(a.f.iv_avatar);
        this.mtp = (TextView) this.mwj.findViewById(a.f.tv_nickname_test);
        this.mtq = (TextView) this.mwj.findViewById(a.f.tv_online_count);
        this.mqy = (TextView) this.mwj.findViewById(a.f.tv_btn_subscribe);
        this.mqy.setOnClickListener(this);
        this.mtr = (TextView) this.mwj.findViewById(a.f.tv_loyal_counts);
        this.mqB = (TextView) this.mwj.findViewById(a.f.tv_btn_contribution);
        this.mtt = (TextView) this.mwj.findViewById(a.f.tv_btn_contribution_forpk);
        this.mqB.setVisibility(4);
        this.mtt.setVisibility(8);
        this.mtu = (LinearLayout) this.mwj.findViewById(a.f.ll_mic);
        this.mtv = (PlayShowMicStatusView) this.mwj.findViewById(a.f.show_mic_status);
        this.mtw = (RecyclerView) this.mwj.findViewById(a.f.rv_loyal);
        this.mtx = (ImageView) this.mwj.findViewById(a.f.iv_clear_close);
        this.mqH = (ImageView) this.mwj.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mtw.setLayoutManager(linearLayoutManager);
        this.muI = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.muJ, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.muJ.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mwz, (JSONObject) null, c.this.mwy.dxz().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0837a view$OnLongClickListenerC0837a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0837a view$OnLongClickListenerC0837a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0837a.JQ(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0837a.JQ(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0837a.JQ(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dJK(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mwz, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwz, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwz, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwz, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mwz, a.c.color_979797), dip2px);
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
        this.mtw.setAdapter(this.muI);
        this.mtu.setOnClickListener(this);
        this.mtk.setOnClickListener(this);
        this.mtx.setOnClickListener(this);
        this.mto.setOnClickListener(this);
        this.mtk.setOnClickListener(this);
        this.mqH.setOnClickListener(this);
        this.mtr.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dq(View view) {
                String str = tv.chushou.common.a.dJy() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mwy != null) {
                    str = str + c.this.mwy.dxz().mRoomID;
                }
                c.this.f(c.this.mwz.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mqB.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dq(View view) {
                String str = tv.chushou.common.a.dJy() + "m/room-billboard/";
                if (c.this.mwy != null) {
                    str = str + c.this.mwy.dxz().mRoomID;
                }
                c.this.f(c.this.mwz.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mtt.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dq(View view) {
                String str = tv.chushou.common.a.dJy() + "m/room-billboard/";
                if (c.this.mwy != null) {
                    str = str + c.this.mwy.dxz().mRoomID;
                }
                c.this.f(c.this.mwz.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.muq == null || this.muq.cycleLiveRoomInfo == null || h.isEmpty(this.muq.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mqb = this.muq.cycleLiveRoomInfo;
        }
        if (z2 && this.mqb != null) {
            this.mvp.setVisibility(0);
            this.mvz.setVisibility(0);
            this.mvv.setVisibility(8);
            this.mvF.setVisibility(8);
            this.mvw.setVisibility(0);
            this.mvB.h(this.mqb.eventIcon, com.kascend.chushou.view.a.a(this.mup.mCreatorGender), b.a.small, b.a.small);
            this.mvr.h(this.mqb.eventIcon, com.kascend.chushou.view.a.a(this.mup.mCreatorGender), b.a.small, b.a.small);
            this.mvC.setText(this.mqb.eventName);
            this.mvD.setText(this.mqb.eventDesc);
            this.mvs.setText(this.mqb.eventName);
            this.mvt.setText(this.mqb.eventDesc);
            this.mvx.setText(this.mqb.nickname);
            aN();
            if (z) {
                c(this.mqb.remainTime);
                return;
            }
            return;
        }
        this.mvp.setVisibility(8);
        this.mvz.setVisibility(8);
        this.mvv.setVisibility(0);
        this.mvF.setVisibility(0);
        this.mvw.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mvG != null) {
            this.mvG.dispose();
            this.mvG = null;
        }
        this.mvG = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dCH()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mwz != null && (c.this.mwz instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mwz).u();
                }
            }
        });
    }

    private void aM() {
        if (this.mup != null && this.mun) {
            this.mti.setVisibility(0);
            this.mtj.setVisibility(0);
            this.mqB.setVisibility(0);
            this.mtk.h(this.mup.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mup.mCreatorGender), b.a.small, b.a.small);
            this.mtl.setText(this.mup.mCreatorNickname);
            this.mto.h(this.mup.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mup.mCreatorGender), b.a.small, b.a.small);
            this.mtp.setText(this.mup.mCreatorNickname);
            dyh();
            aO();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dyh() {
        if (this.mup != null) {
            this.mtm.setText(tv.chushou.zues.utils.b.formatNumber(this.mup.mOnlineCount));
            this.mtq.setText(tv.chushou.zues.utils.b.formatNumber(this.mup.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.mqb != null) {
            if (this.mqb.isSubscribe) {
                this.mvy.setText(a.i.like_already);
                this.mvy.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mvy.setText(getString(a.i.like));
            this.mvy.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        if (this.mup != null) {
            if (this.mup.mIsSubscribed) {
                this.mtn.setText(getString(a.i.like_already));
                this.mtn.setBackgroundResource(a.e.bg_show_subcribe);
                this.mqy.setText(getString(a.i.like_already));
                this.mqy.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mtn.setText(getString(a.i.like));
            this.mtn.setBackgroundResource(a.e.bg_show_subcribe);
            this.mqy.setText(getString(a.i.like));
            this.mqy.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void aP() {
        if (this.muI != null) {
            this.muI.notifyDataSetChanged();
        }
    }

    private void dxL() {
        this.mtz = this.mwj.findViewById(a.f.tv_interact);
        this.mtz.setOnClickListener(this);
        this.mtE = (RelativeLayout) this.mwj.findViewById(a.f.rl_edit_bar);
        this.mtC = (ImageView) this.mwj.findViewById(a.f.btn_hotword);
        this.mtC.setOnClickListener(this);
        this.mtD = (ImageView) this.mwj.findViewById(a.f.iv_task_badge);
        this.mtB = (AnimationSet) AnimationUtils.loadAnimation(this.mwz, a.C0715a.anim_hotword);
        this.mtB.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dwK().c) {
                    c.this.mtC.clearAnimation();
                    c.this.mtC.startAnimation(c.this.mtB);
                }
            }
        });
        if (com.kascend.chushou.d.h.dwK().c) {
            this.mtC.startAnimation(this.mtB);
            this.mtD.setVisibility(0);
        }
        this.mvH = (TextView) this.mwj.findViewById(a.f.tv_bottom_input);
        this.mvH.setOnClickListener(this);
        this.mxz = (FrescoThumbnailView) this.mwj.findViewById(a.f.ll_btn_set);
        this.mxz.setOnClickListener(this);
        this.mxz.xW(a.e.ic_room_set_btn_white);
        this.mtN = (LinearLayout) this.mwj.findViewById(a.f.ll_bottom_all_button);
        this.mtO = (FrescoThumbnailView) this.mwj.findViewById(a.f.fl_clear_bottom_gift);
        this.mtO.setAnim(true);
        this.mtO.setOnClickListener(this);
        this.mtO.xW(a.e.ic_show_gift_n);
        this.mtP = (FrameLayout) this.mwj.findViewById(a.f.flfl_clear_bottom_gift);
        this.mtP.setVisibility(8);
        this.mtA = (RelativeLayout) this.mwj.findViewById(a.f.rl_bottom_input);
        this.mtA.setVisibility(0);
        this.mtF = (PastedEditText) this.mwj.findViewById(a.f.et_bottom_input);
        this.mtF.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mqQ.setEnabled(editable.length() > 0);
            }
        });
        this.mtF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mqQ);
                    return true;
                }
                return true;
            }
        });
        this.mtF.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.m(c.this.mtF);
                }
                return false;
            }
        });
        this.mqZ = (ImageView) this.mwj.findViewById(a.f.iv_btn_emoji);
        this.mqZ.setVisibility(8);
        this.mqQ = (TextView) this.mwj.findViewById(a.f.tv_btn_send);
        this.mqQ.setOnClickListener(this);
        this.mtX = (LinearLayout) this.mwj.findViewById(a.f.head_trumpet);
        this.mtX.setVisibility(8);
        this.mtX.setOnClickListener(this);
        this.mtY = (TextView) this.mwj.findViewById(a.f.tv_primary_name);
        this.mtZ = (TextView) this.mwj.findViewById(a.f.tv_primary_desc);
        this.mub = (TextView) this.mwj.findViewById(a.f.tv_cut_count);
        this.mub.setOnClickListener(this);
        this.mud = (TextView) this.mwj.findViewById(a.f.tv_head_count);
        this.mud.setText(this.mug + "");
        this.muc = (TextView) this.mwj.findViewById(a.f.tv_plus_count);
        this.muc.setOnClickListener(this);
        this.mrq = (TextView) this.mwj.findViewById(a.f.tv_buy_count_coin);
        this.mua = (TextView) this.mwj.findViewById(a.f.tv_buy_head);
        this.mua.setOnClickListener(this);
        this.mue = (ImageView) this.mwj.findViewById(a.f.iv_trumpet_select);
        this.mue.setOnClickListener(this);
        this.muf = (TextView) this.mwj.findViewById(a.f.tv_trumpet_have_count);
        this.muh = false;
        this.mue.setBackgroundResource(a.e.ic_trumpet_n);
        this.muf.setVisibility(8);
        this.mqY = (KPSwitchPanelLinearLayout) this.mwj.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mqY, this.mqZ, this.mtF, new a.InterfaceC0841a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0841a
            public void wb(boolean z) {
                if (c.this.mqZ != null) {
                    if (z) {
                        c.this.mqY.setDirectVisibility(0);
                        c.this.mqZ.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mqZ.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mrc = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wc(boolean z) {
                c.this.mra = z;
                if (z) {
                    c.this.mqZ.setImageResource(a.e.cs_emoji_normal);
                    c.this.dxN();
                    if (c.this.mvo != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mvo.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gt(c.this.mwz);
                        c.this.mvo.setLayoutParams(layoutParams);
                    }
                    if (c.this.mtE != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mtE.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gt(c.this.mwz);
                        c.this.mtE.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mvo != null && c.this.mvo.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mvo.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mvo.setLayoutParams(layoutParams3);
                    c.this.mvo.setVisibility(8);
                }
                if (c.this.muK) {
                    c.this.mxf.setVisibility(0);
                }
                if (c.this.mwz != null && (c.this.mwz instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mwz).wa(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mtE != null && c.this.mqY.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mtE.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mtE.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mrb = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mqY, this.mrc, ((VideoPlayer) this.mwz).dxa());
        ((VideoPlayer) this.mwz).h(((VideoPlayer) this.mwz).dxa());
        this.mvo = this.mwj.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mvl = (TextView) this.mwj.findViewById(a.f.btn_room_search);
        this.mvm = (ImageView) this.mwj.findViewById(a.f.iv_room_emoji_delete);
        this.mvn = (EditText) this.mwj.findViewById(a.f.et_room_emoji_search);
        this.mvn.setImeOptions(3);
        this.mvn.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mvl);
                    return true;
                }
                return false;
            }
        });
        this.mvn.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mvl.setEnabled(editable.length() > 0);
                c.this.mvm.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mxf.setEmojiSearchText(editable.toString());
            }
        });
        this.mvl.setOnClickListener(this);
        this.mvm.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aq(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dC(this.mvn);
            this.mvo.setVisibility(0);
            this.mvn.requestFocus();
        } else {
            this.mvo.setVisibility(8);
        }
        if (z2) {
            this.mvn.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxN() {
        int gt = tv.chushou.zues.widget.kpswitch.b.d.gt(this.mwz) + tv.chushou.zues.utils.a.dip2px(this.mwz, 14.0f);
        if (gt > this.mtc) {
            b(gt, 12);
        }
    }

    private void aS() {
    }

    private void dxR() {
        if (this.muj > 0) {
            View findViewById = this.mwj.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.muj);
        }
        if (this.mui > 0) {
            View findViewById2 = this.mwj.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mui, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.muG) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.mpU = ((VideoPlayer) this.mwz).dwW();
        this.mpU.a(this);
        if (this.mwy.dxv() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mpU != null) {
            this.mpU.d();
        }
    }

    private void dxS() {
        if ((this.mpY == null || this.mpY.msQ == null || !this.mpY.msQ.mInPKMode) ? false : true) {
            if (this.mtd != null) {
                this.mtd.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mqa.getLayoutParams();
            layoutParams.leftMargin = (this.muW.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mwz, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mqa.setLayoutParams(layoutParams);
            this.y.setText(this.mpY.msQ.mPkUserNickname);
            this.mqa.setVisibility(0);
            this.mtu.setVisibility(8);
            return;
        }
        if (this.mtd != null) {
            this.mtd.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mqa.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.mpY != null && this.mpY.msQ != null && this.mpY.msQ.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mvh > 0 && this.muo != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.muo.getLayoutParams();
                if (layoutParams.height != this.mvh) {
                    layoutParams.height = this.mvh;
                    this.muo.setLayoutParams(layoutParams);
                }
            }
            this.mtc = ((int) (tv.chushou.zues.utils.a.gh(this.mwz).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mwz, 84.0f);
            b(this.mtc, 12);
        } else {
            if (this.muo != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.muo.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mwz, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mwz, 250.0f);
                    this.muo.setLayoutParams(layoutParams2);
                }
            }
            this.mtc = ((int) (tv.chushou.zues.utils.a.gh(this.mwz).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mwz, 84.0f);
            b(this.mtc, 12);
        }
        if (this.mpZ != null) {
            this.mpZ.a(this.mvh + tv.chushou.zues.utils.a.dip2px(this.mwz, 52.0f), this.mwD);
        }
        if (this.mqd != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mqd.getLayoutParams();
            layoutParams3.bottomMargin = this.mvh + tv.chushou.zues.utils.a.dip2px(this.mwz, 52.0f);
            this.mqd.setLayoutParams(layoutParams3);
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

    private void dxU() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dyr().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.muW = tv.chushou.zues.utils.a.gi(this.mwz);
        this.muV = 86;
        this.muT = (Math.max(this.muW.x, this.muW.y) - tv.chushou.zues.utils.a.dip2px(this.mwz, (this.muV + 52) + 250)) - this.mui;
        this.muU = Math.max(this.muW.x, this.muW.y) - ((tv.chushou.zues.utils.a.dip2px(this.mwz, this.muV) + this.mui) * 2);
        if (this.muX <= 0 || this.muY <= 0) {
            this.muX = Math.min(this.muW.x, this.muW.y);
            this.muY = Math.max(this.muW.x, this.muW.y);
        }
        this.ar = Math.min(this.muW.x, this.muW.y);
        this.mwD = (this.ar * this.muY) / this.muX;
        boolean z = false;
        if (this.mpY == null || this.mpY.msQ == null) {
            i = 1;
        } else {
            i = this.mpY.msQ.mMode;
            if (this.mpY.msQ.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.muV = 42;
            if (i == 2) {
                if (this.muY < this.muX) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mwD;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mwD;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.muX * layoutParams.height) / this.muY;
                    layoutParams2.height = layoutParams.height;
                    this.mwD = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mwD;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwD;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, this.muV) + this.mui;
            layoutParams.gravity = 48;
            this.mvh = ((this.muW.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mwz, (this.muV + 52) + 64) + this.mui)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            aG();
        } else if (this.E) {
            this.muV = 42;
            if (this.muY < this.muX) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mwD;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwD;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.muX * layoutParams.height) / this.muY;
                layoutParams2.height = layoutParams.height;
                this.mwD = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, this.muV) + this.mui;
            layoutParams.gravity = 48;
            this.mvh = ((this.muW.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mwz, (this.muV + 52) + 98) + this.mui)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            dxU();
        } else {
            this.mvh = -1;
            this.muV = 86;
            if (this.mwD <= this.muT) {
                layoutParams.width = this.ar;
                layoutParams.height = this.muT;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, this.muV) + this.mui;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwD;
            } else if (this.mwD < this.muU) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mwD;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, this.muV) + this.mui;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mwD;
            } else {
                this.mwD = Math.max(this.muW.x, this.muW.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mwD;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mwD * this.muX) / this.muY >= this.ar) {
                        i3 = this.mwD;
                        i2 = (this.mwD * this.muX) / this.muY;
                    } else if ((this.ar * this.muY) / this.muX >= this.mwD) {
                        i2 = this.ar;
                        i3 = (this.ar * this.muY) / this.muX;
                    } else {
                        i2 = this.ar;
                        i3 = this.mwD;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mwD) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.muY) / this.muX > this.mwD) {
                        i3 = this.mwD;
                        i2 = (this.mwD * this.muX) / this.muY;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.muY) / this.muX;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.muY) / this.muX;
                        if (i3 > this.mwD) {
                            i3 = this.mwD;
                            i2 = (this.mwD * this.muX) / this.muY;
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
        if (this.mwy != null && this.mwy.d) {
            layoutParams.width = Math.min(this.muW.x, this.muW.y);
            layoutParams.height = Math.max(this.muW.x, this.muW.y);
        }
        dyr().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void aY() {
        this.N = new SurfaceRenderView(this.mwz);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dyr().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.dx) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dyk();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dyj();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mvK != null) {
            this.mvK.a();
        }
        if (this.mwy != null && !h.isEmpty(this.mwy.mpF)) {
            b(this.mwy.mpF);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.msP != null) {
            int width = this.msP.getWidth();
            int height = this.msP.getHeight();
            if (this.muX != width || this.muY != height || this.muX <= 0 || this.muY <= 0) {
                this.muX = width;
                this.muY = height;
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
            if (this.muK) {
                aD();
            } else {
                if (this.mwz.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwy.dxv().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.muh) {
                f(this.mtF.getText().toString());
            } else {
                a(this.mtF.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dwK().c) {
                com.kascend.chushou.d.h.dwK().b(false);
                this.mtB.cancel();
                this.mtB.reset();
                this.mtC.clearAnimation();
                this.mtD.setVisibility(8);
            }
            l(view, 0, this.mwj.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mwz, 165.0f) / 2);
            k(view, x >= 0 ? x : 0, this.mwj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mwy.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mwy.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.muo != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mup != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.muO = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mwz, (JSONObject) null, this.mwy.dxz().mRoomID, this.mwy.dxz().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mwz.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mwz, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.muQ != null) {
                    com.kascend.chushou.d.e.a(this.mwz, this.muQ, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mvk != null) {
                    this.mvk.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mwz, null) && this.mwy != null && this.mwy.mpG != null) {
                    if (this.muh) {
                        bo();
                    } else {
                        if (this.mwy != null && this.mwy.mpG != null && this.mwy.mpG.count > 0) {
                            this.mtX.setVisibility(8);
                        } else {
                            this.mtX.setVisibility(0);
                        }
                        this.muh = true;
                        this.mue.setBackgroundResource(a.e.ic_trumpet_p);
                        this.muf.setVisibility(0);
                        this.muf.setSelected(true);
                        this.muf.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mtF != null) {
                            this.mtF.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mug <= 9) {
                    this.mug++;
                    this.mud.setText(this.mug + "");
                }
                aH();
            } else if (id == a.f.tv_cut_count) {
                if (this.mug > 1) {
                    this.mug--;
                    this.mud.setText(this.mug + "");
                }
                aH();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mvn.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mvn.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mvo.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dD(this.mvn);
                    this.mxf.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mqb != null && !h.isEmpty(this.mqb.eventUrl)) {
                    f("", this.mqb.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mqb != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mqb != null) {
                    com.kascend.chushou.d.a.a(this.mwz, (JSONObject) null, this.mqb.roomId, this.mqb.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mwy.a(false);
                    ((VideoPlayer) this.mwz).l();
                } else {
                    ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
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
        if (this.mtW != null) {
            int i = (tv.chushou.zues.utils.a.gh(this.mwz).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mtW.getLayoutParams();
            layoutParams.topMargin = i;
            this.mtW.setLayoutParams(layoutParams);
            this.mtW.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mtW.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
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
        } else if (System.currentTimeMillis() - this.muN <= 3000) {
            tv.chushou.zues.utils.g.JO(a.i.str_too_fast);
            return false;
        } else {
            dlz();
            if (!com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a(((VideoPlayer) this.mwz).dwV().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.muN = System.currentTimeMillis();
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                a(this.mwy.dxv().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mwy.h);
            }
            g(this.b);
            if (!z && this.mtF != null) {
                this.mtF.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dlz();
            if (com.kascend.chushou.d.e.c(this.mwz, null) && LoginManager.Instance().getUserInfo() != null && this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                a(this.mwy.dxv().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mtF != null) {
                this.mtF.setText((CharSequence) null);
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
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mwy.dxv().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mwy.dxv().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mwz).mnT;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Qi(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.mwZ != null && this.mwZ.isShowing()) {
            this.mwZ.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
        if (this.mxw == null) {
            i(3);
        }
        this.mxw.getContentView().setBackgroundResource(0);
        this.mxw.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mxw.isShowing()) {
            this.mxw.showAtLocation(view, 83, i, i2);
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mwy.dxv().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mxw.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.mxA)) {
            if (((VideoPlayer) this.mwz).q) {
                this.mxz.xW(a.e.ic_room_set_btn_white);
            } else {
                this.mxz.xW(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mwz).q && this.mxA.size() == 2 && this.mxA.contains("4") && this.mxA.contains("2")) {
            this.mxz.xW(a.e.ic_room_set_btn_system_white);
        } else if (this.mxA.size() > 1 || !((VideoPlayer) this.mwz).q) {
            this.mxz.xW(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mxA.get(0))) {
            this.mxz.xW(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mxA.get(0))) {
            this.mxz.xW(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mxA.get(0))) {
            this.mxz.xW(a.e.ic_room_set_btn_system_white);
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
        if (this.mwZ == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mwZ.getContentView().setBackgroundResource(0);
            this.mwZ.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mwZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mtC.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mwZ.isShowing()) {
            this.mwZ.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mwz, 16.0f) + i2);
            this.mtC.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mwy.dxv().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mwZ.dismiss();
    }

    private void ds(View view) {
        if (this.mwT == null) {
            dxX();
        }
        if (com.kascend.chushou.d.h.dwK().q()) {
            this.mtG.dJI();
        } else {
            this.mtG.dJJ();
        }
        int height = this.mwj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (view != null) {
            this.mwT.showAtLocation(view, 85, 0, height);
        }
    }

    private void dxX() {
        if (this.mwT == null) {
            View inflate = LayoutInflater.from(this.mwz).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mtG = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dwK().q()) {
                this.mtG.dJI();
            } else {
                this.mtG.dJJ();
            }
            this.mtG.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dwK().g(z);
                }
            });
            this.mwN = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mwO = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mwN.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mwN.setVisibility(0);
            } else {
                this.mwN.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dwK().a) {
                this.mwO.b();
            } else {
                this.mwO.c();
            }
            if (this.mwy != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mwy.f;
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
                                if (this.mpY == null || !this.mpY.msQ.mInPKMode || h.isEmpty(this.mpY.b) || this.mup == null || !this.mpY.b.equals(this.mup.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mwz).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dxw = this.mwy.dxw();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mwz).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwz, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, 5.0f);
                                            }
                                            int identifier = this.mwz.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mwz.getPackageName());
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
                                                if (dxw != null && dxw.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mwz.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mwz).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dxw2 = this.mwy.dxw();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mwz).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mwz, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, 5.0f);
                                        }
                                        int identifier2 = this.mwz.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mwz.getPackageName());
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
                                            if (dxw2 != null && dxw2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dxY();
                        c.this.mwT.dismiss();
                    }
                }
            });
            this.mwT = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 150.0f), -2);
            this.mwT.setFocusable(true);
            this.mwT.setOutsideTouchable(true);
            this.mwT.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mwT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mwT = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxY() {
        if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
            if (this.mtV == null) {
                this.mtV = new f(getActivity());
            }
            this.mtV.a(this.mwy.dxv().mRoominfo, this.ax);
            if (!this.mtV.isShowing()) {
                this.mtV.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.dx) {
            return false;
        }
        if (this.muO == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mvI = motionEvent.getX();
                    this.mvJ = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mvI;
                    if (Math.abs(f) > Math.abs(y - this.mvJ) && Math.abs(f) > q && f > 0.0f) {
                        dym();
                        return true;
                    }
                    this.mvI = 0.0f;
                    this.mvJ = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mvo != null && this.mvo.getVisibility() == 0 && b(motionEvent, this.mvo)) {
                this.mvo.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mvn);
                return true;
            } else if (this.muK && this.mvo != null && this.mvo.getVisibility() == 8 && g(this.mxf.b, motionEvent)) {
                aD();
                return true;
            } else if (this.mtW != null && this.mtW.b() && g(this.mtW, motionEvent)) {
                this.mtW.a();
                return true;
            } else if (this.mtM != null && this.mtM.b() && g(this.mtM, motionEvent)) {
                this.mtM.a();
                return true;
            } else if (b(motionEvent, this.mtE)) {
                return dlz();
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
            if (this.mxq != null && this.mxq.a(i, keyEvent)) {
                return true;
            }
            if ((this.mtW != null && this.mtW.onKeyDown(i, keyEvent)) || dxO()) {
                return true;
            }
            if (this.muO == 3) {
                this.muO = 1;
                dym();
                return true;
            } else if (this.mtM != null && this.mtM.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mtF != null && this.mtA != null && this.mtE != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dC(this.mtF);
                this.mtA.setVisibility(8);
                this.mtE.setVisibility(0);
            }
        } else if (this.mtA != null && this.mtE != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
            this.mtA.setVisibility(0);
            this.mtE.setVisibility(8);
        }
    }

    public boolean dlz() {
        boolean z;
        b(this.mtc, 12);
        boolean z2 = false;
        if (this.mqY != null && this.mqY.getVisibility() == 0) {
            this.mqY.setVisibility(8);
            this.mqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mra) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mwz);
            this.mqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mtE == null || this.mtE.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.muh) {
                bo();
            }
            this.mtE.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mtA != null) {
                    c.this.mtA.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dxO() {
        if (dlz()) {
            return true;
        }
        if (this.mwZ != null && this.mwZ.isShowing()) {
            this.mwZ.dismiss();
            return true;
        } else if (this.mxw != null && this.mxw.isShowing()) {
            this.mxw.dismiss();
            return true;
        } else if (this.mwT == null || !this.mwT.isShowing()) {
            return aD() || dxQ() || dxV() || dxP();
        } else {
            this.mwT.dismiss();
            return true;
        }
    }

    public boolean dxP() {
        if (this.mxj == null || !this.mxj.isShown()) {
            return false;
        }
        this.mxj.d();
        return true;
    }

    public boolean dxQ() {
        if (this.muM == null || !this.muM.isShown()) {
            return false;
        }
        this.muM.a();
        return true;
    }

    public boolean dxV() {
        if (this.mtW == null || !this.mtW.b()) {
            return false;
        }
        this.mtW.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mwz != null && !((Activity) this.mwz).isFinishing() && pVar != null) {
            this.mux = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dyq() && this.mup != null && mVar.a(this.mup.mCreatorUID, null)) {
            this.mup.mIsSubscribed = mVar.c;
            aO();
        }
    }

    public boolean aD() {
        if (!this.muK || this.mxf == null) {
            return false;
        }
        if (this.mxf != null) {
            this.mxf.e();
        }
        if (this.mvn != null) {
            this.mvn.setText("");
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
        if (!dyq() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.muS != null) {
                        this.muS.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                        this.mwy.dxv().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mwy.dxv().mMicStatus.onMic) {
                            if (this.mtu != null) {
                                this.mtu.setVisibility(8);
                            }
                            if (this.muM != null && this.muM.isShown()) {
                                this.muM.a();
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
                        if (this.mwy.dxv().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mup != null && !h.isEmpty(this.mup.mCreatorUID)) {
                                g(arrayList2, this.mup.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.mwy.dxv().mMicStatus.onMic) {
                            if (this.mwy.dxv().mMicStatus != null && !h.isEmpty(this.mwy.dxv().mMicStatus.micRoomId) && !this.mwy.dxv().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mwy.dxv().mMicStatus.micRoomId;
                            }
                            this.mwy.dxv().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mwy.dxv().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.mwy.dxv().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mwy.dxv().mMicStatus, str3, z4);
                            if (this.muM != null && this.muM.getVisibility() == 0) {
                                this.muM.a(this.mwy.dxv().mFanItems, this.mwy.dxv().mMicStatus, str3, z4, this.mwy.dxv().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mtu != null) {
                                this.mtu.setVisibility(8);
                            }
                            if (this.muM != null && this.muM.isShown()) {
                                this.muM.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mul != onlineVip.mCount || (this.mtr != null && this.mtr.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mul = onlineVip.mCount;
                        this.mts = onlineVip.mCount;
                        dya();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.muJ.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.muJ.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.muJ.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mve <= 5000) {
                                z2 = false;
                            } else {
                                this.mve = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.muJ.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.muJ.addAll(onlineVip.mOnlineVipItems);
                            }
                            aP();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mvf != null) {
                    if (this.mup == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mup.mCreatorAvatar;
                        str2 = this.mup.mCreatorGender;
                    }
                    this.mvf.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mpY != null && this.mpY.msQ != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mpY.msQ.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mpU != null) {
                                        this.mpU.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mpY.msQ.mInPKMode = true;
                                    this.mpY.msQ.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mpY.msQ.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mpY.msQ.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mpY.msQ.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mpY.msQ.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mpY.msQ.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mpY.msQ.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mpY.msQ.mMode = pkNotifyInfo.mMode;
                                    this.mpY.msQ.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mpZ != null) {
                                        this.mpZ.g(true, this.mpY.msQ.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dwK().a) {
                                        if (!com.kascend.chushou.b.dwD().e) {
                                            com.kascend.chushou.b.dwD().e = true;
                                            tv.chushou.zues.utils.g.F(this.mwz, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dwK().a(this.mwz, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mpY.msQ.mAction = 7;
                                    this.mpY.msQ.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mpY.msQ.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mpY.msQ.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mpY.msQ.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mpY.msQ.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mpY.msQ.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mpY.msQ.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.mpZ != null) {
                                        this.mpZ.g(false, 0L);
                                        this.mpZ.b(this.mpY.msQ, true);
                                        this.mpZ.a(this.mvh + tv.chushou.zues.utils.a.dip2px(this.mwz, 52.0f), this.mwD);
                                        this.mpZ.a(this.mpY.msQ.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mpU != null) {
                                        this.mpU.a(false);
                                    }
                                    this.mpY.msQ.mInPKMode = false;
                                    this.mpY.msQ.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.mpZ != null) {
                                        this.mpZ.c();
                                    }
                                    this.mpY.b = null;
                                    this.mpY.msQ = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mpY.msQ.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mpY.msQ.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mpY.msQ.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mup != null && !h.isEmpty(this.mup.mRoomID) && this.mup.mRoomID.equals(this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mpY.msQ.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mpZ != null) {
                                        this.mpZ.a(this.mpY.msQ, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mpY.msQ.copyUpdate(pkNotifyInfo);
                                    if (this.mpZ != null) {
                                        this.mpZ.a(this.mpY.msQ);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mpY.msQ.copyStop(pkNotifyInfo);
                                        if (this.mpZ != null) {
                                            this.mpZ.A(this.mpY.msQ.mMaxFreeDuration, this.mpY.msQ.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mpY.msQ.copyResult(pkNotifyInfo);
                                    if (!this.muH && this.mpZ != null) {
                                        int i7 = 1;
                                        if (this.mpY.msQ.destinyInfo != null && this.mpY.msQ.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mpZ.a(h.parseInt(this.mpY.msQ.mResult), h.parseLong(this.mpY.msQ.mvpUid), this.mpY.msQ.mvpAvatar, this.mpY.msQ.mvpNickname, this.mpY.msQ.mMaxFreeDuration, this.mpY.msQ.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mqb != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mqb.uid = cycleLiveRoomInfo.uid;
                        this.mqb.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mqb.roomId = cycleLiveRoomInfo.roomId;
                        this.mqb.avatar = cycleLiveRoomInfo.avatar;
                        this.mqb.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.mwz != null && (this.mwz instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mwz).d();
                        }
                    } else {
                        ((VideoPlayer) this.mwz).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mwy != null && this.mwy.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dwK().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dwK().b().equals(next2.mUserID)) {
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

    public void dya() {
        if (this.mtr != null) {
            if (this.mpY == null || this.mpY.msQ == null || !this.mpY.msQ.mInPKMode) {
                if (this.mts > 0) {
                    this.mtr.setVisibility(0);
                    this.mtr.setText(String.format(this.mwz.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mts))));
                    this.mtw.setVisibility(0);
                    return;
                }
                this.mtr.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mtu.setVisibility(0);
            if (this.mtv != null) {
                this.mtv.a(str, z, micStatus, this.mwy.dxv().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mtu.setVisibility(8);
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
        int childCount = this.mur.getChildCount();
        int itemCount = this.mur.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mur);
        if (f + childCount >= itemCount) {
            this.muy = true;
            if (this.muz != null) {
                this.muz.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dye() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mus.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mus.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.mus == null) {
            this.mus = new ArrayList<>();
        }
        while (2 < this.mus.size()) {
            this.mus.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.muu);
        if (a2 == null) {
            w(false);
            return;
        }
        this.mus.addAll(a2);
        int size = this.mus.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mus.size(); i++) {
                this.mus.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.muv == null) {
            this.muv = new ArrayList<>();
        }
        this.muv.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mux != null && this.mux.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mux.contains("2"))) {
                        this.muv.add(next);
                    } else if (!this.mux.contains(next.mType)) {
                        this.muv.add(next);
                    }
                }
                return this.muv;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mus == null) {
                    this.mus = new ArrayList<>(arrayList);
                    dye();
                    w(z2);
                    return;
                }
                if (this.muu == null) {
                    this.muu = new ArrayList<>();
                }
                this.muu.addAll(arrayList);
                int size = this.muu.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.muu.size(); i++) {
                        this.muu.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mus.size();
                if (a2 != null) {
                    this.mus.addAll(a2);
                }
                int size3 = this.mus.size();
                if (!this.muy && this.muz != null) {
                    this.muz.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mus.size(); i3++) {
                        this.mus.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mus == null) {
                this.mus = new ArrayList<>(arrayList);
                dye();
            } else {
                if (this.muu == null) {
                    this.muu = new ArrayList<>();
                }
                this.muu.clear();
                this.muu.addAll(arrayList);
                this.mus.clear();
                dye();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mus.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.muw != null) {
                this.muw.a(this.mus.size());
                if (i == 1) {
                    this.muw.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.muw.notifyItemRangeRemoved(i2, i3);
                    this.muw.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.muw.notifyDataSetChanged();
                }
            }
            if (z || this.muy) {
                this.muy = true;
                if (this.muz != null) {
                    this.muz.setVisibility(8);
                }
                if (z) {
                    this.muo.scrollToPosition(this.mus.size() - 1);
                } else {
                    this.muo.smoothScrollToPosition(this.mus.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.muw != null) {
                this.muw.a(this.mus.size());
                this.muw.notifyDataSetChanged();
            }
            if (z || this.muy) {
                this.muy = true;
                if (this.muz != null) {
                    this.muz.setVisibility(8);
                }
                if (z) {
                    this.muo.scrollToPosition(this.mus.size() - 1);
                } else {
                    this.muo.smoothScrollToPosition(this.mus.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dxg;
        RoomToast roomToast;
        this.p = false;
        if (this.mwy != null && this.mwy.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mwy.f.size()) {
                    break;
                } else if (!"2".equals(this.mwy.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dyi();
            return;
        }
        if (this.mqn != null) {
            this.mqn.setVisibility(0);
        }
        if (this.mth != null) {
            this.mth.setVisibility(0);
        }
        if (this.mwy != null) {
            this.mup = this.mwy.dxz();
            this.muq = this.mwy.dxv();
            if (com.kascend.chushou.b.dwD().c != null && this.muw != null) {
                this.muw.a(com.kascend.chushou.b.dwD().c);
                this.muw.notifyDataSetChanged();
            }
            FullRoomInfo dxv = this.mwy.dxv();
            if (dxv != null) {
                if (!h.isEmpty(dxv.mRoomToastList)) {
                    Iterator<RoomToast> it = dxv.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dwK().j())) {
                    a(roomToast);
                }
            }
            if (this.mup != null) {
                bk();
            }
            if (this.mup != null && !this.mup.mIsSubscribed) {
                RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mup == null || !c.this.mup.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mwy != null && this.mwy.l()) {
                d(true);
            }
        }
        if (this.mup != null && this.muw != null) {
            if (this.mus != null) {
                this.mus.clear();
            } else {
                this.mus = new ArrayList<>();
            }
            this.muw.a(this.mup);
            dye();
            this.muw.a(this.mus.size());
            this.muw.notifyDataSetChanged();
        }
        aM();
        N();
        if (this.mwz != null && (this.mwz instanceof VideoPlayer) && (dxg = ((VideoPlayer) this.mwz).dxg()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dxg.msQ, dxg.b);
        }
        this.mtJ.h(this.mup.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mup.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mtN);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.muk == null) {
            View inflate = LayoutInflater.from(this.mwz).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mrA = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.muk = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mwz, 160.0f), -2);
            this.muk.setFocusable(false);
            this.muk.setOutsideTouchable(false);
            this.muk.setAnimationStyle(a.j.gift_toast_style);
            this.muk.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dwK().c(roomToast.mToastContent);
            if (this.muk == null) {
                bd();
            }
            if (this.mrA != null) {
                this.mrA.setText(roomToast.mToastContent);
            }
            if (!this.muk.isShowing()) {
                if (this.mtN != null) {
                    this.muk.showAtLocation(this.mtN, 85, 0, this.mwj.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.muk != null) {
                                c.this.muk.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.muk.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mva != null) {
            this.mva.setVisibility(z ? 0 : 8);
        }
        this.mvb = true;
        if (this.mwz instanceof VideoPlayer) {
            ((VideoPlayer) this.mwz).p();
        }
    }

    private void dyi() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mwz).s();
        dxP();
        dxQ();
        if (this.mty == null) {
            this.mty = (PlayShowRecommendView) ((ViewStub) this.mwj.findViewById(a.f.view_recommend)).inflate();
        }
        this.mty.setVisibility(0);
        if (this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null && !h.isEmpty(this.mwy.dxv().mRoominfo.mRoomID)) {
            bf();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mxf != null) {
            this.mxf.e();
        }
        if (this.mqn != null) {
            this.mqn.setVisibility(4);
        }
        if (this.mth != null) {
            this.mth.setVisibility(8);
        }
        if (this.mxn != null) {
            this.mxn.dJf();
            this.mxn.setVisibility(8);
        }
        we(false);
        a(false, false);
        if (this.mpU != null) {
            this.mpU.a();
        }
    }

    private void bf() {
        if (this.mty != null && this.mty.getVisibility() == 0) {
            this.mty.a(this.mwy.dxv().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dxT() {
        super.dxT();
        if (this.mwz instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mwz;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mtW != null && this.mtW.b()) {
            this.mtW.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.muL);
        if (this.mwz != null) {
            if (this.muL || "10004".equals(((VideoPlayer) this.mwz).t)) {
                this.muL = true;
                if (this.mwy != null) {
                    this.mwy.f = null;
                    if (this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                        this.mwy.dxv().mRoominfo.mGameId = null;
                    }
                }
                dyi();
                return;
            }
            this.muL = true;
            if (this.mwz != null) {
                ((VideoPlayer) this.mwz).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.muL = false;
        if (this.mqn != null) {
            this.mqn.setVisibility(0);
        }
        if (this.mth != null) {
            this.mth.setVisibility(0);
        }
        if (this.mty != null) {
            this.mty.setVisibility(8);
        }
        if (this.mwt != null) {
            this.mwt.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.muL = false;
        if (this.mqn != null) {
            this.mqn.setVisibility(0);
        }
        if (this.mth != null) {
            this.mth.setVisibility(0);
        }
        if (this.mty != null) {
            this.mty.setVisibility(8);
        }
        if (this.mwt != null) {
            this.mwt.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mty != null) {
            this.mty.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dyq()) {
            if (i()) {
                if (i == 404) {
                    if (this.mwy != null) {
                        this.mwy.f = null;
                        this.mwy.dxv().mRoominfo.mGameId = null;
                    }
                    dyi();
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
        if (this.mwy != null && this.mwy.dxw() != null) {
            a(this.mwy.dxw());
        }
        this.p = false;
        if (this.mwy == null || this.mwy.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mwy.f.size()) {
                if (!"2".equals(this.mwy.f.get(i2).mType)) {
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
    public GiftAnimationLayout dxM() {
        if (this.mwj == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mwj.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mtN != null) {
            int size = iconConfig.configs.size();
            this.mtN.removeAllViews();
            if (this.mtP != null) {
                this.mtP.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mwz).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mtN, false);
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
                            this.mtP.setVisibility(0);
                            this.mtO.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.mtN.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void D() {
        if (this.mwz instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dxb = ((VideoPlayer) this.mwz).dxb();
            if (this.mxq == null) {
                this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxq.setVisibility(0);
            this.mxq.a(2, dxb);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mtR != null && this.mwz != null) {
            this.mtR.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mtR != null && this.mwz != null) {
            this.mtR.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(long j) {
        if (this.mtR != null) {
            this.mtR.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0728a
    public void c(int i) {
        if (this.mtR != null) {
            this.mtR.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void a(int i) {
        if (this.mtQ != null) {
            if (this.mwz != null) {
                this.mtQ.a(((VideoPlayer) this.mwz).dxb(), false);
            }
            this.mtQ.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mwj != null) {
            Point gh = tv.chushou.zues.utils.a.gh(this.mwz);
            int i = gh.x > gh.y ? 1 : 2;
            if (this.mxq == null) {
                this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mxq.setPlayerViewHelper(this.mwy);
            this.mxq.setVisibility(0);
            this.mxq.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mtS != null) {
            this.mtS.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mtS != null) {
            this.mtS.a(bangInfo, str);
        }
        if (this.mqB != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mqB.setText(this.mwz.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mqB.setText(this.mwz.getString(a.i.str_contribute_tittle));
            } else {
                this.mqB.setText(Html.fromHtml(this.mwz.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mtt != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mtt.setText(this.mwz.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mtt.setText(this.mwz.getString(a.i.str_contribute_tittle));
            } else {
                this.mtt.setText(Html.fromHtml(this.mwz.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mtS != null) {
            this.mtS.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mwy != null && !h.isEmpty(this.mwy.mpE)) {
            this.muQ = this.mwy.mpE.get(0);
            if (this.mvi != null) {
                this.mvi.setVisibility(0);
                this.mvi.a(this.muQ.mCover, 0, 0, 0, 1);
                if (this.mvj != null) {
                    if (this.muQ.mShowClose) {
                        this.mvj.setVisibility(0);
                    } else {
                        this.mvj.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mtS != null) {
            this.mtS.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mwj != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mqY != null) {
            this.mqY.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dyq() && !this.muH) {
            if (iVar.a == 52) {
                if (this.muw != null) {
                    this.muw.a(com.kascend.chushou.b.dwD().c);
                    this.muw.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.muH && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dyq()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mtF != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mtF);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dyq() && !this.muH) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mwz, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dxc = ((VideoPlayer) this.mwz).dxc();
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(2, dxc);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dxd = ((VideoPlayer) this.mwz).dxd();
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(2, dxd);
            } else if (bVar.a == 8) {
                if (this.muS != null && this.muS.getVisibility() != 0) {
                    this.muS.a(a.C0715a.slide_in_bottom_danmu_anim, a.C0715a.slide_out_bottom_danmu_anim, this.mup == null ? "" : this.mup.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mxq == null) {
                    this.mxq = (H5Container) ((ViewStub) this.mwj.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mxq.setVisibility(0);
                this.mxq.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dyq() && this.mwy != null && !h.isEmpty(this.mwy.a) && this.mwy.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.muS != null && this.muS.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mwz, 80.0f);
                }
                if (this.muR != null && this.muR.getVisibility() == 0) {
                    r0 = Math.max(r0, this.muR.getHeight());
                }
                this.mvd.setTranslationY(-r0);
                return;
            }
            if (this.mvc != null) {
                this.mvc.cancel();
                this.mvc = null;
            }
            int translationY = (int) this.mvd.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mwz, 80.0f) : 0;
                    if (this.muR != null && this.muR.getVisibility() == 0) {
                        r0 = Math.max(r0, this.muR.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.muR.getHeight() : 0;
                    if (this.muS != null && this.muS.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mwz, 80.0f));
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
        this.mvc = ValueAnimator.ofInt(i, i2);
        this.mvc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dyq() && c.this.mtS != null) {
                    c.this.mvd.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mvc.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mvc = null;
            }
        });
        this.mvc.setInterpolator(new LinearInterpolator());
        this.mvc.setDuration(800L);
        this.mvc.start();
    }

    private boolean dyj() {
        if (this.muO == 1) {
            this.muO = 2;
            x(true);
            return true;
        } else if (this.muO == 3) {
            dym();
            return true;
        } else {
            return false;
        }
    }

    private boolean dyk() {
        if (this.muO == 1) {
            return dyl();
        }
        if (this.muO == 2) {
            this.muO = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean dyl() {
        if (this.dx || this.mwy == null || this.mwy.dxz() == null) {
            return false;
        }
        if (this.mvK != null) {
            this.mvK.a(true);
        }
        this.muO = 3;
        this.dx = true;
        bk();
        this.mte.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.dx = false;
                c.this.mtg.setVisibility(8);
            }
        });
        this.mtg.startAnimation(loadAnimation);
        this.mte.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dym() {
        if (!this.dx) {
            if (this.mvK != null) {
                this.mvK.a(false);
            }
            this.muO = 1;
            this.dx = true;
            bk();
            this.mtg.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.dx = false;
                    c.this.mte.setVisibility(8);
                }
            });
            this.mtg.startAnimation(loadAnimation);
            this.mte.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.mwj != null) {
            if (this.mte == null) {
                this.mte = this.mwj.findViewById(a.f.user_space_container);
            }
            if (this.mtg == null) {
                this.mtg = this.mwj.findViewById(a.f.video_container);
            }
            if (this.mtf == null) {
                this.mtf = com.kascend.chushou.view.user.b.b(null, this.mwy.a, false, this.mwy.h);
                this.mtf.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dym();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dym();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mtf).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.mth != null) {
            this.mth.setVisibility(z ? 8 : 0);
        }
        if (this.mum != null) {
            this.dx = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mum.setVisibility(8);
                        c.this.dx = false;
                    }
                });
            } else {
                this.dx = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mum.setVisibility(0);
                        c.this.dx = false;
                    }
                });
            }
            this.mum.startAnimation(loadAnimation);
        }
        dxO();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mtz.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mtH != null) {
                this.mtH.setVisibility(0);
            }
            if (this.mtI != null) {
                this.mtI.a();
                return;
            }
            return;
        }
        if (this.mtK != null) {
            this.mtK.setVisibility(0);
        }
        if (this.mtL != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mtL.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mtK != null) {
            this.mtK.setVisibility(8);
        }
        if (this.mtL != null) {
            this.mtL.clearAnimation();
        }
        if (this.mtH != null) {
            this.mtH.setVisibility(8);
        }
        if (this.mtI != null) {
            this.mtI.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mum != null && this.mwj != null) {
            if (this.muS == null) {
                this.muS = new com.kascend.chushou.player.ui.miniview.a(this.mwz, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.muS != null && c.this.mwj != null && c.this.muS.a()) {
                            ((ViewGroup) c.this.mwj).removeView(c.this.muS);
                            c.this.muS = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.muS.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mwz, 52.0f);
                this.muS.setLayoutParams(layoutParams);
                ((ViewGroup) this.mum).addView(this.muS, ((ViewGroup) this.mum).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.muS.setVisibility(8);
                } else {
                    this.muS.a(a.C0715a.slide_in_bottom_danmu_anim, a.C0715a.slide_out_bottom_danmu_anim, this.mwy.a == null ? "" : this.mwy.a);
                }
            } else if (!this.muS.isShown()) {
                this.muS.a(a.C0715a.slide_in_bottom_danmu_anim, a.C0715a.slide_out_bottom_danmu_anim, this.mwy.a == null ? "" : this.mwy.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.muZ != null && !h.isEmpty(listItem.mPackIcon)) {
                this.muZ.setVisibility(0);
                this.muZ.setAnim(true);
                this.muZ.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.ntX, b.C0840b.ntZ, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.muA != null && this.muA.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dyn();
                    }
                });
                this.muA.setVisibility(0);
                this.muA.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.muA != null && this.muA.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.muC != null) {
                        c.this.muC.removeAllListeners();
                        c.this.muC.cancel();
                        c.this.muC = null;
                    }
                    if (c.this.muA != null) {
                        c.this.muA.setVisibility(8);
                    }
                }
            });
            this.muA.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mvg == null) {
                this.mvg = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dyq()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mwz, "显示双击666_num", null, new Object[0]);
                            if (c.this.mwy != null) {
                                c.this.mwy.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.mwA != null) {
                    this.mwA.e(this.mvg, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mvg != null) {
            this.mwA.N(this.mvg);
            this.mvg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.muD != null && this.muD.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mwz, a.C0715a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dyo();
                    }
                });
                this.muD.setVisibility(0);
                this.muD.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mwi, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.muD != null && this.muD.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mwz, a.C0715a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.muF != null) {
                        c.this.muF.removeAllListeners();
                        c.this.muF.cancel();
                        c.this.muF = null;
                    }
                    if (c.this.muD != null) {
                        c.this.muD.setVisibility(8);
                    }
                }
            });
            this.muD.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dyn() {
        if (this.muA == null || this.muB == null) {
            return null;
        }
        if (this.muC != null) {
            this.muC.removeAllListeners();
            this.muC.cancel();
            this.muC = null;
        }
        this.muB.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.muB, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.muB, 0.0f);
        int measuredWidth = (this.muA.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mwz, 13.0f) * 2)) - this.muB.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.muB, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.muB, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.muB, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.muC != null) {
                    c.this.muC.removeAllListeners();
                    c.this.muC.cancel();
                    c.this.muC = null;
                }
                RxExecutor.postDelayed(c.this.mwi, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dyn();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.muC = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dyo() {
        if (this.muD == null || this.muE == null) {
            return null;
        }
        if (this.muF != null) {
            this.muF.removeAllListeners();
            this.muF.cancel();
            this.muF = null;
        }
        this.muE.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.muE, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.muE, 0.0f);
        int measuredWidth = (this.muD.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mwz, 13.0f) * 2)) - this.muE.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.muE, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.muE, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.muE, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.muF != null) {
                    c.this.muF.removeAllListeners();
                    c.this.muF.cancel();
                    c.this.muF = null;
                }
                RxExecutor.postDelayed(c.this.mwi, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dyo();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.muF = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mvK = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mqb != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mqb.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dyq()) {
                        ParserRet dy = com.kascend.chushou.c.a.dy(jSONObject);
                        if (dy.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.JO(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.JO(a.i.subscribe_success);
                            }
                            if (c.this.mqb != null) {
                                c.this.mqb.isSubscribe = !z;
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
                    if (!c.this.dyq()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.t(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dwG().a(bVar, (String) null, this.mqb.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mqb.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dwG().b(bVar, (String) null, c.this.mqb.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mwy != null && this.mup != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mwy.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mwy.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mup.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dyq()) {
                        ParserRet dy = com.kascend.chushou.c.a.dy(jSONObject);
                        if (dy.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.JO(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.JO(a.i.subscribe_success);
                            }
                            c.this.mup.mIsSubscribed = !z;
                            c.this.aO();
                            return;
                        }
                        a(dy.mRc, dy.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dyq()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.t(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dwG().a(bVar, (String) null, this.mup.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mup.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dwG().b(bVar, (String) null, c.this.mup.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.msP != null) {
            int width = this.msP.getWidth();
            int height = this.msP.getHeight();
            if (this.muX != width || this.muY != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mwz).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mwj != null) {
            if (this.mtM == null) {
                this.mtM = (InteractionView) ((ViewStub) this.mwj.findViewById(a.f.view_interaction)).inflate();
                this.mtM.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mtM.a();
                    }
                });
            }
            if (this.mtM != null) {
                this.mtM.b(configDetail);
                this.mtM.c();
                this.mtM.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dJS()) {
                tv.chushou.zues.utils.g.F(this.mwz, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mwz, null) && (this.mwz instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwy != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwz, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mwz, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mwy != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mwz, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mwz, configDetail.mUrl, this.mwz.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mwz, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    if (this.muK) {
                        aD();
                        return;
                    }
                    if (this.mwz.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mwz, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mwy != null && this.mwy.dxv() != null && this.mwy.dxv().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mwy.dxv().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    ds(this.mtN);
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
        if (this.mwz != null && !this.v && !h.isEmpty(str) && this.mup != null && str.equals(this.mup.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mpY == null) {
                this.mpY = new com.kascend.chushou.player.e.a();
            }
            this.mpY.b = str;
            this.mpY.msQ.copy(pkNotifyInfo);
            if (this.mpY.msQ.mAction == 6) {
                if (this.mpU != null) {
                    this.mpU.a(true);
                }
                this.mpY.msQ.mInPKMode = true;
                this.u = this.mpY.msQ.mPkId;
            } else if (this.mpY.msQ.mAction == 7 || (this.mpY.msQ.mMode == 1 && this.mpY.msQ.mAction == 5)) {
                if (this.mpU != null) {
                    this.mpU.a(true);
                }
                this.mpY.msQ.mInPKMode = true;
                if (this.muV != 42) {
                    this.mvh = ((this.muW.y - ((this.muW.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mwz, 158.0f) + this.mui)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
                    aX();
                }
                this.u = this.mpY.msQ.mPkId;
                if (this.mpZ != null) {
                    this.mpZ.b(this.mpY.msQ, false);
                    this.mpZ.a(this.mpY.msQ.mMode, (String) null);
                    if (this.mpY.msQ.mAction == 5 && this.mpY.msQ.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mpY.msQ.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mpY.msQ.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mpY.msQ.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mpY.msQ.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mpY.msQ.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mpZ.a(this.mpY.msQ);
                        this.mpZ.a(parseInt, this.mpY.msQ.mPkUpdateInfo.remainDuration, j, this.mpY.msQ.mMode, (this.mpY.msQ.destinyInfo == null || this.mpY.msQ.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mpY.msQ.mPkUpdateInfo != null && !h.isEmpty(this.mpY.msQ.mPkUpdateInfo.specialMomentList) && this.mpZ != null) {
                    this.mpZ.a(this.mpY.msQ, true);
                }
                if (this.mpY.msQ.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.mpY.msQ.mInPKMode = false;
                if (this.mpY.msQ.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        aV();
        dxS();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.muf != null && this.mwy != null && this.mwy.mpG != null) {
            this.muf.setText(tv.chushou.zues.utils.b.JN(this.mwy.mpG.count));
            this.muf.setVisibility(0);
            if (this.mwy.mpG.count < 1) {
                bo();
            }
            if (this.mtY != null) {
                this.mtY.setText(this.mwy.mpG.primaryName);
            }
            if (this.mtZ != null) {
                this.mtZ.setText(this.mwy.mpG.desc);
            }
            aH();
        }
    }

    public void aH() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mug * h.parseLong(this.mwy.mpG.point)));
        if (this.mrq != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mwz.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mwz, a.e.icon_coin_new);
            cVar.append(this.mwz.getString(a.i.str_buy_count_coin2));
            this.mrq.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.mwz, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mug);
        }
    }

    private void bo() {
        this.muh = false;
        this.mue.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mwy != null && this.mwy.mpG != null) {
            if (this.mwy.mpG.count < 1) {
                this.muf.setVisibility(8);
            } else {
                this.muf.setVisibility(0);
                this.muf.setSelected(false);
                this.muf.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mtX.setVisibility(8);
        if (this.mtF != null) {
            this.mtF.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mqd != null) {
            if (z) {
                this.mqd.setVisibility(0);
            } else {
                this.mqd.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mvH != null) {
            this.mvH.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mtO != null) {
            this.mtO.performClick();
        }
    }
}
