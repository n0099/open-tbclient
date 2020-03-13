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
    private View mRT;
    private KPSwitchPanelLinearLayout mSG;
    private ImageView mSH;
    private tv.chushou.zues.widget.kpswitch.b.c mSJ;
    private d.a mSK;
    public String mSa;
    private TextView mSe;
    private TextView mSh;
    private ImageView mSn;
    private TextView mSx;
    private TextView mTc;
    private TextView mTp;
    private View mTs;
    private int mUS;
    private View mUT;
    private View mUU;
    private com.kascend.chushou.view.user.b mUV;
    private View mUW;
    private FrameLayout mUX;
    private LinearLayout mUY;
    private RelativeLayout mUZ;
    private TextView mUs;
    private LinearLayout mVA;
    private ImageView mVB;
    private InteractionView mVC;
    private LinearLayout mVD;
    private FrescoThumbnailView mVE;
    private FrameLayout mVF;
    private RedpacketNotifier mVG;
    private InteractNotifier mVH;
    private EmbeddedButtonLayout mVI;
    private GiftAnimationLayout mVJ;
    private com.kascend.chushou.player.b.a mVK;
    private f mVL;
    private PlayShowH5View mVM;
    private LinearLayout mVN;
    private TextView mVO;
    private TextView mVP;
    private TextView mVQ;
    private TextView mVR;
    private TextView mVS;
    private TextView mVT;
    private ImageView mVU;
    private TextView mVV;
    private FrescoThumbnailView mVa;
    private TextView mVb;
    private TextView mVc;
    private TextView mVd;
    private FrescoThumbnailView mVe;
    private TextView mVf;
    private TextView mVg;
    private TextView mVh;
    private int mVi;
    private TextView mVj;
    private LinearLayout mVk;
    private PlayShowMicStatusView mVl;
    private RecyclerView mVm;
    private ImageView mVn;
    private PlayShowRecommendView mVo;
    private View mVp;
    private RelativeLayout mVq;
    private AnimationSet mVr;
    private ImageView mVs;
    private ImageView mVt;
    private RelativeLayout mVu;
    private PastedEditText mVv;
    private ToggleButton mVw;
    private RelativeLayout mVx;
    private PaoPaoView mVy;
    private FrescoThumbnailView mVz;
    private PlayShowMicPerson mWC;
    private FoodView mWG;
    public ListItem mWH;
    private FoodView mWI;
    private com.kascend.chushou.player.ui.miniview.a mWJ;
    private int mWK;
    private int mWL;
    private int mWN;
    private Point mWO;
    private FrescoThumbnailView mWR;
    private FrescoThumbnailView mWS;
    private ValueAnimator mWU;
    private LinearLayout mWV;
    private long mWW;
    private VideoShowVoteView mWX;
    private Runnable mWY;
    private PopupWindow mWa;
    private View mWc;
    private RecyclerView mWe;
    private RoomInfo mWf;
    private RecyclerView.LayoutManager mWh;
    private ArrayList<ChatInfo> mWi;
    private ArrayList<ChatInfo> mWj;
    private ArrayList<ChatInfo> mWk;
    private ArrayList<ChatInfo> mWl;
    private Button mWp;
    private View mWq;
    private View mWr;
    private Animator mWs;
    private View mWt;
    private View mWu;
    private Animator mWv;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mWy;
    private float mXA;
    private float mXB;
    private a mXC;
    private FrescoThumbnailView mXa;
    private ImageView mXb;
    private RelativeLayout mXc;
    private TextView mXd;
    private ImageView mXe;
    private EditText mXf;
    private View mXg;
    private RelativeLayout mXh;
    private RelativeLayout mXi;
    private FrescoThumbnailView mXj;
    private TextView mXk;
    private TextView mXl;
    private ImageView mXm;
    private RelativeLayout mXn;
    private LinearLayout mXo;
    private TextView mXp;
    private TextView mXq;
    private RelativeLayout mXr;
    private RelativeLayout mXs;
    private FrescoThumbnailView mXt;
    private TextView mXu;
    private TextView mXv;
    private ImageView mXw;
    private RelativeLayout mXx;
    private TextView mXz;
    private boolean mSI = false;
    private int mVW = 1;
    private boolean mVX = false;
    private int mVY = 0;
    private int mVZ = 0;
    private int mWb = -1;
    private boolean mWd = false;
    private FullRoomInfo mWg = null;
    private com.kascend.chushou.player.adapter.a mWm = null;
    private ArrayList<String> mWn = null;
    private boolean mWo = true;
    private boolean mWw = true;
    private boolean mWx = false;
    public final List<OnlineVipItem> mWz = new ArrayList();
    private boolean mWA = false;
    private boolean mWB = false;
    private long mWD = 0;
    private int mWE = 1;
    private boolean mWF = false;
    private int mWP = -1;
    private int mWQ = -1;
    private boolean mWT = false;
    private int mWZ = -1;
    private io.reactivex.disposables.b mXy = null;

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
        this.mSa = getArguments().getString("cover");
        this.mWw = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mYb = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mYb;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dDP()) {
            dCS();
            this.mUF = ((VideoPlayer) this.mYr).dCd();
            this.mYq = ((VideoPlayer) this.mYr).dCg();
            dA(view);
            dDg();
            if (this.mYr instanceof VideoPlayer) {
                ((VideoPlayer) this.mYr).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mWx = false;
        if (this.mYW != null) {
            this.mYW.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWx = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mWs != null) {
            this.mWs.removeAllListeners();
            this.mWs.cancel();
            this.mWs = null;
        }
        if (this.mWv != null) {
            this.mWv.removeAllListeners();
            this.mWv.cancel();
            this.mWv = null;
        }
        if (this.mVH != null) {
            this.mVH.c();
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
        if (this.mXy != null) {
            this.mXy.dispose();
            this.mXy = null;
        }
        this.mVW = 1;
        this.mVX = false;
        if (this.mYs != null) {
            this.mYs.cq(null);
        }
        if (this.mWa != null) {
            this.mWa.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mYr, this.mSJ);
        if (this.mYr != null && (this.mYr instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYr).dCj();
        }
        this.mSK = null;
        this.mSJ = null;
        dCQ();
        if (this.mVK != null) {
            this.mVK.a();
        }
        if (this.mVy != null) {
            this.mVy.b();
            this.mVy.c();
            this.mVy = null;
        }
        super.d();
    }

    private void dCQ() {
        tv.chushou.zues.a.a.cr(this);
        if (this.mWk != null) {
            this.mWk.clear();
        }
        if (this.mWi != null) {
            this.mWi.clear();
        }
        if (this.mWl != null) {
            this.mWl.clear();
        }
        if (this.mWj != null) {
            this.mWj.clear();
        }
        if (this.mWn != null) {
            this.mWn.clear();
        }
        if (this.mWm != null) {
            this.mWm.a(0);
            this.mWm.a();
        }
    }

    private void dA(View view) {
        this.mUT = view.findViewById(a.f.fl_root);
        this.mWO = tv.chushou.zues.utils.a.he(this.mYr);
        this.mVY = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYr);
        this.mVZ = tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        this.mWN = 86;
        this.mYq = ((VideoPlayer) this.mYr).dCg();
        if (this.mYq != null) {
            this.mWf = this.mYq.dCH();
            this.mWg = this.mYq.dCF();
        }
        this.mWi = new ArrayList<>();
        this.mWk = new ArrayList<>();
        this.mWj = new ArrayList<>();
        this.mUX = (FrameLayout) this.mYb.findViewById(a.f.fl_effect);
        b();
        this.mYl = (PlayerErrorView) this.mYb.findViewById(a.f.view_net_error_msg);
        this.mYl.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mVx = (RelativeLayout) this.mYb.findViewById(a.f.rl_audio_ani);
        this.mVy = (PaoPaoView) this.mYb.findViewById(a.f.audio_ani);
        this.mVz = (FrescoThumbnailView) this.mYb.findViewById(a.f.audio_ani_avatar);
        this.mVA = (LinearLayout) this.mYb.findViewById(a.f.ll_audio);
        this.mUs = (TextView) this.mYb.findViewById(a.f.tv_open_video);
        this.mVB = (ImageView) this.mYb.findViewById(a.f.iv_audio_ani);
        this.mWS = (FrescoThumbnailView) this.mYb.findViewById(a.f.live_cover);
        if (!this.mWT || this.mUF == null || this.mUF.getPlayState() != 4) {
            this.mWS.setVisibility(0);
            this.mWS.setBlur(true);
            this.mWS.i(this.mSa, 0, 0, 0);
        }
        this.mUs.setOnClickListener(this);
        this.mRF = new b();
        this.mRF.a(view, null, this.mYr, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dPZ()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mYq != null) {
                    append.append(c.this.mYq.dCH().mRoomID);
                }
                if (c.this.mRE != null && c.this.mRE.mUG != null) {
                    append.append("&mode=").append(c.this.mRE.mUG.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mYr, append.toString());
            }
        });
        this.mRJ = (VoiceInteractionView) this.mYb.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mYq != null) {
            this.mWf = this.mYq.dCH();
            this.mWg = this.mYq.dCF();
        }
        dCT();
        dCR();
        dCY();
        this.mWV = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mWG = (FoodView) view.findViewById(a.f.rav_ad);
        this.mXa = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mXb = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mXa.setOnClickListener(this);
        this.mXb.setOnClickListener(this);
        this.mXc = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mWR = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mWR.setOnClickListener(this);
        this.mVH = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mVG = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mWp = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mWp.setOnClickListener(this);
        this.mWe = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mWe.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWe.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mWO.x, this.mWO.y) * 0.83d);
        this.mWe.setLayoutParams(layoutParams);
        this.mWh = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mYr);
        this.mWe.setLayoutManager(this.mWh);
        this.mWe.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mWe.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mWe.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dDs();
                } else if (i == 1) {
                    c.this.mWo = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mWm = new com.kascend.chushou.player.adapter.a(this.mYr, this.mWi);
        if (this.mWf != null) {
            this.mWm.a(this.mWf);
        }
        if (com.kascend.chushou.b.dBO().c != null) {
            this.mWm.a(com.kascend.chushou.b.dBO().c);
        }
        this.mWe.setAdapter(this.mWm);
        this.mWm.a(this.mWi.size());
        this.mWm.notifyDataSetChanged();
        if (this.mYq != null && (c = this.mYq.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mVK != null) {
            this.mVK.a();
            this.mVK = null;
        }
        this.mVJ = (GiftAnimationLayout) this.mYb.findViewById(a.f.ll_gift_animation);
        this.mVJ.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mUS = ((int) (tv.chushou.zues.utils.a.hd(this.mYr).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYr, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVJ.getLayoutParams();
        layoutParams2.bottomMargin = this.mUS;
        this.mVJ.setLayoutParams(layoutParams2);
        if (this.mYq != null) {
            this.mVK = new com.kascend.chushou.player.b.a(this.mYr.getApplicationContext(), this.mVJ);
            this.mVK.a(this.mYq);
            a(this.mYq.mRl, this.mYq.mRp);
        }
        this.mYb.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mVI = (EmbeddedButtonLayout) this.mYb.findViewById(a.f.embedded_button_layout);
        this.mVI.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mWX = (VideoShowVoteView) this.mYb.findViewById(a.f.view_video_show_vote);
        this.mWX.setOnClickListener(this);
        this.mWX.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dDo();
            }
        });
        if (this.mYq != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
            this.mVI.a(videoPlayer.dCp().dDW());
            this.mVI.b(this.mYq.i());
            this.mVG.a(videoPlayer.dCl(), false);
            this.mVH.a(videoPlayer.dCm(), videoPlayer.dCn(), videoPlayer.dCo());
            this.mRE = new com.kascend.chushou.player.e.a();
        }
        this.mZg = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mWA = false;
                c.this.b(c.this.mUS, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mWA = true;
                if (c.this.mYW != null) {
                    c.this.mYW.measure(0, 0);
                    int measuredHeight = c.this.mYW.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mYr, 14.0f);
                    if (measuredHeight > c.this.mUS) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mZa = (PaoGuideView) this.mYb.findViewById(a.f.rlPaoGuideView);
        this.mWC = (PlayShowMicPerson) this.mYb.findViewById(a.f.rl_mic_person_view);
        this.mVM = (PlayShowH5View) this.mYb.findViewById(a.f.rl_playshowh5);
        this.mWI = (FoodView) this.mYb.findViewById(a.f.bottom_ad);
        if (this.mYq != null) {
            H();
            if (this.mYq.mRf != null && !h.isEmpty(this.mYq.mRf.mUrl)) {
                b(this.mYq.mRf);
            }
        }
        this.mWq = this.mYb.findViewById(a.f.view_reminder_subscribe);
        this.mWr = this.mWq.findViewById(a.f.spash_subscribe);
        ((TextView) this.mWq.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().O(this.mYr, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.mYr.getString(a.i.videoplayer_reminder_subscribe)));
        this.mWq.setOnClickListener(this);
        this.mWt = this.mYb.findViewById(a.f.view_reminder_danmaku);
        this.mWu = this.mWt.findViewById(a.f.spash_danmaku);
        ((TextView) this.mWt.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().O(this.mYr, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.mYr.getString(a.i.videoplayer_reminder_danmaku)));
        this.mWt.setOnClickListener(this);
    }

    private void dCR() {
        this.mXh = (RelativeLayout) this.mYb.findViewById(a.f.rl_cyclelive);
        this.mXi = (RelativeLayout) this.mYb.findViewById(a.f.rlrl_cyclelive);
        this.mXj = (FrescoThumbnailView) this.mYb.findViewById(a.f.iv_liveicon);
        this.mXk = (TextView) this.mYb.findViewById(a.f.tv_livename);
        this.mXl = (TextView) this.mYb.findViewById(a.f.tv_livedesc);
        this.mXm = (ImageView) this.mYb.findViewById(a.f.iv_cyclelive_name_menu);
        this.mXn = (RelativeLayout) this.mYb.findViewById(a.f.rl_normal);
        this.mXo = (LinearLayout) this.mYb.findViewById(a.f.ll_cyclelive_nickname);
        this.mXp = (TextView) this.mYb.findViewById(a.f.tv_cyclelive_nickname);
        this.mXq = (TextView) this.mYb.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mXr = (RelativeLayout) this.mYb.findViewById(a.f.rl_clear_cyclelive);
        this.mXs = (RelativeLayout) this.mYb.findViewById(a.f.rlrl_clear_cyclelive);
        this.mXt = (FrescoThumbnailView) this.mYb.findViewById(a.f.iv_clear_liveicon);
        this.mXu = (TextView) this.mYb.findViewById(a.f.tv_clear_livename);
        this.mXv = (TextView) this.mYb.findViewById(a.f.tv_clear_livedesc);
        this.mXw = (ImageView) this.mYb.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mXx = (RelativeLayout) this.mYb.findViewById(a.f.rl_clear_normal);
        this.mXw.setOnClickListener(this);
        this.mXm.setOnClickListener(this);
        this.mXq.setOnClickListener(this);
        this.mXp.setOnClickListener(this);
        this.mXj.setOnClickListener(this);
        this.mXt.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mYq.mRd != null && this.mWI != null) {
            this.mWI.a(true, this.mYq.a == null ? "" : this.mYq.a);
            this.mWI.a(this.mYq.mRd, a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mYq != null && this.mYq.mRk != null && this.mVI != null) {
            this.mWG.a(this.mYq.mRk, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mYq != null) {
                        c.this.mYq.mRk = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDp() {
        return this.mVK;
    }

    private void dCS() {
        this.mYs = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mYb != null && (textView = (TextView) c.this.mYb.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mYr.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mYs.K(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mYs);
                        break;
                    case 12:
                        c.this.b(c.this.mYs);
                        break;
                    case 17:
                        c.this.dDS();
                        break;
                    case 18:
                        c.this.cXM();
                        break;
                    case 19:
                        c.this.mYp.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mWd) {
            this.mWd = true;
            if (this.mWc == null) {
                this.mWc = this.mYb.findViewById(a.f.vs_async_show_content);
                this.mWc = ((ViewStub) this.mWc).inflate();
            }
            this.mRT = this.mYb.findViewById(a.f.ui_content);
            if (this.mTs == null) {
                this.mTs = this.mYb.findViewById(a.f.vs_async_notification_view);
                this.mTs = ((ViewStub) this.mTs).inflate();
            }
            c(this.mYb);
            k();
            cXN();
            if (this.c == null) {
                this.mRz = new d.a();
                this.c = new GestureDetector(this.mYr, this.mRz);
            }
            ((VideoPlayer) this.mYr).q();
        }
    }

    private void dCT() {
        this.mUY = (LinearLayout) this.mYb.findViewById(a.f.ll_anchor);
        this.mUZ = (RelativeLayout) this.mYb.findViewById(a.f.ll_clear_anchor);
        this.mUY.setVisibility(4);
        this.mUZ.setVisibility(4);
        this.mVa = (FrescoThumbnailView) this.mYb.findViewById(a.f.iv_clear_avatar);
        this.mVb = (TextView) this.mYb.findViewById(a.f.tv_clear_nickname);
        this.mVc = (TextView) this.mYb.findViewById(a.f.tv_clear_online_count);
        this.mVd = (TextView) this.mYb.findViewById(a.f.tv_clear_btn_subscribe);
        this.mVd.setOnClickListener(this);
        this.mVe = (FrescoThumbnailView) this.mYb.findViewById(a.f.iv_avatar);
        this.mVf = (TextView) this.mYb.findViewById(a.f.tv_nickname_test);
        this.mVg = (TextView) this.mYb.findViewById(a.f.tv_online_count);
        this.mSe = (TextView) this.mYb.findViewById(a.f.tv_btn_subscribe);
        this.mSe.setOnClickListener(this);
        this.mVh = (TextView) this.mYb.findViewById(a.f.tv_loyal_counts);
        this.mSh = (TextView) this.mYb.findViewById(a.f.tv_btn_contribution);
        this.mVj = (TextView) this.mYb.findViewById(a.f.tv_btn_contribution_forpk);
        this.mSh.setVisibility(4);
        this.mVj.setVisibility(8);
        this.mVk = (LinearLayout) this.mYb.findViewById(a.f.ll_mic);
        this.mVl = (PlayShowMicStatusView) this.mYb.findViewById(a.f.show_mic_status);
        this.mVm = (RecyclerView) this.mYb.findViewById(a.f.rv_loyal);
        this.mVn = (ImageView) this.mYb.findViewById(a.f.iv_clear_close);
        this.mSn = (ImageView) this.mYb.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mVm.setLayoutManager(linearLayoutManager);
        this.mWy = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mWz, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mWz.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mYr, (JSONObject) null, c.this.mYq.dCH().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dQl(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mYr, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYr, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYr, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYr, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYr, a.c.color_979797), dip2px);
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
        this.mVm.setAdapter(this.mWy);
        this.mVk.setOnClickListener(this);
        this.mVa.setOnClickListener(this);
        this.mVn.setOnClickListener(this);
        this.mVe.setOnClickListener(this);
        this.mVa.setOnClickListener(this);
        this.mSn.setOnClickListener(this);
        this.mVh.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPZ() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mYq != null) {
                    str = str + c.this.mYq.dCH().mRoomID;
                }
                c.this.f(c.this.mYr.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mSh.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPZ() + "m/room-billboard/";
                if (c.this.mYq != null) {
                    str = str + c.this.mYq.dCH().mRoomID;
                }
                c.this.f(c.this.mYr.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mVj.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPZ() + "m/room-billboard/";
                if (c.this.mYq != null) {
                    str = str + c.this.mYq.dCH().mRoomID;
                }
                c.this.f(c.this.mYr.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        s(true);
    }

    public void s(boolean z) {
        boolean z2;
        if (this.mWg == null || this.mWg.cycleLiveRoomInfo == null || h.isEmpty(this.mWg.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mRH = this.mWg.cycleLiveRoomInfo;
        }
        if (z2 && this.mRH != null) {
            this.mXh.setVisibility(0);
            this.mXr.setVisibility(0);
            this.mXn.setVisibility(8);
            this.mXx.setVisibility(8);
            this.mXo.setVisibility(0);
            this.mXt.h(this.mRH.eventIcon, com.kascend.chushou.view.a.a(this.mWf.mCreatorGender), b.a.small, b.a.small);
            this.mXj.h(this.mRH.eventIcon, com.kascend.chushou.view.a.a(this.mWf.mCreatorGender), b.a.small, b.a.small);
            this.mXu.setText(this.mRH.eventName);
            this.mXv.setText(this.mRH.eventDesc);
            this.mXk.setText(this.mRH.eventName);
            this.mXl.setText(this.mRH.eventDesc);
            this.mXp.setText(this.mRH.nickname);
            dCV();
            if (z) {
                c(this.mRH.remainTime);
                return;
            }
            return;
        }
        this.mXh.setVisibility(8);
        this.mXr.setVisibility(8);
        this.mXn.setVisibility(0);
        this.mXx.setVisibility(0);
        this.mXo.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mXy != null) {
            this.mXy.dispose();
            this.mXy = null;
        }
        this.mXy = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJj()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mYr != null && (c.this.mYr instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mYr).u();
                }
            }
        });
    }

    private void dCU() {
        if (this.mWf != null && this.mWd) {
            this.mUY.setVisibility(0);
            this.mUZ.setVisibility(0);
            this.mSh.setVisibility(0);
            this.mVa.h(this.mWf.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mWf.mCreatorGender), b.a.small, b.a.small);
            this.mVb.setText(this.mWf.mCreatorNickname);
            this.mVe.h(this.mWf.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mWf.mCreatorGender), b.a.small, b.a.small);
            this.mVf.setText(this.mWf.mCreatorNickname);
            dDE();
            dCW();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dDE() {
        if (this.mWf != null) {
            this.mVc.setText(tv.chushou.zues.utils.b.formatNumber(this.mWf.mOnlineCount));
            this.mVg.setText(tv.chushou.zues.utils.b.formatNumber(this.mWf.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCV() {
        if (this.mRH != null) {
            if (this.mRH.isSubscribe) {
                this.mXq.setText(a.i.like_already);
                this.mXq.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mXq.setText(getString(a.i.like));
            this.mXq.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCW() {
        if (this.mWf != null) {
            if (this.mWf.mIsSubscribed) {
                this.mVd.setText(getString(a.i.like_already));
                this.mVd.setBackgroundResource(a.e.bg_show_subcribe);
                this.mSe.setText(getString(a.i.like_already));
                this.mSe.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mVd.setText(getString(a.i.like));
            this.mVd.setBackgroundResource(a.e.bg_show_subcribe);
            this.mSe.setText(getString(a.i.like));
            this.mSe.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dCX() {
        if (this.mWy != null) {
            this.mWy.notifyDataSetChanged();
        }
    }

    private void dCY() {
        this.mVp = this.mYb.findViewById(a.f.tv_interact);
        this.mVp.setOnClickListener(this);
        this.mVu = (RelativeLayout) this.mYb.findViewById(a.f.rl_edit_bar);
        this.mVs = (ImageView) this.mYb.findViewById(a.f.btn_hotword);
        this.mVs.setOnClickListener(this);
        this.mVt = (ImageView) this.mYb.findViewById(a.f.iv_task_badge);
        this.mVr = (AnimationSet) AnimationUtils.loadAnimation(this.mYr, a.C0690a.anim_hotword);
        this.mVr.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dBV().c) {
                    c.this.mVs.clearAnimation();
                    c.this.mVs.startAnimation(c.this.mVr);
                }
            }
        });
        if (com.kascend.chushou.d.h.dBV().c) {
            this.mVs.startAnimation(this.mVr);
            this.mVt.setVisibility(0);
        }
        this.mXz = (TextView) this.mYb.findViewById(a.f.tv_bottom_input);
        this.mXz.setOnClickListener(this);
        this.mZq = (FrescoThumbnailView) this.mYb.findViewById(a.f.ll_btn_set);
        this.mZq.setOnClickListener(this);
        this.mZq.xo(a.e.ic_room_set_btn_white);
        this.mVD = (LinearLayout) this.mYb.findViewById(a.f.ll_bottom_all_button);
        this.mVE = (FrescoThumbnailView) this.mYb.findViewById(a.f.fl_clear_bottom_gift);
        this.mVE.setAnim(true);
        this.mVE.setOnClickListener(this);
        this.mVE.xo(a.e.ic_show_gift_n);
        this.mVF = (FrameLayout) this.mYb.findViewById(a.f.flfl_clear_bottom_gift);
        this.mVF.setVisibility(8);
        this.mVq = (RelativeLayout) this.mYb.findViewById(a.f.rl_bottom_input);
        this.mVq.setVisibility(0);
        this.mVv = (PastedEditText) this.mYb.findViewById(a.f.et_bottom_input);
        this.mVv.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mSx.setEnabled(editable.length() > 0);
            }
        });
        this.mVv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mSx);
                    return true;
                }
                return true;
            }
        });
        this.mVv.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.mVv);
                }
                return false;
            }
        });
        this.mSH = (ImageView) this.mYb.findViewById(a.f.iv_btn_emoji);
        this.mSH.setVisibility(8);
        this.mSx = (TextView) this.mYb.findViewById(a.f.tv_btn_send);
        this.mSx.setOnClickListener(this);
        this.mVN = (LinearLayout) this.mYb.findViewById(a.f.head_trumpet);
        this.mVN.setVisibility(8);
        this.mVN.setOnClickListener(this);
        this.mVO = (TextView) this.mYb.findViewById(a.f.tv_primary_name);
        this.mVP = (TextView) this.mYb.findViewById(a.f.tv_primary_desc);
        this.mVR = (TextView) this.mYb.findViewById(a.f.tv_cut_count);
        this.mVR.setOnClickListener(this);
        this.mVT = (TextView) this.mYb.findViewById(a.f.tv_head_count);
        this.mVT.setText(this.mVW + "");
        this.mVS = (TextView) this.mYb.findViewById(a.f.tv_plus_count);
        this.mVS.setOnClickListener(this);
        this.mTc = (TextView) this.mYb.findViewById(a.f.tv_buy_count_coin);
        this.mVQ = (TextView) this.mYb.findViewById(a.f.tv_buy_head);
        this.mVQ.setOnClickListener(this);
        this.mVU = (ImageView) this.mYb.findViewById(a.f.iv_trumpet_select);
        this.mVU.setOnClickListener(this);
        this.mVV = (TextView) this.mYb.findViewById(a.f.tv_trumpet_have_count);
        this.mVX = false;
        this.mVU.setBackgroundResource(a.e.ic_trumpet_n);
        this.mVV.setVisibility(8);
        this.mSG = (KPSwitchPanelLinearLayout) this.mYb.findViewById(a.f.chat_extended_container);
        dDe();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mSG, this.mSH, this.mVv, new a.InterfaceC0817a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0817a
            public void wi(boolean z) {
                if (c.this.mSH != null) {
                    if (z) {
                        c.this.mSG.setDirectVisibility(0);
                        c.this.mSH.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mSH.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mSK = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wj(boolean z) {
                c.this.mSI = z;
                if (z) {
                    c.this.mSH.setImageResource(a.e.cs_emoji_normal);
                    c.this.dDa();
                    if (c.this.mXg != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mXg.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ho(c.this.mYr);
                        c.this.mXg.setLayoutParams(layoutParams);
                    }
                    if (c.this.mVu != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mVu.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ho(c.this.mYr);
                        c.this.mVu.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mXg != null && c.this.mXg.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mXg.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mXg.setLayoutParams(layoutParams3);
                    c.this.mXg.setVisibility(8);
                }
                if (c.this.mWA) {
                    c.this.mYW.setVisibility(0);
                }
                if (c.this.mYr != null && (c.this.mYr instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mYr).wh(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mVu != null && c.this.mSG.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mVu.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mVu.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mSJ = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mSG, this.mSK, ((VideoPlayer) this.mYr).dCk());
        ((VideoPlayer) this.mYr).g(((VideoPlayer) this.mYr).dCk());
        this.mXg = this.mYb.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mXd = (TextView) this.mYb.findViewById(a.f.btn_room_search);
        this.mXe = (ImageView) this.mYb.findViewById(a.f.iv_room_emoji_delete);
        this.mXf = (EditText) this.mYb.findViewById(a.f.et_room_emoji_search);
        this.mXf.setImeOptions(3);
        this.mXf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mXd);
                    return true;
                }
                return false;
            }
        });
        this.mXf.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mXd.setEnabled(editable.length() > 0);
                c.this.mXe.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mYW.setEmojiSearchText(editable.toString());
            }
        });
        this.mXd.setOnClickListener(this);
        this.mXe.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mXf);
            this.mXg.setVisibility(0);
            this.mXf.requestFocus();
        } else {
            this.mXg.setVisibility(8);
        }
        if (z2) {
            this.mXf.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDa() {
        int ho = tv.chushou.zues.widget.kpswitch.b.d.ho(this.mYr) + tv.chushou.zues.utils.a.dip2px(this.mYr, 14.0f);
        if (ho > this.mUS) {
            b(ho, 12);
        }
    }

    private void dDe() {
    }

    private void dDg() {
        if (this.mVZ > 0) {
            View findViewById = this.mYb.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mVZ);
        }
        if (this.mVY > 0) {
            View findViewById2 = this.mYb.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mVY, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mWw) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dDl();
        a();
        this.mRB = ((VideoPlayer) this.mYr).dCh();
        this.mRB.a(this);
        if (this.mYq.dCF() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mRB != null) {
            this.mRB.d();
        }
    }

    private void dDh() {
        if ((this.mRE == null || this.mRE.mUG == null || !this.mRE.mUG.mInPKMode) ? false : true) {
            if (this.mUT != null) {
                this.mUT.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRG.getLayoutParams();
            layoutParams.leftMargin = (this.mWO.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mYr, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mRG.setLayoutParams(layoutParams);
            this.y.setText(this.mRE.mUG.mPkUserNickname);
            this.mRG.setVisibility(0);
            this.mVk.setVisibility(8);
            return;
        }
        if (this.mUT != null) {
            this.mUT.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mRG.setVisibility(8);
    }

    private void dDi() {
        boolean z = false;
        if (this.mRE != null && this.mRE.mUG != null && this.mRE.mUG.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mWZ > 0 && this.mWe != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWe.getLayoutParams();
                if (layoutParams.height != this.mWZ) {
                    layoutParams.height = this.mWZ;
                    this.mWe.setLayoutParams(layoutParams);
                }
            }
            this.mUS = ((int) (tv.chushou.zues.utils.a.hd(this.mYr).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYr, 84.0f);
            b(this.mUS, 12);
        } else {
            if (this.mWe != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mWe.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mYr, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mYr, 250.0f);
                    this.mWe.setLayoutParams(layoutParams2);
                }
            }
            this.mUS = ((int) (tv.chushou.zues.utils.a.hd(this.mYr).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYr, 84.0f);
            b(this.mUS, 12);
        }
        if (this.mRF != null) {
            this.mRF.a(this.mWZ + tv.chushou.zues.utils.a.dip2px(this.mYr, 52.0f), this.mYv);
        }
        if (this.mRJ != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mRJ.getLayoutParams();
            layoutParams3.bottomMargin = this.mWZ + tv.chushou.zues.utils.a.dip2px(this.mYr, 52.0f);
            this.mRJ.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dDk();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dDk();
    }

    private void dDj() {
        dDi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDk() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dDQ().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mWO = tv.chushou.zues.utils.a.he(this.mYr);
        this.mWN = 86;
        this.mWK = (Math.max(this.mWO.x, this.mWO.y) - tv.chushou.zues.utils.a.dip2px(this.mYr, (this.mWN + 52) + 250)) - this.mVY;
        this.mWL = Math.max(this.mWO.x, this.mWO.y) - ((tv.chushou.zues.utils.a.dip2px(this.mYr, this.mWN) + this.mVY) * 2);
        if (this.mWP <= 0 || this.mWQ <= 0) {
            this.mWP = Math.min(this.mWO.x, this.mWO.y);
            this.mWQ = Math.max(this.mWO.x, this.mWO.y);
        }
        this.ar = Math.min(this.mWO.x, this.mWO.y);
        this.mYv = (this.ar * this.mWQ) / this.mWP;
        boolean z = false;
        if (this.mRE == null || this.mRE.mUG == null) {
            i = 1;
        } else {
            i = this.mRE.mUG.mMode;
            if (this.mRE.mUG.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mWN = 42;
            if (i == 2) {
                if (this.mWQ < this.mWP) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mYv;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mYv;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mWP * layoutParams.height) / this.mWQ;
                    layoutParams2.height = layoutParams.height;
                    this.mYv = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYv;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYv;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, this.mWN) + this.mVY;
            layoutParams.gravity = 48;
            this.mWZ = ((this.mWO.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mYr, (this.mWN + 52) + 64) + this.mVY)) - tv.chushou.zues.utils.systemBar.b.aE(getActivity());
            dCO();
        } else if (this.E) {
            this.mWN = 42;
            if (this.mWQ < this.mWP) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYv;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYv;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mWP * layoutParams.height) / this.mWQ;
                layoutParams2.height = layoutParams.height;
                this.mYv = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, this.mWN) + this.mVY;
            layoutParams.gravity = 48;
            this.mWZ = ((this.mWO.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mYr, (this.mWN + 52) + 98) + this.mVY)) - tv.chushou.zues.utils.systemBar.b.aE(getActivity());
            dDj();
        } else {
            this.mWZ = -1;
            this.mWN = 86;
            if (this.mYv <= this.mWK) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mWK;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, this.mWN) + this.mVY;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYv;
            } else if (this.mYv < this.mWL) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYv;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, this.mWN) + this.mVY;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYv;
            } else {
                this.mYv = Math.max(this.mWO.x, this.mWO.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mYv;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mYv * this.mWP) / this.mWQ >= this.ar) {
                        i3 = this.mYv;
                        i2 = (this.mYv * this.mWP) / this.mWQ;
                    } else if ((this.ar * this.mWQ) / this.mWP >= this.mYv) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mWQ) / this.mWP;
                    } else {
                        i2 = this.ar;
                        i3 = this.mYv;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mYv) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mWQ) / this.mWP > this.mYv) {
                        i3 = this.mYv;
                        i2 = (this.mYv * this.mWP) / this.mWQ;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mWQ) / this.mWP;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mWQ) / this.mWP;
                        if (i3 > this.mYv) {
                            i3 = this.mYv;
                            i2 = (this.mYv * this.mWP) / this.mWQ;
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
        if (this.mYq != null && this.mYq.d) {
            layoutParams.width = Math.min(this.mWO.x, this.mWO.y);
            layoutParams.height = Math.max(this.mWO.x, this.mWO.y);
        }
        dDQ().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dDl() {
        this.N = new SurfaceRenderView(this.mYr);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dDQ().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mWF) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dDH();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dDG();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mXC != null) {
            this.mXC.a();
        }
        if (this.mYq != null && !h.isEmpty(this.mYq.mRn)) {
            b(this.mYq.mRn);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mUF != null) {
            int width = this.mUF.getWidth();
            int height = this.mUF.getHeight();
            if (this.mWP != width || this.mWQ != height || this.mWP <= 0 || this.mWQ <= 0) {
                this.mWP = width;
                this.mWQ = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dDk();
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
            if (this.mWA) {
                dDn();
            } else {
                if (this.mYr.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYq.dCF().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mVX) {
                f(this.mVv.getText().toString());
            } else {
                a(this.mVv.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dBV().c) {
                com.kascend.chushou.d.h.dBV().b(false);
                this.mVr.cancel();
                this.mVr.reset();
                this.mVs.clearAnimation();
                this.mVt.setVisibility(8);
            }
            l(view, 0, this.mYb.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mYr, 165.0f) / 2);
            k(view, x >= 0 ? x : 0, this.mYb.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mYq.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mYq.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mWe != null) {
                u(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mWf != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mWE = 1;
            wk(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mYr, (JSONObject) null, this.mYq.dCH().mRoomID, this.mYq.dCH().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mYr.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mYr, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mWH != null) {
                    com.kascend.chushou.d.e.a(this.mYr, this.mWH, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mXc != null) {
                    this.mXc.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mYr, null) && this.mYq != null && this.mYq.mRo != null) {
                    if (this.mVX) {
                        dDO();
                    } else {
                        if (this.mYq != null && this.mYq.mRo != null && this.mYq.mRo.count > 0) {
                            this.mVN.setVisibility(8);
                        } else {
                            this.mVN.setVisibility(0);
                        }
                        this.mVX = true;
                        this.mVU.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mVV.setVisibility(0);
                        this.mVV.setSelected(true);
                        this.mVV.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mVv != null) {
                            this.mVv.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mVW <= 9) {
                    this.mVW++;
                    this.mVT.setText(this.mVW + "");
                }
                dCP();
            } else if (id == a.f.tv_cut_count) {
                if (this.mVW > 1) {
                    this.mVW--;
                    this.mVT.setText(this.mVW + "");
                }
                dCP();
            } else if (id == a.f.tv_buy_head) {
                dDN();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mXf.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mXf.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mXg.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dM(this.mXf);
                    this.mYW.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mRH != null && !h.isEmpty(this.mRH.eventUrl)) {
                    f("", this.mRH.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mRH != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mRH != null) {
                    com.kascend.chushou.d.a.a(this.mYr, (JSONObject) null, this.mRH.roomId, this.mRH.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mYq.a(false);
                    ((VideoPlayer) this.mYr).l();
                } else {
                    ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.mVM != null) {
            int i = (tv.chushou.zues.utils.a.hd(this.mYr).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVM.getLayoutParams();
            layoutParams.topMargin = i;
            this.mVM.setLayoutParams(layoutParams);
            this.mVM.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mVM.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
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
        } else if (System.currentTimeMillis() - this.mWD <= 3000) {
            tv.chushou.zues.utils.g.Om(a.i.str_too_fast);
            return false;
        } else {
            cXT();
            if (!com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYr).dCg().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mWD = System.currentTimeMillis();
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                a(this.mYq.dCF().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYq.h);
            }
            g(this.b);
            if (!z && this.mVv != null) {
                this.mVv.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            cXT();
            if (com.kascend.chushou.d.e.c(this.mYr, null) && LoginManager.Instance().getUserInfo() != null && this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                a(this.mYq.dCF().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mVv != null) {
                this.mVv.setText((CharSequence) null);
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
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mYq.dCF().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mYq.dCF().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mYr).mPA;
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
        if (this.mYQ != null && this.mYQ.isShowing()) {
            this.mYQ.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
        if (this.mZn == null) {
            i(3);
        }
        this.mZn.getContentView().setBackgroundResource(0);
        this.mZn.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mZn.isShowing()) {
            this.mZn.showAtLocation(view, 83, i, i2);
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mYq.dCF().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mZn.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDf() {
        if (h.isEmpty(this.mZr)) {
            if (((VideoPlayer) this.mYr).q) {
                this.mZq.xo(a.e.ic_room_set_btn_white);
            } else {
                this.mZq.xo(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mYr).q && this.mZr.size() == 2 && this.mZr.contains("4") && this.mZr.contains("2")) {
            this.mZq.xo(a.e.ic_room_set_btn_system_white);
        } else if (this.mZr.size() > 1 || !((VideoPlayer) this.mYr).q) {
            this.mZq.xo(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mZr.get(0))) {
            this.mZq.xo(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mZr.get(0))) {
            this.mZq.xo(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mZr.get(0))) {
            this.mZq.xo(a.e.ic_room_set_btn_system_white);
        }
    }

    private void l(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
        if (this.mYQ == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mYQ.getContentView().setBackgroundResource(0);
            this.mYQ.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYQ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mVs.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mYQ.isShowing()) {
            this.mYQ.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mYr, 16.0f) + i2);
            this.mVs.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYq.dCF().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYQ.dismiss();
    }

    private void dB(View view) {
        if (this.mYK == null) {
            dDq();
        }
        if (com.kascend.chushou.d.h.dBV().q()) {
            this.mVw.dQj();
        } else {
            this.mVw.dQk();
        }
        int height = this.mYb.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity());
        if (view != null) {
            this.mYK.showAtLocation(view, 85, 0, height);
        }
    }

    private void dDq() {
        if (this.mYK == null) {
            View inflate = LayoutInflater.from(this.mYr).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mVw = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dBV().q()) {
                this.mVw.dQj();
            } else {
                this.mVw.dQk();
            }
            this.mVw.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dBV().g(z);
                }
            });
            this.mYE = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mYF = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mYE.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mYE.setVisibility(0);
            } else {
                this.mYE.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dBV().a) {
                this.mYF.b();
            } else {
                this.mYF.c();
            }
            if (this.mYq != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mYq.f;
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
                                if (this.mRE == null || !this.mRE.mUG.mInPKMode || h.isEmpty(this.mRE.b) || this.mWf == null || !this.mRE.b.equals(this.mWf.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mYr).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dCG = this.mYq.dCG();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mYr).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYr, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, 5.0f);
                                            }
                                            int identifier = this.mYr.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mYr.getPackageName());
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
                                                if (dCG != null && dCG.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mYr.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mYr).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dCG2 = this.mYq.dCG();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mYr).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYr, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, 5.0f);
                                        }
                                        int identifier2 = this.mYr.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mYr.getPackageName());
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
                                            if (dCG2 != null && dCG2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dDr();
                        c.this.mYK.dismiss();
                    }
                }
            });
            this.mYK = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 150.0f), -2);
            this.mYK.setFocusable(true);
            this.mYK.setOutsideTouchable(true);
            this.mYK.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mYK = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDr() {
        if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
            if (this.mVL == null) {
                this.mVL = new f(getActivity());
            }
            this.mVL.a(this.mYq.dCF().mRoominfo, this.ax);
            if (!this.mVL.isShowing()) {
                this.mVL.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mWF) {
            return false;
        }
        if (this.mWE == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mXA = motionEvent.getX();
                    this.mXB = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mXA;
                    if (Math.abs(f) > Math.abs(y - this.mXB) && Math.abs(f) > q && f > 0.0f) {
                        dDJ();
                        return true;
                    }
                    this.mXA = 0.0f;
                    this.mXB = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mXg != null && this.mXg.getVisibility() == 0 && b(motionEvent, this.mXg)) {
                this.mXg.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mXf);
                return true;
            } else if (this.mWA && this.mXg != null && this.mXg.getVisibility() == 8 && g(this.mYW.b, motionEvent)) {
                dDn();
                return true;
            } else if (this.mVM != null && this.mVM.b() && g(this.mVM, motionEvent)) {
                this.mVM.a();
                return true;
            } else if (this.mVC != null && this.mVC.b() && g(this.mVC, motionEvent)) {
                this.mVC.a();
                return true;
            } else if (b(motionEvent, this.mVu)) {
                return cXT();
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
            if (this.mZh != null && this.mZh.a(i, keyEvent)) {
                return true;
            }
            if ((this.mVM != null && this.mVM.onKeyDown(i, keyEvent)) || dDb()) {
                return true;
            }
            if (this.mWE == 3) {
                this.mWE = 1;
                dDJ();
                return true;
            } else if (this.mVC != null && this.mVC.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mVv != null && this.mVq != null && this.mVu != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mVv);
                this.mVq.setVisibility(8);
                this.mVu.setVisibility(0);
            }
        } else if (this.mVq != null && this.mVu != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
            this.mVq.setVisibility(0);
            this.mVu.setVisibility(8);
        }
    }

    public boolean cXT() {
        boolean z;
        b(this.mUS, 12);
        boolean z2 = false;
        if (this.mSG != null && this.mSG.getVisibility() == 0) {
            this.mSG.setVisibility(8);
            this.mSH.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSI) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYr);
            this.mSH.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mVu == null || this.mVu.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mVX) {
                dDO();
            }
            this.mVu.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mVq != null) {
                    c.this.mVq.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dDb() {
        if (cXT()) {
            return true;
        }
        if (this.mYQ != null && this.mYQ.isShowing()) {
            this.mYQ.dismiss();
            return true;
        } else if (this.mZn != null && this.mZn.isShowing()) {
            this.mZn.dismiss();
            return true;
        } else if (this.mYK == null || !this.mYK.isShowing()) {
            return dDn() || dDd() || dDm() || dDc();
        } else {
            this.mYK.dismiss();
            return true;
        }
    }

    public boolean dDc() {
        if (this.mZa == null || !this.mZa.isShown()) {
            return false;
        }
        this.mZa.d();
        return true;
    }

    public boolean dDd() {
        if (this.mWC == null || !this.mWC.isShown()) {
            return false;
        }
        this.mWC.a();
        return true;
    }

    public boolean dDm() {
        if (this.mVM == null || !this.mVM.b()) {
            return false;
        }
        this.mVM.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mYr != null && !((Activity) this.mYr).isFinishing() && pVar != null) {
            this.mWn = pVar.a;
            u(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dDP() && this.mWf != null && mVar.a(this.mWf.mCreatorUID, null)) {
            this.mWf.mIsSubscribed = mVar.c;
            dCW();
        }
    }

    public boolean dDn() {
        if (!this.mWA || this.mYW == null) {
            return false;
        }
        if (this.mYW != null) {
            this.mYW.e();
        }
        if (this.mXf != null) {
            this.mXf.setText("");
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
        if (!dDP() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mWJ != null) {
                        this.mWJ.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                        this.mYq.dCF().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mYq.dCF().mMicStatus.onMic) {
                            if (this.mVk != null) {
                                this.mVk.setVisibility(8);
                            }
                            if (this.mWC != null && this.mWC.isShown()) {
                                this.mWC.a();
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
                        if (this.mYq.dCF().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mWf != null && !h.isEmpty(this.mWf.mCreatorUID)) {
                                i(arrayList2, this.mWf.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).a(!this.F);
                            }
                        } else if (this.mYq.dCF().mMicStatus.onMic) {
                            if (this.mYq.dCF().mMicStatus != null && !h.isEmpty(this.mYq.dCF().mMicStatus.micRoomId) && !this.mYq.dCF().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mYq.dCF().mMicStatus.micRoomId;
                            }
                            this.mYq.dCF().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mYq.dCF().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = j(this.mYq.dCF().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mYq.dCF().mMicStatus, str3, z4);
                            if (this.mWC != null && this.mWC.getVisibility() == 0) {
                                this.mWC.a(this.mYq.dCF().mFanItems, this.mYq.dCF().mMicStatus, str3, z4, this.mYq.dCF().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mVk != null) {
                                this.mVk.setVisibility(8);
                            }
                            if (this.mWC != null && this.mWC.isShown()) {
                                this.mWC.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mWb != onlineVip.mCount || (this.mVh != null && this.mVh.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mWb = onlineVip.mCount;
                        this.mVi = onlineVip.mCount;
                        dDv();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mWz.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mWz.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mWz.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mWW <= 5000) {
                                z2 = false;
                            } else {
                                this.mWW = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mWz.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mWz.addAll(onlineVip.mOnlineVipItems);
                            }
                            dCX();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mWX != null) {
                    if (this.mWf == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mWf.mCreatorAvatar;
                        str2 = this.mWf.mCreatorGender;
                    }
                    this.mWX.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mRE != null && this.mRE.mUG != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mRE.mUG.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mRB != null) {
                                        this.mRB.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mRE.mUG.mInPKMode = true;
                                    this.mRE.mUG.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRE.mUG.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRE.mUG.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRE.mUG.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRE.mUG.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRE.mUG.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mRE.mUG.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mRE.mUG.mMode = pkNotifyInfo.mMode;
                                    this.mRE.mUG.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mRF != null) {
                                        this.mRF.g(true, this.mRE.mUG.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dBV().a) {
                                        if (!com.kascend.chushou.b.dBO().e) {
                                            com.kascend.chushou.b.dBO().e = true;
                                            tv.chushou.zues.utils.g.M(this.mYr, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBV().a(this.mYr, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mRE.mUG.mAction = 7;
                                    this.mRE.mUG.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRE.mUG.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRE.mUG.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRE.mUG.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRE.mUG.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRE.mUG.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mRE.mUG.mMode == 2) {
                                        dDk();
                                    } else {
                                        dCO();
                                    }
                                    if (this.mRF != null) {
                                        this.mRF.g(false, 0L);
                                        this.mRF.b(this.mRE.mUG, true);
                                        this.mRF.a(this.mWZ + tv.chushou.zues.utils.a.dip2px(this.mYr, 52.0f), this.mYv);
                                        this.mRF.a(this.mRE.mUG.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mRB != null) {
                                        this.mRB.a(false);
                                    }
                                    this.mRE.mUG.mInPKMode = false;
                                    this.mRE.mUG.mAction = 2;
                                    dCO();
                                    dDk();
                                    if (this.mRF != null) {
                                        this.mRF.c();
                                    }
                                    this.mRE.b = null;
                                    this.mRE.mUG = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mRE.mUG.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mRE.mUG.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mRE.mUG.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mWf != null && !h.isEmpty(this.mWf.mRoomID) && this.mWf.mRoomID.equals(this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mRE.mUG.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mRF != null) {
                                        this.mRF.a(this.mRE.mUG, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mRE.mUG.copyUpdate(pkNotifyInfo);
                                    if (this.mRF != null) {
                                        this.mRF.a(this.mRE.mUG);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mRE.mUG.copyStop(pkNotifyInfo);
                                        if (this.mRF != null) {
                                            this.mRF.w(this.mRE.mUG.mMaxFreeDuration, this.mRE.mUG.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mRE.mUG.copyResult(pkNotifyInfo);
                                    if (!this.mWx && this.mRF != null) {
                                        int i7 = 1;
                                        if (this.mRE.mUG.destinyInfo != null && this.mRE.mUG.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mRF.a(h.parseInt(this.mRE.mUG.mResult), h.parseLong(this.mRE.mUG.mvpUid), this.mRE.mUG.mvpAvatar, this.mRE.mUG.mvpNickname, this.mRE.mUG.mMaxFreeDuration, this.mRE.mUG.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mRH != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mRH.uid = cycleLiveRoomInfo.uid;
                        this.mRH.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mRH.roomId = cycleLiveRoomInfo.roomId;
                        this.mRH.avatar = cycleLiveRoomInfo.avatar;
                        this.mRH.nickname = cycleLiveRoomInfo.nickname;
                        s(false);
                        if (this.mYr != null && (this.mYr instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mYr).d();
                        }
                    } else {
                        ((VideoPlayer) this.mYr).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mYq != null && this.mYq.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dBV().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dBV().b().equals(next2.mUserID)) {
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

    public void dDv() {
        if (this.mVh != null) {
            if (this.mRE == null || this.mRE.mUG == null || !this.mRE.mUG.mInPKMode) {
                if (this.mVi > 0) {
                    this.mVh.setVisibility(0);
                    this.mVh.setText(String.format(this.mYr.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mVi))));
                    this.mVm.setVisibility(0);
                    return;
                }
                this.mVh.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mVk.setVisibility(0);
            if (this.mVl != null) {
                this.mVl.a(str, z, micStatus, this.mYq.dCF().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mVk.setVisibility(8);
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
    public void dDs() {
        int childCount = this.mWh.getChildCount();
        int itemCount = this.mWh.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mWh);
        if (f + childCount >= itemCount) {
            this.mWo = true;
            if (this.mWp != null) {
                this.mWp.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                u(true);
            }
        }
    }

    public void dDB() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mWi.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mWi.add(1, chatInfo2);
    }

    private void u(boolean z) {
        if (this.mWi == null) {
            this.mWi = new ArrayList<>();
        }
        while (2 < this.mWi.size()) {
            this.mWi.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mWk);
        if (a2 == null) {
            v(false);
            return;
        }
        this.mWi.addAll(a2);
        int size = this.mWi.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mWi.size(); i++) {
                this.mWi.remove(2);
            }
        }
        v(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mWl == null) {
            this.mWl = new ArrayList<>();
        }
        this.mWl.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mWn != null && this.mWn.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mWn.contains("2"))) {
                        this.mWl.add(next);
                    } else if (!this.mWn.contains(next.mType)) {
                        this.mWl.add(next);
                    }
                }
                return this.mWl;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mWi == null) {
                    this.mWi = new ArrayList<>(arrayList);
                    dDB();
                    v(z2);
                    return;
                }
                if (this.mWk == null) {
                    this.mWk = new ArrayList<>();
                }
                this.mWk.addAll(arrayList);
                int size = this.mWk.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mWk.size(); i++) {
                        this.mWk.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mWi.size();
                if (a2 != null) {
                    this.mWi.addAll(a2);
                }
                int size3 = this.mWi.size();
                if (!this.mWo && this.mWp != null) {
                    this.mWp.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mWi.size(); i3++) {
                        this.mWi.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mWi == null) {
                this.mWi = new ArrayList<>(arrayList);
                dDB();
            } else {
                if (this.mWk == null) {
                    this.mWk = new ArrayList<>();
                }
                this.mWk.clear();
                this.mWk.addAll(arrayList);
                this.mWi.clear();
                dDB();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mWi.addAll(a3);
                }
            }
            v(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mWm != null) {
                this.mWm.a(this.mWi.size());
                if (i == 1) {
                    this.mWm.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mWm.notifyItemRangeRemoved(i2, i3);
                    this.mWm.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mWm.notifyDataSetChanged();
                }
            }
            if (z || this.mWo) {
                this.mWo = true;
                if (this.mWp != null) {
                    this.mWp.setVisibility(8);
                }
                if (z) {
                    this.mWe.scrollToPosition(this.mWi.size() - 1);
                } else {
                    this.mWe.smoothScrollToPosition(this.mWi.size() - 1);
                }
            }
        }
    }

    private void v(boolean z) {
        if (!this.ah) {
            if (this.mWm != null) {
                this.mWm.a(this.mWi.size());
                this.mWm.notifyDataSetChanged();
            }
            if (z || this.mWo) {
                this.mWo = true;
                if (this.mWp != null) {
                    this.mWp.setVisibility(8);
                }
                if (z) {
                    this.mWe.scrollToPosition(this.mWi.size() - 1);
                } else {
                    this.mWe.smoothScrollToPosition(this.mWi.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dCq;
        RoomToast roomToast;
        this.p = false;
        if (this.mYq != null && this.mYq.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mYq.f.size()) {
                    break;
                } else if (!"2".equals(this.mYq.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dDF();
            return;
        }
        if (this.mRT != null) {
            this.mRT.setVisibility(0);
        }
        if (this.mUX != null) {
            this.mUX.setVisibility(0);
        }
        if (this.mYq != null) {
            this.mWf = this.mYq.dCH();
            this.mWg = this.mYq.dCF();
            if (com.kascend.chushou.b.dBO().c != null && this.mWm != null) {
                this.mWm.a(com.kascend.chushou.b.dBO().c);
                this.mWm.notifyDataSetChanged();
            }
            FullRoomInfo dCF = this.mYq.dCF();
            if (dCF != null) {
                if (!h.isEmpty(dCF.mRoomToastList)) {
                    Iterator<RoomToast> it = dCF.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dBV().j())) {
                    a(roomToast);
                }
            }
            if (this.mWf != null) {
                dDK();
            }
            if (this.mWf != null && !this.mWf.mIsSubscribed) {
                RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mWf == null || !c.this.mWf.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mYq != null && this.mYq.l()) {
                d(true);
            }
        }
        if (this.mWf != null && this.mWm != null) {
            if (this.mWi != null) {
                this.mWi.clear();
            } else {
                this.mWi = new ArrayList<>();
            }
            this.mWm.a(this.mWf);
            dDB();
            this.mWm.a(this.mWi.size());
            this.mWm.notifyDataSetChanged();
        }
        dCU();
        N();
        if (this.mYr != null && (this.mYr instanceof VideoPlayer) && (dCq = ((VideoPlayer) this.mYr).dCq()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dCq.mUG, dCq.b);
        }
        this.mVz.h(this.mWf.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mWf.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mVD);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dDt() {
        if (this.mWa == null) {
            View inflate = LayoutInflater.from(this.mYr).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mTp = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mWa = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYr, 160.0f), -2);
            this.mWa.setFocusable(false);
            this.mWa.setOutsideTouchable(false);
            this.mWa.setAnimationStyle(a.j.gift_toast_style);
            this.mWa.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dBV().c(roomToast.mToastContent);
            if (this.mWa == null) {
                dDt();
            }
            if (this.mTp != null) {
                this.mTp.setText(roomToast.mToastContent);
            }
            if (!this.mWa.isShowing()) {
                if (this.mVD != null) {
                    this.mWa.showAtLocation(this.mVD, 85, 0, this.mYb.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aE(getActivity()));
                    RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mWa != null) {
                                c.this.mWa.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mWa.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mWS != null) {
            this.mWS.setVisibility(z ? 0 : 8);
        }
        this.mWT = true;
        if (this.mYr instanceof VideoPlayer) {
            ((VideoPlayer) this.mYr).p();
        }
    }

    private void dDF() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mYr).s();
        dDc();
        dDd();
        if (this.mVo == null) {
            this.mVo = (PlayShowRecommendView) ((ViewStub) this.mYb.findViewById(a.f.view_recommend)).inflate();
        }
        this.mVo.setVisibility(0);
        if (this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null && !h.isEmpty(this.mYq.dCF().mRoominfo.mRoomID)) {
            dDw();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYW != null) {
            this.mYW.e();
        }
        if (this.mRT != null) {
            this.mRT.setVisibility(4);
        }
        if (this.mUX != null) {
            this.mUX.setVisibility(8);
        }
        if (this.mZe != null) {
            this.mZe.dPF();
            this.mZe.setVisibility(8);
        }
        wo(false);
        a(false, false);
        if (this.mRB != null) {
            this.mRB.a();
        }
    }

    private void dDw() {
        if (this.mVo != null && this.mVo.getVisibility() == 0) {
            this.mVo.a(this.mYq.dCF().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.mYr instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYr;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mVM != null && this.mVM.b()) {
            this.mVM.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mWB);
        if (this.mYr != null) {
            if (this.mWB || "10004".equals(((VideoPlayer) this.mYr).t)) {
                this.mWB = true;
                if (this.mYq != null) {
                    this.mYq.f = null;
                    if (this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                        this.mYq.dCF().mRoominfo.mGameId = null;
                    }
                }
                dDF();
                return;
            }
            this.mWB = true;
            if (this.mYr != null) {
                ((VideoPlayer) this.mYr).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mWB = false;
        if (this.mRT != null) {
            this.mRT.setVisibility(0);
        }
        if (this.mUX != null) {
            this.mUX.setVisibility(0);
        }
        if (this.mVo != null) {
            this.mVo.setVisibility(8);
        }
        if (this.mYl != null) {
            this.mYl.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mWB = false;
        if (this.mRT != null) {
            this.mRT.setVisibility(0);
        }
        if (this.mUX != null) {
            this.mUX.setVisibility(0);
        }
        if (this.mVo != null) {
            this.mVo.setVisibility(8);
        }
        if (this.mYl != null) {
            this.mYl.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mVo != null) {
            this.mVo.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dDP()) {
            if (i()) {
                if (i == 404) {
                    if (this.mYq != null) {
                        this.mYq.f = null;
                        this.mYq.dCF().mRoominfo.mGameId = null;
                    }
                    dDF();
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
        if (this.mYq != null && this.mYq.dCG() != null) {
            a(this.mYq.dCG());
        }
        this.p = false;
        if (this.mYq == null || this.mYq.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mYq.f.size()) {
                if (!"2".equals(this.mYq.f.get(i2).mType)) {
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
    public GiftAnimationLayout dCZ() {
        if (this.mYb == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mYb.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mVD != null) {
            int size = iconConfig.configs.size();
            this.mVD.removeAllViews();
            if (this.mVF != null) {
                this.mVF.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mYr).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mVD, false);
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
                            this.mVF.setVisibility(0);
                            this.mVE.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.mVD.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYr instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCl = ((VideoPlayer) this.mYr).dCl();
            if (this.mZh == null) {
                this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mZh.setVisibility(0);
            this.mZh.a(2, dCl);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mVH != null && this.mYr != null) {
            this.mVH.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mVH != null && this.mYr != null) {
            this.mVH.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mVH != null) {
            this.mVH.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mVH != null) {
            this.mVH.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mVG != null) {
            if (this.mYr != null) {
                this.mVG.a(((VideoPlayer) this.mYr).dCl(), false);
            }
            this.mVG.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mYb != null) {
            Point hd = tv.chushou.zues.utils.a.hd(this.mYr);
            int i = hd.x > hd.y ? 1 : 2;
            if (this.mZh == null) {
                this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mZh.setPlayerViewHelper(this.mYq);
            this.mZh.setVisibility(0);
            this.mZh.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mVI != null) {
            this.mVI.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mVI != null) {
            this.mVI.a(bangInfo, str);
        }
        if (this.mSh != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mSh.setText(this.mYr.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mSh.setText(this.mYr.getString(a.i.str_contribute_tittle));
            } else {
                this.mSh.setText(Html.fromHtml(this.mYr.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mVj != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mVj.setText(this.mYr.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mVj.setText(this.mYr.getString(a.i.str_contribute_tittle));
            } else {
                this.mVj.setText(Html.fromHtml(this.mYr.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mVI != null) {
            this.mVI.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mYq != null && !h.isEmpty(this.mYq.mRm)) {
            this.mWH = this.mYq.mRm.get(0);
            if (this.mXa != null) {
                this.mXa.setVisibility(0);
                this.mXa.a(this.mWH.mCover, 0, 0, 0, 1);
                if (this.mXb != null) {
                    if (this.mWH.mShowClose) {
                        this.mXb.setVisibility(0);
                    } else {
                        this.mXb.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mVI != null) {
            this.mVI.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mYb != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mSG != null) {
            this.mSG.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dDP() && !this.mWx) {
            if (iVar.a == 52) {
                if (this.mWm != null) {
                    this.mWm.a(com.kascend.chushou.b.dBO().c);
                    this.mWm.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mWx && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dDP()) {
                    c.this.t(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mVv != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mVv);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dDP() && !this.mWx) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mYr, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCm = ((VideoPlayer) this.mYr).dCm();
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(2, dCm);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCn = ((VideoPlayer) this.mYr).dCn();
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(2, dCn);
            } else if (bVar.a == 8) {
                if (this.mWJ != null && this.mWJ.getVisibility() != 0) {
                    this.mWJ.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mWf == null ? "" : this.mWf.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mZh == null) {
                    this.mZh = (H5Container) ((ViewStub) this.mYb.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mZh.setVisibility(0);
                this.mZh.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dDP() && this.mYq != null && !h.isEmpty(this.mYq.a) && this.mYq.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mWJ != null && this.mWJ.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mYr, 80.0f);
                }
                if (this.mWI != null && this.mWI.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mWI.getHeight());
                }
                this.mWV.setTranslationY(-r0);
                return;
            }
            if (this.mWU != null) {
                this.mWU.cancel();
                this.mWU = null;
            }
            int translationY = (int) this.mWV.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mYr, 80.0f) : 0;
                    if (this.mWI != null && this.mWI.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mWI.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mWI.getHeight() : 0;
                    if (this.mWJ != null && this.mWJ.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mYr, 80.0f));
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
        this.mWU = ValueAnimator.ofInt(i, i2);
        this.mWU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dDP() && c.this.mVI != null) {
                    c.this.mWV.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mWU.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mWU = null;
            }
        });
        this.mWU.setInterpolator(new LinearInterpolator());
        this.mWU.setDuration(800L);
        this.mWU.start();
    }

    private boolean dDG() {
        if (this.mWE == 1) {
            this.mWE = 2;
            wk(true);
            return true;
        } else if (this.mWE == 3) {
            dDJ();
            return true;
        } else {
            return false;
        }
    }

    private boolean dDH() {
        if (this.mWE == 1) {
            return dDI();
        }
        if (this.mWE == 2) {
            this.mWE = 1;
            wk(false);
            return true;
        }
        return false;
    }

    private boolean dDI() {
        if (this.mWF || this.mYq == null || this.mYq.dCH() == null) {
            return false;
        }
        if (this.mXC != null) {
            this.mXC.a(true);
        }
        this.mWE = 3;
        this.mWF = true;
        dDK();
        this.mUU.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.mWF = false;
                c.this.mUW.setVisibility(8);
            }
        });
        this.mUW.startAnimation(loadAnimation);
        this.mUU.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDJ() {
        if (!this.mWF) {
            if (this.mXC != null) {
                this.mXC.a(false);
            }
            this.mWE = 1;
            this.mWF = true;
            dDK();
            this.mUW.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.mWF = false;
                    c.this.mUU.setVisibility(8);
                }
            });
            this.mUW.startAnimation(loadAnimation);
            this.mUU.startAnimation(loadAnimation2);
        }
    }

    private void dDK() {
        if (this.mYb != null) {
            if (this.mUU == null) {
                this.mUU = this.mYb.findViewById(a.f.user_space_container);
            }
            if (this.mUW == null) {
                this.mUW = this.mYb.findViewById(a.f.video_container);
            }
            if (this.mUV == null) {
                this.mUV = com.kascend.chushou.view.user.b.b(null, this.mYq.a, false, this.mYq.h);
                this.mUV.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dDJ();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dDJ();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mUV).commitAllowingStateLoss();
            }
        }
    }

    private void wk(boolean z) {
        Animation loadAnimation;
        if (this.mUX != null) {
            this.mUX.setVisibility(z ? 8 : 0);
        }
        if (this.mWc != null) {
            this.mWF = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mWc.setVisibility(8);
                        c.this.mWF = false;
                    }
                });
            } else {
                this.mWF = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mWc.setVisibility(0);
                        c.this.mWF = false;
                    }
                });
            }
            this.mWc.startAnimation(loadAnimation);
        }
        dDb();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mVp.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mVx != null) {
                this.mVx.setVisibility(0);
            }
            if (this.mVy != null) {
                this.mVy.a();
                return;
            }
            return;
        }
        if (this.mVA != null) {
            this.mVA.setVisibility(0);
        }
        if (this.mVB != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mVB.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mVA != null) {
            this.mVA.setVisibility(8);
        }
        if (this.mVB != null) {
            this.mVB.clearAnimation();
        }
        if (this.mVx != null) {
            this.mVx.setVisibility(8);
        }
        if (this.mVy != null) {
            this.mVy.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mWc != null && this.mYb != null) {
            if (this.mWJ == null) {
                this.mWJ = new com.kascend.chushou.player.ui.miniview.a(this.mYr, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mWJ != null && c.this.mYb != null && c.this.mWJ.a()) {
                            ((ViewGroup) c.this.mYb).removeView(c.this.mWJ);
                            c.this.mWJ = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWJ.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mYr, 52.0f);
                this.mWJ.setLayoutParams(layoutParams);
                ((ViewGroup) this.mWc).addView(this.mWJ, ((ViewGroup) this.mWc).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mWJ.setVisibility(8);
                } else {
                    this.mWJ.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mYq.a == null ? "" : this.mYq.a);
                }
            } else if (!this.mWJ.isShown()) {
                this.mWJ.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mYq.a == null ? "" : this.mYq.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mWR != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mWR.setVisibility(0);
                this.mWR.setAnim(true);
                this.mWR.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nYq, b.C0816b.nYr, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mWq != null && this.mWq.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dDL();
                    }
                });
                this.mWq.setVisibility(0);
                this.mWq.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mWq != null && this.mWq.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mWs != null) {
                        c.this.mWs.removeAllListeners();
                        c.this.mWs.cancel();
                        c.this.mWs = null;
                    }
                    if (c.this.mWq != null) {
                        c.this.mWq.setVisibility(8);
                    }
                }
            });
            this.mWq.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mWY == null) {
                this.mWY = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dDP()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mYr, "显示双击666_num", null, new Object[0]);
                            if (c.this.mYq != null) {
                                c.this.mYq.b(false);
                            }
                            c.this.d(false);
                            c.this.wl(true);
                        }
                    }
                };
                if (this.mYs != null) {
                    this.mYs.d(this.mWY, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mWY != null) {
            this.mYs.removeCallbacks(this.mWY);
            this.mWY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mWt != null && this.mWt.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mYr, a.C0690a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dDM();
                    }
                });
                this.mWt.setVisibility(0);
                this.mWt.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mYa, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.wl(false);
                    }
                });
            }
        } else if (this.mWt != null && this.mWt.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYr, a.C0690a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mWv != null) {
                        c.this.mWv.removeAllListeners();
                        c.this.mWv.cancel();
                        c.this.mWv = null;
                    }
                    if (c.this.mWt != null) {
                        c.this.mWt.setVisibility(8);
                    }
                }
            });
            this.mWt.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dDL() {
        if (this.mWq == null || this.mWr == null) {
            return null;
        }
        if (this.mWs != null) {
            this.mWs.removeAllListeners();
            this.mWs.cancel();
            this.mWs = null;
        }
        this.mWr.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mWr, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mWr, 0.0f);
        int measuredWidth = (this.mWq.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mYr, 13.0f) * 2)) - this.mWr.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mWr, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mWr, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mWr, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mWs != null) {
                    c.this.mWs.removeAllListeners();
                    c.this.mWs.cancel();
                    c.this.mWs = null;
                }
                RxExecutor.postDelayed(c.this.mYa, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dDL();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mWs = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dDM() {
        if (this.mWt == null || this.mWu == null) {
            return null;
        }
        if (this.mWv != null) {
            this.mWv.removeAllListeners();
            this.mWv.cancel();
            this.mWv = null;
        }
        this.mWu.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mWu, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mWu, 0.0f);
        int measuredWidth = (this.mWt.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mYr, 13.0f) * 2)) - this.mWu.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mWu, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mWu, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mWu, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mWv != null) {
                    c.this.mWv.removeAllListeners();
                    c.this.mWv.cancel();
                    c.this.mWv = null;
                }
                RxExecutor.postDelayed(c.this.mYa, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dDM();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mWv = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mXC = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mRH != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mRH.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dDP()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Om(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Om(a.i.subscribe_success);
                            }
                            if (c.this.mRH != null) {
                                c.this.mRH.isSubscribe = !z;
                                c.this.dCV();
                                return;
                            }
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dDP()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dBR().a(bVar, (String) null, this.mRH.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mRH.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dBR().b(bVar, (String) null, c.this.mRH.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mYq != null && this.mWf != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mYq.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mYq.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mWf.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dDP()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Om(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Om(a.i.subscribe_success);
                            }
                            c.this.mWf.mIsSubscribed = !z;
                            c.this.dCW();
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dDP()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dBR().a(bVar, (String) null, this.mWf.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mWf.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dBR().b(bVar, (String) null, c.this.mWf.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mUF != null) {
            int width = this.mUF.getWidth();
            int height = this.mUF.getHeight();
            if (this.mWP != width || this.mWQ != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mYr).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mYb != null) {
            if (this.mVC == null) {
                this.mVC = (InteractionView) ((ViewStub) this.mYb.findViewById(a.f.view_interaction)).inflate();
                this.mVC.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mVC.a();
                    }
                });
            }
            if (this.mVC != null) {
                this.mVC.b(configDetail);
                this.mVC.c();
                this.mVC.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQq()) {
                tv.chushou.zues.utils.g.M(this.mYr, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mYr, null) && (this.mYr instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYq != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYr, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mYr, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYq != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYr, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mYr, configDetail.mUrl, this.mYr.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mYr, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    if (this.mWA) {
                        dDn();
                        return;
                    }
                    if (this.mYr.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mYr, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mYq != null && this.mYq.dCF() != null && this.mYq.dCF().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYq.dCF().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dB(this.mVD);
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
        if (this.mYr != null && !this.v && !h.isEmpty(str) && this.mWf != null && str.equals(this.mWf.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mRE == null) {
                this.mRE = new com.kascend.chushou.player.e.a();
            }
            this.mRE.b = str;
            this.mRE.mUG.copy(pkNotifyInfo);
            if (this.mRE.mUG.mAction == 6) {
                if (this.mRB != null) {
                    this.mRB.a(true);
                }
                this.mRE.mUG.mInPKMode = true;
                this.u = this.mRE.mUG.mPkId;
            } else if (this.mRE.mUG.mAction == 7 || (this.mRE.mUG.mMode == 1 && this.mRE.mUG.mAction == 5)) {
                if (this.mRB != null) {
                    this.mRB.a(true);
                }
                this.mRE.mUG.mInPKMode = true;
                if (this.mWN != 42) {
                    this.mWZ = ((this.mWO.y - ((this.mWO.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mYr, 158.0f) + this.mVY)) - tv.chushou.zues.utils.systemBar.b.aE(getActivity());
                    dDk();
                }
                this.u = this.mRE.mUG.mPkId;
                if (this.mRF != null) {
                    this.mRF.b(this.mRE.mUG, false);
                    this.mRF.a(this.mRE.mUG.mMode, (String) null);
                    if (this.mRE.mUG.mAction == 5 && this.mRE.mUG.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mRE.mUG.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mRE.mUG.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mRE.mUG.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mRE.mUG.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mRE.mUG.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mRF.a(this.mRE.mUG);
                        this.mRF.a(parseInt, this.mRE.mUG.mPkUpdateInfo.remainDuration, j, this.mRE.mUG.mMode, (this.mRE.mUG.destinyInfo == null || this.mRE.mUG.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mRE.mUG.mPkUpdateInfo != null && !h.isEmpty(this.mRE.mUG.mPkUpdateInfo.specialMomentList) && this.mRF != null) {
                    this.mRF.a(this.mRE.mUG, true);
                }
                if (this.mRE.mUG.mMode == 2) {
                    dDk();
                } else {
                    dCO();
                }
            } else {
                this.mRE.mUG.mInPKMode = false;
                if (this.mRE.mUG.mMode == 2) {
                    dDk();
                } else {
                    dCO();
                }
            }
        }
    }

    public void dCO() {
        dDi();
        dDh();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mVV != null && this.mYq != null && this.mYq.mRo != null) {
            this.mVV.setText(tv.chushou.zues.utils.b.Ol(this.mYq.mRo.count));
            this.mVV.setVisibility(0);
            if (this.mYq.mRo.count < 1) {
                dDO();
            }
            if (this.mVO != null) {
                this.mVO.setText(this.mYq.mRo.primaryName);
            }
            if (this.mVP != null) {
                this.mVP.setText(this.mYq.mRo.desc);
            }
            dCP();
        }
    }

    public void dCP() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mVW * h.parseLong(this.mYq.mRo.point)));
        if (this.mTc != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mYr.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mYr, a.e.icon_coin_new);
            cVar.append(this.mYr.getString(a.i.str_buy_count_coin2));
            this.mTc.setText(cVar);
        }
    }

    private void dDN() {
        if (com.kascend.chushou.d.e.c(this.mYr, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mVW);
        }
    }

    private void dDO() {
        this.mVX = false;
        this.mVU.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mYq != null && this.mYq.mRo != null) {
            if (this.mYq.mRo.count < 1) {
                this.mVV.setVisibility(8);
            } else {
                this.mVV.setVisibility(0);
                this.mVV.setSelected(false);
                this.mVV.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mVN.setVisibility(8);
        if (this.mVv != null) {
            this.mVv.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mRJ != null) {
            if (z) {
                this.mRJ.setVisibility(0);
            } else {
                this.mRJ.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mXz != null) {
            this.mXz.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mVE != null) {
            this.mVE.performClick();
        }
    }
}
