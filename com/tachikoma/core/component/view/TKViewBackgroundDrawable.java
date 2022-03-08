package com.tachikoma.core.component.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.TKColorUtil;
import com.tachikoma.core.utility.TKFloatUtil;
import com.tachikoma.core.utility.TKSpacing;
import java.util.Arrays;
import java.util.Locale;
@Keep
/* loaded from: classes8.dex */
public class TKViewBackgroundDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL_BITS_SET = -1;
    public static final int ALL_BITS_UNSET = 0;
    public static final int DEFAULT_BORDER_ALPHA = 255;
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final int DEFAULT_BORDER_RGB = 0;
    public static float UNDEFINED = 1.0E21f;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    public TKSpacing mBorderAlpha;
    public String mBorderColor;
    public float[] mBorderCornerRadii;
    public TKSpacing mBorderRGB;
    public float mBorderRadius;
    public BorderStyle mBorderStyle;
    public TKSpacing mBorderWidth;
    public Path mCenterDrawPath;
    public int mColor;
    public final Context mContext;
    public Gradient mGradient;
    public final Paint mGradientPaint;
    public PointF mInnerBottomLeftCorner;
    public PointF mInnerBottomRightCorner;
    public Path mInnerClipPathForBorderRadius;
    public RectF mInnerClipTempRectForBorderRadius;
    public PointF mInnerTopLeftCorner;
    public PointF mInnerTopRightCorner;
    public int mLayoutDirection;
    public boolean mNeedUpdatePathForBorderRadius;
    public Path mOuterClipPathForBorderRadius;
    public RectF mOuterClipTempRectForBorderRadius;
    public final Paint mPaint;
    public PathEffect mPathEffectForBorderStyle;
    public Path mPathForBorder;
    public Path mPathForBorderRadiusOutline;
    public Shadow mShadow;
    public final Paint mShadowPaint;
    public RectF mTempRectForBorderRadiusOutline;
    public RectF mTempRectForCenterDrawPath;

    /* renamed from: com.tachikoma.core.component.view.TKViewBackgroundDrawable$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tachikoma$core$component$view$TKViewBackgroundDrawable$BorderStyle;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1413458948, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1413458948, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable$1;");
                    return;
                }
            }
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$tachikoma$core$component$view$TKViewBackgroundDrawable$BorderStyle = iArr;
            try {
                iArr[BorderStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tachikoma$core$component$view$TKViewBackgroundDrawable$BorderStyle[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tachikoma$core$component$view$TKViewBackgroundDrawable$BorderStyle[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class BorderRadiusLocation {
        public static final /* synthetic */ BorderRadiusLocation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BorderRadiusLocation BOTTOM_END;
        public static final BorderRadiusLocation BOTTOM_LEFT;
        public static final BorderRadiusLocation BOTTOM_RIGHT;
        public static final BorderRadiusLocation BOTTOM_START;
        public static final BorderRadiusLocation TOP_END;
        public static final BorderRadiusLocation TOP_LEFT;
        public static final BorderRadiusLocation TOP_RIGHT;
        public static final BorderRadiusLocation TOP_START;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2042891438, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable$BorderRadiusLocation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2042891438, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable$BorderRadiusLocation;");
                    return;
                }
            }
            TOP_LEFT = new BorderRadiusLocation("TOP_LEFT", 0);
            TOP_RIGHT = new BorderRadiusLocation("TOP_RIGHT", 1);
            BOTTOM_RIGHT = new BorderRadiusLocation("BOTTOM_RIGHT", 2);
            BOTTOM_LEFT = new BorderRadiusLocation("BOTTOM_LEFT", 3);
            TOP_START = new BorderRadiusLocation("TOP_START", 4);
            TOP_END = new BorderRadiusLocation("TOP_END", 5);
            BOTTOM_START = new BorderRadiusLocation("BOTTOM_START", 6);
            BorderRadiusLocation borderRadiusLocation = new BorderRadiusLocation("BOTTOM_END", 7);
            BOTTOM_END = borderRadiusLocation;
            $VALUES = new BorderRadiusLocation[]{TOP_LEFT, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, TOP_START, TOP_END, BOTTOM_START, borderRadiusLocation};
        }

        public BorderRadiusLocation(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BorderRadiusLocation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BorderRadiusLocation) Enum.valueOf(BorderRadiusLocation.class, str) : (BorderRadiusLocation) invokeL.objValue;
        }

        public static BorderRadiusLocation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BorderRadiusLocation[]) $VALUES.clone() : (BorderRadiusLocation[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class BorderStyle {
        public static final /* synthetic */ BorderStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BorderStyle DASHED;
        public static final BorderStyle DOTTED;
        public static final BorderStyle SOLID;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-529131152, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable$BorderStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-529131152, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable$BorderStyle;");
                    return;
                }
            }
            SOLID = new BorderStyle("SOLID", 0);
            DASHED = new BorderStyle("DASHED", 1);
            BorderStyle borderStyle = new BorderStyle("DOTTED", 2);
            DOTTED = borderStyle;
            $VALUES = new BorderStyle[]{SOLID, DASHED, borderStyle};
        }

        public BorderStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PathEffect getPathEffect(BorderStyle borderStyle, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, borderStyle, f2)) == null) {
                int i2 = AnonymousClass1.$SwitchMap$com$tachikoma$core$component$view$TKViewBackgroundDrawable$BorderStyle[borderStyle.ordinal()];
                if (i2 == 2) {
                    float f3 = f2 * 3.0f;
                    return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
                } else if (i2 != 3) {
                    return null;
                } else {
                    return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
                }
            }
            return (PathEffect) invokeLF.objValue;
        }

        public static BorderStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (BorderStyle) Enum.valueOf(BorderStyle.class, str) : (BorderStyle) invokeL.objValue;
        }

        public static BorderStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (BorderStyle[]) $VALUES.clone() : (BorderStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class Gradient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] colors;
        public int deg;
        public float[] positions;

        public Gradient() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class Shadow {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int color;
        public float dx;
        public float dy;
        public float radius;

        public Shadow(float f2, float f3, float f4, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.radius = f2;
            this.dx = f3;
            this.dy = f4;
            this.color = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(935548017, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(935548017, "Lcom/tachikoma/core/component/view/TKViewBackgroundDrawable;");
        }
    }

    public TKViewBackgroundDrawable(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNeedUpdatePathForBorderRadius = false;
        this.mBorderRadius = UNDEFINED;
        this.mPaint = new Paint(1);
        this.mGradientPaint = new Paint(1);
        this.mShadowPaint = new Paint(1);
        this.mColor = 0;
        this.mAlpha = 255;
        this.mContext = context;
    }

    public static int colorFromAlphaAndRGBComponents(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((((int) f2) << 24) & (-16777216)) | (((int) f3) & 16777215) : invokeCommon.intValue;
    }

    private void drawGradient(@NonNull Canvas canvas, @NonNull Gradient gradient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, canvas, gradient) == null) {
            float[] gradientLine = getGradientLine(gradient, getBoundsExcludeShadow());
            this.mGradientPaint.setShader(new LinearGradient(gradientLine[0], gradientLine[1], gradientLine[2], gradientLine[3], gradient.colors, gradient.positions, Shader.TileMode.CLAMP));
            if (hasRoundedBorders()) {
                canvas.drawPath(this.mInnerClipPathForBorderRadius, this.mGradientPaint);
            } else {
                canvas.drawRect(getBoundsExcludeShadow(), this.mGradientPaint);
            }
        }
    }

    private void drawQuadrilateral(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{canvas, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)}) == null) || i2 == 0) {
            return;
        }
        if (this.mPathForBorder == null) {
            this.mPathForBorder = new Path();
        }
        this.mPaint.setColor(i2);
        this.mPathForBorder.reset();
        this.mPathForBorder.moveTo(f2, f3);
        this.mPathForBorder.lineTo(f4, f5);
        this.mPathForBorder.lineTo(f6, f7);
        this.mPathForBorder.lineTo(f8, f9);
        this.mPathForBorder.lineTo(f2, f3);
        canvas.drawPath(this.mPathForBorder, this.mPaint);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        int i2;
        int i3;
        int fastBorderCompatibleColorOrZero;
        int i4;
        TKViewBackgroundDrawable tKViewBackgroundDrawable;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, canvas) == null) {
            int multiplyColorAlpha = TKColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
            Gradient gradient = this.mGradient;
            if (gradient != null) {
                drawGradient(canvas, gradient);
            } else if (Color.alpha(multiplyColorAlpha) != 0) {
                this.mPaint.setColor(multiplyColorAlpha);
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas.drawRect(getBoundsExcludeShadow(), this.mPaint);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            int round = Math.round(directionAwareBorderInsets.left);
            int round2 = Math.round(directionAwareBorderInsets.top);
            int round3 = Math.round(directionAwareBorderInsets.right);
            int round4 = Math.round(directionAwareBorderInsets.bottom);
            if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
                Rect boundsExcludeShadow = getBoundsExcludeShadow();
                int borderColor = getBorderColor(0);
                int borderColor2 = getBorderColor(1);
                int borderColor3 = getBorderColor(2);
                int borderColor4 = getBorderColor(3);
                if (Build.VERSION.SDK_INT >= 17) {
                    boolean z = getResolvedLayoutDirection() == 1;
                    int borderColor5 = getBorderColor(4);
                    int borderColor6 = getBorderColor(5);
                    int i9 = z ? borderColor6 : borderColor5;
                    if (!z) {
                        borderColor5 = borderColor6;
                    }
                    boolean isBorderColorDefined = isBorderColorDefined(4);
                    boolean isBorderColorDefined2 = isBorderColorDefined(5);
                    boolean z2 = z ? isBorderColorDefined2 : isBorderColorDefined;
                    if (!z) {
                        isBorderColorDefined = isBorderColorDefined2;
                    }
                    if (z2) {
                        borderColor = i9;
                    }
                    if (isBorderColorDefined) {
                        i2 = borderColor;
                        i3 = borderColor5;
                        int i10 = boundsExcludeShadow.left;
                        int i11 = boundsExcludeShadow.top;
                        fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor2, i3, borderColor4);
                        if (fastBorderCompatibleColorOrZero != 0) {
                            this.mPaint.setAntiAlias(false);
                            int width = boundsExcludeShadow.width();
                            int height = boundsExcludeShadow.height();
                            if (round > 0) {
                                float f2 = i10;
                                float f3 = i10 + round;
                                i4 = i10;
                                drawQuadrilateral(canvas, i2, f2, i11, f3, i11 + round2, f3, i8 - round4, f2, i11 + height);
                            } else {
                                i4 = i10;
                            }
                            if (round2 > 0) {
                                float f4 = i11;
                                float f5 = i11 + round2;
                                drawQuadrilateral(canvas, borderColor2, i4, f4, i4 + round, f5, i7 - round3, f5, i4 + width, f4);
                            }
                            if (round3 > 0) {
                                int i12 = i4 + width;
                                float f6 = i12;
                                float f7 = i12 - round3;
                                drawQuadrilateral(canvas, i3, f6, i11, f6, i11 + height, f7, i6 - round4, f7, i11 + round2);
                            }
                            if (round4 > 0) {
                                int i13 = i11 + height;
                                float f8 = i13;
                                float f9 = i13 - round4;
                                tKViewBackgroundDrawable = this;
                                tKViewBackgroundDrawable.drawQuadrilateral(canvas, borderColor4, i4, f8, i4 + width, f8, i5 - round3, f9, i4 + round, f9);
                            } else {
                                tKViewBackgroundDrawable = this;
                            }
                            tKViewBackgroundDrawable.mPaint.setAntiAlias(true);
                            return;
                        } else if (Color.alpha(fastBorderCompatibleColorOrZero) != 0) {
                            int i14 = boundsExcludeShadow.right;
                            int i15 = boundsExcludeShadow.bottom;
                            this.mPaint.setColor(fastBorderCompatibleColorOrZero);
                            if (round > 0) {
                                canvas.drawRect(i10, i11, i10 + round, i15 - round4, this.mPaint);
                            }
                            if (round2 > 0) {
                                canvas.drawRect(i10 + round, i11, i14, i11 + round2, this.mPaint);
                            }
                            if (round3 > 0) {
                                canvas.drawRect(i14 - round3, i11 + round2, i14, i15, this.mPaint);
                            }
                            if (round4 > 0) {
                                canvas.drawRect(i10, i15 - round4, i14 - round3, i15, this.mPaint);
                            }
                        }
                    }
                }
                i2 = borderColor;
                i3 = borderColor3;
                int i102 = boundsExcludeShadow.left;
                int i112 = boundsExcludeShadow.top;
                fastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor2, i3, borderColor4);
                if (fastBorderCompatibleColorOrZero != 0) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        int i2;
        int i3;
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, canvas) == null) {
            updatePath();
            canvas.save();
            Gradient gradient = this.mGradient;
            if (gradient != null) {
                drawGradient(canvas, gradient);
            } else {
                int multiplyColorAlpha = TKColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
                if (Color.alpha(multiplyColorAlpha) != 0) {
                    this.mPaint.setColor(multiplyColorAlpha);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    canvas.drawPath(this.mInnerClipPathForBorderRadius, this.mPaint);
                }
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
                float fullBorderWidth = getFullBorderWidth();
                if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth) {
                    this.mPaint.setStyle(Paint.Style.FILL);
                    canvas.clipPath(this.mOuterClipPathForBorderRadius, Region.Op.INTERSECT);
                    canvas.clipPath(this.mInnerClipPathForBorderRadius, Region.Op.DIFFERENCE);
                    int borderColor = getBorderColor(0);
                    int borderColor2 = getBorderColor(1);
                    int borderColor3 = getBorderColor(2);
                    int borderColor4 = getBorderColor(3);
                    if (Build.VERSION.SDK_INT >= 17) {
                        boolean z = getResolvedLayoutDirection() == 1;
                        int borderColor5 = getBorderColor(4);
                        int borderColor6 = getBorderColor(5);
                        int i4 = z ? borderColor6 : borderColor5;
                        if (!z) {
                            borderColor5 = borderColor6;
                        }
                        boolean isBorderColorDefined = isBorderColorDefined(4);
                        boolean isBorderColorDefined2 = isBorderColorDefined(5);
                        boolean z2 = z ? isBorderColorDefined2 : isBorderColorDefined;
                        if (!z) {
                            isBorderColorDefined = isBorderColorDefined2;
                        }
                        if (z2) {
                            borderColor = i4;
                        }
                        if (isBorderColorDefined) {
                            i2 = borderColor;
                            i3 = borderColor5;
                            RectF rectF = this.mOuterClipTempRectForBorderRadius;
                            float f6 = rectF.left;
                            float f7 = rectF.right;
                            float f8 = rectF.top;
                            float f9 = rectF.bottom;
                            if (directionAwareBorderInsets.left <= 0.0f) {
                                PointF pointF = this.mInnerTopLeftCorner;
                                float f10 = pointF.x;
                                float f11 = pointF.y;
                                PointF pointF2 = this.mInnerBottomLeftCorner;
                                f2 = f9;
                                f3 = f8;
                                f4 = f7;
                                f5 = f6;
                                drawQuadrilateral(canvas, i2, f6, f8, f10, f11, pointF2.x, pointF2.y, f6, f2);
                            } else {
                                f2 = f9;
                                f3 = f8;
                                f4 = f7;
                                f5 = f6;
                            }
                            if (directionAwareBorderInsets.top > 0.0f) {
                                PointF pointF3 = this.mInnerTopLeftCorner;
                                float f12 = pointF3.x;
                                float f13 = pointF3.y;
                                PointF pointF4 = this.mInnerTopRightCorner;
                                drawQuadrilateral(canvas, borderColor2, f5, f3, f12, f13, pointF4.x, pointF4.y, f4, f3);
                            }
                            if (directionAwareBorderInsets.right > 0.0f) {
                                PointF pointF5 = this.mInnerTopRightCorner;
                                float f14 = pointF5.x;
                                float f15 = pointF5.y;
                                PointF pointF6 = this.mInnerBottomRightCorner;
                                drawQuadrilateral(canvas, i3, f4, f3, f14, f15, pointF6.x, pointF6.y, f4, f2);
                            }
                            if (directionAwareBorderInsets.bottom > 0.0f) {
                                PointF pointF7 = this.mInnerBottomLeftCorner;
                                float f16 = pointF7.x;
                                float f17 = pointF7.y;
                                PointF pointF8 = this.mInnerBottomRightCorner;
                                drawQuadrilateral(canvas, borderColor4, f5, f2, f16, f17, pointF8.x, pointF8.y, f4, f2);
                            }
                        }
                    }
                    i2 = borderColor;
                    i3 = borderColor3;
                    RectF rectF2 = this.mOuterClipTempRectForBorderRadius;
                    float f62 = rectF2.left;
                    float f72 = rectF2.right;
                    float f82 = rectF2.top;
                    float f92 = rectF2.bottom;
                    if (directionAwareBorderInsets.left <= 0.0f) {
                    }
                    if (directionAwareBorderInsets.top > 0.0f) {
                    }
                    if (directionAwareBorderInsets.right > 0.0f) {
                    }
                    if (directionAwareBorderInsets.bottom > 0.0f) {
                    }
                } else if (fullBorderWidth > 0.0f) {
                    try {
                        this.mPaint.setColor(Color.parseColor(this.mBorderColor));
                    } catch (Exception unused) {
                    }
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setStrokeWidth(fullBorderWidth);
                    canvas.drawPath(this.mCenterDrawPath, this.mPaint);
                }
            }
            canvas.restore();
        }
    }

    private void drawShadow(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
            this.mShadowPaint.setColor(0);
            this.mShadowPaint.setStyle(Paint.Style.FILL);
            Paint paint = this.mShadowPaint;
            Shadow shadow = this.mShadow;
            paint.setShadowLayer(shadow.radius, shadow.dx, shadow.dy, shadow.color);
            if (hasRoundedBorders()) {
                canvas.drawPath(this.mOuterClipPathForBorderRadius, this.mShadowPaint);
            } else {
                canvas.drawRect(getBoundsExcludeShadow(), this.mShadowPaint);
            }
        }
    }

    private void drawShadowBelow_9_0(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, canvas) == null) {
            try {
                int i2 = (int) (this.mShadow.radius * 2.4f);
                Bitmap createBitmap = Bitmap.createBitmap(getBounds().width() + i2, getBounds().height() + i2, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = i2;
                canvas2.translate(f2, f2);
                this.mShadowPaint.setColor(0);
                this.mShadowPaint.setStyle(Paint.Style.FILL);
                this.mShadowPaint.setShadowLayer(this.mShadow.radius, this.mShadow.dx, this.mShadow.dy, this.mShadow.color);
                if (hasRoundedBorders()) {
                    canvas2.drawPath(this.mOuterClipPathForBorderRadius, this.mShadowPaint);
                } else {
                    canvas2.drawRect(getBoundsExcludeShadow(), this.mShadowPaint);
                }
                float f3 = -i2;
                canvas.drawBitmap(createBitmap, f3, f3, (Paint) null);
                if (createBitmap.isRecycled()) {
                    return;
                }
                createBitmap.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void drawShadowIfNeed(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, canvas) == null) || this.mShadow == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            drawShadow(canvas);
        } else {
            drawShadowBelow_9_0(canvas);
        }
    }

    public static int fastBorderCompatibleColorOrZero(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)})) == null) {
            int i10 = (i5 > 0 ? i9 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1) & (i4 > 0 ? i8 : -1);
            if (i2 <= 0) {
                i6 = 0;
            }
            if (i3 <= 0) {
                i7 = 0;
            }
            int i11 = i6 | i7;
            if (i4 <= 0) {
                i8 = 0;
            }
            int i12 = i11 | i8;
            if (i5 <= 0) {
                i9 = 0;
            }
            if (i10 == (i12 | i9)) {
                return i10;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    private int getBorderColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) {
            TKSpacing tKSpacing = this.mBorderRGB;
            float f2 = tKSpacing != null ? tKSpacing.get(i2) : 0.0f;
            TKSpacing tKSpacing2 = this.mBorderAlpha;
            return colorFromAlphaAndRGBComponents(tKSpacing2 != null ? tKSpacing2.get(i2) : 255.0f, f2);
        }
        return invokeI.intValue;
    }

    private int getBorderWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) {
            TKSpacing tKSpacing = this.mBorderWidth;
            if (tKSpacing == null) {
                return 0;
            }
            float f2 = tKSpacing.get(i2);
            if (isUndefined(f2)) {
                return -1;
            }
            return Math.round(f2);
        }
        return invokeI.intValue;
    }

    private Rect getBoundsExcludeShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            Shadow shadow = this.mShadow;
            float f2 = shadow != null ? shadow.radius : 0.0f;
            if (f2 <= 0.0f) {
                return getBounds();
            }
            Rect rect = new Rect(getBounds());
            rect.left = (int) (rect.left + f2);
            rect.top = (int) (rect.top + f2);
            rect.right = (int) (rect.right - f2);
            rect.bottom = (int) (rect.bottom - f2);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public static void getEllipseIntersectionWithLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), Double.valueOf(d9), pointF}) == null) {
            double d10 = (d2 + d4) / 2.0d;
            double d11 = (d3 + d5) / 2.0d;
            double d12 = d6 - d10;
            double d13 = d7 - d11;
            double abs = Math.abs(d4 - d2) / 2.0d;
            double abs2 = Math.abs(d5 - d3) / 2.0d;
            double d14 = ((d9 - d11) - d13) / ((d8 - d10) - d12);
            double d15 = d13 - (d12 * d14);
            double d16 = abs2 * abs2;
            double d17 = abs * abs;
            double d18 = d16 + (d17 * d14 * d14);
            double d19 = abs * 2.0d * abs * d15 * d14;
            double d20 = (-(d17 * ((d15 * d15) - d16))) / d18;
            double d21 = d18 * 2.0d;
            double sqrt = ((-d19) / d21) - Math.sqrt(d20 + Math.pow(d19 / d21, 2.0d));
            double d22 = sqrt + d10;
            double d23 = (d14 * sqrt) + d15 + d11;
            if (Double.isNaN(d22) || Double.isNaN(d23)) {
                return;
            }
            pointF.x = (float) d22;
            pointF.y = (float) d23;
        }
    }

    private float[] getGradientLine(Gradient gradient, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, gradient, rect)) == null) {
            int i2 = ((gradient.deg % 360) + 360) % 360;
            float[] fArr = new float[4];
            float f2 = (rect.left + rect.right) / 2.0f;
            float f3 = (rect.top + rect.bottom) / 2.0f;
            int i3 = i2 / 45;
            int i4 = i2 % 45;
            float tan = (float) Math.tan(Math.toRadians(i4));
            float tan2 = (float) Math.tan(Math.toRadians(45 - i4));
            switch (i3) {
                case 0:
                    float f4 = tan * f2;
                    fArr[0] = rect.left;
                    fArr[1] = f3 + f4;
                    fArr[2] = rect.right;
                    fArr[3] = f3 - f4;
                    break;
                case 1:
                    float f5 = f2 - (tan2 * f3);
                    fArr[0] = f5;
                    fArr[1] = rect.bottom;
                    fArr[2] = rect.right - f5;
                    fArr[3] = rect.top;
                    break;
                case 2:
                    float f6 = tan * f3;
                    fArr[0] = f2 + f6;
                    fArr[1] = rect.bottom;
                    fArr[2] = f2 - f6;
                    fArr[3] = rect.top;
                    break;
                case 3:
                    float f7 = f3 - (tan2 * f2);
                    fArr[0] = rect.right;
                    fArr[1] = rect.bottom - f7;
                    fArr[2] = rect.left;
                    fArr[3] = f7;
                    break;
                case 4:
                    float f8 = tan * f2;
                    fArr[2] = rect.left;
                    fArr[3] = f3 + f8;
                    fArr[0] = rect.right;
                    fArr[1] = f3 - f8;
                    break;
                case 5:
                    float f9 = f2 - (tan2 * f3);
                    fArr[2] = f9;
                    fArr[3] = rect.bottom;
                    fArr[0] = rect.right - f9;
                    fArr[1] = rect.top;
                    break;
                case 6:
                    float f10 = tan * f3;
                    fArr[2] = f2 + f10;
                    fArr[3] = rect.bottom;
                    fArr[0] = f2 - f10;
                    fArr[1] = rect.top;
                    break;
                case 7:
                    float f11 = f3 - (tan2 * f2);
                    fArr[2] = rect.right;
                    fArr[3] = rect.bottom - f11;
                    fArr[0] = rect.left;
                    fArr[1] = f11;
                    break;
            }
            return fArr;
        }
        return (float[]) invokeLL.objValue;
    }

    private boolean isBorderColorDefined(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) {
            TKSpacing tKSpacing = this.mBorderRGB;
            float f2 = tKSpacing != null ? tKSpacing.get(i2) : UNDEFINED;
            TKSpacing tKSpacing2 = this.mBorderAlpha;
            return (isUndefined(f2) || isUndefined(tKSpacing2 != null ? tKSpacing2.get(i2) : UNDEFINED)) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public static boolean isUndefined(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65553, null, f2)) == null) ? Float.compare(f2, UNDEFINED) == 0 : invokeF.booleanValue;
    }

    private void setBorderAlpha(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.mBorderAlpha == null) {
                this.mBorderAlpha = new TKSpacing(255.0f);
            }
            if (TKFloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i2), f2)) {
                return;
            }
            this.mBorderAlpha.set(i2, f2);
            invalidateSelf();
        }
    }

    private void setBorderRGB(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.mBorderRGB == null) {
                this.mBorderRGB = new TKSpacing(0.0f);
            }
            if (TKFloatUtil.floatsEqual(this.mBorderRGB.getRaw(i2), f2)) {
                return;
            }
            this.mBorderRGB.set(i2, f2);
            invalidateSelf();
        }
    }

    private void updatePath() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            Rect rect = new Rect(getBoundsExcludeShadow());
            this.mInnerClipTempRectForBorderRadius.set(rect);
            this.mOuterClipTempRectForBorderRadius.set(rect);
            this.mTempRectForBorderRadiusOutline.set(rect);
            this.mTempRectForCenterDrawPath.set(rect);
            float fullBorderWidth = getFullBorderWidth();
            if (fullBorderWidth > 0.0f) {
                float f2 = fullBorderWidth * 0.5f;
                this.mTempRectForCenterDrawPath.inset(f2, f2);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            RectF rectF = this.mInnerClipTempRectForBorderRadius;
            rectF.top += directionAwareBorderInsets.top;
            rectF.bottom -= directionAwareBorderInsets.bottom;
            rectF.left += directionAwareBorderInsets.left;
            rectF.right -= directionAwareBorderInsets.right;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            float borderRadiusOrDefaultTo4 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = getResolvedLayoutDirection() == 1;
                float borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
                float borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
                float borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                float borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                float f3 = z ? borderRadius2 : borderRadius;
                if (!z) {
                    borderRadius = borderRadius2;
                }
                float f4 = z ? borderRadius4 : borderRadius3;
                if (!z) {
                    borderRadius3 = borderRadius4;
                }
                if (!isUndefined(f3)) {
                    borderRadiusOrDefaultTo = f3;
                }
                if (!isUndefined(borderRadius)) {
                    borderRadiusOrDefaultTo2 = borderRadius;
                }
                if (!isUndefined(f4)) {
                    borderRadiusOrDefaultTo3 = f4;
                }
                if (!isUndefined(borderRadius3)) {
                    borderRadiusOrDefaultTo4 = borderRadius3;
                }
            }
            float max = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.left, 0.0f);
            float max2 = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
            float max3 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, 0.0f);
            float max4 = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, 0.0f);
            float max5 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.right, 0.0f);
            float max6 = Math.max(borderRadiusOrDefaultTo4 - directionAwareBorderInsets.bottom, 0.0f);
            float max7 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, 0.0f);
            float max8 = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, 0.0f);
            float f5 = borderRadiusOrDefaultTo3;
            float f6 = borderRadiusOrDefaultTo4;
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, borderRadiusOrDefaultTo2, f6, f6, f5, f5}, Path.Direction.CW);
            TKSpacing tKSpacing = this.mBorderWidth;
            float f7 = tKSpacing != null ? tKSpacing.get(8) / 2.0f : 0.0f;
            float f8 = borderRadiusOrDefaultTo + f7;
            float f9 = borderRadiusOrDefaultTo2 + f7;
            float f10 = f6 + f7;
            float f11 = f5 + f7;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{f8, f8, f9, f9, f10, f10, f11, f11}, Path.Direction.CW);
            this.mCenterDrawPath.addRoundRect(this.mTempRectForCenterDrawPath, new float[]{max + f7, max2 + f7, max3 + f7, max4 + f7, max5 + f7, max6 + f7, max7 + f7, max8 + f7}, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            PointF pointF = this.mInnerTopLeftCorner;
            RectF rectF2 = this.mInnerClipTempRectForBorderRadius;
            float f12 = rectF2.left;
            pointF.x = f12;
            float f13 = rectF2.top;
            pointF.y = f13;
            RectF rectF3 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(f12, f13, (max * 2.0f) + f12, (max2 * 2.0f) + f13, rectF3.left, rectF3.top, f12, f13, pointF);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            PointF pointF2 = this.mInnerBottomLeftCorner;
            RectF rectF4 = this.mInnerClipTempRectForBorderRadius;
            float f14 = rectF4.left;
            pointF2.x = f14;
            float f15 = rectF4.bottom;
            pointF2.y = f15;
            RectF rectF5 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(f14, f15 - (max8 * 2.0f), (max7 * 2.0f) + f14, f15, rectF5.left, rectF5.bottom, f14, f15, pointF2);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            PointF pointF3 = this.mInnerTopRightCorner;
            RectF rectF6 = this.mInnerClipTempRectForBorderRadius;
            float f16 = rectF6.right;
            pointF3.x = f16;
            float f17 = rectF6.top;
            pointF3.y = f17;
            RectF rectF7 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(f16 - (max3 * 2.0f), f17, f16, (max4 * 2.0f) + f17, rectF7.right, rectF7.top, f16, f17, pointF3);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            PointF pointF4 = this.mInnerBottomRightCorner;
            RectF rectF8 = this.mInnerClipTempRectForBorderRadius;
            float f18 = rectF8.right;
            pointF4.x = f18;
            float f19 = rectF8.bottom;
            pointF4.y = f19;
            RectF rectF9 = this.mOuterClipTempRectForBorderRadius;
            getEllipseIntersectionWithLine(f18 - (max5 * 2.0f), f19 - (max6 * 2.0f), f18, f19, rectF9.right, rectF9.bottom, f18, f19, pointF4);
        }
    }

    private void updatePathEffect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            BorderStyle borderStyle = this.mBorderStyle;
            PathEffect pathEffect = borderStyle != null ? BorderStyle.getPathEffect(borderStyle, getFullBorderWidth()) : null;
            this.mPathEffectForBorderStyle = pathEffect;
            this.mPaint.setPathEffect(pathEffect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            updatePathEffect();
            drawShadowIfNeed(canvas);
            if (hasRoundedBorders()) {
                drawRoundedBackgroundWithBorders(canvas);
            } else {
                drawRectangularBackgroundWithBorders(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAlpha : invokeV.intValue;
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, borderRadiusLocation)) == null) ? getBorderRadiusOrDefaultTo(UNDEFINED, borderRadiusLocation) : invokeL.floatValue;
    }

    public float getBorderRadiusOrDefaultTo(float f2, BorderRadiusLocation borderRadiusLocation) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), borderRadiusLocation})) == null) {
            float[] fArr = this.mBorderCornerRadii;
            if (fArr == null) {
                return f2;
            }
            float f3 = fArr[borderRadiusLocation.ordinal()];
            return isUndefined(f3) ? f2 : f3;
        }
        return invokeCommon.floatValue;
    }

    public float getBorderWidthOrDefaultTo(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            TKSpacing tKSpacing = this.mBorderWidth;
            if (tKSpacing == null) {
                return f2;
            }
            float raw = tKSpacing.getRaw(i2);
            return isUndefined(raw) ? f2 : raw;
        }
        return invokeCommon.floatValue;
    }

    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mColor : invokeV.intValue;
    }

    public RectF getDirectionAwareBorderInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
            float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
            float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
            float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
            float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
            if (Build.VERSION.SDK_INT >= 17 && this.mBorderWidth != null) {
                boolean z = getResolvedLayoutDirection() == 1;
                float raw = this.mBorderWidth.getRaw(4);
                float raw2 = this.mBorderWidth.getRaw(5);
                float f2 = z ? raw2 : raw;
                if (!z) {
                    raw = raw2;
                }
                if (!isUndefined(f2)) {
                    borderWidthOrDefaultTo4 = f2;
                }
                if (!isUndefined(raw)) {
                    borderWidthOrDefaultTo5 = raw;
                }
            }
            return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
        }
        return (RectF) invokeV.objValue;
    }

    public float getFullBorderRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isUndefined(this.mBorderRadius)) {
                return 0.0f;
            }
            return this.mBorderRadius;
        }
        return invokeV.floatValue;
    }

    public float getFullBorderWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TKSpacing tKSpacing = this.mBorderWidth;
            if (tKSpacing == null || isUndefined(tKSpacing.getRaw(8))) {
                return 0.0f;
            }
            return this.mBorderWidth.getRaw(8);
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TKColorUtil.getOpacityFromColor(TKColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha)) : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, outline) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                super.getOutline(outline);
            } else if ((isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) && this.mBorderCornerRadii == null) {
                outline.setRect(getBounds());
            } else {
                updatePath();
                outline.setConvexPath(this.mPathForBorderRadiusOutline);
            }
        }
    }

    public int getResolvedLayoutDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLayoutDirection : invokeV.intValue;
    }

    public boolean hasRoundedBorders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) {
                float[] fArr = this.mBorderCornerRadii;
                if (fArr != null) {
                    for (float f2 : fArr) {
                        if (!isUndefined(f2) && f2 > 0.0f) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            super.onBoundsChange(rect);
            this.mNeedUpdatePathForBorderRadius = true;
        }
    }

    public boolean onResolvedLayoutDirectionChanged(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || i2 == this.mAlpha) {
            return;
        }
        this.mAlpha = i2;
        invalidateSelf();
    }

    public void setBackgroundGradientColor(int i2, int[] iArr, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i2, iArr, fArr) == null) {
            Gradient gradient = new Gradient();
            this.mGradient = gradient;
            gradient.deg = i2;
            gradient.colors = iArr;
            gradient.positions = fArr;
            invalidateSelf();
        }
    }

    public void setBorderColor(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            setBorderRGB(i2, f2);
            setBorderAlpha(i2, f3);
        }
    }

    public void setBorderColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mBorderColor = str;
        }
    }

    public void setBorderStyle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            BorderStyle valueOf = str == null ? null : BorderStyle.valueOf(str.toUpperCase(Locale.US));
            if (this.mBorderStyle != valueOf) {
                this.mBorderStyle = valueOf;
                this.mNeedUpdatePathForBorderRadius = true;
                invalidateSelf();
            }
        }
    }

    public void setBorderWidth(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.mBorderWidth == null) {
                this.mBorderWidth = new TKSpacing();
            }
            if (TKFloatUtil.floatsEqual(this.mBorderWidth.getRaw(i2), f2)) {
                return;
            }
            this.mBorderWidth.set(i2, f2);
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
                this.mNeedUpdatePathForBorderRadius = true;
            }
            invalidateSelf();
        }
    }

    public void setColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mColor = i2;
            this.mGradient = null;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, colorFilter) == null) {
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048599, this, f2) == null) || TKFloatUtil.floatsEqual(this.mBorderRadius, f2)) {
            return;
        }
        this.mBorderRadius = f2;
        this.mNeedUpdatePathForBorderRadius = true;
        invalidateSelf();
    }

    public void setRadius(float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            if (this.mBorderCornerRadii == null) {
                float[] fArr = new float[8];
                this.mBorderCornerRadii = fArr;
                Arrays.fill(fArr, UNDEFINED);
            }
            if (TKFloatUtil.floatsEqual(this.mBorderCornerRadii[i2], f2)) {
                return;
            }
            this.mBorderCornerRadii[i2] = f2;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public boolean setResolvedLayoutDirection(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            if (this.mLayoutDirection != i2) {
                this.mLayoutDirection = i2;
                return onResolvedLayoutDirectionChanged(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setShadow(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            this.mShadow = new Shadow(f2, f3, f4, i2);
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }
}
