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
    private TextView mKA;
    private TextView mKD;
    private ImageView mKJ;
    private TextView mKS;
    private View mKp;
    public String mKw;
    private TextView mLC;
    private View mLF;
    private KPSwitchPanelLinearLayout mLa;
    private ImageView mLb;
    private tv.chushou.zues.widget.kpswitch.b.c mLd;
    private d.a mLe;
    private TextView mLs;
    private TextView mMA;
    private ImageView mNA;
    private RelativeLayout mNB;
    private PastedEditText mNC;
    private ToggleButton mND;
    private RelativeLayout mNE;
    private PaoPaoView mNF;
    private FrescoThumbnailView mNG;
    private LinearLayout mNH;
    private ImageView mNI;
    private InteractionView mNJ;
    private LinearLayout mNK;
    private FrescoThumbnailView mNL;
    private FrameLayout mNM;
    private RedpacketNotifier mNN;
    private InteractNotifier mNO;
    private EmbeddedButtonLayout mNP;
    private GiftAnimationLayout mNQ;
    private com.kascend.chushou.player.b.a mNR;
    private f mNS;
    private PlayShowH5View mNT;
    private LinearLayout mNU;
    private TextView mNV;
    private TextView mNW;
    private TextView mNX;
    private TextView mNY;
    private TextView mNZ;
    private int mNa;
    private View mNb;
    private View mNc;
    private com.kascend.chushou.view.user.b mNd;
    private View mNe;
    private FrameLayout mNf;
    private LinearLayout mNg;
    private RelativeLayout mNh;
    private FrescoThumbnailView mNi;
    private TextView mNj;
    private TextView mNk;
    private TextView mNl;
    private FrescoThumbnailView mNm;
    private TextView mNn;
    private TextView mNo;
    private TextView mNp;
    private TextView mNq;
    private LinearLayout mNr;
    private PlayShowMicStatusView mNs;
    private RecyclerView mNt;
    private ImageView mNu;
    private PlayShowRecommendView mNv;
    private View mNw;
    private RelativeLayout mNx;
    private AnimationSet mNy;
    private ImageView mNz;
    private View mOA;
    private View mOB;
    private Animator mOC;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mOF;
    private PlayShowMicPerson mOJ;
    private FoodView mOM;
    public ListItem mON;
    private FoodView mOO;
    private com.kascend.chushou.player.ui.miniview.a mOP;
    private int mOQ;
    private int mOR;
    private int mOS;
    private Point mOT;
    private FrescoThumbnailView mOW;
    private FrescoThumbnailView mOX;
    private ValueAnimator mOZ;
    private TextView mOa;
    private ImageView mOb;
    private TextView mOc;
    private PopupWindow mOh;
    private View mOj;
    private RecyclerView mOl;
    private RoomInfo mOm;
    private RecyclerView.LayoutManager mOo;
    private ArrayList<ChatInfo> mOp;
    private ArrayList<ChatInfo> mOq;
    private ArrayList<ChatInfo> mOr;
    private ArrayList<ChatInfo> mOs;
    private Button mOw;
    private View mOx;
    private View mOy;
    private Animator mOz;
    private FrescoThumbnailView mPA;
    private TextView mPB;
    private TextView mPC;
    private ImageView mPD;
    private RelativeLayout mPE;
    private TextView mPG;
    private float mPH;
    private float mPI;
    private a mPJ;
    private LinearLayout mPa;
    private long mPb;
    private VideoShowVoteView mPc;
    private Runnable mPd;
    private FrescoThumbnailView mPf;
    private ImageView mPg;
    private RelativeLayout mPh;
    private TextView mPi;
    private ImageView mPj;
    private EditText mPk;
    private View mPl;
    private RelativeLayout mPo;
    private RelativeLayout mPp;
    private FrescoThumbnailView mPq;
    private TextView mPr;
    private TextView mPs;
    private ImageView mPt;
    private RelativeLayout mPu;
    private LinearLayout mPv;
    private TextView mPw;
    private TextView mPx;
    private RelativeLayout mPy;
    private RelativeLayout mPz;
    private boolean mLc = false;
    private int mOd = 1;
    private boolean mOe = false;
    private int mOf = 0;
    private int mOg = 0;
    private int mOi = -1;
    private boolean mOk = false;
    private FullRoomInfo mOn = null;
    private com.kascend.chushou.player.adapter.a mOt = null;
    private ArrayList<String> mOu = null;
    private boolean mOv = true;
    private boolean mOD = true;
    private boolean mOE = false;
    public final List<OnlineVipItem> mOG = new ArrayList();
    private boolean mOH = false;
    private boolean mOI = false;
    private long mOK = 0;
    private int mOL = 1;
    private boolean dx = false;
    private int mOU = -1;
    private int mOV = -1;
    private boolean mOY = false;
    private int mPe = -1;
    private io.reactivex.disposables.b mPF = null;

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
        this.mKw = getArguments().getString("cover");
        this.mOD = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mQi = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mQi;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dFE()) {
            dEZ();
            this.mMN = ((VideoPlayer) this.mQy).dEi();
            this.mQx = ((VideoPlayer) this.mQy).dEl();
            ds(view);
            dFg();
            if (this.mQy instanceof VideoPlayer) {
                ((VideoPlayer) this.mQy).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mOE = false;
        if (this.mRd != null) {
            this.mRd.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mOE = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mOz != null) {
            this.mOz.removeAllListeners();
            this.mOz.cancel();
            this.mOz = null;
        }
        if (this.mOC != null) {
            this.mOC.removeAllListeners();
            this.mOC.cancel();
            this.mOC = null;
        }
        if (this.mNO != null) {
            this.mNO.c();
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
        if (this.mPF != null) {
            this.mPF.dispose();
            this.mPF = null;
        }
        this.mOd = 1;
        this.mOe = false;
        if (this.mQz != null) {
            this.mQz.cg(null);
        }
        if (this.mOh != null) {
            this.mOh.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mQy, this.mLd);
        if (this.mQy != null && (this.mQy instanceof VideoPlayer)) {
            ((VideoPlayer) this.mQy).dEp();
        }
        this.mLe = null;
        this.mLd = null;
        dEX();
        if (this.mNR != null) {
            this.mNR.a();
        }
        if (this.mNF != null) {
            this.mNF.b();
            this.mNF.c();
            this.mNF = null;
        }
        super.d();
    }

    private void dEX() {
        tv.chushou.zues.a.a.ch(this);
        if (this.mOr != null) {
            this.mOr.clear();
        }
        if (this.mOp != null) {
            this.mOp.clear();
        }
        if (this.mOs != null) {
            this.mOs.clear();
        }
        if (this.mOq != null) {
            this.mOq.clear();
        }
        if (this.mOu != null) {
            this.mOu.clear();
        }
        if (this.mOt != null) {
            this.mOt.a(0);
            this.mOt.a();
        }
    }

    private void ds(View view) {
        this.mNb = view.findViewById(a.f.fl_root);
        this.mOT = tv.chushou.zues.utils.a.gw(this.mQy);
        this.mOf = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mQy);
        this.mOg = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        this.mOS = 86;
        this.mQx = ((VideoPlayer) this.mQy).dEl();
        if (this.mQx != null) {
            this.mOm = this.mQx.dEO();
            this.mOn = this.mQx.dEL();
        }
        this.mOp = new ArrayList<>();
        this.mOr = new ArrayList<>();
        this.mOq = new ArrayList<>();
        this.mNf = (FrameLayout) this.mQi.findViewById(a.f.fl_effect);
        b();
        this.mQs = (PlayerErrorView) this.mQi.findViewById(a.f.view_net_error_msg);
        this.mQs.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mNE = (RelativeLayout) this.mQi.findViewById(a.f.rl_audio_ani);
        this.mNF = (PaoPaoView) this.mQi.findViewById(a.f.audio_ani);
        this.mNG = (FrescoThumbnailView) this.mQi.findViewById(a.f.audio_ani_avatar);
        this.mNH = (LinearLayout) this.mQi.findViewById(a.f.ll_audio);
        this.mMA = (TextView) this.mQi.findViewById(a.f.tv_open_video);
        this.mNI = (ImageView) this.mQi.findViewById(a.f.iv_audio_ani);
        this.mOX = (FrescoThumbnailView) this.mQi.findViewById(a.f.live_cover);
        if (!this.mOY || this.mMN == null || this.mMN.getPlayState() != 4) {
            this.mOX.setVisibility(0);
            this.mOX.setBlur(true);
            this.mOX.i(this.mKw, 0, 0, 0);
        }
        this.mMA.setOnClickListener(this);
        this.mKa = new b();
        this.mKa.a(view, null, this.mQy, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dRp()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mQx != null) {
                    append.append(c.this.mQx.dEO().mRoomID);
                }
                if (c.this.mJZ != null && c.this.mJZ.mMO != null) {
                    append.append("&mode=").append(c.this.mJZ.mMO.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mQy, append.toString());
            }
        });
        this.mKe = (VoiceInteractionView) this.mQi.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mQx != null) {
            this.mOm = this.mQx.dEO();
            this.mOn = this.mQx.dEL();
        }
        dFa();
        dEY();
        dFb();
        this.mPa = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mOM = (FoodView) view.findViewById(a.f.rav_ad);
        this.mPf = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mPg = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mPf.setOnClickListener(this);
        this.mPg.setOnClickListener(this);
        this.mPh = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mOW = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mOW.setOnClickListener(this);
        this.mNO = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mNN = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mOw = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mOw.setOnClickListener(this);
        this.mOl = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mOl.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOl.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mOT.x, this.mOT.y) * 0.83d);
        this.mOl.setLayoutParams(layoutParams);
        this.mOo = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mQy);
        this.mOl.setLayoutManager(this.mOo);
        this.mOl.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mOl.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mOl.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.mOv = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mOt = new com.kascend.chushou.player.adapter.a(this.mQy, this.mOp);
        if (this.mOm != null) {
            this.mOt.a(this.mOm);
        }
        if (com.kascend.chushou.b.dDS().c != null) {
            this.mOt.a(com.kascend.chushou.b.dDS().c);
        }
        this.mOl.setAdapter(this.mOt);
        this.mOt.a(this.mOp.size());
        this.mOt.notifyDataSetChanged();
        if (this.mQx != null && (c = this.mQx.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mNR != null) {
            this.mNR.a();
            this.mNR = null;
        }
        this.mNQ = (GiftAnimationLayout) this.mQi.findViewById(a.f.ll_gift_animation);
        this.mNQ.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mNa = ((int) (tv.chushou.zues.utils.a.gv(this.mQy).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mQy, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mNQ.getLayoutParams();
        layoutParams2.bottomMargin = this.mNa;
        this.mNQ.setLayoutParams(layoutParams2);
        if (this.mQx != null) {
            this.mNR = new com.kascend.chushou.player.b.a(this.mQy.getApplicationContext(), this.mNQ);
            this.mNR.a(this.mQx);
            a(this.mQx.mJF, this.mQx.mJI);
        }
        this.mQi.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mNP = (EmbeddedButtonLayout) this.mQi.findViewById(a.f.embedded_button_layout);
        this.mNP.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mPc = (VideoShowVoteView) this.mQi.findViewById(a.f.view_video_show_vote);
        this.mPc.setOnClickListener(this);
        this.mPc.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.mQx != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
            this.mNP.a(videoPlayer.dEv().dFL());
            this.mNP.b(this.mQx.dEN());
            this.mNN.a(videoPlayer.dEr(), false);
            this.mNO.a(videoPlayer.dEs(), videoPlayer.dEt(), videoPlayer.dEu());
            this.mJZ = new com.kascend.chushou.player.e.a();
        }
        this.mRn = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mOH = false;
                c.this.b(c.this.mNa, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mOH = true;
                if (c.this.mRd != null) {
                    c.this.mRd.measure(0, 0);
                    int measuredHeight = c.this.mRd.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mQy, 14.0f);
                    if (measuredHeight > c.this.mNa) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mRh = (PaoGuideView) this.mQi.findViewById(a.f.rlPaoGuideView);
        this.mOJ = (PlayShowMicPerson) this.mQi.findViewById(a.f.rl_mic_person_view);
        this.mNT = (PlayShowH5View) this.mQi.findViewById(a.f.rl_playshowh5);
        this.mOO = (FoodView) this.mQi.findViewById(a.f.bottom_ad);
        if (this.mQx != null) {
            H();
            if (this.mQx.mJz != null && !h.isEmpty(this.mQx.mJz.mUrl)) {
                b(this.mQx.mJz);
            }
        }
        this.mOx = this.mQi.findViewById(a.f.view_reminder_subscribe);
        this.mOy = this.mOx.findViewById(a.f.spash_subscribe);
        ((TextView) this.mOx.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.mQy, a.e.videoplayer_reminder_subscribe).append(" ").append(this.mQy.getString(a.i.videoplayer_reminder_subscribe)));
        this.mOx.setOnClickListener(this);
        this.mOA = this.mQi.findViewById(a.f.view_reminder_danmaku);
        this.mOB = this.mOA.findViewById(a.f.spash_danmaku);
        ((TextView) this.mOA.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.mQy, a.e.videoplayer_reminder_danmaku).append(" ").append(this.mQy.getString(a.i.videoplayer_reminder_danmaku)));
        this.mOA.setOnClickListener(this);
    }

    private void dEY() {
        this.mPo = (RelativeLayout) this.mQi.findViewById(a.f.rl_cyclelive);
        this.mPp = (RelativeLayout) this.mQi.findViewById(a.f.rlrl_cyclelive);
        this.mPq = (FrescoThumbnailView) this.mQi.findViewById(a.f.iv_liveicon);
        this.mPr = (TextView) this.mQi.findViewById(a.f.tv_livename);
        this.mPs = (TextView) this.mQi.findViewById(a.f.tv_livedesc);
        this.mPt = (ImageView) this.mQi.findViewById(a.f.iv_cyclelive_name_menu);
        this.mPu = (RelativeLayout) this.mQi.findViewById(a.f.rl_normal);
        this.mPv = (LinearLayout) this.mQi.findViewById(a.f.ll_cyclelive_nickname);
        this.mPw = (TextView) this.mQi.findViewById(a.f.tv_cyclelive_nickname);
        this.mPx = (TextView) this.mQi.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mPy = (RelativeLayout) this.mQi.findViewById(a.f.rl_clear_cyclelive);
        this.mPz = (RelativeLayout) this.mQi.findViewById(a.f.rlrl_clear_cyclelive);
        this.mPA = (FrescoThumbnailView) this.mQi.findViewById(a.f.iv_clear_liveicon);
        this.mPB = (TextView) this.mQi.findViewById(a.f.tv_clear_livename);
        this.mPC = (TextView) this.mQi.findViewById(a.f.tv_clear_livedesc);
        this.mPD = (ImageView) this.mQi.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mPE = (RelativeLayout) this.mQi.findViewById(a.f.rl_clear_normal);
        this.mPD.setOnClickListener(this);
        this.mPt.setOnClickListener(this);
        this.mPx.setOnClickListener(this);
        this.mPw.setOnClickListener(this);
        this.mPq.setOnClickListener(this);
        this.mPA.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mQx.mJx != null && this.mOO != null) {
            this.mOO.a(true, this.mQx.a == null ? "" : this.mQx.a);
            this.mOO.a(this.mQx.mJx, a.C0794a.slide_in_bottom_danmu_anim, a.C0794a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mQx != null && this.mQx.mJE != null && this.mNP != null) {
            this.mOM.a(this.mQx.mJE, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mQx != null) {
                        c.this.mQx.mJE = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dFl() {
        return this.mNR;
    }

    private void dEZ() {
        this.mQz = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mQi != null && (textView = (TextView) c.this.mQi.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mQy.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mQz.A(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mQz);
                        break;
                    case 12:
                        c.this.b(c.this.mQz);
                        break;
                    case 17:
                        c.this.dFG();
                        break;
                    case 18:
                        c.this.dsF();
                        break;
                    case 19:
                        c.this.mQw.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mOk) {
            this.mOk = true;
            if (this.mOj == null) {
                this.mOj = this.mQi.findViewById(a.f.vs_async_show_content);
                this.mOj = ((ViewStub) this.mOj).inflate();
            }
            this.mKp = this.mQi.findViewById(a.f.ui_content);
            if (this.mLF == null) {
                this.mLF = this.mQi.findViewById(a.f.vs_async_notification_view);
                this.mLF = ((ViewStub) this.mLF).inflate();
            }
            c(this.mQi);
            k();
            dsG();
            if (this.c == null) {
                this.mJT = new d.a();
                this.c = new GestureDetector(this.mQy, this.mJT);
            }
            ((VideoPlayer) this.mQy).q();
        }
    }

    private void dFa() {
        this.mNg = (LinearLayout) this.mQi.findViewById(a.f.ll_anchor);
        this.mNh = (RelativeLayout) this.mQi.findViewById(a.f.ll_clear_anchor);
        this.mNg.setVisibility(4);
        this.mNh.setVisibility(4);
        this.mNi = (FrescoThumbnailView) this.mQi.findViewById(a.f.iv_clear_avatar);
        this.mNj = (TextView) this.mQi.findViewById(a.f.tv_clear_nickname);
        this.mNk = (TextView) this.mQi.findViewById(a.f.tv_clear_online_count);
        this.mNl = (TextView) this.mQi.findViewById(a.f.tv_clear_btn_subscribe);
        this.mNl.setOnClickListener(this);
        this.mNm = (FrescoThumbnailView) this.mQi.findViewById(a.f.iv_avatar);
        this.mNn = (TextView) this.mQi.findViewById(a.f.tv_nickname_test);
        this.mNo = (TextView) this.mQi.findViewById(a.f.tv_online_count);
        this.mKA = (TextView) this.mQi.findViewById(a.f.tv_btn_subscribe);
        this.mKA.setOnClickListener(this);
        this.mNp = (TextView) this.mQi.findViewById(a.f.tv_loyal_counts);
        this.mKD = (TextView) this.mQi.findViewById(a.f.tv_btn_contribution);
        this.mNq = (TextView) this.mQi.findViewById(a.f.tv_btn_contribution_forpk);
        this.mKD.setVisibility(4);
        this.mNq.setVisibility(8);
        this.mNr = (LinearLayout) this.mQi.findViewById(a.f.ll_mic);
        this.mNs = (PlayShowMicStatusView) this.mQi.findViewById(a.f.show_mic_status);
        this.mNt = (RecyclerView) this.mQi.findViewById(a.f.rv_loyal);
        this.mNu = (ImageView) this.mQi.findViewById(a.f.iv_clear_close);
        this.mKJ = (ImageView) this.mQi.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mNt.setLayoutManager(linearLayoutManager);
        this.mOF = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mOG, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mOG.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mQy, (JSONObject) null, c.this.mQx.dEO().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0920a view$OnLongClickListenerC0920a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0920a view$OnLongClickListenerC0920a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0920a.KB(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0920a.KB(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0920a.KB(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dRB(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mQy, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mQy, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mQy, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mQy, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mQy, a.c.color_979797), dip2px);
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
                        textView.setText(tv.chushou.zues.utils.b.bT(onlineVipItem.mScore, 3));
                    }
                }
            }
        };
        this.mNt.setAdapter(this.mOF);
        this.mNr.setOnClickListener(this);
        this.mNi.setOnClickListener(this);
        this.mNu.setOnClickListener(this);
        this.mNm.setOnClickListener(this);
        this.mNi.setOnClickListener(this);
        this.mKJ.setOnClickListener(this);
        this.mNp.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String str = tv.chushou.common.a.dRp() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mQx != null) {
                    str = str + c.this.mQx.dEO().mRoomID;
                }
                c.this.f(c.this.mQy.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mKD.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String str = tv.chushou.common.a.dRp() + "m/room-billboard/";
                if (c.this.mQx != null) {
                    str = str + c.this.mQx.dEO().mRoomID;
                }
                c.this.f(c.this.mQy.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mNq.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String str = tv.chushou.common.a.dRp() + "m/room-billboard/";
                if (c.this.mQx != null) {
                    str = str + c.this.mQx.dEO().mRoomID;
                }
                c.this.f(c.this.mQy.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.mOn == null || this.mOn.cycleLiveRoomInfo == null || h.isEmpty(this.mOn.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mKc = this.mOn.cycleLiveRoomInfo;
        }
        if (z2 && this.mKc != null) {
            this.mPo.setVisibility(0);
            this.mPy.setVisibility(0);
            this.mPu.setVisibility(8);
            this.mPE.setVisibility(8);
            this.mPv.setVisibility(0);
            this.mPA.h(this.mKc.eventIcon, com.kascend.chushou.view.a.a(this.mOm.mCreatorGender), b.a.small, b.a.small);
            this.mPq.h(this.mKc.eventIcon, com.kascend.chushou.view.a.a(this.mOm.mCreatorGender), b.a.small, b.a.small);
            this.mPB.setText(this.mKc.eventName);
            this.mPC.setText(this.mKc.eventDesc);
            this.mPr.setText(this.mKc.eventName);
            this.mPs.setText(this.mKc.eventDesc);
            this.mPw.setText(this.mKc.nickname);
            aN();
            if (z) {
                c(this.mKc.remainTime);
                return;
            }
            return;
        }
        this.mPo.setVisibility(8);
        this.mPy.setVisibility(8);
        this.mPu.setVisibility(0);
        this.mPE.setVisibility(0);
        this.mPv.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mPF != null) {
            this.mPF.dispose();
            this.mPF = null;
        }
        this.mPF = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKy()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mQy != null && (c.this.mQy instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mQy).u();
                }
            }
        });
    }

    private void aM() {
        if (this.mOm != null && this.mOk) {
            this.mNg.setVisibility(0);
            this.mNh.setVisibility(0);
            this.mKD.setVisibility(0);
            this.mNi.h(this.mOm.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mOm.mCreatorGender), b.a.small, b.a.small);
            this.mNj.setText(this.mOm.mCreatorNickname);
            this.mNm.h(this.mOm.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mOm.mCreatorGender), b.a.small, b.a.small);
            this.mNn.setText(this.mOm.mCreatorNickname);
            dFv();
            aO();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dFv() {
        if (this.mOm != null) {
            this.mNk.setText(tv.chushou.zues.utils.b.formatNumber(this.mOm.mOnlineCount));
            this.mNo.setText(tv.chushou.zues.utils.b.formatNumber(this.mOm.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.mKc != null) {
            if (this.mKc.isSubscribe) {
                this.mPx.setText(a.i.like_already);
                this.mPx.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mPx.setText(getString(a.i.like));
            this.mPx.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        if (this.mOm != null) {
            if (this.mOm.mIsSubscribed) {
                this.mNl.setText(getString(a.i.like_already));
                this.mNl.setBackgroundResource(a.e.bg_show_subcribe);
                this.mKA.setText(getString(a.i.like_already));
                this.mKA.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mNl.setText(getString(a.i.like));
            this.mNl.setBackgroundResource(a.e.bg_show_subcribe);
            this.mKA.setText(getString(a.i.like));
            this.mKA.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void aP() {
        if (this.mOF != null) {
            this.mOF.notifyDataSetChanged();
        }
    }

    private void dFb() {
        this.mNw = this.mQi.findViewById(a.f.tv_interact);
        this.mNw.setOnClickListener(this);
        this.mNB = (RelativeLayout) this.mQi.findViewById(a.f.rl_edit_bar);
        this.mNz = (ImageView) this.mQi.findViewById(a.f.btn_hotword);
        this.mNz.setOnClickListener(this);
        this.mNA = (ImageView) this.mQi.findViewById(a.f.iv_task_badge);
        this.mNy = (AnimationSet) AnimationUtils.loadAnimation(this.mQy, a.C0794a.anim_hotword);
        this.mNy.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dDZ().c) {
                    c.this.mNz.clearAnimation();
                    c.this.mNz.startAnimation(c.this.mNy);
                }
            }
        });
        if (com.kascend.chushou.d.h.dDZ().c) {
            this.mNz.startAnimation(this.mNy);
            this.mNA.setVisibility(0);
        }
        this.mPG = (TextView) this.mQi.findViewById(a.f.tv_bottom_input);
        this.mPG.setOnClickListener(this);
        this.mRy = (FrescoThumbnailView) this.mQi.findViewById(a.f.ll_btn_set);
        this.mRy.setOnClickListener(this);
        this.mRy.yE(a.e.ic_room_set_btn_white);
        this.mNK = (LinearLayout) this.mQi.findViewById(a.f.ll_bottom_all_button);
        this.mNL = (FrescoThumbnailView) this.mQi.findViewById(a.f.fl_clear_bottom_gift);
        this.mNL.setAnim(true);
        this.mNL.setOnClickListener(this);
        this.mNL.yE(a.e.ic_show_gift_n);
        this.mNM = (FrameLayout) this.mQi.findViewById(a.f.flfl_clear_bottom_gift);
        this.mNM.setVisibility(8);
        this.mNx = (RelativeLayout) this.mQi.findViewById(a.f.rl_bottom_input);
        this.mNx.setVisibility(0);
        this.mNC = (PastedEditText) this.mQi.findViewById(a.f.et_bottom_input);
        this.mNC.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mKS.setEnabled(editable.length() > 0);
            }
        });
        this.mNC.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mKS);
                    return true;
                }
                return true;
            }
        });
        this.mNC.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.m(c.this.mNC);
                }
                return false;
            }
        });
        this.mLb = (ImageView) this.mQi.findViewById(a.f.iv_btn_emoji);
        this.mLb.setVisibility(8);
        this.mKS = (TextView) this.mQi.findViewById(a.f.tv_btn_send);
        this.mKS.setOnClickListener(this);
        this.mNU = (LinearLayout) this.mQi.findViewById(a.f.head_trumpet);
        this.mNU.setVisibility(8);
        this.mNU.setOnClickListener(this);
        this.mNV = (TextView) this.mQi.findViewById(a.f.tv_primary_name);
        this.mNW = (TextView) this.mQi.findViewById(a.f.tv_primary_desc);
        this.mNY = (TextView) this.mQi.findViewById(a.f.tv_cut_count);
        this.mNY.setOnClickListener(this);
        this.mOa = (TextView) this.mQi.findViewById(a.f.tv_head_count);
        this.mOa.setText(this.mOd + "");
        this.mNZ = (TextView) this.mQi.findViewById(a.f.tv_plus_count);
        this.mNZ.setOnClickListener(this);
        this.mLs = (TextView) this.mQi.findViewById(a.f.tv_buy_count_coin);
        this.mNX = (TextView) this.mQi.findViewById(a.f.tv_buy_head);
        this.mNX.setOnClickListener(this);
        this.mOb = (ImageView) this.mQi.findViewById(a.f.iv_trumpet_select);
        this.mOb.setOnClickListener(this);
        this.mOc = (TextView) this.mQi.findViewById(a.f.tv_trumpet_have_count);
        this.mOe = false;
        this.mOb.setBackgroundResource(a.e.ic_trumpet_n);
        this.mOc.setVisibility(8);
        this.mLa = (KPSwitchPanelLinearLayout) this.mQi.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mLa, this.mLb, this.mNC, new a.InterfaceC0924a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0924a
            public void wz(boolean z) {
                if (c.this.mLb != null) {
                    if (z) {
                        c.this.mLa.setDirectVisibility(0);
                        c.this.mLb.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mLb.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mLe = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wA(boolean z) {
                c.this.mLc = z;
                if (z) {
                    c.this.mLb.setImageResource(a.e.cs_emoji_normal);
                    c.this.dFd();
                    if (c.this.mPl != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mPl.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gI(c.this.mQy);
                        c.this.mPl.setLayoutParams(layoutParams);
                    }
                    if (c.this.mNB != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mNB.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gI(c.this.mQy);
                        c.this.mNB.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mPl != null && c.this.mPl.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mPl.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mPl.setLayoutParams(layoutParams3);
                    c.this.mPl.setVisibility(8);
                }
                if (c.this.mOH) {
                    c.this.mRd.setVisibility(0);
                }
                if (c.this.mQy != null && (c.this.mQy instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mQy).wy(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mNB != null && c.this.mLa.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mNB.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mNB.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mLd = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mLa, this.mLe, ((VideoPlayer) this.mQy).dEq());
        ((VideoPlayer) this.mQy).h(((VideoPlayer) this.mQy).dEq());
        this.mPl = this.mQi.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mPi = (TextView) this.mQi.findViewById(a.f.btn_room_search);
        this.mPj = (ImageView) this.mQi.findViewById(a.f.iv_room_emoji_delete);
        this.mPk = (EditText) this.mQi.findViewById(a.f.et_room_emoji_search);
        this.mPk.setImeOptions(3);
        this.mPk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mPi);
                    return true;
                }
                return false;
            }
        });
        this.mPk.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mPi.setEnabled(editable.length() > 0);
                c.this.mPj.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mRd.setEmojiSearchText(editable.toString());
            }
        });
        this.mPi.setOnClickListener(this);
        this.mPj.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dD(this.mPk);
            this.mPl.setVisibility(0);
            this.mPk.requestFocus();
        } else {
            this.mPl.setVisibility(8);
        }
        if (z2) {
            this.mPk.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFd() {
        int gI = tv.chushou.zues.widget.kpswitch.b.d.gI(this.mQy) + tv.chushou.zues.utils.a.dip2px(this.mQy, 14.0f);
        if (gI > this.mNa) {
            b(gI, 12);
        }
    }

    private void aS() {
    }

    private void dFg() {
        if (this.mOg > 0) {
            View findViewById = this.mQi.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mOg);
        }
        if (this.mOf > 0) {
            View findViewById2 = this.mQi.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mOf, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mOD) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.mJV = ((VideoPlayer) this.mQy).dEm();
        this.mJV.a(this);
        if (this.mQx.dEL() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mJV != null) {
            this.mJV.d();
        }
    }

    private void dFh() {
        if ((this.mJZ == null || this.mJZ.mMO == null || !this.mJZ.mMO.mInPKMode) ? false : true) {
            if (this.mNb != null) {
                this.mNb.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mKb.getLayoutParams();
            layoutParams.leftMargin = (this.mOT.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mQy, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mKb.setLayoutParams(layoutParams);
            this.y.setText(this.mJZ.mMO.mPkUserNickname);
            this.mKb.setVisibility(0);
            this.mNr.setVisibility(8);
            return;
        }
        if (this.mNb != null) {
            this.mNb.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mKb.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.mJZ != null && this.mJZ.mMO != null && this.mJZ.mMO.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mPe > 0 && this.mOl != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOl.getLayoutParams();
                if (layoutParams.height != this.mPe) {
                    layoutParams.height = this.mPe;
                    this.mOl.setLayoutParams(layoutParams);
                }
            }
            this.mNa = ((int) (tv.chushou.zues.utils.a.gv(this.mQy).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mQy, 84.0f);
            b(this.mNa, 12);
        } else {
            if (this.mOl != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mOl.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mQy, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mQy, 250.0f);
                    this.mOl.setLayoutParams(layoutParams2);
                }
            }
            this.mNa = ((int) (tv.chushou.zues.utils.a.gv(this.mQy).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mQy, 84.0f);
            b(this.mNa, 12);
        }
        if (this.mKa != null) {
            this.mKa.a(this.mPe + tv.chushou.zues.utils.a.dip2px(this.mQy, 52.0f), this.aq);
        }
        if (this.mKe != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mKe.getLayoutParams();
            layoutParams3.bottomMargin = this.mPe + tv.chushou.zues.utils.a.dip2px(this.mQy, 52.0f);
            this.mKe.setLayoutParams(layoutParams3);
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

    private void dFj() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dFF().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mOT = tv.chushou.zues.utils.a.gw(this.mQy);
        this.mOS = 86;
        this.mOQ = (Math.max(this.mOT.x, this.mOT.y) - tv.chushou.zues.utils.a.dip2px(this.mQy, (this.mOS + 52) + 250)) - this.mOf;
        this.mOR = Math.max(this.mOT.x, this.mOT.y) - ((tv.chushou.zues.utils.a.dip2px(this.mQy, this.mOS) + this.mOf) * 2);
        if (this.mOU <= 0 || this.mOV <= 0) {
            this.mOU = Math.min(this.mOT.x, this.mOT.y);
            this.mOV = Math.max(this.mOT.x, this.mOT.y);
        }
        this.ar = Math.min(this.mOT.x, this.mOT.y);
        this.aq = (this.ar * this.mOV) / this.mOU;
        boolean z = false;
        if (this.mJZ == null || this.mJZ.mMO == null) {
            i = 1;
        } else {
            i = this.mJZ.mMO.mMode;
            if (this.mJZ.mMO.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mOS = 42;
            if (i == 2) {
                if (this.mOV < this.mOU) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mOU * layoutParams.height) / this.mOV;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, this.mOS) + this.mOf;
            layoutParams.gravity = 48;
            this.mPe = ((this.mOT.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mQy, (this.mOS + 52) + 64) + this.mOf)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            aG();
        } else if (this.E) {
            this.mOS = 42;
            if (this.mOV < this.mOU) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mOU * layoutParams.height) / this.mOV;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, this.mOS) + this.mOf;
            layoutParams.gravity = 48;
            this.mPe = ((this.mOT.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mQy, (this.mOS + 52) + 98) + this.mOf)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            dFj();
        } else {
            this.mPe = -1;
            this.mOS = 86;
            if (this.aq <= this.mOQ) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mOQ;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, this.mOS) + this.mOf;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.mOR) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, this.mOS) + this.mOf;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.mOT.x, this.mOT.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.mOU) / this.mOV >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.mOU) / this.mOV;
                    } else if ((this.ar * this.mOV) / this.mOU >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mOV) / this.mOU;
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
                    if ((this.ar * this.mOV) / this.mOU > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.mOU) / this.mOV;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mOV) / this.mOU;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mOV) / this.mOU;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.mOU) / this.mOV;
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
        if (this.mQx != null && this.mQx.d) {
            layoutParams.width = Math.min(this.mOT.x, this.mOT.y);
            layoutParams.height = Math.max(this.mOT.x, this.mOT.y);
        }
        dFF().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void aY() {
        this.N = new SurfaceRenderView(this.mQy);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dFF().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.dx) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dFy();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dFx();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mPJ != null) {
            this.mPJ.a();
        }
        if (this.mQx != null && !h.isEmpty(this.mQx.w)) {
            b(this.mQx.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mMN != null) {
            int width = this.mMN.getWidth();
            int height = this.mMN.getHeight();
            if (this.mOU != width || this.mOV != height || this.mOU <= 0 || this.mOV <= 0) {
                this.mOU = width;
                this.mOV = height;
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
            if (this.mOH) {
                aD();
            } else {
                if (this.mQy.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mQx.dEL().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mOe) {
                f(this.mNC.getText().toString());
            } else {
                a(this.mNC.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dDZ().c) {
                com.kascend.chushou.d.h.dDZ().b(false);
                this.mNy.cancel();
                this.mNy.reset();
                this.mNz.clearAnimation();
                this.mNA.setVisibility(8);
            }
            n(view, 0, this.mQi.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mQy, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.mQi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mQx.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mQx.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mOl != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mOm != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mOL = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mQy, (JSONObject) null, this.mQx.dEO().mRoomID, this.mQx.dEO().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mQy.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mQy, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mON != null) {
                    com.kascend.chushou.d.e.a(this.mQy, this.mON, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mPh != null) {
                    this.mPh.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mQy, null) && this.mQx != null && this.mQx.mJH != null) {
                    if (this.mOe) {
                        bo();
                    } else {
                        if (this.mQx != null && this.mQx.mJH != null && this.mQx.mJH.count > 0) {
                            this.mNU.setVisibility(8);
                        } else {
                            this.mNU.setVisibility(0);
                        }
                        this.mOe = true;
                        this.mOb.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mOc.setVisibility(0);
                        this.mOc.setSelected(true);
                        this.mOc.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mNC != null) {
                            this.mNC.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mOd <= 9) {
                    this.mOd++;
                    this.mOa.setText(this.mOd + "");
                }
                aH();
            } else if (id == a.f.tv_cut_count) {
                if (this.mOd > 1) {
                    this.mOd--;
                    this.mOa.setText(this.mOd + "");
                }
                aH();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mPk.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mPk.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mPl.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dE(this.mPk);
                    this.mRd.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mKc != null && !h.isEmpty(this.mKc.eventUrl)) {
                    f("", this.mKc.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mKc != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mKc != null) {
                    com.kascend.chushou.d.a.a(this.mQy, (JSONObject) null, this.mKc.roomId, this.mKc.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mQx.a(false);
                    ((VideoPlayer) this.mQy).l();
                } else {
                    ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
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
        if (this.mNT != null) {
            int i = (tv.chushou.zues.utils.a.gv(this.mQy).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNT.getLayoutParams();
            layoutParams.topMargin = i;
            this.mNT.setLayoutParams(layoutParams);
            this.mNT.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mNT.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Kz(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mOK <= 3000) {
            tv.chushou.zues.utils.g.Kz(a.i.str_too_fast);
            return false;
        } else {
            dsM();
            if (!com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a(((VideoPlayer) this.mQy).dEl().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mOK = System.currentTimeMillis();
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                a(this.mQx.dEL().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mQx.h);
            }
            g(this.b);
            if (!z && this.mNC != null) {
                this.mNC.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dsM();
            if (com.kascend.chushou.d.e.c(this.mQy, null) && LoginManager.Instance().getUserInfo() != null && this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                a(this.mQx.dEL().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mNC != null) {
                this.mNC.setText((CharSequence) null);
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
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mQx.dEL().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mQx.dEL().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mQy).mHU;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Sr(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.mQX != null && this.mQX.isShowing()) {
            this.mQX.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
        if (this.mRv == null) {
            i(3);
        }
        this.mRv.getContentView().setBackgroundResource(0);
        this.mRv.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mRv.isShowing()) {
            this.mRv.showAtLocation(view, 83, i, i2);
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mQx.dEL().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mRv.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.mRz)) {
            if (((VideoPlayer) this.mQy).q) {
                this.mRy.yE(a.e.ic_room_set_btn_white);
            } else {
                this.mRy.yE(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mQy).q && this.mRz.size() == 2 && this.mRz.contains("4") && this.mRz.contains("2")) {
            this.mRy.yE(a.e.ic_room_set_btn_system_white);
        } else if (this.mRz.size() > 1 || !((VideoPlayer) this.mQy).q) {
            this.mRy.yE(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mRz.get(0))) {
            this.mRy.yE(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mRz.get(0))) {
            this.mRy.yE(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mRz.get(0))) {
            this.mRy.yE(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
        if (this.mQX == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mQX.getContentView().setBackgroundResource(0);
            this.mQX.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mQX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mNz.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mQX.isShowing()) {
            this.mQX.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mQy, 16.0f) + i2);
            this.mNz.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mQx.dEL().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mQX.dismiss();
    }

    private void dt(View view) {
        if (this.mQR == null) {
            Nm();
        }
        if (com.kascend.chushou.d.h.dDZ().q()) {
            this.mND.dRz();
        } else {
            this.mND.dRA();
        }
        int height = this.mQi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (view != null) {
            this.mQR.showAtLocation(view, 85, 0, height);
        }
    }

    private void Nm() {
        if (this.mQR == null) {
            View inflate = LayoutInflater.from(this.mQy).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mND = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dDZ().q()) {
                this.mND.dRz();
            } else {
                this.mND.dRA();
            }
            this.mND.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dDZ().g(z);
                }
            });
            this.mQL = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mQM = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mQL.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mQL.setVisibility(0);
            } else {
                this.mQL.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dDZ().a) {
                this.mQM.b();
            } else {
                this.mQM.c();
            }
            if (this.mQx != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mQx.f;
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
                                if (this.mJZ == null || !this.mJZ.mMO.mInPKMode || h.isEmpty(this.mJZ.b) || this.mOm == null || !this.mJZ.b.equals(this.mOm.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mQy).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dEM = this.mQx.dEM();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mQy).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mQy, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, 5.0f);
                                            }
                                            int identifier = this.mQy.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mQy.getPackageName());
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
                                                if (dEM != null && dEM.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mQy.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mQy).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dEM2 = this.mQx.dEM();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mQy).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mQy, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, 5.0f);
                                        }
                                        int identifier2 = this.mQy.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mQy.getPackageName());
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
                                            if (dEM2 != null && dEM2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dFm();
                        c.this.mQR.dismiss();
                    }
                }
            });
            this.mQR = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 150.0f), -2);
            this.mQR.setFocusable(true);
            this.mQR.setOutsideTouchable(true);
            this.mQR.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mQR.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mQR = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFm() {
        if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
            if (this.mNS == null) {
                this.mNS = new f(getActivity());
            }
            this.mNS.a(this.mQx.dEL().mRoominfo, this.ax);
            if (!this.mNS.isShowing()) {
                this.mNS.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.dx) {
            return false;
        }
        if (this.mOL == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mPH = motionEvent.getX();
                    this.mPI = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mPH;
                    if (Math.abs(f) > Math.abs(y - this.mPI) && Math.abs(f) > q && f > 0.0f) {
                        dFA();
                        return true;
                    }
                    this.mPH = 0.0f;
                    this.mPI = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mPl != null && this.mPl.getVisibility() == 0 && b(motionEvent, this.mPl)) {
                this.mPl.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.mPk);
                return true;
            } else if (this.mOH && this.mPl != null && this.mPl.getVisibility() == 8 && f(this.mRd.b, motionEvent)) {
                aD();
                return true;
            } else if (this.mNT != null && this.mNT.b() && f(this.mNT, motionEvent)) {
                this.mNT.a();
                return true;
            } else if (this.mNJ != null && this.mNJ.b() && f(this.mNJ, motionEvent)) {
                this.mNJ.a();
                return true;
            } else if (b(motionEvent, this.mNB)) {
                return dsM();
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
            if (this.mRp != null && this.mRp.a(i, keyEvent)) {
                return true;
            }
            if ((this.mNT != null && this.mNT.onKeyDown(i, keyEvent)) || dFe()) {
                return true;
            }
            if (this.mOL == 3) {
                this.mOL = 1;
                dFA();
                return true;
            } else if (this.mNJ != null && this.mNJ.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mNC != null && this.mNx != null && this.mNB != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mNC);
                this.mNx.setVisibility(8);
                this.mNB.setVisibility(0);
            }
        } else if (this.mNx != null && this.mNB != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
            this.mNx.setVisibility(0);
            this.mNB.setVisibility(8);
        }
    }

    public boolean dsM() {
        boolean z;
        b(this.mNa, 12);
        boolean z2 = false;
        if (this.mLa != null && this.mLa.getVisibility() == 0) {
            this.mLa.setVisibility(8);
            this.mLb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mLc) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mQy);
            this.mLb.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mNB == null || this.mNB.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mOe) {
                bo();
            }
            this.mNB.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mNx != null) {
                    c.this.mNx.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dFe() {
        if (dsM()) {
            return true;
        }
        if (this.mQX != null && this.mQX.isShowing()) {
            this.mQX.dismiss();
            return true;
        } else if (this.mRv != null && this.mRv.isShowing()) {
            this.mRv.dismiss();
            return true;
        } else if (this.mQR == null || !this.mQR.isShowing()) {
            return aD() || dFf() || dFk() || dEW();
        } else {
            this.mQR.dismiss();
            return true;
        }
    }

    public boolean dEW() {
        if (this.mRh == null || !this.mRh.isShown()) {
            return false;
        }
        this.mRh.d();
        return true;
    }

    public boolean dFf() {
        if (this.mOJ == null || !this.mOJ.isShown()) {
            return false;
        }
        this.mOJ.a();
        return true;
    }

    public boolean dFk() {
        if (this.mNT == null || !this.mNT.b()) {
            return false;
        }
        this.mNT.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mQy != null && !((Activity) this.mQy).isFinishing() && pVar != null) {
            this.mOu = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dFE() && this.mOm != null && mVar.a(this.mOm.mCreatorUID, null)) {
            this.mOm.mIsSubscribed = mVar.c;
            aO();
        }
    }

    public boolean aD() {
        if (!this.mOH || this.mRd == null) {
            return false;
        }
        if (this.mRd != null) {
            this.mRd.e();
        }
        if (this.mPk != null) {
            this.mPk.setText("");
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
        if (!dFE() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mOP != null) {
                        this.mOP.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                        this.mQx.dEL().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mQx.dEL().mMicStatus.onMic) {
                            if (this.mNr != null) {
                                this.mNr.setVisibility(8);
                            }
                            if (this.mOJ != null && this.mOJ.isShown()) {
                                this.mOJ.a();
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
                        if (this.mQx.dEL().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mOm != null && !h.isEmpty(this.mOm.mCreatorUID)) {
                                g(arrayList2, this.mOm.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.mQx.dEL().mMicStatus.onMic) {
                            if (this.mQx.dEL().mMicStatus != null && !h.isEmpty(this.mQx.dEL().mMicStatus.micRoomId) && !this.mQx.dEL().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mQx.dEL().mMicStatus.micRoomId;
                            }
                            this.mQx.dEL().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mQx.dEL().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.mQx.dEL().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mQx.dEL().mMicStatus, str3, z4);
                            if (this.mOJ != null && this.mOJ.getVisibility() == 0) {
                                this.mOJ.a(this.mQx.dEL().mFanItems, this.mQx.dEL().mMicStatus, str3, z4, this.mQx.dEL().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mNr != null) {
                                this.mNr.setVisibility(8);
                            }
                            if (this.mOJ != null && this.mOJ.isShown()) {
                                this.mOJ.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mOi != onlineVip.mCount || (this.mNp != null && this.mNp.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mOi = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dFo();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mOG.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mOG.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mOG.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mPb <= 5000) {
                                z2 = false;
                            } else {
                                this.mPb = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mOG.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mOG.addAll(onlineVip.mOnlineVipItems);
                            }
                            aP();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mPc != null) {
                    if (this.mOm == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mOm.mCreatorAvatar;
                        str2 = this.mOm.mCreatorGender;
                    }
                    this.mPc.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mJZ != null && this.mJZ.mMO != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mJZ.mMO.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mJV != null) {
                                        this.mJV.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mJZ.mMO.mInPKMode = true;
                                    this.mJZ.mMO.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mJZ.mMO.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mJZ.mMO.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mJZ.mMO.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mJZ.mMO.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mJZ.mMO.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mJZ.mMO.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mJZ.mMO.mMode = pkNotifyInfo.mMode;
                                    this.mJZ.mMO.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mKa != null) {
                                        this.mKa.g(true, this.mJZ.mMO.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dDZ().a) {
                                        if (!com.kascend.chushou.b.dDS().e) {
                                            com.kascend.chushou.b.dDS().e = true;
                                            tv.chushou.zues.utils.g.F(this.mQy, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dDZ().a(this.mQy, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mJZ.mMO.mAction = 7;
                                    this.mJZ.mMO.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mJZ.mMO.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mJZ.mMO.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mJZ.mMO.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mJZ.mMO.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mJZ.mMO.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mJZ.mMO.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.mKa != null) {
                                        this.mKa.g(false, 0L);
                                        this.mKa.b(this.mJZ.mMO, true);
                                        this.mKa.a(this.mPe + tv.chushou.zues.utils.a.dip2px(this.mQy, 52.0f), this.aq);
                                        this.mKa.a(this.mJZ.mMO.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mJV != null) {
                                        this.mJV.a(false);
                                    }
                                    this.mJZ.mMO.mInPKMode = false;
                                    this.mJZ.mMO.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.mKa != null) {
                                        this.mKa.c();
                                    }
                                    this.mJZ.b = null;
                                    this.mJZ.mMO = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mJZ.mMO.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mJZ.mMO.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mOm != null && !h.isEmpty(this.mOm.mRoomID) && this.mOm.mRoomID.equals(this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mJZ.mMO.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mKa != null) {
                                        this.mKa.a(this.mJZ.mMO, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mJZ.mMO.copyUpdate(pkNotifyInfo);
                                    if (this.mKa != null) {
                                        this.mKa.a(this.mJZ.mMO);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mJZ.mMO.copyStop(pkNotifyInfo);
                                        if (this.mKa != null) {
                                            this.mKa.A(this.mJZ.mMO.mMaxFreeDuration, this.mJZ.mMO.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mJZ.mMO.copyResult(pkNotifyInfo);
                                    if (!this.mOE && this.mKa != null) {
                                        int i7 = 1;
                                        if (this.mJZ.mMO.destinyInfo != null && this.mJZ.mMO.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mKa.a(h.parseInt(this.mJZ.mMO.mResult), h.parseLong(this.mJZ.mMO.mvpUid), this.mJZ.mMO.mvpAvatar, this.mJZ.mMO.mvpNickname, this.mJZ.mMO.mMaxFreeDuration, this.mJZ.mMO.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mKc != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mKc.uid = cycleLiveRoomInfo.uid;
                        this.mKc.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mKc.roomId = cycleLiveRoomInfo.roomId;
                        this.mKc.avatar = cycleLiveRoomInfo.avatar;
                        this.mKc.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.mQy != null && (this.mQy instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mQy).d();
                        }
                    } else {
                        ((VideoPlayer) this.mQy).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mQx != null && this.mQx.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dDZ().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dDZ().b().equals(next2.mUserID)) {
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

    public void dFo() {
        if (this.mNp != null) {
            if (this.mJZ == null || this.mJZ.mMO == null || !this.mJZ.mMO.mInPKMode) {
                if (this.bP > 0) {
                    this.mNp.setVisibility(0);
                    this.mNp.setText(String.format(this.mQy.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.mNt.setVisibility(0);
                    return;
                }
                this.mNp.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mNr.setVisibility(0);
            if (this.mNs != null) {
                this.mNs.a(str, z, micStatus, this.mQx.dEL().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mNr.setVisibility(8);
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
        int childCount = this.mOo.getChildCount();
        int itemCount = this.mOo.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mOo);
        if (f + childCount >= itemCount) {
            this.mOv = true;
            if (this.mOw != null) {
                this.mOw.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dFs() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mOp.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mOp.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.mOp == null) {
            this.mOp = new ArrayList<>();
        }
        while (2 < this.mOp.size()) {
            this.mOp.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mOr);
        if (a2 == null) {
            w(false);
            return;
        }
        this.mOp.addAll(a2);
        int size = this.mOp.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mOp.size(); i++) {
                this.mOp.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mOs == null) {
            this.mOs = new ArrayList<>();
        }
        this.mOs.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mOu != null && this.mOu.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mOu.contains("2"))) {
                        this.mOs.add(next);
                    } else if (!this.mOu.contains(next.mType)) {
                        this.mOs.add(next);
                    }
                }
                return this.mOs;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mOp == null) {
                    this.mOp = new ArrayList<>(arrayList);
                    dFs();
                    w(z2);
                    return;
                }
                if (this.mOr == null) {
                    this.mOr = new ArrayList<>();
                }
                this.mOr.addAll(arrayList);
                int size = this.mOr.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mOr.size(); i++) {
                        this.mOr.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mOp.size();
                if (a2 != null) {
                    this.mOp.addAll(a2);
                }
                int size3 = this.mOp.size();
                if (!this.mOv && this.mOw != null) {
                    this.mOw.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mOp.size(); i3++) {
                        this.mOp.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mOp == null) {
                this.mOp = new ArrayList<>(arrayList);
                dFs();
            } else {
                if (this.mOr == null) {
                    this.mOr = new ArrayList<>();
                }
                this.mOr.clear();
                this.mOr.addAll(arrayList);
                this.mOp.clear();
                dFs();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mOp.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mOt != null) {
                this.mOt.a(this.mOp.size());
                if (i == 1) {
                    this.mOt.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mOt.notifyItemRangeRemoved(i2, i3);
                    this.mOt.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mOt.notifyDataSetChanged();
                }
            }
            if (z || this.mOv) {
                this.mOv = true;
                if (this.mOw != null) {
                    this.mOw.setVisibility(8);
                }
                if (z) {
                    this.mOl.scrollToPosition(this.mOp.size() - 1);
                } else {
                    this.mOl.smoothScrollToPosition(this.mOp.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.mOt != null) {
                this.mOt.a(this.mOp.size());
                this.mOt.notifyDataSetChanged();
            }
            if (z || this.mOv) {
                this.mOv = true;
                if (this.mOw != null) {
                    this.mOw.setVisibility(8);
                }
                if (z) {
                    this.mOl.scrollToPosition(this.mOp.size() - 1);
                } else {
                    this.mOl.smoothScrollToPosition(this.mOp.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dEw;
        RoomToast roomToast;
        this.p = false;
        if (this.mQx != null && this.mQx.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mQx.f.size()) {
                    break;
                } else if (!"2".equals(this.mQx.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dFw();
            return;
        }
        if (this.mKp != null) {
            this.mKp.setVisibility(0);
        }
        if (this.mNf != null) {
            this.mNf.setVisibility(0);
        }
        if (this.mQx != null) {
            this.mOm = this.mQx.dEO();
            this.mOn = this.mQx.dEL();
            if (com.kascend.chushou.b.dDS().c != null && this.mOt != null) {
                this.mOt.a(com.kascend.chushou.b.dDS().c);
                this.mOt.notifyDataSetChanged();
            }
            FullRoomInfo dEL = this.mQx.dEL();
            if (dEL != null) {
                if (!h.isEmpty(dEL.mRoomToastList)) {
                    Iterator<RoomToast> it = dEL.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dDZ().j())) {
                    a(roomToast);
                }
            }
            if (this.mOm != null) {
                bk();
            }
            if (this.mOm != null && !this.mOm.mIsSubscribed) {
                RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mOm == null || !c.this.mOm.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mQx != null && this.mQx.l()) {
                d(true);
            }
        }
        if (this.mOm != null && this.mOt != null) {
            if (this.mOp != null) {
                this.mOp.clear();
            } else {
                this.mOp = new ArrayList<>();
            }
            this.mOt.a(this.mOm);
            dFs();
            this.mOt.a(this.mOp.size());
            this.mOt.notifyDataSetChanged();
        }
        aM();
        N();
        if (this.mQy != null && (this.mQy instanceof VideoPlayer) && (dEw = ((VideoPlayer) this.mQy).dEw()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dEw.mMO, dEw.b);
        }
        this.mNG.h(this.mOm.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mOm.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mNK);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.mOh == null) {
            View inflate = LayoutInflater.from(this.mQy).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mLC = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mOh = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mQy, 160.0f), -2);
            this.mOh.setFocusable(false);
            this.mOh.setOutsideTouchable(false);
            this.mOh.setAnimationStyle(a.j.gift_toast_style);
            this.mOh.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dDZ().c(roomToast.mToastContent);
            if (this.mOh == null) {
                bd();
            }
            if (this.mLC != null) {
                this.mLC.setText(roomToast.mToastContent);
            }
            if (!this.mOh.isShowing()) {
                if (this.mNK != null) {
                    this.mOh.showAtLocation(this.mNK, 85, 0, this.mQi.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mOh != null) {
                                c.this.mOh.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mOh.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mOX != null) {
            this.mOX.setVisibility(z ? 0 : 8);
        }
        this.mOY = true;
        if (this.mQy instanceof VideoPlayer) {
            ((VideoPlayer) this.mQy).p();
        }
    }

    private void dFw() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mQy).s();
        dEW();
        dFf();
        if (this.mNv == null) {
            this.mNv = (PlayShowRecommendView) ((ViewStub) this.mQi.findViewById(a.f.view_recommend)).inflate();
        }
        this.mNv.setVisibility(0);
        if (this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null && !h.isEmpty(this.mQx.dEL().mRoominfo.mRoomID)) {
            bf();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mRd != null) {
            this.mRd.e();
        }
        if (this.mKp != null) {
            this.mKp.setVisibility(4);
        }
        if (this.mNf != null) {
            this.mNf.setVisibility(8);
        }
        if (this.mRl != null) {
            this.mRl.dQW();
            this.mRl.setVisibility(8);
        }
        wC(false);
        a(false, false);
        if (this.mJV != null) {
            this.mJV.a();
        }
    }

    private void bf() {
        if (this.mNv != null && this.mNv.getVisibility() == 0) {
            this.mNv.a(this.mQx.dEL().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dFi() {
        super.dFi();
        if (this.mQy instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mNT != null && this.mNT.b()) {
            this.mNT.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mOI);
        if (this.mQy != null) {
            if (this.mOI || "10004".equals(((VideoPlayer) this.mQy).t)) {
                this.mOI = true;
                if (this.mQx != null) {
                    this.mQx.f = null;
                    if (this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                        this.mQx.dEL().mRoominfo.mGameId = null;
                    }
                }
                dFw();
                return;
            }
            this.mOI = true;
            if (this.mQy != null) {
                ((VideoPlayer) this.mQy).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mOI = false;
        if (this.mKp != null) {
            this.mKp.setVisibility(0);
        }
        if (this.mNf != null) {
            this.mNf.setVisibility(0);
        }
        if (this.mNv != null) {
            this.mNv.setVisibility(8);
        }
        if (this.mQs != null) {
            this.mQs.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mOI = false;
        if (this.mKp != null) {
            this.mKp.setVisibility(0);
        }
        if (this.mNf != null) {
            this.mNf.setVisibility(0);
        }
        if (this.mNv != null) {
            this.mNv.setVisibility(8);
        }
        if (this.mQs != null) {
            this.mQs.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mNv != null) {
            this.mNv.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dFE()) {
            if (i()) {
                if (i == 404) {
                    if (this.mQx != null) {
                        this.mQx.f = null;
                        this.mQx.dEL().mRoominfo.mGameId = null;
                    }
                    dFw();
                    return;
                }
                tv.chushou.zues.utils.g.Kz(a.i.str_getvideosource_failed);
            }
            wC(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mQx != null && this.mQx.dEM() != null) {
            a(this.mQx.dEM());
        }
        this.p = false;
        if (this.mQx == null || this.mQx.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mQx.f.size()) {
                if (!"2".equals(this.mQx.f.get(i2).mType)) {
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
    public GiftAnimationLayout dFc() {
        if (this.mQi == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mQi.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mNK != null) {
            int size = iconConfig.configs.size();
            this.mNK.removeAllViews();
            if (this.mNM != null) {
                this.mNM.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mQy).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mNK, false);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bottom);
                ImageView imageView = (ImageView) inflate.findViewById(a.f.iv_bottom_point);
                imageView.setVisibility(8);
                if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                    if (configDetail.mTargetKey.equals("interaction")) {
                        imageView.setVisibility(8);
                        frescoThumbnailView.bV(configDetail.mCover, a.e.ic_show_interact_n);
                    } else if (configDetail.mTargetKey.equals("more")) {
                        frescoThumbnailView.bV(configDetail.mCover, a.e.ic_show_more_n);
                    } else if (configDetail.mTargetKey.equals("pay")) {
                        frescoThumbnailView.bV(configDetail.mCover, a.e.ic_show_pay_n);
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                            this.mNM.setVisibility(0);
                            this.mNL.bV(configDetail.mCover, a.e.ic_show_gift_n);
                            frescoThumbnailView.bV(configDetail.mCover, a.e.ic_show_gift_n);
                        } else {
                            frescoThumbnailView.bV(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                        }
                    }
                } else {
                    frescoThumbnailView.bV(configDetail.mCover, a.e.ic_default_videoshow_bottom);
                }
                inflate.setTag(configDetail);
                inflate.setClickable(true);
                inflate.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.25
                    @Override // tv.chushou.zues.a
                    public void dr(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.mNK.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void D() {
        if (this.mQy instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dEr = ((VideoPlayer) this.mQy).dEr();
            if (this.mRp == null) {
                this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mRp.setVisibility(0);
            this.mRp.a(2, dEr);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mNO != null && this.mQy != null) {
            this.mNO.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mNO != null && this.mQy != null) {
            this.mNO.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(long j) {
        if (this.mNO != null) {
            this.mNO.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0807a
    public void c(int i) {
        if (this.mNO != null) {
            this.mNO.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void a(int i) {
        if (this.mNN != null) {
            if (this.mQy != null) {
                this.mNN.a(((VideoPlayer) this.mQy).dEr(), false);
            }
            this.mNN.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mQi != null) {
            Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
            int i = gv.x > gv.y ? 1 : 2;
            if (this.mRp == null) {
                this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mRp.setPlayerViewHelper(this.mQx);
            this.mRp.setVisibility(0);
            this.mRp.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mNP != null) {
            this.mNP.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mNP != null) {
            this.mNP.a(bangInfo, str);
        }
        if (this.mKD != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mKD.setText(this.mQy.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mKD.setText(this.mQy.getString(a.i.str_contribute_tittle));
            } else {
                this.mKD.setText(Html.fromHtml(this.mQy.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mNq != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mNq.setText(this.mQy.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mNq.setText(this.mQy.getString(a.i.str_contribute_tittle));
            } else {
                this.mNq.setText(Html.fromHtml(this.mQy.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mNP != null) {
            this.mNP.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mQx != null && !h.isEmpty(this.mQx.mJG)) {
            this.mON = this.mQx.mJG.get(0);
            if (this.mPf != null) {
                this.mPf.setVisibility(0);
                this.mPf.a(this.mON.mCover, 0, 0, 0, 1);
                if (this.mPg != null) {
                    if (this.mON.mShowClose) {
                        this.mPg.setVisibility(0);
                    } else {
                        this.mPg.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mNP != null) {
            this.mNP.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mQi != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mLa != null) {
            this.mLa.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dFE() && !this.mOE) {
            if (iVar.a == 52) {
                if (this.mOt != null) {
                    this.mOt.a(com.kascend.chushou.b.dDS().c);
                    this.mOt.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mOE && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dFE()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mNC != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mNC);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dFE() && !this.mOE) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mQy, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dEs = ((VideoPlayer) this.mQy).dEs();
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(2, dEs);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dEt = ((VideoPlayer) this.mQy).dEt();
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(2, dEt);
            } else if (bVar.a == 8) {
                if (this.mOP != null && this.mOP.getVisibility() != 0) {
                    this.mOP.a(a.C0794a.slide_in_bottom_danmu_anim, a.C0794a.slide_out_bottom_danmu_anim, this.mOm == null ? "" : this.mOm.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mRp == null) {
                    this.mRp = (H5Container) ((ViewStub) this.mQi.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mRp.setVisibility(0);
                this.mRp.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dFE() && this.mQx != null && !h.isEmpty(this.mQx.a) && this.mQx.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mOP != null && this.mOP.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mQy, 80.0f);
                }
                if (this.mOO != null && this.mOO.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mOO.getHeight());
                }
                this.mPa.setTranslationY(-r0);
                return;
            }
            if (this.mOZ != null) {
                this.mOZ.cancel();
                this.mOZ = null;
            }
            int translationY = (int) this.mPa.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mQy, 80.0f) : 0;
                    if (this.mOO != null && this.mOO.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mOO.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mOO.getHeight() : 0;
                    if (this.mOP != null && this.mOP.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mQy, 80.0f));
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
        this.mOZ = ValueAnimator.ofInt(i, i2);
        this.mOZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dFE() && c.this.mNP != null) {
                    c.this.mPa.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mOZ.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mOZ = null;
            }
        });
        this.mOZ.setInterpolator(new LinearInterpolator());
        this.mOZ.setDuration(800L);
        this.mOZ.start();
    }

    private boolean dFx() {
        if (this.mOL == 1) {
            this.mOL = 2;
            x(true);
            return true;
        } else if (this.mOL == 3) {
            dFA();
            return true;
        } else {
            return false;
        }
    }

    private boolean dFy() {
        if (this.mOL == 1) {
            return dFz();
        }
        if (this.mOL == 2) {
            this.mOL = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean dFz() {
        if (this.dx || this.mQx == null || this.mQx.dEO() == null) {
            return false;
        }
        if (this.mPJ != null) {
            this.mPJ.a(true);
        }
        this.mOL = 3;
        this.dx = true;
        bk();
        this.mNc.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.dx = false;
                c.this.mNe.setVisibility(8);
            }
        });
        this.mNe.startAnimation(loadAnimation);
        this.mNc.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFA() {
        if (!this.dx) {
            if (this.mPJ != null) {
                this.mPJ.a(false);
            }
            this.mOL = 1;
            this.dx = true;
            bk();
            this.mNe.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.dx = false;
                    c.this.mNc.setVisibility(8);
                }
            });
            this.mNe.startAnimation(loadAnimation);
            this.mNc.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.mQi != null) {
            if (this.mNc == null) {
                this.mNc = this.mQi.findViewById(a.f.user_space_container);
            }
            if (this.mNe == null) {
                this.mNe = this.mQi.findViewById(a.f.video_container);
            }
            if (this.mNd == null) {
                this.mNd = com.kascend.chushou.view.user.b.b(null, this.mQx.a, false, this.mQx.h);
                this.mNd.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dFA();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dFA();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mNd).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.mNf != null) {
            this.mNf.setVisibility(z ? 8 : 0);
        }
        if (this.mOj != null) {
            this.dx = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mOj.setVisibility(8);
                        c.this.dx = false;
                    }
                });
            } else {
                this.dx = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mOj.setVisibility(0);
                        c.this.dx = false;
                    }
                });
            }
            this.mOj.startAnimation(loadAnimation);
        }
        dFe();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mNw.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Nl() {
        if ("4".equals(this.ax)) {
            if (this.mNE != null) {
                this.mNE.setVisibility(0);
            }
            if (this.mNF != null) {
                this.mNF.a();
                return;
            }
            return;
        }
        if (this.mNH != null) {
            this.mNH.setVisibility(0);
        }
        if (this.mNI != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mNI.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mNH != null) {
            this.mNH.setVisibility(8);
        }
        if (this.mNI != null) {
            this.mNI.clearAnimation();
        }
        if (this.mNE != null) {
            this.mNE.setVisibility(8);
        }
        if (this.mNF != null) {
            this.mNF.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mOj != null && this.mQi != null) {
            if (this.mOP == null) {
                this.mOP = new com.kascend.chushou.player.ui.miniview.a(this.mQy, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mOP != null && c.this.mQi != null && c.this.mOP.a()) {
                            ((ViewGroup) c.this.mQi).removeView(c.this.mOP);
                            c.this.mOP = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOP.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mQy, 52.0f);
                this.mOP.setLayoutParams(layoutParams);
                ((ViewGroup) this.mOj).addView(this.mOP, ((ViewGroup) this.mOj).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mOP.setVisibility(8);
                } else {
                    this.mOP.a(a.C0794a.slide_in_bottom_danmu_anim, a.C0794a.slide_out_bottom_danmu_anim, this.mQx.a == null ? "" : this.mQx.a);
                }
            } else if (!this.mOP.isShown()) {
                this.mOP.a(a.C0794a.slide_in_bottom_danmu_anim, a.C0794a.slide_out_bottom_danmu_anim, this.mQx.a == null ? "" : this.mQx.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mOW != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mOW.setVisibility(0);
                this.mOW.setAnim(true);
                this.mOW.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nOX, b.C0923b.nOZ, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mOx != null && this.mOx.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dFB();
                    }
                });
                this.mOx.setVisibility(0);
                this.mOx.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mOx != null && this.mOx.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mOz != null) {
                        c.this.mOz.removeAllListeners();
                        c.this.mOz.cancel();
                        c.this.mOz = null;
                    }
                    if (c.this.mOx != null) {
                        c.this.mOx.setVisibility(8);
                    }
                }
            });
            this.mOx.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mPd == null) {
                this.mPd = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dFE()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mQy, "显示双击666_num", null, new Object[0]);
                            if (c.this.mQx != null) {
                                c.this.mQx.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.mQz != null) {
                    this.mQz.e(this.mPd, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mPd != null) {
            this.mQz.P(this.mPd);
            this.mPd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mOA != null && this.mOA.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mQy, a.C0794a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dFC();
                    }
                });
                this.mOA.setVisibility(0);
                this.mOA.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mQh, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.mOA != null && this.mOA.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mQy, a.C0794a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mOC != null) {
                        c.this.mOC.removeAllListeners();
                        c.this.mOC.cancel();
                        c.this.mOC = null;
                    }
                    if (c.this.mOA != null) {
                        c.this.mOA.setVisibility(8);
                    }
                }
            });
            this.mOA.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFB() {
        if (this.mOx == null || this.mOy == null) {
            return null;
        }
        if (this.mOz != null) {
            this.mOz.removeAllListeners();
            this.mOz.cancel();
            this.mOz = null;
        }
        this.mOy.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mOy, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mOy, 0.0f);
        int measuredWidth = (this.mOx.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mQy, 13.0f) * 2)) - this.mOy.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mOy, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mOy, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mOy, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mOz != null) {
                    c.this.mOz.removeAllListeners();
                    c.this.mOz.cancel();
                    c.this.mOz = null;
                }
                RxExecutor.postDelayed(c.this.mQh, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dFB();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mOz = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFC() {
        if (this.mOA == null || this.mOB == null) {
            return null;
        }
        if (this.mOC != null) {
            this.mOC.removeAllListeners();
            this.mOC.cancel();
            this.mOC = null;
        }
        this.mOB.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mOB, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mOB, 0.0f);
        int measuredWidth = (this.mOA.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mQy, 13.0f) * 2)) - this.mOB.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mOB, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mOB, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mOB, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mOC != null) {
                    c.this.mOC.removeAllListeners();
                    c.this.mOC.cancel();
                    c.this.mOC = null;
                }
                RxExecutor.postDelayed(c.this.mQh, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dFC();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mOC = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mPJ = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mKc != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mKc.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dFE()) {
                        ParserRet dF = com.kascend.chushou.c.a.dF(jSONObject);
                        if (dF.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Kz(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Kz(a.i.subscribe_success);
                            }
                            if (c.this.mKc != null) {
                                c.this.mKc.isSubscribe = !z;
                                c.this.aN();
                                return;
                            }
                            return;
                        }
                        a(dF.mRc, dF.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dFE()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dDV().a(bVar, (String) null, this.mKc.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mKc.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dDV().b(bVar, (String) null, c.this.mKc.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mQx != null && this.mOm != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mQx.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mQx.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mOm.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dFE()) {
                        ParserRet dF = com.kascend.chushou.c.a.dF(jSONObject);
                        if (dF.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Kz(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Kz(a.i.subscribe_success);
                            }
                            c.this.mOm.mIsSubscribed = !z;
                            c.this.aO();
                            return;
                        }
                        a(dF.mRc, dF.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dFE()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dDV().a(bVar, (String) null, this.mOm.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mOm.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dDV().b(bVar, (String) null, c.this.mOm.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mMN != null) {
            int width = this.mMN.getWidth();
            int height = this.mMN.getHeight();
            if (this.mOU != width || this.mOV != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mQi != null) {
            if (this.mNJ == null) {
                this.mNJ = (InteractionView) ((ViewStub) this.mQi.findViewById(a.f.view_interaction)).inflate();
                this.mNJ.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mNJ.a();
                    }
                });
            }
            if (this.mNJ != null) {
                this.mNJ.b(configDetail);
                this.mNJ.c();
                this.mNJ.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dRJ()) {
                tv.chushou.zues.utils.g.F(this.mQy, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mQy, null) && (this.mQy instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mQx != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mQy, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mQy, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mQx != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mQy, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mQy, configDetail.mUrl, this.mQy.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mQy, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.mOH) {
                        aD();
                        return;
                    }
                    if (this.mQy.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mQy, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mQx != null && this.mQx.dEL() != null && this.mQx.dEL().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mQx.dEL().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dt(this.mNK);
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
        if (this.mQy != null && !this.v && !h.isEmpty(str) && this.mOm != null && str.equals(this.mOm.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mJZ == null) {
                this.mJZ = new com.kascend.chushou.player.e.a();
            }
            this.mJZ.b = str;
            this.mJZ.mMO.copy(pkNotifyInfo);
            if (this.mJZ.mMO.mAction == 6) {
                if (this.mJV != null) {
                    this.mJV.a(true);
                }
                this.mJZ.mMO.mInPKMode = true;
                this.u = this.mJZ.mMO.mPkId;
            } else if (this.mJZ.mMO.mAction == 7 || (this.mJZ.mMO.mMode == 1 && this.mJZ.mMO.mAction == 5)) {
                if (this.mJV != null) {
                    this.mJV.a(true);
                }
                this.mJZ.mMO.mInPKMode = true;
                if (this.mOS != 42) {
                    this.mPe = ((this.mOT.y - ((this.mOT.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mQy, 158.0f) + this.mOf)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
                    aX();
                }
                this.u = this.mJZ.mMO.mPkId;
                if (this.mKa != null) {
                    this.mKa.b(this.mJZ.mMO, false);
                    this.mKa.a(this.mJZ.mMO.mMode, (String) null);
                    if (this.mJZ.mMO.mAction == 5 && this.mJZ.mMO.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mJZ.mMO.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mJZ.mMO.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mJZ.mMO.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mKa.a(this.mJZ.mMO);
                        this.mKa.a(parseInt, this.mJZ.mMO.mPkUpdateInfo.remainDuration, j, this.mJZ.mMO.mMode, (this.mJZ.mMO.destinyInfo == null || this.mJZ.mMO.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mJZ.mMO.mPkUpdateInfo != null && !h.isEmpty(this.mJZ.mMO.mPkUpdateInfo.specialMomentList) && this.mKa != null) {
                    this.mKa.a(this.mJZ.mMO, true);
                }
                if (this.mJZ.mMO.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.mJZ.mMO.mInPKMode = false;
                if (this.mJZ.mMO.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        aV();
        dFh();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mOc != null && this.mQx != null && this.mQx.mJH != null) {
            this.mOc.setText(tv.chushou.zues.utils.b.Ky(this.mQx.mJH.count));
            this.mOc.setVisibility(0);
            if (this.mQx.mJH.count < 1) {
                bo();
            }
            if (this.mNV != null) {
                this.mNV.setText(this.mQx.mJH.primaryName);
            }
            if (this.mNW != null) {
                this.mNW.setText(this.mQx.mJH.desc);
            }
            aH();
        }
    }

    public void aH() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mOd * h.parseLong(this.mQx.mJH.point)));
        if (this.mLs != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mQy.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mQy, a.e.icon_coin_new);
            cVar.append(this.mQy.getString(a.i.str_buy_count_coin2));
            this.mLs.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.mQy, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mOd);
        }
    }

    private void bo() {
        this.mOe = false;
        this.mOb.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mQx != null && this.mQx.mJH != null) {
            if (this.mQx.mJH.count < 1) {
                this.mOc.setVisibility(8);
            } else {
                this.mOc.setVisibility(0);
                this.mOc.setSelected(false);
                this.mOc.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mNU.setVisibility(8);
        if (this.mNC != null) {
            this.mNC.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mKe != null) {
            if (z) {
                this.mKe.setVisibility(0);
            } else {
                this.mKe.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mPG != null) {
            this.mPG.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mNL != null) {
            this.mNL.performClick();
        }
    }
}
