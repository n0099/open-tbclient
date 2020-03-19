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
/* loaded from: classes5.dex */
public class c extends com.kascend.chushou.player.d implements View.OnClickListener {
    private View mTI;
    public String mTP;
    private TextView mTT;
    private TextView mTW;
    private TextView mUP;
    private ImageView mUc;
    private TextView mUm;
    private KPSwitchPanelLinearLayout mUu;
    private ImageView mUv;
    private tv.chushou.zues.widget.kpswitch.b.c mUx;
    private d.a mUy;
    private TextView mVa;
    private View mVd;
    private int mWC;
    private View mWD;
    private View mWE;
    private com.kascend.chushou.view.user.b mWF;
    private View mWG;
    private FrameLayout mWH;
    private LinearLayout mWI;
    private RelativeLayout mWJ;
    private FrescoThumbnailView mWK;
    private TextView mWL;
    private TextView mWN;
    private TextView mWO;
    private FrescoThumbnailView mWP;
    private TextView mWQ;
    private TextView mWR;
    private TextView mWS;
    private int mWT;
    private TextView mWU;
    private LinearLayout mWV;
    private PlayShowMicStatusView mWW;
    private RecyclerView mWX;
    private ImageView mWY;
    private PlayShowRecommendView mWZ;
    private TextView mWc;
    private TextView mXA;
    private TextView mXB;
    private TextView mXC;
    private TextView mXD;
    private TextView mXE;
    private ImageView mXF;
    private TextView mXG;
    private PopupWindow mXL;
    private View mXN;
    private RecyclerView mXP;
    private RoomInfo mXQ;
    private RecyclerView.LayoutManager mXS;
    private ArrayList<ChatInfo> mXT;
    private ArrayList<ChatInfo> mXU;
    private ArrayList<ChatInfo> mXV;
    private ArrayList<ChatInfo> mXW;
    private View mXa;
    private RelativeLayout mXb;
    private AnimationSet mXc;
    private ImageView mXd;
    private ImageView mXe;
    private RelativeLayout mXf;
    private PastedEditText mXg;
    private ToggleButton mXh;
    private RelativeLayout mXi;
    private PaoPaoView mXj;
    private FrescoThumbnailView mXk;
    private LinearLayout mXl;
    private ImageView mXm;
    private InteractionView mXn;
    private LinearLayout mXo;
    private FrescoThumbnailView mXp;
    private FrameLayout mXq;
    private RedpacketNotifier mXr;
    private InteractNotifier mXs;
    private EmbeddedButtonLayout mXt;
    private GiftAnimationLayout mXu;
    private com.kascend.chushou.player.b.a mXv;
    private f mXw;
    private PlayShowH5View mXx;
    private LinearLayout mXy;
    private TextView mXz;
    private FrescoThumbnailView mYB;
    private FrescoThumbnailView mYC;
    private ValueAnimator mYE;
    private LinearLayout mYF;
    private long mYG;
    private VideoShowVoteView mYH;
    private Runnable mYI;
    private FrescoThumbnailView mYK;
    private ImageView mYL;
    private RelativeLayout mYM;
    private TextView mYN;
    private ImageView mYO;
    private EditText mYP;
    private View mYQ;
    private RelativeLayout mYR;
    private RelativeLayout mYS;
    private FrescoThumbnailView mYT;
    private TextView mYU;
    private TextView mYV;
    private ImageView mYW;
    private RelativeLayout mYX;
    private LinearLayout mYY;
    private TextView mYZ;
    private Button mYa;
    private View mYb;
    private View mYc;
    private Animator mYd;
    private View mYe;
    private View mYf;
    private Animator mYg;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mYj;
    private PlayShowMicPerson mYn;
    private FoodView mYr;
    public ListItem mYs;
    private FoodView mYt;
    private com.kascend.chushou.player.ui.miniview.a mYu;
    private int mYv;
    private int mYw;
    private int mYx;
    private Point mYy;
    private TextView mZa;
    private RelativeLayout mZb;
    private RelativeLayout mZc;
    private FrescoThumbnailView mZd;
    private TextView mZe;
    private TextView mZf;
    private ImageView mZg;
    private RelativeLayout mZh;
    private TextView mZj;
    private float mZk;
    private float mZl;
    private a mZm;
    private boolean mUw = false;
    private int mXH = 1;
    private boolean mXI = false;
    private int mXJ = 0;
    private int mXK = 0;
    private int mXM = -1;
    private boolean mXO = false;
    private FullRoomInfo mXR = null;
    private com.kascend.chushou.player.adapter.a mXX = null;
    private ArrayList<String> mXY = null;
    private boolean mXZ = true;
    private boolean mYh = true;
    private boolean mYi = false;
    public final List<OnlineVipItem> mYk = new ArrayList();
    private boolean mYl = false;
    private boolean mYm = false;
    private long mYo = 0;
    private int mYp = 1;
    private boolean mYq = false;
    private int mYz = -1;
    private int mYA = -1;
    private boolean mYD = false;
    private int mYJ = -1;
    private io.reactivex.disposables.b mZi = null;

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
        this.mTP = getArguments().getString("cover");
        this.mYh = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mZL = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mZL;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dEp()) {
            dDq();
            this.mWp = ((VideoPlayer) this.nab).dCA();
            this.naa = ((VideoPlayer) this.nab).dCD();
            dA(view);
            dDE();
            if (this.nab instanceof VideoPlayer) {
                ((VideoPlayer) this.nab).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mYi = false;
        if (this.naH != null) {
            this.naH.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mYi = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mYd != null) {
            this.mYd.removeAllListeners();
            this.mYd.cancel();
            this.mYd = null;
        }
        if (this.mYg != null) {
            this.mYg.removeAllListeners();
            this.mYg.cancel();
            this.mYg = null;
        }
        if (this.mXs != null) {
            this.mXs.c();
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
        if (this.mZi != null) {
            this.mZi.dispose();
            this.mZi = null;
        }
        this.mXH = 1;
        this.mXI = false;
        if (this.nac != null) {
            this.nac.cq(null);
        }
        if (this.mXL != null) {
            this.mXL.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.nab, this.mUx);
        if (this.nab != null && (this.nab instanceof VideoPlayer)) {
            ((VideoPlayer) this.nab).dCH();
        }
        this.mUy = null;
        this.mUx = null;
        dDo();
        if (this.mXv != null) {
            this.mXv.a();
        }
        if (this.mXj != null) {
            this.mXj.b();
            this.mXj.c();
            this.mXj = null;
        }
        super.d();
    }

    private void dDo() {
        tv.chushou.zues.a.a.cr(this);
        if (this.mXV != null) {
            this.mXV.clear();
        }
        if (this.mXT != null) {
            this.mXT.clear();
        }
        if (this.mXW != null) {
            this.mXW.clear();
        }
        if (this.mXU != null) {
            this.mXU.clear();
        }
        if (this.mXY != null) {
            this.mXY.clear();
        }
        if (this.mXX != null) {
            this.mXX.a(0);
            this.mXX.a();
        }
    }

    private void dA(View view) {
        this.mWD = view.findViewById(a.f.fl_root);
        this.mYy = tv.chushou.zues.utils.a.hd(this.nab);
        this.mXJ = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.nab);
        this.mXK = tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        this.mYx = 86;
        this.naa = ((VideoPlayer) this.nab).dCD();
        if (this.naa != null) {
            this.mXQ = this.naa.dDf();
            this.mXR = this.naa.dDd();
        }
        this.mXT = new ArrayList<>();
        this.mXV = new ArrayList<>();
        this.mXU = new ArrayList<>();
        this.mWH = (FrameLayout) this.mZL.findViewById(a.f.fl_effect);
        b();
        this.mZV = (PlayerErrorView) this.mZL.findViewById(a.f.view_net_error_msg);
        this.mZV.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mXi = (RelativeLayout) this.mZL.findViewById(a.f.rl_audio_ani);
        this.mXj = (PaoPaoView) this.mZL.findViewById(a.f.audio_ani);
        this.mXk = (FrescoThumbnailView) this.mZL.findViewById(a.f.audio_ani_avatar);
        this.mXl = (LinearLayout) this.mZL.findViewById(a.f.ll_audio);
        this.mWc = (TextView) this.mZL.findViewById(a.f.tv_open_video);
        this.mXm = (ImageView) this.mZL.findViewById(a.f.iv_audio_ani);
        this.mYC = (FrescoThumbnailView) this.mZL.findViewById(a.f.live_cover);
        if (!this.mYD || this.mWp == null || this.mWp.getPlayState() != 4) {
            this.mYC.setVisibility(0);
            this.mYC.setBlur(true);
            this.mYC.i(this.mTP, 0, 0, 0);
        }
        this.mWc.setOnClickListener(this);
        this.mTs = new b();
        this.mTs.a(view, null, this.nab, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dQz()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.naa != null) {
                    append.append(c.this.naa.dDf().mRoomID);
                }
                if (c.this.mTr != null && c.this.mTr.mWq != null) {
                    append.append("&mode=").append(c.this.mTr.mWq.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.nab, append.toString());
            }
        });
        this.mTw = (VoiceInteractionView) this.mZL.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.naa != null) {
            this.mXQ = this.naa.dDf();
            this.mXR = this.naa.dDd();
        }
        dDr();
        dDp();
        dDw();
        this.mYF = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mYr = (FoodView) view.findViewById(a.f.rav_ad);
        this.mYK = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mYL = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mYK.setOnClickListener(this);
        this.mYL.setOnClickListener(this);
        this.mYM = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mYB = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mYB.setOnClickListener(this);
        this.mXs = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mXr = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mYa = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mYa.setOnClickListener(this);
        this.mXP = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mXP.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXP.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mYy.x, this.mYy.y) * 0.83d);
        this.mXP.setLayoutParams(layoutParams);
        this.mXS = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.nab);
        this.mXP.setLayoutManager(this.mXS);
        this.mXP.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mXP.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mXP.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dDR();
                } else if (i == 1) {
                    c.this.mXZ = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mXX = new com.kascend.chushou.player.adapter.a(this.nab, this.mXT);
        if (this.mXQ != null) {
            this.mXX.a(this.mXQ);
        }
        if (com.kascend.chushou.b.dCl().c != null) {
            this.mXX.a(com.kascend.chushou.b.dCl().c);
        }
        this.mXP.setAdapter(this.mXX);
        this.mXX.a(this.mXT.size());
        this.mXX.notifyDataSetChanged();
        if (this.naa != null && (c = this.naa.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mXv != null) {
            this.mXv.a();
            this.mXv = null;
        }
        this.mXu = (GiftAnimationLayout) this.mZL.findViewById(a.f.ll_gift_animation);
        this.mXu.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mWC = ((int) (tv.chushou.zues.utils.a.hc(this.nab).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nab, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mXu.getLayoutParams();
        layoutParams2.bottomMargin = this.mWC;
        this.mXu.setLayoutParams(layoutParams2);
        if (this.naa != null) {
            this.mXv = new com.kascend.chushou.player.b.a(this.nab.getApplicationContext(), this.mXu);
            this.mXv.a(this.naa);
            a(this.naa.mSV, this.naa.mSZ);
        }
        this.mZL.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mXt = (EmbeddedButtonLayout) this.mZL.findViewById(a.f.embedded_button_layout);
        this.mXt.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mYH = (VideoShowVoteView) this.mZL.findViewById(a.f.view_video_show_vote);
        this.mYH.setOnClickListener(this);
        this.mYH.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dDN();
            }
        });
        if (this.naa != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nab;
            this.mXt.a(videoPlayer.dCN().dEw());
            this.mXt.b(this.naa.i());
            this.mXr.a(videoPlayer.dCJ(), false);
            this.mXs.a(videoPlayer.dCK(), videoPlayer.dCL(), videoPlayer.dCM());
            this.mTr = new com.kascend.chushou.player.e.a();
        }
        this.naR = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mYl = false;
                c.this.b(c.this.mWC, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mYl = true;
                if (c.this.naH != null) {
                    c.this.naH.measure(0, 0);
                    int measuredHeight = c.this.naH.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.nab, 14.0f);
                    if (measuredHeight > c.this.mWC) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.naL = (PaoGuideView) this.mZL.findViewById(a.f.rlPaoGuideView);
        this.mYn = (PlayShowMicPerson) this.mZL.findViewById(a.f.rl_mic_person_view);
        this.mXx = (PlayShowH5View) this.mZL.findViewById(a.f.rl_playshowh5);
        this.mYt = (FoodView) this.mZL.findViewById(a.f.bottom_ad);
        if (this.naa != null) {
            H();
            if (this.naa.mSO != null && !h.isEmpty(this.naa.mSO.mUrl)) {
                b(this.naa.mSO);
            }
        }
        this.mYb = this.mZL.findViewById(a.f.view_reminder_subscribe);
        this.mYc = this.mYb.findViewById(a.f.spash_subscribe);
        ((TextView) this.mYb.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().O(this.nab, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.nab.getString(a.i.videoplayer_reminder_subscribe)));
        this.mYb.setOnClickListener(this);
        this.mYe = this.mZL.findViewById(a.f.view_reminder_danmaku);
        this.mYf = this.mYe.findViewById(a.f.spash_danmaku);
        ((TextView) this.mYe.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().O(this.nab, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.nab.getString(a.i.videoplayer_reminder_danmaku)));
        this.mYe.setOnClickListener(this);
    }

    private void dDp() {
        this.mYR = (RelativeLayout) this.mZL.findViewById(a.f.rl_cyclelive);
        this.mYS = (RelativeLayout) this.mZL.findViewById(a.f.rlrl_cyclelive);
        this.mYT = (FrescoThumbnailView) this.mZL.findViewById(a.f.iv_liveicon);
        this.mYU = (TextView) this.mZL.findViewById(a.f.tv_livename);
        this.mYV = (TextView) this.mZL.findViewById(a.f.tv_livedesc);
        this.mYW = (ImageView) this.mZL.findViewById(a.f.iv_cyclelive_name_menu);
        this.mYX = (RelativeLayout) this.mZL.findViewById(a.f.rl_normal);
        this.mYY = (LinearLayout) this.mZL.findViewById(a.f.ll_cyclelive_nickname);
        this.mYZ = (TextView) this.mZL.findViewById(a.f.tv_cyclelive_nickname);
        this.mZa = (TextView) this.mZL.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mZb = (RelativeLayout) this.mZL.findViewById(a.f.rl_clear_cyclelive);
        this.mZc = (RelativeLayout) this.mZL.findViewById(a.f.rlrl_clear_cyclelive);
        this.mZd = (FrescoThumbnailView) this.mZL.findViewById(a.f.iv_clear_liveicon);
        this.mZe = (TextView) this.mZL.findViewById(a.f.tv_clear_livename);
        this.mZf = (TextView) this.mZL.findViewById(a.f.tv_clear_livedesc);
        this.mZg = (ImageView) this.mZL.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mZh = (RelativeLayout) this.mZL.findViewById(a.f.rl_clear_normal);
        this.mZg.setOnClickListener(this);
        this.mYW.setOnClickListener(this);
        this.mZa.setOnClickListener(this);
        this.mYZ.setOnClickListener(this);
        this.mYT.setOnClickListener(this);
        this.mZd.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.naa.mSM != null && this.mYt != null) {
            this.mYt.a(true, this.naa.a == null ? "" : this.naa.a);
            this.mYt.a(this.naa.mSM, a.C0691a.slide_in_bottom_danmu_anim, a.C0691a.slide_out_bottom_danmu_anim, true);
        }
        if (this.naa != null && this.naa.mSU != null && this.mXt != null) {
            this.mYr.a(this.naa.mSU, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.naa != null) {
                        c.this.naa.mSU = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDO() {
        return this.mXv;
    }

    private void dDq() {
        this.nac = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mZL != null && (textView = (TextView) c.this.mZL.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.nab.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.nac.K(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.nac);
                        break;
                    case 12:
                        c.this.b(c.this.nac);
                        break;
                    case 17:
                        c.this.dEs();
                        break;
                    case 18:
                        c.this.cYj();
                        break;
                    case 19:
                        c.this.mZZ.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mXO) {
            this.mXO = true;
            if (this.mXN == null) {
                this.mXN = this.mZL.findViewById(a.f.vs_async_show_content);
                this.mXN = ((ViewStub) this.mXN).inflate();
            }
            this.mTI = this.mZL.findViewById(a.f.ui_content);
            if (this.mVd == null) {
                this.mVd = this.mZL.findViewById(a.f.vs_async_notification_view);
                this.mVd = ((ViewStub) this.mVd).inflate();
            }
            c(this.mZL);
            k();
            cYk();
            if (this.c == null) {
                this.mTk = new d.a();
                this.c = new GestureDetector(this.nab, this.mTk);
            }
            ((VideoPlayer) this.nab).q();
        }
    }

    private void dDr() {
        this.mWI = (LinearLayout) this.mZL.findViewById(a.f.ll_anchor);
        this.mWJ = (RelativeLayout) this.mZL.findViewById(a.f.ll_clear_anchor);
        this.mWI.setVisibility(4);
        this.mWJ.setVisibility(4);
        this.mWK = (FrescoThumbnailView) this.mZL.findViewById(a.f.iv_clear_avatar);
        this.mWL = (TextView) this.mZL.findViewById(a.f.tv_clear_nickname);
        this.mWN = (TextView) this.mZL.findViewById(a.f.tv_clear_online_count);
        this.mWO = (TextView) this.mZL.findViewById(a.f.tv_clear_btn_subscribe);
        this.mWO.setOnClickListener(this);
        this.mWP = (FrescoThumbnailView) this.mZL.findViewById(a.f.iv_avatar);
        this.mWQ = (TextView) this.mZL.findViewById(a.f.tv_nickname_test);
        this.mWR = (TextView) this.mZL.findViewById(a.f.tv_online_count);
        this.mTT = (TextView) this.mZL.findViewById(a.f.tv_btn_subscribe);
        this.mTT.setOnClickListener(this);
        this.mWS = (TextView) this.mZL.findViewById(a.f.tv_loyal_counts);
        this.mTW = (TextView) this.mZL.findViewById(a.f.tv_btn_contribution);
        this.mWU = (TextView) this.mZL.findViewById(a.f.tv_btn_contribution_forpk);
        this.mTW.setVisibility(4);
        this.mWU.setVisibility(8);
        this.mWV = (LinearLayout) this.mZL.findViewById(a.f.ll_mic);
        this.mWW = (PlayShowMicStatusView) this.mZL.findViewById(a.f.show_mic_status);
        this.mWX = (RecyclerView) this.mZL.findViewById(a.f.rv_loyal);
        this.mWY = (ImageView) this.mZL.findViewById(a.f.iv_clear_close);
        this.mUc = (ImageView) this.mZL.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mWX.setLayoutManager(linearLayoutManager);
        this.mYj = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mYk, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mYk.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.nab, (JSONObject) null, c.this.naa.dDf().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0814a view$OnLongClickListenerC0814a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0814a.Ou(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0814a.Ou(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0814a.Ou(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dQL(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.nab, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nab, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nab, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nab, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.nab, a.c.color_979797), dip2px);
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
        this.mWX.setAdapter(this.mYj);
        this.mWV.setOnClickListener(this);
        this.mWK.setOnClickListener(this);
        this.mWY.setOnClickListener(this);
        this.mWP.setOnClickListener(this);
        this.mWK.setOnClickListener(this);
        this.mUc.setOnClickListener(this);
        this.mWS.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dQz() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.naa != null) {
                    str = str + c.this.naa.dDf().mRoomID;
                }
                c.this.f(c.this.nab.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mTW.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dQz() + "m/room-billboard/";
                if (c.this.naa != null) {
                    str = str + c.this.naa.dDf().mRoomID;
                }
                c.this.f(c.this.nab.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mWU.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dQz() + "m/room-billboard/";
                if (c.this.naa != null) {
                    str = str + c.this.naa.dDf().mRoomID;
                }
                c.this.f(c.this.nab.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        t(true);
    }

    public void t(boolean z) {
        boolean z2;
        if (this.mXR == null || this.mXR.cycleLiveRoomInfo == null || h.isEmpty(this.mXR.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mTu = this.mXR.cycleLiveRoomInfo;
        }
        if (z2 && this.mTu != null) {
            this.mYR.setVisibility(0);
            this.mZb.setVisibility(0);
            this.mYX.setVisibility(8);
            this.mZh.setVisibility(8);
            this.mYY.setVisibility(0);
            this.mZd.h(this.mTu.eventIcon, com.kascend.chushou.view.a.a(this.mXQ.mCreatorGender), b.a.small, b.a.small);
            this.mYT.h(this.mTu.eventIcon, com.kascend.chushou.view.a.a(this.mXQ.mCreatorGender), b.a.small, b.a.small);
            this.mZe.setText(this.mTu.eventName);
            this.mZf.setText(this.mTu.eventDesc);
            this.mYU.setText(this.mTu.eventName);
            this.mYV.setText(this.mTu.eventDesc);
            this.mYZ.setText(this.mTu.nickname);
            dDt();
            if (z) {
                c(this.mTu.remainTime);
                return;
            }
            return;
        }
        this.mYR.setVisibility(8);
        this.mZb.setVisibility(8);
        this.mYX.setVisibility(0);
        this.mZh.setVisibility(0);
        this.mYY.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mZi != null) {
            this.mZi.dispose();
            this.mZi = null;
        }
        this.mZi = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJJ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.nab != null && (c.this.nab instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nab).u();
                }
            }
        });
    }

    private void dDs() {
        if (this.mXQ != null && this.mXO) {
            this.mWI.setVisibility(0);
            this.mWJ.setVisibility(0);
            this.mTW.setVisibility(0);
            this.mWK.h(this.mXQ.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mXQ.mCreatorGender), b.a.small, b.a.small);
            this.mWL.setText(this.mXQ.mCreatorNickname);
            this.mWP.h(this.mXQ.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mXQ.mCreatorGender), b.a.small, b.a.small);
            this.mWQ.setText(this.mXQ.mCreatorNickname);
            dEd();
            dDu();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dEd() {
        if (this.mXQ != null) {
            this.mWN.setText(tv.chushou.zues.utils.b.formatNumber(this.mXQ.mOnlineCount));
            this.mWR.setText(tv.chushou.zues.utils.b.formatNumber(this.mXQ.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDt() {
        if (this.mTu != null) {
            if (this.mTu.isSubscribe) {
                this.mZa.setText(a.i.like_already);
                this.mZa.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mZa.setText(getString(a.i.like));
            this.mZa.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDu() {
        if (this.mXQ != null) {
            if (this.mXQ.mIsSubscribed) {
                this.mWO.setText(getString(a.i.like_already));
                this.mWO.setBackgroundResource(a.e.bg_show_subcribe);
                this.mTT.setText(getString(a.i.like_already));
                this.mTT.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mWO.setText(getString(a.i.like));
            this.mWO.setBackgroundResource(a.e.bg_show_subcribe);
            this.mTT.setText(getString(a.i.like));
            this.mTT.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dDv() {
        if (this.mYj != null) {
            this.mYj.notifyDataSetChanged();
        }
    }

    private void dDw() {
        this.mXa = this.mZL.findViewById(a.f.tv_interact);
        this.mXa.setOnClickListener(this);
        this.mXf = (RelativeLayout) this.mZL.findViewById(a.f.rl_edit_bar);
        this.mXd = (ImageView) this.mZL.findViewById(a.f.btn_hotword);
        this.mXd.setOnClickListener(this);
        this.mXe = (ImageView) this.mZL.findViewById(a.f.iv_task_badge);
        this.mXc = (AnimationSet) AnimationUtils.loadAnimation(this.nab, a.C0691a.anim_hotword);
        this.mXc.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dCs().c) {
                    c.this.mXd.clearAnimation();
                    c.this.mXd.startAnimation(c.this.mXc);
                }
            }
        });
        if (com.kascend.chushou.d.h.dCs().c) {
            this.mXd.startAnimation(this.mXc);
            this.mXe.setVisibility(0);
        }
        this.mZj = (TextView) this.mZL.findViewById(a.f.tv_bottom_input);
        this.mZj.setOnClickListener(this);
        this.nbb = (FrescoThumbnailView) this.mZL.findViewById(a.f.ll_btn_set);
        this.nbb.setOnClickListener(this);
        this.nbb.xw(a.e.ic_room_set_btn_white);
        this.mXo = (LinearLayout) this.mZL.findViewById(a.f.ll_bottom_all_button);
        this.mXp = (FrescoThumbnailView) this.mZL.findViewById(a.f.fl_clear_bottom_gift);
        this.mXp.setAnim(true);
        this.mXp.setOnClickListener(this);
        this.mXp.xw(a.e.ic_show_gift_n);
        this.mXq = (FrameLayout) this.mZL.findViewById(a.f.flfl_clear_bottom_gift);
        this.mXq.setVisibility(8);
        this.mXb = (RelativeLayout) this.mZL.findViewById(a.f.rl_bottom_input);
        this.mXb.setVisibility(0);
        this.mXg = (PastedEditText) this.mZL.findViewById(a.f.et_bottom_input);
        this.mXg.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mUm.setEnabled(editable.length() > 0);
            }
        });
        this.mXg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mUm);
                    return true;
                }
                return true;
            }
        });
        this.mXg.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.mXg);
                }
                return false;
            }
        });
        this.mUv = (ImageView) this.mZL.findViewById(a.f.iv_btn_emoji);
        this.mUv.setVisibility(8);
        this.mUm = (TextView) this.mZL.findViewById(a.f.tv_btn_send);
        this.mUm.setOnClickListener(this);
        this.mXy = (LinearLayout) this.mZL.findViewById(a.f.head_trumpet);
        this.mXy.setVisibility(8);
        this.mXy.setOnClickListener(this);
        this.mXz = (TextView) this.mZL.findViewById(a.f.tv_primary_name);
        this.mXA = (TextView) this.mZL.findViewById(a.f.tv_primary_desc);
        this.mXC = (TextView) this.mZL.findViewById(a.f.tv_cut_count);
        this.mXC.setOnClickListener(this);
        this.mXE = (TextView) this.mZL.findViewById(a.f.tv_head_count);
        this.mXE.setText(this.mXH + "");
        this.mXD = (TextView) this.mZL.findViewById(a.f.tv_plus_count);
        this.mXD.setOnClickListener(this);
        this.mUP = (TextView) this.mZL.findViewById(a.f.tv_buy_count_coin);
        this.mXB = (TextView) this.mZL.findViewById(a.f.tv_buy_head);
        this.mXB.setOnClickListener(this);
        this.mXF = (ImageView) this.mZL.findViewById(a.f.iv_trumpet_select);
        this.mXF.setOnClickListener(this);
        this.mXG = (TextView) this.mZL.findViewById(a.f.tv_trumpet_have_count);
        this.mXI = false;
        this.mXF.setBackgroundResource(a.e.ic_trumpet_n);
        this.mXG.setVisibility(8);
        this.mUu = (KPSwitchPanelLinearLayout) this.mZL.findViewById(a.f.chat_extended_container);
        dDC();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mUu, this.mUv, this.mXg, new a.InterfaceC0818a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0818a
            public void wq(boolean z) {
                if (c.this.mUv != null) {
                    if (z) {
                        c.this.mUu.setDirectVisibility(0);
                        c.this.mUv.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mUv.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mUy = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wr(boolean z) {
                c.this.mUw = z;
                if (z) {
                    c.this.mUv.setImageResource(a.e.cs_emoji_normal);
                    c.this.dDy();
                    if (c.this.mYQ != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mYQ.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hn(c.this.nab);
                        c.this.mYQ.setLayoutParams(layoutParams);
                    }
                    if (c.this.mXf != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mXf.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hn(c.this.nab);
                        c.this.mXf.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mYQ != null && c.this.mYQ.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mYQ.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mYQ.setLayoutParams(layoutParams3);
                    c.this.mYQ.setVisibility(8);
                }
                if (c.this.mYl) {
                    c.this.naH.setVisibility(0);
                }
                if (c.this.nab != null && (c.this.nab instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.nab).wo(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mXf != null && c.this.mUu.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mXf.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mXf.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mUx = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mUu, this.mUy, ((VideoPlayer) this.nab).dCI());
        ((VideoPlayer) this.nab).h(((VideoPlayer) this.nab).dCI());
        this.mYQ = this.mZL.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mYN = (TextView) this.mZL.findViewById(a.f.btn_room_search);
        this.mYO = (ImageView) this.mZL.findViewById(a.f.iv_room_emoji_delete);
        this.mYP = (EditText) this.mZL.findViewById(a.f.et_room_emoji_search);
        this.mYP.setImeOptions(3);
        this.mYP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mYN);
                    return true;
                }
                return false;
            }
        });
        this.mYP.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mYN.setEnabled(editable.length() > 0);
                c.this.mYO.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.naH.setEmojiSearchText(editable.toString());
            }
        });
        this.mYN.setOnClickListener(this);
        this.mYO.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mYP);
            this.mYQ.setVisibility(0);
            this.mYP.requestFocus();
        } else {
            this.mYQ.setVisibility(8);
        }
        if (z2) {
            this.mYP.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDy() {
        int hn = tv.chushou.zues.widget.kpswitch.b.d.hn(this.nab) + tv.chushou.zues.utils.a.dip2px(this.nab, 14.0f);
        if (hn > this.mWC) {
            b(hn, 12);
        }
    }

    private void dDC() {
    }

    private void dDE() {
        if (this.mXK > 0) {
            View findViewById = this.mZL.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mXK);
        }
        if (this.mXJ > 0) {
            View findViewById2 = this.mZL.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mXJ, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mYh) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dDK();
        a();
        this.mTm = ((VideoPlayer) this.nab).dCE();
        this.mTm.a(this);
        if (this.naa.dDd() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mTm != null) {
            this.mTm.d();
        }
    }

    private void dDF() {
        if ((this.mTr == null || this.mTr.mWq == null || !this.mTr.mWq.mInPKMode) ? false : true) {
            if (this.mWD != null) {
                this.mWD.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTt.getLayoutParams();
            layoutParams.leftMargin = (this.mYy.x / 2) + tv.chushou.zues.utils.a.dip2px(this.nab, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mTt.setLayoutParams(layoutParams);
            this.y.setText(this.mTr.mWq.mPkUserNickname);
            this.mTt.setVisibility(0);
            this.mWV.setVisibility(8);
            return;
        }
        if (this.mWD != null) {
            this.mWD.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mTt.setVisibility(8);
    }

    private void dDG() {
        boolean z = false;
        if (this.mTr != null && this.mTr.mWq != null && this.mTr.mWq.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mYJ > 0 && this.mXP != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXP.getLayoutParams();
                if (layoutParams.height != this.mYJ) {
                    layoutParams.height = this.mYJ;
                    this.mXP.setLayoutParams(layoutParams);
                }
            }
            this.mWC = ((int) (tv.chushou.zues.utils.a.hc(this.nab).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nab, 84.0f);
            b(this.mWC, 12);
        } else {
            if (this.mXP != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mXP.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.nab, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.nab, 250.0f);
                    this.mXP.setLayoutParams(layoutParams2);
                }
            }
            this.mWC = ((int) (tv.chushou.zues.utils.a.hc(this.nab).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.nab, 84.0f);
            b(this.mWC, 12);
        }
        if (this.mTs != null) {
            this.mTs.a(this.mYJ + tv.chushou.zues.utils.a.dip2px(this.nab, 52.0f), this.naf);
        }
        if (this.mTw != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mTw.getLayoutParams();
            layoutParams3.bottomMargin = this.mYJ + tv.chushou.zues.utils.a.dip2px(this.nab, 52.0f);
            this.mTw.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dDJ();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dDJ();
    }

    private void dDI() {
        dDG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDJ() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dEq().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mYy = tv.chushou.zues.utils.a.hd(this.nab);
        this.mYx = 86;
        this.mYv = (Math.max(this.mYy.x, this.mYy.y) - tv.chushou.zues.utils.a.dip2px(this.nab, (this.mYx + 52) + 250)) - this.mXJ;
        this.mYw = Math.max(this.mYy.x, this.mYy.y) - ((tv.chushou.zues.utils.a.dip2px(this.nab, this.mYx) + this.mXJ) * 2);
        if (this.mYz <= 0 || this.mYA <= 0) {
            this.mYz = Math.min(this.mYy.x, this.mYy.y);
            this.mYA = Math.max(this.mYy.x, this.mYy.y);
        }
        this.ar = Math.min(this.mYy.x, this.mYy.y);
        this.naf = (this.ar * this.mYA) / this.mYz;
        boolean z = false;
        if (this.mTr == null || this.mTr.mWq == null) {
            i = 1;
        } else {
            i = this.mTr.mWq.mMode;
            if (this.mTr.mWq.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mYx = 42;
            if (i == 2) {
                if (this.mYA < this.mYz) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.naf;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.naf;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mYz * layoutParams.height) / this.mYA;
                    layoutParams2.height = layoutParams.height;
                    this.naf = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.naf;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.naf;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nab, this.mYx) + this.mXJ;
            layoutParams.gravity = 48;
            this.mYJ = ((this.mYy.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nab, (this.mYx + 52) + 64) + this.mXJ)) - tv.chushou.zues.utils.systemBar.b.aE(getActivity());
            dDm();
        } else if (this.E) {
            this.mYx = 42;
            if (this.mYA < this.mYz) {
                layoutParams.width = this.ar;
                layoutParams.height = this.naf;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.naf;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mYz * layoutParams.height) / this.mYA;
                layoutParams2.height = layoutParams.height;
                this.naf = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nab, this.mYx) + this.mXJ;
            layoutParams.gravity = 48;
            this.mYJ = ((this.mYy.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.nab, (this.mYx + 52) + 98) + this.mXJ)) - tv.chushou.zues.utils.systemBar.b.aE(getActivity());
            dDI();
        } else {
            this.mYJ = -1;
            this.mYx = 86;
            if (this.naf <= this.mYv) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYv;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nab, this.mYx) + this.mXJ;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.naf;
            } else if (this.naf < this.mYw) {
                layoutParams.width = this.ar;
                layoutParams.height = this.naf;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.nab, this.mYx) + this.mXJ;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.naf;
            } else {
                this.naf = Math.max(this.mYy.x, this.mYy.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.naf;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.naf * this.mYz) / this.mYA >= this.ar) {
                        i3 = this.naf;
                        i2 = (this.naf * this.mYz) / this.mYA;
                    } else if ((this.ar * this.mYA) / this.mYz >= this.naf) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mYA) / this.mYz;
                    } else {
                        i2 = this.ar;
                        i3 = this.naf;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.naf) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mYA) / this.mYz > this.naf) {
                        i3 = this.naf;
                        i2 = (this.naf * this.mYz) / this.mYA;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mYA) / this.mYz;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mYA) / this.mYz;
                        if (i3 > this.naf) {
                            i3 = this.naf;
                            i2 = (this.naf * this.mYz) / this.mYA;
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
        if (this.naa != null && this.naa.d) {
            layoutParams.width = Math.min(this.mYy.x, this.mYy.y);
            layoutParams.height = Math.max(this.mYy.x, this.mYy.y);
        }
        dEq().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dDK() {
        this.N = new SurfaceRenderView(this.nab);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dEq().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mYq) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dEg();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dEf();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mZm != null) {
            this.mZm.a();
        }
        if (this.naa != null && !h.isEmpty(this.naa.mSX)) {
            b(this.naa.mSX);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mWp != null) {
            int width = this.mWp.getWidth();
            int height = this.mWp.getHeight();
            if (this.mYz != width || this.mYA != height || this.mYz <= 0 || this.mYA <= 0) {
                this.mYz = width;
                this.mYA = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dDJ();
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
            if (this.mYl) {
                dDM();
            } else {
                if (this.nab.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.nab, "点击送礼_num", "竖屏", new Object[0]);
                if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.naa.dDd().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mXI) {
                f(this.mXg.getText().toString());
            } else {
                a(this.mXg.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dCs().c) {
                com.kascend.chushou.d.h.dCs().b(false);
                this.mXc.cancel();
                this.mXc.reset();
                this.mXd.clearAnimation();
                this.mXe.setVisibility(8);
            }
            l(view, 0, this.mZL.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.nab, 165.0f) / 2);
            k(view, x >= 0 ? x : 0, this.mZL.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.naa.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.naa.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mXP != null) {
                v(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mXQ != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mYp = 1;
            ws(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.nab, (JSONObject) null, this.naa.dDf().mRoomID, this.naa.dDf().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        } else if (id == a.f.ftv_pack) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(8, null));
        } else if (id == a.f.view_reminder_subscribe) {
            a(false);
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            hashMap2.put("_fromPos", "73");
            b(hashMap2);
        } else if (id == a.f.view_reminder_danmaku) {
            wt(false);
            a(this.nab.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.nab, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mYs != null) {
                    com.kascend.chushou.d.e.a(this.nab, this.mYs, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mYM != null) {
                    this.mYM.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.nab, null) && this.naa != null && this.naa.mSY != null) {
                    if (this.mXI) {
                        dEn();
                    } else {
                        if (this.naa != null && this.naa.mSY != null && this.naa.mSY.count > 0) {
                            this.mXy.setVisibility(8);
                        } else {
                            this.mXy.setVisibility(0);
                        }
                        this.mXI = true;
                        this.mXF.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mXG.setVisibility(0);
                        this.mXG.setSelected(true);
                        this.mXG.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mXg != null) {
                            this.mXg.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mXH <= 9) {
                    this.mXH++;
                    this.mXE.setText(this.mXH + "");
                }
                dDn();
            } else if (id == a.f.tv_cut_count) {
                if (this.mXH > 1) {
                    this.mXH--;
                    this.mXE.setText(this.mXH + "");
                }
                dDn();
            } else if (id == a.f.tv_buy_head) {
                dEm();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mYP.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mYP.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mYQ.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dM(this.mYP);
                    this.naH.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mTu != null && !h.isEmpty(this.mTu.eventUrl)) {
                    f("", this.mTu.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mTu != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mTu != null) {
                    com.kascend.chushou.d.a.a(this.nab, (JSONObject) null, this.mTu.roomId, this.mTu.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.naa.a(false);
                    ((VideoPlayer) this.nab).l();
                } else {
                    ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.mXx != null) {
            int i = (tv.chushou.zues.utils.a.hc(this.nab).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mXx.getLayoutParams();
            layoutParams.topMargin = i;
            this.mXx.setLayoutParams(layoutParams);
            this.mXx.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mXx.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Os(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mYo <= 3000) {
            tv.chushou.zues.utils.g.Os(a.i.str_too_fast);
            return false;
        } else {
            cYq();
            if (!com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a(((VideoPlayer) this.nab).dCD().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mYo = System.currentTimeMillis();
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                a(this.naa.dDd().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.naa.h);
            }
            g(this.b);
            if (!z && this.mXg != null) {
                this.mXg.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            cYq();
            if (com.kascend.chushou.d.e.c(this.nab, null) && LoginManager.Instance().getUserInfo() != null && this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                a(this.naa.dDd().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mXg != null) {
                this.mXg.setText((CharSequence) null);
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
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.naa.dDd().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.naa.dDd().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.nab).mRh;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.ST(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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

    private void k(View view, int i, int i2) {
        if (this.naB != null && this.naB.isShowing()) {
            this.naB.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
        if (this.naY == null) {
            i(3);
        }
        this.naY.getContentView().setBackgroundResource(0);
        this.naY.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.naY.isShowing()) {
            this.naY.showAtLocation(view, 83, i, i2);
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.naa.dDd().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.naY.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDD() {
        if (h.isEmpty(this.nbc)) {
            if (((VideoPlayer) this.nab).q) {
                this.nbb.xw(a.e.ic_room_set_btn_white);
            } else {
                this.nbb.xw(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.nab).q && this.nbc.size() == 2 && this.nbc.contains("4") && this.nbc.contains("2")) {
            this.nbb.xw(a.e.ic_room_set_btn_system_white);
        } else if (this.nbc.size() > 1 || !((VideoPlayer) this.nab).q) {
            this.nbb.xw(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.nbc.get(0))) {
            this.nbb.xw(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.nbc.get(0))) {
            this.nbb.xw(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.nbc.get(0))) {
            this.nbb.xw(a.e.ic_room_set_btn_system_white);
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
        if (this.naB == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.naB.getContentView().setBackgroundResource(0);
            this.naB.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.naB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mXd.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.naB.isShowing()) {
            this.naB.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.nab, 16.0f) + i2);
            this.mXd.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.naa.dDd().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.naB.dismiss();
    }

    private void dB(View view) {
        if (this.nav == null) {
            dDP();
        }
        if (com.kascend.chushou.d.h.dCs().q()) {
            this.mXh.dQJ();
        } else {
            this.mXh.dQK();
        }
        int height = this.mZL.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        if (view != null) {
            this.nav.showAtLocation(view, 85, 0, height);
        }
    }

    private void dDP() {
        if (this.nav == null) {
            View inflate = LayoutInflater.from(this.nab).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mXh = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dCs().q()) {
                this.mXh.dQJ();
            } else {
                this.mXh.dQK();
            }
            this.mXh.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dCs().g(z);
                }
            });
            this.nap = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.naq = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.nap.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.nap.setVisibility(0);
            } else {
                this.nap.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dCs().a) {
                this.naq.b();
            } else {
                this.naq.c();
            }
            if (this.naa != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.naa.f;
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
                                if (this.mTr == null || !this.mTr.mWq.mInPKMode || h.isEmpty(this.mTr.b) || this.mXQ == null || !this.mTr.b.equals(this.mXQ.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.nab).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dDe = this.naa.dDe();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.nab).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nab, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nab, 5.0f);
                                            }
                                            int identifier = this.nab.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.nab.getPackageName());
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
                                                if (dDe != null && dDe.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.nab.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.nab).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dDe2 = this.naa.dDe();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.nab).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.nab, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.nab, 5.0f);
                                        }
                                        int identifier2 = this.nab.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.nab.getPackageName());
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
                                            if (dDe2 != null && dDe2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dDQ();
                        c.this.nav.dismiss();
                    }
                }
            });
            this.nav = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 150.0f), -2);
            this.nav.setFocusable(true);
            this.nav.setOutsideTouchable(true);
            this.nav.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.nav.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.nav = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDQ() {
        if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
            if (this.mXw == null) {
                this.mXw = new f(getActivity());
            }
            this.mXw.a(this.naa.dDd().mRoominfo, this.ax);
            if (!this.mXw.isShowing()) {
                this.mXw.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mYq) {
            return false;
        }
        if (this.mYp == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mZk = motionEvent.getX();
                    this.mZl = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mZk;
                    if (Math.abs(f) > Math.abs(y - this.mZl) && Math.abs(f) > q && f > 0.0f) {
                        dEi();
                        return true;
                    }
                    this.mZk = 0.0f;
                    this.mZl = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mYQ != null && this.mYQ.getVisibility() == 0 && b(motionEvent, this.mYQ)) {
                this.mYQ.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mYP);
                return true;
            } else if (this.mYl && this.mYQ != null && this.mYQ.getVisibility() == 8 && g(this.naH.b, motionEvent)) {
                dDM();
                return true;
            } else if (this.mXx != null && this.mXx.b() && g(this.mXx, motionEvent)) {
                this.mXx.a();
                return true;
            } else if (this.mXn != null && this.mXn.b() && g(this.mXn, motionEvent)) {
                this.mXn.a();
                return true;
            } else if (b(motionEvent, this.mXf)) {
                return cYq();
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
            if (this.naS != null && this.naS.a(i, keyEvent)) {
                return true;
            }
            if ((this.mXx != null && this.mXx.onKeyDown(i, keyEvent)) || dDz()) {
                return true;
            }
            if (this.mYp == 3) {
                this.mYp = 1;
                dEi();
                return true;
            } else if (this.mXn != null && this.mXn.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z) {
        if (z) {
            if (this.mXg != null && this.mXb != null && this.mXf != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mXg);
                this.mXb.setVisibility(8);
                this.mXf.setVisibility(0);
            }
        } else if (this.mXb != null && this.mXf != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
            this.mXb.setVisibility(0);
            this.mXf.setVisibility(8);
        }
    }

    public boolean cYq() {
        boolean z;
        b(this.mWC, 12);
        boolean z2 = false;
        if (this.mUu != null && this.mUu.getVisibility() == 0) {
            this.mUu.setVisibility(8);
            this.mUv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mUw) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.nab);
            this.mUv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mXf == null || this.mXf.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mXI) {
                dEn();
            }
            this.mXf.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mXb != null) {
                    c.this.mXb.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dDz() {
        if (cYq()) {
            return true;
        }
        if (this.naB != null && this.naB.isShowing()) {
            this.naB.dismiss();
            return true;
        } else if (this.naY != null && this.naY.isShowing()) {
            this.naY.dismiss();
            return true;
        } else if (this.nav == null || !this.nav.isShowing()) {
            return dDM() || dDB() || dDL() || dDA();
        } else {
            this.nav.dismiss();
            return true;
        }
    }

    public boolean dDA() {
        if (this.naL == null || !this.naL.isShown()) {
            return false;
        }
        this.naL.d();
        return true;
    }

    public boolean dDB() {
        if (this.mYn == null || !this.mYn.isShown()) {
            return false;
        }
        this.mYn.a();
        return true;
    }

    public boolean dDL() {
        if (this.mXx == null || !this.mXx.b()) {
            return false;
        }
        this.mXx.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.nab != null && !((Activity) this.nab).isFinishing() && pVar != null) {
            this.mXY = pVar.a;
            v(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dEp() && this.mXQ != null && mVar.a(this.mXQ.mCreatorUID, null)) {
            this.mXQ.mIsSubscribed = mVar.c;
            dDu();
        }
    }

    public boolean dDM() {
        if (!this.mYl || this.naH == null) {
            return false;
        }
        if (this.naH != null) {
            this.naH.e();
        }
        if (this.mYP != null) {
            this.mYP.setText("");
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
        if (!dEp() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mYu != null) {
                        this.mYu.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                        this.naa.dDd().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.naa.dDd().mMicStatus.onMic) {
                            if (this.mWV != null) {
                                this.mWV.setVisibility(8);
                            }
                            if (this.mYn != null && this.mYn.isShown()) {
                                this.mYn.a();
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
                        if (this.naa.dDd().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mXQ != null && !h.isEmpty(this.mXQ.mCreatorUID)) {
                                i(arrayList2, this.mXQ.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).b(!this.F);
                            }
                        } else if (this.naa.dDd().mMicStatus.onMic) {
                            if (this.naa.dDd().mMicStatus != null && !h.isEmpty(this.naa.dDd().mMicStatus.micRoomId) && !this.naa.dDd().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.naa.dDd().mMicStatus.micRoomId;
                            }
                            this.naa.dDd().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.naa.dDd().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = j(this.naa.dDd().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.naa.dDd().mMicStatus, str3, z4);
                            if (this.mYn != null && this.mYn.getVisibility() == 0) {
                                this.mYn.a(this.naa.dDd().mFanItems, this.naa.dDd().mMicStatus, str3, z4, this.naa.dDd().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mWV != null) {
                                this.mWV.setVisibility(8);
                            }
                            if (this.mYn != null && this.mYn.isShown()) {
                                this.mYn.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mXM != onlineVip.mCount || (this.mWS != null && this.mWS.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mXM = onlineVip.mCount;
                        this.mWT = onlineVip.mCount;
                        dDU();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mYk.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mYk.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mYk.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mYG <= 5000) {
                                z2 = false;
                            } else {
                                this.mYG = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mYk.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mYk.addAll(onlineVip.mOnlineVipItems);
                            }
                            dDv();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mYH != null) {
                    if (this.mXQ == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mXQ.mCreatorAvatar;
                        str2 = this.mXQ.mCreatorGender;
                    }
                    this.mYH.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mTr != null && this.mTr.mWq != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mTr.mWq.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mTm != null) {
                                        this.mTm.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mTr.mWq.mInPKMode = true;
                                    this.mTr.mWq.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mTr.mWq.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mTr.mWq.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mTr.mWq.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mTr.mWq.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mTr.mWq.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mTr.mWq.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mTr.mWq.mMode = pkNotifyInfo.mMode;
                                    this.mTr.mWq.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mTs != null) {
                                        this.mTs.g(true, this.mTr.mWq.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dCs().a) {
                                        if (!com.kascend.chushou.b.dCl().e) {
                                            com.kascend.chushou.b.dCl().e = true;
                                            tv.chushou.zues.utils.g.M(this.nab, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dCs().a(this.nab, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mTr.mWq.mAction = 7;
                                    this.mTr.mWq.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mTr.mWq.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mTr.mWq.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mTr.mWq.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mTr.mWq.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mTr.mWq.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mTr.mWq.mMode == 2) {
                                        dDJ();
                                    } else {
                                        dDm();
                                    }
                                    if (this.mTs != null) {
                                        this.mTs.g(false, 0L);
                                        this.mTs.b(this.mTr.mWq, true);
                                        this.mTs.a(this.mYJ + tv.chushou.zues.utils.a.dip2px(this.nab, 52.0f), this.naf);
                                        this.mTs.a(this.mTr.mWq.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mTm != null) {
                                        this.mTm.a(false);
                                    }
                                    this.mTr.mWq.mInPKMode = false;
                                    this.mTr.mWq.mAction = 2;
                                    dDm();
                                    dDJ();
                                    if (this.mTs != null) {
                                        this.mTs.c();
                                    }
                                    this.mTr.b = null;
                                    this.mTr.mWq = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mTr.mWq.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mTr.mWq.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mTr.mWq.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mXQ != null && !h.isEmpty(this.mXQ.mRoomID) && this.mXQ.mRoomID.equals(this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mTr.mWq.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mTs != null) {
                                        this.mTs.a(this.mTr.mWq, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mTr.mWq.copyUpdate(pkNotifyInfo);
                                    if (this.mTs != null) {
                                        this.mTs.a(this.mTr.mWq);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mTr.mWq.copyStop(pkNotifyInfo);
                                        if (this.mTs != null) {
                                            this.mTs.w(this.mTr.mWq.mMaxFreeDuration, this.mTr.mWq.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mTr.mWq.copyResult(pkNotifyInfo);
                                    if (!this.mYi && this.mTs != null) {
                                        int i7 = 1;
                                        if (this.mTr.mWq.destinyInfo != null && this.mTr.mWq.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mTs.a(h.parseInt(this.mTr.mWq.mResult), h.parseLong(this.mTr.mWq.mvpUid), this.mTr.mWq.mvpAvatar, this.mTr.mWq.mvpNickname, this.mTr.mWq.mMaxFreeDuration, this.mTr.mWq.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mTu != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mTu.uid = cycleLiveRoomInfo.uid;
                        this.mTu.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mTu.roomId = cycleLiveRoomInfo.roomId;
                        this.mTu.avatar = cycleLiveRoomInfo.avatar;
                        this.mTu.nickname = cycleLiveRoomInfo.nickname;
                        t(false);
                        if (this.nab != null && (this.nab instanceof VideoPlayer)) {
                            ((VideoPlayer) this.nab).d();
                        }
                    } else {
                        ((VideoPlayer) this.nab).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.naa != null && this.naa.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dCs().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dCs().b().equals(next2.mUserID)) {
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

    public void dDU() {
        if (this.mWS != null) {
            if (this.mTr == null || this.mTr.mWq == null || !this.mTr.mWq.mInPKMode) {
                if (this.mWT > 0) {
                    this.mWS.setVisibility(0);
                    this.mWS.setText(String.format(this.nab.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mWT))));
                    this.mWX.setVisibility(0);
                    return;
                }
                this.mWS.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mWV.setVisibility(0);
            if (this.mWW != null) {
                this.mWW.a(str, z, micStatus, this.naa.dDd().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mWV.setVisibility(8);
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
    public void dDR() {
        int childCount = this.mXS.getChildCount();
        int itemCount = this.mXS.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mXS);
        if (f + childCount >= itemCount) {
            this.mXZ = true;
            if (this.mYa != null) {
                this.mYa.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                v(true);
            }
        }
    }

    public void dEa() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mXT.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mXT.add(1, chatInfo2);
    }

    private void v(boolean z) {
        if (this.mXT == null) {
            this.mXT = new ArrayList<>();
        }
        while (2 < this.mXT.size()) {
            this.mXT.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mXV);
        if (a2 == null) {
            wp(false);
            return;
        }
        this.mXT.addAll(a2);
        int size = this.mXT.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mXT.size(); i++) {
                this.mXT.remove(2);
            }
        }
        wp(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mXW == null) {
            this.mXW = new ArrayList<>();
        }
        this.mXW.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mXY != null && this.mXY.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mXY.contains("2"))) {
                        this.mXW.add(next);
                    } else if (!this.mXY.contains(next.mType)) {
                        this.mXW.add(next);
                    }
                }
                return this.mXW;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mXT == null) {
                    this.mXT = new ArrayList<>(arrayList);
                    dEa();
                    wp(z2);
                    return;
                }
                if (this.mXV == null) {
                    this.mXV = new ArrayList<>();
                }
                this.mXV.addAll(arrayList);
                int size = this.mXV.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mXV.size(); i++) {
                        this.mXV.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mXT.size();
                if (a2 != null) {
                    this.mXT.addAll(a2);
                }
                int size3 = this.mXT.size();
                if (!this.mXZ && this.mYa != null) {
                    this.mYa.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mXT.size(); i3++) {
                        this.mXT.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mXT == null) {
                this.mXT = new ArrayList<>(arrayList);
                dEa();
            } else {
                if (this.mXV == null) {
                    this.mXV = new ArrayList<>();
                }
                this.mXV.clear();
                this.mXV.addAll(arrayList);
                this.mXT.clear();
                dEa();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mXT.addAll(a3);
                }
            }
            wp(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mXX != null) {
                this.mXX.a(this.mXT.size());
                if (i == 1) {
                    this.mXX.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mXX.notifyItemRangeRemoved(i2, i3);
                    this.mXX.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mXX.notifyDataSetChanged();
                }
            }
            if (z || this.mXZ) {
                this.mXZ = true;
                if (this.mYa != null) {
                    this.mYa.setVisibility(8);
                }
                if (z) {
                    this.mXP.scrollToPosition(this.mXT.size() - 1);
                } else {
                    this.mXP.smoothScrollToPosition(this.mXT.size() - 1);
                }
            }
        }
    }

    private void wp(boolean z) {
        if (!this.ah) {
            if (this.mXX != null) {
                this.mXX.a(this.mXT.size());
                this.mXX.notifyDataSetChanged();
            }
            if (z || this.mXZ) {
                this.mXZ = true;
                if (this.mYa != null) {
                    this.mYa.setVisibility(8);
                }
                if (z) {
                    this.mXP.scrollToPosition(this.mXT.size() - 1);
                } else {
                    this.mXP.smoothScrollToPosition(this.mXT.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dCO;
        RoomToast roomToast;
        this.p = false;
        if (this.naa != null && this.naa.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.naa.f.size()) {
                    break;
                } else if (!"2".equals(this.naa.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dEe();
            return;
        }
        if (this.mTI != null) {
            this.mTI.setVisibility(0);
        }
        if (this.mWH != null) {
            this.mWH.setVisibility(0);
        }
        if (this.naa != null) {
            this.mXQ = this.naa.dDf();
            this.mXR = this.naa.dDd();
            if (com.kascend.chushou.b.dCl().c != null && this.mXX != null) {
                this.mXX.a(com.kascend.chushou.b.dCl().c);
                this.mXX.notifyDataSetChanged();
            }
            FullRoomInfo dDd = this.naa.dDd();
            if (dDd != null) {
                if (!h.isEmpty(dDd.mRoomToastList)) {
                    Iterator<RoomToast> it = dDd.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dCs().j())) {
                    a(roomToast);
                }
            }
            if (this.mXQ != null) {
                dEj();
            }
            if (this.mXQ != null && !this.mXQ.mIsSubscribed) {
                RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mXQ == null || !c.this.mXQ.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.naa != null && this.naa.l()) {
                d(true);
            }
        }
        if (this.mXQ != null && this.mXX != null) {
            if (this.mXT != null) {
                this.mXT.clear();
            } else {
                this.mXT = new ArrayList<>();
            }
            this.mXX.a(this.mXQ);
            dEa();
            this.mXX.a(this.mXT.size());
            this.mXX.notifyDataSetChanged();
        }
        dDs();
        N();
        if (this.nab != null && (this.nab instanceof VideoPlayer) && (dCO = ((VideoPlayer) this.nab).dCO()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dCO.mWq, dCO.b);
        }
        this.mXk.h(this.mXQ.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mXQ.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mXo);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dDS() {
        if (this.mXL == null) {
            View inflate = LayoutInflater.from(this.nab).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mVa = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mXL = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.nab, 160.0f), -2);
            this.mXL.setFocusable(false);
            this.mXL.setOutsideTouchable(false);
            this.mXL.setAnimationStyle(a.j.gift_toast_style);
            this.mXL.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dCs().c(roomToast.mToastContent);
            if (this.mXL == null) {
                dDS();
            }
            if (this.mVa != null) {
                this.mVa.setText(roomToast.mToastContent);
            }
            if (!this.mXL.isShowing()) {
                if (this.mXo != null) {
                    this.mXL.showAtLocation(this.mXo, 85, 0, this.mZL.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
                    RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mXL != null) {
                                c.this.mXL.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mXL.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void o(boolean z) {
        if (this.mYC != null) {
            this.mYC.setVisibility(z ? 0 : 8);
        }
        this.mYD = true;
        if (this.nab instanceof VideoPlayer) {
            ((VideoPlayer) this.nab).p();
        }
    }

    private void dEe() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        o(false);
        ((VideoPlayer) this.nab).s();
        dDA();
        dDB();
        if (this.mWZ == null) {
            this.mWZ = (PlayShowRecommendView) ((ViewStub) this.mZL.findViewById(a.f.view_recommend)).inflate();
        }
        this.mWZ.setVisibility(0);
        if (this.naa.dDd() != null && this.naa.dDd().mRoominfo != null && !h.isEmpty(this.naa.dDd().mRoominfo.mRoomID)) {
            dDV();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.naH != null) {
            this.naH.e();
        }
        if (this.mTI != null) {
            this.mTI.setVisibility(4);
        }
        if (this.mWH != null) {
            this.mWH.setVisibility(8);
        }
        if (this.naP != null) {
            this.naP.dQf();
            this.naP.setVisibility(8);
        }
        ww(false);
        a(false, false);
        if (this.mTm != null) {
            this.mTm.a();
        }
    }

    private void dDV() {
        if (this.mWZ != null && this.mWZ.getVisibility() == 0) {
            this.mWZ.a(this.naa.dDd().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void dDH() {
        super.dDH();
        if (this.nab instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.nab;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mXx != null && this.mXx.b()) {
            this.mXx.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mYm);
        if (this.nab != null) {
            if (this.mYm || "10004".equals(((VideoPlayer) this.nab).t)) {
                this.mYm = true;
                if (this.naa != null) {
                    this.naa.f = null;
                    if (this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                        this.naa.dDd().mRoominfo.mGameId = null;
                    }
                }
                dEe();
                return;
            }
            this.mYm = true;
            if (this.nab != null) {
                ((VideoPlayer) this.nab).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mYm = false;
        if (this.mTI != null) {
            this.mTI.setVisibility(0);
        }
        if (this.mWH != null) {
            this.mWH.setVisibility(0);
        }
        if (this.mWZ != null) {
            this.mWZ.setVisibility(8);
        }
        if (this.mZV != null) {
            this.mZV.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mYm = false;
        if (this.mTI != null) {
            this.mTI.setVisibility(0);
        }
        if (this.mWH != null) {
            this.mWH.setVisibility(0);
        }
        if (this.mWZ != null) {
            this.mWZ.setVisibility(8);
        }
        if (this.mZV != null) {
            this.mZV.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mWZ != null) {
            this.mWZ.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dEp()) {
            if (i()) {
                if (i == 404) {
                    if (this.naa != null) {
                        this.naa.f = null;
                        this.naa.dDd().mRoominfo.mGameId = null;
                    }
                    dEe();
                    return;
                }
                tv.chushou.zues.utils.g.Os(a.i.str_getvideosource_failed);
            }
            ww(false);
            o(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.naa != null && this.naa.dDe() != null) {
            a(this.naa.dDe());
        }
        this.p = false;
        if (this.naa == null || this.naa.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.naa.f.size()) {
                if (!"2".equals(this.naa.f.get(i2).mType)) {
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
    public GiftAnimationLayout dDx() {
        if (this.mZL == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mZL.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mXo != null) {
            int size = iconConfig.configs.size();
            this.mXo.removeAllViews();
            if (this.mXq != null) {
                this.mXq.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.nab).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mXo, false);
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
                        if (configDetail.mTargetKey.equals("gift")) {
                            this.mXq.setVisibility(0);
                            this.mXp.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                    public void dz(View view) {
                        ConfigDetail configDetail2 = (ConfigDetail) view.getTag();
                        if (configDetail2 != null) {
                            c.this.b(configDetail2);
                        }
                    }
                });
                this.mXo.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void D() {
        if (this.nab instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCJ = ((VideoPlayer) this.nab).dCJ();
            if (this.naS == null) {
                this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.naS.setVisibility(0);
            this.naS.a(2, dCJ);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mXs != null && this.nab != null) {
            this.mXs.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mXs != null && this.nab != null) {
            this.mXs.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(long j) {
        if (this.mXs != null) {
            this.mXs.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0704a
    public void c(int i) {
        if (this.mXs != null) {
            this.mXs.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void a(int i) {
        if (this.mXr != null) {
            if (this.nab != null) {
                this.mXr.a(((VideoPlayer) this.nab).dCJ(), false);
            }
            this.mXr.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mZL != null) {
            Point hc = tv.chushou.zues.utils.a.hc(this.nab);
            int i = hc.x > hc.y ? 1 : 2;
            if (this.naS == null) {
                this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.naS.setPlayerViewHelper(this.naa);
            this.naS.setVisibility(0);
            this.naS.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mXt != null) {
            this.mXt.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mXt != null) {
            this.mXt.a(bangInfo, str);
        }
        if (this.mTW != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mTW.setText(this.nab.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mTW.setText(this.nab.getString(a.i.str_contribute_tittle));
            } else {
                this.mTW.setText(Html.fromHtml(this.nab.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mWU != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mWU.setText(this.nab.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mWU.setText(this.nab.getString(a.i.str_contribute_tittle));
            } else {
                this.mWU.setText(Html.fromHtml(this.nab.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mXt != null) {
            this.mXt.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.naa != null && !h.isEmpty(this.naa.mSW)) {
            this.mYs = this.naa.mSW.get(0);
            if (this.mYK != null) {
                this.mYK.setVisibility(0);
                this.mYK.a(this.mYs.mCover, 0, 0, 0, 1);
                if (this.mYL != null) {
                    if (this.mYs.mShowClose) {
                        this.mYL.setVisibility(0);
                    } else {
                        this.mYL.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mXt != null) {
            this.mXt.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mZL != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mUu != null) {
            this.mUu.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dEp() && !this.mYi) {
            if (iVar.a == 52) {
                if (this.mXX != null) {
                    this.mXX.a(com.kascend.chushou.b.dCl().c);
                    this.mXX.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mYi && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dEp()) {
                    c.this.u(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mXg != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mXg);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dEp() && !this.mYi) {
            if (bVar.a == 1) {
                q(false);
                com.kascend.chushou.toolkit.a.c.a(this.nab, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCK = ((VideoPlayer) this.nab).dCK();
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(2, dCK);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCL = ((VideoPlayer) this.nab).dCL();
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(2, dCL);
            } else if (bVar.a == 8) {
                if (this.mYu != null && this.mYu.getVisibility() != 0) {
                    this.mYu.a(a.C0691a.slide_in_bottom_danmu_anim, a.C0691a.slide_out_bottom_danmu_anim, this.mXQ == null ? "" : this.mXQ.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.naS == null) {
                    this.naS = (H5Container) ((ViewStub) this.mZL.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.naS.setVisibility(0);
                this.naS.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dEp() && this.naa != null && !h.isEmpty(this.naa.a) && this.naa.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mYu != null && this.mYu.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.nab, 80.0f);
                }
                if (this.mYt != null && this.mYt.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mYt.getHeight());
                }
                this.mYF.setTranslationY(-r0);
                return;
            }
            if (this.mYE != null) {
                this.mYE.cancel();
                this.mYE = null;
            }
            int translationY = (int) this.mYF.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.nab, 80.0f) : 0;
                    if (this.mYt != null && this.mYt.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mYt.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mYt.getHeight() : 0;
                    if (this.mYu != null && this.mYu.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.nab, 80.0f));
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
        this.mYE = ValueAnimator.ofInt(i, i2);
        this.mYE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dEp() && c.this.mXt != null) {
                    c.this.mYF.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mYE.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mYE = null;
            }
        });
        this.mYE.setInterpolator(new LinearInterpolator());
        this.mYE.setDuration(800L);
        this.mYE.start();
    }

    private boolean dEf() {
        if (this.mYp == 1) {
            this.mYp = 2;
            ws(true);
            return true;
        } else if (this.mYp == 3) {
            dEi();
            return true;
        } else {
            return false;
        }
    }

    private boolean dEg() {
        if (this.mYp == 1) {
            return dEh();
        }
        if (this.mYp == 2) {
            this.mYp = 1;
            ws(false);
            return true;
        }
        return false;
    }

    private boolean dEh() {
        if (this.mYq || this.naa == null || this.naa.dDf() == null) {
            return false;
        }
        if (this.mZm != null) {
            this.mZm.a(true);
        }
        this.mYp = 3;
        this.mYq = true;
        dEj();
        this.mWE.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.mYq = false;
                c.this.mWG.setVisibility(8);
            }
        });
        this.mWG.startAnimation(loadAnimation);
        this.mWE.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEi() {
        if (!this.mYq) {
            if (this.mZm != null) {
                this.mZm.a(false);
            }
            this.mYp = 1;
            this.mYq = true;
            dEj();
            this.mWG.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.mYq = false;
                    c.this.mWE.setVisibility(8);
                }
            });
            this.mWG.startAnimation(loadAnimation);
            this.mWE.startAnimation(loadAnimation2);
        }
    }

    private void dEj() {
        if (this.mZL != null) {
            if (this.mWE == null) {
                this.mWE = this.mZL.findViewById(a.f.user_space_container);
            }
            if (this.mWG == null) {
                this.mWG = this.mZL.findViewById(a.f.video_container);
            }
            if (this.mWF == null) {
                this.mWF = com.kascend.chushou.view.user.b.b(null, this.naa.a, false, this.naa.h);
                this.mWF.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dEi();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dEi();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mWF).commitAllowingStateLoss();
            }
        }
    }

    private void ws(boolean z) {
        Animation loadAnimation;
        if (this.mWH != null) {
            this.mWH.setVisibility(z ? 8 : 0);
        }
        if (this.mXN != null) {
            this.mYq = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mXN.setVisibility(8);
                        c.this.mYq = false;
                    }
                });
            } else {
                this.mYq = true;
                loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mXN.setVisibility(0);
                        c.this.mYq = false;
                    }
                });
            }
            this.mXN.startAnimation(loadAnimation);
        }
        dDz();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mXa.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mXi != null) {
                this.mXi.setVisibility(0);
            }
            if (this.mXj != null) {
                this.mXj.a();
                return;
            }
            return;
        }
        if (this.mXl != null) {
            this.mXl.setVisibility(0);
        }
        if (this.mXm != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mXm.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mXl != null) {
            this.mXl.setVisibility(8);
        }
        if (this.mXm != null) {
            this.mXm.clearAnimation();
        }
        if (this.mXi != null) {
            this.mXi.setVisibility(8);
        }
        if (this.mXj != null) {
            this.mXj.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mXN != null && this.mZL != null) {
            if (this.mYu == null) {
                this.mYu = new com.kascend.chushou.player.ui.miniview.a(this.nab, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mYu != null && c.this.mZL != null && c.this.mYu.a()) {
                            ((ViewGroup) c.this.mZL).removeView(c.this.mYu);
                            c.this.mYu = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYu.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.nab, 52.0f);
                this.mYu.setLayoutParams(layoutParams);
                ((ViewGroup) this.mXN).addView(this.mYu, ((ViewGroup) this.mXN).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mYu.setVisibility(8);
                } else {
                    this.mYu.a(a.C0691a.slide_in_bottom_danmu_anim, a.C0691a.slide_out_bottom_danmu_anim, this.naa.a == null ? "" : this.naa.a);
                }
            } else if (!this.mYu.isShown()) {
                this.mYu.a(a.C0691a.slide_in_bottom_danmu_anim, a.C0691a.slide_out_bottom_danmu_anim, this.naa.a == null ? "" : this.naa.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mYB != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mYB.setVisibility(0);
                this.mYB.setAnim(true);
                this.mYB.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.oad, b.C0817b.oae, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mYb != null && this.mYb.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dEk();
                    }
                });
                this.mYb.setVisibility(0);
                this.mYb.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mYb != null && this.mYb.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mYd != null) {
                        c.this.mYd.removeAllListeners();
                        c.this.mYd.cancel();
                        c.this.mYd = null;
                    }
                    if (c.this.mYb != null) {
                        c.this.mYb.setVisibility(8);
                    }
                }
            });
            this.mYb.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mYI == null) {
                this.mYI = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dEp()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.nab, "显示双击666_num", null, new Object[0]);
                            if (c.this.naa != null) {
                                c.this.naa.b(false);
                            }
                            c.this.d(false);
                            c.this.wt(true);
                        }
                    }
                };
                if (this.nac != null) {
                    this.nac.d(this.mYI, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mYI != null) {
            this.nac.removeCallbacks(this.mYI);
            this.mYI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wt(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mYe != null && this.mYe.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.nab, a.C0691a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dEl();
                    }
                });
                this.mYe.setVisibility(0);
                this.mYe.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mZK, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.wt(false);
                    }
                });
            }
        } else if (this.mYe != null && this.mYe.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.nab, a.C0691a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mYg != null) {
                        c.this.mYg.removeAllListeners();
                        c.this.mYg.cancel();
                        c.this.mYg = null;
                    }
                    if (c.this.mYe != null) {
                        c.this.mYe.setVisibility(8);
                    }
                }
            });
            this.mYe.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dEk() {
        if (this.mYb == null || this.mYc == null) {
            return null;
        }
        if (this.mYd != null) {
            this.mYd.removeAllListeners();
            this.mYd.cancel();
            this.mYd = null;
        }
        this.mYc.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mYc, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mYc, 0.0f);
        int measuredWidth = (this.mYb.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nab, 13.0f) * 2)) - this.mYc.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mYc, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mYc, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mYc, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mYd != null) {
                    c.this.mYd.removeAllListeners();
                    c.this.mYd.cancel();
                    c.this.mYd = null;
                }
                RxExecutor.postDelayed(c.this.mZK, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dEk();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mYd = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dEl() {
        if (this.mYe == null || this.mYf == null) {
            return null;
        }
        if (this.mYg != null) {
            this.mYg.removeAllListeners();
            this.mYg.cancel();
            this.mYg = null;
        }
        this.mYf.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mYf, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mYf, 0.0f);
        int measuredWidth = (this.mYe.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.nab, 13.0f) * 2)) - this.mYf.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mYf, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mYf, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mYf, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mYg != null) {
                    c.this.mYg.removeAllListeners();
                    c.this.mYg.cancel();
                    c.this.mYg = null;
                }
                RxExecutor.postDelayed(c.this.mZK, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dEl();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mYg = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mZm = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mTu != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mTu.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dEp()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Os(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Os(a.i.subscribe_success);
                            }
                            if (c.this.mTu != null) {
                                c.this.mTu.isSubscribe = !z;
                                c.this.dDt();
                                return;
                            }
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dEp()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dCo().a(bVar, (String) null, this.mTu.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mTu.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dCo().b(bVar, (String) null, c.this.mTu.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.naa != null && this.mXQ != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.naa.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.naa.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mXQ.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dEp()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Os(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Os(a.i.subscribe_success);
                            }
                            c.this.mXQ.mIsSubscribed = !z;
                            c.this.dDu();
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dEp()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dCo().a(bVar, (String) null, this.mXQ.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mXQ.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dCo().b(bVar, (String) null, c.this.mXQ.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mWp != null) {
            int width = this.mWp.getWidth();
            int height = this.mWp.getHeight();
            if (this.mYz != width || this.mYA != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mZL != null) {
            if (this.mXn == null) {
                this.mXn = (InteractionView) ((ViewStub) this.mZL.findViewById(a.f.view_interaction)).inflate();
                this.mXn.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mXn.a();
                    }
                });
            }
            if (this.mXn != null) {
                this.mXn.b(configDetail);
                this.mXn.c();
                this.mXn.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQQ()) {
                tv.chushou.zues.utils.g.M(this.nab, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.nab, null) && (this.nab instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.naa != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nab, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.nab, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.naa != null) {
                com.kascend.chushou.toolkit.a.c.a(this.nab, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.nab, configDetail.mUrl, this.nab.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.nab, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    if (this.mYl) {
                        dDM();
                        return;
                    }
                    if (this.nab.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.nab, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.naa != null && this.naa.dDd() != null && this.naa.dDd().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.naa.dDd().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dB(this.mXo);
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
        if (this.nab != null && !this.v && !h.isEmpty(str) && this.mXQ != null && str.equals(this.mXQ.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mTr == null) {
                this.mTr = new com.kascend.chushou.player.e.a();
            }
            this.mTr.b = str;
            this.mTr.mWq.copy(pkNotifyInfo);
            if (this.mTr.mWq.mAction == 6) {
                if (this.mTm != null) {
                    this.mTm.a(true);
                }
                this.mTr.mWq.mInPKMode = true;
                this.u = this.mTr.mWq.mPkId;
            } else if (this.mTr.mWq.mAction == 7 || (this.mTr.mWq.mMode == 1 && this.mTr.mWq.mAction == 5)) {
                if (this.mTm != null) {
                    this.mTm.a(true);
                }
                this.mTr.mWq.mInPKMode = true;
                if (this.mYx != 42) {
                    this.mYJ = ((this.mYy.y - ((this.mYy.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.nab, 158.0f) + this.mXJ)) - tv.chushou.zues.utils.systemBar.b.aE(getActivity());
                    dDJ();
                }
                this.u = this.mTr.mWq.mPkId;
                if (this.mTs != null) {
                    this.mTs.b(this.mTr.mWq, false);
                    this.mTs.a(this.mTr.mWq.mMode, (String) null);
                    if (this.mTr.mWq.mAction == 5 && this.mTr.mWq.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mTr.mWq.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mTr.mWq.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mTr.mWq.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mTr.mWq.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mTr.mWq.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mTs.a(this.mTr.mWq);
                        this.mTs.a(parseInt, this.mTr.mWq.mPkUpdateInfo.remainDuration, j, this.mTr.mWq.mMode, (this.mTr.mWq.destinyInfo == null || this.mTr.mWq.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mTr.mWq.mPkUpdateInfo != null && !h.isEmpty(this.mTr.mWq.mPkUpdateInfo.specialMomentList) && this.mTs != null) {
                    this.mTs.a(this.mTr.mWq, true);
                }
                if (this.mTr.mWq.mMode == 2) {
                    dDJ();
                } else {
                    dDm();
                }
            } else {
                this.mTr.mWq.mInPKMode = false;
                if (this.mTr.mWq.mMode == 2) {
                    dDJ();
                } else {
                    dDm();
                }
            }
        }
    }

    public void dDm() {
        dDG();
        dDF();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mXG != null && this.naa != null && this.naa.mSY != null) {
            this.mXG.setText(tv.chushou.zues.utils.b.Or(this.naa.mSY.count));
            this.mXG.setVisibility(0);
            if (this.naa.mSY.count < 1) {
                dEn();
            }
            if (this.mXz != null) {
                this.mXz.setText(this.naa.mSY.primaryName);
            }
            if (this.mXA != null) {
                this.mXA.setText(this.naa.mSY.desc);
            }
            dDn();
        }
    }

    public void dDn() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mXH * h.parseLong(this.naa.mSY.point)));
        if (this.mUP != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.nab.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.nab, a.e.icon_coin_new);
            cVar.append(this.nab.getString(a.i.str_buy_count_coin2));
            this.mUP.setText(cVar);
        }
    }

    private void dEm() {
        if (com.kascend.chushou.d.e.c(this.nab, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mXH);
        }
    }

    private void dEn() {
        this.mXI = false;
        this.mXF.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.naa != null && this.naa.mSY != null) {
            if (this.naa.mSY.count < 1) {
                this.mXG.setVisibility(8);
            } else {
                this.mXG.setVisibility(0);
                this.mXG.setSelected(false);
                this.mXG.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mXy.setVisibility(8);
        if (this.mXg != null) {
            this.mXg.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mTw != null) {
            if (z) {
                this.mTw.setVisibility(0);
            } else {
                this.mTw.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mZj != null) {
            this.mZj.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mXp != null) {
            this.mXp.performClick();
        }
    }
}
