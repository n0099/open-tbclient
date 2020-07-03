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
    public String nhF;
    private TextView nhJ;
    private TextView nhM;
    private ImageView nhS;
    private View nhy;
    private TextView niE;
    private TextView niP;
    private View niS;
    private TextView nib;
    private KPSwitchPanelLinearLayout nik;
    private ImageView nil;
    private tv.chushou.zues.widget.kpswitch.b.c nin;
    private d.a nio;
    private TextView njO;
    private FrescoThumbnailView nkA;
    private TextView nkB;
    private TextView nkC;
    private TextView nkD;
    private TextView nkE;
    private LinearLayout nkF;
    private PlayShowMicStatusView nkG;
    private RecyclerView nkH;
    private ImageView nkI;
    private PlayShowRecommendView nkJ;
    private View nkK;
    private RelativeLayout nkL;
    private AnimationSet nkM;
    private ImageView nkN;
    private ImageView nkO;
    private RelativeLayout nkP;
    private PastedEditText nkQ;
    private ToggleButton nkR;
    private RelativeLayout nkS;
    private PaoPaoView nkT;
    private FrescoThumbnailView nkU;
    private LinearLayout nkV;
    private ImageView nkW;
    private InteractionView nkX;
    private LinearLayout nkY;
    private FrescoThumbnailView nkZ;
    private int nko;
    private View nkp;
    private View nkq;
    private com.kascend.chushou.view.user.b nkr;
    private View nks;
    private FrameLayout nkt;
    private LinearLayout nku;
    private RelativeLayout nkv;
    private FrescoThumbnailView nkw;
    private TextView nkx;
    private TextView nky;
    private TextView nkz;
    private RecyclerView.LayoutManager nlA;
    private ArrayList<ChatInfo> nlB;
    private ArrayList<ChatInfo> nlC;
    private ArrayList<ChatInfo> nlD;
    private ArrayList<ChatInfo> nlE;
    private Button nlI;
    private View nlJ;
    private View nlK;
    private Animator nlL;
    private View nlM;
    private View nlN;
    private Animator nlO;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> nlR;
    private PlayShowMicPerson nlV;
    private FoodView nlZ;
    private FrameLayout nla;
    private RedpacketNotifier nlb;
    private InteractNotifier nlc;
    private EmbeddedButtonLayout nld;
    private GiftAnimationLayout nle;
    private com.kascend.chushou.player.b.a nlf;
    private f nlg;
    private PlayShowH5View nlh;
    private LinearLayout nli;
    private TextView nlj;
    private TextView nlk;
    private TextView nll;
    private TextView nlm;
    private TextView nln;
    private TextView nlo;
    private ImageView nlp;
    private TextView nlq;
    private PopupWindow nlt;
    private View nlv;
    private RecyclerView nlx;
    private RoomInfo nly;
    private TextView nmA;
    private ImageView nmB;
    private RelativeLayout nmC;
    private LinearLayout nmD;
    private TextView nmE;
    private TextView nmF;
    private RelativeLayout nmG;
    private RelativeLayout nmH;
    private FrescoThumbnailView nmI;
    private TextView nmJ;
    private TextView nmK;
    private ImageView nmL;
    private RelativeLayout nmM;
    private TextView nmO;
    private float nmP;
    private float nmQ;
    private a nmR;
    public ListItem nma;
    private FoodView nmb;
    private com.kascend.chushou.player.ui.miniview.a nmc;
    private int nmd;
    private Point nme;
    private FrescoThumbnailView nmh;
    private FrescoThumbnailView nmi;
    private ValueAnimator nmj;
    private LinearLayout nmk;
    private long nml;
    private VideoShowVoteView nmm;
    private Runnable nmn;
    private FrescoThumbnailView nmp;
    private ImageView nmq;
    private RelativeLayout nmr;
    private TextView nms;
    private ImageView nmt;
    private EditText nmu;
    private View nmv;
    private RelativeLayout nmw;
    private RelativeLayout nmx;
    private FrescoThumbnailView nmy;
    private TextView nmz;
    private boolean nim = false;
    private int nlr = 1;
    private boolean cO = false;
    private int nls = 0;
    private int cQ = 0;
    private int nlu = -1;
    private boolean nlw = false;
    private FullRoomInfo nlz = null;
    private com.kascend.chushou.player.adapter.a nlF = null;
    private ArrayList<String> nlG = null;
    private boolean nlH = true;
    private boolean nlP = true;
    private boolean nlQ = false;
    public final List<OnlineVipItem> nlS = new ArrayList();
    private boolean nlT = false;
    private boolean nlU = false;
    private long nlW = 0;
    private int nlX = 1;
    private boolean nlY = false;
    private int nmf = -1;
    private int nmg = -1;
    private boolean dJ = false;
    private int nmo = -1;
    private io.reactivex.disposables.b nmN = null;

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
        this.nhF = getArguments().getString("cover");
        this.nlP = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.nnq = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.nnq;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            aK();
            this.nkb = ((VideoPlayer) this.nnG).dIY();
            this.nnF = ((VideoPlayer) this.nnG).dJb();
            dt(view);
            dKb();
            if (this.nnG instanceof VideoPlayer) {
                ((VideoPlayer) this.nnG).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.nlQ = false;
        if (this.nok != null) {
            this.nok.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.nlQ = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.nlL != null) {
            this.nlL.removeAllListeners();
            this.nlL.cancel();
            this.nlL = null;
        }
        if (this.nlO != null) {
            this.nlO.removeAllListeners();
            this.nlO.cancel();
            this.nlO = null;
        }
        if (this.nlc != null) {
            this.nlc.c();
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
        if (this.nmN != null) {
            this.nmN.dispose();
            this.nmN = null;
        }
        this.nlr = 1;
        this.cO = false;
        if (this.nnH != null) {
            this.nnH.ch(null);
        }
        if (this.nlt != null) {
            this.nlt.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nnG, this.nin);
        if (this.nnG != null && (this.nnG instanceof VideoPlayer)) {
            ((VideoPlayer) this.nnG).dJf();
        }
        this.nio = null;
        this.nin = null;
        aI();
        if (this.nlf != null) {
            this.nlf.a();
        }
        if (this.nkT != null) {
            this.nkT.b();
            this.nkT.c();
            this.nkT = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.ci(this);
        if (this.nlD != null) {
            this.nlD.clear();
        }
        if (this.nlB != null) {
            this.nlB.clear();
        }
        if (this.nlE != null) {
            this.nlE.clear();
        }
        if (this.nlC != null) {
            this.nlC.clear();
        }
        if (this.nlG != null) {
            this.nlG.clear();
        }
        if (this.nlF != null) {
            this.nlF.a(0);
            this.nlF.a();
        }
    }

    private void dt(View view) {
        this.nkp = view.findViewById(a.f.fl_root);
        this.nme = tv.chushou.zues.utils.a.gx(this.nnG);
        this.nls = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nnG);
        this.cQ = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        this.dD = 86;
        this.nnF = ((VideoPlayer) this.nnG).dJb();
        if (this.nnF != null) {
            this.nly = this.nnF.dJE();
            this.nlz = this.nnF.dJB();
        }
        this.nlB = new ArrayList<>();
        this.nlD = new ArrayList<>();
        this.nlC = new ArrayList<>();
        this.nkt = (FrameLayout) this.nnq.findViewById(a.f.fl_effect);
        b();
        this.nnA = (PlayerErrorView) this.nnq.findViewById(a.f.view_net_error_msg);
        this.nnA.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.nkS = (RelativeLayout) this.nnq.findViewById(a.f.rl_audio_ani);
        this.nkT = (PaoPaoView) this.nnq.findViewById(a.f.audio_ani);
        this.nkU = (FrescoThumbnailView) this.nnq.findViewById(a.f.audio_ani_avatar);
        this.nkV = (LinearLayout) this.nnq.findViewById(a.f.ll_audio);
        this.njO = (TextView) this.nnq.findViewById(a.f.tv_open_video);
        this.nkW = (ImageView) this.nnq.findViewById(a.f.iv_audio_ani);
        this.nmi = (FrescoThumbnailView) this.nnq.findViewById(a.f.live_cover);
        if (!this.dJ || this.nkb == null || this.nkb.getPlayState() != 4) {
            this.nmi.setVisibility(0);
            this.nmi.setBlur(true);
            this.nmi.i(this.nhF, 0, 0, 0);
        }
        this.njO.setOnClickListener(this);
        this.nhj = new b();
        this.nhj.a(view, null, this.nnG, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dWj()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.nnF != null) {
                    append.append(c.this.nnF.dJE().mRoomID);
                }
                if (c.this.nhi != null && c.this.nhi.nkc != null) {
                    append.append("&mode=").append(c.this.nhi.nkc.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nnG, append.toString());
            }
        });
        this.nhn = (VoiceInteractionView) this.nnq.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.nnF != null) {
            this.nly = this.nnF.dJE();
            this.nlz = this.nnF.dJB();
        }
        dJR();
        dJQ();
        dJV();
        this.nmk = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.nlZ = (FoodView) view.findViewById(a.f.rav_ad);
        this.nmp = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.nmq = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.nmp.setOnClickListener(this);
        this.nmq.setOnClickListener(this);
        this.nmr = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.nmh = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.nmh.setOnClickListener(this);
        this.nlc = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.nlb = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nlI = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nlI.setOnClickListener(this);
        this.nlx = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nlx.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nlx.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.nme.x, this.nme.y) * 0.83d);
        this.nlx.setLayoutParams(layoutParams);
        this.nlA = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nnG);
        this.nlx.setLayoutManager(this.nlA);
        this.nlx.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nlx.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nlx.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.nlH = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nlF = new com.kascend.chushou.player.adapter.a(this.nnG, this.nlB);
        if (this.nly != null) {
            this.nlF.a(this.nly);
        }
        if (com.kascend.chushou.b.dII().c != null) {
            this.nlF.a(com.kascend.chushou.b.dII().c);
        }
        this.nlx.setAdapter(this.nlF);
        this.nlF.a(this.nlB.size());
        this.nlF.notifyDataSetChanged();
        if (this.nnF != null && (c = this.nnF.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.nlf != null) {
            this.nlf.a();
            this.nlf = null;
        }
        this.nle = (GiftAnimationLayout) this.nnq.findViewById(a.f.ll_gift_animation);
        this.nle.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.nko = ((int) (tv.chushou.zues.utils.a.gw(this.nnG).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nnG, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nle.getLayoutParams();
        layoutParams2.bottomMargin = this.nko;
        this.nle.setLayoutParams(layoutParams2);
        if (this.nnF != null) {
            this.nlf = new com.kascend.chushou.player.b.a(this.nnG.getApplicationContext(), this.nle);
            this.nlf.a(this.nnF);
            a(this.nnF.ngO, this.nnF.ngR);
        }
        this.nnq.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.nld = (EmbeddedButtonLayout) this.nnq.findViewById(a.f.embedded_button_layout);
        this.nld.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.nmm = (VideoShowVoteView) this.nnq.findViewById(a.f.view_video_show_vote);
        this.nmm.setOnClickListener(this);
        this.nmm.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dKi();
            }
        });
        if (this.nnF != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
            this.nld.a(videoPlayer.dJl().dKF());
            this.nld.b(this.nnF.dJD());
            this.nlb.a(videoPlayer.dJh(), false);
            this.nlc.a(videoPlayer.dJi(), videoPlayer.dJj(), videoPlayer.dJk());
            this.nhi = new com.kascend.chushou.player.e.a();
        }
        this.nov = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.nlT = false;
                c.this.b(c.this.nko, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.nlT = true;
                if (c.this.nok != null) {
                    c.this.nok.measure(0, 0);
                    int measuredHeight = c.this.nok.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nnG, 14.0f);
                    if (measuredHeight > c.this.nko) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.noo = (PaoGuideView) this.nnq.findViewById(a.f.rlPaoGuideView);
        this.nlV = (PlayShowMicPerson) this.nnq.findViewById(a.f.rl_mic_person_view);
        this.nlh = (PlayShowH5View) this.nnq.findViewById(a.f.rl_playshowh5);
        this.nmb = (FoodView) this.nnq.findViewById(a.f.bottom_ad);
        if (this.nnF != null) {
            H();
            if (this.nnF.ngI != null && !h.isEmpty(this.nnF.ngI.mUrl)) {
                b(this.nnF.ngI);
            }
        }
        this.nlJ = this.nnq.findViewById(a.f.view_reminder_subscribe);
        this.nlK = this.nlJ.findViewById(a.f.spash_subscribe);
        ((TextView) this.nlJ.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.nnG, a.e.videoplayer_reminder_subscribe).append(" ").append(this.nnG.getString(a.i.videoplayer_reminder_subscribe)));
        this.nlJ.setOnClickListener(this);
        this.nlM = this.nnq.findViewById(a.f.view_reminder_danmaku);
        this.nlN = this.nlM.findViewById(a.f.spash_danmaku);
        ((TextView) this.nlM.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.nnG, a.e.videoplayer_reminder_danmaku).append(" ").append(this.nnG.getString(a.i.videoplayer_reminder_danmaku)));
        this.nlM.setOnClickListener(this);
    }

    private void dJQ() {
        this.nmw = (RelativeLayout) this.nnq.findViewById(a.f.rl_cyclelive);
        this.nmx = (RelativeLayout) this.nnq.findViewById(a.f.rlrl_cyclelive);
        this.nmy = (FrescoThumbnailView) this.nnq.findViewById(a.f.iv_liveicon);
        this.nmz = (TextView) this.nnq.findViewById(a.f.tv_livename);
        this.nmA = (TextView) this.nnq.findViewById(a.f.tv_livedesc);
        this.nmB = (ImageView) this.nnq.findViewById(a.f.iv_cyclelive_name_menu);
        this.nmC = (RelativeLayout) this.nnq.findViewById(a.f.rl_normal);
        this.nmD = (LinearLayout) this.nnq.findViewById(a.f.ll_cyclelive_nickname);
        this.nmE = (TextView) this.nnq.findViewById(a.f.tv_cyclelive_nickname);
        this.nmF = (TextView) this.nnq.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.nmG = (RelativeLayout) this.nnq.findViewById(a.f.rl_clear_cyclelive);
        this.nmH = (RelativeLayout) this.nnq.findViewById(a.f.rlrl_clear_cyclelive);
        this.nmI = (FrescoThumbnailView) this.nnq.findViewById(a.f.iv_clear_liveicon);
        this.nmJ = (TextView) this.nnq.findViewById(a.f.tv_clear_livename);
        this.nmK = (TextView) this.nnq.findViewById(a.f.tv_clear_livedesc);
        this.nmL = (ImageView) this.nnq.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.nmM = (RelativeLayout) this.nnq.findViewById(a.f.rl_clear_normal);
        this.nmL.setOnClickListener(this);
        this.nmB.setOnClickListener(this);
        this.nmF.setOnClickListener(this);
        this.nmE.setOnClickListener(this);
        this.nmy.setOnClickListener(this);
        this.nmI.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.nnF.ngG != null && this.nmb != null) {
            this.nmb.a(true, this.nnF.a == null ? "" : this.nnF.a);
            this.nmb.a(this.nnF.ngG, a.C0814a.slide_in_bottom_danmu_anim, a.C0814a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nnF != null && this.nnF.ngN != null && this.nld != null) {
            this.nlZ.a(this.nnF.ngN, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.nnF != null) {
                        c.this.nnF.ngN = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dKj() {
        return this.nlf;
    }

    private void aK() {
        this.nnH = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.nnq != null && (textView = (TextView) c.this.nnq.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nnG.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nnH.B(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nnH);
                        break;
                    case 12:
                        c.this.b(c.this.nnH);
                        break;
                    case 17:
                        c.this.as();
                        break;
                    case 18:
                        c.this.dxy();
                        break;
                    case 19:
                        c.this.nnE.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.nlw) {
            this.nlw = true;
            if (this.nlv == null) {
                this.nlv = this.nnq.findViewById(a.f.vs_async_show_content);
                this.nlv = ((ViewStub) this.nlv).inflate();
            }
            this.nhy = this.nnq.findViewById(a.f.ui_content);
            if (this.niS == null) {
                this.niS = this.nnq.findViewById(a.f.vs_async_notification_view);
                this.niS = ((ViewStub) this.niS).inflate();
            }
            c(this.nnq);
            k();
            ar();
            if (this.c == null) {
                this.nhc = new d.a();
                this.c = new GestureDetector(this.nnG, this.nhc);
            }
            ((VideoPlayer) this.nnG).q();
        }
    }

    private void dJR() {
        this.nku = (LinearLayout) this.nnq.findViewById(a.f.ll_anchor);
        this.nkv = (RelativeLayout) this.nnq.findViewById(a.f.ll_clear_anchor);
        this.nku.setVisibility(4);
        this.nkv.setVisibility(4);
        this.nkw = (FrescoThumbnailView) this.nnq.findViewById(a.f.iv_clear_avatar);
        this.nkx = (TextView) this.nnq.findViewById(a.f.tv_clear_nickname);
        this.nky = (TextView) this.nnq.findViewById(a.f.tv_clear_online_count);
        this.nkz = (TextView) this.nnq.findViewById(a.f.tv_clear_btn_subscribe);
        this.nkz.setOnClickListener(this);
        this.nkA = (FrescoThumbnailView) this.nnq.findViewById(a.f.iv_avatar);
        this.nkB = (TextView) this.nnq.findViewById(a.f.tv_nickname_test);
        this.nkC = (TextView) this.nnq.findViewById(a.f.tv_online_count);
        this.nhJ = (TextView) this.nnq.findViewById(a.f.tv_btn_subscribe);
        this.nhJ.setOnClickListener(this);
        this.nkD = (TextView) this.nnq.findViewById(a.f.tv_loyal_counts);
        this.nhM = (TextView) this.nnq.findViewById(a.f.tv_btn_contribution);
        this.nkE = (TextView) this.nnq.findViewById(a.f.tv_btn_contribution_forpk);
        this.nhM.setVisibility(4);
        this.nkE.setVisibility(8);
        this.nkF = (LinearLayout) this.nnq.findViewById(a.f.ll_mic);
        this.nkG = (PlayShowMicStatusView) this.nnq.findViewById(a.f.show_mic_status);
        this.nkH = (RecyclerView) this.nnq.findViewById(a.f.rv_loyal);
        this.nkI = (ImageView) this.nnq.findViewById(a.f.iv_clear_close);
        this.nhS = (ImageView) this.nnq.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.nkH.setLayoutManager(linearLayoutManager);
        this.nlR = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.nlS, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.nlS.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nnG, (JSONObject) null, c.this.nnF.dJE().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0940a view$OnLongClickListenerC0940a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0940a.or(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0940a.or(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0940a.or(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dWv(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nnG, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnG, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnG, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnG, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nnG, a.c.color_979797), dip2px);
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
        this.nkH.setAdapter(this.nlR);
        this.nkF.setOnClickListener(this);
        this.nkw.setOnClickListener(this);
        this.nkI.setOnClickListener(this);
        this.nkA.setOnClickListener(this);
        this.nkw.setOnClickListener(this);
        this.nhS.setOnClickListener(this);
        this.nkD.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void ds(View view) {
                String str = tv.chushou.common.a.dWj() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.nnF != null) {
                    str = str + c.this.nnF.dJE().mRoomID;
                }
                c.this.f(c.this.nnG.getString(a.i.str_loyal_fans), str);
            }
        });
        this.nhM.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void ds(View view) {
                String str = tv.chushou.common.a.dWj() + "m/room-billboard/";
                if (c.this.nnF != null) {
                    str = str + c.this.nnF.dJE().mRoomID;
                }
                c.this.f(c.this.nnG.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.nkE.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void ds(View view) {
                String str = tv.chushou.common.a.dWj() + "m/room-billboard/";
                if (c.this.nnF != null) {
                    str = str + c.this.nnF.dJE().mRoomID;
                }
                c.this.f(c.this.nnG.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.nlz == null || this.nlz.cycleLiveRoomInfo == null || h.isEmpty(this.nlz.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.nhl = this.nlz.cycleLiveRoomInfo;
        }
        if (z2 && this.nhl != null) {
            this.nmw.setVisibility(0);
            this.nmG.setVisibility(0);
            this.nmC.setVisibility(8);
            this.nmM.setVisibility(8);
            this.nmD.setVisibility(0);
            this.nmI.h(this.nhl.eventIcon, com.kascend.chushou.view.a.a(this.nly.mCreatorGender), b.a.small, b.a.small);
            this.nmy.h(this.nhl.eventIcon, com.kascend.chushou.view.a.a(this.nly.mCreatorGender), b.a.small, b.a.small);
            this.nmJ.setText(this.nhl.eventName);
            this.nmK.setText(this.nhl.eventDesc);
            this.nmz.setText(this.nhl.eventName);
            this.nmA.setText(this.nhl.eventDesc);
            this.nmE.setText(this.nhl.nickname);
            aN();
            if (z) {
                c(this.nhl.remainTime);
                return;
            }
            return;
        }
        this.nmw.setVisibility(8);
        this.nmG.setVisibility(8);
        this.nmC.setVisibility(0);
        this.nmM.setVisibility(0);
        this.nmD.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.nmN != null) {
            this.nmN.dispose();
            this.nmN = null;
        }
        this.nmN = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dPs()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nnG != null && (c.this.nnG instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nnG).u();
                }
            }
        });
    }

    private void dJS() {
        if (this.nly != null && this.nlw) {
            this.nku.setVisibility(0);
            this.nkv.setVisibility(0);
            this.nhM.setVisibility(0);
            this.nkw.h(this.nly.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nly.mCreatorGender), b.a.small, b.a.small);
            this.nkx.setText(this.nly.mCreatorNickname);
            this.nkA.h(this.nly.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nly.mCreatorGender), b.a.small, b.a.small);
            this.nkB.setText(this.nly.mCreatorNickname);
            dKr();
            dJT();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dKr() {
        if (this.nly != null) {
            this.nky.setText(tv.chushou.zues.utils.b.formatNumber(this.nly.mOnlineCount));
            this.nkC.setText(tv.chushou.zues.utils.b.formatNumber(this.nly.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.nhl != null) {
            if (this.nhl.isSubscribe) {
                this.nmF.setText(a.i.like_already);
                this.nmF.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nmF.setText(getString(a.i.like));
            this.nmF.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJT() {
        if (this.nly != null) {
            if (this.nly.mIsSubscribed) {
                this.nkz.setText(getString(a.i.like_already));
                this.nkz.setBackgroundResource(a.e.bg_show_subcribe);
                this.nhJ.setText(getString(a.i.like_already));
                this.nhJ.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.nkz.setText(getString(a.i.like));
            this.nkz.setBackgroundResource(a.e.bg_show_subcribe);
            this.nhJ.setText(getString(a.i.like));
            this.nhJ.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dJU() {
        if (this.nlR != null) {
            this.nlR.notifyDataSetChanged();
        }
    }

    private void dJV() {
        this.nkK = this.nnq.findViewById(a.f.tv_interact);
        this.nkK.setOnClickListener(this);
        this.nkP = (RelativeLayout) this.nnq.findViewById(a.f.rl_edit_bar);
        this.nkN = (ImageView) this.nnq.findViewById(a.f.btn_hotword);
        this.nkN.setOnClickListener(this);
        this.nkO = (ImageView) this.nnq.findViewById(a.f.iv_task_badge);
        this.nkM = (AnimationSet) AnimationUtils.loadAnimation(this.nnG, a.C0814a.anim_hotword);
        this.nkM.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dIP().c) {
                    c.this.nkN.clearAnimation();
                    c.this.nkN.startAnimation(c.this.nkM);
                }
            }
        });
        if (com.kascend.chushou.d.h.dIP().c) {
            this.nkN.startAnimation(this.nkM);
            this.nkO.setVisibility(0);
        }
        this.nmO = (TextView) this.nnq.findViewById(a.f.tv_bottom_input);
        this.nmO.setOnClickListener(this);
        this.noG = (FrescoThumbnailView) this.nnq.findViewById(a.f.ll_btn_set);
        this.noG.setOnClickListener(this);
        this.noG.zs(a.e.ic_room_set_btn_white);
        this.nkY = (LinearLayout) this.nnq.findViewById(a.f.ll_bottom_all_button);
        this.nkZ = (FrescoThumbnailView) this.nnq.findViewById(a.f.fl_clear_bottom_gift);
        this.nkZ.setAnim(true);
        this.nkZ.setOnClickListener(this);
        this.nkZ.zs(a.e.ic_show_gift_n);
        this.nla = (FrameLayout) this.nnq.findViewById(a.f.flfl_clear_bottom_gift);
        this.nla.setVisibility(8);
        this.nkL = (RelativeLayout) this.nnq.findViewById(a.f.rl_bottom_input);
        this.nkL.setVisibility(0);
        this.nkQ = (PastedEditText) this.nnq.findViewById(a.f.et_bottom_input);
        this.nkQ.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nib.setEnabled(editable.length() > 0);
            }
        });
        this.nkQ.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.nib);
                    return true;
                }
                return true;
            }
        });
        this.nkQ.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.nkQ);
                }
                return false;
            }
        });
        this.nil = (ImageView) this.nnq.findViewById(a.f.iv_btn_emoji);
        this.nil.setVisibility(8);
        this.nib = (TextView) this.nnq.findViewById(a.f.tv_btn_send);
        this.nib.setOnClickListener(this);
        this.nli = (LinearLayout) this.nnq.findViewById(a.f.head_trumpet);
        this.nli.setVisibility(8);
        this.nli.setOnClickListener(this);
        this.nlj = (TextView) this.nnq.findViewById(a.f.tv_primary_name);
        this.nlk = (TextView) this.nnq.findViewById(a.f.tv_primary_desc);
        this.nlm = (TextView) this.nnq.findViewById(a.f.tv_cut_count);
        this.nlm.setOnClickListener(this);
        this.nlo = (TextView) this.nnq.findViewById(a.f.tv_head_count);
        this.nlo.setText(this.nlr + "");
        this.nln = (TextView) this.nnq.findViewById(a.f.tv_plus_count);
        this.nln.setOnClickListener(this);
        this.niE = (TextView) this.nnq.findViewById(a.f.tv_buy_count_coin);
        this.nll = (TextView) this.nnq.findViewById(a.f.tv_buy_head);
        this.nll.setOnClickListener(this);
        this.nlp = (ImageView) this.nnq.findViewById(a.f.iv_trumpet_select);
        this.nlp.setOnClickListener(this);
        this.nlq = (TextView) this.nnq.findViewById(a.f.tv_trumpet_have_count);
        this.cO = false;
        this.nlp.setBackgroundResource(a.e.ic_trumpet_n);
        this.nlq.setVisibility(8);
        this.nik = (KPSwitchPanelLinearLayout) this.nnq.findViewById(a.f.chat_extended_container);
        dJZ();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.nik, this.nil, this.nkQ, new a.InterfaceC0944a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0944a
            public void wX(boolean z) {
                if (c.this.nil != null) {
                    if (z) {
                        c.this.nik.setDirectVisibility(0);
                        c.this.nil.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.nil.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.nio = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wY(boolean z) {
                c.this.nim = z;
                if (z) {
                    c.this.nil.setImageResource(a.e.cs_emoji_normal);
                    c.this.dJX();
                    if (c.this.nmv != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.nmv.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gJ(c.this.nnG);
                        c.this.nmv.setLayoutParams(layoutParams);
                    }
                    if (c.this.nkP != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.nkP.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gJ(c.this.nnG);
                        c.this.nkP.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.nmv != null && c.this.nmv.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.nmv.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.nmv.setLayoutParams(layoutParams3);
                    c.this.nmv.setVisibility(8);
                }
                if (c.this.nlT) {
                    c.this.nok.setVisibility(0);
                }
                if (c.this.nnG != null && (c.this.nnG instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nnG).wW(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.nkP != null && c.this.nik.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.nkP.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.nkP.setLayoutParams(layoutParams4);
                }
            }
        };
        this.nin = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.nik, this.nio, ((VideoPlayer) this.nnG).dJg());
        ((VideoPlayer) this.nnG).h(((VideoPlayer) this.nnG).dJg());
        this.nmv = this.nnq.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.nms = (TextView) this.nnq.findViewById(a.f.btn_room_search);
        this.nmt = (ImageView) this.nnq.findViewById(a.f.iv_room_emoji_delete);
        this.nmu = (EditText) this.nnq.findViewById(a.f.et_room_emoji_search);
        this.nmu.setImeOptions(3);
        this.nmu.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.nms);
                    return true;
                }
                return false;
            }
        });
        this.nmu.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.nms.setEnabled(editable.length() > 0);
                c.this.nmt.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.nok.setEmojiSearchText(editable.toString());
            }
        });
        this.nms.setOnClickListener(this);
        this.nmt.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void au(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dE(this.nmu);
            this.nmv.setVisibility(0);
            this.nmu.requestFocus();
        } else {
            this.nmv.setVisibility(8);
        }
        if (z2) {
            this.nmu.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJX() {
        int gJ = tv.chushou.zues.widget.kpswitch.b.d.gJ(this.nnG) + tv.chushou.zues.utils.a.dip2px(this.nnG, 14.0f);
        if (gJ > this.nko) {
            b(gJ, 12);
        }
    }

    private void dJZ() {
    }

    private void dKb() {
        if (this.cQ > 0) {
            View findViewById = this.nnq.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.cQ);
        }
        if (this.nls > 0) {
            View findViewById2 = this.nnq.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.nls, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.nlP) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dKf();
        a();
        this.nhe = ((VideoPlayer) this.nnG).dJc();
        this.nhe.a(this);
        if (this.nnF.dJB() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.nhe != null) {
            this.nhe.d();
        }
    }

    private void aU() {
        if ((this.nhi == null || this.nhi.nkc == null || !this.nhi.nkc.mInPKMode) ? false : true) {
            if (this.nkp != null) {
                this.nkp.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nhk.getLayoutParams();
            layoutParams.leftMargin = (this.nme.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nnG, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.nhk.setLayoutParams(layoutParams);
            this.y.setText(this.nhi.nkc.mPkUserNickname);
            this.nhk.setVisibility(0);
            this.nkF.setVisibility(8);
            return;
        }
        if (this.nkp != null) {
            this.nkp.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.nhk.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.nhi != null && this.nhi.nkc != null && this.nhi.nkc.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.nmo > 0 && this.nlx != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nlx.getLayoutParams();
                if (layoutParams.height != this.nmo) {
                    layoutParams.height = this.nmo;
                    this.nlx.setLayoutParams(layoutParams);
                }
            }
            this.nko = ((int) (tv.chushou.zues.utils.a.gw(this.nnG).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nnG, 84.0f);
            b(this.nko, 12);
        } else {
            if (this.nlx != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nlx.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nnG, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nnG, 250.0f);
                    this.nlx.setLayoutParams(layoutParams2);
                }
            }
            this.nko = ((int) (tv.chushou.zues.utils.a.gw(this.nnG).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nnG, 84.0f);
            b(this.nko, 12);
        }
        if (this.nhj != null) {
            this.nhj.a(this.nmo + tv.chushou.zues.utils.a.dip2px(this.nnG, 52.0f), this.aq);
        }
        if (this.nhn != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nhn.getLayoutParams();
            layoutParams3.bottomMargin = this.nmo + tv.chushou.zues.utils.a.dip2px(this.nnG, 52.0f);
            this.nhn.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dKe();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dKe();
    }

    private void dKd() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKe() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dKA().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.nme = tv.chushou.zues.utils.a.gx(this.nnG);
        this.dD = 86;
        this.nmd = (Math.max(this.nme.x, this.nme.y) - tv.chushou.zues.utils.a.dip2px(this.nnG, (this.dD + 52) + 250)) - this.nls;
        this.dC = Math.max(this.nme.x, this.nme.y) - ((tv.chushou.zues.utils.a.dip2px(this.nnG, this.dD) + this.nls) * 2);
        if (this.nmf <= 0 || this.nmg <= 0) {
            this.nmf = Math.min(this.nme.x, this.nme.y);
            this.nmg = Math.max(this.nme.x, this.nme.y);
        }
        this.ar = Math.min(this.nme.x, this.nme.y);
        this.aq = (this.ar * this.nmg) / this.nmf;
        boolean z = false;
        if (this.nhi == null || this.nhi.nkc == null) {
            i = 1;
        } else {
            i = this.nhi.nkc.mMode;
            if (this.nhi.nkc.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.dD = 42;
            if (i == 2) {
                if (this.nmg < this.nmf) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.nmf * layoutParams.height) / this.nmg;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, this.dD) + this.nls;
            layoutParams.gravity = 48;
            this.nmo = ((this.nme.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nnG, (this.dD + 52) + 64) + this.nls)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            dJO();
        } else if (this.E) {
            this.dD = 42;
            if (this.nmg < this.nmf) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.nmf * layoutParams.height) / this.nmg;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, this.dD) + this.nls;
            layoutParams.gravity = 48;
            this.nmo = ((this.nme.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nnG, (this.dD + 52) + 98) + this.nls)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            dKd();
        } else {
            this.nmo = -1;
            this.dD = 86;
            if (this.aq <= this.nmd) {
                layoutParams.width = this.ar;
                layoutParams.height = this.nmd;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, this.dD) + this.nls;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.dC) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, this.dD) + this.nls;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.nme.x, this.nme.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.nmf) / this.nmg >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nmf) / this.nmg;
                    } else if ((this.ar * this.nmg) / this.nmf >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.nmg) / this.nmf;
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
                    if ((this.ar * this.nmg) / this.nmf > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.nmf) / this.nmg;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.nmg) / this.nmf;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.nmg) / this.nmf;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.nmf) / this.nmg;
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
        if (this.nnF != null && this.nnF.d) {
            layoutParams.width = Math.min(this.nme.x, this.nme.y);
            layoutParams.height = Math.max(this.nme.x, this.nme.y);
        }
        dKA().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dKf() {
        this.N = new SurfaceRenderView(this.nnG);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dKA().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.nlY) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dKu();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dKt();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.nmR != null) {
            this.nmR.a();
        }
        if (this.nnF != null && !h.isEmpty(this.nnF.w)) {
            b(this.nnF.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.nkb != null) {
            int width = this.nkb.getWidth();
            int height = this.nkb.getHeight();
            if (this.nmf != width || this.nmg != height || this.nmf <= 0 || this.nmg <= 0) {
                this.nmf = width;
                this.nmg = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dKe();
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
            if (this.nlT) {
                dKh();
            } else {
                if (this.nnG.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击送礼_num", "竖屏", new Object[0]);
                if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnF.dJB().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.cO) {
                f(this.nkQ.getText().toString());
            } else {
                a(this.nkQ.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dIP().c) {
                com.kascend.chushou.d.h.dIP().b(false);
                this.nkM.cancel();
                this.nkM.reset();
                this.nkN.clearAnimation();
                this.nkO.setVisibility(8);
            }
            m(view, 0, this.nnq.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nnG, 165.0f) / 2);
            l(view, x >= 0 ? x : 0, this.nnq.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.nnF.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.nnF.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nlx != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.nly != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.nlX = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nnG, (JSONObject) null, this.nnF.dJE().mRoomID, this.nnF.dJE().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.nnG.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nnG, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.nma != null) {
                    com.kascend.chushou.d.e.a(this.nnG, this.nma, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.nmr != null) {
                    this.nmr.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nnG, null) && this.nnF != null && this.nnF.ngQ != null) {
                    if (this.cO) {
                        dKy();
                    } else {
                        if (this.nnF != null && this.nnF.ngQ != null && this.nnF.ngQ.count > 0) {
                            this.nli.setVisibility(8);
                        } else {
                            this.nli.setVisibility(0);
                        }
                        this.cO = true;
                        this.nlp.setBackgroundResource(a.e.ic_trumpet_p);
                        this.nlq.setVisibility(0);
                        this.nlq.setSelected(true);
                        this.nlq.setTextColor(Color.parseColor("#ff5959"));
                        if (this.nkQ != null) {
                            this.nkQ.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.nlr <= 9) {
                    this.nlr++;
                    this.nlo.setText(this.nlr + "");
                }
                dJP();
            } else if (id == a.f.tv_cut_count) {
                if (this.nlr > 1) {
                    this.nlr--;
                    this.nlo.setText(this.nlr + "");
                }
                dJP();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.nmu.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.nmu.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.nmv.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dF(this.nmu);
                    this.nok.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.nhl != null && !h.isEmpty(this.nhl.eventUrl)) {
                    f("", this.nhl.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.nhl != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.nhl != null) {
                    com.kascend.chushou.d.a.a(this.nnG, (JSONObject) null, this.nhl.roomId, this.nhl.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.nnF.a(false);
                    ((VideoPlayer) this.nnG).l();
                } else {
                    ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.nlh != null) {
            int i = (tv.chushou.zues.utils.a.gw(this.nnG).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nlh.getLayoutParams();
            layoutParams.topMargin = i;
            this.nlh.setLayoutParams(layoutParams);
            this.nlh.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.nlh.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
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
        } else if (System.currentTimeMillis() - this.nlW <= 3000) {
            tv.chushou.zues.utils.g.LI(a.i.str_too_fast);
            return false;
        } else {
            dxD();
            if (!com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a(((VideoPlayer) this.nnG).dJb().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.nlW = System.currentTimeMillis();
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                a(this.nnF.dJB().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.nnF.h);
            }
            g(this.b);
            if (!z && this.nkQ != null) {
                this.nkQ.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dxD();
            if (com.kascend.chushou.d.e.c(this.nnG, null) && LoginManager.Instance().getUserInfo() != null && this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                a(this.nnF.dJB().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.nkQ != null) {
                this.nkQ.setText((CharSequence) null);
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
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nnF.dJB().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.nnF.dJB().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nnG).nfg;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Te(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.nof != null && this.nof.isShowing()) {
            this.nof.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
        if (this.noD == null) {
            i(3);
        }
        this.noD.getContentView().setBackgroundResource(0);
        this.noD.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.noD.isShowing()) {
            this.noD.showAtLocation(view, 83, i, i2);
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.nnF.dJB().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.noD.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dKa() {
        if (h.isEmpty(this.noH)) {
            if (((VideoPlayer) this.nnG).q) {
                this.noG.zs(a.e.ic_room_set_btn_white);
            } else {
                this.noG.zs(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nnG).q && this.noH.size() == 2 && this.noH.contains("4") && this.noH.contains("2")) {
            this.noG.zs(a.e.ic_room_set_btn_system_white);
        } else if (this.noH.size() > 1 || !((VideoPlayer) this.nnG).q) {
            this.noG.zs(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.noH.get(0))) {
            this.noG.zs(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.noH.get(0))) {
            this.noG.zs(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.noH.get(0))) {
            this.noG.zs(a.e.ic_room_set_btn_system_white);
        }
    }

    private void m(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
        if (this.nof == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.nof.getContentView().setBackgroundResource(0);
            this.nof.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nof.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nkN.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.nof.isShowing()) {
            this.nof.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nnG, 16.0f) + i2);
            this.nkN.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.nnF.dJB().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.nof.dismiss();
    }

    private void du(View view) {
        if (this.nnZ == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.dIP().q()) {
            this.nkR.dWt();
        } else {
            this.nkR.dWu();
        }
        int height = this.nnq.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (view != null) {
            this.nnZ.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.nnZ == null) {
            View inflate = LayoutInflater.from(this.nnG).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.nkR = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dIP().q()) {
                this.nkR.dWt();
            } else {
                this.nkR.dWu();
            }
            this.nkR.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dIP().g(z);
                }
            });
            this.nnT = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.nnU = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nnT.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nnT.setVisibility(0);
            } else {
                this.nnT.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dIP().a) {
                this.nnU.b();
            } else {
                this.nnU.c();
            }
            if (this.nnF != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.nnF.f;
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
                                if (this.nhi == null || !this.nhi.nkc.mInPKMode || h.isEmpty(this.nhi.b) || this.nly == null || !this.nhi.b.equals(this.nly.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nnG).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dJC = this.nnF.dJC();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nnG).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnG, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, 5.0f);
                                            }
                                            int identifier = this.nnG.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nnG.getPackageName());
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
                                                if (dJC != null && dJC.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nnG.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nnG).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dJC2 = this.nnF.dJC();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nnG).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nnG, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, 5.0f);
                                        }
                                        int identifier2 = this.nnG.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nnG.getPackageName());
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
                                            if (dJC2 != null && dJC2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.nnZ.dismiss();
                    }
                }
            });
            this.nnZ = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 150.0f), -2);
            this.nnZ.setFocusable(true);
            this.nnZ.setOutsideTouchable(true);
            this.nnZ.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nnZ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nnZ = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
            if (this.nlg == null) {
                this.nlg = new f(getActivity());
            }
            this.nlg.a(this.nnF.dJB().mRoominfo, this.ax);
            if (!this.nlg.isShowing()) {
                this.nlg.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.nlY) {
            return false;
        }
        if (this.nlX == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.nmP = motionEvent.getX();
                    this.nmQ = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.nmP;
                    if (Math.abs(f) > Math.abs(y - this.nmQ) && Math.abs(f) > q && f > 0.0f) {
                        bj();
                        return true;
                    }
                    this.nmP = 0.0f;
                    this.nmQ = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.nmv != null && this.nmv.getVisibility() == 0 && b(motionEvent, this.nmv)) {
                this.nmv.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dF(this.nmu);
                return true;
            } else if (this.nlT && this.nmv != null && this.nmv.getVisibility() == 8 && f(this.nok.b, motionEvent)) {
                dKh();
                return true;
            } else if (this.nlh != null && this.nlh.b() && f(this.nlh, motionEvent)) {
                this.nlh.a();
                return true;
            } else if (this.nkX != null && this.nkX.b() && f(this.nkX, motionEvent)) {
                this.nkX.a();
                return true;
            } else if (b(motionEvent, this.nkP)) {
                return dxD();
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
            if (this.nox != null && this.nox.a(i, keyEvent)) {
                return true;
            }
            if ((this.nlh != null && this.nlh.onKeyDown(i, keyEvent)) || az()) {
                return true;
            }
            if (this.nlX == 3) {
                this.nlX = 1;
                bj();
                return true;
            } else if (this.nkX != null && this.nkX.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.nkQ != null && this.nkL != null && this.nkP != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.nkQ);
                this.nkL.setVisibility(8);
                this.nkP.setVisibility(0);
            }
        } else if (this.nkL != null && this.nkP != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
            this.nkL.setVisibility(0);
            this.nkP.setVisibility(8);
        }
    }

    public boolean dxD() {
        boolean z;
        b(this.nko, 12);
        boolean z2 = false;
        if (this.nik != null && this.nik.getVisibility() == 0) {
            this.nik.setVisibility(8);
            this.nil.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nim) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nnG);
            this.nil.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.nkP == null || this.nkP.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.cO) {
                dKy();
            }
            this.nkP.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.nkL != null) {
                    c.this.nkL.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean az() {
        if (dxD()) {
            return true;
        }
        if (this.nof != null && this.nof.isShowing()) {
            this.nof.dismiss();
            return true;
        } else if (this.noD != null && this.noD.isShowing()) {
            this.noD.dismiss();
            return true;
        } else if (this.nnZ == null || !this.nnZ.isShowing()) {
            return dKh() || dJY() || dKg() || dJN();
        } else {
            this.nnZ.dismiss();
            return true;
        }
    }

    public boolean dJN() {
        if (this.noo == null || !this.noo.isShown()) {
            return false;
        }
        this.noo.d();
        return true;
    }

    public boolean dJY() {
        if (this.nlV == null || !this.nlV.isShown()) {
            return false;
        }
        this.nlV.a();
        return true;
    }

    public boolean dKg() {
        if (this.nlh == null || !this.nlh.b()) {
            return false;
        }
        this.nlh.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nnG != null && !((Activity) this.nnG).isFinishing() && pVar != null) {
            this.nlG = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.nly != null && mVar.a(this.nly.mCreatorUID, null)) {
            this.nly.mIsSubscribed = mVar.c;
            dJT();
        }
    }

    public boolean dKh() {
        if (!this.nlT || this.nok == null) {
            return false;
        }
        if (this.nok != null) {
            this.nok.e();
        }
        if (this.nmu != null) {
            this.nmu.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.nmc != null) {
                        this.nmc.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                        this.nnF.dJB().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.nnF.dJB().mMicStatus.onMic) {
                            if (this.nkF != null) {
                                this.nkF.setVisibility(8);
                            }
                            if (this.nlV != null && this.nlV.isShown()) {
                                this.nlV.a();
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
                        if (this.nnF.dJB().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.nly != null && !h.isEmpty(this.nly.mCreatorUID)) {
                                g(arrayList2, this.nly.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.nnF.dJB().mMicStatus.onMic) {
                            if (this.nnF.dJB().mMicStatus != null && !h.isEmpty(this.nnF.dJB().mMicStatus.micRoomId) && !this.nnF.dJB().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.nnF.dJB().mMicStatus.micRoomId;
                            }
                            this.nnF.dJB().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.nnF.dJB().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.nnF.dJB().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.nnF.dJB().mMicStatus, str3, z4);
                            if (this.nlV != null && this.nlV.getVisibility() == 0) {
                                this.nlV.a(this.nnF.dJB().mFanItems, this.nnF.dJB().mMicStatus, str3, z4, this.nnF.dJB().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.nkF != null) {
                                this.nkF.setVisibility(8);
                            }
                            if (this.nlV != null && this.nlV.isShown()) {
                                this.nlV.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.nlu != onlineVip.mCount || (this.nkD != null && this.nkD.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.nlu = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dKl();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.nlS.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.nlS.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.nlS.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.nml <= 5000) {
                                z2 = false;
                            } else {
                                this.nml = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.nlS.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.nlS.addAll(onlineVip.mOnlineVipItems);
                            }
                            dJU();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.nmm != null) {
                    if (this.nly == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.nly.mCreatorAvatar;
                        str2 = this.nly.mCreatorGender;
                    }
                    this.nmm.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.nhi != null && this.nhi.nkc != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.nhi.nkc.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.nhe != null) {
                                        this.nhe.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.nhi.nkc.mInPKMode = true;
                                    this.nhi.nkc.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhi.nkc.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhi.nkc.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhi.nkc.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhi.nkc.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhi.nkc.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.nhi.nkc.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.nhi.nkc.mMode = pkNotifyInfo.mMode;
                                    this.nhi.nkc.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.nhj != null) {
                                        this.nhj.g(true, this.nhi.nkc.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dIP().a) {
                                        if (!com.kascend.chushou.b.dII().e) {
                                            com.kascend.chushou.b.dII().e = true;
                                            tv.chushou.zues.utils.g.F(this.nnG, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dIP().a(this.nnG, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.nhi.nkc.mAction = 7;
                                    this.nhi.nkc.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.nhi.nkc.mPkUid = pkNotifyInfo.mPkUid;
                                    this.nhi.nkc.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.nhi.nkc.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.nhi.nkc.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.nhi.nkc.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.nhi.nkc.mMode == 2) {
                                        dKe();
                                    } else {
                                        dJO();
                                    }
                                    if (this.nhj != null) {
                                        this.nhj.g(false, 0L);
                                        this.nhj.b(this.nhi.nkc, true);
                                        this.nhj.a(this.nmo + tv.chushou.zues.utils.a.dip2px(this.nnG, 52.0f), this.aq);
                                        this.nhj.a(this.nhi.nkc.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.nhe != null) {
                                        this.nhe.a(false);
                                    }
                                    this.nhi.nkc.mInPKMode = false;
                                    this.nhi.nkc.mAction = 2;
                                    dJO();
                                    dKe();
                                    if (this.nhj != null) {
                                        this.nhj.c();
                                    }
                                    this.nhi.b = null;
                                    this.nhi.nkc = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.nhi.nkc.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.nhi.nkc.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.nhi.nkc.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.nly != null && !h.isEmpty(this.nly.mRoomID) && this.nly.mRoomID.equals(this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.nhi.nkc.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.nhj != null) {
                                        this.nhj.a(this.nhi.nkc, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.nhi.nkc.copyUpdate(pkNotifyInfo);
                                    if (this.nhj != null) {
                                        this.nhj.a(this.nhi.nkc);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.nhi.nkc.copyStop(pkNotifyInfo);
                                        if (this.nhj != null) {
                                            this.nhj.A(this.nhi.nkc.mMaxFreeDuration, this.nhi.nkc.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.nhi.nkc.copyResult(pkNotifyInfo);
                                    if (!this.nlQ && this.nhj != null) {
                                        int i7 = 1;
                                        if (this.nhi.nkc.destinyInfo != null && this.nhi.nkc.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.nhj.a(h.parseInt(this.nhi.nkc.mResult), h.parseLong(this.nhi.nkc.mvpUid), this.nhi.nkc.mvpAvatar, this.nhi.nkc.mvpNickname, this.nhi.nkc.mMaxFreeDuration, this.nhi.nkc.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.nhl != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.nhl.uid = cycleLiveRoomInfo.uid;
                        this.nhl.remainTime = cycleLiveRoomInfo.remainTime;
                        this.nhl.roomId = cycleLiveRoomInfo.roomId;
                        this.nhl.avatar = cycleLiveRoomInfo.avatar;
                        this.nhl.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nnG != null && (this.nnG instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nnG).d();
                        }
                    } else {
                        ((VideoPlayer) this.nnG).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.nnF != null && this.nnF.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dIP().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dIP().b().equals(next2.mUserID)) {
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

    public void dKl() {
        if (this.nkD != null) {
            if (this.nhi == null || this.nhi.nkc == null || !this.nhi.nkc.mInPKMode) {
                if (this.bP > 0) {
                    this.nkD.setVisibility(0);
                    this.nkD.setText(String.format(this.nnG.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.nkH.setVisibility(0);
                    return;
                }
                this.nkD.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.nkF.setVisibility(0);
            if (this.nkG != null) {
                this.nkG.a(str, z, micStatus, this.nnF.dJB().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.nkF.setVisibility(8);
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
        int childCount = this.nlA.getChildCount();
        int itemCount = this.nlA.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nlA);
        if (f + childCount >= itemCount) {
            this.nlH = true;
            if (this.nlI != null) {
                this.nlI.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dKo() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.nlB.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.nlB.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.nlB == null) {
            this.nlB = new ArrayList<>();
        }
        while (2 < this.nlB.size()) {
            this.nlB.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.nlD);
        if (a2 == null) {
            w(false);
            return;
        }
        this.nlB.addAll(a2);
        int size = this.nlB.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.nlB.size(); i++) {
                this.nlB.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.nlE == null) {
            this.nlE = new ArrayList<>();
        }
        this.nlE.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.nlG != null && this.nlG.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.nlG.contains("2"))) {
                        this.nlE.add(next);
                    } else if (!this.nlG.contains(next.mType)) {
                        this.nlE.add(next);
                    }
                }
                return this.nlE;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.nlB == null) {
                    this.nlB = new ArrayList<>(arrayList);
                    dKo();
                    w(z2);
                    return;
                }
                if (this.nlD == null) {
                    this.nlD = new ArrayList<>();
                }
                this.nlD.addAll(arrayList);
                int size = this.nlD.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.nlD.size(); i++) {
                        this.nlD.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.nlB.size();
                if (a2 != null) {
                    this.nlB.addAll(a2);
                }
                int size3 = this.nlB.size();
                if (!this.nlH && this.nlI != null) {
                    this.nlI.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.nlB.size(); i3++) {
                        this.nlB.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.nlB == null) {
                this.nlB = new ArrayList<>(arrayList);
                dKo();
            } else {
                if (this.nlD == null) {
                    this.nlD = new ArrayList<>();
                }
                this.nlD.clear();
                this.nlD.addAll(arrayList);
                this.nlB.clear();
                dKo();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.nlB.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.nlF != null) {
                this.nlF.a(this.nlB.size());
                if (i == 1) {
                    this.nlF.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nlF.notifyItemRangeRemoved(i2, i3);
                    this.nlF.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nlF.notifyDataSetChanged();
                }
            }
            if (z || this.nlH) {
                this.nlH = true;
                if (this.nlI != null) {
                    this.nlI.setVisibility(8);
                }
                if (z) {
                    this.nlx.scrollToPosition(this.nlB.size() - 1);
                } else {
                    this.nlx.smoothScrollToPosition(this.nlB.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.nlF != null) {
                this.nlF.a(this.nlB.size());
                this.nlF.notifyDataSetChanged();
            }
            if (z || this.nlH) {
                this.nlH = true;
                if (this.nlI != null) {
                    this.nlI.setVisibility(8);
                }
                if (z) {
                    this.nlx.scrollToPosition(this.nlB.size() - 1);
                } else {
                    this.nlx.smoothScrollToPosition(this.nlB.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dJm;
        RoomToast roomToast;
        this.p = false;
        if (this.nnF != null && this.nnF.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.nnF.f.size()) {
                    break;
                } else if (!"2".equals(this.nnF.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dKs();
            return;
        }
        if (this.nhy != null) {
            this.nhy.setVisibility(0);
        }
        if (this.nkt != null) {
            this.nkt.setVisibility(0);
        }
        if (this.nnF != null) {
            this.nly = this.nnF.dJE();
            this.nlz = this.nnF.dJB();
            if (com.kascend.chushou.b.dII().c != null && this.nlF != null) {
                this.nlF.a(com.kascend.chushou.b.dII().c);
                this.nlF.notifyDataSetChanged();
            }
            FullRoomInfo dJB = this.nnF.dJB();
            if (dJB != null) {
                if (!h.isEmpty(dJB.mRoomToastList)) {
                    Iterator<RoomToast> it = dJB.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dIP().j())) {
                    a(roomToast);
                }
            }
            if (this.nly != null) {
                dKv();
            }
            if (this.nly != null && !this.nly.mIsSubscribed) {
                RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.nly == null || !c.this.nly.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.nnF != null && this.nnF.l()) {
                d(true);
            }
        }
        if (this.nly != null && this.nlF != null) {
            if (this.nlB != null) {
                this.nlB.clear();
            } else {
                this.nlB = new ArrayList<>();
            }
            this.nlF.a(this.nly);
            dKo();
            this.nlF.a(this.nlB.size());
            this.nlF.notifyDataSetChanged();
        }
        dJS();
        N();
        if (this.nnG != null && (this.nnG instanceof VideoPlayer) && (dJm = ((VideoPlayer) this.nnG).dJm()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dJm.nkc, dJm.b);
        }
        this.nkU.h(this.nly.mCreatorAvatar, com.kascend.chushou.view.a.a(this.nly.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.nkY);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.nlt == null) {
            View inflate = LayoutInflater.from(this.nnG).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.niP = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.nlt = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nnG, 160.0f), -2);
            this.nlt.setFocusable(false);
            this.nlt.setOutsideTouchable(false);
            this.nlt.setAnimationStyle(a.j.gift_toast_style);
            this.nlt.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dIP().c(roomToast.mToastContent);
            if (this.nlt == null) {
                bd();
            }
            if (this.niP != null) {
                this.niP.setText(roomToast.mToastContent);
            }
            if (!this.nlt.isShowing()) {
                if (this.nkY != null) {
                    this.nlt.showAtLocation(this.nkY, 85, 0, this.nnq.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.nlt != null) {
                                c.this.nlt.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.nlt.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.nmi != null) {
            this.nmi.setVisibility(z ? 0 : 8);
        }
        this.dJ = true;
        if (this.nnG instanceof VideoPlayer) {
            ((VideoPlayer) this.nnG).p();
        }
    }

    private void dKs() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nnG).s();
        dJN();
        dJY();
        if (this.nkJ == null) {
            this.nkJ = (PlayShowRecommendView) ((ViewStub) this.nnq.findViewById(a.f.view_recommend)).inflate();
        }
        this.nkJ.setVisibility(0);
        if (this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null && !h.isEmpty(this.nnF.dJB().mRoominfo.mRoomID)) {
            dKm();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.nok != null) {
            this.nok.e();
        }
        if (this.nhy != null) {
            this.nhy.setVisibility(4);
        }
        if (this.nkt != null) {
            this.nkt.setVisibility(8);
        }
        if (this.nos != null) {
            this.nos.dVQ();
            this.nos.setVisibility(8);
        }
        m(false);
        a(false, false);
        if (this.nhe != null) {
            this.nhe.a();
        }
    }

    private void dKm() {
        if (this.nkJ != null && this.nkJ.getVisibility() == 0) {
            this.nkJ.a(this.nnF.dJB().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dKc() {
        super.dKc();
        if (this.nnG instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.nlh != null && this.nlh.b()) {
            this.nlh.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.nlU);
        if (this.nnG != null) {
            if (this.nlU || "10004".equals(((VideoPlayer) this.nnG).t)) {
                this.nlU = true;
                if (this.nnF != null) {
                    this.nnF.f = null;
                    if (this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                        this.nnF.dJB().mRoominfo.mGameId = null;
                    }
                }
                dKs();
                return;
            }
            this.nlU = true;
            if (this.nnG != null) {
                ((VideoPlayer) this.nnG).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.nlU = false;
        if (this.nhy != null) {
            this.nhy.setVisibility(0);
        }
        if (this.nkt != null) {
            this.nkt.setVisibility(0);
        }
        if (this.nkJ != null) {
            this.nkJ.setVisibility(8);
        }
        if (this.nnA != null) {
            this.nnA.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.nlU = false;
        if (this.nhy != null) {
            this.nhy.setVisibility(0);
        }
        if (this.nkt != null) {
            this.nkt.setVisibility(0);
        }
        if (this.nkJ != null) {
            this.nkJ.setVisibility(8);
        }
        if (this.nnA != null) {
            this.nnA.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.nkJ != null) {
            this.nkJ.setVisibility(8);
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
                    if (this.nnF != null) {
                        this.nnF.f = null;
                        this.nnF.dJB().mRoominfo.mGameId = null;
                    }
                    dKs();
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
        if (this.nnF != null && this.nnF.dJC() != null) {
            a(this.nnF.dJC());
        }
        this.p = false;
        if (this.nnF == null || this.nnF.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.nnF.f.size()) {
                if (!"2".equals(this.nnF.f.get(i2).mType)) {
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
    public GiftAnimationLayout dJW() {
        if (this.nnq == null) {
            return null;
        }
        return (GiftAnimationLayout) this.nnq.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.nkY != null) {
            int size = iconConfig.configs.size();
            this.nkY.removeAllViews();
            if (this.nla != null) {
                this.nla.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nnG).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.nkY, false);
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
                            this.nla.setVisibility(0);
                            this.nkZ.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.nkY.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void D() {
        if (this.nnG instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dJh = ((VideoPlayer) this.nnG).dJh();
            if (this.nox == null) {
                this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nox.setVisibility(0);
            this.nox.a(2, dJh);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.nlc != null && this.nnG != null) {
            this.nlc.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nlc != null && this.nnG != null) {
            this.nlc.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(long j) {
        if (this.nlc != null) {
            this.nlc.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0827a
    public void c(int i) {
        if (this.nlc != null) {
            this.nlc.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void a(int i) {
        if (this.nlb != null) {
            if (this.nnG != null) {
                this.nlb.a(((VideoPlayer) this.nnG).dJh(), false);
            }
            this.nlb.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nnq != null) {
            Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
            int i = gw.x > gw.y ? 1 : 2;
            if (this.nox == null) {
                this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.nox.setPlayerViewHelper(this.nnF);
            this.nox.setVisibility(0);
            this.nox.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.nld != null) {
            this.nld.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.nld != null) {
            this.nld.a(bangInfo, str);
        }
        if (this.nhM != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nhM.setText(this.nnG.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nhM.setText(this.nnG.getString(a.i.str_contribute_tittle));
            } else {
                this.nhM.setText(Html.fromHtml(this.nnG.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.nkE != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.nkE.setText(this.nnG.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.nkE.setText(this.nnG.getString(a.i.str_contribute_tittle));
            } else {
                this.nkE.setText(Html.fromHtml(this.nnG.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nld != null) {
            this.nld.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.nnF != null && !h.isEmpty(this.nnF.ngP)) {
            this.nma = this.nnF.ngP.get(0);
            if (this.nmp != null) {
                this.nmp.setVisibility(0);
                this.nmp.a(this.nma.mCover, 0, 0, 0, 1);
                if (this.nmq != null) {
                    if (this.nma.mShowClose) {
                        this.nmq.setVisibility(0);
                    } else {
                        this.nmq.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.nld != null) {
            this.nld.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.nnq != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.nik != null) {
            this.nik.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.nlQ) {
            if (iVar.a == 52) {
                if (this.nlF != null) {
                    this.nlF.a(com.kascend.chushou.b.dII().c);
                    this.nlF.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.nlQ && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.nkQ != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.nkQ);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.nlQ) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nnG, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dJi = ((VideoPlayer) this.nnG).dJi();
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(2, dJi);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dJj = ((VideoPlayer) this.nnG).dJj();
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(2, dJj);
            } else if (bVar.a == 8) {
                if (this.nmc != null && this.nmc.getVisibility() != 0) {
                    this.nmc.a(a.C0814a.slide_in_bottom_danmu_anim, a.C0814a.slide_out_bottom_danmu_anim, this.nly == null ? "" : this.nly.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.nox == null) {
                    this.nox = (H5Container) ((ViewStub) this.nnq.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.nox.setVisibility(0);
                this.nox.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.nnF != null && !h.isEmpty(this.nnF.a) && this.nnF.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nmc != null && this.nmc.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nnG, 80.0f);
                }
                if (this.nmb != null && this.nmb.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nmb.getHeight());
                }
                this.nmk.setTranslationY(-r0);
                return;
            }
            if (this.nmj != null) {
                this.nmj.cancel();
                this.nmj = null;
            }
            int translationY = (int) this.nmk.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nnG, 80.0f) : 0;
                    if (this.nmb != null && this.nmb.getVisibility() == 0) {
                        r0 = Math.max(r0, this.nmb.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.nmb.getHeight() : 0;
                    if (this.nmc != null && this.nmc.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nnG, 80.0f));
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
        this.nmj = ValueAnimator.ofInt(i, i2);
        this.nmj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.nld != null) {
                    c.this.nmk.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.nmj.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.nmj = null;
            }
        });
        this.nmj.setInterpolator(new LinearInterpolator());
        this.nmj.setDuration(800L);
        this.nmj.start();
    }

    private boolean dKt() {
        if (this.nlX == 1) {
            this.nlX = 2;
            x(true);
            return true;
        } else if (this.nlX == 3) {
            bj();
            return true;
        } else {
            return false;
        }
    }

    private boolean dKu() {
        if (this.nlX == 1) {
            return bi();
        }
        if (this.nlX == 2) {
            this.nlX = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.nlY || this.nnF == null || this.nnF.dJE() == null) {
            return false;
        }
        if (this.nmR != null) {
            this.nmR.a(true);
        }
        this.nlX = 3;
        this.nlY = true;
        dKv();
        this.nkq.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.nlY = false;
                c.this.nks.setVisibility(8);
            }
        });
        this.nks.startAnimation(loadAnimation);
        this.nkq.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj() {
        if (!this.nlY) {
            if (this.nmR != null) {
                this.nmR.a(false);
            }
            this.nlX = 1;
            this.nlY = true;
            dKv();
            this.nks.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.nlY = false;
                    c.this.nkq.setVisibility(8);
                }
            });
            this.nks.startAnimation(loadAnimation);
            this.nkq.startAnimation(loadAnimation2);
        }
    }

    private void dKv() {
        if (this.nnq != null) {
            if (this.nkq == null) {
                this.nkq = this.nnq.findViewById(a.f.user_space_container);
            }
            if (this.nks == null) {
                this.nks = this.nnq.findViewById(a.f.video_container);
            }
            if (this.nkr == null) {
                this.nkr = com.kascend.chushou.view.user.b.b(null, this.nnF.a, false, this.nnF.h);
                this.nkr.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
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
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.nkr).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.nkt != null) {
            this.nkt.setVisibility(z ? 8 : 0);
        }
        if (this.nlv != null) {
            this.nlY = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.nlv.setVisibility(8);
                        c.this.nlY = false;
                    }
                });
            } else {
                this.nlY = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.nlv.setVisibility(0);
                        c.this.nlY = false;
                    }
                });
            }
            this.nlv.startAnimation(loadAnimation);
        }
        az();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.nkK.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.nkS != null) {
                this.nkS.setVisibility(0);
            }
            if (this.nkT != null) {
                this.nkT.a();
                return;
            }
            return;
        }
        if (this.nkV != null) {
            this.nkV.setVisibility(0);
        }
        if (this.nkW != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.nkW.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.nkV != null) {
            this.nkV.setVisibility(8);
        }
        if (this.nkW != null) {
            this.nkW.clearAnimation();
        }
        if (this.nkS != null) {
            this.nkS.setVisibility(8);
        }
        if (this.nkT != null) {
            this.nkT.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.nlv != null && this.nnq != null) {
            if (this.nmc == null) {
                this.nmc = new com.kascend.chushou.player.ui.miniview.a(this.nnG, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.nmc != null && c.this.nnq != null && c.this.nmc.a()) {
                            ((ViewGroup) c.this.nnq).removeView(c.this.nmc);
                            c.this.nmc = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nmc.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nnG, 52.0f);
                this.nmc.setLayoutParams(layoutParams);
                ((ViewGroup) this.nlv).addView(this.nmc, ((ViewGroup) this.nlv).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.nmc.setVisibility(8);
                } else {
                    this.nmc.a(a.C0814a.slide_in_bottom_danmu_anim, a.C0814a.slide_out_bottom_danmu_anim, this.nnF.a == null ? "" : this.nnF.a);
                }
            } else if (!this.nmc.isShown()) {
                this.nmc.a(a.C0814a.slide_in_bottom_danmu_anim, a.C0814a.slide_out_bottom_danmu_anim, this.nnF.a == null ? "" : this.nnF.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.nmh != null && !h.isEmpty(listItem.mPackIcon)) {
                this.nmh.setVisibility(0);
                this.nmh.setAnim(true);
                this.nmh.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.olV, b.C0943b.olX, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.nlJ != null && this.nlJ.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dKw();
                    }
                });
                this.nlJ.setVisibility(0);
                this.nlJ.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.nlJ != null && this.nlJ.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.nlL != null) {
                        c.this.nlL.removeAllListeners();
                        c.this.nlL.cancel();
                        c.this.nlL = null;
                    }
                    if (c.this.nlJ != null) {
                        c.this.nlJ.setVisibility(8);
                    }
                }
            });
            this.nlJ.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.nmn == null) {
                this.nmn = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nnG, "显示双击666_num", null, new Object[0]);
                            if (c.this.nnF != null) {
                                c.this.nnF.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.nnH != null) {
                    this.nnH.e(this.nmn, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.nmn != null) {
            this.nnH.P(this.nmn);
            this.nmn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.nlM != null && this.nlM.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nnG, a.C0814a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dKx();
                    }
                });
                this.nlM.setVisibility(0);
                this.nlM.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.nnp, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.nlM != null && this.nlM.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nnG, a.C0814a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
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

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dKw() {
        if (this.nlJ == null || this.nlK == null) {
            return null;
        }
        if (this.nlL != null) {
            this.nlL.removeAllListeners();
            this.nlL.cancel();
            this.nlL = null;
        }
        this.nlK.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.nlK, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.nlK, 0.0f);
        int measuredWidth = (this.nlJ.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nnG, 13.0f) * 2)) - this.nlK.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nlK, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nlK, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nlK, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nlL != null) {
                    c.this.nlL.removeAllListeners();
                    c.this.nlL.cancel();
                    c.this.nlL = null;
                }
                RxExecutor.postDelayed(c.this.nnp, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dKw();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nlL = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dKx() {
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
        int measuredWidth = (this.nlM.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nnG, 13.0f) * 2)) - this.nlN.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.nlN, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.nlN, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.nlN, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.nlO != null) {
                    c.this.nlO.removeAllListeners();
                    c.this.nlO.cancel();
                    c.this.nlO = null;
                }
                RxExecutor.postDelayed(c.this.nnp, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dKx();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nlO = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.nmR = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.nhl != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.nhl.isSubscribe;
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
                            if (c.this.nhl != null) {
                                c.this.nhl.isSubscribe = !z;
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
                com.kascend.chushou.c.c.dIL().a(bVar, (String) null, this.nhl.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nhl.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dIL().b(bVar, (String) null, c.this.nhl.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.nnF != null && this.nly != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.nnF.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nnF.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.nly.mIsSubscribed;
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
                            c.this.nly.mIsSubscribed = !z;
                            c.this.dJT();
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
                com.kascend.chushou.c.c.dIL().a(bVar, (String) null, this.nly.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.nly.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dIL().b(bVar, (String) null, c.this.nly.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.nkb != null) {
            int width = this.nkb.getWidth();
            int height = this.nkb.getHeight();
            if (this.nmf != width || this.nmg != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.nnq != null) {
            if (this.nkX == null) {
                this.nkX = (InteractionView) ((ViewStub) this.nnq.findViewById(a.f.view_interaction)).inflate();
                this.nkX.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.nkX.a();
                    }
                });
            }
            if (this.nkX != null) {
                this.nkX.b(configDetail);
                this.nkX.c();
                this.nkX.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dWD()) {
                tv.chushou.zues.utils.g.F(this.nnG, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nnG, null) && (this.nnG instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnF != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnG, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nnG, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.nnF != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nnG, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nnG, configDetail.mUrl, this.nnG.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nnG, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.nlT) {
                        dKh();
                        return;
                    }
                    if (this.nnG.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nnG, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.nnF != null && this.nnF.dJB() != null && this.nnF.dJB().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.nnF.dJB().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    du(this.nkY);
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
        if (this.nnG != null && !this.v && !h.isEmpty(str) && this.nly != null && str.equals(this.nly.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.nhi == null) {
                this.nhi = new com.kascend.chushou.player.e.a();
            }
            this.nhi.b = str;
            this.nhi.nkc.copy(pkNotifyInfo);
            if (this.nhi.nkc.mAction == 6) {
                if (this.nhe != null) {
                    this.nhe.a(true);
                }
                this.nhi.nkc.mInPKMode = true;
                this.u = this.nhi.nkc.mPkId;
            } else if (this.nhi.nkc.mAction == 7 || (this.nhi.nkc.mMode == 1 && this.nhi.nkc.mAction == 5)) {
                if (this.nhe != null) {
                    this.nhe.a(true);
                }
                this.nhi.nkc.mInPKMode = true;
                if (this.dD != 42) {
                    this.nmo = ((this.nme.y - ((this.nme.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nnG, 158.0f) + this.nls)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
                    dKe();
                }
                this.u = this.nhi.nkc.mPkId;
                if (this.nhj != null) {
                    this.nhj.b(this.nhi.nkc, false);
                    this.nhj.a(this.nhi.nkc.mMode, (String) null);
                    if (this.nhi.nkc.mAction == 5 && this.nhi.nkc.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.nhi.nkc.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.nhi.nkc.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.nhi.nkc.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.nhi.nkc.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.nhi.nkc.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.nhj.a(this.nhi.nkc);
                        this.nhj.a(parseInt, this.nhi.nkc.mPkUpdateInfo.remainDuration, j, this.nhi.nkc.mMode, (this.nhi.nkc.destinyInfo == null || this.nhi.nkc.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.nhi.nkc.mPkUpdateInfo != null && !h.isEmpty(this.nhi.nkc.mPkUpdateInfo.specialMomentList) && this.nhj != null) {
                    this.nhj.a(this.nhi.nkc, true);
                }
                if (this.nhi.nkc.mMode == 2) {
                    dKe();
                } else {
                    dJO();
                }
            } else {
                this.nhi.nkc.mInPKMode = false;
                if (this.nhi.nkc.mMode == 2) {
                    dKe();
                } else {
                    dJO();
                }
            }
        }
    }

    public void dJO() {
        aV();
        aU();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.nlq != null && this.nnF != null && this.nnF.ngQ != null) {
            this.nlq.setText(tv.chushou.zues.utils.b.LH(this.nnF.ngQ.count));
            this.nlq.setVisibility(0);
            if (this.nnF.ngQ.count < 1) {
                dKy();
            }
            if (this.nlj != null) {
                this.nlj.setText(this.nnF.ngQ.primaryName);
            }
            if (this.nlk != null) {
                this.nlk.setText(this.nnF.ngQ.desc);
            }
            dJP();
        }
    }

    public void dJP() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.nlr * h.parseLong(this.nnF.ngQ.point)));
        if (this.niE != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nnG.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.nnG, a.e.icon_coin_new);
            cVar.append(this.nnG.getString(a.i.str_buy_count_coin2));
            this.niE.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.nnG, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.nlr);
        }
    }

    private void dKy() {
        this.cO = false;
        this.nlp.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.nnF != null && this.nnF.ngQ != null) {
            if (this.nnF.ngQ.count < 1) {
                this.nlq.setVisibility(8);
            } else {
                this.nlq.setVisibility(0);
                this.nlq.setSelected(false);
                this.nlq.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.nli.setVisibility(8);
        if (this.nkQ != null) {
            this.nkQ.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.nhn != null) {
            if (z) {
                this.nhn.setVisibility(0);
            } else {
                this.nhn.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.nmO != null) {
            this.nmO.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.nkZ != null) {
            this.nkZ.performClick();
        }
    }
}
