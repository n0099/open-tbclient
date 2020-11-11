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
    public String pkD;
    private TextView pkH;
    private TextView pkK;
    private ImageView pkQ;
    private TextView pkZ;
    private View pkw;
    private TextView plK;
    private View plN;
    private KPSwitchPanelLinearLayout plh;
    private ImageView pli;
    private tv.chushou.zues.widget.kpswitch.b.c plj;
    private d.a plk;
    private TextView plz;
    private TextView pmK;
    private LinearLayout pnA;
    private PlayShowMicStatusView pnB;
    private RecyclerView pnC;
    private ImageView pnD;
    private PlayShowRecommendView pnE;
    private View pnF;
    private RelativeLayout pnG;
    private AnimationSet pnH;
    private ImageView pnI;
    private ImageView pnJ;
    private RelativeLayout pnK;
    private PastedEditText pnL;
    private ToggleButton pnM;
    private RelativeLayout pnN;
    private PaoPaoView pnO;
    private FrescoThumbnailView pnP;
    private LinearLayout pnQ;
    private ImageView pnR;
    private InteractionView pnS;
    private LinearLayout pnT;
    private FrescoThumbnailView pnU;
    private FrameLayout pnV;
    private RedpacketNotifier pnW;
    private InteractNotifier pnX;
    private EmbeddedButtonLayout pnY;
    private GiftAnimationLayout pnZ;
    private int pnj;
    private View pnk;
    private View pnl;
    private com.kascend.chushou.view.user.b pnm;
    private View pnn;
    private FrameLayout pno;
    private LinearLayout pnp;
    private RelativeLayout pnq;
    private FrescoThumbnailView pnr;
    private TextView pns;
    private TextView pnt;
    private TextView pnu;
    private FrescoThumbnailView pnv;
    private TextView pnw;
    private TextView pnx;
    private TextView pny;
    private TextView pnz;
    private RecyclerView.LayoutManager poA;
    private ArrayList<ChatInfo> poB;
    private ArrayList<ChatInfo> poC;
    private ArrayList<ChatInfo> poD;
    private ArrayList<ChatInfo> poE;
    private Button poI;
    private View poJ;
    private View poK;
    private Animator poL;
    private View poM;
    private View poN;
    private Animator poO;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> poR;
    private PlayShowMicPerson poU;
    private FoodView poY;
    public ListItem poZ;
    private com.kascend.chushou.player.b.a poa;
    private f pob;
    private PlayShowH5View poc;
    private LinearLayout pod;
    private TextView poe;
    private TextView pof;
    private TextView pog;
    private TextView poh;
    private TextView poj;
    private TextView pok;
    private ImageView pol;
    private TextView pom;
    private PopupWindow pot;
    private View pov;
    private RecyclerView pox;
    private RoomInfo poy;
    private FrescoThumbnailView ppA;
    private TextView ppB;
    private TextView ppC;
    private ImageView ppD;
    private RelativeLayout ppE;
    private LinearLayout ppF;
    private TextView ppG;
    private TextView ppH;
    private RelativeLayout ppI;
    private RelativeLayout ppJ;
    private FrescoThumbnailView ppK;
    private TextView ppL;
    private TextView ppM;
    private ImageView ppN;
    private RelativeLayout ppO;
    private TextView ppQ;
    private float ppR;
    private float ppS;
    private a ppT;
    private FoodView ppa;
    private com.kascend.chushou.player.ui.miniview.a ppb;
    private int ppc;
    private int ppd;
    private Point ppe;
    private FrescoThumbnailView pph;
    private FrescoThumbnailView ppj;
    private ValueAnimator ppl;
    private LinearLayout ppm;
    private long ppn;
    private VideoShowVoteView ppo;
    private Runnable ppp;
    private FrescoThumbnailView ppr;
    private ImageView pps;
    private RelativeLayout ppt;
    private TextView ppu;
    private ImageView ppv;
    private EditText ppw;
    private View ppx;
    private RelativeLayout ppy;
    private RelativeLayout ppz;
    private boolean cp = false;
    private int pon = 1;
    private boolean poo = false;
    private int poq = 0;
    private int por = 0;
    private int pou = -1;
    private boolean pow = false;
    private FullRoomInfo poz = null;
    private com.kascend.chushou.player.adapter.a poF = null;
    private ArrayList<String> poG = null;
    private boolean poH = true;
    private boolean poP = true;
    private boolean poQ = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean poS = false;
    private boolean poT = false;
    private long poV = 0;
    private int poW = 1;
    private boolean poX = false;
    private int ppf = -1;
    private int ppg = -1;
    private boolean ppk = false;
    private int ppq = -1;
    private io.reactivex.disposables.b ppP = null;

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
        this.pkD = getArguments().getString("cover");
        this.poP = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.pqt = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.pqt;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            euX();
            this.pmW = ((VideoPlayer) this.pqI).euh();
            this.pqH = ((VideoPlayer) this.pqI).euk();
            d(view);
            evh();
            if (this.pqI instanceof VideoPlayer) {
                ((VideoPlayer) this.pqI).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.poQ = false;
        if (this.prn != null) {
            this.prn.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.poQ = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.poL != null) {
            this.poL.removeAllListeners();
            this.poL.cancel();
            this.poL = null;
        }
        if (this.poO != null) {
            this.poO.removeAllListeners();
            this.poO.cancel();
            this.poO = null;
        }
        if (this.pnX != null) {
            this.pnX.c();
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
        if (this.ppP != null) {
            this.ppP.dispose();
            this.ppP = null;
        }
        this.pon = 1;
        this.poo = false;
        if (this.pqJ != null) {
            this.pqJ.cs(null);
        }
        if (this.pot != null) {
            this.pot.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.pqI, this.plj);
        if (this.pqI != null && (this.pqI instanceof VideoPlayer)) {
            ((VideoPlayer) this.pqI).euo();
        }
        this.plk = null;
        this.plj = null;
        aI();
        if (this.poa != null) {
            this.poa.a();
        }
        if (this.pnO != null) {
            this.pnO.b();
            this.pnO.c();
            this.pnO = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.ct(this);
        if (this.poD != null) {
            this.poD.clear();
        }
        if (this.poB != null) {
            this.poB.clear();
        }
        if (this.poE != null) {
            this.poE.clear();
        }
        if (this.poC != null) {
            this.poC.clear();
        }
        if (this.poG != null) {
            this.poG.clear();
        }
        if (this.poF != null) {
            this.poF.a(0);
            this.poF.a();
        }
    }

    private void d(View view) {
        this.pnk = view.findViewById(a.f.fl_root);
        this.ppe = tv.chushou.zues.utils.a.hE(this.pqI);
        this.poq = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.pqI);
        this.por = tv.chushou.zues.utils.systemBar.b.aI(getActivity());
        this.ppd = 86;
        this.pqH = ((VideoPlayer) this.pqI).euk();
        if (this.pqH != null) {
            this.poy = this.pqH.euL();
            this.poz = this.pqH.euJ();
        }
        this.poB = new ArrayList<>();
        this.poD = new ArrayList<>();
        this.poC = new ArrayList<>();
        this.pno = (FrameLayout) this.pqt.findViewById(a.f.fl_effect);
        b();
        this.pqC = (PlayerErrorView) this.pqt.findViewById(a.f.view_net_error_msg);
        this.pqC.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.pnN = (RelativeLayout) this.pqt.findViewById(a.f.rl_audio_ani);
        this.pnO = (PaoPaoView) this.pqt.findViewById(a.f.audio_ani);
        this.pnP = (FrescoThumbnailView) this.pqt.findViewById(a.f.audio_ani_avatar);
        this.pnQ = (LinearLayout) this.pqt.findViewById(a.f.ll_audio);
        this.pmK = (TextView) this.pqt.findViewById(a.f.tv_open_video);
        this.pnR = (ImageView) this.pqt.findViewById(a.f.iv_audio_ani);
        this.ppj = (FrescoThumbnailView) this.pqt.findViewById(a.f.live_cover);
        if (!this.ppk || this.pmW == null || this.pmW.getPlayState() != 4) {
            this.ppj.setVisibility(0);
            this.ppj.setBlur(true);
            this.ppj.i(this.pkD, 0, 0, 0);
        }
        this.pmK.setOnClickListener(this);
        this.pkh = new b();
        this.pkh.a(view, null, this.pqI, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cId()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.pqH != null) {
                    append.append(c.this.pqH.euL().mRoomID);
                }
                if (c.this.pkf != null && c.this.pkf.pmX != null) {
                    append.append("&mode=").append(c.this.pkf.pmX.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.pqI, append.toString());
            }
        });
        this.pkl = (VoiceInteractionView) this.pqt.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.pqH != null) {
            this.poy = this.pqH.euL();
            this.poz = this.pqH.euJ();
        }
        aL();
        euW();
        evc();
        this.ppm = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.poY = (FoodView) view.findViewById(a.f.rav_ad);
        this.ppr = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.pps = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.ppr.setOnClickListener(this);
        this.pps.setOnClickListener(this);
        this.ppt = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.pph = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.pph.setOnClickListener(this);
        this.pnX = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.pnW = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.poI = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.poI.setOnClickListener(this);
        this.pox = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.pox.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pox.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.ppe.x, this.ppe.y) * 0.83d);
        this.pox.setLayoutParams(layoutParams);
        this.poA = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.pqI);
        this.pox.setLayoutManager(this.poA);
        this.pox.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.pox.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.pox.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.evp();
                } else if (i == 1) {
                    c.this.poH = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.poF = new com.kascend.chushou.player.adapter.a(this.pqI, this.poB);
        if (this.poy != null) {
            this.poF.a(this.poy);
        }
        if (com.kascend.chushou.b.etQ().c != null) {
            this.poF.a(com.kascend.chushou.b.etQ().c);
        }
        this.pox.setAdapter(this.poF);
        this.poF.a(this.poB.size());
        this.poF.notifyDataSetChanged();
        if (this.pqH != null && (c = this.pqH.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.poa != null) {
            this.poa.a();
            this.poa = null;
        }
        this.pnZ = (GiftAnimationLayout) this.pqt.findViewById(a.f.ll_gift_animation);
        this.pnZ.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.pnj = ((int) (tv.chushou.zues.utils.a.hD(this.pqI).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.pqI, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pnZ.getLayoutParams();
        layoutParams2.bottomMargin = this.pnj;
        this.pnZ.setLayoutParams(layoutParams2);
        if (this.pqH != null) {
            this.poa = new com.kascend.chushou.player.b.a(this.pqI.getApplicationContext(), this.pnZ);
            this.poa.a(this.pqH);
            a(this.pqH.pjL, this.pqH.pjO);
        }
        this.pqt.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.pnY = (EmbeddedButtonLayout) this.pqt.findViewById(a.f.embedded_button_layout);
        this.pnY.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.ppo = (VideoShowVoteView) this.pqt.findViewById(a.f.view_video_show_vote);
        this.ppo.setOnClickListener(this);
        this.ppo.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.pqH != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
            this.pnY.a(videoPlayer.euu().evO());
            this.pnY.b(this.pqH.i());
            this.pnW.a(videoPlayer.euq(), false);
            this.pnX.a(videoPlayer.eur(), videoPlayer.eus(), videoPlayer.eut());
            this.pkf = new com.kascend.chushou.player.e.a();
        }
        this.prx = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.poS = false;
                c.this.b(c.this.pnj, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.poS = true;
                if (c.this.prn != null) {
                    c.this.prn.measure(0, 0);
                    int measuredHeight = c.this.prn.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.pqI, 14.0f);
                    if (measuredHeight > c.this.pnj) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.prr = (PaoGuideView) this.pqt.findViewById(a.f.rlPaoGuideView);
        this.poU = (PlayShowMicPerson) this.pqt.findViewById(a.f.rl_mic_person_view);
        this.poc = (PlayShowH5View) this.pqt.findViewById(a.f.rl_playshowh5);
        this.ppa = (FoodView) this.pqt.findViewById(a.f.bottom_ad);
        if (this.pqH != null) {
            H();
            if (this.pqH.pjE != null && !h.isEmpty(this.pqH.pjE.mUrl)) {
                b(this.pqH.pjE);
            }
        }
        this.poJ = this.pqt.findViewById(a.f.view_reminder_subscribe);
        this.poK = this.poJ.findViewById(a.f.spash_subscribe);
        ((TextView) this.poJ.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().R(this.pqI, a.e.videoplayer_reminder_subscribe).append(" ").append(this.pqI.getString(a.i.videoplayer_reminder_subscribe)));
        this.poJ.setOnClickListener(this);
        this.poM = this.pqt.findViewById(a.f.view_reminder_danmaku);
        this.poN = this.poM.findViewById(a.f.spash_danmaku);
        ((TextView) this.poM.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().R(this.pqI, a.e.videoplayer_reminder_danmaku).append(" ").append(this.pqI.getString(a.i.videoplayer_reminder_danmaku)));
        this.poM.setOnClickListener(this);
    }

    private void euW() {
        this.ppy = (RelativeLayout) this.pqt.findViewById(a.f.rl_cyclelive);
        this.ppz = (RelativeLayout) this.pqt.findViewById(a.f.rlrl_cyclelive);
        this.ppA = (FrescoThumbnailView) this.pqt.findViewById(a.f.iv_liveicon);
        this.ppB = (TextView) this.pqt.findViewById(a.f.tv_livename);
        this.ppC = (TextView) this.pqt.findViewById(a.f.tv_livedesc);
        this.ppD = (ImageView) this.pqt.findViewById(a.f.iv_cyclelive_name_menu);
        this.ppE = (RelativeLayout) this.pqt.findViewById(a.f.rl_normal);
        this.ppF = (LinearLayout) this.pqt.findViewById(a.f.ll_cyclelive_nickname);
        this.ppG = (TextView) this.pqt.findViewById(a.f.tv_cyclelive_nickname);
        this.ppH = (TextView) this.pqt.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.ppI = (RelativeLayout) this.pqt.findViewById(a.f.rl_clear_cyclelive);
        this.ppJ = (RelativeLayout) this.pqt.findViewById(a.f.rlrl_clear_cyclelive);
        this.ppK = (FrescoThumbnailView) this.pqt.findViewById(a.f.iv_clear_liveicon);
        this.ppL = (TextView) this.pqt.findViewById(a.f.tv_clear_livename);
        this.ppM = (TextView) this.pqt.findViewById(a.f.tv_clear_livedesc);
        this.ppN = (ImageView) this.pqt.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.ppO = (RelativeLayout) this.pqt.findViewById(a.f.rl_clear_normal);
        this.ppN.setOnClickListener(this);
        this.ppD.setOnClickListener(this);
        this.ppH.setOnClickListener(this);
        this.ppG.setOnClickListener(this);
        this.ppA.setOnClickListener(this);
        this.ppK.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.pqH.pjC != null && this.ppa != null) {
            this.ppa.a(true, this.pqH.f4119a == null ? "" : this.pqH.f4119a);
            this.ppa.a(this.pqH.pjC, a.C0988a.slide_in_bottom_danmu_anim, a.C0988a.slide_out_bottom_danmu_anim, true);
        }
        if (this.pqH != null && this.pqH.pjJ != null && this.pnY != null) {
            this.poY.a(this.pqH.pjJ, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.pqH != null) {
                        c.this.pqH.pjJ = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a evo() {
        return this.poa;
    }

    private void euX() {
        this.pqJ = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.pqt != null && (textView = (TextView) c.this.pqt.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.pqI.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.pqJ.D(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.pqJ);
                        break;
                    case 12:
                        c.this.b(c.this.pqJ);
                        break;
                    case 17:
                        c.this.evJ();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.pqG.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.pow) {
            this.pow = true;
            if (this.pov == null) {
                this.pov = this.pqt.findViewById(a.f.vs_async_show_content);
                this.pov = ((ViewStub) this.pov).inflate();
            }
            this.pkw = this.pqt.findViewById(a.f.ui_content);
            if (this.plN == null) {
                this.plN = this.pqt.findViewById(a.f.vs_async_notification_view);
                this.plN = ((ViewStub) this.plN).inflate();
            }
            c(this.pqt);
            k();
            edV();
            if (this.c == null) {
                this.pjZ = new d.a();
                this.c = new GestureDetector(this.pqI, this.pjZ);
            }
            ((VideoPlayer) this.pqI).q();
        }
    }

    private void aL() {
        this.pnp = (LinearLayout) this.pqt.findViewById(a.f.ll_anchor);
        this.pnq = (RelativeLayout) this.pqt.findViewById(a.f.ll_clear_anchor);
        this.pnp.setVisibility(4);
        this.pnq.setVisibility(4);
        this.pnr = (FrescoThumbnailView) this.pqt.findViewById(a.f.iv_clear_avatar);
        this.pns = (TextView) this.pqt.findViewById(a.f.tv_clear_nickname);
        this.pnt = (TextView) this.pqt.findViewById(a.f.tv_clear_online_count);
        this.pnu = (TextView) this.pqt.findViewById(a.f.tv_clear_btn_subscribe);
        this.pnu.setOnClickListener(this);
        this.pnv = (FrescoThumbnailView) this.pqt.findViewById(a.f.iv_avatar);
        this.pnw = (TextView) this.pqt.findViewById(a.f.tv_nickname_test);
        this.pnx = (TextView) this.pqt.findViewById(a.f.tv_online_count);
        this.pkH = (TextView) this.pqt.findViewById(a.f.tv_btn_subscribe);
        this.pkH.setOnClickListener(this);
        this.pny = (TextView) this.pqt.findViewById(a.f.tv_loyal_counts);
        this.pkK = (TextView) this.pqt.findViewById(a.f.tv_btn_contribution);
        this.pnz = (TextView) this.pqt.findViewById(a.f.tv_btn_contribution_forpk);
        this.pkK.setVisibility(4);
        this.pnz.setVisibility(8);
        this.pnA = (LinearLayout) this.pqt.findViewById(a.f.ll_mic);
        this.pnB = (PlayShowMicStatusView) this.pqt.findViewById(a.f.show_mic_status);
        this.pnC = (RecyclerView) this.pqt.findViewById(a.f.rv_loyal);
        this.pnD = (ImageView) this.pqt.findViewById(a.f.iv_clear_close);
        this.pkQ = (ImageView) this.pqt.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.pnC.setLayoutManager(linearLayoutManager);
        this.poR = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void I(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.pqI, (JSONObject) null, c.this.pqH.euL().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1121a view$OnLongClickListenerC1121a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC1121a.sg(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC1121a.sg(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1121a.sg(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.eHE(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.pqI, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.pqI, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.pqI, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.pqI, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.pqI, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.cc(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.pnC.setAdapter(this.poR);
        this.pnA.setOnClickListener(this);
        this.pnr.setOnClickListener(this);
        this.pnD.setOnClickListener(this);
        this.pnv.setOnClickListener(this);
        this.pnr.setOnClickListener(this);
        this.pkQ.setOnClickListener(this);
        this.pny.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void ef(View view) {
                String str = tv.chushou.common.a.cId() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.pqH != null) {
                    str = str + c.this.pqH.euL().mRoomID;
                }
                c.this.f(c.this.pqI.getString(a.i.str_loyal_fans), str);
            }
        });
        this.pkK.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void ef(View view) {
                String str = tv.chushou.common.a.cId() + "m/room-billboard/";
                if (c.this.pqH != null) {
                    str = str + c.this.pqH.euL().mRoomID;
                }
                c.this.f(c.this.pqI.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.pnz.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void ef(View view) {
                String str = tv.chushou.common.a.cId() + "m/room-billboard/";
                if (c.this.pqH != null) {
                    str = str + c.this.pqH.euL().mRoomID;
                }
                c.this.f(c.this.pqI.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.poz == null || this.poz.cycleLiveRoomInfo == null || h.isEmpty(this.poz.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.pkj = this.poz.cycleLiveRoomInfo;
        }
        if (z2 && this.pkj != null) {
            this.ppy.setVisibility(0);
            this.ppI.setVisibility(0);
            this.ppE.setVisibility(8);
            this.ppO.setVisibility(8);
            this.ppF.setVisibility(0);
            this.ppK.h(this.pkj.eventIcon, com.kascend.chushou.view.a.a(this.poy.mCreatorGender), b.a.small, b.a.small);
            this.ppA.h(this.pkj.eventIcon, com.kascend.chushou.view.a.a(this.poy.mCreatorGender), b.a.small, b.a.small);
            this.ppL.setText(this.pkj.eventName);
            this.ppM.setText(this.pkj.eventDesc);
            this.ppB.setText(this.pkj.eventName);
            this.ppC.setText(this.pkj.eventDesc);
            this.ppG.setText(this.pkj.nickname);
            euZ();
            if (z) {
                c(this.pkj.remainTime);
                return;
            }
            return;
        }
        this.ppy.setVisibility(8);
        this.ppI.setVisibility(8);
        this.ppE.setVisibility(0);
        this.ppO.setVisibility(0);
        this.ppF.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.ppP != null) {
            this.ppP.dispose();
            this.ppP = null;
        }
        this.ppP = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.eAB()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.pqI != null && (c.this.pqI instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.pqI).u();
                }
            }
        });
    }

    private void euY() {
        if (this.poy != null && this.pow) {
            this.pnp.setVisibility(0);
            this.pnq.setVisibility(0);
            this.pkK.setVisibility(0);
            this.pnr.h(this.poy.mCreatorAvatar, com.kascend.chushou.view.a.a(this.poy.mCreatorGender), b.a.small, b.a.small);
            this.pns.setText(this.poy.mCreatorNickname);
            this.pnv.h(this.poy.mCreatorAvatar, com.kascend.chushou.view.a.a(this.poy.mCreatorGender), b.a.small, b.a.small);
            this.pnw.setText(this.poy.mCreatorNickname);
            evA();
            eva();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void evA() {
        if (this.poy != null) {
            this.pnt.setText(tv.chushou.zues.utils.b.formatNumber(this.poy.mOnlineCount));
            this.pnx.setText(tv.chushou.zues.utils.b.formatNumber(this.poy.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euZ() {
        if (this.pkj != null) {
            if (this.pkj.isSubscribe) {
                this.ppH.setText(a.i.like_already);
                this.ppH.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.ppH.setText(getString(a.i.like));
            this.ppH.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eva() {
        if (this.poy != null) {
            if (this.poy.mIsSubscribed) {
                this.pnu.setText(getString(a.i.like_already));
                this.pnu.setBackgroundResource(a.e.bg_show_subcribe);
                this.pkH.setText(getString(a.i.like_already));
                this.pkH.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.pnu.setText(getString(a.i.like));
            this.pnu.setBackgroundResource(a.e.bg_show_subcribe);
            this.pkH.setText(getString(a.i.like));
            this.pkH.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void evb() {
        if (this.poR != null) {
            this.poR.notifyDataSetChanged();
        }
    }

    private void evc() {
        this.pnF = this.pqt.findViewById(a.f.tv_interact);
        this.pnF.setOnClickListener(this);
        this.pnK = (RelativeLayout) this.pqt.findViewById(a.f.rl_edit_bar);
        this.pnI = (ImageView) this.pqt.findViewById(a.f.btn_hotword);
        this.pnI.setOnClickListener(this);
        this.pnJ = (ImageView) this.pqt.findViewById(a.f.iv_task_badge);
        this.pnH = (AnimationSet) AnimationUtils.loadAnimation(this.pqI, a.C0988a.anim_hotword);
        this.pnH.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.etY().c) {
                    c.this.pnI.clearAnimation();
                    c.this.pnI.startAnimation(c.this.pnH);
                }
            }
        });
        if (com.kascend.chushou.d.h.etY().c) {
            this.pnI.startAnimation(this.pnH);
            this.pnJ.setVisibility(0);
        }
        this.ppQ = (TextView) this.pqt.findViewById(a.f.tv_bottom_input);
        this.ppQ.setOnClickListener(this);
        this.prI = (FrescoThumbnailView) this.pqt.findViewById(a.f.ll_btn_set);
        this.prI.setOnClickListener(this);
        this.prI.DX(a.e.ic_room_set_btn_white);
        this.pnT = (LinearLayout) this.pqt.findViewById(a.f.ll_bottom_all_button);
        this.pnU = (FrescoThumbnailView) this.pqt.findViewById(a.f.fl_clear_bottom_gift);
        this.pnU.setAnim(true);
        this.pnU.setOnClickListener(this);
        this.pnU.DX(a.e.ic_show_gift_n);
        this.pnV = (FrameLayout) this.pqt.findViewById(a.f.flfl_clear_bottom_gift);
        this.pnV.setVisibility(8);
        this.pnG = (RelativeLayout) this.pqt.findViewById(a.f.rl_bottom_input);
        this.pnG.setVisibility(0);
        this.pnL = (PastedEditText) this.pqt.findViewById(a.f.et_bottom_input);
        this.pnL.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.pkZ.setEnabled(editable.length() > 0);
            }
        });
        this.pnL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.pkZ);
                    return true;
                }
                return true;
            }
        });
        this.pnL.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.pnL);
                }
                return false;
            }
        });
        this.pli = (ImageView) this.pqt.findViewById(a.f.iv_btn_emoji);
        this.pli.setVisibility(8);
        this.pkZ = (TextView) this.pqt.findViewById(a.f.tv_btn_send);
        this.pkZ.setOnClickListener(this);
        this.pod = (LinearLayout) this.pqt.findViewById(a.f.head_trumpet);
        this.pod.setVisibility(8);
        this.pod.setOnClickListener(this);
        this.poe = (TextView) this.pqt.findViewById(a.f.tv_primary_name);
        this.pof = (TextView) this.pqt.findViewById(a.f.tv_primary_desc);
        this.poh = (TextView) this.pqt.findViewById(a.f.tv_cut_count);
        this.poh.setOnClickListener(this);
        this.pok = (TextView) this.pqt.findViewById(a.f.tv_head_count);
        this.pok.setText(this.pon + "");
        this.poj = (TextView) this.pqt.findViewById(a.f.tv_plus_count);
        this.poj.setOnClickListener(this);
        this.plz = (TextView) this.pqt.findViewById(a.f.tv_buy_count_coin);
        this.pog = (TextView) this.pqt.findViewById(a.f.tv_buy_head);
        this.pog.setOnClickListener(this);
        this.pol = (ImageView) this.pqt.findViewById(a.f.iv_trumpet_select);
        this.pol.setOnClickListener(this);
        this.pom = (TextView) this.pqt.findViewById(a.f.tv_trumpet_have_count);
        this.poo = false;
        this.pol.setBackgroundResource(a.e.ic_trumpet_n);
        this.pom.setVisibility(8);
        this.plh = (KPSwitchPanelLinearLayout) this.pqt.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.plh, this.pli, this.pnL, new a.InterfaceC1125a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1125a
            public void AE(boolean z) {
                if (c.this.pli != null) {
                    if (z) {
                        c.this.plh.setDirectVisibility(0);
                        c.this.pli.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.pli.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.plk = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void kg(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.pli.setImageResource(a.e.cs_emoji_normal);
                    c.this.eve();
                    if (c.this.ppx != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.ppx.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.pqI);
                        c.this.ppx.setLayoutParams(layoutParams);
                    }
                    if (c.this.pnK != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.pnK.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.pqI);
                        c.this.pnK.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.ppx != null && c.this.ppx.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.ppx.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.ppx.setLayoutParams(layoutParams3);
                    c.this.ppx.setVisibility(8);
                }
                if (c.this.poS) {
                    c.this.prn.setVisibility(0);
                }
                if (c.this.pqI != null && (c.this.pqI instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.pqI).AD(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.pnK != null && c.this.plh.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.pnK.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.pnK.setLayoutParams(layoutParams4);
                }
            }
        };
        this.plj = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.plh, this.plk, ((VideoPlayer) this.pqI).eup());
        ((VideoPlayer) this.pqI).h(((VideoPlayer) this.pqI).eup());
        this.ppx = this.pqt.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.ppu = (TextView) this.pqt.findViewById(a.f.btn_room_search);
        this.ppv = (ImageView) this.pqt.findViewById(a.f.iv_room_emoji_delete);
        this.ppw = (EditText) this.pqt.findViewById(a.f.et_room_emoji_search);
        this.ppw.setImeOptions(3);
        this.ppw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.ppu);
                    return true;
                }
                return false;
            }
        });
        this.ppw.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.ppu.setEnabled(editable.length() > 0);
                c.this.ppv.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.prn.setEmojiSearchText(editable.toString());
            }
        });
        this.ppu.setOnClickListener(this);
        this.ppv.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aI(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bD(this.ppw);
            this.ppx.setVisibility(0);
            this.ppw.requestFocus();
        } else {
            this.ppx.setVisibility(8);
        }
        if (z2) {
            this.ppw.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eve() {
        int ek = tv.chushou.zues.widget.kpswitch.b.d.ek(this.pqI) + tv.chushou.zues.utils.a.dip2px(this.pqI, 14.0f);
        if (ek > this.pnj) {
            b(ek, 12);
        }
    }

    private void aS() {
    }

    private void evh() {
        if (this.por > 0) {
            View findViewById = this.pqt.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.por);
        }
        if (this.poq > 0) {
            View findViewById2 = this.pqt.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.poq, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.poP) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.pkb = ((VideoPlayer) this.pqI).eul();
        this.pkb.a(this);
        if (this.pqH.euJ() != null) {
            s();
        } else if (this.pqu != null) {
            this.pqu.setVisibility(0);
        }
        if (this.pkb != null) {
            this.pkb.d();
        }
    }

    private void evi() {
        if ((this.pkf == null || this.pkf.pmX == null || !this.pkf.pmX.mInPKMode) ? false : true) {
            if (this.pnk != null) {
                this.pnk.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pki.getLayoutParams();
            layoutParams.leftMargin = (this.ppe.x / 2) + tv.chushou.zues.utils.a.dip2px(this.pqI, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.pki.setLayoutParams(layoutParams);
            this.y.setText(this.pkf.pmX.mPkUserNickname);
            this.pki.setVisibility(0);
            this.pnA.setVisibility(8);
            return;
        }
        if (this.pnk != null) {
            this.pnk.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.pki.setVisibility(8);
    }

    private void evk() {
        boolean z = false;
        if (this.pkf != null && this.pkf.pmX != null && this.pkf.pmX.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.ppq > 0 && this.pox != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pox.getLayoutParams();
                if (layoutParams.height != this.ppq) {
                    layoutParams.height = this.ppq;
                    this.pox.setLayoutParams(layoutParams);
                }
            }
            this.pnj = ((int) (tv.chushou.zues.utils.a.hD(this.pqI).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.pqI, 84.0f);
            b(this.pnj, 12);
        } else {
            if (this.pox != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pox.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.pqI, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.pqI, 250.0f);
                    this.pox.setLayoutParams(layoutParams2);
                }
            }
            this.pnj = ((int) (tv.chushou.zues.utils.a.hD(this.pqI).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.pqI, 84.0f);
            b(this.pnj, 12);
        }
        if (this.pkh != null) {
            this.pkh.a(this.ppq + tv.chushou.zues.utils.a.dip2px(this.pqI, 52.0f), this.aq);
        }
        if (this.pkl != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.pkl.getLayoutParams();
            layoutParams3.bottomMargin = this.ppq + tv.chushou.zues.utils.a.dip2px(this.pqI, 52.0f);
            this.pkl.setLayoutParams(layoutParams3);
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

    private void evl() {
        evk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) evH().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pqu.getLayoutParams();
        this.ppe = tv.chushou.zues.utils.a.hE(this.pqI);
        this.ppd = 86;
        this.dB = (Math.max(this.ppe.x, this.ppe.y) - tv.chushou.zues.utils.a.dip2px(this.pqI, (this.ppd + 52) + 250)) - this.poq;
        this.ppc = Math.max(this.ppe.x, this.ppe.y) - ((tv.chushou.zues.utils.a.dip2px(this.pqI, this.ppd) + this.poq) * 2);
        if (this.ppf <= 0 || this.ppg <= 0) {
            this.ppf = Math.min(this.ppe.x, this.ppe.y);
            this.ppg = Math.max(this.ppe.x, this.ppe.y);
        }
        this.ar = Math.min(this.ppe.x, this.ppe.y);
        this.aq = (this.ar * this.ppg) / this.ppf;
        boolean z = false;
        if (this.pkf == null || this.pkf.pmX == null) {
            i = 1;
        } else {
            i = this.pkf.pmX.mMode;
            if (this.pkf.pmX.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.ppd = 42;
            if (i == 2) {
                if (this.ppg < this.ppf) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.ppf * layoutParams.height) / this.ppg;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, this.ppd) + this.poq;
            layoutParams.gravity = 48;
            this.ppq = ((this.ppe.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.pqI, (this.ppd + 52) + 64) + this.poq)) - tv.chushou.zues.utils.systemBar.b.aI(getActivity());
            aG();
        } else if (this.E) {
            this.ppd = 42;
            if (this.ppg < this.ppf) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.ppf * layoutParams.height) / this.ppg;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, this.ppd) + this.poq;
            layoutParams.gravity = 48;
            this.ppq = ((this.ppe.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.pqI, (this.ppd + 52) + 98) + this.poq)) - tv.chushou.zues.utils.systemBar.b.aI(getActivity());
            evl();
        } else {
            this.ppq = -1;
            this.ppd = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, this.ppd) + this.poq;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.ppc) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, this.ppd) + this.poq;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.ppe.x, this.ppe.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.ppf) / this.ppg >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.ppf) / this.ppg;
                    } else if ((this.ar * this.ppg) / this.ppf >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.ppg) / this.ppf;
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
                    if ((this.ar * this.ppg) / this.ppf > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.ppf) / this.ppg;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.ppg) / this.ppf;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.ppg) / this.ppf;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.ppf) / this.ppg;
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
        if (this.pqH != null && this.pqH.d) {
            layoutParams.width = Math.min(this.ppe.x, this.ppe.y);
            layoutParams.height = Math.max(this.ppe.x, this.ppe.y);
        }
        evH().setLayoutParams(layoutParams);
        this.pqu.setLayoutParams(layoutParams2);
        this.pqu.requestLayout();
    }

    private void aY() {
        this.pqu = new SurfaceRenderView(this.pqI);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.pqu;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        evH().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.poX) {
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
        if (this.ppT != null) {
            this.ppT.a();
        }
        if (this.pqH != null && !h.isEmpty(this.pqH.w)) {
            b(this.pqH.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.pmW != null) {
            int width = this.pmW.getWidth();
            int height = this.pmW.getHeight();
            if (this.ppf != width || this.ppg != height || this.ppf <= 0 || this.ppg <= 0) {
                this.ppf = width;
                this.ppg = height;
                if (this.pqu != null) {
                    this.pqu.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.poS) {
                evn();
            } else {
                if (this.pqI.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击送礼_num", "竖屏", new Object[0]);
                if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.pqH.euJ().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.poo) {
                f(this.pnL.getText().toString());
            } else {
                a(this.pnL.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.etY().c) {
                com.kascend.chushou.d.h.etY().b(false);
                this.pnH.cancel();
                this.pnH.reset();
                this.pnI.clearAnimation();
                this.pnJ.setVisibility(8);
            }
            n(view, 0, this.pqt.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.pqI, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.pqt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.pqH.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.pqH.d) {
                edO();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.pox != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.poy != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.poW = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.pqI, (JSONObject) null, this.pqH.euL().mRoomID, this.pqH.euL().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.pqI.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.pqI, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.poZ != null) {
                    com.kascend.chushou.d.e.a(this.pqI, this.poZ, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.ppt != null) {
                    this.ppt.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.pqI, null) && this.pqH != null && this.pqH.pjN != null) {
                    if (this.poo) {
                        bo();
                    } else {
                        if (this.pqH != null && this.pqH.pjN != null && this.pqH.pjN.count > 0) {
                            this.pod.setVisibility(8);
                        } else {
                            this.pod.setVisibility(0);
                        }
                        this.poo = true;
                        this.pol.setBackgroundResource(a.e.ic_trumpet_p);
                        this.pom.setVisibility(0);
                        this.pom.setSelected(true);
                        this.pom.setTextColor(Color.parseColor("#ff5959"));
                        if (this.pnL != null) {
                            this.pnL.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.pon <= 9) {
                    this.pon++;
                    this.pok.setText(this.pon + "");
                }
                euV();
            } else if (id == a.f.tv_cut_count) {
                if (this.pon > 1) {
                    this.pon--;
                    this.pok.setText(this.pon + "");
                }
                euV();
            } else if (id == a.f.tv_buy_head) {
                evF();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.ppw.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.ppw.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.ppx.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.ep(this.ppw);
                    this.prn.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.pkj != null && !h.isEmpty(this.pkj.eventUrl)) {
                    f("", this.pkj.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.pkj != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.pkj != null) {
                    com.kascend.chushou.d.a.a(this.pqI, (JSONObject) null, this.pkj.roomId, this.pkj.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.pqH.a(false);
                    ((VideoPlayer) this.pqI).l();
                } else {
                    ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
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
        if (this.poc != null) {
            int i = (tv.chushou.zues.utils.a.hD(this.pqI).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.poc.getLayoutParams();
            layoutParams.topMargin = i;
            this.poc.setLayoutParams(layoutParams);
            this.poc.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.f4233a = str2;
            h5Options.c = false;
            this.poc.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Sc(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.poV <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.Sc(a.i.str_too_fast);
            return false;
        } else {
            eea();
            if (!com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a(((VideoPlayer) this.pqI).euk().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.poV = System.currentTimeMillis();
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                a(this.pqH.euJ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.pqH.h);
            }
            g(this.b);
            if (!z && this.pnL != null) {
                this.pnL.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            eea();
            if (com.kascend.chushou.d.e.c(this.pqI, null) && LoginManager.Instance().getUserInfo() != null && this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                a(this.pqH.euJ().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.pnL != null) {
                this.pnL.setText((CharSequence) null);
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
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.pqH.euJ().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.pqH.euJ().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.pqI).phZ;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.aaA(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.pri != null && this.pri.isShowing()) {
            this.pri.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
        if (this.prF == null) {
            i(3);
        }
        this.prF.getContentView().setBackgroundResource(0);
        this.prF.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.prF.isShowing()) {
            this.prF.showAtLocation(view, 83, i, i2);
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.pqH.euJ().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.prF.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.prJ)) {
            if (((VideoPlayer) this.pqI).q) {
                this.prI.DX(a.e.ic_room_set_btn_white);
            } else {
                this.prI.DX(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.pqI).q && this.prJ.size() == 2 && this.prJ.contains("4") && this.prJ.contains("2")) {
            this.prI.DX(a.e.ic_room_set_btn_system_white);
        } else if (this.prJ.size() > 1 || !((VideoPlayer) this.pqI).q) {
            this.prI.DX(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.prJ.get(0))) {
            this.prI.DX(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.prJ.get(0))) {
            this.prI.DX(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.prJ.get(0))) {
            this.prI.DX(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
        if (this.pri == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.pri.getContentView().setBackgroundResource(0);
            this.pri.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.pri.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.pnI.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.pri.isShowing()) {
            this.pri.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.pqI, 16.0f) + i2);
            this.pnI.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.pqH.euJ().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.pri.dismiss();
    }

    private void e(View view) {
        if (this.prc == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.etY().q()) {
            this.pnM.eHC();
        } else {
            this.pnM.eHD();
        }
        int height = this.pqt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity());
        if (view != null) {
            this.prc.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.prc == null) {
            View inflate = LayoutInflater.from(this.pqI).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.pnM = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.etY().q()) {
                this.pnM.eHC();
            } else {
                this.pnM.eHD();
            }
            this.pnM.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.etY().g(z);
                }
            });
            this.pqW = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.pqX = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.pqW.setOnClickListener(this);
            if (com.kascend.chushou.c.f4079a) {
                this.pqW.setVisibility(0);
            } else {
                this.pqW.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.etY().f4087a) {
                this.pqX.b();
            } else {
                this.pqX.c();
            }
            if (this.pqH != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.pqH.f;
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
                                if (this.pkf == null || !this.pkf.pmX.mInPKMode || h.isEmpty(this.pkf.b) || this.poy == null || !this.pkf.b.equals(this.poy.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.pqI).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl euK = this.pqH.euK();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.pqI).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.pqI, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, 5.0f);
                                            }
                                            int identifier = this.pqI.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.pqI.getPackageName());
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
                                                if (euK != null && euK.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.pqI.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.pqI).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl euK2 = this.pqH.euK();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.pqI).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.pqI, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, 5.0f);
                                        }
                                        int identifier2 = this.pqI.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.pqI.getPackageName());
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
                                            if (euK2 != null && euK2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.prc.dismiss();
                    }
                }
            });
            this.prc = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 150.0f), -2);
            this.prc.setFocusable(true);
            this.prc.setOutsideTouchable(true);
            this.prc.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.prc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.prc = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
            if (this.pob == null) {
                this.pob = new f(getActivity());
            }
            this.pob.a(this.pqH.euJ().mRoominfo, this.ax);
            if (!this.pob.isShowing()) {
                this.pob.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.poX) {
            return false;
        }
        if (this.poW == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.ppR = motionEvent.getX();
                    this.ppS = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.ppR;
                    if (Math.abs(f) > Math.abs(y - this.ppS) && Math.abs(f) > q && f > 0.0f) {
                        evC();
                        return true;
                    }
                    this.ppR = 0.0f;
                    this.ppS = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.ppx != null && this.ppx.getVisibility() == 0 && a(motionEvent, this.ppx)) {
                this.ppx.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.ep(this.ppw);
                return true;
            } else if (this.poS && this.ppx != null && this.ppx.getVisibility() == 8 && f(this.prn.b, motionEvent)) {
                evn();
                return true;
            } else if (this.poc != null && this.poc.b() && f(this.poc, motionEvent)) {
                this.poc.a();
                return true;
            } else if (this.pnS != null && this.pnS.b() && f(this.pnS, motionEvent)) {
                this.pnS.a();
                return true;
            } else if (a(motionEvent, this.pnK)) {
                return eea();
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
            if (this.prz != null && this.prz.a(i, keyEvent)) {
                return true;
            }
            if ((this.poc != null && this.poc.onKeyDown(i, keyEvent)) || evf()) {
                return true;
            }
            if (this.poW == 3) {
                this.poW = 1;
                evC();
                return true;
            } else if (this.pnS != null && this.pnS.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.pnL != null && this.pnG != null && this.pnK != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bD(this.pnL);
                this.pnG.setVisibility(8);
                this.pnK.setVisibility(0);
            }
        } else if (this.pnG != null && this.pnK != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
            this.pnG.setVisibility(0);
            this.pnK.setVisibility(8);
        }
    }

    public boolean eea() {
        boolean z;
        b(this.pnj, 12);
        boolean z2 = false;
        if (this.plh != null && this.plh.getVisibility() == 0) {
            this.plh.setVisibility(8);
            this.pli.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.pqI);
            this.pli.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.pnK == null || this.pnK.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.poo) {
                bo();
            }
            this.pnK.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.pnG != null) {
                    c.this.pnG.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean evf() {
        if (eea()) {
            return true;
        }
        if (this.pri != null && this.pri.isShowing()) {
            this.pri.dismiss();
            return true;
        } else if (this.prF != null && this.prF.isShowing()) {
            this.prF.dismiss();
            return true;
        } else if (this.prc == null || !this.prc.isShowing()) {
            return evn() || evg() || evm() || euU();
        } else {
            this.prc.dismiss();
            return true;
        }
    }

    public boolean euU() {
        if (this.prr == null || !this.prr.isShown()) {
            return false;
        }
        this.prr.d();
        return true;
    }

    public boolean evg() {
        if (this.poU == null || !this.poU.isShown()) {
            return false;
        }
        this.poU.a();
        return true;
    }

    public boolean evm() {
        if (this.poc == null || !this.poc.b()) {
            return false;
        }
        this.poc.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.pqI != null && !((Activity) this.pqI).isFinishing() && pVar != null) {
            this.poG = pVar.f4077a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.poy != null && mVar.a(this.poy.mCreatorUID, null)) {
            this.poy.mIsSubscribed = mVar.c;
            eva();
        }
    }

    public boolean evn() {
        if (!this.poS || this.prn == null) {
            return false;
        }
        if (this.prn != null) {
            this.prn.e();
        }
        if (this.ppw != null) {
            this.ppw.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.ppb != null) {
                        this.ppb.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                        this.pqH.euJ().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.pqH.euJ().mMicStatus.onMic) {
                            if (this.pnA != null) {
                                this.pnA.setVisibility(8);
                            }
                            if (this.poU != null && this.poU.isShown()) {
                                this.poU.a();
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
                        if (this.pqH.euJ().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.poy != null && !h.isEmpty(this.poy.mCreatorUID)) {
                                g(arrayList2, this.poy.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.pqH.euJ().mMicStatus.onMic) {
                            if (this.pqH.euJ().mMicStatus != null && !h.isEmpty(this.pqH.euJ().mMicStatus.micRoomId) && !this.pqH.euJ().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.pqH.euJ().mMicStatus.micRoomId;
                            }
                            this.pqH.euJ().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.pqH.euJ().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.pqH.euJ().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.pqH.euJ().mMicStatus, str3, z4);
                            if (this.poU != null && this.poU.getVisibility() == 0) {
                                this.poU.a(this.pqH.euJ().mFanItems, this.pqH.euJ().mMicStatus, str3, z4, this.pqH.euJ().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.pnA != null) {
                                this.pnA.setVisibility(8);
                            }
                            if (this.poU != null && this.poU.isShown()) {
                                this.poU.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.pou != onlineVip.mCount || (this.pny != null && this.pny.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.pou = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        evs();
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
                            if (!z3 || System.currentTimeMillis() - this.ppn <= 5000) {
                                z2 = false;
                            } else {
                                this.ppn = System.currentTimeMillis();
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
                            evb();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.ppo != null) {
                    if (this.poy == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.poy.mCreatorAvatar;
                        str2 = this.poy.mCreatorGender;
                    }
                    this.ppo.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.pkf != null && this.pkf.pmX != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.pkf.pmX.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.pkb != null) {
                                        this.pkb.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.pkf.pmX.mInPKMode = true;
                                    this.pkf.pmX.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.pkf.pmX.mPkUid = pkNotifyInfo.mPkUid;
                                    this.pkf.pmX.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.pkf.pmX.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.pkf.pmX.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.pkf.pmX.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.pkf.pmX.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.pkf.pmX.mMode = pkNotifyInfo.mMode;
                                    this.pkf.pmX.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.pkh != null) {
                                        this.pkh.k(true, this.pkf.pmX.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.etY().f4087a) {
                                        if (!com.kascend.chushou.b.etQ().e) {
                                            com.kascend.chushou.b.etQ().e = true;
                                            tv.chushou.zues.utils.g.O(this.pqI, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.etY().a(this.pqI, false);
                                        evj();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.pkf.pmX.mAction = 7;
                                    this.pkf.pmX.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.pkf.pmX.mPkUid = pkNotifyInfo.mPkUid;
                                    this.pkf.pmX.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.pkf.pmX.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.pkf.pmX.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.pkf.pmX.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.pkf.pmX.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.pkh != null) {
                                        this.pkh.k(false, 0L);
                                        this.pkh.b(this.pkf.pmX, true);
                                        this.pkh.a(this.ppq + tv.chushou.zues.utils.a.dip2px(this.pqI, 52.0f), this.aq);
                                        this.pkh.a(this.pkf.pmX.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.pkb != null) {
                                        this.pkb.a(false);
                                    }
                                    this.pkf.pmX.mInPKMode = false;
                                    this.pkf.pmX.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.pkh != null) {
                                        this.pkh.c();
                                    }
                                    this.pkf.b = null;
                                    this.pkf.pmX = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.pkf.pmX.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.pkf.pmX.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.pkf.pmX.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.poy != null && !h.isEmpty(this.poy.mRoomID) && this.poy.mRoomID.equals(this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.pkf.pmX.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.pkh != null) {
                                        this.pkh.a(this.pkf.pmX, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.pkf.pmX.copyUpdate(pkNotifyInfo);
                                    if (this.pkh != null) {
                                        this.pkh.a(this.pkf.pmX);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.pkf.pmX.copyStop(pkNotifyInfo);
                                        if (this.pkh != null) {
                                            this.pkh.M(this.pkf.pmX.mMaxFreeDuration, this.pkf.pmX.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.pkf.pmX.copyResult(pkNotifyInfo);
                                    if (!this.poQ && this.pkh != null) {
                                        int i7 = 1;
                                        if (this.pkf.pmX.destinyInfo != null && this.pkf.pmX.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.pkh.a(h.parseInt(this.pkf.pmX.mResult), h.parseLong(this.pkf.pmX.mvpUid), this.pkf.pmX.mvpAvatar, this.pkf.pmX.mvpNickname, this.pkf.pmX.mMaxFreeDuration, this.pkf.pmX.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.pkj != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.pkj.uid = cycleLiveRoomInfo.uid;
                        this.pkj.remainTime = cycleLiveRoomInfo.remainTime;
                        this.pkj.roomId = cycleLiveRoomInfo.roomId;
                        this.pkj.avatar = cycleLiveRoomInfo.avatar;
                        this.pkj.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.pqI != null && (this.pqI instanceof VideoPlayer)) {
                            ((VideoPlayer) this.pqI).d();
                        }
                    } else {
                        ((VideoPlayer) this.pqI).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.pqH != null && this.pqH.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.etY().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.etY().b().equals(next2.mUserID)) {
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

    public void evs() {
        if (this.pny != null) {
            if (this.pkf == null || this.pkf.pmX == null || !this.pkf.pmX.mInPKMode) {
                if (this.bP > 0) {
                    this.pny.setVisibility(0);
                    this.pny.setText(String.format(this.pqI.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.pnC.setVisibility(0);
                    return;
                }
                this.pny.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.pnA.setVisibility(0);
            if (this.pnB != null) {
                this.pnB.a(str, z, micStatus, this.pqH.euJ().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.pnA.setVisibility(8);
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
    public void evp() {
        int childCount = this.poA.getChildCount();
        int itemCount = this.poA.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.poA);
        if (f + childCount >= itemCount) {
            this.poH = true;
            if (this.poI != null) {
                this.poI.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void evy() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.poB.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.poB.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.poB == null) {
            this.poB = new ArrayList<>();
        }
        while (2 < this.poB.size()) {
            this.poB.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.poD);
        if (a2 == null) {
            w(false);
            return;
        }
        this.poB.addAll(a2);
        int size = this.poB.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.poB.size(); i++) {
                this.poB.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.poE == null) {
            this.poE = new ArrayList<>();
        }
        this.poE.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.poG != null && this.poG.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.poG.contains("2"))) {
                        this.poE.add(next);
                    } else if (!this.poG.contains(next.mType)) {
                        this.poE.add(next);
                    }
                }
                return this.poE;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.poB == null) {
                    this.poB = new ArrayList<>(arrayList);
                    evy();
                    w(z2);
                    return;
                }
                if (this.poD == null) {
                    this.poD = new ArrayList<>();
                }
                this.poD.addAll(arrayList);
                int size = this.poD.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.poD.size(); i++) {
                        this.poD.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.poB.size();
                if (a2 != null) {
                    this.poB.addAll(a2);
                }
                int size3 = this.poB.size();
                if (!this.poH && this.poI != null) {
                    this.poI.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.poB.size(); i3++) {
                        this.poB.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.poB == null) {
                this.poB = new ArrayList<>(arrayList);
                evy();
            } else {
                if (this.poD == null) {
                    this.poD = new ArrayList<>();
                }
                this.poD.clear();
                this.poD.addAll(arrayList);
                this.poB.clear();
                evy();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.poB.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.poF != null) {
                this.poF.a(this.poB.size());
                if (i == 1) {
                    this.poF.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.poF.notifyItemRangeRemoved(i2, i3);
                    this.poF.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.poF.notifyDataSetChanged();
                }
            }
            if (z || this.poH) {
                this.poH = true;
                if (this.poI != null) {
                    this.poI.setVisibility(8);
                }
                if (z) {
                    this.pox.scrollToPosition(this.poB.size() - 1);
                } else {
                    this.pox.smoothScrollToPosition(this.poB.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.poF != null) {
                this.poF.a(this.poB.size());
                this.poF.notifyDataSetChanged();
            }
            if (z || this.poH) {
                this.poH = true;
                if (this.poI != null) {
                    this.poI.setVisibility(8);
                }
                if (z) {
                    this.pox.scrollToPosition(this.poB.size() - 1);
                } else {
                    this.pox.smoothScrollToPosition(this.poB.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a euv;
        RoomToast roomToast;
        this.p = false;
        if (this.pqH != null && this.pqH.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.pqH.f.size()) {
                    break;
                } else if (!"2".equals(this.pqH.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            evB();
            return;
        }
        if (this.pkw != null) {
            this.pkw.setVisibility(0);
        }
        if (this.pno != null) {
            this.pno.setVisibility(0);
        }
        if (this.pqH != null) {
            this.poy = this.pqH.euL();
            this.poz = this.pqH.euJ();
            if (com.kascend.chushou.b.etQ().c != null && this.poF != null) {
                this.poF.a(com.kascend.chushou.b.etQ().c);
                this.poF.notifyDataSetChanged();
            }
            FullRoomInfo euJ = this.pqH.euJ();
            if (euJ != null) {
                if (!h.isEmpty(euJ.mRoomToastList)) {
                    Iterator<RoomToast> it = euJ.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.etY().j())) {
                    a(roomToast);
                }
            }
            if (this.poy != null) {
                bk();
            }
            if (this.poy != null && !this.poy.mIsSubscribed) {
                RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.poy == null || !c.this.poy.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.pqH != null && this.pqH.l()) {
                d(true);
            }
        }
        if (this.poy != null && this.poF != null) {
            if (this.poB != null) {
                this.poB.clear();
            } else {
                this.poB = new ArrayList<>();
            }
            this.poF.a(this.poy);
            evy();
            this.poF.a(this.poB.size());
            this.poF.notifyDataSetChanged();
        }
        euY();
        N();
        if (this.pqI != null && (this.pqI instanceof VideoPlayer) && (euv = ((VideoPlayer) this.pqI).euv()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(euv.pmX, euv.b);
        }
        this.pnP.h(this.poy.mCreatorAvatar, com.kascend.chushou.view.a.a(this.poy.mCreatorGender), 0, 0);
        if (this.pqu != null) {
            this.pqu.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.pnT);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void evq() {
        if (this.pot == null) {
            View inflate = LayoutInflater.from(this.pqI).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.plK = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.pot = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.pqI, 160.0f), -2);
            this.pot.setFocusable(false);
            this.pot.setOutsideTouchable(false);
            this.pot.setAnimationStyle(a.j.gift_toast_style);
            this.pot.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.etY().c(roomToast.mToastContent);
            if (this.pot == null) {
                evq();
            }
            if (this.plK != null) {
                this.plK.setText(roomToast.mToastContent);
            }
            if (!this.pot.isShowing()) {
                if (this.pnT != null) {
                    this.pot.showAtLocation(this.pnT, 85, 0, this.pqt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aI(getActivity()));
                    RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.pot != null) {
                                c.this.pot.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.pot.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.ppj != null) {
            this.ppj.setVisibility(z ? 0 : 8);
        }
        this.ppk = true;
        if (this.pqI instanceof VideoPlayer) {
            ((VideoPlayer) this.pqI).p();
        }
    }

    private void evB() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.pqI).s();
        euU();
        evg();
        if (this.pnE == null) {
            this.pnE = (PlayShowRecommendView) ((ViewStub) this.pqt.findViewById(a.f.view_recommend)).inflate();
        }
        this.pnE.setVisibility(0);
        if (this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null && !h.isEmpty(this.pqH.euJ().mRoominfo.mRoomID)) {
            evt();
        }
        if (this.pqu != null) {
            this.pqu.setVisibility(8);
        }
        if (this.prn != null) {
            this.prn.e();
        }
        if (this.pkw != null) {
            this.pkw.setVisibility(4);
        }
        if (this.pno != null) {
            this.pno.setVisibility(8);
        }
        if (this.prv != null) {
            this.prv.eHa();
            this.prv.setVisibility(8);
        }
        AG(false);
        a(false, false);
        if (this.pkb != null) {
            this.pkb.a();
        }
    }

    private void evt() {
        if (this.pnE != null && this.pnE.getVisibility() == 0) {
            this.pnE.a(this.pqH.euJ().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.pqI instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.poc != null && this.poc.b()) {
            this.poc.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.poT);
        if (this.pqI != null) {
            if (this.poT || "10004".equals(((VideoPlayer) this.pqI).t)) {
                this.poT = true;
                if (this.pqH != null) {
                    this.pqH.f = null;
                    if (this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                        this.pqH.euJ().mRoominfo.mGameId = null;
                    }
                }
                evB();
                return;
            }
            this.poT = true;
            if (this.pqI != null) {
                ((VideoPlayer) this.pqI).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.poT = false;
        if (this.pkw != null) {
            this.pkw.setVisibility(0);
        }
        if (this.pno != null) {
            this.pno.setVisibility(0);
        }
        if (this.pnE != null) {
            this.pnE.setVisibility(8);
        }
        if (this.pqC != null) {
            this.pqC.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.poT = false;
        if (this.pkw != null) {
            this.pkw.setVisibility(0);
        }
        if (this.pno != null) {
            this.pno.setVisibility(0);
        }
        if (this.pnE != null) {
            this.pnE.setVisibility(8);
        }
        if (this.pqC != null) {
            this.pqC.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.pnE != null) {
            this.pnE.setVisibility(8);
        }
        if (this.pqu != null) {
            this.pqu.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.pqH != null) {
                        this.pqH.f = null;
                        this.pqH.euJ().mRoominfo.mGameId = null;
                    }
                    evB();
                    return;
                }
                tv.chushou.zues.utils.g.Sc(a.i.str_getvideosource_failed);
            }
            AG(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.pqH != null && this.pqH.euK() != null) {
            a(this.pqH.euK());
        }
        this.p = false;
        if (this.pqH == null || this.pqH.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.pqH.f.size()) {
                if (!"2".equals(this.pqH.f.get(i2).mType)) {
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
    public GiftAnimationLayout evd() {
        if (this.pqt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.pqt.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.pnT != null) {
            int size = iconConfig.configs.size();
            this.pnT.removeAllViews();
            if (this.pnV != null) {
                this.pnV.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.pqI).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.pnT, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.ce(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.ce(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.ce(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.pnV.setVisibility(0);
                            this.pnU.ce(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.ce(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.ce(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.ce(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void ef(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.pnT.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void D() {
        if (this.pqI instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a euq = ((VideoPlayer) this.pqI).euq();
            if (this.prz == null) {
                this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.prz.setVisibility(0);
            this.prz.a(2, euq);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.pnX != null && this.pqI != null) {
            this.pnX.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pnX != null && this.pqI != null) {
            this.pnX.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(long j) {
        if (this.pnX != null) {
            this.pnX.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1001a
    public void c(int i) {
        if (this.pnX != null) {
            this.pnX.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void a(int i) {
        if (this.pnW != null) {
            if (this.pqI != null) {
                this.pnW.a(((VideoPlayer) this.pqI).euq(), false);
            }
            this.pnW.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.pqt != null) {
            Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
            int i = hD.x > hD.y ? 1 : 2;
            if (this.prz == null) {
                this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.prz.setPlayerViewHelper(this.pqH);
            this.prz.setVisibility(0);
            this.prz.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.pnY != null) {
            this.pnY.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.pnY != null) {
            this.pnY.a(bangInfo, str);
        }
        if (this.pkK != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.pkK.setText(this.pqI.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.pkK.setText(this.pqI.getString(a.i.str_contribute_tittle));
            } else {
                this.pkK.setText(Html.fromHtml(this.pqI.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.pnz != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.pnz.setText(this.pqI.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.pnz.setText(this.pqI.getString(a.i.str_contribute_tittle));
            } else {
                this.pnz.setText(Html.fromHtml(this.pqI.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pnY != null) {
            this.pnY.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.pqH != null && !h.isEmpty(this.pqH.pjM)) {
            this.poZ = this.pqH.pjM.get(0);
            if (this.ppr != null) {
                this.ppr.setVisibility(0);
                this.ppr.a(this.poZ.mCover, 0, 0, 0, 1);
                if (this.pps != null) {
                    if (this.poZ.mShowClose) {
                        this.pps.setVisibility(0);
                    } else {
                        this.pps.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.pnY != null) {
            this.pnY.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.pqt != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.plh != null) {
            this.plh.setPanelEnabled(gVar.f4071a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.poQ) {
            if (iVar.f4073a == 52) {
                if (this.poF != null) {
                    this.poF.a(com.kascend.chushou.b.etQ().c);
                    this.poF.notifyDataSetChanged();
                }
            } else if (iVar.f4073a == 50) {
                if (!this.poQ && (iVar.b instanceof ListItem)) {
                    ListItem listItem = (ListItem) iVar.b;
                    if (!h.isEmpty(listItem.mUrl)) {
                        b(listItem);
                    }
                }
            } else if (iVar.f4073a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.pnL != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.pnL);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.poQ) {
            if (bVar.f4152a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.pqI, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                com.kascend.chushou.player.ui.h5.b.b eur = ((VideoPlayer) this.pqI).eur();
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(2, eur);
            } else if (bVar.f4152a == 3) {
                com.kascend.chushou.player.ui.h5.d.a eus = ((VideoPlayer) this.pqI).eus();
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(2, eus);
            } else if (bVar.f4152a == 8) {
                if (this.ppb != null && this.ppb.getVisibility() != 0) {
                    this.ppb.a(a.C0988a.slide_in_bottom_danmu_anim, a.C0988a.slide_out_bottom_danmu_anim, this.poy == null ? "" : this.poy.mRoomID);
                }
            } else if (bVar.f4152a == 9) {
                if (this.prz == null) {
                    this.prz = (H5Container) ((ViewStub) this.pqt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.prz.setVisibility(0);
                this.prz.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.pqH != null && !h.isEmpty(this.pqH.f4119a) && this.pqH.f4119a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.ppb != null && this.ppb.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.pqI, 80.0f);
                }
                if (this.ppa != null && this.ppa.getVisibility() == 0) {
                    r0 = Math.max(r0, this.ppa.getHeight());
                }
                this.ppm.setTranslationY(-r0);
                return;
            }
            if (this.ppl != null) {
                this.ppl.cancel();
                this.ppl = null;
            }
            int translationY = (int) this.ppm.getTranslationY();
            if (aVar.f4151a != 1 && 2 != aVar.f4151a) {
                if (3 == aVar.f4151a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.pqI, 80.0f) : 0;
                    if (this.ppa != null && this.ppa.getVisibility() == 0) {
                        r0 = Math.max(r0, this.ppa.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.ppa.getHeight() : 0;
                    if (this.ppb != null && this.ppb.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.pqI, 80.0f));
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
        this.ppl = ValueAnimator.ofInt(i, i2);
        this.ppl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.pnY != null) {
                    c.this.ppm.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.ppl.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.ppl = null;
            }
        });
        this.ppl.setInterpolator(new LinearInterpolator());
        this.ppl.setDuration(800L);
        this.ppl.start();
    }

    private boolean bg() {
        if (this.poW == 1) {
            this.poW = 2;
            x(true);
            return true;
        } else if (this.poW == 3) {
            evC();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.poW == 1) {
            return bi();
        }
        if (this.poW == 2) {
            this.poW = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.poX || this.pqH == null || this.pqH.euL() == null) {
            return false;
        }
        if (this.ppT != null) {
            this.ppT.a(true);
        }
        this.poW = 3;
        this.poX = true;
        bk();
        this.pnl.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.poX = false;
                c.this.pnn.setVisibility(8);
            }
        });
        this.pnn.startAnimation(loadAnimation);
        this.pnl.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evC() {
        if (!this.poX) {
            if (this.ppT != null) {
                this.ppT.a(false);
            }
            this.poW = 1;
            this.poX = true;
            bk();
            this.pnn.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.poX = false;
                    c.this.pnl.setVisibility(8);
                }
            });
            this.pnn.startAnimation(loadAnimation);
            this.pnl.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.pqt != null) {
            if (this.pnl == null) {
                this.pnl = this.pqt.findViewById(a.f.user_space_container);
            }
            if (this.pnn == null) {
                this.pnn = this.pqt.findViewById(a.f.video_container);
            }
            if (this.pnm == null) {
                this.pnm = com.kascend.chushou.view.user.b.c(null, this.pqH.f4119a, false, this.pqH.h);
                this.pnm.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.evC();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.evC();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.pnm).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.pno != null) {
            this.pno.setVisibility(z ? 8 : 0);
        }
        if (this.pov != null) {
            this.poX = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.pov.setVisibility(8);
                        c.this.poX = false;
                    }
                });
            } else {
                this.poX = true;
                loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.pov.setVisibility(0);
                        c.this.poX = false;
                    }
                });
            }
            this.pov.startAnimation(loadAnimation);
        }
        evf();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.pnF.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.pnN != null) {
                this.pnN.setVisibility(0);
            }
            if (this.pnO != null) {
                this.pnO.a();
                return;
            }
            return;
        }
        if (this.pnQ != null) {
            this.pnQ.setVisibility(0);
        }
        if (this.pnR != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.pnR.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.pnQ != null) {
            this.pnQ.setVisibility(8);
        }
        if (this.pnR != null) {
            this.pnR.clearAnimation();
        }
        if (this.pnN != null) {
            this.pnN.setVisibility(8);
        }
        if (this.pnO != null) {
            this.pnO.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.pov != null && this.pqt != null) {
            if (this.ppb == null) {
                this.ppb = new com.kascend.chushou.player.ui.miniview.a(this.pqI, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.ppb != null && c.this.pqt != null && c.this.ppb.a()) {
                            ((ViewGroup) c.this.pqt).removeView(c.this.ppb);
                            c.this.ppb = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ppb.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.pqI, 52.0f);
                this.ppb.setLayoutParams(layoutParams);
                ((ViewGroup) this.pov).addView(this.ppb, ((ViewGroup) this.pov).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.ppb.setVisibility(8);
                } else {
                    this.ppb.a(a.C0988a.slide_in_bottom_danmu_anim, a.C0988a.slide_out_bottom_danmu_anim, this.pqH.f4119a == null ? "" : this.pqH.f4119a);
                }
            } else if (!this.ppb.isShown()) {
                this.ppb.a(a.C0988a.slide_in_bottom_danmu_anim, a.C0988a.slide_out_bottom_danmu_anim, this.pqH.f4119a == null ? "" : this.pqH.f4119a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.pph != null && !h.isEmpty(listItem.mPackIcon)) {
                this.pph.setVisibility(0);
                this.pph.setAnim(true);
                this.pph.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.qou, b.C1124b.qow, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.poJ != null && this.poJ.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.evD();
                    }
                });
                this.poJ.setVisibility(0);
                this.poJ.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.poJ != null && this.poJ.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.poL != null) {
                        c.this.poL.removeAllListeners();
                        c.this.poL.cancel();
                        c.this.poL = null;
                    }
                    if (c.this.poJ != null) {
                        c.this.poJ.setVisibility(8);
                    }
                }
            });
            this.poJ.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.ppp == null) {
                this.ppp = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.pqI, "显示双击666_num", null, new Object[0]);
                            if (c.this.pqH != null) {
                                c.this.pqH.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.pqJ != null) {
                    this.pqJ.f(this.ppp, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.ppp != null) {
            this.pqJ.N(this.ppp);
            this.ppp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.poM != null && this.poM.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.pqI, a.C0988a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.evE();
                    }
                });
                this.poM.setVisibility(0);
                this.poM.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.pqs, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.poM != null && this.poM.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.pqI, a.C0988a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.poO != null) {
                        c.this.poO.removeAllListeners();
                        c.this.poO.cancel();
                        c.this.poO = null;
                    }
                    if (c.this.poM != null) {
                        c.this.poM.setVisibility(8);
                    }
                }
            });
            this.poM.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evD() {
        if (this.poJ == null || this.poK == null) {
            return null;
        }
        if (this.poL != null) {
            this.poL.removeAllListeners();
            this.poL.cancel();
            this.poL = null;
        }
        this.poK.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.poK, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.poK, 0.0f);
        int measuredWidth = (this.poJ.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.pqI, 13.0f) * 2)) - this.poK.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.poK, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.poK, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.poK, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.poL != null) {
                    c.this.poL.removeAllListeners();
                    c.this.poL.cancel();
                    c.this.poL = null;
                }
                RxExecutor.postDelayed(c.this.pqs, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.evD();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.poL = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evE() {
        if (this.poM == null || this.poN == null) {
            return null;
        }
        if (this.poO != null) {
            this.poO.removeAllListeners();
            this.poO.cancel();
            this.poO = null;
        }
        this.poN.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.poN, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.poN, 0.0f);
        int measuredWidth = (this.poM.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.pqI, 13.0f) * 2)) - this.poN.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.poN, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.poN, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.poN, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.poO != null) {
                    c.this.poO.removeAllListeners();
                    c.this.poO.cancel();
                    c.this.poO = null;
                }
                RxExecutor.postDelayed(c.this.pqs, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.evE();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.poO = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.ppT = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.pkj != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.pkj.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eH = com.kascend.chushou.c.a.eH(jSONObject);
                        if (eH.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Sc(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Sc(a.i.subscribe_success);
                            }
                            if (c.this.pkj != null) {
                                c.this.pkj.isSubscribe = !z;
                                c.this.euZ();
                                return;
                            }
                            return;
                        }
                        a(eH.mRc, eH.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.A(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.etT().a(bVar, (String) null, this.pkj.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.pkj.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.etT().b(bVar, (String) null, c.this.pkj.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.pqH != null && this.poy != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.pqH.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.pqH.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.poy.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eH = com.kascend.chushou.c.a.eH(jSONObject);
                        if (eH.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Sc(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Sc(a.i.subscribe_success);
                            }
                            c.this.poy.mIsSubscribed = !z;
                            c.this.eva();
                            return;
                        }
                        a(eH.mRc, eH.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.A(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.etT().a(bVar, (String) null, this.poy.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.poy.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.etT().b(bVar, (String) null, c.this.poy.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.pmW != null) {
            int width = this.pmW.getWidth();
            int height = this.pmW.getHeight();
            if (this.ppf != width || this.ppg != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void evj() {
        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.pqt != null) {
            if (this.pnS == null) {
                this.pnS = (InteractionView) ((ViewStub) this.pqt.findViewById(a.f.view_interaction)).inflate();
                this.pnS.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.pnS.a();
                    }
                });
            }
            if (this.pnS != null) {
                this.pnS.b(configDetail);
                this.pnS.c();
                this.pnS.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eHM()) {
                tv.chushou.zues.utils.g.O(this.pqI, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.pqI, null) && (this.pqI instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.pqH != null) {
                com.kascend.chushou.toolkit.a.c.a(this.pqI, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.pqI, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.pqH != null) {
                com.kascend.chushou.toolkit.a.c.a(this.pqI, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.pqI, configDetail.mUrl, this.pqI.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.pqI, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.poS) {
                        evn();
                        return;
                    }
                    if (this.pqI.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.pqI, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.pqH != null && this.pqH.euJ() != null && this.pqH.euJ().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.pqH.euJ().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.pnT);
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
        if (this.pqI != null && !this.v && !h.isEmpty(str) && this.poy != null && str.equals(this.poy.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.pkf == null) {
                this.pkf = new com.kascend.chushou.player.e.a();
            }
            this.pkf.b = str;
            this.pkf.pmX.copy(pkNotifyInfo);
            if (this.pkf.pmX.mAction == 6) {
                if (this.pkb != null) {
                    this.pkb.a(true);
                }
                this.pkf.pmX.mInPKMode = true;
                this.u = this.pkf.pmX.mPkId;
            } else if (this.pkf.pmX.mAction == 7 || (this.pkf.pmX.mMode == 1 && this.pkf.pmX.mAction == 5)) {
                if (this.pkb != null) {
                    this.pkb.a(true);
                }
                this.pkf.pmX.mInPKMode = true;
                if (this.ppd != 42) {
                    this.ppq = ((this.ppe.y - ((this.ppe.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.pqI, 158.0f) + this.poq)) - tv.chushou.zues.utils.systemBar.b.aI(getActivity());
                    aX();
                }
                this.u = this.pkf.pmX.mPkId;
                if (this.pkh != null) {
                    this.pkh.b(this.pkf.pmX, false);
                    this.pkh.a(this.pkf.pmX.mMode, (String) null);
                    if (this.pkf.pmX.mAction == 5 && this.pkf.pmX.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.pkf.pmX.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.pkf.pmX.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.pkf.pmX.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.pkf.pmX.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.pkf.pmX.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.pkh.a(this.pkf.pmX);
                        this.pkh.a(parseInt, this.pkf.pmX.mPkUpdateInfo.remainDuration, j, this.pkf.pmX.mMode, (this.pkf.pmX.destinyInfo == null || this.pkf.pmX.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.pkf.pmX.mPkUpdateInfo != null && !h.isEmpty(this.pkf.pmX.mPkUpdateInfo.specialMomentList) && this.pkh != null) {
                    this.pkh.a(this.pkf.pmX, true);
                }
                if (this.pkf.pmX.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.pkf.pmX.mInPKMode = false;
                if (this.pkf.pmX.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        evk();
        evi();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.pom != null && this.pqH != null && this.pqH.pjN != null) {
            this.pom.setText(tv.chushou.zues.utils.b.Sb(this.pqH.pjN.count));
            this.pom.setVisibility(0);
            if (this.pqH.pjN.count < 1) {
                bo();
            }
            if (this.poe != null) {
                this.poe.setText(this.pqH.pjN.primaryName);
            }
            if (this.pof != null) {
                this.pof.setText(this.pqH.pjN.desc);
            }
            euV();
        }
    }

    public void euV() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.pon * h.parseLong(this.pqH.pjN.point)));
        if (this.plz != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.pqI.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.R(this.pqI, a.e.icon_coin_new);
            cVar.append(this.pqI.getString(a.i.str_buy_count_coin2));
            this.plz.setText(cVar);
        }
    }

    private void evF() {
        if (com.kascend.chushou.d.e.c(this.pqI, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.pon);
        }
    }

    private void bo() {
        this.poo = false;
        this.pol.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.pqH != null && this.pqH.pjN != null) {
            if (this.pqH.pjN.count < 1) {
                this.pom.setVisibility(8);
            } else {
                this.pom.setVisibility(0);
                this.pom.setSelected(false);
                this.pom.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.pod.setVisibility(8);
        if (this.pnL != null) {
            this.pnL.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.pkl != null) {
            if (z) {
                this.pkl.setVisibility(0);
            } else {
                this.pkl.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.ppQ != null) {
            this.ppQ.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pnU != null) {
            this.pnU.performClick();
        }
    }
}
