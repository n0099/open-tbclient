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
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private InteractNotifier mSA;
    private RedpacketNotifier mSB;
    private FrescoThumbnailView mSD;
    private RoomInfo mSE;
    private HashMap<String, Drawable> mSF;
    private ScrollView mSH;
    private RecyclerView mSi;
    private RecyclerView.LayoutManager mSk;
    private ArrayList<ChatInfo> mSl;
    private Button mSn;
    private Animator mSo;
    private Animator mSq;
    private View mSr;
    private Animator mSs;
    private ShareDanmakuView mSt;
    private MicStatusView mSu;
    private ValueAnimator mSv;
    private EmbeddedButtonLayout mSw;
    private FoodView mSx;
    private FoodView mSy;
    private com.kascend.chushou.player.ui.miniview.a mSz;
    private View n;
    private View o;
    private View q;
    private View r;
    private View u;
    private Context a = null;
    private View b = null;
    private b mSj = null;
    private C0803a mSm = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a mSG = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a wD(boolean z) {
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
        this.mSj = ((VideoPlayer) this.a).dEl();
        if (this.mSj != null) {
            this.mSE = this.mSj.dEO();
        }
        this.f = new ArrayList<>();
        if (this.mSE != null) {
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
        this.mSA = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.mSB = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.mSn = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.mSn.setOnClickListener(this);
        this.mSi = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.mSk = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.a);
        this.mSi.setLayoutManager(this.mSk);
        this.mSi.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.mSi.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.mSi.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
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
        this.mSm = new C0803a(this.a);
        this.mSi.setAdapter(this.mSm);
        this.mSm.a(this.f.size());
        this.mSm.notifyDataSetChanged();
        if (this.mSj != null && (c = this.mSj.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.mSu = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.mSu.setOnClickListener(this);
        this.mSx = (FoodView) this.b.findViewById(a.f.top_ad);
        this.mSy = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.mSH = (ScrollView) this.b.findViewById(a.f.sv);
        this.mSw = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().J(this.a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().J(this.a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.mSr = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.mSr.findViewById(a.f.spash_sendgift);
        ((TextView) this.mSr.findViewById(a.f.tv_reminder_sendgift)).setText(new c().J(tv.chushou.basis.d.b.dRk(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.mSr.setOnClickListener(this);
        this.mSt = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.mSt.a(getActivity(), ContextCompat.getColor(this.a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.mSm != null && a.this.mSk != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.mSm.a(a.this.f.size());
                    a.this.mSm.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.mSn != null) {
                        a.this.mSn.setVisibility(8);
                    }
                    a.this.mSk.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.mSj != null ? this.mSj.h : "");
        if (this.mSj != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.a;
            a(this.mSj.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a dEv = videoPlayer.dEv();
            this.mSw.a(dEv.dFL());
            BangInfo dFM = dEv.dFM();
            if (dFM != null) {
                this.mSw.a(dFM, dEv.d());
            }
            this.mSw.b(this.mSj.dEN());
            this.mSA.a(videoPlayer.dEs(), videoPlayer.dEt(), videoPlayer.dEu());
            this.mSB.a(videoPlayer.dEr(), false);
            if (this.mSj.mJz != null && !h.isEmpty(this.mSj.mJz.mUrl)) {
                a(this.mSj.mJz);
            }
            if (this.mSE != null && !this.mSE.mIsSubscribed) {
                RxExecutor.postDelayed(this.mSG, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.mSE == null || !a.this.mSE.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.mSG, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mSj != null && !a.this.mSj.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.mSj.mJG)) {
                this.mSw.a(this.mSj.mJG);
            }
        }
        if (this.mSE != null && !h.isEmpty(this.mSE.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.Qx(this.mSE.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.mSz == null) {
            this.mSz = new com.kascend.chushou.player.ui.miniview.a(this.a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.mSz != null && a.this.b != null && a.this.mSz.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.mSz);
                        a.this.mSz = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.mSz);
            if (listItem.mAutoDisplay == 0) {
                this.mSz.setVisibility(8);
            } else {
                this.mSz.a(a.C0794a.slide_in_top_danmu_anim, a.C0794a.slide_out_top_danmu_anim, this.mSE == null ? "" : this.mSE.mRoomID);
            }
        } else if (!this.mSz.isShown()) {
            this.mSz.a(a.C0794a.slide_in_top_danmu_anim, a.C0794a.slide_out_top_danmu_anim, this.mSE == null ? "" : this.mSE.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.mSw.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.a != null && this.b != null) {
            if (this.mSD == null) {
                this.mSD = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point gv = tv.chushou.zues.utils.a.gv(this.a);
            int integer = (gv.y - ((gv.x * this.a.getResources().getInteger(a.g.h_thumb_height_def)) / this.a.getResources().getInteger(a.g.h_thumb_width_def))) - this.a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.mSD.setVisibility(0);
            this.mSD.i(str, 0, gv.x, integer);
        }
    }

    public void a() {
        if (this.mSD != null) {
            this.mSD.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.mSz != null) {
            this.mSz.a(str);
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
        this.mSt.a();
        if (this.mSo != null) {
            this.mSo.removeAllListeners();
            this.mSo.cancel();
            this.mSo = null;
        }
        if (this.mSq != null) {
            this.mSq.removeAllListeners();
            this.mSq.cancel();
            this.mSq = null;
        }
        if (this.mSs != null) {
            this.mSs.removeAllListeners();
            this.mSs.cancel();
            this.mSs = null;
        }
        if (this.mSA != null) {
            this.mSA.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.mSG.dispose();
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
            if (this.mSi != null) {
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
        if (this.mSA != null) {
            this.mSA.a(j);
        }
    }

    public void c() {
        if (this.mSA != null) {
            this.mSA.a();
        }
    }

    public void b(long j) {
        if (this.mSA != null) {
            this.mSA.b(j);
        }
    }

    public void a(int i) {
        if (this.mSA != null) {
            this.mSA.a(i);
        }
    }

    public void b(int i) {
        if (this.a != null) {
            this.mSB.a(((VideoPlayer) this.a).dEr(), false);
        }
        this.mSB.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.mSw != null) {
            this.mSw.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.mSw != null) {
            this.mSw.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mSw != null) {
            this.mSw.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.mSw != null) {
            this.mSw.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.mSw != null) {
            this.mSw.a(list);
        }
    }

    public void d() {
        if (this.mSj.mJy != null && this.mSx != null) {
            this.mSx.a(true, this.mSE == null ? "" : this.mSE.mRoomID);
            this.mSx.a(this.mSj.mJy, a.C0794a.slide_in_top_danmu_anim, a.C0794a.slide_out_top_danmu_anim, false);
        }
        if (this.mSj.mJx != null && this.mSy != null) {
            this.mSy.a(this.mSj.mJx, a.C0794a.slide_in_bottom_danmu_anim, a.C0794a.slide_out_bottom_danmu_anim, true);
        }
        if (this.mSj.mJE != null && this.mSw != null) {
            this.mSw.a(this.mSj.mJE, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.mSj != null) {
                        a.this.mSj.mJE = null;
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0794a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.dFJ();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.mSG, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0794a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.mSq != null) {
                        a.this.mSq.removeAllListeners();
                        a.this.mSq.cancel();
                        a.this.mSq = null;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this.a, a.C0794a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dFI();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mSG, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a, a.C0794a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.mSo != null) {
                        a.this.mSo.removeAllListeners();
                        a.this.mSo.cancel();
                        a.this.mSo = null;
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
    public Animator dFI() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.mSo != null) {
            this.mSo.removeAllListeners();
            this.mSo.cancel();
            this.mSo = null;
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
                if (a.this.mSo != null) {
                    a.this.mSo.removeAllListeners();
                    a.this.mSo.cancel();
                    a.this.mSo = null;
                }
                RxExecutor.postDelayed(a.this.mSG, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dFI();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mSo = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFJ() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.mSq != null) {
            this.mSq.removeAllListeners();
            this.mSq.cancel();
            this.mSq = null;
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
                if (a.this.mSq != null) {
                    a.this.mSq.removeAllListeners();
                    a.this.mSq.cancel();
                    a.this.mSq = null;
                }
                RxExecutor.postDelayed(a.this.mSG, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dFJ();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mSq = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.mSr != null && this.mSr.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.dRk(), a.C0794a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dFK();
                    }
                });
                this.mSr.setVisibility(0);
                this.mSr.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.mSG, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.mSr != null && this.mSr.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.dRk(), a.C0794a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.mSs != null) {
                        a.this.mSs.removeAllListeners();
                        a.this.mSs.cancel();
                        a.this.mSs = null;
                    }
                    if (a.this.mSr != null) {
                        a.this.mSr.setVisibility(8);
                    }
                }
            });
            this.mSr.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator dFK() {
        if (this.mSr == null || this.u == null) {
            return null;
        }
        if (this.mSs != null) {
            this.mSs.removeAllListeners();
            this.mSs.cancel();
            this.mSs = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.mSr.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.dRk(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.mSs != null) {
                    a.this.mSs.removeAllListeners();
                    a.this.mSs.cancel();
                    a.this.mSs = null;
                }
                RxExecutor.postDelayed(a.this.mSG, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dFK();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.mSs = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.mSG, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mSm != null) {
                        a.this.mSm.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.a != null && !((Activity) this.a).isFinishing() && pVar != null) {
            this.k = pVar.a;
            if (this.k != null && this.k.contains("4") && this.mSt != null) {
                this.mSt.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.mSE != null && mVar.a(this.mSE.mCreatorUID, this.mSE.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.a == 8 && this.mSz != null && this.mSz.getVisibility() != 0) {
            this.mSz.a(a.C0794a.slide_in_top_danmu_anim, a.C0794a.slide_out_top_danmu_anim, this.mSE == null ? "" : this.mSE.mRoomID);
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
        if (!b() && this.mSE != null && !h.isEmpty(this.mSE.mRoomID) && this.mSE.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.mSz != null && this.mSz.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.mSu != null && this.mSu.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.mSx != null && this.mSx.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mSx.getHeight());
                }
                this.mSH.setTranslationY(r0);
                return;
            }
            if (this.mSv != null) {
                this.mSv.cancel();
                this.mSv = null;
            }
            int translationY = (int) this.mSH.getTranslationY();
            if (aVar.a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 32.0f) : 0;
                if (this.mSz != null && this.mSz.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.mSx != null && this.mSx.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mSx.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (2 == aVar.a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.a, 65.0f) : 0;
                if (this.mSz != null && this.mSz.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.mSx != null && this.mSx.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mSx.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 64.0f));
                }
            } else if (3 == aVar.a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.mSu != null && this.mSu.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                }
                if (this.mSx != null && this.mSx.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mSx.getHeight());
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
                    if (this.mSu != null && this.mSu.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.a, 32.0f);
                    }
                }
                if (this.mSz != null && this.mSz.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                }
                if (this.mSx != null && this.mSx.getVisibility() == 0) {
                    r0 = Math.max(r0, this.mSx.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.mSx.getHeight();
                if (this.mSz != null && this.mSz.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.a, 80.0f));
                }
            } else {
                if (this.mSz != null && this.mSz.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.a, 80.0f);
                } else if (this.mSu != null && this.mSu.getVisibility() == 0) {
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
        this.mSv = ValueAnimator.ofInt(i, i2);
        this.mSv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!a.this.b() && a.this.mSH != null) {
                    a.this.mSH.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mSv.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.mSv = null;
            }
        });
        this.mSv.setInterpolator(new LinearInterpolator());
        this.mSv.setDuration(800L);
        this.mSv.start();
    }

    public void a(MicStatus micStatus, List<FanItem> list, String str, boolean z) {
        if (this.mSu != null) {
            if (!this.mSu.isShown()) {
                if (this.mSj != null && this.mSj.dEL() != null && this.mSj.dEL().mRoominfo != null) {
                    this.mSu.a(list, str, z, micStatus, this.mSj.dEL().mRoominfo.mCreatorUID);
                    this.mSu.a(this.mSj.dEL().mRoominfo.mRoomID);
                }
            } else if (this.mSj != null && this.mSj.dEL() != null && this.mSj.dEL().mRoominfo != null) {
                this.mSu.a(list, str, z, micStatus, this.mSj.dEL().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.mSu != null && this.mSu.isShown()) {
            this.mSu.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.mSk.getChildCount();
        int itemCount = this.mSk.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.mSk);
        if (f + childCount >= itemCount) {
            this.l = true;
            if (this.mSn != null) {
                this.mSn.setVisibility(8);
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
        if (this.mSl == null) {
            this.mSl = new ArrayList<>();
        }
        this.mSl.clear();
        if (arrayList != null && arrayList.size() > 0) {
            if (this.k != null && this.k.size() != 0) {
                Iterator<ChatInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatInfo next = it.next();
                    if ("2".equals(next.mType) && (!next.mFilter || !this.k.contains("2"))) {
                        this.mSl.add(next);
                    } else if (!this.k.contains(next.mType)) {
                        this.mSl.add(next);
                    }
                }
                return this.mSl;
            }
            return arrayList;
        }
        return null;
    }

    public void c(List<ChatInfo> list) {
        if (!h.isEmpty(list)) {
            if ((this.k == null || !this.k.contains("4")) && this.mSt != null) {
                this.mSt.a(list);
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
                if (!this.l && this.mSn != null) {
                    this.mSn.setVisibility(0);
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
            if (this.mSm != null) {
                this.mSm.a(this.f.size());
                if (i == 1) {
                    this.mSm.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.mSm.notifyItemRangeRemoved(i2, i3);
                    this.mSm.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.mSm.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.mSn != null) {
                    this.mSn.setVisibility(8);
                }
                if (z) {
                    this.mSi.scrollToPosition(this.f.size() - 1);
                } else {
                    this.mSi.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.mSm != null) {
                this.mSm.a(this.f.size());
                this.mSm.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.mSn != null) {
                    this.mSn.setVisibility(8);
                }
                if (z) {
                    this.mSi.scrollToPosition(this.f.size() - 1);
                } else {
                    this.mSi.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.ch(this);
        if (this.mSm != null) {
            this.mSm.a(0);
            this.mSm = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.mSF != null) {
            this.mSF.clear();
            this.mSF = null;
        }
        this.a = null;
        this.b = null;
        this.mSi = null;
        this.mSn = null;
        if (this.mSl != null) {
            this.mSl.clear();
            this.mSl = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.mSm = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.mSk = null;
        this.mSj = null;
        this.mSE = null;
        this.mSu = null;
        if (this.mSx != null) {
            this.mSx.a();
        }
        if (this.mSy != null) {
            this.mSy.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.mSj != null && this.mSj.dEO() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.mSj.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.mSj.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.dDV().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet dF = com.kascend.chushou.c.a.dF(jSONObject);
                        if (dF.mRc == 0) {
                            g.F(a.this.a, a.i.subscribe_success);
                            a.this.mSE.mIsSubscribed = true;
                            return;
                        }
                        a(dF.mRc, dF.mMessage);
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
            }, (String) null, this.mSE.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0803a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private tv.chushou.zues.a mIV;
        private tv.chushou.zues.a mIW;
        private tv.chushou.zues.a mIX;
        private tv.chushou.zues.a mIY;
        private tv.chushou.zues.a mSM;
        private final tv.chushou.zues.toolkit.richtext.a mSN;
        private final int n;
        private final int o;
        private final int p;
        private final int q;
        private final JSONObject s;
        private final int t;
        protected int a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.B(28.0f);
        private final int v = tv.chushou.widget.a.c.B(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes5.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView mJi;
            private ChatInfo mJm;

            c(View view) {
                super(view);
                this.mJi = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0803a.this.b.getString(a.i.videoplayer_danmaku_share)).J(C0803a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0803a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b dEl;
                JSONObject jSONObject = null;
                if (this.mJm != null && this.mJm.mItem != null) {
                    String str = (!(C0803a.this.b instanceof VideoPlayer) || (dEl = ((VideoPlayer) C0803a.this.b).dEl()) == null) ? null : dEl.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0803a.this.b, this.mJm.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.mJm = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0803a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.mJi, null, C0803a.this.mSN)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.mJi.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0805a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView mJh;

            C0805a(View view) {
                super(view);
                this.mJh = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.mJh != null && ViewCompat.isAttachedToWindow(this.mJh)) {
                    this.mJh.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.mJh != null) {
                    this.mJh.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.mJh != null) {
                    this.mJh.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes5.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {
            View a;
            SimpleDraweeSpanTextView mJi;
            EmojiGiftView mJj;

            b(View view) {
                super(view);
                this.a = view;
                this.mJi = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.mJj = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.mHE.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0803a.this.u, C0803a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0803a.this.a(this.mJi, this, cVar, str, a.e.default_medal_icon, C0803a.this.o, C0803a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0803a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0803a.this.b, a.c.banrrage_chat_name_color), this.mJi, " : ", C0803a.this.mSN);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0803a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0803a.this.b, a.c.kas_red_n), this.mJi)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0803a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0803a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.mJi.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0803a.this.mIV), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.mJi.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.mJi != null) {
                            b.this.mJi.measure(0, 0);
                            b.this.mJi.requestLayout();
                        }
                    }
                });
                this.mJi.setDraweeSpanStringBuilder(cVar);
                int B = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.B(chatInfo.giftDisplayWidth) : C0803a.this.t;
                int B2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.B(chatInfo.giftDisplayHeight) : C0803a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.mJj.getLayoutParams();
                layoutParams.width = B;
                layoutParams.height = B2;
                this.mJj.setLayoutParams(layoutParams);
                this.mJj.g(chatInfo.mGift.icon, a.c.transparent, B, B2);
                this.mJj.setOnClickListener(C0803a.this.mIY);
                this.mJj.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo.mCoolMessage.mBgImage, this.a, a.e.bg_bubble_default);
                    return;
                }
                this.a.setBackgroundResource(0);
                this.a.setPadding(tv.chushou.zues.utils.a.dip2px(C0803a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0803a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0803a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0803a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.mJi != null && ViewCompat.isAttachedToWindow(this.mJi)) {
                    this.mJi.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.mJi != null) {
                    this.mJi.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.mJi != null) {
                    this.mJi.removeCallbacks(runnable);
                }
            }
        }

        C0803a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.mSE != null) {
                hashMap.put("_fbroomid", a.this.mSE.mRoomID);
            }
            this.s = e.a(hashMap);
            this.mIW = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0803a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.mSE.mCreatorUID, C0803a.this.s);
                    }
                }
            };
            this.mIV = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.mSE == null || !chatInfo.mItem.mTargetKey.equals(a.this.mSE.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0803a.this.b, chatInfo.mItem, C0803a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0803a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.mSE.mCreatorUID, C0803a.this.s);
                    }
                }
            };
            this.mIX = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.mSE == null || !chatInfo.mItem.mTargetKey.equals(a.this.mSE.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0803a.this.b, chatInfo.mItem, C0803a.this.s);
                        }
                    }
                }
            };
            this.mIY = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0803a.this.s, a.this.mSE.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.mSM = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void dr(View view) {
                    com.kascend.chushou.d.a.a(C0803a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
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
            this.mSN = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
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
                    return new C0805a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0805a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0805a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0805a c0805a = (C0805a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0805a.mJh != null) {
                                c0805a.mJh.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0805a.mJh != null) {
                            c0805a.mJh.setOnClickListener(null);
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
                        final C0805a c0805a = (C0805a) viewHolder;
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
                                if (!h.isEmpty(a.this.mSE.mSystemAnnouncement)) {
                                    ArrayList<RichText> Sr = tv.chushou.zues.toolkit.richtext.b.Sr(a.this.mSE.mSystemAnnouncement);
                                    if (h.isEmpty(Sr)) {
                                        cVar.a(a.this.mSE.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, Sr, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0805a.mJh);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.mSE.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0805a.mJh.setText(cVar);
                                c0805a.mJh.setOnClickListener(null);
                                c0805a.mJh.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0805a.mJh != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.mHE.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0805a.mJh, c0805a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0805a.mJh, " : ", this.mSN);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mIW), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0805a.mJh, null, this.mSN);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().aZ(chatInfo.mCoolNickname.mFontColors).Hk(chatInfo.mCoolNickname.mNickName.length()).dwS());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0805a.mJh, " : ", this.mSN)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mIW), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.mSN.QA(chatInfo.mCoolContent.mContent), new c.a().aZ(chatInfo.mCoolContent.mFontColors).Hk(chatInfo.mCoolContent.mContent.length()).dwS());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0805a.mJh, null, this.mSN)) {
                                                cVar2.a(this.mSN.QA(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0805a.mJh != null) {
                                                c0805a.mJh.measure(0, 0);
                                                c0805a.mJh.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.mIV), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0805a.mJh.setDraweeSpanStringBuilder(cVar2);
                                    c0805a.mJh.setTag(a.f.tag_position, chatInfo);
                                    c0805a.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo.mCoolMessage.mBgImage, c0805a.mJh, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0805a.mJh.setBackgroundResource(0);
                                    c0805a.mJh.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0805a.mJh != null) {
                                    c0805a.mJh.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0805a.mJh, c0805a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0805a.mJh, null, this.mSN);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0805a.mJh, null, this.mSN)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0805a.mJh != null) {
                                                        c0805a.mJh.measure(0, 0);
                                                        c0805a.mJh.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.mIX), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0805a.mJh.setDraweeSpanStringBuilder(cVar3);
                                            c0805a.mJh.setTag(a.f.tag_position, chatInfo2);
                                            c0805a.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo2.mCoolMessage.mBgImage, c0805a.mJh, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0805a.mJh.setBackgroundResource(0);
                                            c0805a.mJh.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0805a.mJh != null) {
                                    c0805a.mJh.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0805a.mJh, " : ", this.mSN);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mIW), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0805a.mJh, null, this.mSN);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0805a.mJh)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mIW), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0805a.mJh)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0805a.mJh, c0805a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.mSF == null) {
                                                a.this.mSF = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.mSF.containsKey(substring)) {
                                                drawable = (Drawable) a.this.mSF.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.mSF.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.mSF.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.mSF.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.mSF.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.mIV), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0805a.mJh.setDraweeSpanStringBuilder(cVar4);
                                    c0805a.mJh.setTag(a.f.tag_position, chatInfo3);
                                    c0805a.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
                                    c0805a.mJh.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.dFU().a(chatInfo3.mCoolMessage.mBgImage, c0805a.mJh, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0805a.mJh.setBackgroundResource(0);
                                    c0805a.mJh.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
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
                        C0805a c0805a2 = (C0805a) viewHolder;
                        c0805a2.mJh.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.mSM), new UnderlineSpan());
                        c0805a2.mJh.setDraweeSpanStringBuilder(cVar5);
                        c0805a2.mJh.setMovementMethod(tv.chushou.zues.widget.a.b.dSm());
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
                    cVar.a("", new b.a().a(callback).wH(true).Jp(i2).Jq(i3).QF(str).Jo(i).g(simpleDraweeSpanTextView).dGu());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).Hh(i).dwG(), this.b);
                a.setController(com.facebook.drawee.a.a.c.dvf().PU(str).dvW());
                cVar.append("1");
                cVar.a(a, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b dEl;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (dEl = ((VideoPlayer) context).dEl()) != null && !h.isEmpty(dEl.a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", dEl.a);
                Http http = (Http) tv.chushou.basis.d.b.dRm().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
