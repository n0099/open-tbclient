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
    private long fNZ;
    private final int gTc;
    private final CopyOnWriteArraySet<c.a> lbO;
    private final Paint mDA;
    private final Paint mDB;
    private final Paint mDC;
    private final Paint mDD;
    private final Paint mDE;
    private final Drawable mDF;
    private final int mDG;
    private final int mDH;
    private final int mDI;
    private final int mDJ;
    private final int mDK;
    private final int mDL;
    private final int mDM;
    private final StringBuilder mDN;
    private final Formatter mDO;
    private final Runnable mDP;
    private int mDQ;
    private long mDR;
    private int mDS;
    private int[] mDT;
    private Point mDU;
    private boolean mDV;
    private long mDW;
    private long mDX;
    private int mDY;
    private long[] mDZ;
    private final Rect mDt;
    private final Rect mDu;
    private final Rect mDv;
    private final Rect mDw;
    private final Paint mDz;
    private boolean[] mEa;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDt = new Rect();
        this.mDu = new Rect();
        this.mDv = new Rect();
        this.mDw = new Rect();
        this.mDz = new Paint();
        this.mDA = new Paint();
        this.mDB = new Paint();
        this.mDC = new Paint();
        this.mDD = new Paint();
        this.mDE = new Paint();
        this.mDE.setAntiAlias(true);
        this.lbO = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDM = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mDF = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mDF != null) {
                    a(this.mDF, getLayoutDirection());
                    a2 = Math.max(this.mDF.getMinimumHeight(), a2);
                }
                this.gTc = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mDG = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mDH = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mDI = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mDJ = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mDK = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, LJ(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, LL(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, LK(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, LM(i5));
                this.mDz.setColor(i);
                this.mDE.setColor(i2);
                this.mDA.setColor(i3);
                this.mDB.setColor(i4);
                this.mDC.setColor(i5);
                this.mDD.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gTc = a;
            this.mDG = a2;
            this.mDH = a3;
            this.mDI = a4;
            this.mDJ = a5;
            this.mDK = a6;
            this.mDz.setColor(-1);
            this.mDE.setColor(LJ(-1));
            this.mDA.setColor(LL(-1));
            this.mDB.setColor(LK(-1));
            this.mDC.setColor(-1291845888);
            this.mDF = null;
        }
        this.mDN = new StringBuilder();
        this.mDO = new Formatter(this.mDN, Locale.getDefault());
        this.mDP = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vS(false);
            }
        };
        if (this.mDF != null) {
            this.mDL = (this.mDF.getMinimumWidth() + 1) / 2;
        } else {
            this.mDL = (Math.max(this.mDJ, Math.max(this.mDI, this.mDK)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mDR = -9223372036854775807L;
        this.mDQ = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dyA();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.lbO.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mDQ = -1;
        this.mDR = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mDQ = i;
        this.mDR = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fNZ = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mDX = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mDV && j == -9223372036854775807L) {
            vS(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mDY = i;
        this.mDZ = jArr;
        this.mEa = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mDV && !z) {
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
                    dyB();
                    bC(i);
                    this.mDW = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mDV) {
                    vS(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mDV) {
                    if (i2 < this.mDM) {
                        bC(((i - this.mDS) / 3) + this.mDS);
                    } else {
                        this.mDS = i;
                        bC(i);
                    }
                    this.mDW = getScrubberPosition();
                    Iterator<c.a> it = this.lbO.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mDW);
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
                        removeCallbacks(this.mDP);
                        postDelayed(this.mDP, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gD(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mDV) {
                        removeCallbacks(this.mDP);
                        this.mDP.run();
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
        dyC();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mDF != null) {
            this.mDF.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mDG;
        } else if (mode != 1073741824) {
            size = Math.min(this.mDG, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dyC();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mDG) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mDG - this.gTc) / 2) + i5;
        this.mDt.set(paddingLeft, i5, paddingRight, this.mDG + i5);
        this.mDu.set(this.mDt.left + this.mDL, i6, this.mDt.right - this.mDL, this.gTc + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mDF != null && a(this.mDF, i)) {
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
    private void dyA() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dyB() {
        this.mDV = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.lbO.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(boolean z) {
        this.mDV = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.lbO.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.mDv.set(this.mDu);
        this.mDw.set(this.mDu);
        long j = this.mDV ? this.mDW : this.fNZ;
        if (this.duration > 0) {
            this.mDv.right = Math.min(((int) ((this.mDu.width() * this.mDX) / this.duration)) + this.mDu.left, this.mDu.right);
            this.mDw.right = Math.min(((int) ((j * this.mDu.width()) / this.duration)) + this.mDu.left, this.mDu.right);
        } else {
            this.mDv.right = this.mDu.left;
            this.mDw.right = this.mDu.left;
        }
        invalidate(this.mDt);
    }

    private void bC(float f) {
        this.mDw.right = v.am((int) f, this.mDu.left, this.mDu.right);
    }

    private Point aa(MotionEvent motionEvent) {
        if (this.mDT == null) {
            this.mDT = new int[2];
            this.mDU = new Point();
        }
        getLocationOnScreen(this.mDT);
        this.mDU.set(((int) motionEvent.getRawX()) - this.mDT[0], ((int) motionEvent.getRawY()) - this.mDT[1]);
        return this.mDU;
    }

    private long getScrubberPosition() {
        if (this.mDu.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.mDw.width() * this.duration) / this.mDu.width();
    }

    private boolean E(float f, float f2) {
        return this.mDt.contains((int) f, (int) f2);
    }

    private void ac(Canvas canvas) {
        int min;
        int height = this.mDu.height();
        int centerY = this.mDu.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.mDu.left, centerY, this.mDu.right, i, this.mDB);
            return;
        }
        int i2 = this.mDv.left;
        int i3 = this.mDv.right;
        int max = Math.max(Math.max(this.mDu.left, i3), this.mDw.right);
        if (max < this.mDu.right) {
            canvas.drawRect(max, centerY, this.mDu.right, i, this.mDB);
        }
        int max2 = Math.max(i2, this.mDw.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.mDA);
        }
        if (this.mDw.width() > 0) {
            canvas.drawRect(this.mDw.left, centerY, this.mDw.right, i, this.mDz);
        }
        int i4 = this.mDH / 2;
        for (int i5 = 0; i5 < this.mDY; i5++) {
            canvas.drawRect(Math.min(this.mDu.width() - this.mDH, Math.max(0, ((int) ((v.h(this.mDZ[i5], 0L, this.duration) * this.mDu.width()) / this.duration)) - i4)) + this.mDu.left, centerY, min + this.mDH, i, this.mEa[i5] ? this.mDD : this.mDC);
        }
    }

    private void ad(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int am = v.am(this.mDw.right, this.mDw.left, this.mDu.right);
            int centerY = this.mDw.centerY();
            if (this.mDF == null) {
                if (this.mDV || isFocused()) {
                    i = this.mDK;
                } else {
                    i = isEnabled() ? this.mDI : this.mDJ;
                }
                canvas.drawCircle(am, centerY, i / 2, this.mDE);
                return;
            }
            int intrinsicWidth = this.mDF.getIntrinsicWidth();
            int intrinsicHeight = this.mDF.getIntrinsicHeight();
            this.mDF.setBounds(am - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + am, (intrinsicHeight / 2) + centerY);
            this.mDF.draw(canvas);
        }
    }

    private void dyC() {
        if (this.mDF != null && this.mDF.isStateful() && this.mDF.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mDN, this.mDO, this.fNZ);
    }

    private long getPositionIncrement() {
        if (this.mDR == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mDQ;
        }
        return this.mDR;
    }

    private boolean gD(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mDW = v.h(scrubberPosition + j, 0L, this.duration);
        if (this.mDW == scrubberPosition) {
            return false;
        }
        if (!this.mDV) {
            dyB();
        }
        Iterator<c.a> it = this.lbO.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mDW);
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
