package com.kascend.chushou.player.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.facebook.drawee.span.c;
import com.google.android.flexbox.FlexboxLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.l;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.b.a.a.p;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.d.e;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.player.b;
import com.kascend.chushou.player.ui.ShareDanmakuView;
import com.kascend.chushou.player.ui.button.EmbeddedButtonLayout;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.player.ui.h5.redpacket.RedpacketNotifier;
import com.kascend.chushou.player.ui.miniview.MicStatusView;
import com.kascend.chushou.widget.cswebview.d;
import com.kascend.chushou.widget.gif.EmojiGiftView;
import com.kascend.chushou.widget.gif.b;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.a.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class a extends Fragment implements View.OnClickListener {
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private ArrayList<ChatInfo> i;
    private HashMap<String, Drawable> mSK;
    private View n;
    private RecyclerView nbK;
    private RecyclerView.LayoutManager nbM;
    private Button nbO;
    private Animator nbP;
    private Animator nbQ;
    private ShareDanmakuView nbR;
    private MicStatusView nbS;
    private EmbeddedButtonLayout nbT;
    private FoodView nbU;
    private FoodView nbV;
    private com.kascend.chushou.player.ui.miniview.a nbW;
    private InteractNotifier nbX;
    private RedpacketNotifier nbY;
    private FrescoThumbnailView nbZ;
    private RoomInfo nca;
    private ScrollView ncc;
    private View o;
    private View q;
    private View r;
    private ValueAnimator v;
    private Context a = null;
    private View b = null;
    private b nbL = null;
    private C0700a nbN = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean F = false;
    private final io.reactivex.disposables.a ncb = new io.reactivex.disposables.a();
    private boolean I = false;

    public static a wx(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("pkMode", z);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.a = getActivity();
        tv.chushou.zues.a.a.register(this);
        if (arguments != null) {
            this.I = arguments.getBoolean("pkMode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(a.h.view_banrrage_page, viewGroup, false);
        this.nbL = ((VideoPlayer) this.a).dCD();
        if (this.nbL != null) {
            this.nca = this.nbL.dDf();
        }
        this.f = new ArrayList<>();
        if (this.nca != null) {
            f();
        }
        this.h = new ArrayList<>();
        this.g = new ArrayList<>();
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ArrayList<ChatInfo> c;
        super.onViewCreated(view, bundle);
        this.nbX = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.nbY = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.nbO = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.nbO.setOnClickListener(this);
        this.nbK = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.nbM = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.a);
        this.nbK.setLayoutManager(this.nbM);
        this.nbK.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.nbK.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.nbK.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    a.this.i();
                } else if (i == 1) {
                    a.this.l = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.nbN = new C0700a(this.a);
        this.nbK.setAdapter(this.nbN);
        this.nbN.a(this.f.size());
        this.nbN.notifyDataSetChanged();
        if (this.nbL != null && (c = this.nbL.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.nbS = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.nbS.setOnClickListener(this);
        this.nbU = (FoodView) this.b.findViewById(a.f.top_ad);
        this.nbV = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.ncc = (ScrollView) this.b.findViewById(a.f.sv);
        this.nbT = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().O(this.a, a.e.videoplayer_reminder_subscribe).append(HanziToPinyin.Token.SEPARATOR).append(this.a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().O(this.a, a.e.videoplayer_reminder_danmaku).append(HanziToPinyin.Token.SEPARATOR).append(this.a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.nbR = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.nbR.a(getActivity(), ContextCompat.getColor(this.a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.nbN != null && a.this.nbM != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.nbN.a(a.this.f.size());
                    a.this.nbN.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.nbO != null) {
                        a.this.nbO.setVisibility(8);
                    }
                    a.this.nbM.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.nbL != null ? this.nbL.h : "");
        if (this.nbL != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.a;
            a(this.nbL.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a dCN = videoPlayer.dCN();
            this.nbT.a(dCN.dEw());
            BangInfo dEx = dCN.dEx();
            if (dEx != null) {
                this.nbT.a(dEx, dCN.d());
            }
            this.nbT.b(this.nbL.i());
            this.nbX.a(videoPlayer.dCK(), videoPlayer.dCL(), videoPlayer.dCM());
            this.nbY.a(videoPlayer.dCJ(), false);
            if (this.nbL.mSO != null && !h.isEmpty(this.nbL.mSO.mUrl)) {
                a(this.nbL.mSO);
            }
            if (this.nca != null && !this.nca.mIsSubscribed) {
                RxExecutor.postDelayed(this.ncb, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.nca == null || !a.this.nca.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            if (!h.isEmpty(this.nbL.mSW)) {
                this.nbT.a(this.nbL.mSW);
            }
        }
        if (this.nca != null && !h.isEmpty(this.nca.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.I ? 0 : 8);
            aVar.QW(this.nca.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.nbW == null) {
            this.nbW = new com.kascend.chushou.player.ui.miniview.a(this.a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.4
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.nbW != null && a.this.b != null && a.this.nbW.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.nbW);
                        a.this.nbW = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.nbW);
            if (listItem.mAutoDisplay == 0) {
                this.nbW.setVisibility(8);
            } else {
                this.nbW.a(a.C0691a.slide_in_top_danmu_anim, a.C0691a.slide_out_top_danmu_anim, this.nca == null ? "" : this.nca.mRoomID);
            }
        } else if (!this.nbW.isShown()) {
            this.nbW.a(a.C0691a.slide_in_top_danmu_anim, a.C0691a.slide_out_top_danmu_anim, this.nca == null ? "" : this.nca.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.nbT.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.a != null && this.b != null) {
            if (this.nbZ == null) {
                this.nbZ = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point hc = tv.chushou.zues.utils.a.hc(this.a);
            int integer = (hc.y - ((hc.x * this.a.getResources().getInteger(a.g.h_thumb_height_def)) / this.a.getResources().getInteger(a.g.h_thumb_width_def))) - this.a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.nbZ.setVisibility(0);
            this.nbZ.i(str, 0, hc.x, integer);
        }
    }

    public void a() {
        if (this.nbZ != null) {
            this.nbZ.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.nbW != null) {
            this.nbW.a(str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.F = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.F = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        com.kascend.chushou.toolkit.b.a.b();
        this.nbR.a();
        if (this.nbP != null) {
            this.nbP.removeAllListeners();
            this.nbP.cancel();
            this.nbP = null;
        }
        if (this.nbQ != null) {
            this.nbQ.removeAllListeners();
            this.nbQ.cancel();
            this.nbQ = null;
        }
        if (this.nbX != null) {
            this.nbX.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.ncb.dispose();
        super.onDestroy();
        j();
    }

    protected boolean b() {
        return this.a == null || ((Activity) this.a).isFinishing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_mic_status) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.btn_scrollbottom) {
            if (this.nbK != null) {
                d(true);
            }
        } else if (id == a.f.view_reminder_subscribe) {
            c(false);
            HashMap hashMap = new HashMap(3);
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", "73");
            a(hashMap);
        } else if (id == a.f.view_reminder_danmaku) {
            b(false);
            tv.chushou.zues.a.a.post(new i(53, this.a.getResources().getString(a.i.hotword_1)));
            com.kascend.chushou.toolkit.a.c.a(this.a, "双击666_num", null, new Object[0]);
        }
    }

    public void a(long j) {
        if (this.nbX != null) {
            this.nbX.a(j);
        }
    }

    public void c() {
        if (this.nbX != null) {
            this.nbX.a();
        }
    }

    public void b(long j) {
        if (this.nbX != null) {
            this.nbX.b(j);
        }
    }

    public void a(int i) {
        if (this.nbX != null) {
            this.nbX.a(i);
        }
    }

    public void b(int i) {
        if (this.a != null) {
            this.nbY.a(((VideoPlayer) this.a).dCJ(), false);
        }
        this.nbY.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.nbT != null) {
            this.nbT.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.nbT != null) {
            this.nbT.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nbT != null) {
            this.nbT.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.nbT != null) {
            this.nbT.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.nbT != null) {
            this.nbT.a(list);
        }
    }

    public void d() {
        if (this.nbL.mSN != null && this.nbU != null) {
            this.nbU.a(true, this.nca == null ? "" : this.nca.mRoomID);
            this.nbU.a(this.nbL.mSN, a.C0691a.slide_in_top_danmu_anim, a.C0691a.slide_out_top_danmu_anim, false);
        }
        if (this.nbL.mSM != null && this.nbV != null) {
            this.nbV.a(this.nbL.mSM, a.C0691a.slide_in_bottom_danmu_anim, a.C0691a.slide_out_bottom_danmu_anim, true);
        }
        if (this.nbL.mSU != null && this.nbT != null) {
            this.nbT.a(this.nbL.mSU, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.5
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.nbL != null) {
                        a.this.nbL.mSU = null;
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    public void b(boolean z) {
        if (z) {
            if (this.n != null && this.n.getVisibility() == 0) {
                this.n.setVisibility(8);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0691a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.6
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.dEv();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.ncb, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0691a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.8
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.nbQ != null) {
                        a.this.nbQ.removeAllListeners();
                        a.this.nbQ.cancel();
                        a.this.nbQ = null;
                    }
                    if (a.this.q != null) {
                        a.this.q.setVisibility(8);
                    }
                }
            });
            this.q.startAnimation(loadAnimation2);
        }
    }

    public void c(boolean z) {
        if (z) {
            if (this.n != null && this.n.getVisibility() != 0) {
                com.kascend.chushou.toolkit.a.a.a("42");
                this.o.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0691a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.9
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dEu();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.ncb, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0691a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.nbP != null) {
                        a.this.nbP.removeAllListeners();
                        a.this.nbP.cancel();
                        a.this.nbP = null;
                    }
                    if (a.this.n != null) {
                        a.this.n.setVisibility(8);
                    }
                }
            });
            this.n.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dEu() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.nbP != null) {
            this.nbP.removeAllListeners();
            this.nbP.cancel();
            this.nbP = null;
        }
        this.o.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.o, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.o, 0.0f);
        int measuredWidth = (this.n.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.a, 13.0f) * 2)) - this.o.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.o, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.o, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.nbP != null) {
                    a.this.nbP.removeAllListeners();
                    a.this.nbP.cancel();
                    a.this.nbP = null;
                }
                RxExecutor.postDelayed(a.this.ncb, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dEu();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nbP = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dEv() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.nbQ != null) {
            this.nbQ.removeAllListeners();
            this.nbQ.cancel();
            this.nbQ = null;
        }
        this.r.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.r, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.r, 0.0f);
        int measuredWidth = (this.q.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.a, 13.0f) * 2)) - this.r.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.r, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.r, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.r, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.nbQ != null) {
                    a.this.nbQ.removeAllListeners();
                    a.this.nbQ.cancel();
                    a.this.nbQ = null;
                }
                RxExecutor.postDelayed(a.this.ncb, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dEv();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.nbQ = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.ncb, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nbN != null) {
                        a.this.nbN.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.a != null && !((Activity) this.a).isFinishing() && pVar != null) {
            this.k = pVar.a;
            if (this.k != null && this.k.contains("4") && this.nbR != null) {
                this.nbR.b();
            }
            d(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.nca != null && mVar.a(this.nca.mCreatorUID, this.nca.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.a == 8 && this.nbW != null && this.nbW.getVisibility() != 0) {
            this.nbW.a(a.C0691a.slide_in_top_danmu_anim, a.C0691a.slide_out_top_danmu_anim, this.nca == null ? "" : this.nca.mRoomID);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!b()) {
            if (iVar.a == 49) {
                if (!this.F && iVar.b != null) {
                    a(iVar.b.toString());
                }
            } else if (iVar.a == 50 && !this.F && (iVar.b instanceof ListItem)) {
                ListItem listItem = (ListItem) iVar.b;
                if (!h.isEmpty(listItem.mUrl)) {
                    a(listItem);
                }
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!b() && this.nca != null && !h.isEmpty(this.nca.mRoomID) && this.nca.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.nbW != null && this.nbW.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.nbS != null && this.nbS.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.nbU != null && this.nbU.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nbU.getHeight());
                }
                this.ncc.setTranslationY(r0);
                return;
            }
            if (this.v != null) {
                this.v.cancel();
                this.v = null;
            }
            int translationY = (int) this.ncc.getTranslationY();
            if (aVar.a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 32.0f) : 0;
                if (this.nbW != null && this.nbW.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.nbU != null && this.nbU.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nbU.getHeight());
                }
                if (this.I) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (2 == aVar.a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 65.0f) : 0;
                if (this.nbW != null && this.nbW.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.nbU != null && this.nbU.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nbU.getHeight());
                }
                if (this.I) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (3 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.nbS != null && this.nbS.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.nbU != null && this.nbU.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nbU.getHeight());
                }
                if (this.I) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (5 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 64.0f);
                    this.I = true;
                } else {
                    this.I = false;
                    if (this.nbS != null && this.nbS.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                    }
                }
                if (this.nbW != null && this.nbW.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.nbU != null && this.nbU.getVisibility() == 0) {
                    r0 = Math.max(r0, this.nbU.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.nbU.getHeight();
                if (this.nbW != null && this.nbW.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 80.0f));
                }
            } else {
                if (this.nbW != null && this.nbW.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.nbS != null && this.nbS.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.I) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            }
            if (translationY != r0) {
                a(translationY, r0);
            }
        }
    }

    private void a(int i, int i2) {
        this.v = ValueAnimator.ofInt(i, i2);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.a.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!a.this.b() && a.this.ncc != null) {
                    a.this.ncc.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.v.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.v = null;
            }
        });
        this.v.setInterpolator(new LinearInterpolator());
        this.v.setDuration(800L);
        this.v.start();
    }

    public void a(MicStatus micStatus, List<FanItem> list, String str, boolean z) {
        if (this.nbS != null) {
            if (!this.nbS.isShown()) {
                if (this.nbL != null && this.nbL.dDd() != null && this.nbL.dDd().mRoominfo != null) {
                    this.nbS.a(list, str, z, micStatus, this.nbL.dDd().mRoominfo.mCreatorUID);
                    this.nbS.a(this.nbL.dDd().mRoominfo.mRoomID);
                }
            } else if (this.nbL != null && this.nbL.dDd() != null && this.nbL.dDd().mRoominfo != null) {
                this.nbS.a(list, str, z, micStatus, this.nbL.dDd().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.nbS != null && this.nbS.isShown()) {
            this.nbS.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int childCount = this.nbM.getChildCount();
        int itemCount = this.nbM.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.nbM);
        if (f + childCount >= itemCount) {
            this.l = true;
            if (this.nbO != null) {
                this.nbO.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                d(true);
            }
        }
    }

    public void f() {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.mType = "-1";
        this.f.add(0, chatInfo);
        ChatInfo chatInfo2 = new ChatInfo();
        chatInfo2.mType = "-4";
        this.f.add(1, chatInfo2);
    }

    private void d(boolean z) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        while (2 < this.f.size()) {
            this.f.remove(2);
        }
        ArrayList<ChatInfo> a = a(this.h);
        if (a == null) {
            e(false);
            return;
        }
        this.f.addAll(a);
        int size = this.f.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.f.size(); i++) {
                this.f.remove(2);
            }
        }
        e(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        this.i.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.k != null && this.k.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.k.contains("2"))) {
                        this.i.add(next);
                    } else if (!this.k.contains(next.mType)) {
                        this.i.add(next);
                    }
                }
                return this.i;
            }
            return arrayList;
        }
        return null;
    }

    public void c(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            if ((this.k == null || !this.k.contains("4")) && this.nbR != null) {
                this.nbR.a(list);
            }
        }
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.f == null) {
                    this.f = new ArrayList<>(arrayList);
                    f();
                    e(z2);
                    return;
                }
                if (this.h == null) {
                    this.h = new ArrayList<>();
                }
                this.h.addAll(arrayList);
                int size = this.h.size();
                if (size > 500) {
                    this.h.subList(0, size - 500).clear();
                }
                ArrayList<ChatInfo> a = a(arrayList);
                int size2 = this.f.size();
                if (a != null) {
                    this.f.addAll(a);
                }
                int size3 = this.f.size();
                if (!this.l && this.nbO != null) {
                    this.nbO.setVisibility(0);
                }
                if (!h.isEmpty(a)) {
                    a(z2, 1, size2, a.size());
                }
                if (size3 > 200) {
                    int i = 0;
                    for (int i2 = 2; i2 < size3 - 100 && i2 < this.f.size(); i2++) {
                        this.f.remove(2);
                        i++;
                    }
                    a(z2, 2, 1, i);
                    return;
                }
                return;
            }
            if (this.f == null) {
                this.f = new ArrayList<>(arrayList);
                f();
            } else {
                if (this.h == null) {
                    this.h = new ArrayList<>();
                }
                this.h.clear();
                this.h.addAll(arrayList);
                this.f.clear();
                f();
                ArrayList<ChatInfo> a2 = a(arrayList);
                if (a2 != null) {
                    this.f.addAll(a2);
                }
            }
            e(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.F) {
            if (this.nbN != null) {
                this.nbN.a(this.f.size());
                if (i == 1) {
                    this.nbN.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.nbN.notifyItemRangeRemoved(i2, i3);
                    this.nbN.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.nbN.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.nbO != null) {
                    this.nbO.setVisibility(8);
                }
                if (z) {
                    this.nbK.scrollToPosition(this.f.size() - 1);
                } else {
                    this.nbK.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void e(boolean z) {
        if (!this.F) {
            if (this.nbN != null) {
                this.nbN.a(this.f.size());
                this.nbN.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.nbO != null) {
                    this.nbO.setVisibility(8);
                }
                if (z) {
                    this.nbK.scrollToPosition(this.f.size() - 1);
                } else {
                    this.nbK.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void j() {
        tv.chushou.zues.a.a.cr(this);
        if (this.nbN != null) {
            this.nbN.a(0);
            this.nbN = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.mSK != null) {
            this.mSK.clear();
            this.mSK = null;
        }
        this.a = null;
        this.b = null;
        this.nbK = null;
        this.nbO = null;
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.nbN = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.nbM = null;
        this.nbL = null;
        this.nca = null;
        this.nbS = null;
        if (this.nbU != null) {
            this.nbU.a();
        }
        if (this.nbV != null) {
            this.nbV.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.nbL != null && this.nbL.dDf() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.nbL.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.nbL.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.dCo().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet dv = com.kascend.chushou.c.a.dv(jSONObject);
                        if (dv.mRc == 0) {
                            g.M(a.this.a, a.i.subscribe_success);
                            a.this.nca.mIsSubscribed = true;
                            return;
                        }
                        a(dv.mRc, dv.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!a.this.b()) {
                        if (h.isEmpty(str2)) {
                            str2 = a.this.a.getString(a.i.subscribe_failed);
                        }
                        g.c(a.this.a, str2);
                    }
                }
            }, (String) null, this.nca.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0700a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private tv.chushou.zues.a mSi;
        private tv.chushou.zues.a mSj;
        private tv.chushou.zues.a mSl;
        private tv.chushou.zues.a mSm;
        private final int n;
        private tv.chushou.zues.a ncg;
        private final tv.chushou.zues.toolkit.richtext.a nch;
        private final int o;
        private final int p;
        private final int q;
        private final JSONObject s;
        private final int t;
        protected int a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.S(28.0f);
        private final int v = tv.chushou.widget.a.c.S(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes5.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private ChatInfo mSA;
            private SimpleDraweeSpanTextView mSw;

            c(View view) {
                super(view);
                this.mSw = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0700a.this.b.getString(a.i.videoplayer_danmaku_share)).O(C0700a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0700a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b dCD;
                JSONObject jSONObject = null;
                if (this.mSA != null && this.mSA.mItem != null) {
                    String str = (!(C0700a.this.b instanceof VideoPlayer) || (dCD = ((VideoPlayer) C0700a.this.b).dCD()) == null) ? null : dCD.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0700a.this.b, this.mSA.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.mSA = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0700a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.mSw, null, C0700a.this.nch)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.mSw.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0702a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView mSv;

            C0702a(View view) {
                super(view);
                this.mSv = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.mSv != null && ViewCompat.isAttachedToWindow(this.mSv)) {
                    this.mSv.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.mSv != null) {
                    this.mSv.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.mSv != null) {
                    this.mSv.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes5.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {
            View a;
            SimpleDraweeSpanTextView mSw;
            EmojiGiftView mSx;

            b(View view) {
                super(view);
                this.a = view;
                this.mSw = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.mSx = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.mQS.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0700a.this.u, C0700a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0700a.this.a(this.mSw, this, cVar, str, a.e.default_medal_icon, C0700a.this.o, C0700a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0700a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0700a.this.b, a.c.banrrage_chat_name_color), this.mSw, " : ", C0700a.this.nch);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0700a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0700a.this.b, a.c.kas_red_n), this.mSw)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0700a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0700a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.mSw.setMovementMethod(tv.chushou.zues.widget.a.b.dRt());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0700a.this.mSi), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.mSw.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.mSw != null) {
                            b.this.mSw.measure(0, 0);
                            b.this.mSw.requestLayout();
                        }
                    }
                });
                this.mSw.setDraweeSpanStringBuilder(cVar);
                int S = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.S(chatInfo.giftDisplayWidth) : C0700a.this.t;
                int S2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.S(chatInfo.giftDisplayHeight) : C0700a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.mSx.getLayoutParams();
                layoutParams.width = S;
                layoutParams.height = S2;
                this.mSx.setLayoutParams(layoutParams);
                this.mSx.g(chatInfo.mGift.icon, a.c.transparent, S, S2);
                this.mSx.setOnClickListener(C0700a.this.mSm);
                this.mSx.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.dEF().a(chatInfo.mCoolMessage.mBgImage, this.a, a.e.bg_bubble_default);
                    return;
                }
                this.a.setBackgroundResource(0);
                this.a.setPadding(tv.chushou.zues.utils.a.dip2px(C0700a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0700a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0700a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0700a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.mSw != null && ViewCompat.isAttachedToWindow(this.mSw)) {
                    this.mSw.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.mSw != null) {
                    this.mSw.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.mSw != null) {
                    this.mSw.removeCallbacks(runnable);
                }
            }
        }

        C0700a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.nca != null) {
                hashMap.put("_fbroomid", a.this.nca.mRoomID);
            }
            this.s = e.a(hashMap);
            this.mSj = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0700a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.nca.mCreatorUID, C0700a.this.s);
                    }
                }
            };
            this.mSi = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.nca == null || !chatInfo.mItem.mTargetKey.equals(a.this.nca.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0700a.this.b, chatInfo.mItem, C0700a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0700a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.nca.mCreatorUID, C0700a.this.s);
                    }
                }
            };
            this.mSl = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.nca == null || !chatInfo.mItem.mTargetKey.equals(a.this.nca.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0700a.this.b, chatInfo.mItem, C0700a.this.s);
                        }
                    }
                }
            };
            this.mSm = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0700a.this.s, a.this.nca.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.ncg = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void dz(View view) {
                    com.kascend.chushou.d.a.a(C0700a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
                }
            };
            Drawable drawable = tv.chushou.widget.a.c.getDrawable(a.e.zues_default_gift_color);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.n = tv.chushou.zues.utils.a.dip2px(this.b, 21.0f);
            this.m = (intrinsicWidth * this.n) / intrinsicHeight;
            this.p = tv.chushou.zues.utils.a.dip2px(this.b, 21.0f);
            this.o = this.p;
            this.t = tv.chushou.zues.utils.a.dip2px(this.b, 40.0f);
            this.nch = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
            this.q = ContextCompat.getColor(this.b, a.c.videoplayer_share_danmaku);
        }

        public void a(int i) {
            this.a = i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (a.this.f == null || i >= a.this.f.size() || a.this.f.get(i) == null) {
                return 2;
            }
            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
            String str = chatInfo.mType;
            if ("-4".equals(str)) {
                return 10000;
            }
            if ("-1".equals(str)) {
                return 1;
            }
            if ("3".equals(str)) {
                return chatInfo.giftType == 2 ? 4 : 2;
            }
            return chatInfo.isShare() ? 3 : 2;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                case 10000:
                    return new C0702a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0702a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0702a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0702a c0702a = (C0702a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0702a.mSv != null) {
                                c0702a.mSv.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0702a.mSv != null) {
                            c0702a.mSv.setOnClickListener(null);
                            return;
                        } else {
                            return;
                        }
                    } else if (viewHolder instanceof c) {
                        onBindViewHolder(viewHolder, i);
                        return;
                    } else if (viewHolder instanceof b) {
                        onBindViewHolder(viewHolder, i);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            onBindViewHolder(viewHolder, i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
            int i3;
            if (a.this.f != null && i < a.this.f.size()) {
                switch (getItemViewType(i)) {
                    case 1:
                    case 2:
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        final C0702a c0702a = (C0702a) viewHolder;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case 49:
                                if (str.equals("1")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals("3")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                                if (!h.isEmpty(a.this.nca.mSystemAnnouncement)) {
                                    ArrayList<RichText> ST = tv.chushou.zues.toolkit.richtext.b.ST(a.this.nca.mSystemAnnouncement);
                                    if (h.isEmpty(ST)) {
                                        cVar.a(a.this.nca.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, ST, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0702a.mSv);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.nca.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0702a.mSv.setText(cVar);
                                c0702a.mSv.setOnClickListener(null);
                                c0702a.mSv.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0702a.mSv != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.mQS.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0702a.mSv, c0702a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0702a.mSv, " : ", this.nch);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mSj), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0702a.mSv, null, this.nch);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().ba(chatInfo.mCoolNickname.mFontColors).HX(chatInfo.mCoolNickname.mNickName.length()).dnI());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0702a.mSv, " : ", this.nch)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mSj), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.nch.QZ(chatInfo.mCoolContent.mContent), new c.a().ba(chatInfo.mCoolContent.mFontColors).HX(chatInfo.mCoolContent.mContent.length()).dnI());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0702a.mSv, null, this.nch)) {
                                                cVar2.a(this.nch.QZ(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0702a.mSv != null) {
                                                c0702a.mSv.measure(0, 0);
                                                c0702a.mSv.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(HanziToPinyin.Token.SEPARATOR);
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mSi), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0702a.mSv.setDraweeSpanStringBuilder(cVar2);
                                    c0702a.mSv.setTag(a.f.tag_position, chatInfo);
                                    c0702a.mSv.setMovementMethod(tv.chushou.zues.widget.a.b.dRt());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dEF().a(chatInfo.mCoolMessage.mBgImage, c0702a.mSv, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0702a.mSv.setBackgroundResource(0);
                                    c0702a.mSv.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0702a.mSv != null) {
                                    c0702a.mSv.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0702a.mSv, c0702a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0702a.mSv, null, this.nch);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0702a.mSv, null, this.nch)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0702a.mSv != null) {
                                                        c0702a.mSv.measure(0, 0);
                                                        c0702a.mSv.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.mSl), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0702a.mSv.setDraweeSpanStringBuilder(cVar3);
                                            c0702a.mSv.setTag(a.f.tag_position, chatInfo2);
                                            c0702a.mSv.setMovementMethod(tv.chushou.zues.widget.a.b.dRt());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.dEF().a(chatInfo2.mCoolMessage.mBgImage, c0702a.mSv, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0702a.mSv.setBackgroundResource(0);
                                            c0702a.mSv.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0702a.mSv != null) {
                                    c0702a.mSv.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0702a.mSv, " : ", this.nch);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mSj), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0702a.mSv, null, this.nch);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0702a.mSv)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mSj), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0702a.mSv)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(HanziToPinyin.Token.SEPARATOR);
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0702a.mSv, c0702a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.mSK == null) {
                                                a.this.mSK = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.mSK.containsKey(substring)) {
                                                drawable = (Drawable) a.this.mSK.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.mSK.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.mSK.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.mSK.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.mSK.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mSi), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0702a.mSv.setDraweeSpanStringBuilder(cVar4);
                                    c0702a.mSv.setTag(a.f.tag_position, chatInfo3);
                                    c0702a.mSv.setMovementMethod(tv.chushou.zues.widget.a.b.dRt());
                                    c0702a.mSv.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dEF().a(chatInfo3.mCoolMessage.mBgImage, c0702a.mSv, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0702a.mSv.setBackgroundResource(0);
                                    c0702a.mSv.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    case 3:
                        ((c) viewHolder).a((ChatInfo) a.this.f.get(i));
                        return;
                    case 4:
                        ((b) viewHolder).a((ChatInfo) a.this.f.get(i));
                        return;
                    case 10000:
                        C0702a c0702a2 = (C0702a) viewHolder;
                        c0702a2.mSv.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.ncg), new UnderlineSpan());
                        c0702a2.mSv.setDraweeSpanStringBuilder(cVar5);
                        c0702a2.mSv.setMovementMethod(tv.chushou.zues.widget.a.b.dRt());
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SimpleDraweeSpanTextView simpleDraweeSpanTextView, Drawable.Callback callback, tv.chushou.zues.widget.a.c cVar, String str, int i, int i2, int i3) {
            if (!h.isEmpty(str)) {
                if (e.a(str)) {
                    cVar.a("", new b.a().a(callback).wB(true).Nk(i2).Nl(i3).Rd(str).Nj(i).f(simpleDraweeSpanTextView).dFd());
                    cVar.append(HanziToPinyin.Token.SEPARATOR);
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).HU(i).dnx(), this.b);
                a.setController(com.facebook.drawee.a.a.c.dlW().OW(str).dmN());
                cVar.append("1");
                cVar.a(a, length, length, i2, i3, true, 2);
                cVar.append(HanziToPinyin.Token.SEPARATOR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b dCD;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (dCD = ((VideoPlayer) context).dCD()) != null && !h.isEmpty(dCD.a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", dCD.a);
                Http http = (Http) tv.chushou.basis.d.b.dQw().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
