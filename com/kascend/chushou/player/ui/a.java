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
    private View bRD;
    private ArrayList<ChatInfo> f;
    private ArrayList<ChatInfo> g;
    private ArrayList<ChatInfo> h;
    private ArrayList<ChatInfo> i;
    private Button m;
    private View n;
    private View o;
    private RecyclerView orD;
    private RecyclerView.LayoutManager orF;
    private Animator orH;
    private Animator orI;
    private Animator orJ;
    private ShareDanmakuView orK;
    private MicStatusView orL;
    private EmbeddedButtonLayout orM;
    private FoodView orN;
    private FoodView orO;
    private com.kascend.chushou.player.ui.miniview.a orP;
    private InteractNotifier orQ;
    private RedpacketNotifier orR;
    private FrescoThumbnailView orS;
    private RoomInfo orT;
    private HashMap<String, Drawable> orU;
    private ScrollView orW;
    private View q;
    private View r;
    private View u;
    private ValueAnimator y;

    /* renamed from: a  reason: collision with root package name */
    private Context f4147a = null;
    private View b = null;
    private b orE = null;
    private C0906a orG = null;
    private ArrayList<String> k = null;
    private boolean l = true;
    private boolean I = false;
    private final io.reactivex.disposables.a orV = new io.reactivex.disposables.a();
    private boolean L = false;

    public static a zo(boolean z) {
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
        this.orE = ((VideoPlayer) this.f4147a).egv();
        if (this.orE != null) {
            this.orT = this.orE.egW();
        }
        this.f = new ArrayList<>();
        if (this.orT != null) {
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
        this.orQ = (InteractNotifier) view.findViewById(a.f.interact_notifier);
        this.orR = (RedpacketNotifier) view.findViewById(a.f.redpacket_notifier);
        this.m = (Button) view.findViewById(a.f.btn_scrollbottom);
        this.m.setOnClickListener(this);
        this.orD = (RecyclerView) view.findViewById(a.f.list_banrrage);
        this.orF = new tv.chushou.zues.widget.adapterview.recyclerview.b.a(this.f4147a);
        this.orD.setLayoutManager(this.orF);
        this.orD.setHasFixedSize(true);
        RecyclerView.ItemAnimator itemAnimator = this.orD.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            itemAnimator.setAddDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
            itemAnimator.setRemoveDuration(0L);
        }
        this.orD.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kascend.chushou.player.ui.a.1
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
        this.orG = new C0906a(this.f4147a);
        this.orD.setAdapter(this.orG);
        this.orG.a(this.f.size());
        this.orG.notifyDataSetChanged();
        if (this.orE != null && (c = this.orE.c()) != null && c.size() > 0) {
            a(c, false, true);
        }
        this.orL = (MicStatusView) this.b.findViewById(a.f.rl_mic_status);
        this.orL.setOnClickListener(this);
        this.orN = (FoodView) this.b.findViewById(a.f.top_ad);
        this.orO = (FoodView) this.b.findViewById(a.f.bottom_ad);
        this.orW = (ScrollView) this.b.findViewById(a.f.sv);
        this.orM = (EmbeddedButtonLayout) this.b.findViewById(a.f.embedded_button_layout);
        this.n = this.b.findViewById(a.f.view_reminder_subscribe);
        this.o = this.n.findViewById(a.f.spash_subscribe);
        ((TextView) this.n.findViewById(a.f.tv_reminder_subscribe)).setText(new c().N(this.f4147a, a.e.videoplayer_reminder_subscribe).append(" ").append(this.f4147a.getString(a.i.videoplayer_reminder_subscribe)));
        this.n.setOnClickListener(this);
        this.q = this.b.findViewById(a.f.view_reminder_danmaku);
        this.r = this.q.findViewById(a.f.spash_danmaku);
        ((TextView) this.q.findViewById(a.f.tv_reminder_danmaku)).setText(new c().N(this.f4147a, a.e.videoplayer_reminder_danmaku).append(" ").append(this.f4147a.getString(a.i.videoplayer_reminder_danmaku)));
        this.q.setOnClickListener(this);
        this.bRD = this.b.findViewById(a.f.view_reminder_sendgift);
        this.u = this.bRD.findViewById(a.f.spash_sendgift);
        ((TextView) this.bRD.findViewById(a.f.tv_reminder_sendgift)).setText(new c().N(tv.chushou.basis.d.b.etB(), a.e.videoplayer_reminder_sendgift).append(" ").append(tv.chushou.widget.a.c.getString(a.i.videoplayer_reminder_sendGift)));
        this.bRD.setOnClickListener(this);
        this.orK = (ShareDanmakuView) view.findViewById(a.f.share_danmaku_view);
        this.orK.a(getActivity(), ContextCompat.getColor(this.f4147a, a.c.videoplayer_share_danmaku), new ShareDanmakuView.a() { // from class: com.kascend.chushou.player.ui.a.4
            @Override // com.kascend.chushou.player.ui.ShareDanmakuView.a
            public void a(ChatInfo chatInfo) {
                if (a.this.orG != null && a.this.orF != null) {
                    if (a.this.f == null) {
                        a.this.f = new ArrayList();
                        a.this.f();
                    }
                    int size = a.this.f.size();
                    a.this.f.add(chatInfo);
                    a.this.orG.a(a.this.f.size());
                    a.this.orG.notifyItemInserted(size);
                    a.this.l = true;
                    if (a.this.m != null) {
                        a.this.m.setVisibility(8);
                    }
                    a.this.orF.scrollToPosition(a.this.f.size() - 1);
                }
            }
        }, this.orE != null ? this.orE.h : "");
        if (this.orE != null) {
            VideoPlayer videoPlayer = (VideoPlayer) this.f4147a;
            a(this.orE.b("2"));
            d();
            com.kascend.chushou.player.ui.a.a egF = videoPlayer.egF();
            this.orM.a(egF.ehZ());
            BangInfo eia = egF.eia();
            if (eia != null) {
                this.orM.a(eia, egF.d());
            }
            this.orM.b(this.orE.i());
            this.orQ.a(videoPlayer.egC(), videoPlayer.egD(), videoPlayer.egE());
            this.orR.a(videoPlayer.egB(), false);
            if (this.orE.oiR != null && !h.isEmpty(this.orE.oiR.mUrl)) {
                a(this.orE.oiR);
            }
            if (this.orT != null && !this.orT.mIsSubscribed) {
                RxExecutor.postDelayed(this.orV, EventThread.MAIN_THREAD, 5L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.orT == null || !a.this.orT.mIsSubscribed) {
                            a.this.c(true);
                        }
                    }
                });
            }
            RxExecutor.postDelayed(this.orV, EventThread.MAIN_THREAD, 5L, TimeUnit.MINUTES, new Runnable() { // from class: com.kascend.chushou.player.ui.a.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.orE != null && !a.this.orE.z) {
                        a.this.d(true);
                    }
                }
            });
            if (!h.isEmpty(this.orE.oiZ)) {
                this.orM.a(this.orE.oiZ);
            }
        }
        if (this.orT != null && !h.isEmpty(this.orT.mRoomID)) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(5, this.L ? 0 : 8);
            aVar.Wq(this.orT.mRoomID);
            onButtonLayoutLayout(aVar);
        }
    }

    private void a(ListItem listItem) {
        if (this.orP == null) {
            this.orP = new com.kascend.chushou.player.ui.miniview.a(this.f4147a, listItem, new d() { // from class: com.kascend.chushou.player.ui.a.10
                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(Object obj) {
                    if (a.this.orP != null && a.this.b != null && a.this.orP.a()) {
                        ((ViewGroup) a.this.b).removeView(a.this.orP);
                        a.this.orP = null;
                    }
                }

                @Override // com.kascend.chushou.widget.cswebview.d
                public void a(String str) {
                }
            });
            ((ViewGroup) this.b).addView(this.orP);
            if (listItem.mAutoDisplay == 0) {
                this.orP.setVisibility(8);
            } else {
                this.orP.a(a.C0897a.slide_in_top_danmu_anim, a.C0897a.slide_out_top_danmu_anim, this.orT == null ? "" : this.orT.mRoomID);
            }
        } else if (!this.orP.isShown()) {
            this.orP.a(a.C0897a.slide_in_top_danmu_anim, a.C0897a.slide_out_top_danmu_anim, this.orT == null ? "" : this.orT.mRoomID);
        } else {
            return;
        }
        if (listItem.mPackStyle == 1) {
            this.orM.a(listItem);
        }
    }

    public void a(String str) {
        if (!h.isEmpty(str) && this.f4147a != null && this.b != null) {
            if (this.orS == null) {
                this.orS = (FrescoThumbnailView) ((ViewStub) this.b.findViewById(a.f.iv_banrrage_bg)).inflate();
            }
            Point hj = tv.chushou.zues.utils.a.hj(this.f4147a);
            int integer = (hj.y - ((hj.x * this.f4147a.getResources().getInteger(a.g.h_thumb_height_def)) / this.f4147a.getResources().getInteger(a.g.h_thumb_width_def))) - this.f4147a.getResources().getDimensionPixelSize(a.d.videoplayer_tab_height);
            this.orS.setVisibility(0);
            this.orS.i(str, 0, hj.x, integer);
        }
    }

    public void a() {
        if (this.orS != null) {
            this.orS.setVisibility(8);
        }
    }

    public void b(String str) {
        if (this.orP != null) {
            this.orP.a(str);
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
        this.orK.a();
        if (this.orH != null) {
            this.orH.removeAllListeners();
            this.orH.cancel();
            this.orH = null;
        }
        if (this.orI != null) {
            this.orI.removeAllListeners();
            this.orI.cancel();
            this.orI = null;
        }
        if (this.orJ != null) {
            this.orJ.removeAllListeners();
            this.orJ.cancel();
            this.orJ = null;
        }
        if (this.orQ != null) {
            this.orQ.c();
        }
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.orV.dispose();
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
            if (this.orD != null) {
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
        if (this.orQ != null) {
            this.orQ.a(j);
        }
    }

    public void c() {
        if (this.orQ != null) {
            this.orQ.a();
        }
    }

    public void b(long j) {
        if (this.orQ != null) {
            this.orQ.b(j);
        }
    }

    public void a(int i) {
        if (this.orQ != null) {
            this.orQ.a(i);
        }
    }

    public void b(int i) {
        if (this.f4147a != null) {
            this.orR.a(((VideoPlayer) this.f4147a).egB(), false);
        }
        this.orR.a(i, false);
    }

    public void a(IconConfig.Config config) {
        if (this.orM != null) {
            this.orM.a(config);
        }
    }

    public void a(BangInfo bangInfo, String str) {
        if (this.orM != null) {
            this.orM.a(bangInfo, str);
        }
    }

    public void a(long j, BangInfo bangInfo, String str) {
        if (this.orM != null) {
            this.orM.a(j, bangInfo, str);
        }
    }

    public void a(List<ListItem> list) {
        if (this.orM != null) {
            this.orM.b(list);
        }
    }

    public void b(List<ListItem> list) {
        if (this.orM != null) {
            this.orM.a(list);
        }
    }

    public void d() {
        if (this.orE.oiQ != null && this.orN != null) {
            this.orN.a(true, this.orT == null ? "" : this.orT.mRoomID);
            this.orN.a(this.orE.oiQ, a.C0897a.slide_in_top_danmu_anim, a.C0897a.slide_out_top_danmu_anim, false);
        }
        if (this.orE.oiP != null && this.orO != null) {
            this.orO.a(this.orE.oiP, a.C0897a.slide_in_bottom_danmu_anim, a.C0897a.slide_out_bottom_danmu_anim, true);
        }
        if (this.orE.oiW != null && this.orM != null) {
            this.orM.a(this.orE.oiW, new FoodView.a() { // from class: com.kascend.chushou.player.ui.a.11
                @Override // com.kascend.chushou.player.ui.food.FoodView.a
                public boolean a() {
                    if (a.this.orE != null) {
                        a.this.orE.oiW = null;
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
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f4147a, a.C0897a.videoplayer_reminder_in);
            loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.13
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.ehX();
                }
            });
            this.q.setVisibility(0);
            this.q.startAnimation(loadAnimation);
            RxExecutor.postDelayed(this.orV, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(false);
                }
            });
        } else if (this.q != null && this.q.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4147a, a.C0897a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.15
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.orI != null) {
                        a.this.orI.removeAllListeners();
                        a.this.orI.cancel();
                        a.this.orI = null;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f4147a, a.C0897a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.12
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.ehW();
                    }
                });
                this.n.setVisibility(0);
                this.n.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.orV, EventThread.MAIN_THREAD, 20L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.16
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.c(false);
                    }
                });
            }
        } else if (this.n != null && this.n.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f4147a, a.C0897a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.17
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.orH != null) {
                        a.this.orH.removeAllListeners();
                        a.this.orH.cancel();
                        a.this.orH = null;
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
    public Animator ehW() {
        if (this.n == null || this.o == null) {
            return null;
        }
        if (this.orH != null) {
            this.orH.removeAllListeners();
            this.orH.cancel();
            this.orH = null;
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
                if (a.this.orH != null) {
                    a.this.orH.removeAllListeners();
                    a.this.orH.cancel();
                    a.this.orH = null;
                }
                RxExecutor.postDelayed(a.this.orV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ehW();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.orH = animatorSet;
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator ehX() {
        if (this.q == null || this.r == null) {
            return null;
        }
        if (this.orI != null) {
            this.orI.removeAllListeners();
            this.orI.cancel();
            this.orI = null;
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
                if (a.this.orI != null) {
                    a.this.orI.removeAllListeners();
                    a.this.orI.cancel();
                    a.this.orI = null;
                }
                RxExecutor.postDelayed(a.this.orV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ehX();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.orI = animatorSet;
        return animatorSet;
    }

    public void d(boolean z) {
        if (z) {
            if (this.bRD != null && this.bRD.getVisibility() != 0) {
                this.u.setVisibility(8);
                Animation loadAnimation = AnimationUtils.loadAnimation(h.etB(), a.C0897a.videoplayer_reminder_in);
                loadAnimation.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.20
                    @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.ehY();
                    }
                });
                this.bRD.setVisibility(0);
                this.bRD.startAnimation(loadAnimation);
                RxExecutor.postDelayed(this.orV, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.21
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(false);
                    }
                });
            }
        } else if (this.bRD != null && this.bRD.getVisibility() != 8) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(h.etB(), a.C0897a.videoplayer_reminder_out);
            loadAnimation2.setAnimationListener(new tv.chushou.zues.toolkit.c.a() { // from class: com.kascend.chushou.player.ui.a.22
                @Override // tv.chushou.zues.toolkit.c.a, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (a.this.orJ != null) {
                        a.this.orJ.removeAllListeners();
                        a.this.orJ.cancel();
                        a.this.orJ = null;
                    }
                    if (a.this.bRD != null) {
                        a.this.bRD.setVisibility(8);
                    }
                }
            });
            this.bRD.startAnimation(loadAnimation2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator ehY() {
        if (this.bRD == null || this.u == null) {
            return null;
        }
        if (this.orJ != null) {
            this.orJ.removeAllListeners();
            this.orJ.cancel();
            this.orJ = null;
        }
        this.u.setVisibility(0);
        tv.chushou.zues.toolkit.d.b.setTranslationX(this.u, 0.0f);
        tv.chushou.zues.toolkit.d.b.setAlpha(this.u, 0.0f);
        int measuredWidth = (this.bRD.getMeasuredWidth() - (tv.chushou.zues.utils.a.dip2px(h.etB(), 13.0f) * 2)) - this.u.getMeasuredWidth();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f).setDuration(700L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.u, "translationX", 0.0f, measuredWidth).setDuration(1600L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.u, "alpha", 1.0f, 0.0f).setDuration(700L);
        duration3.setStartDelay(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.player.ui.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (a.this.orJ != null) {
                    a.this.orJ.removeAllListeners();
                    a.this.orJ.cancel();
                    a.this.orJ = null;
                }
                RxExecutor.postDelayed(a.this.orV, EventThread.MAIN_THREAD, 1L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.ui.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ehY();
                    }
                });
            }
        });
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
        this.orJ = animatorSet;
        return animatorSet;
    }

    @Subscribe
    public void onRefreshPrivilegeEvent(l lVar) {
        if (!b()) {
            RxExecutor.post(this.orV, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.orG != null) {
                        a.this.orG.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    @Subscribe
    public void onUpdateBanrrageTurnEvent(p pVar) {
        if (!b() && this.f4147a != null && !((Activity) this.f4147a).isFinishing() && pVar != null) {
            this.k = pVar.f4077a;
            if (this.k != null && this.k.contains("4") && this.orK != null) {
                this.orK.b();
            }
            e(true);
        }
    }

    @Subscribe
    public void onRefreshSubscriberEvent(m mVar) {
        if (!b() && this.orT != null && mVar.a(this.orT.mCreatorUID, this.orT.mRoomID) && mVar.c && this.n != null) {
            this.n.setVisibility(8);
        }
    }

    @Subscribe
    public void onButtonUIEvent(com.kascend.chushou.player.ui.button.b bVar) {
        if (!b() && bVar.f4152a == 8 && this.orP != null && this.orP.getVisibility() != 0) {
            this.orP.a(a.C0897a.slide_in_top_danmu_anim, a.C0897a.slide_out_top_danmu_anim, this.orT == null ? "" : this.orT.mRoomID);
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
        if (!b() && this.orT != null && !h.isEmpty(this.orT.mRoomID) && this.orT.mRoomID.equals(aVar.d)) {
            if (!aVar.c) {
                if (this.orP != null && this.orP.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.orL != null && this.orL.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.orN != null && this.orN.getVisibility() == 0) {
                    r0 = Math.max(r0, this.orN.getHeight());
                }
                this.orW.setTranslationY(r0);
                return;
            }
            if (this.y != null) {
                this.y.cancel();
                this.y = null;
            }
            int translationY = (int) this.orW.getTranslationY();
            if (aVar.f4151a == 1) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f) : 0;
                if (this.orP != null && this.orP.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.orN != null && this.orN.getVisibility() == 0) {
                    r0 = Math.max(r0, this.orN.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (2 == aVar.f4151a) {
                r0 = aVar.b == 0 ? tv.chushou.zues.utils.a.dip2px(this.f4147a, 65.0f) : 0;
                if (this.orP != null && this.orP.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.orN != null && this.orN.getVisibility() == 0) {
                    r0 = Math.max(r0, this.orN.getHeight());
                }
                if (this.L) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 64.0f));
                }
            } else if (3 == aVar.f4151a) {
                if (aVar.b == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.orL != null && this.orL.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                }
                if (this.orN != null && this.orN.getVisibility() == 0) {
                    r0 = Math.max(r0, this.orN.getHeight());
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
                    if (this.orL != null && this.orL.getVisibility() == 0) {
                        r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 32.0f);
                    }
                }
                if (this.orP != null && this.orP.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                }
                if (this.orN != null && this.orN.getVisibility() == 0) {
                    r0 = Math.max(r0, this.orN.getHeight());
                }
            } else if (aVar.b == 0) {
                r0 = this.orN.getHeight();
                if (this.orP != null && this.orP.getVisibility() == 0) {
                    r0 = Math.max(r0, tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f));
                }
            } else {
                if (this.orP != null && this.orP.getVisibility() == 0) {
                    r0 = tv.chushou.zues.utils.a.dip2px(this.f4147a, 80.0f);
                } else if (this.orL != null && this.orL.getVisibility() == 0) {
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
                if (!a.this.b() && a.this.orW != null) {
                    a.this.orW.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
        if (this.orL != null) {
            if (!this.orL.isShown()) {
                if (this.orE != null && this.orE.egU() != null && this.orE.egU().mRoominfo != null) {
                    this.orL.a(list, str, z, micStatus, this.orE.egU().mRoominfo.mCreatorUID);
                    this.orL.a(this.orE.egU().mRoominfo.mRoomID);
                }
            } else if (this.orE != null && this.orE.egU() != null && this.orE.egU().mRoominfo != null) {
                this.orL.a(list, str, z, micStatus, this.orE.egU().mRoominfo.mCreatorUID);
            }
        }
    }

    public void e() {
        if (this.orL != null && this.orL.isShown()) {
            this.orL.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int childCount = this.orF.getChildCount();
        int itemCount = this.orF.getItemCount();
        int f = tv.chushou.zues.widget.adapterview.recyclerview.c.a.f(this.orF);
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
            if ((this.k == null || !this.k.contains("4")) && this.orK != null) {
                this.orK.a(list);
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
            if (this.orG != null) {
                this.orG.a(this.f.size());
                if (i == 1) {
                    this.orG.notifyItemRangeInserted(i2, i3);
                } else if (i == 2) {
                    this.orG.notifyItemRangeRemoved(i2, i3);
                    this.orG.notifyItemRangeChanged(i2, 100, "notifydata");
                } else {
                    this.orG.notifyDataSetChanged();
                }
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.orD.scrollToPosition(this.f.size() - 1);
                } else {
                    this.orD.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void f(boolean z) {
        if (!this.I) {
            if (this.orG != null) {
                this.orG.a(this.f.size());
                this.orG.notifyDataSetChanged();
            }
            if (z || this.l) {
                this.l = true;
                if (this.m != null) {
                    this.m.setVisibility(8);
                }
                if (z) {
                    this.orD.scrollToPosition(this.f.size() - 1);
                } else {
                    this.orD.smoothScrollToPosition(this.f.size() - 1);
                }
            }
        }
    }

    private void k() {
        tv.chushou.zues.a.a.cp(this);
        if (this.orG != null) {
            this.orG.a(0);
            this.orG = null;
        }
        if (this.f != null) {
            this.f.clear();
            this.f = null;
        }
        if (this.h != null) {
            this.h.clear();
            this.h = null;
        }
        if (this.orU != null) {
            this.orU.clear();
            this.orU = null;
        }
        this.f4147a = null;
        this.b = null;
        this.orD = null;
        this.m = null;
        if (this.i != null) {
            this.i.clear();
            this.i = null;
        }
        if (this.g != null) {
            this.g.clear();
            this.g = null;
        }
        this.orG = null;
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        this.orF = null;
        this.orE = null;
        this.orT = null;
        this.orL = null;
        if (this.orN != null) {
            this.orN.a();
        }
        if (this.orO != null) {
            this.orO.a();
        }
    }

    private void a(Map<String, String> map) {
        String str;
        if (this.orE != null && this.orE.egW() != null) {
            if (map == null) {
                map = new HashMap<>();
                map.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            }
            if (h.isEmpty(this.orE.h)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(this.orE.h).optString("_sc");
                } catch (JSONException e) {
                    str = null;
                }
            }
            if (!h.isEmpty(str)) {
                map.put("_sc", str);
            }
            com.kascend.chushou.c.c.ege().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.ui.a.7
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet et = com.kascend.chushou.c.a.et(jSONObject);
                        if (et.mRc == 0) {
                            g.K(a.this.f4147a, a.i.subscribe_success);
                            a.this.orT.mIsSubscribed = true;
                            return;
                        }
                        a(et.mRc, et.mMessage);
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!a.this.b()) {
                        if (h.isEmpty(str2)) {
                            str2 = a.this.f4147a.getString(a.i.subscribe_failed);
                        }
                        g.c(a.this.f4147a, str2);
                    }
                }
            }, (String) null, this.orT.mCreatorUID, tv.chushou.zues.utils.d.toJson(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kascend.chushou.player.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0906a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        protected Context b;
        private LayoutInflater d;
        private final int m;
        private final int n;
        private final int o;
        private tv.chushou.zues.a oin;
        private tv.chushou.zues.a oio;
        private tv.chushou.zues.a oip;
        private tv.chushou.zues.a oiq;
        private tv.chushou.zues.a osb;
        private final tv.chushou.zues.toolkit.richtext.a osc;
        private final int p;
        private final int q;
        private final JSONObject s;
        private final int t;

        /* renamed from: a  reason: collision with root package name */
        protected int f4148a = 0;
        private final int j = 14;
        private final int k = 18;
        private final int l = 5;
        private final int u = tv.chushou.widget.a.c.J(28.0f);
        private final int v = tv.chushou.widget.a.c.J(21.0f);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$c */
        /* loaded from: classes6.dex */
        public class c extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView c;
            private int d;
            private SimpleDraweeSpanTextView oiA;
            private ChatInfo oiE;

            c(View view) {
                super(view);
                this.oiA = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
                this.c = (TextView) view.findViewById(a.f.tv_share_room);
                this.c.setOnClickListener(this);
                this.c.setText(new tv.chushou.zues.widget.a.c().append(C0906a.this.b.getString(a.i.videoplayer_danmaku_share)).N(C0906a.this.b, a.e.videoplayer_danmaku_share_icon));
                this.d = C0906a.this.q;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kascend.chushou.player.b egv;
                JSONObject jSONObject = null;
                if (this.oiE != null && this.oiE.mItem != null) {
                    String str = (!(C0906a.this.b instanceof VideoPlayer) || (egv = ((VideoPlayer) C0906a.this.b).egv()) == null) ? null : egv.h;
                    if (!h.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException e) {
                        }
                    }
                    e.a(C0906a.this.b, this.oiE.mItem, jSONObject);
                }
            }

            void a(ChatInfo chatInfo) {
                this.oiE = chatInfo;
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!tv.chushou.zues.toolkit.richtext.b.a(C0906a.this.b, cVar, chatInfo.mContentRichText, 18, this.d, this.oiA, null, C0906a.this.osc)) {
                    cVar.a(chatInfo.mContent, new ForegroundColorSpan(this.d));
                }
                this.oiA.setDraweeSpanStringBuilder(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0908a extends RecyclerView.ViewHolder implements Drawable.Callback {
            SimpleDraweeSpanTextView oiz;

            C0908a(View view) {
                super(view);
                this.oiz = (SimpleDraweeSpanTextView) view.findViewById(a.f.tv_content);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.oiz != null && ViewCompat.isAttachedToWindow(this.oiz)) {
                    this.oiz.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.oiz != null) {
                    this.oiz.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.oiz != null) {
                    this.oiz.removeCallbacks(runnable);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.kascend.chushou.player.ui.a$a$b */
        /* loaded from: classes6.dex */
        public class b extends RecyclerView.ViewHolder implements Drawable.Callback {

            /* renamed from: a  reason: collision with root package name */
            View f4150a;
            SimpleDraweeSpanTextView oiA;
            EmojiGiftView oiB;

            b(View view) {
                super(view);
                this.f4150a = view;
                this.oiA = (SimpleDraweeSpanTextView) view.findViewById(a.f.tvTitle);
                this.oiB = (EmojiGiftView) view.findViewById(a.f.tvEmoji);
            }

            void a(ChatInfo chatInfo) {
                tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
                if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                    com.kascend.chushou.d.d.ohb.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar, C0906a.this.u, C0906a.this.v);
                }
                if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                    for (int i = 0; i < chatInfo.mPrivilegeInfo.mMedals.size(); i++) {
                        String str = chatInfo.mPrivilegeInfo.mMedals.get(i);
                        if (!h.isEmpty(str)) {
                            C0906a.this.a(this.oiA, this, cVar, str, a.e.default_medal_icon, C0906a.this.o, C0906a.this.p);
                        }
                    }
                }
                if (chatInfo.mCoolMessage != null) {
                    tv.chushou.zues.toolkit.richtext.b.a(C0906a.this.b, cVar, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(C0906a.this.b, a.c.banrrage_chat_name_color), this.oiA, " : ", C0906a.this.osc);
                } else if (!tv.chushou.zues.toolkit.richtext.b.a(C0906a.this.b, cVar, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(C0906a.this.b, a.c.kas_red_n), this.oiA)) {
                    cVar.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(C0906a.this.b.getResources().getColor(a.c.kas_red_n)));
                } else {
                    cVar.a(" : ", new ForegroundColorSpan(C0906a.this.b.getResources().getColor(a.c.kas_red_n)));
                }
                this.oiA.setMovementMethod(tv.chushou.zues.widget.a.b.euA());
                cVar.setSpan(new tv.chushou.zues.widget.a.a(C0906a.this.oin), 0, cVar.length() + (-1) > 0 ? cVar.length() - 1 : 0, 17);
                this.oiA.setTag(a.f.tag_position, chatInfo);
                cVar.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.b.1
                    @Override // com.facebook.drawee.span.b.c
                    public void d(com.facebook.drawee.span.b bVar) {
                        if (b.this.oiA != null) {
                            b.this.oiA.measure(0, 0);
                            b.this.oiA.requestLayout();
                        }
                    }
                });
                this.oiA.setDraweeSpanStringBuilder(cVar);
                int J = chatInfo.giftDisplayWidth > 0 ? tv.chushou.widget.a.c.J(chatInfo.giftDisplayWidth) : C0906a.this.t;
                int J2 = chatInfo.giftDisplayHeight > 0 ? tv.chushou.widget.a.c.J(chatInfo.giftDisplayHeight) : C0906a.this.t;
                FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) this.oiB.getLayoutParams();
                layoutParams.width = J;
                layoutParams.height = J2;
                this.oiB.setLayoutParams(layoutParams);
                this.oiB.a(chatInfo.mGift.icon, a.c.transparent, J, J2);
                this.oiB.setOnClickListener(C0906a.this.oiq);
                this.oiB.setTag(a.f.tag_position, Integer.valueOf(chatInfo.mGift.id));
                if (chatInfo.mCoolMessage != null && !h.isEmpty(chatInfo.mCoolMessage.mBgImage)) {
                    com.kascend.chushou.toolkit.b.a.eii().a(chatInfo.mCoolMessage.mBgImage, this.f4150a, a.e.bg_bubble_default);
                    return;
                }
                this.f4150a.setBackgroundResource(0);
                this.f4150a.setPadding(tv.chushou.zues.utils.a.dip2px(C0906a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0906a.this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(C0906a.this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(C0906a.this.b, 5.0f));
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(@NonNull Drawable drawable) {
                if (this.oiA != null && ViewCompat.isAttachedToWindow(this.oiA)) {
                    this.oiA.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
                if (this.oiA != null) {
                    this.oiA.postDelayed(runnable, j);
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
                if (this.oiA != null) {
                    this.oiA.removeCallbacks(runnable);
                }
            }
        }

        C0906a(final Context context) {
            this.b = context;
            this.d = LayoutInflater.from(context);
            HashMap hashMap = new HashMap();
            hashMap.put("_fromView", Constants.VIA_REPORT_TYPE_START_WAP);
            hashMap.put("_fromPos", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            if (a.this.orT != null) {
                hashMap.put("_fbroomid", a.this.orT.mRoomID);
            }
            this.s = e.a(hashMap);
            this.oio = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.1
                @Override // tv.chushou.zues.a
                public void dP(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        com.kascend.chushou.d.a.a(C0906a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.orT.mCreatorUID, C0906a.this.s);
                    }
                }
            };
            this.oin = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.2
                @Override // tv.chushou.zues.a
                public void dP(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null) {
                        if (chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                            if (!chatInfo.mItem.mType.equals("1") || a.this.orT == null || !chatInfo.mItem.mTargetKey.equals(a.this.orT.mRoomID)) {
                                a.this.b(chatInfo.mItem);
                                e.a(C0906a.this.b, chatInfo.mItem, C0906a.this.s);
                                return;
                            }
                            return;
                        }
                        com.kascend.chushou.d.a.a(C0906a.this.b, chatInfo.mRoomID, chatInfo.mUserID, chatInfo.mUserNickname, a.this.orT.mCreatorUID, C0906a.this.s);
                    }
                }
            };
            this.oip = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.3
                @Override // tv.chushou.zues.a
                public void dP(View view) {
                    ChatInfo chatInfo = (ChatInfo) view.getTag(a.f.tag_position);
                    if (chatInfo != null && chatInfo.mItem != null && !h.isEmpty(chatInfo.mItem.mType)) {
                        if (!chatInfo.mItem.mType.equals("1") || a.this.orT == null || !chatInfo.mItem.mTargetKey.equals(a.this.orT.mRoomID)) {
                            a.this.b(chatInfo.mItem);
                            e.a(C0906a.this.b, chatInfo.mItem, C0906a.this.s);
                        }
                    }
                }
            };
            this.oiq = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.4
                @Override // tv.chushou.zues.a
                public void dP(View view) {
                    String valueOf = String.valueOf(view.getTag(a.f.tag_position));
                    if (!TextUtils.isEmpty(valueOf)) {
                        try {
                            com.kascend.chushou.view.b.a.b(valueOf, C0906a.this.s, a.this.orT.mRoomID).show(((FragmentActivity) context).getSupportFragmentManager(), "emojiDialog");
                        } catch (Exception e) {
                        }
                    }
                }
            };
            this.osb = new tv.chushou.zues.a() { // from class: com.kascend.chushou.player.ui.a.a.5
                @Override // tv.chushou.zues.a
                public void dP(View view) {
                    com.kascend.chushou.d.a.a(C0906a.this.b, "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol", tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement_title));
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
            this.osc = new com.kascend.chushou.toolkit.a(tv.chushou.zues.utils.a.dip2px(this.b, 13.0f));
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
                    return new C0908a(this.d.inflate(a.h.view_banrrage_list_header, viewGroup, false));
                case 3:
                    return new c(this.d.inflate(a.h.chat_msg_share_layout, viewGroup, false));
                case 4:
                    return new b(this.d.inflate(a.h.chat_msg_emoji_layout, viewGroup, false));
                default:
                    return new C0908a(this.d.inflate(a.h.chat_msg_layout, viewGroup, false));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            if (!h.isEmpty(list)) {
                if (a.this.f != null && i < a.this.f.size()) {
                    if (viewHolder instanceof C0908a) {
                        String str = ((ChatInfo) a.this.f.get(i)).mType;
                        C0908a c0908a = (C0908a) viewHolder;
                        if (str.equals("1") || str.equals("3")) {
                            ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                            if (chatInfo != null && c0908a.oiz != null) {
                                c0908a.oiz.setTag(a.f.tag_position, chatInfo);
                                return;
                            }
                            return;
                        } else if (c0908a.oiz != null) {
                            c0908a.oiz.setOnClickListener(null);
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
                        final C0908a c0908a = (C0908a) viewHolder;
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
                                if (!h.isEmpty(a.this.orT.mSystemAnnouncement)) {
                                    ArrayList<RichText> Yj = tv.chushou.zues.toolkit.richtext.b.Yj(a.this.orT.mSystemAnnouncement);
                                    if (h.isEmpty(Yj)) {
                                        cVar.a(a.this.orT.mSystemAnnouncement, new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                    } else {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar, Yj, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0908a.oiz);
                                    }
                                } else {
                                    cVar.a(this.b.getString(a.i.danmu_list_title, a.this.orT.mCreatorNickname), new ForegroundColorSpan(Color.parseColor("#ff5959")));
                                }
                                c0908a.oiz.setText(cVar);
                                c0908a.oiz.setOnClickListener(null);
                                c0908a.oiz.setBackgroundResource(0);
                                return;
                            case 1:
                                ChatInfo chatInfo = (ChatInfo) a.this.f.get(i);
                                if (chatInfo != null && c0908a.oiz != null) {
                                    tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                                    if (!h.isEmpty(chatInfo.mHeadIcon) && chatInfo.mPrivilegeInfo.mShowAvatar) {
                                        com.kascend.chushou.d.d.ohb.a(chatInfo.mPrivilegeInfo.mAvatarFrame, chatInfo.mHeadIcon, cVar2, this.u, this.v);
                                    }
                                    if (!h.isEmpty(chatInfo.mPrivilegeInfo.mMedals)) {
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 < chatInfo.mPrivilegeInfo.mMedals.size()) {
                                                String str2 = chatInfo.mPrivilegeInfo.mMedals.get(i5);
                                                if (!h.isEmpty(str2)) {
                                                    a(c0908a.oiz, c0908a, cVar2, str2, a.e.default_medal_icon, this.o, this.p);
                                                }
                                                i4 = i5 + 1;
                                            }
                                        }
                                    }
                                    if (chatInfo.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0908a.oiz, " : ", this.osc);
                                        int length = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.oio), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0908a.oiz, null, this.osc);
                                        i3 = length;
                                    } else {
                                        if (chatInfo.mCoolNickname != null && !h.isEmpty(chatInfo.mCoolNickname.mNickName)) {
                                            cVar2.a(chatInfo.mCoolNickname.mNickName + " : ", new c.a().bj(chatInfo.mCoolNickname.mFontColors).MD(chatInfo.mCoolNickname.mNickName.length()).dYQ());
                                        } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0908a.oiz, " : ", this.osc)) {
                                            cVar2.a(chatInfo.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_name_color)));
                                        }
                                        int length2 = cVar2.length();
                                        cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.oio), 0, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                        if (chatInfo.mCoolContent != null && !h.isEmpty(chatInfo.mCoolContent.mContent)) {
                                            cVar2.a(this.osc.Wt(chatInfo.mCoolContent.mContent), new c.a().bj(chatInfo.mCoolContent.mFontColors).MD(chatInfo.mCoolContent.mContent.length()).dYQ());
                                            i3 = length2;
                                        } else {
                                            if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar2, chatInfo.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0908a.oiz, null, this.osc)) {
                                                cVar2.a(this.osc.Wt(chatInfo.mContent), new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            i3 = length2;
                                        }
                                    }
                                    cVar2.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.6
                                        @Override // com.facebook.drawee.span.b.c
                                        public void d(com.facebook.drawee.span.b bVar) {
                                            if (c0908a.oiz != null) {
                                                c0908a.oiz.measure(0, 0);
                                                c0908a.oiz.requestLayout();
                                            }
                                        }
                                    });
                                    cVar2.append(" ");
                                    cVar2.setSpan(new tv.chushou.zues.widget.a.a(this.oin), i3, cVar2.length() + (-1) > 0 ? cVar2.length() - 1 : 0, 18);
                                    c0908a.oiz.setDraweeSpanStringBuilder(cVar2);
                                    c0908a.oiz.setTag(a.f.tag_position, chatInfo);
                                    c0908a.oiz.setMovementMethod(tv.chushou.zues.widget.a.b.euA());
                                    if (chatInfo.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.eii().a(chatInfo.mCoolMessage.mBgImage, c0908a.oiz, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0908a.oiz.setBackgroundResource(0);
                                    c0908a.oiz.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                    return;
                                }
                                return;
                            case 2:
                            case 3:
                                ChatInfo chatInfo2 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo2 != null && c0908a.oiz != null) {
                                    c0908a.oiz.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar3 = new tv.chushou.zues.widget.a.c();
                                    int i6 = 0;
                                    while (true) {
                                        int i7 = i6;
                                        if (i7 < chatInfo2.mPrivilegeInfo.mMedals.size()) {
                                            String str3 = chatInfo2.mPrivilegeInfo.mMedals.get(i7);
                                            if (!h.isEmpty(str3)) {
                                                a(c0908a.oiz, c0908a, cVar3, str3, a.e.default_medal_icon, this.o, this.p);
                                            }
                                            i6 = i7 + 1;
                                        } else {
                                            if (chatInfo2.mCoolMessage != null) {
                                                tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0908a.oiz, null, this.osc);
                                            } else if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar3, chatInfo2.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0908a.oiz, null, this.osc)) {
                                                cVar3.a(chatInfo2.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                            }
                                            cVar3.a(new b.c() { // from class: com.kascend.chushou.player.ui.a.a.7
                                                @Override // com.facebook.drawee.span.b.c
                                                public void d(com.facebook.drawee.span.b bVar) {
                                                    if (c0908a.oiz != null) {
                                                        c0908a.oiz.measure(0, 0);
                                                        c0908a.oiz.requestLayout();
                                                    }
                                                }
                                            });
                                            cVar3.setSpan(new tv.chushou.zues.widget.a.a(this.oip), 0, cVar3.length() + (-1) > 0 ? cVar3.length() - 1 : 0, 18);
                                            c0908a.oiz.setDraweeSpanStringBuilder(cVar3);
                                            c0908a.oiz.setTag(a.f.tag_position, chatInfo2);
                                            c0908a.oiz.setMovementMethod(tv.chushou.zues.widget.a.b.euA());
                                            if (chatInfo2.mCoolMessage != null) {
                                                com.kascend.chushou.toolkit.b.a.eii().a(chatInfo2.mCoolMessage.mBgImage, c0908a.oiz, a.e.bg_bubble_default);
                                                return;
                                            }
                                            c0908a.oiz.setBackgroundResource(0);
                                            c0908a.oiz.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 4:
                                ChatInfo chatInfo3 = (ChatInfo) a.this.f.get(i);
                                if (chatInfo3 != null && c0908a.oiz != null) {
                                    c0908a.oiz.setTextSize(14.0f);
                                    tv.chushou.zues.widget.a.c cVar4 = new tv.chushou.zues.widget.a.c();
                                    if (chatInfo3.mCoolMessage != null) {
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_name_color), c0908a.oiz, " : ", this.osc);
                                        int length3 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.oio), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mCoolMessage.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0908a.oiz, null, this.osc);
                                        i2 = length3;
                                    } else {
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mNicknameRichText, 18, ContextCompat.getColor(this.b, a.c.kas_red_n), c0908a.oiz)) {
                                            cVar4.a(chatInfo3.mUserNickname + " : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        } else {
                                            cVar4.a(" : ", new ForegroundColorSpan(this.b.getResources().getColor(a.c.kas_red_n)));
                                        }
                                        int length4 = cVar4.length();
                                        cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.oio), 0, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 18);
                                        if (!tv.chushou.zues.toolkit.richtext.b.a(this.b, cVar4, chatInfo3.mContentRichText, 18, ContextCompat.getColor(this.b, a.c.banrrage_chat_text_color), c0908a.oiz)) {
                                            cVar4.a(chatInfo3.mContent, new ForegroundColorSpan(this.b.getResources().getColor(a.c.banrrage_chat_text_color)));
                                        }
                                        i2 = length4;
                                    }
                                    cVar4.append(" ");
                                    if (!h.isEmpty(chatInfo3.mGift.icon)) {
                                        a(c0908a.oiz, c0908a, cVar4, chatInfo3.mGift.icon, a.e.zues_default_gift_color, this.m, this.n);
                                    }
                                    if (chatInfo3.mUserComboCount > 1) {
                                        String valueOf = String.valueOf(chatInfo3.mUserComboCount);
                                        int length5 = valueOf.length();
                                        boolean z = false;
                                        int i8 = 0;
                                        while (i8 < length5) {
                                            String substring = valueOf.substring(i8, i8 + 1);
                                            if (a.this.orU == null) {
                                                a.this.orU = new HashMap();
                                            }
                                            Drawable drawable = null;
                                            if (a.this.orU.containsKey(substring)) {
                                                drawable = (Drawable) a.this.orU.get(substring);
                                            }
                                            if (drawable == null) {
                                                drawable = this.b.getResources().getDrawable(this.b.getResources().getIdentifier("icon_combo_" + substring, "drawable", this.b.getPackageName()));
                                                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                                a.this.orU.put(substring, drawable);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable));
                                            i8++;
                                            z = true;
                                        }
                                        if (z) {
                                            Drawable drawable2 = null;
                                            if (a.this.orU.containsKey("-1")) {
                                                drawable2 = (Drawable) a.this.orU.get("-1");
                                            }
                                            if (drawable2 == null) {
                                                drawable2 = this.b.getResources().getDrawable(a.e.icon_combo);
                                                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                                                a.this.orU.put("-1", drawable2);
                                            }
                                            cVar4.a("", new tv.chushou.zues.widget.a.e(drawable2));
                                        }
                                    }
                                    cVar4.setSpan(new tv.chushou.zues.widget.a.a(this.oin), i2, cVar4.length() + (-1) > 0 ? cVar4.length() - 1 : 0, 17);
                                    c0908a.oiz.setDraweeSpanStringBuilder(cVar4);
                                    c0908a.oiz.setTag(a.f.tag_position, chatInfo3);
                                    c0908a.oiz.setMovementMethod(tv.chushou.zues.widget.a.b.euA());
                                    c0908a.oiz.setFocusable(false);
                                    if (chatInfo3.mCoolMessage != null) {
                                        com.kascend.chushou.toolkit.b.a.eii().a(chatInfo3.mCoolMessage.mBgImage, c0908a.oiz, a.e.bg_bubble_default);
                                        return;
                                    }
                                    c0908a.oiz.setBackgroundResource(0);
                                    c0908a.oiz.setPadding(tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f), tv.chushou.zues.utils.a.dip2px(this.b, 0.0f), tv.chushou.zues.utils.a.dip2px(this.b, 5.0f));
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
                        C0908a c0908a2 = (C0908a) viewHolder;
                        c0908a2.oiz.setOnClickListener(null);
                        tv.chushou.zues.widget.a.c cVar5 = new tv.chushou.zues.widget.a.c();
                        cVar5.a((CharSequence) tv.chushou.widget.a.c.getString(a.i.baidu_live_agreement), new ForegroundColorSpan(Color.parseColor("#ff5959")), new tv.chushou.zues.widget.a.a(this.osb), new UnderlineSpan());
                        c0908a2.oiz.setDraweeSpanStringBuilder(cVar5);
                        c0908a2.oiz.setMovementMethod(tv.chushou.zues.widget.a.b.euA());
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
                    cVar.a("", new b.a().a(callback).zs(true).OH(i2).OI(i3).Wy(str).OG(i).h(simpleDraweeSpanTextView).eiI());
                    cVar.append(" ");
                    return;
                }
                int length = cVar.length();
                com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(a.this.getResources()).MA(i).dYF(), this.b);
                a2.setController(com.facebook.drawee.a.a.c.dXf().VN(str).dXW());
                cVar.append("1");
                cVar.a(a2, length, length, i2, i3, true, 2);
                cVar.append(" ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        com.kascend.chushou.player.b egv;
        if (!h.isEmpty(listItem.mUrl)) {
            Context context = getContext();
            if ((context instanceof VideoPlayer) && (egv = ((VideoPlayer) context).egv()) != null && !h.isEmpty(egv.f4119a)) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("roomId", egv.f4119a);
                Http http = (Http) tv.chushou.basis.d.b.etD().S(Http.class);
                if (http != null) {
                    listItem.mUrl = http.packParams(listItem.mUrl, hashMap);
                }
            }
        }
    }
}
