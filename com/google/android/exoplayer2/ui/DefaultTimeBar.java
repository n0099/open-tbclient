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
/* loaded from: classes5.dex */
public class DefaultTimeBar extends View implements c {
    private long duration;
    private long fLD;
    private final int gRc;
    private final CopyOnWriteArraySet<c.a> lbd;
    private final Rect mCH;
    private final Rect mCI;
    private final Rect mCJ;
    private final Rect mCK;
    private final Paint mCL;
    private final Paint mCM;
    private final Paint mCN;
    private final Paint mCO;
    private final Paint mCP;
    private final Paint mCQ;
    private final Drawable mCR;
    private final int mCS;
    private final int mCT;
    private final int mCU;
    private final int mCV;
    private final int mCW;
    private final int mCX;
    private final int mCY;
    private final StringBuilder mCZ;
    private final Formatter mDa;
    private final Runnable mDc;
    private int mDd;
    private long mDe;
    private int mDf;
    private int[] mDg;
    private Point mDh;
    private boolean mDi;
    private long mDj;
    private long mDk;
    private int mDl;
    private long[] mDm;
    private boolean[] mDn;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCH = new Rect();
        this.mCI = new Rect();
        this.mCJ = new Rect();
        this.mCK = new Rect();
        this.mCL = new Paint();
        this.mCM = new Paint();
        this.mCN = new Paint();
        this.mCO = new Paint();
        this.mCP = new Paint();
        this.mCQ = new Paint();
        this.mCQ.setAntiAlias(true);
        this.lbd = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mCY = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mCR = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mCR != null) {
                    a(this.mCR, getLayoutDirection());
                    a2 = Math.max(this.mCR.getMinimumHeight(), a2);
                }
                this.gRc = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mCS = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mCT = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mCU = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mCV = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mCW = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, LE(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, LG(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, LF(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, LH(i5));
                this.mCL.setColor(i);
                this.mCQ.setColor(i2);
                this.mCM.setColor(i3);
                this.mCN.setColor(i4);
                this.mCO.setColor(i5);
                this.mCP.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gRc = a;
            this.mCS = a2;
            this.mCT = a3;
            this.mCU = a4;
            this.mCV = a5;
            this.mCW = a6;
            this.mCL.setColor(-1);
            this.mCQ.setColor(LE(-1));
            this.mCM.setColor(LG(-1));
            this.mCN.setColor(LF(-1));
            this.mCO.setColor(-1291845888);
            this.mCR = null;
        }
        this.mCZ = new StringBuilder();
        this.mDa = new Formatter(this.mCZ, Locale.getDefault());
        this.mDc = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vO(false);
            }
        };
        if (this.mCR != null) {
            this.mCX = (this.mCR.getMinimumWidth() + 1) / 2;
        } else {
            this.mCX = (Math.max(this.mCV, Math.max(this.mCU, this.mCW)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mDe = -9223372036854775807L;
        this.mDd = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dxo();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.lbd.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mDd = -1;
        this.mDe = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mDd = i;
        this.mDe = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fLD = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mDk = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mDi && j == -9223372036854775807L) {
            vO(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mDl = i;
        this.mDm = jArr;
        this.mDn = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mDi && !z) {
            vO(true);
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
                    dxp();
                    bD(i);
                    this.mDj = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mDi) {
                    vO(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mDi) {
                    if (i2 < this.mCY) {
                        bD(((i - this.mDf) / 3) + this.mDf);
                    } else {
                        this.mDf = i;
                        bD(i);
                    }
                    this.mDj = getScrubberPosition();
                    Iterator<c.a> it = this.lbd.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mDj);
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
                    if (gF(positionIncrement)) {
                        removeCallbacks(this.mDc);
                        postDelayed(this.mDc, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gF(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mDi) {
                        removeCallbacks(this.mDc);
                        this.mDc.run();
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
        dxq();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mCR != null) {
            this.mCR.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mCS;
        } else if (mode != 1073741824) {
            size = Math.min(this.mCS, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dxq();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mCS) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mCS - this.gRc) / 2) + i5;
        this.mCH.set(paddingLeft, i5, paddingRight, this.mCS + i5);
        this.mCI.set(this.mCH.left + this.mCX, i6, this.mCH.right - this.mCX, this.gRc + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mCR != null && a(this.mCR, i)) {
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
            if (gF(-getPositionIncrement())) {
                vO(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (gF(getPositionIncrement())) {
                vO(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    private void dxo() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dxp() {
        this.mDi = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.lbd.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(boolean z) {
        this.mDi = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.lbd.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.mCJ.set(this.mCI);
        this.mCK.set(this.mCI);
        long j = this.mDi ? this.mDj : this.fLD;
        if (this.duration > 0) {
            this.mCJ.right = Math.min(((int) ((this.mCI.width() * this.mDk) / this.duration)) + this.mCI.left, this.mCI.right);
            this.mCK.right = Math.min(((int) ((j * this.mCI.width()) / this.duration)) + this.mCI.left, this.mCI.right);
        } else {
            this.mCJ.right = this.mCI.left;
            this.mCK.right = this.mCI.left;
        }
        invalidate(this.mCH);
    }

    private void bD(float f) {
        this.mCK.right = v.al((int) f, this.mCI.left, this.mCI.right);
    }

    private Point aa(MotionEvent motionEvent) {
        if (this.mDg == null) {
            this.mDg = new int[2];
            this.mDh = new Point();
        }
        getLocationOnScreen(this.mDg);
        this.mDh.set(((int) motionEvent.getRawX()) - this.mDg[0], ((int) motionEvent.getRawY()) - this.mDg[1]);
        return this.mDh;
    }

    private long getScrubberPosition() {
        if (this.mCI.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.mCK.width() * this.duration) / this.mCI.width();
    }

    private boolean E(float f, float f2) {
        return this.mCH.contains((int) f, (int) f2);
    }

    private void ac(Canvas canvas) {
        int min;
        int height = this.mCI.height();
        int centerY = this.mCI.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.mCI.left, centerY, this.mCI.right, i, this.mCN);
            return;
        }
        int i2 = this.mCJ.left;
        int i3 = this.mCJ.right;
        int max = Math.max(Math.max(this.mCI.left, i3), this.mCK.right);
        if (max < this.mCI.right) {
            canvas.drawRect(max, centerY, this.mCI.right, i, this.mCN);
        }
        int max2 = Math.max(i2, this.mCK.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.mCM);
        }
        if (this.mCK.width() > 0) {
            canvas.drawRect(this.mCK.left, centerY, this.mCK.right, i, this.mCL);
        }
        int i4 = this.mCT / 2;
        for (int i5 = 0; i5 < this.mDl; i5++) {
            canvas.drawRect(Math.min(this.mCI.width() - this.mCT, Math.max(0, ((int) ((v.g(this.mDm[i5], 0L, this.duration) * this.mCI.width()) / this.duration)) - i4)) + this.mCI.left, centerY, min + this.mCT, i, this.mDn[i5] ? this.mCP : this.mCO);
        }
    }

    private void ad(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int al = v.al(this.mCK.right, this.mCK.left, this.mCI.right);
            int centerY = this.mCK.centerY();
            if (this.mCR == null) {
                if (this.mDi || isFocused()) {
                    i = this.mCW;
                } else {
                    i = isEnabled() ? this.mCU : this.mCV;
                }
                canvas.drawCircle(al, centerY, i / 2, this.mCQ);
                return;
            }
            int intrinsicWidth = this.mCR.getIntrinsicWidth();
            int intrinsicHeight = this.mCR.getIntrinsicHeight();
            this.mCR.setBounds(al - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + al, (intrinsicHeight / 2) + centerY);
            this.mCR.draw(canvas);
        }
    }

    private void dxq() {
        if (this.mCR != null && this.mCR.isStateful() && this.mCR.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mCZ, this.mDa, this.fLD);
    }

    private long getPositionIncrement() {
        if (this.mDe == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mDd;
        }
        return this.mDe;
    }

    private boolean gF(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mDj = v.g(scrubberPosition + j, 0L, this.duration);
        if (this.mDj == scrubberPosition) {
            return false;
        }
        if (!this.mDi) {
            dxp();
        }
        Iterator<c.a> it = this.lbd.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mDj);
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

    public static int LE(int i) {
        return (-16777216) | i;
    }

    public static int LF(int i) {
        return 855638016 | (16777215 & i);
    }

    public static int LG(int i) {
        return (-872415232) | (16777215 & i);
    }

    public static int LH(int i) {
        return 855638016 | (16777215 & i);
    }
}
