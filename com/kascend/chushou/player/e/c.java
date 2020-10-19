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
    private View ojI;
    public String ojP;
    private TextView ojT;
    private TextView ojW;
    private TextView okL;
    private TextView okW;
    private View okZ;
    private ImageView okc;
    private TextView okl;
    private KPSwitchPanelLinearLayout okt;
    private ImageView oku;
    private tv.chushou.zues.widget.kpswitch.b.c okv;
    private d.a okw;
    private TextView olW;
    private FrameLayout omA;
    private LinearLayout omB;
    private RelativeLayout omC;
    private FrescoThumbnailView omD;
    private TextView omE;
    private TextView omF;
    private TextView omG;
    private FrescoThumbnailView omH;
    private TextView omI;
    private TextView omJ;
    private TextView omK;
    private TextView omL;
    private LinearLayout omM;
    private PlayShowMicStatusView omN;
    private RecyclerView omO;
    private ImageView omP;
    private PlayShowRecommendView omQ;
    private View omR;
    private RelativeLayout omS;
    private AnimationSet omT;
    private ImageView omU;
    private ImageView omV;
    private RelativeLayout omW;
    private PastedEditText omX;
    private ToggleButton omY;
    private RelativeLayout omZ;
    private int omv;
    private View omw;
    private View omx;
    private com.kascend.chushou.view.user.b omy;
    private View omz;
    private PopupWindow onD;
    private View onF;
    private RecyclerView onH;
    private RoomInfo onI;
    private RecyclerView.LayoutManager onK;
    private ArrayList<ChatInfo> onL;
    private ArrayList<ChatInfo> onM;
    private ArrayList<ChatInfo> onN;
    private ArrayList<ChatInfo> onO;
    private Button onS;
    private View onT;
    private View onU;
    private Animator onV;
    private View onW;
    private View onX;
    private Animator onY;
    private PaoPaoView ona;
    private FrescoThumbnailView onb;
    private LinearLayout onc;
    private ImageView ond;
    private InteractionView onf;
    private LinearLayout ong;
    private FrescoThumbnailView onh;
    private FrameLayout oni;
    private RedpacketNotifier onj;
    private InteractNotifier onk;
    private EmbeddedButtonLayout onl;
    private GiftAnimationLayout onm;
    private com.kascend.chushou.player.b.a onn;
    private f ono;
    private PlayShowH5View onp;
    private LinearLayout onq;
    private TextView onr;
    private TextView ons;
    private TextView ont;
    private TextView onu;
    private TextView onv;
    private TextView onw;
    private ImageView onx;
    private TextView ony;
    private FrescoThumbnailView ooA;
    private ImageView ooB;
    private RelativeLayout ooC;
    private TextView ooD;
    private ImageView ooE;
    private EditText ooF;
    private View ooG;
    private RelativeLayout ooH;
    private RelativeLayout ooI;
    private FrescoThumbnailView ooJ;
    private TextView ooK;
    private TextView ooL;
    private ImageView ooM;
    private RelativeLayout ooN;
    private LinearLayout ooO;
    private TextView ooP;
    private TextView ooQ;
    private RelativeLayout ooR;
    private RelativeLayout ooS;
    private FrescoThumbnailView ooT;
    private TextView ooU;
    private TextView ooV;
    private ImageView ooW;
    private RelativeLayout ooX;
    private TextView ooZ;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> oob;
    private PlayShowMicPerson ooe;
    private FoodView ooi;
    public ListItem ooj;
    private FoodView ook;
    private com.kascend.chushou.player.ui.miniview.a ool;
    private int oom;
    private int oon;
    private Point ooo;
    private FrescoThumbnailView oor;
    private FrescoThumbnailView oos;
    private ValueAnimator oou;
    private LinearLayout oov;
    private long oow;
    private VideoShowVoteView oox;
    private Runnable ooy;
    private float opa;
    private float opb;
    private a opc;
    private boolean cp = false;
    private int onz = 1;
    private boolean onA = false;
    private int onB = 0;
    private int onC = 0;
    private int onE = -1;
    private boolean onG = false;
    private FullRoomInfo onJ = null;
    private com.kascend.chushou.player.adapter.a onP = null;
    private ArrayList<String> onQ = null;
    private boolean onR = true;
    private boolean onZ = true;
    private boolean ooa = false;
    public final List<OnlineVipItem> bv = new ArrayList();
    private boolean ooc = false;
    private boolean ood = false;
    private long oof = 0;
    private int oog = 1;
    private boolean ooh = false;
    private int oop = -1;
    private int ooq = -1;
    private boolean oot = false;
    private int ooz = -1;
    private io.reactivex.disposables.b ooY = null;

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
        this.ojP = getArguments().getString("cover");
        this.onZ = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.opD = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.opD;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!aa()) {
            ehi();
            this.omi = ((VideoPlayer) this.opS).egs();
            this.opR = ((VideoPlayer) this.opS).egv();
            d(view);
            ehs();
            if (this.opS instanceof VideoPlayer) {
                ((VideoPlayer) this.opS).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ooa = false;
        if (this.oqx != null) {
            this.oqx.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ooa = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.onV != null) {
            this.onV.removeAllListeners();
            this.onV.cancel();
            this.onV = null;
        }
        if (this.onY != null) {
            this.onY.removeAllListeners();
            this.onY.cancel();
            this.onY = null;
        }
        if (this.onk != null) {
            this.onk.c();
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
        if (this.ooY != null) {
            this.ooY.dispose();
            this.ooY = null;
        }
        this.onz = 1;
        this.onA = false;
        if (this.opT != null) {
            this.opT.co(null);
        }
        if (this.onD != null) {
            this.onD.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.opS, this.okv);
        if (this.opS != null && (this.opS instanceof VideoPlayer)) {
            ((VideoPlayer) this.opS).egz();
        }
        this.okw = null;
        this.okv = null;
        aI();
        if (this.onn != null) {
            this.onn.a();
        }
        if (this.ona != null) {
            this.ona.b();
            this.ona.c();
            this.ona = null;
        }
        super.d();
    }

    private void aI() {
        tv.chushou.zues.a.a.cp(this);
        if (this.onN != null) {
            this.onN.clear();
        }
        if (this.onL != null) {
            this.onL.clear();
        }
        if (this.onO != null) {
            this.onO.clear();
        }
        if (this.onM != null) {
            this.onM.clear();
        }
        if (this.onQ != null) {
            this.onQ.clear();
        }
        if (this.onP != null) {
            this.onP.a(0);
            this.onP.a();
        }
    }

    private void d(View view) {
        this.omw = view.findViewById(a.f.fl_root);
        this.ooo = tv.chushou.zues.utils.a.hk(this.opS);
        this.onB = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.opS);
        this.onC = tv.chushou.zues.utils.systemBar.b.aD(getActivity());
        this.oon = 86;
        this.opR = ((VideoPlayer) this.opS).egv();
        if (this.opR != null) {
            this.onI = this.opR.egW();
            this.onJ = this.opR.egU();
        }
        this.onL = new ArrayList<>();
        this.onN = new ArrayList<>();
        this.onM = new ArrayList<>();
        this.omA = (FrameLayout) this.opD.findViewById(a.f.fl_effect);
        b();
        this.opM = (PlayerErrorView) this.opD.findViewById(a.f.view_net_error_msg);
        this.opM.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.omZ = (RelativeLayout) this.opD.findViewById(a.f.rl_audio_ani);
        this.ona = (PaoPaoView) this.opD.findViewById(a.f.audio_ani);
        this.onb = (FrescoThumbnailView) this.opD.findViewById(a.f.audio_ani_avatar);
        this.onc = (LinearLayout) this.opD.findViewById(a.f.ll_audio);
        this.olW = (TextView) this.opD.findViewById(a.f.tv_open_video);
        this.ond = (ImageView) this.opD.findViewById(a.f.iv_audio_ani);
        this.oos = (FrescoThumbnailView) this.opD.findViewById(a.f.live_cover);
        if (!this.oot || this.omi == null || this.omi.getPlayState() != 4) {
            this.oos.setVisibility(0);
            this.oos.setBlur(true);
            this.oos.i(this.ojP, 0, 0, 0);
        }
        this.olW.setOnClickListener(this);
        this.ojt = new b();
        this.ojt.a(view, null, this.opS, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.cCv()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.opR != null) {
                    append.append(c.this.opR.egW().mRoomID);
                }
                if (c.this.ojs != null && c.this.ojs.omj != null) {
                    append.append("&mode=").append(c.this.ojs.omj.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.opS, append.toString());
            }
        });
        this.ojx = (VoiceInteractionView) this.opD.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.opR != null) {
            this.onI = this.opR.egW();
            this.onJ = this.opR.egU();
        }
        aL();
        ehh();
        ehn();
        this.oov = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.ooi = (FoodView) view.findViewById(a.f.rav_ad);
        this.ooA = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.ooB = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.ooA.setOnClickListener(this);
        this.ooB.setOnClickListener(this);
        this.ooC = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.oor = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.oor.setOnClickListener(this);
        this.onk = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.onj = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.onS = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.onS.setOnClickListener(this);
        this.onH = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.onH.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.onH.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.ooo.x, this.ooo.y) * 0.83d);
        this.onH.setLayoutParams(layoutParams);
        this.onK = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.opS);
        this.onH.setLayoutManager(this.onK);
        this.onH.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.onH.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.onH.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.ehA();
                } else if (i == 1) {
                    c.this.onR = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.onP = new com.kascend.chushou.player.adapter.a(this.opS, this.onL);
        if (this.onI != null) {
            this.onP.a(this.onI);
        }
        if (com.kascend.chushou.b.egb().c != null) {
            this.onP.a(com.kascend.chushou.b.egb().c);
        }
        this.onH.setAdapter(this.onP);
        this.onP.a(this.onL.size());
        this.onP.notifyDataSetChanged();
        if (this.opR != null && (c = this.opR.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.onn != null) {
            this.onn.a();
            this.onn = null;
        }
        this.onm = (GiftAnimationLayout) this.opD.findViewById(a.f.ll_gift_animation);
        this.onm.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.omv = ((int) (tv.chushou.zues.utils.a.hj(this.opS).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.opS, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.onm.getLayoutParams();
        layoutParams2.bottomMargin = this.omv;
        this.onm.setLayoutParams(layoutParams2);
        if (this.opR != null) {
            this.onn = new com.kascend.chushou.player.b.a(this.opS.getApplicationContext(), this.onm);
            this.onn.a(this.opR);
            a(this.opR.oiY, this.opR.ojb);
        }
        this.opD.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.onl = (EmbeddedButtonLayout) this.opD.findViewById(a.f.embedded_button_layout);
        this.onl.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.oox = (VideoShowVoteView) this.opD.findViewById(a.f.view_video_show_vote);
        this.oox.setOnClickListener(this);
        this.oox.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.opR != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.opS;
            this.onl.a(videoPlayer.egF().ehZ());
            this.onl.b(this.opR.i());
            this.onj.a(videoPlayer.egB(), false);
            this.onk.a(videoPlayer.egC(), videoPlayer.egD(), videoPlayer.egE());
            this.ojs = new com.kascend.chushou.player.e.a();
        }
        this.oqH = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.ooc = false;
                c.this.b(c.this.omv, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.ooc = true;
                if (c.this.oqx != null) {
                    c.this.oqx.measure(0, 0);
                    int measuredHeight = c.this.oqx.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.opS, 14.0f);
                    if (measuredHeight > c.this.omv) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.oqB = (PaoGuideView) this.opD.findViewById(a.f.rlPaoGuideView);
        this.ooe = (PlayShowMicPerson) this.opD.findViewById(a.f.rl_mic_person_view);
        this.onp = (PlayShowH5View) this.opD.findViewById(a.f.rl_playshowh5);
        this.ook = (FoodView) this.opD.findViewById(a.f.bottom_ad);
        if (this.opR != null) {
            H();
            if (this.opR.oiR != null && !h.isEmpty(this.opR.oiR.mUrl)) {
                b(this.opR.oiR);
            }
        }
        this.onT = this.opD.findViewById(a.f.view_reminder_subscribe);
        this.onU = this.onT.findViewById(a.f.spash_subscribe);
        ((TextView) this.onT.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().N(this.opS, a.e.videoplayer_reminder_subscribe).append(" ").append(this.opS.getString(a.i.videoplayer_reminder_subscribe)));
        this.onT.setOnClickListener(this);
        this.onW = this.opD.findViewById(a.f.view_reminder_danmaku);
        this.onX = this.onW.findViewById(a.f.spash_danmaku);
        ((TextView) this.onW.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().N(this.opS, a.e.videoplayer_reminder_danmaku).append(" ").append(this.opS.getString(a.i.videoplayer_reminder_danmaku)));
        this.onW.setOnClickListener(this);
    }

    private void ehh() {
        this.ooH = (RelativeLayout) this.opD.findViewById(a.f.rl_cyclelive);
        this.ooI = (RelativeLayout) this.opD.findViewById(a.f.rlrl_cyclelive);
        this.ooJ = (FrescoThumbnailView) this.opD.findViewById(a.f.iv_liveicon);
        this.ooK = (TextView) this.opD.findViewById(a.f.tv_livename);
        this.ooL = (TextView) this.opD.findViewById(a.f.tv_livedesc);
        this.ooM = (ImageView) this.opD.findViewById(a.f.iv_cyclelive_name_menu);
        this.ooN = (RelativeLayout) this.opD.findViewById(a.f.rl_normal);
        this.ooO = (LinearLayout) this.opD.findViewById(a.f.ll_cyclelive_nickname);
        this.ooP = (TextView) this.opD.findViewById(a.f.tv_cyclelive_nickname);
        this.ooQ = (TextView) this.opD.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.ooR = (RelativeLayout) this.opD.findViewById(a.f.rl_clear_cyclelive);
        this.ooS = (RelativeLayout) this.opD.findViewById(a.f.rlrl_clear_cyclelive);
        this.ooT = (FrescoThumbnailView) this.opD.findViewById(a.f.iv_clear_liveicon);
        this.ooU = (TextView) this.opD.findViewById(a.f.tv_clear_livename);
        this.ooV = (TextView) this.opD.findViewById(a.f.tv_clear_livedesc);
        this.ooW = (ImageView) this.opD.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.ooX = (RelativeLayout) this.opD.findViewById(a.f.rl_clear_normal);
        this.ooW.setOnClickListener(this);
        this.ooM.setOnClickListener(this);
        this.ooQ.setOnClickListener(this);
        this.ooP.setOnClickListener(this);
        this.ooJ.setOnClickListener(this);
        this.ooT.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.opR.oiP != null && this.ook != null) {
            this.ook.a(true, this.opR.f4119a == null ? "" : this.opR.f4119a);
            this.ook.a(this.opR.oiP, a.C0897a.slide_in_bottom_danmu_anim, a.C0897a.slide_out_bottom_danmu_anim, true);
        }
        if (this.opR != null && this.opR.oiW != null && this.onl != null) {
            this.ooi.a(this.opR.oiW, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.opR != null) {
                        c.this.opR.oiW = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a ehz() {
        return this.onn;
    }

    private void ehi() {
        this.opT = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.opD != null && (textView = (TextView) c.this.opD.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.opS.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.opT.D(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.opT);
                        break;
                    case 12:
                        c.this.b(c.this.opT);
                        break;
                    case 17:
                        c.this.ehU();
                        break;
                    case 18:
                        c.this.aq();
                        break;
                    case 19:
                        c.this.opQ.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.onG) {
            this.onG = true;
            if (this.onF == null) {
                this.onF = this.opD.findViewById(a.f.vs_async_show_content);
                this.onF = ((ViewStub) this.onF).inflate();
            }
            this.ojI = this.opD.findViewById(a.f.ui_content);
            if (this.okZ == null) {
                this.okZ = this.opD.findViewById(a.f.vs_async_notification_view);
                this.okZ = ((ViewStub) this.okZ).inflate();
            }
            c(this.opD);
            k();
            dUv();
            if (this.c == null) {
                this.ojm = new d.a();
                this.c = new GestureDetector(this.opS, this.ojm);
            }
            ((VideoPlayer) this.opS).q();
        }
    }

    private void aL() {
        this.omB = (LinearLayout) this.opD.findViewById(a.f.ll_anchor);
        this.omC = (RelativeLayout) this.opD.findViewById(a.f.ll_clear_anchor);
        this.omB.setVisibility(4);
        this.omC.setVisibility(4);
        this.omD = (FrescoThumbnailView) this.opD.findViewById(a.f.iv_clear_avatar);
        this.omE = (TextView) this.opD.findViewById(a.f.tv_clear_nickname);
        this.omF = (TextView) this.opD.findViewById(a.f.tv_clear_online_count);
        this.omG = (TextView) this.opD.findViewById(a.f.tv_clear_btn_subscribe);
        this.omG.setOnClickListener(this);
        this.omH = (FrescoThumbnailView) this.opD.findViewById(a.f.iv_avatar);
        this.omI = (TextView) this.opD.findViewById(a.f.tv_nickname_test);
        this.omJ = (TextView) this.opD.findViewById(a.f.tv_online_count);
        this.ojT = (TextView) this.opD.findViewById(a.f.tv_btn_subscribe);
        this.ojT.setOnClickListener(this);
        this.omK = (TextView) this.opD.findViewById(a.f.tv_loyal_counts);
        this.ojW = (TextView) this.opD.findViewById(a.f.tv_btn_contribution);
        this.omL = (TextView) this.opD.findViewById(a.f.tv_btn_contribution_forpk);
        this.ojW.setVisibility(4);
        this.omL.setVisibility(8);
        this.omM = (LinearLayout) this.opD.findViewById(a.f.ll_mic);
        this.omN = (PlayShowMicStatusView) this.opD.findViewById(a.f.show_mic_status);
        this.omO = (RecyclerView) this.opD.findViewById(a.f.rv_loyal);
        this.omP = (ImageView) this.opD.findViewById(a.f.iv_clear_close);
        this.okc = (ImageView) this.opD.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.omO.setLayoutManager(linearLayoutManager);
        this.oob = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.bv, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void E(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.bv.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.opS, (JSONObject) null, c.this.opR.egW().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC1029a view$OnLongClickListenerC1029a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC1029a.rL(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC1029a.rL(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC1029a.rL(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.etR(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.opS, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.opS, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.opS, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.opS, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.opS, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.bW(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.omO.setAdapter(this.oob);
        this.omM.setOnClickListener(this);
        this.omD.setOnClickListener(this);
        this.omP.setOnClickListener(this);
        this.omH.setOnClickListener(this);
        this.omD.setOnClickListener(this);
        this.okc.setOnClickListener(this);
        this.omK.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dP(View view) {
                String str = tv.chushou.common.a.cCv() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.opR != null) {
                    str = str + c.this.opR.egW().mRoomID;
                }
                c.this.f(c.this.opS.getString(a.i.str_loyal_fans), str);
            }
        });
        this.ojW.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dP(View view) {
                String str = tv.chushou.common.a.cCv() + "m/room-billboard/";
                if (c.this.opR != null) {
                    str = str + c.this.opR.egW().mRoomID;
                }
                c.this.f(c.this.opS.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.omL.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dP(View view) {
                String str = tv.chushou.common.a.cCv() + "m/room-billboard/";
                if (c.this.opR != null) {
                    str = str + c.this.opR.egW().mRoomID;
                }
                c.this.f(c.this.opS.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.onJ == null || this.onJ.cycleLiveRoomInfo == null || h.isEmpty(this.onJ.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.ojv = this.onJ.cycleLiveRoomInfo;
        }
        if (z2 && this.ojv != null) {
            this.ooH.setVisibility(0);
            this.ooR.setVisibility(0);
            this.ooN.setVisibility(8);
            this.ooX.setVisibility(8);
            this.ooO.setVisibility(0);
            this.ooT.h(this.ojv.eventIcon, com.kascend.chushou.view.a.a(this.onI.mCreatorGender), b.a.small, b.a.small);
            this.ooJ.h(this.ojv.eventIcon, com.kascend.chushou.view.a.a(this.onI.mCreatorGender), b.a.small, b.a.small);
            this.ooU.setText(this.ojv.eventName);
            this.ooV.setText(this.ojv.eventDesc);
            this.ooK.setText(this.ojv.eventName);
            this.ooL.setText(this.ojv.eventDesc);
            this.ooP.setText(this.ojv.nickname);
            ehk();
            if (z) {
                c(this.ojv.remainTime);
                return;
            }
            return;
        }
        this.ooH.setVisibility(8);
        this.ooR.setVisibility(8);
        this.ooN.setVisibility(0);
        this.ooX.setVisibility(0);
        this.ooO.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.ooY != null) {
            this.ooY.dispose();
            this.ooY = null;
        }
        this.ooY = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.emM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.opS != null && (c.this.opS instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.opS).u();
                }
            }
        });
    }

    private void ehj() {
        if (this.onI != null && this.onG) {
            this.omB.setVisibility(0);
            this.omC.setVisibility(0);
            this.ojW.setVisibility(0);
            this.omD.h(this.onI.mCreatorAvatar, com.kascend.chushou.view.a.a(this.onI.mCreatorGender), b.a.small, b.a.small);
            this.omE.setText(this.onI.mCreatorNickname);
            this.omH.h(this.onI.mCreatorAvatar, com.kascend.chushou.view.a.a(this.onI.mCreatorGender), b.a.small, b.a.small);
            this.omI.setText(this.onI.mCreatorNickname);
            ehL();
            ehl();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void ehL() {
        if (this.onI != null) {
            this.omF.setText(tv.chushou.zues.utils.b.formatNumber(this.onI.mOnlineCount));
            this.omJ.setText(tv.chushou.zues.utils.b.formatNumber(this.onI.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehk() {
        if (this.ojv != null) {
            if (this.ojv.isSubscribe) {
                this.ooQ.setText(a.i.like_already);
                this.ooQ.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.ooQ.setText(getString(a.i.like));
            this.ooQ.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehl() {
        if (this.onI != null) {
            if (this.onI.mIsSubscribed) {
                this.omG.setText(getString(a.i.like_already));
                this.omG.setBackgroundResource(a.e.bg_show_subcribe);
                this.ojT.setText(getString(a.i.like_already));
                this.ojT.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.omG.setText(getString(a.i.like));
            this.omG.setBackgroundResource(a.e.bg_show_subcribe);
            this.ojT.setText(getString(a.i.like));
            this.ojT.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void ehm() {
        if (this.oob != null) {
            this.oob.notifyDataSetChanged();
        }
    }

    private void ehn() {
        this.omR = this.opD.findViewById(a.f.tv_interact);
        this.omR.setOnClickListener(this);
        this.omW = (RelativeLayout) this.opD.findViewById(a.f.rl_edit_bar);
        this.omU = (ImageView) this.opD.findViewById(a.f.btn_hotword);
        this.omU.setOnClickListener(this);
        this.omV = (ImageView) this.opD.findViewById(a.f.iv_task_badge);
        this.omT = (AnimationSet) AnimationUtils.loadAnimation(this.opS, a.C0897a.anim_hotword);
        this.omT.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.egj().c) {
                    c.this.omU.clearAnimation();
                    c.this.omU.startAnimation(c.this.omT);
                }
            }
        });
        if (com.kascend.chushou.d.h.egj().c) {
            this.omU.startAnimation(this.omT);
            this.omV.setVisibility(0);
        }
        this.ooZ = (TextView) this.opD.findViewById(a.f.tv_bottom_input);
        this.ooZ.setOnClickListener(this);
        this.oqS = (FrescoThumbnailView) this.opD.findViewById(a.f.ll_btn_set);
        this.oqS.setOnClickListener(this);
        this.oqS.Dr(a.e.ic_room_set_btn_white);
        this.ong = (LinearLayout) this.opD.findViewById(a.f.ll_bottom_all_button);
        this.onh = (FrescoThumbnailView) this.opD.findViewById(a.f.fl_clear_bottom_gift);
        this.onh.setAnim(true);
        this.onh.setOnClickListener(this);
        this.onh.Dr(a.e.ic_show_gift_n);
        this.oni = (FrameLayout) this.opD.findViewById(a.f.flfl_clear_bottom_gift);
        this.oni.setVisibility(8);
        this.omS = (RelativeLayout) this.opD.findViewById(a.f.rl_bottom_input);
        this.omS.setVisibility(0);
        this.omX = (PastedEditText) this.opD.findViewById(a.f.et_bottom_input);
        this.omX.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.okl.setEnabled(editable.length() > 0);
            }
        });
        this.omX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.okl);
                    return true;
                }
                return true;
            }
        });
        this.omX.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.omX);
                }
                return false;
            }
        });
        this.oku = (ImageView) this.opD.findViewById(a.f.iv_btn_emoji);
        this.oku.setVisibility(8);
        this.okl = (TextView) this.opD.findViewById(a.f.tv_btn_send);
        this.okl.setOnClickListener(this);
        this.onq = (LinearLayout) this.opD.findViewById(a.f.head_trumpet);
        this.onq.setVisibility(8);
        this.onq.setOnClickListener(this);
        this.onr = (TextView) this.opD.findViewById(a.f.tv_primary_name);
        this.ons = (TextView) this.opD.findViewById(a.f.tv_primary_desc);
        this.onu = (TextView) this.opD.findViewById(a.f.tv_cut_count);
        this.onu.setOnClickListener(this);
        this.onw = (TextView) this.opD.findViewById(a.f.tv_head_count);
        this.onw.setText(this.onz + "");
        this.onv = (TextView) this.opD.findViewById(a.f.tv_plus_count);
        this.onv.setOnClickListener(this);
        this.okL = (TextView) this.opD.findViewById(a.f.tv_buy_count_coin);
        this.ont = (TextView) this.opD.findViewById(a.f.tv_buy_head);
        this.ont.setOnClickListener(this);
        this.onx = (ImageView) this.opD.findViewById(a.f.iv_trumpet_select);
        this.onx.setOnClickListener(this);
        this.ony = (TextView) this.opD.findViewById(a.f.tv_trumpet_have_count);
        this.onA = false;
        this.onx.setBackgroundResource(a.e.ic_trumpet_n);
        this.ony.setVisibility(8);
        this.okt = (KPSwitchPanelLinearLayout) this.opD.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.okt, this.oku, this.omX, new a.InterfaceC1033a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC1033a
            public void zl(boolean z) {
                if (c.this.oku != null) {
                    if (z) {
                        c.this.okt.setDirectVisibility(0);
                        c.this.oku.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.oku.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.okw = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void jK(boolean z) {
                c.this.cp = z;
                if (z) {
                    c.this.oku.setImageResource(a.e.cs_emoji_normal);
                    c.this.ehp();
                    if (c.this.ooG != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.ooG.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.opS);
                        c.this.ooG.setLayoutParams(layoutParams);
                    }
                    if (c.this.omW != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.omW.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ek(c.this.opS);
                        c.this.omW.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.ooG != null && c.this.ooG.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.ooG.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.ooG.setLayoutParams(layoutParams3);
                    c.this.ooG.setVisibility(8);
                }
                if (c.this.ooc) {
                    c.this.oqx.setVisibility(0);
                }
                if (c.this.opS != null && (c.this.opS instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.opS).zk(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.omW != null && c.this.okt.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.omW.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.omW.setLayoutParams(layoutParams4);
                }
            }
        };
        this.okv = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.okt, this.okw, ((VideoPlayer) this.opS).egA());
        ((VideoPlayer) this.opS).h(((VideoPlayer) this.opS).egA());
        this.ooG = this.opD.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.ooD = (TextView) this.opD.findViewById(a.f.btn_room_search);
        this.ooE = (ImageView) this.opD.findViewById(a.f.iv_room_emoji_delete);
        this.ooF = (EditText) this.opD.findViewById(a.f.et_room_emoji_search);
        this.ooF.setImeOptions(3);
        this.ooF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.ooD);
                    return true;
                }
                return false;
            }
        });
        this.ooF.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.ooD.setEnabled(editable.length() > 0);
                c.this.ooE.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.oqx.setEmojiSearchText(editable.toString());
            }
        });
        this.ooD.setOnClickListener(this);
        this.ooE.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void aC(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.by(this.ooF);
            this.ooG.setVisibility(0);
            this.ooF.requestFocus();
        } else {
            this.ooG.setVisibility(8);
        }
        if (z2) {
            this.ooF.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehp() {
        int ek = tv.chushou.zues.widget.kpswitch.b.d.ek(this.opS) + tv.chushou.zues.utils.a.dip2px(this.opS, 14.0f);
        if (ek > this.omv) {
            b(ek, 12);
        }
    }

    private void aS() {
    }

    private void ehs() {
        if (this.onC > 0) {
            View findViewById = this.opD.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.onC);
        }
        if (this.onB > 0) {
            View findViewById2 = this.opD.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.onB, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.onZ) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.ojo = ((VideoPlayer) this.opS).egw();
        this.ojo.a(this);
        if (this.opR.egU() != null) {
            s();
        } else if (this.opE != null) {
            this.opE.setVisibility(0);
        }
        if (this.ojo != null) {
            this.ojo.d();
        }
    }

    private void eht() {
        if ((this.ojs == null || this.ojs.omj == null || !this.ojs.omj.mInPKMode) ? false : true) {
            if (this.omw != null) {
                this.omw.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oju.getLayoutParams();
            layoutParams.leftMargin = (this.ooo.x / 2) + tv.chushou.zues.utils.a.dip2px(this.opS, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.oju.setLayoutParams(layoutParams);
            this.y.setText(this.ojs.omj.mPkUserNickname);
            this.oju.setVisibility(0);
            this.omM.setVisibility(8);
            return;
        }
        if (this.omw != null) {
            this.omw.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.oju.setVisibility(8);
    }

    private void ehv() {
        boolean z = false;
        if (this.ojs != null && this.ojs.omj != null && this.ojs.omj.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.ooz > 0 && this.onH != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.onH.getLayoutParams();
                if (layoutParams.height != this.ooz) {
                    layoutParams.height = this.ooz;
                    this.onH.setLayoutParams(layoutParams);
                }
            }
            this.omv = ((int) (tv.chushou.zues.utils.a.hj(this.opS).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.opS, 84.0f);
            b(this.omv, 12);
        } else {
            if (this.onH != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.onH.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.opS, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.opS, 250.0f);
                    this.onH.setLayoutParams(layoutParams2);
                }
            }
            this.omv = ((int) (tv.chushou.zues.utils.a.hj(this.opS).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.opS, 84.0f);
            b(this.omv, 12);
        }
        if (this.ojt != null) {
            this.ojt.a(this.ooz + tv.chushou.zues.utils.a.dip2px(this.opS, 52.0f), this.aq);
        }
        if (this.ojx != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.ojx.getLayoutParams();
            layoutParams3.bottomMargin = this.ooz + tv.chushou.zues.utils.a.dip2px(this.opS, 52.0f);
            this.ojx.setLayoutParams(layoutParams3);
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

    private void ehw() {
        ehv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ehS().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.opE.getLayoutParams();
        this.ooo = tv.chushou.zues.utils.a.hk(this.opS);
        this.oon = 86;
        this.dB = (Math.max(this.ooo.x, this.ooo.y) - tv.chushou.zues.utils.a.dip2px(this.opS, (this.oon + 52) + 250)) - this.onB;
        this.oom = Math.max(this.ooo.x, this.ooo.y) - ((tv.chushou.zues.utils.a.dip2px(this.opS, this.oon) + this.onB) * 2);
        if (this.oop <= 0 || this.ooq <= 0) {
            this.oop = Math.min(this.ooo.x, this.ooo.y);
            this.ooq = Math.max(this.ooo.x, this.ooo.y);
        }
        this.ar = Math.min(this.ooo.x, this.ooo.y);
        this.aq = (this.ar * this.ooq) / this.oop;
        boolean z = false;
        if (this.ojs == null || this.ojs.omj == null) {
            i = 1;
        } else {
            i = this.ojs.omj.mMode;
            if (this.ojs.omj.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.oon = 42;
            if (i == 2) {
                if (this.ooq < this.oop) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.oop * layoutParams.height) / this.ooq;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.opS, this.oon) + this.onB;
            layoutParams.gravity = 48;
            this.ooz = ((this.ooo.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.opS, (this.oon + 52) + 64) + this.onB)) - tv.chushou.zues.utils.systemBar.b.aD(getActivity());
            aG();
        } else if (this.E) {
            this.oon = 42;
            if (this.ooq < this.oop) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.oop * layoutParams.height) / this.ooq;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.opS, this.oon) + this.onB;
            layoutParams.gravity = 48;
            this.ooz = ((this.ooo.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.opS, (this.oon + 52) + 98) + this.onB)) - tv.chushou.zues.utils.systemBar.b.aD(getActivity());
            ehw();
        } else {
            this.ooz = -1;
            this.oon = 86;
            if (this.aq <= this.dB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.dB;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.opS, this.oon) + this.onB;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.oom) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.opS, this.oon) + this.onB;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.ooo.x, this.ooo.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.oop) / this.ooq >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.oop) / this.ooq;
                    } else if ((this.ar * this.ooq) / this.oop >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.ooq) / this.oop;
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
                    if ((this.ar * this.ooq) / this.oop > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.oop) / this.ooq;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.ooq) / this.oop;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.ooq) / this.oop;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.oop) / this.ooq;
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
        if (this.opR != null && this.opR.d) {
            layoutParams.width = Math.min(this.ooo.x, this.ooo.y);
            layoutParams.height = Math.max(this.ooo.x, this.ooo.y);
        }
        ehS().setLayoutParams(layoutParams);
        this.opE.setLayoutParams(layoutParams2);
        this.opE.requestLayout();
    }

    private void aY() {
        this.opE = new SurfaceRenderView(this.opS);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.opE;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        ehS().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.ooh) {
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
        if (this.opc != null) {
            this.opc.a();
        }
        if (this.opR != null && !h.isEmpty(this.opR.w)) {
            b(this.opR.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.omi != null) {
            int width = this.omi.getWidth();
            int height = this.omi.getHeight();
            if (this.oop != width || this.ooq != height || this.oop <= 0 || this.ooq <= 0) {
                this.oop = width;
                this.ooq = height;
                if (this.opE != null) {
                    this.opE.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
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
            if (this.ooc) {
                ehy();
            } else {
                if (this.opS.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.opS, "点击送礼_num", "竖屏", new Object[0]);
                if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.opR.egU().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.onA) {
                f(this.omX.getText().toString());
            } else {
                a(this.omX.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.egj().c) {
                com.kascend.chushou.d.h.egj().b(false);
                this.omT.cancel();
                this.omT.reset();
                this.omU.clearAnimation();
                this.omV.setVisibility(8);
            }
            n(view, 0, this.opD.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.opS, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.opD.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.opR.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.opR.d) {
                dUo();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.onH != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.onI != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.oog = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.opS, (JSONObject) null, this.opR.egW().mRoomID, this.opR.egW().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.opS.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.opS, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.ooj != null) {
                    com.kascend.chushou.d.e.a(this.opS, this.ooj, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.ooC != null) {
                    this.ooC.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.opS, null) && this.opR != null && this.opR.oja != null) {
                    if (this.onA) {
                        bo();
                    } else {
                        if (this.opR != null && this.opR.oja != null && this.opR.oja.count > 0) {
                            this.onq.setVisibility(8);
                        } else {
                            this.onq.setVisibility(0);
                        }
                        this.onA = true;
                        this.onx.setBackgroundResource(a.e.ic_trumpet_p);
                        this.ony.setVisibility(0);
                        this.ony.setSelected(true);
                        this.ony.setTextColor(Color.parseColor("#ff5959"));
                        if (this.omX != null) {
                            this.omX.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.onz <= 9) {
                    this.onz++;
                    this.onw.setText(this.onz + "");
                }
                ehg();
            } else if (id == a.f.tv_cut_count) {
                if (this.onz > 1) {
                    this.onz--;
                    this.onw.setText(this.onz + "");
                }
                ehg();
            } else if (id == a.f.tv_buy_head) {
                ehQ();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.ooF.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.ooF.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.ooG.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dZ(this.ooF);
                    this.oqx.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.ojv != null && !h.isEmpty(this.ojv.eventUrl)) {
                    f("", this.ojv.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.ojv != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.ojv != null) {
                    com.kascend.chushou.d.a.a(this.opS, (JSONObject) null, this.ojv.roomId, this.ojv.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.opR.a(false);
                    ((VideoPlayer) this.opS).l();
                } else {
                    ((VideoPlayer) this.opS).a(true, (Uri) null, false);
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
        if (this.onp != null) {
            int i = (tv.chushou.zues.utils.a.hj(this.opS).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.onp.getLayoutParams();
            layoutParams.topMargin = i;
            this.onp.setLayoutParams(layoutParams);
            this.onp.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.f4233a = str2;
            h5Options.c = false;
            this.onp.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.PQ(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.oof <= IMConnection.RETRY_DELAY_TIMES) {
            tv.chushou.zues.utils.g.PQ(a.i.str_too_fast);
            return false;
        } else {
            dUA();
            if (!com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a(((VideoPlayer) this.opS).egv().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.oof = System.currentTimeMillis();
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                a(this.opR.egU().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.opR.h);
            }
            g(this.b);
            if (!z && this.omX != null) {
                this.omX.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dUA();
            if (com.kascend.chushou.d.e.c(this.opS, null) && LoginManager.Instance().getUserInfo() != null && this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                a(this.opR.egU().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.omX != null) {
                this.omX.setText((CharSequence) null);
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
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.opR.egU().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.opR.egU().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.opS).ohp;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Yj(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.oqs != null && this.oqs.isShowing()) {
            this.oqs.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
        if (this.oqP == null) {
            i(3);
        }
        this.oqP.getContentView().setBackgroundResource(0);
        this.oqP.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.oqP.isShowing()) {
            this.oqP.showAtLocation(view, 83, i, i2);
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.opR.egU().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.oqP.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.oqT)) {
            if (((VideoPlayer) this.opS).q) {
                this.oqS.Dr(a.e.ic_room_set_btn_white);
            } else {
                this.oqS.Dr(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.opS).q && this.oqT.size() == 2 && this.oqT.contains("4") && this.oqT.contains("2")) {
            this.oqS.Dr(a.e.ic_room_set_btn_system_white);
        } else if (this.oqT.size() > 1 || !((VideoPlayer) this.opS).q) {
            this.oqS.Dr(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.oqT.get(0))) {
            this.oqS.Dr(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.oqT.get(0))) {
            this.oqS.Dr(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.oqT.get(0))) {
            this.oqS.Dr(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
        if (this.oqs == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.oqs.getContentView().setBackgroundResource(0);
            this.oqs.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.oqs.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.omU.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.oqs.isShowing()) {
            this.oqs.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.opS, 16.0f) + i2);
            this.omU.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.opR.egU().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.oqs.dismiss();
    }

    private void e(View view) {
        if (this.oqm == null) {
            ba();
        }
        if (com.kascend.chushou.d.h.egj().q()) {
            this.omY.etP();
        } else {
            this.omY.etQ();
        }
        int height = this.opD.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity());
        if (view != null) {
            this.oqm.showAtLocation(view, 85, 0, height);
        }
    }

    private void ba() {
        if (this.oqm == null) {
            View inflate = LayoutInflater.from(this.opS).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.omY = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.egj().q()) {
                this.omY.etP();
            } else {
                this.omY.etQ();
            }
            this.omY.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.egj().g(z);
                }
            });
            this.oqg = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.oqh = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.oqg.setOnClickListener(this);
            if (com.kascend.chushou.c.f4079a) {
                this.oqg.setVisibility(0);
            } else {
                this.oqg.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.egj().f4087a) {
                this.oqh.b();
            } else {
                this.oqh.c();
            }
            if (this.opR != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.opR.f;
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
                                if (this.ojs == null || !this.ojs.omj.mInPKMode || h.isEmpty(this.ojs.b) || this.onI == null || !this.ojs.b.equals(this.onI.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.opS).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl egV = this.opR.egV();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.opS).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.opS, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.opS, 5.0f);
                                            }
                                            int identifier = this.opS.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.opS.getPackageName());
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
                                                if (egV != null && egV.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.opS.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.opS).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl egV2 = this.opR.egV();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.opS).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.opS, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.opS, 5.0f);
                                        }
                                        int identifier2 = this.opS.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.opS.getPackageName());
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
                                            if (egV2 != null && egV2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.oqm.dismiss();
                    }
                }
            });
            this.oqm = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 150.0f), -2);
            this.oqm.setFocusable(true);
            this.oqm.setOutsideTouchable(true);
            this.oqm.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.oqm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.oqm = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
            if (this.ono == null) {
                this.ono = new f(getActivity());
            }
            this.ono.a(this.opR.egU().mRoominfo, this.ax);
            if (!this.ono.isShowing()) {
                this.ono.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.ooh) {
            return false;
        }
        if (this.oog == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.opa = motionEvent.getX();
                    this.opb = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.opa;
                    if (Math.abs(f) > Math.abs(y - this.opb) && Math.abs(f) > q && f > 0.0f) {
                        ehN();
                        return true;
                    }
                    this.opa = 0.0f;
                    this.opb = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.ooG != null && this.ooG.getVisibility() == 0 && a(motionEvent, this.ooG)) {
                this.ooG.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dZ(this.ooF);
                return true;
            } else if (this.ooc && this.ooG != null && this.ooG.getVisibility() == 8 && f(this.oqx.b, motionEvent)) {
                ehy();
                return true;
            } else if (this.onp != null && this.onp.b() && f(this.onp, motionEvent)) {
                this.onp.a();
                return true;
            } else if (this.onf != null && this.onf.b() && f(this.onf, motionEvent)) {
                this.onf.a();
                return true;
            } else if (a(motionEvent, this.omW)) {
                return dUA();
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
            if (this.oqJ != null && this.oqJ.a(i, keyEvent)) {
                return true;
            }
            if ((this.onp != null && this.onp.onKeyDown(i, keyEvent)) || ehq()) {
                return true;
            }
            if (this.oog == 3) {
                this.oog = 1;
                ehN();
                return true;
            } else if (this.onf != null && this.onf.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.omX != null && this.omS != null && this.omW != null) {
                tv.chushou.zues.widget.kpswitch.b.d.by(this.omX);
                this.omS.setVisibility(8);
                this.omW.setVisibility(0);
            }
        } else if (this.omS != null && this.omW != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
            this.omS.setVisibility(0);
            this.omW.setVisibility(8);
        }
    }

    public boolean dUA() {
        boolean z;
        b(this.omv, 12);
        boolean z2 = false;
        if (this.okt != null && this.okt.getVisibility() == 0) {
            this.okt.setVisibility(8);
            this.oku.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.cp) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.opS);
            this.oku.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.omW == null || this.omW.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.onA) {
                bo();
            }
            this.omW.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.omS != null) {
                    c.this.omS.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean ehq() {
        if (dUA()) {
            return true;
        }
        if (this.oqs != null && this.oqs.isShowing()) {
            this.oqs.dismiss();
            return true;
        } else if (this.oqP != null && this.oqP.isShowing()) {
            this.oqP.dismiss();
            return true;
        } else if (this.oqm == null || !this.oqm.isShowing()) {
            return ehy() || ehr() || ehx() || ehf();
        } else {
            this.oqm.dismiss();
            return true;
        }
    }

    public boolean ehf() {
        if (this.oqB == null || !this.oqB.isShown()) {
            return false;
        }
        this.oqB.d();
        return true;
    }

    public boolean ehr() {
        if (this.ooe == null || !this.ooe.isShown()) {
            return false;
        }
        this.ooe.a();
        return true;
    }

    public boolean ehx() {
        if (this.onp == null || !this.onp.b()) {
            return false;
        }
        this.onp.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.opS != null && !((Activity) this.opS).isFinishing() && pVar != null) {
            this.onQ = pVar.f4077a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!aa() && this.onI != null && mVar.a(this.onI.mCreatorUID, null)) {
            this.onI.mIsSubscribed = mVar.c;
            ehl();
        }
    }

    public boolean ehy() {
        if (!this.ooc || this.oqx == null) {
            return false;
        }
        if (this.oqx != null) {
            this.oqx.e();
        }
        if (this.ooF != null) {
            this.ooF.setText("");
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
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.ool != null) {
                        this.ool.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                        this.opR.egU().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.opR.egU().mMicStatus.onMic) {
                            if (this.omM != null) {
                                this.omM.setVisibility(8);
                            }
                            if (this.ooe != null && this.ooe.isShown()) {
                                this.ooe.a();
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
                        if (this.opR.egU().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.onI != null && !h.isEmpty(this.onI.mCreatorUID)) {
                                g(arrayList2, this.onI.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.opR.egU().mMicStatus.onMic) {
                            if (this.opR.egU().mMicStatus != null && !h.isEmpty(this.opR.egU().mMicStatus.micRoomId) && !this.opR.egU().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.opR.egU().mMicStatus.micRoomId;
                            }
                            this.opR.egU().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.opR.egU().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.opR.egU().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.opR.egU().mMicStatus, str3, z4);
                            if (this.ooe != null && this.ooe.getVisibility() == 0) {
                                this.ooe.a(this.opR.egU().mFanItems, this.opR.egU().mMicStatus, str3, z4, this.opR.egU().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.omM != null) {
                                this.omM.setVisibility(8);
                            }
                            if (this.ooe != null && this.ooe.isShown()) {
                                this.ooe.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.onE != onlineVip.mCount || (this.omK != null && this.omK.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.onE = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        ehD();
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
                            if (!z3 || System.currentTimeMillis() - this.oow <= 5000) {
                                z2 = false;
                            } else {
                                this.oow = System.currentTimeMillis();
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
                            ehm();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.oox != null) {
                    if (this.onI == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.onI.mCreatorAvatar;
                        str2 = this.onI.mCreatorGender;
                    }
                    this.oox.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.ojs != null && this.ojs.omj != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.ojs.omj.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.ojo != null) {
                                        this.ojo.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.ojs.omj.mInPKMode = true;
                                    this.ojs.omj.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.ojs.omj.mPkUid = pkNotifyInfo.mPkUid;
                                    this.ojs.omj.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.ojs.omj.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.ojs.omj.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.ojs.omj.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.ojs.omj.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.ojs.omj.mMode = pkNotifyInfo.mMode;
                                    this.ojs.omj.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.ojt != null) {
                                        this.ojt.j(true, this.ojs.omj.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.egj().f4087a) {
                                        if (!com.kascend.chushou.b.egb().e) {
                                            com.kascend.chushou.b.egb().e = true;
                                            tv.chushou.zues.utils.g.K(this.opS, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.egj().a(this.opS, false);
                                        ehu();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.ojs.omj.mAction = 7;
                                    this.ojs.omj.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.ojs.omj.mPkUid = pkNotifyInfo.mPkUid;
                                    this.ojs.omj.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.ojs.omj.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.ojs.omj.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.ojs.omj.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.ojs.omj.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.ojt != null) {
                                        this.ojt.j(false, 0L);
                                        this.ojt.b(this.ojs.omj, true);
                                        this.ojt.a(this.ooz + tv.chushou.zues.utils.a.dip2px(this.opS, 52.0f), this.aq);
                                        this.ojt.a(this.ojs.omj.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.ojo != null) {
                                        this.ojo.a(false);
                                    }
                                    this.ojs.omj.mInPKMode = false;
                                    this.ojs.omj.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.ojt != null) {
                                        this.ojt.c();
                                    }
                                    this.ojs.b = null;
                                    this.ojs.omj = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.ojs.omj.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.ojs.omj.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.ojs.omj.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.onI != null && !h.isEmpty(this.onI.mRoomID) && this.onI.mRoomID.equals(this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.ojs.omj.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.ojt != null) {
                                        this.ojt.a(this.ojs.omj, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.ojs.omj.copyUpdate(pkNotifyInfo);
                                    if (this.ojt != null) {
                                        this.ojt.a(this.ojs.omj);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.ojs.omj.copyStop(pkNotifyInfo);
                                        if (this.ojt != null) {
                                            this.ojt.I(this.ojs.omj.mMaxFreeDuration, this.ojs.omj.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.ojs.omj.copyResult(pkNotifyInfo);
                                    if (!this.ooa && this.ojt != null) {
                                        int i7 = 1;
                                        if (this.ojs.omj.destinyInfo != null && this.ojs.omj.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.ojt.a(h.parseInt(this.ojs.omj.mResult), h.parseLong(this.ojs.omj.mvpUid), this.ojs.omj.mvpAvatar, this.ojs.omj.mvpNickname, this.ojs.omj.mMaxFreeDuration, this.ojs.omj.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.ojv != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.ojv.uid = cycleLiveRoomInfo.uid;
                        this.ojv.remainTime = cycleLiveRoomInfo.remainTime;
                        this.ojv.roomId = cycleLiveRoomInfo.roomId;
                        this.ojv.avatar = cycleLiveRoomInfo.avatar;
                        this.ojv.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.opS != null && (this.opS instanceof VideoPlayer)) {
                            ((VideoPlayer) this.opS).d();
                        }
                    } else {
                        ((VideoPlayer) this.opS).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.opR != null && this.opR.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.egj().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.egj().b().equals(next2.mUserID)) {
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

    public void ehD() {
        if (this.omK != null) {
            if (this.ojs == null || this.ojs.omj == null || !this.ojs.omj.mInPKMode) {
                if (this.bP > 0) {
                    this.omK.setVisibility(0);
                    this.omK.setText(String.format(this.opS.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.omO.setVisibility(0);
                    return;
                }
                this.omK.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.omM.setVisibility(0);
            if (this.omN != null) {
                this.omN.a(str, z, micStatus, this.opR.egU().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.omM.setVisibility(8);
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
    public void ehA() {
        int childCount = this.onK.getChildCount();
        int itemCount = this.onK.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.onK);
        if (f + childCount >= itemCount) {
            this.onR = true;
            if (this.onS != null) {
                this.onS.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void ehJ() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.onL.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.onL.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.onL == null) {
            this.onL = new ArrayList<>();
        }
        while (2 < this.onL.size()) {
            this.onL.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.onN);
        if (a2 == null) {
            w(false);
            return;
        }
        this.onL.addAll(a2);
        int size = this.onL.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.onL.size(); i++) {
                this.onL.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.onO == null) {
            this.onO = new ArrayList<>();
        }
        this.onO.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.onQ != null && this.onQ.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.onQ.contains("2"))) {
                        this.onO.add(next);
                    } else if (!this.onQ.contains(next.mType)) {
                        this.onO.add(next);
                    }
                }
                return this.onO;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.onL == null) {
                    this.onL = new ArrayList<>(arrayList);
                    ehJ();
                    w(z2);
                    return;
                }
                if (this.onN == null) {
                    this.onN = new ArrayList<>();
                }
                this.onN.addAll(arrayList);
                int size = this.onN.size();
                if (size > 500) {
                    for (int i = 0; i < size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL && i < this.onN.size(); i++) {
                        this.onN.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.onL.size();
                if (a2 != null) {
                    this.onL.addAll(a2);
                }
                int size3 = this.onL.size();
                if (!this.onR && this.onS != null) {
                    this.onS.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.onL.size(); i3++) {
                        this.onL.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.onL == null) {
                this.onL = new ArrayList<>(arrayList);
                ehJ();
            } else {
                if (this.onN == null) {
                    this.onN = new ArrayList<>();
                }
                this.onN.clear();
                this.onN.addAll(arrayList);
                this.onL.clear();
                ehJ();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.onL.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.onP != null) {
                this.onP.a(this.onL.size());
                if (i == 1) {
                    this.onP.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.onP.notifyItemRangeRemoved(i2, i3);
                    this.onP.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.onP.notifyDataSetChanged();
                }
            }
            if (z || this.onR) {
                this.onR = true;
                if (this.onS != null) {
                    this.onS.setVisibility(8);
                }
                if (z) {
                    this.onH.scrollToPosition(this.onL.size() - 1);
                } else {
                    this.onH.smoothScrollToPosition(this.onL.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.onP != null) {
                this.onP.a(this.onL.size());
                this.onP.notifyDataSetChanged();
            }
            if (z || this.onR) {
                this.onR = true;
                if (this.onS != null) {
                    this.onS.setVisibility(8);
                }
                if (z) {
                    this.onH.scrollToPosition(this.onL.size() - 1);
                } else {
                    this.onH.smoothScrollToPosition(this.onL.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a egG;
        RoomToast roomToast;
        this.p = false;
        if (this.opR != null && this.opR.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.opR.f.size()) {
                    break;
                } else if (!"2".equals(this.opR.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            ehM();
            return;
        }
        if (this.ojI != null) {
            this.ojI.setVisibility(0);
        }
        if (this.omA != null) {
            this.omA.setVisibility(0);
        }
        if (this.opR != null) {
            this.onI = this.opR.egW();
            this.onJ = this.opR.egU();
            if (com.kascend.chushou.b.egb().c != null && this.onP != null) {
                this.onP.a(com.kascend.chushou.b.egb().c);
                this.onP.notifyDataSetChanged();
            }
            FullRoomInfo egU = this.opR.egU();
            if (egU != null) {
                if (!h.isEmpty(egU.mRoomToastList)) {
                    Iterator<RoomToast> it = egU.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.egj().j())) {
                    a(roomToast);
                }
            }
            if (this.onI != null) {
                bk();
            }
            if (this.onI != null && !this.onI.mIsSubscribed) {
                RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.onI == null || !c.this.onI.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.opR != null && this.opR.l()) {
                d(true);
            }
        }
        if (this.onI != null && this.onP != null) {
            if (this.onL != null) {
                this.onL.clear();
            } else {
                this.onL = new ArrayList<>();
            }
            this.onP.a(this.onI);
            ehJ();
            this.onP.a(this.onL.size());
            this.onP.notifyDataSetChanged();
        }
        ehj();
        N();
        if (this.opS != null && (this.opS instanceof VideoPlayer) && (egG = ((VideoPlayer) this.opS).egG()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(egG.omj, egG.b);
        }
        this.onb.h(this.onI.mCreatorAvatar, com.kascend.chushou.view.a.a(this.onI.mCreatorGender), 0, 0);
        if (this.opE != null) {
            this.opE.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.ong);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void ehB() {
        if (this.onD == null) {
            View inflate = LayoutInflater.from(this.opS).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.okW = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.onD = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.opS, 160.0f), -2);
            this.onD.setFocusable(false);
            this.onD.setOutsideTouchable(false);
            this.onD.setAnimationStyle(a.j.gift_toast_style);
            this.onD.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.egj().c(roomToast.mToastContent);
            if (this.onD == null) {
                ehB();
            }
            if (this.okW != null) {
                this.okW.setText(roomToast.mToastContent);
            }
            if (!this.onD.isShowing()) {
                if (this.ong != null) {
                    this.onD.showAtLocation(this.ong, 85, 0, this.opD.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aD(getActivity()));
                    RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.onD != null) {
                                c.this.onD.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.onD.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.oos != null) {
            this.oos.setVisibility(z ? 0 : 8);
        }
        this.oot = true;
        if (this.opS instanceof VideoPlayer) {
            ((VideoPlayer) this.opS).p();
        }
    }

    private void ehM() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.opS).s();
        ehf();
        ehr();
        if (this.omQ == null) {
            this.omQ = (PlayShowRecommendView) ((ViewStub) this.opD.findViewById(a.f.view_recommend)).inflate();
        }
        this.omQ.setVisibility(0);
        if (this.opR.egU() != null && this.opR.egU().mRoominfo != null && !h.isEmpty(this.opR.egU().mRoominfo.mRoomID)) {
            ehE();
        }
        if (this.opE != null) {
            this.opE.setVisibility(8);
        }
        if (this.oqx != null) {
            this.oqx.e();
        }
        if (this.ojI != null) {
            this.ojI.setVisibility(4);
        }
        if (this.omA != null) {
            this.omA.setVisibility(8);
        }
        if (this.oqF != null) {
            this.oqF.etn();
            this.oqF.setVisibility(8);
        }
        zn(false);
        a(false, false);
        if (this.ojo != null) {
            this.ojo.a();
        }
    }

    private void ehE() {
        if (this.omQ != null && this.omQ.getVisibility() == 0) {
            this.omQ.a(this.opR.egU().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.opS instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.opS;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.onp != null && this.onp.b()) {
            this.onp.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.ood);
        if (this.opS != null) {
            if (this.ood || "10004".equals(((VideoPlayer) this.opS).t)) {
                this.ood = true;
                if (this.opR != null) {
                    this.opR.f = null;
                    if (this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                        this.opR.egU().mRoominfo.mGameId = null;
                    }
                }
                ehM();
                return;
            }
            this.ood = true;
            if (this.opS != null) {
                ((VideoPlayer) this.opS).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.ood = false;
        if (this.ojI != null) {
            this.ojI.setVisibility(0);
        }
        if (this.omA != null) {
            this.omA.setVisibility(0);
        }
        if (this.omQ != null) {
            this.omQ.setVisibility(8);
        }
        if (this.opM != null) {
            this.opM.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.ood = false;
        if (this.ojI != null) {
            this.ojI.setVisibility(0);
        }
        if (this.omA != null) {
            this.omA.setVisibility(0);
        }
        if (this.omQ != null) {
            this.omQ.setVisibility(8);
        }
        if (this.opM != null) {
            this.opM.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.omQ != null) {
            this.omQ.setVisibility(8);
        }
        if (this.opE != null) {
            this.opE.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!aa()) {
            if (i()) {
                if (i == 404) {
                    if (this.opR != null) {
                        this.opR.f = null;
                        this.opR.egU().mRoominfo.mGameId = null;
                    }
                    ehM();
                    return;
                }
                tv.chushou.zues.utils.g.PQ(a.i.str_getvideosource_failed);
            }
            zn(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.opR != null && this.opR.egV() != null) {
            a(this.opR.egV());
        }
        this.p = false;
        if (this.opR == null || this.opR.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.opR.f.size()) {
                if (!"2".equals(this.opR.f.get(i2).mType)) {
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
    public GiftAnimationLayout eho() {
        if (this.opD == null) {
            return null;
        }
        return (GiftAnimationLayout) this.opD.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.ong != null) {
            int size = iconConfig.configs.size();
            this.ong.removeAllViews();
            if (this.oni != null) {
                this.oni.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.opS).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.ong, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bY(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.bY(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bY(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.oni.setVisibility(0);
                            this.onh.bY(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.bY(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.bY(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.bY(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void dP(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.ong.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void D() {
        if (this.opS instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a egB = ((VideoPlayer) this.opS).egB();
            if (this.oqJ == null) {
                this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.oqJ.setVisibility(0);
            this.oqJ.a(2, egB);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.onk != null && this.opS != null) {
            this.onk.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.onk != null && this.opS != null) {
            this.onk.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(long j) {
        if (this.onk != null) {
            this.onk.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0910a
    public void c(int i) {
        if (this.onk != null) {
            this.onk.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void a(int i) {
        if (this.onj != null) {
            if (this.opS != null) {
                this.onj.a(((VideoPlayer) this.opS).egB(), false);
            }
            this.onj.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.opD != null) {
            Point hj = tv.chushou.zues.utils.a.hj(this.opS);
            int i = hj.x > hj.y ? 1 : 2;
            if (this.oqJ == null) {
                this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.oqJ.setPlayerViewHelper(this.opR);
            this.oqJ.setVisibility(0);
            this.oqJ.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.onl != null) {
            this.onl.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.onl != null) {
            this.onl.a(bangInfo, str);
        }
        if (this.ojW != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.ojW.setText(this.opS.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.ojW.setText(this.opS.getString(a.i.str_contribute_tittle));
            } else {
                this.ojW.setText(Html.fromHtml(this.opS.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.omL != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.omL.setText(this.opS.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.omL.setText(this.opS.getString(a.i.str_contribute_tittle));
            } else {
                this.omL.setText(Html.fromHtml(this.opS.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.onl != null) {
            this.onl.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.opR != null && !h.isEmpty(this.opR.oiZ)) {
            this.ooj = this.opR.oiZ.get(0);
            if (this.ooA != null) {
                this.ooA.setVisibility(0);
                this.ooA.a(this.ooj.mCover, 0, 0, 0, 1);
                if (this.ooB != null) {
                    if (this.ooj.mShowClose) {
                        this.ooB.setVisibility(0);
                    } else {
                        this.ooB.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.onl != null) {
            this.onl.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.opD != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.okt != null) {
            this.okt.setPanelEnabled(gVar.f4071a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!aa() && !this.ooa) {
            if (iVar.f4073a == 52) {
                if (this.onP != null) {
                    this.onP.a(com.kascend.chushou.b.egb().c);
                    this.onP.notifyDataSetChanged();
                }
            } else if (iVar.f4073a == 50) {
                if (!this.ooa && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.aa()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.omX != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.omX);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!aa() && !this.ooa) {
            if (bVar.f4152a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.opS, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.f4152a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.f4152a == 6) {
                D();
            } else if (bVar.f4152a == 4) {
                com.kascend.chushou.player.ui.h5.b.b egC = ((VideoPlayer) this.opS).egC();
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(2, egC);
            } else if (bVar.f4152a == 3) {
                com.kascend.chushou.player.ui.h5.d.a egD = ((VideoPlayer) this.opS).egD();
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(2, egD);
            } else if (bVar.f4152a == 8) {
                if (this.ool != null && this.ool.getVisibility() != 0) {
                    this.ool.a(a.C0897a.slide_in_bottom_danmu_anim, a.C0897a.slide_out_bottom_danmu_anim, this.onI == null ? "" : this.onI.mRoomID);
                }
            } else if (bVar.f4152a == 9) {
                if (this.oqJ == null) {
                    this.oqJ = (H5Container) ((ViewStub) this.opD.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.oqJ.setVisibility(0);
                this.oqJ.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!aa() && this.opR != null && !h.isEmpty(this.opR.f4119a) && this.opR.f4119a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.ool != null && this.ool.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.opS, 80.0f);
                }
                if (this.ook != null && this.ook.getVisibility() == 0) {
                    r0 = Math.max(r0, this.ook.getHeight());
                }
                this.oov.setTranslationY(-r0);
                return;
            }
            if (this.oou != null) {
                this.oou.cancel();
                this.oou = null;
            }
            int translationY = (int) this.oov.getTranslationY();
            if (aVar.f4151a != 1 && 2 != aVar.f4151a) {
                if (3 == aVar.f4151a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.opS, 80.0f) : 0;
                    if (this.ook != null && this.ook.getVisibility() == 0) {
                        r0 = Math.max(r0, this.ook.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.ook.getHeight() : 0;
                    if (this.ool != null && this.ool.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.opS, 80.0f));
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
        this.oou = ValueAnimator.ofInt(i, i2);
        this.oou.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.aa() && c.this.onl != null) {
                    c.this.oov.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.oou.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.oou = null;
            }
        });
        this.oou.setInterpolator(new LinearInterpolator());
        this.oou.setDuration(800L);
        this.oou.start();
    }

    private boolean bg() {
        if (this.oog == 1) {
            this.oog = 2;
            x(true);
            return true;
        } else if (this.oog == 3) {
            ehN();
            return true;
        } else {
            return false;
        }
    }

    private boolean bh() {
        if (this.oog == 1) {
            return bi();
        }
        if (this.oog == 2) {
            this.oog = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean bi() {
        if (this.ooh || this.opR == null || this.opR.egW() == null) {
            return false;
        }
        if (this.opc != null) {
            this.opc.a(true);
        }
        this.oog = 3;
        this.ooh = true;
        bk();
        this.omx.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.ooh = false;
                c.this.omz.setVisibility(8);
            }
        });
        this.omz.startAnimation(loadAnimation);
        this.omx.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ehN() {
        if (!this.ooh) {
            if (this.opc != null) {
                this.opc.a(false);
            }
            this.oog = 1;
            this.ooh = true;
            bk();
            this.omz.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.ooh = false;
                    c.this.omx.setVisibility(8);
                }
            });
            this.omz.startAnimation(loadAnimation);
            this.omx.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.opD != null) {
            if (this.omx == null) {
                this.omx = this.opD.findViewById(a.f.user_space_container);
            }
            if (this.omz == null) {
                this.omz = this.opD.findViewById(a.f.video_container);
            }
            if (this.omy == null) {
                this.omy = com.kascend.chushou.view.user.b.c(null, this.opR.f4119a, false, this.opR.h);
                this.omy.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.ehN();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.ehN();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.omy).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.omA != null) {
            this.omA.setVisibility(z ? 8 : 0);
        }
        if (this.onF != null) {
            this.ooh = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.onF.setVisibility(8);
                        c.this.ooh = false;
                    }
                });
            } else {
                this.ooh = true;
                loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.onF.setVisibility(0);
                        c.this.ooh = false;
                    }
                });
            }
            this.onF.startAnimation(loadAnimation);
        }
        ehq();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.omR.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.omZ != null) {
                this.omZ.setVisibility(0);
            }
            if (this.ona != null) {
                this.ona.a();
                return;
            }
            return;
        }
        if (this.onc != null) {
            this.onc.setVisibility(0);
        }
        if (this.ond != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.ond.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.onc != null) {
            this.onc.setVisibility(8);
        }
        if (this.ond != null) {
            this.ond.clearAnimation();
        }
        if (this.omZ != null) {
            this.omZ.setVisibility(8);
        }
        if (this.ona != null) {
            this.ona.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.onF != null && this.opD != null) {
            if (this.ool == null) {
                this.ool = new com.kascend.chushou.player.ui.miniview.a(this.opS, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.ool != null && c.this.opD != null && c.this.ool.a()) {
                            ((ViewGroup) c.this.opD).removeView(c.this.ool);
                            c.this.ool = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ool.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.opS, 52.0f);
                this.ool.setLayoutParams(layoutParams);
                ((ViewGroup) this.onF).addView(this.ool, ((ViewGroup) this.onF).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.ool.setVisibility(8);
                } else {
                    this.ool.a(a.C0897a.slide_in_bottom_danmu_anim, a.C0897a.slide_out_bottom_danmu_anim, this.opR.f4119a == null ? "" : this.opR.f4119a);
                }
            } else if (!this.ool.isShown()) {
                this.ool.a(a.C0897a.slide_in_bottom_danmu_anim, a.C0897a.slide_out_bottom_danmu_anim, this.opR.f4119a == null ? "" : this.opR.f4119a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.oor != null && !h.isEmpty(listItem.mPackIcon)) {
                this.oor.setVisibility(0);
                this.oor.setAnim(true);
                this.oor.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.pnL, b.C1032b.pnN, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.onT != null && this.onT.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.ehO();
                    }
                });
                this.onT.setVisibility(0);
                this.onT.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.onT != null && this.onT.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.onV != null) {
                        c.this.onV.removeAllListeners();
                        c.this.onV.cancel();
                        c.this.onV = null;
                    }
                    if (c.this.onT != null) {
                        c.this.onT.setVisibility(8);
                    }
                }
            });
            this.onT.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.ooy == null) {
                this.ooy = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aa()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.opS, "显示双击666_num", null, new Object[0]);
                            if (c.this.opR != null) {
                                c.this.opR.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.opT != null) {
                    this.opT.e(this.ooy, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.ooy != null) {
            this.opT.L(this.ooy);
            this.ooy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.onW != null && this.onW.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.opS, a.C0897a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.ehP();
                    }
                });
                this.onW.setVisibility(0);
                this.onW.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.opC, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.onW != null && this.onW.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.opS, a.C0897a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.onY != null) {
                        c.this.onY.removeAllListeners();
                        c.this.onY.cancel();
                        c.this.onY = null;
                    }
                    if (c.this.onW != null) {
                        c.this.onW.setVisibility(8);
                    }
                }
            });
            this.onW.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator ehO() {
        if (this.onT == null || this.onU == null) {
            return null;
        }
        if (this.onV != null) {
            this.onV.removeAllListeners();
            this.onV.cancel();
            this.onV = null;
        }
        this.onU.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.onU, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.onU, 0.0f);
        int measuredWidth = (this.onT.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.opS, 13.0f) * 2)) - this.onU.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.onU, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.onU, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.onU, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.onV != null) {
                    c.this.onV.removeAllListeners();
                    c.this.onV.cancel();
                    c.this.onV = null;
                }
                RxExecutor.postDelayed(c.this.opC, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ehO();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.onV = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator ehP() {
        if (this.onW == null || this.onX == null) {
            return null;
        }
        if (this.onY != null) {
            this.onY.removeAllListeners();
            this.onY.cancel();
            this.onY = null;
        }
        this.onX.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.onX, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.onX, 0.0f);
        int measuredWidth = (this.onW.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.opS, 13.0f) * 2)) - this.onX.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.onX, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.onX, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.onX, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.onY != null) {
                    c.this.onY.removeAllListeners();
                    c.this.onY.cancel();
                    c.this.onY = null;
                }
                RxExecutor.postDelayed(c.this.opC, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ehP();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.onY = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.opc = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.ojv != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.ojv.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet et = com.kascend.chushou.c.a.et(jSONObject);
                        if (et.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.PQ(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.PQ(a.i.subscribe_success);
                            }
                            if (c.this.ojv != null) {
                                c.this.ojv.isSubscribe = !z;
                                c.this.ehk();
                                return;
                            }
                            return;
                        }
                        a(et.mRc, et.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.x(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.ege().a(bVar, (String) null, this.ojv.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.ojv.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.ege().b(bVar, (String) null, c.this.ojv.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.opR != null && this.onI != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.opR.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.opR.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.onI.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.aa()) {
                        ParserRet et = com.kascend.chushou.c.a.et(jSONObject);
                        if (et.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.PQ(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.PQ(a.i.subscribe_success);
                            }
                            c.this.onI.mIsSubscribed = !z;
                            c.this.ehl();
                            return;
                        }
                        a(et.mRc, et.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.aa()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.x(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.ege().a(bVar, (String) null, this.onI.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.onI.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.ege().b(bVar, (String) null, c.this.onI.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.omi != null) {
            int width = this.omi.getWidth();
            int height = this.omi.getHeight();
            if (this.oop != width || this.ooq != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ehu() {
        ((VideoPlayer) this.opS).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.opD != null) {
            if (this.onf == null) {
                this.onf = (InteractionView) ((ViewStub) this.opD.findViewById(a.f.view_interaction)).inflate();
                this.onf.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.onf.a();
                    }
                });
            }
            if (this.onf != null) {
                this.onf.b(configDetail);
                this.onf.c();
                this.onf.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.etZ()) {
                tv.chushou.zues.utils.g.K(this.opS, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.opS, null) && (this.opS instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.opR != null) {
                com.kascend.chushou.toolkit.a.c.a(this.opS, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.opS, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.opR != null) {
                com.kascend.chushou.toolkit.a.c.a(this.opS, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.opS, configDetail.mUrl, this.opS.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.opS, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.ooc) {
                        ehy();
                        return;
                    }
                    if (this.opS.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.opS, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.opR != null && this.opR.egU() != null && this.opR.egU().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.a("type", "4", "_clickPos", "27", "roomId", this.opR.egU().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    e(this.ong);
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
        if (this.opS != null && !this.v && !h.isEmpty(str) && this.onI != null && str.equals(this.onI.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.ojs == null) {
                this.ojs = new com.kascend.chushou.player.e.a();
            }
            this.ojs.b = str;
            this.ojs.omj.copy(pkNotifyInfo);
            if (this.ojs.omj.mAction == 6) {
                if (this.ojo != null) {
                    this.ojo.a(true);
                }
                this.ojs.omj.mInPKMode = true;
                this.u = this.ojs.omj.mPkId;
            } else if (this.ojs.omj.mAction == 7 || (this.ojs.omj.mMode == 1 && this.ojs.omj.mAction == 5)) {
                if (this.ojo != null) {
                    this.ojo.a(true);
                }
                this.ojs.omj.mInPKMode = true;
                if (this.oon != 42) {
                    this.ooz = ((this.ooo.y - ((this.ooo.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.opS, 158.0f) + this.onB)) - tv.chushou.zues.utils.systemBar.b.aD(getActivity());
                    aX();
                }
                this.u = this.ojs.omj.mPkId;
                if (this.ojt != null) {
                    this.ojt.b(this.ojs.omj, false);
                    this.ojt.a(this.ojs.omj.mMode, (String) null);
                    if (this.ojs.omj.mAction == 5 && this.ojs.omj.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.ojs.omj.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.ojs.omj.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.ojs.omj.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.ojs.omj.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.ojs.omj.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.ojt.a(this.ojs.omj);
                        this.ojt.a(parseInt, this.ojs.omj.mPkUpdateInfo.remainDuration, j, this.ojs.omj.mMode, (this.ojs.omj.destinyInfo == null || this.ojs.omj.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.ojs.omj.mPkUpdateInfo != null && !h.isEmpty(this.ojs.omj.mPkUpdateInfo.specialMomentList) && this.ojt != null) {
                    this.ojt.a(this.ojs.omj, true);
                }
                if (this.ojs.omj.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.ojs.omj.mInPKMode = false;
                if (this.ojs.omj.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        ehv();
        eht();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.ony != null && this.opR != null && this.opR.oja != null) {
            this.ony.setText(tv.chushou.zues.utils.b.PP(this.opR.oja.count));
            this.ony.setVisibility(0);
            if (this.opR.oja.count < 1) {
                bo();
            }
            if (this.onr != null) {
                this.onr.setText(this.opR.oja.primaryName);
            }
            if (this.ons != null) {
                this.ons.setText(this.opR.oja.desc);
            }
            ehg();
        }
    }

    public void ehg() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.onz * h.parseLong(this.opR.oja.point)));
        if (this.okL != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.opS.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.N(this.opS, a.e.icon_coin_new);
            cVar.append(this.opS.getString(a.i.str_buy_count_coin2));
            this.okL.setText(cVar);
        }
    }

    private void ehQ() {
        if (com.kascend.chushou.d.e.c(this.opS, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.onz);
        }
    }

    private void bo() {
        this.onA = false;
        this.onx.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.opR != null && this.opR.oja != null) {
            if (this.opR.oja.count < 1) {
                this.ony.setVisibility(8);
            } else {
                this.ony.setVisibility(0);
                this.ony.setSelected(false);
                this.ony.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.onq.setVisibility(8);
        if (this.omX != null) {
            this.omX.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.ojx != null) {
            if (z) {
                this.ojx.setVisibility(0);
            } else {
                this.ojx.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.ooZ != null) {
            this.ooZ.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.onh != null) {
            this.onh.performClick();
        }
    }
}
