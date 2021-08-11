package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.platform.TransitionUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@RequiresApi(21)
/* loaded from: classes9.dex */
public final class MaterialContainerTransform extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS;
    public static final ProgressThresholdsGroup DEFAULT_ENTER_THRESHOLDS_ARC;
    public static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS;
    public static final ProgressThresholdsGroup DEFAULT_RETURN_THRESHOLDS_ARC;
    public static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    public static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    public static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    public static final String TAG;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    public static final String[] TRANSITION_PROPS;
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt
    public int containerColor;
    public boolean drawDebugEnabled;
    @IdRes
    public int drawingViewId;
    public boolean elevationShadowEnabled;
    @ColorInt
    public int endContainerColor;
    public float endElevation;
    @Nullable
    public ShapeAppearanceModel endShapeAppearanceModel;
    @Nullable
    public View endView;
    @IdRes
    public int endViewId;
    public int fadeMode;
    @Nullable
    public ProgressThresholds fadeProgressThresholds;
    public int fitMode;
    public boolean holdAtEndEnabled;
    @Nullable
    public ProgressThresholds scaleMaskProgressThresholds;
    @Nullable
    public ProgressThresholds scaleProgressThresholds;
    @ColorInt
    public int scrimColor;
    @Nullable
    public ProgressThresholds shapeMaskProgressThresholds;
    @ColorInt
    public int startContainerColor;
    public float startElevation;
    @Nullable
    public ShapeAppearanceModel startShapeAppearanceModel;
    @Nullable
    public View startView;
    @IdRes
    public int startViewId;
    public int transitionDirection;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes9.dex */
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes9.dex */
    public @interface FitMode {
    }

    /* loaded from: classes9.dex */
    public static class ProgressThresholds {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float end;
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.start = f2;
            this.end = f3;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.end : invokeV.floatValue;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.start : invokeV.floatValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class ProgressThresholdsGroup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final ProgressThresholds fade;
        @NonNull
        public final ProgressThresholds scale;
        @NonNull
        public final ProgressThresholds scaleMask;
        @NonNull
        public final ProgressThresholds shapeMask;

        public ProgressThresholdsGroup(@NonNull ProgressThresholds progressThresholds, @NonNull ProgressThresholds progressThresholds2, @NonNull ProgressThresholds progressThresholds3, @NonNull ProgressThresholds progressThresholds4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressThresholds, progressThresholds2, progressThresholds3, progressThresholds4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fade = progressThresholds;
            this.scale = progressThresholds2;
            this.scaleMask = progressThresholds3;
            this.shapeMask = progressThresholds4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes9.dex */
    public @interface TransitionDirection {
    }

    /* loaded from: classes9.dex */
    public static final class TransitionDrawable extends Drawable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int COMPAT_SHADOW_COLOR = -7829368;
        public static final int SHADOW_COLOR = 754974720;
        public static final float SHADOW_DX_MULTIPLIER_ADJUSTMENT = 0.3f;
        public static final float SHADOW_DY_MULTIPLIER_ADJUSTMENT = 1.5f;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaterialShapeDrawable compatShadowDrawable;
        public final Paint containerPaint;
        public float currentElevation;
        public float currentElevationDy;
        public final RectF currentEndBounds;
        public final RectF currentEndBoundsMasked;
        public RectF currentMaskBounds;
        public final RectF currentStartBounds;
        public final RectF currentStartBoundsMasked;
        public final Paint debugPaint;
        public final Path debugPath;
        public final float displayHeight;
        public final float displayWidth;
        public final boolean drawDebugEnabled;
        public final boolean elevationShadowEnabled;
        public final RectF endBounds;
        public final Paint endContainerPaint;
        public final float endElevation;
        public final ShapeAppearanceModel endShapeAppearanceModel;
        public final View endView;
        public final boolean entering;
        public final FadeModeEvaluator fadeModeEvaluator;
        public FadeModeResult fadeModeResult;
        public final FitModeEvaluator fitModeEvaluator;
        public FitModeResult fitModeResult;
        public final MaskEvaluator maskEvaluator;
        public final float motionPathLength;
        public final PathMeasure motionPathMeasure;
        public final float[] motionPathPosition;
        public float progress;
        public final ProgressThresholdsGroup progressThresholds;
        public final Paint scrimPaint;
        public final Paint shadowPaint;
        public final RectF startBounds;
        public final Paint startContainerPaint;
        public final float startElevation;
        public final ShapeAppearanceModel startShapeAppearanceModel;
        public final View startView;

        public static float calculateElevationDxMultiplier(RectF rectF, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.AD_TEXT_ID, null, rectF, f2)) == null) ? ((rectF.centerX() / (f2 / 2.0f)) - 1.0f) * 0.3f : invokeLF.floatValue;
        }

        public static float calculateElevationDyMultiplier(RectF rectF, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.BAIDU_LOGO_ID, null, rectF, f2)) == null) ? (rectF.centerY() / f2) * 1.5f : invokeLF.floatValue;
        }

        private void drawDebugCumulativePath(Canvas canvas, RectF rectF, Path path, @ColorInt int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(65543, this, canvas, rectF, path, i2) == null) {
                PointF motionPathPoint = getMotionPathPoint(rectF);
                if (this.progress == 0.0f) {
                    path.reset();
                    path.moveTo(motionPathPoint.x, motionPathPoint.y);
                    return;
                }
                path.lineTo(motionPathPoint.x, motionPathPoint.y);
                this.debugPaint.setColor(i2);
                canvas.drawPath(path, this.debugPaint);
            }
        }

        private void drawDebugRect(Canvas canvas, RectF rectF, @ColorInt int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65544, this, canvas, rectF, i2) == null) {
                this.debugPaint.setColor(i2);
                canvas.drawRect(rectF, this.debugPaint);
            }
        }

        private void drawElevationShadow(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, this, canvas) == null) {
                canvas.save();
                canvas.clipPath(this.maskEvaluator.getPath(), Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    drawElevationShadowWithPaintShadowLayer(canvas);
                } else {
                    drawElevationShadowWithMaterialShapeDrawable(canvas);
                }
                canvas.restore();
            }
        }

        private void drawElevationShadowWithMaterialShapeDrawable(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, this, canvas) == null) {
                MaterialShapeDrawable materialShapeDrawable = this.compatShadowDrawable;
                RectF rectF = this.currentMaskBounds;
                materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.compatShadowDrawable.setElevation(this.currentElevation);
                this.compatShadowDrawable.setShadowVerticalOffset((int) this.currentElevationDy);
                this.compatShadowDrawable.setShapeAppearanceModel(this.maskEvaluator.getCurrentShapeAppearanceModel());
                this.compatShadowDrawable.draw(canvas);
            }
        }

        private void drawElevationShadowWithPaintShadowLayer(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65547, this, canvas) == null) {
                ShapeAppearanceModel currentShapeAppearanceModel = this.maskEvaluator.getCurrentShapeAppearanceModel();
                if (currentShapeAppearanceModel.isRoundRect(this.currentMaskBounds)) {
                    float cornerSize = currentShapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.currentMaskBounds);
                    canvas.drawRoundRect(this.currentMaskBounds, cornerSize, cornerSize, this.shadowPaint);
                    return;
                }
                canvas.drawPath(this.maskEvaluator.getPath(), this.shadowPaint);
            }
        }

        private void drawEndView(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, canvas) == null) {
                maybeDrawContainerColor(canvas, this.endContainerPaint);
                Rect bounds = getBounds();
                RectF rectF = this.currentEndBounds;
                TransitionUtils.transform(canvas, bounds, rectF.left, rectF.top, this.fitModeResult.endScale, this.fadeModeResult.endAlpha, new TransitionUtils.CanvasOperation(this) { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TransitionDrawable this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.google.android.material.transition.platform.TransitionUtils.CanvasOperation
                    public void run(Canvas canvas2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, canvas2) == null) {
                            this.this$0.endView.draw(canvas2);
                        }
                    }
                });
            }
        }

        private void drawStartView(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65549, this, canvas) == null) {
                maybeDrawContainerColor(canvas, this.startContainerPaint);
                Rect bounds = getBounds();
                RectF rectF = this.currentStartBounds;
                TransitionUtils.transform(canvas, bounds, rectF.left, rectF.top, this.fitModeResult.startScale, this.fadeModeResult.startAlpha, new TransitionUtils.CanvasOperation(this) { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TransitionDrawable this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.google.android.material.transition.platform.TransitionUtils.CanvasOperation
                    public void run(Canvas canvas2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, canvas2) == null) {
                            this.this$0.startView.draw(canvas2);
                        }
                    }
                });
            }
        }

        public static PointF getMotionPathPoint(RectF rectF) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, rectF)) == null) ? new PointF(rectF.centerX(), rectF.top) : (PointF) invokeL.objValue;
        }

        private void maybeDrawContainerColor(Canvas canvas, Paint paint) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65551, this, canvas, paint) == null) || paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProgress(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(65552, this, f2) == null) || this.progress == f2) {
                return;
            }
            updateProgress(f2);
        }

        private void updateProgress(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(65553, this, f2) == null) {
                this.progress = f2;
                this.scrimPaint.setAlpha((int) (this.entering ? TransitionUtils.lerp(0.0f, 255.0f, f2) : TransitionUtils.lerp(255.0f, 0.0f, f2)));
                this.motionPathMeasure.getPosTan(this.motionPathLength * f2, this.motionPathPosition, null);
                float[] fArr = this.motionPathPosition;
                float f3 = fArr[0];
                float f4 = fArr[1];
                FitModeResult evaluate = this.fitModeEvaluator.evaluate(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scale.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scale.end))).floatValue(), this.startBounds.width(), this.startBounds.height(), this.endBounds.width(), this.endBounds.height());
                this.fitModeResult = evaluate;
                RectF rectF = this.currentStartBounds;
                float f5 = evaluate.currentStartWidth;
                rectF.set(f3 - (f5 / 2.0f), f4, (f5 / 2.0f) + f3, evaluate.currentStartHeight + f4);
                RectF rectF2 = this.currentEndBounds;
                FitModeResult fitModeResult = this.fitModeResult;
                float f6 = fitModeResult.currentEndWidth;
                rectF2.set(f3 - (f6 / 2.0f), f4, f3 + (f6 / 2.0f), fitModeResult.currentEndHeight + f4);
                this.currentStartBoundsMasked.set(this.currentStartBounds);
                this.currentEndBoundsMasked.set(this.currentEndBounds);
                float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scaleMask.start))).floatValue();
                float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.scaleMask.end))).floatValue();
                boolean shouldMaskStartBounds = this.fitModeEvaluator.shouldMaskStartBounds(this.fitModeResult);
                RectF rectF3 = shouldMaskStartBounds ? this.currentStartBoundsMasked : this.currentEndBoundsMasked;
                float lerp = TransitionUtils.lerp(0.0f, 1.0f, floatValue, floatValue2, f2);
                if (!shouldMaskStartBounds) {
                    lerp = 1.0f - lerp;
                }
                this.fitModeEvaluator.applyMask(rectF3, lerp, this.fitModeResult);
                this.currentMaskBounds = new RectF(Math.min(this.currentStartBoundsMasked.left, this.currentEndBoundsMasked.left), Math.min(this.currentStartBoundsMasked.top, this.currentEndBoundsMasked.top), Math.max(this.currentStartBoundsMasked.right, this.currentEndBoundsMasked.right), Math.max(this.currentStartBoundsMasked.bottom, this.currentEndBoundsMasked.bottom));
                this.maskEvaluator.evaluate(f2, this.startShapeAppearanceModel, this.endShapeAppearanceModel, this.currentStartBounds, this.currentStartBoundsMasked, this.currentEndBoundsMasked, this.progressThresholds.shapeMask);
                this.currentElevation = TransitionUtils.lerp(this.startElevation, this.endElevation, f2);
                float calculateElevationDxMultiplier = calculateElevationDxMultiplier(this.currentMaskBounds, this.displayWidth);
                float calculateElevationDyMultiplier = calculateElevationDyMultiplier(this.currentMaskBounds, this.displayHeight);
                float f7 = this.currentElevation;
                float f8 = (int) (calculateElevationDyMultiplier * f7);
                this.currentElevationDy = f8;
                this.shadowPaint.setShadowLayer(f7, (int) (calculateElevationDxMultiplier * f7), f8, 754974720);
                this.fadeModeResult = this.fadeModeEvaluator.evaluate(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.fade.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.progressThresholds.fade.end))).floatValue());
                if (this.startContainerPaint.getColor() != 0) {
                    this.startContainerPaint.setAlpha(this.fadeModeResult.startAlpha);
                }
                if (this.endContainerPaint.getColor() != 0) {
                    this.endContainerPaint.setAlpha(this.fadeModeResult.endAlpha);
                }
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                if (this.scrimPaint.getAlpha() > 0) {
                    canvas.drawRect(getBounds(), this.scrimPaint);
                }
                int save = this.drawDebugEnabled ? canvas.save() : -1;
                if (this.elevationShadowEnabled && this.currentElevation > 0.0f) {
                    drawElevationShadow(canvas);
                }
                this.maskEvaluator.clip(canvas);
                maybeDrawContainerColor(canvas, this.containerPaint);
                if (this.fadeModeResult.endOnTop) {
                    drawStartView(canvas);
                    drawEndView(canvas);
                } else {
                    drawEndView(canvas);
                    drawStartView(canvas);
                }
                if (this.drawDebugEnabled) {
                    canvas.restoreToCount(save);
                    drawDebugCumulativePath(canvas, this.currentStartBounds, this.debugPath, -65281);
                    drawDebugRect(canvas, this.currentStartBoundsMasked, -256);
                    drawDebugRect(canvas, this.currentStartBounds, -16711936);
                    drawDebugRect(canvas, this.currentEndBoundsMasked, -16711681);
                    drawDebugRect(canvas, this.currentEndBounds, -16776961);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return -3;
            }
            return invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                throw new UnsupportedOperationException("Setting alpha on is not supported");
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, colorFilter) == null) {
                throw new UnsupportedOperationException("Setting a color filter is not supported");
            }
        }

        public TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f2, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f3, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, int i5, boolean z, boolean z2, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pathMotion, view, rectF, shapeAppearanceModel, Float.valueOf(f2), view2, rectF2, shapeAppearanceModel2, Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), fadeModeEvaluator, fitModeEvaluator, progressThresholdsGroup, Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.containerPaint = new Paint();
            this.startContainerPaint = new Paint();
            this.endContainerPaint = new Paint();
            this.shadowPaint = new Paint();
            this.scrimPaint = new Paint();
            this.maskEvaluator = new MaskEvaluator();
            this.motionPathPosition = new float[2];
            this.compatShadowDrawable = new MaterialShapeDrawable();
            this.debugPaint = new Paint();
            this.debugPath = new Path();
            this.startView = view;
            this.startBounds = rectF;
            this.startShapeAppearanceModel = shapeAppearanceModel;
            this.startElevation = f2;
            this.endView = view2;
            this.endBounds = rectF2;
            this.endShapeAppearanceModel = shapeAppearanceModel2;
            this.endElevation = f3;
            this.entering = z;
            this.elevationShadowEnabled = z2;
            this.fadeModeEvaluator = fadeModeEvaluator;
            this.fitModeEvaluator = fitModeEvaluator;
            this.progressThresholds = progressThresholdsGroup;
            this.drawDebugEnabled = z3;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.displayWidth = displayMetrics.widthPixels;
            this.displayHeight = displayMetrics.heightPixels;
            this.containerPaint.setColor(i2);
            this.startContainerPaint.setColor(i3);
            this.endContainerPaint.setColor(i4);
            this.compatShadowDrawable.setFillColor(ColorStateList.valueOf(0));
            this.compatShadowDrawable.setShadowCompatibilityMode(2);
            this.compatShadowDrawable.setShadowBitmapDrawingEnable(false);
            this.compatShadowDrawable.setShadowColor(-7829368);
            this.currentStartBounds = new RectF(rectF);
            this.currentStartBoundsMasked = new RectF(this.currentStartBounds);
            this.currentEndBounds = new RectF(this.currentStartBounds);
            this.currentEndBoundsMasked = new RectF(this.currentEndBounds);
            PointF motionPathPoint = getMotionPathPoint(rectF);
            PointF motionPathPoint2 = getMotionPathPoint(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(motionPathPoint.x, motionPathPoint.y, motionPathPoint2.x, motionPathPoint2.y), false);
            this.motionPathMeasure = pathMeasure;
            this.motionPathLength = pathMeasure.getLength();
            this.motionPathPosition[0] = rectF.centerX();
            this.motionPathPosition[1] = rectF.top;
            this.scrimPaint.setStyle(Paint.Style.FILL);
            this.scrimPaint.setShader(TransitionUtils.createColorShader(i5));
            this.debugPaint.setStyle(Paint.Style.STROKE);
            this.debugPaint.setStrokeWidth(10.0f);
            updateProgress(0.0f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2023023813, "Lcom/google/android/material/transition/platform/MaterialContainerTransform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2023023813, "Lcom/google/android/material/transition/platform/MaterialContainerTransform;");
                return;
            }
        }
        TAG = MaterialContainerTransform.class.getSimpleName();
        TRANSITION_PROPS = new String[]{"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
        DEFAULT_ENTER_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
        DEFAULT_RETURN_THRESHOLDS = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
        DEFAULT_ENTER_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
        DEFAULT_RETURN_THRESHOLDS_ARC = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    }

    public MaterialContainerTransform() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.drawingViewId = 16908290;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private ProgressThresholdsGroup buildThresholdsGroup(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            PathMotion pathMotion = getPathMotion();
            if (!(pathMotion instanceof ArcMotion) && !(pathMotion instanceof MaterialArcMotion)) {
                return getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
            }
            return getThresholdsOrDefault(z, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
        }
        return (ProgressThresholdsGroup) invokeZ.objValue;
    }

    public static RectF calculateDrawableBounds(View view, @Nullable View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view, view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (view2 != null) {
                RectF locationOnScreen = TransitionUtils.getLocationOnScreen(view2);
                locationOnScreen.offset(f2, f3);
                return locationOnScreen;
            }
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        return (RectF) invokeCommon.objValue;
    }

    public static ShapeAppearanceModel captureShapeAppearance(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, view, rectF, shapeAppearanceModel)) == null) ? TransitionUtils.convertToRelativeCornerSizes(getShapeAppearance(view, shapeAppearanceModel), rectF) : (ShapeAppearanceModel) invokeLLL.objValue;
    }

    public static void captureValues(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i2, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(AdIconUtil.BAIDU_LOGO_ID, null, transitionValues, view, i2, shapeAppearanceModel) == null) {
            if (i2 != -1) {
                transitionValues.view = TransitionUtils.findDescendantOrAncestorById(transitionValues.view, i2);
            } else if (view != null) {
                transitionValues.view = view;
            } else if (transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view) instanceof View) {
                transitionValues.view.setTag(R.id.mtrl_motion_snapshot_view, null);
                transitionValues.view = (View) transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view);
            }
            View view2 = transitionValues.view;
            if (!ViewCompat.isLaidOut(view2) && view2.getWidth() == 0 && view2.getHeight() == 0) {
                return;
            }
            RectF relativeBounds = view2.getParent() == null ? TransitionUtils.getRelativeBounds(view2) : TransitionUtils.getLocationOnScreen(view2);
            transitionValues.values.put("materialContainerTransition:bounds", relativeBounds);
            transitionValues.values.put("materialContainerTransition:shapeAppearance", captureShapeAppearance(view2, relativeBounds, shapeAppearanceModel));
        }
    }

    public static float getElevationOrDefault(float f2, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f2), view})) == null) ? f2 != -1.0f ? f2 : ViewCompat.getElevation(view) : invokeCommon.floatValue;
    }

    public static ShapeAppearanceModel getShapeAppearance(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, view, shapeAppearanceModel)) == null) {
            if (shapeAppearanceModel != null) {
                return shapeAppearanceModel;
            }
            if (view.getTag(R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) {
                return (ShapeAppearanceModel) view.getTag(R.id.mtrl_motion_snapshot_view);
            }
            Context context = view.getContext();
            int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
            if (transitionShapeAppearanceResId != -1) {
                return ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build();
            }
            if (view instanceof Shapeable) {
                return ((Shapeable) view).getShapeAppearanceModel();
            }
            return ShapeAppearanceModel.builder().build();
        }
        return (ShapeAppearanceModel) invokeLL.objValue;
    }

    private ProgressThresholdsGroup getThresholdsOrDefault(boolean z, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), progressThresholdsGroup, progressThresholdsGroup2})) == null) {
            if (!z) {
                progressThresholdsGroup = progressThresholdsGroup2;
            }
            return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.defaultIfNull(this.fadeProgressThresholds, progressThresholdsGroup.fade), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleProgressThresholds, progressThresholdsGroup.scale), (ProgressThresholds) TransitionUtils.defaultIfNull(this.scaleMaskProgressThresholds, progressThresholdsGroup.scaleMask), (ProgressThresholds) TransitionUtils.defaultIfNull(this.shapeMaskProgressThresholds, progressThresholdsGroup.shapeMask));
        }
        return (ProgressThresholdsGroup) invokeCommon.objValue;
    }

    @StyleRes
    public static int getTransitionShapeAppearanceResId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            return resourceId;
        }
        return invokeL.intValue;
    }

    private boolean isEntering(@NonNull RectF rectF, @NonNull RectF rectF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, rectF, rectF2)) == null) {
            int i2 = this.transitionDirection;
            if (i2 == 0) {
                return TransitionUtils.calculateArea(rectF2) > TransitionUtils.calculateArea(rectF);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
        }
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
        }
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        View findAncestorById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            if (transitionValues != null && transitionValues2 != null) {
                RectF rectF = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.values.get("materialContainerTransition:shapeAppearance");
                if (rectF != null && shapeAppearanceModel != null) {
                    RectF rectF2 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                    ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                    if (rectF2 != null && shapeAppearanceModel2 != null) {
                        View view = transitionValues.view;
                        View view2 = transitionValues2.view;
                        View view3 = view2.getParent() != null ? view2 : view;
                        if (this.drawingViewId == view3.getId()) {
                            findAncestorById = (View) view3.getParent();
                        } else {
                            findAncestorById = TransitionUtils.findAncestorById(view3, this.drawingViewId);
                            view3 = null;
                        }
                        RectF locationOnScreen = TransitionUtils.getLocationOnScreen(findAncestorById);
                        float f2 = -locationOnScreen.left;
                        float f3 = -locationOnScreen.top;
                        RectF calculateDrawableBounds = calculateDrawableBounds(findAncestorById, view3, f2, f3);
                        rectF.offset(f2, f3);
                        rectF2.offset(f2, f3);
                        boolean isEntering = isEntering(rectF, rectF2);
                        TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view, rectF, shapeAppearanceModel, getElevationOrDefault(this.startElevation, view), view2, rectF2, shapeAppearanceModel2, getElevationOrDefault(this.endElevation, view2), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, isEntering, this.elevationShadowEnabled, FadeModeEvaluators.get(this.fadeMode, isEntering), FitModeEvaluators.get(this.fitMode, isEntering, rectF, rectF2), buildThresholdsGroup(isEntering), this.drawDebugEnabled);
                        transitionDrawable.setBounds(Math.round(calculateDrawableBounds.left), Math.round(calculateDrawableBounds.top), Math.round(calculateDrawableBounds.right), Math.round(calculateDrawableBounds.bottom));
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, transitionDrawable) { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MaterialContainerTransform this$0;
                            public final /* synthetic */ TransitionDrawable val$transitionDrawable;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, transitionDrawable};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$transitionDrawable = transitionDrawable;
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                                    this.val$transitionDrawable.setProgress(valueAnimator.getAnimatedFraction());
                                }
                            }
                        });
                        addListener(new TransitionListenerAdapter(this, findAncestorById, transitionDrawable, view, view2) { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MaterialContainerTransform this$0;
                            public final /* synthetic */ View val$drawingView;
                            public final /* synthetic */ View val$endView;
                            public final /* synthetic */ View val$startView;
                            public final /* synthetic */ TransitionDrawable val$transitionDrawable;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, findAncestorById, transitionDrawable, view, view2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$drawingView = findAncestorById;
                                this.val$transitionDrawable = transitionDrawable;
                                this.val$startView = view;
                                this.val$endView = view2;
                            }

                            @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                            public void onTransitionEnd(@NonNull Transition transition) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                    this.this$0.removeListener(this);
                                    if (this.this$0.holdAtEndEnabled) {
                                        return;
                                    }
                                    this.val$startView.setAlpha(1.0f);
                                    this.val$endView.setAlpha(1.0f);
                                    ViewUtils.getOverlay(this.val$drawingView).remove(this.val$transitionDrawable);
                                }
                            }

                            @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                            public void onTransitionStart(@NonNull Transition transition) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                                    ViewUtils.getOverlay(this.val$drawingView).add(this.val$transitionDrawable);
                                    this.val$startView.setAlpha(0.0f);
                                    this.val$endView.setAlpha(0.0f);
                                }
                            }
                        });
                        return ofFloat;
                    }
                }
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    @ColorInt
    public int getContainerColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.containerColor : invokeV.intValue;
    }

    @IdRes
    public int getDrawingViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.drawingViewId : invokeV.intValue;
    }

    @ColorInt
    public int getEndContainerColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.endContainerColor : invokeV.intValue;
    }

    public float getEndElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.endElevation : invokeV.floatValue;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.endShapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public View getEndView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.endView : (View) invokeV.objValue;
    }

    @IdRes
    public int getEndViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.endViewId : invokeV.intValue;
    }

    public int getFadeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.fadeMode : invokeV.intValue;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.fadeProgressThresholds : (ProgressThresholds) invokeV.objValue;
    }

    public int getFitMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.fitMode : invokeV.intValue;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.scaleMaskProgressThresholds : (ProgressThresholds) invokeV.objValue;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.scaleProgressThresholds : (ProgressThresholds) invokeV.objValue;
    }

    @ColorInt
    public int getScrimColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.scrimColor : invokeV.intValue;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.shapeMaskProgressThresholds : (ProgressThresholds) invokeV.objValue;
    }

    @ColorInt
    public int getStartContainerColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.startContainerColor : invokeV.intValue;
    }

    public float getStartElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.startElevation : invokeV.floatValue;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.startShapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public View getStartView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.startView : (View) invokeV.objValue;
    }

    @IdRes
    public int getStartViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.startViewId : invokeV.intValue;
    }

    public int getTransitionDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.transitionDirection : invokeV.intValue;
    }

    @Override // android.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? TRANSITION_PROPS : (String[]) invokeV.objValue;
    }

    public boolean isDrawDebugEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.drawDebugEnabled : invokeV.booleanValue;
    }

    public boolean isElevationShadowEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.elevationShadowEnabled : invokeV.booleanValue;
    }

    public boolean isHoldAtEndEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.holdAtEndEnabled : invokeV.booleanValue;
    }

    public void setAllContainerColors(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.containerColor = i2;
            this.startContainerColor = i2;
            this.endContainerColor = i2;
        }
    }

    public void setContainerColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.containerColor = i2;
        }
    }

    public void setDrawDebugEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.drawDebugEnabled = z;
        }
    }

    public void setDrawingViewId(@IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.drawingViewId = i2;
        }
    }

    public void setElevationShadowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.elevationShadowEnabled = z;
        }
    }

    public void setEndContainerColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.endContainerColor = i2;
        }
    }

    public void setEndElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f2) == null) {
            this.endElevation = f2;
        }
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, shapeAppearanceModel) == null) {
            this.endShapeAppearanceModel = shapeAppearanceModel;
        }
    }

    public void setEndView(@Nullable View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            this.endView = view;
        }
    }

    public void setEndViewId(@IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.endViewId = i2;
        }
    }

    public void setFadeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.fadeMode = i2;
        }
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, progressThresholds) == null) {
            this.fadeProgressThresholds = progressThresholds;
        }
    }

    public void setFitMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.fitMode = i2;
        }
    }

    public void setHoldAtEndEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.holdAtEndEnabled = z;
        }
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, progressThresholds) == null) {
            this.scaleMaskProgressThresholds = progressThresholds;
        }
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, progressThresholds) == null) {
            this.scaleProgressThresholds = progressThresholds;
        }
    }

    public void setScrimColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.scrimColor = i2;
        }
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, progressThresholds) == null) {
            this.shapeMaskProgressThresholds = progressThresholds;
        }
    }

    public void setStartContainerColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.startContainerColor = i2;
        }
    }

    public void setStartElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            this.startElevation = f2;
        }
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, shapeAppearanceModel) == null) {
            this.startShapeAppearanceModel = shapeAppearanceModel;
        }
    }

    public void setStartView(@Nullable View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, view) == null) {
            this.startView = view;
        }
    }

    public void setStartViewId(@IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.startViewId = i2;
        }
    }

    public void setTransitionDirection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.transitionDirection = i2;
        }
    }
}
