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
    private HashMap<String, Drawable> H;
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private View n;
    private Animator npA;
    private View npB;
    private Animator npC;
    private ShareDanmakuView npD;
    private MicStatusView npE;
    private ValueAnimator npF;
    private EmbeddedButtonLayout npG;
    private FoodView npH;
    private FoodView npI;
    private com.kascend.chushou.player.ui.miniview.a npJ;
    private InteractNotifier npK;
    private RedpacketNotifier npL;
    private FrescoThumbnailView npM;
    private RoomInfo npN;
    private ScrollView npP;
    private RecyclerView npt;
    private RecyclerView.LayoutManager npv;
    private ArrayList<ChatInfo> npw;
    private Button npy;
    private Animator npz;
    private View o;
    private View q;
    private View r;
    private View u;
    private Context a = null;
    private View b = null;
    private b npu = null;
    private C0824a npx = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a npO = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a xa(boolean z) {
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
            this.L = arguments.getBoolean("pkMode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(a.h.view_banrrage_page, viewGroup, false);
        this.npu = ((VideoPlayer) this.a).dJf();
        if (this.npu != null) {
            this.npN = this.npu.dJI();
        }
        this.f = new ArrayList<>();
        if (this.npN != null) {
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
        this.npK = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.npL = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.npy = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.npy.setOnClickListener(this);
        this.npt = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.npv = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.a);
        this.npt.setLayoutManager(this.npv);
        this.npt.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.npt.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.npt.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    a.this.j();
                } else if (i == 1) {
                    a.this.l = false;
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            }
        });
        this.npx = new C0824a(this.a);
        this.npt.setAdapter(this.npx);
        this.npx.a(this.f.size());
        this.npx.notifyDataSetChanged();
        if (this.npu != null && (c = this.npu.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.npE = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.npE.setOnClickListener(this);
        this.npH = (FoodView) this.b.findViewById(a.f.top_ad);
        this.npI = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.npP = (ScrollView) this.b.findViewById(a.f.sv);
        this.npG = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().J(this.a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().J(this.a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.npB = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.npB.findViewById(a.f.spash_sendgift);
        ((TextView) this.npB.findViewById(a.f.tv_reminder_sendgift)).setText(new c().J(tv.chushou.basis.d.b.dWi(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.npB.setOnClickListener(this);
        this.npD = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.npD.a(getActivity(), ContextCompat.getColor(this.a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.npx != null && a.this.npv != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.npx.a(a.this.f.size());
                    a.this.npx.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.npy != null) {
                        a.this.npy.setVisibility(8);
                    }
                    a.this.npv.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.npu != null ? this.npu.h : "");
        if (this.npu != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.a;
            a(this.npu.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a dJp = videoPlayer.dJp();
            this.npG.a(dJp.dKJ());
            BangInfo dKK = dJp.dKK();
            if (dKK != null) {
                this.npG.a(dKK, dJp.d());
            }
            this.npG.b(this.npu.dJH());
            this.npK.a(videoPlayer.dJm(), videoPlayer.dJn(), videoPlayer.dJo());
            this.npL.a(videoPlayer.dJl(), false);
            if (this.npu.ngL != null && !h.isEmpty(this.npu.ngL.mUrl)) {
                a(this.npu.ngL);
            }
            if (this.npN != null && !this.npN.mIsSubscribed) {
                RxExecutor.postDelayed(this.npO, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.npN == null || !a.this.npN.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.npO, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.npu != null && !a.this.npu.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.npu.ngS)) {
                this.npG.a(this.npu.ngS);
            }
        }
        if (this.npN != null && !h.isEmpty(this.npN.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.Rl(this.npN.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.npJ == null) {
            this.npJ = new com.kascend.chushou.player.ui.miniview.a(this.a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.npJ != null && a.this.b != null && a.this.npJ.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.npJ);
                        a.this.npJ = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.npJ);
            if (listItem.mAutoDisplay == 0) {
                this.npJ.setVisibility(8);
            } else {
                this.npJ.a(a.C0815a.slide_in_top_danmu_anim, a.C0815a.slide_out_top_danmu_anim, this.npN == null ? "" : this.npN.mRoomID);
            }
        } else if (!this.npJ.isShown()) {
            this.npJ.a(a.C0815a.slide_in_top_danmu_anim, a.C0815a.slide_out_top_danmu_anim, this.npN == null ? "" : this.npN.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.npG.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.a != null && this.b != null) {
            if (this.npM == null) {
                this.npM = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point gw = tv.chushou.zues.utils.a.gw(this.a);
            int integer = (gw.y - ((gw.x * this.a.getResources().getInteger(a.g.h_thumb_height_def)) / this.a.getResources().getInteger(a.g.h_thumb_width_def))) - this.a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.npM.setVisibility(0);
            this.npM.i(str, 0, gw.x, integer);
        }
    }

    public void a() {
        if (this.npM != null) {
            this.npM.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.npJ != null) {
            this.npJ.a(str);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.I = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.I = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        com.kascend.chushou.toolkit.b.a.b();
        this.npD.a();
        if (this.npz != null) {
            this.npz.removeAllListeners();
            this.npz.cancel();
            this.npz = null;
        }
        if (this.npA != null) {
            this.npA.removeAllListeners();
            this.npA.cancel();
            this.npA = null;
        }
        if (this.npC != null) {
            this.npC.removeAllListeners();
            this.npC.cancel();
            this.npC = null;
        }
        if (this.npK != null) {
            this.npK.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.npO.dispose();
        super.onDestroy();
        k();
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
            if (this.npt != null) {
                e(true);
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
        } else if (id == a.f.view_reminder_sendgift) {
            d(false);
            tv.chushou.zues.a.a.post(new i(56, null));
        }
    }

    public void a(long j) {
        if (this.npK != null) {
            this.npK.a(j);
        }
    }

    public void c() {
        if (this.npK != null) {
            this.npK.a();
        }
    }

    public void b(long j) {
        if (this.npK != null) {
            this.npK.b(j);
        }
    }

    public void a(int i) {
        if (this.npK != null) {
            this.npK.a(i);
        }
    }

    public void b(int i) {
        if (this.a != null) {
            this.npL.a(((VideoPlayer) this.a).dJl(), false);
        }
        this.npL.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.npG != null) {
            this.npG.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.npG != null) {
            this.npG.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.npG != null) {
            this.npG.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.npG != null) {
            this.npG.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.npG != null) {
            this.npG.a(list);
        }
    }

    public void d() {
        if (this.npu.ngK != null && this.npH != null) {
            this.npH.a(true, this.npN == null ? "" : this.npN.mRoomID);
            this.npH.a(this.npu.ngK, a.C0815a.slide_in_top_danmu_anim, a.C0815a.slide_out_top_danmu_anim, false);
        }
        if (this.npu.ngJ != null && this.npI != null) {
            this.npI.a(this.npu.ngJ, a.C0815a.slide_in_bottom_danmu_anim, a.C0815a.slide_out_bottom_danmu_anim, true);
        }
        if (this.npu.ngQ != null && this.npG != null) {
            this.npG.a(this.npu.ngQ, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.npu != null) {
                        a.this.npu.ngQ = null;
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0815a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.dKH();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.npO, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0815a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.npA != null) {
                        a.this.npA.removeAllListeners();
                        a.this.npA.cancel();
                        a.this.npA = null;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0815a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dKG();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.npO, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0815a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.npz != null) {
                        a.this.npz.removeAllListeners();
                        a.this.npz.cancel();
                        a.this.npz = null;
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
    public Animator dKG() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.npz != null) {
            this.npz.removeAllListeners();
            this.npz.cancel();
            this.npz = null;
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.npz != null) {
                    a.this.npz.removeAllListeners();
                    a.this.npz.cancel();
                    a.this.npz = null;
                }
                RxExecutor.postDelayed(a.this.npO, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dKG();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.npz = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dKH() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.npA != null) {
            this.npA.removeAllListeners();
            this.npA.cancel();
            this.npA = null;
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.19
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.npA != null) {
                    a.this.npA.removeAllListeners();
                    a.this.npA.cancel();
                    a.this.npA = null;
                }
                RxExecutor.postDelayed(a.this.npO, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dKH();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.npA = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.npB != null && this.npB.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.dWi(), a.C0815a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dKI();
                    }
                });
                this.npB.setVisibility(0);
                this.npB.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.npO, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.npB != null && this.npB.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.dWi(), a.C0815a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.npC != null) {
                        a.this.npC.removeAllListeners();
                        a.this.npC.cancel();
                        a.this.npC = null;
                    }
                    if (a.this.npB != null) {
                        a.this.npB.setVisibility(8);
                    }
                }
            });
            this.npB.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dKI() {
        if (this.npB == null || this.u == null) {
            return null;
        }
        if (this.npC != null) {
            this.npC.removeAllListeners();
            this.npC.cancel();
            this.npC = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.npB.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.dWi(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.npC != null) {
                    a.this.npC.removeAllListeners();
                    a.this.npC.cancel();
                    a.this.npC = null;
                }
                RxExecutor.postDelayed(a.this.npO, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dKI();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.npC = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.npO, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.npx != null) {
                        a.this.npx.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.a != null && !((Activity) this.a).isFinishing() && pVar != null) {
            this.k = pVar.a;
            if (this.k != null && this.k.contains("4") && this.npD != null) {
                this.npD.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.npN != null && mVar.a(this.npN.mCreatorUID, this.npN.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.a == 8 && this.npJ != null && this.npJ.getVisibility() != 0) {
            this.npJ.a(a.C0815a.slide_in_top_danmu_anim, a.C0815a.slide_out_top_danmu_anim, this.npN == null ? "" : this.npN.mRoomID);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!b()) {
            if (iVar.a == 49) {
                if (!this.I && iVar.b != null) {
                    a(iVar.b.toString());
                }
            } else if (iVar.a == 50 && !this.I && (iVar.b instanceof ListItem)) {
                ListItem listItem = (ListItem) iVar.b;
                if (!h.isEmpty(listItem.mUrl)) {
                    a(listItem);
                }
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!b() && this.npN != null && !h.isEmpty(this.npN.mRoomID) && this.npN.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.npJ != null && this.npJ.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.npE != null && this.npE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.npH != null && this.npH.getVisibility() == 0) {
                    r0 = Math.max(r0, this.npH.getHeight());
                }
                this.npP.setTranslationY(r0);
                return;
            }
            if (this.npF != null) {
                this.npF.cancel();
                this.npF = null;
            }
            int translationY = (int) this.npP.getTranslationY();
            if (aVar.a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 32.0f) : 0;
                if (this.npJ != null && this.npJ.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.npH != null && this.npH.getVisibility() == 0) {
                    r0 = Math.max(r0, this.npH.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (2 == aVar.a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 65.0f) : 0;
                if (this.npJ != null && this.npJ.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.npH != null && this.npH.getVisibility() == 0) {
                    r0 = Math.max(r0, this.npH.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (3 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.npE != null && this.npE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.npH != null && this.npH.getVisibility() == 0) {
                    r0 = Math.max(r0, this.npH.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (5 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 64.0f);
                    this.L = true;
                } else {
                    this.L = false;
                    if (this.npE != null && this.npE.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                    }
                }
                if (this.npJ != null && this.npJ.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.npH != null && this.npH.getVisibility() == 0) {
                    r0 = Math.max(r0, this.npH.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.npH.getHeight();
                if (this.npJ != null && this.npJ.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 80.0f));
                }
            } else {
                if (this.npJ != null && this.npJ.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.npE != null && this.npE.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            }
            if (translationY != r0) {
                a(translationY, r0);
            }
        }
    }

    private void a(int i, int i2) {
        this.npF = ValueAnimator.ofInt(i, i2);
        this.npF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!a.this.b() && a.this.npP != null) {
                    a.this.npP.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.npF.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.npF = null;
            }
        });
        this.npF.setInterpolator(new LinearInterpolator());
        this.npF.setDuration(800L);
        this.npF.start();
    }

    public void a(MicStatus micStatus, List<FanItem> list, String str, boolean z) {
        if (this.npE != null) {
            if (!this.npE.isShown()) {
                if (this.npu != null && this.npu.dJF() != null && this.npu.dJF().mRoominfo != null) {
                    this.npE.a(list, str, z, micStatus, this.npu.dJF().mRoominfo.mCreatorUID);
                    this.npE.a(this.npu.dJF().mRoominfo.mRoomID);
                }
            } else if (this.npu != null && this.npu.dJF() != null && this.npu.dJF().mRoominfo != null) {
                this.npE.a(list, str, z, micStatus, this.npu.dJF().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.npE != null && this.npE.isShown()) {
            this.npE.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.npv.getChildCount();
        int itemCount = this.npv.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.npv);
        if (f + childCount >= itemCount) {
            this.l = true;
            if (this.npy != null) {
                this.npy.setVisibility(8);
            }
            if (childCount + f > itemCount) {
                e(true);
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

    private void e(boolean z) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        while (2 < this.f.size()) {
            this.f.remove(2);
        }
        ArrayList<ChatInfo> a = a(this.h);
        if (a == null) {
            f(false);
            return;
        }
        this.f.addAll(a);
        int size = this.f.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.f.size(); i++) {
                this.f.remove(2);
            }
        }
        f(z);
    }

    private ArrayList<ChatInfo> a(ArrayList<ChatInfo> arrayList) {
        if (this.npw == null) {
            this.npw = new ArrayList<>();
        }
        this.npw.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.k != null && this.k.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.k.contains("2"))) {
                        this.npw.add(next);
                    } else if (!this.k.contains(next.mType)) {
                        this.npw.add(next);
                    }
                }
                return this.npw;
            }
            return arrayList;
        }
        return null;
    }

    public void c(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            if ((this.k == null || !this.k.contains("4")) && this.npD != null) {
                this.npD.a(list);
            }
        }
    }

    public void a(ArrayList<ChatInfo> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() > 0) {
            if (z) {
                if (this.f == null) {
                    this.f = new ArrayList<>(arrayList);
                    f();
                    f(z2);
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
                if (!this.l && this.npy != null) {
                    this.npy.setVisibility(0);
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
            f(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.I) {
            if (this.npx != null) {
                this.npx.a(this.f.size());
                if (i == 1) {
                    this.npx.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.npx.notifyItemRangeRemoved(i2, i3);
                    this.npx.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.npx.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.npy != null) {
                    this.npy.setVisibility(8);
                }
                if (z) {
                    this.npt.scrollToPosition(this.f.size() - 1);
                } else {
                    this.npt.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.npx != null) {
                this.npx.a(this.f.size());
                this.npx.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.npy != null) {
                    this.npy.setVisibility(8);
                }
                if (z) {
                    this.npt.scrollToPosition(this.f.size() - 1);
                } else {
                    this.npt.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.ci(this);
        if (this.npx != null) {
            this.npx.a(0);
            this.npx = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.H != null) {
            this.H.clear();
            this.H = null;
        }
        this.a = null;
        this.b = null;
        this.npt = null;
        this.npy = null;
        if (this.npw != null) {
            this.npw.clear();
            this.npw = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.npx = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.npv = null;
        this.npu = null;
        this.npN = null;
        this.npE = null;
        if (this.npH != null) {
            this.npH.a();
        }
        if (this.npI != null) {
            this.npI.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.npu != null && this.npu.dJI() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.npu.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.npu.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.dIP().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet dP = com.kascend.chushou.c.a.dP(jSONObject);
                        if (dP.mRc == 0) {
                            g.F(a.this.a, a.i.subscribe_success);
                            a.this.npN.mIsSubscribed = true;
                            return;
                        }
                        a(dP.mRc, dP.mMessage);
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
            }, (String) null, this.npN.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0824a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private final int n;
        private tv.chushou.zues.a ngg;
        private tv.chushou.zues.a ngh;
        private tv.chushou.zues.a ngi;
        private tv.chushou.zues.a ngj;
        private tv.chushou.zues.a npU;
        private final tv.chushou.zues.toolkit.richtext.a npV;
        private final int o;
        private final int p;
        private final int q;
        private final JSONObject s;
        private final int t;
        protected int a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.D(28.0f);
        private final int v = tv.chushou.widget.a.c.D(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes5.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView ngt;
            private ChatInfo ngx;

            c(View view) {
                super(view);
                this.ngt = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0824a.this.b.getString(a.i.videoplayer_danmaku_share)).J(C0824a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0824a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b dJf;
                JSONObject jSONObject = null;
                if (this.ngx != null && this.ngx.mItem != null) {
                    String str = (!(C0824a.this.b instanceof VideoPlayer) || (dJf = ((VideoPlayer) C0824a.this.b).dJf()) == null) ? null : dJf.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0824a.this.b, this.ngx.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.ngx = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0824a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.ngt, null, C0824a.this.npV)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.ngt.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0826a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView ngs;

            C0826a(View view) {
                super(view);
                this.ngs = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.ngs != null && ViewCompat.isAttachedToWindow(this.ngs)) {
                    this.ngs.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.ngs != null) {
                    this.ngs.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.ngs != null) {
                    this.ngs.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes5.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {
            View a;
            SimpleDraweeSpanTextView ngt;
            EmojiGiftView ngu;

            b(View view) {
                super(view);
                this.a = view;
                this.ngt = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.ngu = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.neU.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0824a.this.u, C0824a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0824a.this.a(this.ngt, this, cVar, str, a.e.default_medal_icon, C0824a.this.o, C0824a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0824a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0824a.this.b, a.c.banrrage_chat_name_color), this.ngt, " : ", C0824a.this.npV);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0824a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0824a.this.b, a.c.kas_red_n), this.ngt)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0824a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0824a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.ngt.setMovementMethod(tv.chushou.zues.widget.a.b.dXk());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0824a.this.ngg), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.ngt.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.ngt != null) {
                            b.this.ngt.measure(0, 0);
                            b.this.ngt.requestLayout();
                        }
                    }
                });
                this.ngt.setDraweeSpanStringBuilder(cVar);
                int D = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.D(chatInfo.giftDisplayWidth) : C0824a.this.t;
                int D2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.D(chatInfo.giftDisplayHeight) : C0824a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.ngu.getLayoutParams();
                layoutParams.width = D;
                layoutParams.height = D2;
                this.ngu.setLayoutParams(layoutParams);
                this.ngu.g(chatInfo.mGift.icon, a.c.transparent, D, D2);
                this.ngu.setOnClickListener(C0824a.this.ngj);
                this.ngu.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.dKS().a(chatInfo.mCoolMessage.mBgImage, this.a, a.e.bg_bubble_default);
                    return;
                }
                this.a.setBackgroundResource(0);
                this.a.setPadding(tv.chushou.zues.utils.a.dip2px(C0824a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0824a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0824a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0824a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.ngt != null && ViewCompat.isAttachedToWindow(this.ngt)) {
                    this.ngt.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.ngt != null) {
                    this.ngt.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.ngt != null) {
                    this.ngt.removeCallbacks(runnable);
                }
            }
        }

        C0824a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.npN != null) {
                hashMap.put("_fbroomid", a.this.npN.mRoomID);
            }
            this.s = e.a(hashMap);
            this.ngh = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void ds(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0824a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.npN.mCreatorUID, C0824a.this.s);
                    }
                }
            };
            this.ngg = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void ds(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.npN == null || !chatInfo.mItem.mTargetKey.equals(a.this.npN.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0824a.this.b, chatInfo.mItem, C0824a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0824a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.npN.mCreatorUID, C0824a.this.s);
                    }
                }
            };
            this.ngi = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void ds(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.npN == null || !chatInfo.mItem.mTargetKey.equals(a.this.npN.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0824a.this.b, chatInfo.mItem, C0824a.this.s);
                        }
                    }
                }
            };
            this.ngj = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void ds(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0824a.this.s, a.this.npN.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.npU = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void ds(View view) {
                    com.kascend.chushou.d.a.a(C0824a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
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
            this.npV = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
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
                    return new C0826a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0826a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0826a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0826a c0826a = (C0826a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0826a.ngs != null) {
                                c0826a.ngs.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0826a.ngs != null) {
                            c0826a.ngs.setOnClickListener(null);
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
                        final C0826a c0826a = (C0826a) viewHolder;
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
                                if (!h.isEmpty(a.this.npN.mSystemAnnouncement)) {
                                    ArrayList<RichText> Tf = tv.chushou.zues.toolkit.richtext.b.Tf(a.this.npN.mSystemAnnouncement);
                                    if (h.isEmpty(Tf)) {
                                        cVar.a(a.this.npN.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, Tf, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0826a.ngs);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.npN.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0826a.ngs.setText(cVar);
                                c0826a.ngs.setOnClickListener(null);
                                c0826a.ngs.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0826a.ngs != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.neU.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0826a.ngs, c0826a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0826a.ngs, " : ", this.npV);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.ngh), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0826a.ngs, null, this.npV);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().ba(chatInfo.mCoolNickname.mFontColors).It(chatInfo.mCoolNickname.mNickName.length()).dBM());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0826a.ngs, " : ", this.npV)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.ngh), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.npV.Ro(chatInfo.mCoolContent.mContent), new c.a().ba(chatInfo.mCoolContent.mFontColors).It(chatInfo.mCoolContent.mContent.length()).dBM());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0826a.ngs, null, this.npV)) {
                                                cVar2.a(this.npV.Ro(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0826a.ngs != null) {
                                                c0826a.ngs.measure(0, 0);
                                                c0826a.ngs.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.ngg), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0826a.ngs.setDraweeSpanStringBuilder(cVar2);
                                    c0826a.ngs.setTag(a.f.tag_position, chatInfo);
                                    c0826a.ngs.setMovementMethod(tv.chushou.zues.widget.a.b.dXk());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dKS().a(chatInfo.mCoolMessage.mBgImage, c0826a.ngs, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0826a.ngs.setBackgroundResource(0);
                                    c0826a.ngs.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0826a.ngs != null) {
                                    c0826a.ngs.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0826a.ngs, c0826a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0826a.ngs, null, this.npV);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0826a.ngs, null, this.npV)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0826a.ngs != null) {
                                                        c0826a.ngs.measure(0, 0);
                                                        c0826a.ngs.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.ngi), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0826a.ngs.setDraweeSpanStringBuilder(cVar3);
                                            c0826a.ngs.setTag(a.f.tag_position, chatInfo2);
                                            c0826a.ngs.setMovementMethod(tv.chushou.zues.widget.a.b.dXk());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.dKS().a(chatInfo2.mCoolMessage.mBgImage, c0826a.ngs, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0826a.ngs.setBackgroundResource(0);
                                            c0826a.ngs.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0826a.ngs != null) {
                                    c0826a.ngs.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0826a.ngs, " : ", this.npV);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.ngh), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0826a.ngs, null, this.npV);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0826a.ngs)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.ngh), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0826a.ngs)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0826a.ngs, c0826a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.H == null) {
                                                a.this.H = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.H.containsKey(substring)) {
                                                drawable = (Drawable) a.this.H.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.H.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.H.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.H.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.H.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.ngg), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0826a.ngs.setDraweeSpanStringBuilder(cVar4);
                                    c0826a.ngs.setTag(a.f.tag_position, chatInfo3);
                                    c0826a.ngs.setMovementMethod(tv.chushou.zues.widget.a.b.dXk());
                                    c0826a.ngs.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dKS().a(chatInfo3.mCoolMessage.mBgImage, c0826a.ngs, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0826a.ngs.setBackgroundResource(0);
                                    c0826a.ngs.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
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
                        C0826a c0826a2 = (C0826a) viewHolder;
                        c0826a2.ngs.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.npU), new UnderlineSpan());
                        c0826a2.ngs.setDraweeSpanStringBuilder(cVar5);
                        c0826a2.ngs.setMovementMethod(tv.chushou.zues.widget.a.b.dXk());
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
                    cVar.a("", new b.a().a(callback).xe(true).Ky(i2).Kz(i3).Rt(str).Kx(i).g(simpleDraweeSpanTextView).dLs());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).Iq(i).dBB(), this.b);
                a.setController(com.facebook.drawee.a.a.c.dAa().QI(str).dAR());
                cVar.append("1");
                cVar.a(a, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b dJf;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (dJf = ((VideoPlayer) context).dJf()) != null && !h.isEmpty(dJf.a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", dJf.a);
                Http http = (Http) tv.chushou.basis.d.b.dWk().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
