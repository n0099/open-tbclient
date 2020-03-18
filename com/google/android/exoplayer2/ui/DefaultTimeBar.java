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
    private long fOW;
    private final int gUx;
    private final CopyOnWriteArraySet<c.a> ldH;
    private final int mFA;
    private final int mFB;
    private final int mFC;
    private final int mFD;
    private final int mFE;
    private final int mFF;
    private final int mFG;
    private final StringBuilder mFH;
    private final Formatter mFI;
    private final Runnable mFJ;
    private int mFK;
    private long mFL;
    private int mFM;
    private int[] mFN;
    private Point mFO;
    private boolean mFP;
    private long mFQ;
    private long mFR;
    private int mFS;
    private long[] mFT;
    private boolean[] mFU;
    private final Rect mFp;
    private final Rect mFq;
    private final Rect mFr;
    private final Rect mFs;
    private final Paint mFt;
    private final Paint mFu;
    private final Paint mFv;
    private final Paint mFw;
    private final Paint mFx;
    private final Paint mFy;
    private final Drawable mFz;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFp = new Rect();
        this.mFq = new Rect();
        this.mFr = new Rect();
        this.mFs = new Rect();
        this.mFt = new Paint();
        this.mFu = new Paint();
        this.mFv = new Paint();
        this.mFw = new Paint();
        this.mFx = new Paint();
        this.mFy = new Paint();
        this.mFy.setAntiAlias(true);
        this.ldH = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mFG = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mFz = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mFz != null) {
                    a(this.mFz, getLayoutDirection());
                    a2 = Math.max(this.mFz.getMinimumHeight(), a2);
                }
                this.gUx = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mFA = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mFB = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mFC = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mFD = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mFE = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, LP(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, LR(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, LQ(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, LS(i5));
                this.mFt.setColor(i);
                this.mFy.setColor(i2);
                this.mFu.setColor(i3);
                this.mFv.setColor(i4);
                this.mFw.setColor(i5);
                this.mFx.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gUx = a;
            this.mFA = a2;
            this.mFB = a3;
            this.mFC = a4;
            this.mFD = a5;
            this.mFE = a6;
            this.mFt.setColor(-1);
            this.mFy.setColor(LP(-1));
            this.mFu.setColor(LR(-1));
            this.mFv.setColor(LQ(-1));
            this.mFw.setColor(-1291845888);
            this.mFz = null;
        }
        this.mFH = new StringBuilder();
        this.mFI = new Formatter(this.mFH, Locale.getDefault());
        this.mFJ = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vZ(false);
            }
        };
        if (this.mFz != null) {
            this.mFF = (this.mFz.getMinimumWidth() + 1) / 2;
        } else {
            this.mFF = (Math.max(this.mFD, Math.max(this.mFC, this.mFE)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mFL = -9223372036854775807L;
        this.mFK = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dza();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.ldH.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mFK = -1;
        this.mFL = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mFK = i;
        this.mFL = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fOW = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mFR = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mFP && j == -9223372036854775807L) {
            vZ(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mFS = i;
        this.mFT = jArr;
        this.mFU = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mFP && !z) {
            vZ(true);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        ad(canvas);
        ae(canvas);
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
                    dzb();
                    bC(i);
                    this.mFQ = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mFP) {
                    vZ(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mFP) {
                    if (i2 < this.mFG) {
                        bC(((i - this.mFM) / 3) + this.mFM);
                    } else {
                        this.mFM = i;
                        bC(i);
                    }
                    this.mFQ = getScrubberPosition();
                    Iterator<c.a> it = this.ldH.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mFQ);
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
                    if (gE(positionIncrement)) {
                        removeCallbacks(this.mFJ);
                        postDelayed(this.mFJ, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gE(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mFP) {
                        removeCallbacks(this.mFJ);
                        this.mFJ.run();
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
        dzc();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mFz != null) {
            this.mFz.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mFA;
        } else if (mode != 1073741824) {
            size = Math.min(this.mFA, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dzc();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mFA) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mFA - this.gUx) / 2) + i5;
        this.mFp.set(paddingLeft, i5, paddingRight, this.mFA + i5);
        this.mFq.set(this.mFp.left + this.mFF, i6, this.mFp.right - this.mFF, this.gUx + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mFz != null && a(this.mFz, i)) {
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
            if (gE(-getPositionIncrement())) {
                vZ(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (gE(getPositionIncrement())) {
                vZ(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    private void dza() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dzb() {
        this.mFP = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.ldH.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ(boolean z) {
        this.mFP = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.ldH.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.mFr.set(this.mFq);
        this.mFs.set(this.mFq);
        long j = this.mFP ? this.mFQ : this.fOW;
        if (this.duration > 0) {
            this.mFr.right = Math.min(((int) ((this.mFq.width() * this.mFR) / this.duration)) + this.mFq.left, this.mFq.right);
            this.mFs.right = Math.min(((int) ((j * this.mFq.width()) / this.duration)) + this.mFq.left, this.mFq.right);
        } else {
            this.mFr.right = this.mFq.left;
            this.mFs.right = this.mFq.left;
        }
        invalidate(this.mFp);
    }

    private void bC(float f) {
        this.mFs.right = v.am((int) f, this.mFq.left, this.mFq.right);
    }

    private Point aa(MotionEvent motionEvent) {
        if (this.mFN == null) {
            this.mFN = new int[2];
            this.mFO = new Point();
        }
        getLocationOnScreen(this.mFN);
        this.mFO.set(((int) motionEvent.getRawX()) - this.mFN[0], ((int) motionEvent.getRawY()) - this.mFN[1]);
        return this.mFO;
    }

    private long getScrubberPosition() {
        if (this.mFq.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.mFs.width() * this.duration) / this.mFq.width();
    }

    private boolean E(float f, float f2) {
        return this.mFp.contains((int) f, (int) f2);
    }

    private void ad(Canvas canvas) {
        int min;
        int height = this.mFq.height();
        int centerY = this.mFq.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.mFq.left, centerY, this.mFq.right, i, this.mFv);
            return;
        }
        int i2 = this.mFr.left;
        int i3 = this.mFr.right;
        int max = Math.max(Math.max(this.mFq.left, i3), this.mFs.right);
        if (max < this.mFq.right) {
            canvas.drawRect(max, centerY, this.mFq.right, i, this.mFv);
        }
        int max2 = Math.max(i2, this.mFs.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.mFu);
        }
        if (this.mFs.width() > 0) {
            canvas.drawRect(this.mFs.left, centerY, this.mFs.right, i, this.mFt);
        }
        int i4 = this.mFB / 2;
        for (int i5 = 0; i5 < this.mFS; i5++) {
            canvas.drawRect(Math.min(this.mFq.width() - this.mFB, Math.max(0, ((int) ((v.h(this.mFT[i5], 0L, this.duration) * this.mFq.width()) / this.duration)) - i4)) + this.mFq.left, centerY, min + this.mFB, i, this.mFU[i5] ? this.mFx : this.mFw);
        }
    }

    private void ae(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int am = v.am(this.mFs.right, this.mFs.left, this.mFq.right);
            int centerY = this.mFs.centerY();
            if (this.mFz == null) {
                if (this.mFP || isFocused()) {
                    i = this.mFE;
                } else {
                    i = isEnabled() ? this.mFC : this.mFD;
                }
                canvas.drawCircle(am, centerY, i / 2, this.mFy);
                return;
            }
            int intrinsicWidth = this.mFz.getIntrinsicWidth();
            int intrinsicHeight = this.mFz.getIntrinsicHeight();
            this.mFz.setBounds(am - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + am, (intrinsicHeight / 2) + centerY);
            this.mFz.draw(canvas);
        }
    }

    private void dzc() {
        if (this.mFz != null && this.mFz.isStateful() && this.mFz.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mFH, this.mFI, this.fOW);
    }

    private long getPositionIncrement() {
        if (this.mFL == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mFK;
        }
        return this.mFL;
    }

    private boolean gE(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mFQ = v.h(scrubberPosition + j, 0L, this.duration);
        if (this.mFQ == scrubberPosition) {
            return false;
        }
        if (!this.mFP) {
            dzb();
        }
        Iterator<c.a> it = this.ldH.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mFQ);
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

    public static int LP(int i) {
        return (-16777216) | i;
    }

    public static int LQ(int i) {
        return 855638016 | (16777215 & i);
    }

    public static int LR(int i) {
        return (-872415232) | (16777215 & i);
    }

    public static int LS(int i) {
        return 855638016 | (16777215 & i);
    }
}
