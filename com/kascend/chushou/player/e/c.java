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
import android.widget.Toast;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes4.dex */
public class c extends com.kascend.chushou.player.d implements View.OnClickListener {
    private TextView mRF;
    private KPSwitchPanelLinearLayout mRN;
    private ImageView mRO;
    private tv.chushou.zues.widget.kpswitch.b.c mRQ;
    private d.a mRR;
    private View mRd;
    public String mRk;
    private TextView mRo;
    private TextView mRr;
    private ImageView mRw;
    private TextView mSi;
    private TextView mSv;
    private View mSy;
    private TextView mTB;
    private RelativeLayout mUA;
    private AnimationSet mUB;
    private ImageView mUC;
    private ImageView mUD;
    private RelativeLayout mUE;
    private PastedEditText mUF;
    private ToggleButton mUG;
    private RelativeLayout mUH;
    private PaoPaoView mUI;
    private FrescoThumbnailView mUJ;
    private LinearLayout mUK;
    private ImageView mUL;
    private InteractionView mUM;
    private LinearLayout mUN;
    private FrescoThumbnailView mUO;
    private FrameLayout mUP;
    private RedpacketNotifier mUQ;
    private InteractNotifier mUR;
    private EmbeddedButtonLayout mUS;
    private GiftAnimationLayout mUT;
    private com.kascend.chushou.player.b.a mUU;
    private f mUV;
    private PlayShowH5View mUW;
    private LinearLayout mUX;
    private TextView mUY;
    private TextView mUZ;
    private int mUb;
    private View mUc;
    private View mUd;
    private com.kascend.chushou.view.user.b mUe;
    private View mUf;
    private FrameLayout mUg;
    private LinearLayout mUh;
    private RelativeLayout mUi;
    private FrescoThumbnailView mUj;
    private TextView mUl;
    private TextView mUm;
    private TextView mUn;
    private FrescoThumbnailView mUo;
    private TextView mUp;
    private TextView mUq;
    private TextView mUr;
    private int mUs;
    private TextView mUt;
    private LinearLayout mUu;
    private PlayShowMicStatusView mUv;
    private RecyclerView mUw;
    private ImageView mUx;
    private PlayShowRecommendView mUy;
    private View mUz;
    private View mVA;
    private View mVB;
    private Animator mVC;
    private View mVD;
    private View mVE;
    private Animator mVF;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mVI;
    private PlayShowMicPerson mVM;
    private FoodView mVQ;
    public ListItem mVR;
    private FoodView mVS;
    private com.kascend.chushou.player.ui.miniview.a mVT;
    private int mVU;
    private int mVV;
    private int mVW;
    private Point mVX;
    private TextView mVa;
    private TextView mVb;
    private TextView mVc;
    private TextView mVd;
    private ImageView mVe;
    private TextView mVf;
    private PopupWindow mVk;
    private View mVm;
    private RecyclerView mVo;
    private RoomInfo mVp;
    private RecyclerView.LayoutManager mVr;
    private ArrayList<ChatInfo> mVs;
    private ArrayList<ChatInfo> mVt;
    private ArrayList<ChatInfo> mVu;
    private ArrayList<ChatInfo> mVv;
    private Button mVz;
    private RelativeLayout mWA;
    private RelativeLayout mWB;
    private FrescoThumbnailView mWC;
    private TextView mWD;
    private TextView mWE;
    private ImageView mWF;
    private RelativeLayout mWG;
    private TextView mWI;
    private float mWJ;
    private float mWK;
    private a mWL;
    private FrescoThumbnailView mWa;
    private FrescoThumbnailView mWb;
    private ValueAnimator mWd;
    private LinearLayout mWe;
    private long mWf;
    private VideoShowVoteView mWg;
    private Runnable mWh;
    private FrescoThumbnailView mWj;
    private ImageView mWk;
    private RelativeLayout mWl;
    private TextView mWm;
    private ImageView mWn;
    private EditText mWo;
    private View mWp;
    private RelativeLayout mWq;
    private RelativeLayout mWr;
    private FrescoThumbnailView mWs;
    private TextView mWt;
    private TextView mWu;
    private ImageView mWv;
    private RelativeLayout mWw;
    private LinearLayout mWx;
    private TextView mWy;
    private TextView mWz;
    private boolean mRP = false;
    private int mVg = 1;
    private boolean mVh = false;
    private int mVi = 0;
    private int mVj = 0;
    private int mVl = -1;
    private boolean mVn = false;
    private FullRoomInfo mVq = null;
    private com.kascend.chushou.player.adapter.a mVw = null;
    private ArrayList<String> mVx = null;
    private boolean mVy = true;
    private boolean mVG = true;
    private boolean mVH = false;
    public final List<OnlineVipItem> mVJ = new ArrayList();
    private boolean mVK = false;
    private boolean mVL = false;
    private long mVN = 0;
    private int mVO = 1;
    private boolean mVP = false;
    private int mVY = -1;
    private int mVZ = -1;
    private boolean mWc = false;
    private int mWi = -1;
    private io.reactivex.disposables.b mWH = null;

