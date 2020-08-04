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
    private TextView nqA;
    private TextView nqD;
    private ImageView nqJ;
    private TextView nqS;
    private View nqp;
    public String nqw;
    private TextView nrF;
    private View nrI;
    private KPSwitchPanelLinearLayout nra;
    private ImageView nrb;
    private tv.chushou.zues.widget.kpswitch.b.c nrd;
    private d.a nre;
    private TextView nru;
    private TextView nsF;
    private PlayShowRecommendView ntA;
    private View ntB;
    private RelativeLayout ntC;
    private AnimationSet ntD;
    private ImageView ntE;
    private ImageView ntF;
    private RelativeLayout ntG;
    private PastedEditText ntH;
    private ToggleButton ntI;
    private RelativeLayout ntJ;
    private PaoPaoView ntK;
    private FrescoThumbnailView ntL;
    private LinearLayout ntM;
    private ImageView ntN;
    private InteractionView ntO;
    private LinearLayout ntP;
    private FrescoThumbnailView ntQ;
    private FrameLayout ntR;
    private RedpacketNotifier ntS;
    private InteractNotifier ntT;
    private EmbeddedButtonLayout ntU;
    private GiftAnimationLayout ntV;
    private com.kascend.chushou.player.b.a ntW;
    private f ntX;
    private PlayShowH5View ntY;
    private LinearLayout ntZ;
    private int ntf;
    private View ntg;
    private View nth;
    private com.kascend.chushou.view.user.b nti;
    private View ntj;
    private FrameLayout ntk;
    private LinearLayout ntl;
    private RelativeLayout ntm;
    private FrescoThumbnailView ntn;
    private TextView nto;
    private TextView ntp;
    private TextView ntq;
    private FrescoThumbnailView ntr;
    private TextView nts;
    private TextView ntt;
    private TextView ntu;
    private TextView ntv;
    private LinearLayout ntw;
    private PlayShowMicStatusView ntx;
    private RecyclerView nty;
    private ImageView ntz;
    private Button nuA;
    private View nuB;
    private View nuC;
    private Animator nuD;
    private View nuE;
    private View nuF;
    private Animator nuG;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nuJ;
    private PlayShowMicPerson nuN;
    private FoodView nuR;
    public ListItem nuS;
    private FoodView nuT;
    private com.kascend.chushou.player.ui.miniview.a nuU;
    private int nuV;
    private Point nuW;
    private FrescoThumbnailView nuZ;
    private TextView nua;
    private TextView nub;
    private TextView nuc;
    private TextView nud;
    private TextView nue;
    private TextView nuf;
    private ImageView nug;
    private TextView nuh;
    private PopupWindow nuk;
    private View nun;
    private RecyclerView nup;
    private RoomInfo nuq;
    private RecyclerView.LayoutManager nus;
    private ArrayList<ChatInfo> nut;
    private ArrayList<ChatInfo> nuu;
    private ArrayList<ChatInfo> nuv;
    private ArrayList<ChatInfo> nuw;
    private FrescoThumbnailView nvA;
    private TextView nvB;
    private TextView nvC;
    private ImageView nvD;
    private RelativeLayout nvE;
    private TextView nvG;
    private float nvH;
    private float nvI;
    private a nvJ;
    private FrescoThumbnailView nva;
    private ValueAnimator nvb;
    private LinearLayout nvc;
    private long nvd;
    private VideoShowVoteView nve;
    private Runnable nvf;
    private FrescoThumbnailView nvh;
    private ImageView nvi;
    private RelativeLayout nvj;
    private TextView nvk;
    private ImageView nvl;
    private EditText nvm;
    private View nvn;
    private RelativeLayout nvo;
    private RelativeLayout nvp;
    private FrescoThumbnailView nvq;
    private TextView nvr;
    private TextView nvs;
    private ImageView nvt;
    private RelativeLayout nvu;
    private LinearLayout nvv;
    private TextView nvw;
    private TextView nvx;
    private RelativeLayout nvy;
    private RelativeLayout nvz;
    private boolean nrc = false;
    private int nui = 1;
    private boolean cO = false;
    private int nuj = 0;
    private int cQ = 0;
    private int nul = -1;
    private boolean nuo = false;
    private FullRoomInfo nur = null;
    private com.kascend.chushou.player.adapter.a nux = null;
    private ArrayList<String> nuy = null;
    private boolean nuz = true;
    private boolean nuH = true;
    private boolean nuI = false;
    public final List<OnlineVipItem> nuK = new ArrayList();
    private boolean nuL = false;
    private boolean nuM = false;
    private long nuO = 0;
    private int nuP = 1;
    private boolean nuQ = false;
    private int nuX = -1;
    private int nuY = -1;
    private boolean dJ = false;
    private int nvg = -1;
    private io.reactivex.disposables.b nvF = null;

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
        this.nqw = getArguments().getString("cover");
        this.nuH = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.nwi = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.nwi;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            aK();
            this.nsS = ((VideoPlayer) this.nwx).dMy();
            this.nww = ((VideoPlayer) this.nwx).dMB();
            dz(view);
            dNB();
            if (this.nwx instanceof VideoPlayer) {
                ((VideoPlayer) this.nwx).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nuI = false;
        if (this.nxb != null) {
            this.nxb.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nuI = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nuD != null) {
            this.nuD.removeAllListeners();
            this.nuD.cancel();
            this.nuD = null;
        }
        if (this.nuG != null) {
            this.nuG.removeAllListeners();
            this.nuG.cancel();
            this.nuG = null;
        }
        if (this.ntT != null) {
            this.ntT.c();
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
        if (this.nvF != null) {
            this.nvF.dispose();
            this.nvF = null;
        }
        this.nui = 1;
        this.cO = false;
        if (this.nwy != null) {
            this.nwy.ch(null);
        }
        if (this.nuk != null) {
            this.nuk.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nwx, this.nrd);
        if (this.nwx != null && (this.nwx instanceof VideoPlayer)) {
            ((VideoPlayer) this.nwx).dMF();
        }
        this.nre = null;
        this.nrd = null;
        aI();
        if (this.ntW != null) {
            this.ntW.a();
        }
        if (this.ntK != null) {
            this.ntK.b();
            this.ntK.c();
            this.ntK = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.ci(this);
        if (this.nuv != null) {
            this.nuv.clear();
        }
        if (this.nut != null) {
            this.nut.clear();
        }
        if (this.nuw != null) {
            this.nuw.clear();
        }
        if (this.nuu != null) {
            this.nuu.clear();
        }
        if (this.nuy != null) {
            this.nuy.clear();
        }
        if (this.nux != null) {
            this.nux.a(0);
            this.nux.a();
        }
    }

    private void dz(View view) {
        this.ntg = view.findViewById(a.f.fl_root);
        this.nuW = tv.chushou.zues.utils.a.gF(this.nwx);
        this.nuj = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nwx);
        this.cQ = tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        this.dD = 86;
        this.nww = ((VideoPlayer) this.nwx).dMB();
        if (this.nww != null) {
            this.nuq = this.nww.dNe();
            this.nur = this.nww.dNb();
        }
        this.nut = new ArrayList<>();
        this.nuv = new ArrayList<>();
        this.nuu = new ArrayList<>();
        this.ntk = (FrameLayout) this.nwi.findViewById(a.f.fl_effect);
        b();
        this.nwr = (PlayerErrorView) this.nwi.findViewById(a.f.view_net_error_msg);
        this.nwr.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.ntJ = (RelativeLayout) this.nwi.findViewById(a.f.rl_audio_ani);
        this.ntK = (PaoPaoView) this.nwi.findViewById(a.f.audio_ani);
        this.ntL = (FrescoThumbnailView) this.nwi.findViewById(a.f.audio_ani_avatar);
        this.ntM = (LinearLayout) this.nwi.findViewById(a.f.ll_audio);
        this.nsF = (TextView) this.nwi.findViewById(a.f.tv_open_video);
        this.ntN = (ImageView) this.nwi.findViewById(a.f.iv_audio_ani);
        this.nva = (FrescoThumbnailView) this.nwi.findViewById(a.f.live_cover);
        if (!this.dJ || this.nsS == null || this.nsS.getPlayState() != 4) {
            this.nva.setVisibility(0);
            this.nva.setBlur(true);
            this.nva.i(this.nqw, 0, 0, 0);
        }
        this.nsF.setOnClickListener(this);
        this.nqa = new b();
        this.nqa.a(view, null, this.nwx, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dZK()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.nww != null) {
                    append.append(c.this.nww.dNe().mRoomID);
                }
                if (c.this.npZ != null && c.this.npZ.nsT != null) {
                    append.append("&mode=").append(c.this.npZ.nsT.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nwx, append.toString());
            }
        });
        this.nqe = (VoiceInteractionView) this.nwi.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.nww != null) {
            this.nuq = this.nww.dNe();
            this.nur = this.nww.dNb();
        }
        dNr();
        dNq();
        dNv();
        this.nvc = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nuR = (FoodView) view.findViewById(a.f.rav_ad);
        this.nvh = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nvi = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nvh.setOnClickListener(this);
        this.nvi.setOnClickListener(this);
        this.nvj = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nuZ = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nuZ.setOnClickListener(this);
        this.ntT = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.ntS = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nuA = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nuA.setOnClickListener(this);
        this.nup = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nup.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nup.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nuW.x, this.nuW.y) * 0.83d);
        this.nup.setLayoutParams(layoutParams);
        this.nus = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nwx);
        this.nup.setLayoutManager(this.nus);
        this.nup.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nup.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nup.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.nuz = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nux = new com.kascend.chushou.player.adapter.a(this.nwx, this.nut);
        if (this.nuq != null) {
            this.nux.a(this.nuq);
        }
        if (com.kascend.chushou.b.dMi().c != null) {
            this.nux.a(com.kascend.chushou.b.dMi().c);
        }
        this.nup.setAdapter(this.nux);
        this.nux.a(this.nut.size());
        this.nux.notifyDataSetChanged();
        if (this.nww != null && (c = this.nww.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.ntW != null) {
            this.ntW.a();
            this.ntW = null;
        }
        this.ntV = (GiftAnimationLayout) this.nwi.findViewById(a.f.ll_gift_animation);
        this.ntV.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.ntf = ((int) (tv.chushou.zues.utils.a.gE(this.nwx).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nwx, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ntV.getLayoutParams();
        layoutParams2.bottomMargin = this.ntf;
        this.ntV.setLayoutParams(layoutParams2);
        if (this.nww != null) {
            this.ntW = new com.kascend.chushou.player.b.a(this.nwx.getApplicationContext(), this.ntV);
            this.ntW.a(this.nww);
            a(this.nww.npF, this.nww.npI);
        }
        this.nwi.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.ntU = (EmbeddedButtonLayout) this.nwi.findViewById(a.f.embedded_button_layout);
        this.ntU.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nve = (VideoShowVoteView) this.nwi.findViewById(a.f.view_video_show_vote);
        this.nve.setOnClickListener(this);
        this.nve.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dNI();
            }
        });
        if (this.nww != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
            this.ntU.a(videoPlayer.dML().dOf());
            this.ntU.b(this.nww.dNd());
            this.ntS.a(videoPlayer.dMH(), false);
            this.ntT.a(videoPlayer.dMI(), videoPlayer.dMJ(), videoPlayer.dMK());
            this.npZ = new com.kascend.chushou.player.e.a();
        }
        this.nxl = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nuL = false;
                c.this.b(c.this.ntf, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nuL = true;
                if (c.this.nxb != null) {
                    c.this.nxb.measure(0, 0);
                    int measuredHeight = c.this.nxb.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nwx, 14.0f);
                    if (measuredHeight > c.this.ntf) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.nxf = (PaoGuideView) this.nwi.findViewById(a.f.rlPaoGuideView);
        this.nuN = (PlayShowMicPerson) this.nwi.findViewById(a.f.rl_mic_person_view);
        this.ntY = (PlayShowH5View) this.nwi.findViewById(a.f.rl_playshowh5);
        this.nuT = (FoodView) this.nwi.findViewById(a.f.bottom_ad);
        if (this.nww != null) {
            H();
            if (this.nww.npz != null && !h.isEmpty(this.nww.npz.mUrl)) {
                b(this.nww.npz);
            }
        }
        this.nuB = this.nwi.findViewById(a.f.view_reminder_subscribe);
        this.nuC = this.nuB.findViewById(a.f.spash_subscribe);
        ((TextView) this.nuB.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.nwx, a.e.videoplayer_reminder_subscribe).append(" ").append(this.nwx.getString(a.i.videoplayer_reminder_subscribe)));
        this.nuB.setOnClickListener(this);
        this.nuE = this.nwi.findViewById(a.f.view_reminder_danmaku);
        this.nuF = this.nuE.findViewById(a.f.spash_danmaku);
        ((TextView) this.nuE.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.nwx, a.e.videoplayer_reminder_danmaku).append(" ").append(this.nwx.getString(a.i.videoplayer_reminder_danmaku)));
        this.nuE.setOnClickListener(this);
    }

    private void dNq() {
        this.nvo = (RelativeLayout) this.nwi.findViewById(a.f.rl_cyclelive);
        this.nvp = (RelativeLayout) this.nwi.findViewById(a.f.rlrl_cyclelive);
        this.nvq = (FrescoThumbnailView) this.nwi.findViewById(a.f.iv_liveicon);
        this.nvr = (TextView) this.nwi.findViewById(a.f.tv_livename);
        this.nvs = (TextView) this.nwi.findViewById(a.f.tv_livedesc);
        this.nvt = (ImageView) this.nwi.findViewById(a.f.iv_cyclelive_name_menu);
        this.nvu = (RelativeLayout) this.nwi.findViewById(a.f.rl_normal);
        this.nvv = (LinearLayout) this.nwi.findViewById(a.f.ll_cyclelive_nickname);
        this.nvw = (TextView) this.nwi.findViewById(a.f.tv_cyclelive_nickname);
        this.nvx = (TextView) this.nwi.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nvy = (RelativeLayout) this.nwi.findViewById(a.f.rl_clear_cyclelive);
        this.nvz = (RelativeLayout) this.nwi.findViewById(a.f.rlrl_clear_cyclelive);
        this.nvA = (FrescoThumbnailView) this.nwi.findViewById(a.f.iv_clear_liveicon);
        this.nvB = (TextView) this.nwi.findViewById(a.f.tv_clear_livename);
        this.nvC = (TextView) this.nwi.findViewById(a.f.tv_clear_livedesc);
        this.nvD = (ImageView) this.nwi.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nvE = (RelativeLayout) this.nwi.findViewById(a.f.rl_clear_normal);
        this.nvD.setOnClickListener(this);
        this.nvt.setOnClickListener(this);
        this.nvx.setOnClickListener(this);
        this.nvw.setOnClickListener(this);
        this.nvq.setOnClickListener(this);
        this.nvA.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nww.npx != null && this.nuT != null) {
            this.nuT.a(true, this.nww.a == null ? "" : this.nww.a);
            this.nuT.a(this.nww.npx, a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nww != null && this.nww.npE != null && this.ntU != null) {
            this.nuR.a(this.nww.npE, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.nww != null) {
                        c.this.nww.npE = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dNJ() {
        return this.ntW;
    }

    private void aK() {
        this.nwy = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.nwi != null && (textView = (TextView) c.this.nwi.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nwx.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nwy.B(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nwy);
                        break;
                    case 12:
                        c.this.b(c.this.nwy);
                        break;
                    case 17:
                        c.this.as();
                        break;
                    case 18:
                        c.this.dAP();
                        break;
                    case 19:
                        c.this.nwv.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nuo) {
            this.nuo = true;
            if (this.nun == null) {
                this.nun = this.nwi.findViewById(a.f.vs_async_show_content);
                this.nun = ((ViewStub) this.nun).inflate();
            }
            this.nqp = this.nwi.findViewById(a.f.ui_content);
            if (this.nrI == null) {
                this.nrI = this.nwi.findViewById(a.f.vs_async_notification_view);
                this.nrI = ((ViewStub) this.nrI).inflate();
            }
            c(this.nwi);
            k();
            ar();
            if (this.c == null) {
                this.npT = new d.a();
                this.c = new GestureDetector(this.nwx, this.npT);
            }
            ((VideoPlayer) this.nwx).q();
        }
    }

    private void dNr() {
        this.ntl = (LinearLayout) this.nwi.findViewById(a.f.ll_anchor);
        this.ntm = (RelativeLayout) this.nwi.findViewById(a.f.ll_clear_anchor);
        this.ntl.setVisibility(4);
        this.ntm.setVisibility(4);
        this.ntn = (FrescoThumbnailView) this.nwi.findViewById(a.f.iv_clear_avatar);
        this.nto = (TextView) this.nwi.findViewById(a.f.tv_clear_nickname);
        this.ntp = (TextView) this.nwi.findViewById(a.f.tv_clear_online_count);
        this.ntq = (TextView) this.nwi.findViewById(a.f.tv_clear_btn_subscribe);
        this.ntq.setOnClickListener(this);
        this.ntr = (FrescoThumbnailView) this.nwi.findViewById(a.f.iv_avatar);
        this.nts = (TextView) this.nwi.findViewById(a.f.tv_nickname_test);
        this.ntt = (TextView) this.nwi.findViewById(a.f.tv_online_count);
        this.nqA = (TextView) this.nwi.findViewById(a.f.tv_btn_subscribe);
        this.nqA.setOnClickListener(this);
        this.ntu = (TextView) this.nwi.findViewById(a.f.tv_loyal_counts);
        this.nqD = (TextView) this.nwi.findViewById(a.f.tv_btn_contribution);
        this.ntv = (TextView) this.nwi.findViewById(a.f.tv_btn_contribution_forpk);
        this.nqD.setVisibility(4);
        this.ntv.setVisibility(8);
        this.ntw = (LinearLayout) this.nwi.findViewById(a.f.ll_mic);
        this.ntx = (PlayShowMicStatusView) this.nwi.findViewById(a.f.show_mic_status);
        this.nty = (RecyclerView) this.nwi.findViewById(a.f.rv_loyal);
        this.ntz = (ImageView) this.nwi.findViewById(a.f.iv_clear_close);
        this.nqJ = (ImageView) this.nwi.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.nty.setLayoutManager(linearLayoutManager);
        this.nuJ = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.nuK, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void C(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.nuK.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nwx, (JSONObject) null, c.this.nww.dNe().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dZW(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nwx, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwx, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwx, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwx, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nwx, a.c.color_979797), dip2px);
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
        this.nty.setAdapter(this.nuJ);
        this.ntw.setOnClickListener(this);
        this.ntn.setOnClickListener(this);
        this.ntz.setOnClickListener(this);
        this.ntr.setOnClickListener(this);
        this.ntn.setOnClickListener(this);
        this.nqJ.setOnClickListener(this);
        this.ntu.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String str = tv.chushou.common.a.dZK() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.nww != null) {
                    str = str + c.this.nww.dNe().mRoomID;
                }
                c.this.f(c.this.nwx.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nqD.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String str = tv.chushou.common.a.dZK() + "m/room-billboard/";
                if (c.this.nww != null) {
                    str = str + c.this.nww.dNe().mRoomID;
                }
                c.this.f(c.this.nwx.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.ntv.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dy(View view) {
                String str = tv.chushou.common.a.dZK() + "m/room-billboard/";
                if (c.this.nww != null) {
                    str = str + c.this.nww.dNe().mRoomID;
                }
                c.this.f(c.this.nwx.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nur == null || this.nur.cycleLiveRoomInfo == null || h.isEmpty(this.nur.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nqc = this.nur.cycleLiveRoomInfo;
        }
        if (z2 && this.nqc != null) {
            this.nvo.setVisibility(0);
            this.nvy.setVisibility(0);
            this.nvu.setVisibility(8);
            this.nvE.setVisibility(8);
            this.nvv.setVisibility(0);
            this.nvA.h(this.nqc.eventIcon, com.kascend.chushou.view.a.a(this.nuq.mCreatorGender), b.a.small, b.a.small);
            this.nvq.h(this.nqc.eventIcon, com.kascend.chushou.view.a.a(this.nuq.mCreatorGender), b.a.small, b.a.small);
            this.nvB.setText(this.nqc.eventName);
            this.nvC.setText(this.nqc.eventDesc);
            this.nvr.setText(this.nqc.eventName);
            this.nvs.setText(this.nqc.eventDesc);
            this.nvw.setText(this.nqc.nickname);
            aN();
            if (z) {
                c(this.nqc.remainTime);
                return;
            }
            return;
        }
        this.nvo.setVisibility(8);
        this.nvy.setVisibility(8);
        this.nvu.setVisibility(0);
        this.nvE.setVisibility(0);
        this.nvv.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nvF != null) {
            this.nvF.dispose();
            this.nvF = null;
        }
        this.nvF = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dST()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nwx != null && (c.this.nwx instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nwx).u();
                }
            }
        });
    }

    private void dNs() {
        if (this.nuq != null && this.nuo) {
            this.ntl.setVisibility(0);
            this.ntm.setVisibility(0);
            this.nqD.setVisibility(0);
            this.ntn.h(this.nuq.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nuq.mCreatorGender), b.a.small, b.a.small);
            this.nto.setText(this.nuq.mCreatorNickname);
            this.ntr.h(this.nuq.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nuq.mCreatorGender), b.a.small, b.a.small);
            this.nts.setText(this.nuq.mCreatorNickname);
            dNR();
            dNt();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dNR() {
        if (this.nuq != null) {
            this.ntp.setText(tv.chushou.zues.utils.b.formatNumber(this.nuq.mOnlineCount));
            this.ntt.setText(tv.chushou.zues.utils.b.formatNumber(this.nuq.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.nqc != null) {
            if (this.nqc.isSubscribe) {
                this.nvx.setText(a.i.like_already);
                this.nvx.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nvx.setText(getString(a.i.like));
            this.nvx.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNt() {
        if (this.nuq != null) {
            if (this.nuq.mIsSubscribed) {
                this.ntq.setText(getString(a.i.like_already));
                this.ntq.setBackgroundResource(a.e.bg_show_subcribe);
                this.nqA.setText(getString(a.i.like_already));
                this.nqA.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.ntq.setText(getString(a.i.like));
            this.ntq.setBackgroundResource(a.e.bg_show_subcribe);
            this.nqA.setText(getString(a.i.like));
            this.nqA.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dNu() {
        if (this.nuJ != null) {
            this.nuJ.notifyDataSetChanged();
        }
    }

    private void dNv() {
        this.ntB = this.nwi.findViewById(a.f.tv_interact);
        this.ntB.setOnClickListener(this);
        this.ntG = (RelativeLayout) this.nwi.findViewById(a.f.rl_edit_bar);
        this.ntE = (ImageView) this.nwi.findViewById(a.f.btn_hotword);
        this.ntE.setOnClickListener(this);
        this.ntF = (ImageView) this.nwi.findViewById(a.f.iv_task_badge);
        this.ntD = (AnimationSet) AnimationUtils.loadAnimation(this.nwx, a.C0824a.anim_hotword);
        this.ntD.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dMp().c) {
                    c.this.ntE.clearAnimation();
                    c.this.ntE.startAnimation(c.this.ntD);
                }
            }
        });
        if (com.kascend.chushou.d.h.dMp().c) {
            this.ntE.startAnimation(this.ntD);
            this.ntF.setVisibility(0);
        }
        this.nvG = (TextView) this.nwi.findViewById(a.f.tv_bottom_input);
        this.nvG.setOnClickListener(this);
        this.nxv = (FrescoThumbnailView) this.nwi.findViewById(a.f.ll_btn_set);
        this.nxv.setOnClickListener(this);
        this.nxv.zR(a.e.ic_room_set_btn_white);
        this.ntP = (LinearLayout) this.nwi.findViewById(a.f.ll_bottom_all_button);
        this.ntQ = (FrescoThumbnailView) this.nwi.findViewById(a.f.fl_clear_bottom_gift);
        this.ntQ.setAnim(true);
        this.ntQ.setOnClickListener(this);
        this.ntQ.zR(a.e.ic_show_gift_n);
        this.ntR = (FrameLayout) this.nwi.findViewById(a.f.flfl_clear_bottom_gift);
        this.ntR.setVisibility(8);
        this.ntC = (RelativeLayout) this.nwi.findViewById(a.f.rl_bottom_input);
        this.ntC.setVisibility(0);
        this.ntH = (PastedEditText) this.nwi.findViewById(a.f.et_bottom_input);
        this.ntH.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nqS.setEnabled(editable.length() > 0);
            }
        });
        this.ntH.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nqS);
                    return true;
                }
                return true;
            }
        });
        this.ntH.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.ntH);
                }
                return false;
            }
        });
        this.nrb = (ImageView) this.nwi.findViewById(a.f.iv_btn_emoji);
        this.nrb.setVisibility(8);
        this.nqS = (TextView) this.nwi.findViewById(a.f.tv_btn_send);
        this.nqS.setOnClickListener(this);
        this.ntZ = (LinearLayout) this.nwi.findViewById(a.f.head_trumpet);
        this.ntZ.setVisibility(8);
        this.ntZ.setOnClickListener(this);
        this.nua = (TextView) this.nwi.findViewById(a.f.tv_primary_name);
        this.nub = (TextView) this.nwi.findViewById(a.f.tv_primary_desc);
        this.nud = (TextView) this.nwi.findViewById(a.f.tv_cut_count);
        this.nud.setOnClickListener(this);
        this.nuf = (TextView) this.nwi.findViewById(a.f.tv_head_count);
        this.nuf.setText(this.nui + "");
        this.nue = (TextView) this.nwi.findViewById(a.f.tv_plus_count);
        this.nue.setOnClickListener(this);
        this.nru = (TextView) this.nwi.findViewById(a.f.tv_buy_count_coin);
        this.nuc = (TextView) this.nwi.findViewById(a.f.tv_buy_head);
        this.nuc.setOnClickListener(this);
        this.nug = (ImageView) this.nwi.findViewById(a.f.iv_trumpet_select);
        this.nug.setOnClickListener(this);
        this.nuh = (TextView) this.nwi.findViewById(a.f.tv_trumpet_have_count);
        this.cO = false;
        this.nug.setBackgroundResource(a.e.ic_trumpet_n);
        this.nuh.setVisibility(8);
        this.nra = (KPSwitchPanelLinearLayout) this.nwi.findViewById(a.f.chat_extended_container);
        dNz();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nra, this.nrb, this.ntH, new a.InterfaceC0960a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0960a
            public void xC(boolean z) {
                if (c.this.nrb != null) {
                    if (z) {
                        c.this.nra.setDirectVisibility(0);
                        c.this.nrb.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nrb.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nre = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void xD(boolean z) {
                c.this.nrc = z;
                if (z) {
                    c.this.nrb.setImageResource(a.e.cs_emoji_normal);
                    c.this.dNx();
                    if (c.this.nvn != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nvn.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gQ(c.this.nwx);
                        c.this.nvn.setLayoutParams(layoutParams);
                    }
                    if (c.this.ntG != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.ntG.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gQ(c.this.nwx);
                        c.this.ntG.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nvn != null && c.this.nvn.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nvn.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nvn.setLayoutParams(layoutParams3);
                    c.this.nvn.setVisibility(8);
                }
                if (c.this.nuL) {
                    c.this.nxb.setVisibility(0);
                }
                if (c.this.nwx != null && (c.this.nwx instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nwx).xB(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.ntG != null && c.this.nra.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.ntG.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.ntG.setLayoutParams(layoutParams4);
                }
            }
        };
        this.nrd = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nra, this.nre, ((VideoPlayer) this.nwx).dMG());
        ((VideoPlayer) this.nwx).h(((VideoPlayer) this.nwx).dMG());
        this.nvn = this.nwi.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nvk = (TextView) this.nwi.findViewById(a.f.btn_room_search);
        this.nvl = (ImageView) this.nwi.findViewById(a.f.iv_room_emoji_delete);
        this.nvm = (EditText) this.nwi.findViewById(a.f.et_room_emoji_search);
        this.nvm.setImeOptions(3);
        this.nvm.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nvk);
                    return true;
                }
                return false;
            }
        });
        this.nvm.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nvk.setEnabled(editable.length() > 0);
                c.this.nvl.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.nxb.setEmojiSearchText(editable.toString());
            }
        });
        this.nvk.setOnClickListener(this);
        this.nvl.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void av(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dK(this.nvm);
            this.nvn.setVisibility(0);
            this.nvm.requestFocus();
        } else {
            this.nvn.setVisibility(8);
        }
        if (z2) {
            this.nvm.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNx() {
        int gQ = tv.chushou.zues.widget.kpswitch.b.d.gQ(this.nwx) + tv.chushou.zues.utils.a.dip2px(this.nwx, 14.0f);
        if (gQ > this.ntf) {
            b(gQ, 12);
        }
    }

    private void dNz() {
    }

    private void dNB() {
        if (this.cQ > 0) {
            View findViewById = this.nwi.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.cQ);
        }
        if (this.nuj > 0) {
            View findViewById2 = this.nwi.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nuj, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nuH) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dNF();
        a();
        this.npV = ((VideoPlayer) this.nwx).dMC();
        this.npV.a(this);
        if (this.nww.dNb() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.npV != null) {
            this.npV.d();
        }
    }

    private void aU() {
        if ((this.npZ == null || this.npZ.nsT == null || !this.npZ.nsT.mInPKMode) ? false : true) {
            if (this.ntg != null) {
                this.ntg.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nqb.getLayoutParams();
            layoutParams.leftMargin = (this.nuW.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nwx, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.nqb.setLayoutParams(layoutParams);
            this.y.setText(this.npZ.nsT.mPkUserNickname);
            this.nqb.setVisibility(0);
            this.ntw.setVisibility(8);
            return;
        }
        if (this.ntg != null) {
            this.ntg.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.nqb.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.npZ != null && this.npZ.nsT != null && this.npZ.nsT.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nvg > 0 && this.nup != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nup.getLayoutParams();
                if (layoutParams.height != this.nvg) {
                    layoutParams.height = this.nvg;
                    this.nup.setLayoutParams(layoutParams);
                }
            }
            this.ntf = ((int) (tv.chushou.zues.utils.a.gE(this.nwx).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nwx, 84.0f);
            b(this.ntf, 12);
        } else {
            if (this.nup != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nup.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nwx, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nwx, 250.0f);
                    this.nup.setLayoutParams(layoutParams2);
                }
            }
            this.ntf = ((int) (tv.chushou.zues.utils.a.gE(this.nwx).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nwx, 84.0f);
            b(this.ntf, 12);
        }
        if (this.nqa != null) {
            this.nqa.a(this.nvg + tv.chushou.zues.utils.a.dip2px(this.nwx, 52.0f), this.aq);
        }
        if (this.nqe != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nqe.getLayoutParams();
            layoutParams3.bottomMargin = this.nvg + tv.chushou.zues.utils.a.dip2px(this.nwx, 52.0f);
            this.nqe.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dNE();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dNE();
    }

    private void dND() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNE() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dOa().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.nuW = tv.chushou.zues.utils.a.gF(this.nwx);
        this.dD = 86;
        this.nuV = (Math.max(this.nuW.x, this.nuW.y) - tv.chushou.zues.utils.a.dip2px(this.nwx, (this.dD + 52) + 250)) - this.nuj;
        this.dC = Math.max(this.nuW.x, this.nuW.y) - ((tv.chushou.zues.utils.a.dip2px(this.nwx, this.dD) + this.nuj) * 2);
        if (this.nuX <= 0 || this.nuY <= 0) {
            this.nuX = Math.min(this.nuW.x, this.nuW.y);
            this.nuY = Math.max(this.nuW.x, this.nuW.y);
        }
        this.ar = Math.min(this.nuW.x, this.nuW.y);
        this.aq = (this.ar * this.nuY) / this.nuX;
        boolean z = false;
        if (this.npZ == null || this.npZ.nsT == null) {
            i = 1;
        } else {
            i = this.npZ.nsT.mMode;
            if (this.npZ.nsT.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.dD = 42;
            if (i == 2) {
                if (this.nuY < this.nuX) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nuX * layoutParams.height) / this.nuY;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, this.dD) + this.nuj;
            layoutParams.gravity = 48;
            this.nvg = ((this.nuW.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nwx, (this.dD + 52) + 64) + this.nuj)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            dNo();
        } else if (this.E) {
            this.dD = 42;
            if (this.nuY < this.nuX) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nuX * layoutParams.height) / this.nuY;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, this.dD) + this.nuj;
            layoutParams.gravity = 48;
            this.nvg = ((this.nuW.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nwx, (this.dD + 52) + 98) + this.nuj)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
            dND();
        } else {
            this.nvg = -1;
            this.dD = 86;
            if (this.aq <= this.nuV) {
                layoutParams.width = this.ar;
                layoutParams.height = this.nuV;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, this.dD) + this.nuj;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.dC) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, this.dD) + this.nuj;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nuW.x, this.nuW.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nuX) / this.nuY >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nuX) / this.nuY;
                    } else if ((this.ar * this.nuY) / this.nuX >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nuY) / this.nuX;
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
                    if ((this.ar * this.nuY) / this.nuX > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nuX) / this.nuY;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nuY) / this.nuX;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nuY) / this.nuX;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nuX) / this.nuY;
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
        if (this.nww != null && this.nww.d) {
            layoutParams.width = Math.min(this.nuW.x, this.nuW.y);
            layoutParams.height = Math.max(this.nuW.x, this.nuW.y);
        }
        dOa().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dNF() {
        this.N = new SurfaceRenderView(this.nwx);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dOa().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nuQ) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dNU();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dNT();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nvJ != null) {
            this.nvJ.a();
        }
        if (this.nww != null && !h.isEmpty(this.nww.w)) {
            b(this.nww.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nsS != null) {
            int width = this.nsS.getWidth();
            int height = this.nsS.getHeight();
            if (this.nuX != width || this.nuY != height || this.nuX <= 0 || this.nuY <= 0) {
                this.nuX = width;
                this.nuY = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dNE();
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
            if (this.nuL) {
                dNH();
            } else {
                if (this.nwx.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击送礼_num", "竖屏", new Object[0]);
                if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nww.dNb().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.cO) {
                f(this.ntH.getText().toString());
            } else {
                a(this.ntH.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dMp().c) {
                com.kascend.chushou.d.h.dMp().b(false);
                this.ntD.cancel();
                this.ntD.reset();
                this.ntE.clearAnimation();
                this.ntF.setVisibility(8);
            }
            o(view, 0, this.nwi.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nwx, 165.0f) / 2);
            n(view, x >= 0 ? x : 0, this.nwi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.nww.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.nww.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nup != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nuq != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nuP = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nwx, (JSONObject) null, this.nww.dNe().mRoomID, this.nww.dNe().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.nwx.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nwx, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nuS != null) {
                    com.kascend.chushou.d.e.a(this.nwx, this.nuS, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nvj != null) {
                    this.nvj.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nwx, null) && this.nww != null && this.nww.npH != null) {
                    if (this.cO) {
                        dNY();
                    } else {
                        if (this.nww != null && this.nww.npH != null && this.nww.npH.count > 0) {
                            this.ntZ.setVisibility(8);
                        } else {
                            this.ntZ.setVisibility(0);
                        }
                        this.cO = true;
                        this.nug.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nuh.setVisibility(0);
                        this.nuh.setSelected(true);
                        this.nuh.setTextColor(Color.parseColor("#ff5959"));
                        if (this.ntH != null) {
                            this.ntH.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nui <= 9) {
                    this.nui++;
                    this.nuf.setText(this.nui + "");
                }
                dNp();
            } else if (id == a.f.tv_cut_count) {
                if (this.nui > 1) {
                    this.nui--;
                    this.nuf.setText(this.nui + "");
                }
                dNp();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nvm.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nvm.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nvn.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dL(this.nvm);
                    this.nxb.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nqc != null && !h.isEmpty(this.nqc.eventUrl)) {
                    f("", this.nqc.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nqc != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nqc != null) {
                    com.kascend.chushou.d.a.a(this.nwx, (JSONObject) null, this.nqc.roomId, this.nqc.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.nww.a(false);
                    ((VideoPlayer) this.nwx).l();
                } else {
                    ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNI() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.ntY != null) {
            int i = (tv.chushou.zues.utils.a.gE(this.nwx).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ntY.getLayoutParams();
            layoutParams.topMargin = i;
            this.ntY.setLayoutParams(layoutParams);
            this.ntY.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.ntY.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
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
        } else if (System.currentTimeMillis() - this.nuO <= 3000) {
            tv.chushou.zues.utils.g.Mc(a.i.str_too_fast);
            return false;
        } else {
            dAU();
            if (!com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a(((VideoPlayer) this.nwx).dMB().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nuO = System.currentTimeMillis();
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                a(this.nww.dNb().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nww.h);
            }
            g(this.b);
            if (!z && this.ntH != null) {
                this.ntH.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dAU();
            if (com.kascend.chushou.d.e.c(this.nwx, null) && LoginManager.Instance().getUserInfo() != null && this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                a(this.nww.dNb().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.ntH != null) {
                this.ntH.setText((CharSequence) null);
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
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nww.dNb().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nww.dNb().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nwx).nnU;
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
        if (this.nwW != null && this.nwW.isShowing()) {
            this.nwW.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
        if (this.nxs == null) {
            i(3);
        }
        this.nxs.getContentView().setBackgroundResource(0);
        this.nxs.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.nxs.isShowing()) {
            this.nxs.showAtLocation(view, 83, i, i2);
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nww.dNb().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.nxs.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dNA() {
        if (h.isEmpty(this.nxw)) {
            if (((VideoPlayer) this.nwx).q) {
                this.nxv.zR(a.e.ic_room_set_btn_white);
            } else {
                this.nxv.zR(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nwx).q && this.nxw.size() == 2 && this.nxw.contains("4") && this.nxw.contains("2")) {
            this.nxv.zR(a.e.ic_room_set_btn_system_white);
        } else if (this.nxw.size() > 1 || !((VideoPlayer) this.nwx).q) {
            this.nxv.zR(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.nxw.get(0))) {
            this.nxv.zR(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.nxw.get(0))) {
            this.nxv.zR(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.nxw.get(0))) {
            this.nxv.zR(a.e.ic_room_set_btn_system_white);
        }
    }

    private void o(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
        if (this.nwW == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.nwW.getContentView().setBackgroundResource(0);
            this.nwW.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nwW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.ntE.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.nwW.isShowing()) {
            this.nwW.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nwx, 16.0f) + i2);
            this.ntE.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nww.dNb().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nwW.dismiss();
    }

    private void dA(View view) {
        if (this.nwQ == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.dMp().q()) {
            this.ntI.dZU();
        } else {
            this.ntI.dZV();
        }
        int height = this.nwi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity());
        if (view != null) {
            this.nwQ.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.nwQ == null) {
            View inflate = LayoutInflater.from(this.nwx).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.ntI = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dMp().q()) {
                this.ntI.dZU();
            } else {
                this.ntI.dZV();
            }
            this.ntI.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dMp().g(z);
                }
            });
            this.nwK = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nwL = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nwK.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nwK.setVisibility(0);
            } else {
                this.nwK.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dMp().a) {
                this.nwL.b();
            } else {
                this.nwL.c();
            }
            if (this.nww != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.nww.f;
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
                                if (this.npZ == null || !this.npZ.nsT.mInPKMode || h.isEmpty(this.npZ.b) || this.nuq == null || !this.npZ.b.equals(this.nuq.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nwx).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dNc = this.nww.dNc();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nwx).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwx, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, 5.0f);
                                            }
                                            int identifier = this.nwx.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nwx.getPackageName());
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
                                                if (dNc != null && dNc.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nwx.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nwx).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dNc2 = this.nww.dNc();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nwx).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nwx, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, 5.0f);
                                        }
                                        int identifier2 = this.nwx.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nwx.getPackageName());
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
                                            if (dNc2 != null && dNc2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.nwQ.dismiss();
                    }
                }
            });
            this.nwQ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 150.0f), -2);
            this.nwQ.setFocusable(true);
            this.nwQ.setOutsideTouchable(true);
            this.nwQ.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nwQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nwQ = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
            if (this.ntX == null) {
                this.ntX = new f(getActivity());
            }
            this.ntX.a(this.nww.dNb().mRoominfo, this.ax);
            if (!this.ntX.isShowing()) {
                this.ntX.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nuQ) {
            return false;
        }
        if (this.nuP == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nvH = motionEvent.getX();
                    this.nvI = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nvH;
                    if (Math.abs(f) > Math.abs(y - this.nvI) && Math.abs(f) > q && f > 0.0f) {
                        bj();
                        return true;
                    }
                    this.nvH = 0.0f;
                    this.nvI = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nvn != null && this.nvn.getVisibility() == 0 && b(motionEvent, this.nvn)) {
                this.nvn.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.nvm);
                return true;
            } else if (this.nuL && this.nvn != null && this.nvn.getVisibility() == 8 && f(this.nxb.b, motionEvent)) {
                dNH();
                return true;
            } else if (this.ntY != null && this.ntY.b() && f(this.ntY, motionEvent)) {
                this.ntY.a();
                return true;
            } else if (this.ntO != null && this.ntO.b() && f(this.ntO, motionEvent)) {
                this.ntO.a();
                return true;
            } else if (b(motionEvent, this.ntG)) {
                return dAU();
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
            if (this.nxm != null && this.nxm.a(i, keyEvent)) {
                return true;
            }
            if ((this.ntY != null && this.ntY.onKeyDown(i, keyEvent)) || az()) {
                return true;
            }
            if (this.nuP == 3) {
                this.nuP = 1;
                bj();
                return true;
            } else if (this.ntO != null && this.ntO.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.ntH != null && this.ntC != null && this.ntG != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.ntH);
                this.ntC.setVisibility(8);
                this.ntG.setVisibility(0);
            }
        } else if (this.ntC != null && this.ntG != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
            this.ntC.setVisibility(0);
            this.ntG.setVisibility(8);
        }
    }

    public boolean dAU() {
        boolean z;
        b(this.ntf, 12);
        boolean z2 = false;
        if (this.nra != null && this.nra.getVisibility() == 0) {
            this.nra.setVisibility(8);
            this.nrb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nrc) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nwx);
            this.nrb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.ntG == null || this.ntG.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.cO) {
                dNY();
            }
            this.ntG.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ntC != null) {
                    c.this.ntC.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean az() {
        if (dAU()) {
            return true;
        }
        if (this.nwW != null && this.nwW.isShowing()) {
            this.nwW.dismiss();
            return true;
        } else if (this.nxs != null && this.nxs.isShowing()) {
            this.nxs.dismiss();
            return true;
        } else if (this.nwQ == null || !this.nwQ.isShowing()) {
            return dNH() || dNy() || dNG() || dNn();
        } else {
            this.nwQ.dismiss();
            return true;
        }
    }

    public boolean dNn() {
        if (this.nxf == null || !this.nxf.isShown()) {
            return false;
        }
        this.nxf.d();
        return true;
    }

    public boolean dNy() {
        if (this.nuN == null || !this.nuN.isShown()) {
            return false;
        }
        this.nuN.a();
        return true;
    }

    public boolean dNG() {
        if (this.ntY == null || !this.ntY.b()) {
            return false;
        }
        this.ntY.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nwx != null && !((Activity) this.nwx).isFinishing() && pVar != null) {
            this.nuy = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nuq != null && mVar.a(this.nuq.mCreatorUID, null)) {
            this.nuq.mIsSubscribed = mVar.c;
            dNt();
        }
    }

    public boolean dNH() {
        if (!this.nuL || this.nxb == null) {
            return false;
        }
        if (this.nxb != null) {
            this.nxb.e();
        }
        if (this.nvm != null) {
            this.nvm.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nuU != null) {
                        this.nuU.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                        this.nww.dNb().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nww.dNb().mMicStatus.onMic) {
                            if (this.ntw != null) {
                                this.ntw.setVisibility(8);
                            }
                            if (this.nuN != null && this.nuN.isShown()) {
                                this.nuN.a();
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
                        if (this.nww.dNb().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nuq != null && !h.isEmpty(this.nuq.mCreatorUID)) {
                                g(arrayList2, this.nuq.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.nww.dNb().mMicStatus.onMic) {
                            if (this.nww.dNb().mMicStatus != null && !h.isEmpty(this.nww.dNb().mMicStatus.micRoomId) && !this.nww.dNb().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.nww.dNb().mMicStatus.micRoomId;
                            }
                            this.nww.dNb().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nww.dNb().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.nww.dNb().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.nww.dNb().mMicStatus, str3, z4);
                            if (this.nuN != null && this.nuN.getVisibility() == 0) {
                                this.nuN.a(this.nww.dNb().mFanItems, this.nww.dNb().mMicStatus, str3, z4, this.nww.dNb().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.ntw != null) {
                                this.ntw.setVisibility(8);
                            }
                            if (this.nuN != null && this.nuN.isShown()) {
                                this.nuN.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nul != onlineVip.mCount || (this.ntu != null && this.ntu.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nul = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dNL();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.nuK.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.nuK.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.nuK.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.nvd <= 5000) {
                                z2 = false;
                            } else {
                                this.nvd = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.nuK.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.nuK.addAll(onlineVip.mOnlineVipItems);
                            }
                            dNu();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nve != null) {
                    if (this.nuq == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nuq.mCreatorAvatar;
                        str2 = this.nuq.mCreatorGender;
                    }
                    this.nve.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.npZ != null && this.npZ.nsT != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.npZ.nsT.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.npV != null) {
                                        this.npV.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.npZ.nsT.mInPKMode = true;
                                    this.npZ.nsT.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npZ.nsT.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npZ.nsT.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npZ.nsT.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npZ.nsT.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npZ.nsT.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.npZ.nsT.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.npZ.nsT.mMode = pkNotifyInfo.mMode;
                                    this.npZ.nsT.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.nqa != null) {
                                        this.nqa.g(true, this.npZ.nsT.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dMp().a) {
                                        if (!com.kascend.chushou.b.dMi().e) {
                                            com.kascend.chushou.b.dMi().e = true;
                                            tv.chushou.zues.utils.g.F(this.nwx, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dMp().a(this.nwx, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.npZ.nsT.mAction = 7;
                                    this.npZ.nsT.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.npZ.nsT.mPkUid = pkNotifyInfo.mPkUid;
                                    this.npZ.nsT.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.npZ.nsT.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.npZ.nsT.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.npZ.nsT.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.npZ.nsT.mMode == 2) {
                                        dNE();
                                    } else {
                                        dNo();
                                    }
                                    if (this.nqa != null) {
                                        this.nqa.g(false, 0L);
                                        this.nqa.b(this.npZ.nsT, true);
                                        this.nqa.a(this.nvg + tv.chushou.zues.utils.a.dip2px(this.nwx, 52.0f), this.aq);
                                        this.nqa.a(this.npZ.nsT.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.npV != null) {
                                        this.npV.a(false);
                                    }
                                    this.npZ.nsT.mInPKMode = false;
                                    this.npZ.nsT.mAction = 2;
                                    dNo();
                                    dNE();
                                    if (this.nqa != null) {
                                        this.nqa.c();
                                    }
                                    this.npZ.b = null;
                                    this.npZ.nsT = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.npZ.nsT.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.npZ.nsT.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.npZ.nsT.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nuq != null && !h.isEmpty(this.nuq.mRoomID) && this.nuq.mRoomID.equals(this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.npZ.nsT.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.nqa != null) {
                                        this.nqa.a(this.npZ.nsT, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.npZ.nsT.copyUpdate(pkNotifyInfo);
                                    if (this.nqa != null) {
                                        this.nqa.a(this.npZ.nsT);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.npZ.nsT.copyStop(pkNotifyInfo);
                                        if (this.nqa != null) {
                                            this.nqa.B(this.npZ.nsT.mMaxFreeDuration, this.npZ.nsT.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.npZ.nsT.copyResult(pkNotifyInfo);
                                    if (!this.nuI && this.nqa != null) {
                                        int i7 = 1;
                                        if (this.npZ.nsT.destinyInfo != null && this.npZ.nsT.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.nqa.a(h.parseInt(this.npZ.nsT.mResult), h.parseLong(this.npZ.nsT.mvpUid), this.npZ.nsT.mvpAvatar, this.npZ.nsT.mvpNickname, this.npZ.nsT.mMaxFreeDuration, this.npZ.nsT.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nqc != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nqc.uid = cycleLiveRoomInfo.uid;
                        this.nqc.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nqc.roomId = cycleLiveRoomInfo.roomId;
                        this.nqc.avatar = cycleLiveRoomInfo.avatar;
                        this.nqc.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nwx != null && (this.nwx instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nwx).d();
                        }
                    } else {
                        ((VideoPlayer) this.nwx).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.nww != null && this.nww.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dMp().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dMp().b().equals(next2.mUserID)) {
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

    public void dNL() {
        if (this.ntu != null) {
            if (this.npZ == null || this.npZ.nsT == null || !this.npZ.nsT.mInPKMode) {
                if (this.bP > 0) {
                    this.ntu.setVisibility(0);
                    this.ntu.setText(String.format(this.nwx.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.nty.setVisibility(0);
                    return;
                }
                this.ntu.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.ntw.setVisibility(0);
            if (this.ntx != null) {
                this.ntx.a(str, z, micStatus, this.nww.dNb().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.ntw.setVisibility(8);
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
        int childCount = this.nus.getChildCount();
        int itemCount = this.nus.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nus);
        if (f + childCount >= itemCount) {
            this.nuz = true;
            if (this.nuA != null) {
                this.nuA.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dNO() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nut.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nut.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nut == null) {
            this.nut = new ArrayList<>();
        }
        while (2 < this.nut.size()) {
            this.nut.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nuv);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nut.addAll(a2);
        int size = this.nut.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nut.size(); i++) {
                this.nut.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nuw == null) {
            this.nuw = new ArrayList<>();
        }
        this.nuw.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nuy != null && this.nuy.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nuy.contains("2"))) {
                        this.nuw.add(next);
                    } else if (!this.nuy.contains(next.mType)) {
                        this.nuw.add(next);
                    }
                }
                return this.nuw;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nut == null) {
                    this.nut = new ArrayList<>(arrayList);
                    dNO();
                    w(z2);
                    return;
                }
                if (this.nuv == null) {
                    this.nuv = new ArrayList<>();
                }
                this.nuv.addAll(arrayList);
                int size = this.nuv.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.nuv.size(); i++) {
                        this.nuv.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nut.size();
                if (a2 != null) {
                    this.nut.addAll(a2);
                }
                int size3 = this.nut.size();
                if (!this.nuz && this.nuA != null) {
                    this.nuA.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nut.size(); i3++) {
                        this.nut.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nut == null) {
                this.nut = new ArrayList<>(arrayList);
                dNO();
            } else {
                if (this.nuv == null) {
                    this.nuv = new ArrayList<>();
                }
                this.nuv.clear();
                this.nuv.addAll(arrayList);
                this.nut.clear();
                dNO();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nut.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nux != null) {
                this.nux.a(this.nut.size());
                if (i == 1) {
                    this.nux.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nux.notifyItemRangeRemoved(i2, i3);
                    this.nux.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nux.notifyDataSetChanged();
                }
            }
            if (z || this.nuz) {
                this.nuz = true;
                if (this.nuA != null) {
                    this.nuA.setVisibility(8);
                }
                if (z) {
                    this.nup.scrollToPosition(this.nut.size() - 1);
                } else {
                    this.nup.smoothScrollToPosition(this.nut.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nux != null) {
                this.nux.a(this.nut.size());
                this.nux.notifyDataSetChanged();
            }
            if (z || this.nuz) {
                this.nuz = true;
                if (this.nuA != null) {
                    this.nuA.setVisibility(8);
                }
                if (z) {
                    this.nup.scrollToPosition(this.nut.size() - 1);
                } else {
                    this.nup.smoothScrollToPosition(this.nut.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dMM;
        RoomToast roomToast;
        this.p = false;
        if (this.nww != null && this.nww.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.nww.f.size()) {
                    break;
                } else if (!"2".equals(this.nww.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dNS();
            return;
        }
        if (this.nqp != null) {
            this.nqp.setVisibility(0);
        }
        if (this.ntk != null) {
            this.ntk.setVisibility(0);
        }
        if (this.nww != null) {
            this.nuq = this.nww.dNe();
            this.nur = this.nww.dNb();
            if (com.kascend.chushou.b.dMi().c != null && this.nux != null) {
                this.nux.a(com.kascend.chushou.b.dMi().c);
                this.nux.notifyDataSetChanged();
            }
            FullRoomInfo dNb = this.nww.dNb();
            if (dNb != null) {
                if (!h.isEmpty(dNb.mRoomToastList)) {
                    Iterator<RoomToast> it = dNb.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dMp().j())) {
                    a(roomToast);
                }
            }
            if (this.nuq != null) {
                dNV();
            }
            if (this.nuq != null && !this.nuq.mIsSubscribed) {
                RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nuq == null || !c.this.nuq.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.nww != null && this.nww.l()) {
                d(true);
            }
        }
        if (this.nuq != null && this.nux != null) {
            if (this.nut != null) {
                this.nut.clear();
            } else {
                this.nut = new ArrayList<>();
            }
            this.nux.a(this.nuq);
            dNO();
            this.nux.a(this.nut.size());
            this.nux.notifyDataSetChanged();
        }
        dNs();
        N();
        if (this.nwx != null && (this.nwx instanceof VideoPlayer) && (dMM = ((VideoPlayer) this.nwx).dMM()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dMM.nsT, dMM.b);
        }
        this.ntL.h(this.nuq.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nuq.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.ntP);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.nuk == null) {
            View inflate = LayoutInflater.from(this.nwx).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.nrF = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nuk = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nwx, 160.0f), -2);
            this.nuk.setFocusable(false);
            this.nuk.setOutsideTouchable(false);
            this.nuk.setAnimationStyle(a.j.gift_toast_style);
            this.nuk.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dMp().c(roomToast.mToastContent);
            if (this.nuk == null) {
                bd();
            }
            if (this.nrF != null) {
                this.nrF.setText(roomToast.mToastContent);
            }
            if (!this.nuk.isShowing()) {
                if (this.ntP != null) {
                    this.nuk.showAtLocation(this.ntP, 85, 0, this.nwi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.ax(getActivity()));
                    RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nuk != null) {
                                c.this.nuk.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nuk.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nva != null) {
            this.nva.setVisibility(z ? 0 : 8);
        }
        this.dJ = true;
        if (this.nwx instanceof VideoPlayer) {
            ((VideoPlayer) this.nwx).p();
        }
    }

    private void dNS() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nwx).s();
        dNn();
        dNy();
        if (this.ntA == null) {
            this.ntA = (PlayShowRecommendView) ((ViewStub) this.nwi.findViewById(a.f.view_recommend)).inflate();
        }
        this.ntA.setVisibility(0);
        if (this.nww.dNb() != null && this.nww.dNb().mRoominfo != null && !h.isEmpty(this.nww.dNb().mRoominfo.mRoomID)) {
            dNM();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nxb != null) {
            this.nxb.e();
        }
        if (this.nqp != null) {
            this.nqp.setVisibility(4);
        }
        if (this.ntk != null) {
            this.ntk.setVisibility(8);
        }
        if (this.nxj != null) {
            this.nxj.dZr();
            this.nxj.setVisibility(8);
        }
        m(false);
        a(false, false);
        if (this.npV != null) {
            this.npV.a();
        }
    }

    private void dNM() {
        if (this.ntA != null && this.ntA.getVisibility() == 0) {
            this.ntA.a(this.nww.dNb().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dNC() {
        super.dNC();
        if (this.nwx instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.ntY != null && this.ntY.b()) {
            this.ntY.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nuM);
        if (this.nwx != null) {
            if (this.nuM || "10004".equals(((VideoPlayer) this.nwx).t)) {
                this.nuM = true;
                if (this.nww != null) {
                    this.nww.f = null;
                    if (this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                        this.nww.dNb().mRoominfo.mGameId = null;
                    }
                }
                dNS();
                return;
            }
            this.nuM = true;
            if (this.nwx != null) {
                ((VideoPlayer) this.nwx).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nuM = false;
        if (this.nqp != null) {
            this.nqp.setVisibility(0);
        }
        if (this.ntk != null) {
            this.ntk.setVisibility(0);
        }
        if (this.ntA != null) {
            this.ntA.setVisibility(8);
        }
        if (this.nwr != null) {
            this.nwr.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nuM = false;
        if (this.nqp != null) {
            this.nqp.setVisibility(0);
        }
        if (this.ntk != null) {
            this.ntk.setVisibility(0);
        }
        if (this.ntA != null) {
            this.ntA.setVisibility(8);
        }
        if (this.nwr != null) {
            this.nwr.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.ntA != null) {
            this.ntA.setVisibility(8);
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
                    if (this.nww != null) {
                        this.nww.f = null;
                        this.nww.dNb().mRoominfo.mGameId = null;
                    }
                    dNS();
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
        if (this.nww != null && this.nww.dNc() != null) {
            a(this.nww.dNc());
        }
        this.p = false;
        if (this.nww == null || this.nww.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nww.f.size()) {
                if (!"2".equals(this.nww.f.get(i2).mType)) {
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
    public GiftAnimationLayout dNw() {
        if (this.nwi == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nwi.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.ntP != null) {
            int size = iconConfig.configs.size();
            this.ntP.removeAllViews();
            if (this.ntR != null) {
                this.ntR.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nwx).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.ntP, false);
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
                            this.ntR.setVisibility(0);
                            this.ntQ.bS(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.ntP.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (this.nwx instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dMH = ((VideoPlayer) this.nwx).dMH();
            if (this.nxm == null) {
                this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxm.setVisibility(0);
            this.nxm.a(2, dMH);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.ntT != null && this.nwx != null) {
            this.ntT.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.ntT != null && this.nwx != null) {
            this.ntT.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (this.ntT != null) {
            this.ntT.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (this.ntT != null) {
            this.ntT.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.ntS != null) {
            if (this.nwx != null) {
                this.ntS.a(((VideoPlayer) this.nwx).dMH(), false);
            }
            this.ntS.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nwi != null) {
            Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
            int i = gE.x > gE.y ? 1 : 2;
            if (this.nxm == null) {
                this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nxm.setPlayerViewHelper(this.nww);
            this.nxm.setVisibility(0);
            this.nxm.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.ntU != null) {
            this.ntU.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.ntU != null) {
            this.ntU.a(bangInfo, str);
        }
        if (this.nqD != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nqD.setText(this.nwx.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nqD.setText(this.nwx.getString(a.i.str_contribute_tittle));
            } else {
                this.nqD.setText(Html.fromHtml(this.nwx.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.ntv != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.ntv.setText(this.nwx.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.ntv.setText(this.nwx.getString(a.i.str_contribute_tittle));
            } else {
                this.ntv.setText(Html.fromHtml(this.nwx.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.ntU != null) {
            this.ntU.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nww != null && !h.isEmpty(this.nww.npG)) {
            this.nuS = this.nww.npG.get(0);
            if (this.nvh != null) {
                this.nvh.setVisibility(0);
                this.nvh.a(this.nuS.mCover, 0, 0, 0, 1);
                if (this.nvi != null) {
                    if (this.nuS.mShowClose) {
                        this.nvi.setVisibility(0);
                    } else {
                        this.nvi.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.ntU != null) {
            this.ntU.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nwi != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nra != null) {
            this.nra.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nuI) {
            if (iVar.a == 52) {
                if (this.nux != null) {
                    this.nux.a(com.kascend.chushou.b.dMi().c);
                    this.nux.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nuI && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.ntH != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.ntH);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nuI) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nwx, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dMI = ((VideoPlayer) this.nwx).dMI();
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(2, dMI);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dMJ = ((VideoPlayer) this.nwx).dMJ();
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(2, dMJ);
            } else if (bVar.a == 8) {
                if (this.nuU != null && this.nuU.getVisibility() != 0) {
                    this.nuU.a(a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, this.nuq == null ? "" : this.nuq.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.nxm == null) {
                    this.nxm = (H5Container) ((ViewStub) this.nwi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nxm.setVisibility(0);
                this.nxm.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.nww != null && !h.isEmpty(this.nww.a) && this.nww.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nuU != null && this.nuU.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nwx, 80.0f);
                }
                if (this.nuT != null && this.nuT.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nuT.getHeight());
                }
                this.nvc.setTranslationY(-r0);
                return;
            }
            if (this.nvb != null) {
                this.nvb.cancel();
                this.nvb = null;
            }
            int translationY = (int) this.nvc.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nwx, 80.0f) : 0;
                    if (this.nuT != null && this.nuT.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nuT.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nuT.getHeight() : 0;
                    if (this.nuU != null && this.nuU.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nwx, 80.0f));
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
        this.nvb = ValueAnimator.ofInt(i, i2);
        this.nvb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.ntU != null) {
                    c.this.nvc.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nvb.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nvb = null;
            }
        });
        this.nvb.setInterpolator(new LinearInterpolator());
        this.nvb.setDuration(800L);
        this.nvb.start();
    }

    private boolean dNT() {
        if (this.nuP == 1) {
            this.nuP = 2;
            x(true);
            return true;
        } else if (this.nuP == 3) {
            bj();
            return true;
        } else {
            return false;
        }
    }

    private boolean dNU() {
        if (this.nuP == 1) {
            return bi();
        }
        if (this.nuP == 2) {
            this.nuP = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nuQ || this.nww == null || this.nww.dNe() == null) {
            return false;
        }
        if (this.nvJ != null) {
            this.nvJ.a(true);
        }
        this.nuP = 3;
        this.nuQ = true;
        dNV();
        this.nth.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nuQ = false;
                c.this.ntj.setVisibility(8);
            }
        });
        this.ntj.startAnimation(loadAnimation);
        this.nth.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj() {
        if (!this.nuQ) {
            if (this.nvJ != null) {
                this.nvJ.a(false);
            }
            this.nuP = 1;
            this.nuQ = true;
            dNV();
            this.ntj.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nuQ = false;
                    c.this.nth.setVisibility(8);
                }
            });
            this.ntj.startAnimation(loadAnimation);
            this.nth.startAnimation(loadAnimation2);
        }
    }

    private void dNV() {
        if (this.nwi != null) {
            if (this.nth == null) {
                this.nth = this.nwi.findViewById(a.f.user_space_container);
            }
            if (this.ntj == null) {
                this.ntj = this.nwi.findViewById(a.f.video_container);
            }
            if (this.nti == null) {
                this.nti = com.kascend.chushou.view.user.b.b(null, this.nww.a, false, this.nww.h);
                this.nti.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
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
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.nti).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.ntk != null) {
            this.ntk.setVisibility(z ? 8 : 0);
        }
        if (this.nun != null) {
            this.nuQ = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nun.setVisibility(8);
                        c.this.nuQ = false;
                    }
                });
            } else {
                this.nuQ = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nun.setVisibility(0);
                        c.this.nuQ = false;
                    }
                });
            }
            this.nun.startAnimation(loadAnimation);
        }
        az();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.ntB.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.ntJ != null) {
                this.ntJ.setVisibility(0);
            }
            if (this.ntK != null) {
                this.ntK.a();
                return;
            }
            return;
        }
        if (this.ntM != null) {
            this.ntM.setVisibility(0);
        }
        if (this.ntN != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.ntN.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.ntM != null) {
            this.ntM.setVisibility(8);
        }
        if (this.ntN != null) {
            this.ntN.clearAnimation();
        }
        if (this.ntJ != null) {
            this.ntJ.setVisibility(8);
        }
        if (this.ntK != null) {
            this.ntK.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nun != null && this.nwi != null) {
            if (this.nuU == null) {
                this.nuU = new com.kascend.chushou.player.ui.miniview.a(this.nwx, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nuU != null && c.this.nwi != null && c.this.nuU.a()) {
                            ((ViewGroup) c.this.nwi).removeView(c.this.nuU);
                            c.this.nuU = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nuU.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nwx, 52.0f);
                this.nuU.setLayoutParams(layoutParams);
                ((ViewGroup) this.nun).addView(this.nuU, ((ViewGroup) this.nun).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nuU.setVisibility(8);
                } else {
                    this.nuU.a(a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, this.nww.a == null ? "" : this.nww.a);
                }
            } else if (!this.nuU.isShown()) {
                this.nuU.a(a.C0824a.slide_in_bottom_danmu_anim, a.C0824a.slide_out_bottom_danmu_anim, this.nww.a == null ? "" : this.nww.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nuZ != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nuZ.setVisibility(0);
                this.nuZ.setAnim(true);
                this.nuZ.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.ouG, b.C0959b.ouI, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nuB != null && this.nuB.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dNW();
                    }
                });
                this.nuB.setVisibility(0);
                this.nuB.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nuB != null && this.nuB.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nuD != null) {
                        c.this.nuD.removeAllListeners();
                        c.this.nuD.cancel();
                        c.this.nuD = null;
                    }
                    if (c.this.nuB != null) {
                        c.this.nuB.setVisibility(8);
                    }
                }
            });
            this.nuB.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nvf == null) {
                this.nvf = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nwx, "显示双击666_num", null, new Object[0]);
                            if (c.this.nww != null) {
                                c.this.nww.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.nwy != null) {
                    this.nwy.e(this.nvf, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nvf != null) {
            this.nwy.O(this.nvf);
            this.nvf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nuE != null && this.nuE.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nwx, a.C0824a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dNX();
                    }
                });
                this.nuE.setVisibility(0);
                this.nuE.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nwh, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nuE != null && this.nuE.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nwx, a.C0824a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nuG != null) {
                        c.this.nuG.removeAllListeners();
                        c.this.nuG.cancel();
                        c.this.nuG = null;
                    }
                    if (c.this.nuE != null) {
                        c.this.nuE.setVisibility(8);
                    }
                }
            });
            this.nuE.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dNW() {
        if (this.nuB == null || this.nuC == null) {
            return null;
        }
        if (this.nuD != null) {
            this.nuD.removeAllListeners();
            this.nuD.cancel();
            this.nuD = null;
        }
        this.nuC.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nuC, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nuC, 0.0f);
        int measuredWidth = (this.nuB.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nwx, 13.0f) * 2)) - this.nuC.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nuC, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nuC, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nuC, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nuD != null) {
                    c.this.nuD.removeAllListeners();
                    c.this.nuD.cancel();
                    c.this.nuD = null;
                }
                RxExecutor.postDelayed(c.this.nwh, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dNW();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nuD = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dNX() {
        if (this.nuE == null || this.nuF == null) {
            return null;
        }
        if (this.nuG != null) {
            this.nuG.removeAllListeners();
            this.nuG.cancel();
            this.nuG = null;
        }
        this.nuF.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nuF, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nuF, 0.0f);
        int measuredWidth = (this.nuE.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nwx, 13.0f) * 2)) - this.nuF.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nuF, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nuF, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nuF, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nuG != null) {
                    c.this.nuG.removeAllListeners();
                    c.this.nuG.cancel();
                    c.this.nuG = null;
                }
                RxExecutor.postDelayed(c.this.nwh, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dNX();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nuG = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nvJ = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nqc != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nqc.isSubscribe;
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
                            if (c.this.nqc != null) {
                                c.this.nqc.isSubscribe = !z;
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
                com.kascend.chushou.c.c.dMl().a(bVar, (String) null, this.nqc.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nqc.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dMl().b(bVar, (String) null, c.this.nqc.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.nww != null && this.nuq != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.nww.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nww.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nuq.mIsSubscribed;
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
                            c.this.nuq.mIsSubscribed = !z;
                            c.this.dNt();
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
                com.kascend.chushou.c.c.dMl().a(bVar, (String) null, this.nuq.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nuq.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dMl().b(bVar, (String) null, c.this.nuq.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.nsS != null) {
            int width = this.nsS.getWidth();
            int height = this.nsS.getHeight();
            if (this.nuX != width || this.nuY != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.nwi != null) {
            if (this.ntO == null) {
                this.ntO = (InteractionView) ((ViewStub) this.nwi.findViewById(a.f.view_interaction)).inflate();
                this.ntO.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.ntO.a();
                    }
                });
            }
            if (this.ntO != null) {
                this.ntO.b(configDetail);
                this.ntO.c();
                this.ntO.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eae()) {
                tv.chushou.zues.utils.g.F(this.nwx, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nwx, null) && (this.nwx instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nww != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwx, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nwx, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nww != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nwx, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nwx, configDetail.mUrl, this.nwx.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nwx, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nuL) {
                        dNH();
                        return;
                    }
                    if (this.nwx.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nwx, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.nww != null && this.nww.dNb() != null && this.nww.dNb().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nww.dNb().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dA(this.ntP);
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
        if (this.nwx != null && !this.v && !h.isEmpty(str) && this.nuq != null && str.equals(this.nuq.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.npZ == null) {
                this.npZ = new com.kascend.chushou.player.e.a();
            }
            this.npZ.b = str;
            this.npZ.nsT.copy(pkNotifyInfo);
            if (this.npZ.nsT.mAction == 6) {
                if (this.npV != null) {
                    this.npV.a(true);
                }
                this.npZ.nsT.mInPKMode = true;
                this.u = this.npZ.nsT.mPkId;
            } else if (this.npZ.nsT.mAction == 7 || (this.npZ.nsT.mMode == 1 && this.npZ.nsT.mAction == 5)) {
                if (this.npV != null) {
                    this.npV.a(true);
                }
                this.npZ.nsT.mInPKMode = true;
                if (this.dD != 42) {
                    this.nvg = ((this.nuW.y - ((this.nuW.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nwx, 158.0f) + this.nuj)) - tv.chushou.zues.utils.systemBar.b.ax(getActivity());
                    dNE();
                }
                this.u = this.npZ.nsT.mPkId;
                if (this.nqa != null) {
                    this.nqa.b(this.npZ.nsT, false);
                    this.nqa.a(this.npZ.nsT.mMode, (String) null);
                    if (this.npZ.nsT.mAction == 5 && this.npZ.nsT.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.npZ.nsT.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.npZ.nsT.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.npZ.nsT.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.npZ.nsT.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.npZ.nsT.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.nqa.a(this.npZ.nsT);
                        this.nqa.a(parseInt, this.npZ.nsT.mPkUpdateInfo.remainDuration, j, this.npZ.nsT.mMode, (this.npZ.nsT.destinyInfo == null || this.npZ.nsT.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.npZ.nsT.mPkUpdateInfo != null && !h.isEmpty(this.npZ.nsT.mPkUpdateInfo.specialMomentList) && this.nqa != null) {
                    this.nqa.a(this.npZ.nsT, true);
                }
                if (this.npZ.nsT.mMode == 2) {
                    dNE();
                } else {
                    dNo();
                }
            } else {
                this.npZ.nsT.mInPKMode = false;
                if (this.npZ.nsT.mMode == 2) {
                    dNE();
                } else {
                    dNo();
                }
            }
        }
    }

    public void dNo() {
        aV();
        aU();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nuh != null && this.nww != null && this.nww.npH != null) {
            this.nuh.setText(tv.chushou.zues.utils.b.Mb(this.nww.npH.count));
            this.nuh.setVisibility(0);
            if (this.nww.npH.count < 1) {
                dNY();
            }
            if (this.nua != null) {
                this.nua.setText(this.nww.npH.primaryName);
            }
            if (this.nub != null) {
                this.nub.setText(this.nww.npH.desc);
            }
            dNp();
        }
    }

    public void dNp() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nui * h.parseLong(this.nww.npH.point)));
        if (this.nru != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nwx.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nwx, a.e.icon_coin_new);
            cVar.append(this.nwx.getString(a.i.str_buy_count_coin2));
            this.nru.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.nwx, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nui);
        }
    }

    private void dNY() {
        this.cO = false;
        this.nug.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nww != null && this.nww.npH != null) {
            if (this.nww.npH.count < 1) {
                this.nuh.setVisibility(8);
            } else {
                this.nuh.setVisibility(0);
                this.nuh.setSelected(false);
                this.nuh.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.ntZ.setVisibility(8);
        if (this.ntH != null) {
            this.ntH.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nqe != null) {
            if (z) {
                this.nqe.setVisibility(0);
            } else {
                this.nqe.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nvG != null) {
            this.nvG.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.ntQ != null) {
            this.ntQ.performClick();
        }
    }
}
