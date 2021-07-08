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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.g0.f;
import d.f.b.a.g0.h;
import d.f.b.a.i0.v;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes5.dex */
public class DefaultTimeBar extends View implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CopyOnWriteArraySet<h.a> A;
    public int B;
    public long C;
    public int D;
    public int[] E;
    public Point F;
    public boolean G;
    public long H;
    public long I;
    public long J;
    public long K;
    public int L;
    public long[] M;
    public boolean[] N;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f32889e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f32890f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f32891g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f32892h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f32893i;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final Paint m;
    public final Paint n;
    public final Drawable o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final StringBuilder x;
    public final Formatter y;
    public final Runnable z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultTimeBar f32894e;

        public a(DefaultTimeBar defaultTimeBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultTimeBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32894e = defaultTimeBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32894e.q(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32889e = new Rect();
        this.f32890f = new Rect();
        this.f32891g = new Rect();
        this.f32892h = new Rect();
        this.f32893i = new Paint();
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new Paint();
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.A = new CopyOnWriteArraySet<>();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.w = c(displayMetrics, -50);
        int c2 = c(displayMetrics, 4);
        int c3 = c(displayMetrics, 26);
        int c4 = c(displayMetrics, 4);
        int c5 = c(displayMetrics, 12);
        int c6 = c(displayMetrics, 0);
        int c7 = c(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, f.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(f.DefaultTimeBar_scrubber_drawable);
                this.o = drawable;
                if (drawable != null) {
                    o(drawable, getLayoutDirection());
                    c3 = Math.max(this.o.getMinimumHeight(), c3);
                }
                this.p = obtainStyledAttributes.getDimensionPixelSize(f.DefaultTimeBar_bar_height, c2);
                this.q = obtainStyledAttributes.getDimensionPixelSize(f.DefaultTimeBar_touch_target_height, c3);
                this.r = obtainStyledAttributes.getDimensionPixelSize(f.DefaultTimeBar_ad_marker_width, c4);
                this.s = obtainStyledAttributes.getDimensionPixelSize(f.DefaultTimeBar_scrubber_enabled_size, c5);
                this.t = obtainStyledAttributes.getDimensionPixelSize(f.DefaultTimeBar_scrubber_disabled_size, c6);
                this.u = obtainStyledAttributes.getDimensionPixelSize(f.DefaultTimeBar_scrubber_dragged_size, c7);
                int i4 = obtainStyledAttributes.getInt(f.DefaultTimeBar_played_color, -1);
                int i5 = obtainStyledAttributes.getInt(f.DefaultTimeBar_scrubber_color, h(i4));
                int i6 = obtainStyledAttributes.getInt(f.DefaultTimeBar_buffered_color, f(i4));
                int i7 = obtainStyledAttributes.getInt(f.DefaultTimeBar_unplayed_color, i(i4));
                int i8 = obtainStyledAttributes.getInt(f.DefaultTimeBar_ad_marker_color, -1291845888);
                int i9 = obtainStyledAttributes.getInt(f.DefaultTimeBar_played_ad_marker_color, g(i8));
                this.f32893i.setColor(i4);
                this.n.setColor(i5);
                this.j.setColor(i6);
                this.k.setColor(i7);
                this.l.setColor(i8);
                this.m.setColor(i9);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.p = c2;
            this.q = c3;
            this.r = c4;
            this.s = c5;
            this.t = c6;
            this.u = c7;
            this.f32893i.setColor(-1);
            this.n.setColor(h(-1));
            this.j.setColor(f(-1));
            this.k.setColor(i(-1));
            this.l.setColor(-1291845888);
            this.o = null;
        }
        this.x = new StringBuilder();
        this.y = new Formatter(this.x, Locale.getDefault());
        this.z = new a(this);
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            this.v = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.v = (Math.max(this.t, Math.max(this.s, this.u)) + 1) / 2;
        }
        this.I = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.B = 20;
        setFocusable(true);
        if (v.f70515a >= 16) {
            k();
        }
    }

    public static int c(DisplayMetrics displayMetrics, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, displayMetrics, i2)) == null) ? (int) ((i2 * displayMetrics.density) + 0.5f) : invokeLI.intValue;
    }

    public static int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? (i2 & 16777215) | (-872415232) : invokeI.intValue;
    }

    public static int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? (i2 & 16777215) | 855638016 : invokeI.intValue;
    }

    private long getPositionIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            long j = this.C;
            if (j == -9223372036854775807L) {
                long j2 = this.I;
                if (j2 == -9223372036854775807L) {
                    return 0L;
                }
                return j2 / this.B;
            }
            return j;
        }
        return invokeV.longValue;
    }

    private String getProgressText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? v.u(this.x, this.y, this.J) : (String) invokeV.objValue;
    }

    private long getScrubberPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.f32890f.width() <= 0 || this.I == -9223372036854775807L) {
                return 0L;
            }
            return (this.f32892h.width() * this.I) / this.f32890f.width();
        }
        return invokeV.longValue;
    }

    public static int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 | (-16777216) : invokeI.intValue;
    }

    public static int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? (i2 & 16777215) | 855638016 : invokeI.intValue;
    }

    public static boolean o(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, drawable, i2)) == null) ? v.f70515a >= 23 && drawable.setLayoutDirection(i2) : invokeLI.booleanValue;
    }

    @Override // d.f.b.a.g0.h
    public void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.A.add(aVar);
        }
    }

    public final void d(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.I <= 0) {
            return;
        }
        Rect rect = this.f32892h;
        int k = v.k(rect.right, rect.left, this.f32890f.right);
        int centerY = this.f32892h.centerY();
        Drawable drawable = this.o;
        if (drawable == null) {
            if (!this.G && !isFocused()) {
                i2 = isEnabled() ? this.s : this.t;
            } else {
                i2 = this.u;
            }
            canvas.drawCircle(k, centerY, i2 / 2, this.n);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
        int intrinsicHeight = this.o.getIntrinsicHeight() / 2;
        this.o.setBounds(k - intrinsicWidth, centerY - intrinsicHeight, k + intrinsicWidth, centerY + intrinsicHeight);
        this.o.draw(canvas);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.drawableStateChanged();
            s();
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            int height = this.f32890f.height();
            int centerY = this.f32890f.centerY() - (height / 2);
            int i2 = height + centerY;
            if (this.I <= 0) {
                Rect rect = this.f32890f;
                canvas.drawRect(rect.left, centerY, rect.right, i2, this.k);
                return;
            }
            Rect rect2 = this.f32891g;
            int i3 = rect2.left;
            int i4 = rect2.right;
            int max = Math.max(Math.max(this.f32890f.left, i4), this.f32892h.right);
            int i5 = this.f32890f.right;
            if (max < i5) {
                canvas.drawRect(max, centerY, i5, i2, this.k);
            }
            int max2 = Math.max(i3, this.f32892h.right);
            if (i4 > max2) {
                canvas.drawRect(max2, centerY, i4, i2, this.j);
            }
            if (this.f32892h.width() > 0) {
                Rect rect3 = this.f32892h;
                canvas.drawRect(rect3.left, centerY, rect3.right, i2, this.f32893i);
            }
            int i6 = this.r / 2;
            for (int i7 = 0; i7 < this.L; i7++) {
                long l = v.l(this.M[i7], 0L, this.I);
                Rect rect4 = this.f32890f;
                int min = rect4.left + Math.min(rect4.width() - this.r, Math.max(0, ((int) ((this.f32890f.width() * l) / this.I)) - i6));
                canvas.drawRect(min, centerY, min + this.r, i2, this.N[i7] ? this.m : this.l);
            }
        }
    }

    public final boolean j(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f32889e.contains((int) f2, (int) f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.o;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    @TargetApi(16)
    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public final void l(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            Rect rect = this.f32892h;
            Rect rect2 = this.f32890f;
            rect.right = v.k((int) f2, rect2.left, rect2.right);
        }
    }

    public final Point m(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.E == null) {
                this.E = new int[2];
                this.F = new Point();
            }
            getLocationOnScreen(this.E);
            this.F.set(((int) motionEvent.getRawX()) - this.E[0], ((int) motionEvent.getRawY()) - this.E[1]);
            return this.F;
        }
        return (Point) invokeL.objValue;
    }

    public final boolean n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (this.I <= 0) {
                return false;
            }
            long scrubberPosition = getScrubberPosition();
            long l = v.l(scrubberPosition + j, 0L, this.I);
            this.H = l;
            if (l == scrubberPosition) {
                return false;
            }
            if (!this.G) {
                p();
            }
            Iterator<h.a> it = this.A.iterator();
            while (it.hasNext()) {
                it.next().g(this, this.H);
            }
            r();
            return true;
        }
        return invokeJ.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            canvas.save();
            e(canvas);
            d(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, accessibilityEvent) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048588, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(DefaultTimeBar.class.getCanonicalName());
            accessibilityNodeInfo.setContentDescription(getProgressText());
            if (this.I <= 0) {
                return;
            }
            int i2 = v.f70515a;
            if (i2 >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (i2 >= 16) {
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
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, keyEvent)) == null) {
            if (isEnabled()) {
                long positionIncrement = getPositionIncrement();
                if (i2 != 66) {
                    switch (i2) {
                        case 21:
                            positionIncrement = -positionIncrement;
                            if (n(positionIncrement)) {
                                removeCallbacks(this.z);
                                postDelayed(this.z, 1000L);
                                return true;
                            }
                            break;
                        case 22:
                            if (n(positionIncrement)) {
                            }
                            break;
                    }
                }
                if (this.G) {
                    removeCallbacks(this.z);
                    this.z.run();
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = ((i5 - i3) - this.q) / 2;
            int paddingLeft = getPaddingLeft();
            int paddingRight = (i4 - i2) - getPaddingRight();
            int i7 = this.q;
            int i8 = ((i7 - this.p) / 2) + i6;
            this.f32889e.set(paddingLeft, i6, paddingRight, i7 + i6);
            Rect rect = this.f32890f;
            Rect rect2 = this.f32889e;
            int i9 = rect2.left;
            int i10 = this.v;
            rect.set(i9 + i10, i8, rect2.right - i10, this.p + i8);
            r();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode == 0) {
                size = this.q;
            } else if (mode != 1073741824) {
                size = Math.min(this.q, size);
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
            s();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && (drawable = this.o) != null && o(drawable, i2)) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (isEnabled() && this.I > 0) {
                Point m = m(motionEvent);
                int i2 = m.x;
                int i3 = m.y;
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.G) {
                                if (i3 < this.w) {
                                    int i4 = this.D;
                                    l(i4 + ((i2 - i4) / 3));
                                } else {
                                    this.D = i2;
                                    l(i2);
                                }
                                this.H = getScrubberPosition();
                                Iterator<h.a> it = this.A.iterator();
                                while (it.hasNext()) {
                                    it.next().g(this, this.H);
                                }
                                r();
                                invalidate();
                                return true;
                            }
                        }
                    }
                    if (this.G) {
                        q(motionEvent.getAction() == 3);
                        return true;
                    }
                } else {
                    float f2 = i2;
                    if (j(f2, i3)) {
                        p();
                        l(f2);
                        this.H = getScrubberPosition();
                        r();
                        invalidate();
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.G = true;
            setPressed(true);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            Iterator<h.a> it = this.A.iterator();
            while (it.hasNext()) {
                it.next().n(this, getScrubberPosition());
            }
        }
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, bundle)) == null) {
            if (super.performAccessibilityAction(i2, bundle)) {
                return true;
            }
            if (this.I <= 0) {
                return false;
            }
            if (i2 == 8192) {
                if (n(-getPositionIncrement())) {
                    q(false);
                }
            } else if (i2 != 4096) {
                return false;
            } else {
                if (n(getPositionIncrement())) {
                    q(false);
                }
            }
            sendAccessibilityEvent(4);
            return true;
        }
        return invokeIL.booleanValue;
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.G = false;
            setPressed(false);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            invalidate();
            Iterator<h.a> it = this.A.iterator();
            while (it.hasNext()) {
                it.next().f(this, getScrubberPosition(), z);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f32891g.set(this.f32890f);
            this.f32892h.set(this.f32890f);
            long j = this.G ? this.H : this.J;
            if (this.I > 0) {
                int width = (int) ((this.f32890f.width() * this.K) / this.I);
                Rect rect = this.f32891g;
                Rect rect2 = this.f32890f;
                rect.right = Math.min(rect2.left + width, rect2.right);
                int width2 = (int) ((this.f32890f.width() * j) / this.I);
                Rect rect3 = this.f32892h;
                Rect rect4 = this.f32890f;
                rect3.right = Math.min(rect4.left + width2, rect4.right);
            } else {
                Rect rect5 = this.f32891g;
                int i2 = this.f32890f.left;
                rect5.right = i2;
                this.f32892h.right = i2;
            }
            invalidate(this.f32889e);
        }
    }

    public final void s() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (drawable = this.o) != null && drawable.isStateful() && this.o.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // d.f.b.a.g0.h
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, jArr, zArr, i2) == null) {
            d.f.b.a.i0.a.a(i2 == 0 || !(jArr == null || zArr == null));
            this.L = i2;
            this.M = jArr;
            this.N = zArr;
            r();
        }
    }

    @Override // d.f.b.a.g0.h
    public void setBufferedPosition(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.K = j;
            r();
        }
    }

    @Override // d.f.b.a.g0.h
    public void setDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.I = j;
            if (this.G && j == -9223372036854775807L) {
                q(true);
            }
            r();
        }
    }

    @Override // android.view.View, d.f.b.a.g0.h
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            super.setEnabled(z);
            if (!this.G || z) {
                return;
            }
            q(true);
        }
    }

    public void setKeyCountIncrement(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            d.f.b.a.i0.a.a(i2 > 0);
            this.B = i2;
            this.C = -9223372036854775807L;
        }
    }

    public void setKeyTimeIncrement(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            d.f.b.a.i0.a.a(j > 0);
            this.B = -1;
            this.C = j;
        }
    }

    @Override // d.f.b.a.g0.h
    public void setPosition(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.J = j;
            setContentDescription(getProgressText());
            r();
        }
    }
}
