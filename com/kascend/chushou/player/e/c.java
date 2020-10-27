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
    private View paZ;
    private TextView pbC;
    private KPSwitchPanelLinearLayout pbK;
    private ImageView pbL;
    private tv.chushou.zues.widget.kpswitch.b.c pbM;
    private d.a pbN;
    public String pbg;
    private TextView pbk;
    private TextView pbn;
    private ImageView pbt;
    private TextView pcc;
    private TextView pcn;
    private View pcq;
    private int pdM;
    private View pdN;
    private View pdO;
    private com.kascend.chushou.view.user.b pdP;
    private View pdQ;
    private FrameLayout pdR;
    private LinearLayout pdS;
    private RelativeLayout pdT;
    private FrescoThumbnailView pdU;
    private TextView pdV;
    private TextView pdW;
    private TextView pdX;
    private FrescoThumbnailView pdY;
    private TextView pdZ;
    private TextView pdn;
    private InteractNotifier peA;
    private EmbeddedButtonLayout peB;
    private GiftAnimationLayout peC;
    private com.kascend.chushou.player.b.a peD;
    private f peE;
    private PlayShowH5View peF;
    private LinearLayout peG;
    private TextView peH;
    private TextView peI;
    private TextView peJ;
    private TextView peK;
    private TextView peL;
    private TextView peM;
    private ImageView peN;
    private TextView peO;
    private PopupWindow peT;
    private View peV;
    private RecyclerView peX;
    private RoomInfo peY;
    private TextView pea;
    private TextView peb;
    private TextView pec;
    private LinearLayout ped;
    private PlayShowMicStatusView pee;
    private RecyclerView pef;
    private ImageView peg;
    private PlayShowRecommendView peh;
    private View pei;
    private RelativeLayout pej;
    private AnimationSet pek;
    private ImageView pel;
    private ImageView pem;
    private RelativeLayout pen;
    private PastedEditText peo;
    private ToggleButton pep;
    private RelativeLayout peq;
    private PaoPaoView per;
    private FrescoThumbnailView pes;
    private LinearLayout pet;
    private ImageView peu;
    private InteractionView pev;
    private LinearLayout pew;
    private FrescoThumbnailView pex;
    private FrameLayout pey;
    private RedpacketNotifier pez;
    private FoodView pfA;
    private com.kascend.chushou.player.ui.miniview.a pfB;
    private int pfC;
    private int pfD;
    private Point pfE;
    private FrescoThumbnailView pfH;
    private FrescoThumbnailView pfI;
    private ValueAnimator pfK;
    private LinearLayout pfL;
    private long pfM;
    private VideoShowVoteView pfN;
    private Runnable pfO;
    private FrescoThumbnailView pfQ;
    private ImageView pfR;
    private RelativeLayout pfS;
    private TextView pfT;
    private ImageView pfU;
    private EditText pfV;
    private View pfW;
    private RelativeLayout pfX;
    private RelativeLayout pfY;
    private FrescoThumbnailView pfZ;
    private RecyclerView.LayoutManager pfa;
    private ArrayList<ChatInfo> pfb;
    private ArrayList<ChatInfo> pfc;
    private ArrayList<ChatInfo> pfd;
    private ArrayList<ChatInfo> pfe;
    private Button pfi;
    private View pfj;
    private View pfk;
    private Animator pfl;
    private View pfm;
    private View pfn;
    private Animator pfo;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> pfr;
    private PlayShowMicPerson pfu;
    private FoodView pfy;
    public ListItem pfz;
    private TextView pga;
    private TextView pgb;
    private ImageView pgc;
    private RelativeLayout pgd;
    private LinearLayout pge;
    private TextView pgf;
    private TextView pgg;
    private RelativeLayout pgh;
    private RelativeLayout pgi;
    private FrescoThumbnailView pgj;
    private TextView pgk;
    private TextView pgl;
    private ImageView pgm;
    private RelativeLayout pgn;
    private TextView pgp;
    private float pgq;
    private float pgr;
    private a pgs;
    private boolean cp = false;
    private int peP = 1;
    private boolean peQ = false;
    private int peR = 0;
    private int peS = 0;
    private int peU = -1;
    private boolean peW = false;
    private FullRoomInfo peZ = null;
    private com.kascend.chushou.player.adapter.a pff = null;
    private ArrayList<String> pfg = null;
    private boolean pfh = true;
    private boolean pfp = true;
    private boolean pfq = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean pfs = false;
    private boolean pft = false;
    private long pfv = 0;
    private int pfw = 1;
    private boolean pfx = false;
    private int pfF = -1;
    private int pfG = -1;
    private boolean pfJ = false;
    private int pfP = -1;
    private io.reactivex.disposables.b pgo = null;

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
        this.pbg = getArguments().getString("cover");
        this.pfp = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.pgS = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.pgS;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            eri();
            this.pdz = ((VideoPlayer) this.phh).eqs();
            this.phg = ((VideoPlayer) this.phh).eqv();
            d(view);
            ers();
            if (this.phh instanceof VideoPlayer) {
                ((VideoPlayer) this.phh).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.pfq = false;
        if (this.phM != null) {
            this.phM.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.pfq = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.pfl != null) {
            this.pfl.removeAllListeners();
            this.pfl.cancel();
            this.pfl = null;
        }
        if (this.pfo != null) {
            this.pfo.removeAllListeners();
            this.pfo.cancel();
            this.pfo = null;
        }
        if (this.peA != null) {
            this.peA.c();
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
        if (this.pgo != null) {
            this.pgo.dispose();
            this.pgo = null;
        }
        this.peP = 1;
        this.peQ = false;
        if (this.phi != null) {
            this.phi.cs(null);
        }
        if (this.peT != null) {
            this.peT.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.phh, this.pbM);
        if (this.phh != null && (this.phh instanceof VideoPlayer)) {
            ((VideoPlayer) this.phh).eqz();
        }
        this.pbN = null;
        this.pbM = null;
        aI();
        if (this.peD != null) {
            this.peD.a();
        }
        if (this.per != null) {
            this.per.b();
            this.per.c();
            this.per = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.ct(this);
        if (this.pfd != null) {
            this.pfd.clear();
        }
        if (this.pfb != null) {
            this.pfb.clear();
        }
        if (this.pfe != null) {
            this.pfe.clear();
        }
        if (this.pfc != null) {
            this.pfc.clear();
        }
        if (this.pfg != null) {
            this.pfg.clear();
        }
        if (this.pff != null) {
            this.pff.a(0);
            this.pff.a();
        }
    }

    private void d(View view) {
        this.pdN = view.findViewById(a.f.fl_root);
        this.pfE = tv.chushou.zues.utils.a.hE(this.phh);
        this.peR = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.phh);
        this.peS = tv.chushou.zues.utils.systemBar.b.aG(getActivity());
        this.pfD = 86;
        this.phg = ((VideoPlayer) this.phh).eqv();
        if (this.phg != null) {
            this.peY = this.phg.eqW();
            this.peZ = this.phg.eqU();
        }
        this.pfb = new ArrayList<>();
        this.pfd = new ArrayList<>();
        this.pfc = new ArrayList<>();
        this.pdR = (FrameLayout) this.pgS.findViewById(a.f.fl_effect);
        b();
        this.phb = (PlayerErrorView) this.pgS.findViewById(a.f.view_net_error_msg);
        this.phb.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.peq = (RelativeLayout) this.pgS.findViewById(a.f.rl_audio_ani);
        this.per = (PaoPaoView) this.pgS.findViewById(a.f.audio_ani);
        this.pes = (FrescoThumbnailView) this.pgS.findViewById(a.f.audio_ani_avatar);
        this.pet = (LinearLayout) this.pgS.findViewById(a.f.ll_audio);
        this.pdn = (TextView) this.pgS.findViewById(a.f.tv_open_video);
        this.peu = (ImageView) this.pgS.findViewById(a.f.iv_audio_ani);
        this.pfI = (FrescoThumbnailView) this.pgS.findViewById(a.f.live_cover);
        if (!this.pfJ || this.pdz == null || this.pdz.getPlayState() != 4) {
            this.pfI.setVisibility(0);
            this.pfI.setBlur(true);
            this.pfI.j(this.pbg, 0, 0, 0);
        }
        this.pdn.setOnClickListener(this);
        this.paK = new b();
        this.paK.a(view, null, this.phh, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cFC()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.phg != null) {
                    append.append(c.this.phg.eqW().mRoomID);
                }
                if (c.this.paJ != null && c.this.paJ.pdA != null) {
                    append.append("&mode=").append(c.this.paJ.pdA.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.phh, append.toString());
            }
        });
        this.paO = (VoiceInteractionView) this.pgS.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.phg != null) {
            this.peY = this.phg.eqW();
            this.peZ = this.phg.eqU();
        }
        aL();
        erh();
        ern();
        this.pfL = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.pfy = (FoodView) view.findViewById(a.f.rav_ad);
        this.pfQ = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.pfR = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.pfQ.setOnClickListener(this);
        this.pfR.setOnClickListener(this);
        this.pfS = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.pfH = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.pfH.setOnClickListener(this);
        this.peA = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.pez = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.pfi = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.pfi.setOnClickListener(this);
        this.peX = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.peX.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.peX.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.pfE.x, this.pfE.y) * 0.83d);
        this.peX.setLayoutParams(layoutParams);
        this.pfa = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.phh);
        this.peX.setLayoutManager(this.pfa);
        this.peX.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.peX.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.peX.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.erA();
                } else if (i == 1) {
                    c.this.pfh = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.pff = new com.kascend.chushou.player.adapter.a(this.phh, this.pfb);
        if (this.peY != null) {
            this.pff.a(this.peY);
        }
        if (com.kascend.chushou.b.eqb().c != null) {
            this.pff.a(com.kascend.chushou.b.eqb().c);
        }
        this.peX.setAdapter(this.pff);
        this.pff.a(this.pfb.size());
        this.pff.notifyDataSetChanged();
        if (this.phg != null && (c = this.phg.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.peD != null) {
            this.peD.a();
            this.peD = null;
        }
        this.peC = (GiftAnimationLayout) this.pgS.findViewById(a.f.ll_gift_animation);
        this.peC.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.pdM = ((int) (tv.chushou.zues.utils.a.hD(this.phh).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.phh, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.peC.getLayoutParams();
        layoutParams2.bottomMargin = this.pdM;
        this.peC.setLayoutParams(layoutParams2);
        if (this.phg != null) {
            this.peD = new com.kascend.chushou.player.b.a(this.phh.getApplicationContext(), this.peC);
            this.peD.a(this.phg);
            a(this.phg.pao, this.phg.par);
        }
        this.pgS.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.peB = (EmbeddedButtonLayout) this.pgS.findViewById(a.f.embedded_button_layout);
        this.peB.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.pfN = (VideoShowVoteView) this.pgS.findViewById(a.f.view_video_show_vote);
        this.pfN.setOnClickListener(this);
        this.pfN.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.phg != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.phh;
            this.peB.a(videoPlayer.eqF().erZ());
            this.peB.b(this.phg.i());
            this.pez.a(videoPlayer.eqB(), false);
            this.peA.a(videoPlayer.eqC(), videoPlayer.eqD(), videoPlayer.eqE());
            this.paJ = new com.kascend.chushou.player.e.a();
        }
        this.phW = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.pfs = false;
                c.this.b(c.this.pdM, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.pfs = true;
                if (c.this.phM != null) {
                    c.this.phM.measure(0, 0);
                    int measuredHeight = c.this.phM.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.phh, 14.0f);
                    if (measuredHeight > c.this.pdM) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.phQ = (PaoGuideView) this.pgS.findViewById(a.f.rlPaoGuideView);
        this.pfu = (PlayShowMicPerson) this.pgS.findViewById(a.f.rl_mic_person_view);
        this.peF = (PlayShowH5View) this.pgS.findViewById(a.f.rl_playshowh5);
        this.pfA = (FoodView) this.pgS.findViewById(a.f.bottom_ad);
        if (this.phg != null) {
            H();
            if (this.phg.pah != null && !h.isEmpty(this.phg.pah.mUrl)) {
                b(this.phg.pah);
            }
        }
        this.pfj = this.pgS.findViewById(a.f.view_reminder_subscribe);
        this.pfk = this.pfj.findViewById(a.f.spash_subscribe);
        ((TextView) this.pfj.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().Q(this.phh, a.e.videoplayer_reminder_subscribe).append(" ").append(this.phh.getString(a.i.videoplayer_reminder_subscribe)));
        this.pfj.setOnClickListener(this);
        this.pfm = this.pgS.findViewById(a.f.view_reminder_danmaku);
        this.pfn = this.pfm.findViewById(a.f.spash_danmaku);
        ((TextView) this.pfm.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().Q(this.phh, a.e.videoplayer_reminder_danmaku).append(" ").append(this.phh.getString(a.i.videoplayer_reminder_danmaku)));
        this.pfm.setOnClickListener(this);
    }

    private void erh() {
        this.pfX = (RelativeLayout) this.pgS.findViewById(a.f.rl_cyclelive);
        this.pfY = (RelativeLayout) this.pgS.findViewById(a.f.rlrl_cyclelive);
        this.pfZ = (FrescoThumbnailView) this.pgS.findViewById(a.f.iv_liveicon);
        this.pga = (TextView) this.pgS.findViewById(a.f.tv_livename);
        this.pgb = (TextView) this.pgS.findViewById(a.f.tv_livedesc);
        this.pgc = (ImageView) this.pgS.findViewById(a.f.iv_cyclelive_name_menu);
        this.pgd = (RelativeLayout) this.pgS.findViewById(a.f.rl_normal);
        this.pge = (LinearLayout) this.pgS.findViewById(a.f.ll_cyclelive_nickname);
        this.pgf = (TextView) this.pgS.findViewById(a.f.tv_cyclelive_nickname);
        this.pgg = (TextView) this.pgS.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.pgh = (RelativeLayout) this.pgS.findViewById(a.f.rl_clear_cyclelive);
        this.pgi = (RelativeLayout) this.pgS.findViewById(a.f.rlrl_clear_cyclelive);
        this.pgj = (FrescoThumbnailView) this.pgS.findViewById(a.f.iv_clear_liveicon);
        this.pgk = (TextView) this.pgS.findViewById(a.f.tv_clear_livename);
        this.pgl = (TextView) this.pgS.findViewById(a.f.tv_clear_livedesc);
        this.pgm = (ImageView) this.pgS.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.pgn = (RelativeLayout) this.pgS.findViewById(a.f.rl_clear_normal);
        this.pgm.setOnClickListener(this);
        this.pgc.setOnClickListener(this);
        this.pgg.setOnClickListener(this);
        this.pgf.setOnClickListener(this);
        this.pfZ.setOnClickListener(this);
        this.pgj.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.phg.paf != null && this.pfA != null) {
            this.pfA.a(true, this.phg.f4117a == null ? "" : this.phg.f4117a);
            this.pfA.a(this.phg.paf, a.C0969a.slide_in_bottom_danmu_anim, a.C0969a.slide_out_bottom_danmu_anim, true);
        }
        if (this.phg != null && this.phg.pam != null && this.peB != null) {
            this.pfy.a(this.phg.pam, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.phg != null) {
                        c.this.phg.pam = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a erz() {
        return this.peD;
    }

    private void eri() {
        this.phi = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.pgS != null && (textView = (TextView) c.this.pgS.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.phh.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.phi.E(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.phi);
                        break;
                    case 12:
                        c.this.b(c.this.phi);
                        break;
                    case 17:
                        c.this.erU();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.phf.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.peW) {
            this.peW = true;
            if (this.peV == null) {
                this.peV = this.pgS.findViewById(a.f.vs_async_show_content);
                this.peV = ((ViewStub) this.peV).inflate();
            }
            this.paZ = this.pgS.findViewById(a.f.ui_content);
            if (this.pcq == null) {
                this.pcq = this.pgS.findViewById(a.f.vs_async_notification_view);
                this.pcq = ((ViewStub) this.pcq).inflate();
            }
            c(this.pgS);
            k();
            ean();
            if (this.c == null) {
                this.paD = new d.a();
                this.c = new GestureDetector(this.phh, this.paD);
            }
            ((VideoPlayer) this.phh).q();
        }
    }

    private void aL() {
        this.pdS = (LinearLayout) this.pgS.findViewById(a.f.ll_anchor);
        this.pdT = (RelativeLayout) this.pgS.findViewById(a.f.ll_clear_anchor);
        this.pdS.setVisibility(4);
        this.pdT.setVisibility(4);
        this.pdU = (FrescoThumbnailView) this.pgS.findViewById(a.f.iv_clear_avatar);
        this.pdV = (TextView) this.pgS.findViewById(a.f.tv_clear_nickname);
        this.pdW = (TextView) this.pgS.findViewById(a.f.tv_clear_online_count);
        this.pdX = (TextView) this.pgS.findViewById(a.f.tv_clear_btn_subscribe);
        this.pdX.setOnClickListener(this);
        this.pdY = (FrescoThumbnailView) this.pgS.findViewById(a.f.iv_avatar);
        this.pdZ = (TextView) this.pgS.findViewById(a.f.tv_nickname_test);
        this.pea = (TextView) this.pgS.findViewById(a.f.tv_online_count);
        this.pbk = (TextView) this.pgS.findViewById(a.f.tv_btn_subscribe);
        this.pbk.setOnClickListener(this);
        this.peb = (TextView) this.pgS.findViewById(a.f.tv_loyal_counts);
        this.pbn = (TextView) this.pgS.findViewById(a.f.tv_btn_contribution);
        this.pec = (TextView) this.pgS.findViewById(a.f.tv_btn_contribution_forpk);
        this.pbn.setVisibility(4);
        this.pec.setVisibility(8);
        this.ped = (LinearLayout) this.pgS.findViewById(a.f.ll_mic);
        this.pee = (PlayShowMicStatusView) this.pgS.findViewById(a.f.show_mic_status);
        this.pef = (RecyclerView) this.pgS.findViewById(a.f.rv_loyal);
        this.peg = (ImageView) this.pgS.findViewById(a.f.iv_clear_close);
        this.pbt = (ImageView) this.pgS.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.pef.setLayoutManager(linearLayoutManager);
        this.pfr = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void I(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.phh, (JSONObject) null, c.this.phg.eqW().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1101a view$OnLongClickListenerC1101a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC1101a.rW(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC1101a.rW(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1101a.rW(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.j(onlineVipItem.mAvatar, tv.chushou.widget.a.c.eDP(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.phh, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.phh, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.phh, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.phh, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.phh, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.ca(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.pef.setAdapter(this.pfr);
        this.ped.setOnClickListener(this);
        this.pdU.setOnClickListener(this);
        this.peg.setOnClickListener(this);
        this.pdY.setOnClickListener(this);
        this.pdU.setOnClickListener(this);
        this.pbt.setOnClickListener(this);
        this.peb.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dX(View view) {
                String str = tv.chushou.common.a.cFC() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.phg != null) {
                    str = str + c.this.phg.eqW().mRoomID;
                }
                c.this.f(c.this.phh.getString(a.i.str_loyal_fans), str);
            }
        });
        this.pbn.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dX(View view) {
                String str = tv.chushou.common.a.cFC() + "m/room-billboard/";
                if (c.this.phg != null) {
                    str = str + c.this.phg.eqW().mRoomID;
                }
                c.this.f(c.this.phh.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.pec.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dX(View view) {
                String str = tv.chushou.common.a.cFC() + "m/room-billboard/";
                if (c.this.phg != null) {
                    str = str + c.this.phg.eqW().mRoomID;
                }
                c.this.f(c.this.phh.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.peZ == null || this.peZ.cycleLiveRoomInfo == null || h.isEmpty(this.peZ.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.paM = this.peZ.cycleLiveRoomInfo;
        }
        if (z2 && this.paM != null) {
            this.pfX.setVisibility(0);
            this.pgh.setVisibility(0);
            this.pgd.setVisibility(8);
            this.pgn.setVisibility(8);
            this.pge.setVisibility(0);
            this.pgj.i(this.paM.eventIcon, com.kascend.chushou.view.a.a(this.peY.mCreatorGender), b.a.small, b.a.small);
            this.pfZ.i(this.paM.eventIcon, com.kascend.chushou.view.a.a(this.peY.mCreatorGender), b.a.small, b.a.small);
            this.pgk.setText(this.paM.eventName);
            this.pgl.setText(this.paM.eventDesc);
            this.pga.setText(this.paM.eventName);
            this.pgb.setText(this.paM.eventDesc);
            this.pgf.setText(this.paM.nickname);
            erk();
            if (z) {
                c(this.paM.remainTime);
                return;
            }
            return;
        }
        this.pfX.setVisibility(8);
        this.pgh.setVisibility(8);
        this.pgd.setVisibility(0);
        this.pgn.setVisibility(0);
        this.pge.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.pgo != null) {
            this.pgo.dispose();
            this.pgo = null;
        }
        this.pgo = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.ewM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.phh != null && (c.this.phh instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.phh).u();
                }
            }
        });
    }

    private void erj() {
        if (this.peY != null && this.peW) {
            this.pdS.setVisibility(0);
            this.pdT.setVisibility(0);
            this.pbn.setVisibility(0);
            this.pdU.i(this.peY.mCreatorAvatar, com.kascend.chushou.view.a.a(this.peY.mCreatorGender), b.a.small, b.a.small);
            this.pdV.setText(this.peY.mCreatorNickname);
            this.pdY.i(this.peY.mCreatorAvatar, com.kascend.chushou.view.a.a(this.peY.mCreatorGender), b.a.small, b.a.small);
            this.pdZ.setText(this.peY.mCreatorNickname);
            erL();
            erl();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void erL() {
        if (this.peY != null) {
            this.pdW.setText(tv.chushou.zues.utils.b.formatNumber(this.peY.mOnlineCount));
            this.pea.setText(tv.chushou.zues.utils.b.formatNumber(this.peY.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erk() {
        if (this.paM != null) {
            if (this.paM.isSubscribe) {
                this.pgg.setText(a.i.like_already);
                this.pgg.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.pgg.setText(getString(a.i.like));
            this.pgg.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erl() {
        if (this.peY != null) {
            if (this.peY.mIsSubscribed) {
                this.pdX.setText(getString(a.i.like_already));
                this.pdX.setBackgroundResource(a.e.bg_show_subcribe);
                this.pbk.setText(getString(a.i.like_already));
                this.pbk.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.pdX.setText(getString(a.i.like));
            this.pdX.setBackgroundResource(a.e.bg_show_subcribe);
            this.pbk.setText(getString(a.i.like));
            this.pbk.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void erm() {
        if (this.pfr != null) {
            this.pfr.notifyDataSetChanged();
        }
    }

    private void ern() {
        this.pei = this.pgS.findViewById(a.f.tv_interact);
        this.pei.setOnClickListener(this);
        this.pen = (RelativeLayout) this.pgS.findViewById(a.f.rl_edit_bar);
        this.pel = (ImageView) this.pgS.findViewById(a.f.btn_hotword);
        this.pel.setOnClickListener(this);
        this.pem = (ImageView) this.pgS.findViewById(a.f.iv_task_badge);
        this.pek = (AnimationSet) AnimationUtils.loadAnimation(this.phh, a.C0969a.anim_hotword);
        this.pek.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.eqj().c) {
                    c.this.pel.clearAnimation();
                    c.this.pel.startAnimation(c.this.pek);
                }
            }
        });
        if (com.kascend.chushou.d.h.eqj().c) {
            this.pel.startAnimation(this.pek);
            this.pem.setVisibility(0);
        }
        this.pgp = (TextView) this.pgS.findViewById(a.f.tv_bottom_input);
        this.pgp.setOnClickListener(this);
        this.pij = (FrescoThumbnailView) this.pgS.findViewById(a.f.ll_btn_set);
        this.pij.setOnClickListener(this);
        this.pij.DK(a.e.ic_room_set_btn_white);
        this.pew = (LinearLayout) this.pgS.findViewById(a.f.ll_bottom_all_button);
        this.pex = (FrescoThumbnailView) this.pgS.findViewById(a.f.fl_clear_bottom_gift);
        this.pex.setAnim(true);
        this.pex.setOnClickListener(this);
        this.pex.DK(a.e.ic_show_gift_n);
        this.pey = (FrameLayout) this.pgS.findViewById(a.f.flfl_clear_bottom_gift);
        this.pey.setVisibility(8);
        this.pej = (RelativeLayout) this.pgS.findViewById(a.f.rl_bottom_input);
        this.pej.setVisibility(0);
        this.peo = (PastedEditText) this.pgS.findViewById(a.f.et_bottom_input);
        this.peo.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.pbC.setEnabled(editable.length() > 0);
            }
        });
        this.peo.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.pbC);
                    return true;
                }
                return true;
            }
        });
        this.peo.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.peo);
                }
                return false;
            }
        });
        this.pbL = (ImageView) this.pgS.findViewById(a.f.iv_btn_emoji);
        this.pbL.setVisibility(8);
        this.pbC = (TextView) this.pgS.findViewById(a.f.tv_btn_send);
        this.pbC.setOnClickListener(this);
        this.peG = (LinearLayout) this.pgS.findViewById(a.f.head_trumpet);
        this.peG.setVisibility(8);
        this.peG.setOnClickListener(this);
        this.peH = (TextView) this.pgS.findViewById(a.f.tv_primary_name);
        this.peI = (TextView) this.pgS.findViewById(a.f.tv_primary_desc);
        this.peK = (TextView) this.pgS.findViewById(a.f.tv_cut_count);
        this.peK.setOnClickListener(this);
        this.peM = (TextView) this.pgS.findViewById(a.f.tv_head_count);
        this.peM.setText(this.peP + "");
        this.peL = (TextView) this.pgS.findViewById(a.f.tv_plus_count);
        this.peL.setOnClickListener(this);
        this.pcc = (TextView) this.pgS.findViewById(a.f.tv_buy_count_coin);
        this.peJ = (TextView) this.pgS.findViewById(a.f.tv_buy_head);
        this.peJ.setOnClickListener(this);
        this.peN = (ImageView) this.pgS.findViewById(a.f.iv_trumpet_select);
        this.peN.setOnClickListener(this);
        this.peO = (TextView) this.pgS.findViewById(a.f.tv_trumpet_have_count);
        this.peQ = false;
        this.peN.setBackgroundResource(a.e.ic_trumpet_n);
        this.peO.setVisibility(8);
        this.pbK = (KPSwitchPanelLinearLayout) this.pgS.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.pbK, this.pbL, this.peo, new a.InterfaceC1105a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1105a
            public void At(boolean z) {
                if (c.this.pbL != null) {
                    if (z) {
                        c.this.pbK.setDirectVisibility(0);
                        c.this.pbL.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.pbL.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.pbN = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void jX(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.pbL.setImageResource(a.e.cs_emoji_normal);
                    c.this.erp();
                    if (c.this.pfW != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.pfW.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.phh);
                        c.this.pfW.setLayoutParams(layoutParams);
                    }
                    if (c.this.pen != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.pen.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.phh);
                        c.this.pen.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.pfW != null && c.this.pfW.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.pfW.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.pfW.setLayoutParams(layoutParams3);
                    c.this.pfW.setVisibility(8);
                }
                if (c.this.pfs) {
                    c.this.phM.setVisibility(0);
                }
                if (c.this.phh != null && (c.this.phh instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.phh).As(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.pen != null && c.this.pbK.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.pen.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.pen.setLayoutParams(layoutParams4);
                }
            }
        };
        this.pbM = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.pbK, this.pbN, ((VideoPlayer) this.phh).eqA());
        ((VideoPlayer) this.phh).h(((VideoPlayer) this.phh).eqA());
        this.pfW = this.pgS.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.pfT = (TextView) this.pgS.findViewById(a.f.btn_room_search);
        this.pfU = (ImageView) this.pgS.findViewById(a.f.iv_room_emoji_delete);
        this.pfV = (EditText) this.pgS.findViewById(a.f.et_room_emoji_search);
        this.pfV.setImeOptions(3);
        this.pfV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.pfT);
                    return true;
                }
                return false;
            }
        });
        this.pfV.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.pfT.setEnabled(editable.length() > 0);
                c.this.pfU.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.phM.setEmojiSearchText(editable.toString());
            }
        });
        this.pfT.setOnClickListener(this);
        this.pfU.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aI(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.bz(this.pfV);
            this.pfW.setVisibility(0);
            this.pfV.requestFocus();
        } else {
            this.pfW.setVisibility(8);
        }
        if (z2) {
            this.pfV.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erp() {
        int ek = tv.chushou.zues.widget.kpswitch.b.d.ek(this.phh) + tv.chushou.zues.utils.a.dip2px(this.phh, 14.0f);
        if (ek > this.pdM) {
            b(ek, 12);
        }
    }

    private void aS() {
    }

    private void ers() {
        if (this.peS > 0) {
            View findViewById = this.pgS.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.peS);
        }
        if (this.peR > 0) {
            View findViewById2 = this.pgS.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.peR, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.pfp) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.paF = ((VideoPlayer) this.phh).eqw();
        this.paF.a(this);
        if (this.phg.eqU() != null) {
            s();
        } else if (this.pgT != null) {
            this.pgT.setVisibility(0);
        }
        if (this.paF != null) {
            this.paF.d();
        }
    }

    private void ert() {
        if ((this.paJ == null || this.paJ.pdA == null || !this.paJ.pdA.mInPKMode) ? false : true) {
            if (this.pdN != null) {
                this.pdN.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.paL.getLayoutParams();
            layoutParams.leftMargin = (this.pfE.x / 2) + tv.chushou.zues.utils.a.dip2px(this.phh, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.paL.setLayoutParams(layoutParams);
            this.y.setText(this.paJ.pdA.mPkUserNickname);
            this.paL.setVisibility(0);
            this.ped.setVisibility(8);
            return;
        }
        if (this.pdN != null) {
            this.pdN.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.paL.setVisibility(8);
    }

    private void erv() {
        boolean z = false;
        if (this.paJ != null && this.paJ.pdA != null && this.paJ.pdA.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.pfP > 0 && this.peX != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.peX.getLayoutParams();
                if (layoutParams.height != this.pfP) {
                    layoutParams.height = this.pfP;
                    this.peX.setLayoutParams(layoutParams);
                }
            }
            this.pdM = ((int) (tv.chushou.zues.utils.a.hD(this.phh).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.phh, 84.0f);
            b(this.pdM, 12);
        } else {
            if (this.peX != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.peX.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.phh, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.phh, 250.0f);
                    this.peX.setLayoutParams(layoutParams2);
                }
            }
            this.pdM = ((int) (tv.chushou.zues.utils.a.hD(this.phh).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.phh, 84.0f);
            b(this.pdM, 12);
        }
        if (this.paK != null) {
            this.paK.a(this.pfP + tv.chushou.zues.utils.a.dip2px(this.phh, 52.0f), this.aq);
        }
        if (this.paO != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.paO.getLayoutParams();
            layoutParams3.bottomMargin = this.pfP + tv.chushou.zues.utils.a.dip2px(this.phh, 52.0f);
            this.paO.setLayoutParams(layoutParams3);
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

    private void erw() {
        erv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) erS().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pgT.getLayoutParams();
        this.pfE = tv.chushou.zues.utils.a.hE(this.phh);
        this.pfD = 86;
        this.dB = (Math.max(this.pfE.x, this.pfE.y) - tv.chushou.zues.utils.a.dip2px(this.phh, (this.pfD + 52) + 250)) - this.peR;
        this.pfC = Math.max(this.pfE.x, this.pfE.y) - ((tv.chushou.zues.utils.a.dip2px(this.phh, this.pfD) + this.peR) * 2);
        if (this.pfF <= 0 || this.pfG <= 0) {
            this.pfF = Math.min(this.pfE.x, this.pfE.y);
            this.pfG = Math.max(this.pfE.x, this.pfE.y);
        }
        this.ar = Math.min(this.pfE.x, this.pfE.y);
        this.aq = (this.ar * this.pfG) / this.pfF;
        boolean z = false;
        if (this.paJ == null || this.paJ.pdA == null) {
            i = 1;
        } else {
            i = this.paJ.pdA.mMode;
            if (this.paJ.pdA.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.pfD = 42;
            if (i == 2) {
                if (this.pfG < this.pfF) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.pfF * layoutParams.height) / this.pfG;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.phh, this.pfD) + this.peR;
            layoutParams.gravity = 48;
            this.pfP = ((this.pfE.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.phh, (this.pfD + 52) + 64) + this.peR)) - tv.chushou.zues.utils.systemBar.b.aG(getActivity());
            aG();
        } else if (this.E) {
            this.pfD = 42;
            if (this.pfG < this.pfF) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.pfF * layoutParams.height) / this.pfG;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.phh, this.pfD) + this.peR;
            layoutParams.gravity = 48;
            this.pfP = ((this.pfE.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.phh, (this.pfD + 52) + 98) + this.peR)) - tv.chushou.zues.utils.systemBar.b.aG(getActivity());
            erw();
        } else {
            this.pfP = -1;
            this.pfD = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.phh, this.pfD) + this.peR;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.pfC) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.phh, this.pfD) + this.peR;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.pfE.x, this.pfE.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.pfF) / this.pfG >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.pfF) / this.pfG;
                    } else if ((this.ar * this.pfG) / this.pfF >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.pfG) / this.pfF;
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
                    if ((this.ar * this.pfG) / this.pfF > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.pfF) / this.pfG;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.pfG) / this.pfF;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.pfG) / this.pfF;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.pfF) / this.pfG;
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
        if (this.phg != null && this.phg.d) {
            layoutParams.width = Math.min(this.pfE.x, this.pfE.y);
            layoutParams.height = Math.max(this.pfE.x, this.pfE.y);
        }
        erS().setLayoutParams(layoutParams);
        this.pgT.setLayoutParams(layoutParams2);
        this.pgT.requestLayout();
    }

    private void aY() {
        this.pgT = new SurfaceRenderView(this.phh);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.pgT;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        erS().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.pfx) {
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
        if (this.pgs != null) {
            this.pgs.a();
        }
        if (this.phg != null && !h.isEmpty(this.phg.w)) {
            b(this.phg.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.pdz != null) {
            int width = this.pdz.getWidth();
            int height = this.pdz.getHeight();
            if (this.pfF != width || this.pfG != height || this.pfF <= 0 || this.pfG <= 0) {
                this.pfF = width;
                this.pfG = height;
                if (this.pgT != null) {
                    this.pgT.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.pfs) {
                ery();
            } else {
                if (this.phh.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.phh, "点击送礼_num", "竖屏", new Object[0]);
                if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.phg.eqU().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.peQ) {
                f(this.peo.getText().toString());
            } else {
                a(this.peo.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.eqj().c) {
                com.kascend.chushou.d.h.eqj().b(false);
                this.pek.cancel();
                this.pek.reset();
                this.pel.clearAnimation();
                this.pem.setVisibility(8);
            }
            n(view, 0, this.pgS.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.phh, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.pgS.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.phg.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.phg.d) {
                eag();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.peX != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.peY != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.pfw = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.phh, (JSONObject) null, this.phg.eqW().mRoomID, this.phg.eqW().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.phh.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.phh, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.pfz != null) {
                    com.kascend.chushou.d.e.a(this.phh, this.pfz, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.pfS != null) {
                    this.pfS.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.phh, null) && this.phg != null && this.phg.paq != null) {
                    if (this.peQ) {
                        bo();
                    } else {
                        if (this.phg != null && this.phg.paq != null && this.phg.paq.count > 0) {
                            this.peG.setVisibility(8);
                        } else {
                            this.peG.setVisibility(0);
                        }
                        this.peQ = true;
                        this.peN.setBackgroundResource(a.e.ic_trumpet_p);
                        this.peO.setVisibility(0);
                        this.peO.setSelected(true);
                        this.peO.setTextColor(Color.parseColor("#ff5959"));
                        if (this.peo != null) {
                            this.peo.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.peP <= 9) {
                    this.peP++;
                    this.peM.setText(this.peP + "");
                }
                erg();
            } else if (id == a.f.tv_cut_count) {
                if (this.peP > 1) {
                    this.peP--;
                    this.peM.setText(this.peP + "");
                }
                erg();
            } else if (id == a.f.tv_buy_head) {
                erQ();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.pfV.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.pfV.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.pfW.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.eh(this.pfV);
                    this.phM.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.paM != null && !h.isEmpty(this.paM.eventUrl)) {
                    f("", this.paM.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.paM != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.paM != null) {
                    com.kascend.chushou.d.a.a(this.phh, (JSONObject) null, this.paM.roomId, this.paM.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.phg.a(false);
                    ((VideoPlayer) this.phh).l();
                } else {
                    ((VideoPlayer) this.phh).a(true, (Uri) null, false);
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
        if (this.peF != null) {
            int i = (tv.chushou.zues.utils.a.hD(this.phh).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.peF.getLayoutParams();
            layoutParams.topMargin = i;
            this.peF.setLayoutParams(layoutParams);
            this.peF.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.f4231a = str2;
            h5Options.c = false;
            this.peF.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.RH(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.pfv <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.RH(a.i.str_too_fast);
            return false;
        } else {
            eas();
            if (!com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a(((VideoPlayer) this.phh).eqv().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.pfv = System.currentTimeMillis();
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                a(this.phg.eqU().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.phg.h);
            }
            g(this.b);
            if (!z && this.peo != null) {
                this.peo.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            eas();
            if (com.kascend.chushou.d.e.c(this.phh, null) && LoginManager.Instance().getUserInfo() != null && this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                a(this.phg.eqU().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.peo != null) {
                this.peo.setText((CharSequence) null);
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
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.phg.eqU().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.phg.eqU().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.phh).oYE;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.ZW(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.phH != null && this.phH.isShowing()) {
            this.phH.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
        if (this.pig == null) {
            i(3);
        }
        this.pig.getContentView().setBackgroundResource(0);
        this.pig.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.pig.isShowing()) {
            this.pig.showAtLocation(view, 83, i, i2);
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.phg.eqU().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.pig.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.pik)) {
            if (((VideoPlayer) this.phh).q) {
                this.pij.DK(a.e.ic_room_set_btn_white);
            } else {
                this.pij.DK(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.phh).q && this.pik.size() == 2 && this.pik.contains("4") && this.pik.contains("2")) {
            this.pij.DK(a.e.ic_room_set_btn_system_white);
        } else if (this.pik.size() > 1 || !((VideoPlayer) this.phh).q) {
            this.pij.DK(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.pik.get(0))) {
            this.pij.DK(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.pik.get(0))) {
            this.pij.DK(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.pik.get(0))) {
            this.pij.DK(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
        if (this.phH == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.phH.getContentView().setBackgroundResource(0);
            this.phH.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.phH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.pel.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.phH.isShowing()) {
            this.phH.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.phh, 16.0f) + i2);
            this.pel.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.phg.eqU().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.phH.dismiss();
    }

    private void e(View view) {
        if (this.phB == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.eqj().q()) {
            this.pep.eDN();
        } else {
            this.pep.eDO();
        }
        int height = this.pgS.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity());
        if (view != null) {
            this.phB.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.phB == null) {
            View inflate = LayoutInflater.from(this.phh).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.pep = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.eqj().q()) {
                this.pep.eDN();
            } else {
                this.pep.eDO();
            }
            this.pep.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.eqj().g(z);
                }
            });
            this.phv = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.phw = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.phv.setOnClickListener(this);
            if (com.kascend.chushou.c.f4077a) {
                this.phv.setVisibility(0);
            } else {
                this.phv.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.eqj().f4085a) {
                this.phw.b();
            } else {
                this.phw.c();
            }
            if (this.phg != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.phg.f;
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
                                if (this.paJ == null || !this.paJ.pdA.mInPKMode || h.isEmpty(this.paJ.b) || this.peY == null || !this.paJ.b.equals(this.peY.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.phh).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl eqV = this.phg.eqV();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.phh).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.phh, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.phh, 5.0f);
                                            }
                                            int identifier = this.phh.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.phh.getPackageName());
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
                                                if (eqV != null && eqV.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.phh.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.phh).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl eqV2 = this.phg.eqV();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.phh).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.phh, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.phh, 5.0f);
                                        }
                                        int identifier2 = this.phh.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.phh.getPackageName());
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
                                            if (eqV2 != null && eqV2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.phB.dismiss();
                    }
                }
            });
            this.phB = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 150.0f), -2);
            this.phB.setFocusable(true);
            this.phB.setOutsideTouchable(true);
            this.phB.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.phB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.phB = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
            if (this.peE == null) {
                this.peE = new f(getActivity());
            }
            this.peE.a(this.phg.eqU().mRoominfo, this.ax);
            if (!this.peE.isShowing()) {
                this.peE.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.pfx) {
            return false;
        }
        if (this.pfw == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.pgq = motionEvent.getX();
                    this.pgr = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.pgq;
                    if (Math.abs(f) > Math.abs(y - this.pgr) && Math.abs(f) > q && f > 0.0f) {
                        erN();
                        return true;
                    }
                    this.pgq = 0.0f;
                    this.pgr = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.pfW != null && this.pfW.getVisibility() == 0 && a(motionEvent, this.pfW)) {
                this.pfW.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.eh(this.pfV);
                return true;
            } else if (this.pfs && this.pfW != null && this.pfW.getVisibility() == 8 && f(this.phM.b, motionEvent)) {
                ery();
                return true;
            } else if (this.peF != null && this.peF.b() && f(this.peF, motionEvent)) {
                this.peF.a();
                return true;
            } else if (this.pev != null && this.pev.b() && f(this.pev, motionEvent)) {
                this.pev.a();
                return true;
            } else if (a(motionEvent, this.pen)) {
                return eas();
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
            if (this.phY != null && this.phY.a(i, keyEvent)) {
                return true;
            }
            if ((this.peF != null && this.peF.onKeyDown(i, keyEvent)) || erq()) {
                return true;
            }
            if (this.pfw == 3) {
                this.pfw = 1;
                erN();
                return true;
            } else if (this.pev != null && this.pev.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.peo != null && this.pej != null && this.pen != null) {
                tv.chushou.zues.widget.kpswitch.b.d.bz(this.peo);
                this.pej.setVisibility(8);
                this.pen.setVisibility(0);
            }
        } else if (this.pej != null && this.pen != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
            this.pej.setVisibility(0);
            this.pen.setVisibility(8);
        }
    }

    public boolean eas() {
        boolean z;
        b(this.pdM, 12);
        boolean z2 = false;
        if (this.pbK != null && this.pbK.getVisibility() == 0) {
            this.pbK.setVisibility(8);
            this.pbL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.phh);
            this.pbL.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.pen == null || this.pen.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.peQ) {
                bo();
            }
            this.pen.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.pej != null) {
                    c.this.pej.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean erq() {
        if (eas()) {
            return true;
        }
        if (this.phH != null && this.phH.isShowing()) {
            this.phH.dismiss();
            return true;
        } else if (this.pig != null && this.pig.isShowing()) {
            this.pig.dismiss();
            return true;
        } else if (this.phB == null || !this.phB.isShowing()) {
            return ery() || err() || erx() || erf();
        } else {
            this.phB.dismiss();
            return true;
        }
    }

    public boolean erf() {
        if (this.phQ == null || !this.phQ.isShown()) {
            return false;
        }
        this.phQ.d();
        return true;
    }

    public boolean err() {
        if (this.pfu == null || !this.pfu.isShown()) {
            return false;
        }
        this.pfu.a();
        return true;
    }

    public boolean erx() {
        if (this.peF == null || !this.peF.b()) {
            return false;
        }
        this.peF.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.phh != null && !((Activity) this.phh).isFinishing() && pVar != null) {
            this.pfg = pVar.f4075a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.peY != null && mVar.a(this.peY.mCreatorUID, null)) {
            this.peY.mIsSubscribed = mVar.c;
            erl();
        }
    }

    public boolean ery() {
        if (!this.pfs || this.phM == null) {
            return false;
        }
        if (this.phM != null) {
            this.phM.e();
        }
        if (this.pfV != null) {
            this.pfV.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.pfB != null) {
                        this.pfB.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                        this.phg.eqU().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.phg.eqU().mMicStatus.onMic) {
                            if (this.ped != null) {
                                this.ped.setVisibility(8);
                            }
                            if (this.pfu != null && this.pfu.isShown()) {
                                this.pfu.a();
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
                        if (this.phg.eqU().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.peY != null && !h.isEmpty(this.peY.mCreatorUID)) {
                                g(arrayList2, this.peY.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.phg.eqU().mMicStatus.onMic) {
                            if (this.phg.eqU().mMicStatus != null && !h.isEmpty(this.phg.eqU().mMicStatus.micRoomId) && !this.phg.eqU().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.phg.eqU().mMicStatus.micRoomId;
                            }
                            this.phg.eqU().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.phg.eqU().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.phg.eqU().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.phg.eqU().mMicStatus, str3, z4);
                            if (this.pfu != null && this.pfu.getVisibility() == 0) {
                                this.pfu.a(this.phg.eqU().mFanItems, this.phg.eqU().mMicStatus, str3, z4, this.phg.eqU().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.ped != null) {
                                this.ped.setVisibility(8);
                            }
                            if (this.pfu != null && this.pfu.isShown()) {
                                this.pfu.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.peU != onlineVip.mCount || (this.peb != null && this.peb.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.peU = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        erD();
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
                            if (!z3 || System.currentTimeMillis() - this.pfM <= 5000) {
                                z2 = false;
                            } else {
                                this.pfM = System.currentTimeMillis();
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
                            erm();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.pfN != null) {
                    if (this.peY == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.peY.mCreatorAvatar;
                        str2 = this.peY.mCreatorGender;
                    }
                    this.pfN.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.paJ != null && this.paJ.pdA != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.paJ.pdA.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.paF != null) {
                                        this.paF.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.paJ.pdA.mInPKMode = true;
                                    this.paJ.pdA.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.paJ.pdA.mPkUid = pkNotifyInfo.mPkUid;
                                    this.paJ.pdA.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.paJ.pdA.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.paJ.pdA.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.paJ.pdA.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.paJ.pdA.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.paJ.pdA.mMode = pkNotifyInfo.mMode;
                                    this.paJ.pdA.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.paK != null) {
                                        this.paK.k(true, this.paJ.pdA.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.eqj().f4085a) {
                                        if (!com.kascend.chushou.b.eqb().e) {
                                            com.kascend.chushou.b.eqb().e = true;
                                            tv.chushou.zues.utils.g.N(this.phh, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.eqj().a(this.phh, false);
                                        eru();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.paJ.pdA.mAction = 7;
                                    this.paJ.pdA.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.paJ.pdA.mPkUid = pkNotifyInfo.mPkUid;
                                    this.paJ.pdA.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.paJ.pdA.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.paJ.pdA.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.paJ.pdA.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.paJ.pdA.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.paK != null) {
                                        this.paK.k(false, 0L);
                                        this.paK.b(this.paJ.pdA, true);
                                        this.paK.a(this.pfP + tv.chushou.zues.utils.a.dip2px(this.phh, 52.0f), this.aq);
                                        this.paK.a(this.paJ.pdA.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.paF != null) {
                                        this.paF.a(false);
                                    }
                                    this.paJ.pdA.mInPKMode = false;
                                    this.paJ.pdA.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.paK != null) {
                                        this.paK.c();
                                    }
                                    this.paJ.b = null;
                                    this.paJ.pdA = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.paJ.pdA.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.paJ.pdA.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.paJ.pdA.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.peY != null && !h.isEmpty(this.peY.mRoomID) && this.peY.mRoomID.equals(this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.paJ.pdA.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.paK != null) {
                                        this.paK.a(this.paJ.pdA, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.paJ.pdA.copyUpdate(pkNotifyInfo);
                                    if (this.paK != null) {
                                        this.paK.a(this.paJ.pdA);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.paJ.pdA.copyStop(pkNotifyInfo);
                                        if (this.paK != null) {
                                            this.paK.J(this.paJ.pdA.mMaxFreeDuration, this.paJ.pdA.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.paJ.pdA.copyResult(pkNotifyInfo);
                                    if (!this.pfq && this.paK != null) {
                                        int i7 = 1;
                                        if (this.paJ.pdA.destinyInfo != null && this.paJ.pdA.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.paK.a(h.parseInt(this.paJ.pdA.mResult), h.parseLong(this.paJ.pdA.mvpUid), this.paJ.pdA.mvpAvatar, this.paJ.pdA.mvpNickname, this.paJ.pdA.mMaxFreeDuration, this.paJ.pdA.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.paM != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.paM.uid = cycleLiveRoomInfo.uid;
                        this.paM.remainTime = cycleLiveRoomInfo.remainTime;
                        this.paM.roomId = cycleLiveRoomInfo.roomId;
                        this.paM.avatar = cycleLiveRoomInfo.avatar;
                        this.paM.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.phh != null && (this.phh instanceof VideoPlayer)) {
                            ((VideoPlayer) this.phh).d();
                        }
                    } else {
                        ((VideoPlayer) this.phh).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.phg != null && this.phg.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.eqj().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.eqj().b().equals(next2.mUserID)) {
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

    public void erD() {
        if (this.peb != null) {
            if (this.paJ == null || this.paJ.pdA == null || !this.paJ.pdA.mInPKMode) {
                if (this.bP > 0) {
                    this.peb.setVisibility(0);
                    this.peb.setText(String.format(this.phh.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.pef.setVisibility(0);
                    return;
                }
                this.peb.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.ped.setVisibility(0);
            if (this.pee != null) {
                this.pee.a(str, z, micStatus, this.phg.eqU().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.ped.setVisibility(8);
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
    public void erA() {
        int childCount = this.pfa.getChildCount();
        int itemCount = this.pfa.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.pfa);
        if (f + childCount >= itemCount) {
            this.pfh = true;
            if (this.pfi != null) {
                this.pfi.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void erJ() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.pfb.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.pfb.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.pfb == null) {
            this.pfb = new ArrayList<>();
        }
        while (2 < this.pfb.size()) {
            this.pfb.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.pfd);
        if (a2 == null) {
            w(false);
            return;
        }
        this.pfb.addAll(a2);
        int size = this.pfb.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.pfb.size(); i++) {
                this.pfb.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.pfe == null) {
            this.pfe = new ArrayList<>();
        }
        this.pfe.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.pfg != null && this.pfg.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.pfg.contains("2"))) {
                        this.pfe.add(next);
                    } else if (!this.pfg.contains(next.mType)) {
                        this.pfe.add(next);
                    }
                }
                return this.pfe;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.pfb == null) {
                    this.pfb = new ArrayList<>(arrayList);
                    erJ();
                    w(z2);
                    return;
                }
                if (this.pfd == null) {
                    this.pfd = new ArrayList<>();
                }
                this.pfd.addAll(arrayList);
                int size = this.pfd.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.pfd.size(); i++) {
                        this.pfd.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.pfb.size();
                if (a2 != null) {
                    this.pfb.addAll(a2);
                }
                int size3 = this.pfb.size();
                if (!this.pfh && this.pfi != null) {
                    this.pfi.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.pfb.size(); i3++) {
                        this.pfb.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.pfb == null) {
                this.pfb = new ArrayList<>(arrayList);
                erJ();
            } else {
                if (this.pfd == null) {
                    this.pfd = new ArrayList<>();
                }
                this.pfd.clear();
                this.pfd.addAll(arrayList);
                this.pfb.clear();
                erJ();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.pfb.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.pff != null) {
                this.pff.a(this.pfb.size());
                if (i == 1) {
                    this.pff.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.pff.notifyItemRangeRemoved(i2, i3);
                    this.pff.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.pff.notifyDataSetChanged();
                }
            }
            if (z || this.pfh) {
                this.pfh = true;
                if (this.pfi != null) {
                    this.pfi.setVisibility(8);
                }
                if (z) {
                    this.peX.scrollToPosition(this.pfb.size() - 1);
                } else {
                    this.peX.smoothScrollToPosition(this.pfb.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.pff != null) {
                this.pff.a(this.pfb.size());
                this.pff.notifyDataSetChanged();
            }
            if (z || this.pfh) {
                this.pfh = true;
                if (this.pfi != null) {
                    this.pfi.setVisibility(8);
                }
                if (z) {
                    this.peX.scrollToPosition(this.pfb.size() - 1);
                } else {
                    this.peX.smoothScrollToPosition(this.pfb.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a eqG;
        RoomToast roomToast;
        this.p = false;
        if (this.phg != null && this.phg.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.phg.f.size()) {
                    break;
                } else if (!"2".equals(this.phg.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            erM();
            return;
        }
        if (this.paZ != null) {
            this.paZ.setVisibility(0);
        }
        if (this.pdR != null) {
            this.pdR.setVisibility(0);
        }
        if (this.phg != null) {
            this.peY = this.phg.eqW();
            this.peZ = this.phg.eqU();
            if (com.kascend.chushou.b.eqb().c != null && this.pff != null) {
                this.pff.a(com.kascend.chushou.b.eqb().c);
                this.pff.notifyDataSetChanged();
            }
            FullRoomInfo eqU = this.phg.eqU();
            if (eqU != null) {
                if (!h.isEmpty(eqU.mRoomToastList)) {
                    Iterator<RoomToast> it = eqU.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.eqj().j())) {
                    a(roomToast);
                }
            }
            if (this.peY != null) {
                bk();
            }
            if (this.peY != null && !this.peY.mIsSubscribed) {
                RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.peY == null || !c.this.peY.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.phg != null && this.phg.l()) {
                d(true);
            }
        }
        if (this.peY != null && this.pff != null) {
            if (this.pfb != null) {
                this.pfb.clear();
            } else {
                this.pfb = new ArrayList<>();
            }
            this.pff.a(this.peY);
            erJ();
            this.pff.a(this.pfb.size());
            this.pff.notifyDataSetChanged();
        }
        erj();
        N();
        if (this.phh != null && (this.phh instanceof VideoPlayer) && (eqG = ((VideoPlayer) this.phh).eqG()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(eqG.pdA, eqG.b);
        }
        this.pes.i(this.peY.mCreatorAvatar, com.kascend.chushou.view.a.a(this.peY.mCreatorGender), 0, 0);
        if (this.pgT != null) {
            this.pgT.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.pew);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void erB() {
        if (this.peT == null) {
            View inflate = LayoutInflater.from(this.phh).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.pcn = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.peT = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.phh, 160.0f), -2);
            this.peT.setFocusable(false);
            this.peT.setOutsideTouchable(false);
            this.peT.setAnimationStyle(a.j.gift_toast_style);
            this.peT.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.eqj().c(roomToast.mToastContent);
            if (this.peT == null) {
                erB();
            }
            if (this.pcn != null) {
                this.pcn.setText(roomToast.mToastContent);
            }
            if (!this.peT.isShowing()) {
                if (this.pew != null) {
                    this.peT.showAtLocation(this.pew, 85, 0, this.pgS.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aG(getActivity()));
                    RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.peT != null) {
                                c.this.peT.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.peT.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.pfI != null) {
            this.pfI.setVisibility(z ? 0 : 8);
        }
        this.pfJ = true;
        if (this.phh instanceof VideoPlayer) {
            ((VideoPlayer) this.phh).p();
        }
    }

    private void erM() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.phh).s();
        erf();
        err();
        if (this.peh == null) {
            this.peh = (PlayShowRecommendView) ((ViewStub) this.pgS.findViewById(a.f.view_recommend)).inflate();
        }
        this.peh.setVisibility(0);
        if (this.phg.eqU() != null && this.phg.eqU().mRoominfo != null && !h.isEmpty(this.phg.eqU().mRoominfo.mRoomID)) {
            erE();
        }
        if (this.pgT != null) {
            this.pgT.setVisibility(8);
        }
        if (this.phM != null) {
            this.phM.e();
        }
        if (this.paZ != null) {
            this.paZ.setVisibility(4);
        }
        if (this.pdR != null) {
            this.pdR.setVisibility(8);
        }
        if (this.phU != null) {
            this.phU.eDl();
            this.phU.setVisibility(8);
        }
        Av(false);
        a(false, false);
        if (this.paF != null) {
            this.paF.a();
        }
    }

    private void erE() {
        if (this.peh != null && this.peh.getVisibility() == 0) {
            this.peh.a(this.phg.eqU().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.phh instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.phh;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.peF != null && this.peF.b()) {
            this.peF.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.pft);
        if (this.phh != null) {
            if (this.pft || "10004".equals(((VideoPlayer) this.phh).t)) {
                this.pft = true;
                if (this.phg != null) {
                    this.phg.f = null;
                    if (this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                        this.phg.eqU().mRoominfo.mGameId = null;
                    }
                }
                erM();
                return;
            }
            this.pft = true;
            if (this.phh != null) {
                ((VideoPlayer) this.phh).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.pft = false;
        if (this.paZ != null) {
            this.paZ.setVisibility(0);
        }
        if (this.pdR != null) {
            this.pdR.setVisibility(0);
        }
        if (this.peh != null) {
            this.peh.setVisibility(8);
        }
        if (this.phb != null) {
            this.phb.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.pft = false;
        if (this.paZ != null) {
            this.paZ.setVisibility(0);
        }
        if (this.pdR != null) {
            this.pdR.setVisibility(0);
        }
        if (this.peh != null) {
            this.peh.setVisibility(8);
        }
        if (this.phb != null) {
            this.phb.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.peh != null) {
            this.peh.setVisibility(8);
        }
        if (this.pgT != null) {
            this.pgT.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.phg != null) {
                        this.phg.f = null;
                        this.phg.eqU().mRoominfo.mGameId = null;
                    }
                    erM();
                    return;
                }
                tv.chushou.zues.utils.g.RH(a.i.str_getvideosource_failed);
            }
            Av(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.phg != null && this.phg.eqV() != null) {
            a(this.phg.eqV());
        }
        this.p = false;
        if (this.phg == null || this.phg.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.phg.f.size()) {
                if (!"2".equals(this.phg.f.get(i2).mType)) {
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
    public GiftAnimationLayout ero() {
        if (this.pgS == null) {
            return null;
        }
        return (GiftAnimationLayout) this.pgS.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.pew != null) {
            int size = iconConfig.configs.size();
            this.pew.removeAllViews();
            if (this.pey != null) {
                this.pey.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.phh).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.pew, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.cc(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.cc(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.cc(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.pey.setVisibility(0);
                            this.pex.cc(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.cc(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.cc(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.cc(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void dX(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.pew.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void D() {
        if (this.phh instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a eqB = ((VideoPlayer) this.phh).eqB();
            if (this.phY == null) {
                this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.phY.setVisibility(0);
            this.phY.a(2, eqB);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.peA != null && this.phh != null) {
            this.peA.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.peA != null && this.phh != null) {
            this.peA.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(long j) {
        if (this.peA != null) {
            this.peA.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0982a
    public void c(int i) {
        if (this.peA != null) {
            this.peA.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void a(int i) {
        if (this.pez != null) {
            if (this.phh != null) {
                this.pez.a(((VideoPlayer) this.phh).eqB(), false);
            }
            this.pez.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.pgS != null) {
            Point hD = tv.chushou.zues.utils.a.hD(this.phh);
            int i = hD.x > hD.y ? 1 : 2;
            if (this.phY == null) {
                this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.phY.setPlayerViewHelper(this.phg);
            this.phY.setVisibility(0);
            this.phY.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.peB != null) {
            this.peB.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.peB != null) {
            this.peB.a(bangInfo, str);
        }
        if (this.pbn != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.pbn.setText(this.phh.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.pbn.setText(this.phh.getString(a.i.str_contribute_tittle));
            } else {
                this.pbn.setText(Html.fromHtml(this.phh.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.pec != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.pec.setText(this.phh.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.pec.setText(this.phh.getString(a.i.str_contribute_tittle));
            } else {
                this.pec.setText(Html.fromHtml(this.phh.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.peB != null) {
            this.peB.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.phg != null && !h.isEmpty(this.phg.pap)) {
            this.pfz = this.phg.pap.get(0);
            if (this.pfQ != null) {
                this.pfQ.setVisibility(0);
                this.pfQ.a(this.pfz.mCover, 0, 0, 0, 1);
                if (this.pfR != null) {
                    if (this.pfz.mShowClose) {
                        this.pfR.setVisibility(0);
                    } else {
                        this.pfR.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.peB != null) {
            this.peB.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.pgS != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.pbK != null) {
            this.pbK.setPanelEnabled(gVar.f4069a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.pfq) {
            if (iVar.f4071a == 52) {
                if (this.pff != null) {
                    this.pff.a(com.kascend.chushou.b.eqb().c);
                    this.pff.notifyDataSetChanged();
                }
            } else if (iVar.f4071a == 50) {
                if (!this.pfq && (iVar.b instanceof ListItem)) {
                    ListItem listItem = (ListItem) iVar.b;
                    if (!h.isEmpty(listItem.mUrl)) {
                        b(listItem);
                    }
                }
            } else if (iVar.f4071a == 3 && (iVar.b instanceof UserCard.UserCardInfo)) {
                a((UserCard.UserCardInfo) iVar.b);
            }
        }
    }

    private void a(final UserCard.UserCardInfo userCardInfo) {
        RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.peo != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.peo);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.pfq) {
            if (bVar.f4150a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.phh, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4150a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4150a == 6) {
                D();
            } else if (bVar.f4150a == 4) {
                com.kascend.chushou.player.ui.h5.b.b eqC = ((VideoPlayer) this.phh).eqC();
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(2, eqC);
            } else if (bVar.f4150a == 3) {
                com.kascend.chushou.player.ui.h5.d.a eqD = ((VideoPlayer) this.phh).eqD();
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(2, eqD);
            } else if (bVar.f4150a == 8) {
                if (this.pfB != null && this.pfB.getVisibility() != 0) {
                    this.pfB.a(a.C0969a.slide_in_bottom_danmu_anim, a.C0969a.slide_out_bottom_danmu_anim, this.peY == null ? "" : this.peY.mRoomID);
                }
            } else if (bVar.f4150a == 9) {
                if (this.phY == null) {
                    this.phY = (H5Container) ((ViewStub) this.pgS.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.phY.setVisibility(0);
                this.phY.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.phg != null && !h.isEmpty(this.phg.f4117a) && this.phg.f4117a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.pfB != null && this.pfB.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.phh, 80.0f);
                }
                if (this.pfA != null && this.pfA.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pfA.getHeight());
                }
                this.pfL.setTranslationY(-r0);
                return;
            }
            if (this.pfK != null) {
                this.pfK.cancel();
                this.pfK = null;
            }
            int translationY = (int) this.pfL.getTranslationY();
            if (aVar.f4149a != 1 && 2 != aVar.f4149a) {
                if (3 == aVar.f4149a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.phh, 80.0f) : 0;
                    if (this.pfA != null && this.pfA.getVisibility() == 0) {
                        r0 = Math.max(r0, this.pfA.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.pfA.getHeight() : 0;
                    if (this.pfB != null && this.pfB.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.phh, 80.0f));
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
        this.pfK = ValueAnimator.ofInt(i, i2);
        this.pfK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.peB != null) {
                    c.this.pfL.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.pfK.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.pfK = null;
            }
        });
        this.pfK.setInterpolator(new LinearInterpolator());
        this.pfK.setDuration(800L);
        this.pfK.start();
    }

    private boolean bg() {
        if (this.pfw == 1) {
            this.pfw = 2;
            x(true);
            return true;
        } else if (this.pfw == 3) {
            erN();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.pfw == 1) {
            return bi();
        }
        if (this.pfw == 2) {
            this.pfw = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.pfx || this.phg == null || this.phg.eqW() == null) {
            return false;
        }
        if (this.pgs != null) {
            this.pgs.a(true);
        }
        this.pfw = 3;
        this.pfx = true;
        bk();
        this.pdO.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.pfx = false;
                c.this.pdQ.setVisibility(8);
            }
        });
        this.pdQ.startAnimation(loadAnimation);
        this.pdO.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void erN() {
        if (!this.pfx) {
            if (this.pgs != null) {
                this.pgs.a(false);
            }
            this.pfw = 1;
            this.pfx = true;
            bk();
            this.pdQ.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.pfx = false;
                    c.this.pdO.setVisibility(8);
                }
            });
            this.pdQ.startAnimation(loadAnimation);
            this.pdO.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.pgS != null) {
            if (this.pdO == null) {
                this.pdO = this.pgS.findViewById(a.f.user_space_container);
            }
            if (this.pdQ == null) {
                this.pdQ = this.pgS.findViewById(a.f.video_container);
            }
            if (this.pdP == null) {
                this.pdP = com.kascend.chushou.view.user.b.c(null, this.phg.f4117a, false, this.phg.h);
                this.pdP.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.erN();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.erN();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.pdP).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.pdR != null) {
            this.pdR.setVisibility(z ? 8 : 0);
        }
        if (this.peV != null) {
            this.pfx = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.peV.setVisibility(8);
                        c.this.pfx = false;
                    }
                });
            } else {
                this.pfx = true;
                loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.peV.setVisibility(0);
                        c.this.pfx = false;
                    }
                });
            }
            this.peV.startAnimation(loadAnimation);
        }
        erq();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.pei.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.peq != null) {
                this.peq.setVisibility(0);
            }
            if (this.per != null) {
                this.per.a();
                return;
            }
            return;
        }
        if (this.pet != null) {
            this.pet.setVisibility(0);
        }
        if (this.peu != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.peu.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.pet != null) {
            this.pet.setVisibility(8);
        }
        if (this.peu != null) {
            this.peu.clearAnimation();
        }
        if (this.peq != null) {
            this.peq.setVisibility(8);
        }
        if (this.per != null) {
            this.per.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.peV != null && this.pgS != null) {
            if (this.pfB == null) {
                this.pfB = new com.kascend.chushou.player.ui.miniview.a(this.phh, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.pfB != null && c.this.pgS != null && c.this.pfB.a()) {
                            ((ViewGroup) c.this.pgS).removeView(c.this.pfB);
                            c.this.pfB = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pfB.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.phh, 52.0f);
                this.pfB.setLayoutParams(layoutParams);
                ((ViewGroup) this.peV).addView(this.pfB, ((ViewGroup) this.peV).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.pfB.setVisibility(8);
                } else {
                    this.pfB.a(a.C0969a.slide_in_bottom_danmu_anim, a.C0969a.slide_out_bottom_danmu_anim, this.phg.f4117a == null ? "" : this.phg.f4117a);
                }
            } else if (!this.pfB.isShown()) {
                this.pfB.a(a.C0969a.slide_in_bottom_danmu_anim, a.C0969a.slide_out_bottom_danmu_anim, this.phg.f4117a == null ? "" : this.phg.f4117a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.pfH != null && !h.isEmpty(listItem.mPackIcon)) {
                this.pfH.setVisibility(0);
                this.pfH.setAnim(true);
                this.pfH.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.qeZ, b.C1104b.qfb, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.pfj != null && this.pfj.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.erO();
                    }
                });
                this.pfj.setVisibility(0);
                this.pfj.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.pfj != null && this.pfj.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.pfl != null) {
                        c.this.pfl.removeAllListeners();
                        c.this.pfl.cancel();
                        c.this.pfl = null;
                    }
                    if (c.this.pfj != null) {
                        c.this.pfj.setVisibility(8);
                    }
                }
            });
            this.pfj.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.pfO == null) {
                this.pfO = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.phh, "显示双击666_num", null, new Object[0]);
                            if (c.this.phg != null) {
                                c.this.phg.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.phi != null) {
                    this.phi.f(this.pfO, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.pfO != null) {
            this.phi.N(this.pfO);
            this.pfO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.pfm != null && this.pfm.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.phh, a.C0969a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.erP();
                    }
                });
                this.pfm.setVisibility(0);
                this.pfm.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.pgR, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.pfm != null && this.pfm.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.phh, a.C0969a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.pfo != null) {
                        c.this.pfo.removeAllListeners();
                        c.this.pfo.cancel();
                        c.this.pfo = null;
                    }
                    if (c.this.pfm != null) {
                        c.this.pfm.setVisibility(8);
                    }
                }
            });
            this.pfm.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator erO() {
        if (this.pfj == null || this.pfk == null) {
            return null;
        }
        if (this.pfl != null) {
            this.pfl.removeAllListeners();
            this.pfl.cancel();
            this.pfl = null;
        }
        this.pfk.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.pfk, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.pfk, 0.0f);
        int measuredWidth = (this.pfj.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.phh, 13.0f) * 2)) - this.pfk.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.pfk, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.pfk, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.pfk, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.pfl != null) {
                    c.this.pfl.removeAllListeners();
                    c.this.pfl.cancel();
                    c.this.pfl = null;
                }
                RxExecutor.postDelayed(c.this.pgR, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.erO();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pfl = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator erP() {
        if (this.pfm == null || this.pfn == null) {
            return null;
        }
        if (this.pfo != null) {
            this.pfo.removeAllListeners();
            this.pfo.cancel();
            this.pfo = null;
        }
        this.pfn.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.pfn, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.pfn, 0.0f);
        int measuredWidth = (this.pfm.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.phh, 13.0f) * 2)) - this.pfn.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.pfn, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.pfn, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.pfn, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.pfo != null) {
                    c.this.pfo.removeAllListeners();
                    c.this.pfo.cancel();
                    c.this.pfo = null;
                }
                RxExecutor.postDelayed(c.this.pgR, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.erP();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pfo = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.pgs = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.paM != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.paM.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eB = com.kascend.chushou.c.a.eB(jSONObject);
                        if (eB.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.RH(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.RH(a.i.subscribe_success);
                            }
                            if (c.this.paM != null) {
                                c.this.paM.isSubscribe = !z;
                                c.this.erk();
                                return;
                            }
                            return;
                        }
                        a(eB.mRc, eB.mMessage);
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
                com.kascend.chushou.c.c.eqe().a(bVar, (String) null, this.paM.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.paM.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.eqe().b(bVar, (String) null, c.this.paM.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.phg != null && this.peY != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.phg.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.phg.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.peY.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet eB = com.kascend.chushou.c.a.eB(jSONObject);
                        if (eB.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.RH(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.RH(a.i.subscribe_success);
                            }
                            c.this.peY.mIsSubscribed = !z;
                            c.this.erl();
                            return;
                        }
                        a(eB.mRc, eB.mMessage);
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
                com.kascend.chushou.c.c.eqe().a(bVar, (String) null, this.peY.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.peY.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.eqe().b(bVar, (String) null, c.this.peY.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.pdz != null) {
            int width = this.pdz.getWidth();
            int height = this.pdz.getHeight();
            if (this.pfF != width || this.pfG != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void eru() {
        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.pgS != null) {
            if (this.pev == null) {
                this.pev = (InteractionView) ((ViewStub) this.pgS.findViewById(a.f.view_interaction)).inflate();
                this.pev.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.pev.a();
                    }
                });
            }
            if (this.pev != null) {
                this.pev.b(configDetail);
                this.pev.c();
                this.pev.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.eDX()) {
                tv.chushou.zues.utils.g.N(this.phh, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.phh, null) && (this.phh instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.phg != null) {
                com.kascend.chushou.toolkit.a.c.a(this.phh, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.phh, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.phg != null) {
                com.kascend.chushou.toolkit.a.c.a(this.phh, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.phh, configDetail.mUrl, this.phh.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.phh, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.pfs) {
                        ery();
                        return;
                    }
                    if (this.phh.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.phh, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.phg != null && this.phg.eqU() != null && this.phg.eqU().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.phg.eqU().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.pew);
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
        if (this.phh != null && !this.v && !h.isEmpty(str) && this.peY != null && str.equals(this.peY.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.paJ == null) {
                this.paJ = new com.kascend.chushou.player.e.a();
            }
            this.paJ.b = str;
            this.paJ.pdA.copy(pkNotifyInfo);
            if (this.paJ.pdA.mAction == 6) {
                if (this.paF != null) {
                    this.paF.a(true);
                }
                this.paJ.pdA.mInPKMode = true;
                this.u = this.paJ.pdA.mPkId;
            } else if (this.paJ.pdA.mAction == 7 || (this.paJ.pdA.mMode == 1 && this.paJ.pdA.mAction == 5)) {
                if (this.paF != null) {
                    this.paF.a(true);
                }
                this.paJ.pdA.mInPKMode = true;
                if (this.pfD != 42) {
                    this.pfP = ((this.pfE.y - ((this.pfE.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.phh, 158.0f) + this.peR)) - tv.chushou.zues.utils.systemBar.b.aG(getActivity());
                    aX();
                }
                this.u = this.paJ.pdA.mPkId;
                if (this.paK != null) {
                    this.paK.b(this.paJ.pdA, false);
                    this.paK.a(this.paJ.pdA.mMode, (String) null);
                    if (this.paJ.pdA.mAction == 5 && this.paJ.pdA.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.paJ.pdA.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.paJ.pdA.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.paJ.pdA.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.paJ.pdA.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.paJ.pdA.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.paK.a(this.paJ.pdA);
                        this.paK.a(parseInt, this.paJ.pdA.mPkUpdateInfo.remainDuration, j, this.paJ.pdA.mMode, (this.paJ.pdA.destinyInfo == null || this.paJ.pdA.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.paJ.pdA.mPkUpdateInfo != null && !h.isEmpty(this.paJ.pdA.mPkUpdateInfo.specialMomentList) && this.paK != null) {
                    this.paK.a(this.paJ.pdA, true);
                }
                if (this.paJ.pdA.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.paJ.pdA.mInPKMode = false;
                if (this.paJ.pdA.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        erv();
        ert();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.peO != null && this.phg != null && this.phg.paq != null) {
            this.peO.setText(tv.chushou.zues.utils.b.RG(this.phg.paq.count));
            this.peO.setVisibility(0);
            if (this.phg.paq.count < 1) {
                bo();
            }
            if (this.peH != null) {
                this.peH.setText(this.phg.paq.primaryName);
            }
            if (this.peI != null) {
                this.peI.setText(this.phg.paq.desc);
            }
            erg();
        }
    }

    public void erg() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.peP * h.parseLong(this.phg.paq.point)));
        if (this.pcc != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.phh.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.Q(this.phh, a.e.icon_coin_new);
            cVar.append(this.phh.getString(a.i.str_buy_count_coin2));
            this.pcc.setText(cVar);
        }
    }

    private void erQ() {
        if (com.kascend.chushou.d.e.c(this.phh, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.peP);
        }
    }

    private void bo() {
        this.peQ = false;
        this.peN.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.phg != null && this.phg.paq != null) {
            if (this.phg.paq.count < 1) {
                this.peO.setVisibility(8);
            } else {
                this.peO.setVisibility(0);
                this.peO.setSelected(false);
                this.peO.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.peG.setVisibility(8);
        if (this.peo != null) {
            this.peo.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.paO != null) {
            if (z) {
                this.paO.setVisibility(0);
            } else {
                this.paO.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.pgp != null) {
            this.pgp.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.pex != null) {
            this.pex.performClick();
        }
    }
}
