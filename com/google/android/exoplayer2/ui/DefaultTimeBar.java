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
/* loaded from: classes6.dex */
public class DefaultTimeBar extends View implements c {
    private long duration;
    private long fOb;
    private final int gTe;
    private final CopyOnWriteArraySet<c.a> lbQ;
    private final Rect mDA;
    private final Paint mDB;
    private final Paint mDC;
    private final Paint mDD;
    private final Paint mDE;
    private final Paint mDF;
    private final Paint mDG;
    private final Drawable mDH;
    private final int mDI;
    private final int mDJ;
    private final int mDK;
    private final int mDL;
    private final int mDM;
    private final int mDN;
    private final int mDO;
    private final StringBuilder mDP;
    private final Formatter mDQ;
    private final Runnable mDR;
    private int mDS;
    private long mDT;
    private int mDU;
    private int[] mDV;
    private Point mDW;
    private boolean mDX;
    private long mDY;
    private long mDZ;
    private final Rect mDv;
    private final Rect mDw;
    private final Rect mDz;
    private int mEa;
    private long[] mEb;
    private boolean[] mEc;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDv = new Rect();
        this.mDw = new Rect();
        this.mDz = new Rect();
        this.mDA = new Rect();
        this.mDB = new Paint();
        this.mDC = new Paint();
        this.mDD = new Paint();
        this.mDE = new Paint();
        this.mDF = new Paint();
        this.mDG = new Paint();
        this.mDG.setAntiAlias(true);
        this.lbQ = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDO = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mDH = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mDH != null) {
                    a(this.mDH, getLayoutDirection());
                    a2 = Math.max(this.mDH.getMinimumHeight(), a2);
                }
                this.gTe = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mDI = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mDJ = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mDK = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mDL = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mDM = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, LJ(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, LL(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, LK(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, LM(i5));
                this.mDB.setColor(i);
                this.mDG.setColor(i2);
                this.mDC.setColor(i3);
                this.mDD.setColor(i4);
                this.mDE.setColor(i5);
                this.mDF.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gTe = a;
            this.mDI = a2;
            this.mDJ = a3;
            this.mDK = a4;
            this.mDL = a5;
            this.mDM = a6;
            this.mDB.setColor(-1);
            this.mDG.setColor(LJ(-1));
            this.mDC.setColor(LL(-1));
            this.mDD.setColor(LK(-1));
            this.mDE.setColor(-1291845888);
            this.mDH = null;
        }
        this.mDP = new StringBuilder();
        this.mDQ = new Formatter(this.mDP, Locale.getDefault());
        this.mDR = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vS(false);
            }
        };
        if (this.mDH != null) {
            this.mDN = (this.mDH.getMinimumWidth() + 1) / 2;
        } else {
            this.mDN = (Math.max(this.mDL, Math.max(this.mDK, this.mDM)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mDT = -9223372036854775807L;
        this.mDS = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dyC();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.lbQ.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mDS = -1;
        this.mDT = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mDS = i;
        this.mDT = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fOb = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mDZ = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mDX && j == -9223372036854775807L) {
            vS(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mEa = i;
        this.mEb = jArr;
        this.mEc = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mDX && !z) {
            vS(true);
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
        Point aa = aa(motionEvent);
        int i = aa.x;
        int i2 = aa.y;
        switch (motionEvent.getAction()) {
            case 0:
                if (E(i, i2)) {
                    dyD();
                    bC(i);
                    this.mDY = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mDX) {
                    vS(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mDX) {
                    if (i2 < this.mDO) {
                        bC(((i - this.mDU) / 3) + this.mDU);
                    } else {
                        this.mDU = i;
                        bC(i);
                    }
                    this.mDY = getScrubberPosition();
                    Iterator<c.a> it = this.lbQ.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mDY);
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
                    if (gD(positionIncrement)) {
                        removeCallbacks(this.mDR);
                        postDelayed(this.mDR, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gD(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mDX) {
                        removeCallbacks(this.mDR);
                        this.mDR.run();
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
        dyE();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mDH != null) {
            this.mDH.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mDI;
        } else if (mode != 1073741824) {
            size = Math.min(this.mDI, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dyE();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mDI) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mDI - this.gTe) / 2) + i5;
        this.mDv.set(paddingLeft, i5, paddingRight, this.mDI + i5);
        this.mDw.set(this.mDv.left + this.mDN, i6, this.mDv.right - this.mDN, this.gTe + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mDH != null && a(this.mDH, i)) {
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
            if (gD(-getPositionIncrement())) {
                vS(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (gD(getPositionIncrement())) {
                vS(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    private void dyC() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dyD() {
        this.mDX = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.lbQ.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(boolean z) {
        this.mDX = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.lbQ.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.mDz.set(this.mDw);
        this.mDA.set(this.mDw);
        long j = this.mDX ? this.mDY : this.fOb;
        if (this.duration > 0) {
            this.mDz.right = Math.min(((int) ((this.mDw.width() * this.mDZ) / this.duration)) + this.mDw.left, this.mDw.right);
            this.mDA.right = Math.min(((int) ((j * this.mDw.width()) / this.duration)) + this.mDw.left, this.mDw.right);
        } else {
            this.mDz.right = this.mDw.left;
            this.mDA.right = this.mDw.left;
        }
        invalidate(this.mDv);
    }

    private void bC(float f) {
        this.mDA.right = v.am((int) f, this.mDw.left, this.mDw.right);
    }

    private Point aa(MotionEvent motionEvent) {
        if (this.mDV == null) {
            this.mDV = new int[2];
            this.mDW = new Point();
        }
        getLocationOnScreen(this.mDV);
        this.mDW.set(((int) motionEvent.getRawX()) - this.mDV[0], ((int) motionEvent.getRawY()) - this.mDV[1]);
        return this.mDW;
    }

    private long getScrubberPosition() {
        if (this.mDw.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.mDA.width() * this.duration) / this.mDw.width();
    }

    private boolean E(float f, float f2) {
        return this.mDv.contains((int) f, (int) f2);
    }

    private void ac(Canvas canvas) {
        int min;
        int height = this.mDw.height();
        int centerY = this.mDw.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.mDw.left, centerY, this.mDw.right, i, this.mDD);
            return;
        }
        int i2 = this.mDz.left;
        int i3 = this.mDz.right;
        int max = Math.max(Math.max(this.mDw.left, i3), this.mDA.right);
        if (max < this.mDw.right) {
            canvas.drawRect(max, centerY, this.mDw.right, i, this.mDD);
        }
        int max2 = Math.max(i2, this.mDA.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.mDC);
        }
        if (this.mDA.width() > 0) {
            canvas.drawRect(this.mDA.left, centerY, this.mDA.right, i, this.mDB);
        }
        int i4 = this.mDJ / 2;
        for (int i5 = 0; i5 < this.mEa; i5++) {
            canvas.drawRect(Math.min(this.mDw.width() - this.mDJ, Math.max(0, ((int) ((v.h(this.mEb[i5], 0L, this.duration) * this.mDw.width()) / this.duration)) - i4)) + this.mDw.left, centerY, min + this.mDJ, i, this.mEc[i5] ? this.mDF : this.mDE);
        }
    }

    private void ad(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int am = v.am(this.mDA.right, this.mDA.left, this.mDw.right);
            int centerY = this.mDA.centerY();
            if (this.mDH == null) {
                if (this.mDX || isFocused()) {
                    i = this.mDM;
                } else {
                    i = isEnabled() ? this.mDK : this.mDL;
                }
                canvas.drawCircle(am, centerY, i / 2, this.mDG);
                return;
            }
            int intrinsicWidth = this.mDH.getIntrinsicWidth();
            int intrinsicHeight = this.mDH.getIntrinsicHeight();
            this.mDH.setBounds(am - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + am, (intrinsicHeight / 2) + centerY);
            this.mDH.draw(canvas);
        }
    }

    private void dyE() {
        if (this.mDH != null && this.mDH.isStateful() && this.mDH.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mDP, this.mDQ, this.fOb);
    }

    private long getPositionIncrement() {
        if (this.mDT == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mDS;
        }
        return this.mDT;
    }

    private boolean gD(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mDY = v.h(scrubberPosition + j, 0L, this.duration);
        if (this.mDY == scrubberPosition) {
            return false;
        }
        if (!this.mDX) {
            dyD();
        }
        Iterator<c.a> it = this.lbQ.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mDY);
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

    public static int LJ(int i) {
        return (-16777216) | i;
    }

    public static int LK(int i) {
        return 855638016 | (16777215 & i);
    }

    public static int LL(int i) {
        return (-872415232) | (16777215 & i);
    }

    public static int LM(int i) {
        return 855638016 | (16777215 & i);
    }
}
