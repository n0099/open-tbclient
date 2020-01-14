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
    private final CopyOnWriteArraySet<c.a> lbi;
    private final Rect mCM;
    private final Rect mCN;
    private final Rect mCO;
    private final Rect mCP;
    private final Paint mCQ;
    private final Paint mCR;
    private final Paint mCS;
    private final Paint mCT;
    private final Paint mCU;
    private final Paint mCV;
    private final Drawable mCW;
    private final int mCX;
    private final int mCY;
    private final int mCZ;
    private final int mDa;
    private final int mDc;
    private final int mDd;
    private final int mDe;
    private final StringBuilder mDf;
    private final Formatter mDg;
    private final Runnable mDh;
    private int mDi;
    private long mDj;
    private int mDk;
    private int[] mDl;
    private Point mDm;
    private boolean mDn;
    private long mDo;
    private long mDp;
    private int mDq;
    private long[] mDr;
    private boolean[] mDs;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCM = new Rect();
        this.mCN = new Rect();
        this.mCO = new Rect();
        this.mCP = new Rect();
        this.mCQ = new Paint();
        this.mCR = new Paint();
        this.mCS = new Paint();
        this.mCT = new Paint();
        this.mCU = new Paint();
        this.mCV = new Paint();
        this.mCV.setAntiAlias(true);
        this.lbi = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDe = a(displayMetrics, -50);
        int a = a(displayMetrics, 4);
        int a2 = a(displayMetrics, 26);
        int a3 = a(displayMetrics, 4);
        int a4 = a(displayMetrics, 12);
        int a5 = a(displayMetrics, 0);
        int a6 = a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f.DefaultTimeBar, 0, 0);
            try {
                this.mCW = obtainStyledAttributes.getDrawable(a.f.DefaultTimeBar_scrubber_drawable);
                if (this.mCW != null) {
                    a(this.mCW, getLayoutDirection());
                    a2 = Math.max(this.mCW.getMinimumHeight(), a2);
                }
                this.gRc = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_bar_height, a);
                this.mCX = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_touch_target_height, a2);
                this.mCY = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_ad_marker_width, a3);
                this.mCZ = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_enabled_size, a4);
                this.mDa = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_disabled_size, a5);
                this.mDc = obtainStyledAttributes.getDimensionPixelSize(a.f.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_scrubber_color, LE(i));
                int i3 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_buffered_color, LG(i));
                int i4 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_unplayed_color, LF(i));
                int i5 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(a.f.DefaultTimeBar_played_ad_marker_color, LH(i5));
                this.mCQ.setColor(i);
                this.mCV.setColor(i2);
                this.mCR.setColor(i3);
                this.mCS.setColor(i4);
                this.mCT.setColor(i5);
                this.mCU.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.gRc = a;
            this.mCX = a2;
            this.mCY = a3;
            this.mCZ = a4;
            this.mDa = a5;
            this.mDc = a6;
            this.mCQ.setColor(-1);
            this.mCV.setColor(LE(-1));
            this.mCR.setColor(LG(-1));
            this.mCS.setColor(LF(-1));
            this.mCT.setColor(-1291845888);
            this.mCW = null;
        }
        this.mDf = new StringBuilder();
        this.mDg = new Formatter(this.mDf, Locale.getDefault());
        this.mDh = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultTimeBar.this.vO(false);
            }
        };
        if (this.mCW != null) {
            this.mDd = (this.mCW.getMinimumWidth() + 1) / 2;
        } else {
            this.mDd = (Math.max(this.mDa, Math.max(this.mCZ, this.mDc)) + 1) / 2;
        }
        this.duration = -9223372036854775807L;
        this.mDj = -9223372036854775807L;
        this.mDi = 20;
        setFocusable(true);
        if (v.SDK_INT >= 16) {
            dxq();
        }
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void a(c.a aVar) {
        this.lbi.add(aVar);
    }

    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.a.checkArgument(j > 0);
        this.mDi = -1;
        this.mDj = j;
    }

    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i > 0);
        this.mDi = i;
        this.mDj = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setPosition(long j) {
        this.fLD = j;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setBufferedPosition(long j) {
        this.mDp = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setDuration(long j) {
        this.duration = j;
        if (this.mDn && j == -9223372036854775807L) {
            vO(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.c
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.a.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.mDq = i;
        this.mDr = jArr;
        this.mDs = zArr;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.c
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mDn && !z) {
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
                    dxr();
                    bD(i);
                    this.mDo = getScrubberPosition();
                    update();
                    invalidate();
                    return true;
                }
                break;
            case 1:
            case 3:
                if (this.mDn) {
                    vO(motionEvent.getAction() == 3);
                    return true;
                }
                break;
            case 2:
                if (this.mDn) {
                    if (i2 < this.mDe) {
                        bD(((i - this.mDk) / 3) + this.mDk);
                    } else {
                        this.mDk = i;
                        bD(i);
                    }
                    this.mDo = getScrubberPosition();
                    Iterator<c.a> it = this.lbi.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.mDo);
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
                        removeCallbacks(this.mDh);
                        postDelayed(this.mDh, 1000L);
                        return true;
                    }
                    break;
                case 22:
                    if (gF(positionIncrement)) {
                    }
                    break;
                case 23:
                case 66:
                    if (this.mDn) {
                        removeCallbacks(this.mDh);
                        this.mDh.run();
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
        dxs();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mCW != null) {
            this.mCW.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.mCX;
        } else if (mode != 1073741824) {
            size = Math.min(this.mCX, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        dxs();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.mCX) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = ((this.mCX - this.gRc) / 2) + i5;
        this.mCM.set(paddingLeft, i5, paddingRight, this.mCX + i5);
        this.mCN.set(this.mCM.left + this.mDd, i6, this.mCM.right - this.mDd, this.gRc + i6);
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.mCW != null && a(this.mCW, i)) {
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
    private void dxq() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void dxr() {
        this.mDn = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<c.a> it = this.lbi.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(boolean z) {
        this.mDn = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<c.a> it = this.lbi.iterator();
        while (it.hasNext()) {
            it.next().a(this, getScrubberPosition(), z);
        }
    }

    private void update() {
        this.mCO.set(this.mCN);
        this.mCP.set(this.mCN);
        long j = this.mDn ? this.mDo : this.fLD;
        if (this.duration > 0) {
            this.mCO.right = Math.min(((int) ((this.mCN.width() * this.mDp) / this.duration)) + this.mCN.left, this.mCN.right);
            this.mCP.right = Math.min(((int) ((j * this.mCN.width()) / this.duration)) + this.mCN.left, this.mCN.right);
        } else {
            this.mCO.right = this.mCN.left;
            this.mCP.right = this.mCN.left;
        }
        invalidate(this.mCM);
    }

    private void bD(float f) {
        this.mCP.right = v.al((int) f, this.mCN.left, this.mCN.right);
    }

    private Point aa(MotionEvent motionEvent) {
        if (this.mDl == null) {
            this.mDl = new int[2];
            this.mDm = new Point();
        }
        getLocationOnScreen(this.mDl);
        this.mDm.set(((int) motionEvent.getRawX()) - this.mDl[0], ((int) motionEvent.getRawY()) - this.mDl[1]);
        return this.mDm;
    }

    private long getScrubberPosition() {
        if (this.mCN.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.mCP.width() * this.duration) / this.mCN.width();
    }

    private boolean E(float f, float f2) {
        return this.mCM.contains((int) f, (int) f2);
    }

    private void ac(Canvas canvas) {
        int min;
        int height = this.mCN.height();
        int centerY = this.mCN.centerY() - (height / 2);
        int i = centerY + height;
        if (this.duration <= 0) {
            canvas.drawRect(this.mCN.left, centerY, this.mCN.right, i, this.mCS);
            return;
        }
        int i2 = this.mCO.left;
        int i3 = this.mCO.right;
        int max = Math.max(Math.max(this.mCN.left, i3), this.mCP.right);
        if (max < this.mCN.right) {
            canvas.drawRect(max, centerY, this.mCN.right, i, this.mCS);
        }
        int max2 = Math.max(i2, this.mCP.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.mCR);
        }
        if (this.mCP.width() > 0) {
            canvas.drawRect(this.mCP.left, centerY, this.mCP.right, i, this.mCQ);
        }
        int i4 = this.mCY / 2;
        for (int i5 = 0; i5 < this.mDq; i5++) {
            canvas.drawRect(Math.min(this.mCN.width() - this.mCY, Math.max(0, ((int) ((v.g(this.mDr[i5], 0L, this.duration) * this.mCN.width()) / this.duration)) - i4)) + this.mCN.left, centerY, min + this.mCY, i, this.mDs[i5] ? this.mCU : this.mCT);
        }
    }

    private void ad(Canvas canvas) {
        int i;
        if (this.duration > 0) {
            int al = v.al(this.mCP.right, this.mCP.left, this.mCN.right);
            int centerY = this.mCP.centerY();
            if (this.mCW == null) {
                if (this.mDn || isFocused()) {
                    i = this.mDc;
                } else {
                    i = isEnabled() ? this.mCZ : this.mDa;
                }
                canvas.drawCircle(al, centerY, i / 2, this.mCV);
                return;
            }
            int intrinsicWidth = this.mCW.getIntrinsicWidth();
            int intrinsicHeight = this.mCW.getIntrinsicHeight();
            this.mCW.setBounds(al - (intrinsicWidth / 2), centerY - (intrinsicHeight / 2), (intrinsicWidth / 2) + al, (intrinsicHeight / 2) + centerY);
            this.mCW.draw(canvas);
        }
    }

    private void dxs() {
        if (this.mCW != null && this.mCW.isStateful() && this.mCW.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return v.a(this.mDf, this.mDg, this.fLD);
    }

    private long getPositionIncrement() {
        if (this.mDj == -9223372036854775807L) {
            if (this.duration == -9223372036854775807L) {
                return 0L;
            }
            return this.duration / this.mDi;
        }
        return this.mDj;
    }

    private boolean gF(long j) {
        if (this.duration <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.mDo = v.g(scrubberPosition + j, 0L, this.duration);
        if (this.mDo == scrubberPosition) {
            return false;
        }
        if (!this.mDn) {
            dxr();
        }
        Iterator<c.a> it = this.lbi.iterator();
        while (it.hasNext()) {
            it.next().b(this, this.mDo);
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
