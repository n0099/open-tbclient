package com.kascend.chushou.player.ui.food;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.widget.cswebview.CSWebView;
/* loaded from: classes6.dex */
public abstract class k {
    public static final k nzV = new k() { // from class: com.kascend.chushou.player.ui.food.k.2
        @Override // com.kascend.chushou.player.ui.food.k
        int a() {
            return 17367043;
        }

        @Override // com.kascend.chushou.player.ui.food.k
        void a(ListItem listItem, a aVar) {
        }

        @Override // com.kascend.chushou.player.ui.food.k
        void a(ListItem listItem, boolean z) {
        }
    };
    private boolean a;
    FoodView nzT;
    private com.kascend.chushou.player.ui.food.a nzU;
    Context q;
    int m = AdCard.INVALID_NUM;
    int n = AdCard.INVALID_NUM;
    int o = AdCard.INVALID_NUM;
    int p = AdCard.INVALID_NUM;
    private long c = 0;
    private boolean d = false;

    /* loaded from: classes6.dex */
    public static class a {
        public boolean a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public int h;
    }

    abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(ListItem listItem, a aVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(ListItem listItem, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    @CallSuper
    public void f(FoodView foodView) {
        this.q = foodView.getContext();
        this.nzT = foodView;
        this.nzT.removeAllViews();
        LayoutInflater.from(foodView.getContext()).inflate(a(), (ViewGroup) foodView, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean a(ListItem listItem, @NonNull ViewGroup viewGroup) {
        if (listItem.mAdExtraInfo != null && com.kascend.chushou.a.a.t.equals(listItem.mAdExtraInfo.mShowType)) {
            if (viewGroup.getChildCount() > 0) {
                if (viewGroup.getChildAt(0) instanceof com.kascend.chushou.player.ui.food.a) {
                    this.a = true;
                } else {
                    viewGroup.removeAllViews();
                    this.nzU = null;
                    this.a = false;
                }
            } else {
                this.nzU = new com.kascend.chushou.player.ui.food.a(this.q.getApplicationContext());
                this.nzU.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.player.ui.food.k.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getActionMasked() == 0) {
                            k.this.m = (int) motionEvent.getX();
                            k.this.n = (int) motionEvent.getY();
                            k.this.o = AdCard.INVALID_NUM;
                            k.this.p = AdCard.INVALID_NUM;
                        } else if (motionEvent.getActionMasked() == 1) {
                            k.this.o = (int) motionEvent.getX();
                            k.this.p = (int) motionEvent.getY();
                            k.this.nzT.a(k.this.m, k.this.n, k.this.o, k.this.p);
                        }
                        if (k.this.d) {
                            return false;
                        }
                        if (motionEvent.getActionMasked() != 1 || System.currentTimeMillis() - k.this.c <= 1000) {
                            return true;
                        }
                        k.this.nzU.performClick();
                        k.this.c = System.currentTimeMillis();
                        return true;
                    }
                });
                CSWebView.a(this.nzU, this.q, null, null);
                this.nzU.resumeTimers();
                this.nzU.onResume();
                viewGroup.addView(this.nzU, 0, new ViewGroup.LayoutParams(-1, -1));
                this.a = true;
            }
        } else {
            this.a = false;
            if (viewGroup.getChildCount() > 0) {
                if (viewGroup.getChildAt(0) instanceof com.kascend.chushou.player.ui.food.a) {
                    ((com.kascend.chushou.player.ui.food.a) viewGroup.getChildAt(0)).destroy();
                }
                viewGroup.removeAllViews();
                this.nzU = null;
            }
        }
        return this.a;
    }

    public boolean b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.d = true;
        if (dOj() != null) {
            dOj().setEnableTouch(true);
        }
    }

    @Nullable
    public com.kascend.chushou.player.ui.food.a dOj() {
        return this.nzU;
    }

    public void a(ListItem listItem, boolean z, boolean z2) {
        a(listItem, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CallSuper
    public void e() {
        if (this.nzU != null) {
            this.nzU.destroy();
            this.nzU = null;
        }
    }

    @Nullable
    public final <T extends View> T KG(@IdRes int i) {
        if (this.nzT == null) {
            return null;
        }
        return (T) this.nzT.findViewById(i);
    }
}
