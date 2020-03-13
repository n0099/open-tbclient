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
    private long fOo;
    private final int gTq;
    private final CopyOnWriteArraySet<c.a> lcc;
    private final Rect mDI;
    private final Rect mDJ;
    private final Rect mDK;
    private final Rect mDL;
    private final Paint mDM;
    private final Paint mDN;
    private final Paint mDO;
    private final Paint mDP;
    private final Paint mDQ;
    private final Paint mDR;
    private final Drawable mDS;
    private final int mDT;
    private final int mDU;
    private final int mDV;
    private final int mDW;
    private final int mDX;
    private final int mDY;
    private final int mDZ;
    private final StringBuilder mEa;
    private final Formatter mEb;
    private final Runnable mEc;
    private int mEd;
    private long mEe;
    private int mEf;
    private int[] mEg;
    private Point mEh;
    private boolean mEi;
    private long mEj;
    private long mEk;
    private int mEl;
    private long[] mEm;
    private boolean[] mEn;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDI = new Rect();
        this.mDJ = new Rect();
        this.mDK = new Rect();
        this.mDL = new Rect();
        this.mDM = new Paint();
        this.mDN = new Paint();
        this.mDO = new Paint();
        this.mDP = new Paint();
        this.mDQ = new Paint();
        this.mDR = new Paint();
        this.mDR.setAntiAlias(true);
        this.lcc = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDZ = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mDS = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mDS != null) {
                    a(this.mDS, getLayoutDirection());
                    a2 = Math.max(this.mDS.getMinimumHeight(), a2);
                }
                this.gTq = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mDT = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mDU = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mDV = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mDW = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mDX = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, LJ(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, LL(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, LK(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, LM(i5));
                this.mDM.setColor(i);
                this.mDR.setColor(i2);
                this.mDN.setColor(i3);
                this.mDO.setColor(i4);
                this.mDP.setColor(i5);
                this.mDQ.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gTq = a;
            this.mDT = a2;
            this.mDU = a3;
            this.mDV = a4;
            this.mDW = a5;
            this.mDX = a6;
            this.mDM.setColor(-1);
            this.mDR.setColor(LJ(-1));
            this.mDN.setColor(LL(-1));
            this.mDO.setColor(LK(-1));
            this.mDP.setColor(-1291845888);
            this.mDS = null;
        }
        this.mEa = new StringBuilder();
        this.mEb = new Formatter(this.mEa, Locale.getDefault());
        this.mEc = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vS(false);
            }
        };
        if (this.mDS != null) {
            this.mDY = (this.mDS.getMinimumWidth() + 1) / 2;
        } else {
            this.mDY = (Math.max(this.mDW, Math.max(this.mDV, this.mDX)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mEe = -9223372036854775807L;
        this.mEd = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dyD();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.lcc.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mEd = -1;
        this.mEe = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mEd = i;
        this.mEe = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fOo = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mEk = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mEi && j == -9223372036854775807L) {
            vS(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mEl = i;
        this.mEm = jArr;
        this.mEn = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mEi && !z) {
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
                    dyE();
                    bC(i);
                    this.mEj = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mEi) {
                    vS(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mEi) {
                    if (i2 < this.mDZ) {
                        bC(((i - this.mEf) / 3) + this.mEf);
                    } else {
                        this.mEf = i;
                        bC(i);
                    }
                    this.mEj = getScrubberPosition();
                    Iterator<c.a> it = this.lcc.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mEj);
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
                        removeCallbacks(this.mEc);
                        postDelayed(this.mEc, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gD(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mEi) {
                        removeCallbacks(this.mEc);
                        this.mEc.run();
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
        dyF();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mDS != null) {
            this.mDS.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mDT;
        } else if (mode != 1073741824) {
            size = Math.min(this.mDT, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dyF();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mDT) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mDT - this.gTq) / 2) + i5;
        this.mDI.set(paddingLeft, i5, paddingRight, this.mDT + i5);
        this.mDJ.set(this.mDI.left + this.mDY, i6, this.mDI.right - this.mDY, this.gTq + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mDS != null && a(this.mDS, i)) {
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
    private void dyD() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dyE() {
        this.mEi = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.lcc.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(boolean z) {
        this.mEi = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.lcc.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.mDK.set(this.mDJ);
        this.mDL.set(this.mDJ);
        long j = this.mEi ? this.mEj : this.fOo;
        if (this.duration > 0) {
            this.mDK.right = Math.min(((int) ((this.mDJ.width() * this.mEk) / this.duration)) + this.mDJ.left, this.mDJ.right);
            this.mDL.right = Math.min(((int) ((j * this.mDJ.width()) / this.duration)) + this.mDJ.left, this.mDJ.right);
        } else {
            this.mDK.right = this.mDJ.left;
            this.mDL.right = this.mDJ.left;
        }
        invalidate(this.mDI);
    }

    private void bC(float f) {
        this.mDL.right = v.am((int) f, this.mDJ.left, this.mDJ.right);
    }

    private Point aa(MotionEvent motionEvent) {
        if (this.mEg == null) {
            this.mEg = new int[2];
            this.mEh = new Point();
        }
        getLocationOnScreen(this.mEg);
        this.mEh.set(((int) motionEvent.getRawX()) - this.mEg[0], ((int) motionEvent.getRawY()) - this.mEg[1]);
        return this.mEh;
    }

    private long getScrubberPosition() {
        if (this.mDJ.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.mDL.width() * this.duration) / this.mDJ.width();
    }

    private boolean E(float f, float f2) {
        return this.mDI.contains((int) f, (int) f2);
    }

    private void ac(Canvas canvas) {
        int min;
        int height = this.mDJ.height();
        int centerY = this.mDJ.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.mDJ.left, centerY, this.mDJ.right, i, this.mDO);
            return;
        }
        int i2 = this.mDK.left;
        int i3 = this.mDK.right;
        int max = Math.max(Math.max(this.mDJ.left, i3), this.mDL.right);
        if (max < this.mDJ.right) {
            canvas.drawRect(max, centerY, this.mDJ.right, i, this.mDO);
        }
        int max2 = Math.max(i2, this.mDL.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.mDN);
        }
        if (this.mDL.width() > 0) {
            canvas.drawRect(this.mDL.left, centerY, this.mDL.right, i, this.mDM);
        }
        int i4 = this.mDU / 2;
        for (int i5 = 0; i5 < this.mEl; i5++) {
            canvas.drawRect(Math.min(this.mDJ.width() - this.mDU, Math.max(0, ((int) ((v.h(this.mEm[i5], 0L, this.duration) * this.mDJ.width()) / this.duration)) - i4)) + this.mDJ.left, centerY, min + this.mDU, i, this.mEn[i5] ? this.mDQ : this.mDP);
        }
    }

    private void ad(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int am = v.am(this.mDL.right, this.mDL.left, this.mDJ.right);
            int centerY = this.mDL.centerY();
            if (this.mDS == null) {
                if (this.mEi || isFocused()) {
                    i = this.mDX;
                } else {
                    i = isEnabled() ? this.mDV : this.mDW;
                }
                canvas.drawCircle(am, centerY, i / 2, this.mDR);
                return;
            }
            int intrinsicWidth = this.mDS.getIntrinsicWidth();
            int intrinsicHeight = this.mDS.getIntrinsicHeight();
            this.mDS.setBounds(am - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + am, (intrinsicHeight / 2) + centerY);
            this.mDS.draw(canvas);
        }
    }

    private void dyF() {
        if (this.mDS != null && this.mDS.isStateful() && this.mDS.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mEa, this.mEb, this.fOo);
    }

    private long getPositionIncrement() {
        if (this.mEe == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mEd;
        }
        return this.mEe;
    }

    private boolean gD(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mEj = v.h(scrubberPosition + j, 0L, this.duration);
        if (this.mEj == scrubberPosition) {
            return false;
        }
        if (!this.mEi) {
            dyE();
        }
        Iterator<c.a> it = this.lcc.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mEj);
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
