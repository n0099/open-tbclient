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
    public String mLG;
    private TextView mLK;
    private TextView mLN;
    private ImageView mLT;
    private View mLz;
    private TextView mMC;
    private TextView mMM;
    private View mMP;
    private TextView mMc;
    private KPSwitchPanelLinearLayout mMk;
    private ImageView mMl;
    private tv.chushou.zues.widget.kpswitch.b.c mMn;
    private d.a mMo;
    private TextView mNK;
    private TextView mOA;
    private LinearLayout mOB;
    private PlayShowMicStatusView mOC;
    private RecyclerView mOD;
    private ImageView mOE;
    private PlayShowRecommendView mOF;
    private View mOG;
    private RelativeLayout mOH;
    private AnimationSet mOI;
    private ImageView mOJ;
    private ImageView mOK;
    private RelativeLayout mOL;
    private PastedEditText mOM;
    private ToggleButton mON;
    private RelativeLayout mOO;
    private PaoPaoView mOP;
    private FrescoThumbnailView mOQ;
    private LinearLayout mOR;
    private ImageView mOS;
    private InteractionView mOT;
    private LinearLayout mOU;
    private FrescoThumbnailView mOV;
    private FrameLayout mOW;
    private RedpacketNotifier mOX;
    private InteractNotifier mOY;
    private EmbeddedButtonLayout mOZ;
    private int mOk;
    private View mOl;
    private View mOm;
    private com.kascend.chushou.view.user.b mOn;
    private View mOo;
    private FrameLayout mOp;
    private LinearLayout mOq;
    private RelativeLayout mOr;
    private FrescoThumbnailView mOs;
    private TextView mOt;
    private TextView mOu;
    private TextView mOv;
    private FrescoThumbnailView mOw;
    private TextView mOx;
    private TextView mOy;
    private TextView mOz;
    private RecyclerView.LayoutManager mPA;
    private ArrayList<ChatInfo> mPB;
    private ArrayList<ChatInfo> mPC;
    private ArrayList<ChatInfo> mPD;
    private ArrayList<ChatInfo> mPE;
    private Button mPI;
    private View mPJ;
    private View mPK;
    private Animator mPL;
    private View mPM;
    private View mPN;
    private Animator mPO;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mPR;
    private PlayShowMicPerson mPV;
    private FoodView mPY;
    public ListItem mPZ;
    private GiftAnimationLayout mPa;
    private com.kascend.chushou.player.b.a mPb;
    private f mPc;
    private PlayShowH5View mPd;
    private LinearLayout mPe;
    private TextView mPf;
    private TextView mPg;
    private TextView mPh;
    private TextView mPi;
    private TextView mPj;
    private TextView mPk;
    private ImageView mPl;
    private TextView mPo;
    private PopupWindow mPt;
    private View mPv;
    private RecyclerView mPx;
    private RoomInfo mPy;
    private FrescoThumbnailView mQA;
    private TextView mQB;
    private TextView mQC;
    private ImageView mQD;
    private RelativeLayout mQE;
    private LinearLayout mQF;
    private TextView mQG;
    private TextView mQH;
    private RelativeLayout mQI;
    private RelativeLayout mQJ;
    private FrescoThumbnailView mQK;
    private TextView mQL;
    private TextView mQM;
    private ImageView mQN;
    private RelativeLayout mQO;
    private TextView mQQ;
    private float mQR;
    private float mQS;
    private a mQT;
    private FoodView mQa;
    private com.kascend.chushou.player.ui.miniview.a mQb;
    private int mQc;
    private int mQd;
    private int mQe;
    private Point mQf;
    private FrescoThumbnailView mQi;
    private FrescoThumbnailView mQj;
    private ValueAnimator mQl;
    private LinearLayout mQm;
    private long mQn;
    private VideoShowVoteView mQo;
    private Runnable mQp;
    private FrescoThumbnailView mQr;
    private ImageView mQs;
    private RelativeLayout mQt;
    private TextView mQu;
    private ImageView mQv;
    private EditText mQw;
    private View mQx;
    private RelativeLayout mQy;
    private RelativeLayout mQz;
    private boolean mMm = false;
    private int mPp = 1;
    private boolean mPq = false;
    private int mPr = 0;
    private int mPs = 0;
    private int mPu = -1;
    private boolean mPw = false;
    private FullRoomInfo mPz = null;
    private com.kascend.chushou.player.adapter.a mPF = null;
    private ArrayList<String> mPG = null;
    private boolean mPH = true;
    private boolean mPP = true;
    private boolean mPQ = false;
    public final List<OnlineVipItem> mPS = new ArrayList();
    private boolean mPT = false;
    private boolean mPU = false;
    private long mPW = 0;
    private int mPX = 1;
    private boolean dx = false;
    private int mQg = -1;
    private int mQh = -1;
    private boolean mQk = false;
    private int mQq = -1;
    private io.reactivex.disposables.b mQP = null;

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
        this.mLG = getArguments().getString("cover");
        this.mPP = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mRt = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mRt;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dFS()) {
            dFn();
            this.mNX = ((VideoPlayer) this.mRJ).dEw();
            this.mRI = ((VideoPlayer) this.mRJ).dEz();
            ds(view);
            dFu();
            if (this.mRJ instanceof VideoPlayer) {
                ((VideoPlayer) this.mRJ).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPQ = false;
        if (this.mSn != null) {
            this.mSn.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPQ = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mPL != null) {
            this.mPL.removeAllListeners();
            this.mPL.cancel();
            this.mPL = null;
        }
        if (this.mPO != null) {
            this.mPO.removeAllListeners();
            this.mPO.cancel();
            this.mPO = null;
        }
        if (this.mOY != null) {
            this.mOY.c();
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
        if (this.mQP != null) {
            this.mQP.dispose();
            this.mQP = null;
        }
        this.mPp = 1;
        this.mPq = false;
        if (this.mRK != null) {
            this.mRK.cg(null);
        }
        if (this.mPt != null) {
            this.mPt.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mRJ, this.mMn);
        if (this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
            ((VideoPlayer) this.mRJ).dED();
        }
        this.mMo = null;
        this.mMn = null;
        dFl();
        if (this.mPb != null) {
            this.mPb.a();
        }
        if (this.mOP != null) {
            this.mOP.b();
            this.mOP.c();
            this.mOP = null;
        }
        super.d();
    }

    private void dFl() {
        tv.chushou.zues.a.a.ch(this);
        if (this.mPD != null) {
            this.mPD.clear();
        }
        if (this.mPB != null) {
            this.mPB.clear();
        }
        if (this.mPE != null) {
            this.mPE.clear();
        }
        if (this.mPC != null) {
            this.mPC.clear();
        }
        if (this.mPG != null) {
            this.mPG.clear();
        }
        if (this.mPF != null) {
            this.mPF.a(0);
            this.mPF.a();
        }
    }

    private void ds(View view) {
        this.mOl = view.findViewById(a.f.fl_root);
        this.mQf = tv.chushou.zues.utils.a.gw(this.mRJ);
        this.mPr = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mRJ);
        this.mPs = tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        this.mQe = 86;
        this.mRI = ((VideoPlayer) this.mRJ).dEz();
        if (this.mRI != null) {
            this.mPy = this.mRI.dFc();
            this.mPz = this.mRI.dEZ();
        }
        this.mPB = new ArrayList<>();
        this.mPD = new ArrayList<>();
        this.mPC = new ArrayList<>();
        this.mOp = (FrameLayout) this.mRt.findViewById(a.f.fl_effect);
        b();
        this.mRD = (PlayerErrorView) this.mRt.findViewById(a.f.view_net_error_msg);
        this.mRD.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mOO = (RelativeLayout) this.mRt.findViewById(a.f.rl_audio_ani);
        this.mOP = (PaoPaoView) this.mRt.findViewById(a.f.audio_ani);
        this.mOQ = (FrescoThumbnailView) this.mRt.findViewById(a.f.audio_ani_avatar);
        this.mOR = (LinearLayout) this.mRt.findViewById(a.f.ll_audio);
        this.mNK = (TextView) this.mRt.findViewById(a.f.tv_open_video);
        this.mOS = (ImageView) this.mRt.findViewById(a.f.iv_audio_ani);
        this.mQj = (FrescoThumbnailView) this.mRt.findViewById(a.f.live_cover);
        if (!this.mQk || this.mNX == null || this.mNX.getPlayState() != 4) {
            this.mQj.setVisibility(0);
            this.mQj.setBlur(true);
            this.mQj.i(this.mLG, 0, 0, 0);
        }
        this.mNK.setOnClickListener(this);
        this.mLk = new b();
        this.mLk.a(view, null, this.mRJ, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dRD()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mRI != null) {
                    append.append(c.this.mRI.dFc().mRoomID);
                }
                if (c.this.mLj != null && c.this.mLj.mNY != null) {
                    append.append("&mode=").append(c.this.mLj.mNY.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mRJ, append.toString());
            }
        });
        this.mLo = (VoiceInteractionView) this.mRt.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mRI != null) {
            this.mPy = this.mRI.dFc();
            this.mPz = this.mRI.dEZ();
        }
        dFo();
        dFm();
        dFp();
        this.mQm = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mPY = (FoodView) view.findViewById(a.f.rav_ad);
        this.mQr = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mQs = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mQr.setOnClickListener(this);
        this.mQs.setOnClickListener(this);
        this.mQt = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mQi = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mQi.setOnClickListener(this);
        this.mOY = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mOX = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mPI = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mPI.setOnClickListener(this);
        this.mPx = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mPx.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPx.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mQf.x, this.mQf.y) * 0.83d);
        this.mPx.setLayoutParams(layoutParams);
        this.mPA = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mRJ);
        this.mPx.setLayoutManager(this.mPA);
        this.mPx.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mPx.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mPx.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.bc();
                } else if (i == 1) {
                    c.this.mPH = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mPF = new com.kascend.chushou.player.adapter.a(this.mRJ, this.mPB);
        if (this.mPy != null) {
            this.mPF.a(this.mPy);
        }
        if (com.kascend.chushou.b.dEg().c != null) {
            this.mPF.a(com.kascend.chushou.b.dEg().c);
        }
        this.mPx.setAdapter(this.mPF);
        this.mPF.a(this.mPB.size());
        this.mPF.notifyDataSetChanged();
        if (this.mRI != null && (c = this.mRI.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mPb != null) {
            this.mPb.a();
            this.mPb = null;
        }
        this.mPa = (GiftAnimationLayout) this.mRt.findViewById(a.f.ll_gift_animation);
        this.mPa.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mOk = ((int) (tv.chushou.zues.utils.a.gv(this.mRJ).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mRJ, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mPa.getLayoutParams();
        layoutParams2.bottomMargin = this.mOk;
        this.mPa.setLayoutParams(layoutParams2);
        if (this.mRI != null) {
            this.mPb = new com.kascend.chushou.player.b.a(this.mRJ.getApplicationContext(), this.mPa);
            this.mPb.a(this.mRI);
            a(this.mRI.mKP, this.mRI.mKS);
        }
        this.mRt.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mOZ = (EmbeddedButtonLayout) this.mRt.findViewById(a.f.embedded_button_layout);
        this.mOZ.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mQo = (VideoShowVoteView) this.mRt.findViewById(a.f.view_video_show_vote);
        this.mQo.setOnClickListener(this);
        this.mQo.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.aZ();
            }
        });
        if (this.mRI != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
            this.mOZ.a(videoPlayer.dEJ().dFZ());
            this.mOZ.b(this.mRI.dFb());
            this.mOX.a(videoPlayer.dEF(), false);
            this.mOY.a(videoPlayer.dEG(), videoPlayer.dEH(), videoPlayer.dEI());
            this.mLj = new com.kascend.chushou.player.e.a();
        }
        this.mSy = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mPT = false;
                c.this.b(c.this.mOk, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mPT = true;
                if (c.this.mSn != null) {
                    c.this.mSn.measure(0, 0);
                    int measuredHeight = c.this.mSn.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mRJ, 14.0f);
                    if (measuredHeight > c.this.mOk) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mSs = (PaoGuideView) this.mRt.findViewById(a.f.rlPaoGuideView);
        this.mPV = (PlayShowMicPerson) this.mRt.findViewById(a.f.rl_mic_person_view);
        this.mPd = (PlayShowH5View) this.mRt.findViewById(a.f.rl_playshowh5);
        this.mQa = (FoodView) this.mRt.findViewById(a.f.bottom_ad);
        if (this.mRI != null) {
            H();
            if (this.mRI.mKJ != null && !h.isEmpty(this.mRI.mKJ.mUrl)) {
                b(this.mRI.mKJ);
            }
        }
        this.mPJ = this.mRt.findViewById(a.f.view_reminder_subscribe);
        this.mPK = this.mPJ.findViewById(a.f.spash_subscribe);
        ((TextView) this.mPJ.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().J(this.mRJ, a.e.videoplayer_reminder_subscribe).append(" ").append(this.mRJ.getString(a.i.videoplayer_reminder_subscribe)));
        this.mPJ.setOnClickListener(this);
        this.mPM = this.mRt.findViewById(a.f.view_reminder_danmaku);
        this.mPN = this.mPM.findViewById(a.f.spash_danmaku);
        ((TextView) this.mPM.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().J(this.mRJ, a.e.videoplayer_reminder_danmaku).append(" ").append(this.mRJ.getString(a.i.videoplayer_reminder_danmaku)));
        this.mPM.setOnClickListener(this);
    }

    private void dFm() {
        this.mQy = (RelativeLayout) this.mRt.findViewById(a.f.rl_cyclelive);
        this.mQz = (RelativeLayout) this.mRt.findViewById(a.f.rlrl_cyclelive);
        this.mQA = (FrescoThumbnailView) this.mRt.findViewById(a.f.iv_liveicon);
        this.mQB = (TextView) this.mRt.findViewById(a.f.tv_livename);
        this.mQC = (TextView) this.mRt.findViewById(a.f.tv_livedesc);
        this.mQD = (ImageView) this.mRt.findViewById(a.f.iv_cyclelive_name_menu);
        this.mQE = (RelativeLayout) this.mRt.findViewById(a.f.rl_normal);
        this.mQF = (LinearLayout) this.mRt.findViewById(a.f.ll_cyclelive_nickname);
        this.mQG = (TextView) this.mRt.findViewById(a.f.tv_cyclelive_nickname);
        this.mQH = (TextView) this.mRt.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mQI = (RelativeLayout) this.mRt.findViewById(a.f.rl_clear_cyclelive);
        this.mQJ = (RelativeLayout) this.mRt.findViewById(a.f.rlrl_clear_cyclelive);
        this.mQK = (FrescoThumbnailView) this.mRt.findViewById(a.f.iv_clear_liveicon);
        this.mQL = (TextView) this.mRt.findViewById(a.f.tv_clear_livename);
        this.mQM = (TextView) this.mRt.findViewById(a.f.tv_clear_livedesc);
        this.mQN = (ImageView) this.mRt.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mQO = (RelativeLayout) this.mRt.findViewById(a.f.rl_clear_normal);
        this.mQN.setOnClickListener(this);
        this.mQD.setOnClickListener(this);
        this.mQH.setOnClickListener(this);
        this.mQG.setOnClickListener(this);
        this.mQA.setOnClickListener(this);
        this.mQK.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mRI.mKH != null && this.mQa != null) {
            this.mQa.a(true, this.mRI.a == null ? "" : this.mRI.a);
            this.mQa.a(this.mRI.mKH, a.C0795a.slide_in_bottom_danmu_anim, a.C0795a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mRI != null && this.mRI.mKO != null && this.mOZ != null) {
            this.mPY.a(this.mRI.mKO, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mRI != null) {
                        c.this.mRI.mKO = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dFz() {
        return this.mPb;
    }

    private void dFn() {
        this.mRK = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mRt != null && (textView = (TextView) c.this.mRt.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mRJ.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mRK.A(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mRK);
                        break;
                    case 12:
                        c.this.b(c.this.mRK);
                        break;
                    case 17:
                        c.this.dFU();
                        break;
                    case 18:
                        c.this.dsT();
                        break;
                    case 19:
                        c.this.mRH.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mPw) {
            this.mPw = true;
            if (this.mPv == null) {
                this.mPv = this.mRt.findViewById(a.f.vs_async_show_content);
                this.mPv = ((ViewStub) this.mPv).inflate();
            }
            this.mLz = this.mRt.findViewById(a.f.ui_content);
            if (this.mMP == null) {
                this.mMP = this.mRt.findViewById(a.f.vs_async_notification_view);
                this.mMP = ((ViewStub) this.mMP).inflate();
            }
            c(this.mRt);
            k();
            dsU();
            if (this.c == null) {
                this.mLd = new d.a();
                this.c = new GestureDetector(this.mRJ, this.mLd);
            }
            ((VideoPlayer) this.mRJ).q();
        }
    }

    private void dFo() {
        this.mOq = (LinearLayout) this.mRt.findViewById(a.f.ll_anchor);
        this.mOr = (RelativeLayout) this.mRt.findViewById(a.f.ll_clear_anchor);
        this.mOq.setVisibility(4);
        this.mOr.setVisibility(4);
        this.mOs = (FrescoThumbnailView) this.mRt.findViewById(a.f.iv_clear_avatar);
        this.mOt = (TextView) this.mRt.findViewById(a.f.tv_clear_nickname);
        this.mOu = (TextView) this.mRt.findViewById(a.f.tv_clear_online_count);
        this.mOv = (TextView) this.mRt.findViewById(a.f.tv_clear_btn_subscribe);
        this.mOv.setOnClickListener(this);
        this.mOw = (FrescoThumbnailView) this.mRt.findViewById(a.f.iv_avatar);
        this.mOx = (TextView) this.mRt.findViewById(a.f.tv_nickname_test);
        this.mOy = (TextView) this.mRt.findViewById(a.f.tv_online_count);
        this.mLK = (TextView) this.mRt.findViewById(a.f.tv_btn_subscribe);
        this.mLK.setOnClickListener(this);
        this.mOz = (TextView) this.mRt.findViewById(a.f.tv_loyal_counts);
        this.mLN = (TextView) this.mRt.findViewById(a.f.tv_btn_contribution);
        this.mOA = (TextView) this.mRt.findViewById(a.f.tv_btn_contribution_forpk);
        this.mLN.setVisibility(4);
        this.mOA.setVisibility(8);
        this.mOB = (LinearLayout) this.mRt.findViewById(a.f.ll_mic);
        this.mOC = (PlayShowMicStatusView) this.mRt.findViewById(a.f.show_mic_status);
        this.mOD = (RecyclerView) this.mRt.findViewById(a.f.rv_loyal);
        this.mOE = (ImageView) this.mRt.findViewById(a.f.iv_clear_close);
        this.mLT = (ImageView) this.mRt.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mOD.setLayoutManager(linearLayoutManager);
        this.mPR = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mPS, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void B(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mPS.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mRJ, (JSONObject) null, c.this.mRI.dFc().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0921a view$OnLongClickListenerC0921a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0921a.KD(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0921a.KD(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0921a.KD(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dRP(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mRJ, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mRJ, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mRJ, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mRJ, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mRJ, a.c.color_979797), dip2px);
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
        this.mOD.setAdapter(this.mPR);
        this.mOB.setOnClickListener(this);
        this.mOs.setOnClickListener(this);
        this.mOE.setOnClickListener(this);
        this.mOw.setOnClickListener(this);
        this.mOs.setOnClickListener(this);
        this.mLT.setOnClickListener(this);
        this.mOz.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String str = tv.chushou.common.a.dRD() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mRI != null) {
                    str = str + c.this.mRI.dFc().mRoomID;
                }
                c.this.f(c.this.mRJ.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mLN.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String str = tv.chushou.common.a.dRD() + "m/room-billboard/";
                if (c.this.mRI != null) {
                    str = str + c.this.mRI.dFc().mRoomID;
                }
                c.this.f(c.this.mRJ.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mOA.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dr(View view) {
                String str = tv.chushou.common.a.dRD() + "m/room-billboard/";
                if (c.this.mRI != null) {
                    str = str + c.this.mRI.dFc().mRoomID;
                }
                c.this.f(c.this.mRJ.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.mPz == null || this.mPz.cycleLiveRoomInfo == null || h.isEmpty(this.mPz.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mLm = this.mPz.cycleLiveRoomInfo;
        }
        if (z2 && this.mLm != null) {
            this.mQy.setVisibility(0);
            this.mQI.setVisibility(0);
            this.mQE.setVisibility(8);
            this.mQO.setVisibility(8);
            this.mQF.setVisibility(0);
            this.mQK.h(this.mLm.eventIcon, com.kascend.chushou.view.a.a(this.mPy.mCreatorGender), b.a.small, b.a.small);
            this.mQA.h(this.mLm.eventIcon, com.kascend.chushou.view.a.a(this.mPy.mCreatorGender), b.a.small, b.a.small);
            this.mQL.setText(this.mLm.eventName);
            this.mQM.setText(this.mLm.eventDesc);
            this.mQB.setText(this.mLm.eventName);
            this.mQC.setText(this.mLm.eventDesc);
            this.mQG.setText(this.mLm.nickname);
            aN();
            if (z) {
                c(this.mLm.remainTime);
                return;
            }
            return;
        }
        this.mQy.setVisibility(8);
        this.mQI.setVisibility(8);
        this.mQE.setVisibility(0);
        this.mQO.setVisibility(0);
        this.mQF.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mQP != null) {
            this.mQP.dispose();
            this.mQP = null;
        }
        this.mQP = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mRJ != null && (c.this.mRJ instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mRJ).u();
                }
            }
        });
    }

    private void aM() {
        if (this.mPy != null && this.mPw) {
            this.mOq.setVisibility(0);
            this.mOr.setVisibility(0);
            this.mLN.setVisibility(0);
            this.mOs.h(this.mPy.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mPy.mCreatorGender), b.a.small, b.a.small);
            this.mOt.setText(this.mPy.mCreatorNickname);
            this.mOw.h(this.mPy.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mPy.mCreatorGender), b.a.small, b.a.small);
            this.mOx.setText(this.mPy.mCreatorNickname);
            dFJ();
            aO();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dFJ() {
        if (this.mPy != null) {
            this.mOu.setText(tv.chushou.zues.utils.b.formatNumber(this.mPy.mOnlineCount));
            this.mOy.setText(tv.chushou.zues.utils.b.formatNumber(this.mPy.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN() {
        if (this.mLm != null) {
            if (this.mLm.isSubscribe) {
                this.mQH.setText(a.i.like_already);
                this.mQH.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mQH.setText(getString(a.i.like));
            this.mQH.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        if (this.mPy != null) {
            if (this.mPy.mIsSubscribed) {
                this.mOv.setText(getString(a.i.like_already));
                this.mOv.setBackgroundResource(a.e.bg_show_subcribe);
                this.mLK.setText(getString(a.i.like_already));
                this.mLK.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mOv.setText(getString(a.i.like));
            this.mOv.setBackgroundResource(a.e.bg_show_subcribe);
            this.mLK.setText(getString(a.i.like));
            this.mLK.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void aP() {
        if (this.mPR != null) {
            this.mPR.notifyDataSetChanged();
        }
    }

    private void dFp() {
        this.mOG = this.mRt.findViewById(a.f.tv_interact);
        this.mOG.setOnClickListener(this);
        this.mOL = (RelativeLayout) this.mRt.findViewById(a.f.rl_edit_bar);
        this.mOJ = (ImageView) this.mRt.findViewById(a.f.btn_hotword);
        this.mOJ.setOnClickListener(this);
        this.mOK = (ImageView) this.mRt.findViewById(a.f.iv_task_badge);
        this.mOI = (AnimationSet) AnimationUtils.loadAnimation(this.mRJ, a.C0795a.anim_hotword);
        this.mOI.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dEn().c) {
                    c.this.mOJ.clearAnimation();
                    c.this.mOJ.startAnimation(c.this.mOI);
                }
            }
        });
        if (com.kascend.chushou.d.h.dEn().c) {
            this.mOJ.startAnimation(this.mOI);
            this.mOK.setVisibility(0);
        }
        this.mQQ = (TextView) this.mRt.findViewById(a.f.tv_bottom_input);
        this.mQQ.setOnClickListener(this);
        this.mSK = (FrescoThumbnailView) this.mRt.findViewById(a.f.ll_btn_set);
        this.mSK.setOnClickListener(this);
        this.mSK.yG(a.e.ic_room_set_btn_white);
        this.mOU = (LinearLayout) this.mRt.findViewById(a.f.ll_bottom_all_button);
        this.mOV = (FrescoThumbnailView) this.mRt.findViewById(a.f.fl_clear_bottom_gift);
        this.mOV.setAnim(true);
        this.mOV.setOnClickListener(this);
        this.mOV.yG(a.e.ic_show_gift_n);
        this.mOW = (FrameLayout) this.mRt.findViewById(a.f.flfl_clear_bottom_gift);
        this.mOW.setVisibility(8);
        this.mOH = (RelativeLayout) this.mRt.findViewById(a.f.rl_bottom_input);
        this.mOH.setVisibility(0);
        this.mOM = (PastedEditText) this.mRt.findViewById(a.f.et_bottom_input);
        this.mOM.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mMc.setEnabled(editable.length() > 0);
            }
        });
        this.mOM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mMc);
                    return true;
                }
                return true;
            }
        });
        this.mOM.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.n(c.this.mOM);
                }
                return false;
            }
        });
        this.mMl = (ImageView) this.mRt.findViewById(a.f.iv_btn_emoji);
        this.mMl.setVisibility(8);
        this.mMc = (TextView) this.mRt.findViewById(a.f.tv_btn_send);
        this.mMc.setOnClickListener(this);
        this.mPe = (LinearLayout) this.mRt.findViewById(a.f.head_trumpet);
        this.mPe.setVisibility(8);
        this.mPe.setOnClickListener(this);
        this.mPf = (TextView) this.mRt.findViewById(a.f.tv_primary_name);
        this.mPg = (TextView) this.mRt.findViewById(a.f.tv_primary_desc);
        this.mPi = (TextView) this.mRt.findViewById(a.f.tv_cut_count);
        this.mPi.setOnClickListener(this);
        this.mPk = (TextView) this.mRt.findViewById(a.f.tv_head_count);
        this.mPk.setText(this.mPp + "");
        this.mPj = (TextView) this.mRt.findViewById(a.f.tv_plus_count);
        this.mPj.setOnClickListener(this);
        this.mMC = (TextView) this.mRt.findViewById(a.f.tv_buy_count_coin);
        this.mPh = (TextView) this.mRt.findViewById(a.f.tv_buy_head);
        this.mPh.setOnClickListener(this);
        this.mPl = (ImageView) this.mRt.findViewById(a.f.iv_trumpet_select);
        this.mPl.setOnClickListener(this);
        this.mPo = (TextView) this.mRt.findViewById(a.f.tv_trumpet_have_count);
        this.mPq = false;
        this.mPl.setBackgroundResource(a.e.ic_trumpet_n);
        this.mPo.setVisibility(8);
        this.mMk = (KPSwitchPanelLinearLayout) this.mRt.findViewById(a.f.chat_extended_container);
        aS();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mMk, this.mMl, this.mOM, new a.InterfaceC0925a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0925a
            public void wB(boolean z) {
                if (c.this.mMl != null) {
                    if (z) {
                        c.this.mMk.setDirectVisibility(0);
                        c.this.mMl.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mMl.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mMo = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wC(boolean z) {
                c.this.mMm = z;
                if (z) {
                    c.this.mMl.setImageResource(a.e.cs_emoji_normal);
                    c.this.dFr();
                    if (c.this.mQx != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mQx.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gI(c.this.mRJ);
                        c.this.mQx.setLayoutParams(layoutParams);
                    }
                    if (c.this.mOL != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mOL.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.gI(c.this.mRJ);
                        c.this.mOL.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mQx != null && c.this.mQx.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mQx.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mQx.setLayoutParams(layoutParams3);
                    c.this.mQx.setVisibility(8);
                }
                if (c.this.mPT) {
                    c.this.mSn.setVisibility(0);
                }
                if (c.this.mRJ != null && (c.this.mRJ instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mRJ).wA(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mOL != null && c.this.mMk.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mOL.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mOL.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mMn = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mMk, this.mMo, ((VideoPlayer) this.mRJ).dEE());
        ((VideoPlayer) this.mRJ).h(((VideoPlayer) this.mRJ).dEE());
        this.mQx = this.mRt.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mQu = (TextView) this.mRt.findViewById(a.f.btn_room_search);
        this.mQv = (ImageView) this.mRt.findViewById(a.f.iv_room_emoji_delete);
        this.mQw = (EditText) this.mRt.findViewById(a.f.et_room_emoji_search);
        this.mQw.setImeOptions(3);
        this.mQw.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mQu);
                    return true;
                }
                return false;
            }
        });
        this.mQw.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mQu.setEnabled(editable.length() > 0);
                c.this.mQv.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mSn.setEmojiSearchText(editable.toString());
            }
        });
        this.mQu.setOnClickListener(this);
        this.mQv.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dD(this.mQw);
            this.mQx.setVisibility(0);
            this.mQw.requestFocus();
        } else {
            this.mQx.setVisibility(8);
        }
        if (z2) {
            this.mQw.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFr() {
        int gI = tv.chushou.zues.widget.kpswitch.b.d.gI(this.mRJ) + tv.chushou.zues.utils.a.dip2px(this.mRJ, 14.0f);
        if (gI > this.mOk) {
            b(gI, 12);
        }
    }

    private void aS() {
    }

    private void dFu() {
        if (this.mPs > 0) {
            View findViewById = this.mRt.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mPs);
        }
        if (this.mPr > 0) {
            View findViewById2 = this.mRt.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mPr, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mPP) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        aY();
        a();
        this.mLf = ((VideoPlayer) this.mRJ).dEA();
        this.mLf.a(this);
        if (this.mRI.dEZ() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mLf != null) {
            this.mLf.d();
        }
    }

    private void dFv() {
        if ((this.mLj == null || this.mLj.mNY == null || !this.mLj.mNY.mInPKMode) ? false : true) {
            if (this.mOl != null) {
                this.mOl.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLl.getLayoutParams();
            layoutParams.leftMargin = (this.mQf.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mRJ, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mLl.setLayoutParams(layoutParams);
            this.y.setText(this.mLj.mNY.mPkUserNickname);
            this.mLl.setVisibility(0);
            this.mOB.setVisibility(8);
            return;
        }
        if (this.mOl != null) {
            this.mOl.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mLl.setVisibility(8);
    }

    private void aV() {
        boolean z = false;
        if (this.mLj != null && this.mLj.mNY != null && this.mLj.mNY.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mQq > 0 && this.mPx != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPx.getLayoutParams();
                if (layoutParams.height != this.mQq) {
                    layoutParams.height = this.mQq;
                    this.mPx.setLayoutParams(layoutParams);
                }
            }
            this.mOk = ((int) (tv.chushou.zues.utils.a.gv(this.mRJ).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mRJ, 84.0f);
            b(this.mOk, 12);
        } else {
            if (this.mPx != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mPx.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mRJ, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mRJ, 250.0f);
                    this.mPx.setLayoutParams(layoutParams2);
                }
            }
            this.mOk = ((int) (tv.chushou.zues.utils.a.gv(this.mRJ).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mRJ, 84.0f);
            b(this.mOk, 12);
        }
        if (this.mLk != null) {
            this.mLk.a(this.mQq + tv.chushou.zues.utils.a.dip2px(this.mRJ, 52.0f), this.aq);
        }
        if (this.mLo != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLo.getLayoutParams();
            layoutParams3.bottomMargin = this.mQq + tv.chushou.zues.utils.a.dip2px(this.mRJ, 52.0f);
            this.mLo.setLayoutParams(layoutParams3);
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

    private void dFx() {
        aV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dFT().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mQf = tv.chushou.zues.utils.a.gw(this.mRJ);
        this.mQe = 86;
        this.mQc = (Math.max(this.mQf.x, this.mQf.y) - tv.chushou.zues.utils.a.dip2px(this.mRJ, (this.mQe + 52) + 250)) - this.mPr;
        this.mQd = Math.max(this.mQf.x, this.mQf.y) - ((tv.chushou.zues.utils.a.dip2px(this.mRJ, this.mQe) + this.mPr) * 2);
        if (this.mQg <= 0 || this.mQh <= 0) {
            this.mQg = Math.min(this.mQf.x, this.mQf.y);
            this.mQh = Math.max(this.mQf.x, this.mQf.y);
        }
        this.ar = Math.min(this.mQf.x, this.mQf.y);
        this.aq = (this.ar * this.mQh) / this.mQg;
        boolean z = false;
        if (this.mLj == null || this.mLj.mNY == null) {
            i = 1;
        } else {
            i = this.mLj.mNY.mMode;
            if (this.mLj.mNY.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mQe = 42;
            if (i == 2) {
                if (this.mQh < this.mQg) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.aq;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.aq;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mQg * layoutParams.height) / this.mQh;
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
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, this.mQe) + this.mPr;
            layoutParams.gravity = 48;
            this.mQq = ((this.mQf.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mRJ, (this.mQe + 52) + 64) + this.mPr)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            aG();
        } else if (this.E) {
            this.mQe = 42;
            if (this.mQh < this.mQg) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mQg * layoutParams.height) / this.mQh;
                layoutParams2.height = layoutParams.height;
                this.aq = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, this.mQe) + this.mPr;
            layoutParams.gravity = 48;
            this.mQq = ((this.mQf.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mRJ, (this.mQe + 52) + 98) + this.mPr)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
            dFx();
        } else {
            this.mQq = -1;
            this.mQe = 86;
            if (this.aq <= this.mQc) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mQc;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, this.mQe) + this.mPr;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else if (this.aq < this.mQd) {
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, this.mQe) + this.mPr;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.aq;
            } else {
                this.aq = Math.max(this.mQf.x, this.mQf.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.aq;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.aq * this.mQg) / this.mQh >= this.ar) {
                        i3 = this.aq;
                        i2 = (this.aq * this.mQg) / this.mQh;
                    } else if ((this.ar * this.mQh) / this.mQg >= this.aq) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mQh) / this.mQg;
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
                    if ((this.ar * this.mQh) / this.mQg > this.aq) {
                        i3 = this.aq;
                        i2 = (this.aq * this.mQg) / this.mQh;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mQh) / this.mQg;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mQh) / this.mQg;
                        if (i3 > this.aq) {
                            i3 = this.aq;
                            i2 = (this.aq * this.mQg) / this.mQh;
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
        if (this.mRI != null && this.mRI.d) {
            layoutParams.width = Math.min(this.mQf.x, this.mQf.y);
            layoutParams.height = Math.max(this.mQf.x, this.mQf.y);
        }
        dFT().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void aY() {
        this.N = new SurfaceRenderView(this.mRJ);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dFT().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.dx) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dFM();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dFL();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mQT != null) {
            this.mQT.a();
        }
        if (this.mRI != null && !h.isEmpty(this.mRI.w)) {
            b(this.mRI.w);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mNX != null) {
            int width = this.mNX.getWidth();
            int height = this.mNX.getHeight();
            if (this.mQg != width || this.mQh != height || this.mQg <= 0 || this.mQh <= 0) {
                this.mQg = width;
                this.mQh = height;
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
            if (this.mPT) {
                aD();
            } else {
                if (this.mRJ.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mPq) {
                f(this.mOM.getText().toString());
            } else {
                a(this.mOM.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dEn().c) {
                com.kascend.chushou.d.h.dEn().b(false);
                this.mOI.cancel();
                this.mOI.reset();
                this.mOJ.clearAnimation();
                this.mOK.setVisibility(8);
            }
            n(view, 0, this.mRt.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mRJ, 165.0f) / 2);
            m(view, x >= 0 ? x : 0, this.mRt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mRI.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mRI.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mPx != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mPy != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mPX = 1;
            x(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mRJ, (JSONObject) null, this.mRI.dFc().mRoomID, this.mRI.dFc().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mRJ.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mRJ, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mPZ != null) {
                    com.kascend.chushou.d.e.a(this.mRJ, this.mPZ, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mQt != null) {
                    this.mQt.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mRJ, null) && this.mRI != null && this.mRI.mKR != null) {
                    if (this.mPq) {
                        bo();
                    } else {
                        if (this.mRI != null && this.mRI.mKR != null && this.mRI.mKR.count > 0) {
                            this.mPe.setVisibility(8);
                        } else {
                            this.mPe.setVisibility(0);
                        }
                        this.mPq = true;
                        this.mPl.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mPo.setVisibility(0);
                        this.mPo.setSelected(true);
                        this.mPo.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mOM != null) {
                            this.mOM.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mPp <= 9) {
                    this.mPp++;
                    this.mPk.setText(this.mPp + "");
                }
                aH();
            } else if (id == a.f.tv_cut_count) {
                if (this.mPp > 1) {
                    this.mPp--;
                    this.mPk.setText(this.mPp + "");
                }
                aH();
            } else if (id == a.f.tv_buy_head) {
                bn();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mQw.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mQw.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mQx.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dE(this.mQw);
                    this.mSn.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mLm != null && !h.isEmpty(this.mLm.eventUrl)) {
                    f("", this.mLm.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mLm != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mLm != null) {
                    com.kascend.chushou.d.a.a(this.mRJ, (JSONObject) null, this.mLm.roomId, this.mLm.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mRI.a(false);
                    ((VideoPlayer) this.mRJ).l();
                } else {
                    ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
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
        if (this.mPd != null) {
            int i = (tv.chushou.zues.utils.a.gv(this.mRJ).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPd.getLayoutParams();
            layoutParams.topMargin = i;
            this.mPd.setLayoutParams(layoutParams);
            this.mPd.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mPd.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.KB(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mPW <= 3000) {
            tv.chushou.zues.utils.g.KB(a.i.str_too_fast);
            return false;
        } else {
            dta();
            if (!com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a(((VideoPlayer) this.mRJ).dEz().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mPW = System.currentTimeMillis();
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                a(this.mRI.dEZ().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mRI.h);
            }
            g(this.b);
            if (!z && this.mOM != null) {
                this.mOM.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            dta();
            if (com.kascend.chushou.d.e.c(this.mRJ, null) && LoginManager.Instance().getUserInfo() != null && this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                a(this.mRI.dEZ().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mOM != null) {
                this.mOM.setText((CharSequence) null);
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
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mRI.dEZ().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mRI.dEZ().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mRJ).mJi;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Ss(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.mSi != null && this.mSi.isShowing()) {
            this.mSi.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
        if (this.mSH == null) {
            i(3);
        }
        this.mSH.getContentView().setBackgroundResource(0);
        this.mSH.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mSH.isShowing()) {
            this.mSH.showAtLocation(view, 83, i, i2);
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mSH.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void au() {
        if (h.isEmpty(this.mSL)) {
            if (((VideoPlayer) this.mRJ).q) {
                this.mSK.yG(a.e.ic_room_set_btn_white);
            } else {
                this.mSK.yG(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mRJ).q && this.mSL.size() == 2 && this.mSL.contains("4") && this.mSL.contains("2")) {
            this.mSK.yG(a.e.ic_room_set_btn_system_white);
        } else if (this.mSL.size() > 1 || !((VideoPlayer) this.mRJ).q) {
            this.mSK.yG(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mSL.get(0))) {
            this.mSK.yG(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mSL.get(0))) {
            this.mSK.yG(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mSL.get(0))) {
            this.mSK.yG(a.e.ic_room_set_btn_system_white);
        }
    }

    private void n(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
        if (this.mSi == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mSi.getContentView().setBackgroundResource(0);
            this.mSi.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mSi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mOJ.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mSi.isShowing()) {
            this.mSi.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mRJ, 16.0f) + i2);
            this.mOJ.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mSi.dismiss();
    }

    private void dt(View view) {
        if (this.mSc == null) {
            Nm();
        }
        if (com.kascend.chushou.d.h.dEn().q()) {
            this.mON.dRN();
        } else {
            this.mON.dRO();
        }
        int height = this.mRt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity());
        if (view != null) {
            this.mSc.showAtLocation(view, 85, 0, height);
        }
    }

    private void Nm() {
        if (this.mSc == null) {
            View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mON = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dEn().q()) {
                this.mON.dRN();
            } else {
                this.mON.dRO();
            }
            this.mON.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dEn().g(z);
                }
            });
            this.mRW = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mRX = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mRW.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mRW.setVisibility(0);
            } else {
                this.mRW.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dEn().a) {
                this.mRX.b();
            } else {
                this.mRX.c();
            }
            if (this.mRI != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mRI.f;
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
                                if (this.mLj == null || !this.mLj.mNY.mInPKMode || h.isEmpty(this.mLj.b) || this.mPy == null || !this.mLj.b.equals(this.mPy.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dFa = this.mRI.dFa();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mRJ, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, 5.0f);
                                            }
                                            int identifier = this.mRJ.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mRJ.getPackageName());
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
                                                if (dFa != null && dFa.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mRJ.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mRJ).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dFa2 = this.mRI.dFa();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mRJ).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mRJ, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, 5.0f);
                                        }
                                        int identifier2 = this.mRJ.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mRJ.getPackageName());
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
                                            if (dFa2 != null && dFa2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dFA();
                        c.this.mSc.dismiss();
                    }
                }
            });
            this.mSc = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 150.0f), -2);
            this.mSc.setFocusable(true);
            this.mSc.setOutsideTouchable(true);
            this.mSc.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mSc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mSc = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFA() {
        if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
            if (this.mPc == null) {
                this.mPc = new f(getActivity());
            }
            this.mPc.a(this.mRI.dEZ().mRoominfo, this.ax);
            if (!this.mPc.isShowing()) {
                this.mPc.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.dx) {
            return false;
        }
        if (this.mPX == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mQR = motionEvent.getX();
                    this.mQS = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mQR;
                    if (Math.abs(f) > Math.abs(y - this.mQS) && Math.abs(f) > q && f > 0.0f) {
                        dFO();
                        return true;
                    }
                    this.mQR = 0.0f;
                    this.mQS = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mQx != null && this.mQx.getVisibility() == 0 && b(motionEvent, this.mQx)) {
                this.mQx.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dE(this.mQw);
                return true;
            } else if (this.mPT && this.mQx != null && this.mQx.getVisibility() == 8 && f(this.mSn.b, motionEvent)) {
                aD();
                return true;
            } else if (this.mPd != null && this.mPd.b() && f(this.mPd, motionEvent)) {
                this.mPd.a();
                return true;
            } else if (this.mOT != null && this.mOT.b() && f(this.mOT, motionEvent)) {
                this.mOT.a();
                return true;
            } else if (b(motionEvent, this.mOL)) {
                return dta();
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
            if (this.mSA != null && this.mSA.a(i, keyEvent)) {
                return true;
            }
            if ((this.mPd != null && this.mPd.onKeyDown(i, keyEvent)) || dFs()) {
                return true;
            }
            if (this.mPX == 3) {
                this.mPX = 1;
                dFO();
                return true;
            } else if (this.mOT != null && this.mOT.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mOM != null && this.mOH != null && this.mOL != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dD(this.mOM);
                this.mOH.setVisibility(8);
                this.mOL.setVisibility(0);
            }
        } else if (this.mOH != null && this.mOL != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
            this.mOH.setVisibility(0);
            this.mOL.setVisibility(8);
        }
    }

    public boolean dta() {
        boolean z;
        b(this.mOk, 12);
        boolean z2 = false;
        if (this.mMk != null && this.mMk.getVisibility() == 0) {
            this.mMk.setVisibility(8);
            this.mMl.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mMm) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mRJ);
            this.mMl.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mOL == null || this.mOL.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mPq) {
                bo();
            }
            this.mOL.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mOH != null) {
                    c.this.mOH.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dFs() {
        if (dta()) {
            return true;
        }
        if (this.mSi != null && this.mSi.isShowing()) {
            this.mSi.dismiss();
            return true;
        } else if (this.mSH != null && this.mSH.isShowing()) {
            this.mSH.dismiss();
            return true;
        } else if (this.mSc == null || !this.mSc.isShowing()) {
            return aD() || dFt() || dFy() || dFk();
        } else {
            this.mSc.dismiss();
            return true;
        }
    }

    public boolean dFk() {
        if (this.mSs == null || !this.mSs.isShown()) {
            return false;
        }
        this.mSs.d();
        return true;
    }

    public boolean dFt() {
        if (this.mPV == null || !this.mPV.isShown()) {
            return false;
        }
        this.mPV.a();
        return true;
    }

    public boolean dFy() {
        if (this.mPd == null || !this.mPd.b()) {
            return false;
        }
        this.mPd.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mRJ != null && !((Activity) this.mRJ).isFinishing() && pVar != null) {
            this.mPG = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dFS() && this.mPy != null && mVar.a(this.mPy.mCreatorUID, null)) {
            this.mPy.mIsSubscribed = mVar.c;
            aO();
        }
    }

    public boolean aD() {
        if (!this.mPT || this.mSn == null) {
            return false;
        }
        if (this.mSn != null) {
            this.mSn.e();
        }
        if (this.mQw != null) {
            this.mQw.setText("");
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
        if (!dFS() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mQb != null) {
                        this.mQb.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                        this.mRI.dEZ().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mRI.dEZ().mMicStatus.onMic) {
                            if (this.mOB != null) {
                                this.mOB.setVisibility(8);
                            }
                            if (this.mPV != null && this.mPV.isShown()) {
                                this.mPV.a();
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
                        if (this.mRI.dEZ().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mPy != null && !h.isEmpty(this.mPy.mCreatorUID)) {
                                g(arrayList2, this.mPy.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.mRI.dEZ().mMicStatus.onMic) {
                            if (this.mRI.dEZ().mMicStatus != null && !h.isEmpty(this.mRI.dEZ().mMicStatus.micRoomId) && !this.mRI.dEZ().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mRI.dEZ().mMicStatus.micRoomId;
                            }
                            this.mRI.dEZ().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mRI.dEZ().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = h(this.mRI.dEZ().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mRI.dEZ().mMicStatus, str3, z4);
                            if (this.mPV != null && this.mPV.getVisibility() == 0) {
                                this.mPV.a(this.mRI.dEZ().mFanItems, this.mRI.dEZ().mMicStatus, str3, z4, this.mRI.dEZ().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mOB != null) {
                                this.mOB.setVisibility(8);
                            }
                            if (this.mPV != null && this.mPV.isShown()) {
                                this.mPV.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mPu != onlineVip.mCount || (this.mOz != null && this.mOz.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mPu = onlineVip.mCount;
                        this.bP = onlineVip.mCount;
                        dFC();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mPS.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mPS.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mPS.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mQn <= 5000) {
                                z2 = false;
                            } else {
                                this.mQn = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mPS.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mPS.addAll(onlineVip.mOnlineVipItems);
                            }
                            aP();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mQo != null) {
                    if (this.mPy == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mPy.mCreatorAvatar;
                        str2 = this.mPy.mCreatorGender;
                    }
                    this.mQo.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mLj != null && this.mLj.mNY != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mLj.mNY.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mLf != null) {
                                        this.mLf.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mLj.mNY.mInPKMode = true;
                                    this.mLj.mNY.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mLj.mNY.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mLj.mNY.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mLj.mNY.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mLj.mNY.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mLj.mNY.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mLj.mNY.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mLj.mNY.mMode = pkNotifyInfo.mMode;
                                    this.mLj.mNY.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mLk != null) {
                                        this.mLk.g(true, this.mLj.mNY.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dEn().a) {
                                        if (!com.kascend.chushou.b.dEg().e) {
                                            com.kascend.chushou.b.dEg().e = true;
                                            tv.chushou.zues.utils.g.F(this.mRJ, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dEn().a(this.mRJ, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mLj.mNY.mAction = 7;
                                    this.mLj.mNY.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mLj.mNY.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mLj.mNY.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mLj.mNY.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mLj.mNY.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mLj.mNY.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mLj.mNY.mMode == 2) {
                                        aX();
                                    } else {
                                        aG();
                                    }
                                    if (this.mLk != null) {
                                        this.mLk.g(false, 0L);
                                        this.mLk.b(this.mLj.mNY, true);
                                        this.mLk.a(this.mQq + tv.chushou.zues.utils.a.dip2px(this.mRJ, 52.0f), this.aq);
                                        this.mLk.a(this.mLj.mNY.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mLf != null) {
                                        this.mLf.a(false);
                                    }
                                    this.mLj.mNY.mInPKMode = false;
                                    this.mLj.mNY.mAction = 2;
                                    aG();
                                    aX();
                                    if (this.mLk != null) {
                                        this.mLk.c();
                                    }
                                    this.mLj.b = null;
                                    this.mLj.mNY = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mLj.mNY.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mLj.mNY.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mLj.mNY.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mPy != null && !h.isEmpty(this.mPy.mRoomID) && this.mPy.mRoomID.equals(this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mLj.mNY.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mLk != null) {
                                        this.mLk.a(this.mLj.mNY, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mLj.mNY.copyUpdate(pkNotifyInfo);
                                    if (this.mLk != null) {
                                        this.mLk.a(this.mLj.mNY);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mLj.mNY.copyStop(pkNotifyInfo);
                                        if (this.mLk != null) {
                                            this.mLk.A(this.mLj.mNY.mMaxFreeDuration, this.mLj.mNY.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mLj.mNY.copyResult(pkNotifyInfo);
                                    if (!this.mPQ && this.mLk != null) {
                                        int i7 = 1;
                                        if (this.mLj.mNY.destinyInfo != null && this.mLj.mNY.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mLk.a(h.parseInt(this.mLj.mNY.mResult), h.parseLong(this.mLj.mNY.mvpUid), this.mLj.mNY.mvpAvatar, this.mLj.mNY.mvpNickname, this.mLj.mNY.mMaxFreeDuration, this.mLj.mNY.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mLm != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mLm.uid = cycleLiveRoomInfo.uid;
                        this.mLm.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mLm.roomId = cycleLiveRoomInfo.roomId;
                        this.mLm.avatar = cycleLiveRoomInfo.avatar;
                        this.mLm.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.mRJ != null && (this.mRJ instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mRJ).d();
                        }
                    } else {
                        ((VideoPlayer) this.mRJ).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mRI != null && this.mRI.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dEn().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dEn().b().equals(next2.mUserID)) {
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

    public void dFC() {
        if (this.mOz != null) {
            if (this.mLj == null || this.mLj.mNY == null || !this.mLj.mNY.mInPKMode) {
                if (this.bP > 0) {
                    this.mOz.setVisibility(0);
                    this.mOz.setText(String.format(this.mRJ.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.bP))));
                    this.mOD.setVisibility(0);
                    return;
                }
                this.mOz.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mOB.setVisibility(0);
            if (this.mOC != null) {
                this.mOC.a(str, z, micStatus, this.mRI.dEZ().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mOB.setVisibility(8);
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
        int childCount = this.mPA.getChildCount();
        int itemCount = this.mPA.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mPA);
        if (f + childCount >= itemCount) {
            this.mPH = true;
            if (this.mPI != null) {
                this.mPI.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dFG() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mPB.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mPB.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.mPB == null) {
            this.mPB = new ArrayList<>();
        }
        while (2 < this.mPB.size()) {
            this.mPB.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mPD);
        if (a2 == null) {
            w(false);
            return;
        }
        this.mPB.addAll(a2);
        int size = this.mPB.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mPB.size(); i++) {
                this.mPB.remove(2);
            }
        }
        w(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mPE == null) {
            this.mPE = new ArrayList<>();
        }
        this.mPE.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mPG != null && this.mPG.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mPG.contains("2"))) {
                        this.mPE.add(next);
                    } else if (!this.mPG.contains(next.mType)) {
                        this.mPE.add(next);
                    }
                }
                return this.mPE;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mPB == null) {
                    this.mPB = new ArrayList<>(arrayList);
                    dFG();
                    w(z2);
                    return;
                }
                if (this.mPD == null) {
                    this.mPD = new ArrayList<>();
                }
                this.mPD.addAll(arrayList);
                int size = this.mPD.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mPD.size(); i++) {
                        this.mPD.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mPB.size();
                if (a2 != null) {
                    this.mPB.addAll(a2);
                }
                int size3 = this.mPB.size();
                if (!this.mPH && this.mPI != null) {
                    this.mPI.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mPB.size(); i3++) {
                        this.mPB.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mPB == null) {
                this.mPB = new ArrayList<>(arrayList);
                dFG();
            } else {
                if (this.mPD == null) {
                    this.mPD = new ArrayList<>();
                }
                this.mPD.clear();
                this.mPD.addAll(arrayList);
                this.mPB.clear();
                dFG();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mPB.addAll(a3);
                }
            }
            w(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mPF != null) {
                this.mPF.a(this.mPB.size());
                if (i == 1) {
                    this.mPF.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mPF.notifyItemRangeRemoved(i2, i3);
                    this.mPF.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mPF.notifyDataSetChanged();
                }
            }
            if (z || this.mPH) {
                this.mPH = true;
                if (this.mPI != null) {
                    this.mPI.setVisibility(8);
                }
                if (z) {
                    this.mPx.scrollToPosition(this.mPB.size() - 1);
                } else {
                    this.mPx.smoothScrollToPosition(this.mPB.size() - 1);
                }
            }
        }
    }

    private void w(boolean z) {
        if (!this.ah) {
            if (this.mPF != null) {
                this.mPF.a(this.mPB.size());
                this.mPF.notifyDataSetChanged();
            }
            if (z || this.mPH) {
                this.mPH = true;
                if (this.mPI != null) {
                    this.mPI.setVisibility(8);
                }
                if (z) {
                    this.mPx.scrollToPosition(this.mPB.size() - 1);
                } else {
                    this.mPx.smoothScrollToPosition(this.mPB.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dEK;
        RoomToast roomToast;
        this.p = false;
        if (this.mRI != null && this.mRI.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mRI.f.size()) {
                    break;
                } else if (!"2".equals(this.mRI.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dFK();
            return;
        }
        if (this.mLz != null) {
            this.mLz.setVisibility(0);
        }
        if (this.mOp != null) {
            this.mOp.setVisibility(0);
        }
        if (this.mRI != null) {
            this.mPy = this.mRI.dFc();
            this.mPz = this.mRI.dEZ();
            if (com.kascend.chushou.b.dEg().c != null && this.mPF != null) {
                this.mPF.a(com.kascend.chushou.b.dEg().c);
                this.mPF.notifyDataSetChanged();
            }
            FullRoomInfo dEZ = this.mRI.dEZ();
            if (dEZ != null) {
                if (!h.isEmpty(dEZ.mRoomToastList)) {
                    Iterator<RoomToast> it = dEZ.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dEn().j())) {
                    a(roomToast);
                }
            }
            if (this.mPy != null) {
                bk();
            }
            if (this.mPy != null && !this.mPy.mIsSubscribed) {
                RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mPy == null || !c.this.mPy.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mRI != null && this.mRI.l()) {
                d(true);
            }
        }
        if (this.mPy != null && this.mPF != null) {
            if (this.mPB != null) {
                this.mPB.clear();
            } else {
                this.mPB = new ArrayList<>();
            }
            this.mPF.a(this.mPy);
            dFG();
            this.mPF.a(this.mPB.size());
            this.mPF.notifyDataSetChanged();
        }
        aM();
        N();
        if (this.mRJ != null && (this.mRJ instanceof VideoPlayer) && (dEK = ((VideoPlayer) this.mRJ).dEK()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dEK.mNY, dEK.b);
        }
        this.mOQ.h(this.mPy.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mPy.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mOU);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void bd() {
        if (this.mPt == null) {
            View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mMM = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mPt = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mRJ, 160.0f), -2);
            this.mPt.setFocusable(false);
            this.mPt.setOutsideTouchable(false);
            this.mPt.setAnimationStyle(a.j.gift_toast_style);
            this.mPt.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dEn().c(roomToast.mToastContent);
            if (this.mPt == null) {
                bd();
            }
            if (this.mMM != null) {
                this.mMM.setText(roomToast.mToastContent);
            }
            if (!this.mPt.isShowing()) {
                if (this.mOU != null) {
                    this.mPt.showAtLocation(this.mOU, 85, 0, this.mRt.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aw(getActivity()));
                    RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mPt != null) {
                                c.this.mPt.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mPt.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mQj != null) {
            this.mQj.setVisibility(z ? 0 : 8);
        }
        this.mQk = true;
        if (this.mRJ instanceof VideoPlayer) {
            ((VideoPlayer) this.mRJ).p();
        }
    }

    private void dFK() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.mRJ).s();
        dFk();
        dFt();
        if (this.mOF == null) {
            this.mOF = (PlayShowRecommendView) ((ViewStub) this.mRt.findViewById(a.f.view_recommend)).inflate();
        }
        this.mOF.setVisibility(0);
        if (this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null && !h.isEmpty(this.mRI.dEZ().mRoominfo.mRoomID)) {
            bf();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mSn != null) {
            this.mSn.e();
        }
        if (this.mLz != null) {
            this.mLz.setVisibility(4);
        }
        if (this.mOp != null) {
            this.mOp.setVisibility(8);
        }
        if (this.mSw != null) {
            this.mSw.dRk();
            this.mSw.setVisibility(8);
        }
        wE(false);
        a(false, false);
        if (this.mLf != null) {
            this.mLf.a();
        }
    }

    private void bf() {
        if (this.mOF != null && this.mOF.getVisibility() == 0) {
            this.mOF.a(this.mRI.dEZ().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dFw() {
        super.dFw();
        if (this.mRJ instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mPd != null && this.mPd.b()) {
            this.mPd.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mPU);
        if (this.mRJ != null) {
            if (this.mPU || "10004".equals(((VideoPlayer) this.mRJ).t)) {
                this.mPU = true;
                if (this.mRI != null) {
                    this.mRI.f = null;
                    if (this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                        this.mRI.dEZ().mRoominfo.mGameId = null;
                    }
                }
                dFK();
                return;
            }
            this.mPU = true;
            if (this.mRJ != null) {
                ((VideoPlayer) this.mRJ).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mPU = false;
        if (this.mLz != null) {
            this.mLz.setVisibility(0);
        }
        if (this.mOp != null) {
            this.mOp.setVisibility(0);
        }
        if (this.mOF != null) {
            this.mOF.setVisibility(8);
        }
        if (this.mRD != null) {
            this.mRD.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mPU = false;
        if (this.mLz != null) {
            this.mLz.setVisibility(0);
        }
        if (this.mOp != null) {
            this.mOp.setVisibility(0);
        }
        if (this.mOF != null) {
            this.mOF.setVisibility(8);
        }
        if (this.mRD != null) {
            this.mRD.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mOF != null) {
            this.mOF.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dFS()) {
            if (i()) {
                if (i == 404) {
                    if (this.mRI != null) {
                        this.mRI.f = null;
                        this.mRI.dEZ().mRoominfo.mGameId = null;
                    }
                    dFK();
                    return;
                }
                tv.chushou.zues.utils.g.KB(a.i.str_getvideosource_failed);
            }
            wE(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mRI != null && this.mRI.dFa() != null) {
            a(this.mRI.dFa());
        }
        this.p = false;
        if (this.mRI == null || this.mRI.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mRI.f.size()) {
                if (!"2".equals(this.mRI.f.get(i2).mType)) {
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
    public GiftAnimationLayout dFq() {
        if (this.mRt == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mRt.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mOU != null) {
            int size = iconConfig.configs.size();
            this.mOU.removeAllViews();
            if (this.mOW != null) {
                this.mOW.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mRJ).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mOU, false);
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
                            this.mOW.setVisibility(0);
                            this.mOV.bV(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.mOU.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void D() {
        if (this.mRJ instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dEF = ((VideoPlayer) this.mRJ).dEF();
            if (this.mSA == null) {
                this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mSA.setVisibility(0);
            this.mSA.a(2, dEF);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mOY != null && this.mRJ != null) {
            this.mOY.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mOY != null && this.mRJ != null) {
            this.mOY.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(long j) {
        if (this.mOY != null) {
            this.mOY.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0808a
    public void c(int i) {
        if (this.mOY != null) {
            this.mOY.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void a(int i) {
        if (this.mOX != null) {
            if (this.mRJ != null) {
                this.mOX.a(((VideoPlayer) this.mRJ).dEF(), false);
            }
            this.mOX.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mRt != null) {
            Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
            int i = gv.x > gv.y ? 1 : 2;
            if (this.mSA == null) {
                this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mSA.setPlayerViewHelper(this.mRI);
            this.mSA.setVisibility(0);
            this.mSA.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mOZ != null) {
            this.mOZ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mOZ != null) {
            this.mOZ.a(bangInfo, str);
        }
        if (this.mLN != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mLN.setText(this.mRJ.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mLN.setText(this.mRJ.getString(a.i.str_contribute_tittle));
            } else {
                this.mLN.setText(Html.fromHtml(this.mRJ.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mOA != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mOA.setText(this.mRJ.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mOA.setText(this.mRJ.getString(a.i.str_contribute_tittle));
            } else {
                this.mOA.setText(Html.fromHtml(this.mRJ.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mOZ != null) {
            this.mOZ.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mRI != null && !h.isEmpty(this.mRI.mKQ)) {
            this.mPZ = this.mRI.mKQ.get(0);
            if (this.mQr != null) {
                this.mQr.setVisibility(0);
                this.mQr.a(this.mPZ.mCover, 0, 0, 0, 1);
                if (this.mQs != null) {
                    if (this.mPZ.mShowClose) {
                        this.mQs.setVisibility(0);
                    } else {
                        this.mQs.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mOZ != null) {
            this.mOZ.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mRt != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mMk != null) {
            this.mMk.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dFS() && !this.mPQ) {
            if (iVar.a == 52) {
                if (this.mPF != null) {
                    this.mPF.a(com.kascend.chushou.b.dEg().c);
                    this.mPF.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mPQ && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dFS()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mOM != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mOM);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dFS() && !this.mPQ) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dEG = ((VideoPlayer) this.mRJ).dEG();
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(2, dEG);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dEH = ((VideoPlayer) this.mRJ).dEH();
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(2, dEH);
            } else if (bVar.a == 8) {
                if (this.mQb != null && this.mQb.getVisibility() != 0) {
                    this.mQb.a(a.C0795a.slide_in_bottom_danmu_anim, a.C0795a.slide_out_bottom_danmu_anim, this.mPy == null ? "" : this.mPy.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mSA == null) {
                    this.mSA = (H5Container) ((ViewStub) this.mRt.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mSA.setVisibility(0);
                this.mSA.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dFS() && this.mRI != null && !h.isEmpty(this.mRI.a) && this.mRI.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mQb != null && this.mQb.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mRJ, 80.0f);
                }
                if (this.mQa != null && this.mQa.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mQa.getHeight());
                }
                this.mQm.setTranslationY(-r0);
                return;
            }
            if (this.mQl != null) {
                this.mQl.cancel();
                this.mQl = null;
            }
            int translationY = (int) this.mQm.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mRJ, 80.0f) : 0;
                    if (this.mQa != null && this.mQa.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mQa.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mQa.getHeight() : 0;
                    if (this.mQb != null && this.mQb.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mRJ, 80.0f));
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
        this.mQl = ValueAnimator.ofInt(i, i2);
        this.mQl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dFS() && c.this.mOZ != null) {
                    c.this.mQm.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mQl.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mQl = null;
            }
        });
        this.mQl.setInterpolator(new LinearInterpolator());
        this.mQl.setDuration(800L);
        this.mQl.start();
    }

    private boolean dFL() {
        if (this.mPX == 1) {
            this.mPX = 2;
            x(true);
            return true;
        } else if (this.mPX == 3) {
            dFO();
            return true;
        } else {
            return false;
        }
    }

    private boolean dFM() {
        if (this.mPX == 1) {
            return dFN();
        }
        if (this.mPX == 2) {
            this.mPX = 1;
            x(false);
            return true;
        }
        return false;
    }

    private boolean dFN() {
        if (this.dx || this.mRI == null || this.mRI.dFc() == null) {
            return false;
        }
        if (this.mQT != null) {
            this.mQT.a(true);
        }
        this.mPX = 3;
        this.dx = true;
        bk();
        this.mOm.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.dx = false;
                c.this.mOo.setVisibility(8);
            }
        });
        this.mOo.startAnimation(loadAnimation);
        this.mOm.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFO() {
        if (!this.dx) {
            if (this.mQT != null) {
                this.mQT.a(false);
            }
            this.mPX = 1;
            this.dx = true;
            bk();
            this.mOo.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.dx = false;
                    c.this.mOm.setVisibility(8);
                }
            });
            this.mOo.startAnimation(loadAnimation);
            this.mOm.startAnimation(loadAnimation2);
        }
    }

    private void bk() {
        if (this.mRt != null) {
            if (this.mOm == null) {
                this.mOm = this.mRt.findViewById(a.f.user_space_container);
            }
            if (this.mOo == null) {
                this.mOo = this.mRt.findViewById(a.f.video_container);
            }
            if (this.mOn == null) {
                this.mOn = com.kascend.chushou.view.user.b.b(null, this.mRI.a, false, this.mRI.h);
                this.mOn.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dFO();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dFO();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mOn).commitAllowingStateLoss();
            }
        }
    }

    private void x(boolean z) {
        Animation loadAnimation;
        if (this.mOp != null) {
            this.mOp.setVisibility(z ? 8 : 0);
        }
        if (this.mPv != null) {
            this.dx = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mPv.setVisibility(8);
                        c.this.dx = false;
                    }
                });
            } else {
                this.dx = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mPv.setVisibility(0);
                        c.this.dx = false;
                    }
                });
            }
            this.mPv.startAnimation(loadAnimation);
        }
        dFs();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mOG.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void Nl() {
        if ("4".equals(this.ax)) {
            if (this.mOO != null) {
                this.mOO.setVisibility(0);
            }
            if (this.mOP != null) {
                this.mOP.a();
                return;
            }
            return;
        }
        if (this.mOR != null) {
            this.mOR.setVisibility(0);
        }
        if (this.mOS != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mOS.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mOR != null) {
            this.mOR.setVisibility(8);
        }
        if (this.mOS != null) {
            this.mOS.clearAnimation();
        }
        if (this.mOO != null) {
            this.mOO.setVisibility(8);
        }
        if (this.mOP != null) {
            this.mOP.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mPv != null && this.mRt != null) {
            if (this.mQb == null) {
                this.mQb = new com.kascend.chushou.player.ui.miniview.a(this.mRJ, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mQb != null && c.this.mRt != null && c.this.mQb.a()) {
                            ((ViewGroup) c.this.mRt).removeView(c.this.mQb);
                            c.this.mQb = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mQb.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mRJ, 52.0f);
                this.mQb.setLayoutParams(layoutParams);
                ((ViewGroup) this.mPv).addView(this.mQb, ((ViewGroup) this.mPv).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mQb.setVisibility(8);
                } else {
                    this.mQb.a(a.C0795a.slide_in_bottom_danmu_anim, a.C0795a.slide_out_bottom_danmu_anim, this.mRI.a == null ? "" : this.mRI.a);
                }
            } else if (!this.mQb.isShown()) {
                this.mQb.a(a.C0795a.slide_in_bottom_danmu_anim, a.C0795a.slide_out_bottom_danmu_anim, this.mRI.a == null ? "" : this.mRI.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mQi != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mQi.setVisibility(0);
                this.mQi.setAnim(true);
                this.mQi.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nQh, b.C0924b.nQj, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mPJ != null && this.mPJ.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dFP();
                    }
                });
                this.mPJ.setVisibility(0);
                this.mPJ.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mPJ != null && this.mPJ.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mPL != null) {
                        c.this.mPL.removeAllListeners();
                        c.this.mPL.cancel();
                        c.this.mPL = null;
                    }
                    if (c.this.mPJ != null) {
                        c.this.mPJ.setVisibility(8);
                    }
                }
            });
            this.mPJ.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mQp == null) {
                this.mQp = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dFS()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mRJ, "显示双击666_num", null, new Object[0]);
                            if (c.this.mRI != null) {
                                c.this.mRI.b(false);
                            }
                            c.this.d(false);
                            c.this.y(true);
                        }
                    }
                };
                if (this.mRK != null) {
                    this.mRK.e(this.mQp, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mQp != null) {
            this.mRK.P(this.mQp);
            this.mQp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mPM != null && this.mPM.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dFQ();
                    }
                });
                this.mPM.setVisibility(0);
                this.mPM.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mRs, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.y(false);
                    }
                });
            }
        } else if (this.mPM != null && this.mPM.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mRJ, a.C0795a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mPO != null) {
                        c.this.mPO.removeAllListeners();
                        c.this.mPO.cancel();
                        c.this.mPO = null;
                    }
                    if (c.this.mPM != null) {
                        c.this.mPM.setVisibility(8);
                    }
                }
            });
            this.mPM.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFP() {
        if (this.mPJ == null || this.mPK == null) {
            return null;
        }
        if (this.mPL != null) {
            this.mPL.removeAllListeners();
            this.mPL.cancel();
            this.mPL = null;
        }
        this.mPK.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mPK, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mPK, 0.0f);
        int measuredWidth = (this.mPJ.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mRJ, 13.0f) * 2)) - this.mPK.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mPK, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mPK, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mPK, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mPL != null) {
                    c.this.mPL.removeAllListeners();
                    c.this.mPL.cancel();
                    c.this.mPL = null;
                }
                RxExecutor.postDelayed(c.this.mRs, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dFP();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mPL = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFQ() {
        if (this.mPM == null || this.mPN == null) {
            return null;
        }
        if (this.mPO != null) {
            this.mPO.removeAllListeners();
            this.mPO.cancel();
            this.mPO = null;
        }
        this.mPN.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mPN, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mPN, 0.0f);
        int measuredWidth = (this.mPM.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mRJ, 13.0f) * 2)) - this.mPN.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mPN, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mPN, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mPN, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mPO != null) {
                    c.this.mPO.removeAllListeners();
                    c.this.mPO.cancel();
                    c.this.mPO = null;
                }
                RxExecutor.postDelayed(c.this.mRs, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dFQ();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mPO = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mQT = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mLm != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mLm.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dFS()) {
                        ParserRet dF = com.kascend.chushou.c.a.dF(jSONObject);
                        if (dF.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.KB(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.KB(a.i.subscribe_success);
                            }
                            if (c.this.mLm != null) {
                                c.this.mLm.isSubscribe = !z;
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
                    if (!c.this.dFS()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dEj().a(bVar, (String) null, this.mLm.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mLm.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dEj().b(bVar, (String) null, c.this.mLm.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mRI != null && this.mPy != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mRI.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mRI.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mPy.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dFS()) {
                        ParserRet dF = com.kascend.chushou.c.a.dF(jSONObject);
                        if (dF.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.KB(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.KB(a.i.subscribe_success);
                            }
                            c.this.mPy.mIsSubscribed = !z;
                            c.this.aO();
                            return;
                        }
                        a(dF.mRc, dF.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dFS()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dEj().a(bVar, (String) null, this.mPy.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mPy.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dEj().b(bVar, (String) null, c.this.mPy.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mNX != null) {
            int width = this.mNX.getWidth();
            int height = this.mNX.getHeight();
            if (this.mQg != width || this.mQh != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mRt != null) {
            if (this.mOT == null) {
                this.mOT = (InteractionView) ((ViewStub) this.mRt.findViewById(a.f.view_interaction)).inflate();
                this.mOT.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mOT.a();
                    }
                });
            }
            if (this.mOT != null) {
                this.mOT.b(configDetail);
                this.mOT.c();
                this.mOT.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals(HttpConfig.UBC_HTTP_ID)) {
            if (!tv.chushou.zues.utils.a.dRX()) {
                tv.chushou.zues.utils.g.F(this.mRJ, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mRJ, null) && (this.mRJ instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mRI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mRJ, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mRI != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mRJ, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mRJ, configDetail.mUrl, this.mRJ.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mRJ, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals(UbcStatConstant.DebugContentValue.GIFT)) {
                    if (this.mPT) {
                        aD();
                        return;
                    }
                    if (this.mRJ.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mRJ, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mRI != null && this.mRI.dEZ() != null && this.mRI.dEZ().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.l("type", "4", "_clickPos", "27", "roomId", this.mRI.dEZ().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dt(this.mOU);
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
        if (this.mRJ != null && !this.v && !h.isEmpty(str) && this.mPy != null && str.equals(this.mPy.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mLj == null) {
                this.mLj = new com.kascend.chushou.player.e.a();
            }
            this.mLj.b = str;
            this.mLj.mNY.copy(pkNotifyInfo);
            if (this.mLj.mNY.mAction == 6) {
                if (this.mLf != null) {
                    this.mLf.a(true);
                }
                this.mLj.mNY.mInPKMode = true;
                this.u = this.mLj.mNY.mPkId;
            } else if (this.mLj.mNY.mAction == 7 || (this.mLj.mNY.mMode == 1 && this.mLj.mNY.mAction == 5)) {
                if (this.mLf != null) {
                    this.mLf.a(true);
                }
                this.mLj.mNY.mInPKMode = true;
                if (this.mQe != 42) {
                    this.mQq = ((this.mQf.y - ((this.mQf.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mRJ, 158.0f) + this.mPr)) - tv.chushou.zues.utils.systemBar.b.aw(getActivity());
                    aX();
                }
                this.u = this.mLj.mNY.mPkId;
                if (this.mLk != null) {
                    this.mLk.b(this.mLj.mNY, false);
                    this.mLk.a(this.mLj.mNY.mMode, (String) null);
                    if (this.mLj.mNY.mAction == 5 && this.mLj.mNY.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mLj.mNY.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mLj.mNY.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mLj.mNY.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mLj.mNY.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mLj.mNY.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mLk.a(this.mLj.mNY);
                        this.mLk.a(parseInt, this.mLj.mNY.mPkUpdateInfo.remainDuration, j, this.mLj.mNY.mMode, (this.mLj.mNY.destinyInfo == null || this.mLj.mNY.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mLj.mNY.mPkUpdateInfo != null && !h.isEmpty(this.mLj.mNY.mPkUpdateInfo.specialMomentList) && this.mLk != null) {
                    this.mLk.a(this.mLj.mNY, true);
                }
                if (this.mLj.mNY.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            } else {
                this.mLj.mNY.mInPKMode = false;
                if (this.mLj.mNY.mMode == 2) {
                    aX();
                } else {
                    aG();
                }
            }
        }
    }

    public void aG() {
        aV();
        dFv();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mPo != null && this.mRI != null && this.mRI.mKR != null) {
            this.mPo.setText(tv.chushou.zues.utils.b.KA(this.mRI.mKR.count));
            this.mPo.setVisibility(0);
            if (this.mRI.mKR.count < 1) {
                bo();
            }
            if (this.mPf != null) {
                this.mPf.setText(this.mRI.mKR.primaryName);
            }
            if (this.mPg != null) {
                this.mPg.setText(this.mRI.mKR.desc);
            }
            aH();
        }
    }

    public void aH() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mPp * h.parseLong(this.mRI.mKR.point)));
        if (this.mMC != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mRJ.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.J(this.mRJ, a.e.icon_coin_new);
            cVar.append(this.mRJ.getString(a.i.str_buy_count_coin2));
            this.mMC.setText(cVar);
        }
    }

    private void bn() {
        if (com.kascend.chushou.d.e.c(this.mRJ, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mPp);
        }
    }

    private void bo() {
        this.mPq = false;
        this.mPl.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mRI != null && this.mRI.mKR != null) {
            if (this.mRI.mKR.count < 1) {
                this.mPo.setVisibility(8);
            } else {
                this.mPo.setVisibility(0);
                this.mPo.setSelected(false);
                this.mPo.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mPe.setVisibility(8);
        if (this.mOM != null) {
            this.mOM.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mLo != null) {
            if (z) {
                this.mLo.setVisibility(0);
            } else {
                this.mLo.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mQQ != null) {
            this.mQQ.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mOV != null) {
            this.mOV.performClick();
        }
    }
}
