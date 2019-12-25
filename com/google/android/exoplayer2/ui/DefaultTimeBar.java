package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.a;
import com.google.android.exoplayer2.ui.c;
import com.google.android.exoplayer2.util.v;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes4.dex */
public class DefaultTimeBar extends View implements c {
    private long duration;
    private long fIt;
    private final int gNI;
    private final CopyOnWriteArraySet<c.a> kXD;
    private final Rect myR;
    private final Rect myS;
    private final Rect myT;
    private final Rect myU;
    private final Paint myV;
    private final Paint myW;
    private final Paint myX;
    private final Paint myY;
    private final Paint myZ;
    private final Paint mza;
    private final Drawable mzb;
    private final int mzc;
    private final int mzd;
    private final int mze;
    private final int mzf;
    private final int mzg;
    private final int mzh;
    private final int mzi;
    private final StringBuilder mzj;
    private final Formatter mzk;
    private final Runnable mzl;
    private int mzm;
    private long mzn;
    private int mzo;
    private int[] mzp;
    private Point mzq;
    private boolean mzr;
    private long mzs;
    private long mzt;
    private int mzu;
    private long[] mzv;
    private boolean[] mzw;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myR = new Rect();
        this.myS = new Rect();
        this.myT = new Rect();
        this.myU = new Rect();
        this.myV = new Paint();
        this.myW = new Paint();
        this.myX = new Paint();
        this.myY = new Paint();
        this.myZ = new Paint();
        this.mza = new Paint();
        this.mza.setAntiAlias(true);
        this.kXD = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mzi = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mzb = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mzb != null) {
                    a(this.mzb, getLayoutDirection());
                    a2 = Math.max(this.mzb.getMinimumHeight(), a2);
                }
                this.gNI = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mzc = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mzd = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mze = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mzf = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mzg = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, Lv(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, Lx(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, Lw(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, Ly(i5));
                this.myV.setColor(i);
                this.mza.setColor(i2);
                this.myW.setColor(i3);
                this.myX.setColor(i4);
                this.myY.setColor(i5);
                this.myZ.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gNI = a;
            this.mzc = a2;
            this.mzd = a3;
            this.mze = a4;
            this.mzf = a5;
            this.mzg = a6;
            this.myV.setColor(-1);
            this.mza.setColor(Lv(-1));
            this.myW.setColor(Lx(-1));
            this.myX.setColor(Lw(-1));
            this.myY.setColor(-1291845888);
            this.mzb = null;
        }
        this.mzj = new StringBuilder();
        this.mzk = new Formatter(this.mzj, Locale.getDefault());
        this.mzl = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vC(false);
            }
        };
        if (this.mzb != null) {
            this.mzh = (this.mzb.getMinimumWidth() + 1) / 2;
        } else {
            this.mzh = (Math.max(this.mzf, Math.max(this.mze, this.mzg)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mzn = -9223372036854775807L;
        this.mzm = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dwd();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.kXD.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mzm = -1;
        this.mzn = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mzm = i;
        this.mzn = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fIt = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mzt = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mzr && j == -9223372036854775807L) {
            vC(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mzu = i;
        this.mzv = jArr;
        this.mzw = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mzr && !z) {
            vC(true);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        ac(canvas);
        ad(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.duration <= 0) {
            return false;
        }
        Point ab = ab(motionEvent);
        int i = ab.x;
        int i2 = ab.y;
        switch (motionEvent.getAction()) {
            case 0:
                if (E(i, i2)) {
                    dwe();
                    bD(i);
                    this.mzs = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mzr) {
                    vC(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mzr) {
                    if (i2 < this.mzi) {
                        bD(((i - this.mzo) / 3) + this.mzo);
                    } else {
                        this.mzo = i;
                        bD(i);
                    }
                    this.mzs = getScrubberPosition();
                    Iterator<c.a> it = this.kXD.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mzs);
                    }
                    update();
                    invalidate();
                    return true;
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            switch (i) {
                case 21:
                    positionIncrement = -positionIncrement;
                    if (gA(positionIncrement)) {
                        removeCallbacks(this.mzl);
                        postDelayed(this.mzl, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gA(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mzr) {
                        removeCallbacks(this.mzl);
                        this.mzl.run();
                        return true;
                    }
                    break;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        dwf();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mzb != null) {
            this.mzb.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mzc;
        } else if (mode != 1073741824) {
            size = Math.min(this.mzc, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dwf();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mzc) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mzc - this.gNI) / 2) + i5;
        this.myR.set(paddingLeft, i5, paddingRight, this.mzc + i5);
        this.myS.set(this.myR.left + this.mzh, i6, this.myR.right - this.mzh, this.gNI + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mzb != null && a(this.mzb, i)) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(DefaultTimeBar.class.getName());
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DefaultTimeBar.class.getCanonicalName());
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.duration > 0) {
            if (v.SDK_INT >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (v.SDK_INT >= 16) {
                accessibilityNodeInfo.addAction(4096);
                accessibilityNodeInfo.addAction(8192);
            }
        }
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.duration <= 0) {
            return false;
        }
        if (i == 8192) {
            if (gA(-getPositionIncrement())) {
                vC(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (gA(getPositionIncrement())) {
                vC(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    private void dwd() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dwe() {
        this.mzr = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.kXD.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(boolean z) {
        this.mzr = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.kXD.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.myT.set(this.myS);
        this.myU.set(this.myS);
        long j = this.mzr ? this.mzs : this.fIt;
        if (this.duration > 0) {
            this.myT.right = Math.min(((int) ((this.myS.width() * this.mzt) / this.duration)) + this.myS.left, this.myS.right);
            this.myU.right = Math.min(((int) ((j * this.myS.width()) / this.duration)) + this.myS.left, this.myS.right);
        } else {
            this.myT.right = this.myS.left;
            this.myU.right = this.myS.left;
        }
        invalidate(this.myR);
    }

    private void bD(float f) {
        this.myU.right = v.al((int) f, this.myS.left, this.myS.right);
    }

    private Point ab(MotionEvent motionEvent) {
        if (this.mzp == null) {
            this.mzp = new int[2];
            this.mzq = new Point();
        }
        getLocationOnScreen(this.mzp);
        this.mzq.set(((int) motionEvent.getRawX()) - this.mzp[0], ((int) motionEvent.getRawY()) - this.mzp[1]);
        return this.mzq;
    }

    private long getScrubberPosition() {
        if (this.myS.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.myU.width() * this.duration) / this.myS.width();
    }

    private boolean E(float f, float f2) {
        return this.myR.contains((int) f, (int) f2);
    }

    private void ac(Canvas canvas) {
        int min;
        int height = this.myS.height();
        int centerY = this.myS.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.myS.left, centerY, this.myS.right, i, this.myX);
            return;
        }
        int i2 = this.myT.left;
        int i3 = this.myT.right;
        int max = Math.max(Math.max(this.myS.left, i3), this.myU.right);
        if (max < this.myS.right) {
            canvas.drawRect(max, centerY, this.myS.right, i, this.myX);
        }
        int max2 = Math.max(i2, this.myU.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.myW);
        }
        if (this.myU.width() > 0) {
            canvas.drawRect(this.myU.left, centerY, this.myU.right, i, this.myV);
        }
        int i4 = this.mzd / 2;
        for (int i5 = 0; i5 < this.mzu; i5++) {
            canvas.drawRect(Math.min(this.myS.width() - this.mzd, Math.max(0, ((int) ((v.g(this.mzv[i5], 0L, this.duration) * this.myS.width()) / this.duration)) - i4)) + this.myS.left, centerY, min + this.mzd, i, this.mzw[i5] ? this.myZ : this.myY);
        }
    }

    private void ad(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int al = v.al(this.myU.right, this.myU.left, this.myS.right);
            int centerY = this.myU.centerY();
            if (this.mzb == null) {
                if (this.mzr || isFocused()) {
                    i = this.mzg;
                } else {
                    i = isEnabled() ? this.mze : this.mzf;
                }
                canvas.drawCircle(al, centerY, i / 2, this.mza);
                return;
            }
            int intrinsicWidth = this.mzb.getIntrinsicWidth();
            int intrinsicHeight = this.mzb.getIntrinsicHeight();
            this.mzb.setBounds(al - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + al, (intrinsicHeight / 2) + centerY);
            this.mzb.draw(canvas);
        }
    }

    private void dwf() {
        if (this.mzb != null && this.mzb.isStateful() && this.mzb.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mzj, this.mzk, this.fIt);
    }

    private long getPositionIncrement() {
        if (this.mzn == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mzm;
        }
        return this.mzn;
    }

    private boolean gA(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mzs = v.g(scrubberPosition + j, 0L, this.duration);
        if (this.mzs == scrubberPosition) {
            return false;
        }
        if (!this.mzr) {
            dwe();
        }
        Iterator<c.a> it = this.kXD.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mzs);
        }
        update();
        return true;
    }

    private static int a(DisplayMetrics displayMetrics, int i) {
        return (int) ((i * displayMetrics.density) + 0.5f);
    }

    private static boolean a(Drawable drawable, int i) {
        return v.SDK_INT >= 23 && drawable.setLayoutDirection(i);
    }

    public static int Lv(int i) {
        return (-16777216) | i;
    }

    public static int Lw(int i) {
        return 855638016 | (16777215 & i);
    }

    public static int Lx(int i) {
        return (-872415232) | (16777215 & i);
    }

    public static int Ly(int i) {
        return 855638016 | (16777215 & i);
    }
}
