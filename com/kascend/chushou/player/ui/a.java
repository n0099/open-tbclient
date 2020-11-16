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
    private View ceb;
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private ArrayList<ChatInfo> i;
    private Button m;
    private View n;
    private View o;
    private RecyclerView ptW;
    private RecyclerView.LayoutManager ptY;
    private Animator pua;
    private Animator pub;
    private Animator puc;
    private ShareDanmakuView pud;
    private MicStatusView pue;
    private EmbeddedButtonLayout puf;
    private FoodView pug;
    private FoodView puh;
    private com.kascend.chushou.player.ui.miniview.a pui;
    private InteractNotifier puj;
    private RedpacketNotifier puk;
    private FrescoThumbnailView pul;
    private RoomInfo pum;
    private HashMap<String, Drawable> pun;
    private ScrollView pup;
    private View q;
    private View r;
    private View u;
    private ValueAnimator y;

    /* renamed from: a  reason: collision with root package name */
    private Context f4147a = null;
    private View b = null;
    private b ptX = null;
    private C1000a ptZ = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a puo = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a AO(boolean z) {
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
        this.f4147a = getActivity();
        tv.chushou.zues.a.a.register(this);
        if (arguments != null) {
            this.L = arguments.getBoolean("pkMode");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(a.h.view_banrrage_page, viewGroup, false);
        this.ptX = ((VideoPlayer) this.f4147a).euk();
        if (this.ptX != null) {
            this.pum = this.ptX.euL();
        }
        this.f = new ArrayList<>();
        if (this.pum != null) {
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
        this.puj = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.puk = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.m = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.m.setOnClickListener(this);
        this.ptW = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.ptY = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.f4147a);
        this.ptW.setLayoutManager(this.ptY);
        this.ptW.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.ptW.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.ptW.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
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
        this.ptZ = new C1000a(this.f4147a);
        this.ptW.setAdapter(this.ptZ);
        this.ptZ.a(this.f.size());
        this.ptZ.notifyDataSetChanged();
        if (this.ptX != null && (c = this.ptX.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.pue = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.pue.setOnClickListener(this);
        this.pug = (FoodView) this.b.findViewById(a.f.top_ad);
        this.puh = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.pup = (ScrollView) this.b.findViewById(a.f.sv);
        this.puf = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().R(this.f4147a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.f4147a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().R(this.f4147a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.f4147a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.ceb = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.ceb.findViewById(a.f.spash_sendgift);
        ((TextView) this.ceb.findViewById(a.f.tv_reminder_sendgift)).setText(new c().R(tv.chushou.basis.d.b.eHp(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.ceb.setOnClickListener(this);
        this.pud = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.pud.a(getActivity(), ContextCompat.getColor(this.f4147a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.ptZ != null && a.this.ptY != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.ptZ.a(a.this.f.size());
                    a.this.ptZ.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.m != null) {
                        a.this.m.setVisibility(8);
                    }
                    a.this.ptY.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.ptX != null ? this.ptX.h : "");
        if (this.ptX != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.f4147a;
            a(this.ptX.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a euu = videoPlayer.euu();
            this.puf.a(euu.evO());
            BangInfo evP = euu.evP();
            if (evP != null) {
                this.puf.a(evP, euu.d());
            }
            this.puf.b(this.ptX.i());
            this.puj.a(videoPlayer.eur(), videoPlayer.eus(), videoPlayer.eut());
            this.puk.a(videoPlayer.euq(), false);
            if (this.ptX.pli != null && !h.isEmpty(this.ptX.pli.mUrl)) {
                a(this.ptX.pli);
            }
            if (this.pum != null && !this.pum.mIsSubscribed) {
                RxExecutor.postDelayed(this.puo, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.pum == null || !a.this.pum.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.puo, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ptX != null && !a.this.ptX.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.ptX.plq)) {
                this.puf.a(this.ptX.plq);
            }
        }
        if (this.pum != null && !h.isEmpty(this.pum.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.Ys(this.pum.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.pui == null) {
            this.pui = new com.kascend.chushou.player.ui.miniview.a(this.f4147a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.pui != null && a.this.b != null && a.this.pui.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.pui);
                        a.this.pui = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.pui);
            if (listItem.mAutoDisplay == 0) {
                this.pui.setVisibility(8);
            } else {
                this.pui.a(a.C0991a.slide_in_top_danmu_anim, a.C0991a.slide_out_top_danmu_anim, this.pum == null ? "" : this.pum.mRoomID);
            }
        } else if (!this.pui.isShown()) {
            this.pui.a(a.C0991a.slide_in_top_danmu_anim, a.C0991a.slide_out_top_danmu_anim, this.pum == null ? "" : this.pum.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.puf.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.f4147a != null && this.b != null) {
            if (this.pul == null) {
                this.pul = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point hB = tv.chushou.zues.utils.a.hB(this.f4147a);
            int integer = (hB.y - ((hB.x * this.f4147a.getResources().getInteger(a.g.h_thumb_height_def)) / this.f4147a.getResources().getInteger(a.g.h_thumb_width_def))) - this.f4147a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.pul.setVisibility(0);
            this.pul.i(str, 0, hB.x, integer);
        }
    }

    public void a() {
        if (this.pul != null) {
            this.pul.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.pui != null) {
            this.pui.a(str);
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
        this.pud.a();
        if (this.pua != null) {
            this.pua.removeAllListeners();
            this.pua.cancel();
            this.pua = null;
        }
        if (this.pub != null) {
            this.pub.removeAllListeners();
            this.pub.cancel();
            this.pub = null;
        }
        if (this.puc != null) {
            this.puc.removeAllListeners();
            this.puc.cancel();
            this.puc = null;
        }
        if (this.puj != null) {
            this.puj.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.puo.dispose();
        super.onDestroy();
        k();
    }

    protected boolean b() {
        return this.f4147a == null || ((Activity) this.f4147a).isFinishing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.rl_mic_status) {
            tv.chushou.zues.a.a.post(new com.kascend.chushou.b.a.a.a());
        } else if (id == a.f.btn_scrollbottom) {
            if (this.ptW != null) {
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
            tv.chushou.zues.a.a.post(new i(53, this.f4147a.getResources().getString(a.i.hotword_1)));
            com.kascend.chushou.toolkit.a.c.a(this.f4147a, "双击666_num", null, new Object[0]);
        } else if (id == a.f.view_reminder_sendgift) {
            d(false);
            tv.chushou.zues.a.a.post(new i(56, null));
        }
    }

    public void a(long j) {
        if (this.puj != null) {
            this.puj.a(j);
        }
    }

    public void c() {
        if (this.puj != null) {
            this.puj.a();
        }
    }

    public void b(long j) {
        if (this.puj != null) {
            this.puj.b(j);
        }
    }

    public void a(int i) {
        if (this.puj != null) {
            this.puj.a(i);
        }
    }

    public void b(int i) {
        if (this.f4147a != null) {
            this.puk.a(((VideoPlayer) this.f4147a).euq(), false);
        }
        this.puk.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.puf != null) {
            this.puf.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.puf != null) {
            this.puf.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.puf != null) {
            this.puf.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.puf != null) {
            this.puf.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.puf != null) {
            this.puf.a(list);
        }
    }

    public void d() {
        if (this.ptX.plh != null && this.pug != null) {
            this.pug.a(true, this.pum == null ? "" : this.pum.mRoomID);
            this.pug.a(this.ptX.plh, a.C0991a.slide_in_top_danmu_anim, a.C0991a.slide_out_top_danmu_anim, false);
        }
        if (this.ptX.plg != null && this.puh != null) {
            this.puh.a(this.ptX.plg, a.C0991a.slide_in_bottom_danmu_anim, a.C0991a.slide_out_bottom_danmu_anim, true);
        }
        if (this.ptX.pln != null && this.puf != null) {
            this.puf.a(this.ptX.pln, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.ptX != null) {
                        a.this.ptX.pln = null;
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4147a, a.C0991a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.evM();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.puo, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4147a, a.C0991a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.pub != null) {
                        a.this.pub.removeAllListeners();
                        a.this.pub.cancel();
                        a.this.pub = null;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f4147a, a.C0991a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.evL();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.puo, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4147a, a.C0991a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.pua != null) {
                        a.this.pua.removeAllListeners();
                        a.this.pua.cancel();
                        a.this.pua = null;
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
    public Animator evL() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.pua != null) {
            this.pua.removeAllListeners();
            this.pua.cancel();
            this.pua = null;
        }
        this.o.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.o, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.o, 0.0f);
        int measuredWidth = (this.n.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.f4147a, 13.0f) * 2)) - this.o.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.o, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.o, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.o, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.pua != null) {
                    a.this.pua.removeAllListeners();
                    a.this.pua.cancel();
                    a.this.pua = null;
                }
                RxExecutor.postDelayed(a.this.puo, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evL();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pua = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evM() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.pub != null) {
            this.pub.removeAllListeners();
            this.pub.cancel();
            this.pub = null;
        }
        this.r.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.r, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.r, 0.0f);
        int measuredWidth = (this.q.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(this.f4147a, 13.0f) * 2)) - this.r.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.r, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.r, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.r, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.19
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.pub != null) {
                    a.this.pub.removeAllListeners();
                    a.this.pub.cancel();
                    a.this.pub = null;
                }
                RxExecutor.postDelayed(a.this.puo, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evM();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.pub = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.ceb != null && this.ceb.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.eHp(), a.C0991a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.evN();
                    }
                });
                this.ceb.setVisibility(0);
                this.ceb.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.puo, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.ceb != null && this.ceb.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.eHp(), a.C0991a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.puc != null) {
                        a.this.puc.removeAllListeners();
                        a.this.puc.cancel();
                        a.this.puc = null;
                    }
                    if (a.this.ceb != null) {
                        a.this.ceb.setVisibility(8);
                    }
                }
            });
            this.ceb.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator evN() {
        if (this.ceb == null || this.u == null) {
            return null;
        }
        if (this.puc != null) {
            this.puc.removeAllListeners();
            this.puc.cancel();
            this.puc = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.ceb.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.eHp(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.puc != null) {
                    a.this.puc.removeAllListeners();
                    a.this.puc.cancel();
                    a.this.puc = null;
                }
                RxExecutor.postDelayed(a.this.puo, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.evN();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.puc = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.puo, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ptZ != null) {
                        a.this.ptZ.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.f4147a != null && !((Activity) this.f4147a).isFinishing() && pVar != null) {
            this.k = pVar.f4077a;
            if (this.k != null && this.k.contains("4") && this.pud != null) {
                this.pud.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.pum != null && mVar.a(this.pum.mCreatorUID, this.pum.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.f4152a == 8 && this.pui != null && this.pui.getVisibility() != 0) {
            this.pui.a(a.C0991a.slide_in_top_danmu_anim, a.C0991a.slide_out_top_danmu_anim, this.pum == null ? "" : this.pum.mRoomID);
        }
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!b()) {
            if (iVar.f4073a == 49) {
                if (!this.I && iVar.b != null) {
                    a(iVar.b.toString());
                }
            } else if (iVar.f4073a == 50 && !this.I && (iVar.b instanceof ListItem)) {
                ListItem listItem = (ListItem) iVar.b;
                if (!h.isEmpty(listItem.mUrl)) {
                    a(listItem);
                }
            }
        }
    }

    @Subscribe
    public void onButtonLayoutLayout(com.kascend.chushou.player.ui.button.a aVar) {
        if (!b() && this.pum != null && !h.isEmpty(this.pum.mRoomID) && this.pum.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.pui != null && this.pui.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.pue != null && this.pue.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.pug != null && this.pug.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pug.getHeight());
                }
                this.pup.setTranslationY(r0);
                return;
            }
            if (this.y != null) {
                this.y.cancel();
                this.y = null;
            }
            int translationY = (int) this.pup.getTranslationY();
            if (aVar.f4151a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f) : 0;
                if (this.pui != null && this.pui.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.pug != null && this.pug.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pug.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (2 == aVar.f4151a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4147a, 65.0f) : 0;
                if (this.pui != null && this.pui.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.pug != null && this.pug.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pug.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (3 == aVar.f4151a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.pue != null && this.pue.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.pug != null && this.pug.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pug.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (5 == aVar.f4151a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f);
                    this.L = true;
                } else {
                    this.L = false;
                    if (this.pue != null && this.pue.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                    }
                }
                if (this.pui != null && this.pui.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.pug != null && this.pug.getVisibility() == 0) {
                    r0 = Math.max(r0, this.pug.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.pug.getHeight();
                if (this.pui != null && this.pui.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f));
                }
            } else {
                if (this.pui != null && this.pui.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.pue != null && this.pue.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
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
                if (!a.this.b() && a.this.pup != null) {
                    a.this.pup.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
        if (this.pue != null) {
            if (!this.pue.isShown()) {
                if (this.ptX != null && this.ptX.euJ() != null && this.ptX.euJ().mRoominfo != null) {
                    this.pue.a(list, str, z, micStatus, this.ptX.euJ().mRoominfo.mCreatorUID);
                    this.pue.a(this.ptX.euJ().mRoominfo.mRoomID);
                }
            } else if (this.ptX != null && this.ptX.euJ() != null && this.ptX.euJ().mRoominfo != null) {
                this.pue.a(list, str, z, micStatus, this.ptX.euJ().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.pue != null && this.pue.isShown()) {
            this.pue.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.ptY.getChildCount();
        int itemCount = this.ptY.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.ptY);
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
            if ((this.k == null || !this.k.contains("4")) && this.pud != null) {
                this.pud.a(list);
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
            if (this.ptZ != null) {
                this.ptZ.a(this.f.size());
                if (i == 1) {
                    this.ptZ.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.ptZ.notifyItemRangeRemoved(i2, i3);
                    this.ptZ.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.ptZ.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.ptW.scrollToPosition(this.f.size() - 1);
                } else {
                    this.ptW.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.ptZ != null) {
                this.ptZ.a(this.f.size());
                this.ptZ.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.ptW.scrollToPosition(this.f.size() - 1);
                } else {
                    this.ptW.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.cu(this);
        if (this.ptZ != null) {
            this.ptZ.a(0);
            this.ptZ = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.pun != null) {
            this.pun.clear();
            this.pun = null;
        }
        this.f4147a = null;
        this.b = null;
        this.ptW = null;
        this.m = null;
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.ptZ = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.ptY = null;
        this.ptX = null;
        this.pum = null;
        this.pue = null;
        if (this.pug != null) {
            this.pug.a();
        }
        if (this.puh != null) {
            this.puh.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.ptX != null && this.ptX.euL() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.ptX.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.ptX.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.etT().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet eC = com.kascend.chushou.c.a.eC(jSONObject);
                        if (eC.mRc == 0) {
                            g.O(a.this.f4147a, a.i.subscribe_success);
                            a.this.pum.mIsSubscribed = true;
                            return;
                        }
                        a(eC.mRc, eC.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!a.this.b()) {
                        if (h.isEmpty(str2)) {
                            str2 = a.this.f4147a.getString(a.i.subscribe_failed);
                        }
                        g.d(a.this.f4147a, str2);
                    }
                }
            }, (String) null, this.pum.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1000a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private final int n;
        private final int o;
        private final int p;
        private tv.chushou.zues.a pkE;
        private tv.chushou.zues.a pkF;
        private tv.chushou.zues.a pkG;
        private tv.chushou.zues.a pkH;
        private tv.chushou.zues.a puu;
        private final tv.chushou.zues.toolkit.richtext.a puv;
        private final int q;
        private final JSONObject s;
        private final int t;

        /* renamed from: a  reason: collision with root package name */
        protected int f4148a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.M(28.0f);
        private final int v = tv.chushou.widget.a.c.M(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes6.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView pkR;
            private ChatInfo pkV;

            c(View view) {
                super(view);
                this.pkR = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C1000a.this.b.getString(a.i.videoplayer_danmaku_share)).R(C1000a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C1000a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b euk;
                JSONObject jSONObject = null;
                if (this.pkV != null && this.pkV.mItem != null) {
                    String str = (!(C1000a.this.b instanceof VideoPlayer) || (euk = ((VideoPlayer) C1000a.this.b).euk()) == null) ? null : euk.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C1000a.this.b, this.pkV.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.pkV = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C1000a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.pkR, null, C1000a.this.puv)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.pkR.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1002a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView pkQ;

            C1002a(View view) {
                super(view);
                this.pkQ = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.pkQ != null && ViewCompat.isAttachedToWindow(this.pkQ)) {
                    this.pkQ.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.pkQ != null) {
                    this.pkQ.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.pkQ != null) {
                    this.pkQ.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes6.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {

            /* renamed from: a  reason: collision with root package name */
            View f4150a;
            SimpleDraweeSpanTextView pkR;
            EmojiGiftView pkS;

            b(View view) {
                super(view);
                this.f4150a = view;
                this.pkR = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.pkS = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.pjr.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C1000a.this.u, C1000a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C1000a.this.a(this.pkR, this, cVar, str, a.e.default_medal_icon, C1000a.this.o, C1000a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C1000a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C1000a.this.b, a.c.banrrage_chat_name_color), this.pkR, " : ", C1000a.this.puv);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C1000a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C1000a.this.b, a.c.kas_red_n), this.pkR)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C1000a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C1000a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.pkR.setMovementMethod(tv.chushou.zues.widget.a.b.eIo());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C1000a.this.pkE), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.pkR.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.pkR != null) {
                            b.this.pkR.measure(0, 0);
                            b.this.pkR.requestLayout();
                        }
                    }
                });
                this.pkR.setDraweeSpanStringBuilder(cVar);
                int M = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.M(chatInfo.giftDisplayWidth) : C1000a.this.t;
                int M2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.M(chatInfo.giftDisplayHeight) : C1000a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.pkS.getLayoutParams();
                layoutParams.width = M;
                layoutParams.height = M2;
                this.pkS.setLayoutParams(layoutParams);
                this.pkS.a(chatInfo.mGift.icon, a.c.transparent, M, M2);
                this.pkS.setOnClickListener(C1000a.this.pkH);
                this.pkS.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.evX().a(chatInfo.mCoolMessage.mBgImage, this.f4150a, a.e.bg_bubble_default);
                    return;
                }
                this.f4150a.setBackgroundResource(0);
                this.f4150a.setPadding(tv.chushou.zues.utils.a.dip2px(C1000a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C1000a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C1000a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C1000a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.pkR != null && ViewCompat.isAttachedToWindow(this.pkR)) {
                    this.pkR.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.pkR != null) {
                    this.pkR.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.pkR != null) {
                    this.pkR.removeCallbacks(runnable);
                }
            }
        }

        C1000a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.pum != null) {
                hashMap.put("_fbroomid", a.this.pum.mRoomID);
            }
            this.s = e.a(hashMap);
            this.pkF = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void em(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C1000a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.pum.mCreatorUID, C1000a.this.s);
                    }
                }
            };
            this.pkE = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void em(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.pum == null || !chatInfo.mItem.mTargetKey.equals(a.this.pum.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C1000a.this.b, chatInfo.mItem, C1000a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C1000a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.pum.mCreatorUID, C1000a.this.s);
                    }
                }
            };
            this.pkG = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void em(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.pum == null || !chatInfo.mItem.mTargetKey.equals(a.this.pum.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C1000a.this.b, chatInfo.mItem, C1000a.this.s);
                        }
                    }
                }
            };
            this.pkH = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void em(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C1000a.this.s, a.this.pum.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.puu = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void em(View view) {
                    com.kascend.chushou.d.a.a(C1000a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
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
            this.puv = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
            this.q = ContextCompat.getColor(this.b, a.c.videoplayer_share_danmaku);
        }

        public void a(int i) {
            this.f4148a = i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f4148a;
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
                    return new C1002a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C1002a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C1002a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C1002a c1002a = (C1002a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c1002a.pkQ != null) {
                                c1002a.pkQ.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c1002a.pkQ != null) {
                            c1002a.pkQ.setOnClickListener(null);
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
                        final C1002a c1002a = (C1002a) viewHolder;
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
                                if (!h.isEmpty(a.this.pum.mSystemAnnouncement)) {
                                    ArrayList<RichText> aal = tv.chushou.zues.toolkit.richtext.b.aal(a.this.pum.mSystemAnnouncement);
                                    if (h.isEmpty(aal)) {
                                        cVar.a(a.this.pum.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, aal, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c1002a.pkQ);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.pum.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c1002a.pkQ.setText(cVar);
                                c1002a.pkQ.setOnClickListener(null);
                                c1002a.pkQ.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c1002a.pkQ != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.pjr.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c1002a.pkQ, c1002a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c1002a.pkQ, " : ", this.puv);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.pkF), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c1002a.pkQ, null, this.puv);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().bo(chatInfo.mCoolNickname.mFontColors).Ps(chatInfo.mCoolNickname.mNickName.length()).emB());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c1002a.pkQ, " : ", this.puv)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.pkF), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.puv.Yv(chatInfo.mCoolContent.mContent), new c.a().bo(chatInfo.mCoolContent.mFontColors).Ps(chatInfo.mCoolContent.mContent.length()).emB());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c1002a.pkQ, null, this.puv)) {
                                                cVar2.a(this.puv.Yv(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c1002a.pkQ != null) {
                                                c1002a.pkQ.measure(0, 0);
                                                c1002a.pkQ.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.pkE), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c1002a.pkQ.setDraweeSpanStringBuilder(cVar2);
                                    c1002a.pkQ.setTag(a.f.tag_position, chatInfo);
                                    c1002a.pkQ.setMovementMethod(tv.chushou.zues.widget.a.b.eIo());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.evX().a(chatInfo.mCoolMessage.mBgImage, c1002a.pkQ, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c1002a.pkQ.setBackgroundResource(0);
                                    c1002a.pkQ.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c1002a.pkQ != null) {
                                    c1002a.pkQ.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c1002a.pkQ, c1002a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c1002a.pkQ, null, this.puv);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c1002a.pkQ, null, this.puv)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c1002a.pkQ != null) {
                                                        c1002a.pkQ.measure(0, 0);
                                                        c1002a.pkQ.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.pkG), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c1002a.pkQ.setDraweeSpanStringBuilder(cVar3);
                                            c1002a.pkQ.setTag(a.f.tag_position, chatInfo2);
                                            c1002a.pkQ.setMovementMethod(tv.chushou.zues.widget.a.b.eIo());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.evX().a(chatInfo2.mCoolMessage.mBgImage, c1002a.pkQ, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c1002a.pkQ.setBackgroundResource(0);
                                            c1002a.pkQ.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c1002a.pkQ != null) {
                                    c1002a.pkQ.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c1002a.pkQ, " : ", this.puv);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.pkF), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c1002a.pkQ, null, this.puv);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c1002a.pkQ)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.pkF), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c1002a.pkQ)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c1002a.pkQ, c1002a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.pun == null) {
                                                a.this.pun = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.pun.containsKey(substring)) {
                                                drawable = (Drawable) a.this.pun.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.pun.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.pun.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.pun.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.pun.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.pkE), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c1002a.pkQ.setDraweeSpanStringBuilder(cVar4);
                                    c1002a.pkQ.setTag(a.f.tag_position, chatInfo3);
                                    c1002a.pkQ.setMovementMethod(tv.chushou.zues.widget.a.b.eIo());
                                    c1002a.pkQ.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.evX().a(chatInfo3.mCoolMessage.mBgImage, c1002a.pkQ, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c1002a.pkQ.setBackgroundResource(0);
                                    c1002a.pkQ.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
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
                        C1002a c1002a2 = (C1002a) viewHolder;
                        c1002a2.pkQ.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.puu), new UnderlineSpan());
                        c1002a2.pkQ.setDraweeSpanStringBuilder(cVar5);
                        c1002a2.pkQ.setMovementMethod(tv.chushou.zues.widget.a.b.eIo());
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
                    cVar.a("", new b.a().a(callback).AS(true).Rw(i2).Rx(i3).YA(str).Rv(i).m(simpleDraweeSpanTextView).ewy());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).Pp(i).emq(), this.b);
                a2.setController(com.facebook.drawee.a.a.c.ekQ().XP(str).elH());
                cVar.append("1");
                cVar.a(a2, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b euk;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (euk = ((VideoPlayer) context).euk()) != null && !h.isEmpty(euk.f4119a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", euk.f4119a);
                Http http = (Http) tv.chushou.basis.d.b.eHr().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
