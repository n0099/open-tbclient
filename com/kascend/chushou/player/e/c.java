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
    private View mQX;
    private TextView mRA;
    private KPSwitchPanelLinearLayout mRI;
    private ImageView mRJ;
    private tv.chushou.zues.widget.kpswitch.b.c mRL;
    private d.a mRM;
    public String mRf;
    private TextView mRj;
    private TextView mRm;
    private ImageView mRr;
    private TextView mSd;
    private TextView mSq;
    private View mSt;
    private int mTW;
    private View mTX;
    private View mTY;
    private com.kascend.chushou.view.user.b mTZ;
    private TextView mTu;
    private PastedEditText mUA;
    private ToggleButton mUB;
    private RelativeLayout mUC;
    private PaoPaoView mUD;
    private FrescoThumbnailView mUE;
    private LinearLayout mUF;
    private ImageView mUG;
    private InteractionView mUH;
    private LinearLayout mUI;
    private FrescoThumbnailView mUJ;
    private FrameLayout mUK;
    private RedpacketNotifier mUL;
    private InteractNotifier mUM;
    private EmbeddedButtonLayout mUN;
    private GiftAnimationLayout mUO;
    private com.kascend.chushou.player.b.a mUP;
    private f mUQ;
    private PlayShowH5View mUR;
    private LinearLayout mUS;
    private TextView mUT;
    private TextView mUU;
    private TextView mUV;
    private TextView mUW;
    private TextView mUX;
    private TextView mUY;
    private ImageView mUZ;
    private View mUa;
    private FrameLayout mUb;
    private LinearLayout mUc;
    private RelativeLayout mUd;
    private FrescoThumbnailView mUe;
    private TextView mUf;
    private TextView mUg;
    private TextView mUh;
    private FrescoThumbnailView mUi;
    private TextView mUj;
    private TextView mUl;
    private TextView mUm;
    private int mUn;
    private TextView mUo;
    private LinearLayout mUp;
    private PlayShowMicStatusView mUq;
    private RecyclerView mUr;
    private ImageView mUs;
    private PlayShowRecommendView mUt;
    private View mUu;
    private RelativeLayout mUv;
    private AnimationSet mUw;
    private ImageView mUx;
    private ImageView mUy;
    private RelativeLayout mUz;
    private Animator mVA;
    private tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem> mVD;
    private PlayShowMicPerson mVH;
    private FoodView mVL;
    public ListItem mVM;
    private FoodView mVN;
    private com.kascend.chushou.player.ui.miniview.a mVO;
    private int mVP;
    private int mVQ;
    private int mVR;
    private Point mVS;
    private FrescoThumbnailView mVV;
    private FrescoThumbnailView mVW;
    private ValueAnimator mVY;
    private LinearLayout mVZ;
    private TextView mVa;
    private PopupWindow mVf;
    private View mVh;
    private RecyclerView mVj;
    private RoomInfo mVk;
    private RecyclerView.LayoutManager mVm;
    private ArrayList<ChatInfo> mVn;
    private ArrayList<ChatInfo> mVo;
    private ArrayList<ChatInfo> mVp;
    private ArrayList<ChatInfo> mVq;
    private Button mVu;
    private View mVv;
    private View mVw;
    private Animator mVx;
    private View mVy;
    private View mVz;
    private ImageView mWA;
    private RelativeLayout mWB;
    private TextView mWD;
    private float mWE;
    private float mWF;
    private a mWG;
    private long mWa;
    private VideoShowVoteView mWb;
    private Runnable mWc;
    private FrescoThumbnailView mWe;
    private ImageView mWf;
    private RelativeLayout mWg;
    private TextView mWh;
    private ImageView mWi;
    private EditText mWj;
    private View mWk;
    private RelativeLayout mWl;
    private RelativeLayout mWm;
    private FrescoThumbnailView mWn;
    private TextView mWo;
    private TextView mWp;
    private ImageView mWq;
    private RelativeLayout mWr;
    private LinearLayout mWs;
    private TextView mWt;
    private TextView mWu;
    private RelativeLayout mWv;
    private RelativeLayout mWw;
    private FrescoThumbnailView mWx;
    private TextView mWy;
    private TextView mWz;
    private boolean mRK = false;
    private int mVb = 1;
    private boolean mVc = false;
    private int mVd = 0;
    private int mVe = 0;
    private int mVg = -1;
    private boolean mVi = false;
    private FullRoomInfo mVl = null;
    private com.kascend.chushou.player.adapter.a mVr = null;
    private ArrayList<String> mVs = null;
    private boolean mVt = true;
    private boolean mVB = true;
    private boolean mVC = false;
    public final List<OnlineVipItem> mVE = new ArrayList();
    private boolean mVF = false;
    private boolean mVG = false;
    private long mVI = 0;
    private int mVJ = 1;
    private boolean mVK = false;
    private int mVT = -1;
    private int mVU = -1;
    private boolean mVX = false;
    private int mWd = -1;
    private io.reactivex.disposables.b mWC = null;

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
        this.mRf = getArguments().getString("cover");
        this.mVB = getArguments().getBoolean("initViewAsync");
        this.ax = getArguments().getString("liveType");
        this.ay = "2";
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mXg = layoutInflater.inflate(a.h.videoplayer_root_view_show, viewGroup, false);
        return this.mXg;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!dCE()) {
            dBH();
            this.mTJ = ((VideoPlayer) this.mXw).dAS();
            this.mXv = ((VideoPlayer) this.mXw).dAV();
            dy(view);
            dBV();
            if (this.mXw instanceof VideoPlayer) {
                ((VideoPlayer) this.mXw).o();
            }
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.mVC = false;
        if (this.mYb != null) {
            this.mYb.b();
        }
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.mVC = true;
        this.v = false;
    }

    @Override // com.kascend.chushou.player.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.mVx != null) {
            this.mVx.removeAllListeners();
            this.mVx.cancel();
            this.mVx = null;
        }
        if (this.mVA != null) {
            this.mVA.removeAllListeners();
            this.mVA.cancel();
            this.mVA = null;
        }
        if (this.mUM != null) {
            this.mUM.c();
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
        if (this.mWC != null) {
            this.mWC.dispose();
            this.mWC = null;
        }
        this.mVb = 1;
        this.mVc = false;
        if (this.mXx != null) {
            this.mXx.cp(null);
        }
        if (this.mVf != null) {
            this.mVf.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.a((Activity) this.mXw, this.mRL);
        if (this.mXw != null && (this.mXw instanceof VideoPlayer)) {
            ((VideoPlayer) this.mXw).dAY();
        }
        this.mRM = null;
        this.mRL = null;
        dBF();
        if (this.mUP != null) {
            this.mUP.a();
        }
        if (this.mUD != null) {
            this.mUD.b();
            this.mUD.c();
            this.mUD = null;
        }
        super.d();
    }

    private void dBF() {
        tv.chushou.zues.a.a.cq(this);
        if (this.mVp != null) {
            this.mVp.clear();
        }
        if (this.mVn != null) {
            this.mVn.clear();
        }
        if (this.mVq != null) {
            this.mVq.clear();
        }
        if (this.mVo != null) {
            this.mVo.clear();
        }
        if (this.mVs != null) {
            this.mVs.clear();
        }
        if (this.mVr != null) {
            this.mVr.a(0);
            this.mVr.a();
        }
    }

    private void dy(View view) {
        this.mTX = view.findViewById(a.f.fl_root);
        this.mVS = tv.chushou.zues.utils.a.hf(this.mXw);
        this.mVd = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(this.mXw);
        this.mVe = tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        this.mVR = 86;
        this.mXv = ((VideoPlayer) this.mXw).dAV();
        if (this.mXv != null) {
            this.mVk = this.mXv.dBw();
            this.mVl = this.mXv.dBu();
        }
        this.mVn = new ArrayList<>();
        this.mVp = new ArrayList<>();
        this.mVo = new ArrayList<>();
        this.mUb = (FrameLayout) this.mXg.findViewById(a.f.fl_effect);
        b();
        this.mXq = (PlayerErrorView) this.mXg.findViewById(a.f.view_net_error_msg);
        this.mXq.findViewById(a.f.tv_error_refresh_again).setOnClickListener(this);
        c();
        this.mUC = (RelativeLayout) this.mXg.findViewById(a.f.rl_audio_ani);
        this.mUD = (PaoPaoView) this.mXg.findViewById(a.f.audio_ani);
        this.mUE = (FrescoThumbnailView) this.mXg.findViewById(a.f.audio_ani_avatar);
        this.mUF = (LinearLayout) this.mXg.findViewById(a.f.ll_audio);
        this.mTu = (TextView) this.mXg.findViewById(a.f.tv_open_video);
        this.mUG = (ImageView) this.mXg.findViewById(a.f.iv_audio_ani);
        this.mVW = (FrescoThumbnailView) this.mXg.findViewById(a.f.live_cover);
        if (!this.mVX || this.mTJ == null || this.mTJ.getPlayState() != 4) {
            this.mVW.setVisibility(0);
            this.mVW.setBlur(true);
            this.mVW.i(this.mRf, 0, 0, 0);
        }
        this.mTu.setOnClickListener(this);
        this.mQJ = new b();
        this.mQJ.a(view, null, this.mXw, new b.a() { // from class: com.kascend.chushou.player.e.c.1
            @Override // com.kascend.chushou.player.e.b.a
            public void a(int i) {
                StringBuilder append = new StringBuilder(tv.chushou.common.a.dOH()).append("/m/pk-live/assist-billboard.htm?roomId=");
                if (c.this.mXv != null) {
                    append.append(c.this.mXv.dBw().mRoomID);
                }
                if (c.this.mQI != null && c.this.mQI.mTK != null) {
                    append.append("&mode=").append(c.this.mQI.mTK.mMode);
                }
                append.append("&type=").append(i);
                com.kascend.chushou.d.e.a(c.this.mXw, append.toString());
            }
        });
        this.mQN = (VoiceInteractionView) this.mXg.findViewById(a.f.voiceInteractiveView);
        t();
    }

    protected void c(View view) {
        ArrayList<ChatInfo> c;
        if (this.mXv != null) {
            this.mVk = this.mXv.dBw();
            this.mVl = this.mXv.dBu();
        }
        dBI();
        dBG();
        dBN();
        this.mVZ = (LinearLayout) view.findViewById(a.f.ll_notifier_container);
        this.mVL = (FoodView) view.findViewById(a.f.rav_ad);
        this.mWe = (FrescoThumbnailView) view.findViewById(a.f.ic_shopwindow);
        this.mWf = (ImageView) view.findViewById(a.f.iv_shopwindow_close);
        this.mWe.setOnClickListener(this);
        this.mWf.setOnClickListener(this);
        this.mWg = (RelativeLayout) view.findViewById(a.f.rl_shopwindow);
        this.mVV = (FrescoThumbnailView) view.findViewById(a.f.ftv_pack);
        this.mVV.setOnClickListener(this);
        this.mUM = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mUL = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mVu = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mVu.setOnClickListener(this);
        this.mVj = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mVj.setTag("VideoVerticalViewPager");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVj.getLayoutParams();
        layoutParams.width = (int) (Math.min(this.mVS.x, this.mVS.y) * 0.83d);
        this.mVj.setLayoutParams(layoutParams);
        this.mVm = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.mXw);
        this.mVj.setLayoutManager(this.mVm);
        this.mVj.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mVj.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mVj.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.e.c.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    c.this.dCh();
                } else if (i == 1) {
                    c.this.mVt = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.mVr = new com.kascend.chushou.player.adapter.a(this.mXw, this.mVn);
        if (this.mVk != null) {
            this.mVr.a(this.mVk);
        }
        if (com.kascend.chushou.b.dAD().c != null) {
            this.mVr.a(com.kascend.chushou.b.dAD().c);
        }
        this.mVj.setAdapter(this.mVr);
        this.mVr.a(this.mVn.size());
        this.mVr.notifyDataSetChanged();
        if (this.mXv != null && (c = this.mXv.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        if (this.mUP != null) {
            this.mUP.a();
            this.mUP = null;
        }
        this.mUO = (GiftAnimationLayout) this.mXg.findViewById(a.f.ll_gift_animation);
        this.mUO.setLayoutDefaultBg(a.e.bg_gift_animation_v);
        this.mTW = ((int) (tv.chushou.zues.utils.a.he(this.mXw).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mXw, 84.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mUO.getLayoutParams();
        layoutParams2.bottomMargin = this.mTW;
        this.mUO.setLayoutParams(layoutParams2);
        if (this.mXv != null) {
            this.mUP = new com.kascend.chushou.player.b.a(this.mXw.getApplicationContext(), this.mUO);
            this.mUP.a(this.mXv);
            a(this.mXv.mQp, this.mXv.mQt);
        }
        this.mXg.findViewById(a.f.sv).setTag("VideoVerticalViewPager");
        this.mUN = (EmbeddedButtonLayout) this.mXg.findViewById(a.f.embedded_button_layout);
        this.mUN.a(a.e.btn_side_bar_open, a.e.btn_side_bar_close);
        this.mWb = (VideoShowVoteView) this.mXg.findViewById(a.f.view_video_show_vote);
        this.mWb.setOnClickListener(this);
        this.mWb.setStatusChangeListener(new VideoShowVoteView.a() { // from class: com.kascend.chushou.player.e.c.16
            @Override // com.kascend.chushou.widget.VideoShowVoteView.a
            public void a() {
                c.this.dCd();
            }
        });
        if (this.mXv != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mXw;
            this.mUN.a(videoPlayer.dBe().dCL());
            this.mUN.b(this.mXv.i());
            this.mUL.a(videoPlayer.dBa(), false);
            this.mUM.a(videoPlayer.dBb(), videoPlayer.dBc(), videoPlayer.dBd());
            this.mQI = new com.kascend.chushou.player.e.a();
        }
        this.mYl = new KasBaseMenuView.a() { // from class: com.kascend.chushou.player.e.c.28
            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void a() {
                c.this.mVF = false;
                c.this.b(c.this.mTW, 12);
            }

            @Override // com.kascend.chushou.widget.menu.KasBaseMenuView.a
            public void b() {
                c.this.mVF = true;
                if (c.this.mYb != null) {
                    c.this.mYb.measure(0, 0);
                    int measuredHeight = c.this.mYb.getMeasuredHeight() + tv.chushou.zues.utils.a.dip2px(c.this.mXw, 14.0f);
                    if (measuredHeight > c.this.mTW) {
                        c.this.b(measuredHeight, 12);
                    }
                }
            }
        };
        this.mYf = (PaoGuideView) this.mXg.findViewById(a.f.rlPaoGuideView);
        this.mVH = (PlayShowMicPerson) this.mXg.findViewById(a.f.rl_mic_person_view);
        this.mUR = (PlayShowH5View) this.mXg.findViewById(a.f.rl_playshowh5);
        this.mVN = (FoodView) this.mXg.findViewById(a.f.bottom_ad);
        if (this.mXv != null) {
            H();
            if (this.mXv.mQj != null && !h.isEmpty(this.mXv.mQj.mUrl)) {
                b(this.mXv.mQj);
            }
        }
        this.mVv = this.mXg.findViewById(a.f.view_reminder_subscribe);
        this.mVw = this.mVv.findViewById(a.f.spash_subscribe);
        ((TextView) this.mVv.findViewById(a.f.tv_reminder_subscribe)).setText(new tv.chushou.zues.widget.a.c().O(this.mXw, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.mXw.getString(a.i.videoplayer_reminder_subscribe)));
        this.mVv.setOnClickListener(this);
        this.mVy = this.mXg.findViewById(a.f.view_reminder_danmaku);
        this.mVz = this.mVy.findViewById(a.f.spash_danmaku);
        ((TextView) this.mVy.findViewById(a.f.tv_reminder_danmaku)).setText(new tv.chushou.zues.widget.a.c().O(this.mXw, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.mXw.getString(a.i.videoplayer_reminder_danmaku)));
        this.mVy.setOnClickListener(this);
    }

    private void dBG() {
        this.mWl = (RelativeLayout) this.mXg.findViewById(a.f.rl_cyclelive);
        this.mWm = (RelativeLayout) this.mXg.findViewById(a.f.rlrl_cyclelive);
        this.mWn = (FrescoThumbnailView) this.mXg.findViewById(a.f.iv_liveicon);
        this.mWo = (TextView) this.mXg.findViewById(a.f.tv_livename);
        this.mWp = (TextView) this.mXg.findViewById(a.f.tv_livedesc);
        this.mWq = (ImageView) this.mXg.findViewById(a.f.iv_cyclelive_name_menu);
        this.mWr = (RelativeLayout) this.mXg.findViewById(a.f.rl_normal);
        this.mWs = (LinearLayout) this.mXg.findViewById(a.f.ll_cyclelive_nickname);
        this.mWt = (TextView) this.mXg.findViewById(a.f.tv_cyclelive_nickname);
        this.mWu = (TextView) this.mXg.findViewById(a.f.tv_btn_cyclelive_subscribe);
        this.mWv = (RelativeLayout) this.mXg.findViewById(a.f.rl_clear_cyclelive);
        this.mWw = (RelativeLayout) this.mXg.findViewById(a.f.rlrl_clear_cyclelive);
        this.mWx = (FrescoThumbnailView) this.mXg.findViewById(a.f.iv_clear_liveicon);
        this.mWy = (TextView) this.mXg.findViewById(a.f.tv_clear_livename);
        this.mWz = (TextView) this.mXg.findViewById(a.f.tv_clear_livedesc);
        this.mWA = (ImageView) this.mXg.findViewById(a.f.iv_clear_cyclelive_name_menu);
        this.mWB = (RelativeLayout) this.mXg.findViewById(a.f.rl_clear_normal);
        this.mWA.setOnClickListener(this);
        this.mWq.setOnClickListener(this);
        this.mWu.setOnClickListener(this);
        this.mWt.setOnClickListener(this);
        this.mWn.setOnClickListener(this);
        this.mWx.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void H() {
        if (this.mXv.mQh != null && this.mVN != null) {
            this.mVN.a(true, this.mXv.a == null ? "" : this.mXv.a);
            this.mVN.a(this.mXv.mQh, a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mXv != null && this.mXv.mQo != null && this.mUN != null) {
            this.mVL.a(this.mXv.mQo, 0, new FoodView.a() { // from class: com.kascend.chushou.player.e.c.40
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (c.this.mXv != null) {
                        c.this.mXv.mQo = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.kascend.chushou.player.g
    public com.kascend.chushou.player.b.a dCe() {
        return this.mUP;
    }

    private void dBH() {
        this.mXx = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.e.c.52
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                TextView textView;
                switch (message.what) {
                    case 5:
                        if (c.this.mXg != null && (textView = (TextView) c.this.mXg.findViewById(a.f.LoadingPercent)) != null && textView.getVisibility() == 0) {
                            int i = c.this.ao;
                            if (i < 0) {
                                i = 0;
                            }
                            if (i >= 100) {
                                i = 99;
                            }
                            textView.setText(c.this.mXw.getString(a.i.str_buffer_percent) + ":" + i + "%");
                            c.this.mXx.L(5, 200L);
                            break;
                        }
                        break;
                    case 11:
                        c.this.a(c.this.mXx);
                        break;
                    case 12:
                        c.this.b(c.this.mXx);
                        break;
                    case 17:
                        c.this.dCH();
                        break;
                    case 18:
                        c.this.cWt();
                        break;
                    case 19:
                        c.this.mXu.setVisibility(8);
                        break;
                }
                return false;
            }
        });
    }

    @Override // com.kascend.chushou.player.f
    protected void Q() {
        if (!this.mVi) {
            this.mVi = true;
            if (this.mVh == null) {
                this.mVh = this.mXg.findViewById(a.f.vs_async_show_content);
                this.mVh = ((ViewStub) this.mVh).inflate();
            }
            this.mQX = this.mXg.findViewById(a.f.ui_content);
            if (this.mSt == null) {
                this.mSt = this.mXg.findViewById(a.f.vs_async_notification_view);
                this.mSt = ((ViewStub) this.mSt).inflate();
            }
            c(this.mXg);
            k();
            cWu();
            if (this.c == null) {
                this.mQD = new d.a();
                this.c = new GestureDetector(this.mXw, this.mQD);
            }
            ((VideoPlayer) this.mXw).q();
        }
    }

    private void dBI() {
        this.mUc = (LinearLayout) this.mXg.findViewById(a.f.ll_anchor);
        this.mUd = (RelativeLayout) this.mXg.findViewById(a.f.ll_clear_anchor);
        this.mUc.setVisibility(4);
        this.mUd.setVisibility(4);
        this.mUe = (FrescoThumbnailView) this.mXg.findViewById(a.f.iv_clear_avatar);
        this.mUf = (TextView) this.mXg.findViewById(a.f.tv_clear_nickname);
        this.mUg = (TextView) this.mXg.findViewById(a.f.tv_clear_online_count);
        this.mUh = (TextView) this.mXg.findViewById(a.f.tv_clear_btn_subscribe);
        this.mUh.setOnClickListener(this);
        this.mUi = (FrescoThumbnailView) this.mXg.findViewById(a.f.iv_avatar);
        this.mUj = (TextView) this.mXg.findViewById(a.f.tv_nickname_test);
        this.mUl = (TextView) this.mXg.findViewById(a.f.tv_online_count);
        this.mRj = (TextView) this.mXg.findViewById(a.f.tv_btn_subscribe);
        this.mRj.setOnClickListener(this);
        this.mUm = (TextView) this.mXg.findViewById(a.f.tv_loyal_counts);
        this.mRm = (TextView) this.mXg.findViewById(a.f.tv_btn_contribution);
        this.mUo = (TextView) this.mXg.findViewById(a.f.tv_btn_contribution_forpk);
        this.mRm.setVisibility(4);
        this.mUo.setVisibility(8);
        this.mUp = (LinearLayout) this.mXg.findViewById(a.f.ll_mic);
        this.mUq = (PlayShowMicStatusView) this.mXg.findViewById(a.f.show_mic_status);
        this.mUr = (RecyclerView) this.mXg.findViewById(a.f.rv_loyal);
        this.mUs = (ImageView) this.mXg.findViewById(a.f.iv_clear_close);
        this.mRr = (ImageView) this.mXg.findViewById(a.f.iv_close);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.mUr.setLayoutManager(linearLayoutManager);
        this.mVD = new tv.chushou.zues.widget.adapterview.recyclerview.a.a<OnlineVipItem>(this.mVE, a.h.item_show_online_loyal, new tv.chushou.zues.widget.adapterview.d() { // from class: com.kascend.chushou.player.e.c.54
            @Override // tv.chushou.zues.widget.adapterview.d
            public void onItemClick(View view, int i) {
                OnlineVipItem onlineVipItem = c.this.mVE.get(i);
                if (onlineVipItem != null) {
                    com.kascend.chushou.d.a.a(c.this.mXw, (JSONObject) null, c.this.mXv.dBw().mRoomID, onlineVipItem.mUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
                    frescoThumbnailView.i(onlineVipItem.mAvatar, tv.chushou.widget.a.c.dOT(), b.a.small, b.a.small);
                    int dip2px = tv.chushou.zues.utils.a.dip2px(c.this.mXw, 1.0f);
                    if (i == 0) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXw, a.c.color_FFBF3D), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal1);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score1);
                        textView.setTextColor(Color.parseColor("#FFBF3D"));
                    } else if (i == 1) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXw, a.c.color_A6D9FF), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal2);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score2);
                        textView.setTextColor(Color.parseColor("#A6D9FF"));
                    } else if (i == 2) {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXw, a.c.color_DFA7A7), dip2px);
                        imageView.setVisibility(0);
                        imageView.setImageResource(a.e.ic_playshow_loyal3);
                        textView.setBackgroundResource(a.e.bg_playshow_loyal_score3);
                        textView.setTextColor(Color.parseColor("#DFA7A7"));
                    } else {
                        frescoThumbnailView.setBorderColor(ContextCompat.getColor(c.this.mXw, a.c.color_979797), dip2px);
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
        this.mUr.setAdapter(this.mVD);
        this.mUp.setOnClickListener(this);
        this.mUe.setOnClickListener(this);
        this.mUs.setOnClickListener(this);
        this.mUi.setOnClickListener(this);
        this.mUe.setOnClickListener(this);
        this.mRr.setOnClickListener(this);
        this.mUm.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.57
            @Override // tv.chushou.zues.a
            public void dx(View view) {
                String str = tv.chushou.common.a.dOH() + "m/bigfans/online-list.htm?roomId=";
                if (c.this.mXv != null) {
                    str = str + c.this.mXv.dBw().mRoomID;
                }
                c.this.f(c.this.mXw.getString(a.i.str_loyal_fans), str);
            }
        });
        this.mRm.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.12
            @Override // tv.chushou.zues.a
            public void dx(View view) {
                String str = tv.chushou.common.a.dOH() + "m/room-billboard/";
                if (c.this.mXv != null) {
                    str = str + c.this.mXv.dBw().mRoomID;
                }
                c.this.f(c.this.mXw.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
        this.mUo.setOnClickListener(new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.e.c.23
            @Override // tv.chushou.zues.a
            public void dx(View view) {
                String str = tv.chushou.common.a.dOH() + "m/room-billboard/";
                if (c.this.mXv != null) {
                    str = str + c.this.mXv.dBw().mRoomID;
                }
                c.this.f(c.this.mXw.getString(a.i.str_contribute_tittle), str + ".htm");
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void N() {
        s(true);
    }

    public void s(boolean z) {
        boolean z2;
        if (this.mVl == null || this.mVl.cycleLiveRoomInfo == null || h.isEmpty(this.mVl.cycleLiveRoomInfo.roomId)) {
            z2 = false;
        } else {
            z2 = true;
            this.mQL = this.mVl.cycleLiveRoomInfo;
        }
        if (z2 && this.mQL != null) {
            this.mWl.setVisibility(0);
            this.mWv.setVisibility(0);
            this.mWr.setVisibility(8);
            this.mWB.setVisibility(8);
            this.mWs.setVisibility(0);
            this.mWx.h(this.mQL.eventIcon, com.kascend.chushou.view.a.a(this.mVk.mCreatorGender), b.a.small, b.a.small);
            this.mWn.h(this.mQL.eventIcon, com.kascend.chushou.view.a.a(this.mVk.mCreatorGender), b.a.small, b.a.small);
            this.mWy.setText(this.mQL.eventName);
            this.mWz.setText(this.mQL.eventDesc);
            this.mWo.setText(this.mQL.eventName);
            this.mWp.setText(this.mQL.eventDesc);
            this.mWt.setText(this.mQL.nickname);
            dBK();
            if (z) {
                c(this.mQL.remainTime);
                return;
            }
            return;
        }
        this.mWl.setVisibility(8);
        this.mWv.setVisibility(8);
        this.mWr.setVisibility(0);
        this.mWB.setVisibility(0);
        this.mWs.setVisibility(8);
    }

    private void c(long j) {
        long j2 = 5 + j;
        if (this.mWC != null) {
            this.mWC.dispose();
            this.mWC = null;
        }
        this.mWC = g.a(0L, j2, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dHX()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.e.c.34
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
                if (c.this.mXw != null && (c.this.mXw instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mXw).u();
                }
            }
        });
    }

    private void dBJ() {
        if (this.mVk != null && this.mVi) {
            this.mUc.setVisibility(0);
            this.mUd.setVisibility(0);
            this.mRm.setVisibility(0);
            this.mUe.h(this.mVk.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVk.mCreatorGender), b.a.small, b.a.small);
            this.mUf.setText(this.mVk.mCreatorNickname);
            this.mUi.h(this.mVk.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVk.mCreatorGender), b.a.small, b.a.small);
            this.mUj.setText(this.mVk.mCreatorNickname);
            dCt();
            dBL();
        }
    }

    @Override // com.kascend.chushou.player.g
    public void dCt() {
        if (this.mVk != null) {
            this.mUg.setText(tv.chushou.zues.utils.b.formatNumber(this.mVk.mOnlineCount));
            this.mUl.setText(tv.chushou.zues.utils.b.formatNumber(this.mVk.mOnlineCount));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBK() {
        if (this.mQL != null) {
            if (this.mQL.isSubscribe) {
                this.mWu.setText(a.i.like_already);
                this.mWu.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mWu.setText(getString(a.i.like));
            this.mWu.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBL() {
        if (this.mVk != null) {
            if (this.mVk.mIsSubscribed) {
                this.mUh.setText(getString(a.i.like_already));
                this.mUh.setBackgroundResource(a.e.bg_show_subcribe);
                this.mRj.setText(getString(a.i.like_already));
                this.mRj.setBackgroundResource(a.e.bg_show_subcribe);
                return;
            }
            this.mUh.setText(getString(a.i.like));
            this.mUh.setBackgroundResource(a.e.bg_show_subcribe);
            this.mRj.setText(getString(a.i.like));
            this.mRj.setBackgroundResource(a.e.bg_show_subcribe);
        }
    }

    private void dBM() {
        if (this.mVD != null) {
            this.mVD.notifyDataSetChanged();
        }
    }

    private void dBN() {
        this.mUu = this.mXg.findViewById(a.f.tv_interact);
        this.mUu.setOnClickListener(this);
        this.mUz = (RelativeLayout) this.mXg.findViewById(a.f.rl_edit_bar);
        this.mUx = (ImageView) this.mXg.findViewById(a.f.btn_hotword);
        this.mUx.setOnClickListener(this);
        this.mUy = (ImageView) this.mXg.findViewById(a.f.iv_task_badge);
        this.mUw = (AnimationSet) AnimationUtils.loadAnimation(this.mXw, a.C0682a.anim_hotword);
        this.mUw.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.58
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                if (com.kascend.chushou.d.h.dAK().c) {
                    c.this.mUx.clearAnimation();
                    c.this.mUx.startAnimation(c.this.mUw);
                }
            }
        });
        if (com.kascend.chushou.d.h.dAK().c) {
            this.mUx.startAnimation(this.mUw);
            this.mUy.setVisibility(0);
        }
        this.mWD = (TextView) this.mXg.findViewById(a.f.tv_bottom_input);
        this.mWD.setOnClickListener(this);
        this.mYv = (FrescoThumbnailView) this.mXg.findViewById(a.f.ll_btn_set);
        this.mYv.setOnClickListener(this);
        this.mYv.xi(a.e.ic_room_set_btn_white);
        this.mUI = (LinearLayout) this.mXg.findViewById(a.f.ll_bottom_all_button);
        this.mUJ = (FrescoThumbnailView) this.mXg.findViewById(a.f.fl_clear_bottom_gift);
        this.mUJ.setAnim(true);
        this.mUJ.setOnClickListener(this);
        this.mUJ.xi(a.e.ic_show_gift_n);
        this.mUK = (FrameLayout) this.mXg.findViewById(a.f.flfl_clear_bottom_gift);
        this.mUK.setVisibility(8);
        this.mUv = (RelativeLayout) this.mXg.findViewById(a.f.rl_bottom_input);
        this.mUv.setVisibility(0);
        this.mUA = (PastedEditText) this.mXg.findViewById(a.f.et_bottom_input);
        this.mUA.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.59
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mRA.setEnabled(editable.length() > 0);
            }
        });
        this.mUA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.60
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (4 == i) {
                    c.this.onClick(c.this.mRA);
                    return true;
                }
                return true;
            }
        });
        this.mUA.setOnKeyListener(new View.OnKeyListener() { // from class: com.kascend.chushou.player.e.c.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 67) {
                    return c.this.o(c.this.mUA);
                }
                return false;
            }
        });
        this.mRJ = (ImageView) this.mXg.findViewById(a.f.iv_btn_emoji);
        this.mRJ.setVisibility(8);
        this.mRA = (TextView) this.mXg.findViewById(a.f.tv_btn_send);
        this.mRA.setOnClickListener(this);
        this.mUS = (LinearLayout) this.mXg.findViewById(a.f.head_trumpet);
        this.mUS.setVisibility(8);
        this.mUS.setOnClickListener(this);
        this.mUT = (TextView) this.mXg.findViewById(a.f.tv_primary_name);
        this.mUU = (TextView) this.mXg.findViewById(a.f.tv_primary_desc);
        this.mUW = (TextView) this.mXg.findViewById(a.f.tv_cut_count);
        this.mUW.setOnClickListener(this);
        this.mUY = (TextView) this.mXg.findViewById(a.f.tv_head_count);
        this.mUY.setText(this.mVb + "");
        this.mUX = (TextView) this.mXg.findViewById(a.f.tv_plus_count);
        this.mUX.setOnClickListener(this);
        this.mSd = (TextView) this.mXg.findViewById(a.f.tv_buy_count_coin);
        this.mUV = (TextView) this.mXg.findViewById(a.f.tv_buy_head);
        this.mUV.setOnClickListener(this);
        this.mUZ = (ImageView) this.mXg.findViewById(a.f.iv_trumpet_select);
        this.mUZ.setOnClickListener(this);
        this.mVa = (TextView) this.mXg.findViewById(a.f.tv_trumpet_have_count);
        this.mVc = false;
        this.mUZ.setBackgroundResource(a.e.ic_trumpet_n);
        this.mVa.setVisibility(8);
        this.mRI = (KPSwitchPanelLinearLayout) this.mXg.findViewById(a.f.chat_extended_container);
        dBT();
        tv.chushou.zues.widget.kpswitch.b.a.a(this.mRI, this.mRJ, this.mUA, new a.InterfaceC0809a() { // from class: com.kascend.chushou.player.e.c.3
            @Override // tv.chushou.zues.widget.kpswitch.b.a.InterfaceC0809a
            public void we(boolean z) {
                if (c.this.mRJ != null) {
                    if (z) {
                        c.this.mRI.setDirectVisibility(0);
                        c.this.mRJ.setImageResource(a.e.cs_keyboard_normal);
                        return;
                    }
                    c.this.mRJ.setImageResource(a.e.cs_emoji_normal);
                }
            }
        });
        this.mRM = new d.a() { // from class: com.kascend.chushou.player.e.c.5
            @Override // tv.chushou.zues.widget.kpswitch.b.d.a
            public void wf(boolean z) {
                c.this.mRK = z;
                if (z) {
                    c.this.mRJ.setImageResource(a.e.cs_emoji_normal);
                    c.this.dBP();
                    if (c.this.mWk != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c.this.mWk.getLayoutParams();
                        layoutParams.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hp(c.this.mXw);
                        c.this.mWk.setLayoutParams(layoutParams);
                    }
                    if (c.this.mUz != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c.this.mUz.getLayoutParams();
                        layoutParams2.bottomMargin = tv.chushou.zues.widget.kpswitch.b.d.hp(c.this.mXw);
                        c.this.mUz.setLayoutParams(layoutParams2);
                        return;
                    }
                    return;
                }
                if (c.this.mWk != null && c.this.mWk.getVisibility() == 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c.this.mWk.getLayoutParams();
                    layoutParams3.bottomMargin = 0;
                    c.this.mWk.setLayoutParams(layoutParams3);
                    c.this.mWk.setVisibility(8);
                }
                if (c.this.mVF) {
                    c.this.mYb.setVisibility(0);
                }
                if (c.this.mXw != null && (c.this.mXw instanceof VideoPlayer)) {
                    ((VideoPlayer) c.this.mXw).wd(true);
                }
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(7, null));
                if (c.this.mUz != null && c.this.mRI.getVisibility() != 0) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c.this.mUz.getLayoutParams();
                    layoutParams4.bottomMargin = 0;
                    c.this.mUz.setLayoutParams(layoutParams4);
                }
            }
        };
        this.mRL = tv.chushou.zues.widget.kpswitch.b.d.a(getActivity(), this.mRI, this.mRM, ((VideoPlayer) this.mXw).dAZ());
        ((VideoPlayer) this.mXw).g(((VideoPlayer) this.mXw).dAZ());
        this.mWk = this.mXg.findViewById(a.f.rl_room_emoji_search_edit_bar);
        this.mWh = (TextView) this.mXg.findViewById(a.f.btn_room_search);
        this.mWi = (ImageView) this.mXg.findViewById(a.f.iv_room_emoji_delete);
        this.mWj = (EditText) this.mXg.findViewById(a.f.et_room_emoji_search);
        this.mWj.setImeOptions(3);
        this.mWj.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kascend.chushou.player.e.c.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 == i) {
                    c.this.onClick(c.this.mWh);
                    return true;
                }
                return false;
            }
        });
        this.mWj.addTextChangedListener(new tv.chushou.zues.toolkit.c.b() { // from class: com.kascend.chushou.player.e.c.7
            @Override // tv.chushou.zues.toolkit.c.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                c.this.mWh.setEnabled(editable.length() > 0);
                c.this.mWi.setVisibility(editable.length() <= 0 ? 8 : 0);
                c.this.mYb.setEmojiSearchText(editable.toString());
            }
        });
        this.mWh.setOnClickListener(this);
        this.mWi.setOnClickListener(this);
    }

    @Override // com.kascend.chushou.player.g
    protected void ar(boolean z, boolean z2) {
        if (z) {
            tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mWj);
            this.mWk.setVisibility(0);
            this.mWj.requestFocus();
        } else {
            this.mWk.setVisibility(8);
        }
        if (z2) {
            this.mWj.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBP() {
        int hp = tv.chushou.zues.widget.kpswitch.b.d.hp(this.mXw) + tv.chushou.zues.utils.a.dip2px(this.mXw, 14.0f);
        if (hp > this.mTW) {
            b(hp, 12);
        }
    }

    private void dBT() {
    }

    private void dBV() {
        if (this.mVe > 0) {
            View findViewById = this.mXg.findViewById(a.f.video_container);
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + this.mVe);
        }
        if (this.mVd > 0) {
            View findViewById2 = this.mXg.findViewById(a.f.ui_content);
            findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + this.mVd, findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        }
        if (!this.mVB) {
            Q();
        }
        MN(a.e.bg_gift_animation_v);
        dCa();
        a();
        this.mQF = ((VideoPlayer) this.mXw).dAW();
        this.mQF.a(this);
        if (this.mXv.dBu() != null) {
            s();
        } else if (this.N != null) {
            this.N.setVisibility(0);
        }
        if (this.mQF != null) {
            this.mQF.d();
        }
    }

    private void dBW() {
        if ((this.mQI == null || this.mQI.mTK == null || !this.mQI.mTK.mInPKMode) ? false : true) {
            if (this.mTX != null) {
                this.mTX.setBackgroundResource(a.e.bg_showpk);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mQK.getLayoutParams();
            layoutParams.leftMargin = (this.mVS.x / 2) + tv.chushou.zues.utils.a.dip2px(this.mXw, 5.0f);
            layoutParams.bottomMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
                layoutParams.removeRule(12);
            }
            layoutParams.addRule(9);
            this.mQK.setLayoutParams(layoutParams);
            this.y.setText(this.mQI.mTK.mPkUserNickname);
            this.mQK.setVisibility(0);
            this.mUp.setVisibility(8);
            return;
        }
        if (this.mTX != null) {
            this.mTX.setBackgroundResource(a.e.ic_audio_bg);
        }
        this.mQK.setVisibility(8);
    }

    private void dBX() {
        boolean z = false;
        if (this.mQI != null && this.mQI.mTK != null && this.mQI.mTK.mInPKMode) {
            z = true;
        }
        if (z || this.E) {
            if (this.mWd > 0 && this.mVj != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVj.getLayoutParams();
                if (layoutParams.height != this.mWd) {
                    layoutParams.height = this.mWd;
                    this.mVj.setLayoutParams(layoutParams);
                }
            }
            this.mTW = ((int) (tv.chushou.zues.utils.a.he(this.mXw).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mXw, 84.0f);
            b(this.mTW, 12);
        } else {
            if (this.mVj != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVj.getLayoutParams();
                if (layoutParams2.height != tv.chushou.zues.utils.a.dip2px(this.mXw, 250.0f)) {
                    layoutParams2.height = tv.chushou.zues.utils.a.dip2px(this.mXw, 250.0f);
                    this.mVj.setLayoutParams(layoutParams2);
                }
            }
            this.mTW = ((int) (tv.chushou.zues.utils.a.he(this.mXw).y * 0.44d)) - tv.chushou.zues.utils.a.dip2px(this.mXw, 84.0f);
            b(this.mTW, 12);
        }
        if (this.mQJ != null) {
            this.mQJ.a(this.mWd + tv.chushou.zues.utils.a.dip2px(this.mXw, 52.0f), this.mXA);
        }
        if (this.mQN != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mQN.getLayoutParams();
            layoutParams3.bottomMargin = this.mWd + tv.chushou.zues.utils.a.dip2px(this.mXw, 52.0f);
            this.mQN.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dBZ();
    }

    @Override // com.kascend.chushou.player.d
    protected void u() {
        dBZ();
    }

    private void dBY() {
        dBX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBZ() {
        int i;
        int i2;
        int i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) dCF().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        this.mVS = tv.chushou.zues.utils.a.hf(this.mXw);
        this.mVR = 86;
        this.mVP = (Math.max(this.mVS.x, this.mVS.y) - tv.chushou.zues.utils.a.dip2px(this.mXw, (this.mVR + 52) + 250)) - this.mVd;
        this.mVQ = Math.max(this.mVS.x, this.mVS.y) - ((tv.chushou.zues.utils.a.dip2px(this.mXw, this.mVR) + this.mVd) * 2);
        if (this.mVT <= 0 || this.mVU <= 0) {
            this.mVT = Math.min(this.mVS.x, this.mVS.y);
            this.mVU = Math.max(this.mVS.x, this.mVS.y);
        }
        this.ar = Math.min(this.mVS.x, this.mVS.y);
        this.mXA = (this.ar * this.mVU) / this.mVT;
        boolean z = false;
        if (this.mQI == null || this.mQI.mTK == null) {
            i = 1;
        } else {
            i = this.mQI.mTK.mMode;
            if (this.mQI.mTK.mInPKMode) {
                z = true;
            }
        }
        if (z) {
            this.mVR = 42;
            if (i == 2) {
                if (this.mVU < this.mVT) {
                    layoutParams.width = this.ar;
                    layoutParams.height = this.mXA;
                    layoutParams2.width = this.ar;
                    layoutParams2.height = this.mXA;
                } else {
                    layoutParams.width = this.ar;
                    layoutParams.height = (this.ar * 16) / 18;
                    layoutParams2.width = (this.mVT * layoutParams.height) / this.mVU;
                    layoutParams2.height = layoutParams.height;
                    this.mXA = layoutParams.height;
                    layoutParams2.addRule(13);
                }
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = this.mXA;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXA;
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, this.mVR) + this.mVd;
            layoutParams.gravity = 48;
            this.mWd = ((this.mVS.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mXw, (this.mVR + 52) + 64) + this.mVd)) - tv.chushou.zues.utils.systemBar.b.aB(getActivity());
            dBD();
        } else if (this.E) {
            this.mVR = 42;
            if (this.mVU < this.mVT) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mXA;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXA;
            } else {
                layoutParams.width = this.ar;
                layoutParams.height = (this.ar * 16) / 18;
                layoutParams2.width = (this.mVT * layoutParams.height) / this.mVU;
                layoutParams2.height = layoutParams.height;
                this.mXA = layoutParams.height;
                layoutParams2.addRule(13);
            }
            layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, this.mVR) + this.mVd;
            layoutParams.gravity = 48;
            this.mWd = ((this.mVS.y - layoutParams.height) - (tv.chushou.zues.utils.a.dip2px(this.mXw, (this.mVR + 52) + 98) + this.mVd)) - tv.chushou.zues.utils.systemBar.b.aB(getActivity());
            dBY();
        } else {
            this.mWd = -1;
            this.mVR = 86;
            if (this.mXA <= this.mVP) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mVP;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, this.mVR) + this.mVd;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.removeRule(10);
                }
                layoutParams2.addRule(13);
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXA;
            } else if (this.mXA < this.mVQ) {
                layoutParams.width = this.ar;
                layoutParams.height = this.mXA;
                layoutParams.topMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, this.mVR) + this.mVd;
                layoutParams.gravity = 48;
                layoutParams2.width = this.ar;
                layoutParams2.height = this.mXA;
            } else {
                this.mXA = Math.max(this.mVS.x, this.mVS.y);
                layoutParams.width = this.ar;
                layoutParams.height = this.mXA;
                layoutParams.topMargin = 0;
                if ("2".equals(this.ax)) {
                    if ((this.mXA * this.mVT) / this.mVU >= this.ar) {
                        i3 = this.mXA;
                        i2 = (this.mXA * this.mVT) / this.mVU;
                    } else if ((this.ar * this.mVU) / this.mVT >= this.mXA) {
                        i2 = this.ar;
                        i3 = (this.ar * this.mVU) / this.mVT;
                    } else {
                        i2 = this.ar;
                        i3 = this.mXA;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        layoutParams2.removeRule(13);
                    }
                    layoutParams2.addRule(10);
                    if (i2 > this.ar) {
                        layoutParams.width = i2;
                        layoutParams.gravity = 1;
                    }
                    if (i3 > this.mXA) {
                        layoutParams.height = i3;
                        layoutParams.gravity = 16;
                    }
                } else {
                    if ((this.ar * this.mVU) / this.mVT > this.mXA) {
                        i3 = this.mXA;
                        i2 = (this.mXA * this.mVT) / this.mVU;
                        if (i2 > this.ar) {
                            i2 = this.ar;
                            i3 = (this.ar * this.mVU) / this.mVT;
                        }
                    } else {
                        i2 = this.ar;
                        i3 = (this.ar * this.mVU) / this.mVT;
                        if (i3 > this.mXA) {
                            i3 = this.mXA;
                            i2 = (this.mXA * this.mVT) / this.mVU;
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
        if (this.mXv != null && this.mXv.d) {
            layoutParams.width = Math.min(this.mVS.x, this.mVS.y);
            layoutParams.height = Math.max(this.mVS.x, this.mVS.y);
        }
        dCF().setLayoutParams(layoutParams);
        this.N.setLayoutParams(layoutParams2);
        this.N.requestLayout();
    }

    private void dCa() {
        this.N = new SurfaceRenderView(this.mXw);
        SurfaceRenderView surfaceRenderView = (SurfaceRenderView) this.N;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        surfaceRenderView.setLayoutParams(layoutParams);
        dCF().addView(surfaceRenderView, 0);
        surfaceRenderView.getHolder().addCallback(this);
    }

    @Override // com.kascend.chushou.player.d
    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mVK) {
            tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "mode 切换动画中");
            return false;
        } else if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            if (motionEvent.getX() - motionEvent2.getX() > q) {
                return dCw();
            }
            if (motionEvent.getX() - motionEvent2.getX() >= 0.0f || Math.abs(motionEvent.getX() - motionEvent2.getX()) <= q) {
                return false;
            }
            return dCv();
        } else {
            return false;
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a() {
        if (this.mWG != null) {
            this.mWG.a();
        }
        if (this.mXv != null && !h.isEmpty(this.mXv.mQr)) {
            b(this.mXv.mQr);
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void y() {
        if (this.mTJ != null) {
            int width = this.mTJ.getWidth();
            int height = this.mTJ.getHeight();
            if (this.mVT != width || this.mVU != height || this.mVT <= 0 || this.mVU <= 0) {
                this.mVT = width;
                this.mVU = height;
                if (this.N != null) {
                    this.N.post(new Runnable() { // from class: com.kascend.chushou.player.e.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.dBZ();
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
            if (this.mVF) {
                dCc();
            } else {
                if (this.mXw.getResources().getDisplayMetrics().density < 2.0f) {
                    b(true, false);
                } else {
                    b(true, true);
                }
                com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击送礼_num", "竖屏", new Object[0]);
                if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                    com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXv.dBu().mRoominfo.mRoomID);
                }
            }
        } else if (id == a.f.tv_btn_send) {
            if (this.mVc) {
                f(this.mUA.getText().toString());
            } else {
                a(this.mUA.getText().toString(), false);
            }
        } else if (id == a.f.btn_hotword) {
            if (com.kascend.chushou.d.h.dAK().c) {
                com.kascend.chushou.d.h.dAK().b(false);
                this.mUw.cancel();
                this.mUw.reset();
                this.mUx.clearAnimation();
                this.mUy.setVisibility(8);
            }
            k(view, 0, this.mXg.findViewById(a.f.ll_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.ll_btn_set) {
            int x = (((int) view.getX()) + view.getWidth()) - (tv.chushou.zues.utils.a.dip2px(this.mXw, 165.0f) / 2);
            j(view, x >= 0 ? x : 0, this.mXg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
        } else if (id == a.f.tv_open_video) {
            if (this.mXv.e) {
                tv.chushou.zues.utils.e.d("VideoPlayShowFragment", "正在切换线路");
                return;
            } else if (this.mXv.d) {
                ai();
            }
        } else if (id == a.f.btn_scrollbottom) {
            if (this.mVj != null) {
                u(true);
            }
        } else if (id == a.f.ll_mic) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.tv_clear_btn_subscribe || id == a.f.tv_btn_subscribe) {
            if (this.mVk != null) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
                hashMap.put("_fromPos", "74");
                b(hashMap);
            } else {
                return;
            }
        } else if (id == a.f.tv_interact) {
            this.mVJ = 1;
            wg(false);
        } else if (id == a.f.iv_avatar || id == a.f.iv_clear_avatar || id == a.f.iv_liveicon || id == a.f.iv_clear_liveicon) {
            com.kascend.chushou.d.a.a(this.mXw, (JSONObject) null, this.mXv.dBw().mRoomID, this.mXv.dBw().mCreatorUID, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
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
            a(this.mXw.getResources().getString(a.i.hotword_1), true);
            com.kascend.chushou.toolkit.a.c.a(this.mXw, "双击666_num", null, new Object[0]);
        } else if (id != a.f.view_video_show_vote) {
            if (id == a.f.ic_shopwindow) {
                if (this.mVM != null) {
                    com.kascend.chushou.d.e.a(this.mXw, this.mVM, (JSONObject) null);
                }
            } else if (id == a.f.iv_shopwindow_close) {
                if (this.mWg != null) {
                    this.mWg.setVisibility(8);
                }
            } else if (id == a.f.iv_trumpet_select) {
                if (com.kascend.chushou.d.e.c(this.mXw, null) && this.mXv != null && this.mXv.mQs != null) {
                    if (this.mVc) {
                        dCD();
                    } else {
                        if (this.mXv != null && this.mXv.mQs != null && this.mXv.mQs.count > 0) {
                            this.mUS.setVisibility(8);
                        } else {
                            this.mUS.setVisibility(0);
                        }
                        this.mVc = true;
                        this.mUZ.setBackgroundResource(a.e.ic_trumpet_p);
                        this.mVa.setVisibility(0);
                        this.mVa.setSelected(true);
                        this.mVa.setTextColor(Color.parseColor("#ff5959"));
                        if (this.mUA != null) {
                            this.mUA.setHint(a.i.str_danmu_trumpet_hint);
                        }
                    }
                }
            } else if (id == a.f.tv_plus_count) {
                if (this.mVb <= 9) {
                    this.mVb++;
                    this.mUY.setText(this.mVb + "");
                }
                dBE();
            } else if (id == a.f.tv_cut_count) {
                if (this.mVb > 1) {
                    this.mVb--;
                    this.mUY.setText(this.mVb + "");
                }
                dBE();
            } else if (id == a.f.tv_buy_head) {
                dCC();
            } else if (id == a.f.iv_room_emoji_delete) {
                this.mWj.setText("");
            } else if (id == a.f.btn_room_search) {
                String obj = this.mWj.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.mWk.setVisibility(8);
                    tv.chushou.zues.widget.kpswitch.b.d.dK(this.mWj);
                    this.mYb.a(obj);
                }
            } else if (id == a.f.iv_clear_cyclelive_name_menu || id == a.f.iv_cyclelive_name_menu) {
                if (this.mQL != null && !h.isEmpty(this.mQL.eventUrl)) {
                    f("", this.mQL.eventUrl);
                }
            } else if (id == a.f.tv_btn_cyclelive_subscribe) {
                if (this.mQL != null) {
                    a((Map<String, String>) null);
                }
            } else if (id == a.f.tv_cyclelive_nickname) {
                if (this.mQL != null) {
                    com.kascend.chushou.d.a.a(this.mXw, (JSONObject) null, this.mQL.roomId, this.mQL.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                }
            } else if (id == a.f.tv_error_refresh_again) {
                if (this.al) {
                    this.al = false;
                    this.mXv.a(false);
                    ((VideoPlayer) this.mXw).l();
                } else {
                    ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
                }
            }
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        if (this.mUR != null) {
            int i = (tv.chushou.zues.utils.a.he(this.mXw).x * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUR.getLayoutParams();
            layoutParams.topMargin = i;
            this.mUR.setLayoutParams(layoutParams);
            this.mUR.setVisibilityListener(new com.kascend.chushou.widget.menu.a() { // from class: com.kascend.chushou.player.e.c.9
                @Override // com.kascend.chushou.widget.menu.a
                public void a() {
                    c.this.l();
                }

                @Override // com.kascend.chushou.widget.menu.a
                public void b() {
                    c.this.k();
                }
            });
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_bottom_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_bottom_anim);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = str2;
            h5Options.c = false;
            this.mUR.a(getChildFragmentManager(), str, h5Options, loadAnimation, loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.g
    protected boolean a(String str, boolean z) {
        if (h.isEmpty(str)) {
            return false;
        }
        if (!h.isEmpty(this.b) && this.b.equals(str)) {
            Toast.makeText(this.mXw, a.i.str_same_content, 0).show();
            return false;
        } else if (System.currentTimeMillis() - this.mVI <= 3000) {
            Toast.makeText(this.mXw, a.i.str_too_fast, 0).show();
            return false;
        } else {
            cWA();
            if (!com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a(((VideoPlayer) this.mXw).dAV().h, "_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "9")) || LoginManager.Instance().getUserInfo() == null) {
                return false;
            }
            this.b = str.trim();
            this.b = com.kascend.chushou.d.e.b(this.b);
            this.mVI = System.currentTimeMillis();
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                a(this.mXv.dBu().mRoominfo.mRoomID, this.b, LoginManager.Instance().getUserInfo().mToken, this.mXv.h);
            }
            g(this.b);
            if (!z && this.mUA != null) {
                this.mUA.setText((CharSequence) null);
            }
            return true;
        }
    }

    private void f(String str) {
        if (!h.isEmpty(str)) {
            cWA();
            if (com.kascend.chushou.d.e.c(this.mXw, null) && LoginManager.Instance().getUserInfo() != null && this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                a(this.mXv.dBu().mRoominfo.mRoomID, com.kascend.chushou.d.e.b(str.trim()));
            }
            if (this.mUA != null) {
                this.mUA.setText((CharSequence) null);
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
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mXv.dBu().mRoominfo.mRoomID)) {
                chatInfo.mRoomID = this.mXv.dBu().mRoominfo.mRoomID;
            }
            String str3 = userInfo.mNickname;
            PrivilegeInfo privilegeInfo = ((VideoPlayer) this.mXw).mOE;
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
        if (this.mXV != null && this.mXV.isShowing()) {
            this.mXV.dismiss();
        }
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
        if (this.mYs == null) {
            i(3);
        }
        this.mYs.getContentView().setBackgroundResource(0);
        this.mYs.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
        if (!this.mYs.isShowing()) {
            this.mYs.showAtLocation(view, 83, i, i2);
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", SoUtils.SO_EVENT_ID_NEW_SO, "roomId", this.mXv.dBu().mRoominfo.mRoomID);
                return;
            }
            return;
        }
        this.mYs.dismiss();
    }

    @Override // com.kascend.chushou.player.g
    protected void dBU() {
        if (h.isEmpty(this.mYw)) {
            if (((VideoPlayer) this.mXw).q) {
                this.mYv.xi(a.e.ic_room_set_btn_white);
            } else {
                this.mYv.xi(a.e.ic_room_set_btn_effect_white);
            }
        } else if (((VideoPlayer) this.mXw).q && this.mYw.size() == 2 && this.mYw.contains("4") && this.mYw.contains("2")) {
            this.mYv.xi(a.e.ic_room_set_btn_system_white);
        } else if (this.mYw.size() > 1 || !((VideoPlayer) this.mXw).q) {
            this.mYv.xi(a.e.ic_room_set_btn_more_white);
        } else if ("1".equals(this.mYw.get(0))) {
            this.mYv.xi(a.e.ic_room_set_btn_chat_white);
        } else if ("3".equals(this.mYw.get(0))) {
            this.mYv.xi(a.e.ic_room_set_btn_gift_white);
        } else if ("4".equals(this.mYw.get(0))) {
            this.mYv.xi(a.e.ic_room_set_btn_system_white);
        }
    }

    private void k(View view, int i, int i2) {
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
        if (this.mXV == null) {
            a(a.h.face_show_hotword_item, a.c.face_show_popitem_color_select);
            this.mXV.getContentView().setBackgroundResource(0);
            this.mXV.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mXV.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.10
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mUx.setImageResource(a.e.ic_hotwords_white);
                    c.this.ao();
                }
            });
        }
        if (!this.mXV.isShowing()) {
            this.mXV.showAtLocation(view, 83, i, tv.chushou.zues.utils.a.dip2px(this.mXw, 16.0f) + i2);
            this.mUx.setImageResource(a.e.ic_hotwords_white_pressed);
            if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "roomId", this.mXv.dBu().mRoominfo.mRoomID);
            }
            am();
            return;
        }
        this.mXV.dismiss();
    }

    private void dz(View view) {
        if (this.mXP == null) {
            dCf();
        }
        if (com.kascend.chushou.d.h.dAK().q()) {
            this.mUB.dOR();
        } else {
            this.mUB.dOS();
        }
        int height = this.mXg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity());
        if (view != null) {
            this.mXP.showAtLocation(view, 85, 0, height);
        }
    }

    private void dCf() {
        if (this.mXP == null) {
            View inflate = LayoutInflater.from(this.mXw).inflate(a.h.popup_face_show_more, (ViewGroup) null);
            this.mUB = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
            if (com.kascend.chushou.d.h.dAK().q()) {
                this.mUB.dOR();
            } else {
                this.mUB.dOS();
            }
            this.mUB.setOnToggleChanged(new ToggleButton.a() { // from class: com.kascend.chushou.player.e.c.11
                @Override // tv.chushou.widget.ToggleButton.a
                public void a(boolean z, ToggleButton toggleButton) {
                    com.kascend.chushou.d.h.dAK().g(z);
                }
            });
            this.mXJ = (RelativeLayout) inflate.findViewById(a.f.rl_decode);
            this.mXK = (OnlineToggleButton) inflate.findViewById(a.f.btn_decode_toggle);
            this.mXJ.setOnClickListener(this);
            if (com.kascend.chushou.c.a) {
                this.mXJ.setVisibility(0);
            } else {
                this.mXJ.setVisibility(8);
            }
            if (com.kascend.chushou.d.h.dAK().a) {
                this.mXK.b();
            } else {
                this.mXK.c();
            }
            if (this.mXv != null) {
                final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.ll_playlist);
                ArrayList<PlayUrl> arrayList = this.mXv.f;
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
                                if (this.mQI == null || !this.mQI.mTK.mInPKMode || h.isEmpty(this.mQI.b) || this.mVk == null || !this.mQI.b.equals(this.mVk.mRoomID)) {
                                    View inflate2 = LayoutInflater.from(this.mXw).inflate(a.h.definition_item_audio_show, (ViewGroup) null, false);
                                    ((TextView) inflate2.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                    RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(a.f.rg_defi);
                                    radioGroup.setTag(playUrl);
                                    PlayUrl dBv = this.mXv.dBv();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= playUrl.mUrlDetails.size()) {
                                            break;
                                        }
                                        final UrlDetails urlDetails = playUrl.mUrlDetails.get(i5);
                                        if (!h.isEmpty(urlDetails.mDefinitionName) && !h.isEmpty(urlDetails.mUrl)) {
                                            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.mXw).inflate(a.h.definition_item_audio_item_show, (ViewGroup) null, false);
                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXw, 103.0f), -1);
                                            if (i5 != playUrl.mUrlDetails.size() - 1) {
                                                layoutParams.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, 5.0f);
                                            }
                                            int identifier = this.mXw.getResources().getIdentifier("radiobutton_" + urlDetails.mDefinitionType, "id", this.mXw.getPackageName());
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
                                                if (dBv != null && dBv.mSelectedUrl.equals(urlDetails.mUrl)) {
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
                                if (this.mXw.getResources().getConfiguration().orientation == 1) {
                                    i3 = a.h.definition_item_show;
                                }
                                View inflate3 = LayoutInflater.from(this.mXw).inflate(i3, (ViewGroup) null, false);
                                ((TextView) inflate3.findViewById(a.f.tv_name)).setText(playUrl.mName);
                                RadioGroup radioGroup2 = (RadioGroup) inflate3.findViewById(a.f.rg_defi);
                                radioGroup2.setTag(playUrl);
                                PlayUrl dBv2 = this.mXv.dBv();
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= playUrl.mUrlDetails.size()) {
                                        break;
                                    }
                                    final UrlDetails urlDetails2 = playUrl.mUrlDetails.get(i7);
                                    if (!h.isEmpty(urlDetails2.mDefinitionName) && !h.isEmpty(urlDetails2.mUrl)) {
                                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(this.mXw).inflate(a.h.definition_item_item_show, (ViewGroup) null, false);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(this.mXw, 40.0f), -1);
                                        if (i7 != playUrl.mUrlDetails.size() - 1) {
                                            layoutParams2.rightMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, 5.0f);
                                        }
                                        int identifier2 = this.mXw.getResources().getIdentifier("radiobutton_" + urlDetails2.mDefinitionType, "id", this.mXw.getPackageName());
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
                                            if (dBv2 != null && dBv2.mSelectedUrl.equals(urlDetails2.mUrl)) {
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
                        c.this.dCg();
                        c.this.mXP.dismiss();
                    }
                }
            });
            this.mXP = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 150.0f), -2);
            this.mXP.setFocusable(true);
            this.mXP.setOutsideTouchable(true);
            this.mXP.setBackgroundDrawable(tv.chushou.widget.a.c.getDrawable(a.e.bg_popup_face_show_more));
            this.mXP.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.kascend.chushou.player.e.c.17
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.mXP = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCg() {
        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
            if (this.mUQ == null) {
                this.mUQ = new f(getActivity());
            }
            this.mUQ.a(this.mXv.dBu().mRoominfo, this.ax);
            if (!this.mUQ.isShowing()) {
                this.mUQ.show();
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean b(MotionEvent motionEvent) {
        if (this.mVK) {
            return false;
        }
        if (this.mVJ == 3) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mWE = motionEvent.getX();
                    this.mWF = motionEvent.getY();
                    return false;
                case 1:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = x - this.mWE;
                    if (Math.abs(f) > Math.abs(y - this.mWF) && Math.abs(f) > q && f > 0.0f) {
                        dCy();
                        return true;
                    }
                    this.mWE = 0.0f;
                    this.mWF = 0.0f;
                    return false;
                default:
                    return false;
            }
        } else if (motionEvent.getAction() == 0) {
            if (this.mWk != null && this.mWk.getVisibility() == 0 && b(motionEvent, this.mWk)) {
                this.mWk.setVisibility(8);
                tv.chushou.zues.widget.kpswitch.b.d.dK(this.mWj);
                return true;
            } else if (this.mVF && this.mWk != null && this.mWk.getVisibility() == 8 && g(this.mYb.b, motionEvent)) {
                dCc();
                return true;
            } else if (this.mUR != null && this.mUR.b() && g(this.mUR, motionEvent)) {
                this.mUR.a();
                return true;
            } else if (this.mUH != null && this.mUH.b() && g(this.mUH, motionEvent)) {
                this.mUH.a();
                return true;
            } else if (b(motionEvent, this.mUz)) {
                return cWA();
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
            if (this.mYm != null && this.mYm.a(i, keyEvent)) {
                return true;
            }
            if ((this.mUR != null && this.mUR.onKeyDown(i, keyEvent)) || dBQ()) {
                return true;
            }
            if (this.mVJ == 3) {
                this.mVJ = 1;
                dCy();
                return true;
            } else if (this.mUH != null && this.mUH.onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return super.a(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z) {
        if (z) {
            if (this.mUA != null && this.mUv != null && this.mUz != null) {
                tv.chushou.zues.widget.kpswitch.b.d.dJ(this.mUA);
                this.mUv.setVisibility(8);
                this.mUz.setVisibility(0);
            }
        } else if (this.mUv != null && this.mUz != null) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
            this.mUv.setVisibility(0);
            this.mUz.setVisibility(8);
        }
    }

    public boolean cWA() {
        boolean z;
        b(this.mTW, 12);
        boolean z2 = false;
        if (this.mRI != null && this.mRI.getVisibility() == 0) {
            this.mRI.setVisibility(8);
            this.mRJ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mRK) {
            tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard((Activity) this.mXw);
            this.mRJ.setImageResource(a.e.cs_emoji_normal);
            z2 = true;
        }
        if (this.mUz == null || this.mUz.getVisibility() != 0) {
            z = z2;
        } else {
            if (this.mVc) {
                dCD();
            }
            this.mUz.setVisibility(8);
            z = true;
        }
        RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 100L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.18
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mUv != null) {
                    c.this.mUv.setVisibility(0);
                }
            }
        });
        return z;
    }

    public boolean dBQ() {
        if (cWA()) {
            return true;
        }
        if (this.mXV != null && this.mXV.isShowing()) {
            this.mXV.dismiss();
            return true;
        } else if (this.mYs != null && this.mYs.isShowing()) {
            this.mYs.dismiss();
            return true;
        } else if (this.mXP == null || !this.mXP.isShowing()) {
            return dCc() || dBS() || dCb() || dBR();
        } else {
            this.mXP.dismiss();
            return true;
        }
    }

    public boolean dBR() {
        if (this.mYf == null || !this.mYf.isShown()) {
            return false;
        }
        this.mYf.d();
        return true;
    }

    public boolean dBS() {
        if (this.mVH == null || !this.mVH.isShown()) {
            return false;
        }
        this.mVH.a();
        return true;
    }

    public boolean dCb() {
        if (this.mUR == null || !this.mUR.b()) {
            return false;
        }
        this.mUR.a();
        return true;
    }

    @Subscribe
    public void onMicStatusClick(com.kascend.chushou.b.a.a.a aVar) {
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (this.mXw != null && !((Activity) this.mXw).isFinishing() && pVar != null) {
            this.mVs = pVar.a;
            u(true);
        }
    }

    @Subscribe
    public void onSubscribeEvent(m mVar) {
        if (!dCE() && this.mVk != null && mVar.a(this.mVk.mCreatorUID, null)) {
            this.mVk.mIsSubscribed = mVar.c;
            dBL();
        }
    }

    public boolean dCc() {
        if (!this.mVF || this.mYb == null) {
            return false;
        }
        if (this.mYb != null) {
            this.mYb.e();
        }
        if (this.mWj != null) {
            this.mWj.setText("");
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
        if (!dCE() && parserRet != null && isAdded()) {
            a(parserRet);
            if (parserRet.mData3 != null) {
                SparseArray sparseArray = parserRet.mData3;
                if (sparseArray.get(1) != null && (sparseArray.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray.get(1);
                    if (!h.isEmpty(bangInfo.mRoomH5Data) && this.mVO != null) {
                        this.mVO.a(bangInfo.mRoomH5Data);
                    }
                }
                if (sparseArray.get(3) != null && (sparseArray.get(3) instanceof MicStatus)) {
                    if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                        this.mXv.dBu().mMicStatus = (MicStatus) sparseArray.get(3);
                        if (!this.mXv.dBu().mMicStatus.onMic) {
                            if (this.mUp != null) {
                                this.mUp.setVisibility(8);
                            }
                            if (this.mVH != null && this.mVH.isShown()) {
                                this.mVH.a();
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
                        if (this.mXv.dBu().mMicStatus.micType == 1) {
                            ArrayList<MicMemberInfo> arrayList2 = null;
                            if (sparseArray.get(18) != null && (sparseArray.get(18) instanceof ArrayList)) {
                                arrayList2 = (ArrayList) sparseArray.get(18);
                            }
                            if (this.mVk != null && !h.isEmpty(this.mVk.mCreatorUID)) {
                                i(arrayList2, this.mVk.mCreatorUID);
                            }
                            if (getActivity() instanceof VideoPlayer) {
                                ((VideoPlayer) getActivity()).a(!this.F);
                            }
                        } else if (this.mXv.dBu().mMicStatus.onMic) {
                            if (this.mXv.dBu().mMicStatus != null && !h.isEmpty(this.mXv.dBu().mMicStatus.micRoomId) && !this.mXv.dBu().mMicStatus.micRoomId.equals("0")) {
                                this.G = this.mXv.dBu().mMicStatus.micRoomId;
                            }
                            this.mXv.dBu().mFanItems.clear();
                            if (sparseArray.get(4) != null && (sparseArray.get(4) instanceof ArrayList)) {
                                this.mXv.dBu().mFanItems.addAll((ArrayList) sparseArray.get(4));
                            }
                            String str3 = null;
                            boolean z4 = false;
                            if (LoginManager.Instance().getUserInfo() != null) {
                                str3 = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                                z4 = j(this.mXv.dBu().mFanItems, str3);
                            }
                            this.F = z4;
                            a(this.mXv.dBu().mMicStatus, str3, z4);
                            if (this.mVH != null && this.mVH.getVisibility() == 0) {
                                this.mVH.a(this.mXv.dBu().mFanItems, this.mXv.dBu().mMicStatus, str3, z4, this.mXv.dBu().mRoominfo.mCreatorUID);
                            }
                        } else {
                            if (this.mUp != null) {
                                this.mUp.setVisibility(8);
                            }
                            if (this.mVH != null && this.mVH.isShown()) {
                                this.mVH.a();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (sparseArray.get(10) != null && (sparseArray.get(10) instanceof OnlineVip)) {
                    OnlineVip onlineVip = (OnlineVip) sparseArray.get(10);
                    if ((this.mVg != onlineVip.mCount || (this.mUm != null && this.mUm.getVisibility() == 8)) && onlineVip.mCount >= 0) {
                        this.mVg = onlineVip.mCount;
                        this.mUn = onlineVip.mCount;
                        dCk();
                    }
                    if (onlineVip.mOnlineVipItems != null) {
                        if (this.mVE.size() == onlineVip.mOnlineVipItems.size()) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= this.mVE.size()) {
                                    z3 = false;
                                    break;
                                } else if (this.mVE.get(i2).compare(onlineVip.mOnlineVipItems.get(i2))) {
                                    i = i2 + 1;
                                } else {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3 || System.currentTimeMillis() - this.mWa <= 5000) {
                                z2 = false;
                            } else {
                                this.mWa = System.currentTimeMillis();
                                z2 = true;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            this.mVE.clear();
                            if (!h.isEmpty(onlineVip.mOnlineVipItems)) {
                                this.mVE.addAll(onlineVip.mOnlineVipItems);
                            }
                            dBM();
                        }
                    }
                }
                if (sparseArray.get(13) != null && (sparseArray.get(13) instanceof KaraokeBean) && this.mWb != null) {
                    if (this.mVk == null) {
                        str = "";
                        str2 = "male";
                    } else {
                        str = this.mVk.mCreatorAvatar;
                        str2 = this.mVk.mCreatorGender;
                    }
                    this.mWb.a((KaraokeBean) sparseArray.get(13), str, str2);
                }
                if (sparseArray.get(14) != null && (sparseArray.get(14) instanceof List) && this.mQI != null && this.mQI.mTK != null) {
                    List list = (List) sparseArray.get(14);
                    if (!h.isEmpty(list)) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= list.size()) {
                                break;
                            }
                            PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) list.get(i4);
                            if (pkNotifyInfo != null && ((pkNotifyInfo.mAction == 6 || (!h.isEmpty(this.u) && this.u.equals(pkNotifyInfo.mPkId))) && (pkNotifyInfo.mAction != 3 || this.mQI.mTK.mAction == 7))) {
                                if (pkNotifyInfo.mAction == 6) {
                                    if (this.mQF != null) {
                                        this.mQF.a(true);
                                    }
                                    this.u = pkNotifyInfo.mPkId;
                                    this.mQI.mTK.mInPKMode = true;
                                    this.mQI.mTK.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQI.mTK.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQI.mTK.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQI.mTK.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQI.mTK.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQI.mTK.mMaxFreeDuration = pkNotifyInfo.mMaxFreeDuration;
                                    this.mQI.mTK.maxPrepareDuration = pkNotifyInfo.maxPrepareDuration;
                                    this.mQI.mTK.mMode = pkNotifyInfo.mMode;
                                    this.mQI.mTK.liveStyle = pkNotifyInfo.liveStyle;
                                    if (this.mQJ != null) {
                                        this.mQJ.g(true, this.mQI.mTK.maxPrepareDuration);
                                    }
                                    if (com.kascend.chushou.d.h.dAK().a) {
                                        if (!com.kascend.chushou.b.dAD().e) {
                                            com.kascend.chushou.b.dAD().e = true;
                                            tv.chushou.zues.utils.g.M(this.mXw, a.i.str_pk_toast);
                                        }
                                        com.kascend.chushou.d.h.dAK().a(this.mXw, false);
                                        ak();
                                    }
                                } else if (pkNotifyInfo.mAction == 7) {
                                    this.mQI.mTK.mAction = 7;
                                    this.mQI.mTK.mPkRoomId = pkNotifyInfo.mPkRoomId;
                                    this.mQI.mTK.mPkUid = pkNotifyInfo.mPkUid;
                                    this.mQI.mTK.mPkUserNickname = pkNotifyInfo.mPkUserNickname;
                                    this.mQI.mTK.mPkUserAvatar = pkNotifyInfo.mPkUserAvatar;
                                    this.mQI.mTK.mMaxPKDuration = pkNotifyInfo.mMaxPKDuration;
                                    this.mQI.mTK.destinyInfo = pkNotifyInfo.destinyInfo;
                                    if (this.mQI.mTK.mMode == 2) {
                                        dBZ();
                                    } else {
                                        dBD();
                                    }
                                    if (this.mQJ != null) {
                                        this.mQJ.g(false, 0L);
                                        this.mQJ.b(this.mQI.mTK, true);
                                        this.mQJ.a(this.mWd + tv.chushou.zues.utils.a.dip2px(this.mXw, 52.0f), this.mXA);
                                        this.mQJ.a(this.mQI.mTK.mMode, (String) null);
                                    }
                                } else if (pkNotifyInfo.mAction == 2) {
                                    this.w = -1;
                                    if (this.mQF != null) {
                                        this.mQF.a(false);
                                    }
                                    this.mQI.mTK.mInPKMode = false;
                                    this.mQI.mTK.mAction = 2;
                                    dBD();
                                    dBZ();
                                    if (this.mQJ != null) {
                                        this.mQJ.c();
                                    }
                                    this.mQI.b = null;
                                    this.mQI.mTK = new PkNotifyInfo();
                                    this.u = null;
                                } else if (pkNotifyInfo.mAction == 8) {
                                    this.mQI.mTK.copySpecial(pkNotifyInfo);
                                    if (!h.isEmpty(this.mQI.mTK.mPkUpdateInfo.specialMomentList)) {
                                        int i5 = 0;
                                        while (true) {
                                            int i6 = i5;
                                            if (i6 >= this.mQI.mTK.mPkUpdateInfo.specialMomentList.size()) {
                                                break;
                                            }
                                            if (this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i6).type == 1) {
                                                if (this.mVk != null && !h.isEmpty(this.mVk.mRoomID) && this.mVk.mRoomID.equals(this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i6).roomId)) {
                                                    this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = true;
                                                } else {
                                                    this.mQI.mTK.mPkUpdateInfo.specialMomentList.get(i6).mineFirstblood = false;
                                                }
                                            }
                                            i5 = i6 + 1;
                                        }
                                    }
                                    if (this.mQJ != null) {
                                        this.mQJ.a(this.mQI.mTK, false);
                                    }
                                } else if (pkNotifyInfo.mAction == 3) {
                                    this.mQI.mTK.copyUpdate(pkNotifyInfo);
                                    if (this.mQJ != null) {
                                        this.mQJ.a(this.mQI.mTK);
                                    }
                                } else if (pkNotifyInfo.mAction == 4) {
                                    if (this.w != 5) {
                                        this.mQI.mTK.copyStop(pkNotifyInfo);
                                        if (this.mQJ != null) {
                                            this.mQJ.w(this.mQI.mTK.mMaxFreeDuration, this.mQI.mTK.mMode);
                                        }
                                    }
                                } else if (pkNotifyInfo.mAction == 5 && this.w != 5) {
                                    this.mQI.mTK.copyResult(pkNotifyInfo);
                                    if (!this.mVC && this.mQJ != null) {
                                        int i7 = 1;
                                        if (this.mQI.mTK.destinyInfo != null && this.mQI.mTK.destinyInfo.destinyId != 0) {
                                            i7 = 2;
                                        }
                                        this.mQJ.a(h.parseInt(this.mQI.mTK.mResult), h.parseLong(this.mQI.mTK.mvpUid), this.mQI.mTK.mvpAvatar, this.mQI.mTK.mvpNickname, this.mQI.mTK.mMaxFreeDuration, this.mQI.mTK.mMode, i7);
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                if (sparseArray.get(17) != null) {
                    if (this.mQL != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) sparseArray.get(17);
                        this.mQL.uid = cycleLiveRoomInfo.uid;
                        this.mQL.remainTime = cycleLiveRoomInfo.remainTime;
                        this.mQL.roomId = cycleLiveRoomInfo.roomId;
                        this.mQL.avatar = cycleLiveRoomInfo.avatar;
                        this.mQL.nickname = cycleLiveRoomInfo.nickname;
                        s(false);
                        if (this.mXw != null && (this.mXw instanceof VideoPlayer)) {
                            ((VideoPlayer) this.mXw).d();
                        }
                    } else {
                        ((VideoPlayer) this.mXw).u();
                    }
                }
            }
            if (parserRet.mData == null) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) parserRet.mData;
            }
            if (arrayList != null && arrayList.size() != 0) {
                if (LoginManager.Instance().islogined() && this.mXv != null && this.mXv.l()) {
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
                        if (!h.isEmpty(com.kascend.chushou.d.h.dAK().b()) && "1".equals(next2.mType) && com.kascend.chushou.d.h.dAK().b().equals(next2.mUserID)) {
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

    public void dCk() {
        if (this.mUm != null) {
            if (this.mQI == null || this.mQI.mTK == null || !this.mQI.mTK.mInPKMode) {
                if (this.mUn > 0) {
                    this.mUm.setVisibility(0);
                    this.mUm.setText(String.format(this.mXw.getString(a.i.str_show_online_count), tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mUn))));
                    this.mUr.setVisibility(0);
                    return;
                }
                this.mUm.setVisibility(8);
            }
        }
    }

    public void a(MicStatus micStatus, String str, boolean z) {
        if (micStatus.onlineCount > 0) {
            this.mUp.setVisibility(0);
            if (this.mUq != null) {
                this.mUq.a(str, z, micStatus, this.mXv.dBu().mRoominfo.mCreatorUID);
                return;
            }
            return;
        }
        this.mUp.setVisibility(8);
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
    public void dCh() {
        int childCount = this.mVm.getChildCount();
        int itemCount = this.mVm.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mVm);
        if (f + childCount >= itemCount) {
            this.mVt = true;
            if (this.mVu != null) {
                this.mVu.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                u(true);
            }
        }
    }

    public void dCq() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.mVn.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.mVn.add(1, chatInfo2);
    }

    private void u(boolean z) {
        if (this.mVn == null) {
            this.mVn = new ArrayList<>();
        }
        while (2 < this.mVn.size()) {
            this.mVn.remove(2);
        }
        ArrayList<ChatInfo> a2 = a(this.mVp);
        if (a2 == null) {
            v(false);
            return;
        }
        this.mVn.addAll(a2);
        int size = this.mVn.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.mVn.size(); i++) {
                this.mVn.remove(2);
            }
        }
        v(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.mVq == null) {
            this.mVq = new ArrayList<>();
        }
        this.mVq.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mVs != null && this.mVs.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.mVs.contains("2"))) {
                        this.mVq.add(next);
                    } else if (!this.mVs.contains(next.mType)) {
                        this.mVq.add(next);
                    }
                }
                return this.mVq;
            }
            return arrayList;
        }
        return null;
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.mVn == null) {
                    this.mVn = new ArrayList<>(arrayList);
                    dCq();
                    v(z2);
                    return;
                }
                if (this.mVp == null) {
                    this.mVp = new ArrayList<>();
                }
                this.mVp.addAll(arrayList);
                int size = this.mVp.size();
                if (size > 500) {
                    for (int i = 0; i < size - 500 && i < this.mVp.size(); i++) {
                        this.mVp.remove(0);
                    }
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.mVn.size();
                if (a2 != null) {
                    this.mVn.addAll(a2);
                }
                int size3 = this.mVn.size();
                if (!this.mVt && this.mVu != null) {
                    this.mVu.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
                }
                if (size3 > 200) {
                    int i2 = 0;
                    for (int i3 = 2; i3 < size3 - 100 && i3 < this.mVn.size(); i3++) {
                        this.mVn.remove(2);
                        i2++;
                    }
                    a(z2, 2, 1, i2);
                    return;
                }
                return;
            }
            if (this.mVn == null) {
                this.mVn = new ArrayList<>(arrayList);
                dCq();
            } else {
                if (this.mVp == null) {
                    this.mVp = new ArrayList<>();
                }
                this.mVp.clear();
                this.mVp.addAll(arrayList);
                this.mVn.clear();
                dCq();
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.mVn.addAll(a3);
                }
            }
            v(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.ah) {
            if (this.mVr != null) {
                this.mVr.a(this.mVn.size());
                if (i == 1) {
                    this.mVr.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mVr.notifyItemRangeRemoved(i2, i3);
                    this.mVr.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mVr.notifyDataSetChanged();
                }
            }
            if (z || this.mVt) {
                this.mVt = true;
                if (this.mVu != null) {
                    this.mVu.setVisibility(8);
                }
                if (z) {
                    this.mVj.scrollToPosition(this.mVn.size() - 1);
                } else {
                    this.mVj.smoothScrollToPosition(this.mVn.size() - 1);
                }
            }
        }
    }

    private void v(boolean z) {
        if (!this.ah) {
            if (this.mVr != null) {
                this.mVr.a(this.mVn.size());
                this.mVr.notifyDataSetChanged();
            }
            if (z || this.mVt) {
                this.mVt = true;
                if (this.mVu != null) {
                    this.mVu.setVisibility(8);
                }
                if (z) {
                    this.mVj.scrollToPosition(this.mVn.size() - 1);
                } else {
                    this.mVj.smoothScrollToPosition(this.mVn.size() - 1);
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void s() {
        com.kascend.chushou.player.e.a dBf;
        RoomToast roomToast;
        this.p = false;
        if (this.mXv != null && this.mXv.f != null) {
            int i = 0;
            while (true) {
                if (i >= this.mXv.f.size()) {
                    break;
                } else if (!"2".equals(this.mXv.f.get(i).mType)) {
                    i++;
                } else {
                    this.p = true;
                    break;
                }
            }
        }
        if (!i()) {
            dCu();
            return;
        }
        if (this.mQX != null) {
            this.mQX.setVisibility(0);
        }
        if (this.mUb != null) {
            this.mUb.setVisibility(0);
        }
        if (this.mXv != null) {
            this.mVk = this.mXv.dBw();
            this.mVl = this.mXv.dBu();
            if (com.kascend.chushou.b.dAD().c != null && this.mVr != null) {
                this.mVr.a(com.kascend.chushou.b.dAD().c);
                this.mVr.notifyDataSetChanged();
            }
            FullRoomInfo dBu = this.mXv.dBu();
            if (dBu != null) {
                if (!h.isEmpty(dBu.mRoomToastList)) {
                    Iterator<RoomToast> it = dBu.mRoomToastList.iterator();
                    while (it.hasNext()) {
                        roomToast = it.next();
                        if (roomToast != null && roomToast.mType == RoomToast.TYPE_ROOM_GIFT) {
                            break;
                        }
                    }
                }
                roomToast = null;
                if (roomToast != null && roomToast.mToastContent != null && !roomToast.mToastContent.equals(com.kascend.chushou.d.h.dAK().j())) {
                    a(roomToast);
                }
            }
            if (this.mVk != null) {
                dCz();
            }
            if (this.mVk != null && !this.mVk.mIsSubscribed) {
                RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.19
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.mVk == null || !c.this.mVk.mIsSubscribed) {
                            c.this.a(true);
                        }
                    }
                });
            }
            if (LoginManager.Instance().islogined() && this.mXv != null && this.mXv.l()) {
                d(true);
            }
        }
        if (this.mVk != null && this.mVr != null) {
            if (this.mVn != null) {
                this.mVn.clear();
            } else {
                this.mVn = new ArrayList<>();
            }
            this.mVr.a(this.mVk);
            dCq();
            this.mVr.a(this.mVn.size());
            this.mVr.notifyDataSetChanged();
        }
        dBJ();
        N();
        if (this.mXw != null && (this.mXw instanceof VideoPlayer) && (dBf = ((VideoPlayer) this.mXw).dBf()) != null) {
            tv.chushou.zues.utils.e.d("guohe", "VideoPlayShowFragment.initFragmentAfterApi(): aaa");
            a(dBf.mTK, dBf.b);
        }
        this.mUE.h(this.mVk.mCreatorAvatar, com.kascend.chushou.view.a.a(this.mVk.mCreatorGender), 0, 0);
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    private void a(final RoomToast roomToast) {
        RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 500L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.20
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(roomToast);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void J() {
        RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.21
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(c.this.mUI);
            }
        });
    }

    @Override // com.kascend.chushou.player.e
    public void K() {
    }

    private void dCi() {
        if (this.mVf == null) {
            View inflate = LayoutInflater.from(this.mXw).inflate(a.h.item_popup_room_gift_toast, (ViewGroup) null);
            this.mSq = (TextView) inflate.findViewById(a.f.tv_toast_content);
            this.mVf = new PopupWindow(inflate, tv.chushou.zues.utils.a.dip2px(this.mXw, 160.0f), -2);
            this.mVf.setFocusable(false);
            this.mVf.setOutsideTouchable(false);
            this.mVf.setAnimationStyle(a.j.gift_toast_style);
            this.mVf.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(RoomToast roomToast) {
        if (roomToast != null && !h.isEmpty(roomToast.mToastContent)) {
            com.kascend.chushou.d.h.dAK().c(roomToast.mToastContent);
            if (this.mVf == null) {
                dCi();
            }
            if (this.mSq != null) {
                this.mSq.setText(roomToast.mToastContent);
            }
            if (!this.mVf.isShowing()) {
                if (this.mUI != null) {
                    this.mVf.showAtLocation(this.mUI, 85, 0, this.mXg.findViewById(a.f.rl_bottom_input).getHeight() + tv.chushou.zues.utils.systemBar.b.aB(getActivity()));
                    RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 3300L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.mVf != null) {
                                c.this.mVf.dismiss();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.mVf.dismiss();
        }
    }

    @Override // com.kascend.chushou.player.f
    protected void n(boolean z) {
        if (this.mVW != null) {
            this.mVW.setVisibility(z ? 0 : 8);
        }
        this.mVX = true;
        if (this.mXw instanceof VideoPlayer) {
            ((VideoPlayer) this.mXw).p();
        }
    }

    private void dCu() {
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "showNoLiveView");
        n(false);
        ((VideoPlayer) this.mXw).s();
        dBR();
        dBS();
        if (this.mUt == null) {
            this.mUt = (PlayShowRecommendView) ((ViewStub) this.mXg.findViewById(a.f.view_recommend)).inflate();
        }
        this.mUt.setVisibility(0);
        if (this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null && !h.isEmpty(this.mXv.dBu().mRoominfo.mRoomID)) {
            dCl();
        }
        if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.mYb != null) {
            this.mYb.e();
        }
        if (this.mQX != null) {
            this.mQX.setVisibility(4);
        }
        if (this.mUb != null) {
            this.mUb.setVisibility(8);
        }
        if (this.mYj != null) {
            this.mYj.dOn();
            this.mYj.setVisibility(8);
        }
        wk(false);
        a(false, false);
        if (this.mQF != null) {
            this.mQF.a();
        }
    }

    private void dCl() {
        if (this.mUt != null && this.mUt.getVisibility() == 0) {
            this.mUt.a(this.mXv.dBu().mRoominfo, new PlayShowRecommendView.a() { // from class: com.kascend.chushou.player.e.c.24
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
        if (this.mXw instanceof VideoPlayer) {
            VideoPlayer videoPlayer = (VideoPlayer) this.mXw;
            videoPlayer.c();
            videoPlayer.k();
        }
        z();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void z() {
        super.z();
        if (this.mUR != null && this.mUR.b()) {
            this.mUR.a();
        }
        tv.chushou.zues.utils.e.e("VideoPlayShowFragment", "receive onCompletePlayback mRetryInComplete =" + this.mVG);
        if (this.mXw != null) {
            if (this.mVG || "10004".equals(((VideoPlayer) this.mXw).t)) {
                this.mVG = true;
                if (this.mXv != null) {
                    this.mXv.f = null;
                    if (this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                        this.mXv.dBu().mRoominfo.mGameId = null;
                    }
                }
                dCu();
                return;
            }
            this.mVG = true;
            if (this.mXw != null) {
                ((VideoPlayer) this.mXw).l();
            }
        }
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void A() {
        this.mVG = false;
        if (this.mQX != null) {
            this.mQX.setVisibility(0);
        }
        if (this.mUb != null) {
            this.mUb.setVisibility(0);
        }
        if (this.mUt != null) {
            this.mUt.setVisibility(8);
        }
        if (this.mXq != null) {
            this.mXq.setVisibility(8);
        }
        super.A();
    }

    @Override // com.kascend.chushou.player.f, com.kascend.chushou.player.e
    public void i(boolean z) {
        this.mVG = false;
        if (this.mQX != null) {
            this.mQX.setVisibility(0);
        }
        if (this.mUb != null) {
            this.mUb.setVisibility(0);
        }
        if (this.mUt != null) {
            this.mUt.setVisibility(8);
        }
        if (this.mXq != null) {
            this.mXq.setVisibility(8);
        }
        super.i(z);
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void j() {
        super.j();
        if (this.mUt != null) {
            this.mUt.setVisibility(8);
        }
        if (this.N != null) {
            this.N.setVisibility(0);
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void e(int i) {
        if (!dCE()) {
            if (i()) {
                if (i == 404) {
                    if (this.mXv != null) {
                        this.mXv.f = null;
                        this.mXv.dBu().mRoominfo.mGameId = null;
                    }
                    dCu();
                    return;
                }
                Toast.makeText(this.mXw, a.i.str_getvideosource_failed, 0).show();
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
        if (this.mXv != null && this.mXv.dBv() != null) {
            a(this.mXv.dBv());
        }
        this.p = false;
        if (this.mXv == null || this.mXv.f == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.mXv.f.size()) {
                if (!"2".equals(this.mXv.f.get(i2).mType)) {
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
    public GiftAnimationLayout dBO() {
        if (this.mXg == null) {
            return null;
        }
        return (GiftAnimationLayout) this.mXg.findViewById(a.f.ll_gift_animation);
    }

    @Override // com.kascend.chushou.player.e
    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (iconConfig != null && !h.isEmpty(iconConfig.configs) && this.mUI != null) {
            int size = iconConfig.configs.size();
            this.mUI.removeAllViews();
            if (this.mUK != null) {
                this.mUK.setVisibility(8);
            }
            for (int i = 0; i < size; i++) {
                ConfigDetail configDetail = iconConfig.configs.get(i);
                View inflate = LayoutInflater.from(this.mXw).inflate(a.h.item_videoplayer_bottom, (ViewGroup) this.mUI, false);
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
                            this.mUK.setVisibility(0);
                            this.mUJ.bV(configDetail.mCover, a.e.ic_show_gift_n);
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
                this.mUI.addView(inflate);
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (this.mXw instanceof VideoPlayer) {
            com.kascend.chushou.player.ui.h5.redpacket.a dBa = ((VideoPlayer) this.mXw).dBa();
            if (this.mYm == null) {
                this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYm.setVisibility(0);
            this.mYm.a(2, dBa);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (this.mUM != null && this.mXw != null) {
            this.mUM.b(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mUM != null && this.mXw != null) {
            this.mUM.a(i);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (this.mUM != null) {
            this.mUM.a(j);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (this.mUM != null) {
            this.mUM.a();
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mUL != null) {
            if (this.mXw != null) {
                this.mUL.a(((VideoPlayer) this.mXw).dBa(), false);
            }
            this.mUL.a(i, false);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e
    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mXg != null) {
            Point he = tv.chushou.zues.utils.a.he(this.mXw);
            int i = he.x > he.y ? 1 : 2;
            if (this.mYm == null) {
                this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
            }
            this.mYm.setPlayerViewHelper(this.mXv);
            this.mYm.setVisibility(0);
            this.mYm.a(i, aVar);
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        super.a(config);
        if (this.mUN != null) {
            this.mUN.a(config);
        }
    }

    @Override // com.kascend.chushou.player.g, com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        super.a(bangInfo, str);
        if (this.mUN != null) {
            this.mUN.a(bangInfo, str);
        }
        if (this.mRm != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mRm.setText(this.mXw.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mRm.setText(this.mXw.getString(a.i.str_contribute_tittle));
            } else {
                this.mRm.setText(Html.fromHtml(this.mXw.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
        if (this.mUo != null) {
            if (h.isEmpty(bangInfo.mReceivePoint)) {
                this.mUo.setText(this.mXw.getString(a.i.str_contribute_tittle));
            } else if (bangInfo.mReceivePoint.equals("0")) {
                this.mUo.setText(this.mXw.getString(a.i.str_contribute_tittle));
            } else {
                this.mUo.setText(Html.fromHtml(this.mXw.getString(a.i.str_playshow_contribute, tv.chushou.zues.utils.b.formatNumber(bangInfo.mReceivePoint))));
            }
        }
    }

    @Override // com.kascend.chushou.player.e, com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mUN != null) {
            this.mUN.a(j, bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void L() {
        if (this.mXv != null && !h.isEmpty(this.mXv.mQq)) {
            this.mVM = this.mXv.mQq.get(0);
            if (this.mWe != null) {
                this.mWe.setVisibility(0);
                this.mWe.a(this.mVM.mCover, 0, 0, 0, 1);
                if (this.mWf != null) {
                    if (this.mVM.mShowClose) {
                        this.mWf.setVisibility(0);
                    } else {
                        this.mWf.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(List<ListItem> list) {
        if (this.mUN != null) {
            this.mUN.b(list);
        }
    }

    @Override // com.kascend.chushou.player.d
    public void a(ListItem listItem) {
        if (listItem != null && this.mXg != null) {
            f(listItem.mName, listItem.mUrl);
        }
    }

    @Subscribe
    public void onKeyboardEvent(com.kascend.chushou.b.a.a.g gVar) {
        if (gVar.b == 1 && this.mRI != null) {
            this.mRI.setPanelEnabled(gVar.a);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!dCE() && !this.mVC) {
            if (iVar.a == 52) {
                if (this.mVr != null) {
                    this.mVr.a(com.kascend.chushou.b.dAD().c);
                    this.mVr.notifyDataSetChanged();
                }
            } else if (iVar.a == 50) {
                if (!this.mVC && (iVar.b instanceof ListItem)) {
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
        RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 200L, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.26
            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.dCE()) {
                    c.this.t(true);
                    if (!h.isEmpty(userCardInfo.getNickname()) && c.this.mUA != null) {
                        c.this.a(userCardInfo.getUid(), userCardInfo.getNickname(), c.this.mUA);
                    }
                }
            }
        });
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!dCE() && !this.mVC) {
            if (bVar.a == 1) {
                p(false);
                com.kascend.chushou.toolkit.a.c.a(this.mXw, "能量_num", "竖屏", new Object[0]);
            } else if (bVar.a == 2) {
                if (bVar.b instanceof ListItem) {
                    a((ListItem) bVar.b);
                }
            } else if (bVar.a == 6) {
                D();
            } else if (bVar.a == 4) {
                com.kascend.chushou.player.ui.h5.b.b dBb = ((VideoPlayer) this.mXw).dBb();
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(2, dBb);
            } else if (bVar.a == 3) {
                com.kascend.chushou.player.ui.h5.d.a dBc = ((VideoPlayer) this.mXw).dBc();
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(2, dBc);
            } else if (bVar.a == 8) {
                if (this.mVO != null && this.mVO.getVisibility() != 0) {
                    this.mVO.a(a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, this.mVk == null ? "" : this.mVk.mRoomID);
                }
            } else if (bVar.a == 9) {
                if (this.mYm == null) {
                    this.mYm = (H5Container) ((ViewStub) this.mXg.findViewById(a.f.videoplayer_pop_h5_container)).inflate();
                }
                this.mYm.setVisibility(0);
                this.mYm.a(2, bVar.b);
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!dCE() && this.mXv != null && !h.isEmpty(this.mXv.a) && this.mXv.a.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mVO != null && this.mVO.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.mXw, 80.0f);
                }
                if (this.mVN != null && this.mVN.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mVN.getHeight());
                }
                this.mVZ.setTranslationY(-r0);
                return;
            }
            if (this.mVY != null) {
                this.mVY.cancel();
                this.mVY = null;
            }
            int translationY = (int) this.mVZ.getTranslationY();
            if (aVar.a != 1 && 2 != aVar.a) {
                if (3 == aVar.a) {
                    r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.mXw, 80.0f) : 0;
                    if (this.mVN != null && this.mVN.getVisibility() == 0) {
                        r0 = Math.max(r0, this.mVN.getHeight());
                    }
                } else {
                    r0 = aVar.b == 0 ? this.mVN.getHeight() : 0;
                    if (this.mVO != null && this.mVO.getVisibility() == 0) {
                        r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.mXw, 80.0f));
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
        this.mVY = ValueAnimator.ofInt(i, i2);
        this.mVY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.e.c.27
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.dCE() && c.this.mUN != null) {
                    c.this.mVZ.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mVY.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.29
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.mVY = null;
            }
        });
        this.mVY.setInterpolator(new LinearInterpolator());
        this.mVY.setDuration(800L);
        this.mVY.start();
    }

    private boolean dCv() {
        if (this.mVJ == 1) {
            this.mVJ = 2;
            wg(true);
            return true;
        } else if (this.mVJ == 3) {
            dCy();
            return true;
        } else {
            return false;
        }
    }

    private boolean dCw() {
        if (this.mVJ == 1) {
            return dCx();
        }
        if (this.mVJ == 2) {
            this.mVJ = 1;
            wg(false);
            return true;
        }
        return false;
    }

    private boolean dCx() {
        if (this.mVK || this.mXv == null || this.mXv.dBw() == null) {
            return false;
        }
        if (this.mWG != null) {
            this.mWG.a(true);
        }
        this.mVJ = 3;
        this.mVK = true;
        dCz();
        this.mTY.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_left_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_right_anim);
        loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.30
            @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                c.this.mVK = false;
                c.this.mUa.setVisibility(8);
            }
        });
        this.mUa.startAnimation(loadAnimation);
        this.mTY.startAnimation(loadAnimation2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCy() {
        if (!this.mVK) {
            if (this.mWG != null) {
                this.mWG.a(false);
            }
            this.mVJ = 1;
            this.mVK = true;
            dCz();
            this.mUa.setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_in_left_anim);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.slide_out_right_anim);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.31
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.mVK = false;
                    c.this.mTY.setVisibility(8);
                }
            });
            this.mUa.startAnimation(loadAnimation);
            this.mTY.startAnimation(loadAnimation2);
        }
    }

    private void dCz() {
        if (this.mXg != null) {
            if (this.mTY == null) {
                this.mTY = this.mXg.findViewById(a.f.user_space_container);
            }
            if (this.mUa == null) {
                this.mUa = this.mXg.findViewById(a.f.video_container);
            }
            if (this.mTZ == null) {
                this.mTZ = com.kascend.chushou.view.user.b.b(null, this.mXv.a, false, this.mXv.h);
                this.mTZ.a(new com.kascend.chushou.toolkit.c() { // from class: com.kascend.chushou.player.e.c.32
                    @Override // com.kascend.chushou.toolkit.c
                    public boolean a(View view) {
                        int id = view.getId();
                        if (id == a.f.back_icon) {
                            c.this.dCy();
                            return true;
                        } else if (id == a.f.tv_live_status) {
                            c.this.dCy();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
                getChildFragmentManager().beginTransaction().add(a.f.user_space_container, this.mTZ).commitAllowingStateLoss();
            }
        }
    }

    private void wg(boolean z) {
        Animation loadAnimation;
        if (this.mUb != null) {
            this.mUb.setVisibility(z ? 8 : 0);
        }
        if (this.mVh != null) {
            this.mVK = true;
            if (z) {
                loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.play_show_slide_out_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.33
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.mVh.setVisibility(8);
                        c.this.mVK = false;
                    }
                });
            } else {
                this.mVK = true;
                loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.play_show_slide_in_right_anim);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.35
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        c.this.mVh.setVisibility(0);
                        c.this.mVK = false;
                    }
                });
            }
            this.mVh.startAnimation(loadAnimation);
        }
        dBQ();
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(getActivity());
        this.mUu.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void T() {
        if ("4".equals(this.ax)) {
            if (this.mUC != null) {
                this.mUC.setVisibility(0);
            }
            if (this.mUD != null) {
                this.mUD.a();
                return;
            }
            return;
        }
        if (this.mUF != null) {
            this.mUF.setVisibility(0);
        }
        if (this.mUG != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.mUG.getDrawable();
            animationDrawable.setOneShot(false);
            animationDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.player.f
    public void U() {
        if (this.mUF != null) {
            this.mUF.setVisibility(8);
        }
        if (this.mUG != null) {
            this.mUG.clearAnimation();
        }
        if (this.mUC != null) {
            this.mUC.setVisibility(8);
        }
        if (this.mUD != null) {
            this.mUD.b();
        }
    }

    private void b(ListItem listItem) {
        if (this.mVh != null && this.mXg != null) {
            if (this.mVO == null) {
                this.mVO = new com.kascend.chushou.player.ui.miniview.a(this.mXw, listItem, new com.kascend.chushou.widget.cswebview.d() { // from class: com.kascend.chushou.player.e.c.36
                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(Object obj) {
                        if (c.this.mVO != null && c.this.mXg != null && c.this.mVO.a()) {
                            ((ViewGroup) c.this.mXg).removeView(c.this.mVO);
                            c.this.mVO = null;
                        }
                    }

                    @Override // com.kascend.chushou.widget.cswebview.d
                    public void a(String str) {
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVO.getLayoutParams();
                layoutParams.addRule(12);
                layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(this.mXw, 52.0f);
                this.mVO.setLayoutParams(layoutParams);
                ((ViewGroup) this.mVh).addView(this.mVO, ((ViewGroup) this.mVh).getChildCount() - 2);
                if (listItem.mAutoDisplay == 0) {
                    this.mVO.setVisibility(8);
                } else {
                    this.mVO.a(a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, this.mXv.a == null ? "" : this.mXv.a);
                }
            } else if (!this.mVO.isShown()) {
                this.mVO.a(a.C0682a.slide_in_bottom_danmu_anim, a.C0682a.slide_out_bottom_danmu_anim, this.mXv.a == null ? "" : this.mXv.a);
            } else {
                return;
            }
            if (listItem.mPackStyle == 1 && this.mVV != null && !h.isEmpty(listItem.mPackIcon)) {
                this.mVV.setVisibility(0);
                this.mVV.setAnim(true);
                this.mVV.a(listItem.mPackIcon, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.nXk, b.C0808b.nXl, 0);
            }
        }
    }

    @Override // com.kascend.chushou.player.d, com.kascend.chushou.player.e
    public void a(boolean z) {
        if (z) {
            if (this.mVv != null && this.mVv.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.37
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dCA();
                    }
                });
                this.mVv.setVisibility(0);
                this.mVv.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.38
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(false);
                    }
                });
            }
        } else if (this.mVv != null && this.mVv.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.39
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mVx != null) {
                        c.this.mVx.removeAllListeners();
                        c.this.mVx.cancel();
                        c.this.mVx = null;
                    }
                    if (c.this.mVv != null) {
                        c.this.mVv.setVisibility(8);
                    }
                }
            });
            this.mVv.startAnimation(loadAnimation2);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void d(boolean z) {
        if (z) {
            if (this.mWc == null) {
                this.mWc = new Runnable() { // from class: com.kascend.chushou.player.e.c.41
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.dCE()) {
                            com.kascend.chushou.toolkit.a.c.a(c.this.mXw, "显示双击666_num", null, new Object[0]);
                            if (c.this.mXv != null) {
                                c.this.mXv.b(false);
                            }
                            c.this.d(false);
                            c.this.wh(true);
                        }
                    }
                };
                if (this.mXx != null) {
                    this.mXx.d(this.mWc, TimeUnit.SECONDS.toMillis(60L));
                }
            }
        } else if (this.mWc != null) {
            this.mXx.removeCallbacks(this.mWc);
            this.mWc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(boolean z) {
        if (z) {
            if (LoginManager.Instance().islogined() && this.mVy != null && this.mVy.getVisibility() != 0) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mXw, a.C0682a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.42
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        c.this.dCB();
                    }
                });
                this.mVy.setVisibility(0);
                this.mVy.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mXf, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.43
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.wh(false);
                    }
                });
            }
        } else if (this.mVy != null && this.mVy.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mXw, a.C0682a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.e.c.44
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c.this.mVA != null) {
                        c.this.mVA.removeAllListeners();
                        c.this.mVA.cancel();
                        c.this.mVA = null;
                    }
                    if (c.this.mVy != null) {
                        c.this.mVy.setVisibility(8);
                    }
                }
            });
            this.mVy.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dCA() {
        if (this.mVv == null || this.mVw == null) {
            return null;
        }
        if (this.mVx != null) {
            this.mVx.removeAllListeners();
            this.mVx.cancel();
            this.mVx = null;
        }
        this.mVw.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mVw, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mVw, 0.0f);
        int measuredWidth = (this.mVv.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mXw, 13.0f) * 2)) - this.mVw.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mVw, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mVw, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mVw, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.46
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mVx != null) {
                    c.this.mVx.removeAllListeners();
                    c.this.mVx.cancel();
                    c.this.mVx = null;
                }
                RxExecutor.postDelayed(c.this.mXf, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dCA();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mVx = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dCB() {
        if (this.mVy == null || this.mVz == null) {
            return null;
        }
        if (this.mVA != null) {
            this.mVA.removeAllListeners();
            this.mVA.cancel();
            this.mVA = null;
        }
        this.mVz.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.mVz, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.mVz, 0.0f);
        int measuredWidth = (this.mVy.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.mXw, 13.0f) * 2)) - this.mVz.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mVz, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mVz, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mVz, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.e.c.47
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (c.this.mVA != null) {
                    c.this.mVA.removeAllListeners();
                    c.this.mVA.cancel();
                    c.this.mVA = null;
                }
                RxExecutor.postDelayed(c.this.mXf, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.e.c.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.dCB();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mVA = animatorSet;
        return animatorSet;
    }

    public void a(a aVar) {
        this.mWG = aVar;
    }

    private void a(final Map<String, String> map) {
        if (this.mQL != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", "83");
            }
            final boolean z = this.mQL.isSubscribe;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.48
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!c.this.dCE()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Oj(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Oj(a.i.subscribe_success);
                            }
                            if (c.this.mQL != null) {
                                c.this.mQL.isSubscribe = !z;
                                c.this.dBK();
                                return;
                            }
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!c.this.dCE()) {
                        if (h.isEmpty(str)) {
                            str = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dAG().a(bVar, (String) null, this.mQL.uid, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mQL.nickname, new b.a() { // from class: com.kascend.chushou.player.e.c.49
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dAG().b(bVar, (String) null, c.this.mQL.uid, tv.chushou.zues.utils.d.toJson(map));
                    }
                });
            }
        }
    }

    private void b(final Map<String, String> map) {
        String str;
        if (this.mXv != null && this.mVk != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", UgcUBCUtils.LAND_PAGE_PV);
            }
            if (h.isEmpty(this.mXv.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mXv.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            final boolean z = this.mVk.mIsSubscribed;
            final com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.e.c.50
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!c.this.dCE()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            if (z) {
                                tv.chushou.zues.utils.g.Oj(a.i.unsubscribe_success);
                            } else {
                                tv.chushou.zues.utils.g.Oj(a.i.subscribe_success);
                            }
                            c.this.mVk.mIsSubscribed = !z;
                            c.this.dBL();
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!c.this.dCE()) {
                        if (h.isEmpty(str2)) {
                            str2 = tv.chushou.widget.a.c.getString(a.i.subscribe_failed);
                        }
                        tv.chushou.zues.utils.g.u(str2);
                    }
                }
            };
            if (!z) {
                com.kascend.chushou.c.c.dAG().a(bVar, (String) null, this.mVk.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
            } else {
                com.kascend.chushou.d.e.a(getActivity(), this.mVk.mCreatorNickname, new b.a() { // from class: com.kascend.chushou.player.e.c.51
                    @Override // tv.chushou.zues.widget.sweetalert.b.a
                    public void onClick(tv.chushou.zues.widget.sweetalert.b bVar2) {
                        bVar2.dismiss();
                        com.kascend.chushou.c.c.dAG().b(bVar, (String) null, c.this.mVk.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
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
        if (this.mTJ != null) {
            int width = this.mTJ.getWidth();
            int height = this.mTJ.getHeight();
            if (this.mVT != width || this.mVU != height) {
                y();
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    protected void ak() {
        ((VideoPlayer) this.mXw).a(true, (Uri) null, false);
    }

    private void a(ConfigDetail configDetail) {
        if (this.mXg != null) {
            if (this.mUH == null) {
                this.mUH = (InteractionView) ((ViewStub) this.mXg.findViewById(a.f.view_interaction)).inflate();
                this.mUH.setInterface(new InteractionView.a() { // from class: com.kascend.chushou.player.e.c.53
                    @Override // com.kascend.chushou.player.ui.InteractionView.a
                    public void b(ConfigDetail configDetail2) {
                        c.this.b(configDetail2);
                        c.this.mUH.a();
                    }
                });
            }
            if (this.mUH != null) {
                this.mUH.b(configDetail);
                this.mUH.c();
                this.mUH.a(true);
            }
        }
    }

    @Override // com.kascend.chushou.player.g
    public void b(ConfigDetail configDetail) {
        if (configDetail.mType.equals("94")) {
            if (!tv.chushou.zues.utils.a.dOY()) {
                tv.chushou.zues.utils.g.M(this.mXw, a.i.s_no_available_network);
            } else if (com.kascend.chushou.d.e.c(this.mXw, null) && (this.mXw instanceof VideoPlayer)) {
                com.kascend.chushou.player.ui.h5.redpacket.c.c(configDetail).show(getChildFragmentManager(), "redpacket");
            }
        } else if (configDetail.mType.equals("98")) {
            if (com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXv != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXw, configDetail.mName, "房间", new Object[0]);
                ListItem listItem = new ListItem();
                listItem.mUrl = configDetail.mUrl;
                tv.chushou.zues.a.a.post(new com.kascend.chushou.player.ui.button.b(2, listItem));
            }
        } else if (configDetail.mType.equals("99")) {
            if (com.kascend.chushou.d.e.c(this.mXw, com.kascend.chushou.d.e.a("_fromView", Constants.VIA_ACT_TYPE_NINETEEN)) && this.mXv != null) {
                com.kascend.chushou.toolkit.a.c.a(this.mXw, configDetail.mName, "房间", new Object[0]);
                com.kascend.chushou.d.a.a(this.mXw, configDetail.mUrl, this.mXw.getString(a.i.str_prop_title));
            }
        } else if (configDetail.mType.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
            if (com.kascend.chushou.d.e.c(this.mXw, null)) {
                if (!configDetail.mTargetKey.equals("pay")) {
                    if (configDetail.mTargetKey.equals("gift")) {
                        if (this.mVF) {
                            dCc();
                            return;
                        }
                        if (this.mXw.getResources().getDisplayMetrics().density < 2.0f) {
                            b(true, false);
                        } else {
                            b(true, true);
                        }
                        com.kascend.chushou.toolkit.a.c.a(this.mXw, "点击送礼_num", "竖屏", new Object[0]);
                        if (this.mXv != null && this.mXv.dBu() != null && this.mXv.dBu().mRoominfo != null) {
                            com.kascend.chushou.toolkit.a.a.j("type", "4", "_clickPos", "27", "roomId", this.mXv.dBu().mRoominfo.mRoomID);
                            return;
                        }
                        return;
                    } else if (configDetail.mTargetKey.equals("interaction")) {
                        a(configDetail);
                        return;
                    } else if (!configDetail.mTargetKey.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        if (configDetail.mTargetKey.equals("more")) {
                            dz(this.mUI);
                            return;
                        } else {
                            Toast.makeText(this.mXw, a.i.str_getnewversion, 0).show();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                b(com.kascend.chushou.d.e.a("_fromView", Constants.VIA_REPORT_TYPE_START_WAP, "_fromPos", "34"));
            }
        } else {
            Toast.makeText(this.mXw, a.i.str_getnewversion, 0).show();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void a(PkNotifyInfo pkNotifyInfo, String str) {
        if (this.mXw != null && !this.v && !h.isEmpty(str) && this.mVk != null && str.equals(this.mVk.mRoomID) && pkNotifyInfo != null && !h.isEmpty(pkNotifyInfo.mPkId)) {
            this.v = true;
            if (this.mQI == null) {
                this.mQI = new com.kascend.chushou.player.e.a();
            }
            this.mQI.b = str;
            this.mQI.mTK.copy(pkNotifyInfo);
            if (this.mQI.mTK.mAction == 6) {
                if (this.mQF != null) {
                    this.mQF.a(true);
                }
                this.mQI.mTK.mInPKMode = true;
                this.u = this.mQI.mTK.mPkId;
            } else if (this.mQI.mTK.mAction == 7 || (this.mQI.mTK.mMode == 1 && this.mQI.mTK.mAction == 5)) {
                if (this.mQF != null) {
                    this.mQF.a(true);
                }
                this.mQI.mTK.mInPKMode = true;
                if (this.mVR != 42) {
                    this.mWd = ((this.mVS.y - ((this.mVS.x * 16) / 18)) - (tv.chushou.zues.utils.a.dip2px(this.mXw, 158.0f) + this.mVd)) - tv.chushou.zues.utils.systemBar.b.aB(getActivity());
                    dBZ();
                }
                this.u = this.mQI.mTK.mPkId;
                if (this.mQJ != null) {
                    this.mQJ.b(this.mQI.mTK, false);
                    this.mQJ.a(this.mQI.mTK.mMode, (String) null);
                    if (this.mQI.mTK.mAction == 5 && this.mQI.mTK.mPkUpdateInfo != null) {
                        this.w = 5;
                        long j = -1;
                        int parseInt = h.parseInt(this.mQI.mTK.mResult);
                        if (parseInt == 1) {
                            if (!h.isEmpty(this.mQI.mTK.mPkUpdateInfo.rewardList)) {
                                j = h.parseLong(this.mQI.mTK.mPkUpdateInfo.rewardList.get(0).mUserID);
                            }
                        } else if (parseInt == -1 && !h.isEmpty(this.mQI.mTK.mPkUpdateInfo.opponentRewardList)) {
                            j = h.parseLong(this.mQI.mTK.mPkUpdateInfo.opponentRewardList.get(0).mUserID);
                        }
                        this.mQJ.a(this.mQI.mTK);
                        this.mQJ.a(parseInt, this.mQI.mTK.mPkUpdateInfo.remainDuration, j, this.mQI.mTK.mMode, (this.mQI.mTK.destinyInfo == null || this.mQI.mTK.destinyInfo.destinyId == 0) ? 1 : 2);
                    }
                }
                if (this.mQI.mTK.mPkUpdateInfo != null && !h.isEmpty(this.mQI.mTK.mPkUpdateInfo.specialMomentList) && this.mQJ != null) {
                    this.mQJ.a(this.mQI.mTK, true);
                }
                if (this.mQI.mTK.mMode == 2) {
                    dBZ();
                } else {
                    dBD();
                }
            } else {
                this.mQI.mTK.mInPKMode = false;
                if (this.mQI.mTK.mMode == 2) {
                    dBZ();
                } else {
                    dBD();
                }
            }
        }
    }

    public void dBD() {
        dBX();
        dBW();
    }

    @Override // com.kascend.chushou.player.e
    public void M() {
        super.M();
        if (this.mVa != null && this.mXv != null && this.mXv.mQs != null) {
            this.mVa.setText(tv.chushou.zues.utils.b.Oi(this.mXv.mQs.count));
            this.mVa.setVisibility(0);
            if (this.mXv.mQs.count < 1) {
                dCD();
            }
            if (this.mUT != null) {
                this.mUT.setText(this.mXv.mQs.primaryName);
            }
            if (this.mUU != null) {
                this.mUU.setText(this.mXv.mQs.desc);
            }
            dBE();
        }
    }

    public void dBE() {
        String formatNumber = tv.chushou.zues.utils.b.formatNumber(String.valueOf(this.mVb * h.parseLong(this.mXv.mQs.point)));
        if (this.mSd != null) {
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.append(String.format(this.mXw.getString(a.i.str_buy_count_coin), formatNumber));
            cVar.O(this.mXw, a.e.icon_coin_new);
            cVar.append(this.mXw.getString(a.i.str_buy_count_coin2));
            this.mSd.setText(cVar);
        }
    }

    private void dCC() {
        if (com.kascend.chushou.d.e.c(this.mXw, null) && LoginManager.Instance().getUserInfo() != null) {
            f(this.mVb);
        }
    }

    private void dCD() {
        this.mVc = false;
        this.mUZ.setBackgroundResource(a.e.ic_trumpet_n);
        if (this.mXv != null && this.mXv.mQs != null) {
            if (this.mXv.mQs.count < 1) {
                this.mVa.setVisibility(8);
            } else {
                this.mVa.setVisibility(0);
                this.mVa.setSelected(false);
                this.mVa.setTextColor(Color.parseColor("#235DA0"));
            }
        }
        this.mUS.setVisibility(8);
        if (this.mUA != null) {
            this.mUA.setHint(a.i.str_danmu_common_hint);
        }
    }

    @Override // com.kascend.chushou.player.d
    protected void b(boolean z) {
        if (this.mQN != null) {
            if (z) {
                this.mQN.setVisibility(0);
            } else {
                this.mQN.setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void O() {
        if (this.mWD != null) {
            this.mWD.performClick();
        }
    }

    @Override // com.kascend.chushou.player.e
    public void P() {
        if (this.mUJ != null) {
            this.mUJ.performClick();
        }
    }
}
