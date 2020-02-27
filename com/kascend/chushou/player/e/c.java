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
    private View mRG;
    public String mRN;
    private TextView mRR;
    private TextView mRU;
    private ImageView mRZ;
    private TextView mSO;
    private TextView mSi;
    private KPSwitchPanelLinearLayout mSs;
    private ImageView mSt;
    private tv.chushou.zues.widget.kpswitch.b.c mSv;
    private d.a mSw;
    private TextView mTa;
    private View mTd;
    private int mUF;
    private View mUG;
    private View mUH;
    private com.kascend.chushou.view.user.b mUI;
    private View mUJ;
    private FrameLayout mUK;
    private LinearLayout mUL;
    private RelativeLayout mUM;
    private FrescoThumbnailView mUN;
    private TextView mUO;
    private TextView mUP;
    private TextView mUQ;
    private FrescoThumbnailView mUR;
    private TextView mUS;
    private TextView mUT;
    private TextView mUU;
    private int mUV;
    private TextView mUW;
    private LinearLayout mUX;
    private PlayShowMicStatusView mUY;
    private RecyclerView mUZ;
    private TextView mUe;
    private LinearLayout mVA;
    private TextView mVB;
    private TextView mVC;
    private TextView mVD;
    private TextView mVE;
    private TextView mVF;
    private TextView mVG;
    private ImageView mVH;
    private TextView mVI;
    private PopupWindow mVN;
    private View mVP;
    private RecyclerView mVR;
    private RoomInfo mVS;
    private RecyclerView.LayoutManager mVU;
    private ArrayList<ChatInfo> mVV;
    private ArrayList<ChatInfo> mVW;
    private ArrayList<ChatInfo> mVX;
    private ArrayList<ChatInfo> mVY;
    private ImageView mVa;
    private PlayShowRecommendView mVb;
    private View mVc;
    private RelativeLayout mVd;
    private AnimationSet mVe;
    private ImageView mVf;
    private ImageView mVg;
    private RelativeLayout mVh;
    private PastedEditText mVi;
    private ToggleButton mVj;
    private RelativeLayout mVk;
    private PaoPaoView mVl;
    private FrescoThumbnailView mVm;
    private LinearLayout mVn;
    private ImageView mVo;
    private InteractionView mVp;
    private LinearLayout mVq;
    private FrescoThumbnailView mVr;
    private FrameLayout mVs;
    private RedpacketNotifier mVt;
    private InteractNotifier mVu;
    private EmbeddedButtonLayout mVv;
    private GiftAnimationLayout mVw;
    private com.kascend.chushou.player.b.a mVx;
    private f mVy;
    private PlayShowH5View mVz;
    private Point mWA;
    private FrescoThumbnailView mWD;
    private FrescoThumbnailView mWE;
    private ValueAnimator mWG;
    private LinearLayout mWH;
    private long mWI;
    private VideoShowVoteView mWJ;
    private Runnable mWK;
    private FrescoThumbnailView mWN;
    private ImageView mWO;
    private RelativeLayout mWP;
    private TextView mWQ;
    private ImageView mWR;
    private EditText mWS;
    private View mWT;
    private RelativeLayout mWU;
    private RelativeLayout mWV;
    private FrescoThumbnailView mWW;
    private TextView mWX;
    private TextView mWY;
    private ImageView mWZ;
    private Button mWc;
    private View mWd;
    private View mWe;
    private Animator mWf;
    private View mWg;
    private View mWh;
    private Animator mWi;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mWl;
    private PlayShowMicPerson mWp;
    private FoodView mWt;
    public ListItem mWu;
    private FoodView mWv;
    private com.kascend.chushou.player.ui.miniview.a mWw;
    private int mWx;
    private int mWy;
    private int mWz;
    private RelativeLayout mXa;
    private LinearLayout mXb;
    private TextView mXc;
    private TextView mXd;
    private RelativeLayout mXe;
    private RelativeLayout mXf;
    private FrescoThumbnailView mXg;
    private TextView mXh;
    private TextView mXi;
    private ImageView mXj;
    private RelativeLayout mXk;
    private TextView mXm;
    private float mXn;
    private float mXo;
    private a mXp;
    private boolean mSu = false;
    private int mVJ = 1;
    private boolean mVK = false;
    private int mVL = 0;
    private int mVM = 0;
    private int mVO = -1;
    private boolean mVQ = false;
    private FullRoomInfo mVT = null;
    private com.kascend.chushou.player.adapter.a mVZ = null;
    private ArrayList<String> mWa = null;
    private boolean mWb = true;
    private boolean mWj = true;
    private boolean mWk = false;
    public final List<OnlineVipItem> mWm = new ArrayList();
    private boolean mWn = false;
    private boolean mWo = false;
    private long mWq = 0;
    private int mWr = 1;
    private boolean mWs = false;
    private int mWB = -1;
    private int mWC = -1;
    private boolean mWF = false;
    private int mWL = -1;
    private io.reactivex.disposables.b mXl = null;

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
        this.mRN = getArguments().getString("cover");
        this.mWj = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mXO = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mXO;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dDM()) {
            dCP();
            this.mUs = ((VideoPlayer) this.mYe).dCa();
            this.mYd = ((VideoPlayer) this.mYe).dCd();
            dA(view);
            dDd();
            if (this.mYe instanceof VideoPlayer) {
                ((VideoPlayer) this.mYe).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mWk = false;
        if (this.mYJ != null) {
            this.mYJ.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWk = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mWf != null) {
            this.mWf.removeAllListeners();
            this.mWf.cancel();
            this.mWf = null;
        }
        if (this.mWi != null) {
            this.mWi.removeAllListeners();
            this.mWi.cancel();
            this.mWi = null;
        }
        if (this.mVu != null) {
            this.mVu.c();
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
        if (this.mXl != null) {
            this.mXl.dispose();
            this.mXl = null;
        }
        this.mVJ = 1;
        this.mVK = false;
        if (this.mYf != null) {
            this.mYf.cq(null);
        }
        if (this.mVN != null) {
            this.mVN.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mYe, this.mSv);
        if (this.mYe != null && (this.mYe instanceof VideoPlayer)) {
            ((VideoPlayer) this.mYe).dCg();
        }
        this.mSw = null;
        this.mSv = null;
        dCN();
        if (this.mVx != null) {
            this.mVx.a();
        }
        if (this.mVl != null) {
            this.mVl.b();
            this.mVl.c();
            this.mVl = null;
        }
        super.d();
    }

    private void dCN() {
        tv.chushou.zues.a.a.cr(this);
        if (this.mVX != null) {
            this.mVX.clear();
        }
        if (this.mVV != null) {
            this.mVV.clear();
        }
        if (this.mVY != null) {
            this.mVY.clear();
        }
        if (this.mVW != null) {
            this.mVW.clear();
        }
        if (this.mWa != null) {
            this.mWa.clear();
        }
        if (this.mVZ != null) {
            this.mVZ.a(0);
            this.mVZ.a();
        }
    }

    private void dA(View view) {
        this.mUG = view.findViewById(a.f.fl_root);
        this.mWA = tv.chushou.zues.utils.a.he(this.mYe);
        this.mVL = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mYe);
        this.mVM = tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        this.mWz = 86;
        this.mYd = ((VideoPlayer) this.mYe).dCd();
        if (this.mYd != null) {
            this.mVS = this.mYd.dCE();
            this.mVT = this.mYd.dCC();
        }
        this.mVV = new ArrayList<>();
        this.mVX = new ArrayList<>();
        this.mVW = new ArrayList<>();
        this.mUK = (FrameLayout) this.mXO.findViewById(a.f.fl_effect);
        b();
        this.mXY = (PlayerErrorView) this.mXO.findViewById(a.f.view_net_error_msg);
        this.mXY.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mVk = (RelativeLayout) this.mXO.findViewById(a.f.rl_audio_ani);
        this.mVl = (PaoPaoView) this.mXO.findViewById(a.f.audio_ani);
        this.mVm = (FrescoThumbnailView) this.mXO.findViewById(a.f.audio_ani_avatar);
        this.mVn = (LinearLayout) this.mXO.findViewById(a.f.ll_audio);
        this.mUe = (TextView) this.mXO.findViewById(a.f.tv_open_video);
        this.mVo = (ImageView) this.mXO.findViewById(a.f.iv_audio_ani);
        this.mWE = (FrescoThumbnailView) this.mXO.findViewById(a.f.live_cover);
        if (!this.mWF || this.mUs == null || this.mUs.getPlayState() != 4) {
            this.mWE.setVisibility(0);
            this.mWE.setBlur(true);
            this.mWE.i(this.mRN, 0, 0, 0);
        }
        this.mUe.setOnClickListener(this);
        this.mRs = new b();
        this.mRs.a(view, null, this.mYe, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dPW()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mYd != null) {
                    append.append(c.this.mYd.dCE().mRoomID);
                }
                if (c.this.mRr != null && c.this.mRr.mUt != null) {
                    append.append("&mode=").append(c.this.mRr.mUt.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mYe, append.toString());
            }
        });
        this.mRw = (VoiceInteractionView) this.mXO.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mYd != null) {
            this.mVS = this.mYd.dCE();
            this.mVT = this.mYd.dCC();
        }
        dCQ();
        dCO();
        dCV();
        this.mWH = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mWt = (FoodView) view.findViewById(a.f.rav_ad);
        this.mWN = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mWO = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mWN.setOnClickListener(this);
        this.mWO.setOnClickListener(this);
        this.mWP = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mWD = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mWD.setOnClickListener(this);
        this.mVu = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mVt = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mWc = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mWc.setOnClickListener(this);
        this.mVR = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mVR.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVR.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mWA.x, this.mWA.y) * 0.83d);
        this.mVR.setLayoutParams(layoutParams);
        this.mVU = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mYe);
        this.mVR.setLayoutManager(this.mVU);
        this.mVR.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mVR.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mVR.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dDp();
                } else if (i == 1) {
                    c.this.mWb = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mVZ = new com.kascend.chushou.player.adapter.a(this.mYe, this.mVV);
        if (this.mVS != null) {
            this.mVZ.a(this.mVS);
        }
        if (com.kascend.chushou.b.dBL().c != null) {
            this.mVZ.a(com.kascend.chushou.b.dBL().c);
        }
        this.mVR.setAdapter(this.mVZ);
        this.mVZ.a(this.mVV.size());
        this.mVZ.notifyDataSetChanged();
        if (this.mYd != null && (c = this.mYd.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mVx != null) {
            this.mVx.a();
            this.mVx = null;
        }
        this.mVw = (GiftAnimationLayout) this.mXO.findViewById(a.f.ll_gift_animation);
        this.mVw.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mUF = ((int) (tv.chushou.zues.utils.a.hd(this.mYe).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYe, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVw.getLayoutParams();
        layoutParams2.bottomMargin = this.mUF;
        this.mVw.setLayoutParams(layoutParams2);
        if (this.mYd != null) {
            this.mVx = new com.kascend.chushou.player.b.a(this.mYe.getApplicationContext(), this.mVw);
            this.mVx.a(this.mYd);
            a(this.mYd.mQX, this.mYd.mRb);
        }
        this.mXO.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mVv = (EmbeddedButtonLayout) this.mXO.findViewById(a.f.embedded_button_layout);
        this.mVv.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mWJ = (VideoShowVoteView) this.mXO.findViewById(a.f.view_video_show_vote);
        this.mWJ.setOnClickListener(this);
        this.mWJ.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dDl();
            }
        });
        if (this.mYd != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
            this.mVv.a(videoPlayer.dCm().dDT());
            this.mVv.b(this.mYd.i());
            this.mVt.a(videoPlayer.dCi(), false);
            this.mVu.a(videoPlayer.dCj(), videoPlayer.dCk(), videoPlayer.dCl());
            this.mRr = new com.kascend.chushou.player.e.a();
        }
        this.mYT = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mWn = false;
                c.this.b(c.this.mUF, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mWn = true;
                if (c.this.mYJ != null) {
                    c.this.mYJ.measure(0, 0);
                    int measuredHeight = c.this.mYJ.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mYe, 14.0f);
                    if (measuredHeight > c.this.mUF) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mYN = (PaoGuideView) this.mXO.findViewById(a.f.rlPaoGuideView);
        this.mWp = (PlayShowMicPerson) this.mXO.findViewById(a.f.rl_mic_person_view);
        this.mVz = (PlayShowH5View) this.mXO.findViewById(a.f.rl_playshowh5);
        this.mWv = (FoodView) this.mXO.findViewById(a.f.bottom_ad);
        if (this.mYd != null) {
            H();
            if (this.mYd.mQR != null && !h.isEmpty(this.mYd.mQR.mUrl)) {
                b(this.mYd.mQR);
            }
        }
        this.mWd = this.mXO.findViewById(a.f.view_reminder_subscribe);
        this.mWe = this.mWd.findViewById(a.f.spash_subscribe);
        ((TextView) this.mWd.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().O(this.mYe, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.mYe.getString(a.i.videoplayer_reminder_subscribe)));
        this.mWd.setOnClickListener(this);
        this.mWg = this.mXO.findViewById(a.f.view_reminder_danmaku);
        this.mWh = this.mWg.findViewById(a.f.spash_danmaku);
        ((TextView) this.mWg.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().O(this.mYe, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.mYe.getString(a.i.videoplayer_reminder_danmaku)));
        this.mWg.setOnClickListener(this);
    }

    private void dCO() {
        this.mWU = (RelativeLayout) this.mXO.findViewById(a.f.rl_cyclelive);
        this.mWV = (RelativeLayout) this.mXO.findViewById(a.f.rlrl_cyclelive);
        this.mWW = (FrescoThumbnailView) this.mXO.findViewById(a.f.iv_liveicon);
        this.mWX = (TextView) this.mXO.findViewById(a.f.tv_livename);
        this.mWY = (TextView) this.mXO.findViewById(a.f.tv_livedesc);
        this.mWZ = (ImageView) this.mXO.findViewById(a.f.iv_cyclelive_name_menu);
        this.mXa = (RelativeLayout) this.mXO.findViewById(a.f.rl_normal);
        this.mXb = (LinearLayout) this.mXO.findViewById(a.f.ll_cyclelive_nickname);
        this.mXc = (TextView) this.mXO.findViewById(a.f.tv_cyclelive_nickname);
        this.mXd = (TextView) this.mXO.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mXe = (RelativeLayout) this.mXO.findViewById(a.f.rl_clear_cyclelive);
        this.mXf = (RelativeLayout) this.mXO.findViewById(a.f.rlrl_clear_cyclelive);
        this.mXg = (FrescoThumbnailView) this.mXO.findViewById(a.f.iv_clear_liveicon);
        this.mXh = (TextView) this.mXO.findViewById(a.f.tv_clear_livename);
        this.mXi = (TextView) this.mXO.findViewById(a.f.tv_clear_livedesc);
        this.mXj = (ImageView) this.mXO.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mXk = (RelativeLayout) this.mXO.findViewById(a.f.rl_clear_normal);
        this.mXj.setOnClickListener(this);
        this.mWZ.setOnClickListener(this);
        this.mXd.setOnClickListener(this);
        this.mXc.setOnClickListener(this);
        this.mWW.setOnClickListener(this);
        this.mXg.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mYd.mQP != null && this.mWv != null) {
            this.mWv.a(true, this.mYd.a == null ? "" : this.mYd.a);
            this.mWv.a(this.mYd.mQP, a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mYd != null && this.mYd.mQW != null && this.mVv != null) {
            this.mWt.a(this.mYd.mQW, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mYd != null) {
                        c.this.mYd.mQW = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dDm() {
        return this.mVx;
    }

    private void dCP() {
        this.mYf = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mXO != null && (textView = (TextView) c.this.mXO.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mYe.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mYf.K(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mYf);
                        break;
                    case 12:
                        c.this.b(c.this.mYf);
                        break;
                    case 17:
                        c.this.dDP();
                        break;
                    case 18:
                        c.this.cXJ();
                        break;
                    case 19:
                        c.this.mYc.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mVQ) {
            this.mVQ = true;
            if (this.mVP == null) {
                this.mVP = this.mXO.findViewById(a.f.vs_async_show_content);
                this.mVP = ((ViewStub) this.mVP).inflate();
            }
            this.mRG = this.mXO.findViewById(a.f.ui_content);
            if (this.mTd == null) {
                this.mTd = this.mXO.findViewById(a.f.vs_async_notification_view);
                this.mTd = ((ViewStub) this.mTd).inflate();
            }
            c(this.mXO);
            k();
            cXK();
            if (this.c == null) {
                this.mRm = new d.a();
                this.c = new GestureDetector(this.mYe, this.mRm);
            }
            ((VideoPlayer) this.mYe).q();
        }
    }

    private void dCQ() {
        this.mUL = (LinearLayout) this.mXO.findViewById(a.f.ll_anchor);
        this.mUM = (RelativeLayout) this.mXO.findViewById(a.f.ll_clear_anchor);
        this.mUL.setVisibility(4);
        this.mUM.setVisibility(4);
        this.mUN = (FrescoThumbnailView) this.mXO.findViewById(a.f.iv_clear_avatar);
        this.mUO = (TextView) this.mXO.findViewById(a.f.tv_clear_nickname);
        this.mUP = (TextView) this.mXO.findViewById(a.f.tv_clear_online_count);
        this.mUQ = (TextView) this.mXO.findViewById(a.f.tv_clear_btn_subscribe);
        this.mUQ.setOnClickListener(this);
        this.mUR = (FrescoThumbnailView) this.mXO.findViewById(a.f.iv_avatar);
        this.mUS = (TextView) this.mXO.findViewById(a.f.tv_nickname_test);
        this.mUT = (TextView) this.mXO.findViewById(a.f.tv_online_count);
        this.mRR = (TextView) this.mXO.findViewById(a.f.tv_btn_subscribe);
        this.mRR.setOnClickListener(this);
        this.mUU = (TextView) this.mXO.findViewById(a.f.tv_loyal_counts);
        this.mRU = (TextView) this.mXO.findViewById(a.f.tv_btn_contribution);
        this.mUW = (TextView) this.mXO.findViewById(a.f.tv_btn_contribution_forpk);
        this.mRU.setVisibility(4);
        this.mUW.setVisibility(8);
        this.mUX = (LinearLayout) this.mXO.findViewById(a.f.ll_mic);
        this.mUY = (PlayShowMicStatusView) this.mXO.findViewById(a.f.show_mic_status);
        this.mUZ = (RecyclerView) this.mXO.findViewById(a.f.rv_loyal);
        this.mVa = (ImageView) this.mXO.findViewById(a.f.iv_clear_close);
        this.mRZ = (ImageView) this.mXO.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mUZ.setLayoutManager(linearLayoutManager);
        this.mWl = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mWm, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mWm.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mYe, (JSONObject) null, c.this.mYd.dCE().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dQi(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mYe, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYe, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYe, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYe, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mYe, a.c.color_979797), dip2px);
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
        this.mUZ.setAdapter(this.mWl);
        this.mUX.setOnClickListener(this);
        this.mUN.setOnClickListener(this);
        this.mVa.setOnClickListener(this);
        this.mUR.setOnClickListener(this);
        this.mUN.setOnClickListener(this);
        this.mRZ.setOnClickListener(this);
        this.mUU.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPW() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mYd != null) {
                    str = str + c.this.mYd.dCE().mRoomID;
                }
                c.this.f(c.this.mYe.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mRU.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPW() + "m/room-billboard/";
                if (c.this.mYd != null) {
                    str = str + c.this.mYd.dCE().mRoomID;
                }
                c.this.f(c.this.mYe.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mUW.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dz(View view) {
                String str = tv.chushou.common.a.dPW() + "m/room-billboard/";
                if (c.this.mYd != null) {
                    str = str + c.this.mYd.dCE().mRoomID;
                }
                c.this.f(c.this.mYe.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        s(true);
    }

    public void s(boolean z) {
        boolean z2;
        if (this.mVT == null || this.mVT.cycleLiveRoomInfo == null || h.isEmpty(this.mVT.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mRu = this.mVT.cycleLiveRoomInfo;
        }
        if (z2 && this.mRu != null) {
            this.mWU.setVisibility(0);
            this.mXe.setVisibility(0);
            this.mXa.setVisibility(8);
            this.mXk.setVisibility(8);
            this.mXb.setVisibility(0);
            this.mXg.h(this.mRu.eventIcon, com.kascend.chushou.view.a.a(this.mVS.mCreatorGender), b.a.small, b.a.small);
            this.mWW.h(this.mRu.eventIcon, com.kascend.chushou.view.a.a(this.mVS.mCreatorGender), b.a.small, b.a.small);
            this.mXh.setText(this.mRu.eventName);
            this.mXi.setText(this.mRu.eventDesc);
            this.mWX.setText(this.mRu.eventName);
            this.mWY.setText(this.mRu.eventDesc);
            this.mXc.setText(this.mRu.nickname);
            dCS();
            if (z) {
                c(this.mRu.remainTime);
                return;
            }
            return;
        }
        this.mWU.setVisibility(8);
        this.mXe.setVisibility(8);
        this.mXa.setVisibility(0);
        this.mXk.setVisibility(0);
        this.mXb.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mXl != null) {
            this.mXl.dispose();
            this.mXl = null;
        }
        this.mXl = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJg()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mYe != null && (c.this.mYe instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mYe).u();
                }
            }
        });
    }

    private void dCR() {
        if (this.mVS != null && this.mVQ) {
            this.mUL.setVisibility(0);
            this.mUM.setVisibility(0);
            this.mRU.setVisibility(0);
            this.mUN.h(this.mVS.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVS.mCreatorGender), b.a.small, b.a.small);
            this.mUO.setText(this.mVS.mCreatorNickname);
            this.mUR.h(this.mVS.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVS.mCreatorGender), b.a.small, b.a.small);
            this.mUS.setText(this.mVS.mCreatorNickname);
            dDB();
            dCT();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dDB() {
        if (this.mVS != null) {
            this.mUP.setText(tv.chushou.zues.utils.b.formatNumber(this.mVS.mOnlineCount));
            this.mUT.setText(tv.chushou.zues.utils.b.formatNumber(this.mVS.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCS() {
        if (this.mRu != null) {
            if (this.mRu.isSubscribe) {
                this.mXd.setText(a.i.like_already);
                this.mXd.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mXd.setText(getString(a.i.like));
            this.mXd.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCT() {
        if (this.mVS != null) {
            if (this.mVS.mIsSubscribed) {
                this.mUQ.setText(getString(a.i.like_already));
                this.mUQ.setBackgroundResource(a.e.bg_show_subcribe);
                this.mRR.setText(getString(a.i.like_already));
                this.mRR.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mUQ.setText(getString(a.i.like));
            this.mUQ.setBackgroundResource(a.e.bg_show_subcribe);
            this.mRR.setText(getString(a.i.like));
            this.mRR.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dCU() {
        if (this.mWl != null) {
            this.mWl.notifyDataSetChanged();
        }
    }

    private void dCV() {
        this.mVc = this.mXO.findViewById(a.f.tv_interact);
        this.mVc.setOnClickListener(this);
        this.mVh = (RelativeLayout) this.mXO.findViewById(a.f.rl_edit_bar);
        this.mVf = (ImageView) this.mXO.findViewById(a.f.btn_hotword);
        this.mVf.setOnClickListener(this);
        this.mVg = (ImageView) this.mXO.findViewById(a.f.iv_task_badge);
        this.mVe = (AnimationSet) AnimationUtils.loadAnimation(this.mYe, a.C0690a.anim_hotword);
        this.mVe.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dBS().c) {
                    c.this.mVf.clearAnimation();
                    c.this.mVf.startAnimation(c.this.mVe);
                }
            }
        });
        if (com.kascend.chushou.d.h.dBS().c) {
            this.mVf.startAnimation(this.mVe);
            this.mVg.setVisibility(0);
        }
        this.mXm = (TextView) this.mXO.findViewById(a.f.tv_bottom_input);
        this.mXm.setOnClickListener(this);
        this.mZd = (FrescoThumbnailView) this.mXO.findViewById(a.f.ll_btn_set);
        this.mZd.setOnClickListener(this);
        this.mZd.xo(a.e.ic_room_set_btn_white);
        this.mVq = (LinearLayout) this.mXO.findViewById(a.f.ll_bottom_all_button);
        this.mVr = (FrescoThumbnailView) this.mXO.findViewById(a.f.fl_clear_bottom_gift);
        this.mVr.setAnim(true);
        this.mVr.setOnClickListener(this);
        this.mVr.xo(a.e.ic_show_gift_n);
        this.mVs = (FrameLayout) this.mXO.findViewById(a.f.flfl_clear_bottom_gift);
        this.mVs.setVisibility(8);
        this.mVd = (RelativeLayout) this.mXO.findViewById(a.f.rl_bottom_input);
        this.mVd.setVisibility(0);
        this.mVi = (PastedEditText) this.mXO.findViewById(a.f.et_bottom_input);
        this.mVi.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mSi.setEnabled(editable.length() > 0);
            }
        });
        this.mVi.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mSi);
                    return true;
                }
                return true;
            }
        });
        this.mVi.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.mVi);
                }
                return false;
            }
        });
        this.mSt = (ImageView) this.mXO.findViewById(a.f.iv_btn_emoji);
        this.mSt.setVisibility(8);
        this.mSi = (TextView) this.mXO.findViewById(a.f.tv_btn_send);
        this.mSi.setOnClickListener(this);
        this.mVA = (LinearLayout) this.mXO.findViewById(a.f.head_trumpet);
        this.mVA.setVisibility(8);
        this.mVA.setOnClickListener(this);
        this.mVB = (TextView) this.mXO.findViewById(a.f.tv_primary_name);
        this.mVC = (TextView) this.mXO.findViewById(a.f.tv_primary_desc);
        this.mVE = (TextView) this.mXO.findViewById(a.f.tv_cut_count);
        this.mVE.setOnClickListener(this);
        this.mVG = (TextView) this.mXO.findViewById(a.f.tv_head_count);
        this.mVG.setText(this.mVJ + "");
        this.mVF = (TextView) this.mXO.findViewById(a.f.tv_plus_count);
        this.mVF.setOnClickListener(this);
        this.mSO = (TextView) this.mXO.findViewById(a.f.tv_buy_count_coin);
        this.mVD = (TextView) this.mXO.findViewById(a.f.tv_buy_head);
        this.mVD.setOnClickListener(this);
        this.mVH = (ImageView) this.mXO.findViewById(a.f.iv_trumpet_select);
        this.mVH.setOnClickListener(this);
        this.mVI = (TextView) this.mXO.findViewById(a.f.tv_trumpet_have_count);
        this.mVK = false;
        this.mVH.setBackgroundResource(a.e.ic_trumpet_n);
        this.mVI.setVisibility(8);
        this.mSs = (KPSwitchPanelLinearLayout) this.mXO.findViewById(a.f.chat_extended_container);
        dDb();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mSs, this.mSt, this.mVi, new a.InterfaceC0817a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0817a
            public void wi(boolean z) {
                if (c.this.mSt != null) {
                    if (z) {
                        c.this.mSs.setDirectVisibility(0);
                        c.this.mSt.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mSt.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mSw = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wj(boolean z) {
                c.this.mSu = z;
                if (z) {
                    c.this.mSt.setImageResource(a.e.cs_emoji_normal);
                    c.this.dCX();
                    if (c.this.mWT != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mWT.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ho(c.this.mYe);
                        c.this.mWT.setLayoutParams(layoutParams);
                    }
                    if (c.this.mVh != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mVh.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.ho(c.this.mYe);
                        c.this.mVh.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mWT != null && c.this.mWT.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mWT.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mWT.setLayoutParams(layoutParams3);
                    c.this.mWT.setVisibility(8);
                }
                if (c.this.mWn) {
                    c.this.mYJ.setVisibility(0);
                }
                if (c.this.mYe != null && (c.this.mYe instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mYe).wh(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mVh != null && c.this.mSs.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mVh.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mVh.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mSv = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mSs, this.mSw, ((VideoPlayer) this.mYe).dCh());
        ((VideoPlayer) this.mYe).g(((VideoPlayer) this.mYe).dCh());
        this.mWT = this.mXO.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mWQ = (TextView) this.mXO.findViewById(a.f.btn_room_search);
        this.mWR = (ImageView) this.mXO.findViewById(a.f.iv_room_emoji_delete);
        this.mWS = (EditText) this.mXO.findViewById(a.f.et_room_emoji_search);
        this.mWS.setImeOptions(3);
        this.mWS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mWQ);
                    return true;
                }
                return false;
            }
        });
        this.mWS.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mWQ.setEnabled(editable.length() > 0);
                c.this.mWR.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mYJ.setEmojiSearchText(editable.toString());
            }
        });
        this.mWQ.setOnClickListener(this);
        this.mWR.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void at(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dL(this.mWS);
            this.mWT.setVisibility(0);
            this.mWS.requestFocus();
        } else {
            this.mWT.setVisibility(8);
        }
        if (z2) {
            this.mWS.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCX() {
        int ho = tv.chushou.zues.widget.kpswitch.b.d.ho(this.mYe) + tv.chushou.zues.utils.a.dip2px(this.mYe, 14.0f);
        if (ho > this.mUF) {
            b(ho, 12);
        }
    }

    private void dDb() {
    }

    private void dDd() {
        if (this.mVM > 0) {
            View findViewById = this.mXO.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mVM);
        }
        if (this.mVL > 0) {
            View findViewById2 = this.mXO.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mVL, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mWj) {
            Q();
        }
        j(a.e.bg_gift_animation_v);
        dDi();
        a();
        this.mRo = ((VideoPlayer) this.mYe).dCe();
        this.mRo.a(this);
        if (this.mYd.dCC() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mRo != null) {
            this.mRo.d();
        }
    }

    private void dDe() {
        if ((this.mRr == null || this.mRr.mUt == null || !this.mRr.mUt.mInPKMode) ? false : true) {
            if (this.mUG != null) {
                this.mUG.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRt.getLayoutParams();
            layoutParams.leftMargin = (this.mWA.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mYe, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mRt.setLayoutParams(layoutParams);
            this.y.setText(this.mRr.mUt.mPkUserNickname);
            this.mRt.setVisibility(0);
            this.mUX.setVisibility(8);
            return;
        }
        if (this.mUG != null) {
            this.mUG.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mRt.setVisibility(8);
    }

    private void dDf() {
        boolean z = false;
        if (this.mRr != null && this.mRr.mUt != null && this.mRr.mUt.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mWL > 0 && this.mVR != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVR.getLayoutParams();
                if (layoutParams.height != this.mWL) {
                    layoutParams.height = this.mWL;
                    this.mVR.setLayoutParams(layoutParams);
                }
            }
            this.mUF = ((int) (tv.chushou.zues.utils.a.hd(this.mYe).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYe, 84.0f);
            b(this.mUF, 12);
        } else {
            if (this.mVR != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVR.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mYe, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mYe, 250.0f);
                    this.mVR.setLayoutParams(layoutParams2);
                }
            }
            this.mUF = ((int) (tv.chushou.zues.utils.a.hd(this.mYe).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mYe, 84.0f);
            b(this.mUF, 12);
        }
        if (this.mRs != null) {
            this.mRs.a(this.mWL + tv.chushou.zues.utils.a.dip2px(this.mYe, 52.0f), this.mYi);
        }
        if (this.mRw != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mRw.getLayoutParams();
            layoutParams3.bottomMargin = this.mWL + tv.chushou.zues.utils.a.dip2px(this.mYe, 52.0f);
            this.mRw.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dDh();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dDh();
    }

    private void dDg() {
        dDf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDh() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dDN().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mWA = tv.chushou.zues.utils.a.he(this.mYe);
        this.mWz = 86;
        this.mWx = (Math.max(this.mWA.x, this.mWA.y) - tv.chushou.zues.utils.a.dip2px(this.mYe, (this.mWz + 52) + 250)) - this.mVL;
        this.mWy = Math.max(this.mWA.x, this.mWA.y) - ((tv.chushou.zues.utils.a.dip2px(this.mYe, this.mWz) + this.mVL) * 2);
        if (this.mWB <= 0 || this.mWC <= 0) {
            this.mWB = Math.min(this.mWA.x, this.mWA.y);
            this.mWC = Math.max(this.mWA.x, this.mWA.y);
        }
        this.ar = Math.min(this.mWA.x, this.mWA.y);
        this.mYi = (this.ar * this.mWC) / this.mWB;
        boolean z = false;
        if (this.mRr == null || this.mRr.mUt == null) {
            i = 1;
        } else {
            i = this.mRr.mUt.mMode;
            if (this.mRr.mUt.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mWz = 42;
            if (i == 2) {
                if (this.mWC < this.mWB) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mYi;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mYi;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mWB * layoutParams.height) / this.mWC;
                    layoutParams2.height = layoutParams.height;
                    this.mYi = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYi;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYi;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, this.mWz) + this.mVL;
            layoutParams.gravity = 48;
            this.mWL = ((this.mWA.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mYe, (this.mWz + 52) + 64) + this.mVL)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
            dCL();
        } else if (this.E) {
            this.mWz = 42;
            if (this.mWC < this.mWB) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYi;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYi;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mWB * layoutParams.height) / this.mWC;
                layoutParams2.height = layoutParams.height;
                this.mYi = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, this.mWz) + this.mVL;
            layoutParams.gravity = 48;
            this.mWL = ((this.mWA.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mYe, (this.mWz + 52) + 98) + this.mVL)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
            dDg();
        } else {
            this.mWL = -1;
            this.mWz = 86;
            if (this.mYi <= this.mWx) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mWx;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, this.mWz) + this.mVL;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYi;
            } else if (this.mYi < this.mWy) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mYi;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, this.mWz) + this.mVL;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mYi;
            } else {
                this.mYi = Math.max(this.mWA.x, this.mWA.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mYi;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mYi * this.mWB) / this.mWC >= this.ar) {
                        i3 = this.mYi;
                        i2 = (this.mYi * this.mWB) / this.mWC;
                    } else if ((this.ar * this.mWC) / this.mWB >= this.mYi) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mWC) / this.mWB;
                    } else {
                        i2 = this.ar;
                        i3 = this.mYi;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mYi) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mWC) / this.mWB > this.mYi) {
                        i3 = this.mYi;
                        i2 = (this.mYi * this.mWB) / this.mWC;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mWC) / this.mWB;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mWC) / this.mWB;
                        if (i3 > this.mYi) {
                            i3 = this.mYi;
                            i2 = (this.mYi * this.mWB) / this.mWC;
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
        if (this.mYd != null && this.mYd.d) {
            layoutParams.width = Math.min(this.mWA.x, this.mWA.y);
            layoutParams.height = Math.max(this.mWA.x, this.mWA.y);
        }
        dDN().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dDi() {
        this.N = new SurfaceRenderView(this.mYe);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dDN().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mWs) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dDE();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dDD();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mXp != null) {
            this.mXp.a();
        }
        if (this.mYd != null && !h.isEmpty(this.mYd.mQZ)) {
            b(this.mYd.mQZ);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mUs != null) {
            int width = this.mUs.getWidth();
            int height = this.mUs.getHeight();
            if (this.mWB != width || this.mWC != height || this.mWB <= 0 || this.mWC <= 0) {
                this.mWB = width;
                this.mWC = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dDh();
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
            if (this.mWn) {
                dDk();
            } else {
                if (this.mYe.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYd.dCC().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mVK) {
                f(this.mVi.getText().toString());
            } else {
                a(this.mVi.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dBS().c) {
                com.kascend.chushou.d.h.dBS().b(false);
                this.mVe.cancel();
                this.mVe.reset();
                this.mVf.clearAnimation();
                this.mVg.setVisibility(8);
            }
            k(view, 0, this.mXO.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mYe, 165.0f) / 2);
            j(view, x >= 0 ? x : 0, this.mXO.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mYd.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mYd.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mVR != null) {
                u(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mVS != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mWr = 1;
            wk(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mYe, (JSONObject) null, this.mYd.dCE().mRoomID, this.mYd.dCE().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mYe.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mYe, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mWu != null) {
                    com.kascend.chushou.d.e.a(this.mYe, this.mWu, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mWP != null) {
                    this.mWP.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mYe, null) && this.mYd != null && this.mYd.mRa != null) {
                    if (this.mVK) {
                        dDL();
                    } else {
                        if (this.mYd != null && this.mYd.mRa != null && this.mYd.mRa.count > 0) {
                            this.mVA.setVisibility(8);
                        } else {
                            this.mVA.setVisibility(0);
                        }
                        this.mVK = true;
                        this.mVH.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mVI.setVisibility(0);
                        this.mVI.setSelected(true);
                        this.mVI.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mVi != null) {
                            this.mVi.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mVJ <= 9) {
                    this.mVJ++;
                    this.mVG.setText(this.mVJ + "");
                }
                dCM();
            } else if (id == a.f.tv_cut_count) {
                if (this.mVJ > 1) {
                    this.mVJ--;
                    this.mVG.setText(this.mVJ + "");
                }
                dCM();
            } else if (id == a.f.tv_buy_head) {
                dDK();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mWS.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mWS.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mWT.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dM(this.mWS);
                    this.mYJ.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mRu != null && !h.isEmpty(this.mRu.eventUrl)) {
                    f("", this.mRu.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mRu != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mRu != null) {
                    com.kascend.chushou.d.a.a(this.mYe, (JSONObject) null, this.mRu.roomId, this.mRu.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mYd.a(false);
                    ((VideoPlayer) this.mYe).l();
                } else {
                    ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.mVz != null) {
            int i = (tv.chushou.zues.utils.a.hd(this.mYe).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVz.getLayoutParams();
            layoutParams.topMargin = i;
            this.mVz.setLayoutParams(layoutParams);
            this.mVz.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mVz.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
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
        } else if (System.currentTimeMillis() - this.mWq <= 3000) {
            tv.chushou.zues.utils.g.Om(a.i.str_too_fast);
            return false;
        } else {
            cXQ();
            if (!com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a(((VideoPlayer) this.mYe).dCd().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mWq = System.currentTimeMillis();
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                a(this.mYd.dCC().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mYd.h);
            }
            g(this.b);
            if (!z && this.mVi != null) {
                this.mVi.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            cXQ();
            if (com.kascend.chushou.d.e.c(this.mYe, null) && LoginManager.Instance().getUserInfo() != null && this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                a(this.mYd.dCC().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mVi != null) {
                this.mVi.setText((CharSequence) null);
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
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mYd.dCC().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mYd.dCC().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mYe).mPl;
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
        if (this.mYD != null && this.mYD.isShowing()) {
            this.mYD.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
        if (this.mZa == null) {
            i(3);
        }
        this.mZa.getContentView().setBackgroundResource(0);
        this.mZa.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mZa.isShowing()) {
            this.mZa.showAtLocation(view, 83, i, i2);
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mYd.dCC().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mZa.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dDc() {
        if (h.isEmpty(this.mZe)) {
            if (((VideoPlayer) this.mYe).q) {
                this.mZd.xo(a.e.ic_room_set_btn_white);
            } else {
                this.mZd.xo(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mYe).q && this.mZe.size() == 2 && this.mZe.contains("4") && this.mZe.contains("2")) {
            this.mZd.xo(a.e.ic_room_set_btn_system_white);
        } else if (this.mZe.size() > 1 || !((VideoPlayer) this.mYe).q) {
            this.mZd.xo(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mZe.get(0))) {
            this.mZd.xo(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mZe.get(0))) {
            this.mZd.xo(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mZe.get(0))) {
            this.mZd.xo(a.e.ic_room_set_btn_system_white);
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
        if (this.mYD == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mYD.getContentView().setBackgroundResource(0);
            this.mYD.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mVf.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mYD.isShowing()) {
            this.mYD.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mYe, 16.0f) + i2);
            this.mVf.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mYd.dCC().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mYD.dismiss();
    }

    private void dB(View view) {
        if (this.mYx == null) {
            dDn();
        }
        if (com.kascend.chushou.d.h.dBS().q()) {
            this.mVj.dQg();
        } else {
            this.mVj.dQh();
        }
        int height = this.mXO.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity());
        if (view != null) {
            this.mYx.showAtLocation(view, 85, 0, height);
        }
    }

    private void dDn() {
        if (this.mYx == null) {
            View inflate = LayoutInflater.from(this.mYe).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mVj = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dBS().q()) {
                this.mVj.dQg();
            } else {
                this.mVj.dQh();
            }
            this.mVj.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dBS().g(z);
                }
            });
            this.mYr = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mYs = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mYr.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mYr.setVisibility(0);
            } else {
                this.mYr.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dBS().a) {
                this.mYs.b();
            } else {
                this.mYs.c();
            }
            if (this.mYd != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mYd.f;
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
                                if (this.mRr == null || !this.mRr.mUt.mInPKMode || h.isEmpty(this.mRr.b) || this.mVS == null || !this.mRr.b.equals(this.mVS.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mYe).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dCD = this.mYd.dCD();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mYe).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYe, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, 5.0f);
                                            }
                                            int identifier = this.mYe.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mYe.getPackageName());
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
                                                if (dCD != null && dCD.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mYe.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mYe).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dCD2 = this.mYd.dCD();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mYe).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mYe, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, 5.0f);
                                        }
                                        int identifier2 = this.mYe.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mYe.getPackageName());
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
                                            if (dCD2 != null && dCD2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dDo();
                        c.this.mYx.dismiss();
                    }
                }
            });
            this.mYx = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 150.0f), -2);
            this.mYx.setFocusable(true);
            this.mYx.setOutsideTouchable(true);
            this.mYx.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mYx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mYx = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDo() {
        if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
            if (this.mVy == null) {
                this.mVy = new f(getActivity());
            }
            this.mVy.a(this.mYd.dCC().mRoominfo, this.ax);
            if (!this.mVy.isShowing()) {
                this.mVy.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mWs) {
            return false;
        }
        if (this.mWr == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mXn = motionEvent.getX();
                    this.mXo = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mXn;
                    if (Math.abs(f) > Math.abs(y - this.mXo) && Math.abs(f) > q && f > 0.0f) {
                        dDG();
                        return true;
                    }
                    this.mXn = 0.0f;
                    this.mXo = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mWT != null && this.mWT.getVisibility() == 0 && b(motionEvent, this.mWT)) {
                this.mWT.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dM(this.mWS);
                return true;
            } else if (this.mWn && this.mWT != null && this.mWT.getVisibility() == 8 && g(this.mYJ.b, motionEvent)) {
                dDk();
                return true;
            } else if (this.mVz != null && this.mVz.b() && g(this.mVz, motionEvent)) {
                this.mVz.a();
                return true;
            } else if (this.mVp != null && this.mVp.b() && g(this.mVp, motionEvent)) {
                this.mVp.a();
                return true;
            } else if (b(motionEvent, this.mVh)) {
                return cXQ();
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
            if (this.mYU != null && this.mYU.a(i, keyEvent)) {
                return true;
            }
            if ((this.mVz != null && this.mVz.onKeyDown(i, keyEvent)) || dCY()) {
                return true;
            }
            if (this.mWr == 3) {
                this.mWr = 1;
                dDG();
                return true;
            } else if (this.mVp != null && this.mVp.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mVi != null && this.mVd != null && this.mVh != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dL(this.mVi);
                this.mVd.setVisibility(8);
                this.mVh.setVisibility(0);
            }
        } else if (this.mVd != null && this.mVh != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
            this.mVd.setVisibility(0);
            this.mVh.setVisibility(8);
        }
    }

    public boolean cXQ() {
        boolean z;
        b(this.mUF, 12);
        boolean z2 = false;
        if (this.mSs != null && this.mSs.getVisibility() == 0) {
            this.mSs.setVisibility(8);
            this.mSt.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mSu) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mYe);
            this.mSt.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mVh == null || this.mVh.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mVK) {
                dDL();
            }
            this.mVh.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mVd != null) {
                    c.this.mVd.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dCY() {
        if (cXQ()) {
            return true;
        }
        if (this.mYD != null && this.mYD.isShowing()) {
            this.mYD.dismiss();
            return true;
        } else if (this.mZa != null && this.mZa.isShowing()) {
            this.mZa.dismiss();
            return true;
        } else if (this.mYx == null || !this.mYx.isShowing()) {
            return dDk() || dDa() || dDj() || dCZ();
        } else {
            this.mYx.dismiss();
            return true;
        }
    }

    public boolean dCZ() {
        if (this.mYN == null || !this.mYN.isShown()) {
            return false;
        }
        this.mYN.d();
        return true;
    }

    public boolean dDa() {
        if (this.mWp == null || !this.mWp.isShown()) {
            return false;
        }
        this.mWp.a();
        return true;
    }

    public boolean dDj() {
        if (this.mVz == null || !this.mVz.b()) {
            return false;
        }
        this.mVz.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mYe != null && !((Activity) this.mYe).isFinishing() && pVar != null) {
            this.mWa = pVar.a;
            u(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dDM() && this.mVS != null && mVar.a(this.mVS.mCreatorUID, null)) {
            this.mVS.mIsSubscribed = mVar.c;
            dCT();
        }
    }

    public boolean dDk() {
        if (!this.mWn || this.mYJ == null) {
            return false;
        }
        if (this.mYJ != null) {
            this.mYJ.e();
        }
        if (this.mWS != null) {
            this.mWS.setText("");
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
        if (!dDM() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mWw != null) {
                        this.mWw.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                        this.mYd.dCC().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mYd.dCC().mMicStatus.onMic) {
                            if (this.mUX != null) {
                                this.mUX.setVisibility(8);
                            }
                            if (this.mWp != null && this.mWp.isShown()) {
                                this.mWp.a();
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
                        if (this.mYd.dCC().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mVS != null && !h.isEmpty(this.mVS.mCreatorUID)) {
                                i(arrayList2, this.mVS.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).a(!this.F);
                            }
                        } else if (this.mYd.dCC().mMicStatus.onMic) {
                            if (this.mYd.dCC().mMicStatus != null && !h.isEmpty(this.mYd.dCC().mMicStatus.micRoomId) && !this.mYd.dCC().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mYd.dCC().mMicStatus.micRoomId;
                            }
                            this.mYd.dCC().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mYd.dCC().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = j(this.mYd.dCC().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mYd.dCC().mMicStatus, str3, z4);
                            if (this.mWp != null && this.mWp.getVisibility() == 0) {
                                this.mWp.a(this.mYd.dCC().mFanItems, this.mYd.dCC().mMicStatus, str3, z4, this.mYd.dCC().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mUX != null) {
                                this.mUX.setVisibility(8);
                            }
                            if (this.mWp != null && this.mWp.isShown()) {
                                this.mWp.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mVO != onlineVip.mCount || (this.mUU != null && this.mUU.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mVO = onlineVip.mCount;
                        this.mUV = onlineVip.mCount;
                        dDs();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mWm.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mWm.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mWm.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mWI <= 5000) {
                                z2 = false;
                            } else {
                                this.mWI = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mWm.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mWm.addAll(onlineVip.mOnlineVipItems);
                            }
                            dCU();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mWJ != null) {
                    if (this.mVS == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mVS.mCreatorAvatar;
                        str2 = this.mVS.mCreatorGender;
                    }
                    this.mWJ.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mRr != null && this.mRr.mUt != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mRr.mUt.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mRo != null) {
                                        this.mRo.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mRr.mUt.mInPKMode = true;
                                    this.mRr.mUt.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRr.mUt.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRr.mUt.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRr.mUt.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRr.mUt.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRr.mUt.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mRr.mUt.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mRr.mUt.mMode = pkNotifyInfo.mMode;
                                    this.mRr.mUt.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mRs != null) {
                                        this.mRs.g(true, this.mRr.mUt.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dBS().a) {
                                        if (!com.kascend.chushou.b.dBL().e) {
                                            com.kascend.chushou.b.dBL().e = true;
                                            tv.chushou.zues.utils.g.M(this.mYe, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dBS().a(this.mYe, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mRr.mUt.mAction = 7;
                                    this.mRr.mUt.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mRr.mUt.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mRr.mUt.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mRr.mUt.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mRr.mUt.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mRr.mUt.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mRr.mUt.mMode == 2) {
                                        dDh();
                                    } else {
                                        dCL();
                                    }
                                    if (this.mRs != null) {
                                        this.mRs.g(false, 0L);
                                        this.mRs.b(this.mRr.mUt, true);
                                        this.mRs.a(this.mWL + tv.chushou.zues.utils.a.dip2px(this.mYe, 52.0f), this.mYi);
                                        this.mRs.a(this.mRr.mUt.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mRo != null) {
                                        this.mRo.a(false);
                                    }
                                    this.mRr.mUt.mInPKMode = false;
                                    this.mRr.mUt.mAction = 2;
                                    dCL();
                                    dDh();
                                    if (this.mRs != null) {
                                        this.mRs.c();
                                    }
                                    this.mRr.b = null;
                                    this.mRr.mUt = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mRr.mUt.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mRr.mUt.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mRr.mUt.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mVS != null && !h.isEmpty(this.mVS.mRoomID) && this.mVS.mRoomID.equals(this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mRr.mUt.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mRs != null) {
                                        this.mRs.a(this.mRr.mUt, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mRr.mUt.copyUpdate(pkNotifyInfo);
                                    if (this.mRs != null) {
                                        this.mRs.a(this.mRr.mUt);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mRr.mUt.copyStop(pkNotifyInfo);
                                        if (this.mRs != null) {
                                            this.mRs.w(this.mRr.mUt.mMaxFreeDuration, this.mRr.mUt.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mRr.mUt.copyResult(pkNotifyInfo);
                                    if (!this.mWk && this.mRs != null) {
                                        int i7 = 1;
                                        if (this.mRr.mUt.destinyInfo != null && this.mRr.mUt.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mRs.a(h.parseInt(this.mRr.mUt.mResult), h.parseLong(this.mRr.mUt.mvpUid), this.mRr.mUt.mvpAvatar, this.mRr.mUt.mvpNickname, this.mRr.mUt.mMaxFreeDuration, this.mRr.mUt.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mRu != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mRu.uid = cycleLiveRoomInfo.uid;
                        this.mRu.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mRu.roomId = cycleLiveRoomInfo.roomId;
                        this.mRu.avatar = cycleLiveRoomInfo.avatar;
                        this.mRu.nickname = cycleLiveRoomInfo.nickname;
                        s(false);
                        if (this.mYe != null && (this.mYe instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mYe).d();
                        }
                    } else {
                        ((VideoPlayer) this.mYe).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mYd != null && this.mYd.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dBS().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dBS().b().equals(next2.mUserID)) {
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

    public void dDs() {
        if (this.mUU != null) {
            if (this.mRr == null || this.mRr.mUt == null || !this.mRr.mUt.mInPKMode) {
                if (this.mUV > 0) {
                    this.mUU.setVisibility(0);
                    this.mUU.setText(String.format(this.mYe.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mUV))));
                    this.mUZ.setVisibility(0);
                    return;
                }
                this.mUU.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mUX.setVisibility(0);
            if (this.mUY != null) {
                this.mUY.a(str, z, micStatus, this.mYd.dCC().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mUX.setVisibility(8);
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
    public void dDp() {
        int childCount = this.mVU.getChildCount();
        int itemCount = this.mVU.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mVU);
        if (f + childCount >= itemCount) {
            this.mWb = true;
            if (this.mWc != null) {
                this.mWc.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                u(true);
            }
        }
    }

    public void dDy() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mVV.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mVV.add(1, chatInfo2);
    }

    private void u(boolean z) {
        if (this.mVV == null) {
            this.mVV = new ArrayList<>();
        }
        while (2 < this.mVV.size()) {
            this.mVV.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mVX);
        if (a2 == null) {
            v(false);
            return;
        }
        this.mVV.addAll(a2);
        int size = this.mVV.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mVV.size(); i++) {
                this.mVV.remove(2);
            }
        }
        v(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mVY == null) {
            this.mVY = new ArrayList<>();
        }
        this.mVY.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mWa != null && this.mWa.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mWa.contains("2"))) {
                        this.mVY.add(next);
                    } else if (!this.mWa.contains(next.mType)) {
                        this.mVY.add(next);
                    }
                }
                return this.mVY;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mVV == null) {
                    this.mVV = new ArrayList<>(arrayList);
                    dDy();
                    v(z2);
                    return;
                }
                if (this.mVX == null) {
                    this.mVX = new ArrayList<>();
                }
                this.mVX.addAll(arrayList);
                int size = this.mVX.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mVX.size(); i++) {
                        this.mVX.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mVV.size();
                if (a2 != null) {
                    this.mVV.addAll(a2);
                }
                int size3 = this.mVV.size();
                if (!this.mWb && this.mWc != null) {
                    this.mWc.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mVV.size(); i3++) {
                        this.mVV.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mVV == null) {
                this.mVV = new ArrayList<>(arrayList);
                dDy();
            } else {
                if (this.mVX == null) {
                    this.mVX = new ArrayList<>();
                }
                this.mVX.clear();
                this.mVX.addAll(arrayList);
                this.mVV.clear();
                dDy();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mVV.addAll(a3);
                }
            }
            v(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mVZ != null) {
                this.mVZ.a(this.mVV.size());
                if (i == 1) {
                    this.mVZ.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mVZ.notifyItemRangeRemoved(i2, i3);
                    this.mVZ.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mVZ.notifyDataSetChanged();
                }
            }
            if (z || this.mWb) {
                this.mWb = true;
                if (this.mWc != null) {
                    this.mWc.setVisibility(8);
                }
                if (z) {
                    this.mVR.scrollToPosition(this.mVV.size() - 1);
                } else {
                    this.mVR.smoothScrollToPosition(this.mVV.size() - 1);
                }
            }
        }
    }

    private void v(boolean z) {
        if (!this.ah) {
            if (this.mVZ != null) {
                this.mVZ.a(this.mVV.size());
                this.mVZ.notifyDataSetChanged();
            }
            if (z || this.mWb) {
                this.mWb = true;
                if (this.mWc != null) {
                    this.mWc.setVisibility(8);
                }
                if (z) {
                    this.mVR.scrollToPosition(this.mVV.size() - 1);
                } else {
                    this.mVR.smoothScrollToPosition(this.mVV.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dCn;
        RoomToast roomToast;
        this.p = false;
        if (this.mYd != null && this.mYd.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mYd.f.size()) {
                    break;
                } else if (!"2".equals(this.mYd.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dDC();
            return;
        }
        if (this.mRG != null) {
            this.mRG.setVisibility(0);
        }
        if (this.mUK != null) {
            this.mUK.setVisibility(0);
        }
        if (this.mYd != null) {
            this.mVS = this.mYd.dCE();
            this.mVT = this.mYd.dCC();
            if (com.kascend.chushou.b.dBL().c != null && this.mVZ != null) {
                this.mVZ.a(com.kascend.chushou.b.dBL().c);
                this.mVZ.notifyDataSetChanged();
            }
            FullRoomInfo dCC = this.mYd.dCC();
            if (dCC != null) {
                if (!h.isEmpty(dCC.mRoomToastList)) {
                    Iterator<RoomToast> it = dCC.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dBS().j())) {
                    a(roomToast);
                }
            }
            if (this.mVS != null) {
                dDH();
            }
            if (this.mVS != null && !this.mVS.mIsSubscribed) {
                RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mVS == null || !c.this.mVS.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mYd != null && this.mYd.l()) {
                d(true);
            }
        }
        if (this.mVS != null && this.mVZ != null) {
            if (this.mVV != null) {
                this.mVV.clear();
            } else {
                this.mVV = new ArrayList<>();
            }
            this.mVZ.a(this.mVS);
            dDy();
            this.mVZ.a(this.mVV.size());
            this.mVZ.notifyDataSetChanged();
        }
        dCR();
        N();
        if (this.mYe != null && (this.mYe instanceof VideoPlayer) && (dCn = ((VideoPlayer) this.mYe).dCn()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dCn.mUt, dCn.b);
        }
        this.mVm.h(this.mVS.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVS.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mVq);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dDq() {
        if (this.mVN == null) {
            View inflate = LayoutInflater.from(this.mYe).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mTa = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mVN = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mYe, 160.0f), -2);
            this.mVN.setFocusable(false);
            this.mVN.setOutsideTouchable(false);
            this.mVN.setAnimationStyle(a.j.gift_toast_style);
            this.mVN.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dBS().c(roomToast.mToastContent);
            if (this.mVN == null) {
                dDq();
            }
            if (this.mTa != null) {
                this.mTa.setText(roomToast.mToastContent);
            }
            if (!this.mVN.isShowing()) {
                if (this.mVq != null) {
                    this.mVN.showAtLocation(this.mVq, 85, 0, this.mXO.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aC(getActivity()));
                    RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mVN != null) {
                                c.this.mVN.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mVN.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mWE != null) {
            this.mWE.setVisibility(z ? 0 : 8);
        }
        this.mWF = true;
        if (this.mYe instanceof VideoPlayer) {
            ((VideoPlayer) this.mYe).p();
        }
    }

    private void dDC() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mYe).s();
        dCZ();
        dDa();
        if (this.mVb == null) {
            this.mVb = (PlayShowRecommendView) ((ViewStub) this.mXO.findViewById(a.f.view_recommend)).inflate();
        }
        this.mVb.setVisibility(0);
        if (this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null && !h.isEmpty(this.mYd.dCC().mRoominfo.mRoomID)) {
            dDt();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYJ != null) {
            this.mYJ.e();
        }
        if (this.mRG != null) {
            this.mRG.setVisibility(4);
        }
        if (this.mUK != null) {
            this.mUK.setVisibility(8);
        }
        if (this.mYR != null) {
            this.mYR.dPC();
            this.mYR.setVisibility(8);
        }
        wo(false);
        a(false, false);
        if (this.mRo != null) {
            this.mRo.a();
        }
    }

    private void dDt() {
        if (this.mVb != null && this.mVb.getVisibility() == 0) {
            this.mVb.a(this.mYd.dCC().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.mYe instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mYe;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mVz != null && this.mVz.b()) {
            this.mVz.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mWo);
        if (this.mYe != null) {
            if (this.mWo || "10004".equals(((VideoPlayer) this.mYe).t)) {
                this.mWo = true;
                if (this.mYd != null) {
                    this.mYd.f = null;
                    if (this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                        this.mYd.dCC().mRoominfo.mGameId = null;
                    }
                }
                dDC();
                return;
            }
            this.mWo = true;
            if (this.mYe != null) {
                ((VideoPlayer) this.mYe).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mWo = false;
        if (this.mRG != null) {
            this.mRG.setVisibility(0);
        }
        if (this.mUK != null) {
            this.mUK.setVisibility(0);
        }
        if (this.mVb != null) {
            this.mVb.setVisibility(8);
        }
        if (this.mXY != null) {
            this.mXY.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mWo = false;
        if (this.mRG != null) {
            this.mRG.setVisibility(0);
        }
        if (this.mUK != null) {
            this.mUK.setVisibility(0);
        }
        if (this.mVb != null) {
            this.mVb.setVisibility(8);
        }
        if (this.mXY != null) {
            this.mXY.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mVb != null) {
            this.mVb.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dDM()) {
            if (i()) {
                if (i == 404) {
                    if (this.mYd != null) {
                        this.mYd.f = null;
                        this.mYd.dCC().mRoominfo.mGameId = null;
                    }
                    dDC();
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
        if (this.mYd != null && this.mYd.dCD() != null) {
            a(this.mYd.dCD());
        }
        this.p = false;
        if (this.mYd == null || this.mYd.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mYd.f.size()) {
                if (!"2".equals(this.mYd.f.get(i2).mType)) {
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
    public GiftAnimationLayout dCW() {
        if (this.mXO == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXO.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mVq != null) {
            int size = iconConfig.configs.size();
            this.mVq.removeAllViews();
            if (this.mVs != null) {
                this.mVs.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mYe).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mVq, false);
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
                            this.mVs.setVisibility(0);
                            this.mVr.bU(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.mVq.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (this.mYe instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dCi = ((VideoPlayer) this.mYe).dCi();
            if (this.mYU == null) {
                this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYU.setVisibility(0);
            this.mYU.a(2, dCi);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mVu != null && this.mYe != null) {
            this.mVu.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mVu != null && this.mYe != null) {
            this.mVu.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (this.mVu != null) {
            this.mVu.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (this.mVu != null) {
            this.mVu.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mVt != null) {
            if (this.mYe != null) {
                this.mVt.a(((VideoPlayer) this.mYe).dCi(), false);
            }
            this.mVt.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mXO != null) {
            Point hd = tv.chushou.zues.utils.a.hd(this.mYe);
            int i = hd.x > hd.y ? 1 : 2;
            if (this.mYU == null) {
                this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYU.setPlayerViewHelper(this.mYd);
            this.mYU.setVisibility(0);
            this.mYU.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mVv != null) {
            this.mVv.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mVv != null) {
            this.mVv.a(bangInfo, str);
        }
        if (this.mRU != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mRU.setText(this.mYe.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mRU.setText(this.mYe.getString(a.i.str_contribute_tittle));
            } else {
                this.mRU.setText(Html.fromHtml(this.mYe.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mUW != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mUW.setText(this.mYe.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mUW.setText(this.mYe.getString(a.i.str_contribute_tittle));
            } else {
                this.mUW.setText(Html.fromHtml(this.mYe.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mVv != null) {
            this.mVv.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mYd != null && !h.isEmpty(this.mYd.mQY)) {
            this.mWu = this.mYd.mQY.get(0);
            if (this.mWN != null) {
                this.mWN.setVisibility(0);
                this.mWN.a(this.mWu.mCover, 0, 0, 0, 1);
                if (this.mWO != null) {
                    if (this.mWu.mShowClose) {
                        this.mWO.setVisibility(0);
                    } else {
                        this.mWO.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mVv != null) {
            this.mVv.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXO != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mSs != null) {
            this.mSs.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dDM() && !this.mWk) {
            if (iVar.a == 52) {
                if (this.mVZ != null) {
                    this.mVZ.a(com.kascend.chushou.b.dBL().c);
                    this.mVZ.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mWk && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dDM()) {
                    c.this.t(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mVi != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mVi);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dDM() && !this.mWk) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mYe, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dCj = ((VideoPlayer) this.mYe).dCj();
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(2, dCj);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dCk = ((VideoPlayer) this.mYe).dCk();
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(2, dCk);
            } else if (bVar.a == 8) {
                if (this.mWw != null && this.mWw.getVisibility() != 0) {
                    this.mWw.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mVS == null ? "" : this.mVS.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mYU == null) {
                    this.mYU = (H5Container) ((ViewStub) this.mXO.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYU.setVisibility(0);
                this.mYU.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dDM() && this.mYd != null && !h.isEmpty(this.mYd.a) && this.mYd.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mWw != null && this.mWw.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mYe, 80.0f);
                }
                if (this.mWv != null && this.mWv.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mWv.getHeight());
                }
                this.mWH.setTranslationY(-r0);
                return;
            }
            if (this.mWG != null) {
                this.mWG.cancel();
                this.mWG = null;
            }
            int translationY = (int) this.mWH.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mYe, 80.0f) : 0;
                    if (this.mWv != null && this.mWv.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mWv.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mWv.getHeight() : 0;
                    if (this.mWw != null && this.mWw.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mYe, 80.0f));
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
        this.mWG = ValueAnimator.ofInt(i, i2);
        this.mWG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dDM() && c.this.mVv != null) {
                    c.this.mWH.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mWG.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mWG = null;
            }
        });
        this.mWG.setInterpolator(new LinearInterpolator());
        this.mWG.setDuration(800L);
        this.mWG.start();
    }

    private boolean dDD() {
        if (this.mWr == 1) {
            this.mWr = 2;
            wk(true);
            return true;
        } else if (this.mWr == 3) {
            dDG();
            return true;
        } else {
            return false;
        }
    }

    private boolean dDE() {
        if (this.mWr == 1) {
            return dDF();
        }
        if (this.mWr == 2) {
            this.mWr = 1;
            wk(false);
            return true;
        }
        return false;
    }

    private boolean dDF() {
        if (this.mWs || this.mYd == null || this.mYd.dCE() == null) {
            return false;
        }
        if (this.mXp != null) {
            this.mXp.a(true);
        }
        this.mWr = 3;
        this.mWs = true;
        dDH();
        this.mUH.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.mWs = false;
                c.this.mUJ.setVisibility(8);
            }
        });
        this.mUJ.startAnimation(loadAnimation);
        this.mUH.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDG() {
        if (!this.mWs) {
            if (this.mXp != null) {
                this.mXp.a(false);
            }
            this.mWr = 1;
            this.mWs = true;
            dDH();
            this.mUJ.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.mWs = false;
                    c.this.mUH.setVisibility(8);
                }
            });
            this.mUJ.startAnimation(loadAnimation);
            this.mUH.startAnimation(loadAnimation2);
        }
    }

    private void dDH() {
        if (this.mXO != null) {
            if (this.mUH == null) {
                this.mUH = this.mXO.findViewById(a.f.user_space_container);
            }
            if (this.mUJ == null) {
                this.mUJ = this.mXO.findViewById(a.f.video_container);
            }
            if (this.mUI == null) {
                this.mUI = com.kascend.chushou.view.user.b.b(null, this.mYd.a, false, this.mYd.h);
                this.mUI.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dDG();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dDG();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mUI).commitAllowingStateLoss();
            }
        }
    }

    private void wk(boolean z) {
        Animation loadAnimation;
        if (this.mUK != null) {
            this.mUK.setVisibility(z ? 8 : 0);
        }
        if (this.mVP != null) {
            this.mWs = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mVP.setVisibility(8);
                        c.this.mWs = false;
                    }
                });
            } else {
                this.mWs = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mVP.setVisibility(0);
                        c.this.mWs = false;
                    }
                });
            }
            this.mVP.startAnimation(loadAnimation);
        }
        dCY();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mVc.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mVk != null) {
                this.mVk.setVisibility(0);
            }
            if (this.mVl != null) {
                this.mVl.a();
                return;
            }
            return;
        }
        if (this.mVn != null) {
            this.mVn.setVisibility(0);
        }
        if (this.mVo != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mVo.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mVn != null) {
            this.mVn.setVisibility(8);
        }
        if (this.mVo != null) {
            this.mVo.clearAnimation();
        }
        if (this.mVk != null) {
            this.mVk.setVisibility(8);
        }
        if (this.mVl != null) {
            this.mVl.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mVP != null && this.mXO != null) {
            if (this.mWw == null) {
                this.mWw = new com.kascend.chushou.player.ui.miniview.a(this.mYe, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mWw != null && c.this.mXO != null && c.this.mWw.a()) {
                            ((ViewGroup) c.this.mXO).removeView(c.this.mWw);
                            c.this.mWw = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWw.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mYe, 52.0f);
                this.mWw.setLayoutParams(layoutParams);
                ((ViewGroup) this.mVP).addView(this.mWw, ((ViewGroup) this.mVP).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mWw.setVisibility(8);
                } else {
                    this.mWw.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mYd.a == null ? "" : this.mYd.a);
                }
            } else if (!this.mWw.isShown()) {
                this.mWw.a(a.C0690a.slide_in_bottom_danmu_anim, a.C0690a.slide_out_bottom_danmu_anim, this.mYd.a == null ? "" : this.mYd.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mWD != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mWD.setVisibility(0);
                this.mWD.setAnim(true);
                this.mWD.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nYd, b.C0816b.nYe, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mWd != null && this.mWd.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dDI();
                    }
                });
                this.mWd.setVisibility(0);
                this.mWd.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mWd != null && this.mWd.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mWf != null) {
                        c.this.mWf.removeAllListeners();
                        c.this.mWf.cancel();
                        c.this.mWf = null;
                    }
                    if (c.this.mWd != null) {
                        c.this.mWd.setVisibility(8);
                    }
                }
            });
            this.mWd.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mWK == null) {
                this.mWK = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dDM()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mYe, "显示双击666_num", null, new Object[0]);
                            if (c.this.mYd != null) {
                                c.this.mYd.b(false);
                            }
                            c.this.d(false);
                            c.this.wl(true);
                        }
                    }
                };
                if (this.mYf != null) {
                    this.mYf.d(this.mWK, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mWK != null) {
            this.mYf.removeCallbacks(this.mWK);
            this.mWK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mWg != null && this.mWg.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mYe, a.C0690a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dDJ();
                    }
                });
                this.mWg.setVisibility(0);
                this.mWg.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXN, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.wl(false);
                    }
                });
            }
        } else if (this.mWg != null && this.mWg.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mYe, a.C0690a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mWi != null) {
                        c.this.mWi.removeAllListeners();
                        c.this.mWi.cancel();
                        c.this.mWi = null;
                    }
                    if (c.this.mWg != null) {
                        c.this.mWg.setVisibility(8);
                    }
                }
            });
            this.mWg.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dDI() {
        if (this.mWd == null || this.mWe == null) {
            return null;
        }
        if (this.mWf != null) {
            this.mWf.removeAllListeners();
            this.mWf.cancel();
            this.mWf = null;
        }
        this.mWe.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mWe, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mWe, 0.0f);
        int measuredWidth = (this.mWd.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mYe, 13.0f) * 2)) - this.mWe.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mWe, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mWe, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mWe, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mWf != null) {
                    c.this.mWf.removeAllListeners();
                    c.this.mWf.cancel();
                    c.this.mWf = null;
                }
                RxExecutor.postDelayed(c.this.mXN, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dDI();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mWf = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dDJ() {
        if (this.mWg == null || this.mWh == null) {
            return null;
        }
        if (this.mWi != null) {
            this.mWi.removeAllListeners();
            this.mWi.cancel();
            this.mWi = null;
        }
        this.mWh.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mWh, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mWh, 0.0f);
        int measuredWidth = (this.mWg.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mYe, 13.0f) * 2)) - this.mWh.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mWh, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mWh, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mWh, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mWi != null) {
                    c.this.mWi.removeAllListeners();
                    c.this.mWi.cancel();
                    c.this.mWi = null;
                }
                RxExecutor.postDelayed(c.this.mXN, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dDJ();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mWi = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mXp = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mRu != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mRu.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dDM()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Om(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Om(a.i.subscribe_success);
                            }
                            if (c.this.mRu != null) {
                                c.this.mRu.isSubscribe = !z;
                                c.this.dCS();
                                return;
                            }
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dDM()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dBO().a(bVar, (String) null, this.mRu.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mRu.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dBO().b(bVar, (String) null, c.this.mRu.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mYd != null && this.mVS != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mYd.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mYd.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mVS.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dDM()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Om(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Om(a.i.subscribe_success);
                            }
                            c.this.mVS.mIsSubscribed = !z;
                            c.this.dCT();
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dDM()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dBO().a(bVar, (String) null, this.mVS.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mVS.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dBO().b(bVar, (String) null, c.this.mVS.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mUs != null) {
            int width = this.mUs.getWidth();
            int height = this.mUs.getHeight();
            if (this.mWB != width || this.mWC != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mYe).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXO != null) {
            if (this.mVp == null) {
                this.mVp = (InteractionView) ((ViewStub) this.mXO.findViewById(a.f.view_interaction)).inflate();
                this.mVp.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mVp.a();
                    }
                });
            }
            if (this.mVp != null) {
                this.mVp.b(configDetail);
                this.mVp.c();
                this.mVp.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dQn()) {
                tv.chushou.zues.utils.g.M(this.mYe, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mYe, null) && (this.mYe instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYd != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYe, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mYe, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mYd != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mYe, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mYe, configDetail.mUrl, this.mYe.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN) && com.kascend.chushou.d.e.c(this.mYe, null)) {
            if (!configDetail.mTargetKey.equals("pay")) {
                if (configDetail.mTargetKey.equals("gift")) {
                    if (this.mWn) {
                        dDk();
                        return;
                    }
                    if (this.mYe.getResources().getDisplayMetrics().density < 2.0f) {
                        b(true, false);
                    } else {
                        b(true, true);
                    }
                    com.kascend.chushou.toolkit.a.c.a(this.mYe, "点击送礼_num", "竖屏", new Object[0]);
                    if (this.mYd != null && this.mYd.dCC() != null && this.mYd.dCC().mRoominfo != null) {
                        com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mYd.dCC().mRoominfo.mRoomID);
                        return;
                    }
                    return;
                } else if (configDetail.mTargetKey.equals("interaction")) {
                    a(configDetail);
                    return;
                } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME) && configDetail.mTargetKey.equals("more")) {
                    dB(this.mVq);
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
        if (this.mYe != null && !this.v && !h.isEmpty(str) && this.mVS != null && str.equals(this.mVS.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mRr == null) {
                this.mRr = new com.kascend.chushou.player.e.a();
            }
            this.mRr.b = str;
            this.mRr.mUt.copy(pkNotifyInfo);
            if (this.mRr.mUt.mAction == 6) {
                if (this.mRo != null) {
                    this.mRo.a(true);
                }
                this.mRr.mUt.mInPKMode = true;
                this.u = this.mRr.mUt.mPkId;
            } else if (this.mRr.mUt.mAction == 7 || (this.mRr.mUt.mMode == 1 && this.mRr.mUt.mAction == 5)) {
                if (this.mRo != null) {
                    this.mRo.a(true);
                }
                this.mRr.mUt.mInPKMode = true;
                if (this.mWz != 42) {
                    this.mWL = ((this.mWA.y - ((this.mWA.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mYe, 158.0f) + this.mVL)) - tv.chushou.zues.utils.systemBar.b.aC(getActivity());
                    dDh();
                }
                this.u = this.mRr.mUt.mPkId;
                if (this.mRs != null) {
                    this.mRs.b(this.mRr.mUt, false);
                    this.mRs.a(this.mRr.mUt.mMode, (String) null);
                    if (this.mRr.mUt.mAction == 5 && this.mRr.mUt.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mRr.mUt.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mRr.mUt.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mRr.mUt.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mRr.mUt.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mRr.mUt.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mRs.a(this.mRr.mUt);
                        this.mRs.a(parseInt, this.mRr.mUt.mPkUpdateInfo.remainDuration, j, this.mRr.mUt.mMode, (this.mRr.mUt.destinyInfo == null || this.mRr.mUt.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mRr.mUt.mPkUpdateInfo != null && !h.isEmpty(this.mRr.mUt.mPkUpdateInfo.specialMomentList) && this.mRs != null) {
                    this.mRs.a(this.mRr.mUt, true);
                }
                if (this.mRr.mUt.mMode == 2) {
                    dDh();
                } else {
                    dCL();
                }
            } else {
                this.mRr.mUt.mInPKMode = false;
                if (this.mRr.mUt.mMode == 2) {
                    dDh();
                } else {
                    dCL();
                }
            }
        }
    }

    public void dCL() {
        dDf();
        dDe();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mVI != null && this.mYd != null && this.mYd.mRa != null) {
            this.mVI.setText(tv.chushou.zues.utils.b.Ol(this.mYd.mRa.count));
            this.mVI.setVisibility(0);
            if (this.mYd.mRa.count < 1) {
                dDL();
            }
            if (this.mVB != null) {
                this.mVB.setText(this.mYd.mRa.primaryName);
            }
            if (this.mVC != null) {
                this.mVC.setText(this.mYd.mRa.desc);
            }
            dCM();
        }
    }

    public void dCM() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mVJ * h.parseLong(this.mYd.mRa.point)));
        if (this.mSO != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mYe.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mYe, a.e.icon_coin_new);
            cVar.append(this.mYe.getString(a.i.str_buy_count_coin2));
            this.mSO.setText(cVar);
        }
    }

    private void dDK() {
        if (com.kascend.chushou.d.e.c(this.mYe, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mVJ);
        }
    }

    private void dDL() {
        this.mVK = false;
        this.mVH.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mYd != null && this.mYd.mRa != null) {
            if (this.mYd.mRa.count < 1) {
                this.mVI.setVisibility(8);
            } else {
                this.mVI.setVisibility(0);
                this.mVI.setSelected(false);
                this.mVI.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mVA.setVisibility(8);
        if (this.mVi != null) {
            this.mVi.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mRw != null) {
            if (z) {
                this.mRw.setVisibility(0);
            } else {
                this.mRw.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mXm != null) {
            this.mXm.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mVr != null) {
            this.mVr.performClick();
        }
    }
}