    /* loaded from: classes4.dex */
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
        this.mRk = getArguments().getString("cover");
        this.mVG = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mXl = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mXl;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dCG()) {
            dBJ();
            this.mTO = ((VideoPlayer) this.mXB).dAU();
            this.mXA = ((VideoPlayer) this.mXB).dAX();
            dy(view);
            dBX();
            if (this.mXB instanceof VideoPlayer) {
                ((VideoPlayer) this.mXB).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mVH = false;
        if (this.mYg != null) {
            this.mYg.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mVH = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mVC != null) {
            this.mVC.removeAllListeners();
            this.mVC.cancel();
            this.mVC = null;
        }
        if (this.mVF != null) {
            this.mVF.removeAllListeners();
            this.mVF.cancel();
            this.mVF = null;
        }
        if (this.mUR != null) {
            this.mUR.c();
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
        if (this.mWH != null) {
            this.mWH.dispose();
            this.mWH = null;
        }
        this.mVg = 1;
        this.mVh = false;
        if (this.mXC != null) {
            this.mXC.cp(null);
        }
        if (this.mVk != null) {
            this.mVk.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mXB, this.mRQ);
        if (this.mXB != null && (this.mXB instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXB).dBa();
        }
        this.mRR = null;
        this.mRQ = null;
        dBH();
        if (this.mUU != null) {
            this.mUU.a();
        }
        if (this.mUI != null) {
            this.mUI.b();
            this.mUI.c();
            this.mUI = null;
        }
        super.d();
    }

    private void dBH() {
        tv.chushou.zues.a.a.cq(this);
        if (this.mVu != null) {
            this.mVu.clear();
        }
        if (this.mVs != null) {
            this.mVs.clear();
        }
        if (this.mVv != null) {
            this.mVv.clear();
        }
        if (this.mVt != null) {
            this.mVt.clear();
        }
        if (this.mVx != null) {
            this.mVx.clear();
        }
        if (this.mVw != null) {
            this.mVw.a(0);
            this.mVw.a();
        }
    }

    private void dy(View view) {
        this.mUc = view.findViewById(a.f.fl_root);
        this.mVX = tv.chushou.zues.utils.a.hf(this.mXB);
        this.mVi = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXB);
        this.mVj = tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        this.mVW = 86;
        this.mXA = ((VideoPlayer) this.mXB).dAX();
        if (this.mXA != null) {
            this.mVp = this.mXA.dBy();
            this.mVq = this.mXA.dBw();
        }
        this.mVs = new ArrayList<>();
        this.mVu = new ArrayList<>();
        this.mVt = new ArrayList<>();
        this.mUg = (FrameLayout) this.mXl.findViewById(a.f.fl_effect);
        b();
        this.mXv = (PlayerErrorView) this.mXl.findViewById(a.f.view_net_error_msg);
        this.mXv.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mUH = (RelativeLayout) this.mXl.findViewById(a.f.rl_audio_ani);
        this.mUI = (PaoPaoView) this.mXl.findViewById(a.f.audio_ani);
        this.mUJ = (FrescoThumbnailView) this.mXl.findViewById(a.f.audio_ani_avatar);
        this.mUK = (LinearLayout) this.mXl.findViewById(a.f.ll_audio);
        this.mTB = (TextView) this.mXl.findViewById(a.f.tv_open_video);
        this.mUL = (ImageView) this.mXl.findViewById(a.f.iv_audio_ani);
        this.mWb = (FrescoThumbnailView) this.mXl.findViewById(a.f.live_cover);
        if (!this.mWc || this.mTO == null || this.mTO.getPlayState() != 4) {
            this.mWb.setVisibility(0);
            this.mWb.setBlur(true);
            this.mWb.i(this.mRk, 0, 0, 0);
        }
        this.mTB.setOnClickListener(this);
        this.mQO = new b();
        this.mQO.a(view, null, this.mXB, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dOJ()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mXA != null) {
                    append.append(c.this.mXA.dBy().mRoomID);
                }
                if (c.this.mQN != null && c.this.mQN.mTP != null) {
                    append.append("&mode=").append(c.this.mQN.mTP.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mXB, append.toString());
            }
        });
        this.mQS = (VoiceInteractionView) this.mXl.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mXA != null) {
            this.mVp = this.mXA.dBy();
            this.mVq = this.mXA.dBw();
        }
        dBK();
        dBI();
        dBP();
        this.mWe = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mVQ = (FoodView) view.findViewById(a.f.rav_ad);
        this.mWj = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mWk = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mWj.setOnClickListener(this);
        this.mWk.setOnClickListener(this);
        this.mWl = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mWa = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mWa.setOnClickListener(this);
        this.mUR = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mUQ = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mVz = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mVz.setOnClickListener(this);
        this.mVo = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mVo.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVo.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mVX.x, this.mVX.y) * 0.83d);
        this.mVo.setLayoutParams(layoutParams);
        this.mVr = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mXB);
        this.mVo.setLayoutManager(this.mVr);
        this.mVo.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mVo.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mVo.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dCj();
                } else if (i == 1) {
                    c.this.mVy = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mVw = new com.kascend.chushou.player.adapter.a(this.mXB, this.mVs);
        if (this.mVp != null) {
            this.mVw.a(this.mVp);
        }
        if (com.kascend.chushou.b.dAF().c != null) {
            this.mVw.a(com.kascend.chushou.b.dAF().c);
        }
        this.mVo.setAdapter(this.mVw);
        this.mVw.a(this.mVs.size());
        this.mVw.notifyDataSetChanged();
        if (this.mXA != null && (c = this.mXA.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mUU != null) {
            this.mUU.a();
            this.mUU = null;
        }
        this.mUT = (GiftAnimationLayout) this.mXl.findViewById(a.f.ll_gift_animation);
        this.mUT.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mUb = ((int) (tv.chushou.zues.utils.a.he(this.mXB).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mXB, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mUT.getLayoutParams();
        layoutParams2.bottomMargin = this.mUb;
        this.mUT.setLayoutParams(layoutParams2);
        if (this.mXA != null) {
            this.mUU = new com.kascend.chushou.player.b.a(this.mXB.getApplicationContext(), this.mUT);
            this.mUU.a(this.mXA);
            a(this.mXA.mQu, this.mXA.mQy);
        }
        this.mXl.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mUS = (EmbeddedButtonLayout) this.mXl.findViewById(a.f.embedded_button_layout);
        this.mUS.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mWg = (VideoShowVoteView) this.mXl.findViewById(a.f.view_video_show_vote);
        this.mWg.setOnClickListener(this);
        this.mWg.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dCf();
            }
        });
        if (this.mXA != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
            this.mUS.a(videoPlayer.dBg().dCN());
            this.mUS.b(this.mXA.i());
            this.mUQ.a(videoPlayer.dBc(), false);
            this.mUR.a(videoPlayer.dBd(), videoPlayer.dBe(), videoPlayer.dBf());
            this.mQN = new com.kascend.chushou.player.e.a();
        }
        this.mYq = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mVK = false;
                c.this.b(c.this.mUb, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mVK = true;
                if (c.this.mYg != null) {
                    c.this.mYg.measure(0, 0);
                    int measuredHeight = c.this.mYg.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mXB, 14.0f);
                    if (measuredHeight > c.this.mUb) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mYk = (PaoGuideView) this.mXl.findViewById(a.f.rlPaoGuideView);
        this.mVM = (PlayShowMicPerson) this.mXl.findViewById(a.f.rl_mic_person_view);
        this.mUW = (PlayShowH5View) this.mXl.findViewById(a.f.rl_playshowh5);
        this.mVS = (FoodView) this.mXl.findViewById(a.f.bottom_ad);
        if (this.mXA != null) {
            H();
            if (this.mXA.mQo != null && !h.isEmpty(this.mXA.mQo.mUrl)) {
                b(this.mXA.mQo);
            }
        }
        this.mVA = this.mXl.findViewById(a.f.view_reminder_subscribe);
        this.mVB = this.mVA.findViewById(a.f.spash_subscribe);
        ((TextView) this.mVA.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().O(this.mXB, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.mXB.getString(a.i.videoplayer_reminder_subscribe)));
        this.mVA.setOnClickListener(this);
        this.mVD = this.mXl.findViewById(a.f.view_reminder_danmaku);
        this.mVE = this.mVD.findViewById(a.f.spash_danmaku);
        ((TextView) this.mVD.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().O(this.mXB, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.mXB.getString(a.i.videoplayer_reminder_danmaku)));
        this.mVD.setOnClickListener(this);
    }

    private void dBI() {
        this.mWq = (RelativeLayout) this.mXl.findViewById(a.f.rl_cyclelive);
        this.mWr = (RelativeLayout) this.mXl.findViewById(a.f.rlrl_cyclelive);
        this.mWs = (FrescoThumbnailView) this.mXl.findViewById(a.f.iv_liveicon);
        this.mWt = (TextView) this.mXl.findViewById(a.f.tv_livename);
        this.mWu = (TextView) this.mXl.findViewById(a.f.tv_livedesc);
        this.mWv = (ImageView) this.mXl.findViewById(a.f.iv_cyclelive_name_menu);
        this.mWw = (RelativeLayout) this.mXl.findViewById(a.f.rl_normal);
        this.mWx = (LinearLayout) this.mXl.findViewById(a.f.ll_cyclelive_nickname);
        this.mWy = (TextView) this.mXl.findViewById(a.f.tv_cyclelive_nickname);
        this.mWz = (TextView) this.mXl.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mWA = (RelativeLayout) this.mXl.findViewById(a.f.rl_clear_cyclelive);
        this.mWB = (RelativeLayout) this.mXl.findViewById(a.f.rlrl_clear_cyclelive);
        this.mWC = (FrescoThumbnailView) this.mXl.findViewById(a.f.iv_clear_liveicon);
        this.mWD = (TextView) this.mXl.findViewById(a.f.tv_clear_livename);
        this.mWE = (TextView) this.mXl.findViewById(a.f.tv_clear_livedesc);
        this.mWF = (ImageView) this.mXl.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mWG = (RelativeLayout) this.mXl.findViewById(a.f.rl_clear_normal);
        this.mWF.setOnClickListener(this);
        this.mWv.setOnClickListener(this);
        this.mWz.setOnClickListener(this);
        this.mWy.setOnClickListener(this);
        this.mWs.setOnClickListener(this);
        this.mWC.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mXA.mQm != null && this.mVS != null) {
            this.mVS.a(true, this.mXA.a == null ? "" : this.mXA.a);
            this.mVS.a(this.mXA.mQm, a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mXA != null && this.mXA.mQt != null && this.mUS != null) {
            this.mVQ.a(this.mXA.mQt, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mXA != null) {
                        c.this.mXA.mQt = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dCg() {
        return this.mUU;
    }

    private void dBJ() {
        this.mXC = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mXl != null && (textView = (TextView) c.this.mXl.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mXB.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mXC.L(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mXC);
                        break;
                    case 12:
                        c.this.b(c.this.mXC);
                        break;
                    case 17:
                        c.this.dCJ();
                        break;
                    case 18:
                        c.this.cWv();
                        break;
                    case 19:
                        c.this.mXz.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mVn) {
            this.mVn = true;
            if (this.mVm == null) {
                this.mVm = this.mXl.findViewById(a.f.vs_async_show_content);
                this.mVm = ((ViewStub) this.mVm).inflate();
            }
            this.mRd = this.mXl.findViewById(a.f.ui_content);
            if (this.mSy == null) {
                this.mSy = this.mXl.findViewById(a.f.vs_async_notification_view);
                this.mSy = ((ViewStub) this.mSy).inflate();
            }
            c(this.mXl);
            k();
            cWw();
            if (this.c == null) {
                this.mQI = new d.a();
                this.c = new GestureDetector(this.mXB, this.mQI);
            }
            ((VideoPlayer) this.mXB).q();
        }
    }

    private void dBK() {
        this.mUh = (LinearLayout) this.mXl.findViewById(a.f.ll_anchor);
        this.mUi = (RelativeLayout) this.mXl.findViewById(a.f.ll_clear_anchor);
        this.mUh.setVisibility(4);
        this.mUi.setVisibility(4);
        this.mUj = (FrescoThumbnailView) this.mXl.findViewById(a.f.iv_clear_avatar);
        this.mUl = (TextView) this.mXl.findViewById(a.f.tv_clear_nickname);
        this.mUm = (TextView) this.mXl.findViewById(a.f.tv_clear_online_count);
        this.mUn = (TextView) this.mXl.findViewById(a.f.tv_clear_btn_subscribe);
        this.mUn.setOnClickListener(this);
        this.mUo = (FrescoThumbnailView) this.mXl.findViewById(a.f.iv_avatar);
        this.mUp = (TextView) this.mXl.findViewById(a.f.tv_nickname_test);
        this.mUq = (TextView) this.mXl.findViewById(a.f.tv_online_count);
        this.mRo = (TextView) this.mXl.findViewById(a.f.tv_btn_subscribe);
        this.mRo.setOnClickListener(this);
        this.mUr = (TextView) this.mXl.findViewById(a.f.tv_loyal_counts);
        this.mRr = (TextView) this.mXl.findViewById(a.f.tv_btn_contribution);
        this.mUt = (TextView) this.mXl.findViewById(a.f.tv_btn_contribution_forpk);
        this.mRr.setVisibility(4);
        this.mUt.setVisibility(8);
        this.mUu = (LinearLayout) this.mXl.findViewById(a.f.ll_mic);
        this.mUv = (PlayShowMicStatusView) this.mXl.findViewById(a.f.show_mic_status);
        this.mUw = (RecyclerView) this.mXl.findViewById(a.f.rv_loyal);
        this.mUx = (ImageView) this.mXl.findViewById(a.f.iv_clear_close);
        this.mRw = (ImageView) this.mXl.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mUw.setLayoutManager(linearLayoutManager);
        this.mVI = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mVJ, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mVJ.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mXB, (JSONObject) null, c.this.mXA.dBy().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0805a view$OnLongClickListenerC0805a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0805a view$OnLongClickListenerC0805a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0805a.Ol(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0805a.Ol(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0805a.Ol(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dOV(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mXB, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXB, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXB, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXB, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXB, a.c.color_979797), dip2px);
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
        this.mUw.setAdapter(this.mVI);
        this.mUu.setOnClickListener(this);
        this.mUj.setOnClickListener(this);
        this.mUx.setOnClickListener(this);
        this.mUo.setOnClickListener(this);
        this.mUj.setOnClickListener(this);
        this.mRw.setOnClickListener(this);
        this.mUr.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dx(View view) {
                String str = tv.chushou.common.a.dOJ() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mXA != null) {
                    str = str + c.this.mXA.dBy().mRoomID;
                }
                c.this.f(c.this.mXB.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mRr.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dx(View view) {
                String str = tv.chushou.common.a.dOJ() + "m/room-billboard/";
                if (c.this.mXA != null) {
                    str = str + c.this.mXA.dBy().mRoomID;
                }
                c.this.f(c.this.mXB.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mUt.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dx(View view) {
                String str = tv.chushou.common.a.dOJ() + "m/room-billboard/";
                if (c.this.mXA != null) {
                    str = str + c.this.mXA.dBy().mRoomID;
                }
                c.this.f(c.this.mXB.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        s(true);
    }

    public void s(boolean z) {
        boolean z2;
        if (this.mVq == null || this.mVq.cycleLiveRoomInfo == null || h.isEmpty(this.mVq.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mQQ = this.mVq.cycleLiveRoomInfo;
        }
        if (z2 && this.mQQ != null) {
            this.mWq.setVisibility(0);
            this.mWA.setVisibility(0);
            this.mWw.setVisibility(8);
            this.mWG.setVisibility(8);
            this.mWx.setVisibility(0);
            this.mWC.h(this.mQQ.eventIcon, com.kascend.chushou.view.a.a(this.mVp.mCreatorGender), b.a.small, b.a.small);
            this.mWs.h(this.mQQ.eventIcon, com.kascend.chushou.view.a.a(this.mVp.mCreatorGender), b.a.small, b.a.small);
            this.mWD.setText(this.mQQ.eventName);
            this.mWE.setText(this.mQQ.eventDesc);
            this.mWt.setText(this.mQQ.eventName);
            this.mWu.setText(this.mQQ.eventDesc);
            this.mWy.setText(this.mQQ.nickname);
            dBM();
            if (z) {
                c(this.mQQ.remainTime);
                return;
            }
            return;
        }
        this.mWq.setVisibility(8);
        this.mWA.setVisibility(8);
        this.mWw.setVisibility(0);
        this.mWG.setVisibility(0);
        this.mWx.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mWH != null) {
            this.mWH.dispose();
            this.mWH = null;
        }
        this.mWH = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dHZ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mXB != null && (c.this.mXB instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mXB).u();
                }
            }
        });
    }

    private void dBL() {
        if (this.mVp != null && this.mVn) {
            this.mUh.setVisibility(0);
            this.mUi.setVisibility(0);
            this.mRr.setVisibility(0);
            this.mUj.h(this.mVp.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVp.mCreatorGender), b.a.small, b.a.small);
            this.mUl.setText(this.mVp.mCreatorNickname);
            this.mUo.h(this.mVp.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVp.mCreatorGender), b.a.small, b.a.small);
            this.mUp.setText(this.mVp.mCreatorNickname);
            dCv();
            dBN();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dCv() {
        if (this.mVp != null) {
            this.mUm.setText(tv.chushou.zues.utils.b.formatNumber(this.mVp.mOnlineCount));
            this.mUq.setText(tv.chushou.zues.utils.b.formatNumber(this.mVp.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBM() {
        if (this.mQQ != null) {
            if (this.mQQ.isSubscribe) {
                this.mWz.setText(a.i.like_already);
                this.mWz.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mWz.setText(getString(a.i.like));
            this.mWz.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBN() {
        if (this.mVp != null) {
            if (this.mVp.mIsSubscribed) {
                this.mUn.setText(getString(a.i.like_already));
                this.mUn.setBackgroundResource(a.e.bg_show_subcribe);
                this.mRo.setText(getString(a.i.like_already));
                this.mRo.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mUn.setText(getString(a.i.like));
            this.mUn.setBackgroundResource(a.e.bg_show_subcribe);
            this.mRo.setText(getString(a.i.like));
            this.mRo.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dBO() {
        if (this.mVI != null) {
            this.mVI.notifyDataSetChanged();
        }
    }

    private void dBP() {
        this.mUz = this.mXl.findViewById(a.f.tv_interact);
        this.mUz.setOnClickListener(this);
        this.mUE = (RelativeLayout) this.mXl.findViewById(a.f.rl_edit_bar);
        this.mUC = (ImageView) this.mXl.findViewById(a.f.btn_hotword);
        this.mUC.setOnClickListener(this);
        this.mUD = (ImageView) this.mXl.findViewById(a.f.iv_task_badge);
        this.mUB = (AnimationSet) AnimationUtils.loadAnimation(this.mXB, a.C0682a.anim_hotword);
        this.mUB.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dAM().c) {
                    c.this.mUC.clearAnimation();
                    c.this.mUC.startAnimation(c.this.mUB);
                }
            }
        });
        if (com.kascend.chushou.d.h.dAM().c) {
            this.mUC.startAnimation(this.mUB);
            this.mUD.setVisibility(0);
        }
        this.mWI = (TextView) this.mXl.findViewById(a.f.tv_bottom_input);
        this.mWI.setOnClickListener(this);
        this.mYA = (FrescoThumbnailView) this.mXl.findViewById(a.f.ll_btn_set);
        this.mYA.setOnClickListener(this);
        this.mYA.xi(a.e.ic_room_set_btn_white);
        this.mUN = (LinearLayout) this.mXl.findViewById(a.f.ll_bottom_all_button);
        this.mUO = (FrescoThumbnailView) this.mXl.findViewById(a.f.fl_clear_bottom_gift);
        this.mUO.setAnim(true);
        this.mUO.setOnClickListener(this);
        this.mUO.xi(a.e.ic_show_gift_n);
        this.mUP = (FrameLayout) this.mXl.findViewById(a.f.flfl_clear_bottom_gift);
        this.mUP.setVisibility(8);
        this.mUA = (RelativeLayout) this.mXl.findViewById(a.f.rl_bottom_input);
        this.mUA.setVisibility(0);
        this.mUF = (PastedEditText) this.mXl.findViewById(a.f.et_bottom_input);
        this.mUF.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mRF.setEnabled(editable.length() > 0);
            }
        });
        this.mUF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mRF);
                    return true;
                }
                return true;
            }
        });
        this.mUF.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.mUF);
                }
                return false;
            }
        });
        this.mRO = (ImageView) this.mXl.findViewById(a.f.iv_btn_emoji);
        this.mRO.setVisibility(8);
        this.mRF = (TextView) this.mXl.findViewById(a.f.tv_btn_send);
        this.mRF.setOnClickListener(this);
        this.mUX = (LinearLayout) this.mXl.findViewById(a.f.head_trumpet);
        this.mUX.setVisibility(8);
        this.mUX.setOnClickListener(this);
        this.mUY = (TextView) this.mXl.findViewById(a.f.tv_primary_name);
        this.mUZ = (TextView) this.mXl.findViewById(a.f.tv_primary_desc);
        this.mVb = (TextView) this.mXl.findViewById(a.f.tv_cut_count);
        this.mVb.setOnClickListener(this);
        this.mVd = (TextView) this.mXl.findViewById(a.f.tv_head_count);
        this.mVd.setText(this.mVg + "");
        this.mVc = (TextView) this.mXl.findViewById(a.f.tv_plus_count);
        this.mVc.setOnClickListener(this);
        this.mSi = (TextView) this.mXl.findViewById(a.f.tv_buy_count_coin);
        this.mVa = (TextView) this.mXl.findViewById(a.f.tv_buy_head);
        this.mVa.setOnClickListener(this);
        this.mVe = (ImageView) this.mXl.findViewById(a.f.iv_trumpet_select);
        this.mVe.setOnClickListener(this);
        this.mVf = (TextView) this.mXl.findViewById(a.f.tv_trumpet_have_count);
        this.mVh = false;
        this.mVe.setBackgroundResource(a.e.ic_trumpet_n);
        this.mVf.setVisibility(8);
        this.mRN = (KPSwitchPanelLinearLayout) this.mXl.findViewById(a.f.chat_extended_container);
        dBV();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mRN, this.mRO, this.mUF, new a.InterfaceC0809a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0809a
            public void we(boolean z) {
                if (c.this.mRO != null) {
                    if (z) {
                        c.this.mRN.setDirectVisibility(0);
                        c.this.mRO.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mRO.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mRR = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wf(boolean z) {
                c.this.mRP = z;
                if (z) {
                    c.this.mRO.setImageResource(a.e.cs_emoji_normal);
                    c.this.dBR();
                    if (c.this.mWp != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mWp.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hp(c.this.mXB);
                        c.this.mWp.setLayoutParams(layoutParams);
                    }
                    if (c.this.mUE != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mUE.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hp(c.this.mXB);
                        c.this.mUE.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mWp != null && c.this.mWp.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mWp.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mWp.setLayoutParams(layoutParams3);
                    c.this.mWp.setVisibility(8);
                }
                if (c.this.mVK) {
                    c.this.mYg.setVisibility(0);
                }
                if (c.this.mXB != null && (c.this.mXB instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mXB).wd(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mUE != null && c.this.mRN.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mUE.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mUE.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mRQ = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mRN, this.mRR, ((VideoPlayer) this.mXB).dBb());
        ((VideoPlayer) this.mXB).g(((VideoPlayer) this.mXB).dBb());
        this.mWp = this.mXl.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mWm = (TextView) this.mXl.findViewById(a.f.btn_room_search);
        this.mWn = (ImageView) this.mXl.findViewById(a.f.iv_room_emoji_delete);
        this.mWo = (EditText) this.mXl.findViewById(a.f.et_room_emoji_search);
        this.mWo.setImeOptions(3);
        this.mWo.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mWm);
                    return true;
                }
                return false;
            }
        });
        this.mWo.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mWm.setEnabled(editable.length() > 0);
                c.this.mWn.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mYg.setEmojiSearchText(editable.toString());
            }
        });
        this.mWm.setOnClickListener(this);
        this.mWn.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void ar(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mWo);
            this.mWp.setVisibility(0);
            this.mWo.requestFocus();
        } else {
            this.mWp.setVisibility(8);
        }
        if (z2) {
            this.mWo.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBR() {
        int hp = tv.chushou.zues.widget.kpswitch.b.d.hp(this.mXB) + tv.chushou.zues.utils.a.dip2px(this.mXB, 14.0f);
        if (hp > this.mUb) {
            b(hp, 12);
        }
    }

    private void dBV() {
    }

    private void dBX() {
        if (this.mVj > 0) {
            View findViewById = this.mXl.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mVj);
        }
        if (this.mVi > 0) {
            View findViewById2 = this.mXl.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mVi, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mVG) {
            Q();
        }
        MN(a.e.bg_gift_animation_v);
        dCc();
        a();
        this.mQK = ((VideoPlayer) this.mXB).dAY();
        this.mQK.a(this);
        if (this.mXA.dBw() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mQK != null) {
            this.mQK.d();
        }
    }

    private void dBY() {
        if ((this.mQN == null || this.mQN.mTP == null || !this.mQN.mTP.mInPKMode) ? false : true) {
            if (this.mUc != null) {
                this.mUc.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mQP.getLayoutParams();
            layoutParams.leftMargin = (this.mVX.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mXB, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mQP.setLayoutParams(layoutParams);
            this.y.setText(this.mQN.mTP.mPkUserNickname);
            this.mQP.setVisibility(0);
            this.mUu.setVisibility(8);
            return;
        }
        if (this.mUc != null) {
            this.mUc.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mQP.setVisibility(8);
    }

    private void dBZ() {
        boolean z = false;
        if (this.mQN != null && this.mQN.mTP != null && this.mQN.mTP.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mWi > 0 && this.mVo != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVo.getLayoutParams();
                if (layoutParams.height != this.mWi) {
                    layoutParams.height = this.mWi;
                    this.mVo.setLayoutParams(layoutParams);
                }
            }
            this.mUb = ((int) (tv.chushou.zues.utils.a.he(this.mXB).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mXB, 84.0f);
            b(this.mUb, 12);
        } else {
            if (this.mVo != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVo.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mXB, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mXB, 250.0f);
                    this.mVo.setLayoutParams(layoutParams2);
                }
            }
            this.mUb = ((int) (tv.chushou.zues.utils.a.he(this.mXB).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mXB, 84.0f);
            b(this.mUb, 12);
        }
        if (this.mQO != null) {
            this.mQO.a(this.mWi + tv.chushou.zues.utils.a.dip2px(this.mXB, 52.0f), this.mXF);
        }
        if (this.mQS != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mQS.getLayoutParams();
            layoutParams3.bottomMargin = this.mWi + tv.chushou.zues.utils.a.dip2px(this.mXB, 52.0f);
            this.mQS.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dCb();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dCb();
    }

    private void dCa() {
        dBZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCb() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dCH().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mVX = tv.chushou.zues.utils.a.hf(this.mXB);
        this.mVW = 86;
        this.mVU = (Math.max(this.mVX.x, this.mVX.y) - tv.chushou.zues.utils.a.dip2px(this.mXB, (this.mVW + 52) + 250)) - this.mVi;
        this.mVV = Math.max(this.mVX.x, this.mVX.y) - ((tv.chushou.zues.utils.a.dip2px(this.mXB, this.mVW) + this.mVi) * 2);
        if (this.mVY <= 0 || this.mVZ <= 0) {
            this.mVY = Math.min(this.mVX.x, this.mVX.y);
            this.mVZ = Math.max(this.mVX.x, this.mVX.y);
        }
        this.ar = Math.min(this.mVX.x, this.mVX.y);
        this.mXF = (this.ar * this.mVZ) / this.mVY;
        boolean z = false;
        if (this.mQN == null || this.mQN.mTP == null) {
            i = 1;
        } else {
            i = this.mQN.mTP.mMode;
            if (this.mQN.mTP.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mVW = 42;
            if (i == 2) {
                if (this.mVZ < this.mVY) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mXF;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mXF;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mVY * layoutParams.height) / this.mVZ;
                    layoutParams2.height = layoutParams.height;
                    this.mXF = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mXF;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXF;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, this.mVW) + this.mVi;
            layoutParams.gravity = 48;
            this.mWi = ((this.mVX.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mXB, (this.mVW + 52) + 64) + this.mVi)) - tv.chushou.zues.utils.systemBar.b.aB(getActivity());
            dBF();
        } else if (this.E) {
            this.mVW = 42;
            if (this.mVZ < this.mVY) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mXF;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXF;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mVY * layoutParams.height) / this.mVZ;
                layoutParams2.height = layoutParams.height;
                this.mXF = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, this.mVW) + this.mVi;
            layoutParams.gravity = 48;
            this.mWi = ((this.mVX.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mXB, (this.mVW + 52) + 98) + this.mVi)) - tv.chushou.zues.utils.systemBar.b.aB(getActivity());
            dCa();
        } else {
            this.mWi = -1;
            this.mVW = 86;
            if (this.mXF <= this.mVU) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mVU;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, this.mVW) + this.mVi;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXF;
            } else if (this.mXF < this.mVV) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mXF;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, this.mVW) + this.mVi;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXF;
            } else {
                this.mXF = Math.max(this.mVX.x, this.mVX.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mXF;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mXF * this.mVY) / this.mVZ >= this.ar) {
                        i3 = this.mXF;
                        i2 = (this.mXF * this.mVY) / this.mVZ;
                    } else if ((this.ar * this.mVZ) / this.mVY >= this.mXF) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mVZ) / this.mVY;
                    } else {
                        i2 = this.ar;
                        i3 = this.mXF;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mXF) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mVZ) / this.mVY > this.mXF) {
                        i3 = this.mXF;
                        i2 = (this.mXF * this.mVY) / this.mVZ;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mVZ) / this.mVY;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mVZ) / this.mVY;
                        if (i3 > this.mXF) {
                            i3 = this.mXF;
                            i2 = (this.mXF * this.mVY) / this.mVZ;
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
        if (this.mXA != null && this.mXA.d) {
            layoutParams.width = Math.min(this.mVX.x, this.mVX.y);
            layoutParams.height = Math.max(this.mVX.x, this.mVX.y);
        }
        dCH().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dCc() {
        this.N = new SurfaceRenderView(this.mXB);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dCH().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mVP) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dCy();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dCx();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mWL != null) {
            this.mWL.a();
        }
        if (this.mXA != null && !h.isEmpty(this.mXA.mQw)) {
            b(this.mXA.mQw);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mTO != null) {
            int width = this.mTO.getWidth();
            int height = this.mTO.getHeight();
            if (this.mVY != width || this.mVZ != height || this.mVY <= 0 || this.mVZ <= 0) {
                this.mVY = width;
                this.mVZ = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dCb();
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
            t(true);
        } else if (id == a.f.fl_clear_bottom_gift) {
            if (this.mVK) {
                dCe();
            } else {
                if (this.mXB.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXA.dBw().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mVh) {
                f(this.mUF.getText().toString());
            } else {
                a(this.mUF.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dAM().c) {
                com.kascend.chushou.d.h.dAM().b(false);
                this.mUB.cancel();
                this.mUB.reset();
                this.mUC.clearAnimation();
                this.mUD.setVisibility(8);
            }
            k(view, 0, this.mXl.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mXB, 165.0f) / 2);
            j(view, x >= 0 ? x : 0, this.mXl.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mXA.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mXA.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mVo != null) {
                u(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mVp != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mVO = 1;
            wg(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mXB, (JSONObject) null, this.mXA.dBy().mRoomID, this.mXA.dBy().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        } else if (id == a.f.ftv_pack) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(8, null));
        } else if (id == a.f.view_reminder_subscribe) {
            a(false);
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            hashMap2.put("_fromPos", "73");
            b(hashMap2);
        } else if (id == a.f.view_reminder_danmaku) {
            wh(false);
            a(this.mXB.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mXB, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mVR != null) {
                    com.kascend.chushou.d.e.a(this.mXB, this.mVR, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mWl != null) {
                    this.mWl.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mXB, null) && this.mXA != null && this.mXA.mQx != null) {
                    if (this.mVh) {
                        dCF();
                    } else {
                        if (this.mXA != null && this.mXA.mQx != null && this.mXA.mQx.count > 0) {
                            this.mUX.setVisibility(8);
                        } else {
                            this.mUX.setVisibility(0);
                        }
                        this.mVh = true;
                        this.mVe.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mVf.setVisibility(0);
                        this.mVf.setSelected(true);
                        this.mVf.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mUF != null) {
                            this.mUF.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mVg <= 9) {
                    this.mVg++;
                    this.mVd.setText(this.mVg + "");
                }
                dBG();
            } else if (id == a.f.tv_cut_count) {
                if (this.mVg > 1) {
                    this.mVg--;
                    this.mVd.setText(this.mVg + "");
                }
                dBG();
            } else if (id == a.f.tv_buy_head) {
                dCE();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mWo.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mWo.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mWp.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dK(this.mWo);
                    this.mYg.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mQQ != null && !h.isEmpty(this.mQQ.eventUrl)) {
                    f("", this.mQQ.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mQQ != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mQQ != null) {
                    com.kascend.chushou.d.a.a(this.mXB, (JSONObject) null, this.mQQ.roomId, this.mQQ.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mXA.a(false);
                    ((VideoPlayer) this.mXB).l();
                } else {
                    ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.mUW != null) {
            int i = (tv.chushou.zues.utils.a.he(this.mXB).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUW.getLayoutParams();
            layoutParams.topMargin = i;
            this.mUW.setLayoutParams(layoutParams);
            this.mUW.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mUW.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            Toast.makeText(this.mXB, a.i.str_same_content, 0).show();
            return false;
        } else if (System.currentTimeMillis() - this.mVN <= 3000) {
            Toast.makeText(this.mXB, a.i.str_too_fast, 0).show();
            return false;
        } else {
            cWC();
            if (!com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a(((VideoPlayer) this.mXB).dAX().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mVN = System.currentTimeMillis();
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                a(this.mXA.dBw().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mXA.h);
            }
            g(this.b);
            if (!z && this.mUF != null) {
                this.mUF.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            cWC();
            if (com.kascend.chushou.d.e.c(this.mXB, null) && LoginManager.Instance().getUserInfo() != null && this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                a(this.mXA.dBw().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mUF != null) {
                this.mUF.setText((CharSequence) null);
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
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mXA.dBw().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mXA.dBw().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mXB).mOJ;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.SH(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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

    private void j(View view, int i, int i2) {
        if (this.mYa != null && this.mYa.isShowing()) {
            this.mYa.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
        if (this.mYx == null) {
            i(3);
        }
        this.mYx.getContentView().setBackgroundResource(0);
        this.mYx.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mYx.isShowing()) {
            this.mYx.showAtLocation(view, 83, i, i2);
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mXA.dBw().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mYx.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dBW() {
        if (h.isEmpty(this.mYB)) {
            if (((VideoPlayer) this.mXB).q) {
                this.mYA.xi(a.e.ic_room_set_btn_white);
            } else {
                this.mYA.xi(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mXB).q && this.mYB.size() == 2 && this.mYB.contains("4") && this.mYB.contains("2")) {
            this.mYA.xi(a.e.ic_room_set_btn_system_white);
        } else if (this.mYB.size() > 1 || !((VideoPlayer) this.mXB).q) {
            this.mYA.xi(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mYB.get(0))) {
            this.mYA.xi(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mYB.get(0))) {
            this.mYA.xi(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mYB.get(0))) {
            this.mYA.xi(a.e.ic_room_set_btn_system_white);
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
        if (this.mYa == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mYa.getContentView().setBackgroundResource(0);
            this.mYa.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mUC.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mYa.isShowing()) {
            this.mYa.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mXB, 16.0f) + i2);
            this.mUC.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mXA.dBw().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYa.dismiss();
    }

    private void dz(View view) {
        if (this.mXU == null) {
            dCh();
        }
        if (com.kascend.chushou.d.h.dAM().q()) {
            this.mUG.dOT();
        } else {
            this.mUG.dOU();
        }
        int height = this.mXl.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        if (view != null) {
            this.mXU.showAtLocation(view, 85, 0, height);
        }
    }

    private void dCh() {
        if (this.mXU == null) {
            View inflate = LayoutInflater.from(this.mXB).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mUG = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dAM().q()) {
                this.mUG.dOT();
            } else {
                this.mUG.dOU();
            }
            this.mUG.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dAM().g(z);
                }
            });
            this.mXO = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mXP = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mXO.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mXO.setVisibility(0);
            } else {
                this.mXO.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dAM().a) {
                this.mXP.b();
            } else {
                this.mXP.c();
            }
            if (this.mXA != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mXA.f;
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
                                if (this.mQN == null || !this.mQN.mTP.mInPKMode || h.isEmpty(this.mQN.b) || this.mVp == null || !this.mQN.b.equals(this.mVp.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mXB).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dBx = this.mXA.dBx();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mXB).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXB, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, 5.0f);
                                            }
                                            int identifier = this.mXB.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mXB.getPackageName());
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
                                                if (dBx != null && dBx.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mXB.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mXB).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dBx2 = this.mXA.dBx();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mXB).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXB, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, 5.0f);
                                        }
                                        int identifier2 = this.mXB.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mXB.getPackageName());
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
                                            if (dBx2 != null && dBx2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dCi();
                        c.this.mXU.dismiss();
                    }
                }
            });
            this.mXU = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 150.0f), -2);
            this.mXU.setFocusable(true);
            this.mXU.setOutsideTouchable(true);
            this.mXU.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mXU.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mXU = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCi() {
        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
            if (this.mUV == null) {
                this.mUV = new f(getActivity());
            }
            this.mUV.a(this.mXA.dBw().mRoominfo, this.ax);
            if (!this.mUV.isShowing()) {
                this.mUV.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mVP) {
            return false;
        }
        if (this.mVO == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mWJ = motionEvent.getX();
                    this.mWK = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mWJ;
                    if (Math.abs(f) > Math.abs(y - this.mWK) && Math.abs(f) > q && f > 0.0f) {
                        dCA();
                        return true;
                    }
                    this.mWJ = 0.0f;
                    this.mWK = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mWp != null && this.mWp.getVisibility() == 0 && b(motionEvent, this.mWp)) {
                this.mWp.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.mWo);
                return true;
            } else if (this.mVK && this.mWp != null && this.mWp.getVisibility() == 8 && g(this.mYg.b, motionEvent)) {
                dCe();
                return true;
            } else if (this.mUW != null && this.mUW.b() && g(this.mUW, motionEvent)) {
                this.mUW.a();
                return true;
            } else if (this.mUM != null && this.mUM.b() && g(this.mUM, motionEvent)) {
                this.mUM.a();
                return true;
            } else if (b(motionEvent, this.mUE)) {
                return cWC();
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
            if (this.mYr != null && this.mYr.a(i, keyEvent)) {
                return true;
            }
            if ((this.mUW != null && this.mUW.onKeyDown(i, keyEvent)) || dBS()) {
                return true;
            }
            if (this.mVO == 3) {
                this.mVO = 1;
                dCA();
                return true;
            } else if (this.mUM != null && this.mUM.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mUF != null && this.mUA != null && this.mUE != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mUF);
                this.mUA.setVisibility(8);
                this.mUE.setVisibility(0);
            }
        } else if (this.mUA != null && this.mUE != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
            this.mUA.setVisibility(0);
            this.mUE.setVisibility(8);
        }
    }

    public boolean cWC() {
        boolean z;
        b(this.mUb, 12);
        boolean z2 = false;
        if (this.mRN != null && this.mRN.getVisibility() == 0) {
            this.mRN.setVisibility(8);
            this.mRO.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mRP) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXB);
            this.mRO.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mUE == null || this.mUE.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mVh) {
                dCF();
            }
            this.mUE.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mUA != null) {
                    c.this.mUA.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dBS() {
        if (cWC()) {
            return true;
        }
        if (this.mYa != null && this.mYa.isShowing()) {
            this.mYa.dismiss();
            return true;
        } else if (this.mYx != null && this.mYx.isShowing()) {
            this.mYx.dismiss();
            return true;
        } else if (this.mXU == null || !this.mXU.isShowing()) {
            return dCe() || dBU() || dCd() || dBT();
        } else {
            this.mXU.dismiss();
            return true;
        }
    }

    public boolean dBT() {
        if (this.mYk == null || !this.mYk.isShown()) {
            return false;
        }
        this.mYk.d();
        return true;
    }

    public boolean dBU() {
        if (this.mVM == null || !this.mVM.isShown()) {
            return false;
        }
        this.mVM.a();
        return true;
    }

    public boolean dCd() {
        if (this.mUW == null || !this.mUW.b()) {
            return false;
        }
        this.mUW.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mXB != null && !((Activity) this.mXB).isFinishing() && pVar != null) {
            this.mVx = pVar.a;
            u(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dCG() && this.mVp != null && mVar.a(this.mVp.mCreatorUID, null)) {
            this.mVp.mIsSubscribed = mVar.c;
            dBN();
        }
    }

    public boolean dCe() {
        if (!this.mVK || this.mYg == null) {
            return false;
        }
        if (this.mYg != null) {
            this.mYg.e();
        }
        if (this.mWo != null) {
            this.mWo.setText("");
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
        if (!dCG() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mVT != null) {
                        this.mVT.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                        this.mXA.dBw().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mXA.dBw().mMicStatus.onMic) {
                            if (this.mUu != null) {
                                this.mUu.setVisibility(8);
                            }
                            if (this.mVM != null && this.mVM.isShown()) {
                                this.mVM.a();
                            }
                            if (this.E) {
                                this.E = false;
                                u();
                                b(false);
                                if (getActivity() instanceof VideoPlayer) {
                                    ((VideoPlayer) getActivity()).a(true);
                                }
                            }
                        }
                        if (this.mXA.dBw().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mVp != null && !h.isEmpty(this.mVp.mCreatorUID)) {
                                i(arrayList2, this.mVp.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).a(!this.F);
                            }
                        } else if (this.mXA.dBw().mMicStatus.onMic) {
                            if (this.mXA.dBw().mMicStatus != null && !h.isEmpty(this.mXA.dBw().mMicStatus.micRoomId) && !this.mXA.dBw().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mXA.dBw().mMicStatus.micRoomId;
                            }
                            this.mXA.dBw().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mXA.dBw().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = j(this.mXA.dBw().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mXA.dBw().mMicStatus, str3, z4);
                            if (this.mVM != null && this.mVM.getVisibility() == 0) {
                                this.mVM.a(this.mXA.dBw().mFanItems, this.mXA.dBw().mMicStatus, str3, z4, this.mXA.dBw().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mUu != null) {
                                this.mUu.setVisibility(8);
                            }
                            if (this.mVM != null && this.mVM.isShown()) {
                                this.mVM.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mVl != onlineVip.mCount || (this.mUr != null && this.mUr.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mVl = onlineVip.mCount;
                        this.mUs = onlineVip.mCount;
                        dCm();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mVJ.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mVJ.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mVJ.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mWf <= 5000) {
                                z2 = false;
                            } else {
                                this.mWf = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mVJ.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mVJ.addAll(onlineVip.mOnlineVipItems);
                            }
                            dBO();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mWg != null) {
                    if (this.mVp == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mVp.mCreatorAvatar;
                        str2 = this.mVp.mCreatorGender;
                    }
                    this.mWg.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mQN != null && this.mQN.mTP != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mQN.mTP.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mQK != null) {
                                        this.mQK.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mQN.mTP.mInPKMode = true;
                                    this.mQN.mTP.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQN.mTP.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQN.mTP.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQN.mTP.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQN.mTP.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQN.mTP.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mQN.mTP.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mQN.mTP.mMode = pkNotifyInfo.mMode;
                                    this.mQN.mTP.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mQO != null) {
                                        this.mQO.g(true, this.mQN.mTP.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dAM().a) {
                                        if (!com.kascend.chushou.b.dAF().e) {
                                            com.kascend.chushou.b.dAF().e = true;
                                            tv.chushou.zues.utils.g.M(this.mXB, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dAM().a(this.mXB, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mQN.mTP.mAction = 7;
                                    this.mQN.mTP.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQN.mTP.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQN.mTP.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQN.mTP.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQN.mTP.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQN.mTP.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mQN.mTP.mMode == 2) {
                                        dCb();
                                    } else {
                                        dBF();
                                    }
                                    if (this.mQO != null) {
                                        this.mQO.g(false, 0L);
                                        this.mQO.b(this.mQN.mTP, true);
                                        this.mQO.a(this.mWi + tv.chushou.zues.utils.a.dip2px(this.mXB, 52.0f), this.mXF);
                                        this.mQO.a(this.mQN.mTP.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mQK != null) {
                                        this.mQK.a(false);
                                    }
                                    this.mQN.mTP.mInPKMode = false;
                                    this.mQN.mTP.mAction = 2;
                                    dBF();
                                    dCb();
                                    if (this.mQO != null) {
                                        this.mQO.c();
                                    }
                                    this.mQN.b = null;
                                    this.mQN.mTP = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mQN.mTP.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mQN.mTP.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mQN.mTP.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mVp != null && !h.isEmpty(this.mVp.mRoomID) && this.mVp.mRoomID.equals(this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mQN.mTP.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mQO != null) {
                                        this.mQO.a(this.mQN.mTP, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mQN.mTP.copyUpdate(pkNotifyInfo);
                                    if (this.mQO != null) {
                                        this.mQO.a(this.mQN.mTP);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mQN.mTP.copyStop(pkNotifyInfo);
                                        if (this.mQO != null) {
                                            this.mQO.w(this.mQN.mTP.mMaxFreeDuration, this.mQN.mTP.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mQN.mTP.copyResult(pkNotifyInfo);
                                    if (!this.mVH && this.mQO != null) {
                                        int i7 = 1;
                                        if (this.mQN.mTP.destinyInfo != null && this.mQN.mTP.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mQO.a(h.parseInt(this.mQN.mTP.mResult), h.parseLong(this.mQN.mTP.mvpUid), this.mQN.mTP.mvpAvatar, this.mQN.mTP.mvpNickname, this.mQN.mTP.mMaxFreeDuration, this.mQN.mTP.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mQQ != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mQQ.uid = cycleLiveRoomInfo.uid;
                        this.mQQ.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mQQ.roomId = cycleLiveRoomInfo.roomId;
                        this.mQQ.avatar = cycleLiveRoomInfo.avatar;
                        this.mQQ.nickname = cycleLiveRoomInfo.nickname;
                        s(false);
                        if (this.mXB != null && (this.mXB instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mXB).d();
                        }
                    } else {
                        ((VideoPlayer) this.mXB).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mXA != null && this.mXA.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dAM().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dAM().b().equals(next2.mUserID)) {
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

    public void dCm() {
        if (this.mUr != null) {
            if (this.mQN == null || this.mQN.mTP == null || !this.mQN.mTP.mInPKMode) {
                if (this.mUs > 0) {
                    this.mUr.setVisibility(0);
                    this.mUr.setText(String.format(this.mXB.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mUs))));
                    this.mUw.setVisibility(0);
                    return;
                }
                this.mUr.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mUu.setVisibility(0);
            if (this.mUv != null) {
                this.mUv.a(str, z, micStatus, this.mXA.dBw().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mUu.setVisibility(8);
    }

    private boolean j(ArrayList<FanItem> arrayList, String str) {
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
    public void dCj() {
        int childCount = this.mVr.getChildCount();
        int itemCount = this.mVr.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mVr);
        if (f + childCount >= itemCount) {
            this.mVy = true;
            if (this.mVz != null) {
                this.mVz.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                u(true);
            }
        }
    }

    public void dCs() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mVs.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mVs.add(1, chatInfo2);
    }

    private void u(boolean z) {
        if (this.mVs == null) {
            this.mVs = new ArrayList<>();
        }
        while (2 < this.mVs.size()) {
            this.mVs.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mVu);
        if (a2 == null) {
            v(false);
            return;
        }
        this.mVs.addAll(a2);
        int size = this.mVs.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mVs.size(); i++) {
                this.mVs.remove(2);
            }
        }
        v(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mVv == null) {
            this.mVv = new ArrayList<>();
        }
        this.mVv.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mVx != null && this.mVx.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mVx.contains("2"))) {
                        this.mVv.add(next);
                    } else if (!this.mVx.contains(next.mType)) {
                        this.mVv.add(next);
                    }
                }
                return this.mVv;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mVs == null) {
                    this.mVs = new ArrayList<>(arrayList);
                    dCs();
                    v(z2);
                    return;
                }
                if (this.mVu == null) {
                    this.mVu = new ArrayList<>();
                }
                this.mVu.addAll(arrayList);
                int size = this.mVu.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mVu.size(); i++) {
                        this.mVu.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mVs.size();
                if (a2 != null) {
                    this.mVs.addAll(a2);
                }
                int size3 = this.mVs.size();
                if (!this.mVy && this.mVz != null) {
                    this.mVz.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mVs.size(); i3++) {
                        this.mVs.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mVs == null) {
                this.mVs = new ArrayList<>(arrayList);
                dCs();
            } else {
                if (this.mVu == null) {
                    this.mVu = new ArrayList<>();
                }
                this.mVu.clear();
                this.mVu.addAll(arrayList);
                this.mVs.clear();
                dCs();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mVs.addAll(a3);
                }
            }
            v(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mVw != null) {
                this.mVw.a(this.mVs.size());
                if (i == 1) {
                    this.mVw.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mVw.notifyItemRangeRemoved(i2, i3);
                    this.mVw.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mVw.notifyDataSetChanged();
                }
            }
            if (z || this.mVy) {
                this.mVy = true;
                if (this.mVz != null) {
                    this.mVz.setVisibility(8);
                }
                if (z) {
                    this.mVo.scrollToPosition(this.mVs.size() - 1);
                } else {
                    this.mVo.smoothScrollToPosition(this.mVs.size() - 1);
                }
            }
        }
    }

    private void v(boolean z) {
        if (!this.ah) {
            if (this.mVw != null) {
                this.mVw.a(this.mVs.size());
                this.mVw.notifyDataSetChanged();
            }
            if (z || this.mVy) {
                this.mVy = true;
                if (this.mVz != null) {
                    this.mVz.setVisibility(8);
                }
                if (z) {
                    this.mVo.scrollToPosition(this.mVs.size() - 1);
                } else {
                    this.mVo.smoothScrollToPosition(this.mVs.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dBh;
        RoomToast roomToast;
        this.p = false;
        if (this.mXA != null && this.mXA.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mXA.f.size()) {
                    break;
                } else if (!"2".equals(this.mXA.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dCw();
            return;
        }
        if (this.mRd != null) {
            this.mRd.setVisibility(0);
        }
        if (this.mUg != null) {
            this.mUg.setVisibility(0);
        }
        if (this.mXA != null) {
            this.mVp = this.mXA.dBy();
            this.mVq = this.mXA.dBw();
            if (com.kascend.chushou.b.dAF().c != null && this.mVw != null) {
                this.mVw.a(com.kascend.chushou.b.dAF().c);
                this.mVw.notifyDataSetChanged();
            }
            FullRoomInfo dBw = this.mXA.dBw();
            if (dBw != null) {
                if (!h.isEmpty(dBw.mRoomToastList)) {
                    Iterator<RoomToast> it = dBw.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dAM().j())) {
                    a(roomToast);
                }
            }
            if (this.mVp != null) {
                dCB();
            }
            if (this.mVp != null && !this.mVp.mIsSubscribed) {
                RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mVp == null || !c.this.mVp.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mXA != null && this.mXA.l()) {
                d(true);
            }
        }
        if (this.mVp != null && this.mVw != null) {
            if (this.mVs != null) {
                this.mVs.clear();
            } else {
                this.mVs = new ArrayList<>();
            }
            this.mVw.a(this.mVp);
            dCs();
            this.mVw.a(this.mVs.size());
            this.mVw.notifyDataSetChanged();
        }
        dBL();
        N();
        if (this.mXB != null && (this.mXB instanceof VideoPlayer) && (dBh = ((VideoPlayer) this.mXB).dBh()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dBh.mTP, dBh.b);
        }
        this.mUJ.h(this.mVp.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVp.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mUN);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dCk() {
        if (this.mVk == null) {
            View inflate = LayoutInflater.from(this.mXB).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mSv = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mVk = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXB, 160.0f), -2);
            this.mVk.setFocusable(false);
            this.mVk.setOutsideTouchable(false);
            this.mVk.setAnimationStyle(a.j.gift_toast_style);
            this.mVk.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dAM().c(roomToast.mToastContent);
            if (this.mVk == null) {
                dCk();
            }
            if (this.mSv != null) {
                this.mSv.setText(roomToast.mToastContent);
            }
            if (!this.mVk.isShowing()) {
                if (this.mUN != null) {
                    this.mVk.showAtLocation(this.mUN, 85, 0, this.mXl.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
                    RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mVk != null) {
                                c.this.mVk.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mVk.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mWb != null) {
            this.mWb.setVisibility(z ? 0 : 8);
        }
        this.mWc = true;
        if (this.mXB instanceof VideoPlayer) {
            ((VideoPlayer) this.mXB).p();
        }
    }

    private void dCw() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mXB).s();
        dBT();
        dBU();
        if (this.mUy == null) {
            this.mUy = (PlayShowRecommendView) ((ViewStub) this.mXl.findViewById(a.f.view_recommend)).inflate();
        }
        this.mUy.setVisibility(0);
        if (this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null && !h.isEmpty(this.mXA.dBw().mRoominfo.mRoomID)) {
            dCn();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYg != null) {
            this.mYg.e();
        }
        if (this.mRd != null) {
            this.mRd.setVisibility(4);
        }
        if (this.mUg != null) {
            this.mUg.setVisibility(8);
        }
        if (this.mYo != null) {
            this.mYo.dOp();
            this.mYo.setVisibility(8);
        }
        wk(false);
        a(false, false);
        if (this.mQK != null) {
            this.mQK.a();
        }
    }

    private void dCn() {
        if (this.mUy != null && this.mUy.getVisibility() == 0) {
            this.mUy.a(this.mXA.dBw().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void nO() {
        super.nO();
        if (this.mXB instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mUW != null && this.mUW.b()) {
            this.mUW.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mVL);
        if (this.mXB != null) {
            if (this.mVL || "10004".equals(((VideoPlayer) this.mXB).t)) {
                this.mVL = true;
                if (this.mXA != null) {
                    this.mXA.f = null;
                    if (this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                        this.mXA.dBw().mRoominfo.mGameId = null;
                    }
                }
                dCw();
                return;
            }
            this.mVL = true;
            if (this.mXB != null) {
                ((VideoPlayer) this.mXB).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mVL = false;
        if (this.mRd != null) {
            this.mRd.setVisibility(0);
        }
        if (this.mUg != null) {
            this.mUg.setVisibility(0);
        }
        if (this.mUy != null) {
            this.mUy.setVisibility(8);
        }
        if (this.mXv != null) {
            this.mXv.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mVL = false;
        if (this.mRd != null) {
            this.mRd.setVisibility(0);
        }
        if (this.mUg != null) {
            this.mUg.setVisibility(0);
        }
        if (this.mUy != null) {
            this.mUy.setVisibility(8);
        }
        if (this.mXv != null) {
            this.mXv.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mUy != null) {
            this.mUy.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dCG()) {
            if (i()) {
                if (i == 404) {
                    if (this.mXA != null) {
                        this.mXA.f = null;
                        this.mXA.dBw().mRoominfo.mGameId = null;
                    }
                    dCw();
                    return;
                }
                Toast.makeText(this.mXB, a.i.str_getvideosource_failed, 0).show();
            }
            wk(false);
            n(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mXA != null && this.mXA.dBx() != null) {
            a(this.mXA.dBx());
        }
        this.p = false;
        if (this.mXA == null || this.mXA.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mXA.f.size()) {
                if (!"2".equals(this.mXA.f.get(i2).mType)) {
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
    public GiftAnimationLayout dBQ() {
        if (this.mXl == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXl.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mUN != null) {
            int size = iconConfig.configs.size();
            this.mUN.removeAllViews();
            if (this.mUP != null) {
                this.mUP.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mXB).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mUN, false);
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
                        if (configDetail.mTargetKey.equals("gift")) {
                            this.mUP.setVisibility(0);
                            this.mUO.bV(configDetail.mCover, a.e.ic_show_gift_n);
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
                    public void dx(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.mUN.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mXB instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dBc = ((VideoPlayer) this.mXB).dBc();
            if (this.mYr == null) {
                this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYr.setVisibility(0);
            this.mYr.a(2, dBc);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mUR != null && this.mXB != null) {
            this.mUR.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mUR != null && this.mXB != null) {
            this.mUR.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mUR != null) {
            this.mUR.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mUR != null) {
            this.mUR.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mUQ != null) {
            if (this.mXB != null) {
                this.mUQ.a(((VideoPlayer) this.mXB).dBc(), false);
            }
            this.mUQ.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mXl != null) {
            Point he = tv.chushou.zues.utils.a.he(this.mXB);
            int i = he.x > he.y ? 1 : 2;
            if (this.mYr == null) {
                this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYr.setPlayerViewHelper(this.mXA);
            this.mYr.setVisibility(0);
            this.mYr.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mUS != null) {
            this.mUS.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mUS != null) {
            this.mUS.a(bangInfo, str);
        }
        if (this.mRr != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mRr.setText(this.mXB.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mRr.setText(this.mXB.getString(a.i.str_contribute_tittle));
            } else {
                this.mRr.setText(Html.fromHtml(this.mXB.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mUt != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mUt.setText(this.mXB.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mUt.setText(this.mXB.getString(a.i.str_contribute_tittle));
            } else {
                this.mUt.setText(Html.fromHtml(this.mXB.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mUS != null) {
            this.mUS.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mXA != null && !h.isEmpty(this.mXA.mQv)) {
            this.mVR = this.mXA.mQv.get(0);
            if (this.mWj != null) {
                this.mWj.setVisibility(0);
                this.mWj.a(this.mVR.mCover, 0, 0, 0, 1);
                if (this.mWk != null) {
                    if (this.mVR.mShowClose) {
                        this.mWk.setVisibility(0);
                    } else {
                        this.mWk.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mUS != null) {
            this.mUS.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXl != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mRN != null) {
            this.mRN.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dCG() && !this.mVH) {
            if (iVar.a == 52) {
                if (this.mVw != null) {
                    this.mVw.a(com.kascend.chushou.b.dAF().c);
                    this.mVw.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mVH && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dCG()) {
                    c.this.t(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mUF != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mUF);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dCG() && !this.mVH) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mXB, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dBd = ((VideoPlayer) this.mXB).dBd();
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(2, dBd);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dBe = ((VideoPlayer) this.mXB).dBe();
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(2, dBe);
            } else if (bVar.a == 8) {
                if (this.mVT != null && this.mVT.getVisibility() != 0) {
                    this.mVT.a(a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, this.mVp == null ? "" : this.mVp.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mYr == null) {
                    this.mYr = (H5Container) ((ViewStub) this.mXl.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYr.setVisibility(0);
                this.mYr.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dCG() && this.mXA != null && !h.isEmpty(this.mXA.a) && this.mXA.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mVT != null && this.mVT.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mXB, 80.0f);
                }
                if (this.mVS != null && this.mVS.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mVS.getHeight());
                }
                this.mWe.setTranslationY(-r0);
                return;
            }
            if (this.mWd != null) {
                this.mWd.cancel();
                this.mWd = null;
            }
            int translationY = (int) this.mWe.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mXB, 80.0f) : 0;
                    if (this.mVS != null && this.mVS.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mVS.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mVS.getHeight() : 0;
                    if (this.mVT != null && this.mVT.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mXB, 80.0f));
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
        this.mWd = ValueAnimator.ofInt(i, i2);
        this.mWd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dCG() && c.this.mUS != null) {
                    c.this.mWe.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mWd.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mWd = null;
            }
        });
        this.mWd.setInterpolator(new LinearInterpolator());
        this.mWd.setDuration(800L);
        this.mWd.start();
    }

    private boolean dCx() {
        if (this.mVO == 1) {
            this.mVO = 2;
            wg(true);
            return true;
        } else if (this.mVO == 3) {
            dCA();
            return true;
        } else {
            return false;
        }
    }

    private boolean dCy() {
        if (this.mVO == 1) {
            return dCz();
        }
        if (this.mVO == 2) {
            this.mVO = 1;
            wg(false);
            return true;
        }
        return false;
    }

    private boolean dCz() {
        if (this.mVP || this.mXA == null || this.mXA.dBy() == null) {
            return false;
        }
        if (this.mWL != null) {
            this.mWL.a(true);
        }
        this.mVO = 3;
        this.mVP = true;
        dCB();
        this.mUd.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.mVP = false;
                c.this.mUf.setVisibility(8);
            }
        });
        this.mUf.startAnimation(loadAnimation);
        this.mUd.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCA() {
        if (!this.mVP) {
            if (this.mWL != null) {
                this.mWL.a(false);
            }
            this.mVO = 1;
            this.mVP = true;
            dCB();
            this.mUf.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.mVP = false;
                    c.this.mUd.setVisibility(8);
                }
            });
            this.mUf.startAnimation(loadAnimation);
            this.mUd.startAnimation(loadAnimation2);
        }
    }

    private void dCB() {
        if (this.mXl != null) {
            if (this.mUd == null) {
                this.mUd = this.mXl.findViewById(a.f.user_space_container);
            }
            if (this.mUf == null) {
                this.mUf = this.mXl.findViewById(a.f.video_container);
            }
            if (this.mUe == null) {
                this.mUe = com.kascend.chushou.view.user.b.b(null, this.mXA.a, false, this.mXA.h);
                this.mUe.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dCA();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dCA();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mUe).commitAllowingStateLoss();
            }
        }
    }

    private void wg(boolean z) {
        Animation loadAnimation;
        if (this.mUg != null) {
            this.mUg.setVisibility(z ? 8 : 0);
        }
        if (this.mVm != null) {
            this.mVP = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mVm.setVisibility(8);
                        c.this.mVP = false;
                    }
                });
            } else {
                this.mVP = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mVm.setVisibility(0);
                        c.this.mVP = false;
                    }
                });
            }
            this.mVm.startAnimation(loadAnimation);
        }
        dBS();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mUz.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mUH != null) {
                this.mUH.setVisibility(0);
            }
            if (this.mUI != null) {
                this.mUI.a();
                return;
            }
            return;
        }
        if (this.mUK != null) {
            this.mUK.setVisibility(0);
        }
        if (this.mUL != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mUL.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mUK != null) {
            this.mUK.setVisibility(8);
        }
        if (this.mUL != null) {
            this.mUL.clearAnimation();
        }
        if (this.mUH != null) {
            this.mUH.setVisibility(8);
        }
        if (this.mUI != null) {
            this.mUI.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mVm != null && this.mXl != null) {
            if (this.mVT == null) {
                this.mVT = new com.kascend.chushou.player.ui.miniview.a(this.mXB, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mVT != null && c.this.mXl != null && c.this.mVT.a()) {
                            ((ViewGroup) c.this.mXl).removeView(c.this.mVT);
                            c.this.mVT = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVT.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mXB, 52.0f);
                this.mVT.setLayoutParams(layoutParams);
                ((ViewGroup) this.mVm).addView(this.mVT, ((ViewGroup) this.mVm).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mVT.setVisibility(8);
                } else {
                    this.mVT.a(a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, this.mXA.a == null ? "" : this.mXA.a);
                }
            } else if (!this.mVT.isShown()) {
                this.mVT.a(a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, this.mXA.a == null ? "" : this.mXA.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mWa != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mWa.setVisibility(0);
                this.mWa.setAnim(true);
                this.mWa.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nXp, b.C0808b.nXq, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mVA != null && this.mVA.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dCC();
                    }
                });
                this.mVA.setVisibility(0);
                this.mVA.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mVA != null && this.mVA.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mVC != null) {
                        c.this.mVC.removeAllListeners();
                        c.this.mVC.cancel();
                        c.this.mVC = null;
                    }
                    if (c.this.mVA != null) {
                        c.this.mVA.setVisibility(8);
                    }
                }
            });
            this.mVA.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mWh == null) {
                this.mWh = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dCG()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mXB, "显示双击666_num", null, new Object[0]);
                            if (c.this.mXA != null) {
                                c.this.mXA.b(false);
                            }
                            c.this.d(false);
                            c.this.wh(true);
                        }
                    }
                };
                if (this.mXC != null) {
                    this.mXC.d(this.mWh, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mWh != null) {
            this.mXC.removeCallbacks(this.mWh);
            this.mWh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mVD != null && this.mVD.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mXB, a.C0682a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dCD();
                    }
                });
                this.mVD.setVisibility(0);
                this.mVD.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXk, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.wh(false);
                    }
                });
            }
        } else if (this.mVD != null && this.mVD.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXB, a.C0682a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mVF != null) {
                        c.this.mVF.removeAllListeners();
                        c.this.mVF.cancel();
                        c.this.mVF = null;
                    }
                    if (c.this.mVD != null) {
                        c.this.mVD.setVisibility(8);
                    }
                }
            });
            this.mVD.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dCC() {
        if (this.mVA == null || this.mVB == null) {
            return null;
        }
        if (this.mVC != null) {
            this.mVC.removeAllListeners();
            this.mVC.cancel();
            this.mVC = null;
        }
        this.mVB.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mVB, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mVB, 0.0f);
        int measuredWidth = (this.mVA.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mXB, 13.0f) * 2)) - this.mVB.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mVB, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mVB, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mVB, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mVC != null) {
                    c.this.mVC.removeAllListeners();
                    c.this.mVC.cancel();
                    c.this.mVC = null;
                }
                RxExecutor.postDelayed(c.this.mXk, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dCC();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mVC = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dCD() {
        if (this.mVD == null || this.mVE == null) {
            return null;
        }
        if (this.mVF != null) {
            this.mVF.removeAllListeners();
            this.mVF.cancel();
            this.mVF = null;
        }
        this.mVE.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mVE, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mVE, 0.0f);
        int measuredWidth = (this.mVD.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mXB, 13.0f) * 2)) - this.mVE.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mVE, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mVE, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mVE, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mVF != null) {
                    c.this.mVF.removeAllListeners();
                    c.this.mVF.cancel();
                    c.this.mVF = null;
                }
                RxExecutor.postDelayed(c.this.mXk, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dCD();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mVF = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mWL = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mQQ != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mQQ.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dCG()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Oj(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Oj(a.i.subscribe_success);
                            }
                            if (c.this.mQQ != null) {
                                c.this.mQQ.isSubscribe = !z;
                                c.this.dBM();
                                return;
                            }
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dCG()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dAI().a(bVar, (String) null, this.mQQ.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mQQ.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dAI().b(bVar, (String) null, c.this.mQQ.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mXA != null && this.mVp != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mXA.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mXA.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mVp.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dCG()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Oj(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Oj(a.i.subscribe_success);
                            }
                            c.this.mVp.mIsSubscribed = !z;
                            c.this.dBN();
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dCG()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dAI().a(bVar, (String) null, this.mVp.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mVp.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dAI().b(bVar, (String) null, c.this.mVp.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mTO != null) {
            int width = this.mTO.getWidth();
            int height = this.mTO.getHeight();
            if (this.mVY != width || this.mVZ != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXl != null) {
            if (this.mUM == null) {
                this.mUM = (InteractionView) ((ViewStub) this.mXl.findViewById(a.f.view_interaction)).inflate();
                this.mUM.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mUM.a();
                    }
                });
            }
            if (this.mUM != null) {
                this.mUM.b(configDetail);
                this.mUM.c();
                this.mUM.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dPa()) {
                tv.chushou.zues.utils.g.M(this.mXB, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mXB, null) && (this.mXB instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXA != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXB, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mXB, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXA != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXB, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mXB, configDetail.mUrl, this.mXB.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
            if (com.kascend.chushou.d.e.c(this.mXB, null)) {
                if (!configDetail.mTargetKey.equals("pay")) {
                    if (configDetail.mTargetKey.equals("gift")) {
                        if (this.mVK) {
                            dCe();
                            return;
                        }
                        if (this.mXB.getResources().getDisplayMetrics().density < 2.0f) {
                            b(true, false);
                        } else {
                            b(true, true);
                        }
                        com.kascend.chushou.toolkit.a.c.a(this.mXB, "点击送礼_num", "竖屏", new Object[0]);
                        if (this.mXA != null && this.mXA.dBw() != null && this.mXA.dBw().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXA.dBw().mRoominfo.mRoomID);
                            return;
                        }
                        return;
                    } else if (configDetail.mTargetKey.equals("interaction")) {
                        a(configDetail);
                        return;
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals("more")) {
                            dz(this.mUN);
                            return;
                        } else {
                            Toast.makeText(this.mXB, a.i.str_getnewversion, 0).show();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                b(com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "34"));
            }
        } else {
            Toast.makeText(this.mXB, a.i.str_getnewversion, 0).show();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mXB != null && !this.v && !h.isEmpty(str) && this.mVp != null && str.equals(this.mVp.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mQN == null) {
                this.mQN = new com.kascend.chushou.player.e.a();
            }
            this.mQN.b = str;
            this.mQN.mTP.copy(pkNotifyInfo);
            if (this.mQN.mTP.mAction == 6) {
                if (this.mQK != null) {
                    this.mQK.a(true);
                }
                this.mQN.mTP.mInPKMode = true;
                this.u = this.mQN.mTP.mPkId;
            } else if (this.mQN.mTP.mAction == 7 || (this.mQN.mTP.mMode == 1 && this.mQN.mTP.mAction == 5)) {
                if (this.mQK != null) {
                    this.mQK.a(true);
                }
                this.mQN.mTP.mInPKMode = true;
                if (this.mVW != 42) {
                    this.mWi = ((this.mVX.y - ((this.mVX.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mXB, 158.0f) + this.mVi)) - tv.chushou.zues.utils.systemBar.b.aB(getActivity());
                    dCb();
                }
                this.u = this.mQN.mTP.mPkId;
                if (this.mQO != null) {
                    this.mQO.b(this.mQN.mTP, false);
                    this.mQO.a(this.mQN.mTP.mMode, (String) null);
                    if (this.mQN.mTP.mAction == 5 && this.mQN.mTP.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mQN.mTP.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mQN.mTP.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mQN.mTP.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mQN.mTP.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mQN.mTP.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mQO.a(this.mQN.mTP);
                        this.mQO.a(parseInt, this.mQN.mTP.mPkUpdateInfo.remainDuration, j, this.mQN.mTP.mMode, (this.mQN.mTP.destinyInfo == null || this.mQN.mTP.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mQN.mTP.mPkUpdateInfo != null && !h.isEmpty(this.mQN.mTP.mPkUpdateInfo.specialMomentList) && this.mQO != null) {
                    this.mQO.a(this.mQN.mTP, true);
                }
                if (this.mQN.mTP.mMode == 2) {
                    dCb();
                } else {
                    dBF();
                }
            } else {
                this.mQN.mTP.mInPKMode = false;
                if (this.mQN.mTP.mMode == 2) {
                    dCb();
                } else {
                    dBF();
                }
            }
        }
    }

    public void dBF() {
        dBZ();
        dBY();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mVf != null && this.mXA != null && this.mXA.mQx != null) {
            this.mVf.setText(tv.chushou.zues.utils.b.Oi(this.mXA.mQx.count));
            this.mVf.setVisibility(0);
            if (this.mXA.mQx.count < 1) {
                dCF();
            }
            if (this.mUY != null) {
                this.mUY.setText(this.mXA.mQx.primaryName);
            }
            if (this.mUZ != null) {
                this.mUZ.setText(this.mXA.mQx.desc);
            }
            dBG();
        }
    }

    public void dBG() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mVg * h.parseLong(this.mXA.mQx.point)));
        if (this.mSi != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mXB.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mXB, a.e.icon_coin_new);
            cVar.append(this.mXB.getString(a.i.str_buy_count_coin2));
            this.mSi.setText(cVar);
        }
    }

    private void dCE() {
        if (com.kascend.chushou.d.e.c(this.mXB, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mVg);
        }
    }

    private void dCF() {
        this.mVh = false;
        this.mVe.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mXA != null && this.mXA.mQx != null) {
            if (this.mXA.mQx.count < 1) {
                this.mVf.setVisibility(8);
            } else {
                this.mVf.setVisibility(0);
                this.mVf.setSelected(false);
                this.mVf.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mUX.setVisibility(8);
        if (this.mUF != null) {
            this.mUF.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mQS != null) {
            if (z) {
                this.mQS.setVisibility(0);
            } else {
                this.mQS.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mWI != null) {
            this.mWI.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mUO != null) {
            this.mUO.performClick();
        }
    }
}
