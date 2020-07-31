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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
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
    private int dC;
    private int dD;
    private TextView nqB;
    private ImageView nqH;
    private TextView nqQ;
    private KPSwitchPanelLinearLayout nqY;
    private ImageView nqZ;
    private View nqn;
    public String nqu;
    private TextView nqy;
    private TextView nrD;
    private View nrG;
    private tv.chushou.zues.widget.kpswitch.b.c nrb;
    private d.a nrc;
    private TextView nrs;
    private TextView nsD;
    private RelativeLayout ntA;
    private AnimationSet ntB;
    private ImageView ntC;
    private ImageView ntD;
    private RelativeLayout ntE;
    private PastedEditText ntF;
    private ToggleButton ntG;
    private RelativeLayout ntH;
    private PaoPaoView ntI;
    private FrescoThumbnailView ntJ;
    private LinearLayout ntK;
    private ImageView ntL;
    private InteractionView ntM;
    private LinearLayout ntN;
    private FrescoThumbnailView ntO;
    private FrameLayout ntP;
    private RedpacketNotifier ntQ;
    private InteractNotifier ntR;
    private EmbeddedButtonLayout ntS;
    private GiftAnimationLayout ntT;
    private com.kascend.chushou.player.b.a ntU;
    private f ntV;
    private PlayShowH5View ntW;
    private LinearLayout ntX;
    private TextView ntY;
    private TextView ntZ;
    private int ntd;
    private View nte;
    private View ntf;
    private com.kascend.chushou.view.user.b ntg;
    private View nth;
    private FrameLayout nti;
    private LinearLayout ntj;
    private RelativeLayout ntk;
    private FrescoThumbnailView ntl;
    private TextView ntm;
    private TextView ntn;
    private TextView nto;
    private FrescoThumbnailView ntp;
    private TextView ntq;
    private TextView ntr;
    private TextView nts;
    private TextView ntt;
    private LinearLayout ntu;
    private PlayShowMicStatusView ntv;
    private RecyclerView ntw;
    private ImageView ntx;
    private PlayShowRecommendView nty;
    private View ntz;
    private View nuA;
    private Animator nuB;
    private View nuC;
    private View nuD;
    private Animator nuE;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nuH;
    private PlayShowMicPerson nuL;
    private FoodView nuP;
    public ListItem nuQ;
    private FoodView nuR;
    private com.kascend.chushou.player.ui.miniview.a nuS;
    private int nuT;
    private Point nuU;
    private FrescoThumbnailView nuX;
    private FrescoThumbnailView nuY;
    private ValueAnimator nuZ;
    private TextView nua;
    private TextView nub;
    private TextView nuc;
    private TextView nud;
    private ImageView nue;
    private TextView nuf;
    private PopupWindow nui;
    private View nuk;
    private RecyclerView nun;
    private RoomInfo nuo;
    private RecyclerView.LayoutManager nuq;
    private ArrayList<ChatInfo> nur;
    private ArrayList<ChatInfo> nus;
    private ArrayList<ChatInfo> nut;
    private ArrayList<ChatInfo> nuu;
    private Button nuy;
    private View nuz;
    private TextView nvA;
    private ImageView nvB;
    private RelativeLayout nvC;
    private TextView nvE;
    private float nvF;
    private float nvG;
    private a nvH;
    private LinearLayout nva;
    private long nvb;
    private VideoShowVoteView nvc;
    private Runnable nvd;
    private FrescoThumbnailView nvf;
    private ImageView nvg;
    private RelativeLayout nvh;
    private TextView nvi;
    private ImageView nvj;
    private EditText nvk;
    private View nvl;
    private RelativeLayout nvm;
    private RelativeLayout nvn;
    private FrescoThumbnailView nvo;
    private TextView nvp;
    private TextView nvq;
    private ImageView nvr;
    private RelativeLayout nvs;
    private LinearLayout nvt;
    private TextView nvu;
    private TextView nvv;
    private RelativeLayout nvw;
    private RelativeLayout nvx;
    private FrescoThumbnailView nvy;
    private TextView nvz;
    private boolean nra = false;
    private int nug = 1;
    private boolean cO = false;
    private int nuh = 0;
    private int cQ = 0;
    private int nuj = -1;
    private boolean nul = false;
    private FullRoomInfo nup = null;
    private com.kascend.chushou.player.adapter.a nuv = null;
    private ArrayList<String> nuw = null;
    private boolean nux = true;
    private boolean nuF = true;
    private boolean nuG = false;
    public final List<OnlineVipItem> nuI = new ArrayList();
    private boolean nuJ = false;
    private boolean nuK = false;
    private long nuM = 0;
    private int nuN = 1;
    private boolean nuO = false;
    private int nuV = -1;
    private int nuW = -1;
    private boolean dJ = false;
    private int nve = -1;
    private io.reactivex.disposables.b nvD = null;

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
        this.nqu = getArguments().getString("cover");
        this.nuF = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.nwg = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.nwg;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            aK();
            this.nsQ = ((VideoPlayer) this.nwv).dMx();
            this.nwu = ((VideoPlayer) this.nwv).dMA();
            dz(view);
            dNA();
            if (this.nwv instanceof VideoPlayer) {
                ((VideoPlayer) this.nwv).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nuG = false;
        if (this.nwZ != null) {
            this.nwZ.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nuG = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nuB != null) {
            this.nuB.removeAllListeners();
            this.nuB.cancel();
            this.nuB = null;
        }
        if (this.nuE != null) {
            this.nuE.removeAllListeners();
            this.nuE.cancel();
            this.nuE = null;
        }
        if (this.ntR != null) {
            this.ntR.c();
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
        if (this.nvD != null) {
            this.nvD.dispose();
            this.nvD = null;
        }
        this.nug = 1;
        this.cO = false;
        if (this.nww != null) {
            this.nww.ch(null);
        }
        if (this.nui != null) {
            this.nui.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nwv, this.nrb);
        if (this.nwv != null && (this.nwv instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwv).dME();
        }
        this.nrc = null;
        this.nrb = null;
        aI();
        if (this.ntU != null) {
            this.ntU.a();
        }
        if (this.ntI != null) {
            this.ntI.b();
            this.ntI.c();
            this.ntI = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.ci(this);
        if (this.nut != null) {
            this.nut.clear();
        }
        if (this.nur != null) {
            this.nur.clear();
        }
        if (this.nuu != null) {
            this.nuu.clear();
        }
        if (this.nus != null) {
            this.nus.clear();
        }
        if (this.nuw != null) {
            this.nuw.clear();
        }
        if (this.nuv != null) {
            this.nuv.a(0);
            this.nuv.a();
        }
    }

    private void dz(View view) {
        this.nte = view.findViewById(a.f.fl_root);
        this.nuU = tv.chushou.zues.utils.a.gF(this.nwv);
        this.nuh = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwv);
        this.cQ = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        this.dD = 86;
        this.nwu = ((VideoPlayer) this.nwv).dMA();
        if (this.nwu != null) {
            this.nuo = this.nwu.dNd();
            this.nup = this.nwu.dNa();
        }
        this.nur = new ArrayList<>();
        this.nut = new ArrayList<>();
        this.nus = new ArrayList<>();
        this.nti = (FrameLayout) this.nwg.findViewById(a.f.fl_effect);
        b();
        this.nwp = (PlayerErrorView) this.nwg.findViewById(a.f.view_net_error_msg);
        this.nwp.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.ntH = (RelativeLayout) this.nwg.findViewById(a.f.rl_audio_ani);
        this.ntI = (PaoPaoView) this.nwg.findViewById(a.f.audio_ani);
        this.ntJ = (FrescoThumbnailView) this.nwg.findViewById(a.f.audio_ani_avatar);
        this.ntK = (LinearLayout) this.nwg.findViewById(a.f.ll_audio);
        this.nsD = (TextView) this.nwg.findViewById(a.f.tv_open_video);
        this.ntL = (ImageView) this.nwg.findViewById(a.f.iv_audio_ani);
        this.nuY = (FrescoThumbnailView) this.nwg.findViewById(a.f.live_cover);
        if (!this.dJ || this.nsQ == null || this.nsQ.getPlayState() != 4) {
            this.nuY.setVisibility(0);
            this.nuY.setBlur(true);
            this.nuY.i(this.nqu, 0, 0, 0);
        }
        this.nsD.setOnClickListener(this);
        this.npY = new b();
        this.npY.a(view, null, this.nwv, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dZJ()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.nwu != null) {
                    append.append(c.this.nwu.dNd().mRoomID);
                }
                if (c.this.npX != null && c.this.npX.nsR != null) {
                    append.append("&mode=").append(c.this.npX.nsR.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nwv, append.toString());
            }
        });
        this.nqc = (VoiceInteractionView) this.nwg.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.nwu != null) {
            this.nuo = this.nwu.dNd();
            this.nup = this.nwu.dNa();
        }
        dNq();
        dNp();
        dNu();
        this.nva = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nuP = (FoodView) view.findViewById(a.f.rav_ad);
        this.nvf = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nvg = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nvf.setOnClickListener(this);
        this.nvg.setOnClickListener(this);
        this.nvh = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nuX = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nuX.setOnClickListener(this);
        this.ntR = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.ntQ = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nuy = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nuy.setOnClickListener(this);
        this.nun = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nun.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nun.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nuU.x, this.nuU.y) * 0.83d);
        this.nun.setLayoutParams(layoutParams);
        this.nuq = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nwv);
        this.nun.setLayoutManager(this.nuq);
        this.nun.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nun.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nun.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.nux = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nuv = new com.kascend.chushou.player.adapter.a(this.nwv, this.nur);
        if (this.nuo != null) {
            this.nuv.a(this.nuo);
        }
        if (com.kascend.chushou.b.dMh().c != null) {
            this.nuv.a(com.kascend.chushou.b.dMh().c);
        }
        this.nun.setAdapter(this.nuv);
        this.nuv.a(this.nur.size());
        this.nuv.notifyDataSetChanged();
        if (this.nwu != null && (c = this.nwu.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.ntU != null) {
            this.ntU.a();
            this.ntU = null;
        }
        this.ntT = (GiftAnimationLayout) this.nwg.findViewById(a.f.ll_gift_animation);
        this.ntT.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.ntd = ((int) (tv.chushou.zues.utils.a.gE(this.nwv).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nwv, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ntT.getLayoutParams();
        layoutParams2.bottomMargin = this.ntd;
        this.ntT.setLayoutParams(layoutParams2);
        if (this.nwu != null) {
            this.ntU = new com.kascend.chushou.player.b.a(this.nwv.getApplicationContext(), this.ntT);
            this.ntU.a(this.nwu);
            a(this.nwu.npD, this.nwu.npG);
        }
        this.nwg.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.ntS = (EmbeddedButtonLayout) this.nwg.findViewById(a.f.embedded_button_layout);
        this.ntS.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nvc = (VideoShowVoteView) this.nwg.findViewById(a.f.view_video_show_vote);
        this.nvc.setOnClickListener(this);
        this.nvc.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dNH();
            }
        });
        if (this.nwu != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
            this.ntS.a(videoPlayer.dMK().dOe());
            this.ntS.b(this.nwu.dNc());
            this.ntQ.a(videoPlayer.dMG(), false);
            this.ntR.a(videoPlayer.dMH(), videoPlayer.dMI(), videoPlayer.dMJ());
            this.npX = new com.kascend.chushou.player.e.a();
        }
        this.nxj = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nuJ = false;
                c.this.b(c.this.ntd, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nuJ = true;
                if (c.this.nwZ != null) {
                    c.this.nwZ.measure(0, 0);
                    int measuredHeight = c.this.nwZ.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nwv, 14.0f);
                    if (measuredHeight > c.this.ntd) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.nxd = (PaoGuideView) this.nwg.findViewById(a.f.rlPaoGuideView);
        this.nuL = (PlayShowMicPerson) this.nwg.findViewById(a.f.rl_mic_person_view);
        this.ntW = (PlayShowH5View) this.nwg.findViewById(a.f.rl_playshowh5);
        this.nuR = (FoodView) this.nwg.findViewById(a.f.bottom_ad);
        if (this.nwu != null) {
            H();
            if (this.nwu.npx != null && !h.isEmpty(this.nwu.npx.mUrl)) {
                b(this.nwu.npx);
            }
        }
        this.nuz = this.nwg.findViewById(a.f.view_reminder_subscribe);
        this.nuA = this.nuz.findViewById(a.f.spash_subscribe);
        ((TextView) this.nuz.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.nwv, a.e.videoplayer_reminder_subscribe).append(" ").append(this.nwv.getString(a.i.videoplayer_reminder_subscribe)));
        this.nuz.setOnClickListener(this);
        this.nuC = this.nwg.findViewById(a.f.view_reminder_danmaku);
        this.nuD = this.nuC.findViewById(a.f.spash_danmaku);
        ((TextView) this.nuC.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.nwv, a.e.videoplayer_reminder_danmaku).append(" ").append(this.nwv.getString(a.i.videoplayer_reminder_danmaku)));
        this.nuC.setOnClickListener(this);
    }

    private void dNp() {
        this.nvm = (RelativeLayout) this.nwg.findViewById(a.f.rl_cyclelive);
        this.nvn = (RelativeLayout) this.nwg.findViewById(a.f.rlrl_cyclelive);
        this.nvo = (FrescoThumbnailView) this.nwg.findViewById(a.f.iv_liveicon);
        this.nvp = (TextView) this.nwg.findViewById(a.f.tv_livename);
        this.nvq = (TextView) this.nwg.findViewById(a.f.tv_livedesc);
        this.nvr = (ImageView) this.nwg.findViewById(a.f.iv_cyclelive_name_menu);
        this.nvs = (RelativeLayout) this.nwg.findViewById(a.f.rl_normal);
        this.nvt = (LinearLayout) this.nwg.findViewById(a.f.ll_cyclelive_nickname);
        this.nvu = (TextView) this.nwg.findViewById(a.f.tv_cyclelive_nickname);
        this.nvv = (TextView) this.nwg.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nvw = (RelativeLayout) this.nwg.findViewById(a.f.rl_clear_cyclelive);
        this.nvx = (RelativeLayout) this.nwg.findViewById(a.f.rlrl_clear_cyclelive);
        this.nvy = (FrescoThumbnailView) this.nwg.findViewById(a.f.iv_clear_liveicon);
        this.nvz = (TextView) this.nwg.findViewById(a.f.tv_clear_livename);
        this.nvA = (TextView) this.nwg.findViewById(a.f.tv_clear_livedesc);
        this.nvB = (ImageView) this.nwg.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nvC = (RelativeLayout) this.nwg.findViewById(a.f.rl_clear_normal);
        this.nvB.setOnClickListener(this);
        this.nvr.setOnClickListener(this);
        this.nvv.setOnClickListener(this);
        this.nvu.setOnClickListener(this);
        this.nvo.setOnClickListener(this);
        this.nvy.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nwu.npv != null && this.nuR != null) {
            this.nuR.a(true, this.nwu.a == null ? "" : this.nwu.a);
            this.nuR.a(this.nwu.npv, a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nwu != null && this.nwu.npC != null && this.ntS != null) {
            this.nuP.a(this.nwu.npC, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.nwu != null) {
                        c.this.nwu.npC = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dNI() {
        return this.ntU;
    }

    private void aK() {
        this.nww = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.nwg != null && (textView = (TextView) c.this.nwg.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nwv.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nww.B(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nww);
                        break;
                    case 12:
                        c.this.b(c.this.nww);
                        break;
                    case 17:
                        c.this.as();
                        break;
                    case 18:
                        c.this.dAO();
                        break;
                    case 19:
                        c.this.nwt.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nul) {
            this.nul = true;
            if (this.nuk == null) {
                this.nuk = this.nwg.findViewById(a.f.vs_async_show_content);
                this.nuk = ((ViewStub) this.nuk).inflate();
            }
            this.nqn = this.nwg.findViewById(a.f.ui_content);
            if (this.nrG == null) {
                this.nrG = this.nwg.findViewById(a.f.vs_async_notification_view);
                this.nrG = ((ViewStub) this.nrG).inflate();
            }
            c(this.nwg);
            k();
            ar();
            if (this.c == null) {
                this.npR = new d.a();
                this.c = new GestureDetector(this.nwv, this.npR);
            }
            ((VideoPlayer) this.nwv).q();
        }
    }

    private void dNq() {
        this.ntj = (LinearLayout) this.nwg.findViewById(a.f.ll_anchor);
        this.ntk = (RelativeLayout) this.nwg.findViewById(a.f.ll_clear_anchor);
        this.ntj.setVisibility(4);
        this.ntk.setVisibility(4);
        this.ntl = (FrescoThumbnailView) this.nwg.findViewById(a.f.iv_clear_avatar);
        this.ntm = (TextView) this.nwg.findViewById(a.f.tv_clear_nickname);
        this.ntn = (TextView) this.nwg.findViewById(a.f.tv_clear_online_count);
        this.nto = (TextView) this.nwg.findViewById(a.f.tv_clear_btn_subscribe);
        this.nto.setOnClickListener(this);
        this.ntp = (FrescoThumbnailView) this.nwg.findViewById(a.f.iv_avatar);
        this.ntq = (TextView) this.nwg.findViewById(a.f.tv_nickname_test);
        this.ntr = (TextView) this.nwg.findViewById(a.f.tv_online_count);
        this.nqy = (TextView) this.nwg.findViewById(a.f.tv_btn_subscribe);
        this.nqy.setOnClickListener(this);
        this.nts = (TextView) this.nwg.findViewById(a.f.tv_loyal_counts);
        this.nqB = (TextView) this.nwg.findViewById(a.f.tv_btn_contribution);
        this.ntt = (TextView) this.nwg.findViewById(a.f.tv_btn_contribution_forpk);
        this.nqB.setVisibility(4);
        this.ntt.setVisibility(8);
        this.ntu = (LinearLayout) this.nwg.findViewById(a.f.ll_mic);
        this.ntv = (PlayShowMicStatusView) this.nwg.findViewById(a.f.show_mic_status);
        this.ntw = (RecyclerView) this.nwg.findViewById(a.f.rv_loyal);
        this.ntx = (ImageView) this.nwg.findViewById(a.f.iv_clear_close);
        this.nqH = (ImageView) this.nwg.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.ntw.setLayoutManager(linearLayoutManager);
        this.nuH = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.nuI, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void C(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.nuI.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nwv, (JSONObject) null, c.this.nwu.dNd().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0956a view$OnLongClickListenerC0956a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0956a.oK(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0956a.oK(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0956a.oK(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dZV(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nwv, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwv, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwv, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwv, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwv, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.bQ(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.ntw.setAdapter(this.nuH);
        this.ntu.setOnClickListener(this);
        this.ntl.setOnClickListener(this);
        this.ntx.setOnClickListener(this);
        this.ntp.setOnClickListener(this);
        this.ntl.setOnClickListener(this);
        this.nqH.setOnClickListener(this);
        this.nts.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String str = tv.chushou.common.a.dZJ() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.nwu != null) {
                    str = str + c.this.nwu.dNd().mRoomID;
                }
                c.this.f(c.this.nwv.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nqB.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String str = tv.chushou.common.a.dZJ() + "m/room-billboard/";
                if (c.this.nwu != null) {
                    str = str + c.this.nwu.dNd().mRoomID;
                }
                c.this.f(c.this.nwv.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.ntt.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String str = tv.chushou.common.a.dZJ() + "m/room-billboard/";
                if (c.this.nwu != null) {
                    str = str + c.this.nwu.dNd().mRoomID;
                }
                c.this.f(c.this.nwv.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nup == null || this.nup.cycleLiveRoomInfo == null || h.isEmpty(this.nup.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nqa = this.nup.cycleLiveRoomInfo;
        }
        if (z2 && this.nqa != null) {
            this.nvm.setVisibility(0);
            this.nvw.setVisibility(0);
            this.nvs.setVisibility(8);
            this.nvC.setVisibility(8);
            this.nvt.setVisibility(0);
            this.nvy.h(this.nqa.eventIcon, com.kascend.chushou.view.a.a(this.nuo.mCreatorGender), b.a.small, b.a.small);
            this.nvo.h(this.nqa.eventIcon, com.kascend.chushou.view.a.a(this.nuo.mCreatorGender), b.a.small, b.a.small);
            this.nvz.setText(this.nqa.eventName);
            this.nvA.setText(this.nqa.eventDesc);
            this.nvp.setText(this.nqa.eventName);
            this.nvq.setText(this.nqa.eventDesc);
            this.nvu.setText(this.nqa.nickname);
            aN();
            if (z) {
                c(this.nqa.remainTime);
                return;
            }
            return;
        }
        this.nvm.setVisibility(8);
        this.nvw.setVisibility(8);
        this.nvs.setVisibility(0);
        this.nvC.setVisibility(0);
        this.nvt.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nvD != null) {
            this.nvD.dispose();
            this.nvD = null;
        }
        this.nvD = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dSS()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nwv != null && (c.this.nwv instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nwv).u();
                }
            }
        });
    }

    private void dNr() {
        if (this.nuo != null && this.nul) {
            this.ntj.setVisibility(0);
            this.ntk.setVisibility(0);
            this.nqB.setVisibility(0);
            this.ntl.h(this.nuo.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nuo.mCreatorGender), b.a.small, b.a.small);
            this.ntm.setText(this.nuo.mCreatorNickname);
            this.ntp.h(this.nuo.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nuo.mCreatorGender), b.a.small, b.a.small);
            this.ntq.setText(this.nuo.mCreatorNickname);
            dNQ();
            dNs();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dNQ() {
        if (this.nuo != null) {
            this.ntn.setText(tv.chushou.zues.utils.b.formatNumber(this.nuo.mOnlineCount));
            this.ntr.setText(tv.chushou.zues.utils.b.formatNumber(this.nuo.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.nqa != null) {
            if (this.nqa.isSubscribe) {
                this.nvv.setText(a.i.like_already);
                this.nvv.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nvv.setText(getString(a.i.like));
            this.nvv.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNs() {
        if (this.nuo != null) {
            if (this.nuo.mIsSubscribed) {
                this.nto.setText(getString(a.i.like_already));
                this.nto.setBackgroundResource(a.e.bg_show_subcribe);
                this.nqy.setText(getString(a.i.like_already));
                this.nqy.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nto.setText(getString(a.i.like));
            this.nto.setBackgroundResource(a.e.bg_show_subcribe);
            this.nqy.setText(getString(a.i.like));
            this.nqy.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dNt() {
        if (this.nuH != null) {
            this.nuH.notifyDataSetChanged();
        }
    }

    private void dNu() {
        this.ntz = this.nwg.findViewById(a.f.tv_interact);
        this.ntz.setOnClickListener(this);
        this.ntE = (RelativeLayout) this.nwg.findViewById(a.f.rl_edit_bar);
        this.ntC = (ImageView) this.nwg.findViewById(a.f.btn_hotword);
        this.ntC.setOnClickListener(this);
        this.ntD = (ImageView) this.nwg.findViewById(a.f.iv_task_badge);
        this.ntB = (AnimationSet) AnimationUtils.loadAnimation(this.nwv, a.C0824a.anim_hotword);
        this.ntB.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dMo().c) {
                    c.this.ntC.clearAnimation();
                    c.this.ntC.startAnimation(c.this.ntB);
                }
            }
        });
        if (com.kascend.chushou.d.h.dMo().c) {
            this.ntC.startAnimation(this.ntB);
            this.ntD.setVisibility(0);
        }
        this.nvE = (TextView) this.nwg.findViewById(a.f.tv_bottom_input);
        this.nvE.setOnClickListener(this);
        this.nxt = (FrescoThumbnailView) this.nwg.findViewById(a.f.ll_btn_set);
        this.nxt.setOnClickListener(this);
        this.nxt.zR(a.e.ic_room_set_btn_white);
        this.ntN = (LinearLayout) this.nwg.findViewById(a.f.ll_bottom_all_button);
        this.ntO = (FrescoThumbnailView) this.nwg.findViewById(a.f.fl_clear_bottom_gift);
        this.ntO.setAnim(true);
        this.ntO.setOnClickListener(this);
        this.ntO.zR(a.e.ic_show_gift_n);
        this.ntP = (FrameLayout) this.nwg.findViewById(a.f.flfl_clear_bottom_gift);
        this.ntP.setVisibility(8);
        this.ntA = (RelativeLayout) this.nwg.findViewById(a.f.rl_bottom_input);
        this.ntA.setVisibility(0);
        this.ntF = (PastedEditText) this.nwg.findViewById(a.f.et_bottom_input);
        this.ntF.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nqQ.setEnabled(editable.length() > 0);
            }
        });
        this.ntF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nqQ);
                    return true;
                }
                return true;
            }
        });
        this.ntF.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.ntF);
                }
                return false;
            }
        });
        this.nqZ = (ImageView) this.nwg.findViewById(a.f.iv_btn_emoji);
        this.nqZ.setVisibility(8);
        this.nqQ = (TextView) this.nwg.findViewById(a.f.tv_btn_send);
        this.nqQ.setOnClickListener(this);
        this.ntX = (LinearLayout) this.nwg.findViewById(a.f.head_trumpet);
        this.ntX.setVisibility(8);
        this.ntX.setOnClickListener(this);
        this.ntY = (TextView) this.nwg.findViewById(a.f.tv_primary_name);
        this.ntZ = (TextView) this.nwg.findViewById(a.f.tv_primary_desc);
        this.nub = (TextView) this.nwg.findViewById(a.f.tv_cut_count);
        this.nub.setOnClickListener(this);
        this.nud = (TextView) this.nwg.findViewById(a.f.tv_head_count);
        this.nud.setText(this.nug + "");
        this.nuc = (TextView) this.nwg.findViewById(a.f.tv_plus_count);
        this.nuc.setOnClickListener(this);
        this.nrs = (TextView) this.nwg.findViewById(a.f.tv_buy_count_coin);
        this.nua = (TextView) this.nwg.findViewById(a.f.tv_buy_head);
        this.nua.setOnClickListener(this);
        this.nue = (ImageView) this.nwg.findViewById(a.f.iv_trumpet_select);
        this.nue.setOnClickListener(this);
        this.nuf = (TextView) this.nwg.findViewById(a.f.tv_trumpet_have_count);
        this.cO = false;
        this.nue.setBackgroundResource(a.e.ic_trumpet_n);
        this.nuf.setVisibility(8);
        this.nqY = (KPSwitchPanelLinearLayout) this.nwg.findViewById(a.f.chat_extended_container);
        dNy();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nqY, this.nqZ, this.ntF, new a.InterfaceC0960a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0960a
            public void xC(boolean z) {
                if (c.this.nqZ != null) {
                    if (z) {
                        c.this.nqY.setDirectVisibility(0);
                        c.this.nqZ.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nqZ.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nrc = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void xD(boolean z) {
                c.this.nra = z;
                if (z) {
                    c.this.nqZ.setImageResource(a.e.cs_emoji_normal);
                    c.this.dNw();
                    if (c.this.nvl != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nvl.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gQ(c.this.nwv);
                        c.this.nvl.setLayoutParams(layoutParams);
                    }
                    if (c.this.ntE != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.ntE.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gQ(c.this.nwv);
                        c.this.ntE.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nvl != null && c.this.nvl.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nvl.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nvl.setLayoutParams(layoutParams3);
                    c.this.nvl.setVisibility(8);
                }
                if (c.this.nuJ) {
                    c.this.nwZ.setVisibility(0);
                }
                if (c.this.nwv != null && (c.this.nwv instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nwv).xB(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.ntE != null && c.this.nqY.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.ntE.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.ntE.setLayoutParams(layoutParams4);
                }
            }
        };
        this.nrb = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nqY, this.nrc, ((VideoPlayer) this.nwv).dMF());
        ((VideoPlayer) this.nwv).h(((VideoPlayer) this.nwv).dMF());
        this.nvl = this.nwg.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nvi = (TextView) this.nwg.findViewById(a.f.btn_room_search);
        this.nvj = (ImageView) this.nwg.findViewById(a.f.iv_room_emoji_delete);
        this.nvk = (EditText) this.nwg.findViewById(a.f.et_room_emoji_search);
        this.nvk.setImeOptions(3);
        this.nvk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nvi);
                    return true;
                }
                return false;
            }
        });
        this.nvk.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nvi.setEnabled(editable.length() > 0);
                c.this.nvj.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.nwZ.setEmojiSearchText(editable.toString());
            }
        });
        this.nvi.setOnClickListener(this);
        this.nvj.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void av(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dK(this.nvk);
            this.nvl.setVisibility(0);
            this.nvk.requestFocus();
        } else {
            this.nvl.setVisibility(8);
        }
        if (z2) {
            this.nvk.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNw() {
        int gQ = tv.chushou.zues.widget.kpswitch.b.d.gQ(this.nwv) + tv.chushou.zues.utils.a.dip2px(this.nwv, 14.0f);
        if (gQ > this.ntd) {
            b(gQ, 12);
        }
    }

    private void dNy() {
    }

    private void dNA() {
        if (this.cQ > 0) {
            View findViewById = this.nwg.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.cQ);
        }
        if (this.nuh > 0) {
            View findViewById2 = this.nwg.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nuh, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nuF) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dNE();
        a();
        this.npT = ((VideoPlayer) this.nwv).dMB();
        this.npT.a(this);
        if (this.nwu.dNa() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.npT != null) {
            this.npT.d();
        }
    }

    private void aU() {
        if ((this.npX == null || this.npX.nsR == null || !this.npX.nsR.mInPKMode) ? false : true) {
            if (this.nte != null) {
                this.nte.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.npZ.getLayoutParams();
            layoutParams.leftMargin = (this.nuU.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nwv, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.npZ.setLayoutParams(layoutParams);
            this.y.setText(this.npX.nsR.mPkUserNickname);
            this.npZ.setVisibility(0);
            this.ntu.setVisibility(8);
            return;
        }
        if (this.nte != null) {
            this.nte.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.npZ.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.npX != null && this.npX.nsR != null && this.npX.nsR.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nve > 0 && this.nun != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nun.getLayoutParams();
                if (layoutParams.height != this.nve) {
                    layoutParams.height = this.nve;
                    this.nun.setLayoutParams(layoutParams);
                }
            }
            this.ntd = ((int) (tv.chushou.zues.utils.a.gE(this.nwv).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nwv, 84.0f);
            b(this.ntd, 12);
        } else {
            if (this.nun != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nun.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nwv, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nwv, 250.0f);
                    this.nun.setLayoutParams(layoutParams2);
                }
            }
            this.ntd = ((int) (tv.chushou.zues.utils.a.gE(this.nwv).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nwv, 84.0f);
            b(this.ntd, 12);
        }
        if (this.npY != null) {
            this.npY.a(this.nve + tv.chushou.zues.utils.a.dip2px(this.nwv, 52.0f), this.aq);
        }
        if (this.nqc != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nqc.getLayoutParams();
            layoutParams3.bottomMargin = this.nve + tv.chushou.zues.utils.a.dip2px(this.nwv, 52.0f);
            this.nqc.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dND();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dND();
    }

    private void dNC() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dND() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dNZ().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.nuU = tv.chushou.zues.utils.a.gF(this.nwv);
        this.dD = 86;
        this.nuT = (Math.max(this.nuU.x, this.nuU.y) - tv.chushou.zues.utils.a.dip2px(this.nwv, (this.dD + 52) + 250)) - this.nuh;
        this.dC = Math.max(this.nuU.x, this.nuU.y) - ((tv.chushou.zues.utils.a.dip2px(this.nwv, this.dD) + this.nuh) * 2);
        if (this.nuV <= 0 || this.nuW <= 0) {
            this.nuV = Math.min(this.nuU.x, this.nuU.y);
            this.nuW = Math.max(this.nuU.x, this.nuU.y);
        }
        this.ar = Math.min(this.nuU.x, this.nuU.y);
        this.aq = (this.ar * this.nuW) / this.nuV;
        boolean z = false;
        if (this.npX == null || this.npX.nsR == null) {
            i = 1;
        } else {
            i = this.npX.nsR.mMode;
            if (this.npX.nsR.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.dD = 42;
            if (i == 2) {
                if (this.nuW < this.nuV) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nuV * layoutParams.height) / this.nuW;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, this.dD) + this.nuh;
            layoutParams.gravity = 48;
            this.nve = ((this.nuU.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nwv, (this.dD + 52) + 64) + this.nuh)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            dNn();
        } else if (this.E) {
            this.dD = 42;
            if (this.nuW < this.nuV) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nuV * layoutParams.height) / this.nuW;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, this.dD) + this.nuh;
            layoutParams.gravity = 48;
            this.nve = ((this.nuU.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nwv, (this.dD + 52) + 98) + this.nuh)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            dNC();
        } else {
            this.nve = -1;
            this.dD = 86;
            if (this.aq <= this.nuT) {
                layoutParams.width = this.ar;
                layoutParams.height = this.nuT;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, this.dD) + this.nuh;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.dC) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, this.dD) + this.nuh;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nuU.x, this.nuU.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nuV) / this.nuW >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nuV) / this.nuW;
                    } else if ((this.ar * this.nuW) / this.nuV >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nuW) / this.nuV;
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
                    if ((this.ar * this.nuW) / this.nuV > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nuV) / this.nuW;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nuW) / this.nuV;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nuW) / this.nuV;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nuV) / this.nuW;
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
        if (this.nwu != null && this.nwu.d) {
            layoutParams.width = Math.min(this.nuU.x, this.nuU.y);
            layoutParams.height = Math.max(this.nuU.x, this.nuU.y);
        }
        dNZ().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dNE() {
        this.N = new SurfaceRenderView(this.nwv);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dNZ().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nuO) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dNT();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dNS();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nvH != null) {
            this.nvH.a();
        }
        if (this.nwu != null && !h.isEmpty(this.nwu.w)) {
            b(this.nwu.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nsQ != null) {
            int width = this.nsQ.getWidth();
            int height = this.nsQ.getHeight();
            if (this.nuV != width || this.nuW != height || this.nuV <= 0 || this.nuW <= 0) {
                this.nuV = width;
                this.nuW = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dND();
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
            if (this.nuJ) {
                dNG();
            } else {
                if (this.nwv.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击送礼_num", "竖屏", new Object[0]);
                if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nwu.dNa().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.cO) {
                f(this.ntF.getText().toString());
            } else {
                a(this.ntF.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dMo().c) {
                com.kascend.chushou.d.h.dMo().b(false);
                this.ntB.cancel();
                this.ntB.reset();
                this.ntC.clearAnimation();
                this.ntD.setVisibility(8);
            }
            o(view, 0, this.nwg.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nwv, 165.0f) / 2);
            n(view, x >= 0 ? x : 0, this.nwg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.nwu.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.nwu.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nun != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nuo != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nuN = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nwv, (JSONObject) null, this.nwu.dNd().mRoomID, this.nwu.dNd().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.nwv.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nwv, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nuQ != null) {
                    com.kascend.chushou.d.e.a(this.nwv, this.nuQ, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nvh != null) {
                    this.nvh.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nwv, null) && this.nwu != null && this.nwu.npF != null) {
                    if (this.cO) {
                        dNX();
                    } else {
                        if (this.nwu != null && this.nwu.npF != null && this.nwu.npF.count > 0) {
                            this.ntX.setVisibility(8);
                        } else {
                            this.ntX.setVisibility(0);
                        }
                        this.cO = true;
                        this.nue.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nuf.setVisibility(0);
                        this.nuf.setSelected(true);
                        this.nuf.setTextColor(Color.parseColor("#ff5959"));
                        if (this.ntF != null) {
                            this.ntF.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nug <= 9) {
                    this.nug++;
                    this.nud.setText(this.nug + "");
                }
                dNo();
            } else if (id == a.f.tv_cut_count) {
                if (this.nug > 1) {
                    this.nug--;
                    this.nud.setText(this.nug + "");
                }
                dNo();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nvk.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nvk.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nvl.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dL(this.nvk);
                    this.nwZ.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nqa != null && !h.isEmpty(this.nqa.eventUrl)) {
                    f("", this.nqa.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nqa != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nqa != null) {
                    com.kascend.chushou.d.a.a(this.nwv, (JSONObject) null, this.nqa.roomId, this.nqa.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.nwu.a(false);
                    ((VideoPlayer) this.nwv).l();
                } else {
                    ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNH() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.ntW != null) {
            int i = (tv.chushou.zues.utils.a.gE(this.nwv).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ntW.getLayoutParams();
            layoutParams.topMargin = i;
            this.ntW.setLayoutParams(layoutParams);
            this.ntW.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.ntW.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Mc(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nuM <= 3000) {
            tv.chushou.zues.utils.g.Mc(a.i.str_too_fast);
            return false;
        } else {
            dAT();
            if (!com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a(((VideoPlayer) this.nwv).dMA().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nuM = System.currentTimeMillis();
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                a(this.nwu.dNa().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nwu.h);
            }
            g(this.b);
            if (!z && this.ntF != null) {
                this.ntF.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dAT();
            if (com.kascend.chushou.d.e.c(this.nwv, null) && LoginManager.Instance().getUserInfo() != null && this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                a(this.nwu.dNa().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.ntF != null) {
                this.ntF.setText((CharSequence) null);
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
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nwu.dNa().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nwu.dNa().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nwv).nnS;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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

    private void n(View view, int i, int i2) {
        if (this.nwU != null && this.nwU.isShowing()) {
            this.nwU.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
        if (this.nxq == null) {
            i(3);
        }
        this.nxq.getContentView().setBackgroundResource(0);
        this.nxq.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.nxq.isShowing()) {
            this.nxq.showAtLocation(view, 83, i, i2);
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nwu.dNa().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nxq.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dNz() {
        if (h.isEmpty(this.nxu)) {
            if (((VideoPlayer) this.nwv).q) {
                this.nxt.zR(a.e.ic_room_set_btn_white);
            } else {
                this.nxt.zR(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nwv).q && this.nxu.size() == 2 && this.nxu.contains("4") && this.nxu.contains("2")) {
            this.nxt.zR(a.e.ic_room_set_btn_system_white);
        } else if (this.nxu.size() > 1 || !((VideoPlayer) this.nwv).q) {
            this.nxt.zR(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.nxu.get(0))) {
            this.nxt.zR(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.nxu.get(0))) {
            this.nxt.zR(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.nxu.get(0))) {
            this.nxt.zR(a.e.ic_room_set_btn_system_white);
        }
    }

    private void o(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
        if (this.nwU == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.nwU.getContentView().setBackgroundResource(0);
            this.nwU.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nwU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.ntC.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.nwU.isShowing()) {
            this.nwU.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nwv, 16.0f) + i2);
            this.ntC.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nwu.dNa().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nwU.dismiss();
    }

    private void dA(View view) {
        if (this.nwO == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.dMo().q()) {
            this.ntG.dZT();
        } else {
            this.ntG.dZU();
        }
        int height = this.nwg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (view != null) {
            this.nwO.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.nwO == null) {
            View inflate = LayoutInflater.from(this.nwv).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.ntG = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dMo().q()) {
                this.ntG.dZT();
            } else {
                this.ntG.dZU();
            }
            this.ntG.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dMo().g(z);
                }
            });
            this.nwI = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nwJ = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nwI.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nwI.setVisibility(0);
            } else {
                this.nwI.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dMo().a) {
                this.nwJ.b();
            } else {
                this.nwJ.c();
            }
            if (this.nwu != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.nwu.f;
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
                                if (this.npX == null || !this.npX.nsR.mInPKMode || h.isEmpty(this.npX.b) || this.nuo == null || !this.npX.b.equals(this.nuo.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nwv).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dNb = this.nwu.dNb();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nwv).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwv, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, 5.0f);
                                            }
                                            int identifier = this.nwv.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nwv.getPackageName());
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
                                                if (dNb != null && dNb.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nwv.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nwv).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dNb2 = this.nwu.dNb();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nwv).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwv, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, 5.0f);
                                        }
                                        int identifier2 = this.nwv.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nwv.getPackageName());
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
                                            if (dNb2 != null && dNb2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.nwO.dismiss();
                    }
                }
            });
            this.nwO = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 150.0f), -2);
            this.nwO.setFocusable(true);
            this.nwO.setOutsideTouchable(true);
            this.nwO.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nwO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nwO = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
            if (this.ntV == null) {
                this.ntV = new f(getActivity());
            }
            this.ntV.a(this.nwu.dNa().mRoominfo, this.ax);
            if (!this.ntV.isShowing()) {
                this.ntV.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nuO) {
            return false;
        }
        if (this.nuN == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nvF = motionEvent.getX();
                    this.nvG = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nvF;
                    if (Math.abs(f) > Math.abs(y - this.nvG) && Math.abs(f) > q && f > 0.0f) {
                        bj();
                        return true;
                    }
                    this.nvF = 0.0f;
                    this.nvG = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nvl != null && this.nvl.getVisibility() == 0 && b(motionEvent, this.nvl)) {
                this.nvl.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.nvk);
                return true;
            } else if (this.nuJ && this.nvl != null && this.nvl.getVisibility() == 8 && f(this.nwZ.b, motionEvent)) {
                dNG();
                return true;
            } else if (this.ntW != null && this.ntW.b() && f(this.ntW, motionEvent)) {
                this.ntW.a();
                return true;
            } else if (this.ntM != null && this.ntM.b() && f(this.ntM, motionEvent)) {
                this.ntM.a();
                return true;
            } else if (b(motionEvent, this.ntE)) {
                return dAT();
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
            if (this.nxk != null && this.nxk.a(i, keyEvent)) {
                return true;
            }
            if ((this.ntW != null && this.ntW.onKeyDown(i, keyEvent)) || az()) {
                return true;
            }
            if (this.nuN == 3) {
                this.nuN = 1;
                bj();
                return true;
            } else if (this.ntM != null && this.ntM.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.ntF != null && this.ntA != null && this.ntE != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.ntF);
                this.ntA.setVisibility(8);
                this.ntE.setVisibility(0);
            }
        } else if (this.ntA != null && this.ntE != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
            this.ntA.setVisibility(0);
            this.ntE.setVisibility(8);
        }
    }

    public boolean dAT() {
        boolean z;
        b(this.ntd, 12);
        boolean z2 = false;
        if (this.nqY != null && this.nqY.getVisibility() == 0) {
            this.nqY.setVisibility(8);
            this.nqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nra) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwv);
            this.nqZ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.ntE == null || this.ntE.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.cO) {
                dNX();
            }
            this.ntE.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ntA != null) {
                    c.this.ntA.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean az() {
        if (dAT()) {
            return true;
        }
        if (this.nwU != null && this.nwU.isShowing()) {
            this.nwU.dismiss();
            return true;
        } else if (this.nxq != null && this.nxq.isShowing()) {
            this.nxq.dismiss();
            return true;
        } else if (this.nwO == null || !this.nwO.isShowing()) {
            return dNG() || dNx() || dNF() || dNm();
        } else {
            this.nwO.dismiss();
            return true;
        }
    }

    public boolean dNm() {
        if (this.nxd == null || !this.nxd.isShown()) {
            return false;
        }
        this.nxd.d();
        return true;
    }

    public boolean dNx() {
        if (this.nuL == null || !this.nuL.isShown()) {
            return false;
        }
        this.nuL.a();
        return true;
    }

    public boolean dNF() {
        if (this.ntW == null || !this.ntW.b()) {
            return false;
        }
        this.ntW.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nwv != null && !((Activity) this.nwv).isFinishing() && pVar != null) {
            this.nuw = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nuo != null && mVar.a(this.nuo.mCreatorUID, null)) {
            this.nuo.mIsSubscribed = mVar.c;
            dNs();
        }
    }

    public boolean dNG() {
        if (!this.nuJ || this.nwZ == null) {
            return false;
        }
        if (this.nwZ != null) {
            this.nwZ.e();
        }
        if (this.nvk != null) {
            this.nvk.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nuS != null) {
                        this.nuS.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                        this.nwu.dNa().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nwu.dNa().mMicStatus.onMic) {
                            if (this.ntu != null) {
                                this.ntu.setVisibility(8);
                            }
                            if (this.nuL != null && this.nuL.isShown()) {
                                this.nuL.a();
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
                        if (this.nwu.dNa().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nuo != null && !h.isEmpty(this.nuo.mCreatorUID)) {
                                g(arrayList2, this.nuo.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.nwu.dNa().mMicStatus.onMic) {
                            if (this.nwu.dNa().mMicStatus != null && !h.isEmpty(this.nwu.dNa().mMicStatus.micRoomId) && !this.nwu.dNa().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.nwu.dNa().mMicStatus.micRoomId;
                            }
                            this.nwu.dNa().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nwu.dNa().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.nwu.dNa().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.nwu.dNa().mMicStatus, str3, z4);
                            if (this.nuL != null && this.nuL.getVisibility() == 0) {
                                this.nuL.a(this.nwu.dNa().mFanItems, this.nwu.dNa().mMicStatus, str3, z4, this.nwu.dNa().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.ntu != null) {
                                this.ntu.setVisibility(8);
                            }
                            if (this.nuL != null && this.nuL.isShown()) {
                                this.nuL.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nuj != onlineVip.mCount || (this.nts != null && this.nts.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nuj = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dNK();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.nuI.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.nuI.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.nuI.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.nvb <= 5000) {
                                z2 = false;
                            } else {
                                this.nvb = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.nuI.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.nuI.addAll(onlineVip.mOnlineVipItems);
                            }
                            dNt();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nvc != null) {
                    if (this.nuo == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nuo.mCreatorAvatar;
                        str2 = this.nuo.mCreatorGender;
                    }
                    this.nvc.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.npX != null && this.npX.nsR != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.npX.nsR.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.npT != null) {
                                        this.npT.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.npX.nsR.mInPKMode = true;
                                    this.npX.nsR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npX.nsR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npX.nsR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npX.nsR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npX.nsR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npX.nsR.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.npX.nsR.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.npX.nsR.mMode = pkNotifyInfo.mMode;
                                    this.npX.nsR.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.npY != null) {
                                        this.npY.g(true, this.npX.nsR.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dMo().a) {
                                        if (!com.kascend.chushou.b.dMh().e) {
                                            com.kascend.chushou.b.dMh().e = true;
                                            tv.chushou.zues.utils.g.F(this.nwv, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dMo().a(this.nwv, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.npX.nsR.mAction = 7;
                                    this.npX.nsR.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npX.nsR.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npX.nsR.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npX.nsR.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npX.nsR.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npX.nsR.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.npX.nsR.mMode == 2) {
                                        dND();
                                    } else {
                                        dNn();
                                    }
                                    if (this.npY != null) {
                                        this.npY.g(false, 0L);
                                        this.npY.b(this.npX.nsR, true);
                                        this.npY.a(this.nve + tv.chushou.zues.utils.a.dip2px(this.nwv, 52.0f), this.aq);
                                        this.npY.a(this.npX.nsR.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.npT != null) {
                                        this.npT.a(false);
                                    }
                                    this.npX.nsR.mInPKMode = false;
                                    this.npX.nsR.mAction = 2;
                                    dNn();
                                    dND();
                                    if (this.npY != null) {
                                        this.npY.c();
                                    }
                                    this.npX.b = null;
                                    this.npX.nsR = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.npX.nsR.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.npX.nsR.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.npX.nsR.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nuo != null && !h.isEmpty(this.nuo.mRoomID) && this.nuo.mRoomID.equals(this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.npX.nsR.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.npY != null) {
                                        this.npY.a(this.npX.nsR, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.npX.nsR.copyUpdate(pkNotifyInfo);
                                    if (this.npY != null) {
                                        this.npY.a(this.npX.nsR);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.npX.nsR.copyStop(pkNotifyInfo);
                                        if (this.npY != null) {
                                            this.npY.B(this.npX.nsR.mMaxFreeDuration, this.npX.nsR.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.npX.nsR.copyResult(pkNotifyInfo);
                                    if (!this.nuG && this.npY != null) {
                                        int i7 = 1;
                                        if (this.npX.nsR.destinyInfo != null && this.npX.nsR.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.npY.a(h.parseInt(this.npX.nsR.mResult), h.parseLong(this.npX.nsR.mvpUid), this.npX.nsR.mvpAvatar, this.npX.nsR.mvpNickname, this.npX.nsR.mMaxFreeDuration, this.npX.nsR.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nqa != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nqa.uid = cycleLiveRoomInfo.uid;
                        this.nqa.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nqa.roomId = cycleLiveRoomInfo.roomId;
                        this.nqa.avatar = cycleLiveRoomInfo.avatar;
                        this.nqa.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nwv != null && (this.nwv instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nwv).d();
                        }
                    } else {
                        ((VideoPlayer) this.nwv).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.nwu != null && this.nwu.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dMo().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dMo().b().equals(next2.mUserID)) {
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

    public void dNK() {
        if (this.nts != null) {
            if (this.npX == null || this.npX.nsR == null || !this.npX.nsR.mInPKMode) {
                if (this.bP > 0) {
                    this.nts.setVisibility(0);
                    this.nts.setText(String.format(this.nwv.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.ntw.setVisibility(0);
                    return;
                }
                this.nts.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.ntu.setVisibility(0);
            if (this.ntv != null) {
                this.ntv.a(str, z, micStatus, this.nwu.dNa().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.ntu.setVisibility(8);
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
        int childCount = this.nuq.getChildCount();
        int itemCount = this.nuq.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nuq);
        if (f + childCount >= itemCount) {
            this.nux = true;
            if (this.nuy != null) {
                this.nuy.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dNN() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nur.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nur.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nur == null) {
            this.nur = new ArrayList<>();
        }
        while (2 < this.nur.size()) {
            this.nur.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nut);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nur.addAll(a2);
        int size = this.nur.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nur.size(); i++) {
                this.nur.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nuu == null) {
            this.nuu = new ArrayList<>();
        }
        this.nuu.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nuw != null && this.nuw.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nuw.contains("2"))) {
                        this.nuu.add(next);
                    } else if (!this.nuw.contains(next.mType)) {
                        this.nuu.add(next);
                    }
                }
                return this.nuu;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nur == null) {
                    this.nur = new ArrayList<>(arrayList);
                    dNN();
                    w(z2);
                    return;
                }
                if (this.nut == null) {
                    this.nut = new ArrayList<>();
                }
                this.nut.addAll(arrayList);
                int size = this.nut.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.nut.size(); i++) {
                        this.nut.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nur.size();
                if (a2 != null) {
                    this.nur.addAll(a2);
                }
                int size3 = this.nur.size();
                if (!this.nux && this.nuy != null) {
                    this.nuy.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nur.size(); i3++) {
                        this.nur.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nur == null) {
                this.nur = new ArrayList<>(arrayList);
                dNN();
            } else {
                if (this.nut == null) {
                    this.nut = new ArrayList<>();
                }
                this.nut.clear();
                this.nut.addAll(arrayList);
                this.nur.clear();
                dNN();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nur.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nuv != null) {
                this.nuv.a(this.nur.size());
                if (i == 1) {
                    this.nuv.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nuv.notifyItemRangeRemoved(i2, i3);
                    this.nuv.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nuv.notifyDataSetChanged();
                }
            }
            if (z || this.nux) {
                this.nux = true;
                if (this.nuy != null) {
                    this.nuy.setVisibility(8);
                }
                if (z) {
                    this.nun.scrollToPosition(this.nur.size() - 1);
                } else {
                    this.nun.smoothScrollToPosition(this.nur.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nuv != null) {
                this.nuv.a(this.nur.size());
                this.nuv.notifyDataSetChanged();
            }
            if (z || this.nux) {
                this.nux = true;
                if (this.nuy != null) {
                    this.nuy.setVisibility(8);
                }
                if (z) {
                    this.nun.scrollToPosition(this.nur.size() - 1);
                } else {
                    this.nun.smoothScrollToPosition(this.nur.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dML;
        RoomToast roomToast;
        this.p = false;
        if (this.nwu != null && this.nwu.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.nwu.f.size()) {
                    break;
                } else if (!"2".equals(this.nwu.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dNR();
            return;
        }
        if (this.nqn != null) {
            this.nqn.setVisibility(0);
        }
        if (this.nti != null) {
            this.nti.setVisibility(0);
        }
        if (this.nwu != null) {
            this.nuo = this.nwu.dNd();
            this.nup = this.nwu.dNa();
            if (com.kascend.chushou.b.dMh().c != null && this.nuv != null) {
                this.nuv.a(com.kascend.chushou.b.dMh().c);
                this.nuv.notifyDataSetChanged();
            }
            FullRoomInfo dNa = this.nwu.dNa();
            if (dNa != null) {
                if (!h.isEmpty(dNa.mRoomToastList)) {
                    Iterator<RoomToast> it = dNa.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dMo().j())) {
                    a(roomToast);
                }
            }
            if (this.nuo != null) {
                dNU();
            }
            if (this.nuo != null && !this.nuo.mIsSubscribed) {
                RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nuo == null || !c.this.nuo.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.nwu != null && this.nwu.l()) {
                d(true);
            }
        }
        if (this.nuo != null && this.nuv != null) {
            if (this.nur != null) {
                this.nur.clear();
            } else {
                this.nur = new ArrayList<>();
            }
            this.nuv.a(this.nuo);
            dNN();
            this.nuv.a(this.nur.size());
            this.nuv.notifyDataSetChanged();
        }
        dNr();
        N();
        if (this.nwv != null && (this.nwv instanceof VideoPlayer) && (dML = ((VideoPlayer) this.nwv).dML()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dML.nsR, dML.b);
        }
        this.ntJ.h(this.nuo.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nuo.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.ntN);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.nui == null) {
            View inflate = LayoutInflater.from(this.nwv).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nrD = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nui = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwv, 160.0f), -2);
            this.nui.setFocusable(false);
            this.nui.setOutsideTouchable(false);
            this.nui.setAnimationStyle(a.j.gift_toast_style);
            this.nui.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dMo().c(roomToast.mToastContent);
            if (this.nui == null) {
                bd();
            }
            if (this.nrD != null) {
                this.nrD.setText(roomToast.mToastContent);
            }
            if (!this.nui.isShowing()) {
                if (this.ntN != null) {
                    this.nui.showAtLocation(this.ntN, 85, 0, this.nwg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nui != null) {
                                c.this.nui.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nui.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nuY != null) {
            this.nuY.setVisibility(z ? 0 : 8);
        }
        this.dJ = true;
        if (this.nwv instanceof VideoPlayer) {
            ((VideoPlayer) this.nwv).p();
        }
    }

    private void dNR() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nwv).s();
        dNm();
        dNx();
        if (this.nty == null) {
            this.nty = (PlayShowRecommendView) ((ViewStub) this.nwg.findViewById(a.f.view_recommend)).inflate();
        }
        this.nty.setVisibility(0);
        if (this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null && !h.isEmpty(this.nwu.dNa().mRoominfo.mRoomID)) {
            dNL();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nwZ != null) {
            this.nwZ.e();
        }
        if (this.nqn != null) {
            this.nqn.setVisibility(4);
        }
        if (this.nti != null) {
            this.nti.setVisibility(8);
        }
        if (this.nxh != null) {
            this.nxh.dZq();
            this.nxh.setVisibility(8);
        }
        m(false);
        a(false, false);
        if (this.npT != null) {
            this.npT.a();
        }
    }

    private void dNL() {
        if (this.nty != null && this.nty.getVisibility() == 0) {
            this.nty.a(this.nwu.dNa().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dNB() {
        super.dNB();
        if (this.nwv instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.ntW != null && this.ntW.b()) {
            this.ntW.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nuK);
        if (this.nwv != null) {
            if (this.nuK || "10004".equals(((VideoPlayer) this.nwv).t)) {
                this.nuK = true;
                if (this.nwu != null) {
                    this.nwu.f = null;
                    if (this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                        this.nwu.dNa().mRoominfo.mGameId = null;
                    }
                }
                dNR();
                return;
            }
            this.nuK = true;
            if (this.nwv != null) {
                ((VideoPlayer) this.nwv).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nuK = false;
        if (this.nqn != null) {
            this.nqn.setVisibility(0);
        }
        if (this.nti != null) {
            this.nti.setVisibility(0);
        }
        if (this.nty != null) {
            this.nty.setVisibility(8);
        }
        if (this.nwp != null) {
            this.nwp.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nuK = false;
        if (this.nqn != null) {
            this.nqn.setVisibility(0);
        }
        if (this.nti != null) {
            this.nti.setVisibility(0);
        }
        if (this.nty != null) {
            this.nty.setVisibility(8);
        }
        if (this.nwp != null) {
            this.nwp.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nty != null) {
            this.nty.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.nwu != null) {
                        this.nwu.f = null;
                        this.nwu.dNa().mRoominfo.mGameId = null;
                    }
                    dNR();
                    return;
                }
                tv.chushou.zues.utils.g.Mc(a.i.str_getvideosource_failed);
            }
            m(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.nwu != null && this.nwu.dNb() != null) {
            a(this.nwu.dNb());
        }
        this.p = false;
        if (this.nwu == null || this.nwu.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nwu.f.size()) {
                if (!"2".equals(this.nwu.f.get(i2).mType)) {
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
    public GiftAnimationLayout dNv() {
        if (this.nwg == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nwg.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.ntN != null) {
            int size = iconConfig.configs.size();
            this.ntN.removeAllViews();
            if (this.ntP != null) {
                this.ntP.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nwv).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.ntN, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bS(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.bS(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bS(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.ntP.setVisibility(0);
                            this.ntO.bS(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.bS(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.bS(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.bS(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void dy(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.ntN.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nwv instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dMG = ((VideoPlayer) this.nwv).dMG();
            if (this.nxk == null) {
                this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxk.setVisibility(0);
            this.nxk.a(2, dMG);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.ntR != null && this.nwv != null) {
            this.ntR.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.ntR != null && this.nwv != null) {
            this.ntR.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.ntR != null) {
            this.ntR.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.ntR != null) {
            this.ntR.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.ntQ != null) {
            if (this.nwv != null) {
                this.ntQ.a(((VideoPlayer) this.nwv).dMG(), false);
            }
            this.ntQ.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nwg != null) {
            Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
            int i = gE.x > gE.y ? 1 : 2;
            if (this.nxk == null) {
                this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxk.setPlayerViewHelper(this.nwu);
            this.nxk.setVisibility(0);
            this.nxk.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.ntS != null) {
            this.ntS.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.ntS != null) {
            this.ntS.a(bangInfo, str);
        }
        if (this.nqB != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nqB.setText(this.nwv.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nqB.setText(this.nwv.getString(a.i.str_contribute_tittle));
            } else {
                this.nqB.setText(Html.fromHtml(this.nwv.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.ntt != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.ntt.setText(this.nwv.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.ntt.setText(this.nwv.getString(a.i.str_contribute_tittle));
            } else {
                this.ntt.setText(Html.fromHtml(this.nwv.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.ntS != null) {
            this.ntS.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nwu != null && !h.isEmpty(this.nwu.npE)) {
            this.nuQ = this.nwu.npE.get(0);
            if (this.nvf != null) {
                this.nvf.setVisibility(0);
                this.nvf.a(this.nuQ.mCover, 0, 0, 0, 1);
                if (this.nvg != null) {
                    if (this.nuQ.mShowClose) {
                        this.nvg.setVisibility(0);
                    } else {
                        this.nvg.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.ntS != null) {
            this.ntS.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nwg != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nqY != null) {
            this.nqY.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nuG) {
            if (iVar.a == 52) {
                if (this.nuv != null) {
                    this.nuv.a(com.kascend.chushou.b.dMh().c);
                    this.nuv.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nuG && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.ntF != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.ntF);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nuG) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nwv, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dMH = ((VideoPlayer) this.nwv).dMH();
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(2, dMH);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dMI = ((VideoPlayer) this.nwv).dMI();
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(2, dMI);
            } else if (bVar.a == 8) {
                if (this.nuS != null && this.nuS.getVisibility() != 0) {
                    this.nuS.a(a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, this.nuo == null ? "" : this.nuo.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.nxk == null) {
                    this.nxk = (H5Container) ((ViewStub) this.nwg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxk.setVisibility(0);
                this.nxk.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.nwu != null && !h.isEmpty(this.nwu.a) && this.nwu.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nuS != null && this.nuS.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nwv, 80.0f);
                }
                if (this.nuR != null && this.nuR.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nuR.getHeight());
                }
                this.nva.setTranslationY(-r0);
                return;
            }
            if (this.nuZ != null) {
                this.nuZ.cancel();
                this.nuZ = null;
            }
            int translationY = (int) this.nva.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nwv, 80.0f) : 0;
                    if (this.nuR != null && this.nuR.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nuR.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nuR.getHeight() : 0;
                    if (this.nuS != null && this.nuS.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nwv, 80.0f));
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
        this.nuZ = ValueAnimator.ofInt(i, i2);
        this.nuZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.ntS != null) {
                    c.this.nva.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nuZ.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nuZ = null;
            }
        });
        this.nuZ.setInterpolator(new LinearInterpolator());
        this.nuZ.setDuration(800L);
        this.nuZ.start();
    }

    private boolean dNS() {
        if (this.nuN == 1) {
            this.nuN = 2;
            x(true);
            return true;
        } else if (this.nuN == 3) {
            bj();
            return true;
        } else {
            return false;
        }
    }

    private boolean dNT() {
        if (this.nuN == 1) {
            return bi();
        }
        if (this.nuN == 2) {
            this.nuN = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nuO || this.nwu == null || this.nwu.dNd() == null) {
            return false;
        }
        if (this.nvH != null) {
            this.nvH.a(true);
        }
        this.nuN = 3;
        this.nuO = true;
        dNU();
        this.ntf.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nuO = false;
                c.this.nth.setVisibility(8);
            }
        });
        this.nth.startAnimation(loadAnimation);
        this.ntf.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj() {
        if (!this.nuO) {
            if (this.nvH != null) {
                this.nvH.a(false);
            }
            this.nuN = 1;
            this.nuO = true;
            dNU();
            this.nth.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nuO = false;
                    c.this.ntf.setVisibility(8);
                }
            });
            this.nth.startAnimation(loadAnimation);
            this.ntf.startAnimation(loadAnimation2);
        }
    }

    private void dNU() {
        if (this.nwg != null) {
            if (this.ntf == null) {
                this.ntf = this.nwg.findViewById(a.f.user_space_container);
            }
            if (this.nth == null) {
                this.nth = this.nwg.findViewById(a.f.video_container);
            }
            if (this.ntg == null) {
                this.ntg = com.kascend.chushou.view.user.b.b(null, this.nwu.a, false, this.nwu.h);
                this.ntg.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.bj();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.bj();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.ntg).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.nti != null) {
            this.nti.setVisibility(z ? 8 : 0);
        }
        if (this.nuk != null) {
            this.nuO = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nuk.setVisibility(8);
                        c.this.nuO = false;
                    }
                });
            } else {
                this.nuO = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nuk.setVisibility(0);
                        c.this.nuO = false;
                    }
                });
            }
            this.nuk.startAnimation(loadAnimation);
        }
        az();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.ntz.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.ntH != null) {
                this.ntH.setVisibility(0);
            }
            if (this.ntI != null) {
                this.ntI.a();
                return;
            }
            return;
        }
        if (this.ntK != null) {
            this.ntK.setVisibility(0);
        }
        if (this.ntL != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.ntL.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.ntK != null) {
            this.ntK.setVisibility(8);
        }
        if (this.ntL != null) {
            this.ntL.clearAnimation();
        }
        if (this.ntH != null) {
            this.ntH.setVisibility(8);
        }
        if (this.ntI != null) {
            this.ntI.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nuk != null && this.nwg != null) {
            if (this.nuS == null) {
                this.nuS = new com.kascend.chushou.player.ui.miniview.a(this.nwv, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nuS != null && c.this.nwg != null && c.this.nuS.a()) {
                            ((ViewGroup) c.this.nwg).removeView(c.this.nuS);
                            c.this.nuS = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nuS.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nwv, 52.0f);
                this.nuS.setLayoutParams(layoutParams);
                ((ViewGroup) this.nuk).addView(this.nuS, ((ViewGroup) this.nuk).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nuS.setVisibility(8);
                } else {
                    this.nuS.a(a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, this.nwu.a == null ? "" : this.nwu.a);
                }
            } else if (!this.nuS.isShown()) {
                this.nuS.a(a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, this.nwu.a == null ? "" : this.nwu.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nuX != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nuX.setVisibility(0);
                this.nuX.setAnim(true);
                this.nuX.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.ouE, b.C0959b.ouG, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nuz != null && this.nuz.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dNV();
                    }
                });
                this.nuz.setVisibility(0);
                this.nuz.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nuz != null && this.nuz.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nuB != null) {
                        c.this.nuB.removeAllListeners();
                        c.this.nuB.cancel();
                        c.this.nuB = null;
                    }
                    if (c.this.nuz != null) {
                        c.this.nuz.setVisibility(8);
                    }
                }
            });
            this.nuz.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nvd == null) {
                this.nvd = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nwv, "显示双击666_num", null, new Object[0]);
                            if (c.this.nwu != null) {
                                c.this.nwu.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.nww != null) {
                    this.nww.e(this.nvd, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nvd != null) {
            this.nww.O(this.nvd);
            this.nvd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nuC != null && this.nuC.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nwv, a.C0824a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dNW();
                    }
                });
                this.nuC.setVisibility(0);
                this.nuC.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nwf, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nuC != null && this.nuC.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwv, a.C0824a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nuE != null) {
                        c.this.nuE.removeAllListeners();
                        c.this.nuE.cancel();
                        c.this.nuE = null;
                    }
                    if (c.this.nuC != null) {
                        c.this.nuC.setVisibility(8);
                    }
                }
            });
            this.nuC.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dNV() {
        if (this.nuz == null || this.nuA == null) {
            return null;
        }
        if (this.nuB != null) {
            this.nuB.removeAllListeners();
            this.nuB.cancel();
            this.nuB = null;
        }
        this.nuA.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nuA, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nuA, 0.0f);
        int measuredWidth = (this.nuz.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nwv, 13.0f) * 2)) - this.nuA.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nuA, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nuA, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nuA, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nuB != null) {
                    c.this.nuB.removeAllListeners();
                    c.this.nuB.cancel();
                    c.this.nuB = null;
                }
                RxExecutor.postDelayed(c.this.nwf, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dNV();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nuB = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dNW() {
        if (this.nuC == null || this.nuD == null) {
            return null;
        }
        if (this.nuE != null) {
            this.nuE.removeAllListeners();
            this.nuE.cancel();
            this.nuE = null;
        }
        this.nuD.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nuD, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nuD, 0.0f);
        int measuredWidth = (this.nuC.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nwv, 13.0f) * 2)) - this.nuD.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nuD, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nuD, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nuD, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nuE != null) {
                    c.this.nuE.removeAllListeners();
                    c.this.nuE.cancel();
                    c.this.nuE = null;
                }
                RxExecutor.postDelayed(c.this.nwf, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dNW();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nuE = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nvH = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nqa != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nqa.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet dW = com.kascend.chushou.c.a.dW(jSONObject);
                        if (dW.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Mc(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Mc(a.i.subscribe_success);
                            }
                            if (c.this.nqa != null) {
                                c.this.nqa.isSubscribe = !z;
                                c.this.aN();
                                return;
                            }
                            return;
                        }
                        a(dW.mRc, dW.mMessage);
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
                com.kascend.chushou.c.c.dMk().a(bVar, (String) null, this.nqa.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nqa.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dMk().b(bVar, (String) null, c.this.nqa.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.nwu != null && this.nuo != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.nwu.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nwu.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nuo.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet dW = com.kascend.chushou.c.a.dW(jSONObject);
                        if (dW.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Mc(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Mc(a.i.subscribe_success);
                            }
                            c.this.nuo.mIsSubscribed = !z;
                            c.this.dNs();
                            return;
                        }
                        a(dW.mRc, dW.mMessage);
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
                com.kascend.chushou.c.c.dMk().a(bVar, (String) null, this.nuo.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nuo.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dMk().b(bVar, (String) null, c.this.nuo.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.nsQ != null) {
            int width = this.nsQ.getWidth();
            int height = this.nsQ.getHeight();
            if (this.nuV != width || this.nuW != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.nwg != null) {
            if (this.ntM == null) {
                this.ntM = (InteractionView) ((ViewStub) this.nwg.findViewById(a.f.view_interaction)).inflate();
                this.ntM.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.ntM.a();
                    }
                });
            }
            if (this.ntM != null) {
                this.ntM.b(configDetail);
                this.ntM.c();
                this.ntM.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.ead()) {
                tv.chushou.zues.utils.g.F(this.nwv, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nwv, null) && (this.nwv instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nwu != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwv, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nwv, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nwu != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwv, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nwv, configDetail.mUrl, this.nwv.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nwv, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nuJ) {
                        dNG();
                        return;
                    }
                    if (this.nwv.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nwv, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.nwu != null && this.nwu.dNa() != null && this.nwu.dNa().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nwu.dNa().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dA(this.ntN);
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
        if (this.nwv != null && !this.v && !h.isEmpty(str) && this.nuo != null && str.equals(this.nuo.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.npX == null) {
                this.npX = new com.kascend.chushou.player.e.a();
            }
            this.npX.b = str;
            this.npX.nsR.copy(pkNotifyInfo);
            if (this.npX.nsR.mAction == 6) {
                if (this.npT != null) {
                    this.npT.a(true);
                }
                this.npX.nsR.mInPKMode = true;
                this.u = this.npX.nsR.mPkId;
            } else if (this.npX.nsR.mAction == 7 || (this.npX.nsR.mMode == 1 && this.npX.nsR.mAction == 5)) {
                if (this.npT != null) {
                    this.npT.a(true);
                }
                this.npX.nsR.mInPKMode = true;
                if (this.dD != 42) {
                    this.nve = ((this.nuU.y - ((this.nuU.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nwv, 158.0f) + this.nuh)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
                    dND();
                }
                this.u = this.npX.nsR.mPkId;
                if (this.npY != null) {
                    this.npY.b(this.npX.nsR, false);
                    this.npY.a(this.npX.nsR.mMode, (String) null);
                    if (this.npX.nsR.mAction == 5 && this.npX.nsR.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.npX.nsR.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.npX.nsR.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.npX.nsR.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.npX.nsR.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.npX.nsR.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.npY.a(this.npX.nsR);
                        this.npY.a(parseInt, this.npX.nsR.mPkUpdateInfo.remainDuration, j, this.npX.nsR.mMode, (this.npX.nsR.destinyInfo == null || this.npX.nsR.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.npX.nsR.mPkUpdateInfo != null && !h.isEmpty(this.npX.nsR.mPkUpdateInfo.specialMomentList) && this.npY != null) {
                    this.npY.a(this.npX.nsR, true);
                }
                if (this.npX.nsR.mMode == 2) {
                    dND();
                } else {
                    dNn();
                }
            } else {
                this.npX.nsR.mInPKMode = false;
                if (this.npX.nsR.mMode == 2) {
                    dND();
                } else {
                    dNn();
                }
            }
        }
    }

    public void dNn() {
        aV();
        aU();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nuf != null && this.nwu != null && this.nwu.npF != null) {
            this.nuf.setText(tv.chushou.zues.utils.b.Mb(this.nwu.npF.count));
            this.nuf.setVisibility(0);
            if (this.nwu.npF.count < 1) {
                dNX();
            }
            if (this.ntY != null) {
                this.ntY.setText(this.nwu.npF.primaryName);
            }
            if (this.ntZ != null) {
                this.ntZ.setText(this.nwu.npF.desc);
            }
            dNo();
        }
    }

    public void dNo() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nug * h.parseLong(this.nwu.npF.point)));
        if (this.nrs != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nwv.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nwv, a.e.icon_coin_new);
            cVar.append(this.nwv.getString(a.i.str_buy_count_coin2));
            this.nrs.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.nwv, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nug);
        }
    }

    private void dNX() {
        this.cO = false;
        this.nue.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nwu != null && this.nwu.npF != null) {
            if (this.nwu.npF.count < 1) {
                this.nuf.setVisibility(8);
            } else {
                this.nuf.setVisibility(0);
                this.nuf.setSelected(false);
                this.nuf.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.ntX.setVisibility(8);
        if (this.ntF != null) {
            this.ntF.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nqc != null) {
            if (z) {
                this.nqc.setVisibility(0);
            } else {
                this.nqc.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nvE != null) {
            this.nvE.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.ntO != null) {
            this.ntO.performClick();
        }
    }
}
