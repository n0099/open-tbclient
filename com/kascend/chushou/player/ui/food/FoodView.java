package com.kascend.chushou.player.ui.food;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.a.a;
import com.kascend.chushou.constants.AdExtraInfo;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.k;
import com.tencent.connect.common.Constants;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.widget.fresco.a;
/* loaded from: classes6.dex */
public class FoodView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4153a;
    private float b;
    private boolean d;
    private Context e;
    private int g;
    private String i;
    private int j;
    private boolean m;
    private String n;
    private io.reactivex.disposables.b osA;
    private ListItem osB;
    private com.facebook.datasource.b<Void> osC;
    private k osD;
    private tv.chushou.zues.c osE;
    private Random osF;
    private k.a osG;
    private io.reactivex.disposables.a osH;
    private a osI;

    public FoodView(Context context) {
        this(context, null, 0);
    }

    public FoodView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoodView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osA = null;
        this.d = false;
        this.m = false;
        this.n = "";
        this.osF = new Random();
        this.osH = new io.reactivex.disposables.a();
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.FoodView);
        this.j = obtainStyledAttributes.getInteger(a.k.FoodView_view_style, 0);
        this.b = obtainStyledAttributes.getFloat(a.k.FoodView_size_ratio, 1.0f);
        obtainStyledAttributes.recycle();
        this.osD = Ou(this.j);
        this.osD.f(this);
    }

    public void setContext(Context context) {
        this.e = context;
    }

    private k Ou(int i) {
        k kVar = k.oto;
        if (i == 0) {
            return new f();
        }
        if (i == 1) {
            return new j();
        }
        if (i == 2) {
            return new c();
        }
        if (i == 3) {
            return new d();
        }
        if (i == 4) {
            return new i();
        }
        if (i == 5) {
            return new e();
        }
        if (i == 6) {
            return new g(this.b);
        }
        if (i == 7) {
            return new h();
        }
        if (i == 8) {
            return new b();
        }
        return kVar;
    }

    public void setStyle(int i) {
        if (this.j != i) {
            d();
            this.j = i;
            this.osD = Ou(this.j);
            this.osD.f(this);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.d;
    }

    private boolean d(ListItem listItem) {
        return (this.d || listItem == null || listItem.mAdExtraInfo == null || !com.kascend.chushou.a.a.egc().a(listItem.mAdExtraInfo.mCode, listItem.mAdExtraInfo.mIntervalTime)) ? false : true;
    }

    public void a(boolean z, String str) {
        this.m = z;
        this.n = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ListItem listItem, boolean z, int i2) {
        this.g = i;
        a(listItem, z, true);
        setVisibility(0);
        startAnimation(AnimationUtils.loadAnimation(this.e, i2));
        if (this.m) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(4, 0);
            aVar.Wq(this.n);
            tv.chushou.zues.a.a.post(aVar);
        }
        if (this.e != null && this.osB != null && this.osB.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.osB.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y) {
            if (this.osB.mAdExtraInfo != null && !this.osB.mAdExtraInfo.vTrackShow) {
                this.osB.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.egc().a(this.osB);
            }
            tv.chushou.zues.utils.e.d("FoodView", "FoodView:" + toString() + ",Method:updateWithAnimation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ListItem listItem) {
        a(listItem, true, false);
        setVisibility(0);
        if (this.m) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(4, 0);
            aVar.Wq(this.n);
            tv.chushou.zues.a.a.post(aVar);
        }
        if (this.e != null && this.osB != null && this.osB.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.osB.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.osB.mAdExtraInfo != null && !this.osB.mAdExtraInfo.vTrackShow) {
            this.osB.mAdExtraInfo.vTrackShow = true;
            com.kascend.chushou.a.a.egc().a(this.osB);
        }
    }

    private long K(long j, long j2) {
        if (j > 0 && j2 > 0 && j2 > j) {
            return (long) ((this.osF.nextDouble() * (j2 - j)) + j);
        }
        return 5L;
    }

    private void a(ListItem listItem, boolean z, boolean z2) {
        a(listItem, z, z2, false);
    }

    private void a(ListItem listItem, boolean z, final boolean z2, boolean z3) {
        if (listItem != null) {
            this.f4153a = z;
            a(listItem, listItem.mAdExtraInfo);
            this.osB = listItem;
            this.osD.a(listItem, z, z3);
            if (listItem.mAutoCloseTime > 0) {
                this.osA = io.reactivex.g.a(0L, listItem.mAutoCloseTime, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.emM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.food.FoodView.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Long l) throws Exception {
                    }
                }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.ui.food.FoodView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // io.reactivex.c.g
                    /* renamed from: a */
                    public void accept(Throwable th) throws Exception {
                    }
                }, new io.reactivex.c.a() { // from class: com.kascend.chushou.player.ui.food.FoodView.3
                    @Override // io.reactivex.c.a
                    public void run() throws Exception {
                        if (z2) {
                            FoodView.this.b();
                        } else {
                            FoodView.this.a();
                        }
                    }
                });
            }
        }
    }

    private void a(ListItem listItem, AdExtraInfo adExtraInfo) {
        if (this.osB == null && adExtraInfo != null && adExtraInfo.mAdvertAutoRefreshTimes > 0 && this.osE == null) {
            this.osE = eib();
        }
        if (adExtraInfo != null && adExtraInfo.mAdvertAutoRefreshTimes > 0) {
            if (this.osE != null && !TextUtils.isEmpty(adExtraInfo.mAdvertRefreshUrl)) {
                long K = K(adExtraInfo.mAdvertMinFreshIntervalSecond, adExtraInfo.mAdvertMaxFreshIntervalSecond);
                Message PJ = this.osE.PJ(10101);
                PJ.obj = listItem;
                this.osE.b(PJ, K * 1000);
            }
            adExtraInfo.mAdvertAutoRefreshTimes--;
        }
    }

    @NonNull
    private tv.chushou.zues.c eib() {
        return new tv.chushou.zues.c(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kascend.chushou.player.ui.food.FoodView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 10101:
                        if (message.obj != null && (message.obj instanceof ListItem)) {
                            FoodView.this.a(message);
                            return false;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        final ListItem listItem = (ListItem) message.obj;
        com.kascend.chushou.a.a.egc().a(listItem.mAdExtraInfo.mAdvertRefreshUrl, listItem.mAdExtraInfo.mCode, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.5
            @Override // com.kascend.chushou.a.a.b
            public void a(ListItem listItem2) {
                if (listItem2 != null && listItem2.mAdExtraInfo != null) {
                    listItem.adCopy(listItem2);
                }
                RxExecutor.post(FoodView.this.osH, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FoodView.this.c(listItem);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ListItem listItem) {
        if (this.d) {
            this.osD.a(listItem, this.osG);
            if (this.e != null) {
                listItem.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.egc().a(listItem);
            }
            a(listItem, listItem.mAdExtraInfo);
            this.osD.a(listItem, this.f4153a);
        }
    }

    public void a(final ListItem listItem, final int i, final int i2, final boolean z) {
        if (d(listItem)) {
            this.osG = null;
            this.osD.a(listItem, (k.a) null);
            this.d = true;
            if (this.osD.b()) {
                a(i2, listItem, z, i);
            } else if (listItem.mAdExtraInfo != null && com.kascend.chushou.a.a.y == tv.chushou.zues.utils.h.parseInt(listItem.mAdExtraInfo.mMarketId)) {
                a(i2, listItem, z, i);
            } else {
                this.osC = tv.chushou.zues.widget.fresco.a.a(listItem.mCover, this.e, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.6
                    @Override // tv.chushou.zues.widget.fresco.a.b
                    public void finish() {
                        RxExecutor.post(FoodView.this.osH, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FoodView.this.a(i2, listItem, z, i);
                            }
                        });
                    }

                    @Override // tv.chushou.zues.widget.fresco.a.b
                    public void eic() {
                        FoodView.this.d = false;
                    }
                });
            }
        }
    }

    public boolean a(final ListItem listItem, a aVar, boolean z) {
        if (!d(listItem)) {
            return false;
        }
        this.osB = null;
        this.osG = null;
        this.osD.a(listItem, (k.a) null);
        this.d = true;
        this.osI = aVar;
        if (this.osD.b() || z) {
            b(listItem);
            return true;
        } else if (listItem.mAdExtraInfo != null && com.kascend.chushou.a.a.y == tv.chushou.zues.utils.h.parseInt(listItem.mAdExtraInfo.mMarketId)) {
            b(listItem);
            return true;
        } else {
            this.osC = tv.chushou.zues.widget.fresco.a.a(listItem.mCover, this.e, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.7
                @Override // tv.chushou.zues.widget.fresco.a.b
                public void finish() {
                    RxExecutor.post(FoodView.this.osH, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FoodView.this.b(listItem);
                        }
                    });
                }

                @Override // tv.chushou.zues.widget.fresco.a.b
                public void eic() {
                    FoodView.this.d = false;
                }
            });
            return true;
        }
    }

    public void a(ListItem listItem, a aVar, boolean z, String str, boolean z2) {
        a(listItem, aVar, z, str, 144, 77, 0, false, z2);
    }

    public void a(ListItem listItem, a aVar, boolean z, String str) {
        a(listItem, aVar, z, str, 144, 77, 0, false, true);
    }

    public void a(ListItem listItem, a aVar, boolean z, String str, int i, int i2, int i3) {
        a(listItem, aVar, z, str, i, i2, i3, false, true);
    }

    public void a(ListItem listItem, a aVar, boolean z, String str, int i, int i2, int i3, boolean z2, boolean z3) {
        if (listItem != null) {
            d();
            this.osB = null;
            k.a aVar2 = new k.a();
            aVar2.f4162a = z;
            aVar2.b = z3;
            aVar2.c = i;
            aVar2.d = i2;
            aVar2.e = i3;
            this.osG = aVar2;
            this.osD.a(listItem, aVar2);
            this.d = true;
            this.osI = aVar;
            a(listItem, true, false, z2);
            if (z) {
                this.i = str;
            }
            if (this.e != null && this.osB != null && this.osB.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.osB.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.osB.mAdExtraInfo != null && !this.osB.mAdExtraInfo.vTrackShow) {
                this.osB.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.egc().a(this.osB);
            }
        }
    }

    public void b(ListItem listItem, a aVar, boolean z, String str) {
        if (listItem != null) {
            d();
            this.osB = null;
            k.a aVar2 = new k.a();
            aVar2.f4162a = z;
            aVar2.f = true;
            this.osG = aVar2;
            this.osD.a(listItem, aVar2);
            this.d = true;
            if (z) {
                this.i = str;
            }
            this.osI = aVar;
            a(listItem, true, false);
            if (this.e != null && this.osB != null && this.osB.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.osB.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.osB.mAdExtraInfo != null && !this.osB.mAdExtraInfo.vTrackShow) {
                this.osB.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.egc().a(this.osB);
            }
        }
    }

    public void a(ListItem listItem, a aVar, boolean z, String str, int i) {
        if (listItem != null) {
            setVisibility(0);
            d();
            this.osB = null;
            k.a aVar2 = new k.a();
            aVar2.f4162a = z;
            aVar2.f = true;
            aVar2.h = i;
            this.osG = aVar2;
            this.osD.a(listItem, aVar2);
            this.d = true;
            if (z) {
                this.i = str;
            }
            this.osI = aVar;
            a(listItem, true, false);
            if (this.e != null && this.osB != null && this.osB.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.osB.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.osB.mAdExtraInfo != null && !this.osB.mAdExtraInfo.vTrackShow) {
                this.osB.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.egc().a(this.osB);
            }
        }
    }

    public void a(ListItem listItem, int i, a aVar) {
        if (d(listItem)) {
            this.osB = null;
            this.osG = null;
            this.osD.a(listItem, (k.a) null);
            this.osI = aVar;
            this.d = true;
            a(listItem, true, false);
            if (this.e != null && this.osB != null && this.osB.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.osB.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.osB.mAdExtraInfo != null && !this.osB.mAdExtraInfo.vTrackShow) {
                this.osB.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.egc().a(this.osB);
            }
        }
    }

    public void a(final ListItem listItem, boolean z, final int i, final int i2, a aVar) {
        if (!this.d && listItem != null && listItem.mAdExtraInfo != null) {
            this.osB = null;
            k.a aVar2 = new k.a();
            aVar2.g = z;
            this.osG = aVar2;
            this.osD.a(listItem, aVar2);
            this.d = true;
            this.osI = aVar;
            if (this.osD.b()) {
                a(i2, listItem, false, i);
                if (this.osI != null) {
                    this.osI.b();
                    return;
                }
                return;
            }
            this.osC = tv.chushou.zues.widget.fresco.a.a(listItem.mCover, this.e, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.8
                @Override // tv.chushou.zues.widget.fresco.a.b
                public void finish() {
                    RxExecutor.post(FoodView.this.osH, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FoodView.this.a(i2, listItem, false, i);
                            if (FoodView.this.osI != null) {
                                FoodView.this.osI.b();
                            }
                        }
                    });
                }

                @Override // tv.chushou.zues.widget.fresco.a.b
                public void eic() {
                    FoodView.this.d = false;
                    if (FoodView.this.osI != null) {
                        FoodView.this.osI.a();
                    }
                }
            });
        }
    }

    public void a() {
        this.d = false;
        boolean z = true;
        if (this.osI != null) {
            z = this.osI.a();
            this.osI = null;
        }
        if (this.m) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(4, 8);
            aVar.Wq(this.n);
            tv.chushou.zues.a.a.post(aVar);
        }
        if (z) {
            setVisibility(8);
        }
        d();
    }

    public void b() {
        if (this.d) {
            this.d = false;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.e, this.g);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.kascend.chushou.player.ui.food.FoodView.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (FoodView.this.m) {
                        com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(4, 8);
                        aVar.Wq(FoodView.this.n);
                        tv.chushou.zues.a.a.post(aVar);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!FoodView.this.d) {
                        boolean z = true;
                        if (FoodView.this.osI != null) {
                            z = FoodView.this.osI.a();
                            FoodView.this.osI = null;
                        }
                        if (z) {
                            FoodView.this.setVisibility(8);
                        }
                        FoodView.this.d();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.osA != null && !this.osA.isDisposed()) {
            this.osA.dispose();
        }
        this.osA = null;
        a();
        if (this.e != null && this.osB != null) {
            com.kascend.chushou.a.a.egc().c(this.osB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        if (this.osB != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__DOWN_X__", String.valueOf(i));
                jSONObject.put("__DOWN_Y__", String.valueOf(i2));
                jSONObject.put("__UP_X__", String.valueOf(i3));
                jSONObject.put("__UP_Y__", String.valueOf(i4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.a.a.egc().a(this.osB, 0, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2, int i3, int i4) {
        if (this.e != null && this.osB != null) {
            String str = Constants.VIA_ACT_TYPE_NINETEEN;
            if (!tv.chushou.zues.utils.h.isEmpty(this.i)) {
                str = this.i;
            }
            JSONObject O = com.kascend.chushou.d.e.O("_fromView", str);
            try {
                O.put("__DOWN_X__", String.valueOf(i));
                O.put("__DOWN_Y__", String.valueOf(i2));
                O.put("__UP_X__", String.valueOf(i3));
                O.put("__UP_Y__", String.valueOf(i4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.d.e.a(this.e, this.osB, O);
            if ((this.osD instanceof e) && this.osI != null) {
                this.osI.a();
            }
        }
    }

    public void d() {
        if (this.osA != null && !this.osA.isDisposed()) {
            this.osA.dispose();
        }
        this.osA = null;
        this.osB = null;
        if (this.osC != null) {
            this.osC.akV();
            this.osC = null;
        }
        if (this.osE != null) {
            this.osE.co(null);
        }
        if (this.osD != null) {
            this.osD.e();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class a {
        public abstract boolean a();

        public void b() {
        }
    }
}
