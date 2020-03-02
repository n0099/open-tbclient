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
    private View mRI;
    public String mRP;
    private TextView mRT;
    private TextView mRW;
    private TextView mSR;
    private ImageView mSb;
    private TextView mSl;
    private KPSwitchPanelLinearLayout mSu;
    private ImageView mSv;
    private tv.chushou.zues.widget.kpswitch.b.c mSx;
    private d.a mSy;
    private TextView mTc;
    private View mTf;
    private int mUH;
    private View mUI;
    private View mUJ;
    private com.kascend.chushou.view.user.b mUK;
    private View mUL;
    private FrameLayout mUM;
    private LinearLayout mUN;
    private RelativeLayout mUO;
    private FrescoThumbnailView mUP;
    private TextView mUQ;
    private TextView mUR;
    private TextView mUS;
    private FrescoThumbnailView mUT;
    private TextView mUU;
    private TextView mUV;
    private TextView mUW;
    private int mUX;
    private TextView mUY;
    private LinearLayout mUZ;
    private TextView mUg;
    private f mVA;
    private PlayShowH5View mVB;
    private LinearLayout mVC;
    private TextView mVD;
    private TextView mVE;
    private TextView mVF;
    private TextView mVG;
    private TextView mVH;
    private TextView mVI;
    private ImageView mVJ;
    private TextView mVK;
    private PopupWindow mVP;
    private View mVR;
    private RecyclerView mVT;
    private RoomInfo mVU;
    private RecyclerView.LayoutManager mVW;
    private ArrayList<ChatInfo> mVX;
    private ArrayList<ChatInfo> mVY;
    private ArrayList<ChatInfo> mVZ;
    private PlayShowMicStatusView mVa;
    private RecyclerView mVb;
    private ImageView mVc;
    private PlayShowRecommendView mVd;
    private View mVe;
    private RelativeLayout mVf;
    private AnimationSet mVg;
    private ImageView mVh;
    private ImageView mVi;
    private RelativeLayout mVj;
    private PastedEditText mVk;
    private ToggleButton mVl;
    private RelativeLayout mVm;
    private PaoPaoView mVn;
    private FrescoThumbnailView mVo;
    private LinearLayout mVp;
    private ImageView mVq;
    private InteractionView mVr;
    private LinearLayout mVs;
    private FrescoThumbnailView mVt;
    private FrameLayout mVu;
    private RedpacketNotifier mVv;
    private InteractNotifier mVw;
    private EmbeddedButtonLayout mVx;
    private GiftAnimationLayout mVy;
    private com.kascend.chushou.player.b.a mVz;
    private int mWA;
    private int mWB;
    private Point mWC;
    private FrescoThumbnailView mWF;
    private FrescoThumbnailView mWG;
    private ValueAnimator mWI;
    private LinearLayout mWJ;
    private long mWK;
    private VideoShowVoteView mWL;
    private Runnable mWN;
    private FrescoThumbnailView mWP;
    private ImageView mWQ;
    private RelativeLayout mWR;
    private TextView mWS;
    private ImageView mWT;
    private EditText mWU;
    private View mWV;
    private RelativeLayout mWW;
    private RelativeLayout mWX;
    private FrescoThumbnailView mWY;
    private TextView mWZ;
    private ArrayList<ChatInfo> mWa;
    private Button mWe;
    private View mWf;
    private View mWg;
    private Animator mWh;
    private View mWi;
    private View mWj;
    private Animator mWk;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mWn;
    private PlayShowMicPerson mWr;
    private FoodView mWv;
    public ListItem mWw;
    private FoodView mWx;
    private com.kascend.chushou.player.ui.miniview.a mWy;
    private int mWz;
    private TextView mXa;
    private ImageView mXb;
    private RelativeLayout mXc;
    private LinearLayout mXd;
    private TextView mXe;
    private TextView mXf;
    private RelativeLayout mXg;
    private RelativeLayout mXh;
    private FrescoThumbnailView mXi;
    private TextView mXj;
    private TextView mXk;
    private ImageView mXl;
    private RelativeLayout mXm;
    private TextView mXo;
    private float mXp;
    private float mXq;
    private a mXr;
    private boolean mSw = false;
    private int mVL = 1;
    private boolean mVM = false;
    private int mVN = 0;
    private int mVO = 0;
    private int mVQ = -1;
    private boolean mVS = false;
    private FullRoomInfo mVV = null;
    private com.kascend.chushou.player.adapter.a mWb = null;
    private ArrayList<String> mWc = null;
    private boolean mWd = true;
    private boolean mWl = true;
    private boolean mWm = false;
    public final List<OnlineVipItem> mWo = new ArrayList();
    private boolean mWp = false;
    private boolean mWq = false;
    private long mWs = 0;
    private int mWt = 1;
    private boolean mWu = false;
    private int mWD = -1;
    private int mWE = -1;
    private boolean mWH = false;
    private int mWO = -1;
    private io.reactivex.disposables.b mXn = null;

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
        this.mRP = getArguments().getString("cover");
        this.mWl = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mXQ = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mXQ;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dDO()) {
            dCR();
            this.mUu = ((VideoPlayer) this.mYg).dCc();
            this.mYf = ((VideoPlayer) this.mYg).dCf();
            dA(view);
            dDf();
            if (this.mYg instanceof VideoPlayer) {
                ((VideoPlayer) this.mYg).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mWm = false;
        if (this.mYL != null) {
            this.mYL.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWm = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mWh != null) {
            this.mWh.removeAllListeners();
            this.mWh.cancel();
            this.mWh = null;
        }
        if (this.mWk != null) {
            this.mWk.removeAllListeners();
            this.mWk.cancel();
            this.mWk = null;
        }
        if (this.mVw != null) {
            this.mVw.c();
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
        if (this.mXn != null) {
            this.mXn.dispose();
            this.mXn = null;
        }
        this.mVL = 1;
        this.mVM = false;
        if (this.mYh != null) {
            this.mYh.cq(null);
        }
        if (this.mVP != null) {
            this.mVP.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mYg, this.mSx);
        if (this.mYg != null && (this.mYg instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYg).dCi();
        }
        this.mSy = null;
        this.mSx = null;
        dCP();
        if (this.mVz != null) {
            this.mVz.a();
        }
        if (this.mVn != null) {
            this.mVn.b();
            this.mVn.c();
            this.mVn = null;
        }
        super.d();
    }

    private void dCP() {
        tv.chushou.zues.a.a.cr(this);
        if (this.mVZ != null) {
            this.mVZ.clear();
        }
        if (this.mVX != null) {
            this.mVX.clear();
        }
        if (this.mWa != null) {
            this.mWa.clear();
        }
        if (this.mVY != null) {
            this.mVY.clear();
        }
        if (this.mWc != null) {
            this.mWc.clear();
        }
        if (this.mWb != null) {
            this.mWb.a(0);
            this.mWb.a();
        }
    }

    private void dA(View view) {
        this.mUI = view.findViewById(a.f.fl_root);
        this.mWC = tv.chushou.zues.utils.a.he(this.mYg);
        this.mVN = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYg);
        this.mVO = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        this.mWB = 86;
        this.mYf = ((VideoPlayer) this.mYg).dCf();
        if (this.mYf != null) {
            this.mVU = this.mYf.dCG();
            this.mVV = this.mYf.dCE();
        }
        this.mVX = new ArrayList<>();
        this.mVZ = new ArrayList<>();
        this.mVY = new ArrayList<>();
        this.mUM = (FrameLayout) this.mXQ.findViewById(a.f.fl_effect);
        b();
        this.mYa = (PlayerErrorView) this.mXQ.findViewById(a.f.view_net_error_msg);
        this.mYa.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mVm = (RelativeLayout) this.mXQ.findViewById(a.f.rl_audio_ani);
        this.mVn = (PaoPaoView) this.mXQ.findViewById(a.f.audio_ani);
        this.mVo = (FrescoThumbnailView) this.mXQ.findViewById(a.f.audio_ani_avatar);
        this.mVp = (LinearLayout) this.mXQ.findViewById(a.f.ll_audio);
        this.mUg = (TextView) this.mXQ.findViewById(a.f.tv_open_video);
        this.mVq = (ImageView) this.mXQ.findViewById(a.f.iv_audio_ani);
        this.mWG = (FrescoThumbnailView) this.mXQ.findViewById(a.f.live_cover);
        if (!this.mWH || this.mUu == null || this.mUu.getPlayState() != 4) {
            this.mWG.setVisibility(0);
            this.mWG.setBlur(true);
            this.mWG.i(this.mRP, 0, 0, 0);
        }
        this.mUg.setOnClickListener(this);
        this.mRu = new b();
        this.mRu.a(view, null, this.mYg, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dPY()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mYf != null) {
                    append.append(c.this.mYf.dCG().mRoomID);
                }
                if (c.this.mRt != null && c.this.mRt.mUv != null) {
                    append.append("&mode=").append(c.this.mRt.mUv.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mYg, append.toString());
            }
        });
        this.mRy = (VoiceInteractionView) this.mXQ.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mYf != null) {
            this.mVU = this.mYf.dCG();
            this.mVV = this.mYf.dCE();
        }
        dCS();
        dCQ();
        dCX();
        this.mWJ = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mWv = (FoodView) view.findViewById(a.f.rav_ad);
        this.mWP = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mWQ = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mWP.setOnClickListener(this);
        this.mWQ.setOnClickListener(this);
        this.mWR = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mWF = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mWF.setOnClickListener(this);
        this.mVw = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mVv = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mWe = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mWe.setOnClickListener(this);
        this.mVT = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mVT.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVT.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mWC.x, this.mWC.y) * 0.83d);
        this.mVT.setLayoutParams(layoutParams);
        this.mVW = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mYg);
        this.mVT.setLayoutManager(this.mVW);
        this.mVT.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mVT.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mVT.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dDr();
                } else if (i == 1) {
                    c.this.mWd = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mWb = new com.kascend.chushou.player.adapter.a(this.mYg, this.mVX);
        if (this.mVU != null) {
            this.mWb.a(this.mVU);
        }
        if (com.kascend.chushou.b.dBN().c != null) {
            this.mWb.a(com.kascend.chushou.b.dBN().c);
        }
        this.mVT.setAdapter(this.mWb);
        this.mWb.a(this.mVX.size());
        this.mWb.notifyDataSetChanged();
        if (this.mYf != null && (c = this.mYf.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mVz != null) {
            this.mVz.a();
            this.mVz = null;
        }
        this.mVy = (GiftAnimationLayout) this.mXQ.findViewById(a.f.ll_gift_animation);
        this.mVy.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mUH = ((int) (tv.chushou.zues.utils.a.hd(this.mYg).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYg, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVy.getLayoutParams();
        layoutParams2.bottomMargin = this.mUH;
        this.mVy.setLayoutParams(layoutParams2);
        if (this.mYf != null) {
            this.mVz = new com.kascend.chushou.player.b.a(this.mYg.getApplicationContext(), this.mVy);
            this.mVz.a(this.mYf);
            a(this.mYf.mQZ, this.mYf.mRe);
        }
        this.mXQ.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mVx = (EmbeddedButtonLayout) this.mXQ.findViewById(a.f.embedded_button_layout);
        this.mVx.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mWL = (VideoShowVoteView) this.mXQ.findViewById(a.f.view_video_show_vote);
        this.mWL.setOnClickListener(this);
        this.mWL.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dDn();
            }
        });
        if (this.mYf != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
            this.mVx.a(videoPlayer.dCo().dDV());
            this.mVx.b(this.mYf.i());
            this.mVv.a(videoPlayer.dCk(), false);
            this.mVw.a(videoPlayer.dCl(), videoPlayer.dCm(), videoPlayer.dCn());
            this.mRt = new com.kascend.chushou.player.e.a();
        }
        this.mYV = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mWp = false;
                c.this.b(c.this.mUH, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mWp = true;
                if (c.this.mYL != null) {
                    c.this.mYL.measure(0, 0);
                    int measuredHeight = c.this.mYL.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mYg, 14.0f);
                    if (measuredHeight > c.this.mUH) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mYP = (PaoGuideView) this.mXQ.findViewById(a.f.rlPaoGuideView);
        this.mWr = (PlayShowMicPerson) this.mXQ.findViewById(a.f.rl_mic_person_view);
        this.mVB = (PlayShowH5View) this.mXQ.findViewById(a.f.rl_playshowh5);
        this.mWx = (FoodView) this.mXQ.findViewById(a.f.bottom_ad);
        if (this.mYf != null) {
            H();
            if (this.mYf.mQT != null && !h.isEmpty(this.mYf.mQT.mUrl)) {
                b(this.mYf.mQT);
            }
        }
        this.mWf = this.mXQ.findViewById(a.f.view_reminder_subscribe);
        this.mWg = this.mWf.findViewById(a.f.spash_subscribe);
        ((TextView) this.mWf.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().O(this.mYg, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.mYg.getString(a.i.videoplayer_reminder_subscribe)));
        this.mWf.setOnClickListener(this);
        this.mWi = this.mXQ.findViewById(a.f.view_reminder_danmaku);
        this.mWj = this.mWi.findViewById(a.f.spash_danmaku);
        ((TextView) this.mWi.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().O(this.mYg, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.mYg.getString(a.i.videoplayer_reminder_danmaku)));
        this.mWi.setOnClickListener(this);
    }

    private void dCQ() {
        this.mWW = (RelativeLayout) this.mXQ.findViewById(a.f.rl_cyclelive);
        this.mWX = (RelativeLayout) this.mXQ.findViewById(a.f.rlrl_cyclelive);
        this.mWY = (FrescoThumbnailView) this.mXQ.findViewById(a.f.iv_liveicon);
        this.mWZ = (TextView) this.mXQ.findViewById(a.f.tv_livename);
        this.mXa = (TextView) this.mXQ.findViewById(a.f.tv_livedesc);
        this.mXb = (ImageView) this.mXQ.findViewById(a.f.iv_cyclelive_name_menu);
        this.mXc = (RelativeLayout) this.mXQ.findViewById(a.f.rl_normal);
        this.mXd = (LinearLayout) this.mXQ.findViewById(a.f.ll_cyclelive_nickname);
        this.mXe = (TextView) this.mXQ.findViewById(a.f.tv_cyclelive_nickname);
        this.mXf = (TextView) this.mXQ.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mXg = (RelativeLayout) this.mXQ.findViewById(a.f.rl_clear_cyclelive);
        this.mXh = (RelativeLayout) this.mXQ.findViewById(a.f.rlrl_clear_cyclelive);
        this.mXi = (FrescoThumbnailView) this.mXQ.findViewById(a.f.iv_clear_liveicon);
        this.mXj = (TextView) this.mXQ.findViewById(a.f.tv_clear_livename);
        this.mXk = (TextView) this.mXQ.findViewById(a.f.tv_clear_livedesc);
        this.mXl = (ImageView) this.mXQ.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mXm = (RelativeLayout) this.mXQ.findViewById(a.f.rl_clear_normal);
        this.mXl.setOnClickListener(this);
        this.mXb.setOnClickListener(this);
        this.mXf.setOnClickListener(this);
        this.mXe.setOnClickListener(this);
        this.mWY.setOnClickListener(this);
        this.mXi.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mYf.mQR != null && this.mWx != null) {
            this.mWx.a(true, this.mYf.a == null ? "" : this.mYf.a);
            this.mWx.a(this.mYf.mQR, a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mYf != null && this.mYf.mQY != null && this.mVx != null) {
            this.mWv.a(this.mYf.mQY, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mYf != null) {
                        c.this.mYf.mQY = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDo() {
        return this.mVz;
    }

    private void dCR() {
        this.mYh = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mXQ != null && (textView = (TextView) c.this.mXQ.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mYg.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mYh.K(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mYh);
                        break;
                    case 12:
                        c.this.b(c.this.mYh);
                        break;
                    case 17:
                        c.this.dDR();
                        break;
                    case 18:
                        c.this.cXL();
                        break;
                    case 19:
                        c.this.mYe.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mVS) {
            this.mVS = true;
            if (this.mVR == null) {
                this.mVR = this.mXQ.findViewById(a.f.vs_async_show_content);
                this.mVR = ((ViewStub) this.mVR).inflate();
            }
            this.mRI = this.mXQ.findViewById(a.f.ui_content);
            if (this.mTf == null) {
                this.mTf = this.mXQ.findViewById(a.f.vs_async_notification_view);
                this.mTf = ((ViewStub) this.mTf).inflate();
            }
            c(this.mXQ);
            k();
            cXM();
            if (this.c == null) {
                this.mRo = new d.a();
                this.c = new GestureDetector(this.mYg, this.mRo);
            }
            ((VideoPlayer) this.mYg).q();
        }
    }

    private void dCS() {
        this.mUN = (LinearLayout) this.mXQ.findViewById(a.f.ll_anchor);
        this.mUO = (RelativeLayout) this.mXQ.findViewById(a.f.ll_clear_anchor);
        this.mUN.setVisibility(4);
        this.mUO.setVisibility(4);
        this.mUP = (FrescoThumbnailView) this.mXQ.findViewById(a.f.iv_clear_avatar);
        this.mUQ = (TextView) this.mXQ.findViewById(a.f.tv_clear_nickname);
        this.mUR = (TextView) this.mXQ.findViewById(a.f.tv_clear_online_count);
        this.mUS = (TextView) this.mXQ.findViewById(a.f.tv_clear_btn_subscribe);
        this.mUS.setOnClickListener(this);
        this.mUT = (FrescoThumbnailView) this.mXQ.findViewById(a.f.iv_avatar);
        this.mUU = (TextView) this.mXQ.findViewById(a.f.tv_nickname_test);
        this.mUV = (TextView) this.mXQ.findViewById(a.f.tv_online_count);
        this.mRT = (TextView) this.mXQ.findViewById(a.f.tv_btn_subscribe);
        this.mRT.setOnClickListener(this);
        this.mUW = (TextView) this.mXQ.findViewById(a.f.tv_loyal_counts);
        this.mRW = (TextView) this.mXQ.findViewById(a.f.tv_btn_contribution);
        this.mUY = (TextView) this.mXQ.findViewById(a.f.tv_btn_contribution_forpk);
        this.mRW.setVisibility(4);
        this.mUY.setVisibility(8);
        this.mUZ = (LinearLayout) this.mXQ.findViewById(a.f.ll_mic);
        this.mVa = (PlayShowMicStatusView) this.mXQ.findViewById(a.f.show_mic_status);
        this.mVb = (RecyclerView) this.mXQ.findViewById(a.f.rv_loyal);
        this.mVc = (ImageView) this.mXQ.findViewById(a.f.iv_clear_close);
        this.mSb = (ImageView) this.mXQ.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mVb.setLayoutManager(linearLayoutManager);
        this.mWn = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mWo, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mWo.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mYg, (JSONObject) null, c.this.mYf.dCG().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            }
        }) { // from class: com.kascend.chushou.player.e.c.55
            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, OnlineVipItem onlineVipItem) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // tv.chushou.zues.widget.adapterview.recyclerview.a.a
            public void a(a.View$OnLongClickListenerC0813a view$OnLongClickListenerC0813a, OnlineVipItem onlineVipItem, int i) {
                ImageView imageView = (ImageView) view$OnLongClickListenerC0813a.Oo(a.f.iv_ranking);
                TextView textView = (TextView) view$OnLongClickListenerC0813a.Oo(a.f.tv_score);
                FrescoThumbnailView frescoThumbnailView = (FrescoThumbnailView) view$OnLongClickListenerC0813a.Oo(a.f.iv_avatar);
                if (onlineVipItem != null) {
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dQk(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mYg, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYg, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYg, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYg, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYg, a.c.color_979797), dip2px);
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
        this.mVb.setAdapter(this.mWn);
        this.mUZ.setOnClickListener(this);
        this.mUP.setOnClickListener(this);
        this.mVc.setOnClickListener(this);
        this.mUT.setOnClickListener(this);
        this.mUP.setOnClickListener(this);
        this.mSb.setOnClickListener(this);
        this.mUW.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPY() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mYf != null) {
                    str = str + c.this.mYf.dCG().mRoomID;
                }
                c.this.f(c.this.mYg.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mRW.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPY() + "m/room-billboard/";
                if (c.this.mYf != null) {
                    str = str + c.this.mYf.dCG().mRoomID;
                }
                c.this.f(c.this.mYg.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mUY.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPY() + "m/room-billboard/";
                if (c.this.mYf != null) {
                    str = str + c.this.mYf.dCG().mRoomID;
                }
                c.this.f(c.this.mYg.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        s(true);
    }

    public void s(boolean z) {
        boolean z2;
        if (this.mVV == null || this.mVV.cycleLiveRoomInfo == null || h.isEmpty(this.mVV.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mRw = this.mVV.cycleLiveRoomInfo;
        }
        if (z2 && this.mRw != null) {
            this.mWW.setVisibility(0);
            this.mXg.setVisibility(0);
            this.mXc.setVisibility(8);
            this.mXm.setVisibility(8);
            this.mXd.setVisibility(0);
            this.mXi.h(this.mRw.eventIcon, com.kascend.chushou.view.a.a(this.mVU.mCreatorGender), b.a.small, b.a.small);
            this.mWY.h(this.mRw.eventIcon, com.kascend.chushou.view.a.a(this.mVU.mCreatorGender), b.a.small, b.a.small);
            this.mXj.setText(this.mRw.eventName);
            this.mXk.setText(this.mRw.eventDesc);
            this.mWZ.setText(this.mRw.eventName);
            this.mXa.setText(this.mRw.eventDesc);
            this.mXe.setText(this.mRw.nickname);
            dCU();
            if (z) {
                c(this.mRw.remainTime);
                return;
            }
            return;
        }
        this.mWW.setVisibility(8);
        this.mXg.setVisibility(8);
        this.mXc.setVisibility(0);
        this.mXm.setVisibility(0);
        this.mXd.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mXn != null) {
            this.mXn.dispose();
            this.mXn = null;
        }
        this.mXn = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJi()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mYg != null && (c.this.mYg instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mYg).u();
                }
            }
        });
    }

    private void dCT() {
        if (this.mVU != null && this.mVS) {
            this.mUN.setVisibility(0);
            this.mUO.setVisibility(0);
            this.mRW.setVisibility(0);
            this.mUP.h(this.mVU.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVU.mCreatorGender), b.a.small, b.a.small);
            this.mUQ.setText(this.mVU.mCreatorNickname);
            this.mUT.h(this.mVU.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVU.mCreatorGender), b.a.small, b.a.small);
            this.mUU.setText(this.mVU.mCreatorNickname);
            dDD();
            dCV();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dDD() {
        if (this.mVU != null) {
            this.mUR.setText(tv.chushou.zues.utils.b.formatNumber(this.mVU.mOnlineCount));
            this.mUV.setText(tv.chushou.zues.utils.b.formatNumber(this.mVU.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCU() {
        if (this.mRw != null) {
            if (this.mRw.isSubscribe) {
                this.mXf.setText(a.i.like_already);
                this.mXf.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mXf.setText(getString(a.i.like));
            this.mXf.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCV() {
        if (this.mVU != null) {
            if (this.mVU.mIsSubscribed) {
                this.mUS.setText(getString(a.i.like_already));
                this.mUS.setBackgroundResource(a.e.bg_show_subcribe);
                this.mRT.setText(getString(a.i.like_already));
                this.mRT.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mUS.setText(getString(a.i.like));
            this.mUS.setBackgroundResource(a.e.bg_show_subcribe);
            this.mRT.setText(getString(a.i.like));
            this.mRT.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dCW() {
        if (this.mWn != null) {
            this.mWn.notifyDataSetChanged();
        }
    }

    private void dCX() {
        this.mVe = this.mXQ.findViewById(a.f.tv_interact);
        this.mVe.setOnClickListener(this);
        this.mVj = (RelativeLayout) this.mXQ.findViewById(a.f.rl_edit_bar);
        this.mVh = (ImageView) this.mXQ.findViewById(a.f.btn_hotword);
        this.mVh.setOnClickListener(this);
        this.mVi = (ImageView) this.mXQ.findViewById(a.f.iv_task_badge);
        this.mVg = (AnimationSet) AnimationUtils.loadAnimation(this.mYg, a.C0690a.anim_hotword);
        this.mVg.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dBU().c) {
                    c.this.mVh.clearAnimation();
                    c.this.mVh.startAnimation(c.this.mVg);
                }
            }
        });
        if (com.kascend.chushou.d.h.dBU().c) {
            this.mVh.startAnimation(this.mVg);
            this.mVi.setVisibility(0);
        }
        this.mXo = (TextView) this.mXQ.findViewById(a.f.tv_bottom_input);
        this.mXo.setOnClickListener(this);
        this.mZf = (FrescoThumbnailView) this.mXQ.findViewById(a.f.ll_btn_set);
        this.mZf.setOnClickListener(this);
        this.mZf.xo(a.e.ic_room_set_btn_white);
        this.mVs = (LinearLayout) this.mXQ.findViewById(a.f.ll_bottom_all_button);
        this.mVt = (FrescoThumbnailView) this.mXQ.findViewById(a.f.fl_clear_bottom_gift);
        this.mVt.setAnim(true);
        this.mVt.setOnClickListener(this);
        this.mVt.xo(a.e.ic_show_gift_n);
        this.mVu = (FrameLayout) this.mXQ.findViewById(a.f.flfl_clear_bottom_gift);
        this.mVu.setVisibility(8);
        this.mVf = (RelativeLayout) this.mXQ.findViewById(a.f.rl_bottom_input);
        this.mVf.setVisibility(0);
        this.mVk = (PastedEditText) this.mXQ.findViewById(a.f.et_bottom_input);
        this.mVk.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mSl.setEnabled(editable.length() > 0);
            }
        });
        this.mVk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mSl);
                    return true;
                }
                return true;
            }
        });
        this.mVk.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.mVk);
                }
                return false;
            }
        });
        this.mSv = (ImageView) this.mXQ.findViewById(a.f.iv_btn_emoji);
        this.mSv.setVisibility(8);
        this.mSl = (TextView) this.mXQ.findViewById(a.f.tv_btn_send);
        this.mSl.setOnClickListener(this);
        this.mVC = (LinearLayout) this.mXQ.findViewById(a.f.head_trumpet);
        this.mVC.setVisibility(8);
        this.mVC.setOnClickListener(this);
        this.mVD = (TextView) this.mXQ.findViewById(a.f.tv_primary_name);
        this.mVE = (TextView) this.mXQ.findViewById(a.f.tv_primary_desc);
        this.mVG = (TextView) this.mXQ.findViewById(a.f.tv_cut_count);
        this.mVG.setOnClickListener(this);
        this.mVI = (TextView) this.mXQ.findViewById(a.f.tv_head_count);
        this.mVI.setText(this.mVL + "");
        this.mVH = (TextView) this.mXQ.findViewById(a.f.tv_plus_count);
        this.mVH.setOnClickListener(this);
        this.mSR = (TextView) this.mXQ.findViewById(a.f.tv_buy_count_coin);
        this.mVF = (TextView) this.mXQ.findViewById(a.f.tv_buy_head);
        this.mVF.setOnClickListener(this);
        this.mVJ = (ImageView) this.mXQ.findViewById(a.f.iv_trumpet_select);
        this.mVJ.setOnClickListener(this);
        this.mVK = (TextView) this.mXQ.findViewById(a.f.tv_trumpet_have_count);
        this.mVM = false;
        this.mVJ.setBackgroundResource(a.e.ic_trumpet_n);
        this.mVK.setVisibility(8);
        this.mSu = (KPSwitchPanelLinearLayout) this.mXQ.findViewById(a.f.chat_extended_container);
        dDd();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mSu, this.mSv, this.mVk, new a.InterfaceC0817a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0817a
            public void wi(boolean z) {
                if (c.this.mSv != null) {
                    if (z) {
                        c.this.mSu.setDirectVisibility(0);
                        c.this.mSv.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mSv.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mSy = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wj(boolean z) {
                c.this.mSw = z;
                if (z) {
                    c.this.mSv.setImageResource(a.e.cs_emoji_normal);
                    c.this.dCZ();
                    if (c.this.mWV != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mWV.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ho(c.this.mYg);
                        c.this.mWV.setLayoutParams(layoutParams);
                    }
                    if (c.this.mVj != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mVj.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ho(c.this.mYg);
                        c.this.mVj.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mWV != null && c.this.mWV.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mWV.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mWV.setLayoutParams(layoutParams3);
                    c.this.mWV.setVisibility(8);
                }
                if (c.this.mWp) {
                    c.this.mYL.setVisibility(0);
                }
                if (c.this.mYg != null && (c.this.mYg instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mYg).wh(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mVj != null && c.this.mSu.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mVj.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mVj.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mSx = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mSu, this.mSy, ((VideoPlayer) this.mYg).dCj());
        ((VideoPlayer) this.mYg).g(((VideoPlayer) this.mYg).dCj());
        this.mWV = this.mXQ.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mWS = (TextView) this.mXQ.findViewById(a.f.btn_room_search);
        this.mWT = (ImageView) this.mXQ.findViewById(a.f.iv_room_emoji_delete);
        this.mWU = (EditText) this.mXQ.findViewById(a.f.et_room_emoji_search);
        this.mWU.setImeOptions(3);
        this.mWU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mWS);
                    return true;
                }
                return false;
            }
        });
        this.mWU.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mWS.setEnabled(editable.length() > 0);
                c.this.mWT.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mYL.setEmojiSearchText(editable.toString());
            }
        });
        this.mWS.setOnClickListener(this);
        this.mWT.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mWU);
            this.mWV.setVisibility(0);
            this.mWU.requestFocus();
        } else {
            this.mWV.setVisibility(8);
        }
        if (z2) {
            this.mWU.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCZ() {
        int ho = tv.chushou.zues.widget.kpswitch.b.d.ho(this.mYg) + tv.chushou.zues.utils.a.dip2px(this.mYg, 14.0f);
        if (ho > this.mUH) {
            b(ho, 12);
        }
    }

    private void dDd() {
    }

    private void dDf() {
        if (this.mVO > 0) {
            View findViewById = this.mXQ.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mVO);
        }
        if (this.mVN > 0) {
            View findViewById2 = this.mXQ.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mVN, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mWl) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dDk();
        a();
        this.mRq = ((VideoPlayer) this.mYg).dCg();
        this.mRq.a(this);
        if (this.mYf.dCE() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mRq != null) {
            this.mRq.d();
        }
    }

    private void dDg() {
        if ((this.mRt == null || this.mRt.mUv == null || !this.mRt.mUv.mInPKMode) ? false : true) {
            if (this.mUI != null) {
                this.mUI.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRv.getLayoutParams();
            layoutParams.leftMargin = (this.mWC.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mYg, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mRv.setLayoutParams(layoutParams);
            this.y.setText(this.mRt.mUv.mPkUserNickname);
            this.mRv.setVisibility(0);
            this.mUZ.setVisibility(8);
            return;
        }
        if (this.mUI != null) {
            this.mUI.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mRv.setVisibility(8);
    }

    private void dDh() {
        boolean z = false;
        if (this.mRt != null && this.mRt.mUv != null && this.mRt.mUv.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mWO > 0 && this.mVT != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVT.getLayoutParams();
                if (layoutParams.height != this.mWO) {
                    layoutParams.height = this.mWO;
                    this.mVT.setLayoutParams(layoutParams);
                }
            }
            this.mUH = ((int) (tv.chushou.zues.utils.a.hd(this.mYg).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYg, 84.0f);
            b(this.mUH, 12);
        } else {
            if (this.mVT != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVT.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mYg, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mYg, 250.0f);
                    this.mVT.setLayoutParams(layoutParams2);
                }
            }
            this.mUH = ((int) (tv.chushou.zues.utils.a.hd(this.mYg).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYg, 84.0f);
            b(this.mUH, 12);
        }
        if (this.mRu != null) {
            this.mRu.a(this.mWO + tv.chushou.zues.utils.a.dip2px(this.mYg, 52.0f), this.mYk);
        }
        if (this.mRy != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mRy.getLayoutParams();
            layoutParams3.bottomMargin = this.mWO + tv.chushou.zues.utils.a.dip2px(this.mYg, 52.0f);
            this.mRy.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dDj();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dDj();
    }

    private void dDi() {
        dDh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDj() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dDP().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mWC = tv.chushou.zues.utils.a.he(this.mYg);
        this.mWB = 86;
        this.mWz = (Math.max(this.mWC.x, this.mWC.y) - tv.chushou.zues.utils.a.dip2px(this.mYg, (this.mWB + 52) + 250)) - this.mVN;
        this.mWA = Math.max(this.mWC.x, this.mWC.y) - ((tv.chushou.zues.utils.a.dip2px(this.mYg, this.mWB) + this.mVN) * 2);
        if (this.mWD <= 0 || this.mWE <= 0) {
            this.mWD = Math.min(this.mWC.x, this.mWC.y);
            this.mWE = Math.max(this.mWC.x, this.mWC.y);
        }
        this.ar = Math.min(this.mWC.x, this.mWC.y);
        this.mYk = (this.ar * this.mWE) / this.mWD;
        boolean z = false;
        if (this.mRt == null || this.mRt.mUv == null) {
            i = 1;
        } else {
            i = this.mRt.mUv.mMode;
            if (this.mRt.mUv.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mWB = 42;
            if (i == 2) {
                if (this.mWE < this.mWD) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mYk;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mYk;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mWD * layoutParams.height) / this.mWE;
                    layoutParams2.height = layoutParams.height;
                    this.mYk = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYk;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYk;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, this.mWB) + this.mVN;
            layoutParams.gravity = 48;
            this.mWO = ((this.mWC.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mYg, (this.mWB + 52) + 64) + this.mVN)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
            dCN();
        } else if (this.E) {
            this.mWB = 42;
            if (this.mWE < this.mWD) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYk;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYk;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mWD * layoutParams.height) / this.mWE;
                layoutParams2.height = layoutParams.height;
                this.mYk = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, this.mWB) + this.mVN;
            layoutParams.gravity = 48;
            this.mWO = ((this.mWC.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mYg, (this.mWB + 52) + 98) + this.mVN)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
            dDi();
        } else {
            this.mWO = -1;
            this.mWB = 86;
            if (this.mYk <= this.mWz) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mWz;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, this.mWB) + this.mVN;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYk;
            } else if (this.mYk < this.mWA) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYk;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, this.mWB) + this.mVN;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYk;
            } else {
                this.mYk = Math.max(this.mWC.x, this.mWC.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mYk;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mYk * this.mWD) / this.mWE >= this.ar) {
                        i3 = this.mYk;
                        i2 = (this.mYk * this.mWD) / this.mWE;
                    } else if ((this.ar * this.mWE) / this.mWD >= this.mYk) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mWE) / this.mWD;
                    } else {
                        i2 = this.ar;
                        i3 = this.mYk;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mYk) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mWE) / this.mWD > this.mYk) {
                        i3 = this.mYk;
                        i2 = (this.mYk * this.mWD) / this.mWE;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mWE) / this.mWD;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mWE) / this.mWD;
                        if (i3 > this.mYk) {
                            i3 = this.mYk;
                            i2 = (this.mYk * this.mWD) / this.mWE;
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
        if (this.mYf != null && this.mYf.d) {
            layoutParams.width = Math.min(this.mWC.x, this.mWC.y);
            layoutParams.height = Math.max(this.mWC.x, this.mWC.y);
        }
        dDP().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dDk() {
        this.N = new SurfaceRenderView(this.mYg);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dDP().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mWu) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dDG();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dDF();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mXr != null) {
            this.mXr.a();
        }
        if (this.mYf != null && !h.isEmpty(this.mYf.mRb)) {
            b(this.mYf.mRb);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mUu != null) {
            int width = this.mUu.getWidth();
            int height = this.mUu.getHeight();
            if (this.mWD != width || this.mWE != height || this.mWD <= 0 || this.mWE <= 0) {
                this.mWD = width;
                this.mWE = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dDj();
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
            if (this.mWp) {
                dDm();
            } else {
                if (this.mYg.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYf.dCE().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mVM) {
                f(this.mVk.getText().toString());
            } else {
                a(this.mVk.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dBU().c) {
                com.kascend.chushou.d.h.dBU().b(false);
                this.mVg.cancel();
                this.mVg.reset();
                this.mVh.clearAnimation();
                this.mVi.setVisibility(8);
            }
            k(view, 0, this.mXQ.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mYg, 165.0f) / 2);
            j(view, x >= 0 ? x : 0, this.mXQ.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mYf.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mYf.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mVT != null) {
                u(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mVU != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mWt = 1;
            wk(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mYg, (JSONObject) null, this.mYf.dCG().mRoomID, this.mYf.dCG().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        } else if (id == a.f.ftv_pack) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(8, null));
        } else if (id == a.f.view_reminder_subscribe) {
            a(false);
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            hashMap2.put("_fromPos", "73");
            b(hashMap2);
        } else if (id == a.f.view_reminder_danmaku) {
            wl(false);
            a(this.mYg.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mYg, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mWw != null) {
                    com.kascend.chushou.d.e.a(this.mYg, this.mWw, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mWR != null) {
                    this.mWR.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mYg, null) && this.mYf != null && this.mYf.mRd != null) {
                    if (this.mVM) {
                        dDN();
                    } else {
                        if (this.mYf != null && this.mYf.mRd != null && this.mYf.mRd.count > 0) {
                            this.mVC.setVisibility(8);
                        } else {
                            this.mVC.setVisibility(0);
                        }
                        this.mVM = true;
                        this.mVJ.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mVK.setVisibility(0);
                        this.mVK.setSelected(true);
                        this.mVK.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mVk != null) {
                            this.mVk.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mVL <= 9) {
                    this.mVL++;
                    this.mVI.setText(this.mVL + "");
                }
                dCO();
            } else if (id == a.f.tv_cut_count) {
                if (this.mVL > 1) {
                    this.mVL--;
                    this.mVI.setText(this.mVL + "");
                }
                dCO();
            } else if (id == a.f.tv_buy_head) {
                dDM();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mWU.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mWU.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mWV.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dM(this.mWU);
                    this.mYL.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mRw != null && !h.isEmpty(this.mRw.eventUrl)) {
                    f("", this.mRw.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mRw != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mRw != null) {
                    com.kascend.chushou.d.a.a(this.mYg, (JSONObject) null, this.mRw.roomId, this.mRw.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mYf.a(false);
                    ((VideoPlayer) this.mYg).l();
                } else {
                    ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.mVB != null) {
            int i = (tv.chushou.zues.utils.a.hd(this.mYg).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVB.getLayoutParams();
            layoutParams.topMargin = i;
            this.mVB.setLayoutParams(layoutParams);
            this.mVB.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mVB.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            tv.chushou.zues.utils.g.Om(a.i.str_same_content);
            return false;
        } else if (System.currentTimeMillis() - this.mWs <= 3000) {
            tv.chushou.zues.utils.g.Om(a.i.str_too_fast);
            return false;
        } else {
            cXS();
            if (!com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYg).dCf().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mWs = System.currentTimeMillis();
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                a(this.mYf.dCE().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYf.h);
            }
            g(this.b);
            if (!z && this.mVk != null) {
                this.mVk.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            cXS();
            if (com.kascend.chushou.d.e.c(this.mYg, null) && LoginManager.Instance().getUserInfo() != null && this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                a(this.mYf.dCE().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mVk != null) {
                this.mVk.setText((CharSequence) null);
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
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mYf.dCE().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mYf.dCE().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mYg).mPp;
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
                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.SS(tv.chushou.zues.toolkit.richtext.b.a(chatInfo.mContent, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
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
        if (this.mYF != null && this.mYF.isShowing()) {
            this.mYF.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
        if (this.mZc == null) {
            i(3);
        }
        this.mZc.getContentView().setBackgroundResource(0);
        this.mZc.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mZc.isShowing()) {
            this.mZc.showAtLocation(view, 83, i, i2);
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mYf.dCE().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mZc.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDe() {
        if (h.isEmpty(this.mZg)) {
            if (((VideoPlayer) this.mYg).q) {
                this.mZf.xo(a.e.ic_room_set_btn_white);
            } else {
                this.mZf.xo(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mYg).q && this.mZg.size() == 2 && this.mZg.contains("4") && this.mZg.contains("2")) {
            this.mZf.xo(a.e.ic_room_set_btn_system_white);
        } else if (this.mZg.size() > 1 || !((VideoPlayer) this.mYg).q) {
            this.mZf.xo(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mZg.get(0))) {
            this.mZf.xo(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mZg.get(0))) {
            this.mZf.xo(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mZg.get(0))) {
            this.mZf.xo(a.e.ic_room_set_btn_system_white);
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
        if (this.mYF == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mYF.getContentView().setBackgroundResource(0);
            this.mYF.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mVh.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mYF.isShowing()) {
            this.mYF.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mYg, 16.0f) + i2);
            this.mVh.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYf.dCE().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYF.dismiss();
    }

    private void dB(View view) {
        if (this.mYz == null) {
            dDp();
        }
        if (com.kascend.chushou.d.h.dBU().q()) {
            this.mVl.dQi();
        } else {
            this.mVl.dQj();
        }
        int height = this.mXQ.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (view != null) {
            this.mYz.showAtLocation(view, 85, 0, height);
        }
    }

    private void dDp() {
        if (this.mYz == null) {
            View inflate = LayoutInflater.from(this.mYg).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mVl = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dBU().q()) {
                this.mVl.dQi();
            } else {
                this.mVl.dQj();
            }
            this.mVl.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dBU().g(z);
                }
            });
            this.mYt = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mYu = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mYt.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mYt.setVisibility(0);
            } else {
                this.mYt.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dBU().a) {
                this.mYu.b();
            } else {
                this.mYu.c();
            }
            if (this.mYf != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mYf.f;
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
                                if (this.mRt == null || !this.mRt.mUv.mInPKMode || h.isEmpty(this.mRt.b) || this.mVU == null || !this.mRt.b.equals(this.mVU.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mYg).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dCF = this.mYf.dCF();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mYg).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYg, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, 5.0f);
                                            }
                                            int identifier = this.mYg.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mYg.getPackageName());
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
                                                if (dCF != null && dCF.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mYg.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mYg).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dCF2 = this.mYf.dCF();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mYg).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYg, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, 5.0f);
                                        }
                                        int identifier2 = this.mYg.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mYg.getPackageName());
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
                                            if (dCF2 != null && dCF2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dDq();
                        c.this.mYz.dismiss();
                    }
                }
            });
            this.mYz = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 150.0f), -2);
            this.mYz.setFocusable(true);
            this.mYz.setOutsideTouchable(true);
            this.mYz.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mYz = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDq() {
        if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
            if (this.mVA == null) {
                this.mVA = new f(getActivity());
            }
            this.mVA.a(this.mYf.dCE().mRoominfo, this.ax);
            if (!this.mVA.isShowing()) {
                this.mVA.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mWu) {
            return false;
        }
        if (this.mWt == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mXp = motionEvent.getX();
                    this.mXq = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mXp;
                    if (Math.abs(f) > Math.abs(y - this.mXq) && Math.abs(f) > q && f > 0.0f) {
                        dDI();
                        return true;
                    }
                    this.mXp = 0.0f;
                    this.mXq = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mWV != null && this.mWV.getVisibility() == 0 && b(motionEvent, this.mWV)) {
                this.mWV.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mWU);
                return true;
            } else if (this.mWp && this.mWV != null && this.mWV.getVisibility() == 8 && g(this.mYL.b, motionEvent)) {
                dDm();
                return true;
            } else if (this.mVB != null && this.mVB.b() && g(this.mVB, motionEvent)) {
                this.mVB.a();
                return true;
            } else if (this.mVr != null && this.mVr.b() && g(this.mVr, motionEvent)) {
                this.mVr.a();
                return true;
            } else if (b(motionEvent, this.mVj)) {
                return cXS();
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
            if (this.mYW != null && this.mYW.a(i, keyEvent)) {
                return true;
            }
            if ((this.mVB != null && this.mVB.onKeyDown(i, keyEvent)) || dDa()) {
                return true;
            }
            if (this.mWt == 3) {
                this.mWt = 1;
                dDI();
                return true;
            } else if (this.mVr != null && this.mVr.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mVk != null && this.mVf != null && this.mVj != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mVk);
                this.mVf.setVisibility(8);
                this.mVj.setVisibility(0);
            }
        } else if (this.mVf != null && this.mVj != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
            this.mVf.setVisibility(0);
            this.mVj.setVisibility(8);
        }
    }

    public boolean cXS() {
        boolean z;
        b(this.mUH, 12);
        boolean z2 = false;
        if (this.mSu != null && this.mSu.getVisibility() == 0) {
            this.mSu.setVisibility(8);
            this.mSv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSw) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYg);
            this.mSv.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mVj == null || this.mVj.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mVM) {
                dDN();
            }
            this.mVj.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mVf != null) {
                    c.this.mVf.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dDa() {
        if (cXS()) {
            return true;
        }
        if (this.mYF != null && this.mYF.isShowing()) {
            this.mYF.dismiss();
            return true;
        } else if (this.mZc != null && this.mZc.isShowing()) {
            this.mZc.dismiss();
            return true;
        } else if (this.mYz == null || !this.mYz.isShowing()) {
            return dDm() || dDc() || dDl() || dDb();
        } else {
            this.mYz.dismiss();
            return true;
        }
    }

    public boolean dDb() {
        if (this.mYP == null || !this.mYP.isShown()) {
            return false;
        }
        this.mYP.d();
        return true;
    }

    public boolean dDc() {
        if (this.mWr == null || !this.mWr.isShown()) {
            return false;
        }
        this.mWr.a();
        return true;
    }

    public boolean dDl() {
        if (this.mVB == null || !this.mVB.b()) {
            return false;
        }
        this.mVB.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mYg != null && !((Activity) this.mYg).isFinishing() && pVar != null) {
            this.mWc = pVar.a;
            u(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dDO() && this.mVU != null && mVar.a(this.mVU.mCreatorUID, null)) {
            this.mVU.mIsSubscribed = mVar.c;
            dCV();
        }
    }

    public boolean dDm() {
        if (!this.mWp || this.mYL == null) {
            return false;
        }
        if (this.mYL != null) {
            this.mYL.e();
        }
        if (this.mWU != null) {
            this.mWU.setText("");
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
        if (!dDO() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mWy != null) {
                        this.mWy.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                        this.mYf.dCE().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mYf.dCE().mMicStatus.onMic) {
                            if (this.mUZ != null) {
                                this.mUZ.setVisibility(8);
                            }
                            if (this.mWr != null && this.mWr.isShown()) {
                                this.mWr.a();
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
                        if (this.mYf.dCE().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mVU != null && !h.isEmpty(this.mVU.mCreatorUID)) {
                                i(arrayList2, this.mVU.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).a(!this.F);
                            }
                        } else if (this.mYf.dCE().mMicStatus.onMic) {
                            if (this.mYf.dCE().mMicStatus != null && !h.isEmpty(this.mYf.dCE().mMicStatus.micRoomId) && !this.mYf.dCE().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mYf.dCE().mMicStatus.micRoomId;
                            }
                            this.mYf.dCE().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mYf.dCE().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = j(this.mYf.dCE().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mYf.dCE().mMicStatus, str3, z4);
                            if (this.mWr != null && this.mWr.getVisibility() == 0) {
                                this.mWr.a(this.mYf.dCE().mFanItems, this.mYf.dCE().mMicStatus, str3, z4, this.mYf.dCE().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mUZ != null) {
                                this.mUZ.setVisibility(8);
                            }
                            if (this.mWr != null && this.mWr.isShown()) {
                                this.mWr.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mVQ != onlineVip.mCount || (this.mUW != null && this.mUW.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mVQ = onlineVip.mCount;
                        this.mUX = onlineVip.mCount;
                        dDu();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mWo.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mWo.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mWo.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mWK <= 5000) {
                                z2 = false;
                            } else {
                                this.mWK = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mWo.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mWo.addAll(onlineVip.mOnlineVipItems);
                            }
                            dCW();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mWL != null) {
                    if (this.mVU == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mVU.mCreatorAvatar;
                        str2 = this.mVU.mCreatorGender;
                    }
                    this.mWL.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mRt != null && this.mRt.mUv != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mRt.mUv.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mRq != null) {
                                        this.mRq.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mRt.mUv.mInPKMode = true;
                                    this.mRt.mUv.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRt.mUv.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRt.mUv.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRt.mUv.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRt.mUv.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRt.mUv.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mRt.mUv.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mRt.mUv.mMode = pkNotifyInfo.mMode;
                                    this.mRt.mUv.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mRu != null) {
                                        this.mRu.g(true, this.mRt.mUv.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dBU().a) {
                                        if (!com.kascend.chushou.b.dBN().e) {
                                            com.kascend.chushou.b.dBN().e = true;
                                            tv.chushou.zues.utils.g.M(this.mYg, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBU().a(this.mYg, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mRt.mUv.mAction = 7;
                                    this.mRt.mUv.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRt.mUv.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRt.mUv.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRt.mUv.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRt.mUv.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRt.mUv.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mRt.mUv.mMode == 2) {
                                        dDj();
                                    } else {
                                        dCN();
                                    }
                                    if (this.mRu != null) {
                                        this.mRu.g(false, 0L);
                                        this.mRu.b(this.mRt.mUv, true);
                                        this.mRu.a(this.mWO + tv.chushou.zues.utils.a.dip2px(this.mYg, 52.0f), this.mYk);
                                        this.mRu.a(this.mRt.mUv.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mRq != null) {
                                        this.mRq.a(false);
                                    }
                                    this.mRt.mUv.mInPKMode = false;
                                    this.mRt.mUv.mAction = 2;
                                    dCN();
                                    dDj();
                                    if (this.mRu != null) {
                                        this.mRu.c();
                                    }
                                    this.mRt.b = null;
                                    this.mRt.mUv = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mRt.mUv.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mRt.mUv.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mRt.mUv.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mVU != null && !h.isEmpty(this.mVU.mRoomID) && this.mVU.mRoomID.equals(this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mRt.mUv.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mRu != null) {
                                        this.mRu.a(this.mRt.mUv, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mRt.mUv.copyUpdate(pkNotifyInfo);
                                    if (this.mRu != null) {
                                        this.mRu.a(this.mRt.mUv);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mRt.mUv.copyStop(pkNotifyInfo);
                                        if (this.mRu != null) {
                                            this.mRu.w(this.mRt.mUv.mMaxFreeDuration, this.mRt.mUv.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mRt.mUv.copyResult(pkNotifyInfo);
                                    if (!this.mWm && this.mRu != null) {
                                        int i7 = 1;
                                        if (this.mRt.mUv.destinyInfo != null && this.mRt.mUv.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mRu.a(h.parseInt(this.mRt.mUv.mResult), h.parseLong(this.mRt.mUv.mvpUid), this.mRt.mUv.mvpAvatar, this.mRt.mUv.mvpNickname, this.mRt.mUv.mMaxFreeDuration, this.mRt.mUv.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mRw != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mRw.uid = cycleLiveRoomInfo.uid;
                        this.mRw.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mRw.roomId = cycleLiveRoomInfo.roomId;
                        this.mRw.avatar = cycleLiveRoomInfo.avatar;
                        this.mRw.nickname = cycleLiveRoomInfo.nickname;
                        s(false);
                        if (this.mYg != null && (this.mYg instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mYg).d();
                        }
                    } else {
                        ((VideoPlayer) this.mYg).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mYf != null && this.mYf.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dBU().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dBU().b().equals(next2.mUserID)) {
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

    public void dDu() {
        if (this.mUW != null) {
            if (this.mRt == null || this.mRt.mUv == null || !this.mRt.mUv.mInPKMode) {
                if (this.mUX > 0) {
                    this.mUW.setVisibility(0);
                    this.mUW.setText(String.format(this.mYg.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mUX))));
                    this.mVb.setVisibility(0);
                    return;
                }
                this.mUW.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mUZ.setVisibility(0);
            if (this.mVa != null) {
                this.mVa.a(str, z, micStatus, this.mYf.dCE().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mUZ.setVisibility(8);
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
    public void dDr() {
        int childCount = this.mVW.getChildCount();
        int itemCount = this.mVW.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mVW);
        if (f + childCount >= itemCount) {
            this.mWd = true;
            if (this.mWe != null) {
                this.mWe.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                u(true);
            }
        }
    }

    public void dDA() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mVX.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mVX.add(1, chatInfo2);
    }

    private void u(boolean z) {
        if (this.mVX == null) {
            this.mVX = new ArrayList<>();
        }
        while (2 < this.mVX.size()) {
            this.mVX.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mVZ);
        if (a2 == null) {
            v(false);
            return;
        }
        this.mVX.addAll(a2);
        int size = this.mVX.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mVX.size(); i++) {
                this.mVX.remove(2);
            }
        }
        v(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mWa == null) {
            this.mWa = new ArrayList<>();
        }
        this.mWa.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mWc != null && this.mWc.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mWc.contains("2"))) {
                        this.mWa.add(next);
                    } else if (!this.mWc.contains(next.mType)) {
                        this.mWa.add(next);
                    }
                }
                return this.mWa;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mVX == null) {
                    this.mVX = new ArrayList<>(arrayList);
                    dDA();
                    v(z2);
                    return;
                }
                if (this.mVZ == null) {
                    this.mVZ = new ArrayList<>();
                }
                this.mVZ.addAll(arrayList);
                int size = this.mVZ.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mVZ.size(); i++) {
                        this.mVZ.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mVX.size();
                if (a2 != null) {
                    this.mVX.addAll(a2);
                }
                int size3 = this.mVX.size();
                if (!this.mWd && this.mWe != null) {
                    this.mWe.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mVX.size(); i3++) {
                        this.mVX.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mVX == null) {
                this.mVX = new ArrayList<>(arrayList);
                dDA();
            } else {
                if (this.mVZ == null) {
                    this.mVZ = new ArrayList<>();
                }
                this.mVZ.clear();
                this.mVZ.addAll(arrayList);
                this.mVX.clear();
                dDA();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mVX.addAll(a3);
                }
            }
            v(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mWb != null) {
                this.mWb.a(this.mVX.size());
                if (i == 1) {
                    this.mWb.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mWb.notifyItemRangeRemoved(i2, i3);
                    this.mWb.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mWb.notifyDataSetChanged();
                }
            }
            if (z || this.mWd) {
                this.mWd = true;
                if (this.mWe != null) {
                    this.mWe.setVisibility(8);
                }
                if (z) {
                    this.mVT.scrollToPosition(this.mVX.size() - 1);
                } else {
                    this.mVT.smoothScrollToPosition(this.mVX.size() - 1);
                }
            }
        }
    }

    private void v(boolean z) {
        if (!this.ah) {
            if (this.mWb != null) {
                this.mWb.a(this.mVX.size());
                this.mWb.notifyDataSetChanged();
            }
            if (z || this.mWd) {
                this.mWd = true;
                if (this.mWe != null) {
                    this.mWe.setVisibility(8);
                }
                if (z) {
                    this.mVT.scrollToPosition(this.mVX.size() - 1);
                } else {
                    this.mVT.smoothScrollToPosition(this.mVX.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dCp;
        RoomToast roomToast;
        this.p = false;
        if (this.mYf != null && this.mYf.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mYf.f.size()) {
                    break;
                } else if (!"2".equals(this.mYf.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dDE();
            return;
        }
        if (this.mRI != null) {
            this.mRI.setVisibility(0);
        }
        if (this.mUM != null) {
            this.mUM.setVisibility(0);
        }
        if (this.mYf != null) {
            this.mVU = this.mYf.dCG();
            this.mVV = this.mYf.dCE();
            if (com.kascend.chushou.b.dBN().c != null && this.mWb != null) {
                this.mWb.a(com.kascend.chushou.b.dBN().c);
                this.mWb.notifyDataSetChanged();
            }
            FullRoomInfo dCE = this.mYf.dCE();
            if (dCE != null) {
                if (!h.isEmpty(dCE.mRoomToastList)) {
                    Iterator<RoomToast> it = dCE.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dBU().j())) {
                    a(roomToast);
                }
            }
            if (this.mVU != null) {
                dDJ();
            }
            if (this.mVU != null && !this.mVU.mIsSubscribed) {
                RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mVU == null || !c.this.mVU.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mYf != null && this.mYf.l()) {
                d(true);
            }
        }
        if (this.mVU != null && this.mWb != null) {
            if (this.mVX != null) {
                this.mVX.clear();
            } else {
                this.mVX = new ArrayList<>();
            }
            this.mWb.a(this.mVU);
            dDA();
            this.mWb.a(this.mVX.size());
            this.mWb.notifyDataSetChanged();
        }
        dCT();
        N();
        if (this.mYg != null && (this.mYg instanceof VideoPlayer) && (dCp = ((VideoPlayer) this.mYg).dCp()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dCp.mUv, dCp.b);
        }
        this.mVo.h(this.mVU.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVU.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mVs);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dDs() {
        if (this.mVP == null) {
            View inflate = LayoutInflater.from(this.mYg).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mTc = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mVP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYg, 160.0f), -2);
            this.mVP.setFocusable(false);
            this.mVP.setOutsideTouchable(false);
            this.mVP.setAnimationStyle(a.j.gift_toast_style);
            this.mVP.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dBU().c(roomToast.mToastContent);
            if (this.mVP == null) {
                dDs();
            }
            if (this.mTc != null) {
                this.mTc.setText(roomToast.mToastContent);
            }
            if (!this.mVP.isShowing()) {
                if (this.mVs != null) {
                    this.mVP.showAtLocation(this.mVs, 85, 0, this.mXQ.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
                    RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mVP != null) {
                                c.this.mVP.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mVP.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mWG != null) {
            this.mWG.setVisibility(z ? 0 : 8);
        }
        this.mWH = true;
        if (this.mYg instanceof VideoPlayer) {
            ((VideoPlayer) this.mYg).p();
        }
    }

    private void dDE() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mYg).s();
        dDb();
        dDc();
        if (this.mVd == null) {
            this.mVd = (PlayShowRecommendView) ((ViewStub) this.mXQ.findViewById(a.f.view_recommend)).inflate();
        }
        this.mVd.setVisibility(0);
        if (this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null && !h.isEmpty(this.mYf.dCE().mRoominfo.mRoomID)) {
            dDv();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYL != null) {
            this.mYL.e();
        }
        if (this.mRI != null) {
            this.mRI.setVisibility(4);
        }
        if (this.mUM != null) {
            this.mUM.setVisibility(8);
        }
        if (this.mYT != null) {
            this.mYT.dPE();
            this.mYT.setVisibility(8);
        }
        wo(false);
        a(false, false);
        if (this.mRq != null) {
            this.mRq.a();
        }
    }

    private void dDv() {
        if (this.mVd != null && this.mVd.getVisibility() == 0) {
            this.mVd.a(this.mYf.dCE().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
    public void ox() {
        super.ox();
        if (this.mYg instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mVB != null && this.mVB.b()) {
            this.mVB.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mWq);
        if (this.mYg != null) {
            if (this.mWq || "10004".equals(((VideoPlayer) this.mYg).t)) {
                this.mWq = true;
                if (this.mYf != null) {
                    this.mYf.f = null;
                    if (this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                        this.mYf.dCE().mRoominfo.mGameId = null;
                    }
                }
                dDE();
                return;
            }
            this.mWq = true;
            if (this.mYg != null) {
                ((VideoPlayer) this.mYg).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mWq = false;
        if (this.mRI != null) {
            this.mRI.setVisibility(0);
        }
        if (this.mUM != null) {
            this.mUM.setVisibility(0);
        }
        if (this.mVd != null) {
            this.mVd.setVisibility(8);
        }
        if (this.mYa != null) {
            this.mYa.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mWq = false;
        if (this.mRI != null) {
            this.mRI.setVisibility(0);
        }
        if (this.mUM != null) {
            this.mUM.setVisibility(0);
        }
        if (this.mVd != null) {
            this.mVd.setVisibility(8);
        }
        if (this.mYa != null) {
            this.mYa.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mVd != null) {
            this.mVd.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dDO()) {
            if (i()) {
                if (i == 404) {
                    if (this.mYf != null) {
                        this.mYf.f = null;
                        this.mYf.dCE().mRoominfo.mGameId = null;
                    }
                    dDE();
                    return;
                }
                tv.chushou.zues.utils.g.Om(a.i.str_getvideosource_failed);
            }
            wo(false);
            n(false);
            g(false);
            this.al = true;
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void p() {
        int i = 0;
        if (this.mYf != null && this.mYf.dCF() != null) {
            a(this.mYf.dCF());
        }
        this.p = false;
        if (this.mYf == null || this.mYf.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mYf.f.size()) {
                if (!"2".equals(this.mYf.f.get(i2).mType)) {
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
    public GiftAnimationLayout dCY() {
        if (this.mXQ == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXQ.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mVs != null) {
            int size = iconConfig.configs.size();
            this.mVs.removeAllViews();
            if (this.mVu != null) {
                this.mVu.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mYg).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mVs, false);
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
                            this.mVu.setVisibility(0);
                            this.mVt.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.mVs.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYg instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCk = ((VideoPlayer) this.mYg).dCk();
            if (this.mYW == null) {
                this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYW.setVisibility(0);
            this.mYW.a(2, dCk);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mVw != null && this.mYg != null) {
            this.mVw.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mVw != null && this.mYg != null) {
            this.mVw.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mVw != null) {
            this.mVw.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mVw != null) {
            this.mVw.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mVv != null) {
            if (this.mYg != null) {
                this.mVv.a(((VideoPlayer) this.mYg).dCk(), false);
            }
            this.mVv.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mXQ != null) {
            Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
            int i = hd.x > hd.y ? 1 : 2;
            if (this.mYW == null) {
                this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYW.setPlayerViewHelper(this.mYf);
            this.mYW.setVisibility(0);
            this.mYW.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mVx != null) {
            this.mVx.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mVx != null) {
            this.mVx.a(bangInfo, str);
        }
        if (this.mRW != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mRW.setText(this.mYg.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mRW.setText(this.mYg.getString(a.i.str_contribute_tittle));
            } else {
                this.mRW.setText(Html.fromHtml(this.mYg.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mUY != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mUY.setText(this.mYg.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mUY.setText(this.mYg.getString(a.i.str_contribute_tittle));
            } else {
                this.mUY.setText(Html.fromHtml(this.mYg.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mVx != null) {
            this.mVx.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mYf != null && !h.isEmpty(this.mYf.mRa)) {
            this.mWw = this.mYf.mRa.get(0);
            if (this.mWP != null) {
                this.mWP.setVisibility(0);
                this.mWP.a(this.mWw.mCover, 0, 0, 0, 1);
                if (this.mWQ != null) {
                    if (this.mWw.mShowClose) {
                        this.mWQ.setVisibility(0);
                    } else {
                        this.mWQ.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mVx != null) {
            this.mVx.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXQ != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mSu != null) {
            this.mSu.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dDO() && !this.mWm) {
            if (iVar.a == 52) {
                if (this.mWb != null) {
                    this.mWb.a(com.kascend.chushou.b.dBN().c);
                    this.mWb.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mWm && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dDO()) {
                    c.this.t(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mVk != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mVk);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dDO() && !this.mWm) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mYg, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCl = ((VideoPlayer) this.mYg).dCl();
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(2, dCl);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCm = ((VideoPlayer) this.mYg).dCm();
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(2, dCm);
            } else if (bVar.a == 8) {
                if (this.mWy != null && this.mWy.getVisibility() != 0) {
                    this.mWy.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mVU == null ? "" : this.mVU.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mYW == null) {
                    this.mYW = (H5Container) ((ViewStub) this.mXQ.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYW.setVisibility(0);
                this.mYW.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dDO() && this.mYf != null && !h.isEmpty(this.mYf.a) && this.mYf.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mWy != null && this.mWy.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mYg, 80.0f);
                }
                if (this.mWx != null && this.mWx.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mWx.getHeight());
                }
                this.mWJ.setTranslationY(-r0);
                return;
            }
            if (this.mWI != null) {
                this.mWI.cancel();
                this.mWI = null;
            }
            int translationY = (int) this.mWJ.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mYg, 80.0f) : 0;
                    if (this.mWx != null && this.mWx.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mWx.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mWx.getHeight() : 0;
                    if (this.mWy != null && this.mWy.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mYg, 80.0f));
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
        this.mWI = ValueAnimator.ofInt(i, i2);
        this.mWI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dDO() && c.this.mVx != null) {
                    c.this.mWJ.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mWI.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mWI = null;
            }
        });
        this.mWI.setInterpolator(new LinearInterpolator());
        this.mWI.setDuration(800L);
        this.mWI.start();
    }

    private boolean dDF() {
        if (this.mWt == 1) {
            this.mWt = 2;
            wk(true);
            return true;
        } else if (this.mWt == 3) {
            dDI();
            return true;
        } else {
            return false;
        }
    }

    private boolean dDG() {
        if (this.mWt == 1) {
            return dDH();
        }
        if (this.mWt == 2) {
            this.mWt = 1;
            wk(false);
            return true;
        }
        return false;
    }

    private boolean dDH() {
        if (this.mWu || this.mYf == null || this.mYf.dCG() == null) {
            return false;
        }
        if (this.mXr != null) {
            this.mXr.a(true);
        }
        this.mWt = 3;
        this.mWu = true;
        dDJ();
        this.mUJ.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.mWu = false;
                c.this.mUL.setVisibility(8);
            }
        });
        this.mUL.startAnimation(loadAnimation);
        this.mUJ.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDI() {
        if (!this.mWu) {
            if (this.mXr != null) {
                this.mXr.a(false);
            }
            this.mWt = 1;
            this.mWu = true;
            dDJ();
            this.mUL.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.mWu = false;
                    c.this.mUJ.setVisibility(8);
                }
            });
            this.mUL.startAnimation(loadAnimation);
            this.mUJ.startAnimation(loadAnimation2);
        }
    }

    private void dDJ() {
        if (this.mXQ != null) {
            if (this.mUJ == null) {
                this.mUJ = this.mXQ.findViewById(a.f.user_space_container);
            }
            if (this.mUL == null) {
                this.mUL = this.mXQ.findViewById(a.f.video_container);
            }
            if (this.mUK == null) {
                this.mUK = com.kascend.chushou.view.user.b.b(null, this.mYf.a, false, this.mYf.h);
                this.mUK.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dDI();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dDI();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mUK).commitAllowingStateLoss();
            }
        }
    }

    private void wk(boolean z) {
        Animation loadAnimation;
        if (this.mUM != null) {
            this.mUM.setVisibility(z ? 8 : 0);
        }
        if (this.mVR != null) {
            this.mWu = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mVR.setVisibility(8);
                        c.this.mWu = false;
                    }
                });
            } else {
                this.mWu = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mVR.setVisibility(0);
                        c.this.mWu = false;
                    }
                });
            }
            this.mVR.startAnimation(loadAnimation);
        }
        dDa();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mVe.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mVm != null) {
                this.mVm.setVisibility(0);
            }
            if (this.mVn != null) {
                this.mVn.a();
                return;
            }
            return;
        }
        if (this.mVp != null) {
            this.mVp.setVisibility(0);
        }
        if (this.mVq != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mVq.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mVp != null) {
            this.mVp.setVisibility(8);
        }
        if (this.mVq != null) {
            this.mVq.clearAnimation();
        }
        if (this.mVm != null) {
            this.mVm.setVisibility(8);
        }
        if (this.mVn != null) {
            this.mVn.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mVR != null && this.mXQ != null) {
            if (this.mWy == null) {
                this.mWy = new com.kascend.chushou.player.ui.miniview.a(this.mYg, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mWy != null && c.this.mXQ != null && c.this.mWy.a()) {
                            ((ViewGroup) c.this.mXQ).removeView(c.this.mWy);
                            c.this.mWy = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWy.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mYg, 52.0f);
                this.mWy.setLayoutParams(layoutParams);
                ((ViewGroup) this.mVR).addView(this.mWy, ((ViewGroup) this.mVR).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mWy.setVisibility(8);
                } else {
                    this.mWy.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mYf.a == null ? "" : this.mYf.a);
                }
            } else if (!this.mWy.isShown()) {
                this.mWy.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mYf.a == null ? "" : this.mYf.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mWF != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mWF.setVisibility(0);
                this.mWF.setAnim(true);
                this.mWF.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nYf, b.C0816b.nYg, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mWf != null && this.mWf.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dDK();
                    }
                });
                this.mWf.setVisibility(0);
                this.mWf.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mWf != null && this.mWf.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mWh != null) {
                        c.this.mWh.removeAllListeners();
                        c.this.mWh.cancel();
                        c.this.mWh = null;
                    }
                    if (c.this.mWf != null) {
                        c.this.mWf.setVisibility(8);
                    }
                }
            });
            this.mWf.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mWN == null) {
                this.mWN = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dDO()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mYg, "显示双击666_num", null, new Object[0]);
                            if (c.this.mYf != null) {
                                c.this.mYf.b(false);
                            }
                            c.this.d(false);
                            c.this.wl(true);
                        }
                    }
                };
                if (this.mYh != null) {
                    this.mYh.d(this.mWN, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mWN != null) {
            this.mYh.removeCallbacks(this.mWN);
            this.mWN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mWi != null && this.mWi.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mYg, a.C0690a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dDL();
                    }
                });
                this.mWi.setVisibility(0);
                this.mWi.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXP, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.wl(false);
                    }
                });
            }
        } else if (this.mWi != null && this.mWi.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYg, a.C0690a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mWk != null) {
                        c.this.mWk.removeAllListeners();
                        c.this.mWk.cancel();
                        c.this.mWk = null;
                    }
                    if (c.this.mWi != null) {
                        c.this.mWi.setVisibility(8);
                    }
                }
            });
            this.mWi.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dDK() {
        if (this.mWf == null || this.mWg == null) {
            return null;
        }
        if (this.mWh != null) {
            this.mWh.removeAllListeners();
            this.mWh.cancel();
            this.mWh = null;
        }
        this.mWg.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mWg, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mWg, 0.0f);
        int measuredWidth = (this.mWf.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mYg, 13.0f) * 2)) - this.mWg.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mWg, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mWg, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mWg, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mWh != null) {
                    c.this.mWh.removeAllListeners();
                    c.this.mWh.cancel();
                    c.this.mWh = null;
                }
                RxExecutor.postDelayed(c.this.mXP, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dDK();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mWh = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dDL() {
        if (this.mWi == null || this.mWj == null) {
            return null;
        }
        if (this.mWk != null) {
            this.mWk.removeAllListeners();
            this.mWk.cancel();
            this.mWk = null;
        }
        this.mWj.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mWj, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mWj, 0.0f);
        int measuredWidth = (this.mWi.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mYg, 13.0f) * 2)) - this.mWj.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mWj, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mWj, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mWj, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mWk != null) {
                    c.this.mWk.removeAllListeners();
                    c.this.mWk.cancel();
                    c.this.mWk = null;
                }
                RxExecutor.postDelayed(c.this.mXP, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dDL();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mWk = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mXr = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mRw != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mRw.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dDO()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Om(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Om(a.i.subscribe_success);
                            }
                            if (c.this.mRw != null) {
                                c.this.mRw.isSubscribe = !z;
                                c.this.dCU();
                                return;
                            }
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dDO()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dBQ().a(bVar, (String) null, this.mRw.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mRw.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dBQ().b(bVar, (String) null, c.this.mRw.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mYf != null && this.mVU != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mYf.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mYf.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mVU.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dDO()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Om(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Om(a.i.subscribe_success);
                            }
                            c.this.mVU.mIsSubscribed = !z;
                            c.this.dCV();
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dDO()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dBQ().a(bVar, (String) null, this.mVU.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mVU.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dBQ().b(bVar, (String) null, c.this.mVU.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mUu != null) {
            int width = this.mUu.getWidth();
            int height = this.mUu.getHeight();
            if (this.mWD != width || this.mWE != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXQ != null) {
            if (this.mVr == null) {
                this.mVr = (InteractionView) ((ViewStub) this.mXQ.findViewById(a.f.view_interaction)).inflate();
                this.mVr.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mVr.a();
                    }
                });
            }
            if (this.mVr != null) {
                this.mVr.b(configDetail);
                this.mVr.c();
                this.mVr.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQp()) {
                tv.chushou.zues.utils.g.M(this.mYg, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mYg, null) && (this.mYg instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYf != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYg, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mYg, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYf != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYg, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mYg, configDetail.mUrl, this.mYg.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mYg, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    if (this.mWp) {
                        dDm();
                        return;
                    }
                    if (this.mYg.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mYg, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mYf != null && this.mYf.dCE() != null && this.mYf.dCE().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYf.dCE().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dB(this.mVs);
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
        if (this.mYg != null && !this.v && !h.isEmpty(str) && this.mVU != null && str.equals(this.mVU.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mRt == null) {
                this.mRt = new com.kascend.chushou.player.e.a();
            }
            this.mRt.b = str;
            this.mRt.mUv.copy(pkNotifyInfo);
            if (this.mRt.mUv.mAction == 6) {
                if (this.mRq != null) {
                    this.mRq.a(true);
                }
                this.mRt.mUv.mInPKMode = true;
                this.u = this.mRt.mUv.mPkId;
            } else if (this.mRt.mUv.mAction == 7 || (this.mRt.mUv.mMode == 1 && this.mRt.mUv.mAction == 5)) {
                if (this.mRq != null) {
                    this.mRq.a(true);
                }
                this.mRt.mUv.mInPKMode = true;
                if (this.mWB != 42) {
                    this.mWO = ((this.mWC.y - ((this.mWC.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mYg, 158.0f) + this.mVN)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
                    dDj();
                }
                this.u = this.mRt.mUv.mPkId;
                if (this.mRu != null) {
                    this.mRu.b(this.mRt.mUv, false);
                    this.mRu.a(this.mRt.mUv.mMode, (String) null);
                    if (this.mRt.mUv.mAction == 5 && this.mRt.mUv.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mRt.mUv.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mRt.mUv.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mRt.mUv.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mRt.mUv.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mRt.mUv.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mRu.a(this.mRt.mUv);
                        this.mRu.a(parseInt, this.mRt.mUv.mPkUpdateInfo.remainDuration, j, this.mRt.mUv.mMode, (this.mRt.mUv.destinyInfo == null || this.mRt.mUv.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mRt.mUv.mPkUpdateInfo != null && !h.isEmpty(this.mRt.mUv.mPkUpdateInfo.specialMomentList) && this.mRu != null) {
                    this.mRu.a(this.mRt.mUv, true);
                }
                if (this.mRt.mUv.mMode == 2) {
                    dDj();
                } else {
                    dCN();
                }
            } else {
                this.mRt.mUv.mInPKMode = false;
                if (this.mRt.mUv.mMode == 2) {
                    dDj();
                } else {
                    dCN();
                }
            }
        }
    }

    public void dCN() {
        dDh();
        dDg();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mVK != null && this.mYf != null && this.mYf.mRd != null) {
            this.mVK.setText(tv.chushou.zues.utils.b.Ol(this.mYf.mRd.count));
            this.mVK.setVisibility(0);
            if (this.mYf.mRd.count < 1) {
                dDN();
            }
            if (this.mVD != null) {
                this.mVD.setText(this.mYf.mRd.primaryName);
            }
            if (this.mVE != null) {
                this.mVE.setText(this.mYf.mRd.desc);
            }
            dCO();
        }
    }

    public void dCO() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mVL * h.parseLong(this.mYf.mRd.point)));
        if (this.mSR != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mYg.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mYg, a.e.icon_coin_new);
            cVar.append(this.mYg.getString(a.i.str_buy_count_coin2));
            this.mSR.setText(cVar);
        }
    }

    private void dDM() {
        if (com.kascend.chushou.d.e.c(this.mYg, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mVL);
        }
    }

    private void dDN() {
        this.mVM = false;
        this.mVJ.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mYf != null && this.mYf.mRd != null) {
            if (this.mYf.mRd.count < 1) {
                this.mVK.setVisibility(8);
            } else {
                this.mVK.setVisibility(0);
                this.mVK.setSelected(false);
                this.mVK.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mVC.setVisibility(8);
        if (this.mVk != null) {
            this.mVk.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mRy != null) {
            if (z) {
                this.mRy.setVisibility(0);
            } else {
                this.mRy.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mXo != null) {
            this.mXo.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mVt != null) {
            this.mVt.performClick();
        }
    }
}
