package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes7.dex */
public class CircularRevealHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    public static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean buildingCircularRevealCache;
    public Paint debugPaint;
    public final Delegate delegate;
    public boolean hasCircularRevealCache;
    @Nullable
    public Drawable overlayDrawable;
    @Nullable
    public CircularRevealWidget.RevealInfo revealInfo;
    @NonNull
    public final Paint revealPaint;
    @NonNull
    public final Path revealPath;
    @NonNull
    public final Paint scrimPaint;
    @NonNull

    /* renamed from: view  reason: collision with root package name */
    public final View f1072view;

    /* loaded from: classes7.dex */
    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Strategy {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1753937322, "Lcom/google/android/material/circularreveal/CircularRevealHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1753937322, "Lcom/google/android/material/circularreveal/CircularRevealHelper;");
                return;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            STRATEGY = 2;
        } else if (i >= 18) {
            STRATEGY = 1;
        } else {
            STRATEGY = 0;
        }
    }

    public CircularRevealHelper(Delegate delegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {delegate};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delegate = delegate;
        View view2 = (View) delegate;
        this.f1072view = view2;
        view2.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas canvas, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{canvas, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.debugPaint.setColor(i);
            this.debugPaint.setStrokeWidth(f);
            CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius - (f / 2.0f), this.debugPaint);
        }
    }

    private void drawDebugMode(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, canvas) == null) {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
                canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.scrimPaint);
            }
            if (shouldDrawCircularReveal()) {
                drawDebugCircle(canvas, -16777216, 10.0f);
                drawDebugCircle(canvas, -65536, 5.0f);
            }
            drawOverlayDrawable(canvas);
        }
    }

    private void drawOverlayDrawable(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) && shouldDrawOverlayDrawable()) {
            Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (bounds.width() / 2.0f);
            float height = this.revealInfo.centerY - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo revealInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, revealInfo)) == null) ? MathUtils.distanceToFurthestCorner(revealInfo.centerX, revealInfo.centerY, 0.0f, 0.0f, this.f1072view.getWidth(), this.f1072view.getHeight()) : invokeL.floatValue;
    }

    private void invalidateRevealInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (STRATEGY == 1) {
                this.revealPath.rewind();
                CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
                if (revealInfo != null) {
                    this.revealPath.addCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, Path.Direction.CW);
                }
            }
            this.f1072view.invalidate();
        }
    }

    private boolean shouldDrawCircularReveal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            boolean z = revealInfo == null || revealInfo.isInvalid();
            return STRATEGY == 0 ? !z && this.hasCircularRevealCache : !z;
        }
        return invokeV.booleanValue;
    }

    private boolean shouldDrawOverlayDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true : invokeV.booleanValue;
    }

    private boolean shouldDrawScrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (this.buildingCircularRevealCache || Color.alpha(this.scrimPaint.getColor()) == 0) ? false : true : invokeV.booleanValue;
    }

    public void buildCircularRevealCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.f1072view.buildDrawingCache();
            Bitmap drawingCache = this.f1072view.getDrawingCache();
            if (drawingCache == null && this.f1072view.getWidth() != 0 && this.f1072view.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f1072view.getWidth(), this.f1072view.getHeight(), Bitmap.Config.ARGB_8888);
                this.f1072view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.revealPaint;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.f1072view.destroyDrawingCache();
            this.revealPaint.setShader(null);
            this.f1072view.invalidate();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (shouldDrawCircularReveal()) {
                int i = STRATEGY;
                if (i == 0) {
                    CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
                    canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.revealPaint);
                    if (shouldDrawScrim()) {
                        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
                        canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.scrimPaint);
                    }
                } else if (i == 1) {
                    int save = canvas.save();
                    canvas.clipPath(this.revealPath);
                    this.delegate.actualDraw(canvas);
                    if (shouldDrawScrim()) {
                        canvas.drawRect(0.0f, 0.0f, this.f1072view.getWidth(), this.f1072view.getHeight(), this.scrimPaint);
                    }
                    canvas.restoreToCount(save);
                } else if (i == 2) {
                    this.delegate.actualDraw(canvas);
                    if (shouldDrawScrim()) {
                        canvas.drawRect(0.0f, 0.0f, this.f1072view.getWidth(), this.f1072view.getHeight(), this.scrimPaint);
                    }
                } else {
                    throw new IllegalStateException("Unsupported strategy " + STRATEGY);
                }
            } else {
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.f1072view.getWidth(), this.f1072view.getHeight(), this.scrimPaint);
                }
            }
            drawOverlayDrawable(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.overlayDrawable : (Drawable) invokeV.objValue;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.scrimPaint.getColor() : invokeV.intValue;
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            if (revealInfo == null) {
                return null;
            }
            CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
            if (revealInfo2.isInvalid()) {
                revealInfo2.radius = getDistanceToFurthestCorner(revealInfo2);
            }
            return revealInfo2;
        }
        return (CircularRevealWidget.RevealInfo) invokeV.objValue;
    }

    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.delegate.actualIsOpaque() && !shouldDrawCircularReveal() : invokeV.booleanValue;
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) {
            this.overlayDrawable = drawable;
            this.f1072view.invalidate();
        }
    }

    public void setCircularRevealScrimColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.scrimPaint.setColor(i);
            this.f1072view.invalidate();
        }
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, revealInfo) == null) {
            if (revealInfo == null) {
                this.revealInfo = null;
            } else {
                CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
                if (revealInfo2 == null) {
                    this.revealInfo = new CircularRevealWidget.RevealInfo(revealInfo);
                } else {
                    revealInfo2.set(revealInfo);
                }
                if (MathUtils.geq(revealInfo.radius, getDistanceToFurthestCorner(revealInfo), 1.0E-4f)) {
                    this.revealInfo.radius = Float.MAX_VALUE;
                }
            }
            invalidateRevealInfo();
        }
    }
}
