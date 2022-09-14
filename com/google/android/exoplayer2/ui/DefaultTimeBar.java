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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes7.dex */
public class DefaultTimeBar extends View implements TimeBar {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_INCREMENT_COUNT = 20;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int FINE_SCRUB_RATIO = 3;
    public static final int FINE_SCRUB_Y_THRESHOLD_DP = -50;
    public static final long STOP_SCRUBBING_TIMEOUT_MS = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public int adGroupCount;
    public long[] adGroupTimesMs;
    public final Paint adMarkerPaint;
    public final int adMarkerWidth;
    public final int barHeight;
    public final Rect bufferedBar;
    public final Paint bufferedPaint;
    public long bufferedPosition;
    public long duration;
    public final int fineScrubYThreshold;
    public final StringBuilder formatBuilder;
    public final Formatter formatter;
    public int keyCountIncrement;
    public long keyTimeIncrement;
    public int lastCoarseScrubXPosition;
    public final CopyOnWriteArraySet<TimeBar.OnScrubListener> listeners;
    public int[] locationOnScreen;
    public boolean[] playedAdGroups;
    public final Paint playedAdMarkerPaint;
    public final Paint playedPaint;
    public long position;
    public final Rect progressBar;
    public long scrubPosition;
    public final Rect scrubberBar;
    public final int scrubberDisabledSize;
    public final int scrubberDraggedSize;
    public final Drawable scrubberDrawable;
    public final int scrubberEnabledSize;
    public final int scrubberPadding;
    public final Paint scrubberPaint;
    public boolean scrubbing;
    public final Rect seekBounds;
    public final Runnable stopScrubbingRunnable;
    public Point touchPosition;
    public final int touchTargetHeight;
    public final Paint unplayedPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.seekBounds = new Rect();
        this.progressBar = new Rect();
        this.bufferedBar = new Rect();
        this.scrubberBar = new Rect();
        this.playedPaint = new Paint();
        this.bufferedPaint = new Paint();
        this.unplayedPaint = new Paint();
        this.adMarkerPaint = new Paint();
        this.playedAdMarkerPaint = new Paint();
        Paint paint = new Paint();
        this.scrubberPaint = paint;
        paint.setAntiAlias(true);
        this.listeners = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.fineScrubYThreshold = dpToPx(displayMetrics, -50);
        int dpToPx = dpToPx(displayMetrics, 4);
        int dpToPx2 = dpToPx(displayMetrics, 26);
        int dpToPx3 = dpToPx(displayMetrics, 4);
        int dpToPx4 = dpToPx(displayMetrics, 12);
        int dpToPx5 = dpToPx(displayMetrics, 0);
        int dpToPx6 = dpToPx(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(9);
                this.scrubberDrawable = drawable;
                if (drawable != null) {
                    setDrawableLayoutDirection(drawable, getLayoutDirection());
                    dpToPx2 = Math.max(this.scrubberDrawable.getMinimumHeight(), dpToPx2);
                }
                this.barHeight = obtainStyledAttributes.getDimensionPixelSize(2, dpToPx);
                this.touchTargetHeight = obtainStyledAttributes.getDimensionPixelSize(11, dpToPx2);
                this.adMarkerWidth = obtainStyledAttributes.getDimensionPixelSize(1, dpToPx3);
                this.scrubberEnabledSize = obtainStyledAttributes.getDimensionPixelSize(10, dpToPx4);
                this.scrubberDisabledSize = obtainStyledAttributes.getDimensionPixelSize(7, dpToPx5);
                this.scrubberDraggedSize = obtainStyledAttributes.getDimensionPixelSize(8, dpToPx6);
                int i3 = obtainStyledAttributes.getInt(5, -1);
                int i4 = obtainStyledAttributes.getInt(6, getDefaultScrubberColor(i3));
                int i5 = obtainStyledAttributes.getInt(3, getDefaultBufferedColor(i3));
                int i6 = obtainStyledAttributes.getInt(12, getDefaultUnplayedColor(i3));
                int i7 = obtainStyledAttributes.getInt(0, DEFAULT_AD_MARKER_COLOR);
                int i8 = obtainStyledAttributes.getInt(4, getDefaultPlayedAdMarkerColor(i7));
                this.playedPaint.setColor(i3);
                this.scrubberPaint.setColor(i4);
                this.bufferedPaint.setColor(i5);
                this.unplayedPaint.setColor(i6);
                this.adMarkerPaint.setColor(i7);
                this.playedAdMarkerPaint.setColor(i8);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.barHeight = dpToPx;
            this.touchTargetHeight = dpToPx2;
            this.adMarkerWidth = dpToPx3;
            this.scrubberEnabledSize = dpToPx4;
            this.scrubberDisabledSize = dpToPx5;
            this.scrubberDraggedSize = dpToPx6;
            this.playedPaint.setColor(-1);
            this.scrubberPaint.setColor(getDefaultScrubberColor(-1));
            this.bufferedPaint.setColor(getDefaultBufferedColor(-1));
            this.unplayedPaint.setColor(getDefaultUnplayedColor(-1));
            this.adMarkerPaint.setColor(DEFAULT_AD_MARKER_COLOR);
            this.scrubberDrawable = null;
        }
        this.formatBuilder = new StringBuilder();
        this.formatter = new Formatter(this.formatBuilder, Locale.getDefault());
        this.stopScrubbingRunnable = new Runnable(this) { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DefaultTimeBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i9 = newInitContext2.flag;
                    if ((i9 & 1) != 0) {
                        int i10 = i9 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.stopScrubbing(false);
                }
            }
        };
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 != null) {
            this.scrubberPadding = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.scrubberPadding = (Math.max(this.scrubberDisabledSize, Math.max(this.scrubberEnabledSize, this.scrubberDraggedSize)) + 1) / 2;
        }
        this.duration = C.TIME_UNSET;
        this.keyTimeIncrement = C.TIME_UNSET;
        this.keyCountIncrement = 20;
        setFocusable(true);
        if (Util.SDK_INT >= 16) {
            maybeSetImportantForAccessibilityV16();
        }
    }

    public static int dpToPx(DisplayMetrics displayMetrics, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, displayMetrics, i)) == null) ? (int) ((i * displayMetrics.density) + 0.5f) : invokeLI.intValue;
    }

    private void drawPlayhead(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, canvas) == null) || this.duration <= 0) {
            return;
        }
        Rect rect = this.scrubberBar;
        int constrainValue = Util.constrainValue(rect.right, rect.left, this.progressBar.right);
        int centerY = this.scrubberBar.centerY();
        Drawable drawable = this.scrubberDrawable;
        if (drawable == null) {
            if (!this.scrubbing && !isFocused()) {
                i = isEnabled() ? this.scrubberEnabledSize : this.scrubberDisabledSize;
            } else {
                i = this.scrubberDraggedSize;
            }
            canvas.drawCircle(constrainValue, centerY, i / 2, this.scrubberPaint);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
        int intrinsicHeight = this.scrubberDrawable.getIntrinsicHeight() / 2;
        this.scrubberDrawable.setBounds(constrainValue - intrinsicWidth, centerY - intrinsicHeight, constrainValue + intrinsicWidth, centerY + intrinsicHeight);
        this.scrubberDrawable.draw(canvas);
    }

    private void drawTimeBar(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) {
            int height = this.progressBar.height();
            int centerY = this.progressBar.centerY() - (height / 2);
            int i = height + centerY;
            if (this.duration <= 0) {
                Rect rect = this.progressBar;
                canvas.drawRect(rect.left, centerY, rect.right, i, this.unplayedPaint);
                return;
            }
            Rect rect2 = this.bufferedBar;
            int i2 = rect2.left;
            int i3 = rect2.right;
            int max = Math.max(Math.max(this.progressBar.left, i3), this.scrubberBar.right);
            int i4 = this.progressBar.right;
            if (max < i4) {
                canvas.drawRect(max, centerY, i4, i, this.unplayedPaint);
            }
            int max2 = Math.max(i2, this.scrubberBar.right);
            if (i3 > max2) {
                canvas.drawRect(max2, centerY, i3, i, this.bufferedPaint);
            }
            if (this.scrubberBar.width() > 0) {
                Rect rect3 = this.scrubberBar;
                canvas.drawRect(rect3.left, centerY, rect3.right, i, this.playedPaint);
            }
            int i5 = this.adMarkerWidth / 2;
            for (int i6 = 0; i6 < this.adGroupCount; i6++) {
                long constrainValue = Util.constrainValue(this.adGroupTimesMs[i6], 0L, this.duration);
                Rect rect4 = this.progressBar;
                int min = rect4.left + Math.min(rect4.width() - this.adMarkerWidth, Math.max(0, ((int) ((this.progressBar.width() * constrainValue) / this.duration)) - i5));
                canvas.drawRect(min, centerY, min + this.adMarkerWidth, i, this.playedAdGroups[i6] ? this.playedAdMarkerPaint : this.adMarkerPaint);
            }
        }
    }

    public static int getDefaultBufferedColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? (i & 16777215) | (-872415232) : invokeI.intValue;
    }

    public static int getDefaultPlayedAdMarkerColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) ? (i & 16777215) | 855638016 : invokeI.intValue;
    }

    public static int getDefaultScrubberColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? i | (-16777216) : invokeI.intValue;
    }

    public static int getDefaultUnplayedColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? (i & 16777215) | 855638016 : invokeI.intValue;
    }

    private long getPositionIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            long j = this.keyTimeIncrement;
            if (j == C.TIME_UNSET) {
                long j2 = this.duration;
                if (j2 == C.TIME_UNSET) {
                    return 0L;
                }
                return j2 / this.keyCountIncrement;
            }
            return j;
        }
        return invokeV.longValue;
    }

    private String getProgressText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? Util.getStringForTime(this.formatBuilder, this.formatter, this.position) : (String) invokeV.objValue;
    }

    private long getScrubberPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.progressBar.width() <= 0 || this.duration == C.TIME_UNSET) {
                return 0L;
            }
            return (this.scrubberBar.width() * this.duration) / this.progressBar.width();
        }
        return invokeV.longValue;
    }

    private boolean isInSeekBar(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.seekBounds.contains((int) f, (int) f2) : invokeCommon.booleanValue;
    }

    @TargetApi(16)
    private void maybeSetImportantForAccessibilityV16() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void positionScrubber(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65550, this, f) == null) {
            Rect rect = this.scrubberBar;
            Rect rect2 = this.progressBar;
            rect.right = Util.constrainValue((int) f, rect2.left, rect2.right);
        }
    }

    private Point resolveRelativeTouchPosition(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, motionEvent)) == null) {
            if (this.locationOnScreen == null) {
                this.locationOnScreen = new int[2];
                this.touchPosition = new Point();
            }
            getLocationOnScreen(this.locationOnScreen);
            this.touchPosition.set(((int) motionEvent.getRawX()) - this.locationOnScreen[0], ((int) motionEvent.getRawY()) - this.locationOnScreen[1]);
            return this.touchPosition;
        }
        return (Point) invokeL.objValue;
    }

    private boolean scrubIncrementally(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, this, j)) == null) {
            if (this.duration <= 0) {
                return false;
            }
            long scrubberPosition = getScrubberPosition();
            long constrainValue = Util.constrainValue(scrubberPosition + j, 0L, this.duration);
            this.scrubPosition = constrainValue;
            if (constrainValue == scrubberPosition) {
                return false;
            }
            if (!this.scrubbing) {
                startScrubbing();
            }
            Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onScrubMove(this, this.scrubPosition);
            }
            update();
            return true;
        }
        return invokeJ.booleanValue;
    }

    public static boolean setDrawableLayoutDirection(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, drawable, i)) == null) ? Util.SDK_INT >= 23 && drawable.setLayoutDirection(i) : invokeLI.booleanValue;
    }

    private void startScrubbing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.scrubbing = true;
            setPressed(true);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onScrubStart(this, getScrubberPosition());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopScrubbing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, this, z) == null) {
            this.scrubbing = false;
            setPressed(false);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            invalidate();
            Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onScrubStop(this, getScrubberPosition(), z);
            }
        }
    }

    private void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.bufferedBar.set(this.progressBar);
            this.scrubberBar.set(this.progressBar);
            long j = this.scrubbing ? this.scrubPosition : this.position;
            if (this.duration > 0) {
                int width = (int) ((this.progressBar.width() * this.bufferedPosition) / this.duration);
                Rect rect = this.bufferedBar;
                Rect rect2 = this.progressBar;
                rect.right = Math.min(rect2.left + width, rect2.right);
                int width2 = (int) ((this.progressBar.width() * j) / this.duration);
                Rect rect3 = this.scrubberBar;
                Rect rect4 = this.progressBar;
                rect3.right = Math.min(rect4.left + width2, rect4.right);
            } else {
                Rect rect5 = this.bufferedBar;
                int i = this.progressBar.left;
                rect5.right = i;
                this.scrubberBar.right = i;
            }
            invalidate(this.seekBounds);
        }
    }

    private void updateDrawableState() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && (drawable = this.scrubberDrawable) != null && drawable.isStateful() && this.scrubberDrawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void addListener(TimeBar.OnScrubListener onScrubListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onScrubListener) == null) {
            this.listeners.add(onScrubListener);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.drawableStateChanged();
            updateDrawableState();
        }
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.scrubberDrawable;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.save();
            drawTimeBar(canvas);
            drawPlayhead(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            if (accessibilityEvent.getEventType() == 4) {
                accessibilityEvent.getText().add(getProgressText());
            }
            accessibilityEvent.setClassName(DefaultTimeBar.class.getName());
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(DefaultTimeBar.class.getCanonicalName());
            accessibilityNodeInfo.setContentDescription(getProgressText());
            if (this.duration <= 0) {
                return;
            }
            int i = Util.SDK_INT;
            if (i >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (i >= 16) {
                accessibilityNodeInfo.addAction(4096);
                accessibilityNodeInfo.addAction(8192);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            if (isEnabled()) {
                long positionIncrement = getPositionIncrement();
                if (i != 66) {
                    switch (i) {
                        case 21:
                            positionIncrement = -positionIncrement;
                            if (scrubIncrementally(positionIncrement)) {
                                removeCallbacks(this.stopScrubbingRunnable);
                                postDelayed(this.stopScrubbingRunnable, 1000L);
                                return true;
                            }
                            break;
                        case 22:
                            if (scrubIncrementally(positionIncrement)) {
                            }
                            break;
                    }
                }
                if (this.scrubbing) {
                    removeCallbacks(this.stopScrubbingRunnable);
                    this.stopScrubbingRunnable.run();
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = ((i4 - i2) - this.touchTargetHeight) / 2;
            int paddingLeft = getPaddingLeft();
            int paddingRight = (i3 - i) - getPaddingRight();
            int i6 = this.touchTargetHeight;
            int i7 = ((i6 - this.barHeight) / 2) + i5;
            this.seekBounds.set(paddingLeft, i5, paddingRight, i6 + i5);
            Rect rect = this.progressBar;
            Rect rect2 = this.seekBounds;
            int i8 = rect2.left;
            int i9 = this.scrubberPadding;
            rect.set(i8 + i9, i7, rect2.right - i9, this.barHeight + i7);
            update();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 0) {
                size = this.touchTargetHeight;
            } else if (mode != 1073741824) {
                size = Math.min(this.touchTargetHeight, size);
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i), size);
            updateDrawableState();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (drawable = this.scrubberDrawable) != null && setDrawableLayoutDirection(drawable, i)) {
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (r3 != 3) goto L39;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (isEnabled() && this.duration > 0) {
                Point resolveRelativeTouchPosition = resolveRelativeTouchPosition(motionEvent);
                int i = resolveRelativeTouchPosition.x;
                int i2 = resolveRelativeTouchPosition.y;
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.scrubbing) {
                                if (i2 < this.fineScrubYThreshold) {
                                    int i3 = this.lastCoarseScrubXPosition;
                                    positionScrubber(i3 + ((i - i3) / 3));
                                } else {
                                    this.lastCoarseScrubXPosition = i;
                                    positionScrubber(i);
                                }
                                this.scrubPosition = getScrubberPosition();
                                Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
                                while (it.hasNext()) {
                                    it.next().onScrubMove(this, this.scrubPosition);
                                }
                                update();
                                invalidate();
                                return true;
                            }
                        }
                    }
                    if (this.scrubbing) {
                        stopScrubbing(motionEvent.getAction() == 3);
                        return true;
                    }
                } else {
                    float f = i;
                    if (isInSeekBar(f, i2)) {
                        startScrubbing();
                        positionScrubber(f);
                        this.scrubPosition = getScrubberPosition();
                        update();
                        invalidate();
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, bundle)) == null) {
            if (super.performAccessibilityAction(i, bundle)) {
                return true;
            }
            if (this.duration <= 0) {
                return false;
            }
            if (i == 8192) {
                if (scrubIncrementally(-getPositionIncrement())) {
                    stopScrubbing(false);
                }
            } else if (i != 4096) {
                return false;
            } else {
                if (scrubIncrementally(getPositionIncrement())) {
                    stopScrubbing(false);
                }
            }
            sendAccessibilityEvent(4);
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void removeListener(TimeBar.OnScrubListener onScrubListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onScrubListener) == null) {
            this.listeners.remove(onScrubListener);
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, jArr, zArr, i) == null) {
            Assertions.checkArgument(i == 0 || !(jArr == null || zArr == null));
            this.adGroupCount = i;
            this.adGroupTimesMs = jArr;
            this.playedAdGroups = zArr;
            update();
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setBufferedPosition(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.bufferedPosition = j;
            update();
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.duration = j;
            if (this.scrubbing && j == C.TIME_UNSET) {
                stopScrubbing(true);
            }
            update();
        }
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.TimeBar
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.setEnabled(z);
            if (!this.scrubbing || z) {
                return;
            }
            stopScrubbing(true);
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyCountIncrement(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            Assertions.checkArgument(i > 0);
            this.keyCountIncrement = i;
            this.keyTimeIncrement = C.TIME_UNSET;
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyTimeIncrement(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            Assertions.checkArgument(j > 0);
            this.keyCountIncrement = -1;
            this.keyTimeIncrement = j;
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setPosition(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.position = j;
            setContentDescription(getProgressText());
            update();
        }
    }
}
