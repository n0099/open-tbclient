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
/* loaded from: classes5.dex */
public class FoodView extends RelativeLayout {
    private boolean a;
    private float b;
    private boolean d;
    private Context e;
    private int g;
    private String i;
    private int j;
    private boolean m;
    private String n;
    private io.reactivex.disposables.b ncH;
    private ListItem ncI;
    private com.facebook.datasource.b<Void> ncJ;
    private k ncK;
    private tv.chushou.zues.c ncL;
    private Random ncM;
    private k.a ncN;
    private io.reactivex.disposables.a ncO;
    private a ncP;

    public FoodView(Context context) {
        this(context, null, 0);
    }

    public FoodView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoodView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ncH = null;
        this.d = false;
        this.m = false;
        this.n = "";
        this.ncM = new Random();
        this.ncO = new io.reactivex.disposables.a();
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.FoodView);
        this.j = obtainStyledAttributes.getInteger(a.k.FoodView_view_style, 0);
        this.b = obtainStyledAttributes.getFloat(a.k.FoodView_size_ratio, 1.0f);
        obtainStyledAttributes.recycle();
        this.ncK = MX(this.j);
        this.ncK.f(this);
    }

    public void setContext(Context context) {
        this.e = context;
    }

    private k MX(int i) {
        k kVar = k.ndv;
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
            this.ncK = MX(this.j);
            this.ncK.f(this);
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.d;
    }

    private boolean d(ListItem listItem) {
        return (this.d || listItem == null || listItem.mAdExtraInfo == null || !com.kascend.chushou.a.a.dCm().a(listItem.mAdExtraInfo.mCode, listItem.mAdExtraInfo.mIntervalTime)) ? false : true;
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
            aVar.QW(this.n);
            tv.chushou.zues.a.a.post(aVar);
        }
        if (this.e != null && this.ncI != null && this.ncI.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.ncI.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y) {
            if (this.ncI.mAdExtraInfo != null && !this.ncI.mAdExtraInfo.vTrackShow) {
                this.ncI.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.dCm().a(this.ncI);
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
            aVar.QW(this.n);
            tv.chushou.zues.a.a.post(aVar);
        }
        if (this.e != null && this.ncI != null && this.ncI.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.ncI.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.ncI.mAdExtraInfo != null && !this.ncI.mAdExtraInfo.vTrackShow) {
            this.ncI.mAdExtraInfo.vTrackShow = true;
            com.kascend.chushou.a.a.dCm().a(this.ncI);
        }
    }

    private long ab(long j, long j2) {
        if (j > 0 && j2 > 0 && j2 > j) {
            return (long) ((this.ncM.nextDouble() * (j2 - j)) + j);
        }
        return 5L;
    }

    private void a(ListItem listItem, boolean z, boolean z2) {
        a(listItem, z, z2, false);
    }

    private void a(ListItem listItem, boolean z, final boolean z2, boolean z3) {
        if (listItem != null) {
            this.a = z;
            a(listItem, listItem.mAdExtraInfo);
            this.ncI = listItem;
            this.ncK.a(listItem, z, z3);
            if (listItem.mAutoCloseTime > 0) {
                this.ncH = io.reactivex.g.a(0L, listItem.mAutoCloseTime, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJJ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.ui.food.FoodView.1
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
        if (this.ncI == null && adExtraInfo != null && adExtraInfo.mAdvertAutoRefreshTimes > 0 && this.ncL == null) {
            this.ncL = dEy();
        }
        if (adExtraInfo != null && adExtraInfo.mAdvertAutoRefreshTimes > 0) {
            if (this.ncL != null && !TextUtils.isEmpty(adExtraInfo.mAdvertRefreshUrl)) {
                long ab = ab(adExtraInfo.mAdvertMinFreshIntervalSecond, adExtraInfo.mAdvertMaxFreshIntervalSecond);
                Message On = this.ncL.On(10101);
                On.obj = listItem;
                this.ncL.a(On, ab * 1000);
            }
            adExtraInfo.mAdvertAutoRefreshTimes--;
        }
    }

    @NonNull
    private tv.chushou.zues.c dEy() {
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
        com.kascend.chushou.a.a.dCm().a(listItem.mAdExtraInfo.mAdvertRefreshUrl, listItem.mAdExtraInfo.mCode, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.5
            @Override // com.kascend.chushou.a.a.b
            public void a(ListItem listItem2) {
                if (listItem2 != null && listItem2.mAdExtraInfo != null) {
                    listItem.adCopy(listItem2);
                }
                RxExecutor.post(FoodView.this.ncO, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.5.1
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
            this.ncK.a(listItem, this.ncN);
            if (this.e != null) {
                listItem.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.dCm().a(listItem);
            }
            a(listItem, listItem.mAdExtraInfo);
            this.ncK.a(listItem, this.a);
        }
    }

    public void a(final ListItem listItem, final int i, final int i2, final boolean z) {
        if (d(listItem)) {
            this.ncN = null;
            this.ncK.a(listItem, (k.a) null);
            this.d = true;
            if (this.ncK.b()) {
                a(i2, listItem, z, i);
            } else if (listItem.mAdExtraInfo != null && com.kascend.chushou.a.a.y == tv.chushou.zues.utils.h.parseInt(listItem.mAdExtraInfo.mMarketId)) {
                a(i2, listItem, z, i);
            } else {
                this.ncJ = tv.chushou.zues.widget.fresco.a.a(listItem.mCover, this.e, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.6
                    @Override // tv.chushou.zues.widget.fresco.a.b
                    public void finish() {
                        RxExecutor.post(FoodView.this.ncO, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FoodView.this.a(i2, listItem, z, i);
                            }
                        });
                    }

                    @Override // tv.chushou.zues.widget.fresco.a.b
                    public void dEz() {
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
        this.ncI = null;
        this.ncN = null;
        this.ncK.a(listItem, (k.a) null);
        this.d = true;
        this.ncP = aVar;
        if (this.ncK.b() || z) {
            b(listItem);
            return true;
        } else if (listItem.mAdExtraInfo != null && com.kascend.chushou.a.a.y == tv.chushou.zues.utils.h.parseInt(listItem.mAdExtraInfo.mMarketId)) {
            b(listItem);
            return true;
        } else {
            this.ncJ = tv.chushou.zues.widget.fresco.a.a(listItem.mCover, this.e, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.7
                @Override // tv.chushou.zues.widget.fresco.a.b
                public void finish() {
                    RxExecutor.post(FoodView.this.ncO, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FoodView.this.b(listItem);
                        }
                    });
                }

                @Override // tv.chushou.zues.widget.fresco.a.b
                public void dEz() {
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
            this.ncI = null;
            k.a aVar2 = new k.a();
            aVar2.a = z;
            aVar2.b = z3;
            aVar2.c = i;
            aVar2.d = i2;
            aVar2.e = i3;
            this.ncN = aVar2;
            this.ncK.a(listItem, aVar2);
            this.d = true;
            this.ncP = aVar;
            a(listItem, true, false, z2);
            if (z) {
                this.i = str;
            }
            if (this.e != null && this.ncI != null && this.ncI.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.ncI.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.ncI.mAdExtraInfo != null && !this.ncI.mAdExtraInfo.vTrackShow) {
                this.ncI.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.dCm().a(this.ncI);
            }
        }
    }

    public void b(ListItem listItem, a aVar, boolean z, String str) {
        if (listItem != null) {
            d();
            this.ncI = null;
            k.a aVar2 = new k.a();
            aVar2.a = z;
            aVar2.f = true;
            this.ncN = aVar2;
            this.ncK.a(listItem, aVar2);
            this.d = true;
            if (z) {
                this.i = str;
            }
            this.ncP = aVar;
            a(listItem, true, false);
            if (this.e != null && this.ncI != null && this.ncI.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.ncI.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.ncI.mAdExtraInfo != null && !this.ncI.mAdExtraInfo.vTrackShow) {
                this.ncI.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.dCm().a(this.ncI);
            }
        }
    }

    public void a(ListItem listItem, a aVar, boolean z, String str, int i) {
        if (listItem != null) {
            setVisibility(0);
            d();
            this.ncI = null;
            k.a aVar2 = new k.a();
            aVar2.a = z;
            aVar2.f = true;
            aVar2.h = i;
            this.ncN = aVar2;
            this.ncK.a(listItem, aVar2);
            this.d = true;
            if (z) {
                this.i = str;
            }
            this.ncP = aVar;
            a(listItem, true, false);
            if (this.e != null && this.ncI != null && this.ncI.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.ncI.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.ncI.mAdExtraInfo != null && !this.ncI.mAdExtraInfo.vTrackShow) {
                this.ncI.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.dCm().a(this.ncI);
            }
        }
    }

    public void a(ListItem listItem, int i, a aVar) {
        if (d(listItem)) {
            this.ncI = null;
            this.ncN = null;
            this.ncK.a(listItem, (k.a) null);
            this.ncP = aVar;
            this.d = true;
            a(listItem, true, false);
            if (this.e != null && this.ncI != null && this.ncI.mAdExtraInfo != null && tv.chushou.zues.utils.h.parseInt(this.ncI.mAdExtraInfo.mMarketId) != com.kascend.chushou.a.a.y && this.ncI.mAdExtraInfo != null && !this.ncI.mAdExtraInfo.vTrackShow) {
                this.ncI.mAdExtraInfo.vTrackShow = true;
                com.kascend.chushou.a.a.dCm().a(this.ncI);
            }
        }
    }

    public void a(final ListItem listItem, boolean z, final int i, final int i2, a aVar) {
        if (!this.d && listItem != null && listItem.mAdExtraInfo != null) {
            this.ncI = null;
            k.a aVar2 = new k.a();
            aVar2.g = z;
            this.ncN = aVar2;
            this.ncK.a(listItem, aVar2);
            this.d = true;
            this.ncP = aVar;
            if (this.ncK.b()) {
                a(i2, listItem, false, i);
                if (this.ncP != null) {
                    this.ncP.b();
                    return;
                }
                return;
            }
            this.ncJ = tv.chushou.zues.widget.fresco.a.a(listItem.mCover, this.e, new a.b() { // from class: com.kascend.chushou.player.ui.food.FoodView.8
                @Override // tv.chushou.zues.widget.fresco.a.b
                public void finish() {
                    RxExecutor.post(FoodView.this.ncO, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.ui.food.FoodView.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FoodView.this.a(i2, listItem, false, i);
                            if (FoodView.this.ncP != null) {
                                FoodView.this.ncP.b();
                            }
                        }
                    });
                }

                @Override // tv.chushou.zues.widget.fresco.a.b
                public void dEz() {
                    FoodView.this.d = false;
                    if (FoodView.this.ncP != null) {
                        FoodView.this.ncP.a();
                    }
                }
            });
        }
    }

    public void a() {
        this.d = false;
        boolean z = true;
        if (this.ncP != null) {
            z = this.ncP.a();
            this.ncP = null;
        }
        if (this.m) {
            com.kascend.chushou.player.ui.button.a aVar = new com.kascend.chushou.player.ui.button.a(4, 8);
            aVar.QW(this.n);
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
                        aVar.QW(FoodView.this.n);
                        tv.chushou.zues.a.a.post(aVar);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!FoodView.this.d) {
                        boolean z = true;
                        if (FoodView.this.ncP != null) {
                            z = FoodView.this.ncP.a();
                            FoodView.this.ncP = null;
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
        if (this.ncH != null && !this.ncH.isDisposed()) {
            this.ncH.dispose();
        }
        this.ncH = null;
        a();
        if (this.e != null && this.ncI != null) {
            com.kascend.chushou.a.a.dCm().c(this.ncI);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        if (this.ncI != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__DOWN_X__", String.valueOf(i));
                jSONObject.put("__DOWN_Y__", String.valueOf(i2));
                jSONObject.put("__UP_X__", String.valueOf(i3));
                jSONObject.put("__UP_Y__", String.valueOf(i4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.a.a.dCm().a(this.ncI, 0, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2, int i3, int i4) {
        if (this.e != null && this.ncI != null) {
            String str = Constants.VIA_ACT_TYPE_NINETEEN;
            if (!tv.chushou.zues.utils.h.isEmpty(this.i)) {
                str = this.i;
            }
            JSONObject N = com.kascend.chushou.d.e.N("_fromView", str);
            try {
                N.put("__DOWN_X__", String.valueOf(i));
                N.put("__DOWN_Y__", String.valueOf(i2));
                N.put("__UP_X__", String.valueOf(i3));
                N.put("__UP_Y__", String.valueOf(i4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.d.e.a(this.e, this.ncI, N);
            if ((this.ncK instanceof e) && this.ncP != null) {
                this.ncP.a();
            }
        }
    }

    public void d() {
        if (this.ncH != null && !this.ncH.isDisposed()) {
            this.ncH.dispose();
        }
        this.ncH = null;
        this.ncI = null;
        if (this.ncJ != null) {
            this.ncJ.OG();
            this.ncJ = null;
        }
        if (this.ncL != null) {
            this.ncL.cq(null);
        }
        if (this.ncK != null) {
            this.ncK.e();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class a {
        public abstract boolean a();

        public void b() {
        }
    }
}
