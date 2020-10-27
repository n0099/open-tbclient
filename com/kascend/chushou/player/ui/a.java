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
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
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
/* loaded from: classes6.dex */
public class a extends Fragment implements View.OnClickListener {
    private View caa;
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private ArrayList<ChatInfo> i;
    private Button m;
    private View n;
    private View o;
    private RecyclerView piU;
    private RecyclerView.LayoutManager piW;
    private Animator piY;
    private Animator piZ;
    private Animator pja;
    private ShareDanmakuView pjb;
    private MicStatusView pjc;
    private EmbeddedButtonLayout pjd;
    private FoodView pje;
    private FoodView pjf;
    private com.kascend.chushou.player.ui.miniview.a pjg;
    private InteractNotifier pjh;
    private RedpacketNotifier pji;
    private FrescoThumbnailView pjj;
    private RoomInfo pjk;
    private HashMap<String, Drawable> pjl;
    private ScrollView pjn;
    private View q;
    private View r;
    private View u;
    private ValueAnimator y;

    /* renamed from: a  reason: collision with root package name */
    private Context f4145a = null;
    private View b = null;
    private b piV = null;
    private C0978a piX = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a pjm = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a Aw(boolean z) {
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
        this.f4145a = getActivity();
        tv.chushou.zues.a.a.register(this);
        if (arguments != null) {
            this.L = arguments.getBoolean("pkMode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(a.h.view_banrrage_page, viewGroup, false);
        this.piV = ((VideoPlayer) this.f4145a).eqv();
        if (this.piV != null) {
            this.pjk = this.piV.eqW();
        }
        this.f = new ArrayList<>();
        if (this.pjk != null) {
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
        this.pjh = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.pji = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.m = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.m.setOnClickListener(this);
        this.piU = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.piW = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.f4145a);
        this.piU.setLayoutManager(this.piW);
        this.piU.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.piU.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.piU.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
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
        this.piX = new C0978a(this.f4145a);
        this.piU.setAdapter(this.piX);
        this.piX.a(this.f.size());
        this.piX.notifyDataSetChanged();
        if (this.piV != null && (c = this.piV.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.pjc = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.pjc.setOnClickListener(this);
        this.pje = (FoodView) this.b.findViewById(a.f.top_ad);
        this.pjf = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.pjn = (ScrollView) this.b.findViewById(a.f.sv);
        this.pjd = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().Q(this.f4145a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.f4145a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().Q(this.f4145a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.f4145a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.caa = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.caa.findViewById(a.f.spash_sendgift);
        ((TextView) this.caa.findViewById(a.f.tv_reminder_sendgift)).setText(new c().Q(tv.chushou.basis.d.b.eDz(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.caa.setOnClickListener(this);
        this.pjb = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.pjb.a(getActivity(), ContextCompat.getColor(this.f4145a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.piX != null && a.this.piW != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.piX.a(a.this.f.size());
                    a.this.piX.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.m != null) {
                        a.this.m.setVisibility(8);
                    }
                    a.this.piW.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.piV != null ? this.piV.h : "");
        if (this.piV != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.f4145a;
            a(this.piV.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a eqF = videoPlayer.eqF();
            this.pjd.a(eqF.erZ());
            BangInfo esa = eqF.esa();
            if (esa != null) {
                this.pjd.a(esa, eqF.d());
            }
            this.pjd.b(this.piV.i());
            this.pjh.a(videoPlayer.eqC(), videoPlayer.eqD(), videoPlayer.eqE());
            this.pji.a(videoPlayer.eqB(), false);
            if (this.piV.pah != null && !h.isEmpty(this.piV.pah.mUrl)) {
                a(this.piV.pah);
            }
            if (this.pjk != null && !this.pjk.mIsSubscribed) {
                RxExecutor.postDelayed(this.pjm, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.pjk == null || !a.this.pjk.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.pjm, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.piV != null && !a.this.piV.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.piV.pap)) {
                this.pjd.a(this.piV.pap);
            }
        }
        if (this.pjk != null && !h.isEmpty(this.pjk.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.Yd(this.pjk.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.pjg == null) {
            this.pjg = new com.kascend.chushou.player.ui.miniview.a(this.f4145a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.pjg != null && a.this.b != null && a.this.pjg.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.pjg);
                        a.this.pjg = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.pjg);
            if (listItem.mAutoDisplay == 0) {
                this.pjg.setVisibility(8);
            } else {
                this.pjg.a(a.C0969a.slide_in_top_danmu_anim, a.C0969a.slide_out_top_danmu_anim, this.pjk == null ? "" : this.pjk.mRoomID);
            }
        } else if (!this.pjg.isShown()) {
            this.pjg.a(a.C0969a.slide_in_top_danmu_anim, a.C0969a.slide_out_top_danmu_anim, this.pjk == null ? "" : this.pjk.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.pjd.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.f4145a != null && this.b != null) {
            if (this.pjj == null) {
                this.pjj = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point hD = tv.chushou.zues.utils.a.hD(this.f4145a);
            int integer = (hD.y - ((hD.x * this.f4145a.getResources().getInteger(a.g.h_thumb_height_def)) / this.f4145a.getResources().getInteger(a.g.h_thumb_width_def))) - this.f4145a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.pjj.setVisibility(0);
            this.pjj.j(str, 0, hD.x, integer);
        }
    }

    public void a() {
        if (this.pjj != null) {
            this.pjj.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.pjg != null) {
            this.pjg.a(str);
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
        this.pjb.a();
        if (this.piY != null) {
            this.piY.removeAllListeners();
            this.piY.cancel();
            this.piY = null;
        }
        if (this.piZ != null) {
            this.piZ.removeAllListeners();
            this.piZ.cancel();
            this.piZ = null;
        }
        if (this.pja != null) {
            this.pja.removeAllListeners();
            this.pja.cancel();
            this.pja = null;
        }
        if (this.pjh != null) {
            this.pjh.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.pjm.dispose();
        super.onDestroy();
        k();
    }

    protected boolean b() {
        return this.f4145a == null || ((Activity) this.f4145a).isFinishing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_mic_status) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.btn_scrollbottom) {
            if (this.piU != null) {
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
            tv.chushou.zues.a.a.post(new i(53, this.f4145a.getResources().getString(a.i.hotword_1)));
            com.kascend.chushou.toolkit.a.c.a(this.f4145a, "双击666_num", null, new Object[0]);
        } else if (id == a.f.view_reminder_sendgift) {
            d(false);
            tv.chushou.zues.a.a.post(new i(56, null));
        }
    }

    public void a(long j) {
        if (this.pjh != null) {
            this.pjh.a(j);
        }
    }

    public void c() {
        if (this.pjh != null) {
            this.pjh.a();
        }
    }

    public void b(long j) {
        if (this.pjh != null) {
            this.pjh.b(j);
        }
    }

    public void a(int i) {
        if (this.pjh != null) {
            this.pjh.a(i);
        }
    }

    public void b(int i) {
        if (this.f4145a != null) {
            this.pji.a(((VideoPlayer) this.f4145a).eqB(), false);
        }
        this.pji.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.pjd != null) {
            this.pjd.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.pjd != null) {
            this.pjd.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pjd != null) {
            this.pjd.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.pjd != null) {
            this.pjd.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.pjd != null) {
            this.pjd.a(list);
        }
    }

    public void d() {
        if (this.piV.pag != null && this.pje != null) {
            this.pje.a(true, this.pjk == null ? "" : this.pjk.mRoomID);
            this.pje.a(this.piV.pag, a.C0969a.slide_in_top_danmu_anim, a.C0969a.slide_out_top_danmu_anim, false);
        }
        if (this.piV.paf != null && this.pjf != null) {
            this.pjf.a(this.piV.paf, a.C0969a.slide_in_bottom_danmu_anim, a.C0969a.slide_out_bottom_danmu_anim, true);
        }
        if (this.piV.pam != null && this.pjd != null) {
            this.pjd.a(this.piV.pam, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.piV != null) {
                        a.this.piV.pam = null;
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4145a, a.C0969a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.erX();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.pjm, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4145a, a.C0969a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.piZ != null) {
                        a.this.piZ.removeAllListeners();
                        a.this.piZ.cancel();
                        a.this.piZ = null;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f4145a, a.C0969a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.erW();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.pjm, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4145a, a.C0969a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.piY != null) {
                        a.this.piY.removeAllListeners();
                        a.this.piY.cancel();
                        a.this.piY = null;
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
    public Animator erW() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.piY != null) {
            this.piY.removeAllListeners();
            this.piY.cancel();
            this.piY = null;
        }
        this.o.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.o, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.o, 0.0f);
        int measuredWidth = (this.n.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.f4145a, 13.0f) * 2)) - this.o.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.o, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.o, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.piY != null) {
                    a.this.piY.removeAllListeners();
                    a.this.piY.cancel();
                    a.this.piY = null;
                }
                RxExecutor.postDelayed(a.this.pjm, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.erW();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.piY = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator erX() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.piZ != null) {
            this.piZ.removeAllListeners();
            this.piZ.cancel();
            this.piZ = null;
        }
        this.r.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.r, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.r, 0.0f);
        int measuredWidth = (this.q.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.f4145a, 13.0f) * 2)) - this.r.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.r, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.r, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.r, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.19
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.piZ != null) {
                    a.this.piZ.removeAllListeners();
                    a.this.piZ.cancel();
                    a.this.piZ = null;
                }
                RxExecutor.postDelayed(a.this.pjm, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.erX();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.piZ = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.caa != null && this.caa.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.eDz(), a.C0969a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.erY();
                    }
                });
                this.caa.setVisibility(0);
                this.caa.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.pjm, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.caa != null && this.caa.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.eDz(), a.C0969a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.pja != null) {
                        a.this.pja.removeAllListeners();
                        a.this.pja.cancel();
                        a.this.pja = null;
                    }
                    if (a.this.caa != null) {
                        a.this.caa.setVisibility(8);
                    }
                }
            });
            this.caa.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator erY() {
        if (this.caa == null || this.u == null) {
            return null;
        }
        if (this.pja != null) {
            this.pja.removeAllListeners();
            this.pja.cancel();
            this.pja = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.caa.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.eDz(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.pja != null) {
                    a.this.pja.removeAllListeners();
                    a.this.pja.cancel();
                    a.this.pja = null;
                }
                RxExecutor.postDelayed(a.this.pjm, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.erY();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pja = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.pjm, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.piX != null) {
                        a.this.piX.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.f4145a != null && !((Activity) this.f4145a).isFinishing() && pVar != null) {
            this.k = pVar.f4075a;
            if (this.k != null && this.k.contains("4") && this.pjb != null) {
                this.pjb.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.pjk != null && mVar.a(this.pjk.mCreatorUID, this.pjk.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.f4150a == 8 && this.pjg != null && this.pjg.getVisibility() != 0) {
            this.pjg.a(a.C0969a.slide_in_top_danmu_anim, a.C0969a.slide_out_top_danmu_anim, this.pjk == null ? "" : this.pjk.mRoomID);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!b()) {
            if (iVar.f4071a == 49) {
                if (!this.I && iVar.b != null) {
                    a(iVar.b.toString());
                }
            } else if (iVar.f4071a == 50 && !this.I && (iVar.b instanceof ListItem)) {
                ListItem listItem = (ListItem) iVar.b;
                if (!h.isEmpty(listItem.mUrl)) {
                    a(listItem);
                }
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!b() && this.pjk != null && !h.isEmpty(this.pjk.mRoomID) && this.pjk.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.pjg != null && this.pjg.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f);
                } else if (this.pjc != null && this.pjc.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 32.0f);
                }
                if (this.pje != null && this.pje.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pje.getHeight());
                }
                this.pjn.setTranslationY(r0);
                return;
            }
            if (this.y != null) {
                this.y.cancel();
                this.y = null;
            }
            int translationY = (int) this.pjn.getTranslationY();
            if (aVar.f4149a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4145a, 32.0f) : 0;
                if (this.pjg != null && this.pjg.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f);
                }
                if (this.pje != null && this.pje.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pje.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4145a, 64.0f));
                }
            } else if (2 == aVar.f4149a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4145a, 65.0f) : 0;
                if (this.pjg != null && this.pjg.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f);
                }
                if (this.pje != null && this.pje.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pje.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4145a, 64.0f));
                }
            } else if (3 == aVar.f4149a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f);
                } else if (this.pjc != null && this.pjc.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 32.0f);
                }
                if (this.pje != null && this.pje.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pje.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4145a, 64.0f));
                }
            } else if (5 == aVar.f4149a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 64.0f);
                    this.L = true;
                } else {
                    this.L = false;
                    if (this.pjc != null && this.pjc.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 32.0f);
                    }
                }
                if (this.pjg != null && this.pjg.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f);
                }
                if (this.pje != null && this.pje.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pje.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.pje.getHeight();
                if (this.pjg != null && this.pjg.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f));
                }
            } else {
                if (this.pjg != null && this.pjg.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 80.0f);
                } else if (this.pjc != null && this.pjc.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4145a, 32.0f);
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4145a, 64.0f));
                }
            }
            if (translationY != r0) {
                a(translationY, r0);
            }
        }
    }

    private void a(int i, int i2) {
        this.y = ValueAnimator.ofInt(i, i2);
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.player.ui.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!a.this.b() && a.this.pjn != null) {
                    a.this.pjn.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.y.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.y = null;
            }
        });
        this.y.setInterpolator(new LinearInterpolator());
        this.y.setDuration(800L);
        this.y.start();
    }

    public void a(MicStatus micStatus, List<FanItem> list, String str, boolean z) {
        if (this.pjc != null) {
            if (!this.pjc.isShown()) {
                if (this.piV != null && this.piV.eqU() != null && this.piV.eqU().mRoominfo != null) {
                    this.pjc.a(list, str, z, micStatus, this.piV.eqU().mRoominfo.mCreatorUID);
                    this.pjc.a(this.piV.eqU().mRoominfo.mRoomID);
                }
            } else if (this.piV != null && this.piV.eqU() != null && this.piV.eqU().mRoominfo != null) {
                this.pjc.a(list, str, z, micStatus, this.piV.eqU().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.pjc != null && this.pjc.isShown()) {
            this.pjc.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.piW.getChildCount();
        int itemCount = this.piW.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.piW);
        if (f + childCount >= itemCount) {
            this.l = true;
            if (this.m != null) {
                this.m.setVisibility(8);
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
        ArrayList<ChatInfo> a2 = a(this.h);
        if (a2 == null) {
            f(false);
            return;
        }
        this.f.addAll(a2);
        int size = this.f.size();
        if (size > 100) {
            for (int i = 2; i < size - 100 && i < this.f.size(); i++) {
                this.f.remove(2);
            }
        }
        f(z);
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
            if ((this.k == null || !this.k.contains("4")) && this.pjb != null) {
                this.pjb.a(list);
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
                    this.h.subList(0, size + AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL).clear();
                }
                ArrayList<ChatInfo> a2 = a(arrayList);
                int size2 = this.f.size();
                if (a2 != null) {
                    this.f.addAll(a2);
                }
                int size3 = this.f.size();
                if (!this.l && this.m != null) {
                    this.m.setVisibility(0);
                }
                if (!h.isEmpty(a2)) {
                    a(z2, 1, size2, a2.size());
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
                ArrayList<ChatInfo> a3 = a(arrayList);
                if (a3 != null) {
                    this.f.addAll(a3);
                }
            }
            f(z2);
        }
    }

    private void a(boolean z, int i, int i2, int i3) {
        if (!this.I) {
            if (this.piX != null) {
                this.piX.a(this.f.size());
                if (i == 1) {
                    this.piX.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.piX.notifyItemRangeRemoved(i2, i3);
                    this.piX.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.piX.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.piU.scrollToPosition(this.f.size() - 1);
                } else {
                    this.piU.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.piX != null) {
                this.piX.a(this.f.size());
                this.piX.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.piU.scrollToPosition(this.f.size() - 1);
                } else {
                    this.piU.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.ct(this);
        if (this.piX != null) {
            this.piX.a(0);
            this.piX = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.pjl != null) {
            this.pjl.clear();
            this.pjl = null;
        }
        this.f4145a = null;
        this.b = null;
        this.piU = null;
        this.m = null;
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.piX = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.piW = null;
        this.piV = null;
        this.pjk = null;
        this.pjc = null;
        if (this.pje != null) {
            this.pje.a();
        }
        if (this.pjf != null) {
            this.pjf.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.piV != null && this.piV.eqW() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.piV.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.piV.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.eqe().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet eB = com.kascend.chushou.c.a.eB(jSONObject);
                        if (eB.mRc == 0) {
                            g.N(a.this.f4145a, a.i.subscribe_success);
                            a.this.pjk.mIsSubscribed = true;
                            return;
                        }
                        a(eB.mRc, eB.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!a.this.b()) {
                        if (h.isEmpty(str2)) {
                            str2 = a.this.f4145a.getString(a.i.subscribe_failed);
                        }
                        g.d(a.this.f4145a, str2);
                    }
                }
            }, (String) null, this.pjk.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0978a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private final int n;
        private final int o;
        private tv.chushou.zues.a oZC;
        private tv.chushou.zues.a oZD;
        private tv.chushou.zues.a oZE;
        private tv.chushou.zues.a oZF;
        private final int p;
        private tv.chushou.zues.a pjs;
        private final tv.chushou.zues.toolkit.richtext.a pjt;
        private final int q;
        private final JSONObject s;
        private final int t;

        /* renamed from: a  reason: collision with root package name */
        protected int f4146a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.L(28.0f);
        private final int v = tv.chushou.widget.a.c.L(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes6.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView oZP;
            private ChatInfo oZT;

            c(View view) {
                super(view);
                this.oZP = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0978a.this.b.getString(a.i.videoplayer_danmaku_share)).Q(C0978a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0978a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b eqv;
                JSONObject jSONObject = null;
                if (this.oZT != null && this.oZT.mItem != null) {
                    String str = (!(C0978a.this.b instanceof VideoPlayer) || (eqv = ((VideoPlayer) C0978a.this.b).eqv()) == null) ? null : eqv.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0978a.this.b, this.oZT.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.oZT = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0978a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.oZP, null, C0978a.this.pjt)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.oZP.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0980a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView oZO;

            C0980a(View view) {
                super(view);
                this.oZO = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.oZO != null && ViewCompat.isAttachedToWindow(this.oZO)) {
                    this.oZO.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.oZO != null) {
                    this.oZO.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.oZO != null) {
                    this.oZO.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes6.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {

            /* renamed from: a  reason: collision with root package name */
            View f4148a;
            SimpleDraweeSpanTextView oZP;
            EmojiGiftView oZQ;

            b(View view) {
                super(view);
                this.f4148a = view;
                this.oZP = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.oZQ = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.oYq.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0978a.this.u, C0978a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0978a.this.a(this.oZP, this, cVar, str, a.e.default_medal_icon, C0978a.this.o, C0978a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0978a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0978a.this.b, a.c.banrrage_chat_name_color), this.oZP, " : ", C0978a.this.pjt);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0978a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0978a.this.b, a.c.kas_red_n), this.oZP)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0978a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0978a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.oZP.setMovementMethod(tv.chushou.zues.widget.a.b.eEy());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0978a.this.oZC), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.oZP.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.oZP != null) {
                            b.this.oZP.measure(0, 0);
                            b.this.oZP.requestLayout();
                        }
                    }
                });
                this.oZP.setDraweeSpanStringBuilder(cVar);
                int L = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.L(chatInfo.giftDisplayWidth) : C0978a.this.t;
                int L2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.L(chatInfo.giftDisplayHeight) : C0978a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.oZQ.getLayoutParams();
                layoutParams.width = L;
                layoutParams.height = L2;
                this.oZQ.setLayoutParams(layoutParams);
                this.oZQ.a(chatInfo.mGift.icon, a.c.transparent, L, L2);
                this.oZQ.setOnClickListener(C0978a.this.oZF);
                this.oZQ.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.esi().a(chatInfo.mCoolMessage.mBgImage, this.f4148a, a.e.bg_bubble_default);
                    return;
                }
                this.f4148a.setBackgroundResource(0);
                this.f4148a.setPadding(tv.chushou.zues.utils.a.dip2px(C0978a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0978a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0978a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0978a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.oZP != null && ViewCompat.isAttachedToWindow(this.oZP)) {
                    this.oZP.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.oZP != null) {
                    this.oZP.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.oZP != null) {
                    this.oZP.removeCallbacks(runnable);
                }
            }
        }

        C0978a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.pjk != null) {
                hashMap.put("_fbroomid", a.this.pjk.mRoomID);
            }
            this.s = e.a(hashMap);
            this.oZD = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void dX(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0978a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.pjk.mCreatorUID, C0978a.this.s);
                    }
                }
            };
            this.oZC = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void dX(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.pjk == null || !chatInfo.mItem.mTargetKey.equals(a.this.pjk.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0978a.this.b, chatInfo.mItem, C0978a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0978a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.pjk.mCreatorUID, C0978a.this.s);
                    }
                }
            };
            this.oZE = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void dX(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.pjk == null || !chatInfo.mItem.mTargetKey.equals(a.this.pjk.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0978a.this.b, chatInfo.mItem, C0978a.this.s);
                        }
                    }
                }
            };
            this.oZF = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void dX(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0978a.this.s, a.this.pjk.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.pjs = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void dX(View view) {
                    com.kascend.chushou.d.a.a(C0978a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
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
            this.pjt = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
            this.q = ContextCompat.getColor(this.b, a.c.videoplayer_share_danmaku);
        }

        public void a(int i) {
            this.f4146a = i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f4146a;
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
                    return new C0980a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0980a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0980a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0980a c0980a = (C0980a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0980a.oZO != null) {
                                c0980a.oZO.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0980a.oZO != null) {
                            c0980a.oZO.setOnClickListener(null);
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
                        final C0980a c0980a = (C0980a) viewHolder;
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
                                if (!h.isEmpty(a.this.pjk.mSystemAnnouncement)) {
                                    ArrayList<RichText> ZW = tv.chushou.zues.toolkit.richtext.b.ZW(a.this.pjk.mSystemAnnouncement);
                                    if (h.isEmpty(ZW)) {
                                        cVar.a(a.this.pjk.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, ZW, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0980a.oZO);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.pjk.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0980a.oZO.setText(cVar);
                                c0980a.oZO.setOnClickListener(null);
                                c0980a.oZO.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0980a.oZO != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.oYq.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0980a.oZO, c0980a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0980a.oZO, " : ", this.pjt);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.oZD), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0980a.oZO, null, this.pjt);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().bn(chatInfo.mCoolNickname.mFontColors).Ou(chatInfo.mCoolNickname.mNickName.length()).eiO());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0980a.oZO, " : ", this.pjt)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.oZD), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.pjt.Yg(chatInfo.mCoolContent.mContent), new c.a().bn(chatInfo.mCoolContent.mFontColors).Ou(chatInfo.mCoolContent.mContent.length()).eiO());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0980a.oZO, null, this.pjt)) {
                                                cVar2.a(this.pjt.Yg(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0980a.oZO != null) {
                                                c0980a.oZO.measure(0, 0);
                                                c0980a.oZO.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.oZC), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0980a.oZO.setDraweeSpanStringBuilder(cVar2);
                                    c0980a.oZO.setTag(a.f.tag_position, chatInfo);
                                    c0980a.oZO.setMovementMethod(tv.chushou.zues.widget.a.b.eEy());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.esi().a(chatInfo.mCoolMessage.mBgImage, c0980a.oZO, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0980a.oZO.setBackgroundResource(0);
                                    c0980a.oZO.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0980a.oZO != null) {
                                    c0980a.oZO.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0980a.oZO, c0980a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0980a.oZO, null, this.pjt);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0980a.oZO, null, this.pjt)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0980a.oZO != null) {
                                                        c0980a.oZO.measure(0, 0);
                                                        c0980a.oZO.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.oZE), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0980a.oZO.setDraweeSpanStringBuilder(cVar3);
                                            c0980a.oZO.setTag(a.f.tag_position, chatInfo2);
                                            c0980a.oZO.setMovementMethod(tv.chushou.zues.widget.a.b.eEy());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.esi().a(chatInfo2.mCoolMessage.mBgImage, c0980a.oZO, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0980a.oZO.setBackgroundResource(0);
                                            c0980a.oZO.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0980a.oZO != null) {
                                    c0980a.oZO.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0980a.oZO, " : ", this.pjt);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.oZD), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0980a.oZO, null, this.pjt);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0980a.oZO)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.oZD), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0980a.oZO)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0980a.oZO, c0980a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.pjl == null) {
                                                a.this.pjl = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.pjl.containsKey(substring)) {
                                                drawable = (Drawable) a.this.pjl.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.pjl.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.pjl.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.pjl.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.pjl.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.oZC), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0980a.oZO.setDraweeSpanStringBuilder(cVar4);
                                    c0980a.oZO.setTag(a.f.tag_position, chatInfo3);
                                    c0980a.oZO.setMovementMethod(tv.chushou.zues.widget.a.b.eEy());
                                    c0980a.oZO.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.esi().a(chatInfo3.mCoolMessage.mBgImage, c0980a.oZO, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0980a.oZO.setBackgroundResource(0);
                                    c0980a.oZO.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
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
                        C0980a c0980a2 = (C0980a) viewHolder;
                        c0980a2.oZO.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.pjs), new UnderlineSpan());
                        c0980a2.oZO.setDraweeSpanStringBuilder(cVar5);
                        c0980a2.oZO.setMovementMethod(tv.chushou.zues.widget.a.b.eEy());
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
                    cVar.a("", new b.a().a(callback).AA(true).Qy(i2).Qz(i3).Yl(str).Qx(i).h(simpleDraweeSpanTextView).esI());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).Or(i).eiD(), this.b);
                a2.setController(com.facebook.drawee.a.a.c.ehd().XA(str).ehU());
                cVar.append("1");
                cVar.a(a2, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b eqv;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (eqv = ((VideoPlayer) context).eqv()) != null && !h.isEmpty(eqv.f4117a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", eqv.f4117a);
                Http http = (Http) tv.chushou.basis.d.b.eDB().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
