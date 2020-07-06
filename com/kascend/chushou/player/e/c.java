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
/* loaded from: classes5.dex */
public class c extends com.kascend.chushou.player.d implements View.OnClickListener {
    private int bP;
    private int dC;
    private int dD;
    private View nhB;
    public String nhI;
    private TextView nhM;
    private TextView nhP;
    private ImageView nhV;
    private TextView niH;
    private TextView niS;
    private View niV;
    private TextView nif;
    private KPSwitchPanelLinearLayout nin;
    private ImageView nio;
    private tv.chushou.zues.widget.kpswitch.b.c niq;
    private d.a nir;
    private TextView njR;
    private TextView nkA;
    private TextView nkB;
    private TextView nkC;
    private FrescoThumbnailView nkD;
    private TextView nkE;
    private TextView nkF;
    private TextView nkG;
    private TextView nkH;
    private LinearLayout nkI;
    private PlayShowMicStatusView nkJ;
    private RecyclerView nkK;
    private ImageView nkL;
    private PlayShowRecommendView nkM;
    private View nkN;
    private RelativeLayout nkO;
    private AnimationSet nkP;
    private ImageView nkQ;
    private ImageView nkR;
    private RelativeLayout nkS;
    private PastedEditText nkT;
    private ToggleButton nkU;
    private RelativeLayout nkV;
    private PaoPaoView nkW;
    private FrescoThumbnailView nkX;
    private LinearLayout nkY;
    private ImageView nkZ;
    private int nkr;
    private View nks;
    private View nkt;
    private com.kascend.chushou.view.user.b nku;
    private View nkv;
    private FrameLayout nkw;
    private LinearLayout nkx;
    private RelativeLayout nky;
    private FrescoThumbnailView nkz;
    private RecyclerView nlA;
    private RoomInfo nlB;
    private RecyclerView.LayoutManager nlD;
    private ArrayList<ChatInfo> nlE;
    private ArrayList<ChatInfo> nlF;
    private ArrayList<ChatInfo> nlG;
    private ArrayList<ChatInfo> nlH;
    private Button nlL;
    private View nlM;
    private View nlN;
    private Animator nlO;
    private View nlP;
    private View nlQ;
    private Animator nlR;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nlU;
    private PlayShowMicPerson nlY;
    private InteractionView nla;
    private LinearLayout nlb;
    private FrescoThumbnailView nlc;
    private FrameLayout nld;
    private RedpacketNotifier nle;
    private InteractNotifier nlf;
    private EmbeddedButtonLayout nlg;
    private GiftAnimationLayout nlh;
    private com.kascend.chushou.player.b.a nli;
    private f nlj;
    private PlayShowH5View nlk;
    private LinearLayout nll;
    private TextView nlm;
    private TextView nln;
    private TextView nlo;
    private TextView nlp;
    private TextView nlq;
    private TextView nlr;
    private ImageView nls;
    private TextView nlt;
    private PopupWindow nlw;
    private View nly;
    private RelativeLayout nmA;
    private FrescoThumbnailView nmB;
    private TextView nmC;
    private TextView nmD;
    private ImageView nmE;
    private RelativeLayout nmF;
    private LinearLayout nmG;
    private TextView nmH;
    private TextView nmI;
    private RelativeLayout nmJ;
    private RelativeLayout nmK;
    private FrescoThumbnailView nmL;
    private TextView nmM;
    private TextView nmN;
    private ImageView nmO;
    private RelativeLayout nmP;
    private TextView nmR;
    private float nmS;
    private float nmT;
    private a nmU;
    private FoodView nmc;
    public ListItem nmd;
    private FoodView nme;
    private com.kascend.chushou.player.ui.miniview.a nmf;
    private int nmg;
    private Point nmh;
    private FrescoThumbnailView nmk;
    private FrescoThumbnailView nml;
    private ValueAnimator nmm;
    private LinearLayout nmn;
    private long nmo;
    private VideoShowVoteView nmp;
    private Runnable nmq;
    private FrescoThumbnailView nms;
    private ImageView nmt;
    private RelativeLayout nmu;
    private TextView nmv;
    private ImageView nmw;
    private EditText nmx;
    private View nmy;
    private RelativeLayout nmz;
    private boolean nip = false;
    private int nlu = 1;
    private boolean cO = false;
    private int nlv = 0;
    private int cQ = 0;
    private int nlx = -1;
    private boolean nlz = false;
    private FullRoomInfo nlC = null;
    private com.kascend.chushou.player.adapter.a nlI = null;
    private ArrayList<String> nlJ = null;
    private boolean nlK = true;
    private boolean nlS = true;
    private boolean nlT = false;
    public final List<OnlineVipItem> nlV = new ArrayList();
    private boolean nlW = false;
    private boolean nlX = false;
    private long nlZ = 0;
    private int nma = 1;
    private boolean nmb = false;
    private int nmi = -1;
    private int nmj = -1;
    private boolean dJ = false;
    private int nmr = -1;
    private io.reactivex.disposables.b nmQ = null;

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
        this.nhI = getArguments().getString("cover");
        this.nlS = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.nnt = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.nnt;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            aK();
            this.nke = ((VideoPlayer) this.nnJ).dJc();
            this.nnI = ((VideoPlayer) this.nnJ).dJf();
            dt(view);
            dKf();
            if (this.nnJ instanceof VideoPlayer) {
                ((VideoPlayer) this.nnJ).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nlT = false;
        if (this.non != null) {
            this.non.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nlT = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nlO != null) {
            this.nlO.removeAllListeners();
            this.nlO.cancel();
            this.nlO = null;
        }
        if (this.nlR != null) {
            this.nlR.removeAllListeners();
            this.nlR.cancel();
            this.nlR = null;
        }
        if (this.nlf != null) {
            this.nlf.c();
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
        if (this.nmQ != null) {
            this.nmQ.dispose();
            this.nmQ = null;
        }
        this.nlu = 1;
        this.cO = false;
        if (this.nnK != null) {
            this.nnK.ch(null);
        }
        if (this.nlw != null) {
            this.nlw.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nnJ, this.niq);
        if (this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnJ).dJj();
        }
        this.nir = null;
        this.niq = null;
        aI();
        if (this.nli != null) {
            this.nli.a();
        }
        if (this.nkW != null) {
            this.nkW.b();
            this.nkW.c();
            this.nkW = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.ci(this);
        if (this.nlG != null) {
            this.nlG.clear();
        }
        if (this.nlE != null) {
            this.nlE.clear();
        }
        if (this.nlH != null) {
            this.nlH.clear();
        }
        if (this.nlF != null) {
            this.nlF.clear();
        }
        if (this.nlJ != null) {
            this.nlJ.clear();
        }
        if (this.nlI != null) {
            this.nlI.a(0);
            this.nlI.a();
        }
    }

    private void dt(View view) {
        this.nks = view.findViewById(a.f.fl_root);
        this.nmh = tv.chushou.zues.utils.a.gx(this.nnJ);
        this.nlv = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnJ);
        this.cQ = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        this.dD = 86;
        this.nnI = ((VideoPlayer) this.nnJ).dJf();
        if (this.nnI != null) {
            this.nlB = this.nnI.dJI();
            this.nlC = this.nnI.dJF();
        }
        this.nlE = new ArrayList<>();
        this.nlG = new ArrayList<>();
        this.nlF = new ArrayList<>();
        this.nkw = (FrameLayout) this.nnt.findViewById(a.f.fl_effect);
        b();
        this.nnD = (PlayerErrorView) this.nnt.findViewById(a.f.view_net_error_msg);
        this.nnD.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.nkV = (RelativeLayout) this.nnt.findViewById(a.f.rl_audio_ani);
        this.nkW = (PaoPaoView) this.nnt.findViewById(a.f.audio_ani);
        this.nkX = (FrescoThumbnailView) this.nnt.findViewById(a.f.audio_ani_avatar);
        this.nkY = (LinearLayout) this.nnt.findViewById(a.f.ll_audio);
        this.njR = (TextView) this.nnt.findViewById(a.f.tv_open_video);
        this.nkZ = (ImageView) this.nnt.findViewById(a.f.iv_audio_ani);
        this.nml = (FrescoThumbnailView) this.nnt.findViewById(a.f.live_cover);
        if (!this.dJ || this.nke == null || this.nke.getPlayState() != 4) {
            this.nml.setVisibility(0);
            this.nml.setBlur(true);
            this.nml.i(this.nhI, 0, 0, 0);
        }
        this.njR.setOnClickListener(this);
        this.nhm = new b();
        this.nhm.a(view, null, this.nnJ, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dWn()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.nnI != null) {
                    append.append(c.this.nnI.dJI().mRoomID);
                }
                if (c.this.nhl != null && c.this.nhl.nkf != null) {
                    append.append("&mode=").append(c.this.nhl.nkf.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nnJ, append.toString());
            }
        });
        this.nhq = (VoiceInteractionView) this.nnt.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.nnI != null) {
            this.nlB = this.nnI.dJI();
            this.nlC = this.nnI.dJF();
        }
        dJV();
        dJU();
        dJZ();
        this.nmn = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nmc = (FoodView) view.findViewById(a.f.rav_ad);
        this.nms = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nmt = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nms.setOnClickListener(this);
        this.nmt.setOnClickListener(this);
        this.nmu = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nmk = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nmk.setOnClickListener(this);
        this.nlf = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.nle = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nlL = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nlL.setOnClickListener(this);
        this.nlA = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nlA.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nlA.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nmh.x, this.nmh.y) * 0.83d);
        this.nlA.setLayoutParams(layoutParams);
        this.nlD = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nnJ);
        this.nlA.setLayoutManager(this.nlD);
        this.nlA.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nlA.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nlA.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.nlK = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nlI = new com.kascend.chushou.player.adapter.a(this.nnJ, this.nlE);
        if (this.nlB != null) {
            this.nlI.a(this.nlB);
        }
        if (com.kascend.chushou.b.dIM().c != null) {
            this.nlI.a(com.kascend.chushou.b.dIM().c);
        }
        this.nlA.setAdapter(this.nlI);
        this.nlI.a(this.nlE.size());
        this.nlI.notifyDataSetChanged();
        if (this.nnI != null && (c = this.nnI.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.nli != null) {
            this.nli.a();
            this.nli = null;
        }
        this.nlh = (GiftAnimationLayout) this.nnt.findViewById(a.f.ll_gift_animation);
        this.nlh.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.nkr = ((int) (tv.chushou.zues.utils.a.gw(this.nnJ).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nnJ, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nlh.getLayoutParams();
        layoutParams2.bottomMargin = this.nkr;
        this.nlh.setLayoutParams(layoutParams2);
        if (this.nnI != null) {
            this.nli = new com.kascend.chushou.player.b.a(this.nnJ.getApplicationContext(), this.nlh);
            this.nli.a(this.nnI);
            a(this.nnI.ngR, this.nnI.ngU);
        }
        this.nnt.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.nlg = (EmbeddedButtonLayout) this.nnt.findViewById(a.f.embedded_button_layout);
        this.nlg.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nmp = (VideoShowVoteView) this.nnt.findViewById(a.f.view_video_show_vote);
        this.nmp.setOnClickListener(this);
        this.nmp.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dKm();
            }
        });
        if (this.nnI != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
            this.nlg.a(videoPlayer.dJp().dKJ());
            this.nlg.b(this.nnI.dJH());
            this.nle.a(videoPlayer.dJl(), false);
            this.nlf.a(videoPlayer.dJm(), videoPlayer.dJn(), videoPlayer.dJo());
            this.nhl = new com.kascend.chushou.player.e.a();
        }
        this.noz = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nlW = false;
                c.this.b(c.this.nkr, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nlW = true;
                if (c.this.non != null) {
                    c.this.non.measure(0, 0);
                    int measuredHeight = c.this.non.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nnJ, 14.0f);
                    if (measuredHeight > c.this.nkr) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.nor = (PaoGuideView) this.nnt.findViewById(a.f.rlPaoGuideView);
        this.nlY = (PlayShowMicPerson) this.nnt.findViewById(a.f.rl_mic_person_view);
        this.nlk = (PlayShowH5View) this.nnt.findViewById(a.f.rl_playshowh5);
        this.nme = (FoodView) this.nnt.findViewById(a.f.bottom_ad);
        if (this.nnI != null) {
            H();
            if (this.nnI.ngL != null && !h.isEmpty(this.nnI.ngL.mUrl)) {
                b(this.nnI.ngL);
            }
        }
        this.nlM = this.nnt.findViewById(a.f.view_reminder_subscribe);
        this.nlN = this.nlM.findViewById(a.f.spash_subscribe);
        ((TextView) this.nlM.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.nnJ, a.e.videoplayer_reminder_subscribe).append(" ").append(this.nnJ.getString(a.i.videoplayer_reminder_subscribe)));
        this.nlM.setOnClickListener(this);
        this.nlP = this.nnt.findViewById(a.f.view_reminder_danmaku);
        this.nlQ = this.nlP.findViewById(a.f.spash_danmaku);
        ((TextView) this.nlP.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.nnJ, a.e.videoplayer_reminder_danmaku).append(" ").append(this.nnJ.getString(a.i.videoplayer_reminder_danmaku)));
        this.nlP.setOnClickListener(this);
    }

    private void dJU() {
        this.nmz = (RelativeLayout) this.nnt.findViewById(a.f.rl_cyclelive);
        this.nmA = (RelativeLayout) this.nnt.findViewById(a.f.rlrl_cyclelive);
        this.nmB = (FrescoThumbnailView) this.nnt.findViewById(a.f.iv_liveicon);
        this.nmC = (TextView) this.nnt.findViewById(a.f.tv_livename);
        this.nmD = (TextView) this.nnt.findViewById(a.f.tv_livedesc);
        this.nmE = (ImageView) this.nnt.findViewById(a.f.iv_cyclelive_name_menu);
        this.nmF = (RelativeLayout) this.nnt.findViewById(a.f.rl_normal);
        this.nmG = (LinearLayout) this.nnt.findViewById(a.f.ll_cyclelive_nickname);
        this.nmH = (TextView) this.nnt.findViewById(a.f.tv_cyclelive_nickname);
        this.nmI = (TextView) this.nnt.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nmJ = (RelativeLayout) this.nnt.findViewById(a.f.rl_clear_cyclelive);
        this.nmK = (RelativeLayout) this.nnt.findViewById(a.f.rlrl_clear_cyclelive);
        this.nmL = (FrescoThumbnailView) this.nnt.findViewById(a.f.iv_clear_liveicon);
        this.nmM = (TextView) this.nnt.findViewById(a.f.tv_clear_livename);
        this.nmN = (TextView) this.nnt.findViewById(a.f.tv_clear_livedesc);
        this.nmO = (ImageView) this.nnt.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nmP = (RelativeLayout) this.nnt.findViewById(a.f.rl_clear_normal);
        this.nmO.setOnClickListener(this);
        this.nmE.setOnClickListener(this);
        this.nmI.setOnClickListener(this);
        this.nmH.setOnClickListener(this);
        this.nmB.setOnClickListener(this);
        this.nmL.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nnI.ngJ != null && this.nme != null) {
            this.nme.a(true, this.nnI.a == null ? "" : this.nnI.a);
            this.nme.a(this.nnI.ngJ, a.C0815a.slide_in_bottom_danmu_anim, a.C0815a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nnI != null && this.nnI.ngQ != null && this.nlg != null) {
            this.nmc.a(this.nnI.ngQ, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.nnI != null) {
                        c.this.nnI.ngQ = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dKn() {
        return this.nli;
    }

    private void aK() {
        this.nnK = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.nnt != null && (textView = (TextView) c.this.nnt.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nnJ.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nnK.B(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nnK);
                        break;
                    case 12:
                        c.this.b(c.this.nnK);
                        break;
                    case 17:
                        c.this.as();
                        break;
                    case 18:
                        c.this.dxC();
                        break;
                    case 19:
                        c.this.nnH.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nlz) {
            this.nlz = true;
            if (this.nly == null) {
                this.nly = this.nnt.findViewById(a.f.vs_async_show_content);
                this.nly = ((ViewStub) this.nly).inflate();
            }
            this.nhB = this.nnt.findViewById(a.f.ui_content);
            if (this.niV == null) {
                this.niV = this.nnt.findViewById(a.f.vs_async_notification_view);
                this.niV = ((ViewStub) this.niV).inflate();
            }
            c(this.nnt);
            k();
            ar();
            if (this.c == null) {
                this.nhf = new d.a();
                this.c = new GestureDetector(this.nnJ, this.nhf);
            }
            ((VideoPlayer) this.nnJ).q();
        }
    }

    private void dJV() {
        this.nkx = (LinearLayout) this.nnt.findViewById(a.f.ll_anchor);
        this.nky = (RelativeLayout) this.nnt.findViewById(a.f.ll_clear_anchor);
        this.nkx.setVisibility(4);
        this.nky.setVisibility(4);
        this.nkz = (FrescoThumbnailView) this.nnt.findViewById(a.f.iv_clear_avatar);
        this.nkA = (TextView) this.nnt.findViewById(a.f.tv_clear_nickname);
        this.nkB = (TextView) this.nnt.findViewById(a.f.tv_clear_online_count);
        this.nkC = (TextView) this.nnt.findViewById(a.f.tv_clear_btn_subscribe);
        this.nkC.setOnClickListener(this);
        this.nkD = (FrescoThumbnailView) this.nnt.findViewById(a.f.iv_avatar);
        this.nkE = (TextView) this.nnt.findViewById(a.f.tv_nickname_test);
        this.nkF = (TextView) this.nnt.findViewById(a.f.tv_online_count);
        this.nhM = (TextView) this.nnt.findViewById(a.f.tv_btn_subscribe);
        this.nhM.setOnClickListener(this);
        this.nkG = (TextView) this.nnt.findViewById(a.f.tv_loyal_counts);
        this.nhP = (TextView) this.nnt.findViewById(a.f.tv_btn_contribution);
        this.nkH = (TextView) this.nnt.findViewById(a.f.tv_btn_contribution_forpk);
        this.nhP.setVisibility(4);
        this.nkH.setVisibility(8);
        this.nkI = (LinearLayout) this.nnt.findViewById(a.f.ll_mic);
        this.nkJ = (PlayShowMicStatusView) this.nnt.findViewById(a.f.show_mic_status);
        this.nkK = (RecyclerView) this.nnt.findViewById(a.f.rv_loyal);
        this.nkL = (ImageView) this.nnt.findViewById(a.f.iv_clear_close);
        this.nhV = (ImageView) this.nnt.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.nkK.setLayoutManager(linearLayoutManager);
        this.nlU = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.nlV, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.nlV.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nnJ, (JSONObject) null, c.this.nnI.dJI().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0941a view$OnLongClickListenerC0941a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0941a view$OnLongClickListenerC0941a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0941a.or(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0941a.or(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0941a.or(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dWz(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nnJ, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnJ, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnJ, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnJ, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnJ, a.c.color_979797), dip2px);
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
        this.nkK.setAdapter(this.nlU);
        this.nkI.setOnClickListener(this);
        this.nkz.setOnClickListener(this);
        this.nkL.setOnClickListener(this);
        this.nkD.setOnClickListener(this);
        this.nkz.setOnClickListener(this);
        this.nhV.setOnClickListener(this);
        this.nkG.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void ds(View view) {
                String str = tv.chushou.common.a.dWn() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.nnI != null) {
                    str = str + c.this.nnI.dJI().mRoomID;
                }
                c.this.f(c.this.nnJ.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nhP.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void ds(View view) {
                String str = tv.chushou.common.a.dWn() + "m/room-billboard/";
                if (c.this.nnI != null) {
                    str = str + c.this.nnI.dJI().mRoomID;
                }
                c.this.f(c.this.nnJ.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.nkH.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void ds(View view) {
                String str = tv.chushou.common.a.dWn() + "m/room-billboard/";
                if (c.this.nnI != null) {
                    str = str + c.this.nnI.dJI().mRoomID;
                }
                c.this.f(c.this.nnJ.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nlC == null || this.nlC.cycleLiveRoomInfo == null || h.isEmpty(this.nlC.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nho = this.nlC.cycleLiveRoomInfo;
        }
        if (z2 && this.nho != null) {
            this.nmz.setVisibility(0);
            this.nmJ.setVisibility(0);
            this.nmF.setVisibility(8);
            this.nmP.setVisibility(8);
            this.nmG.setVisibility(0);
            this.nmL.h(this.nho.eventIcon, com.kascend.chushou.view.a.a(this.nlB.mCreatorGender), b.a.small, b.a.small);
            this.nmB.h(this.nho.eventIcon, com.kascend.chushou.view.a.a(this.nlB.mCreatorGender), b.a.small, b.a.small);
            this.nmM.setText(this.nho.eventName);
            this.nmN.setText(this.nho.eventDesc);
            this.nmC.setText(this.nho.eventName);
            this.nmD.setText(this.nho.eventDesc);
            this.nmH.setText(this.nho.nickname);
            aN();
            if (z) {
                c(this.nho.remainTime);
                return;
            }
            return;
        }
        this.nmz.setVisibility(8);
        this.nmJ.setVisibility(8);
        this.nmF.setVisibility(0);
        this.nmP.setVisibility(0);
        this.nmG.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nmQ != null) {
            this.nmQ.dispose();
            this.nmQ = null;
        }
        this.nmQ = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dPw()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nnJ != null && (c.this.nnJ instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nnJ).u();
                }
            }
        });
    }

    private void dJW() {
        if (this.nlB != null && this.nlz) {
            this.nkx.setVisibility(0);
            this.nky.setVisibility(0);
            this.nhP.setVisibility(0);
            this.nkz.h(this.nlB.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nlB.mCreatorGender), b.a.small, b.a.small);
            this.nkA.setText(this.nlB.mCreatorNickname);
            this.nkD.h(this.nlB.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nlB.mCreatorGender), b.a.small, b.a.small);
            this.nkE.setText(this.nlB.mCreatorNickname);
            dKv();
            dJX();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dKv() {
        if (this.nlB != null) {
            this.nkB.setText(tv.chushou.zues.utils.b.formatNumber(this.nlB.mOnlineCount));
            this.nkF.setText(tv.chushou.zues.utils.b.formatNumber(this.nlB.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.nho != null) {
            if (this.nho.isSubscribe) {
                this.nmI.setText(a.i.like_already);
                this.nmI.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nmI.setText(getString(a.i.like));
            this.nmI.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJX() {
        if (this.nlB != null) {
            if (this.nlB.mIsSubscribed) {
                this.nkC.setText(getString(a.i.like_already));
                this.nkC.setBackgroundResource(a.e.bg_show_subcribe);
                this.nhM.setText(getString(a.i.like_already));
                this.nhM.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nkC.setText(getString(a.i.like));
            this.nkC.setBackgroundResource(a.e.bg_show_subcribe);
            this.nhM.setText(getString(a.i.like));
            this.nhM.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dJY() {
        if (this.nlU != null) {
            this.nlU.notifyDataSetChanged();
        }
    }

    private void dJZ() {
        this.nkN = this.nnt.findViewById(a.f.tv_interact);
        this.nkN.setOnClickListener(this);
        this.nkS = (RelativeLayout) this.nnt.findViewById(a.f.rl_edit_bar);
        this.nkQ = (ImageView) this.nnt.findViewById(a.f.btn_hotword);
        this.nkQ.setOnClickListener(this);
        this.nkR = (ImageView) this.nnt.findViewById(a.f.iv_task_badge);
        this.nkP = (AnimationSet) AnimationUtils.loadAnimation(this.nnJ, a.C0815a.anim_hotword);
        this.nkP.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dIT().c) {
                    c.this.nkQ.clearAnimation();
                    c.this.nkQ.startAnimation(c.this.nkP);
                }
            }
        });
        if (com.kascend.chushou.d.h.dIT().c) {
            this.nkQ.startAnimation(this.nkP);
            this.nkR.setVisibility(0);
        }
        this.nmR = (TextView) this.nnt.findViewById(a.f.tv_bottom_input);
        this.nmR.setOnClickListener(this);
        this.noJ = (FrescoThumbnailView) this.nnt.findViewById(a.f.ll_btn_set);
        this.noJ.setOnClickListener(this);
        this.noJ.zs(a.e.ic_room_set_btn_white);
        this.nlb = (LinearLayout) this.nnt.findViewById(a.f.ll_bottom_all_button);
        this.nlc = (FrescoThumbnailView) this.nnt.findViewById(a.f.fl_clear_bottom_gift);
        this.nlc.setAnim(true);
        this.nlc.setOnClickListener(this);
        this.nlc.zs(a.e.ic_show_gift_n);
        this.nld = (FrameLayout) this.nnt.findViewById(a.f.flfl_clear_bottom_gift);
        this.nld.setVisibility(8);
        this.nkO = (RelativeLayout) this.nnt.findViewById(a.f.rl_bottom_input);
        this.nkO.setVisibility(0);
        this.nkT = (PastedEditText) this.nnt.findViewById(a.f.et_bottom_input);
        this.nkT.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nif.setEnabled(editable.length() > 0);
            }
        });
        this.nkT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nif);
                    return true;
                }
                return true;
            }
        });
        this.nkT.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.nkT);
                }
                return false;
            }
        });
        this.nio = (ImageView) this.nnt.findViewById(a.f.iv_btn_emoji);
        this.nio.setVisibility(8);
        this.nif = (TextView) this.nnt.findViewById(a.f.tv_btn_send);
        this.nif.setOnClickListener(this);
        this.nll = (LinearLayout) this.nnt.findViewById(a.f.head_trumpet);
        this.nll.setVisibility(8);
        this.nll.setOnClickListener(this);
        this.nlm = (TextView) this.nnt.findViewById(a.f.tv_primary_name);
        this.nln = (TextView) this.nnt.findViewById(a.f.tv_primary_desc);
        this.nlp = (TextView) this.nnt.findViewById(a.f.tv_cut_count);
        this.nlp.setOnClickListener(this);
        this.nlr = (TextView) this.nnt.findViewById(a.f.tv_head_count);
        this.nlr.setText(this.nlu + "");
        this.nlq = (TextView) this.nnt.findViewById(a.f.tv_plus_count);
        this.nlq.setOnClickListener(this);
        this.niH = (TextView) this.nnt.findViewById(a.f.tv_buy_count_coin);
        this.nlo = (TextView) this.nnt.findViewById(a.f.tv_buy_head);
        this.nlo.setOnClickListener(this);
        this.nls = (ImageView) this.nnt.findViewById(a.f.iv_trumpet_select);
        this.nls.setOnClickListener(this);
        this.nlt = (TextView) this.nnt.findViewById(a.f.tv_trumpet_have_count);
        this.cO = false;
        this.nls.setBackgroundResource(a.e.ic_trumpet_n);
        this.nlt.setVisibility(8);
        this.nin = (KPSwitchPanelLinearLayout) this.nnt.findViewById(a.f.chat_extended_container);
        dKd();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nin, this.nio, this.nkT, new a.InterfaceC0945a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0945a
            public void wX(boolean z) {
                if (c.this.nio != null) {
                    if (z) {
                        c.this.nin.setDirectVisibility(0);
                        c.this.nio.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nio.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nir = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wY(boolean z) {
                c.this.nip = z;
                if (z) {
                    c.this.nio.setImageResource(a.e.cs_emoji_normal);
                    c.this.dKb();
                    if (c.this.nmy != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nmy.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gJ(c.this.nnJ);
                        c.this.nmy.setLayoutParams(layoutParams);
                    }
                    if (c.this.nkS != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.nkS.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gJ(c.this.nnJ);
                        c.this.nkS.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nmy != null && c.this.nmy.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nmy.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nmy.setLayoutParams(layoutParams3);
                    c.this.nmy.setVisibility(8);
                }
                if (c.this.nlW) {
                    c.this.non.setVisibility(0);
                }
                if (c.this.nnJ != null && (c.this.nnJ instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nnJ).wW(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.nkS != null && c.this.nin.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.nkS.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.nkS.setLayoutParams(layoutParams4);
                }
            }
        };
        this.niq = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nin, this.nir, ((VideoPlayer) this.nnJ).dJk());
        ((VideoPlayer) this.nnJ).h(((VideoPlayer) this.nnJ).dJk());
        this.nmy = this.nnt.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nmv = (TextView) this.nnt.findViewById(a.f.btn_room_search);
        this.nmw = (ImageView) this.nnt.findViewById(a.f.iv_room_emoji_delete);
        this.nmx = (EditText) this.nnt.findViewById(a.f.et_room_emoji_search);
        this.nmx.setImeOptions(3);
        this.nmx.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nmv);
                    return true;
                }
                return false;
            }
        });
        this.nmx.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nmv.setEnabled(editable.length() > 0);
                c.this.nmw.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.non.setEmojiSearchText(editable.toString());
            }
        });
        this.nmv.setOnClickListener(this);
        this.nmw.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void au(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dE(this.nmx);
            this.nmy.setVisibility(0);
            this.nmx.requestFocus();
        } else {
            this.nmy.setVisibility(8);
        }
        if (z2) {
            this.nmx.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKb() {
        int gJ = tv.chushou.zues.widget.kpswitch.b.d.gJ(this.nnJ) + tv.chushou.zues.utils.a.dip2px(this.nnJ, 14.0f);
        if (gJ > this.nkr) {
            b(gJ, 12);
        }
    }

    private void dKd() {
    }

    private void dKf() {
        if (this.cQ > 0) {
            View findViewById = this.nnt.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.cQ);
        }
        if (this.nlv > 0) {
            View findViewById2 = this.nnt.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nlv, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nlS) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dKj();
        a();
        this.nhh = ((VideoPlayer) this.nnJ).dJg();
        this.nhh.a(this);
        if (this.nnI.dJF() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.nhh != null) {
            this.nhh.d();
        }
    }

    private void aU() {
        if ((this.nhl == null || this.nhl.nkf == null || !this.nhl.nkf.mInPKMode) ? false : true) {
            if (this.nks != null) {
                this.nks.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nhn.getLayoutParams();
            layoutParams.leftMargin = (this.nmh.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nnJ, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.nhn.setLayoutParams(layoutParams);
            this.y.setText(this.nhl.nkf.mPkUserNickname);
            this.nhn.setVisibility(0);
            this.nkI.setVisibility(8);
            return;
        }
        if (this.nks != null) {
            this.nks.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.nhn.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.nhl != null && this.nhl.nkf != null && this.nhl.nkf.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nmr > 0 && this.nlA != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nlA.getLayoutParams();
                if (layoutParams.height != this.nmr) {
                    layoutParams.height = this.nmr;
                    this.nlA.setLayoutParams(layoutParams);
                }
            }
            this.nkr = ((int) (tv.chushou.zues.utils.a.gw(this.nnJ).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nnJ, 84.0f);
            b(this.nkr, 12);
        } else {
            if (this.nlA != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nlA.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nnJ, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nnJ, 250.0f);
                    this.nlA.setLayoutParams(layoutParams2);
                }
            }
            this.nkr = ((int) (tv.chushou.zues.utils.a.gw(this.nnJ).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nnJ, 84.0f);
            b(this.nkr, 12);
        }
        if (this.nhm != null) {
            this.nhm.a(this.nmr + tv.chushou.zues.utils.a.dip2px(this.nnJ, 52.0f), this.aq);
        }
        if (this.nhq != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nhq.getLayoutParams();
            layoutParams3.bottomMargin = this.nmr + tv.chushou.zues.utils.a.dip2px(this.nnJ, 52.0f);
            this.nhq.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dKi();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dKi();
    }

    private void dKh() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKi() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dKE().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.nmh = tv.chushou.zues.utils.a.gx(this.nnJ);
        this.dD = 86;
        this.nmg = (Math.max(this.nmh.x, this.nmh.y) - tv.chushou.zues.utils.a.dip2px(this.nnJ, (this.dD + 52) + 250)) - this.nlv;
        this.dC = Math.max(this.nmh.x, this.nmh.y) - ((tv.chushou.zues.utils.a.dip2px(this.nnJ, this.dD) + this.nlv) * 2);
        if (this.nmi <= 0 || this.nmj <= 0) {
            this.nmi = Math.min(this.nmh.x, this.nmh.y);
            this.nmj = Math.max(this.nmh.x, this.nmh.y);
        }
        this.ar = Math.min(this.nmh.x, this.nmh.y);
        this.aq = (this.ar * this.nmj) / this.nmi;
        boolean z = false;
        if (this.nhl == null || this.nhl.nkf == null) {
            i = 1;
        } else {
            i = this.nhl.nkf.mMode;
            if (this.nhl.nkf.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.dD = 42;
            if (i == 2) {
                if (this.nmj < this.nmi) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nmi * layoutParams.height) / this.nmj;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, this.dD) + this.nlv;
            layoutParams.gravity = 48;
            this.nmr = ((this.nmh.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nnJ, (this.dD + 52) + 64) + this.nlv)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            dJS();
        } else if (this.E) {
            this.dD = 42;
            if (this.nmj < this.nmi) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nmi * layoutParams.height) / this.nmj;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, this.dD) + this.nlv;
            layoutParams.gravity = 48;
            this.nmr = ((this.nmh.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nnJ, (this.dD + 52) + 98) + this.nlv)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            dKh();
        } else {
            this.nmr = -1;
            this.dD = 86;
            if (this.aq <= this.nmg) {
                layoutParams.width = this.ar;
                layoutParams.height = this.nmg;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, this.dD) + this.nlv;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.dC) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, this.dD) + this.nlv;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nmh.x, this.nmh.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nmi) / this.nmj >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nmi) / this.nmj;
                    } else if ((this.ar * this.nmj) / this.nmi >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nmj) / this.nmi;
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
                    if ((this.ar * this.nmj) / this.nmi > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nmi) / this.nmj;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nmj) / this.nmi;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nmj) / this.nmi;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nmi) / this.nmj;
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
        if (this.nnI != null && this.nnI.d) {
            layoutParams.width = Math.min(this.nmh.x, this.nmh.y);
            layoutParams.height = Math.max(this.nmh.x, this.nmh.y);
        }
        dKE().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dKj() {
        this.N = new SurfaceRenderView(this.nnJ);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dKE().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nmb) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dKy();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dKx();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nmU != null) {
            this.nmU.a();
        }
        if (this.nnI != null && !h.isEmpty(this.nnI.w)) {
            b(this.nnI.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nke != null) {
            int width = this.nke.getWidth();
            int height = this.nke.getHeight();
            if (this.nmi != width || this.nmj != height || this.nmi <= 0 || this.nmj <= 0) {
                this.nmi = width;
                this.nmj = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dKi();
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
            if (this.nlW) {
                dKl();
            } else {
                if (this.nnJ.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击送礼_num", "竖屏", new Object[0]);
                if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnI.dJF().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.cO) {
                f(this.nkT.getText().toString());
            } else {
                a(this.nkT.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dIT().c) {
                com.kascend.chushou.d.h.dIT().b(false);
                this.nkP.cancel();
                this.nkP.reset();
                this.nkQ.clearAnimation();
                this.nkR.setVisibility(8);
            }
            m(view, 0, this.nnt.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nnJ, 165.0f) / 2);
            l(view, x >= 0 ? x : 0, this.nnt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.nnI.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.nnI.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nlA != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nlB != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nma = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nnJ, (JSONObject) null, this.nnI.dJI().mRoomID, this.nnI.dJI().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.nnJ.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nnJ, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nmd != null) {
                    com.kascend.chushou.d.e.a(this.nnJ, this.nmd, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nmu != null) {
                    this.nmu.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nnJ, null) && this.nnI != null && this.nnI.ngT != null) {
                    if (this.cO) {
                        dKC();
                    } else {
                        if (this.nnI != null && this.nnI.ngT != null && this.nnI.ngT.count > 0) {
                            this.nll.setVisibility(8);
                        } else {
                            this.nll.setVisibility(0);
                        }
                        this.cO = true;
                        this.nls.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nlt.setVisibility(0);
                        this.nlt.setSelected(true);
                        this.nlt.setTextColor(Color.parseColor("#ff5959"));
                        if (this.nkT != null) {
                            this.nkT.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nlu <= 9) {
                    this.nlu++;
                    this.nlr.setText(this.nlu + "");
                }
                dJT();
            } else if (id == a.f.tv_cut_count) {
                if (this.nlu > 1) {
                    this.nlu--;
                    this.nlr.setText(this.nlu + "");
                }
                dJT();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nmx.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nmx.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nmy.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dF(this.nmx);
                    this.non.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nho != null && !h.isEmpty(this.nho.eventUrl)) {
                    f("", this.nho.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nho != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nho != null) {
                    com.kascend.chushou.d.a.a(this.nnJ, (JSONObject) null, this.nho.roomId, this.nho.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.nnI.a(false);
                    ((VideoPlayer) this.nnJ).l();
                } else {
                    ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKm() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.nlk != null) {
            int i = (tv.chushou.zues.utils.a.gw(this.nnJ).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nlk.getLayoutParams();
            layoutParams.topMargin = i;
            this.nlk.setLayoutParams(layoutParams);
            this.nlk.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.nlk.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.LI(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.nlZ <= 3000) {
            tv.chushou.zues.utils.g.LI(a.i.str_too_fast);
            return false;
        } else {
            dxH();
            if (!com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a(((VideoPlayer) this.nnJ).dJf().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nlZ = System.currentTimeMillis();
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                a(this.nnI.dJF().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nnI.h);
            }
            g(this.b);
            if (!z && this.nkT != null) {
                this.nkT.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dxH();
            if (com.kascend.chushou.d.e.c(this.nnJ, null) && LoginManager.Instance().getUserInfo() != null && this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                a(this.nnI.dJF().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nkT != null) {
                this.nkT.setText((CharSequence) null);
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
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.nnI.dJF().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nnI.dJF().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nnJ).nfj;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Tf(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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

    private void l(View view, int i, int i2) {
        if (this.noi != null && this.noi.isShowing()) {
            this.noi.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
        if (this.noG == null) {
            i(3);
        }
        this.noG.getContentView().setBackgroundResource(0);
        this.noG.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.noG.isShowing()) {
            this.noG.showAtLocation(view, 83, i, i2);
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nnI.dJF().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.noG.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dKe() {
        if (h.isEmpty(this.noK)) {
            if (((VideoPlayer) this.nnJ).q) {
                this.noJ.zs(a.e.ic_room_set_btn_white);
            } else {
                this.noJ.zs(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nnJ).q && this.noK.size() == 2 && this.noK.contains("4") && this.noK.contains("2")) {
            this.noJ.zs(a.e.ic_room_set_btn_system_white);
        } else if (this.noK.size() > 1 || !((VideoPlayer) this.nnJ).q) {
            this.noJ.zs(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.noK.get(0))) {
            this.noJ.zs(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.noK.get(0))) {
            this.noJ.zs(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.noK.get(0))) {
            this.noJ.zs(a.e.ic_room_set_btn_system_white);
        }
    }

    private void m(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
        if (this.noi == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.noi.getContentView().setBackgroundResource(0);
            this.noi.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.noi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nkQ.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.noi.isShowing()) {
            this.noi.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nnJ, 16.0f) + i2);
            this.nkQ.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nnI.dJF().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.noi.dismiss();
    }

    private void du(View view) {
        if (this.noc == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.dIT().q()) {
            this.nkU.dWx();
        } else {
            this.nkU.dWy();
        }
        int height = this.nnt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (view != null) {
            this.noc.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.noc == null) {
            View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.nkU = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dIT().q()) {
                this.nkU.dWx();
            } else {
                this.nkU.dWy();
            }
            this.nkU.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dIT().g(z);
                }
            });
            this.nnW = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nnX = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nnW.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nnW.setVisibility(0);
            } else {
                this.nnW.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dIT().a) {
                this.nnX.b();
            } else {
                this.nnX.c();
            }
            if (this.nnI != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.nnI.f;
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
                                if (this.nhl == null || !this.nhl.nkf.mInPKMode || h.isEmpty(this.nhl.b) || this.nlB == null || !this.nhl.b.equals(this.nlB.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dJG = this.nnI.dJG();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnJ, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, 5.0f);
                                            }
                                            int identifier = this.nnJ.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nnJ.getPackageName());
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
                                                if (dJG != null && dJG.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nnJ.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nnJ).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dJG2 = this.nnI.dJG();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nnJ).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnJ, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, 5.0f);
                                        }
                                        int identifier2 = this.nnJ.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nnJ.getPackageName());
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
                                            if (dJG2 != null && dJG2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.noc.dismiss();
                    }
                }
            });
            this.noc = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 150.0f), -2);
            this.noc.setFocusable(true);
            this.noc.setOutsideTouchable(true);
            this.noc.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.noc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.noc = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
            if (this.nlj == null) {
                this.nlj = new f(getActivity());
            }
            this.nlj.a(this.nnI.dJF().mRoominfo, this.ax);
            if (!this.nlj.isShowing()) {
                this.nlj.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nmb) {
            return false;
        }
        if (this.nma == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nmS = motionEvent.getX();
                    this.nmT = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nmS;
                    if (Math.abs(f) > Math.abs(y - this.nmT) && Math.abs(f) > q && f > 0.0f) {
                        bj();
                        return true;
                    }
                    this.nmS = 0.0f;
                    this.nmT = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nmy != null && this.nmy.getVisibility() == 0 && b(motionEvent, this.nmy)) {
                this.nmy.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dF(this.nmx);
                return true;
            } else if (this.nlW && this.nmy != null && this.nmy.getVisibility() == 8 && f(this.non.b, motionEvent)) {
                dKl();
                return true;
            } else if (this.nlk != null && this.nlk.b() && f(this.nlk, motionEvent)) {
                this.nlk.a();
                return true;
            } else if (this.nla != null && this.nla.b() && f(this.nla, motionEvent)) {
                this.nla.a();
                return true;
            } else if (b(motionEvent, this.nkS)) {
                return dxH();
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
            if (this.noA != null && this.noA.a(i, keyEvent)) {
                return true;
            }
            if ((this.nlk != null && this.nlk.onKeyDown(i, keyEvent)) || az()) {
                return true;
            }
            if (this.nma == 3) {
                this.nma = 1;
                bj();
                return true;
            } else if (this.nla != null && this.nla.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nkT != null && this.nkO != null && this.nkS != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.nkT);
                this.nkO.setVisibility(8);
                this.nkS.setVisibility(0);
            }
        } else if (this.nkO != null && this.nkS != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
            this.nkO.setVisibility(0);
            this.nkS.setVisibility(8);
        }
    }

    public boolean dxH() {
        boolean z;
        b(this.nkr, 12);
        boolean z2 = false;
        if (this.nin != null && this.nin.getVisibility() == 0) {
            this.nin.setVisibility(8);
            this.nio.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nip) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnJ);
            this.nio.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nkS == null || this.nkS.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.cO) {
                dKC();
            }
            this.nkS.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.nkO != null) {
                    c.this.nkO.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean az() {
        if (dxH()) {
            return true;
        }
        if (this.noi != null && this.noi.isShowing()) {
            this.noi.dismiss();
            return true;
        } else if (this.noG != null && this.noG.isShowing()) {
            this.noG.dismiss();
            return true;
        } else if (this.noc == null || !this.noc.isShowing()) {
            return dKl() || dKc() || dKk() || dJR();
        } else {
            this.noc.dismiss();
            return true;
        }
    }

    public boolean dJR() {
        if (this.nor == null || !this.nor.isShown()) {
            return false;
        }
        this.nor.d();
        return true;
    }

    public boolean dKc() {
        if (this.nlY == null || !this.nlY.isShown()) {
            return false;
        }
        this.nlY.a();
        return true;
    }

    public boolean dKk() {
        if (this.nlk == null || !this.nlk.b()) {
            return false;
        }
        this.nlk.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nnJ != null && !((Activity) this.nnJ).isFinishing() && pVar != null) {
            this.nlJ = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nlB != null && mVar.a(this.nlB.mCreatorUID, null)) {
            this.nlB.mIsSubscribed = mVar.c;
            dJX();
        }
    }

    public boolean dKl() {
        if (!this.nlW || this.non == null) {
            return false;
        }
        if (this.non != null) {
            this.non.e();
        }
        if (this.nmx != null) {
            this.nmx.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nmf != null) {
                        this.nmf.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                        this.nnI.dJF().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nnI.dJF().mMicStatus.onMic) {
                            if (this.nkI != null) {
                                this.nkI.setVisibility(8);
                            }
                            if (this.nlY != null && this.nlY.isShown()) {
                                this.nlY.a();
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
                        if (this.nnI.dJF().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nlB != null && !h.isEmpty(this.nlB.mCreatorUID)) {
                                g(arrayList2, this.nlB.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.nnI.dJF().mMicStatus.onMic) {
                            if (this.nnI.dJF().mMicStatus != null && !h.isEmpty(this.nnI.dJF().mMicStatus.micRoomId) && !this.nnI.dJF().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.nnI.dJF().mMicStatus.micRoomId;
                            }
                            this.nnI.dJF().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nnI.dJF().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.nnI.dJF().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.nnI.dJF().mMicStatus, str3, z4);
                            if (this.nlY != null && this.nlY.getVisibility() == 0) {
                                this.nlY.a(this.nnI.dJF().mFanItems, this.nnI.dJF().mMicStatus, str3, z4, this.nnI.dJF().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nkI != null) {
                                this.nkI.setVisibility(8);
                            }
                            if (this.nlY != null && this.nlY.isShown()) {
                                this.nlY.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nlx != onlineVip.mCount || (this.nkG != null && this.nkG.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nlx = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dKp();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.nlV.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.nlV.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.nlV.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.nmo <= 5000) {
                                z2 = false;
                            } else {
                                this.nmo = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.nlV.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.nlV.addAll(onlineVip.mOnlineVipItems);
                            }
                            dJY();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nmp != null) {
                    if (this.nlB == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nlB.mCreatorAvatar;
                        str2 = this.nlB.mCreatorGender;
                    }
                    this.nmp.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nhl != null && this.nhl.nkf != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nhl.nkf.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.nhh != null) {
                                        this.nhh.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nhl.nkf.mInPKMode = true;
                                    this.nhl.nkf.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhl.nkf.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhl.nkf.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhl.nkf.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhl.nkf.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhl.nkf.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nhl.nkf.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nhl.nkf.mMode = pkNotifyInfo.mMode;
                                    this.nhl.nkf.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.nhm != null) {
                                        this.nhm.g(true, this.nhl.nkf.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dIT().a) {
                                        if (!com.kascend.chushou.b.dIM().e) {
                                            com.kascend.chushou.b.dIM().e = true;
                                            tv.chushou.zues.utils.g.F(this.nnJ, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dIT().a(this.nnJ, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.nhl.nkf.mAction = 7;
                                    this.nhl.nkf.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhl.nkf.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhl.nkf.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhl.nkf.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhl.nkf.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhl.nkf.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.nhl.nkf.mMode == 2) {
                                        dKi();
                                    } else {
                                        dJS();
                                    }
                                    if (this.nhm != null) {
                                        this.nhm.g(false, 0L);
                                        this.nhm.b(this.nhl.nkf, true);
                                        this.nhm.a(this.nmr + tv.chushou.zues.utils.a.dip2px(this.nnJ, 52.0f), this.aq);
                                        this.nhm.a(this.nhl.nkf.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.nhh != null) {
                                        this.nhh.a(false);
                                    }
                                    this.nhl.nkf.mInPKMode = false;
                                    this.nhl.nkf.mAction = 2;
                                    dJS();
                                    dKi();
                                    if (this.nhm != null) {
                                        this.nhm.c();
                                    }
                                    this.nhl.b = null;
                                    this.nhl.nkf = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nhl.nkf.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nhl.nkf.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.nhl.nkf.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nlB != null && !h.isEmpty(this.nlB.mRoomID) && this.nlB.mRoomID.equals(this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.nhl.nkf.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.nhm != null) {
                                        this.nhm.a(this.nhl.nkf, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nhl.nkf.copyUpdate(pkNotifyInfo);
                                    if (this.nhm != null) {
                                        this.nhm.a(this.nhl.nkf);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nhl.nkf.copyStop(pkNotifyInfo);
                                        if (this.nhm != null) {
                                            this.nhm.A(this.nhl.nkf.mMaxFreeDuration, this.nhl.nkf.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nhl.nkf.copyResult(pkNotifyInfo);
                                    if (!this.nlT && this.nhm != null) {
                                        int i7 = 1;
                                        if (this.nhl.nkf.destinyInfo != null && this.nhl.nkf.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.nhm.a(h.parseInt(this.nhl.nkf.mResult), h.parseLong(this.nhl.nkf.mvpUid), this.nhl.nkf.mvpAvatar, this.nhl.nkf.mvpNickname, this.nhl.nkf.mMaxFreeDuration, this.nhl.nkf.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nho != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nho.uid = cycleLiveRoomInfo.uid;
                        this.nho.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nho.roomId = cycleLiveRoomInfo.roomId;
                        this.nho.avatar = cycleLiveRoomInfo.avatar;
                        this.nho.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nnJ != null && (this.nnJ instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nnJ).d();
                        }
                    } else {
                        ((VideoPlayer) this.nnJ).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.nnI != null && this.nnI.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dIT().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dIT().b().equals(next2.mUserID)) {
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

    public void dKp() {
        if (this.nkG != null) {
            if (this.nhl == null || this.nhl.nkf == null || !this.nhl.nkf.mInPKMode) {
                if (this.bP > 0) {
                    this.nkG.setVisibility(0);
                    this.nkG.setText(String.format(this.nnJ.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.nkK.setVisibility(0);
                    return;
                }
                this.nkG.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.nkI.setVisibility(0);
            if (this.nkJ != null) {
                this.nkJ.a(str, z, micStatus, this.nnI.dJF().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.nkI.setVisibility(8);
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
        int childCount = this.nlD.getChildCount();
        int itemCount = this.nlD.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nlD);
        if (f + childCount >= itemCount) {
            this.nlK = true;
            if (this.nlL != null) {
                this.nlL.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dKs() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nlE.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nlE.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nlE == null) {
            this.nlE = new ArrayList<>();
        }
        while (2 < this.nlE.size()) {
            this.nlE.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nlG);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nlE.addAll(a2);
        int size = this.nlE.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nlE.size(); i++) {
                this.nlE.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nlH == null) {
            this.nlH = new ArrayList<>();
        }
        this.nlH.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nlJ != null && this.nlJ.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nlJ.contains("2"))) {
                        this.nlH.add(next);
                    } else if (!this.nlJ.contains(next.mType)) {
                        this.nlH.add(next);
                    }
                }
                return this.nlH;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nlE == null) {
                    this.nlE = new ArrayList<>(arrayList);
                    dKs();
                    w(z2);
                    return;
                }
                if (this.nlG == null) {
                    this.nlG = new ArrayList<>();
                }
                this.nlG.addAll(arrayList);
                int size = this.nlG.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.nlG.size(); i++) {
                        this.nlG.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nlE.size();
                if (a2 != null) {
                    this.nlE.addAll(a2);
                }
                int size3 = this.nlE.size();
                if (!this.nlK && this.nlL != null) {
                    this.nlL.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nlE.size(); i3++) {
                        this.nlE.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nlE == null) {
                this.nlE = new ArrayList<>(arrayList);
                dKs();
            } else {
                if (this.nlG == null) {
                    this.nlG = new ArrayList<>();
                }
                this.nlG.clear();
                this.nlG.addAll(arrayList);
                this.nlE.clear();
                dKs();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nlE.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nlI != null) {
                this.nlI.a(this.nlE.size());
                if (i == 1) {
                    this.nlI.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nlI.notifyItemRangeRemoved(i2, i3);
                    this.nlI.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nlI.notifyDataSetChanged();
                }
            }
            if (z || this.nlK) {
                this.nlK = true;
                if (this.nlL != null) {
                    this.nlL.setVisibility(8);
                }
                if (z) {
                    this.nlA.scrollToPosition(this.nlE.size() - 1);
                } else {
                    this.nlA.smoothScrollToPosition(this.nlE.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nlI != null) {
                this.nlI.a(this.nlE.size());
                this.nlI.notifyDataSetChanged();
            }
            if (z || this.nlK) {
                this.nlK = true;
                if (this.nlL != null) {
                    this.nlL.setVisibility(8);
                }
                if (z) {
                    this.nlA.scrollToPosition(this.nlE.size() - 1);
                } else {
                    this.nlA.smoothScrollToPosition(this.nlE.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dJq;
        RoomToast roomToast;
        this.p = false;
        if (this.nnI != null && this.nnI.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.nnI.f.size()) {
                    break;
                } else if (!"2".equals(this.nnI.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dKw();
            return;
        }
        if (this.nhB != null) {
            this.nhB.setVisibility(0);
        }
        if (this.nkw != null) {
            this.nkw.setVisibility(0);
        }
        if (this.nnI != null) {
            this.nlB = this.nnI.dJI();
            this.nlC = this.nnI.dJF();
            if (com.kascend.chushou.b.dIM().c != null && this.nlI != null) {
                this.nlI.a(com.kascend.chushou.b.dIM().c);
                this.nlI.notifyDataSetChanged();
            }
            FullRoomInfo dJF = this.nnI.dJF();
            if (dJF != null) {
                if (!h.isEmpty(dJF.mRoomToastList)) {
                    Iterator<RoomToast> it = dJF.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dIT().j())) {
                    a(roomToast);
                }
            }
            if (this.nlB != null) {
                dKz();
            }
            if (this.nlB != null && !this.nlB.mIsSubscribed) {
                RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nlB == null || !c.this.nlB.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.nnI != null && this.nnI.l()) {
                d(true);
            }
        }
        if (this.nlB != null && this.nlI != null) {
            if (this.nlE != null) {
                this.nlE.clear();
            } else {
                this.nlE = new ArrayList<>();
            }
            this.nlI.a(this.nlB);
            dKs();
            this.nlI.a(this.nlE.size());
            this.nlI.notifyDataSetChanged();
        }
        dJW();
        N();
        if (this.nnJ != null && (this.nnJ instanceof VideoPlayer) && (dJq = ((VideoPlayer) this.nnJ).dJq()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dJq.nkf, dJq.b);
        }
        this.nkX.h(this.nlB.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nlB.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.nlb);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.nlw == null) {
            View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.niS = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nlw = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnJ, 160.0f), -2);
            this.nlw.setFocusable(false);
            this.nlw.setOutsideTouchable(false);
            this.nlw.setAnimationStyle(a.j.gift_toast_style);
            this.nlw.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dIT().c(roomToast.mToastContent);
            if (this.nlw == null) {
                bd();
            }
            if (this.niS != null) {
                this.niS.setText(roomToast.mToastContent);
            }
            if (!this.nlw.isShowing()) {
                if (this.nlb != null) {
                    this.nlw.showAtLocation(this.nlb, 85, 0, this.nnt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nlw != null) {
                                c.this.nlw.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nlw.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nml != null) {
            this.nml.setVisibility(z ? 0 : 8);
        }
        this.dJ = true;
        if (this.nnJ instanceof VideoPlayer) {
            ((VideoPlayer) this.nnJ).p();
        }
    }

    private void dKw() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nnJ).s();
        dJR();
        dKc();
        if (this.nkM == null) {
            this.nkM = (PlayShowRecommendView) ((ViewStub) this.nnt.findViewById(a.f.view_recommend)).inflate();
        }
        this.nkM.setVisibility(0);
        if (this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null && !h.isEmpty(this.nnI.dJF().mRoominfo.mRoomID)) {
            dKq();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.non != null) {
            this.non.e();
        }
        if (this.nhB != null) {
            this.nhB.setVisibility(4);
        }
        if (this.nkw != null) {
            this.nkw.setVisibility(8);
        }
        if (this.nox != null) {
            this.nox.dVU();
            this.nox.setVisibility(8);
        }
        m(false);
        a(false, false);
        if (this.nhh != null) {
            this.nhh.a();
        }
    }

    private void dKq() {
        if (this.nkM != null && this.nkM.getVisibility() == 0) {
            this.nkM.a(this.nnI.dJF().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dKg() {
        super.dKg();
        if (this.nnJ instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.nlk != null && this.nlk.b()) {
            this.nlk.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nlX);
        if (this.nnJ != null) {
            if (this.nlX || "10004".equals(((VideoPlayer) this.nnJ).t)) {
                this.nlX = true;
                if (this.nnI != null) {
                    this.nnI.f = null;
                    if (this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                        this.nnI.dJF().mRoominfo.mGameId = null;
                    }
                }
                dKw();
                return;
            }
            this.nlX = true;
            if (this.nnJ != null) {
                ((VideoPlayer) this.nnJ).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nlX = false;
        if (this.nhB != null) {
            this.nhB.setVisibility(0);
        }
        if (this.nkw != null) {
            this.nkw.setVisibility(0);
        }
        if (this.nkM != null) {
            this.nkM.setVisibility(8);
        }
        if (this.nnD != null) {
            this.nnD.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nlX = false;
        if (this.nhB != null) {
            this.nhB.setVisibility(0);
        }
        if (this.nkw != null) {
            this.nkw.setVisibility(0);
        }
        if (this.nkM != null) {
            this.nkM.setVisibility(8);
        }
        if (this.nnD != null) {
            this.nnD.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nkM != null) {
            this.nkM.setVisibility(8);
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
                    if (this.nnI != null) {
                        this.nnI.f = null;
                        this.nnI.dJF().mRoominfo.mGameId = null;
                    }
                    dKw();
                    return;
                }
                tv.chushou.zues.utils.g.LI(a.i.str_getvideosource_failed);
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
        if (this.nnI != null && this.nnI.dJG() != null) {
            a(this.nnI.dJG());
        }
        this.p = false;
        if (this.nnI == null || this.nnI.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nnI.f.size()) {
                if (!"2".equals(this.nnI.f.get(i2).mType)) {
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
    public GiftAnimationLayout dKa() {
        if (this.nnt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nnt.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nlb != null) {
            int size = iconConfig.configs.size();
            this.nlb.removeAllViews();
            if (this.nld != null) {
                this.nld.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nnJ).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.nlb, false);
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
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.nld.setVisibility(0);
                            this.nlc.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                    public void ds(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.nlb.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void D() {
        if (this.nnJ instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dJl = ((VideoPlayer) this.nnJ).dJl();
            if (this.noA == null) {
                this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.noA.setVisibility(0);
            this.noA.a(2, dJl);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nlf != null && this.nnJ != null) {
            this.nlf.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nlf != null && this.nnJ != null) {
            this.nlf.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(long j) {
        if (this.nlf != null) {
            this.nlf.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0828a
    public void c(int i) {
        if (this.nlf != null) {
            this.nlf.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void a(int i) {
        if (this.nle != null) {
            if (this.nnJ != null) {
                this.nle.a(((VideoPlayer) this.nnJ).dJl(), false);
            }
            this.nle.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nnt != null) {
            Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
            int i = gw.x > gw.y ? 1 : 2;
            if (this.noA == null) {
                this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.noA.setPlayerViewHelper(this.nnI);
            this.noA.setVisibility(0);
            this.noA.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nlg != null) {
            this.nlg.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nlg != null) {
            this.nlg.a(bangInfo, str);
        }
        if (this.nhP != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nhP.setText(this.nnJ.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nhP.setText(this.nnJ.getString(a.i.str_contribute_tittle));
            } else {
                this.nhP.setText(Html.fromHtml(this.nnJ.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.nkH != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nkH.setText(this.nnJ.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nkH.setText(this.nnJ.getString(a.i.str_contribute_tittle));
            } else {
                this.nkH.setText(Html.fromHtml(this.nnJ.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nlg != null) {
            this.nlg.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nnI != null && !h.isEmpty(this.nnI.ngS)) {
            this.nmd = this.nnI.ngS.get(0);
            if (this.nms != null) {
                this.nms.setVisibility(0);
                this.nms.a(this.nmd.mCover, 0, 0, 0, 1);
                if (this.nmt != null) {
                    if (this.nmd.mShowClose) {
                        this.nmt.setVisibility(0);
                    } else {
                        this.nmt.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nlg != null) {
            this.nlg.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nnt != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nin != null) {
            this.nin.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nlT) {
            if (iVar.a == 52) {
                if (this.nlI != null) {
                    this.nlI.a(com.kascend.chushou.b.dIM().c);
                    this.nlI.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nlT && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.nkT != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.nkT);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nlT) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dJm = ((VideoPlayer) this.nnJ).dJm();
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(2, dJm);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dJn = ((VideoPlayer) this.nnJ).dJn();
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(2, dJn);
            } else if (bVar.a == 8) {
                if (this.nmf != null && this.nmf.getVisibility() != 0) {
                    this.nmf.a(a.C0815a.slide_in_bottom_danmu_anim, a.C0815a.slide_out_bottom_danmu_anim, this.nlB == null ? "" : this.nlB.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.noA == null) {
                    this.noA = (H5Container) ((ViewStub) this.nnt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.noA.setVisibility(0);
                this.noA.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.nnI != null && !h.isEmpty(this.nnI.a) && this.nnI.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nmf != null && this.nmf.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nnJ, 80.0f);
                }
                if (this.nme != null && this.nme.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nme.getHeight());
                }
                this.nmn.setTranslationY(-r0);
                return;
            }
            if (this.nmm != null) {
                this.nmm.cancel();
                this.nmm = null;
            }
            int translationY = (int) this.nmn.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nnJ, 80.0f) : 0;
                    if (this.nme != null && this.nme.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nme.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nme.getHeight() : 0;
                    if (this.nmf != null && this.nmf.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nnJ, 80.0f));
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
        this.nmm = ValueAnimator.ofInt(i, i2);
        this.nmm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.nlg != null) {
                    c.this.nmn.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nmm.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nmm = null;
            }
        });
        this.nmm.setInterpolator(new LinearInterpolator());
        this.nmm.setDuration(800L);
        this.nmm.start();
    }

    private boolean dKx() {
        if (this.nma == 1) {
            this.nma = 2;
            x(true);
            return true;
        } else if (this.nma == 3) {
            bj();
            return true;
        } else {
            return false;
        }
    }

    private boolean dKy() {
        if (this.nma == 1) {
            return bi();
        }
        if (this.nma == 2) {
            this.nma = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nmb || this.nnI == null || this.nnI.dJI() == null) {
            return false;
        }
        if (this.nmU != null) {
            this.nmU.a(true);
        }
        this.nma = 3;
        this.nmb = true;
        dKz();
        this.nkt.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nmb = false;
                c.this.nkv.setVisibility(8);
            }
        });
        this.nkv.startAnimation(loadAnimation);
        this.nkt.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj() {
        if (!this.nmb) {
            if (this.nmU != null) {
                this.nmU.a(false);
            }
            this.nma = 1;
            this.nmb = true;
            dKz();
            this.nkv.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nmb = false;
                    c.this.nkt.setVisibility(8);
                }
            });
            this.nkv.startAnimation(loadAnimation);
            this.nkt.startAnimation(loadAnimation2);
        }
    }

    private void dKz() {
        if (this.nnt != null) {
            if (this.nkt == null) {
                this.nkt = this.nnt.findViewById(a.f.user_space_container);
            }
            if (this.nkv == null) {
                this.nkv = this.nnt.findViewById(a.f.video_container);
            }
            if (this.nku == null) {
                this.nku = com.kascend.chushou.view.user.b.b(null, this.nnI.a, false, this.nnI.h);
                this.nku.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
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
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.nku).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.nkw != null) {
            this.nkw.setVisibility(z ? 8 : 0);
        }
        if (this.nly != null) {
            this.nmb = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nly.setVisibility(8);
                        c.this.nmb = false;
                    }
                });
            } else {
                this.nmb = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nly.setVisibility(0);
                        c.this.nmb = false;
                    }
                });
            }
            this.nly.startAnimation(loadAnimation);
        }
        az();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.nkN.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.nkV != null) {
                this.nkV.setVisibility(0);
            }
            if (this.nkW != null) {
                this.nkW.a();
                return;
            }
            return;
        }
        if (this.nkY != null) {
            this.nkY.setVisibility(0);
        }
        if (this.nkZ != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.nkZ.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.nkY != null) {
            this.nkY.setVisibility(8);
        }
        if (this.nkZ != null) {
            this.nkZ.clearAnimation();
        }
        if (this.nkV != null) {
            this.nkV.setVisibility(8);
        }
        if (this.nkW != null) {
            this.nkW.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nly != null && this.nnt != null) {
            if (this.nmf == null) {
                this.nmf = new com.kascend.chushou.player.ui.miniview.a(this.nnJ, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nmf != null && c.this.nnt != null && c.this.nmf.a()) {
                            ((ViewGroup) c.this.nnt).removeView(c.this.nmf);
                            c.this.nmf = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nmf.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nnJ, 52.0f);
                this.nmf.setLayoutParams(layoutParams);
                ((ViewGroup) this.nly).addView(this.nmf, ((ViewGroup) this.nly).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nmf.setVisibility(8);
                } else {
                    this.nmf.a(a.C0815a.slide_in_bottom_danmu_anim, a.C0815a.slide_out_bottom_danmu_anim, this.nnI.a == null ? "" : this.nnI.a);
                }
            } else if (!this.nmf.isShown()) {
                this.nmf.a(a.C0815a.slide_in_bottom_danmu_anim, a.C0815a.slide_out_bottom_danmu_anim, this.nnI.a == null ? "" : this.nnI.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nmk != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nmk.setVisibility(0);
                this.nmk.setAnim(true);
                this.nmk.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.olY, b.C0944b.oma, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nlM != null && this.nlM.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dKA();
                    }
                });
                this.nlM.setVisibility(0);
                this.nlM.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nlM != null && this.nlM.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nlO != null) {
                        c.this.nlO.removeAllListeners();
                        c.this.nlO.cancel();
                        c.this.nlO = null;
                    }
                    if (c.this.nlM != null) {
                        c.this.nlM.setVisibility(8);
                    }
                }
            });
            this.nlM.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nmq == null) {
                this.nmq = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nnJ, "显示双击666_num", null, new Object[0]);
                            if (c.this.nnI != null) {
                                c.this.nnI.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.nnK != null) {
                    this.nnK.e(this.nmq, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nmq != null) {
            this.nnK.P(this.nmq);
            this.nmq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nlP != null && this.nlP.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dKB();
                    }
                });
                this.nlP.setVisibility(0);
                this.nlP.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nns, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nlP != null && this.nlP.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnJ, a.C0815a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nlR != null) {
                        c.this.nlR.removeAllListeners();
                        c.this.nlR.cancel();
                        c.this.nlR = null;
                    }
                    if (c.this.nlP != null) {
                        c.this.nlP.setVisibility(8);
                    }
                }
            });
            this.nlP.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dKA() {
        if (this.nlM == null || this.nlN == null) {
            return null;
        }
        if (this.nlO != null) {
            this.nlO.removeAllListeners();
            this.nlO.cancel();
            this.nlO = null;
        }
        this.nlN.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nlN, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nlN, 0.0f);
        int measuredWidth = (this.nlM.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nnJ, 13.0f) * 2)) - this.nlN.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nlN, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nlN, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nlN, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nlO != null) {
                    c.this.nlO.removeAllListeners();
                    c.this.nlO.cancel();
                    c.this.nlO = null;
                }
                RxExecutor.postDelayed(c.this.nns, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dKA();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nlO = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dKB() {
        if (this.nlP == null || this.nlQ == null) {
            return null;
        }
        if (this.nlR != null) {
            this.nlR.removeAllListeners();
            this.nlR.cancel();
            this.nlR = null;
        }
        this.nlQ.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nlQ, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nlQ, 0.0f);
        int measuredWidth = (this.nlP.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nnJ, 13.0f) * 2)) - this.nlQ.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nlQ, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nlQ, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nlQ, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nlR != null) {
                    c.this.nlR.removeAllListeners();
                    c.this.nlR.cancel();
                    c.this.nlR = null;
                }
                RxExecutor.postDelayed(c.this.nns, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dKB();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nlR = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nmU = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nho != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nho.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet dP = com.kascend.chushou.c.a.dP(jSONObject);
                        if (dP.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.LI(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.LI(a.i.subscribe_success);
                            }
                            if (c.this.nho != null) {
                                c.this.nho.isSubscribe = !z;
                                c.this.aN();
                                return;
                            }
                            return;
                        }
                        a(dP.mRc, dP.mMessage);
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
                com.kascend.chushou.c.c.dIP().a(bVar, (String) null, this.nho.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nho.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dIP().b(bVar, (String) null, c.this.nho.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.nnI != null && this.nlB != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.nnI.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nnI.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nlB.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet dP = com.kascend.chushou.c.a.dP(jSONObject);
                        if (dP.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.LI(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.LI(a.i.subscribe_success);
                            }
                            c.this.nlB.mIsSubscribed = !z;
                            c.this.dJX();
                            return;
                        }
                        a(dP.mRc, dP.mMessage);
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
                com.kascend.chushou.c.c.dIP().a(bVar, (String) null, this.nlB.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nlB.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dIP().b(bVar, (String) null, c.this.nlB.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.nke != null) {
            int width = this.nke.getWidth();
            int height = this.nke.getHeight();
            if (this.nmi != width || this.nmj != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.nnt != null) {
            if (this.nla == null) {
                this.nla = (InteractionView) ((ViewStub) this.nnt.findViewById(a.f.view_interaction)).inflate();
                this.nla.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.nla.a();
                    }
                });
            }
            if (this.nla != null) {
                this.nla.b(configDetail);
                this.nla.c();
                this.nla.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dWH()) {
                tv.chushou.zues.utils.g.F(this.nnJ, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nnJ, null) && (this.nnJ instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nnJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnJ, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nnJ, configDetail.mUrl, this.nnJ.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nnJ, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nlW) {
                        dKl();
                        return;
                    }
                    if (this.nnJ.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nnJ, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.nnI != null && this.nnI.dJF() != null && this.nnI.dJF().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnI.dJF().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    du(this.nlb);
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
        if (this.nnJ != null && !this.v && !h.isEmpty(str) && this.nlB != null && str.equals(this.nlB.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nhl == null) {
                this.nhl = new com.kascend.chushou.player.e.a();
            }
            this.nhl.b = str;
            this.nhl.nkf.copy(pkNotifyInfo);
            if (this.nhl.nkf.mAction == 6) {
                if (this.nhh != null) {
                    this.nhh.a(true);
                }
                this.nhl.nkf.mInPKMode = true;
                this.u = this.nhl.nkf.mPkId;
            } else if (this.nhl.nkf.mAction == 7 || (this.nhl.nkf.mMode == 1 && this.nhl.nkf.mAction == 5)) {
                if (this.nhh != null) {
                    this.nhh.a(true);
                }
                this.nhl.nkf.mInPKMode = true;
                if (this.dD != 42) {
                    this.nmr = ((this.nmh.y - ((this.nmh.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nnJ, 158.0f) + this.nlv)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
                    dKi();
                }
                this.u = this.nhl.nkf.mPkId;
                if (this.nhm != null) {
                    this.nhm.b(this.nhl.nkf, false);
                    this.nhm.a(this.nhl.nkf.mMode, (String) null);
                    if (this.nhl.nkf.mAction == 5 && this.nhl.nkf.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nhl.nkf.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nhl.nkf.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nhl.nkf.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nhl.nkf.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nhl.nkf.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.nhm.a(this.nhl.nkf);
                        this.nhm.a(parseInt, this.nhl.nkf.mPkUpdateInfo.remainDuration, j, this.nhl.nkf.mMode, (this.nhl.nkf.destinyInfo == null || this.nhl.nkf.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.nhl.nkf.mPkUpdateInfo != null && !h.isEmpty(this.nhl.nkf.mPkUpdateInfo.specialMomentList) && this.nhm != null) {
                    this.nhm.a(this.nhl.nkf, true);
                }
                if (this.nhl.nkf.mMode == 2) {
                    dKi();
                } else {
                    dJS();
                }
            } else {
                this.nhl.nkf.mInPKMode = false;
                if (this.nhl.nkf.mMode == 2) {
                    dKi();
                } else {
                    dJS();
                }
            }
        }
    }

    public void dJS() {
        aV();
        aU();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nlt != null && this.nnI != null && this.nnI.ngT != null) {
            this.nlt.setText(tv.chushou.zues.utils.b.LH(this.nnI.ngT.count));
            this.nlt.setVisibility(0);
            if (this.nnI.ngT.count < 1) {
                dKC();
            }
            if (this.nlm != null) {
                this.nlm.setText(this.nnI.ngT.primaryName);
            }
            if (this.nln != null) {
                this.nln.setText(this.nnI.ngT.desc);
            }
            dJT();
        }
    }

    public void dJT() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nlu * h.parseLong(this.nnI.ngT.point)));
        if (this.niH != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nnJ.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nnJ, a.e.icon_coin_new);
            cVar.append(this.nnJ.getString(a.i.str_buy_count_coin2));
            this.niH.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.nnJ, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nlu);
        }
    }

    private void dKC() {
        this.cO = false;
        this.nls.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nnI != null && this.nnI.ngT != null) {
            if (this.nnI.ngT.count < 1) {
                this.nlt.setVisibility(8);
            } else {
                this.nlt.setVisibility(0);
                this.nlt.setSelected(false);
                this.nlt.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nll.setVisibility(8);
        if (this.nkT != null) {
            this.nkT.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nhq != null) {
            if (z) {
                this.nhq.setVisibility(0);
            } else {
                this.nhq.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nmR != null) {
            this.nmR.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nlc != null) {
            this.nlc.performClick();
        }
    }
}
