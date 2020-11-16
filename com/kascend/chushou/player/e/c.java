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
    private View plZ;
    private TextView pmC;
    private KPSwitchPanelLinearLayout pmK;
    private ImageView pmL;
    private tv.chushou.zues.widget.kpswitch.b.c pmM;
    private d.a pmN;
    public String pmg;
    private TextView pmk;
    private TextView pmn;
    private ImageView pmt;
    private TextView pnc;
    private TextView pnn;
    private View pnq;
    private int poP;
    private View poQ;
    private View poR;
    private com.kascend.chushou.view.user.b poS;
    private View poT;
    private FrameLayout poU;
    private LinearLayout poV;
    private RelativeLayout poW;
    private FrescoThumbnailView poX;
    private TextView poY;
    private TextView poZ;
    private TextView poo;
    private LinearLayout ppA;
    private FrescoThumbnailView ppB;
    private FrameLayout ppC;
    private RedpacketNotifier ppD;
    private InteractNotifier ppE;
    private EmbeddedButtonLayout ppF;
    private GiftAnimationLayout ppG;
    private com.kascend.chushou.player.b.a ppH;
    private f ppI;
    private PlayShowH5View ppJ;
    private LinearLayout ppK;
    private TextView ppL;
    private TextView ppM;
    private TextView ppN;
    private TextView ppO;
    private TextView ppP;
    private TextView ppQ;
    private ImageView ppR;
    private TextView ppS;
    private PopupWindow ppX;
    private View ppZ;
    private TextView ppa;
    private FrescoThumbnailView ppb;
    private TextView ppc;
    private TextView ppd;
    private TextView ppe;
    private TextView ppf;
    private LinearLayout ppg;
    private PlayShowMicStatusView pph;
    private RecyclerView ppj;
    private ImageView ppk;
    private PlayShowRecommendView ppl;
    private View ppm;
    private RelativeLayout ppn;
    private AnimationSet ppo;
    private ImageView ppp;
    private ImageView ppq;
    private RelativeLayout ppr;
    private PastedEditText pps;
    private ToggleButton ppt;
    private RelativeLayout ppu;
    private PaoPaoView ppv;
    private FrescoThumbnailView ppw;
    private LinearLayout ppx;
    private ImageView ppy;
    private InteractionView ppz;
    private FoodView pqC;
    public ListItem pqD;
    private FoodView pqE;
    private com.kascend.chushou.player.ui.miniview.a pqF;
    private int pqG;
    private int pqH;
    private Point pqI;
    private FrescoThumbnailView pqL;
    private FrescoThumbnailView pqM;
    private ValueAnimator pqO;
    private LinearLayout pqP;
    private long pqQ;
    private VideoShowVoteView pqR;
    private Runnable pqS;
    private FrescoThumbnailView pqU;
    private ImageView pqV;
    private RelativeLayout pqW;
    private TextView pqX;
    private ImageView pqY;
    private EditText pqZ;
    private RecyclerView pqb;
    private RoomInfo pqc;
    private RecyclerView.LayoutManager pqe;
    private ArrayList<ChatInfo> pqf;
    private ArrayList<ChatInfo> pqg;
    private ArrayList<ChatInfo> pqh;
    private ArrayList<ChatInfo> pqi;
    private Button pqm;
    private View pqn;
    private View pqo;
    private Animator pqp;
    private View pqq;
    private View pqr;
    private Animator pqs;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> pqv;
    private PlayShowMicPerson pqy;
    private View pra;
    private RelativeLayout prb;
    private RelativeLayout prc;
    private FrescoThumbnailView prd;
    private TextView pre;
    private TextView prf;
    private ImageView prg;
    private RelativeLayout prh;
    private LinearLayout pri;
    private TextView prj;
    private TextView prk;
    private RelativeLayout prl;
    private RelativeLayout prm;
    private FrescoThumbnailView prn;
    private TextView pro;
    private TextView prp;
    private ImageView prq;
    private RelativeLayout prr;
    private TextView prt;
    private float pru;
    private float prv;
    private a prw;
    private boolean cp = false;
    private int ppT = 1;
    private boolean ppU = false;
    private int ppV = 0;
    private int ppW = 0;
    private int ppY = -1;
    private boolean pqa = false;
    private FullRoomInfo pqd = null;
    private com.kascend.chushou.player.adapter.a pqj = null;
    private ArrayList<String> pqk = null;
    private boolean pql = true;
    private boolean pqt = true;
    private boolean pqu = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean pqw = false;
    private boolean pqx = false;
    private long pqz = 0;
    private int pqA = 1;
    private boolean pqB = false;
    private int pqJ = -1;
    private int pqK = -1;
    private boolean pqN = false;
    private int pqT = -1;
    private io.reactivex.disposables.b prs = null;

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
        this.pmg = getArguments().getString("cover");
        this.pqt = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.prW = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.prW;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            euX();
            this.poC = ((VideoPlayer) this.psl).euh();
            this.psk = ((VideoPlayer) this.psl).euk();
            d(view);
            evh();
            if (this.psl instanceof VideoPlayer) {
                ((VideoPlayer) this.psl).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.pqu = false;
        if (this.psQ != null) {
            this.psQ.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.pqu = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.pqp != null) {
            this.pqp.removeAllListeners();
            this.pqp.cancel();
            this.pqp = null;
        }
        if (this.pqs != null) {
            this.pqs.removeAllListeners();
            this.pqs.cancel();
            this.pqs = null;
        }
        if (this.ppE != null) {
            this.ppE.c();
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
        if (this.prs != null) {
            this.prs.dispose();
            this.prs = null;
        }
        this.ppT = 1;
        this.ppU = false;
        if (this.psm != null) {
            this.psm.ct(null);
        }
        if (this.ppX != null) {
            this.ppX.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.psl, this.pmM);
        if (this.psl != null && (this.psl instanceof VideoPlayer)) {
            ((VideoPlayer) this.psl).euo();
        }
        this.pmN = null;
        this.pmM = null;
        aI();
        if (this.ppH != null) {
            this.ppH.a();
        }
        if (this.ppv != null) {
            this.ppv.b();
            this.ppv.c();
            this.ppv = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.cu(this);
        if (this.pqh != null) {
            this.pqh.clear();
        }
        if (this.pqf != null) {
            this.pqf.clear();
        }
        if (this.pqi != null) {
            this.pqi.clear();
        }
        if (this.pqg != null) {
            this.pqg.clear();
        }
        if (this.pqk != null) {
            this.pqk.clear();
        }
        if (this.pqj != null) {
            this.pqj.a(0);
            this.pqj.a();
        }
    }

    private void d(View view) {
        this.poQ = view.findViewById(a.f.fl_root);
        this.pqI = tv.chushou.zues.utils.a.hC(this.psl);
        this.ppV = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.psl);
        this.ppW = tv.chushou.zues.utils.systemBar.b.aH(getActivity());
        this.pqH = 86;
        this.psk = ((VideoPlayer) this.psl).euk();
        if (this.psk != null) {
            this.pqc = this.psk.euL();
            this.pqd = this.psk.euJ();
        }
        this.pqf = new ArrayList<>();
        this.pqh = new ArrayList<>();
        this.pqg = new ArrayList<>();
        this.poU = (FrameLayout) this.prW.findViewById(a.f.fl_effect);
        b();
        this.psf = (PlayerErrorView) this.prW.findViewById(a.f.view_net_error_msg);
        this.psf.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.ppu = (RelativeLayout) this.prW.findViewById(a.f.rl_audio_ani);
        this.ppv = (PaoPaoView) this.prW.findViewById(a.f.audio_ani);
        this.ppw = (FrescoThumbnailView) this.prW.findViewById(a.f.audio_ani_avatar);
        this.ppx = (LinearLayout) this.prW.findViewById(a.f.ll_audio);
        this.poo = (TextView) this.prW.findViewById(a.f.tv_open_video);
        this.ppy = (ImageView) this.prW.findViewById(a.f.iv_audio_ani);
        this.pqM = (FrescoThumbnailView) this.prW.findViewById(a.f.live_cover);
        if (!this.pqN || this.poC == null || this.poC.getPlayState() != 4) {
            this.pqM.setVisibility(0);
            this.pqM.setBlur(true);
            this.pqM.i(this.pmg, 0, 0, 0);
        }
        this.poo.setOnClickListener(this);
        this.plK = new b();
        this.plK.a(view, null, this.psl, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cHI()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.psk != null) {
                    append.append(c.this.psk.euL().mRoomID);
                }
                if (c.this.plJ != null && c.this.plJ.poD != null) {
                    append.append("&mode=").append(c.this.plJ.poD.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.psl, append.toString());
            }
        });
        this.plO = (VoiceInteractionView) this.prW.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.psk != null) {
            this.pqc = this.psk.euL();
            this.pqd = this.psk.euJ();
        }
        aL();
        euW();
        evc();
        this.pqP = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.pqC = (FoodView) view.findViewById(a.f.rav_ad);
        this.pqU = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.pqV = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.pqU.setOnClickListener(this);
        this.pqV.setOnClickListener(this);
        this.pqW = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.pqL = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.pqL.setOnClickListener(this);
        this.ppE = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.ppD = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.pqm = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.pqm.setOnClickListener(this);
        this.pqb = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.pqb.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pqb.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.pqI.x, this.pqI.y) * 0.83d);
        this.pqb.setLayoutParams(layoutParams);
        this.pqe = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.psl);
        this.pqb.setLayoutManager(this.pqe);
        this.pqb.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.pqb.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.pqb.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.evp();
                } else if (i == 1) {
                    c.this.pql = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.pqj = new com.kascend.chushou.player.adapter.a(this.psl, this.pqf);
        if (this.pqc != null) {
            this.pqj.a(this.pqc);
        }
        if (com.kascend.chushou.b.etQ().c != null) {
            this.pqj.a(com.kascend.chushou.b.etQ().c);
        }
        this.pqb.setAdapter(this.pqj);
        this.pqj.a(this.pqf.size());
        this.pqj.notifyDataSetChanged();
        if (this.psk != null && (c = this.psk.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.ppH != null) {
            this.ppH.a();
            this.ppH = null;
        }
        this.ppG = (GiftAnimationLayout) this.prW.findViewById(a.f.ll_gift_animation);
        this.ppG.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.poP = ((int) (tv.chushou.zues.utils.a.hB(this.psl).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.psl, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ppG.getLayoutParams();
        layoutParams2.bottomMargin = this.poP;
        this.ppG.setLayoutParams(layoutParams2);
        if (this.psk != null) {
            this.ppH = new com.kascend.chushou.player.b.a(this.psl.getApplicationContext(), this.ppG);
            this.ppH.a(this.psk);
            a(this.psk.plp, this.psk.pls);
        }
        this.prW.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.ppF = (EmbeddedButtonLayout) this.prW.findViewById(a.f.embedded_button_layout);
        this.ppF.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.pqR = (VideoShowVoteView) this.prW.findViewById(a.f.view_video_show_vote);
        this.pqR.setOnClickListener(this);
        this.pqR.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.psk != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.psl;
            this.ppF.a(videoPlayer.euu().evO());
            this.ppF.b(this.psk.i());
            this.ppD.a(videoPlayer.euq(), false);
            this.ppE.a(videoPlayer.eur(), videoPlayer.eus(), videoPlayer.eut());
            this.plJ = new com.kascend.chushou.player.e.a();
        }
        this.pta = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.pqw = false;
                c.this.b(c.this.poP, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.pqw = true;
                if (c.this.psQ != null) {
                    c.this.psQ.measure(0, 0);
                    int measuredHeight = c.this.psQ.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.psl, 14.0f);
                    if (measuredHeight > c.this.poP) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.psU = (PaoGuideView) this.prW.findViewById(a.f.rlPaoGuideView);
        this.pqy = (PlayShowMicPerson) this.prW.findViewById(a.f.rl_mic_person_view);
        this.ppJ = (PlayShowH5View) this.prW.findViewById(a.f.rl_playshowh5);
        this.pqE = (FoodView) this.prW.findViewById(a.f.bottom_ad);
        if (this.psk != null) {
            H();
            if (this.psk.pli != null && !h.isEmpty(this.psk.pli.mUrl)) {
                b(this.psk.pli);
            }
        }
        this.pqn = this.prW.findViewById(a.f.view_reminder_subscribe);
        this.pqo = this.pqn.findViewById(a.f.spash_subscribe);
        ((TextView) this.pqn.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().R(this.psl, a.e.videoplayer_reminder_subscribe).append(" ").append(this.psl.getString(a.i.videoplayer_reminder_subscribe)));
        this.pqn.setOnClickListener(this);
        this.pqq = this.prW.findViewById(a.f.view_reminder_danmaku);
        this.pqr = this.pqq.findViewById(a.f.spash_danmaku);
        ((TextView) this.pqq.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().R(this.psl, a.e.videoplayer_reminder_danmaku).append(" ").append(this.psl.getString(a.i.videoplayer_reminder_danmaku)));
        this.pqq.setOnClickListener(this);
    }

    private void euW() {
        this.prb = (RelativeLayout) this.prW.findViewById(a.f.rl_cyclelive);
        this.prc = (RelativeLayout) this.prW.findViewById(a.f.rlrl_cyclelive);
        this.prd = (FrescoThumbnailView) this.prW.findViewById(a.f.iv_liveicon);
        this.pre = (TextView) this.prW.findViewById(a.f.tv_livename);
        this.prf = (TextView) this.prW.findViewById(a.f.tv_livedesc);
        this.prg = (ImageView) this.prW.findViewById(a.f.iv_cyclelive_name_menu);
        this.prh = (RelativeLayout) this.prW.findViewById(a.f.rl_normal);
        this.pri = (LinearLayout) this.prW.findViewById(a.f.ll_cyclelive_nickname);
        this.prj = (TextView) this.prW.findViewById(a.f.tv_cyclelive_nickname);
        this.prk = (TextView) this.prW.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.prl = (RelativeLayout) this.prW.findViewById(a.f.rl_clear_cyclelive);
        this.prm = (RelativeLayout) this.prW.findViewById(a.f.rlrl_clear_cyclelive);
        this.prn = (FrescoThumbnailView) this.prW.findViewById(a.f.iv_clear_liveicon);
        this.pro = (TextView) this.prW.findViewById(a.f.tv_clear_livename);
        this.prp = (TextView) this.prW.findViewById(a.f.tv_clear_livedesc);
        this.prq = (ImageView) this.prW.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.prr = (RelativeLayout) this.prW.findViewById(a.f.rl_clear_normal);
        this.prq.setOnClickListener(this);
        this.prg.setOnClickListener(this);
        this.prk.setOnClickListener(this);
        this.prj.setOnClickListener(this);
        this.prd.setOnClickListener(this);
        this.prn.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.psk.plg != null && this.pqE != null) {
            this.pqE.a(true, this.psk.f4119a == null ? "" : this.psk.f4119a);
            this.pqE.a(this.psk.plg, a.C0991a.slide_in_bottom_danmu_anim, a.C0991a.slide_out_bottom_danmu_anim, true);
        }
        if (this.psk != null && this.psk.pln != null && this.ppF != null) {
            this.pqC.a(this.psk.pln, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.psk != null) {
                        c.this.psk.pln = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a evo() {
        return this.ppH;
    }

    private void euX() {
        this.psm = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.prW != null && (textView = (TextView) c.this.prW.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.psl.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.psm.D(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.psm);
                        break;
                    case 12:
                        c.this.b(c.this.psm);
                        break;
                    case 17:
                        c.this.evJ();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.psj.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.pqa) {
            this.pqa = true;
            if (this.ppZ == null) {
                this.ppZ = this.prW.findViewById(a.f.vs_async_show_content);
                this.ppZ = ((ViewStub) this.ppZ).inflate();
            }
            this.plZ = this.prW.findViewById(a.f.ui_content);
            if (this.pnq == null) {
                this.pnq = this.prW.findViewById(a.f.vs_async_notification_view);
                this.pnq = ((ViewStub) this.pnq).inflate();
            }
            c(this.prW);
            k();
            edU();
            if (this.c == null) {
                this.plD = new d.a();
                this.c = new GestureDetector(this.psl, this.plD);
            }
            ((VideoPlayer) this.psl).q();
        }
    }

    private void aL() {
        this.poV = (LinearLayout) this.prW.findViewById(a.f.ll_anchor);
        this.poW = (RelativeLayout) this.prW.findViewById(a.f.ll_clear_anchor);
        this.poV.setVisibility(4);
        this.poW.setVisibility(4);
        this.poX = (FrescoThumbnailView) this.prW.findViewById(a.f.iv_clear_avatar);
        this.poY = (TextView) this.prW.findViewById(a.f.tv_clear_nickname);
        this.poZ = (TextView) this.prW.findViewById(a.f.tv_clear_online_count);
        this.ppa = (TextView) this.prW.findViewById(a.f.tv_clear_btn_subscribe);
        this.ppa.setOnClickListener(this);
        this.ppb = (FrescoThumbnailView) this.prW.findViewById(a.f.iv_avatar);
        this.ppc = (TextView) this.prW.findViewById(a.f.tv_nickname_test);
        this.ppd = (TextView) this.prW.findViewById(a.f.tv_online_count);
        this.pmk = (TextView) this.prW.findViewById(a.f.tv_btn_subscribe);
        this.pmk.setOnClickListener(this);
        this.ppe = (TextView) this.prW.findViewById(a.f.tv_loyal_counts);
        this.pmn = (TextView) this.prW.findViewById(a.f.tv_btn_contribution);
        this.ppf = (TextView) this.prW.findViewById(a.f.tv_btn_contribution_forpk);
        this.pmn.setVisibility(4);
        this.ppf.setVisibility(8);
        this.ppg = (LinearLayout) this.prW.findViewById(a.f.ll_mic);
        this.pph = (PlayShowMicStatusView) this.prW.findViewById(a.f.show_mic_status);
        this.ppj = (RecyclerView) this.prW.findViewById(a.f.rv_loyal);
        this.ppk = (ImageView) this.prW.findViewById(a.f.iv_clear_close);
        this.pmt = (ImageView) this.prW.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.ppj.setLayoutManager(linearLayoutManager);
        this.pqv = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void K(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.psl, (JSONObject) null, c.this.psk.euL().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1124a view$OnLongClickListenerC1124a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1124a view$OnLongClickListenerC1124a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC1124a.sE(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC1124a.sE(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1124a.sE(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.eHF(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.psl, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.psl, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.psl, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.psl, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.psl, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.cb(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.ppj.setAdapter(this.pqv);
        this.ppg.setOnClickListener(this);
        this.poX.setOnClickListener(this);
        this.ppk.setOnClickListener(this);
        this.ppb.setOnClickListener(this);
        this.poX.setOnClickListener(this);
        this.pmt.setOnClickListener(this);
        this.ppe.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void em(View view) {
                String str = tv.chushou.common.a.cHI() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.psk != null) {
                    str = str + c.this.psk.euL().mRoomID;
                }
                c.this.f(c.this.psl.getString(a.i.str_loyal_fans), str);
            }
        });
        this.pmn.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void em(View view) {
                String str = tv.chushou.common.a.cHI() + "m/room-billboard/";
                if (c.this.psk != null) {
                    str = str + c.this.psk.euL().mRoomID;
                }
                c.this.f(c.this.psl.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.ppf.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void em(View view) {
                String str = tv.chushou.common.a.cHI() + "m/room-billboard/";
                if (c.this.psk != null) {
                    str = str + c.this.psk.euL().mRoomID;
                }
                c.this.f(c.this.psl.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.pqd == null || this.pqd.cycleLiveRoomInfo == null || h.isEmpty(this.pqd.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.plM = this.pqd.cycleLiveRoomInfo;
        }
        if (z2 && this.plM != null) {
            this.prb.setVisibility(0);
            this.prl.setVisibility(0);
            this.prh.setVisibility(8);
            this.prr.setVisibility(8);
            this.pri.setVisibility(0);
            this.prn.h(this.plM.eventIcon, com.kascend.chushou.view.a.a(this.pqc.mCreatorGender), b.a.small, b.a.small);
            this.prd.h(this.plM.eventIcon, com.kascend.chushou.view.a.a(this.pqc.mCreatorGender), b.a.small, b.a.small);
            this.pro.setText(this.plM.eventName);
            this.prp.setText(this.plM.eventDesc);
            this.pre.setText(this.plM.eventName);
            this.prf.setText(this.plM.eventDesc);
            this.prj.setText(this.plM.nickname);
            euZ();
            if (z) {
                c(this.plM.remainTime);
                return;
            }
            return;
        }
        this.prb.setVisibility(8);
        this.prl.setVisibility(8);
        this.prh.setVisibility(0);
        this.prr.setVisibility(0);
        this.pri.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.prs != null) {
            this.prs.dispose();
            this.prs = null;
        }
        this.prs = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.eAC()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.psl != null && (c.this.psl instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.psl).u();
                }
            }
        });
    }

    private void euY() {
        if (this.pqc != null && this.pqa) {
            this.poV.setVisibility(0);
            this.poW.setVisibility(0);
            this.pmn.setVisibility(0);
            this.poX.h(this.pqc.mCreatorAvatar, com.kascend.chushou.view.a.a(this.pqc.mCreatorGender), b.a.small, b.a.small);
            this.poY.setText(this.pqc.mCreatorNickname);
            this.ppb.h(this.pqc.mCreatorAvatar, com.kascend.chushou.view.a.a(this.pqc.mCreatorGender), b.a.small, b.a.small);
            this.ppc.setText(this.pqc.mCreatorNickname);
            evA();
            eva();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void evA() {
        if (this.pqc != null) {
            this.poZ.setText(tv.chushou.zues.utils.b.formatNumber(this.pqc.mOnlineCount));
            this.ppd.setText(tv.chushou.zues.utils.b.formatNumber(this.pqc.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euZ() {
        if (this.plM != null) {
            if (this.plM.isSubscribe) {
                this.prk.setText(a.i.like_already);
                this.prk.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.prk.setText(getString(a.i.like));
            this.prk.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eva() {
        if (this.pqc != null) {
            if (this.pqc.mIsSubscribed) {
                this.ppa.setText(getString(a.i.like_already));
                this.ppa.setBackgroundResource(a.e.bg_show_subcribe);
                this.pmk.setText(getString(a.i.like_already));
                this.pmk.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.ppa.setText(getString(a.i.like));
            this.ppa.setBackgroundResource(a.e.bg_show_subcribe);
            this.pmk.setText(getString(a.i.like));
            this.pmk.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void evb() {
        if (this.pqv != null) {
            this.pqv.notifyDataSetChanged();
        }
    }

    private void evc() {
        this.ppm = this.prW.findViewById(a.f.tv_interact);
        this.ppm.setOnClickListener(this);
        this.ppr = (RelativeLayout) this.prW.findViewById(a.f.rl_edit_bar);
        this.ppp = (ImageView) this.prW.findViewById(a.f.btn_hotword);
        this.ppp.setOnClickListener(this);
        this.ppq = (ImageView) this.prW.findViewById(a.f.iv_task_badge);
        this.ppo = (AnimationSet) AnimationUtils.loadAnimation(this.psl, a.C0991a.anim_hotword);
        this.ppo.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.etY().c) {
                    c.this.ppp.clearAnimation();
                    c.this.ppp.startAnimation(c.this.ppo);
                }
            }
        });
        if (com.kascend.chushou.d.h.etY().c) {
            this.ppp.startAnimation(this.ppo);
            this.ppq.setVisibility(0);
        }
        this.prt = (TextView) this.prW.findViewById(a.f.tv_bottom_input);
        this.prt.setOnClickListener(this);
        this.ptl = (FrescoThumbnailView) this.prW.findViewById(a.f.ll_btn_set);
        this.ptl.setOnClickListener(this);
        this.ptl.Ev(a.e.ic_room_set_btn_white);
        this.ppA = (LinearLayout) this.prW.findViewById(a.f.ll_bottom_all_button);
        this.ppB = (FrescoThumbnailView) this.prW.findViewById(a.f.fl_clear_bottom_gift);
        this.ppB.setAnim(true);
        this.ppB.setOnClickListener(this);
        this.ppB.Ev(a.e.ic_show_gift_n);
        this.ppC = (FrameLayout) this.prW.findViewById(a.f.flfl_clear_bottom_gift);
        this.ppC.setVisibility(8);
        this.ppn = (RelativeLayout) this.prW.findViewById(a.f.rl_bottom_input);
        this.ppn.setVisibility(0);
        this.pps = (PastedEditText) this.prW.findViewById(a.f.et_bottom_input);
        this.pps.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.pmC.setEnabled(editable.length() > 0);
            }
        });
        this.pps.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.pmC);
                    return true;
                }
                return true;
            }
        });
        this.pps.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.pps);
                }
                return false;
            }
        });
        this.pmL = (ImageView) this.prW.findViewById(a.f.iv_btn_emoji);
        this.pmL.setVisibility(8);
        this.pmC = (TextView) this.prW.findViewById(a.f.tv_btn_send);
        this.pmC.setOnClickListener(this);
        this.ppK = (LinearLayout) this.prW.findViewById(a.f.head_trumpet);
        this.ppK.setVisibility(8);
        this.ppK.setOnClickListener(this);
        this.ppL = (TextView) this.prW.findViewById(a.f.tv_primary_name);
        this.ppM = (TextView) this.prW.findViewById(a.f.tv_primary_desc);
        this.ppO = (TextView) this.prW.findViewById(a.f.tv_cut_count);
        this.ppO.setOnClickListener(this);
        this.ppQ = (TextView) this.prW.findViewById(a.f.tv_head_count);
        this.ppQ.setText(this.ppT + "");
        this.ppP = (TextView) this.prW.findViewById(a.f.tv_plus_count);
        this.ppP.setOnClickListener(this);
        this.pnc = (TextView) this.prW.findViewById(a.f.tv_buy_count_coin);
        this.ppN = (TextView) this.prW.findViewById(a.f.tv_buy_head);
        this.ppN.setOnClickListener(this);
        this.ppR = (ImageView) this.prW.findViewById(a.f.iv_trumpet_select);
        this.ppR.setOnClickListener(this);
        this.ppS = (TextView) this.prW.findViewById(a.f.tv_trumpet_have_count);
        this.ppU = false;
        this.ppR.setBackgroundResource(a.e.ic_trumpet_n);
        this.ppS.setVisibility(8);
        this.pmK = (KPSwitchPanelLinearLayout) this.prW.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.pmK, this.pmL, this.pps, new a.InterfaceC1128a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1128a
            public void AL(boolean z) {
                if (c.this.pmL != null) {
                    if (z) {
                        c.this.pmK.setDirectVisibility(0);
                        c.this.pmL.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.pmL.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.pmN = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void kh(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.pmL.setImageResource(a.e.cs_emoji_normal);
                    c.this.eve();
                    if (c.this.pra != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.pra.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.psl);
                        c.this.pra.setLayoutParams(layoutParams);
                    }
                    if (c.this.ppr != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.ppr.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.psl);
                        c.this.ppr.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.pra != null && c.this.pra.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.pra.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.pra.setLayoutParams(layoutParams3);
                    c.this.pra.setVisibility(8);
                }
                if (c.this.pqw) {
                    c.this.psQ.setVisibility(0);
                }
                if (c.this.psl != null && (c.this.psl instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.psl).AK(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.ppr != null && c.this.pmK.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.ppr.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.ppr.setLayoutParams(layoutParams4);
                }
            }
        };
        this.pmM = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.pmK, this.pmN, ((VideoPlayer) this.psl).eup());
        ((VideoPlayer) this.psl).h(((VideoPlayer) this.psl).eup());
        this.pra = this.prW.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.pqX = (TextView) this.prW.findViewById(a.f.btn_room_search);
        this.pqY = (ImageView) this.prW.findViewById(a.f.iv_room_emoji_delete);
        this.pqZ = (EditText) this.prW.findViewById(a.f.et_room_emoji_search);
        this.pqZ.setImeOptions(3);
        this.pqZ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.pqX);
                    return true;
                }
                return false;
            }
        });
        this.pqZ.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.pqX.setEnabled(editable.length() > 0);
                c.this.pqY.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.psQ.setEmojiSearchText(editable.toString());
            }
        });
        this.pqX.setOnClickListener(this);
        this.pqY.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aG(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bG(this.pqZ);
            this.pra.setVisibility(0);
            this.pqZ.requestFocus();
        } else {
            this.pra.setVisibility(8);
        }
        if (z2) {
            this.pqZ.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eve() {
        int ek = tv.chushou.zues.widget.kpswitch.b.d.ek(this.psl) + tv.chushou.zues.utils.a.dip2px(this.psl, 14.0f);
        if (ek > this.poP) {
            b(ek, 12);
        }
    }

    private void aS() {
    }

    private void evh() {
        if (this.ppW > 0) {
            View findViewById = this.prW.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.ppW);
        }
        if (this.ppV > 0) {
            View findViewById2 = this.prW.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.ppV, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.pqt) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.plF = ((VideoPlayer) this.psl).eul();
        this.plF.a(this);
        if (this.psk.euJ() != null) {
            s();
        } else if (this.prX != null) {
            this.prX.setVisibility(0);
        }
        if (this.plF != null) {
            this.plF.d();
        }
    }

    private void evi() {
        if ((this.plJ == null || this.plJ.poD == null || !this.plJ.poD.mInPKMode) ? false : true) {
            if (this.poQ != null) {
                this.poQ.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.plL.getLayoutParams();
            layoutParams.leftMargin = (this.pqI.x / 2) + tv.chushou.zues.utils.a.dip2px(this.psl, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.plL.setLayoutParams(layoutParams);
            this.y.setText(this.plJ.poD.mPkUserNickname);
            this.plL.setVisibility(0);
            this.ppg.setVisibility(8);
            return;
        }
        if (this.poQ != null) {
            this.poQ.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.plL.setVisibility(8);
    }

    private void evk() {
        boolean z = false;
        if (this.plJ != null && this.plJ.poD != null && this.plJ.poD.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.pqT > 0 && this.pqb != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pqb.getLayoutParams();
                if (layoutParams.height != this.pqT) {
                    layoutParams.height = this.pqT;
                    this.pqb.setLayoutParams(layoutParams);
                }
            }
            this.poP = ((int) (tv.chushou.zues.utils.a.hB(this.psl).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.psl, 84.0f);
            b(this.poP, 12);
        } else {
            if (this.pqb != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pqb.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.psl, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.psl, 250.0f);
                    this.pqb.setLayoutParams(layoutParams2);
                }
            }
            this.poP = ((int) (tv.chushou.zues.utils.a.hB(this.psl).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.psl, 84.0f);
            b(this.poP, 12);
        }
        if (this.plK != null) {
            this.plK.a(this.pqT + tv.chushou.zues.utils.a.dip2px(this.psl, 52.0f), this.aq);
        }
        if (this.plO != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.plO.getLayoutParams();
            layoutParams3.bottomMargin = this.pqT + tv.chushou.zues.utils.a.dip2px(this.psl, 52.0f);
            this.plO.setLayoutParams(layoutParams3);
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
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.prX.getLayoutParams();
        this.pqI = tv.chushou.zues.utils.a.hC(this.psl);
        this.pqH = 86;
        this.dB = (Math.max(this.pqI.x, this.pqI.y) - tv.chushou.zues.utils.a.dip2px(this.psl, (this.pqH + 52) + 250)) - this.ppV;
        this.pqG = Math.max(this.pqI.x, this.pqI.y) - ((tv.chushou.zues.utils.a.dip2px(this.psl, this.pqH) + this.ppV) * 2);
        if (this.pqJ <= 0 || this.pqK <= 0) {
            this.pqJ = Math.min(this.pqI.x, this.pqI.y);
            this.pqK = Math.max(this.pqI.x, this.pqI.y);
        }
        this.ar = Math.min(this.pqI.x, this.pqI.y);
        this.aq = (this.ar * this.pqK) / this.pqJ;
        boolean z = false;
        if (this.plJ == null || this.plJ.poD == null) {
            i = 1;
        } else {
            i = this.plJ.poD.mMode;
            if (this.plJ.poD.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.pqH = 42;
            if (i == 2) {
                if (this.pqK < this.pqJ) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.pqJ * layoutParams.height) / this.pqK;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.psl, this.pqH) + this.ppV;
            layoutParams.gravity = 48;
            this.pqT = ((this.pqI.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.psl, (this.pqH + 52) + 64) + this.ppV)) - tv.chushou.zues.utils.systemBar.b.aH(getActivity());
            aG();
        } else if (this.E) {
            this.pqH = 42;
            if (this.pqK < this.pqJ) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.pqJ * layoutParams.height) / this.pqK;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.psl, this.pqH) + this.ppV;
            layoutParams.gravity = 48;
            this.pqT = ((this.pqI.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.psl, (this.pqH + 52) + 98) + this.ppV)) - tv.chushou.zues.utils.systemBar.b.aH(getActivity());
            evl();
        } else {
            this.pqT = -1;
            this.pqH = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.psl, this.pqH) + this.ppV;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.pqG) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.psl, this.pqH) + this.ppV;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.pqI.x, this.pqI.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.pqJ) / this.pqK >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.pqJ) / this.pqK;
                    } else if ((this.ar * this.pqK) / this.pqJ >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.pqK) / this.pqJ;
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
                    if ((this.ar * this.pqK) / this.pqJ > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.pqJ) / this.pqK;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.pqK) / this.pqJ;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.pqK) / this.pqJ;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.pqJ) / this.pqK;
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
        if (this.psk != null && this.psk.d) {
            layoutParams.width = Math.min(this.pqI.x, this.pqI.y);
            layoutParams.height = Math.max(this.pqI.x, this.pqI.y);
        }
        evH().setLayoutParams(layoutParams);
        this.prX.setLayoutParams(layoutParams2);
        this.prX.requestLayout();
    }

    private void aY() {
        this.prX = new SurfaceRenderView(this.psl);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.prX;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        evH().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.pqB) {
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
        if (this.prw != null) {
            this.prw.a();
        }
        if (this.psk != null && !h.isEmpty(this.psk.w)) {
            b(this.psk.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.poC != null) {
            int width = this.poC.getWidth();
            int height = this.poC.getHeight();
            if (this.pqJ != width || this.pqK != height || this.pqJ <= 0 || this.pqK <= 0) {
                this.pqJ = width;
                this.pqK = height;
                if (this.prX != null) {
                    this.prX.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.pqw) {
                evn();
            } else {
                if (this.psl.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.psl, "点击送礼_num", "竖屏", new Object[0]);
                if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.psk.euJ().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.ppU) {
                f(this.pps.getText().toString());
            } else {
                a(this.pps.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.etY().c) {
                com.kascend.chushou.d.h.etY().b(false);
                this.ppo.cancel();
                this.ppo.reset();
                this.ppp.clearAnimation();
                this.ppq.setVisibility(8);
            }
            o(view, 0, this.prW.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.psl, 165.0f) / 2);
            n(view, x >= 0 ? x : 0, this.prW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.psk.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.psk.d) {
                edN();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.pqb != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.pqc != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.pqA = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.psl, (JSONObject) null, this.psk.euL().mRoomID, this.psk.euL().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.psl.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.psl, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.pqD != null) {
                    com.kascend.chushou.d.e.a(this.psl, this.pqD, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.pqW != null) {
                    this.pqW.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.psl, null) && this.psk != null && this.psk.plr != null) {
                    if (this.ppU) {
                        bo();
                    } else {
                        if (this.psk != null && this.psk.plr != null && this.psk.plr.count > 0) {
                            this.ppK.setVisibility(8);
                        } else {
                            this.ppK.setVisibility(0);
                        }
                        this.ppU = true;
                        this.ppR.setBackgroundResource(a.e.ic_trumpet_p);
                        this.ppS.setVisibility(0);
                        this.ppS.setSelected(true);
                        this.ppS.setTextColor(Color.parseColor("#ff5959"));
                        if (this.pps != null) {
                            this.pps.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.ppT <= 9) {
                    this.ppT++;
                    this.ppQ.setText(this.ppT + "");
                }
                euV();
            } else if (id == a.f.tv_cut_count) {
                if (this.ppT > 1) {
                    this.ppT--;
                    this.ppQ.setText(this.ppT + "");
                }
                euV();
            } else if (id == a.f.tv_buy_head) {
                evF();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.pqZ.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.pqZ.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.pra.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.ew(this.pqZ);
                    this.psQ.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.plM != null && !h.isEmpty(this.plM.eventUrl)) {
                    f("", this.plM.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.plM != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.plM != null) {
                    com.kascend.chushou.d.a.a(this.psl, (JSONObject) null, this.plM.roomId, this.plM.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.psk.a(false);
                    ((VideoPlayer) this.psl).l();
                } else {
                    ((VideoPlayer) this.psl).a(true, (Uri) null, false);
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
        if (this.ppJ != null) {
            int i = (tv.chushou.zues.utils.a.hB(this.psl).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ppJ.getLayoutParams();
            layoutParams.topMargin = i;
            this.ppJ.setLayoutParams(layoutParams);
            this.ppJ.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.f4233a = str2;
            h5Options.c = false;
            this.ppJ.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.SE(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.pqz <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.SE(a.i.str_too_fast);
            return false;
        } else {
            edZ();
            if (!com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a(((VideoPlayer) this.psl).euk().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.pqz = System.currentTimeMillis();
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                a(this.psk.euJ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.psk.h);
            }
            g(this.b);
            if (!z && this.pps != null) {
                this.pps.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            edZ();
            if (com.kascend.chushou.d.e.c(this.psl, null) && LoginManager.Instance().getUserInfo() != null && this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                a(this.psk.euJ().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.pps != null) {
                this.pps.setText((CharSequence) null);
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
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.psk.euJ().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.psk.euJ().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.psl).pjF;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.aal(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.psL != null && this.psL.isShowing()) {
            this.psL.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
        if (this.pti == null) {
            i(3);
        }
        this.pti.getContentView().setBackgroundResource(0);
        this.pti.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.pti.isShowing()) {
            this.pti.showAtLocation(view, 83, i, i2);
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.psk.euJ().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.pti.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.ptm)) {
            if (((VideoPlayer) this.psl).q) {
                this.ptl.Ev(a.e.ic_room_set_btn_white);
            } else {
                this.ptl.Ev(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.psl).q && this.ptm.size() == 2 && this.ptm.contains("4") && this.ptm.contains("2")) {
            this.ptl.Ev(a.e.ic_room_set_btn_system_white);
        } else if (this.ptm.size() > 1 || !((VideoPlayer) this.psl).q) {
            this.ptl.Ev(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.ptm.get(0))) {
            this.ptl.Ev(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.ptm.get(0))) {
            this.ptl.Ev(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.ptm.get(0))) {
            this.ptl.Ev(a.e.ic_room_set_btn_system_white);
        }
    }

    private void o(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
        if (this.psL == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.psL.getContentView().setBackgroundResource(0);
            this.psL.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.psL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.ppp.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.psL.isShowing()) {
            this.psL.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.psl, 16.0f) + i2);
            this.ppp.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.psk.euJ().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.psL.dismiss();
    }

    private void e(View view) {
        if (this.psF == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.etY().q()) {
            this.ppt.eHD();
        } else {
            this.ppt.eHE();
        }
        int height = this.prW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity());
        if (view != null) {
            this.psF.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.psF == null) {
            View inflate = LayoutInflater.from(this.psl).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.ppt = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.etY().q()) {
                this.ppt.eHD();
            } else {
                this.ppt.eHE();
            }
            this.ppt.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.etY().g(z);
                }
            });
            this.psz = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.psA = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.psz.setOnClickListener(this);
            if (com.kascend.chushou.c.f4079a) {
                this.psz.setVisibility(0);
            } else {
                this.psz.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.etY().f4087a) {
                this.psA.b();
            } else {
                this.psA.c();
            }
            if (this.psk != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.psk.f;
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
                                if (this.plJ == null || !this.plJ.poD.mInPKMode || h.isEmpty(this.plJ.b) || this.pqc == null || !this.plJ.b.equals(this.pqc.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.psl).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl euK = this.psk.euK();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.psl).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.psl, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.psl, 5.0f);
                                            }
                                            int identifier = this.psl.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.psl.getPackageName());
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
                                if (this.psl.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.psl).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl euK2 = this.psk.euK();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.psl).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.psl, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.psl, 5.0f);
                                        }
                                        int identifier2 = this.psl.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.psl.getPackageName());
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
                        c.this.psF.dismiss();
                    }
                }
            });
            this.psF = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 150.0f), -2);
            this.psF.setFocusable(true);
            this.psF.setOutsideTouchable(true);
            this.psF.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.psF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.psF = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
            if (this.ppI == null) {
                this.ppI = new f(getActivity());
            }
            this.ppI.a(this.psk.euJ().mRoominfo, this.ax);
            if (!this.ppI.isShowing()) {
                this.ppI.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.pqB) {
            return false;
        }
        if (this.pqA == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.pru = motionEvent.getX();
                    this.prv = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.pru;
                    if (Math.abs(f) > Math.abs(y - this.prv) && Math.abs(f) > q && f > 0.0f) {
                        evC();
                        return true;
                    }
                    this.pru = 0.0f;
                    this.prv = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.pra != null && this.pra.getVisibility() == 0 && a(motionEvent, this.pra)) {
                this.pra.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.ew(this.pqZ);
                return true;
            } else if (this.pqw && this.pra != null && this.pra.getVisibility() == 8 && f(this.psQ.b, motionEvent)) {
                evn();
                return true;
            } else if (this.ppJ != null && this.ppJ.b() && f(this.ppJ, motionEvent)) {
                this.ppJ.a();
                return true;
            } else if (this.ppz != null && this.ppz.b() && f(this.ppz, motionEvent)) {
                this.ppz.a();
                return true;
            } else if (a(motionEvent, this.ppr)) {
                return edZ();
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
            if (this.ptc != null && this.ptc.a(i, keyEvent)) {
                return true;
            }
            if ((this.ppJ != null && this.ppJ.onKeyDown(i, keyEvent)) || evf()) {
                return true;
            }
            if (this.pqA == 3) {
                this.pqA = 1;
                evC();
                return true;
            } else if (this.ppz != null && this.ppz.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.pps != null && this.ppn != null && this.ppr != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bG(this.pps);
                this.ppn.setVisibility(8);
                this.ppr.setVisibility(0);
            }
        } else if (this.ppn != null && this.ppr != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
            this.ppn.setVisibility(0);
            this.ppr.setVisibility(8);
        }
    }

    public boolean edZ() {
        boolean z;
        b(this.poP, 12);
        boolean z2 = false;
        if (this.pmK != null && this.pmK.getVisibility() == 0) {
            this.pmK.setVisibility(8);
            this.pmL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.psl);
            this.pmL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.ppr == null || this.ppr.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.ppU) {
                bo();
            }
            this.ppr.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ppn != null) {
                    c.this.ppn.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean evf() {
        if (edZ()) {
            return true;
        }
        if (this.psL != null && this.psL.isShowing()) {
            this.psL.dismiss();
            return true;
        } else if (this.pti != null && this.pti.isShowing()) {
            this.pti.dismiss();
            return true;
        } else if (this.psF == null || !this.psF.isShowing()) {
            return evn() || evg() || evm() || euU();
        } else {
            this.psF.dismiss();
            return true;
        }
    }

    public boolean euU() {
        if (this.psU == null || !this.psU.isShown()) {
            return false;
        }
        this.psU.d();
        return true;
    }

    public boolean evg() {
        if (this.pqy == null || !this.pqy.isShown()) {
            return false;
        }
        this.pqy.a();
        return true;
    }

    public boolean evm() {
        if (this.ppJ == null || !this.ppJ.b()) {
            return false;
        }
        this.ppJ.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.psl != null && !((Activity) this.psl).isFinishing() && pVar != null) {
            this.pqk = pVar.f4077a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.pqc != null && mVar.a(this.pqc.mCreatorUID, null)) {
            this.pqc.mIsSubscribed = mVar.c;
            eva();
        }
    }

    public boolean evn() {
        if (!this.pqw || this.psQ == null) {
            return false;
        }
        if (this.psQ != null) {
            this.psQ.e();
        }
        if (this.pqZ != null) {
            this.pqZ.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.pqF != null) {
                        this.pqF.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                        this.psk.euJ().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.psk.euJ().mMicStatus.onMic) {
                            if (this.ppg != null) {
                                this.ppg.setVisibility(8);
                            }
                            if (this.pqy != null && this.pqy.isShown()) {
                                this.pqy.a();
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
                        if (this.psk.euJ().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.pqc != null && !h.isEmpty(this.pqc.mCreatorUID)) {
                                g(arrayList2, this.pqc.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.psk.euJ().mMicStatus.onMic) {
                            if (this.psk.euJ().mMicStatus != null && !h.isEmpty(this.psk.euJ().mMicStatus.micRoomId) && !this.psk.euJ().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.psk.euJ().mMicStatus.micRoomId;
                            }
                            this.psk.euJ().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.psk.euJ().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.psk.euJ().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.psk.euJ().mMicStatus, str3, z4);
                            if (this.pqy != null && this.pqy.getVisibility() == 0) {
                                this.pqy.a(this.psk.euJ().mFanItems, this.psk.euJ().mMicStatus, str3, z4, this.psk.euJ().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.ppg != null) {
                                this.ppg.setVisibility(8);
                            }
                            if (this.pqy != null && this.pqy.isShown()) {
                                this.pqy.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.ppY != onlineVip.mCount || (this.ppe != null && this.ppe.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.ppY = onlineVip.mCount;
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
                            if (!z3 || System.currentTimeMillis() - this.pqQ <= 5000) {
                                z2 = false;
                            } else {
                                this.pqQ = System.currentTimeMillis();
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
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.pqR != null) {
                    if (this.pqc == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.pqc.mCreatorAvatar;
                        str2 = this.pqc.mCreatorGender;
                    }
                    this.pqR.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.plJ != null && this.plJ.poD != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.plJ.poD.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.plF != null) {
                                        this.plF.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.plJ.poD.mInPKMode = true;
                                    this.plJ.poD.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.plJ.poD.mPkUid = pkNotifyInfo.mPkUid;
                                    this.plJ.poD.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.plJ.poD.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.plJ.poD.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.plJ.poD.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.plJ.poD.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.plJ.poD.mMode = pkNotifyInfo.mMode;
                                    this.plJ.poD.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.plK != null) {
                                        this.plK.k(true, this.plJ.poD.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.etY().f4087a) {
                                        if (!com.kascend.chushou.b.etQ().e) {
                                            com.kascend.chushou.b.etQ().e = true;
                                            tv.chushou.zues.utils.g.O(this.psl, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.etY().a(this.psl, false);
                                        evj();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.plJ.poD.mAction = 7;
                                    this.plJ.poD.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.plJ.poD.mPkUid = pkNotifyInfo.mPkUid;
                                    this.plJ.poD.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.plJ.poD.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.plJ.poD.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.plJ.poD.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.plJ.poD.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.plK != null) {
                                        this.plK.k(false, 0L);
                                        this.plK.b(this.plJ.poD, true);
                                        this.plK.a(this.pqT + tv.chushou.zues.utils.a.dip2px(this.psl, 52.0f), this.aq);
                                        this.plK.a(this.plJ.poD.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.plF != null) {
                                        this.plF.a(false);
                                    }
                                    this.plJ.poD.mInPKMode = false;
                                    this.plJ.poD.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.plK != null) {
                                        this.plK.c();
                                    }
                                    this.plJ.b = null;
                                    this.plJ.poD = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.plJ.poD.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.plJ.poD.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.plJ.poD.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.pqc != null && !h.isEmpty(this.pqc.mRoomID) && this.pqc.mRoomID.equals(this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.plJ.poD.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.plK != null) {
                                        this.plK.a(this.plJ.poD, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.plJ.poD.copyUpdate(pkNotifyInfo);
                                    if (this.plK != null) {
                                        this.plK.a(this.plJ.poD);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.plJ.poD.copyStop(pkNotifyInfo);
                                        if (this.plK != null) {
                                            this.plK.M(this.plJ.poD.mMaxFreeDuration, this.plJ.poD.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.plJ.poD.copyResult(pkNotifyInfo);
                                    if (!this.pqu && this.plK != null) {
                                        int i7 = 1;
                                        if (this.plJ.poD.destinyInfo != null && this.plJ.poD.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.plK.a(h.parseInt(this.plJ.poD.mResult), h.parseLong(this.plJ.poD.mvpUid), this.plJ.poD.mvpAvatar, this.plJ.poD.mvpNickname, this.plJ.poD.mMaxFreeDuration, this.plJ.poD.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.plM != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.plM.uid = cycleLiveRoomInfo.uid;
                        this.plM.remainTime = cycleLiveRoomInfo.remainTime;
                        this.plM.roomId = cycleLiveRoomInfo.roomId;
                        this.plM.avatar = cycleLiveRoomInfo.avatar;
                        this.plM.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.psl != null && (this.psl instanceof VideoPlayer)) {
                            ((VideoPlayer) this.psl).d();
                        }
                    } else {
                        ((VideoPlayer) this.psl).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.psk != null && this.psk.l()) {
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
        if (this.ppe != null) {
            if (this.plJ == null || this.plJ.poD == null || !this.plJ.poD.mInPKMode) {
                if (this.bP > 0) {
                    this.ppe.setVisibility(0);
                    this.ppe.setText(String.format(this.psl.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.ppj.setVisibility(0);
                    return;
                }
                this.ppe.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.ppg.setVisibility(0);
            if (this.pph != null) {
                this.pph.a(str, z, micStatus, this.psk.euJ().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.ppg.setVisibility(8);
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
        int childCount = this.pqe.getChildCount();
        int itemCount = this.pqe.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.pqe);
        if (f + childCount >= itemCount) {
            this.pql = true;
            if (this.pqm != null) {
                this.pqm.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void evy() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.pqf.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.pqf.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.pqf == null) {
            this.pqf = new ArrayList<>();
        }
        while (2 < this.pqf.size()) {
            this.pqf.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.pqh);
        if (a2 == null) {
            w(false);
            return;
        }
        this.pqf.addAll(a2);
        int size = this.pqf.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.pqf.size(); i++) {
                this.pqf.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.pqi == null) {
            this.pqi = new ArrayList<>();
        }
        this.pqi.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.pqk != null && this.pqk.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.pqk.contains("2"))) {
                        this.pqi.add(next);
                    } else if (!this.pqk.contains(next.mType)) {
                        this.pqi.add(next);
                    }
                }
                return this.pqi;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.pqf == null) {
                    this.pqf = new ArrayList<>(arrayList);
                    evy();
                    w(z2);
                    return;
                }
                if (this.pqh == null) {
                    this.pqh = new ArrayList<>();
                }
                this.pqh.addAll(arrayList);
                int size = this.pqh.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.pqh.size(); i++) {
                        this.pqh.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.pqf.size();
                if (a2 != null) {
                    this.pqf.addAll(a2);
                }
                int size3 = this.pqf.size();
                if (!this.pql && this.pqm != null) {
                    this.pqm.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.pqf.size(); i3++) {
                        this.pqf.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.pqf == null) {
                this.pqf = new ArrayList<>(arrayList);
                evy();
            } else {
                if (this.pqh == null) {
                    this.pqh = new ArrayList<>();
                }
                this.pqh.clear();
                this.pqh.addAll(arrayList);
                this.pqf.clear();
                evy();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.pqf.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.pqj != null) {
                this.pqj.a(this.pqf.size());
                if (i == 1) {
                    this.pqj.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.pqj.notifyItemRangeRemoved(i2, i3);
                    this.pqj.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.pqj.notifyDataSetChanged();
                }
            }
            if (z || this.pql) {
                this.pql = true;
                if (this.pqm != null) {
                    this.pqm.setVisibility(8);
                }
                if (z) {
                    this.pqb.scrollToPosition(this.pqf.size() - 1);
                } else {
                    this.pqb.smoothScrollToPosition(this.pqf.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.pqj != null) {
                this.pqj.a(this.pqf.size());
                this.pqj.notifyDataSetChanged();
            }
            if (z || this.pql) {
                this.pql = true;
                if (this.pqm != null) {
                    this.pqm.setVisibility(8);
                }
                if (z) {
                    this.pqb.scrollToPosition(this.pqf.size() - 1);
                } else {
                    this.pqb.smoothScrollToPosition(this.pqf.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a euv;
        RoomToast roomToast;
        this.p = false;
        if (this.psk != null && this.psk.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.psk.f.size()) {
                    break;
                } else if (!"2".equals(this.psk.f.get(i).mType)) {
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
        if (this.plZ != null) {
            this.plZ.setVisibility(0);
        }
        if (this.poU != null) {
            this.poU.setVisibility(0);
        }
        if (this.psk != null) {
            this.pqc = this.psk.euL();
            this.pqd = this.psk.euJ();
            if (com.kascend.chushou.b.etQ().c != null && this.pqj != null) {
                this.pqj.a(com.kascend.chushou.b.etQ().c);
                this.pqj.notifyDataSetChanged();
            }
            FullRoomInfo euJ = this.psk.euJ();
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
            if (this.pqc != null) {
                bk();
            }
            if (this.pqc != null && !this.pqc.mIsSubscribed) {
                RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.pqc == null || !c.this.pqc.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.psk != null && this.psk.l()) {
                d(true);
            }
        }
        if (this.pqc != null && this.pqj != null) {
            if (this.pqf != null) {
                this.pqf.clear();
            } else {
                this.pqf = new ArrayList<>();
            }
            this.pqj.a(this.pqc);
            evy();
            this.pqj.a(this.pqf.size());
            this.pqj.notifyDataSetChanged();
        }
        euY();
        N();
        if (this.psl != null && (this.psl instanceof VideoPlayer) && (euv = ((VideoPlayer) this.psl).euv()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(euv.poD, euv.b);
        }
        this.ppw.h(this.pqc.mCreatorAvatar, com.kascend.chushou.view.a.a(this.pqc.mCreatorGender), 0, 0);
        if (this.prX != null) {
            this.prX.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.ppA);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void evq() {
        if (this.ppX == null) {
            View inflate = LayoutInflater.from(this.psl).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.pnn = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.ppX = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.psl, 160.0f), -2);
            this.ppX.setFocusable(false);
            this.ppX.setOutsideTouchable(false);
            this.ppX.setAnimationStyle(a.j.gift_toast_style);
            this.ppX.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.etY().c(roomToast.mToastContent);
            if (this.ppX == null) {
                evq();
            }
            if (this.pnn != null) {
                this.pnn.setText(roomToast.mToastContent);
            }
            if (!this.ppX.isShowing()) {
                if (this.ppA != null) {
                    this.ppX.showAtLocation(this.ppA, 85, 0, this.prW.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aH(getActivity()));
                    RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.ppX != null) {
                                c.this.ppX.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.ppX.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.pqM != null) {
            this.pqM.setVisibility(z ? 0 : 8);
        }
        this.pqN = true;
        if (this.psl instanceof VideoPlayer) {
            ((VideoPlayer) this.psl).p();
        }
    }

    private void evB() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.psl).s();
        euU();
        evg();
        if (this.ppl == null) {
            this.ppl = (PlayShowRecommendView) ((ViewStub) this.prW.findViewById(a.f.view_recommend)).inflate();
        }
        this.ppl.setVisibility(0);
        if (this.psk.euJ() != null && this.psk.euJ().mRoominfo != null && !h.isEmpty(this.psk.euJ().mRoominfo.mRoomID)) {
            evt();
        }
        if (this.prX != null) {
            this.prX.setVisibility(8);
        }
        if (this.psQ != null) {
            this.psQ.e();
        }
        if (this.plZ != null) {
            this.plZ.setVisibility(4);
        }
        if (this.poU != null) {
            this.poU.setVisibility(8);
        }
        if (this.psY != null) {
            this.psY.eHb();
            this.psY.setVisibility(8);
        }
        AN(false);
        a(false, false);
        if (this.plF != null) {
            this.plF.a();
        }
    }

    private void evt() {
        if (this.ppl != null && this.ppl.getVisibility() == 0) {
            this.ppl.a(this.psk.euJ().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.psl instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.psl;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.ppJ != null && this.ppJ.b()) {
            this.ppJ.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.pqx);
        if (this.psl != null) {
            if (this.pqx || "10004".equals(((VideoPlayer) this.psl).t)) {
                this.pqx = true;
                if (this.psk != null) {
                    this.psk.f = null;
                    if (this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                        this.psk.euJ().mRoominfo.mGameId = null;
                    }
                }
                evB();
                return;
            }
            this.pqx = true;
            if (this.psl != null) {
                ((VideoPlayer) this.psl).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.pqx = false;
        if (this.plZ != null) {
            this.plZ.setVisibility(0);
        }
        if (this.poU != null) {
            this.poU.setVisibility(0);
        }
        if (this.ppl != null) {
            this.ppl.setVisibility(8);
        }
        if (this.psf != null) {
            this.psf.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.pqx = false;
        if (this.plZ != null) {
            this.plZ.setVisibility(0);
        }
        if (this.poU != null) {
            this.poU.setVisibility(0);
        }
        if (this.ppl != null) {
            this.ppl.setVisibility(8);
        }
        if (this.psf != null) {
            this.psf.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.ppl != null) {
            this.ppl.setVisibility(8);
        }
        if (this.prX != null) {
            this.prX.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.psk != null) {
                        this.psk.f = null;
                        this.psk.euJ().mRoominfo.mGameId = null;
                    }
                    evB();
                    return;
                }
                tv.chushou.zues.utils.g.SE(a.i.str_getvideosource_failed);
            }
            AN(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.psk != null && this.psk.euK() != null) {
            a(this.psk.euK());
        }
        this.p = false;
        if (this.psk == null || this.psk.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.psk.f.size()) {
                if (!"2".equals(this.psk.f.get(i2).mType)) {
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
        if (this.prW == null) {
            return null;
        }
        return (GiftAnimationLayout) this.prW.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.ppA != null) {
            int size = iconConfig.configs.size();
            this.ppA.removeAllViews();
            if (this.ppC != null) {
                this.ppC.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.psl).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.ppA, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.cd(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.cd(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.cd(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.ppC.setVisibility(0);
                            this.ppB.cd(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.cd(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.cd(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.cd(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void em(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.ppA.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void D() {
        if (this.psl instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a euq = ((VideoPlayer) this.psl).euq();
            if (this.ptc == null) {
                this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.ptc.setVisibility(0);
            this.ptc.a(2, euq);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.ppE != null && this.psl != null) {
            this.ppE.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.ppE != null && this.psl != null) {
            this.ppE.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(long j) {
        if (this.ppE != null) {
            this.ppE.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC1004a
    public void c(int i) {
        if (this.ppE != null) {
            this.ppE.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void a(int i) {
        if (this.ppD != null) {
            if (this.psl != null) {
                this.ppD.a(((VideoPlayer) this.psl).euq(), false);
            }
            this.ppD.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.prW != null) {
            Point hB = tv.chushou.zues.utils.a.hB(this.psl);
            int i = hB.x > hB.y ? 1 : 2;
            if (this.ptc == null) {
                this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.ptc.setPlayerViewHelper(this.psk);
            this.ptc.setVisibility(0);
            this.ptc.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.ppF != null) {
            this.ppF.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.ppF != null) {
            this.ppF.a(bangInfo, str);
        }
        if (this.pmn != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.pmn.setText(this.psl.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.pmn.setText(this.psl.getString(a.i.str_contribute_tittle));
            } else {
                this.pmn.setText(Html.fromHtml(this.psl.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.ppf != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.ppf.setText(this.psl.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.ppf.setText(this.psl.getString(a.i.str_contribute_tittle));
            } else {
                this.ppf.setText(Html.fromHtml(this.psl.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.ppF != null) {
            this.ppF.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.psk != null && !h.isEmpty(this.psk.plq)) {
            this.pqD = this.psk.plq.get(0);
            if (this.pqU != null) {
                this.pqU.setVisibility(0);
                this.pqU.a(this.pqD.mCover, 0, 0, 0, 1);
                if (this.pqV != null) {
                    if (this.pqD.mShowClose) {
                        this.pqV.setVisibility(0);
                    } else {
                        this.pqV.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.ppF != null) {
            this.ppF.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.prW != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.pmK != null) {
            this.pmK.setPanelEnabled(gVar.f4071a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.pqu) {
            if (iVar.f4073a == 52) {
                if (this.pqj != null) {
                    this.pqj.a(com.kascend.chushou.b.etQ().c);
                    this.pqj.notifyDataSetChanged();
                }
            } else if (iVar.f4073a == 50) {
                if (!this.pqu && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.pps != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.pps);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.pqu) {
            if (bVar.f4152a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.psl, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                com.kascend.chushou.player.ui.h5.b.b eur = ((VideoPlayer) this.psl).eur();
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(2, eur);
            } else if (bVar.f4152a == 3) {
                com.kascend.chushou.player.ui.h5.d.a eus = ((VideoPlayer) this.psl).eus();
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(2, eus);
            } else if (bVar.f4152a == 8) {
                if (this.pqF != null && this.pqF.getVisibility() != 0) {
                    this.pqF.a(a.C0991a.slide_in_bottom_danmu_anim, a.C0991a.slide_out_bottom_danmu_anim, this.pqc == null ? "" : this.pqc.mRoomID);
                }
            } else if (bVar.f4152a == 9) {
                if (this.ptc == null) {
                    this.ptc = (H5Container) ((ViewStub) this.prW.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.ptc.setVisibility(0);
                this.ptc.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.psk != null && !h.isEmpty(this.psk.f4119a) && this.psk.f4119a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.pqF != null && this.pqF.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.psl, 80.0f);
                }
                if (this.pqE != null && this.pqE.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pqE.getHeight());
                }
                this.pqP.setTranslationY(-r0);
                return;
            }
            if (this.pqO != null) {
                this.pqO.cancel();
                this.pqO = null;
            }
            int translationY = (int) this.pqP.getTranslationY();
            if (aVar.f4151a != 1 && 2 != aVar.f4151a) {
                if (3 == aVar.f4151a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.psl, 80.0f) : 0;
                    if (this.pqE != null && this.pqE.getVisibility() == 0) {
                        r0 = Math.max(r0, this.pqE.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.pqE.getHeight() : 0;
                    if (this.pqF != null && this.pqF.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.psl, 80.0f));
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
        this.pqO = ValueAnimator.ofInt(i, i2);
        this.pqO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.ppF != null) {
                    c.this.pqP.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.pqO.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.pqO = null;
            }
        });
        this.pqO.setInterpolator(new LinearInterpolator());
        this.pqO.setDuration(800L);
        this.pqO.start();
    }

    private boolean bg() {
        if (this.pqA == 1) {
            this.pqA = 2;
            x(true);
            return true;
        } else if (this.pqA == 3) {
            evC();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.pqA == 1) {
            return bi();
        }
        if (this.pqA == 2) {
            this.pqA = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.pqB || this.psk == null || this.psk.euL() == null) {
            return false;
        }
        if (this.prw != null) {
            this.prw.a(true);
        }
        this.pqA = 3;
        this.pqB = true;
        bk();
        this.poR.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.pqB = false;
                c.this.poT.setVisibility(8);
            }
        });
        this.poT.startAnimation(loadAnimation);
        this.poR.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evC() {
        if (!this.pqB) {
            if (this.prw != null) {
                this.prw.a(false);
            }
            this.pqA = 1;
            this.pqB = true;
            bk();
            this.poT.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.pqB = false;
                    c.this.poR.setVisibility(8);
                }
            });
            this.poT.startAnimation(loadAnimation);
            this.poR.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.prW != null) {
            if (this.poR == null) {
                this.poR = this.prW.findViewById(a.f.user_space_container);
            }
            if (this.poT == null) {
                this.poT = this.prW.findViewById(a.f.video_container);
            }
            if (this.poS == null) {
                this.poS = com.kascend.chushou.view.user.b.c(null, this.psk.f4119a, false, this.psk.h);
                this.poS.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
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
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.poS).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.poU != null) {
            this.poU.setVisibility(z ? 8 : 0);
        }
        if (this.ppZ != null) {
            this.pqB = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.ppZ.setVisibility(8);
                        c.this.pqB = false;
                    }
                });
            } else {
                this.pqB = true;
                loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.ppZ.setVisibility(0);
                        c.this.pqB = false;
                    }
                });
            }
            this.ppZ.startAnimation(loadAnimation);
        }
        evf();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.ppm.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.ppu != null) {
                this.ppu.setVisibility(0);
            }
            if (this.ppv != null) {
                this.ppv.a();
                return;
            }
            return;
        }
        if (this.ppx != null) {
            this.ppx.setVisibility(0);
        }
        if (this.ppy != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.ppy.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.ppx != null) {
            this.ppx.setVisibility(8);
        }
        if (this.ppy != null) {
            this.ppy.clearAnimation();
        }
        if (this.ppu != null) {
            this.ppu.setVisibility(8);
        }
        if (this.ppv != null) {
            this.ppv.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.ppZ != null && this.prW != null) {
            if (this.pqF == null) {
                this.pqF = new com.kascend.chushou.player.ui.miniview.a(this.psl, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.pqF != null && c.this.prW != null && c.this.pqF.a()) {
                            ((ViewGroup) c.this.prW).removeView(c.this.pqF);
                            c.this.pqF = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pqF.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.psl, 52.0f);
                this.pqF.setLayoutParams(layoutParams);
                ((ViewGroup) this.ppZ).addView(this.pqF, ((ViewGroup) this.ppZ).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.pqF.setVisibility(8);
                } else {
                    this.pqF.a(a.C0991a.slide_in_bottom_danmu_anim, a.C0991a.slide_out_bottom_danmu_anim, this.psk.f4119a == null ? "" : this.psk.f4119a);
                }
            } else if (!this.pqF.isShown()) {
                this.pqF.a(a.C0991a.slide_in_bottom_danmu_anim, a.C0991a.slide_out_bottom_danmu_anim, this.psk.f4119a == null ? "" : this.psk.f4119a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.pqL != null && !h.isEmpty(listItem.mPackIcon)) {
                this.pqL.setVisibility(0);
                this.pqL.setAnim(true);
                this.pqL.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.qpX, b.C1127b.qpZ, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.pqn != null && this.pqn.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.evD();
                    }
                });
                this.pqn.setVisibility(0);
                this.pqn.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.pqn != null && this.pqn.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.pqp != null) {
                        c.this.pqp.removeAllListeners();
                        c.this.pqp.cancel();
                        c.this.pqp = null;
                    }
                    if (c.this.pqn != null) {
                        c.this.pqn.setVisibility(8);
                    }
                }
            });
            this.pqn.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.pqS == null) {
                this.pqS = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.psl, "显示双击666_num", null, new Object[0]);
                            if (c.this.psk != null) {
                                c.this.psk.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.psm != null) {
                    this.psm.f(this.pqS, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.pqS != null) {
            this.psm.N(this.pqS);
            this.pqS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.pqq != null && this.pqq.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.psl, a.C0991a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.evE();
                    }
                });
                this.pqq.setVisibility(0);
                this.pqq.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.prV, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.pqq != null && this.pqq.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.psl, a.C0991a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.pqs != null) {
                        c.this.pqs.removeAllListeners();
                        c.this.pqs.cancel();
                        c.this.pqs = null;
                    }
                    if (c.this.pqq != null) {
                        c.this.pqq.setVisibility(8);
                    }
                }
            });
            this.pqq.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evD() {
        if (this.pqn == null || this.pqo == null) {
            return null;
        }
        if (this.pqp != null) {
            this.pqp.removeAllListeners();
            this.pqp.cancel();
            this.pqp = null;
        }
        this.pqo.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.pqo, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.pqo, 0.0f);
        int measuredWidth = (this.pqn.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.psl, 13.0f) * 2)) - this.pqo.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.pqo, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.pqo, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.pqo, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.pqp != null) {
                    c.this.pqp.removeAllListeners();
                    c.this.pqp.cancel();
                    c.this.pqp = null;
                }
                RxExecutor.postDelayed(c.this.prV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.evD();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pqp = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evE() {
        if (this.pqq == null || this.pqr == null) {
            return null;
        }
        if (this.pqs != null) {
            this.pqs.removeAllListeners();
            this.pqs.cancel();
            this.pqs = null;
        }
        this.pqr.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.pqr, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.pqr, 0.0f);
        int measuredWidth = (this.pqq.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.psl, 13.0f) * 2)) - this.pqr.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.pqr, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.pqr, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.pqr, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.pqs != null) {
                    c.this.pqs.removeAllListeners();
                    c.this.pqs.cancel();
                    c.this.pqs = null;
                }
                RxExecutor.postDelayed(c.this.prV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.evE();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pqs = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.prw = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.plM != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.plM.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eC = com.kascend.chushou.c.a.eC(jSONObject);
                        if (eC.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.SE(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.SE(a.i.subscribe_success);
                            }
                            if (c.this.plM != null) {
                                c.this.plM.isSubscribe = !z;
                                c.this.euZ();
                                return;
                            }
                            return;
                        }
                        a(eC.mRc, eC.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.B(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.etT().a(bVar, (String) null, this.plM.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.plM.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.etT().b(bVar, (String) null, c.this.plM.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.psk != null && this.pqc != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.psk.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.psk.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.pqc.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eC = com.kascend.chushou.c.a.eC(jSONObject);
                        if (eC.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.SE(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.SE(a.i.subscribe_success);
                            }
                            c.this.pqc.mIsSubscribed = !z;
                            c.this.eva();
                            return;
                        }
                        a(eC.mRc, eC.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.B(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.etT().a(bVar, (String) null, this.pqc.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.pqc.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.etT().b(bVar, (String) null, c.this.pqc.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.poC != null) {
            int width = this.poC.getWidth();
            int height = this.poC.getHeight();
            if (this.pqJ != width || this.pqK != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void evj() {
        ((VideoPlayer) this.psl).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.prW != null) {
            if (this.ppz == null) {
                this.ppz = (InteractionView) ((ViewStub) this.prW.findViewById(a.f.view_interaction)).inflate();
                this.ppz.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.ppz.a();
                    }
                });
            }
            if (this.ppz != null) {
                this.ppz.b(configDetail);
                this.ppz.c();
                this.ppz.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eHN()) {
                tv.chushou.zues.utils.g.O(this.psl, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.psl, null) && (this.psl instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.psk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.psl, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.psl, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.psk != null) {
                com.kascend.chushou.toolkit.a.c.a(this.psl, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.psl, configDetail.mUrl, this.psl.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.psl, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.pqw) {
                        evn();
                        return;
                    }
                    if (this.psl.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.psl, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.psk != null && this.psk.euJ() != null && this.psk.euJ().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.psk.euJ().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.ppA);
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
        if (this.psl != null && !this.v && !h.isEmpty(str) && this.pqc != null && str.equals(this.pqc.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.plJ == null) {
                this.plJ = new com.kascend.chushou.player.e.a();
            }
            this.plJ.b = str;
            this.plJ.poD.copy(pkNotifyInfo);
            if (this.plJ.poD.mAction == 6) {
                if (this.plF != null) {
                    this.plF.a(true);
                }
                this.plJ.poD.mInPKMode = true;
                this.u = this.plJ.poD.mPkId;
            } else if (this.plJ.poD.mAction == 7 || (this.plJ.poD.mMode == 1 && this.plJ.poD.mAction == 5)) {
                if (this.plF != null) {
                    this.plF.a(true);
                }
                this.plJ.poD.mInPKMode = true;
                if (this.pqH != 42) {
                    this.pqT = ((this.pqI.y - ((this.pqI.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.psl, 158.0f) + this.ppV)) - tv.chushou.zues.utils.systemBar.b.aH(getActivity());
                    aX();
                }
                this.u = this.plJ.poD.mPkId;
                if (this.plK != null) {
                    this.plK.b(this.plJ.poD, false);
                    this.plK.a(this.plJ.poD.mMode, (String) null);
                    if (this.plJ.poD.mAction == 5 && this.plJ.poD.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.plJ.poD.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.plJ.poD.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.plJ.poD.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.plJ.poD.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.plJ.poD.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.plK.a(this.plJ.poD);
                        this.plK.a(parseInt, this.plJ.poD.mPkUpdateInfo.remainDuration, j, this.plJ.poD.mMode, (this.plJ.poD.destinyInfo == null || this.plJ.poD.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.plJ.poD.mPkUpdateInfo != null && !h.isEmpty(this.plJ.poD.mPkUpdateInfo.specialMomentList) && this.plK != null) {
                    this.plK.a(this.plJ.poD, true);
                }
                if (this.plJ.poD.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.plJ.poD.mInPKMode = false;
                if (this.plJ.poD.mMode == 2) {
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
        if (this.ppS != null && this.psk != null && this.psk.plr != null) {
            this.ppS.setText(tv.chushou.zues.utils.b.SD(this.psk.plr.count));
            this.ppS.setVisibility(0);
            if (this.psk.plr.count < 1) {
                bo();
            }
            if (this.ppL != null) {
                this.ppL.setText(this.psk.plr.primaryName);
            }
            if (this.ppM != null) {
                this.ppM.setText(this.psk.plr.desc);
            }
            euV();
        }
    }

    public void euV() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.ppT * h.parseLong(this.psk.plr.point)));
        if (this.pnc != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.psl.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.R(this.psl, a.e.icon_coin_new);
            cVar.append(this.psl.getString(a.i.str_buy_count_coin2));
            this.pnc.setText(cVar);
        }
    }

    private void evF() {
        if (com.kascend.chushou.d.e.c(this.psl, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.ppT);
        }
    }

    private void bo() {
        this.ppU = false;
        this.ppR.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.psk != null && this.psk.plr != null) {
            if (this.psk.plr.count < 1) {
                this.ppS.setVisibility(8);
            } else {
                this.ppS.setVisibility(0);
                this.ppS.setSelected(false);
                this.ppS.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.ppK.setVisibility(8);
        if (this.pps != null) {
            this.pps.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.plO != null) {
            if (z) {
                this.plO.setVisibility(0);
            } else {
                this.plO.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.prt != null) {
            this.prt.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.ppB != null) {
            this.ppB.performClick();
        }
    }
}
